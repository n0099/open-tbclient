package com.baidu.live.tieba.personextra;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
import com.alibaba.fastjson.asm.Opcodes;
/* loaded from: classes7.dex */
public class EditHeadsImageTopLayerView extends View {
    private Paint bnB;
    private Paint bnC;
    private int bnD;
    private int bnE;
    private float bnF;
    private float bnG;
    private int bnH;

    public EditHeadsImageTopLayerView(Context context) {
        super(context);
        this.bnB = null;
        this.bnC = null;
        this.bnD = 0;
        this.bnE = 0;
        this.bnF = 0.42857143f;
        this.bnG = 1.0f;
        this.bnH = 1;
        init();
    }

    public EditHeadsImageTopLayerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bnB = null;
        this.bnC = null;
        this.bnD = 0;
        this.bnE = 0;
        this.bnF = 0.42857143f;
        this.bnG = 1.0f;
        this.bnH = 1;
        init();
    }

    public EditHeadsImageTopLayerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bnB = null;
        this.bnC = null;
        this.bnD = 0;
        this.bnE = 0;
        this.bnF = 0.42857143f;
        this.bnG = 1.0f;
        this.bnH = 1;
        init();
    }

    private void init() {
        this.bnB = new Paint();
        this.bnB.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.bnB.setAlpha(Opcodes.IFEQ);
        this.bnC = new Paint();
        this.bnC.setStyle(Paint.Style.STROKE);
        this.bnC.setColor(-1);
    }

    public void setLinePaintColor(int i) {
        if (this.bnC != null) {
            this.bnC.setColor(i);
        }
        invalidate();
    }

    public void setLineWidth(int i) {
        this.bnH = i;
        if (this.bnC != null) {
            this.bnC.setStrokeWidth(i);
        }
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.save();
        super.onDraw(canvas);
        canvas.restore();
        canvas.drawRect(0.0f, 0.0f, getWidth(), this.bnD, this.bnB);
        canvas.drawRect(0.0f, getHeight() - this.bnE, getWidth(), getHeight(), this.bnB);
        canvas.drawRect(1.0f, this.bnD, getWidth() - 1, getHeight() - this.bnE, this.bnC);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        float width = this.bnG * getWidth();
        if (width > getHeight()) {
            width = getHeight();
        }
        this.bnD = (int) (((i4 - i2) - width) * this.bnF);
        this.bnE = (int) (((i4 - i2) - width) * (1.0f - this.bnF));
    }

    public void setCutImageHeightScale(float f) {
        this.bnG = f;
        invalidate();
    }
}
