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
    private int bNT;
    private int bTf;
    private int bTg;
    private Paint bqg;
    private int lastHeight;
    private int lastWidth;
    private int mDirection;

    public AlphaGradientHListView(Context context) {
        super(context);
        this.bNT = 0;
        this.bTg = 0;
        this.lastWidth = -1;
        this.lastHeight = -1;
        this.mDirection = 1;
        init();
    }

    public AlphaGradientHListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bNT = 0;
        this.bTg = 0;
        this.lastWidth = -1;
        this.lastHeight = -1;
        this.mDirection = 1;
        init();
    }

    public AlphaGradientHListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bNT = 0;
        this.bTg = 0;
        this.lastWidth = -1;
        this.lastHeight = -1;
        this.mDirection = 1;
        init();
    }

    private void init() {
        setLayerType(1, null);
    }

    public void setColor(int i, int i2) {
        this.bNT = i;
        this.bTg = i2;
    }

    public void setDirection(int i) {
        this.mDirection = i;
    }

    public void setShadowWidth(int i) {
        this.bTf = i;
    }

    public void setNeedAlphaShade(boolean z) {
        if (z) {
            if (this.bTf <= 0) {
                this.bTf = getResources().getDimensionPixelSize(a.d.sdk_ds28);
            }
            this.bqg = new Paint();
            this.bqg.setStyle(Paint.Style.FILL_AND_STROKE);
            this.bqg.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.MULTIPLY));
            if (this.mDirection == 2) {
                this.bqg.setShader(new LinearGradient(0.0f, 0.0f, this.bTf, 0.0f, this.bNT, this.bTg, Shader.TileMode.CLAMP));
            }
        } else {
            this.bTf = 0;
            this.bqg = null;
        }
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tieba.horizonallist.widget.HListView, com.baidu.live.tieba.horizonallist.widget.AbsHListView, android.view.View
    public void onMeasure(int i, int i2) {
        LinearGradient linearGradient;
        super.onMeasure(i, i2);
        if (this.bqg != null) {
            if (this.lastWidth != getMeasuredWidth() || this.lastHeight != getMeasuredHeight()) {
                if (this.mDirection == 2) {
                    linearGradient = new LinearGradient(0.0f, 0.0f, this.bTf, 0.0f, this.bNT, this.bTg, Shader.TileMode.CLAMP);
                } else {
                    linearGradient = new LinearGradient(getMeasuredWidth() - this.bTf, 0.0f, getMeasuredWidth(), 0.0f, this.bNT, this.bTg, Shader.TileMode.CLAMP);
                }
                this.bqg.setShader(linearGradient);
                this.lastWidth = getMeasuredWidth();
                this.lastHeight = getMeasuredHeight();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tieba.horizonallist.widget.HListView, com.baidu.live.tieba.horizonallist.widget.AbsHListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.bqg != null) {
            if (this.mDirection == 2) {
                canvas.drawRect(0.0f, 0.0f, this.bTf, getMeasuredHeight(), this.bqg);
            } else {
                canvas.drawRect(getMeasuredWidth() - this.bTf, 0.0f, getMeasuredWidth(), getMeasuredHeight(), this.bqg);
            }
        }
    }
}
