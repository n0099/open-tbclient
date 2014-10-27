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
    private Rect dZ;
    private Paint gs;
    private Matrix mMatrix;

    public FragmentTabRootView(Context context) {
        super(context);
        this.mMatrix = new Matrix();
        this.gs = new Paint(6);
        this.dZ = new Rect();
        init();
    }

    public FragmentTabRootView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMatrix = new Matrix();
        this.gs = new Paint(6);
        this.dZ = new Rect();
        init();
    }

    private void init() {
        this.gs.setAntiAlias(true);
        this.gs.setStyle(Paint.Style.FILL);
        this.gs.setColor(-16777216);
        this.gs.setAlpha(0);
        setWillNotDraw(false);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.dZ.set(0, 0, i, i2);
    }

    public void a(float f, float f2, float f3, float f4, float f5, float f6, int i) {
        this.mMatrix.reset();
        this.mMatrix.postTranslate(f, f2);
        this.mMatrix.postScale(f3, f4, f5, f6);
        this.gs.setAlpha(i);
        postInvalidateDelayed(16L);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        canvas.save();
        canvas.concat(this.mMatrix);
        super.draw(canvas);
        canvas.drawRect(this.dZ, this.gs);
        canvas.restore();
    }
}
