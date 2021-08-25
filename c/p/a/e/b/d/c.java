package c.p.a.e.b.d;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static volatile String f34970a = "";

    /* renamed from: b  reason: collision with root package name */
    public static volatile String f34971b = "";

    /* renamed from: c  reason: collision with root package name */
    public static volatile String f34972c = "";

    /* renamed from: d  reason: collision with root package name */
    public static long f34973d = 512000;

    /* renamed from: e  reason: collision with root package name */
    public static long f34974e = 50;

    /* renamed from: f  reason: collision with root package name */
    public static long f34975f = 5242880;

    /* renamed from: g  reason: collision with root package name */
    public static final JSONObject f34976g;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1473568097, "Lc/p/a/e/b/d/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1473568097, "Lc/p/a/e/b/d/c;");
                return;
            }
        }
        f34976g = new JSONObject();
    }

    public static void a(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, null, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        f34970a = str;
    }
}
