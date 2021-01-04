package com.baidu.live.yuyingift.widget.panel;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.live.sdk.a;
/* loaded from: classes11.dex */
public class GiftPanelNumRoundRectView extends View {
    private float bjC;
    private boolean bjD;
    private Paint mPaint;
    private Path mPath;
    private float mRadius;

    public GiftPanelNumRoundRectView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setStyleEnabled(boolean z) {
        if (this.bjD != z) {
            this.bjD = z;
            this.mPaint.setColor(this.bjD ? -49609 : -8445926);
            invalidate();
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        RectF rectF = new RectF(this.bjC, this.bjC, this.bjC + (this.mRadius * 2.0f), this.bjC + (this.mRadius * 2.0f));
        this.mPath.reset();
        this.mPath.addArc(rectF, -90.0f, -90.0f);
        this.mPath.moveTo(this.bjC, this.mRadius + this.bjC);
        this.mPath.lineTo(this.bjC, i2 - this.mRadius);
        this.mPath.addArc(new RectF(this.bjC, i2 - (this.mRadius * 2.0f), this.bjC + (this.mRadius * 2.0f), i2 - this.bjC), -180.0f, -90.0f);
        this.mPath.moveTo(this.mRadius + this.bjC, this.bjC);
        this.mPath.lineTo(i, this.bjC);
        this.mPath.moveTo(this.mRadius + this.bjC, i2 - this.bjC);
        this.mPath.lineTo(i, i2 - this.bjC);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(this.mPath, this.mPaint);
    }

    private void init() {
        this.mRadius = getResources().getDimensionPixelOffset(a.d.sdk_ds16);
        this.bjC = 0.5f * 2.0f;
        this.mPaint = new Paint(1);
        this.mPaint.setDither(true);
        this.mPaint.setColor(-49609);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeWidth(2.0f);
        this.mPaint.setStrokeJoin(Paint.Join.ROUND);
        this.mPath = new Path();
        setStyleEnabled(true);
    }
}
