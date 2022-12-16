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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            initialize(BidiFormatter.isRtlLocale(Locale.getDefault()));
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

        public Builder(Locale locale) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {locale};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            initialize(BidiFormatter.isRtlLocale(locale));
        }

        public Builder(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z)};
                interceptable.invokeUnInit(65538, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            initialize(z);
        }

        public static BidiFormatter getDefaultInstanceFromContext(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(65539, null, z)) == null) {
                if (z) {
                    return BidiFormatter.DEFAULT_RTL_INSTANCE;
                }
                return BidiFormatter.DEFAULT_LTR_INSTANCE;
            }
            return (BidiFormatter) invokeZ.objValue;
        }

        private void initialize(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TRACKBALL, this, z) == null) {
                this.mIsRtlContext = z;
                this.mTextDirectionHeuristicCompat = BidiFormatter.DEFAULT_TEXT_DIRECTION_HEURISTIC;
                this.mFlags = 2;
            }
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
    }

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
            for (int i = 0; i < 1792; i++) {
                DIR_TYPE_CACHE[i] = Character.getDirectionality(i);
            }
        }

        private byte skipEntityBackward() {
            InterceptResult invokeV;
            char charAt;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
                int i = this.charIndex;
                do {
                    int i2 = this.charIndex;
                    if (i2 <= 0) {
                        break;
                    }
                    CharSequence charSequence = this.text;
                    int i3 = i2 - 1;
                    this.charIndex = i3;
                    charAt = charSequence.charAt(i3);
                    this.lastChar = charAt;
                    if (charAt == '&') {
                        return (byte) 12;
                    }
                } while (charAt != ';');
                this.charIndex = i;
                this.lastChar = WebvttCueParser.CHAR_SEMI_COLON;
                return (byte) 13;
            }
            return invokeV.byteValue;
        }

        public DirectionalityEstimator(CharSequence charSequence, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {charSequence, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.text = charSequence;
            this.isHtml = z;
            this.length = charSequence.length();
        }

        public static byte getCachedDirectionality(char c) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Character.valueOf(c)})) == null) {
                if (c < 1792) {
                    return DIR_TYPE_CACHE[c];
                }
                return Character.getDirectionality(c);
            }
            return invokeCommon.byteValue;
        }

        private byte skipEntityForward() {
            char charAt;
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
                do {
                    int i = this.charIndex;
                    if (i < this.length) {
                        CharSequence charSequence = this.text;
                        this.charIndex = i + 1;
                        charAt = charSequence.charAt(i);
                        this.lastChar = charAt;
                    } else {
                        return (byte) 12;
                    }
                } while (charAt != ';');
                return (byte) 12;
            }
            return invokeV.byteValue;
        }

        private byte skipTagBackward() {
            InterceptResult invokeV;
            char charAt;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) {
                int i = this.charIndex;
                while (true) {
                    int i2 = this.charIndex;
                    if (i2 <= 0) {
                        break;
                    }
                    CharSequence charSequence = this.text;
                    int i3 = i2 - 1;
                    this.charIndex = i3;
                    char charAt2 = charSequence.charAt(i3);
                    this.lastChar = charAt2;
                    if (charAt2 == '<') {
                        return (byte) 12;
                    }
                    if (charAt2 == '>') {
                        break;
                    } else if (charAt2 == '\"' || charAt2 == '\'') {
                        char c = this.lastChar;
                        do {
                            int i4 = this.charIndex;
                            if (i4 > 0) {
                                CharSequence charSequence2 = this.text;
                                int i5 = i4 - 1;
                                this.charIndex = i5;
                                charAt = charSequence2.charAt(i5);
                                this.lastChar = charAt;
                            }
                        } while (charAt != c);
                    }
                }
                this.charIndex = i;
                this.lastChar = '>';
                return (byte) 13;
            }
            return invokeV.byteValue;
        }

        private byte skipTagForward() {
            InterceptResult invokeV;
            char charAt;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) {
                int i = this.charIndex;
                while (true) {
                    int i2 = this.charIndex;
                    if (i2 < this.length) {
                        CharSequence charSequence = this.text;
                        this.charIndex = i2 + 1;
                        char charAt2 = charSequence.charAt(i2);
                        this.lastChar = charAt2;
                        if (charAt2 == '>') {
                            return (byte) 12;
                        }
                        if (charAt2 == '\"' || charAt2 == '\'') {
                            char c = this.lastChar;
                            do {
                                int i3 = this.charIndex;
                                if (i3 < this.length) {
                                    CharSequence charSequence2 = this.text;
                                    this.charIndex = i3 + 1;
                                    charAt = charSequence2.charAt(i3);
                                    this.lastChar = charAt;
                                }
                            } while (charAt != c);
                        }
                    } else {
                        this.charIndex = i;
                        this.lastChar = '<';
                        return (byte) 13;
                    }
                }
            } else {
                return invokeV.byteValue;
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
                    char c = this.lastChar;
                    if (c == '>') {
                        return skipTagBackward();
                    }
                    if (c == ';') {
                        return skipEntityBackward();
                    }
                    return cachedDirectionality;
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
                    char c = this.lastChar;
                    if (c == '<') {
                        return skipTagForward();
                    }
                    if (c == '&') {
                        return skipEntityForward();
                    }
                    return cachedDirectionality;
                }
                return cachedDirectionality;
            }
            return invokeV.byteValue;
        }

        public int getExitDir() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                this.charIndex = this.length;
                int i = 0;
                int i2 = 0;
                while (this.charIndex > 0) {
                    byte dirTypeBackward = dirTypeBackward();
                    if (dirTypeBackward != 0) {
                        if (dirTypeBackward != 1 && dirTypeBackward != 2) {
                            if (dirTypeBackward != 9) {
                                switch (dirTypeBackward) {
                                    case 14:
                                    case 15:
                                        if (i2 == i) {
                                            return -1;
                                        }
                                        i--;
                                        break;
                                    case 16:
                                    case 17:
                                        if (i2 == i) {
                                            return 1;
                                        }
                                        i--;
                                        break;
                                    case 18:
                                        i++;
                                        break;
                                    default:
                                        if (i2 != 0) {
                                            break;
                                        } else {
                                            i2 = i;
                                            break;
                                        }
                                }
                            } else {
                                continue;
                            }
                        } else if (i == 0) {
                            return 1;
                        } else {
                            if (i2 == 0) {
                                i2 = i;
                            }
                        }
                    } else if (i == 0) {
                        return -1;
                    } else {
                        if (i2 == 0) {
                            i2 = i;
                        }
                    }
                }
                return 0;
            }
            return invokeV.intValue;
        }

        public int getEntryDir() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                this.charIndex = 0;
                int i = 0;
                int i2 = 0;
                int i3 = 0;
                while (this.charIndex < this.length && i == 0) {
                    byte dirTypeForward = dirTypeForward();
                    if (dirTypeForward != 0) {
                        if (dirTypeForward != 1 && dirTypeForward != 2) {
                            if (dirTypeForward != 9) {
                                switch (dirTypeForward) {
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
                        } else if (i3 == 0) {
                            return 1;
                        }
                    } else if (i3 == 0) {
                        return -1;
                    }
                    i = i3;
                }
                if (i == 0) {
                    return 0;
                }
                if (i2 != 0) {
                    return i2;
                }
                while (this.charIndex > 0) {
                    switch (dirTypeBackward()) {
                        case 14:
                        case 15:
                            if (i == i3) {
                                return -1;
                            }
                            break;
                        case 16:
                        case 17:
                            if (i == i3) {
                                return 1;
                            }
                            break;
                        case 18:
                            i3++;
                            continue;
                    }
                    i3--;
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

    public BidiFormatter(boolean z, int i, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z), Integer.valueOf(i), textDirectionHeuristicCompat};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mIsRtlContext = z;
        this.mFlags = i;
        this.mDefaultTextDirectionHeuristicCompat = textDirectionHeuristicCompat;
    }

    public static int getEntryDir(CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, charSequence)) == null) {
            return new DirectionalityEstimator(charSequence, false).getEntryDir();
        }
        return invokeL.intValue;
    }

    public static int getExitDir(CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, charSequence)) == null) {
            return new DirectionalityEstimator(charSequence, false).getExitDir();
        }
        return invokeL.intValue;
    }

    public static BidiFormatter getInstance(Locale locale) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, locale)) == null) {
            return new Builder(locale).build();
        }
        return (BidiFormatter) invokeL.objValue;
    }

    public static boolean isRtlLocale(Locale locale) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, locale)) == null) {
            if (TextUtilsCompat.getLayoutDirectionFromLocale(locale) == 1) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean isRtl(CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence)) == null) {
            return this.mDefaultTextDirectionHeuristicCompat.isRtl(charSequence, 0, charSequence.length());
        }
        return invokeL.booleanValue;
    }

    public CharSequence unicodeWrap(CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, charSequence)) == null) {
            return unicodeWrap(charSequence, this.mDefaultTextDirectionHeuristicCompat, true);
        }
        return (CharSequence) invokeL.objValue;
    }

    public static BidiFormatter getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return new Builder().build();
        }
        return (BidiFormatter) invokeV.objValue;
    }

    public boolean getStereoReset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if ((this.mFlags & 2) != 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isRtlContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mIsRtlContext;
        }
        return invokeV.booleanValue;
    }

    public static BidiFormatter getInstance(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65542, null, z)) == null) {
            return new Builder(z).build();
        }
        return (BidiFormatter) invokeZ.objValue;
    }

    public boolean isRtl(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            return isRtl((CharSequence) str);
        }
        return invokeL.booleanValue;
    }

    public String unicodeWrap(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            return unicodeWrap(str, this.mDefaultTextDirectionHeuristicCompat, true);
        }
        return (String) invokeL.objValue;
    }

    private String markAfter(CharSequence charSequence, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, this, charSequence, textDirectionHeuristicCompat)) == null) {
            boolean isRtl = textDirectionHeuristicCompat.isRtl(charSequence, 0, charSequence.length());
            if (!this.mIsRtlContext && (isRtl || getExitDir(charSequence) == 1)) {
                return LRM_STRING;
            }
            if (this.mIsRtlContext) {
                if (!isRtl || getExitDir(charSequence) == -1) {
                    return RLM_STRING;
                }
                return "";
            }
            return "";
        }
        return (String) invokeLL.objValue;
    }

    private String markBefore(CharSequence charSequence, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, this, charSequence, textDirectionHeuristicCompat)) == null) {
            boolean isRtl = textDirectionHeuristicCompat.isRtl(charSequence, 0, charSequence.length());
            if (!this.mIsRtlContext && (isRtl || getEntryDir(charSequence) == 1)) {
                return LRM_STRING;
            }
            if (this.mIsRtlContext) {
                if (!isRtl || getEntryDir(charSequence) == -1) {
                    return RLM_STRING;
                }
                return "";
            }
            return "";
        }
        return (String) invokeLL.objValue;
    }

    public CharSequence unicodeWrap(CharSequence charSequence, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, charSequence, textDirectionHeuristicCompat)) == null) {
            return unicodeWrap(charSequence, textDirectionHeuristicCompat, true);
        }
        return (CharSequence) invokeLL.objValue;
    }

    public CharSequence unicodeWrap(CharSequence charSequence, TextDirectionHeuristicCompat textDirectionHeuristicCompat, boolean z) {
        InterceptResult invokeLLZ;
        TextDirectionHeuristicCompat textDirectionHeuristicCompat2;
        char c;
        TextDirectionHeuristicCompat textDirectionHeuristicCompat3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048582, this, charSequence, textDirectionHeuristicCompat, z)) == null) {
            if (charSequence == null) {
                return null;
            }
            boolean isRtl = textDirectionHeuristicCompat.isRtl(charSequence, 0, charSequence.length());
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (getStereoReset() && z) {
                if (isRtl) {
                    textDirectionHeuristicCompat3 = TextDirectionHeuristicsCompat.RTL;
                } else {
                    textDirectionHeuristicCompat3 = TextDirectionHeuristicsCompat.LTR;
                }
                spannableStringBuilder.append((CharSequence) markBefore(charSequence, textDirectionHeuristicCompat3));
            }
            if (isRtl != this.mIsRtlContext) {
                if (isRtl) {
                    c = RLE;
                } else {
                    c = LRE;
                }
                spannableStringBuilder.append(c);
                spannableStringBuilder.append(charSequence);
                spannableStringBuilder.append(PDF);
            } else {
                spannableStringBuilder.append(charSequence);
            }
            if (z) {
                if (isRtl) {
                    textDirectionHeuristicCompat2 = TextDirectionHeuristicsCompat.RTL;
                } else {
                    textDirectionHeuristicCompat2 = TextDirectionHeuristicsCompat.LTR;
                }
                spannableStringBuilder.append((CharSequence) markAfter(charSequence, textDirectionHeuristicCompat2));
            }
            return spannableStringBuilder;
        }
        return (CharSequence) invokeLLZ.objValue;
    }

    public CharSequence unicodeWrap(CharSequence charSequence, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048583, this, charSequence, z)) == null) {
            return unicodeWrap(charSequence, this.mDefaultTextDirectionHeuristicCompat, z);
        }
        return (CharSequence) invokeLZ.objValue;
    }

    public String unicodeWrap(String str, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, str, textDirectionHeuristicCompat)) == null) {
            return unicodeWrap(str, textDirectionHeuristicCompat, true);
        }
        return (String) invokeLL.objValue;
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

    public String unicodeWrap(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048587, this, str, z)) == null) {
            return unicodeWrap(str, this.mDefaultTextDirectionHeuristicCompat, z);
        }
        return (String) invokeLZ.objValue;
    }
}
