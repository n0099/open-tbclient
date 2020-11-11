package com.baidu.android.imsdk.chatmessage.request;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.account.LoginManager;
import com.baidu.android.imsdk.chatmessage.BindStateManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.request.Message;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes18.dex */
public class IMBindPushMsg extends Message {
    private String mChannelId;
    private boolean mChannelIdIsEmpty;
    private Context mContext;
    private String mDeviceId;
    private String mPushAppId;
    private int mReSendCount = 0;
    private String mUserId;

    public IMBindPushMsg(Context context, String str, String str2, String str3) {
        this.mChannelIdIsEmpty = false;
        this.mContext = context;
        initCommonParameter(context);
        if (TextUtils.isEmpty(str)) {
            str = "0";
            str2 = "0";
            str3 = "0";
            this.mChannelIdIsEmpty = true;
        }
        this.mChannelId = str;
        this.mUserId = str2;
        this.mPushAppId = str3;
        this.mDeviceId = Utility.getIMDeviceId(context);
        setNeedReplay(true);
        setType(90);
    }

    public static IMBindPushMsg newInstance(Context context, Intent intent) {
        if (intent.hasExtra("push_channel_id") && intent.hasExtra(Constants.EXTRA_PUSH_USER_ID) && intent.hasExtra(Constants.EXTRA_PUSH_APP_ID)) {
            return new IMBindPushMsg(context, intent.getStringExtra("push_channel_id"), intent.getStringExtra(Constants.EXTRA_PUSH_USER_ID), intent.getStringExtra(Constants.EXTRA_PUSH_APP_ID));
        }
        return null;
    }

    public static IMBindPushMsg parseBody(Context context, String str, String str2) throws Exception {
        JSONObject jSONObject = new JSONObject(str2);
        IMBindPushMsg iMBindPushMsg = new IMBindPushMsg(context, jSONObject.optString("push_channelid"), jSONObject.optString("push_uid"), jSONObject.optString("push_appid"));
        iMBindPushMsg.setUUID(str);
        return iMBindPushMsg;
    }

    @Override // com.baidu.android.imsdk.request.Message
    protected void buildBody() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("method", 90);
            jSONObject.put("appid", this.mAppid);
            jSONObject.put("uk", this.mUk);
            jSONObject.put("device_id", this.mDeviceId);
            jSONObject.put("push_channelid", this.mChannelId);
            jSONObject.put("push_uid", this.mUserId);
            jSONObject.put("push_appid", this.mPushAppId);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("rpc_retry_time", this.mReSendCount);
            jSONObject.put("rpc", jSONObject2.toString());
            this.mBody = jSONObject.toString();
        } catch (JSONException e) {
            LogUtils.e(getClass().getSimpleName(), "Exception ", e);
            new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
        }
    }

    @Override // com.baidu.android.imsdk.request.Message
    public void onMsgSending(Context context) {
        Utility.updateBindPushCUIDStatus(this.mContext, 2);
    }

    @Override // com.baidu.android.imsdk.request.Message
    public void handleMessageResult(Context context, JSONObject jSONObject, int i, String str) {
        LogUtils.d("IMBindPushMsg", "bind > handleMessageResult errcode = " + i);
        if (i != 0) {
            if (i == 1004 || i == 1001 || i == 4001) {
                setNeedReSend(false);
                LoginManager.getInstance(context).triggleLogoutListener(i, str);
            } else if (this.mReSendCount >= 3) {
                LogUtils.e(LogUtils.TAG, "try to bind push CUID failed 3 times. Cancel resend...errorCode=" + i);
                setNeedReSend(false);
            } else {
                this.mReSendCount++;
                setNeedReSend(true);
            }
        } else {
            setNeedReSend(false);
        }
        Utility.updateBindPushCUIDStatus(this.mContext, 1);
        BindStateManager.onRegisterNotifyResult(context, getListenerKey(), i, str, this.mChannelIdIsEmpty);
    }
}
