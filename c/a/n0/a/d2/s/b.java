package c.a.n0.a.d2.s;

import android.text.TextUtils;
import c.a.n0.a.v0.e.b;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b extends e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String k;

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.k = "";
    }

    @Override // c.a.n0.a.d2.s.e
    public JSONObject f() {
        InterceptResult invokeV;
        c.a.n0.a.t1.e D;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f4194h == null) {
                this.f4194h = new JSONObject();
            }
            if (TextUtils.isEmpty(this.k) && (D = c.a.n0.a.w0.f.U().D()) != null) {
                b.a X = D.X();
                this.k = X != null ? X.T() : "";
            }
            try {
                this.f4194h.put("source", this.k);
                String b2 = c.a.n0.a.k1.l.d.b();
                if (b2 != null) {
                    this.f4194h.put("launchid", b2);
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return super.f();
        }
        return (JSONObject) invokeV.objValue;
    }
}
