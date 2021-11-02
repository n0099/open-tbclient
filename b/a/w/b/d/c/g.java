package b.a.w.b.d.c;

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
/* loaded from: classes6.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f29221a;

    /* renamed from: b  reason: collision with root package name */
    public String f29222b;

    /* renamed from: c  reason: collision with root package name */
    public List<LiveTabEntity> f29223c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f29224d;

    /* renamed from: e  reason: collision with root package name */
    public long f29225e;

    /* renamed from: f  reason: collision with root package name */
    public int f29226f;

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
        this.f29223c = new ArrayList();
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i2);
            if (optJSONObject != null) {
                LiveTabEntity liveTabEntity = new LiveTabEntity();
                liveTabEntity.parserJson(optJSONObject);
                this.f29223c.add(liveTabEntity);
            }
        }
    }

    public void b(JSONObject jSONObject, boolean z, int i2) {
        List<LiveTabEntity> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{jSONObject, Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            if (jSONObject != null) {
                this.f29221a = jSONObject.optInt("inner_errno");
                this.f29222b = jSONObject.optString("inner_msg");
                JSONArray optJSONArray = jSONObject.optJSONArray("items");
                a(optJSONArray);
                if (z && optJSONArray != null && (list = this.f29223c) != null && !list.isEmpty()) {
                    b.a.w.b.f.c.c("live_feed_page_tab_cache_time", System.currentTimeMillis());
                    b.a.w.b.f.c.d("live_feed_page_tab_cache_key", optJSONArray.toString());
                }
            }
            if ((z && this.f29223c == null) || this.f29223c.isEmpty()) {
                this.f29226f = 2;
                String a2 = b.a.w.b.f.c.a("live_feed_page_tab_cache_key", "");
                if (TextUtils.isEmpty(a2)) {
                    return;
                }
                try {
                    a(new JSONArray(a2));
                    this.f29224d = true;
                    if (i2 == -101) {
                        this.f29226f = 1;
                    } else if (this.f29221a != 0) {
                        this.f29226f = 3;
                    }
                    this.f29225e = b.a.w.b.f.c.b("live_feed_page_tab_cache_time", 0L);
                } catch (JSONException unused) {
                    b.a.w.b.f.c.e("live_feed_page_tab_cache_key");
                    b.a.w.b.f.c.e("live_feed_page_tab_cache_time");
                }
            }
        }
    }
}
