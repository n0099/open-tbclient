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
    private int mq;
    private boolean tp;
    private int tq;
    private float tr;
    private float ts;
    private Drawable tt;
    private Drawable tu;
    private final ab tv;

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [com.baidu.adp.widget.m.measure(int, int):void] */
    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(IndicatorView indicatorView, int i, int i2) {
        indicatorView.setMeasuredDimension(i, i2);
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [com.baidu.adp.widget.m.ag(int):int, com.baidu.adp.widget.m.draw(android.graphics.Canvas):void] */
    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int d(IndicatorView indicatorView) {
        return indicatorView.tq;
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [com.baidu.adp.widget.m.ag(int):int, com.baidu.adp.widget.m.draw(android.graphics.Canvas):void, com.baidu.adp.widget.m.measure(int, int):void] */
    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int c(IndicatorView indicatorView) {
        return indicatorView.mq;
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [com.baidu.adp.widget.m.gV():void] */
    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(IndicatorView indicatorView, float f) {
        indicatorView.tr = f;
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [com.baidu.adp.widget.m.draw(android.graphics.Canvas):void] */
    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ float e(IndicatorView indicatorView) {
        return indicatorView.tr;
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [com.baidu.adp.widget.m.gV():void] */
    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ float f(IndicatorView indicatorView) {
        return indicatorView.ts;
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [com.baidu.adp.widget.m.ag(int):int, com.baidu.adp.widget.m.ah(int):int, com.baidu.adp.widget.m.draw(android.graphics.Canvas):void, com.baidu.adp.widget.m.measure(int, int):void] */
    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Drawable a(IndicatorView indicatorView) {
        return indicatorView.tt;
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [com.baidu.adp.widget.m.ag(int):int, com.baidu.adp.widget.m.ah(int):int, com.baidu.adp.widget.m.draw(android.graphics.Canvas):void, com.baidu.adp.widget.m.measure(int, int):void] */
    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Drawable b(IndicatorView indicatorView) {
        return indicatorView.tu;
    }

    public IndicatorView(Context context) {
        this(context, null, 0);
    }

    public IndicatorView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public IndicatorView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.tv = new m(this);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.IndicatorView);
        this.tq = obtainStyledAttributes.getDimensionPixelSize(0, (int) ((getResources().getDisplayMetrics().density * 5.0f) + 0.5f));
        this.mq = obtainStyledAttributes.getInteger(4, 0);
        this.tt = obtainStyledAttributes.getDrawable(1);
        if (this.tt == null) {
            Log.d("IndicatorView$IndicatorView", "Drawable not defined in xml");
        } else {
            this.tt.setBounds(0, 0, this.tt.getIntrinsicWidth(), this.tt.getIntrinsicHeight());
            Log.d("IndicatorView$IndicatorView", "Drawable bounds=" + this.tt.getBounds());
        }
        this.tu = obtainStyledAttributes.getDrawable(2);
        if (this.tu == null) {
            Log.d("IndicatorView$IndicatorView", "Selector not defined in xml");
        } else {
            this.tu.setBounds(0, 0, this.tu.getIntrinsicWidth(), this.tu.getIntrinsicHeight());
            Log.d("IndicatorView$IndicatorView", "Selector bound=" + this.tu.getBounds());
        }
        this.tp = obtainStyledAttributes.getBoolean(3, false);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        this.tv.measure(i, i2);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        this.tv.draw(canvas);
    }

    public void setAutoHide(boolean z) {
        this.tp = z;
    }

    public void setDrawable(Drawable drawable) {
        this.tt = drawable;
        requestLayout();
        invalidate();
    }

    public Drawable getDrawable() {
        return this.tt;
    }

    public void setSelector(Drawable drawable) {
        this.tu = drawable;
        requestLayout();
        invalidate();
    }

    public Drawable getSelector() {
        return this.tu;
    }

    public void setSpacing(int i) {
        this.tq = i;
        requestLayout();
        invalidate();
    }

    public int getSpacing() {
        return this.tq;
    }

    public int getCount() {
        return this.mq;
    }

    public void setCount(int i) {
        this.mq = i;
        requestLayout();
        invalidate();
    }

    public void setPosition(float f) {
        Log.d("IndicatorView$IndicatorView", "@setPosition");
        this.tr = f;
        invalidate();
    }

    public float getPosition() {
        return this.tr;
    }
}
