package com.baidu.searchbox.account.utils;

import android.text.TextUtils;
import com.baidu.searchbox.NativeBds;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.apache.commons.codec.binary4util.bdapp.Base64;
/* loaded from: classes9.dex */
public final class SocialEncodeUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG;
    public static final String TAG = "SocialEncodeUtils";
    public static final String TAG_SOCIAL = "baiduuid_";
    public static final String TAG_TEL = "tel_";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1866854983, "Lcom/baidu/searchbox/account/utils/SocialEncodeUtils;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1866854983, "Lcom/baidu/searchbox/account/utils/SocialEncodeUtils;");
                return;
            }
        }
        DEBUG = AppConfig.isDebug();
    }

    public SocialEncodeUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static String getSocialDecrypt(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            try {
                return new String(NativeBds.dae(str2, Base64.decode(str, 11)));
            } catch (Exception e2) {
                if (DEBUG) {
                    String str3 = "getSocialDecrypt plainText:" + str + ", exception:" + e2;
                    return "";
                }
                return "";
            } catch (UnsatisfiedLinkError e3) {
                if (DEBUG) {
                    String str4 = "Only Debug Mode Throw ：UnsatisfiedLinkError exception:" + e3;
                    throw e3;
                }
                return "";
            }
        }
        return (String) invokeLL.objValue;
    }

    public static String getSocialEncryption(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, str2)) == null) {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            try {
                return new String(Base64.encode(NativeBds.ae(str2, str), 11));
            } catch (Exception e2) {
                if (DEBUG) {
                    String str3 = "getSocialEncryption plainText:" + str + ", exception:" + e2;
                }
                return "";
            }
        }
        return (String) invokeLL.objValue;
    }
}
