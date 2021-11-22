package b.a.p0.i.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.k;
import b.a.p0.a.z2.k0;
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
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f10700h;

    /* renamed from: i  reason: collision with root package name */
    public static volatile a f10701i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public b.a.p0.i.b.b f10702a;

    /* renamed from: b  reason: collision with root package name */
    public b.a.p0.i.b.b f10703b;

    /* renamed from: c  reason: collision with root package name */
    public DownloadManager f10704c;

    /* renamed from: d  reason: collision with root package name */
    public b.a.p0.i.b.d.c f10705d;

    /* renamed from: e  reason: collision with root package name */
    public JSONObject f10706e;

    /* renamed from: f  reason: collision with root package name */
    public AppDownloadNetworkStateReceiver f10707f;

    /* renamed from: g  reason: collision with root package name */
    public long f10708g;

    /* renamed from: b.a.p0.i.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0564a implements DownloadManager.OnProgressChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C0564a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.down.manage.DownloadManager.OnProgressChangeListener
        public void onProgressChanged(long j, int i2, long j2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Integer.valueOf(i2), Long.valueOf(j2)}) == null) && k.f6863a) {
                String str = "onProgressChanged downloadId = " + j + ",percentage = " + i2 + ",speed = " + j2;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements b.a.p0.i.b.f.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f10709a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Download f10710b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f10711c;

        public b(a aVar, String str, Download download) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str, download};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10711c = aVar;
            this.f10709a = str;
            this.f10710b = download;
        }

        @Override // b.a.p0.i.b.f.b
        public void a(b.a.p0.i.b.g.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
                if (bVar != null) {
                    if (bVar.d()) {
                        this.f10711c.f10702a.b(this.f10709a, new b.a.p0.i.b.g.c(this.f10710b));
                    } else {
                        this.f10711c.f10702a.b(this.f10709a, bVar);
                    }
                }
                this.f10711c.C(this.f10709a);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f10712e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f10713f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f10714g;

        public c(a aVar, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10714g = aVar;
            this.f10712e = str;
            this.f10713f = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || b.a.p0.a.g1.g.a().b()) {
                return;
            }
            boolean unused = a.f10700h;
            Intent intent = new Intent(AppRuntime.getAppContext(), InstallAntiBlockingActivity.class);
            intent.putExtra("type", this.f10712e);
            intent.putExtra("packageName", this.f10713f);
            if (this.f10714g.f10706e != null) {
                intent.putExtra("ubc_params", this.f10714g.f10706e.toString());
            }
            intent.setFlags(276824064);
            b.a.p0.a.z2.f.g(AppRuntime.getAppContext(), intent);
        }
    }

    /* loaded from: classes4.dex */
    public class d implements DownloadManager.OnStateChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f10715a;

        /* renamed from: b.a.p0.i.b.a$d$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C0565a implements b.a.p0.i.b.f.b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f10716a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Download f10717b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ d f10718c;

            public C0565a(d dVar, String str, Download download) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar, str, download};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f10718c = dVar;
                this.f10716a = str;
                this.f10717b = download;
            }

            @Override // b.a.p0.i.b.f.b
            public void a(b.a.p0.i.b.g.b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
                    if (bVar != null) {
                        if (bVar.d()) {
                            this.f10718c.f10715a.f10702a.b(this.f10716a, new b.a.p0.i.b.g.c(this.f10717b));
                        } else {
                            this.f10718c.f10715a.f10702a.b(this.f10716a, bVar);
                        }
                    }
                    this.f10718c.f10715a.C(this.f10716a);
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10715a = aVar;
        }

        @Override // com.baidu.down.manage.DownloadManager.OnStateChangeListener
        public void onStateChanged(long j, Download download) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJL(1048576, this, j, download) == null) || download == null || download.getId() == null) {
                return;
            }
            String valueOf = String.valueOf(download.getId());
            if (a.f10700h) {
                String str = "onStateChanged downloadId = " + j + ",eventType:" + valueOf + ",download = " + download;
            }
            if (download.getState() == Download.DownloadState.FINISH) {
                if (!b.a.p0.j.u.a.d().a(download)) {
                    b.a.p0.i.b.i.c.a(download.getKeyByUser(), "startDownload", "success", null, new b.a.p0.i.b.i.a(this.f10715a.f10706e));
                    b.a.p0.i.b.i.c.d(2, download.getKeyByUser(), new b.a.p0.i.b.d.a(download).c(), download.getUrl());
                }
                b.a.p0.i.b.h.a.f().m(download, true, "downloadfinish");
            }
            if (this.f10715a.f10702a.d(valueOf)) {
                int i2 = h.f10725a[download.getState().ordinal()];
                if (i2 == 1) {
                    this.f10715a.f10705d.f();
                    b.a.p0.j.u.a.c().b(download.getUrl(), download.getFileName(), download.getRealDownloadDir(), String.valueOf(download.getTotalbytes()), String.valueOf(download.getCurrentbytes()));
                    new b.a.p0.i.b.e.c(download, this.f10715a.f10706e).c(new C0565a(this, valueOf, download));
                    if (b.a.p0.j.u.a.d().a(download)) {
                        b.a.p0.j.u.a.d().b(download);
                    }
                } else if (i2 == 2) {
                    this.f10715a.f10702a.b(valueOf, new b.a.p0.i.b.g.a(31015, "download is canceled"));
                    this.f10715a.C(valueOf);
                } else if (i2 != 3) {
                } else {
                    this.f10715a.f10702a.b(valueOf, new b.a.p0.i.b.g.a(download.getFailedType().intValue(), TextUtils.isEmpty(download.getFailedReason()) ? "download is failed" : download.getFailedReason()));
                    this.f10715a.C(valueOf);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
            if (a.f10700h) {
                String str = "AddPackageReceiver packageName = " + schemeSpecificPart;
            }
            Download o = this.this$0.f10705d.o(schemeSpecificPart);
            if (!b.a.p0.j.u.a.d().a(o)) {
                this.this$0.p(schemeSpecificPart);
            } else {
                b.a.p0.j.u.a.d().c(o);
            }
            this.this$0.t(schemeSpecificPart);
            this.this$0.f10703b.b(schemeSpecificPart, new b.a.p0.i.b.g.c((String) null));
            this.this$0.B(schemeSpecificPart, null);
        }
    }

    /* loaded from: classes4.dex */
    public class f implements b.a.p0.i.b.f.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Download f10719a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f10720b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f10721c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ a f10722d;

        public f(a aVar, Download download, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, download, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10722d = aVar;
            this.f10719a = download;
            this.f10720b = str;
            this.f10721c = str2;
        }

        @Override // b.a.p0.i.b.f.b
        public void a(b.a.p0.i.b.g.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
                String valueOf = String.valueOf(this.f10719a.getId());
                if (bVar != null) {
                    if (!bVar.d()) {
                        this.f10722d.f10702a.b(valueOf, bVar);
                    } else {
                        if (!TextUtils.isEmpty(this.f10720b)) {
                            b.a.p0.i.b.i.c.c("installSuccess", this.f10720b, this.f10721c);
                        }
                        this.f10722d.f10702a.b(valueOf, new b.a.p0.i.b.g.c(this.f10719a));
                    }
                }
                this.f10722d.C(valueOf);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g implements b.a.p0.i.b.f.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Download f10723a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f10724b;

        public g(a aVar, Download download) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, download};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10724b = aVar;
            this.f10723a = download;
        }

        @Override // b.a.p0.i.b.f.b
        public void a(b.a.p0.i.b.g.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
                String valueOf = String.valueOf(this.f10723a.getId());
                if (bVar != null) {
                    if (bVar.d()) {
                        this.f10724b.f10702a.b(valueOf, new b.a.p0.i.b.g.c(this.f10723a));
                    } else {
                        this.f10724b.f10702a.b(valueOf, bVar);
                    }
                }
                this.f10724b.C(valueOf);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static /* synthetic */ class h {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f10725a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1001824271, "Lb/a/p0/i/b/a$h;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1001824271, "Lb/a/p0/i/b/a$h;");
                    return;
                }
            }
            int[] iArr = new int[Download.DownloadState.values().length];
            f10725a = iArr;
            try {
                iArr[Download.DownloadState.FINISH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f10725a[Download.DownloadState.CANCEL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f10725a[Download.DownloadState.FAILED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f10725a[Download.DownloadState.WAITING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f10725a[Download.DownloadState.DOWNLOADING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f10725a[Download.DownloadState.PAUSE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i implements b.a.p0.i.b.f.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public i(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // b.a.p0.i.b.f.b
        public void a(b.a.p0.i.b.g.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-836795723, "Lb/a/p0/i/b/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-836795723, "Lb/a/p0/i/b/a;");
                return;
            }
        }
        f10700h = k.f6863a;
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
        this.f10702a = new b.a.p0.i.b.b();
        this.f10703b = new b.a.p0.i.b.b();
        this.f10708g = 0L;
        DownloadManager downloadManager = DownloadManager.getInstance(AppRuntime.getAppContext());
        this.f10704c = downloadManager;
        b.a.p0.i.b.d.c cVar = new b.a.p0.i.b.d.c(downloadManager);
        this.f10705d = cVar;
        cVar.e();
        this.f10705d.m();
        A();
        z();
        if (f10700h) {
            this.f10704c.registerOnProgressChangeListener(new C0564a(this));
        }
        b.a.p0.i.b.h.a.f().j();
        F();
        o();
    }

    public static a n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            if (f10701i == null) {
                synchronized (a.class) {
                    if (f10701i == null) {
                        f10701i = new a();
                    }
                }
            }
            return f10701i;
        }
        return (a) invokeV.objValue;
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f10704c.registerOnStateChangeListener(new d(this));
        }
    }

    public void B(String str, b.a.p0.i.b.f.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, bVar) == null) {
            this.f10703b.g(str, bVar);
        }
    }

    public final void C(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.f10702a.f(str);
        }
    }

    public void D() {
        Collection<Download> x;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (x = this.f10705d.x()) == null || x.isEmpty()) {
            return;
        }
        for (Download download : x) {
            this.f10702a.a(String.valueOf(download.getId()), new i(this));
            if (!b.a.p0.j.u.a.d().a(download)) {
                b.a.p0.i.b.i.c.a(download.getKeyByUser(), "resumeAllDownload", "success", null, new b.a.p0.i.b.i.a(this.f10706e));
            }
        }
    }

    public void E(@NonNull JSONObject jSONObject, @NonNull b.a.p0.i.b.f.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, jSONObject, bVar) == null) {
            if (i()) {
                bVar.a(new b.a.p0.i.b.g.a(31006, "is not in main process"));
            } else if (!SwanAppNetworkUtils.i(null)) {
                bVar.a(new b.a.p0.i.b.g.a(31014, "network is not connected"));
            } else {
                String optString = jSONObject.optString("url");
                String optString2 = jSONObject.optString("packageName");
                if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                    Download u = this.f10705d.u(optString, optString2);
                    if (u == null) {
                        b.a.p0.i.b.d.d.b().e(jSONObject, bVar);
                        return;
                    }
                    String valueOf = String.valueOf(u.getId());
                    if (!this.f10702a.d(valueOf)) {
                        this.f10702a.a(String.valueOf(u.getId()), bVar);
                    }
                    if (u.getState() == Download.DownloadState.FINISH) {
                        new b.a.p0.i.b.e.c(u, this.f10706e).c(new b(this, valueOf, u));
                        return;
                    }
                    b.a.p0.i.b.i.c.a(optString2, "resumeDownload", null, null, new b.a.p0.i.b.i.a(this.f10706e));
                    this.f10704c.resume(u.getId().longValue());
                    return;
                }
                bVar.a(new b.a.p0.i.b.g.a(31007, "invalid params"));
            }
        }
    }

    public final void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.f10707f == null) {
                this.f10707f = new AppDownloadNetworkStateReceiver();
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            b.a.p0.a.c1.a.c().registerReceiver(this.f10707f, intentFilter);
        }
    }

    public void G(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        this.f10706e = jSONObject;
    }

    public void H(String str, String str2, String str3, @NonNull b.a.p0.i.b.f.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048583, this, str, str2, str3, bVar) == null) {
            if (i()) {
                bVar.a(new b.a.p0.i.b.g.a(31006, "is not in main process"));
            } else if (!SwanAppNetworkUtils.i(null)) {
                bVar.a(new b.a.p0.i.b.g.a(31014, "network is not connected"));
            } else if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                if (b.a.p0.i.b.e.a.h(AppRuntime.getAppContext(), str2)) {
                    bVar.a(new b.a.p0.i.b.g.a(31005, "apk is already installed"));
                } else if (j(str, bVar)) {
                    b.a.p0.i.b.d.a aVar = new b.a.p0.i.b.d.a();
                    aVar.g(str);
                    aVar.f(str2);
                    aVar.a(str3);
                    Download b2 = aVar.b();
                    this.f10704c.start(b2);
                    if (b2.getId() != null) {
                        this.f10702a.a(String.valueOf(b2.getId()), bVar);
                    }
                    if (b.a.p0.j.u.a.d().a(b2)) {
                        return;
                    }
                    b.a.p0.i.b.i.c.a(str2, "startDownload", null, null, new b.a.p0.i.b.i.a(this.f10706e));
                    b.a.p0.i.b.i.c.d(1, str2, str3, str);
                }
            } else {
                bVar.a(new b.a.p0.i.b.g.a(31007, "invalid params"));
            }
        }
    }

    public final void h(Download download, b.a.p0.i.b.f.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, download, bVar) == null) || download.getId() == null) {
            return;
        }
        this.f10702a.a(String.valueOf(download.getId()), bVar);
    }

    public final boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? !ProcessUtils.isMainProcess() : invokeV.booleanValue;
    }

    public boolean j(String str, b.a.p0.i.b.f.b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, str, bVar)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.f10708g < 1000) {
                if (k.f6863a) {
                    String str2 = "interval is " + (currentTimeMillis - this.f10708g);
                }
                return false;
            }
            this.f10708g = currentTimeMillis;
            Download v = this.f10705d.v(str);
            if (v == null) {
                return true;
            }
            Download.DownloadState state = v.getState();
            if (k.f6863a) {
                String str3 = "current state is " + state.name();
            }
            int i2 = h.f10725a[state.ordinal()];
            if (i2 == 1) {
                h(v, bVar);
                s(v);
                return false;
            } else if (i2 == 4 || i2 == 5) {
                h(v, bVar);
                boolean z = k.f6863a;
                return false;
            } else if (i2 != 6) {
                this.f10705d.g(str);
                return true;
            } else {
                h(v, bVar);
                this.f10704c.resume(v.getId().longValue());
                boolean z2 = k.f6863a;
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public synchronized void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            synchronized (this) {
                this.f10705d.d();
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
                    if (f10700h) {
                        e2.printStackTrace();
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void m(@NonNull JSONObject jSONObject, @NonNull b.a.p0.i.b.f.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, jSONObject, bVar) == null) {
            if (i()) {
                bVar.a(new b.a.p0.i.b.g.a(31006, "is not in main process"));
                return;
            }
            String optString = jSONObject.optString("url");
            String optString2 = jSONObject.optString("packageName");
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                Collection<Download> r = this.f10705d.r(optString);
                if (r != null && !r.isEmpty()) {
                    Iterator<Download> it = r.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        Download next = it.next();
                        if (next != null && next.getState() == Download.DownloadState.FINISH) {
                            b.a.p0.j.u.a.c().c(optString);
                            break;
                        }
                    }
                    b.a.p0.i.b.i.c.a(optString2, "deleteDownload", null, null, new b.a.p0.i.b.i.a(this.f10706e));
                    this.f10705d.h(r);
                    bVar.a(new b.a.p0.i.b.g.c(r));
                    return;
                }
                b.a.p0.i.b.d.d.b().a(jSONObject, bVar);
                return;
            }
            bVar.a(new b.a.p0.i.b.g.a(31007, "invalid params"));
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            b.a.p0.i.h.d.a.c().d();
        }
    }

    public final void p(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            if (!this.f10705d.b(str)) {
                String i2 = this.f10705d.i(str);
                if (TextUtils.isEmpty(i2) || !this.f10705d.c(i2)) {
                    return;
                }
                b.a.p0.i.b.i.c.a(str, "installHijack", null, null, new b.a.p0.i.b.i.a(this.f10706e));
                return;
            }
            b.a.p0.i.b.i.c.a(str, "installApp", "success", null, new b.a.p0.i.b.i.a(this.f10706e));
            Download o = this.f10705d.o(str);
            if (o != null) {
                b.a.p0.i.b.i.c.d(3, str, new b.a.p0.i.b.d.a(o).c(), o.getUrl());
            }
        }
    }

    public void q(String str, String str2) {
        Download w;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048592, this, str, str2) == null) || (w = this.f10705d.w(str)) == null) {
            return;
        }
        b.a.p0.i.b.e.c cVar = new b.a.p0.i.b.e.c(w, this.f10706e);
        if (!TextUtils.isEmpty(str2)) {
            b.a.p0.i.b.i.c.c("notifyInstall", str2, str);
        }
        cVar.c(new f(this, w, str2, str));
    }

    public String r(Context context, String str, String str2, @NonNull b.a.p0.i.b.f.a aVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048593, this, context, str, str2, aVar)) == null) {
            if (i()) {
                aVar.a(new b.a.p0.i.b.g.a(31006, "is not in main process"));
                return null;
            } else if (TextUtils.isEmpty(str)) {
                aVar.a(new b.a.p0.i.b.g.a(31007, "invalid params"));
                return null;
            } else {
                Download o = this.f10705d.o(str2);
                if (o == null) {
                    aVar.a(new b.a.p0.i.b.g.a(31008, "download is not exist"));
                    this.f10705d.g(str);
                    return null;
                } else if (o.getCurrentbytes().longValue() < o.getTotalbytes().longValue()) {
                    aVar.a(new b.a.p0.i.b.g.a(31017, "download is not finished"));
                    this.f10705d.g(str);
                    return null;
                } else {
                    String realDownloadDir = o.getRealDownloadDir();
                    String fileName = o.getFileName();
                    if (f10700h) {
                        String str3 = "installApp packageName:" + str2 + ",fileDir:" + realDownloadDir + ",fileName:" + fileName;
                    }
                    if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(realDownloadDir) || TextUtils.isEmpty(fileName)) {
                        aVar.a(new b.a.p0.i.b.g.a(31001, "database no package or file name"));
                        this.f10705d.g(str);
                    }
                    String str4 = realDownloadDir + File.separator + fileName;
                    if (b.a.p0.i.b.e.a.h(AppRuntime.getAppContext(), str2)) {
                        p(str2);
                        aVar.a(new b.a.p0.i.b.g.c("apk is already installed"));
                        l(str4);
                        return null;
                    }
                    File file = new File(str4);
                    if (file.isFile() && file.exists()) {
                        if (k0.c() <= file.length()) {
                            aVar.a(new b.a.p0.i.b.g.a(31020, "not enough space to install"));
                            return null;
                        }
                        aVar.setPackageName(str2);
                        aVar.setFilePath(str4);
                        this.f10703b.a(str2, aVar);
                        if (!b.a.p0.i.b.e.a.j(context, str4, false)) {
                            t(str2);
                            B(str2, aVar);
                            aVar.a(new b.a.p0.i.b.g.a(31004, "apk install fail"));
                            this.f10705d.g(str);
                        } else {
                            long length = ((file.length() / 104857600) + 1) * 1000;
                            String c2 = b.a.p0.i.b.e.a.c();
                            if (b.a.p0.i.b.e.a.k(c2)) {
                                b.a.p0.a.d2.d.L().postDelayed(new c(this, c2, str2), length);
                            }
                        }
                        return str2;
                    }
                    aVar.a(new b.a.p0.i.b.g.a(31002, "file is not exist"));
                    this.f10705d.g(str);
                    return null;
                }
            }
        }
        return (String) invokeLLLL.objValue;
    }

    public final void s(Download download) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, download) == null) {
            new b.a.p0.i.b.e.c(download, this.f10706e).c(new g(this, download));
        }
    }

    public void t(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            for (Download download : this.f10705d.p(str)) {
                if (download != null) {
                    b.a.p0.i.b.h.a.f().a(download);
                }
            }
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            this.f10705d.m();
        }
    }

    public void v(@NonNull JSONObject jSONObject, @NonNull b.a.p0.i.b.f.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048597, this, jSONObject, bVar) == null) {
            if (i()) {
                bVar.a(new b.a.p0.i.b.g.a(31006, "is not in main process"));
                return;
            }
            String optString = jSONObject.optString("url");
            String optString2 = jSONObject.optString("packageName");
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                Download u = this.f10705d.u(optString, optString2);
                if (u == null) {
                    b.a.p0.i.b.d.d.b().c(jSONObject, bVar);
                    return;
                } else if (u.getState() != Download.DownloadState.WAITING && u.getState() != Download.DownloadState.DOWNLOADING) {
                    bVar.a(new b.a.p0.i.b.g.a(31013, "download is not started"));
                    return;
                } else {
                    b.a.p0.i.b.i.c.a(optString2, "pauseDownload", null, null, new b.a.p0.i.b.i.a(this.f10706e));
                    this.f10704c.pause(u.getId().longValue());
                    bVar.a(new b.a.p0.i.b.g.c(u));
                    return;
                }
            }
            bVar.a(new b.a.p0.i.b.g.a(31007, "invalid params"));
        }
    }

    public void w(@NonNull b.a.p0.i.b.f.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, bVar) == null) {
            if (i()) {
                bVar.a(new b.a.p0.i.b.g.a(31006, "is not in main process"));
                return;
            }
            Collection<Download> n = this.f10705d.n();
            if (n != null && !n.isEmpty()) {
                bVar.a(new b.a.p0.i.b.g.c(n));
            } else {
                bVar.a(new b.a.p0.i.b.g.a(31008, "download is not exist"));
            }
        }
    }

    public void x(@NonNull JSONObject jSONObject, @NonNull b.a.p0.i.b.f.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048599, this, jSONObject, bVar) == null) {
            if (i()) {
                bVar.a(new b.a.p0.i.b.g.a(31006, "is not in main process"));
                return;
            }
            String optString = jSONObject.optString("url");
            if (TextUtils.isEmpty(optString)) {
                bVar.a(new b.a.p0.i.b.g.a(31007, "invalid params"));
                return;
            }
            Download v = this.f10705d.v(optString);
            if (v == null) {
                b.a.p0.i.b.d.d.b().d(jSONObject, bVar);
            } else {
                bVar.a(new b.a.p0.i.b.g.c(v));
            }
        }
    }

    public Download y(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, str)) == null) ? this.f10705d.v(str) : (Download) invokeL.objValue;
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
