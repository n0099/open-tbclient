package c.a.m.d.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.security.InvalidAlgorithmParameterException;
import java.security.SecureRandom;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.ShortBufferException;
/* loaded from: classes.dex */
public final class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public byte[] f4001a;

    /* renamed from: b  reason: collision with root package name */
    public int f4002b;

    /* renamed from: c  reason: collision with root package name */
    public int f4003c;

    /* renamed from: d  reason: collision with root package name */
    public int f4004d;

    /* renamed from: e  reason: collision with root package name */
    public int f4005e;

    /* renamed from: f  reason: collision with root package name */
    public i f4006f;

    /* renamed from: g  reason: collision with root package name */
    public f f4007g;

    /* renamed from: h  reason: collision with root package name */
    public int f4008h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f4009i;

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
        this.f4001a = null;
        this.f4002b = 0;
        this.f4003c = 0;
        this.f4004d = 0;
        this.f4005e = 0;
        this.f4006f = null;
        this.f4007g = null;
        this.f4008h = 1;
        this.f4009i = false;
        this.f4002b = i2;
        this.f4003c = i2;
        this.f4005e = i2;
        this.f4001a = new byte[i2 * 2];
        this.f4007g = new d(bVar);
        this.f4006f = new h(this.f4002b);
    }

    public int a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            int i3 = this.f4004d + i2;
            i iVar = this.f4006f;
            if (iVar == null || this.f4009i) {
                return i3;
            }
            int i4 = this.f4003c;
            int i5 = this.f4002b;
            if (i4 != i5) {
                int i6 = this.f4005e;
                return i3 < i6 ? i6 : (i3 + i5) - ((i3 - i6) % i5);
            }
            return i3 + iVar.a(i3);
        }
        return invokeI.intValue;
    }

    public final int b(byte[] bArr, int i2, byte[] bArr2, int i3, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{bArr, Integer.valueOf(i2), bArr2, Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            if (bArr == null || i4 == 0) {
                return 0;
            }
            int i5 = this.f4008h;
            if (i5 == 2 || i5 == 3 || i4 % this.f4003c == 0 || i5 == 6) {
                if (this.f4009i) {
                    this.f4007g.h(bArr, i2, i4, bArr2, i3);
                } else {
                    this.f4007g.f(bArr, i2, i4, bArr2, i3);
                }
                return i4;
            } else if (this.f4006f != null) {
                throw new IllegalBlockSizeException("Input length (with padding) not multiple of " + this.f4003c + " bytes");
            } else {
                throw new IllegalBlockSizeException("Input length not multiple of " + this.f4003c + " bytes");
            }
        }
        return invokeCommon.intValue;
    }

    public void c(int i2, byte[] bArr, byte[] bArr2, SecureRandom secureRandom) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), bArr, bArr2, secureRandom}) == null) {
            boolean z = i2 == 2 || i2 == 4;
            this.f4009i = z;
            if (this.f4008h == 0) {
                if (bArr2 != null) {
                    throw new InvalidAlgorithmParameterException("ECB mode cannot use IV");
                }
            } else if (bArr2 == null) {
                if (z) {
                    throw new InvalidAlgorithmParameterException("Parameters missing");
                }
                if (secureRandom == null) {
                    secureRandom = c.f3996b;
                }
                bArr2 = new byte[this.f4002b];
                secureRandom.nextBytes(bArr2);
            }
            this.f4004d = 0;
            this.f4005e = this.f4002b;
            this.f4007g.a(this.f4009i, "", bArr, bArr2);
        }
    }

    public int d(byte[] bArr, int i2, int i3, byte[] bArr2, int i4) {
        InterceptResult invokeCommon;
        int a2;
        byte[] bArr3;
        int i5;
        i iVar;
        int b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{bArr, Integer.valueOf(i2), Integer.valueOf(i3), bArr2, Integer.valueOf(i4)})) == null) {
            int i6 = this.f4004d + i3;
            int i7 = this.f4003c;
            int i8 = this.f4002b;
            if (i7 != i8) {
                int i9 = this.f4005e;
                a2 = i6 < i9 ? i9 - i6 : i8 - ((i6 - i9) % i8);
            } else {
                i iVar2 = this.f4006f;
                a2 = iVar2 != null ? iVar2.a(i6) : 0;
            }
            if (a2 > 0 && a2 != this.f4002b && this.f4006f != null && this.f4009i) {
                throw new IllegalBlockSizeException("Input length must be multiple of " + this.f4002b + " when decrypting with padded cipher");
            }
            int i10 = (this.f4009i || this.f4006f == null) ? i6 : i6 + a2;
            if (bArr2 != null) {
                int length = bArr2.length - i4;
                if (((!this.f4009i || this.f4006f == null) && length < i10) || (this.f4009i && length < i10 - this.f4002b)) {
                    throw new ShortBufferException("Output buffer too short: " + length + " bytes given, " + i10 + " bytes needed");
                }
                if (this.f4004d == 0 && (this.f4009i || this.f4006f == null)) {
                    bArr3 = bArr;
                    i5 = i2;
                } else {
                    byte[] bArr4 = new byte[i10];
                    int i11 = this.f4004d;
                    if (i11 != 0) {
                        System.arraycopy(this.f4001a, 0, bArr4, 0, i11);
                    }
                    if (i3 != 0) {
                        System.arraycopy(bArr, i2, bArr4, this.f4004d, i3);
                    }
                    if (!this.f4009i && (iVar = this.f4006f) != null) {
                        iVar.a(bArr4, i6, a2);
                    }
                    bArr3 = bArr4;
                    i5 = 0;
                }
                if (this.f4009i) {
                    if (length < i10) {
                        this.f4007g.e();
                    }
                    byte[] bArr5 = new byte[i6];
                    b2 = b(bArr3, i5, bArr5, 0, i6);
                    i iVar3 = this.f4006f;
                    if (iVar3 != null && (b2 = iVar3.b(bArr5, 0, b2)) < 0) {
                        throw new BadPaddingException("Given final block not properly padded");
                    }
                    if (bArr2.length - i4 < b2) {
                        this.f4007g.g();
                        throw new ShortBufferException("Output buffer too short: " + (bArr2.length - i4) + " bytes given, " + b2 + " bytes needed");
                    }
                    for (int i12 = 0; i12 < b2; i12++) {
                        bArr2[i4 + i12] = bArr5[i12];
                    }
                } else {
                    b2 = b(bArr3, i5, bArr2, i4, i10);
                }
                this.f4004d = 0;
                this.f4005e = this.f4002b;
                if (this.f4008h != 0) {
                    this.f4007g.c();
                }
                return b2;
            }
            throw new ShortBufferException("Output buffer is null");
        }
        return invokeCommon.intValue;
    }

    public byte[] e(byte[] bArr, int i2, int i3) {
        InterceptResult invokeLII;
        int a2;
        byte[] bArr2;
        int d2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048580, this, bArr, i2, i3)) == null) {
            byte[] bArr3 = null;
            try {
                a2 = a(i3);
                bArr2 = new byte[a2];
                d2 = d(bArr, i2, i3, bArr2, 0);
            } catch (ShortBufferException unused) {
            }
            if (d2 < a2) {
                bArr3 = new byte[d2];
                if (d2 != 0) {
                    System.arraycopy(bArr2, 0, bArr3, 0, d2);
                }
                return bArr3;
            }
            return bArr2;
        }
        return (byte[]) invokeLII.objValue;
    }
}
