package android.support.v4.text;

import android.text.SpannableStringBuilder;
import java.util.Locale;
/* loaded from: classes2.dex */
public final class BidiFormatter {
    private static TextDirectionHeuristicCompat AR = TextDirectionHeuristicsCompat.FIRSTSTRONG_LTR;
    private static final String AT = Character.toString(8206);
    private static final String AU = Character.toString(8207);
    private static final BidiFormatter AV = new BidiFormatter(false, 2, AR);
    private static final BidiFormatter AW = new BidiFormatter(true, 2, AR);
    private final boolean AX;
    private final TextDirectionHeuristicCompat AY;
    private final int mFlags;

    /* loaded from: classes2.dex */
    public static final class Builder {
        private boolean AX;
        private TextDirectionHeuristicCompat AZ;
        private int mFlags;

        public Builder() {
            v(BidiFormatter.a(Locale.getDefault()));
        }

        public Builder(boolean z) {
            v(z);
        }

        public Builder(Locale locale) {
            v(BidiFormatter.a(locale));
        }

        private void v(boolean z) {
            this.AX = z;
            this.AZ = BidiFormatter.AR;
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
            this.AZ = textDirectionHeuristicCompat;
            return this;
        }

        private static BidiFormatter w(boolean z) {
            return z ? BidiFormatter.AW : BidiFormatter.AV;
        }

        public BidiFormatter build() {
            return (this.mFlags == 2 && this.AZ == BidiFormatter.AR) ? w(this.AX) : new BidiFormatter(this.AX, this.mFlags, this.AZ);
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
        this.AX = z;
        this.mFlags = i;
        this.AY = textDirectionHeuristicCompat;
    }

    public boolean isRtlContext() {
        return this.AX;
    }

    public boolean getStereoReset() {
        return (this.mFlags & 2) != 0;
    }

    private String a(CharSequence charSequence, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        boolean isRtl = textDirectionHeuristicCompat.isRtl(charSequence, 0, charSequence.length());
        if (!this.AX && (isRtl || d(charSequence) == 1)) {
            return AT;
        }
        if (this.AX && (!isRtl || d(charSequence) == -1)) {
            return AU;
        }
        return "";
    }

    private String b(CharSequence charSequence, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        boolean isRtl = textDirectionHeuristicCompat.isRtl(charSequence, 0, charSequence.length());
        if (!this.AX && (isRtl || e(charSequence) == 1)) {
            return AT;
        }
        if (this.AX && (!isRtl || e(charSequence) == -1)) {
            return AU;
        }
        return "";
    }

    public boolean isRtl(String str) {
        return isRtl((CharSequence) str);
    }

    public boolean isRtl(CharSequence charSequence) {
        return this.AY.isRtl(charSequence, 0, charSequence.length());
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
        if (isRtl != this.AX) {
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
        return unicodeWrap(str, this.AY, z);
    }

    public CharSequence unicodeWrap(CharSequence charSequence, boolean z) {
        return unicodeWrap(charSequence, this.AY, z);
    }

    public String unicodeWrap(String str) {
        return unicodeWrap(str, this.AY, true);
    }

    public CharSequence unicodeWrap(CharSequence charSequence) {
        return unicodeWrap(charSequence, this.AY, true);
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
        private static final byte[] Ba = new byte[1792];
        private final boolean Bb;
        private int Bc;
        private char Bd;
        private final int length;
        private final CharSequence text;

        static {
            for (int i = 0; i < 1792; i++) {
                Ba[i] = Character.getDirectionality(i);
            }
        }

        a(CharSequence charSequence, boolean z) {
            this.text = charSequence;
            this.Bb = z;
            this.length = charSequence.length();
        }

        int dI() {
            this.Bc = 0;
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            while (this.Bc < this.length && i == 0) {
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
            while (this.Bc > 0) {
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
            this.Bc = this.length;
            int i = 0;
            int i2 = 0;
            while (this.Bc > 0) {
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
            return c < 1792 ? Ba[c] : Character.getDirectionality(c);
        }

        byte dK() {
            this.Bd = this.text.charAt(this.Bc);
            if (Character.isHighSurrogate(this.Bd)) {
                int codePointAt = Character.codePointAt(this.text, this.Bc);
                this.Bc += Character.charCount(codePointAt);
                return Character.getDirectionality(codePointAt);
            }
            this.Bc++;
            byte d = d(this.Bd);
            if (this.Bb) {
                if (this.Bd == '<') {
                    return dM();
                }
                if (this.Bd == '&') {
                    return dO();
                }
                return d;
            }
            return d;
        }

        byte dL() {
            this.Bd = this.text.charAt(this.Bc - 1);
            if (Character.isLowSurrogate(this.Bd)) {
                int codePointBefore = Character.codePointBefore(this.text, this.Bc);
                this.Bc -= Character.charCount(codePointBefore);
                return Character.getDirectionality(codePointBefore);
            }
            this.Bc--;
            byte d = d(this.Bd);
            if (this.Bb) {
                if (this.Bd == '>') {
                    return dN();
                }
                if (this.Bd == ';') {
                    return dP();
                }
                return d;
            }
            return d;
        }

        private byte dM() {
            int i = this.Bc;
            while (this.Bc < this.length) {
                CharSequence charSequence = this.text;
                int i2 = this.Bc;
                this.Bc = i2 + 1;
                this.Bd = charSequence.charAt(i2);
                if (this.Bd == '>') {
                    return (byte) 12;
                }
                if (this.Bd == '\"' || this.Bd == '\'') {
                    char c = this.Bd;
                    while (this.Bc < this.length) {
                        CharSequence charSequence2 = this.text;
                        int i3 = this.Bc;
                        this.Bc = i3 + 1;
                        char charAt = charSequence2.charAt(i3);
                        this.Bd = charAt;
                        if (charAt == c) {
                            break;
                        }
                    }
                }
            }
            this.Bc = i;
            this.Bd = '<';
            return (byte) 13;
        }

        private byte dN() {
            int i = this.Bc;
            while (this.Bc > 0) {
                CharSequence charSequence = this.text;
                int i2 = this.Bc - 1;
                this.Bc = i2;
                this.Bd = charSequence.charAt(i2);
                if (this.Bd == '<') {
                    return (byte) 12;
                }
                if (this.Bd == '>') {
                    break;
                } else if (this.Bd == '\"' || this.Bd == '\'') {
                    char c = this.Bd;
                    while (this.Bc > 0) {
                        CharSequence charSequence2 = this.text;
                        int i3 = this.Bc - 1;
                        this.Bc = i3;
                        char charAt = charSequence2.charAt(i3);
                        this.Bd = charAt;
                        if (charAt == c) {
                            break;
                        }
                    }
                }
            }
            this.Bc = i;
            this.Bd = '>';
            return (byte) 13;
        }

        private byte dO() {
            while (this.Bc < this.length) {
                CharSequence charSequence = this.text;
                int i = this.Bc;
                this.Bc = i + 1;
                char charAt = charSequence.charAt(i);
                this.Bd = charAt;
                if (charAt == ';') {
                    return (byte) 12;
                }
            }
            return (byte) 12;
        }

        private byte dP() {
            int i = this.Bc;
            while (this.Bc > 0) {
                CharSequence charSequence = this.text;
                int i2 = this.Bc - 1;
                this.Bc = i2;
                this.Bd = charSequence.charAt(i2);
                if (this.Bd == '&') {
                    return (byte) 12;
                }
                if (this.Bd == ';') {
                    break;
                }
            }
            this.Bc = i;
            this.Bd = ';';
            return (byte) 13;
        }
    }
}
