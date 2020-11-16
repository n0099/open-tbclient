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
    private Paint bAT;
    private Paint bAU;
    private int bAV;
    private int bAW;
    private float bAX;
    private float bAY;
    private int bAZ;

    public EditHeadsImageTopLayerView(Context context) {
        super(context);
        this.bAT = null;
        this.bAU = null;
        this.bAV = 0;
        this.bAW = 0;
        this.bAX = 0.42857143f;
        this.bAY = 1.0f;
        this.bAZ = 1;
        init();
    }

    public EditHeadsImageTopLayerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bAT = null;
        this.bAU = null;
        this.bAV = 0;
        this.bAW = 0;
        this.bAX = 0.42857143f;
        this.bAY = 1.0f;
        this.bAZ = 1;
        init();
    }

    public EditHeadsImageTopLayerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bAT = null;
        this.bAU = null;
        this.bAV = 0;
        this.bAW = 0;
        this.bAX = 0.42857143f;
        this.bAY = 1.0f;
        this.bAZ = 1;
        init();
    }

    private void init() {
        this.bAT = new Paint();
        this.bAT.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.bAT.setAlpha(Opcodes.IFEQ);
        this.bAU = new Paint();
        this.bAU.setStyle(Paint.Style.STROKE);
        this.bAU.setColor(-1);
    }

    public void setLinePaintColor(int i) {
        if (this.bAU != null) {
            this.bAU.setColor(i);
        }
        invalidate();
    }

    public void setLineWidth(int i) {
        this.bAZ = i;
        if (this.bAU != null) {
            this.bAU.setStrokeWidth(i);
        }
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.save();
        super.onDraw(canvas);
        canvas.restore();
        canvas.drawRect(0.0f, 0.0f, getWidth(), this.bAV, this.bAT);
        canvas.drawRect(0.0f, getHeight() - this.bAW, getWidth(), getHeight(), this.bAT);
        canvas.drawRect(1.0f, this.bAV, getWidth() - 1, getHeight() - this.bAW, this.bAU);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        float width = this.bAY * getWidth();
        if (width > getHeight()) {
            width = getHeight();
        }
        this.bAV = (int) (((i4 - i2) - width) * this.bAX);
        this.bAW = (int) (((i4 - i2) - width) * (1.0f - this.bAX));
    }

    public void setCutImageHeightScale(float f) {
        this.bAY = f;
        invalidate();
    }
}
