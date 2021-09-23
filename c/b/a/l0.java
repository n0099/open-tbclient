package c.b.a;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes4.dex */
public final class l0 {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final AtomicBoolean f31388a;

    /* renamed from: b  reason: collision with root package name */
    public static String f31389b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2074078108, "Lc/b/a/l0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2074078108, "Lc/b/a/l0;");
                return;
            }
        }
        f31388a = new AtomicBoolean(false);
        f31389b = "";
    }

    public static String a(SharedPreferences sharedPreferences) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, sharedPreferences)) == null) {
            if (f31388a.compareAndSet(false, true)) {
                String string = sharedPreferences.getString("cdid", "");
                f31389b = string;
                if (TextUtils.isEmpty(string)) {
                    f31389b = UUID.randomUUID().toString();
                    sharedPreferences.edit().putString("cdid", f31389b).apply();
                }
            }
            return f31389b;
        }
        return (String) invokeL.objValue;
    }
}
