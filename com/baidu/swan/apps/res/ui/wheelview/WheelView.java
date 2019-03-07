package com.baidu.swan.apps.res.ui.wheelview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.swan.apps.an.x;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.u.a;
/* loaded from: classes2.dex */
public class WheelView extends BdGallery {
    private static final int[] aKN = {-1, -1140850689, ViewCompat.MEASURED_SIZE_MASK};
    private static final int[] aKO = {-15132391, -1155983079, 1644825};
    private Drawable aKP;
    private Rect aKQ;
    private Drawable aKR;
    private Drawable aKS;
    private int aKT;
    private int mShadowHeight;

    public WheelView(Context context) {
        super(context);
        this.aKP = null;
        this.aKQ = new Rect();
        this.aKR = null;
        this.aKS = null;
        initialize(context);
    }

    public WheelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aKP = null;
        this.aKQ = new Rect();
        this.aKR = null;
        this.aKS = null;
        initialize(context);
    }

    public WheelView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aKP = null;
        this.aKQ = new Rect();
        this.aKR = null;
        this.aKS = null;
        initialize(context);
    }

    private void initialize(Context context) {
        setVerticalScrollBarEnabled(false);
        setSlotInCenter(true);
        setOrientation(2);
        setGravity(1);
        setUnselectedAlpha(1.0f);
        setWillNotDraw(false);
        this.aKP = getContext().getResources().getDrawable(b.e.aiapps_wheel_val);
        if (a.CT().Ds()) {
            this.aKR = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, aKO);
            this.aKS = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, aKO);
        } else {
            this.aKR = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, aKN);
            this.aKS = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, aKN);
        }
        setSoundEffectsEnabled(false);
        this.aKT = x.dip2px(getContext(), 50.0f);
    }

    public void setSelectorDrawable(Drawable drawable) {
        if (this.aKP != drawable) {
            this.aKP = drawable;
            invalidate();
        }
    }

    public void setShadowDrawable(Drawable drawable, Drawable drawable2) {
        this.aKR = drawable;
        this.aKS = drawable2;
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
        if (this.aKQ != null && !this.aKQ.isEmpty() && this.aKP != null) {
            this.aKP.setBounds(this.aKQ);
            this.aKP.draw(canvas);
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
            this.mShadowHeight = (int) (2.0d * this.aKQ.height());
            this.mShadowHeight = Math.min(this.mShadowHeight, this.aKQ.top);
        }
        int i = this.mShadowHeight;
        if (this.aKR != null) {
            this.aKR.setBounds(0, 0, getWidth(), i);
            this.aKR.draw(canvas);
        }
        if (this.aKS != null) {
            this.aKS.setBounds(0, getHeight() - i, getWidth(), getHeight());
            this.aKS.draw(canvas);
        }
    }

    private void Ij() {
        int centerOfGallery = getCenterOfGallery();
        View childAt = getChildAt(0);
        int measuredWidth = childAt != null ? childAt.getMeasuredWidth() : this.aKT;
        int i = centerOfGallery - (measuredWidth / 2);
        this.aKQ.set(i, getPaddingTop(), measuredWidth + i, getHeight() - getPaddingBottom());
    }

    private void Ik() {
        int centerOfGallery = getCenterOfGallery();
        View childAt = getChildAt(0);
        int measuredHeight = childAt != null ? childAt.getMeasuredHeight() : this.aKT;
        int i = centerOfGallery - (measuredHeight / 2);
        this.aKQ.set(getPaddingLeft(), i, getWidth() - getPaddingRight(), measuredHeight + i);
    }
}
