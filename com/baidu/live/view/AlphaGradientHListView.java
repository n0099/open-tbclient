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
    private Paint aUc;
    private int bfp;
    private int bhV;
    private int bhW;
    private int bhX;
    private int bhY;

    public AlphaGradientHListView(Context context) {
        super(context);
        this.bfp = 0;
        this.bhW = 0;
        this.bhX = -1;
        this.bhY = -1;
        init();
    }

    public AlphaGradientHListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bfp = 0;
        this.bhW = 0;
        this.bhX = -1;
        this.bhY = -1;
        init();
    }

    public AlphaGradientHListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bfp = 0;
        this.bhW = 0;
        this.bhX = -1;
        this.bhY = -1;
        init();
    }

    private void init() {
        setLayerType(1, null);
    }

    public void setColor(int i, int i2) {
        this.bfp = i;
        this.bhW = i2;
    }

    public void setShadowWidth(int i) {
        this.bhV = i;
    }

    public void setNeedAlphaShade(boolean z) {
        if (z) {
            if (this.bhV <= 0) {
                this.bhV = getResources().getDimensionPixelSize(a.e.sdk_ds28);
            }
            this.aUc = new Paint();
            this.aUc.setStyle(Paint.Style.FILL_AND_STROKE);
            this.aUc.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.MULTIPLY));
        } else {
            this.bhV = 0;
            this.aUc = null;
        }
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tieba.horizonallist.widget.HListView, com.baidu.live.tieba.horizonallist.widget.AbsHListView, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.aUc != null) {
            if (this.bhX != getMeasuredWidth() || this.bhY != getMeasuredHeight()) {
                this.aUc.setShader(new LinearGradient(getMeasuredWidth() - this.bhV, 0.0f, getMeasuredWidth(), 0.0f, this.bfp, this.bhW, Shader.TileMode.CLAMP));
                this.bhX = getMeasuredWidth();
                this.bhY = getMeasuredHeight();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tieba.horizonallist.widget.HListView, com.baidu.live.tieba.horizonallist.widget.AbsHListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.aUc != null) {
            canvas.drawRect(getMeasuredWidth() - this.bhV, 0.0f, getMeasuredWidth(), getMeasuredHeight(), this.aUc);
        }
    }
}
