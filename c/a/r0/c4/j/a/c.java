package c.a.r0.c4.j.a;

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
    public static final long f16422a;

    /* renamed from: b  reason: collision with root package name */
    public static final c.a.r0.x3.i.a f16423b;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f16424c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(466452062, "Lc/a/r0/c4/j/a/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(466452062, "Lc/a/r0/c4/j/a/c;");
                return;
            }
        }
        f16422a = TimeUnit.DAYS.toMillis(5L);
        f16423b = new c.a.r0.x3.i.a("camera_last_api", 0, "camera_last_api_stamp");
        f16424c = "Lenovo K520".equals(Build.MODEL);
    }
}
