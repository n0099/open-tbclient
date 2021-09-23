package c.p.a.d.b;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.WorkerThread;
import androidx.core.view.InputDeviceCompat;
import c.p.a.d.b.c;
import c.p.a.d.c;
import c.p.a.d.e;
import c.p.a.d.h;
import c.p.a.e.b.f.t;
import c.p.a.e.b.f.u;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.livesdk.sdk.service.IMLikeRequest;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static volatile d f34664b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ConcurrentHashMap<Long, Runnable> f34665a;

    /* loaded from: classes4.dex */
    public class a implements c.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f34666a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f34667b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.p.a.a.a.d.d f34668c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d f34669d;

        public a(d dVar, g gVar, int i2, c.p.a.a.a.d.d dVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, gVar, Integer.valueOf(i2), dVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f34669d = dVar;
            this.f34666a = gVar;
            this.f34667b = i2;
            this.f34668c = dVar2;
        }

        @Override // c.p.a.d.c.g
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.f34669d.d(this.f34666a, z, this.f34667b, this.f34668c);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements u {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f34670a;

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
                }
            }
        }

        @Override // c.p.a.e.b.f.u
        public boolean a(long j2, long j3, t tVar) {
            InterceptResult invokeCommon;
            long j4;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), tVar})) == null) {
                c.p.a.e.b.j.a d2 = c.p.a.e.b.j.a.d(this.f34670a);
                if (e(d2)) {
                    long currentTimeMillis = System.currentTimeMillis();
                    e.a().h();
                    long d3 = h.r.d(0L);
                    b();
                    long d4 = h.r.d(0L);
                    long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                    if (d4 < j3) {
                        long f2 = f(d2);
                        if (f2 > 0) {
                            d4 = h.r.d(0L);
                        }
                        j4 = f2;
                    } else {
                        j4 = 0;
                    }
                    h.q.c("AppDownloadDiskSpaceHandler", "cleanUpDisk, byteRequired = " + j3 + ", byteAvailableAfter = " + d4 + ", cleaned = " + (d4 - d3), null);
                    d(d3, d4, j3, currentTimeMillis2, j4);
                    if (d4 < j3) {
                        return false;
                    }
                    if (tVar != null) {
                        tVar.a();
                        return true;
                    }
                    return true;
                }
                return false;
            }
            return invokeCommon.booleanValue;
        }

        public final void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                c.p.a.a.a.c.e B = l.B();
                if (B != null) {
                    B.a();
                }
                C1525d.a();
                C1525d.e();
            }
        }

        public void c(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
                this.f34670a = i2;
            }
        }

        public final void d(long j2, long j3, long j4, long j5, long j6) {
            DownloadInfo f2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(j5), Long.valueOf(j6)}) == null) || (f2 = c.p.a.e.b.g.a.H(l.a()).f(this.f34670a)) == null) {
                return;
            }
            try {
                c.p.a.d.a.d().m(f2, j2, j3, j4, j5, j6, j3 > j4);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        public final boolean e(c.p.a.e.b.j.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, aVar)) == null) {
                if (aVar.b("clear_space_use_disk_handler", 0) != 1) {
                    return false;
                }
                return System.currentTimeMillis() - e.a().g() >= aVar.c("clear_space_min_time_interval", 600000L);
            }
            return invokeL.booleanValue;
        }

        public final long f(c.p.a.e.b.j.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, aVar)) == null) {
                long c2 = aVar.c("clear_space_sleep_time", 0L);
                if (c2 <= 0) {
                    return 0L;
                }
                if (c2 > 5000) {
                    c2 = 5000;
                }
                h.q.c("AppDownloadDiskSpaceHandler", "waiting for space clear, sleepTime = " + c2, null);
                try {
                    Thread.sleep(c2);
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
                h.q.c("AppDownloadDiskSpaceHandler", "waiting end!", null);
                return c2;
            }
            return invokeL.longValue;
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public DownloadInfo f34671e;

        /* loaded from: classes4.dex */
        public class a implements f {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a(c cVar, c.p.a.b.a.c.b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, bVar};
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

        public c(DownloadInfo downloadInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {downloadInfo};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f34671e = downloadInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.p.a.b.a.c.b c2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f34671e == null || (c2 = c.g.e().c(this.f34671e)) == null) {
                return;
            }
            e.c.a().m("cleanspace_task", c2);
            long longValue = Double.valueOf((h.k.a(this.f34671e.getId()) + 1.0d) * this.f34671e.getTotalBytes()).longValue() - this.f34671e.getCurBytes();
            long d2 = h.r.d(0L);
            if (l.y() != null) {
                l.y().e();
            }
            C1525d.a();
            C1525d.e();
            if (h.k.s(c2.s())) {
                C1525d.b(l.a());
            }
            long d3 = h.r.d(0L);
            if (d3 >= longValue) {
                c2.Y0("1");
                c.j.b().c(c2);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("quite_clean_size", Long.valueOf(d3 - d2));
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                e.c.a().r("cleanspace_download_after_quite_clean", jSONObject, c2);
                c.p.a.e.b.g.a.H(l.a()).y(this.f34671e.getId());
            } else if (l.y() != null) {
                c2.w0(false);
                e.a().e(c2.a(), new a(this, c2));
                if (l.y().a(this.f34671e.getId(), this.f34671e.getUrl(), true, longValue)) {
                    c2.A0(true);
                }
            } else {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.putOpt("show_dialog_result", 3);
                } catch (JSONException e3) {
                    e3.printStackTrace();
                }
                e.c.a().r("cleanspace_window_show", jSONObject2, c2);
            }
        }
    }

    /* renamed from: c.p.a.d.b.d$d  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1525d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static void a() {
            List<DownloadInfo> h2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(65536, null) == null) || (h2 = c.p.a.e.a.e.G().h(l.a())) == null || h2.size() <= 0) {
                return;
            }
            for (int i2 = 0; i2 < h2.size(); i2++) {
                DownloadInfo downloadInfo = h2.get(i2);
                File file = new File(downloadInfo.getTempPath(), downloadInfo.getTempName());
                long lastModified = file.lastModified();
                long b2 = c.p.a.e.b.j.a.d(downloadInfo.getId()).b("download_file_expire_hours", 0) * 3600000;
                if (b2 <= 0) {
                    b2 = 604800000;
                }
                if (file.isFile() && file.exists() && System.currentTimeMillis() - lastModified >= b2) {
                    c(file);
                    c.p.a.e.b.g.a.H(l.a()).d(downloadInfo.getId());
                }
            }
        }

        public static void b(Context context) {
            File externalCacheDir;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(65537, null, context) == null) || context == null || (externalCacheDir = context.getExternalCacheDir()) == null) {
                return;
            }
            try {
                d(externalCacheDir.getPath());
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:33:0x0005 */
        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:8:0x0017 */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:35:0x0034 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Type inference failed for: r0v2 */
        /* JADX WARN: Type inference failed for: r0v4, types: [java.io.FileOutputStream] */
        /* JADX WARN: Type inference failed for: r0v6 */
        /* JADX WARN: Type inference failed for: r1v3 */
        /* JADX WARN: Type inference failed for: r1v5, types: [java.io.FileOutputStream] */
        /* JADX WARN: Type inference failed for: r1v7, types: [java.io.FileOutputStream] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static void c(File file) {
            Interceptable interceptable;
            ?? r1;
            Exception e2;
            Interceptable interceptable2 = $ic;
            if (interceptable2 != null) {
                interceptable = interceptable2;
                if (interceptable.invokeL(65538, null, file) != null) {
                    return;
                }
            }
            ?? r0 = null;
            try {
                try {
                    r1 = new FileOutputStream(file);
                    try {
                        r1.write("1".getBytes());
                        r1.close();
                        interceptable = r1;
                    } catch (Exception e3) {
                        e2 = e3;
                        e2.printStackTrace();
                        interceptable = r1;
                        if (r1 != 0) {
                            try {
                                r1.close();
                                interceptable = r1;
                            } catch (Exception e4) {
                                e4.printStackTrace();
                                interceptable = r1;
                            }
                        }
                        file.delete();
                    }
                } catch (Throwable th) {
                    th = th;
                    r0 = interceptable;
                    if (r0 != null) {
                        try {
                            r0.close();
                        } catch (Exception e5) {
                            e5.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Exception e6) {
                r1 = 0;
                e2 = e6;
            } catch (Throwable th2) {
                th = th2;
                if (r0 != null) {
                }
                throw th;
            }
            file.delete();
        }

        public static void d(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65539, null, str) == null) {
                File file = new File(str);
                if (file.exists()) {
                    if (file.isFile()) {
                        file.delete();
                        return;
                    }
                    String[] list = file.list();
                    if (list == null) {
                        return;
                    }
                    for (String str2 : list) {
                        if (str2 != null) {
                            String str3 = str.endsWith(File.separator) ? str + str2 : str + File.separator + str2;
                            File file2 = new File(str3);
                            if (file2.isFile()) {
                                file2.delete();
                            }
                            if (file2.isDirectory()) {
                                d(str3);
                            }
                        }
                    }
                    file.delete();
                }
            }
        }

        public static void e() {
            List<DownloadInfo> p;
            DownloadInfo downloadInfo;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) || (p = c.p.a.e.b.g.a.H(l.a()).p("application/vnd.android.package-archive")) == null || p.isEmpty()) {
                return;
            }
            for (int i2 = 0; i2 < p.size(); i2++) {
                if (p.get(i2) != null) {
                    String str = downloadInfo.getSavePath() + File.separator + downloadInfo.getName();
                    File file = new File(str);
                    if (file.exists()) {
                        long currentTimeMillis = System.currentTimeMillis() - file.lastModified();
                        long b2 = c.p.a.e.b.j.a.d(downloadInfo.getId()).b("download_complete_file_expire_hours", 0) * 3600000;
                        if (b2 <= 0) {
                            b2 = 604800000;
                        }
                        boolean z = true;
                        if (currentTimeMillis < b2 && !h.r.H(l.a(), str)) {
                            z = false;
                        }
                        if (z) {
                            c(file);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: d  reason: collision with root package name */
        public static volatile e f34672d;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public long f34673a;

        /* renamed from: b  reason: collision with root package name */
        public ConcurrentHashMap<String, f> f34674b;

        /* renamed from: c  reason: collision with root package name */
        public HashMap<String, Integer> f34675c;

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
                    return;
                }
            }
            this.f34673a = 0L;
            this.f34674b = new ConcurrentHashMap<>();
            this.f34675c = new HashMap<>();
            new CopyOnWriteArrayList();
        }

        public static e a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
                if (f34672d == null) {
                    synchronized (e.class) {
                        if (f34672d == null) {
                            f34672d = new e();
                        }
                    }
                }
                return f34672d;
            }
            return (e) invokeV.objValue;
        }

        @WorkerThread
        public static void b(c.p.a.b.a.c.b bVar) {
            DownloadInfo f2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(65538, null, bVar) == null) || bVar == null || bVar.b() <= 0 || (f2 = c.p.a.e.b.g.a.H(l.a()).f(bVar.s())) == null) {
                return;
            }
            c(f2);
        }

        @WorkerThread
        public static void c(DownloadInfo downloadInfo) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(65539, null, downloadInfo) == null) || downloadInfo == null || c.p.a.e.b.j.a.d(downloadInfo.getId()).b("delete_file_after_install", 0) == 0) {
                return;
            }
            try {
                String str = downloadInfo.getSavePath() + File.separator + downloadInfo.getName();
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                File file = new File(str);
                if (file.isFile() && file.exists()) {
                    file.delete();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        public void d(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || TextUtils.isEmpty(str)) {
                return;
            }
            this.f34674b.remove(str);
        }

        public void e(String str, f fVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, fVar) == null) || TextUtils.isEmpty(str)) {
                return;
            }
            this.f34674b.put(str, fVar);
        }

        public int f(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                if (TextUtils.isEmpty(str)) {
                    return 0;
                }
                if (this.f34675c == null) {
                    this.f34675c = new HashMap<>();
                }
                if (this.f34675c.containsKey(str)) {
                    return this.f34675c.get(str).intValue();
                }
                return 0;
            }
            return invokeL.intValue;
        }

        public long g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f34673a : invokeV.longValue;
        }

        public void h() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.f34673a = System.currentTimeMillis();
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface f {
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-146363500, "Lc/p/a/d/b/d;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-146363500, "Lc/p/a/d/b/d;");
        }
    }

    public d() {
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
        this.f34665a = null;
        this.f34665a = new ConcurrentHashMap<>();
    }

    public static d a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f34664b == null) {
                synchronized (d.class) {
                    if (f34664b == null) {
                        f34664b = new d();
                    }
                }
            }
            return f34664b;
        }
        return (d) invokeV.objValue;
    }

    public static boolean e(DownloadInfo downloadInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, downloadInfo)) == null) ? downloadInfo == null || downloadInfo.getStatus() == 0 || downloadInfo.getStatus() == -4 : invokeL.booleanValue;
    }

    public final void b(long j2, boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j2), Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            e.c.a().f(j2, z, i2);
            if (z) {
                l.G().a(null, null, null, null, null, 3);
            }
        }
    }

    public void c(g gVar, int i2, c.p.a.a.a.d.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gVar, i2, dVar) == null) {
            c.h.d().f(new a(this, gVar, i2, dVar), f());
        }
    }

    public void d(g gVar, boolean z, int i2, c.p.a.a.a.d.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{gVar, Boolean.valueOf(z), Integer.valueOf(i2), dVar}) == null) {
            if (dVar instanceof c.p.a.b.a.a.c) {
                ((c.p.a.b.a.a.c) dVar).b(3);
            }
            long d2 = dVar.d();
            if (i2 == 4) {
                if (!z) {
                    b(d2, false, 2);
                    gVar.u(false);
                    return;
                }
                b(d2, true, 2);
            } else if (i2 == 5) {
                if (!z) {
                    b(d2, false, 1);
                    gVar.w(false);
                    return;
                }
                b(d2, true, 1);
            } else if (i2 != 7) {
            } else {
                Runnable remove = this.f34665a.remove(Long.valueOf(d2));
                if (z) {
                    e.c.a().c(d2, 1);
                    b(d2, true, 1);
                    return;
                }
                if (remove != null) {
                    c.p.a.d.g.b().n().post(remove);
                }
                b(d2, false, 1);
            }
        }
    }

    public long f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? l.v().optLong("quick_app_check_internal", IMLikeRequest.TIME_INTERVAL) : invokeV.longValue;
    }
}
