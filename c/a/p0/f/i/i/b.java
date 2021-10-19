package c.a.p0.f.i.i;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.f.i.i.d;
import c.a.p0.f.i.o.c;
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
public class b implements c.a.p0.f.i.l.b, d.e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f10506a;

    /* renamed from: b  reason: collision with root package name */
    public String f10507b;

    /* renamed from: c  reason: collision with root package name */
    public String f10508c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.p0.f.i.i.f f10509d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.p0.f.i.i.c f10510e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.p0.f.i.o.b f10511f;

    /* renamed from: g  reason: collision with root package name */
    public AdElementInfo f10512g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.p0.f.i.i.d f10513h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f10514i;

    /* renamed from: j  reason: collision with root package name */
    public String f10515j;
    public boolean k;
    public c.a.p0.f.i.k.b l;
    public Map<String, String> m;
    public c.a.p0.f.i.l.f n;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f10516e;

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
            this.f10516e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f10516e.f10513h == null || this.f10516e.f10513h.f() == null || !this.f10516e.n.c(this.f10516e.f10513h.f())) {
                return;
            }
            this.f10516e.n.removeView(this.f10516e.f10513h.f());
        }
    }

    /* renamed from: c.a.p0.f.i.i.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0522b implements c.a.p0.f.i.l.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f10517a;

        public C0522b(b bVar) {
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
            this.f10517a = bVar;
        }

        @Override // c.a.p0.f.i.l.d
        public void d(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) {
            }
        }

        @Override // c.a.p0.f.i.l.d
        public void f(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) && this.f10517a.k) {
                this.f10517a.A(view);
                if (this.f10517a.f10509d != null) {
                    this.f10517a.f10509d.onClick();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements c.a.p0.f.i.l.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f10518a;

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
            this.f10518a = bVar;
        }

        @Override // c.a.p0.f.i.l.a
        public void b(CommandType commandType, Uri uri) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, commandType, uri) == null) || this.f10518a.f10512g == null) {
                return;
            }
            String clickUrl = this.f10518a.f10512g.getClickUrl();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("monitorUrl", c.a.p0.f.i.q.b.b("landingPageLoad", this.f10518a.m));
            } catch (JSONException unused) {
            }
            this.f10518a.n.a(clickUrl, jSONObject);
            c.a.p0.f.i.q.b.g(this.f10518a.f10512g, this.f10518a.f10511f);
            c.a.p0.f.i.q.b.n("lpClick", this.f10518a.m, this.f10518a.f10511f);
            c.a.p0.f.i.q.b.n(PrefetchEvent.STATE_CLICK, this.f10518a.m, this.f10518a.f10511f);
        }
    }

    /* loaded from: classes.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f10519e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f10520f;

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
            this.f10520f = bVar;
            this.f10519e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.p0.f.i.i.c cVar = this.f10520f.f10510e;
                boolean z = cVar.f10527c != cVar.f10529e;
                this.f10520f.x();
                if (this.f10520f.f10513h != null) {
                    this.f10520f.f10513h.e(this.f10520f.f10510e.f10527c);
                    this.f10520f.n.f(this.f10520f.f10513h.f(), new c.a.p0.f.i.i.a(c.a.p0.f.i.r.h.a(this.f10520f.f10510e.f10525a), c.a.p0.f.i.r.h.a(this.f10520f.f10510e.f10526b), c.a.p0.f.i.r.h.a(this.f10520f.f10510e.f10529e), c.a.p0.f.i.r.h.a(this.f10520f.f10510e.f10530f)));
                }
                if (this.f10519e.equals("width") && z && this.f10520f.f10509d != null) {
                    c.a.p0.f.i.i.f fVar = this.f10520f.f10509d;
                    c.a.p0.f.i.i.c cVar2 = this.f10520f.f10510e;
                    fVar.b(cVar2.f10529e, cVar2.f10530f);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f10521e;

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
            this.f10521e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f10521e.f10513h == null || !this.f10521e.n.c(this.f10521e.f10513h.f())) {
                    if (this.f10521e.f10509d != null) {
                        this.f10521e.f10509d.onShow(false);
                        this.f10521e.f10509d.onError("3010010");
                        return;
                    }
                    return;
                }
                this.f10521e.f10513h.l();
                if (this.f10521e.f10509d != null) {
                    this.f10521e.f10509d.onShow(true);
                }
                c.a.p0.f.i.q.b.n("showSuccess", this.f10521e.m, this.f10521e.f10511f);
                if (this.f10521e.f10514i) {
                    return;
                }
                this.f10521e.f10514i = true;
                if (this.f10521e.k) {
                    c.a.p0.f.i.q.d.f(this.f10521e.f10512g, this.f10521e.f10511f);
                    return;
                }
                c.a.p0.f.i.q.b.j(this.f10521e.f10512g, this.f10521e.f10511f);
                String str = this.f10521e.f10508c;
                b bVar = this.f10521e;
                c.a.p0.f.i.q.b.f(str, bVar.f10507b, bVar.f10515j, this.f10521e.f10511f);
                c.a.p0.f.i.q.b.n("show", this.f10521e.m, this.f10521e.f10511f);
            }
        }
    }

    /* loaded from: classes.dex */
    public class f implements c.a.p0.f.i.l.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f10522a;

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
            this.f10522a = bVar;
        }

        @Override // c.a.p0.f.i.l.d
        public void d(String str, String str2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) || TextUtils.isEmpty(str2)) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("url", str2);
                if (this.f10522a.l == null) {
                    this.f10522a.l = new c.a.p0.f.i.k.b(this.f10522a.f10506a, this.f10522a.f10512g, this.f10522a.f10511f);
                }
                this.f10522a.l.k(str);
                c.a.p0.f.i.m.a.b().b(this.f10522a.f10506a, jSONObject, DownloadParams.SwanAppDownloadType.TYPE_START_DOWNLOAD, this.f10522a.l);
            } catch (JSONException unused) {
            }
        }

        @Override // c.a.p0.f.i.l.d
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
        public final /* synthetic */ b f10523e;

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
            this.f10523e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f10523e.f10513h == null) {
                return;
            }
            this.f10523e.f10513h.g();
        }
    }

    /* loaded from: classes.dex */
    public class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f10524e;

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
            this.f10524e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f10524e.f10513h != null) {
                    this.f10524e.n.removeView(this.f10524e.f10513h.f());
                }
                this.f10524e.f10513h = null;
                this.f10524e.f10509d = null;
                this.f10524e.f10512g = null;
                if (this.f10524e.l != null) {
                    this.f10524e.l.i();
                    this.f10524e.l = null;
                }
            }
        }
    }

    public b(String str, String str2, c.a.p0.f.i.i.f fVar, c.a.p0.f.i.l.f fVar2) {
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
        this.f10510e = null;
        this.m = new TreeMap();
        Context appContext = AppRuntime.getAppContext();
        this.f10506a = appContext;
        this.f10508c = str;
        this.f10507b = str2;
        this.f10509d = fVar;
        this.n = fVar2;
        this.f10511f = new c.a.p0.f.i.o.b(appContext);
        this.k = false;
        E(10, 10, 350, 50);
        D();
    }

    public final void A(View view) {
        AdElementInfo adElementInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || !this.k || (adElementInfo = this.f10512g) == null || this.f10510e == null || view == null) {
            return;
        }
        c.a.p0.f.i.q.d.d(adElementInfo, this.f10511f);
        c.a.p0.f.i.q.a aVar = new c.a.p0.f.i.q.a();
        aVar.f10677a = String.valueOf(this.f10510e.f10527c);
        aVar.f10678b = String.valueOf(this.f10510e.f10528d);
        aVar.f10679c = String.valueOf(this.f10510e.f10527c);
        aVar.f10680d = String.valueOf(this.f10510e.f10528d);
        aVar.f10681e = String.valueOf((int) view.getX());
        aVar.f10682f = String.valueOf((int) view.getY());
        aVar.f10683g = String.valueOf((int) view.getX());
        aVar.f10684h = String.valueOf((int) view.getY());
        if (this.f10512g.getActionType() == 2) {
            c.a.p0.f.i.q.d.a(aVar, this.f10512g, this.f10511f, new f(this));
            return;
        }
        AdElementInfo adElementInfo2 = this.f10512g;
        if (adElementInfo2 != null) {
            this.n.a(c.a.p0.f.i.q.d.c(adElementInfo2.getClickUrl(), aVar), new JSONObject());
        }
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            c.a.p0.f.i.r.d.c(new g(this));
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c.a.p0.f.i.i.d dVar = new c.a.p0.f.i.i.d(this.f10506a, this.f10512g, this.f10507b, this.k);
            this.f10513h = dVar;
            dVar.i(this);
            if (this.k) {
                this.f10513h.k(new C0522b(this));
            } else {
                this.f10513h.j(new c(this));
            }
            this.f10513h.e(this.f10510e.f10527c);
            if (this.n.c(this.f10513h.f())) {
                this.n.removeView(this.f10513h.f());
            }
            if (this.n.d(this.f10513h.f(), new c.a.p0.f.i.i.a(c.a.p0.f.i.r.h.a(this.f10510e.f10525a), c.a.p0.f.i.r.h.a(this.f10510e.f10526b), c.a.p0.f.i.r.h.a(this.f10510e.f10529e), c.a.p0.f.i.r.h.a(this.f10510e.f10530f)))) {
                c.a.p0.f.i.i.f fVar = this.f10509d;
                if (fVar != null) {
                    fVar.a(true, "");
                    return;
                }
                return;
            }
            c.a.p0.f.i.i.f fVar2 = this.f10509d;
            if (fVar2 != null) {
                fVar2.onError("3010000");
            }
        }
    }

    public final void D() {
        c.a.p0.f.i.o.e dVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            c.a.p0.f.i.q.b.n("loadApi", this.m, this.f10511f);
            String appKey = c.a.p0.f.i.m.a.b().getAppKey();
            c.b bVar = new c.b();
            bVar.m(this.f10508c);
            bVar.j(this.f10507b);
            bVar.o(appKey);
            bVar.n("game");
            bVar.k("banner");
            bVar.l(this.f10510e.f10527c);
            bVar.i(this.f10510e.f10528d);
            c.a.p0.f.i.o.c h2 = bVar.h();
            if (this.k) {
                dVar = new c.a.p0.f.i.o.f(this.f10506a, h2, 1, z());
            } else {
                dVar = new c.a.p0.f.i.o.d(this.f10506a, h2);
                this.f10515j = dVar.c();
            }
            c.a.p0.f.i.o.a aVar = new c.a.p0.f.i.o.a(this.f10506a, false);
            aVar.k(this);
            aVar.i(dVar, this.f10511f);
        }
    }

    public void E(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048580, this, i2, i3, i4, i5) == null) {
            this.f10510e = new c.a.p0.f.i.i.c(i2, i3, i4, i5);
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
            c.a.p0.f.i.r.d.c(new e(this));
        }
    }

    public void H(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            c.a.p0.f.i.r.d.c(new d(this, str));
        }
    }

    @Override // c.a.p0.f.i.l.b
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            c.a.p0.f.i.i.f fVar = this.f10509d;
            if (fVar != null) {
                fVar.onError(str);
            }
            String appId = c.a.p0.f.i.m.a.b().getAppId();
            if (appId.lastIndexOf("_dev") >= 0 && appId.lastIndexOf("_dev") < appId.length() && str.equals("201000")) {
                w();
            }
            c.a.p0.f.i.i.f fVar2 = this.f10509d;
            if (fVar2 != null) {
                fVar2.a(false, "");
            }
        }
    }

    @Override // c.a.p0.f.i.i.d.e
    public void b() {
        c.a.p0.f.i.i.f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (fVar = this.f10509d) == null) {
            return;
        }
        fVar.onClose();
    }

    @Override // c.a.p0.f.i.l.b
    public void c(AdElementInfo adElementInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, adElementInfo) == null) {
            this.f10512g = adElementInfo;
            C();
        }
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            c.a.p0.f.i.i.d dVar = new c.a.p0.f.i.i.d(this.f10506a);
            this.f10513h = dVar;
            dVar.e(this.f10510e.f10527c);
            if (this.f10513h.f() == null) {
                return;
            }
            if (this.n.c(this.f10513h.f())) {
                this.n.removeView(this.f10513h.f());
            }
            this.n.d(this.f10513h.f(), new c.a.p0.f.i.i.a(c.a.p0.f.i.r.h.a(this.f10510e.f10525a), c.a.p0.f.i.r.h.a(this.f10510e.f10526b), c.a.p0.f.i.r.h.a(this.f10510e.f10529e), c.a.p0.f.i.r.h.a(this.f10510e.f10530f)));
            this.f10513h.f().postDelayed(new a(this), 20000L);
        }
    }

    public final void x() {
        c.a.p0.f.i.i.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (cVar = this.f10510e) == null) {
            return;
        }
        if (c.a.p0.f.i.r.h.a(cVar.f10527c) < 300) {
            this.f10510e.f10527c = c.a.p0.f.i.r.h.p(300.0f);
        }
        int q = c.a.p0.f.i.m.a.b().q();
        int p = c.a.p0.f.i.m.a.b().p();
        if (c.a.p0.f.i.r.h.a(this.f10510e.f10527c) > q) {
            this.f10510e.f10527c = c.a.p0.f.i.r.h.p(q);
        }
        c.a.p0.f.i.i.c cVar2 = this.f10510e;
        cVar2.f10528d = (int) (cVar2.f10527c / c.a.p0.f.i.i.e.f10545a);
        if (cVar2.f10525a < 0) {
            cVar2.f10525a = 0;
        }
        int p2 = c.a.p0.f.i.r.h.p(q);
        c.a.p0.f.i.i.c cVar3 = this.f10510e;
        int i2 = p2 - cVar3.f10527c;
        if (cVar3.f10525a > i2) {
            cVar3.f10525a = i2;
        }
        c.a.p0.f.i.i.c cVar4 = this.f10510e;
        if (cVar4.f10526b < 0) {
            cVar4.f10526b = 0;
        }
        int p3 = c.a.p0.f.i.r.h.p(p);
        c.a.p0.f.i.i.c cVar5 = this.f10510e;
        int i3 = p3 - cVar5.f10528d;
        if (cVar5.f10526b > i3) {
            cVar5.f10526b = i3;
        }
        c.a.p0.f.i.i.c cVar6 = this.f10510e;
        cVar6.f10529e = cVar6.f10527c;
        cVar6.f10530f = cVar6.f10528d;
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            c.a.p0.f.i.r.d.c(new h(this));
        }
    }

    public final int z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (this.f10510e == null) {
                return 2;
            }
            int p = c.a.p0.f.i.r.h.p(c.a.p0.f.i.m.a.b().p());
            int i2 = this.f10510e.f10526b;
            int i3 = p / 3;
            if (i2 < i3) {
                return 1;
            }
            return i2 < i3 * 2 ? 4 : 2;
        }
        return invokeV.intValue;
    }
}
