package c.a.n0.h.a.a;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.h.a.a.d;
import c.a.n0.h.a.h.d;
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
/* loaded from: classes.dex */
public class b implements c.a.n0.h.a.e.c, d.e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public String f8263b;

    /* renamed from: c  reason: collision with root package name */
    public String f8264c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.n0.h.a.a.f f8265d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.n0.h.a.a.c f8266e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.n0.h.a.h.c f8267f;

    /* renamed from: g  reason: collision with root package name */
    public AdElementInfo f8268g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.n0.h.a.a.d f8269h;
    public boolean i;
    public String j;
    public boolean k;
    public c.a.n0.h.a.c.b l;
    public Map<String, String> m;
    public c.a.n0.h.a.e.g n;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.f8269h == null || this.a.f8269h.f() == null || !this.a.n.c(this.a.f8269h.f())) {
                return;
            }
            this.a.n.removeView(this.a.f8269h.f());
        }
    }

    /* renamed from: c.a.n0.h.a.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0649b implements c.a.n0.h.a.e.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public C0649b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // c.a.n0.h.a.e.e
        public void d(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) {
            }
        }

        @Override // c.a.n0.h.a.e.e
        public void f(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) && this.a.k) {
                this.a.A(view);
                if (this.a.f8265d != null) {
                    this.a.f8265d.onClick();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements c.a.n0.h.a.e.a {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // c.a.n0.h.a.e.a
        public void b(CommandType commandType, Uri uri) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, commandType, uri) == null) || this.a.f8268g == null) {
                return;
            }
            String clickUrl = this.a.f8268g.getClickUrl();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("monitorUrl", c.a.n0.h.a.j.b.b("landingPageLoad", this.a.m));
            } catch (JSONException unused) {
            }
            this.a.n.a(clickUrl, jSONObject);
            c.a.n0.h.a.j.b.g(this.a.f8268g, this.a.f8267f);
            c.a.n0.h.a.j.b.n("lpClick", this.a.m, this.a.f8267f);
            c.a.n0.h.a.j.b.n("click", this.a.m, this.a.f8267f);
        }
    }

    /* loaded from: classes.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f8270b;

        public d(b bVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8270b = bVar;
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.n0.h.a.a.c cVar = this.f8270b.f8266e;
                boolean z = cVar.f8272c != cVar.f8274e;
                this.f8270b.x();
                if (this.f8270b.f8269h != null) {
                    this.f8270b.f8269h.e(this.f8270b.f8266e.f8272c);
                    this.f8270b.n.f(this.f8270b.f8269h.f(), new c.a.n0.h.a.a.a(c.a.n0.h.a.k.h.a(this.f8270b.f8266e.a), c.a.n0.h.a.k.h.a(this.f8270b.f8266e.f8271b), c.a.n0.h.a.k.h.a(this.f8270b.f8266e.f8274e), c.a.n0.h.a.k.h.a(this.f8270b.f8266e.f8275f)));
                }
                if (this.a.equals("width") && z && this.f8270b.f8265d != null) {
                    c.a.n0.h.a.a.f fVar = this.f8270b.f8265d;
                    c.a.n0.h.a.a.c cVar2 = this.f8270b.f8266e;
                    fVar.c(cVar2.f8274e, cVar2.f8275f);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public e(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.f8269h == null || !this.a.n.c(this.a.f8269h.f())) {
                    if (this.a.f8265d != null) {
                        this.a.f8265d.b(false);
                        this.a.f8265d.onError("3010010");
                        return;
                    }
                    return;
                }
                this.a.f8269h.l();
                if (this.a.f8265d != null) {
                    this.a.f8265d.b(true);
                }
                c.a.n0.h.a.j.b.n("showSuccess", this.a.m, this.a.f8267f);
                if (this.a.i) {
                    return;
                }
                this.a.i = true;
                if (this.a.k) {
                    c.a.n0.h.a.j.d.f(this.a.f8268g, this.a.f8267f);
                    return;
                }
                c.a.n0.h.a.j.b.j(this.a.f8268g, this.a.f8267f);
                String str = this.a.f8264c;
                b bVar = this.a;
                c.a.n0.h.a.j.b.f(str, bVar.f8263b, bVar.j, this.a.f8267f);
                c.a.n0.h.a.j.b.n("show", this.a.m, this.a.f8267f);
            }
        }
    }

    /* loaded from: classes.dex */
    public class f implements c.a.n0.h.a.e.e {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // c.a.n0.h.a.e.e
        public void d(String str, String str2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) || TextUtils.isEmpty(str2)) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("url", str2);
                if (this.a.l == null) {
                    this.a.l = new c.a.n0.h.a.c.b(this.a.a, this.a.f8268g, this.a.f8267f);
                }
                this.a.l.k(str);
                c.a.n0.h.a.f.a.b().d(this.a.a, jSONObject, DownloadParams.SwanAppDownloadType.TYPE_START_DOWNLOAD, this.a.l);
            } catch (JSONException unused) {
            }
        }

        @Override // c.a.n0.h.a.e.e
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
        public final /* synthetic */ b a;

        public g(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.f8269h == null) {
                return;
            }
            this.a.f8269h.g();
        }
    }

    /* loaded from: classes.dex */
    public class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public h(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.f8269h != null) {
                    this.a.n.removeView(this.a.f8269h.f());
                }
                this.a.f8269h = null;
                this.a.f8265d = null;
                this.a.f8268g = null;
                if (this.a.l != null) {
                    this.a.l.i();
                    this.a.l = null;
                }
            }
        }
    }

    public b(String str, String str2, c.a.n0.h.a.a.f fVar, c.a.n0.h.a.e.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, fVar, gVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f8266e = null;
        this.m = new TreeMap();
        Context appContext = AppRuntime.getAppContext();
        this.a = appContext;
        this.f8264c = str;
        this.f8263b = str2;
        this.f8265d = fVar;
        this.n = gVar;
        this.f8267f = new c.a.n0.h.a.h.c(appContext);
        this.k = false;
        E(10, 10, 350, 50);
        D();
    }

    public final void A(View view) {
        AdElementInfo adElementInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || !this.k || (adElementInfo = this.f8268g) == null || this.f8266e == null || view == null) {
            return;
        }
        c.a.n0.h.a.j.d.d(adElementInfo, this.f8267f);
        c.a.n0.h.a.j.a aVar = new c.a.n0.h.a.j.a();
        aVar.a = String.valueOf(this.f8266e.f8272c);
        aVar.f8394b = String.valueOf(this.f8266e.f8273d);
        aVar.f8395c = String.valueOf(this.f8266e.f8272c);
        aVar.f8396d = String.valueOf(this.f8266e.f8273d);
        aVar.f8397e = String.valueOf((int) view.getX());
        aVar.f8398f = String.valueOf((int) view.getY());
        aVar.f8399g = String.valueOf((int) view.getX());
        aVar.f8400h = String.valueOf((int) view.getY());
        if (this.f8268g.getActionType() == 2) {
            c.a.n0.h.a.j.d.a(aVar, this.f8268g, this.f8267f, new f(this));
            return;
        }
        AdElementInfo adElementInfo2 = this.f8268g;
        if (adElementInfo2 != null) {
            this.n.a(c.a.n0.h.a.j.d.c(adElementInfo2.getClickUrl(), aVar), new JSONObject());
        }
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            c.a.n0.h.a.k.d.c(new g(this));
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c.a.n0.h.a.a.d dVar = new c.a.n0.h.a.a.d(this.a, this.f8268g, this.f8263b, this.k);
            this.f8269h = dVar;
            dVar.i(this);
            if (this.k) {
                this.f8269h.k(new C0649b(this));
            } else {
                this.f8269h.j(new c(this));
            }
            this.f8269h.e(this.f8266e.f8272c);
            if (this.n.c(this.f8269h.f())) {
                this.n.removeView(this.f8269h.f());
            }
            if (this.n.d(this.f8269h.f(), new c.a.n0.h.a.a.a(c.a.n0.h.a.k.h.a(this.f8266e.a), c.a.n0.h.a.k.h.a(this.f8266e.f8271b), c.a.n0.h.a.k.h.a(this.f8266e.f8274e), c.a.n0.h.a.k.h.a(this.f8266e.f8275f)))) {
                c.a.n0.h.a.a.f fVar = this.f8265d;
                if (fVar != null) {
                    fVar.a(true, "");
                    return;
                }
                return;
            }
            c.a.n0.h.a.a.f fVar2 = this.f8265d;
            if (fVar2 != null) {
                fVar2.onError("3010000");
            }
        }
    }

    public final void D() {
        c.a.n0.h.a.h.f eVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            c.a.n0.h.a.j.b.n("loadApi", this.m, this.f8267f);
            String appKey = c.a.n0.h.a.f.a.b().getAppKey();
            d.b bVar = new d.b();
            bVar.m(this.f8264c);
            bVar.j(this.f8263b);
            bVar.o(appKey);
            bVar.n("game");
            bVar.k(SpeedStatsUtils.UBC_VALUE_BANNER);
            bVar.l(this.f8266e.f8272c);
            bVar.i(this.f8266e.f8273d);
            c.a.n0.h.a.h.d h2 = bVar.h();
            if (this.k) {
                eVar = new c.a.n0.h.a.h.g(this.a, h2, 1, z());
            } else {
                eVar = new c.a.n0.h.a.h.e(this.a, h2);
                this.j = eVar.c();
            }
            c.a.n0.h.a.h.a aVar = new c.a.n0.h.a.h.a(this.a, false);
            aVar.k(this);
            aVar.i(eVar, this.f8267f);
        }
    }

    public void E(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048580, this, i, i2, i3, i4) == null) {
            this.f8266e = new c.a.n0.h.a.a.c(i, i2, i3, i4);
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
            c.a.n0.h.a.k.d.c(new e(this));
        }
    }

    public void H(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            c.a.n0.h.a.k.d.c(new d(this, str));
        }
    }

    @Override // c.a.n0.h.a.e.c
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            c.a.n0.h.a.a.f fVar = this.f8265d;
            if (fVar != null) {
                fVar.onError(str);
            }
            String appId = c.a.n0.h.a.f.a.b().getAppId();
            if (appId.lastIndexOf("_dev") >= 0 && appId.lastIndexOf("_dev") < appId.length() && str.equals("201000")) {
                w();
            }
            c.a.n0.h.a.a.f fVar2 = this.f8265d;
            if (fVar2 != null) {
                fVar2.a(false, "");
            }
        }
    }

    @Override // c.a.n0.h.a.a.d.e
    public void b() {
        c.a.n0.h.a.a.f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (fVar = this.f8265d) == null) {
            return;
        }
        fVar.onClose();
    }

    @Override // c.a.n0.h.a.e.c
    public void c(AdElementInfo adElementInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, adElementInfo) == null) {
            this.f8268g = adElementInfo;
            C();
        }
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            c.a.n0.h.a.a.d dVar = new c.a.n0.h.a.a.d(this.a);
            this.f8269h = dVar;
            dVar.e(this.f8266e.f8272c);
            if (this.f8269h.f() == null) {
                return;
            }
            if (this.n.c(this.f8269h.f())) {
                this.n.removeView(this.f8269h.f());
            }
            this.n.d(this.f8269h.f(), new c.a.n0.h.a.a.a(c.a.n0.h.a.k.h.a(this.f8266e.a), c.a.n0.h.a.k.h.a(this.f8266e.f8271b), c.a.n0.h.a.k.h.a(this.f8266e.f8274e), c.a.n0.h.a.k.h.a(this.f8266e.f8275f)));
            this.f8269h.f().postDelayed(new a(this), 20000L);
        }
    }

    public final void x() {
        c.a.n0.h.a.a.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (cVar = this.f8266e) == null) {
            return;
        }
        if (c.a.n0.h.a.k.h.a(cVar.f8272c) < 300) {
            this.f8266e.f8272c = c.a.n0.h.a.k.h.p(300.0f);
        }
        int q = c.a.n0.h.a.f.a.b().q();
        int p = c.a.n0.h.a.f.a.b().p();
        if (c.a.n0.h.a.k.h.a(this.f8266e.f8272c) > q) {
            this.f8266e.f8272c = c.a.n0.h.a.k.h.p(q);
        }
        c.a.n0.h.a.a.c cVar2 = this.f8266e;
        cVar2.f8273d = (int) (cVar2.f8272c / c.a.n0.h.a.a.e.a);
        if (cVar2.a < 0) {
            cVar2.a = 0;
        }
        int p2 = c.a.n0.h.a.k.h.p(q);
        c.a.n0.h.a.a.c cVar3 = this.f8266e;
        int i = p2 - cVar3.f8272c;
        if (cVar3.a > i) {
            cVar3.a = i;
        }
        c.a.n0.h.a.a.c cVar4 = this.f8266e;
        if (cVar4.f8271b < 0) {
            cVar4.f8271b = 0;
        }
        int p3 = c.a.n0.h.a.k.h.p(p);
        c.a.n0.h.a.a.c cVar5 = this.f8266e;
        int i2 = p3 - cVar5.f8273d;
        if (cVar5.f8271b > i2) {
            cVar5.f8271b = i2;
        }
        c.a.n0.h.a.a.c cVar6 = this.f8266e;
        cVar6.f8274e = cVar6.f8272c;
        cVar6.f8275f = cVar6.f8273d;
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            c.a.n0.h.a.k.d.c(new h(this));
        }
    }

    public final int z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (this.f8266e == null) {
                return 2;
            }
            int p = c.a.n0.h.a.k.h.p(c.a.n0.h.a.f.a.b().p());
            int i = this.f8266e.f8271b;
            int i2 = p / 3;
            if (i < i2) {
                return 1;
            }
            return i < i2 * 2 ? 4 : 2;
        }
        return invokeV.intValue;
    }
}
