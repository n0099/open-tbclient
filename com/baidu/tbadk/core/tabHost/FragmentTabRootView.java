package com.baidu.tbadk.core.tabHost;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class FragmentTabRootView extends LinearLayout {
    private Matrix a;
    private Paint b;
    private Rect c;

    public FragmentTabRootView(Context context) {
        super(context);
        this.a = new Matrix();
        this.b = new Paint(6);
        this.c = new Rect();
        a();
    }

    public FragmentTabRootView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = new Matrix();
        this.b = new Paint(6);
        this.c = new Rect();
        a();
    }

    private void a() {
        this.b.setAntiAlias(true);
        this.b.setStyle(Paint.Style.FILL);
        this.b.setColor(-16777216);
        this.b.setAlpha(0);
        setWillNotDraw(false);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.c.set(0, 0, i, i2);
    }

    public void a(float f, float f2, float f3, float f4, float f5, float f6, int i) {
        this.a.reset();
        this.a.postTranslate(f, f2);
        this.a.postScale(f3, f4, f5, f6);
        this.b.setAlpha(i);
        postInvalidateDelayed(16L);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        canvas.save();
        canvas.concat(this.a);
        super.draw(canvas);
        canvas.drawRect(this.c, this.b);
        canvas.restore();
    }
}
