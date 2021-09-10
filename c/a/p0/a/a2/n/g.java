package c.a.p0.a.a2.n;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.reactivex.annotations.SchedulerSupport;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean r;
    public static final f<g> s;
    public static final e<g> t;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f4603a;

    /* renamed from: b  reason: collision with root package name */
    public String f4604b;

    /* renamed from: c  reason: collision with root package name */
    public String f4605c;

    /* renamed from: d  reason: collision with root package name */
    public String f4606d;

    /* renamed from: e  reason: collision with root package name */
    public int f4607e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f4608f;

    /* renamed from: g  reason: collision with root package name */
    public String f4609g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f4610h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f4611i;

    /* renamed from: j  reason: collision with root package name */
    public String f4612j;
    public boolean k;
    public boolean l;
    public boolean m;
    public boolean n;
    public boolean o;
    public boolean p;
    public String q;

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
        @Override // c.a.p0.a.a2.n.f
        /* renamed from: c */
        public void b(@NonNull g gVar, @NonNull c.a.p0.a.b1.d dVar) throws Exception {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gVar, dVar) == null) {
                dVar.writeInt(gVar.f4603a);
                dVar.f(gVar.f4604b);
                dVar.f(gVar.f4605c);
                dVar.f(gVar.f4606d);
                dVar.writeInt(gVar.f4607e);
                dVar.writeBoolean(gVar.f4608f);
                dVar.f(gVar.f4609g);
                dVar.writeBoolean(gVar.f4610h);
                dVar.writeBoolean(gVar.f4611i);
                dVar.f(gVar.f4612j);
                dVar.writeBoolean(gVar.k);
                dVar.writeBoolean(gVar.l);
                dVar.writeBoolean(gVar.m);
                dVar.writeBoolean(gVar.n);
                dVar.writeBoolean(gVar.o);
                dVar.writeBoolean(gVar.p);
                dVar.f(gVar.q);
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
        @Override // c.a.p0.a.a2.n.e
        /* renamed from: c */
        public g b(@NonNull c.a.p0.a.b1.c cVar) throws Exception {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar)) == null) {
                g gVar = new g();
                gVar.f4603a = cVar.readInt();
                gVar.f4604b = cVar.r();
                gVar.f4605c = cVar.r();
                gVar.f4606d = cVar.r();
                gVar.f4607e = cVar.readInt();
                gVar.f4608f = cVar.readBoolean();
                gVar.f4609g = cVar.r();
                gVar.f4610h = cVar.readBoolean();
                gVar.f4611i = cVar.readBoolean();
                gVar.f4612j = cVar.r();
                gVar.k = cVar.readBoolean();
                gVar.l = cVar.readBoolean();
                gVar.m = cVar.readBoolean();
                gVar.n = cVar.readBoolean();
                gVar.o = cVar.readBoolean();
                gVar.p = cVar.readBoolean();
                gVar.q = cVar.r();
                return gVar;
            }
            return (g) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-773222788, "Lc/a/p0/a/a2/n/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-773222788, "Lc/a/p0/a/a2/n/g;");
                return;
            }
        }
        r = k.f7077a;
        s = new a();
        t = new b();
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
        this.f4603a = -16777216;
        this.f4605c = "#ffffff";
        this.f4612j = "default";
        this.f4607e = -1;
        this.f4608f = false;
    }

    public static g a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return d();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("window");
            if (optJSONObject == null) {
                return d();
            }
            return c(optJSONObject);
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
                if (r) {
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
            g gVar = new g();
            String optString = jSONObject.optString("navigationBarBackgroundColor");
            if (TextUtils.isEmpty(optString)) {
                optString = "#000000";
            }
            gVar.f4603a = SwanAppConfigData.s(optString);
            String optString2 = jSONObject.optString("navigationBarTextStyle");
            if (TextUtils.isEmpty(optString2)) {
                optString2 = "white";
            }
            gVar.f4605c = optString2;
            gVar.f4604b = jSONObject.optString("navigationBarTitleText");
            gVar.f4606d = jSONObject.optString("backgroundTextStyle", "black");
            gVar.f4607e = SwanAppConfigData.s(jSONObject.optString("backgroundColor"));
            gVar.f4608f = jSONObject.optBoolean("enablePullDownRefresh");
            gVar.f4609g = jSONObject.optString("onReachBottomDistance");
            gVar.f4610h = jSONObject.optBoolean("enableOpacityNavigationBar");
            gVar.f4611i = jSONObject.optBoolean("enableOpacityNavigationBarText");
            gVar.f4612j = jSONObject.optString("navigationStyle", "default");
            gVar.k = jSONObject.optBoolean("navigationHomeButtonHidden");
            gVar.q = jSONObject.optString("textSizeAdjust");
            return gVar;
        }
        return (g) invokeL.objValue;
    }

    public static g d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) {
            if (r) {
                String str = "WindowConfig createNullObject() " + Log.getStackTraceString(new Exception());
            }
            return new g();
        }
        return (g) invokeV.objValue;
    }

    public static g e(JSONObject jSONObject, @NonNull g gVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, jSONObject, gVar)) == null) {
            g gVar2 = new g();
            String optString = jSONObject.optString("navigationBarBackgroundColor");
            gVar2.f4603a = TextUtils.isEmpty(optString) ? gVar.f4603a : SwanAppConfigData.s(optString);
            gVar2.f4604b = jSONObject.optString("navigationBarTitleText", gVar.f4604b);
            String optString2 = jSONObject.optString("navigationBarTextStyle");
            if (TextUtils.isEmpty(optString2)) {
                optString2 = gVar.f4605c;
            }
            gVar2.f4605c = optString2;
            gVar2.f4606d = jSONObject.optString("backgroundTextStyle", gVar.f4606d);
            gVar2.f4607e = jSONObject.has("backgroundColor") ? SwanAppConfigData.s(jSONObject.optString("backgroundColor")) : gVar.f4607e;
            gVar2.f4608f = jSONObject.optBoolean("enablePullDownRefresh", gVar.f4608f);
            gVar2.f4609g = jSONObject.optString("onReachBottomDistance", gVar.f4609g);
            gVar2.f4610h = jSONObject.optBoolean("enableOpacityNavigationBar", gVar.f4610h);
            gVar2.f4611i = jSONObject.optBoolean("enableOpacityNavigationBarText", gVar.f4611i);
            gVar2.f4612j = jSONObject.optString("navigationStyle", gVar.f4612j);
            gVar2.k = jSONObject.optBoolean("navigationHomeButtonHidden", gVar.k);
            gVar2.l = jSONObject.optBoolean("disableSwipeBack", false);
            gVar2.m = jSONObject.optBoolean("disableFullscreenSwipeBack", false);
            gVar2.n = jSONObject.optBoolean("pageFavoriteEnable", true);
            gVar2.o = jSONObject.optBoolean("_hasVideo", false);
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
            return gVar.f4610h || TextUtils.equals(gVar.f4612j, SchedulerSupport.CUSTOM);
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
