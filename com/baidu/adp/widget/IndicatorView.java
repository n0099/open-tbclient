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
    private int vA;
    private float vB;
    private Drawable vC;
    private Drawable vD;
    private final ab vE;
    private boolean vz;

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [com.baidu.adp.widget.m.measure(int, int):void] */
    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(IndicatorView indicatorView, int i, int i2) {
        indicatorView.setMeasuredDimension(i, i2);
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [com.baidu.adp.widget.m.aw(int):int, com.baidu.adp.widget.m.draw(android.graphics.Canvas):void] */
    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int d(IndicatorView indicatorView) {
        return indicatorView.vA;
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [com.baidu.adp.widget.m.aw(int):int, com.baidu.adp.widget.m.draw(android.graphics.Canvas):void, com.baidu.adp.widget.m.measure(int, int):void] */
    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int c(IndicatorView indicatorView) {
        return indicatorView.mCount;
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [com.baidu.adp.widget.m.iS():void] */
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
    /* JADX DEBUG: Method not inlined, still used in: [com.baidu.adp.widget.m.iS():void] */
    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ float f(IndicatorView indicatorView) {
        return indicatorView.vB;
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [com.baidu.adp.widget.m.aw(int):int, com.baidu.adp.widget.m.ax(int):int, com.baidu.adp.widget.m.draw(android.graphics.Canvas):void, com.baidu.adp.widget.m.measure(int, int):void] */
    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Drawable a(IndicatorView indicatorView) {
        return indicatorView.vC;
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [com.baidu.adp.widget.m.aw(int):int, com.baidu.adp.widget.m.ax(int):int, com.baidu.adp.widget.m.draw(android.graphics.Canvas):void, com.baidu.adp.widget.m.measure(int, int):void] */
    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Drawable b(IndicatorView indicatorView) {
        return indicatorView.vD;
    }

    public IndicatorView(Context context) {
        this(context, null, 0);
    }

    public IndicatorView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public IndicatorView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.vE = new m(this);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.IndicatorView);
        this.vA = obtainStyledAttributes.getDimensionPixelSize(0, (int) ((getResources().getDisplayMetrics().density * 5.0f) + 0.5f));
        this.mCount = obtainStyledAttributes.getInteger(4, 0);
        this.vC = obtainStyledAttributes.getDrawable(1);
        if (this.vC == null) {
            Log.d("IndicatorView$IndicatorView", "Drawable not defined in xml");
        } else {
            this.vC.setBounds(0, 0, this.vC.getIntrinsicWidth(), this.vC.getIntrinsicHeight());
            Log.d("IndicatorView$IndicatorView", "Drawable bounds=" + this.vC.getBounds());
        }
        this.vD = obtainStyledAttributes.getDrawable(2);
        if (this.vD == null) {
            Log.d("IndicatorView$IndicatorView", "Selector not defined in xml");
        } else {
            this.vD.setBounds(0, 0, this.vD.getIntrinsicWidth(), this.vD.getIntrinsicHeight());
            Log.d("IndicatorView$IndicatorView", "Selector bound=" + this.vD.getBounds());
        }
        this.vz = obtainStyledAttributes.getBoolean(3, false);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        this.vE.measure(i, i2);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        this.vE.draw(canvas);
    }

    public void setAutoHide(boolean z) {
        this.vz = z;
    }

    public void setDrawable(Drawable drawable) {
        this.vC = drawable;
        requestLayout();
        invalidate();
    }

    public Drawable getDrawable() {
        return this.vC;
    }

    public void setSelector(Drawable drawable) {
        this.vD = drawable;
        requestLayout();
        invalidate();
    }

    public Drawable getSelector() {
        return this.vD;
    }

    public void setSpacing(int i) {
        this.vA = i;
        requestLayout();
        invalidate();
    }

    public int getSpacing() {
        return this.vA;
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
