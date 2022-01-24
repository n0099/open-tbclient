package c.i.b.a.d0.w;

import android.net.Uri;
import android.os.SystemClock;
import androidx.core.view.InputDeviceCompat;
import c.i.b.a.d0.s;
import c.i.b.a.d0.w.o.a;
import c.i.b.a.d0.w.o.b;
import c.i.b.a.i0.u;
import c.i.b.a.i0.v;
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
/* loaded from: classes9.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final f a;

    /* renamed from: b  reason: collision with root package name */
    public final c.i.b.a.h0.e f29306b;

    /* renamed from: c  reason: collision with root package name */
    public final c.i.b.a.h0.e f29307c;

    /* renamed from: d  reason: collision with root package name */
    public final m f29308d;

    /* renamed from: e  reason: collision with root package name */
    public final a.C1660a[] f29309e;

    /* renamed from: f  reason: collision with root package name */
    public final HlsPlaylistTracker f29310f;

    /* renamed from: g  reason: collision with root package name */
    public final s f29311g;

    /* renamed from: h  reason: collision with root package name */
    public final List<Format> f29312h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f29313i;

    /* renamed from: j  reason: collision with root package name */
    public byte[] f29314j;
    public IOException k;
    public a.C1660a l;
    public boolean m;
    public Uri n;
    public byte[] o;
    public String p;
    public byte[] q;
    public c.i.b.a.f0.f r;
    public long s;

    /* loaded from: classes9.dex */
    public static final class a extends c.i.b.a.d0.u.j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final String l;
        public byte[] m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(c.i.b.a.h0.e eVar, c.i.b.a.h0.g gVar, Format format, int i2, Object obj, byte[] bArr, String str) {
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
                    super((c.i.b.a.h0.e) objArr2[0], (c.i.b.a.h0.g) objArr2[1], ((Integer) objArr2[2]).intValue(), (Format) objArr2[3], ((Integer) objArr2[4]).intValue(), objArr2[5], (byte[]) objArr2[6]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.l = str;
        }

        @Override // c.i.b.a.d0.u.j
        public void d(byte[] bArr, int i2) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, bArr, i2) == null) {
                this.m = Arrays.copyOf(bArr, i2);
            }
        }

        public byte[] g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.m : (byte[]) invokeV.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public c.i.b.a.d0.u.c a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f29315b;

        /* renamed from: c  reason: collision with root package name */
        public a.C1660a f29316c;

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
                this.a = null;
                this.f29315b = false;
                this.f29316c = null;
            }
        }
    }

    /* loaded from: classes9.dex */
    public static final class c extends c.i.b.a.f0.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: g  reason: collision with root package name */
        public int f29317g;

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
            this.f29317g = k(sVar.a(0));
        }

        @Override // c.i.b.a.f0.f
        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f29317g : invokeV.intValue;
        }

        @Override // c.i.b.a.f0.f
        public void i(long j2, long j3, long j4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4)}) == null) {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                if (m(this.f29317g, elapsedRealtime)) {
                    for (int i2 = this.f29598b - 1; i2 >= 0; i2--) {
                        if (!m(i2, elapsedRealtime)) {
                            this.f29317g = i2;
                            return;
                        }
                    }
                    throw new IllegalStateException();
                }
            }
        }

        @Override // c.i.b.a.f0.f
        public Object j() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return null;
            }
            return invokeV.objValue;
        }

        @Override // c.i.b.a.f0.f
        public int l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }
    }

    public d(f fVar, HlsPlaylistTracker hlsPlaylistTracker, a.C1660a[] c1660aArr, e eVar, m mVar, List<Format> list) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar, hlsPlaylistTracker, c1660aArr, eVar, mVar, list};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = fVar;
        this.f29310f = hlsPlaylistTracker;
        this.f29309e = c1660aArr;
        this.f29308d = mVar;
        this.f29312h = list;
        this.s = -9223372036854775807L;
        Format[] formatArr = new Format[c1660aArr.length];
        int[] iArr = new int[c1660aArr.length];
        for (int i4 = 0; i4 < c1660aArr.length; i4++) {
            formatArr[i4] = c1660aArr[i4].f29352b;
            iArr[i4] = i4;
        }
        this.f29306b = eVar.a(1);
        this.f29307c = eVar.a(3);
        s sVar = new s(formatArr);
        this.f29311g = sVar;
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
    public void b(h hVar, long j2, long j3, b bVar) {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{hVar, Long.valueOf(j2), Long.valueOf(j3), bVar}) != null) {
            return;
        }
        int b2 = hVar == null ? -1 : this.f29311g.b(hVar.f29176c);
        this.l = null;
        long j4 = j3 - j2;
        long k = k(j2);
        if (hVar != null && !this.m) {
            long c2 = hVar.c();
            j4 = Math.max(0L, j4 - c2);
            if (k != -9223372036854775807L) {
                k = Math.max(0L, k - c2);
            }
        }
        this.r.i(j2, j4, k);
        int e2 = this.r.e();
        boolean z = false;
        boolean z2 = b2 != e2;
        a.C1660a c1660a = this.f29309e[e2];
        if (!this.f29310f.x(c1660a)) {
            bVar.f29316c = c1660a;
            this.l = c1660a;
            return;
        }
        c.i.b.a.d0.w.o.b v = this.f29310f.v(c1660a);
        this.m = v.k;
        o(v);
        if (hVar != null && !z2) {
            i2 = hVar.d();
        } else {
            long j5 = (hVar == null || this.m) ? j3 : hVar.f29179f;
            if (!v.l && j5 >= v.c()) {
                i2 = v.f29358h + v.p.size();
            } else {
                int c3 = v.c(v.p, Long.valueOf(j5 - v.f29355e), true, (!this.f29310f.w() || hVar == null) ? true : true);
                int i4 = v.f29358h;
                i2 = c3 + i4;
                if (i2 < i4 && hVar != null) {
                    c1660a = this.f29309e[b2];
                    c.i.b.a.d0.w.o.b v2 = this.f29310f.v(c1660a);
                    i2 = hVar.d();
                    v = v2;
                    a.C1660a c1660a2 = c1660a;
                    c.i.b.a.d0.w.o.b bVar2 = v;
                    i3 = bVar2.f29358h;
                    if (i2 >= i3) {
                        this.k = new BehindLiveWindowException();
                        return;
                    }
                    int i5 = i2 - i3;
                    if (i5 >= bVar2.p.size()) {
                        if (bVar2.l) {
                            bVar.f29315b = true;
                            return;
                        }
                        bVar.f29316c = c1660a2;
                        this.l = c1660a2;
                        return;
                    }
                    b.a aVar = bVar2.p.get(i5);
                    String str = aVar.f29365i;
                    if (str != null) {
                        Uri d2 = u.d(bVar2.a, str);
                        if (!d2.equals(this.n)) {
                            bVar.a = f(d2, aVar.f29366j, b2, this.r.l(), this.r.j());
                            return;
                        } else if (!v.a(aVar.f29366j, this.p)) {
                            m(d2, aVar.f29366j, this.o);
                        }
                    } else {
                        a();
                    }
                    b.a aVar2 = bVar2.o;
                    c.i.b.a.h0.g gVar = aVar2 != null ? new c.i.b.a.h0.g(u.d(bVar2.a, aVar2.f29361e), aVar2.k, aVar2.l, null) : null;
                    long j6 = bVar2.f29355e + aVar.f29364h;
                    int i6 = bVar2.f29357g + aVar.f29363g;
                    bVar.a = new h(this.a, this.f29306b, new c.i.b.a.h0.g(u.d(bVar2.a, aVar.f29361e), aVar.k, aVar.l, null), gVar, c1660a2, this.f29312h, this.r.l(), this.r.j(), j6, j6 + aVar.f29362f, i2, i6, this.f29313i, this.f29308d.a(i6), hVar, bVar2.n, this.o, this.q);
                    return;
                }
            }
        }
        b2 = e2;
        a.C1660a c1660a22 = c1660a;
        c.i.b.a.d0.w.o.b bVar22 = v;
        i3 = bVar22.f29358h;
        if (i2 >= i3) {
        }
    }

    public s c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f29311g : (s) invokeV.objValue;
    }

    public c.i.b.a.f0.f d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.r : (c.i.b.a.f0.f) invokeV.objValue;
    }

    public void e() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            IOException iOException = this.k;
            if (iOException == null) {
                a.C1660a c1660a = this.l;
                if (c1660a != null) {
                    this.f29310f.A(c1660a);
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
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{uri, str, Integer.valueOf(i2), Integer.valueOf(i3), obj})) == null) ? new a(this.f29307c, new c.i.b.a.h0.g(uri, 0L, -1L, null, 1), this.f29309e[i2].f29352b, i3, obj, this.f29314j, str) : (a) invokeCommon.objValue;
    }

    public void g(c.i.b.a.d0.u.c cVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, cVar) == null) && (cVar instanceof a)) {
            a aVar = (a) cVar;
            this.f29314j = aVar.e();
            m(aVar.a.a, aVar.l, aVar.g());
        }
    }

    public boolean h(c.i.b.a.d0.u.c cVar, boolean z, IOException iOException) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{cVar, Boolean.valueOf(z), iOException})) == null) {
            if (z) {
                c.i.b.a.f0.f fVar = this.r;
                if (c.i.b.a.d0.u.h.a(fVar, fVar.c(this.f29311g.b(cVar.f29176c)), iOException)) {
                    return true;
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public void i(a.C1660a c1660a, long j2) {
        int b2;
        int c2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, c1660a, j2) == null) || (b2 = this.f29311g.b(c1660a.f29352b)) == -1 || (c2 = this.r.c(b2)) == -1) {
            return;
        }
        this.r.g(c2, j2);
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.k = null;
        }
    }

    public final long k(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048586, this, j2)) == null) {
            if (this.s != -9223372036854775807L) {
                return this.s - j2;
            }
            return -9223372036854775807L;
        }
        return invokeJ.longValue;
    }

    public void l(c.i.b.a.f0.f fVar) {
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
            this.f29313i = z;
        }
    }

    public final void o(c.i.b.a.d0.w.o.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, bVar) == null) {
            this.s = bVar.l ? -9223372036854775807L : bVar.c();
        }
    }
}
