package c.a.p0.j.a;

import c.a.p0.a.n2.s.e;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class b extends e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: k  reason: collision with root package name */
    public String f9960k;

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
        this.f9960k = "";
    }

    @Override // c.a.p0.a.n2.s.e
    public JSONObject f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f7119h == null) {
                this.f7119h = new JSONObject();
            }
            try {
                this.f7119h.put("error_code", this.f9960k);
            } catch (JSONException e2) {
                if (e.f7112j) {
                    e2.printStackTrace();
                }
            }
            if (e.f7112j) {
                String str = "SwanGameAdEvent: mExt=" + this.f7119h + "\t " + Thread.currentThread().getId();
            }
            return super.f();
        }
        return (JSONObject) invokeV.objValue;
    }
}
