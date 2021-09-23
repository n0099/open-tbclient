package c.a.p0.g.c;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.k;
import c.a.p0.a.v2.k0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.manage.Download;
import com.baidu.down.manage.DownloadManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.gamecenter.appmanager.download.AppDownloadNetworkStateReceiver;
import com.baidu.swan.gamecenter.appmanager.install.InstallAntiBlockingActivity;
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
import java.util.Collection;
import java.util.Iterator;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f10824h;

    /* renamed from: i  reason: collision with root package name */
    public static volatile a f10825i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c.a.p0.g.c.b f10826a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.p0.g.c.b f10827b;

    /* renamed from: c  reason: collision with root package name */
    public DownloadManager f10828c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.p0.g.c.d.c f10829d;

    /* renamed from: e  reason: collision with root package name */
    public JSONObject f10830e;

    /* renamed from: f  reason: collision with root package name */
    public AppDownloadNetworkStateReceiver f10831f;

    /* renamed from: g  reason: collision with root package name */
    public long f10832g;

    /* renamed from: c.a.p0.g.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0541a implements DownloadManager.OnProgressChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C0541a(a aVar) {
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
        public void onProgressChanged(long j2, int i2, long j3) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j2), Integer.valueOf(i2), Long.valueOf(j3)}) == null) && k.f7085a) {
                String str = "onProgressChanged downloadId = " + j2 + ",percentage = " + i2 + ",speed = " + j3;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements c.a.p0.g.c.f.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f10833a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Download f10834b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f10835c;

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
            this.f10835c = aVar;
            this.f10833a = str;
            this.f10834b = download;
        }

        @Override // c.a.p0.g.c.f.b
        public void b(c.a.p0.g.c.g.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
                if (bVar != null) {
                    if (bVar.d()) {
                        this.f10835c.f10826a.b(this.f10833a, new c.a.p0.g.c.g.c(this.f10834b));
                    } else {
                        this.f10835c.f10826a.b(this.f10833a, bVar);
                    }
                }
                this.f10835c.C(this.f10833a);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f10836e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f10837f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f10838g;

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
            this.f10838g = aVar;
            this.f10836e = str;
            this.f10837f = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || c.a.p0.a.g1.g.a().b()) {
                return;
            }
            boolean unused = a.f10824h;
            Intent intent = new Intent(AppRuntime.getAppContext(), InstallAntiBlockingActivity.class);
            intent.putExtra("type", this.f10836e);
            intent.putExtra("packageName", this.f10837f);
            if (this.f10838g.f10830e != null) {
                intent.putExtra("ubc_params", this.f10838g.f10830e.toString());
            }
            intent.setFlags(276824064);
            c.a.p0.a.v2.f.g(AppRuntime.getAppContext(), intent);
        }
    }

    /* loaded from: classes3.dex */
    public class d implements DownloadManager.OnStateChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f10839a;

        /* renamed from: c.a.p0.g.c.a$d$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0542a implements c.a.p0.g.c.f.b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f10840a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Download f10841b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ d f10842c;

            public C0542a(d dVar, String str, Download download) {
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
                this.f10842c = dVar;
                this.f10840a = str;
                this.f10841b = download;
            }

            @Override // c.a.p0.g.c.f.b
            public void b(c.a.p0.g.c.g.b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
                    if (bVar != null) {
                        if (bVar.d()) {
                            this.f10842c.f10839a.f10826a.b(this.f10840a, new c.a.p0.g.c.g.c(this.f10841b));
                        } else {
                            this.f10842c.f10839a.f10826a.b(this.f10840a, bVar);
                        }
                    }
                    this.f10842c.f10839a.C(this.f10840a);
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
            this.f10839a = aVar;
        }

        @Override // com.baidu.down.manage.DownloadManager.OnStateChangeListener
        public void onStateChanged(long j2, Download download) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJL(1048576, this, j2, download) == null) || download == null || download.getId() == null) {
                return;
            }
            String valueOf = String.valueOf(download.getId());
            if (a.f10824h) {
                String str = "onStateChanged downloadId = " + j2 + ",eventType:" + valueOf + ",download = " + download;
            }
            if (download.getState() == Download.DownloadState.FINISH) {
                if (!c.a.p0.h.t.a.d().a(download)) {
                    c.a.p0.g.c.i.c.a(download.getKeyByUser(), "startDownload", "success", null, new c.a.p0.g.c.i.a(this.f10839a.f10830e));
                    c.a.p0.g.c.i.c.d(2, download.getKeyByUser(), new c.a.p0.g.c.d.a(download).c(), download.getUrl());
                }
                c.a.p0.g.c.h.a.f().m(download, true, "downloadfinish");
            }
            if (this.f10839a.f10826a.d(valueOf)) {
                int i2 = h.f10849a[download.getState().ordinal()];
                if (i2 == 1) {
                    this.f10839a.f10829d.f();
                    c.a.p0.h.t.a.c().b(download.getUrl(), download.getFileName(), download.getRealDownloadDir(), String.valueOf(download.getTotalbytes()), String.valueOf(download.getCurrentbytes()));
                    new c.a.p0.g.c.e.c(download, this.f10839a.f10830e).c(new C0542a(this, valueOf, download));
                    if (c.a.p0.h.t.a.d().a(download)) {
                        c.a.p0.h.t.a.d().b(download);
                    }
                } else if (i2 == 2) {
                    this.f10839a.f10826a.b(valueOf, new c.a.p0.g.c.g.a(31015, "download is canceled"));
                    this.f10839a.C(valueOf);
                } else if (i2 != 3) {
                } else {
                    this.f10839a.f10826a.b(valueOf, new c.a.p0.g.c.g.a(download.getFailedType().intValue(), TextUtils.isEmpty(download.getFailedReason()) ? "download is failed" : download.getFailedReason()));
                    this.f10839a.C(valueOf);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
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
            if (a.f10824h) {
                String str = "AddPackageReceiver packageName = " + schemeSpecificPart;
            }
            Download o = this.this$0.f10829d.o(schemeSpecificPart);
            if (!c.a.p0.h.t.a.d().a(o)) {
                this.this$0.p(schemeSpecificPart);
            } else {
                c.a.p0.h.t.a.d().c(o);
            }
            this.this$0.t(schemeSpecificPart);
            this.this$0.f10827b.b(schemeSpecificPart, new c.a.p0.g.c.g.c((String) null));
            this.this$0.B(schemeSpecificPart, null);
        }
    }

    /* loaded from: classes3.dex */
    public class f implements c.a.p0.g.c.f.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Download f10843a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f10844b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f10845c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ a f10846d;

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
            this.f10846d = aVar;
            this.f10843a = download;
            this.f10844b = str;
            this.f10845c = str2;
        }

        @Override // c.a.p0.g.c.f.b
        public void b(c.a.p0.g.c.g.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
                String valueOf = String.valueOf(this.f10843a.getId());
                if (bVar != null) {
                    if (!bVar.d()) {
                        this.f10846d.f10826a.b(valueOf, bVar);
                    } else {
                        if (!TextUtils.isEmpty(this.f10844b)) {
                            c.a.p0.g.c.i.c.c("installSuccess", this.f10844b, this.f10845c);
                        }
                        this.f10846d.f10826a.b(valueOf, new c.a.p0.g.c.g.c(this.f10843a));
                    }
                }
                this.f10846d.C(valueOf);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g implements c.a.p0.g.c.f.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Download f10847a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f10848b;

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
            this.f10848b = aVar;
            this.f10847a = download;
        }

        @Override // c.a.p0.g.c.f.b
        public void b(c.a.p0.g.c.g.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
                String valueOf = String.valueOf(this.f10847a.getId());
                if (bVar != null) {
                    if (bVar.d()) {
                        this.f10848b.f10826a.b(valueOf, new c.a.p0.g.c.g.c(this.f10847a));
                    } else {
                        this.f10848b.f10826a.b(valueOf, bVar);
                    }
                }
                this.f10848b.C(valueOf);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static /* synthetic */ class h {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f10849a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1343703315, "Lc/a/p0/g/c/a$h;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1343703315, "Lc/a/p0/g/c/a$h;");
                    return;
                }
            }
            int[] iArr = new int[Download.DownloadState.values().length];
            f10849a = iArr;
            try {
                iArr[Download.DownloadState.FINISH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f10849a[Download.DownloadState.CANCEL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f10849a[Download.DownloadState.FAILED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f10849a[Download.DownloadState.WAITING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f10849a[Download.DownloadState.DOWNLOADING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f10849a[Download.DownloadState.PAUSE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public class i implements c.a.p0.g.c.f.b {
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

        @Override // c.a.p0.g.c.f.b
        public void b(c.a.p0.g.c.g.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1187427241, "Lc/a/p0/g/c/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1187427241, "Lc/a/p0/g/c/a;");
                return;
            }
        }
        f10824h = k.f7085a;
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
        this.f10826a = new c.a.p0.g.c.b();
        this.f10827b = new c.a.p0.g.c.b();
        this.f10832g = 0L;
        DownloadManager downloadManager = DownloadManager.getInstance(AppRuntime.getAppContext());
        this.f10828c = downloadManager;
        c.a.p0.g.c.d.c cVar = new c.a.p0.g.c.d.c(downloadManager);
        this.f10829d = cVar;
        cVar.e();
        this.f10829d.m();
        A();
        z();
        if (f10824h) {
            this.f10828c.registerOnProgressChangeListener(new C0541a(this));
        }
        c.a.p0.g.c.h.a.f().j();
        F();
        o();
    }

    public static a n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            if (f10825i == null) {
                synchronized (a.class) {
                    if (f10825i == null) {
                        f10825i = new a();
                    }
                }
            }
            return f10825i;
        }
        return (a) invokeV.objValue;
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f10828c.registerOnStateChangeListener(new d(this));
        }
    }

    public void B(String str, c.a.p0.g.c.f.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, bVar) == null) {
            this.f10827b.g(str, bVar);
        }
    }

    public final void C(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.f10826a.f(str);
        }
    }

    public void D() {
        Collection<Download> x;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (x = this.f10829d.x()) == null || x.isEmpty()) {
            return;
        }
        for (Download download : x) {
            this.f10826a.a(String.valueOf(download.getId()), new i(this));
            if (!c.a.p0.h.t.a.d().a(download)) {
                c.a.p0.g.c.i.c.a(download.getKeyByUser(), "resumeAllDownload", "success", null, new c.a.p0.g.c.i.a(this.f10830e));
            }
        }
    }

    public void E(@NonNull JSONObject jSONObject, @NonNull c.a.p0.g.c.f.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, jSONObject, bVar) == null) {
            if (i()) {
                bVar.b(new c.a.p0.g.c.g.a(31006, "is not in main process"));
            } else if (!SwanAppNetworkUtils.i(null)) {
                bVar.b(new c.a.p0.g.c.g.a(31014, "network is not connected"));
            } else {
                String optString = jSONObject.optString("url");
                String optString2 = jSONObject.optString("packageName");
                if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                    Download u = this.f10829d.u(optString, optString2);
                    if (u == null) {
                        c.a.p0.g.c.d.d.b().e(jSONObject, bVar);
                        return;
                    }
                    String valueOf = String.valueOf(u.getId());
                    if (!this.f10826a.d(valueOf)) {
                        this.f10826a.a(String.valueOf(u.getId()), bVar);
                    }
                    if (u.getState() == Download.DownloadState.FINISH) {
                        new c.a.p0.g.c.e.c(u, this.f10830e).c(new b(this, valueOf, u));
                        return;
                    }
                    c.a.p0.g.c.i.c.a(optString2, "resumeDownload", null, null, new c.a.p0.g.c.i.a(this.f10830e));
                    this.f10828c.resume(u.getId().longValue());
                    return;
                }
                bVar.b(new c.a.p0.g.c.g.a(31007, "invalid params"));
            }
        }
    }

    public final void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.f10831f == null) {
                this.f10831f = new AppDownloadNetworkStateReceiver();
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            c.a.p0.a.c1.a.b().registerReceiver(this.f10831f, intentFilter);
        }
    }

    public void G(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        this.f10830e = jSONObject;
    }

    public void H(String str, String str2, String str3, @NonNull c.a.p0.g.c.f.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048583, this, str, str2, str3, bVar) == null) {
            if (i()) {
                bVar.b(new c.a.p0.g.c.g.a(31006, "is not in main process"));
            } else if (!SwanAppNetworkUtils.i(null)) {
                bVar.b(new c.a.p0.g.c.g.a(31014, "network is not connected"));
            } else if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                if (c.a.p0.g.c.e.a.h(AppRuntime.getAppContext(), str2)) {
                    bVar.b(new c.a.p0.g.c.g.a(31005, "apk is already installed"));
                } else if (j(str, bVar)) {
                    c.a.p0.g.c.d.a aVar = new c.a.p0.g.c.d.a();
                    aVar.g(str);
                    aVar.f(str2);
                    aVar.a(str3);
                    Download b2 = aVar.b();
                    this.f10828c.start(b2);
                    if (b2.getId() != null) {
                        this.f10826a.a(String.valueOf(b2.getId()), bVar);
                    }
                    if (c.a.p0.h.t.a.d().a(b2)) {
                        return;
                    }
                    c.a.p0.g.c.i.c.a(str2, "startDownload", null, null, new c.a.p0.g.c.i.a(this.f10830e));
                    c.a.p0.g.c.i.c.d(1, str2, str3, str);
                }
            } else {
                bVar.b(new c.a.p0.g.c.g.a(31007, "invalid params"));
            }
        }
    }

    public final void h(Download download, c.a.p0.g.c.f.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, download, bVar) == null) || download.getId() == null) {
            return;
        }
        this.f10826a.a(String.valueOf(download.getId()), bVar);
    }

    public final boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? !ProcessUtils.isMainProcess() : invokeV.booleanValue;
    }

    public boolean j(String str, c.a.p0.g.c.f.b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, str, bVar)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.f10832g < 1000) {
                if (k.f7085a) {
                    String str2 = "interval is " + (currentTimeMillis - this.f10832g);
                }
                return false;
            }
            this.f10832g = currentTimeMillis;
            Download v = this.f10829d.v(str);
            if (v == null) {
                return true;
            }
            Download.DownloadState state = v.getState();
            if (k.f7085a) {
                String str3 = "current state is " + state.name();
            }
            int i2 = h.f10849a[state.ordinal()];
            if (i2 == 1) {
                h(v, bVar);
                s(v);
                return false;
            } else if (i2 == 4 || i2 == 5) {
                h(v, bVar);
                boolean z = k.f7085a;
                return false;
            } else if (i2 != 6) {
                this.f10829d.g(str);
                return true;
            } else {
                h(v, bVar);
                this.f10828c.resume(v.getId().longValue());
                boolean z2 = k.f7085a;
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public synchronized void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            synchronized (this) {
                this.f10829d.d();
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
                    if (f10824h) {
                        e2.printStackTrace();
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void m(@NonNull JSONObject jSONObject, @NonNull c.a.p0.g.c.f.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, jSONObject, bVar) == null) {
            if (i()) {
                bVar.b(new c.a.p0.g.c.g.a(31006, "is not in main process"));
                return;
            }
            String optString = jSONObject.optString("url");
            String optString2 = jSONObject.optString("packageName");
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                Collection<Download> r = this.f10829d.r(optString);
                if (r != null && !r.isEmpty()) {
                    Iterator<Download> it = r.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        Download next = it.next();
                        if (next != null && next.getState() == Download.DownloadState.FINISH) {
                            c.a.p0.h.t.a.c().c(optString);
                            break;
                        }
                    }
                    c.a.p0.g.c.i.c.a(optString2, "deleteDownload", null, null, new c.a.p0.g.c.i.a(this.f10830e));
                    this.f10829d.h(r);
                    bVar.b(new c.a.p0.g.c.g.c(r));
                    return;
                }
                c.a.p0.g.c.d.d.b().a(jSONObject, bVar);
                return;
            }
            bVar.b(new c.a.p0.g.c.g.a(31007, "invalid params"));
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            c.a.p0.g.i.d.a.c().d();
        }
    }

    public final void p(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            if (!this.f10829d.b(str)) {
                String i2 = this.f10829d.i(str);
                if (TextUtils.isEmpty(i2) || !this.f10829d.c(i2)) {
                    return;
                }
                c.a.p0.g.c.i.c.a(str, "installHijack", null, null, new c.a.p0.g.c.i.a(this.f10830e));
                return;
            }
            c.a.p0.g.c.i.c.a(str, "installApp", "success", null, new c.a.p0.g.c.i.a(this.f10830e));
            Download o = this.f10829d.o(str);
            if (o != null) {
                c.a.p0.g.c.i.c.d(3, str, new c.a.p0.g.c.d.a(o).c(), o.getUrl());
            }
        }
    }

    public void q(String str, String str2) {
        Download w;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048592, this, str, str2) == null) || (w = this.f10829d.w(str)) == null) {
            return;
        }
        c.a.p0.g.c.e.c cVar = new c.a.p0.g.c.e.c(w, this.f10830e);
        if (!TextUtils.isEmpty(str2)) {
            c.a.p0.g.c.i.c.c("notifyInstall", str2, str);
        }
        cVar.c(new f(this, w, str2, str));
    }

    public String r(Context context, String str, String str2, @NonNull c.a.p0.g.c.f.a aVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048593, this, context, str, str2, aVar)) == null) {
            if (i()) {
                aVar.b(new c.a.p0.g.c.g.a(31006, "is not in main process"));
                return null;
            } else if (TextUtils.isEmpty(str)) {
                aVar.b(new c.a.p0.g.c.g.a(31007, "invalid params"));
                return null;
            } else {
                Download o = this.f10829d.o(str2);
                if (o == null) {
                    aVar.b(new c.a.p0.g.c.g.a(31008, "download is not exist"));
                    this.f10829d.g(str);
                    return null;
                } else if (o.getCurrentbytes().longValue() < o.getTotalbytes().longValue()) {
                    aVar.b(new c.a.p0.g.c.g.a(31017, "download is not finished"));
                    this.f10829d.g(str);
                    return null;
                } else {
                    String realDownloadDir = o.getRealDownloadDir();
                    String fileName = o.getFileName();
                    if (f10824h) {
                        String str3 = "installApp packageName:" + str2 + ",fileDir:" + realDownloadDir + ",fileName:" + fileName;
                    }
                    if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(realDownloadDir) || TextUtils.isEmpty(fileName)) {
                        aVar.b(new c.a.p0.g.c.g.a(31001, "database no package or file name"));
                        this.f10829d.g(str);
                    }
                    String str4 = realDownloadDir + File.separator + fileName;
                    if (c.a.p0.g.c.e.a.h(AppRuntime.getAppContext(), str2)) {
                        p(str2);
                        aVar.b(new c.a.p0.g.c.g.c("apk is already installed"));
                        l(str4);
                        return null;
                    }
                    File file = new File(str4);
                    if (file.isFile() && file.exists()) {
                        if (k0.c() <= file.length()) {
                            aVar.b(new c.a.p0.g.c.g.a(31020, "not enough space to install"));
                            return null;
                        }
                        aVar.setPackageName(str2);
                        aVar.a(str4);
                        this.f10827b.a(str2, aVar);
                        if (!c.a.p0.g.c.e.a.j(context, str4, false)) {
                            t(str2);
                            B(str2, aVar);
                            aVar.b(new c.a.p0.g.c.g.a(31004, "apk install fail"));
                            this.f10829d.g(str);
                        } else {
                            long length = ((file.length() / 104857600) + 1) * 1000;
                            String c2 = c.a.p0.g.c.e.a.c();
                            if (c.a.p0.g.c.e.a.k(c2)) {
                                c.a.p0.a.a2.d.i().postDelayed(new c(this, c2, str2), length);
                            }
                        }
                        return str2;
                    }
                    aVar.b(new c.a.p0.g.c.g.a(31002, "file is not exist"));
                    this.f10829d.g(str);
                    return null;
                }
            }
        }
        return (String) invokeLLLL.objValue;
    }

    public final void s(Download download) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, download) == null) {
            new c.a.p0.g.c.e.c(download, this.f10830e).c(new g(this, download));
        }
    }

    public void t(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            for (Download download : this.f10829d.p(str)) {
                if (download != null) {
                    c.a.p0.g.c.h.a.f().a(download);
                }
            }
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            this.f10829d.m();
        }
    }

    public void v(@NonNull JSONObject jSONObject, @NonNull c.a.p0.g.c.f.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048597, this, jSONObject, bVar) == null) {
            if (i()) {
                bVar.b(new c.a.p0.g.c.g.a(31006, "is not in main process"));
                return;
            }
            String optString = jSONObject.optString("url");
            String optString2 = jSONObject.optString("packageName");
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                Download u = this.f10829d.u(optString, optString2);
                if (u == null) {
                    c.a.p0.g.c.d.d.b().c(jSONObject, bVar);
                    return;
                } else if (u.getState() != Download.DownloadState.WAITING && u.getState() != Download.DownloadState.DOWNLOADING) {
                    bVar.b(new c.a.p0.g.c.g.a(31013, "download is not started"));
                    return;
                } else {
                    c.a.p0.g.c.i.c.a(optString2, "pauseDownload", null, null, new c.a.p0.g.c.i.a(this.f10830e));
                    this.f10828c.pause(u.getId().longValue());
                    bVar.b(new c.a.p0.g.c.g.c(u));
                    return;
                }
            }
            bVar.b(new c.a.p0.g.c.g.a(31007, "invalid params"));
        }
    }

    public void w(@NonNull c.a.p0.g.c.f.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, bVar) == null) {
            if (i()) {
                bVar.b(new c.a.p0.g.c.g.a(31006, "is not in main process"));
                return;
            }
            Collection<Download> n = this.f10829d.n();
            if (n != null && !n.isEmpty()) {
                bVar.b(new c.a.p0.g.c.g.c(n));
            } else {
                bVar.b(new c.a.p0.g.c.g.a(31008, "download is not exist"));
            }
        }
    }

    public void x(@NonNull JSONObject jSONObject, @NonNull c.a.p0.g.c.f.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048599, this, jSONObject, bVar) == null) {
            if (i()) {
                bVar.b(new c.a.p0.g.c.g.a(31006, "is not in main process"));
                return;
            }
            String optString = jSONObject.optString("url");
            if (TextUtils.isEmpty(optString)) {
                bVar.b(new c.a.p0.g.c.g.a(31007, "invalid params"));
                return;
            }
            Download v = this.f10829d.v(optString);
            if (v == null) {
                c.a.p0.g.c.d.d.b().d(jSONObject, bVar);
            } else {
                bVar.b(new c.a.p0.g.c.g.c(v));
            }
        }
    }

    public Download y(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, str)) == null) ? this.f10829d.v(str) : (Download) invokeL.objValue;
    }

    public final synchronized void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            synchronized (this) {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addDataScheme(AsInstallService.SCHEME_PACKAGE_ADDED);
                intentFilter.addAction(PackageChangedReceiver.ACTION_INSTALL);
                AppRuntime.getAppContext().registerReceiver(new e(this), intentFilter);
            }
        }
    }
}
