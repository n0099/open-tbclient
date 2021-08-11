package c.a.n0.a.c0.c.f;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class b extends c.a.n0.a.c0.a.a.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String O;
    public boolean P;
    public boolean Q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b() {
        super("input", "viewId");
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
    }

    @Override // c.a.n0.a.c0.a.a.b, c.a.n0.a.c0.a.c.c, c.a.n0.a.c0.a.d.b, c.a.n0.a.c0.b.b, c.a.n0.a.l1.a
    public void a(JSONObject jSONObject) throws JSONException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        super.a(jSONObject);
        if (this.l == null) {
            this.l = new c.a.n0.a.l1.e.a.a();
        }
        this.x = jSONObject.optString("value");
        this.O = jSONObject.optString("type");
        this.P = jSONObject.optInt("confirmHold") == 1;
        this.Q = jSONObject.optInt("adjustPosition", 1) == 1;
    }
}
