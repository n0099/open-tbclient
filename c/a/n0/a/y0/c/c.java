package c.a.n0.a.y0.c;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tachikoma.core.component.anim.AnimationProperty;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c extends c.a.n0.a.s.b.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.n0.a.y0.c.h.c j;
    public double k;
    public List<c.a.n0.a.y0.c.h.d> l;
    public List<c.a.n0.a.y0.c.h.f> m;
    public List<c.a.n0.a.y0.c.h.a> n;
    public List<c.a.n0.a.y0.c.h.b> o;
    public List<c.a.n0.a.y0.c.h.c> p;
    public List<c.a.n0.a.y0.c.h.e> q;
    public boolean r;
    public boolean s;
    public boolean t;
    public boolean u;
    public boolean v;
    public boolean w;
    public boolean x;
    public String y;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c() {
        super("map", "mapId");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr = newInitContext.callArgs;
                super((String) objArr[0], (String) objArr[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.k = 16.0d;
        this.r = true;
        this.y = "";
    }

    @Override // c.a.n0.a.s.b.b, c.a.n0.a.c1.a
    public void a(JSONObject jSONObject) throws JSONException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
            String str = "markers";
            if (jSONObject == null) {
                return;
            }
            super.a(jSONObject);
            if (jSONObject.has("longitude") && jSONObject.has("latitude")) {
                c.a.n0.a.y0.c.h.c cVar = new c.a.n0.a.y0.c.h.c();
                this.j = cVar;
                cVar.a(jSONObject);
            }
            if (jSONObject.has(AnimationProperty.SCALE)) {
                this.k = jSONObject.optDouble(AnimationProperty.SCALE, 16.0d);
            }
            jSONObject.optString("subkey", "");
            jSONObject.optString("layerStyle", "");
            this.y = jSONObject.optString("cb");
            this.r = jSONObject.optBoolean("showLocation", true);
            this.s = jSONObject.optBoolean("enableZoom", true);
            this.t = jSONObject.optBoolean("enableScroll", true);
            this.u = jSONObject.optBoolean("enableRotate", false);
            this.v = jSONObject.optBoolean("showCompass", false);
            this.w = jSONObject.optBoolean("enableOverlooking", false);
            this.x = jSONObject.optBoolean("enable3D", false);
            try {
                if (!jSONObject.has("markers")) {
                    str = "covers";
                }
                this.l = h(jSONObject, str, c.a.n0.a.y0.c.h.d.class);
                this.n = h(jSONObject, "circles", c.a.n0.a.y0.c.h.a.class);
                this.m = h(jSONObject, "polyline", c.a.n0.a.y0.c.h.f.class);
                this.o = h(jSONObject, "controls", c.a.n0.a.y0.c.h.b.class);
                this.p = h(jSONObject, "includePoints", c.a.n0.a.y0.c.h.c.class);
                this.q = h(jSONObject, "polygons", c.a.n0.a.y0.c.h.e.class);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public final <T extends c.a.n0.a.c1.a> List<T> h(JSONObject jSONObject, String str, Class<T> cls) throws IllegalAccessException, InstantiationException, JSONException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject, str, cls)) == null) {
            if (jSONObject.has(str)) {
                JSONArray optJSONArray = jSONObject.optJSONArray(str);
                int length = optJSONArray == null ? 0 : optJSONArray.length();
                if (length > 0) {
                    ArrayList arrayList = new ArrayList(length);
                    for (int i = 0; i < length; i++) {
                        JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                        if (optJSONObject != null) {
                            T newInstance = cls.newInstance();
                            newInstance.a(optJSONObject);
                            if (newInstance.isValid()) {
                                arrayList.add(newInstance);
                            }
                        }
                    }
                    return arrayList;
                }
            }
            return null;
        }
        return (List) invokeLLL.objValue;
    }
}
