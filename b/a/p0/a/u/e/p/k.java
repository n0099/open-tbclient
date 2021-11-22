package b.a.p0.a.u.e.p;

import android.content.Context;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.z2.a0;
import b.a.p0.a.z2.f0;
import b.a.p0.a.z2.n0;
import b.a.p0.a.z2.q;
import b.a.p0.a.z2.q0;
import b.a.p0.a.z2.s0;
import com.baidu.adp.widget.HorizontalTranslateLayout;
import com.baidu.adp.widget.VerticalTranslateLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapsdkplatform.comapi.location.CoordinateType;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.PermissionRequest;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class k extends b.a.p0.a.u.e.p.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements s0<b.a.p0.a.u.h.b> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ k f8921a;

        public a(k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8921a = kVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // b.a.p0.a.z2.s0
        public b.a.p0.a.u.h.b call() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                JSONObject d2 = b.a.p0.a.u1.k.g.a.c().d("getSystemInfo");
                if (d2 == null) {
                    k kVar = this.f8921a;
                    d2 = kVar.G(kVar.getContext());
                    b.a.p0.a.u1.k.g.a.c().h("getSystemInfo", d2);
                    b.a.p0.a.u1.k.g.a.c().h("getSystemInfoSync", d2);
                }
                if (d2 == null) {
                    return new b.a.p0.a.u.h.b(202, "empty joData");
                }
                return new b.a.p0.a.u.h.b(0, d2);
            }
            return (b.a.p0.a.u.h.b) invokeV.objValue;
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8922e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ s0 f8923f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ k f8924g;

        public b(k kVar, String str, s0 s0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar, str, s0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8924g = kVar;
            this.f8922e = str;
            this.f8923f = s0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f8924g.d(this.f8922e, (b.a.p0.a.u.h.b) this.f8923f.call());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(@NonNull b.a.p0.a.u.c.b bVar) {
        super(bVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((b.a.p0.a.u.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static void B(@NonNull JSONObject jSONObject) throws JSONException {
        b.a.p0.a.d2.e L;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, jSONObject) == null) && (L = b.a.p0.a.d2.e.L()) != null && L.d0().f("mapp_location")) {
            b.a.p0.a.c1.d.e I = b.a.p0.a.c1.a.I();
            b.a.p0.a.f2.f.j0.b h2 = I == null ? null : I.h();
            if (h2 == null) {
                return;
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("city", h2.k);
            jSONObject2.put("cityCode", h2.l);
            jSONObject2.put("country", h2.f5055i);
            jSONObject2.put("district", h2.n);
            jSONObject2.put("province", h2.m);
            jSONObject2.put("street", h2.o);
            jSONObject2.put("streetNumber", h2.p);
            jSONObject2.put("coord_gcj02", D(h2, "gcj02"));
            jSONObject2.put("coord_wgs84", D(h2, CoordinateType.WGS84));
            jSONObject.put("cacheLocation", jSONObject2);
        }
    }

    public static JSONObject D(@NonNull b.a.p0.a.f2.f.j0.b bVar, @NonNull String str) throws JSONException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, bVar, str)) == null) {
            JSONObject jSONObject = new JSONObject();
            double[] g2 = b.a.p0.a.c1.a.I().g(bVar, str);
            if (g2 != null && g2.length >= 2) {
                jSONObject.put("longitude", g2[0]);
                jSONObject.put("latitude", g2[1]);
            }
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }

    public static String F(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            int frameType = context instanceof SwanAppActivity ? ((SwanAppActivity) context).getFrameType() : 0;
            if (frameType == 1) {
                return b.a.p0.a.q2.b.i(b.a.p0.a.c1.b.i().n(), frameType);
            }
            return b.a.p0.a.q2.b.i(b.a.p0.a.h0.u.g.U().d0(), frameType);
        }
        return (String) invokeL.objValue;
    }

    public final void A(@NonNull JSONObject jSONObject) throws JSONException {
        b.a.p0.a.d2.e L;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) && (L = b.a.p0.a.d2.e.L()) != null && L.d0().f("mapp_set_user_agent")) {
            jSONObject.put(TTDownloadField.TT_USERAGENT, b.a.p0.p.b.b().a());
        }
    }

    public final void C(@NonNull Context context, @NonNull JSONObject jSONObject, @NonNull Pair<Integer, Integer> pair) throws JSONException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, jSONObject, pair) == null) {
            int P = n0.P(f0.e(context));
            int P2 = n0.P(((Integer) pair.first).intValue());
            int P3 = n0.P(((Integer) pair.second).intValue());
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("left", 0);
            jSONObject2.put(HorizontalTranslateLayout.RIGHT, P2);
            jSONObject2.put(VerticalTranslateLayout.TOP, P);
            jSONObject2.put("width", P2);
            jSONObject2.put("bottom", P3);
            jSONObject2.put("height", P3 - P);
            jSONObject.put("safeArea", jSONObject2);
        }
    }

    public b.a.p0.a.u.h.b E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            q("#getCommonSysInfoSync", false);
            JSONObject d2 = b.a.p0.a.u1.k.g.a.c().d("getCommonSysInfoSync");
            if (d2 == null) {
                try {
                    d2 = new JSONObject();
                    d2.put("imei", q0.r());
                    b.a.p0.a.u1.k.g.a.c().h("getCommonSysInfoSync", d2);
                } catch (JSONException unused) {
                    return new b.a.p0.a.u.h.b(1001, "exec fail");
                }
            }
            return new b.a.p0.a.u.h.b(0, d2);
        }
        return (b.a.p0.a.u.h.b) invokeV.objValue;
    }

    public final JSONObject G(Context context) {
        InterceptResult invokeL;
        JSONObject a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) {
            if (b.a.p0.a.c1.a.g0().o()) {
                a2 = l.b(context);
            } else {
                a2 = l.a(context);
            }
            if (a2 == null) {
                return null;
            }
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            Pair<Integer, Integer> q = b.a.p0.a.g1.f.U().q();
            Pair<Integer, Integer> x = b.a.p0.a.g1.f.U().x();
            try {
                a2.put("SDKVersion", F(context));
                a2.put("windowWidth", (int) (((Integer) q.first).intValue() / displayMetrics.density));
                a2.put("windowHeight", (int) (((Integer) q.second).intValue() / displayMetrics.density));
                a2.put("screenWidth", n0.P(((Integer) x.first).intValue()));
                a2.put("screenHeight", n0.P(((Integer) x.second).intValue()));
                a2.put("privacyMode", b.a.p0.a.c1.a.y0().c());
                B(a2);
                z(context, a2);
                C(context, a2, x);
                A(a2);
            } catch (JSONException e2) {
                p("json put data fail", e2, false);
            }
            return a2;
        }
        return (JSONObject) invokeL.objValue;
    }

    public b.a.p0.a.u.h.b H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            q("#getSystemInfo", false);
            return I(null);
        }
        return (b.a.p0.a.u.h.b) invokeV.objValue;
    }

    public b.a.p0.a.u.h.b I(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            q("#getSystemInfoAsync", false);
            a aVar = new a(this);
            if (!TextUtils.isEmpty(str)) {
                try {
                    String optString = new JSONObject(str).optString("cb");
                    if (!TextUtils.isEmpty(optString)) {
                        q.k(new b(this, optString, aVar), "SystemInfoApi");
                        return b.a.p0.a.u.h.b.f();
                    }
                } catch (JSONException e2) {
                    p("json put data fail", e2, false);
                }
            }
            return aVar.call();
        }
        return (b.a.p0.a.u.h.b) invokeL.objValue;
    }

    public b.a.p0.a.u.h.b J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            q("#getSystemInfoSync", false);
            JSONObject d2 = b.a.p0.a.u1.k.g.a.c().d("getSystemInfoSync");
            if (d2 == null) {
                d2 = G(getContext());
                b.a.p0.a.u1.k.g.a.c().h("getSystemInfoSync", d2);
                b.a.p0.a.u1.k.g.a.c().h("getSystemInfo", d2);
            }
            if (d2 == null) {
                return new b.a.p0.a.u.h.b(202, "empty joData");
            }
            return new b.a.p0.a.u.h.b(0, d2);
        }
        return (b.a.p0.a.u.h.b) invokeV.objValue;
    }

    @Override // b.a.p0.a.u.c.d
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? "SystemInfoApi" : (String) invokeV.objValue;
    }

    public final void z(@NonNull Context context, @NonNull JSONObject jSONObject) throws JSONException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context, jSONObject) == null) {
            jSONObject.put("cameraAuthorized", a0.j(context, PermissionRequest.RESOURCE_VIDEO_CAPTURE));
            jSONObject.put("locationAuthorized", a0.j(context, "android.permission.ACCESS_FINE_LOCATION"));
            jSONObject.put("microphoneAuthorized", a0.j(context, PermissionRequest.RESOURCE_AUDIO_CAPTURE));
            jSONObject.put("notificationAuthorized", q0.N(context));
            jSONObject.put("locationEnabled", q0.L(context));
            jSONObject.put("wifiEnabled", q0.V(context));
        }
    }
}
