package c.a.r0.b4.j.a;

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
    public static final long f16260a;

    /* renamed from: b  reason: collision with root package name */
    public static final c.a.r0.w3.i.a f16261b;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f16262c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2021060771, "Lc/a/r0/b4/j/a/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2021060771, "Lc/a/r0/b4/j/a/c;");
                return;
            }
        }
        f16260a = TimeUnit.DAYS.toMillis(5L);
        f16261b = new c.a.r0.w3.i.a("camera_last_api", 0, "camera_last_api_stamp");
        f16262c = "Lenovo K520".equals(Build.MODEL);
    }
}
