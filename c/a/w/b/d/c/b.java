package c.a.w.b.d.c;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public long f26572b;

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
                this.a = jSONObject.optString("start_live_scheme");
                this.f26572b = jSONObject.optLong("timeout_refresh_time");
                if (z) {
                    c.a.w.b.f.c.d("live_feed_page_config_cache_key", jSONObject.toString());
                }
            } else if (z) {
                String a = c.a.w.b.f.c.a("live_feed_page_config_cache_key", "");
                if (TextUtils.isEmpty(a)) {
                    return;
                }
                try {
                    JSONObject jSONObject2 = new JSONObject(a);
                    this.a = jSONObject2.optString("start_live_scheme");
                    this.f26572b = jSONObject2.optLong("timeout_refresh_time");
                } catch (JSONException unused) {
                    c.a.w.b.f.c.e("live_feed_page_config_cache_key");
                }
            }
        }
    }
}
