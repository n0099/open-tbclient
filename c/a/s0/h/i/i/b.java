package c.a.s0.h.i.i;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.s0.h.i.i.d;
import c.a.s0.h.i.p.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.launch.utils.SpeedStatsUtils;
import com.baidu.searchbox.v8engine.JsObject;
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
/* loaded from: classes6.dex */
public class b implements c.a.s0.h.i.m.c, d.e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public String f10645b;

    /* renamed from: c  reason: collision with root package name */
    public String f10646c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.s0.h.i.i.f f10647d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.s0.h.i.i.c f10648e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.s0.h.i.p.c f10649f;

    /* renamed from: g  reason: collision with root package name */
    public AdElementInfo f10650g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.s0.h.i.i.d f10651h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f10652i;

    /* renamed from: j  reason: collision with root package name */
    public String f10653j;
    public boolean k;
    public c.a.s0.h.i.k.b l;
    public Map<String, String> m;
    public c.a.s0.h.i.m.g n;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f10654e;

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
            this.f10654e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f10654e.f10651h == null || this.f10654e.f10651h.f() == null || !this.f10654e.n.c(this.f10654e.f10651h.f())) {
                return;
            }
            this.f10654e.n.removeView(this.f10654e.f10651h.f());
        }
    }

    /* renamed from: c.a.s0.h.i.i.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C0712b implements c.a.s0.h.i.m.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public C0712b(b bVar) {
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

        @Override // c.a.s0.h.i.m.e
        public void d(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) {
            }
        }

        @Override // c.a.s0.h.i.m.e
        public void f(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) && this.a.k) {
                this.a.A(view);
                if (this.a.f10647d != null) {
                    this.a.f10647d.onClick();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements c.a.s0.h.i.m.a {
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

        @Override // c.a.s0.h.i.m.a
        public void b(CommandType commandType, Uri uri) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, commandType, uri) == null) || this.a.f10650g == null) {
                return;
            }
            String clickUrl = this.a.f10650g.getClickUrl();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("monitorUrl", c.a.s0.h.i.r.b.b("landingPageLoad", this.a.m));
            } catch (JSONException unused) {
            }
            this.a.n.a(clickUrl, jSONObject);
            c.a.s0.h.i.r.b.g(this.a.f10650g, this.a.f10649f);
            c.a.s0.h.i.r.b.n("lpClick", this.a.m, this.a.f10649f);
            c.a.s0.h.i.r.b.n("click", this.a.m, this.a.f10649f);
        }
    }

    /* loaded from: classes6.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f10655e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f10656f;

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
            this.f10656f = bVar;
            this.f10655e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.s0.h.i.i.c cVar = this.f10656f.f10648e;
                boolean z = cVar.f10661c != cVar.f10663e;
                this.f10656f.x();
                if (this.f10656f.f10651h != null) {
                    this.f10656f.f10651h.e(this.f10656f.f10648e.f10661c);
                    this.f10656f.n.f(this.f10656f.f10651h.f(), new c.a.s0.h.i.i.a(c.a.s0.h.i.s.h.a(this.f10656f.f10648e.a), c.a.s0.h.i.s.h.a(this.f10656f.f10648e.f10660b), c.a.s0.h.i.s.h.a(this.f10656f.f10648e.f10663e), c.a.s0.h.i.s.h.a(this.f10656f.f10648e.f10664f)));
                }
                if (this.f10655e.equals("width") && z && this.f10656f.f10647d != null) {
                    c.a.s0.h.i.i.f fVar = this.f10656f.f10647d;
                    c.a.s0.h.i.i.c cVar2 = this.f10656f.f10648e;
                    fVar.c(cVar2.f10663e, cVar2.f10664f);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f10657e;

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
            this.f10657e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f10657e.f10651h == null || !this.f10657e.n.c(this.f10657e.f10651h.f())) {
                    if (this.f10657e.f10647d != null) {
                        this.f10657e.f10647d.b(false);
                        this.f10657e.f10647d.onError("3010010");
                        return;
                    }
                    return;
                }
                this.f10657e.f10651h.l();
                if (this.f10657e.f10647d != null) {
                    this.f10657e.f10647d.b(true);
                }
                c.a.s0.h.i.r.b.n("showSuccess", this.f10657e.m, this.f10657e.f10649f);
                if (this.f10657e.f10652i) {
                    return;
                }
                this.f10657e.f10652i = true;
                if (this.f10657e.k) {
                    c.a.s0.h.i.r.d.f(this.f10657e.f10650g, this.f10657e.f10649f);
                    return;
                }
                c.a.s0.h.i.r.b.j(this.f10657e.f10650g, this.f10657e.f10649f);
                String str = this.f10657e.f10646c;
                b bVar = this.f10657e;
                c.a.s0.h.i.r.b.f(str, bVar.f10645b, bVar.f10653j, this.f10657e.f10649f);
                c.a.s0.h.i.r.b.n("show", this.f10657e.m, this.f10657e.f10649f);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements c.a.s0.h.i.m.e {
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

        @Override // c.a.s0.h.i.m.e
        public void d(String str, String str2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) || TextUtils.isEmpty(str2)) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("url", str2);
                if (this.a.l == null) {
                    this.a.l = new c.a.s0.h.i.k.b(this.a.a, this.a.f10650g, this.a.f10649f);
                }
                this.a.l.k(str);
                c.a.s0.h.i.n.a.b().d(this.a.a, jSONObject, DownloadParams.SwanAppDownloadType.TYPE_START_DOWNLOAD, this.a.l);
            } catch (JSONException unused) {
            }
        }

        @Override // c.a.s0.h.i.m.e
        public void f(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f10658e;

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
            this.f10658e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f10658e.f10651h == null) {
                return;
            }
            this.f10658e.f10651h.g();
        }
    }

    /* loaded from: classes6.dex */
    public class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f10659e;

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
            this.f10659e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f10659e.f10651h != null) {
                    this.f10659e.n.removeView(this.f10659e.f10651h.f());
                }
                this.f10659e.f10651h = null;
                this.f10659e.f10647d = null;
                this.f10659e.f10650g = null;
                if (this.f10659e.l != null) {
                    this.f10659e.l.i();
                    this.f10659e.l = null;
                }
            }
        }
    }

    public b(String str, String str2, c.a.s0.h.i.i.f fVar, c.a.s0.h.i.m.g gVar) {
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
        this.f10648e = null;
        this.m = new TreeMap();
        Context appContext = AppRuntime.getAppContext();
        this.a = appContext;
        this.f10646c = str;
        this.f10645b = str2;
        this.f10647d = fVar;
        this.n = gVar;
        this.f10649f = new c.a.s0.h.i.p.c(appContext);
        this.k = false;
        E(10, 10, 350, 50);
        D();
    }

    public final void A(View view) {
        AdElementInfo adElementInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || !this.k || (adElementInfo = this.f10650g) == null || this.f10648e == null || view == null) {
            return;
        }
        c.a.s0.h.i.r.d.d(adElementInfo, this.f10649f);
        c.a.s0.h.i.r.a aVar = new c.a.s0.h.i.r.a();
        aVar.a = String.valueOf(this.f10648e.f10661c);
        aVar.f10800b = String.valueOf(this.f10648e.f10662d);
        aVar.f10801c = String.valueOf(this.f10648e.f10661c);
        aVar.f10802d = String.valueOf(this.f10648e.f10662d);
        aVar.f10803e = String.valueOf((int) view.getX());
        aVar.f10804f = String.valueOf((int) view.getY());
        aVar.f10805g = String.valueOf((int) view.getX());
        aVar.f10806h = String.valueOf((int) view.getY());
        if (this.f10650g.getActionType() == 2) {
            c.a.s0.h.i.r.d.a(aVar, this.f10650g, this.f10649f, new f(this));
            return;
        }
        AdElementInfo adElementInfo2 = this.f10650g;
        if (adElementInfo2 != null) {
            this.n.a(c.a.s0.h.i.r.d.c(adElementInfo2.getClickUrl(), aVar), new JSONObject());
        }
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            c.a.s0.h.i.s.d.c(new g(this));
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c.a.s0.h.i.i.d dVar = new c.a.s0.h.i.i.d(this.a, this.f10650g, this.f10645b, this.k);
            this.f10651h = dVar;
            dVar.i(this);
            if (this.k) {
                this.f10651h.k(new C0712b(this));
            } else {
                this.f10651h.j(new c(this));
            }
            this.f10651h.e(this.f10648e.f10661c);
            if (this.n.c(this.f10651h.f())) {
                this.n.removeView(this.f10651h.f());
            }
            if (this.n.d(this.f10651h.f(), new c.a.s0.h.i.i.a(c.a.s0.h.i.s.h.a(this.f10648e.a), c.a.s0.h.i.s.h.a(this.f10648e.f10660b), c.a.s0.h.i.s.h.a(this.f10648e.f10663e), c.a.s0.h.i.s.h.a(this.f10648e.f10664f)))) {
                c.a.s0.h.i.i.f fVar = this.f10647d;
                if (fVar != null) {
                    fVar.a(true, "");
                    return;
                }
                return;
            }
            c.a.s0.h.i.i.f fVar2 = this.f10647d;
            if (fVar2 != null) {
                fVar2.onError("3010000");
            }
        }
    }

    public final void D() {
        c.a.s0.h.i.p.f eVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            c.a.s0.h.i.r.b.n("loadApi", this.m, this.f10649f);
            String appKey = c.a.s0.h.i.n.a.b().getAppKey();
            d.b bVar = new d.b();
            bVar.m(this.f10646c);
            bVar.j(this.f10645b);
            bVar.o(appKey);
            bVar.n("game");
            bVar.k(SpeedStatsUtils.UBC_VALUE_BANNER);
            bVar.l(this.f10648e.f10661c);
            bVar.i(this.f10648e.f10662d);
            c.a.s0.h.i.p.d h2 = bVar.h();
            if (this.k) {
                eVar = new c.a.s0.h.i.p.g(this.a, h2, 1, z());
            } else {
                eVar = new c.a.s0.h.i.p.e(this.a, h2);
                this.f10653j = eVar.c();
            }
            c.a.s0.h.i.p.a aVar = new c.a.s0.h.i.p.a(this.a, false);
            aVar.k(this);
            aVar.i(eVar, this.f10649f);
        }
    }

    public void E(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048580, this, i2, i3, i4, i5) == null) {
            this.f10648e = new c.a.s0.h.i.i.c(i2, i3, i4, i5);
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
            c.a.s0.h.i.s.d.c(new e(this));
        }
    }

    public void H(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            c.a.s0.h.i.s.d.c(new d(this, str));
        }
    }

    @Override // c.a.s0.h.i.m.c
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            c.a.s0.h.i.i.f fVar = this.f10647d;
            if (fVar != null) {
                fVar.onError(str);
            }
            String appId = c.a.s0.h.i.n.a.b().getAppId();
            if (appId.lastIndexOf("_dev") >= 0 && appId.lastIndexOf("_dev") < appId.length() && str.equals("201000")) {
                w();
            }
            c.a.s0.h.i.i.f fVar2 = this.f10647d;
            if (fVar2 != null) {
                fVar2.a(false, "");
            }
        }
    }

    @Override // c.a.s0.h.i.i.d.e
    public void b() {
        c.a.s0.h.i.i.f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (fVar = this.f10647d) == null) {
            return;
        }
        fVar.onClose();
    }

    @Override // c.a.s0.h.i.m.c
    public void c(AdElementInfo adElementInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, adElementInfo) == null) {
            this.f10650g = adElementInfo;
            C();
        }
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            c.a.s0.h.i.i.d dVar = new c.a.s0.h.i.i.d(this.a);
            this.f10651h = dVar;
            dVar.e(this.f10648e.f10661c);
            if (this.f10651h.f() == null) {
                return;
            }
            if (this.n.c(this.f10651h.f())) {
                this.n.removeView(this.f10651h.f());
            }
            this.n.d(this.f10651h.f(), new c.a.s0.h.i.i.a(c.a.s0.h.i.s.h.a(this.f10648e.a), c.a.s0.h.i.s.h.a(this.f10648e.f10660b), c.a.s0.h.i.s.h.a(this.f10648e.f10663e), c.a.s0.h.i.s.h.a(this.f10648e.f10664f)));
            this.f10651h.f().postDelayed(new a(this), 20000L);
        }
    }

    public final void x() {
        c.a.s0.h.i.i.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (cVar = this.f10648e) == null) {
            return;
        }
        if (c.a.s0.h.i.s.h.a(cVar.f10661c) < 300) {
            this.f10648e.f10661c = c.a.s0.h.i.s.h.p(300.0f);
        }
        int q = c.a.s0.h.i.n.a.b().q();
        int p = c.a.s0.h.i.n.a.b().p();
        if (c.a.s0.h.i.s.h.a(this.f10648e.f10661c) > q) {
            this.f10648e.f10661c = c.a.s0.h.i.s.h.p(q);
        }
        c.a.s0.h.i.i.c cVar2 = this.f10648e;
        cVar2.f10662d = (int) (cVar2.f10661c / c.a.s0.h.i.i.e.a);
        if (cVar2.a < 0) {
            cVar2.a = 0;
        }
        int p2 = c.a.s0.h.i.s.h.p(q);
        c.a.s0.h.i.i.c cVar3 = this.f10648e;
        int i2 = p2 - cVar3.f10661c;
        if (cVar3.a > i2) {
            cVar3.a = i2;
        }
        c.a.s0.h.i.i.c cVar4 = this.f10648e;
        if (cVar4.f10660b < 0) {
            cVar4.f10660b = 0;
        }
        int p3 = c.a.s0.h.i.s.h.p(p);
        c.a.s0.h.i.i.c cVar5 = this.f10648e;
        int i3 = p3 - cVar5.f10662d;
        if (cVar5.f10660b > i3) {
            cVar5.f10660b = i3;
        }
        c.a.s0.h.i.i.c cVar6 = this.f10648e;
        cVar6.f10663e = cVar6.f10661c;
        cVar6.f10664f = cVar6.f10662d;
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            c.a.s0.h.i.s.d.c(new h(this));
        }
    }

    public final int z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (this.f10648e == null) {
                return 2;
            }
            int p = c.a.s0.h.i.s.h.p(c.a.s0.h.i.n.a.b().p());
            int i2 = this.f10648e.f10660b;
            int i3 = p / 3;
            if (i2 < i3) {
                return 1;
            }
            return i2 < i3 * 2 ? 4 : 2;
        }
        return invokeV.intValue;
    }
}
