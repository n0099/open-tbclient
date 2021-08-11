package c.a.n0.f.i.i;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.f.i.i.d;
import c.a.n0.f.i.o.c;
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
public class b implements c.a.n0.f.i.l.b, d.e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f10224a;

    /* renamed from: b  reason: collision with root package name */
    public String f10225b;

    /* renamed from: c  reason: collision with root package name */
    public String f10226c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.n0.f.i.i.f f10227d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.n0.f.i.i.c f10228e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.n0.f.i.o.b f10229f;

    /* renamed from: g  reason: collision with root package name */
    public AdElementInfo f10230g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.n0.f.i.i.d f10231h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f10232i;

    /* renamed from: j  reason: collision with root package name */
    public String f10233j;
    public boolean k;
    public c.a.n0.f.i.k.b l;
    public Map<String, String> m;
    public c.a.n0.f.i.l.f n;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f10234e;

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
            this.f10234e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f10234e.f10231h == null || this.f10234e.f10231h.f() == null || !this.f10234e.n.c(this.f10234e.f10231h.f())) {
                return;
            }
            this.f10234e.n.removeView(this.f10234e.f10231h.f());
        }
    }

    /* renamed from: c.a.n0.f.i.i.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0512b implements c.a.n0.f.i.l.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f10235a;

        public C0512b(b bVar) {
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
            this.f10235a = bVar;
        }

        @Override // c.a.n0.f.i.l.d
        public void d(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) {
            }
        }

        @Override // c.a.n0.f.i.l.d
        public void f(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) && this.f10235a.k) {
                this.f10235a.A(view);
                if (this.f10235a.f10227d != null) {
                    this.f10235a.f10227d.onClick();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements c.a.n0.f.i.l.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f10236a;

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
            this.f10236a = bVar;
        }

        @Override // c.a.n0.f.i.l.a
        public void b(CommandType commandType, Uri uri) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, commandType, uri) == null) || this.f10236a.f10230g == null) {
                return;
            }
            String clickUrl = this.f10236a.f10230g.getClickUrl();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("monitorUrl", c.a.n0.f.i.q.b.b("landingPageLoad", this.f10236a.m));
            } catch (JSONException unused) {
            }
            this.f10236a.n.a(clickUrl, jSONObject);
            c.a.n0.f.i.q.b.g(this.f10236a.f10230g, this.f10236a.f10229f);
            c.a.n0.f.i.q.b.n("lpClick", this.f10236a.m, this.f10236a.f10229f);
            c.a.n0.f.i.q.b.n(PrefetchEvent.STATE_CLICK, this.f10236a.m, this.f10236a.f10229f);
        }
    }

    /* loaded from: classes.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f10237e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f10238f;

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
            this.f10238f = bVar;
            this.f10237e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.n0.f.i.i.c cVar = this.f10238f.f10228e;
                boolean z = cVar.f10245c != cVar.f10247e;
                this.f10238f.x();
                if (this.f10238f.f10231h != null) {
                    this.f10238f.f10231h.e(this.f10238f.f10228e.f10245c);
                    this.f10238f.n.f(this.f10238f.f10231h.f(), new c.a.n0.f.i.i.a(c.a.n0.f.i.r.h.a(this.f10238f.f10228e.f10243a), c.a.n0.f.i.r.h.a(this.f10238f.f10228e.f10244b), c.a.n0.f.i.r.h.a(this.f10238f.f10228e.f10247e), c.a.n0.f.i.r.h.a(this.f10238f.f10228e.f10248f)));
                }
                if (this.f10237e.equals("width") && z && this.f10238f.f10227d != null) {
                    c.a.n0.f.i.i.f fVar = this.f10238f.f10227d;
                    c.a.n0.f.i.i.c cVar2 = this.f10238f.f10228e;
                    fVar.b(cVar2.f10247e, cVar2.f10248f);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f10239e;

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
            this.f10239e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f10239e.f10231h == null || !this.f10239e.n.c(this.f10239e.f10231h.f())) {
                    if (this.f10239e.f10227d != null) {
                        this.f10239e.f10227d.onShow(false);
                        this.f10239e.f10227d.onError("3010010");
                        return;
                    }
                    return;
                }
                this.f10239e.f10231h.l();
                if (this.f10239e.f10227d != null) {
                    this.f10239e.f10227d.onShow(true);
                }
                c.a.n0.f.i.q.b.n("showSuccess", this.f10239e.m, this.f10239e.f10229f);
                if (this.f10239e.f10232i) {
                    return;
                }
                this.f10239e.f10232i = true;
                if (this.f10239e.k) {
                    c.a.n0.f.i.q.d.f(this.f10239e.f10230g, this.f10239e.f10229f);
                    return;
                }
                c.a.n0.f.i.q.b.j(this.f10239e.f10230g, this.f10239e.f10229f);
                String str = this.f10239e.f10226c;
                b bVar = this.f10239e;
                c.a.n0.f.i.q.b.f(str, bVar.f10225b, bVar.f10233j, this.f10239e.f10229f);
                c.a.n0.f.i.q.b.n("show", this.f10239e.m, this.f10239e.f10229f);
            }
        }
    }

    /* loaded from: classes.dex */
    public class f implements c.a.n0.f.i.l.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f10240a;

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
            this.f10240a = bVar;
        }

        @Override // c.a.n0.f.i.l.d
        public void d(String str, String str2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) || TextUtils.isEmpty(str2)) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("url", str2);
                if (this.f10240a.l == null) {
                    this.f10240a.l = new c.a.n0.f.i.k.b(this.f10240a.f10224a, this.f10240a.f10230g, this.f10240a.f10229f);
                }
                this.f10240a.l.k(str);
                c.a.n0.f.i.m.a.b().b(this.f10240a.f10224a, jSONObject, DownloadParams.SwanAppDownloadType.TYPE_START_DOWNLOAD, this.f10240a.l);
            } catch (JSONException unused) {
            }
        }

        @Override // c.a.n0.f.i.l.d
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
        public final /* synthetic */ b f10241e;

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
            this.f10241e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f10241e.f10231h == null) {
                return;
            }
            this.f10241e.f10231h.g();
        }
    }

    /* loaded from: classes.dex */
    public class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f10242e;

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
            this.f10242e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f10242e.f10231h != null) {
                    this.f10242e.n.removeView(this.f10242e.f10231h.f());
                }
                this.f10242e.f10231h = null;
                this.f10242e.f10227d = null;
                this.f10242e.f10230g = null;
                if (this.f10242e.l != null) {
                    this.f10242e.l.i();
                    this.f10242e.l = null;
                }
            }
        }
    }

    public b(String str, String str2, c.a.n0.f.i.i.f fVar, c.a.n0.f.i.l.f fVar2) {
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
        this.f10228e = null;
        this.m = new TreeMap();
        Context appContext = AppRuntime.getAppContext();
        this.f10224a = appContext;
        this.f10226c = str;
        this.f10225b = str2;
        this.f10227d = fVar;
        this.n = fVar2;
        this.f10229f = new c.a.n0.f.i.o.b(appContext);
        this.k = false;
        E(10, 10, VideoPlayFragment.COVER_ANIMINATION_TIME, 50);
        D();
    }

    public final void A(View view) {
        AdElementInfo adElementInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || !this.k || (adElementInfo = this.f10230g) == null || this.f10228e == null || view == null) {
            return;
        }
        c.a.n0.f.i.q.d.d(adElementInfo, this.f10229f);
        c.a.n0.f.i.q.a aVar = new c.a.n0.f.i.q.a();
        aVar.f10395a = String.valueOf(this.f10228e.f10245c);
        aVar.f10396b = String.valueOf(this.f10228e.f10246d);
        aVar.f10397c = String.valueOf(this.f10228e.f10245c);
        aVar.f10398d = String.valueOf(this.f10228e.f10246d);
        aVar.f10399e = String.valueOf((int) view.getX());
        aVar.f10400f = String.valueOf((int) view.getY());
        aVar.f10401g = String.valueOf((int) view.getX());
        aVar.f10402h = String.valueOf((int) view.getY());
        if (this.f10230g.getActionType() == 2) {
            c.a.n0.f.i.q.d.a(aVar, this.f10230g, this.f10229f, new f(this));
            return;
        }
        AdElementInfo adElementInfo2 = this.f10230g;
        if (adElementInfo2 != null) {
            this.n.a(c.a.n0.f.i.q.d.c(adElementInfo2.getClickUrl(), aVar), new JSONObject());
        }
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            c.a.n0.f.i.r.d.c(new g(this));
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c.a.n0.f.i.i.d dVar = new c.a.n0.f.i.i.d(this.f10224a, this.f10230g, this.f10225b, this.k);
            this.f10231h = dVar;
            dVar.i(this);
            if (this.k) {
                this.f10231h.k(new C0512b(this));
            } else {
                this.f10231h.j(new c(this));
            }
            this.f10231h.e(this.f10228e.f10245c);
            if (this.n.c(this.f10231h.f())) {
                this.n.removeView(this.f10231h.f());
            }
            if (this.n.d(this.f10231h.f(), new c.a.n0.f.i.i.a(c.a.n0.f.i.r.h.a(this.f10228e.f10243a), c.a.n0.f.i.r.h.a(this.f10228e.f10244b), c.a.n0.f.i.r.h.a(this.f10228e.f10247e), c.a.n0.f.i.r.h.a(this.f10228e.f10248f)))) {
                c.a.n0.f.i.i.f fVar = this.f10227d;
                if (fVar != null) {
                    fVar.a(true, "");
                    return;
                }
                return;
            }
            c.a.n0.f.i.i.f fVar2 = this.f10227d;
            if (fVar2 != null) {
                fVar2.onError("3010000");
            }
        }
    }

    public final void D() {
        c.a.n0.f.i.o.e dVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            c.a.n0.f.i.q.b.n("loadApi", this.m, this.f10229f);
            String appKey = c.a.n0.f.i.m.a.b().getAppKey();
            c.b bVar = new c.b();
            bVar.m(this.f10226c);
            bVar.j(this.f10225b);
            bVar.o(appKey);
            bVar.n("game");
            bVar.k("banner");
            bVar.l(this.f10228e.f10245c);
            bVar.i(this.f10228e.f10246d);
            c.a.n0.f.i.o.c h2 = bVar.h();
            if (this.k) {
                dVar = new c.a.n0.f.i.o.f(this.f10224a, h2, 1, z());
            } else {
                dVar = new c.a.n0.f.i.o.d(this.f10224a, h2);
                this.f10233j = dVar.c();
            }
            c.a.n0.f.i.o.a aVar = new c.a.n0.f.i.o.a(this.f10224a, false);
            aVar.k(this);
            aVar.i(dVar, this.f10229f);
        }
    }

    public void E(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048580, this, i2, i3, i4, i5) == null) {
            this.f10228e = new c.a.n0.f.i.i.c(i2, i3, i4, i5);
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
            c.a.n0.f.i.r.d.c(new e(this));
        }
    }

    public void H(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            c.a.n0.f.i.r.d.c(new d(this, str));
        }
    }

    @Override // c.a.n0.f.i.l.b
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            c.a.n0.f.i.i.f fVar = this.f10227d;
            if (fVar != null) {
                fVar.onError(str);
            }
            String appId = c.a.n0.f.i.m.a.b().getAppId();
            if (appId.lastIndexOf("_dev") >= 0 && appId.lastIndexOf("_dev") < appId.length() && str.equals("201000")) {
                w();
            }
            c.a.n0.f.i.i.f fVar2 = this.f10227d;
            if (fVar2 != null) {
                fVar2.a(false, "");
            }
        }
    }

    @Override // c.a.n0.f.i.i.d.e
    public void b() {
        c.a.n0.f.i.i.f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (fVar = this.f10227d) == null) {
            return;
        }
        fVar.onClose();
    }

    @Override // c.a.n0.f.i.l.b
    public void c(AdElementInfo adElementInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, adElementInfo) == null) {
            this.f10230g = adElementInfo;
            C();
        }
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            c.a.n0.f.i.i.d dVar = new c.a.n0.f.i.i.d(this.f10224a);
            this.f10231h = dVar;
            dVar.e(this.f10228e.f10245c);
            if (this.f10231h.f() == null) {
                return;
            }
            if (this.n.c(this.f10231h.f())) {
                this.n.removeView(this.f10231h.f());
            }
            this.n.d(this.f10231h.f(), new c.a.n0.f.i.i.a(c.a.n0.f.i.r.h.a(this.f10228e.f10243a), c.a.n0.f.i.r.h.a(this.f10228e.f10244b), c.a.n0.f.i.r.h.a(this.f10228e.f10247e), c.a.n0.f.i.r.h.a(this.f10228e.f10248f)));
            this.f10231h.f().postDelayed(new a(this), 20000L);
        }
    }

    public final void x() {
        c.a.n0.f.i.i.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (cVar = this.f10228e) == null) {
            return;
        }
        if (c.a.n0.f.i.r.h.a(cVar.f10245c) < 300) {
            this.f10228e.f10245c = c.a.n0.f.i.r.h.p(300.0f);
        }
        int q = c.a.n0.f.i.m.a.b().q();
        int p = c.a.n0.f.i.m.a.b().p();
        if (c.a.n0.f.i.r.h.a(this.f10228e.f10245c) > q) {
            this.f10228e.f10245c = c.a.n0.f.i.r.h.p(q);
        }
        c.a.n0.f.i.i.c cVar2 = this.f10228e;
        cVar2.f10246d = (int) (cVar2.f10245c / c.a.n0.f.i.i.e.f10263a);
        if (cVar2.f10243a < 0) {
            cVar2.f10243a = 0;
        }
        int p2 = c.a.n0.f.i.r.h.p(q);
        c.a.n0.f.i.i.c cVar3 = this.f10228e;
        int i2 = p2 - cVar3.f10245c;
        if (cVar3.f10243a > i2) {
            cVar3.f10243a = i2;
        }
        c.a.n0.f.i.i.c cVar4 = this.f10228e;
        if (cVar4.f10244b < 0) {
            cVar4.f10244b = 0;
        }
        int p3 = c.a.n0.f.i.r.h.p(p);
        c.a.n0.f.i.i.c cVar5 = this.f10228e;
        int i3 = p3 - cVar5.f10246d;
        if (cVar5.f10244b > i3) {
            cVar5.f10244b = i3;
        }
        c.a.n0.f.i.i.c cVar6 = this.f10228e;
        cVar6.f10247e = cVar6.f10245c;
        cVar6.f10248f = cVar6.f10246d;
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            c.a.n0.f.i.r.d.c(new h(this));
        }
    }

    public final int z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (this.f10228e == null) {
                return 2;
            }
            int p = c.a.n0.f.i.r.h.p(c.a.n0.f.i.m.a.b().p());
            int i2 = this.f10228e.f10244b;
            int i3 = p / 3;
            if (i2 < i3) {
                return 1;
            }
            return i2 < i3 * 2 ? 4 : 2;
        }
        return invokeV.intValue;
    }
}
