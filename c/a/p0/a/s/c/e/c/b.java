package c.a.p0.a.s.c.e.c;

import c.a.p0.a.s.a.c.c;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class b extends c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int H;
    public String I;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b() {
        super("coverView", "viewId");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr = newInitContext.callArgs;
                super((String) objArr[0], (String) objArr[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.I = "";
    }

    @Override // c.a.p0.a.s.a.c.c, c.a.p0.a.s.a.d.b, c.a.p0.a.s.b.b, c.a.p0.a.c1.a
    public void a(JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        super.a(jSONObject);
        this.H = jSONObject.optInt("scrollTop");
        JSONObject jSONObject3 = this.n;
        if (jSONObject3 != null) {
            this.I = jSONObject3.optString("overflowY");
        }
        c.a.p0.a.c1.e.a.a aVar = this.l;
        if (aVar == null || (jSONObject2 = this.n) == null) {
            return;
        }
        aVar.j(jSONObject2.optBoolean("fixed", false));
    }
}
