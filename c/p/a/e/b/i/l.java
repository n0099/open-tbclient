package c.p.a.e.b.i;

import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.f.p;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
/* loaded from: classes4.dex */
public class l implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public int B;
    public long C;
    public int D;
    public boolean E;
    public BaseException F;
    public boolean G;
    public c.p.a.e.b.l.e H;
    public volatile long I;
    public volatile long J;
    public volatile long K;
    public volatile long L;
    public String M;
    public String N;
    public String O;

    /* renamed from: e  reason: collision with root package name */
    public final f f35237e;

    /* renamed from: f  reason: collision with root package name */
    public final c f35238f;

    /* renamed from: g  reason: collision with root package name */
    public final DownloadInfo f35239g;

    /* renamed from: h  reason: collision with root package name */
    public final c.p.a.e.b.j.a f35240h;

    /* renamed from: i  reason: collision with root package name */
    public c.p.a.e.b.o.k f35241i;

    /* renamed from: j  reason: collision with root package name */
    public c.p.a.e.b.n.b f35242j;
    public final List<i> k;
    public volatile i l;
    public o m;
    public long n;
    public volatile long o;
    public volatile long p;
    public volatile long q;
    public volatile long r;
    public Future s;
    public volatile boolean t;
    public volatile boolean u;
    public volatile boolean v;
    public Thread w;
    public final int x;
    public volatile boolean y;
    public int z;

    public l(DownloadInfo downloadInfo, j jVar, c cVar, o oVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {downloadInfo, jVar, cVar, oVar, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.k = new ArrayList();
        this.q = -1L;
        this.f35239g = downloadInfo;
        this.f35237e = jVar;
        this.f35238f = cVar;
        this.f35240h = c.p.a.e.b.j.a.d(downloadInfo.getId());
        this.m = oVar;
        this.x = i2;
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.A = this.m.f35248d ? this.f35239g.getRetryCount() : this.f35239g.getBackUpUrlRetryCount();
            this.B = 0;
        }
    }

    public final long B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            long j2 = this.o;
            this.o = 0L;
            if (j2 <= 0) {
                return Long.MAX_VALUE;
            }
            return j2;
        }
        return invokeV.longValue;
    }

    public long a(long j2, long j3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)})) == null) {
            c.p.a.e.b.l.e eVar = this.H;
            if (eVar == null) {
                return -1L;
            }
            return eVar.d(j2, j3);
        }
        return invokeCommon.longValue;
    }

    public final a b(c cVar, InputStream inputStream) throws InterruptedException, BaseException, IOException {
        InterceptResult invokeLL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, cVar, inputStream)) == null) {
            a b2 = cVar.b();
            try {
                i2 = inputStream.read(b2.f35187a);
            } catch (Throwable th) {
                th = th;
                i2 = -1;
            }
            try {
                if (i2 != -1) {
                    b2.f35189c = i2;
                    if (i2 == -1) {
                        cVar.a(b2);
                    }
                    return b2;
                }
                throw new BaseException(1073, "probe");
            } catch (Throwable th2) {
                th = th2;
                if (i2 == -1) {
                    cVar.a(b2);
                }
                throw th;
            }
        }
        return (a) invokeLL.objValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            o oVar = this.m;
            try {
                synchronized (this.f35237e) {
                    long o = o();
                    if (o > 0) {
                        this.r += o;
                        oVar.c(o);
                    }
                    this.q = -1L;
                }
            } catch (Throwable unused) {
            }
        }
    }

    public void d(Future future) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, future) == null) {
            this.s = future;
        }
    }

    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            c.p.a.e.b.c.a.i("SegmentReader", "reconnect: threadIndex = " + this.x);
            synchronized (this) {
                this.v = z;
                this.u = true;
                this.y = true;
            }
            y();
            Thread thread = this.w;
            if (thread != null) {
                try {
                    String str = "reconnect: t.interrupt threadIndex = " + this.x;
                    thread.interrupt();
                } catch (Throwable unused) {
                }
            }
        }
    }

    public boolean f(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048583, this, j2)) == null) {
            long j3 = this.p;
            if (j2 > 0 || j3 <= 0) {
                if (j2 <= j3 || j3 <= 0) {
                    this.o = j2;
                    this.y = true;
                    return true;
                }
                return false;
            }
            return false;
        }
        return invokeJ.booleanValue;
    }

    public final boolean g(BaseException baseException) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, baseException)) == null) {
            if (c.p.a.e.b.l.f.s0(baseException)) {
                String str = this.m.f35245a;
                if (TextUtils.isEmpty(str) || !str.startsWith("https") || !this.f35239g.isNeedHttpsToHttpRetry() || this.E) {
                    return false;
                }
                this.E = true;
                A();
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final boolean h(i iVar) throws BaseException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, iVar)) == null) {
            z();
            try {
                try {
                    m(iVar);
                    s(iVar);
                    x();
                    return true;
                } catch (com.ss.android.socialbase.downloader.f.j e2) {
                    this.F = e2;
                    throw e2;
                }
            }
        }
        return invokeL.booleanValue;
    }

    public final boolean i(i iVar, BaseException baseException) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, iVar, baseException)) == null) {
            c.p.a.e.b.c.a.k("SegmentReader", "handleDownloadFailed:  e = " + baseException + ", curRetryCount = " + this.B + ", retryCount = " + this.A);
            this.F = baseException;
            this.m.e();
            this.f35237e.a(this, this.m, iVar, baseException, this.B, this.A);
            int i2 = this.B;
            if (i2 < this.A) {
                this.B = i2 + 1;
                return true;
            } else if (g(baseException)) {
                return true;
            } else {
                this.f35237e.g(this, this.m, iVar, baseException);
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public boolean j(o oVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, oVar)) == null) {
            int i2 = this.D;
            if (i2 >= 30) {
                return false;
            }
            this.D = i2 + 1;
            o oVar2 = this.m;
            if (oVar2 != null) {
                oVar2.f(this);
            }
            oVar.d(this);
            this.m = oVar;
            A();
            return true;
        }
        return invokeL.booleanValue;
    }

    public long k() {
        InterceptResult invokeV;
        long o;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            synchronized (this.f35237e) {
                o = this.r + o();
            }
            return o;
        }
        return invokeV.longValue;
    }

    public void l(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048589, this, j2) == null) {
            long j3 = this.q;
            c.p.a.e.b.l.e eVar = this.H;
            if (j3 < 0 || eVar == null) {
                return;
            }
            String str = "markProgress: curSegmentReadOffset = " + j3 + ", threadIndex = " + this.x;
            eVar.c(j3, j2);
        }
    }

    public final void m(i iVar) throws BaseException, com.ss.android.socialbase.downloader.exception.i {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, iVar) == null) {
            p(iVar);
            this.f35237e.b(this, iVar, this.m, this.f35242j);
            this.m.g();
        }
    }

    public void n(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.G = z;
        }
    }

    public long o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            synchronized (this.f35237e) {
                long j2 = this.q;
                long j3 = this.n;
                if (j3 < 0 || j2 <= j3) {
                    return 0L;
                }
                return j2 - j3;
            }
        }
        return invokeV.longValue;
    }

    public final void p(i iVar) throws BaseException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, iVar) == null) {
            try {
                try {
                    long currentTimeMillis = System.currentTimeMillis();
                    this.J = 0L;
                    this.I = currentTimeMillis;
                    this.n = iVar.l();
                    this.p = iVar.m();
                    if (this.p > 0 && this.n > this.p) {
                        throw new com.ss.android.socialbase.downloader.f.j(6, "createConn, " + iVar);
                    }
                    this.H = new c.p.a.e.b.l.e();
                    List<com.ss.android.socialbase.downloader.model.c> s = c.p.a.e.b.l.f.s(this.f35239g.getExtraHeaders(), this.f35239g.geteTag(), this.n, this.p);
                    s.add(new com.ss.android.socialbase.downloader.model.c("Segment-Index", String.valueOf(iVar.n())));
                    s.add(new com.ss.android.socialbase.downloader.model.c("Thread-Index", String.valueOf(this.x)));
                    c.p.a.e.b.l.f.C(s, this.f35239g);
                    c.p.a.e.b.l.f.d0(s, this.f35239g);
                    String str = this.m.f35245a;
                    if (this.E && !TextUtils.isEmpty(str) && str.startsWith("https")) {
                        str = str.replaceFirst("https", "http");
                    }
                    String str2 = this.m.f35246b;
                    c.p.a.e.b.c.a.i("SegmentReader", "createConnectionBegin: url = " + str + ", ip = " + str2 + ", segment = " + iVar + ", threadIndex = " + this.x);
                    this.M = str;
                    this.N = str2;
                    c.p.a.e.b.o.k A = c.p.a.e.b.g.e.A(this.f35239g.isNeedDefaultHttpServiceBackUp(), this.f35239g.getMaxBytes(), str, str2, s, 0, currentTimeMillis - this.C > 3000 && this.f35240h.m("monitor_download_connect") > 0, this.f35239g);
                    if (A != null) {
                        this.f35241i = A;
                        this.f35242j = new c.p.a.e.b.n.b(str, A);
                        if (!this.t) {
                            if (A instanceof c.p.a.e.b.o.c) {
                                this.O = ((c.p.a.e.b.o.c) A).e();
                            }
                            String str3 = "createConnectionSuccess: url = " + str + ", ip = " + str2 + ", hostRealIp = " + this.O + ", threadIndex = " + this.x;
                            return;
                        }
                        throw new p("createConn");
                    }
                    throw new BaseException(1022, new IOException("download can't continue, chunk connection is null"));
                } finally {
                    this.J = System.currentTimeMillis();
                }
            } catch (BaseException e2) {
                throw e2;
            } catch (Throwable th) {
                c.p.a.e.b.l.f.B(th, "createConn");
                throw null;
            }
        }
    }

    public void q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
        }
    }

    public long r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.q : invokeV.longValue;
    }

    /* JADX DEBUG: Null dom frontier in handler: all -> 0x0101 */
    @Override // java.lang.Runnable
    public void run() {
        i c2;
        f fVar;
        f fVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            Process.setThreadPriority(10);
            try {
                this.w = Thread.currentThread();
                this.f35237e.i(this);
                this.m.d(this);
                while (true) {
                    c2 = this.f35237e.c(this, this.m);
                    if (c2 == null) {
                        c.p.a.e.b.c.a.i("SegmentReader", "no more segment, thread_index = " + this.x);
                        break;
                    }
                    this.l = c2;
                    try {
                        try {
                        } catch (com.ss.android.socialbase.downloader.f.j e2) {
                            c.p.a.e.b.c.a.k("SegmentReader", "run: SegmentApplyException, e = " + e2);
                            if (this.z >= 50) {
                                c.p.a.e.b.c.a.k("SegmentReader", "segment apply failed " + this.z + "times, thread_index = " + this.x);
                                this.l = null;
                                fVar = this.f35237e;
                                break;
                            }
                            this.z++;
                            this.l = null;
                            fVar2 = this.f35237e;
                        }
                        if (h(c2)) {
                            this.k.add(c2);
                            this.l = null;
                            fVar2 = this.f35237e;
                            fVar2.e(this, c2);
                        } else if (!this.t) {
                            c.p.a.e.b.c.a.k("SegmentReader", "download segment failed, segment = " + c2 + ", thread_index = " + this.x + ", failedException = " + this.F);
                            break;
                        } else {
                            break;
                        }
                    } catch (Throwable th) {
                        this.l = null;
                        this.f35237e.e(this, c2);
                        throw th;
                    }
                }
                this.l = null;
                fVar = this.f35237e;
                fVar.e(this, c2);
                this.m.f(this);
                this.f35237e.j(this);
            } catch (Throwable unused) {
            }
            this.w = null;
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:192:0x032a */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:223:0x0017 */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x01c6, code lost:
        r6 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0130, code lost:
        r7 = r11 + 1;
        r11 = r13 - r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x013a, code lost:
        if (r11 <= 0) goto L184;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x013c, code lost:
        c.p.a.e.b.c.a.k("SegmentReader", "loopAndRead: redundant = " + r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0152, code lost:
        r31.q = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0155, code lost:
        r13 = r7;
        r11 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0159, code lost:
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0162, code lost:
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x016a, code lost:
        throw new com.ss.android.socialbase.downloader.f.p("loopAndRead");
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:201:0x0347  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x0354  */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v8, types: [java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void s(i iVar) throws BaseException {
        a aVar;
        long j2;
        e eVar;
        InputStream inputStream;
        long j3;
        a aVar2;
        int i2;
        a aVar3;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(1048597, this, iVar) != null) {
            return;
        }
        i iVar2 = iVar;
        c cVar = this.f35238f;
        this.K = System.currentTimeMillis();
        long l = iVar.l();
        ?? r6 = -1;
        boolean z = false;
        try {
            try {
                try {
                    try {
                        inputStream = this.f35241i.a();
                        try {
                            if (inputStream != null) {
                                long h2 = this.f35242j.h();
                                int i4 = (h2 > 0L ? 1 : (h2 == 0L ? 0 : -1));
                                if (i4 != 0) {
                                    a aVar4 = b(cVar, inputStream);
                                    try {
                                        if (!this.u && !this.t) {
                                            this.f35237e.d(this, iVar2);
                                            eVar = this.f35237e.h(this, iVar2);
                                            try {
                                                long m = iVar.m();
                                                if (m <= 0) {
                                                    m = i4 > 0 ? (h2 + l) - 1 : Long.MAX_VALUE;
                                                }
                                                int i5 = aVar4.f35189c;
                                                long j4 = i5;
                                                j2 = l + j4;
                                                try {
                                                    if (j2 > m) {
                                                        long j5 = m + 1;
                                                        if (j2 > j5 && (i3 = (int) (j4 - (j2 - j5))) > 0 && i3 < i5) {
                                                            aVar4.f35189c = i3;
                                                            j2 = j5;
                                                        }
                                                        this.q = j2;
                                                        eVar.b(aVar4);
                                                        c.p.a.e.b.l.f.E(inputStream);
                                                        if (eVar != null) {
                                                            try {
                                                                a b2 = cVar.b();
                                                                try {
                                                                    b2.f35189c = -1;
                                                                    eVar.b(b2);
                                                                } catch (Throwable unused) {
                                                                    aVar3 = b2;
                                                                }
                                                            } catch (Throwable unused2) {
                                                            }
                                                        }
                                                        aVar3 = null;
                                                        if (aVar3 != null) {
                                                            cVar.a(aVar3);
                                                        }
                                                        this.L = System.currentTimeMillis();
                                                        if (j2 > l) {
                                                            c.p.a.e.b.e.a.g(this.f35240h, this.f35239g, this.M, this.N, this.O, this.t || this.u, this.f35241i, this.F, j2 - l, TimeUnit.MILLISECONDS.toNanos(this.L - this.K));
                                                        }
                                                        this.f35237e.f(this, iVar2);
                                                        return;
                                                    }
                                                    this.q = j2;
                                                    eVar.b(aVar4);
                                                    long j6 = m;
                                                    while (true) {
                                                        try {
                                                            if (this.y) {
                                                                try {
                                                                    synchronized (this) {
                                                                        this.y = z;
                                                                        if (this.u || this.t) {
                                                                            break;
                                                                        }
                                                                    }
                                                                    synchronized (this.f35237e) {
                                                                        try {
                                                                            if (this.o != 0) {
                                                                                c.p.a.e.b.c.a.i("SegmentReader", "loopAndRead:  change readEnd = " + j6 + ", segmentNewEndOffset = " + this.o + ", segment = " + iVar2);
                                                                                j6 = B();
                                                                                if (j2 > j6) {
                                                                                    break;
                                                                                }
                                                                            }
                                                                        } catch (Throwable th) {
                                                                            th = th;
                                                                        }
                                                                    }
                                                                } catch (BaseException e2) {
                                                                    e = e2;
                                                                    this.F = e;
                                                                    throw e;
                                                                } catch (Throwable th2) {
                                                                    th = th2;
                                                                    iVar2 = iVar;
                                                                    aVar4 = null;
                                                                    try {
                                                                        r6 = "SegmentReader";
                                                                        c.p.a.e.b.c.a.k("SegmentReader", "loopAndRead: " + th + ",stack = " + Log.getStackTraceString(th));
                                                                        th.printStackTrace();
                                                                        try {
                                                                            r6 = "loopAndRead";
                                                                            c.p.a.e.b.l.f.B(th, "loopAndRead");
                                                                            throw null;
                                                                        } catch (BaseException e3) {
                                                                            this.F = e3;
                                                                            throw e3;
                                                                        }
                                                                    } catch (Throwable th3) {
                                                                        th = th3;
                                                                        r6 = 0;
                                                                        c.p.a.e.b.l.f.E(inputStream);
                                                                        if (eVar != null) {
                                                                            if (aVar4 == null) {
                                                                                try {
                                                                                    aVar4 = cVar.b();
                                                                                } catch (Throwable unused3) {
                                                                                    aVar = aVar4;
                                                                                    if (aVar != null) {
                                                                                        cVar.a(aVar);
                                                                                    }
                                                                                    this.L = System.currentTimeMillis();
                                                                                    if (j2 > l) {
                                                                                        c.p.a.e.b.e.a.g(this.f35240h, this.f35239g, this.M, this.N, this.O, this.t || this.u, this.f35241i, this.F, j2 - l, TimeUnit.MILLISECONDS.toNanos(this.L - this.K));
                                                                                    }
                                                                                    this.f35237e.f(this, iVar2);
                                                                                    throw th;
                                                                                }
                                                                            }
                                                                            aVar4.f35189c = -1;
                                                                            eVar.b(aVar4);
                                                                            aVar = r6;
                                                                            if (aVar != null) {
                                                                            }
                                                                            this.L = System.currentTimeMillis();
                                                                            if (j2 > l) {
                                                                            }
                                                                            this.f35237e.f(this, iVar2);
                                                                            throw th;
                                                                        }
                                                                        aVar = aVar4;
                                                                        if (aVar != null) {
                                                                        }
                                                                        this.L = System.currentTimeMillis();
                                                                        if (j2 > l) {
                                                                        }
                                                                        this.f35237e.f(this, iVar2);
                                                                        throw th;
                                                                    }
                                                                }
                                                            }
                                                            aVar4 = cVar.b();
                                                        } catch (BaseException e4) {
                                                            e = e4;
                                                        } catch (Throwable th4) {
                                                            th = th4;
                                                        }
                                                        try {
                                                            int read = inputStream.read(aVar4.f35187a);
                                                            aVar4.f35189c = read;
                                                            if (read == -1) {
                                                                eVar.b(aVar4);
                                                                j3 = 0;
                                                                eVar = null;
                                                                break;
                                                            }
                                                            long j7 = read;
                                                            j2 += j7;
                                                            if (j2 > j6) {
                                                                long j8 = j6 + 1;
                                                                if (j2 > j8 && (i2 = (int) (j7 - (j2 - j8))) > 0 && i2 < read) {
                                                                    aVar4.f35189c = i2;
                                                                    j2 = j8;
                                                                }
                                                                this.q = j2;
                                                                eVar.b(aVar4);
                                                                c.p.a.e.b.c.a.i("SegmentReader", "loopAndRead: bytesRead = " + (j2 - l) + ", url = " + this.m.f35245a);
                                                            } else {
                                                                iVar2 = iVar;
                                                                this.q = j2;
                                                                eVar.b(aVar4);
                                                                z = false;
                                                            }
                                                        } catch (BaseException e5) {
                                                            e = e5;
                                                            this.F = e;
                                                            throw e;
                                                        } catch (Throwable th5) {
                                                            th = th5;
                                                            iVar2 = iVar;
                                                            r6 = "SegmentReader";
                                                            c.p.a.e.b.c.a.k("SegmentReader", "loopAndRead: " + th + ",stack = " + Log.getStackTraceString(th));
                                                            th.printStackTrace();
                                                            r6 = "loopAndRead";
                                                            c.p.a.e.b.l.f.B(th, "loopAndRead");
                                                            throw null;
                                                        }
                                                    }
                                                    if (j6 > j3 && j6 != Long.MAX_VALUE && j2 <= j6) {
                                                        throw new BaseException(1051, String.format("range[%d, %d] , but readCurrent[%d] , readStart[%d]", Long.valueOf(l), Long.valueOf(j6), Long.valueOf(j2), Long.valueOf(l)));
                                                    }
                                                    c.p.a.e.b.l.f.E(inputStream);
                                                    if (eVar != null) {
                                                        try {
                                                            a b3 = cVar.b();
                                                            try {
                                                                b3.f35189c = -1;
                                                                eVar.b(b3);
                                                            } catch (Throwable unused4) {
                                                                aVar2 = b3;
                                                            }
                                                        } catch (Throwable unused5) {
                                                        }
                                                    }
                                                    aVar2 = null;
                                                    if (aVar2 != null) {
                                                        cVar.a(aVar2);
                                                    }
                                                    this.L = System.currentTimeMillis();
                                                    if (j2 > l) {
                                                        c.p.a.e.b.e.a.g(this.f35240h, this.f35239g, this.M, this.N, this.O, this.t || this.u, this.f35241i, this.F, j2 - l, TimeUnit.MILLISECONDS.toNanos(this.L - this.K));
                                                    }
                                                    this.f35237e.f(this, iVar);
                                                } catch (BaseException e6) {
                                                    e = e6;
                                                } catch (Throwable th6) {
                                                    th = th6;
                                                }
                                            } catch (BaseException e7) {
                                                e = e7;
                                            } catch (Throwable th7) {
                                                th = th7;
                                                j2 = l;
                                            }
                                        } else {
                                            throw new p("probe");
                                        }
                                    } catch (BaseException e8) {
                                        e = e8;
                                    } catch (Throwable th8) {
                                        th = th8;
                                        j2 = l;
                                        eVar = null;
                                    }
                                } else {
                                    throw new com.ss.android.socialbase.downloader.exception.f(1004, "the content-length is 0, contentLength = " + h2);
                                }
                            } else {
                                throw new BaseException(1042, new IOException("inputStream is null"));
                            }
                        } catch (BaseException e9) {
                            e = e9;
                        } catch (Throwable th9) {
                            th = th9;
                            j2 = l;
                            eVar = null;
                        }
                    } catch (BaseException e10) {
                        e = e10;
                    }
                } catch (Throwable th10) {
                    th = th10;
                    j2 = l;
                    eVar = null;
                    inputStream = null;
                }
            } catch (BaseException e11) {
                e = e11;
            }
        } catch (Throwable th11) {
            th = th11;
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            c.p.a.e.b.c.a.i("SegmentReader", "close: threadIndex = " + this.x);
            synchronized (this) {
                this.t = true;
                this.y = true;
            }
            y();
            Future future = this.s;
            if (future != null) {
                this.s = null;
                try {
                    future.cancel(true);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            e(false);
        }
    }

    public boolean v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.G : invokeV.booleanValue;
    }

    public long w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.n : invokeV.longValue;
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            this.C = this.I;
            this.I = -1L;
            this.J = -1L;
            this.K = -1L;
            this.L = -1L;
            y();
        }
    }

    public final void y() {
        c.p.a.e.b.o.k kVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048603, this) == null) || (kVar = this.f35241i) == null) {
            return;
        }
        try {
            c.p.a.e.b.c.a.i("SegmentReader", "closeConnection: thread = " + this.x);
            kVar.d();
            kVar.c();
        } catch (Throwable unused) {
        }
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            this.E = false;
            A();
        }
    }
}
