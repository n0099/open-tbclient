package com.baidu.live.gift.widget.panel;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.live.r.a;
/* loaded from: classes2.dex */
public class GiftPanelNumRoundRectView extends View {
    private float amV;
    private boolean amW;
    private Paint mPaint;
    private Path mPath;
    private float mRadius;

    public GiftPanelNumRoundRectView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setStyleEnabled(boolean z) {
        if (this.amW != z) {
            this.amW = z;
            this.mPaint.setColor(this.amW ? -49609 : -8445926);
            invalidate();
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        RectF rectF = new RectF(this.amV, this.amV, this.amV + (this.mRadius * 2.0f), this.amV + (this.mRadius * 2.0f));
        this.mPath.reset();
        this.mPath.addArc(rectF, -90.0f, -90.0f);
        this.mPath.moveTo(this.amV, this.mRadius + this.amV);
        this.mPath.lineTo(this.amV, i2 - this.mRadius);
        this.mPath.addArc(new RectF(this.amV, i2 - (this.mRadius * 2.0f), this.amV + (this.mRadius * 2.0f), i2 - this.amV), -180.0f, -90.0f);
        this.mPath.moveTo(this.mRadius + this.amV, this.amV);
        this.mPath.lineTo(i, this.amV);
        this.mPath.moveTo(this.mRadius + this.amV, i2 - this.amV);
        this.mPath.lineTo(i, i2 - this.amV);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(this.mPath, this.mPaint);
    }

    private void init() {
        this.mRadius = getResources().getDimensionPixelOffset(a.e.sdk_ds16);
        this.amV = 0.5f * 2.0f;
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
