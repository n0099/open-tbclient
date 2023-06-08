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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.tbselector.interfaces.ISelector;
import com.baidu.tbadk.core.util.tbselector.utils.SelectorHelper;
import com.baidu.tieba.ow9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes4.dex */
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
    /* loaded from: classes4.dex */
    public @interface GradientOrientation {
    }

    /* loaded from: classes4.dex */
    public @interface Shape {
    }

    public DrawableSelector() {
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
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            GradientDrawable.Orientation orientation = GradientDrawable.Orientation.TOP_BOTTOM;
            String str = this.gradientOrientation;
            switch (str.hashCode()) {
                case -1196165855:
                    if (str.equals(BOTTOM_TOP)) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                case -873241494:
                    if (str.equals(RIGHT_LEFT)) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case -434150460:
                    if (str.equals(LEFT_RIGHT)) {
                        c = 6;
                        break;
                    }
                    c = 65535;
                    break;
                case 63310483:
                    if (str.equals(BL_TR)) {
                        c = 5;
                        break;
                    }
                    c = 65535;
                    break;
                case 63489223:
                    if (str.equals(BR_TL)) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case 79933303:
                    if (str.equals(TL_BR)) {
                        c = 7;
                        break;
                    }
                    c = 65535;
                    break;
                case 80112043:
                    if (str.equals(TR_BL)) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case 1982197877:
                    if (str.equals(TOP_BOTTOM)) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            switch (c) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return new DrawableSelector();
        }
        return (DrawableSelector) invokeV.objValue;
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

    @Override // com.baidu.tbadk.core.util.tbselector.selector.AbsDrawableSelector
    public Drawable onItemDefaultDrawable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            Drawable drawable = this.mNormalDrawable;
            if (drawable == null) {
                return makeItemShapeDrawable(this.mShape, this.mDefaultBgColor, this.mDefaultStrokeColor, this.dashLineColor);
            }
            return drawable;
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
            if (this.hasSetDisabledBgColor || this.hasSetDisabledStrokeColor) {
                return makeItemShapeDrawable(this.mShape, this.mDisabledBgColor, this.mDisabledStrokeColor, this.dashLineColor);
            }
            return drawable;
        }
        return (Drawable) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.util.tbselector.selector.AbsDrawableSelector
    public Drawable onItemFocusedDrawable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            Drawable drawable = this.mFocusedDrawable;
            if (!this.hasSetFocusedDrawable) {
                if (this.hasSetFocusedBgColor || this.hasSetFocusedStrokeColor) {
                    return makeItemShapeDrawable(this.mShape, this.mFocusedBgColor, this.mFocusedStrokeColor, this.dashLineColor);
                }
                return drawable;
            }
            return drawable;
        }
        return (Drawable) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.util.tbselector.selector.AbsDrawableSelector
    public Drawable onItemPressedDrawable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            Drawable drawable = this.mPressedDrawable;
            if (!this.hasSetPressedDrawable) {
                if (this.hasSetPressedBgColor || this.hasSetPressedStrokeColor) {
                    return makeItemShapeDrawable(this.mShape, this.mPressedBgColor, this.mPressedStrokeColor, this.dashLineColor);
                }
                return drawable;
            }
            return drawable;
        }
        return (Drawable) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.util.tbselector.selector.AbsDrawableSelector
    public Drawable onItemSelectedDrawable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            Drawable drawable = this.mSelectedDrawable;
            if (!this.hasSetSelectedDrawable) {
                if (this.hasSetSelectedBgColor || this.hasSetSelectedStrokeColor) {
                    return makeItemShapeDrawable(this.mShape, this.mSelectedBgColor, this.mSelectedStrokeColor, this.dashLineColor);
                }
                return drawable;
            }
            return drawable;
        }
        return (Drawable) invokeV.objValue;
    }

    private GradientDrawable makeItemShapeDrawable(int i, int i2, int i3, int i4) {
        InterceptResult invokeIIII;
        GradientDrawable gradientDrawable;
        int i5;
        int[] iArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIII = interceptable.invokeIIII(65539, this, i, i2, i3, i4)) == null) {
            if (this.isGradient && (iArr = this.gradientColors) != null && iArr.length > 1) {
                gradientDrawable = new GradientDrawable(createGradientOrientation(), this.gradientColors);
                gradientDrawable.setGradientType(this.gradientType);
                if (this.gradientType == 1) {
                    gradientDrawable.setGradientRadius(this.radialRadius);
                }
            } else {
                gradientDrawable = new GradientDrawable();
            }
            gradientDrawable.setShape(i);
            if (this.isSolid) {
                gradientDrawable.setColor(i2);
            }
            if (this.isStroke) {
                gradientDrawable.setStroke(this.mStrokeWidth, i3);
            } else if (this.isDashLine) {
                gradientDrawable.setStroke(this.dashLineWidth, i4, this.dashWidth, this.dashGap);
            }
            int i6 = this.mCornerRadius;
            if (i6 > 0) {
                gradientDrawable.setCornerRadius(i6);
            } else if (this.isRadius) {
                float f = this.topLeftRadius;
                float f2 = this.topRightRadius;
                float f3 = this.bottomRightRadius;
                float f4 = this.bottomLeftRadius;
                gradientDrawable.setCornerRadii(new float[]{f, f, f2, f2, f3, f3, f4, f4});
            }
            int i7 = this.width;
            if (i7 > 0 && (i5 = this.height) > 0) {
                gradientDrawable.setSize(i7, i5);
            }
            if (this.centerX > 0.0f || this.centerY > 0.0f) {
                gradientDrawable.setGradientCenter(this.centerX, this.centerY);
            }
            updateDrawableAlpha(gradientDrawable);
            return gradientDrawable;
        }
        return (GradientDrawable) invokeIIII.objValue;
    }

    public DrawableSelector autoGradient(@ColorRes int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            this.isGradient = true;
            this.gradientColors = r1;
            int[] iArr = {0, SelectorHelper.getColor(i)};
            int[] iArr2 = this.gradientColors;
            iArr2[0] = ow9.c(iArr2[1]);
            this.gradientType = 0;
            this.gradientOrientation = TOP_BOTTOM;
            return this;
        }
        return (DrawableSelector) invokeI.objValue;
    }

    public DrawableSelector blRadius(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f)) == null) {
            this.isRadius = true;
            this.bottomLeftRadius = f;
            return this;
        }
        return (DrawableSelector) invokeF.objValue;
    }

    public DrawableSelector brRadius(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(Constants.METHOD_SEND_USER_MSG, this, f)) == null) {
            this.isRadius = true;
            this.bottomRightRadius = f;
            return this;
        }
        return (DrawableSelector) invokeF.objValue;
    }

    public DrawableSelector cornerRadius(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            this.mCornerRadius = i;
            return this;
        }
        return (DrawableSelector) invokeI.objValue;
    }

    public DrawableSelector defaultColorValue(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i)) == null) {
            this.mDefaultBgColor = i;
            this.isSolid = true;
            if (!this.hasSetDisabledBgColor) {
                this.mDisabledBgColor = i;
            }
            if (!this.hasSetPressedBgColor) {
                this.mPressedBgColor = i;
            }
            if (!this.hasSetSelectedBgColor) {
                this.mSelectedBgColor = i;
            }
            if (!this.hasSetFocusedBgColor) {
                this.mFocusedBgColor = i;
            }
            return this;
        }
        return (DrawableSelector) invokeI.objValue;
    }

    public DrawableSelector defaultColorValueNotAutoChangeSkinType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i)) == null) {
            this.mDefaultBgColor = i;
            this.isSolid = true;
            if (!this.hasSetDisabledBgColor) {
                this.mDisabledBgColor = i;
            }
            if (!this.hasSetPressedBgColor) {
                this.mPressedBgColor = i;
            }
            if (!this.hasSetSelectedBgColor) {
                this.mSelectedBgColor = i;
            }
            if (!this.hasSetFocusedBgColor) {
                this.mFocusedBgColor = i;
            }
            return this;
        }
        return (DrawableSelector) invokeI.objValue;
    }

    public DrawableSelector defaultDrawable(@DrawableRes int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i)) == null) {
            return defaultDrawable(SelectorHelper.getDrawable(i));
        }
        return (DrawableSelector) invokeI.objValue;
    }

    public DrawableSelector disabledColor(@ColorRes int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048595, this, i)) == null) {
            this.mDisabledBgColor = SelectorHelper.getColor(i);
            this.hasSetDisabledBgColor = true;
            this.isSolid = true;
            return this;
        }
        return (DrawableSelector) invokeI.objValue;
    }

    public DrawableSelector disabledDrawable(@DrawableRes int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048598, this, i)) == null) {
            return disabledDrawable(SelectorHelper.getDrawable(i));
        }
        return (DrawableSelector) invokeI.objValue;
    }

    public DrawableSelector disabledStrokeColor(@ColorRes int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048600, this, i)) == null) {
            this.mDisabledStrokeColor = SelectorHelper.getColor(i);
            this.hasSetDisabledStrokeColor = true;
            this.isStroke = true;
            return this;
        }
        return (DrawableSelector) invokeI.objValue;
    }

    public DrawableSelector focusedColor(@ColorRes int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048602, this, i)) == null) {
            this.mFocusedBgColor = SelectorHelper.getColor(i);
            this.isSolid = true;
            this.hasSetPressedBgColor = true;
            return this;
        }
        return (DrawableSelector) invokeI.objValue;
    }

    public DrawableSelector focusedDrawable(@DrawableRes int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048604, this, i)) == null) {
            return focusedDrawable(SelectorHelper.getDrawable(i));
        }
        return (DrawableSelector) invokeI.objValue;
    }

    public DrawableSelector focusedStrokeColor(@ColorRes int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048606, this, i)) == null) {
            this.mFocusedStrokeColor = SelectorHelper.getColor(i);
            this.hasSetFocusedStrokeColor = true;
            this.isStroke = true;
            return this;
        }
        return (DrawableSelector) invokeI.objValue;
    }

    @Override // com.baidu.tbadk.core.util.tbselector.interfaces.ISelector
    public void into(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048619, this, view2) != null) || view2 == null) {
            return;
        }
        build();
        int i = this.mType;
        if (i == 2) {
            if (view2 instanceof ImageView) {
                ((ImageView) view2).setImageDrawable(this.mStateListDrawable);
            }
        } else if (i == 1) {
            view2.setBackgroundDrawable(this.mStateListDrawable);
        }
    }

    public DrawableSelector pressedColor(@ColorRes int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048625, this, i)) == null) {
            this.mPressedBgColor = SelectorHelper.getColor(i);
            this.hasSetPressedBgColor = true;
            this.isSolid = true;
            return this;
        }
        return (DrawableSelector) invokeI.objValue;
    }

    public DrawableSelector pressedDrawable(@DrawableRes int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048628, this, i)) == null) {
            return pressedDrawable(SelectorHelper.getDrawable(i));
        }
        return (DrawableSelector) invokeI.objValue;
    }

    public DrawableSelector pressedStrokeColor(@ColorRes int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048630, this, i)) == null) {
            this.mPressedStrokeColor = SelectorHelper.getColor(i);
            this.hasSetPressedStrokeColor = true;
            this.isStroke = true;
            return this;
        }
        return (DrawableSelector) invokeI.objValue;
    }

    public DrawableSelector radius(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048632, this, f)) == null) {
            this.isRadius = true;
            this.topRightRadius = f;
            this.topLeftRadius = f;
            this.bottomRightRadius = f;
            this.bottomLeftRadius = f;
            return this;
        }
        return (DrawableSelector) invokeF.objValue;
    }

    public DrawableSelector selectedColor(@ColorRes int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048633, this, i)) == null) {
            this.mSelectedBgColor = SelectorHelper.getColor(i);
            this.hasSetSelectedBgColor = true;
            this.isSolid = true;
            return this;
        }
        return (DrawableSelector) invokeI.objValue;
    }

    public DrawableSelector selectedDrawable(@DrawableRes int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048635, this, i)) == null) {
            return selectedDrawable(SelectorHelper.getDrawable(i));
        }
        return (DrawableSelector) invokeI.objValue;
    }

    public DrawableSelector selectedStrokeColor(@ColorRes int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048637, this, i)) == null) {
            this.mSelectedStrokeColor = SelectorHelper.getColor(i);
            this.hasSetSelectedStrokeColor = true;
            this.isStroke = true;
            return this;
        }
        return (DrawableSelector) invokeI.objValue;
    }

    public DrawableSelector setAlpha(@IntRange(from = 0, to = 255) int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048639, this, i)) == null) {
            this.mAlpha = i;
            this.hasSetAlpha = true;
            return this;
        }
        return (DrawableSelector) invokeI.objValue;
    }

    public DrawableSelector setGradientOrientation(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048641, this, str)) == null) {
            this.gradientOrientation = str;
            return this;
        }
        return (DrawableSelector) invokeL.objValue;
    }

    public DrawableSelector setShape(@Shape int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048642, this, i)) == null) {
            this.mShape = i;
            return this;
        }
        return (DrawableSelector) invokeI.objValue;
    }

    public DrawableSelector setType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048644, this, i)) == null) {
            this.mType = i;
            return this;
        }
        return (DrawableSelector) invokeI.objValue;
    }

    public DrawableSelector strokeWidth(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048645, this, i)) == null) {
            this.mStrokeWidth = i;
            return this;
        }
        return (DrawableSelector) invokeI.objValue;
    }

    public DrawableSelector strokeWidthDimenId(@DimenRes int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048646, this, i)) == null) {
            this.mStrokeWidth = SelectorHelper.getDimens(i);
            return this;
        }
        return (DrawableSelector) invokeI.objValue;
    }

    public DrawableSelector tlRadius(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048647, this, f)) == null) {
            this.isRadius = true;
            this.topLeftRadius = f;
            return this;
        }
        return (DrawableSelector) invokeF.objValue;
    }

    public DrawableSelector trRadius(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048648, this, f)) == null) {
            this.isRadius = true;
            this.topRightRadius = f;
            return this;
        }
        return (DrawableSelector) invokeF.objValue;
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

    public DrawableSelector dashLine(@ColorRes int i, int i2, float f, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(f), Float.valueOf(f2)})) == null) {
            this.isDashLine = true;
            this.dashLineWidth = i2;
            this.dashWidth = f;
            this.dashGap = f2;
            this.dashLineColor = SelectorHelper.getColor(i);
            return this;
        }
        return (DrawableSelector) invokeCommon.objValue;
    }

    public DrawableSelector dashLine(String str, int i, float f, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{str, Integer.valueOf(i), Float.valueOf(f), Float.valueOf(f2)})) == null) {
            this.isDashLine = true;
            this.dashLineWidth = i;
            this.dashWidth = f;
            this.dashGap = f2;
            this.dashLineColor = SelectorHelper.parseColor(str);
            return this;
        }
        return (DrawableSelector) invokeCommon.objValue;
    }

    public DrawableSelector defaultColor(@ColorRes int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) {
            int color = SelectorHelper.getColor(i);
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

    public DrawableSelector defaultColorNotAutoChangeSkinType(@ColorRes int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i)) == null) {
            int color = TbadkCoreApplication.getInst().getApp().getResources().getColor(i);
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

    public DrawableSelector defaultStrokeColor(@ColorRes int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048593, this, i)) == null) {
            int color = SelectorHelper.getColor(i);
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

    public DrawableSelector gradientLinear(@ColorRes int... iArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048612, this, iArr)) == null) {
            this.isGradient = true;
            this.gradientType = 0;
            this.gradientOrientation = TOP_BOTTOM;
            if (iArr.length > 1) {
                this.gradientColors = new int[iArr.length];
                for (int i = 0; i < iArr.length; i++) {
                    this.gradientColors[i] = SelectorHelper.getColor(iArr[i]);
                }
                return this;
            }
            throw new ExceptionInInitializerError("渐变颜色数组至少需要两个颜色");
        }
        return (DrawableSelector) invokeL.objValue;
    }

    public DrawableSelector gradientSweep(int... iArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048617, this, iArr)) == null) {
            this.isGradient = true;
            this.gradientType = 2;
            if (iArr.length > 1) {
                this.gradientColors = new int[iArr.length];
                for (int i = 0; i < iArr.length; i++) {
                    this.gradientColors[i] = SelectorHelper.getColor(iArr[i]);
                }
                return this;
            }
            throw new ExceptionInInitializerError("渐变颜色数组至少需要两个颜色");
        }
        return (DrawableSelector) invokeL.objValue;
    }

    public DrawableSelector defaultColor(@ColorRes int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048586, this, i, i2)) == null) {
            int color = SkinManager.getColor(i2, i);
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

    public DrawableSelector disabledColor(@ColorRes int i, float f) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048596, this, new Object[]{Integer.valueOf(i), Float.valueOf(f)})) == null) {
            this.mDisabledBgColor = SelectorHelper.getColor(i, f);
            this.hasSetDisabledBgColor = true;
            this.isSolid = true;
            return this;
        }
        return (DrawableSelector) invokeCommon.objValue;
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
                for (int i = 0; i < iArr.length; i++) {
                    this.gradientColors[i] = SelectorHelper.getColor(iArr[i]);
                }
                return this;
            }
            throw new ExceptionInInitializerError("渐变颜色数组至少需要两个颜色");
        }
        return (DrawableSelector) invokeLL.objValue;
    }

    public DrawableSelector pressedColor(@ColorRes int i, float f) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048626, this, new Object[]{Integer.valueOf(i), Float.valueOf(f)})) == null) {
            this.mPressedBgColor = SelectorHelper.getColor(i, f);
            this.hasSetPressedBgColor = true;
            this.isSolid = true;
            return this;
        }
        return (DrawableSelector) invokeCommon.objValue;
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

    public DrawableSelector gradientLinear(String... strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048613, this, strArr)) == null) {
            this.isGradient = true;
            this.gradientType = 0;
            this.gradientOrientation = TOP_BOTTOM;
            if (strArr.length > 1) {
                this.gradientColors = new int[strArr.length];
                for (int i = 0; i < strArr.length; i++) {
                    this.gradientColors[i] = SelectorHelper.parseColor(strArr[i]);
                }
                return this;
            }
            throw new ExceptionInInitializerError("渐变颜色数组至少需要两个颜色");
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
                for (int i = 0; i < strArr.length; i++) {
                    this.gradientColors[i] = SelectorHelper.parseColor(strArr[i]);
                }
                return this;
            }
            throw new ExceptionInInitializerError("渐变颜色数组至少需要两个颜色");
        }
        return (DrawableSelector) invokeL.objValue;
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

    public DrawableSelector gradient(@ColorRes int i, @ColorRes int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048608, this, i, i2)) == null) {
            this.isGradient = true;
            this.gradientColors = r1;
            int[] iArr = {SelectorHelper.getColor(i)};
            this.gradientColors[1] = SelectorHelper.getColor(i2);
            this.gradientType = 0;
            this.gradientOrientation = TOP_BOTTOM;
            return this;
        }
        return (DrawableSelector) invokeII.objValue;
    }

    public DrawableSelector setGradientCenter(float f, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048640, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)})) == null) {
            this.centerX = f;
            this.centerY = f2;
            return this;
        }
        return (DrawableSelector) invokeCommon.objValue;
    }

    public DrawableSelector setSize(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048643, this, i, i2)) == null) {
            this.width = i;
            this.height = i2;
            return this;
        }
        return (DrawableSelector) invokeII.objValue;
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

    public DrawableSelector gradientLinear(String str, String... strArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048611, this, str, strArr)) == null) {
            this.isGradient = true;
            this.gradientType = 0;
            this.gradientOrientation = str;
            if (strArr.length > 1) {
                this.gradientColors = new int[strArr.length];
                for (int i = 0; i < strArr.length; i++) {
                    this.gradientColors[i] = SelectorHelper.parseColor(strArr[i]);
                }
                return this;
            }
            throw new ExceptionInInitializerError("渐变颜色数组至少需要两个颜色");
        }
        return (DrawableSelector) invokeLL.objValue;
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
                for (int i = 0; i < iArr.length; i++) {
                    this.gradientColors[i] = TbadkCoreApplication.getInst().getApp().getResources().getColor(iArr[i]);
                }
                return this;
            }
            throw new ExceptionInInitializerError("渐变颜色数组至少需要两个颜色");
        }
        return (DrawableSelector) invokeL.objValue;
    }

    public DrawableSelector gradientRadial(float f, int... iArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048615, this, new Object[]{Float.valueOf(f), iArr})) == null) {
            this.isGradient = true;
            this.gradientType = 1;
            this.radialRadius = f;
            if (iArr.length > 1) {
                this.gradientColors = new int[iArr.length];
                for (int i = 0; i < iArr.length; i++) {
                    this.gradientColors[i] = SelectorHelper.getColor(iArr[i]);
                }
                return this;
            }
            throw new ExceptionInInitializerError("渐变颜色数组至少需要两个颜色");
        }
        return (DrawableSelector) invokeCommon.objValue;
    }

    public DrawableSelector gradientRadial(float f, String... strArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048616, this, new Object[]{Float.valueOf(f), strArr})) == null) {
            this.isGradient = true;
            this.gradientType = 1;
            this.radialRadius = f;
            if (strArr.length > 1) {
                this.gradientColors = new int[strArr.length];
                for (int i = 0; i < strArr.length; i++) {
                    this.gradientColors[i] = SelectorHelper.parseColor(strArr[i]);
                }
                return this;
            }
            throw new ExceptionInInitializerError("渐变颜色数组至少需要两个颜色");
        }
        return (DrawableSelector) invokeCommon.objValue;
    }
}
