package c.p.a.e.b.g;

import android.os.SystemClock;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.clientupdate.download.DownloadManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.yy.mobile.framework.revenuesdk.payservice.revenueservice.RevenueServerConst;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutorService;
/* loaded from: classes4.dex */
public class g {
    public static /* synthetic */ Interceptable $ic = null;
    public static String F = "ResponseHandler";
    public transient /* synthetic */ FieldHolder $fh;
    public long A;
    public long B;
    public long C;
    public volatile long D;
    public volatile long E;

    /* renamed from: a  reason: collision with root package name */
    public final DownloadInfo f35151a;

    /* renamed from: b  reason: collision with root package name */
    public final String f35152b;

    /* renamed from: c  reason: collision with root package name */
    public final com.ss.android.socialbase.downloader.model.b f35153c;

    /* renamed from: d  reason: collision with root package name */
    public final c.p.a.e.b.o.k f35154d;

    /* renamed from: e  reason: collision with root package name */
    public k f35155e;

    /* renamed from: f  reason: collision with root package name */
    public c.p.a.e.b.m.k f35156f;

    /* renamed from: g  reason: collision with root package name */
    public t f35157g;

    /* renamed from: h  reason: collision with root package name */
    public c.p.a.e.b.n.c f35158h;

    /* renamed from: i  reason: collision with root package name */
    public BaseException f35159i;

    /* renamed from: j  reason: collision with root package name */
    public volatile boolean f35160j;
    public volatile boolean k;
    public final c.p.a.e.b.k.f l;
    public long m;
    public long n;
    public volatile long o;
    public volatile long p;
    public final boolean q;
    public final c.p.a.e.b.j.a r;
    public final c.p.a.e.b.a.a s;
    public final boolean t;
    public final long u;
    public final long v;
    public final boolean w;
    public boolean x;
    public boolean y;
    public long z;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f35161e;

        public a(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f35161e = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    this.f35161e.f35154d.d();
                } catch (Throwable unused) {
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1473478600, "Lc/p/a/e/b/g/g;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1473478600, "Lc/p/a/e/b/g/g;");
        }
    }

    public g(DownloadInfo downloadInfo, String str, c.p.a.e.b.o.k kVar, com.ss.android.socialbase.downloader.model.b bVar, c.p.a.e.b.k.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {downloadInfo, str, kVar, bVar, fVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.y = false;
        this.D = 0L;
        this.E = 0L;
        this.f35151a = downloadInfo;
        this.f35152b = str;
        k M0 = e.M0();
        this.f35155e = M0;
        if (M0 instanceof c.p.a.e.b.m.d) {
            c.p.a.e.b.m.d dVar = (c.p.a.e.b.m.d) M0;
            this.f35156f = dVar.f();
            this.f35157g = dVar.k();
        }
        this.f35154d = kVar;
        this.f35153c = bVar;
        this.l = fVar;
        long n = bVar.n();
        this.m = n;
        this.n = n;
        if (bVar.d()) {
            this.p = bVar.q();
        } else {
            this.p = bVar.c(false);
        }
        this.o = bVar.p();
        this.s = c.p.a.e.b.a.a.c();
        c.p.a.e.b.j.a d2 = c.p.a.e.b.j.a.d(downloadInfo.getId());
        this.r = d2;
        boolean z = d2.b("sync_strategy", 0) == 1;
        this.t = z;
        if (z) {
            this.u = Math.max(this.r.b("sync_interval_ms_fg", 5000), 500L);
            this.v = Math.max(this.r.b("sync_interval_ms_bg", 1000), 500L);
        } else {
            this.u = 0L;
            this.v = 0L;
        }
        this.w = this.r.m("monitor_rw") == 1;
        this.q = c.p.a.e.b.l.a.a(65536);
    }

    public long a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.m : invokeV.longValue;
    }

    public final c.p.a.e.b.h.b b(InputStream inputStream) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, inputStream)) == null) {
            int h2 = e.h();
            if (this.r.b("rw_concurrent", 0) == 1 && this.f35151a.getChunkCount() == 1 && this.f35151a.getTotalBytes() > DownloadManager.MIN_LEFT_SIZE) {
                try {
                    c.p.a.e.b.h.a aVar = new c.p.a.e.b.h.a(inputStream, h2, this.r.b("rw_concurrent_max_buffer_count", 4));
                    this.x = true;
                    return aVar;
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            c.p.a.e.b.h.c cVar = new c.p.a.e.b.h.c(inputStream, h2);
            this.x = false;
            return cVar;
        }
        return (c.p.a.e.b.h.b) invokeL.objValue;
    }

    public void d(long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            this.o = j2;
            this.p = j3;
        }
    }

    public void e(long j2, long j3, long j4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4)}) == null) {
            this.m = j2;
            this.n = j2;
            this.o = j3;
            this.p = j4;
        }
    }

    public final void f(k kVar) {
        com.ss.android.socialbase.downloader.model.b bVar;
        com.ss.android.socialbase.downloader.model.b bVar2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, kVar) == null) || kVar == null) {
            return;
        }
        n nVar = null;
        boolean z = kVar instanceof com.ss.android.socialbase.downloader.b.e;
        if (z && (nVar = c.p.a.e.b.m.l.a(c.p.a.e.b.l.f.e0())) == null) {
            return;
        }
        n nVar2 = nVar;
        if (this.f35153c.d()) {
            bVar = this.f35153c.e();
        } else {
            bVar = this.f35153c;
        }
        com.ss.android.socialbase.downloader.model.b bVar3 = bVar;
        if (bVar3 != null) {
            bVar3.b(this.m);
            if (z && nVar2 != null) {
                nVar2.a(bVar3.k(), bVar3.s(), bVar3.b(), this.m);
                bVar2 = bVar3;
            } else {
                bVar2 = bVar3;
                kVar.a(bVar3.k(), bVar3.s(), bVar3.b(), this.m);
            }
            if (bVar2.h()) {
                boolean z2 = false;
                if (bVar2.i()) {
                    long j2 = bVar2.j();
                    if (j2 > this.m) {
                        if (z && nVar2 != null) {
                            nVar2.a(bVar2.k(), bVar2.b(), j2);
                        } else {
                            kVar.a(bVar2.k(), bVar2.b(), j2);
                        }
                        z2 = true;
                    }
                }
                if (z2) {
                    return;
                }
                if (z && nVar2 != null) {
                    nVar2.a(bVar2.k(), bVar2.b(), this.m);
                } else {
                    kVar.a(bVar2.k(), bVar2.b(), this.m);
                }
            }
        } else if (this.f35153c.d()) {
            if (z && nVar2 != null) {
                nVar2.a(this.f35153c.k(), this.f35153c.s(), this.m);
            } else {
                kVar.a(this.f35153c.k(), this.f35153c.s(), this.m);
            }
        }
    }

    public final void g(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            long uptimeMillis = SystemClock.uptimeMillis();
            long j2 = uptimeMillis - this.E;
            if (this.t) {
                if (j2 > (this.s.k() ? this.u : this.v)) {
                    o();
                    this.E = uptimeMillis;
                    return;
                }
                return;
            }
            long j3 = this.m - this.D;
            if (z || i(j3, j2)) {
                o();
                this.E = uptimeMillis;
            }
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.f35160j) {
            return;
        }
        this.f35160j = true;
        n();
    }

    public final boolean i(long j2, long j3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)})) == null) ? j2 > 65536 && j3 > 500 : invokeCommon.booleanValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || this.k) {
            return;
        }
        synchronized (this.l) {
            this.k = true;
        }
        n();
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:162:0x031e */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:164:0x0320 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:187:0x0358 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:189:0x035a */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:237:0x0400 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:201:0x038d  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x03ec A[Catch: all -> 0x0400, TRY_ENTER, TryCatch #15 {all -> 0x0400, blocks: (B:198:0x036a, B:199:0x0371, B:228:0x03ec, B:230:0x03f2, B:231:0x03f5, B:235:0x03fd, B:236:0x03ff), top: B:320:0x036a, inners: #12 }] */
    /* JADX WARN: Removed duplicated region for block: B:243:0x0428 A[Catch: all -> 0x0486, TRY_LEAVE, TryCatch #17 {all -> 0x0486, blocks: (B:241:0x0408, B:243:0x0428, B:271:0x047a, B:273:0x0480, B:274:0x0483, B:275:0x0485), top: B:322:0x0408 }] */
    /* JADX WARN: Removed duplicated region for block: B:273:0x0480 A[Catch: all -> 0x0486, TryCatch #17 {all -> 0x0486, blocks: (B:241:0x0408, B:243:0x0428, B:271:0x047a, B:273:0x0480, B:274:0x0483, B:275:0x0485), top: B:322:0x0408 }] */
    /* JADX WARN: Removed duplicated region for block: B:280:0x048c  */
    /* JADX WARN: Removed duplicated region for block: B:282:0x0491  */
    /* JADX WARN: Removed duplicated region for block: B:285:0x0498 A[Catch: all -> 0x04fb, TryCatch #13 {all -> 0x04fb, blocks: (B:283:0x0494, B:285:0x0498, B:286:0x049a, B:297:0x04b0, B:299:0x04b9, B:287:0x049b, B:289:0x049f, B:291:0x04a8, B:292:0x04ab), top: B:318:0x0494 }] */
    /* JADX WARN: Removed duplicated region for block: B:297:0x04b0 A[Catch: all -> 0x04fb, TryCatch #13 {all -> 0x04fb, blocks: (B:283:0x0494, B:285:0x0498, B:286:0x049a, B:297:0x04b0, B:299:0x04b9, B:287:0x049b, B:289:0x049f, B:291:0x04a8, B:292:0x04ab), top: B:318:0x0494 }] */
    /* JADX WARN: Removed duplicated region for block: B:320:0x036a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:332:0x019b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0172 A[Catch: BaseException -> 0x0112, all -> 0x0324, TRY_LEAVE, TryCatch #26 {BaseException -> 0x0112, blocks: (B:51:0x010d, B:57:0x011d, B:64:0x013b, B:66:0x0141, B:68:0x014c, B:70:0x015b, B:75:0x0172, B:79:0x0182, B:89:0x01c1, B:91:0x01c9, B:93:0x01d1, B:95:0x01d9, B:97:0x01e1, B:139:0x02dc, B:143:0x02e4, B:147:0x02f0, B:151:0x02f6, B:152:0x02f9, B:154:0x030c, B:155:0x0312, B:156:0x0313, B:157:0x0319), top: B:311:0x010d }] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0182 A[Catch: BaseException -> 0x0112, all -> 0x0324, TRY_ENTER, TRY_LEAVE, TryCatch #26 {BaseException -> 0x0112, blocks: (B:51:0x010d, B:57:0x011d, B:64:0x013b, B:66:0x0141, B:68:0x014c, B:70:0x015b, B:75:0x0172, B:79:0x0182, B:89:0x01c1, B:91:0x01c9, B:93:0x01d1, B:95:0x01d9, B:97:0x01e1, B:139:0x02dc, B:143:0x02e4, B:147:0x02f0, B:151:0x02f6, B:152:0x02f9, B:154:0x030c, B:155:0x0312, B:156:0x0313, B:157:0x0319), top: B:311:0x010d }] */
    /* JADX WARN: Type inference failed for: r2v0, types: [long] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v26, types: [int] */
    /* JADX WARN: Type inference failed for: r2v29 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v30 */
    /* JADX WARN: Type inference failed for: r2v35 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v49 */
    /* JADX WARN: Type inference failed for: r2v5, types: [int] */
    /* JADX WARN: Type inference failed for: r2v50 */
    /* JADX WARN: Type inference failed for: r2v52 */
    /* JADX WARN: Type inference failed for: r2v53 */
    /* JADX WARN: Type inference failed for: r2v8, types: [int] */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v10, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v17 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void k() throws BaseException {
        boolean z;
        boolean z2;
        c.p.a.e.b.h.b bVar;
        c.p.a.e.b.h.b bVar2;
        c.p.a.e.b.o.k kVar;
        boolean z3;
        boolean z4;
        c.p.a.e.b.o.k kVar2;
        String str;
        DownloadInfo downloadInfo;
        c.p.a.e.b.j.a aVar;
        boolean z5;
        int i2;
        c.p.a.e.b.n.c f2;
        InputStream a2;
        boolean z6;
        long j2;
        long j3;
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || m() || this.f35153c == null) {
            return;
        }
        int d2 = c.p.a.e.b.l.f.d(this.f35154d);
        if (d2 != 0) {
            long l = this.f35153c.l();
            long nanoTime = System.nanoTime();
            boolean z7 = this.w;
            boolean z8 = this.f35154d instanceof c.p.a.e.b.o.c;
            int i5 = 1;
            try {
                try {
                    try {
                        z2 = "flush_buffer_size_byte";
                        i2 = -1;
                        f2 = c.p.a.e.b.l.f.f(this.f35151a, this.f35151a.getTempPath(), this.f35151a.getTempName(), this.r.b("flush_buffer_size_byte", -1));
                        this.f35158h = f2;
                    } catch (BaseException e2) {
                        e = e2;
                        z2 = z7;
                        d2 = 1;
                    }
                } catch (BaseException e3) {
                    e = e3;
                    z2 = z7;
                    d2 = 1;
                    bVar = null;
                }
            } catch (Throwable th) {
                th = th;
                z = z8;
                z2 = z7;
                d2 = 1;
            }
            try {
                try {
                    f2.a(this.m);
                    a2 = this.f35154d.a();
                } catch (IOException e4) {
                    throw new BaseException((int) RevenueServerConst.ChargeCurrencyHistoryRequest, e4);
                }
            } catch (BaseException e5) {
                e = e5;
                bVar = null;
                d2 = d2;
                z2 = z2;
                try {
                    c.p.a.e.b.c.a.j(F, "handleResponse: BaseException e = " + e);
                    if (!this.r.l("ignore_base_ex_on_stop_status")) {
                    }
                    if (c.p.a.e.b.c.a.e()) {
                    }
                    this.f35159i = e;
                    throw e;
                } catch (Throwable th2) {
                    th = th2;
                    bVar2 = bVar;
                    kVar = this.f35154d;
                    if (kVar != null) {
                    }
                    if (bVar2 != null) {
                    }
                    try {
                        if (!this.q) {
                        }
                        Closeable[] closeableArr = new Closeable[d2];
                        closeableArr[0] = this.f35158h;
                        c.p.a.e.b.l.f.E(closeableArr);
                        this.C = System.nanoTime() - nanoTime;
                        c.p.a.e.b.e.a.f(this.r, this.f35151a, this.f35152b, this.f35154d, this.f35160j, this.k, this.f35159i, this.m - this.n, this.C, z2, this.z, this.A, this.B, null);
                        throw th;
                    } catch (Throwable th3) {
                        Closeable[] closeableArr2 = new Closeable[d2];
                        closeableArr2[0] = this.f35158h;
                        c.p.a.e.b.l.f.E(closeableArr2);
                        throw th3;
                    }
                }
            } catch (Throwable th4) {
                th = th4;
                bVar2 = null;
                if (z) {
                }
                c.p.a.e.b.c.a.j(F, "handleResponse: e = " + th);
                if (!m()) {
                }
            }
            if (a2 != null) {
                this.f35151a.updateRealStartDownloadTime();
                bVar2 = b(a2);
                try {
                    this.f35151a.setIsRwConcurrent(this.x);
                    this.y = this.f35151a.getOpenLimitSpeed();
                    long j4 = c.p.a.e.b.d.c.f35109d;
                    long j5 = c.p.a.e.b.d.c.f35110e;
                    long j6 = j4 / (1000 / j5);
                    long currentTimeMillis = System.currentTimeMillis();
                    long j7 = 0;
                    long j8 = 0;
                    while (!m()) {
                        z2 = z7;
                        if (z2) {
                            try {
                                try {
                                    j7 = System.nanoTime();
                                } catch (Throwable th5) {
                                    th = th5;
                                    z = z8;
                                    d2 = 1;
                                    if (z) {
                                        try {
                                            ((c.p.a.e.b.o.c) this.f35154d).b(th);
                                        } catch (Throwable th6) {
                                            th = th6;
                                            kVar = this.f35154d;
                                            if (kVar != null) {
                                                kVar.d();
                                            }
                                            if (bVar2 != null) {
                                                bVar2.b();
                                            }
                                            if (!this.q) {
                                                synchronized (this.l) {
                                                    if (!this.k) {
                                                        f(this.f35156f);
                                                        if (this.f35158h != null) {
                                                            o();
                                                        }
                                                    }
                                                }
                                            } else {
                                                f(this.f35156f);
                                                if (this.f35158h != null) {
                                                    o();
                                                }
                                            }
                                            Closeable[] closeableArr3 = new Closeable[d2];
                                            closeableArr3[0] = this.f35158h;
                                            c.p.a.e.b.l.f.E(closeableArr3);
                                            this.C = System.nanoTime() - nanoTime;
                                            c.p.a.e.b.e.a.f(this.r, this.f35151a, this.f35152b, this.f35154d, this.f35160j, this.k, this.f35159i, this.m - this.n, this.C, z2, this.z, this.A, this.B, null);
                                            throw th;
                                        }
                                    }
                                    c.p.a.e.b.c.a.j(F, "handleResponse: e = " + th);
                                    if (!m()) {
                                        c.p.a.e.b.o.k kVar3 = this.f35154d;
                                        if (kVar3 != null) {
                                            kVar3.d();
                                        }
                                        if (bVar2 != null) {
                                            bVar2.b();
                                        }
                                        try {
                                            if (this.q) {
                                                synchronized (this.l) {
                                                    if (!this.k) {
                                                        f(this.f35156f);
                                                        if (this.f35158h != null) {
                                                            o();
                                                        }
                                                    }
                                                }
                                            } else {
                                                f(this.f35156f);
                                                if (this.f35158h != null) {
                                                    o();
                                                }
                                            }
                                            Closeable[] closeableArr4 = new Closeable[d2];
                                            closeableArr4[0] = this.f35158h;
                                            c.p.a.e.b.l.f.E(closeableArr4);
                                            z5 = z2;
                                            this.C = System.nanoTime() - nanoTime;
                                            aVar = this.r;
                                            downloadInfo = this.f35151a;
                                            str = this.f35152b;
                                            kVar2 = this.f35154d;
                                            z4 = this.f35160j;
                                            z3 = this.k;
                                            c.p.a.e.b.e.a.f(aVar, downloadInfo, str, kVar2, z4, z3, this.f35159i, this.m - this.n, this.C, z5, this.z, this.A, this.B, null);
                                            return;
                                        } catch (Throwable th7) {
                                            Closeable[] closeableArr5 = new Closeable[d2];
                                            closeableArr5[0] = this.f35158h;
                                            c.p.a.e.b.l.f.E(closeableArr5);
                                            throw th7;
                                        }
                                    }
                                    if (c.p.a.e.b.c.a.e()) {
                                        th.printStackTrace();
                                    }
                                    try {
                                        c.p.a.e.b.l.f.B(th, "ResponseHandler");
                                        throw null;
                                    } catch (BaseException e6) {
                                        this.f35159i = e6;
                                        throw e6;
                                    }
                                }
                            } catch (BaseException e7) {
                                e = e7;
                                bVar = bVar2;
                                d2 = 1;
                                z2 = z2;
                                c.p.a.e.b.c.a.j(F, "handleResponse: BaseException e = " + e);
                                if (!this.r.l("ignore_base_ex_on_stop_status")) {
                                }
                                if (c.p.a.e.b.c.a.e()) {
                                }
                                this.f35159i = e;
                                throw e;
                            }
                        }
                        try {
                            c.p.a.e.b.i.a a3 = bVar2.a();
                            if (z2) {
                                this.z += System.nanoTime() - j7;
                            }
                            int i6 = a3.f35189c;
                            if (i6 == i2) {
                                j2 = l;
                            } else {
                                if (this.f35151a.isIgnoreDataVerify()) {
                                    j2 = l;
                                    z = z8;
                                    j3 = j6;
                                    i3 = i6;
                                } else {
                                    z = z8;
                                    j3 = j6;
                                    try {
                                        j2 = l;
                                        if (this.p > this.m - this.n) {
                                            i3 = i6;
                                            if (this.p < (this.m - this.n) + i3) {
                                                i4 = (int) (this.p - (this.m - this.n));
                                                if (z2) {
                                                    j7 = System.nanoTime();
                                                }
                                                this.f35158h.a(a3.f35187a, 0, i4);
                                                if (z2) {
                                                    this.A += System.nanoTime() - j7;
                                                }
                                                bVar2.a(a3);
                                                long j9 = i4;
                                                this.m += j9;
                                                j8 += j9;
                                                synchronized (this.l) {
                                                    try {
                                                        if (this.q) {
                                                            if (!this.k) {
                                                                boolean b2 = this.l.b(j9);
                                                                f(this.f35156f);
                                                                g(b2);
                                                            }
                                                        } else {
                                                            boolean b3 = this.l.b(j9);
                                                            f(this.f35156f);
                                                            g(b3);
                                                        }
                                                    } catch (Throwable th8) {
                                                        th = th8;
                                                        d2 = 1;
                                                        z6 = true;
                                                        while (true) {
                                                            try {
                                                                try {
                                                                    break;
                                                                } catch (BaseException e8) {
                                                                    e = e8;
                                                                    bVar = bVar2;
                                                                    d2 = z6;
                                                                    z2 = z2;
                                                                    c.p.a.e.b.c.a.j(F, "handleResponse: BaseException e = " + e);
                                                                    if (!this.r.l("ignore_base_ex_on_stop_status")) {
                                                                    }
                                                                    if (c.p.a.e.b.c.a.e()) {
                                                                    }
                                                                    this.f35159i = e;
                                                                    throw e;
                                                                } catch (Throwable th9) {
                                                                    th = th9;
                                                                    if (z) {
                                                                    }
                                                                    c.p.a.e.b.c.a.j(F, "handleResponse: e = " + th);
                                                                    if (!m()) {
                                                                    }
                                                                }
                                                            } catch (Throwable th10) {
                                                                th = th10;
                                                            }
                                                        }
                                                        throw th;
                                                    }
                                                }
                                                if (this.f35151a.isDownloadWithWifiValid()) {
                                                    if (this.f35151a.isPauseReserveWithWifiValid()) {
                                                        if (this.f35151a.isIgnoreDataVerify() || this.p < 0 || this.p > this.m - this.n) {
                                                            if (this.y && j8 > j3) {
                                                                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                                                                if (currentTimeMillis2 < j5) {
                                                                    try {
                                                                        Thread.sleep(j5 - currentTimeMillis2);
                                                                    } catch (InterruptedException e9) {
                                                                        e9.printStackTrace();
                                                                    }
                                                                }
                                                                j8 = 0;
                                                                currentTimeMillis = System.currentTimeMillis();
                                                            }
                                                            z7 = z2;
                                                            z8 = z;
                                                            j6 = j3;
                                                            l = j2;
                                                            i2 = -1;
                                                            i5 = 1;
                                                        }
                                                    } else {
                                                        throw new com.ss.android.socialbase.downloader.exception.e();
                                                    }
                                                } else {
                                                    throw new com.ss.android.socialbase.downloader.exception.c();
                                                }
                                            }
                                        } else {
                                            i3 = i6;
                                        }
                                    } catch (Throwable th11) {
                                        th = th11;
                                        d2 = 1;
                                        if (z) {
                                        }
                                        c.p.a.e.b.c.a.j(F, "handleResponse: e = " + th);
                                        if (!m()) {
                                        }
                                    }
                                }
                                i4 = i3;
                                if (z2) {
                                }
                                this.f35158h.a(a3.f35187a, 0, i4);
                                if (z2) {
                                }
                                bVar2.a(a3);
                                long j92 = i4;
                                this.m += j92;
                                j8 += j92;
                                synchronized (this.l) {
                                }
                            }
                            c.p.a.e.b.o.k kVar4 = this.f35154d;
                            if (kVar4 != null) {
                                kVar4.d();
                            }
                            if (bVar2 != null) {
                                bVar2.b();
                            }
                            try {
                                if (this.q) {
                                    synchronized (this.l) {
                                        if (!this.k) {
                                            f(this.f35156f);
                                            if (this.f35158h != null) {
                                                o();
                                            }
                                        }
                                    }
                                } else {
                                    f(this.f35156f);
                                    if (this.f35158h != null) {
                                        o();
                                    }
                                }
                                c.p.a.e.b.l.f.E(this.f35158h);
                                this.C = System.nanoTime() - nanoTime;
                                c.p.a.e.b.e.a.f(this.r, this.f35151a, this.f35152b, this.f35154d, this.f35160j, this.k, this.f35159i, this.m - this.n, this.C, z2, this.z, this.A, this.B, null);
                                if (this.f35151a.isIgnoreDataVerify()) {
                                    return;
                                }
                                long j10 = this.m - this.n;
                                if (j10 >= 0 && this.p >= 0 && this.p != j10) {
                                    throw new BaseException(1051, String.format("handle data length[%d] != content length[%d] downloadChunkContentLen[%d], range[%d, %d) , current offset[%d] , handle start from %d", Long.valueOf(j10), Long.valueOf((long) d2), Long.valueOf(this.p), Long.valueOf(j2), Long.valueOf(this.o), Long.valueOf(this.m), Long.valueOf(this.n)));
                                }
                                return;
                            } catch (Throwable th12) {
                                c.p.a.e.b.l.f.E(this.f35158h);
                                throw th12;
                            }
                        } catch (BaseException e10) {
                            e = e10;
                            z6 = true;
                            bVar = bVar2;
                            d2 = z6;
                            z2 = z2;
                            c.p.a.e.b.c.a.j(F, "handleResponse: BaseException e = " + e);
                            if (!this.r.l("ignore_base_ex_on_stop_status") && m()) {
                                c.p.a.e.b.o.k kVar5 = this.f35154d;
                                if (kVar5 != null) {
                                    kVar5.d();
                                }
                                if (bVar != null) {
                                    bVar.b();
                                }
                                try {
                                    if (this.q) {
                                        synchronized (this.l) {
                                            if (!this.k) {
                                                f(this.f35156f);
                                                if (this.f35158h != null) {
                                                    o();
                                                }
                                            }
                                        }
                                    } else {
                                        f(this.f35156f);
                                        if (this.f35158h != null) {
                                            o();
                                        }
                                    }
                                    Closeable[] closeableArr6 = new Closeable[d2];
                                    closeableArr6[0] = this.f35158h;
                                    c.p.a.e.b.l.f.E(closeableArr6);
                                    z5 = z2;
                                    this.C = System.nanoTime() - nanoTime;
                                    aVar = this.r;
                                    downloadInfo = this.f35151a;
                                    str = this.f35152b;
                                    kVar2 = this.f35154d;
                                    z4 = this.f35160j;
                                    z3 = this.k;
                                    c.p.a.e.b.e.a.f(aVar, downloadInfo, str, kVar2, z4, z3, this.f35159i, this.m - this.n, this.C, z5, this.z, this.A, this.B, null);
                                    return;
                                } catch (Throwable th13) {
                                    Closeable[] closeableArr7 = new Closeable[d2];
                                    closeableArr7[0] = this.f35158h;
                                    c.p.a.e.b.l.f.E(closeableArr7);
                                    throw th13;
                                }
                            }
                            if (c.p.a.e.b.c.a.e()) {
                                e.printStackTrace();
                            }
                            this.f35159i = e;
                            throw e;
                        }
                    }
                    c.p.a.e.b.o.k kVar6 = this.f35154d;
                    if (kVar6 != null) {
                        kVar6.d();
                    }
                    if (bVar2 != null) {
                        bVar2.b();
                    }
                    try {
                        if (this.q) {
                            synchronized (this.l) {
                                if (!this.k) {
                                    f(this.f35156f);
                                    if (this.f35158h != null) {
                                        o();
                                    }
                                }
                            }
                        } else {
                            f(this.f35156f);
                            if (this.f35158h != null) {
                                o();
                            }
                        }
                        Closeable[] closeableArr8 = new Closeable[i5];
                        closeableArr8[0] = this.f35158h;
                        c.p.a.e.b.l.f.E(closeableArr8);
                        this.C = System.nanoTime() - nanoTime;
                        aVar = this.r;
                        downloadInfo = this.f35151a;
                        str = this.f35152b;
                        kVar2 = this.f35154d;
                        z4 = this.f35160j;
                        z5 = z7;
                        z3 = this.k;
                    } catch (Throwable th14) {
                        Closeable[] closeableArr9 = new Closeable[i5];
                        closeableArr9[0] = this.f35158h;
                        c.p.a.e.b.l.f.E(closeableArr9);
                        throw th14;
                    }
                } catch (BaseException e11) {
                    e = e11;
                    z2 = z7;
                } catch (Throwable th15) {
                    th = th15;
                    z = z8;
                    z2 = z7;
                }
                c.p.a.e.b.e.a.f(aVar, downloadInfo, str, kVar2, z4, z3, this.f35159i, this.m - this.n, this.C, z5, this.z, this.A, this.B, null);
                return;
            }
            throw new BaseException(1042, new IOException("inputStream is null"));
        }
        throw new com.ss.android.socialbase.downloader.exception.f(1004, "the content-length is 0");
    }

    public long l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.D : invokeV.longValue;
    }

    public final boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f35160j || this.k : invokeV.booleanValue;
    }

    public final void n() {
        ExecutorService A0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || this.f35154d == null || (A0 = e.A0()) == null) {
            return;
        }
        A0.execute(new a(this));
    }

    public final void o() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            long nanoTime = this.w ? System.nanoTime() : 0L;
            try {
                this.f35158h.g();
                z = true;
            } catch (Exception unused) {
                z = false;
            }
            if (z) {
                this.f35151a.updateRealDownloadTime(true);
                boolean z2 = this.f35151a.getChunkCount() > 1;
                n a2 = c.p.a.e.b.m.l.a(c.p.a.e.b.l.f.e0());
                if (z2) {
                    f(this.f35157g);
                    if (a2 != null) {
                        a2.c(this.f35151a);
                    } else {
                        this.f35157g.a(this.f35151a.getId(), this.f35151a.getCurBytes());
                    }
                } else if (a2 != null) {
                    a2.c(this.f35151a);
                } else {
                    this.f35157g.a(this.f35153c.k(), this.m);
                }
                this.D = this.m;
            }
            if (this.w) {
                this.B += System.nanoTime() - nanoTime;
            }
        }
    }
}
