package aegon.chrome.base;

import aegon.chrome.base.annotations.CalledByNative;
import android.os.StrictMode;
import java.util.TimeZone;
/* loaded from: classes5.dex */
public class TimezoneUtils {
    @CalledByNative
    public static String getDefaultTimeZoneId() {
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        String id = TimeZone.getDefault().getID();
        StrictMode.setThreadPolicy(allowThreadDiskReads);
        return id;
    }
}
