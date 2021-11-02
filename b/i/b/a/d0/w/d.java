package b.i.b.a.d0.w;

import android.net.Uri;
import android.os.SystemClock;
import androidx.core.view.InputDeviceCompat;
import b.i.b.a.d0.s;
import b.i.b.a.d0.w.o.a;
import b.i.b.a.d0.w.o.b;
import b.i.b.a.i0.u;
import b.i.b.a.i0.v;
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
    public final f f32154a;

    /* renamed from: b  reason: collision with root package name */
    public final b.i.b.a.h0.e f32155b;

    /* renamed from: c  reason: collision with root package name */
    public final b.i.b.a.h0.e f32156c;

    /* renamed from: d  reason: collision with root package name */
    public final m f32157d;

    /* renamed from: e  reason: collision with root package name */
    public final a.C1482a[] f32158e;

    /* renamed from: f  reason: collision with root package name */
    public final HlsPlaylistTracker f32159f;

    /* renamed from: g  reason: collision with root package name */
    public final s f32160g;

    /* renamed from: h  reason: collision with root package name */
    public final List<Format> f32161h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f32162i;
    public byte[] j;
    public IOException k;
    public a.C1482a l;
    public boolean m;
    public Uri n;
    public byte[] o;
    public String p;
    public byte[] q;
    public b.i.b.a.f0.f r;
    public long s;

    /* loaded from: classes6.dex */
    public static final class a extends b.i.b.a.d0.u.j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final String l;
        public byte[] m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(b.i.b.a.h0.e eVar, b.i.b.a.h0.g gVar, Format format, int i2, Object obj, byte[] bArr, String str) {
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
                    super((b.i.b.a.h0.e) objArr2[0], (b.i.b.a.h0.g) objArr2[1], ((Integer) objArr2[2]).intValue(), (Format) objArr2[3], ((Integer) objArr2[4]).intValue(), objArr2[5], (byte[]) objArr2[6]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.l = str;
        }

        @Override // b.i.b.a.d0.u.j
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
        public b.i.b.a.d0.u.c f32163a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f32164b;

        /* renamed from: c  reason: collision with root package name */
        public a.C1482a f32165c;

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
                this.f32163a = null;
                this.f32164b = false;
                this.f32165c = null;
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class c extends b.i.b.a.f0.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: g  reason: collision with root package name */
        public int f32166g;

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
            this.f32166g = k(sVar.a(0));
        }

        @Override // b.i.b.a.f0.f
        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f32166g : invokeV.intValue;
        }

        @Override // b.i.b.a.f0.f
        public void i(long j, long j2, long j3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)}) == null) {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                if (m(this.f32166g, elapsedRealtime)) {
                    for (int i2 = this.f32466b - 1; i2 >= 0; i2--) {
                        if (!m(i2, elapsedRealtime)) {
                            this.f32166g = i2;
                            return;
                        }
                    }
                    throw new IllegalStateException();
                }
            }
        }

        @Override // b.i.b.a.f0.f
        public Object j() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return null;
            }
            return invokeV.objValue;
        }

        @Override // b.i.b.a.f0.f
        public int l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }
    }

    public d(f fVar, HlsPlaylistTracker hlsPlaylistTracker, a.C1482a[] c1482aArr, e eVar, m mVar, List<Format> list) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar, hlsPlaylistTracker, c1482aArr, eVar, mVar, list};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f32154a = fVar;
        this.f32159f = hlsPlaylistTracker;
        this.f32158e = c1482aArr;
        this.f32157d = mVar;
        this.f32161h = list;
        this.s = -9223372036854775807L;
        Format[] formatArr = new Format[c1482aArr.length];
        int[] iArr = new int[c1482aArr.length];
        for (int i4 = 0; i4 < c1482aArr.length; i4++) {
            formatArr[i4] = c1482aArr[i4].f32201b;
            iArr[i4] = i4;
        }
        this.f32155b = eVar.a(1);
        this.f32156c = eVar.a(3);
        s sVar = new s(formatArr);
        this.f32160g = sVar;
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
        int b2 = hVar == null ? -1 : this.f32160g.b(hVar.f32008c);
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
        a.C1482a c1482a = this.f32158e[e2];
        if (!this.f32159f.x(c1482a)) {
            bVar.f32165c = c1482a;
            this.l = c1482a;
            return;
        }
        b.i.b.a.d0.w.o.b v = this.f32159f.v(c1482a);
        this.m = v.k;
        o(v);
        if (hVar != null && !z2) {
            i2 = hVar.e();
        } else {
            long j4 = (hVar == null || this.m) ? j2 : hVar.f32011f;
            if (!v.l && j4 >= v.c()) {
                i2 = v.f32207h + v.p.size();
            } else {
                int c2 = v.c(v.p, Long.valueOf(j4 - v.f32204e), true, (!this.f32159f.w() || hVar == null) ? true : true);
                int i4 = v.f32207h;
                i2 = c2 + i4;
                if (i2 < i4 && hVar != null) {
                    c1482a = this.f32158e[b2];
                    b.i.b.a.d0.w.o.b v2 = this.f32159f.v(c1482a);
                    i2 = hVar.e();
                    v = v2;
                    a.C1482a c1482a2 = c1482a;
                    b.i.b.a.d0.w.o.b bVar2 = v;
                    i3 = bVar2.f32207h;
                    if (i2 >= i3) {
                        this.k = new BehindLiveWindowException();
                        return;
                    }
                    int i5 = i2 - i3;
                    if (i5 >= bVar2.p.size()) {
                        if (bVar2.l) {
                            bVar.f32164b = true;
                            return;
                        }
                        bVar.f32165c = c1482a2;
                        this.l = c1482a2;
                        return;
                    }
                    b.a aVar = bVar2.p.get(i5);
                    String str = aVar.f32213i;
                    if (str != null) {
                        Uri d3 = u.d(bVar2.f32214a, str);
                        if (!d3.equals(this.n)) {
                            bVar.f32163a = f(d3, aVar.j, b2, this.r.l(), this.r.j());
                            return;
                        } else if (!v.a(aVar.j, this.p)) {
                            m(d3, aVar.j, this.o);
                        }
                    } else {
                        a();
                    }
                    b.a aVar2 = bVar2.o;
                    b.i.b.a.h0.g gVar = aVar2 != null ? new b.i.b.a.h0.g(u.d(bVar2.f32214a, aVar2.f32209e), aVar2.k, aVar2.l, null) : null;
                    long j5 = bVar2.f32204e + aVar.f32212h;
                    int i6 = bVar2.f32206g + aVar.f32211g;
                    bVar.f32163a = new h(this.f32154a, this.f32155b, new b.i.b.a.h0.g(u.d(bVar2.f32214a, aVar.f32209e), aVar.k, aVar.l, null), gVar, c1482a2, this.f32161h, this.r.l(), this.r.j(), j5, j5 + aVar.f32210f, i2, i6, this.f32162i, this.f32157d.a(i6), hVar, bVar2.n, this.o, this.q);
                    return;
                }
            }
        }
        b2 = e2;
        a.C1482a c1482a22 = c1482a;
        b.i.b.a.d0.w.o.b bVar22 = v;
        i3 = bVar22.f32207h;
        if (i2 >= i3) {
        }
    }

    public s c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f32160g : (s) invokeV.objValue;
    }

    public b.i.b.a.f0.f d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.r : (b.i.b.a.f0.f) invokeV.objValue;
    }

    public void e() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            IOException iOException = this.k;
            if (iOException == null) {
                a.C1482a c1482a = this.l;
                if (c1482a != null) {
                    this.f32159f.A(c1482a);
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
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{uri, str, Integer.valueOf(i2), Integer.valueOf(i3), obj})) == null) ? new a(this.f32156c, new b.i.b.a.h0.g(uri, 0L, -1L, null, 1), this.f32158e[i2].f32201b, i3, obj, this.j, str) : (a) invokeCommon.objValue;
    }

    public void g(b.i.b.a.d0.u.c cVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, cVar) == null) && (cVar instanceof a)) {
            a aVar = (a) cVar;
            this.j = aVar.f();
            m(aVar.f32006a.f32529a, aVar.l, aVar.h());
        }
    }

    public boolean h(b.i.b.a.d0.u.c cVar, boolean z, IOException iOException) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{cVar, Boolean.valueOf(z), iOException})) == null) {
            if (z) {
                b.i.b.a.f0.f fVar = this.r;
                if (b.i.b.a.d0.u.h.a(fVar, fVar.c(this.f32160g.b(cVar.f32008c)), iOException)) {
                    return true;
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public void i(a.C1482a c1482a, long j) {
        int b2;
        int c2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, c1482a, j) == null) || (b2 = this.f32160g.b(c1482a.f32201b)) == -1 || (c2 = this.r.c(b2)) == -1) {
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

    public void l(b.i.b.a.f0.f fVar) {
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
            this.f32162i = z;
        }
    }

    public final void o(b.i.b.a.d0.w.o.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, bVar) == null) {
            this.s = bVar.l ? -9223372036854775807L : bVar.c();
        }
    }
}
