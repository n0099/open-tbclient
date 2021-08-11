package c.a.v.b.d.c;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f29982a;

    /* renamed from: b  reason: collision with root package name */
    public long f29983b;

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

    public void a(JSONObject jSONObject, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048576, this, jSONObject, z) == null) {
            if (jSONObject != null) {
                this.f29982a = jSONObject.optString("start_live_scheme");
                this.f29983b = jSONObject.optLong("timeout_refresh_time");
                if (z) {
                    c.a.v.b.f.c.d("live_feed_page_config_cache_key", jSONObject.toString());
                }
            } else if (z) {
                String a2 = c.a.v.b.f.c.a("live_feed_page_config_cache_key", "");
                if (TextUtils.isEmpty(a2)) {
                    return;
                }
                try {
                    JSONObject jSONObject2 = new JSONObject(a2);
                    this.f29982a = jSONObject2.optString("start_live_scheme");
                    this.f29983b = jSONObject2.optLong("timeout_refresh_time");
                } catch (JSONException unused) {
                    c.a.v.b.f.c.e("live_feed_page_config_cache_key");
                }
            }
        }
    }
}
