package com.baidu.android.imsdk.shield.request;

import android.content.Context;
import android.util.Pair;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.shield.ShieldAndTopManager;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.searchbox.live.interfaces.DI;
import com.baidu.tieba.frs.itemtab.gamecode.GameCodeGetResponseMsg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class IMForbidRequest extends IMSettingBaseHttpRequest {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "IMForbidRequest";
    public transient /* synthetic */ FieldHolder $fh;
    public String key;
    public long touk;
    public int type;
    public long uid;

    public IMForbidRequest(Context context, long j, long j2, int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i), str};
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
        this.uid = j2;
        this.type = i;
        this.key = str;
        this.touk = j;
    }

    private int getReportType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            if (AccountManager.getMediaRole(this.mContext)) {
                int i = this.type;
                if (i == 0) {
                    return 3;
                }
                if (i == 7) {
                    return 4;
                }
            } else {
                int i2 = this.type;
                if (i2 == 0) {
                    return 0;
                }
                if (i2 == 7) {
                    return 1;
                }
                if (i2 == 3) {
                    return 2;
                }
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getContentType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "application/json" : (String) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.shield.request.IMSettingBaseHttpRequest
    public String getHostUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
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
                return "http://rd-im-server.bcc-szth.baidu.com:8111/";
            }
            return "https://pim.baidu.com/";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.shield.request.IMSettingBaseHttpRequest
    public String getHostUrlParam() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "chat_report" : (String) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public byte[] getRequestParameter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            try {
                long appid = AccountManager.getAppid(this.mContext);
                long uk = AccountManager.getUK(this.mContext);
                long currentTimeMillis = System.currentTimeMillis() / 1000;
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("appid", appid);
                jSONObject.put("uk_from", uk);
                jSONObject.put("uk_to", this.touk);
                jSONObject.put("app_version", Utility.getAppVersionName(this.mContext));
                jSONObject.put("sdk_version", IMConfigInternal.getInstance().getSDKVersionValue(this.mContext));
                jSONObject.put("cuid", Utility.getDeviceId(this.mContext));
                jSONObject.put(HttpConstants.DEVICE_TYPE, 2);
                jSONObject.put("timestamp", currentTimeMillis);
                int i = 1;
                jSONObject.put("reason", 1);
                int reportType = getReportType();
                jSONObject.put("report_type", reportType);
                if (reportType == 0 || reportType == 3) {
                    jSONObject.put("bduk_to", Utility.transBDUID(this.uid + ""));
                }
                jSONObject.put("sign", getMd5("" + currentTimeMillis + uk + appid));
                if (!AccountManager.isCuidLogin(this.mContext)) {
                    i = 0;
                }
                jSONObject.put("account_type", i);
                LogUtils.d(TAG, "IMForbidRequest msg :" + jSONObject.toString());
                return jSONObject.toString().getBytes();
            } catch (Exception unused) {
                return null;
            }
        }
        return (byte[]) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onFailure(int i, byte[] bArr, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048580, this, i, bArr, th) == null) {
            Pair<Integer, String> transErrorCode = transErrorCode(i, bArr, th);
            ShieldAndTopManager.getInstance(this.mContext).onForbidResult(((Integer) transErrorCode.first).intValue(), (String) transErrorCode.second, true, "", this.key);
        }
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onSuccess(int i, byte[] bArr) {
        String str;
        boolean z;
        String str2;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048581, this, i, bArr) == null) {
            String str3 = new String(bArr);
            LogUtils.e(TAG, "IMForbidRequest onSuccess :" + str3);
            boolean z2 = true;
            try {
                JSONObject jSONObject = new JSONObject(str3);
                int optInt = jSONObject.optInt("error_code");
                String optString = jSONObject.optString(GameCodeGetResponseMsg.PARAM_ERROR_MSG);
                z2 = jSONObject.optBoolean("display_toast", false);
                str = z2 ? jSONObject.optString(DI.TOAST_NAME, "") : "";
                z = z2;
                i2 = optInt;
                str2 = optString;
            } catch (JSONException e) {
                LogUtils.e(TAG, "JSONException", e);
                str = "";
                z = z2;
                str2 = Constants.ERROR_MSG_JSON_PARSE_EXCEPTION;
                i2 = 1010;
            }
            ShieldAndTopManager.getInstance(this.mContext).onForbidResult(i2, str2, z, str, this.key);
        }
    }
}
