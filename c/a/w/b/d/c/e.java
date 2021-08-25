package c.a.w.b.d.c;

import c.a.w.e.g.j;
import com.baidu.android.util.io.DocumentOpenUtil;
import com.baidu.live.business.model.data.LiveHostInfo;
import com.baidu.swan.apps.relateswans.SwanAppRelatedSwanListAdapter;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public List<d> f30341a;

    public e() {
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

    public void a(JSONObject jSONObject) {
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        jSONObject.optInt("inner_errno");
        jSONObject.optString("inner_msg");
        JSONArray optJSONArray = jSONObject.optJSONArray("items");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            this.f30341a = new ArrayList();
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                JSONObject optJSONObject2 = optJSONArray.optJSONObject(i2);
                if (optJSONObject2 != null) {
                    d dVar = new d();
                    dVar.a(optJSONObject2);
                    this.f30341a.add(dVar);
                }
            }
        }
        if (c.a.w.e.g.d.c(this.f30341a) || (optJSONObject = jSONObject.optJSONObject(SwanAppRelatedSwanListAdapter.PAGE_ABOUT_MORE_RELATED_SWAN)) == null) {
            return;
        }
        String optString = optJSONObject.optString("scheme");
        if (j.a(optString)) {
            return;
        }
        d dVar2 = new d();
        dVar2.f30337d = optString;
        dVar2.f30334a = true;
        LiveHostInfo liveHostInfo = new LiveHostInfo();
        liveHostInfo.name = optJSONObject.optString(DocumentOpenUtil.TXT);
        dVar2.f30338e = liveHostInfo;
        this.f30341a.add(dVar2);
    }
}
