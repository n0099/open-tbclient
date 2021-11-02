package b.a.p0.n.j.k;

import b.a.p0.n.h.h;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.ETAG;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class d extends b.a.p0.n.j.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public d() {
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

    @Override // b.a.p0.n.j.b
    public JSONArray c() {
        InterceptResult invokeV;
        List<h> n;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", "bbasp_core");
                jSONObject.put("version_name", b.a.p0.n.c.b().F(0));
                jSONObject.put("version_code", b.a.p0.n.c.b().w(0));
                jSONArray.put(jSONObject);
            } catch (JSONException e2) {
                if (b.a.p0.n.c.f11048a) {
                    e2.printStackTrace();
                }
            }
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("type", "bbasp_game");
                jSONObject2.put("version_name", b.a.p0.n.c.b().F(1));
                jSONObject2.put("version_code", b.a.p0.n.c.b().w(1));
                jSONArray.put(jSONObject2);
            } catch (JSONException e3) {
                if (b.a.p0.n.c.f11048a) {
                    e3.printStackTrace();
                }
            }
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject3.put("type", ETAG.KEY_EXTENSION);
                jSONObject3.put("version_name", b.a.p0.n.c.b().u(0));
                jSONObject3.put("version_code", b.a.p0.n.c.b().k(0));
                jSONArray.put(jSONObject3);
            } catch (JSONException e4) {
                if (b.a.p0.n.c.f11048a) {
                    e4.printStackTrace();
                }
            }
            JSONObject jSONObject4 = new JSONObject();
            try {
                jSONObject4.put("type", "extension_game");
                jSONObject4.put("version_name", b.a.p0.n.c.b().u(1));
                jSONObject4.put("version_code", b.a.p0.n.c.b().k(1));
                jSONArray.put(jSONObject4);
            } catch (JSONException e5) {
                if (b.a.p0.n.c.f11048a) {
                    e5.printStackTrace();
                }
            }
            try {
                n = b.a.p0.n.g.a.h().n(10);
            } catch (JSONException e6) {
                if (b.a.p0.n.c.f11048a) {
                    e6.printStackTrace();
                }
            }
            if (n == null) {
                return jSONArray;
            }
            for (h hVar : n) {
                JSONObject jSONObject5 = new JSONObject();
                jSONObject5.put("type", "ddl");
                jSONObject5.put("bundle_id", hVar.f11076g);
                jSONObject5.put("version_code", hVar.f11078i);
                jSONObject5.put("version_name", hVar.j);
                jSONArray.put(jSONObject5);
            }
            return jSONArray;
        }
        return (JSONArray) invokeV.objValue;
    }
}
