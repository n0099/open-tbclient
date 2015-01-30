package android.support.v4.text;

import android.os.Build;
/* loaded from: classes.dex */
public class ICUCompat {
    private static final c bn;

    static {
        if (Build.VERSION.SDK_INT >= 14) {
            bn = new e();
        } else {
            bn = new d();
        }
    }

    public static String getScript(String str) {
        return bn.getScript(str);
    }

    public static String addLikelySubtags(String str) {
        return bn.addLikelySubtags(str);
    }
}
