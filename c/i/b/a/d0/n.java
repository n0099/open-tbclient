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
/* loaded from: classes4.dex */
public final class n implements c.i.b.a.a0.m {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final c.i.b.a.h0.b f33134a;

    /* renamed from: b  reason: collision with root package name */
    public final int f33135b;

    /* renamed from: c  reason: collision with root package name */
    public final m f33136c;

    /* renamed from: d  reason: collision with root package name */
    public final m.a f33137d;

    /* renamed from: e  reason: collision with root package name */
    public final c.i.b.a.i0.l f33138e;

    /* renamed from: f  reason: collision with root package name */
    public a f33139f;

    /* renamed from: g  reason: collision with root package name */
    public a f33140g;

    /* renamed from: h  reason: collision with root package name */
    public a f33141h;

    /* renamed from: i  reason: collision with root package name */
    public Format f33142i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f33143j;
    public Format k;
    public long l;
    public long m;
    public boolean n;
    public b o;

    /* loaded from: classes4.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final long f33144a;

        /* renamed from: b  reason: collision with root package name */
        public final long f33145b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f33146c;
        @Nullable

        /* renamed from: d  reason: collision with root package name */
        public c.i.b.a.h0.a f33147d;
        @Nullable

        /* renamed from: e  reason: collision with root package name */
        public a f33148e;

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
            this.f33144a = j2;
            this.f33145b = j2 + i2;
        }

        public a a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                this.f33147d = null;
                a aVar = this.f33148e;
                this.f33148e = null;
                return aVar;
            }
            return (a) invokeV.objValue;
        }

        public void b(c.i.b.a.h0.a aVar, a aVar2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, aVar2) == null) {
                this.f33147d = aVar;
                this.f33148e = aVar2;
                this.f33146c = true;
            }
        }

        public int c(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j2)) == null) ? ((int) (j2 - this.f33144a)) + this.f33147d.f33719b : invokeJ.intValue;
        }
    }

    /* loaded from: classes4.dex */
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
        this.f33134a = bVar;
        this.f33135b = bVar.e();
        this.f33136c = new m();
        this.f33137d = new m.a();
        this.f33138e = new c.i.b.a.i0.l(32);
        a aVar = new a(0L, this.f33135b);
        this.f33139f = aVar;
        this.f33140g = aVar;
        this.f33141h = aVar;
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
            this.f33136c.v(z);
            h(this.f33139f);
            a aVar = new a(0L, this.f33135b);
            this.f33139f = aVar;
            this.f33140g = aVar;
            this.f33141h = aVar;
            this.m = 0L;
            this.f33134a.b();
        }
    }

    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f33136c.w();
            this.f33140g = this.f33139f;
        }
    }

    public void D(long j2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(1048579, this, j2) == null) || this.l == j2) {
            return;
        }
        this.l = j2;
        this.f33143j = true;
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
            this.f33136c.x(i2);
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
                a aVar = this.f33141h;
                lVar.g(aVar.f33147d.f33718a, aVar.c(this.m), v);
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
            boolean l = this.f33136c.l(n);
            this.k = format;
            this.f33143j = false;
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
            if (this.f33143j) {
                b(this.k);
            }
            if (this.n) {
                if ((i2 & 1) == 0 || !this.f33136c.c(j2)) {
                    return;
                }
                this.n = false;
            }
            this.f33136c.d(j2 + this.l, i2, (this.m - i3) - i4, i3, aVar);
        }
    }

    @Override // c.i.b.a.a0.m
    public int d(c.i.b.a.a0.f fVar, int i2, boolean z) throws IOException, InterruptedException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{fVar, Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            int v = v(i2);
            a aVar = this.f33141h;
            int read = fVar.read(aVar.f33147d.f33718a, aVar.c(this.m), v);
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
            a aVar = this.f33140g;
            if (j2 < aVar.f33145b) {
                return;
            }
            this.f33140g = aVar.f33148e;
        }
    }

    public int f(long j2, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{Long.valueOf(j2), Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) ? this.f33136c.a(j2, z, z2) : invokeCommon.intValue;
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f33136c.b() : invokeV.intValue;
    }

    public final void h(a aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048590, this, aVar) == null) && aVar.f33146c) {
            a aVar2 = this.f33141h;
            int i2 = (aVar2.f33146c ? 1 : 0) + (((int) (aVar2.f33144a - aVar.f33144a)) / this.f33135b);
            c.i.b.a.h0.a[] aVarArr = new c.i.b.a.h0.a[i2];
            for (int i3 = 0; i3 < i2; i3++) {
                aVarArr[i3] = aVar.f33147d;
                aVar = aVar.a();
            }
            this.f33134a.d(aVarArr);
        }
    }

    public final void i(long j2) {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(1048591, this, j2) == null) || j2 == -1) {
            return;
        }
        while (true) {
            aVar = this.f33139f;
            if (j2 < aVar.f33145b) {
                break;
            }
            this.f33134a.a(aVar.f33147d);
            this.f33139f = this.f33139f.a();
        }
        if (this.f33140g.f33144a < aVar.f33144a) {
            this.f33140g = aVar;
        }
    }

    public void j(long j2, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{Long.valueOf(j2), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            i(this.f33136c.g(j2, z, z2));
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            i(this.f33136c.h());
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            i(this.f33136c.i());
        }
    }

    public void m(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
            long j2 = this.f33136c.j(i2);
            this.m = j2;
            if (j2 != 0) {
                a aVar = this.f33139f;
                if (j2 != aVar.f33144a) {
                    while (this.m > aVar.f33145b) {
                        aVar = aVar.f33148e;
                    }
                    a aVar2 = aVar.f33148e;
                    h(aVar2);
                    a aVar3 = new a(aVar.f33145b, this.f33135b);
                    aVar.f33148e = aVar3;
                    if (this.m != aVar.f33145b) {
                        aVar3 = aVar;
                    }
                    this.f33141h = aVar3;
                    if (this.f33140g == aVar2) {
                        this.f33140g = aVar.f33148e;
                        return;
                    }
                    return;
                }
            }
            h(this.f33139f);
            a aVar4 = new a(this.m, this.f33135b);
            this.f33139f = aVar4;
            this.f33140g = aVar4;
            this.f33141h = aVar4;
        }
    }

    public long o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f33136c.m() : invokeV.longValue;
    }

    public int p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.f33136c.o() : invokeV.intValue;
    }

    public Format q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.f33136c.q() : (Format) invokeV.objValue;
    }

    public int r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.f33136c.r() : invokeV.intValue;
    }

    public boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.f33136c.s() : invokeV.booleanValue;
    }

    public int t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.f33136c.t() : invokeV.intValue;
    }

    public final void u(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i2) == null) {
            long j2 = this.m + i2;
            this.m = j2;
            a aVar = this.f33141h;
            if (j2 == aVar.f33145b) {
                this.f33141h = aVar.f33148e;
            }
        }
    }

    public final int v(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048603, this, i2)) == null) {
            a aVar = this.f33141h;
            if (!aVar.f33146c) {
                aVar.b(this.f33134a.c(), new a(this.f33141h.f33145b, this.f33135b));
            }
            return Math.min(i2, (int) (this.f33141h.f33145b - this.m));
        }
        return invokeI.intValue;
    }

    public int w(c.i.b.a.l lVar, c.i.b.a.y.e eVar, boolean z, boolean z2, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048604, this, new Object[]{lVar, eVar, Boolean.valueOf(z), Boolean.valueOf(z2), Long.valueOf(j2)})) == null) {
            int u = this.f33136c.u(lVar, eVar, z, z2, this.f33142i, this.f33137d);
            if (u == -5) {
                this.f33142i = lVar.f33949a;
                return -5;
            } else if (u != -4) {
                if (u == -3) {
                    return -3;
                }
                throw new IllegalStateException();
            } else {
                if (!eVar.j()) {
                    if (eVar.f34117h < j2) {
                        eVar.e(Integer.MIN_VALUE);
                    }
                    if (eVar.p()) {
                        z(eVar, this.f33137d);
                    }
                    eVar.n(this.f33137d.f33131a);
                    m.a aVar = this.f33137d;
                    x(aVar.f33132b, eVar.f34116g, aVar.f33131a);
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
                int min = Math.min(i2, (int) (this.f33140g.f33145b - j2));
                a aVar = this.f33140g;
                byteBuffer.put(aVar.f33147d.f33718a, aVar.c(j2), min);
                i2 -= min;
                j2 += min;
                a aVar2 = this.f33140g;
                if (j2 == aVar2.f33145b) {
                    this.f33140g = aVar2.f33148e;
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
                int min = Math.min(i3, (int) (this.f33140g.f33145b - j2));
                a aVar = this.f33140g;
                System.arraycopy(aVar.f33147d.f33718a, aVar.c(j2), bArr, i2 - i3, min);
                i3 -= min;
                j2 += min;
                a aVar2 = this.f33140g;
                if (j2 == aVar2.f33145b) {
                    this.f33140g = aVar2.f33148e;
                }
            }
        }
    }

    public final void z(c.i.b.a.y.e eVar, m.a aVar) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048607, this, eVar, aVar) == null) {
            long j2 = aVar.f33132b;
            this.f33138e.G(1);
            y(j2, this.f33138e.f33839a, 1);
            long j3 = j2 + 1;
            byte b2 = this.f33138e.f33839a[0];
            boolean z = (b2 & ByteCompanionObject.MIN_VALUE) != 0;
            int i3 = b2 & ByteCompanionObject.MAX_VALUE;
            c.i.b.a.y.b bVar = eVar.f34115f;
            if (bVar.f34094a == null) {
                bVar.f34094a = new byte[16];
            }
            y(j3, eVar.f34115f.f34094a, i3);
            long j4 = j3 + i3;
            if (z) {
                this.f33138e.G(2);
                y(j4, this.f33138e.f33839a, 2);
                j4 += 2;
                i2 = this.f33138e.D();
            } else {
                i2 = 1;
            }
            int[] iArr = eVar.f34115f.f34097d;
            if (iArr == null || iArr.length < i2) {
                iArr = new int[i2];
            }
            int[] iArr2 = iArr;
            int[] iArr3 = eVar.f34115f.f34098e;
            if (iArr3 == null || iArr3.length < i2) {
                iArr3 = new int[i2];
            }
            int[] iArr4 = iArr3;
            if (z) {
                int i4 = i2 * 6;
                this.f33138e.G(i4);
                y(j4, this.f33138e.f33839a, i4);
                j4 += i4;
                this.f33138e.J(0);
                for (int i5 = 0; i5 < i2; i5++) {
                    iArr2[i5] = this.f33138e.D();
                    iArr4[i5] = this.f33138e.B();
                }
            } else {
                iArr2[0] = 0;
                iArr4[0] = aVar.f33131a - ((int) (j4 - aVar.f33132b));
            }
            m.a aVar2 = aVar.f33133c;
            c.i.b.a.y.b bVar2 = eVar.f34115f;
            bVar2.c(i2, iArr2, iArr4, aVar2.f32498b, bVar2.f34094a, aVar2.f32497a, aVar2.f32499c, aVar2.f32500d);
            long j5 = aVar.f33132b;
            int i6 = (int) (j4 - j5);
            aVar.f33132b = j5 + i6;
            aVar.f33131a -= i6;
        }
    }
}
