package androidx.core.content.res;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.annotation.AnyRes;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleableRes;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.xmlpull.v1.XmlPullParser;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class TypedArrayUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String NAMESPACE = "http://schemas.android.com/apk/res/android";
    public transient /* synthetic */ FieldHolder $fh;

    public TypedArrayUtils() {
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

    public static int getAttr(@NonNull Context context, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65537, null, context, i, i2)) == null) {
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(i, typedValue, true);
            return typedValue.resourceId != 0 ? i : i2;
        }
        return invokeLII.intValue;
    }

    public static boolean getBoolean(@NonNull TypedArray typedArray, @StyleableRes int i, @StyleableRes int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{typedArray, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z)})) == null) ? typedArray.getBoolean(i, typedArray.getBoolean(i2, z)) : invokeCommon.booleanValue;
    }

    @Nullable
    public static Drawable getDrawable(@NonNull TypedArray typedArray, @StyleableRes int i, @StyleableRes int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65539, null, typedArray, i, i2)) == null) {
            Drawable drawable = typedArray.getDrawable(i);
            return drawable == null ? typedArray.getDrawable(i2) : drawable;
        }
        return (Drawable) invokeLII.objValue;
    }

    public static int getInt(@NonNull TypedArray typedArray, @StyleableRes int i, @StyleableRes int i2, int i3) {
        InterceptResult invokeLIII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLIII = interceptable.invokeLIII(InputDeviceCompat.SOURCE_TRACKBALL, null, typedArray, i, i2, i3)) == null) ? typedArray.getInt(i, typedArray.getInt(i2, i3)) : invokeLIII.intValue;
    }

    public static boolean getNamedBoolean(@NonNull TypedArray typedArray, @NonNull XmlPullParser xmlPullParser, @NonNull String str, @StyleableRes int i, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, null, new Object[]{typedArray, xmlPullParser, str, Integer.valueOf(i), Boolean.valueOf(z)})) == null) ? !hasAttribute(xmlPullParser, str) ? z : typedArray.getBoolean(i, z) : invokeCommon.booleanValue;
    }

    @ColorInt
    public static int getNamedColor(@NonNull TypedArray typedArray, @NonNull XmlPullParser xmlPullParser, @NonNull String str, @StyleableRes int i, @ColorInt int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, null, new Object[]{typedArray, xmlPullParser, str, Integer.valueOf(i), Integer.valueOf(i2)})) == null) ? !hasAttribute(xmlPullParser, str) ? i2 : typedArray.getColor(i, i2) : invokeCommon.intValue;
    }

    @Nullable
    public static ColorStateList getNamedColorStateList(@NonNull TypedArray typedArray, @NonNull XmlPullParser xmlPullParser, @Nullable Resources.Theme theme, @NonNull String str, @StyleableRes int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{typedArray, xmlPullParser, theme, str, Integer.valueOf(i)})) == null) {
            if (hasAttribute(xmlPullParser, str)) {
                TypedValue typedValue = new TypedValue();
                typedArray.getValue(i, typedValue);
                int i2 = typedValue.type;
                if (i2 != 2) {
                    if (i2 >= 28 && i2 <= 31) {
                        return getNamedColorStateListFromInt(typedValue);
                    }
                    return ColorStateListInflaterCompat.inflate(typedArray.getResources(), typedArray.getResourceId(i, 0), theme);
                }
                throw new UnsupportedOperationException("Failed to resolve attribute at index " + i + ": " + typedValue);
            }
            return null;
        }
        return (ColorStateList) invokeCommon.objValue;
    }

    @NonNull
    public static ColorStateList getNamedColorStateListFromInt(@NonNull TypedValue typedValue) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, typedValue)) == null) ? ColorStateList.valueOf(typedValue.data) : (ColorStateList) invokeL.objValue;
    }

    public static ComplexColorCompat getNamedComplexColor(@NonNull TypedArray typedArray, @NonNull XmlPullParser xmlPullParser, @Nullable Resources.Theme theme, @NonNull String str, @StyleableRes int i, @ColorInt int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65545, null, new Object[]{typedArray, xmlPullParser, theme, str, Integer.valueOf(i), Integer.valueOf(i2)})) == null) {
            if (hasAttribute(xmlPullParser, str)) {
                TypedValue typedValue = new TypedValue();
                typedArray.getValue(i, typedValue);
                int i3 = typedValue.type;
                if (i3 >= 28 && i3 <= 31) {
                    return ComplexColorCompat.from(typedValue.data);
                }
                ComplexColorCompat inflate = ComplexColorCompat.inflate(typedArray.getResources(), typedArray.getResourceId(i, 0), theme);
                if (inflate != null) {
                    return inflate;
                }
            }
            return ComplexColorCompat.from(i2);
        }
        return (ComplexColorCompat) invokeCommon.objValue;
    }

    public static float getNamedFloat(@NonNull TypedArray typedArray, @NonNull XmlPullParser xmlPullParser, @NonNull String str, @StyleableRes int i, float f) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65546, null, new Object[]{typedArray, xmlPullParser, str, Integer.valueOf(i), Float.valueOf(f)})) == null) ? !hasAttribute(xmlPullParser, str) ? f : typedArray.getFloat(i, f) : invokeCommon.floatValue;
    }

    public static int getNamedInt(@NonNull TypedArray typedArray, @NonNull XmlPullParser xmlPullParser, @NonNull String str, @StyleableRes int i, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65547, null, new Object[]{typedArray, xmlPullParser, str, Integer.valueOf(i), Integer.valueOf(i2)})) == null) ? !hasAttribute(xmlPullParser, str) ? i2 : typedArray.getInt(i, i2) : invokeCommon.intValue;
    }

    @AnyRes
    public static int getNamedResourceId(@NonNull TypedArray typedArray, @NonNull XmlPullParser xmlPullParser, @NonNull String str, @StyleableRes int i, @AnyRes int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65548, null, new Object[]{typedArray, xmlPullParser, str, Integer.valueOf(i), Integer.valueOf(i2)})) == null) ? !hasAttribute(xmlPullParser, str) ? i2 : typedArray.getResourceId(i, i2) : invokeCommon.intValue;
    }

    @Nullable
    public static String getNamedString(@NonNull TypedArray typedArray, @NonNull XmlPullParser xmlPullParser, @NonNull String str, @StyleableRes int i) {
        InterceptResult invokeLLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(65549, null, typedArray, xmlPullParser, str, i)) == null) {
            if (hasAttribute(xmlPullParser, str)) {
                return typedArray.getString(i);
            }
            return null;
        }
        return (String) invokeLLLI.objValue;
    }

    @AnyRes
    public static int getResourceId(@NonNull TypedArray typedArray, @StyleableRes int i, @StyleableRes int i2, @AnyRes int i3) {
        InterceptResult invokeLIII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLIII = interceptable.invokeLIII(65550, null, typedArray, i, i2, i3)) == null) ? typedArray.getResourceId(i, typedArray.getResourceId(i2, i3)) : invokeLIII.intValue;
    }

    @Nullable
    public static String getString(@NonNull TypedArray typedArray, @StyleableRes int i, @StyleableRes int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65551, null, typedArray, i, i2)) == null) {
            String string = typedArray.getString(i);
            return string == null ? typedArray.getString(i2) : string;
        }
        return (String) invokeLII.objValue;
    }

    @Nullable
    public static CharSequence getText(@NonNull TypedArray typedArray, @StyleableRes int i, @StyleableRes int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65552, null, typedArray, i, i2)) == null) {
            CharSequence text = typedArray.getText(i);
            return text == null ? typedArray.getText(i2) : text;
        }
        return (CharSequence) invokeLII.objValue;
    }

    @Nullable
    public static CharSequence[] getTextArray(@NonNull TypedArray typedArray, @StyleableRes int i, @StyleableRes int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65553, null, typedArray, i, i2)) == null) {
            CharSequence[] textArray = typedArray.getTextArray(i);
            return textArray == null ? typedArray.getTextArray(i2) : textArray;
        }
        return (CharSequence[]) invokeLII.objValue;
    }

    public static boolean hasAttribute(@NonNull XmlPullParser xmlPullParser, @NonNull String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65554, null, xmlPullParser, str)) == null) ? xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", str) != null : invokeLL.booleanValue;
    }

    @NonNull
    public static TypedArray obtainAttributes(@NonNull Resources resources, @Nullable Resources.Theme theme, @NonNull AttributeSet attributeSet, @NonNull int[] iArr) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65555, null, resources, theme, attributeSet, iArr)) == null) {
            if (theme == null) {
                return resources.obtainAttributes(attributeSet, iArr);
            }
            return theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
        }
        return (TypedArray) invokeLLLL.objValue;
    }

    @Nullable
    public static TypedValue peekNamedValue(@NonNull TypedArray typedArray, @NonNull XmlPullParser xmlPullParser, @NonNull String str, int i) {
        InterceptResult invokeLLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(65556, null, typedArray, xmlPullParser, str, i)) == null) {
            if (hasAttribute(xmlPullParser, str)) {
                return typedArray.peekValue(i);
            }
            return null;
        }
        return (TypedValue) invokeLLLI.objValue;
    }
}
