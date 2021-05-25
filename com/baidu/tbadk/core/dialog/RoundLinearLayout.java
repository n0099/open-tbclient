package com.baidu.tbadk.core.dialog;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.baidu.tieba.R;
import java.util.Arrays;
/* loaded from: classes3.dex */
public class RoundLinearLayout extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public float f12067e;

    /* renamed from: f  reason: collision with root package name */
    public Shape f12068f;

    /* renamed from: g  reason: collision with root package name */
    public Paint f12069g;

    /* renamed from: h  reason: collision with root package name */
    public int f12070h;

    public RoundLinearLayout(Context context) {
        this(context, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        int saveCount = canvas.getSaveCount();
        canvas.save();
        super.dispatchDraw(canvas);
        Shape shape = this.f12068f;
        if (shape != null) {
            shape.draw(canvas, this.f12069g);
        }
        if (saveCount < 1 || saveCount > canvas.getSaveCount()) {
            return;
        }
        canvas.restoreToCount(saveCount);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        if (z) {
            if (this.f12068f == null) {
                float[] fArr = new float[8];
                Arrays.fill(fArr, 0.0f);
                RectF rectF = new RectF(getPaddingLeft(), getPaddingTop() > 0 ? getPaddingTop() : 1.0f, getPaddingRight() <= 0 ? 1.0f : getPaddingRight(), getPaddingBottom());
                float[] fArr2 = new float[8];
                Arrays.fill(fArr, 0.0f);
                Arrays.fill(fArr2, 0, this.f12070h, this.f12067e);
                this.f12068f = new RoundRectShape(fArr, rectF, fArr2);
            }
            this.f12068f.resize(getWidth(), getHeight());
        }
    }

    public void setRadius(float f2) {
        this.f12067e = f2;
    }

    public void setRoundCount(int i2) {
        this.f12070h = i2;
    }

    public RoundLinearLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundLinearLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f12067e = 0.0f;
        this.f12070h = 4;
        setLayerType(1, null);
        this.f12067e = getResources().getDimension(R.dimen.tbds32);
        Paint paint = new Paint();
        this.f12069g = paint;
        paint.setAntiAlias(true);
        this.f12069g.setColor(-7829368);
        this.f12069g.setStyle(Paint.Style.FILL);
        this.f12069g.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    }
}
