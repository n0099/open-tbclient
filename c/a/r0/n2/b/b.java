package c.a.r0.n2.b;

import c.a.q0.t.i;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<i> a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f19372b;

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

    public void a(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("user_info_list");
        if (optJSONArray != null && optJSONArray.length() != 0) {
            this.a = new ArrayList();
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                i iVar = new i();
                iVar.a(optJSONArray.optJSONObject(i2));
                this.a.add(iVar);
            }
        }
        this.f19372b = jSONObject.optInt("has_more", 0) == 1;
    }
}
