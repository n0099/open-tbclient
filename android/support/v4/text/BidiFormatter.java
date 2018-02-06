package android.support.v4.text;

import android.text.SpannableStringBuilder;
import java.util.Locale;
/* loaded from: classes2.dex */
public final class BidiFormatter {
    private static TextDirectionHeuristicCompat AQ = TextDirectionHeuristicsCompat.FIRSTSTRONG_LTR;
    private static final String AR = Character.toString(8206);
    private static final String AT = Character.toString(8207);
    private static final BidiFormatter AU = new BidiFormatter(false, 2, AQ);
    private static final BidiFormatter AV = new BidiFormatter(true, 2, AQ);
    private final boolean AW;
    private final TextDirectionHeuristicCompat AX;
    private final int mFlags;

    /* loaded from: classes2.dex */
    public static final class Builder {
        private boolean AW;
        private TextDirectionHeuristicCompat AY;
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
            this.AW = z;
            this.AY = BidiFormatter.AQ;
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
            this.AY = textDirectionHeuristicCompat;
            return this;
        }

        private static BidiFormatter y(boolean z) {
            return z ? BidiFormatter.AV : BidiFormatter.AU;
        }

        public BidiFormatter build() {
            return (this.mFlags == 2 && this.AY == BidiFormatter.AQ) ? y(this.AW) : new BidiFormatter(this.AW, this.mFlags, this.AY);
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
        this.AW = z;
        this.mFlags = i;
        this.AX = textDirectionHeuristicCompat;
    }

    public boolean isRtlContext() {
        return this.AW;
    }

    public boolean getStereoReset() {
        return (this.mFlags & 2) != 0;
    }

    private String a(CharSequence charSequence, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        boolean isRtl = textDirectionHeuristicCompat.isRtl(charSequence, 0, charSequence.length());
        if (!this.AW && (isRtl || d(charSequence) == 1)) {
            return AR;
        }
        if (this.AW && (!isRtl || d(charSequence) == -1)) {
            return AT;
        }
        return "";
    }

    private String b(CharSequence charSequence, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        boolean isRtl = textDirectionHeuristicCompat.isRtl(charSequence, 0, charSequence.length());
        if (!this.AW && (isRtl || e(charSequence) == 1)) {
            return AR;
        }
        if (this.AW && (!isRtl || e(charSequence) == -1)) {
            return AT;
        }
        return "";
    }

    public boolean isRtl(String str) {
        return isRtl((CharSequence) str);
    }

    public boolean isRtl(CharSequence charSequence) {
        return this.AX.isRtl(charSequence, 0, charSequence.length());
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
        if (isRtl != this.AW) {
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
        return unicodeWrap(str, this.AX, z);
    }

    public CharSequence unicodeWrap(CharSequence charSequence, boolean z) {
        return unicodeWrap(charSequence, this.AX, z);
    }

    public String unicodeWrap(String str) {
        return unicodeWrap(str, this.AX, true);
    }

    public CharSequence unicodeWrap(CharSequence charSequence) {
        return unicodeWrap(charSequence, this.AX, true);
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
        private static final byte[] AZ = new byte[1792];
        private final boolean Ba;
        private int Bb;
        private char Bc;
        private final int length;
        private final CharSequence text;

        static {
            for (int i = 0; i < 1792; i++) {
                AZ[i] = Character.getDirectionality(i);
            }
        }

        a(CharSequence charSequence, boolean z) {
            this.text = charSequence;
            this.Ba = z;
            this.length = charSequence.length();
        }

        int dI() {
            this.Bb = 0;
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            while (this.Bb < this.length && i == 0) {
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
            while (this.Bb > 0) {
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
            this.Bb = this.length;
            int i = 0;
            int i2 = 0;
            while (this.Bb > 0) {
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
            return c < 1792 ? AZ[c] : Character.getDirectionality(c);
        }

        byte dK() {
            this.Bc = this.text.charAt(this.Bb);
            if (Character.isHighSurrogate(this.Bc)) {
                int codePointAt = Character.codePointAt(this.text, this.Bb);
                this.Bb += Character.charCount(codePointAt);
                return Character.getDirectionality(codePointAt);
            }
            this.Bb++;
            byte d = d(this.Bc);
            if (this.Ba) {
                if (this.Bc == '<') {
                    return dM();
                }
                if (this.Bc == '&') {
                    return dO();
                }
                return d;
            }
            return d;
        }

        byte dL() {
            this.Bc = this.text.charAt(this.Bb - 1);
            if (Character.isLowSurrogate(this.Bc)) {
                int codePointBefore = Character.codePointBefore(this.text, this.Bb);
                this.Bb -= Character.charCount(codePointBefore);
                return Character.getDirectionality(codePointBefore);
            }
            this.Bb--;
            byte d = d(this.Bc);
            if (this.Ba) {
                if (this.Bc == '>') {
                    return dN();
                }
                if (this.Bc == ';') {
                    return dP();
                }
                return d;
            }
            return d;
        }

        private byte dM() {
            int i = this.Bb;
            while (this.Bb < this.length) {
                CharSequence charSequence = this.text;
                int i2 = this.Bb;
                this.Bb = i2 + 1;
                this.Bc = charSequence.charAt(i2);
                if (this.Bc == '>') {
                    return (byte) 12;
                }
                if (this.Bc == '\"' || this.Bc == '\'') {
                    char c = this.Bc;
                    while (this.Bb < this.length) {
                        CharSequence charSequence2 = this.text;
                        int i3 = this.Bb;
                        this.Bb = i3 + 1;
                        char charAt = charSequence2.charAt(i3);
                        this.Bc = charAt;
                        if (charAt == c) {
                            break;
                        }
                    }
                }
            }
            this.Bb = i;
            this.Bc = '<';
            return (byte) 13;
        }

        private byte dN() {
            int i = this.Bb;
            while (this.Bb > 0) {
                CharSequence charSequence = this.text;
                int i2 = this.Bb - 1;
                this.Bb = i2;
                this.Bc = charSequence.charAt(i2);
                if (this.Bc == '<') {
                    return (byte) 12;
                }
                if (this.Bc == '>') {
                    break;
                } else if (this.Bc == '\"' || this.Bc == '\'') {
                    char c = this.Bc;
                    while (this.Bb > 0) {
                        CharSequence charSequence2 = this.text;
                        int i3 = this.Bb - 1;
                        this.Bb = i3;
                        char charAt = charSequence2.charAt(i3);
                        this.Bc = charAt;
                        if (charAt == c) {
                            break;
                        }
                    }
                }
            }
            this.Bb = i;
            this.Bc = '>';
            return (byte) 13;
        }

        private byte dO() {
            while (this.Bb < this.length) {
                CharSequence charSequence = this.text;
                int i = this.Bb;
                this.Bb = i + 1;
                char charAt = charSequence.charAt(i);
                this.Bc = charAt;
                if (charAt == ';') {
                    return (byte) 12;
                }
            }
            return (byte) 12;
        }

        private byte dP() {
            int i = this.Bb;
            while (this.Bb > 0) {
                CharSequence charSequence = this.text;
                int i2 = this.Bb - 1;
                this.Bb = i2;
                this.Bc = charSequence.charAt(i2);
                if (this.Bc == '&') {
                    return (byte) 12;
                }
                if (this.Bc == ';') {
                    break;
                }
            }
            this.Bb = i;
            this.Bc = ';';
            return (byte) 13;
        }
    }
}
