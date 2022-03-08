package c.a.p0.a.q.a.j;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
/* loaded from: classes.dex */
public class k0 implements Cloneable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f7083e;

    /* renamed from: f  reason: collision with root package name */
    public int f7084f;

    /* renamed from: g  reason: collision with root package name */
    public int f7085g;

    /* renamed from: h  reason: collision with root package name */
    public i f7086h;

    public k0(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jSONArray};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        b(jSONArray);
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            i iVar = this.f7086h;
            return iVar != null && iVar.d();
        }
        return invokeV.booleanValue;
    }

    public void b(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray) == null) {
            try {
                if (jSONArray.length() > 3) {
                    this.f7083e = c.a.p0.a.p2.n0.g((float) jSONArray.optDouble(0));
                    this.f7084f = c.a.p0.a.p2.n0.g((float) jSONArray.optDouble(1));
                    this.f7085g = jSONArray.optInt(2);
                    this.f7086h = new i(jSONArray.optJSONArray(3));
                }
            } catch (Exception e2) {
                if (c.a.p0.a.a.a) {
                    e2.printStackTrace();
                }
            }
        }
    }
}
