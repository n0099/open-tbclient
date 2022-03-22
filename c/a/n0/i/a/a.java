package c.a.n0.i.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.p2.k0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.manage.Download;
import com.baidu.down.manage.DownloadManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.gamecenter.appmanager.download.AppDownloadNetworkStateReceiver;
import com.baidu.swan.gamecenter.appmanager.install.InstallAntiBlockingActivity;
import com.baidu.tbadk.commonReceiver.PackageChangedReceiver;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.Collection;
import java.util.Iterator;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f8478h;
    public static volatile a i;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.n0.i.a.b a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.n0.i.a.b f8479b;

    /* renamed from: c  reason: collision with root package name */
    public DownloadManager f8480c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.n0.i.a.d.c f8481d;

    /* renamed from: e  reason: collision with root package name */
    public JSONObject f8482e;

    /* renamed from: f  reason: collision with root package name */
    public AppDownloadNetworkStateReceiver f8483f;

    /* renamed from: g  reason: collision with root package name */
    public long f8484g;

    /* renamed from: c.a.n0.i.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0672a implements DownloadManager.OnProgressChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C0672a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.down.manage.DownloadManager.OnProgressChangeListener
        public void onProgressChanged(long j, int i, long j2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Integer.valueOf(i), Long.valueOf(j2)}) == null) && c.a.n0.a.a.a) {
                Log.d("GameCenterAppManager", "onProgressChanged downloadId = " + j + ",percentage = " + i + ",speed = " + j2);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements c.a.n0.i.a.f.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Download f8485b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f8486c;

        public b(a aVar, String str, Download download) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str, download};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8486c = aVar;
            this.a = str;
            this.f8485b = download;
        }

        @Override // c.a.n0.i.a.f.b
        public void a(c.a.n0.i.a.g.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
                if (bVar != null) {
                    if (bVar.d()) {
                        this.f8486c.a.b(this.a, new c.a.n0.i.a.g.c(this.f8485b));
                    } else {
                        this.f8486c.a.b(this.a, bVar);
                    }
                }
                this.f8486c.C(this.a);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f8487b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f8488c;

        public c(a aVar, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8488c = aVar;
            this.a = str;
            this.f8487b = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || c.a.n0.a.w0.g.a().b()) {
                return;
            }
            if (a.f8478h) {
                Log.d("GameCenterAppManager", "start InstallAntiBlockingActivity");
            }
            Intent intent = new Intent(AppRuntime.getAppContext(), InstallAntiBlockingActivity.class);
            intent.putExtra("type", this.a);
            intent.putExtra("packageName", this.f8487b);
            if (this.f8488c.f8482e != null) {
                intent.putExtra("ubc_params", this.f8488c.f8482e.toString());
            }
            intent.setFlags(276824064);
            c.a.n0.a.p2.f.g(AppRuntime.getAppContext(), intent);
        }
    }

    /* loaded from: classes.dex */
    public class d implements DownloadManager.OnStateChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        /* renamed from: c.a.n0.i.a.a$d$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0673a implements c.a.n0.i.a.f.b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Download f8489b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ d f8490c;

            public C0673a(d dVar, String str, Download download) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar, str, download};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f8490c = dVar;
                this.a = str;
                this.f8489b = download;
            }

            @Override // c.a.n0.i.a.f.b
            public void a(c.a.n0.i.a.g.b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
                    if (bVar != null) {
                        if (bVar.d()) {
                            this.f8490c.a.a.b(this.a, new c.a.n0.i.a.g.c(this.f8489b));
                        } else {
                            this.f8490c.a.a.b(this.a, bVar);
                        }
                    }
                    this.f8490c.a.C(this.a);
                }
            }
        }

        public d(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // com.baidu.down.manage.DownloadManager.OnStateChangeListener
        public void onStateChanged(long j, Download download) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJL(1048576, this, j, download) == null) || download == null || download.getId() == null) {
                return;
            }
            String valueOf = String.valueOf(download.getId());
            if (a.f8478h) {
                Log.d("GameCenterAppManager", "onStateChanged downloadId = " + j + ",eventType:" + valueOf + ",download = " + download);
            }
            if (download.getState() == Download.DownloadState.FINISH) {
                if (!c.a.n0.j.u.a.d().a(download)) {
                    c.a.n0.i.a.i.c.a(download.getKeyByUser(), "startDownload", "success", null, new c.a.n0.i.a.i.a(this.a.f8482e));
                    c.a.n0.i.a.i.c.d(2, download.getKeyByUser(), new c.a.n0.i.a.d.a(download).c(), download.getUrl());
                }
                c.a.n0.i.a.h.a.f().m(download, true, "downloadfinish");
            }
            if (this.a.a.d(valueOf)) {
                int i = h.a[download.getState().ordinal()];
                if (i == 1) {
                    this.a.f8481d.f();
                    c.a.n0.j.u.a.c().b(download.getUrl(), download.getFileName(), download.getRealDownloadDir(), String.valueOf(download.getTotalbytes()), String.valueOf(download.getCurrentbytes()));
                    new c.a.n0.i.a.e.c(download, this.a.f8482e).c(new C0673a(this, valueOf, download));
                    if (c.a.n0.j.u.a.d().a(download)) {
                        c.a.n0.j.u.a.d().b(download);
                    }
                } else if (i == 2) {
                    this.a.a.b(valueOf, new c.a.n0.i.a.g.a(31015, "download is canceled"));
                    this.a.C(valueOf);
                } else if (i != 3) {
                } else {
                    this.a.a.b(valueOf, new c.a.n0.i.a.g.a(download.getFailedType().intValue(), TextUtils.isEmpty(download.getFailedReason()) ? "download is failed" : download.getFailedReason()));
                    this.a.C(valueOf);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class e extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a this$0;

        public e(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = aVar;
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
            if (a.f8478h) {
                Log.d("GameCenterAppManager", "AddPackageReceiver packageName = " + schemeSpecificPart);
            }
            Download o = this.this$0.f8481d.o(schemeSpecificPart);
            if (!c.a.n0.j.u.a.d().a(o)) {
                this.this$0.p(schemeSpecificPart);
            } else {
                c.a.n0.j.u.a.d().c(o);
            }
            this.this$0.t(schemeSpecificPart);
            this.this$0.f8479b.b(schemeSpecificPart, new c.a.n0.i.a.g.c((String) null));
            this.this$0.B(schemeSpecificPart, null);
        }
    }

    /* loaded from: classes.dex */
    public class f implements c.a.n0.i.a.f.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Download a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f8491b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f8492c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ a f8493d;

        public f(a aVar, Download download, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, download, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8493d = aVar;
            this.a = download;
            this.f8491b = str;
            this.f8492c = str2;
        }

        @Override // c.a.n0.i.a.f.b
        public void a(c.a.n0.i.a.g.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
                String valueOf = String.valueOf(this.a.getId());
                if (bVar != null) {
                    if (!bVar.d()) {
                        this.f8493d.a.b(valueOf, bVar);
                    } else {
                        if (!TextUtils.isEmpty(this.f8491b)) {
                            c.a.n0.i.a.i.c.c("installSuccess", this.f8491b, this.f8492c);
                        }
                        this.f8493d.a.b(valueOf, new c.a.n0.i.a.g.c(this.a));
                    }
                }
                this.f8493d.C(valueOf);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class g implements c.a.n0.i.a.f.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Download a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f8494b;

        public g(a aVar, Download download) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, download};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8494b = aVar;
            this.a = download;
        }

        @Override // c.a.n0.i.a.f.b
        public void a(c.a.n0.i.a.g.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
                String valueOf = String.valueOf(this.a.getId());
                if (bVar != null) {
                    if (bVar.d()) {
                        this.f8494b.a.b(valueOf, new c.a.n0.i.a.g.c(this.a));
                    } else {
                        this.f8494b.a.b(valueOf, bVar);
                    }
                }
                this.f8494b.C(valueOf);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static /* synthetic */ class h {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-223966191, "Lc/a/n0/i/a/a$h;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-223966191, "Lc/a/n0/i/a/a$h;");
                    return;
                }
            }
            int[] iArr = new int[Download.DownloadState.values().length];
            a = iArr;
            try {
                iArr[Download.DownloadState.FINISH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[Download.DownloadState.CANCEL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[Download.DownloadState.FAILED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[Download.DownloadState.WAITING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[Download.DownloadState.DOWNLOADING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[Download.DownloadState.PAUSE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public class i implements c.a.n0.i.a.f.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public i(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // c.a.n0.i.a.f.b
        public void a(c.a.n0.i.a.g.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1810286891, "Lc/a/n0/i/a/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1810286891, "Lc/a/n0/i/a/a;");
                return;
            }
        }
        f8478h = c.a.n0.a.a.a;
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
        this.a = new c.a.n0.i.a.b();
        this.f8479b = new c.a.n0.i.a.b();
        this.f8484g = 0L;
        DownloadManager downloadManager = DownloadManager.getInstance(AppRuntime.getAppContext());
        this.f8480c = downloadManager;
        c.a.n0.i.a.d.c cVar = new c.a.n0.i.a.d.c(downloadManager);
        this.f8481d = cVar;
        cVar.e();
        this.f8481d.m();
        A();
        z();
        if (f8478h) {
            this.f8480c.registerOnProgressChangeListener(new C0672a(this));
        }
        c.a.n0.i.a.h.a.f().j();
        F();
        o();
    }

    public static a n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            if (i == null) {
                synchronized (a.class) {
                    if (i == null) {
                        i = new a();
                    }
                }
            }
            return i;
        }
        return (a) invokeV.objValue;
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f8480c.registerOnStateChangeListener(new d(this));
        }
    }

    public void B(String str, c.a.n0.i.a.f.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, bVar) == null) {
            this.f8479b.g(str, bVar);
        }
    }

    public final void C(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.a.f(str);
        }
    }

    public void D() {
        Collection<Download> x;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (x = this.f8481d.x()) == null || x.isEmpty()) {
            return;
        }
        for (Download download : x) {
            this.a.a(String.valueOf(download.getId()), new i(this));
            if (!c.a.n0.j.u.a.d().a(download)) {
                c.a.n0.i.a.i.c.a(download.getKeyByUser(), "resumeAllDownload", "success", null, new c.a.n0.i.a.i.a(this.f8482e));
            }
        }
    }

    public void E(@NonNull JSONObject jSONObject, @NonNull c.a.n0.i.a.f.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, jSONObject, bVar) == null) {
            if (i()) {
                bVar.a(new c.a.n0.i.a.g.a(31006, "is not in main process"));
            } else if (!SwanAppNetworkUtils.i(null)) {
                bVar.a(new c.a.n0.i.a.g.a(31014, "network is not connected"));
            } else {
                String optString = jSONObject.optString("url");
                String optString2 = jSONObject.optString("packageName");
                if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                    Download u = this.f8481d.u(optString, optString2);
                    if (u == null) {
                        c.a.n0.i.a.d.d.b().e(jSONObject, bVar);
                        return;
                    }
                    String valueOf = String.valueOf(u.getId());
                    if (!this.a.d(valueOf)) {
                        this.a.a(String.valueOf(u.getId()), bVar);
                    }
                    if (u.getState() == Download.DownloadState.FINISH) {
                        new c.a.n0.i.a.e.c(u, this.f8482e).c(new b(this, valueOf, u));
                        return;
                    }
                    c.a.n0.i.a.i.c.a(optString2, "resumeDownload", null, null, new c.a.n0.i.a.i.a(this.f8482e));
                    this.f8480c.resume(u.getId().longValue());
                    return;
                }
                bVar.a(new c.a.n0.i.a.g.a(31007, "invalid params"));
            }
        }
    }

    public final void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.f8483f == null) {
                this.f8483f = new AppDownloadNetworkStateReceiver();
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            c.a.n0.a.s0.a.c().registerReceiver(this.f8483f, intentFilter);
        }
    }

    public void G(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        this.f8482e = jSONObject;
    }

    public void H(String str, String str2, String str3, @NonNull c.a.n0.i.a.f.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048583, this, str, str2, str3, bVar) == null) {
            if (i()) {
                bVar.a(new c.a.n0.i.a.g.a(31006, "is not in main process"));
            } else if (!SwanAppNetworkUtils.i(null)) {
                bVar.a(new c.a.n0.i.a.g.a(31014, "network is not connected"));
            } else if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                if (c.a.n0.i.a.e.a.h(AppRuntime.getAppContext(), str2)) {
                    bVar.a(new c.a.n0.i.a.g.a(31005, "apk is already installed"));
                } else if (j(str, bVar)) {
                    c.a.n0.i.a.d.a aVar = new c.a.n0.i.a.d.a();
                    aVar.g(str);
                    aVar.f(str2);
                    aVar.a(str3);
                    Download b2 = aVar.b();
                    this.f8480c.start(b2);
                    if (b2.getId() != null) {
                        this.a.a(String.valueOf(b2.getId()), bVar);
                    }
                    if (c.a.n0.j.u.a.d().a(b2)) {
                        return;
                    }
                    c.a.n0.i.a.i.c.a(str2, "startDownload", null, null, new c.a.n0.i.a.i.a(this.f8482e));
                    c.a.n0.i.a.i.c.d(1, str2, str3, str);
                }
            } else {
                bVar.a(new c.a.n0.i.a.g.a(31007, "invalid params"));
            }
        }
    }

    public final void h(Download download, c.a.n0.i.a.f.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, download, bVar) == null) || download.getId() == null) {
            return;
        }
        this.a.a(String.valueOf(download.getId()), bVar);
    }

    public final boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? !ProcessUtils.isMainProcess() : invokeV.booleanValue;
    }

    public boolean j(String str, c.a.n0.i.a.f.b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, str, bVar)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.f8484g < 1000) {
                if (c.a.n0.a.a.a) {
                    Log.d("GameCenterAppManager", "interval is " + (currentTimeMillis - this.f8484g));
                }
                return false;
            }
            this.f8484g = currentTimeMillis;
            Download v = this.f8481d.v(str);
            if (v == null) {
                return true;
            }
            Download.DownloadState state = v.getState();
            if (c.a.n0.a.a.a) {
                Log.d("GameCenterAppManager", "current state is " + state.name());
            }
            int i2 = h.a[state.ordinal()];
            if (i2 == 1) {
                h(v, bVar);
                s(v);
                return false;
            } else if (i2 == 4 || i2 == 5) {
                h(v, bVar);
                if (c.a.n0.a.a.a) {
                    Log.d("GameCenterAppManager", "下载中，继续下载");
                }
                return false;
            } else if (i2 != 6) {
                this.f8481d.g(str);
                return true;
            } else {
                h(v, bVar);
                this.f8480c.resume(v.getId().longValue());
                if (c.a.n0.a.a.a) {
                    Log.d("GameCenterAppManager", "状态暂停，恢复下载下载");
                }
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public synchronized void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            synchronized (this) {
                this.f8481d.d();
            }
        }
    }

    public boolean l(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            File file = new File(str);
            if (file.isFile() && file.exists()) {
                try {
                    return file.delete();
                } catch (SecurityException e2) {
                    if (f8478h) {
                        e2.printStackTrace();
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void m(@NonNull JSONObject jSONObject, @NonNull c.a.n0.i.a.f.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, jSONObject, bVar) == null) {
            if (i()) {
                bVar.a(new c.a.n0.i.a.g.a(31006, "is not in main process"));
                return;
            }
            String optString = jSONObject.optString("url");
            String optString2 = jSONObject.optString("packageName");
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                Collection<Download> r = this.f8481d.r(optString);
                if (r != null && !r.isEmpty()) {
                    Iterator<Download> it = r.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        Download next = it.next();
                        if (next != null && next.getState() == Download.DownloadState.FINISH) {
                            c.a.n0.j.u.a.c().c(optString);
                            break;
                        }
                    }
                    c.a.n0.i.a.i.c.a(optString2, "deleteDownload", null, null, new c.a.n0.i.a.i.a(this.f8482e));
                    this.f8481d.h(r);
                    bVar.a(new c.a.n0.i.a.g.c(r));
                    return;
                }
                c.a.n0.i.a.d.d.b().a(jSONObject, bVar);
                return;
            }
            bVar.a(new c.a.n0.i.a.g.a(31007, "invalid params"));
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            c.a.n0.i.g.d.a.c().d();
        }
    }

    public final void p(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            if (!this.f8481d.b(str)) {
                String i2 = this.f8481d.i(str);
                if (TextUtils.isEmpty(i2) || !this.f8481d.c(i2)) {
                    return;
                }
                c.a.n0.i.a.i.c.a(str, "installHijack", null, null, new c.a.n0.i.a.i.a(this.f8482e));
                return;
            }
            c.a.n0.i.a.i.c.a(str, "installApp", "success", null, new c.a.n0.i.a.i.a(this.f8482e));
            Download o = this.f8481d.o(str);
            if (o != null) {
                c.a.n0.i.a.i.c.d(3, str, new c.a.n0.i.a.d.a(o).c(), o.getUrl());
            }
        }
    }

    public void q(String str, String str2) {
        Download w;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048592, this, str, str2) == null) || (w = this.f8481d.w(str)) == null) {
            return;
        }
        c.a.n0.i.a.e.c cVar = new c.a.n0.i.a.e.c(w, this.f8482e);
        if (!TextUtils.isEmpty(str2)) {
            c.a.n0.i.a.i.c.c("notifyInstall", str2, str);
        }
        cVar.c(new f(this, w, str2, str));
    }

    public String r(Context context, String str, String str2, @NonNull c.a.n0.i.a.f.a aVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048593, this, context, str, str2, aVar)) == null) {
            if (i()) {
                aVar.a(new c.a.n0.i.a.g.a(31006, "is not in main process"));
                return null;
            } else if (TextUtils.isEmpty(str)) {
                aVar.a(new c.a.n0.i.a.g.a(31007, "invalid params"));
                return null;
            } else {
                Download o = this.f8481d.o(str2);
                if (o == null) {
                    aVar.a(new c.a.n0.i.a.g.a(31008, "download is not exist"));
                    this.f8481d.g(str);
                    return null;
                } else if (o.getCurrentbytes().longValue() < o.getTotalbytes().longValue()) {
                    aVar.a(new c.a.n0.i.a.g.a(31017, "download is not finished"));
                    this.f8481d.g(str);
                    return null;
                } else {
                    String realDownloadDir = o.getRealDownloadDir();
                    String fileName = o.getFileName();
                    if (f8478h) {
                        Log.d("GameCenterAppManager", "installApp packageName:" + str2 + ",fileDir:" + realDownloadDir + ",fileName:" + fileName);
                    }
                    if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(realDownloadDir) || TextUtils.isEmpty(fileName)) {
                        aVar.a(new c.a.n0.i.a.g.a(31001, "database no package or file name"));
                        this.f8481d.g(str);
                    }
                    String str3 = realDownloadDir + File.separator + fileName;
                    if (c.a.n0.i.a.e.a.h(AppRuntime.getAppContext(), str2)) {
                        p(str2);
                        aVar.a(new c.a.n0.i.a.g.c("apk is already installed"));
                        l(str3);
                        return null;
                    }
                    File file = new File(str3);
                    if (file.isFile() && file.exists()) {
                        if (k0.c() <= file.length()) {
                            aVar.a(new c.a.n0.i.a.g.a(31020, "not enough space to install"));
                            return null;
                        }
                        aVar.setPackageName(str2);
                        aVar.setFilePath(str3);
                        this.f8479b.a(str2, aVar);
                        if (!c.a.n0.i.a.e.a.j(context, str3, false)) {
                            t(str2);
                            B(str2, aVar);
                            aVar.a(new c.a.n0.i.a.g.a(31004, "apk install fail"));
                            this.f8481d.g(str);
                        } else {
                            long length = ((file.length() / 104857600) + 1) * 1000;
                            String c2 = c.a.n0.i.a.e.a.c();
                            if (c.a.n0.i.a.e.a.k(c2)) {
                                c.a.n0.a.t1.d.L().postDelayed(new c(this, c2, str2), length);
                            }
                        }
                        return str2;
                    }
                    aVar.a(new c.a.n0.i.a.g.a(31002, "file is not exist"));
                    this.f8481d.g(str);
                    return null;
                }
            }
        }
        return (String) invokeLLLL.objValue;
    }

    public final void s(Download download) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, download) == null) {
            new c.a.n0.i.a.e.c(download, this.f8482e).c(new g(this, download));
        }
    }

    public void t(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            for (Download download : this.f8481d.p(str)) {
                if (download != null) {
                    c.a.n0.i.a.h.a.f().a(download);
                }
            }
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            this.f8481d.m();
        }
    }

    public void v(@NonNull JSONObject jSONObject, @NonNull c.a.n0.i.a.f.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048597, this, jSONObject, bVar) == null) {
            if (i()) {
                bVar.a(new c.a.n0.i.a.g.a(31006, "is not in main process"));
                return;
            }
            String optString = jSONObject.optString("url");
            String optString2 = jSONObject.optString("packageName");
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                Download u = this.f8481d.u(optString, optString2);
                if (u == null) {
                    c.a.n0.i.a.d.d.b().c(jSONObject, bVar);
                    return;
                } else if (u.getState() != Download.DownloadState.WAITING && u.getState() != Download.DownloadState.DOWNLOADING) {
                    bVar.a(new c.a.n0.i.a.g.a(31013, "download is not started"));
                    return;
                } else {
                    c.a.n0.i.a.i.c.a(optString2, "pauseDownload", null, null, new c.a.n0.i.a.i.a(this.f8482e));
                    this.f8480c.pause(u.getId().longValue());
                    bVar.a(new c.a.n0.i.a.g.c(u));
                    return;
                }
            }
            bVar.a(new c.a.n0.i.a.g.a(31007, "invalid params"));
        }
    }

    public void w(@NonNull c.a.n0.i.a.f.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, bVar) == null) {
            if (i()) {
                bVar.a(new c.a.n0.i.a.g.a(31006, "is not in main process"));
                return;
            }
            Collection<Download> n = this.f8481d.n();
            if (n != null && !n.isEmpty()) {
                bVar.a(new c.a.n0.i.a.g.c(n));
            } else {
                bVar.a(new c.a.n0.i.a.g.a(31008, "download is not exist"));
            }
        }
    }

    public void x(@NonNull JSONObject jSONObject, @NonNull c.a.n0.i.a.f.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048599, this, jSONObject, bVar) == null) {
            if (i()) {
                bVar.a(new c.a.n0.i.a.g.a(31006, "is not in main process"));
                return;
            }
            String optString = jSONObject.optString("url");
            if (TextUtils.isEmpty(optString)) {
                bVar.a(new c.a.n0.i.a.g.a(31007, "invalid params"));
                return;
            }
            Download v = this.f8481d.v(optString);
            if (v == null) {
                c.a.n0.i.a.d.d.b().d(jSONObject, bVar);
            } else {
                bVar.a(new c.a.n0.i.a.g.c(v));
            }
        }
    }

    public Download y(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, str)) == null) ? this.f8481d.v(str) : (Download) invokeL.objValue;
    }

    public final synchronized void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            synchronized (this) {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addDataScheme("package");
                intentFilter.addAction(PackageChangedReceiver.ACTION_INSTALL);
                AppRuntime.getAppContext().registerReceiver(new e(this), intentFilter);
            }
        }
    }
}
