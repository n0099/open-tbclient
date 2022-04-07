package com.baidu.sofire.utility;

import androidx.core.view.InputDeviceCompat;
import com.baidu.sofire.jni.Asc;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes2.dex */
public class EncryptUtil {
    public static /* synthetic */ Interceptable $ic;
    public static Asc sAsc;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1293117306, "Lcom/baidu/sofire/utility/EncryptUtil;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1293117306, "Lcom/baidu/sofire/utility/EncryptUtil;");
                return;
            }
        }
        sAsc = new Asc();
    }

    public EncryptUtil() {
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

    public static byte[] aesDecrypt(byte[] bArr, byte[] bArr2, boolean z) {
        InterceptResult invokeLLZ;
        byte[] dcn;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65538, null, bArr, bArr2, z)) == null) {
            if (bArr != null) {
                try {
                } catch (Throwable th) {
                    CommonMethods.handleNuLException(th);
                }
                if (bArr.length > 0 && bArr2 != null && bArr2.length > 0) {
                    if (sAsc != null) {
                        if (z) {
                            dcn = sAsc.dc(bArr2, bArr);
                        } else {
                            dcn = sAsc.dcn(bArr2, bArr);
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

    public static byte[] aesEncrypt(byte[] bArr, byte[] bArr2, boolean z) {
        InterceptResult invokeLLZ;
        byte[] acn;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65539, null, bArr, bArr2, z)) == null) {
            if (bArr != null) {
                try {
                } catch (Throwable th) {
                    CommonMethods.handleNuLException(th);
                }
                if (bArr.length > 0 && bArr2 != null && bArr2.length > 0) {
                    if (sAsc != null) {
                        if (z) {
                            acn = sAsc.ac(bArr2, bArr);
                        } else {
                            acn = sAsc.acn(bArr2, bArr);
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

    public static int decryptFile(File file, File file2, byte[] bArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, file, file2, bArr)) == null) {
            if (bArr != null) {
                try {
                    if (bArr.length > 0 && file != null && file2 != null && sAsc != null) {
                        return sAsc.df(file.getAbsolutePath(), file2.getAbsolutePath(), bArr);
                    }
                } catch (Throwable th) {
                    CommonMethods.handleNuLException(th);
                }
            }
            return -1;
        }
        return invokeLLL.intValue;
    }

    public static byte[] rc4Decrypt(byte[] bArr, byte[] bArr2) {
        InterceptResult invokeLL;
        byte[] dr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, bArr, bArr2)) == null) {
            if (bArr2 != null) {
                try {
                } catch (Throwable th) {
                    CommonMethods.handleNuLException(th);
                }
                if (bArr2.length > 0 && bArr != null && bArr.length > 0) {
                    if (sAsc != null && (dr = sAsc.dr(bArr, bArr2)) != null && dr.length > 0) {
                        return dr;
                    }
                    return new byte[0];
                }
            }
            return new byte[0];
        }
        return (byte[]) invokeLL.objValue;
    }

    public static byte[] rc4Encrypt(byte[] bArr, byte[] bArr2) {
        InterceptResult invokeLL;
        byte[] ar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, bArr, bArr2)) == null) {
            if (bArr2 != null) {
                try {
                } catch (Throwable th) {
                    CommonMethods.handleNuLException(th);
                }
                if (bArr2.length > 0 && bArr != null && bArr.length > 0) {
                    if (sAsc != null && (ar = sAsc.ar(bArr, bArr2)) != null && ar.length > 0) {
                        return ar;
                    }
                    return new byte[0];
                }
            }
            return new byte[0];
        }
        return (byte[]) invokeLL.objValue;
    }
}
