package c.a.p0.a.j2.p;

import android.text.TextUtils;
import c.a.p0.a.f1.e.b;
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

    @Override // c.a.p0.a.j2.p.e
    public JSONObject f() {
        InterceptResult invokeV;
        c.a.p0.a.a2.e F;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f7078h == null) {
                this.f7078h = new JSONObject();
            }
            if (TextUtils.isEmpty(this.k) && (F = c.a.p0.a.g1.f.V().F()) != null) {
                b.a N = F.N();
                this.k = N != null ? N.T() : "";
            }
            try {
                this.f7078h.put("source", this.k);
                String a2 = c.a.p0.a.r1.l.d.a();
                if (a2 != null) {
                    this.f7078h.put("launchid", a2);
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return super.f();
        }
        return (JSONObject) invokeV.objValue;
    }
}
