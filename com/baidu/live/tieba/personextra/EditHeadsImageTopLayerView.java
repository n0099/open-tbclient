package com.baidu.live.tieba.personextra;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
import com.alibaba.fastjson.asm.Opcodes;
/* loaded from: classes3.dex */
public class EditHeadsImageTopLayerView extends View {
    private Paint aBb;
    private Paint aBc;
    private int aBd;
    private int aBe;
    private float aBf;
    private float aBg;
    private int aBh;

    public EditHeadsImageTopLayerView(Context context) {
        super(context);
        this.aBb = null;
        this.aBc = null;
        this.aBd = 0;
        this.aBe = 0;
        this.aBf = 0.42857143f;
        this.aBg = 1.0f;
        this.aBh = 1;
        init();
    }

    public EditHeadsImageTopLayerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aBb = null;
        this.aBc = null;
        this.aBd = 0;
        this.aBe = 0;
        this.aBf = 0.42857143f;
        this.aBg = 1.0f;
        this.aBh = 1;
        init();
    }

    public EditHeadsImageTopLayerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aBb = null;
        this.aBc = null;
        this.aBd = 0;
        this.aBe = 0;
        this.aBf = 0.42857143f;
        this.aBg = 1.0f;
        this.aBh = 1;
        init();
    }

    private void init() {
        this.aBb = new Paint();
        this.aBb.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.aBb.setAlpha(Opcodes.IFEQ);
        this.aBc = new Paint();
        this.aBc.setStyle(Paint.Style.STROKE);
        this.aBc.setColor(-1);
    }

    public void setLinePaintColor(int i) {
        if (this.aBc != null) {
            this.aBc.setColor(i);
        }
        invalidate();
    }

    public void setLineWidth(int i) {
        this.aBh = i;
        if (this.aBc != null) {
            this.aBc.setStrokeWidth(i);
        }
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.save();
        super.onDraw(canvas);
        canvas.restore();
        canvas.drawRect(0.0f, 0.0f, getWidth(), this.aBd, this.aBb);
        canvas.drawRect(0.0f, getHeight() - this.aBe, getWidth(), getHeight(), this.aBb);
        canvas.drawRect(1.0f, this.aBd, getWidth() - 1, getHeight() - this.aBe, this.aBc);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        float width = this.aBg * getWidth();
        if (width > getHeight()) {
            width = getHeight();
        }
        this.aBd = (int) (((i4 - i2) - width) * this.aBf);
        this.aBe = (int) (((i4 - i2) - width) * (1.0f - this.aBf));
    }

    public void setCutImageHeightScale(float f) {
        this.aBg = f;
        invalidate();
    }
}
