package c.a.r0.a.i1.c.h;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a implements c.a.r0.a.m1.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public c f7347e;

    /* renamed from: f  reason: collision with root package name */
    public int f7348f;

    /* renamed from: g  reason: collision with root package name */
    public int f7349g;

    /* renamed from: h  reason: collision with root package name */
    public int f7350h;

    /* renamed from: i  reason: collision with root package name */
    public float f7351i;

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
                return;
            }
        }
        this.f7348f = 0;
        this.f7349g = -16777216;
        this.f7350h = -1;
        this.f7351i = 0.0f;
    }

    @Override // c.a.r0.a.m1.a
    public void a(JSONObject jSONObject) throws JSONException {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) && jSONObject != null && jSONObject.has("radius")) {
            c cVar = new c();
            this.f7347e = cVar;
            cVar.a(jSONObject);
            if (this.f7347e.isValid()) {
                this.f7348f = c.a.r0.a.i1.c.d.a(jSONObject.optString("color"), 0);
                this.f7349g = c.a.r0.a.i1.c.d.a(jSONObject.optString("fillColor"), -16777216);
                this.f7350h = jSONObject.optInt("radius", -1);
                this.f7351i = Math.abs(c.a.r0.a.i1.c.d.b(jSONObject.optDouble("strokeWidth", 0.0d)));
            }
        }
    }

    @Override // c.a.r0.a.m1.a
    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            c cVar = this.f7347e;
            return (cVar == null || !cVar.isValid() || this.f7350h == -1) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return "coordinate ->" + this.f7347e + "color ->" + this.f7348f + "fillColor ->" + this.f7349g + "radius ->" + this.f7350h + "strokeWidth ->" + this.f7351i;
        }
        return (String) invokeV.objValue;
    }
}
