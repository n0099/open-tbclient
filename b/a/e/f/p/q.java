package b.a.e.f.p;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.InputStream;
import java.security.MessageDigest;
/* loaded from: classes.dex */
public class q {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final char[] f2059a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1111238883, "Lb/a/e/f/p/q;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1111238883, "Lb/a/e/f/p/q;");
                return;
            }
        }
        f2059a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    }

    public static String a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, bArr)) == null) {
            if (bArr == null) {
                return null;
            }
            StringBuilder sb = new StringBuilder(bArr.length * 2);
            for (int i2 = 0; i2 < bArr.length; i2++) {
                sb.append(f2059a[(bArr[i2] & 240) >>> 4]);
                sb.append(f2059a[bArr[i2] & 15]);
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String b(InputStream inputStream) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, inputStream)) == null) {
            String str = null;
            if (inputStream == null) {
                return null;
            }
            try {
                try {
                    byte[] bArr = new byte[1024];
                    MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read <= 0) {
                            break;
                        }
                        messageDigest.update(bArr, 0, read);
                    }
                    str = a(messageDigest.digest());
                } catch (Exception e2) {
                    BdLog.e(e2.toString());
                }
                return str;
            } finally {
                m.e(inputStream);
            }
        }
        return (String) invokeL.objValue;
    }

    public static String c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (str == null) {
                return null;
            }
            try {
                return d(str.getBytes("UTF-8"));
            } catch (Exception unused) {
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public static String d(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, bArr)) == null) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                messageDigest.update(bArr);
                return a(messageDigest.digest());
            } catch (Exception e2) {
                BdLog.e(e2);
                return null;
            }
        }
        return (String) invokeL.objValue;
    }
}
