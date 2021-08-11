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
/* loaded from: classes4.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f30006a;

    /* renamed from: b  reason: collision with root package name */
    public String f30007b;

    /* renamed from: c  reason: collision with root package name */
    public List<LiveTabEntity> f30008c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f30009d;

    /* renamed from: e  reason: collision with root package name */
    public long f30010e;

    /* renamed from: f  reason: collision with root package name */
    public int f30011f;

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
        this.f30008c = new ArrayList();
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i2);
            if (optJSONObject != null) {
                LiveTabEntity liveTabEntity = new LiveTabEntity();
                liveTabEntity.parserJson(optJSONObject);
                this.f30008c.add(liveTabEntity);
            }
        }
    }

    public void b(JSONObject jSONObject, boolean z, int i2) {
        List<LiveTabEntity> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{jSONObject, Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            if (jSONObject != null) {
                this.f30006a = jSONObject.optInt("inner_errno");
                this.f30007b = jSONObject.optString("inner_msg");
                JSONArray optJSONArray = jSONObject.optJSONArray("items");
                a(optJSONArray);
                if (z && optJSONArray != null && (list = this.f30008c) != null && !list.isEmpty()) {
                    c.a.v.b.f.c.c("live_feed_page_tab_cache_time", System.currentTimeMillis());
                    c.a.v.b.f.c.d("live_feed_page_tab_cache_key", optJSONArray.toString());
                }
            }
            if ((z && this.f30008c == null) || this.f30008c.isEmpty()) {
                this.f30011f = 2;
                String a2 = c.a.v.b.f.c.a("live_feed_page_tab_cache_key", "");
                if (TextUtils.isEmpty(a2)) {
                    return;
                }
                try {
                    a(new JSONArray(a2));
                    this.f30009d = true;
                    if (i2 == -101) {
                        this.f30011f = 1;
                    } else if (this.f30006a != 0) {
                        this.f30011f = 3;
                    }
                    this.f30010e = c.a.v.b.f.c.b("live_feed_page_tab_cache_time", 0L);
                } catch (JSONException unused) {
                    c.a.v.b.f.c.e("live_feed_page_tab_cache_key");
                    c.a.v.b.f.c.e("live_feed_page_tab_cache_time");
                }
            }
        }
    }
}
