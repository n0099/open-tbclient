package b.a.p0.h.i.q;

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
import b.a.p0.h.i.p.d;
import b.a.p0.h.i.s.h;
import b.a.p0.h.i.s.i;
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
public class b implements b.a.p0.h.i.m.c, b.a.p0.h.i.m.d, b.a.p0.h.i.m.a, b.a.p0.h.i.m.e {
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
    public b.a.p0.h.i.k.b B;
    public Activity C;

    /* renamed from: a  reason: collision with root package name */
    public Context f10539a;

    /* renamed from: b  reason: collision with root package name */
    public b.a.p0.h.i.t.a f10540b;

    /* renamed from: c  reason: collision with root package name */
    public b.a.p0.h.i.n.b.c f10541c;

    /* renamed from: d  reason: collision with root package name */
    public AdElementInfo f10542d;

    /* renamed from: e  reason: collision with root package name */
    public int f10543e;

    /* renamed from: f  reason: collision with root package name */
    public int f10544f;

    /* renamed from: g  reason: collision with root package name */
    public AdAlertDialog f10545g;

    /* renamed from: h  reason: collision with root package name */
    public String f10546h;

    /* renamed from: i  reason: collision with root package name */
    public String f10547i;
    public b.a.p0.h.i.q.a j;
    public b.a.p0.h.i.p.c k;
    public String l;
    public b.a.p0.h.i.o.a m;
    public String n;
    public String o;
    public Map<String, String> p;
    public b.a.p0.h.i.r.c q;
    public DownloadState r;
    public DownloadParams s;
    public b.a.p0.h.i.k.f.a t;
    public boolean u;
    public boolean v;
    public boolean w;
    public boolean x;
    public b.a.p0.h.i.m.g y;
    public boolean z;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f10548e;

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
            this.f10548e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f10548e.a0();
                if (this.f10548e.y.c(this.f10548e.f10540b.r())) {
                    this.f10548e.y.removeView(this.f10548e.f10540b.r());
                }
                if (!this.f10548e.y.d(this.f10548e.f10540b.r(), b.a.p0.h.i.i.a.a())) {
                    this.f10548e.X("3010000");
                    return;
                }
                this.f10548e.f10543e = 260;
                this.f10548e.f10540b.G(this.f10548e.f10542d.getVideoUrl());
                b.a.p0.h.i.r.b.n("showSuccess", this.f10548e.A, this.f10548e.k);
            }
        }
    }

    /* renamed from: b.a.p0.h.i.q.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class DialogInterface$OnDismissListenerC0555b implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public DialogInterface$OnDismissListenerC0555b(b bVar) {
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
        public final /* synthetic */ b f10549e;

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
            this.f10549e = bVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                this.f10549e.N();
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f10550e;

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
            this.f10550e = bVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                if (!this.f10550e.x || this.f10550e.f10540b == null) {
                    this.f10550e.S();
                    return;
                }
                if (this.f10550e.f10541c != null) {
                    this.f10550e.f10541c.pause();
                }
                this.f10550e.f10543e = PlayerEvent.PLAY_LOADING_END;
                this.f10550e.f10540b.B();
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements b.a.p0.h.i.k.f.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f10551a;

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
            this.f10551a = bVar;
        }

        @Override // b.a.p0.h.i.k.f.a
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || i2 == 0 || i2 > 100) {
                return;
            }
            if (i2 != 100 || this.f10551a.n == b.E) {
                if (this.f10551a.n == b.E || this.f10551a.n == b.H) {
                    return;
                }
                this.f10551a.n = String.valueOf(i2);
                return;
            }
            this.f10551a.n = b.F;
        }

        @Override // b.a.p0.h.i.k.f.a
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f10551a.q.c("appinstallbegin");
            }
        }

        @Override // b.a.p0.h.i.k.f.a
        public void c(DownloadState downloadState, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, downloadState, i2) == null) {
                if (!this.f10551a.u) {
                    this.f10551a.m0(downloadState);
                }
                this.f10551a.u = true;
                if (this.f10551a.r == downloadState) {
                    return;
                }
                if (this.f10551a.r == DownloadState.NOT_START && downloadState == DownloadState.DOWNLOADING) {
                    this.f10551a.o = b.J;
                    this.f10551a.q.c("appdownloadbegin");
                } else if (downloadState != DownloadState.DOWNLOAD_PAUSED) {
                    if (this.f10551a.r == DownloadState.DOWNLOAD_PAUSED && downloadState == DownloadState.DOWNLOADING) {
                        this.f10551a.o = b.J;
                        this.f10551a.q.c("appdownloadcontinue");
                    } else if (downloadState == DownloadState.DOWNLOADED) {
                        this.f10551a.o = b.J;
                        this.f10551a.n = b.F;
                        this.f10551a.q.c("appdownloadfinish");
                        this.f10551a.q.c("appinstallbegin");
                    } else if (downloadState == DownloadState.INSTALLED) {
                        this.f10551a.o = b.J;
                        this.f10551a.n = b.G;
                        this.f10551a.q.c("appinstallfinish");
                    } else if (downloadState == DownloadState.DOWNLOAD_FAILED) {
                        this.f10551a.o = b.J;
                        this.f10551a.n = b.H;
                    }
                } else {
                    this.f10551a.o = b.I;
                    this.f10551a.q.c("appdownloadpause");
                }
                this.f10551a.r = downloadState;
            }
        }

        @Override // b.a.p0.h.i.k.f.a
        public void d(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            }
        }

        @Override // b.a.p0.h.i.k.f.a
        public String e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                this.f10551a.q.c("appinstallopen");
                return "";
            }
            return (String) invokeV.objValue;
        }

        @Override // b.a.p0.h.i.k.f.a
        public void f(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            }
        }
    }

    /* loaded from: classes.dex */
    public class f implements b.a.p0.h.i.m.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f10552a;

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
            this.f10552a = bVar;
        }

        @Override // b.a.p0.h.i.m.f
        public void onCompletion() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f10552a.R();
            }
        }

        @Override // b.a.p0.h.i.m.f
        public boolean onError() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                this.f10552a.j0();
                this.f10552a.X("3010001");
                return true;
            }
            return invokeV.booleanValue;
        }

        @Override // b.a.p0.h.i.m.f
        public void onPause() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f10552a.f10540b == null) {
                return;
            }
            this.f10552a.f10540b.z();
        }

        @Override // b.a.p0.h.i.m.f
        public void onPrepared() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                if (this.f10552a.f10540b != null) {
                    this.f10552a.f10540b.y();
                }
                this.f10552a.f10543e = PlayerEvent.PLAY_LOADING_START;
                this.f10552a.f10544f = 0;
                if (this.f10552a.f10540b != null) {
                    this.f10552a.f10540b.p();
                }
                if (this.f10552a.j != null) {
                    this.f10552a.j.b(true, "");
                }
                if (this.f10552a.v) {
                    b.a.p0.h.i.r.d.f(this.f10552a.f10542d, this.f10552a.k);
                } else {
                    b.a.p0.h.i.r.b.j(this.f10552a.f10542d, this.f10552a.k);
                    b.a.p0.h.i.r.b.q(this.f10552a.f10542d, this.f10552a.k);
                    String str = this.f10552a.f10547i;
                    b bVar = this.f10552a;
                    b.a.p0.h.i.r.b.f(str, bVar.f10546h, bVar.l, this.f10552a.k);
                }
                b.a.p0.h.i.r.b.n("show", this.f10552a.A, this.f10552a.k);
            }
        }

        @Override // b.a.p0.h.i.m.f
        public void onResume() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.f10552a.f10540b == null) {
                return;
            }
            this.f10552a.f10540b.D();
        }

        @Override // b.a.p0.h.i.m.f
        public void onStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            }
        }
    }

    /* loaded from: classes.dex */
    public static /* synthetic */ class g {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f10553a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-701138615, "Lb/a/p0/h/i/q/b$g;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-701138615, "Lb/a/p0/h/i/q/b$g;");
                    return;
                }
            }
            int[] iArr = new int[CommandType.values().length];
            f10553a = iArr;
            try {
                iArr[CommandType.ACTION_URL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f10553a[CommandType.GET_DOWNLOAD_STATUS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f10553a[CommandType.PAUSE_DOWNLOAD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f10553a[CommandType.DOWNLOAD_PERMISSION_CLICK.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f10553a[CommandType.DOWNLOAD_PRIVACY_CLICK.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1751223788, "Lb/a/p0/h/i/q/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1751223788, "Lb/a/p0/h/i/q/b;");
        }
    }

    public b(Activity activity, String str, String str2, boolean z, b.a.p0.h.i.q.a aVar, b.a.p0.h.i.m.g gVar) {
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
        this.f10543e = 256;
        this.f10544f = 0;
        this.f10546h = "";
        this.n = E;
        this.o = J;
        this.p = new HashMap();
        this.r = DownloadState.NOT_START;
        this.A = new TreeMap();
        Context appContext = AppRuntime.getAppContext();
        this.f10539a = appContext;
        this.f10547i = str;
        this.f10546h = str2;
        this.v = z;
        this.w = z;
        this.k = new b.a.p0.h.i.p.c(appContext);
        this.m = new b.a.p0.h.i.o.a();
        this.x = i.i();
        this.j = aVar;
        this.y = gVar;
        this.C = activity;
    }

    public synchronized void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this) {
                if (this.f10541c != null && this.f10540b != null) {
                    if (this.f10545g == null || !this.f10545g.isShowing()) {
                        if (!this.f10540b.t()) {
                            this.f10541c.resume();
                        } else {
                            b.a.p0.h.i.r.b.q(this.f10542d, this.k);
                        }
                    }
                }
            }
        }
    }

    public final b.a.p0.h.i.r.a O(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            b.a.p0.h.i.r.a aVar = new b.a.p0.h.i.r.a();
            aVar.f10562i = String.valueOf(this.f10542d.getDuration());
            aVar.j = String.valueOf(this.f10544f);
            aVar.k = String.valueOf(i2);
            String str = "1";
            aVar.l = this.f10544f == 0 ? "1" : "0";
            aVar.m = i2 == this.f10542d.getDuration() ? "1" : "0";
            int i3 = 1;
            aVar.n = this.f10539a.getResources().getConfiguration().orientation == 1 ? "2" : "4";
            int i4 = this.f10544f;
            if (i4 != 0) {
                i3 = i4 == this.f10542d.getDuration() ? 3 : 2;
            }
            aVar.o = String.valueOf(i3);
            aVar.p = (this.f10544f == 0 && NetworkUtils.g(this.f10539a)) ? "2" : "2";
            aVar.q = String.valueOf(0);
            return aVar;
        }
        return (b.a.p0.h.i.r.a) invokeI.objValue;
    }

    public final int P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            b.a.p0.h.i.n.b.c cVar = this.f10541c;
            if (cVar != null && cVar.isEnd()) {
                return this.f10541c.getDuration() / 1000;
            }
            return Q();
        }
        return invokeV.intValue;
    }

    public final int Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            b.a.p0.h.i.n.b.c cVar = this.f10541c;
            if (cVar != null) {
                return cVar.getCurrentPosition() / 1000;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public final void R() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.f10541c == null || this.f10540b == null) {
            return;
        }
        i0();
        this.f10543e = PlayerEvent.PLAY_LOADING_END;
        if (this.f10540b != null) {
            if (this.f10541c.isEnd()) {
                this.f10540b.A();
            } else {
                this.f10540b.B();
            }
        }
    }

    public final void S() {
        b.a.p0.h.i.n.b.c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.j != null && (cVar = this.f10541c) != null) {
                int duration = cVar.getDuration() / 1000;
                this.j.c(this.f10541c.isEnd() || this.f10541c.getCurrentPosition() / 1000 >= Math.min(this.f10542d.getRewardTime(), duration), duration);
            }
            j0();
            if (this.f10542d.getActionType() == 2 && DownloadState.DOWNLOADING == this.r) {
                this.t = null;
                b.a.p0.h.i.n.a.b().d(this.f10539a, this.s.a(), DownloadParams.SwanAppDownloadType.TYPE_PAUSE_DOWNLOAD, this.t);
            }
            b.a.p0.h.i.r.b.p(this.f10542d, this.k);
            this.f10543e = PayBeanFactory.BEAN_ID_CREDIT_PAY;
            c0();
        }
    }

    public final void T() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (b.a.p0.h.i.s.g.a(this.f10539a, this.s.f45357b)) {
                this.n = G;
                f0(this.f10539a, this.s.f45357b);
                this.q.c("appinstallopen");
                return;
            }
            DownloadState downloadState = this.r;
            if (downloadState == DownloadState.NOT_START || downloadState == DownloadState.DELETED) {
                this.n = D;
                b.a.p0.h.i.n.a.b().d(this.f10539a, this.s.a(), DownloadParams.SwanAppDownloadType.TYPE_START_DOWNLOAD, this.t);
            }
            if (this.r == DownloadState.DOWNLOADING) {
                b.a.p0.h.i.n.a.b().d(this.f10539a, this.s.a(), DownloadParams.SwanAppDownloadType.TYPE_PAUSE_DOWNLOAD, this.t);
            }
            if (this.r == DownloadState.DOWNLOAD_PAUSED) {
                this.o = J;
                b.a.p0.h.i.n.a.b().d(this.f10539a, this.s.a(), DownloadParams.SwanAppDownloadType.TYPE_START_DOWNLOAD, this.t);
            }
            if (this.r == DownloadState.DOWNLOAD_FAILED) {
                b.a.p0.h.i.n.a.b().d(this.f10539a, this.s.a(), DownloadParams.SwanAppDownloadType.TYPE_START_DOWNLOAD, this.t);
            }
            if (this.r == DownloadState.DOWNLOADED) {
                this.n = F;
                this.t.b();
                b.a.p0.h.i.n.a.b().d(this.f10539a, this.s.a(), DownloadParams.SwanAppDownloadType.TYPE_INSTALL_APP, this.t);
            }
            if (this.r == DownloadState.INSTALLED) {
                f0(this.f10539a, this.s.f45357b);
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
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view) == null) && this.v && (adElementInfo = this.f10542d) != null) {
            b.a.p0.h.i.r.d.d(adElementInfo, this.k);
            b.a.p0.h.i.r.a aVar = new b.a.p0.h.i.r.a();
            aVar.f10554a = String.valueOf(h.i(this.f10539a));
            aVar.f10555b = String.valueOf(h.h(this.f10539a));
            aVar.f10556c = String.valueOf(h.i(this.f10539a));
            aVar.f10557d = String.valueOf(h.h(this.f10539a));
            aVar.f10558e = String.valueOf((int) view.getX());
            aVar.f10559f = String.valueOf((int) view.getY());
            aVar.f10560g = String.valueOf((int) view.getX());
            aVar.f10561h = String.valueOf((int) view.getY());
            if (this.f10542d.getActionType() == 2) {
                b.a.p0.h.i.r.d.a(aVar, this.f10542d, this.k, this);
                return;
            }
            AdElementInfo adElementInfo2 = this.f10542d;
            if (adElementInfo2 != null) {
                this.y.a(b.a.p0.h.i.r.d.c(adElementInfo2.getClickUrl(), aVar), new JSONObject());
            }
        }
    }

    public final void W() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            String clickUrl = this.f10542d.getClickUrl();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("monitorUrl", b.a.p0.h.i.r.b.b("landingPageLoad", this.A));
            } catch (JSONException unused) {
            }
            this.y.a(clickUrl, jSONObject);
        }
    }

    public final void X(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            b.a.p0.h.i.q.a aVar = this.j;
            if (aVar != null) {
                aVar.onError(str);
                this.j.b(false, "");
            }
            this.f10543e = PayBeanFactory.BEAN_ID_SEND_SMS_FOR_VERIFY_BY_BANK;
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
            this.q = new b.a.p0.h.i.r.c(this.f10539a, this.f10542d.getAdMonitors());
            this.t = new e(this);
            String clickUrl = this.f10542d.getClickUrl();
            String packageName = this.f10542d.getPackageName();
            String str = this.p.get(packageName);
            if (str != null) {
                clickUrl = str;
            } else {
                this.p.put(packageName, clickUrl);
            }
            this.s = new DownloadParams(clickUrl, packageName, this.f10542d.getTitle());
            this.u = false;
            if (h.o()) {
                b.a.p0.h.i.n.a.b().d(this.f10539a, this.s.a(), DownloadParams.SwanAppDownloadType.TYPE_QUERY_STATUS, this.t);
            }
        }
    }

    @Override // b.a.p0.h.i.m.c
    public synchronized void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            synchronized (this) {
                this.f10543e = 259;
                d0(str);
            }
        }
    }

    public final void a0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.m.i(this);
            if (this.y.b()) {
                this.f10540b = new b.a.p0.h.i.t.b(this.f10539a, this.f10542d, this.m);
            } else {
                this.f10540b = new b.a.p0.h.i.t.c(this.f10539a, this.f10542d, this.m);
            }
            if (this.v) {
                this.f10540b.F(this);
            }
            this.f10540b.E(this);
            b.a.p0.h.i.n.b.c s = this.f10540b.s();
            this.f10541c = s;
            s.g(new f(this));
            this.f10540b.r().setAnimation(AnimationUtils.loadAnimation(this.f10539a, b.a.p0.h.i.a.ng_game_ad_open));
        }
    }

    @Override // b.a.p0.h.i.m.a
    public synchronized void b(CommandType commandType, Uri uri) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, commandType, uri) == null) {
            synchronized (this) {
                this.f10542d.getClickUrl();
                String packageName = this.f10542d.getPackageName();
                int i2 = g.f10553a[commandType.ordinal()];
                if (i2 == 1) {
                    if (this.f10542d.getActionType() == 2) {
                        T();
                    } else {
                        W();
                        b.a.p0.h.i.r.b.n("lpClick", this.A, this.k);
                    }
                    b.a.p0.h.i.r.b.g(this.f10542d, this.k);
                    b.a.p0.h.i.r.b.n(PrefetchEvent.STATE_CLICK, this.A, this.k);
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
                    if (Y(this.f10539a, packageName)) {
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
            AdElementInfo adElementInfo = this.f10542d;
            if (adElementInfo == null) {
                return true;
            }
            long expired = adElementInfo.getExpired() * 1000;
            if (expired == 0) {
                expired = 1740000;
            }
            return System.currentTimeMillis() - this.f10542d.getCreateTime() >= expired;
        }
        return invokeV.booleanValue;
    }

    @Override // b.a.p0.h.i.m.c
    public synchronized void c(AdElementInfo adElementInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, adElementInfo) == null) {
            synchronized (this) {
                this.f10542d = adElementInfo;
                this.v = adElementInfo.isGdtAd();
                this.f10543e = 258;
                e0();
                if (!this.v && this.f10542d.getActionType() == 2) {
                    Z();
                }
            }
        }
    }

    public synchronized void c0() {
        b.a.p0.h.i.p.f hVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            synchronized (this) {
                if (this.f10543e == 257) {
                    return;
                }
                b.a.p0.h.i.r.b.n("loadApi", this.A, this.k);
                b.a.p0.h.i.n.a.a().b(this.v);
                int i2 = this.f10543e;
                if (i2 != 256 && i2 != 272) {
                    switch (i2) {
                        case 258:
                            if (b0()) {
                                this.f10543e = AuthorityState.STATE_INIT_ING;
                                return;
                            } else {
                                e0();
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
                            d0("3010006");
                            return;
                        default:
                            return;
                    }
                }
                String appKey = b.a.p0.h.i.n.a.b().getAppKey();
                if (!TextUtils.isEmpty(appKey) && !TextUtils.isEmpty(this.f10547i) && !TextUtils.isEmpty(this.f10546h)) {
                    this.f10543e = 257;
                    d.b bVar = new d.b();
                    bVar.m(this.f10547i);
                    bVar.j(this.f10546h);
                    bVar.o(appKey);
                    bVar.l(h.i(this.f10539a));
                    bVar.i(h.h(this.f10539a));
                    bVar.n(this.z ? "game" : "app");
                    bVar.k("video");
                    b.a.p0.h.i.p.d h2 = bVar.h();
                    if (this.w) {
                        this.v = true;
                        hVar = new b.a.p0.h.i.p.g(this.f10539a, h2, 5, 5);
                    } else {
                        this.v = false;
                        hVar = new b.a.p0.h.i.p.h(this.f10539a, h2);
                        this.l = hVar.c();
                    }
                    b.a.p0.h.i.p.a aVar = new b.a.p0.h.i.p.a(this.f10539a, false);
                    aVar.k(this);
                    aVar.i(hVar, this.k);
                    return;
                }
                d0("3010007");
            }
        }
    }

    @Override // b.a.p0.h.i.m.e
    public synchronized void d(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048595, this, str, str2) == null) {
            synchronized (this) {
                if (!TextUtils.isEmpty(str2)) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("url", str2);
                        jSONObject.put("title", this.f10542d.getTitle());
                        jSONObject.put("description", this.f10542d.getDescription());
                        jSONObject.put("autoinstall", true);
                        if (this.B == null) {
                            this.B = new b.a.p0.h.i.k.b(this.f10539a, this.f10542d, this.k);
                        }
                        this.B.k(str);
                        b.a.p0.h.i.n.a.b().d(this.f10539a, jSONObject, DownloadParams.SwanAppDownloadType.TYPE_START_DOWNLOAD, this.B);
                    } catch (JSONException unused) {
                    }
                }
            }
        }
    }

    public final void d0(String str) {
        b.a.p0.h.i.q.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048596, this, str) == null) || (aVar = this.j) == null) {
            return;
        }
        aVar.onError(str);
        this.j.a(false, str);
    }

    @Override // b.a.p0.h.i.m.d
    public synchronized void e(View view) {
        int min;
        int i2;
        int i3;
        String format;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, view) == null) {
            synchronized (this) {
                if (this.f10541c != null && this.f10542d != null) {
                    if (this.f10545g == null || !this.f10545g.isShowing()) {
                        if (view != null && b.a.p0.h.i.e.close_ad != view.getId()) {
                            U();
                            return;
                        }
                        int currentPosition = this.f10541c.getCurrentPosition() / 1000;
                        int min2 = Math.min(this.f10542d.getRewardTime(), this.f10541c.getDuration() / 1000);
                        if (currentPosition >= min2) {
                            R();
                            return;
                        }
                        int q = b.a.p0.h.i.n.a.b().q();
                        int p = b.a.p0.h.i.n.a.b().p();
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
                        this.f10539a.getResources().getString(b.a.p0.h.i.g.swangame_game_ad_dialog_msg_more);
                        if (this.x) {
                            format = String.format(this.f10539a.getResources().getString(b.a.p0.h.i.g.swangame_game_ad_reward_msg_time_tip), Integer.valueOf(15 - (this.f10541c.getCurrentPosition() / 1000)));
                        } else {
                            format = String.format(this.f10539a.getResources().getString(b.a.p0.h.i.g.swangame_game_ad_video_close_alert), Integer.valueOf(min2 - currentPosition));
                        }
                        if (this.f10545g != null) {
                            this.f10545g.setMessage(format);
                            this.f10545g.show();
                        } else {
                            AdAlertDialog.a aVar = new AdAlertDialog.a(this.C);
                            aVar.c(true);
                            aVar.i(b.a.p0.h.i.g.ad_close, new d(this));
                            aVar.g(format);
                            aVar.l(b.a.p0.h.i.g.ad_continue_watch, new c(this));
                            aVar.n(b.a.p0.h.i.b.swan_ad_game_continue_watch);
                            aVar.k(new DialogInterface$OnDismissListenerC0555b(this));
                            aVar.f(min, 0, i2, i3);
                            this.f10545g = aVar.p();
                        }
                    }
                }
            }
        }
    }

    public final void e0() {
        b.a.p0.h.i.q.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048598, this) == null) || (aVar = this.j) == null) {
            return;
        }
        aVar.a(true, "");
    }

    @Override // b.a.p0.h.i.m.e
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
            intent2.setFlags(268435456);
            return b.a.p0.h.i.n.a.b().b(context, intent2, b.a.p0.h.i.n.a.b().getAppKey(), null, str);
        }
        return invokeLL.booleanValue;
    }

    public final void g0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            this.y.a(this.f10542d.getPermissionUrl(), new JSONObject());
        }
    }

    public final void h0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            this.y.a(this.f10542d.getPrivacyUrl(), new JSONObject());
        }
    }

    public synchronized void i0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            synchronized (this) {
                if (this.f10541c != null && this.f10540b != null) {
                    if (this.f10541c.isPlaying()) {
                        this.f10541c.pause();
                        if (this.v) {
                            b.a.p0.h.i.r.d.g(O(Q()), this.f10542d, this.k);
                        } else {
                            b.a.p0.h.i.r.b.o(Q(), this.f10544f, this.f10542d, this.k);
                        }
                    } else {
                        b.a.p0.h.i.r.b.o(Q(), this.f10544f, this.f10542d, this.k);
                        this.f10544f = Q();
                    }
                }
            }
        }
    }

    public final void j0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            b.a.p0.h.i.n.b.c cVar = this.f10541c;
            if (cVar != null) {
                cVar.pause();
                this.f10541c.stop();
            }
            b.a.p0.h.i.t.a aVar = this.f10540b;
            if (aVar != null) {
                aVar.n();
                this.f10540b.r().setAnimation(AnimationUtils.loadAnimation(this.f10539a, b.a.p0.h.i.a.ng_game_ad_close));
                this.y.removeView(this.f10540b.r());
                this.f10540b = null;
            }
            b.a.p0.h.i.k.b bVar = this.B;
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
            this.z = b.a.p0.h.i.r.b.c(map).equals("game");
        }
    }

    public synchronized void l0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            synchronized (this) {
                b.a.p0.h.i.r.b.n("showApi", this.A, this.k);
                if (this.f10543e != 261 && this.f10543e != 260 && this.f10543e != 265) {
                    if (this.f10543e == 258 && !b0()) {
                        if (this.f10542d != null && TextUtils.isEmpty(this.f10542d.getVideoUrl())) {
                            X("3010008");
                            return;
                        }
                        if (this.f10543e == 258) {
                            this.f10543e = 265;
                            this.y.e();
                            b.a.p0.h.i.s.d.c(new a(this));
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
