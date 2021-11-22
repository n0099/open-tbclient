package b.a.p0.a.i1.c.h;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a implements b.a.p0.a.m1.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public c f6477e;

    /* renamed from: f  reason: collision with root package name */
    public int f6478f;

    /* renamed from: g  reason: collision with root package name */
    public int f6479g;

    /* renamed from: h  reason: collision with root package name */
    public int f6480h;

    /* renamed from: i  reason: collision with root package name */
    public float f6481i;

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
        this.f6478f = 0;
        this.f6479g = -16777216;
        this.f6480h = -1;
        this.f6481i = 0.0f;
    }

    @Override // b.a.p0.a.m1.a
    public void a(JSONObject jSONObject) throws JSONException {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) && jSONObject != null && jSONObject.has("radius")) {
            c cVar = new c();
            this.f6477e = cVar;
            cVar.a(jSONObject);
            if (this.f6477e.isValid()) {
                this.f6478f = b.a.p0.a.i1.c.d.a(jSONObject.optString("color"), 0);
                this.f6479g = b.a.p0.a.i1.c.d.a(jSONObject.optString("fillColor"), -16777216);
                this.f6480h = jSONObject.optInt("radius", -1);
                this.f6481i = Math.abs(b.a.p0.a.i1.c.d.b(jSONObject.optDouble("strokeWidth", 0.0d)));
            }
        }
    }

    @Override // b.a.p0.a.m1.a
    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            c cVar = this.f6477e;
            return (cVar == null || !cVar.isValid() || this.f6480h == -1) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return "coordinate ->" + this.f6477e + "color ->" + this.f6478f + "fillColor ->" + this.f6479g + "radius ->" + this.f6480h + "strokeWidth ->" + this.f6481i;
        }
        return (String) invokeV.objValue;
    }
}
