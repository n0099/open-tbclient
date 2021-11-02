package com.baidu.android.imsdk.chatmessage.request;

import android.content.Context;
import android.util.Log;
import android.util.Pair;
import com.baidu.android.imsdk.chatmessage.BindStateManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.BaseHttpRequest;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.tieba.frs.itemtab.gamecode.GameCodeGetResponseMsg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class IMUnBindPushRequest extends BaseHttpRequest {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Long mAppid;
    public String mBduss;
    public String mDeviceId;
    public Long mUk;

    public IMUnBindPushRequest(Context context, long j, String str, String str2, Long l) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Long.valueOf(j), str, str2, l};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mContext = context;
        this.mAppid = Long.valueOf(j);
        this.mBduss = str;
        this.mDeviceId = str2;
        this.mUk = l;
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getContentType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "application/x-www-form-urlencoded" : (String) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public Map<String, String> getHeaders() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("Cookie", "BDUSS=" + this.mBduss);
            return hashMap;
        }
        return (Map) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return BaseHttpRequest.getHostUrl(this.mContext) + "rest/2.0/im/bind_push?method=unbind";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getMethod() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "POST" : (String) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public byte[] getRequestParameter() throws NoSuchAlgorithmException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            return ("method=unbind&appid=" + this.mAppid + "&device_id=" + this.mDeviceId + "&uk=" + this.mUk + "&timestamp=" + currentTimeMillis + "&sdk_version=" + IMConfigInternal.getInstance().getSDKVersionValue(this.mContext) + "&sign=" + getMd5("" + currentTimeMillis + this.mBduss + this.mAppid)).getBytes();
        }
        return (byte[]) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onFailure(int i2, byte[] bArr, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048581, this, i2, bArr, th) == null) {
            Pair<Integer, String> transErrorCode = transErrorCode(i2, bArr, th);
            LogUtils.d("IMUnBindPushRequest", "  errorCode: " + transErrorCode.first);
        }
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onSuccess(int i2, byte[] bArr) {
        String str;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048582, this, i2, bArr) == null) {
            String str2 = new String(bArr);
            LogUtils.d("IMUnBindPushRequest", str2);
            long j = 0;
            try {
                JSONObject jSONObject = new JSONObject(str2);
                j = jSONObject.optLong(BaseJsonData.TAG_REQUESTID);
                i3 = jSONObject.optInt("error_code", 0);
                str = i3 != 0 ? jSONObject.optString(GameCodeGetResponseMsg.PARAM_ERROR_MSG) : Constants.ERROR_MSG_SUCCESS;
                if (i3 == 0) {
                    BindStateManager.clearUnBindInfo(this.mContext);
                }
            } catch (JSONException e2) {
                LogUtils.e("IMUnBindPushRequest", e2.getMessage(), e2);
                new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e2)).build();
                str = Constants.ERROR_MSG_JSON_PARSE_EXCEPTION;
                i3 = 1010;
            }
            LogUtils.d("IMUnBindPushRequest", "requestid : " + j + " , resultCode: " + i3 + " , resultMsg : " + str);
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
}
