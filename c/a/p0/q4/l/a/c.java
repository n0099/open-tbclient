package c.a.p0.q4.l.a;

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
    public static final c.a.p0.m4.h.a f17786b;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f17787c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(730986220, "Lc/a/p0/q4/l/a/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(730986220, "Lc/a/p0/q4/l/a/c;");
                return;
            }
        }
        a = TimeUnit.DAYS.toMillis(5L);
        f17786b = new c.a.p0.m4.h.a("camera_last_api", 0, "camera_last_api_stamp");
        f17787c = "Lenovo K520".equals(Build.MODEL);
    }
}
