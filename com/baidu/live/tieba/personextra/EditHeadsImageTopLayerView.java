package com.baidu.live.tieba.personextra;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.view.ViewCompat;
import com.alibaba.fastjson.asm.Opcodes;
/* loaded from: classes11.dex */
public class EditHeadsImageTopLayerView extends View {
    private Paint bKQ;
    private Paint bKR;
    private int bKS;
    private int bKT;
    private float bKU;
    private float bKV;
    private int bKW;

    public EditHeadsImageTopLayerView(Context context) {
        super(context);
        this.bKQ = null;
        this.bKR = null;
        this.bKS = 0;
        this.bKT = 0;
        this.bKU = 0.42857143f;
        this.bKV = 1.0f;
        this.bKW = 1;
        init();
    }

    public EditHeadsImageTopLayerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bKQ = null;
        this.bKR = null;
        this.bKS = 0;
        this.bKT = 0;
        this.bKU = 0.42857143f;
        this.bKV = 1.0f;
        this.bKW = 1;
        init();
    }

    public EditHeadsImageTopLayerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bKQ = null;
        this.bKR = null;
        this.bKS = 0;
        this.bKT = 0;
        this.bKU = 0.42857143f;
        this.bKV = 1.0f;
        this.bKW = 1;
        init();
    }

    private void init() {
        this.bKQ = new Paint();
        this.bKQ.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.bKQ.setAlpha(Opcodes.IFEQ);
        this.bKR = new Paint();
        this.bKR.setStyle(Paint.Style.STROKE);
        this.bKR.setColor(-1);
    }

    public void setLinePaintColor(int i) {
        if (this.bKR != null) {
            this.bKR.setColor(i);
        }
        invalidate();
    }

    public void setLineWidth(int i) {
        this.bKW = i;
        if (this.bKR != null) {
            this.bKR.setStrokeWidth(i);
        }
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.save();
        super.onDraw(canvas);
        canvas.restore();
        canvas.drawRect(0.0f, 0.0f, getWidth(), this.bKS, this.bKQ);
        canvas.drawRect(0.0f, getHeight() - this.bKT, getWidth(), getHeight(), this.bKQ);
        canvas.drawRect(1.0f, this.bKS, getWidth() - 1, getHeight() - this.bKT, this.bKR);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        float width = this.bKV * getWidth();
        if (width > getHeight()) {
            width = getHeight();
        }
        this.bKS = (int) (((i4 - i2) - width) * this.bKU);
        this.bKT = (int) (((i4 - i2) - width) * (1.0f - this.bKU));
    }

    public void setCutImageHeightScale(float f) {
        this.bKV = f;
        invalidate();
    }
}
