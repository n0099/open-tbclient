package b.a.p0.a.o.h;

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
import b.a.p0.a.k;
import b.a.p0.a.v2.w;
import b.a.p0.f.i.k.d.a;
import b.a.p0.f.i.r.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
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
import com.baidu.wallet.home.datamodel.HomeCfgResponse;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a extends b.a.p0.a.v1.a.a.a {
    public static /* synthetic */ Interceptable $ic;
    public static final String j;
    public static boolean k;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public Bundle f7075f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f7076g;

    /* renamed from: h  reason: collision with root package name */
    public AdDownloadService.a f7077h;

    /* renamed from: i  reason: collision with root package name */
    public ServiceConnection f7078i;

    /* renamed from: b.a.p0.a.o.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class ServiceConnectionC0327a implements ServiceConnection {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f7079e;

        public ServiceConnectionC0327a(a aVar) {
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
            this.f7079e = aVar;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, componentName, iBinder) == null) {
                this.f7079e.f7077h = (AdDownloadService.a) iBinder;
                boolean z = k.f6397a;
                a aVar = this.f7079e;
                aVar.l(aVar.f7075f);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, componentName) == null) {
                this.f7079e.f7077h = null;
                boolean z = k.f6397a;
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f7080e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f7081f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f7082g;

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
            this.f7082g = aVar;
            this.f7080e = i2;
            this.f7081f = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f7082g.f8460d.putInt("state", this.f7080e);
                this.f7082g.f8460d.putInt("progress", this.f7081f);
                this.f7082g.c();
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f7083e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f7084f;

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
            this.f7084f = aVar;
            this.f7083e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f7084f.f8460d.putString("packageName", this.f7083e);
                this.f7084f.c();
            }
        }
    }

    /* loaded from: classes.dex */
    public static /* synthetic */ class d {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f7085a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f7086b;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2011276201, "Lb/a/p0/a/o/h/a$d;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-2011276201, "Lb/a/p0/a/o/h/a$d;");
                    return;
                }
            }
            int[] iArr = new int[DownloadState.values().length];
            f7086b = iArr;
            try {
                iArr[DownloadState.NOT_START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f7086b[DownloadState.WAIT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f7086b[DownloadState.PREPARE_DOWNLOAD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f7086b[DownloadState.DOWNLOADED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f7086b[DownloadState.DOWNLOADING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f7086b[DownloadState.DOWNLOAD_FAILED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f7086b[DownloadState.DOWNLOAD_PAUSED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f7086b[DownloadState.DELETED.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            int[] iArr2 = new int[SwanAppDownloadAction.SwanAppDownloadType.values().length];
            f7085a = iArr2;
            try {
                iArr2[SwanAppDownloadAction.SwanAppDownloadType.TYPE_QUERY_STATUS.ordinal()] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f7085a[SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD.ordinal()] = 2;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f7085a[SwanAppDownloadAction.SwanAppDownloadType.TYPE_PAUSE_DOWNLOAD.ordinal()] = 3;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f7085a[SwanAppDownloadAction.SwanAppDownloadType.TYPE_CANCEL_DOWNLOAD.ordinal()] = 4;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f7085a[SwanAppDownloadAction.SwanAppDownloadType.TYPE_RESUME_DOWNLOAD.ordinal()] = 5;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f7085a[SwanAppDownloadAction.SwanAppDownloadType.TYPE_INSTALL_APP.ordinal()] = 6;
            } catch (NoSuchFieldError unused14) {
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements b.a.p0.f.i.k.f.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final String f7087a;

        /* renamed from: b  reason: collision with root package name */
        public final String f7088b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f7089c;

        /* renamed from: b.a.p0.a.o.h.a$e$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0328a extends a.d<Boolean> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b.a.p0.f.i.k.f.d f7090a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ e f7091b;

            public C0328a(e eVar, b.a.p0.f.i.k.f.d dVar) {
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
                this.f7091b = eVar;
                this.f7090a = dVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // b.a.p0.f.i.k.d.a.d
            /* renamed from: b */
            public void a(Boolean bool) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bool) == null) {
                    super.a(bool);
                    if (bool.booleanValue()) {
                        boolean z = k.f6397a;
                        b.a.p0.f.i.k.f.d dVar = this.f7090a;
                        dVar.b(dVar.g(this.f7091b.f7088b));
                        this.f7091b.f7089c.setResult(DownloadState.INSTALLED.value(), Integer.parseInt(HomeCfgResponse.ConfigData.GROUP_LAYOUR_GAP));
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
            this.f7089c = aVar;
            this.f7087a = str;
            this.f7088b = str2;
        }

        @Override // b.a.p0.f.i.k.f.c
        public void a() {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f7089c.setResult(DownloadState.DOWNLOADED.value(), Integer.parseInt(HomeCfgResponse.ConfigData.GROUP_LAYOUR_GAP));
                boolean z = k.f6397a;
                String str2 = this.f7087a;
                if (TextUtils.isEmpty(str2) && (str = this.f7088b) != null) {
                    str2 = this.f7089c.v(str);
                    this.f7089c.w(str2);
                }
                if (TextUtils.isEmpty(str2)) {
                    return;
                }
                Uri parse = Uri.parse(this.f7088b);
                b.a.p0.f.i.k.f.d m = b.a.p0.f.i.k.d.a.m(this.f7089c.getContext(), null);
                m.f(str2, parse, new C0328a(this, m));
            }
        }

        @Override // b.a.p0.f.i.k.f.c
        public void b(DownloadException downloadException) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadException) == null) {
                this.f7089c.setResult(DownloadState.DOWNLOAD_FAILED.value(), Integer.parseInt("-1"));
            }
        }

        @Override // b.a.p0.f.i.k.f.c
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f7089c.setResult(DownloadState.DELETED.value(), Integer.parseInt("0"));
                boolean z = k.f6397a;
            }
        }

        @Override // b.a.p0.f.i.k.f.c
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.f7089c.setResult(DownloadState.NOT_START.value(), Integer.parseInt("0"));
                boolean z = k.f6397a;
            }
        }

        @Override // b.a.p0.f.i.k.f.c
        public void e(long j, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
                String n = a.n(j, j2);
                this.f7089c.setResult(DownloadState.DOWNLOADING.value(), Integer.parseInt(n));
                if (k.f6397a) {
                    String str = "下载进度" + n;
                }
            }
        }

        @Override // b.a.p0.f.i.k.f.c
        public void f(long j, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
                String n = a.n(j, j2);
                this.f7089c.setResult(DownloadState.DOWNLOAD_PAUSED.value(), Integer.parseInt(n));
                if (k.f6397a) {
                    String str = "下载暂停" + n;
                }
            }
        }

        @Override // b.a.p0.f.i.k.f.c
        public void onStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                this.f7089c.setResult(DownloadState.DOWNLOADING.value(), Integer.parseInt("0"));
                boolean z = k.f6397a;
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1687007209, "Lb/a/p0/a/o/h/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1687007209, "Lb/a/p0/a/o/h/a;");
                return;
            }
        }
        j = AppRuntime.getAppContext().getPackageName();
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
        this.f7076g = false;
        this.f7078i = new ServiceConnectionC0327a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this)) == null) ? AppRuntime.getAppContext() : (Context) invokeV.objValue;
    }

    public static String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
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

    public static String n(long j2, long j3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65546, null, new Object[]{Long.valueOf(j2), Long.valueOf(j3)})) == null) ? (j3 <= 0 || j2 <= 0) ? "0" : String.valueOf((int) Math.floor((j2 * 100) / j3)) : (String) invokeCommon.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setResult(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65547, this, i2, i3) == null) {
            b.a.p0.a.a2.d.i().post(new b(this, i2, i3));
            z();
        }
    }

    @Override // b.a.p0.a.v1.a.a.a
    public void b(@NonNull Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
            this.f7075f = bundle;
            if (SwanAppDownloadAction.SwanAppDownloadType.find(bundle.getString("type")) == SwanAppDownloadAction.SwanAppDownloadType.TYPE_STOP_SERVICE) {
                y();
                return;
            }
            x();
            k();
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f7076g) {
            return;
        }
        this.f7076g = true;
        Context context = getContext();
        Intent intent = new Intent();
        intent.setAction("com.baidu.swan.game.ad.downloader.core.AdDownloadService");
        intent.setPackage(j);
        context.bindService(intent, this.f7078i, 128);
    }

    public void l(@NonNull Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            try {
                SwanAppDownloadAction.SwanAppDownloadType find = SwanAppDownloadAction.SwanAppDownloadType.find(bundle.getString("type"));
                JSONObject d2 = w.d(bundle.getString(PushConstants.PARAMS, null));
                String optString = d2.optString("url");
                if (!TextUtils.isEmpty(optString) && this.f7077h != null) {
                    switch (d.f7085a[find.ordinal()]) {
                        case 1:
                            s(d2, optString);
                            return;
                        case 2:
                            u(d2, optString);
                            return;
                        case 3:
                            r(optString);
                            return;
                        case 4:
                            o(optString);
                            return;
                        case 5:
                            t(optString);
                            return;
                        case 6:
                            q(d2, optString);
                            return;
                        default:
                            return;
                    }
                }
            } catch (Exception unused) {
                p();
            }
        }
    }

    public final void o(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.f7077h.a(this.f7077h.b(str));
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            setResult(DownloadState.DOWNLOAD_FAILED.value(), Integer.parseInt("0"));
        }
    }

    public final void q(@NonNull JSONObject jSONObject, @NonNull String str) {
        DownloadInfo b2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048581, this, jSONObject, str) == null) || (b2 = this.f7077h.b(str)) == null) {
            return;
        }
        g.c(b2.getPath(), false);
    }

    public final void r(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.f7077h.c(this.f7077h.b(str));
        }
    }

    public final void s(@NonNull JSONObject jSONObject, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, jSONObject, str) == null) {
            DownloadInfo b2 = this.f7077h.b(str);
            int value = DownloadState.NOT_START.value();
            int parseInt = Integer.parseInt("0");
            if (b2 == null) {
                setResult(value, parseInt);
                return;
            }
            long progress = b2.getProgress();
            long size = b2.getSize();
            switch (d.f7086b[DownloadState.convert(b2.getStatus()).ordinal()]) {
                case 1:
                case 2:
                case 3:
                    value = DownloadState.NOT_START.value();
                    parseInt = Integer.parseInt("0");
                    break;
                case 4:
                    value = DownloadState.DOWNLOADED.value();
                    parseInt = Integer.parseInt(HomeCfgResponse.ConfigData.GROUP_LAYOUR_GAP);
                    break;
                case 5:
                    value = DownloadState.DOWNLOADING.value();
                    parseInt = Integer.parseInt(n(progress, size));
                    break;
                case 6:
                    value = DownloadState.DOWNLOAD_FAILED.value();
                    parseInt = Integer.parseInt("0");
                    break;
                case 7:
                    value = DownloadState.DOWNLOAD_PAUSED.value();
                    parseInt = Integer.parseInt(n(progress, size));
                    break;
                case 8:
                    value = DownloadState.DELETED.value();
                    parseInt = Integer.parseInt("0");
                    break;
            }
            setResult(value, parseInt);
        }
    }

    public final void t(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.f7077h.d(this.f7077h.b(str));
        }
    }

    public final void u(@NonNull JSONObject jSONObject, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, jSONObject, str) == null) {
            DownloadInfo b2 = this.f7077h.b(str);
            String optString = jSONObject.optString("name");
            String m = m();
            if (TextUtils.isEmpty(m)) {
                p();
                return;
            }
            File file = new File(m);
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
            this.f7077h.e(b2);
        }
    }

    public final String v(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            DownloadInfo b2 = this.f7077h.b(str);
            return b2 == null ? "" : b2.getPackageName();
        }
        return (String) invokeL.objValue;
    }

    public final void w(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            b.a.p0.a.a2.d.i().post(new c(this, str));
        }
    }

    public void x() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || k) {
            return;
        }
        Context context = getContext();
        Intent intent = new Intent();
        intent.setAction("com.baidu.swan.game.ad.downloader.core.AdDownloadService");
        intent.setPackage(j);
        context.startService(intent);
        k = true;
    }

    public void y() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && k) {
            Context context = getContext();
            Intent intent = new Intent();
            intent.setAction("com.baidu.swan.game.ad.downloader.core.AdDownloadService");
            intent.setPackage(j);
            context.stopService(intent);
            k = false;
        }
    }

    public void z() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && this.f7076g) {
            this.f7076g = false;
            Context context = getContext();
            Intent intent = new Intent();
            intent.setAction("com.baidu.swan.game.ad.downloader.core.AdDownloadService");
            intent.setPackage(j);
            context.unbindService(this.f7078i);
        }
    }
}
