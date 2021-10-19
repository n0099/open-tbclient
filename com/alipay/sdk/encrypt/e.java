package com.alipay.sdk.encrypt;

import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: classes4.dex */
public class e {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static String f36030a = "DESede/CBC/PKCS5Padding";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1795807520, "Lcom/alipay/sdk/encrypt/e;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1795807520, "Lcom/alipay/sdk/encrypt/e;");
        }
    }

    public e() {
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

    public static byte[] a(String str, byte[] bArr, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, str, bArr, str2)) == null) {
            try {
                SecretKeySpec secretKeySpec = new SecretKeySpec(str.getBytes(), "DESede");
                Cipher cipher = Cipher.getInstance(f36030a);
                cipher.init(2, secretKeySpec, new IvParameterSpec(c.a(cipher, str2)));
                return cipher.doFinal(bArr);
            } catch (Exception unused) {
                return null;
            }
        }
        return (byte[]) invokeLLL.objValue;
    }

    public static byte[] b(String str, byte[] bArr, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(AdIconUtil.AD_TEXT_ID, null, str, bArr, str2)) == null) {
            try {
                SecretKeySpec secretKeySpec = new SecretKeySpec(str.getBytes(), "DESede");
                Cipher cipher = Cipher.getInstance(f36030a);
                cipher.init(1, secretKeySpec, new IvParameterSpec(c.a(cipher, str2)));
                return cipher.doFinal(bArr);
            } catch (Exception unused) {
                return null;
            }
        }
        return (byte[]) invokeLLL.objValue;
    }

    public static String a(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, str, str2, str3)) == null) {
            try {
                return new String(a(str, a.a(str2), str3));
            } catch (Exception unused) {
                return null;
            }
        }
        return (String) invokeLLL.objValue;
    }

    public static String b(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2, str3)) == null) {
            try {
                return a.a(b(str, str2.getBytes(), str3));
            } catch (Exception unused) {
                return null;
            }
        }
        return (String) invokeLLL.objValue;
    }
}
