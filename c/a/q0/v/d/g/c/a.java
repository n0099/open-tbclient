package c.a.q0.v.d.g.c;

import c.a.p0.s.q.c2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f25303a;

    /* renamed from: b  reason: collision with root package name */
    public String f25304b;

    /* renamed from: c  reason: collision with root package name */
    public List<c2> f25305c;

    /* renamed from: d  reason: collision with root package name */
    public int f25306d;

    /* renamed from: e  reason: collision with root package name */
    public int f25307e;

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

    public void a(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        this.f25303a = jSONObject.optString("head_pic");
        jSONObject.optString("url_type");
        this.f25304b = jSONObject.optString("url");
        this.f25306d = jSONObject.optInt("head_type", 0);
        this.f25307e = jSONObject.optInt("is_set", -1);
        JSONArray optJSONArray = jSONObject.optJSONArray("head_thread");
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            return;
        }
        this.f25305c = new ArrayList(optJSONArray.length());
        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
            JSONObject jSONObject2 = (JSONObject) optJSONArray.opt(i2);
            if (jSONObject2 != null) {
                c2 c2Var = new c2();
                c2Var.R2(jSONObject2);
                this.f25305c.add(c2Var);
            }
        }
    }
}
