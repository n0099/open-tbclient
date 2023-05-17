package com.baidu.sofire.k;

import android.text.TextUtils;
import android.util.Base64;
import androidx.core.view.InputDeviceCompat;
import com.baidu.sofire.jni.Asc;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public static Asc a;
    public static byte[] b;
    public static byte[] c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2074259016, "Lcom/baidu/sofire/k/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2074259016, "Lcom/baidu/sofire/k/f;");
                return;
            }
        }
        a = new Asc();
    }

    public static String a(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, str, i)) == null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return "";
                }
                return new String(a(a(i), Base64.decode(str, 10), true), "UTF-8");
            } catch (Throwable unused) {
                int i2 = com.baidu.sofire.a.b.a;
                return "";
            }
        }
        return (String) invokeLI.objValue;
    }

    public static synchronized byte[] a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) {
            synchronized (f.class) {
                if (i != 16) {
                    if (i != 24) {
                        return new byte[0];
                    }
                    byte[] bArr = c;
                    if (bArr == null || bArr.length != 24) {
                        c = new byte[]{77, 122, 65, 121, 77, 84, 73, 120, 77, 68, 74, 107, 97, 87, 78, 49, 90, 71, 108, 104, 89, 103, 61, 61};
                    }
                    return c;
                }
                byte[] bArr2 = b;
                if (bArr2 == null || bArr2.length != 16) {
                    b = Base64.decode(new byte[]{77, 122, 65, 121, 77, 84, 73, 120, 77, 68, 74, 107, 97, 87, 78, 49, 90, 71, 108, 104, 89, 103, 61, 61}, 0);
                }
                return b;
            }
        }
        return (byte[]) invokeI.objValue;
    }

    public static byte[] a(byte[] bArr, byte[] bArr2, boolean z) {
        InterceptResult invokeLLZ;
        byte[] dcn;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65539, null, bArr, bArr2, z)) == null) {
            if (bArr != null) {
                try {
                } catch (Throwable unused) {
                    int i = com.baidu.sofire.a.b.a;
                }
                if (bArr.length > 0 && bArr2 != null && bArr2.length > 0) {
                    Asc asc = a;
                    if (asc != null) {
                        if (z) {
                            dcn = asc.dc(bArr2, bArr);
                        } else {
                            dcn = asc.dcn(bArr2, bArr);
                        }
                        if (dcn != null && dcn.length > 0) {
                            return dcn;
                        }
                    }
                    return new byte[0];
                }
            }
            return new byte[0];
        }
        return (byte[]) invokeLLZ.objValue;
    }

    public static byte[] b(byte[] bArr, byte[] bArr2, boolean z) {
        InterceptResult invokeLLZ;
        byte[] acn;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(InputDeviceCompat.SOURCE_TRACKBALL, null, bArr, bArr2, z)) == null) {
            if (bArr != null) {
                try {
                } catch (Throwable unused) {
                    int i = com.baidu.sofire.a.b.a;
                }
                if (bArr.length > 0 && bArr2 != null && bArr2.length > 0) {
                    Asc asc = a;
                    if (asc != null) {
                        if (z) {
                            acn = asc.ac(bArr2, bArr);
                        } else {
                            acn = asc.acn(bArr2, bArr);
                        }
                        if (acn != null && acn.length > 0) {
                            return acn;
                        }
                    }
                    return new byte[0];
                }
            }
            return new byte[0];
        }
        return (byte[]) invokeLLZ.objValue;
    }
}
