package android.support.v4.text;

import java.util.Locale;
/* loaded from: classes.dex */
public final class BidiFormatter {
    private static TextDirectionHeuristicCompat cj = TextDirectionHeuristicsCompat.FIRSTSTRONG_LTR;
    private static final String ck = Character.toString(8206);
    private static final String cl = Character.toString(8207);
    private static final BidiFormatter cm = new BidiFormatter(false, 2, cj);
    private static final BidiFormatter cn = new BidiFormatter(true, 2, cj);
    private final boolean co;
    private final int cp;
    private final TextDirectionHeuristicCompat cq;

    /* loaded from: classes.dex */
    public static final class Builder {
        private boolean co;
        private int cp;
        private TextDirectionHeuristicCompat cr;

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
            this.co = z;
            this.cr = BidiFormatter.cj;
            this.cp = 2;
        }

        public Builder stereoReset(boolean z) {
            if (z) {
                this.cp |= 2;
            } else {
                this.cp &= -3;
            }
            return this;
        }

        public Builder setTextDirectionHeuristic(TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
            this.cr = textDirectionHeuristicCompat;
            return this;
        }

        private static BidiFormatter g(boolean z) {
            return z ? BidiFormatter.cn : BidiFormatter.cm;
        }

        public BidiFormatter build() {
            return (this.cp == 2 && this.cr == BidiFormatter.cj) ? g(this.co) : new BidiFormatter(this.co, this.cp, this.cr);
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
        this.co = z;
        this.cp = i;
        this.cq = textDirectionHeuristicCompat;
    }

    public boolean isRtlContext() {
        return this.co;
    }

    public boolean getStereoReset() {
        return (this.cp & 2) != 0;
    }

    private String a(String str, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        boolean isRtl = textDirectionHeuristicCompat.isRtl(str, 0, str.length());
        if (!this.co && (isRtl || m(str) == 1)) {
            return ck;
        }
        if (this.co && (!isRtl || m(str) == -1)) {
            return cl;
        }
        return "";
    }

    private String b(String str, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        boolean isRtl = textDirectionHeuristicCompat.isRtl(str, 0, str.length());
        if (!this.co && (isRtl || n(str) == 1)) {
            return ck;
        }
        if (this.co && (!isRtl || n(str) == -1)) {
            return cl;
        }
        return "";
    }

    public boolean isRtl(String str) {
        return this.cq.isRtl(str, 0, str.length());
    }

    public String unicodeWrap(String str, TextDirectionHeuristicCompat textDirectionHeuristicCompat, boolean z) {
        boolean isRtl = textDirectionHeuristicCompat.isRtl(str, 0, str.length());
        StringBuilder sb = new StringBuilder();
        if (getStereoReset() && z) {
            sb.append(b(str, isRtl ? TextDirectionHeuristicsCompat.RTL : TextDirectionHeuristicsCompat.LTR));
        }
        if (isRtl != this.co) {
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
        return unicodeWrap(str, this.cq, z);
    }

    public String unicodeWrap(String str) {
        return unicodeWrap(str, this.cq, true);
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
        private static final byte[] cs = new byte[1792];
        private int charIndex;
        private final boolean ct;
        private char cu;
        private final int length;
        private final String text;

        static {
            for (int i = 0; i < 1792; i++) {
                cs[i] = Character.getDirectionality(i);
            }
        }

        a(String str, boolean z) {
            this.text = str;
            this.ct = z;
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
            return c < 1792 ? cs[c] : Character.getDirectionality(c);
        }

        byte P() {
            this.cu = this.text.charAt(this.charIndex);
            if (Character.isHighSurrogate(this.cu)) {
                int codePointAt = Character.codePointAt(this.text, this.charIndex);
                this.charIndex += Character.charCount(codePointAt);
                return Character.getDirectionality(codePointAt);
            }
            this.charIndex++;
            byte d = d(this.cu);
            if (this.ct) {
                if (this.cu == '<') {
                    return R();
                }
                if (this.cu == '&') {
                    return T();
                }
                return d;
            }
            return d;
        }

        byte Q() {
            this.cu = this.text.charAt(this.charIndex - 1);
            if (Character.isLowSurrogate(this.cu)) {
                int codePointBefore = Character.codePointBefore(this.text, this.charIndex);
                this.charIndex -= Character.charCount(codePointBefore);
                return Character.getDirectionality(codePointBefore);
            }
            this.charIndex--;
            byte d = d(this.cu);
            if (this.ct) {
                if (this.cu == '>') {
                    return S();
                }
                if (this.cu == ';') {
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
                this.cu = str.charAt(i2);
                if (this.cu == '>') {
                    return (byte) 12;
                }
                if (this.cu == '\"' || this.cu == '\'') {
                    char c = this.cu;
                    while (this.charIndex < this.length) {
                        String str2 = this.text;
                        int i3 = this.charIndex;
                        this.charIndex = i3 + 1;
                        char charAt = str2.charAt(i3);
                        this.cu = charAt;
                        if (charAt == c) {
                            break;
                        }
                    }
                }
            }
            this.charIndex = i;
            this.cu = '<';
            return (byte) 13;
        }

        private byte S() {
            int i = this.charIndex;
            while (this.charIndex > 0) {
                String str = this.text;
                int i2 = this.charIndex - 1;
                this.charIndex = i2;
                this.cu = str.charAt(i2);
                if (this.cu == '<') {
                    return (byte) 12;
                }
                if (this.cu == '>') {
                    break;
                } else if (this.cu == '\"' || this.cu == '\'') {
                    char c = this.cu;
                    while (this.charIndex > 0) {
                        String str2 = this.text;
                        int i3 = this.charIndex - 1;
                        this.charIndex = i3;
                        char charAt = str2.charAt(i3);
                        this.cu = charAt;
                        if (charAt == c) {
                            break;
                        }
                    }
                }
            }
            this.charIndex = i;
            this.cu = '>';
            return (byte) 13;
        }

        private byte T() {
            while (this.charIndex < this.length) {
                String str = this.text;
                int i = this.charIndex;
                this.charIndex = i + 1;
                char charAt = str.charAt(i);
                this.cu = charAt;
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
                this.cu = str.charAt(i2);
                if (this.cu == '&') {
                    return (byte) 12;
                }
                if (this.cu == ';') {
                    break;
                }
            }
            this.charIndex = i;
            this.cu = ';';
            return (byte) 13;
        }
    }
}
