package c.p.a.d.b;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.p.a.a.a.c.t;
import c.p.a.a.a.c.v;
import c.p.a.a.a.d.h;
import c.p.a.d.b.c;
import c.p.a.d.b.f;
import c.p.a.d.b.i;
import c.p.a.d.d;
import c.p.a.d.e;
import c.p.a.d.f;
import c.p.a.d.h;
import c.p.a.e.a.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.socialbase.appdownloader.DownloadHandlerService;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class g implements c.p.a.d.b.h, h.s.a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String t = "g";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final h.s f34686a;

    /* renamed from: b  reason: collision with root package name */
    public c.p.a.d.b.i f34687b;

    /* renamed from: c  reason: collision with root package name */
    public c.p.a.d.b.f f34688c;

    /* renamed from: d  reason: collision with root package name */
    public WeakReference<Context> f34689d;

    /* renamed from: e  reason: collision with root package name */
    public final Map<Integer, Object> f34690e;

    /* renamed from: f  reason: collision with root package name */
    public c.p.a.a.a.f.e f34691f;

    /* renamed from: g  reason: collision with root package name */
    public DownloadInfo f34692g;

    /* renamed from: h  reason: collision with root package name */
    public h f34693h;

    /* renamed from: i  reason: collision with root package name */
    public final c.p.a.e.b.f.c f34694i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f34695j;
    public long k;
    public long l;
    public c.p.a.a.a.d.d m;
    public c.p.a.a.a.d.c n;
    public c.p.a.a.a.d.b o;
    public SoftReference<v> p;
    public boolean q;
    public final boolean r;
    public SoftReference<c.p.a.a.a.c.n> s;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f34696e;

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
            this.f34696e = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                for (c.p.a.a.a.d.e eVar : c.p.a.d.b.i.d(this.f34696e.f34690e)) {
                    eVar.b(this.f34696e.U());
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f34697a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f34698b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ g f34699c;

        public b(g gVar, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f34699c = gVar;
            this.f34697a = i2;
            this.f34698b = i3;
        }

        @Override // c.p.a.d.b.g.f
        public void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f34699c.f34688c.n()) {
                return;
            }
            g gVar = this.f34699c;
            gVar.n(this.f34697a, this.f34698b, gVar.f34692g);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements f.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f34700a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.p.a.b.a.c.b f34701b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f34702c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f34703d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f34704e;

        public c(g gVar, boolean z, c.p.a.b.a.c.b bVar, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, Boolean.valueOf(z), bVar, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f34704e = gVar;
            this.f34700a = z;
            this.f34701b = bVar;
            this.f34702c = i2;
            this.f34703d = i3;
        }

        @Override // c.p.a.d.b.f.i
        public void a(c.p.a.b.a.c.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
                this.f34704e.f34687b.k(this.f34704e.f34692g, this.f34700a);
                if (c.p.a.e.b.l.f.g0(l.a()) && this.f34704e.f34692g.isPauseReserveOnWifi()) {
                    this.f34704e.f34692g.stopPauseReserveOnWifi();
                    e.c.a().v("pause_reserve_wifi_cancel_on_wifi", this.f34701b);
                    return;
                }
                g gVar = this.f34704e;
                gVar.n(this.f34702c, this.f34703d, gVar.f34692g);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f34707a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ g f34708b;

        public e(g gVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f34708b = gVar;
            this.f34707a = z;
        }

        @Override // c.p.a.d.b.g.f
        public void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f34708b.f34688c.n()) {
                return;
            }
            this.f34708b.I(this.f34707a);
        }
    }

    /* loaded from: classes4.dex */
    public interface f {
        void a();
    }

    /* renamed from: c.p.a.d.b.g$g  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC1530g {
        void a(long j2);
    }

    /* loaded from: classes4.dex */
    public class h extends AsyncTask<String, Void, DownloadInfo> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f34709a;

        public h(g gVar) {
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
            this.f34709a = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public DownloadInfo doInBackground(String... strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, strArr)) == null) {
                DownloadInfo downloadInfo = null;
                if (strArr != null) {
                    if (strArr.length < 1 || !TextUtils.isEmpty(strArr[0])) {
                        String str = strArr[0];
                        if (this.f34709a.m != null && !TextUtils.isEmpty(this.f34709a.m.n())) {
                            downloadInfo = c.p.a.e.b.g.a.H(l.a()).g(str, this.f34709a.m.n());
                        }
                        return downloadInfo == null ? c.p.a.e.a.e.G().e(l.a(), str) : downloadInfo;
                    }
                    return null;
                }
                return null;
            }
            return (DownloadInfo) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.AsyncTask
        /* renamed from: b */
        public void onPostExecute(DownloadInfo downloadInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadInfo) == null) {
                super.onPostExecute(downloadInfo);
                if (isCancelled() || this.f34709a.m == null) {
                    return;
                }
                try {
                    c.d j2 = h.r.j(this.f34709a.m.v(), this.f34709a.m.r(), this.f34709a.m.s());
                    c.i.a().b(this.f34709a.m.r(), j2.c(), c.g.e().c(downloadInfo));
                    boolean b2 = j2.b();
                    if (downloadInfo != null && downloadInfo.getId() != 0 && (b2 || !c.p.a.e.b.g.a.H(l.a()).s(downloadInfo))) {
                        c.p.a.e.b.g.a.H(l.a()).x(downloadInfo.getId());
                        if (this.f34709a.f34692g == null || this.f34709a.f34692g.getStatus() != -4) {
                            this.f34709a.f34692g = downloadInfo;
                            if (this.f34709a.r) {
                                c.p.a.e.b.g.a.H(l.a()).E(this.f34709a.f34692g.getId(), this.f34709a.f34694i, false);
                            } else {
                                c.p.a.e.b.g.a.H(l.a()).D(this.f34709a.f34692g.getId(), this.f34709a.f34694i);
                            }
                        } else {
                            this.f34709a.f34692g = null;
                        }
                        this.f34709a.f34687b.j(this.f34709a.f34692g, this.f34709a.U(), c.p.a.d.b.i.d(this.f34709a.f34690e));
                    } else {
                        if (downloadInfo != null && c.p.a.e.b.g.a.H(l.a()).s(downloadInfo)) {
                            c.p.a.e.b.p.b.a().m(downloadInfo.getId());
                            this.f34709a.f34692g = null;
                        }
                        if (this.f34709a.f34692g != null) {
                            c.p.a.e.b.g.a.H(l.a()).x(this.f34709a.f34692g.getId());
                            if (this.f34709a.r) {
                                c.p.a.e.b.g.a.H(this.f34709a.O()).E(this.f34709a.f34692g.getId(), this.f34709a.f34694i, false);
                            } else {
                                c.p.a.e.b.g.a.H(this.f34709a.O()).D(this.f34709a.f34692g.getId(), this.f34709a.f34694i);
                            }
                        }
                        if (!b2) {
                            for (c.p.a.a.a.d.e eVar : c.p.a.d.b.i.d(this.f34709a.f34690e)) {
                                eVar.a();
                            }
                            this.f34709a.f34692g = null;
                        } else {
                            this.f34709a.f34692g = new DownloadInfo.b(this.f34709a.m.a()).E();
                            this.f34709a.f34692g.setStatus(-3);
                            this.f34709a.f34687b.j(this.f34709a.f34692g, this.f34709a.U(), c.p.a.d.b.i.d(this.f34709a.f34690e));
                        }
                    }
                    this.f34709a.f34687b.t(this.f34709a.f34692g);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }

        public /* synthetic */ h(g gVar, a aVar) {
            this(gVar);
        }
    }

    /* loaded from: classes4.dex */
    public class i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static void a(DownloadInfo downloadInfo, long j2, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(65536, null, new Object[]{downloadInfo, Long.valueOf(j2), str, str2}) == null) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-146363407, "Lc/p/a/d/b/g;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-146363407, "Lc/p/a/d/b/g;");
        }
    }

    public g() {
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
        this.f34686a = new h.s(Looper.getMainLooper(), this);
        this.f34690e = new ConcurrentHashMap();
        this.f34694i = new i.d(this.f34686a);
        this.l = -1L;
        this.m = null;
        this.n = null;
        this.o = null;
        this.f34687b = new c.p.a.d.b.i(this);
        this.f34688c = new c.p.a.d.b.f(this.f34686a);
        this.r = c.p.a.e.b.j.a.r().l("ttdownloader_callback_twice");
    }

    public final void A(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            if (h.k.g(this.m).m("notification_opt_2") == 1 && this.f34692g != null) {
                c.p.a.e.b.p.b.a().m(this.f34692g.getId());
            }
            C(z);
        }
    }

    public final void C(boolean z) {
        c.p.a.a.a.d.d dVar;
        c.p.a.a.a.d.b bVar;
        c.p.a.a.a.d.b bVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            h.q.b(t, "performButtonClickWithNewDownloader", null);
            if (S()) {
                c.f v = c.g.e().v(this.l);
                DownloadInfo downloadInfo = this.f34692g;
                if (downloadInfo != null && downloadInfo.getStatus() != 0) {
                    r(z, true);
                    return;
                } else if (this.q) {
                    if (this.m.t() && this.s != null) {
                        if (V() && (bVar2 = v.f34624d) != null && bVar2.f()) {
                            r(z, true);
                            return;
                        }
                        return;
                    }
                    r(z, true);
                    return;
                } else if (this.m.t() && (bVar = v.f34624d) != null && bVar.e() && v.f34622b != null && c.p.a.d.b.e.a.a().e(v.f34622b) && c.p.a.d.b.e.a.a().f(v)) {
                    return;
                } else {
                    r(z, true);
                    return;
                }
            }
            String str = t;
            h.q.b(str, "performButtonClickWithNewDownloader continue download, status:" + this.f34692g.getStatus(), null);
            DownloadInfo downloadInfo2 = this.f34692g;
            if (downloadInfo2 != null && (dVar = this.m) != null) {
                downloadInfo2.setOnlyWifi(dVar.m());
            }
            int status = this.f34692g.getStatus();
            int id = this.f34692g.getId();
            c.p.a.b.a.c.b c2 = c.g.e().c(this.f34692g);
            if (status != -2 && status != -1) {
                if (n.c(status)) {
                    if (this.m.L()) {
                        this.f34688c.m(true);
                        d.k.a().g(c.g.e().u(this.l));
                        f.l.a().b(c2, status, new c(this, z, c2, id, status));
                        return;
                    }
                    return;
                }
                this.f34687b.k(this.f34692g, z);
                n(id, status, this.f34692g);
                return;
            }
            this.f34687b.k(this.f34692g, z);
            if (c2 != null) {
                c2.K0(System.currentTimeMillis());
                c2.O0(this.f34692g.getCurBytes());
            }
            this.f34692g.setDownloadFromReserveWifi(false);
            this.f34688c.j(new c.f(this.l, this.m, P(), Q()));
            this.f34688c.f(id, this.f34692g.getCurBytes(), this.f34692g.getTotalBytes(), new b(this, id, status));
        }
    }

    public boolean D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? l.v().optInt("quick_app_enable_switch", 0) == 0 && this.m.B() != null && !TextUtils.isEmpty(this.m.B().a()) && c.p.a.d.b.d.e(this.f34692g) && h.r.t(O(), new Intent("android.intent.action.VIEW", Uri.parse(this.m.B().a()))) : invokeV.booleanValue;
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f34686a.post(new a(this));
        }
    }

    public final void G(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.f34688c.j(new c.f(this.l, this.m, P(), Q()));
            this.f34688c.f(0, 0L, 0L, new e(this, z));
        }
    }

    public void H() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.f34690e.size() == 0) {
            return;
        }
        for (c.p.a.a.a.d.e eVar : c.p.a.d.b.i.d(this.f34690e)) {
            eVar.a();
        }
        DownloadInfo downloadInfo = this.f34692g;
        if (downloadInfo != null) {
            downloadInfo.setStatus(-4);
        }
    }

    public final void I(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            for (c.p.a.a.a.d.e eVar : c.p.a.d.b.i.d(this.f34690e)) {
                eVar.a(this.m, Q());
            }
            int a2 = this.f34687b.a(l.a(), this.f34694i);
            String str = t;
            h.q.b(str, "beginDownloadWithNewDownloader id:" + a2, null);
            if (a2 != 0) {
                if (this.f34692g != null && !c.p.a.e.b.j.a.r().l("fix_click_start")) {
                    this.f34687b.k(this.f34692g, false);
                } else if (z) {
                    this.f34687b.e();
                }
            } else {
                DownloadInfo E = new DownloadInfo.b(this.m.a()).E();
                E.setStatus(-1);
                q(E);
                e.c.a().e(this.l, new BaseException(2, "start download failed, id=0"));
                f.e.b().g("beginDownloadWithNewDownloader");
            }
            if (this.f34687b.n(x())) {
                String str2 = t;
                h.q.b(str2, "beginDownloadWithNewDownloader onItemClick id:" + a2, null);
                N();
            }
        }
    }

    public final void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            SoftReference<v> softReference = this.p;
            if (softReference != null && softReference.get() != null) {
                this.p.get().a(this.m, P(), Q());
                this.p = null;
                return;
            }
            l.o().a(O(), this.m, Q(), P());
        }
    }

    public final Context O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            WeakReference<Context> weakReference = this.f34689d;
            if (weakReference != null && weakReference.get() != null) {
                return this.f34689d.get();
            }
            return l.a();
        }
        return (Context) invokeV.objValue;
    }

    @NonNull
    public final c.p.a.a.a.d.c P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            c.p.a.a.a.d.c cVar = this.n;
            return cVar == null ? new h.b().a() : cVar;
        }
        return (c.p.a.a.a.d.c) invokeV.objValue;
    }

    @NonNull
    public final c.p.a.a.a.d.b Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (this.o == null) {
                this.o = new c.p.a.a.a.d.g();
            }
            return this.o;
        }
        return (c.p.a.a.a.d.b) invokeV.objValue;
    }

    public final void R() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            h.q.b(t, "performItemClickWithNewDownloader", null);
            if (this.f34687b.w(this.f34692g)) {
                h.q.b(t, "performItemClickWithNewDownloader ButtonClick", null);
                C(false);
                return;
            }
            h.q.b(t, "performItemClickWithNewDownloader onItemClick", null);
            N();
        }
    }

    public final boolean S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (c.p.a.e.b.j.a.r().l("fix_click_start")) {
                DownloadInfo downloadInfo = this.f34692g;
                if (downloadInfo == null) {
                    return true;
                }
                if ((downloadInfo.getStatus() == -3 && this.f34692g.getCurBytes() <= 0) || this.f34692g.getStatus() == 0 || this.f34692g.getStatus() == -4) {
                    return true;
                }
                return c.p.a.e.b.l.f.I(this.f34692g.getStatus(), this.f34692g.getSavePath(), this.f34692g.getName());
            }
            DownloadInfo downloadInfo2 = this.f34692g;
            if (downloadInfo2 == null) {
                return true;
            }
            return !(downloadInfo2.getStatus() == -3 || c.p.a.e.b.g.a.H(l.a()).a(this.f34692g.getId())) || this.f34692g.getStatus() == 0;
        }
        return invokeV.booleanValue;
    }

    public final void T() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            h hVar = this.f34693h;
            if (hVar != null && hVar.getStatus() != AsyncTask.Status.FINISHED) {
                this.f34693h.cancel(true);
            }
            h hVar2 = new h(this, null);
            this.f34693h = hVar2;
            h.C1540h.a(hVar2, this.m.a(), this.m.v());
        }
    }

    public final c.p.a.a.a.f.e U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (this.f34691f == null) {
                this.f34691f = new c.p.a.a.a.f.e();
            }
            return this.f34691f;
        }
        return (c.p.a.a.a.f.e) invokeV.objValue;
    }

    public final boolean V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            SoftReference<c.p.a.a.a.c.n> softReference = this.s;
            if (softReference != null && softReference.get() != null) {
                this.s.get().a(true);
                this.s = null;
                return true;
            }
            f.e.b().g("mDownloadButtonClickListener has recycled");
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.p.a.d.b.h
    public /* synthetic */ c.p.a.d.b.h a(c.p.a.a.a.d.b bVar) {
        i(bVar);
        return this;
    }

    @Override // c.p.a.d.b.h
    public /* synthetic */ c.p.a.d.b.h b(Context context) {
        h(context);
        return this;
    }

    @Override // c.p.a.d.b.h
    public /* synthetic */ c.p.a.d.b.h c(c.p.a.a.a.d.d dVar) {
        k(dVar);
        return this;
    }

    @Override // c.p.a.d.b.h
    public c.p.a.d.b.h d(v vVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, vVar)) == null) {
            if (vVar == null) {
                this.p = null;
            } else {
                this.p = new SoftReference<>(vVar);
            }
            return this;
        }
        return (c.p.a.d.b.h) invokeL.objValue;
    }

    @Override // c.p.a.d.b.h
    public c.p.a.d.b.h e(c.p.a.a.a.c.n nVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, nVar)) == null) {
            if (nVar == null) {
                this.s = null;
            } else {
                this.s = new SoftReference<>(nVar);
            }
            return this;
        }
        return (c.p.a.d.b.h) invokeL.objValue;
    }

    @Override // c.p.a.d.b.h
    public /* synthetic */ c.p.a.d.b.h f(int i2, c.p.a.a.a.d.e eVar) {
        g(i2, eVar);
        return this;
    }

    public g g(int i2, c.p.a.a.a.d.e eVar) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048607, this, i2, eVar)) == null) {
            if (eVar != null) {
                if (l.v().optInt("back_use_softref_listener") == 1) {
                    this.f34690e.put(Integer.valueOf(i2), eVar);
                } else {
                    this.f34690e.put(Integer.valueOf(i2), new SoftReference(eVar));
                }
            }
            return this;
        }
        return (g) invokeIL.objValue;
    }

    public g h(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048608, this, context)) == null) {
            if (context != null) {
                this.f34689d = new WeakReference<>(context);
            }
            l.n(context);
            return this;
        }
        return (g) invokeL.objValue;
    }

    public g i(c.p.a.a.a.d.b bVar) {
        InterceptResult invokeL;
        JSONObject z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048610, this, bVar)) == null) {
            this.o = bVar;
            if (h.k.g(this.m).m("force_auto_open") == 1) {
                Q().b(1);
            }
            if (c.p.a.e.b.j.a.r().l("fix_show_dialog") && (z = this.m.z()) != null && z.optInt("subprocess") > 0) {
                Q().a(false);
            }
            c.g.e().g(this.l, Q());
            return this;
        }
        return (g) invokeL.objValue;
    }

    public g j(c.p.a.a.a.d.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048611, this, cVar)) == null) {
            this.n = cVar;
            this.q = P().k() == 0;
            c.g.e().h(this.l, P());
            return this;
        }
        return (g) invokeL.objValue;
    }

    public g k(c.p.a.a.a.d.d dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048612, this, dVar)) == null) {
            if (dVar != null) {
                if (dVar.t()) {
                    if (dVar.d() <= 0 || TextUtils.isEmpty(dVar.u())) {
                        f.e.b().d("setDownloadModel ad error");
                    }
                } else if (dVar.d() == 0 && (dVar instanceof c.p.a.b.a.a.c)) {
                    f.e.b().e(false, "setDownloadModel id=0");
                    if (c.p.a.e.b.j.a.r().l("fix_model_id")) {
                        ((c.p.a.b.a.a.c) dVar).d(dVar.a().hashCode());
                    }
                }
                c.g.e().i(dVar);
                this.l = dVar.d();
                this.m = dVar;
                if (j.f(dVar)) {
                    ((c.p.a.b.a.a.c) dVar).c(3L);
                    c.p.a.b.a.c.b u = c.g.e().u(this.l);
                    if (u != null && u.l() != 3) {
                        u.y0(3L);
                        c.j.b().c(u);
                    }
                }
            }
            return this;
        }
        return (g) invokeL.objValue;
    }

    public final void n(int i2, int i3, @NonNull DownloadInfo downloadInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048613, this, i2, i3, downloadInfo) == null) {
            if (c.p.a.e.b.j.a.r().l("fix_click_start")) {
                if (i3 != -3 && !c.p.a.e.b.g.f.c().B(i2)) {
                    r(false, false);
                    return;
                } else {
                    c.p.a.e.a.e.G().j(l.a(), i2, i3);
                    return;
                }
            }
            c.p.a.e.a.e.G().j(l.a(), i2, i3);
        }
    }

    public final void q(DownloadInfo downloadInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, downloadInfo) == null) {
            Message obtain = Message.obtain();
            obtain.what = 3;
            obtain.obj = downloadInfo;
            this.f34686a.sendMessage(obtain);
        }
    }

    public void r(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048615, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (z) {
                e.c.a().c(this.l, 2);
            }
            if (!h.p.e("android.permission.WRITE_EXTERNAL_STORAGE") && !Q().g()) {
                this.m.a(this.f34687b.p());
            }
            if (h.k.k(this.m) == 0) {
                h.q.b(t, "performButtonClickWithNewDownloader not start", null);
                this.f34687b.h(new d(this, z2));
                return;
            }
            G(z2);
        }
    }

    public void u(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048616, this, z) == null) {
            A(z);
        }
    }

    public void w(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048617, this, z) == null) {
            if (z) {
                e.c.a().c(this.l, 1);
            }
            R();
        }
    }

    public boolean x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            DownloadInfo downloadInfo = this.f34692g;
            return (downloadInfo == null || downloadInfo.getStatus() == 0) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final boolean y(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048619, this, i2)) == null) {
            if (D()) {
                int i3 = -1;
                String a2 = this.m.B().a();
                if (i2 == 1) {
                    i3 = 5;
                } else if (i2 == 2) {
                    i3 = 4;
                }
                c.p.a.a.a.d.d dVar = this.m;
                if (dVar instanceof c.p.a.b.a.a.c) {
                    ((c.p.a.b.a.a.c) dVar).b(3);
                }
                boolean h2 = h.o.h(l.a(), a2);
                if (h2) {
                    e.c.a().c(this.l, i2);
                    Message obtain = Message.obtain();
                    obtain.what = i3;
                    obtain.obj = Long.valueOf(this.m.d());
                    c.p.a.d.b.d.a().c(this, i3, this.m);
                } else {
                    e.c.a().f(this.l, false, 0);
                }
                return h2;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    /* loaded from: classes4.dex */
    public class d implements t {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f34705a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ g f34706b;

        public d(g gVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f34706b = gVar;
            this.f34705a = z;
        }

        @Override // c.p.a.a.a.c.t
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                h.q.b(g.t, "performButtonClickWithNewDownloader start download", null);
                this.f34706b.G(this.f34705a);
            }
        }

        @Override // c.p.a.a.a.c.t
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                h.q.b(g.t, "performButtonClickWithNewDownloader onDenied", null);
            }
        }
    }

    @Override // c.p.a.d.b.h
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.f34695j = true;
            c.g.e().h(this.l, P());
            c.g.e().g(this.l, Q());
            this.f34687b.f(this.l);
            T();
            if (l.v().optInt("enable_empty_listener", 1) == 1 && this.f34690e.get(Integer.MIN_VALUE) == null) {
                g(Integer.MIN_VALUE, new c.p.a.a.a.c.a());
            }
        }
    }

    @Override // c.p.a.d.b.h
    public /* synthetic */ c.p.a.d.b.h b(c.p.a.a.a.d.c cVar) {
        j(cVar);
        return this;
    }

    @Override // c.p.a.d.b.h
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.f34695j : invokeV.booleanValue;
    }

    @Override // c.p.a.d.b.h
    public long d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.k : invokeV.longValue;
    }

    @Override // c.p.a.d.b.h
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            c.g.e().w(this.l);
        }
    }

    @Override // c.p.a.d.b.h
    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i2) == null) {
            if (i2 != 1 && i2 != 2) {
                throw new IllegalArgumentException("error actionType");
            }
            this.f34687b.f(this.l);
            if (!c.g.e().v(this.l).y()) {
                f.e.b().d("handleDownload ModelBox !isStrictValid");
            }
            if (this.f34687b.m(O(), i2, this.q)) {
                return;
            }
            boolean y = y(i2);
            if (i2 == 1) {
                if (y) {
                    return;
                }
                String str = t;
                h.q.b(str, "handleDownload id:" + this.l + ",tryPerformItemClick:", null);
                w(true);
            } else if (i2 == 2 && !y) {
                String str2 = t;
                h.q.b(str2, "handleDownload id:" + this.l + ",tryPerformButtonClick:", null);
                u(true);
            }
        }
    }

    @Override // c.p.a.d.b.h
    public boolean a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048597, this, i2)) == null) {
            if (i2 == 0) {
                this.f34690e.clear();
            } else {
                this.f34690e.remove(Integer.valueOf(i2));
            }
            if (this.f34690e.isEmpty()) {
                this.f34695j = false;
                this.k = System.currentTimeMillis();
                if (this.f34692g != null) {
                    c.p.a.e.b.g.a.H(l.a()).x(this.f34692g.getId());
                }
                h hVar = this.f34693h;
                if (hVar != null && hVar.getStatus() != AsyncTask.Status.FINISHED) {
                    this.f34693h.cancel(true);
                }
                this.f34687b.i(this.f34692g);
                String str = t;
                StringBuilder sb = new StringBuilder();
                sb.append("onUnbind removeCallbacksAndMessages, downloadUrl:");
                DownloadInfo downloadInfo = this.f34692g;
                sb.append(downloadInfo == null ? "" : downloadInfo.getUrl());
                h.q.b(str, sb.toString(), null);
                this.f34686a.removeCallbacksAndMessages(null);
                this.f34691f = null;
                this.f34692g = null;
                return true;
            }
            if (this.f34690e.size() == 1 && this.f34690e.containsKey(Integer.MIN_VALUE)) {
                this.f34687b.s(this.f34692g);
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    @Override // c.p.a.d.b.h
    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048596, this, z) == null) || this.f34692g == null) {
            return;
        }
        if (z) {
            d.f u = c.p.a.e.a.e.G().u();
            if (u != null) {
                u.a(this.f34692g);
            }
            c.p.a.e.b.g.a.H(c.p.a.e.b.g.e.n()).c(this.f34692g.getId(), true);
            return;
        }
        Intent intent = new Intent(l.a(), DownloadHandlerService.class);
        intent.setAction("android.ss.intent.action.DOWNLOAD_DELETE");
        intent.putExtra("extra_click_download_ids", this.f34692g.getId());
        l.a().startService(intent);
    }

    @Override // c.p.a.d.b.h
    public c.p.a.d.b.h a(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048592, this, j2)) == null) {
            if (j2 != 0) {
                c.p.a.a.a.d.d a2 = c.g.e().a(j2);
                if (a2 != null) {
                    this.m = a2;
                    this.l = j2;
                    this.f34687b.f(j2);
                }
            } else {
                f.e.b().e(false, "setModelId");
            }
            return this;
        }
        return (c.p.a.d.b.h) invokeJ.objValue;
    }

    @Override // c.p.a.d.h.s.a
    public void a(Message message) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048595, this, message) == null) && message != null && this.f34695j && message.what == 3) {
            this.f34692g = (DownloadInfo) message.obj;
            this.f34687b.g(message, U(), this.f34690e);
        }
    }
}
