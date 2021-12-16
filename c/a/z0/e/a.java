package c.a.z0.e;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.core.view.InputDeviceCompat;
import com.baidu.sapi2.share.ShareCallPacking;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static final AtomicBoolean a;

    /* renamed from: b  reason: collision with root package name */
    public static HashMap<Integer, Boolean> f27616b;

    /* renamed from: c  reason: collision with root package name */
    public static HashMap<Integer, Long> f27617c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2125128905, "Lc/a/z0/e/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2125128905, "Lc/a/z0/e/a;");
                return;
            }
        }
        a = new AtomicBoolean(false);
        f27616b = new HashMap<>();
        f27617c = new HashMap<>();
    }

    public static long a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i2)) == null) {
            if (f27617c.containsKey(Integer.valueOf(i2))) {
                return f27617c.get(Integer.valueOf(i2)).longValue();
            }
            return Long.MAX_VALUE;
        }
        return invokeI.longValue;
    }

    public static SharedPreferences b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) ? context.getSharedPreferences("CONFIG_RUNTIME", 0) : (SharedPreferences) invokeL.objValue;
    }

    public static synchronized void c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, context) == null) {
            synchronized (a.class) {
                if (!a.get()) {
                    SharedPreferences b2 = b(context);
                    Iterator<Integer> it = b.a.iterator();
                    while (it.hasNext()) {
                        int intValue = it.next().intValue();
                        HashMap<Integer, Long> hashMap = f27617c;
                        Integer valueOf = Integer.valueOf(intValue);
                        hashMap.put(valueOf, Long.valueOf(b2.getLong("cache_" + intValue, 10080L)));
                        HashMap<Integer, Boolean> hashMap2 = f27616b;
                        Integer valueOf2 = Integer.valueOf(intValue);
                        hashMap2.put(valueOf2, Boolean.valueOf(b2.getBoolean("close_" + intValue, false)));
                    }
                    f27617c.put(Integer.valueOf((int) ShareCallPacking.REQUEST_CODE_V2_SHARE_ACCOUNT), Long.MAX_VALUE);
                    f27616b.put(Integer.valueOf((int) ShareCallPacking.REQUEST_CODE_V2_SHARE_ACCOUNT), Boolean.TRUE);
                    a.set(true);
                }
            }
        }
    }

    public static boolean d(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, null, i2)) == null) {
            if (f27616b.containsKey(Integer.valueOf(i2))) {
                return f27616b.get(Integer.valueOf(i2)).booleanValue();
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public static boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }
}
