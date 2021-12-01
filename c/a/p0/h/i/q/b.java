package c.a.p0.h.i.q;

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
import c.a.p0.h.i.p.d;
import c.a.p0.h.i.s.h;
import c.a.p0.h.i.s.i;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.idl.authority.AuthorityState;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.game.ad.component.AdAlertDialog;
import com.baidu.swan.game.ad.downloader.model.DownloadParams;
import com.baidu.swan.game.ad.downloader.model.DownloadState;
import com.baidu.swan.game.ad.entity.AdElementInfo;
import com.baidu.swan.game.ad.jsbridge.CommandType;
import com.baidu.swan.game.ad.utils.NetworkUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.paysdk.beans.PayBeanFactory;
import com.kuaishou.weapon.un.w0;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class b implements c.a.p0.h.i.m.c, c.a.p0.h.i.m.d, c.a.p0.h.i.m.a, c.a.p0.h.i.m.e {
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
    public c.a.p0.h.i.k.b B;
    public Activity C;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.p0.h.i.t.a f9738b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.p0.h.i.n.b.c f9739c;

    /* renamed from: d  reason: collision with root package name */
    public AdElementInfo f9740d;

    /* renamed from: e  reason: collision with root package name */
    public int f9741e;

    /* renamed from: f  reason: collision with root package name */
    public int f9742f;

    /* renamed from: g  reason: collision with root package name */
    public AdAlertDialog f9743g;

    /* renamed from: h  reason: collision with root package name */
    public String f9744h;

    /* renamed from: i  reason: collision with root package name */
    public String f9745i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.p0.h.i.q.a f9746j;

    /* renamed from: k  reason: collision with root package name */
    public c.a.p0.h.i.p.c f9747k;
    public String l;
    public c.a.p0.h.i.o.a m;
    public String n;
    public String o;
    public Map<String, String> p;
    public c.a.p0.h.i.r.c q;
    public DownloadState r;
    public DownloadParams s;
    public c.a.p0.h.i.k.f.a t;
    public boolean u;
    public boolean v;
    public boolean w;
    public boolean x;
    public c.a.p0.h.i.m.g y;
    public boolean z;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f9748e;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9748e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f9748e.a0();
                if (this.f9748e.y.c(this.f9748e.f9738b.r())) {
                    this.f9748e.y.removeView(this.f9748e.f9738b.r());
                }
                if (!this.f9748e.y.d(this.f9748e.f9738b.r(), c.a.p0.h.i.i.a.a())) {
                    this.f9748e.X("3010000");
                    return;
                }
                this.f9748e.f9741e = 260;
                this.f9748e.f9738b.G(this.f9748e.f9740d.getVideoUrl());
                c.a.p0.h.i.r.b.n("showSuccess", this.f9748e.A, this.f9748e.f9747k);
            }
        }
    }

    /* renamed from: c.a.p0.h.i.q.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class DialogInterface$OnDismissListenerC0611b implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public DialogInterface$OnDismissListenerC0611b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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

    /* loaded from: classes5.dex */
    public class c implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f9749e;

        public c(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9749e = bVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                this.f9749e.N();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f9750e;

        public d(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9750e = bVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                if (!this.f9750e.x || this.f9750e.f9738b == null) {
                    this.f9750e.S();
                    return;
                }
                if (this.f9750e.f9739c != null) {
                    this.f9750e.f9739c.pause();
                }
                this.f9750e.f9741e = 262;
                this.f9750e.f9738b.B();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements c.a.p0.h.i.k.f.a {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // c.a.p0.h.i.k.f.a
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || i2 == 0 || i2 > 100) {
                return;
            }
            if (i2 != 100 || this.a.n == b.E) {
                if (this.a.n == b.E || this.a.n == b.H) {
                    return;
                }
                this.a.n = String.valueOf(i2);
                return;
            }
            this.a.n = b.F;
        }

        @Override // c.a.p0.h.i.k.f.a
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.q.c("appinstallbegin");
            }
        }

        @Override // c.a.p0.h.i.k.f.a
        public void c(DownloadState downloadState, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, downloadState, i2) == null) {
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

        @Override // c.a.p0.h.i.k.f.a
        public void d(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            }
        }

        @Override // c.a.p0.h.i.k.f.a
        public String e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                this.a.q.c("appinstallopen");
                return "";
            }
            return (String) invokeV.objValue;
        }

        @Override // c.a.p0.h.i.k.f.a
        public void f(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements c.a.p0.h.i.m.f {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // c.a.p0.h.i.m.f
        public void onCompletion() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.R();
            }
        }

        @Override // c.a.p0.h.i.m.f
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

        @Override // c.a.p0.h.i.m.f
        public void onPause() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.a.f9738b == null) {
                return;
            }
            this.a.f9738b.z();
        }

        @Override // c.a.p0.h.i.m.f
        public void onPrepared() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                if (this.a.f9738b != null) {
                    this.a.f9738b.y();
                }
                this.a.f9741e = w0.F;
                this.a.f9742f = 0;
                if (this.a.f9738b != null) {
                    this.a.f9738b.p();
                }
                if (this.a.f9746j != null) {
                    this.a.f9746j.b(true, "");
                }
                if (this.a.v) {
                    c.a.p0.h.i.r.d.f(this.a.f9740d, this.a.f9747k);
                } else {
                    c.a.p0.h.i.r.b.j(this.a.f9740d, this.a.f9747k);
                    c.a.p0.h.i.r.b.q(this.a.f9740d, this.a.f9747k);
                    String str = this.a.f9745i;
                    b bVar = this.a;
                    c.a.p0.h.i.r.b.f(str, bVar.f9744h, bVar.l, this.a.f9747k);
                }
                c.a.p0.h.i.r.b.n("show", this.a.A, this.a.f9747k);
            }
        }

        @Override // c.a.p0.h.i.m.f
        public void onResume() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.a.f9738b == null) {
                return;
            }
            this.a.f9738b.D();
        }

        @Override // c.a.p0.h.i.m.f
        public void onStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public static /* synthetic */ class g {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(652171082, "Lc/a/p0/h/i/q/b$g;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(652171082, "Lc/a/p0/h/i/q/b$g;");
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
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1036191699, "Lc/a/p0/h/i/q/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1036191699, "Lc/a/p0/h/i/q/b;");
        }
    }

    public b(Activity activity, String str, String str2, boolean z, c.a.p0.h.i.q.a aVar, c.a.p0.h.i.m.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, str, str2, Boolean.valueOf(z), aVar, gVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f9741e = 256;
        this.f9742f = 0;
        this.f9744h = "";
        this.n = E;
        this.o = J;
        this.p = new HashMap();
        this.r = DownloadState.NOT_START;
        this.A = new TreeMap();
        Context appContext = AppRuntime.getAppContext();
        this.a = appContext;
        this.f9745i = str;
        this.f9744h = str2;
        this.v = z;
        this.w = z;
        this.f9747k = new c.a.p0.h.i.p.c(appContext);
        this.m = new c.a.p0.h.i.o.a();
        this.x = i.i();
        this.f9746j = aVar;
        this.y = gVar;
        this.C = activity;
    }

    public synchronized void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this) {
                if (this.f9739c != null && this.f9738b != null) {
                    if (this.f9743g == null || !this.f9743g.isShowing()) {
                        if (!this.f9738b.t()) {
                            this.f9739c.resume();
                        } else {
                            c.a.p0.h.i.r.b.q(this.f9740d, this.f9747k);
                        }
                    }
                }
            }
        }
    }

    public final c.a.p0.h.i.r.a O(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            c.a.p0.h.i.r.a aVar = new c.a.p0.h.i.r.a();
            aVar.f9758i = String.valueOf(this.f9740d.getDuration());
            aVar.f9759j = String.valueOf(this.f9742f);
            aVar.f9760k = String.valueOf(i2);
            String str = "1";
            aVar.l = this.f9742f == 0 ? "1" : "0";
            aVar.m = i2 == this.f9740d.getDuration() ? "1" : "0";
            int i3 = 1;
            aVar.n = this.a.getResources().getConfiguration().orientation == 1 ? "2" : "4";
            int i4 = this.f9742f;
            if (i4 != 0) {
                i3 = i4 == this.f9740d.getDuration() ? 3 : 2;
            }
            aVar.o = String.valueOf(i3);
            aVar.p = (this.f9742f == 0 && NetworkUtils.g(this.a)) ? "2" : "2";
            aVar.q = String.valueOf(0);
            return aVar;
        }
        return (c.a.p0.h.i.r.a) invokeI.objValue;
    }

    public final int P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            c.a.p0.h.i.n.b.c cVar = this.f9739c;
            if (cVar != null && cVar.isEnd()) {
                return this.f9739c.getDuration() / 1000;
            }
            return Q();
        }
        return invokeV.intValue;
    }

    public final int Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            c.a.p0.h.i.n.b.c cVar = this.f9739c;
            if (cVar != null) {
                return cVar.getCurrentPosition() / 1000;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public final void R() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.f9739c == null || this.f9738b == null) {
            return;
        }
        i0();
        this.f9741e = 262;
        if (this.f9738b != null) {
            if (this.f9739c.isEnd()) {
                this.f9738b.A();
            } else {
                this.f9738b.B();
            }
        }
    }

    public final void S() {
        c.a.p0.h.i.n.b.c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.f9746j != null && (cVar = this.f9739c) != null) {
                int duration = cVar.getDuration() / 1000;
                this.f9746j.c(this.f9739c.isEnd() || this.f9739c.getCurrentPosition() / 1000 >= Math.min(this.f9740d.getRewardTime(), duration), duration);
            }
            j0();
            if (this.f9740d.getActionType() == 2 && DownloadState.DOWNLOADING == this.r) {
                this.t = null;
                c.a.p0.h.i.n.a.b().d(this.a, this.s.a(), DownloadParams.SwanAppDownloadType.TYPE_PAUSE_DOWNLOAD, this.t);
            }
            c.a.p0.h.i.r.b.p(this.f9740d, this.f9747k);
            this.f9741e = PayBeanFactory.BEAN_ID_CREDIT_PAY;
            c0();
        }
    }

    public final void T() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (c.a.p0.h.i.s.g.a(this.a, this.s.f40391b)) {
                this.n = G;
                f0(this.a, this.s.f40391b);
                this.q.c("appinstallopen");
                return;
            }
            DownloadState downloadState = this.r;
            if (downloadState == DownloadState.NOT_START || downloadState == DownloadState.DELETED) {
                this.n = D;
                c.a.p0.h.i.n.a.b().d(this.a, this.s.a(), DownloadParams.SwanAppDownloadType.TYPE_START_DOWNLOAD, this.t);
            }
            if (this.r == DownloadState.DOWNLOADING) {
                c.a.p0.h.i.n.a.b().d(this.a, this.s.a(), DownloadParams.SwanAppDownloadType.TYPE_PAUSE_DOWNLOAD, this.t);
            }
            if (this.r == DownloadState.DOWNLOAD_PAUSED) {
                this.o = J;
                c.a.p0.h.i.n.a.b().d(this.a, this.s.a(), DownloadParams.SwanAppDownloadType.TYPE_START_DOWNLOAD, this.t);
            }
            if (this.r == DownloadState.DOWNLOAD_FAILED) {
                c.a.p0.h.i.n.a.b().d(this.a, this.s.a(), DownloadParams.SwanAppDownloadType.TYPE_START_DOWNLOAD, this.t);
            }
            if (this.r == DownloadState.DOWNLOADED) {
                this.n = F;
                this.t.b();
                c.a.p0.h.i.n.a.b().d(this.a, this.s.a(), DownloadParams.SwanAppDownloadType.TYPE_INSTALL_APP, this.t);
            }
            if (this.r == DownloadState.INSTALLED) {
                f0(this.a, this.s.f40391b);
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
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view) == null) && this.v && (adElementInfo = this.f9740d) != null) {
            c.a.p0.h.i.r.d.d(adElementInfo, this.f9747k);
            c.a.p0.h.i.r.a aVar = new c.a.p0.h.i.r.a();
            aVar.a = String.valueOf(h.i(this.a));
            aVar.f9751b = String.valueOf(h.h(this.a));
            aVar.f9752c = String.valueOf(h.i(this.a));
            aVar.f9753d = String.valueOf(h.h(this.a));
            aVar.f9754e = String.valueOf((int) view.getX());
            aVar.f9755f = String.valueOf((int) view.getY());
            aVar.f9756g = String.valueOf((int) view.getX());
            aVar.f9757h = String.valueOf((int) view.getY());
            if (this.f9740d.getActionType() == 2) {
                c.a.p0.h.i.r.d.a(aVar, this.f9740d, this.f9747k, this);
                return;
            }
            AdElementInfo adElementInfo2 = this.f9740d;
            if (adElementInfo2 != null) {
                this.y.a(c.a.p0.h.i.r.d.c(adElementInfo2.getClickUrl(), aVar), new JSONObject());
            }
        }
    }

    public final void W() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            String clickUrl = this.f9740d.getClickUrl();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("monitorUrl", c.a.p0.h.i.r.b.b("landingPageLoad", this.A));
            } catch (JSONException unused) {
            }
            this.y.a(clickUrl, jSONObject);
        }
    }

    public final void X(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            c.a.p0.h.i.q.a aVar = this.f9746j;
            if (aVar != null) {
                aVar.onError(str);
                this.f9746j.b(false, "");
            }
            this.f9741e = PayBeanFactory.BEAN_ID_SEND_SMS_FOR_VERIFY_BY_BANK;
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
            this.q = new c.a.p0.h.i.r.c(this.a, this.f9740d.getAdMonitors());
            this.t = new e(this);
            String clickUrl = this.f9740d.getClickUrl();
            String packageName = this.f9740d.getPackageName();
            String str = this.p.get(packageName);
            if (str != null) {
                clickUrl = str;
            } else {
                this.p.put(packageName, clickUrl);
            }
            this.s = new DownloadParams(clickUrl, packageName, this.f9740d.getTitle());
            this.u = false;
            if (h.o()) {
                c.a.p0.h.i.n.a.b().d(this.a, this.s.a(), DownloadParams.SwanAppDownloadType.TYPE_QUERY_STATUS, this.t);
            }
        }
    }

    @Override // c.a.p0.h.i.m.c
    public synchronized void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            synchronized (this) {
                this.f9741e = 259;
                d0(str);
            }
        }
    }

    public final void a0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.m.i(this);
            if (this.y.b()) {
                this.f9738b = new c.a.p0.h.i.t.b(this.a, this.f9740d, this.m);
            } else {
                this.f9738b = new c.a.p0.h.i.t.c(this.a, this.f9740d, this.m);
            }
            if (this.v) {
                this.f9738b.F(this);
            }
            this.f9738b.E(this);
            c.a.p0.h.i.n.b.c s = this.f9738b.s();
            this.f9739c = s;
            s.g(new f(this));
            this.f9738b.r().setAnimation(AnimationUtils.loadAnimation(this.a, c.a.p0.h.i.a.ng_game_ad_open));
        }
    }

    @Override // c.a.p0.h.i.m.a
    public synchronized void b(CommandType commandType, Uri uri) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, commandType, uri) == null) {
            synchronized (this) {
                this.f9740d.getClickUrl();
                String packageName = this.f9740d.getPackageName();
                int i2 = g.a[commandType.ordinal()];
                if (i2 == 1) {
                    if (this.f9740d.getActionType() == 2) {
                        T();
                    } else {
                        W();
                        c.a.p0.h.i.r.b.n("lpClick", this.A, this.f9747k);
                    }
                    c.a.p0.h.i.r.b.g(this.f9740d, this.f9747k);
                    c.a.p0.h.i.r.b.n("click", this.A, this.f9747k);
                } else if (i2 != 2) {
                    if (i2 == 3) {
                        this.o = I;
                        T();
                    } else if (i2 == 4) {
                        g0();
                    } else if (i2 == 5) {
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
            AdElementInfo adElementInfo = this.f9740d;
            if (adElementInfo == null) {
                return true;
            }
            long expired = adElementInfo.getExpired() * 1000;
            if (expired == 0) {
                expired = 1740000;
            }
            return System.currentTimeMillis() - this.f9740d.getCreateTime() >= expired;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.p0.h.i.m.c
    public synchronized void c(AdElementInfo adElementInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, adElementInfo) == null) {
            synchronized (this) {
                this.f9740d = adElementInfo;
                this.v = adElementInfo.isGdtAd();
                this.f9741e = 258;
                e0();
                if (!this.v && this.f9740d.getActionType() == 2) {
                    Z();
                }
            }
        }
    }

    public synchronized void c0() {
        c.a.p0.h.i.p.f hVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            synchronized (this) {
                if (this.f9741e == 257) {
                    return;
                }
                c.a.p0.h.i.r.b.n("loadApi", this.A, this.f9747k);
                c.a.p0.h.i.n.a.a().b(this.v);
                int i2 = this.f9741e;
                if (i2 != 256 && i2 != 272) {
                    switch (i2) {
                        case 258:
                            if (b0()) {
                                this.f9741e = AuthorityState.STATE_INIT_ING;
                                return;
                            } else {
                                e0();
                                return;
                            }
                        case 259:
                        case 262:
                        case PayBeanFactory.BEAN_ID_CREDIT_PAY /* 263 */:
                        case PayBeanFactory.BEAN_ID_SEND_SMS_FOR_VERIFY_BY_BANK /* 264 */:
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
                String appKey = c.a.p0.h.i.n.a.b().getAppKey();
                if (!TextUtils.isEmpty(appKey) && !TextUtils.isEmpty(this.f9745i) && !TextUtils.isEmpty(this.f9744h)) {
                    this.f9741e = 257;
                    d.b bVar = new d.b();
                    bVar.m(this.f9745i);
                    bVar.j(this.f9744h);
                    bVar.o(appKey);
                    bVar.l(h.i(this.a));
                    bVar.i(h.h(this.a));
                    bVar.n(this.z ? "game" : "app");
                    bVar.k("video");
                    c.a.p0.h.i.p.d h2 = bVar.h();
                    if (this.w) {
                        this.v = true;
                        hVar = new c.a.p0.h.i.p.g(this.a, h2, 5, 5);
                    } else {
                        this.v = false;
                        hVar = new c.a.p0.h.i.p.h(this.a, h2);
                        this.l = hVar.c();
                    }
                    c.a.p0.h.i.p.a aVar = new c.a.p0.h.i.p.a(this.a, false);
                    aVar.k(this);
                    aVar.i(hVar, this.f9747k);
                    return;
                }
                d0("3010007");
            }
        }
    }

    @Override // c.a.p0.h.i.m.e
    public synchronized void d(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048595, this, str, str2) == null) {
            synchronized (this) {
                if (!TextUtils.isEmpty(str2)) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("url", str2);
                        jSONObject.put("title", this.f9740d.getTitle());
                        jSONObject.put("description", this.f9740d.getDescription());
                        jSONObject.put("autoinstall", true);
                        if (this.B == null) {
                            this.B = new c.a.p0.h.i.k.b(this.a, this.f9740d, this.f9747k);
                        }
                        this.B.k(str);
                        c.a.p0.h.i.n.a.b().d(this.a, jSONObject, DownloadParams.SwanAppDownloadType.TYPE_START_DOWNLOAD, this.B);
                    } catch (JSONException unused) {
                    }
                }
            }
        }
    }

    public final void d0(String str) {
        c.a.p0.h.i.q.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048596, this, str) == null) || (aVar = this.f9746j) == null) {
            return;
        }
        aVar.onError(str);
        this.f9746j.a(false, str);
    }

    @Override // c.a.p0.h.i.m.d
    public synchronized void e(View view) {
        int min;
        int i2;
        int i3;
        String format;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, view) == null) {
            synchronized (this) {
                if (this.f9739c != null && this.f9740d != null) {
                    if (this.f9743g == null || !this.f9743g.isShowing()) {
                        if (view != null && c.a.p0.h.i.e.close_ad != view.getId()) {
                            U();
                            return;
                        }
                        int currentPosition = this.f9739c.getCurrentPosition() / 1000;
                        int min2 = Math.min(this.f9740d.getRewardTime(), this.f9739c.getDuration() / 1000);
                        if (currentPosition >= min2) {
                            R();
                            return;
                        }
                        int q = c.a.p0.h.i.n.a.b().q();
                        int p = c.a.p0.h.i.n.a.b().p();
                        if (this.y.b()) {
                            min = (int) (q * 0.275f);
                            i3 = (int) (p * 0.05f);
                            i2 = min;
                        } else {
                            min = (int) (Math.min(q, p) * 0.1f);
                            i2 = min;
                            i3 = 0;
                        }
                        i0();
                        this.a.getResources().getString(c.a.p0.h.i.g.swangame_game_ad_dialog_msg_more);
                        if (this.x) {
                            format = String.format(this.a.getResources().getString(c.a.p0.h.i.g.swangame_game_ad_reward_msg_time_tip), Integer.valueOf(15 - (this.f9739c.getCurrentPosition() / 1000)));
                        } else {
                            format = String.format(this.a.getResources().getString(c.a.p0.h.i.g.swangame_game_ad_video_close_alert), Integer.valueOf(min2 - currentPosition));
                        }
                        if (this.f9743g != null) {
                            this.f9743g.setMessage(format);
                            this.f9743g.show();
                        } else {
                            AdAlertDialog.a aVar = new AdAlertDialog.a(this.C);
                            aVar.c(true);
                            aVar.i(c.a.p0.h.i.g.ad_close, new d(this));
                            aVar.g(format);
                            aVar.l(c.a.p0.h.i.g.ad_continue_watch, new c(this));
                            aVar.n(c.a.p0.h.i.b.swan_ad_game_continue_watch);
                            aVar.k(new DialogInterface$OnDismissListenerC0611b(this));
                            aVar.f(min, 0, i2, i3);
                            this.f9743g = aVar.p();
                        }
                    }
                }
            }
        }
    }

    public final void e0() {
        c.a.p0.h.i.q.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048598, this) == null) || (aVar = this.f9746j) == null) {
            return;
        }
        aVar.a(true, "");
    }

    @Override // c.a.p0.h.i.m.e
    public synchronized void f(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, view) == null) {
            synchronized (this) {
                if (this.f9746j != null) {
                    this.f9746j.onClick(P());
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
            intent2.setFlags(268435456);
            return c.a.p0.h.i.n.a.b().b(context, intent2, c.a.p0.h.i.n.a.b().getAppKey(), null, str);
        }
        return invokeLL.booleanValue;
    }

    public final void g0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            this.y.a(this.f9740d.getPermissionUrl(), new JSONObject());
        }
    }

    public final void h0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            this.y.a(this.f9740d.getPrivacyUrl(), new JSONObject());
        }
    }

    public synchronized void i0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            synchronized (this) {
                if (this.f9739c != null && this.f9738b != null) {
                    if (this.f9739c.isPlaying()) {
                        this.f9739c.pause();
                        if (this.v) {
                            c.a.p0.h.i.r.d.g(O(Q()), this.f9740d, this.f9747k);
                        } else {
                            c.a.p0.h.i.r.b.o(Q(), this.f9742f, this.f9740d, this.f9747k);
                        }
                    } else {
                        c.a.p0.h.i.r.b.o(Q(), this.f9742f, this.f9740d, this.f9747k);
                        this.f9742f = Q();
                    }
                }
            }
        }
    }

    public final void j0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            c.a.p0.h.i.n.b.c cVar = this.f9739c;
            if (cVar != null) {
                cVar.pause();
                this.f9739c.stop();
            }
            c.a.p0.h.i.t.a aVar = this.f9738b;
            if (aVar != null) {
                aVar.n();
                this.f9738b.r().setAnimation(AnimationUtils.loadAnimation(this.a, c.a.p0.h.i.a.ng_game_ad_close));
                this.y.removeView(this.f9738b.r());
                this.f9738b = null;
            }
            c.a.p0.h.i.k.b bVar = this.B;
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
            this.z = c.a.p0.h.i.r.b.c(map).equals("game");
        }
    }

    public synchronized void l0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            synchronized (this) {
                c.a.p0.h.i.r.b.n("showApi", this.A, this.f9747k);
                if (this.f9741e != 261 && this.f9741e != 260 && this.f9741e != 265) {
                    if (this.f9741e == 258 && !b0()) {
                        if (this.f9740d != null && TextUtils.isEmpty(this.f9740d.getVideoUrl())) {
                            X("3010008");
                            return;
                        }
                        if (this.f9741e == 258) {
                            this.f9741e = 265;
                            this.y.e();
                            c.a.p0.h.i.s.d.c(new a(this));
                        }
                        return;
                    }
                    X("3010004");
                    return;
                }
                if (this.f9746j != null) {
                    this.f9746j.onError("3010004");
                    this.f9746j.b(false, "3010004");
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
