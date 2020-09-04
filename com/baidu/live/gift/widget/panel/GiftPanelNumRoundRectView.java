package com.baidu.live.gift.widget.panel;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.live.sdk.a;
/* loaded from: classes7.dex */
public class GiftPanelNumRoundRectView extends View {
    private float aXa;
    private boolean aXb;
    private Paint mPaint;
    private Path mPath;
    private float mRadius;

    public GiftPanelNumRoundRectView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setStyleEnabled(boolean z) {
        if (this.aXb != z) {
            this.aXb = z;
            this.mPaint.setColor(this.aXb ? -49609 : -8445926);
            invalidate();
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        RectF rectF = new RectF(this.aXa, this.aXa, this.aXa + (this.mRadius * 2.0f), this.aXa + (this.mRadius * 2.0f));
        this.mPath.reset();
        this.mPath.addArc(rectF, -90.0f, -90.0f);
        this.mPath.moveTo(this.aXa, this.mRadius + this.aXa);
        this.mPath.lineTo(this.aXa, i2 - this.mRadius);
        this.mPath.addArc(new RectF(this.aXa, i2 - (this.mRadius * 2.0f), this.aXa + (this.mRadius * 2.0f), i2 - this.aXa), -180.0f, -90.0f);
        this.mPath.moveTo(this.mRadius + this.aXa, this.aXa);
        this.mPath.lineTo(i, this.aXa);
        this.mPath.moveTo(this.mRadius + this.aXa, i2 - this.aXa);
        this.mPath.lineTo(i, i2 - this.aXa);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(this.mPath, this.mPaint);
    }

    private void init() {
        this.mRadius = getResources().getDimensionPixelOffset(a.e.sdk_ds16);
        this.aXa = 0.5f * 2.0f;
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
