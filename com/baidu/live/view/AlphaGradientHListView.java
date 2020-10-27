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
    private int bAz;
    private int bFV;
    private int bFW;
    private Paint bkR;
    private int lastHeight;
    private int lastWidth;
    private int mDirection;

    public AlphaGradientHListView(Context context) {
        super(context);
        this.bAz = 0;
        this.bFW = 0;
        this.lastWidth = -1;
        this.lastHeight = -1;
        this.mDirection = 1;
        init();
    }

    public AlphaGradientHListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bAz = 0;
        this.bFW = 0;
        this.lastWidth = -1;
        this.lastHeight = -1;
        this.mDirection = 1;
        init();
    }

    public AlphaGradientHListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bAz = 0;
        this.bFW = 0;
        this.lastWidth = -1;
        this.lastHeight = -1;
        this.mDirection = 1;
        init();
    }

    private void init() {
        setLayerType(1, null);
    }

    public void setColor(int i, int i2) {
        this.bAz = i;
        this.bFW = i2;
    }

    public void setDirection(int i) {
        this.mDirection = i;
    }

    public void setShadowWidth(int i) {
        this.bFV = i;
    }

    public void setNeedAlphaShade(boolean z) {
        if (z) {
            if (this.bFV <= 0) {
                this.bFV = getResources().getDimensionPixelSize(a.e.sdk_ds28);
            }
            this.bkR = new Paint();
            this.bkR.setStyle(Paint.Style.FILL_AND_STROKE);
            this.bkR.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.MULTIPLY));
            if (this.mDirection == 2) {
                this.bkR.setShader(new LinearGradient(0.0f, 0.0f, this.bFV, 0.0f, this.bAz, this.bFW, Shader.TileMode.CLAMP));
            }
        } else {
            this.bFV = 0;
            this.bkR = null;
        }
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tieba.horizonallist.widget.HListView, com.baidu.live.tieba.horizonallist.widget.AbsHListView, android.view.View
    public void onMeasure(int i, int i2) {
        LinearGradient linearGradient;
        super.onMeasure(i, i2);
        if (this.bkR != null) {
            if (this.lastWidth != getMeasuredWidth() || this.lastHeight != getMeasuredHeight()) {
                if (this.mDirection == 2) {
                    linearGradient = new LinearGradient(0.0f, 0.0f, this.bFV, 0.0f, this.bAz, this.bFW, Shader.TileMode.CLAMP);
                } else {
                    linearGradient = new LinearGradient(getMeasuredWidth() - this.bFV, 0.0f, getMeasuredWidth(), 0.0f, this.bAz, this.bFW, Shader.TileMode.CLAMP);
                }
                this.bkR.setShader(linearGradient);
                this.lastWidth = getMeasuredWidth();
                this.lastHeight = getMeasuredHeight();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tieba.horizonallist.widget.HListView, com.baidu.live.tieba.horizonallist.widget.AbsHListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.bkR != null) {
            if (this.mDirection == 2) {
                canvas.drawRect(0.0f, 0.0f, this.bFV, getMeasuredHeight(), this.bkR);
            } else {
                canvas.drawRect(getMeasuredWidth() - this.bFV, 0.0f, getMeasuredWidth(), getMeasuredHeight(), this.bkR);
            }
        }
    }
}
