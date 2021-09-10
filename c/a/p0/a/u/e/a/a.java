package c.a.p0.a.u.e.a;

import android.content.Context;
import androidx.annotation.NonNull;
import c.a.p0.a.a2.e;
import c.a.p0.a.p.c.i;
import c.a.p0.a.p.d.n;
import c.a.p0.a.s.a.f;
import c.a.p0.a.v2.w;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a extends c.a.p0.a.u.c.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NonNull c.a.p0.a.u.c.b bVar) {
        super(bVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((c.a.p0.a.u.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static boolean s(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            boolean h2 = f.f8492d.h();
            if (h2) {
                return h2;
            }
            n a0 = c.a.p0.a.c1.a.a0();
            return a0 instanceof i ? ((i) a0).k(context) : h2;
        }
        return invokeL.booleanValue;
    }

    public c.a.p0.a.u.h.b r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            boolean z = c.a.p0.a.u.c.d.f8727c;
            if (e.Q() == null) {
                return new c.a.p0.a.u.h.b(1001, "SwanApp is null");
            }
            boolean s = s(i());
            JSONObject jSONObject = new JSONObject();
            w.f(jSONObject, "isBaiduAccount", Boolean.valueOf(s));
            return new c.a.p0.a.u.h.b(0, jSONObject);
        }
        return (c.a.p0.a.u.h.b) invokeV.objValue;
    }
}
