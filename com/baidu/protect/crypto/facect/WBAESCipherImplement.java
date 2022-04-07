package com.baidu.protect.crypto.facect;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class WBAESCipherImplement extends Cipher {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "WBAESCipherImplement";
    public static final int WBAES_ERR_ALLOC_MEMORY = -4;
    public static final int WBAES_ERR_CREATE_KEY = -8;
    public static final int WBAES_ERR_FILE_IO = -5;
    public static final int WBAES_ERR_INIT_FAIL = -3;
    public static final int WBAES_ERR_INVALID_LENGTH = -1;
    public static final int WBAES_ERR_INVALID_PARAMETER = -6;
    public static final int WBAES_ERR_INVALID_POINTER = -2;
    public static final int WBAES_ERR_MEMORY_IO = -7;
    public transient /* synthetic */ FieldHolder $fh;
    public long context;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1413464634, "Lcom/baidu/protect/crypto/facect/WBAESCipherImplement;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1413464634, "Lcom/baidu/protect/crypto/facect/WBAESCipherImplement;");
                return;
            }
        }
        System.loadLibrary("baiduprotect_sec_jni_facect");
    }

    public WBAESCipherImplement() {
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

    private native int decrypt(long j, byte[] bArr, byte[] bArr2, int i);

    private native int decryptFile(long j, String str, String str2, int i);

    private native int destroyContext(long j);

    private native int encrypt(long j, byte[] bArr, byte[] bArr2, int i);

    private native int encryptFile(long j, String str, String str2, int i);

    public static Cipher getInstance(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) ? new WBAESCipherImplement() : (Cipher) invokeL.objValue;
    }

    private native long initKeyDataFile(String str, String str2);

    private native long initKeyDataMemory(byte[] bArr, byte[] bArr2);

    private boolean isValidContext(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(65546, this, j)) == null) ? (j == -2 || j == -7 || j == 0) ? false : true : invokeJ.booleanValue;
    }

    @Override // com.baidu.protect.crypto.facect.Cipher
    public boolean decrypt(byte[] bArr, byte[] bArr2, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048576, this, bArr, bArr2, i)) == null) {
            if (isValidContext(this.context)) {
                int decrypt = decrypt(this.context, bArr, bArr2, i);
                if (decrypt == -2 || decrypt == -1) {
                    throw new WBAESException("invalid param");
                }
                if (decrypt == 0) {
                    return true;
                }
                throw new WBAESException("decrypt fail reason:" + decrypt);
            }
            return false;
        }
        return invokeLLI.booleanValue;
    }

    @Override // com.baidu.protect.crypto.facect.Cipher
    public boolean decryptFile(String str, String str2, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, i)) == null) {
            if (isValidContext(this.context)) {
                int decryptFile = decryptFile(this.context, str, str2, i);
                if (decryptFile == -2 || decryptFile == -1) {
                    throw new WBAESException("invalid param");
                }
                if (decryptFile == 0) {
                    return true;
                }
                throw new WBAESException("decrypt fail reason:" + decryptFile);
            }
            return false;
        }
        return invokeLLI.booleanValue;
    }

    @Override // com.baidu.protect.crypto.facect.Cipher
    public void doFinal() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && isValidContext(this.context)) {
            destroyContext(this.context);
        }
    }

    @Override // com.baidu.protect.crypto.facect.Cipher
    public boolean encrypt(byte[] bArr, byte[] bArr2, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048579, this, bArr, bArr2, i)) == null) {
            if (isValidContext(this.context)) {
                int encrypt = encrypt(this.context, bArr, bArr2, i);
                if (encrypt == -2 || encrypt == -1) {
                    throw new WBAESException("invalid param");
                }
                if (encrypt == 0) {
                    return true;
                }
                throw new WBAESException("decrypt fail reason:" + encrypt);
            }
            return false;
        }
        return invokeLLI.booleanValue;
    }

    @Override // com.baidu.protect.crypto.facect.Cipher
    public boolean encryptFile(String str, String str2, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048580, this, str, str2, i)) == null) {
            if (isValidContext(this.context)) {
                int encryptFile = encryptFile(this.context, str, str2, i);
                if (encryptFile == -2 || encryptFile == -1) {
                    throw new WBAESException("invalid param");
                }
                if (encryptFile == 0) {
                    return true;
                }
                throw new WBAESException("decrypt fail reason:" + encryptFile);
            }
            return false;
        }
        return invokeLLI.booleanValue;
    }

    @Override // com.baidu.protect.crypto.facect.Cipher
    public boolean initKeyFromFile(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, str2)) == null) {
            long initKeyDataFile = initKeyDataFile(str, str2);
            this.context = initKeyDataFile;
            return isValidContext(initKeyDataFile);
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.protect.crypto.facect.Cipher
    public boolean initKeyFromMemory(byte[] bArr, byte[] bArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, bArr, bArr2)) == null) {
            long initKeyDataMemory = initKeyDataMemory(bArr, bArr2);
            this.context = initKeyDataMemory;
            return isValidContext(initKeyDataMemory);
        }
        return invokeLL.booleanValue;
    }
}
