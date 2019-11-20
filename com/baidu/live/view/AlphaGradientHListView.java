package com.baidu.live.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.util.AttributeSet;
import com.baidu.live.k.a;
import com.baidu.live.tieba.horizonallist.widget.HListView;
/* loaded from: classes6.dex */
public class AlphaGradientHListView extends HListView {
    private Paint ahF;
    private int arM;
    private int arN;
    private int arO;
    private int arP;
    private int arb;

    public AlphaGradientHListView(Context context) {
        super(context);
        this.arb = 0;
        this.arN = 0;
        this.arO = -1;
        this.arP = -1;
        init();
    }

    public AlphaGradientHListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.arb = 0;
        this.arN = 0;
        this.arO = -1;
        this.arP = -1;
        init();
    }

    public AlphaGradientHListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.arb = 0;
        this.arN = 0;
        this.arO = -1;
        this.arP = -1;
        init();
    }

    private void init() {
        setLayerType(1, null);
    }

    public void setColor(int i, int i2) {
        this.arb = i;
        this.arN = i2;
    }

    public void setShadowWidth(int i) {
        this.arM = i;
    }

    public void setNeedAlphaShade(boolean z) {
        if (z) {
            if (this.arM <= 0) {
                this.arM = getResources().getDimensionPixelSize(a.e.sdk_ds28);
            }
            this.ahF = new Paint();
            this.ahF.setStyle(Paint.Style.FILL_AND_STROKE);
            this.ahF.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.MULTIPLY));
        } else {
            this.arM = 0;
            this.ahF = null;
        }
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tieba.horizonallist.widget.HListView, com.baidu.live.tieba.horizonallist.widget.AbsHListView, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.ahF != null) {
            if (this.arO != getMeasuredWidth() || this.arP != getMeasuredHeight()) {
                this.ahF.setShader(new LinearGradient(getMeasuredWidth() - this.arM, 0.0f, getMeasuredWidth(), 0.0f, this.arb, this.arN, Shader.TileMode.CLAMP));
                this.arO = getMeasuredWidth();
                this.arP = getMeasuredHeight();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tieba.horizonallist.widget.HListView, com.baidu.live.tieba.horizonallist.widget.AbsHListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.ahF != null) {
            canvas.drawRect(getMeasuredWidth() - this.arM, 0.0f, getMeasuredWidth(), getMeasuredHeight(), this.ahF);
        }
    }
}
