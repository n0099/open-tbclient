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
/* loaded from: classes4.dex */
public class IMPaSubscribeMsg extends Message {
    private Context mContext;
    private long mPaId;
    private PaInfo mPaInfo;

    public long getPaId() {
        return this.mPaId;
    }

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
    protected void buildBody() {
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
        } catch (JSONException e) {
            LogUtils.e(LogUtils.TAG, "buildBody:", e);
            new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
        }
    }

    @Override // com.baidu.android.imsdk.request.Message
    public void handleMessageResult(Context context, JSONObject jSONObject, int i, String str) {
        if (i == 0) {
            try {
                PaInfoDBManager.getInstance(context).subscribePa(this.mPaInfo);
            } catch (Exception e) {
                LogUtils.e(LogUtils.TAG, "handleMessageResult:", e);
                new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
            }
        }
        super.handleMessageResult(context, jSONObject, i, str);
        PaManagerImpl.getInstance(context).onSubscribePaResult(getListenerKey(), i, str, this.mPaId);
    }
}
