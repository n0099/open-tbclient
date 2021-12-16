package c.i.b.a.d0.w;

import android.os.Handler;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.i.b.a.d0.b;
import c.i.b.a.d0.k;
import c.i.b.a.d0.o;
import c.i.b.a.d0.s;
import c.i.b.a.d0.t;
import c.i.b.a.d0.w.l;
import c.i.b.a.d0.w.o.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.coremedia.iso.boxes.sampleentry.AudioSampleEntry;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.List;
/* loaded from: classes9.dex */
public final class i implements c.i.b.a.d0.k, l.b, HlsPlaylistTracker.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final f f30154e;

    /* renamed from: f  reason: collision with root package name */
    public final HlsPlaylistTracker f30155f;

    /* renamed from: g  reason: collision with root package name */
    public final e f30156g;

    /* renamed from: h  reason: collision with root package name */
    public final int f30157h;

    /* renamed from: i  reason: collision with root package name */
    public final b.a f30158i;

    /* renamed from: j  reason: collision with root package name */
    public final c.i.b.a.h0.b f30159j;

    /* renamed from: k  reason: collision with root package name */
    public final IdentityHashMap<o, Integer> f30160k;
    public final m l;
    public final Handler m;
    public k.a n;
    public int o;
    public t p;
    public l[] q;
    public l[] r;
    public c.i.b.a.d0.e s;

    public i(f fVar, HlsPlaylistTracker hlsPlaylistTracker, e eVar, int i2, b.a aVar, c.i.b.a.h0.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar, hlsPlaylistTracker, eVar, Integer.valueOf(i2), aVar, bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f30154e = fVar;
        this.f30155f = hlsPlaylistTracker;
        this.f30156g = eVar;
        this.f30157h = i2;
        this.f30158i = aVar;
        this.f30159j = bVar;
        this.f30160k = new IdentityHashMap<>();
        this.l = new m();
        this.m = new Handler();
        this.q = new l[0];
        this.r = new l[0];
    }

    public static boolean u(a.C1639a c1639a, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, c1639a, str)) == null) {
            String str2 = c1639a.f30190b.codecs;
            if (TextUtils.isEmpty(str2)) {
                return false;
            }
            for (String str3 : str2.split("(\\s*,\\s*)|(\\s*$)")) {
                if (str3.startsWith(str)) {
                    return true;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.c
    public void a(a.C1639a c1639a, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048576, this, c1639a, j2) == null) {
            for (l lVar : this.q) {
                lVar.K(c1639a, j2);
            }
            p();
        }
    }

    @Override // c.i.b.a.d0.k, c.i.b.a.d0.p
    public boolean b(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2)) == null) ? this.s.b(j2) : invokeJ.booleanValue;
    }

    @Override // c.i.b.a.d0.k, c.i.b.a.d0.p
    public long c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.s.c() : invokeV.longValue;
    }

    @Override // c.i.b.a.d0.k, c.i.b.a.d0.p
    public long d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.s.d() : invokeV.longValue;
    }

    @Override // c.i.b.a.d0.k
    public long e(c.i.b.a.f0.f[] fVarArr, boolean[] zArr, o[] oVarArr, boolean[] zArr2, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{fVarArr, zArr, oVarArr, zArr2, Long.valueOf(j2)})) == null) {
            o[] oVarArr2 = oVarArr;
            int[] iArr = new int[fVarArr.length];
            int[] iArr2 = new int[fVarArr.length];
            for (int i2 = 0; i2 < fVarArr.length; i2++) {
                iArr[i2] = oVarArr2[i2] == null ? -1 : this.f30160k.get(oVarArr2[i2]).intValue();
                iArr2[i2] = -1;
                if (fVarArr[i2] != null) {
                    s d2 = fVarArr[i2].d();
                    int i3 = 0;
                    while (true) {
                        l[] lVarArr = this.q;
                        if (i3 >= lVarArr.length) {
                            break;
                        } else if (lVarArr[i3].k().b(d2) != -1) {
                            iArr2[i2] = i3;
                            break;
                        } else {
                            i3++;
                        }
                    }
                }
            }
            this.f30160k.clear();
            int length = fVarArr.length;
            o[] oVarArr3 = new o[length];
            o[] oVarArr4 = new o[fVarArr.length];
            c.i.b.a.f0.f[] fVarArr2 = new c.i.b.a.f0.f[fVarArr.length];
            l[] lVarArr2 = new l[this.q.length];
            int i4 = 0;
            int i5 = 0;
            boolean z = false;
            while (i5 < this.q.length) {
                for (int i6 = 0; i6 < fVarArr.length; i6++) {
                    c.i.b.a.f0.f fVar = null;
                    oVarArr4[i6] = iArr[i6] == i5 ? oVarArr2[i6] : null;
                    if (iArr2[i6] == i5) {
                        fVar = fVarArr[i6];
                    }
                    fVarArr2[i6] = fVar;
                }
                l lVar = this.q[i5];
                int i7 = i4;
                int i8 = length;
                int i9 = i5;
                c.i.b.a.f0.f[] fVarArr3 = fVarArr2;
                l[] lVarArr3 = lVarArr2;
                boolean R = lVar.R(fVarArr2, zArr, oVarArr4, zArr2, j2, z);
                int i10 = 0;
                boolean z2 = false;
                while (true) {
                    if (i10 >= fVarArr.length) {
                        break;
                    }
                    if (iArr2[i10] == i9) {
                        c.i.b.a.i0.a.f(oVarArr4[i10] != null);
                        oVarArr3[i10] = oVarArr4[i10];
                        this.f30160k.put(oVarArr4[i10], Integer.valueOf(i9));
                        z2 = true;
                    } else if (iArr[i10] == i9) {
                        c.i.b.a.i0.a.f(oVarArr4[i10] == null);
                    }
                    i10++;
                }
                if (z2) {
                    lVarArr3[i7] = lVar;
                    i4 = i7 + 1;
                    if (i7 == 0) {
                        lVar.S(true);
                        if (!R) {
                            l[] lVarArr4 = this.r;
                            if (lVarArr4.length != 0) {
                                if (lVar == lVarArr4[0]) {
                                }
                                this.l.b();
                                z = true;
                            }
                        }
                        this.l.b();
                        z = true;
                    } else {
                        lVar.S(false);
                    }
                } else {
                    i4 = i7;
                }
                i5 = i9 + 1;
                lVarArr2 = lVarArr3;
                length = i8;
                fVarArr2 = fVarArr3;
                oVarArr2 = oVarArr;
            }
            System.arraycopy(oVarArr3, 0, oVarArr2, 0, length);
            l[] lVarArr5 = (l[]) Arrays.copyOf(lVarArr2, i4);
            this.r = lVarArr5;
            this.s = new c.i.b.a.d0.e(lVarArr5);
            return j2;
        }
        return invokeCommon.longValue;
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.c
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            p();
        }
    }

    @Override // c.i.b.a.d0.k
    public long g(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048582, this, j2)) == null) {
            l[] lVarArr = this.r;
            if (lVarArr.length > 0) {
                boolean Q = lVarArr[0].Q(j2, false);
                int i2 = 1;
                while (true) {
                    l[] lVarArr2 = this.r;
                    if (i2 >= lVarArr2.length) {
                        break;
                    }
                    lVarArr2[i2].Q(j2, Q);
                    i2++;
                }
                if (Q) {
                    this.l.b();
                }
            }
            return j2;
        }
        return invokeJ.longValue;
    }

    @Override // c.i.b.a.d0.k
    public long h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return -9223372036854775807L;
        }
        return invokeV.longValue;
    }

    @Override // c.i.b.a.d0.w.l.b
    public void i(a.C1639a c1639a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, c1639a) == null) {
            this.f30155f.H(c1639a);
        }
    }

    @Override // c.i.b.a.d0.k
    public t k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.p : (t) invokeV.objValue;
    }

    public final void m(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048587, this, j2) == null) {
            c.i.b.a.d0.w.o.a u = this.f30155f.u();
            ArrayList arrayList = new ArrayList(u.f30185c);
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                a.C1639a c1639a = (a.C1639a) arrayList.get(i2);
                if (c1639a.f30190b.height <= 0 && !u(c1639a, "avc")) {
                    if (u(c1639a, AudioSampleEntry.TYPE3)) {
                        arrayList3.add(c1639a);
                    }
                } else {
                    arrayList2.add(c1639a);
                }
            }
            if (!arrayList2.isEmpty()) {
                arrayList = arrayList2;
            } else if (arrayList3.size() < arrayList.size()) {
                arrayList.removeAll(arrayList3);
            }
            List<a.C1639a> list = u.f30186d;
            List<a.C1639a> list2 = u.f30187e;
            l[] lVarArr = new l[list.size() + 1 + list2.size()];
            this.q = lVarArr;
            this.o = lVarArr.length;
            c.i.b.a.i0.a.a(!arrayList.isEmpty());
            a.C1639a[] c1639aArr = new a.C1639a[arrayList.size()];
            arrayList.toArray(c1639aArr);
            l n = n(0, c1639aArr, u.f30188f, u.f30189g, j2);
            this.q[0] = n;
            n.S(true);
            n.u();
            int i3 = 0;
            int i4 = 1;
            while (i3 < list.size()) {
                l n2 = n(1, new a.C1639a[]{list.get(i3)}, null, Collections.emptyList(), j2);
                this.q[i4] = n2;
                n2.u();
                i3++;
                i4++;
            }
            int i5 = 0;
            while (i5 < list2.size()) {
                a.C1639a c1639a2 = list2.get(i5);
                l n3 = n(3, new a.C1639a[]{c1639a2}, null, Collections.emptyList(), j2);
                n3.L(c1639a2.f30190b);
                this.q[i4] = n3;
                i5++;
                i4++;
            }
            this.r = this.q;
        }
    }

    public final l n(int i2, a.C1639a[] c1639aArr, Format format, List<Format> list, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{Integer.valueOf(i2), c1639aArr, format, list, Long.valueOf(j2)})) == null) ? new l(i2, this, new d(this.f30154e, this.f30155f, c1639aArr, this.f30156g, this.l, list), this.f30159j, j2, format, this.f30157h, this.f30158i) : (l) invokeCommon.objValue;
    }

    @Override // c.i.b.a.d0.k
    public void o(k.a aVar, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048589, this, aVar, j2) == null) {
            this.n = aVar;
            this.f30155f.o(this);
            m(j2);
        }
    }

    @Override // c.i.b.a.d0.w.l.b
    public void onPrepared() {
        l[] lVarArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            int i2 = this.o - 1;
            this.o = i2;
            if (i2 > 0) {
                return;
            }
            int i3 = 0;
            for (l lVar : this.q) {
                i3 += lVar.k().a;
            }
            s[] sVarArr = new s[i3];
            int i4 = 0;
            for (l lVar2 : this.q) {
                int i5 = lVar2.k().a;
                int i6 = 0;
                while (i6 < i5) {
                    sVarArr[i4] = lVar2.k().a(i6);
                    i6++;
                    i4++;
                }
            }
            this.p = new t(sVarArr);
            this.n.l(this);
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            if (this.p != null) {
                this.n.j(this);
                return;
            }
            for (l lVar : this.q) {
                lVar.u();
            }
        }
    }

    @Override // c.i.b.a.d0.k
    public void q() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            for (l lVar : this.q) {
                lVar.q();
            }
        }
    }

    @Override // c.i.b.a.d0.k
    public void r(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048593, this, j2) == null) {
            for (l lVar : this.r) {
                lVar.r(j2);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.i.b.a.d0.p.a
    /* renamed from: s */
    public void j(l lVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, lVar) == null) || this.p == null) {
            return;
        }
        this.n.j(this);
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.f30155f.J(this);
            this.m.removeCallbacksAndMessages(null);
            for (l lVar : this.q) {
                lVar.N();
            }
        }
    }
}
