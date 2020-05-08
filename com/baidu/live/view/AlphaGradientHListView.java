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
    private Paint aNV;
    private int aXU;
    private int baA;
    private int baB;
    private int bay;
    private int baz;

    public AlphaGradientHListView(Context context) {
        super(context);
        this.aXU = 0;
        this.baz = 0;
        this.baA = -1;
        this.baB = -1;
        init();
    }

    public AlphaGradientHListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aXU = 0;
        this.baz = 0;
        this.baA = -1;
        this.baB = -1;
        init();
    }

    public AlphaGradientHListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aXU = 0;
        this.baz = 0;
        this.baA = -1;
        this.baB = -1;
        init();
    }

    private void init() {
        setLayerType(1, null);
    }

    public void setColor(int i, int i2) {
        this.aXU = i;
        this.baz = i2;
    }

    public void setShadowWidth(int i) {
        this.bay = i;
    }

    public void setNeedAlphaShade(boolean z) {
        if (z) {
            if (this.bay <= 0) {
                this.bay = getResources().getDimensionPixelSize(a.e.sdk_ds28);
            }
            this.aNV = new Paint();
            this.aNV.setStyle(Paint.Style.FILL_AND_STROKE);
            this.aNV.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.MULTIPLY));
        } else {
            this.bay = 0;
            this.aNV = null;
        }
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tieba.horizonallist.widget.HListView, com.baidu.live.tieba.horizonallist.widget.AbsHListView, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.aNV != null) {
            if (this.baA != getMeasuredWidth() || this.baB != getMeasuredHeight()) {
                this.aNV.setShader(new LinearGradient(getMeasuredWidth() - this.bay, 0.0f, getMeasuredWidth(), 0.0f, this.aXU, this.baz, Shader.TileMode.CLAMP));
                this.baA = getMeasuredWidth();
                this.baB = getMeasuredHeight();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tieba.horizonallist.widget.HListView, com.baidu.live.tieba.horizonallist.widget.AbsHListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.aNV != null) {
            canvas.drawRect(getMeasuredWidth() - this.bay, 0.0f, getMeasuredWidth(), getMeasuredHeight(), this.aNV);
        }
    }
}
