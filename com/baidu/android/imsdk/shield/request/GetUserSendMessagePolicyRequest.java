package com.baidu.android.imsdk.shield.request;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.chatmessage.request.RequestContants;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.retrieve.RetrieveReportRequest;
import com.baidu.android.imsdk.shield.ShieldAndTopManager;
import com.baidu.android.imsdk.utils.BaseHttpRequest;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.searchbox.account.contants.AccountConstants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.engine.GlideException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class GetUserSendMessagePolicyRequest extends BaseHttpRequest {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "GetUserSendMessagePolicyRequest";
    public static final String URL_HTTP_ONLINE = "https://pim.baidu.com/";
    public transient /* synthetic */ FieldHolder $fh;
    public long mContacterBdUid;
    public String mKey;
    public int sendScene;
    public long toUser;
    public int toUserType;
    public int userType;

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public int getConnectTimeout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return 1000;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getContentType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "application/json" : (String) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getMethod() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? "POST" : (String) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public int getReadTimeout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return 1000;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public boolean shouldAbort() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public GetUserSendMessagePolicyRequest(Context context, long j, String str, int i, int i2, int i3, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Long.valueOf(j), str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mKey = "";
        this.mContext = context;
        this.mKey = str;
        this.mContacterBdUid = j;
        this.sendScene = i;
        this.userType = i2;
        this.toUserType = i3;
        this.toUser = j2;
    }

    private String getHostUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            int readIntData = Utility.readIntData(this.mContext, Constants.KEY_ENV, 0);
            if (readIntData != 0) {
                if (readIntData != 1) {
                    if (readIntData != 2) {
                        if (readIntData != 3) {
                            return null;
                        }
                        return Constants.URL_HTTP_BOX;
                    }
                    return Constants.URL_HTTP_QA;
                }
                return Constants.URL_HTTP_RD_8111;
            }
            return "https://pim.baidu.com/";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public Map<String, String> getHeaders() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("Cookie", "BDUSS=" + IMConfigInternal.getInstance().getIMConfig(this.mContext).getBduss(this.mContext));
            hashMap.put("Content-Type", "application/json");
            return hashMap;
        }
        return (Map) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return getHostUrl() + "rest/3.0/im/get_send_msg_setting";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public byte[] getRequestParameter() throws NoSuchAlgorithmException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("appid", AccountManager.getAppid(this.mContext));
                jSONObject.put("user_type", this.userType);
                jSONObject.put(Constants.EXTRA_TO_USER_TYPE, this.toUserType);
                jSONObject.put(RequestContants.EXTRA_TO_USER, this.toUser);
                jSONObject.put("app_version", Utility.getAppVersionName(this.mContext));
                jSONObject.put("sdk_version", "" + IMConfigInternal.getInstance().getSDKVersionValue(this.mContext));
                jSONObject.put("cuid", Utility.getDeviceId(this.mContext));
                jSONObject.put("timestamp", System.currentTimeMillis() / 1000);
                jSONObject.put("scene", this.sendScene);
                LogUtils.e(TAG, RetrieveReportRequest.APP_NAME + jSONObject.toString());
                jSONObject.put("sign", generateSign(jSONObject));
            } catch (Exception e) {
                LogUtils.e(TAG, "Exception ", e);
            }
            LogUtils.d(TAG, "getRequestParameter :" + jSONObject.toString());
            return jSONObject.toString().getBytes();
        }
        return (byte[]) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onFailure(int i, byte[] bArr, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048583, this, i, bArr, th) == null) {
            LogUtils.e(TAG, "errorCode:" + i + GlideException.IndentedAppendable.INDENT + new String(bArr));
            ShieldAndTopManager.getInstance(this.mContext).onSendMsgPolicyResult(i, "", true, this.mContacterBdUid, this.mKey, 0);
        }
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onSuccess(int i, byte[] bArr) {
        int i2;
        String str;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, bArr) == null) {
            LogUtils.d(TAG, "errorCode: " + i + " resultContent: " + new String(bArr));
            int i3 = 0;
            String str2 = "";
            boolean z2 = true;
            if (i != 200) {
                str = "";
                z = true;
                i2 = 0;
            } else {
                try {
                    JSONObject jSONObject = new JSONObject(new String(bArr));
                    JSONArray optJSONArray = jSONObject.optJSONArray(AccountConstants.LOGOUT_TYPE_NATIVE_SRC_SETTINGS);
                    int optInt = jSONObject.optInt("follow_relation");
                    if (optJSONArray != null) {
                        try {
                            if (optJSONArray.length() > 0) {
                                JSONObject optJSONObject = optJSONArray.optJSONObject(0);
                                boolean optBoolean = optJSONObject.optBoolean("could_send");
                                try {
                                    if (optJSONObject.optInt("scene") >= 0) {
                                        str2 = optJSONObject.optString("tips");
                                    }
                                    z2 = optBoolean;
                                } catch (JSONException e) {
                                    e = e;
                                    z2 = optBoolean;
                                    i3 = optInt;
                                    LogUtils.e(TAG, "AddSubscribeRequest JSONException", e);
                                    i2 = i3;
                                    str = "";
                                    z = z2;
                                    ShieldAndTopManager.getInstance(this.mContext).onSendMsgPolicyResult(i, str, z, this.mContacterBdUid, this.mKey, i2);
                                }
                            }
                        } catch (JSONException e2) {
                            e = e2;
                        }
                    }
                    str = str2;
                    z = z2;
                    i2 = optInt;
                } catch (JSONException e3) {
                    e = e3;
                }
            }
            ShieldAndTopManager.getInstance(this.mContext).onSendMsgPolicyResult(i, str, z, this.mContacterBdUid, this.mKey, i2);
        }
    }
}
