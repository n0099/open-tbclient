package aegon.chrome.net;

import android.net.TrafficStats;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public class ThreadStatsUid {
    public static /* synthetic */ Interceptable $ic;
    public static final Method sClearThreadStatsUid;
    public static final Method sSetThreadStatsUid;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(773892402, "Laegon/chrome/net/ThreadStatsUid;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(773892402, "Laegon/chrome/net/ThreadStatsUid;");
                return;
            }
        }
        try {
            sSetThreadStatsUid = TrafficStats.class.getMethod("setThreadStatsUid", Integer.TYPE);
            sClearThreadStatsUid = TrafficStats.class.getMethod("clearThreadStatsUid", new Class[0]);
        } catch (NoSuchMethodException | SecurityException e2) {
            throw new RuntimeException("Unable to get TrafficStats methods", e2);
        }
    }

    public static void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            try {
                sClearThreadStatsUid.invoke(null, new Object[0]);
            } catch (IllegalAccessException e2) {
                throw new RuntimeException("TrafficStats.clearThreadStatsUid failed", e2);
            } catch (InvocationTargetException e3) {
                throw new RuntimeException("TrafficStats.clearThreadStatsUid failed", e3);
            }
        }
    }

    public static void set(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65538, null, i2) == null) {
            try {
                sSetThreadStatsUid.invoke(null, Integer.valueOf(i2));
            } catch (IllegalAccessException e2) {
                throw new RuntimeException("TrafficStats.setThreadStatsUid failed", e2);
            } catch (InvocationTargetException e3) {
                throw new RuntimeException("TrafficStats.setThreadStatsUid failed", e3);
            }
        }
    }
}
