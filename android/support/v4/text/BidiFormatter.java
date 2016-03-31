package android.support.v4.text;

import java.util.Locale;
/* loaded from: classes.dex */
public final class BidiFormatter {
    private static TextDirectionHeuristicCompat mi = TextDirectionHeuristicsCompat.FIRSTSTRONG_LTR;
    private static final String mj = Character.toString(8206);
    private static final String mk = Character.toString(8207);
    private static final BidiFormatter ml = new BidiFormatter(false, 2, mi);
    private static final BidiFormatter mm = new BidiFormatter(true, 2, mi);
    private final boolean mn;
    private final int mo;
    private final TextDirectionHeuristicCompat mp;

    /* loaded from: classes.dex */
    public static final class Builder {
        private boolean mn;
        private int mo;
        private TextDirectionHeuristicCompat mq;

        public Builder() {
            d(BidiFormatter.a(Locale.getDefault()));
        }

        public Builder(boolean z) {
            d(z);
        }

        public Builder(Locale locale) {
            d(BidiFormatter.a(locale));
        }

        private void d(boolean z) {
            this.mn = z;
            this.mq = BidiFormatter.mi;
            this.mo = 2;
        }

        public Builder stereoReset(boolean z) {
            if (z) {
                this.mo |= 2;
            } else {
                this.mo &= -3;
            }
            return this;
        }

        public Builder setTextDirectionHeuristic(TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
            this.mq = textDirectionHeuristicCompat;
            return this;
        }

        private static BidiFormatter e(boolean z) {
            return z ? BidiFormatter.mm : BidiFormatter.ml;
        }

        public BidiFormatter build() {
            return (this.mo == 2 && this.mq == BidiFormatter.mi) ? e(this.mn) : new BidiFormatter(this.mn, this.mo, this.mq);
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
        this.mn = z;
        this.mo = i;
        this.mp = textDirectionHeuristicCompat;
    }

    public boolean isRtlContext() {
        return this.mn;
    }

    public boolean getStereoReset() {
        return (this.mo & 2) != 0;
    }

    private String a(String str, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        boolean isRtl = textDirectionHeuristicCompat.isRtl(str, 0, str.length());
        if (!this.mn && (isRtl || x(str) == 1)) {
            return mj;
        }
        if (this.mn && (!isRtl || x(str) == -1)) {
            return mk;
        }
        return "";
    }

    private String b(String str, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        boolean isRtl = textDirectionHeuristicCompat.isRtl(str, 0, str.length());
        if (!this.mn && (isRtl || y(str) == 1)) {
            return mj;
        }
        if (this.mn && (!isRtl || y(str) == -1)) {
            return mk;
        }
        return "";
    }

    public boolean isRtl(String str) {
        return this.mp.isRtl(str, 0, str.length());
    }

    public String unicodeWrap(String str, TextDirectionHeuristicCompat textDirectionHeuristicCompat, boolean z) {
        boolean isRtl = textDirectionHeuristicCompat.isRtl(str, 0, str.length());
        StringBuilder sb = new StringBuilder();
        if (getStereoReset() && z) {
            sb.append(b(str, isRtl ? TextDirectionHeuristicsCompat.RTL : TextDirectionHeuristicsCompat.LTR));
        }
        if (isRtl != this.mn) {
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
        return unicodeWrap(str, this.mp, z);
    }

    public String unicodeWrap(String str) {
        return unicodeWrap(str, this.mp, true);
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
        private static final byte[] mr = new byte[1792];
        private final int length;
        private final boolean ms;
        private int mt;
        private char mu;
        private final String text;

        static {
            for (int i = 0; i < 1792; i++) {
                mr[i] = Character.getDirectionality(i);
            }
        }

        a(String str, boolean z) {
            this.text = str;
            this.ms = z;
            this.length = str.length();
        }

        int dv() {
            this.mt = 0;
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            while (this.mt < this.length && i == 0) {
                switch (dz()) {
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
            while (this.mt > 0) {
                switch (dA()) {
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
            this.mt = this.length;
            int i = 0;
            int i2 = 0;
            while (this.mt > 0) {
                switch (dA()) {
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
            return c < 1792 ? mr[c] : Character.getDirectionality(c);
        }

        byte dz() {
            this.mu = this.text.charAt(this.mt);
            if (Character.isHighSurrogate(this.mu)) {
                int codePointAt = Character.codePointAt(this.text, this.mt);
                this.mt += Character.charCount(codePointAt);
                return Character.getDirectionality(codePointAt);
            }
            this.mt++;
            byte d = d(this.mu);
            if (this.ms) {
                if (this.mu == '<') {
                    return dB();
                }
                if (this.mu == '&') {
                    return dD();
                }
                return d;
            }
            return d;
        }

        byte dA() {
            this.mu = this.text.charAt(this.mt - 1);
            if (Character.isLowSurrogate(this.mu)) {
                int codePointBefore = Character.codePointBefore(this.text, this.mt);
                this.mt -= Character.charCount(codePointBefore);
                return Character.getDirectionality(codePointBefore);
            }
            this.mt--;
            byte d = d(this.mu);
            if (this.ms) {
                if (this.mu == '>') {
                    return dC();
                }
                if (this.mu == ';') {
                    return dE();
                }
                return d;
            }
            return d;
        }

        private byte dB() {
            int i = this.mt;
            while (this.mt < this.length) {
                String str = this.text;
                int i2 = this.mt;
                this.mt = i2 + 1;
                this.mu = str.charAt(i2);
                if (this.mu == '>') {
                    return (byte) 12;
                }
                if (this.mu == '\"' || this.mu == '\'') {
                    char c = this.mu;
                    while (this.mt < this.length) {
                        String str2 = this.text;
                        int i3 = this.mt;
                        this.mt = i3 + 1;
                        char charAt = str2.charAt(i3);
                        this.mu = charAt;
                        if (charAt == c) {
                            break;
                        }
                    }
                }
            }
            this.mt = i;
            this.mu = '<';
            return (byte) 13;
        }

        private byte dC() {
            int i = this.mt;
            while (this.mt > 0) {
                String str = this.text;
                int i2 = this.mt - 1;
                this.mt = i2;
                this.mu = str.charAt(i2);
                if (this.mu == '<') {
                    return (byte) 12;
                }
                if (this.mu == '>') {
                    break;
                } else if (this.mu == '\"' || this.mu == '\'') {
                    char c = this.mu;
                    while (this.mt > 0) {
                        String str2 = this.text;
                        int i3 = this.mt - 1;
                        this.mt = i3;
                        char charAt = str2.charAt(i3);
                        this.mu = charAt;
                        if (charAt == c) {
                            break;
                        }
                    }
                }
            }
            this.mt = i;
            this.mu = '>';
            return (byte) 13;
        }

        private byte dD() {
            while (this.mt < this.length) {
                String str = this.text;
                int i = this.mt;
                this.mt = i + 1;
                char charAt = str.charAt(i);
                this.mu = charAt;
                if (charAt == ';') {
                    return (byte) 12;
                }
            }
            return (byte) 12;
        }

        private byte dE() {
            int i = this.mt;
            while (this.mt > 0) {
                String str = this.text;
                int i2 = this.mt - 1;
                this.mt = i2;
                this.mu = str.charAt(i2);
                if (this.mu == '&') {
                    return (byte) 12;
                }
                if (this.mu == ';') {
                    break;
                }
            }
            this.mt = i;
            this.mu = ';';
            return (byte) 13;
        }
    }
}
