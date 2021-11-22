package b.a.e.h.g;

import android.content.pm.Signature;
import android.util.Base64;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1168228570, "Lb/a/e/h/g/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1168228570, "Lb/a/e/h/g/a;");
        }
    }

    public static byte[] a(Signature[] signatureArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, signatureArr)) == null) {
            if (signatureArr != null) {
                int i2 = 0;
                for (Signature signature : signatureArr) {
                    i2 += signature.toByteArray().length;
                }
                byte[] bArr = new byte[i2];
                int i3 = 0;
                for (Signature signature2 : signatureArr) {
                    byte[] byteArray = signature2.toByteArray();
                    System.arraycopy(byteArray, 0, bArr, i3, byteArray.length);
                    i3 += byteArray.length;
                }
                return bArr;
            }
            return null;
        }
        return (byte[]) invokeL.objValue;
    }

    public static String b(byte[] bArr) {
        InterceptResult invokeL;
        NoSuchAlgorithmException e2;
        String str;
        byte[] digest;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, bArr)) == null) {
            if (bArr != null) {
                try {
                    digest = MessageDigest.getInstance("MD5").digest(bArr);
                } catch (NoSuchAlgorithmException e3) {
                    e2 = e3;
                    str = null;
                }
                if (digest != null) {
                    str = Base64.encodeToString(digest, 0);
                    if (str != null) {
                        try {
                            str = str.replaceAll("\\s", "").replaceAll("\\\\", "rg").replaceAll("/", "lg");
                        } catch (NoSuchAlgorithmException e4) {
                            e2 = e4;
                            if (BdLog.isDebugMode()) {
                                e2.printStackTrace();
                            }
                            return str;
                        }
                    }
                    return str;
                }
                return null;
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static String c(Signature[] signatureArr) {
        InterceptResult invokeL;
        byte[] a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, signatureArr)) == null) {
            if (signatureArr == null || (a2 = a(signatureArr)) == null) {
                return null;
            }
            return b(a2);
        }
        return (String) invokeL.objValue;
    }
}
