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
    private int aEM;
    private int aEN;
    private int aEO;
    private int aEP;
    private int aEd;
    private Paint auq;

    public AlphaGradientHListView(Context context) {
        super(context);
        this.aEd = 0;
        this.aEN = 0;
        this.aEO = -1;
        this.aEP = -1;
        init();
    }

    public AlphaGradientHListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aEd = 0;
        this.aEN = 0;
        this.aEO = -1;
        this.aEP = -1;
        init();
    }

    public AlphaGradientHListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aEd = 0;
        this.aEN = 0;
        this.aEO = -1;
        this.aEP = -1;
        init();
    }

    private void init() {
        setLayerType(1, null);
    }

    public void setColor(int i, int i2) {
        this.aEd = i;
        this.aEN = i2;
    }

    public void setShadowWidth(int i) {
        this.aEM = i;
    }

    public void setNeedAlphaShade(boolean z) {
        if (z) {
            if (this.aEM <= 0) {
                this.aEM = getResources().getDimensionPixelSize(a.e.sdk_ds28);
            }
            this.auq = new Paint();
            this.auq.setStyle(Paint.Style.FILL_AND_STROKE);
            this.auq.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.MULTIPLY));
        } else {
            this.aEM = 0;
            this.auq = null;
        }
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tieba.horizonallist.widget.HListView, com.baidu.live.tieba.horizonallist.widget.AbsHListView, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.auq != null) {
            if (this.aEO != getMeasuredWidth() || this.aEP != getMeasuredHeight()) {
                this.auq.setShader(new LinearGradient(getMeasuredWidth() - this.aEM, 0.0f, getMeasuredWidth(), 0.0f, this.aEd, this.aEN, Shader.TileMode.CLAMP));
                this.aEO = getMeasuredWidth();
                this.aEP = getMeasuredHeight();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tieba.horizonallist.widget.HListView, com.baidu.live.tieba.horizonallist.widget.AbsHListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.auq != null) {
            canvas.drawRect(getMeasuredWidth() - this.aEM, 0.0f, getMeasuredWidth(), getMeasuredHeight(), this.auq);
        }
    }
}
