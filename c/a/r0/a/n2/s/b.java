package c.a.r0.a.n2.s;

import android.text.TextUtils;
import c.a.r0.a.f1.e.b;
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
    public String f8155k;

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
        this.f8155k = "";
    }

    @Override // c.a.r0.a.n2.s.e
    public JSONObject f() {
        InterceptResult invokeV;
        c.a.r0.a.d2.e D;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f8163h == null) {
                this.f8163h = new JSONObject();
            }
            if (TextUtils.isEmpty(this.f8155k) && (D = c.a.r0.a.g1.f.U().D()) != null) {
                b.a X = D.X();
                this.f8155k = X != null ? X.T() : "";
            }
            try {
                this.f8163h.put("source", this.f8155k);
                String b2 = c.a.r0.a.u1.l.d.b();
                if (b2 != null) {
                    this.f8163h.put("launchid", b2);
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return super.f();
        }
        return (JSONObject) invokeV.objValue;
    }
}
