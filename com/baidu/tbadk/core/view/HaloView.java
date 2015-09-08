package com.baidu.tbadk.core.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v4.view.MotionEventCompat;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.cloudsdk.social.core.util.SocialAPIErrorCodes;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class HaloView extends View {
    Runnable Ix;
    private boolean adK;
    private int adL;
    private boolean adM;
    private final Context mContext;
    private final Paint mPaint;

    public HaloView(Context context) {
        this(context, null);
    }

    public HaloView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.adK = false;
        this.adL = 0;
        this.adM = false;
        this.Ix = new j(this);
        this.mContext = context;
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i.j.HaloView);
        this.adK = obtainStyledAttributes.getBoolean(0, false);
        obtainStyledAttributes.recycle();
        if (this.adK) {
            this.mPaint.setStyle(Paint.Style.FILL);
        } else {
            this.mPaint.setStyle(Paint.Style.STROKE);
        }
        postDelayed(this.Ix, 800L);
    }

    public void setIsBlack(boolean z) {
        this.adK = z;
        if (this.adK) {
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
        if (!this.adK) {
            int d = com.baidu.adp.lib.util.k.d(this.mContext, i.d.ds70);
            int d2 = com.baidu.adp.lib.util.k.d(this.mContext, i.d.ds90);
            int d3 = com.baidu.adp.lib.util.k.d(this.mContext, i.d.ds30);
            int d4 = com.baidu.adp.lib.util.k.d(this.mContext, i.d.ds60);
            if (this.adL >= 1) {
                this.mPaint.setARGB(25, MotionEventCompat.ACTION_MASK, MotionEventCompat.ACTION_MASK, MotionEventCompat.ACTION_MASK);
                this.mPaint.setStrokeWidth(d3);
                canvas.drawCircle(width, height, d, this.mPaint);
            }
            if (this.adL >= 2) {
                this.mPaint.setARGB(20, MotionEventCompat.ACTION_MASK, MotionEventCompat.ACTION_MASK, MotionEventCompat.ACTION_MASK);
                this.mPaint.setStrokeWidth(d4);
                canvas.drawCircle(width, height, (d3 / 2) + d, this.mPaint);
            }
            if (this.adL >= 3) {
                this.mPaint.setARGB(15, MotionEventCompat.ACTION_MASK, MotionEventCompat.ACTION_MASK, MotionEventCompat.ACTION_MASK);
                this.mPaint.setStrokeWidth(d2);
                canvas.drawCircle(width, height, d + d3, this.mPaint);
            }
        } else {
            int d5 = com.baidu.adp.lib.util.k.d(this.mContext, i.d.ds120);
            this.mPaint.setARGB(SocialAPIErrorCodes.ERROR_INVALID_SESSION_KEY, 0, 0, 0);
            this.mPaint.setStrokeWidth(d5);
            canvas.drawCircle(width, height, d5, this.mPaint);
        }
        super.onDraw(canvas);
    }

    public void onDestroy() {
        this.adM = true;
    }
}
