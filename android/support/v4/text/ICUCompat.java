package android.support.v4.text;

import android.os.Build;
import java.util.Locale;
/* loaded from: classes2.dex */
public final class ICUCompat {
    private static final a AY;

    /* loaded from: classes2.dex */
    interface a {
        String maximizeAndGetScript(Locale locale);
    }

    /* loaded from: classes2.dex */
    static class b implements a {
        b() {
        }

        @Override // android.support.v4.text.ICUCompat.a
        public String maximizeAndGetScript(Locale locale) {
            return null;
        }
    }

    /* loaded from: classes2.dex */
    static class c implements a {
        c() {
        }

        @Override // android.support.v4.text.ICUCompat.a
        public String maximizeAndGetScript(Locale locale) {
            return android.support.v4.text.b.maximizeAndGetScript(locale);
        }
    }

    /* loaded from: classes2.dex */
    static class d implements a {
        d() {
        }

        @Override // android.support.v4.text.ICUCompat.a
        public String maximizeAndGetScript(Locale locale) {
            return android.support.v4.text.a.maximizeAndGetScript(locale);
        }
    }

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 21) {
            AY = new d();
        } else if (i >= 14) {
            AY = new c();
        } else {
            AY = new b();
        }
    }

    public static String maximizeAndGetScript(Locale locale) {
        return AY.maximizeAndGetScript(locale);
    }

    private ICUCompat() {
    }
}
