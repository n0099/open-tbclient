package com.baidu.tbadk.core.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v4.view.MotionEventCompat;
import android.util.AttributeSet;
import android.view.View;
/* loaded from: classes.dex */
public class HaloView extends View {
    private boolean Mp;
    private int Mq;
    private boolean Mr;
    private final Context mContext;
    private final Paint mPaint;
    Runnable yd;

    public HaloView(Context context) {
        this(context, null);
    }

    public HaloView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Mp = false;
        this.Mq = 0;
        this.Mr = false;
        this.yd = new p(this);
        this.mContext = context;
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.baidu.tieba.ab.HaloView);
        this.Mp = obtainStyledAttributes.getBoolean(0, false);
        obtainStyledAttributes.recycle();
        if (this.Mp) {
            this.mPaint.setStyle(Paint.Style.FILL);
        } else {
            this.mPaint.setStyle(Paint.Style.STROKE);
        }
        postDelayed(this.yd, 800L);
    }

    public void setIsBlack(boolean z) {
        this.Mp = z;
        if (this.Mp) {
            this.mPaint.setStyle(Paint.Style.FILL);
        } else {
            this.mPaint.setStyle(Paint.Style.STROKE);
        }
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int width = getWidth() / 2;
        int height = getHeight() / 2;
        if (!this.Mp) {
            int d = com.baidu.adp.lib.util.l.d(this.mContext, com.baidu.tieba.u.ds70);
            int d2 = com.baidu.adp.lib.util.l.d(this.mContext, com.baidu.tieba.u.ds90);
            int d3 = com.baidu.adp.lib.util.l.d(this.mContext, com.baidu.tieba.u.ds30);
            int d4 = com.baidu.adp.lib.util.l.d(this.mContext, com.baidu.tieba.u.ds60);
            if (this.Mq >= 1) {
                this.mPaint.setARGB(25, MotionEventCompat.ACTION_MASK, MotionEventCompat.ACTION_MASK, MotionEventCompat.ACTION_MASK);
                this.mPaint.setStrokeWidth(d3);
                canvas.drawCircle(width, height, d, this.mPaint);
            }
            if (this.Mq >= 2) {
                this.mPaint.setARGB(20, MotionEventCompat.ACTION_MASK, MotionEventCompat.ACTION_MASK, MotionEventCompat.ACTION_MASK);
                this.mPaint.setStrokeWidth(d4);
                canvas.drawCircle(width, height, (d3 / 2) + d, this.mPaint);
            }
            if (this.Mq >= 3) {
                this.mPaint.setARGB(15, MotionEventCompat.ACTION_MASK, MotionEventCompat.ACTION_MASK, MotionEventCompat.ACTION_MASK);
                this.mPaint.setStrokeWidth(d2);
                canvas.drawCircle(width, height, d + d3, this.mPaint);
            }
        } else {
            int d5 = com.baidu.adp.lib.util.l.d(this.mContext, com.baidu.tieba.u.ds120);
            this.mPaint.setARGB(102, 0, 0, 0);
            this.mPaint.setStrokeWidth(d5);
            canvas.drawCircle(width, height, d5, this.mPaint);
        }
        super.onDraw(canvas);
    }

    public void onDestroy() {
        this.Mr = true;
    }
}
