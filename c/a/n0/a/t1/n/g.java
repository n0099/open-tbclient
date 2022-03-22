package c.a.n0.a.t1.n;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean t;
    public static final f<g> u;
    public static final e<g> v;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public String f6379b;

    /* renamed from: c  reason: collision with root package name */
    public String f6380c;

    /* renamed from: d  reason: collision with root package name */
    public String f6381d;

    /* renamed from: e  reason: collision with root package name */
    public int f6382e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f6383f;

    /* renamed from: g  reason: collision with root package name */
    public String f6384g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f6385h;
    public boolean i;
    public String j;
    public boolean k;
    public boolean l;
    public boolean m;
    public boolean n;
    public boolean o;
    public boolean p;
    public String q;
    public String r;
    public String s;

    /* loaded from: classes.dex */
    public static class a extends f<g> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.a.t1.n.f
        /* renamed from: b */
        public void a(@NonNull g gVar, @NonNull c.a.n0.a.r0.d dVar) throws Exception {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gVar, dVar) == null) {
                dVar.writeInt(gVar.a);
                dVar.f(gVar.f6379b);
                dVar.f(gVar.f6380c);
                dVar.f(gVar.f6381d);
                dVar.writeInt(gVar.f6382e);
                dVar.writeBoolean(gVar.f6383f);
                dVar.f(gVar.f6384g);
                dVar.writeBoolean(gVar.f6385h);
                dVar.writeBoolean(gVar.i);
                dVar.f(gVar.j);
                dVar.writeBoolean(gVar.k);
                dVar.writeBoolean(gVar.l);
                dVar.writeBoolean(gVar.m);
                dVar.writeBoolean(gVar.n);
                dVar.writeBoolean(gVar.o);
                dVar.writeBoolean(gVar.p);
                dVar.f(gVar.q);
                dVar.f(gVar.r);
                dVar.f(gVar.s);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b extends e<g> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.a.t1.n.e
        /* renamed from: b */
        public g a(@NonNull c.a.n0.a.r0.c cVar) throws Exception {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar)) == null) {
                g gVar = new g();
                gVar.a = cVar.readInt();
                gVar.f6379b = cVar.g();
                gVar.f6380c = cVar.g();
                gVar.f6381d = cVar.g();
                gVar.f6382e = cVar.readInt();
                gVar.f6383f = cVar.readBoolean();
                gVar.f6384g = cVar.g();
                gVar.f6385h = cVar.readBoolean();
                gVar.i = cVar.readBoolean();
                gVar.j = cVar.g();
                gVar.k = cVar.readBoolean();
                gVar.l = cVar.readBoolean();
                gVar.m = cVar.readBoolean();
                gVar.n = cVar.readBoolean();
                gVar.o = cVar.readBoolean();
                gVar.p = cVar.readBoolean();
                gVar.q = cVar.g();
                gVar.r = cVar.g();
                gVar.s = cVar.g();
                return gVar;
            }
            return (g) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1377316622, "Lc/a/n0/a/t1/n/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1377316622, "Lc/a/n0/a/t1/n/g;");
                return;
            }
        }
        t = c.a.n0.a.a.a;
        u = new a();
        v = new b();
    }

    public g() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.l = false;
        this.m = false;
        this.n = true;
        this.o = false;
        this.p = false;
        this.a = -16777216;
        this.f6380c = "#ffffff";
        this.j = "default";
        this.f6382e = -1;
        this.f6383f = false;
    }

    public static g a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return d();
            }
            return c(jSONObject);
        }
        return (g) invokeL.objValue;
    }

    public static g b(String str, @NonNull g gVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, gVar)) == null) {
            if (TextUtils.isEmpty(str)) {
                return gVar;
            }
            try {
                return e(new JSONObject(str), gVar);
            } catch (JSONException e2) {
                if (t) {
                    Log.d("WindowConfig", "buildPageWindowConfig jsonString failed: " + Log.getStackTraceString(e2));
                }
                return gVar;
            }
        }
        return (g) invokeLL.objValue;
    }

    public static g c(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONObject)) == null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("window");
            if (optJSONObject == null) {
                return d();
            }
            g gVar = new g();
            String optString = optJSONObject.optString("navigationBarBackgroundColor");
            if (TextUtils.isEmpty(optString)) {
                optString = "#000000";
            }
            gVar.a = SwanAppConfigData.t(optString);
            String optString2 = optJSONObject.optString("navigationBarTextStyle");
            if (TextUtils.isEmpty(optString2)) {
                optString2 = "white";
            }
            gVar.f6380c = optString2;
            gVar.f6379b = optJSONObject.optString("navigationBarTitleText");
            gVar.f6381d = optJSONObject.optString("backgroundTextStyle", "black");
            gVar.f6382e = SwanAppConfigData.t(optJSONObject.optString("backgroundColor"));
            gVar.f6383f = optJSONObject.optBoolean("enablePullDownRefresh");
            gVar.f6384g = optJSONObject.optString("onReachBottomDistance");
            gVar.f6385h = optJSONObject.optBoolean("enableOpacityNavigationBar");
            gVar.i = optJSONObject.optBoolean("enableOpacityNavigationBarText");
            gVar.j = optJSONObject.optString("navigationStyle", "default");
            gVar.k = optJSONObject.optBoolean("navigationHomeButtonHidden");
            gVar.q = optJSONObject.optString("textSizeAdjust");
            gVar.s = optJSONObject.optString("htmlFontSize");
            optJSONObject.optJSONArray("fontFace");
            return gVar;
        }
        return (g) invokeL.objValue;
    }

    public static g d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            if (t) {
                Log.w("WindowConfig", "WindowConfig#createNullObject stack=" + Log.getStackTraceString(new Exception()));
            }
            return new g();
        }
        return (g) invokeV.objValue;
    }

    public static g e(JSONObject jSONObject, @NonNull g gVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, jSONObject, gVar)) == null) {
            g gVar2 = new g();
            String optString = jSONObject.optString("navigationBarBackgroundColor");
            gVar2.a = TextUtils.isEmpty(optString) ? gVar.a : SwanAppConfigData.t(optString);
            gVar2.f6379b = jSONObject.optString("navigationBarTitleText", gVar.f6379b);
            String optString2 = jSONObject.optString("navigationBarTextStyle");
            if (TextUtils.isEmpty(optString2)) {
                optString2 = gVar.f6380c;
            }
            gVar2.f6380c = optString2;
            gVar2.f6381d = jSONObject.optString("backgroundTextStyle", gVar.f6381d);
            gVar2.f6382e = jSONObject.has("backgroundColor") ? SwanAppConfigData.t(jSONObject.optString("backgroundColor")) : gVar.f6382e;
            gVar2.f6383f = jSONObject.optBoolean("enablePullDownRefresh", gVar.f6383f);
            gVar2.f6384g = jSONObject.optString("onReachBottomDistance", gVar.f6384g);
            gVar2.f6385h = jSONObject.optBoolean("enableOpacityNavigationBar", gVar.f6385h);
            gVar2.i = jSONObject.optBoolean("enableOpacityNavigationBarText", gVar.i);
            gVar2.j = jSONObject.optString("navigationStyle", gVar.j);
            gVar2.k = jSONObject.optBoolean("navigationHomeButtonHidden", gVar.k);
            gVar2.l = jSONObject.optBoolean("disableSwipeBack", false);
            gVar2.m = jSONObject.optBoolean("disableFullscreenSwipeBack", false);
            gVar2.n = jSONObject.optBoolean("pageFavoriteEnable", true);
            gVar2.o = jSONObject.optBoolean("_hasVideo", false);
            gVar2.r = jSONObject.optString("viewMode", gVar.r);
            gVar2.s = jSONObject.optString("htmlFontSize", gVar.s);
            jSONObject.optJSONArray("fontFace");
            return gVar2;
        }
        return (g) invokeLL.objValue;
    }

    public static boolean f(g gVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, gVar)) == null) {
            if (gVar == null) {
                return false;
            }
            return gVar.f6385h || TextUtils.equals(gVar.j, "custom");
        }
        return invokeL.booleanValue;
    }

    public void g(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && z && !this.p) {
            this.p = true;
        }
    }
}
