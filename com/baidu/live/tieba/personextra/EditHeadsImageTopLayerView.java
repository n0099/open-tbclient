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
    private Paint aUX;
    private Paint aUY;
    private int aUZ;
    private int aVa;
    private float aVb;
    private float aVc;
    private int aVd;

    public EditHeadsImageTopLayerView(Context context) {
        super(context);
        this.aUX = null;
        this.aUY = null;
        this.aUZ = 0;
        this.aVa = 0;
        this.aVb = 0.42857143f;
        this.aVc = 1.0f;
        this.aVd = 1;
        init();
    }

    public EditHeadsImageTopLayerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aUX = null;
        this.aUY = null;
        this.aUZ = 0;
        this.aVa = 0;
        this.aVb = 0.42857143f;
        this.aVc = 1.0f;
        this.aVd = 1;
        init();
    }

    public EditHeadsImageTopLayerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aUX = null;
        this.aUY = null;
        this.aUZ = 0;
        this.aVa = 0;
        this.aVb = 0.42857143f;
        this.aVc = 1.0f;
        this.aVd = 1;
        init();
    }

    private void init() {
        this.aUX = new Paint();
        this.aUX.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.aUX.setAlpha(Opcodes.IFEQ);
        this.aUY = new Paint();
        this.aUY.setStyle(Paint.Style.STROKE);
        this.aUY.setColor(-1);
    }

    public void setLinePaintColor(int i) {
        if (this.aUY != null) {
            this.aUY.setColor(i);
        }
        invalidate();
    }

    public void setLineWidth(int i) {
        this.aVd = i;
        if (this.aUY != null) {
            this.aUY.setStrokeWidth(i);
        }
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.save();
        super.onDraw(canvas);
        canvas.restore();
        canvas.drawRect(0.0f, 0.0f, getWidth(), this.aUZ, this.aUX);
        canvas.drawRect(0.0f, getHeight() - this.aVa, getWidth(), getHeight(), this.aUX);
        canvas.drawRect(1.0f, this.aUZ, getWidth() - 1, getHeight() - this.aVa, this.aUY);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        float width = this.aVc * getWidth();
        if (width > getHeight()) {
            width = getHeight();
        }
        this.aUZ = (int) (((i4 - i2) - width) * this.aVb);
        this.aVa = (int) (((i4 - i2) - width) * (1.0f - this.aVb));
    }

    public void setCutImageHeightScale(float f) {
        this.aVc = f;
        invalidate();
    }
}
