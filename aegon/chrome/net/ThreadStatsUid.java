package aegon.chrome.net;

import android.net.TrafficStats;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public class ThreadStatsUid {
    public static final Method sClearThreadStatsUid;
    public static final Method sSetThreadStatsUid;

    static {
        try {
            sSetThreadStatsUid = TrafficStats.class.getMethod("setThreadStatsUid", Integer.TYPE);
            sClearThreadStatsUid = TrafficStats.class.getMethod("clearThreadStatsUid", new Class[0]);
        } catch (NoSuchMethodException | SecurityException e2) {
            throw new RuntimeException("Unable to get TrafficStats methods", e2);
        }
    }

    public static void clear() {
        try {
            sClearThreadStatsUid.invoke(null, new Object[0]);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("TrafficStats.clearThreadStatsUid failed", e2);
        } catch (InvocationTargetException e3) {
            throw new RuntimeException("TrafficStats.clearThreadStatsUid failed", e3);
        }
    }

    public static void set(int i2) {
        try {
            sSetThreadStatsUid.invoke(null, Integer.valueOf(i2));
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("TrafficStats.setThreadStatsUid failed", e2);
        } catch (InvocationTargetException e3) {
            throw new RuntimeException("TrafficStats.setThreadStatsUid failed", e3);
        }
    }
}
