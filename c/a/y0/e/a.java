package c.a.y0.e;

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
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static final AtomicBoolean a;

    /* renamed from: b  reason: collision with root package name */
    public static HashMap<Integer, Boolean> f27223b;

    /* renamed from: c  reason: collision with root package name */
    public static HashMap<Integer, Long> f27224c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1282334710, "Lc/a/y0/e/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1282334710, "Lc/a/y0/e/a;");
                return;
            }
        }
        a = new AtomicBoolean(false);
        f27223b = new HashMap<>();
        f27224c = new HashMap<>();
    }

    public static long a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i2)) == null) {
            if (f27224c.containsKey(Integer.valueOf(i2))) {
                return f27224c.get(Integer.valueOf(i2)).longValue();
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
                        HashMap<Integer, Long> hashMap = f27224c;
                        Integer valueOf = Integer.valueOf(intValue);
                        hashMap.put(valueOf, Long.valueOf(b2.getLong("cache_" + intValue, 10080L)));
                        HashMap<Integer, Boolean> hashMap2 = f27223b;
                        Integer valueOf2 = Integer.valueOf(intValue);
                        hashMap2.put(valueOf2, Boolean.valueOf(b2.getBoolean("close_" + intValue, false)));
                    }
                    f27224c.put(Integer.valueOf((int) ShareCallPacking.REQUEST_CODE_V2_SHARE_ACCOUNT), Long.MAX_VALUE);
                    f27223b.put(Integer.valueOf((int) ShareCallPacking.REQUEST_CODE_V2_SHARE_ACCOUNT), Boolean.TRUE);
                    a.set(true);
                }
            }
        }
    }

    public static boolean d(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, null, i2)) == null) {
            if (f27223b.containsKey(Integer.valueOf(i2))) {
                return f27223b.get(Integer.valueOf(i2)).booleanValue();
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
