package b.a.p0.a.a2.n;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.k;
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
    public int f4004a;

    /* renamed from: b  reason: collision with root package name */
    public String f4005b;

    /* renamed from: c  reason: collision with root package name */
    public String f4006c;

    /* renamed from: d  reason: collision with root package name */
    public String f4007d;

    /* renamed from: e  reason: collision with root package name */
    public int f4008e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f4009f;

    /* renamed from: g  reason: collision with root package name */
    public String f4010g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f4011h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f4012i;
    public String j;
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
        @Override // b.a.p0.a.a2.n.f
        /* renamed from: b */
        public void a(@NonNull g gVar, @NonNull b.a.p0.a.b1.d dVar) throws Exception {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gVar, dVar) == null) {
                dVar.writeInt(gVar.f4004a);
                dVar.f(gVar.f4005b);
                dVar.f(gVar.f4006c);
                dVar.f(gVar.f4007d);
                dVar.writeInt(gVar.f4008e);
                dVar.writeBoolean(gVar.f4009f);
                dVar.f(gVar.f4010g);
                dVar.writeBoolean(gVar.f4011h);
                dVar.writeBoolean(gVar.f4012i);
                dVar.f(gVar.j);
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
        @Override // b.a.p0.a.a2.n.e
        /* renamed from: b */
        public g a(@NonNull b.a.p0.a.b1.c cVar) throws Exception {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar)) == null) {
                g gVar = new g();
                gVar.f4004a = cVar.readInt();
                gVar.f4005b = cVar.g();
                gVar.f4006c = cVar.g();
                gVar.f4007d = cVar.g();
                gVar.f4008e = cVar.readInt();
                gVar.f4009f = cVar.readBoolean();
                gVar.f4010g = cVar.g();
                gVar.f4011h = cVar.readBoolean();
                gVar.f4012i = cVar.readBoolean();
                gVar.j = cVar.g();
                gVar.k = cVar.readBoolean();
                gVar.l = cVar.readBoolean();
                gVar.m = cVar.readBoolean();
                gVar.n = cVar.readBoolean();
                gVar.o = cVar.readBoolean();
                gVar.p = cVar.readBoolean();
                gVar.q = cVar.g();
                return gVar;
            }
            return (g) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-262688611, "Lb/a/p0/a/a2/n/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-262688611, "Lb/a/p0/a/a2/n/g;");
                return;
            }
        }
        r = k.f6397a;
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
        this.f4004a = -16777216;
        this.f4006c = "#ffffff";
        this.j = "default";
        this.f4008e = -1;
        this.f4009f = false;
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
            gVar.f4004a = SwanAppConfigData.s(optString);
            String optString2 = jSONObject.optString("navigationBarTextStyle");
            if (TextUtils.isEmpty(optString2)) {
                optString2 = "white";
            }
            gVar.f4006c = optString2;
            gVar.f4005b = jSONObject.optString("navigationBarTitleText");
            gVar.f4007d = jSONObject.optString("backgroundTextStyle", "black");
            gVar.f4008e = SwanAppConfigData.s(jSONObject.optString("backgroundColor"));
            gVar.f4009f = jSONObject.optBoolean("enablePullDownRefresh");
            gVar.f4010g = jSONObject.optString("onReachBottomDistance");
            gVar.f4011h = jSONObject.optBoolean("enableOpacityNavigationBar");
            gVar.f4012i = jSONObject.optBoolean("enableOpacityNavigationBarText");
            gVar.j = jSONObject.optString("navigationStyle", "default");
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
            gVar2.f4004a = TextUtils.isEmpty(optString) ? gVar.f4004a : SwanAppConfigData.s(optString);
            gVar2.f4005b = jSONObject.optString("navigationBarTitleText", gVar.f4005b);
            String optString2 = jSONObject.optString("navigationBarTextStyle");
            if (TextUtils.isEmpty(optString2)) {
                optString2 = gVar.f4006c;
            }
            gVar2.f4006c = optString2;
            gVar2.f4007d = jSONObject.optString("backgroundTextStyle", gVar.f4007d);
            gVar2.f4008e = jSONObject.has("backgroundColor") ? SwanAppConfigData.s(jSONObject.optString("backgroundColor")) : gVar.f4008e;
            gVar2.f4009f = jSONObject.optBoolean("enablePullDownRefresh", gVar.f4009f);
            gVar2.f4010g = jSONObject.optString("onReachBottomDistance", gVar.f4010g);
            gVar2.f4011h = jSONObject.optBoolean("enableOpacityNavigationBar", gVar.f4011h);
            gVar2.f4012i = jSONObject.optBoolean("enableOpacityNavigationBarText", gVar.f4012i);
            gVar2.j = jSONObject.optString("navigationStyle", gVar.j);
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
            return gVar.f4011h || TextUtils.equals(gVar.j, SchedulerSupport.CUSTOM);
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
