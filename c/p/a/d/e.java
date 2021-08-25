package c.p.a.d;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.p.a.a.a.f.d;
import c.p.a.d.b.c;
import c.p.a.d.b.l;
import c.p.a.d.f;
import c.p.a.d.h;
import c.p.a.e.b.g.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ExecutorService f34699a;

    /* renamed from: b  reason: collision with root package name */
    public ExecutorService f34700b;

    /* renamed from: c  reason: collision with root package name */
    public ScheduledExecutorService f34701c;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
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
            k M0;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (e.class) {
                    try {
                        String[] strArr = {"sp_ad_download_event", "sp_download_finish_cache", "sp_delay_operation_info", "sp_ttdownloader_md5", "sp_name_installed_app", "misc_config", "sp_ad_install_back_dialog", "sp_ttdownloader_clean", "sp_order_download", "sp_a_b_c", "sp_ah_config", "sp_download_info", "sp_appdownloader"};
                        for (int i2 = 0; i2 < 13; i2++) {
                            SharedPreferences sharedPreferences = l.a().getSharedPreferences(strArr[i2], 0);
                            if (sharedPreferences != null) {
                                sharedPreferences.edit().clear().apply();
                            }
                        }
                        M0 = c.p.a.e.b.g.e.M0();
                    } catch (Throwable unused) {
                    }
                    if (M0 instanceof c.p.a.e.b.m.d) {
                        SparseArray<DownloadInfo> a2 = ((c.p.a.e.b.m.d) M0).f().a();
                        for (int size = a2.size() - 1; size >= 0; size--) {
                            DownloadInfo downloadInfo = a2.get(a2.keyAt(size));
                            if (downloadInfo != null) {
                                c.p.a.e.b.g.a.H(l.a()).d(downloadInfo.getId());
                            }
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static e f34702a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-146284760, "Lc/p/a/d/e$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-146284760, "Lc/p/a/d/e$b;");
                    return;
                }
            }
            f34702a = new e(null);
        }
    }

    /* loaded from: classes4.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes4.dex */
        public static /* synthetic */ class a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
        }

        /* loaded from: classes4.dex */
        public static class b {
            public static /* synthetic */ Interceptable $ic;

            /* renamed from: a  reason: collision with root package name */
            public static c f34703a;
            public transient /* synthetic */ FieldHolder $fh;

            static {
                InterceptResult invokeClinit;
                ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
                if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1154277193, "Lc/p/a/d/e$c$b;")) != null) {
                    Interceptable interceptable = invokeClinit.interceptor;
                    if (interceptable != null) {
                        $ic = interceptable;
                    }
                    if ((invokeClinit.flags & 1) != 0) {
                        classClinitInterceptable.invokePostClinit(1154277193, "Lc/p/a/d/e$c$b;");
                        return;
                    }
                }
                f34703a = new c(null);
            }
        }

        public /* synthetic */ c(a aVar) {
            this();
        }

        public static c a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? b.f34703a : (c) invokeV.objValue;
        }

        public final JSONObject b(c.p.a.b.a.c.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    h.r.o(aVar.g(), jSONObject);
                    h.r.o(aVar.p(), jSONObject);
                    jSONObject.putOpt("download_url", aVar.a());
                    jSONObject.putOpt("package_name", aVar.e());
                    jSONObject.putOpt("android_int", Integer.valueOf(Build.VERSION.SDK_INT));
                    jSONObject.putOpt("rom_name", c.p.a.e.a.h.e.k());
                    jSONObject.putOpt("rom_version", c.p.a.e.a.h.e.l());
                    jSONObject.putOpt("ttdownloader", 1);
                    jSONObject.putOpt("funnel_type", Integer.valueOf(aVar.h()));
                    if (aVar.h() == 2) {
                        h.l.e(jSONObject, aVar);
                    }
                } catch (Exception e2) {
                    l.F().a(e2, "getBaseJson");
                }
                return jSONObject;
            }
            return (JSONObject) invokeL.objValue;
        }

        public void c(long j2, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j2), Integer.valueOf(i2)}) == null) {
                c.f v = c.g.e().v(j2);
                if (v.x()) {
                    f.e.b().d("sendClickEvent ModelBox notValid");
                } else if (v.f34514c.l()) {
                    int i3 = 1;
                    c.p.a.a.a.d.c cVar = v.f34514c;
                    String c2 = i2 == 1 ? cVar.c() : cVar.b();
                    String m = h.r.m(v.f34514c.d(), PrefetchEvent.STATE_CLICK);
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.putOpt("download_click_type", Integer.valueOf(i2));
                        jSONObject.putOpt("permission_notification", Integer.valueOf(c.p.a.e.a.f.c.d() ? 1 : 2));
                        if (!c.p.a.e.b.l.f.r0(l.a())) {
                            i3 = 2;
                        }
                        jSONObject.putOpt("network_available", Integer.valueOf(i3));
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                    p(c2, m, jSONObject, v);
                    if (!PrefetchEvent.STATE_CLICK.equals(m) || v.f34513b == null) {
                        return;
                    }
                    C1538e.a().b(j2, v.f34513b.u());
                }
            }
        }

        public void d(long j2, int i2, DownloadInfo downloadInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j2), Integer.valueOf(i2), downloadInfo}) == null) {
                c.f v = c.g.e().v(j2);
                if (v.x()) {
                    f.e.b().d("sendEvent ModelBox notValid");
                    return;
                }
                String str = null;
                JSONObject jSONObject = new JSONObject();
                h.r.q(jSONObject, "download_scene", Integer.valueOf(v.t()));
                if (i2 == 1) {
                    str = h.r.m(v.f34514c.i(), "storage_deny");
                } else if (i2 == 2) {
                    str = h.r.m(v.f34514c.e(), "click_start");
                    h.l.c(downloadInfo, jSONObject);
                } else if (i2 == 3) {
                    str = h.r.m(v.f34514c.f(), "click_pause");
                    h.l.f(downloadInfo, jSONObject);
                } else if (i2 == 4) {
                    str = h.r.m(v.f34514c.g(), "click_continue");
                    h.l.g(downloadInfo, jSONObject);
                } else if (i2 == 5) {
                    if (downloadInfo != null) {
                        try {
                            h.l.d(jSONObject, downloadInfo.getId());
                            c.p.a.d.a.t(jSONObject, downloadInfo);
                        } catch (Throwable unused) {
                        }
                    }
                    str = h.r.m(v.f34514c.h(), "click_install");
                }
                o(null, str, jSONObject, 0L, 1, v);
            }
        }

        public void e(long j2, BaseException baseException) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJL(1048579, this, j2, baseException) == null) {
                c.f v = c.g.e().v(j2);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("download_time", 0);
                    if (baseException != null) {
                        jSONObject.putOpt("fail_status", Integer.valueOf(baseException.getErrorCode()));
                        jSONObject.putOpt("fail_msg", baseException.getErrorMessage());
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                w("download_failed", jSONObject, v);
            }
        }

        public void f(long j2, boolean z, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Long.valueOf(j2), Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
                c.f v = c.g.e().v(j2);
                if (v.x()) {
                    f.e.b().d("sendQuickAppEvent ModelBox notValid");
                } else if (v.f34513b.B() == null) {
                } else {
                    c.p.a.a.a.d.d dVar = v.f34513b;
                    if (dVar instanceof c.p.a.b.a.a.c) {
                        ((c.p.a.b.a.a.c) dVar).b(3);
                    }
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.putOpt("download_click_type", Integer.valueOf(i2));
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                    w(z ? "deeplink_quickapp_success" : "deeplink_quickapp_failed", jSONObject, v);
                }
            }
        }

        public final void g(c.p.a.a.a.f.d dVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048581, this, dVar) == null) || l.m() == null) {
                return;
            }
            if (dVar.e()) {
                l.m().a(dVar);
            } else {
                l.m().b(dVar);
            }
        }

        public void h(DownloadInfo downloadInfo) {
            c.p.a.b.a.c.b c2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048582, this, downloadInfo) == null) || (c2 = c.g.e().c(downloadInfo)) == null) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                h.l.g(downloadInfo, jSONObject);
                c2.Y(System.currentTimeMillis());
                p(c2.j(), "download_resume", jSONObject, c2);
                c.j.b().c(c2);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        public void i(DownloadInfo downloadInfo, BaseException baseException) {
            c.p.a.b.a.c.b c2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048583, this, downloadInfo, baseException) == null) || downloadInfo == null || (c2 = c.g.e().c(downloadInfo)) == null || c2.N.get()) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                c.p.a.d.a.g(jSONObject, downloadInfo);
                jSONObject.putOpt("fail_status", Integer.valueOf(c2.B()));
                jSONObject.putOpt("fail_msg", c2.C());
                jSONObject.put("download_failed_times", c2.k1());
                if (downloadInfo.getTotalBytes() > 0) {
                    jSONObject.put("download_percent", downloadInfo.getCurBytes() / downloadInfo.getTotalBytes());
                }
                jSONObject.put("download_status", downloadInfo.getRealStatus());
                long currentTimeMillis = System.currentTimeMillis();
                if (c2.E() > 0) {
                    jSONObject.put("time_from_start_download", currentTimeMillis - c2.E());
                }
                if (c2.y() > 0) {
                    jSONObject.put("time_from_download_resume", currentTimeMillis - c2.y());
                }
                int i2 = 1;
                jSONObject.put("is_update_download", c2.S() ? 1 : 2);
                jSONObject.put("can_show_notification", c.p.a.e.a.f.c.d() ? 1 : 2);
                if (!c2.O.get()) {
                    i2 = 2;
                }
                jSONObject.put("has_send_download_failed_finally", i2);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            p(c2.j(), "download_cancel", jSONObject, c2);
        }

        public void j(String str, int i2, c.f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, i2, fVar) == null) {
                o(null, str, null, i2, 0, fVar);
            }
        }

        public void k(String str, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(1048585, this, str, j2) == null) {
                c.p.a.b.a.c.b u = c.g.e().u(j2);
                if (u != null) {
                    v(str, u);
                } else {
                    v(str, c.g.e().v(j2));
                }
            }
        }

        public void l(String str, @NonNull c.p.a.a.a.d.d dVar, @NonNull c.p.a.a.a.d.c cVar, @NonNull c.p.a.a.a.d.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(1048586, this, str, dVar, cVar, bVar) == null) {
                v(str, new c.f(dVar.d(), dVar, cVar, bVar));
            }
        }

        public void m(String str, c.p.a.b.a.c.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048587, this, str, aVar) == null) {
                r(str, null, aVar);
            }
        }

        public void n(String str, String str2, c.p.a.b.a.c.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048588, this, str, str2, aVar) == null) {
                p(str, str2, null, aVar);
            }
        }

        public final void o(String str, String str2, JSONObject jSONObject, long j2, int i2, c.p.a.b.a.c.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{str, str2, jSONObject, Long.valueOf(j2), Integer.valueOf(i2), aVar}) == null) {
                if (aVar == null) {
                    f.e.b().d("onEvent data null");
                } else if ((aVar instanceof c.f) && ((c.f) aVar).x()) {
                    f.e.b().d("onEvent ModelBox notValid");
                } else {
                    try {
                        d.a aVar2 = new d.a();
                        aVar2.d(h.r.m(str, aVar.j(), "embeded_ad"));
                        aVar2.k(str2);
                        aVar2.m(aVar.c());
                        aVar2.b(aVar.b());
                        aVar2.o(aVar.d());
                        if (j2 <= 0) {
                            j2 = aVar.l();
                        }
                        aVar2.j(j2);
                        aVar2.q(aVar.i());
                        aVar2.e(aVar.n());
                        aVar2.f(h.r.p(b(aVar), jSONObject));
                        aVar2.l(aVar.k());
                        aVar2.c(aVar.o());
                        if (i2 <= 0) {
                            i2 = 2;
                        }
                        aVar2.a(i2);
                        aVar2.g(aVar.m());
                        g(aVar2.h());
                    } catch (Exception e2) {
                        f.e.b().a(e2, "onEvent");
                    }
                }
            }
        }

        public void p(String str, String str2, JSONObject jSONObject, c.p.a.b.a.c.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(1048590, this, str, str2, jSONObject, aVar) == null) {
                o(str, str2, jSONObject, 0L, 0, aVar);
            }
        }

        public void q(String str, JSONObject jSONObject, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{str, jSONObject, Long.valueOf(j2)}) == null) {
                c.p.a.b.a.c.a u = c.g.e().u(j2);
                if (u != null) {
                    r(str, jSONObject, u);
                    return;
                }
                c.f v = c.g.e().v(j2);
                if (v.x()) {
                    f.e.b().d("sendUnityEvent ModelBox notValid");
                } else {
                    r(str, jSONObject, v);
                }
            }
        }

        public void r(String str, JSONObject jSONObject, c.p.a.b.a.c.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048592, this, str, jSONObject, aVar) == null) {
                JSONObject jSONObject2 = new JSONObject();
                h.r.q(jSONObject2, "unity_label", str);
                h.r.o(jSONObject, jSONObject2);
                p("embeded_ad", "ttdownloader_unity", jSONObject2, aVar);
            }
        }

        public void s(JSONObject jSONObject, @NonNull c.p.a.b.a.c.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048593, this, jSONObject, bVar) == null) {
                p(bVar.j(), "install_finish", jSONObject, bVar);
            }
        }

        public void t(long j2, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{Long.valueOf(j2), Integer.valueOf(i2)}) == null) {
                d(j2, i2, null);
            }
        }

        public void u(DownloadInfo downloadInfo, BaseException baseException) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048595, this, downloadInfo, baseException) == null) || downloadInfo == null) {
                return;
            }
            c.p.a.b.a.c.b c2 = c.g.e().c(downloadInfo);
            if (c2 == null) {
                f.e.b().d("sendDownloadFailedEvent nativeModel null");
            } else if (c2.N.get()) {
            } else {
                JSONObject jSONObject = new JSONObject();
                try {
                    h.l.g(downloadInfo, jSONObject);
                    c.p.a.d.a.g(jSONObject, downloadInfo);
                    if (baseException != null) {
                        jSONObject.putOpt("fail_status", Integer.valueOf(baseException.getErrorCode()));
                        jSONObject.putOpt("fail_msg", baseException.getErrorMessage());
                        c2.t0(baseException.getErrorCode());
                        c2.Z(baseException.getErrorMessage());
                    }
                    c2.l1();
                    jSONObject.put("download_failed_times", c2.k1());
                    if (downloadInfo.getTotalBytes() > 0) {
                        jSONObject.put("download_percent", downloadInfo.getCurBytes() / downloadInfo.getTotalBytes());
                    }
                    int i2 = 1;
                    jSONObject.put("has_send_download_failed_finally", c2.O.get() ? 1 : 2);
                    h.l.b(c2, jSONObject);
                    if (!c2.S()) {
                        i2 = 2;
                    }
                    jSONObject.put("is_update_download", i2);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                p(c2.j(), "download_failed", jSONObject, c2);
                c.j.b().c(c2);
            }
        }

        public void v(String str, c.p.a.b.a.c.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048596, this, str, aVar) == null) {
                n(null, str, aVar);
            }
        }

        public void w(String str, JSONObject jSONObject, c.p.a.b.a.c.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048597, this, str, jSONObject, aVar) == null) {
                p(null, str, jSONObject, aVar);
            }
        }

        public c() {
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
    }

    /* loaded from: classes4.dex */
    public class d extends SQLiteOpenHelper {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: e  reason: collision with root package name */
        public static final String[] f34704e;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-146284698, "Lc/p/a/d/e$d;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-146284698, "Lc/p/a/d/e$d;");
                    return;
                }
            }
            f34704e = new String[]{"_id", LegoListActivityConfig.AD_ID, IAdRequestParam.REQ_ID, "time"};
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(@Nullable Context context) {
            super(context, "click_event", (SQLiteDatabase.CursorFactory) null, 1);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Context) objArr2[0], (String) objArr2[1], (SQLiteDatabase.CursorFactory) objArr2[2], ((Integer) objArr2[3]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, sQLiteDatabase) == null) {
                sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS click_event(_id INTEGER PRIMARY KEY AUTOINCREMENT,ad_id INTEGER,req_id TEXT,time INTEGER)");
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sQLiteDatabase, i2, i3) == null) {
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS click_event");
                onCreate(sQLiteDatabase);
            }
        }
    }

    /* renamed from: c.p.a.d.e$e  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1538e {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: b  reason: collision with root package name */
        public static volatile C1538e f34705b;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public SQLiteDatabase f34706a;

        public C1538e() {
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
            try {
                this.f34706a = new d(l.a()).getWritableDatabase();
            } catch (Throwable th) {
                f.e.b().a(th, "ClickEventHelper");
            }
        }

        public static C1538e a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
                if (f34705b == null) {
                    synchronized (C1538e.class) {
                        if (f34705b == null) {
                            f34705b = new C1538e();
                        }
                    }
                }
                return f34705b;
            }
            return (C1538e) invokeV.objValue;
        }

        public void b(long j2, String str) {
            SQLiteDatabase sQLiteDatabase;
            String optString;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJL(1048576, this, j2, str) == null) || (sQLiteDatabase = this.f34706a) == null || !sQLiteDatabase.isOpen() || j2 <= 0 || TextUtils.isEmpty(str)) {
                return;
            }
            try {
                optString = new JSONObject(str).optString(IAdRequestParam.REQ_ID);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (TextUtils.isEmpty(optString)) {
                return;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put(LegoListActivityConfig.AD_ID, Long.valueOf(j2));
            contentValues.put(IAdRequestParam.REQ_ID, optString);
            contentValues.put("time", Long.valueOf(System.currentTimeMillis()));
            this.f34706a.insert("click_event", null, contentValues);
            e(j2, str);
        }

        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? c.p.a.e.b.j.a.r().b("click_event_switch", 0) == 1 : invokeV.booleanValue;
        }

        /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
        public boolean d(long j2, String str) {
            InterceptResult invokeJL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJL = interceptable.invokeJL(Constants.METHOD_SEND_USER_MSG, this, j2, str)) == null) {
                SQLiteDatabase sQLiteDatabase = this.f34706a;
                if (sQLiteDatabase == null || !sQLiteDatabase.isOpen() || j2 <= 0 || TextUtils.isEmpty(str)) {
                    return false;
                }
                Cursor cursor = null;
                try {
                    try {
                        String optString = new JSONObject(str).optString(IAdRequestParam.REQ_ID);
                        if (TextUtils.isEmpty(optString)) {
                            return false;
                        }
                        cursor = this.f34706a.query("click_event", d.f34704e, "time > ? AND ad_id = ? AND req_id = ?", new String[]{String.valueOf(System.currentTimeMillis() - 1209600000), String.valueOf(j2), optString}, null, null, null, null);
                        boolean z = cursor.getCount() > 0;
                        if (cursor != null) {
                            cursor.close();
                        }
                        return z;
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        if (cursor != null) {
                            cursor.close();
                        }
                        return false;
                    }
                } catch (Throwable th) {
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
            return invokeJL.booleanValue;
        }

        public final void e(long j2, String str) {
            SQLiteDatabase sQLiteDatabase;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJL(1048579, this, j2, str) == null) || (sQLiteDatabase = this.f34706a) == null || !sQLiteDatabase.isOpen() || j2 <= 0 || TextUtils.isEmpty(str)) {
                return;
            }
            try {
                String optString = new JSONObject(str).optString(IAdRequestParam.REQ_ID);
                if (TextUtils.isEmpty(optString)) {
                    return;
                }
                this.f34706a.delete("click_event", "time < ? AND ad_id = ? AND req_id = ?", new String[]{String.valueOf(System.currentTimeMillis() - 1209600000), String.valueOf(j2), optString});
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        public boolean f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? c.p.a.e.b.j.a.r().b("click_event_switch", 0) == 2 : invokeV.booleanValue;
        }
    }

    public /* synthetic */ e(a aVar) {
        this();
    }

    public static e a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? b.f34702a : (e) invokeV.objValue;
    }

    public void b(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, runnable) == null) {
            d(runnable, false);
        }
    }

    public void c(Runnable runnable, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, runnable, j2) == null) {
            try {
                i().schedule(runnable, j2, TimeUnit.MILLISECONDS);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public void d(Runnable runnable, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, runnable, z) == null) || runnable == null) {
            return;
        }
        if (z && !h.r.r()) {
            runnable.run();
        } else {
            e().execute(runnable);
        }
    }

    public ExecutorService e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.f34699a == null) {
                synchronized (e.class) {
                    if (this.f34699a == null) {
                        TimeUnit timeUnit = TimeUnit.SECONDS;
                        SynchronousQueue synchronousQueue = new SynchronousQueue();
                        this.f34699a = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 30L, timeUnit, synchronousQueue, new c.p.a.e.b.k.a(h.class.getName() + "-CPUThreadPool"));
                    }
                }
            }
            return this.f34699a;
        }
        return (ExecutorService) invokeV.objValue;
    }

    public void f(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, runnable) == null) {
            g(runnable, false);
        }
    }

    public void g(Runnable runnable, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048581, this, runnable, z) == null) || runnable == null) {
            return;
        }
        if (z && !h.r.r()) {
            runnable.run();
        } else {
            h().execute(runnable);
        }
    }

    public ExecutorService h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.f34700b == null) {
                synchronized (e.class) {
                    if (this.f34700b == null) {
                        TimeUnit timeUnit = TimeUnit.SECONDS;
                        SynchronousQueue synchronousQueue = new SynchronousQueue();
                        this.f34700b = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 30L, timeUnit, synchronousQueue, new c.p.a.e.b.k.a(h.class.getName() + "-IOThreadPool"));
                    }
                }
            }
            return this.f34700b;
        }
        return (ExecutorService) invokeV.objValue;
    }

    public ScheduledExecutorService i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.f34701c == null) {
                synchronized (e.class) {
                    if (this.f34701c == null) {
                        this.f34701c = new ScheduledThreadPoolExecutor(0, new c.p.a.e.b.k.a(h.class.getName() + "-ScheduledThreadPool"));
                    }
                }
            }
            return this.f34701c;
        }
        return (ScheduledExecutorService) invokeV.objValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            b(new a(this));
        }
    }

    public e() {
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
}
