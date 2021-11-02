package b.a.p0.a.u.e.o;

import androidx.annotation.NonNull;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b extends b.a.p0.a.u.c.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NonNull b.a.p0.a.u.c.b bVar) {
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
                super((b.a.p0.a.u.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public b.a.p0.a.u.h.b q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            boolean z = b.a.p0.a.u.c.d.f8000c;
            b.a.p0.a.a2.e P = b.a.p0.a.a2.e.P();
            if (P == null) {
                return new b.a.p0.a.u.h.b(1001, "SwanApp is null");
            }
            SwanAppActivity x = P.x();
            if (x == null) {
                b.a.p0.a.e0.d.b("Api-BrightnessApi", "null activity");
                return new b.a.p0.a.u.h.b(1001, "null activity");
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("value", b.a.p0.a.n2.e.b.a.b().a(x));
                return new b.a.p0.a.u.h.b(0, jSONObject);
            } catch (JSONException e2) {
                e2.printStackTrace();
                return new b.a.p0.a.u.h.b(1001, "make result json error");
            }
        }
        return (b.a.p0.a.u.h.b) invokeV.objValue;
    }
}
