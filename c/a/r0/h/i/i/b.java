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
    public String f10545b;

    /* renamed from: c  reason: collision with root package name */
    public String f10546c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.r0.h.i.i.f f10547d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.r0.h.i.i.c f10548e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.r0.h.i.p.c f10549f;

    /* renamed from: g  reason: collision with root package name */
    public AdElementInfo f10550g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.r0.h.i.i.d f10551h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f10552i;

    /* renamed from: j  reason: collision with root package name */
    public String f10553j;
    public boolean k;
    public c.a.r0.h.i.k.b l;
    public Map<String, String> m;
    public c.a.r0.h.i.m.g n;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f10554e;

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
            this.f10554e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f10554e.f10551h == null || this.f10554e.f10551h.f() == null || !this.f10554e.n.c(this.f10554e.f10551h.f())) {
                return;
            }
            this.f10554e.n.removeView(this.f10554e.f10551h.f());
        }
    }

    /* renamed from: c.a.r0.h.i.i.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C0701b implements c.a.r0.h.i.m.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public C0701b(b bVar) {
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
                if (this.a.f10547d != null) {
                    this.a.f10547d.onClick();
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
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, commandType, uri) == null) || this.a.f10550g == null) {
                return;
            }
            String clickUrl = this.a.f10550g.getClickUrl();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("monitorUrl", c.a.r0.h.i.r.b.b("landingPageLoad", this.a.m));
            } catch (JSONException unused) {
            }
            this.a.n.a(clickUrl, jSONObject);
            c.a.r0.h.i.r.b.g(this.a.f10550g, this.a.f10549f);
            c.a.r0.h.i.r.b.n("lpClick", this.a.m, this.a.f10549f);
            c.a.r0.h.i.r.b.n("click", this.a.m, this.a.f10549f);
        }
    }

    /* loaded from: classes6.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f10555e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f10556f;

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
            this.f10556f = bVar;
            this.f10555e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.r0.h.i.i.c cVar = this.f10556f.f10548e;
                boolean z = cVar.f10561c != cVar.f10563e;
                this.f10556f.x();
                if (this.f10556f.f10551h != null) {
                    this.f10556f.f10551h.e(this.f10556f.f10548e.f10561c);
                    this.f10556f.n.f(this.f10556f.f10551h.f(), new c.a.r0.h.i.i.a(c.a.r0.h.i.s.h.a(this.f10556f.f10548e.a), c.a.r0.h.i.s.h.a(this.f10556f.f10548e.f10560b), c.a.r0.h.i.s.h.a(this.f10556f.f10548e.f10563e), c.a.r0.h.i.s.h.a(this.f10556f.f10548e.f10564f)));
                }
                if (this.f10555e.equals("width") && z && this.f10556f.f10547d != null) {
                    c.a.r0.h.i.i.f fVar = this.f10556f.f10547d;
                    c.a.r0.h.i.i.c cVar2 = this.f10556f.f10548e;
                    fVar.c(cVar2.f10563e, cVar2.f10564f);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f10557e;

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
            this.f10557e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f10557e.f10551h == null || !this.f10557e.n.c(this.f10557e.f10551h.f())) {
                    if (this.f10557e.f10547d != null) {
                        this.f10557e.f10547d.b(false);
                        this.f10557e.f10547d.onError("3010010");
                        return;
                    }
                    return;
                }
                this.f10557e.f10551h.l();
                if (this.f10557e.f10547d != null) {
                    this.f10557e.f10547d.b(true);
                }
                c.a.r0.h.i.r.b.n("showSuccess", this.f10557e.m, this.f10557e.f10549f);
                if (this.f10557e.f10552i) {
                    return;
                }
                this.f10557e.f10552i = true;
                if (this.f10557e.k) {
                    c.a.r0.h.i.r.d.f(this.f10557e.f10550g, this.f10557e.f10549f);
                    return;
                }
                c.a.r0.h.i.r.b.j(this.f10557e.f10550g, this.f10557e.f10549f);
                String str = this.f10557e.f10546c;
                b bVar = this.f10557e;
                c.a.r0.h.i.r.b.f(str, bVar.f10545b, bVar.f10553j, this.f10557e.f10549f);
                c.a.r0.h.i.r.b.n("show", this.f10557e.m, this.f10557e.f10549f);
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
                    this.a.l = new c.a.r0.h.i.k.b(this.a.a, this.a.f10550g, this.a.f10549f);
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
        public final /* synthetic */ b f10558e;

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
            this.f10558e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f10558e.f10551h == null) {
                return;
            }
            this.f10558e.f10551h.g();
        }
    }

    /* loaded from: classes6.dex */
    public class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f10559e;

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
            this.f10559e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f10559e.f10551h != null) {
                    this.f10559e.n.removeView(this.f10559e.f10551h.f());
                }
                this.f10559e.f10551h = null;
                this.f10559e.f10547d = null;
                this.f10559e.f10550g = null;
                if (this.f10559e.l != null) {
                    this.f10559e.l.i();
                    this.f10559e.l = null;
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
        this.f10548e = null;
        this.m = new TreeMap();
        Context appContext = AppRuntime.getAppContext();
        this.a = appContext;
        this.f10546c = str;
        this.f10545b = str2;
        this.f10547d = fVar;
        this.n = gVar;
        this.f10549f = new c.a.r0.h.i.p.c(appContext);
        this.k = false;
        E(10, 10, 350, 50);
        D();
    }

    public final void A(View view) {
        AdElementInfo adElementInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || !this.k || (adElementInfo = this.f10550g) == null || this.f10548e == null || view == null) {
            return;
        }
        c.a.r0.h.i.r.d.d(adElementInfo, this.f10549f);
        c.a.r0.h.i.r.a aVar = new c.a.r0.h.i.r.a();
        aVar.a = String.valueOf(this.f10548e.f10561c);
        aVar.f10700b = String.valueOf(this.f10548e.f10562d);
        aVar.f10701c = String.valueOf(this.f10548e.f10561c);
        aVar.f10702d = String.valueOf(this.f10548e.f10562d);
        aVar.f10703e = String.valueOf((int) view.getX());
        aVar.f10704f = String.valueOf((int) view.getY());
        aVar.f10705g = String.valueOf((int) view.getX());
        aVar.f10706h = String.valueOf((int) view.getY());
        if (this.f10550g.getActionType() == 2) {
            c.a.r0.h.i.r.d.a(aVar, this.f10550g, this.f10549f, new f(this));
            return;
        }
        AdElementInfo adElementInfo2 = this.f10550g;
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
            c.a.r0.h.i.i.d dVar = new c.a.r0.h.i.i.d(this.a, this.f10550g, this.f10545b, this.k);
            this.f10551h = dVar;
            dVar.i(this);
            if (this.k) {
                this.f10551h.k(new C0701b(this));
            } else {
                this.f10551h.j(new c(this));
            }
            this.f10551h.e(this.f10548e.f10561c);
            if (this.n.c(this.f10551h.f())) {
                this.n.removeView(this.f10551h.f());
            }
            if (this.n.d(this.f10551h.f(), new c.a.r0.h.i.i.a(c.a.r0.h.i.s.h.a(this.f10548e.a), c.a.r0.h.i.s.h.a(this.f10548e.f10560b), c.a.r0.h.i.s.h.a(this.f10548e.f10563e), c.a.r0.h.i.s.h.a(this.f10548e.f10564f)))) {
                c.a.r0.h.i.i.f fVar = this.f10547d;
                if (fVar != null) {
                    fVar.a(true, "");
                    return;
                }
                return;
            }
            c.a.r0.h.i.i.f fVar2 = this.f10547d;
            if (fVar2 != null) {
                fVar2.onError("3010000");
            }
        }
    }

    public final void D() {
        c.a.r0.h.i.p.f eVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            c.a.r0.h.i.r.b.n("loadApi", this.m, this.f10549f);
            String appKey = c.a.r0.h.i.n.a.b().getAppKey();
            d.b bVar = new d.b();
            bVar.m(this.f10546c);
            bVar.j(this.f10545b);
            bVar.o(appKey);
            bVar.n("game");
            bVar.k(SpeedStatsUtils.UBC_VALUE_BANNER);
            bVar.l(this.f10548e.f10561c);
            bVar.i(this.f10548e.f10562d);
            c.a.r0.h.i.p.d h2 = bVar.h();
            if (this.k) {
                eVar = new c.a.r0.h.i.p.g(this.a, h2, 1, z());
            } else {
                eVar = new c.a.r0.h.i.p.e(this.a, h2);
                this.f10553j = eVar.c();
            }
            c.a.r0.h.i.p.a aVar = new c.a.r0.h.i.p.a(this.a, false);
            aVar.k(this);
            aVar.i(eVar, this.f10549f);
        }
    }

    public void E(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048580, this, i2, i3, i4, i5) == null) {
            this.f10548e = new c.a.r0.h.i.i.c(i2, i3, i4, i5);
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
            c.a.r0.h.i.i.f fVar = this.f10547d;
            if (fVar != null) {
                fVar.onError(str);
            }
            String appId = c.a.r0.h.i.n.a.b().getAppId();
            if (appId.lastIndexOf("_dev") >= 0 && appId.lastIndexOf("_dev") < appId.length() && str.equals("201000")) {
                w();
            }
            c.a.r0.h.i.i.f fVar2 = this.f10547d;
            if (fVar2 != null) {
                fVar2.a(false, "");
            }
        }
    }

    @Override // c.a.r0.h.i.i.d.e
    public void b() {
        c.a.r0.h.i.i.f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (fVar = this.f10547d) == null) {
            return;
        }
        fVar.onClose();
    }

    @Override // c.a.r0.h.i.m.c
    public void c(AdElementInfo adElementInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, adElementInfo) == null) {
            this.f10550g = adElementInfo;
            C();
        }
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            c.a.r0.h.i.i.d dVar = new c.a.r0.h.i.i.d(this.a);
            this.f10551h = dVar;
            dVar.e(this.f10548e.f10561c);
            if (this.f10551h.f() == null) {
                return;
            }
            if (this.n.c(this.f10551h.f())) {
                this.n.removeView(this.f10551h.f());
            }
            this.n.d(this.f10551h.f(), new c.a.r0.h.i.i.a(c.a.r0.h.i.s.h.a(this.f10548e.a), c.a.r0.h.i.s.h.a(this.f10548e.f10560b), c.a.r0.h.i.s.h.a(this.f10548e.f10563e), c.a.r0.h.i.s.h.a(this.f10548e.f10564f)));
            this.f10551h.f().postDelayed(new a(this), 20000L);
        }
    }

    public final void x() {
        c.a.r0.h.i.i.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (cVar = this.f10548e) == null) {
            return;
        }
        if (c.a.r0.h.i.s.h.a(cVar.f10561c) < 300) {
            this.f10548e.f10561c = c.a.r0.h.i.s.h.p(300.0f);
        }
        int q = c.a.r0.h.i.n.a.b().q();
        int p = c.a.r0.h.i.n.a.b().p();
        if (c.a.r0.h.i.s.h.a(this.f10548e.f10561c) > q) {
            this.f10548e.f10561c = c.a.r0.h.i.s.h.p(q);
        }
        c.a.r0.h.i.i.c cVar2 = this.f10548e;
        cVar2.f10562d = (int) (cVar2.f10561c / c.a.r0.h.i.i.e.a);
        if (cVar2.a < 0) {
            cVar2.a = 0;
        }
        int p2 = c.a.r0.h.i.s.h.p(q);
        c.a.r0.h.i.i.c cVar3 = this.f10548e;
        int i2 = p2 - cVar3.f10561c;
        if (cVar3.a > i2) {
            cVar3.a = i2;
        }
        c.a.r0.h.i.i.c cVar4 = this.f10548e;
        if (cVar4.f10560b < 0) {
            cVar4.f10560b = 0;
        }
        int p3 = c.a.r0.h.i.s.h.p(p);
        c.a.r0.h.i.i.c cVar5 = this.f10548e;
        int i3 = p3 - cVar5.f10562d;
        if (cVar5.f10560b > i3) {
            cVar5.f10560b = i3;
        }
        c.a.r0.h.i.i.c cVar6 = this.f10548e;
        cVar6.f10563e = cVar6.f10561c;
        cVar6.f10564f = cVar6.f10562d;
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
            if (this.f10548e == null) {
                return 2;
            }
            int p = c.a.r0.h.i.s.h.p(c.a.r0.h.i.n.a.b().p());
            int i2 = this.f10548e.f10560b;
            int i3 = p / 3;
            if (i2 < i3) {
                return 1;
            }
            return i2 < i3 * 2 ? 4 : 2;
        }
        return invokeV.intValue;
    }
}
