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
    private Paint bJO;
    private Paint bJP;
    private int bJQ;
    private int bJR;
    private float bJS;
    private float bJT;
    private int bJU;

    public EditHeadsImageTopLayerView(Context context) {
        super(context);
        this.bJO = null;
        this.bJP = null;
        this.bJQ = 0;
        this.bJR = 0;
        this.bJS = 0.42857143f;
        this.bJT = 1.0f;
        this.bJU = 1;
        init();
    }

    public EditHeadsImageTopLayerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bJO = null;
        this.bJP = null;
        this.bJQ = 0;
        this.bJR = 0;
        this.bJS = 0.42857143f;
        this.bJT = 1.0f;
        this.bJU = 1;
        init();
    }

    public EditHeadsImageTopLayerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bJO = null;
        this.bJP = null;
        this.bJQ = 0;
        this.bJR = 0;
        this.bJS = 0.42857143f;
        this.bJT = 1.0f;
        this.bJU = 1;
        init();
    }

    private void init() {
        this.bJO = new Paint();
        this.bJO.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.bJO.setAlpha(Opcodes.IFEQ);
        this.bJP = new Paint();
        this.bJP.setStyle(Paint.Style.STROKE);
        this.bJP.setColor(-1);
    }

    public void setLinePaintColor(int i) {
        if (this.bJP != null) {
            this.bJP.setColor(i);
        }
        invalidate();
    }

    public void setLineWidth(int i) {
        this.bJU = i;
        if (this.bJP != null) {
            this.bJP.setStrokeWidth(i);
        }
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.save();
        super.onDraw(canvas);
        canvas.restore();
        canvas.drawRect(0.0f, 0.0f, getWidth(), this.bJQ, this.bJO);
        canvas.drawRect(0.0f, getHeight() - this.bJR, getWidth(), getHeight(), this.bJO);
        canvas.drawRect(1.0f, this.bJQ, getWidth() - 1, getHeight() - this.bJR, this.bJP);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        float width = this.bJT * getWidth();
        if (width > getHeight()) {
            width = getHeight();
        }
        this.bJQ = (int) (((i4 - i2) - width) * this.bJS);
        this.bJR = (int) (((i4 - i2) - width) * (1.0f - this.bJS));
    }

    public void setCutImageHeightScale(float f) {
        this.bJT = f;
        invalidate();
    }
}
