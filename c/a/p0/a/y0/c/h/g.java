package c.a.p0.a.y0.c.h;

import c.a.p0.a.p2.n0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class g implements c.a.p0.a.c1.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f9215e;

    /* renamed from: f  reason: collision with root package name */
    public int f9216f;

    /* renamed from: g  reason: collision with root package name */
    public int f9217g;

    /* renamed from: h  reason: collision with root package name */
    public int f9218h;

    public g() {
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
        this.f9215e = Integer.MIN_VALUE;
        this.f9216f = Integer.MIN_VALUE;
        this.f9217g = -1;
        this.f9218h = -1;
    }

    @Override // c.a.p0.a.c1.a
    public void a(JSONObject jSONObject) throws JSONException {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) && jSONObject != null && jSONObject.has("left") && jSONObject.has("top")) {
            this.f9215e = n0.g(jSONObject.optInt("left"));
            this.f9216f = n0.g(jSONObject.optInt("top"));
            this.f9217g = jSONObject.has("width") ? Math.abs(n0.g(jSONObject.optInt("width"))) : -1;
            this.f9218h = jSONObject.has("height") ? Math.abs(n0.g(jSONObject.optInt("height"))) : -1;
        }
    }

    @Override // c.a.p0.a.c1.a
    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (this.f9215e == Integer.MIN_VALUE || this.f9216f == Integer.MIN_VALUE) ? false : true : invokeV.booleanValue;
    }
}
