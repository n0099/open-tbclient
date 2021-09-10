package c.a.n0.l;

import android.content.Context;
import android.util.Base64;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.security.KeyFactory;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
/* loaded from: classes.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, context, str)) == null) {
            if (context != null && str != null) {
                try {
                    return new String(a.b(c.i(context).getBytes(), Base64.decode(str, 0), true));
                } catch (Throwable th) {
                    c.d(th);
                }
            }
            return null;
        }
        return (String) invokeLL.objValue;
    }

    public static String b(Context context, byte[] bArr) {
        InterceptResult invokeLL;
        byte[] a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, bArr)) == null) {
            if (bArr != null) {
                try {
                    if (bArr.length != 0 && (a2 = a.a(c.i(context).getBytes(), bArr)) != null && a2.length > 0) {
                        return Base64.encodeToString(a2, 0);
                    }
                    return null;
                } catch (Throwable th) {
                    c.d(th);
                }
            }
            return null;
        }
        return (String) invokeLL.objValue;
    }

    public static String c(byte[] bArr, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, bArr, str)) == null) {
            try {
                RSAPublicKey d2 = d(str);
                if (d2 == null) {
                    return "";
                }
                Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
                cipher.init(1, d2);
                return Base64.encodeToString(cipher.doFinal(bArr), 0);
            } catch (Throwable th) {
                c.d(th);
                return "";
            }
        }
        return (String) invokeLL.objValue;
    }

    public static RSAPublicKey d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            try {
                return (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str, 0)));
            } catch (Throwable th) {
                c.d(th);
                return null;
            }
        }
        return (RSAPublicKey) invokeL.objValue;
    }

    public static byte[] e(byte[] bArr, byte[] bArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, bArr, bArr2)) == null) {
            byte[] bArr3 = null;
            if (bArr2 != null) {
                try {
                    if (bArr2.length > 0 && bArr != null && bArr.length > 0 && (bArr3 = a.b(bArr2, bArr, true)) != null) {
                        if (bArr3.length > 0) {
                            return bArr3;
                        }
                    }
                } catch (Throwable th) {
                    c.d(th);
                }
            }
            return bArr3;
        }
        return (byte[]) invokeLL.objValue;
    }

    public static byte[] f(byte[] bArr, byte[] bArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, bArr, bArr2)) == null) {
            byte[] bArr3 = null;
            if (bArr2 != null) {
                try {
                    if (bArr2.length > 0 && bArr != null && bArr.length > 0 && (bArr3 = a.a(bArr2, bArr)) != null) {
                        if (bArr3.length > 0) {
                            return bArr3;
                        }
                    }
                } catch (Throwable th) {
                    c.d(th);
                }
            }
            return bArr3;
        }
        return (byte[]) invokeLL.objValue;
    }

    public static byte[] g(byte[] bArr, byte[] bArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, bArr, bArr2)) == null) {
            byte[] bArr3 = null;
            if (bArr2 != null) {
                try {
                    if (bArr2.length > 0 && bArr != null && bArr.length > 0 && (bArr3 = i.b(bArr, bArr2)) != null) {
                        if (bArr3.length > 0) {
                            return bArr3;
                        }
                    }
                } catch (Throwable th) {
                    c.d(th);
                }
            }
            return bArr3;
        }
        return (byte[]) invokeLL.objValue;
    }

    public static byte[] h(byte[] bArr, byte[] bArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, bArr, bArr2)) == null) {
            byte[] bArr3 = null;
            if (bArr2 != null) {
                try {
                    if (bArr2.length > 0 && bArr != null && bArr.length > 0 && (bArr3 = i.c(bArr, bArr2)) != null) {
                        if (bArr3.length > 0) {
                            return bArr3;
                        }
                    }
                } catch (Throwable th) {
                    c.d(th);
                }
            }
            return bArr3;
        }
        return (byte[]) invokeLL.objValue;
    }
}
