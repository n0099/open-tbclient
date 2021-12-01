package com.baidu.sofire.utility;

import androidx.core.view.InputDeviceCompat;
import com.baidu.sofire.jni.Asc;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
/* loaded from: classes9.dex */
public final class h {
    public static /* synthetic */ Interceptable $ic;
    public static Asc a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1443542363, "Lcom/baidu/sofire/utility/h;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1443542363, "Lcom/baidu/sofire/utility/h;");
                return;
            }
        }
        a = new Asc();
    }

    public static byte[] a(byte[] bArr, byte[] bArr2, boolean z) {
        InterceptResult invokeLLZ;
        byte[] acn;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65539, null, bArr, bArr2, z)) == null) {
            if (bArr != null) {
                try {
                } catch (Throwable unused) {
                    c.a();
                }
                if (bArr.length > 0 && bArr2 != null && bArr2.length > 0) {
                    if (a != null) {
                        if (z) {
                            acn = a.ac(bArr2, bArr);
                        } else {
                            acn = a.acn(bArr2, bArr);
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

    public static byte[] b(byte[] bArr, byte[] bArr2) {
        InterceptResult invokeLL;
        byte[] ar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, bArr, bArr2)) == null) {
            if (bArr2 != null) {
                try {
                } catch (Throwable unused) {
                    c.a();
                }
                if (bArr2.length > 0 && bArr != null && bArr.length > 0) {
                    if (a != null && (ar = a.ar(bArr, bArr2)) != null && ar.length > 0) {
                        return ar;
                    }
                    return new byte[0];
                }
            }
            return new byte[0];
        }
        return (byte[]) invokeLL.objValue;
    }

    public static byte[] c(byte[] bArr, byte[] bArr2) {
        InterceptResult invokeLL;
        byte[] dr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, bArr, bArr2)) == null) {
            if (bArr2 != null) {
                try {
                } catch (Throwable unused) {
                    c.a();
                }
                if (bArr2.length > 0 && bArr != null && bArr.length > 0) {
                    if (a != null && (dr = a.dr(bArr, bArr2)) != null && dr.length > 0) {
                        return dr;
                    }
                    return new byte[0];
                }
            }
            return new byte[0];
        }
        return (byte[]) invokeLL.objValue;
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        InterceptResult invokeLL;
        byte[] dc;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, bArr, bArr2)) == null) {
            if (bArr != null) {
                try {
                } catch (Throwable unused) {
                    c.a();
                }
                if (bArr.length > 0 && bArr2 != null && bArr2.length > 0) {
                    if (a != null && (dc = a.dc(bArr2, bArr)) != null && dc.length > 0) {
                        return dc;
                    }
                    return new byte[0];
                }
            }
            return new byte[0];
        }
        return (byte[]) invokeLL.objValue;
    }

    public static int a(File file, File file2, byte[] bArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, file, file2, bArr)) == null) {
            if (bArr != null) {
                try {
                    if (bArr.length > 0 && file != null && file2 != null && a != null) {
                        return a.df(file.getAbsolutePath(), file2.getAbsolutePath(), bArr);
                    }
                } catch (Throwable unused) {
                    c.a();
                }
            }
            return -1;
        }
        return invokeLLL.intValue;
    }
}
