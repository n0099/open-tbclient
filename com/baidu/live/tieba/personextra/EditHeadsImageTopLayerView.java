package com.baidu.live.tieba.personextra;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
/* loaded from: classes6.dex */
public class EditHeadsImageTopLayerView extends View {
    private Paint aob;
    private Paint aoc;
    private int aod;
    private int aoe;
    private float aof;
    private float aog;
    private int aoh;

    public EditHeadsImageTopLayerView(Context context) {
        super(context);
        this.aob = null;
        this.aoc = null;
        this.aod = 0;
        this.aoe = 0;
        this.aof = 0.42857143f;
        this.aog = 1.0f;
        this.aoh = 1;
        init();
    }

    public EditHeadsImageTopLayerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aob = null;
        this.aoc = null;
        this.aod = 0;
        this.aoe = 0;
        this.aof = 0.42857143f;
        this.aog = 1.0f;
        this.aoh = 1;
        init();
    }

    public EditHeadsImageTopLayerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aob = null;
        this.aoc = null;
        this.aod = 0;
        this.aoe = 0;
        this.aof = 0.42857143f;
        this.aog = 1.0f;
        this.aoh = 1;
        init();
    }

    private void init() {
        this.aob = new Paint();
        this.aob.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.aob.setAlpha(153);
        this.aoc = new Paint();
        this.aoc.setStyle(Paint.Style.STROKE);
        this.aoc.setColor(-1);
    }

    public void setLinePaintColor(int i) {
        if (this.aoc != null) {
            this.aoc.setColor(i);
        }
        invalidate();
    }

    public void setLineWidth(int i) {
        this.aoh = i;
        if (this.aoc != null) {
            this.aoc.setStrokeWidth(i);
        }
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.save();
        super.onDraw(canvas);
        canvas.restore();
        canvas.drawRect(0.0f, 0.0f, getWidth(), this.aod, this.aob);
        canvas.drawRect(0.0f, getHeight() - this.aoe, getWidth(), getHeight(), this.aob);
        canvas.drawRect(1.0f, this.aod, getWidth() - 1, getHeight() - this.aoe, this.aoc);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        float width = this.aog * getWidth();
        if (width > getHeight()) {
            width = getHeight();
        }
        this.aod = (int) (((i4 - i2) - width) * this.aof);
        this.aoe = (int) (((i4 - i2) - width) * (1.0f - this.aof));
    }

    public void setCutImageHeightScale(float f) {
        this.aog = f;
        invalidate();
    }
}
