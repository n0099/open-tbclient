package c.a.q0.a.n2.s;

import android.text.TextUtils;
import c.a.q0.a.f1.e.b;
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

    /* renamed from: k  reason: collision with root package name */
    public String f7420k;

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
                return;
            }
        }
        this.f7420k = "";
    }

    @Override // c.a.q0.a.n2.s.e
    public JSONObject f() {
        InterceptResult invokeV;
        c.a.q0.a.d2.e D;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f7428h == null) {
                this.f7428h = new JSONObject();
            }
            if (TextUtils.isEmpty(this.f7420k) && (D = c.a.q0.a.g1.f.U().D()) != null) {
                b.a X = D.X();
                this.f7420k = X != null ? X.T() : "";
            }
            try {
                this.f7428h.put("source", this.f7420k);
                String b2 = c.a.q0.a.u1.l.d.b();
                if (b2 != null) {
                    this.f7428h.put("launchid", b2);
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return super.f();
        }
        return (JSONObject) invokeV.objValue;
    }
}
