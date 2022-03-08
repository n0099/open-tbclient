package c.a.r0.o4.k.a;

import android.os.Build;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.concurrent.TimeUnit;
/* loaded from: classes2.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public static final long a;

    /* renamed from: b  reason: collision with root package name */
    public static final c.a.r0.k4.i.a f20535b;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f20536c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(280464137, "Lc/a/r0/o4/k/a/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(280464137, "Lc/a/r0/o4/k/a/c;");
                return;
            }
        }
        a = TimeUnit.DAYS.toMillis(5L);
        f20535b = new c.a.r0.k4.i.a("camera_last_api", 0, "camera_last_api_stamp");
        f20536c = "Lenovo K520".equals(Build.MODEL);
    }
}
