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
import com.baidu.swan.apps.ap.ah;
/* loaded from: classes3.dex */
public class SwanAppRoundCornerListView extends ListView {
    private static final float dgi = ah.I(11.0f);
    private float[] bxA;
    private final Path dgj;
    private final RectF dgk;
    private PorterDuffXfermode dgl;
    private final Paint mPaint;

    public SwanAppRoundCornerListView(Context context) {
        super(context);
        this.dgj = new Path();
        this.mPaint = new Paint(1);
        this.dgk = new RectF();
        this.bxA = new float[]{dgi, dgi, dgi, dgi, 0.0f, 0.0f, 0.0f, 0.0f};
    }

    public SwanAppRoundCornerListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dgj = new Path();
        this.mPaint = new Paint(1);
        this.dgk = new RectF();
        this.bxA = new float[]{dgi, dgi, dgi, dgi, 0.0f, 0.0f, 0.0f, 0.0f};
    }

    public SwanAppRoundCornerListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dgj = new Path();
        this.mPaint = new Paint(1);
        this.dgk = new RectF();
        this.bxA = new float[]{dgi, dgi, dgi, dgi, 0.0f, 0.0f, 0.0f, 0.0f};
    }

    public void setListViewRadius(float f, float f2, float f3, float f4) {
        setListViewRadius(new float[]{f, f, f2, f2, f3, f3, f4, f4});
    }

    public void setListViewRadius(@NonNull float[] fArr) {
        if (fArr.length < 8) {
            throw new ArrayIndexOutOfBoundsException("radii[] needs 8 values");
        }
        this.bxA = new float[8];
        for (int i = 0; i < 8; i++) {
            this.bxA[i] = fArr[i];
        }
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.dgk.set(0.0f, 0.0f, i, i2 + 1);
        this.dgj.reset();
        this.dgj.addRoundRect(this.dgk, this.bxA, Path.Direction.CW);
        this.dgl = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        canvas.save();
        this.mPaint.setColor(-1);
        this.mPaint.setXfermode(this.dgl);
        canvas.drawPath(this.dgj, this.mPaint);
        this.mPaint.setXfermode(null);
        canvas.restore();
    }
}
