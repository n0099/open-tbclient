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
    private int bGK;
    private int bLA;
    private int bLB;
    private Paint bml;
    private int lastHeight;
    private int lastWidth;
    private int mDirection;

    public AlphaGradientHListView(Context context) {
        super(context);
        this.bGK = 0;
        this.bLB = 0;
        this.lastWidth = -1;
        this.lastHeight = -1;
        this.mDirection = 1;
        init();
    }

    public AlphaGradientHListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bGK = 0;
        this.bLB = 0;
        this.lastWidth = -1;
        this.lastHeight = -1;
        this.mDirection = 1;
        init();
    }

    public AlphaGradientHListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bGK = 0;
        this.bLB = 0;
        this.lastWidth = -1;
        this.lastHeight = -1;
        this.mDirection = 1;
        init();
    }

    private void init() {
        setLayerType(1, null);
    }

    public void setColor(int i, int i2) {
        this.bGK = i;
        this.bLB = i2;
    }

    public void setDirection(int i) {
        this.mDirection = i;
    }

    public void setShadowWidth(int i) {
        this.bLA = i;
    }

    public void setNeedAlphaShade(boolean z) {
        if (z) {
            if (this.bLA <= 0) {
                this.bLA = getResources().getDimensionPixelSize(a.d.sdk_ds28);
            }
            this.bml = new Paint();
            this.bml.setStyle(Paint.Style.FILL_AND_STROKE);
            this.bml.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.MULTIPLY));
            if (this.mDirection == 2) {
                this.bml.setShader(new LinearGradient(0.0f, 0.0f, this.bLA, 0.0f, this.bGK, this.bLB, Shader.TileMode.CLAMP));
            }
        } else {
            this.bLA = 0;
            this.bml = null;
        }
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tieba.horizonallist.widget.HListView, com.baidu.live.tieba.horizonallist.widget.AbsHListView, android.view.View
    public void onMeasure(int i, int i2) {
        LinearGradient linearGradient;
        super.onMeasure(i, i2);
        if (this.bml != null) {
            if (this.lastWidth != getMeasuredWidth() || this.lastHeight != getMeasuredHeight()) {
                if (this.mDirection == 2) {
                    linearGradient = new LinearGradient(0.0f, 0.0f, this.bLA, 0.0f, this.bGK, this.bLB, Shader.TileMode.CLAMP);
                } else {
                    linearGradient = new LinearGradient(getMeasuredWidth() - this.bLA, 0.0f, getMeasuredWidth(), 0.0f, this.bGK, this.bLB, Shader.TileMode.CLAMP);
                }
                this.bml.setShader(linearGradient);
                this.lastWidth = getMeasuredWidth();
                this.lastHeight = getMeasuredHeight();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tieba.horizonallist.widget.HListView, com.baidu.live.tieba.horizonallist.widget.AbsHListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.bml != null) {
            if (this.mDirection == 2) {
                canvas.drawRect(0.0f, 0.0f, this.bLA, getMeasuredHeight(), this.bml);
            } else {
                canvas.drawRect(getMeasuredWidth() - this.bLA, 0.0f, getMeasuredWidth(), getMeasuredHeight(), this.bml);
            }
        }
    }
}
