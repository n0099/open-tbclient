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
    public float f12830e;

    /* renamed from: f  reason: collision with root package name */
    public Shape f12831f;

    /* renamed from: g  reason: collision with root package name */
    public Paint f12832g;

    /* renamed from: h  reason: collision with root package name */
    public int f12833h;

    public RoundLinearLayout(Context context) {
        this(context, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        int saveCount = canvas.getSaveCount();
        canvas.save();
        super.dispatchDraw(canvas);
        Shape shape = this.f12831f;
        if (shape != null) {
            shape.draw(canvas, this.f12832g);
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
            if (this.f12831f == null) {
                float[] fArr = new float[8];
                Arrays.fill(fArr, 0.0f);
                RectF rectF = new RectF(getPaddingLeft(), getPaddingTop() > 0 ? getPaddingTop() : 1.0f, getPaddingRight() <= 0 ? 1.0f : getPaddingRight(), getPaddingBottom());
                float[] fArr2 = new float[8];
                Arrays.fill(fArr, 0.0f);
                Arrays.fill(fArr2, 0, this.f12833h, this.f12830e);
                this.f12831f = new RoundRectShape(fArr, rectF, fArr2);
            }
            this.f12831f.resize(getWidth(), getHeight());
        }
    }

    public void setRadius(float f2) {
        this.f12830e = f2;
    }

    public void setRoundCount(int i2) {
        this.f12833h = i2;
    }

    public RoundLinearLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundLinearLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f12830e = 0.0f;
        this.f12833h = 4;
        setLayerType(1, null);
        this.f12830e = getResources().getDimension(R.dimen.tbds32);
        Paint paint = new Paint();
        this.f12832g = paint;
        paint.setAntiAlias(true);
        this.f12832g.setColor(-7829368);
        this.f12832g.setStyle(Paint.Style.FILL);
        this.f12832g.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    }
}
