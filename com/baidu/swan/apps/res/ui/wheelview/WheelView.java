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
    private static final int[] bha = {-1, -1140850689, ViewCompat.MEASURED_SIZE_MASK};
    private static final int[] bhb = {-15132391, -1155983079, 1644825};
    private int ahY;
    private Drawable bhc;
    private Rect bhd;
    private Drawable bhe;
    private Drawable bhf;
    private int bhg;

    public WheelView(Context context) {
        super(context);
        this.bhc = null;
        this.bhd = new Rect();
        this.bhe = null;
        this.bhf = null;
        initialize(context);
    }

    public WheelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bhc = null;
        this.bhd = new Rect();
        this.bhe = null;
        this.bhf = null;
        initialize(context);
    }

    public WheelView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bhc = null;
        this.bhd = new Rect();
        this.bhe = null;
        this.bhf = null;
        initialize(context);
    }

    private void initialize(Context context) {
        setVerticalScrollBarEnabled(false);
        setSlotInCenter(true);
        setOrientation(2);
        setGravity(1);
        setUnselectedAlpha(1.0f);
        setWillNotDraw(false);
        this.bhc = getContext().getResources().getDrawable(a.e.aiapps_wheel_val);
        if (com.baidu.swan.apps.u.a.JD().Kc()) {
            this.bhe = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, bhb);
            this.bhf = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, bhb);
        } else {
            this.bhe = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, bha);
            this.bhf = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, bha);
        }
        setSoundEffectsEnabled(false);
        this.bhg = z.dip2px(getContext(), 50.0f);
    }

    public void setSelectorDrawable(Drawable drawable) {
        if (this.bhc != drawable) {
            this.bhc = drawable;
            invalidate();
        }
    }

    public void setShadowDrawable(Drawable drawable, Drawable drawable2) {
        this.bhe = drawable;
        this.bhf = drawable2;
        invalidate();
    }

    public void setShadowDrawableHeight(int i) {
        this.ahY = i;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        w(canvas);
        x(canvas);
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
            Qh();
        } else {
            Qi();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.res.ui.wheelview.BdGallery, com.baidu.swan.apps.res.ui.wheelview.BdAdapterView
    public void selectionChanged() {
        super.selectionChanged();
        playSoundEffect(0);
    }

    private void w(Canvas canvas) {
        if (this.bhd != null && !this.bhd.isEmpty() && this.bhc != null) {
            this.bhc.setBounds(this.bhd);
            this.bhc.draw(canvas);
        }
    }

    private void x(Canvas canvas) {
        if (1 == getOrientation()) {
            y(canvas);
        } else {
            z(canvas);
        }
    }

    private void y(Canvas canvas) {
    }

    private void z(Canvas canvas) {
        if (this.ahY <= 0) {
            this.ahY = (int) (2.0d * this.bhd.height());
            this.ahY = Math.min(this.ahY, this.bhd.top);
        }
        int i = this.ahY;
        if (this.bhe != null) {
            this.bhe.setBounds(0, 0, getWidth(), i);
            this.bhe.draw(canvas);
        }
        if (this.bhf != null) {
            this.bhf.setBounds(0, getHeight() - i, getWidth(), getHeight());
            this.bhf.draw(canvas);
        }
    }

    private void Qh() {
        int centerOfGallery = getCenterOfGallery();
        View childAt = getChildAt(0);
        int measuredWidth = childAt != null ? childAt.getMeasuredWidth() : this.bhg;
        int i = centerOfGallery - (measuredWidth / 2);
        this.bhd.set(i, getPaddingTop(), measuredWidth + i, getHeight() - getPaddingBottom());
    }

    private void Qi() {
        int centerOfGallery = getCenterOfGallery();
        View childAt = getChildAt(0);
        int measuredHeight = childAt != null ? childAt.getMeasuredHeight() : this.bhg;
        int i = centerOfGallery - (measuredHeight / 2);
        this.bhd.set(getPaddingLeft(), i, getWidth() - getPaddingRight(), measuredHeight + i);
    }
}
