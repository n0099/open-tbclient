package c.a.r0.a.i1.c;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tachikoma.core.component.anim.AnimationProperty;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class f extends c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String D;
    public c.a.r0.a.i1.c.h.c E;
    public double F;
    public int G;

    public f() {
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
        this.D = "";
        this.G = 1000;
    }

    @Override // c.a.r0.a.i1.c.c, c.a.r0.a.c0.b.b, c.a.r0.a.m1.a
    public void a(JSONObject jSONObject) throws JSONException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        super.a(jSONObject);
        this.D = jSONObject.optString("markerId");
        c.a.r0.a.i1.c.h.c cVar = new c.a.r0.a.i1.c.h.c();
        this.E = cVar;
        cVar.a(jSONObject.optJSONObject("destination"));
        jSONObject.optBoolean("autoRotate");
        this.F = jSONObject.optDouble(AnimationProperty.ROTATE);
        this.G = Math.abs(jSONObject.optInt("duration", this.G));
    }

    @Override // c.a.r0.a.c0.b.b, c.a.r0.a.m1.a
    public boolean isValid() {
        InterceptResult invokeV;
        c.a.r0.a.i1.c.h.c cVar;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (TextUtils.isEmpty(this.f5451g) || TextUtils.isEmpty(this.f5450f) || TextUtils.isEmpty(this.D) || (cVar = this.E) == null || !cVar.isValid()) ? false : true : invokeV.booleanValue;
    }
}
