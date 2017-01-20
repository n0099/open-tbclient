package android.support.v4.text;

import java.util.Locale;
/* loaded from: classes.dex */
public final class BidiFormatter {
    private static TextDirectionHeuristicCompat ch = TextDirectionHeuristicsCompat.FIRSTSTRONG_LTR;
    private static final String ci = Character.toString(8206);
    private static final String cj = Character.toString(8207);
    private static final BidiFormatter ck = new BidiFormatter(false, 2, ch);
    private static final BidiFormatter cl = new BidiFormatter(true, 2, ch);
    private final boolean cm;
    private final int cn;
    private final TextDirectionHeuristicCompat co;

    /* loaded from: classes.dex */
    public static final class Builder {
        private boolean cm;
        private int cn;
        private TextDirectionHeuristicCompat cp;

        public Builder() {
            f(BidiFormatter.a(Locale.getDefault()));
        }

        public Builder(boolean z) {
            f(z);
        }

        public Builder(Locale locale) {
            f(BidiFormatter.a(locale));
        }

        private void f(boolean z) {
            this.cm = z;
            this.cp = BidiFormatter.ch;
            this.cn = 2;
        }

        public Builder stereoReset(boolean z) {
            if (z) {
                this.cn |= 2;
            } else {
                this.cn &= -3;
            }
            return this;
        }

        public Builder setTextDirectionHeuristic(TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
            this.cp = textDirectionHeuristicCompat;
            return this;
        }

        private static BidiFormatter g(boolean z) {
            return z ? BidiFormatter.cl : BidiFormatter.ck;
        }

        public BidiFormatter build() {
            return (this.cn == 2 && this.cp == BidiFormatter.ch) ? g(this.cm) : new BidiFormatter(this.cm, this.cn, this.cp);
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
        this.cm = z;
        this.cn = i;
        this.co = textDirectionHeuristicCompat;
    }

    public boolean isRtlContext() {
        return this.cm;
    }

    public boolean getStereoReset() {
        return (this.cn & 2) != 0;
    }

    private String a(String str, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        boolean isRtl = textDirectionHeuristicCompat.isRtl(str, 0, str.length());
        if (!this.cm && (isRtl || m(str) == 1)) {
            return ci;
        }
        if (this.cm && (!isRtl || m(str) == -1)) {
            return cj;
        }
        return "";
    }

    private String b(String str, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        boolean isRtl = textDirectionHeuristicCompat.isRtl(str, 0, str.length());
        if (!this.cm && (isRtl || n(str) == 1)) {
            return ci;
        }
        if (this.cm && (!isRtl || n(str) == -1)) {
            return cj;
        }
        return "";
    }

    public boolean isRtl(String str) {
        return this.co.isRtl(str, 0, str.length());
    }

    public String unicodeWrap(String str, TextDirectionHeuristicCompat textDirectionHeuristicCompat, boolean z) {
        boolean isRtl = textDirectionHeuristicCompat.isRtl(str, 0, str.length());
        StringBuilder sb = new StringBuilder();
        if (getStereoReset() && z) {
            sb.append(b(str, isRtl ? TextDirectionHeuristicsCompat.RTL : TextDirectionHeuristicsCompat.LTR));
        }
        if (isRtl != this.cm) {
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
        return unicodeWrap(str, this.co, z);
    }

    public String unicodeWrap(String str) {
        return unicodeWrap(str, this.co, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean a(Locale locale) {
        return TextUtilsCompat.getLayoutDirectionFromLocale(locale) == 1;
    }

    private static int m(String str) {
        return new a(str, false).O();
    }

    private static int n(String str) {
        return new a(str, false).N();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private static final byte[] cq = new byte[1792];
        private int charIndex;
        private final boolean cr;
        private char cs;
        private final int length;
        private final String text;

        static {
            for (int i = 0; i < 1792; i++) {
                cq[i] = Character.getDirectionality(i);
            }
        }

        a(String str, boolean z) {
            this.text = str;
            this.cr = z;
            this.length = str.length();
        }

        int N() {
            this.charIndex = 0;
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            while (this.charIndex < this.length && i == 0) {
                switch (P()) {
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
            while (this.charIndex > 0) {
                switch (Q()) {
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

        int O() {
            this.charIndex = this.length;
            int i = 0;
            int i2 = 0;
            while (this.charIndex > 0) {
                switch (Q()) {
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
            return c < 1792 ? cq[c] : Character.getDirectionality(c);
        }

        byte P() {
            this.cs = this.text.charAt(this.charIndex);
            if (Character.isHighSurrogate(this.cs)) {
                int codePointAt = Character.codePointAt(this.text, this.charIndex);
                this.charIndex += Character.charCount(codePointAt);
                return Character.getDirectionality(codePointAt);
            }
            this.charIndex++;
            byte d = d(this.cs);
            if (this.cr) {
                if (this.cs == '<') {
                    return R();
                }
                if (this.cs == '&') {
                    return T();
                }
                return d;
            }
            return d;
        }

        byte Q() {
            this.cs = this.text.charAt(this.charIndex - 1);
            if (Character.isLowSurrogate(this.cs)) {
                int codePointBefore = Character.codePointBefore(this.text, this.charIndex);
                this.charIndex -= Character.charCount(codePointBefore);
                return Character.getDirectionality(codePointBefore);
            }
            this.charIndex--;
            byte d = d(this.cs);
            if (this.cr) {
                if (this.cs == '>') {
                    return S();
                }
                if (this.cs == ';') {
                    return U();
                }
                return d;
            }
            return d;
        }

        private byte R() {
            int i = this.charIndex;
            while (this.charIndex < this.length) {
                String str = this.text;
                int i2 = this.charIndex;
                this.charIndex = i2 + 1;
                this.cs = str.charAt(i2);
                if (this.cs == '>') {
                    return (byte) 12;
                }
                if (this.cs == '\"' || this.cs == '\'') {
                    char c = this.cs;
                    while (this.charIndex < this.length) {
                        String str2 = this.text;
                        int i3 = this.charIndex;
                        this.charIndex = i3 + 1;
                        char charAt = str2.charAt(i3);
                        this.cs = charAt;
                        if (charAt == c) {
                            break;
                        }
                    }
                }
            }
            this.charIndex = i;
            this.cs = '<';
            return (byte) 13;
        }

        private byte S() {
            int i = this.charIndex;
            while (this.charIndex > 0) {
                String str = this.text;
                int i2 = this.charIndex - 1;
                this.charIndex = i2;
                this.cs = str.charAt(i2);
                if (this.cs == '<') {
                    return (byte) 12;
                }
                if (this.cs == '>') {
                    break;
                } else if (this.cs == '\"' || this.cs == '\'') {
                    char c = this.cs;
                    while (this.charIndex > 0) {
                        String str2 = this.text;
                        int i3 = this.charIndex - 1;
                        this.charIndex = i3;
                        char charAt = str2.charAt(i3);
                        this.cs = charAt;
                        if (charAt == c) {
                            break;
                        }
                    }
                }
            }
            this.charIndex = i;
            this.cs = '>';
            return (byte) 13;
        }

        private byte T() {
            while (this.charIndex < this.length) {
                String str = this.text;
                int i = this.charIndex;
                this.charIndex = i + 1;
                char charAt = str.charAt(i);
                this.cs = charAt;
                if (charAt == ';') {
                    return (byte) 12;
                }
            }
            return (byte) 12;
        }

        private byte U() {
            int i = this.charIndex;
            while (this.charIndex > 0) {
                String str = this.text;
                int i2 = this.charIndex - 1;
                this.charIndex = i2;
                this.cs = str.charAt(i2);
                if (this.cs == '&') {
                    return (byte) 12;
                }
                if (this.cs == ';') {
                    break;
                }
            }
            this.charIndex = i;
            this.cs = ';';
            return (byte) 13;
        }
    }
}
