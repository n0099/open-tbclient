package c.a.p0.a.o.h;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.IBinder;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.k;
import c.a.p0.a.v2.w;
import c.a.p0.f.i.k.d.a;
import c.a.p0.f.i.r.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.scheme.actions.SwanAppDownloadAction;
import com.baidu.swan.game.ad.downloader.core.AdDownloadService;
import com.baidu.swan.game.ad.downloader.exception.DownloadException;
import com.baidu.swan.game.ad.downloader.model.DownloadInfo;
import com.baidu.swan.game.ad.downloader.model.DownloadState;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a extends c.a.p0.a.v1.a.a.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: j  reason: collision with root package name */
    public static final String f7770j;
    public static boolean k;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public Bundle f7771f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f7772g;

    /* renamed from: h  reason: collision with root package name */
    public AdDownloadService.a f7773h;

    /* renamed from: i  reason: collision with root package name */
    public ServiceConnection f7774i;

    /* renamed from: c.a.p0.a.o.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class ServiceConnectionC0332a implements ServiceConnection {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f7775e;

        public ServiceConnectionC0332a(a aVar) {
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
            this.f7775e = aVar;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, componentName, iBinder) == null) {
                this.f7775e.f7773h = (AdDownloadService.a) iBinder;
                boolean z = k.f7077a;
                a aVar = this.f7775e;
                aVar.l(aVar.f7771f);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, componentName) == null) {
                this.f7775e.f7773h = null;
                boolean z = k.f7077a;
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f7776e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f7777f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f7778g;

        public b(a aVar, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7778g = aVar;
            this.f7776e = i2;
            this.f7777f = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f7778g.f9203d.putInt("state", this.f7776e);
                this.f7778g.f9203d.putInt("progress", this.f7777f);
                this.f7778g.c();
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f7779e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f7780f;

        public c(a aVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7780f = aVar;
            this.f7779e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f7780f.f9203d.putString("packageName", this.f7779e);
                this.f7780f.c();
            }
        }
    }

    /* loaded from: classes.dex */
    public static /* synthetic */ class d {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f7781a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f7782b;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-657966504, "Lc/a/p0/a/o/h/a$d;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-657966504, "Lc/a/p0/a/o/h/a$d;");
                    return;
                }
            }
            int[] iArr = new int[DownloadState.values().length];
            f7782b = iArr;
            try {
                iArr[DownloadState.NOT_START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f7782b[DownloadState.WAIT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f7782b[DownloadState.PREPARE_DOWNLOAD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f7782b[DownloadState.DOWNLOADED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f7782b[DownloadState.DOWNLOADING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f7782b[DownloadState.DOWNLOAD_FAILED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f7782b[DownloadState.DOWNLOAD_PAUSED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f7782b[DownloadState.DELETED.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            int[] iArr2 = new int[SwanAppDownloadAction.SwanAppDownloadType.values().length];
            f7781a = iArr2;
            try {
                iArr2[SwanAppDownloadAction.SwanAppDownloadType.TYPE_QUERY_STATUS.ordinal()] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f7781a[SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD.ordinal()] = 2;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f7781a[SwanAppDownloadAction.SwanAppDownloadType.TYPE_PAUSE_DOWNLOAD.ordinal()] = 3;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f7781a[SwanAppDownloadAction.SwanAppDownloadType.TYPE_CANCEL_DOWNLOAD.ordinal()] = 4;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f7781a[SwanAppDownloadAction.SwanAppDownloadType.TYPE_RESUME_DOWNLOAD.ordinal()] = 5;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f7781a[SwanAppDownloadAction.SwanAppDownloadType.TYPE_INSTALL_APP.ordinal()] = 6;
            } catch (NoSuchFieldError unused14) {
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements c.a.p0.f.i.k.f.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final String f7783a;

        /* renamed from: b  reason: collision with root package name */
        public final String f7784b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f7785c;

        /* renamed from: c.a.p0.a.o.h.a$e$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0333a extends a.d<Boolean> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ c.a.p0.f.i.k.f.d f7786a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ e f7787b;

            public C0333a(e eVar, c.a.p0.f.i.k.f.d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar, dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f7787b = eVar;
                this.f7786a = dVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // c.a.p0.f.i.k.d.a.d
            /* renamed from: b */
            public void a(Boolean bool) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bool) == null) {
                    super.a(bool);
                    if (bool.booleanValue()) {
                        boolean z = k.f7077a;
                        c.a.p0.f.i.k.f.d dVar = this.f7786a;
                        dVar.b(dVar.g(this.f7787b.f7784b));
                        this.f7787b.f7785c.y(DownloadState.INSTALLED.value(), Integer.parseInt("100"));
                    }
                }
            }
        }

        public e(a aVar, String str, String str2) {
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
            this.f7785c = aVar;
            this.f7783a = str;
            this.f7784b = str2;
        }

        @Override // c.a.p0.f.i.k.f.c
        public void a() {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f7785c.y(DownloadState.DOWNLOADED.value(), Integer.parseInt("100"));
                boolean z = k.f7077a;
                String str2 = this.f7783a;
                if (TextUtils.isEmpty(str2) && (str = this.f7784b) != null) {
                    str2 = this.f7785c.w(str);
                    this.f7785c.x(str2);
                }
                if (TextUtils.isEmpty(str2)) {
                    return;
                }
                Uri parse = Uri.parse(this.f7784b);
                c.a.p0.f.i.k.f.d m = c.a.p0.f.i.k.d.a.m(this.f7785c.m(), null);
                m.f(str2, parse, new C0333a(this, m));
            }
        }

        @Override // c.a.p0.f.i.k.f.c
        public void b(DownloadException downloadException) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadException) == null) {
                this.f7785c.y(DownloadState.DOWNLOAD_FAILED.value(), Integer.parseInt("-1"));
            }
        }

        @Override // c.a.p0.f.i.k.f.c
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f7785c.y(DownloadState.DELETED.value(), Integer.parseInt("0"));
                boolean z = k.f7077a;
            }
        }

        @Override // c.a.p0.f.i.k.f.c
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.f7785c.y(DownloadState.NOT_START.value(), Integer.parseInt("0"));
                boolean z = k.f7077a;
            }
        }

        @Override // c.a.p0.f.i.k.f.c
        public void e(long j2, long j3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) {
                String o = a.o(j2, j3);
                this.f7785c.y(DownloadState.DOWNLOADING.value(), Integer.parseInt(o));
                if (k.f7077a) {
                    String str = "下载进度" + o;
                }
            }
        }

        @Override // c.a.p0.f.i.k.f.c
        public void f(long j2, long j3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) {
                String o = a.o(j2, j3);
                this.f7785c.y(DownloadState.DOWNLOAD_PAUSED.value(), Integer.parseInt(o));
                if (k.f7077a) {
                    String str = "下载暂停" + o;
                }
            }
        }

        @Override // c.a.p0.f.i.k.f.c
        public void onStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                this.f7785c.y(DownloadState.DOWNLOADING.value(), Integer.parseInt("0"));
                boolean z = k.f7077a;
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-179455400, "Lc/a/p0/a/o/h/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-179455400, "Lc/a/p0/a/o/h/a;");
                return;
            }
        }
        f7770j = AppRuntime.getAppContext().getPackageName();
        k = false;
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
        this.f7772g = false;
        this.f7774i = new ServiceConnectionC0332a(this);
    }

    public static String n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            if (Environment.getExternalStorageState().equals("mounted")) {
                String str = AppRuntime.getAppContext().getExternalFilesDir(null) + File.separator + "swanAdDownload";
                File file = new File(str);
                if (!file.exists()) {
                    file.mkdirs();
                }
                return str;
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public static String o(long j2, long j3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65545, null, new Object[]{Long.valueOf(j2), Long.valueOf(j3)})) == null) ? (j3 <= 0 || j2 <= 0) ? "0" : String.valueOf((int) Math.floor((j2 * 100) / j3)) : (String) invokeCommon.objValue;
    }

    public void A() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && k) {
            Context m = m();
            Intent intent = new Intent();
            intent.setAction("com.baidu.swan.game.ad.downloader.core.AdDownloadService");
            intent.setPackage(f7770j);
            m.stopService(intent);
            k = false;
        }
    }

    public void B() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.f7772g) {
            this.f7772g = false;
            Context m = m();
            Intent intent = new Intent();
            intent.setAction("com.baidu.swan.game.ad.downloader.core.AdDownloadService");
            intent.setPackage(f7770j);
            m.unbindService(this.f7774i);
        }
    }

    @Override // c.a.p0.a.v1.a.a.a
    public void b(@NonNull Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            this.f7771f = bundle;
            if (SwanAppDownloadAction.SwanAppDownloadType.find(bundle.getString("type")) == SwanAppDownloadAction.SwanAppDownloadType.TYPE_STOP_SERVICE) {
                A();
                return;
            }
            z();
            k();
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.f7772g) {
            return;
        }
        this.f7772g = true;
        Context m = m();
        Intent intent = new Intent();
        intent.setAction("com.baidu.swan.game.ad.downloader.core.AdDownloadService");
        intent.setPackage(f7770j);
        m.bindService(intent, this.f7774i, 128);
    }

    public void l(@NonNull Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            try {
                SwanAppDownloadAction.SwanAppDownloadType find = SwanAppDownloadAction.SwanAppDownloadType.find(bundle.getString("type"));
                JSONObject d2 = w.d(bundle.getString(PushConstants.PARAMS, null));
                String optString = d2.optString("url");
                if (!TextUtils.isEmpty(optString) && this.f7773h != null) {
                    switch (d.f7781a[find.ordinal()]) {
                        case 1:
                            t(d2, optString);
                            return;
                        case 2:
                            v(d2, optString);
                            return;
                        case 3:
                            s(optString);
                            return;
                        case 4:
                            p(optString);
                            return;
                        case 5:
                            u(optString);
                            return;
                        case 6:
                            r(d2, optString);
                            return;
                        default:
                            return;
                    }
                }
            } catch (Exception unused) {
                q();
            }
        }
    }

    public final Context m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? AppRuntime.getAppContext() : (Context) invokeV.objValue;
    }

    public final void p(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.f7773h.a(this.f7773h.b(str));
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            y(DownloadState.DOWNLOAD_FAILED.value(), Integer.parseInt("0"));
        }
    }

    public final void r(@NonNull JSONObject jSONObject, @NonNull String str) {
        DownloadInfo b2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONObject, str) == null) || (b2 = this.f7773h.b(str)) == null) {
            return;
        }
        g.c(b2.getPath(), false);
    }

    public final void s(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.f7773h.c(this.f7773h.b(str));
        }
    }

    public final void t(@NonNull JSONObject jSONObject, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, jSONObject, str) == null) {
            DownloadInfo b2 = this.f7773h.b(str);
            int value = DownloadState.NOT_START.value();
            int parseInt = Integer.parseInt("0");
            if (b2 == null) {
                y(value, parseInt);
                return;
            }
            long progress = b2.getProgress();
            long size = b2.getSize();
            switch (d.f7782b[DownloadState.convert(b2.getStatus()).ordinal()]) {
                case 1:
                case 2:
                case 3:
                    value = DownloadState.NOT_START.value();
                    parseInt = Integer.parseInt("0");
                    break;
                case 4:
                    value = DownloadState.DOWNLOADED.value();
                    parseInt = Integer.parseInt("100");
                    break;
                case 5:
                    value = DownloadState.DOWNLOADING.value();
                    parseInt = Integer.parseInt(o(progress, size));
                    break;
                case 6:
                    value = DownloadState.DOWNLOAD_FAILED.value();
                    parseInt = Integer.parseInt("0");
                    break;
                case 7:
                    value = DownloadState.DOWNLOAD_PAUSED.value();
                    parseInt = Integer.parseInt(o(progress, size));
                    break;
                case 8:
                    value = DownloadState.DELETED.value();
                    parseInt = Integer.parseInt("0");
                    break;
            }
            y(value, parseInt);
        }
    }

    public final void u(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.f7773h.d(this.f7773h.b(str));
        }
    }

    public final void v(@NonNull JSONObject jSONObject, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, jSONObject, str) == null) {
            DownloadInfo b2 = this.f7773h.b(str);
            String optString = jSONObject.optString("name");
            String n = n();
            if (TextUtils.isEmpty(n)) {
                q();
                return;
            }
            File file = new File(n);
            String valueOf = String.valueOf(str.hashCode());
            String concat = file.getAbsolutePath().concat("/");
            String concat2 = concat.concat(valueOf + ".apk");
            if (b2 == null) {
                DownloadInfo.a aVar = new DownloadInfo.a();
                aVar.e(str);
                aVar.d(concat2);
                aVar.c(optString);
                b2 = aVar.a();
            }
            b2.setDownloadListener(new e(this, optString, str));
            this.f7773h.e(b2);
        }
    }

    public final String w(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
            DownloadInfo b2 = this.f7773h.b(str);
            return b2 == null ? "" : b2.getPackageName();
        }
        return (String) invokeL.objValue;
    }

    public final void x(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            c.a.p0.a.a2.d.i().post(new c(this, str));
        }
    }

    public final void y(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048591, this, i2, i3) == null) {
            c.a.p0.a.a2.d.i().post(new b(this, i2, i3));
            B();
        }
    }

    public void z() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || k) {
            return;
        }
        Context m = m();
        Intent intent = new Intent();
        intent.setAction("com.baidu.swan.game.ad.downloader.core.AdDownloadService");
        intent.setPackage(f7770j);
        m.startService(intent);
        k = true;
    }
}
