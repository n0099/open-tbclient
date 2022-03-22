package c.a.n0.a.y0.c.h;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a implements c.a.n0.a.c1.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c a;

    /* renamed from: b  reason: collision with root package name */
    public int f7697b;

    /* renamed from: c  reason: collision with root package name */
    public int f7698c;

    /* renamed from: d  reason: collision with root package name */
    public int f7699d;

    /* renamed from: e  reason: collision with root package name */
    public float f7700e;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f7697b = 0;
        this.f7698c = -16777216;
        this.f7699d = -1;
        this.f7700e = 0.0f;
    }

    @Override // c.a.n0.a.c1.a
    public void a(JSONObject jSONObject) throws JSONException {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) && jSONObject != null && jSONObject.has("radius")) {
            c cVar = new c();
            this.a = cVar;
            cVar.a(jSONObject);
            if (this.a.isValid()) {
                this.f7697b = c.a.n0.a.y0.c.d.a(jSONObject.optString("color"), 0);
                this.f7698c = c.a.n0.a.y0.c.d.a(jSONObject.optString("fillColor"), -16777216);
                this.f7699d = jSONObject.optInt("radius", -1);
                this.f7700e = Math.abs(c.a.n0.a.y0.c.d.b(jSONObject.optDouble("strokeWidth", 0.0d)));
            }
        }
    }

    @Override // c.a.n0.a.c1.a
    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            c cVar = this.a;
            return (cVar == null || !cVar.isValid() || this.f7699d == -1) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return "coordinate ->" + this.a + "color ->" + this.f7697b + "fillColor ->" + this.f7698c + "radius ->" + this.f7699d + "strokeWidth ->" + this.f7700e;
        }
        return (String) invokeV.objValue;
    }
}
