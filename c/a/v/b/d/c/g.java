package c.a.v.b.d.c;

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
/* loaded from: classes3.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public String f21443b;

    /* renamed from: c  reason: collision with root package name */
    public List<LiveTabEntity> f21444c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f21445d;

    /* renamed from: e  reason: collision with root package name */
    public long f21446e;

    /* renamed from: f  reason: collision with root package name */
    public int f21447f;

    public g() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
        this.f21444c = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                LiveTabEntity liveTabEntity = new LiveTabEntity();
                liveTabEntity.parserJson(optJSONObject);
                this.f21444c.add(liveTabEntity);
            }
        }
    }

    public void b(JSONObject jSONObject, boolean z, int i) {
        List<LiveTabEntity> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{jSONObject, Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            if (jSONObject != null) {
                this.a = jSONObject.optInt("inner_errno");
                this.f21443b = jSONObject.optString("inner_msg");
                JSONArray optJSONArray = jSONObject.optJSONArray("items");
                a(optJSONArray);
                if (z && optJSONArray != null && (list = this.f21444c) != null && !list.isEmpty()) {
                    c.a.v.b.f.c.e("live_feed_page_tab_cache_time", System.currentTimeMillis());
                    c.a.v.b.f.c.f("live_feed_page_tab_cache_key", optJSONArray.toString());
                }
            }
            if (z) {
                List<LiveTabEntity> list2 = this.f21444c;
                if (list2 == null || list2.isEmpty()) {
                    this.f21447f = 2;
                    String b2 = c.a.v.b.f.c.b("live_feed_page_tab_cache_key", "");
                    if (TextUtils.isEmpty(b2)) {
                        return;
                    }
                    try {
                        a(new JSONArray(b2));
                        this.f21445d = true;
                        if (i == -101) {
                            this.f21447f = 1;
                        } else if (this.a != 0) {
                            this.f21447f = 3;
                        }
                        this.f21446e = c.a.v.b.f.c.c("live_feed_page_tab_cache_time", 0L);
                    } catch (JSONException unused) {
                        c.a.v.b.f.c.g("live_feed_page_tab_cache_key");
                        c.a.v.b.f.c.g("live_feed_page_tab_cache_time");
                    }
                }
            }
        }
    }
}
