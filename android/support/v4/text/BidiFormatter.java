package android.support.v4.text;

import java.util.Locale;
/* loaded from: classes.dex */
public final class BidiFormatter {
    private static TextDirectionHeuristicCompat jP = TextDirectionHeuristicsCompat.FIRSTSTRONG_LTR;
    private static final String jQ = Character.toString(8206);
    private static final String jR = Character.toString(8207);
    private static final BidiFormatter jS = new BidiFormatter(false, 2, jP);
    private static final BidiFormatter jT = new BidiFormatter(true, 2, jP);
    private final boolean jU;
    private final int jV;
    private final TextDirectionHeuristicCompat jW;

    /* loaded from: classes.dex */
    public static final class Builder {
        private boolean jU;
        private int jV;
        private TextDirectionHeuristicCompat jX;

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
            this.jU = z;
            this.jX = BidiFormatter.jP;
            this.jV = 2;
        }

        public Builder stereoReset(boolean z) {
            if (z) {
                this.jV |= 2;
            } else {
                this.jV &= -3;
            }
            return this;
        }

        public Builder setTextDirectionHeuristic(TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
            this.jX = textDirectionHeuristicCompat;
            return this;
        }

        private static BidiFormatter h(boolean z) {
            return z ? BidiFormatter.jT : BidiFormatter.jS;
        }

        public BidiFormatter build() {
            return (this.jV == 2 && this.jX == BidiFormatter.jP) ? h(this.jU) : new BidiFormatter(this.jU, this.jV, this.jX);
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
        this.jU = z;
        this.jV = i;
        this.jW = textDirectionHeuristicCompat;
    }

    public boolean isRtlContext() {
        return this.jU;
    }

    public boolean getStereoReset() {
        return (this.jV & 2) != 0;
    }

    private String a(String str, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        boolean isRtl = textDirectionHeuristicCompat.isRtl(str, 0, str.length());
        if (!this.jU && (isRtl || r(str) == 1)) {
            return jQ;
        }
        if (this.jU && (!isRtl || r(str) == -1)) {
            return jR;
        }
        return "";
    }

    private String b(String str, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        boolean isRtl = textDirectionHeuristicCompat.isRtl(str, 0, str.length());
        if (!this.jU && (isRtl || t(str) == 1)) {
            return jQ;
        }
        if (this.jU && (!isRtl || t(str) == -1)) {
            return jR;
        }
        return "";
    }

    public boolean isRtl(String str) {
        return this.jW.isRtl(str, 0, str.length());
    }

    public String unicodeWrap(String str, TextDirectionHeuristicCompat textDirectionHeuristicCompat, boolean z) {
        boolean isRtl = textDirectionHeuristicCompat.isRtl(str, 0, str.length());
        StringBuilder sb = new StringBuilder();
        if (getStereoReset() && z) {
            sb.append(b(str, isRtl ? TextDirectionHeuristicsCompat.RTL : TextDirectionHeuristicsCompat.LTR));
        }
        if (isRtl != this.jU) {
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
        return unicodeWrap(str, this.jW, z);
    }

    public String unicodeWrap(String str) {
        return unicodeWrap(str, this.jW, true);
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
        private static final byte[] jY = new byte[1792];
        private final boolean jZ;
        private int kb;
        private char kc;
        private final int length;
        private final String text;

        static {
            for (int i = 0; i < 1792; i++) {
                jY[i] = Character.getDirectionality(i);
            }
        }

        a(String str, boolean z) {
            this.text = str;
            this.jZ = z;
            this.length = str.length();
        }

        int aX() {
            this.kb = 0;
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            while (this.kb < this.length && i == 0) {
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
            while (this.kb > 0) {
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
            this.kb = this.length;
            int i = 0;
            int i2 = 0;
            while (this.kb > 0) {
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
            return c < 1792 ? jY[c] : Character.getDirectionality(c);
        }

        byte aZ() {
            this.kc = this.text.charAt(this.kb);
            if (Character.isHighSurrogate(this.kc)) {
                int codePointAt = Character.codePointAt(this.text, this.kb);
                this.kb += Character.charCount(codePointAt);
                return Character.getDirectionality(codePointAt);
            }
            this.kb++;
            byte d = d(this.kc);
            if (this.jZ) {
                if (this.kc == '<') {
                    return bb();
                }
                if (this.kc == '&') {
                    return bd();
                }
                return d;
            }
            return d;
        }

        byte ba() {
            this.kc = this.text.charAt(this.kb - 1);
            if (Character.isLowSurrogate(this.kc)) {
                int codePointBefore = Character.codePointBefore(this.text, this.kb);
                this.kb -= Character.charCount(codePointBefore);
                return Character.getDirectionality(codePointBefore);
            }
            this.kb--;
            byte d = d(this.kc);
            if (this.jZ) {
                if (this.kc == '>') {
                    return bc();
                }
                if (this.kc == ';') {
                    return be();
                }
                return d;
            }
            return d;
        }

        private byte bb() {
            int i = this.kb;
            while (this.kb < this.length) {
                String str = this.text;
                int i2 = this.kb;
                this.kb = i2 + 1;
                this.kc = str.charAt(i2);
                if (this.kc == '>') {
                    return (byte) 12;
                }
                if (this.kc == '\"' || this.kc == '\'') {
                    char c = this.kc;
                    while (this.kb < this.length) {
                        String str2 = this.text;
                        int i3 = this.kb;
                        this.kb = i3 + 1;
                        char charAt = str2.charAt(i3);
                        this.kc = charAt;
                        if (charAt == c) {
                            break;
                        }
                    }
                }
            }
            this.kb = i;
            this.kc = '<';
            return (byte) 13;
        }

        private byte bc() {
            int i = this.kb;
            while (this.kb > 0) {
                String str = this.text;
                int i2 = this.kb - 1;
                this.kb = i2;
                this.kc = str.charAt(i2);
                if (this.kc == '<') {
                    return (byte) 12;
                }
                if (this.kc == '>') {
                    break;
                } else if (this.kc == '\"' || this.kc == '\'') {
                    char c = this.kc;
                    while (this.kb > 0) {
                        String str2 = this.text;
                        int i3 = this.kb - 1;
                        this.kb = i3;
                        char charAt = str2.charAt(i3);
                        this.kc = charAt;
                        if (charAt == c) {
                            break;
                        }
                    }
                }
            }
            this.kb = i;
            this.kc = '>';
            return (byte) 13;
        }

        private byte bd() {
            while (this.kb < this.length) {
                String str = this.text;
                int i = this.kb;
                this.kb = i + 1;
                char charAt = str.charAt(i);
                this.kc = charAt;
                if (charAt == ';') {
                    return (byte) 12;
                }
            }
            return (byte) 12;
        }

        private byte be() {
            int i = this.kb;
            while (this.kb > 0) {
                String str = this.text;
                int i2 = this.kb - 1;
                this.kb = i2;
                this.kc = str.charAt(i2);
                if (this.kc == '&') {
                    return (byte) 12;
                }
                if (this.kc == ';') {
                    break;
                }
            }
            this.kb = i;
            this.kc = ';';
            return (byte) 13;
        }
    }
}
