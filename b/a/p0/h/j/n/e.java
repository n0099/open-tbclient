package b.a.p0.h.j.n;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.k;
import b.a.p0.a.z2.q;
import b.a.p0.a.z2.w;
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
/* loaded from: classes4.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean k;
    public static volatile e l;
    public static ExecutorService m;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public b.a.p0.h.j.n.d f10649a;

    /* renamed from: b  reason: collision with root package name */
    public b.a.p0.h.j.n.d f10650b;

    /* renamed from: c  reason: collision with root package name */
    public b.a.p0.h.j.n.d f10651c;

    /* renamed from: d  reason: collision with root package name */
    public DownloadManager f10652d;

    /* renamed from: e  reason: collision with root package name */
    public b.a.p0.h.j.n.b f10653e;

    /* renamed from: f  reason: collision with root package name */
    public i f10654f;

    /* renamed from: g  reason: collision with root package name */
    public BroadcastReceiver f10655g;

    /* renamed from: h  reason: collision with root package name */
    public JSONObject f10656h;

    /* renamed from: i  reason: collision with root package name */
    public int f10657i;
    public int j;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f10658e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f10659f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f10660g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f10661h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ e f10662i;

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
            this.f10662i = eVar;
            this.f10658e = str;
            this.f10659f = str2;
            this.f10660g = str3;
            this.f10661h = str4;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.a.p0.h.j.r.b.n().h(this.f10658e, new b.a.p0.h.j.r.a(this.f10662i.f10656h), this.f10659f, this.f10660g, this.f10661h);
                if (b.a.p0.a.g1.g.a().b()) {
                    return;
                }
                boolean unused = e.k;
                Intent intent = new Intent(AppRuntime.getAppContext(), GameNowInstallAntiBlockingActivity.class);
                intent.putExtra("type", this.f10658e);
                intent.putExtra("packageName", this.f10659f);
                if (this.f10662i.f10656h != null) {
                    intent.putExtra("ubc_params", this.f10662i.f10656h.toString());
                }
                intent.setFlags(276824064);
                b.a.p0.a.z2.f.g(AppRuntime.getAppContext(), intent);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements DownloadManager.OnProgressChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f10663a;

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
            this.f10663a = eVar;
        }

        @Override // com.baidu.down.manage.DownloadManager.OnProgressChangeListener
        public void onProgressChanged(long j, int i2, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
                if (k.f6863a) {
                    String str = "onProgressChanged downloadId = " + j + ",percentage = " + i2 + ",speed = " + j2;
                }
                if (this.f10663a.f10651c.d(String.valueOf(j))) {
                    this.f10663a.f10651c.b(String.valueOf(j), new h(i2));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements DownloadManager.OnStateChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f10664a;

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
            this.f10664a = eVar;
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
                String str = "onStateChanged downloadId = " + j + ",eventType:" + valueOf + ",download = " + download;
            }
            if (download.getState() != Download.DownloadState.FINISH || !download.getMimetype().equals("application/zip")) {
                if (this.f10664a.f10649a.d(valueOf)) {
                    this.f10664a.f10649a.b(valueOf, new h(download));
                    b.a.p0.h.j.n.a aVar = new b.a.p0.h.j.n.a(download);
                    int i2 = f.f10666a[download.getState().ordinal()];
                    if (i2 == 1) {
                        b.a.p0.h.j.r.b.n().f("reallyPause", new b.a.p0.h.j.r.a(this.f10664a.f10656h), aVar.m(), aVar.j(), aVar.l());
                        return;
                    } else if (i2 != 2) {
                        if (i2 != 3) {
                            return;
                        }
                        b.a.p0.h.j.r.b.n().h("reallyDownloadFail", new b.a.p0.h.j.r.a(this.f10664a.f10656h), aVar.m(), aVar.j(), aVar.l());
                        this.f10664a.F(valueOf);
                        this.f10664a.E(valueOf);
                        return;
                    } else {
                        String j2 = aVar.j();
                        if (this.f10664a.w(download)) {
                            this.f10664a.L(download.getUrl(), download.getKeyByUser(), j2);
                            b.a.p0.h.j.r.b.n().f("reallyDownloaded", new b.a.p0.h.j.r.a(this.f10664a.f10656h), aVar.m(), aVar.j(), aVar.l());
                            if (TextUtils.equals(aVar.m(), b.a.p0.h.j.m.c.f10613a)) {
                                b.a.p0.h.j.r.b.n().p(12, aVar.m(), aVar.h(), aVar.l());
                            }
                            this.f10664a.F(valueOf);
                            this.f10664a.E(valueOf);
                            return;
                        }
                        aVar.p("download_current_bytes", download.getCurrentbytes());
                        aVar.p("download_total_bytes", download.getTotalbytes());
                        b.a.p0.h.j.r.b.n().h("analysisFailed", new b.a.p0.h.j.r.a(this.f10664a.f10656h), aVar.m(), aVar.j(), aVar.l());
                        String str2 = download.getRealDownloadDir() + File.separator + download.getFileName();
                        b.a.p0.h.j.r.b.n().q(1001, download.getKeyByUser(), download.getUrl(), this.f10664a.j, (TextUtils.isEmpty(str2) || !new File(str2).exists()) ? "" : b.a.p0.w.f.b(new File(str2), true), download.getCurrentbytes().longValue(), download.getTotalbytes().longValue());
                        b.a.p0.a.c2.b.f.e.g(b.a.p0.a.c1.a.c(), b.a.p0.a.c1.a.c().getString(b.a.p0.h.j.k.aiapps_gamenow_download_fail)).G();
                        this.f10664a.s(download.getKeyByUser());
                        if (this.f10664a.f10657i >= 2) {
                            this.f10664a.F(valueOf);
                            this.f10664a.E(valueOf);
                            return;
                        }
                        this.f10664a.J(download.getUrl(), download.getKeyByUser(), download.getFromParam());
                        return;
                    }
                }
                return;
            }
            this.f10664a.M(download);
        }
    }

    /* loaded from: classes4.dex */
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
            if (e.k) {
                String str = "AddPackageReceiver packageName = " + schemeSpecificPart;
            }
            if (this.this$0.f10650b.d(schemeSpecificPart)) {
                this.this$0.f10650b.b(schemeSpecificPart, new h(true));
                this.this$0.D(schemeSpecificPart, null);
            }
            Download g2 = this.this$0.f10653e.g(schemeSpecificPart);
            if (g2 != null) {
                b.a.p0.h.j.n.a aVar = new b.a.p0.h.j.n.a(g2);
                String h2 = aVar.h();
                if (TextUtils.equals(aVar.m(), b.a.p0.h.j.m.c.f10613a) || TextUtils.isEmpty(h2)) {
                    b.a.p0.h.j.r.b.n().h("reallyInstalled", new b.a.p0.h.j.r.a(this.this$0.f10656h), aVar.m(), aVar.j(), aVar.l());
                    this.this$0.n(g2);
                }
            }
        }
    }

    /* renamed from: b.a.p0.h.j.n.e$e  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class RunnableC0562e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Download f10665e;

        public RunnableC0562e(e eVar, Download download) {
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
            this.f10665e = download;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    b.a.p0.w.d.M(this.f10665e.getFromParam());
                    String str = this.f10665e.getFromParam() + File.separator + this.f10665e.getFileName().replace(".zip", "");
                    String str2 = b.a.p0.h.j.n.a.n() + File.separator + this.f10665e.getFileName();
                    if (e.k) {
                        String str3 = "unzip: " + str + " zip:  " + str2;
                    }
                    b.a.p0.w.d.U(str2, str);
                    b.a.p0.w.d.M(str2);
                } catch (Exception e2) {
                    if (e.k) {
                        e2.printStackTrace();
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static /* synthetic */ class f {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f10666a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(955873609, "Lb/a/p0/h/j/n/e$f;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(955873609, "Lb/a/p0/h/j/n/e$f;");
                    return;
                }
            }
            int[] iArr = new int[Download.DownloadState.values().length];
            f10666a = iArr;
            try {
                iArr[Download.DownloadState.PAUSE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f10666a[Download.DownloadState.FINISH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f10666a[Download.DownloadState.FAILED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1779763659, "Lb/a/p0/h/j/n/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1779763659, "Lb/a/p0/h/j/n/e;");
                return;
            }
        }
        k = k.f6863a;
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
        this.f10649a = new b.a.p0.h.j.n.d();
        this.f10650b = new b.a.p0.h.j.n.d();
        this.f10651c = new b.a.p0.h.j.n.d();
        this.f10657i = 0;
        DownloadManager downloadManager = DownloadManager.getInstance(AppRuntime.getAppContext());
        this.f10652d = downloadManager;
        this.f10653e = new b.a.p0.h.j.n.b(downloadManager);
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
                this.f10655g = new d(this);
                AppRuntime.getAppContext().registerReceiver(this.f10655g, intentFilter);
            }
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f10652d.registerOnProgressChangeListener(new b(this));
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f10652d.registerOnStateChangeListener(new c(this));
        }
    }

    public void D(String str, b.a.p0.h.j.p.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, aVar) == null) {
            this.f10650b.g(str, aVar);
        }
    }

    public void E(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.f10651c.f(str);
        }
    }

    public final void F(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.f10649a.f(str);
        }
    }

    public void G(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048582, this, str, str2, str3) == null) || o() || !SwanAppNetworkUtils.i(null) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        Download g2 = this.f10653e.g(str2);
        if (g2 == null) {
            J(str, str2, str3);
        } else if (g2.getState() == Download.DownloadState.FINISH) {
            b.a.p0.h.j.r.b.n().h("resumeDownloadInstall", new b.a.p0.h.j.r.a(this.f10656h), str2, str3, str);
            L(str, str2, str3);
        } else {
            this.f10649a.a(String.valueOf(g2.getId()), this.f10654f);
            this.f10651c.a(String.valueOf(g2.getId()), this.f10654f);
            this.f10652d.resume(g2.getId().longValue());
        }
    }

    public void H(i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, iVar) == null) {
            this.f10654f = iVar;
        }
    }

    public void I(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        this.f10656h = jSONObject;
    }

    public void J(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048585, this, str, str2, str3) == null) || o() || !SwanAppNetworkUtils.i(null) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        if (b.a.p0.h.j.o.a.g(AppRuntime.getAppContext(), str2)) {
            i iVar = this.f10654f;
            if (iVar != null) {
                iVar.a(new h(true));
                return;
            }
            return;
        }
        this.f10653e.c(str2);
        b.a.p0.a.o2.g.h.a().putLong("startDownloadPackageTime", SystemClock.elapsedRealtime());
        JSONObject d2 = w.d(str3);
        String optString = d2.optString("apk_id");
        String optString2 = d2.optString("from_view");
        String optString3 = d2.optString("from_value");
        String optString4 = d2.optString(GameGuideConfigInfo.KEY_CONFIG_NAME);
        b.a.p0.h.j.n.a aVar = new b.a.p0.h.j.n.a();
        aVar.r(str);
        aVar.o(str2);
        aVar.a(optString);
        aVar.g(optString2);
        aVar.f(optString3);
        aVar.d(optString4);
        Download b2 = aVar.b();
        this.f10652d.start(b2);
        if (b2.getId() != null) {
            this.f10649a.a(String.valueOf(b2.getId()), this.f10654f);
            this.f10651c.a(String.valueOf(b2.getId()), this.f10654f);
        }
        if (TextUtils.equals(str2, b.a.p0.h.j.m.c.f10613a)) {
            b.a.p0.h.j.r.b.n().p(11, str2, optString, str);
        }
        b.a.p0.h.j.r.b.n().f("reallyBeginDownload", new b.a.p0.h.j.r.a(this.f10656h), str2, b2.getFromParam(), str);
    }

    public void K(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048586, this, str, str2, str3) == null) || o() || !SwanAppNetworkUtils.i(null) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.f10653e.c(str2);
        b.a.p0.h.j.n.a aVar = new b.a.p0.h.j.n.a();
        aVar.r(str);
        aVar.o(str2);
        aVar.e(str2);
        aVar.q(str3);
        this.f10652d.start(aVar.c());
    }

    public void L(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048587, this, str, str2, str3) == null) {
            Bundle bundle = new Bundle();
            String m2 = m(str3, "download_finish_time", Long.valueOf(SystemClock.elapsedRealtime()));
            bundle.putString("key_download_url", str);
            bundle.putString("key_download_package_name", str2);
            bundle.putString("ubc_params", new b.a.p0.h.j.r.a(this.f10656h).a());
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
        q.j(new RunnableC0562e(this, download), "unzipRes");
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
        Download h2 = this.f10653e.h(str2);
        if (h2 != null) {
            b.a.p0.h.j.n.a aVar = new b.a.p0.h.j.n.a(h2);
            long k2 = aVar.k();
            aVar.p("download_status", h2.getState());
            String j2 = aVar.j();
            if (k2 != 0 && System.currentTimeMillis() - k2 > j) {
                s(str2);
                b.a.p0.h.j.r.b.n().h("package_expired", new b.a.p0.h.j.r.a(this.f10656h), str2, j2, str);
                return;
            }
            z(str2);
            return;
        }
        i iVar = this.f10654f;
        if (iVar != null) {
            iVar.a(new g(DownloadState.NOT_START.name()));
        }
    }

    public synchronized void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            synchronized (this) {
                this.f10653e.b();
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
        if (!(interceptable == null || interceptable.invokeL(1048595, this, str) == null) || o() || TextUtils.isEmpty(str) || (g2 = this.f10653e.g(str)) == null) {
            return;
        }
        this.f10653e.c(str);
        i iVar = this.f10654f;
        if (iVar != null) {
            iVar.a(new h(g2, true));
        }
    }

    public boolean u(Activity activity, String str, String str2, String str3) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048596, this, activity, str, str2, str3)) == null) {
            if (o()) {
                b.a.p0.h.j.r.b.n().h("checkIllegalProcess", new b.a.p0.h.j.r.a(this.f10656h), str2, str3, str);
                return false;
            } else if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
                Download g2 = this.f10653e.g(str2);
                if (g2 == null) {
                    b.a.p0.h.j.r.b.n().h("nullDownload", new b.a.p0.h.j.r.a(this.f10656h), str2, str3, str);
                    J(str, str2, str3);
                    return false;
                }
                String realDownloadDir = g2.getRealDownloadDir();
                String fileName = g2.getFileName();
                if (k) {
                    String str4 = "installApp packageName:" + str2 + ",fileDir:" + realDownloadDir + ",fileName:" + fileName;
                }
                if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(realDownloadDir) || TextUtils.isEmpty(fileName)) {
                    this.f10653e.c(str2);
                }
                String str5 = realDownloadDir + File.separator + fileName;
                if (b.a.p0.h.j.o.a.g(AppRuntime.getAppContext(), str2)) {
                    b.a.p0.h.j.r.b.n().h("hasInstalled", new b.a.p0.h.j.r.a(this.f10656h), str2, str3, str);
                    i iVar = this.f10654f;
                    if (iVar != null) {
                        iVar.a(new h(true));
                    }
                    r(str5);
                    return false;
                }
                File file = new File(str5);
                if (file.isFile() && file.exists()) {
                    this.f10650b.a(str2, this.f10654f);
                    if (b.a.p0.h.j.o.a.i(activity, str5, false)) {
                        new b.a.p0.h.j.n.a(g2).p("download_finish_time", Long.valueOf(SystemClock.elapsedRealtime()));
                        b.a.p0.h.j.r.b.n().h("showInstallView", new b.a.p0.h.j.r.a(this.f10656h), str2, str3, str);
                        long length = ((file.length() / 104857600) + 1) * 1000;
                        String c2 = b.a.p0.h.j.o.a.c();
                        if (b.a.p0.h.j.o.a.j(c2)) {
                            b.a.p0.a.d2.d.L().postDelayed(new a(this, c2, str2, str3, str), length);
                        }
                        return true;
                    }
                    b.a.p0.h.j.r.b.n().h("showInstallViewFailed", new b.a.p0.h.j.r.a(this.f10656h), str2, str3, str);
                    D(str2, this.f10654f);
                    this.f10653e.c(str2);
                    return false;
                }
                b.a.p0.h.j.r.b.n().h("nullGamenowFile", new b.a.p0.h.j.r.a(this.f10656h), str2, str3, str);
                J(str, str2, str3);
                return false;
            } else {
                b.a.p0.h.j.r.b.n().h("nullPackagenameOrUrl", new b.a.p0.h.j.r.a(this.f10656h), str2, str3, str);
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
                boolean z = zipFile.getEntry("AndroidManifest.xml") != null;
                zipFile.close();
                return z;
            } catch (Exception e2) {
                if (k) {
                    String str2 = "解析APK出错:" + e2.getMessage();
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
            this.f10657i++;
            long longValue = download.getTotalbytes().longValue();
            String str = download.getRealDownloadDir() + File.separator + download.getFileName();
            if (!TextUtils.isEmpty(str) && new File(str).exists()) {
                if (((int) (longValue / 1024)) <= 10) {
                    this.j = 2;
                    return false;
                }
                return v(str, longValue);
            }
            boolean z = k;
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
        Download g2 = this.f10653e.g(str2);
        String fromParam = g2 != null ? g2.getFromParam() : "";
        if (b.a.p0.h.j.o.a.k(AppRuntime.getAppContext(), str2)) {
            b.a.p0.h.j.r.b.n().h("manualOpen", new b.a.p0.h.j.r.a(this.f10656h), str2, fromParam, str);
        }
    }

    public void y(String str) {
        Download g2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048600, this, str) == null) || o() || TextUtils.isEmpty(str) || (g2 = this.f10653e.g(str)) == null) {
            return;
        }
        if (g2.getState() == Download.DownloadState.WAITING || g2.getState() == Download.DownloadState.DOWNLOADING) {
            this.f10652d.pause(g2.getId().longValue());
            i iVar = this.f10654f;
            if (iVar != null) {
                iVar.a(new h(g2));
            }
        }
    }

    public void z(String str) {
        Download g2;
        i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048601, this, str) == null) || o() || TextUtils.isEmpty(str) || (g2 = this.f10653e.g(str)) == null || (iVar = this.f10654f) == null) {
            return;
        }
        iVar.a(new h(g2));
    }
}
