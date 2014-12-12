package android.support.v4.text;

import java.util.Locale;
/* loaded from: classes.dex */
public final class BidiFormatter {
    private static TextDirectionHeuristicCompat aZ = TextDirectionHeuristicsCompat.FIRSTSTRONG_LTR;
    private static final String ba = Character.toString(8206);
    private static final String bb = Character.toString(8207);
    private static final BidiFormatter bc = new BidiFormatter(false, 2, aZ);
    private static final BidiFormatter bd = new BidiFormatter(true, 2, aZ);
    private final boolean be;
    private final TextDirectionHeuristicCompat bf;
    private final int mFlags;

    /* loaded from: classes.dex */
    public final class Builder {
        private boolean be;
        private TextDirectionHeuristicCompat bh;
        private int mFlags;

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
            this.be = z;
            this.bh = BidiFormatter.aZ;
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
            this.bh = textDirectionHeuristicCompat;
            return this;
        }

        private static BidiFormatter f(boolean z) {
            return z ? BidiFormatter.bd : BidiFormatter.bc;
        }

        public BidiFormatter build() {
            return (this.mFlags == 2 && this.bh == BidiFormatter.aZ) ? f(this.be) : new BidiFormatter(this.be, this.mFlags, this.bh);
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
        this.be = z;
        this.mFlags = i;
        this.bf = textDirectionHeuristicCompat;
    }

    public boolean isRtlContext() {
        return this.be;
    }

    public boolean getStereoReset() {
        return (this.mFlags & 2) != 0;
    }

    private String a(String str, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        boolean isRtl = textDirectionHeuristicCompat.isRtl(str, 0, str.length());
        if (!this.be && (isRtl || n(str) == 1)) {
            return ba;
        }
        if (this.be && (!isRtl || n(str) == -1)) {
            return bb;
        }
        return "";
    }

    private String b(String str, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        boolean isRtl = textDirectionHeuristicCompat.isRtl(str, 0, str.length());
        if (!this.be && (isRtl || o(str) == 1)) {
            return ba;
        }
        if (this.be && (!isRtl || o(str) == -1)) {
            return bb;
        }
        return "";
    }

    public boolean isRtl(String str) {
        return this.bf.isRtl(str, 0, str.length());
    }

    public String unicodeWrap(String str, TextDirectionHeuristicCompat textDirectionHeuristicCompat, boolean z) {
        boolean isRtl = textDirectionHeuristicCompat.isRtl(str, 0, str.length());
        StringBuilder sb = new StringBuilder();
        if (getStereoReset() && z) {
            sb.append(b(str, isRtl ? TextDirectionHeuristicsCompat.RTL : TextDirectionHeuristicsCompat.LTR));
        }
        if (isRtl != this.be) {
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
        return unicodeWrap(str, this.bf, z);
    }

    public String unicodeWrap(String str) {
        return unicodeWrap(str, this.bf, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean a(Locale locale) {
        return TextUtilsCompat.getLayoutDirectionFromLocale(locale) == 1;
    }

    private static int n(String str) {
        return new b(str, false).Y();
    }

    private static int o(String str) {
        return new b(str, false).X();
    }
}
