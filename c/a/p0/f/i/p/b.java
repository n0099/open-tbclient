package c.a.p0.f.i.p;

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
import c.a.p0.f.i.o.c;
import c.a.p0.f.i.r.h;
import c.a.p0.f.i.r.i;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.idl.authority.AuthorityState;
import com.baidu.mobads.container.widget.player.PlayerEvent;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b implements c.a.p0.f.i.l.b, c.a.p0.f.i.l.c, c.a.p0.f.i.l.a, c.a.p0.f.i.l.d {
    public static /* synthetic */ Interceptable $ic = null;
    public static String E = "0";
    public static String F = "101";
    public static String G = "102";
    public static String H = "103";
    public static String I = "104";
    public static String J = "1";
    public static String K = "0";
    public static String L = "status";
    public static String M = "isPaused";
    public static String N = "token";
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public Map<String, String> B;
    public c.a.p0.f.i.k.b C;
    public Activity D;

    /* renamed from: a  reason: collision with root package name */
    public Context f10661a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.p0.f.i.s.a f10662b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.p0.f.i.m.b.c f10663c;

    /* renamed from: d  reason: collision with root package name */
    public AdElementInfo f10664d;

    /* renamed from: e  reason: collision with root package name */
    public int f10665e;

    /* renamed from: f  reason: collision with root package name */
    public int f10666f;

    /* renamed from: g  reason: collision with root package name */
    public AdAlertDialog f10667g;

    /* renamed from: h  reason: collision with root package name */
    public String f10668h;

    /* renamed from: i  reason: collision with root package name */
    public String f10669i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.p0.f.i.p.a f10670j;
    public c.a.p0.f.i.o.b k;
    public String l;
    public c.a.p0.f.i.n.a m;
    public String n;
    public String o;
    public Map<String, String> p;
    public c.a.p0.f.i.q.c q;
    public DownloadState r;
    public DownloadParams s;
    public c.a.p0.f.i.k.f.a t;
    public boolean u;
    public boolean v;
    public boolean w;
    public boolean x;
    public c.a.p0.f.i.l.f y;
    public boolean z;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f10671e;

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
            this.f10671e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f10671e.c0();
                if (this.f10671e.y.c(this.f10671e.f10662b.r())) {
                    this.f10671e.y.removeView(this.f10671e.f10662b.r());
                }
                if (!this.f10671e.y.d(this.f10671e.f10662b.r(), c.a.p0.f.i.i.a.d())) {
                    this.f10671e.Z("3010000");
                    return;
                }
                this.f10671e.f10665e = 260;
                this.f10671e.f10662b.G(this.f10671e.f10664d.getVideoUrl());
                c.a.p0.f.i.q.b.n("showSuccess", this.f10671e.B, this.f10671e.k);
            }
        }
    }

    /* renamed from: c.a.p0.f.i.p.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class DialogInterface$OnDismissListenerC0532b implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public DialogInterface$OnDismissListenerC0532b(b bVar) {
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

    /* loaded from: classes.dex */
    public class c implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f10672e;

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
            this.f10672e = bVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                this.f10672e.P();
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f10673e;

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
            this.f10673e = bVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                if (!this.f10673e.x || this.f10673e.f10662b == null) {
                    this.f10673e.U();
                    return;
                }
                if (this.f10673e.f10663c != null) {
                    this.f10673e.f10663c.pause();
                }
                this.f10673e.f10665e = PlayerEvent.PLAY_LOADING_END;
                this.f10673e.f10662b.B();
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements c.a.p0.f.i.k.f.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f10674a;

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
            this.f10674a = bVar;
        }

        @Override // c.a.p0.f.i.k.f.a
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || i2 == 0 || i2 > 100) {
                return;
            }
            if (i2 != 100 || this.f10674a.n == b.F) {
                if (this.f10674a.n == b.F || this.f10674a.n == b.I) {
                    return;
                }
                this.f10674a.n = String.valueOf(i2);
                return;
            }
            this.f10674a.n = b.G;
        }

        @Override // c.a.p0.f.i.k.f.a
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f10674a.q.c("appinstallbegin");
            }
        }

        @Override // c.a.p0.f.i.k.f.a
        public void c(DownloadState downloadState, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, downloadState, i2) == null) {
                if (!this.f10674a.u) {
                    this.f10674a.m0(downloadState);
                }
                this.f10674a.u = true;
                if (this.f10674a.r == downloadState) {
                    return;
                }
                if (this.f10674a.r == DownloadState.NOT_START && downloadState == DownloadState.DOWNLOADING) {
                    this.f10674a.o = b.K;
                    this.f10674a.q.c("appdownloadbegin");
                } else if (downloadState != DownloadState.DOWNLOAD_PAUSED) {
                    if (this.f10674a.r == DownloadState.DOWNLOAD_PAUSED && downloadState == DownloadState.DOWNLOADING) {
                        this.f10674a.o = b.K;
                        this.f10674a.q.c("appdownloadcontinue");
                    } else if (downloadState == DownloadState.DOWNLOADED) {
                        this.f10674a.o = b.K;
                        this.f10674a.n = b.G;
                        this.f10674a.q.c("appdownloadfinish");
                        this.f10674a.q.c("appinstallbegin");
                    } else if (downloadState == DownloadState.INSTALLED) {
                        this.f10674a.o = b.K;
                        this.f10674a.n = b.H;
                        this.f10674a.q.c("appinstallfinish");
                    } else if (downloadState == DownloadState.DOWNLOAD_FAILED) {
                        this.f10674a.o = b.K;
                        this.f10674a.n = b.I;
                    }
                } else {
                    this.f10674a.o = b.J;
                    this.f10674a.q.c("appdownloadpause");
                }
                this.f10674a.r = downloadState;
            }
        }

        @Override // c.a.p0.f.i.k.f.a
        public void d(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            }
        }

        @Override // c.a.p0.f.i.k.f.a
        public String e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                this.f10674a.q.c("appinstallopen");
                return "";
            }
            return (String) invokeV.objValue;
        }

        @Override // c.a.p0.f.i.k.f.a
        public void f(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            }
        }
    }

    /* loaded from: classes.dex */
    public class f implements c.a.p0.f.i.l.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f10675a;

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
            this.f10675a = bVar;
        }

        @Override // c.a.p0.f.i.l.e
        public void onCompletion() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f10675a.A = false;
                this.f10675a.T();
            }
        }

        @Override // c.a.p0.f.i.l.e
        public boolean onError() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                this.f10675a.j0();
                this.f10675a.Z("3010001");
                return true;
            }
            return invokeV.booleanValue;
        }

        @Override // c.a.p0.f.i.l.e
        public void onPause() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.f10675a.A) {
                this.f10675a.i0();
                this.f10675a.A = false;
            }
        }

        @Override // c.a.p0.f.i.l.e
        public void onPrepared() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                if (this.f10675a.f10662b != null) {
                    this.f10675a.f10662b.y();
                }
                this.f10675a.f10665e = PlayerEvent.PLAY_LOADING_START;
                this.f10675a.f10666f = 0;
                if (this.f10675a.f10662b != null) {
                    this.f10675a.f10662b.p();
                }
                if (this.f10675a.f10670j != null) {
                    this.f10675a.f10670j.b(true, "");
                }
                if (this.f10675a.v) {
                    c.a.p0.f.i.q.d.f(this.f10675a.f10664d, this.f10675a.k);
                } else {
                    c.a.p0.f.i.q.b.j(this.f10675a.f10664d, this.f10675a.k);
                    c.a.p0.f.i.q.b.q(this.f10675a.f10664d, this.f10675a.k);
                    String str = this.f10675a.f10669i;
                    b bVar = this.f10675a;
                    c.a.p0.f.i.q.b.f(str, bVar.f10668h, bVar.l, this.f10675a.k);
                }
                c.a.p0.f.i.q.b.n("show", this.f10675a.B, this.f10675a.k);
            }
        }

        @Override // c.a.p0.f.i.l.e
        public void onResume() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.f10675a.A = true;
                this.f10675a.P();
            }
        }

        @Override // c.a.p0.f.i.l.e
        public void onStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                this.f10675a.A = true;
            }
        }
    }

    /* loaded from: classes.dex */
    public static /* synthetic */ class g {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f10676a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1016568941, "Lc/a/p0/f/i/p/b$g;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1016568941, "Lc/a/p0/f/i/p/b$g;");
                    return;
                }
            }
            int[] iArr = new int[CommandType.values().length];
            f10676a = iArr;
            try {
                iArr[CommandType.ACTION_URL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f10676a[CommandType.GET_DOWNLOAD_STATUS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f10676a[CommandType.PAUSE_DOWNLOAD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-226874864, "Lc/a/p0/f/i/p/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-226874864, "Lc/a/p0/f/i/p/b;");
        }
    }

    public b(Activity activity, String str, String str2, boolean z, c.a.p0.f.i.p.a aVar, c.a.p0.f.i.l.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, str, str2, Boolean.valueOf(z), aVar, fVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f10665e = 256;
        this.f10666f = 0;
        this.f10668h = "";
        this.n = F;
        this.o = K;
        this.p = new HashMap();
        this.r = DownloadState.NOT_START;
        this.A = false;
        this.B = new TreeMap();
        Context appContext = AppRuntime.getAppContext();
        this.f10661a = appContext;
        this.f10669i = str;
        this.f10668h = str2;
        this.v = z;
        this.w = z;
        this.k = new c.a.p0.f.i.o.b(appContext);
        this.m = new c.a.p0.f.i.n.a();
        this.x = i.i();
        this.f10670j = aVar;
        this.y = fVar;
        this.D = activity;
    }

    public synchronized void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this) {
                if (this.f10663c != null && this.f10662b != null) {
                    if (this.f10667g == null || !this.f10667g.isShowing()) {
                        if (!this.A && !this.f10662b.t()) {
                            this.f10663c.resume();
                            this.f10662b.D();
                        } else {
                            c.a.p0.f.i.q.b.q(this.f10664d, this.k);
                        }
                    }
                }
            }
        }
    }

    public final c.a.p0.f.i.q.a Q(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            c.a.p0.f.i.q.a aVar = new c.a.p0.f.i.q.a();
            aVar.f10685i = String.valueOf(this.f10664d.getDuration());
            aVar.f10686j = String.valueOf(this.f10666f);
            aVar.k = String.valueOf(i2);
            String str = "1";
            aVar.l = this.f10666f == 0 ? "1" : "0";
            aVar.m = i2 == this.f10664d.getDuration() ? "1" : "0";
            int i3 = 1;
            aVar.n = this.f10661a.getResources().getConfiguration().orientation == 1 ? "2" : "4";
            int i4 = this.f10666f;
            if (i4 != 0) {
                i3 = i4 == this.f10664d.getDuration() ? 3 : 2;
            }
            aVar.o = String.valueOf(i3);
            aVar.p = (this.f10666f == 0 && NetworkUtils.g(this.f10661a)) ? "2" : "2";
            aVar.q = String.valueOf(0);
            return aVar;
        }
        return (c.a.p0.f.i.q.a) invokeI.objValue;
    }

    public final int R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            c.a.p0.f.i.m.b.c cVar = this.f10663c;
            if (cVar != null && cVar.isEnd()) {
                return this.f10663c.getDuration() / 1000;
            }
            return S();
        }
        return invokeV.intValue;
    }

    public final int S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            c.a.p0.f.i.m.b.c cVar = this.f10663c;
            if (cVar != null) {
                return cVar.getCurrentPosition() / 1000;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public final void T() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.f10663c == null || this.f10662b == null) {
            return;
        }
        i0();
        this.f10665e = PlayerEvent.PLAY_LOADING_END;
        if (this.f10662b != null) {
            if (this.f10663c.isEnd()) {
                this.f10662b.A();
            } else {
                this.f10662b.B();
            }
        }
    }

    public final void U() {
        c.a.p0.f.i.m.b.c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.f10670j != null && (cVar = this.f10663c) != null) {
                int duration = cVar.getDuration() / 1000;
                this.f10670j.c(this.f10663c.isEnd() || this.f10663c.getCurrentPosition() / 1000 >= Math.min(this.f10664d.getRewardTime(), duration), duration);
            }
            j0();
            if (this.f10664d.getActionType() == 2 && DownloadState.DOWNLOADING == this.r) {
                this.t = null;
                c.a.p0.f.i.m.a.b().b(this.f10661a, this.s.a(), DownloadParams.SwanAppDownloadType.TYPE_PAUSE_DOWNLOAD, this.t);
            }
            c.a.p0.f.i.q.b.p(this.f10664d, this.k);
            this.f10665e = PayBeanFactory.BEAN_ID_CREDIT_PAY;
            e0();
        }
    }

    public final void V() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (c.a.p0.f.i.r.g.a(this.f10661a, this.s.f46997b)) {
                this.n = H;
                h0(this.f10661a, this.s.f46997b);
                this.q.c("appinstallopen");
                return;
            }
            DownloadState downloadState = this.r;
            if (downloadState == DownloadState.NOT_START || downloadState == DownloadState.DELETED) {
                this.n = E;
                c.a.p0.f.i.m.a.b().b(this.f10661a, this.s.a(), DownloadParams.SwanAppDownloadType.TYPE_START_DOWNLOAD, this.t);
            }
            if (this.r == DownloadState.DOWNLOADING) {
                c.a.p0.f.i.m.a.b().b(this.f10661a, this.s.a(), DownloadParams.SwanAppDownloadType.TYPE_PAUSE_DOWNLOAD, this.t);
            }
            if (this.r == DownloadState.DOWNLOAD_PAUSED) {
                this.o = K;
                c.a.p0.f.i.m.a.b().b(this.f10661a, this.s.a(), DownloadParams.SwanAppDownloadType.TYPE_START_DOWNLOAD, this.t);
            }
            if (this.r == DownloadState.DOWNLOAD_FAILED) {
                c.a.p0.f.i.m.a.b().b(this.f10661a, this.s.a(), DownloadParams.SwanAppDownloadType.TYPE_START_DOWNLOAD, this.t);
            }
            if (this.r == DownloadState.DOWNLOADED) {
                this.n = G;
                this.t.b();
                c.a.p0.f.i.m.a.b().b(this.f10661a, this.s.a(), DownloadParams.SwanAppDownloadType.TYPE_INSTALL_APP, this.t);
            }
            if (this.r == DownloadState.INSTALLED) {
                h0(this.f10661a, this.s.f46997b);
            }
        }
    }

    public final void W() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            U();
        }
    }

    public final void X(View view) {
        AdElementInfo adElementInfo;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view) == null) && this.v && (adElementInfo = this.f10664d) != null) {
            c.a.p0.f.i.q.d.d(adElementInfo, this.k);
            c.a.p0.f.i.q.a aVar = new c.a.p0.f.i.q.a();
            aVar.f10677a = String.valueOf(h.i(this.f10661a));
            aVar.f10678b = String.valueOf(h.h(this.f10661a));
            aVar.f10679c = String.valueOf(h.i(this.f10661a));
            aVar.f10680d = String.valueOf(h.h(this.f10661a));
            aVar.f10681e = String.valueOf((int) view.getX());
            aVar.f10682f = String.valueOf((int) view.getY());
            aVar.f10683g = String.valueOf((int) view.getX());
            aVar.f10684h = String.valueOf((int) view.getY());
            if (this.f10664d.getActionType() == 2) {
                c.a.p0.f.i.q.d.a(aVar, this.f10664d, this.k, this);
                return;
            }
            AdElementInfo adElementInfo2 = this.f10664d;
            if (adElementInfo2 != null) {
                this.y.a(c.a.p0.f.i.q.d.c(adElementInfo2.getClickUrl(), aVar), new JSONObject());
            }
        }
    }

    public final void Y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            String clickUrl = this.f10664d.getClickUrl();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("monitorUrl", c.a.p0.f.i.q.b.b("landingPageLoad", this.B));
            } catch (JSONException unused) {
            }
            this.y.a(clickUrl, jSONObject);
        }
    }

    public final void Z(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            c.a.p0.f.i.p.a aVar = this.f10670j;
            if (aVar != null) {
                aVar.onError(str);
                this.f10670j.b(false, "");
            }
            this.f10665e = PayBeanFactory.BEAN_ID_SEND_SMS_FOR_VERIFY_BY_BANK;
        }
    }

    @Override // c.a.p0.f.i.l.b
    public synchronized void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            synchronized (this) {
                this.f10665e = 259;
                f0(str);
            }
        }
    }

    public final boolean a0(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, context, str)) == null) {
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

    @Override // c.a.p0.f.i.l.a
    public synchronized void b(CommandType commandType, Uri uri) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, commandType, uri) == null) {
            synchronized (this) {
                this.f10664d.getClickUrl();
                String packageName = this.f10664d.getPackageName();
                int i2 = g.f10676a[commandType.ordinal()];
                if (i2 == 1) {
                    if (this.f10664d.getActionType() == 2) {
                        V();
                    } else {
                        Y();
                        c.a.p0.f.i.q.b.n("lpClick", this.B, this.k);
                    }
                    c.a.p0.f.i.q.b.g(this.f10664d, this.k);
                    c.a.p0.f.i.q.b.n(PrefetchEvent.STATE_CLICK, this.B, this.k);
                } else if (i2 != 2) {
                    if (i2 == 3) {
                        this.o = J;
                        V();
                    }
                } else if (this.m == null) {
                } else {
                    if (a0(this.f10661a, packageName)) {
                        this.n = H;
                    }
                    String queryParameter = uri.getQueryParameter(N);
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(L, this.n);
                        jSONObject.put(M, this.o);
                        this.m.b(queryParameter, jSONObject.toString());
                    } catch (JSONException unused) {
                    }
                }
            }
        }
    }

    public final void b0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.q = new c.a.p0.f.i.q.c(this.f10661a, this.f10664d.getAdMonitors());
            this.t = new e(this);
            String clickUrl = this.f10664d.getClickUrl();
            String packageName = this.f10664d.getPackageName();
            String str = this.p.get(packageName);
            if (str != null) {
                clickUrl = str;
            } else {
                this.p.put(packageName, clickUrl);
            }
            this.s = new DownloadParams(clickUrl, packageName, this.f10664d.getTitle());
            this.u = false;
            if (h.o()) {
                c.a.p0.f.i.m.a.b().b(this.f10661a, this.s.a(), DownloadParams.SwanAppDownloadType.TYPE_QUERY_STATUS, this.t);
            }
        }
    }

    @Override // c.a.p0.f.i.l.b
    public synchronized void c(AdElementInfo adElementInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, adElementInfo) == null) {
            synchronized (this) {
                this.f10664d = adElementInfo;
                this.v = adElementInfo.isGdtAd();
                this.f10665e = 258;
                g0();
                if (!this.v && this.f10664d.getActionType() == 2) {
                    b0();
                }
            }
        }
    }

    public final void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.m.i(this);
            if (this.y.b()) {
                this.f10662b = new c.a.p0.f.i.s.b(this.f10661a, this.f10664d, this.m);
            } else {
                this.f10662b = new c.a.p0.f.i.s.c(this.f10661a, this.f10664d, this.m);
            }
            if (this.v) {
                this.f10662b.F(this);
            }
            this.f10662b.E(this);
            c.a.p0.f.i.m.b.c s = this.f10662b.s();
            this.f10663c = s;
            s.g(new f(this));
            this.f10662b.r().setAnimation(AnimationUtils.loadAnimation(this.f10661a, c.a.p0.f.i.a.ng_game_ad_open));
        }
    }

    @Override // c.a.p0.f.i.l.d
    public synchronized void d(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048593, this, str, str2) == null) {
            synchronized (this) {
                if (!TextUtils.isEmpty(str2)) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("url", str2);
                        jSONObject.put("title", this.f10664d.getTitle());
                        jSONObject.put("description", this.f10664d.getDescription());
                        jSONObject.put("autoinstall", true);
                        if (this.C == null) {
                            this.C = new c.a.p0.f.i.k.b(this.f10661a, this.f10664d, this.k);
                        }
                        this.C.k(str);
                        c.a.p0.f.i.m.a.b().b(this.f10661a, jSONObject, DownloadParams.SwanAppDownloadType.TYPE_START_DOWNLOAD, this.C);
                    } catch (JSONException unused) {
                    }
                }
            }
        }
    }

    public final boolean d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            AdElementInfo adElementInfo = this.f10664d;
            if (adElementInfo == null) {
                return true;
            }
            long expired = adElementInfo.getExpired() * 1000;
            if (expired == 0) {
                expired = 1740000;
            }
            return System.currentTimeMillis() - this.f10664d.getCreateTime() >= expired;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.p0.f.i.l.c
    public synchronized void e(View view) {
        int min;
        int i2;
        int i3;
        String format;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, view) == null) {
            synchronized (this) {
                if (this.f10663c != null && this.f10664d != null) {
                    if (this.f10667g == null || !this.f10667g.isShowing()) {
                        if (view != null && c.a.p0.f.i.e.close_ad != view.getId()) {
                            W();
                            return;
                        }
                        int currentPosition = this.f10663c.getCurrentPosition() / 1000;
                        int min2 = Math.min(this.f10664d.getRewardTime(), this.f10663c.getDuration() / 1000);
                        if (currentPosition >= min2) {
                            T();
                            return;
                        }
                        int q = c.a.p0.f.i.m.a.b().q();
                        int p = c.a.p0.f.i.m.a.b().p();
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
                        this.f10661a.getResources().getString(c.a.p0.f.i.g.swangame_game_ad_dialog_msg_more);
                        if (this.x) {
                            format = String.format(this.f10661a.getResources().getString(c.a.p0.f.i.g.swangame_game_ad_reward_msg_time_tip), Integer.valueOf(15 - (this.f10663c.getCurrentPosition() / 1000)));
                        } else {
                            format = String.format(this.f10661a.getResources().getString(c.a.p0.f.i.g.swangame_game_ad_video_close_alert), Integer.valueOf(min2 - currentPosition));
                        }
                        if (this.f10667g != null) {
                            this.f10667g.setMessage(format);
                            this.f10667g.show();
                        } else {
                            AdAlertDialog.a aVar = new AdAlertDialog.a(this.D);
                            aVar.c(true);
                            aVar.i(c.a.p0.f.i.g.ad_close, new d(this));
                            aVar.g(format);
                            aVar.l(c.a.p0.f.i.g.ad_continue_watch, new c(this));
                            aVar.n(c.a.p0.f.i.b.swan_ad_game_continue_watch);
                            aVar.k(new DialogInterface$OnDismissListenerC0532b(this));
                            aVar.f(min, 0, i2, i3);
                            this.f10667g = aVar.p();
                        }
                    }
                }
            }
        }
    }

    public synchronized void e0() {
        c.a.p0.f.i.o.e gVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            synchronized (this) {
                if (this.f10665e == 257) {
                    return;
                }
                c.a.p0.f.i.q.b.n("loadApi", this.B, this.k);
                c.a.p0.f.i.m.a.a().b(this.v);
                int i2 = this.f10665e;
                if (i2 != 256 && i2 != 272) {
                    switch (i2) {
                        case 258:
                            if (d0()) {
                                this.f10665e = AuthorityState.STATE_INIT_ING;
                                return;
                            } else {
                                g0();
                                return;
                            }
                        case 259:
                        case PlayerEvent.PLAY_LOADING_END /* 262 */:
                        case PayBeanFactory.BEAN_ID_CREDIT_PAY /* 263 */:
                        case PayBeanFactory.BEAN_ID_SEND_SMS_FOR_VERIFY_BY_BANK /* 264 */:
                            break;
                        case 260:
                        case PlayerEvent.PLAY_LOADING_START /* 261 */:
                        case 265:
                            f0("3010006");
                            return;
                        default:
                            return;
                    }
                }
                String appKey = c.a.p0.f.i.m.a.b().getAppKey();
                if (!TextUtils.isEmpty(appKey) && !TextUtils.isEmpty(this.f10669i) && !TextUtils.isEmpty(this.f10668h)) {
                    this.f10665e = 257;
                    c.b bVar = new c.b();
                    bVar.m(this.f10669i);
                    bVar.j(this.f10668h);
                    bVar.o(appKey);
                    bVar.l(h.i(this.f10661a));
                    bVar.i(h.h(this.f10661a));
                    bVar.n(this.z ? "game" : "app");
                    bVar.k("video");
                    c.a.p0.f.i.o.c h2 = bVar.h();
                    if (this.w) {
                        this.v = true;
                        gVar = new c.a.p0.f.i.o.f(this.f10661a, h2, 5, 5);
                    } else {
                        this.v = false;
                        gVar = new c.a.p0.f.i.o.g(this.f10661a, h2);
                        this.l = gVar.c();
                    }
                    c.a.p0.f.i.o.a aVar = new c.a.p0.f.i.o.a(this.f10661a, false);
                    aVar.k(this);
                    aVar.i(gVar, this.k);
                    return;
                }
                f0("3010007");
            }
        }
    }

    @Override // c.a.p0.f.i.l.d
    public synchronized void f(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, view) == null) {
            synchronized (this) {
                if (this.f10670j != null) {
                    this.f10670j.onClick(R());
                }
                if (this.v) {
                    X(view);
                }
            }
        }
    }

    public final void f0(String str) {
        c.a.p0.f.i.p.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048598, this, str) == null) || (aVar = this.f10670j) == null) {
            return;
        }
        aVar.onError(str);
        this.f10670j.a(false, str);
    }

    public final void g0() {
        c.a.p0.f.i.p.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048599, this) == null) || (aVar = this.f10670j) == null) {
            return;
        }
        aVar.a(true, "");
    }

    public final boolean h0(Context context, String str) {
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
            if (queryIntentActivities != null && queryIntentActivities.size() > 0 && queryIntentActivities.iterator().next() != null) {
                String str2 = queryIntentActivities.iterator().next().activityInfo.name;
                Intent intent2 = new Intent("android.intent.action.MAIN");
                intent2.addCategory("android.intent.category.LAUNCHER");
                intent2.setComponent(new ComponentName(str, str2));
                intent2.setFlags(268435456);
                try {
                    context.startActivity(intent2);
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public synchronized void i0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            synchronized (this) {
                if (this.f10663c != null && this.f10662b != null) {
                    if (this.f10663c.isPlaying()) {
                        this.f10663c.pause();
                        this.f10662b.z();
                        if (this.v) {
                            c.a.p0.f.i.q.d.g(Q(S()), this.f10664d, this.k);
                        } else {
                            c.a.p0.f.i.q.b.o(S(), this.f10666f, this.f10664d, this.k);
                        }
                    } else {
                        c.a.p0.f.i.q.b.o(S(), this.f10666f, this.f10664d, this.k);
                        this.f10666f = S();
                    }
                }
            }
        }
    }

    public final void j0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            c.a.p0.f.i.m.b.c cVar = this.f10663c;
            if (cVar != null) {
                cVar.pause();
                this.f10663c.stop();
            }
            c.a.p0.f.i.s.a aVar = this.f10662b;
            if (aVar != null) {
                aVar.n();
                this.f10662b.r().setAnimation(AnimationUtils.loadAnimation(this.f10661a, c.a.p0.f.i.a.ng_game_ad_close));
                this.y.removeView(this.f10662b.r());
                this.f10662b = null;
            }
            c.a.p0.f.i.k.b bVar = this.C;
            if (bVar != null) {
                bVar.i();
                this.C = null;
            }
        }
    }

    public void k0(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, map) == null) {
            this.B = map;
            this.z = c.a.p0.f.i.q.b.c(map).equals("game");
        }
    }

    public synchronized void l0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            synchronized (this) {
                c.a.p0.f.i.q.b.n("showApi", this.B, this.k);
                if (this.f10665e != 261 && this.f10665e != 260 && this.f10665e != 265) {
                    if (this.f10665e == 258 && !d0()) {
                        if (this.f10664d != null && TextUtils.isEmpty(this.f10664d.getVideoUrl())) {
                            Z("3010008");
                            return;
                        }
                        if (this.f10665e == 258) {
                            this.f10665e = 265;
                            this.y.e();
                            c.a.p0.f.i.r.d.c(new a(this));
                        }
                        return;
                    }
                    Z("3010004");
                    return;
                }
                if (this.f10670j != null) {
                    this.f10670j.onError("3010004");
                    this.f10670j.b(false, "3010004");
                }
            }
        }
    }

    public final void m0(DownloadState downloadState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, downloadState) == null) {
            this.r = downloadState;
            if (downloadState == DownloadState.NOT_START) {
                this.n = F;
                this.o = K;
            } else if (downloadState == DownloadState.DOWNLOAD_PAUSED) {
                this.n = E;
                this.o = J;
            } else if (downloadState == DownloadState.DOWNLOADED) {
                this.n = G;
                this.o = K;
            } else if (downloadState == DownloadState.INSTALLED) {
                this.n = H;
                this.o = K;
            } else if (downloadState == DownloadState.DOWNLOADING) {
                this.n = E;
                this.o = K;
            }
        }
    }
}
