package c.a.i0.a.f;

import android.graphics.Bitmap;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
/* loaded from: classes.dex */
public class b extends Thread {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public Bitmap B;
    public Bitmap C;
    public c D;
    public boolean E;
    public byte[] F;
    public int G;
    public int H;
    public int I;
    public boolean J;
    public int K;
    public int L;
    public short[] M;
    public byte[] N;
    public byte[] O;
    public byte[] P;
    public c Q;
    public int R;
    public a S;
    public byte[] T;

    /* renamed from: e  reason: collision with root package name */
    public InputStream f3593e;

    /* renamed from: f  reason: collision with root package name */
    public int f3594f;

    /* renamed from: g  reason: collision with root package name */
    public int f3595g;

    /* renamed from: h  reason: collision with root package name */
    public int f3596h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f3597i;

    /* renamed from: j  reason: collision with root package name */
    public int f3598j;
    public int[] k;
    public int[] l;
    public int[] m;
    public int n;
    public int o;
    public int p;
    public boolean q;
    public boolean r;
    public int s;
    public int t;
    public int u;
    public int v;
    public int w;
    public int x;
    public int y;
    public int z;

    public b(byte[] bArr, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bArr, aVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.D = null;
        this.E = false;
        this.F = new byte[256];
        this.G = 0;
        this.H = 0;
        this.I = 0;
        this.J = false;
        this.K = 0;
        this.S = null;
        this.T = null;
        this.T = bArr;
        this.S = aVar;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:80:0x00c4 */
    /* JADX DEBUG: Multi-variable search result rejected for r2v25, resolved type: short */
    /* JADX WARN: Multi-variable type inference failed */
    public final void a() {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        short s;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            int i7 = this.v * this.w;
            byte[] bArr = this.P;
            if (bArr == null || bArr.length < i7) {
                this.P = new byte[i7];
            }
            if (this.M == null) {
                this.M = new short[4096];
            }
            if (this.N == null) {
                this.N = new byte[4096];
            }
            if (this.O == null) {
                this.O = new byte[4097];
            }
            int j2 = j();
            int i8 = 1 << j2;
            int i9 = i8 + 1;
            int i10 = i8 + 2;
            int i11 = j2 + 1;
            int i12 = (1 << i11) - 1;
            for (int i13 = 0; i13 < i8; i13++) {
                this.M[i13] = 0;
                this.N[i13] = (byte) i13;
            }
            int i14 = i11;
            int i15 = i10;
            int i16 = i12;
            int i17 = -1;
            int i18 = 0;
            int i19 = 0;
            int i20 = 0;
            int i21 = 0;
            int i22 = 0;
            int i23 = 0;
            int i24 = 0;
            int i25 = 0;
            while (i18 < i7) {
                if (i19 != 0) {
                    i2 = i11;
                    i3 = i9;
                    int i26 = i24;
                    i4 = i8;
                    i5 = i26;
                } else if (i20 >= i14) {
                    int i27 = i21 & i16;
                    i21 >>= i14;
                    i20 -= i14;
                    if (i27 > i15 || i27 == i9) {
                        break;
                    } else if (i27 == i8) {
                        i14 = i11;
                        i15 = i10;
                        i16 = i12;
                        i17 = -1;
                    } else if (i17 == -1) {
                        this.O[i19] = this.N[i27];
                        i17 = i27;
                        i24 = i17;
                        i19++;
                        i11 = i11;
                    } else {
                        i2 = i11;
                        if (i27 == i15) {
                            i6 = i27;
                            this.O[i19] = (byte) i24;
                            s = i17;
                            i19++;
                        } else {
                            i6 = i27;
                            s = i6;
                        }
                        while (s > i8) {
                            this.O[i19] = this.N[s];
                            s = this.M[s];
                            i19++;
                            i8 = i8;
                        }
                        i4 = i8;
                        byte[] bArr2 = this.N;
                        i5 = bArr2[s] & 255;
                        if (i15 >= 4096) {
                            break;
                        }
                        int i28 = i19 + 1;
                        i3 = i9;
                        byte b2 = (byte) i5;
                        this.O[i19] = b2;
                        this.M[i15] = (short) i17;
                        bArr2[i15] = b2;
                        i15++;
                        if ((i15 & i16) == 0 && i15 < 4096) {
                            i14++;
                            i16 += i15;
                        }
                        i19 = i28;
                        i17 = i6;
                    }
                } else {
                    if (i22 == 0) {
                        i22 = k();
                        if (i22 <= 0) {
                            break;
                        }
                        i23 = 0;
                    }
                    i21 += (this.F[i23] & 255) << i20;
                    i20 += 8;
                    i23++;
                    i22--;
                }
                i19--;
                this.P[i25] = this.O[i19];
                i18++;
                i25++;
                i8 = i4;
                i9 = i3;
                i24 = i5;
                i11 = i2;
            }
            for (int i29 = i25; i29 < i7; i29++) {
                this.P[i29] = 0;
            }
        }
    }

    public final boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f3594f != 0 : invokeV.booleanValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c cVar = this.Q;
            while (cVar != null) {
                cVar.f3599a = null;
                cVar = this.Q.f3601c;
                this.Q = cVar;
            }
            InputStream inputStream = this.f3593e;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception unused) {
                }
                this.f3593e = null;
            }
            this.T = null;
        }
    }

    public c d(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            c cVar = this.Q;
            int i3 = 0;
            while (cVar != null) {
                if (i3 == i2) {
                    return cVar;
                }
                cVar = cVar.f3601c;
                i3++;
            }
            return null;
        }
        return (c) invokeI.objValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.R : invokeV.intValue;
    }

    public Bitmap f(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            c d2 = d(i2);
            if (d2 == null) {
                return null;
            }
            return d2.f3599a;
        }
        return (Bitmap) invokeI.objValue;
    }

    public Bitmap g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? f(0) : (Bitmap) invokeV.objValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f3594f = 0;
            this.R = 0;
            this.Q = null;
            this.k = null;
            this.l = null;
        }
    }

    public c i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (!this.E) {
                this.E = true;
                return this.Q;
            }
            if (this.f3594f == 0) {
                c cVar = this.D.f3601c;
                if (cVar != null) {
                    this.D = cVar;
                }
            } else {
                c cVar2 = this.D.f3601c;
                this.D = cVar2;
                if (cVar2 == null) {
                    this.D = this.Q;
                }
            }
            return this.D;
        }
        return (c) invokeV.objValue;
    }

    public final int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            try {
                return this.f3593e.read();
            } catch (Exception unused) {
                this.f3594f = 1;
                return 0;
            }
        }
        return invokeV.intValue;
    }

    public final int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            int j2 = j();
            this.G = j2;
            int i2 = 0;
            if (j2 > 0) {
                while (i2 < this.G) {
                    try {
                        int read = this.f3593e.read(this.F, i2, this.G - i2);
                        if (read == -1) {
                            break;
                        }
                        i2 += read;
                    } catch (Exception unused) {
                    }
                }
                if (i2 < this.G) {
                    this.f3594f = 1;
                }
            }
            return i2;
        }
        return invokeV.intValue;
    }

    public final int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            this.f3593e = new ByteArrayInputStream(this.T);
            this.T = null;
            return u();
        }
        return invokeV.intValue;
    }

    public final int[] m(int i2) {
        InterceptResult invokeI;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i2)) == null) {
            int i4 = i2 * 3;
            byte[] bArr = new byte[i4];
            try {
                i3 = this.f3593e.read(bArr);
            } catch (Exception unused) {
                i3 = 0;
            }
            if (i3 < i4) {
                this.f3594f = 1;
                return null;
            }
            int[] iArr = new int[256];
            int i5 = 0;
            for (int i6 = 0; i6 < i2; i6++) {
                int i7 = i5 + 1;
                int i8 = i7 + 1;
                iArr[i6] = ((bArr[i5] & 255) << 16) | (-16777216) | ((bArr[i7] & 255) << 8) | (bArr[i8] & 255);
                i5 = i8 + 1;
            }
            return iArr;
        }
        return (int[]) invokeI.objValue;
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            boolean z = false;
            while (!z && !b()) {
                int j2 = j();
                if (j2 != 0) {
                    if (j2 == 33) {
                        int j3 = j();
                        if (j3 == 249) {
                            o();
                        } else if (j3 != 255) {
                            x();
                        } else {
                            k();
                            String str = "";
                            for (int i2 = 0; i2 < 11; i2++) {
                                str = str + ((char) this.F[i2]);
                            }
                            if (str.equals("NETSCAPE2.0")) {
                                s();
                            } else {
                                x();
                            }
                        }
                    } else if (j2 == 44) {
                        q();
                    } else if (j2 != 59) {
                        this.f3594f = 1;
                    } else {
                        z = true;
                    }
                }
            }
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            j();
            int j2 = j();
            int i2 = (j2 & 28) >> 2;
            this.H = i2;
            if (i2 == 0) {
                this.H = 1;
            }
            this.J = (j2 & 1) != 0;
            this.K = t() * 10;
            this.L = j();
            j();
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            String str = "";
            for (int i2 = 0; i2 < 6; i2++) {
                str = str + ((char) j());
            }
            if (!str.startsWith("GIF")) {
                this.f3594f = 1;
                return;
            }
            r();
            if (!this.f3597i || b()) {
                return;
            }
            int[] m = m(this.f3598j);
            this.k = m;
            this.o = m[this.n];
        }
    }

    public final void q() {
        int[] iArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.t = t();
            this.u = t();
            this.v = t();
            this.w = t();
            int j2 = j();
            int i2 = 0;
            this.q = (j2 & 128) != 0;
            this.r = (j2 & 64) != 0;
            int i3 = 2 << (j2 & 7);
            this.s = i3;
            if (this.q) {
                int[] m = m(i3);
                this.l = m;
                this.m = m;
            } else {
                this.m = this.k;
                if (this.n == this.L) {
                    this.o = 0;
                }
            }
            if (this.J) {
                int[] iArr2 = this.m;
                int i4 = this.L;
                int i5 = iArr2[i4];
                iArr2[i4] = 0;
                i2 = i5;
            }
            if (this.m == null) {
                this.f3594f = 1;
            }
            if (b()) {
                return;
            }
            a();
            x();
            if (b()) {
                return;
            }
            this.R++;
            this.B = Bitmap.createBitmap(this.f3595g, this.f3596h, Bitmap.Config.ARGB_4444);
            w();
            c cVar = this.Q;
            if (cVar == null) {
                c cVar2 = new c(this.B, this.K);
                this.Q = cVar2;
                this.D = cVar2;
            } else {
                while (true) {
                    c cVar3 = cVar.f3601c;
                    if (cVar3 == null) {
                        break;
                    }
                    cVar = cVar3;
                }
                cVar.f3601c = new c(this.B, this.K);
            }
            if (this.J && (iArr = this.m) != null) {
                iArr[this.L] = i2;
            }
            v();
            this.S.parseOk(true, this.R);
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.f3595g = t();
            this.f3596h = t();
            int j2 = j();
            this.f3597i = (j2 & 128) != 0;
            this.f3598j = 2 << (j2 & 7);
            this.n = j();
            j();
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            try {
                if (this.f3593e != null) {
                    u();
                } else if (this.T != null) {
                    l();
                }
            } catch (Exception unused) {
            }
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            do {
                k();
                byte[] bArr = this.F;
                if (bArr[0] == 1) {
                    byte b2 = bArr[1];
                    byte b3 = bArr[2];
                }
                if (this.G <= 0) {
                    return;
                }
            } while (!b());
        }
    }

    public final int t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? j() | (j() << 8) : invokeV.intValue;
    }

    public final int u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            h();
            if (this.f3593e != null) {
                p();
                if (!b()) {
                    n();
                    if (this.R < 0) {
                        this.f3594f = 1;
                        this.S.parseOk(false, -1);
                    } else {
                        this.f3594f = -1;
                        this.S.parseOk(true, -1);
                    }
                }
                try {
                    this.f3593e.close();
                } catch (Exception unused) {
                }
            } else {
                this.f3594f = 2;
                this.S.parseOk(false, -1);
            }
            return this.f3594f;
        }
        return invokeV.intValue;
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            this.I = this.H;
            this.x = this.t;
            this.y = this.u;
            this.z = this.v;
            this.A = this.w;
            this.C = this.B;
            this.p = this.o;
            this.H = 0;
            this.J = false;
            this.K = 0;
            this.l = null;
        }
    }

    public final void w() {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(1048599, this) != null) {
            return;
        }
        int[] iArr = new int[this.f3595g * this.f3596h];
        int i3 = this.I;
        int i4 = 0;
        if (i3 > 0) {
            if (i3 == 3) {
                int i5 = this.R - 2;
                if (i5 > 0) {
                    this.C = f(i5 - 1);
                } else {
                    this.C = null;
                }
            }
            Bitmap bitmap = this.C;
            if (bitmap != null) {
                int i6 = this.f3595g;
                bitmap.getPixels(iArr, 0, i6, 0, 0, i6, this.f3596h);
                if (this.I == 2) {
                    int i7 = !this.J ? this.p : 0;
                    for (int i8 = 0; i8 < this.A; i8++) {
                        int i9 = ((this.y + i8) * this.f3595g) + this.x;
                        int i10 = this.z + i9;
                        while (i9 < i10) {
                            iArr[i9] = i7;
                            i9++;
                        }
                    }
                }
            }
        }
        int i11 = 8;
        int i12 = 0;
        int i13 = 1;
        while (true) {
            int i14 = this.w;
            if (i4 < i14) {
                if (this.r) {
                    if (i12 >= i14) {
                        i13++;
                        if (i13 == 2) {
                            i12 = 4;
                        } else if (i13 == 3) {
                            i11 = 4;
                            i12 = 2;
                        } else if (i13 == 4) {
                            i11 = 2;
                            i12 = 1;
                        }
                    }
                    i2 = i12 + i11;
                } else {
                    i2 = i12;
                    i12 = i4;
                }
                int i15 = i12 + this.u;
                if (i15 < this.f3596h) {
                    int i16 = this.f3595g;
                    int i17 = i15 * i16;
                    int i18 = this.t + i17;
                    int i19 = this.v + i18;
                    if (i17 + i16 < i19) {
                        i19 = i17 + i16;
                    }
                    int i20 = this.v * i4;
                    while (i18 < i19) {
                        int i21 = i20 + 1;
                        int i22 = this.m[this.P[i20] & 255];
                        if (i22 != 0) {
                            iArr[i18] = i22;
                        }
                        i18++;
                        i20 = i21;
                    }
                }
                i4++;
                i12 = i2;
            } else {
                try {
                    this.B = Bitmap.createBitmap(iArr, this.f3595g, this.f3596h, Bitmap.Config.ARGB_4444);
                    return;
                } catch (OutOfMemoryError unused) {
                    return;
                }
            }
        }
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            do {
                k();
                if (this.G <= 0) {
                    return;
                }
            } while (!b());
        }
    }

    public b(InputStream inputStream, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {inputStream, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.D = null;
        this.E = false;
        this.F = new byte[256];
        this.G = 0;
        this.H = 0;
        this.I = 0;
        this.J = false;
        this.K = 0;
        this.S = null;
        this.T = null;
        this.f3593e = inputStream;
        this.S = aVar;
    }
}
