package b.a.r0.d4.j.a;

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
    public static final long f17067a;

    /* renamed from: b  reason: collision with root package name */
    public static final b.a.r0.z3.i.a f17068b;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f17069c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-830468224, "Lb/a/r0/d4/j/a/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-830468224, "Lb/a/r0/d4/j/a/c;");
                return;
            }
        }
        f17067a = TimeUnit.DAYS.toMillis(5L);
        f17068b = new b.a.r0.z3.i.a("camera_last_api", 0, "camera_last_api_stamp");
        f17069c = "Lenovo K520".equals(Build.MODEL);
    }
}
