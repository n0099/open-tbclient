package com.baidu.sofire.face.b;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.security.MessageDigest;
/* loaded from: classes3.dex */
public final class c {
    public static /* synthetic */ Interceptable $ic;
    public static final String[] a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-266860216, "Lcom/baidu/sofire/face/b/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-266860216, "Lcom/baidu/sofire/face/b/c;");
                return;
            }
        }
        a = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};
    }

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                String str2 = new String(str);
                try {
                    return a(MessageDigest.getInstance("MD5").digest(str2.getBytes()));
                } catch (Throwable unused) {
                    return str2;
                }
            } catch (Throwable unused2) {
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public static String a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, bArr)) == null) {
            StringBuffer stringBuffer = new StringBuffer();
            for (int i : bArr) {
                if (i < 0) {
                    i += 256;
                }
                StringBuilder sb = new StringBuilder();
                String[] strArr = a;
                sb.append(strArr[i / 16]);
                sb.append(strArr[i % 16]);
                stringBuffer.append(sb.toString());
            }
            return stringBuffer.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String b(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, bArr)) == null) {
            if (bArr == null) {
                return null;
            }
            if (bArr.length > 0) {
                try {
                } catch (Throwable unused) {
                    return null;
                }
            }
            return a(MessageDigest.getInstance("MD5").digest(bArr));
        }
        return (String) invokeL.objValue;
    }
}
