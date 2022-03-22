package c.a.n0.h.b.f;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.p2.q;
import c.a.n0.a.p2.w;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.manage.Download;
import com.baidu.down.manage.DownloadManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.sofire.utility.CommonMethods;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.game.ad.downloader.model.DownloadState;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.swan.game.guide.install.GameNowInstallAntiBlockingActivity;
import com.baidu.swan.game.guide.install.InstallActivity;
import com.baidu.tbadk.commonReceiver.PackageChangedReceiver;
import com.baidu.tieba.R;
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
/* loaded from: classes.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean k;
    public static volatile e l;
    public static ExecutorService m;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.n0.h.b.f.d a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.n0.h.b.f.d f8444b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.n0.h.b.f.d f8445c;

    /* renamed from: d  reason: collision with root package name */
    public DownloadManager f8446d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.n0.h.b.f.b f8447e;

    /* renamed from: f  reason: collision with root package name */
    public i f8448f;

    /* renamed from: g  reason: collision with root package name */
    public BroadcastReceiver f8449g;

    /* renamed from: h  reason: collision with root package name */
    public JSONObject f8450h;
    public int i;
    public int j;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f8451b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f8452c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f8453d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f8454e;

        public a(e eVar, String str, String str2, String str3, String str4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, str, str2, str3, str4};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8454e = eVar;
            this.a = str;
            this.f8451b = str2;
            this.f8452c = str3;
            this.f8453d = str4;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.n0.h.b.j.b.n().h(this.a, new c.a.n0.h.b.j.a(this.f8454e.f8450h), this.f8451b, this.f8452c, this.f8453d);
                if (c.a.n0.a.w0.g.a().b()) {
                    return;
                }
                if (e.k) {
                    Log.d("GameNowAppManager", "start InstallAntiBlockingActivity");
                }
                Intent intent = new Intent(AppRuntime.getAppContext(), GameNowInstallAntiBlockingActivity.class);
                intent.putExtra("type", this.a);
                intent.putExtra("packageName", this.f8451b);
                if (this.f8454e.f8450h != null) {
                    intent.putExtra("ubc_params", this.f8454e.f8450h.toString());
                }
                intent.setFlags(276824064);
                c.a.n0.a.p2.f.g(AppRuntime.getAppContext(), intent);
            }
        }
    }

    /* loaded from: classes.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eVar;
        }

        @Override // com.baidu.down.manage.DownloadManager.OnProgressChangeListener
        public void onProgressChanged(long j, int i, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Integer.valueOf(i), Long.valueOf(j2)}) == null) {
                if (c.a.n0.a.a.a) {
                    Log.d("GameNowAppManager", "onProgressChanged downloadId = " + j + ",percentage = " + i + ",speed = " + j2);
                }
                if (this.a.f8445c.d(String.valueOf(j))) {
                    this.a.f8445c.b(String.valueOf(j), new h(i));
                }
            }
        }
    }

    /* loaded from: classes.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eVar;
        }

        @Override // com.baidu.down.manage.DownloadManager.OnStateChangeListener
        public void onStateChanged(long j, Download download) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJL(1048576, this, j, download) == null) || download == null || download.getId() == null) {
                return;
            }
            String valueOf = String.valueOf(download.getId());
            download.getKeyByUser();
            if (e.k) {
                Log.d("GameNowAppManager", "onStateChanged downloadId = " + j + ",eventType:" + valueOf + ",download = " + download);
            }
            if (download.getState() != Download.DownloadState.FINISH || !download.getMimetype().equals("application/zip")) {
                if (this.a.a.d(valueOf)) {
                    this.a.a.b(valueOf, new h(download));
                    c.a.n0.h.b.f.a aVar = new c.a.n0.h.b.f.a(download);
                    int i = f.a[download.getState().ordinal()];
                    if (i == 1) {
                        c.a.n0.h.b.j.b.n().f("reallyPause", new c.a.n0.h.b.j.a(this.a.f8450h), aVar.m(), aVar.j(), aVar.l());
                        return;
                    } else if (i != 2) {
                        if (i != 3) {
                            return;
                        }
                        c.a.n0.h.b.j.b.n().h("reallyDownloadFail", new c.a.n0.h.b.j.a(this.a.f8450h), aVar.m(), aVar.j(), aVar.l());
                        this.a.F(valueOf);
                        this.a.E(valueOf);
                        return;
                    } else {
                        String j2 = aVar.j();
                        if (this.a.w(download)) {
                            this.a.L(download.getUrl(), download.getKeyByUser(), j2);
                            c.a.n0.h.b.j.b.n().f("reallyDownloaded", new c.a.n0.h.b.j.a(this.a.f8450h), aVar.m(), aVar.j(), aVar.l());
                            if (TextUtils.equals(aVar.m(), c.a.n0.h.b.e.c.a)) {
                                c.a.n0.h.b.j.b.n().p(12, aVar.m(), aVar.h(), aVar.l());
                            }
                            this.a.F(valueOf);
                            this.a.E(valueOf);
                            return;
                        }
                        aVar.p("download_current_bytes", download.getCurrentbytes());
                        aVar.p("download_total_bytes", download.getTotalbytes());
                        c.a.n0.h.b.j.b.n().h("analysisFailed", new c.a.n0.h.b.j.a(this.a.f8450h), aVar.m(), aVar.j(), aVar.l());
                        String str = download.getRealDownloadDir() + File.separator + download.getFileName();
                        c.a.n0.h.b.j.b.n().q(1001, download.getKeyByUser(), download.getUrl(), this.a.j, (TextUtils.isEmpty(str) || !new File(str).exists()) ? "" : c.a.n0.w.f.b(new File(str), true), download.getCurrentbytes().longValue(), download.getTotalbytes().longValue());
                        c.a.n0.a.s1.b.f.e.g(c.a.n0.a.s0.a.c(), c.a.n0.a.s0.a.c().getString(R.string.obfuscated_res_0x7f0f017b)).G();
                        this.a.s(download.getKeyByUser());
                        if (this.a.i >= 2) {
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

    /* loaded from: classes.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
            if (e.k) {
                Log.d("GameNowAppManager", "AddPackageReceiver packageName = " + schemeSpecificPart);
            }
            if (this.this$0.f8444b.d(schemeSpecificPart)) {
                this.this$0.f8444b.b(schemeSpecificPart, new h(true));
                this.this$0.D(schemeSpecificPart, null);
            }
            Download g2 = this.this$0.f8447e.g(schemeSpecificPart);
            if (g2 != null) {
                c.a.n0.h.b.f.a aVar = new c.a.n0.h.b.f.a(g2);
                String h2 = aVar.h();
                if (TextUtils.equals(aVar.m(), c.a.n0.h.b.e.c.a) || TextUtils.isEmpty(h2)) {
                    c.a.n0.h.b.j.b.n().h("reallyInstalled", new c.a.n0.h.b.j.a(this.this$0.f8450h), aVar.m(), aVar.j(), aVar.l());
                    this.this$0.n(g2);
                }
            }
        }
    }

    /* renamed from: c.a.n0.h.b.f.e$e  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0670e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Download a;

        public RunnableC0670e(e eVar, Download download) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, download};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = download;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    c.a.n0.w.d.M(this.a.getFromParam());
                    String str = this.a.getFromParam() + File.separator + this.a.getFileName().replace(".zip", "");
                    String str2 = c.a.n0.h.b.f.a.n() + File.separator + this.a.getFileName();
                    if (e.k) {
                        Log.d("GameNowAppManager", "unzip: " + str + " zip:  " + str2);
                    }
                    c.a.n0.w.d.U(str2, str);
                    c.a.n0.w.d.M(str2);
                } catch (Exception e2) {
                    if (e.k) {
                        e2.printStackTrace();
                    }
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static /* synthetic */ class f {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1609375320, "Lc/a/n0/h/b/f/e$f;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1609375320, "Lc/a/n0/h/b/f/e$f;");
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1937987942, "Lc/a/n0/h/b/f/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1937987942, "Lc/a/n0/h/b/f/e;");
                return;
            }
        }
        k = c.a.n0.a.a.a;
        m = Executors.newSingleThreadExecutor();
    }

    public e() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new c.a.n0.h.b.f.d();
        this.f8444b = new c.a.n0.h.b.f.d();
        this.f8445c = new c.a.n0.h.b.f.d();
        this.i = 0;
        DownloadManager downloadManager = DownloadManager.getInstance(AppRuntime.getAppContext());
        this.f8446d = downloadManager;
        this.f8447e = new c.a.n0.h.b.f.b(downloadManager);
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
                this.f8449g = new d(this);
                AppRuntime.getAppContext().registerReceiver(this.f8449g, intentFilter);
            }
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f8446d.registerOnProgressChangeListener(new b(this));
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f8446d.registerOnStateChangeListener(new c(this));
        }
    }

    public void D(String str, c.a.n0.h.b.h.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, aVar) == null) {
            this.f8444b.g(str, aVar);
        }
    }

    public void E(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.f8445c.f(str);
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
        Download g2 = this.f8447e.g(str2);
        if (g2 == null) {
            J(str, str2, str3);
        } else if (g2.getState() == Download.DownloadState.FINISH) {
            c.a.n0.h.b.j.b.n().h("resumeDownloadInstall", new c.a.n0.h.b.j.a(this.f8450h), str2, str3, str);
            L(str, str2, str3);
        } else {
            this.a.a(String.valueOf(g2.getId()), this.f8448f);
            this.f8445c.a(String.valueOf(g2.getId()), this.f8448f);
            this.f8446d.resume(g2.getId().longValue());
        }
    }

    public void H(i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, iVar) == null) {
            this.f8448f = iVar;
        }
    }

    public void I(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        this.f8450h = jSONObject;
    }

    public void J(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048585, this, str, str2, str3) == null) || o() || !SwanAppNetworkUtils.i(null) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        if (c.a.n0.h.b.g.a.g(AppRuntime.getAppContext(), str2)) {
            i iVar = this.f8448f;
            if (iVar != null) {
                iVar.a(new h(true));
                return;
            }
            return;
        }
        this.f8447e.c(str2);
        c.a.n0.a.e2.g.h.a().putLong("startDownloadPackageTime", SystemClock.elapsedRealtime());
        JSONObject d2 = w.d(str3);
        String optString = d2.optString("apk_id");
        String optString2 = d2.optString("from_view");
        String optString3 = d2.optString("from_value");
        String optString4 = d2.optString(GameGuideConfigInfo.KEY_CONFIG_NAME);
        c.a.n0.h.b.f.a aVar = new c.a.n0.h.b.f.a();
        aVar.r(str);
        aVar.o(str2);
        aVar.a(optString);
        aVar.g(optString2);
        aVar.f(optString3);
        aVar.d(optString4);
        Download b2 = aVar.b();
        this.f8446d.start(b2);
        if (b2.getId() != null) {
            this.a.a(String.valueOf(b2.getId()), this.f8448f);
            this.f8445c.a(String.valueOf(b2.getId()), this.f8448f);
        }
        if (TextUtils.equals(str2, c.a.n0.h.b.e.c.a)) {
            c.a.n0.h.b.j.b.n().p(11, str2, optString, str);
        }
        c.a.n0.h.b.j.b.n().f("reallyBeginDownload", new c.a.n0.h.b.j.a(this.f8450h), str2, b2.getFromParam(), str);
    }

    public void K(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048586, this, str, str2, str3) == null) || o() || !SwanAppNetworkUtils.i(null) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.f8447e.c(str2);
        c.a.n0.h.b.f.a aVar = new c.a.n0.h.b.f.a();
        aVar.r(str);
        aVar.o(str2);
        aVar.e(str2);
        aVar.q(str3);
        this.f8446d.start(aVar.c());
    }

    public void L(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048587, this, str, str2, str3) == null) {
            Bundle bundle = new Bundle();
            String m2 = m(str3, "download_finish_time", Long.valueOf(SystemClock.elapsedRealtime()));
            bundle.putString("key_download_url", str);
            bundle.putString("key_download_package_name", str2);
            bundle.putString("ubc_params", new c.a.n0.h.b.j.a(this.f8450h).a());
            bundle.putString("download_params", m2);
            Intent intent = new Intent(AppRuntime.getAppContext(), InstallActivity.class);
            intent.addFlags(LaunchTaskConstants.OTHER_PROCESS);
            intent.putExtras(bundle);
            AppRuntime.getAppContext().startActivity(intent);
        }
    }

    public final void M(Download download) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, download) == null) || download == null || TextUtils.isEmpty(download.getFileName())) {
            return;
        }
        q.j(new RunnableC0670e(this, download), "unzipRes");
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

    public void p(String str, String str2, long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{str, str2, Long.valueOf(j)}) == null) || o() || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        Download h2 = this.f8447e.h(str2);
        if (h2 != null) {
            c.a.n0.h.b.f.a aVar = new c.a.n0.h.b.f.a(h2);
            long k2 = aVar.k();
            aVar.p("download_status", h2.getState());
            String j2 = aVar.j();
            if (k2 != 0 && System.currentTimeMillis() - k2 > j) {
                s(str2);
                c.a.n0.h.b.j.b.n().h("package_expired", new c.a.n0.h.b.j.a(this.f8450h), str2, j2, str);
                return;
            }
            z(str2);
            return;
        }
        i iVar = this.f8448f;
        if (iVar != null) {
            iVar.a(new g(DownloadState.NOT_START.name()));
        }
    }

    public synchronized void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            synchronized (this) {
                this.f8447e.b();
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
                    if (k) {
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
        if (!(interceptable == null || interceptable.invokeL(1048595, this, str) == null) || o() || TextUtils.isEmpty(str) || (g2 = this.f8447e.g(str)) == null) {
            return;
        }
        this.f8447e.c(str);
        i iVar = this.f8448f;
        if (iVar != null) {
            iVar.a(new h(g2, true));
        }
    }

    public boolean u(Activity activity, String str, String str2, String str3) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048596, this, activity, str, str2, str3)) == null) {
            if (o()) {
                c.a.n0.h.b.j.b.n().h("checkIllegalProcess", new c.a.n0.h.b.j.a(this.f8450h), str2, str3, str);
                return false;
            } else if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
                Download g2 = this.f8447e.g(str2);
                if (g2 == null) {
                    c.a.n0.h.b.j.b.n().h("nullDownload", new c.a.n0.h.b.j.a(this.f8450h), str2, str3, str);
                    J(str, str2, str3);
                    return false;
                }
                String realDownloadDir = g2.getRealDownloadDir();
                String fileName = g2.getFileName();
                if (k) {
                    Log.d("GameNowAppManager", "installApp packageName:" + str2 + ",fileDir:" + realDownloadDir + ",fileName:" + fileName);
                }
                if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(realDownloadDir) || TextUtils.isEmpty(fileName)) {
                    this.f8447e.c(str2);
                }
                String str4 = realDownloadDir + File.separator + fileName;
                if (c.a.n0.h.b.g.a.g(AppRuntime.getAppContext(), str2)) {
                    c.a.n0.h.b.j.b.n().h("hasInstalled", new c.a.n0.h.b.j.a(this.f8450h), str2, str3, str);
                    i iVar = this.f8448f;
                    if (iVar != null) {
                        iVar.a(new h(true));
                    }
                    r(str4);
                    return false;
                }
                File file = new File(str4);
                if (file.isFile() && file.exists()) {
                    this.f8444b.a(str2, this.f8448f);
                    if (c.a.n0.h.b.g.a.i(activity, str4, false)) {
                        new c.a.n0.h.b.f.a(g2).p("download_finish_time", Long.valueOf(SystemClock.elapsedRealtime()));
                        c.a.n0.h.b.j.b.n().h("showInstallView", new c.a.n0.h.b.j.a(this.f8450h), str2, str3, str);
                        long length = ((file.length() / 104857600) + 1) * 1000;
                        String c2 = c.a.n0.h.b.g.a.c();
                        if (c.a.n0.h.b.g.a.j(c2)) {
                            c.a.n0.a.t1.d.L().postDelayed(new a(this, c2, str2, str3, str), length);
                        }
                        return true;
                    }
                    c.a.n0.h.b.j.b.n().h("showInstallViewFailed", new c.a.n0.h.b.j.a(this.f8450h), str2, str3, str);
                    D(str2, this.f8448f);
                    this.f8447e.c(str2);
                    return false;
                }
                c.a.n0.h.b.j.b.n().h("nullGamenowFile", new c.a.n0.h.b.j.a(this.f8450h), str2, str3, str);
                J(str, str2, str3);
                return false;
            } else {
                c.a.n0.h.b.j.b.n().h("nullPackagenameOrUrl", new c.a.n0.h.b.j.a(this.f8450h), str2, str3, str);
                return false;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public boolean v(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048597, this, str, j)) == null) {
            if (new File(str).length() < j) {
                this.j = 3;
                return false;
            }
            try {
                ZipFile zipFile = new ZipFile(str);
                boolean z = zipFile.getEntry(CommonMethods.ANDROID_MANIFEST_FILENAME) != null;
                zipFile.close();
                return z;
            } catch (Exception e2) {
                if (k) {
                    Log.e("GameNowAppManager", "解析APK出错:" + e2.getMessage());
                }
                this.j = 4;
                return false;
            }
        }
        return invokeLJ.booleanValue;
    }

    public final boolean w(Download download) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, download)) == null) {
            this.i++;
            long longValue = download.getTotalbytes().longValue();
            String str = download.getRealDownloadDir() + File.separator + download.getFileName();
            if (!TextUtils.isEmpty(str) && new File(str).exists()) {
                if (((int) (longValue / 1024)) <= 10) {
                    this.j = 2;
                    return false;
                }
                return v(str, longValue);
            }
            if (k) {
                Log.e("GameNowAppManager", "apk文件找不到");
            }
            this.j = 1;
            return false;
        }
        return invokeL.booleanValue;
    }

    public void x(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048599, this, str, str2) == null) || o() || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        Download g2 = this.f8447e.g(str2);
        String fromParam = g2 != null ? g2.getFromParam() : "";
        if (c.a.n0.h.b.g.a.k(AppRuntime.getAppContext(), str2)) {
            c.a.n0.h.b.j.b.n().h("manualOpen", new c.a.n0.h.b.j.a(this.f8450h), str2, fromParam, str);
        }
    }

    public void y(String str) {
        Download g2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048600, this, str) == null) || o() || TextUtils.isEmpty(str) || (g2 = this.f8447e.g(str)) == null) {
            return;
        }
        if (g2.getState() == Download.DownloadState.WAITING || g2.getState() == Download.DownloadState.DOWNLOADING) {
            this.f8446d.pause(g2.getId().longValue());
            i iVar = this.f8448f;
            if (iVar != null) {
                iVar.a(new h(g2));
            }
        }
    }

    public void z(String str) {
        Download g2;
        i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048601, this, str) == null) || o() || TextUtils.isEmpty(str) || (g2 = this.f8447e.g(str)) == null || (iVar = this.f8448f) == null) {
            return;
        }
        iVar.a(new h(g2));
    }
}
