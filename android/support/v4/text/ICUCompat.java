package android.support.v4.text;

import android.os.Build;
/* loaded from: classes.dex */
public class ICUCompat {
    private static final c bm;

    static {
        if (Build.VERSION.SDK_INT >= 14) {
            bm = new e();
        } else {
            bm = new d();
        }
    }

    public static String getScript(String str) {
        return bm.getScript(str);
    }

    public static String addLikelySubtags(String str) {
        return bm.addLikelySubtags(str);
    }
}
