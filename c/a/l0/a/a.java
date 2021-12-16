package c.a.l0.a;

import android.content.Context;
import c.a.l0.a.e.d;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

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
            }
        }
    }

    public c.a.l0.a.h.b a(Context context, b bVar) {
        InterceptResult invokeLL;
        JSONObject a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, context, bVar)) == null) {
            if (bVar == null || context == null || (a = bVar.a()) == null) {
                return null;
            }
            String optString = a.optString("material_type");
            if ("image".equals(optString)) {
                return new c.a.l0.a.e.c(context, a);
            }
            if ("gif".equals(optString)) {
                return new c.a.l0.a.e.b(context, a);
            }
            if ("video".equals(optString)) {
                return new d(context, a);
            }
            return null;
        }
        return (c.a.l0.a.h.b) invokeLL.objValue;
    }
}
