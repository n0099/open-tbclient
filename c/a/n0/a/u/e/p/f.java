package c.a.n0.a.u.e.p;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import c.a.n0.a.v2.a0;
import c.a.n0.a.v2.f0;
import c.a.n0.a.v2.n0;
import c.a.n0.a.v2.q0;
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
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class f extends c.a.n0.a.u.c.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(@NonNull c.a.n0.a.u.c.b bVar) {
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
                super((c.a.n0.a.u.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static void s(@NonNull JSONObject jSONObject) throws JSONException {
        c.a.n0.a.a2.e i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, jSONObject) == null) && (i2 = c.a.n0.a.a2.e.i()) != null && i2.T().f("mapp_location")) {
            c.a.n0.a.c1.d.d E = c.a.n0.a.c1.a.E();
            c.a.n0.a.c2.f.k0.b g2 = E == null ? null : E.g();
            if (g2 == null) {
                return;
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("city", g2.k);
            jSONObject2.put("cityCode", g2.l);
            jSONObject2.put("country", g2.f4683i);
            jSONObject2.put("district", g2.n);
            jSONObject2.put("province", g2.m);
            jSONObject2.put("street", g2.o);
            jSONObject2.put("streetNumber", g2.p);
            jSONObject2.put("coord_gcj02", u(g2, "gcj02"));
            jSONObject2.put("coord_wgs84", u(g2, CoordinateType.WGS84));
            jSONObject.put("cacheLocation", jSONObject2);
        }
    }

    public static JSONObject u(@NonNull c.a.n0.a.c2.f.k0.b bVar, @NonNull String str) throws JSONException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, bVar, str)) == null) {
            JSONObject jSONObject = new JSONObject();
            double[] f2 = c.a.n0.a.c1.a.E().f(bVar, str);
            if (f2 != null && f2.length >= 2) {
                jSONObject.put("longitude", f2[0]);
                jSONObject.put("latitude", f2[1]);
            }
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }

    public static String w(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            int frameType = context instanceof SwanAppActivity ? ((SwanAppActivity) context).getFrameType() : 0;
            if (frameType == 1) {
                return c.a.n0.a.m2.b.i(c.a.n0.a.c1.b.i().n(), frameType);
            }
            return c.a.n0.a.m2.b.i(c.a.n0.a.h0.u.g.N().V(), frameType);
        }
        return (String) invokeL.objValue;
    }

    public final void r(@NonNull Context context, @NonNull JSONObject jSONObject) throws JSONException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, jSONObject) == null) {
            jSONObject.put("cameraAuthorized", a0.j(context, PermissionRequest.RESOURCE_VIDEO_CAPTURE));
            jSONObject.put("locationAuthorized", a0.j(context, "android.permission.ACCESS_FINE_LOCATION"));
            jSONObject.put("microphoneAuthorized", a0.j(context, PermissionRequest.RESOURCE_AUDIO_CAPTURE));
            jSONObject.put("notificationAuthorized", q0.M(context));
            jSONObject.put("locationEnabled", q0.K(context));
            jSONObject.put("wifiEnabled", q0.S(context));
        }
    }

    public final void t(@NonNull Context context, @NonNull JSONObject jSONObject, @NonNull Pair<Integer, Integer> pair) throws JSONException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, jSONObject, pair) == null) {
            int L = n0.L(f0.e(context));
            int L2 = n0.L(((Integer) pair.first).intValue());
            int L3 = n0.L(((Integer) pair.second).intValue());
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("left", 0);
            jSONObject2.put(HorizontalTranslateLayout.RIGHT, L2);
            jSONObject2.put(VerticalTranslateLayout.TOP, L);
            jSONObject2.put("width", L2);
            jSONObject2.put("bottom", L3);
            jSONObject2.put("height", L3 - L);
            jSONObject.put("safeArea", jSONObject2);
        }
    }

    public c.a.n0.a.u.h.b v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            boolean z = c.a.n0.a.u.c.d.f8453c;
            JSONObject d2 = c.a.n0.a.r1.k.g.a.c().d("getCommonSysInfoSync");
            if (d2 == null) {
                try {
                    d2 = new JSONObject();
                    d2.put("imei", q0.r());
                    c.a.n0.a.r1.k.g.a.c().h("getCommonSysInfoSync", d2);
                } catch (JSONException unused) {
                    return new c.a.n0.a.u.h.b(1001, "exec fail");
                }
            }
            return new c.a.n0.a.u.h.b(0, d2);
        }
        return (c.a.n0.a.u.h.b) invokeV.objValue;
    }

    public final JSONObject x(Context context) {
        InterceptResult invokeL;
        JSONObject a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) {
            if (c.a.n0.a.c1.a.Z().p()) {
                a2 = g.b(context);
            } else {
                a2 = g.a(context);
            }
            if (a2 == null) {
                return null;
            }
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            Pair<Integer, Integer> r = c.a.n0.a.g1.f.V().r();
            Pair<Integer, Integer> y = c.a.n0.a.g1.f.V().y();
            try {
                a2.put("SDKVersion", w(context));
                a2.put("windowWidth", (int) (((Integer) r.first).intValue() / displayMetrics.density));
                a2.put("windowHeight", (int) (((Integer) r.second).intValue() / displayMetrics.density));
                a2.put("screenWidth", n0.L(((Integer) y.first).intValue()));
                a2.put("screenHeight", n0.L(((Integer) y.second).intValue()));
                s(a2);
                r(context, a2);
                t(context, a2, y);
            } catch (JSONException e2) {
                if (c.a.n0.a.u.c.d.f8453c) {
                    e2.printStackTrace();
                }
            }
            if (c.a.n0.a.u.c.d.f8453c) {
                String str = "getSystemInfo:  " + a2;
            }
            return a2;
        }
        return (JSONObject) invokeL.objValue;
    }

    public c.a.n0.a.u.h.b y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            boolean z = c.a.n0.a.u.c.d.f8453c;
            JSONObject d2 = c.a.n0.a.r1.k.g.a.c().d("getSystemInfo");
            if (d2 == null) {
                d2 = x(i());
                c.a.n0.a.r1.k.g.a.c().h("getSystemInfo", d2);
                c.a.n0.a.r1.k.g.a.c().h("getSystemInfoSync", d2);
            }
            if (d2 == null) {
                return new c.a.n0.a.u.h.b(202, "empty joData");
            }
            return new c.a.n0.a.u.h.b(0, d2);
        }
        return (c.a.n0.a.u.h.b) invokeV.objValue;
    }

    public c.a.n0.a.u.h.b z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            boolean z = c.a.n0.a.u.c.d.f8453c;
            JSONObject d2 = c.a.n0.a.r1.k.g.a.c().d("getSystemInfoSync");
            if (d2 == null) {
                d2 = x(i());
                c.a.n0.a.r1.k.g.a.c().h("getSystemInfoSync", d2);
                c.a.n0.a.r1.k.g.a.c().h("getSystemInfo", d2);
            }
            if (d2 == null) {
                return new c.a.n0.a.u.h.b(202, "empty joData");
            }
            return new c.a.n0.a.u.h.b(0, d2);
        }
        return (c.a.n0.a.u.h.b) invokeV.objValue;
    }
}
