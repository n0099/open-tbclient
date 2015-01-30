package com.baidu.adp.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import com.baidu.adp.R;
/* loaded from: classes.dex */
public class IndicatorView extends View {
    private int mCount;
    private float mPosition;
    private boolean vF;
    private int vG;
    private float vH;
    private Drawable vI;
    private Drawable vJ;
    private final ab vK;

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [com.baidu.adp.widget.m.measure(int, int):void] */
    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(IndicatorView indicatorView, int i, int i2) {
        indicatorView.setMeasuredDimension(i, i2);
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [com.baidu.adp.widget.m.aB(int):int, com.baidu.adp.widget.m.draw(android.graphics.Canvas):void] */
    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int d(IndicatorView indicatorView) {
        return indicatorView.vG;
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [com.baidu.adp.widget.m.aB(int):int, com.baidu.adp.widget.m.draw(android.graphics.Canvas):void, com.baidu.adp.widget.m.measure(int, int):void] */
    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int c(IndicatorView indicatorView) {
        return indicatorView.mCount;
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [com.baidu.adp.widget.m.iT():void] */
    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(IndicatorView indicatorView, float f) {
        indicatorView.mPosition = f;
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [com.baidu.adp.widget.m.draw(android.graphics.Canvas):void] */
    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ float e(IndicatorView indicatorView) {
        return indicatorView.mPosition;
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [com.baidu.adp.widget.m.iT():void] */
    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ float f(IndicatorView indicatorView) {
        return indicatorView.vH;
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [com.baidu.adp.widget.m.aB(int):int, com.baidu.adp.widget.m.aC(int):int, com.baidu.adp.widget.m.draw(android.graphics.Canvas):void, com.baidu.adp.widget.m.measure(int, int):void] */
    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Drawable a(IndicatorView indicatorView) {
        return indicatorView.vI;
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [com.baidu.adp.widget.m.aB(int):int, com.baidu.adp.widget.m.aC(int):int, com.baidu.adp.widget.m.draw(android.graphics.Canvas):void, com.baidu.adp.widget.m.measure(int, int):void] */
    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Drawable b(IndicatorView indicatorView) {
        return indicatorView.vJ;
    }

    public IndicatorView(Context context) {
        this(context, null, 0);
    }

    public IndicatorView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public IndicatorView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.vK = new m(this);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.IndicatorView);
        this.vG = obtainStyledAttributes.getDimensionPixelSize(0, (int) ((getResources().getDisplayMetrics().density * 5.0f) + 0.5f));
        this.mCount = obtainStyledAttributes.getInteger(4, 0);
        this.vI = obtainStyledAttributes.getDrawable(1);
        if (this.vI == null) {
            Log.d("IndicatorView$IndicatorView", "Drawable not defined in xml");
        } else {
            this.vI.setBounds(0, 0, this.vI.getIntrinsicWidth(), this.vI.getIntrinsicHeight());
            Log.d("IndicatorView$IndicatorView", "Drawable bounds=" + this.vI.getBounds());
        }
        this.vJ = obtainStyledAttributes.getDrawable(2);
        if (this.vJ == null) {
            Log.d("IndicatorView$IndicatorView", "Selector not defined in xml");
        } else {
            this.vJ.setBounds(0, 0, this.vJ.getIntrinsicWidth(), this.vJ.getIntrinsicHeight());
            Log.d("IndicatorView$IndicatorView", "Selector bound=" + this.vJ.getBounds());
        }
        this.vF = obtainStyledAttributes.getBoolean(3, false);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        this.vK.measure(i, i2);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        this.vK.draw(canvas);
    }

    public void setAutoHide(boolean z) {
        this.vF = z;
    }

    public void setDrawable(Drawable drawable) {
        this.vI = drawable;
        requestLayout();
        invalidate();
    }

    public Drawable getDrawable() {
        return this.vI;
    }

    public void setSelector(Drawable drawable) {
        this.vJ = drawable;
        requestLayout();
        invalidate();
    }

    public Drawable getSelector() {
        return this.vJ;
    }

    public void setSpacing(int i) {
        this.vG = i;
        requestLayout();
        invalidate();
    }

    public int getSpacing() {
        return this.vG;
    }

    public int getCount() {
        return this.mCount;
    }

    public void setCount(int i) {
        this.mCount = i;
        requestLayout();
        invalidate();
    }

    public void setPosition(float f) {
        Log.d("IndicatorView$IndicatorView", "@setPosition");
        this.mPosition = f;
        invalidate();
    }

    public float getPosition() {
        return this.mPosition;
    }
}
