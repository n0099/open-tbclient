package androidx.core.view.inputmethod;

import android.os.Build;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.inputmethod.EditorInfo;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import androidx.core.util.Preconditions;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public final class EditorInfoCompat {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String CONTENT_MIME_TYPES_INTEROP_KEY = "android.support.v13.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES";
    public static final String CONTENT_MIME_TYPES_KEY = "androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES";
    public static final String CONTENT_SELECTION_END_KEY = "androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SELECTION_END";
    public static final String CONTENT_SELECTION_HEAD_KEY = "androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SELECTION_HEAD";
    public static final String CONTENT_SURROUNDING_TEXT_KEY = "androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SURROUNDING_TEXT";
    public static final String[] EMPTY_STRING_ARRAY;
    public static final int IME_FLAG_FORCE_ASCII = Integer.MIN_VALUE;
    public static final int IME_FLAG_NO_PERSONALIZED_LEARNING = 16777216;
    @VisibleForTesting
    public static final int MAX_INITIAL_SELECTION_LENGTH = 1024;
    @VisibleForTesting
    public static final int MEMORY_EFFICIENT_TEXT_LENGTH = 2048;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean isPasswordInputType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65544, null, i)) == null) {
            int i2 = i & 4095;
            return i2 == 129 || i2 == 225 || i2 == 18;
        }
        return invokeI.booleanValue;
    }

    @RequiresApi(30)
    /* loaded from: classes.dex */
    public static class Impl30 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public Impl30() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public static CharSequence getInitialSelectedText(@NonNull EditorInfo editorInfo, int i) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, editorInfo, i)) == null) {
                return editorInfo.getInitialSelectedText(i);
            }
            return (CharSequence) invokeLI.objValue;
        }

        public static CharSequence getInitialTextAfterCursor(@NonNull EditorInfo editorInfo, int i, int i2) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(65538, null, editorInfo, i, i2)) == null) {
                return editorInfo.getInitialTextAfterCursor(i, i2);
            }
            return (CharSequence) invokeLII.objValue;
        }

        public static CharSequence getInitialTextBeforeCursor(@NonNull EditorInfo editorInfo, int i, int i2) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(65539, null, editorInfo, i, i2)) == null) {
                return editorInfo.getInitialTextBeforeCursor(i, i2);
            }
            return (CharSequence) invokeLII.objValue;
        }

        public static void setInitialSurroundingSubText(@NonNull EditorInfo editorInfo, CharSequence charSequence, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(InputDeviceCompat.SOURCE_TRACKBALL, null, editorInfo, charSequence, i) == null) {
                editorInfo.setInitialSurroundingSubText(charSequence, i);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2064546662, "Landroidx/core/view/inputmethod/EditorInfoCompat;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2064546662, "Landroidx/core/view/inputmethod/EditorInfoCompat;");
                return;
            }
        }
        EMPTY_STRING_ARRAY = new String[0];
    }

    @Deprecated
    public EditorInfoCompat() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @NonNull
    public static String[] getContentMimeTypes(EditorInfo editorInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, editorInfo)) == null) {
            if (Build.VERSION.SDK_INT >= 25) {
                String[] strArr = editorInfo.contentMimeTypes;
                if (strArr == null) {
                    return EMPTY_STRING_ARRAY;
                }
                return strArr;
            }
            Bundle bundle = editorInfo.extras;
            if (bundle == null) {
                return EMPTY_STRING_ARRAY;
            }
            String[] stringArray = bundle.getStringArray(CONTENT_MIME_TYPES_KEY);
            if (stringArray == null) {
                stringArray = editorInfo.extras.getStringArray(CONTENT_MIME_TYPES_INTEROP_KEY);
            }
            if (stringArray == null) {
                return EMPTY_STRING_ARRAY;
            }
            return stringArray;
        }
        return (String[]) invokeL.objValue;
    }

    public static int getProtocol(EditorInfo editorInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, editorInfo)) == null) {
            if (Build.VERSION.SDK_INT >= 25) {
                return 1;
            }
            Bundle bundle = editorInfo.extras;
            if (bundle == null) {
                return 0;
            }
            boolean containsKey = bundle.containsKey(CONTENT_MIME_TYPES_KEY);
            boolean containsKey2 = editorInfo.extras.containsKey(CONTENT_MIME_TYPES_INTEROP_KEY);
            if (containsKey && containsKey2) {
                return 4;
            }
            if (containsKey) {
                return 3;
            }
            if (!containsKey2) {
                return 0;
            }
            return 2;
        }
        return invokeL.intValue;
    }

    @Nullable
    public static CharSequence getInitialSelectedText(@NonNull EditorInfo editorInfo, int i) {
        InterceptResult invokeLI;
        CharSequence charSequence;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, editorInfo, i)) == null) {
            if (Build.VERSION.SDK_INT >= 30) {
                return Impl30.getInitialSelectedText(editorInfo, i);
            }
            if (editorInfo.extras == null) {
                return null;
            }
            int i2 = editorInfo.initialSelStart;
            int i3 = editorInfo.initialSelEnd;
            if (i2 > i3) {
                i2 = i3;
            }
            int i4 = editorInfo.initialSelStart;
            int i5 = editorInfo.initialSelEnd;
            if (i4 <= i5) {
                i4 = i5;
            }
            int i6 = editorInfo.extras.getInt(CONTENT_SELECTION_HEAD_KEY);
            int i7 = editorInfo.extras.getInt(CONTENT_SELECTION_END_KEY);
            int i8 = i4 - i2;
            if (editorInfo.initialSelStart < 0 || editorInfo.initialSelEnd < 0 || i7 - i6 != i8 || (charSequence = editorInfo.extras.getCharSequence(CONTENT_SURROUNDING_TEXT_KEY)) == null) {
                return null;
            }
            if ((i & 1) != 0) {
                return charSequence.subSequence(i6, i7);
            }
            return TextUtils.substring(charSequence, i6, i7);
        }
        return (CharSequence) invokeLI.objValue;
    }

    @Nullable
    public static CharSequence getInitialTextAfterCursor(@NonNull EditorInfo editorInfo, int i, int i2) {
        InterceptResult invokeLII;
        CharSequence charSequence;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(InputDeviceCompat.SOURCE_TRACKBALL, null, editorInfo, i, i2)) == null) {
            if (Build.VERSION.SDK_INT >= 30) {
                return Impl30.getInitialTextAfterCursor(editorInfo, i, i2);
            }
            Bundle bundle = editorInfo.extras;
            if (bundle == null || (charSequence = bundle.getCharSequence(CONTENT_SURROUNDING_TEXT_KEY)) == null) {
                return null;
            }
            int i3 = editorInfo.extras.getInt(CONTENT_SELECTION_END_KEY);
            int min = Math.min(i, charSequence.length() - i3);
            if ((i2 & 1) != 0) {
                return charSequence.subSequence(i3, min + i3);
            }
            return TextUtils.substring(charSequence, i3, min + i3);
        }
        return (CharSequence) invokeLII.objValue;
    }

    @Nullable
    public static CharSequence getInitialTextBeforeCursor(@NonNull EditorInfo editorInfo, int i, int i2) {
        InterceptResult invokeLII;
        CharSequence charSequence;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65541, null, editorInfo, i, i2)) == null) {
            if (Build.VERSION.SDK_INT >= 30) {
                return Impl30.getInitialTextBeforeCursor(editorInfo, i, i2);
            }
            Bundle bundle = editorInfo.extras;
            if (bundle == null || (charSequence = bundle.getCharSequence(CONTENT_SURROUNDING_TEXT_KEY)) == null) {
                return null;
            }
            int i3 = editorInfo.extras.getInt(CONTENT_SELECTION_HEAD_KEY);
            int min = Math.min(i, i3);
            if ((i2 & 1) != 0) {
                return charSequence.subSequence(i3 - min, i3);
            }
            return TextUtils.substring(charSequence, i3 - min, i3);
        }
        return (CharSequence) invokeLII.objValue;
    }

    public static void setInitialSurroundingSubText(@NonNull EditorInfo editorInfo, @NonNull CharSequence charSequence, int i) {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65546, null, editorInfo, charSequence, i) == null) {
            Preconditions.checkNotNull(charSequence);
            if (Build.VERSION.SDK_INT >= 30) {
                Impl30.setInitialSurroundingSubText(editorInfo, charSequence, i);
                return;
            }
            int i4 = editorInfo.initialSelStart;
            int i5 = editorInfo.initialSelEnd;
            if (i4 > i5) {
                i2 = i5 - i;
            } else {
                i2 = i4 - i;
            }
            int i6 = editorInfo.initialSelStart;
            int i7 = editorInfo.initialSelEnd;
            if (i6 > i7) {
                i3 = i6 - i;
            } else {
                i3 = i7 - i;
            }
            int length = charSequence.length();
            if (i >= 0 && i2 >= 0 && i3 <= length) {
                if (isPasswordInputType(editorInfo.inputType)) {
                    setSurroundingText(editorInfo, null, 0, 0);
                    return;
                } else if (length <= 2048) {
                    setSurroundingText(editorInfo, charSequence, i2, i3);
                    return;
                } else {
                    trimLongSurroundingText(editorInfo, charSequence, i2, i3);
                    return;
                }
            }
            setSurroundingText(editorInfo, null, 0, 0);
        }
    }

    public static boolean isCutOnSurrogate(CharSequence charSequence, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65543, null, charSequence, i, i2)) == null) {
            if (i2 != 0) {
                if (i2 != 1) {
                    return false;
                }
                return Character.isHighSurrogate(charSequence.charAt(i));
            }
            return Character.isLowSurrogate(charSequence.charAt(i));
        }
        return invokeLII.booleanValue;
    }

    public static void setContentMimeTypes(@NonNull EditorInfo editorInfo, @Nullable String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, editorInfo, strArr) == null) {
            if (Build.VERSION.SDK_INT >= 25) {
                editorInfo.contentMimeTypes = strArr;
                return;
            }
            if (editorInfo.extras == null) {
                editorInfo.extras = new Bundle();
            }
            editorInfo.extras.putStringArray(CONTENT_MIME_TYPES_KEY, strArr);
            editorInfo.extras.putStringArray(CONTENT_MIME_TYPES_INTEROP_KEY, strArr);
        }
    }

    public static void setInitialSurroundingText(@NonNull EditorInfo editorInfo, @NonNull CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65547, null, editorInfo, charSequence) == null) {
            if (Build.VERSION.SDK_INT >= 30) {
                Impl30.setInitialSurroundingSubText(editorInfo, charSequence, 0);
            } else {
                setInitialSurroundingSubText(editorInfo, charSequence, 0);
            }
        }
    }

    public static void setSurroundingText(EditorInfo editorInfo, CharSequence charSequence, int i, int i2) {
        SpannableStringBuilder spannableStringBuilder;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(65548, null, editorInfo, charSequence, i, i2) == null) {
            if (editorInfo.extras == null) {
                editorInfo.extras = new Bundle();
            }
            if (charSequence != null) {
                spannableStringBuilder = new SpannableStringBuilder(charSequence);
            } else {
                spannableStringBuilder = null;
            }
            editorInfo.extras.putCharSequence(CONTENT_SURROUNDING_TEXT_KEY, spannableStringBuilder);
            editorInfo.extras.putInt(CONTENT_SELECTION_HEAD_KEY, i);
            editorInfo.extras.putInt(CONTENT_SELECTION_END_KEY, i2);
        }
    }

    public static void trimLongSurroundingText(EditorInfo editorInfo, CharSequence charSequence, int i, int i2) {
        int i3;
        CharSequence subSequence;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(65549, null, editorInfo, charSequence, i, i2) == null) {
            int i4 = i2 - i;
            if (i4 > 1024) {
                i3 = 0;
            } else {
                i3 = i4;
            }
            int i5 = 2048 - i3;
            int min = Math.min(charSequence.length() - i2, i5 - Math.min(i, (int) (i5 * 0.8d)));
            int min2 = Math.min(i, i5 - min);
            int i6 = i - min2;
            if (isCutOnSurrogate(charSequence, i6, 0)) {
                i6++;
                min2--;
            }
            if (isCutOnSurrogate(charSequence, (i2 + min) - 1, 1)) {
                min--;
            }
            int i7 = min2 + i3 + min;
            if (i3 != i4) {
                subSequence = TextUtils.concat(charSequence.subSequence(i6, i6 + min2), charSequence.subSequence(i2, min + i2));
            } else {
                subSequence = charSequence.subSequence(i6, i7 + i6);
            }
            int i8 = min2 + 0;
            setSurroundingText(editorInfo, subSequence, i8, i3 + i8);
        }
    }
}
