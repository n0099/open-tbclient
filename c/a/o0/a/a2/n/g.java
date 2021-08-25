package c.a.o0.a.a2.n;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.a.k;
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
    public int f4575a;

    /* renamed from: b  reason: collision with root package name */
    public String f4576b;

    /* renamed from: c  reason: collision with root package name */
    public String f4577c;

    /* renamed from: d  reason: collision with root package name */
    public String f4578d;

    /* renamed from: e  reason: collision with root package name */
    public int f4579e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f4580f;

    /* renamed from: g  reason: collision with root package name */
    public String f4581g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f4582h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f4583i;

    /* renamed from: j  reason: collision with root package name */
    public String f4584j;
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
        @Override // c.a.o0.a.a2.n.f
        /* renamed from: c */
        public void b(@NonNull g gVar, @NonNull c.a.o0.a.b1.d dVar) throws Exception {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gVar, dVar) == null) {
                dVar.writeInt(gVar.f4575a);
                dVar.f(gVar.f4576b);
                dVar.f(gVar.f4577c);
                dVar.f(gVar.f4578d);
                dVar.writeInt(gVar.f4579e);
                dVar.writeBoolean(gVar.f4580f);
                dVar.f(gVar.f4581g);
                dVar.writeBoolean(gVar.f4582h);
                dVar.writeBoolean(gVar.f4583i);
                dVar.f(gVar.f4584j);
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
        @Override // c.a.o0.a.a2.n.e
        /* renamed from: c */
        public g b(@NonNull c.a.o0.a.b1.c cVar) throws Exception {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar)) == null) {
                g gVar = new g();
                gVar.f4575a = cVar.readInt();
                gVar.f4576b = cVar.r();
                gVar.f4577c = cVar.r();
                gVar.f4578d = cVar.r();
                gVar.f4579e = cVar.readInt();
                gVar.f4580f = cVar.readBoolean();
                gVar.f4581g = cVar.r();
                gVar.f4582h = cVar.readBoolean();
                gVar.f4583i = cVar.readBoolean();
                gVar.f4584j = cVar.r();
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-902305507, "Lc/a/o0/a/a2/n/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-902305507, "Lc/a/o0/a/a2/n/g;");
                return;
            }
        }
        r = k.f7049a;
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
        this.f4575a = -16777216;
        this.f4577c = "#ffffff";
        this.f4584j = "default";
        this.f4579e = -1;
        this.f4580f = false;
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
            gVar.f4575a = SwanAppConfigData.s(optString);
            String optString2 = jSONObject.optString("navigationBarTextStyle");
            if (TextUtils.isEmpty(optString2)) {
                optString2 = "white";
            }
            gVar.f4577c = optString2;
            gVar.f4576b = jSONObject.optString("navigationBarTitleText");
            gVar.f4578d = jSONObject.optString("backgroundTextStyle", "black");
            gVar.f4579e = SwanAppConfigData.s(jSONObject.optString("backgroundColor"));
            gVar.f4580f = jSONObject.optBoolean("enablePullDownRefresh");
            gVar.f4581g = jSONObject.optString("onReachBottomDistance");
            gVar.f4582h = jSONObject.optBoolean("enableOpacityNavigationBar");
            gVar.f4583i = jSONObject.optBoolean("enableOpacityNavigationBarText");
            gVar.f4584j = jSONObject.optString("navigationStyle", "default");
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
            gVar2.f4575a = TextUtils.isEmpty(optString) ? gVar.f4575a : SwanAppConfigData.s(optString);
            gVar2.f4576b = jSONObject.optString("navigationBarTitleText", gVar.f4576b);
            String optString2 = jSONObject.optString("navigationBarTextStyle");
            if (TextUtils.isEmpty(optString2)) {
                optString2 = gVar.f4577c;
            }
            gVar2.f4577c = optString2;
            gVar2.f4578d = jSONObject.optString("backgroundTextStyle", gVar.f4578d);
            gVar2.f4579e = jSONObject.has("backgroundColor") ? SwanAppConfigData.s(jSONObject.optString("backgroundColor")) : gVar.f4579e;
            gVar2.f4580f = jSONObject.optBoolean("enablePullDownRefresh", gVar.f4580f);
            gVar2.f4581g = jSONObject.optString("onReachBottomDistance", gVar.f4581g);
            gVar2.f4582h = jSONObject.optBoolean("enableOpacityNavigationBar", gVar.f4582h);
            gVar2.f4583i = jSONObject.optBoolean("enableOpacityNavigationBarText", gVar.f4583i);
            gVar2.f4584j = jSONObject.optString("navigationStyle", gVar.f4584j);
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
            return gVar.f4582h || TextUtils.equals(gVar.f4584j, SchedulerSupport.CUSTOM);
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
