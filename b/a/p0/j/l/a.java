package b.a.p0.j.l;

import android.text.TextUtils;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.h1.c.h.d;
import b.a.p0.a.k;
import b.a.p0.j.n.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.map.MapPoi;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f10932a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b.a.p0.j.l.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0607a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public JSONObject f10933a;

        public C0607a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10933a = new JSONObject();
        }

        public static C0607a a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? new C0607a() : (C0607a) invokeV.objValue;
        }

        public JSONObject b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f10933a : (JSONObject) invokeV.objValue;
        }

        public C0607a c(String str, Object obj) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, obj)) == null) {
                if (!TextUtils.isEmpty(str)) {
                    try {
                        this.f10933a.put(str, obj);
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
                return this;
            }
            return (C0607a) invokeLL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-807868662, "Lb/a/p0/j/l/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-807868662, "Lb/a/p0/j/l/a;");
                return;
            }
        }
        f10932a = k.f6397a;
    }

    public static void a(c cVar, d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, cVar, dVar) == null) {
            C0607a a2 = C0607a.a();
            a2.c("mapId", cVar.j);
            a2.c("markerId", dVar.f5873e);
            JSONObject b2 = a2.b();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("vtype", "callouttap");
                jSONObject.put("data", b2.toString());
                jSONObject.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, cVar.f10956i);
            } catch (JSONException e2) {
                if (f10932a) {
                    e2.printStackTrace();
                }
            }
            b.a.p0.a.w2.g.c.a.d(cVar.f10956i, cVar.j, "map", "callouttap", jSONObject);
        }
    }

    public static void b(View view, c cVar) {
        b.a.p0.a.h1.c.h.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, view, cVar) == null) {
            b.a.p0.j.n.a G = cVar.G(view);
            String str = (G == null || (bVar = G.f10942a) == null) ? "" : bVar.f5867e;
            C0607a a2 = C0607a.a();
            a2.c("mapId", cVar.j);
            a2.c("controlId", str);
            JSONObject b2 = a2.b();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("vtype", "controltap");
                jSONObject.put("data", b2.toString());
                jSONObject.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, cVar.f10956i);
            } catch (JSONException e2) {
                if (f10932a) {
                    e2.printStackTrace();
                }
            }
            b.a.p0.a.w2.g.c.a.d(cVar.f10956i, cVar.j, "map", "controltap", jSONObject);
        }
    }

    public static void c(c cVar, MapPoi mapPoi) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, cVar, mapPoi) == null) {
            LatLng position = mapPoi.getPosition();
            C0607a a2 = C0607a.a();
            a2.c("latitude", Double.valueOf(position.latitude));
            a2.c("longitude", Double.valueOf(position.longitude));
            a2.b();
            C0607a a3 = C0607a.a();
            a3.c("mapId", cVar.j);
            a3.c("name", mapPoi.getName());
            a3.c("latitude", Double.valueOf(position.latitude));
            a3.c("longitude", Double.valueOf(position.longitude));
            JSONObject b2 = a3.b();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("vtype", "poitap");
                jSONObject.put("data", b2.toString());
                jSONObject.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, cVar.f10956i);
            } catch (JSONException e2) {
                if (f10932a) {
                    e2.printStackTrace();
                }
            }
            b.a.p0.a.w2.g.c.a.d(cVar.f10956i, cVar.j, "map", "poitap", jSONObject);
        }
    }

    public static void d(c cVar, LatLng latLng) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, cVar, latLng) == null) {
            C0607a a2 = C0607a.a();
            a2.c("latitude", Double.valueOf(latLng.latitude));
            a2.c("longitude", Double.valueOf(latLng.longitude));
            JSONObject b2 = a2.b();
            C0607a a3 = C0607a.a();
            a3.c("mapId", cVar.j);
            a3.c("position", b2);
            JSONObject b3 = a3.b();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("vtype", "tap");
                jSONObject.put("data", b3.toString());
                jSONObject.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, cVar.f10956i);
            } catch (JSONException e2) {
                if (f10932a) {
                    e2.printStackTrace();
                }
            }
            b.a.p0.a.w2.g.c.a.d(cVar.f10956i, cVar.j, "map", "tap", jSONObject);
        }
    }

    public static void e(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, cVar) == null) {
            C0607a a2 = C0607a.a();
            a2.c("mapId", cVar.j);
            JSONObject b2 = a2.b();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("vtype", "updated");
                jSONObject.put("data", b2.toString());
                jSONObject.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, cVar.f10956i);
            } catch (JSONException e2) {
                if (f10932a) {
                    e2.printStackTrace();
                }
            }
            b.a.p0.a.w2.g.c.a.d(cVar.f10956i, cVar.j, "map", "updated", jSONObject);
        }
    }

    public static void f(Marker marker, c cVar) {
        d dVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, marker, cVar) == null) {
            b.a.p0.j.n.b H = cVar.H(marker);
            String str = (H == null || (dVar = H.f10945a) == null) ? "" : dVar.f5873e;
            C0607a a2 = C0607a.a();
            a2.c("mapId", cVar.j);
            a2.c("markerId", str);
            JSONObject b2 = a2.b();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("vtype", "markertap");
                jSONObject.put("data", b2.toString());
                jSONObject.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, cVar.f10956i);
            } catch (JSONException e2) {
                if (f10932a) {
                    e2.printStackTrace();
                }
            }
            b.a.p0.a.w2.g.c.a.d(cVar.f10956i, cVar.j, "map", "markertap", jSONObject);
        }
    }

    public static void g(c cVar, MapStatus mapStatus, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65543, null, cVar, mapStatus, i2) == null) {
            C0607a a2 = C0607a.a();
            a2.c("latitude", Double.valueOf(mapStatus.bound.northeast.latitude));
            a2.c("longitude", Double.valueOf(mapStatus.bound.northeast.longitude));
            JSONObject b2 = a2.b();
            C0607a a3 = C0607a.a();
            a3.c("latitude", Double.valueOf(mapStatus.bound.southwest.latitude));
            a3.c("longitude", Double.valueOf(mapStatus.bound.southwest.longitude));
            JSONObject b3 = a3.b();
            C0607a a4 = C0607a.a();
            a4.c("mapId", cVar.j);
            a4.c("northeast", b2);
            a4.c("southwest", b3);
            a4.c("scale", Float.valueOf(mapStatus.zoom));
            a4.c("reason", Integer.valueOf(i2));
            JSONObject b4 = a4.b();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("vtype", "regionchange");
                jSONObject.put("data", b4.toString());
                jSONObject.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, cVar.f10956i);
            } catch (JSONException e2) {
                if (f10932a) {
                    e2.printStackTrace();
                }
            }
            b.a.p0.a.w2.g.c.a.d(cVar.f10956i, cVar.j, "map", "regionchange", jSONObject);
        }
    }
}
