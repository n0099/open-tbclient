package com.baidu.protect.crypto;

import c.a.g0.a.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class WBAESCipherImplement extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f44337a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(146567815, "Lcom/baidu/protect/crypto/WBAESCipherImplement;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(146567815, "Lcom/baidu/protect/crypto/WBAESCipherImplement;");
                return;
            }
        }
        System.loadLibrary("baiduprotect_sec_jni");
    }

    public WBAESCipherImplement() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static a c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? new WBAESCipherImplement() : (a) invokeV.objValue;
    }

    private native int decrypt(long j2, byte[] bArr, byte[] bArr2, int i2);

    private native int decryptFile(long j2, String str, String str2, int i2);

    private native int destroyContext(long j2);

    private native int encrypt(long j2, byte[] bArr, byte[] bArr2, int i2);

    private native int encryptFile(long j2, String str, String str2, int i2);

    private native long initKeyDataFile(String str, String str2);

    private native long initKeyDataMemory(byte[] bArr, byte[] bArr2);

    @Override // c.a.g0.a.a
    public final boolean a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bArr)) == null) {
            long initKeyDataMemory = initKeyDataMemory(bArr, null);
            this.f44337a = initKeyDataMemory;
            return initKeyDataMemory > 0;
        }
        return invokeL.booleanValue;
    }

    @Override // c.a.g0.a.a
    public final boolean b(byte[] bArr, byte[] bArr2, int i2) throws b {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bArr, bArr2, i2)) == null) {
            long j2 = this.f44337a;
            if (j2 <= 0) {
                return false;
            }
            int encrypt = encrypt(j2, bArr, bArr2, i2);
            if (encrypt == -2 || encrypt == -1) {
                throw new b("invalid param");
            }
            if (encrypt == 0) {
                return true;
            }
            throw new b("decrypt fail reason:" + encrypt);
        }
        return invokeLLI.booleanValue;
    }
}
