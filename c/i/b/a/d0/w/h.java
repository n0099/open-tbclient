package c.i.b.a.d0.w;

import android.util.Pair;
import androidx.core.view.InputDeviceCompat;
import c.i.b.a.d0.w.o.a;
import c.i.b.a.i0.s;
import c.i.b.a.i0.v;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.id3.PrivFrame;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes9.dex */
public final class h extends c.i.b.a.d0.u.l {
    public static /* synthetic */ Interceptable $ic;
    public static final AtomicInteger E;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public boolean B;
    public volatile boolean C;
    public volatile boolean D;

    /* renamed from: j  reason: collision with root package name */
    public final int f29290j;
    public final int k;
    public final a.C1659a l;
    public final c.i.b.a.h0.e m;
    public final c.i.b.a.h0.g n;
    public final boolean o;
    public final boolean p;
    public final s q;
    public final boolean r;
    public final c.i.b.a.a0.e s;
    public final boolean t;
    public final boolean u;
    public final c.i.b.a.c0.g.a v;
    public final c.i.b.a.i0.l w;
    public l x;
    public int y;
    public int z;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2077398763, "Lc/i/b/a/d0/w/h;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2077398763, "Lc/i/b/a/d0/w/h;");
                return;
            }
        }
        E = new AtomicInteger();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(f fVar, c.i.b.a.h0.e eVar, c.i.b.a.h0.g gVar, c.i.b.a.h0.g gVar2, a.C1659a c1659a, List<Format> list, int i2, Object obj, long j2, long j3, int i3, int i4, boolean z, s sVar, h hVar, DrmInitData drmInitData, byte[] bArr, byte[] bArr2) {
        super(f(eVar, bArr, bArr2), gVar, c1659a.f29324b, i2, obj, j2, j3, i3);
        c.i.b.a.h0.g gVar3;
        c.i.b.a.a0.e eVar2;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {fVar, eVar, gVar, gVar2, c1659a, list, Integer.valueOf(i2), obj, Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z), sVar, hVar, drmInitData, bArr, bArr2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i5 = newInitContext.flag;
            if ((i5 & 1) != 0) {
                int i6 = i5 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((c.i.b.a.h0.e) objArr2[0], (c.i.b.a.h0.g) objArr2[1], (Format) objArr2[2], ((Integer) objArr2[3]).intValue(), objArr2[4], ((Long) objArr2[5]).longValue(), ((Long) objArr2[6]).longValue(), ((Integer) objArr2[7]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.k = i4;
        this.n = gVar2;
        this.l = c1659a;
        this.p = z;
        this.q = sVar;
        this.o = this.f29153h instanceof a;
        boolean z2 = true;
        if (hVar != null) {
            boolean z3 = hVar.l != c1659a;
            this.r = z3;
            eVar2 = (hVar.k != i4 || z3) ? null : hVar.s;
            gVar3 = gVar;
        } else {
            this.r = false;
            gVar3 = gVar;
            eVar2 = null;
        }
        Pair<c.i.b.a.a0.e, Boolean> a = fVar.a(eVar2, gVar3.a, this.f29148c, list, drmInitData, sVar);
        this.s = (c.i.b.a.a0.e) a.first;
        this.t = ((Boolean) a.second).booleanValue();
        boolean z4 = this.s == eVar2;
        this.u = z4;
        this.B = (!z4 || gVar2 == null) ? false : false;
        if (this.t) {
            this.v = hVar != null ? hVar.v : new c.i.b.a.c0.g.a();
            this.w = hVar != null ? hVar.w : new c.i.b.a.i0.l(10);
        } else {
            this.v = null;
            this.w = null;
        }
        this.m = eVar;
        this.f29290j = E.getAndIncrement();
    }

    public static c.i.b.a.h0.e f(c.i.b.a.h0.e eVar, byte[] bArr, byte[] bArr2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, eVar, bArr, bArr2)) == null) ? bArr != null ? new a(eVar, bArr, bArr2) : eVar : (c.i.b.a.h0.e) invokeLLL.objValue;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.c
    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.C : invokeV.booleanValue;
    }

    @Override // c.i.b.a.d0.u.c
    public long b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.z : invokeV.longValue;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.c
    public void cancelLoad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.C = true;
        }
    }

    @Override // c.i.b.a.d0.u.l
    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.D : invokeV.booleanValue;
    }

    public void g(l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, lVar) == null) {
            this.x = lVar;
            lVar.B(this.f29290j, this.r);
            if (this.u) {
                return;
            }
            this.s.f(lVar);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0020  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0065 A[Catch: all -> 0x00a8, TryCatch #1 {all -> 0x00a8, blocks: (B:17:0x003c, B:19:0x0050, B:21:0x0054, B:23:0x0065, B:25:0x006e, B:24:0x006c, B:27:0x0073, B:36:0x0094, B:29:0x007a, B:31:0x007e), top: B:45:0x003c }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x006c A[Catch: all -> 0x00a8, TryCatch #1 {all -> 0x00a8, blocks: (B:17:0x003c, B:19:0x0050, B:21:0x0054, B:23:0x0065, B:25:0x006e, B:24:0x006c, B:27:0x0073, B:36:0x0094, B:29:0x007a, B:31:0x007e), top: B:45:0x003c }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0073 A[Catch: all -> 0x00a8, TRY_LEAVE, TryCatch #1 {all -> 0x00a8, blocks: (B:17:0x003c, B:19:0x0050, B:21:0x0054, B:23:0x0065, B:25:0x006e, B:24:0x006c, B:27:0x0073, B:36:0x0094, B:29:0x007a, B:31:0x007e), top: B:45:0x003c }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void h() throws IOException, InterruptedException {
        c.i.b.a.h0.g b2;
        boolean z;
        c.i.b.a.a0.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(1048581, this) != null) {
            return;
        }
        int i2 = 0;
        try {
            if (this.o) {
                b2 = this.a;
                if (this.z != 0) {
                    z = true;
                    if (this.p) {
                        this.q.j();
                    } else if (this.q.c() == Long.MAX_VALUE) {
                        this.q.h(this.f29151f);
                    }
                    bVar = new c.i.b.a.a0.b(this.f29153h, b2.f29628c, this.f29153h.a(b2));
                    if (this.t && !this.A) {
                        long j2 = j(bVar);
                        this.A = true;
                        this.x.T(j2 == -9223372036854775807L ? this.q.b(j2) : this.f29151f);
                    }
                    if (z) {
                        bVar.h(this.z);
                    }
                    while (i2 == 0 && !this.C) {
                        i2 = this.s.e(bVar, null);
                    }
                    this.z = (int) (bVar.getPosition() - this.a.f29628c);
                    v.h(this.f29153h);
                    this.D = true;
                    return;
                }
            } else {
                b2 = this.a.b(this.z);
            }
            bVar = new c.i.b.a.a0.b(this.f29153h, b2.f29628c, this.f29153h.a(b2));
            if (this.t) {
                long j22 = j(bVar);
                this.A = true;
                this.x.T(j22 == -9223372036854775807L ? this.q.b(j22) : this.f29151f);
            }
            if (z) {
            }
            while (i2 == 0) {
                i2 = this.s.e(bVar, null);
            }
            this.z = (int) (bVar.getPosition() - this.a.f29628c);
            v.h(this.f29153h);
            this.D = true;
            return;
        } catch (Throwable th) {
            v.h(this.f29153h);
            throw th;
        }
        z = false;
        if (this.p) {
        }
    }

    public final void i() throws IOException, InterruptedException {
        c.i.b.a.h0.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.B || (gVar = this.n) == null) {
            return;
        }
        c.i.b.a.h0.g b2 = gVar.b(this.y);
        try {
            c.i.b.a.a0.b bVar = new c.i.b.a.a0.b(this.m, b2.f29628c, this.m.a(b2));
            int i2 = 0;
            while (i2 == 0 && !this.C) {
                i2 = this.s.e(bVar, null);
            }
            this.y = (int) (bVar.getPosition() - this.n.f29628c);
            v.h(this.f29153h);
            this.B = true;
        } catch (Throwable th) {
            v.h(this.f29153h);
            throw th;
        }
    }

    public final long j(c.i.b.a.a0.f fVar) throws IOException, InterruptedException {
        InterceptResult invokeL;
        Metadata c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, fVar)) == null) {
            fVar.e();
            if (fVar.d(this.w.a, 0, 10, true)) {
                this.w.G(10);
                if (this.w.A() != c.i.b.a.c0.g.a.f29002b) {
                    return -9223372036854775807L;
                }
                this.w.K(3);
                int w = this.w.w();
                int i2 = w + 10;
                if (i2 > this.w.b()) {
                    c.i.b.a.i0.l lVar = this.w;
                    byte[] bArr = lVar.a;
                    lVar.G(i2);
                    System.arraycopy(bArr, 0, this.w.a, 0, 10);
                }
                if (fVar.d(this.w.a, 10, w, true) && (c2 = this.v.c(this.w.a, w)) != null) {
                    int length = c2.length();
                    for (int i3 = 0; i3 < length; i3++) {
                        Metadata.Entry entry = c2.get(i3);
                        if (entry instanceof PrivFrame) {
                            PrivFrame privFrame = (PrivFrame) entry;
                            if ("com.apple.streaming.transportStreamTimestamp".equals(privFrame.owner)) {
                                System.arraycopy(privFrame.privateData, 0, this.w.a, 0, 8);
                                this.w.G(8);
                                return this.w.q();
                            }
                        }
                    }
                    return -9223372036854775807L;
                }
                return -9223372036854775807L;
            }
            return -9223372036854775807L;
        }
        return invokeL.longValue;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.c
    public void load() throws IOException, InterruptedException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            i();
            if (this.C) {
                return;
            }
            h();
        }
    }
}
