package android.support.v4.text;

import java.util.Locale;
/* loaded from: classes.dex */
public class TextUtilsCompat {
    public static final Locale ROOT = new Locale("", "");
    private static String mG = "Arab";
    private static String mH = "Hebr";

    public static String htmlEncode(String str) {
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

    public static int getLayoutDirectionFromLocale(Locale locale) {
        if (locale != null && !locale.equals(ROOT)) {
            String script = ICUCompat.getScript(ICUCompat.addLikelySubtags(locale.toString()));
            if (script == null) {
                return c(locale);
            }
            if (script.equalsIgnoreCase(mG) || script.equalsIgnoreCase(mH)) {
                return 1;
            }
        }
        return 0;
    }

    private static int c(Locale locale) {
        switch (Character.getDirectionality(locale.getDisplayName(locale).charAt(0))) {
            case 1:
            case 2:
                return 1;
            default:
                return 0;
        }
    }
}
