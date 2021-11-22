package b.a.p0.h.i.i;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.h.i.i.d;
import b.a.p0.h.i.p.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.game.ad.downloader.model.DownloadParams;
import com.baidu.swan.game.ad.entity.AdElementInfo;
import com.baidu.swan.game.ad.jsbridge.CommandType;
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
public class b implements b.a.p0.h.i.m.c, d.e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f10373a;

    /* renamed from: b  reason: collision with root package name */
    public String f10374b;

    /* renamed from: c  reason: collision with root package name */
    public String f10375c;

    /* renamed from: d  reason: collision with root package name */
    public b.a.p0.h.i.i.f f10376d;

    /* renamed from: e  reason: collision with root package name */
    public b.a.p0.h.i.i.c f10377e;

    /* renamed from: f  reason: collision with root package name */
    public b.a.p0.h.i.p.c f10378f;

    /* renamed from: g  reason: collision with root package name */
    public AdElementInfo f10379g;

    /* renamed from: h  reason: collision with root package name */
    public b.a.p0.h.i.i.d f10380h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f10381i;
    public String j;
    public boolean k;
    public b.a.p0.h.i.k.b l;
    public Map<String, String> m;
    public b.a.p0.h.i.m.g n;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f10382e;

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
            this.f10382e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f10382e.f10380h == null || this.f10382e.f10380h.f() == null || !this.f10382e.n.c(this.f10382e.f10380h.f())) {
                return;
            }
            this.f10382e.n.removeView(this.f10382e.f10380h.f());
        }
    }

    /* renamed from: b.a.p0.h.i.i.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0543b implements b.a.p0.h.i.m.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f10383a;

        public C0543b(b bVar) {
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
            this.f10383a = bVar;
        }

        @Override // b.a.p0.h.i.m.e
        public void d(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) {
            }
        }

        @Override // b.a.p0.h.i.m.e
        public void f(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) && this.f10383a.k) {
                this.f10383a.A(view);
                if (this.f10383a.f10376d != null) {
                    this.f10383a.f10376d.onClick();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements b.a.p0.h.i.m.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f10384a;

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
            this.f10384a = bVar;
        }

        @Override // b.a.p0.h.i.m.a
        public void b(CommandType commandType, Uri uri) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, commandType, uri) == null) || this.f10384a.f10379g == null) {
                return;
            }
            String clickUrl = this.f10384a.f10379g.getClickUrl();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("monitorUrl", b.a.p0.h.i.r.b.b("landingPageLoad", this.f10384a.m));
            } catch (JSONException unused) {
            }
            this.f10384a.n.a(clickUrl, jSONObject);
            b.a.p0.h.i.r.b.g(this.f10384a.f10379g, this.f10384a.f10378f);
            b.a.p0.h.i.r.b.n("lpClick", this.f10384a.m, this.f10384a.f10378f);
            b.a.p0.h.i.r.b.n(PrefetchEvent.STATE_CLICK, this.f10384a.m, this.f10384a.f10378f);
        }
    }

    /* loaded from: classes.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f10385e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f10386f;

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
            this.f10386f = bVar;
            this.f10385e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.a.p0.h.i.i.c cVar = this.f10386f.f10377e;
                boolean z = cVar.f10393c != cVar.f10395e;
                this.f10386f.x();
                if (this.f10386f.f10380h != null) {
                    this.f10386f.f10380h.e(this.f10386f.f10377e.f10393c);
                    this.f10386f.n.f(this.f10386f.f10380h.f(), new b.a.p0.h.i.i.a(b.a.p0.h.i.s.h.a(this.f10386f.f10377e.f10391a), b.a.p0.h.i.s.h.a(this.f10386f.f10377e.f10392b), b.a.p0.h.i.s.h.a(this.f10386f.f10377e.f10395e), b.a.p0.h.i.s.h.a(this.f10386f.f10377e.f10396f)));
                }
                if (this.f10385e.equals("width") && z && this.f10386f.f10376d != null) {
                    b.a.p0.h.i.i.f fVar = this.f10386f.f10376d;
                    b.a.p0.h.i.i.c cVar2 = this.f10386f.f10377e;
                    fVar.b(cVar2.f10395e, cVar2.f10396f);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f10387e;

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
            this.f10387e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f10387e.f10380h == null || !this.f10387e.n.c(this.f10387e.f10380h.f())) {
                    if (this.f10387e.f10376d != null) {
                        this.f10387e.f10376d.onShow(false);
                        this.f10387e.f10376d.onError("3010010");
                        return;
                    }
                    return;
                }
                this.f10387e.f10380h.l();
                if (this.f10387e.f10376d != null) {
                    this.f10387e.f10376d.onShow(true);
                }
                b.a.p0.h.i.r.b.n("showSuccess", this.f10387e.m, this.f10387e.f10378f);
                if (this.f10387e.f10381i) {
                    return;
                }
                this.f10387e.f10381i = true;
                if (this.f10387e.k) {
                    b.a.p0.h.i.r.d.f(this.f10387e.f10379g, this.f10387e.f10378f);
                    return;
                }
                b.a.p0.h.i.r.b.j(this.f10387e.f10379g, this.f10387e.f10378f);
                String str = this.f10387e.f10375c;
                b bVar = this.f10387e;
                b.a.p0.h.i.r.b.f(str, bVar.f10374b, bVar.j, this.f10387e.f10378f);
                b.a.p0.h.i.r.b.n("show", this.f10387e.m, this.f10387e.f10378f);
            }
        }
    }

    /* loaded from: classes.dex */
    public class f implements b.a.p0.h.i.m.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f10388a;

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
            this.f10388a = bVar;
        }

        @Override // b.a.p0.h.i.m.e
        public void d(String str, String str2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) || TextUtils.isEmpty(str2)) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("url", str2);
                if (this.f10388a.l == null) {
                    this.f10388a.l = new b.a.p0.h.i.k.b(this.f10388a.f10373a, this.f10388a.f10379g, this.f10388a.f10378f);
                }
                this.f10388a.l.k(str);
                b.a.p0.h.i.n.a.b().d(this.f10388a.f10373a, jSONObject, DownloadParams.SwanAppDownloadType.TYPE_START_DOWNLOAD, this.f10388a.l);
            } catch (JSONException unused) {
            }
        }

        @Override // b.a.p0.h.i.m.e
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
        public final /* synthetic */ b f10389e;

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
            this.f10389e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f10389e.f10380h == null) {
                return;
            }
            this.f10389e.f10380h.g();
        }
    }

    /* loaded from: classes.dex */
    public class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f10390e;

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
            this.f10390e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f10390e.f10380h != null) {
                    this.f10390e.n.removeView(this.f10390e.f10380h.f());
                }
                this.f10390e.f10380h = null;
                this.f10390e.f10376d = null;
                this.f10390e.f10379g = null;
                if (this.f10390e.l != null) {
                    this.f10390e.l.i();
                    this.f10390e.l = null;
                }
            }
        }
    }

    public b(String str, String str2, b.a.p0.h.i.i.f fVar, b.a.p0.h.i.m.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, fVar, gVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f10377e = null;
        this.m = new TreeMap();
        Context appContext = AppRuntime.getAppContext();
        this.f10373a = appContext;
        this.f10375c = str;
        this.f10374b = str2;
        this.f10376d = fVar;
        this.n = gVar;
        this.f10378f = new b.a.p0.h.i.p.c(appContext);
        this.k = false;
        E(10, 10, 350, 50);
        D();
    }

    public final void A(View view) {
        AdElementInfo adElementInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || !this.k || (adElementInfo = this.f10379g) == null || this.f10377e == null || view == null) {
            return;
        }
        b.a.p0.h.i.r.d.d(adElementInfo, this.f10378f);
        b.a.p0.h.i.r.a aVar = new b.a.p0.h.i.r.a();
        aVar.f10554a = String.valueOf(this.f10377e.f10393c);
        aVar.f10555b = String.valueOf(this.f10377e.f10394d);
        aVar.f10556c = String.valueOf(this.f10377e.f10393c);
        aVar.f10557d = String.valueOf(this.f10377e.f10394d);
        aVar.f10558e = String.valueOf((int) view.getX());
        aVar.f10559f = String.valueOf((int) view.getY());
        aVar.f10560g = String.valueOf((int) view.getX());
        aVar.f10561h = String.valueOf((int) view.getY());
        if (this.f10379g.getActionType() == 2) {
            b.a.p0.h.i.r.d.a(aVar, this.f10379g, this.f10378f, new f(this));
            return;
        }
        AdElementInfo adElementInfo2 = this.f10379g;
        if (adElementInfo2 != null) {
            this.n.a(b.a.p0.h.i.r.d.c(adElementInfo2.getClickUrl(), aVar), new JSONObject());
        }
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            b.a.p0.h.i.s.d.c(new g(this));
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            b.a.p0.h.i.i.d dVar = new b.a.p0.h.i.i.d(this.f10373a, this.f10379g, this.f10374b, this.k);
            this.f10380h = dVar;
            dVar.i(this);
            if (this.k) {
                this.f10380h.k(new C0543b(this));
            } else {
                this.f10380h.j(new c(this));
            }
            this.f10380h.e(this.f10377e.f10393c);
            if (this.n.c(this.f10380h.f())) {
                this.n.removeView(this.f10380h.f());
            }
            if (this.n.d(this.f10380h.f(), new b.a.p0.h.i.i.a(b.a.p0.h.i.s.h.a(this.f10377e.f10391a), b.a.p0.h.i.s.h.a(this.f10377e.f10392b), b.a.p0.h.i.s.h.a(this.f10377e.f10395e), b.a.p0.h.i.s.h.a(this.f10377e.f10396f)))) {
                b.a.p0.h.i.i.f fVar = this.f10376d;
                if (fVar != null) {
                    fVar.a(true, "");
                    return;
                }
                return;
            }
            b.a.p0.h.i.i.f fVar2 = this.f10376d;
            if (fVar2 != null) {
                fVar2.onError("3010000");
            }
        }
    }

    public final void D() {
        b.a.p0.h.i.p.f eVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            b.a.p0.h.i.r.b.n("loadApi", this.m, this.f10378f);
            String appKey = b.a.p0.h.i.n.a.b().getAppKey();
            d.b bVar = new d.b();
            bVar.m(this.f10375c);
            bVar.j(this.f10374b);
            bVar.o(appKey);
            bVar.n("game");
            bVar.k("banner");
            bVar.l(this.f10377e.f10393c);
            bVar.i(this.f10377e.f10394d);
            b.a.p0.h.i.p.d h2 = bVar.h();
            if (this.k) {
                eVar = new b.a.p0.h.i.p.g(this.f10373a, h2, 1, z());
            } else {
                eVar = new b.a.p0.h.i.p.e(this.f10373a, h2);
                this.j = eVar.c();
            }
            b.a.p0.h.i.p.a aVar = new b.a.p0.h.i.p.a(this.f10373a, false);
            aVar.k(this);
            aVar.i(eVar, this.f10378f);
        }
    }

    public void E(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048580, this, i2, i3, i4, i5) == null) {
            this.f10377e = new b.a.p0.h.i.i.c(i2, i3, i4, i5);
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
            b.a.p0.h.i.s.d.c(new e(this));
        }
    }

    public void H(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            b.a.p0.h.i.s.d.c(new d(this, str));
        }
    }

    @Override // b.a.p0.h.i.m.c
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            b.a.p0.h.i.i.f fVar = this.f10376d;
            if (fVar != null) {
                fVar.onError(str);
            }
            String appId = b.a.p0.h.i.n.a.b().getAppId();
            if (appId.lastIndexOf("_dev") >= 0 && appId.lastIndexOf("_dev") < appId.length() && str.equals("201000")) {
                w();
            }
            b.a.p0.h.i.i.f fVar2 = this.f10376d;
            if (fVar2 != null) {
                fVar2.a(false, "");
            }
        }
    }

    @Override // b.a.p0.h.i.i.d.e
    public void b() {
        b.a.p0.h.i.i.f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (fVar = this.f10376d) == null) {
            return;
        }
        fVar.onClose();
    }

    @Override // b.a.p0.h.i.m.c
    public void c(AdElementInfo adElementInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, adElementInfo) == null) {
            this.f10379g = adElementInfo;
            C();
        }
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            b.a.p0.h.i.i.d dVar = new b.a.p0.h.i.i.d(this.f10373a);
            this.f10380h = dVar;
            dVar.e(this.f10377e.f10393c);
            if (this.f10380h.f() == null) {
                return;
            }
            if (this.n.c(this.f10380h.f())) {
                this.n.removeView(this.f10380h.f());
            }
            this.n.d(this.f10380h.f(), new b.a.p0.h.i.i.a(b.a.p0.h.i.s.h.a(this.f10377e.f10391a), b.a.p0.h.i.s.h.a(this.f10377e.f10392b), b.a.p0.h.i.s.h.a(this.f10377e.f10395e), b.a.p0.h.i.s.h.a(this.f10377e.f10396f)));
            this.f10380h.f().postDelayed(new a(this), 20000L);
        }
    }

    public final void x() {
        b.a.p0.h.i.i.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (cVar = this.f10377e) == null) {
            return;
        }
        if (b.a.p0.h.i.s.h.a(cVar.f10393c) < 300) {
            this.f10377e.f10393c = b.a.p0.h.i.s.h.p(300.0f);
        }
        int q = b.a.p0.h.i.n.a.b().q();
        int p = b.a.p0.h.i.n.a.b().p();
        if (b.a.p0.h.i.s.h.a(this.f10377e.f10393c) > q) {
            this.f10377e.f10393c = b.a.p0.h.i.s.h.p(q);
        }
        b.a.p0.h.i.i.c cVar2 = this.f10377e;
        cVar2.f10394d = (int) (cVar2.f10393c / b.a.p0.h.i.i.e.f10410a);
        if (cVar2.f10391a < 0) {
            cVar2.f10391a = 0;
        }
        int p2 = b.a.p0.h.i.s.h.p(q);
        b.a.p0.h.i.i.c cVar3 = this.f10377e;
        int i2 = p2 - cVar3.f10393c;
        if (cVar3.f10391a > i2) {
            cVar3.f10391a = i2;
        }
        b.a.p0.h.i.i.c cVar4 = this.f10377e;
        if (cVar4.f10392b < 0) {
            cVar4.f10392b = 0;
        }
        int p3 = b.a.p0.h.i.s.h.p(p);
        b.a.p0.h.i.i.c cVar5 = this.f10377e;
        int i3 = p3 - cVar5.f10394d;
        if (cVar5.f10392b > i3) {
            cVar5.f10392b = i3;
        }
        b.a.p0.h.i.i.c cVar6 = this.f10377e;
        cVar6.f10395e = cVar6.f10393c;
        cVar6.f10396f = cVar6.f10394d;
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            b.a.p0.h.i.s.d.c(new h(this));
        }
    }

    public final int z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (this.f10377e == null) {
                return 2;
            }
            int p = b.a.p0.h.i.s.h.p(b.a.p0.h.i.n.a.b().p());
            int i2 = this.f10377e.f10392b;
            int i3 = p / 3;
            if (i2 < i3) {
                return 1;
            }
            return i2 < i3 * 2 ? 4 : 2;
        }
        return invokeV.intValue;
    }
}
