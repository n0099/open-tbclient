package com.baidu.live.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.util.AttributeSet;
import com.baidu.live.r.a;
import com.baidu.live.tieba.horizonallist.widget.HListView;
/* loaded from: classes2.dex */
public class AlphaGradientHListView extends HListView {
    private int aAg;
    private int aAh;
    private int aAi;
    private int aAj;
    private Paint aqv;
    private int azx;

    public AlphaGradientHListView(Context context) {
        super(context);
        this.azx = 0;
        this.aAh = 0;
        this.aAi = -1;
        this.aAj = -1;
        init();
    }

    public AlphaGradientHListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.azx = 0;
        this.aAh = 0;
        this.aAi = -1;
        this.aAj = -1;
        init();
    }

    public AlphaGradientHListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.azx = 0;
        this.aAh = 0;
        this.aAi = -1;
        this.aAj = -1;
        init();
    }

    private void init() {
        setLayerType(1, null);
    }

    public void setColor(int i, int i2) {
        this.azx = i;
        this.aAh = i2;
    }

    public void setShadowWidth(int i) {
        this.aAg = i;
    }

    public void setNeedAlphaShade(boolean z) {
        if (z) {
            if (this.aAg <= 0) {
                this.aAg = getResources().getDimensionPixelSize(a.e.sdk_ds28);
            }
            this.aqv = new Paint();
            this.aqv.setStyle(Paint.Style.FILL_AND_STROKE);
            this.aqv.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.MULTIPLY));
        } else {
            this.aAg = 0;
            this.aqv = null;
        }
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tieba.horizonallist.widget.HListView, com.baidu.live.tieba.horizonallist.widget.AbsHListView, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.aqv != null) {
            if (this.aAi != getMeasuredWidth() || this.aAj != getMeasuredHeight()) {
                this.aqv.setShader(new LinearGradient(getMeasuredWidth() - this.aAg, 0.0f, getMeasuredWidth(), 0.0f, this.azx, this.aAh, Shader.TileMode.CLAMP));
                this.aAi = getMeasuredWidth();
                this.aAj = getMeasuredHeight();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tieba.horizonallist.widget.HListView, com.baidu.live.tieba.horizonallist.widget.AbsHListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.aqv != null) {
            canvas.drawRect(getMeasuredWidth() - this.aAg, 0.0f, getMeasuredWidth(), getMeasuredHeight(), this.aqv);
        }
    }
}
