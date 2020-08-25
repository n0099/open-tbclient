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
    private Paint bcS;
    private int bqz;
    private int btc;
    private int btd;
    private int lastHeight;
    private int lastWidth;
    private int mDirection;

    public AlphaGradientHListView(Context context) {
        super(context);
        this.bqz = 0;
        this.btd = 0;
        this.lastWidth = -1;
        this.lastHeight = -1;
        this.mDirection = 1;
        init();
    }

    public AlphaGradientHListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bqz = 0;
        this.btd = 0;
        this.lastWidth = -1;
        this.lastHeight = -1;
        this.mDirection = 1;
        init();
    }

    public AlphaGradientHListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bqz = 0;
        this.btd = 0;
        this.lastWidth = -1;
        this.lastHeight = -1;
        this.mDirection = 1;
        init();
    }

    private void init() {
        setLayerType(1, null);
    }

    public void setColor(int i, int i2) {
        this.bqz = i;
        this.btd = i2;
    }

    public void setDirection(int i) {
        this.mDirection = i;
    }

    public void setShadowWidth(int i) {
        this.btc = i;
    }

    public void setNeedAlphaShade(boolean z) {
        if (z) {
            if (this.btc <= 0) {
                this.btc = getResources().getDimensionPixelSize(a.e.sdk_ds28);
            }
            this.bcS = new Paint();
            this.bcS.setStyle(Paint.Style.FILL_AND_STROKE);
            this.bcS.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.MULTIPLY));
            if (this.mDirection == 2) {
                this.bcS.setShader(new LinearGradient(0.0f, 0.0f, this.btc, 0.0f, this.bqz, this.btd, Shader.TileMode.CLAMP));
            }
        } else {
            this.btc = 0;
            this.bcS = null;
        }
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tieba.horizonallist.widget.HListView, com.baidu.live.tieba.horizonallist.widget.AbsHListView, android.view.View
    public void onMeasure(int i, int i2) {
        LinearGradient linearGradient;
        super.onMeasure(i, i2);
        if (this.bcS != null) {
            if (this.lastWidth != getMeasuredWidth() || this.lastHeight != getMeasuredHeight()) {
                if (this.mDirection == 2) {
                    linearGradient = new LinearGradient(0.0f, 0.0f, this.btc, 0.0f, this.bqz, this.btd, Shader.TileMode.CLAMP);
                } else {
                    linearGradient = new LinearGradient(getMeasuredWidth() - this.btc, 0.0f, getMeasuredWidth(), 0.0f, this.bqz, this.btd, Shader.TileMode.CLAMP);
                }
                this.bcS.setShader(linearGradient);
                this.lastWidth = getMeasuredWidth();
                this.lastHeight = getMeasuredHeight();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tieba.horizonallist.widget.HListView, com.baidu.live.tieba.horizonallist.widget.AbsHListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.bcS != null) {
            if (this.mDirection == 2) {
                canvas.drawRect(0.0f, 0.0f, this.btc, getMeasuredHeight(), this.bcS);
            } else {
                canvas.drawRect(getMeasuredWidth() - this.btc, 0.0f, getMeasuredWidth(), getMeasuredHeight(), this.bcS);
            }
        }
    }
}
