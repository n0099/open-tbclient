package com.baidu.protect.crypto.facect;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public abstract class Cipher {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public Cipher() {
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

    public static Cipher getInstance(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, str2)) == null) {
            if ("WBAES".equals(str)) {
                return WBAESCipherImplement.getInstance(str2);
            }
            throw new RuntimeException("Invalid cipher name:" + str);
        }
        return (Cipher) invokeLL.objValue;
    }

    public abstract boolean decrypt(byte[] bArr, byte[] bArr2, int i);

    public abstract boolean decryptFile(String str, String str2, int i);

    public abstract void doFinal();

    public abstract boolean encrypt(byte[] bArr, byte[] bArr2, int i);

    public abstract boolean encryptFile(String str, String str2, int i);

    public abstract boolean initKeyFromFile(String str, String str2);

    public abstract boolean initKeyFromMemory(byte[] bArr, byte[] bArr2);
}
