package c.a.p0.a.s.c.f;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class b extends c.a.p0.a.s.a.a.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String P;
    public boolean Q;
    public boolean R;

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

    @Override // c.a.p0.a.s.a.a.b, c.a.p0.a.s.a.c.c, c.a.p0.a.s.a.d.b, c.a.p0.a.s.b.b, c.a.p0.a.c1.a
    public void a(JSONObject jSONObject) throws JSONException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        super.a(jSONObject);
        if (this.l == null) {
            this.l = new c.a.p0.a.c1.e.a.a();
        }
        this.x = jSONObject.optString("value");
        this.P = jSONObject.optString("type");
        this.Q = jSONObject.optInt("confirmHold") == 1;
        this.R = jSONObject.optInt("adjustPosition", 1) == 1;
    }
}
