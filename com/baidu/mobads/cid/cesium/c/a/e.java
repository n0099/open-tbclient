package com.baidu.mobads.cid.cesium.c.a;

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
/* loaded from: classes3.dex */
public final class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public byte[] f8276a;

    /* renamed from: b  reason: collision with root package name */
    public int f8277b;

    /* renamed from: c  reason: collision with root package name */
    public int f8278c;

    /* renamed from: d  reason: collision with root package name */
    public int f8279d;

    /* renamed from: e  reason: collision with root package name */
    public int f8280e;

    /* renamed from: f  reason: collision with root package name */
    public int f8281f;

    /* renamed from: g  reason: collision with root package name */
    public i f8282g;

    /* renamed from: h  reason: collision with root package name */
    public f f8283h;

    /* renamed from: i  reason: collision with root package name */
    public int f8284i;
    public boolean j;

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
        this.f8276a = null;
        this.f8277b = 0;
        this.f8278c = 0;
        this.f8279d = 0;
        this.f8280e = 0;
        this.f8281f = 0;
        this.f8282g = null;
        this.f8283h = null;
        this.f8284i = 1;
        this.j = false;
        this.f8277b = i2;
        this.f8278c = i2;
        this.f8281f = i2;
        this.f8276a = new byte[i2 * 2];
        this.f8283h = new d(bVar);
        this.f8282g = new h(this.f8277b);
    }

    private int a(byte[] bArr, int i2, byte[] bArr2, int i3, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, this, new Object[]{bArr, Integer.valueOf(i2), bArr2, Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            if (bArr == null || i4 == 0) {
                return 0;
            }
            int i5 = this.f8284i;
            if (i5 == 2 || i5 == 3 || i4 % this.f8278c == 0 || i5 == 6) {
                if (this.j) {
                    this.f8283h.d(bArr, i2, i4, bArr2, i3);
                } else {
                    this.f8283h.c(bArr, i2, i4, bArr2, i3);
                }
                return i4;
            } else if (this.f8282g != null) {
                throw new IllegalBlockSizeException("Input length (with padding) not multiple of " + this.f8278c + " bytes");
            } else {
                throw new IllegalBlockSizeException("Input length not multiple of " + this.f8278c + " bytes");
            }
        }
        return invokeCommon.intValue;
    }

    public int a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            int i3 = this.f8279d + i2;
            i iVar = this.f8282g;
            if (iVar == null || this.j) {
                return i3;
            }
            int i4 = this.f8278c;
            int i5 = this.f8277b;
            if (i4 != i5) {
                int i6 = this.f8281f;
                return i3 < i6 ? i6 : (i3 + i5) - ((i3 - i6) % i5);
            }
            return i3 + iVar.a(i3);
        }
        return invokeI.intValue;
    }

    public int a(byte[] bArr, int i2, int i3, byte[] bArr2, int i4) {
        InterceptResult invokeCommon;
        int a2;
        byte[] bArr3;
        int i5;
        i iVar;
        int a3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{bArr, Integer.valueOf(i2), Integer.valueOf(i3), bArr2, Integer.valueOf(i4)})) == null) {
            int i6 = this.f8279d + i3;
            int i7 = this.f8278c;
            int i8 = this.f8277b;
            if (i7 != i8) {
                int i9 = this.f8281f;
                a2 = i6 < i9 ? i9 - i6 : i8 - ((i6 - i9) % i8);
            } else {
                i iVar2 = this.f8282g;
                a2 = iVar2 != null ? iVar2.a(i6) : 0;
            }
            if (a2 > 0 && a2 != this.f8277b && this.f8282g != null && this.j) {
                throw new IllegalBlockSizeException("Input length must be multiple of " + this.f8277b + " when decrypting with padded cipher");
            }
            int i10 = (this.j || this.f8282g == null) ? i6 : i6 + a2;
            if (bArr2 != null) {
                int length = bArr2.length - i4;
                if (((!this.j || this.f8282g == null) && length < i10) || (this.j && length < i10 - this.f8277b)) {
                    throw new ShortBufferException("Output buffer too short: " + length + " bytes given, " + i10 + " bytes needed");
                }
                if (this.f8279d == 0 && (this.j || this.f8282g == null)) {
                    bArr3 = bArr;
                    i5 = i2;
                } else {
                    byte[] bArr4 = new byte[i10];
                    int i11 = this.f8279d;
                    if (i11 != 0) {
                        System.arraycopy(this.f8276a, 0, bArr4, 0, i11);
                    }
                    if (i3 != 0) {
                        System.arraycopy(bArr, i2, bArr4, this.f8279d, i3);
                    }
                    if (!this.j && (iVar = this.f8282g) != null) {
                        iVar.a(bArr4, i6, a2);
                    }
                    bArr3 = bArr4;
                    i5 = 0;
                }
                if (this.j) {
                    if (length < i10) {
                        this.f8283h.b();
                    }
                    byte[] bArr5 = new byte[i6];
                    a3 = a(bArr3, i5, bArr5, 0, i6);
                    i iVar3 = this.f8282g;
                    if (iVar3 != null && (a3 = iVar3.b(bArr5, 0, a3)) < 0) {
                        throw new BadPaddingException("Given final block not properly padded");
                    }
                    if (bArr2.length - i4 < a3) {
                        this.f8283h.c();
                        throw new ShortBufferException("Output buffer too short: " + (bArr2.length - i4) + " bytes given, " + a3 + " bytes needed");
                    }
                    for (int i12 = 0; i12 < a3; i12++) {
                        bArr2[i4 + i12] = bArr5[i12];
                    }
                } else {
                    a3 = a(bArr3, i5, bArr2, i4, i10);
                }
                this.f8279d = 0;
                this.f8281f = this.f8277b;
                if (this.f8284i != 0) {
                    this.f8283h.a();
                }
                return a3;
            }
            throw new ShortBufferException("Output buffer is null");
        }
        return invokeCommon.intValue;
    }

    public void a(int i2, byte[] bArr, byte[] bArr2, SecureRandom secureRandom) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), bArr, bArr2, secureRandom}) == null) {
            boolean z = i2 == 2 || i2 == 4;
            this.j = z;
            if (this.f8284i == 0) {
                if (bArr2 != null) {
                    throw new InvalidAlgorithmParameterException("ECB mode cannot use IV");
                }
            } else if (bArr2 == null) {
                if (z) {
                    throw new InvalidAlgorithmParameterException("Parameters missing");
                }
                if (secureRandom == null) {
                    secureRandom = c.f8271a;
                }
                bArr2 = new byte[this.f8277b];
                secureRandom.nextBytes(bArr2);
            }
            this.f8279d = 0;
            this.f8281f = this.f8277b;
            this.f8283h.a(this.j, "", bArr, bArr2);
        }
    }

    public byte[] a(byte[] bArr, int i2, int i3) {
        InterceptResult invokeLII;
        int a2;
        byte[] bArr2;
        int a3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048579, this, bArr, i2, i3)) == null) {
            byte[] bArr3 = null;
            try {
                a2 = a(i3);
                bArr2 = new byte[a2];
                a3 = a(bArr, i2, i3, bArr2, 0);
            } catch (ShortBufferException unused) {
            }
            if (a3 < a2) {
                bArr3 = new byte[a3];
                if (a3 != 0) {
                    System.arraycopy(bArr2, 0, bArr3, 0, a3);
                }
                return bArr3;
            }
            return bArr2;
        }
        return (byte[]) invokeLII.objValue;
    }
}
