package c.a.o0.f.i.i;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.f.i.i.d;
import c.a.o0.f.i.o.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.game.ad.downloader.model.DownloadParams;
import com.baidu.swan.game.ad.entity.AdElementInfo;
import com.baidu.swan.game.ad.jsbridge.CommandType;
import com.baidu.tieba.videoplay.VideoPlayFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b implements c.a.o0.f.i.l.b, d.e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f10470a;

    /* renamed from: b  reason: collision with root package name */
    public String f10471b;

    /* renamed from: c  reason: collision with root package name */
    public String f10472c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.o0.f.i.i.f f10473d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.o0.f.i.i.c f10474e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.o0.f.i.o.b f10475f;

    /* renamed from: g  reason: collision with root package name */
    public AdElementInfo f10476g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.o0.f.i.i.d f10477h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f10478i;

    /* renamed from: j  reason: collision with root package name */
    public String f10479j;
    public boolean k;
    public c.a.o0.f.i.k.b l;
    public Map<String, String> m;
    public c.a.o0.f.i.l.f n;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f10480e;

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
            this.f10480e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f10480e.f10477h == null || this.f10480e.f10477h.f() == null || !this.f10480e.n.c(this.f10480e.f10477h.f())) {
                return;
            }
            this.f10480e.n.removeView(this.f10480e.f10477h.f());
        }
    }

    /* renamed from: c.a.o0.f.i.i.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0520b implements c.a.o0.f.i.l.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f10481a;

        public C0520b(b bVar) {
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
            this.f10481a = bVar;
        }

        @Override // c.a.o0.f.i.l.d
        public void d(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) {
            }
        }

        @Override // c.a.o0.f.i.l.d
        public void f(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) && this.f10481a.k) {
                this.f10481a.A(view);
                if (this.f10481a.f10473d != null) {
                    this.f10481a.f10473d.onClick();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements c.a.o0.f.i.l.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f10482a;

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
            this.f10482a = bVar;
        }

        @Override // c.a.o0.f.i.l.a
        public void b(CommandType commandType, Uri uri) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, commandType, uri) == null) || this.f10482a.f10476g == null) {
                return;
            }
            String clickUrl = this.f10482a.f10476g.getClickUrl();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("monitorUrl", c.a.o0.f.i.q.b.b("landingPageLoad", this.f10482a.m));
            } catch (JSONException unused) {
            }
            this.f10482a.n.a(clickUrl, jSONObject);
            c.a.o0.f.i.q.b.g(this.f10482a.f10476g, this.f10482a.f10475f);
            c.a.o0.f.i.q.b.n("lpClick", this.f10482a.m, this.f10482a.f10475f);
            c.a.o0.f.i.q.b.n(PrefetchEvent.STATE_CLICK, this.f10482a.m, this.f10482a.f10475f);
        }
    }

    /* loaded from: classes.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f10483e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f10484f;

        public d(b bVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10484f = bVar;
            this.f10483e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.o0.f.i.i.c cVar = this.f10484f.f10474e;
                boolean z = cVar.f10491c != cVar.f10493e;
                this.f10484f.x();
                if (this.f10484f.f10477h != null) {
                    this.f10484f.f10477h.e(this.f10484f.f10474e.f10491c);
                    this.f10484f.n.f(this.f10484f.f10477h.f(), new c.a.o0.f.i.i.a(c.a.o0.f.i.r.h.a(this.f10484f.f10474e.f10489a), c.a.o0.f.i.r.h.a(this.f10484f.f10474e.f10490b), c.a.o0.f.i.r.h.a(this.f10484f.f10474e.f10493e), c.a.o0.f.i.r.h.a(this.f10484f.f10474e.f10494f)));
                }
                if (this.f10483e.equals("width") && z && this.f10484f.f10473d != null) {
                    c.a.o0.f.i.i.f fVar = this.f10484f.f10473d;
                    c.a.o0.f.i.i.c cVar2 = this.f10484f.f10474e;
                    fVar.b(cVar2.f10493e, cVar2.f10494f);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f10485e;

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
            this.f10485e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f10485e.f10477h == null || !this.f10485e.n.c(this.f10485e.f10477h.f())) {
                    if (this.f10485e.f10473d != null) {
                        this.f10485e.f10473d.onShow(false);
                        this.f10485e.f10473d.onError("3010010");
                        return;
                    }
                    return;
                }
                this.f10485e.f10477h.l();
                if (this.f10485e.f10473d != null) {
                    this.f10485e.f10473d.onShow(true);
                }
                c.a.o0.f.i.q.b.n("showSuccess", this.f10485e.m, this.f10485e.f10475f);
                if (this.f10485e.f10478i) {
                    return;
                }
                this.f10485e.f10478i = true;
                if (this.f10485e.k) {
                    c.a.o0.f.i.q.d.f(this.f10485e.f10476g, this.f10485e.f10475f);
                    return;
                }
                c.a.o0.f.i.q.b.j(this.f10485e.f10476g, this.f10485e.f10475f);
                String str = this.f10485e.f10472c;
                b bVar = this.f10485e;
                c.a.o0.f.i.q.b.f(str, bVar.f10471b, bVar.f10479j, this.f10485e.f10475f);
                c.a.o0.f.i.q.b.n("show", this.f10485e.m, this.f10485e.f10475f);
            }
        }
    }

    /* loaded from: classes.dex */
    public class f implements c.a.o0.f.i.l.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f10486a;

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
            this.f10486a = bVar;
        }

        @Override // c.a.o0.f.i.l.d
        public void d(String str, String str2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) || TextUtils.isEmpty(str2)) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("url", str2);
                if (this.f10486a.l == null) {
                    this.f10486a.l = new c.a.o0.f.i.k.b(this.f10486a.f10470a, this.f10486a.f10476g, this.f10486a.f10475f);
                }
                this.f10486a.l.k(str);
                c.a.o0.f.i.m.a.b().b(this.f10486a.f10470a, jSONObject, DownloadParams.SwanAppDownloadType.TYPE_START_DOWNLOAD, this.f10486a.l);
            } catch (JSONException unused) {
            }
        }

        @Override // c.a.o0.f.i.l.d
        public void f(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
            }
        }
    }

    /* loaded from: classes.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f10487e;

        public g(b bVar) {
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
            this.f10487e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f10487e.f10477h == null) {
                return;
            }
            this.f10487e.f10477h.g();
        }
    }

    /* loaded from: classes.dex */
    public class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f10488e;

        public h(b bVar) {
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
            this.f10488e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f10488e.f10477h != null) {
                    this.f10488e.n.removeView(this.f10488e.f10477h.f());
                }
                this.f10488e.f10477h = null;
                this.f10488e.f10473d = null;
                this.f10488e.f10476g = null;
                if (this.f10488e.l != null) {
                    this.f10488e.l.i();
                    this.f10488e.l = null;
                }
            }
        }
    }

    public b(String str, String str2, c.a.o0.f.i.i.f fVar, c.a.o0.f.i.l.f fVar2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, fVar, fVar2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f10474e = null;
        this.m = new TreeMap();
        Context appContext = AppRuntime.getAppContext();
        this.f10470a = appContext;
        this.f10472c = str;
        this.f10471b = str2;
        this.f10473d = fVar;
        this.n = fVar2;
        this.f10475f = new c.a.o0.f.i.o.b(appContext);
        this.k = false;
        E(10, 10, VideoPlayFragment.COVER_ANIMINATION_TIME, 50);
        D();
    }

    public final void A(View view) {
        AdElementInfo adElementInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || !this.k || (adElementInfo = this.f10476g) == null || this.f10474e == null || view == null) {
            return;
        }
        c.a.o0.f.i.q.d.d(adElementInfo, this.f10475f);
        c.a.o0.f.i.q.a aVar = new c.a.o0.f.i.q.a();
        aVar.f10641a = String.valueOf(this.f10474e.f10491c);
        aVar.f10642b = String.valueOf(this.f10474e.f10492d);
        aVar.f10643c = String.valueOf(this.f10474e.f10491c);
        aVar.f10644d = String.valueOf(this.f10474e.f10492d);
        aVar.f10645e = String.valueOf((int) view.getX());
        aVar.f10646f = String.valueOf((int) view.getY());
        aVar.f10647g = String.valueOf((int) view.getX());
        aVar.f10648h = String.valueOf((int) view.getY());
        if (this.f10476g.getActionType() == 2) {
            c.a.o0.f.i.q.d.a(aVar, this.f10476g, this.f10475f, new f(this));
            return;
        }
        AdElementInfo adElementInfo2 = this.f10476g;
        if (adElementInfo2 != null) {
            this.n.a(c.a.o0.f.i.q.d.c(adElementInfo2.getClickUrl(), aVar), new JSONObject());
        }
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            c.a.o0.f.i.r.d.c(new g(this));
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c.a.o0.f.i.i.d dVar = new c.a.o0.f.i.i.d(this.f10470a, this.f10476g, this.f10471b, this.k);
            this.f10477h = dVar;
            dVar.i(this);
            if (this.k) {
                this.f10477h.k(new C0520b(this));
            } else {
                this.f10477h.j(new c(this));
            }
            this.f10477h.e(this.f10474e.f10491c);
            if (this.n.c(this.f10477h.f())) {
                this.n.removeView(this.f10477h.f());
            }
            if (this.n.d(this.f10477h.f(), new c.a.o0.f.i.i.a(c.a.o0.f.i.r.h.a(this.f10474e.f10489a), c.a.o0.f.i.r.h.a(this.f10474e.f10490b), c.a.o0.f.i.r.h.a(this.f10474e.f10493e), c.a.o0.f.i.r.h.a(this.f10474e.f10494f)))) {
                c.a.o0.f.i.i.f fVar = this.f10473d;
                if (fVar != null) {
                    fVar.a(true, "");
                    return;
                }
                return;
            }
            c.a.o0.f.i.i.f fVar2 = this.f10473d;
            if (fVar2 != null) {
                fVar2.onError("3010000");
            }
        }
    }

    public final void D() {
        c.a.o0.f.i.o.e dVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            c.a.o0.f.i.q.b.n("loadApi", this.m, this.f10475f);
            String appKey = c.a.o0.f.i.m.a.b().getAppKey();
            c.b bVar = new c.b();
            bVar.m(this.f10472c);
            bVar.j(this.f10471b);
            bVar.o(appKey);
            bVar.n("game");
            bVar.k("banner");
            bVar.l(this.f10474e.f10491c);
            bVar.i(this.f10474e.f10492d);
            c.a.o0.f.i.o.c h2 = bVar.h();
            if (this.k) {
                dVar = new c.a.o0.f.i.o.f(this.f10470a, h2, 1, z());
            } else {
                dVar = new c.a.o0.f.i.o.d(this.f10470a, h2);
                this.f10479j = dVar.c();
            }
            c.a.o0.f.i.o.a aVar = new c.a.o0.f.i.o.a(this.f10470a, false);
            aVar.k(this);
            aVar.i(dVar, this.f10475f);
        }
    }

    public void E(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048580, this, i2, i3, i4, i5) == null) {
            this.f10474e = new c.a.o0.f.i.i.c(i2, i3, i4, i5);
            x();
        }
    }

    public void F(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, map) == null) {
            this.m = map;
        }
    }

    public void G(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, jsObject) == null) {
            c.a.o0.f.i.r.d.c(new e(this));
        }
    }

    public void H(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            c.a.o0.f.i.r.d.c(new d(this, str));
        }
    }

    @Override // c.a.o0.f.i.l.b
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            c.a.o0.f.i.i.f fVar = this.f10473d;
            if (fVar != null) {
                fVar.onError(str);
            }
            String appId = c.a.o0.f.i.m.a.b().getAppId();
            if (appId.lastIndexOf("_dev") >= 0 && appId.lastIndexOf("_dev") < appId.length() && str.equals("201000")) {
                w();
            }
            c.a.o0.f.i.i.f fVar2 = this.f10473d;
            if (fVar2 != null) {
                fVar2.a(false, "");
            }
        }
    }

    @Override // c.a.o0.f.i.i.d.e
    public void b() {
        c.a.o0.f.i.i.f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (fVar = this.f10473d) == null) {
            return;
        }
        fVar.onClose();
    }

    @Override // c.a.o0.f.i.l.b
    public void c(AdElementInfo adElementInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, adElementInfo) == null) {
            this.f10476g = adElementInfo;
            C();
        }
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            c.a.o0.f.i.i.d dVar = new c.a.o0.f.i.i.d(this.f10470a);
            this.f10477h = dVar;
            dVar.e(this.f10474e.f10491c);
            if (this.f10477h.f() == null) {
                return;
            }
            if (this.n.c(this.f10477h.f())) {
                this.n.removeView(this.f10477h.f());
            }
            this.n.d(this.f10477h.f(), new c.a.o0.f.i.i.a(c.a.o0.f.i.r.h.a(this.f10474e.f10489a), c.a.o0.f.i.r.h.a(this.f10474e.f10490b), c.a.o0.f.i.r.h.a(this.f10474e.f10493e), c.a.o0.f.i.r.h.a(this.f10474e.f10494f)));
            this.f10477h.f().postDelayed(new a(this), 20000L);
        }
    }

    public final void x() {
        c.a.o0.f.i.i.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (cVar = this.f10474e) == null) {
            return;
        }
        if (c.a.o0.f.i.r.h.a(cVar.f10491c) < 300) {
            this.f10474e.f10491c = c.a.o0.f.i.r.h.p(300.0f);
        }
        int q = c.a.o0.f.i.m.a.b().q();
        int p = c.a.o0.f.i.m.a.b().p();
        if (c.a.o0.f.i.r.h.a(this.f10474e.f10491c) > q) {
            this.f10474e.f10491c = c.a.o0.f.i.r.h.p(q);
        }
        c.a.o0.f.i.i.c cVar2 = this.f10474e;
        cVar2.f10492d = (int) (cVar2.f10491c / c.a.o0.f.i.i.e.f10509a);
        if (cVar2.f10489a < 0) {
            cVar2.f10489a = 0;
        }
        int p2 = c.a.o0.f.i.r.h.p(q);
        c.a.o0.f.i.i.c cVar3 = this.f10474e;
        int i2 = p2 - cVar3.f10491c;
        if (cVar3.f10489a > i2) {
            cVar3.f10489a = i2;
        }
        c.a.o0.f.i.i.c cVar4 = this.f10474e;
        if (cVar4.f10490b < 0) {
            cVar4.f10490b = 0;
        }
        int p3 = c.a.o0.f.i.r.h.p(p);
        c.a.o0.f.i.i.c cVar5 = this.f10474e;
        int i3 = p3 - cVar5.f10492d;
        if (cVar5.f10490b > i3) {
            cVar5.f10490b = i3;
        }
        c.a.o0.f.i.i.c cVar6 = this.f10474e;
        cVar6.f10493e = cVar6.f10491c;
        cVar6.f10494f = cVar6.f10492d;
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            c.a.o0.f.i.r.d.c(new h(this));
        }
    }

    public final int z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (this.f10474e == null) {
                return 2;
            }
            int p = c.a.o0.f.i.r.h.p(c.a.o0.f.i.m.a.b().p());
            int i2 = this.f10474e.f10490b;
            int i3 = p / 3;
            if (i2 < i3) {
                return 1;
            }
            return i2 < i3 * 2 ? 4 : 2;
        }
        return invokeV.intValue;
    }
}
