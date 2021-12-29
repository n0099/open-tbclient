package cn.com.chinatelecom.gateway.lib.a;

import androidx.core.view.InputDeviceCompat;
import cn.com.chinatelecom.gateway.lib.CtAuth;
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
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "a";

    /* renamed from: b  reason: collision with root package name */
    public static byte[] f31564b;

    /* renamed from: c  reason: collision with root package name */
    public static byte[] f31565c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1293575034, "Lcn/com/chinatelecom/gateway/lib/a/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1293575034, "Lcn/com/chinatelecom/gateway/lib/a/a;");
                return;
            }
        }
        f31564b = "0000000000000000".getBytes();
        f31565c = "vrf5g7h0tededwx3".getBytes();
    }

    public a() {
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

    public static String a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) {
            try {
                IvParameterSpec ivParameterSpec = new IvParameterSpec(f31564b);
                SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), "AES");
                Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
                byte[] bytes = str.getBytes("utf-8");
                cipher.init(1, secretKeySpec, ivParameterSpec);
                return e.a(cipher.doFinal(bytes));
            } catch (Throwable th) {
                CtAuth.warn(a, "encryptAesNew error", th);
                return null;
            }
        }
        return (String) invokeLL.objValue;
    }

    public static byte[] b(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, str2)) == null) {
            try {
                byte[] bytes = str.getBytes("utf-8");
                int length = bytes.length;
                while (length % 16 != 0) {
                    length++;
                }
                byte[] bArr = new byte[length];
                for (int i2 = 0; i2 < length; i2++) {
                    if (i2 < bytes.length) {
                        bArr[i2] = bytes[i2];
                    } else {
                        bArr[i2] = 0;
                    }
                }
                IvParameterSpec ivParameterSpec = new IvParameterSpec(f31565c);
                SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), "AES");
                Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
                cipher.init(1, secretKeySpec, ivParameterSpec);
                return cipher.doFinal(bArr);
            } catch (Throwable th) {
                CtAuth.warn(a, "encrypt4Ux error", th);
                return null;
            }
        }
        return (byte[]) invokeLL.objValue;
    }

    public static String c(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2)) == null) {
            try {
                IvParameterSpec ivParameterSpec = new IvParameterSpec(f31564b);
                SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), "AES");
                Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
                cipher.init(2, secretKeySpec, ivParameterSpec);
                byte[] doFinal = cipher.doFinal(e.a(str));
                if (doFinal != null) {
                    return new String(doFinal);
                }
                CtAuth.info(a, "Aes decrypt result is empty");
                return "";
            } catch (Throwable th) {
                CtAuth.warn(a, "decryptAesNew error", th);
                return "";
            }
        }
        return (String) invokeLL.objValue;
    }
}
