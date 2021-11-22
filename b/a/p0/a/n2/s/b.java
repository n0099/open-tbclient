package b.a.p0.a.n2.s;

import android.text.TextUtils;
import b.a.p0.a.f1.e.b;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.k = "";
    }

    @Override // b.a.p0.a.n2.s.e
    public JSONObject f() {
        InterceptResult invokeV;
        b.a.p0.a.d2.e D;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f7386h == null) {
                this.f7386h = new JSONObject();
            }
            if (TextUtils.isEmpty(this.k) && (D = b.a.p0.a.g1.f.U().D()) != null) {
                b.a X = D.X();
                this.k = X != null ? X.T() : "";
            }
            try {
                this.f7386h.put("source", this.k);
                String b2 = b.a.p0.a.u1.l.d.b();
                if (b2 != null) {
                    this.f7386h.put("launchid", b2);
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return super.f();
        }
        return (JSONObject) invokeV.objValue;
    }
}
