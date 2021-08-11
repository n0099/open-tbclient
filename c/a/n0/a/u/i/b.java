package c.a.n0.a.u.i;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import c.a.n0.a.k;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f8901a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-708715250, "Lc/a/n0/a/u/i/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-708715250, "Lc/a/n0/a/u/i/b;");
                return;
            }
        }
        f8901a = k.f6803a;
    }

    @NonNull
    public static Pair<c.a.n0.a.u.h.b, JSONObject> a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) ? b("Api-Utils", str) : (Pair) invokeL.objValue;
    }

    @NonNull
    public static Pair<c.a.n0.a.u.h.b, JSONObject> b(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) {
            TextUtils.isEmpty(str);
            if (TextUtils.isEmpty(str2)) {
                boolean z = f8901a;
                return new Pair<>(new c.a.n0.a.u.h.b(202, "parseJson: json str is empty"), new JSONObject());
            }
            try {
                return new Pair<>(new c.a.n0.a.u.h.b(0), new JSONObject(str2));
            } catch (JSONException e2) {
                if (f8901a) {
                    e2.printStackTrace();
                }
                return new Pair<>(new c.a.n0.a.u.h.b(202, "parseJson: with exception "), new JSONObject());
            }
        }
        return (Pair) invokeLL.objValue;
    }
}
