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
    private static final int[] aKO = {-1, -1140850689, ViewCompat.MEASURED_SIZE_MASK};
    private static final int[] aKP = {-15132391, -1155983079, 1644825};
    private Drawable aKQ;
    private Rect aKR;
    private Drawable aKS;
    private Drawable aKT;
    private int aKU;
    private int mShadowHeight;

    public WheelView(Context context) {
        super(context);
        this.aKQ = null;
        this.aKR = new Rect();
        this.aKS = null;
        this.aKT = null;
        initialize(context);
    }

    public WheelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aKQ = null;
        this.aKR = new Rect();
        this.aKS = null;
        this.aKT = null;
        initialize(context);
    }

    public WheelView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aKQ = null;
        this.aKR = new Rect();
        this.aKS = null;
        this.aKT = null;
        initialize(context);
    }

    private void initialize(Context context) {
        setVerticalScrollBarEnabled(false);
        setSlotInCenter(true);
        setOrientation(2);
        setGravity(1);
        setUnselectedAlpha(1.0f);
        setWillNotDraw(false);
        this.aKQ = getContext().getResources().getDrawable(a.e.aiapps_wheel_val);
        if (com.baidu.swan.apps.u.a.CT().Ds()) {
            this.aKS = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, aKP);
            this.aKT = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, aKP);
        } else {
            this.aKS = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, aKO);
            this.aKT = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, aKO);
        }
        setSoundEffectsEnabled(false);
        this.aKU = x.dip2px(getContext(), 50.0f);
    }

    public void setSelectorDrawable(Drawable drawable) {
        if (this.aKQ != drawable) {
            this.aKQ = drawable;
            invalidate();
        }
    }

    public void setShadowDrawable(Drawable drawable, Drawable drawable2) {
        this.aKS = drawable;
        this.aKT = drawable2;
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
            Ij();
        } else {
            Ik();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.res.ui.wheelview.BdGallery, com.baidu.swan.apps.res.ui.wheelview.BdAdapterView
    public void selectionChanged() {
        super.selectionChanged();
        playSoundEffect(0);
    }

    private void s(Canvas canvas) {
        if (this.aKR != null && !this.aKR.isEmpty() && this.aKQ != null) {
            this.aKQ.setBounds(this.aKR);
            this.aKQ.draw(canvas);
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
            this.mShadowHeight = (int) (2.0d * this.aKR.height());
            this.mShadowHeight = Math.min(this.mShadowHeight, this.aKR.top);
        }
        int i = this.mShadowHeight;
        if (this.aKS != null) {
            this.aKS.setBounds(0, 0, getWidth(), i);
            this.aKS.draw(canvas);
        }
        if (this.aKT != null) {
            this.aKT.setBounds(0, getHeight() - i, getWidth(), getHeight());
            this.aKT.draw(canvas);
        }
    }

    private void Ij() {
        int centerOfGallery = getCenterOfGallery();
        View childAt = getChildAt(0);
        int measuredWidth = childAt != null ? childAt.getMeasuredWidth() : this.aKU;
        int i = centerOfGallery - (measuredWidth / 2);
        this.aKR.set(i, getPaddingTop(), measuredWidth + i, getHeight() - getPaddingBottom());
    }

    private void Ik() {
        int centerOfGallery = getCenterOfGallery();
        View childAt = getChildAt(0);
        int measuredHeight = childAt != null ? childAt.getMeasuredHeight() : this.aKU;
        int i = centerOfGallery - (measuredHeight / 2);
        this.aKR.set(getPaddingLeft(), i, getWidth() - getPaddingRight(), measuredHeight + i);
    }
}
