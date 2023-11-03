package com.baidu.searchbox.ui.wheelview2d;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.searchbox.skin.NightModeHelper;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class WheelView2d extends BdGallery {
    public static final int[] SHADOWS_COLORS = {-1, -1140850689, 16777215};
    public static final int[] SHADOWS_COLORS_NIGHT = {-15132391, -1155983079, 1644825};
    public static final String TAG = "WheelView2d";
    public Drawable mBottomShadow;
    public int mDefSelectorSize;
    public Rect mSelectorBound;
    public Drawable mSelectorDrawable;
    public int mSelectorHeight;
    public int mShadowHeight;
    public Drawable mTopShadow;

    private void drawShadowsHorizontal(Canvas canvas) {
    }

    private void calcCustomSelectorBoundVertical() {
        int centerOfGallery = getCenterOfGallery();
        int i = this.mSelectorHeight;
        int i2 = centerOfGallery - (i / 2);
        this.mSelectorBound.set(getPaddingLeft(), i2, getWidth() - getPaddingRight(), i + i2);
    }

    private void calcDefaultSelectorBoundVertical() {
        int i;
        int centerOfGallery = getCenterOfGallery();
        View childAt = getChildAt(0);
        if (childAt != null) {
            i = childAt.getMeasuredHeight();
        } else {
            i = this.mDefSelectorSize;
        }
        int i2 = centerOfGallery - (i / 2);
        this.mSelectorBound.set(getPaddingLeft(), i2, getWidth() - getPaddingRight(), i + i2);
    }

    private void calcSelectorBoundHorizontal() {
        int i;
        int centerOfGallery = getCenterOfGallery();
        View childAt = getChildAt(0);
        if (childAt != null) {
            i = childAt.getMeasuredWidth();
        } else {
            i = this.mDefSelectorSize;
        }
        int i2 = centerOfGallery - (i / 2);
        this.mSelectorBound.set(i2, getPaddingTop(), i + i2, getHeight() - getPaddingBottom());
    }

    private void calcSelectorBoundVertical() {
        if (this.mSelectorHeight > 0) {
            calcCustomSelectorBoundVertical();
        } else {
            calcDefaultSelectorBoundVertical();
        }
    }

    @Override // com.baidu.searchbox.ui.wheelview2d.BdGallery, com.baidu.searchbox.ui.wheelview2d.BdAdapterView
    public void selectionChanged() {
        super.selectionChanged();
        playSoundEffect(0);
    }

    public WheelView2d(Context context) {
        super(context);
        this.mSelectorDrawable = null;
        this.mSelectorBound = new Rect();
        this.mTopShadow = null;
        this.mBottomShadow = null;
        this.mSelectorHeight = -1;
        initialize(context);
    }

    private void drawCenterRect(Canvas canvas) {
        Drawable drawable;
        Rect rect = this.mSelectorBound;
        if (rect != null && !rect.isEmpty() && (drawable = this.mSelectorDrawable) != null) {
            drawable.setBounds(this.mSelectorBound);
            this.mSelectorDrawable.draw(canvas);
        }
    }

    private void drawShadows(Canvas canvas) {
        if (1 == getOrientation()) {
            drawShadowsHorizontal(canvas);
        } else {
            drawShadowsVertical(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        drawCenterRect(canvas);
        drawShadows(canvas);
    }

    @Override // com.baidu.searchbox.ui.wheelview2d.BdGallery
    public void setOrientation(int i) {
        if (1 == i) {
            return;
        }
        super.setOrientation(i);
    }

    public void setSelectorDrawable(Drawable drawable) {
        if (this.mSelectorDrawable != drawable) {
            this.mSelectorDrawable = drawable;
            invalidate();
        }
    }

    public void setSelectorDrawableHeight(int i) {
        this.mSelectorHeight = i;
    }

    public void setShadowDrawableHeight(int i) {
        this.mShadowHeight = i;
    }

    public WheelView2d(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSelectorDrawable = null;
        this.mSelectorBound = new Rect();
        this.mTopShadow = null;
        this.mBottomShadow = null;
        this.mSelectorHeight = -1;
        initialize(context);
    }

    public void setShadowDrawable(Drawable drawable, Drawable drawable2) {
        this.mTopShadow = drawable;
        this.mBottomShadow = drawable2;
        invalidate();
    }

    public WheelView2d(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSelectorDrawable = null;
        this.mSelectorBound = new Rect();
        this.mTopShadow = null;
        this.mBottomShadow = null;
        this.mSelectorHeight = -1;
        initialize(context);
    }

    private void drawShadowsVertical(Canvas canvas) {
        if (this.mShadowHeight <= 0) {
            int height = (int) (this.mSelectorBound.height() * 2.0d);
            this.mShadowHeight = height;
            this.mShadowHeight = Math.min(height, this.mSelectorBound.top);
        }
        int i = this.mShadowHeight;
        Drawable drawable = this.mTopShadow;
        if (drawable != null) {
            drawable.setBounds(0, 0, getWidth(), i);
            this.mTopShadow.draw(canvas);
        }
        Drawable drawable2 = this.mBottomShadow;
        if (drawable2 != null) {
            drawable2.setBounds(0, getHeight() - i, getWidth(), getHeight());
            this.mBottomShadow.draw(canvas);
        }
    }

    private void initialize(Context context) {
        setVerticalScrollBarEnabled(false);
        setSlotInCenter(true);
        setOrientation(2);
        setGravity(1);
        setUnselectedAlpha(1.0f);
        setWillNotDraw(false);
        this.mSelectorDrawable = getContext().getResources().getDrawable(R.drawable.obfuscated_res_0x7f080265);
        if (NightModeHelper.getNightModeSwitcherState()) {
            this.mTopShadow = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, SHADOWS_COLORS_NIGHT);
            this.mBottomShadow = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, SHADOWS_COLORS_NIGHT);
        } else {
            this.mTopShadow = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, SHADOWS_COLORS);
            this.mBottomShadow = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, SHADOWS_COLORS);
        }
        setSoundEffectsEnabled(false);
        this.mDefSelectorSize = DeviceUtil.ScreenInfo.dp2px(getContext(), 50.0f);
    }

    @Override // com.baidu.searchbox.ui.wheelview2d.BdGallery, com.baidu.searchbox.ui.wheelview2d.BdAdapterView, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (1 == getOrientation()) {
            calcSelectorBoundHorizontal();
        } else {
            calcSelectorBoundVertical();
        }
    }
}
