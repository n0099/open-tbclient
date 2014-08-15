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
    Runnable a;
    private final Paint b;
    private final Context c;
    private boolean d;
    private int e;
    private boolean f;

    public HaloView(Context context) {
        this(context, null);
    }

    public HaloView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = false;
        this.e = 0;
        this.f = false;
        this.a = new g(this);
        this.c = context;
        this.b = new Paint();
        this.b.setAntiAlias(true);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.baidu.tieba.z.HaloView);
        this.d = obtainStyledAttributes.getBoolean(0, false);
        obtainStyledAttributes.recycle();
        if (this.d) {
            this.b.setStyle(Paint.Style.FILL);
        } else {
            this.b.setStyle(Paint.Style.STROKE);
        }
        postDelayed(this.a, 800L);
    }

    public void setIsBlack(boolean z) {
        this.d = z;
        if (this.d) {
            this.b.setStyle(Paint.Style.FILL);
        } else {
            this.b.setStyle(Paint.Style.STROKE);
        }
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int width = getWidth() / 2;
        int height = getHeight() / 2;
        if (!this.d) {
            int c = com.baidu.adp.lib.util.j.c(this.c, com.baidu.tieba.s.ds70);
            int c2 = com.baidu.adp.lib.util.j.c(this.c, com.baidu.tieba.s.ds90);
            int c3 = com.baidu.adp.lib.util.j.c(this.c, com.baidu.tieba.s.ds30);
            int c4 = com.baidu.adp.lib.util.j.c(this.c, com.baidu.tieba.s.ds60);
            if (this.e >= 1) {
                this.b.setARGB(25, MotionEventCompat.ACTION_MASK, MotionEventCompat.ACTION_MASK, MotionEventCompat.ACTION_MASK);
                this.b.setStrokeWidth(c3);
                canvas.drawCircle(width, height, c, this.b);
            }
            if (this.e >= 2) {
                this.b.setARGB(20, MotionEventCompat.ACTION_MASK, MotionEventCompat.ACTION_MASK, MotionEventCompat.ACTION_MASK);
                this.b.setStrokeWidth(c4);
                canvas.drawCircle(width, height, (c3 / 2) + c, this.b);
            }
            if (this.e >= 3) {
                this.b.setARGB(15, MotionEventCompat.ACTION_MASK, MotionEventCompat.ACTION_MASK, MotionEventCompat.ACTION_MASK);
                this.b.setStrokeWidth(c2);
                canvas.drawCircle(width, height, c + c3, this.b);
            }
        } else {
            int c5 = com.baidu.adp.lib.util.j.c(this.c, com.baidu.tieba.s.ds120);
            this.b.setARGB(102, 0, 0, 0);
            this.b.setStrokeWidth(c5);
            canvas.drawCircle(width, height, c5, this.b);
        }
        super.onDraw(canvas);
    }

    public void a() {
        this.f = true;
    }
}
