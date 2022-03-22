package com.baidu.tbadk.core.util.tbselector;

import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.tbselector.selector.ColorSelector;
import com.baidu.tbadk.core.util.tbselector.selector.DrawableSelector;
import com.baidu.tbadk.core.util.tbselector.shadow.ShadowDrawable;
import com.baidu.tbadk.core.util.tbselector.utils.SelectorHelper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class TBSelector {
    public static /* synthetic */ Interceptable $ic;
    public static final float RESOURCE_ALPHA_DISABLE;
    public static final float RESOURCE_ALPHA_PRESS;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(171588972, "Lcom/baidu/tbadk/core/util/tbselector/TBSelector;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(171588972, "Lcom/baidu/tbadk/core/util/tbselector/TBSelector;");
                return;
            }
        }
        RESOURCE_ALPHA_PRESS = SkinManager.RESOURCE_ALPHA_PRESS;
        RESOURCE_ALPHA_DISABLE = SkinManager.RESOURCE_ALPHA_DISABLE;
    }

    public TBSelector() {
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

    public static ColorSelector makeColorSelector() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? ColorSelector.make().textType(1) : (ColorSelector) invokeV.objValue;
    }

    public static DrawableSelector makeDrawableSelector() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? DrawableSelector.make() : (DrawableSelector) invokeV.objValue;
    }

    public static ShadowDrawable makeShadowDrawable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? ShadowDrawable.make() : (ShadowDrawable) invokeV.objValue;
    }

    public static ColorSelector makeTextColorSelector() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? ColorSelector.make().textType(1) : (ColorSelector) invokeV.objValue;
    }

    public static ColorSelector makeTextHintColorSelector() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) ? ColorSelector.make().textType(2) : (ColorSelector) invokeV.objValue;
    }

    public static DrawableSelector selectorBackgroundColor(@ColorRes int i, @ColorRes int i2, int i3) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIII = interceptable.invokeIII(65543, null, i, i2, i3)) == null) ? DrawableSelector.make().setType(1).defaultColor(i).pressedColor(i2).radius(i3) : (DrawableSelector) invokeIII.objValue;
    }

    public static DrawableSelector selectorBackgroundDrawable(Drawable drawable, Drawable drawable2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, drawable, drawable2)) == null) ? DrawableSelector.make().setType(1).defaultDrawable(drawable).pressedDrawable(drawable2) : (DrawableSelector) invokeLL.objValue;
    }

    public static DrawableSelector selectorImageDrawable(@DrawableRes int i, @DrawableRes int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(65547, null, i, i2)) == null) ? DrawableSelector.make().setType(2).defaultDrawable(i).pressedDrawable(i2) : (DrawableSelector) invokeII.objValue;
    }

    public static ColorSelector selectorTextColor(@ColorRes int i, @ColorRes int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(65548, null, i, i2)) == null) ? ColorSelector.make().textType(1).pressedColor(i2).defaultColor(i) : (ColorSelector) invokeII.objValue;
    }

    public static ColorSelector selectorTextHintColor(@ColorRes int i, @ColorRes int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(65550, null, i, i2)) == null) ? ColorSelector.make().textType(2).pressedColor(i2).defaultColor(i) : (ColorSelector) invokeII.objValue;
    }

    public static void setViewBackgroundColorWithDisabledState(View view, @ColorRes int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65552, null, view, i) == null) || view == null) {
            return;
        }
        Drawable colorDrawable = SelectorHelper.getColorDrawable(i);
        DrawableSelector.make().setType(1).defaultDrawable(colorDrawable).disabledDrawable(SelectorHelper.getColorDrawable(i, RESOURCE_ALPHA_DISABLE)).into(view);
    }

    public static void setViewBackgroundColorWithPressedState(View view, int i, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(65554, null, view, i, i2) == null) || view == null) {
            return;
        }
        DrawableSelector.make().setType(1).defaultColor(i).pressedColor(i2).into(view);
    }

    public static DrawableSelector selectorBackgroundDrawable(@DrawableRes int i, @DrawableRes int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(65545, null, i, i2)) == null) ? DrawableSelector.make().setType(1).defaultDrawable(i).pressedDrawable(i2) : (DrawableSelector) invokeII.objValue;
    }

    public static ColorSelector selectorTextColor(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65549, null, str, str2)) == null) ? ColorSelector.make().textType(1).pressedColor(str2).defaultColor(str) : (ColorSelector) invokeLL.objValue;
    }

    public static ColorSelector selectorTextHintColor(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65551, null, str, str2)) == null) ? ColorSelector.make().textType(2).pressedColor(str2).defaultColor(str) : (ColorSelector) invokeLL.objValue;
    }

    public static DrawableSelector selectorBackgroundColor(String str, String str2, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLI = interceptable.invokeLLI(65544, null, str, str2, i)) == null) ? DrawableSelector.make().setType(1).defaultColor(str).pressedColor(str2).radius(i) : (DrawableSelector) invokeLLI.objValue;
    }

    public static void setViewBackgroundColorWithPressedState(View view, @ColorRes int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65553, null, view, i) == null) || view == null) {
            return;
        }
        Drawable colorDrawable = SelectorHelper.getColorDrawable(i);
        DrawableSelector.make().setType(1).defaultDrawable(colorDrawable).pressedDrawable(SelectorHelper.getColorDrawable(i, RESOURCE_ALPHA_PRESS)).into(view);
    }
}
