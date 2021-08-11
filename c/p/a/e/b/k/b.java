package c.p.a.e.b.k;

import android.annotation.SuppressLint;
import android.os.Process;
import androidx.core.view.InputDeviceCompat;
import c.p.a.e.b.o.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.IOException;
import java.util.List;
/* loaded from: classes4.dex */
public class b implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public com.ss.android.socialbase.downloader.model.b f35026e;

    /* renamed from: f  reason: collision with root package name */
    public com.ss.android.socialbase.downloader.model.b f35027f;

    /* renamed from: g  reason: collision with root package name */
    public c.p.a.e.b.g.g f35028g;

    /* renamed from: h  reason: collision with root package name */
    public DownloadInfo f35029h;

    /* renamed from: i  reason: collision with root package name */
    public final f f35030i;

    /* renamed from: j  reason: collision with root package name */
    public k f35031j;
    public c.p.a.e.b.g.k k;
    public volatile boolean l;
    public volatile boolean m;
    public boolean n;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1473359591, "Lc/p/a/e/b/k/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1473359591, "Lc/p/a/e/b/k/b;");
            }
        }
    }

    public b(com.ss.android.socialbase.downloader.model.b bVar, c.p.a.e.b.n.a aVar, f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar, aVar, fVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.n = false;
        this.f35027f = bVar;
        if (aVar != null) {
            this.f35029h = aVar.J();
        }
        this.f35030i = fVar;
        this.k = c.p.a.e.b.g.e.M0();
        this.f35027f.a(this);
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.l = true;
            c.p.a.e.b.g.g gVar = this.f35028g;
            if (gVar != null) {
                gVar.h();
            }
        }
    }

    public void b(long j2, long j3) {
        c.p.a.e.b.g.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) || (gVar = this.f35028g) == null) {
            return;
        }
        gVar.d(j2, j3);
    }

    public final void c(com.ss.android.socialbase.downloader.model.b bVar, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_SEND_USER_MSG, this, bVar, j2) == null) {
            com.ss.android.socialbase.downloader.model.b e2 = bVar.d() ? bVar.e() : bVar;
            if (e2 != null) {
                if (e2.h()) {
                    this.k.a(e2.k(), e2.b(), j2);
                }
                e2.b(j2);
                this.k.a(e2.k(), e2.s(), e2.b(), j2);
            } else if (bVar.d()) {
                this.k.a(bVar.k(), bVar.s(), j2);
            }
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:110:0x01a2 */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0110, code lost:
        throw new com.ss.android.socialbase.downloader.exception.BaseException(1002, java.lang.String.format("Http response error , code is : %s ", java.lang.String.valueOf(r0)));
     */
    /* JADX WARN: Removed duplicated region for block: B:131:0x01cf A[Catch: all -> 0x0294, TRY_ENTER, TryCatch #7 {all -> 0x0294, BaseException -> 0x01b6, blocks: (B:127:0x01c5, B:131:0x01cf, B:133:0x01d5, B:136:0x01de, B:138:0x01e6, B:140:0x01ec, B:144:0x01f7, B:146:0x01fb, B:148:0x0203, B:150:0x0214, B:159:0x023c, B:161:0x0242, B:163:0x024f, B:167:0x0257, B:162:0x0249, B:153:0x0221, B:154:0x022f, B:169:0x0262, B:171:0x026a, B:173:0x0272, B:175:0x027a, B:177:0x0282, B:180:0x028b, B:114:0x01a6, B:118:0x01b0, B:121:0x01b7), top: B:196:0x01c5 }] */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0242 A[Catch: all -> 0x0294, TryCatch #7 {all -> 0x0294, BaseException -> 0x01b6, blocks: (B:127:0x01c5, B:131:0x01cf, B:133:0x01d5, B:136:0x01de, B:138:0x01e6, B:140:0x01ec, B:144:0x01f7, B:146:0x01fb, B:148:0x0203, B:150:0x0214, B:159:0x023c, B:161:0x0242, B:163:0x024f, B:167:0x0257, B:162:0x0249, B:153:0x0221, B:154:0x022f, B:169:0x0262, B:171:0x026a, B:173:0x0272, B:175:0x027a, B:177:0x0282, B:180:0x028b, B:114:0x01a6, B:118:0x01b0, B:121:0x01b7), top: B:196:0x01c5 }] */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0249 A[Catch: all -> 0x0294, TryCatch #7 {all -> 0x0294, BaseException -> 0x01b6, blocks: (B:127:0x01c5, B:131:0x01cf, B:133:0x01d5, B:136:0x01de, B:138:0x01e6, B:140:0x01ec, B:144:0x01f7, B:146:0x01fb, B:148:0x0203, B:150:0x0214, B:159:0x023c, B:161:0x0242, B:163:0x024f, B:167:0x0257, B:162:0x0249, B:153:0x0221, B:154:0x022f, B:169:0x0262, B:171:0x026a, B:173:0x0272, B:175:0x027a, B:177:0x0282, B:180:0x028b, B:114:0x01a6, B:118:0x01b0, B:121:0x01b7), top: B:196:0x01c5 }] */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0257 A[Catch: all -> 0x0294, TRY_ENTER, TRY_LEAVE, TryCatch #7 {all -> 0x0294, BaseException -> 0x01b6, blocks: (B:127:0x01c5, B:131:0x01cf, B:133:0x01d5, B:136:0x01de, B:138:0x01e6, B:140:0x01ec, B:144:0x01f7, B:146:0x01fb, B:148:0x0203, B:150:0x0214, B:159:0x023c, B:161:0x0242, B:163:0x024f, B:167:0x0257, B:162:0x0249, B:153:0x0221, B:154:0x022f, B:169:0x0262, B:171:0x026a, B:173:0x0272, B:175:0x027a, B:177:0x0282, B:180:0x028b, B:114:0x01a6, B:118:0x01b0, B:121:0x01b7), top: B:196:0x01c5 }] */
    /* JADX WARN: Removed duplicated region for block: B:208:0x0253 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:211:0x01cb A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean d(com.ss.android.socialbase.downloader.model.b bVar) {
        Interceptable interceptable;
        InterceptResult invokeL;
        boolean z;
        long j2;
        long j3;
        com.ss.android.socialbase.downloader.exception.h h2;
        com.ss.android.socialbase.downloader.model.b e2;
        Interceptable interceptable2 = $ic;
        if (interceptable2 != null && (invokeL = (interceptable = interceptable2).invokeL(1048579, this, bVar)) != null) {
            return invokeL.booleanValue;
        }
        long j4 = interceptable;
        while (true) {
            com.ss.android.socialbase.downloader.model.b bVar2 = (bVar.d() && bVar.f() && (e2 = bVar.e()) != null && e2.s() == bVar.s()) ? e2 : null;
            if (bVar2 != null && bVar2.i()) {
                return true;
            }
            long n = bVar.n();
            long p = bVar.p();
            long n2 = bVar.n();
            if (bVar2 != null) {
                n2 = bVar2.n();
                n = bVar2.n();
                p = bVar2.p();
            }
            long j5 = n;
            long j6 = p;
            long j7 = 0;
            boolean z2 = false;
            try {
                try {
                    if (h()) {
                        return false;
                    }
                    String f2 = f();
                    boolean z3 = this.f35031j != null;
                    this.n = z3;
                    bVar.b(z3);
                    try {
                        try {
                            try {
                                try {
                                    if (!this.n) {
                                        List<com.ss.android.socialbase.downloader.model.c> s = c.p.a.e.b.l.f.s(this.f35029h.getExtraHeaders(), this.f35029h.geteTag(), j5, j6);
                                        s.add(new com.ss.android.socialbase.downloader.model.c("Chunk-Index", String.valueOf(bVar.s())));
                                        c.p.a.e.b.l.f.C(s, this.f35029h);
                                        c.p.a.e.b.l.f.d0(s, this.f35029h);
                                        this.f35031j = c.p.a.e.b.g.e.B(this.f35029h.isNeedDefaultHttpServiceBackUp(), this.f35029h.getMaxBytes(), f2, s);
                                    }
                                    if (this.f35031j != null) {
                                        try {
                                            if (this.f35030i != null) {
                                                try {
                                                    int b2 = this.f35031j.b();
                                                    if (b2 < 200 || b2 >= 300) {
                                                        this.f35030i.e(this.f35031j);
                                                    }
                                                } catch (Throwable th) {
                                                    th.printStackTrace();
                                                }
                                            }
                                        } catch (BaseException e3) {
                                            e = e3;
                                            j2 = n2;
                                            z = false;
                                            try {
                                                if (h()) {
                                                }
                                            } catch (BaseException e4) {
                                                this.f35030i.g(e4);
                                                return z;
                                            } finally {
                                                g();
                                            }
                                        }
                                    }
                                    if (h()) {
                                        return false;
                                    }
                                    if (this.f35031j != null) {
                                        if (!this.n) {
                                            try {
                                                int b3 = this.f35031j.b();
                                                if (!c.p.a.e.b.l.f.C0(b3)) {
                                                    break;
                                                }
                                            } catch (BaseException e5) {
                                                throw e5;
                                            } catch (Throwable th2) {
                                                c.p.a.e.b.l.f.B(th2, "ChunkRunnableGetResponseCode");
                                                throw null;
                                            }
                                        }
                                        z = false;
                                        j2 = n2;
                                        this.f35028g = new c.p.a.e.b.g.g(this.f35029h, f2, this.f35031j, bVar, this.f35030i);
                                        if (bVar2 != null) {
                                            long c2 = bVar2.c(false);
                                            if (j6 != 0 && j6 >= j5) {
                                                c2 = (j6 - j5) + 1;
                                            }
                                            this.f35028g.e(bVar2.n(), bVar2.p(), c2);
                                        }
                                        try {
                                            this.f35028g.k();
                                            return true;
                                        } catch (BaseException e6) {
                                            e = e6;
                                            z2 = true;
                                            if (h()) {
                                            }
                                        }
                                    } else {
                                        throw new BaseException(1022, new IOException("download can't continue, chunk connection is null"));
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                    if (h()) {
                                        return true;
                                    }
                                    c.p.a.e.b.l.f.B(th, "downloadChunkInner");
                                    throw null;
                                }
                            } catch (Throwable th4) {
                                if (this.f35031j != null && this.f35030i != null) {
                                    try {
                                        int b4 = this.f35031j.b();
                                        if (b4 < 200 || b4 >= 300) {
                                            this.f35030i.e(this.f35031j);
                                        }
                                    } catch (Throwable th5) {
                                        th5.printStackTrace();
                                    }
                                }
                                throw th4;
                            }
                        } catch (BaseException e7) {
                            throw e7;
                        } catch (Throwable th6) {
                            c.p.a.e.b.l.f.B(th6, "ChunkRunnableConnection");
                            throw null;
                        }
                    } catch (BaseException e8) {
                        e = e8;
                        z2 = false;
                        j2 = j4;
                        if (h()) {
                            return true;
                        }
                        if (c.p.a.e.b.l.f.h0(e)) {
                            this.f35030i.i(e, z);
                            return z;
                        } else if (this.f35030i.a(e)) {
                            if (c.p.a.e.b.l.f.K(e)) {
                                this.f35030i.i(e, true);
                                return z;
                            }
                            if (z2) {
                                if (this.f35028g != null) {
                                    if (c.p.a.e.b.l.a.a(32)) {
                                        j3 = this.f35028g.a() - this.f35028g.l();
                                        int i2 = (j3 > 0L ? 1 : (j3 == 0L ? 0 : -1));
                                        if (i2 > 0) {
                                            c(bVar, this.f35028g.l());
                                        } else if (i2 < 0) {
                                        }
                                        if (!c.p.a.e.b.l.a.a(16)) {
                                            h2 = this.f35030i.b(bVar, e, j3);
                                        } else {
                                            h2 = this.f35030i.h(e, j3);
                                        }
                                        if (h2 != com.ss.android.socialbase.downloader.exception.h.f75524a) {
                                            return z;
                                        }
                                        bVar.b(z);
                                        g();
                                    } else {
                                        long j8 = j2;
                                        j7 = this.f35028g.a() - j8;
                                        c(bVar, j8);
                                    }
                                } else {
                                    this.f35030i.g(e);
                                    return z;
                                }
                            }
                            j3 = j7;
                            if (!c.p.a.e.b.l.a.a(16)) {
                            }
                            if (h2 != com.ss.android.socialbase.downloader.exception.h.f75524a) {
                            }
                        } else if (this.f35029h.isNeedChunkDowngradeRetry() && !this.f35029h.isChunkDowngradeRetryUsed() && this.f35029h.getChunkCount() > 1 && c.p.a.e.b.l.f.L(e, this.f35029h)) {
                            this.f35030i.f(e);
                            return z;
                        } else {
                            this.f35030i.g(e);
                            return z;
                        }
                    }
                } catch (Throwable th7) {
                    th = th7;
                    z = false;
                }
            } catch (BaseException e9) {
                e = e9;
                j4 = n2;
                z = false;
            }
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.m = true;
            c.p.a.e.b.g.g gVar = this.f35028g;
            if (gVar != null) {
                gVar.j();
            }
        }
    }

    public final String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f35029h.getConnectionUrl() : (String) invokeV.objValue;
    }

    public final void g() {
        k kVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (kVar = this.f35031j) == null) {
            return;
        }
        kVar.d();
        this.f35031j = null;
    }

    public final boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.l || this.m : invokeV.booleanValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x001b, code lost:
        r4.f35026e.a(false);
     */
    @Override // java.lang.Runnable
    @SuppressLint({"DefaultLocale"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            Process.setThreadPriority(10);
            this.f35026e = this.f35027f;
            while (true) {
                try {
                    this.f35026e.a(this);
                    if (!d(this.f35026e)) {
                        break;
                    }
                    this.f35026e.a(false);
                    if (!h()) {
                        this.f35026e = this.f35030i.a(this.f35026e.s());
                        if (h() || this.f35026e == null) {
                            break;
                        }
                        Thread.sleep(50L);
                    } else {
                        break;
                    }
                } finally {
                    com.ss.android.socialbase.downloader.model.b bVar = this.f35026e;
                    if (bVar != null) {
                        bVar.a(false);
                    }
                    g();
                    this.f35030i.c(this);
                }
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b(com.ss.android.socialbase.downloader.model.b bVar, c.p.a.e.b.n.a aVar, k kVar, f fVar) {
        this(bVar, aVar, fVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar, aVar, kVar, fVar};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((com.ss.android.socialbase.downloader.model.b) objArr2[0], (c.p.a.e.b.n.a) objArr2[1], (f) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f35031j = kVar;
    }
}
