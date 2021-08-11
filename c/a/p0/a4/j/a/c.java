package c.a.p0.a4.j.a;

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
    public static final long f15431a;

    /* renamed from: b  reason: collision with root package name */
    public static final c.a.p0.v3.i.a f15432b;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f15433c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-471771746, "Lc/a/p0/a4/j/a/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-471771746, "Lc/a/p0/a4/j/a/c;");
                return;
            }
        }
        f15431a = TimeUnit.DAYS.toMillis(5L);
        f15432b = new c.a.p0.v3.i.a("camera_last_api", 0, "camera_last_api_stamp");
        f15433c = "Lenovo K520".equals(Build.MODEL);
    }
}
