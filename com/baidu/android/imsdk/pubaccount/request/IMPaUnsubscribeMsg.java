package com.baidu.android.imsdk.pubaccount.request;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.pubaccount.PaManagerImpl;
import com.baidu.android.imsdk.pubaccount.db.PaInfoDBManager;
import com.baidu.android.imsdk.request.Message;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class IMPaUnsubscribeMsg extends Message {
    public Context mContext;
    public long mPaId;

    public IMPaUnsubscribeMsg(Context context, long j) {
        this.mContext = context;
        initCommonParameter(context);
        this.mPaId = j;
        setNeedReplay(true);
        setType(101);
    }

    public static IMPaUnsubscribeMsg newInstance(Context context, Intent intent) {
        if (intent.hasExtra(Constants.EXTRA_PA_ID)) {
            return new IMPaUnsubscribeMsg(context, intent.getLongExtra(Constants.EXTRA_PA_ID, -1L));
        }
        return null;
    }

    @Override // com.baidu.android.imsdk.request.Message
    public void buildBody() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("method", 101);
            jSONObject.put("appid", this.mAppid);
            jSONObject.put("uk", this.mUk);
            jSONObject.put("pa_uid", this.mPaId);
            jSONObject.put("origin_id", Utility.getTriggerId(this.mContext));
            this.mBody = jSONObject.toString();
        } catch (JSONException e2) {
            LogUtils.e(LogUtils.TAG, "buildBody:", e2);
            new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e2)).build();
        }
    }

    public long getPaId() {
        return this.mPaId;
    }

    @Override // com.baidu.android.imsdk.request.Message
    public void handleMessageResult(Context context, JSONObject jSONObject, int i, String str) {
        if (i == 0) {
            try {
                PaInfoDBManager.getInstance(context).unSubscribePa(this.mPaId);
            } catch (Exception e2) {
                LogUtils.e(LogUtils.TAG, "handleMessageResult:", e2);
                new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e2)).build();
            }
        }
        super.handleMessageResult(context, jSONObject, i, str);
        PaManagerImpl.getInstance(context).onUnsubscribePaResult(getListenerKey(), i, str, this.mPaId);
    }
}
