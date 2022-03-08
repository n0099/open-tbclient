package com.alipay.sdk.encrypt;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.security.SecureRandom;
import javax.crypto.Cipher;
/* loaded from: classes3.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
            int i2 = blockSize * 2;
            byte[] bArr = new byte[i2];
            byte[] bArr2 = new byte[blockSize];
            secureRandom.nextBytes(bArr2);
            for (int i3 = 1; i3 < i2; i3++) {
                bArr[i3] = (byte) (str.codePointAt(i3 % str.length()) & 127);
                if (i3 >= blockSize) {
                    bArr[i3] = (byte) (bArr[0] & bArr[i3]);
                }
            }
            System.arraycopy(bArr, blockSize, bArr2, 0, blockSize);
            return bArr2;
        }
        return (byte[]) invokeLL.objValue;
    }
}
