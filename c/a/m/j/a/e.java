package c.a.m.j.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.SecureRandom;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.ShortBufferException;
/* loaded from: classes.dex */
public final class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public byte[] a;

    /* renamed from: b  reason: collision with root package name */
    public int f4212b;

    /* renamed from: c  reason: collision with root package name */
    public int f4213c;

    /* renamed from: d  reason: collision with root package name */
    public int f4214d;

    /* renamed from: e  reason: collision with root package name */
    public int f4215e;

    /* renamed from: f  reason: collision with root package name */
    public i f4216f;

    /* renamed from: g  reason: collision with root package name */
    public f f4217g;

    /* renamed from: h  reason: collision with root package name */
    public int f4218h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f4219i;

    public e(b bVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
        this.f4212b = 0;
        this.f4213c = 0;
        this.f4214d = 0;
        this.f4215e = 0;
        this.f4216f = null;
        this.f4217g = null;
        this.f4218h = 1;
        this.f4219i = false;
        this.f4212b = i2;
        this.f4213c = i2;
        this.f4215e = i2;
        this.a = new byte[i2 * 2];
        this.f4217g = new d(bVar);
        this.f4216f = new h(this.f4212b);
    }

    public int a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            int i3 = this.f4214d + i2;
            i iVar = this.f4216f;
            if (iVar == null || this.f4219i) {
                return i3;
            }
            int i4 = this.f4213c;
            int i5 = this.f4212b;
            if (i4 != i5) {
                int i6 = this.f4215e;
                return i3 < i6 ? i6 : (i3 + i5) - ((i3 - i6) % i5);
            }
            return i3 + iVar.a(i3);
        }
        return invokeI.intValue;
    }

    public int b(byte[] bArr, int i2, int i3, byte[] bArr2, int i4) throws IllegalBlockSizeException, ShortBufferException, BadPaddingException {
        InterceptResult invokeCommon;
        int a;
        byte[] bArr3;
        int i5;
        i iVar;
        int c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{bArr, Integer.valueOf(i2), Integer.valueOf(i3), bArr2, Integer.valueOf(i4)})) == null) {
            int i6 = this.f4214d + i3;
            int i7 = this.f4213c;
            int i8 = this.f4212b;
            if (i7 != i8) {
                int i9 = this.f4215e;
                a = i6 < i9 ? i9 - i6 : i8 - ((i6 - i9) % i8);
            } else {
                i iVar2 = this.f4216f;
                a = iVar2 != null ? iVar2.a(i6) : 0;
            }
            if (a > 0 && a != this.f4212b && this.f4216f != null && this.f4219i) {
                throw new IllegalBlockSizeException("Input length must be multiple of " + this.f4212b + " when decrypting with padded cipher");
            }
            int i10 = (this.f4219i || this.f4216f == null) ? i6 : i6 + a;
            if (bArr2 != null) {
                int length = bArr2.length - i4;
                if (((!this.f4219i || this.f4216f == null) && length < i10) || (this.f4219i && length < i10 - this.f4212b)) {
                    throw new ShortBufferException("Output buffer too short: " + length + " bytes given, " + i10 + " bytes needed");
                }
                if (this.f4214d == 0 && (this.f4219i || this.f4216f == null)) {
                    bArr3 = bArr;
                    i5 = i2;
                } else {
                    byte[] bArr4 = new byte[i10];
                    int i11 = this.f4214d;
                    if (i11 != 0) {
                        System.arraycopy(this.a, 0, bArr4, 0, i11);
                    }
                    if (i3 != 0) {
                        System.arraycopy(bArr, i2, bArr4, this.f4214d, i3);
                    }
                    if (!this.f4219i && (iVar = this.f4216f) != null) {
                        iVar.b(bArr4, i6, a);
                    }
                    bArr3 = bArr4;
                    i5 = 0;
                }
                if (this.f4219i) {
                    if (length < i10) {
                        this.f4217g.h();
                    }
                    byte[] bArr5 = new byte[i6];
                    c2 = c(bArr3, i5, bArr5, 0, i6);
                    i iVar3 = this.f4216f;
                    if (iVar3 != null && (c2 = iVar3.a(bArr5, 0, c2)) < 0) {
                        throw new BadPaddingException("Given final block not properly padded");
                    }
                    if (bArr2.length - i4 < c2) {
                        this.f4217g.g();
                        throw new ShortBufferException("Output buffer too short: " + (bArr2.length - i4) + " bytes given, " + c2 + " bytes needed");
                    }
                    for (int i12 = 0; i12 < c2; i12++) {
                        bArr2[i4 + i12] = bArr5[i12];
                    }
                } else {
                    c2 = c(bArr3, i5, bArr2, i4, i10);
                }
                this.f4214d = 0;
                this.f4215e = this.f4212b;
                if (this.f4218h != 0) {
                    this.f4217g.f();
                }
                return c2;
            }
            throw new ShortBufferException("Output buffer is null");
        }
        return invokeCommon.intValue;
    }

    public final int c(byte[] bArr, int i2, byte[] bArr2, int i3, int i4) throws IllegalBlockSizeException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{bArr, Integer.valueOf(i2), bArr2, Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            if (bArr == null || i4 == 0) {
                return 0;
            }
            int i5 = this.f4218h;
            if (i5 == 2 || i5 == 3 || i4 % this.f4213c == 0 || i5 == 6) {
                if (this.f4219i) {
                    this.f4217g.c(bArr, i2, i4, bArr2, i3);
                } else {
                    this.f4217g.e(bArr, i2, i4, bArr2, i3);
                }
                return i4;
            } else if (this.f4216f != null) {
                throw new IllegalBlockSizeException("Input length (with padding) not multiple of " + this.f4213c + " bytes");
            } else {
                throw new IllegalBlockSizeException("Input length not multiple of " + this.f4213c + " bytes");
            }
        }
        return invokeCommon.intValue;
    }

    public void d(int i2, byte[] bArr, byte[] bArr2, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), bArr, bArr2, secureRandom}) == null) {
            boolean z = i2 == 2 || i2 == 4;
            this.f4219i = z;
            if (this.f4218h == 0) {
                if (bArr2 != null) {
                    throw new InvalidAlgorithmParameterException("ECB mode cannot use IV");
                }
            } else if (bArr2 == null) {
                if (z) {
                    throw new InvalidAlgorithmParameterException("Parameters missing");
                }
                if (secureRandom == null) {
                    secureRandom = c.f4208b;
                }
                bArr2 = new byte[this.f4212b];
                secureRandom.nextBytes(bArr2);
            }
            this.f4214d = 0;
            this.f4215e = this.f4212b;
            this.f4217g.a(this.f4219i, "", bArr, bArr2);
        }
    }

    public byte[] e(byte[] bArr, int i2, int i3) throws IllegalBlockSizeException, BadPaddingException {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048580, this, bArr, i2, i3)) == null) {
            try {
                int a = a(i3);
                byte[] bArr2 = new byte[a];
                int b2 = b(bArr, i2, i3, bArr2, 0);
                if (b2 < a) {
                    byte[] bArr3 = new byte[b2];
                    if (b2 != 0) {
                        try {
                            System.arraycopy(bArr2, 0, bArr3, 0, b2);
                        } catch (ShortBufferException unused) {
                        }
                    }
                    return bArr3;
                }
                return bArr2;
            } catch (ShortBufferException unused2) {
                return null;
            }
        }
        return (byte[]) invokeLII.objValue;
    }
}
