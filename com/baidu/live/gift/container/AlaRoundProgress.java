package com.baidu.live.gift.container;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.v4.internal.view.SupportMenu;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.ala.recorder.video.drawer.EncoderTextureDrawer;
import com.baidu.live.sdk.a;
/* loaded from: classes4.dex */
public class AlaRoundProgress extends View {
    private float baF;
    private int baG;
    private int max;
    private Paint paint;
    private int progress;
    private int progressColor;
    private int roundColor;
    private float roundWidth;

    public AlaRoundProgress(Context context) {
        this(context, null);
    }

    public AlaRoundProgress(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AlaRoundProgress(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.paint = new Paint();
        this.paint = new Paint();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.j.AlaRoundProgress);
        this.roundColor = obtainStyledAttributes.getColor(a.j.AlaRoundProgress_ala_srp_roundColor, SupportMenu.CATEGORY_MASK);
        this.roundWidth = obtainStyledAttributes.getDimension(a.j.AlaRoundProgress_ala_srp_roundWidth, 5.0f);
        this.progressColor = obtainStyledAttributes.getColor(a.j.AlaRoundProgress_ala_srp_progressColor, -16711936);
        this.baF = obtainStyledAttributes.getDimension(a.j.AlaRoundProgress_ala_srp_progressWidth, this.roundWidth);
        this.max = obtainStyledAttributes.getInteger(a.j.AlaRoundProgress_ala_srp_max, 100);
        this.baG = obtainStyledAttributes.getInt(a.j.AlaRoundProgress_ala_srp_startAngle, 0);
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float width = getWidth() / 2.0f;
        float f = width - (this.roundWidth / 2.0f);
        this.paint.setStrokeWidth(this.roundWidth);
        this.paint.setColor(Color.parseColor("#00ffffff"));
        this.paint.setAntiAlias(true);
        this.paint.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(width, width, f, this.paint);
        this.paint.setStrokeWidth(this.baF);
        this.paint.setColor(this.progressColor);
        RectF rectF = new RectF(width - f, width - f, width + f, width + f);
        int i = (this.progress * EncoderTextureDrawer.X264_WIDTH) / this.max;
        canvas.drawArc(rectF, this.baG, i, false, this.paint);
        this.paint.setColor(this.roundColor);
        canvas.drawArc(rectF, this.baG + i, 630 - (this.baG + i), false, this.paint);
    }

    public synchronized void setMax(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("max not less than 0");
        }
        this.max = i;
    }

    public synchronized int getProgress() {
        return this.progress;
    }

    public synchronized void setProgress(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("progress not less than 0");
        }
        if (i > this.max) {
            i = this.max;
        }
        this.progress = i;
        postInvalidate();
    }
}
