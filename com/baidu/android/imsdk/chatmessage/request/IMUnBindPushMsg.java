package com.baidu.android.imsdk.chatmessage.request;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.baidu.android.imsdk.chatmessage.BindStateManager;
import com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.request.Message;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class IMUnBindPushMsg extends Message {
    public static final String TAG = "IMUnBindPushMsg";
    public Context mContext;
    public String mDeviceId;

    public IMUnBindPushMsg(Context context) {
        this.mContext = context;
        initCommonParameter(context);
        this.mDeviceId = Utility.getIMDeviceId(context);
        setNeedReplay(true);
        setType(92);
    }

    public static IMUnBindPushMsg newInstance(Context context, Intent intent) {
        return new IMUnBindPushMsg(context);
    }

    @Override // com.baidu.android.imsdk.request.Message
    public void buildBody() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("method", 92);
            jSONObject.put("appid", this.mAppid);
            jSONObject.put("uk", this.mUk);
            jSONObject.put(Constants.KEY_DEVICE_ID, this.mDeviceId);
            this.mBody = jSONObject.toString();
        } catch (JSONException e2) {
            LogUtils.e(LogUtils.TAG, "buildBody", e2);
            new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e2)).build();
        }
    }

    @Override // com.baidu.android.imsdk.request.Message
    public void handleMessageResult(Context context, JSONObject jSONObject, int i2, String str) {
        if (i2 == 0) {
            Utility.updateBindPushCUIDStatus(this.mContext, 1);
            BindStateManager.clearUnBindInfo(context);
        }
        super.handleMessageResult(context, jSONObject, i2, str);
        ChatMsgManagerImpl.getInstance(context).onUnRegisterNotifyResult(getListenerKey(), i2, str);
    }
}
