package com.baidu.android.imsdk.account.request;

import android.content.Context;
import com.baidu.android.imsdk.account.AccountManagerImpl;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.ubc.MessageUbc;
import com.baidu.android.imsdk.utils.BaseHttpRequest;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.tieba.frs.itemtab.gamecode.GameCodeGetResponseMsg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.security.NoSuchAlgorithmException;
import org.apache.http.HttpVersion;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class IMLogoutRequest extends IMLogoutBaseRequest {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "IMLogoutRequest";
    public transient /* synthetic */ FieldHolder $fh;
    public final JSONArray mEventList;
    public final long mLoginId;
    public final int mLoginType;

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

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onFailure(int i, byte[] bArr, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048580, this, i, bArr, th) == null) {
        }
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onSuccess(int i, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048582, this, i, bArr) == null) {
        }
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public boolean shouldAbort() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public IMLogoutRequest(Context context, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, jSONArray};
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
        this.mEventList = jSONArray;
        this.mLoginType = AccountManagerImpl.getInstance(context).getLoginType();
        this.mLoginId = AccountManagerImpl.getInstance(this.mContext).getLoginId();
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (BaseHttpRequest.getHostUrl(this.mContext) == null) {
                return "";
            }
            return BaseHttpRequest.getHostUrl(this.mContext) + "rest/3.0/im/logout";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public byte[] getRequestParameter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("appid", Utility.readAppId(this.mContext));
                jSONObject.put("app_version", Utility.getAppVersionName(this.mContext));
                jSONObject.put("sdk_version", IMConfigInternal.getInstance().getSDKVersionValue(this.mContext));
                jSONObject.put("device_id", Utility.getDeviceId(this.mContext));
                jSONObject.put("timestamp", System.currentTimeMillis() / 1000);
                jSONObject.put("account_type", this.mLoginType);
                if (this.mLoginType == 6) {
                    jSONObject.put("token", AccountManagerImpl.getInstance(this.mContext).getToken());
                }
                jSONObject.put(Constants.KEY_TRIGGER_ID, Utility.getTriggerId(this.mContext));
                jSONObject.put(Constants.EXTRA_LOGIN_ID, this.mLoginId);
                jSONObject.put("sign", generateSign(jSONObject));
            } catch (NoSuchAlgorithmException | JSONException e) {
                LogUtils.d(TAG, "getRequestParameter error：" + e.toString());
            }
            LogUtils.d(TAG, " getRequestParameter:" + jSONObject);
            return jSONObject.toString().getBytes();
        }
        return (byte[]) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.LogoutResponseHandler
    public void onResult(int i, byte[] bArr, JSONArray jSONArray) {
        JSONArray optJSONArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048581, this, i, bArr, jSONArray) == null) {
            String str = new String(bArr);
            LogUtils.e(TAG, "onSuccess :" + str + ", errorCode :" + i);
            String str2 = "";
            if (i == 200) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    int optInt = jSONObject.optInt("error_code");
                    str2 = jSONObject.optString(GameCodeGetResponseMsg.PARAM_ERROR_MSG);
                    if (jSONObject.has("event_list") && (optJSONArray = jSONObject.optJSONArray("event_list")) != null) {
                        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                            this.mEventList.put(optJSONArray.get(i2));
                        }
                    }
                    i = optInt;
                } catch (JSONException unused) {
                    i = 1010;
                }
            }
            if (jSONArray != null) {
                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                    try {
                        this.mEventList.put(jSONArray.get(i3));
                    } catch (Exception e) {
                        LogUtils.e(TAG, "logout Net Exception :", e);
                    }
                }
            }
            Utility.addEventListMs(this.mEventList, "CIMResEnd");
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("event_list", this.mEventList);
                LogUtils.d(TAG, "logout onSuccess eventList :" + jSONObject2);
            } catch (Exception e2) {
                LogUtils.e(TAG, "logout onSuccess Exception :", e2);
            }
            if (!AccountManagerImpl.getInstance(this.mContext).isLogoutUpload()) {
                return;
            }
            MessageUbc.DebugInfo debugInfo = new MessageUbc.DebugInfo();
            debugInfo.methodId = 52L;
            debugInfo.eventList = jSONObject2.toString();
            debugInfo.loginId = this.mLoginId;
            debugInfo.protocolType = HttpVersion.HTTP;
            MessageUbc.uploadUbc(this.mContext, i, str2, debugInfo);
        }
    }
}
