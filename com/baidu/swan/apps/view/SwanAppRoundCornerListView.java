package com.baidu.swan.apps.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.widget.ListView;
import com.baidu.swan.apps.an.z;
/* loaded from: classes2.dex */
public class SwanAppRoundCornerListView extends ListView {
    private static final float buD = z.T(11.0f);
    private float[] asC;
    private final Path buE;
    private final RectF buF;
    private PorterDuffXfermode buG;
    private final Paint mPaint;

    public SwanAppRoundCornerListView(Context context) {
        super(context);
        this.buE = new Path();
        this.mPaint = new Paint(1);
        this.buF = new RectF();
        this.asC = new float[]{buD, buD, buD, buD, 0.0f, 0.0f, 0.0f, 0.0f};
    }

    public SwanAppRoundCornerListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.buE = new Path();
        this.mPaint = new Paint(1);
        this.buF = new RectF();
        this.asC = new float[]{buD, buD, buD, buD, 0.0f, 0.0f, 0.0f, 0.0f};
    }

    public SwanAppRoundCornerListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.buE = new Path();
        this.mPaint = new Paint(1);
        this.buF = new RectF();
        this.asC = new float[]{buD, buD, buD, buD, 0.0f, 0.0f, 0.0f, 0.0f};
    }

    public void setListViewRadius(float f, float f2, float f3, float f4) {
        setListViewRadius(new float[]{f, f, f2, f2, f3, f3, f4, f4});
    }

    public void setListViewRadius(@NonNull float[] fArr) {
        if (fArr.length < 8) {
            throw new ArrayIndexOutOfBoundsException("radii[] needs 8 values");
        }
        this.asC = new float[8];
        for (int i = 0; i < 8; i++) {
            this.asC[i] = fArr[i];
        }
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.buF.set(0.0f, 0.0f, i, i2 + 1);
        this.buE.reset();
        this.buE.addRoundRect(this.buF, this.asC, Path.Direction.CW);
        this.buG = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        canvas.save();
        this.mPaint.setColor(-1);
        this.mPaint.setXfermode(this.buG);
        canvas.drawPath(this.buE, this.mPaint);
        this.mPaint.setXfermode(null);
        canvas.restore();
    }
}
