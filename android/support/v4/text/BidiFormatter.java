package android.support.v4.text;

import java.util.Locale;
/* loaded from: classes.dex */
public final class BidiFormatter {
    private static TextDirectionHeuristicCompat jR = TextDirectionHeuristicsCompat.FIRSTSTRONG_LTR;
    private static final String jS = Character.toString(8206);
    private static final String jT = Character.toString(8207);
    private static final BidiFormatter jU = new BidiFormatter(false, 2, jR);
    private static final BidiFormatter jV = new BidiFormatter(true, 2, jR);
    private final boolean jW;
    private final int jX;
    private final TextDirectionHeuristicCompat jY;

    /* loaded from: classes.dex */
    public static final class Builder {
        private boolean jW;
        private int jX;
        private TextDirectionHeuristicCompat jZ;

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
            this.jW = z;
            this.jZ = BidiFormatter.jR;
            this.jX = 2;
        }

        public Builder stereoReset(boolean z) {
            if (z) {
                this.jX |= 2;
            } else {
                this.jX &= -3;
            }
            return this;
        }

        public Builder setTextDirectionHeuristic(TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
            this.jZ = textDirectionHeuristicCompat;
            return this;
        }

        private static BidiFormatter h(boolean z) {
            return z ? BidiFormatter.jV : BidiFormatter.jU;
        }

        public BidiFormatter build() {
            return (this.jX == 2 && this.jZ == BidiFormatter.jR) ? h(this.jW) : new BidiFormatter(this.jW, this.jX, this.jZ);
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
        this.jW = z;
        this.jX = i;
        this.jY = textDirectionHeuristicCompat;
    }

    public boolean isRtlContext() {
        return this.jW;
    }

    public boolean getStereoReset() {
        return (this.jX & 2) != 0;
    }

    private String a(String str, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        boolean isRtl = textDirectionHeuristicCompat.isRtl(str, 0, str.length());
        if (!this.jW && (isRtl || r(str) == 1)) {
            return jS;
        }
        if (this.jW && (!isRtl || r(str) == -1)) {
            return jT;
        }
        return "";
    }

    private String b(String str, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        boolean isRtl = textDirectionHeuristicCompat.isRtl(str, 0, str.length());
        if (!this.jW && (isRtl || s(str) == 1)) {
            return jS;
        }
        if (this.jW && (!isRtl || s(str) == -1)) {
            return jT;
        }
        return "";
    }

    public boolean isRtl(String str) {
        return this.jY.isRtl(str, 0, str.length());
    }

    public String unicodeWrap(String str, TextDirectionHeuristicCompat textDirectionHeuristicCompat, boolean z) {
        boolean isRtl = textDirectionHeuristicCompat.isRtl(str, 0, str.length());
        StringBuilder sb = new StringBuilder();
        if (getStereoReset() && z) {
            sb.append(b(str, isRtl ? TextDirectionHeuristicsCompat.RTL : TextDirectionHeuristicsCompat.LTR));
        }
        if (isRtl != this.jW) {
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
        return unicodeWrap(str, this.jY, z);
    }

    public String unicodeWrap(String str) {
        return unicodeWrap(str, this.jY, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean a(Locale locale) {
        return TextUtilsCompat.getLayoutDirectionFromLocale(locale) == 1;
    }

    private static int r(String str) {
        return new a(str, false).aY();
    }

    private static int s(String str) {
        return new a(str, false).aX();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private static final byte[] kb = new byte[1792];
        private int charIndex;
        private final boolean kc;
        private char kd;
        private final int length;
        private final String text;

        static {
            for (int i = 0; i < 1792; i++) {
                kb[i] = Character.getDirectionality(i);
            }
        }

        a(String str, boolean z) {
            this.text = str;
            this.kc = z;
            this.length = str.length();
        }

        int aX() {
            this.charIndex = 0;
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            while (this.charIndex < this.length && i == 0) {
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
            while (this.charIndex > 0) {
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
            this.charIndex = this.length;
            int i = 0;
            int i2 = 0;
            while (this.charIndex > 0) {
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
            return c < 1792 ? kb[c] : Character.getDirectionality(c);
        }

        byte aZ() {
            this.kd = this.text.charAt(this.charIndex);
            if (Character.isHighSurrogate(this.kd)) {
                int codePointAt = Character.codePointAt(this.text, this.charIndex);
                this.charIndex += Character.charCount(codePointAt);
                return Character.getDirectionality(codePointAt);
            }
            this.charIndex++;
            byte d = d(this.kd);
            if (this.kc) {
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
            this.kd = this.text.charAt(this.charIndex - 1);
            if (Character.isLowSurrogate(this.kd)) {
                int codePointBefore = Character.codePointBefore(this.text, this.charIndex);
                this.charIndex -= Character.charCount(codePointBefore);
                return Character.getDirectionality(codePointBefore);
            }
            this.charIndex--;
            byte d = d(this.kd);
            if (this.kc) {
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
            int i = this.charIndex;
            while (this.charIndex < this.length) {
                String str = this.text;
                int i2 = this.charIndex;
                this.charIndex = i2 + 1;
                this.kd = str.charAt(i2);
                if (this.kd == '>') {
                    return (byte) 12;
                }
                if (this.kd == '\"' || this.kd == '\'') {
                    char c = this.kd;
                    while (this.charIndex < this.length) {
                        String str2 = this.text;
                        int i3 = this.charIndex;
                        this.charIndex = i3 + 1;
                        char charAt = str2.charAt(i3);
                        this.kd = charAt;
                        if (charAt == c) {
                            break;
                        }
                    }
                }
            }
            this.charIndex = i;
            this.kd = '<';
            return (byte) 13;
        }

        private byte bc() {
            int i = this.charIndex;
            while (this.charIndex > 0) {
                String str = this.text;
                int i2 = this.charIndex - 1;
                this.charIndex = i2;
                this.kd = str.charAt(i2);
                if (this.kd == '<') {
                    return (byte) 12;
                }
                if (this.kd == '>') {
                    break;
                } else if (this.kd == '\"' || this.kd == '\'') {
                    char c = this.kd;
                    while (this.charIndex > 0) {
                        String str2 = this.text;
                        int i3 = this.charIndex - 1;
                        this.charIndex = i3;
                        char charAt = str2.charAt(i3);
                        this.kd = charAt;
                        if (charAt == c) {
                            break;
                        }
                    }
                }
            }
            this.charIndex = i;
            this.kd = '>';
            return (byte) 13;
        }

        private byte bd() {
            while (this.charIndex < this.length) {
                String str = this.text;
                int i = this.charIndex;
                this.charIndex = i + 1;
                char charAt = str.charAt(i);
                this.kd = charAt;
                if (charAt == ';') {
                    return (byte) 12;
                }
            }
            return (byte) 12;
        }

        private byte be() {
            int i = this.charIndex;
            while (this.charIndex > 0) {
                String str = this.text;
                int i2 = this.charIndex - 1;
                this.charIndex = i2;
                this.kd = str.charAt(i2);
                if (this.kd == '&') {
                    return (byte) 12;
                }
                if (this.kd == ';') {
                    break;
                }
            }
            this.charIndex = i;
            this.kd = ';';
            return (byte) 13;
        }
    }
}
