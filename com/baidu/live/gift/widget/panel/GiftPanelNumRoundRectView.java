package com.baidu.live.gift.widget.panel;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.live.sdk.a;
/* loaded from: classes3.dex */
public class GiftPanelNumRoundRectView extends View {
    private float aQs;
    private boolean aQt;
    private Paint mPaint;
    private Path mPath;
    private float mRadius;

    public GiftPanelNumRoundRectView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setStyleEnabled(boolean z) {
        if (this.aQt != z) {
            this.aQt = z;
            this.mPaint.setColor(this.aQt ? -49609 : -8445926);
            invalidate();
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        RectF rectF = new RectF(this.aQs, this.aQs, this.aQs + (this.mRadius * 2.0f), this.aQs + (this.mRadius * 2.0f));
        this.mPath.reset();
        this.mPath.addArc(rectF, -90.0f, -90.0f);
        this.mPath.moveTo(this.aQs, this.mRadius + this.aQs);
        this.mPath.lineTo(this.aQs, i2 - this.mRadius);
        this.mPath.addArc(new RectF(this.aQs, i2 - (this.mRadius * 2.0f), this.aQs + (this.mRadius * 2.0f), i2 - this.aQs), -180.0f, -90.0f);
        this.mPath.moveTo(this.mRadius + this.aQs, this.aQs);
        this.mPath.lineTo(i, this.aQs);
        this.mPath.moveTo(this.mRadius + this.aQs, i2 - this.aQs);
        this.mPath.lineTo(i, i2 - this.aQs);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(this.mPath, this.mPaint);
    }

    private void init() {
        this.mRadius = getResources().getDimensionPixelOffset(a.e.sdk_ds16);
        this.aQs = 0.5f * 2.0f;
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
