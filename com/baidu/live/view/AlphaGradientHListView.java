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
/* loaded from: classes7.dex */
public class AlphaGradientHListView extends HListView {
    private Paint bcU;
    private int bqC;
    private int btf;
    private int btg;
    private int lastHeight;
    private int lastWidth;
    private int mDirection;

    public AlphaGradientHListView(Context context) {
        super(context);
        this.bqC = 0;
        this.btg = 0;
        this.lastWidth = -1;
        this.lastHeight = -1;
        this.mDirection = 1;
        init();
    }

    public AlphaGradientHListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bqC = 0;
        this.btg = 0;
        this.lastWidth = -1;
        this.lastHeight = -1;
        this.mDirection = 1;
        init();
    }

    public AlphaGradientHListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bqC = 0;
        this.btg = 0;
        this.lastWidth = -1;
        this.lastHeight = -1;
        this.mDirection = 1;
        init();
    }

    private void init() {
        setLayerType(1, null);
    }

    public void setColor(int i, int i2) {
        this.bqC = i;
        this.btg = i2;
    }

    public void setDirection(int i) {
        this.mDirection = i;
    }

    public void setShadowWidth(int i) {
        this.btf = i;
    }

    public void setNeedAlphaShade(boolean z) {
        if (z) {
            if (this.btf <= 0) {
                this.btf = getResources().getDimensionPixelSize(a.e.sdk_ds28);
            }
            this.bcU = new Paint();
            this.bcU.setStyle(Paint.Style.FILL_AND_STROKE);
            this.bcU.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.MULTIPLY));
            if (this.mDirection == 2) {
                this.bcU.setShader(new LinearGradient(0.0f, 0.0f, this.btf, 0.0f, this.bqC, this.btg, Shader.TileMode.CLAMP));
            }
        } else {
            this.btf = 0;
            this.bcU = null;
        }
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tieba.horizonallist.widget.HListView, com.baidu.live.tieba.horizonallist.widget.AbsHListView, android.view.View
    public void onMeasure(int i, int i2) {
        LinearGradient linearGradient;
        super.onMeasure(i, i2);
        if (this.bcU != null) {
            if (this.lastWidth != getMeasuredWidth() || this.lastHeight != getMeasuredHeight()) {
                if (this.mDirection == 2) {
                    linearGradient = new LinearGradient(0.0f, 0.0f, this.btf, 0.0f, this.bqC, this.btg, Shader.TileMode.CLAMP);
                } else {
                    linearGradient = new LinearGradient(getMeasuredWidth() - this.btf, 0.0f, getMeasuredWidth(), 0.0f, this.bqC, this.btg, Shader.TileMode.CLAMP);
                }
                this.bcU.setShader(linearGradient);
                this.lastWidth = getMeasuredWidth();
                this.lastHeight = getMeasuredHeight();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tieba.horizonallist.widget.HListView, com.baidu.live.tieba.horizonallist.widget.AbsHListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.bcU != null) {
            if (this.mDirection == 2) {
                canvas.drawRect(0.0f, 0.0f, this.btf, getMeasuredHeight(), this.bcU);
            } else {
                canvas.drawRect(getMeasuredWidth() - this.btf, 0.0f, getMeasuredWidth(), getMeasuredHeight(), this.bcU);
            }
        }
    }
}
