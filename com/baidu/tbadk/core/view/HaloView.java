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
    Runnable IC;
    private boolean XO;
    private int XP;
    private boolean XQ;
    private final Context mContext;
    private final Paint mPaint;

    public HaloView(Context context) {
        this(context, null);
    }

    public HaloView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.XO = false;
        this.XP = 0;
        this.XQ = false;
        this.IC = new l(this);
        this.mContext = context;
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.baidu.tieba.aa.HaloView);
        this.XO = obtainStyledAttributes.getBoolean(0, false);
        obtainStyledAttributes.recycle();
        if (this.XO) {
            this.mPaint.setStyle(Paint.Style.FILL);
        } else {
            this.mPaint.setStyle(Paint.Style.STROKE);
        }
        postDelayed(this.IC, 800L);
    }

    public void setIsBlack(boolean z) {
        this.XO = z;
        if (this.XO) {
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
        if (!this.XO) {
            int d = com.baidu.adp.lib.util.n.d(this.mContext, com.baidu.tieba.t.ds70);
            int d2 = com.baidu.adp.lib.util.n.d(this.mContext, com.baidu.tieba.t.ds90);
            int d3 = com.baidu.adp.lib.util.n.d(this.mContext, com.baidu.tieba.t.ds30);
            int d4 = com.baidu.adp.lib.util.n.d(this.mContext, com.baidu.tieba.t.ds60);
            if (this.XP >= 1) {
                this.mPaint.setARGB(25, MotionEventCompat.ACTION_MASK, MotionEventCompat.ACTION_MASK, MotionEventCompat.ACTION_MASK);
                this.mPaint.setStrokeWidth(d3);
                canvas.drawCircle(width, height, d, this.mPaint);
            }
            if (this.XP >= 2) {
                this.mPaint.setARGB(20, MotionEventCompat.ACTION_MASK, MotionEventCompat.ACTION_MASK, MotionEventCompat.ACTION_MASK);
                this.mPaint.setStrokeWidth(d4);
                canvas.drawCircle(width, height, (d3 / 2) + d, this.mPaint);
            }
            if (this.XP >= 3) {
                this.mPaint.setARGB(15, MotionEventCompat.ACTION_MASK, MotionEventCompat.ACTION_MASK, MotionEventCompat.ACTION_MASK);
                this.mPaint.setStrokeWidth(d2);
                canvas.drawCircle(width, height, d + d3, this.mPaint);
            }
        } else {
            int d5 = com.baidu.adp.lib.util.n.d(this.mContext, com.baidu.tieba.t.ds120);
            this.mPaint.setARGB(102, 0, 0, 0);
            this.mPaint.setStrokeWidth(d5);
            canvas.drawCircle(width, height, d5, this.mPaint);
        }
        super.onDraw(canvas);
    }

    public void onDestroy() {
        this.XQ = true;
    }
}
