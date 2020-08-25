package com.baidu.searchbox.ui.wheelview2d;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.android.common.ui.R;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.searchbox.skin.NightModeHelper;
/* loaded from: classes14.dex */
public class WheelView2d extends BdGallery {
    private static final int[] SHADOWS_COLORS = {-1, -1140850689, 16777215};
    private static final int[] SHADOWS_COLORS_NIGHT = {-15132391, -1155983079, 1644825};
    private Drawable mBottomShadow;
    private int mDefSelectorSize;
    private Rect mSelectorBound;
    private Drawable mSelectorDrawable;
    private int mShadowHeight;
    private Drawable mTopShadow;

    public WheelView2d(Context context) {
        super(context);
        this.mSelectorDrawable = null;
        this.mSelectorBound = new Rect();
        this.mTopShadow = null;
        this.mBottomShadow = null;
        initialize(context);
    }

    public WheelView2d(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSelectorDrawable = null;
        this.mSelectorBound = new Rect();
        this.mTopShadow = null;
        this.mBottomShadow = null;
        initialize(context);
    }

    public WheelView2d(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSelectorDrawable = null;
        this.mSelectorBound = new Rect();
        this.mTopShadow = null;
        this.mBottomShadow = null;
        initialize(context);
    }

    private void initialize(Context context) {
        setVerticalScrollBarEnabled(false);
        setSlotInCenter(true);
        setOrientation(2);
        setGravity(1);
        setUnselectedAlpha(1.0f);
        setWillNotDraw(false);
        this.mSelectorDrawable = getContext().getResources().getDrawable(R.drawable.bd_wheel_val);
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

    public void setSelectorDrawable(Drawable drawable) {
        if (this.mSelectorDrawable != drawable) {
            this.mSelectorDrawable = drawable;
            invalidate();
        }
    }

    public void setShadowDrawable(Drawable drawable, Drawable drawable2) {
        this.mTopShadow = drawable;
        this.mBottomShadow = drawable2;
        invalidate();
    }

    public void setShadowDrawableHeight(int i) {
        this.mShadowHeight = i;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        drawCenterRect(canvas);
        drawShadows(canvas);
    }

    @Override // com.baidu.searchbox.ui.wheelview2d.BdGallery
    public void setOrientation(int i) {
        if (1 == i) {
            throw new IllegalArgumentException("The orientation must be VERTICAL");
        }
        super.setOrientation(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.searchbox.ui.wheelview2d.BdGallery, com.baidu.searchbox.ui.wheelview2d.BdAdapterView, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (1 == getOrientation()) {
            calcSelectorBoundHorizontal();
        } else {
            calcSelectorBoundVertical();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.searchbox.ui.wheelview2d.BdGallery, com.baidu.searchbox.ui.wheelview2d.BdAdapterView
    public void selectionChanged() {
        super.selectionChanged();
        playSoundEffect(0);
    }

    private void drawCenterRect(Canvas canvas) {
        if (this.mSelectorBound != null && !this.mSelectorBound.isEmpty() && this.mSelectorDrawable != null) {
            this.mSelectorDrawable.setBounds(this.mSelectorBound);
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

    private void drawShadowsHorizontal(Canvas canvas) {
    }

    private void drawShadowsVertical(Canvas canvas) {
        if (this.mShadowHeight <= 0) {
            this.mShadowHeight = (int) (2.0d * this.mSelectorBound.height());
            this.mShadowHeight = Math.min(this.mShadowHeight, this.mSelectorBound.top);
        }
        int i = this.mShadowHeight;
        if (this.mTopShadow != null) {
            this.mTopShadow.setBounds(0, 0, getWidth(), i);
            this.mTopShadow.draw(canvas);
        }
        if (this.mBottomShadow != null) {
            this.mBottomShadow.setBounds(0, getHeight() - i, getWidth(), getHeight());
            this.mBottomShadow.draw(canvas);
        }
    }

    private void calcSelectorBoundHorizontal() {
        int centerOfGallery = getCenterOfGallery();
        View childAt = getChildAt(0);
        int measuredWidth = childAt != null ? childAt.getMeasuredWidth() : this.mDefSelectorSize;
        int i = centerOfGallery - (measuredWidth / 2);
        this.mSelectorBound.set(i, getPaddingTop(), measuredWidth + i, getHeight() - getPaddingBottom());
    }

    private void calcSelectorBoundVertical() {
        int centerOfGallery = getCenterOfGallery();
        View childAt = getChildAt(0);
        int measuredHeight = childAt != null ? childAt.getMeasuredHeight() : this.mDefSelectorSize;
        int i = centerOfGallery - (measuredHeight / 2);
        this.mSelectorBound.set(getPaddingLeft(), i, getWidth() - getPaddingRight(), measuredHeight + i);
    }
}
