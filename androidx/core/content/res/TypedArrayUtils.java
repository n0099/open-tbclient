package androidx.core.content.res;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.xmlpull.v1.XmlPullParser;
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

    public static int getAttr(Context context, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65537, null, context, i, i2)) == null) {
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(i, typedValue, true);
            if (typedValue.resourceId != 0) {
                return i;
            }
            return i2;
        }
        return invokeLII.intValue;
    }

    public static Drawable getDrawable(TypedArray typedArray, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65539, null, typedArray, i, i2)) == null) {
            Drawable drawable = typedArray.getDrawable(i);
            if (drawable == null) {
                return typedArray.getDrawable(i2);
            }
            return drawable;
        }
        return (Drawable) invokeLII.objValue;
    }

    public static String getString(TypedArray typedArray, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65551, null, typedArray, i, i2)) == null) {
            String string = typedArray.getString(i);
            if (string == null) {
                return typedArray.getString(i2);
            }
            return string;
        }
        return (String) invokeLII.objValue;
    }

    public static CharSequence getText(TypedArray typedArray, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65552, null, typedArray, i, i2)) == null) {
            CharSequence text = typedArray.getText(i);
            if (text == null) {
                return typedArray.getText(i2);
            }
            return text;
        }
        return (CharSequence) invokeLII.objValue;
    }

    public static CharSequence[] getTextArray(TypedArray typedArray, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65553, null, typedArray, i, i2)) == null) {
            CharSequence[] textArray = typedArray.getTextArray(i);
            if (textArray == null) {
                return typedArray.getTextArray(i2);
            }
            return textArray;
        }
        return (CharSequence[]) invokeLII.objValue;
    }

    public static boolean getBoolean(TypedArray typedArray, int i, int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{typedArray, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            return typedArray.getBoolean(i, typedArray.getBoolean(i2, z));
        }
        return invokeCommon.booleanValue;
    }

    public static int getInt(TypedArray typedArray, int i, int i2, int i3) {
        InterceptResult invokeLIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIII = interceptable.invokeLIII(InputDeviceCompat.SOURCE_TRACKBALL, null, typedArray, i, i2, i3)) == null) {
            return typedArray.getInt(i, typedArray.getInt(i2, i3));
        }
        return invokeLIII.intValue;
    }

    public static String getNamedString(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i) {
        InterceptResult invokeLLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(65549, null, typedArray, xmlPullParser, str, i)) == null) {
            if (!hasAttribute(xmlPullParser, str)) {
                return null;
            }
            return typedArray.getString(i);
        }
        return (String) invokeLLLI.objValue;
    }

    public static int getResourceId(TypedArray typedArray, int i, int i2, int i3) {
        InterceptResult invokeLIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIII = interceptable.invokeLIII(65550, null, typedArray, i, i2, i3)) == null) {
            return typedArray.getResourceId(i, typedArray.getResourceId(i2, i3));
        }
        return invokeLIII.intValue;
    }

    public static TypedArray obtainAttributes(Resources resources, Resources.Theme theme, AttributeSet attributeSet, int[] iArr) {
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

    public static TypedValue peekNamedValue(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i) {
        InterceptResult invokeLLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(65556, null, typedArray, xmlPullParser, str, i)) == null) {
            if (!hasAttribute(xmlPullParser, str)) {
                return null;
            }
            return typedArray.peekValue(i);
        }
        return (TypedValue) invokeLLLI.objValue;
    }

    public static boolean getNamedBoolean(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, null, new Object[]{typedArray, xmlPullParser, str, Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
            if (!hasAttribute(xmlPullParser, str)) {
                return z;
            }
            return typedArray.getBoolean(i, z);
        }
        return invokeCommon.booleanValue;
    }

    public static int getNamedColor(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, null, new Object[]{typedArray, xmlPullParser, str, Integer.valueOf(i), Integer.valueOf(i2)})) == null) {
            if (!hasAttribute(xmlPullParser, str)) {
                return i2;
            }
            return typedArray.getColor(i, i2);
        }
        return invokeCommon.intValue;
    }

    public static float getNamedFloat(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i, float f) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65546, null, new Object[]{typedArray, xmlPullParser, str, Integer.valueOf(i), Float.valueOf(f)})) == null) {
            if (!hasAttribute(xmlPullParser, str)) {
                return f;
            }
            return typedArray.getFloat(i, f);
        }
        return invokeCommon.floatValue;
    }

    public static int getNamedInt(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65547, null, new Object[]{typedArray, xmlPullParser, str, Integer.valueOf(i), Integer.valueOf(i2)})) == null) {
            if (!hasAttribute(xmlPullParser, str)) {
                return i2;
            }
            return typedArray.getInt(i, i2);
        }
        return invokeCommon.intValue;
    }

    public static int getNamedResourceId(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65548, null, new Object[]{typedArray, xmlPullParser, str, Integer.valueOf(i), Integer.valueOf(i2)})) == null) {
            if (!hasAttribute(xmlPullParser, str)) {
                return i2;
            }
            return typedArray.getResourceId(i, i2);
        }
        return invokeCommon.intValue;
    }

    public static ColorStateList getNamedColorStateList(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme, String str, int i) {
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

    public static ColorStateList getNamedColorStateListFromInt(TypedValue typedValue) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, typedValue)) == null) {
            return ColorStateList.valueOf(typedValue.data);
        }
        return (ColorStateList) invokeL.objValue;
    }

    public static ComplexColorCompat getNamedComplexColor(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme, String str, int i, int i2) {
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

    public static boolean hasAttribute(XmlPullParser xmlPullParser, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65554, null, xmlPullParser, str)) == null) {
            if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", str) != null) {
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
