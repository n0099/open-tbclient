package aegon.chrome.base;

import android.annotation.TargetApi;
import android.content.Context;
@TargetApi(21)
/* loaded from: classes.dex */
public class ApiCompatibilityUtils {
    static {
        ApiCompatibilityUtils.class.desiredAssertionStatus();
    }

    public static int checkPermission(Context context, String str, int i2, int i3) {
        try {
            return context.checkPermission(str, i2, i3);
        } catch (RuntimeException unused) {
            return -1;
        }
    }
}
