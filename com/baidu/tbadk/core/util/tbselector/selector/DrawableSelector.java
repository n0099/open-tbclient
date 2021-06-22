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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.tbselector.interfaces.ISelector;
import com.baidu.tbadk.core.util.tbselector.utils.SelectorHelper;
import d.a.o0.e3.c;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes3.dex */
public class DrawableSelector extends AbsDrawableSelector implements ISelector<StateListDrawable, View> {
    public static final String BL_TR = "BL_TR";
    public static final String BOTTOM_TOP = "BOTTOM_TOP";
    public static final String BR_TL = "BR_TL";
    public static final String LEFT_RIGHT = "LEFT_RIGHT";
    public static final String RIGHT_LEFT = "RIGHT_LEFT";
    public static final String TL_BR = "TL_BR";
    public static final String TOP_BOTTOM = "TOP_BOTTOM";
    public static final String TR_BL = "TR_BL";
    public float centerX;
    public float centerY;
    public int[] gradientColors;
    public int height;
    public boolean isDashLine;
    public boolean isGradient;
    public boolean isRadius;
    public boolean isSolid;
    public boolean isStroke;
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
    public StateListDrawable mStateListDrawable;
    public float radialRadius;
    public int width;
    public int dashLineWidth = 1;
    public int dashLineColor = 1;
    public float dashWidth = 1.0f;
    public float dashGap = 1.0f;
    public int gradientType = 0;
    public String gradientOrientation = TOP_BOTTOM;
    public float topRightRadius = 0.0f;
    public float topLeftRadius = 0.0f;
    public float bottomRightRadius = 0.0f;
    public float bottomLeftRadius = 0.0f;
    public int mShape = 0;
    public int mCornerRadius = 0;
    public int mStrokeWidth = 0;
    public boolean hasSetDisabledBgColor = false;
    public boolean hasSetPressedBgColor = false;
    public boolean hasSetSelectedBgColor = false;
    public boolean hasSetFocusedBgColor = false;
    public boolean hasSetDisabledStrokeColor = false;
    public boolean hasSetPressedStrokeColor = false;
    public boolean hasSetSelectedStrokeColor = false;
    public boolean hasSetFocusedStrokeColor = false;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface GradientOrientation {
    }

    /* loaded from: classes3.dex */
    public @interface Shape {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private GradientDrawable.Orientation createGradientOrientation() {
        char c2;
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

    public static DrawableSelector make() {
        return new DrawableSelector();
    }

    private GradientDrawable makeItemShapeDrawable(int i2, int i3, int i4, int i5) {
        GradientDrawable gradientDrawable;
        int i6;
        int[] iArr;
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

    public DrawableSelector autoGradient(@ColorRes int i2) {
        this.isGradient = true;
        this.gradientColors = r1;
        int[] iArr = {0, SelectorHelper.getColor(i2)};
        int[] iArr2 = this.gradientColors;
        iArr2[0] = c.b(iArr2[1]);
        this.gradientType = 0;
        this.gradientOrientation = TOP_BOTTOM;
        return this;
    }

    public DrawableSelector blRadius(float f2) {
        this.isRadius = true;
        this.bottomLeftRadius = f2;
        return this;
    }

    public DrawableSelector brRadius(float f2) {
        this.isRadius = true;
        this.bottomRightRadius = f2;
        return this;
    }

    public DrawableSelector cornerRadius(int i2) {
        this.mCornerRadius = i2;
        return this;
    }

    public StateListDrawable create() {
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

    public DrawableSelector dashLine(@ColorRes int i2, int i3, float f2, float f3) {
        this.isDashLine = true;
        this.dashLineWidth = i3;
        this.dashWidth = f2;
        this.dashGap = f3;
        this.dashLineColor = SelectorHelper.getColor(i2);
        return this;
    }

    public DrawableSelector defaultColor(@ColorRes int i2) {
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

    public DrawableSelector defaultColorNotAutoChangeSkinType(@ColorRes int i2) {
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

    public DrawableSelector defaultColorValue(int i2) {
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

    public DrawableSelector defaultColorValueNotAutoChangeSkinType(int i2) {
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

    public DrawableSelector defaultDrawable(Drawable drawable) {
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

    public DrawableSelector defaultStrokeColor(@ColorRes int i2) {
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

    public DrawableSelector disabledColor(@ColorRes int i2) {
        this.mDisabledBgColor = SelectorHelper.getColor(i2);
        this.hasSetDisabledBgColor = true;
        this.isSolid = true;
        return this;
    }

    public DrawableSelector disabledDrawable(Drawable drawable) {
        this.mDisabledDrawable = drawable;
        this.hasSetDisabledDrawable = true;
        return this;
    }

    public DrawableSelector disabledStrokeColor(@ColorRes int i2) {
        this.mDisabledStrokeColor = SelectorHelper.getColor(i2);
        this.hasSetDisabledStrokeColor = true;
        this.isStroke = true;
        return this;
    }

    public DrawableSelector focusedColor(@ColorRes int i2) {
        this.mFocusedBgColor = SelectorHelper.getColor(i2);
        this.isSolid = true;
        this.hasSetPressedBgColor = true;
        return this;
    }

    public DrawableSelector focusedDrawable(Drawable drawable) {
        this.mFocusedDrawable = drawable;
        this.hasSetFocusedDrawable = true;
        return this;
    }

    public DrawableSelector focusedStrokeColor(@ColorRes int i2) {
        this.mFocusedStrokeColor = SelectorHelper.getColor(i2);
        this.hasSetFocusedStrokeColor = true;
        this.isStroke = true;
        return this;
    }

    public DrawableSelector gradient(@ColorRes int i2, @ColorRes int i3) {
        this.isGradient = true;
        this.gradientColors = r1;
        int[] iArr = {SelectorHelper.getColor(i2)};
        this.gradientColors[1] = SelectorHelper.getColor(i3);
        this.gradientType = 0;
        this.gradientOrientation = TOP_BOTTOM;
        return this;
    }

    public DrawableSelector gradientLinear(@ColorRes int... iArr) {
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

    public DrawableSelector gradientLinearNotAutoChangeSkinType(@ColorRes int... iArr) {
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

    public DrawableSelector gradientRadial(float f2, int... iArr) {
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

    public DrawableSelector gradientSweep(int... iArr) {
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

    @Override // com.baidu.tbadk.core.util.tbselector.interfaces.ISelector
    public void into(View view) {
        if (view == null) {
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
        Drawable drawable = this.mNormalDrawable;
        return drawable == null ? makeItemShapeDrawable(this.mShape, this.mDefaultBgColor, this.mDefaultStrokeColor, this.dashLineColor) : drawable;
    }

    @Override // com.baidu.tbadk.core.util.tbselector.selector.AbsDrawableSelector
    public Drawable onItemDisabledDrawable() {
        Drawable drawable = this.mDisabledDrawable;
        boolean z = this.hasSetDisabledDrawable;
        return (this.hasSetDisabledBgColor || this.hasSetDisabledStrokeColor) ? makeItemShapeDrawable(this.mShape, this.mDisabledBgColor, this.mDisabledStrokeColor, this.dashLineColor) : drawable;
    }

    @Override // com.baidu.tbadk.core.util.tbselector.selector.AbsDrawableSelector
    public Drawable onItemFocusedDrawable() {
        Drawable drawable = this.mFocusedDrawable;
        return this.hasSetFocusedDrawable ? drawable : (this.hasSetFocusedBgColor || this.hasSetFocusedStrokeColor) ? makeItemShapeDrawable(this.mShape, this.mFocusedBgColor, this.mFocusedStrokeColor, this.dashLineColor) : drawable;
    }

    @Override // com.baidu.tbadk.core.util.tbselector.selector.AbsDrawableSelector
    public Drawable onItemPressedDrawable() {
        Drawable drawable = this.mPressedDrawable;
        return this.hasSetPressedDrawable ? drawable : (this.hasSetPressedBgColor || this.hasSetPressedStrokeColor) ? makeItemShapeDrawable(this.mShape, this.mPressedBgColor, this.mPressedStrokeColor, this.dashLineColor) : drawable;
    }

    @Override // com.baidu.tbadk.core.util.tbselector.selector.AbsDrawableSelector
    public Drawable onItemSelectedDrawable() {
        Drawable drawable = this.mSelectedDrawable;
        return this.hasSetSelectedDrawable ? drawable : (this.hasSetSelectedBgColor || this.hasSetSelectedStrokeColor) ? makeItemShapeDrawable(this.mShape, this.mSelectedBgColor, this.mSelectedStrokeColor, this.dashLineColor) : drawable;
    }

    public DrawableSelector pressedColor(@ColorRes int i2) {
        this.mPressedBgColor = SelectorHelper.getColor(i2);
        this.hasSetPressedBgColor = true;
        this.isSolid = true;
        return this;
    }

    public DrawableSelector pressedDrawable(Drawable drawable) {
        this.mPressedDrawable = drawable;
        this.hasSetPressedDrawable = true;
        return this;
    }

    public DrawableSelector pressedStrokeColor(@ColorRes int i2) {
        this.mPressedStrokeColor = SelectorHelper.getColor(i2);
        this.hasSetPressedStrokeColor = true;
        this.isStroke = true;
        return this;
    }

    public DrawableSelector radius(float f2) {
        this.isRadius = true;
        this.topRightRadius = f2;
        this.topLeftRadius = f2;
        this.bottomRightRadius = f2;
        this.bottomLeftRadius = f2;
        return this;
    }

    public DrawableSelector selectedColor(@ColorRes int i2) {
        this.mSelectedBgColor = SelectorHelper.getColor(i2);
        this.hasSetSelectedBgColor = true;
        this.isSolid = true;
        return this;
    }

    public DrawableSelector selectedDrawable(Drawable drawable) {
        this.mSelectedDrawable = drawable;
        this.hasSetSelectedDrawable = true;
        return this;
    }

    public DrawableSelector selectedStrokeColor(@ColorRes int i2) {
        this.mSelectedStrokeColor = SelectorHelper.getColor(i2);
        this.hasSetSelectedStrokeColor = true;
        this.isStroke = true;
        return this;
    }

    public DrawableSelector setAlpha(@IntRange(from = 0, to = 255) int i2) {
        this.mAlpha = i2;
        this.hasSetAlpha = true;
        return this;
    }

    public DrawableSelector setGradientCenter(float f2, float f3) {
        this.centerX = f2;
        this.centerY = f3;
        return this;
    }

    public DrawableSelector setShape(@Shape int i2) {
        this.mShape = i2;
        return this;
    }

    public DrawableSelector setSize(int i2, int i3) {
        this.width = i2;
        this.height = i3;
        return this;
    }

    public DrawableSelector setType(int i2) {
        this.mType = i2;
        return this;
    }

    public DrawableSelector strokeWidth(int i2) {
        this.mStrokeWidth = i2;
        return this;
    }

    public DrawableSelector strokeWidthDimenId(@DimenRes int i2) {
        this.mStrokeWidth = SelectorHelper.getDimens(i2);
        return this;
    }

    public DrawableSelector tlRadius(float f2) {
        this.isRadius = true;
        this.topLeftRadius = f2;
        return this;
    }

    public DrawableSelector trRadius(float f2) {
        this.isRadius = true;
        this.topRightRadius = f2;
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.core.util.tbselector.interfaces.ISelector
    public StateListDrawable build() {
        StateListDrawable create = create();
        this.mStateListDrawable = create;
        return create;
    }

    public DrawableSelector disabledDrawable(@DrawableRes int i2) {
        return disabledDrawable(SelectorHelper.getDrawable(i2));
    }

    public DrawableSelector focusedDrawable(@DrawableRes int i2) {
        return focusedDrawable(SelectorHelper.getDrawable(i2));
    }

    public DrawableSelector pressedDrawable(@DrawableRes int i2) {
        return pressedDrawable(SelectorHelper.getDrawable(i2));
    }

    public DrawableSelector selectedDrawable(@DrawableRes int i2) {
        return selectedDrawable(SelectorHelper.getDrawable(i2));
    }

    public DrawableSelector disabledColor(@ColorRes int i2, float f2) {
        this.mDisabledBgColor = SelectorHelper.getColor(i2, f2);
        this.hasSetDisabledBgColor = true;
        this.isSolid = true;
        return this;
    }

    public DrawableSelector disabledStrokeColor(String str) {
        this.mDisabledStrokeColor = SelectorHelper.parseColor(str);
        this.hasSetDisabledStrokeColor = true;
        this.isStroke = true;
        return this;
    }

    public DrawableSelector focusedColor(String str) {
        this.mFocusedBgColor = SelectorHelper.parseColor(str);
        this.isSolid = true;
        this.hasSetPressedBgColor = true;
        return this;
    }

    public DrawableSelector focusedStrokeColor(String str) {
        this.mFocusedStrokeColor = SelectorHelper.parseColor(str);
        this.hasSetFocusedStrokeColor = true;
        this.isStroke = true;
        return this;
    }

    public DrawableSelector pressedColor(@ColorRes int i2, float f2) {
        this.mPressedBgColor = SelectorHelper.getColor(i2, f2);
        this.hasSetPressedBgColor = true;
        this.isSolid = true;
        return this;
    }

    public DrawableSelector pressedStrokeColor(String str) {
        this.mPressedStrokeColor = SelectorHelper.parseColor(str);
        this.hasSetPressedStrokeColor = true;
        this.isStroke = true;
        return this;
    }

    public DrawableSelector selectedColor(String str) {
        this.mSelectedBgColor = SelectorHelper.parseColor(str);
        this.hasSetSelectedBgColor = true;
        this.isSolid = true;
        return this;
    }

    public DrawableSelector selectedStrokeColor(String str) {
        this.mSelectedStrokeColor = SelectorHelper.parseColor(str);
        this.hasSetSelectedStrokeColor = true;
        this.isStroke = true;
        return this;
    }

    public DrawableSelector dashLine(String str, int i2, float f2, float f3) {
        this.isDashLine = true;
        this.dashLineWidth = i2;
        this.dashWidth = f2;
        this.dashGap = f3;
        this.dashLineColor = SelectorHelper.parseColor(str);
        return this;
    }

    public DrawableSelector disabledColor(String str) {
        this.mDisabledBgColor = SelectorHelper.parseColor(str);
        this.hasSetDisabledBgColor = true;
        this.isSolid = true;
        return this;
    }

    public DrawableSelector gradient(String str, String str2) {
        this.isGradient = true;
        this.gradientColors = r1;
        int[] iArr = {SelectorHelper.parseColor(str)};
        this.gradientColors[1] = SelectorHelper.parseColor(str2);
        this.gradientType = 0;
        this.gradientOrientation = TOP_BOTTOM;
        return this;
    }

    public DrawableSelector pressedColor(String str) {
        this.mPressedBgColor = SelectorHelper.parseColor(str);
        this.hasSetPressedBgColor = true;
        this.isSolid = true;
        return this;
    }

    public DrawableSelector gradientSweep(String... strArr) {
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

    public DrawableSelector gradientLinear(String... strArr) {
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

    public DrawableSelector gradientRadial(float f2, String... strArr) {
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

    public DrawableSelector defaultDrawable(@DrawableRes int i2) {
        return defaultDrawable(SelectorHelper.getDrawable(i2));
    }

    public DrawableSelector defaultColor(@ColorRes int i2, int i3) {
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

    public DrawableSelector defaultStrokeColor(String str) {
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

    public DrawableSelector gradientLinear(String str, @ColorRes int... iArr) {
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

    public DrawableSelector defaultColor(String str) {
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

    public DrawableSelector gradientLinear(String str, String... strArr) {
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
}
