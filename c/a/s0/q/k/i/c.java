package c.a.s0.q.k.i;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class c extends c.a.s0.q.k.b {
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

    @Override // c.a.s0.q.k.b
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
                p.b();
                jSONObject3.put("version", p.c());
                jSONObject.put("web_degrade_strategy", jSONObject3);
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("version", l.a().b());
                jSONObject.put("pkg_preload", jSONObject4);
                JSONObject jSONObject5 = new JSONObject();
                jSONObject5.put("version", b.b().c());
                jSONObject.put("pkg_clean_strategy", jSONObject5);
                JSONObject jSONObject6 = new JSONObject();
                jSONObject6.put("version", e.a().b());
                jSONObject.put("getpkg_retry_switch", jSONObject6);
                JSONObject jSONObject7 = new JSONObject();
                jSONObject7.put("version", r.d());
                jSONObject.put("update_expire_time", jSONObject7);
                JSONObject jSONObject8 = new JSONObject();
                jSONObject8.put("version", j.f().h());
                jSONObject.put("page_tips", jSONObject8);
                if (n.a) {
                    JSONObject jSONObject9 = new JSONObject();
                    jSONObject9.put("version", n.f11855b);
                    jSONObject.put("heartbeat", jSONObject9);
                }
                JSONObject jSONObject10 = new JSONObject();
                jSONObject10.put("version", g.a().b());
                jSONObject.put("local_debug", jSONObject10);
                JSONObject jSONObject11 = new JSONObject();
                jSONObject11.put("version", c.a.s0.q.c.a().a());
                jSONObject.put(c.a.s0.q.c.a().c(), jSONObject11);
                if (o.b()) {
                    JSONObject jSONObject12 = new JSONObject();
                    jSONObject12.put("version", o.a());
                    jSONObject.put("api_description", jSONObject12);
                }
                JSONObject jSONObject13 = new JSONObject();
                jSONObject13.put("version", q.b().c());
                jSONObject.put("tts", jSONObject13);
                new JSONObject().put("version", h.a().c());
                jSONObject.put("no_history_apps", jSONObject13);
                JSONObject jSONObject14 = new JSONObject();
                jSONObject14.put("version", c.a.s0.q.k.i.t.a.d());
                jSONObject.put("app_inner_preload", jSONObject14);
                JSONObject jSONObject15 = new JSONObject();
                jSONObject15.put("version", m.a().b());
                jSONObject.put("simple_control_item", jSONObject15);
            } catch (JSONException unused) {
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }
}
