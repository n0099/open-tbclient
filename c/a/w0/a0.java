package c.a.w0;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONException;
/* loaded from: classes9.dex */
public class a0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(l0 l0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65536, null, l0Var) == null) || l0Var == null || l0Var.y()) {
            return;
        }
        JSONArray n = l0Var.n();
        int length = n.length();
        boolean B = l0Var.B();
        for (int i2 = 0; i2 < length; i2++) {
            try {
                if (B != g.o().e(n.getJSONObject(i2).getString("id"))) {
                    String str = " data is " + B + "  content " + l0Var.u().toString();
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, str) == null) {
        }
    }
}
