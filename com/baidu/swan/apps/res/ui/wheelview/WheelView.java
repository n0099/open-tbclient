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
    private static final int[] bgI = {-1, -1140850689, ViewCompat.MEASURED_SIZE_MASK};
    private static final int[] bgJ = {-15132391, -1155983079, 1644825};
    private int ahG;
    private Drawable bgK;
    private Rect bgL;
    private Drawable bgM;
    private Drawable bgN;
    private int bgO;

    public WheelView(Context context) {
        super(context);
        this.bgK = null;
        this.bgL = new Rect();
        this.bgM = null;
        this.bgN = null;
        initialize(context);
    }

    public WheelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bgK = null;
        this.bgL = new Rect();
        this.bgM = null;
        this.bgN = null;
        initialize(context);
    }

    public WheelView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bgK = null;
        this.bgL = new Rect();
        this.bgM = null;
        this.bgN = null;
        initialize(context);
    }

    private void initialize(Context context) {
        setVerticalScrollBarEnabled(false);
        setSlotInCenter(true);
        setOrientation(2);
        setGravity(1);
        setUnselectedAlpha(1.0f);
        setWillNotDraw(false);
        this.bgK = getContext().getResources().getDrawable(a.e.aiapps_wheel_val);
        if (com.baidu.swan.apps.u.a.JE().Kd()) {
            this.bgM = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, bgJ);
            this.bgN = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, bgJ);
        } else {
            this.bgM = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, bgI);
            this.bgN = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, bgI);
        }
        setSoundEffectsEnabled(false);
        this.bgO = z.dip2px(getContext(), 50.0f);
    }

    public void setSelectorDrawable(Drawable drawable) {
        if (this.bgK != drawable) {
            this.bgK = drawable;
            invalidate();
        }
    }

    public void setShadowDrawable(Drawable drawable, Drawable drawable2) {
        this.bgM = drawable;
        this.bgN = drawable2;
        invalidate();
    }

    public void setShadowDrawableHeight(int i) {
        this.ahG = i;
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
            Qi();
        } else {
            Qj();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.res.ui.wheelview.BdGallery, com.baidu.swan.apps.res.ui.wheelview.BdAdapterView
    public void selectionChanged() {
        super.selectionChanged();
        playSoundEffect(0);
    }

    private void w(Canvas canvas) {
        if (this.bgL != null && !this.bgL.isEmpty() && this.bgK != null) {
            this.bgK.setBounds(this.bgL);
            this.bgK.draw(canvas);
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
        if (this.ahG <= 0) {
            this.ahG = (int) (2.0d * this.bgL.height());
            this.ahG = Math.min(this.ahG, this.bgL.top);
        }
        int i = this.ahG;
        if (this.bgM != null) {
            this.bgM.setBounds(0, 0, getWidth(), i);
            this.bgM.draw(canvas);
        }
        if (this.bgN != null) {
            this.bgN.setBounds(0, getHeight() - i, getWidth(), getHeight());
            this.bgN.draw(canvas);
        }
    }

    private void Qi() {
        int centerOfGallery = getCenterOfGallery();
        View childAt = getChildAt(0);
        int measuredWidth = childAt != null ? childAt.getMeasuredWidth() : this.bgO;
        int i = centerOfGallery - (measuredWidth / 2);
        this.bgL.set(i, getPaddingTop(), measuredWidth + i, getHeight() - getPaddingBottom());
    }

    private void Qj() {
        int centerOfGallery = getCenterOfGallery();
        View childAt = getChildAt(0);
        int measuredHeight = childAt != null ? childAt.getMeasuredHeight() : this.bgO;
        int i = centerOfGallery - (measuredHeight / 2);
        this.bgL.set(getPaddingLeft(), i, getWidth() - getPaddingRight(), measuredHeight + i);
    }
}
