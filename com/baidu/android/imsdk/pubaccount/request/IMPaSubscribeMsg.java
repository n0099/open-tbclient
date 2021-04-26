package com.baidu.android.imsdk.pubaccount.request;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.pubaccount.PaInfo;
import com.baidu.android.imsdk.pubaccount.PaManagerImpl;
import com.baidu.android.imsdk.pubaccount.db.PaInfoDBManager;
import com.baidu.android.imsdk.request.Message;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class IMPaSubscribeMsg extends Message {
    public Context mContext;
    public long mPaId;
    public PaInfo mPaInfo;

    public IMPaSubscribeMsg(Context context, long j, PaInfo paInfo) {
        this.mContext = context;
        initCommonParameter(context);
        this.mPaId = j;
        this.mPaInfo = paInfo;
        setNeedReplay(true);
        setType(100);
    }

    public static IMPaSubscribeMsg newInstance(Context context, Intent intent) {
        if (intent.hasExtra(Constants.EXTRA_PA_ID)) {
            return new IMPaSubscribeMsg(context, intent.getLongExtra(Constants.EXTRA_PA_ID, -1L), (PaInfo) intent.getParcelableExtra(Constants.EXTRA_PA_INFO));
        }
        return null;
    }

    @Override // com.baidu.android.imsdk.request.Message
    public void buildBody() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("method", 100);
            jSONObject.put("appid", this.mAppid);
            jSONObject.put("uk", this.mUk);
            jSONObject.put("origin_id", Utility.getTriggerId(this.mContext));
            jSONObject.put("pa_uid", this.mPaId);
            long triggerId = Utility.getTriggerId(this.mContext);
            if (triggerId > 0) {
                jSONObject.put("origin_id", triggerId);
            }
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
    public void handleMessageResult(Context context, JSONObject jSONObject, int i2, String str) {
        if (i2 == 0) {
            try {
                PaInfoDBManager.getInstance(context).subscribePa(this.mPaInfo);
            } catch (Exception e2) {
                LogUtils.e(LogUtils.TAG, "handleMessageResult:", e2);
                new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e2)).build();
            }
        }
        super.handleMessageResult(context, jSONObject, i2, str);
        PaManagerImpl.getInstance(context).onSubscribePaResult(getListenerKey(), i2, str, this.mPaId);
    }
}
