package c.a.o0.h.h0;

import c.a.o0.a.j2.p.e;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int k;
    public String l;
    public int m;
    public int n;
    public long o;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
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
                this.f7042h.put("stage", this.k);
                this.f7042h.put("errMsg", this.l);
                this.f7042h.put("netStatus", this.m);
                this.f7042h.put("touch", this.n);
                this.f7042h.put("stuck_interval", this.o);
            } catch (JSONException e2) {
                if (e.f7034j) {
                    e2.printStackTrace();
                }
            }
            return super.f();
        }
        return (JSONObject) invokeV.objValue;
    }
}
