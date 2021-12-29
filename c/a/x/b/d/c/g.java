package c.a.x.b.d.c;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.business.model.data.LiveTabEntity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public String f27421b;

    /* renamed from: c  reason: collision with root package name */
    public List<LiveTabEntity> f27422c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f27423d;

    /* renamed from: e  reason: collision with root package name */
    public long f27424e;

    /* renamed from: f  reason: collision with root package name */
    public int f27425f;

    public g() {
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

    public final void a(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) || jSONArray == null || jSONArray.length() <= 0) {
            return;
        }
        this.f27422c = new ArrayList();
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i2);
            if (optJSONObject != null) {
                LiveTabEntity liveTabEntity = new LiveTabEntity();
                liveTabEntity.parserJson(optJSONObject);
                this.f27422c.add(liveTabEntity);
            }
        }
    }

    public void b(JSONObject jSONObject, boolean z, int i2) {
        List<LiveTabEntity> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{jSONObject, Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            if (jSONObject != null) {
                this.a = jSONObject.optInt("inner_errno");
                this.f27421b = jSONObject.optString("inner_msg");
                JSONArray optJSONArray = jSONObject.optJSONArray("items");
                a(optJSONArray);
                if (z && optJSONArray != null && (list = this.f27422c) != null && !list.isEmpty()) {
                    c.a.x.b.f.c.e("live_feed_page_tab_cache_time", System.currentTimeMillis());
                    c.a.x.b.f.c.f("live_feed_page_tab_cache_key", optJSONArray.toString());
                }
            }
            if (z) {
                List<LiveTabEntity> list2 = this.f27422c;
                if (list2 == null || list2.isEmpty()) {
                    this.f27425f = 2;
                    String b2 = c.a.x.b.f.c.b("live_feed_page_tab_cache_key", "");
                    if (TextUtils.isEmpty(b2)) {
                        return;
                    }
                    try {
                        a(new JSONArray(b2));
                        this.f27423d = true;
                        if (i2 == -101) {
                            this.f27425f = 1;
                        } else if (this.a != 0) {
                            this.f27425f = 3;
                        }
                        this.f27424e = c.a.x.b.f.c.c("live_feed_page_tab_cache_time", 0L);
                    } catch (JSONException unused) {
                        c.a.x.b.f.c.g("live_feed_page_tab_cache_key");
                        c.a.x.b.f.c.g("live_feed_page_tab_cache_time");
                    }
                }
            }
        }
    }
}
