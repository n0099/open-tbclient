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
    private int bKi;
    private int bOX;
    private int bOY;
    private Paint bpJ;
    private int lastHeight;
    private int lastWidth;
    private int mDirection;

    public AlphaGradientHListView(Context context) {
        super(context);
        this.bKi = 0;
        this.bOY = 0;
        this.lastWidth = -1;
        this.lastHeight = -1;
        this.mDirection = 1;
        init();
    }

    public AlphaGradientHListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bKi = 0;
        this.bOY = 0;
        this.lastWidth = -1;
        this.lastHeight = -1;
        this.mDirection = 1;
        init();
    }

    public AlphaGradientHListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bKi = 0;
        this.bOY = 0;
        this.lastWidth = -1;
        this.lastHeight = -1;
        this.mDirection = 1;
        init();
    }

    private void init() {
        setLayerType(1, null);
    }

    public void setColor(int i, int i2) {
        this.bKi = i;
        this.bOY = i2;
    }

    public void setDirection(int i) {
        this.mDirection = i;
    }

    public void setShadowWidth(int i) {
        this.bOX = i;
    }

    public void setNeedAlphaShade(boolean z) {
        if (z) {
            if (this.bOX <= 0) {
                this.bOX = getResources().getDimensionPixelSize(a.d.sdk_ds28);
            }
            this.bpJ = new Paint();
            this.bpJ.setStyle(Paint.Style.FILL_AND_STROKE);
            this.bpJ.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.MULTIPLY));
            if (this.mDirection == 2) {
                this.bpJ.setShader(new LinearGradient(0.0f, 0.0f, this.bOX, 0.0f, this.bKi, this.bOY, Shader.TileMode.CLAMP));
            }
        } else {
            this.bOX = 0;
            this.bpJ = null;
        }
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tieba.horizonallist.widget.HListView, com.baidu.live.tieba.horizonallist.widget.AbsHListView, android.view.View
    public void onMeasure(int i, int i2) {
        LinearGradient linearGradient;
        super.onMeasure(i, i2);
        if (this.bpJ != null) {
            if (this.lastWidth != getMeasuredWidth() || this.lastHeight != getMeasuredHeight()) {
                if (this.mDirection == 2) {
                    linearGradient = new LinearGradient(0.0f, 0.0f, this.bOX, 0.0f, this.bKi, this.bOY, Shader.TileMode.CLAMP);
                } else {
                    linearGradient = new LinearGradient(getMeasuredWidth() - this.bOX, 0.0f, getMeasuredWidth(), 0.0f, this.bKi, this.bOY, Shader.TileMode.CLAMP);
                }
                this.bpJ.setShader(linearGradient);
                this.lastWidth = getMeasuredWidth();
                this.lastHeight = getMeasuredHeight();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tieba.horizonallist.widget.HListView, com.baidu.live.tieba.horizonallist.widget.AbsHListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.bpJ != null) {
            if (this.mDirection == 2) {
                canvas.drawRect(0.0f, 0.0f, this.bOX, getMeasuredHeight(), this.bpJ);
            } else {
                canvas.drawRect(getMeasuredWidth() - this.bOX, 0.0f, getMeasuredWidth(), getMeasuredHeight(), this.bpJ);
            }
        }
    }
}
