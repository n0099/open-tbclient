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
/* loaded from: classes18.dex */
public class IMPaUnsubscribeMsg extends Message {
    private Context mContext;
    private long mPaId;

    public long getPaId() {
        return this.mPaId;
    }

    public IMPaUnsubscribeMsg(Context context, long j) {
        this.mContext = context;
        initCommonParameter(context);
        this.mPaId = j;
        setNeedReplay(true);
        setType(101);
    }

    @Override // com.baidu.android.imsdk.request.Message
    protected void buildBody() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("method", 101);
            jSONObject.put("appid", this.mAppid);
            jSONObject.put("uk", this.mUk);
            jSONObject.put("pa_uid", this.mPaId);
            jSONObject.put("origin_id", Utility.getTriggerId(this.mContext));
            this.mBody = jSONObject.toString();
        } catch (JSONException e) {
            LogUtils.e(LogUtils.TAG, "buildBody:", e);
            new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
        }
    }

    public static IMPaUnsubscribeMsg newInstance(Context context, Intent intent) {
        if (intent.hasExtra(Constants.EXTRA_PA_ID)) {
            return new IMPaUnsubscribeMsg(context, intent.getLongExtra(Constants.EXTRA_PA_ID, -1L));
        }
        return null;
    }

    @Override // com.baidu.android.imsdk.request.Message
    public void handleMessageResult(Context context, JSONObject jSONObject, int i, String str) {
        if (i == 0) {
            try {
                PaInfoDBManager.getInstance(context).unSubscribePa(this.mPaId);
            } catch (Exception e) {
                LogUtils.e(LogUtils.TAG, "handleMessageResult:", e);
                new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
            }
        }
        PaManagerImpl.getInstance(context).onUnsubscribePaResult(getListenerKey(), i, str, this.mPaId);
    }
}
