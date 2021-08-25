package c.a.q0.a4.j.a;

import android.os.Build;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.concurrent.TimeUnit;
/* loaded from: classes3.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final long f15717a;

    /* renamed from: b  reason: collision with root package name */
    public static final c.a.q0.v3.i.a f15718b;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f15719c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-342689027, "Lc/a/q0/a4/j/a/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-342689027, "Lc/a/q0/a4/j/a/c;");
                return;
            }
        }
        f15717a = TimeUnit.DAYS.toMillis(5L);
        f15718b = new c.a.q0.v3.i.a("camera_last_api", 0, "camera_last_api_stamp");
        f15719c = "Lenovo K520".equals(Build.MODEL);
    }
}
