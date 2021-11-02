package b.a.p0.g.c;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.k;
import b.a.p0.a.v2.k0;
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
    public static final boolean f10030h;

    /* renamed from: i  reason: collision with root package name */
    public static volatile a f10031i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public b.a.p0.g.c.b f10032a;

    /* renamed from: b  reason: collision with root package name */
    public b.a.p0.g.c.b f10033b;

    /* renamed from: c  reason: collision with root package name */
    public DownloadManager f10034c;

    /* renamed from: d  reason: collision with root package name */
    public b.a.p0.g.c.d.c f10035d;

    /* renamed from: e  reason: collision with root package name */
    public JSONObject f10036e;

    /* renamed from: f  reason: collision with root package name */
    public AppDownloadNetworkStateReceiver f10037f;

    /* renamed from: g  reason: collision with root package name */
    public long f10038g;

    /* renamed from: b.a.p0.g.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0536a implements DownloadManager.OnProgressChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C0536a(a aVar) {
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
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Integer.valueOf(i2), Long.valueOf(j2)}) == null) && k.f6397a) {
                String str = "onProgressChanged downloadId = " + j + ",percentage = " + i2 + ",speed = " + j2;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements b.a.p0.g.c.f.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f10039a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Download f10040b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f10041c;

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
            this.f10041c = aVar;
            this.f10039a = str;
            this.f10040b = download;
        }

        @Override // b.a.p0.g.c.f.b
        public void a(b.a.p0.g.c.g.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
                if (bVar != null) {
                    if (bVar.d()) {
                        this.f10041c.f10032a.b(this.f10039a, new b.a.p0.g.c.g.c(this.f10040b));
                    } else {
                        this.f10041c.f10032a.b(this.f10039a, bVar);
                    }
                }
                this.f10041c.C(this.f10039a);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f10042e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f10043f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f10044g;

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
            this.f10044g = aVar;
            this.f10042e = str;
            this.f10043f = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || b.a.p0.a.g1.g.a().b()) {
                return;
            }
            boolean unused = a.f10030h;
            Intent intent = new Intent(AppRuntime.getAppContext(), InstallAntiBlockingActivity.class);
            intent.putExtra("type", this.f10042e);
            intent.putExtra("packageName", this.f10043f);
            if (this.f10044g.f10036e != null) {
                intent.putExtra("ubc_params", this.f10044g.f10036e.toString());
            }
            intent.setFlags(276824064);
            b.a.p0.a.v2.f.g(AppRuntime.getAppContext(), intent);
        }
    }

    /* loaded from: classes4.dex */
    public class d implements DownloadManager.OnStateChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f10045a;

        /* renamed from: b.a.p0.g.c.a$d$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C0537a implements b.a.p0.g.c.f.b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f10046a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Download f10047b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ d f10048c;

            public C0537a(d dVar, String str, Download download) {
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
                this.f10048c = dVar;
                this.f10046a = str;
                this.f10047b = download;
            }

            @Override // b.a.p0.g.c.f.b
            public void a(b.a.p0.g.c.g.b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
                    if (bVar != null) {
                        if (bVar.d()) {
                            this.f10048c.f10045a.f10032a.b(this.f10046a, new b.a.p0.g.c.g.c(this.f10047b));
                        } else {
                            this.f10048c.f10045a.f10032a.b(this.f10046a, bVar);
                        }
                    }
                    this.f10048c.f10045a.C(this.f10046a);
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
            this.f10045a = aVar;
        }

        @Override // com.baidu.down.manage.DownloadManager.OnStateChangeListener
        public void onStateChanged(long j, Download download) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJL(1048576, this, j, download) == null) || download == null || download.getId() == null) {
                return;
            }
            String valueOf = String.valueOf(download.getId());
            if (a.f10030h) {
                String str = "onStateChanged downloadId = " + j + ",eventType:" + valueOf + ",download = " + download;
            }
            if (download.getState() == Download.DownloadState.FINISH) {
                if (!b.a.p0.h.t.a.d().a(download)) {
                    b.a.p0.g.c.i.c.a(download.getKeyByUser(), "startDownload", "success", null, new b.a.p0.g.c.i.a(this.f10045a.f10036e));
                    b.a.p0.g.c.i.c.d(2, download.getKeyByUser(), new b.a.p0.g.c.d.a(download).c(), download.getUrl());
                }
                b.a.p0.g.c.h.a.f().m(download, true, "downloadfinish");
            }
            if (this.f10045a.f10032a.d(valueOf)) {
                int i2 = h.f10055a[download.getState().ordinal()];
                if (i2 == 1) {
                    this.f10045a.f10035d.f();
                    b.a.p0.h.t.a.c().b(download.getUrl(), download.getFileName(), download.getRealDownloadDir(), String.valueOf(download.getTotalbytes()), String.valueOf(download.getCurrentbytes()));
                    new b.a.p0.g.c.e.c(download, this.f10045a.f10036e).c(new C0537a(this, valueOf, download));
                    if (b.a.p0.h.t.a.d().a(download)) {
                        b.a.p0.h.t.a.d().b(download);
                    }
                } else if (i2 == 2) {
                    this.f10045a.f10032a.b(valueOf, new b.a.p0.g.c.g.a(31015, "download is canceled"));
                    this.f10045a.C(valueOf);
                } else if (i2 != 3) {
                } else {
                    this.f10045a.f10032a.b(valueOf, new b.a.p0.g.c.g.a(download.getFailedType().intValue(), TextUtils.isEmpty(download.getFailedReason()) ? "download is failed" : download.getFailedReason()));
                    this.f10045a.C(valueOf);
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
            if (a.f10030h) {
                String str = "AddPackageReceiver packageName = " + schemeSpecificPart;
            }
            Download o = this.this$0.f10035d.o(schemeSpecificPart);
            if (!b.a.p0.h.t.a.d().a(o)) {
                this.this$0.p(schemeSpecificPart);
            } else {
                b.a.p0.h.t.a.d().c(o);
            }
            this.this$0.t(schemeSpecificPart);
            this.this$0.f10033b.b(schemeSpecificPart, new b.a.p0.g.c.g.c((String) null));
            this.this$0.B(schemeSpecificPart, null);
        }
    }

    /* loaded from: classes4.dex */
    public class f implements b.a.p0.g.c.f.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Download f10049a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f10050b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f10051c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ a f10052d;

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
            this.f10052d = aVar;
            this.f10049a = download;
            this.f10050b = str;
            this.f10051c = str2;
        }

        @Override // b.a.p0.g.c.f.b
        public void a(b.a.p0.g.c.g.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
                String valueOf = String.valueOf(this.f10049a.getId());
                if (bVar != null) {
                    if (!bVar.d()) {
                        this.f10052d.f10032a.b(valueOf, bVar);
                    } else {
                        if (!TextUtils.isEmpty(this.f10050b)) {
                            b.a.p0.g.c.i.c.c("installSuccess", this.f10050b, this.f10051c);
                        }
                        this.f10052d.f10032a.b(valueOf, new b.a.p0.g.c.g.c(this.f10049a));
                    }
                }
                this.f10052d.C(valueOf);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g implements b.a.p0.g.c.f.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Download f10053a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f10054b;

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
            this.f10054b = aVar;
            this.f10053a = download;
        }

        @Override // b.a.p0.g.c.f.b
        public void a(b.a.p0.g.c.g.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
                String valueOf = String.valueOf(this.f10053a.getId());
                if (bVar != null) {
                    if (bVar.d()) {
                        this.f10054b.f10032a.b(valueOf, new b.a.p0.g.c.g.c(this.f10053a));
                    } else {
                        this.f10054b.f10032a.b(valueOf, bVar);
                    }
                }
                this.f10054b.C(valueOf);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static /* synthetic */ class h {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f10055a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-163848494, "Lb/a/p0/g/c/a$h;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-163848494, "Lb/a/p0/g/c/a$h;");
                    return;
                }
            }
            int[] iArr = new int[Download.DownloadState.values().length];
            f10055a = iArr;
            try {
                iArr[Download.DownloadState.FINISH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f10055a[Download.DownloadState.CANCEL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f10055a[Download.DownloadState.FAILED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f10055a[Download.DownloadState.WAITING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f10055a[Download.DownloadState.DOWNLOADING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f10055a[Download.DownloadState.PAUSE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i implements b.a.p0.g.c.f.b {
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

        @Override // b.a.p0.g.c.f.b
        public void a(b.a.p0.g.c.g.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-894024234, "Lb/a/p0/g/c/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-894024234, "Lb/a/p0/g/c/a;");
                return;
            }
        }
        f10030h = k.f6397a;
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
        this.f10032a = new b.a.p0.g.c.b();
        this.f10033b = new b.a.p0.g.c.b();
        this.f10038g = 0L;
        DownloadManager downloadManager = DownloadManager.getInstance(AppRuntime.getAppContext());
        this.f10034c = downloadManager;
        b.a.p0.g.c.d.c cVar = new b.a.p0.g.c.d.c(downloadManager);
        this.f10035d = cVar;
        cVar.e();
        this.f10035d.m();
        A();
        z();
        if (f10030h) {
            this.f10034c.registerOnProgressChangeListener(new C0536a(this));
        }
        b.a.p0.g.c.h.a.f().j();
        F();
        o();
    }

    public static a n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            if (f10031i == null) {
                synchronized (a.class) {
                    if (f10031i == null) {
                        f10031i = new a();
                    }
                }
            }
            return f10031i;
        }
        return (a) invokeV.objValue;
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f10034c.registerOnStateChangeListener(new d(this));
        }
    }

    public void B(String str, b.a.p0.g.c.f.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, bVar) == null) {
            this.f10033b.g(str, bVar);
        }
    }

    public final void C(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.f10032a.f(str);
        }
    }

    public void D() {
        Collection<Download> x;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (x = this.f10035d.x()) == null || x.isEmpty()) {
            return;
        }
        for (Download download : x) {
            this.f10032a.a(String.valueOf(download.getId()), new i(this));
            if (!b.a.p0.h.t.a.d().a(download)) {
                b.a.p0.g.c.i.c.a(download.getKeyByUser(), "resumeAllDownload", "success", null, new b.a.p0.g.c.i.a(this.f10036e));
            }
        }
    }

    public void E(@NonNull JSONObject jSONObject, @NonNull b.a.p0.g.c.f.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, jSONObject, bVar) == null) {
            if (i()) {
                bVar.a(new b.a.p0.g.c.g.a(31006, "is not in main process"));
            } else if (!SwanAppNetworkUtils.i(null)) {
                bVar.a(new b.a.p0.g.c.g.a(31014, "network is not connected"));
            } else {
                String optString = jSONObject.optString("url");
                String optString2 = jSONObject.optString("packageName");
                if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                    Download u = this.f10035d.u(optString, optString2);
                    if (u == null) {
                        b.a.p0.g.c.d.d.b().e(jSONObject, bVar);
                        return;
                    }
                    String valueOf = String.valueOf(u.getId());
                    if (!this.f10032a.d(valueOf)) {
                        this.f10032a.a(String.valueOf(u.getId()), bVar);
                    }
                    if (u.getState() == Download.DownloadState.FINISH) {
                        new b.a.p0.g.c.e.c(u, this.f10036e).c(new b(this, valueOf, u));
                        return;
                    }
                    b.a.p0.g.c.i.c.a(optString2, "resumeDownload", null, null, new b.a.p0.g.c.i.a(this.f10036e));
                    this.f10034c.resume(u.getId().longValue());
                    return;
                }
                bVar.a(new b.a.p0.g.c.g.a(31007, "invalid params"));
            }
        }
    }

    public final void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.f10037f == null) {
                this.f10037f = new AppDownloadNetworkStateReceiver();
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            b.a.p0.a.c1.a.b().registerReceiver(this.f10037f, intentFilter);
        }
    }

    public void G(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        this.f10036e = jSONObject;
    }

    public void H(String str, String str2, String str3, @NonNull b.a.p0.g.c.f.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048583, this, str, str2, str3, bVar) == null) {
            if (i()) {
                bVar.a(new b.a.p0.g.c.g.a(31006, "is not in main process"));
            } else if (!SwanAppNetworkUtils.i(null)) {
                bVar.a(new b.a.p0.g.c.g.a(31014, "network is not connected"));
            } else if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                if (b.a.p0.g.c.e.a.h(AppRuntime.getAppContext(), str2)) {
                    bVar.a(new b.a.p0.g.c.g.a(31005, "apk is already installed"));
                } else if (j(str, bVar)) {
                    b.a.p0.g.c.d.a aVar = new b.a.p0.g.c.d.a();
                    aVar.g(str);
                    aVar.f(str2);
                    aVar.a(str3);
                    Download b2 = aVar.b();
                    this.f10034c.start(b2);
                    if (b2.getId() != null) {
                        this.f10032a.a(String.valueOf(b2.getId()), bVar);
                    }
                    if (b.a.p0.h.t.a.d().a(b2)) {
                        return;
                    }
                    b.a.p0.g.c.i.c.a(str2, "startDownload", null, null, new b.a.p0.g.c.i.a(this.f10036e));
                    b.a.p0.g.c.i.c.d(1, str2, str3, str);
                }
            } else {
                bVar.a(new b.a.p0.g.c.g.a(31007, "invalid params"));
            }
        }
    }

    public final void h(Download download, b.a.p0.g.c.f.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, download, bVar) == null) || download.getId() == null) {
            return;
        }
        this.f10032a.a(String.valueOf(download.getId()), bVar);
    }

    public final boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? !ProcessUtils.isMainProcess() : invokeV.booleanValue;
    }

    public boolean j(String str, b.a.p0.g.c.f.b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, str, bVar)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.f10038g < 1000) {
                if (k.f6397a) {
                    String str2 = "interval is " + (currentTimeMillis - this.f10038g);
                }
                return false;
            }
            this.f10038g = currentTimeMillis;
            Download v = this.f10035d.v(str);
            if (v == null) {
                return true;
            }
            Download.DownloadState state = v.getState();
            if (k.f6397a) {
                String str3 = "current state is " + state.name();
            }
            int i2 = h.f10055a[state.ordinal()];
            if (i2 == 1) {
                h(v, bVar);
                s(v);
                return false;
            } else if (i2 == 4 || i2 == 5) {
                h(v, bVar);
                boolean z = k.f6397a;
                return false;
            } else if (i2 != 6) {
                this.f10035d.g(str);
                return true;
            } else {
                h(v, bVar);
                this.f10034c.resume(v.getId().longValue());
                boolean z2 = k.f6397a;
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public synchronized void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            synchronized (this) {
                this.f10035d.d();
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
                    if (f10030h) {
                        e2.printStackTrace();
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void m(@NonNull JSONObject jSONObject, @NonNull b.a.p0.g.c.f.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, jSONObject, bVar) == null) {
            if (i()) {
                bVar.a(new b.a.p0.g.c.g.a(31006, "is not in main process"));
                return;
            }
            String optString = jSONObject.optString("url");
            String optString2 = jSONObject.optString("packageName");
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                Collection<Download> r = this.f10035d.r(optString);
                if (r != null && !r.isEmpty()) {
                    Iterator<Download> it = r.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        Download next = it.next();
                        if (next != null && next.getState() == Download.DownloadState.FINISH) {
                            b.a.p0.h.t.a.c().c(optString);
                            break;
                        }
                    }
                    b.a.p0.g.c.i.c.a(optString2, "deleteDownload", null, null, new b.a.p0.g.c.i.a(this.f10036e));
                    this.f10035d.h(r);
                    bVar.a(new b.a.p0.g.c.g.c(r));
                    return;
                }
                b.a.p0.g.c.d.d.b().a(jSONObject, bVar);
                return;
            }
            bVar.a(new b.a.p0.g.c.g.a(31007, "invalid params"));
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            b.a.p0.g.i.d.a.c().d();
        }
    }

    public final void p(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            if (!this.f10035d.b(str)) {
                String i2 = this.f10035d.i(str);
                if (TextUtils.isEmpty(i2) || !this.f10035d.c(i2)) {
                    return;
                }
                b.a.p0.g.c.i.c.a(str, "installHijack", null, null, new b.a.p0.g.c.i.a(this.f10036e));
                return;
            }
            b.a.p0.g.c.i.c.a(str, "installApp", "success", null, new b.a.p0.g.c.i.a(this.f10036e));
            Download o = this.f10035d.o(str);
            if (o != null) {
                b.a.p0.g.c.i.c.d(3, str, new b.a.p0.g.c.d.a(o).c(), o.getUrl());
            }
        }
    }

    public void q(String str, String str2) {
        Download w;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048592, this, str, str2) == null) || (w = this.f10035d.w(str)) == null) {
            return;
        }
        b.a.p0.g.c.e.c cVar = new b.a.p0.g.c.e.c(w, this.f10036e);
        if (!TextUtils.isEmpty(str2)) {
            b.a.p0.g.c.i.c.c("notifyInstall", str2, str);
        }
        cVar.c(new f(this, w, str2, str));
    }

    public String r(Context context, String str, String str2, @NonNull b.a.p0.g.c.f.a aVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048593, this, context, str, str2, aVar)) == null) {
            if (i()) {
                aVar.a(new b.a.p0.g.c.g.a(31006, "is not in main process"));
                return null;
            } else if (TextUtils.isEmpty(str)) {
                aVar.a(new b.a.p0.g.c.g.a(31007, "invalid params"));
                return null;
            } else {
                Download o = this.f10035d.o(str2);
                if (o == null) {
                    aVar.a(new b.a.p0.g.c.g.a(31008, "download is not exist"));
                    this.f10035d.g(str);
                    return null;
                } else if (o.getCurrentbytes().longValue() < o.getTotalbytes().longValue()) {
                    aVar.a(new b.a.p0.g.c.g.a(31017, "download is not finished"));
                    this.f10035d.g(str);
                    return null;
                } else {
                    String realDownloadDir = o.getRealDownloadDir();
                    String fileName = o.getFileName();
                    if (f10030h) {
                        String str3 = "installApp packageName:" + str2 + ",fileDir:" + realDownloadDir + ",fileName:" + fileName;
                    }
                    if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(realDownloadDir) || TextUtils.isEmpty(fileName)) {
                        aVar.a(new b.a.p0.g.c.g.a(31001, "database no package or file name"));
                        this.f10035d.g(str);
                    }
                    String str4 = realDownloadDir + File.separator + fileName;
                    if (b.a.p0.g.c.e.a.h(AppRuntime.getAppContext(), str2)) {
                        p(str2);
                        aVar.a(new b.a.p0.g.c.g.c("apk is already installed"));
                        l(str4);
                        return null;
                    }
                    File file = new File(str4);
                    if (file.isFile() && file.exists()) {
                        if (k0.c() <= file.length()) {
                            aVar.a(new b.a.p0.g.c.g.a(31020, "not enough space to install"));
                            return null;
                        }
                        aVar.setPackageName(str2);
                        aVar.setFilePath(str4);
                        this.f10033b.a(str2, aVar);
                        if (!b.a.p0.g.c.e.a.j(context, str4, false)) {
                            t(str2);
                            B(str2, aVar);
                            aVar.a(new b.a.p0.g.c.g.a(31004, "apk install fail"));
                            this.f10035d.g(str);
                        } else {
                            long length = ((file.length() / 104857600) + 1) * 1000;
                            String c2 = b.a.p0.g.c.e.a.c();
                            if (b.a.p0.g.c.e.a.k(c2)) {
                                b.a.p0.a.a2.d.i().postDelayed(new c(this, c2, str2), length);
                            }
                        }
                        return str2;
                    }
                    aVar.a(new b.a.p0.g.c.g.a(31002, "file is not exist"));
                    this.f10035d.g(str);
                    return null;
                }
            }
        }
        return (String) invokeLLLL.objValue;
    }

    public final void s(Download download) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, download) == null) {
            new b.a.p0.g.c.e.c(download, this.f10036e).c(new g(this, download));
        }
    }

    public void t(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            for (Download download : this.f10035d.p(str)) {
                if (download != null) {
                    b.a.p0.g.c.h.a.f().a(download);
                }
            }
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            this.f10035d.m();
        }
    }

    public void v(@NonNull JSONObject jSONObject, @NonNull b.a.p0.g.c.f.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048597, this, jSONObject, bVar) == null) {
            if (i()) {
                bVar.a(new b.a.p0.g.c.g.a(31006, "is not in main process"));
                return;
            }
            String optString = jSONObject.optString("url");
            String optString2 = jSONObject.optString("packageName");
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                Download u = this.f10035d.u(optString, optString2);
                if (u == null) {
                    b.a.p0.g.c.d.d.b().c(jSONObject, bVar);
                    return;
                } else if (u.getState() != Download.DownloadState.WAITING && u.getState() != Download.DownloadState.DOWNLOADING) {
                    bVar.a(new b.a.p0.g.c.g.a(31013, "download is not started"));
                    return;
                } else {
                    b.a.p0.g.c.i.c.a(optString2, "pauseDownload", null, null, new b.a.p0.g.c.i.a(this.f10036e));
                    this.f10034c.pause(u.getId().longValue());
                    bVar.a(new b.a.p0.g.c.g.c(u));
                    return;
                }
            }
            bVar.a(new b.a.p0.g.c.g.a(31007, "invalid params"));
        }
    }

    public void w(@NonNull b.a.p0.g.c.f.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, bVar) == null) {
            if (i()) {
                bVar.a(new b.a.p0.g.c.g.a(31006, "is not in main process"));
                return;
            }
            Collection<Download> n = this.f10035d.n();
            if (n != null && !n.isEmpty()) {
                bVar.a(new b.a.p0.g.c.g.c(n));
            } else {
                bVar.a(new b.a.p0.g.c.g.a(31008, "download is not exist"));
            }
        }
    }

    public void x(@NonNull JSONObject jSONObject, @NonNull b.a.p0.g.c.f.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048599, this, jSONObject, bVar) == null) {
            if (i()) {
                bVar.a(new b.a.p0.g.c.g.a(31006, "is not in main process"));
                return;
            }
            String optString = jSONObject.optString("url");
            if (TextUtils.isEmpty(optString)) {
                bVar.a(new b.a.p0.g.c.g.a(31007, "invalid params"));
                return;
            }
            Download v = this.f10035d.v(optString);
            if (v == null) {
                b.a.p0.g.c.d.d.b().d(jSONObject, bVar);
            } else {
                bVar.a(new b.a.p0.g.c.g.c(v));
            }
        }
    }

    public Download y(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, str)) == null) ? this.f10035d.v(str) : (Download) invokeL.objValue;
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
