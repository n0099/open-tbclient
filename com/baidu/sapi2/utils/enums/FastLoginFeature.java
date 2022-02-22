package com.baidu.sapi2.utils.enums;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes11.dex */
public final class FastLoginFeature {
    public static final /* synthetic */ FastLoginFeature[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final FastLoginFeature GLORY_LOGIN;
    public static final FastLoginFeature HUAWEI_LOGIN;
    public static final FastLoginFeature MEIZU_SSO;
    public static final FastLoginFeature QR_LOGIN;
    public static final FastLoginFeature SINA_WEIBO_SSO;
    public static final FastLoginFeature SINA_WEIBO_WEBVIEW;
    public static final FastLoginFeature TX_QQ_SSO;
    public static final FastLoginFeature TX_WEIXIN_SSO;
    public static final FastLoginFeature XIAOMI_SSO;
    public static final FastLoginFeature YY_SSO;
    public transient /* synthetic */ FieldHolder $fh;
    public String mStrValue;

    /* loaded from: classes11.dex */
    public interface SSOLoginType {
        public static final String HONOR = "glory_login";
        public static final String HUAWEI = "huawei_login";
        public static final String MEIZU = "meizu_sso";
        public static final String QQ = "qq_sso";
        public static final String QR_APP_LOGIN = "qr_app_login";
        public static final String SINA_SSO = "tsina_sso";
        public static final String SINA_WEB = "tsina";
        public static final String WEIXIN = "tweixin_sso";
        public static final String XIAOMI = "xiaomi_sso";
        public static final String YY = "yy";
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2014550597, "Lcom/baidu/sapi2/utils/enums/FastLoginFeature;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2014550597, "Lcom/baidu/sapi2/utils/enums/FastLoginFeature;");
                return;
            }
        }
        TX_WEIXIN_SSO = new FastLoginFeature("TX_WEIXIN_SSO", 0, SSOLoginType.WEIXIN);
        SINA_WEIBO_SSO = new FastLoginFeature("SINA_WEIBO_SSO", 1, SSOLoginType.SINA_SSO);
        SINA_WEIBO_WEBVIEW = new FastLoginFeature("SINA_WEIBO_WEBVIEW", 2, "tsina");
        TX_QQ_SSO = new FastLoginFeature("TX_QQ_SSO", 3, SSOLoginType.QQ);
        QR_LOGIN = new FastLoginFeature("QR_LOGIN", 4, SSOLoginType.QR_APP_LOGIN);
        HUAWEI_LOGIN = new FastLoginFeature("HUAWEI_LOGIN", 5, SSOLoginType.HUAWEI);
        GLORY_LOGIN = new FastLoginFeature("GLORY_LOGIN", 6, SSOLoginType.HONOR);
        MEIZU_SSO = new FastLoginFeature("MEIZU_SSO", 7, SSOLoginType.MEIZU);
        XIAOMI_SSO = new FastLoginFeature("XIAOMI_SSO", 8, SSOLoginType.XIAOMI);
        FastLoginFeature fastLoginFeature = new FastLoginFeature("YY_SSO", 9, "yy");
        YY_SSO = fastLoginFeature;
        $VALUES = new FastLoginFeature[]{TX_WEIXIN_SSO, SINA_WEIBO_SSO, SINA_WEIBO_WEBVIEW, TX_QQ_SSO, QR_LOGIN, HUAWEI_LOGIN, GLORY_LOGIN, MEIZU_SSO, XIAOMI_SSO, fastLoginFeature};
    }

    public FastLoginFeature(String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2), str2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str3 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mStrValue = str2;
    }

    public static FastLoginFeature getDefault() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? SINA_WEIBO_SSO : (FastLoginFeature) invokeV.objValue;
    }

    public static FastLoginFeature mapStrToValue(String str) {
        InterceptResult invokeL;
        FastLoginFeature[] values;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return getDefault();
            }
            for (FastLoginFeature fastLoginFeature : values()) {
                if (str.equals(fastLoginFeature.getStrValue())) {
                    return fastLoginFeature;
                }
            }
            return getDefault();
        }
        return (FastLoginFeature) invokeL.objValue;
    }

    public static FastLoginFeature valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) ? (FastLoginFeature) Enum.valueOf(FastLoginFeature.class, str) : (FastLoginFeature) invokeL.objValue;
    }

    public static FastLoginFeature[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? (FastLoginFeature[]) $VALUES.clone() : (FastLoginFeature[]) invokeV.objValue;
    }

    public String getStrValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mStrValue : (String) invokeV.objValue;
    }
}
