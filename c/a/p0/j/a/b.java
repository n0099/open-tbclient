package c.a.p0.j.a;

import c.a.p0.a.d2.s.e;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
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

    @Override // c.a.p0.a.d2.s.e
    public JSONObject f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f4953h == null) {
                this.f4953h = new JSONObject();
            }
            try {
                this.f4953h.put("error_code", this.k);
            } catch (JSONException e2) {
                if (e.f4946j) {
                    e2.printStackTrace();
                }
            }
            if (e.f4946j) {
                String str = "SwanGameAdEvent: mExt=" + this.f4953h + "\t " + Thread.currentThread().getId();
            }
            return super.f();
        }
        return (JSONObject) invokeV.objValue;
    }
}
