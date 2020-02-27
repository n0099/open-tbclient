package com.baidu.live.gift.widget.panel;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class GiftPanelNumRoundRectView extends View {
    private float api;
    private boolean apj;
    private Paint mPaint;
    private Path mPath;
    private float mRadius;

    public GiftPanelNumRoundRectView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setStyleEnabled(boolean z) {
        if (this.apj != z) {
            this.apj = z;
            this.mPaint.setColor(this.apj ? -49609 : -8445926);
            invalidate();
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        RectF rectF = new RectF(this.api, this.api, this.api + (this.mRadius * 2.0f), this.api + (this.mRadius * 2.0f));
        this.mPath.reset();
        this.mPath.addArc(rectF, -90.0f, -90.0f);
        this.mPath.moveTo(this.api, this.mRadius + this.api);
        this.mPath.lineTo(this.api, i2 - this.mRadius);
        this.mPath.addArc(new RectF(this.api, i2 - (this.mRadius * 2.0f), this.api + (this.mRadius * 2.0f), i2 - this.api), -180.0f, -90.0f);
        this.mPath.moveTo(this.mRadius + this.api, this.api);
        this.mPath.lineTo(i, this.api);
        this.mPath.moveTo(this.mRadius + this.api, i2 - this.api);
        this.mPath.lineTo(i, i2 - this.api);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(this.mPath, this.mPaint);
    }

    private void init() {
        this.mRadius = getResources().getDimensionPixelOffset(a.e.sdk_ds16);
        this.api = 0.5f * 2.0f;
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
