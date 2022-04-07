package com.baidu.android.imsdk.account.request;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.account.IGetMsgSettingSwitchListener;
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
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class IMGetMsgSettingSwitchRequest extends BaseHttpRequest {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "IMGetMsgSettingSwitchRequest";
    public transient /* synthetic */ FieldHolder $fh;
    public IGetMsgSettingSwitchListener mListener;

    public IMGetMsgSettingSwitchRequest(Context context, IGetMsgSettingSwitchListener iGetMsgSettingSwitchListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, iGetMsgSettingSwitchListener};
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
        this.mListener = iGetMsgSettingSwitchListener;
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getContentType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "application/json" : (String) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public Map<String, String> getHeaders() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new HashMap() : (Map) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getHost() {
        InterceptResult invokeV;
        String replace;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            int readIntData = Utility.readIntData(this.mContext, Constants.KEY_ENV, 0);
            if (readIntData != 0) {
                replace = readIntData != 1 ? readIntData != 2 ? readIntData != 3 ? null : Constants.URL_HTTP_BOX : Constants.URL_HTTP_QA : "http://rd-im-server.bcc-szth.baidu.com:8080/";
            } else {
                replace = Utility.isPeakTime() ? "https://pim.baidu.com/".replace("https://", "http://") : "https://pim.baidu.com/";
            }
            if (TextUtils.isEmpty(replace)) {
                return replace;
            }
            return replace + "rest/3.0/im/read_user_setting";
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
    public byte[] getRequestParameter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            try {
                long appid = AccountManager.getAppid(this.mContext);
                long uk = AccountManager.getUK(this.mContext);
                long currentTimeMillis = System.currentTimeMillis() / 1000;
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("appid", appid);
                jSONObject.put("uk", uk);
                jSONObject.put("app_version", Utility.getAppVersionName(this.mContext));
                jSONObject.put("sdk_version", IMConfigInternal.getInstance().getSDKVersionValue(this.mContext));
                jSONObject.put("cuid", Utility.getDeviceId(this.mContext));
                jSONObject.put(HttpConstants.DEVICE_TYPE, 2);
                jSONObject.put("timestamp", currentTimeMillis);
                jSONObject.put("sign", getMd5("" + currentTimeMillis + uk + appid));
                jSONObject.put("account_type", AccountManager.isCuidLogin(this.mContext) ? 1 : 0);
                LogUtils.d(TAG, "IMGetMsgSettingSwitchRequest getRequestParameter :" + jSONObject.toString());
                return jSONObject.toString().getBytes();
            } catch (Exception unused) {
                return null;
            }
        }
        return (byte[]) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onFailure(int i, byte[] bArr, Throwable th) {
        int i2;
        IGetMsgSettingSwitchListener iGetMsgSettingSwitchListener;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048581, this, i, bArr, th) == null) {
            Pair<Integer, String> transErrorCode = transErrorCode(i, bArr, th);
            String str = new String(bArr);
            LogUtils.e(TAG, "IMGetMsgSettingSwitchRequest onFailure :" + str);
            int i3 = 0;
            try {
                JSONObject jSONObject = new JSONObject(str);
                i2 = jSONObject.optInt("push_privacy", 0);
                try {
                    i3 = jSONObject.optInt("block_stranger", 0);
                } catch (JSONException e) {
                    e = e;
                    LogUtils.e(TAG, "onFailure JSONException", e);
                    iGetMsgSettingSwitchListener = this.mListener;
                    if (iGetMsgSettingSwitchListener == null) {
                    }
                }
            } catch (JSONException e2) {
                e = e2;
                i2 = 0;
            }
            iGetMsgSettingSwitchListener = this.mListener;
            if (iGetMsgSettingSwitchListener == null) {
                iGetMsgSettingSwitchListener.onGetMsgSettingSwitch(((Integer) transErrorCode.first).intValue(), (String) transErrorCode.second, i3, i2);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onSuccess(int i, byte[] bArr) {
        int i2;
        int i3;
        String str;
        IGetMsgSettingSwitchListener iGetMsgSettingSwitchListener;
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048582, this, i, bArr) == null) {
            String str2 = new String(bArr);
            LogUtils.e(TAG, "IMGetMsgSettingSwitchRequest onSuccess :" + str2);
            int i4 = 0;
            try {
                jSONObject = new JSONObject(str2);
                i3 = jSONObject.getInt("error_code");
                str = jSONObject.optString(GameCodeGetResponseMsg.PARAM_ERROR_MSG, "");
                i2 = jSONObject.optInt("push_privacy", 0);
            } catch (JSONException e) {
                e = e;
                i2 = 0;
            }
            try {
                i4 = jSONObject.optInt("block_stranger", 0);
            } catch (JSONException e2) {
                e = e2;
                LogUtils.e(TAG, "JSONException", e);
                i3 = 1010;
                str = Constants.ERROR_MSG_JSON_PARSE_EXCEPTION;
                iGetMsgSettingSwitchListener = this.mListener;
                if (iGetMsgSettingSwitchListener == null) {
                }
            }
            iGetMsgSettingSwitchListener = this.mListener;
            if (iGetMsgSettingSwitchListener == null) {
                iGetMsgSettingSwitchListener.onGetMsgSettingSwitch(i3, str, i4, i2);
            }
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
