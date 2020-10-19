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
    private Paint bun;
    private Paint buo;
    private int bup;
    private int buq;
    private float bur;
    private float bus;
    private int but;

    public EditHeadsImageTopLayerView(Context context) {
        super(context);
        this.bun = null;
        this.buo = null;
        this.bup = 0;
        this.buq = 0;
        this.bur = 0.42857143f;
        this.bus = 1.0f;
        this.but = 1;
        init();
    }

    public EditHeadsImageTopLayerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bun = null;
        this.buo = null;
        this.bup = 0;
        this.buq = 0;
        this.bur = 0.42857143f;
        this.bus = 1.0f;
        this.but = 1;
        init();
    }

    public EditHeadsImageTopLayerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bun = null;
        this.buo = null;
        this.bup = 0;
        this.buq = 0;
        this.bur = 0.42857143f;
        this.bus = 1.0f;
        this.but = 1;
        init();
    }

    private void init() {
        this.bun = new Paint();
        this.bun.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.bun.setAlpha(Opcodes.IFEQ);
        this.buo = new Paint();
        this.buo.setStyle(Paint.Style.STROKE);
        this.buo.setColor(-1);
    }

    public void setLinePaintColor(int i) {
        if (this.buo != null) {
            this.buo.setColor(i);
        }
        invalidate();
    }

    public void setLineWidth(int i) {
        this.but = i;
        if (this.buo != null) {
            this.buo.setStrokeWidth(i);
        }
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.save();
        super.onDraw(canvas);
        canvas.restore();
        canvas.drawRect(0.0f, 0.0f, getWidth(), this.bup, this.bun);
        canvas.drawRect(0.0f, getHeight() - this.buq, getWidth(), getHeight(), this.bun);
        canvas.drawRect(1.0f, this.bup, getWidth() - 1, getHeight() - this.buq, this.buo);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        float width = this.bus * getWidth();
        if (width > getHeight()) {
            width = getHeight();
        }
        this.bup = (int) (((i4 - i2) - width) * this.bur);
        this.buq = (int) (((i4 - i2) - width) * (1.0f - this.bur));
    }

    public void setCutImageHeightScale(float f) {
        this.bus = f;
        invalidate();
    }
}
