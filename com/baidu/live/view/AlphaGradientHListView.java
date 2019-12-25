package com.baidu.live.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.util.AttributeSet;
import com.baidu.live.q.a;
import com.baidu.live.tieba.horizonallist.widget.HListView;
/* loaded from: classes2.dex */
public class AlphaGradientHListView extends HListView {
    private Paint apJ;
    private int ayM;
    private int azw;
    private int azx;
    private int azy;
    private int azz;

    public AlphaGradientHListView(Context context) {
        super(context);
        this.ayM = 0;
        this.azx = 0;
        this.azy = -1;
        this.azz = -1;
        init();
    }

    public AlphaGradientHListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ayM = 0;
        this.azx = 0;
        this.azy = -1;
        this.azz = -1;
        init();
    }

    public AlphaGradientHListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ayM = 0;
        this.azx = 0;
        this.azy = -1;
        this.azz = -1;
        init();
    }

    private void init() {
        setLayerType(1, null);
    }

    public void setColor(int i, int i2) {
        this.ayM = i;
        this.azx = i2;
    }

    public void setShadowWidth(int i) {
        this.azw = i;
    }

    public void setNeedAlphaShade(boolean z) {
        if (z) {
            if (this.azw <= 0) {
                this.azw = getResources().getDimensionPixelSize(a.e.sdk_ds28);
            }
            this.apJ = new Paint();
            this.apJ.setStyle(Paint.Style.FILL_AND_STROKE);
            this.apJ.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.MULTIPLY));
        } else {
            this.azw = 0;
            this.apJ = null;
        }
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tieba.horizonallist.widget.HListView, com.baidu.live.tieba.horizonallist.widget.AbsHListView, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.apJ != null) {
            if (this.azy != getMeasuredWidth() || this.azz != getMeasuredHeight()) {
                this.apJ.setShader(new LinearGradient(getMeasuredWidth() - this.azw, 0.0f, getMeasuredWidth(), 0.0f, this.ayM, this.azx, Shader.TileMode.CLAMP));
                this.azy = getMeasuredWidth();
                this.azz = getMeasuredHeight();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tieba.horizonallist.widget.HListView, com.baidu.live.tieba.horizonallist.widget.AbsHListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.apJ != null) {
            canvas.drawRect(getMeasuredWidth() - this.azw, 0.0f, getMeasuredWidth(), getMeasuredHeight(), this.apJ);
        }
    }
}
