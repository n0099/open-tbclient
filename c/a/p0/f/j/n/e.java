package c.a.p0.f.j.n;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.k;
import c.a.p0.a.v2.w;
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
import com.baidu.tieba.service.AsInstallService;
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
/* loaded from: classes3.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean k;
    public static volatile e l;
    public static ExecutorService m;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c.a.p0.f.j.n.d f10764a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.p0.f.j.n.d f10765b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.p0.f.j.n.d f10766c;

    /* renamed from: d  reason: collision with root package name */
    public DownloadManager f10767d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.p0.f.j.n.b f10768e;

    /* renamed from: f  reason: collision with root package name */
    public i f10769f;

    /* renamed from: g  reason: collision with root package name */
    public BroadcastReceiver f10770g;

    /* renamed from: h  reason: collision with root package name */
    public JSONObject f10771h;

    /* renamed from: i  reason: collision with root package name */
    public int f10772i;

    /* renamed from: j  reason: collision with root package name */
    public int f10773j;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f10774e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f10775f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f10776g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f10777h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ e f10778i;

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
            this.f10778i = eVar;
            this.f10774e = str;
            this.f10775f = str2;
            this.f10776g = str3;
            this.f10777h = str4;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.p0.f.j.r.b.n().h(this.f10774e, new c.a.p0.f.j.r.a(this.f10778i.f10771h), this.f10775f, this.f10776g, this.f10777h);
                if (c.a.p0.a.g1.g.a().b()) {
                    return;
                }
                boolean unused = e.k;
                Intent intent = new Intent(AppRuntime.getAppContext(), GameNowInstallAntiBlockingActivity.class);
                intent.putExtra("type", this.f10774e);
                intent.putExtra("packageName", this.f10775f);
                if (this.f10778i.f10771h != null) {
                    intent.putExtra("ubc_params", this.f10778i.f10771h.toString());
                }
                intent.setFlags(276824064);
                c.a.p0.a.v2.f.g(AppRuntime.getAppContext(), intent);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements DownloadManager.OnProgressChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f10779a;

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
            this.f10779a = eVar;
        }

        @Override // com.baidu.down.manage.DownloadManager.OnProgressChangeListener
        public void onProgressChanged(long j2, int i2, long j3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j2), Integer.valueOf(i2), Long.valueOf(j3)}) == null) {
                if (k.f7077a) {
                    String str = "onProgressChanged downloadId = " + j2 + ",percentage = " + i2 + ",speed = " + j3;
                }
                if (this.f10779a.f10766c.d(String.valueOf(j2))) {
                    this.f10779a.f10766c.b(String.valueOf(j2), new h(i2));
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements DownloadManager.OnStateChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f10780a;

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
            this.f10780a = eVar;
        }

        @Override // com.baidu.down.manage.DownloadManager.OnStateChangeListener
        public void onStateChanged(long j2, Download download) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJL(1048576, this, j2, download) == null) || download == null || download.getId() == null) {
                return;
            }
            String valueOf = String.valueOf(download.getId());
            download.getKeyByUser();
            if (e.k) {
                String str = "onStateChanged downloadId = " + j2 + ",eventType:" + valueOf + ",download = " + download;
            }
            if (this.f10780a.f10764a.d(valueOf)) {
                this.f10780a.f10764a.b(valueOf, new h(download));
                c.a.p0.f.j.n.a aVar = new c.a.p0.f.j.n.a(download);
                int i2 = C0539e.f10781a[download.getState().ordinal()];
                if (i2 == 1) {
                    c.a.p0.f.j.r.b.n().f("reallyPause", new c.a.p0.f.j.r.a(this.f10780a.f10771h), aVar.k(), aVar.h(), aVar.j());
                } else if (i2 != 2) {
                    if (i2 != 3) {
                        return;
                    }
                    c.a.p0.f.j.r.b.n().h("reallyDownloadFail", new c.a.p0.f.j.r.a(this.f10780a.f10771h), aVar.k(), aVar.h(), aVar.j());
                    this.f10780a.E(valueOf);
                    this.f10780a.D(valueOf);
                } else {
                    String h2 = aVar.h();
                    if (this.f10780a.v(download)) {
                        this.f10780a.J(download.getUrl(), download.getKeyByUser(), h2);
                        c.a.p0.f.j.r.b.n().f("reallyDownloaded", new c.a.p0.f.j.r.a(this.f10780a.f10771h), aVar.k(), aVar.h(), aVar.j());
                        if (TextUtils.equals(aVar.k(), c.a.p0.f.j.m.c.f10731a)) {
                            c.a.p0.f.j.r.b.n().p(12, aVar.k(), aVar.f(), aVar.j());
                        }
                        this.f10780a.E(valueOf);
                        this.f10780a.D(valueOf);
                        return;
                    }
                    aVar.m("download_current_bytes", download.getCurrentbytes());
                    aVar.m("download_total_bytes", download.getTotalbytes());
                    c.a.p0.f.j.r.b.n().h("analysisFailed", new c.a.p0.f.j.r.a(this.f10780a.f10771h), aVar.k(), aVar.h(), aVar.j());
                    String str2 = download.getRealDownloadDir() + File.separator + download.getFileName();
                    c.a.p0.f.j.r.b.n().q(1001, download.getKeyByUser(), download.getUrl(), this.f10780a.f10773j, (TextUtils.isEmpty(str2) || !new File(str2).exists()) ? "" : c.a.p0.t.f.b(new File(str2), true), download.getCurrentbytes().longValue(), download.getTotalbytes().longValue());
                    c.a.p0.a.z1.b.f.e.g(c.a.p0.a.c1.a.b(), c.a.p0.a.c1.a.b().getString(c.a.p0.f.j.k.aiapps_gamenow_download_fail)).F();
                    this.f10780a.r(download.getKeyByUser());
                    if (this.f10780a.f10772i >= 2) {
                        this.f10780a.E(valueOf);
                        this.f10780a.D(valueOf);
                        return;
                    }
                    this.f10780a.I(download.getUrl(), download.getKeyByUser(), download.getFromParam());
                }
            }
        }
    }

    /* loaded from: classes3.dex */
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
            if (this.this$0.f10765b.d(schemeSpecificPart)) {
                this.this$0.f10765b.b(schemeSpecificPart, new h(true));
                this.this$0.C(schemeSpecificPart, null);
            }
            Download d2 = this.this$0.f10768e.d(schemeSpecificPart);
            if (d2 != null) {
                c.a.p0.f.j.n.a aVar = new c.a.p0.f.j.n.a(d2);
                String f2 = aVar.f();
                if (TextUtils.equals(aVar.k(), c.a.p0.f.j.m.c.f10731a) || TextUtils.isEmpty(f2)) {
                    c.a.p0.f.j.r.b.n().h("reallyInstalled", new c.a.p0.f.j.r.a(this.this$0.f10771h), aVar.k(), aVar.h(), aVar.j());
                    this.this$0.m(d2);
                }
            }
        }
    }

    /* renamed from: c.a.p0.f.j.n.e$e  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class C0539e {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f10781a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1592757011, "Lc/a/p0/f/j/n/e$e;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1592757011, "Lc/a/p0/f/j/n/e$e;");
                    return;
                }
            }
            int[] iArr = new int[Download.DownloadState.values().length];
            f10781a = iArr;
            try {
                iArr[Download.DownloadState.PAUSE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f10781a[Download.DownloadState.FINISH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f10781a[Download.DownloadState.FAILED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-198305202, "Lc/a/p0/f/j/n/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-198305202, "Lc/a/p0/f/j/n/e;");
                return;
            }
        }
        k = k.f7077a;
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
        this.f10764a = new c.a.p0.f.j.n.d();
        this.f10765b = new c.a.p0.f.j.n.d();
        this.f10766c = new c.a.p0.f.j.n.d();
        this.f10772i = 0;
        DownloadManager downloadManager = DownloadManager.getInstance(AppRuntime.getAppContext());
        this.f10767d = downloadManager;
        this.f10768e = new c.a.p0.f.j.n.b(downloadManager);
        A();
        B();
        z();
    }

    public static e s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) {
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

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f10767d.registerOnProgressChangeListener(new b(this));
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f10767d.registerOnStateChangeListener(new c(this));
        }
    }

    public void C(String str, c.a.p0.f.j.p.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, aVar) == null) {
            this.f10765b.g(str, aVar);
        }
    }

    public void D(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.f10766c.f(str);
        }
    }

    public final void E(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.f10764a.f(str);
        }
    }

    public void F(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048581, this, str, str2, str3) == null) || n() || !SwanAppNetworkUtils.i(null) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        Download d2 = this.f10768e.d(str2);
        if (d2 == null) {
            I(str, str2, str3);
        } else if (d2.getState() == Download.DownloadState.FINISH) {
            c.a.p0.f.j.r.b.n().h("resumeDownloadInstall", new c.a.p0.f.j.r.a(this.f10771h), str2, str3, str);
            J(str, str2, str3);
        } else {
            this.f10764a.a(String.valueOf(d2.getId()), this.f10769f);
            this.f10766c.a(String.valueOf(d2.getId()), this.f10769f);
            this.f10767d.resume(d2.getId().longValue());
        }
    }

    public void G(i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, iVar) == null) {
            this.f10769f = iVar;
        }
    }

    public void H(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        this.f10771h = jSONObject;
    }

    public void I(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2, str3) == null) || n() || !SwanAppNetworkUtils.i(null) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        if (c.a.p0.f.j.o.a.g(AppRuntime.getAppContext(), str2)) {
            i iVar = this.f10769f;
            if (iVar != null) {
                iVar.a(new h(true));
                return;
            }
            return;
        }
        this.f10768e.b(str2);
        c.a.p0.a.k2.g.h.a().putLong("startDownloadPackageTime", SystemClock.elapsedRealtime());
        JSONObject d2 = w.d(str3);
        String optString = d2.optString("apk_id");
        String optString2 = d2.optString("from_view");
        String optString3 = d2.optString("from_value");
        String optString4 = d2.optString(GameGuideConfigInfo.KEY_CONFIG_NAME);
        c.a.p0.f.j.n.a aVar = new c.a.p0.f.j.n.a();
        aVar.n(str);
        aVar.l(str2);
        aVar.a(optString);
        aVar.e(optString2);
        aVar.d(optString3);
        aVar.c(optString4);
        Download b2 = aVar.b();
        this.f10767d.start(b2);
        if (b2.getId() != null) {
            this.f10764a.a(String.valueOf(b2.getId()), this.f10769f);
            this.f10766c.a(String.valueOf(b2.getId()), this.f10769f);
        }
        if (TextUtils.equals(str2, c.a.p0.f.j.m.c.f10731a)) {
            c.a.p0.f.j.r.b.n().p(11, str2, optString, str);
        }
        c.a.p0.f.j.r.b.n().f("reallyBeginDownload", new c.a.p0.f.j.r.a(this.f10771h), str2, b2.getFromParam(), str);
    }

    public void J(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048585, this, str, str2, str3) == null) {
            Bundle bundle = new Bundle();
            String l2 = l(str3, "download_finish_time", Long.valueOf(SystemClock.elapsedRealtime()));
            bundle.putString("key_download_url", str);
            bundle.putString("key_download_package_name", str2);
            bundle.putString("ubc_params", new c.a.p0.f.j.r.a(this.f10771h).a());
            bundle.putString("download_params", l2);
            Intent intent = new Intent(AppRuntime.getAppContext(), InstallActivity.class);
            intent.addFlags(268435456);
            intent.putExtras(bundle);
            AppRuntime.getAppContext().startActivity(intent);
        }
    }

    public final <T> String l(String str, String str2, T t) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048586, this, str, str2, t)) == null) {
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

    public final void m(Download download) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, download) == null) {
            String realDownloadDir = download.getRealDownloadDir();
            String fileName = download.getFileName();
            if (!TextUtils.isEmpty(realDownloadDir) && !TextUtils.isEmpty(fileName)) {
                q(realDownloadDir + File.separator + fileName);
            }
            p();
        }
    }

    public final boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? !ProcessUtils.isMainProcess() : invokeV.booleanValue;
    }

    public void o(String str, String str2, long j2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{str, str2, Long.valueOf(j2)}) == null) || n() || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        Download d2 = this.f10768e.d(str2);
        if (d2 != null) {
            c.a.p0.f.j.n.a aVar = new c.a.p0.f.j.n.a(d2);
            long i2 = aVar.i();
            aVar.m("download_status", d2.getState());
            String h2 = aVar.h();
            if (i2 != 0 && System.currentTimeMillis() - i2 > j2) {
                r(str2);
                c.a.p0.f.j.r.b.n().h("package_expired", new c.a.p0.f.j.r.a(this.f10771h), str2, h2, str);
                return;
            }
            y(str2);
            return;
        }
        i iVar = this.f10769f;
        if (iVar != null) {
            iVar.a(new g(DownloadState.NOT_START.name()));
        }
    }

    public synchronized void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            synchronized (this) {
                this.f10768e.a();
            }
        }
    }

    public boolean q(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, str)) == null) {
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

    public void r(String str) {
        Download d2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, str) == null) || n() || TextUtils.isEmpty(str) || (d2 = this.f10768e.d(str)) == null) {
            return;
        }
        this.f10768e.b(str);
        i iVar = this.f10769f;
        if (iVar != null) {
            iVar.a(new h(d2, true));
        }
    }

    public boolean t(Activity activity, String str, String str2, String str3) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048593, this, activity, str, str2, str3)) == null) {
            if (n()) {
                c.a.p0.f.j.r.b.n().h("checkIllegalProcess", new c.a.p0.f.j.r.a(this.f10771h), str2, str3, str);
                return false;
            } else if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
                Download d2 = this.f10768e.d(str2);
                if (d2 == null) {
                    c.a.p0.f.j.r.b.n().h("nullDownload", new c.a.p0.f.j.r.a(this.f10771h), str2, str3, str);
                    I(str, str2, str3);
                    return false;
                }
                String realDownloadDir = d2.getRealDownloadDir();
                String fileName = d2.getFileName();
                if (k) {
                    String str4 = "installApp packageName:" + str2 + ",fileDir:" + realDownloadDir + ",fileName:" + fileName;
                }
                if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(realDownloadDir) || TextUtils.isEmpty(fileName)) {
                    this.f10768e.b(str2);
                }
                String str5 = realDownloadDir + File.separator + fileName;
                if (c.a.p0.f.j.o.a.g(AppRuntime.getAppContext(), str2)) {
                    c.a.p0.f.j.r.b.n().h("hasInstalled", new c.a.p0.f.j.r.a(this.f10771h), str2, str3, str);
                    i iVar = this.f10769f;
                    if (iVar != null) {
                        iVar.a(new h(true));
                    }
                    q(str5);
                    return false;
                }
                File file = new File(str5);
                if (file.isFile() && file.exists()) {
                    this.f10765b.a(str2, this.f10769f);
                    if (c.a.p0.f.j.o.a.i(activity, str5, false)) {
                        new c.a.p0.f.j.n.a(d2).m("download_finish_time", Long.valueOf(SystemClock.elapsedRealtime()));
                        c.a.p0.f.j.r.b.n().h("showInstallView", new c.a.p0.f.j.r.a(this.f10771h), str2, str3, str);
                        long length = ((file.length() / 104857600) + 1) * 1000;
                        String c2 = c.a.p0.f.j.o.a.c();
                        if (c.a.p0.f.j.o.a.j(c2)) {
                            c.a.p0.a.a2.d.i().postDelayed(new a(this, c2, str2, str3, str), length);
                        }
                        return true;
                    }
                    c.a.p0.f.j.r.b.n().h("showInstallViewFailed", new c.a.p0.f.j.r.a(this.f10771h), str2, str3, str);
                    C(str2, this.f10769f);
                    this.f10768e.b(str2);
                    return false;
                }
                c.a.p0.f.j.r.b.n().h("nullGamenowFile", new c.a.p0.f.j.r.a(this.f10771h), str2, str3, str);
                I(str, str2, str3);
                return false;
            } else {
                c.a.p0.f.j.r.b.n().h("nullPackagenameOrUrl", new c.a.p0.f.j.r.a(this.f10771h), str2, str3, str);
                return false;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public boolean u(String str, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048594, this, str, j2)) == null) {
            if (new File(str).length() < j2) {
                this.f10773j = 3;
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
                this.f10773j = 4;
                return false;
            }
        }
        return invokeLJ.booleanValue;
    }

    public final boolean v(Download download) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, download)) == null) {
            this.f10772i++;
            long longValue = download.getTotalbytes().longValue();
            String str = download.getRealDownloadDir() + File.separator + download.getFileName();
            if (!TextUtils.isEmpty(str) && new File(str).exists()) {
                if (((int) (longValue / 1024)) <= 10) {
                    this.f10773j = 2;
                    return false;
                }
                return u(str, longValue);
            }
            boolean z = k;
            this.f10773j = 1;
            return false;
        }
        return invokeL.booleanValue;
    }

    public void w(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048596, this, str, str2) == null) || n() || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        Download d2 = this.f10768e.d(str2);
        String fromParam = d2 != null ? d2.getFromParam() : "";
        if (c.a.p0.f.j.o.a.k(AppRuntime.getAppContext(), str2)) {
            c.a.p0.f.j.r.b.n().h("manualOpen", new c.a.p0.f.j.r.a(this.f10771h), str2, fromParam, str);
        }
    }

    public void x(String str) {
        Download d2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048597, this, str) == null) || n() || TextUtils.isEmpty(str) || (d2 = this.f10768e.d(str)) == null) {
            return;
        }
        if (d2.getState() == Download.DownloadState.WAITING || d2.getState() == Download.DownloadState.DOWNLOADING) {
            this.f10767d.pause(d2.getId().longValue());
            i iVar = this.f10769f;
            if (iVar != null) {
                iVar.a(new h(d2));
            }
        }
    }

    public void y(String str) {
        Download d2;
        i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048598, this, str) == null) || n() || TextUtils.isEmpty(str) || (d2 = this.f10768e.d(str)) == null || (iVar = this.f10769f) == null) {
            return;
        }
        iVar.a(new h(d2));
    }

    public final synchronized void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            synchronized (this) {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addDataScheme(AsInstallService.SCHEME_PACKAGE_ADDED);
                intentFilter.addAction(PackageChangedReceiver.ACTION_INSTALL);
                this.f10770g = new d(this);
                AppRuntime.getAppContext().registerReceiver(this.f10770g, intentFilter);
            }
        }
    }
}
