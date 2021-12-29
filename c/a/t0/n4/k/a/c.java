package c.a.t0.n4.k.a;

import android.os.Build;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.concurrent.TimeUnit;
/* loaded from: classes7.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public static final long a;

    /* renamed from: b  reason: collision with root package name */
    public static final c.a.t0.j4.i.a f20463b;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f20464c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1948883258, "Lc/a/t0/n4/k/a/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1948883258, "Lc/a/t0/n4/k/a/c;");
                return;
            }
        }
        a = TimeUnit.DAYS.toMillis(5L);
        f20463b = new c.a.t0.j4.i.a("camera_last_api", 0, "camera_last_api_stamp");
        f20464c = "Lenovo K520".equals(Build.MODEL);
    }
}
