package com.baidu.swan.apps.res.ui.wheelview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.an.x;
/* loaded from: classes2.dex */
public class WheelView extends BdGallery {
    private static final int[] aKS = {-1, -1140850689, ViewCompat.MEASURED_SIZE_MASK};
    private static final int[] aKT = {-15132391, -1155983079, 1644825};
    private Drawable aKU;
    private Rect aKV;
    private Drawable aKW;
    private Drawable aKX;
    private int aKY;
    private int mShadowHeight;

    public WheelView(Context context) {
        super(context);
        this.aKU = null;
        this.aKV = new Rect();
        this.aKW = null;
        this.aKX = null;
        initialize(context);
    }

    public WheelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aKU = null;
        this.aKV = new Rect();
        this.aKW = null;
        this.aKX = null;
        initialize(context);
    }

    public WheelView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aKU = null;
        this.aKV = new Rect();
        this.aKW = null;
        this.aKX = null;
        initialize(context);
    }

    private void initialize(Context context) {
        setVerticalScrollBarEnabled(false);
        setSlotInCenter(true);
        setOrientation(2);
        setGravity(1);
        setUnselectedAlpha(1.0f);
        setWillNotDraw(false);
        this.aKU = getContext().getResources().getDrawable(a.e.aiapps_wheel_val);
        if (com.baidu.swan.apps.u.a.CR().Dq()) {
            this.aKW = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, aKT);
            this.aKX = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, aKT);
        } else {
            this.aKW = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, aKS);
            this.aKX = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, aKS);
        }
        setSoundEffectsEnabled(false);
        this.aKY = x.dip2px(getContext(), 50.0f);
    }

    public void setSelectorDrawable(Drawable drawable) {
        if (this.aKU != drawable) {
            this.aKU = drawable;
            invalidate();
        }
    }

    public void setShadowDrawable(Drawable drawable, Drawable drawable2) {
        this.aKW = drawable;
        this.aKX = drawable2;
        invalidate();
    }

    public void setShadowDrawableHeight(int i) {
        this.mShadowHeight = i;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        s(canvas);
        t(canvas);
    }

    @Override // com.baidu.swan.apps.res.ui.wheelview.BdGallery
    public void setOrientation(int i) {
        if (1 == i) {
            throw new IllegalArgumentException("The orientation must be VERTICAL");
        }
        super.setOrientation(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.res.ui.wheelview.BdGallery, com.baidu.swan.apps.res.ui.wheelview.BdAdapterView, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (1 == getOrientation()) {
            Ih();
        } else {
            Ii();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.res.ui.wheelview.BdGallery, com.baidu.swan.apps.res.ui.wheelview.BdAdapterView
    public void selectionChanged() {
        super.selectionChanged();
        playSoundEffect(0);
    }

    private void s(Canvas canvas) {
        if (this.aKV != null && !this.aKV.isEmpty() && this.aKU != null) {
            this.aKU.setBounds(this.aKV);
            this.aKU.draw(canvas);
        }
    }

    private void t(Canvas canvas) {
        if (1 == getOrientation()) {
            u(canvas);
        } else {
            v(canvas);
        }
    }

    private void u(Canvas canvas) {
    }

    private void v(Canvas canvas) {
        if (this.mShadowHeight <= 0) {
            this.mShadowHeight = (int) (2.0d * this.aKV.height());
            this.mShadowHeight = Math.min(this.mShadowHeight, this.aKV.top);
        }
        int i = this.mShadowHeight;
        if (this.aKW != null) {
            this.aKW.setBounds(0, 0, getWidth(), i);
            this.aKW.draw(canvas);
        }
        if (this.aKX != null) {
            this.aKX.setBounds(0, getHeight() - i, getWidth(), getHeight());
            this.aKX.draw(canvas);
        }
    }

    private void Ih() {
        int centerOfGallery = getCenterOfGallery();
        View childAt = getChildAt(0);
        int measuredWidth = childAt != null ? childAt.getMeasuredWidth() : this.aKY;
        int i = centerOfGallery - (measuredWidth / 2);
        this.aKV.set(i, getPaddingTop(), measuredWidth + i, getHeight() - getPaddingBottom());
    }

    private void Ii() {
        int centerOfGallery = getCenterOfGallery();
        View childAt = getChildAt(0);
        int measuredHeight = childAt != null ? childAt.getMeasuredHeight() : this.aKY;
        int i = centerOfGallery - (measuredHeight / 2);
        this.aKV.set(getPaddingLeft(), i, getWidth() - getPaddingRight(), measuredHeight + i);
    }
}
