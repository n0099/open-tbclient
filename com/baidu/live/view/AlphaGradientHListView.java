package com.baidu.live.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.util.AttributeSet;
import com.baidu.live.tieba.horizonallist.widget.HListView;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class AlphaGradientHListView extends HListView {
    private int aDP;
    private int aEA;
    private int aEB;
    private int aEy;
    private int aEz;
    private Paint aug;

    public AlphaGradientHListView(Context context) {
        super(context);
        this.aDP = 0;
        this.aEz = 0;
        this.aEA = -1;
        this.aEB = -1;
        init();
    }

    public AlphaGradientHListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aDP = 0;
        this.aEz = 0;
        this.aEA = -1;
        this.aEB = -1;
        init();
    }

    public AlphaGradientHListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aDP = 0;
        this.aEz = 0;
        this.aEA = -1;
        this.aEB = -1;
        init();
    }

    private void init() {
        setLayerType(1, null);
    }

    public void setColor(int i, int i2) {
        this.aDP = i;
        this.aEz = i2;
    }

    public void setShadowWidth(int i) {
        this.aEy = i;
    }

    public void setNeedAlphaShade(boolean z) {
        if (z) {
            if (this.aEy <= 0) {
                this.aEy = getResources().getDimensionPixelSize(a.e.sdk_ds28);
            }
            this.aug = new Paint();
            this.aug.setStyle(Paint.Style.FILL_AND_STROKE);
            this.aug.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.MULTIPLY));
        } else {
            this.aEy = 0;
            this.aug = null;
        }
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tieba.horizonallist.widget.HListView, com.baidu.live.tieba.horizonallist.widget.AbsHListView, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.aug != null) {
            if (this.aEA != getMeasuredWidth() || this.aEB != getMeasuredHeight()) {
                this.aug.setShader(new LinearGradient(getMeasuredWidth() - this.aEy, 0.0f, getMeasuredWidth(), 0.0f, this.aDP, this.aEz, Shader.TileMode.CLAMP));
                this.aEA = getMeasuredWidth();
                this.aEB = getMeasuredHeight();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tieba.horizonallist.widget.HListView, com.baidu.live.tieba.horizonallist.widget.AbsHListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.aug != null) {
            canvas.drawRect(getMeasuredWidth() - this.aEy, 0.0f, getMeasuredWidth(), getMeasuredHeight(), this.aug);
        }
    }
}
