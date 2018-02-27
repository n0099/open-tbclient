package android.support.v4.text;

import android.os.Build;
import java.util.Locale;
/* loaded from: classes2.dex */
public final class TextUtilsCompat {
    private static final a Bi;
    static String Bj;
    static String Bk;
    public static final Locale ROOT;

    /* loaded from: classes2.dex */
    private static class a {
        a() {
        }

        public String htmlEncode(String str) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < str.length(); i++) {
                char charAt = str.charAt(i);
                switch (charAt) {
                    case '\"':
                        sb.append("&quot;");
                        break;
                    case '&':
                        sb.append("&amp;");
                        break;
                    case '\'':
                        sb.append("&#39;");
                        break;
                    case '<':
                        sb.append("&lt;");
                        break;
                    case '>':
                        sb.append("&gt;");
                        break;
                    default:
                        sb.append(charAt);
                        break;
                }
            }
            return sb.toString();
        }

        public int getLayoutDirectionFromLocale(Locale locale) {
            if (locale != null && !locale.equals(TextUtilsCompat.ROOT)) {
                String maximizeAndGetScript = ICUCompat.maximizeAndGetScript(locale);
                if (maximizeAndGetScript == null) {
                    return d(locale);
                }
                if (maximizeAndGetScript.equalsIgnoreCase(TextUtilsCompat.Bj) || maximizeAndGetScript.equalsIgnoreCase(TextUtilsCompat.Bk)) {
                    return 1;
                }
            }
            return 0;
        }

        private static int d(Locale locale) {
            switch (Character.getDirectionality(locale.getDisplayName(locale).charAt(0))) {
                case 1:
                case 2:
                    return 1;
                default:
                    return 0;
            }
        }
    }

    /* loaded from: classes2.dex */
    private static class b extends a {
        b() {
        }

        @Override // android.support.v4.text.TextUtilsCompat.a
        public String htmlEncode(String str) {
            return c.htmlEncode(str);
        }

        @Override // android.support.v4.text.TextUtilsCompat.a
        public int getLayoutDirectionFromLocale(Locale locale) {
            return c.getLayoutDirectionFromLocale(locale);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 17) {
            Bi = new b();
        } else {
            Bi = new a();
        }
        ROOT = new Locale("", "");
        Bj = "Arab";
        Bk = "Hebr";
    }

    public static String htmlEncode(String str) {
        return Bi.htmlEncode(str);
    }

    public static int getLayoutDirectionFromLocale(Locale locale) {
        return Bi.getLayoutDirectionFromLocale(locale);
    }

    private TextUtilsCompat() {
    }
}
