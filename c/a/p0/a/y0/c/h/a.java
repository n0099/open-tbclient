package c.a.p0.a.y0.c.h;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a implements c.a.p0.a.c1.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public c f9180e;

    /* renamed from: f  reason: collision with root package name */
    public int f9181f;

    /* renamed from: g  reason: collision with root package name */
    public int f9182g;

    /* renamed from: h  reason: collision with root package name */
    public int f9183h;

    /* renamed from: i  reason: collision with root package name */
    public float f9184i;

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
        this.f9181f = 0;
        this.f9182g = -16777216;
        this.f9183h = -1;
        this.f9184i = 0.0f;
    }

    @Override // c.a.p0.a.c1.a
    public void a(JSONObject jSONObject) throws JSONException {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) && jSONObject != null && jSONObject.has("radius")) {
            c cVar = new c();
            this.f9180e = cVar;
            cVar.a(jSONObject);
            if (this.f9180e.isValid()) {
                this.f9181f = c.a.p0.a.y0.c.d.a(jSONObject.optString("color"), 0);
                this.f9182g = c.a.p0.a.y0.c.d.a(jSONObject.optString("fillColor"), -16777216);
                this.f9183h = jSONObject.optInt("radius", -1);
                this.f9184i = Math.abs(c.a.p0.a.y0.c.d.b(jSONObject.optDouble("strokeWidth", 0.0d)));
            }
        }
    }

    @Override // c.a.p0.a.c1.a
    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            c cVar = this.f9180e;
            return (cVar == null || !cVar.isValid() || this.f9183h == -1) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return "coordinate ->" + this.f9180e + "color ->" + this.f9181f + "fillColor ->" + this.f9182g + "radius ->" + this.f9183h + "strokeWidth ->" + this.f9184i;
        }
        return (String) invokeV.objValue;
    }
}
