package com.baidu.bdptask.bdtls;

import androidx.annotation.Keep;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.charset.Charset;
@Keep
/* loaded from: classes3.dex */
public class AES {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Keep
    public static native byte[] decrypt(byte[] bArr, byte[] bArr2);

    @Keep
    public static native byte[] encrypt(byte[] bArr, byte[] bArr2);

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1545759636, "Lcom/baidu/bdptask/bdtls/AES;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1545759636, "Lcom/baidu/bdptask/bdtls/AES;");
                return;
            }
        }
        try {
            System.loadLibrary("bdptask");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public AES() {
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

    public static byte[] aesDecrypt(byte[] bArr, byte[] bArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, bArr, bArr2)) == null) {
            return (bArr == null || bArr.length <= 0) ? new byte[]{-1} : decrypt(bArr, bArr2);
        }
        return (byte[]) invokeLL.objValue;
    }

    public static byte[] aesEncrypt(String str, byte[] bArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, bArr)) == null) {
            return (str == null || str.length() <= 0) ? new byte[]{-1} : encrypt(str.getBytes(Charset.forName("UTF-8")), bArr);
        }
        return (byte[]) invokeLL.objValue;
    }
}
