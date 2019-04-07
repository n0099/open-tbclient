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
    private static final int[] aKR = {-1, -1140850689, ViewCompat.MEASURED_SIZE_MASK};
    private static final int[] aKS = {-15132391, -1155983079, 1644825};
    private Drawable aKT;
    private Rect aKU;
    private Drawable aKV;
    private Drawable aKW;
    private int aKX;
    private int mShadowHeight;

    public WheelView(Context context) {
        super(context);
        this.aKT = null;
        this.aKU = new Rect();
        this.aKV = null;
        this.aKW = null;
        initialize(context);
    }

    public WheelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aKT = null;
        this.aKU = new Rect();
        this.aKV = null;
        this.aKW = null;
        initialize(context);
    }

    public WheelView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aKT = null;
        this.aKU = new Rect();
        this.aKV = null;
        this.aKW = null;
        initialize(context);
    }

    private void initialize(Context context) {
        setVerticalScrollBarEnabled(false);
        setSlotInCenter(true);
        setOrientation(2);
        setGravity(1);
        setUnselectedAlpha(1.0f);
        setWillNotDraw(false);
        this.aKT = getContext().getResources().getDrawable(a.e.aiapps_wheel_val);
        if (com.baidu.swan.apps.u.a.CR().Dq()) {
            this.aKV = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, aKS);
            this.aKW = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, aKS);
        } else {
            this.aKV = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, aKR);
            this.aKW = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, aKR);
        }
        setSoundEffectsEnabled(false);
        this.aKX = x.dip2px(getContext(), 50.0f);
    }

    public void setSelectorDrawable(Drawable drawable) {
        if (this.aKT != drawable) {
            this.aKT = drawable;
            invalidate();
        }
    }

    public void setShadowDrawable(Drawable drawable, Drawable drawable2) {
        this.aKV = drawable;
        this.aKW = drawable2;
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
        if (this.aKU != null && !this.aKU.isEmpty() && this.aKT != null) {
            this.aKT.setBounds(this.aKU);
            this.aKT.draw(canvas);
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
            this.mShadowHeight = (int) (2.0d * this.aKU.height());
            this.mShadowHeight = Math.min(this.mShadowHeight, this.aKU.top);
        }
        int i = this.mShadowHeight;
        if (this.aKV != null) {
            this.aKV.setBounds(0, 0, getWidth(), i);
            this.aKV.draw(canvas);
        }
        if (this.aKW != null) {
            this.aKW.setBounds(0, getHeight() - i, getWidth(), getHeight());
            this.aKW.draw(canvas);
        }
    }

    private void Ih() {
        int centerOfGallery = getCenterOfGallery();
        View childAt = getChildAt(0);
        int measuredWidth = childAt != null ? childAt.getMeasuredWidth() : this.aKX;
        int i = centerOfGallery - (measuredWidth / 2);
        this.aKU.set(i, getPaddingTop(), measuredWidth + i, getHeight() - getPaddingBottom());
    }

    private void Ii() {
        int centerOfGallery = getCenterOfGallery();
        View childAt = getChildAt(0);
        int measuredHeight = childAt != null ? childAt.getMeasuredHeight() : this.aKX;
        int i = centerOfGallery - (measuredHeight / 2);
        this.aKU.set(getPaddingLeft(), i, getWidth() - getPaddingRight(), measuredHeight + i);
    }
}
