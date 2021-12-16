package com.baidu.pass.biometrics.base.utils;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.pass.biometrics.base.debug.Log;
import com.baidu.pass.common.SecurityUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Random;
/* loaded from: classes10.dex */
public class PassBioDataEncryptor {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "PassBioDataEncryptor";
    public transient /* synthetic */ FieldHolder $fh;

    public PassBioDataEncryptor() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static String a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i2)) == null) {
            Random random = new Random();
            StringBuffer stringBuffer = new StringBuffer();
            for (int i3 = 0; i3 < i2; i3++) {
                stringBuffer.append("0123456789abcdefghijklmnopqrstuvwxyz".charAt(random.nextInt(36)));
            }
            return stringBuffer.toString();
        }
        return (String) invokeI.objValue;
    }

    public static String decryptAccountInfo(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                return new String(SecurityUtil.base64Decode(new AES().decrypt(SecurityUtil.base64Decode(str.getBytes()), new StringBuffer(str2).reverse().toString(), str2)), "UTF-8").trim();
            } catch (Throwable th) {
                Log.e(a, a, th);
                return "";
            }
        }
        return (String) invokeLL.objValue;
    }

    public static String encryptAccountInfo(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, str2)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                return SecurityUtil.base64Encode(new AES().encrypt(SecurityUtil.base64Encode(str.getBytes()), new StringBuffer(str2).reverse().toString(), str2));
            } catch (Throwable th) {
                Log.e(a, a, th);
                return "";
            }
        }
        return (String) invokeLL.objValue;
    }

    public static String encryptParams(String str) {
        InterceptResult invokeL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            String str3 = "";
            String a2 = a(16);
            try {
                str2 = SecurityUtil.base64Encode(new AES().encrypt(str, new StringBuffer(a2).reverse().toString(), a2));
            } catch (Exception e2) {
                e = e2;
                str2 = "";
            }
            try {
                str3 = SecurityUtil.base64Encode(RSA.encrypt(a2));
            } catch (Exception e3) {
                e = e3;
                Log.e(a, a, e);
                return TextUtils.join("_", new String[]{str3, str2});
            }
            return TextUtils.join("_", new String[]{str3, str2});
        }
        return (String) invokeL.objValue;
    }
}
