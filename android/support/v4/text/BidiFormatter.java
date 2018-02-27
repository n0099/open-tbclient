package android.support.v4.text;

import android.text.SpannableStringBuilder;
import java.util.Locale;
/* loaded from: classes2.dex */
public final class BidiFormatter {
    private static TextDirectionHeuristicCompat AK = TextDirectionHeuristicsCompat.FIRSTSTRONG_LTR;
    private static final String AM = Character.toString(8206);
    private static final String AN = Character.toString(8207);
    private static final BidiFormatter AO = new BidiFormatter(false, 2, AK);
    private static final BidiFormatter AP = new BidiFormatter(true, 2, AK);
    private final boolean AQ;
    private final TextDirectionHeuristicCompat AR;
    private final int mFlags;

    /* loaded from: classes2.dex */
    public static final class Builder {
        private boolean AQ;
        private TextDirectionHeuristicCompat AT;
        private int mFlags;

        public Builder() {
            x(BidiFormatter.a(Locale.getDefault()));
        }

        public Builder(boolean z) {
            x(z);
        }

        public Builder(Locale locale) {
            x(BidiFormatter.a(locale));
        }

        private void x(boolean z) {
            this.AQ = z;
            this.AT = BidiFormatter.AK;
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
            this.AT = textDirectionHeuristicCompat;
            return this;
        }

        private static BidiFormatter y(boolean z) {
            return z ? BidiFormatter.AP : BidiFormatter.AO;
        }

        public BidiFormatter build() {
            return (this.mFlags == 2 && this.AT == BidiFormatter.AK) ? y(this.AQ) : new BidiFormatter(this.AQ, this.mFlags, this.AT);
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
        this.AQ = z;
        this.mFlags = i;
        this.AR = textDirectionHeuristicCompat;
    }

    public boolean isRtlContext() {
        return this.AQ;
    }

    public boolean getStereoReset() {
        return (this.mFlags & 2) != 0;
    }

    private String a(CharSequence charSequence, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        boolean isRtl = textDirectionHeuristicCompat.isRtl(charSequence, 0, charSequence.length());
        if (!this.AQ && (isRtl || d(charSequence) == 1)) {
            return AM;
        }
        if (this.AQ && (!isRtl || d(charSequence) == -1)) {
            return AN;
        }
        return "";
    }

    private String b(CharSequence charSequence, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        boolean isRtl = textDirectionHeuristicCompat.isRtl(charSequence, 0, charSequence.length());
        if (!this.AQ && (isRtl || e(charSequence) == 1)) {
            return AM;
        }
        if (this.AQ && (!isRtl || e(charSequence) == -1)) {
            return AN;
        }
        return "";
    }

    public boolean isRtl(String str) {
        return isRtl((CharSequence) str);
    }

    public boolean isRtl(CharSequence charSequence) {
        return this.AR.isRtl(charSequence, 0, charSequence.length());
    }

    public String unicodeWrap(String str, TextDirectionHeuristicCompat textDirectionHeuristicCompat, boolean z) {
        if (str == null) {
            return null;
        }
        return unicodeWrap((CharSequence) str, textDirectionHeuristicCompat, z).toString();
    }

    public CharSequence unicodeWrap(CharSequence charSequence, TextDirectionHeuristicCompat textDirectionHeuristicCompat, boolean z) {
        if (charSequence == null) {
            return null;
        }
        boolean isRtl = textDirectionHeuristicCompat.isRtl(charSequence, 0, charSequence.length());
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (getStereoReset() && z) {
            spannableStringBuilder.append((CharSequence) b(charSequence, isRtl ? TextDirectionHeuristicsCompat.RTL : TextDirectionHeuristicsCompat.LTR));
        }
        if (isRtl != this.AQ) {
            spannableStringBuilder.append(isRtl ? (char) 8235 : (char) 8234);
            spannableStringBuilder.append(charSequence);
            spannableStringBuilder.append((char) 8236);
        } else {
            spannableStringBuilder.append(charSequence);
        }
        if (z) {
            spannableStringBuilder.append((CharSequence) a(charSequence, isRtl ? TextDirectionHeuristicsCompat.RTL : TextDirectionHeuristicsCompat.LTR));
        }
        return spannableStringBuilder;
    }

    public String unicodeWrap(String str, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        return unicodeWrap(str, textDirectionHeuristicCompat, true);
    }

    public CharSequence unicodeWrap(CharSequence charSequence, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        return unicodeWrap(charSequence, textDirectionHeuristicCompat, true);
    }

    public String unicodeWrap(String str, boolean z) {
        return unicodeWrap(str, this.AR, z);
    }

    public CharSequence unicodeWrap(CharSequence charSequence, boolean z) {
        return unicodeWrap(charSequence, this.AR, z);
    }

    public String unicodeWrap(String str) {
        return unicodeWrap(str, this.AR, true);
    }

    public CharSequence unicodeWrap(CharSequence charSequence) {
        return unicodeWrap(charSequence, this.AR, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean a(Locale locale) {
        return TextUtilsCompat.getLayoutDirectionFromLocale(locale) == 1;
    }

    private static int d(CharSequence charSequence) {
        return new a(charSequence, false).dJ();
    }

    private static int e(CharSequence charSequence) {
        return new a(charSequence, false).dI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a {
        private static final byte[] AU = new byte[1792];
        private final boolean AV;
        private int AW;
        private char AX;
        private final int length;
        private final CharSequence text;

        static {
            for (int i = 0; i < 1792; i++) {
                AU[i] = Character.getDirectionality(i);
            }
        }

        a(CharSequence charSequence, boolean z) {
            this.text = charSequence;
            this.AV = z;
            this.length = charSequence.length();
        }

        int dI() {
            this.AW = 0;
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            while (this.AW < this.length && i == 0) {
                switch (dK()) {
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
            while (this.AW > 0) {
                switch (dL()) {
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

        int dJ() {
            this.AW = this.length;
            int i = 0;
            int i2 = 0;
            while (this.AW > 0) {
                switch (dL()) {
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
            return c < 1792 ? AU[c] : Character.getDirectionality(c);
        }

        byte dK() {
            this.AX = this.text.charAt(this.AW);
            if (Character.isHighSurrogate(this.AX)) {
                int codePointAt = Character.codePointAt(this.text, this.AW);
                this.AW += Character.charCount(codePointAt);
                return Character.getDirectionality(codePointAt);
            }
            this.AW++;
            byte d = d(this.AX);
            if (this.AV) {
                if (this.AX == '<') {
                    return dM();
                }
                if (this.AX == '&') {
                    return dO();
                }
                return d;
            }
            return d;
        }

        byte dL() {
            this.AX = this.text.charAt(this.AW - 1);
            if (Character.isLowSurrogate(this.AX)) {
                int codePointBefore = Character.codePointBefore(this.text, this.AW);
                this.AW -= Character.charCount(codePointBefore);
                return Character.getDirectionality(codePointBefore);
            }
            this.AW--;
            byte d = d(this.AX);
            if (this.AV) {
                if (this.AX == '>') {
                    return dN();
                }
                if (this.AX == ';') {
                    return dP();
                }
                return d;
            }
            return d;
        }

        private byte dM() {
            int i = this.AW;
            while (this.AW < this.length) {
                CharSequence charSequence = this.text;
                int i2 = this.AW;
                this.AW = i2 + 1;
                this.AX = charSequence.charAt(i2);
                if (this.AX == '>') {
                    return (byte) 12;
                }
                if (this.AX == '\"' || this.AX == '\'') {
                    char c = this.AX;
                    while (this.AW < this.length) {
                        CharSequence charSequence2 = this.text;
                        int i3 = this.AW;
                        this.AW = i3 + 1;
                        char charAt = charSequence2.charAt(i3);
                        this.AX = charAt;
                        if (charAt == c) {
                            break;
                        }
                    }
                }
            }
            this.AW = i;
            this.AX = '<';
            return (byte) 13;
        }

        private byte dN() {
            int i = this.AW;
            while (this.AW > 0) {
                CharSequence charSequence = this.text;
                int i2 = this.AW - 1;
                this.AW = i2;
                this.AX = charSequence.charAt(i2);
                if (this.AX == '<') {
                    return (byte) 12;
                }
                if (this.AX == '>') {
                    break;
                } else if (this.AX == '\"' || this.AX == '\'') {
                    char c = this.AX;
                    while (this.AW > 0) {
                        CharSequence charSequence2 = this.text;
                        int i3 = this.AW - 1;
                        this.AW = i3;
                        char charAt = charSequence2.charAt(i3);
                        this.AX = charAt;
                        if (charAt == c) {
                            break;
                        }
                    }
                }
            }
            this.AW = i;
            this.AX = '>';
            return (byte) 13;
        }

        private byte dO() {
            while (this.AW < this.length) {
                CharSequence charSequence = this.text;
                int i = this.AW;
                this.AW = i + 1;
                char charAt = charSequence.charAt(i);
                this.AX = charAt;
                if (charAt == ';') {
                    return (byte) 12;
                }
            }
            return (byte) 12;
        }

        private byte dP() {
            int i = this.AW;
            while (this.AW > 0) {
                CharSequence charSequence = this.text;
                int i2 = this.AW - 1;
                this.AW = i2;
                this.AX = charSequence.charAt(i2);
                if (this.AX == '&') {
                    return (byte) 12;
                }
                if (this.AX == ';') {
                    break;
                }
            }
            this.AW = i;
            this.AX = ';';
            return (byte) 13;
        }
    }
}
