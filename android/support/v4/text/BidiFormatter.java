package android.support.v4.text;

import java.util.Locale;
/* loaded from: classes.dex */
public final class BidiFormatter {
    private static TextDirectionHeuristicCompat mf = TextDirectionHeuristicsCompat.FIRSTSTRONG_LTR;
    private static final String mg = Character.toString(8206);
    private static final String mh = Character.toString(8207);
    private static final BidiFormatter mi = new BidiFormatter(false, 2, mf);
    private static final BidiFormatter mj = new BidiFormatter(true, 2, mf);
    private final int mFlags;
    private final boolean mk;
    private final TextDirectionHeuristicCompat ml;

    /* loaded from: classes.dex */
    public final class Builder {
        private int mFlags;
        private boolean mk;
        private TextDirectionHeuristicCompat mm;

        public Builder() {
            e(BidiFormatter.a(Locale.getDefault()));
        }

        public Builder(boolean z) {
            e(z);
        }

        public Builder(Locale locale) {
            e(BidiFormatter.a(locale));
        }

        private void e(boolean z) {
            this.mk = z;
            this.mm = BidiFormatter.mf;
            this.mFlags = 2;
        }

        public Builder stereoReset(boolean z) {
            if (z) {
                this.mFlags |= 2;
            } else {
                this.mFlags &= -3;
            }
            return this;
        }

        public Builder setTextDirectionHeuristic(TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
            this.mm = textDirectionHeuristicCompat;
            return this;
        }

        private static BidiFormatter f(boolean z) {
            return z ? BidiFormatter.mj : BidiFormatter.mi;
        }

        public BidiFormatter build() {
            return (this.mFlags == 2 && this.mm == BidiFormatter.mf) ? f(this.mk) : new BidiFormatter(this.mk, this.mFlags, this.mm);
        }
    }

    public static BidiFormatter getInstance() {
        return new Builder().build();
    }

    public static BidiFormatter getInstance(boolean z) {
        return new Builder(z).build();
    }

    public static BidiFormatter getInstance(Locale locale) {
        return new Builder(locale).build();
    }

    private BidiFormatter(boolean z, int i, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        this.mk = z;
        this.mFlags = i;
        this.ml = textDirectionHeuristicCompat;
    }

    public boolean isRtlContext() {
        return this.mk;
    }

    public boolean getStereoReset() {
        return (this.mFlags & 2) != 0;
    }

    private String a(String str, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        boolean isRtl = textDirectionHeuristicCompat.isRtl(str, 0, str.length());
        if (!this.mk && (isRtl || x(str) == 1)) {
            return mg;
        }
        if (this.mk && (!isRtl || x(str) == -1)) {
            return mh;
        }
        return "";
    }

    private String b(String str, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        boolean isRtl = textDirectionHeuristicCompat.isRtl(str, 0, str.length());
        if (!this.mk && (isRtl || y(str) == 1)) {
            return mg;
        }
        if (this.mk && (!isRtl || y(str) == -1)) {
            return mh;
        }
        return "";
    }

    public boolean isRtl(String str) {
        return this.ml.isRtl(str, 0, str.length());
    }

    public String unicodeWrap(String str, TextDirectionHeuristicCompat textDirectionHeuristicCompat, boolean z) {
        boolean isRtl = textDirectionHeuristicCompat.isRtl(str, 0, str.length());
        StringBuilder sb = new StringBuilder();
        if (getStereoReset() && z) {
            sb.append(b(str, isRtl ? TextDirectionHeuristicsCompat.RTL : TextDirectionHeuristicsCompat.LTR));
        }
        if (isRtl != this.mk) {
            sb.append(isRtl ? (char) 8235 : (char) 8234);
            sb.append(str);
            sb.append((char) 8236);
        } else {
            sb.append(str);
        }
        if (z) {
            sb.append(a(str, isRtl ? TextDirectionHeuristicsCompat.RTL : TextDirectionHeuristicsCompat.LTR));
        }
        return sb.toString();
    }

    public String unicodeWrap(String str, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        return unicodeWrap(str, textDirectionHeuristicCompat, true);
    }

    public String unicodeWrap(String str, boolean z) {
        return unicodeWrap(str, this.ml, z);
    }

    public String unicodeWrap(String str) {
        return unicodeWrap(str, this.ml, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean a(Locale locale) {
        return TextUtilsCompat.getLayoutDirectionFromLocale(locale) == 1;
    }

    private static int x(String str) {
        return new b(str, false).dw();
    }

    private static int y(String str) {
        return new b(str, false).dv();
    }
}
