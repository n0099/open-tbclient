package c.a.n0.a.h1.c.h;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a implements c.a.n0.a.l1.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public c f6250e;

    /* renamed from: f  reason: collision with root package name */
    public int f6251f;

    /* renamed from: g  reason: collision with root package name */
    public int f6252g;

    /* renamed from: h  reason: collision with root package name */
    public int f6253h;

    /* renamed from: i  reason: collision with root package name */
    public float f6254i;

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
        this.f6251f = 0;
        this.f6252g = -16777216;
        this.f6253h = -1;
        this.f6254i = 0.0f;
    }

    @Override // c.a.n0.a.l1.a
    public void a(JSONObject jSONObject) throws JSONException {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) && jSONObject != null && jSONObject.has("radius")) {
            c cVar = new c();
            this.f6250e = cVar;
            cVar.a(jSONObject);
            if (this.f6250e.isValid()) {
                this.f6251f = c.a.n0.a.h1.c.d.a(jSONObject.optString("color"), 0);
                this.f6252g = c.a.n0.a.h1.c.d.a(jSONObject.optString("fillColor"), -16777216);
                this.f6253h = jSONObject.optInt("radius", -1);
                this.f6254i = Math.abs(c.a.n0.a.h1.c.d.b(jSONObject.optDouble("strokeWidth", 0.0d)));
            }
        }
    }

    @Override // c.a.n0.a.l1.a
    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            c cVar = this.f6250e;
            return (cVar == null || !cVar.isValid() || this.f6253h == -1) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return "coordinate ->" + this.f6250e + "color ->" + this.f6251f + "fillColor ->" + this.f6252g + "radius ->" + this.f6253h + "strokeWidth ->" + this.f6254i;
        }
        return (String) invokeV.objValue;
    }
}
