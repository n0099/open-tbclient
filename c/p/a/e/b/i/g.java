package c.p.a.e.b.i;

import android.os.SystemClock;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final List<k> f35197a;

    /* renamed from: b  reason: collision with root package name */
    public final List<k> f35198b;

    /* renamed from: c  reason: collision with root package name */
    public final DownloadInfo f35199c;

    /* renamed from: d  reason: collision with root package name */
    public final c.p.a.e.b.g.k f35200d;

    /* renamed from: e  reason: collision with root package name */
    public final c.p.a.e.b.j.a f35201e;

    /* renamed from: f  reason: collision with root package name */
    public final c.p.a.e.b.k.f f35202f;

    /* renamed from: g  reason: collision with root package name */
    public final c f35203g;

    /* renamed from: h  reason: collision with root package name */
    public BaseException f35204h;

    /* renamed from: i  reason: collision with root package name */
    public volatile boolean f35205i;

    /* renamed from: j  reason: collision with root package name */
    public volatile boolean f35206j;
    public volatile boolean k;
    public final c.p.a.e.b.a.a l;
    public final boolean m;
    public final long n;
    public final long o;
    public final boolean p;
    public long q;
    public volatile long r;
    public volatile long s;

    public g(DownloadInfo downloadInfo, c.p.a.e.b.k.f fVar, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {downloadInfo, fVar, cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f35197a = new LinkedList();
        this.f35198b = new ArrayList();
        this.f35205i = false;
        this.f35206j = false;
        this.k = false;
        this.r = 0L;
        this.s = 0L;
        this.f35199c = downloadInfo;
        this.f35200d = c.p.a.e.b.g.e.M0();
        this.f35202f = fVar;
        this.f35203g = cVar;
        this.l = c.p.a.e.b.a.a.c();
        c.p.a.e.b.j.a d2 = c.p.a.e.b.j.a.d(downloadInfo.getId());
        this.f35201e = d2;
        boolean z = d2.b("sync_strategy", 0) == 1;
        this.m = z;
        if (z) {
            this.n = Math.max(this.f35201e.b("sync_interval_ms_fg", 5000), 500L);
            this.o = Math.max(this.f35201e.b("sync_interval_ms_bg", 1000), 500L);
        } else {
            this.n = 0L;
            this.o = 0L;
        }
        this.p = this.f35201e.m("monitor_rw") == 1;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.k = true;
            this.f35205i = true;
        }
    }

    public final void b(long j2, boolean z) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j2), Boolean.valueOf(z)}) == null) {
            long j3 = j2 - this.s;
            if (this.m) {
                if (j3 > (this.l.k() ? this.n : this.o)) {
                    k();
                    this.s = j2;
                    return;
                }
                return;
            }
            long curBytes = this.f35199c.getCurBytes() - this.r;
            if (z || h(curBytes, j3)) {
                k();
                this.s = j2;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:179:0x022b, code lost:
        r3.b(r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00bc, code lost:
        if (r13 <= 0) goto L234;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00bf, code lost:
        r3.b(r13);
     */
    /* JADX WARN: Removed duplicated region for block: B:164:0x01f9 A[Catch: all -> 0x0364, TryCatch #3 {all -> 0x0364, blocks: (B:162:0x01f5, B:164:0x01f9, B:167:0x01fe, B:169:0x0204, B:170:0x0207, B:171:0x021d, B:175:0x0225, B:176:0x0227, B:217:0x02b0, B:219:0x02ba, B:221:0x02be, B:260:0x0342, B:262:0x0348, B:263:0x034b, B:264:0x0363), top: B:314:0x002b, inners: #36 }] */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0204 A[Catch: all -> 0x0364, TryCatch #3 {all -> 0x0364, blocks: (B:162:0x01f5, B:164:0x01f9, B:167:0x01fe, B:169:0x0204, B:170:0x0207, B:171:0x021d, B:175:0x0225, B:176:0x0227, B:217:0x02b0, B:219:0x02ba, B:221:0x02be, B:260:0x0342, B:262:0x0348, B:263:0x034b, B:264:0x0363), top: B:314:0x002b, inners: #36 }] */
    /* JADX WARN: Removed duplicated region for block: B:219:0x02ba A[Catch: all -> 0x0364, TryCatch #3 {all -> 0x0364, blocks: (B:162:0x01f5, B:164:0x01f9, B:167:0x01fe, B:169:0x0204, B:170:0x0207, B:171:0x021d, B:175:0x0225, B:176:0x0227, B:217:0x02b0, B:219:0x02ba, B:221:0x02be, B:260:0x0342, B:262:0x0348, B:263:0x034b, B:264:0x0363), top: B:314:0x002b, inners: #36 }] */
    /* JADX WARN: Removed duplicated region for block: B:262:0x0348 A[Catch: all -> 0x0364, TryCatch #3 {all -> 0x0364, blocks: (B:162:0x01f5, B:164:0x01f9, B:167:0x01fe, B:169:0x0204, B:170:0x0207, B:171:0x021d, B:175:0x0225, B:176:0x0227, B:217:0x02b0, B:219:0x02ba, B:221:0x02be, B:260:0x0342, B:262:0x0348, B:263:0x034b, B:264:0x0363), top: B:314:0x002b, inners: #36 }] */
    /* JADX WARN: Removed duplicated region for block: B:275:0x0378  */
    /* JADX WARN: Removed duplicated region for block: B:315:0x0253 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:321:0x03a2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:323:0x0234 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:331:0x00e7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:333:0x02ed A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:339:0x0382 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void c(d dVar) throws BaseException {
        DownloadInfo downloadInfo;
        long curBytes;
        long nanoTime;
        boolean z;
        boolean z2;
        long j2;
        long j3;
        long j4;
        long j5;
        Throwable th;
        int i2;
        Throwable th2;
        Throwable th3;
        Throwable th4;
        Throwable th5;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dVar) == null) || this.f35206j || this.k) {
            return;
        }
        c.p.a.e.b.o.d.e();
        this.f35204h = null;
        downloadInfo = this.f35199c;
        c.p.a.e.b.k.f fVar = this.f35202f;
        c cVar = this.f35203g;
        curBytes = downloadInfo.getCurBytes();
        nanoTime = System.nanoTime();
        z = this.p;
        z2 = true;
        long j6 = 0;
        int i3 = 0;
        boolean z3 = false;
        try {
            try {
                downloadInfo.updateRealStartDownloadTime();
                long j7 = 0;
                long j8 = 0;
                long j9 = 0;
                int i4 = 0;
                while (true) {
                    if (z) {
                        try {
                            j7 = System.nanoTime();
                        } catch (p e2) {
                            e = e2;
                            i3 = i4;
                            j5 = j8;
                            try {
                                this.f35204h = e;
                                throw e;
                            } catch (Throwable th6) {
                                th = th6;
                                j3 = j6;
                                j2 = j5;
                                if (i3 > 0) {
                                }
                                if (!this.k) {
                                }
                                th4 = null;
                                synchronized (this) {
                                }
                            }
                        } catch (BaseException e3) {
                            e = e3;
                            j3 = j6;
                            i2 = i4;
                            j4 = j8;
                            if (!this.f35201e.l("ignore_base_ex_on_stop_status")) {
                            }
                            if (c.p.a.e.b.c.a.e()) {
                            }
                            c.p.a.e.b.c.a.j("MultiSegmentWriter", "loopAndWrite:  BaseException e = " + e);
                            this.f35204h = e;
                            throw e;
                        } catch (Throwable th7) {
                            th = th7;
                            j3 = j6;
                            i3 = i4;
                            j2 = j8;
                            if (!this.f35206j) {
                            }
                            if (!this.k) {
                            }
                            th2 = null;
                            synchronized (this) {
                            }
                        }
                    }
                    try {
                        a a2 = dVar.a();
                        if (z) {
                            j6 += System.nanoTime() - j7;
                        }
                        j3 = j6;
                        try {
                            int i5 = a2.f35185c;
                            if (i5 == -1) {
                                try {
                                    d(a2.f35184b);
                                    cVar.a(a2);
                                    j6 = j3;
                                } catch (p e4) {
                                    e = e4;
                                    i3 = i4;
                                    j5 = j8;
                                    j6 = j3;
                                    this.f35204h = e;
                                    throw e;
                                } catch (BaseException e5) {
                                    e = e5;
                                    i2 = i4;
                                    j4 = j8;
                                    if (!this.f35201e.l("ignore_base_ex_on_stop_status") && (this.f35206j || this.k)) {
                                        if (i2 > 0) {
                                            try {
                                                fVar.b(i2);
                                            } catch (Throwable unused) {
                                            }
                                        }
                                        if (!this.k) {
                                            try {
                                                k();
                                            } catch (Throwable th8) {
                                                th3 = th8;
                                                c.p.a.e.b.c.a.j("MultiSegmentWriter", "loopAndWrite: finally sync, e = " + th3);
                                                synchronized (this) {
                                                    l(this.f35197a);
                                                    this.f35197a.clear();
                                                }
                                                c.p.a.e.b.e.a.f(this.f35201e, downloadInfo, downloadInfo.getUrl(), null, this.f35206j, this.k, this.f35204h, downloadInfo.getCurBytes() - curBytes, System.nanoTime() - nanoTime, z, j3, j4, this.q, null);
                                                if (th3 != null) {
                                                    if (!this.f35206j && !this.k && this.f35204h == null) {
                                                        z2 = false;
                                                    }
                                                    if (z2) {
                                                        return;
                                                    }
                                                    try {
                                                        c.p.a.e.b.l.f.B(th3, "loopAndWrite_finally");
                                                        throw null;
                                                    } catch (BaseException e6) {
                                                        this.f35204h = e6;
                                                        throw e6;
                                                    }
                                                }
                                                return;
                                            }
                                        }
                                        th3 = null;
                                        synchronized (this) {
                                        }
                                    } else {
                                        if (c.p.a.e.b.c.a.e()) {
                                            e.printStackTrace();
                                        }
                                        c.p.a.e.b.c.a.j("MultiSegmentWriter", "loopAndWrite:  BaseException e = " + e);
                                        this.f35204h = e;
                                        throw e;
                                    }
                                } catch (Throwable th9) {
                                    th = th9;
                                    i3 = i4;
                                    j2 = j8;
                                    if (!this.f35206j && !this.k) {
                                        if (c.p.a.e.b.c.a.e()) {
                                            th.printStackTrace();
                                        }
                                        c.p.a.e.b.c.a.j("MultiSegmentWriter", "loopAndWrite:  e = " + th);
                                        try {
                                            c.p.a.e.b.l.f.B(th, "loopAndWrite");
                                            throw null;
                                        } catch (BaseException e7) {
                                            this.f35204h = e7;
                                            throw e7;
                                        }
                                    }
                                    if (!this.k) {
                                        try {
                                            k();
                                        } catch (Throwable th10) {
                                            th2 = th10;
                                            c.p.a.e.b.c.a.j("MultiSegmentWriter", "loopAndWrite: finally sync, e = " + th2);
                                            synchronized (this) {
                                                l(this.f35197a);
                                                this.f35197a.clear();
                                            }
                                            c.p.a.e.b.e.a.f(this.f35201e, downloadInfo, downloadInfo.getUrl(), null, this.f35206j, this.k, this.f35204h, downloadInfo.getCurBytes() - curBytes, System.nanoTime() - nanoTime, z, j3, j2, this.q, null);
                                            if (th2 != null) {
                                                if (!this.f35206j && !this.k && this.f35204h == null) {
                                                    z2 = false;
                                                }
                                                if (z2) {
                                                    return;
                                                }
                                                try {
                                                    c.p.a.e.b.l.f.B(th2, "loopAndWrite_finally");
                                                    throw null;
                                                } catch (BaseException e8) {
                                                    this.f35204h = e8;
                                                    throw e8;
                                                }
                                            }
                                            return;
                                        }
                                    }
                                    th2 = null;
                                    synchronized (this) {
                                    }
                                }
                            } else {
                                if (z) {
                                    j7 = System.nanoTime();
                                }
                                a2.f35184b.b(a2);
                                if (z) {
                                    j8 += System.nanoTime() - j7;
                                }
                                j5 = j8;
                                try {
                                    cVar.a(a2);
                                    if (this.f35205i) {
                                        if (this.f35206j) {
                                            break;
                                        }
                                        try {
                                            if (this.k) {
                                                break;
                                            }
                                            this.f35205i = z3;
                                        } catch (p e9) {
                                            e = e9;
                                            i3 = i4;
                                            j6 = j3;
                                            this.f35204h = e;
                                            throw e;
                                        } catch (BaseException e10) {
                                            e = e10;
                                            i2 = i4;
                                            j4 = j5;
                                            if (!this.f35201e.l("ignore_base_ex_on_stop_status")) {
                                            }
                                            if (c.p.a.e.b.c.a.e()) {
                                            }
                                            c.p.a.e.b.c.a.j("MultiSegmentWriter", "loopAndWrite:  BaseException e = " + e);
                                            this.f35204h = e;
                                            throw e;
                                        } catch (Throwable th11) {
                                            th = th11;
                                            i3 = i4;
                                            j2 = j5;
                                            if (!this.f35206j) {
                                                if (c.p.a.e.b.c.a.e()) {
                                                }
                                                c.p.a.e.b.c.a.j("MultiSegmentWriter", "loopAndWrite:  e = " + th);
                                                c.p.a.e.b.l.f.B(th, "loopAndWrite");
                                                throw null;
                                            }
                                            if (!this.k) {
                                            }
                                            th2 = null;
                                            synchronized (this) {
                                            }
                                        }
                                    }
                                    i4 += i5;
                                    if (i4 >= 65536) {
                                        try {
                                            long uptimeMillis = SystemClock.uptimeMillis();
                                            if (uptimeMillis - j9 > 100) {
                                                long j10 = j7;
                                                try {
                                                    b(uptimeMillis, fVar.b(i4));
                                                    if (!c.p.a.e.b.o.d.f35432f) {
                                                        if (!downloadInfo.isOnlyWifi()) {
                                                            if (downloadInfo.isDownloadFromReserveWifi() && downloadInfo.isPauseReserveOnWifi()) {
                                                                throw new com.ss.android.socialbase.downloader.exception.e();
                                                            }
                                                        } else {
                                                            throw new com.ss.android.socialbase.downloader.exception.c();
                                                        }
                                                    }
                                                    j9 = uptimeMillis;
                                                    j7 = j10;
                                                    j6 = j3;
                                                    j8 = j5;
                                                    i4 = 0;
                                                    z3 = false;
                                                } catch (p e11) {
                                                    e = e11;
                                                    j6 = j3;
                                                    i3 = 0;
                                                    this.f35204h = e;
                                                    throw e;
                                                } catch (BaseException e12) {
                                                    e = e12;
                                                    j4 = j5;
                                                    i2 = 0;
                                                    if (!this.f35201e.l("ignore_base_ex_on_stop_status")) {
                                                    }
                                                    if (c.p.a.e.b.c.a.e()) {
                                                    }
                                                    c.p.a.e.b.c.a.j("MultiSegmentWriter", "loopAndWrite:  BaseException e = " + e);
                                                    this.f35204h = e;
                                                    throw e;
                                                } catch (Throwable th12) {
                                                    th = th12;
                                                    j2 = j5;
                                                    i3 = 0;
                                                    if (!this.f35206j) {
                                                    }
                                                    if (!this.k) {
                                                    }
                                                    th2 = null;
                                                    synchronized (this) {
                                                    }
                                                }
                                            }
                                        } catch (p e13) {
                                            e = e13;
                                            i3 = i4;
                                            j6 = j3;
                                            this.f35204h = e;
                                            throw e;
                                        } catch (BaseException e14) {
                                            e = e14;
                                            i2 = i4;
                                            j4 = j5;
                                            if (!this.f35201e.l("ignore_base_ex_on_stop_status")) {
                                            }
                                            if (c.p.a.e.b.c.a.e()) {
                                            }
                                            c.p.a.e.b.c.a.j("MultiSegmentWriter", "loopAndWrite:  BaseException e = " + e);
                                            this.f35204h = e;
                                            throw e;
                                        } catch (Throwable th13) {
                                            th = th13;
                                            i3 = i4;
                                            j2 = j5;
                                            if (!this.f35206j) {
                                            }
                                            if (!this.k) {
                                            }
                                            th2 = null;
                                            synchronized (this) {
                                            }
                                        }
                                    }
                                    j7 = j7;
                                    j6 = j3;
                                    j8 = j5;
                                    z3 = false;
                                } catch (p e15) {
                                    e = e15;
                                } catch (BaseException e16) {
                                    e = e16;
                                } catch (Throwable th14) {
                                    th = th14;
                                }
                            }
                        } catch (p e17) {
                            e = e17;
                            i3 = i4;
                            j5 = j8;
                        } catch (BaseException e18) {
                            e = e18;
                            i2 = i4;
                            j4 = j8;
                            if (!this.f35201e.l("ignore_base_ex_on_stop_status")) {
                            }
                            if (c.p.a.e.b.c.a.e()) {
                            }
                            c.p.a.e.b.c.a.j("MultiSegmentWriter", "loopAndWrite:  BaseException e = " + e);
                            this.f35204h = e;
                            throw e;
                        } catch (Throwable th15) {
                            th = th15;
                            i3 = i4;
                            j2 = j8;
                            if (!this.f35206j) {
                            }
                            if (!this.k) {
                            }
                            th2 = null;
                            synchronized (this) {
                            }
                        }
                    } catch (p e19) {
                        e = e19;
                        i3 = i4;
                        j5 = j8;
                    } catch (BaseException e20) {
                        e = e20;
                        j3 = j6;
                    } catch (Throwable th16) {
                        th = th16;
                        j3 = j6;
                    }
                }
            } catch (Throwable th17) {
                th = th17;
                if (i3 > 0) {
                    try {
                        fVar.b(i3);
                    } catch (Throwable unused2) {
                    }
                }
                if (!this.k) {
                    try {
                        k();
                    } catch (Throwable th18) {
                        c.p.a.e.b.c.a.j("MultiSegmentWriter", "loopAndWrite: finally sync, e = " + th18);
                        th4 = th18;
                        synchronized (this) {
                        }
                    }
                }
                th4 = null;
                synchronized (this) {
                    l(this.f35197a);
                    this.f35197a.clear();
                }
                c.p.a.e.b.e.a.f(this.f35201e, downloadInfo, downloadInfo.getUrl(), null, this.f35206j, this.k, this.f35204h, downloadInfo.getCurBytes() - curBytes, System.nanoTime() - nanoTime, z, j3, j2, this.q, null);
                if (th4 != null) {
                    if (!this.f35206j && !this.k && this.f35204h == null) {
                        z2 = false;
                    }
                    if (!z2) {
                        try {
                            c.p.a.e.b.l.f.B(th4, "loopAndWrite_finally");
                            throw null;
                        } catch (BaseException e21) {
                            this.f35204h = e21;
                            throw e21;
                        }
                    }
                }
                throw th;
            }
        } catch (p e22) {
            e = e22;
            j5 = 0;
        } catch (BaseException e23) {
            e = e23;
            j4 = 0;
            j3 = 0;
        } catch (Throwable th19) {
            th = th19;
            j2 = 0;
            j3 = 0;
        }
        if (!this.k) {
            try {
                k();
            } catch (Throwable th20) {
                th5 = th20;
                c.p.a.e.b.c.a.j("MultiSegmentWriter", "loopAndWrite: finally sync, e = " + th5);
                synchronized (this) {
                    l(this.f35197a);
                    this.f35197a.clear();
                }
                c.p.a.e.b.e.a.f(this.f35201e, downloadInfo, downloadInfo.getUrl(), null, this.f35206j, this.k, this.f35204h, downloadInfo.getCurBytes() - curBytes, System.nanoTime() - nanoTime, z, j3, j5, this.q, null);
                if (th5 != null) {
                    if (!this.f35206j && !this.k && this.f35204h == null) {
                        z2 = false;
                    }
                    if (z2) {
                        return;
                    }
                    try {
                        c.p.a.e.b.l.f.B(th5, "loopAndWrite_finally");
                        throw null;
                    } catch (BaseException e24) {
                        this.f35204h = e24;
                        throw e24;
                    }
                }
                return;
            }
        }
        th5 = null;
        synchronized (this) {
        }
    }

    public final void d(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, eVar) == null) {
            synchronized (this) {
                this.f35198b.add((k) eVar);
            }
        }
    }

    public void e(k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, kVar) == null) {
            synchronized (this) {
                this.f35197a.add(kVar);
            }
        }
    }

    public final void f(List<k> list) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            for (k kVar : list) {
                kVar.d();
            }
        }
    }

    public final void g(List<k> list, Map<Long, i> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, list, map) == null) {
            for (k kVar : list) {
                i g2 = kVar.g();
                i iVar = map.get(Long.valueOf(g2.h()));
                if (iVar == null) {
                    map.put(Long.valueOf(g2.h()), new i(g2));
                } else {
                    iVar.d(g2.j());
                    iVar.i(g2.m());
                }
            }
        }
    }

    public final boolean h(long j2, long j3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)})) == null) ? j2 > 65536 && j3 > 500 : invokeCommon.booleanValue;
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f35206j = true;
            this.f35205i = true;
        }
    }

    public final void j(List<k> list) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, list) == null) {
            for (k kVar : list) {
                kVar.e();
            }
        }
    }

    public final void k() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            boolean z = this.p;
            long nanoTime = z ? System.nanoTime() : 0L;
            DownloadInfo downloadInfo = this.f35199c;
            c.p.a.e.b.g.k kVar = this.f35200d;
            List<k> list = this.f35197a;
            List<k> list2 = this.f35198b;
            Map<Long, i> l = kVar.l(downloadInfo.getId());
            if (l == null) {
                l = new HashMap<>(4);
            }
            synchronized (this) {
                f(list);
                j(list);
                g(list, l);
                if (list2.size() > 0) {
                    l(list2);
                    list.removeAll(list2);
                    list2.clear();
                }
            }
            if (1 != 0) {
                downloadInfo.updateRealDownloadTime(true);
                kVar.a(downloadInfo.getId(), l);
                kVar.a(downloadInfo);
                this.r = downloadInfo.getCurBytes();
            }
            if (z) {
                this.q += System.nanoTime() - nanoTime;
            }
        }
    }

    public final void l(List<k> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, list) == null) {
            for (k kVar : list) {
                kVar.f();
            }
        }
    }
}
