package androidx.core.text;

import android.text.SpannableStringBuilder;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import io.flutter.plugin.common.StandardMessageCodec;
import java.util.Locale;
/* loaded from: classes.dex */
public final class BidiFormatter {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DEFAULT_FLAGS = 2;
    public static final BidiFormatter DEFAULT_LTR_INSTANCE;
    public static final BidiFormatter DEFAULT_RTL_INSTANCE;
    public static final TextDirectionHeuristicCompat DEFAULT_TEXT_DIRECTION_HEURISTIC;
    public static final int DIR_LTR = -1;
    public static final int DIR_RTL = 1;
    public static final int DIR_UNKNOWN = 0;
    public static final String EMPTY_STRING = "";
    public static final int FLAG_STEREO_RESET = 2;
    public static final char LRE = 8234;
    public static final char LRM = 8206;
    public static final String LRM_STRING;
    public static final char PDF = 8236;
    public static final char RLE = 8235;
    public static final char RLM = 8207;
    public static final String RLM_STRING;
    public transient /* synthetic */ FieldHolder $fh;
    public final TextDirectionHeuristicCompat mDefaultTextDirectionHeuristicCompat;
    public final int mFlags;
    public final boolean mIsRtlContext;

    /* loaded from: classes.dex */
    public static class DirectionalityEstimator {
        public static /* synthetic */ Interceptable $ic = null;
        public static final byte[] DIR_TYPE_CACHE;
        public static final int DIR_TYPE_CACHE_SIZE = 1792;
        public transient /* synthetic */ FieldHolder $fh;
        public int charIndex;
        public final boolean isHtml;
        public char lastChar;
        public final int length;
        public final CharSequence text;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-136376143, "Landroidx/core/text/BidiFormatter$DirectionalityEstimator;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-136376143, "Landroidx/core/text/BidiFormatter$DirectionalityEstimator;");
                    return;
                }
            }
            DIR_TYPE_CACHE = new byte[1792];
            for (int i2 = 0; i2 < 1792; i2++) {
                DIR_TYPE_CACHE[i2] = Character.getDirectionality(i2);
            }
        }

        public DirectionalityEstimator(CharSequence charSequence, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {charSequence, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.text = charSequence;
            this.isHtml = z;
            this.length = charSequence.length();
        }

        public static byte getCachedDirectionality(char c2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Character.valueOf(c2)})) == null) ? c2 < 1792 ? DIR_TYPE_CACHE[c2] : Character.getDirectionality(c2) : invokeCommon.byteValue;
        }

        private byte skipEntityBackward() {
            InterceptResult invokeV;
            char charAt;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
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
                this.lastChar = WebvttCueParser.CHAR_SEMI_COLON;
                return (byte) 13;
            }
            return invokeV.byteValue;
        }

        private byte skipEntityForward() {
            char charAt;
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
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
            return invokeV.byteValue;
        }

        private byte skipTagBackward() {
            InterceptResult invokeV;
            char charAt;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) {
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
                this.lastChar = '>';
                return (byte) 13;
            }
            return invokeV.byteValue;
        }

        private byte skipTagForward() {
            InterceptResult invokeV;
            char charAt;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeV = interceptable.invokeV(65542, this)) != null) {
                return invokeV.byteValue;
            }
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
                    this.lastChar = '<';
                    return (byte) 13;
                }
            }
        }

        public byte dirTypeBackward() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
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
            return invokeV.byteValue;
        }

        public byte dirTypeForward() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
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
            return invokeV.byteValue;
        }

        public int getEntryDir() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
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
            return invokeV.intValue;
        }

        public int getExitDir() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
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
            return invokeV.intValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-45562807, "Landroidx/core/text/BidiFormatter;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-45562807, "Landroidx/core/text/BidiFormatter;");
                return;
            }
        }
        DEFAULT_TEXT_DIRECTION_HEURISTIC = TextDirectionHeuristicsCompat.FIRSTSTRONG_LTR;
        LRM_STRING = Character.toString(LRM);
        RLM_STRING = Character.toString(RLM);
        DEFAULT_LTR_INSTANCE = new BidiFormatter(false, 2, DEFAULT_TEXT_DIRECTION_HEURISTIC);
        DEFAULT_RTL_INSTANCE = new BidiFormatter(true, 2, DEFAULT_TEXT_DIRECTION_HEURISTIC);
    }

    public BidiFormatter(boolean z, int i2, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z), Integer.valueOf(i2), textDirectionHeuristicCompat};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mIsRtlContext = z;
        this.mFlags = i2;
        this.mDefaultTextDirectionHeuristicCompat = textDirectionHeuristicCompat;
    }

    public static int getEntryDir(CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, charSequence)) == null) ? new DirectionalityEstimator(charSequence, false).getEntryDir() : invokeL.intValue;
    }

    public static int getExitDir(CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, charSequence)) == null) ? new DirectionalityEstimator(charSequence, false).getExitDir() : invokeL.intValue;
    }

    public static BidiFormatter getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? new Builder().build() : (BidiFormatter) invokeV.objValue;
    }

    public static boolean isRtlLocale(Locale locale) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, locale)) == null) ? TextUtilsCompat.getLayoutDirectionFromLocale(locale) == 1 : invokeL.booleanValue;
    }

    private String markAfter(CharSequence charSequence, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, this, charSequence, textDirectionHeuristicCompat)) == null) {
            boolean isRtl = textDirectionHeuristicCompat.isRtl(charSequence, 0, charSequence.length());
            if (this.mIsRtlContext || !(isRtl || getExitDir(charSequence) == 1)) {
                return this.mIsRtlContext ? (!isRtl || getExitDir(charSequence) == -1) ? RLM_STRING : "" : "";
            }
            return LRM_STRING;
        }
        return (String) invokeLL.objValue;
    }

    private String markBefore(CharSequence charSequence, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, this, charSequence, textDirectionHeuristicCompat)) == null) {
            boolean isRtl = textDirectionHeuristicCompat.isRtl(charSequence, 0, charSequence.length());
            if (this.mIsRtlContext || !(isRtl || getEntryDir(charSequence) == 1)) {
                return this.mIsRtlContext ? (!isRtl || getEntryDir(charSequence) == -1) ? RLM_STRING : "" : "";
            }
            return LRM_STRING;
        }
        return (String) invokeLL.objValue;
    }

    public boolean getStereoReset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? (this.mFlags & 2) != 0 : invokeV.booleanValue;
    }

    public boolean isRtl(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) ? isRtl((CharSequence) str) : invokeL.booleanValue;
    }

    public boolean isRtlContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mIsRtlContext : invokeV.booleanValue;
    }

    public String unicodeWrap(String str, TextDirectionHeuristicCompat textDirectionHeuristicCompat, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048586, this, str, textDirectionHeuristicCompat, z)) == null) {
            if (str == null) {
                return null;
            }
            return unicodeWrap((CharSequence) str, textDirectionHeuristicCompat, z).toString();
        }
        return (String) invokeLLZ.objValue;
    }

    /* loaded from: classes.dex */
    public static final class Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int mFlags;
        public boolean mIsRtlContext;
        public TextDirectionHeuristicCompat mTextDirectionHeuristicCompat;

        public Builder() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            initialize(BidiFormatter.isRtlLocale(Locale.getDefault()));
        }

        public static BidiFormatter getDefaultInstanceFromContext(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeZ = interceptable.invokeZ(65539, null, z)) == null) ? z ? BidiFormatter.DEFAULT_RTL_INSTANCE : BidiFormatter.DEFAULT_LTR_INSTANCE : (BidiFormatter) invokeZ.objValue;
        }

        private void initialize(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TRACKBALL, this, z) == null) {
                this.mIsRtlContext = z;
                this.mTextDirectionHeuristicCompat = BidiFormatter.DEFAULT_TEXT_DIRECTION_HEURISTIC;
                this.mFlags = 2;
            }
        }

        public BidiFormatter build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.mFlags == 2 && this.mTextDirectionHeuristicCompat == BidiFormatter.DEFAULT_TEXT_DIRECTION_HEURISTIC) {
                    return getDefaultInstanceFromContext(this.mIsRtlContext);
                }
                return new BidiFormatter(this.mIsRtlContext, this.mFlags, this.mTextDirectionHeuristicCompat);
            }
            return (BidiFormatter) invokeV.objValue;
        }

        public Builder setTextDirectionHeuristic(TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, textDirectionHeuristicCompat)) == null) {
                this.mTextDirectionHeuristicCompat = textDirectionHeuristicCompat;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder stereoReset(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z)) == null) {
                if (z) {
                    this.mFlags |= 2;
                } else {
                    this.mFlags &= -3;
                }
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z)};
                interceptable.invokeUnInit(65538, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            initialize(z);
        }

        public Builder(Locale locale) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {locale};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            initialize(BidiFormatter.isRtlLocale(locale));
        }
    }

    public static BidiFormatter getInstance(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZ = interceptable.invokeZ(65542, null, z)) == null) ? new Builder(z).build() : (BidiFormatter) invokeZ.objValue;
    }

    public boolean isRtl(CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence)) == null) ? this.mDefaultTextDirectionHeuristicCompat.isRtl(charSequence, 0, charSequence.length()) : invokeL.booleanValue;
    }

    public CharSequence unicodeWrap(CharSequence charSequence, TextDirectionHeuristicCompat textDirectionHeuristicCompat, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048582, this, charSequence, textDirectionHeuristicCompat, z)) == null) {
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
        return (CharSequence) invokeLLZ.objValue;
    }

    public static BidiFormatter getInstance(Locale locale) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, locale)) == null) ? new Builder(locale).build() : (BidiFormatter) invokeL.objValue;
    }

    public String unicodeWrap(String str, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, str, textDirectionHeuristicCompat)) == null) ? unicodeWrap(str, textDirectionHeuristicCompat, true) : (String) invokeLL.objValue;
    }

    public CharSequence unicodeWrap(CharSequence charSequence, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, charSequence, textDirectionHeuristicCompat)) == null) ? unicodeWrap(charSequence, textDirectionHeuristicCompat, true) : (CharSequence) invokeLL.objValue;
    }

    public String unicodeWrap(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048587, this, str, z)) == null) ? unicodeWrap(str, this.mDefaultTextDirectionHeuristicCompat, z) : (String) invokeLZ.objValue;
    }

    public CharSequence unicodeWrap(CharSequence charSequence, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048583, this, charSequence, z)) == null) ? unicodeWrap(charSequence, this.mDefaultTextDirectionHeuristicCompat, z) : (CharSequence) invokeLZ.objValue;
    }

    public String unicodeWrap(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) ? unicodeWrap(str, this.mDefaultTextDirectionHeuristicCompat, true) : (String) invokeL.objValue;
    }

    public CharSequence unicodeWrap(CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, charSequence)) == null) ? unicodeWrap(charSequence, this.mDefaultTextDirectionHeuristicCompat, true) : (CharSequence) invokeL.objValue;
    }
}
