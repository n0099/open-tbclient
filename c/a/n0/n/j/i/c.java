package c.a.n0.n.j.i;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c extends c.a.n0.n.j.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public c() {
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

    @Override // c.a.n0.n.j.b
    public JSONObject d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("version", f.b().d());
                jSONObject.put("tipmsgs", jSONObject2);
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("version", k.a().b());
                jSONObject.put("pkg_preload", jSONObject3);
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("version", b.b().c());
                jSONObject.put("pkg_clean_strategy", jSONObject4);
                JSONObject jSONObject5 = new JSONObject();
                jSONObject5.put("version", e.a().b());
                jSONObject.put("getpkg_retry_switch", jSONObject5);
                JSONObject jSONObject6 = new JSONObject();
                jSONObject6.put("version", o.d());
                jSONObject.put("update_expire_time", jSONObject6);
                JSONObject jSONObject7 = new JSONObject();
                jSONObject7.put("version", i.b().d());
                jSONObject.put("page_tips", jSONObject7);
                if (l.f11755a) {
                    JSONObject jSONObject8 = new JSONObject();
                    jSONObject8.put("version", l.f11756b);
                    jSONObject.put("heartbeat", jSONObject8);
                }
                JSONObject jSONObject9 = new JSONObject();
                jSONObject9.put("version", g.a().b());
                jSONObject.put("local_debug", jSONObject9);
                JSONObject jSONObject10 = new JSONObject();
                jSONObject10.put("version", c.a.n0.n.c.a().a());
                jSONObject.put(c.a.n0.n.c.a().c(), jSONObject10);
                if (m.b()) {
                    JSONObject jSONObject11 = new JSONObject();
                    jSONObject11.put("version", m.a());
                    jSONObject.put("api_description", jSONObject11);
                }
                JSONObject jSONObject12 = new JSONObject();
                jSONObject12.put("version", n.b().c());
                jSONObject.put("tts", jSONObject12);
            } catch (JSONException e2) {
                if (c.a.n0.n.c.f11582a) {
                    e2.printStackTrace();
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }
}
