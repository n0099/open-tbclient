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
    private Paint aNP;
    private int aXP;
    private int bat;
    private int bau;
    private int bav;
    private int baw;

    public AlphaGradientHListView(Context context) {
        super(context);
        this.aXP = 0;
        this.bau = 0;
        this.bav = -1;
        this.baw = -1;
        init();
    }

    public AlphaGradientHListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aXP = 0;
        this.bau = 0;
        this.bav = -1;
        this.baw = -1;
        init();
    }

    public AlphaGradientHListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aXP = 0;
        this.bau = 0;
        this.bav = -1;
        this.baw = -1;
        init();
    }

    private void init() {
        setLayerType(1, null);
    }

    public void setColor(int i, int i2) {
        this.aXP = i;
        this.bau = i2;
    }

    public void setShadowWidth(int i) {
        this.bat = i;
    }

    public void setNeedAlphaShade(boolean z) {
        if (z) {
            if (this.bat <= 0) {
                this.bat = getResources().getDimensionPixelSize(a.e.sdk_ds28);
            }
            this.aNP = new Paint();
            this.aNP.setStyle(Paint.Style.FILL_AND_STROKE);
            this.aNP.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.MULTIPLY));
        } else {
            this.bat = 0;
            this.aNP = null;
        }
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tieba.horizonallist.widget.HListView, com.baidu.live.tieba.horizonallist.widget.AbsHListView, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.aNP != null) {
            if (this.bav != getMeasuredWidth() || this.baw != getMeasuredHeight()) {
                this.aNP.setShader(new LinearGradient(getMeasuredWidth() - this.bat, 0.0f, getMeasuredWidth(), 0.0f, this.aXP, this.bau, Shader.TileMode.CLAMP));
                this.bav = getMeasuredWidth();
                this.baw = getMeasuredHeight();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tieba.horizonallist.widget.HListView, com.baidu.live.tieba.horizonallist.widget.AbsHListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.aNP != null) {
            canvas.drawRect(getMeasuredWidth() - this.bat, 0.0f, getMeasuredWidth(), getMeasuredHeight(), this.aNP);
        }
    }
}
