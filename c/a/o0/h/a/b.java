package c.a.o0.h.a;

import c.a.o0.a.j2.p.e;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
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

    @Override // c.a.o0.a.j2.p.e
    public JSONObject f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f7042h == null) {
                this.f7042h = new JSONObject();
            }
            try {
                this.f7042h.put("error_code", this.k);
            } catch (JSONException e2) {
                if (e.f7034j) {
                    e2.printStackTrace();
                }
            }
            if (e.f7034j) {
                String str = "SwanGameAdEvent: mExt=" + this.f7042h + "\t " + Thread.currentThread().getId();
            }
            return super.f();
        }
        return (JSONObject) invokeV.objValue;
    }
}
