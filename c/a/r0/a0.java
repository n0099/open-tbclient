package c.a.r0;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONException;
/* loaded from: classes4.dex */
public class a0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(j0 j0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65536, null, j0Var) == null) || j0Var == null || j0Var.x()) {
            return;
        }
        JSONArray m = j0Var.m();
        int length = m.length();
        boolean A = j0Var.A();
        for (int i2 = 0; i2 < length; i2++) {
            try {
                if (A != g.n().e(m.getJSONObject(i2).getString("id"))) {
                    String str = " data is " + A + "  content " + j0Var.t().toString();
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
