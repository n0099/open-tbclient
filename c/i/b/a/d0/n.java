package c.i.b.a.d0;

import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.i.b.a.a0.m;
import c.i.b.a.d0.m;
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
/* loaded from: classes7.dex */
public final class n implements c.i.b.a.a0.m {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final c.i.b.a.h0.b a;

    /* renamed from: b  reason: collision with root package name */
    public final int f29599b;

    /* renamed from: c  reason: collision with root package name */
    public final m f29600c;

    /* renamed from: d  reason: collision with root package name */
    public final m.a f29601d;

    /* renamed from: e  reason: collision with root package name */
    public final c.i.b.a.i0.l f29602e;

    /* renamed from: f  reason: collision with root package name */
    public a f29603f;

    /* renamed from: g  reason: collision with root package name */
    public a f29604g;

    /* renamed from: h  reason: collision with root package name */
    public a f29605h;

    /* renamed from: i  reason: collision with root package name */
    public Format f29606i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f29607j;

    /* renamed from: k  reason: collision with root package name */
    public Format f29608k;
    public long l;
    public long m;
    public boolean n;
    public b o;

    /* loaded from: classes7.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final long a;

        /* renamed from: b  reason: collision with root package name */
        public final long f29609b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f29610c;
        @Nullable

        /* renamed from: d  reason: collision with root package name */
        public c.i.b.a.h0.a f29611d;
        @Nullable

        /* renamed from: e  reason: collision with root package name */
        public a f29612e;

        public a(long j2, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Long.valueOf(j2), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j2;
            this.f29609b = j2 + i2;
        }

        public a a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                this.f29611d = null;
                a aVar = this.f29612e;
                this.f29612e = null;
                return aVar;
            }
            return (a) invokeV.objValue;
        }

        public void b(c.i.b.a.h0.a aVar, a aVar2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, aVar2) == null) {
                this.f29611d = aVar;
                this.f29612e = aVar2;
                this.f29610c = true;
            }
        }

        public int c(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j2)) == null) ? ((int) (j2 - this.a)) + this.f29611d.f30130b : invokeJ.intValue;
        }
    }

    /* loaded from: classes7.dex */
    public interface b {
        void f(Format format);
    }

    public n(c.i.b.a.h0.b bVar) {
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
        this.a = bVar;
        this.f29599b = bVar.e();
        this.f29600c = new m();
        this.f29601d = new m.a();
        this.f29602e = new c.i.b.a.i0.l(32);
        a aVar = new a(0L, this.f29599b);
        this.f29603f = aVar;
        this.f29604g = aVar;
        this.f29605h = aVar;
    }

    public static Format n(Format format, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65537, null, format, j2)) == null) {
            if (format == null) {
                return null;
            }
            if (j2 != 0) {
                long j3 = format.subsampleOffsetUs;
                return j3 != Long.MAX_VALUE ? format.copyWithSubsampleOffsetUs(j3 + j2) : format;
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
            this.f29600c.v(z);
            h(this.f29603f);
            a aVar = new a(0L, this.f29599b);
            this.f29603f = aVar;
            this.f29604g = aVar;
            this.f29605h = aVar;
            this.m = 0L;
            this.a.b();
        }
    }

    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f29600c.w();
            this.f29604g = this.f29603f;
        }
    }

    public void D(long j2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(1048579, this, j2) == null) || this.l == j2) {
            return;
        }
        this.l = j2;
        this.f29607j = true;
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
            this.f29600c.x(i2);
        }
    }

    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.n = true;
        }
    }

    @Override // c.i.b.a.a0.m
    public void a(c.i.b.a.i0.l lVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048583, this, lVar, i2) == null) {
            while (i2 > 0) {
                int v = v(i2);
                a aVar = this.f29605h;
                lVar.g(aVar.f29611d.a, aVar.c(this.m), v);
                i2 -= v;
                u(v);
            }
        }
    }

    @Override // c.i.b.a.a0.m
    public void b(Format format) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, format) == null) {
            Format n = n(format, this.l);
            boolean l = this.f29600c.l(n);
            this.f29608k = format;
            this.f29607j = false;
            b bVar = this.o;
            if (bVar == null || !l) {
                return;
            }
            bVar.f(n);
        }
    }

    @Override // c.i.b.a.a0.m
    public void c(long j2, int i2, int i3, int i4, m.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Long.valueOf(j2), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), aVar}) == null) {
            if (this.f29607j) {
                b(this.f29608k);
            }
            if (this.n) {
                if ((i2 & 1) == 0 || !this.f29600c.c(j2)) {
                    return;
                }
                this.n = false;
            }
            this.f29600c.d(j2 + this.l, i2, (this.m - i3) - i4, i3, aVar);
        }
    }

    @Override // c.i.b.a.a0.m
    public int d(c.i.b.a.a0.f fVar, int i2, boolean z) throws IOException, InterruptedException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{fVar, Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            int v = v(i2);
            a aVar = this.f29605h;
            int read = fVar.read(aVar.f29611d.a, aVar.c(this.m), v);
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

    public final void e(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeJ(1048587, this, j2) != null) {
            return;
        }
        while (true) {
            a aVar = this.f29604g;
            if (j2 < aVar.f29609b) {
                return;
            }
            this.f29604g = aVar.f29612e;
        }
    }

    public int f(long j2, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{Long.valueOf(j2), Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) ? this.f29600c.a(j2, z, z2) : invokeCommon.intValue;
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f29600c.b() : invokeV.intValue;
    }

    public final void h(a aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048590, this, aVar) == null) && aVar.f29610c) {
            a aVar2 = this.f29605h;
            int i2 = (aVar2.f29610c ? 1 : 0) + (((int) (aVar2.a - aVar.a)) / this.f29599b);
            c.i.b.a.h0.a[] aVarArr = new c.i.b.a.h0.a[i2];
            for (int i3 = 0; i3 < i2; i3++) {
                aVarArr[i3] = aVar.f29611d;
                aVar = aVar.a();
            }
            this.a.d(aVarArr);
        }
    }

    public final void i(long j2) {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(1048591, this, j2) == null) || j2 == -1) {
            return;
        }
        while (true) {
            aVar = this.f29603f;
            if (j2 < aVar.f29609b) {
                break;
            }
            this.a.a(aVar.f29611d);
            this.f29603f = this.f29603f.a();
        }
        if (this.f29604g.a < aVar.a) {
            this.f29604g = aVar;
        }
    }

    public void j(long j2, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{Long.valueOf(j2), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            i(this.f29600c.g(j2, z, z2));
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            i(this.f29600c.h());
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            i(this.f29600c.i());
        }
    }

    public void m(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
            long j2 = this.f29600c.j(i2);
            this.m = j2;
            if (j2 != 0) {
                a aVar = this.f29603f;
                if (j2 != aVar.a) {
                    while (this.m > aVar.f29609b) {
                        aVar = aVar.f29612e;
                    }
                    a aVar2 = aVar.f29612e;
                    h(aVar2);
                    a aVar3 = new a(aVar.f29609b, this.f29599b);
                    aVar.f29612e = aVar3;
                    if (this.m != aVar.f29609b) {
                        aVar3 = aVar;
                    }
                    this.f29605h = aVar3;
                    if (this.f29604g == aVar2) {
                        this.f29604g = aVar.f29612e;
                        return;
                    }
                    return;
                }
            }
            h(this.f29603f);
            a aVar4 = new a(this.m, this.f29599b);
            this.f29603f = aVar4;
            this.f29604g = aVar4;
            this.f29605h = aVar4;
        }
    }

    public long o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f29600c.m() : invokeV.longValue;
    }

    public int p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.f29600c.o() : invokeV.intValue;
    }

    public Format q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.f29600c.q() : (Format) invokeV.objValue;
    }

    public int r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.f29600c.r() : invokeV.intValue;
    }

    public boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.f29600c.s() : invokeV.booleanValue;
    }

    public int t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.f29600c.t() : invokeV.intValue;
    }

    public final void u(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i2) == null) {
            long j2 = this.m + i2;
            this.m = j2;
            a aVar = this.f29605h;
            if (j2 == aVar.f29609b) {
                this.f29605h = aVar.f29612e;
            }
        }
    }

    public final int v(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048603, this, i2)) == null) {
            a aVar = this.f29605h;
            if (!aVar.f29610c) {
                aVar.b(this.a.c(), new a(this.f29605h.f29609b, this.f29599b));
            }
            return Math.min(i2, (int) (this.f29605h.f29609b - this.m));
        }
        return invokeI.intValue;
    }

    public int w(c.i.b.a.l lVar, c.i.b.a.y.e eVar, boolean z, boolean z2, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048604, this, new Object[]{lVar, eVar, Boolean.valueOf(z), Boolean.valueOf(z2), Long.valueOf(j2)})) == null) {
            int u = this.f29600c.u(lVar, eVar, z, z2, this.f29606i, this.f29601d);
            if (u == -5) {
                this.f29606i = lVar.a;
                return -5;
            } else if (u != -4) {
                if (u == -3) {
                    return -3;
                }
                throw new IllegalStateException();
            } else {
                if (!eVar.j()) {
                    if (eVar.f30479h < j2) {
                        eVar.e(Integer.MIN_VALUE);
                    }
                    if (eVar.p()) {
                        z(eVar, this.f29601d);
                    }
                    eVar.n(this.f29601d.a);
                    m.a aVar = this.f29601d;
                    x(aVar.f29597b, eVar.f30478g, aVar.a);
                }
                return -4;
            }
        }
        return invokeCommon.intValue;
    }

    public final void x(long j2, ByteBuffer byteBuffer, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048605, this, new Object[]{Long.valueOf(j2), byteBuffer, Integer.valueOf(i2)}) == null) {
            e(j2);
            while (i2 > 0) {
                int min = Math.min(i2, (int) (this.f29604g.f29609b - j2));
                a aVar = this.f29604g;
                byteBuffer.put(aVar.f29611d.a, aVar.c(j2), min);
                i2 -= min;
                j2 += min;
                a aVar2 = this.f29604g;
                if (j2 == aVar2.f29609b) {
                    this.f29604g = aVar2.f29612e;
                }
            }
        }
    }

    public final void y(long j2, byte[] bArr, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048606, this, new Object[]{Long.valueOf(j2), bArr, Integer.valueOf(i2)}) == null) {
            e(j2);
            int i3 = i2;
            while (i3 > 0) {
                int min = Math.min(i3, (int) (this.f29604g.f29609b - j2));
                a aVar = this.f29604g;
                System.arraycopy(aVar.f29611d.a, aVar.c(j2), bArr, i2 - i3, min);
                i3 -= min;
                j2 += min;
                a aVar2 = this.f29604g;
                if (j2 == aVar2.f29609b) {
                    this.f29604g = aVar2.f29612e;
                }
            }
        }
    }

    public final void z(c.i.b.a.y.e eVar, m.a aVar) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048607, this, eVar, aVar) == null) {
            long j2 = aVar.f29597b;
            this.f29602e.G(1);
            y(j2, this.f29602e.a, 1);
            long j3 = j2 + 1;
            byte b2 = this.f29602e.a[0];
            boolean z = (b2 & ByteCompanionObject.MIN_VALUE) != 0;
            int i3 = b2 & ByteCompanionObject.MAX_VALUE;
            c.i.b.a.y.b bVar = eVar.f30477f;
            if (bVar.a == null) {
                bVar.a = new byte[16];
            }
            y(j3, eVar.f30477f.a, i3);
            long j4 = j3 + i3;
            if (z) {
                this.f29602e.G(2);
                y(j4, this.f29602e.a, 2);
                j4 += 2;
                i2 = this.f29602e.D();
            } else {
                i2 = 1;
            }
            int[] iArr = eVar.f30477f.f30461d;
            if (iArr == null || iArr.length < i2) {
                iArr = new int[i2];
            }
            int[] iArr2 = iArr;
            int[] iArr3 = eVar.f30477f.f30462e;
            if (iArr3 == null || iArr3.length < i2) {
                iArr3 = new int[i2];
            }
            int[] iArr4 = iArr3;
            if (z) {
                int i4 = i2 * 6;
                this.f29602e.G(i4);
                y(j4, this.f29602e.a, i4);
                j4 += i4;
                this.f29602e.J(0);
                for (int i5 = 0; i5 < i2; i5++) {
                    iArr2[i5] = this.f29602e.D();
                    iArr4[i5] = this.f29602e.B();
                }
            } else {
                iArr2[0] = 0;
                iArr4[0] = aVar.a - ((int) (j4 - aVar.f29597b));
            }
            m.a aVar2 = aVar.f29598c;
            c.i.b.a.y.b bVar2 = eVar.f30477f;
            bVar2.c(i2, iArr2, iArr4, aVar2.f29022b, bVar2.a, aVar2.a, aVar2.f29023c, aVar2.f29024d);
            long j5 = aVar.f29597b;
            int i6 = (int) (j4 - j5);
            aVar.f29597b = j5 + i6;
            aVar.a -= i6;
        }
    }
}
