package com.baidu.android.imsdk.chatmessage.request;

import android.content.Context;
import com.baidu.android.imsdk.account.AccountManagerImpl;
import com.baidu.android.imsdk.chatmessage.IChatRoomExitListener;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.utils.BaseHttpRequest;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.tieba.frs.itemtab.gamecode.GameCodeGetResponseMsg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.security.NoSuchAlgorithmException;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class IMChatRoomExitRequest extends BaseHttpRequest {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "IMChatRoomExitRequest";
    public transient /* synthetic */ FieldHolder $fh;
    public final IChatRoomExitListener mListener;
    public final int mLoginType;
    public final long mRoomId;

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getContentType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "application/json" : (String) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getMethod() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "POST" : (String) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public boolean shouldAbort() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public IMChatRoomExitRequest(Context context, long j, IChatRoomExitListener iChatRoomExitListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Long.valueOf(j), iChatRoomExitListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mContext = context;
        this.mRoomId = j;
        this.mListener = iChatRoomExitListener;
        this.mLoginType = AccountManagerImpl.getInstance(context).getLoginType();
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return BaseHttpRequest.getHostUrl(this.mContext) + "rest/3.0/im/chatroom/exit_chatroom_client";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public byte[] getRequestParameter() throws NoSuchAlgorithmException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("appid", Utility.readAppId(this.mContext));
                jSONObject.put("room_id", this.mRoomId);
                jSONObject.put("app_version", Utility.getAppVersionName(this.mContext));
                jSONObject.put(HttpConstants.DEVICE_TYPE, "android");
                jSONObject.put("cuid", Utility.getDeviceId(this.mContext));
                jSONObject.put("device_id", Utility.getDeviceId(this.mContext));
                jSONObject.put("sdk_version", IMConfigInternal.getInstance().getSDKVersionValue(this.mContext));
                jSONObject.put("timestamp", System.currentTimeMillis() / 1000);
                jSONObject.put("account_type", this.mLoginType);
                if (this.mLoginType == 6) {
                    jSONObject.put("token", AccountManagerImpl.getInstance(this.mContext).getToken());
                }
                jSONObject.put("sign", generateSign(jSONObject));
            } catch (JSONException e) {
                LogUtils.d(TAG, "getRequestParameter error：" + e.toString());
            }
            LogUtils.d(TAG, "IMChatRoomExitRequest getRequestParameter:" + jSONObject);
            return jSONObject.toString().getBytes();
        }
        return (byte[]) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onFailure(int i, byte[] bArr, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048580, this, i, bArr, th) == null) {
            String str = "";
            try {
                JSONObject jSONObject = new JSONObject(new String(bArr));
                i = jSONObject.optInt("error_code");
                str = jSONObject.optString(GameCodeGetResponseMsg.PARAM_ERROR_MSG);
                LogUtils.d(TAG, "errorCode：" + i + ", resultContent: " + jSONObject);
            } catch (Exception e) {
                LogUtils.e(TAG, "onFailure errorCode：" + i + ", exception : " + e.toString());
            }
            IChatRoomExitListener iChatRoomExitListener = this.mListener;
            if (iChatRoomExitListener != null) {
                iChatRoomExitListener.onResult(i, str);
            }
        }
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onSuccess(int i, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048581, this, i, bArr) == null) {
            String str = "";
            try {
                JSONObject jSONObject = new JSONObject(new String(bArr));
                i = jSONObject.optInt("error_code");
                str = jSONObject.optString(GameCodeGetResponseMsg.PARAM_ERROR_MSG);
                LogUtils.d(TAG, "errorCode：" + i + ", resultContent: " + jSONObject);
            } catch (Exception e) {
                LogUtils.e(TAG, "onSuccess errorCode：" + i + ", exception : " + e.toString());
            }
            IChatRoomExitListener iChatRoomExitListener = this.mListener;
            if (iChatRoomExitListener != null) {
                iChatRoomExitListener.onResult(i, str);
            }
        }
    }
}
