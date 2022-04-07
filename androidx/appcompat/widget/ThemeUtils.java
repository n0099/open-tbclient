package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R$styleable;
import androidx.core.graphics.ColorUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public class ThemeUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int[] ACTIVATED_STATE_SET;
    public static final int[] CHECKED_STATE_SET;
    public static final int[] DISABLED_STATE_SET;
    public static final int[] EMPTY_STATE_SET;
    public static final int[] FOCUSED_STATE_SET;
    public static final int[] NOT_PRESSED_OR_FOCUSED_STATE_SET;
    public static final int[] PRESSED_STATE_SET;
    public static final int[] SELECTED_STATE_SET;
    public static final String TAG = "ThemeUtils";
    public static final int[] TEMP_ARRAY;
    public static final ThreadLocal<TypedValue> TL_TYPED_VALUE;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1035201966, "Landroidx/appcompat/widget/ThemeUtils;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1035201966, "Landroidx/appcompat/widget/ThemeUtils;");
                return;
            }
        }
        TL_TYPED_VALUE = new ThreadLocal<>();
        DISABLED_STATE_SET = new int[]{-16842910};
        FOCUSED_STATE_SET = new int[]{16842908};
        ACTIVATED_STATE_SET = new int[]{16843518};
        PRESSED_STATE_SET = new int[]{16842919};
        CHECKED_STATE_SET = new int[]{16842912};
        SELECTED_STATE_SET = new int[]{16842913};
        NOT_PRESSED_OR_FOCUSED_STATE_SET = new int[]{-16842919, -16842908};
        EMPTY_STATE_SET = new int[0];
        TEMP_ARRAY = new int[1];
    }

    public ThemeUtils() {
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

    public static void checkAppCompatTheme(@NonNull View view2, @NonNull Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, view2, context) == null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(R$styleable.AppCompatTheme);
            try {
                if (!obtainStyledAttributes.hasValue(R$styleable.AppCompatTheme_windowActionBar)) {
                    Log.e(TAG, "View " + view2.getClass() + " is an AppCompat widget that can only be used with a Theme.AppCompat theme (or descendant).");
                }
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
    }

    @NonNull
    public static ColorStateList createDisabledStateList(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(65539, null, i, i2)) == null) ? new ColorStateList(new int[][]{DISABLED_STATE_SET, EMPTY_STATE_SET}, new int[]{i2, i}) : (ColorStateList) invokeII.objValue;
    }

    public static int getDisabledThemeAttrColor(@NonNull Context context, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, context, i)) == null) {
            ColorStateList themeAttrColorStateList = getThemeAttrColorStateList(context, i);
            if (themeAttrColorStateList != null && themeAttrColorStateList.isStateful()) {
                return themeAttrColorStateList.getColorForState(DISABLED_STATE_SET, themeAttrColorStateList.getDefaultColor());
            }
            TypedValue typedValue = getTypedValue();
            context.getTheme().resolveAttribute(16842803, typedValue, true);
            return getThemeAttrColor(context, i, typedValue.getFloat());
        }
        return invokeLI.intValue;
    }

    public static int getThemeAttrColor(@NonNull Context context, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65541, null, context, i)) == null) {
            int[] iArr = TEMP_ARRAY;
            iArr[0] = i;
            TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, (AttributeSet) null, iArr);
            try {
                return obtainStyledAttributes.getColor(0, 0);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
        return invokeLI.intValue;
    }

    @Nullable
    public static ColorStateList getThemeAttrColorStateList(@NonNull Context context, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65543, null, context, i)) == null) {
            int[] iArr = TEMP_ARRAY;
            iArr[0] = i;
            TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, (AttributeSet) null, iArr);
            try {
                return obtainStyledAttributes.getColorStateList(0);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
        return (ColorStateList) invokeLI.objValue;
    }

    public static TypedValue getTypedValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            TypedValue typedValue = TL_TYPED_VALUE.get();
            if (typedValue == null) {
                TypedValue typedValue2 = new TypedValue();
                TL_TYPED_VALUE.set(typedValue2);
                return typedValue2;
            }
            return typedValue;
        }
        return (TypedValue) invokeV.objValue;
    }

    public static int getThemeAttrColor(@NonNull Context context, int i, float f) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, null, new Object[]{context, Integer.valueOf(i), Float.valueOf(f)})) == null) {
            int themeAttrColor = getThemeAttrColor(context, i);
            return ColorUtils.setAlphaComponent(themeAttrColor, Math.round(Color.alpha(themeAttrColor) * f));
        }
        return invokeCommon.intValue;
    }
}
