package c.a.n0.a.e2;

import android.net.Uri;
import android.text.TextUtils;
import c.a.n0.a.t1.e;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1209323108, "Lc/a/n0/a/e2/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1209323108, "Lc/a/n0/a/e2/d;");
                return;
            }
        }
        a = c.a.n0.a.a.a;
    }

    public static boolean a() {
        InterceptResult invokeV;
        String W;
        String queryParameter;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            e a0 = e.a0();
            if (a0 == null || (W = a0.V().W()) == null || (queryParameter = Uri.parse(W).getQueryParameter("params")) == null) {
                return false;
            }
            try {
            } catch (JSONException e2) {
                if (a) {
                    e2.printStackTrace();
                }
            }
            return TextUtils.equals(new JSONObject(queryParameter).optString("forcePath"), "homepage");
        }
        return invokeV.booleanValue;
    }
}
