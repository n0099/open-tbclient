package b.a.r0.c4.j.a;

import android.os.Build;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.concurrent.TimeUnit;
/* loaded from: classes4.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final long f15435a;

    /* renamed from: b  reason: collision with root package name */
    public static final b.a.r0.y3.i.a f15436b;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f15437c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(976986239, "Lb/a/r0/c4/j/a/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(976986239, "Lb/a/r0/c4/j/a/c;");
                return;
            }
        }
        f15435a = TimeUnit.DAYS.toMillis(5L);
        f15436b = new b.a.r0.y3.i.a("camera_last_api", 0, "camera_last_api_stamp");
        f15437c = "Lenovo K520".equals(Build.MODEL);
    }
}
