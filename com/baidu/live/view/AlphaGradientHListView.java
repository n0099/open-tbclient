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
    private int aDN;
    private int aEw;
    private int aEx;
    private int aEy;
    private int aEz;
    private Paint auf;

    public AlphaGradientHListView(Context context) {
        super(context);
        this.aDN = 0;
        this.aEx = 0;
        this.aEy = -1;
        this.aEz = -1;
        init();
    }

    public AlphaGradientHListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aDN = 0;
        this.aEx = 0;
        this.aEy = -1;
        this.aEz = -1;
        init();
    }

    public AlphaGradientHListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aDN = 0;
        this.aEx = 0;
        this.aEy = -1;
        this.aEz = -1;
        init();
    }

    private void init() {
        setLayerType(1, null);
    }

    public void setColor(int i, int i2) {
        this.aDN = i;
        this.aEx = i2;
    }

    public void setShadowWidth(int i) {
        this.aEw = i;
    }

    public void setNeedAlphaShade(boolean z) {
        if (z) {
            if (this.aEw <= 0) {
                this.aEw = getResources().getDimensionPixelSize(a.e.sdk_ds28);
            }
            this.auf = new Paint();
            this.auf.setStyle(Paint.Style.FILL_AND_STROKE);
            this.auf.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.MULTIPLY));
        } else {
            this.aEw = 0;
            this.auf = null;
        }
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tieba.horizonallist.widget.HListView, com.baidu.live.tieba.horizonallist.widget.AbsHListView, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.auf != null) {
            if (this.aEy != getMeasuredWidth() || this.aEz != getMeasuredHeight()) {
                this.auf.setShader(new LinearGradient(getMeasuredWidth() - this.aEw, 0.0f, getMeasuredWidth(), 0.0f, this.aDN, this.aEx, Shader.TileMode.CLAMP));
                this.aEy = getMeasuredWidth();
                this.aEz = getMeasuredHeight();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tieba.horizonallist.widget.HListView, com.baidu.live.tieba.horizonallist.widget.AbsHListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.auf != null) {
            canvas.drawRect(getMeasuredWidth() - this.aEw, 0.0f, getMeasuredWidth(), getMeasuredHeight(), this.auf);
        }
    }
}
