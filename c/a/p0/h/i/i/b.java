package c.a.p0.h.i.i;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.h.i.i.d;
import c.a.p0.h.i.p.d;
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
/* loaded from: classes5.dex */
public class b implements c.a.p0.h.i.m.c, d.e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public String f9589b;

    /* renamed from: c  reason: collision with root package name */
    public String f9590c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.p0.h.i.i.f f9591d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.p0.h.i.i.c f9592e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.p0.h.i.p.c f9593f;

    /* renamed from: g  reason: collision with root package name */
    public AdElementInfo f9594g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.p0.h.i.i.d f9595h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f9596i;

    /* renamed from: j  reason: collision with root package name */
    public String f9597j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f9598k;
    public c.a.p0.h.i.k.b l;
    public Map<String, String> m;
    public c.a.p0.h.i.m.g n;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f9599e;

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
            this.f9599e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f9599e.f9595h == null || this.f9599e.f9595h.f() == null || !this.f9599e.n.c(this.f9599e.f9595h.f())) {
                return;
            }
            this.f9599e.n.removeView(this.f9599e.f9595h.f());
        }
    }

    /* renamed from: c.a.p0.h.i.i.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C0599b implements c.a.p0.h.i.m.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public C0599b(b bVar) {
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

        @Override // c.a.p0.h.i.m.e
        public void d(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) {
            }
        }

        @Override // c.a.p0.h.i.m.e
        public void f(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) && this.a.f9598k) {
                this.a.A(view);
                if (this.a.f9591d != null) {
                    this.a.f9591d.onClick();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements c.a.p0.h.i.m.a {
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

        @Override // c.a.p0.h.i.m.a
        public void b(CommandType commandType, Uri uri) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, commandType, uri) == null) || this.a.f9594g == null) {
                return;
            }
            String clickUrl = this.a.f9594g.getClickUrl();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("monitorUrl", c.a.p0.h.i.r.b.b("landingPageLoad", this.a.m));
            } catch (JSONException unused) {
            }
            this.a.n.a(clickUrl, jSONObject);
            c.a.p0.h.i.r.b.g(this.a.f9594g, this.a.f9593f);
            c.a.p0.h.i.r.b.n("lpClick", this.a.m, this.a.f9593f);
            c.a.p0.h.i.r.b.n("click", this.a.m, this.a.f9593f);
        }
    }

    /* loaded from: classes5.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f9600e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f9601f;

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
            this.f9601f = bVar;
            this.f9600e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.p0.h.i.i.c cVar = this.f9601f.f9592e;
                boolean z = cVar.f9606c != cVar.f9608e;
                this.f9601f.x();
                if (this.f9601f.f9595h != null) {
                    this.f9601f.f9595h.e(this.f9601f.f9592e.f9606c);
                    this.f9601f.n.f(this.f9601f.f9595h.f(), new c.a.p0.h.i.i.a(c.a.p0.h.i.s.h.a(this.f9601f.f9592e.a), c.a.p0.h.i.s.h.a(this.f9601f.f9592e.f9605b), c.a.p0.h.i.s.h.a(this.f9601f.f9592e.f9608e), c.a.p0.h.i.s.h.a(this.f9601f.f9592e.f9609f)));
                }
                if (this.f9600e.equals("width") && z && this.f9601f.f9591d != null) {
                    c.a.p0.h.i.i.f fVar = this.f9601f.f9591d;
                    c.a.p0.h.i.i.c cVar2 = this.f9601f.f9592e;
                    fVar.c(cVar2.f9608e, cVar2.f9609f);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f9602e;

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
            this.f9602e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f9602e.f9595h == null || !this.f9602e.n.c(this.f9602e.f9595h.f())) {
                    if (this.f9602e.f9591d != null) {
                        this.f9602e.f9591d.b(false);
                        this.f9602e.f9591d.onError("3010010");
                        return;
                    }
                    return;
                }
                this.f9602e.f9595h.l();
                if (this.f9602e.f9591d != null) {
                    this.f9602e.f9591d.b(true);
                }
                c.a.p0.h.i.r.b.n("showSuccess", this.f9602e.m, this.f9602e.f9593f);
                if (this.f9602e.f9596i) {
                    return;
                }
                this.f9602e.f9596i = true;
                if (this.f9602e.f9598k) {
                    c.a.p0.h.i.r.d.f(this.f9602e.f9594g, this.f9602e.f9593f);
                    return;
                }
                c.a.p0.h.i.r.b.j(this.f9602e.f9594g, this.f9602e.f9593f);
                String str = this.f9602e.f9590c;
                b bVar = this.f9602e;
                c.a.p0.h.i.r.b.f(str, bVar.f9589b, bVar.f9597j, this.f9602e.f9593f);
                c.a.p0.h.i.r.b.n("show", this.f9602e.m, this.f9602e.f9593f);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements c.a.p0.h.i.m.e {
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

        @Override // c.a.p0.h.i.m.e
        public void d(String str, String str2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) || TextUtils.isEmpty(str2)) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("url", str2);
                if (this.a.l == null) {
                    this.a.l = new c.a.p0.h.i.k.b(this.a.a, this.a.f9594g, this.a.f9593f);
                }
                this.a.l.k(str);
                c.a.p0.h.i.n.a.b().d(this.a.a, jSONObject, DownloadParams.SwanAppDownloadType.TYPE_START_DOWNLOAD, this.a.l);
            } catch (JSONException unused) {
            }
        }

        @Override // c.a.p0.h.i.m.e
        public void f(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f9603e;

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
            this.f9603e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f9603e.f9595h == null) {
                return;
            }
            this.f9603e.f9595h.g();
        }
    }

    /* loaded from: classes5.dex */
    public class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f9604e;

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
            this.f9604e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f9604e.f9595h != null) {
                    this.f9604e.n.removeView(this.f9604e.f9595h.f());
                }
                this.f9604e.f9595h = null;
                this.f9604e.f9591d = null;
                this.f9604e.f9594g = null;
                if (this.f9604e.l != null) {
                    this.f9604e.l.i();
                    this.f9604e.l = null;
                }
            }
        }
    }

    public b(String str, String str2, c.a.p0.h.i.i.f fVar, c.a.p0.h.i.m.g gVar) {
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
        this.f9592e = null;
        this.m = new TreeMap();
        Context appContext = AppRuntime.getAppContext();
        this.a = appContext;
        this.f9590c = str;
        this.f9589b = str2;
        this.f9591d = fVar;
        this.n = gVar;
        this.f9593f = new c.a.p0.h.i.p.c(appContext);
        this.f9598k = false;
        E(10, 10, 350, 50);
        D();
    }

    public final void A(View view) {
        AdElementInfo adElementInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || !this.f9598k || (adElementInfo = this.f9594g) == null || this.f9592e == null || view == null) {
            return;
        }
        c.a.p0.h.i.r.d.d(adElementInfo, this.f9593f);
        c.a.p0.h.i.r.a aVar = new c.a.p0.h.i.r.a();
        aVar.a = String.valueOf(this.f9592e.f9606c);
        aVar.f9751b = String.valueOf(this.f9592e.f9607d);
        aVar.f9752c = String.valueOf(this.f9592e.f9606c);
        aVar.f9753d = String.valueOf(this.f9592e.f9607d);
        aVar.f9754e = String.valueOf((int) view.getX());
        aVar.f9755f = String.valueOf((int) view.getY());
        aVar.f9756g = String.valueOf((int) view.getX());
        aVar.f9757h = String.valueOf((int) view.getY());
        if (this.f9594g.getActionType() == 2) {
            c.a.p0.h.i.r.d.a(aVar, this.f9594g, this.f9593f, new f(this));
            return;
        }
        AdElementInfo adElementInfo2 = this.f9594g;
        if (adElementInfo2 != null) {
            this.n.a(c.a.p0.h.i.r.d.c(adElementInfo2.getClickUrl(), aVar), new JSONObject());
        }
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            c.a.p0.h.i.s.d.c(new g(this));
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c.a.p0.h.i.i.d dVar = new c.a.p0.h.i.i.d(this.a, this.f9594g, this.f9589b, this.f9598k);
            this.f9595h = dVar;
            dVar.i(this);
            if (this.f9598k) {
                this.f9595h.k(new C0599b(this));
            } else {
                this.f9595h.j(new c(this));
            }
            this.f9595h.e(this.f9592e.f9606c);
            if (this.n.c(this.f9595h.f())) {
                this.n.removeView(this.f9595h.f());
            }
            if (this.n.d(this.f9595h.f(), new c.a.p0.h.i.i.a(c.a.p0.h.i.s.h.a(this.f9592e.a), c.a.p0.h.i.s.h.a(this.f9592e.f9605b), c.a.p0.h.i.s.h.a(this.f9592e.f9608e), c.a.p0.h.i.s.h.a(this.f9592e.f9609f)))) {
                c.a.p0.h.i.i.f fVar = this.f9591d;
                if (fVar != null) {
                    fVar.a(true, "");
                    return;
                }
                return;
            }
            c.a.p0.h.i.i.f fVar2 = this.f9591d;
            if (fVar2 != null) {
                fVar2.onError("3010000");
            }
        }
    }

    public final void D() {
        c.a.p0.h.i.p.f eVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            c.a.p0.h.i.r.b.n("loadApi", this.m, this.f9593f);
            String appKey = c.a.p0.h.i.n.a.b().getAppKey();
            d.b bVar = new d.b();
            bVar.m(this.f9590c);
            bVar.j(this.f9589b);
            bVar.o(appKey);
            bVar.n("game");
            bVar.k(SpeedStatsUtils.UBC_VALUE_BANNER);
            bVar.l(this.f9592e.f9606c);
            bVar.i(this.f9592e.f9607d);
            c.a.p0.h.i.p.d h2 = bVar.h();
            if (this.f9598k) {
                eVar = new c.a.p0.h.i.p.g(this.a, h2, 1, z());
            } else {
                eVar = new c.a.p0.h.i.p.e(this.a, h2);
                this.f9597j = eVar.c();
            }
            c.a.p0.h.i.p.a aVar = new c.a.p0.h.i.p.a(this.a, false);
            aVar.k(this);
            aVar.i(eVar, this.f9593f);
        }
    }

    public void E(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048580, this, i2, i3, i4, i5) == null) {
            this.f9592e = new c.a.p0.h.i.i.c(i2, i3, i4, i5);
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
            c.a.p0.h.i.s.d.c(new e(this));
        }
    }

    public void H(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            c.a.p0.h.i.s.d.c(new d(this, str));
        }
    }

    @Override // c.a.p0.h.i.m.c
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            c.a.p0.h.i.i.f fVar = this.f9591d;
            if (fVar != null) {
                fVar.onError(str);
            }
            String appId = c.a.p0.h.i.n.a.b().getAppId();
            if (appId.lastIndexOf("_dev") >= 0 && appId.lastIndexOf("_dev") < appId.length() && str.equals("201000")) {
                w();
            }
            c.a.p0.h.i.i.f fVar2 = this.f9591d;
            if (fVar2 != null) {
                fVar2.a(false, "");
            }
        }
    }

    @Override // c.a.p0.h.i.i.d.e
    public void b() {
        c.a.p0.h.i.i.f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (fVar = this.f9591d) == null) {
            return;
        }
        fVar.onClose();
    }

    @Override // c.a.p0.h.i.m.c
    public void c(AdElementInfo adElementInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, adElementInfo) == null) {
            this.f9594g = adElementInfo;
            C();
        }
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            c.a.p0.h.i.i.d dVar = new c.a.p0.h.i.i.d(this.a);
            this.f9595h = dVar;
            dVar.e(this.f9592e.f9606c);
            if (this.f9595h.f() == null) {
                return;
            }
            if (this.n.c(this.f9595h.f())) {
                this.n.removeView(this.f9595h.f());
            }
            this.n.d(this.f9595h.f(), new c.a.p0.h.i.i.a(c.a.p0.h.i.s.h.a(this.f9592e.a), c.a.p0.h.i.s.h.a(this.f9592e.f9605b), c.a.p0.h.i.s.h.a(this.f9592e.f9608e), c.a.p0.h.i.s.h.a(this.f9592e.f9609f)));
            this.f9595h.f().postDelayed(new a(this), 20000L);
        }
    }

    public final void x() {
        c.a.p0.h.i.i.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (cVar = this.f9592e) == null) {
            return;
        }
        if (c.a.p0.h.i.s.h.a(cVar.f9606c) < 300) {
            this.f9592e.f9606c = c.a.p0.h.i.s.h.p(300.0f);
        }
        int q = c.a.p0.h.i.n.a.b().q();
        int p = c.a.p0.h.i.n.a.b().p();
        if (c.a.p0.h.i.s.h.a(this.f9592e.f9606c) > q) {
            this.f9592e.f9606c = c.a.p0.h.i.s.h.p(q);
        }
        c.a.p0.h.i.i.c cVar2 = this.f9592e;
        cVar2.f9607d = (int) (cVar2.f9606c / c.a.p0.h.i.i.e.a);
        if (cVar2.a < 0) {
            cVar2.a = 0;
        }
        int p2 = c.a.p0.h.i.s.h.p(q);
        c.a.p0.h.i.i.c cVar3 = this.f9592e;
        int i2 = p2 - cVar3.f9606c;
        if (cVar3.a > i2) {
            cVar3.a = i2;
        }
        c.a.p0.h.i.i.c cVar4 = this.f9592e;
        if (cVar4.f9605b < 0) {
            cVar4.f9605b = 0;
        }
        int p3 = c.a.p0.h.i.s.h.p(p);
        c.a.p0.h.i.i.c cVar5 = this.f9592e;
        int i3 = p3 - cVar5.f9607d;
        if (cVar5.f9605b > i3) {
            cVar5.f9605b = i3;
        }
        c.a.p0.h.i.i.c cVar6 = this.f9592e;
        cVar6.f9608e = cVar6.f9606c;
        cVar6.f9609f = cVar6.f9607d;
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            c.a.p0.h.i.s.d.c(new h(this));
        }
    }

    public final int z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (this.f9592e == null) {
                return 2;
            }
            int p = c.a.p0.h.i.s.h.p(c.a.p0.h.i.n.a.b().p());
            int i2 = this.f9592e.f9605b;
            int i3 = p / 3;
            if (i2 < i3) {
                return 1;
            }
            return i2 < i3 * 2 ? 4 : 2;
        }
        return invokeV.intValue;
    }
}
