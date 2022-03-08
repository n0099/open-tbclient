package c.a.p0.a.t1.n;

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
    public String f7549b;

    /* renamed from: c  reason: collision with root package name */
    public String f7550c;

    /* renamed from: d  reason: collision with root package name */
    public String f7551d;

    /* renamed from: e  reason: collision with root package name */
    public int f7552e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f7553f;

    /* renamed from: g  reason: collision with root package name */
    public String f7554g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f7555h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f7556i;

    /* renamed from: j  reason: collision with root package name */
    public String f7557j;
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.t1.n.f
        /* renamed from: b */
        public void a(@NonNull g gVar, @NonNull c.a.p0.a.r0.d dVar) throws Exception {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gVar, dVar) == null) {
                dVar.writeInt(gVar.a);
                dVar.f(gVar.f7549b);
                dVar.f(gVar.f7550c);
                dVar.f(gVar.f7551d);
                dVar.writeInt(gVar.f7552e);
                dVar.writeBoolean(gVar.f7553f);
                dVar.f(gVar.f7554g);
                dVar.writeBoolean(gVar.f7555h);
                dVar.writeBoolean(gVar.f7556i);
                dVar.f(gVar.f7557j);
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.t1.n.e
        /* renamed from: b */
        public g a(@NonNull c.a.p0.a.r0.c cVar) throws Exception {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar)) == null) {
                g gVar = new g();
                gVar.a = cVar.readInt();
                gVar.f7549b = cVar.g();
                gVar.f7550c = cVar.g();
                gVar.f7551d = cVar.g();
                gVar.f7552e = cVar.readInt();
                gVar.f7553f = cVar.readBoolean();
                gVar.f7554g = cVar.g();
                gVar.f7555h = cVar.readBoolean();
                gVar.f7556i = cVar.readBoolean();
                gVar.f7557j = cVar.g();
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1119151184, "Lc/a/p0/a/t1/n/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1119151184, "Lc/a/p0/a/t1/n/g;");
                return;
            }
        }
        t = c.a.p0.a.a.a;
        u = new a();
        v = new b();
    }

    public g() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
        this.f7550c = "#ffffff";
        this.f7557j = "default";
        this.f7552e = -1;
        this.f7553f = false;
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
                    String str2 = "buildPageWindowConfig jsonString failed: " + Log.getStackTraceString(e2);
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
            gVar.f7550c = optString2;
            gVar.f7549b = optJSONObject.optString("navigationBarTitleText");
            gVar.f7551d = optJSONObject.optString("backgroundTextStyle", "black");
            gVar.f7552e = SwanAppConfigData.t(optJSONObject.optString("backgroundColor"));
            gVar.f7553f = optJSONObject.optBoolean("enablePullDownRefresh");
            gVar.f7554g = optJSONObject.optString("onReachBottomDistance");
            gVar.f7555h = optJSONObject.optBoolean("enableOpacityNavigationBar");
            gVar.f7556i = optJSONObject.optBoolean("enableOpacityNavigationBarText");
            gVar.f7557j = optJSONObject.optString("navigationStyle", "default");
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
                String str = "WindowConfig#createNullObject stack=" + Log.getStackTraceString(new Exception());
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
            gVar2.f7549b = jSONObject.optString("navigationBarTitleText", gVar.f7549b);
            String optString2 = jSONObject.optString("navigationBarTextStyle");
            if (TextUtils.isEmpty(optString2)) {
                optString2 = gVar.f7550c;
            }
            gVar2.f7550c = optString2;
            gVar2.f7551d = jSONObject.optString("backgroundTextStyle", gVar.f7551d);
            gVar2.f7552e = jSONObject.has("backgroundColor") ? SwanAppConfigData.t(jSONObject.optString("backgroundColor")) : gVar.f7552e;
            gVar2.f7553f = jSONObject.optBoolean("enablePullDownRefresh", gVar.f7553f);
            gVar2.f7554g = jSONObject.optString("onReachBottomDistance", gVar.f7554g);
            gVar2.f7555h = jSONObject.optBoolean("enableOpacityNavigationBar", gVar.f7555h);
            gVar2.f7556i = jSONObject.optBoolean("enableOpacityNavigationBarText", gVar.f7556i);
            gVar2.f7557j = jSONObject.optString("navigationStyle", gVar.f7557j);
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
            return gVar.f7555h || TextUtils.equals(gVar.f7557j, "custom");
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
