package b.h.b.a.d0.w;

import android.net.Uri;
import android.os.SystemClock;
import androidx.core.view.InputDeviceCompat;
import b.h.b.a.d0.s;
import b.h.b.a.d0.w.o.a;
import b.h.b.a.d0.w.o.b;
import b.h.b.a.i0.u;
import b.h.b.a.i0.v;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.BehindLiveWindowException;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes6.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final f f33012a;

    /* renamed from: b  reason: collision with root package name */
    public final b.h.b.a.h0.e f33013b;

    /* renamed from: c  reason: collision with root package name */
    public final b.h.b.a.h0.e f33014c;

    /* renamed from: d  reason: collision with root package name */
    public final m f33015d;

    /* renamed from: e  reason: collision with root package name */
    public final a.C1524a[] f33016e;

    /* renamed from: f  reason: collision with root package name */
    public final HlsPlaylistTracker f33017f;

    /* renamed from: g  reason: collision with root package name */
    public final s f33018g;

    /* renamed from: h  reason: collision with root package name */
    public final List<Format> f33019h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f33020i;
    public byte[] j;
    public IOException k;
    public a.C1524a l;
    public boolean m;
    public Uri n;
    public byte[] o;
    public String p;
    public byte[] q;
    public b.h.b.a.f0.f r;
    public long s;

    /* loaded from: classes6.dex */
    public static final class a extends b.h.b.a.d0.u.j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final String l;
        public byte[] m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(b.h.b.a.h0.e eVar, b.h.b.a.h0.g gVar, Format format, int i2, Object obj, byte[] bArr, String str) {
            super(eVar, gVar, 3, format, i2, obj, bArr);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r3;
                Object[] objArr = {eVar, gVar, format, Integer.valueOf(i2), obj, bArr, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((b.h.b.a.h0.e) objArr2[0], (b.h.b.a.h0.g) objArr2[1], ((Integer) objArr2[2]).intValue(), (Format) objArr2[3], ((Integer) objArr2[4]).intValue(), objArr2[5], (byte[]) objArr2[6]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.l = str;
        }

        @Override // b.h.b.a.d0.u.j
        public void e(byte[] bArr, int i2) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, bArr, i2) == null) {
                this.m = Arrays.copyOf(bArr, i2);
            }
        }

        public byte[] h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.m : (byte[]) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public b.h.b.a.d0.u.c f33021a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f33022b;

        /* renamed from: c  reason: collision with root package name */
        public a.C1524a f33023c;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            a();
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f33021a = null;
                this.f33022b = false;
                this.f33023c = null;
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class c extends b.h.b.a.f0.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: g  reason: collision with root package name */
        public int f33024g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(s sVar, int[] iArr) {
            super(sVar, iArr);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sVar, iArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((s) objArr2[0], (int[]) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f33024g = k(sVar.a(0));
        }

        @Override // b.h.b.a.f0.f
        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f33024g : invokeV.intValue;
        }

        @Override // b.h.b.a.f0.f
        public void i(long j, long j2, long j3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)}) == null) {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                if (m(this.f33024g, elapsedRealtime)) {
                    for (int i2 = this.f33324b - 1; i2 >= 0; i2--) {
                        if (!m(i2, elapsedRealtime)) {
                            this.f33024g = i2;
                            return;
                        }
                    }
                    throw new IllegalStateException();
                }
            }
        }

        @Override // b.h.b.a.f0.f
        public Object j() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return null;
            }
            return invokeV.objValue;
        }

        @Override // b.h.b.a.f0.f
        public int l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }
    }

    public d(f fVar, HlsPlaylistTracker hlsPlaylistTracker, a.C1524a[] c1524aArr, e eVar, m mVar, List<Format> list) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar, hlsPlaylistTracker, c1524aArr, eVar, mVar, list};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f33012a = fVar;
        this.f33017f = hlsPlaylistTracker;
        this.f33016e = c1524aArr;
        this.f33015d = mVar;
        this.f33019h = list;
        this.s = -9223372036854775807L;
        Format[] formatArr = new Format[c1524aArr.length];
        int[] iArr = new int[c1524aArr.length];
        for (int i4 = 0; i4 < c1524aArr.length; i4++) {
            formatArr[i4] = c1524aArr[i4].f33059b;
            iArr[i4] = i4;
        }
        this.f33013b = eVar.a(1);
        this.f33014c = eVar.a(3);
        s sVar = new s(formatArr);
        this.f33018g = sVar;
        this.r = new c(sVar, iArr);
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.n = null;
            this.o = null;
            this.p = null;
            this.q = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00de  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(h hVar, long j, long j2, b bVar) {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{hVar, Long.valueOf(j), Long.valueOf(j2), bVar}) != null) {
            return;
        }
        int b2 = hVar == null ? -1 : this.f33018g.b(hVar.f32866c);
        this.l = null;
        long j3 = j2 - j;
        long k = k(j);
        if (hVar != null && !this.m) {
            long d2 = hVar.d();
            j3 = Math.max(0L, j3 - d2);
            if (k != -9223372036854775807L) {
                k = Math.max(0L, k - d2);
            }
        }
        this.r.i(j, j3, k);
        int e2 = this.r.e();
        boolean z = false;
        boolean z2 = b2 != e2;
        a.C1524a c1524a = this.f33016e[e2];
        if (!this.f33017f.x(c1524a)) {
            bVar.f33023c = c1524a;
            this.l = c1524a;
            return;
        }
        b.h.b.a.d0.w.o.b v = this.f33017f.v(c1524a);
        this.m = v.k;
        o(v);
        if (hVar != null && !z2) {
            i2 = hVar.e();
        } else {
            long j4 = (hVar == null || this.m) ? j2 : hVar.f32869f;
            if (!v.l && j4 >= v.c()) {
                i2 = v.f33065h + v.p.size();
            } else {
                int c2 = v.c(v.p, Long.valueOf(j4 - v.f33062e), true, (!this.f33017f.w() || hVar == null) ? true : true);
                int i4 = v.f33065h;
                i2 = c2 + i4;
                if (i2 < i4 && hVar != null) {
                    c1524a = this.f33016e[b2];
                    b.h.b.a.d0.w.o.b v2 = this.f33017f.v(c1524a);
                    i2 = hVar.e();
                    v = v2;
                    a.C1524a c1524a2 = c1524a;
                    b.h.b.a.d0.w.o.b bVar2 = v;
                    i3 = bVar2.f33065h;
                    if (i2 >= i3) {
                        this.k = new BehindLiveWindowException();
                        return;
                    }
                    int i5 = i2 - i3;
                    if (i5 >= bVar2.p.size()) {
                        if (bVar2.l) {
                            bVar.f33022b = true;
                            return;
                        }
                        bVar.f33023c = c1524a2;
                        this.l = c1524a2;
                        return;
                    }
                    b.a aVar = bVar2.p.get(i5);
                    String str = aVar.f33071i;
                    if (str != null) {
                        Uri d3 = u.d(bVar2.f33072a, str);
                        if (!d3.equals(this.n)) {
                            bVar.f33021a = f(d3, aVar.j, b2, this.r.l(), this.r.j());
                            return;
                        } else if (!v.a(aVar.j, this.p)) {
                            m(d3, aVar.j, this.o);
                        }
                    } else {
                        a();
                    }
                    b.a aVar2 = bVar2.o;
                    b.h.b.a.h0.g gVar = aVar2 != null ? new b.h.b.a.h0.g(u.d(bVar2.f33072a, aVar2.f33067e), aVar2.k, aVar2.l, null) : null;
                    long j5 = bVar2.f33062e + aVar.f33070h;
                    int i6 = bVar2.f33064g + aVar.f33069g;
                    bVar.f33021a = new h(this.f33012a, this.f33013b, new b.h.b.a.h0.g(u.d(bVar2.f33072a, aVar.f33067e), aVar.k, aVar.l, null), gVar, c1524a2, this.f33019h, this.r.l(), this.r.j(), j5, j5 + aVar.f33068f, i2, i6, this.f33020i, this.f33015d.a(i6), hVar, bVar2.n, this.o, this.q);
                    return;
                }
            }
        }
        b2 = e2;
        a.C1524a c1524a22 = c1524a;
        b.h.b.a.d0.w.o.b bVar22 = v;
        i3 = bVar22.f33065h;
        if (i2 >= i3) {
        }
    }

    public s c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f33018g : (s) invokeV.objValue;
    }

    public b.h.b.a.f0.f d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.r : (b.h.b.a.f0.f) invokeV.objValue;
    }

    public void e() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            IOException iOException = this.k;
            if (iOException == null) {
                a.C1524a c1524a = this.l;
                if (c1524a != null) {
                    this.f33017f.A(c1524a);
                    return;
                }
                return;
            }
            throw iOException;
        }
    }

    public final a f(Uri uri, String str, int i2, int i3, Object obj) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{uri, str, Integer.valueOf(i2), Integer.valueOf(i3), obj})) == null) ? new a(this.f33014c, new b.h.b.a.h0.g(uri, 0L, -1L, null, 1), this.f33016e[i2].f33059b, i3, obj, this.j, str) : (a) invokeCommon.objValue;
    }

    public void g(b.h.b.a.d0.u.c cVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, cVar) == null) && (cVar instanceof a)) {
            a aVar = (a) cVar;
            this.j = aVar.f();
            m(aVar.f32864a.f33387a, aVar.l, aVar.h());
        }
    }

    public boolean h(b.h.b.a.d0.u.c cVar, boolean z, IOException iOException) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{cVar, Boolean.valueOf(z), iOException})) == null) {
            if (z) {
                b.h.b.a.f0.f fVar = this.r;
                if (b.h.b.a.d0.u.h.a(fVar, fVar.c(this.f33018g.b(cVar.f32866c)), iOException)) {
                    return true;
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public void i(a.C1524a c1524a, long j) {
        int b2;
        int c2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, c1524a, j) == null) || (b2 = this.f33018g.b(c1524a.f33059b)) == -1 || (c2 = this.r.c(b2)) == -1) {
            return;
        }
        this.r.g(c2, j);
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.k = null;
        }
    }

    public final long k(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048586, this, j)) == null) {
            if (this.s != -9223372036854775807L) {
                return this.s - j;
            }
            return -9223372036854775807L;
        }
        return invokeJ.longValue;
    }

    public void l(b.h.b.a.f0.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, fVar) == null) {
            this.r = fVar;
        }
    }

    public final void m(Uri uri, String str, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048588, this, uri, str, bArr) == null) {
            byte[] byteArray = new BigInteger(v.J(str).startsWith("0x") ? str.substring(2) : str, 16).toByteArray();
            byte[] bArr2 = new byte[16];
            int length = byteArray.length > 16 ? byteArray.length - 16 : 0;
            System.arraycopy(byteArray, length, bArr2, (16 - byteArray.length) + length, byteArray.length - length);
            this.n = uri;
            this.o = bArr;
            this.p = str;
            this.q = bArr2;
        }
    }

    public void n(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.f33020i = z;
        }
    }

    public final void o(b.h.b.a.d0.w.o.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, bVar) == null) {
            this.s = bVar.l ? -9223372036854775807L : bVar.c();
        }
    }
}
