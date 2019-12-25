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
import com.baidu.swan.apps.as.af;
/* loaded from: classes9.dex */
public class SwanAppRoundCornerListView extends ListView {
    private static final float bVZ = af.U(11.0f);
    private float[] aAs;
    private final Path bWa;
    private final RectF bWb;
    private PorterDuffXfermode bWc;
    private final Paint mPaint;

    public SwanAppRoundCornerListView(Context context) {
        super(context);
        this.bWa = new Path();
        this.mPaint = new Paint(1);
        this.bWb = new RectF();
        this.aAs = new float[]{bVZ, bVZ, bVZ, bVZ, 0.0f, 0.0f, 0.0f, 0.0f};
    }

    public SwanAppRoundCornerListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bWa = new Path();
        this.mPaint = new Paint(1);
        this.bWb = new RectF();
        this.aAs = new float[]{bVZ, bVZ, bVZ, bVZ, 0.0f, 0.0f, 0.0f, 0.0f};
    }

    public SwanAppRoundCornerListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bWa = new Path();
        this.mPaint = new Paint(1);
        this.bWb = new RectF();
        this.aAs = new float[]{bVZ, bVZ, bVZ, bVZ, 0.0f, 0.0f, 0.0f, 0.0f};
    }

    public void setListViewRadius(float f, float f2, float f3, float f4) {
        setListViewRadius(new float[]{f, f, f2, f2, f3, f3, f4, f4});
    }

    public void setListViewRadius(@NonNull float[] fArr) {
        if (fArr.length < 8) {
            throw new ArrayIndexOutOfBoundsException("radii[] needs 8 values");
        }
        this.aAs = new float[8];
        for (int i = 0; i < 8; i++) {
            this.aAs[i] = fArr[i];
        }
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.bWb.set(0.0f, 0.0f, i, i2 + 1);
        this.bWa.reset();
        this.bWa.addRoundRect(this.bWb, this.aAs, Path.Direction.CW);
        this.bWc = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        canvas.save();
        this.mPaint.setColor(-1);
        this.mPaint.setXfermode(this.bWc);
        canvas.drawPath(this.bWa, this.mPaint);
        this.mPaint.setXfermode(null);
        canvas.restore();
    }
}
