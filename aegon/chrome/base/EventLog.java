package aegon.chrome.base;

import aegon.chrome.base.annotations.CalledByNative;
/* loaded from: classes.dex */
public class EventLog {
    @CalledByNative
    public static void writeEvent(int i2, int i3) {
        android.util.EventLog.writeEvent(i2, i3);
    }
}
