package com.baidu.live.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.util.AttributeSet;
import com.baidu.live.sdk.a;
import com.baidu.live.tieba.horizonallist.widget.HListView;
/* loaded from: classes3.dex */
public class AlphaGradientHListView extends HListView {
    private Paint aWJ;
    private int bkz;
    private int bnc;
    private int bnd;
    private int bne;
    private int bnf;

    public AlphaGradientHListView(Context context) {
        super(context);
        this.bkz = 0;
        this.bnd = 0;
        this.bne = -1;
        this.bnf = -1;
        init();
    }

    public AlphaGradientHListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bkz = 0;
        this.bnd = 0;
        this.bne = -1;
        this.bnf = -1;
        init();
    }

    public AlphaGradientHListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bkz = 0;
        this.bnd = 0;
        this.bne = -1;
        this.bnf = -1;
        init();
    }

    private void init() {
        setLayerType(1, null);
    }

    public void setColor(int i, int i2) {
        this.bkz = i;
        this.bnd = i2;
    }

    public void setShadowWidth(int i) {
        this.bnc = i;
    }

    public void setNeedAlphaShade(boolean z) {
        if (z) {
            if (this.bnc <= 0) {
                this.bnc = getResources().getDimensionPixelSize(a.e.sdk_ds28);
            }
            this.aWJ = new Paint();
            this.aWJ.setStyle(Paint.Style.FILL_AND_STROKE);
            this.aWJ.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.MULTIPLY));
        } else {
            this.bnc = 0;
            this.aWJ = null;
        }
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tieba.horizonallist.widget.HListView, com.baidu.live.tieba.horizonallist.widget.AbsHListView, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.aWJ != null) {
            if (this.bne != getMeasuredWidth() || this.bnf != getMeasuredHeight()) {
                this.aWJ.setShader(new LinearGradient(getMeasuredWidth() - this.bnc, 0.0f, getMeasuredWidth(), 0.0f, this.bkz, this.bnd, Shader.TileMode.CLAMP));
                this.bne = getMeasuredWidth();
                this.bnf = getMeasuredHeight();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tieba.horizonallist.widget.HListView, com.baidu.live.tieba.horizonallist.widget.AbsHListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.aWJ != null) {
            canvas.drawRect(getMeasuredWidth() - this.bnc, 0.0f, getMeasuredWidth(), getMeasuredHeight(), this.aWJ);
        }
    }
}
