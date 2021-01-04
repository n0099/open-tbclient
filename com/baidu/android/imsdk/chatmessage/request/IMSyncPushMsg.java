package com.baidu.android.imsdk.chatmessage.request;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.account.AccountManagerImpl;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.request.Message;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class IMSyncPushMsg extends Message {
    public static final String TAG = IMSyncPushMsg.class.getSimpleName();
    private String mChannelId;
    private Context mContext;
    private String mDeviceId;
    private String mPushAppId;
    private String mUserId;

    public IMSyncPushMsg(Context context, String str, String str2, String str3) {
        this.mContext = context;
        initCommonParameter(context);
        if (TextUtils.isEmpty(str)) {
            str = "0";
            str2 = "0";
            str3 = "0";
        }
        this.mChannelId = str;
        this.mUserId = str2;
        this.mPushAppId = str3;
        this.mDeviceId = Utility.getIMDeviceId(context);
        setNeedReplay(true);
        setType(190);
    }

    public static IMSyncPushMsg newInstance(Context context, Intent intent) {
        if (intent.hasExtra("push_channel_id") && intent.hasExtra(Constants.EXTRA_PUSH_USER_ID) && intent.hasExtra(Constants.EXTRA_PUSH_APP_ID)) {
            return new IMSyncPushMsg(context, intent.getStringExtra("push_channel_id"), intent.getStringExtra(Constants.EXTRA_PUSH_USER_ID), intent.getStringExtra(Constants.EXTRA_PUSH_APP_ID));
        }
        return null;
    }

    public static IMSyncPushMsg parseBody(Context context, String str, String str2) throws Exception {
        JSONObject jSONObject = new JSONObject(str2);
        IMSyncPushMsg iMSyncPushMsg = new IMSyncPushMsg(context, jSONObject.optString("push_channelid"), jSONObject.optString("push_uid"), jSONObject.optString("push_appid"));
        iMSyncPushMsg.setUUID(str);
        return iMSyncPushMsg;
    }

    @Override // com.baidu.android.imsdk.request.Message
    protected void buildBody() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("method", 190);
            jSONObject.put("appid", this.mAppid);
            jSONObject.put("uk", this.mUk);
            jSONObject.put("device_id", this.mDeviceId);
            jSONObject.put("push_channelid", this.mChannelId);
            jSONObject.put("push_uid", this.mUserId);
            jSONObject.put("push_appid", this.mPushAppId);
            jSONObject.put("account_type", AccountManagerImpl.getInstance(this.mContext).getLoginType());
            this.mBody = jSONObject.toString();
        } catch (JSONException e) {
            LogUtils.e(TAG, "Exception ", e);
            new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
        }
    }

    @Override // com.baidu.android.imsdk.request.Message
    public void onMsgSending(Context context) {
    }

    @Override // com.baidu.android.imsdk.request.Message
    public void handleMessageResult(Context context, JSONObject jSONObject, int i, String str) {
        if (i == 0) {
            Utility.setLastSyncPushTime(context, System.currentTimeMillis());
            return;
        }
        setNeedReSend(false);
        super.handleMessageResult(context, jSONObject, i, str);
    }
}
