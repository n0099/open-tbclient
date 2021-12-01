package com.baidu.tbadk.core.util.tbselector.selector;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.widget.TextView;
import androidx.annotation.ColorRes;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.tbselector.interfaces.ISelector;
import com.baidu.tbadk.core.util.tbselector.utils.SelectorHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class ColorSelector implements ISelector<ColorStateList, TextView> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int HINT_TEXT_COLOR = 2;
    public static final int TEXT_COLOR = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public int disabledColor;
    public int focusedColor;
    public boolean hasSetDisabledColor;
    public boolean hasSetFocusedColor;
    public boolean hasSetPressedColor;
    public boolean hasSetSelectedColor;
    public ColorStateList mColorStateList;
    public int normalColor;
    public int pressedColor;
    public int selectedColor;
    public int textType;

    public ColorSelector() {
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
        this.textType = 1;
        this.hasSetDisabledColor = false;
        this.hasSetPressedColor = false;
        this.hasSetSelectedColor = false;
        this.hasSetFocusedColor = false;
    }

    private ColorStateList create() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            int[] iArr = new int[5];
            iArr[0] = this.hasSetDisabledColor ? this.disabledColor : this.normalColor;
            iArr[1] = this.hasSetPressedColor ? this.pressedColor : this.normalColor;
            iArr[2] = this.hasSetSelectedColor ? this.selectedColor : this.normalColor;
            iArr[3] = this.hasSetFocusedColor ? this.focusedColor : this.normalColor;
            iArr[4] = this.normalColor;
            return getColorStateList(iArr);
        }
        return (ColorStateList) invokeV.objValue;
    }

    private ColorStateList getColorStateList(int[] iArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, this, iArr)) == null) ? new ColorStateList(new int[][]{new int[]{-16842910}, new int[]{16842919}, new int[]{16842913}, new int[]{16842908}, new int[0]}, iArr) : (ColorStateList) invokeL.objValue;
    }

    public static ColorSelector make() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? new ColorSelector() : (ColorSelector) invokeV.objValue;
    }

    public ColorSelector defaultColor(@ColorRes int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            int color = SelectorHelper.getColor(i2);
            this.normalColor = color;
            if (!this.hasSetDisabledColor) {
                this.disabledColor = color;
            }
            if (!this.hasSetPressedColor) {
                this.pressedColor = color;
            }
            if (!this.hasSetSelectedColor) {
                this.selectedColor = color;
            }
            if (!this.hasSetFocusedColor) {
                this.focusedColor = color;
            }
            return this;
        }
        return (ColorSelector) invokeI.objValue;
    }

    public ColorSelector disabledColor(@ColorRes int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            this.disabledColor = SelectorHelper.getColor(i2);
            this.hasSetDisabledColor = true;
            return this;
        }
        return (ColorSelector) invokeI.objValue;
    }

    public ColorSelector focusedColor(@ColorRes int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            this.focusedColor = SelectorHelper.getColor(i2);
            this.hasSetFocusedColor = true;
            return this;
        }
        return (ColorSelector) invokeI.objValue;
    }

    public ColorSelector pressedColor(@ColorRes int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i2)) == null) {
            this.pressedColor = SelectorHelper.getColor(i2);
            this.hasSetPressedColor = true;
            return this;
        }
        return (ColorSelector) invokeI.objValue;
    }

    public ColorSelector selectedColor(@ColorRes int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i2)) == null) {
            this.selectedColor = SelectorHelper.getColor(i2);
            this.hasSetSelectedColor = true;
            return this;
        }
        return (ColorSelector) invokeI.objValue;
    }

    public ColorSelector selectorColor(@ColorRes int i2, @ColorRes int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048590, this, i2, i3)) == null) {
            this.pressedColor = i2;
            this.normalColor = i3;
            this.hasSetPressedColor = true;
            return this;
        }
        return (ColorSelector) invokeII.objValue;
    }

    public ColorSelector textType(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i2)) == null) {
            this.textType = i2;
            return this;
        }
        return (ColorSelector) invokeI.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.core.util.tbselector.interfaces.ISelector
    public ColorStateList build() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ColorStateList create = create();
            this.mColorStateList = create;
            return create;
        }
        return (ColorStateList) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.util.tbselector.interfaces.ISelector
    public void into(TextView textView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, textView) == null) || textView == null) {
            return;
        }
        build();
        if (2 == this.textType) {
            textView.setHintTextColor(this.mColorStateList);
        } else {
            textView.setTextColor(this.mColorStateList);
        }
    }

    public ColorSelector disabledColor(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            this.disabledColor = SelectorHelper.parseColor(str);
            this.hasSetDisabledColor = true;
            return this;
        }
        return (ColorSelector) invokeL.objValue;
    }

    public ColorSelector focusedColor(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            this.focusedColor = SelectorHelper.parseColor(str);
            this.hasSetFocusedColor = true;
            return this;
        }
        return (ColorSelector) invokeL.objValue;
    }

    public ColorSelector pressedColor(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
            this.pressedColor = SelectorHelper.parseColor(str);
            this.hasSetPressedColor = true;
            return this;
        }
        return (ColorSelector) invokeL.objValue;
    }

    public ColorSelector selectedColor(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
            this.selectedColor = SelectorHelper.parseColor(str);
            this.hasSetSelectedColor = true;
            return this;
        }
        return (ColorSelector) invokeL.objValue;
    }

    public ColorSelector defaultColor(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            int parseColor = Color.parseColor(str);
            this.normalColor = parseColor;
            if (!this.hasSetDisabledColor) {
                this.disabledColor = parseColor;
            }
            if (!this.hasSetPressedColor) {
                this.pressedColor = parseColor;
            }
            if (!this.hasSetSelectedColor) {
                this.selectedColor = parseColor;
            }
            if (!this.hasSetFocusedColor) {
                this.focusedColor = parseColor;
            }
            return this;
        }
        return (ColorSelector) invokeL.objValue;
    }
}
