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
    private boolean Gr;
    private int Gs;
    private float Gt;
    private Drawable Gu;
    private Drawable Gv;
    private final ae Gw;
    private int mCount;
    private float mPosition;

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [com.baidu.adp.widget.n.measure(int, int):void] */
    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(IndicatorView indicatorView, int i, int i2) {
        indicatorView.setMeasuredDimension(i, i2);
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [com.baidu.adp.widget.n.aw(int):int, com.baidu.adp.widget.n.draw(android.graphics.Canvas):void] */
    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int d(IndicatorView indicatorView) {
        return indicatorView.Gs;
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [com.baidu.adp.widget.n.aw(int):int, com.baidu.adp.widget.n.draw(android.graphics.Canvas):void, com.baidu.adp.widget.n.measure(int, int):void] */
    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int c(IndicatorView indicatorView) {
        return indicatorView.mCount;
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [com.baidu.adp.widget.n.mC():void] */
    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(IndicatorView indicatorView, float f) {
        indicatorView.mPosition = f;
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [com.baidu.adp.widget.n.draw(android.graphics.Canvas):void] */
    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ float e(IndicatorView indicatorView) {
        return indicatorView.mPosition;
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [com.baidu.adp.widget.n.mC():void] */
    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ float f(IndicatorView indicatorView) {
        return indicatorView.Gt;
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [com.baidu.adp.widget.n.aw(int):int, com.baidu.adp.widget.n.ax(int):int, com.baidu.adp.widget.n.draw(android.graphics.Canvas):void, com.baidu.adp.widget.n.measure(int, int):void] */
    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Drawable a(IndicatorView indicatorView) {
        return indicatorView.Gu;
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [com.baidu.adp.widget.n.aw(int):int, com.baidu.adp.widget.n.ax(int):int, com.baidu.adp.widget.n.draw(android.graphics.Canvas):void, com.baidu.adp.widget.n.measure(int, int):void] */
    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Drawable b(IndicatorView indicatorView) {
        return indicatorView.Gv;
    }

    public IndicatorView(Context context) {
        this(context, null, 0);
    }

    public IndicatorView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public IndicatorView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Gw = new n(this);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.IndicatorView);
        this.Gs = obtainStyledAttributes.getDimensionPixelSize(0, (int) ((getResources().getDisplayMetrics().density * 5.0f) + 0.5f));
        this.mCount = obtainStyledAttributes.getInteger(4, 0);
        this.Gu = obtainStyledAttributes.getDrawable(1);
        if (this.Gu == null) {
            Log.d("IndicatorView$IndicatorView", "Drawable not defined in xml");
        } else {
            this.Gu.setBounds(0, 0, this.Gu.getIntrinsicWidth(), this.Gu.getIntrinsicHeight());
            Log.d("IndicatorView$IndicatorView", "Drawable bounds=" + this.Gu.getBounds());
        }
        this.Gv = obtainStyledAttributes.getDrawable(2);
        if (this.Gv == null) {
            Log.d("IndicatorView$IndicatorView", "Selector not defined in xml");
        } else {
            this.Gv.setBounds(0, 0, this.Gv.getIntrinsicWidth(), this.Gv.getIntrinsicHeight());
            Log.d("IndicatorView$IndicatorView", "Selector bound=" + this.Gv.getBounds());
        }
        this.Gr = obtainStyledAttributes.getBoolean(3, false);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        this.Gw.measure(i, i2);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        this.Gw.draw(canvas);
    }

    public void setAutoHide(boolean z) {
        this.Gr = z;
    }

    public void setDrawable(Drawable drawable) {
        this.Gu = drawable;
        requestLayout();
        invalidate();
    }

    public Drawable getDrawable() {
        return this.Gu;
    }

    public void setSelector(Drawable drawable) {
        this.Gv = drawable;
        requestLayout();
        invalidate();
    }

    public Drawable getSelector() {
        return this.Gv;
    }

    public void setSpacing(int i) {
        this.Gs = i;
        requestLayout();
        invalidate();
    }

    public int getSpacing() {
        return this.Gs;
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
