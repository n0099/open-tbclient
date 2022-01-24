package c.a.t0.n4.k.a;

import android.os.Build;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.concurrent.TimeUnit;
/* loaded from: classes8.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public static final long a;

    /* renamed from: b  reason: collision with root package name */
    public static final c.a.t0.j4.i.a f20016b;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f20017c;
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
        f20016b = new c.a.t0.j4.i.a("camera_last_api", 0, "camera_last_api_stamp");
        f20017c = "Lenovo K520".equals(Build.MODEL);
    }
}
