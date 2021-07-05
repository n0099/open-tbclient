package com.baidu.mobads.cid.cesium.c.d;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
/* loaded from: classes3.dex */
public final class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final byte[] f8302a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public int f8303b;

    /* renamed from: c  reason: collision with root package name */
    public String f8304c;

    /* renamed from: d  reason: collision with root package name */
    public f f8305d;

    /* renamed from: e  reason: collision with root package name */
    public byte[] f8306e;

    /* renamed from: f  reason: collision with root package name */
    public int f8307f;

    /* renamed from: g  reason: collision with root package name */
    public int f8308g;

    /* renamed from: h  reason: collision with root package name */
    public d f8309h;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1962342124, "Lcom/baidu/mobads/cid/cesium/c/d/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1962342124, "Lcom/baidu/mobads/cid/cesium/c/d/c;");
                return;
            }
        }
        f8302a = new byte[0];
    }

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f8304c = "PKCS1Padding";
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x008e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(int i2, d dVar, SecureRandom secureRandom, AlgorithmParameterSpec algorithmParameterSpec) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeCommon(65538, this, new Object[]{Integer.valueOf(i2), dVar, secureRandom, algorithmParameterSpec}) != null) {
            return;
        }
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 != 4) {
                        throw new InvalidKeyException("Unknown mode: " + i2);
                    }
                }
            }
            z = false;
            if (dVar instanceof d) {
                throw new InvalidKeyException("only support helios key");
            }
            this.f8303b = z ? 1 : 4;
            this.f8309h = dVar;
            int a2 = b.a(dVar.a());
            this.f8308g = a2;
            this.f8307f = 0;
            String str = this.f8304c;
            if (str == "NoPadding") {
                if (algorithmParameterSpec != null) {
                    throw new InvalidAlgorithmParameterException("Parameters not supported");
                }
                this.f8305d = f.a(3, a2, secureRandom);
                this.f8306e = new byte[a2];
                return;
            } else if (str != "PKCS1Padding") {
                throw new InvalidKeyException("OAEP not supported");
            } else {
                if (algorithmParameterSpec != null) {
                    throw new InvalidAlgorithmParameterException("Parameters not supported");
                }
                f a3 = f.a(this.f8303b > 2 ? 1 : 2, a2, secureRandom);
                this.f8305d = a3;
                if (z) {
                    this.f8306e = new byte[a3.a()];
                    return;
                } else {
                    this.f8306e = new byte[a2];
                    return;
                }
            }
        }
        z = true;
        if (dVar instanceof d) {
        }
    }

    private byte[] a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            int i2 = this.f8307f;
            byte[] bArr = this.f8306e;
            if (i2 > bArr.length) {
                throw new IllegalBlockSizeException("Data must not be longer than " + this.f8306e.length + " bytes");
            }
            try {
                int i3 = this.f8303b;
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 != 3) {
                            if (i3 == 4) {
                                return this.f8305d.b(b.a(b.a(bArr, 0, i2), this.f8309h));
                            }
                            throw new AssertionError("Internal error");
                        }
                        throw new UnsupportedOperationException("only verify supported");
                    }
                    throw new UnsupportedOperationException("only verify supported");
                }
                return b.a(this.f8305d.a(bArr, 0, i2), this.f8309h);
            } finally {
                this.f8307f = 0;
            }
        }
        return (byte[]) invokeV.objValue;
    }

    private void b(byte[] bArr, int i2, int i3) {
        int i4;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(65540, this, bArr, i2, i3) == null) || i3 == 0 || bArr == null) {
            return;
        }
        int i5 = this.f8307f;
        int i6 = i5 + i3;
        byte[] bArr2 = this.f8306e;
        if (i6 > bArr2.length) {
            i4 = bArr2.length + 1;
        } else {
            System.arraycopy(bArr, i2, bArr2, i5, i3);
            i4 = this.f8307f + i3;
        }
        this.f8307f = i4;
    }

    public void a(int i2, d dVar, SecureRandom secureRandom) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048576, this, i2, dVar, secureRandom) == null) {
            try {
                a(i2, dVar, secureRandom, null);
            } catch (InvalidAlgorithmParameterException e2) {
                InvalidKeyException invalidKeyException = new InvalidKeyException("Wrong parameters");
                invalidKeyException.initCause(e2);
                throw invalidKeyException;
            }
        }
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            String str2 = "NoPadding";
            if (!str.equalsIgnoreCase("NoPadding")) {
                str2 = "PKCS1Padding";
                if (!str.equalsIgnoreCase("PKCS1Padding")) {
                    throw new NoSuchPaddingException("Padding " + str + " not supported");
                }
            }
            this.f8304c = str2;
        }
    }

    public byte[] a(byte[] bArr, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(Constants.METHOD_SEND_USER_MSG, this, bArr, i2, i3)) == null) {
            b(bArr, i2, i3);
            return a();
        }
        return (byte[]) invokeLII.objValue;
    }
}
