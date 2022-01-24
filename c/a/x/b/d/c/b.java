package c.a.x.b.d.c;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public long f26607b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f26608c;

    /* renamed from: d  reason: collision with root package name */
    public a f26609d;

    /* loaded from: classes9.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;

        /* renamed from: b  reason: collision with root package name */
        public int f26610b;

        public a() {
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

        public static a a(JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
                if (jSONObject != null) {
                    a aVar = new a();
                    aVar.a = jSONObject.optInt(com.baidu.fsg.face.base.b.c.l) == 1;
                    aVar.f26610b = jSONObject.optInt("max_auto_play_count");
                    return aVar;
                }
                return null;
            }
            return (a) invokeL.objValue;
        }
    }

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
                this.f26607b = jSONObject.optLong("timeout_refresh_time");
                this.f26608c = jSONObject.optInt("feed_search_switch") == 1;
                this.f26609d = a.a(jSONObject.optJSONObject("auto_play"));
                if (z) {
                    c.a.x.b.f.c.f("live_feed_page_config_cache_key", jSONObject.toString());
                }
            } else if (z) {
                String b2 = c.a.x.b.f.c.b("live_feed_page_config_cache_key", "");
                if (TextUtils.isEmpty(b2)) {
                    return;
                }
                try {
                    JSONObject jSONObject2 = new JSONObject(b2);
                    this.a = jSONObject2.optString("start_live_scheme");
                    this.f26607b = jSONObject2.optLong("timeout_refresh_time");
                    this.f26608c = jSONObject2.optInt("feed_search_switch") == 1;
                    this.f26609d = a.a(jSONObject2.optJSONObject("auto_play"));
                } catch (JSONException unused) {
                    c.a.x.b.f.c.g("live_feed_page_config_cache_key");
                }
            }
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            a aVar = this.f26609d;
            if (aVar != null) {
                return aVar.a;
            }
            return false;
        }
        return invokeV.booleanValue;
    }
}
