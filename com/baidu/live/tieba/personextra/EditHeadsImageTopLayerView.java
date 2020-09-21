package com.baidu.live.tieba.personextra;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
import com.alibaba.fastjson.asm.Opcodes;
/* loaded from: classes4.dex */
public class EditHeadsImageTopLayerView extends View {
    private Paint bqA;
    private int bqB;
    private int bqC;
    private float bqD;
    private float bqE;
    private int bqF;
    private Paint bqz;

    public EditHeadsImageTopLayerView(Context context) {
        super(context);
        this.bqz = null;
        this.bqA = null;
        this.bqB = 0;
        this.bqC = 0;
        this.bqD = 0.42857143f;
        this.bqE = 1.0f;
        this.bqF = 1;
        init();
    }

    public EditHeadsImageTopLayerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bqz = null;
        this.bqA = null;
        this.bqB = 0;
        this.bqC = 0;
        this.bqD = 0.42857143f;
        this.bqE = 1.0f;
        this.bqF = 1;
        init();
    }

    public EditHeadsImageTopLayerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bqz = null;
        this.bqA = null;
        this.bqB = 0;
        this.bqC = 0;
        this.bqD = 0.42857143f;
        this.bqE = 1.0f;
        this.bqF = 1;
        init();
    }

    private void init() {
        this.bqz = new Paint();
        this.bqz.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.bqz.setAlpha(Opcodes.IFEQ);
        this.bqA = new Paint();
        this.bqA.setStyle(Paint.Style.STROKE);
        this.bqA.setColor(-1);
    }

    public void setLinePaintColor(int i) {
        if (this.bqA != null) {
            this.bqA.setColor(i);
        }
        invalidate();
    }

    public void setLineWidth(int i) {
        this.bqF = i;
        if (this.bqA != null) {
            this.bqA.setStrokeWidth(i);
        }
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.save();
        super.onDraw(canvas);
        canvas.restore();
        canvas.drawRect(0.0f, 0.0f, getWidth(), this.bqB, this.bqz);
        canvas.drawRect(0.0f, getHeight() - this.bqC, getWidth(), getHeight(), this.bqz);
        canvas.drawRect(1.0f, this.bqB, getWidth() - 1, getHeight() - this.bqC, this.bqA);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        float width = this.bqE * getWidth();
        if (width > getHeight()) {
            width = getHeight();
        }
        this.bqB = (int) (((i4 - i2) - width) * this.bqD);
        this.bqC = (int) (((i4 - i2) - width) * (1.0f - this.bqD));
    }

    public void setCutImageHeightScale(float f) {
        this.bqE = f;
        invalidate();
    }
}
