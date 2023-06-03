package com.baidu.searchbox.ui.cardview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import com.baidu.searchbox.common.res.R;
/* loaded from: classes4.dex */
public class RelativeCardView extends RelativeLayout {
    public static final int[] COLOR_BACKGROUND_ATTR = {16842801};
    public static final CardViewImpl IMPL;
    public final CardViewDelegate mCardViewDelegate;
    public boolean mCompatPadding;
    public final Rect mContentPadding;
    public boolean mPreventCornerOverlap;
    public final Rect mShadowBounds;
    public int mUserSetMinHeight;
    public int mUserSetMinWidth;

    @Override // android.view.View
    public void setPadding(int i, int i2, int i3, int i4) {
    }

    @Override // android.view.View
    public void setPaddingRelative(int i, int i2, int i3, int i4) {
    }

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 21) {
            IMPL = new CardViewApi21();
        } else if (i >= 17) {
            IMPL = new CardViewJellybeanMr1();
        } else {
            IMPL = new CardViewGingerbread();
        }
        IMPL.initStatic();
    }

    public ColorStateList getCardBackgroundColor() {
        return IMPL.getBackgroundColor(this.mCardViewDelegate);
    }

    public float getCardElevation() {
        return IMPL.getElevation(this.mCardViewDelegate);
    }

    public int getContentPaddingBottom() {
        return this.mContentPadding.bottom;
    }

    public int getContentPaddingLeft() {
        return this.mContentPadding.left;
    }

    public int getContentPaddingRight() {
        return this.mContentPadding.right;
    }

    public int getContentPaddingTop() {
        return this.mContentPadding.top;
    }

    public float getMaxCardElevation() {
        return IMPL.getMaxElevation(this.mCardViewDelegate);
    }

    public boolean getPreventCornerOverlap() {
        return this.mPreventCornerOverlap;
    }

    public float getRadius() {
        return IMPL.getRadius(this.mCardViewDelegate);
    }

    public boolean getUseCompatPadding() {
        return this.mCompatPadding;
    }

    public RelativeCardView(Context context) {
        super(context);
        this.mContentPadding = new Rect();
        this.mShadowBounds = new Rect();
        this.mCardViewDelegate = new CardViewDelegate() { // from class: com.baidu.searchbox.ui.cardview.RelativeCardView.1
            public Drawable mCardBackground;

            @Override // com.baidu.searchbox.ui.cardview.CardViewDelegate
            public void setCardBackground(Drawable drawable) {
                this.mCardBackground = drawable;
                RelativeCardView.this.setBackgroundDrawable(drawable);
            }

            @Override // com.baidu.searchbox.ui.cardview.CardViewDelegate
            public Drawable getCardBackground() {
                return this.mCardBackground;
            }

            @Override // com.baidu.searchbox.ui.cardview.CardViewDelegate
            public View getCardView() {
                return RelativeCardView.this;
            }

            @Override // com.baidu.searchbox.ui.cardview.CardViewDelegate
            public boolean getPreventCornerOverlap() {
                return RelativeCardView.this.getPreventCornerOverlap();
            }

            @Override // com.baidu.searchbox.ui.cardview.CardViewDelegate
            public boolean getUseCompatPadding() {
                return RelativeCardView.this.getUseCompatPadding();
            }

            @Override // com.baidu.searchbox.ui.cardview.CardViewDelegate
            public void setMinWidthHeightInternal(int i, int i2) {
                if (i > RelativeCardView.this.mUserSetMinWidth) {
                    RelativeCardView.super.setMinimumWidth(i);
                }
                if (i2 > RelativeCardView.this.mUserSetMinHeight) {
                    RelativeCardView.super.setMinimumHeight(i2);
                }
            }

            @Override // com.baidu.searchbox.ui.cardview.CardViewDelegate
            public void setShadowPadding(int i, int i2, int i3, int i4) {
                RelativeCardView.this.mShadowBounds.set(i, i2, i3, i4);
                RelativeCardView relativeCardView = RelativeCardView.this;
                RelativeCardView.super.setPadding(i + relativeCardView.mContentPadding.left, i2 + RelativeCardView.this.mContentPadding.top, i3 + RelativeCardView.this.mContentPadding.right, i4 + RelativeCardView.this.mContentPadding.bottom);
            }
        };
        initialize(context, null, 0);
    }

    public void setCardBackgroundColor(@ColorInt int i) {
        IMPL.setBackgroundColor(this.mCardViewDelegate, ColorStateList.valueOf(i));
    }

    public void setCardElevation(float f) {
        IMPL.setElevation(this.mCardViewDelegate, f);
    }

    public void setMaxCardElevation(float f) {
        IMPL.setMaxElevation(this.mCardViewDelegate, f);
    }

    @Override // android.view.View
    public void setMinimumHeight(int i) {
        this.mUserSetMinHeight = i;
        super.setMinimumHeight(i);
    }

    @Override // android.view.View
    public void setMinimumWidth(int i) {
        this.mUserSetMinWidth = i;
        super.setMinimumWidth(i);
    }

    public void setPreventCornerOverlap(boolean z) {
        if (z != this.mPreventCornerOverlap) {
            this.mPreventCornerOverlap = z;
            IMPL.onPreventCornerOverlapChanged(this.mCardViewDelegate);
        }
    }

    public void setRadius(float f) {
        IMPL.setRadius(this.mCardViewDelegate, f);
    }

    public void setUseCompatPadding(boolean z) {
        if (this.mCompatPadding != z) {
            this.mCompatPadding = z;
            IMPL.onCompatPaddingChanged(this.mCardViewDelegate);
        }
    }

    public RelativeCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContentPadding = new Rect();
        this.mShadowBounds = new Rect();
        this.mCardViewDelegate = new CardViewDelegate() { // from class: com.baidu.searchbox.ui.cardview.RelativeCardView.1
            public Drawable mCardBackground;

            @Override // com.baidu.searchbox.ui.cardview.CardViewDelegate
            public void setCardBackground(Drawable drawable) {
                this.mCardBackground = drawable;
                RelativeCardView.this.setBackgroundDrawable(drawable);
            }

            @Override // com.baidu.searchbox.ui.cardview.CardViewDelegate
            public Drawable getCardBackground() {
                return this.mCardBackground;
            }

            @Override // com.baidu.searchbox.ui.cardview.CardViewDelegate
            public View getCardView() {
                return RelativeCardView.this;
            }

            @Override // com.baidu.searchbox.ui.cardview.CardViewDelegate
            public boolean getPreventCornerOverlap() {
                return RelativeCardView.this.getPreventCornerOverlap();
            }

            @Override // com.baidu.searchbox.ui.cardview.CardViewDelegate
            public boolean getUseCompatPadding() {
                return RelativeCardView.this.getUseCompatPadding();
            }

            @Override // com.baidu.searchbox.ui.cardview.CardViewDelegate
            public void setMinWidthHeightInternal(int i, int i2) {
                if (i > RelativeCardView.this.mUserSetMinWidth) {
                    RelativeCardView.super.setMinimumWidth(i);
                }
                if (i2 > RelativeCardView.this.mUserSetMinHeight) {
                    RelativeCardView.super.setMinimumHeight(i2);
                }
            }

            @Override // com.baidu.searchbox.ui.cardview.CardViewDelegate
            public void setShadowPadding(int i, int i2, int i3, int i4) {
                RelativeCardView.this.mShadowBounds.set(i, i2, i3, i4);
                RelativeCardView relativeCardView = RelativeCardView.this;
                RelativeCardView.super.setPadding(i + relativeCardView.mContentPadding.left, i2 + RelativeCardView.this.mContentPadding.top, i3 + RelativeCardView.this.mContentPadding.right, i4 + RelativeCardView.this.mContentPadding.bottom);
            }
        };
        initialize(context, attributeSet, 0);
    }

    public RelativeCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContentPadding = new Rect();
        this.mShadowBounds = new Rect();
        this.mCardViewDelegate = new CardViewDelegate() { // from class: com.baidu.searchbox.ui.cardview.RelativeCardView.1
            public Drawable mCardBackground;

            @Override // com.baidu.searchbox.ui.cardview.CardViewDelegate
            public void setCardBackground(Drawable drawable) {
                this.mCardBackground = drawable;
                RelativeCardView.this.setBackgroundDrawable(drawable);
            }

            @Override // com.baidu.searchbox.ui.cardview.CardViewDelegate
            public Drawable getCardBackground() {
                return this.mCardBackground;
            }

            @Override // com.baidu.searchbox.ui.cardview.CardViewDelegate
            public View getCardView() {
                return RelativeCardView.this;
            }

            @Override // com.baidu.searchbox.ui.cardview.CardViewDelegate
            public boolean getPreventCornerOverlap() {
                return RelativeCardView.this.getPreventCornerOverlap();
            }

            @Override // com.baidu.searchbox.ui.cardview.CardViewDelegate
            public boolean getUseCompatPadding() {
                return RelativeCardView.this.getUseCompatPadding();
            }

            @Override // com.baidu.searchbox.ui.cardview.CardViewDelegate
            public void setMinWidthHeightInternal(int i2, int i22) {
                if (i2 > RelativeCardView.this.mUserSetMinWidth) {
                    RelativeCardView.super.setMinimumWidth(i2);
                }
                if (i22 > RelativeCardView.this.mUserSetMinHeight) {
                    RelativeCardView.super.setMinimumHeight(i22);
                }
            }

            @Override // com.baidu.searchbox.ui.cardview.CardViewDelegate
            public void setShadowPadding(int i2, int i22, int i3, int i4) {
                RelativeCardView.this.mShadowBounds.set(i2, i22, i3, i4);
                RelativeCardView relativeCardView = RelativeCardView.this;
                RelativeCardView.super.setPadding(i2 + relativeCardView.mContentPadding.left, i22 + RelativeCardView.this.mContentPadding.top, i3 + RelativeCardView.this.mContentPadding.right, i4 + RelativeCardView.this.mContentPadding.bottom);
            }
        };
        initialize(context, attributeSet, i);
    }

    private void initialize(Context context, AttributeSet attributeSet, int i) {
        int color;
        ColorStateList valueOf;
        float f;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RelativeCardView, i, com.baidu.tieba.R.style.obfuscated_res_0x7f100100);
        if (obtainStyledAttributes.hasValue(2)) {
            valueOf = obtainStyledAttributes.getColorStateList(2);
        } else {
            TypedArray obtainStyledAttributes2 = getContext().obtainStyledAttributes(COLOR_BACKGROUND_ATTR);
            int color2 = obtainStyledAttributes2.getColor(0, 0);
            obtainStyledAttributes2.recycle();
            float[] fArr = new float[3];
            Color.colorToHSV(color2, fArr);
            if (fArr[2] > 0.5f) {
                color = getResources().getColor(com.baidu.tieba.R.color.obfuscated_res_0x7f0604d5);
            } else {
                color = getResources().getColor(com.baidu.tieba.R.color.obfuscated_res_0x7f0604d4);
            }
            valueOf = ColorStateList.valueOf(color);
        }
        ColorStateList colorStateList = valueOf;
        float dimension = obtainStyledAttributes.getDimension(3, 0.0f);
        float dimension2 = obtainStyledAttributes.getDimension(4, 0.0f);
        float dimension3 = obtainStyledAttributes.getDimension(5, 0.0f);
        this.mCompatPadding = obtainStyledAttributes.getBoolean(7, false);
        this.mPreventCornerOverlap = obtainStyledAttributes.getBoolean(6, true);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(8, 0);
        this.mContentPadding.left = obtainStyledAttributes.getDimensionPixelSize(10, dimensionPixelSize);
        this.mContentPadding.top = obtainStyledAttributes.getDimensionPixelSize(12, dimensionPixelSize);
        this.mContentPadding.right = obtainStyledAttributes.getDimensionPixelSize(11, dimensionPixelSize);
        this.mContentPadding.bottom = obtainStyledAttributes.getDimensionPixelSize(9, dimensionPixelSize);
        if (dimension2 > dimension3) {
            f = dimension2;
        } else {
            f = dimension3;
        }
        this.mUserSetMinWidth = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.mUserSetMinHeight = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        obtainStyledAttributes.recycle();
        IMPL.initialize(this.mCardViewDelegate, context, colorStateList, dimension, dimension2, f);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    @SuppressLint({"SwitchIntDef"})
    public void onMeasure(int i, int i2) {
        if (!(IMPL instanceof CardViewApi21)) {
            int mode = View.MeasureSpec.getMode(i);
            if (mode == Integer.MIN_VALUE || mode == 1073741824) {
                i = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil(IMPL.getMinWidth(this.mCardViewDelegate)), View.MeasureSpec.getSize(i)), mode);
            }
            int mode2 = View.MeasureSpec.getMode(i2);
            if (mode2 == Integer.MIN_VALUE || mode2 == 1073741824) {
                i2 = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil(IMPL.getMinHeight(this.mCardViewDelegate)), View.MeasureSpec.getSize(i2)), mode2);
            }
            super.onMeasure(i, i2);
        } else {
            super.onMeasure(i, i2);
        }
        setMeasuredDimension(i, i2);
    }

    public void setCardBackgroundColor(@Nullable ColorStateList colorStateList) {
        IMPL.setBackgroundColor(this.mCardViewDelegate, colorStateList);
    }

    public void setContentPadding(int i, int i2, int i3, int i4) {
        this.mContentPadding.set(i, i2, i3, i4);
        IMPL.updatePadding(this.mCardViewDelegate);
    }
}
