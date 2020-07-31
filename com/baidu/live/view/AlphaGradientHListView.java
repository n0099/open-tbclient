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
/* loaded from: classes4.dex */
public class AlphaGradientHListView extends HListView {
    private Paint aXC;
    private int bkT;
    private int bnA;
    private int bnx;
    private int bny;
    private int bnz;

    public AlphaGradientHListView(Context context) {
        super(context);
        this.bkT = 0;
        this.bny = 0;
        this.bnz = -1;
        this.bnA = -1;
        init();
    }

    public AlphaGradientHListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bkT = 0;
        this.bny = 0;
        this.bnz = -1;
        this.bnA = -1;
        init();
    }

    public AlphaGradientHListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bkT = 0;
        this.bny = 0;
        this.bnz = -1;
        this.bnA = -1;
        init();
    }

    private void init() {
        setLayerType(1, null);
    }

    public void setColor(int i, int i2) {
        this.bkT = i;
        this.bny = i2;
    }

    public void setShadowWidth(int i) {
        this.bnx = i;
    }

    public void setNeedAlphaShade(boolean z) {
        if (z) {
            if (this.bnx <= 0) {
                this.bnx = getResources().getDimensionPixelSize(a.e.sdk_ds28);
            }
            this.aXC = new Paint();
            this.aXC.setStyle(Paint.Style.FILL_AND_STROKE);
            this.aXC.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.MULTIPLY));
        } else {
            this.bnx = 0;
            this.aXC = null;
        }
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tieba.horizonallist.widget.HListView, com.baidu.live.tieba.horizonallist.widget.AbsHListView, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.aXC != null) {
            if (this.bnz != getMeasuredWidth() || this.bnA != getMeasuredHeight()) {
                this.aXC.setShader(new LinearGradient(getMeasuredWidth() - this.bnx, 0.0f, getMeasuredWidth(), 0.0f, this.bkT, this.bny, Shader.TileMode.CLAMP));
                this.bnz = getMeasuredWidth();
                this.bnA = getMeasuredHeight();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tieba.horizonallist.widget.HListView, com.baidu.live.tieba.horizonallist.widget.AbsHListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.aXC != null) {
            canvas.drawRect(getMeasuredWidth() - this.bnx, 0.0f, getMeasuredWidth(), getMeasuredHeight(), this.aXC);
        }
    }
}
