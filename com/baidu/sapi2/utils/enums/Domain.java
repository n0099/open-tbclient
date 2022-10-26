package com.baidu.sapi2.utils.enums;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.utils.SapiHost;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes2.dex */
public final class Domain {
    public static final /* synthetic */ Domain[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final Domain DOMAIN_ONLINE;
    public static final Domain DOMAIN_QA;
    public transient /* synthetic */ FieldHolder $fh;
    public String configHttpsUrl;
    public String deviceUrl;
    public boolean forceHttps;
    public String portraitUrl;
    public String url;
    public String wap;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-964295062, "Lcom/baidu/sapi2/utils/enums/Domain;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-964295062, "Lcom/baidu/sapi2/utils/enums/Domain;");
                return;
            }
        }
        DOMAIN_ONLINE = new Domain("DOMAIN_ONLINE", 0, "aHR0cDovL3Bhc3Nwb3J0LmJhaWR1LmNvbQ==", SapiHost.DOMAIN_ONLINE_WAPPASS_URL, SapiHost.DOMAIN_ONLINE_DEVICE_URL, SapiHost.DOMAIN_ONLINE_CONFIG_HTTPS_URL, SapiHost.DOMAIN_ONLINE_PORTRAIT_URL);
        Domain domain = new Domain("DOMAIN_QA", 1, SapiHost.DOMAIN_QA_PASSPORT_URL, SapiHost.DOMAIN_QA_WAPPASS_URL, SapiHost.DOMAIN_QA_DEVICE_URL, SapiHost.DOMAIN_QA_CONFIG_HTTPS_URL, "aHR0cDovL3Bhc3Nwb3J0LmJhaWR1LmNvbQ==");
        DOMAIN_QA = domain;
        $VALUES = new Domain[]{DOMAIN_ONLINE, domain};
    }

    public Domain(String str, int i, String str2, String str3, String str4, String str5, String str6) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i), str2, str3, str4, str5, str6};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str7 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.url = SapiHost.getHost(str2);
        this.wap = SapiHost.getHost(str3);
        this.deviceUrl = SapiHost.getHost(str4);
        this.configHttpsUrl = SapiHost.getHost(str5);
        this.portraitUrl = SapiHost.getHost(str6);
    }

    public static Domain valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            return (Domain) Enum.valueOf(Domain.class, str);
        }
        return (Domain) invokeL.objValue;
    }

    public Domain forceHttps(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
            this.forceHttps = z;
            return this;
        }
        return (Domain) invokeZ.objValue;
    }

    public static Domain[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return (Domain[]) $VALUES.clone();
        }
        return (Domain[]) invokeV.objValue;
    }

    public String getConfigHttpsUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.configHttpsUrl;
        }
        return (String) invokeV.objValue;
    }

    public String getDeviceUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.deviceUrl;
        }
        return (String) invokeV.objValue;
    }

    public String getPortraitUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.portraitUrl;
        }
        return (String) invokeV.objValue;
    }

    public String getURL() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return getURL(SapiUtils.getDefaultHttpsEnabled());
        }
        return (String) invokeV.objValue;
    }

    public String getUrlDomain() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return getURL().replace("http://", "").replace("https://", "").replaceAll("(:[0-9]{1,4})?", "");
        }
        return (String) invokeV.objValue;
    }

    public String getWapDomain() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return getWap().replace("http://", "").replace("https://", "").replaceAll("(:[0-9]{1,4})?", "");
        }
        return (String) invokeV.objValue;
    }

    public String getURL(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048581, this, z)) == null) {
            if ((equals(DOMAIN_ONLINE) && z) || (!equals(DOMAIN_ONLINE) && this.forceHttps)) {
                return this.url.replace("http://", "https://");
            }
            return this.url;
        }
        return (String) invokeZ.objValue;
    }

    public String getWap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if ((equals(DOMAIN_ONLINE) && SapiUtils.getDefaultHttpsEnabled()) || (!equals(DOMAIN_ONLINE) && this.forceHttps)) {
                return this.wap.replace("http://", "https://");
            }
            return this.wap;
        }
        return (String) invokeV.objValue;
    }
}
