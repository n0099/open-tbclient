package c.a.w.b.d.c;

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
/* loaded from: classes7.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public String f26591b;

    /* renamed from: c  reason: collision with root package name */
    public List<LiveTabEntity> f26592c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f26593d;

    /* renamed from: e  reason: collision with root package name */
    public long f26594e;

    /* renamed from: f  reason: collision with root package name */
    public int f26595f;

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
        this.f26592c = new ArrayList();
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i2);
            if (optJSONObject != null) {
                LiveTabEntity liveTabEntity = new LiveTabEntity();
                liveTabEntity.parserJson(optJSONObject);
                this.f26592c.add(liveTabEntity);
            }
        }
    }

    public void b(JSONObject jSONObject, boolean z, int i2) {
        List<LiveTabEntity> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{jSONObject, Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            if (jSONObject != null) {
                this.a = jSONObject.optInt("inner_errno");
                this.f26591b = jSONObject.optString("inner_msg");
                JSONArray optJSONArray = jSONObject.optJSONArray("items");
                a(optJSONArray);
                if (z && optJSONArray != null && (list = this.f26592c) != null && !list.isEmpty()) {
                    c.a.w.b.f.c.c("live_feed_page_tab_cache_time", System.currentTimeMillis());
                    c.a.w.b.f.c.d("live_feed_page_tab_cache_key", optJSONArray.toString());
                }
            }
            if ((z && this.f26592c == null) || this.f26592c.isEmpty()) {
                this.f26595f = 2;
                String a = c.a.w.b.f.c.a("live_feed_page_tab_cache_key", "");
                if (TextUtils.isEmpty(a)) {
                    return;
                }
                try {
                    a(new JSONArray(a));
                    this.f26593d = true;
                    if (i2 == -101) {
                        this.f26595f = 1;
                    } else if (this.a != 0) {
                        this.f26595f = 3;
                    }
                    this.f26594e = c.a.w.b.f.c.b("live_feed_page_tab_cache_time", 0L);
                } catch (JSONException unused) {
                    c.a.w.b.f.c.e("live_feed_page_tab_cache_key");
                    c.a.w.b.f.c.e("live_feed_page_tab_cache_time");
                }
            }
        }
    }
}
