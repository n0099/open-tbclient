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
/* loaded from: classes9.dex */
public class IMPaAcceptPushMsg extends Message {
    private boolean mAcceptPush;
    private Context mContext;
    private long mPaId;

    public IMPaAcceptPushMsg(Context context, long j, boolean z) {
        this.mContext = null;
        initCommonParameter(context);
        this.mContext = context;
        this.mPaId = j;
        this.mAcceptPush = z;
        setNeedReplay(true);
        setType(105);
    }

    public long getPaId() {
        return this.mPaId;
    }

    public static IMPaAcceptPushMsg newInstance(Context context, Intent intent) {
        if (intent.hasExtra(Constants.EXTRA_PA_ID) && intent.hasExtra(Constants.EXTRA_PA_ACCEPT_PUSH)) {
            return new IMPaAcceptPushMsg(context, intent.getLongExtra(Constants.EXTRA_PA_ID, -1L), intent.getBooleanExtra(Constants.EXTRA_PA_ACCEPT_PUSH, true));
        }
        return null;
    }

    @Override // com.baidu.android.imsdk.request.Message
    protected void buildBody() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("method", 105);
            jSONObject.put("appid", this.mAppid);
            jSONObject.put("uk", this.mUk);
            jSONObject.put("pa_uid", this.mPaId);
            jSONObject.put("origin_id", Utility.getTriggerId(this.mContext));
            jSONObject.put("is_accept_msg", this.mAcceptPush);
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
                PaInfoDBManager.getInstance(context).acceptPaPush(this.mPaId, this.mAcceptPush);
            } catch (Exception e) {
                LogUtils.e(LogUtils.TAG, "handleMessageResult:", e);
                new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
            }
        }
        super.handleMessageResult(context, jSONObject, i, str);
        PaManagerImpl.getInstance(context).onAcceptPaPushResult(getListenerKey(), i, str, this.mPaId);
    }
}
