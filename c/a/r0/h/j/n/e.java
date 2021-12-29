package c.a.r0.h.j.n;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.a.k;
import c.a.r0.a.z2.q;
import c.a.r0.a.z2.w;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.manage.Download;
import com.baidu.down.manage.DownloadManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.game.ad.downloader.model.DownloadState;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.swan.game.guide.install.GameNowInstallAntiBlockingActivity;
import com.baidu.swan.game.guide.install.InstallActivity;
import com.baidu.tbadk.commonReceiver.PackageChangedReceiver;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.zip.ZipFile;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: k  reason: collision with root package name */
    public static final boolean f10869k;
    public static volatile e l;
    public static ExecutorService m;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.r0.h.j.n.d a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.r0.h.j.n.d f10870b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.r0.h.j.n.d f10871c;

    /* renamed from: d  reason: collision with root package name */
    public DownloadManager f10872d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.r0.h.j.n.b f10873e;

    /* renamed from: f  reason: collision with root package name */
    public i f10874f;

    /* renamed from: g  reason: collision with root package name */
    public BroadcastReceiver f10875g;

    /* renamed from: h  reason: collision with root package name */
    public JSONObject f10876h;

    /* renamed from: i  reason: collision with root package name */
    public int f10877i;

    /* renamed from: j  reason: collision with root package name */
    public int f10878j;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f10879e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f10880f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f10881g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f10882h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ e f10883i;

        public a(e eVar, String str, String str2, String str3, String str4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, str, str2, str3, str4};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10883i = eVar;
            this.f10879e = str;
            this.f10880f = str2;
            this.f10881g = str3;
            this.f10882h = str4;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.r0.h.j.r.b.n().h(this.f10879e, new c.a.r0.h.j.r.a(this.f10883i.f10876h), this.f10880f, this.f10881g, this.f10882h);
                if (c.a.r0.a.g1.g.a().b()) {
                    return;
                }
                boolean unused = e.f10869k;
                Intent intent = new Intent(AppRuntime.getAppContext(), GameNowInstallAntiBlockingActivity.class);
                intent.putExtra("type", this.f10879e);
                intent.putExtra("packageName", this.f10880f);
                if (this.f10883i.f10876h != null) {
                    intent.putExtra("ubc_params", this.f10883i.f10876h.toString());
                }
                intent.setFlags(276824064);
                c.a.r0.a.z2.f.g(AppRuntime.getAppContext(), intent);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements DownloadManager.OnProgressChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e a;

        public b(e eVar) {
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
                    return;
                }
            }
            this.a = eVar;
        }

        @Override // com.baidu.down.manage.DownloadManager.OnProgressChangeListener
        public void onProgressChanged(long j2, int i2, long j3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j2), Integer.valueOf(i2), Long.valueOf(j3)}) == null) {
                if (k.a) {
                    String str = "onProgressChanged downloadId = " + j2 + ",percentage = " + i2 + ",speed = " + j3;
                }
                if (this.a.f10871c.d(String.valueOf(j2))) {
                    this.a.f10871c.b(String.valueOf(j2), new h(i2));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements DownloadManager.OnStateChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e a;

        public c(e eVar) {
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
                    return;
                }
            }
            this.a = eVar;
        }

        @Override // com.baidu.down.manage.DownloadManager.OnStateChangeListener
        public void onStateChanged(long j2, Download download) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJL(1048576, this, j2, download) == null) || download == null || download.getId() == null) {
                return;
            }
            String valueOf = String.valueOf(download.getId());
            download.getKeyByUser();
            if (e.f10869k) {
                String str = "onStateChanged downloadId = " + j2 + ",eventType:" + valueOf + ",download = " + download;
            }
            if (download.getState() != Download.DownloadState.FINISH || !download.getMimetype().equals("application/zip")) {
                if (this.a.a.d(valueOf)) {
                    this.a.a.b(valueOf, new h(download));
                    c.a.r0.h.j.n.a aVar = new c.a.r0.h.j.n.a(download);
                    int i2 = f.a[download.getState().ordinal()];
                    if (i2 == 1) {
                        c.a.r0.h.j.r.b.n().f("reallyPause", new c.a.r0.h.j.r.a(this.a.f10876h), aVar.m(), aVar.j(), aVar.l());
                        return;
                    } else if (i2 != 2) {
                        if (i2 != 3) {
                            return;
                        }
                        c.a.r0.h.j.r.b.n().h("reallyDownloadFail", new c.a.r0.h.j.r.a(this.a.f10876h), aVar.m(), aVar.j(), aVar.l());
                        this.a.F(valueOf);
                        this.a.E(valueOf);
                        return;
                    } else {
                        String j3 = aVar.j();
                        if (this.a.w(download)) {
                            this.a.L(download.getUrl(), download.getKeyByUser(), j3);
                            c.a.r0.h.j.r.b.n().f("reallyDownloaded", new c.a.r0.h.j.r.a(this.a.f10876h), aVar.m(), aVar.j(), aVar.l());
                            if (TextUtils.equals(aVar.m(), c.a.r0.h.j.m.c.a)) {
                                c.a.r0.h.j.r.b.n().p(12, aVar.m(), aVar.h(), aVar.l());
                            }
                            this.a.F(valueOf);
                            this.a.E(valueOf);
                            return;
                        }
                        aVar.p("download_current_bytes", download.getCurrentbytes());
                        aVar.p("download_total_bytes", download.getTotalbytes());
                        c.a.r0.h.j.r.b.n().h("analysisFailed", new c.a.r0.h.j.r.a(this.a.f10876h), aVar.m(), aVar.j(), aVar.l());
                        String str2 = download.getRealDownloadDir() + File.separator + download.getFileName();
                        c.a.r0.h.j.r.b.n().q(1001, download.getKeyByUser(), download.getUrl(), this.a.f10878j, (TextUtils.isEmpty(str2) || !new File(str2).exists()) ? "" : c.a.r0.w.f.b(new File(str2), true), download.getCurrentbytes().longValue(), download.getTotalbytes().longValue());
                        c.a.r0.a.c2.b.f.e.g(c.a.r0.a.c1.a.c(), c.a.r0.a.c1.a.c().getString(c.a.r0.h.j.k.aiapps_gamenow_download_fail)).G();
                        this.a.s(download.getKeyByUser());
                        if (this.a.f10877i >= 2) {
                            this.a.F(valueOf);
                            this.a.E(valueOf);
                            return;
                        }
                        this.a.J(download.getUrl(), download.getKeyByUser(), download.getFromParam());
                        return;
                    }
                }
                return;
            }
            this.a.M(download);
        }
    }

    /* loaded from: classes6.dex */
    public class d extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e this$0;

        public d(e eVar) {
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
                    return;
                }
            }
            this.this$0 = eVar;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) || intent == null || intent.getData() == null) {
                return;
            }
            String schemeSpecificPart = intent.getData().getSchemeSpecificPart();
            if (TextUtils.isEmpty(schemeSpecificPart)) {
                return;
            }
            if (e.f10869k) {
                String str = "AddPackageReceiver packageName = " + schemeSpecificPart;
            }
            if (this.this$0.f10870b.d(schemeSpecificPart)) {
                this.this$0.f10870b.b(schemeSpecificPart, new h(true));
                this.this$0.D(schemeSpecificPart, null);
            }
            Download g2 = this.this$0.f10873e.g(schemeSpecificPart);
            if (g2 != null) {
                c.a.r0.h.j.n.a aVar = new c.a.r0.h.j.n.a(g2);
                String h2 = aVar.h();
                if (TextUtils.equals(aVar.m(), c.a.r0.h.j.m.c.a) || TextUtils.isEmpty(h2)) {
                    c.a.r0.h.j.r.b.n().h("reallyInstalled", new c.a.r0.h.j.r.a(this.this$0.f10876h), aVar.m(), aVar.j(), aVar.l());
                    this.this$0.n(g2);
                }
            }
        }
    }

    /* renamed from: c.a.r0.h.j.n.e$e  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class RunnableC0702e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Download f10884e;

        public RunnableC0702e(e eVar, Download download) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, download};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10884e = download;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    c.a.r0.w.d.M(this.f10884e.getFromParam());
                    String str = this.f10884e.getFromParam() + File.separator + this.f10884e.getFileName().replace(".zip", "");
                    String str2 = c.a.r0.h.j.n.a.n() + File.separator + this.f10884e.getFileName();
                    if (e.f10869k) {
                        String str3 = "unzip: " + str + " zip:  " + str2;
                    }
                    c.a.r0.w.d.U(str2, str);
                    c.a.r0.w.d.M(str2);
                } catch (Exception e2) {
                    if (e.f10869k) {
                        e2.printStackTrace();
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static /* synthetic */ class f {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1722377292, "Lc/a/r0/h/j/n/e$f;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1722377292, "Lc/a/r0/h/j/n/e$f;");
                    return;
                }
            }
            int[] iArr = new int[Download.DownloadState.values().length];
            a = iArr;
            try {
                iArr[Download.DownloadState.PAUSE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[Download.DownloadState.FINISH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[Download.DownloadState.FAILED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-306587250, "Lc/a/r0/h/j/n/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-306587250, "Lc/a/r0/h/j/n/e;");
                return;
            }
        }
        f10869k = k.a;
        m = Executors.newSingleThreadExecutor();
    }

    public e() {
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
        this.a = new c.a.r0.h.j.n.d();
        this.f10870b = new c.a.r0.h.j.n.d();
        this.f10871c = new c.a.r0.h.j.n.d();
        this.f10877i = 0;
        DownloadManager downloadManager = DownloadManager.getInstance(AppRuntime.getAppContext());
        this.f10872d = downloadManager;
        this.f10873e = new c.a.r0.h.j.n.b(downloadManager);
        B();
        C();
        A();
    }

    public static e t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) {
            if (l == null) {
                synchronized (e.class) {
                    if (l == null) {
                        l = new e();
                    }
                }
            }
            return l;
        }
        return (e) invokeV.objValue;
    }

    public final synchronized void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this) {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addDataScheme("package");
                intentFilter.addAction(PackageChangedReceiver.ACTION_INSTALL);
                this.f10875g = new d(this);
                AppRuntime.getAppContext().registerReceiver(this.f10875g, intentFilter);
            }
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f10872d.registerOnProgressChangeListener(new b(this));
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f10872d.registerOnStateChangeListener(new c(this));
        }
    }

    public void D(String str, c.a.r0.h.j.p.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, aVar) == null) {
            this.f10870b.g(str, aVar);
        }
    }

    public void E(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.f10871c.f(str);
        }
    }

    public final void F(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.a.f(str);
        }
    }

    public void G(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048582, this, str, str2, str3) == null) || o() || !SwanAppNetworkUtils.i(null) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        Download g2 = this.f10873e.g(str2);
        if (g2 == null) {
            J(str, str2, str3);
        } else if (g2.getState() == Download.DownloadState.FINISH) {
            c.a.r0.h.j.r.b.n().h("resumeDownloadInstall", new c.a.r0.h.j.r.a(this.f10876h), str2, str3, str);
            L(str, str2, str3);
        } else {
            this.a.a(String.valueOf(g2.getId()), this.f10874f);
            this.f10871c.a(String.valueOf(g2.getId()), this.f10874f);
            this.f10872d.resume(g2.getId().longValue());
        }
    }

    public void H(i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, iVar) == null) {
            this.f10874f = iVar;
        }
    }

    public void I(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        this.f10876h = jSONObject;
    }

    public void J(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048585, this, str, str2, str3) == null) || o() || !SwanAppNetworkUtils.i(null) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        if (c.a.r0.h.j.o.a.g(AppRuntime.getAppContext(), str2)) {
            i iVar = this.f10874f;
            if (iVar != null) {
                iVar.a(new h(true));
                return;
            }
            return;
        }
        this.f10873e.c(str2);
        c.a.r0.a.o2.g.h.a().putLong("startDownloadPackageTime", SystemClock.elapsedRealtime());
        JSONObject d2 = w.d(str3);
        String optString = d2.optString("apk_id");
        String optString2 = d2.optString("from_view");
        String optString3 = d2.optString("from_value");
        String optString4 = d2.optString(GameGuideConfigInfo.KEY_CONFIG_NAME);
        c.a.r0.h.j.n.a aVar = new c.a.r0.h.j.n.a();
        aVar.r(str);
        aVar.o(str2);
        aVar.a(optString);
        aVar.g(optString2);
        aVar.f(optString3);
        aVar.d(optString4);
        Download b2 = aVar.b();
        this.f10872d.start(b2);
        if (b2.getId() != null) {
            this.a.a(String.valueOf(b2.getId()), this.f10874f);
            this.f10871c.a(String.valueOf(b2.getId()), this.f10874f);
        }
        if (TextUtils.equals(str2, c.a.r0.h.j.m.c.a)) {
            c.a.r0.h.j.r.b.n().p(11, str2, optString, str);
        }
        c.a.r0.h.j.r.b.n().f("reallyBeginDownload", new c.a.r0.h.j.r.a(this.f10876h), str2, b2.getFromParam(), str);
    }

    public void K(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048586, this, str, str2, str3) == null) || o() || !SwanAppNetworkUtils.i(null) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.f10873e.c(str2);
        c.a.r0.h.j.n.a aVar = new c.a.r0.h.j.n.a();
        aVar.r(str);
        aVar.o(str2);
        aVar.e(str2);
        aVar.q(str3);
        this.f10872d.start(aVar.c());
    }

    public void L(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048587, this, str, str2, str3) == null) {
            Bundle bundle = new Bundle();
            String m2 = m(str3, "download_finish_time", Long.valueOf(SystemClock.elapsedRealtime()));
            bundle.putString("key_download_url", str);
            bundle.putString("key_download_package_name", str2);
            bundle.putString("ubc_params", new c.a.r0.h.j.r.a(this.f10876h).a());
            bundle.putString("download_params", m2);
            Intent intent = new Intent(AppRuntime.getAppContext(), InstallActivity.class);
            intent.addFlags(268435456);
            intent.putExtras(bundle);
            AppRuntime.getAppContext().startActivity(intent);
        }
    }

    public final void M(Download download) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, download) == null) || download == null || TextUtils.isEmpty(download.getFileName())) {
            return;
        }
        q.j(new RunnableC0702e(this, download), "unzipRes");
    }

    public final <T> String m(String str, String str2, T t) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048589, this, str, str2, t)) == null) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    jSONObject.put(str2, t);
                    return jSONObject.toString();
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            return str;
        }
        return (String) invokeLLL.objValue;
    }

    public final void n(Download download) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, download) == null) {
            String realDownloadDir = download.getRealDownloadDir();
            String fileName = download.getFileName();
            if (!TextUtils.isEmpty(realDownloadDir) && !TextUtils.isEmpty(fileName)) {
                r(realDownloadDir + File.separator + fileName);
            }
            q();
        }
    }

    public final boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? !ProcessUtils.isMainProcess() : invokeV.booleanValue;
    }

    public void p(String str, String str2, long j2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{str, str2, Long.valueOf(j2)}) == null) || o() || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        Download h2 = this.f10873e.h(str2);
        if (h2 != null) {
            c.a.r0.h.j.n.a aVar = new c.a.r0.h.j.n.a(h2);
            long k2 = aVar.k();
            aVar.p("download_status", h2.getState());
            String j3 = aVar.j();
            if (k2 != 0 && System.currentTimeMillis() - k2 > j2) {
                s(str2);
                c.a.r0.h.j.r.b.n().h("package_expired", new c.a.r0.h.j.r.a(this.f10876h), str2, j3, str);
                return;
            }
            z(str2);
            return;
        }
        i iVar = this.f10874f;
        if (iVar != null) {
            iVar.a(new g(DownloadState.NOT_START.name()));
        }
    }

    public synchronized void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            synchronized (this) {
                this.f10873e.b();
            }
        }
    }

    public boolean r(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            File file = new File(str);
            if (file.isFile() && file.exists()) {
                try {
                    return file.delete();
                } catch (SecurityException e2) {
                    if (f10869k) {
                        e2.printStackTrace();
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void s(String str) {
        Download g2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048595, this, str) == null) || o() || TextUtils.isEmpty(str) || (g2 = this.f10873e.g(str)) == null) {
            return;
        }
        this.f10873e.c(str);
        i iVar = this.f10874f;
        if (iVar != null) {
            iVar.a(new h(g2, true));
        }
    }

    public boolean u(Activity activity, String str, String str2, String str3) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048596, this, activity, str, str2, str3)) == null) {
            if (o()) {
                c.a.r0.h.j.r.b.n().h("checkIllegalProcess", new c.a.r0.h.j.r.a(this.f10876h), str2, str3, str);
                return false;
            } else if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
                Download g2 = this.f10873e.g(str2);
                if (g2 == null) {
                    c.a.r0.h.j.r.b.n().h("nullDownload", new c.a.r0.h.j.r.a(this.f10876h), str2, str3, str);
                    J(str, str2, str3);
                    return false;
                }
                String realDownloadDir = g2.getRealDownloadDir();
                String fileName = g2.getFileName();
                if (f10869k) {
                    String str4 = "installApp packageName:" + str2 + ",fileDir:" + realDownloadDir + ",fileName:" + fileName;
                }
                if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(realDownloadDir) || TextUtils.isEmpty(fileName)) {
                    this.f10873e.c(str2);
                }
                String str5 = realDownloadDir + File.separator + fileName;
                if (c.a.r0.h.j.o.a.g(AppRuntime.getAppContext(), str2)) {
                    c.a.r0.h.j.r.b.n().h("hasInstalled", new c.a.r0.h.j.r.a(this.f10876h), str2, str3, str);
                    i iVar = this.f10874f;
                    if (iVar != null) {
                        iVar.a(new h(true));
                    }
                    r(str5);
                    return false;
                }
                File file = new File(str5);
                if (file.isFile() && file.exists()) {
                    this.f10870b.a(str2, this.f10874f);
                    if (c.a.r0.h.j.o.a.i(activity, str5, false)) {
                        new c.a.r0.h.j.n.a(g2).p("download_finish_time", Long.valueOf(SystemClock.elapsedRealtime()));
                        c.a.r0.h.j.r.b.n().h("showInstallView", new c.a.r0.h.j.r.a(this.f10876h), str2, str3, str);
                        long length = ((file.length() / 104857600) + 1) * 1000;
                        String c2 = c.a.r0.h.j.o.a.c();
                        if (c.a.r0.h.j.o.a.j(c2)) {
                            c.a.r0.a.d2.d.L().postDelayed(new a(this, c2, str2, str3, str), length);
                        }
                        return true;
                    }
                    c.a.r0.h.j.r.b.n().h("showInstallViewFailed", new c.a.r0.h.j.r.a(this.f10876h), str2, str3, str);
                    D(str2, this.f10874f);
                    this.f10873e.c(str2);
                    return false;
                }
                c.a.r0.h.j.r.b.n().h("nullGamenowFile", new c.a.r0.h.j.r.a(this.f10876h), str2, str3, str);
                J(str, str2, str3);
                return false;
            } else {
                c.a.r0.h.j.r.b.n().h("nullPackagenameOrUrl", new c.a.r0.h.j.r.a(this.f10876h), str2, str3, str);
                return false;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public boolean v(String str, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048597, this, str, j2)) == null) {
            if (new File(str).length() < j2) {
                this.f10878j = 3;
                return false;
            }
            try {
                ZipFile zipFile = new ZipFile(str);
                boolean z = zipFile.getEntry("AndroidManifest.xml") != null;
                zipFile.close();
                return z;
            } catch (Exception e2) {
                if (f10869k) {
                    String str2 = "解析APK出错:" + e2.getMessage();
                }
                this.f10878j = 4;
                return false;
            }
        }
        return invokeLJ.booleanValue;
    }

    public final boolean w(Download download) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, download)) == null) {
            this.f10877i++;
            long longValue = download.getTotalbytes().longValue();
            String str = download.getRealDownloadDir() + File.separator + download.getFileName();
            if (!TextUtils.isEmpty(str) && new File(str).exists()) {
                if (((int) (longValue / 1024)) <= 10) {
                    this.f10878j = 2;
                    return false;
                }
                return v(str, longValue);
            }
            boolean z = f10869k;
            this.f10878j = 1;
            return false;
        }
        return invokeL.booleanValue;
    }

    public void x(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048599, this, str, str2) == null) || o() || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        Download g2 = this.f10873e.g(str2);
        String fromParam = g2 != null ? g2.getFromParam() : "";
        if (c.a.r0.h.j.o.a.k(AppRuntime.getAppContext(), str2)) {
            c.a.r0.h.j.r.b.n().h("manualOpen", new c.a.r0.h.j.r.a(this.f10876h), str2, fromParam, str);
        }
    }

    public void y(String str) {
        Download g2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048600, this, str) == null) || o() || TextUtils.isEmpty(str) || (g2 = this.f10873e.g(str)) == null) {
            return;
        }
        if (g2.getState() == Download.DownloadState.WAITING || g2.getState() == Download.DownloadState.DOWNLOADING) {
            this.f10872d.pause(g2.getId().longValue());
            i iVar = this.f10874f;
            if (iVar != null) {
                iVar.a(new h(g2));
            }
        }
    }

    public void z(String str) {
        Download g2;
        i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048601, this, str) == null) || o() || TextUtils.isEmpty(str) || (g2 = this.f10873e.g(str)) == null || (iVar = this.f10874f) == null) {
            return;
        }
        iVar.a(new h(g2));
    }
}
