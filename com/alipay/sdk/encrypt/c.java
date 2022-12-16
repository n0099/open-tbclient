package com.alipay.sdk.encrypt;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.security.SecureRandom;
import javax.crypto.Cipher;
/* loaded from: classes.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static byte[] a(Cipher cipher, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, cipher, str)) == null) {
            SecureRandom secureRandom = new SecureRandom();
            int blockSize = cipher.getBlockSize();
            if (TextUtils.isEmpty(str)) {
                str = String.valueOf(secureRandom.nextDouble());
            }
            int i = blockSize * 2;
            byte[] bArr = new byte[i];
            byte[] bArr2 = new byte[blockSize];
            secureRandom.nextBytes(bArr2);
            for (int i2 = 1; i2 < i; i2++) {
                bArr[i2] = (byte) (str.codePointAt(i2 % str.length()) & 127);
                if (i2 >= blockSize) {
                    bArr[i2] = (byte) (bArr[0] & bArr[i2]);
                }
            }
            System.arraycopy(bArr, blockSize, bArr2, 0, blockSize);
            return bArr2;
        }
        return (byte[]) invokeLL.objValue;
    }
}
