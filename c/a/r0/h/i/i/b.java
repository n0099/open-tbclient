package c.a.r0.h.i.i;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.h.i.i.d;
import c.a.r0.h.i.p.d;
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
public class b implements c.a.r0.h.i.m.c, d.e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public String f10403b;

    /* renamed from: c  reason: collision with root package name */
    public String f10404c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.r0.h.i.i.f f10405d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.r0.h.i.i.c f10406e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.r0.h.i.p.c f10407f;

    /* renamed from: g  reason: collision with root package name */
    public AdElementInfo f10408g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.r0.h.i.i.d f10409h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f10410i;

    /* renamed from: j  reason: collision with root package name */
    public String f10411j;
    public boolean k;
    public c.a.r0.h.i.k.b l;
    public Map<String, String> m;
    public c.a.r0.h.i.m.g n;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f10412e;

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
            this.f10412e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f10412e.f10409h == null || this.f10412e.f10409h.f() == null || !this.f10412e.n.c(this.f10412e.f10409h.f())) {
                return;
            }
            this.f10412e.n.removeView(this.f10412e.f10409h.f());
        }
    }

    /* renamed from: c.a.r0.h.i.i.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C0692b implements c.a.r0.h.i.m.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public C0692b(b bVar) {
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

        @Override // c.a.r0.h.i.m.e
        public void d(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) {
            }
        }

        @Override // c.a.r0.h.i.m.e
        public void f(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) && this.a.k) {
                this.a.A(view);
                if (this.a.f10405d != null) {
                    this.a.f10405d.onClick();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements c.a.r0.h.i.m.a {
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

        @Override // c.a.r0.h.i.m.a
        public void b(CommandType commandType, Uri uri) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, commandType, uri) == null) || this.a.f10408g == null) {
                return;
            }
            String clickUrl = this.a.f10408g.getClickUrl();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("monitorUrl", c.a.r0.h.i.r.b.b("landingPageLoad", this.a.m));
            } catch (JSONException unused) {
            }
            this.a.n.a(clickUrl, jSONObject);
            c.a.r0.h.i.r.b.g(this.a.f10408g, this.a.f10407f);
            c.a.r0.h.i.r.b.n("lpClick", this.a.m, this.a.f10407f);
            c.a.r0.h.i.r.b.n("click", this.a.m, this.a.f10407f);
        }
    }

    /* loaded from: classes6.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f10413e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f10414f;

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
            this.f10414f = bVar;
            this.f10413e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.r0.h.i.i.c cVar = this.f10414f.f10406e;
                boolean z = cVar.f10419c != cVar.f10421e;
                this.f10414f.x();
                if (this.f10414f.f10409h != null) {
                    this.f10414f.f10409h.e(this.f10414f.f10406e.f10419c);
                    this.f10414f.n.f(this.f10414f.f10409h.f(), new c.a.r0.h.i.i.a(c.a.r0.h.i.s.h.a(this.f10414f.f10406e.a), c.a.r0.h.i.s.h.a(this.f10414f.f10406e.f10418b), c.a.r0.h.i.s.h.a(this.f10414f.f10406e.f10421e), c.a.r0.h.i.s.h.a(this.f10414f.f10406e.f10422f)));
                }
                if (this.f10413e.equals("width") && z && this.f10414f.f10405d != null) {
                    c.a.r0.h.i.i.f fVar = this.f10414f.f10405d;
                    c.a.r0.h.i.i.c cVar2 = this.f10414f.f10406e;
                    fVar.c(cVar2.f10421e, cVar2.f10422f);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f10415e;

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
            this.f10415e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f10415e.f10409h == null || !this.f10415e.n.c(this.f10415e.f10409h.f())) {
                    if (this.f10415e.f10405d != null) {
                        this.f10415e.f10405d.b(false);
                        this.f10415e.f10405d.onError("3010010");
                        return;
                    }
                    return;
                }
                this.f10415e.f10409h.l();
                if (this.f10415e.f10405d != null) {
                    this.f10415e.f10405d.b(true);
                }
                c.a.r0.h.i.r.b.n("showSuccess", this.f10415e.m, this.f10415e.f10407f);
                if (this.f10415e.f10410i) {
                    return;
                }
                this.f10415e.f10410i = true;
                if (this.f10415e.k) {
                    c.a.r0.h.i.r.d.f(this.f10415e.f10408g, this.f10415e.f10407f);
                    return;
                }
                c.a.r0.h.i.r.b.j(this.f10415e.f10408g, this.f10415e.f10407f);
                String str = this.f10415e.f10404c;
                b bVar = this.f10415e;
                c.a.r0.h.i.r.b.f(str, bVar.f10403b, bVar.f10411j, this.f10415e.f10407f);
                c.a.r0.h.i.r.b.n("show", this.f10415e.m, this.f10415e.f10407f);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements c.a.r0.h.i.m.e {
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

        @Override // c.a.r0.h.i.m.e
        public void d(String str, String str2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) || TextUtils.isEmpty(str2)) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("url", str2);
                if (this.a.l == null) {
                    this.a.l = new c.a.r0.h.i.k.b(this.a.a, this.a.f10408g, this.a.f10407f);
                }
                this.a.l.k(str);
                c.a.r0.h.i.n.a.b().d(this.a.a, jSONObject, DownloadParams.SwanAppDownloadType.TYPE_START_DOWNLOAD, this.a.l);
            } catch (JSONException unused) {
            }
        }

        @Override // c.a.r0.h.i.m.e
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
        public final /* synthetic */ b f10416e;

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
            this.f10416e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f10416e.f10409h == null) {
                return;
            }
            this.f10416e.f10409h.g();
        }
    }

    /* loaded from: classes6.dex */
    public class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f10417e;

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
            this.f10417e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f10417e.f10409h != null) {
                    this.f10417e.n.removeView(this.f10417e.f10409h.f());
                }
                this.f10417e.f10409h = null;
                this.f10417e.f10405d = null;
                this.f10417e.f10408g = null;
                if (this.f10417e.l != null) {
                    this.f10417e.l.i();
                    this.f10417e.l = null;
                }
            }
        }
    }

    public b(String str, String str2, c.a.r0.h.i.i.f fVar, c.a.r0.h.i.m.g gVar) {
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
        this.f10406e = null;
        this.m = new TreeMap();
        Context appContext = AppRuntime.getAppContext();
        this.a = appContext;
        this.f10404c = str;
        this.f10403b = str2;
        this.f10405d = fVar;
        this.n = gVar;
        this.f10407f = new c.a.r0.h.i.p.c(appContext);
        this.k = false;
        E(10, 10, 350, 50);
        D();
    }

    public final void A(View view) {
        AdElementInfo adElementInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || !this.k || (adElementInfo = this.f10408g) == null || this.f10406e == null || view == null) {
            return;
        }
        c.a.r0.h.i.r.d.d(adElementInfo, this.f10407f);
        c.a.r0.h.i.r.a aVar = new c.a.r0.h.i.r.a();
        aVar.a = String.valueOf(this.f10406e.f10419c);
        aVar.f10558b = String.valueOf(this.f10406e.f10420d);
        aVar.f10559c = String.valueOf(this.f10406e.f10419c);
        aVar.f10560d = String.valueOf(this.f10406e.f10420d);
        aVar.f10561e = String.valueOf((int) view.getX());
        aVar.f10562f = String.valueOf((int) view.getY());
        aVar.f10563g = String.valueOf((int) view.getX());
        aVar.f10564h = String.valueOf((int) view.getY());
        if (this.f10408g.getActionType() == 2) {
            c.a.r0.h.i.r.d.a(aVar, this.f10408g, this.f10407f, new f(this));
            return;
        }
        AdElementInfo adElementInfo2 = this.f10408g;
        if (adElementInfo2 != null) {
            this.n.a(c.a.r0.h.i.r.d.c(adElementInfo2.getClickUrl(), aVar), new JSONObject());
        }
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            c.a.r0.h.i.s.d.c(new g(this));
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c.a.r0.h.i.i.d dVar = new c.a.r0.h.i.i.d(this.a, this.f10408g, this.f10403b, this.k);
            this.f10409h = dVar;
            dVar.i(this);
            if (this.k) {
                this.f10409h.k(new C0692b(this));
            } else {
                this.f10409h.j(new c(this));
            }
            this.f10409h.e(this.f10406e.f10419c);
            if (this.n.c(this.f10409h.f())) {
                this.n.removeView(this.f10409h.f());
            }
            if (this.n.d(this.f10409h.f(), new c.a.r0.h.i.i.a(c.a.r0.h.i.s.h.a(this.f10406e.a), c.a.r0.h.i.s.h.a(this.f10406e.f10418b), c.a.r0.h.i.s.h.a(this.f10406e.f10421e), c.a.r0.h.i.s.h.a(this.f10406e.f10422f)))) {
                c.a.r0.h.i.i.f fVar = this.f10405d;
                if (fVar != null) {
                    fVar.a(true, "");
                    return;
                }
                return;
            }
            c.a.r0.h.i.i.f fVar2 = this.f10405d;
            if (fVar2 != null) {
                fVar2.onError("3010000");
            }
        }
    }

    public final void D() {
        c.a.r0.h.i.p.f eVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            c.a.r0.h.i.r.b.n("loadApi", this.m, this.f10407f);
            String appKey = c.a.r0.h.i.n.a.b().getAppKey();
            d.b bVar = new d.b();
            bVar.m(this.f10404c);
            bVar.j(this.f10403b);
            bVar.o(appKey);
            bVar.n("game");
            bVar.k(SpeedStatsUtils.UBC_VALUE_BANNER);
            bVar.l(this.f10406e.f10419c);
            bVar.i(this.f10406e.f10420d);
            c.a.r0.h.i.p.d h2 = bVar.h();
            if (this.k) {
                eVar = new c.a.r0.h.i.p.g(this.a, h2, 1, z());
            } else {
                eVar = new c.a.r0.h.i.p.e(this.a, h2);
                this.f10411j = eVar.c();
            }
            c.a.r0.h.i.p.a aVar = new c.a.r0.h.i.p.a(this.a, false);
            aVar.k(this);
            aVar.i(eVar, this.f10407f);
        }
    }

    public void E(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048580, this, i2, i3, i4, i5) == null) {
            this.f10406e = new c.a.r0.h.i.i.c(i2, i3, i4, i5);
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
            c.a.r0.h.i.s.d.c(new e(this));
        }
    }

    public void H(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            c.a.r0.h.i.s.d.c(new d(this, str));
        }
    }

    @Override // c.a.r0.h.i.m.c
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            c.a.r0.h.i.i.f fVar = this.f10405d;
            if (fVar != null) {
                fVar.onError(str);
            }
            String appId = c.a.r0.h.i.n.a.b().getAppId();
            if (appId.lastIndexOf("_dev") >= 0 && appId.lastIndexOf("_dev") < appId.length() && str.equals("201000")) {
                w();
            }
            c.a.r0.h.i.i.f fVar2 = this.f10405d;
            if (fVar2 != null) {
                fVar2.a(false, "");
            }
        }
    }

    @Override // c.a.r0.h.i.i.d.e
    public void b() {
        c.a.r0.h.i.i.f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (fVar = this.f10405d) == null) {
            return;
        }
        fVar.onClose();
    }

    @Override // c.a.r0.h.i.m.c
    public void c(AdElementInfo adElementInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, adElementInfo) == null) {
            this.f10408g = adElementInfo;
            C();
        }
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            c.a.r0.h.i.i.d dVar = new c.a.r0.h.i.i.d(this.a);
            this.f10409h = dVar;
            dVar.e(this.f10406e.f10419c);
            if (this.f10409h.f() == null) {
                return;
            }
            if (this.n.c(this.f10409h.f())) {
                this.n.removeView(this.f10409h.f());
            }
            this.n.d(this.f10409h.f(), new c.a.r0.h.i.i.a(c.a.r0.h.i.s.h.a(this.f10406e.a), c.a.r0.h.i.s.h.a(this.f10406e.f10418b), c.a.r0.h.i.s.h.a(this.f10406e.f10421e), c.a.r0.h.i.s.h.a(this.f10406e.f10422f)));
            this.f10409h.f().postDelayed(new a(this), 20000L);
        }
    }

    public final void x() {
        c.a.r0.h.i.i.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (cVar = this.f10406e) == null) {
            return;
        }
        if (c.a.r0.h.i.s.h.a(cVar.f10419c) < 300) {
            this.f10406e.f10419c = c.a.r0.h.i.s.h.p(300.0f);
        }
        int q = c.a.r0.h.i.n.a.b().q();
        int p = c.a.r0.h.i.n.a.b().p();
        if (c.a.r0.h.i.s.h.a(this.f10406e.f10419c) > q) {
            this.f10406e.f10419c = c.a.r0.h.i.s.h.p(q);
        }
        c.a.r0.h.i.i.c cVar2 = this.f10406e;
        cVar2.f10420d = (int) (cVar2.f10419c / c.a.r0.h.i.i.e.a);
        if (cVar2.a < 0) {
            cVar2.a = 0;
        }
        int p2 = c.a.r0.h.i.s.h.p(q);
        c.a.r0.h.i.i.c cVar3 = this.f10406e;
        int i2 = p2 - cVar3.f10419c;
        if (cVar3.a > i2) {
            cVar3.a = i2;
        }
        c.a.r0.h.i.i.c cVar4 = this.f10406e;
        if (cVar4.f10418b < 0) {
            cVar4.f10418b = 0;
        }
        int p3 = c.a.r0.h.i.s.h.p(p);
        c.a.r0.h.i.i.c cVar5 = this.f10406e;
        int i3 = p3 - cVar5.f10420d;
        if (cVar5.f10418b > i3) {
            cVar5.f10418b = i3;
        }
        c.a.r0.h.i.i.c cVar6 = this.f10406e;
        cVar6.f10421e = cVar6.f10419c;
        cVar6.f10422f = cVar6.f10420d;
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            c.a.r0.h.i.s.d.c(new h(this));
        }
    }

    public final int z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (this.f10406e == null) {
                return 2;
            }
            int p = c.a.r0.h.i.s.h.p(c.a.r0.h.i.n.a.b().p());
            int i2 = this.f10406e.f10418b;
            int i3 = p / 3;
            if (i2 < i3) {
                return 1;
            }
            return i2 < i3 * 2 ? 4 : 2;
        }
        return invokeV.intValue;
    }
}
