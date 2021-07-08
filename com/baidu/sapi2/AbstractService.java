package com.baidu.sapi2;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.httpwrap.HttpHashMapWrap;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiDeviceInfo;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.utils.ZeusInitConfigUtils;
import com.meizu.cloud.pushsdk.notification.model.AppIconSetting;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public abstract class AbstractService implements NoProguard {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String API_V3 = "3";
    public transient /* synthetic */ FieldHolder $fh;
    public SapiConfiguration configuration;
    public String versionName;

    public AbstractService(SapiConfiguration sapiConfiguration, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {sapiConfiguration, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.configuration = sapiConfiguration;
        this.versionName = str;
    }

    public HttpHashMapWrap buildSapiParams(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
            String deviceInfo = SapiDeviceInfo.getDeviceInfo(str);
            if (!TextUtils.isEmpty(deviceInfo)) {
                httpHashMapWrap.put(AppIconSetting.DEFAULT_LARGE_ICON, deviceInfo);
            }
            httpHashMapWrap.put("clientfrom", "mobilesdk_enhanced");
            httpHashMapWrap.put(ZeusInitConfigUtils.PREF_KEY_SDK_VERSION, "3");
            return httpHashMapWrap;
        }
        return (HttpHashMapWrap) invokeL.objValue;
    }

    public int getErrorCode(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            try {
                return new JSONObject(str).getInt("errno");
            } catch (Exception e2) {
                Log.e(e2);
                return -100;
            }
        }
        return invokeL.intValue;
    }

    public String getErrorMsg(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            try {
                return new JSONObject(str).optString("errmsg");
            } catch (Exception e2) {
                Log.e(e2);
                return "网络连接失败，请检查网络设置";
            }
        }
        return (String) invokeL.objValue;
    }

    public String getUaInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return "tpl:" + this.configuration.tpl + ";android_sapi_v" + this.versionName;
        }
        return (String) invokeV.objValue;
    }

    public SapiAccount parseAccount(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, jSONObject)) == null) {
            SapiAccount sapiAccount = new SapiAccount();
            sapiAccount.uid = jSONObject.optString("uid");
            sapiAccount.bduss = jSONObject.optString("bduss");
            sapiAccount.displayname = jSONObject.optString("displayname");
            sapiAccount.username = jSONObject.optString("uname");
            sapiAccount.stoken = jSONObject.optString("stoken");
            sapiAccount.ptoken = jSONObject.optString(SapiAccount.SAPI_ACCOUNT_PTOKEN);
            sapiAccount.extra = jSONObject.toString();
            sapiAccount.app = SapiUtils.getAppName(this.configuration.context);
            return sapiAccount;
        }
        return (SapiAccount) invokeL.objValue;
    }
}
