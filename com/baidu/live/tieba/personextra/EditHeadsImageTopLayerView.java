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
    private Paint aBa;
    private Paint aBb;
    private int aBc;
    private int aBd;
    private float aBe;
    private float aBf;
    private int aBg;

    public EditHeadsImageTopLayerView(Context context) {
        super(context);
        this.aBa = null;
        this.aBb = null;
        this.aBc = 0;
        this.aBd = 0;
        this.aBe = 0.42857143f;
        this.aBf = 1.0f;
        this.aBg = 1;
        init();
    }

    public EditHeadsImageTopLayerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aBa = null;
        this.aBb = null;
        this.aBc = 0;
        this.aBd = 0;
        this.aBe = 0.42857143f;
        this.aBf = 1.0f;
        this.aBg = 1;
        init();
    }

    public EditHeadsImageTopLayerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aBa = null;
        this.aBb = null;
        this.aBc = 0;
        this.aBd = 0;
        this.aBe = 0.42857143f;
        this.aBf = 1.0f;
        this.aBg = 1;
        init();
    }

    private void init() {
        this.aBa = new Paint();
        this.aBa.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.aBa.setAlpha(Opcodes.IFEQ);
        this.aBb = new Paint();
        this.aBb.setStyle(Paint.Style.STROKE);
        this.aBb.setColor(-1);
    }

    public void setLinePaintColor(int i) {
        if (this.aBb != null) {
            this.aBb.setColor(i);
        }
        invalidate();
    }

    public void setLineWidth(int i) {
        this.aBg = i;
        if (this.aBb != null) {
            this.aBb.setStrokeWidth(i);
        }
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.save();
        super.onDraw(canvas);
        canvas.restore();
        canvas.drawRect(0.0f, 0.0f, getWidth(), this.aBc, this.aBa);
        canvas.drawRect(0.0f, getHeight() - this.aBd, getWidth(), getHeight(), this.aBa);
        canvas.drawRect(1.0f, this.aBc, getWidth() - 1, getHeight() - this.aBd, this.aBb);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        float width = this.aBf * getWidth();
        if (width > getHeight()) {
            width = getHeight();
        }
        this.aBc = (int) (((i4 - i2) - width) * this.aBe);
        this.aBd = (int) (((i4 - i2) - width) * (1.0f - this.aBe));
    }

    public void setCutImageHeightScale(float f) {
        this.aBf = f;
        invalidate();
    }
}
