package com.baidu.sofire.k;

import com.baidu.sofire.jni.Asc;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public static Asc a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2074258985, "Lcom/baidu/sofire/k/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2074258985, "Lcom/baidu/sofire/k/e;");
                return;
            }
        }
        a = new Asc();
    }

    public static byte[] a(byte[] bArr, byte[] bArr2, boolean z) {
        InterceptResult invokeLLZ;
        byte[] dcn;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65537, null, bArr, bArr2, z)) == null) {
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
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65538, null, bArr, bArr2, z)) == null) {
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
