package android.support.v4.text;

import android.os.Build;
/* loaded from: classes.dex */
public class ICUCompat {
    private static final a mw;

    /* loaded from: classes.dex */
    interface a {
        String addLikelySubtags(String str);

        String getScript(String str);
    }

    /* loaded from: classes.dex */
    static class b implements a {
        b() {
        }

        @Override // android.support.v4.text.ICUCompat.a
        public String getScript(String str) {
            return null;
        }

        @Override // android.support.v4.text.ICUCompat.a
        public String addLikelySubtags(String str) {
            return str;
        }
    }

    /* loaded from: classes.dex */
    static class c implements a {
        c() {
        }

        @Override // android.support.v4.text.ICUCompat.a
        public String getScript(String str) {
            return android.support.v4.text.a.getScript(str);
        }

        @Override // android.support.v4.text.ICUCompat.a
        public String addLikelySubtags(String str) {
            return android.support.v4.text.a.addLikelySubtags(str);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 14) {
            mw = new c();
        } else {
            mw = new b();
        }
    }

    public static String getScript(String str) {
        return mw.getScript(str);
    }

    public static String addLikelySubtags(String str) {
        return mw.addLikelySubtags(str);
    }
}
