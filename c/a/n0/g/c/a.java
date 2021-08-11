package c.a.n0.g.c;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.k;
import c.a.n0.a.v2.k0;
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
    public static final boolean f10542h;

    /* renamed from: i  reason: collision with root package name */
    public static volatile a f10543i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c.a.n0.g.c.b f10544a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.n0.g.c.b f10545b;

    /* renamed from: c  reason: collision with root package name */
    public DownloadManager f10546c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.n0.g.c.d.c f10547d;

    /* renamed from: e  reason: collision with root package name */
    public JSONObject f10548e;

    /* renamed from: f  reason: collision with root package name */
    public AppDownloadNetworkStateReceiver f10549f;

    /* renamed from: g  reason: collision with root package name */
    public long f10550g;

    /* renamed from: c.a.n0.g.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0531a implements DownloadManager.OnProgressChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C0531a(a aVar) {
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
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j2), Integer.valueOf(i2), Long.valueOf(j3)}) == null) && k.f6803a) {
                String str = "onProgressChanged downloadId = " + j2 + ",percentage = " + i2 + ",speed = " + j3;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements c.a.n0.g.c.f.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f10551a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Download f10552b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f10553c;

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
            this.f10553c = aVar;
            this.f10551a = str;
            this.f10552b = download;
        }

        @Override // c.a.n0.g.c.f.b
        public void b(c.a.n0.g.c.g.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
                if (bVar != null) {
                    if (bVar.d()) {
                        this.f10553c.f10544a.b(this.f10551a, new c.a.n0.g.c.g.c(this.f10552b));
                    } else {
                        this.f10553c.f10544a.b(this.f10551a, bVar);
                    }
                }
                this.f10553c.C(this.f10551a);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f10554e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f10555f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f10556g;

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
            this.f10556g = aVar;
            this.f10554e = str;
            this.f10555f = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || c.a.n0.a.g1.g.a().b()) {
                return;
            }
            boolean unused = a.f10542h;
            Intent intent = new Intent(AppRuntime.getAppContext(), InstallAntiBlockingActivity.class);
            intent.putExtra("type", this.f10554e);
            intent.putExtra("packageName", this.f10555f);
            if (this.f10556g.f10548e != null) {
                intent.putExtra("ubc_params", this.f10556g.f10548e.toString());
            }
            intent.setFlags(276824064);
            c.a.n0.a.v2.f.g(AppRuntime.getAppContext(), intent);
        }
    }

    /* loaded from: classes3.dex */
    public class d implements DownloadManager.OnStateChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f10557a;

        /* renamed from: c.a.n0.g.c.a$d$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0532a implements c.a.n0.g.c.f.b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f10558a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Download f10559b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ d f10560c;

            public C0532a(d dVar, String str, Download download) {
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
                this.f10560c = dVar;
                this.f10558a = str;
                this.f10559b = download;
            }

            @Override // c.a.n0.g.c.f.b
            public void b(c.a.n0.g.c.g.b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
                    if (bVar != null) {
                        if (bVar.d()) {
                            this.f10560c.f10557a.f10544a.b(this.f10558a, new c.a.n0.g.c.g.c(this.f10559b));
                        } else {
                            this.f10560c.f10557a.f10544a.b(this.f10558a, bVar);
                        }
                    }
                    this.f10560c.f10557a.C(this.f10558a);
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
            this.f10557a = aVar;
        }

        @Override // com.baidu.down.manage.DownloadManager.OnStateChangeListener
        public void onStateChanged(long j2, Download download) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJL(1048576, this, j2, download) == null) || download == null || download.getId() == null) {
                return;
            }
            String valueOf = String.valueOf(download.getId());
            if (a.f10542h) {
                String str = "onStateChanged downloadId = " + j2 + ",eventType:" + valueOf + ",download = " + download;
            }
            if (download.getState() == Download.DownloadState.FINISH) {
                if (!c.a.n0.h.t.a.d().a(download)) {
                    c.a.n0.g.c.i.c.a(download.getKeyByUser(), "startDownload", "success", null, new c.a.n0.g.c.i.a(this.f10557a.f10548e));
                    c.a.n0.g.c.i.c.d(2, download.getKeyByUser(), new c.a.n0.g.c.d.a(download).c(), download.getUrl());
                }
                c.a.n0.g.c.h.a.f().m(download, true, "downloadfinish");
            }
            if (this.f10557a.f10544a.d(valueOf)) {
                int i2 = h.f10567a[download.getState().ordinal()];
                if (i2 == 1) {
                    this.f10557a.f10547d.f();
                    c.a.n0.h.t.a.c().b(download.getUrl(), download.getFileName(), download.getRealDownloadDir(), String.valueOf(download.getTotalbytes()), String.valueOf(download.getCurrentbytes()));
                    new c.a.n0.g.c.e.c(download, this.f10557a.f10548e).c(new C0532a(this, valueOf, download));
                    if (c.a.n0.h.t.a.d().a(download)) {
                        c.a.n0.h.t.a.d().b(download);
                    }
                } else if (i2 == 2) {
                    this.f10557a.f10544a.b(valueOf, new c.a.n0.g.c.g.a(31015, "download is canceled"));
                    this.f10557a.C(valueOf);
                } else if (i2 != 3) {
                } else {
                    this.f10557a.f10544a.b(valueOf, new c.a.n0.g.c.g.a(download.getFailedType().intValue(), TextUtils.isEmpty(download.getFailedReason()) ? "download is failed" : download.getFailedReason()));
                    this.f10557a.C(valueOf);
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
            if (a.f10542h) {
                String str = "AddPackageReceiver packageName = " + schemeSpecificPart;
            }
            Download o = this.this$0.f10547d.o(schemeSpecificPart);
            if (!c.a.n0.h.t.a.d().a(o)) {
                this.this$0.p(schemeSpecificPart);
            } else {
                c.a.n0.h.t.a.d().c(o);
            }
            this.this$0.t(schemeSpecificPart);
            this.this$0.f10545b.b(schemeSpecificPart, new c.a.n0.g.c.g.c((String) null));
            this.this$0.B(schemeSpecificPart, null);
        }
    }

    /* loaded from: classes3.dex */
    public class f implements c.a.n0.g.c.f.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Download f10561a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f10562b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f10563c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ a f10564d;

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
            this.f10564d = aVar;
            this.f10561a = download;
            this.f10562b = str;
            this.f10563c = str2;
        }

        @Override // c.a.n0.g.c.f.b
        public void b(c.a.n0.g.c.g.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
                String valueOf = String.valueOf(this.f10561a.getId());
                if (bVar != null) {
                    if (!bVar.d()) {
                        this.f10564d.f10544a.b(valueOf, bVar);
                    } else {
                        if (!TextUtils.isEmpty(this.f10562b)) {
                            c.a.n0.g.c.i.c.c("installSuccess", this.f10562b, this.f10563c);
                        }
                        this.f10564d.f10544a.b(valueOf, new c.a.n0.g.c.g.c(this.f10561a));
                    }
                }
                this.f10564d.C(valueOf);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g implements c.a.n0.g.c.f.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Download f10565a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f10566b;

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
            this.f10566b = aVar;
            this.f10565a = download;
        }

        @Override // c.a.n0.g.c.f.b
        public void b(c.a.n0.g.c.g.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
                String valueOf = String.valueOf(this.f10565a.getId());
                if (bVar != null) {
                    if (bVar.d()) {
                        this.f10566b.f10544a.b(valueOf, new c.a.n0.g.c.g.c(this.f10565a));
                    } else {
                        this.f10566b.f10544a.b(valueOf, bVar);
                    }
                }
                this.f10566b.C(valueOf);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static /* synthetic */ class h {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f10567a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(642638737, "Lc/a/n0/g/c/a$h;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(642638737, "Lc/a/n0/g/c/a$h;");
                    return;
                }
            }
            int[] iArr = new int[Download.DownloadState.values().length];
            f10567a = iArr;
            try {
                iArr[Download.DownloadState.FINISH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f10567a[Download.DownloadState.CANCEL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f10567a[Download.DownloadState.FAILED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f10567a[Download.DownloadState.WAITING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f10567a[Download.DownloadState.DOWNLOADING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f10567a[Download.DownloadState.PAUSE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public class i implements c.a.n0.g.c.f.b {
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

        @Override // c.a.n0.g.c.f.b
        public void b(c.a.n0.g.c.g.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1867485611, "Lc/a/n0/g/c/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1867485611, "Lc/a/n0/g/c/a;");
                return;
            }
        }
        f10542h = k.f6803a;
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
        this.f10544a = new c.a.n0.g.c.b();
        this.f10545b = new c.a.n0.g.c.b();
        this.f10550g = 0L;
        DownloadManager downloadManager = DownloadManager.getInstance(AppRuntime.getAppContext());
        this.f10546c = downloadManager;
        c.a.n0.g.c.d.c cVar = new c.a.n0.g.c.d.c(downloadManager);
        this.f10547d = cVar;
        cVar.e();
        this.f10547d.m();
        A();
        z();
        if (f10542h) {
            this.f10546c.registerOnProgressChangeListener(new C0531a(this));
        }
        c.a.n0.g.c.h.a.f().j();
        F();
        o();
    }

    public static a n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            if (f10543i == null) {
                synchronized (a.class) {
                    if (f10543i == null) {
                        f10543i = new a();
                    }
                }
            }
            return f10543i;
        }
        return (a) invokeV.objValue;
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f10546c.registerOnStateChangeListener(new d(this));
        }
    }

    public void B(String str, c.a.n0.g.c.f.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, bVar) == null) {
            this.f10545b.g(str, bVar);
        }
    }

    public final void C(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.f10544a.f(str);
        }
    }

    public void D() {
        Collection<Download> x;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (x = this.f10547d.x()) == null || x.isEmpty()) {
            return;
        }
        for (Download download : x) {
            this.f10544a.a(String.valueOf(download.getId()), new i(this));
            if (!c.a.n0.h.t.a.d().a(download)) {
                c.a.n0.g.c.i.c.a(download.getKeyByUser(), "resumeAllDownload", "success", null, new c.a.n0.g.c.i.a(this.f10548e));
            }
        }
    }

    public void E(@NonNull JSONObject jSONObject, @NonNull c.a.n0.g.c.f.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, jSONObject, bVar) == null) {
            if (i()) {
                bVar.b(new c.a.n0.g.c.g.a(31006, "is not in main process"));
            } else if (!SwanAppNetworkUtils.i(null)) {
                bVar.b(new c.a.n0.g.c.g.a(31014, "network is not connected"));
            } else {
                String optString = jSONObject.optString("url");
                String optString2 = jSONObject.optString("packageName");
                if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                    Download u = this.f10547d.u(optString, optString2);
                    if (u == null) {
                        c.a.n0.g.c.d.d.b().e(jSONObject, bVar);
                        return;
                    }
                    String valueOf = String.valueOf(u.getId());
                    if (!this.f10544a.d(valueOf)) {
                        this.f10544a.a(String.valueOf(u.getId()), bVar);
                    }
                    if (u.getState() == Download.DownloadState.FINISH) {
                        new c.a.n0.g.c.e.c(u, this.f10548e).c(new b(this, valueOf, u));
                        return;
                    }
                    c.a.n0.g.c.i.c.a(optString2, "resumeDownload", null, null, new c.a.n0.g.c.i.a(this.f10548e));
                    this.f10546c.resume(u.getId().longValue());
                    return;
                }
                bVar.b(new c.a.n0.g.c.g.a(31007, "invalid params"));
            }
        }
    }

    public final void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.f10549f == null) {
                this.f10549f = new AppDownloadNetworkStateReceiver();
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            c.a.n0.a.c1.a.b().registerReceiver(this.f10549f, intentFilter);
        }
    }

    public void G(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        this.f10548e = jSONObject;
    }

    public void H(String str, String str2, String str3, @NonNull c.a.n0.g.c.f.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048583, this, str, str2, str3, bVar) == null) {
            if (i()) {
                bVar.b(new c.a.n0.g.c.g.a(31006, "is not in main process"));
            } else if (!SwanAppNetworkUtils.i(null)) {
                bVar.b(new c.a.n0.g.c.g.a(31014, "network is not connected"));
            } else if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                if (c.a.n0.g.c.e.a.h(AppRuntime.getAppContext(), str2)) {
                    bVar.b(new c.a.n0.g.c.g.a(31005, "apk is already installed"));
                } else if (j(str, bVar)) {
                    c.a.n0.g.c.d.a aVar = new c.a.n0.g.c.d.a();
                    aVar.g(str);
                    aVar.f(str2);
                    aVar.a(str3);
                    Download b2 = aVar.b();
                    this.f10546c.start(b2);
                    if (b2.getId() != null) {
                        this.f10544a.a(String.valueOf(b2.getId()), bVar);
                    }
                    if (c.a.n0.h.t.a.d().a(b2)) {
                        return;
                    }
                    c.a.n0.g.c.i.c.a(str2, "startDownload", null, null, new c.a.n0.g.c.i.a(this.f10548e));
                    c.a.n0.g.c.i.c.d(1, str2, str3, str);
                }
            } else {
                bVar.b(new c.a.n0.g.c.g.a(31007, "invalid params"));
            }
        }
    }

    public final void h(Download download, c.a.n0.g.c.f.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, download, bVar) == null) || download.getId() == null) {
            return;
        }
        this.f10544a.a(String.valueOf(download.getId()), bVar);
    }

    public final boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? !ProcessUtils.isMainProcess() : invokeV.booleanValue;
    }

    public boolean j(String str, c.a.n0.g.c.f.b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, str, bVar)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.f10550g < 1000) {
                if (k.f6803a) {
                    String str2 = "interval is " + (currentTimeMillis - this.f10550g);
                }
                return false;
            }
            this.f10550g = currentTimeMillis;
            Download v = this.f10547d.v(str);
            if (v == null) {
                return true;
            }
            Download.DownloadState state = v.getState();
            if (k.f6803a) {
                String str3 = "current state is " + state.name();
            }
            int i2 = h.f10567a[state.ordinal()];
            if (i2 == 1) {
                h(v, bVar);
                s(v);
                return false;
            } else if (i2 == 4 || i2 == 5) {
                h(v, bVar);
                boolean z = k.f6803a;
                return false;
            } else if (i2 != 6) {
                this.f10547d.g(str);
                return true;
            } else {
                h(v, bVar);
                this.f10546c.resume(v.getId().longValue());
                boolean z2 = k.f6803a;
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public synchronized void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            synchronized (this) {
                this.f10547d.d();
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
                    if (f10542h) {
                        e2.printStackTrace();
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void m(@NonNull JSONObject jSONObject, @NonNull c.a.n0.g.c.f.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, jSONObject, bVar) == null) {
            if (i()) {
                bVar.b(new c.a.n0.g.c.g.a(31006, "is not in main process"));
                return;
            }
            String optString = jSONObject.optString("url");
            String optString2 = jSONObject.optString("packageName");
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                Collection<Download> r = this.f10547d.r(optString);
                if (r != null && !r.isEmpty()) {
                    Iterator<Download> it = r.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        Download next = it.next();
                        if (next != null && next.getState() == Download.DownloadState.FINISH) {
                            c.a.n0.h.t.a.c().c(optString);
                            break;
                        }
                    }
                    c.a.n0.g.c.i.c.a(optString2, "deleteDownload", null, null, new c.a.n0.g.c.i.a(this.f10548e));
                    this.f10547d.h(r);
                    bVar.b(new c.a.n0.g.c.g.c(r));
                    return;
                }
                c.a.n0.g.c.d.d.b().a(jSONObject, bVar);
                return;
            }
            bVar.b(new c.a.n0.g.c.g.a(31007, "invalid params"));
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            c.a.n0.g.i.d.a.c().d();
        }
    }

    public final void p(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            if (!this.f10547d.b(str)) {
                String i2 = this.f10547d.i(str);
                if (TextUtils.isEmpty(i2) || !this.f10547d.c(i2)) {
                    return;
                }
                c.a.n0.g.c.i.c.a(str, "installHijack", null, null, new c.a.n0.g.c.i.a(this.f10548e));
                return;
            }
            c.a.n0.g.c.i.c.a(str, "installApp", "success", null, new c.a.n0.g.c.i.a(this.f10548e));
            Download o = this.f10547d.o(str);
            if (o != null) {
                c.a.n0.g.c.i.c.d(3, str, new c.a.n0.g.c.d.a(o).c(), o.getUrl());
            }
        }
    }

    public void q(String str, String str2) {
        Download w;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048592, this, str, str2) == null) || (w = this.f10547d.w(str)) == null) {
            return;
        }
        c.a.n0.g.c.e.c cVar = new c.a.n0.g.c.e.c(w, this.f10548e);
        if (!TextUtils.isEmpty(str2)) {
            c.a.n0.g.c.i.c.c("notifyInstall", str2, str);
        }
        cVar.c(new f(this, w, str2, str));
    }

    public String r(Context context, String str, String str2, @NonNull c.a.n0.g.c.f.a aVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048593, this, context, str, str2, aVar)) == null) {
            if (i()) {
                aVar.b(new c.a.n0.g.c.g.a(31006, "is not in main process"));
                return null;
            } else if (TextUtils.isEmpty(str)) {
                aVar.b(new c.a.n0.g.c.g.a(31007, "invalid params"));
                return null;
            } else {
                Download o = this.f10547d.o(str2);
                if (o == null) {
                    aVar.b(new c.a.n0.g.c.g.a(31008, "download is not exist"));
                    this.f10547d.g(str);
                    return null;
                } else if (o.getCurrentbytes().longValue() < o.getTotalbytes().longValue()) {
                    aVar.b(new c.a.n0.g.c.g.a(31017, "download is not finished"));
                    this.f10547d.g(str);
                    return null;
                } else {
                    String realDownloadDir = o.getRealDownloadDir();
                    String fileName = o.getFileName();
                    if (f10542h) {
                        String str3 = "installApp packageName:" + str2 + ",fileDir:" + realDownloadDir + ",fileName:" + fileName;
                    }
                    if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(realDownloadDir) || TextUtils.isEmpty(fileName)) {
                        aVar.b(new c.a.n0.g.c.g.a(31001, "database no package or file name"));
                        this.f10547d.g(str);
                    }
                    String str4 = realDownloadDir + File.separator + fileName;
                    if (c.a.n0.g.c.e.a.h(AppRuntime.getAppContext(), str2)) {
                        p(str2);
                        aVar.b(new c.a.n0.g.c.g.c("apk is already installed"));
                        l(str4);
                        return null;
                    }
                    File file = new File(str4);
                    if (file.isFile() && file.exists()) {
                        if (k0.c() <= file.length()) {
                            aVar.b(new c.a.n0.g.c.g.a(31020, "not enough space to install"));
                            return null;
                        }
                        aVar.setPackageName(str2);
                        aVar.a(str4);
                        this.f10545b.a(str2, aVar);
                        if (!c.a.n0.g.c.e.a.j(context, str4, false)) {
                            t(str2);
                            B(str2, aVar);
                            aVar.b(new c.a.n0.g.c.g.a(31004, "apk install fail"));
                            this.f10547d.g(str);
                        } else {
                            long length = ((file.length() / 104857600) + 1) * 1000;
                            String c2 = c.a.n0.g.c.e.a.c();
                            if (c.a.n0.g.c.e.a.k(c2)) {
                                c.a.n0.a.a2.d.i().postDelayed(new c(this, c2, str2), length);
                            }
                        }
                        return str2;
                    }
                    aVar.b(new c.a.n0.g.c.g.a(31002, "file is not exist"));
                    this.f10547d.g(str);
                    return null;
                }
            }
        }
        return (String) invokeLLLL.objValue;
    }

    public final void s(Download download) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, download) == null) {
            new c.a.n0.g.c.e.c(download, this.f10548e).c(new g(this, download));
        }
    }

    public void t(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            for (Download download : this.f10547d.p(str)) {
                if (download != null) {
                    c.a.n0.g.c.h.a.f().a(download);
                }
            }
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            this.f10547d.m();
        }
    }

    public void v(@NonNull JSONObject jSONObject, @NonNull c.a.n0.g.c.f.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048597, this, jSONObject, bVar) == null) {
            if (i()) {
                bVar.b(new c.a.n0.g.c.g.a(31006, "is not in main process"));
                return;
            }
            String optString = jSONObject.optString("url");
            String optString2 = jSONObject.optString("packageName");
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                Download u = this.f10547d.u(optString, optString2);
                if (u == null) {
                    c.a.n0.g.c.d.d.b().c(jSONObject, bVar);
                    return;
                } else if (u.getState() != Download.DownloadState.WAITING && u.getState() != Download.DownloadState.DOWNLOADING) {
                    bVar.b(new c.a.n0.g.c.g.a(31013, "download is not started"));
                    return;
                } else {
                    c.a.n0.g.c.i.c.a(optString2, "pauseDownload", null, null, new c.a.n0.g.c.i.a(this.f10548e));
                    this.f10546c.pause(u.getId().longValue());
                    bVar.b(new c.a.n0.g.c.g.c(u));
                    return;
                }
            }
            bVar.b(new c.a.n0.g.c.g.a(31007, "invalid params"));
        }
    }

    public void w(@NonNull c.a.n0.g.c.f.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, bVar) == null) {
            if (i()) {
                bVar.b(new c.a.n0.g.c.g.a(31006, "is not in main process"));
                return;
            }
            Collection<Download> n = this.f10547d.n();
            if (n != null && !n.isEmpty()) {
                bVar.b(new c.a.n0.g.c.g.c(n));
            } else {
                bVar.b(new c.a.n0.g.c.g.a(31008, "download is not exist"));
            }
        }
    }

    public void x(@NonNull JSONObject jSONObject, @NonNull c.a.n0.g.c.f.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048599, this, jSONObject, bVar) == null) {
            if (i()) {
                bVar.b(new c.a.n0.g.c.g.a(31006, "is not in main process"));
                return;
            }
            String optString = jSONObject.optString("url");
            if (TextUtils.isEmpty(optString)) {
                bVar.b(new c.a.n0.g.c.g.a(31007, "invalid params"));
                return;
            }
            Download v = this.f10547d.v(optString);
            if (v == null) {
                c.a.n0.g.c.d.d.b().d(jSONObject, bVar);
            } else {
                bVar.b(new c.a.n0.g.c.g.c(v));
            }
        }
    }

    public Download y(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, str)) == null) ? this.f10547d.v(str) : (Download) invokeL.objValue;
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
