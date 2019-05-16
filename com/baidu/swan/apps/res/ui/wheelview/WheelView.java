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
import com.baidu.swan.apps.an.z;
/* loaded from: classes2.dex */
public class WheelView extends BdGallery {
    private static final int[] aML = {-1, -1140850689, ViewCompat.MEASURED_SIZE_MASK};
    private static final int[] aMM = {-15132391, -1155983079, 1644825};
    private Drawable aMN;
    private Rect aMO;
    private Drawable aMP;
    private Drawable aMQ;
    private int aMR;
    private int mShadowHeight;

    public WheelView(Context context) {
        super(context);
        this.aMN = null;
        this.aMO = new Rect();
        this.aMP = null;
        this.aMQ = null;
        initialize(context);
    }

    public WheelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aMN = null;
        this.aMO = new Rect();
        this.aMP = null;
        this.aMQ = null;
        initialize(context);
    }

    public WheelView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aMN = null;
        this.aMO = new Rect();
        this.aMP = null;
        this.aMQ = null;
        initialize(context);
    }

    private void initialize(Context context) {
        setVerticalScrollBarEnabled(false);
        setSlotInCenter(true);
        setOrientation(2);
        setGravity(1);
        setUnselectedAlpha(1.0f);
        setWillNotDraw(false);
        this.aMN = getContext().getResources().getDrawable(a.e.aiapps_wheel_val);
        if (com.baidu.swan.apps.u.a.DW().Ev()) {
            this.aMP = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, aMM);
            this.aMQ = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, aMM);
        } else {
            this.aMP = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, aML);
            this.aMQ = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, aML);
        }
        setSoundEffectsEnabled(false);
        this.aMR = z.dip2px(getContext(), 50.0f);
    }

    public void setSelectorDrawable(Drawable drawable) {
        if (this.aMN != drawable) {
            this.aMN = drawable;
            invalidate();
        }
    }

    public void setShadowDrawable(Drawable drawable, Drawable drawable2) {
        this.aMP = drawable;
        this.aMQ = drawable2;
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
            Kx();
        } else {
            Ky();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.res.ui.wheelview.BdGallery, com.baidu.swan.apps.res.ui.wheelview.BdAdapterView
    public void selectionChanged() {
        super.selectionChanged();
        playSoundEffect(0);
    }

    private void s(Canvas canvas) {
        if (this.aMO != null && !this.aMO.isEmpty() && this.aMN != null) {
            this.aMN.setBounds(this.aMO);
            this.aMN.draw(canvas);
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
            this.mShadowHeight = (int) (2.0d * this.aMO.height());
            this.mShadowHeight = Math.min(this.mShadowHeight, this.aMO.top);
        }
        int i = this.mShadowHeight;
        if (this.aMP != null) {
            this.aMP.setBounds(0, 0, getWidth(), i);
            this.aMP.draw(canvas);
        }
        if (this.aMQ != null) {
            this.aMQ.setBounds(0, getHeight() - i, getWidth(), getHeight());
            this.aMQ.draw(canvas);
        }
    }

    private void Kx() {
        int centerOfGallery = getCenterOfGallery();
        View childAt = getChildAt(0);
        int measuredWidth = childAt != null ? childAt.getMeasuredWidth() : this.aMR;
        int i = centerOfGallery - (measuredWidth / 2);
        this.aMO.set(i, getPaddingTop(), measuredWidth + i, getHeight() - getPaddingBottom());
    }

    private void Ky() {
        int centerOfGallery = getCenterOfGallery();
        View childAt = getChildAt(0);
        int measuredHeight = childAt != null ? childAt.getMeasuredHeight() : this.aMR;
        int i = centerOfGallery - (measuredHeight / 2);
        this.aMO.set(getPaddingLeft(), i, getWidth() - getPaddingRight(), measuredHeight + i);
    }
}
