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
    private boolean Hv;
    private int Hw;
    private boolean Hx;
    private final Paint gs;
    private final Context mContext;
    Runnable wb;

    public HaloView(Context context) {
        this(context, null);
    }

    public HaloView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Hv = false;
        this.Hw = 0;
        this.Hx = false;
        this.wb = new h(this);
        this.mContext = context;
        this.gs = new Paint();
        this.gs.setAntiAlias(true);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.baidu.tieba.aa.HaloView);
        this.Hv = obtainStyledAttributes.getBoolean(0, false);
        obtainStyledAttributes.recycle();
        if (this.Hv) {
            this.gs.setStyle(Paint.Style.FILL);
        } else {
            this.gs.setStyle(Paint.Style.STROKE);
        }
        postDelayed(this.wb, 800L);
    }

    public void setIsBlack(boolean z) {
        this.Hv = z;
        if (this.Hv) {
            this.gs.setStyle(Paint.Style.FILL);
        } else {
            this.gs.setStyle(Paint.Style.STROKE);
        }
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int width = getWidth() / 2;
        int height = getHeight() / 2;
        if (!this.Hv) {
            int c = com.baidu.adp.lib.util.m.c(this.mContext, com.baidu.tieba.t.ds70);
            int c2 = com.baidu.adp.lib.util.m.c(this.mContext, com.baidu.tieba.t.ds90);
            int c3 = com.baidu.adp.lib.util.m.c(this.mContext, com.baidu.tieba.t.ds30);
            int c4 = com.baidu.adp.lib.util.m.c(this.mContext, com.baidu.tieba.t.ds60);
            if (this.Hw >= 1) {
                this.gs.setARGB(25, MotionEventCompat.ACTION_MASK, MotionEventCompat.ACTION_MASK, MotionEventCompat.ACTION_MASK);
                this.gs.setStrokeWidth(c3);
                canvas.drawCircle(width, height, c, this.gs);
            }
            if (this.Hw >= 2) {
                this.gs.setARGB(20, MotionEventCompat.ACTION_MASK, MotionEventCompat.ACTION_MASK, MotionEventCompat.ACTION_MASK);
                this.gs.setStrokeWidth(c4);
                canvas.drawCircle(width, height, (c3 / 2) + c, this.gs);
            }
            if (this.Hw >= 3) {
                this.gs.setARGB(15, MotionEventCompat.ACTION_MASK, MotionEventCompat.ACTION_MASK, MotionEventCompat.ACTION_MASK);
                this.gs.setStrokeWidth(c2);
                canvas.drawCircle(width, height, c + c3, this.gs);
            }
        } else {
            int c5 = com.baidu.adp.lib.util.m.c(this.mContext, com.baidu.tieba.t.ds120);
            this.gs.setARGB(102, 0, 0, 0);
            this.gs.setStrokeWidth(c5);
            canvas.drawCircle(width, height, c5, this.gs);
        }
        super.onDraw(canvas);
    }

    public void onDestroy() {
        this.Hx = true;
    }
}
