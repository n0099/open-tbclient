package androidx.core.text;

import android.text.SpannableStringBuilder;
import io.flutter.plugin.common.StandardMessageCodec;
import java.util.Locale;
import kotlin.text.Typography;
/* loaded from: classes.dex */
public final class BidiFormatter {
    public static final int DEFAULT_FLAGS = 2;
    public static final int DIR_LTR = -1;
    public static final int DIR_RTL = 1;
    public static final int DIR_UNKNOWN = 0;
    public static final String EMPTY_STRING = "";
    public static final int FLAG_STEREO_RESET = 2;
    public static final char LRE = 8234;
    public static final char PDF = 8236;
    public static final char RLE = 8235;
    public final TextDirectionHeuristicCompat mDefaultTextDirectionHeuristicCompat;
    public final int mFlags;
    public final boolean mIsRtlContext;
    public static final TextDirectionHeuristicCompat DEFAULT_TEXT_DIRECTION_HEURISTIC = TextDirectionHeuristicsCompat.FIRSTSTRONG_LTR;
    public static final char LRM = 8206;
    public static final String LRM_STRING = Character.toString(LRM);
    public static final char RLM = 8207;
    public static final String RLM_STRING = Character.toString(RLM);
    public static final BidiFormatter DEFAULT_LTR_INSTANCE = new BidiFormatter(false, 2, DEFAULT_TEXT_DIRECTION_HEURISTIC);
    public static final BidiFormatter DEFAULT_RTL_INSTANCE = new BidiFormatter(true, 2, DEFAULT_TEXT_DIRECTION_HEURISTIC);

    /* loaded from: classes.dex */
    public static class DirectionalityEstimator {
        public static final byte[] DIR_TYPE_CACHE = new byte[1792];
        public static final int DIR_TYPE_CACHE_SIZE = 1792;
        public int charIndex;
        public final boolean isHtml;
        public char lastChar;
        public final int length;
        public final CharSequence text;

        static {
            for (int i2 = 0; i2 < 1792; i2++) {
                DIR_TYPE_CACHE[i2] = Character.getDirectionality(i2);
            }
        }

        public DirectionalityEstimator(CharSequence charSequence, boolean z) {
            this.text = charSequence;
            this.isHtml = z;
            this.length = charSequence.length();
        }

        public static byte getCachedDirectionality(char c2) {
            return c2 < 1792 ? DIR_TYPE_CACHE[c2] : Character.getDirectionality(c2);
        }

        private byte skipEntityBackward() {
            char charAt;
            int i2 = this.charIndex;
            do {
                int i3 = this.charIndex;
                if (i3 <= 0) {
                    break;
                }
                CharSequence charSequence = this.text;
                int i4 = i3 - 1;
                this.charIndex = i4;
                charAt = charSequence.charAt(i4);
                this.lastChar = charAt;
                if (charAt == '&') {
                    return StandardMessageCodec.LIST;
                }
            } while (charAt != ';');
            this.charIndex = i2;
            this.lastChar = ';';
            return (byte) 13;
        }

        private byte skipEntityForward() {
            char charAt;
            do {
                int i2 = this.charIndex;
                if (i2 >= this.length) {
                    return StandardMessageCodec.LIST;
                }
                CharSequence charSequence = this.text;
                this.charIndex = i2 + 1;
                charAt = charSequence.charAt(i2);
                this.lastChar = charAt;
            } while (charAt != ';');
            return StandardMessageCodec.LIST;
        }

        private byte skipTagBackward() {
            char charAt;
            int i2 = this.charIndex;
            while (true) {
                int i3 = this.charIndex;
                if (i3 <= 0) {
                    break;
                }
                CharSequence charSequence = this.text;
                int i4 = i3 - 1;
                this.charIndex = i4;
                char charAt2 = charSequence.charAt(i4);
                this.lastChar = charAt2;
                if (charAt2 == '<') {
                    return StandardMessageCodec.LIST;
                }
                if (charAt2 == '>') {
                    break;
                } else if (charAt2 == '\"' || charAt2 == '\'') {
                    char c2 = this.lastChar;
                    do {
                        int i5 = this.charIndex;
                        if (i5 > 0) {
                            CharSequence charSequence2 = this.text;
                            int i6 = i5 - 1;
                            this.charIndex = i6;
                            charAt = charSequence2.charAt(i6);
                            this.lastChar = charAt;
                        }
                    } while (charAt != c2);
                }
            }
            this.charIndex = i2;
            this.lastChar = Typography.greater;
            return (byte) 13;
        }

        private byte skipTagForward() {
            char charAt;
            int i2 = this.charIndex;
            while (true) {
                int i3 = this.charIndex;
                if (i3 < this.length) {
                    CharSequence charSequence = this.text;
                    this.charIndex = i3 + 1;
                    char charAt2 = charSequence.charAt(i3);
                    this.lastChar = charAt2;
                    if (charAt2 == '>') {
                        return StandardMessageCodec.LIST;
                    }
                    if (charAt2 == '\"' || charAt2 == '\'') {
                        char c2 = this.lastChar;
                        do {
                            int i4 = this.charIndex;
                            if (i4 < this.length) {
                                CharSequence charSequence2 = this.text;
                                this.charIndex = i4 + 1;
                                charAt = charSequence2.charAt(i4);
                                this.lastChar = charAt;
                            }
                        } while (charAt != c2);
                    }
                } else {
                    this.charIndex = i2;
                    this.lastChar = Typography.less;
                    return (byte) 13;
                }
            }
        }

        public byte dirTypeBackward() {
            char charAt = this.text.charAt(this.charIndex - 1);
            this.lastChar = charAt;
            if (Character.isLowSurrogate(charAt)) {
                int codePointBefore = Character.codePointBefore(this.text, this.charIndex);
                this.charIndex -= Character.charCount(codePointBefore);
                return Character.getDirectionality(codePointBefore);
            }
            this.charIndex--;
            byte cachedDirectionality = getCachedDirectionality(this.lastChar);
            if (this.isHtml) {
                char c2 = this.lastChar;
                if (c2 == '>') {
                    return skipTagBackward();
                }
                return c2 == ';' ? skipEntityBackward() : cachedDirectionality;
            }
            return cachedDirectionality;
        }

        public byte dirTypeForward() {
            char charAt = this.text.charAt(this.charIndex);
            this.lastChar = charAt;
            if (Character.isHighSurrogate(charAt)) {
                int codePointAt = Character.codePointAt(this.text, this.charIndex);
                this.charIndex += Character.charCount(codePointAt);
                return Character.getDirectionality(codePointAt);
            }
            this.charIndex++;
            byte cachedDirectionality = getCachedDirectionality(this.lastChar);
            if (this.isHtml) {
                char c2 = this.lastChar;
                if (c2 == '<') {
                    return skipTagForward();
                }
                return c2 == '&' ? skipEntityForward() : cachedDirectionality;
            }
            return cachedDirectionality;
        }

        public int getEntryDir() {
            this.charIndex = 0;
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            while (this.charIndex < this.length && i2 == 0) {
                byte dirTypeForward = dirTypeForward();
                if (dirTypeForward != 0) {
                    if (dirTypeForward == 1 || dirTypeForward == 2) {
                        if (i4 == 0) {
                            return 1;
                        }
                    } else if (dirTypeForward != 9) {
                        switch (dirTypeForward) {
                            case 14:
                            case 15:
                                i4++;
                                i3 = -1;
                                break;
                            case 16:
                            case 17:
                                i4++;
                                i3 = 1;
                                break;
                            case 18:
                                i4--;
                                i3 = 0;
                                break;
                        }
                    }
                } else if (i4 == 0) {
                    return -1;
                }
                i2 = i4;
            }
            if (i2 == 0) {
                return 0;
            }
            if (i3 != 0) {
                return i3;
            }
            while (this.charIndex > 0) {
                switch (dirTypeBackward()) {
                    case 14:
                    case 15:
                        if (i2 == i4) {
                            return -1;
                        }
                        break;
                    case 16:
                    case 17:
                        if (i2 == i4) {
                            return 1;
                        }
                        break;
                    case 18:
                        i4++;
                        continue;
                }
                i4--;
            }
            return 0;
        }

        public int getExitDir() {
            this.charIndex = this.length;
            int i2 = 0;
            int i3 = 0;
            while (this.charIndex > 0) {
                byte dirTypeBackward = dirTypeBackward();
                if (dirTypeBackward != 0) {
                    if (dirTypeBackward == 1 || dirTypeBackward == 2) {
                        if (i2 == 0) {
                            return 1;
                        }
                        if (i3 == 0) {
                            i3 = i2;
                        }
                    } else if (dirTypeBackward != 9) {
                        switch (dirTypeBackward) {
                            case 14:
                            case 15:
                                if (i3 == i2) {
                                    return -1;
                                }
                                i2--;
                                break;
                            case 16:
                            case 17:
                                if (i3 == i2) {
                                    return 1;
                                }
                                i2--;
                                break;
                            case 18:
                                i2++;
                                break;
                            default:
                                if (i3 != 0) {
                                    break;
                                } else {
                                    i3 = i2;
                                    break;
                                }
                        }
                    } else {
                        continue;
                    }
                } else if (i2 == 0) {
                    return -1;
                } else {
                    if (i3 == 0) {
                        i3 = i2;
                    }
                }
            }
            return 0;
        }
    }

    public BidiFormatter(boolean z, int i2, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        this.mIsRtlContext = z;
        this.mFlags = i2;
        this.mDefaultTextDirectionHeuristicCompat = textDirectionHeuristicCompat;
    }

    public static int getEntryDir(CharSequence charSequence) {
        return new DirectionalityEstimator(charSequence, false).getEntryDir();
    }

    public static int getExitDir(CharSequence charSequence) {
        return new DirectionalityEstimator(charSequence, false).getExitDir();
    }

    public static BidiFormatter getInstance() {
        return new Builder().build();
    }

    public static boolean isRtlLocale(Locale locale) {
        return TextUtilsCompat.getLayoutDirectionFromLocale(locale) == 1;
    }

    private String markAfter(CharSequence charSequence, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        boolean isRtl = textDirectionHeuristicCompat.isRtl(charSequence, 0, charSequence.length());
        if (this.mIsRtlContext || !(isRtl || getExitDir(charSequence) == 1)) {
            return this.mIsRtlContext ? (!isRtl || getExitDir(charSequence) == -1) ? RLM_STRING : "" : "";
        }
        return LRM_STRING;
    }

    private String markBefore(CharSequence charSequence, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        boolean isRtl = textDirectionHeuristicCompat.isRtl(charSequence, 0, charSequence.length());
        if (this.mIsRtlContext || !(isRtl || getEntryDir(charSequence) == 1)) {
            return this.mIsRtlContext ? (!isRtl || getEntryDir(charSequence) == -1) ? RLM_STRING : "" : "";
        }
        return LRM_STRING;
    }

    public boolean getStereoReset() {
        return (this.mFlags & 2) != 0;
    }

    public boolean isRtl(String str) {
        return isRtl((CharSequence) str);
    }

    public boolean isRtlContext() {
        return this.mIsRtlContext;
    }

    public String unicodeWrap(String str, TextDirectionHeuristicCompat textDirectionHeuristicCompat, boolean z) {
        if (str == null) {
            return null;
        }
        return unicodeWrap((CharSequence) str, textDirectionHeuristicCompat, z).toString();
    }

    /* loaded from: classes.dex */
    public static final class Builder {
        public int mFlags;
        public boolean mIsRtlContext;
        public TextDirectionHeuristicCompat mTextDirectionHeuristicCompat;

        public Builder() {
            initialize(BidiFormatter.isRtlLocale(Locale.getDefault()));
        }

        public static BidiFormatter getDefaultInstanceFromContext(boolean z) {
            return z ? BidiFormatter.DEFAULT_RTL_INSTANCE : BidiFormatter.DEFAULT_LTR_INSTANCE;
        }

        private void initialize(boolean z) {
            this.mIsRtlContext = z;
            this.mTextDirectionHeuristicCompat = BidiFormatter.DEFAULT_TEXT_DIRECTION_HEURISTIC;
            this.mFlags = 2;
        }

        public BidiFormatter build() {
            if (this.mFlags == 2 && this.mTextDirectionHeuristicCompat == BidiFormatter.DEFAULT_TEXT_DIRECTION_HEURISTIC) {
                return getDefaultInstanceFromContext(this.mIsRtlContext);
            }
            return new BidiFormatter(this.mIsRtlContext, this.mFlags, this.mTextDirectionHeuristicCompat);
        }

        public Builder setTextDirectionHeuristic(TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
            this.mTextDirectionHeuristicCompat = textDirectionHeuristicCompat;
            return this;
        }

        public Builder stereoReset(boolean z) {
            if (z) {
                this.mFlags |= 2;
            } else {
                this.mFlags &= -3;
            }
            return this;
        }

        public Builder(boolean z) {
            initialize(z);
        }

        public Builder(Locale locale) {
            initialize(BidiFormatter.isRtlLocale(locale));
        }
    }

    public static BidiFormatter getInstance(boolean z) {
        return new Builder(z).build();
    }

    public boolean isRtl(CharSequence charSequence) {
        return this.mDefaultTextDirectionHeuristicCompat.isRtl(charSequence, 0, charSequence.length());
    }

    public CharSequence unicodeWrap(CharSequence charSequence, TextDirectionHeuristicCompat textDirectionHeuristicCompat, boolean z) {
        if (charSequence == null) {
            return null;
        }
        boolean isRtl = textDirectionHeuristicCompat.isRtl(charSequence, 0, charSequence.length());
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (getStereoReset() && z) {
            spannableStringBuilder.append((CharSequence) markBefore(charSequence, isRtl ? TextDirectionHeuristicsCompat.RTL : TextDirectionHeuristicsCompat.LTR));
        }
        if (isRtl != this.mIsRtlContext) {
            spannableStringBuilder.append(isRtl ? RLE : LRE);
            spannableStringBuilder.append(charSequence);
            spannableStringBuilder.append(PDF);
        } else {
            spannableStringBuilder.append(charSequence);
        }
        if (z) {
            spannableStringBuilder.append((CharSequence) markAfter(charSequence, isRtl ? TextDirectionHeuristicsCompat.RTL : TextDirectionHeuristicsCompat.LTR));
        }
        return spannableStringBuilder;
    }

    public static BidiFormatter getInstance(Locale locale) {
        return new Builder(locale).build();
    }

    public String unicodeWrap(String str, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        return unicodeWrap(str, textDirectionHeuristicCompat, true);
    }

    public CharSequence unicodeWrap(CharSequence charSequence, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        return unicodeWrap(charSequence, textDirectionHeuristicCompat, true);
    }

    public String unicodeWrap(String str, boolean z) {
        return unicodeWrap(str, this.mDefaultTextDirectionHeuristicCompat, z);
    }

    public CharSequence unicodeWrap(CharSequence charSequence, boolean z) {
        return unicodeWrap(charSequence, this.mDefaultTextDirectionHeuristicCompat, z);
    }

    public String unicodeWrap(String str) {
        return unicodeWrap(str, this.mDefaultTextDirectionHeuristicCompat, true);
    }

    public CharSequence unicodeWrap(CharSequence charSequence) {
        return unicodeWrap(charSequence, this.mDefaultTextDirectionHeuristicCompat, true);
    }
}
