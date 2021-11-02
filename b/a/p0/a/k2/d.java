package b.a.p0.a.k2;

import android.net.Uri;
import android.text.TextUtils;
import b.a.p0.a.a2.e;
import b.a.p0.a.k;
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

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f6433a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1327395849, "Lb/a/p0/a/k2/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1327395849, "Lb/a/p0/a/k2/d;");
                return;
            }
        }
        f6433a = k.f6397a;
    }

    public static boolean a() {
        InterceptResult invokeV;
        String V;
        String queryParameter;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            e P = e.P();
            if (P == null || (V = P.K().V()) == null || (queryParameter = Uri.parse(V).getQueryParameter("params")) == null) {
                return false;
            }
            try {
            } catch (JSONException e2) {
                if (f6433a) {
                    e2.printStackTrace();
                }
            }
            return TextUtils.equals(new JSONObject(queryParameter).optString("forcePath"), "homepage");
        }
        return invokeV.booleanValue;
    }
}
