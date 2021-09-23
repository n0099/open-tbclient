package c.p.a.e.b.o.b;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.p.a.e.b.l.f;
import c.p.a.e.b.o.l;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final HandlerThread f35409a;

    /* renamed from: b  reason: collision with root package name */
    public static final Handler f35410b;

    /* renamed from: c  reason: collision with root package name */
    public static long f35411c;

    /* renamed from: d  reason: collision with root package name */
    public static long f35412d;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    Process.setThreadPriority(10);
                } catch (Throwable unused) {
                }
            }
        }
    }

    /* renamed from: c.p.a.e.b.o.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class RunnableC1554b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f35413e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ l f35414f;

        public RunnableC1554b(String str, l lVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, lVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f35413e = str;
            this.f35414f = lVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            if (!TextUtils.isEmpty(this.f35413e)) {
                try {
                    try {
                        List<com.ss.android.socialbase.downloader.model.c> d2 = b.d(0L, null, null);
                        r1 = c.p.a.e.b.o.b.a.a().e(this.f35413e) ? c.p.a.e.b.o.b.a.a().b(this.f35413e, d2) : null;
                        if (r1 == null) {
                            c cVar = new c(this.f35413e, d2, 0L);
                            try {
                                cVar.e();
                                if (cVar.h()) {
                                    c.p.a.e.b.o.b.a.a().d(this.f35413e, cVar);
                                }
                                r1 = cVar;
                            } catch (Exception e2) {
                                e = e2;
                                r1 = cVar;
                                e.printStackTrace();
                                r1.c();
                            } catch (Throwable th) {
                                th = th;
                                r1 = cVar;
                                try {
                                    r1.c();
                                } catch (Throwable unused) {
                                }
                                throw th;
                            }
                        }
                        Map<String, String> l = r1.l();
                        if (this.f35414f != null) {
                            this.f35414f.a(l);
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (Exception e3) {
                    e = e3;
                }
                try {
                    r1.c();
                } catch (Throwable unused2) {
                }
            } else {
                l lVar = this.f35414f;
                if (lVar != null) {
                    lVar.a(null);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1555148898, "Lc/p/a/e/b/o/b/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1555148898, "Lc/p/a/e/b/o/b/b;");
                return;
            }
        }
        f35409a = new HandlerThread("Downloader-preconnecter");
        e();
        f35409a.start();
        Handler handler = new Handler(f35409a.getLooper());
        f35410b = handler;
        handler.post(new a());
    }

    public static Looper a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? f35409a.getLooper() : (Looper) invokeV.objValue;
    }

    public static void c(String str, l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, str, lVar) == null) {
            f35410b.post(new RunnableC1554b(str, lVar));
        }
    }

    public static List<com.ss.android.socialbase.downloader.model.c> d(long j2, DownloadInfo downloadInfo, List<com.ss.android.socialbase.downloader.model.c> list) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Long.valueOf(j2), downloadInfo, list})) == null) {
            return f.s(list, downloadInfo == null ? null : downloadInfo.geteTag(), j2, 0L);
        }
        return (List) invokeCommon.objValue;
    }

    public static void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null) == null) {
            f35411c = c.p.a.e.b.j.a.r().c("preconnect_connection_outdate_time", 300000L);
            f35412d = c.p.a.e.b.j.a.r().c("preconnect_head_info_outdate_time", 300000L);
            c.p.a.e.b.o.b.a.a().c(c.p.a.e.b.j.a.r().b("preconnect_max_cache_size", 3));
        }
    }
}
