package b.i.b.a.d0;

import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import b.i.b.a.a0.m;
import b.i.b.a.d0.m;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.Format;
import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import kotlin.jvm.internal.ByteCompanionObject;
/* loaded from: classes6.dex */
public final class n implements b.i.b.a.a0.m {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final b.i.b.a.h0.b f31973a;

    /* renamed from: b  reason: collision with root package name */
    public final int f31974b;

    /* renamed from: c  reason: collision with root package name */
    public final m f31975c;

    /* renamed from: d  reason: collision with root package name */
    public final m.a f31976d;

    /* renamed from: e  reason: collision with root package name */
    public final b.i.b.a.i0.l f31977e;

    /* renamed from: f  reason: collision with root package name */
    public a f31978f;

    /* renamed from: g  reason: collision with root package name */
    public a f31979g;

    /* renamed from: h  reason: collision with root package name */
    public a f31980h;

    /* renamed from: i  reason: collision with root package name */
    public Format f31981i;
    public boolean j;
    public Format k;
    public long l;
    public long m;
    public boolean n;
    public b o;

    /* loaded from: classes6.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final long f31982a;

        /* renamed from: b  reason: collision with root package name */
        public final long f31983b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f31984c;
        @Nullable

        /* renamed from: d  reason: collision with root package name */
        public b.i.b.a.h0.a f31985d;
        @Nullable

        /* renamed from: e  reason: collision with root package name */
        public a f31986e;

        public a(long j, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Long.valueOf(j), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f31982a = j;
            this.f31983b = j + i2;
        }

        public a a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                this.f31985d = null;
                a aVar = this.f31986e;
                this.f31986e = null;
                return aVar;
            }
            return (a) invokeV.objValue;
        }

        public void b(b.i.b.a.h0.a aVar, a aVar2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, aVar2) == null) {
                this.f31985d = aVar;
                this.f31986e = aVar2;
                this.f31984c = true;
            }
        }

        public int c(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j)) == null) ? ((int) (j - this.f31982a)) + this.f31985d.f32520b : invokeJ.intValue;
        }
    }

    /* loaded from: classes6.dex */
    public interface b {
        void f(Format format);
    }

    public n(b.i.b.a.h0.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f31973a = bVar;
        this.f31974b = bVar.e();
        this.f31975c = new m();
        this.f31976d = new m.a();
        this.f31977e = new b.i.b.a.i0.l(32);
        a aVar = new a(0L, this.f31974b);
        this.f31978f = aVar;
        this.f31979g = aVar;
        this.f31980h = aVar;
    }

    public static Format n(Format format, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65537, null, format, j)) == null) {
            if (format == null) {
                return null;
            }
            if (j != 0) {
                long j2 = format.subsampleOffsetUs;
                return j2 != Long.MAX_VALUE ? format.copyWithSubsampleOffsetUs(j2 + j) : format;
            }
            return format;
        }
        return (Format) invokeLJ.objValue;
    }

    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            B(false);
        }
    }

    public void B(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.f31975c.v(z);
            h(this.f31978f);
            a aVar = new a(0L, this.f31974b);
            this.f31978f = aVar;
            this.f31979g = aVar;
            this.f31980h = aVar;
            this.m = 0L;
            this.f31973a.b();
        }
    }

    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f31975c.w();
            this.f31979g = this.f31978f;
        }
    }

    public void D(long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(1048579, this, j) == null) || this.l == j) {
            return;
        }
        this.l = j;
        this.j = true;
    }

    public void E(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) {
            this.o = bVar;
        }
    }

    public void F(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.f31975c.x(i2);
        }
    }

    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.n = true;
        }
    }

    @Override // b.i.b.a.a0.m
    public void a(b.i.b.a.i0.l lVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048583, this, lVar, i2) == null) {
            while (i2 > 0) {
                int v = v(i2);
                a aVar = this.f31980h;
                lVar.g(aVar.f31985d.f32519a, aVar.c(this.m), v);
                i2 -= v;
                u(v);
            }
        }
    }

    @Override // b.i.b.a.a0.m
    public void b(Format format) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, format) == null) {
            Format n = n(format, this.l);
            boolean l = this.f31975c.l(n);
            this.k = format;
            this.j = false;
            b bVar = this.o;
            if (bVar == null || !l) {
                return;
            }
            bVar.f(n);
        }
    }

    @Override // b.i.b.a.a0.m
    public void c(long j, int i2, int i3, int i4, m.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Long.valueOf(j), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), aVar}) == null) {
            if (this.j) {
                b(this.k);
            }
            if (this.n) {
                if ((i2 & 1) == 0 || !this.f31975c.c(j)) {
                    return;
                }
                this.n = false;
            }
            this.f31975c.d(j + this.l, i2, (this.m - i3) - i4, i3, aVar);
        }
    }

    @Override // b.i.b.a.a0.m
    public int d(b.i.b.a.a0.f fVar, int i2, boolean z) throws IOException, InterruptedException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{fVar, Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            int v = v(i2);
            a aVar = this.f31980h;
            int read = fVar.read(aVar.f31985d.f32519a, aVar.c(this.m), v);
            if (read != -1) {
                u(read);
                return read;
            } else if (z) {
                return -1;
            } else {
                throw new EOFException();
            }
        }
        return invokeCommon.intValue;
    }

    public final void e(long j) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeJ(1048587, this, j) != null) {
            return;
        }
        while (true) {
            a aVar = this.f31979g;
            if (j < aVar.f31983b) {
                return;
            }
            this.f31979g = aVar.f31986e;
        }
    }

    public int f(long j, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{Long.valueOf(j), Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) ? this.f31975c.a(j, z, z2) : invokeCommon.intValue;
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f31975c.b() : invokeV.intValue;
    }

    public final void h(a aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048590, this, aVar) == null) && aVar.f31984c) {
            a aVar2 = this.f31980h;
            int i2 = (aVar2.f31984c ? 1 : 0) + (((int) (aVar2.f31982a - aVar.f31982a)) / this.f31974b);
            b.i.b.a.h0.a[] aVarArr = new b.i.b.a.h0.a[i2];
            for (int i3 = 0; i3 < i2; i3++) {
                aVarArr[i3] = aVar.f31985d;
                aVar = aVar.a();
            }
            this.f31973a.d(aVarArr);
        }
    }

    public final void i(long j) {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(1048591, this, j) == null) || j == -1) {
            return;
        }
        while (true) {
            aVar = this.f31978f;
            if (j < aVar.f31983b) {
                break;
            }
            this.f31973a.a(aVar.f31985d);
            this.f31978f = this.f31978f.a();
        }
        if (this.f31979g.f31982a < aVar.f31982a) {
            this.f31979g = aVar;
        }
    }

    public void j(long j, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{Long.valueOf(j), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            i(this.f31975c.g(j, z, z2));
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            i(this.f31975c.h());
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            i(this.f31975c.i());
        }
    }

    public void m(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
            long j = this.f31975c.j(i2);
            this.m = j;
            if (j != 0) {
                a aVar = this.f31978f;
                if (j != aVar.f31982a) {
                    while (this.m > aVar.f31983b) {
                        aVar = aVar.f31986e;
                    }
                    a aVar2 = aVar.f31986e;
                    h(aVar2);
                    a aVar3 = new a(aVar.f31983b, this.f31974b);
                    aVar.f31986e = aVar3;
                    if (this.m != aVar.f31983b) {
                        aVar3 = aVar;
                    }
                    this.f31980h = aVar3;
                    if (this.f31979g == aVar2) {
                        this.f31979g = aVar.f31986e;
                        return;
                    }
                    return;
                }
            }
            h(this.f31978f);
            a aVar4 = new a(this.m, this.f31974b);
            this.f31978f = aVar4;
            this.f31979g = aVar4;
            this.f31980h = aVar4;
        }
    }

    public long o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f31975c.m() : invokeV.longValue;
    }

    public int p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.f31975c.o() : invokeV.intValue;
    }

    public Format q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.f31975c.q() : (Format) invokeV.objValue;
    }

    public int r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.f31975c.r() : invokeV.intValue;
    }

    public boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.f31975c.s() : invokeV.booleanValue;
    }

    public int t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.f31975c.t() : invokeV.intValue;
    }

    public final void u(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i2) == null) {
            long j = this.m + i2;
            this.m = j;
            a aVar = this.f31980h;
            if (j == aVar.f31983b) {
                this.f31980h = aVar.f31986e;
            }
        }
    }

    public final int v(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048603, this, i2)) == null) {
            a aVar = this.f31980h;
            if (!aVar.f31984c) {
                aVar.b(this.f31973a.c(), new a(this.f31980h.f31983b, this.f31974b));
            }
            return Math.min(i2, (int) (this.f31980h.f31983b - this.m));
        }
        return invokeI.intValue;
    }

    public int w(b.i.b.a.l lVar, b.i.b.a.y.e eVar, boolean z, boolean z2, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048604, this, new Object[]{lVar, eVar, Boolean.valueOf(z), Boolean.valueOf(z2), Long.valueOf(j)})) == null) {
            int u = this.f31975c.u(lVar, eVar, z, z2, this.f31981i, this.f31976d);
            if (u == -5) {
                this.f31981i = lVar.f32741a;
                return -5;
            } else if (u != -4) {
                if (u == -3) {
                    return -3;
                }
                throw new IllegalStateException();
            } else {
                if (!eVar.j()) {
                    if (eVar.f32902h < j) {
                        eVar.e(Integer.MIN_VALUE);
                    }
                    if (eVar.p()) {
                        z(eVar, this.f31976d);
                    }
                    eVar.n(this.f31976d.f31970a);
                    m.a aVar = this.f31976d;
                    x(aVar.f31971b, eVar.f32901g, aVar.f31970a);
                }
                return -4;
            }
        }
        return invokeCommon.intValue;
    }

    public final void x(long j, ByteBuffer byteBuffer, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048605, this, new Object[]{Long.valueOf(j), byteBuffer, Integer.valueOf(i2)}) == null) {
            e(j);
            while (i2 > 0) {
                int min = Math.min(i2, (int) (this.f31979g.f31983b - j));
                a aVar = this.f31979g;
                byteBuffer.put(aVar.f31985d.f32519a, aVar.c(j), min);
                i2 -= min;
                j += min;
                a aVar2 = this.f31979g;
                if (j == aVar2.f31983b) {
                    this.f31979g = aVar2.f31986e;
                }
            }
        }
    }

    public final void y(long j, byte[] bArr, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048606, this, new Object[]{Long.valueOf(j), bArr, Integer.valueOf(i2)}) == null) {
            e(j);
            int i3 = i2;
            while (i3 > 0) {
                int min = Math.min(i3, (int) (this.f31979g.f31983b - j));
                a aVar = this.f31979g;
                System.arraycopy(aVar.f31985d.f32519a, aVar.c(j), bArr, i2 - i3, min);
                i3 -= min;
                j += min;
                a aVar2 = this.f31979g;
                if (j == aVar2.f31983b) {
                    this.f31979g = aVar2.f31986e;
                }
            }
        }
    }

    public final void z(b.i.b.a.y.e eVar, m.a aVar) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048607, this, eVar, aVar) == null) {
            long j = aVar.f31971b;
            this.f31977e.G(1);
            y(j, this.f31977e.f32635a, 1);
            long j2 = j + 1;
            byte b2 = this.f31977e.f32635a[0];
            boolean z = (b2 & ByteCompanionObject.MIN_VALUE) != 0;
            int i3 = b2 & ByteCompanionObject.MAX_VALUE;
            b.i.b.a.y.b bVar = eVar.f32900f;
            if (bVar.f32880a == null) {
                bVar.f32880a = new byte[16];
            }
            y(j2, eVar.f32900f.f32880a, i3);
            long j3 = j2 + i3;
            if (z) {
                this.f31977e.G(2);
                y(j3, this.f31977e.f32635a, 2);
                j3 += 2;
                i2 = this.f31977e.D();
            } else {
                i2 = 1;
            }
            int[] iArr = eVar.f32900f.f32883d;
            if (iArr == null || iArr.length < i2) {
                iArr = new int[i2];
            }
            int[] iArr2 = iArr;
            int[] iArr3 = eVar.f32900f.f32884e;
            if (iArr3 == null || iArr3.length < i2) {
                iArr3 = new int[i2];
            }
            int[] iArr4 = iArr3;
            if (z) {
                int i4 = i2 * 6;
                this.f31977e.G(i4);
                y(j3, this.f31977e.f32635a, i4);
                j3 += i4;
                this.f31977e.J(0);
                for (int i5 = 0; i5 < i2; i5++) {
                    iArr2[i5] = this.f31977e.D();
                    iArr4[i5] = this.f31977e.B();
                }
            } else {
                iArr2[0] = 0;
                iArr4[0] = aVar.f31970a - ((int) (j3 - aVar.f31971b));
            }
            m.a aVar2 = aVar.f31972c;
            b.i.b.a.y.b bVar2 = eVar.f32900f;
            bVar2.c(i2, iArr2, iArr4, aVar2.f31376b, bVar2.f32880a, aVar2.f31375a, aVar2.f31377c, aVar2.f31378d);
            long j4 = aVar.f31971b;
            int i6 = (int) (j3 - j4);
            aVar.f31971b = j4 + i6;
            aVar.f31970a -= i6;
        }
    }
}
