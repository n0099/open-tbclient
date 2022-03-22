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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class IMBindPushMsg extends Message {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String mChannelId;
    public boolean mChannelIdIsEmpty;
    public Context mContext;
    public String mDeviceId;
    public String mPushAppId;
    public int mReSendCount;
    public String mUserId;

    public IMBindPushMsg(Context context, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, str2, str3};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mReSendCount = 0;
        this.mChannelIdIsEmpty = false;
        this.mContext = context;
        initCommonParameter(context);
        if (TextUtils.isEmpty(str)) {
            this.mChannelIdIsEmpty = true;
            str = "0";
            str2 = str;
            str3 = str2;
        }
        this.mChannelId = str;
        this.mUserId = str2;
        this.mPushAppId = str3;
        this.mDeviceId = Utility.getIMDeviceId(context);
        setNeedReplay(true);
        setType(90);
    }

    public static IMBindPushMsg newInstance(Context context, Intent intent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, intent)) == null) {
            if (intent.hasExtra(Constants.EXTRA_PUSH_CHANNEL_ID) && intent.hasExtra(Constants.EXTRA_PUSH_USER_ID) && intent.hasExtra(Constants.EXTRA_PUSH_APP_ID)) {
                return new IMBindPushMsg(context, intent.getStringExtra(Constants.EXTRA_PUSH_CHANNEL_ID), intent.getStringExtra(Constants.EXTRA_PUSH_USER_ID), intent.getStringExtra(Constants.EXTRA_PUSH_APP_ID));
            }
            return null;
        }
        return (IMBindPushMsg) invokeLL.objValue;
    }

    public static IMBindPushMsg parseBody(Context context, String str, String str2) throws Exception {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, context, str, str2)) == null) {
            JSONObject jSONObject = new JSONObject(str2);
            IMBindPushMsg iMBindPushMsg = new IMBindPushMsg(context, jSONObject.optString("push_channelid"), jSONObject.optString("push_uid"), jSONObject.optString("push_appid"));
            iMBindPushMsg.setUUID(str);
            return iMBindPushMsg;
        }
        return (IMBindPushMsg) invokeLLL.objValue;
    }

    @Override // com.baidu.android.imsdk.request.Message
    public void buildBody() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
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
            } catch (JSONException e2) {
                LogUtils.e(IMBindPushMsg.class.getSimpleName(), "Exception ", e2);
                new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e2)).build();
            }
        }
    }

    @Override // com.baidu.android.imsdk.request.Message
    public void handleMessageResult(Context context, JSONObject jSONObject, int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, jSONObject, i, str) == null) {
            LogUtils.d("IMBindPushMsg", "bind > handleMessageResult errcode = " + i);
            if (i == 0) {
                setNeedReSend(false);
            } else if (i != 1004 && i != 1001) {
                int i2 = this.mReSendCount;
                if (i2 >= 3) {
                    String str2 = LogUtils.TAG;
                    LogUtils.e(str2, "try to bind push CUID failed 3 times. Cancel resend...errorCode=" + i);
                    setNeedReSend(false);
                } else {
                    this.mReSendCount = i2 + 1;
                    setNeedReSend(true);
                }
            } else {
                setNeedReSend(false);
                LoginManager.getInstance(context).triggleLogoutListener(i, str);
            }
            super.handleMessageResult(context, jSONObject, i, str);
            Utility.updateBindPushCUIDStatus(this.mContext, 1);
            BindStateManager.onRegisterNotifyResult(context, getListenerKey(), i, str, this.mChannelIdIsEmpty);
        }
    }

    @Override // com.baidu.android.imsdk.request.Message
    public void onMsgSending(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) {
            Utility.updateBindPushCUIDStatus(this.mContext, 2);
        }
    }
}
