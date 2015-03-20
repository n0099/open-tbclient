package android.support.v4.text;

import android.os.Build;
/* loaded from: classes.dex */
public class ICUCompat {
    private static final c mr;

    static {
        if (Build.VERSION.SDK_INT >= 14) {
            mr = new e();
        } else {
            mr = new d();
        }
    }

    public static String getScript(String str) {
        return mr.getScript(str);
    }

    public static String addLikelySubtags(String str) {
        return mr.addLikelySubtags(str);
    }
}
