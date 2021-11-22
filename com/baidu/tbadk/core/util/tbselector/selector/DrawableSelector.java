package com.baidu.tbadk.core.util.tbselector.selector;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.IntRange;
import androidx.core.view.InputDeviceCompat;
import b.a.r0.m3.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.tbselector.interfaces.ISelector;
import com.baidu.tbadk.core.util.tbselector.utils.SelectorHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes8.dex */
public class DrawableSelector extends AbsDrawableSelector implements ISelector<StateListDrawable, View> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String BL_TR = "BL_TR";
    public static final String BOTTOM_TOP = "BOTTOM_TOP";
    public static final String BR_TL = "BR_TL";
    public static final String LEFT_RIGHT = "LEFT_RIGHT";
    public static final String RIGHT_LEFT = "RIGHT_LEFT";
    public static final String TL_BR = "TL_BR";
    public static final String TOP_BOTTOM = "TOP_BOTTOM";
    public static final String TR_BL = "TR_BL";
    public transient /* synthetic */ FieldHolder $fh;
    public float bottomLeftRadius;
    public float bottomRightRadius;
    public float centerX;
    public float centerY;
    public float dashGap;
    public int dashLineColor;
    public int dashLineWidth;
    public float dashWidth;
    public int[] gradientColors;
    public String gradientOrientation;
    public int gradientType;
    public boolean hasSetDisabledBgColor;
    public boolean hasSetDisabledStrokeColor;
    public boolean hasSetFocusedBgColor;
    public boolean hasSetFocusedStrokeColor;
    public boolean hasSetPressedBgColor;
    public boolean hasSetPressedStrokeColor;
    public boolean hasSetSelectedBgColor;
    public boolean hasSetSelectedStrokeColor;
    public int height;
    public boolean isDashLine;
    public boolean isGradient;
    public boolean isRadius;
    public boolean isSolid;
    public boolean isStroke;
    public int mCornerRadius;
    public int mDefaultBgColor;
    public int mDefaultStrokeColor;
    public int mDisabledBgColor;
    public int mDisabledStrokeColor;
    public int mFocusedBgColor;
    public int mFocusedStrokeColor;
    public int mPressedBgColor;
    public int mPressedStrokeColor;
    public int mSelectedBgColor;
    public int mSelectedStrokeColor;
    public int mShape;
    public StateListDrawable mStateListDrawable;
    public int mStrokeWidth;
    public float radialRadius;
    public float topLeftRadius;
    public float topRightRadius;
    public int width;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes8.dex */
    public @interface GradientOrientation {
    }

    /* loaded from: classes8.dex */
    public @interface Shape {
    }

    public DrawableSelector() {
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
        this.dashLineWidth = 1;
        this.dashLineColor = 1;
        this.dashWidth = 1.0f;
        this.dashGap = 1.0f;
        this.gradientType = 0;
        this.gradientOrientation = TOP_BOTTOM;
        this.topRightRadius = 0.0f;
        this.topLeftRadius = 0.0f;
        this.bottomRightRadius = 0.0f;
        this.bottomLeftRadius = 0.0f;
        this.mShape = 0;
        this.mCornerRadius = 0;
        this.mStrokeWidth = 0;
        this.hasSetDisabledBgColor = false;
        this.hasSetPressedBgColor = false;
        this.hasSetSelectedBgColor = false;
        this.hasSetFocusedBgColor = false;
        this.hasSetDisabledStrokeColor = false;
        this.hasSetPressedStrokeColor = false;
        this.hasSetSelectedStrokeColor = false;
        this.hasSetFocusedStrokeColor = false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private GradientDrawable.Orientation createGradientOrientation() {
        InterceptResult invokeV;
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            GradientDrawable.Orientation orientation = GradientDrawable.Orientation.TOP_BOTTOM;
            String str = this.gradientOrientation;
            switch (str.hashCode()) {
                case -1196165855:
                    if (str.equals(BOTTOM_TOP)) {
                        c2 = 4;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -873241494:
                    if (str.equals(RIGHT_LEFT)) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -434150460:
                    if (str.equals(LEFT_RIGHT)) {
                        c2 = 6;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 63310483:
                    if (str.equals(BL_TR)) {
                        c2 = 5;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 63489223:
                    if (str.equals(BR_TL)) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 79933303:
                    if (str.equals(TL_BR)) {
                        c2 = 7;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 80112043:
                    if (str.equals(TR_BL)) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1982197877:
                    if (str.equals(TOP_BOTTOM)) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            switch (c2) {
                case 0:
                    return GradientDrawable.Orientation.TOP_BOTTOM;
                case 1:
                    return GradientDrawable.Orientation.TR_BL;
                case 2:
                    return GradientDrawable.Orientation.RIGHT_LEFT;
                case 3:
                    return GradientDrawable.Orientation.BR_TL;
                case 4:
                    return GradientDrawable.Orientation.BOTTOM_TOP;
                case 5:
                    return GradientDrawable.Orientation.BL_TR;
                case 6:
                    return GradientDrawable.Orientation.LEFT_RIGHT;
                case 7:
                    return GradientDrawable.Orientation.TL_BR;
                default:
                    return GradientDrawable.Orientation.TOP_BOTTOM;
            }
        }
        return (GradientDrawable.Orientation) invokeV.objValue;
    }

    public static DrawableSelector make() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? new DrawableSelector() : (DrawableSelector) invokeV.objValue;
    }

    private GradientDrawable makeItemShapeDrawable(int i2, int i3, int i4, int i5) {
        InterceptResult invokeIIII;
        GradientDrawable gradientDrawable;
        int i6;
        int[] iArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIII = interceptable.invokeIIII(65539, this, i2, i3, i4, i5)) == null) {
            if (this.isGradient && (iArr = this.gradientColors) != null && iArr.length > 1) {
                gradientDrawable = new GradientDrawable(createGradientOrientation(), this.gradientColors);
                gradientDrawable.setGradientType(this.gradientType);
                if (this.gradientType == 1) {
                    gradientDrawable.setGradientRadius(this.radialRadius);
                }
            } else {
                gradientDrawable = new GradientDrawable();
            }
            gradientDrawable.setShape(i2);
            if (this.isSolid) {
                gradientDrawable.setColor(i3);
            }
            if (this.isStroke) {
                gradientDrawable.setStroke(this.mStrokeWidth, i4);
            } else if (this.isDashLine) {
                gradientDrawable.setStroke(this.dashLineWidth, i5, this.dashWidth, this.dashGap);
            }
            int i7 = this.mCornerRadius;
            if (i7 > 0) {
                gradientDrawable.setCornerRadius(i7);
            } else if (this.isRadius) {
                float f2 = this.topLeftRadius;
                float f3 = this.topRightRadius;
                float f4 = this.bottomRightRadius;
                float f5 = this.bottomLeftRadius;
                gradientDrawable.setCornerRadii(new float[]{f2, f2, f3, f3, f4, f4, f5, f5});
            }
            int i8 = this.width;
            if (i8 > 0 && (i6 = this.height) > 0) {
                gradientDrawable.setSize(i8, i6);
            }
            if (this.centerX > 0.0f || this.centerY > 0.0f) {
                gradientDrawable.setGradientCenter(this.centerX, this.centerY);
            }
            updateDrawableAlpha(gradientDrawable);
            return gradientDrawable;
        }
        return (GradientDrawable) invokeIIII.objValue;
    }

    public DrawableSelector autoGradient(@ColorRes int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            this.isGradient = true;
            this.gradientColors = r1;
            int[] iArr = {0, SelectorHelper.getColor(i2)};
            int[] iArr2 = this.gradientColors;
            iArr2[0] = c.b(iArr2[1]);
            this.gradientType = 0;
            this.gradientOrientation = TOP_BOTTOM;
            return this;
        }
        return (DrawableSelector) invokeI.objValue;
    }

    public DrawableSelector blRadius(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f2)) == null) {
            this.isRadius = true;
            this.bottomLeftRadius = f2;
            return this;
        }
        return (DrawableSelector) invokeF.objValue;
    }

    public DrawableSelector brRadius(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(Constants.METHOD_SEND_USER_MSG, this, f2)) == null) {
            this.isRadius = true;
            this.bottomRightRadius = f2;
            return this;
        }
        return (DrawableSelector) invokeF.objValue;
    }

    public DrawableSelector cornerRadius(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            this.mCornerRadius = i2;
            return this;
        }
        return (DrawableSelector) invokeI.objValue;
    }

    public StateListDrawable create() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            StateListDrawable stateListDrawable = new StateListDrawable();
            Drawable onItemDisabledDrawable = onItemDisabledDrawable();
            if (onItemDisabledDrawable != null) {
                stateListDrawable.addState(new int[]{-16842910}, onItemDisabledDrawable);
            }
            Drawable onItemPressedDrawable = onItemPressedDrawable();
            if (onItemPressedDrawable != null) {
                stateListDrawable.addState(new int[]{16842919}, onItemPressedDrawable);
            }
            Drawable onItemSelectedDrawable = onItemSelectedDrawable();
            if (onItemSelectedDrawable != null) {
                stateListDrawable.addState(new int[]{16842913}, onItemSelectedDrawable);
            }
            Drawable onItemFocusedDrawable = onItemFocusedDrawable();
            if (onItemFocusedDrawable != null) {
                stateListDrawable.addState(new int[]{16842908}, onItemFocusedDrawable);
            }
            Drawable onItemDefaultDrawable = onItemDefaultDrawable();
            if (onItemDefaultDrawable == null) {
                onItemDefaultDrawable = new ColorDrawable(0);
            }
            if (onItemDefaultDrawable != null) {
                stateListDrawable.addState(new int[0], onItemDefaultDrawable);
            }
            return stateListDrawable;
        }
        return (StateListDrawable) invokeV.objValue;
    }

    public DrawableSelector dashLine(@ColorRes int i2, int i3, float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            this.isDashLine = true;
            this.dashLineWidth = i3;
            this.dashWidth = f2;
            this.dashGap = f3;
            this.dashLineColor = SelectorHelper.getColor(i2);
            return this;
        }
        return (DrawableSelector) invokeCommon.objValue;
    }

    public DrawableSelector defaultColor(@ColorRes int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) {
            int color = SelectorHelper.getColor(i2);
            this.mDefaultBgColor = color;
            this.isSolid = true;
            if (!this.hasSetDisabledBgColor) {
                this.mDisabledBgColor = color;
            }
            if (!this.hasSetPressedBgColor) {
                this.mPressedBgColor = color;
            }
            if (!this.hasSetSelectedBgColor) {
                this.mSelectedBgColor = color;
            }
            if (!this.hasSetFocusedBgColor) {
                this.mFocusedBgColor = color;
            }
            return this;
        }
        return (DrawableSelector) invokeI.objValue;
    }

    public DrawableSelector defaultColorNotAutoChangeSkinType(@ColorRes int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i2)) == null) {
            int color = TbadkCoreApplication.getInst().getApp().getResources().getColor(i2);
            this.mDefaultBgColor = color;
            this.isSolid = true;
            if (!this.hasSetDisabledBgColor) {
                this.mDisabledBgColor = color;
            }
            if (!this.hasSetPressedBgColor) {
                this.mPressedBgColor = color;
            }
            if (!this.hasSetSelectedBgColor) {
                this.mSelectedBgColor = color;
            }
            if (!this.hasSetFocusedBgColor) {
                this.mFocusedBgColor = color;
            }
            return this;
        }
        return (DrawableSelector) invokeI.objValue;
    }

    public DrawableSelector defaultColorValue(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i2)) == null) {
            this.mDefaultBgColor = i2;
            this.isSolid = true;
            if (!this.hasSetDisabledBgColor) {
                this.mDisabledBgColor = i2;
            }
            if (!this.hasSetPressedBgColor) {
                this.mPressedBgColor = i2;
            }
            if (!this.hasSetSelectedBgColor) {
                this.mSelectedBgColor = i2;
            }
            if (!this.hasSetFocusedBgColor) {
                this.mFocusedBgColor = i2;
            }
            return this;
        }
        return (DrawableSelector) invokeI.objValue;
    }

    public DrawableSelector defaultColorValueNotAutoChangeSkinType(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i2)) == null) {
            this.mDefaultBgColor = i2;
            this.isSolid = true;
            if (!this.hasSetDisabledBgColor) {
                this.mDisabledBgColor = i2;
            }
            if (!this.hasSetPressedBgColor) {
                this.mPressedBgColor = i2;
            }
            if (!this.hasSetSelectedBgColor) {
                this.mSelectedBgColor = i2;
            }
            if (!this.hasSetFocusedBgColor) {
                this.mFocusedBgColor = i2;
            }
            return this;
        }
        return (DrawableSelector) invokeI.objValue;
    }

    public DrawableSelector defaultDrawable(Drawable drawable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, drawable)) == null) {
            this.mNormalDrawable = drawable;
            if (!this.hasSetDisabledDrawable) {
                this.mDisabledDrawable = drawable;
            }
            if (!this.hasSetPressedDrawable) {
                this.mPressedDrawable = drawable;
            }
            if (!this.hasSetSelectedDrawable) {
                this.mSelectedDrawable = drawable;
            }
            if (!this.hasSetFocusedDrawable) {
                this.mFocusedDrawable = drawable;
            }
            return this;
        }
        return (DrawableSelector) invokeL.objValue;
    }

    public DrawableSelector defaultStrokeColor(@ColorRes int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048593, this, i2)) == null) {
            int color = SelectorHelper.getColor(i2);
            this.mDefaultStrokeColor = color;
            this.isStroke = true;
            if (!this.hasSetDisabledStrokeColor) {
                this.mDisabledStrokeColor = color;
            }
            if (!this.hasSetPressedStrokeColor) {
                this.mPressedStrokeColor = color;
            }
            if (!this.hasSetSelectedStrokeColor) {
                this.mSelectedStrokeColor = color;
            }
            if (!this.hasSetFocusedStrokeColor) {
                this.mFocusedStrokeColor = color;
            }
            return this;
        }
        return (DrawableSelector) invokeI.objValue;
    }

    public DrawableSelector disabledColor(@ColorRes int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048595, this, i2)) == null) {
            this.mDisabledBgColor = SelectorHelper.getColor(i2);
            this.hasSetDisabledBgColor = true;
            this.isSolid = true;
            return this;
        }
        return (DrawableSelector) invokeI.objValue;
    }

    public DrawableSelector disabledDrawable(Drawable drawable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, drawable)) == null) {
            this.mDisabledDrawable = drawable;
            this.hasSetDisabledDrawable = true;
            return this;
        }
        return (DrawableSelector) invokeL.objValue;
    }

    public DrawableSelector disabledStrokeColor(@ColorRes int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048600, this, i2)) == null) {
            this.mDisabledStrokeColor = SelectorHelper.getColor(i2);
            this.hasSetDisabledStrokeColor = true;
            this.isStroke = true;
            return this;
        }
        return (DrawableSelector) invokeI.objValue;
    }

    public DrawableSelector focusedColor(@ColorRes int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048602, this, i2)) == null) {
            this.mFocusedBgColor = SelectorHelper.getColor(i2);
            this.isSolid = true;
            this.hasSetPressedBgColor = true;
            return this;
        }
        return (DrawableSelector) invokeI.objValue;
    }

    public DrawableSelector focusedDrawable(Drawable drawable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, drawable)) == null) {
            this.mFocusedDrawable = drawable;
            this.hasSetFocusedDrawable = true;
            return this;
        }
        return (DrawableSelector) invokeL.objValue;
    }

    public DrawableSelector focusedStrokeColor(@ColorRes int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048606, this, i2)) == null) {
            this.mFocusedStrokeColor = SelectorHelper.getColor(i2);
            this.hasSetFocusedStrokeColor = true;
            this.isStroke = true;
            return this;
        }
        return (DrawableSelector) invokeI.objValue;
    }

    public DrawableSelector gradient(@ColorRes int i2, @ColorRes int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048608, this, i2, i3)) == null) {
            this.isGradient = true;
            this.gradientColors = r1;
            int[] iArr = {SelectorHelper.getColor(i2)};
            this.gradientColors[1] = SelectorHelper.getColor(i3);
            this.gradientType = 0;
            this.gradientOrientation = TOP_BOTTOM;
            return this;
        }
        return (DrawableSelector) invokeII.objValue;
    }

    public DrawableSelector gradientLinear(@ColorRes int... iArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048612, this, iArr)) == null) {
            this.isGradient = true;
            this.gradientType = 0;
            this.gradientOrientation = TOP_BOTTOM;
            if (iArr.length > 1) {
                this.gradientColors = new int[iArr.length];
                for (int i2 = 0; i2 < iArr.length; i2++) {
                    this.gradientColors[i2] = SelectorHelper.getColor(iArr[i2]);
                }
                return this;
            }
            throw new ExceptionInInitializerError("渐变颜色数组至少需要两个颜色");
        }
        return (DrawableSelector) invokeL.objValue;
    }

    public DrawableSelector gradientLinearNotAutoChangeSkinType(@ColorRes int... iArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048614, this, iArr)) == null) {
            this.isGradient = true;
            this.gradientType = 0;
            this.gradientOrientation = TOP_BOTTOM;
            if (iArr.length > 1) {
                this.gradientColors = new int[iArr.length];
                for (int i2 = 0; i2 < iArr.length; i2++) {
                    this.gradientColors[i2] = TbadkCoreApplication.getInst().getApp().getResources().getColor(iArr[i2]);
                }
                return this;
            }
            throw new ExceptionInInitializerError("渐变颜色数组至少需要两个颜色");
        }
        return (DrawableSelector) invokeL.objValue;
    }

    public DrawableSelector gradientRadial(float f2, int... iArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048615, this, new Object[]{Float.valueOf(f2), iArr})) == null) {
            this.isGradient = true;
            this.gradientType = 1;
            this.radialRadius = f2;
            if (iArr.length > 1) {
                this.gradientColors = new int[iArr.length];
                for (int i2 = 0; i2 < iArr.length; i2++) {
                    this.gradientColors[i2] = SelectorHelper.getColor(iArr[i2]);
                }
                return this;
            }
            throw new ExceptionInInitializerError("渐变颜色数组至少需要两个颜色");
        }
        return (DrawableSelector) invokeCommon.objValue;
    }

    public DrawableSelector gradientSweep(int... iArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048617, this, iArr)) == null) {
            this.isGradient = true;
            this.gradientType = 2;
            if (iArr.length > 1) {
                this.gradientColors = new int[iArr.length];
                for (int i2 = 0; i2 < iArr.length; i2++) {
                    this.gradientColors[i2] = SelectorHelper.getColor(iArr[i2]);
                }
                return this;
            }
            throw new ExceptionInInitializerError("渐变颜色数组至少需要两个颜色");
        }
        return (DrawableSelector) invokeL.objValue;
    }

    @Override // com.baidu.tbadk.core.util.tbselector.interfaces.ISelector
    public void into(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048619, this, view) == null) || view == null) {
            return;
        }
        build();
        int i2 = this.mType;
        if (i2 == 2) {
            if (view instanceof ImageView) {
                ((ImageView) view).setImageDrawable(this.mStateListDrawable);
            }
        } else if (i2 == 1) {
            view.setBackgroundDrawable(this.mStateListDrawable);
        }
    }

    @Override // com.baidu.tbadk.core.util.tbselector.selector.AbsDrawableSelector
    public Drawable onItemDefaultDrawable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            Drawable drawable = this.mNormalDrawable;
            return drawable == null ? makeItemShapeDrawable(this.mShape, this.mDefaultBgColor, this.mDefaultStrokeColor, this.dashLineColor) : drawable;
        }
        return (Drawable) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.util.tbselector.selector.AbsDrawableSelector
    public Drawable onItemDisabledDrawable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            Drawable drawable = this.mDisabledDrawable;
            boolean z = this.hasSetDisabledDrawable;
            return (this.hasSetDisabledBgColor || this.hasSetDisabledStrokeColor) ? makeItemShapeDrawable(this.mShape, this.mDisabledBgColor, this.mDisabledStrokeColor, this.dashLineColor) : drawable;
        }
        return (Drawable) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.util.tbselector.selector.AbsDrawableSelector
    public Drawable onItemFocusedDrawable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            Drawable drawable = this.mFocusedDrawable;
            return this.hasSetFocusedDrawable ? drawable : (this.hasSetFocusedBgColor || this.hasSetFocusedStrokeColor) ? makeItemShapeDrawable(this.mShape, this.mFocusedBgColor, this.mFocusedStrokeColor, this.dashLineColor) : drawable;
        }
        return (Drawable) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.util.tbselector.selector.AbsDrawableSelector
    public Drawable onItemPressedDrawable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            Drawable drawable = this.mPressedDrawable;
            return this.hasSetPressedDrawable ? drawable : (this.hasSetPressedBgColor || this.hasSetPressedStrokeColor) ? makeItemShapeDrawable(this.mShape, this.mPressedBgColor, this.mPressedStrokeColor, this.dashLineColor) : drawable;
        }
        return (Drawable) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.util.tbselector.selector.AbsDrawableSelector
    public Drawable onItemSelectedDrawable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            Drawable drawable = this.mSelectedDrawable;
            return this.hasSetSelectedDrawable ? drawable : (this.hasSetSelectedBgColor || this.hasSetSelectedStrokeColor) ? makeItemShapeDrawable(this.mShape, this.mSelectedBgColor, this.mSelectedStrokeColor, this.dashLineColor) : drawable;
        }
        return (Drawable) invokeV.objValue;
    }

    public DrawableSelector pressedColor(@ColorRes int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048625, this, i2)) == null) {
            this.mPressedBgColor = SelectorHelper.getColor(i2);
            this.hasSetPressedBgColor = true;
            this.isSolid = true;
            return this;
        }
        return (DrawableSelector) invokeI.objValue;
    }

    public DrawableSelector pressedDrawable(Drawable drawable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048629, this, drawable)) == null) {
            this.mPressedDrawable = drawable;
            this.hasSetPressedDrawable = true;
            return this;
        }
        return (DrawableSelector) invokeL.objValue;
    }

    public DrawableSelector pressedStrokeColor(@ColorRes int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048630, this, i2)) == null) {
            this.mPressedStrokeColor = SelectorHelper.getColor(i2);
            this.hasSetPressedStrokeColor = true;
            this.isStroke = true;
            return this;
        }
        return (DrawableSelector) invokeI.objValue;
    }

    public DrawableSelector radius(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048632, this, f2)) == null) {
            this.isRadius = true;
            this.topRightRadius = f2;
            this.topLeftRadius = f2;
            this.bottomRightRadius = f2;
            this.bottomLeftRadius = f2;
            return this;
        }
        return (DrawableSelector) invokeF.objValue;
    }

    public DrawableSelector selectedColor(@ColorRes int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048633, this, i2)) == null) {
            this.mSelectedBgColor = SelectorHelper.getColor(i2);
            this.hasSetSelectedBgColor = true;
            this.isSolid = true;
            return this;
        }
        return (DrawableSelector) invokeI.objValue;
    }

    public DrawableSelector selectedDrawable(Drawable drawable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048636, this, drawable)) == null) {
            this.mSelectedDrawable = drawable;
            this.hasSetSelectedDrawable = true;
            return this;
        }
        return (DrawableSelector) invokeL.objValue;
    }

    public DrawableSelector selectedStrokeColor(@ColorRes int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048637, this, i2)) == null) {
            this.mSelectedStrokeColor = SelectorHelper.getColor(i2);
            this.hasSetSelectedStrokeColor = true;
            this.isStroke = true;
            return this;
        }
        return (DrawableSelector) invokeI.objValue;
    }

    public DrawableSelector setAlpha(@IntRange(from = 0, to = 255) int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048639, this, i2)) == null) {
            this.mAlpha = i2;
            this.hasSetAlpha = true;
            return this;
        }
        return (DrawableSelector) invokeI.objValue;
    }

    public DrawableSelector setGradientCenter(float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048640, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            this.centerX = f2;
            this.centerY = f3;
            return this;
        }
        return (DrawableSelector) invokeCommon.objValue;
    }

    public DrawableSelector setShape(@Shape int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048641, this, i2)) == null) {
            this.mShape = i2;
            return this;
        }
        return (DrawableSelector) invokeI.objValue;
    }

    public DrawableSelector setSize(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048642, this, i2, i3)) == null) {
            this.width = i2;
            this.height = i3;
            return this;
        }
        return (DrawableSelector) invokeII.objValue;
    }

    public DrawableSelector setType(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048643, this, i2)) == null) {
            this.mType = i2;
            return this;
        }
        return (DrawableSelector) invokeI.objValue;
    }

    public DrawableSelector strokeWidth(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048644, this, i2)) == null) {
            this.mStrokeWidth = i2;
            return this;
        }
        return (DrawableSelector) invokeI.objValue;
    }

    public DrawableSelector strokeWidthDimenId(@DimenRes int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048645, this, i2)) == null) {
            this.mStrokeWidth = SelectorHelper.getDimens(i2);
            return this;
        }
        return (DrawableSelector) invokeI.objValue;
    }

    public DrawableSelector tlRadius(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048646, this, f2)) == null) {
            this.isRadius = true;
            this.topLeftRadius = f2;
            return this;
        }
        return (DrawableSelector) invokeF.objValue;
    }

    public DrawableSelector trRadius(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048647, this, f2)) == null) {
            this.isRadius = true;
            this.topRightRadius = f2;
            return this;
        }
        return (DrawableSelector) invokeF.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.core.util.tbselector.interfaces.ISelector
    public StateListDrawable build() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            StateListDrawable create = create();
            this.mStateListDrawable = create;
            return create;
        }
        return (StateListDrawable) invokeV.objValue;
    }

    public DrawableSelector disabledDrawable(@DrawableRes int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048598, this, i2)) == null) ? disabledDrawable(SelectorHelper.getDrawable(i2)) : (DrawableSelector) invokeI.objValue;
    }

    public DrawableSelector focusedDrawable(@DrawableRes int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048604, this, i2)) == null) ? focusedDrawable(SelectorHelper.getDrawable(i2)) : (DrawableSelector) invokeI.objValue;
    }

    public DrawableSelector pressedDrawable(@DrawableRes int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048628, this, i2)) == null) ? pressedDrawable(SelectorHelper.getDrawable(i2)) : (DrawableSelector) invokeI.objValue;
    }

    public DrawableSelector selectedDrawable(@DrawableRes int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048635, this, i2)) == null) ? selectedDrawable(SelectorHelper.getDrawable(i2)) : (DrawableSelector) invokeI.objValue;
    }

    public DrawableSelector disabledColor(@ColorRes int i2, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048596, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2)})) == null) {
            this.mDisabledBgColor = SelectorHelper.getColor(i2, f2);
            this.hasSetDisabledBgColor = true;
            this.isSolid = true;
            return this;
        }
        return (DrawableSelector) invokeCommon.objValue;
    }

    public DrawableSelector disabledStrokeColor(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, str)) == null) {
            this.mDisabledStrokeColor = SelectorHelper.parseColor(str);
            this.hasSetDisabledStrokeColor = true;
            this.isStroke = true;
            return this;
        }
        return (DrawableSelector) invokeL.objValue;
    }

    public DrawableSelector focusedColor(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, str)) == null) {
            this.mFocusedBgColor = SelectorHelper.parseColor(str);
            this.isSolid = true;
            this.hasSetPressedBgColor = true;
            return this;
        }
        return (DrawableSelector) invokeL.objValue;
    }

    public DrawableSelector focusedStrokeColor(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, str)) == null) {
            this.mFocusedStrokeColor = SelectorHelper.parseColor(str);
            this.hasSetFocusedStrokeColor = true;
            this.isStroke = true;
            return this;
        }
        return (DrawableSelector) invokeL.objValue;
    }

    public DrawableSelector pressedColor(@ColorRes int i2, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048626, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2)})) == null) {
            this.mPressedBgColor = SelectorHelper.getColor(i2, f2);
            this.hasSetPressedBgColor = true;
            this.isSolid = true;
            return this;
        }
        return (DrawableSelector) invokeCommon.objValue;
    }

    public DrawableSelector pressedStrokeColor(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048631, this, str)) == null) {
            this.mPressedStrokeColor = SelectorHelper.parseColor(str);
            this.hasSetPressedStrokeColor = true;
            this.isStroke = true;
            return this;
        }
        return (DrawableSelector) invokeL.objValue;
    }

    public DrawableSelector selectedColor(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048634, this, str)) == null) {
            this.mSelectedBgColor = SelectorHelper.parseColor(str);
            this.hasSetSelectedBgColor = true;
            this.isSolid = true;
            return this;
        }
        return (DrawableSelector) invokeL.objValue;
    }

    public DrawableSelector selectedStrokeColor(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048638, this, str)) == null) {
            this.mSelectedStrokeColor = SelectorHelper.parseColor(str);
            this.hasSetSelectedStrokeColor = true;
            this.isStroke = true;
            return this;
        }
        return (DrawableSelector) invokeL.objValue;
    }

    public DrawableSelector dashLine(String str, int i2, float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{str, Integer.valueOf(i2), Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            this.isDashLine = true;
            this.dashLineWidth = i2;
            this.dashWidth = f2;
            this.dashGap = f3;
            this.dashLineColor = SelectorHelper.parseColor(str);
            return this;
        }
        return (DrawableSelector) invokeCommon.objValue;
    }

    public DrawableSelector disabledColor(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, str)) == null) {
            this.mDisabledBgColor = SelectorHelper.parseColor(str);
            this.hasSetDisabledBgColor = true;
            this.isSolid = true;
            return this;
        }
        return (DrawableSelector) invokeL.objValue;
    }

    public DrawableSelector gradient(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048609, this, str, str2)) == null) {
            this.isGradient = true;
            this.gradientColors = r1;
            int[] iArr = {SelectorHelper.parseColor(str)};
            this.gradientColors[1] = SelectorHelper.parseColor(str2);
            this.gradientType = 0;
            this.gradientOrientation = TOP_BOTTOM;
            return this;
        }
        return (DrawableSelector) invokeLL.objValue;
    }

    public DrawableSelector pressedColor(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048627, this, str)) == null) {
            this.mPressedBgColor = SelectorHelper.parseColor(str);
            this.hasSetPressedBgColor = true;
            this.isSolid = true;
            return this;
        }
        return (DrawableSelector) invokeL.objValue;
    }

    public DrawableSelector gradientSweep(String... strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048618, this, strArr)) == null) {
            this.isGradient = true;
            this.gradientType = 2;
            if (strArr.length > 1) {
                this.gradientColors = new int[strArr.length];
                for (int i2 = 0; i2 < strArr.length; i2++) {
                    this.gradientColors[i2] = SelectorHelper.parseColor(strArr[i2]);
                }
                return this;
            }
            throw new ExceptionInInitializerError("渐变颜色数组至少需要两个颜色");
        }
        return (DrawableSelector) invokeL.objValue;
    }

    public DrawableSelector gradientLinear(String... strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048613, this, strArr)) == null) {
            this.isGradient = true;
            this.gradientType = 0;
            this.gradientOrientation = TOP_BOTTOM;
            if (strArr.length > 1) {
                this.gradientColors = new int[strArr.length];
                for (int i2 = 0; i2 < strArr.length; i2++) {
                    this.gradientColors[i2] = SelectorHelper.parseColor(strArr[i2]);
                }
                return this;
            }
            throw new ExceptionInInitializerError("渐变颜色数组至少需要两个颜色");
        }
        return (DrawableSelector) invokeL.objValue;
    }

    public DrawableSelector gradientRadial(float f2, String... strArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048616, this, new Object[]{Float.valueOf(f2), strArr})) == null) {
            this.isGradient = true;
            this.gradientType = 1;
            this.radialRadius = f2;
            if (strArr.length > 1) {
                this.gradientColors = new int[strArr.length];
                for (int i2 = 0; i2 < strArr.length; i2++) {
                    this.gradientColors[i2] = SelectorHelper.parseColor(strArr[i2]);
                }
                return this;
            }
            throw new ExceptionInInitializerError("渐变颜色数组至少需要两个颜色");
        }
        return (DrawableSelector) invokeCommon.objValue;
    }

    public DrawableSelector defaultDrawable(@DrawableRes int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i2)) == null) ? defaultDrawable(SelectorHelper.getDrawable(i2)) : (DrawableSelector) invokeI.objValue;
    }

    public DrawableSelector defaultColor(@ColorRes int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048586, this, i2, i3)) == null) {
            int color = SkinManager.getColor(i3, i2);
            this.mDefaultBgColor = color;
            this.isSolid = true;
            if (!this.hasSetDisabledBgColor) {
                this.mDisabledBgColor = color;
            }
            if (!this.hasSetPressedBgColor) {
                this.mPressedBgColor = color;
            }
            if (!this.hasSetSelectedBgColor) {
                this.mSelectedBgColor = color;
            }
            if (!this.hasSetFocusedBgColor) {
                this.mFocusedBgColor = color;
            }
            return this;
        }
        return (DrawableSelector) invokeII.objValue;
    }

    public DrawableSelector defaultStrokeColor(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, str)) == null) {
            int parseColor = SelectorHelper.parseColor(str);
            this.mDefaultStrokeColor = parseColor;
            this.isStroke = true;
            if (!this.hasSetDisabledStrokeColor) {
                this.mDisabledStrokeColor = parseColor;
            }
            if (!this.hasSetPressedStrokeColor) {
                this.mPressedStrokeColor = parseColor;
            }
            if (!this.hasSetSelectedStrokeColor) {
                this.mSelectedStrokeColor = parseColor;
            }
            if (!this.hasSetFocusedStrokeColor) {
                this.mFocusedStrokeColor = parseColor;
            }
            return this;
        }
        return (DrawableSelector) invokeL.objValue;
    }

    public DrawableSelector gradientLinear(String str, @ColorRes int... iArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048610, this, str, iArr)) == null) {
            this.isGradient = true;
            this.gradientType = 0;
            this.gradientOrientation = str;
            if (iArr.length > 1) {
                this.gradientColors = new int[iArr.length];
                for (int i2 = 0; i2 < iArr.length; i2++) {
                    this.gradientColors[i2] = SelectorHelper.getColor(iArr[i2]);
                }
                return this;
            }
            throw new ExceptionInInitializerError("渐变颜色数组至少需要两个颜色");
        }
        return (DrawableSelector) invokeLL.objValue;
    }

    public DrawableSelector defaultColor(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
            int parseColor = SelectorHelper.parseColor(str);
            this.mDefaultBgColor = parseColor;
            this.isSolid = true;
            if (!this.hasSetDisabledBgColor) {
                this.mDisabledBgColor = parseColor;
            }
            if (!this.hasSetPressedBgColor) {
                this.mPressedBgColor = parseColor;
            }
            if (!this.hasSetSelectedBgColor) {
                this.mSelectedBgColor = parseColor;
            }
            if (!this.hasSetFocusedBgColor) {
                this.mFocusedBgColor = parseColor;
            }
            return this;
        }
        return (DrawableSelector) invokeL.objValue;
    }

    public DrawableSelector gradientLinear(String str, String... strArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048611, this, str, strArr)) == null) {
            this.isGradient = true;
            this.gradientType = 0;
            this.gradientOrientation = str;
            if (strArr.length > 1) {
                this.gradientColors = new int[strArr.length];
                for (int i2 = 0; i2 < strArr.length; i2++) {
                    this.gradientColors[i2] = SelectorHelper.parseColor(strArr[i2]);
                }
                return this;
            }
            throw new ExceptionInInitializerError("渐变颜色数组至少需要两个颜色");
        }
        return (DrawableSelector) invokeLL.objValue;
    }
}
