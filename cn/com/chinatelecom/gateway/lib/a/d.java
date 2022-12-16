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
import java.security.KeyFactory;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
/* loaded from: classes.dex */
public class d {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "d";
    public static String b = "RSA/ECB/PKCS1Padding";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1293574941, "Lcn/com/chinatelecom/gateway/lib/a/d;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1293574941, "Lcn/com/chinatelecom/gateway/lib/a/d;");
        }
    }

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static String a(String str, RSAPublicKey rSAPublicKey) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, rSAPublicKey)) == null) {
            byte[] a2 = a(rSAPublicKey, str.getBytes());
            return a2 != null ? e.a(a2) : "";
        }
        return (String) invokeLL.objValue;
    }

    public static RSAPublicKey a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            try {
                return (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(b.a("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC5se07mkN71qsSJHjZ2Z0+Z+4LlLvf2sz7Md38VAa3EmAOvI7vZp3hbAxicL724ylcmisTPtZQhT/9C+25AELqy9PN9JmzKpwoVTUoJvxG4BoyT49+gGVl6s6zo1byNoHUzTfkmRfmC9MC53HvG8GwKP5xtcdptFjAIcgIR7oAWQIDAQAB")));
            } catch (Throwable th) {
                CtAuth.warn(a, "getPublicKey error", th);
                return null;
            }
        }
        return (RSAPublicKey) invokeV.objValue;
    }

    public static byte[] a(RSAPublicKey rSAPublicKey, byte[] bArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, rSAPublicKey, bArr)) == null) {
            try {
                Cipher cipher = Cipher.getInstance(b);
                cipher.init(1, rSAPublicKey);
                return cipher.doFinal(bArr);
            } catch (Throwable th) {
                CtAuth.warn(a, "Rsa encrypt4Ux error", th);
                return null;
            }
        }
        return (byte[]) invokeLL.objValue;
    }
}
