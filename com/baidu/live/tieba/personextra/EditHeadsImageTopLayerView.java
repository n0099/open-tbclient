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
    private Paint bcq;
    private Paint bcr;
    private int bcs;
    private int bct;
    private float bcu;
    private float bcv;
    private int bcw;

    public EditHeadsImageTopLayerView(Context context) {
        super(context);
        this.bcq = null;
        this.bcr = null;
        this.bcs = 0;
        this.bct = 0;
        this.bcu = 0.42857143f;
        this.bcv = 1.0f;
        this.bcw = 1;
        init();
    }

    public EditHeadsImageTopLayerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bcq = null;
        this.bcr = null;
        this.bcs = 0;
        this.bct = 0;
        this.bcu = 0.42857143f;
        this.bcv = 1.0f;
        this.bcw = 1;
        init();
    }

    public EditHeadsImageTopLayerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bcq = null;
        this.bcr = null;
        this.bcs = 0;
        this.bct = 0;
        this.bcu = 0.42857143f;
        this.bcv = 1.0f;
        this.bcw = 1;
        init();
    }

    private void init() {
        this.bcq = new Paint();
        this.bcq.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.bcq.setAlpha(Opcodes.IFEQ);
        this.bcr = new Paint();
        this.bcr.setStyle(Paint.Style.STROKE);
        this.bcr.setColor(-1);
    }

    public void setLinePaintColor(int i) {
        if (this.bcr != null) {
            this.bcr.setColor(i);
        }
        invalidate();
    }

    public void setLineWidth(int i) {
        this.bcw = i;
        if (this.bcr != null) {
            this.bcr.setStrokeWidth(i);
        }
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.save();
        super.onDraw(canvas);
        canvas.restore();
        canvas.drawRect(0.0f, 0.0f, getWidth(), this.bcs, this.bcq);
        canvas.drawRect(0.0f, getHeight() - this.bct, getWidth(), getHeight(), this.bcq);
        canvas.drawRect(1.0f, this.bcs, getWidth() - 1, getHeight() - this.bct, this.bcr);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        float width = this.bcv * getWidth();
        if (width > getHeight()) {
            width = getHeight();
        }
        this.bcs = (int) (((i4 - i2) - width) * this.bcu);
        this.bct = (int) (((i4 - i2) - width) * (1.0f - this.bcu));
    }

    public void setCutImageHeightScale(float f) {
        this.bcv = f;
        invalidate();
    }
}
