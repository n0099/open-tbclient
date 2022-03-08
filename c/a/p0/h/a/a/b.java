package c.a.p0.h.a.a;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.h.a.a.d;
import c.a.p0.h.a.h.d;
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
/* loaded from: classes2.dex */
public class b implements c.a.p0.h.a.e.c, d.e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public String f9870b;

    /* renamed from: c  reason: collision with root package name */
    public String f9871c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.p0.h.a.a.f f9872d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.p0.h.a.a.c f9873e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.p0.h.a.h.c f9874f;

    /* renamed from: g  reason: collision with root package name */
    public AdElementInfo f9875g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.p0.h.a.a.d f9876h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f9877i;

    /* renamed from: j  reason: collision with root package name */
    public String f9878j;
    public boolean k;
    public c.a.p0.h.a.c.b l;
    public Map<String, String> m;
    public c.a.p0.h.a.e.g n;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f9879e;

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
            this.f9879e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f9879e.f9876h == null || this.f9879e.f9876h.f() == null || !this.f9879e.n.c(this.f9879e.f9876h.f())) {
                return;
            }
            this.f9879e.n.removeView(this.f9879e.f9876h.f());
        }
    }

    /* renamed from: c.a.p0.h.a.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0657b implements c.a.p0.h.a.e.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public C0657b(b bVar) {
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

        @Override // c.a.p0.h.a.e.e
        public void d(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) {
            }
        }

        @Override // c.a.p0.h.a.e.e
        public void f(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) && this.a.k) {
                this.a.A(view);
                if (this.a.f9872d != null) {
                    this.a.f9872d.onClick();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements c.a.p0.h.a.e.a {
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

        @Override // c.a.p0.h.a.e.a
        public void b(CommandType commandType, Uri uri) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, commandType, uri) == null) || this.a.f9875g == null) {
                return;
            }
            String clickUrl = this.a.f9875g.getClickUrl();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("monitorUrl", c.a.p0.h.a.j.b.b("landingPageLoad", this.a.m));
            } catch (JSONException unused) {
            }
            this.a.n.a(clickUrl, jSONObject);
            c.a.p0.h.a.j.b.g(this.a.f9875g, this.a.f9874f);
            c.a.p0.h.a.j.b.n("lpClick", this.a.m, this.a.f9874f);
            c.a.p0.h.a.j.b.n("click", this.a.m, this.a.f9874f);
        }
    }

    /* loaded from: classes.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f9880e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f9881f;

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
            this.f9881f = bVar;
            this.f9880e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.p0.h.a.a.c cVar = this.f9881f.f9873e;
                boolean z = cVar.f9886c != cVar.f9888e;
                this.f9881f.x();
                if (this.f9881f.f9876h != null) {
                    this.f9881f.f9876h.e(this.f9881f.f9873e.f9886c);
                    this.f9881f.n.f(this.f9881f.f9876h.f(), new c.a.p0.h.a.a.a(c.a.p0.h.a.k.h.a(this.f9881f.f9873e.a), c.a.p0.h.a.k.h.a(this.f9881f.f9873e.f9885b), c.a.p0.h.a.k.h.a(this.f9881f.f9873e.f9888e), c.a.p0.h.a.k.h.a(this.f9881f.f9873e.f9889f)));
                }
                if (this.f9880e.equals("width") && z && this.f9881f.f9872d != null) {
                    c.a.p0.h.a.a.f fVar = this.f9881f.f9872d;
                    c.a.p0.h.a.a.c cVar2 = this.f9881f.f9873e;
                    fVar.c(cVar2.f9888e, cVar2.f9889f);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f9882e;

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
            this.f9882e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f9882e.f9876h == null || !this.f9882e.n.c(this.f9882e.f9876h.f())) {
                    if (this.f9882e.f9872d != null) {
                        this.f9882e.f9872d.b(false);
                        this.f9882e.f9872d.onError("3010010");
                        return;
                    }
                    return;
                }
                this.f9882e.f9876h.l();
                if (this.f9882e.f9872d != null) {
                    this.f9882e.f9872d.b(true);
                }
                c.a.p0.h.a.j.b.n("showSuccess", this.f9882e.m, this.f9882e.f9874f);
                if (this.f9882e.f9877i) {
                    return;
                }
                this.f9882e.f9877i = true;
                if (this.f9882e.k) {
                    c.a.p0.h.a.j.d.f(this.f9882e.f9875g, this.f9882e.f9874f);
                    return;
                }
                c.a.p0.h.a.j.b.j(this.f9882e.f9875g, this.f9882e.f9874f);
                String str = this.f9882e.f9871c;
                b bVar = this.f9882e;
                c.a.p0.h.a.j.b.f(str, bVar.f9870b, bVar.f9878j, this.f9882e.f9874f);
                c.a.p0.h.a.j.b.n("show", this.f9882e.m, this.f9882e.f9874f);
            }
        }
    }

    /* loaded from: classes.dex */
    public class f implements c.a.p0.h.a.e.e {
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

        @Override // c.a.p0.h.a.e.e
        public void d(String str, String str2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) || TextUtils.isEmpty(str2)) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("url", str2);
                if (this.a.l == null) {
                    this.a.l = new c.a.p0.h.a.c.b(this.a.a, this.a.f9875g, this.a.f9874f);
                }
                this.a.l.k(str);
                c.a.p0.h.a.f.a.b().d(this.a.a, jSONObject, DownloadParams.SwanAppDownloadType.TYPE_START_DOWNLOAD, this.a.l);
            } catch (JSONException unused) {
            }
        }

        @Override // c.a.p0.h.a.e.e
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
        public final /* synthetic */ b f9883e;

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
            this.f9883e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f9883e.f9876h == null) {
                return;
            }
            this.f9883e.f9876h.g();
        }
    }

    /* loaded from: classes.dex */
    public class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f9884e;

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
            this.f9884e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f9884e.f9876h != null) {
                    this.f9884e.n.removeView(this.f9884e.f9876h.f());
                }
                this.f9884e.f9876h = null;
                this.f9884e.f9872d = null;
                this.f9884e.f9875g = null;
                if (this.f9884e.l != null) {
                    this.f9884e.l.i();
                    this.f9884e.l = null;
                }
            }
        }
    }

    public b(String str, String str2, c.a.p0.h.a.a.f fVar, c.a.p0.h.a.e.g gVar) {
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
        this.f9873e = null;
        this.m = new TreeMap();
        Context appContext = AppRuntime.getAppContext();
        this.a = appContext;
        this.f9871c = str;
        this.f9870b = str2;
        this.f9872d = fVar;
        this.n = gVar;
        this.f9874f = new c.a.p0.h.a.h.c(appContext);
        this.k = false;
        E(10, 10, 350, 50);
        D();
    }

    public final void A(View view) {
        AdElementInfo adElementInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || !this.k || (adElementInfo = this.f9875g) == null || this.f9873e == null || view == null) {
            return;
        }
        c.a.p0.h.a.j.d.d(adElementInfo, this.f9874f);
        c.a.p0.h.a.j.a aVar = new c.a.p0.h.a.j.a();
        aVar.a = String.valueOf(this.f9873e.f9886c);
        aVar.f10025b = String.valueOf(this.f9873e.f9887d);
        aVar.f10026c = String.valueOf(this.f9873e.f9886c);
        aVar.f10027d = String.valueOf(this.f9873e.f9887d);
        aVar.f10028e = String.valueOf((int) view.getX());
        aVar.f10029f = String.valueOf((int) view.getY());
        aVar.f10030g = String.valueOf((int) view.getX());
        aVar.f10031h = String.valueOf((int) view.getY());
        if (this.f9875g.getActionType() == 2) {
            c.a.p0.h.a.j.d.a(aVar, this.f9875g, this.f9874f, new f(this));
            return;
        }
        AdElementInfo adElementInfo2 = this.f9875g;
        if (adElementInfo2 != null) {
            this.n.a(c.a.p0.h.a.j.d.c(adElementInfo2.getClickUrl(), aVar), new JSONObject());
        }
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            c.a.p0.h.a.k.d.c(new g(this));
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c.a.p0.h.a.a.d dVar = new c.a.p0.h.a.a.d(this.a, this.f9875g, this.f9870b, this.k);
            this.f9876h = dVar;
            dVar.i(this);
            if (this.k) {
                this.f9876h.k(new C0657b(this));
            } else {
                this.f9876h.j(new c(this));
            }
            this.f9876h.e(this.f9873e.f9886c);
            if (this.n.c(this.f9876h.f())) {
                this.n.removeView(this.f9876h.f());
            }
            if (this.n.d(this.f9876h.f(), new c.a.p0.h.a.a.a(c.a.p0.h.a.k.h.a(this.f9873e.a), c.a.p0.h.a.k.h.a(this.f9873e.f9885b), c.a.p0.h.a.k.h.a(this.f9873e.f9888e), c.a.p0.h.a.k.h.a(this.f9873e.f9889f)))) {
                c.a.p0.h.a.a.f fVar = this.f9872d;
                if (fVar != null) {
                    fVar.a(true, "");
                    return;
                }
                return;
            }
            c.a.p0.h.a.a.f fVar2 = this.f9872d;
            if (fVar2 != null) {
                fVar2.onError("3010000");
            }
        }
    }

    public final void D() {
        c.a.p0.h.a.h.f eVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            c.a.p0.h.a.j.b.n("loadApi", this.m, this.f9874f);
            String appKey = c.a.p0.h.a.f.a.b().getAppKey();
            d.b bVar = new d.b();
            bVar.m(this.f9871c);
            bVar.j(this.f9870b);
            bVar.o(appKey);
            bVar.n("game");
            bVar.k(SpeedStatsUtils.UBC_VALUE_BANNER);
            bVar.l(this.f9873e.f9886c);
            bVar.i(this.f9873e.f9887d);
            c.a.p0.h.a.h.d h2 = bVar.h();
            if (this.k) {
                eVar = new c.a.p0.h.a.h.g(this.a, h2, 1, z());
            } else {
                eVar = new c.a.p0.h.a.h.e(this.a, h2);
                this.f9878j = eVar.c();
            }
            c.a.p0.h.a.h.a aVar = new c.a.p0.h.a.h.a(this.a, false);
            aVar.k(this);
            aVar.i(eVar, this.f9874f);
        }
    }

    public void E(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048580, this, i2, i3, i4, i5) == null) {
            this.f9873e = new c.a.p0.h.a.a.c(i2, i3, i4, i5);
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
            c.a.p0.h.a.k.d.c(new e(this));
        }
    }

    public void H(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            c.a.p0.h.a.k.d.c(new d(this, str));
        }
    }

    @Override // c.a.p0.h.a.e.c
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            c.a.p0.h.a.a.f fVar = this.f9872d;
            if (fVar != null) {
                fVar.onError(str);
            }
            String appId = c.a.p0.h.a.f.a.b().getAppId();
            if (appId.lastIndexOf("_dev") >= 0 && appId.lastIndexOf("_dev") < appId.length() && str.equals("201000")) {
                w();
            }
            c.a.p0.h.a.a.f fVar2 = this.f9872d;
            if (fVar2 != null) {
                fVar2.a(false, "");
            }
        }
    }

    @Override // c.a.p0.h.a.a.d.e
    public void b() {
        c.a.p0.h.a.a.f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (fVar = this.f9872d) == null) {
            return;
        }
        fVar.onClose();
    }

    @Override // c.a.p0.h.a.e.c
    public void c(AdElementInfo adElementInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, adElementInfo) == null) {
            this.f9875g = adElementInfo;
            C();
        }
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            c.a.p0.h.a.a.d dVar = new c.a.p0.h.a.a.d(this.a);
            this.f9876h = dVar;
            dVar.e(this.f9873e.f9886c);
            if (this.f9876h.f() == null) {
                return;
            }
            if (this.n.c(this.f9876h.f())) {
                this.n.removeView(this.f9876h.f());
            }
            this.n.d(this.f9876h.f(), new c.a.p0.h.a.a.a(c.a.p0.h.a.k.h.a(this.f9873e.a), c.a.p0.h.a.k.h.a(this.f9873e.f9885b), c.a.p0.h.a.k.h.a(this.f9873e.f9888e), c.a.p0.h.a.k.h.a(this.f9873e.f9889f)));
            this.f9876h.f().postDelayed(new a(this), 20000L);
        }
    }

    public final void x() {
        c.a.p0.h.a.a.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (cVar = this.f9873e) == null) {
            return;
        }
        if (c.a.p0.h.a.k.h.a(cVar.f9886c) < 300) {
            this.f9873e.f9886c = c.a.p0.h.a.k.h.p(300.0f);
        }
        int q = c.a.p0.h.a.f.a.b().q();
        int p = c.a.p0.h.a.f.a.b().p();
        if (c.a.p0.h.a.k.h.a(this.f9873e.f9886c) > q) {
            this.f9873e.f9886c = c.a.p0.h.a.k.h.p(q);
        }
        c.a.p0.h.a.a.c cVar2 = this.f9873e;
        cVar2.f9887d = (int) (cVar2.f9886c / c.a.p0.h.a.a.e.a);
        if (cVar2.a < 0) {
            cVar2.a = 0;
        }
        int p2 = c.a.p0.h.a.k.h.p(q);
        c.a.p0.h.a.a.c cVar3 = this.f9873e;
        int i2 = p2 - cVar3.f9886c;
        if (cVar3.a > i2) {
            cVar3.a = i2;
        }
        c.a.p0.h.a.a.c cVar4 = this.f9873e;
        if (cVar4.f9885b < 0) {
            cVar4.f9885b = 0;
        }
        int p3 = c.a.p0.h.a.k.h.p(p);
        c.a.p0.h.a.a.c cVar5 = this.f9873e;
        int i3 = p3 - cVar5.f9887d;
        if (cVar5.f9885b > i3) {
            cVar5.f9885b = i3;
        }
        c.a.p0.h.a.a.c cVar6 = this.f9873e;
        cVar6.f9888e = cVar6.f9886c;
        cVar6.f9889f = cVar6.f9887d;
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            c.a.p0.h.a.k.d.c(new h(this));
        }
    }

    public final int z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (this.f9873e == null) {
                return 2;
            }
            int p = c.a.p0.h.a.k.h.p(c.a.p0.h.a.f.a.b().p());
            int i2 = this.f9873e.f9885b;
            int i3 = p / 3;
            if (i2 < i3) {
                return 1;
            }
            return i2 < i3 * 2 ? 4 : 2;
        }
        return invokeV.intValue;
    }
}
