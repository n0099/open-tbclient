package c.a.p0.q.k.i;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class d extends c.a.p0.q.k.a {
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

    @Override // c.a.p0.q.k.a, c.a.p0.q.k.d
    public void b(JSONObject jSONObject, c.a.p0.q.f.i iVar, @Nullable c.a.p0.q.f.i iVar2, @Nullable c.a.p0.q.f.i iVar3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048576, this, jSONObject, iVar, iVar2, iVar3) == null) || jSONObject == null) {
            return;
        }
        f.b().e(jSONObject.optJSONObject("tipmsgs"));
        j.f().k(jSONObject.optJSONObject("page_tips"));
        b.b().d(jSONObject.optJSONObject("pkg_clean_strategy"));
        l.a().d(jSONObject.optJSONObject("pkg_preload"));
        c.a.p0.q.k.i.t.a.f(jSONObject.optJSONObject("app_inner_preload"));
        e.a().c(jSONObject.optJSONObject("getpkg_retry_switch"));
        q.b().d(jSONObject.optJSONObject("tts"));
        m.a().e(jSONObject.optJSONObject("simple_control_item"));
        r.e(jSONObject.optJSONObject("update_expire_time"));
        if (n.a) {
            c(jSONObject);
        }
        p.b().f(jSONObject.optJSONObject("web_degrade_strategy"));
        g.a().c(jSONObject.optJSONObject("local_debug"));
        c.a.p0.q.c.a().b(jSONObject.optJSONObject(c.a.p0.q.c.a().c()));
        if (o.b()) {
            i.a().b(jSONObject.optJSONObject("api_description"));
        }
        h.a().e(jSONObject.optJSONObject("no_history_apps"));
    }

    public final void c(@NonNull JSONObject jSONObject) {
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) && (optJSONObject = jSONObject.optJSONObject("heartbeat")) != null && optJSONObject.optLong("errno") == 0) {
            c.a.p0.q.a b2 = c.a.p0.q.c.b();
            c.a.p0.w.b i2 = b2 != null ? b2.i() : null;
            String optString = optJSONObject.optString("version");
            if (!TextUtils.isEmpty(optString)) {
                n.f10839b = optString;
                if (i2 != null) {
                    i2.putString("key_h2_heart_beat_version", optString);
                }
            }
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("data");
            if (optJSONObject2 != null) {
                if (optJSONObject2.optInt("switch") > 0) {
                    int optInt = optJSONObject2.optInt("timespan");
                    int optInt2 = optJSONObject2.optInt(com.alipay.sdk.data.a.O);
                    if (i2 != null) {
                        if (optInt > 0) {
                            i2.putInt("key_h2_heart_beat_timespan", optInt);
                        }
                        if (optInt2 > 0) {
                            i2.putInt("key_h2_heart_beat_timeout", optInt2);
                            return;
                        }
                        return;
                    }
                    return;
                }
                n.a = false;
            }
        }
    }
}
