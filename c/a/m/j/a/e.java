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
    public int f3795b;

    /* renamed from: c  reason: collision with root package name */
    public int f3796c;

    /* renamed from: d  reason: collision with root package name */
    public int f3797d;

    /* renamed from: e  reason: collision with root package name */
    public int f3798e;

    /* renamed from: f  reason: collision with root package name */
    public i f3799f;

    /* renamed from: g  reason: collision with root package name */
    public f f3800g;

    /* renamed from: h  reason: collision with root package name */
    public int f3801h;
    public boolean i;

    public e(b bVar, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
        this.f3795b = 0;
        this.f3796c = 0;
        this.f3797d = 0;
        this.f3798e = 0;
        this.f3799f = null;
        this.f3800g = null;
        this.f3801h = 1;
        this.i = false;
        this.f3795b = i;
        this.f3796c = i;
        this.f3798e = i;
        this.a = new byte[i * 2];
        this.f3800g = new d(bVar);
        this.f3799f = new h(this.f3795b);
    }

    public int a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            int i2 = this.f3797d + i;
            i iVar = this.f3799f;
            if (iVar == null || this.i) {
                return i2;
            }
            int i3 = this.f3796c;
            int i4 = this.f3795b;
            if (i3 != i4) {
                int i5 = this.f3798e;
                return i2 < i5 ? i5 : (i2 + i4) - ((i2 - i5) % i4);
            }
            return i2 + iVar.a(i2);
        }
        return invokeI.intValue;
    }

    public int b(byte[] bArr, int i, int i2, byte[] bArr2, int i3) throws IllegalBlockSizeException, ShortBufferException, BadPaddingException {
        InterceptResult invokeCommon;
        int a;
        byte[] bArr3;
        int i4;
        i iVar;
        int c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{bArr, Integer.valueOf(i), Integer.valueOf(i2), bArr2, Integer.valueOf(i3)})) == null) {
            int i5 = this.f3797d + i2;
            int i6 = this.f3796c;
            int i7 = this.f3795b;
            if (i6 != i7) {
                int i8 = this.f3798e;
                a = i5 < i8 ? i8 - i5 : i7 - ((i5 - i8) % i7);
            } else {
                i iVar2 = this.f3799f;
                a = iVar2 != null ? iVar2.a(i5) : 0;
            }
            if (a > 0 && a != this.f3795b && this.f3799f != null && this.i) {
                throw new IllegalBlockSizeException("Input length must be multiple of " + this.f3795b + " when decrypting with padded cipher");
            }
            int i9 = (this.i || this.f3799f == null) ? i5 : i5 + a;
            if (bArr2 != null) {
                int length = bArr2.length - i3;
                if (((!this.i || this.f3799f == null) && length < i9) || (this.i && length < i9 - this.f3795b)) {
                    throw new ShortBufferException("Output buffer too short: " + length + " bytes given, " + i9 + " bytes needed");
                }
                if (this.f3797d == 0 && (this.i || this.f3799f == null)) {
                    bArr3 = bArr;
                    i4 = i;
                } else {
                    byte[] bArr4 = new byte[i9];
                    int i10 = this.f3797d;
                    if (i10 != 0) {
                        System.arraycopy(this.a, 0, bArr4, 0, i10);
                    }
                    if (i2 != 0) {
                        System.arraycopy(bArr, i, bArr4, this.f3797d, i2);
                    }
                    if (!this.i && (iVar = this.f3799f) != null) {
                        iVar.b(bArr4, i5, a);
                    }
                    bArr3 = bArr4;
                    i4 = 0;
                }
                if (this.i) {
                    if (length < i9) {
                        this.f3800g.h();
                    }
                    byte[] bArr5 = new byte[i5];
                    c2 = c(bArr3, i4, bArr5, 0, i5);
                    i iVar3 = this.f3799f;
                    if (iVar3 != null && (c2 = iVar3.a(bArr5, 0, c2)) < 0) {
                        throw new BadPaddingException("Given final block not properly padded");
                    }
                    if (bArr2.length - i3 < c2) {
                        this.f3800g.g();
                        throw new ShortBufferException("Output buffer too short: " + (bArr2.length - i3) + " bytes given, " + c2 + " bytes needed");
                    }
                    for (int i11 = 0; i11 < c2; i11++) {
                        bArr2[i3 + i11] = bArr5[i11];
                    }
                } else {
                    c2 = c(bArr3, i4, bArr2, i3, i9);
                }
                this.f3797d = 0;
                this.f3798e = this.f3795b;
                if (this.f3801h != 0) {
                    this.f3800g.f();
                }
                return c2;
            }
            throw new ShortBufferException("Output buffer is null");
        }
        return invokeCommon.intValue;
    }

    public final int c(byte[] bArr, int i, byte[] bArr2, int i2, int i3) throws IllegalBlockSizeException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{bArr, Integer.valueOf(i), bArr2, Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
            if (bArr == null || i3 == 0) {
                return 0;
            }
            int i4 = this.f3801h;
            if (i4 == 2 || i4 == 3 || i3 % this.f3796c == 0 || i4 == 6) {
                if (this.i) {
                    this.f3800g.c(bArr, i, i3, bArr2, i2);
                } else {
                    this.f3800g.e(bArr, i, i3, bArr2, i2);
                }
                return i3;
            } else if (this.f3799f != null) {
                throw new IllegalBlockSizeException("Input length (with padding) not multiple of " + this.f3796c + " bytes");
            } else {
                throw new IllegalBlockSizeException("Input length not multiple of " + this.f3796c + " bytes");
            }
        }
        return invokeCommon.intValue;
    }

    public void d(int i, byte[] bArr, byte[] bArr2, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), bArr, bArr2, secureRandom}) == null) {
            boolean z = i == 2 || i == 4;
            this.i = z;
            if (this.f3801h == 0) {
                if (bArr2 != null) {
                    throw new InvalidAlgorithmParameterException("ECB mode cannot use IV");
                }
            } else if (bArr2 == null) {
                if (z) {
                    throw new InvalidAlgorithmParameterException("Parameters missing");
                }
                if (secureRandom == null) {
                    secureRandom = c.f3791b;
                }
                bArr2 = new byte[this.f3795b];
                secureRandom.nextBytes(bArr2);
            }
            this.f3797d = 0;
            this.f3798e = this.f3795b;
            this.f3800g.a(this.i, "", bArr, bArr2);
        }
    }

    public byte[] e(byte[] bArr, int i, int i2) throws IllegalBlockSizeException, BadPaddingException {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048580, this, bArr, i, i2)) == null) {
            try {
                int a = a(i2);
                byte[] bArr2 = new byte[a];
                int b2 = b(bArr, i, i2, bArr2, 0);
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
