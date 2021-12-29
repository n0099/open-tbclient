package c.a.r0.a.i1.c.h;

import c.a.r0.a.z2.n0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class g implements c.a.r0.a.m1.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f7403e;

    /* renamed from: f  reason: collision with root package name */
    public int f7404f;

    /* renamed from: g  reason: collision with root package name */
    public int f7405g;

    /* renamed from: h  reason: collision with root package name */
    public int f7406h;

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
        this.f7403e = Integer.MIN_VALUE;
        this.f7404f = Integer.MIN_VALUE;
        this.f7405g = -1;
        this.f7406h = -1;
    }

    @Override // c.a.r0.a.m1.a
    public void a(JSONObject jSONObject) throws JSONException {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) && jSONObject != null && jSONObject.has("left") && jSONObject.has("top")) {
            this.f7403e = n0.g(jSONObject.optInt("left"));
            this.f7404f = n0.g(jSONObject.optInt("top"));
            this.f7405g = jSONObject.has("width") ? Math.abs(n0.g(jSONObject.optInt("width"))) : -1;
            this.f7406h = jSONObject.has("height") ? Math.abs(n0.g(jSONObject.optInt("height"))) : -1;
        }
    }

    @Override // c.a.r0.a.m1.a
    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (this.f7403e == Integer.MIN_VALUE || this.f7404f == Integer.MIN_VALUE) ? false : true : invokeV.booleanValue;
    }
}
