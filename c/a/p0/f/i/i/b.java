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
public class b implements c.a.p0.f.i.l.b, d.e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f10498a;

    /* renamed from: b  reason: collision with root package name */
    public String f10499b;

    /* renamed from: c  reason: collision with root package name */
    public String f10500c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.p0.f.i.i.f f10501d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.p0.f.i.i.c f10502e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.p0.f.i.o.b f10503f;

    /* renamed from: g  reason: collision with root package name */
    public AdElementInfo f10504g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.p0.f.i.i.d f10505h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f10506i;

    /* renamed from: j  reason: collision with root package name */
    public String f10507j;
    public boolean k;
    public c.a.p0.f.i.k.b l;
    public Map<String, String> m;
    public c.a.p0.f.i.l.f n;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f10508e;

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
            this.f10508e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f10508e.f10505h == null || this.f10508e.f10505h.f() == null || !this.f10508e.n.c(this.f10508e.f10505h.f())) {
                return;
            }
            this.f10508e.n.removeView(this.f10508e.f10505h.f());
        }
    }

    /* renamed from: c.a.p0.f.i.i.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0522b implements c.a.p0.f.i.l.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f10509a;

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
            this.f10509a = bVar;
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
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) && this.f10509a.k) {
                this.f10509a.A(view);
                if (this.f10509a.f10501d != null) {
                    this.f10509a.f10501d.onClick();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements c.a.p0.f.i.l.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f10510a;

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
            this.f10510a = bVar;
        }

        @Override // c.a.p0.f.i.l.a
        public void b(CommandType commandType, Uri uri) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, commandType, uri) == null) || this.f10510a.f10504g == null) {
                return;
            }
            String clickUrl = this.f10510a.f10504g.getClickUrl();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("monitorUrl", c.a.p0.f.i.q.b.b("landingPageLoad", this.f10510a.m));
            } catch (JSONException unused) {
            }
            this.f10510a.n.a(clickUrl, jSONObject);
            c.a.p0.f.i.q.b.g(this.f10510a.f10504g, this.f10510a.f10503f);
            c.a.p0.f.i.q.b.n("lpClick", this.f10510a.m, this.f10510a.f10503f);
            c.a.p0.f.i.q.b.n(PrefetchEvent.STATE_CLICK, this.f10510a.m, this.f10510a.f10503f);
        }
    }

    /* loaded from: classes.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f10511e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f10512f;

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
            this.f10512f = bVar;
            this.f10511e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.p0.f.i.i.c cVar = this.f10512f.f10502e;
                boolean z = cVar.f10519c != cVar.f10521e;
                this.f10512f.x();
                if (this.f10512f.f10505h != null) {
                    this.f10512f.f10505h.e(this.f10512f.f10502e.f10519c);
                    this.f10512f.n.f(this.f10512f.f10505h.f(), new c.a.p0.f.i.i.a(c.a.p0.f.i.r.h.a(this.f10512f.f10502e.f10517a), c.a.p0.f.i.r.h.a(this.f10512f.f10502e.f10518b), c.a.p0.f.i.r.h.a(this.f10512f.f10502e.f10521e), c.a.p0.f.i.r.h.a(this.f10512f.f10502e.f10522f)));
                }
                if (this.f10511e.equals("width") && z && this.f10512f.f10501d != null) {
                    c.a.p0.f.i.i.f fVar = this.f10512f.f10501d;
                    c.a.p0.f.i.i.c cVar2 = this.f10512f.f10502e;
                    fVar.b(cVar2.f10521e, cVar2.f10522f);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f10513e;

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
            this.f10513e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f10513e.f10505h == null || !this.f10513e.n.c(this.f10513e.f10505h.f())) {
                    if (this.f10513e.f10501d != null) {
                        this.f10513e.f10501d.onShow(false);
                        this.f10513e.f10501d.onError("3010010");
                        return;
                    }
                    return;
                }
                this.f10513e.f10505h.l();
                if (this.f10513e.f10501d != null) {
                    this.f10513e.f10501d.onShow(true);
                }
                c.a.p0.f.i.q.b.n("showSuccess", this.f10513e.m, this.f10513e.f10503f);
                if (this.f10513e.f10506i) {
                    return;
                }
                this.f10513e.f10506i = true;
                if (this.f10513e.k) {
                    c.a.p0.f.i.q.d.f(this.f10513e.f10504g, this.f10513e.f10503f);
                    return;
                }
                c.a.p0.f.i.q.b.j(this.f10513e.f10504g, this.f10513e.f10503f);
                String str = this.f10513e.f10500c;
                b bVar = this.f10513e;
                c.a.p0.f.i.q.b.f(str, bVar.f10499b, bVar.f10507j, this.f10513e.f10503f);
                c.a.p0.f.i.q.b.n("show", this.f10513e.m, this.f10513e.f10503f);
            }
        }
    }

    /* loaded from: classes.dex */
    public class f implements c.a.p0.f.i.l.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f10514a;

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
            this.f10514a = bVar;
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
                if (this.f10514a.l == null) {
                    this.f10514a.l = new c.a.p0.f.i.k.b(this.f10514a.f10498a, this.f10514a.f10504g, this.f10514a.f10503f);
                }
                this.f10514a.l.k(str);
                c.a.p0.f.i.m.a.b().b(this.f10514a.f10498a, jSONObject, DownloadParams.SwanAppDownloadType.TYPE_START_DOWNLOAD, this.f10514a.l);
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
        public final /* synthetic */ b f10515e;

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
            this.f10515e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f10515e.f10505h == null) {
                return;
            }
            this.f10515e.f10505h.g();
        }
    }

    /* loaded from: classes.dex */
    public class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f10516e;

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
            this.f10516e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f10516e.f10505h != null) {
                    this.f10516e.n.removeView(this.f10516e.f10505h.f());
                }
                this.f10516e.f10505h = null;
                this.f10516e.f10501d = null;
                this.f10516e.f10504g = null;
                if (this.f10516e.l != null) {
                    this.f10516e.l.i();
                    this.f10516e.l = null;
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
        this.f10502e = null;
        this.m = new TreeMap();
        Context appContext = AppRuntime.getAppContext();
        this.f10498a = appContext;
        this.f10500c = str;
        this.f10499b = str2;
        this.f10501d = fVar;
        this.n = fVar2;
        this.f10503f = new c.a.p0.f.i.o.b(appContext);
        this.k = false;
        E(10, 10, VideoPlayFragment.COVER_ANIMINATION_TIME, 50);
        D();
    }

    public final void A(View view) {
        AdElementInfo adElementInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || !this.k || (adElementInfo = this.f10504g) == null || this.f10502e == null || view == null) {
            return;
        }
        c.a.p0.f.i.q.d.d(adElementInfo, this.f10503f);
        c.a.p0.f.i.q.a aVar = new c.a.p0.f.i.q.a();
        aVar.f10669a = String.valueOf(this.f10502e.f10519c);
        aVar.f10670b = String.valueOf(this.f10502e.f10520d);
        aVar.f10671c = String.valueOf(this.f10502e.f10519c);
        aVar.f10672d = String.valueOf(this.f10502e.f10520d);
        aVar.f10673e = String.valueOf((int) view.getX());
        aVar.f10674f = String.valueOf((int) view.getY());
        aVar.f10675g = String.valueOf((int) view.getX());
        aVar.f10676h = String.valueOf((int) view.getY());
        if (this.f10504g.getActionType() == 2) {
            c.a.p0.f.i.q.d.a(aVar, this.f10504g, this.f10503f, new f(this));
            return;
        }
        AdElementInfo adElementInfo2 = this.f10504g;
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
            c.a.p0.f.i.i.d dVar = new c.a.p0.f.i.i.d(this.f10498a, this.f10504g, this.f10499b, this.k);
            this.f10505h = dVar;
            dVar.i(this);
            if (this.k) {
                this.f10505h.k(new C0522b(this));
            } else {
                this.f10505h.j(new c(this));
            }
            this.f10505h.e(this.f10502e.f10519c);
            if (this.n.c(this.f10505h.f())) {
                this.n.removeView(this.f10505h.f());
            }
            if (this.n.d(this.f10505h.f(), new c.a.p0.f.i.i.a(c.a.p0.f.i.r.h.a(this.f10502e.f10517a), c.a.p0.f.i.r.h.a(this.f10502e.f10518b), c.a.p0.f.i.r.h.a(this.f10502e.f10521e), c.a.p0.f.i.r.h.a(this.f10502e.f10522f)))) {
                c.a.p0.f.i.i.f fVar = this.f10501d;
                if (fVar != null) {
                    fVar.a(true, "");
                    return;
                }
                return;
            }
            c.a.p0.f.i.i.f fVar2 = this.f10501d;
            if (fVar2 != null) {
                fVar2.onError("3010000");
            }
        }
    }

    public final void D() {
        c.a.p0.f.i.o.e dVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            c.a.p0.f.i.q.b.n("loadApi", this.m, this.f10503f);
            String appKey = c.a.p0.f.i.m.a.b().getAppKey();
            c.b bVar = new c.b();
            bVar.m(this.f10500c);
            bVar.j(this.f10499b);
            bVar.o(appKey);
            bVar.n("game");
            bVar.k("banner");
            bVar.l(this.f10502e.f10519c);
            bVar.i(this.f10502e.f10520d);
            c.a.p0.f.i.o.c h2 = bVar.h();
            if (this.k) {
                dVar = new c.a.p0.f.i.o.f(this.f10498a, h2, 1, z());
            } else {
                dVar = new c.a.p0.f.i.o.d(this.f10498a, h2);
                this.f10507j = dVar.c();
            }
            c.a.p0.f.i.o.a aVar = new c.a.p0.f.i.o.a(this.f10498a, false);
            aVar.k(this);
            aVar.i(dVar, this.f10503f);
        }
    }

    public void E(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048580, this, i2, i3, i4, i5) == null) {
            this.f10502e = new c.a.p0.f.i.i.c(i2, i3, i4, i5);
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
            c.a.p0.f.i.i.f fVar = this.f10501d;
            if (fVar != null) {
                fVar.onError(str);
            }
            String appId = c.a.p0.f.i.m.a.b().getAppId();
            if (appId.lastIndexOf("_dev") >= 0 && appId.lastIndexOf("_dev") < appId.length() && str.equals("201000")) {
                w();
            }
            c.a.p0.f.i.i.f fVar2 = this.f10501d;
            if (fVar2 != null) {
                fVar2.a(false, "");
            }
        }
    }

    @Override // c.a.p0.f.i.i.d.e
    public void b() {
        c.a.p0.f.i.i.f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (fVar = this.f10501d) == null) {
            return;
        }
        fVar.onClose();
    }

    @Override // c.a.p0.f.i.l.b
    public void c(AdElementInfo adElementInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, adElementInfo) == null) {
            this.f10504g = adElementInfo;
            C();
        }
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            c.a.p0.f.i.i.d dVar = new c.a.p0.f.i.i.d(this.f10498a);
            this.f10505h = dVar;
            dVar.e(this.f10502e.f10519c);
            if (this.f10505h.f() == null) {
                return;
            }
            if (this.n.c(this.f10505h.f())) {
                this.n.removeView(this.f10505h.f());
            }
            this.n.d(this.f10505h.f(), new c.a.p0.f.i.i.a(c.a.p0.f.i.r.h.a(this.f10502e.f10517a), c.a.p0.f.i.r.h.a(this.f10502e.f10518b), c.a.p0.f.i.r.h.a(this.f10502e.f10521e), c.a.p0.f.i.r.h.a(this.f10502e.f10522f)));
            this.f10505h.f().postDelayed(new a(this), 20000L);
        }
    }

    public final void x() {
        c.a.p0.f.i.i.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (cVar = this.f10502e) == null) {
            return;
        }
        if (c.a.p0.f.i.r.h.a(cVar.f10519c) < 300) {
            this.f10502e.f10519c = c.a.p0.f.i.r.h.p(300.0f);
        }
        int q = c.a.p0.f.i.m.a.b().q();
        int p = c.a.p0.f.i.m.a.b().p();
        if (c.a.p0.f.i.r.h.a(this.f10502e.f10519c) > q) {
            this.f10502e.f10519c = c.a.p0.f.i.r.h.p(q);
        }
        c.a.p0.f.i.i.c cVar2 = this.f10502e;
        cVar2.f10520d = (int) (cVar2.f10519c / c.a.p0.f.i.i.e.f10537a);
        if (cVar2.f10517a < 0) {
            cVar2.f10517a = 0;
        }
        int p2 = c.a.p0.f.i.r.h.p(q);
        c.a.p0.f.i.i.c cVar3 = this.f10502e;
        int i2 = p2 - cVar3.f10519c;
        if (cVar3.f10517a > i2) {
            cVar3.f10517a = i2;
        }
        c.a.p0.f.i.i.c cVar4 = this.f10502e;
        if (cVar4.f10518b < 0) {
            cVar4.f10518b = 0;
        }
        int p3 = c.a.p0.f.i.r.h.p(p);
        c.a.p0.f.i.i.c cVar5 = this.f10502e;
        int i3 = p3 - cVar5.f10520d;
        if (cVar5.f10518b > i3) {
            cVar5.f10518b = i3;
        }
        c.a.p0.f.i.i.c cVar6 = this.f10502e;
        cVar6.f10521e = cVar6.f10519c;
        cVar6.f10522f = cVar6.f10520d;
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
            if (this.f10502e == null) {
                return 2;
            }
            int p = c.a.p0.f.i.r.h.p(c.a.p0.f.i.m.a.b().p());
            int i2 = this.f10502e.f10518b;
            int i3 = p / 3;
            if (i2 < i3) {
                return 1;
            }
            return i2 < i3 * 2 ? 4 : 2;
        }
        return invokeV.intValue;
    }
}
