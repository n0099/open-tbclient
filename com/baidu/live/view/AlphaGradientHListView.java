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
/* loaded from: classes11.dex */
public class AlphaGradientHListView extends HListView {
    private int bOV;
    private int bUb;
    private int bUc;
    private Paint brr;
    private int lastHeight;
    private int lastWidth;
    private int mDirection;

    public AlphaGradientHListView(Context context) {
        super(context);
        this.bOV = 0;
        this.bUc = 0;
        this.lastWidth = -1;
        this.lastHeight = -1;
        this.mDirection = 1;
        init();
    }

    public AlphaGradientHListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bOV = 0;
        this.bUc = 0;
        this.lastWidth = -1;
        this.lastHeight = -1;
        this.mDirection = 1;
        init();
    }

    public AlphaGradientHListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bOV = 0;
        this.bUc = 0;
        this.lastWidth = -1;
        this.lastHeight = -1;
        this.mDirection = 1;
        init();
    }

    private void init() {
        setLayerType(1, null);
    }

    public void setColor(int i, int i2) {
        this.bOV = i;
        this.bUc = i2;
    }

    public void setDirection(int i) {
        this.mDirection = i;
    }

    public void setShadowWidth(int i) {
        this.bUb = i;
    }

    public void setNeedAlphaShade(boolean z) {
        if (z) {
            if (this.bUb <= 0) {
                this.bUb = getResources().getDimensionPixelSize(a.d.sdk_ds28);
            }
            this.brr = new Paint();
            this.brr.setStyle(Paint.Style.FILL_AND_STROKE);
            this.brr.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.MULTIPLY));
            if (this.mDirection == 2) {
                this.brr.setShader(new LinearGradient(0.0f, 0.0f, this.bUb, 0.0f, this.bOV, this.bUc, Shader.TileMode.CLAMP));
            }
        } else {
            this.bUb = 0;
            this.brr = null;
        }
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tieba.horizonallist.widget.HListView, com.baidu.live.tieba.horizonallist.widget.AbsHListView, android.view.View
    public void onMeasure(int i, int i2) {
        LinearGradient linearGradient;
        super.onMeasure(i, i2);
        if (this.brr != null) {
            if (this.lastWidth != getMeasuredWidth() || this.lastHeight != getMeasuredHeight()) {
                if (this.mDirection == 2) {
                    linearGradient = new LinearGradient(0.0f, 0.0f, this.bUb, 0.0f, this.bOV, this.bUc, Shader.TileMode.CLAMP);
                } else {
                    linearGradient = new LinearGradient(getMeasuredWidth() - this.bUb, 0.0f, getMeasuredWidth(), 0.0f, this.bOV, this.bUc, Shader.TileMode.CLAMP);
                }
                this.brr.setShader(linearGradient);
                this.lastWidth = getMeasuredWidth();
                this.lastHeight = getMeasuredHeight();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tieba.horizonallist.widget.HListView, com.baidu.live.tieba.horizonallist.widget.AbsHListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.brr != null) {
            if (this.mDirection == 2) {
                canvas.drawRect(0.0f, 0.0f, this.bUb, getMeasuredHeight(), this.brr);
            } else {
                canvas.drawRect(getMeasuredWidth() - this.bUb, 0.0f, getMeasuredWidth(), getMeasuredHeight(), this.brr);
            }
        }
    }
}
