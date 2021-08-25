package c.a.i0.a;

import android.content.Context;
import c.a.i0.a.d.c;
import c.a.i0.a.d.d;
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

    public c.a.i0.a.g.b a(Context context, b bVar) {
        InterceptResult invokeLL;
        JSONObject a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, context, bVar)) == null) {
            if (bVar == null || context == null || (a2 = bVar.a()) == null) {
                return null;
            }
            String optString = a2.optString("material_type");
            if ("image".equals(optString)) {
                return new c(context, a2);
            }
            if ("gif".equals(optString)) {
                return new c.a.i0.a.d.b(context, a2);
            }
            if ("video".equals(optString)) {
                return new d(context, a2);
            }
            return null;
        }
        return (c.a.i0.a.g.b) invokeLL.objValue;
    }
}
