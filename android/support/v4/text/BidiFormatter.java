package android.support.v4.text;

import java.util.Locale;
/* loaded from: classes.dex */
public final class BidiFormatter {
    private static TextDirectionHeuristicCompat jQ = TextDirectionHeuristicsCompat.FIRSTSTRONG_LTR;
    private static final String jR = Character.toString(8206);
    private static final String jS = Character.toString(8207);
    private static final BidiFormatter jT = new BidiFormatter(false, 2, jQ);
    private static final BidiFormatter jU = new BidiFormatter(true, 2, jQ);
    private final boolean jV;
    private final int jW;
    private final TextDirectionHeuristicCompat jX;

    /* loaded from: classes.dex */
    public static final class Builder {
        private boolean jV;
        private int jW;
        private TextDirectionHeuristicCompat jY;

        public Builder() {
            g(BidiFormatter.a(Locale.getDefault()));
        }

        public Builder(boolean z) {
            g(z);
        }

        public Builder(Locale locale) {
            g(BidiFormatter.a(locale));
        }

        private void g(boolean z) {
            this.jV = z;
            this.jY = BidiFormatter.jQ;
            this.jW = 2;
        }

        public Builder stereoReset(boolean z) {
            if (z) {
                this.jW |= 2;
            } else {
                this.jW &= -3;
            }
            return this;
        }

        public Builder setTextDirectionHeuristic(TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
            this.jY = textDirectionHeuristicCompat;
            return this;
        }

        private static BidiFormatter h(boolean z) {
            return z ? BidiFormatter.jU : BidiFormatter.jT;
        }

        public BidiFormatter build() {
            return (this.jW == 2 && this.jY == BidiFormatter.jQ) ? h(this.jV) : new BidiFormatter(this.jV, this.jW, this.jY);
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
        this.jV = z;
        this.jW = i;
        this.jX = textDirectionHeuristicCompat;
    }

    public boolean isRtlContext() {
        return this.jV;
    }

    public boolean getStereoReset() {
        return (this.jW & 2) != 0;
    }

    private String a(String str, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        boolean isRtl = textDirectionHeuristicCompat.isRtl(str, 0, str.length());
        if (!this.jV && (isRtl || r(str) == 1)) {
            return jR;
        }
        if (this.jV && (!isRtl || r(str) == -1)) {
            return jS;
        }
        return "";
    }

    private String b(String str, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        boolean isRtl = textDirectionHeuristicCompat.isRtl(str, 0, str.length());
        if (!this.jV && (isRtl || t(str) == 1)) {
            return jR;
        }
        if (this.jV && (!isRtl || t(str) == -1)) {
            return jS;
        }
        return "";
    }

    public boolean isRtl(String str) {
        return this.jX.isRtl(str, 0, str.length());
    }

    public String unicodeWrap(String str, TextDirectionHeuristicCompat textDirectionHeuristicCompat, boolean z) {
        boolean isRtl = textDirectionHeuristicCompat.isRtl(str, 0, str.length());
        StringBuilder sb = new StringBuilder();
        if (getStereoReset() && z) {
            sb.append(b(str, isRtl ? TextDirectionHeuristicsCompat.RTL : TextDirectionHeuristicsCompat.LTR));
        }
        if (isRtl != this.jV) {
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
        return unicodeWrap(str, this.jX, z);
    }

    public String unicodeWrap(String str) {
        return unicodeWrap(str, this.jX, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean a(Locale locale) {
        return TextUtilsCompat.getLayoutDirectionFromLocale(locale) == 1;
    }

    private static int r(String str) {
        return new a(str, false).aY();
    }

    private static int t(String str) {
        return new a(str, false).aX();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private static final byte[] jZ = new byte[1792];
        private final boolean kb;
        private int kc;
        private char kd;
        private final int length;
        private final String text;

        static {
            for (int i = 0; i < 1792; i++) {
                jZ[i] = Character.getDirectionality(i);
            }
        }

        a(String str, boolean z) {
            this.text = str;
            this.kb = z;
            this.length = str.length();
        }

        int aX() {
            this.kc = 0;
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            while (this.kc < this.length && i == 0) {
                switch (aZ()) {
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
            while (this.kc > 0) {
                switch (ba()) {
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

        int aY() {
            this.kc = this.length;
            int i = 0;
            int i2 = 0;
            while (this.kc > 0) {
                switch (ba()) {
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
            return c < 1792 ? jZ[c] : Character.getDirectionality(c);
        }

        byte aZ() {
            this.kd = this.text.charAt(this.kc);
            if (Character.isHighSurrogate(this.kd)) {
                int codePointAt = Character.codePointAt(this.text, this.kc);
                this.kc += Character.charCount(codePointAt);
                return Character.getDirectionality(codePointAt);
            }
            this.kc++;
            byte d = d(this.kd);
            if (this.kb) {
                if (this.kd == '<') {
                    return bb();
                }
                if (this.kd == '&') {
                    return bd();
                }
                return d;
            }
            return d;
        }

        byte ba() {
            this.kd = this.text.charAt(this.kc - 1);
            if (Character.isLowSurrogate(this.kd)) {
                int codePointBefore = Character.codePointBefore(this.text, this.kc);
                this.kc -= Character.charCount(codePointBefore);
                return Character.getDirectionality(codePointBefore);
            }
            this.kc--;
            byte d = d(this.kd);
            if (this.kb) {
                if (this.kd == '>') {
                    return bc();
                }
                if (this.kd == ';') {
                    return be();
                }
                return d;
            }
            return d;
        }

        private byte bb() {
            int i = this.kc;
            while (this.kc < this.length) {
                String str = this.text;
                int i2 = this.kc;
                this.kc = i2 + 1;
                this.kd = str.charAt(i2);
                if (this.kd == '>') {
                    return (byte) 12;
                }
                if (this.kd == '\"' || this.kd == '\'') {
                    char c = this.kd;
                    while (this.kc < this.length) {
                        String str2 = this.text;
                        int i3 = this.kc;
                        this.kc = i3 + 1;
                        char charAt = str2.charAt(i3);
                        this.kd = charAt;
                        if (charAt == c) {
                            break;
                        }
                    }
                }
            }
            this.kc = i;
            this.kd = '<';
            return (byte) 13;
        }

        private byte bc() {
            int i = this.kc;
            while (this.kc > 0) {
                String str = this.text;
                int i2 = this.kc - 1;
                this.kc = i2;
                this.kd = str.charAt(i2);
                if (this.kd == '<') {
                    return (byte) 12;
                }
                if (this.kd == '>') {
                    break;
                } else if (this.kd == '\"' || this.kd == '\'') {
                    char c = this.kd;
                    while (this.kc > 0) {
                        String str2 = this.text;
                        int i3 = this.kc - 1;
                        this.kc = i3;
                        char charAt = str2.charAt(i3);
                        this.kd = charAt;
                        if (charAt == c) {
                            break;
                        }
                    }
                }
            }
            this.kc = i;
            this.kd = '>';
            return (byte) 13;
        }

        private byte bd() {
            while (this.kc < this.length) {
                String str = this.text;
                int i = this.kc;
                this.kc = i + 1;
                char charAt = str.charAt(i);
                this.kd = charAt;
                if (charAt == ';') {
                    return (byte) 12;
                }
            }
            return (byte) 12;
        }

        private byte be() {
            int i = this.kc;
            while (this.kc > 0) {
                String str = this.text;
                int i2 = this.kc - 1;
                this.kc = i2;
                this.kd = str.charAt(i2);
                if (this.kd == '&') {
                    return (byte) 12;
                }
                if (this.kd == ';') {
                    break;
                }
            }
            this.kc = i;
            this.kd = ';';
            return (byte) 13;
        }
    }
}
