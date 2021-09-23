package c.p.a.d;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.Environment;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.core.view.InputDeviceCompat;
import c.p.a.d.b.c;
import c.p.a.d.b.d;
import c.p.a.d.b.g;
import c.p.a.d.b.l;
import c.p.a.d.c;
import c.p.a.d.d;
import c.p.a.d.e;
import c.p.a.d.f;
import c.p.a.d.h;
import c.p.a.e.a.c;
import c.p.a.e.b.a.a;
import c.p.a.e.b.f.k;
import c.p.a.e.b.o.m;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.request.db.DownloadDataConstants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.launch.stats.SpeedStatsStampTable;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a implements c.p.a.b.a.b, c.e, a.b, k {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: g  reason: collision with root package name */
    public static String f34565g = "a";

    /* renamed from: h  reason: collision with root package name */
    public static volatile a f34566h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public long f34567e;

    /* renamed from: f  reason: collision with root package name */
    public f f34568f;

    /* renamed from: c.p.a.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1521a implements c.j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c.p.a.b.a.c.b f34581a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f34582b;

        public C1521a(a aVar, c.p.a.b.a.c.b bVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, bVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f34581a = bVar;
            this.f34582b = str;
        }

        @Override // c.p.a.d.c.j
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                String str = a.f34565g;
                c.p.a.e.b.c.a.g(str, "appBackForeground->" + z);
                if (z) {
                    if (!(c.i.f(this.f34581a) ? c.d.i(this.f34582b, this.f34581a) : false) && c.i.g(this.f34581a) && this.f34581a.H() == 4) {
                        c.p.a.d.b.a.a.a().f(this.f34581a);
                    }
                } else if (c.d.i(this.f34582b, this.f34581a) || this.f34581a.H() != 4) {
                } else {
                    c.p.a.d.b.a.a.a().f(this.f34581a);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f34583e;

        public b(a aVar, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Long.valueOf(j2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f34583e = j2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                a.d().h(this.f34583e);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f34584e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.p.a.b.a.c.b f34585f;

        public c(a aVar, String str, c.p.a.b.a.c.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f34584e = str;
            this.f34585f = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                String b2 = h.g.b(this.f34584e);
                if (TextUtils.isEmpty(b2)) {
                    return;
                }
                l.a().getSharedPreferences("sp_ttdownloader_md5", 0).edit().putString(String.valueOf(this.f34585f.b()), b2).apply();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements c.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ DownloadInfo f34586a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ JSONObject f34587b;

        public d(a aVar, DownloadInfo downloadInfo, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, downloadInfo, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f34586a = downloadInfo;
            this.f34587b = jSONObject;
        }

        @Override // c.p.a.d.c.g
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (!z) {
                    Intent intent = (Intent) this.f34586a.getTempCacheData().get("intent");
                    if (intent != null) {
                        this.f34586a.getTempCacheData().remove("intent");
                        c.p.a.e.a.d.f(l.a(), intent);
                        h.r.q(this.f34587b, UnitedSchemeConstants.UNITED_SCHEME_BACKUP, 1);
                    } else {
                        h.r.q(this.f34587b, UnitedSchemeConstants.UNITED_SCHEME_BACKUP, 2);
                    }
                }
                c.p.a.b.a.c.b c2 = c.g.e().c(this.f34586a);
                if (c2 != null) {
                    e.c.a().r(z ? "installer_delay_success" : "installer_delay_failed", this.f34587b, c2);
                } else {
                    f.e.b().g("ah nativeModel=null");
                }
                if (z) {
                    l.G().a(l.a(), null, null, null, null, 1);
                }
            }
        }
    }

    @WorkerThread
    /* loaded from: classes4.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final int f34588e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f34589f;

        public e(a aVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f34589f = aVar;
            this.f34588e = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    c.g.e().q();
                    ConcurrentHashMap<Long, c.p.a.b.a.c.b> t = c.g.e().t();
                    if (t == null || t.isEmpty()) {
                        return;
                    }
                    this.f34589f.r(t, this.f34588e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public long f34590e;

        /* renamed from: f  reason: collision with root package name */
        public int f34591f;

        /* renamed from: g  reason: collision with root package name */
        public long f34592g;

        /* renamed from: h  reason: collision with root package name */
        public int f34593h;

        /* renamed from: i  reason: collision with root package name */
        public long f34594i;

        public /* synthetic */ f(long j2, int i2, long j3, int i3, C1521a c1521a) {
            this(j2, i2, j3, i3);
        }

        public final int a(boolean z, c.p.a.b.a.c.b bVar, DownloadInfo downloadInfo, boolean z2, JSONObject jSONObject) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), bVar, downloadInfo, Boolean.valueOf(z2), jSONObject})) == null) {
                c.p.a.e.b.j.a d2 = c.p.a.e.b.j.a.d(downloadInfo.getId());
                int i2 = 1;
                if (d2.b("install_failed_check_ttmd5", 1) == 1) {
                    int checkMd5Status = downloadInfo.checkMd5Status();
                    try {
                        jSONObject.put("ttmd5_status", checkMd5Status);
                    } catch (Throwable unused) {
                    }
                    if (!c.p.a.e.b.l.f.G(checkMd5Status)) {
                        return 2005;
                    }
                }
                int i3 = this.f34593h;
                if (i3 != 2000) {
                    return i3;
                }
                if (d2.b("install_failed_check_signature", 1) == 1 && h.r.G(l.a(), bVar.e()) && !h.r.x(h.r.K(l.a(), downloadInfo.getTargetFilePath()), h.r.J(l.a(), bVar.e()))) {
                    return 2006;
                }
                if (z) {
                    long j2 = this.f34594i;
                    long j3 = this.f34592g;
                    if (j2 > j3) {
                        try {
                            jSONObject.put("install_time", j2 - j3);
                            if (bVar.z() <= this.f34592g) {
                                i2 = 0;
                            }
                            jSONObject.put("install_again", i2);
                        } catch (Throwable unused2) {
                        }
                        return !z2 ? 2003 : 2004;
                    }
                    return 2000;
                }
                return 2002;
            }
            return invokeCommon.intValue;
        }

        /* JADX WARN: Code restructure failed: missing block: B:19:0x0068, code lost:
            if (r9 < r1) goto L20;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean c() {
            InterceptResult invokeV;
            DownloadInfo f2;
            double d2;
            JSONObject jSONObject;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                c.p.a.b.a.c.b u = c.g.e().u(this.f34590e);
                boolean z = false;
                if (u == null || h.r.C(u) || u.N.get() || (f2 = c.p.a.e.b.g.a.H(l.a()).f(u.s())) == null) {
                    return false;
                }
                long J = u.J();
                long e2 = h.r.e(Environment.getDataDirectory());
                long min = Math.min(524288000L, e2 / 10);
                long totalBytes = f2.getTotalBytes();
                double d3 = totalBytes;
                double d4 = min + (2.5d * d3);
                if (J <= -1 || totalBytes <= -1) {
                    d2 = d3;
                } else {
                    d2 = d3;
                }
                z = true;
                boolean l = c.p.a.e.a.c.l(l.a());
                JSONObject jSONObject2 = new JSONObject();
                int a2 = a(z, u, f2, l, jSONObject2);
                this.f34593h = a2;
                try {
                    jSONObject = jSONObject2;
                } catch (Exception e3) {
                    e = e3;
                    jSONObject = jSONObject2;
                }
                try {
                    jSONObject.putOpt("fail_status", Integer.valueOf(a2));
                    jSONObject.putOpt("available_space", Long.valueOf(J / 1048576));
                    jSONObject.putOpt("total_space", Long.valueOf(e2 / 1048576));
                    int i2 = (totalBytes > 0L ? 1 : (totalBytes == 0L ? 0 : -1));
                    if (i2 > 0) {
                        jSONObject.putOpt("package_size", Long.valueOf(totalBytes / 1048576));
                    }
                    jSONObject.putOpt("space_enough", Integer.valueOf(z ? 1 : 2));
                    if (J > 0 && i2 > 0) {
                        jSONObject.put("available_space_ratio", J / d2);
                    }
                    jSONObject.putOpt("permission_unknown_source_install", Integer.valueOf(l ? 1 : 2));
                    jSONObject.put("is_update_download", u.S() ? 1 : 2);
                } catch (Exception e4) {
                    e = e4;
                    e.printStackTrace();
                    e.c.a().w("install_failed", jSONObject, u);
                    return true;
                }
                e.c.a().w("install_failed", jSONObject, u);
                return true;
            }
            return invokeV.booleanValue;
        }

        public final void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f34594i = System.currentTimeMillis();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                try {
                    if (c()) {
                        a.d().i(this.f34590e, this.f34591f);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }

        public f(long j2, int i2, long j3, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Long.valueOf(j2), Integer.valueOf(i2), Long.valueOf(j3), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f34590e = j2;
            this.f34591f = i2;
            this.f34592g = j3;
            this.f34593h = i3;
        }
    }

    /* loaded from: classes4.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final c.p.a.b.a.c.b f34595e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f34596f;

        public g(a aVar, c.p.a.b.a.c.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f34596f = aVar;
            this.f34595e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    try {
                        this.f34595e.T0(true);
                        this.f34596f.x(this.f34595e);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                } finally {
                    this.f34595e.T0(false);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1242609046, "Lc/p/a/d/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1242609046, "Lc/p/a/d/a;");
        }
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        c.p.a.e.a.c.j(this);
        c.p.a.e.b.a.a.c().f(this);
    }

    public static a d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (f34566h == null) {
                synchronized (a.class) {
                    if (f34566h == null) {
                        f34566h = new a();
                    }
                }
            }
            return f34566h;
        }
        return (a) invokeV.objValue;
    }

    public static DownloadInfo e(List<DownloadInfo> list, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, list, str)) == null) {
            if (list != null && !list.isEmpty() && !TextUtils.isEmpty(str)) {
                for (DownloadInfo downloadInfo : list) {
                    if (downloadInfo != null) {
                        if (str.equals(downloadInfo.getPackageName())) {
                            return downloadInfo;
                        }
                        if (h.r.u(l.a(), downloadInfo.getTargetFilePath(), str)) {
                            return downloadInfo;
                        }
                    }
                }
            }
            return null;
        }
        return (DownloadInfo) invokeLL.objValue;
    }

    public static JSONObject g(JSONObject jSONObject, DownloadInfo downloadInfo) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, jSONObject, downloadInfo)) == null) {
            if (jSONObject != null && downloadInfo != null) {
                int i2 = 1;
                if (c.p.a.e.b.j.a.d(downloadInfo.getId()).b("download_event_opt", 1) == 0) {
                    return jSONObject;
                }
                try {
                    jSONObject.put("download_id", downloadInfo.getId());
                    jSONObject.put("name", downloadInfo.getName());
                    jSONObject.put("cur_bytes", downloadInfo.getCurBytes());
                    jSONObject.put(DownloadDataConstants.Columns.COLUMN_TOTAL_BYTES, downloadInfo.getTotalBytes());
                    jSONObject.put("network_quality", downloadInfo.getNetworkQuality());
                    jSONObject.put("current_network_quality", m.a().d().name());
                    jSONObject.put("only_wifi", downloadInfo.isOnlyWifi() ? 1 : 0);
                    jSONObject.put("need_https_degrade", downloadInfo.isNeedHttpsToHttpRetry() ? 1 : 0);
                    jSONObject.put("https_degrade_retry_used", downloadInfo.isHttpsToHttpRetryUsed() ? 1 : 0);
                    jSONObject.put("chunk_count", downloadInfo.getChunkCount());
                    jSONObject.put("retry_count", downloadInfo.getRetryCount());
                    jSONObject.put("cur_retry_time", downloadInfo.getCurRetryTime());
                    jSONObject.put("need_retry_delay", downloadInfo.isNeedRetryDelay() ? 1 : 0);
                    jSONObject.put("backup_url_used", downloadInfo.isBackUpUrlUsed() ? 1 : 0);
                    jSONObject.put("head_connection_error_msg", downloadInfo.getHeadConnectionException() != null ? downloadInfo.getHeadConnectionException() : "");
                    jSONObject.put("need_independent_process", downloadInfo.isNeedIndependentProcess() ? 1 : 0);
                    jSONObject.put("total_retry_count", downloadInfo.getTotalRetryCount());
                    jSONObject.put("cur_retry_time_in_total", downloadInfo.getCurRetryTimeInTotal());
                    jSONObject.put("real_download_time", downloadInfo.getRealDownloadTime());
                    jSONObject.put("first_speed_time", downloadInfo.getFirstSpeedTime());
                    jSONObject.put("all_connect_time", downloadInfo.getAllConnectTime());
                    jSONObject.put("download_prepare_time", downloadInfo.getDownloadPrepareTime());
                    jSONObject.put("download_time", downloadInfo.getRealDownloadTime() + downloadInfo.getAllConnectTime() + downloadInfo.getDownloadPrepareTime());
                    jSONObject.put("chunk_downgrade_retry_used", downloadInfo.isChunkDowngradeRetryUsed() ? 1 : 0);
                    jSONObject.put("need_chunk_downgrade_retry", downloadInfo.isNeedChunkDowngradeRetry() ? 1 : 0);
                    jSONObject.put("failed_resume_count", downloadInfo.getFailedResumeCount());
                    jSONObject.put("preconnect_level", downloadInfo.getPreconnectLevel());
                    jSONObject.put(PackageTable.MD5, downloadInfo.getMd5());
                    jSONObject.put("expect_file_length", downloadInfo.getExpectFileLength());
                    jSONObject.put("retry_schedule_count", downloadInfo.getRetryScheduleCount());
                    jSONObject.put("rw_concurrent", downloadInfo.isRwConcurrent() ? 1 : 0);
                    double curBytes = downloadInfo.getCurBytes() / 1048576.0d;
                    double realDownloadTime = downloadInfo.getRealDownloadTime() / 1000.0d;
                    if (curBytes > 0.0d && realDownloadTime > 0.0d) {
                        double d2 = curBytes / realDownloadTime;
                        try {
                            jSONObject.put("download_speed", d2);
                        } catch (Exception unused) {
                        }
                        String str = f34565g;
                        c.p.a.e.b.c.a.g(str, "download speed : " + d2 + "MB/s");
                    }
                    try {
                        jSONObject.put("is_download_service_foreground", c.p.a.e.b.g.a.H(l.a()).r(downloadInfo.getId()) ? 1 : 0);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    if (downloadInfo.getBackUpUrls() != null) {
                        jSONObject.put("backup_url_count", downloadInfo.getBackUpUrls().size());
                        jSONObject.put("cur_backup_url_index", downloadInfo.getCurBackUpUrlIndex());
                    }
                    jSONObject.put("clear_space_restart_times", d.e.a().f(downloadInfo.getUrl()));
                    jSONObject.put("mime_type", downloadInfo.getMimeType());
                    if (!c.p.a.e.b.l.f.r0(l.a())) {
                        i2 = 2;
                    }
                    jSONObject.put("network_available", i2);
                    jSONObject.put("status_code", downloadInfo.getHttpStatusCode());
                    t(jSONObject, downloadInfo);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }

    @WorkerThread
    public static synchronized void n(DownloadInfo downloadInfo, c.p.a.b.a.c.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, downloadInfo, bVar) == null) {
            synchronized (a.class) {
                if (downloadInfo == null) {
                    f.e.b().d("onDownloadFinish info null");
                } else if (bVar == null) {
                    f.e.b().d("onDownloadFinish nativeModel null");
                } else if (bVar.D() != 1) {
                } else {
                    d.k.a().k(bVar);
                    String w = w(downloadInfo, bVar);
                    c.g.e().r(downloadInfo.getUrl(), w);
                    Map<Long, c.p.a.b.a.c.b> f2 = c.g.e().f(downloadInfo.getUrl(), w);
                    bVar.C0(System.currentTimeMillis());
                    bVar.x0(2);
                    bVar.n0(w);
                    f2.put(Long.valueOf(bVar.b()), bVar);
                    c.j.b().d(f2.values());
                    u(bVar);
                    c.p.a.d.g.b().i(downloadInfo, w);
                    if ("application/vnd.android.package-archive".equals(downloadInfo.getMimeType())) {
                        d().j(bVar);
                        d().v(downloadInfo, bVar);
                        if (bVar.I()) {
                            c.p.a.d.b.a.a.a().c(downloadInfo.getId(), bVar.b(), bVar.l(), w, downloadInfo.getTitle(), bVar.d(), downloadInfo.getTargetFilePath());
                        }
                        g.i.a(downloadInfo, bVar.b(), bVar.d(), w);
                    }
                }
            }
        }
    }

    public static JSONObject t(JSONObject jSONObject, DownloadInfo downloadInfo) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, jSONObject, downloadInfo)) == null) {
            if (jSONObject == null || downloadInfo == null || c.p.a.e.b.j.a.d(downloadInfo.getId()).b("download_event_opt", 1) == 0) {
                return jSONObject;
            }
            try {
                long d2 = h.r.d(0L);
                double d3 = d2;
                jSONObject.put("available_space", d3 / 1048576.0d);
                long totalBytes = downloadInfo.getTotalBytes();
                double d4 = totalBytes;
                jSONObject.put("apk_size", d4 / 1048576.0d);
                if (d2 > 0 && totalBytes > 0) {
                    jSONObject.put("available_space_ratio", d3 / d4);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }

    public static void u(c.p.a.b.a.c.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65546, null, bVar) == null) || bVar == null) {
            return;
        }
        String M = TextUtils.isEmpty(bVar.M()) ? "" : bVar.M();
        DownloadInfo f2 = c.p.a.e.b.g.a.H(l.a()).f(bVar.s());
        bVar.Y0("");
        c.j.b().c(bVar);
        JSONObject jSONObject = new JSONObject();
        g(jSONObject, f2);
        int i2 = 1;
        try {
            jSONObject.putOpt("finish_reason", M);
            jSONObject.putOpt("finish_from_reserve_wifi", Integer.valueOf(f2.isDownloadFromReserveWifi() ? 1 : 0));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        c.p.a.b.a.c.b c2 = c.g.e().c(f2);
        h.l.d(jSONObject, f2.getId());
        try {
            jSONObject.put("download_failed_times", c2.k1());
            jSONObject.put("can_show_notification", c.p.a.e.a.f.c.d() ? 1 : 2);
            if (f2.getExpectFileLength() > 0 && f2.getTotalBytes() > 0) {
                jSONObject.put("file_length_gap", f2.getExpectFileLength() - f2.getTotalBytes());
            }
            jSONObject.put("ttmd5_status", f2.getTTMd5CheckStatus());
            jSONObject.put("has_send_download_failed_finally", c2.O.get() ? 1 : 2);
            if (!c2.S()) {
                i2 = 2;
            }
            jSONObject.put("is_update_download", i2);
            h.l.b(c2, jSONObject);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        e.c.a().w("download_finish", jSONObject, bVar);
    }

    public static String w(@NonNull DownloadInfo downloadInfo, @NonNull c.p.a.b.a.c.b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65547, null, downloadInfo, bVar)) == null) {
            File file = new File(downloadInfo.getSavePath(), downloadInfo.getName());
            String str = null;
            if (file.exists()) {
                try {
                    PackageInfo packageArchiveInfo = l.a().getPackageManager().getPackageArchiveInfo(file.getAbsolutePath(), c.p.a.e.a.d.a());
                    if (packageArchiveInfo != null) {
                        str = packageArchiveInfo.packageName;
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            if (!TextUtils.isEmpty(str) && !str.equals(downloadInfo.getPackageName())) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("real_package_name", str);
                    jSONObject.put("input_package_name", downloadInfo.getPackageName());
                } catch (JSONException e3) {
                    e3.printStackTrace();
                }
                e.c.a().p("embeded_ad", "package_name_error", jSONObject, bVar);
                return str;
            }
            return downloadInfo.getPackageName();
        }
        return (String) invokeLL.objValue;
    }

    @Override // c.p.a.b.a.b
    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.f34567e < AppConfig.TIMESTAMP_AVAILABLE_DURATION) {
                return;
            }
            c.p.a.d.e.a().c(new e(this, i2), this.f34567e > 0 ? 2000L : 8000L);
            this.f34567e = currentTimeMillis;
        }
    }

    public final int b(c.p.a.b.a.c.b bVar, DownloadInfo downloadInfo, String str, JSONObject jSONObject) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048579, this, bVar, downloadInfo, str, jSONObject)) == null) {
            int E = c.p.a.e.a.d.E(l.a(), downloadInfo);
            int y = h.r.y(l.a(), str);
            if (E > 0 && y > 0 && E != y) {
                return y > E ? SpeedStatsStampTable.CHECK_CLIENT_CONFIG_END_STAMP_KEY : SpeedStatsStampTable.CHECK_CLIENT_CONFIG_START_STAMP_KEY;
            } else if (c.p.a.e.b.j.a.d(bVar.s()).b("install_finish_check_ttmd5", 1) == 1) {
                String string = l.a().getSharedPreferences("sp_ttdownloader_md5", 0).getString(String.valueOf(bVar.b()), null);
                if (TextUtils.isEmpty(string) && downloadInfo != null) {
                    string = h.g.b(downloadInfo.getTargetFilePath());
                }
                int a2 = h.g.a(string, h.g.e(str));
                try {
                    jSONObject.put("ttmd5_status", a2);
                } catch (Throwable unused) {
                }
                if (a2 == 0) {
                    return 3000;
                }
                return a2 == 1 ? 3002 : 3001;
            } else {
                return 3001;
            }
        }
        return invokeLLLL.intValue;
    }

    @Override // c.p.a.e.b.a.a.b
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            c.p.a.e.b.c.a.g(f34565g, "onAppBackground()");
            a(6);
        }
    }

    public final JSONObject f(c.p.a.b.a.c.b bVar, String str, int i2) {
        InterceptResult invokeLLI;
        c.p.a.e.a.b a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048582, this, bVar, str, i2)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                DownloadInfo f2 = c.p.a.e.b.g.a.H(l.a()).f(bVar.s());
                jSONObject.putOpt("scene", Integer.valueOf(i2));
                h.l.d(jSONObject, bVar.s());
                h.l.b(bVar, jSONObject);
                jSONObject.put("is_update_download", bVar.S() ? 1 : 2);
                jSONObject.put("install_after_back_app", bVar.d0() ? 1 : 2);
                jSONObject.putOpt("clean_space_install_params", bVar.O() ? "1" : "2");
                if (f2 != null) {
                    g(jSONObject, f2);
                    try {
                        jSONObject.put("uninstall_resume_count", f2.getUninstallResumeCount());
                        if (bVar.z() > 0) {
                            jSONObject.put("install_time", System.currentTimeMillis() - bVar.z());
                        }
                    } catch (Throwable unused) {
                    }
                    String i3 = c.p.a.e.b.l.f.i(f2.getTempCacheData().get("ah_attempt"), null);
                    if (!TextUtils.isEmpty(i3) && (a2 = c.p.a.e.a.b.a(i3)) != null) {
                        a2.c(jSONObject);
                    }
                }
                int b2 = b(bVar, f2, str, jSONObject);
                jSONObject.put("fail_status", b2);
                if (b2 == 3000) {
                    jSONObject.put("hijack", 2);
                } else if (b2 == 3001) {
                    jSONObject.put("hijack", 0);
                } else {
                    jSONObject.put("hijack", 1);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            return jSONObject;
        }
        return (JSONObject) invokeLLI.objValue;
    }

    public void h(long j2) {
        c.e.b a2;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048583, this, j2) == null) {
            try {
                c.p.a.b.a.c.b u = c.g.e().u(j2);
                if (u != null && !h.r.C(u) && !u.N.get()) {
                    Pair<c.e.b, Integer> e2 = c.e.b().e(u);
                    if (e2 != null) {
                        a2 = (c.e.b) e2.first;
                        i2 = ((Integer) e2.second).intValue();
                    } else {
                        a2 = c.e.b().a(u);
                        i2 = -1;
                    }
                    if (a2 == null) {
                        return;
                    }
                    c.e.b().g(a2.f34639a);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("installed_app_name", a2.f34642d);
                    jSONObject.put("installed_pkg_name", a2.f34639a);
                    if (i2 != -1) {
                        jSONObject.put("error_code", i2);
                        h.l.d(jSONObject, u.s());
                        e.c.a().w("install_finish_hijack", jSONObject, u);
                        return;
                    }
                    e.c.a().w("install_finish_may_hijack", jSONObject, u);
                }
            } catch (Throwable th) {
                f.e.b().a(th, "trySendInstallFinishHijack");
            }
        }
    }

    public void i(long j2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Long.valueOf(j2), Integer.valueOf(i2)}) == null) {
            long c2 = c.p.a.e.b.j.a.d(i2).c("check_install_finish_hijack_delay_time", 900000L);
            if (c2 < 0) {
                return;
            }
            c.p.a.d.e.a().c(new b(this, j2), Math.max(c2, 300000L));
        }
    }

    public void j(c.p.a.b.a.c.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bVar) == null) {
            c.p.a.d.e.a().b(new g(this, bVar));
        }
    }

    public void m(DownloadInfo downloadInfo, long j2, long j3, long j4, long j5, long j6, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{downloadInfo, Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(j5), Long.valueOf(j6), Boolean.valueOf(z)}) == null) {
            c.p.a.b.a.c.b c2 = c.g.e().c(downloadInfo);
            if (c2 == null) {
                f.e.b().d("trySendClearSpaceEvent nativeModel null");
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.putOpt("space_before", Double.valueOf(j2 / 1048576.0d));
                jSONObject.putOpt("space_cleaned", Double.valueOf((j3 - j2) / 1048576.0d));
                jSONObject.putOpt("clean_up_time_cost", Long.valueOf(j5));
                jSONObject.putOpt("is_download_restarted", Integer.valueOf(z ? 1 : 0));
                jSONObject.putOpt("byte_required", Long.valueOf(j4));
                jSONObject.putOpt("byte_required_after", Double.valueOf((j4 - j3) / 1048576.0d));
                jSONObject.putOpt("clear_sleep_time", Long.valueOf(j6));
                h.l.g(downloadInfo, jSONObject);
                e.c.a().r("cleanup", jSONObject, c2);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void o(DownloadInfo downloadInfo, c.p.a.b.a.c.b bVar, int i2) {
        long max;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(1048587, this, downloadInfo, bVar, i2) == null) || downloadInfo == null || bVar == null) {
            return;
        }
        z();
        long currentTimeMillis = System.currentTimeMillis();
        bVar.m0(currentTimeMillis);
        bVar.G0(h.r.f(Environment.getDataDirectory(), -1L));
        if (i2 != 2000) {
            max = 2000;
        } else {
            long c2 = c.p.a.e.b.j.a.d(downloadInfo.getId()).c("check_install_failed_delay_time", AppConfig.TIMESTAMP_AVAILABLE_DURATION);
            if (c2 < 0) {
                return;
            }
            max = Math.max(c2, 30000L);
        }
        long j2 = max;
        f fVar = new f(bVar.b(), downloadInfo.getId(), currentTimeMillis, i2, null);
        c.p.a.d.e.a().c(fVar, j2);
        this.f34568f = fVar;
        c.j.b().c(bVar);
    }

    @WorkerThread
    public synchronized void p(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            synchronized (this) {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                if (!h.r.r()) {
                    c.p.a.b.a.c.b d2 = c.g.e().d(str);
                    if (d2 == null) {
                        c.e.b().c(str);
                        return;
                    }
                    c.p.a.d.b.g a2 = c.p.a.d.g.b().a(d2.a());
                    if (a2 != null) {
                        a2.F();
                    }
                    if (d2.N.get()) {
                        return;
                    }
                    if (c.p.a.e.b.j.a.d(d2.s()).m("notification_opt_2") == 1) {
                        c.p.a.e.b.p.b.a().m(d2.s());
                    }
                    new c.e().a(d2, new C1521a(this, d2, str), h.k.c(d2).b("try_applink_delay_after_installed", 0));
                    d.k.a().m(d2);
                    q(str, d2);
                    c.p.a.d.b.a.a.a().j(str);
                    DownloadInfo e2 = e(c.p.a.e.b.g.a.H(l.a()).p("application/vnd.android.package-archive"), str);
                    if (e2 != null) {
                        if (c.p.a.e.b.j.a.d(e2.getId()).m("no_hide_notification") != 1) {
                            c.p.a.e.b.p.b.a().b(e2.getId());
                        }
                        c.p.a.d.g.b().p(e2, str);
                        d.e.c(e2);
                    } else {
                        c.p.a.d.g.b().p(null, str);
                    }
                    return;
                }
                throw new RuntimeException("handleAppInstalled in main thread.");
            }
        }
    }

    public void q(String str, c.p.a.b.a.c.b bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048589, this, str, bVar) == null) && bVar != null && h.r.C(bVar) && bVar.N.compareAndSet(false, true)) {
            e.c.a().p(bVar.j(), "install_finish", f(bVar, str, bVar.H() != 4 ? 3 : 4), bVar);
            c.j.b().c(bVar);
        }
    }

    @WorkerThread
    public final void r(@NonNull ConcurrentHashMap<Long, c.p.a.b.a.c.b> concurrentHashMap, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048590, this, concurrentHashMap, i2) == null) {
            ArrayList arrayList = new ArrayList();
            long currentTimeMillis = System.currentTimeMillis();
            for (c.p.a.b.a.c.b bVar : concurrentHashMap.values()) {
                if (bVar.N.get()) {
                    if (currentTimeMillis - bVar.E() >= c.p.a.e.b.j.a.d(bVar.s()).b("start_event_expire_hours", 168) * 60 * 60 * 1000) {
                        arrayList.add(Long.valueOf(bVar.b()));
                    }
                } else if (bVar.D() == 1) {
                    if (y(bVar) <= 0 && currentTimeMillis - bVar.E() >= c.p.a.e.b.j.a.d(bVar.s()).b("start_event_expire_hours", 168) * 60 * 60 * 1000) {
                        arrayList.add(Long.valueOf(bVar.b()));
                    }
                } else if (bVar.D() == 2) {
                    if (!bVar.V()) {
                        if (h.r.C(bVar)) {
                            if (bVar.H() == 4) {
                                i2 = bVar.H();
                            }
                            e.c.a().s(f(bVar, bVar.e(), i2), bVar);
                            arrayList.add(Long.valueOf(bVar.b()));
                            d.e.b(bVar);
                        } else if (currentTimeMillis - bVar.E() >= c.p.a.e.b.j.a.d(bVar.s()).b("finish_event_expire_hours", 168) * 60 * 60 * 1000) {
                            arrayList.add(Long.valueOf(bVar.b()));
                        } else if (TextUtils.isEmpty(bVar.e())) {
                            arrayList.add(Long.valueOf(bVar.b()));
                        }
                    }
                } else {
                    arrayList.add(Long.valueOf(bVar.b()));
                }
            }
            c.g.e().k(arrayList);
        }
    }

    public final JSONObject s(@NonNull DownloadInfo downloadInfo, c.p.a.e.a.b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, downloadInfo, bVar)) == null) {
            c.p.a.b.a.c.b c2 = c.g.e().c(downloadInfo);
            if (c2 == null) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            bVar.c(jSONObject);
            try {
                jSONObject.put("download_id", downloadInfo.getId());
                jSONObject.put("name", downloadInfo.getName());
            } catch (Throwable th) {
                th.printStackTrace();
            }
            h.l.d(jSONObject, downloadInfo.getId());
            e.c.a().p("embeded_ad", "ah_result", jSONObject, c2);
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }

    public void v(DownloadInfo downloadInfo, c.p.a.b.a.c.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048592, this, downloadInfo, bVar) == null) || downloadInfo == null || bVar == null || c.p.a.e.b.j.a.d(downloadInfo.getId()).b("install_finish_check_ttmd5", 1) == 0) {
            return;
        }
        String targetFilePath = downloadInfo.getTargetFilePath();
        if (TextUtils.isEmpty(targetFilePath)) {
            return;
        }
        c.p.a.d.e.a().f(new c(this, targetFilePath, bVar));
    }

    @WorkerThread
    public final void x(c.p.a.b.a.c.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, bVar) == null) {
            SystemClock.sleep(20000L);
            int i2 = 15;
            while (i2 > 0) {
                if (h.r.C(bVar)) {
                    p(bVar.e());
                    return;
                }
                i2--;
                if (i2 == 0) {
                    return;
                }
                SystemClock.sleep(20000L);
            }
        }
    }

    public final int y(c.p.a.b.a.c.b bVar) {
        InterceptResult invokeL;
        int realStatus;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, bVar)) == null) {
            double a2 = c.p.a.e.b.j.a.d(bVar.s()).a("download_failed_finally_hours", 48.0d);
            if (a2 <= 0.0d) {
                return -1;
            }
            if (System.currentTimeMillis() - bVar.E() < a2 * 60.0d * 60.0d * 1000.0d) {
                return 1;
            }
            if (bVar.O.get()) {
                return 0;
            }
            DownloadInfo f2 = c.p.a.e.b.g.a.H(l.a()).f(bVar.s());
            if (f2 == null || (realStatus = f2.getRealStatus()) == -3 || realStatus == -4) {
                return -1;
            }
            if (!c.p.a.e.b.d.a.b(realStatus) && bVar.O.compareAndSet(false, true)) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    g(jSONObject, f2);
                    jSONObject.putOpt("download_status", Integer.valueOf(realStatus));
                    jSONObject.putOpt("fail_status", Integer.valueOf(bVar.B()));
                    jSONObject.putOpt("fail_msg", bVar.C());
                    jSONObject.put("download_failed_times", bVar.k1());
                    if (f2.getTotalBytes() > 0) {
                        jSONObject.put("download_percent", f2.getCurBytes() / f2.getTotalBytes());
                    }
                    jSONObject.put("is_update_download", bVar.S() ? 1 : 2);
                    e.c.a().p(bVar.j(), "download_failed_finally", jSONObject, bVar);
                    c.j.b().c(bVar);
                    return 0;
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            return 1;
        }
        return invokeL.intValue;
    }

    public synchronized void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            synchronized (this) {
                f fVar = this.f34568f;
                if (fVar != null) {
                    fVar.d();
                    this.f34568f = null;
                }
            }
        }
    }

    @Override // c.p.a.e.a.c.e
    public void a(DownloadInfo downloadInfo, c.p.a.e.a.b bVar) {
        JSONObject s;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadInfo, bVar) == null) || downloadInfo == null || bVar == null) {
            return;
        }
        JSONArray v = c.p.a.e.b.j.a.d(downloadInfo.getId()).v("ah_report_config");
        if (bVar.f34938b != 0) {
            downloadInfo.getTempCacheData().remove("intent");
        }
        if (v == null || (s = s(downloadInfo, bVar)) == null) {
            return;
        }
        downloadInfo.getTempCacheData().put("ah_ext_json", s);
    }

    @Override // c.p.a.e.b.f.k
    public void a(@Nullable DownloadInfo downloadInfo, @Nullable String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, downloadInfo, str) == null) {
            if (downloadInfo == null) {
                f.e.b().d("info is null");
            } else if ((c.p.a.e.b.j.a.f(downloadInfo).m("check_applink_mode") & 2) != 0) {
                c.h.d().g(new d(this, downloadInfo, (JSONObject) downloadInfo.getTempCacheData().get("ah_ext_json")));
            }
        }
    }

    @Override // c.p.a.e.b.a.a.b
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            c.p.a.e.b.c.a.g(f34565g, "onAppForeground()");
            z();
            a(5);
        }
    }
}
