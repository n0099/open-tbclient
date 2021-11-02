package b.a.p0.f.i.i;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.f.i.i.d;
import b.a.p0.f.i.o.c;
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
public class b implements b.a.p0.f.i.l.b, d.e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f9724a;

    /* renamed from: b  reason: collision with root package name */
    public String f9725b;

    /* renamed from: c  reason: collision with root package name */
    public String f9726c;

    /* renamed from: d  reason: collision with root package name */
    public b.a.p0.f.i.i.f f9727d;

    /* renamed from: e  reason: collision with root package name */
    public b.a.p0.f.i.i.c f9728e;

    /* renamed from: f  reason: collision with root package name */
    public b.a.p0.f.i.o.b f9729f;

    /* renamed from: g  reason: collision with root package name */
    public AdElementInfo f9730g;

    /* renamed from: h  reason: collision with root package name */
    public b.a.p0.f.i.i.d f9731h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f9732i;
    public String j;
    public boolean k;
    public b.a.p0.f.i.k.b l;
    public Map<String, String> m;
    public b.a.p0.f.i.l.f n;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f9733e;

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
            this.f9733e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f9733e.f9731h == null || this.f9733e.f9731h.f() == null || !this.f9733e.n.c(this.f9733e.f9731h.f())) {
                return;
            }
            this.f9733e.n.removeView(this.f9733e.f9731h.f());
        }
    }

    /* renamed from: b.a.p0.f.i.i.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0517b implements b.a.p0.f.i.l.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f9734a;

        public C0517b(b bVar) {
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
            this.f9734a = bVar;
        }

        @Override // b.a.p0.f.i.l.d
        public void d(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) {
            }
        }

        @Override // b.a.p0.f.i.l.d
        public void f(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) && this.f9734a.k) {
                this.f9734a.A(view);
                if (this.f9734a.f9727d != null) {
                    this.f9734a.f9727d.onClick();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements b.a.p0.f.i.l.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f9735a;

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
            this.f9735a = bVar;
        }

        @Override // b.a.p0.f.i.l.a
        public void b(CommandType commandType, Uri uri) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, commandType, uri) == null) || this.f9735a.f9730g == null) {
                return;
            }
            String clickUrl = this.f9735a.f9730g.getClickUrl();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("monitorUrl", b.a.p0.f.i.q.b.b("landingPageLoad", this.f9735a.m));
            } catch (JSONException unused) {
            }
            this.f9735a.n.a(clickUrl, jSONObject);
            b.a.p0.f.i.q.b.g(this.f9735a.f9730g, this.f9735a.f9729f);
            b.a.p0.f.i.q.b.n("lpClick", this.f9735a.m, this.f9735a.f9729f);
            b.a.p0.f.i.q.b.n(PrefetchEvent.STATE_CLICK, this.f9735a.m, this.f9735a.f9729f);
        }
    }

    /* loaded from: classes.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f9736e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f9737f;

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
            this.f9737f = bVar;
            this.f9736e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.a.p0.f.i.i.c cVar = this.f9737f.f9728e;
                boolean z = cVar.f9744c != cVar.f9746e;
                this.f9737f.x();
                if (this.f9737f.f9731h != null) {
                    this.f9737f.f9731h.e(this.f9737f.f9728e.f9744c);
                    this.f9737f.n.f(this.f9737f.f9731h.f(), new b.a.p0.f.i.i.a(b.a.p0.f.i.r.h.a(this.f9737f.f9728e.f9742a), b.a.p0.f.i.r.h.a(this.f9737f.f9728e.f9743b), b.a.p0.f.i.r.h.a(this.f9737f.f9728e.f9746e), b.a.p0.f.i.r.h.a(this.f9737f.f9728e.f9747f)));
                }
                if (this.f9736e.equals("width") && z && this.f9737f.f9727d != null) {
                    b.a.p0.f.i.i.f fVar = this.f9737f.f9727d;
                    b.a.p0.f.i.i.c cVar2 = this.f9737f.f9728e;
                    fVar.b(cVar2.f9746e, cVar2.f9747f);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f9738e;

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
            this.f9738e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f9738e.f9731h == null || !this.f9738e.n.c(this.f9738e.f9731h.f())) {
                    if (this.f9738e.f9727d != null) {
                        this.f9738e.f9727d.onShow(false);
                        this.f9738e.f9727d.onError("3010010");
                        return;
                    }
                    return;
                }
                this.f9738e.f9731h.l();
                if (this.f9738e.f9727d != null) {
                    this.f9738e.f9727d.onShow(true);
                }
                b.a.p0.f.i.q.b.n("showSuccess", this.f9738e.m, this.f9738e.f9729f);
                if (this.f9738e.f9732i) {
                    return;
                }
                this.f9738e.f9732i = true;
                if (this.f9738e.k) {
                    b.a.p0.f.i.q.d.f(this.f9738e.f9730g, this.f9738e.f9729f);
                    return;
                }
                b.a.p0.f.i.q.b.j(this.f9738e.f9730g, this.f9738e.f9729f);
                String str = this.f9738e.f9726c;
                b bVar = this.f9738e;
                b.a.p0.f.i.q.b.f(str, bVar.f9725b, bVar.j, this.f9738e.f9729f);
                b.a.p0.f.i.q.b.n("show", this.f9738e.m, this.f9738e.f9729f);
            }
        }
    }

    /* loaded from: classes.dex */
    public class f implements b.a.p0.f.i.l.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f9739a;

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
            this.f9739a = bVar;
        }

        @Override // b.a.p0.f.i.l.d
        public void d(String str, String str2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) || TextUtils.isEmpty(str2)) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("url", str2);
                if (this.f9739a.l == null) {
                    this.f9739a.l = new b.a.p0.f.i.k.b(this.f9739a.f9724a, this.f9739a.f9730g, this.f9739a.f9729f);
                }
                this.f9739a.l.k(str);
                b.a.p0.f.i.m.a.b().b(this.f9739a.f9724a, jSONObject, DownloadParams.SwanAppDownloadType.TYPE_START_DOWNLOAD, this.f9739a.l);
            } catch (JSONException unused) {
            }
        }

        @Override // b.a.p0.f.i.l.d
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
        public final /* synthetic */ b f9740e;

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
            this.f9740e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f9740e.f9731h == null) {
                return;
            }
            this.f9740e.f9731h.g();
        }
    }

    /* loaded from: classes.dex */
    public class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f9741e;

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
            this.f9741e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f9741e.f9731h != null) {
                    this.f9741e.n.removeView(this.f9741e.f9731h.f());
                }
                this.f9741e.f9731h = null;
                this.f9741e.f9727d = null;
                this.f9741e.f9730g = null;
                if (this.f9741e.l != null) {
                    this.f9741e.l.i();
                    this.f9741e.l = null;
                }
            }
        }
    }

    public b(String str, String str2, b.a.p0.f.i.i.f fVar, b.a.p0.f.i.l.f fVar2) {
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
        this.f9728e = null;
        this.m = new TreeMap();
        Context appContext = AppRuntime.getAppContext();
        this.f9724a = appContext;
        this.f9726c = str;
        this.f9725b = str2;
        this.f9727d = fVar;
        this.n = fVar2;
        this.f9729f = new b.a.p0.f.i.o.b(appContext);
        this.k = false;
        E(10, 10, 350, 50);
        D();
    }

    public final void A(View view) {
        AdElementInfo adElementInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || !this.k || (adElementInfo = this.f9730g) == null || this.f9728e == null || view == null) {
            return;
        }
        b.a.p0.f.i.q.d.d(adElementInfo, this.f9729f);
        b.a.p0.f.i.q.a aVar = new b.a.p0.f.i.q.a();
        aVar.f9888a = String.valueOf(this.f9728e.f9744c);
        aVar.f9889b = String.valueOf(this.f9728e.f9745d);
        aVar.f9890c = String.valueOf(this.f9728e.f9744c);
        aVar.f9891d = String.valueOf(this.f9728e.f9745d);
        aVar.f9892e = String.valueOf((int) view.getX());
        aVar.f9893f = String.valueOf((int) view.getY());
        aVar.f9894g = String.valueOf((int) view.getX());
        aVar.f9895h = String.valueOf((int) view.getY());
        if (this.f9730g.getActionType() == 2) {
            b.a.p0.f.i.q.d.a(aVar, this.f9730g, this.f9729f, new f(this));
            return;
        }
        AdElementInfo adElementInfo2 = this.f9730g;
        if (adElementInfo2 != null) {
            this.n.a(b.a.p0.f.i.q.d.c(adElementInfo2.getClickUrl(), aVar), new JSONObject());
        }
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            b.a.p0.f.i.r.d.c(new g(this));
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            b.a.p0.f.i.i.d dVar = new b.a.p0.f.i.i.d(this.f9724a, this.f9730g, this.f9725b, this.k);
            this.f9731h = dVar;
            dVar.i(this);
            if (this.k) {
                this.f9731h.k(new C0517b(this));
            } else {
                this.f9731h.j(new c(this));
            }
            this.f9731h.e(this.f9728e.f9744c);
            if (this.n.c(this.f9731h.f())) {
                this.n.removeView(this.f9731h.f());
            }
            if (this.n.d(this.f9731h.f(), new b.a.p0.f.i.i.a(b.a.p0.f.i.r.h.a(this.f9728e.f9742a), b.a.p0.f.i.r.h.a(this.f9728e.f9743b), b.a.p0.f.i.r.h.a(this.f9728e.f9746e), b.a.p0.f.i.r.h.a(this.f9728e.f9747f)))) {
                b.a.p0.f.i.i.f fVar = this.f9727d;
                if (fVar != null) {
                    fVar.a(true, "");
                    return;
                }
                return;
            }
            b.a.p0.f.i.i.f fVar2 = this.f9727d;
            if (fVar2 != null) {
                fVar2.onError("3010000");
            }
        }
    }

    public final void D() {
        b.a.p0.f.i.o.e dVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            b.a.p0.f.i.q.b.n("loadApi", this.m, this.f9729f);
            String appKey = b.a.p0.f.i.m.a.b().getAppKey();
            c.b bVar = new c.b();
            bVar.m(this.f9726c);
            bVar.j(this.f9725b);
            bVar.o(appKey);
            bVar.n("game");
            bVar.k("banner");
            bVar.l(this.f9728e.f9744c);
            bVar.i(this.f9728e.f9745d);
            b.a.p0.f.i.o.c h2 = bVar.h();
            if (this.k) {
                dVar = new b.a.p0.f.i.o.f(this.f9724a, h2, 1, z());
            } else {
                dVar = new b.a.p0.f.i.o.d(this.f9724a, h2);
                this.j = dVar.c();
            }
            b.a.p0.f.i.o.a aVar = new b.a.p0.f.i.o.a(this.f9724a, false);
            aVar.k(this);
            aVar.i(dVar, this.f9729f);
        }
    }

    public void E(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048580, this, i2, i3, i4, i5) == null) {
            this.f9728e = new b.a.p0.f.i.i.c(i2, i3, i4, i5);
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
            b.a.p0.f.i.r.d.c(new e(this));
        }
    }

    public void H(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            b.a.p0.f.i.r.d.c(new d(this, str));
        }
    }

    @Override // b.a.p0.f.i.l.b
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            b.a.p0.f.i.i.f fVar = this.f9727d;
            if (fVar != null) {
                fVar.onError(str);
            }
            String appId = b.a.p0.f.i.m.a.b().getAppId();
            if (appId.lastIndexOf("_dev") >= 0 && appId.lastIndexOf("_dev") < appId.length() && str.equals("201000")) {
                w();
            }
            b.a.p0.f.i.i.f fVar2 = this.f9727d;
            if (fVar2 != null) {
                fVar2.a(false, "");
            }
        }
    }

    @Override // b.a.p0.f.i.i.d.e
    public void b() {
        b.a.p0.f.i.i.f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (fVar = this.f9727d) == null) {
            return;
        }
        fVar.onClose();
    }

    @Override // b.a.p0.f.i.l.b
    public void c(AdElementInfo adElementInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, adElementInfo) == null) {
            this.f9730g = adElementInfo;
            C();
        }
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            b.a.p0.f.i.i.d dVar = new b.a.p0.f.i.i.d(this.f9724a);
            this.f9731h = dVar;
            dVar.e(this.f9728e.f9744c);
            if (this.f9731h.f() == null) {
                return;
            }
            if (this.n.c(this.f9731h.f())) {
                this.n.removeView(this.f9731h.f());
            }
            this.n.d(this.f9731h.f(), new b.a.p0.f.i.i.a(b.a.p0.f.i.r.h.a(this.f9728e.f9742a), b.a.p0.f.i.r.h.a(this.f9728e.f9743b), b.a.p0.f.i.r.h.a(this.f9728e.f9746e), b.a.p0.f.i.r.h.a(this.f9728e.f9747f)));
            this.f9731h.f().postDelayed(new a(this), 20000L);
        }
    }

    public final void x() {
        b.a.p0.f.i.i.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (cVar = this.f9728e) == null) {
            return;
        }
        if (b.a.p0.f.i.r.h.a(cVar.f9744c) < 300) {
            this.f9728e.f9744c = b.a.p0.f.i.r.h.p(300.0f);
        }
        int q = b.a.p0.f.i.m.a.b().q();
        int p = b.a.p0.f.i.m.a.b().p();
        if (b.a.p0.f.i.r.h.a(this.f9728e.f9744c) > q) {
            this.f9728e.f9744c = b.a.p0.f.i.r.h.p(q);
        }
        b.a.p0.f.i.i.c cVar2 = this.f9728e;
        cVar2.f9745d = (int) (cVar2.f9744c / b.a.p0.f.i.i.e.f9761a);
        if (cVar2.f9742a < 0) {
            cVar2.f9742a = 0;
        }
        int p2 = b.a.p0.f.i.r.h.p(q);
        b.a.p0.f.i.i.c cVar3 = this.f9728e;
        int i2 = p2 - cVar3.f9744c;
        if (cVar3.f9742a > i2) {
            cVar3.f9742a = i2;
        }
        b.a.p0.f.i.i.c cVar4 = this.f9728e;
        if (cVar4.f9743b < 0) {
            cVar4.f9743b = 0;
        }
        int p3 = b.a.p0.f.i.r.h.p(p);
        b.a.p0.f.i.i.c cVar5 = this.f9728e;
        int i3 = p3 - cVar5.f9745d;
        if (cVar5.f9743b > i3) {
            cVar5.f9743b = i3;
        }
        b.a.p0.f.i.i.c cVar6 = this.f9728e;
        cVar6.f9746e = cVar6.f9744c;
        cVar6.f9747f = cVar6.f9745d;
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            b.a.p0.f.i.r.d.c(new h(this));
        }
    }

    public final int z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (this.f9728e == null) {
                return 2;
            }
            int p = b.a.p0.f.i.r.h.p(b.a.p0.f.i.m.a.b().p());
            int i2 = this.f9728e.f9743b;
            int i3 = p / 3;
            if (i2 < i3) {
                return 1;
            }
            return i2 < i3 * 2 ? 4 : 2;
        }
        return invokeV.intValue;
    }
}
