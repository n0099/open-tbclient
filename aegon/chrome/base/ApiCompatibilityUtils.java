package aegon.chrome.base;

import android.annotation.TargetApi;
import android.content.Context;
@TargetApi(21)
/* loaded from: classes5.dex */
public class ApiCompatibilityUtils {
    static {
        ApiCompatibilityUtils.class.desiredAssertionStatus();
    }

    public static int checkPermission(Context context, String str, int i, int i2) {
        try {
            return context.checkPermission(str, i, i2);
        } catch (RuntimeException e) {
            return -1;
        }
    }
}
