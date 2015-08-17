package android.support.v4.text;

import java.util.Locale;
/* loaded from: classes.dex */
public final class BidiFormatter {
    private static TextDirectionHeuristicCompat mh = TextDirectionHeuristicsCompat.FIRSTSTRONG_LTR;
    private static final String mi = Character.toString(8206);
    private static final String mj = Character.toString(8207);
    private static final BidiFormatter mk = new BidiFormatter(false, 2, mh);
    private static final BidiFormatter ml = new BidiFormatter(true, 2, mh);
    private final boolean mm;
    private final int mn;
    private final TextDirectionHeuristicCompat mo;

    /* loaded from: classes.dex */
    public static final class Builder {
        private boolean mm;
        private int mn;
        private TextDirectionHeuristicCompat mp;

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
            this.mm = z;
            this.mp = BidiFormatter.mh;
            this.mn = 2;
        }

        public Builder stereoReset(boolean z) {
            if (z) {
                this.mn |= 2;
            } else {
                this.mn &= -3;
            }
            return this;
        }

        public Builder setTextDirectionHeuristic(TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
            this.mp = textDirectionHeuristicCompat;
            return this;
        }

        private static BidiFormatter f(boolean z) {
            return z ? BidiFormatter.ml : BidiFormatter.mk;
        }

        public BidiFormatter build() {
            return (this.mn == 2 && this.mp == BidiFormatter.mh) ? f(this.mm) : new BidiFormatter(this.mm, this.mn, this.mp);
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
        this.mm = z;
        this.mn = i;
        this.mo = textDirectionHeuristicCompat;
    }

    public boolean isRtlContext() {
        return this.mm;
    }

    public boolean getStereoReset() {
        return (this.mn & 2) != 0;
    }

    private String a(String str, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        boolean isRtl = textDirectionHeuristicCompat.isRtl(str, 0, str.length());
        if (!this.mm && (isRtl || x(str) == 1)) {
            return mi;
        }
        if (this.mm && (!isRtl || x(str) == -1)) {
            return mj;
        }
        return "";
    }

    private String b(String str, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        boolean isRtl = textDirectionHeuristicCompat.isRtl(str, 0, str.length());
        if (!this.mm && (isRtl || y(str) == 1)) {
            return mi;
        }
        if (this.mm && (!isRtl || y(str) == -1)) {
            return mj;
        }
        return "";
    }

    public boolean isRtl(String str) {
        return this.mo.isRtl(str, 0, str.length());
    }

    public String unicodeWrap(String str, TextDirectionHeuristicCompat textDirectionHeuristicCompat, boolean z) {
        boolean isRtl = textDirectionHeuristicCompat.isRtl(str, 0, str.length());
        StringBuilder sb = new StringBuilder();
        if (getStereoReset() && z) {
            sb.append(b(str, isRtl ? TextDirectionHeuristicsCompat.RTL : TextDirectionHeuristicsCompat.LTR));
        }
        if (isRtl != this.mm) {
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
        return unicodeWrap(str, this.mo, z);
    }

    public String unicodeWrap(String str) {
        return unicodeWrap(str, this.mo, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean a(Locale locale) {
        return TextUtilsCompat.getLayoutDirectionFromLocale(locale) == 1;
    }

    private static int x(String str) {
        return new a(str, false).dw();
    }

    private static int y(String str) {
        return new a(str, false).dv();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private static final byte[] mq = new byte[1792];
        private final int length;
        private final boolean mr;
        private int ms;
        private char mt;
        private final String text;

        static {
            for (int i = 0; i < 1792; i++) {
                mq[i] = Character.getDirectionality(i);
            }
        }

        a(String str, boolean z) {
            this.text = str;
            this.mr = z;
            this.length = str.length();
        }

        int dv() {
            this.ms = 0;
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            while (this.ms < this.length && i == 0) {
                switch (dx()) {
                    case 0:
                        if (i3 != 0) {
                            i = i3;
                            break;
                        } else {
                            return -1;
                        }
                    case 1:
                    case 2:
                        if (i3 != 0) {
                            i = i3;
                            break;
                        } else {
                            return 1;
                        }
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 10:
                    case 11:
                    case 12:
                    case 13:
                    default:
                        i = i3;
                        break;
                    case 9:
                        break;
                    case 14:
                    case 15:
                        i3++;
                        i2 = -1;
                        break;
                    case 16:
                    case 17:
                        i3++;
                        i2 = 1;
                        break;
                    case 18:
                        i3--;
                        i2 = 0;
                        break;
                }
            }
            if (i == 0) {
                return 0;
            }
            if (i2 != 0) {
                return i2;
            }
            while (this.ms > 0) {
                switch (dy()) {
                    case 14:
                    case 15:
                        if (i != i3) {
                            i3--;
                            break;
                        } else {
                            return -1;
                        }
                    case 16:
                    case 17:
                        if (i != i3) {
                            i3--;
                            break;
                        } else {
                            return 1;
                        }
                    case 18:
                        i3++;
                        break;
                }
            }
            return 0;
        }

        int dw() {
            this.ms = this.length;
            int i = 0;
            int i2 = 0;
            while (this.ms > 0) {
                switch (dy()) {
                    case 0:
                        if (i2 != 0) {
                            if (i != 0) {
                                break;
                            } else {
                                i = i2;
                                break;
                            }
                        } else {
                            return -1;
                        }
                    case 1:
                    case 2:
                        if (i2 != 0) {
                            if (i != 0) {
                                break;
                            } else {
                                i = i2;
                                break;
                            }
                        } else {
                            return 1;
                        }
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 10:
                    case 11:
                    case 12:
                    case 13:
                    default:
                        if (i != 0) {
                            break;
                        } else {
                            i = i2;
                            break;
                        }
                    case 9:
                        break;
                    case 14:
                    case 15:
                        if (i != i2) {
                            i2--;
                            break;
                        } else {
                            return -1;
                        }
                    case 16:
                    case 17:
                        if (i != i2) {
                            i2--;
                            break;
                        } else {
                            return 1;
                        }
                    case 18:
                        i2++;
                        break;
                }
            }
            return 0;
        }

        private static byte d(char c) {
            return c < 1792 ? mq[c] : Character.getDirectionality(c);
        }

        byte dx() {
            this.mt = this.text.charAt(this.ms);
            if (Character.isHighSurrogate(this.mt)) {
                int codePointAt = Character.codePointAt(this.text, this.ms);
                this.ms += Character.charCount(codePointAt);
                return Character.getDirectionality(codePointAt);
            }
            this.ms++;
            byte d = d(this.mt);
            if (this.mr) {
                if (this.mt == '<') {
                    return dz();
                }
                if (this.mt == '&') {
                    return dB();
                }
                return d;
            }
            return d;
        }

        byte dy() {
            this.mt = this.text.charAt(this.ms - 1);
            if (Character.isLowSurrogate(this.mt)) {
                int codePointBefore = Character.codePointBefore(this.text, this.ms);
                this.ms -= Character.charCount(codePointBefore);
                return Character.getDirectionality(codePointBefore);
            }
            this.ms--;
            byte d = d(this.mt);
            if (this.mr) {
                if (this.mt == '>') {
                    return dA();
                }
                if (this.mt == ';') {
                    return dC();
                }
                return d;
            }
            return d;
        }

        private byte dz() {
            int i = this.ms;
            while (this.ms < this.length) {
                String str = this.text;
                int i2 = this.ms;
                this.ms = i2 + 1;
                this.mt = str.charAt(i2);
                if (this.mt == '>') {
                    return (byte) 12;
                }
                if (this.mt == '\"' || this.mt == '\'') {
                    char c = this.mt;
                    while (this.ms < this.length) {
                        String str2 = this.text;
                        int i3 = this.ms;
                        this.ms = i3 + 1;
                        char charAt = str2.charAt(i3);
                        this.mt = charAt;
                        if (charAt == c) {
                            break;
                        }
                    }
                }
            }
            this.ms = i;
            this.mt = '<';
            return (byte) 13;
        }

        private byte dA() {
            int i = this.ms;
            while (this.ms > 0) {
                String str = this.text;
                int i2 = this.ms - 1;
                this.ms = i2;
                this.mt = str.charAt(i2);
                if (this.mt == '<') {
                    return (byte) 12;
                }
                if (this.mt == '>') {
                    break;
                } else if (this.mt == '\"' || this.mt == '\'') {
                    char c = this.mt;
                    while (this.ms > 0) {
                        String str2 = this.text;
                        int i3 = this.ms - 1;
                        this.ms = i3;
                        char charAt = str2.charAt(i3);
                        this.mt = charAt;
                        if (charAt == c) {
                            break;
                        }
                    }
                }
            }
            this.ms = i;
            this.mt = '>';
            return (byte) 13;
        }

        private byte dB() {
            while (this.ms < this.length) {
                String str = this.text;
                int i = this.ms;
                this.ms = i + 1;
                char charAt = str.charAt(i);
                this.mt = charAt;
                if (charAt == ';') {
                    return (byte) 12;
                }
            }
            return (byte) 12;
        }

        private byte dC() {
            int i = this.ms;
            while (this.ms > 0) {
                String str = this.text;
                int i2 = this.ms - 1;
                this.ms = i2;
                this.mt = str.charAt(i2);
                if (this.mt == '&') {
                    return (byte) 12;
                }
                if (this.mt == ';') {
                    break;
                }
            }
            this.ms = i;
            this.mt = ';';
            return (byte) 13;
        }
    }
}
