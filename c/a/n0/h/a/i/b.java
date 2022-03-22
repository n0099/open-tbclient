package c.a.n0.h.a.i;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.AnimationUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.h.a.b.a;
import c.a.n0.h.a.h.d;
import c.a.n0.h.a.k.h;
import c.a.n0.h.a.k.i;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.swan.game.ad.downloader.model.DownloadParams;
import com.baidu.swan.game.ad.downloader.model.DownloadState;
import com.baidu.swan.game.ad.entity.AdElementInfo;
import com.baidu.swan.game.ad.jsbridge.CommandType;
import com.baidu.swan.game.ad.utils.NetworkUtils;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.titan.sdk.verifier.ApkSignatureSchemeV2Verifier;
import com.kuaishou.weapon.un.w0;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b implements c.a.n0.h.a.e.c, c.a.n0.h.a.e.d, c.a.n0.h.a.e.a, c.a.n0.h.a.e.e {
    public static /* synthetic */ Interceptable $ic = null;
    public static String D = "0";
    public static String E = "101";
    public static String F = "102";
    public static String G = "103";
    public static String H = "104";
    public static String I = "1";
    public static String J = "0";
    public static String K = "status";
    public static String L = "isPaused";
    public static String M = "token";
    public transient /* synthetic */ FieldHolder $fh;
    public Map<String, String> A;
    public c.a.n0.h.a.c.b B;
    public Activity C;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.n0.h.a.l.a f8387b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.n0.h.a.f.b.c f8388c;

    /* renamed from: d  reason: collision with root package name */
    public AdElementInfo f8389d;

    /* renamed from: e  reason: collision with root package name */
    public int f8390e;

    /* renamed from: f  reason: collision with root package name */
    public int f8391f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.n0.h.a.b.a f8392g;

    /* renamed from: h  reason: collision with root package name */
    public String f8393h;
    public String i;
    public c.a.n0.h.a.i.a j;
    public c.a.n0.h.a.h.c k;
    public String l;
    public c.a.n0.h.a.g.a m;
    public String n;
    public String o;
    public Map<String, String> p;
    public c.a.n0.h.a.j.c q;
    public DownloadState r;
    public DownloadParams s;
    public c.a.n0.h.a.c.f.a t;
    public boolean u;
    public boolean v;
    public boolean w;
    public boolean x;
    public c.a.n0.h.a.e.g y;
    public boolean z;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.a0();
                if (this.a.y.c(this.a.f8387b.r())) {
                    this.a.y.removeView(this.a.f8387b.r());
                }
                if (!this.a.y.d(this.a.f8387b.r(), c.a.n0.h.a.a.a.a())) {
                    this.a.X("3010000");
                    return;
                }
                this.a.f8390e = 260;
                this.a.f8387b.G(this.a.f8389d.getVideoUrl());
                c.a.n0.h.a.j.b.n("showSuccess", this.a.A, this.a.k);
            }
        }
    }

    /* renamed from: c.a.n0.h.a.i.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class DialogInterface$OnDismissListenerC0663b implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public DialogInterface$OnDismissListenerC0663b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public c(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                this.a.N();
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public d(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                if (!this.a.x || this.a.f8387b == null) {
                    this.a.S();
                    return;
                }
                if (this.a.f8388c != null) {
                    this.a.f8388c.pause();
                }
                this.a.f8390e = 262;
                this.a.f8387b.B();
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements c.a.n0.h.a.c.f.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public e(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // c.a.n0.h.a.c.f.a
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i) == null) || i == 0 || i > 100) {
                return;
            }
            if (i != 100 || this.a.n == b.E) {
                if (this.a.n == b.E || this.a.n == b.H) {
                    return;
                }
                this.a.n = String.valueOf(i);
                return;
            }
            this.a.n = b.F;
        }

        @Override // c.a.n0.h.a.c.f.a
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.q.c("appinstallbegin");
            }
        }

        @Override // c.a.n0.h.a.c.f.a
        public void c(DownloadState downloadState, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, downloadState, i) == null) {
                if (!this.a.u) {
                    this.a.m0(downloadState);
                }
                this.a.u = true;
                if (this.a.r == downloadState) {
                    return;
                }
                if (this.a.r == DownloadState.NOT_START && downloadState == DownloadState.DOWNLOADING) {
                    this.a.o = b.J;
                    this.a.q.c("appdownloadbegin");
                } else if (downloadState != DownloadState.DOWNLOAD_PAUSED) {
                    if (this.a.r == DownloadState.DOWNLOAD_PAUSED && downloadState == DownloadState.DOWNLOADING) {
                        this.a.o = b.J;
                        this.a.q.c("appdownloadcontinue");
                    } else if (downloadState == DownloadState.DOWNLOADED) {
                        this.a.o = b.J;
                        this.a.n = b.F;
                        this.a.q.c("appdownloadfinish");
                        this.a.q.c("appinstallbegin");
                    } else if (downloadState == DownloadState.INSTALLED) {
                        this.a.o = b.J;
                        this.a.n = b.G;
                        this.a.q.c("appinstallfinish");
                    } else if (downloadState == DownloadState.DOWNLOAD_FAILED) {
                        this.a.o = b.J;
                        this.a.n = b.H;
                    }
                } else {
                    this.a.o = b.I;
                    this.a.q.c("appdownloadpause");
                }
                this.a.r = downloadState;
            }
        }

        @Override // c.a.n0.h.a.c.f.a
        public void d(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            }
        }

        @Override // c.a.n0.h.a.c.f.a
        public String e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                this.a.q.c("appinstallopen");
                return "";
            }
            return (String) invokeV.objValue;
        }

        @Override // c.a.n0.h.a.c.f.a
        public void f(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            }
        }
    }

    /* loaded from: classes.dex */
    public class f implements c.a.n0.h.a.e.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public f(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // c.a.n0.h.a.e.f
        public void onCompletion() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.R();
            }
        }

        @Override // c.a.n0.h.a.e.f
        public boolean onError() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                this.a.j0();
                this.a.X("3010001");
                return true;
            }
            return invokeV.booleanValue;
        }

        @Override // c.a.n0.h.a.e.f
        public void onPause() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.a.f8387b == null) {
                return;
            }
            this.a.f8387b.z();
        }

        @Override // c.a.n0.h.a.e.f
        public void onPrepared() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                if (this.a.f8387b != null) {
                    this.a.f8387b.y();
                }
                this.a.f8390e = w0.F;
                this.a.f8391f = 0;
                if (this.a.f8387b != null) {
                    this.a.f8387b.p();
                }
                if (this.a.j != null) {
                    this.a.j.b(true, "");
                }
                if (this.a.v) {
                    c.a.n0.h.a.j.d.f(this.a.f8389d, this.a.k);
                } else {
                    c.a.n0.h.a.j.b.j(this.a.f8389d, this.a.k);
                    c.a.n0.h.a.j.b.q(this.a.f8389d, this.a.k);
                    String str = this.a.i;
                    b bVar = this.a;
                    c.a.n0.h.a.j.b.f(str, bVar.f8393h, bVar.l, this.a.k);
                }
                c.a.n0.h.a.j.b.n("show", this.a.A, this.a.k);
            }
        }

        @Override // c.a.n0.h.a.e.f
        public void onResume() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.a.f8387b == null) {
                return;
            }
            this.a.f8387b.D();
        }

        @Override // c.a.n0.h.a.e.f
        public void onStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            }
        }
    }

    /* loaded from: classes.dex */
    public static /* synthetic */ class g {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-47636904, "Lc/a/n0/h/a/i/b$g;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-47636904, "Lc/a/n0/h/a/i/b$g;");
                    return;
                }
            }
            int[] iArr = new int[CommandType.values().length];
            a = iArr;
            try {
                iArr[CommandType.ACTION_URL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[CommandType.GET_DOWNLOAD_STATUS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[CommandType.PAUSE_DOWNLOAD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[CommandType.DOWNLOAD_PERMISSION_CLICK.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[CommandType.DOWNLOAD_PRIVACY_CLICK.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1966527813, "Lc/a/n0/h/a/i/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1966527813, "Lc/a/n0/h/a/i/b;");
        }
    }

    public b(Activity activity, String str, String str2, boolean z, c.a.n0.h.a.i.a aVar, c.a.n0.h.a.e.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, str, str2, Boolean.valueOf(z), aVar, gVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f8390e = 256;
        this.f8391f = 0;
        this.f8393h = "";
        this.n = E;
        this.o = J;
        this.p = new HashMap();
        this.r = DownloadState.NOT_START;
        this.A = new TreeMap();
        Context appContext = AppRuntime.getAppContext();
        this.a = appContext;
        this.i = str;
        this.f8393h = str2;
        this.v = z;
        this.w = z;
        this.k = new c.a.n0.h.a.h.c(appContext);
        this.m = new c.a.n0.h.a.g.a();
        this.x = i.i();
        this.j = aVar;
        this.y = gVar;
        this.C = activity;
    }

    public synchronized void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this) {
                if (this.f8388c != null && this.f8387b != null) {
                    if (this.f8392g == null || !this.f8392g.isShowing()) {
                        if (!this.f8387b.t()) {
                            this.f8388c.resume();
                        } else {
                            c.a.n0.h.a.j.b.q(this.f8389d, this.k);
                        }
                    }
                }
            }
        }
    }

    public final c.a.n0.h.a.j.a O(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            c.a.n0.h.a.j.a aVar = new c.a.n0.h.a.j.a();
            aVar.i = String.valueOf(this.f8389d.getDuration());
            aVar.j = String.valueOf(this.f8391f);
            aVar.k = String.valueOf(i);
            String str = "1";
            aVar.l = this.f8391f == 0 ? "1" : "0";
            aVar.m = i == this.f8389d.getDuration() ? "1" : "0";
            int i2 = 1;
            aVar.n = this.a.getResources().getConfiguration().orientation == 1 ? "2" : "4";
            int i3 = this.f8391f;
            if (i3 != 0) {
                i2 = i3 == this.f8389d.getDuration() ? 3 : 2;
            }
            aVar.o = String.valueOf(i2);
            aVar.p = (this.f8391f == 0 && NetworkUtils.g(this.a)) ? "2" : "2";
            aVar.q = String.valueOf(0);
            return aVar;
        }
        return (c.a.n0.h.a.j.a) invokeI.objValue;
    }

    public final int P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            c.a.n0.h.a.f.b.c cVar = this.f8388c;
            if (cVar != null && cVar.isEnd()) {
                return this.f8388c.getDuration() / 1000;
            }
            return Q();
        }
        return invokeV.intValue;
    }

    public final int Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            c.a.n0.h.a.f.b.c cVar = this.f8388c;
            if (cVar != null) {
                return cVar.getCurrentPosition() / 1000;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public final void R() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.f8388c == null || this.f8387b == null) {
            return;
        }
        i0();
        this.f8390e = 262;
        if (this.f8387b != null) {
            if (this.f8388c.isEnd()) {
                this.f8387b.A();
            } else {
                this.f8387b.B();
            }
        }
    }

    public final void S() {
        c.a.n0.h.a.f.b.c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.j != null && (cVar = this.f8388c) != null) {
                int duration = cVar.getDuration() / 1000;
                this.j.c(this.f8388c.isEnd() || this.f8388c.getCurrentPosition() / 1000 >= Math.min(this.f8389d.getRewardTime(), duration), duration);
            }
            j0();
            if (this.f8389d.getActionType() == 2 && DownloadState.DOWNLOADING == this.r) {
                this.t = null;
                c.a.n0.h.a.f.a.b().d(this.a, this.s.a(), DownloadParams.SwanAppDownloadType.TYPE_PAUSE_DOWNLOAD, this.t);
            }
            c.a.n0.h.a.j.b.p(this.f8389d, this.k);
            this.f8390e = 263;
            c0();
        }
    }

    public final void T() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (c.a.n0.h.a.k.g.a(this.a, this.s.f29461b)) {
                this.n = G;
                f0(this.a, this.s.f29461b);
                this.q.c("appinstallopen");
                return;
            }
            DownloadState downloadState = this.r;
            if (downloadState == DownloadState.NOT_START || downloadState == DownloadState.DELETED) {
                this.n = D;
                c.a.n0.h.a.f.a.b().d(this.a, this.s.a(), DownloadParams.SwanAppDownloadType.TYPE_START_DOWNLOAD, this.t);
            }
            if (this.r == DownloadState.DOWNLOADING) {
                c.a.n0.h.a.f.a.b().d(this.a, this.s.a(), DownloadParams.SwanAppDownloadType.TYPE_PAUSE_DOWNLOAD, this.t);
            }
            if (this.r == DownloadState.DOWNLOAD_PAUSED) {
                this.o = J;
                c.a.n0.h.a.f.a.b().d(this.a, this.s.a(), DownloadParams.SwanAppDownloadType.TYPE_START_DOWNLOAD, this.t);
            }
            if (this.r == DownloadState.DOWNLOAD_FAILED) {
                c.a.n0.h.a.f.a.b().d(this.a, this.s.a(), DownloadParams.SwanAppDownloadType.TYPE_START_DOWNLOAD, this.t);
            }
            if (this.r == DownloadState.DOWNLOADED) {
                this.n = F;
                this.t.b();
                c.a.n0.h.a.f.a.b().d(this.a, this.s.a(), DownloadParams.SwanAppDownloadType.TYPE_INSTALL_APP, this.t);
            }
            if (this.r == DownloadState.INSTALLED) {
                f0(this.a, this.s.f29461b);
            }
        }
    }

    public final void U() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            S();
        }
    }

    public final void V(View view) {
        AdElementInfo adElementInfo;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view) == null) && this.v && (adElementInfo = this.f8389d) != null) {
            c.a.n0.h.a.j.d.d(adElementInfo, this.k);
            c.a.n0.h.a.j.a aVar = new c.a.n0.h.a.j.a();
            aVar.a = String.valueOf(h.i(this.a));
            aVar.f8394b = String.valueOf(h.h(this.a));
            aVar.f8395c = String.valueOf(h.i(this.a));
            aVar.f8396d = String.valueOf(h.h(this.a));
            aVar.f8397e = String.valueOf((int) view.getX());
            aVar.f8398f = String.valueOf((int) view.getY());
            aVar.f8399g = String.valueOf((int) view.getX());
            aVar.f8400h = String.valueOf((int) view.getY());
            if (this.f8389d.getActionType() == 2) {
                c.a.n0.h.a.j.d.a(aVar, this.f8389d, this.k, this);
                return;
            }
            AdElementInfo adElementInfo2 = this.f8389d;
            if (adElementInfo2 != null) {
                this.y.a(c.a.n0.h.a.j.d.c(adElementInfo2.getClickUrl(), aVar), new JSONObject());
            }
        }
    }

    public final void W() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            String clickUrl = this.f8389d.getClickUrl();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("monitorUrl", c.a.n0.h.a.j.b.b("landingPageLoad", this.A));
            } catch (JSONException unused) {
            }
            this.y.a(clickUrl, jSONObject);
        }
    }

    public final void X(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            c.a.n0.h.a.i.a aVar = this.j;
            if (aVar != null) {
                aVar.onError(str);
                this.j.b(false, "");
            }
            this.f8390e = 264;
        }
    }

    public final boolean Y(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, context, str)) == null) {
            if (context != null) {
                try {
                    if (context.getPackageManager() != null) {
                        context.getPackageManager().getPackageInfo(str, 0);
                        return true;
                    }
                    return false;
                } catch (Exception unused) {
                    return false;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final void Z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.q = new c.a.n0.h.a.j.c(this.a, this.f8389d.getAdMonitors());
            this.t = new e(this);
            String clickUrl = this.f8389d.getClickUrl();
            String packageName = this.f8389d.getPackageName();
            String str = this.p.get(packageName);
            if (str != null) {
                clickUrl = str;
            } else {
                this.p.put(packageName, clickUrl);
            }
            this.s = new DownloadParams(clickUrl, packageName, this.f8389d.getTitle());
            this.u = false;
            if (h.o()) {
                c.a.n0.h.a.f.a.b().d(this.a, this.s.a(), DownloadParams.SwanAppDownloadType.TYPE_QUERY_STATUS, this.t);
            }
        }
    }

    @Override // c.a.n0.h.a.e.c
    public synchronized void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            synchronized (this) {
                this.f8390e = ApkSignatureSchemeV2Verifier.SIGNATURE_RSA_PKCS1_V1_5_WITH_SHA256;
                d0(str);
            }
        }
    }

    public final void a0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.m.i(this);
            if (this.y.b()) {
                this.f8387b = new c.a.n0.h.a.l.b(this.a, this.f8389d, this.m);
            } else {
                this.f8387b = new c.a.n0.h.a.l.c(this.a, this.f8389d, this.m);
            }
            if (this.v) {
                this.f8387b.F(this);
            }
            this.f8387b.E(this);
            c.a.n0.h.a.f.b.c s = this.f8387b.s();
            this.f8388c = s;
            s.g(new f(this));
            this.f8387b.r().setAnimation(AnimationUtils.loadAnimation(this.a, R.anim.obfuscated_res_0x7f0100aa));
        }
    }

    @Override // c.a.n0.h.a.e.a
    public synchronized void b(CommandType commandType, Uri uri) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, commandType, uri) == null) {
            synchronized (this) {
                this.f8389d.getClickUrl();
                String packageName = this.f8389d.getPackageName();
                int i = g.a[commandType.ordinal()];
                if (i == 1) {
                    if (this.f8389d.getActionType() == 2) {
                        T();
                    } else {
                        W();
                        c.a.n0.h.a.j.b.n("lpClick", this.A, this.k);
                    }
                    c.a.n0.h.a.j.b.g(this.f8389d, this.k);
                    c.a.n0.h.a.j.b.n("click", this.A, this.k);
                } else if (i != 2) {
                    if (i == 3) {
                        this.o = I;
                        T();
                    } else if (i == 4) {
                        g0();
                    } else if (i == 5) {
                        h0();
                    }
                } else if (this.m == null) {
                } else {
                    if (Y(this.a, packageName)) {
                        this.n = G;
                    }
                    String queryParameter = uri.getQueryParameter(M);
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(K, this.n);
                        jSONObject.put(L, this.o);
                        this.m.b(queryParameter, jSONObject.toString());
                    } catch (JSONException unused) {
                    }
                }
            }
        }
    }

    public final boolean b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            AdElementInfo adElementInfo = this.f8389d;
            if (adElementInfo == null) {
                return true;
            }
            long expired = adElementInfo.getExpired() * 1000;
            if (expired == 0) {
                expired = 1740000;
            }
            return System.currentTimeMillis() - this.f8389d.getCreateTime() >= expired;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.n0.h.a.e.c
    public synchronized void c(AdElementInfo adElementInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, adElementInfo) == null) {
            synchronized (this) {
                this.f8389d = adElementInfo;
                this.v = adElementInfo.isGdtAd();
                this.f8390e = ApkSignatureSchemeV2Verifier.SIGNATURE_RSA_PSS_WITH_SHA512;
                e0();
                if (!this.v && this.f8389d.getActionType() == 2) {
                    Z();
                }
            }
        }
    }

    public synchronized void c0() {
        c.a.n0.h.a.h.f hVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            synchronized (this) {
                if (this.f8390e == 257) {
                    return;
                }
                c.a.n0.h.a.j.b.n("loadApi", this.A, this.k);
                c.a.n0.h.a.f.a.a().b(this.v);
                int i = this.f8390e;
                if (i != 256 && i != 272) {
                    switch (i) {
                        case ApkSignatureSchemeV2Verifier.SIGNATURE_RSA_PSS_WITH_SHA512 /* 258 */:
                            if (b0()) {
                                this.f8390e = 272;
                                return;
                            } else {
                                e0();
                                return;
                            }
                        case ApkSignatureSchemeV2Verifier.SIGNATURE_RSA_PKCS1_V1_5_WITH_SHA256 /* 259 */:
                        case 262:
                        case 263:
                        case 264:
                            break;
                        case 260:
                        case w0.F /* 261 */:
                        case 265:
                            d0("3010006");
                            return;
                        default:
                            return;
                    }
                }
                String appKey = c.a.n0.h.a.f.a.b().getAppKey();
                if (!TextUtils.isEmpty(appKey) && !TextUtils.isEmpty(this.i) && !TextUtils.isEmpty(this.f8393h)) {
                    this.f8390e = 257;
                    d.b bVar = new d.b();
                    bVar.m(this.i);
                    bVar.j(this.f8393h);
                    bVar.o(appKey);
                    bVar.l(h.i(this.a));
                    bVar.i(h.h(this.a));
                    bVar.n(this.z ? "game" : "app");
                    bVar.k("video");
                    c.a.n0.h.a.h.d h2 = bVar.h();
                    if (this.w) {
                        this.v = true;
                        hVar = new c.a.n0.h.a.h.g(this.a, h2, 5, 5);
                    } else {
                        this.v = false;
                        hVar = new c.a.n0.h.a.h.h(this.a, h2);
                        this.l = hVar.c();
                    }
                    c.a.n0.h.a.h.a aVar = new c.a.n0.h.a.h.a(this.a, false);
                    aVar.k(this);
                    aVar.i(hVar, this.k);
                    return;
                }
                d0("3010007");
            }
        }
    }

    @Override // c.a.n0.h.a.e.e
    public synchronized void d(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048595, this, str, str2) == null) {
            synchronized (this) {
                if (!TextUtils.isEmpty(str2)) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("url", str2);
                        jSONObject.put("title", this.f8389d.getTitle());
                        jSONObject.put("description", this.f8389d.getDescription());
                        jSONObject.put("autoinstall", true);
                        if (this.B == null) {
                            this.B = new c.a.n0.h.a.c.b(this.a, this.f8389d, this.k);
                        }
                        this.B.k(str);
                        c.a.n0.h.a.f.a.b().d(this.a, jSONObject, DownloadParams.SwanAppDownloadType.TYPE_START_DOWNLOAD, this.B);
                    } catch (JSONException unused) {
                    }
                }
            }
        }
    }

    public final void d0(String str) {
        c.a.n0.h.a.i.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048596, this, str) == null) || (aVar = this.j) == null) {
            return;
        }
        aVar.onError(str);
        this.j.a(false, str);
    }

    @Override // c.a.n0.h.a.e.d
    public synchronized void e(View view) {
        int min;
        int i;
        int i2;
        String format;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, view) == null) {
            synchronized (this) {
                if (this.f8388c != null && this.f8389d != null) {
                    if (this.f8392g == null || !this.f8392g.isShowing()) {
                        if (view != null && R.id.obfuscated_res_0x7f090663 != view.getId()) {
                            U();
                            return;
                        }
                        int currentPosition = this.f8388c.getCurrentPosition() / 1000;
                        int min2 = Math.min(this.f8389d.getRewardTime(), this.f8388c.getDuration() / 1000);
                        if (currentPosition >= min2) {
                            R();
                            return;
                        }
                        int q = c.a.n0.h.a.f.a.b().q();
                        int p = c.a.n0.h.a.f.a.b().p();
                        if (this.y.b()) {
                            min = (int) (q * 0.275f);
                            i2 = (int) (p * 0.05f);
                            i = min;
                        } else {
                            min = (int) (Math.min(q, p) * 0.1f);
                            i = min;
                            i2 = 0;
                        }
                        i0();
                        this.a.getResources().getString(R.string.obfuscated_res_0x7f0f1300);
                        if (this.x) {
                            format = String.format(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f1301), Integer.valueOf(15 - (this.f8388c.getCurrentPosition() / 1000)));
                        } else {
                            format = String.format(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f1303), Integer.valueOf(min2 - currentPosition));
                        }
                        if (this.f8392g != null) {
                            this.f8392g.d(format);
                            this.f8392g.show();
                        } else {
                            a.C0651a c0651a = new a.C0651a(this.C);
                            c0651a.c(true);
                            c0651a.i(R.string.obfuscated_res_0x7f0f00a1, new d(this));
                            c0651a.g(format);
                            c0651a.l(R.string.obfuscated_res_0x7f0f00a4, new c(this));
                            c0651a.n(R.color.obfuscated_res_0x7f060a13);
                            c0651a.k(new DialogInterface$OnDismissListenerC0663b(this));
                            c0651a.f(min, 0, i, i2);
                            this.f8392g = c0651a.p();
                        }
                    }
                }
            }
        }
    }

    public final void e0() {
        c.a.n0.h.a.i.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048598, this) == null) || (aVar = this.j) == null) {
            return;
        }
        aVar.a(true, "");
    }

    @Override // c.a.n0.h.a.e.e
    public synchronized void f(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, view) == null) {
            synchronized (this) {
                if (this.j != null) {
                    this.j.onClick(P());
                }
                if (this.v) {
                    V(view);
                }
            }
        }
    }

    public final boolean f0(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048600, this, context, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
            intent.addCategory("android.intent.category.LAUNCHER");
            intent.setPackage(str);
            List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
            if (queryIntentActivities == null || queryIntentActivities.size() <= 0 || queryIntentActivities.iterator().next() == null) {
                return false;
            }
            String str2 = queryIntentActivities.iterator().next().activityInfo.name;
            Intent intent2 = new Intent("android.intent.action.MAIN");
            intent2.addCategory("android.intent.category.LAUNCHER");
            intent2.setComponent(new ComponentName(str, str2));
            intent2.setFlags(LaunchTaskConstants.OTHER_PROCESS);
            return c.a.n0.h.a.f.a.b().b(context, intent2, c.a.n0.h.a.f.a.b().getAppKey(), null, str);
        }
        return invokeLL.booleanValue;
    }

    public final void g0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            this.y.a(this.f8389d.getPermissionUrl(), new JSONObject());
        }
    }

    public final void h0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            this.y.a(this.f8389d.getPrivacyUrl(), new JSONObject());
        }
    }

    public synchronized void i0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            synchronized (this) {
                if (this.f8388c != null && this.f8387b != null) {
                    if (this.f8388c.isPlaying()) {
                        this.f8388c.pause();
                        if (this.v) {
                            c.a.n0.h.a.j.d.g(O(Q()), this.f8389d, this.k);
                        } else {
                            c.a.n0.h.a.j.b.o(Q(), this.f8391f, this.f8389d, this.k);
                        }
                    } else {
                        c.a.n0.h.a.j.b.o(Q(), this.f8391f, this.f8389d, this.k);
                        this.f8391f = Q();
                    }
                }
            }
        }
    }

    public final void j0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            c.a.n0.h.a.f.b.c cVar = this.f8388c;
            if (cVar != null) {
                cVar.pause();
                this.f8388c.stop();
            }
            c.a.n0.h.a.l.a aVar = this.f8387b;
            if (aVar != null) {
                aVar.n();
                this.f8387b.r().setAnimation(AnimationUtils.loadAnimation(this.a, R.anim.obfuscated_res_0x7f0100a9));
                this.y.removeView(this.f8387b.r());
                this.f8387b = null;
            }
            c.a.n0.h.a.c.b bVar = this.B;
            if (bVar != null) {
                bVar.i();
                this.B = null;
            }
        }
    }

    public void k0(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, map) == null) {
            this.A = map;
            this.z = c.a.n0.h.a.j.b.c(map).equals("game");
        }
    }

    public synchronized void l0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            synchronized (this) {
                c.a.n0.h.a.j.b.n("showApi", this.A, this.k);
                if (this.f8390e != 261 && this.f8390e != 260 && this.f8390e != 265) {
                    if (this.f8390e == 258 && !b0()) {
                        if (this.f8389d != null && TextUtils.isEmpty(this.f8389d.getVideoUrl())) {
                            X("3010008");
                            return;
                        }
                        if (this.f8390e == 258) {
                            this.f8390e = 265;
                            this.y.e();
                            c.a.n0.h.a.k.d.c(new a(this));
                        }
                        return;
                    }
                    X("3010004");
                    return;
                }
                if (this.j != null) {
                    this.j.onError("3010004");
                    this.j.b(false, "3010004");
                }
            }
        }
    }

    public final void m0(DownloadState downloadState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, downloadState) == null) {
            this.r = downloadState;
            if (downloadState == DownloadState.NOT_START) {
                this.n = E;
                this.o = J;
            } else if (downloadState == DownloadState.DOWNLOAD_PAUSED) {
                this.n = D;
                this.o = I;
            } else if (downloadState == DownloadState.DOWNLOADED) {
                this.n = F;
                this.o = J;
            } else if (downloadState == DownloadState.INSTALLED) {
                this.n = G;
                this.o = J;
            } else if (downloadState == DownloadState.DOWNLOADING) {
                this.n = D;
                this.o = J;
            }
        }
    }
}
