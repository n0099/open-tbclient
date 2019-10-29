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
    private Paint ahX;
    private int art;
    private int ase;
    private int asf;
    private int asg;
    private int ash;

    public AlphaGradientHListView(Context context) {
        super(context);
        this.art = 0;
        this.asf = 0;
        this.asg = -1;
        this.ash = -1;
        init();
    }

    public AlphaGradientHListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.art = 0;
        this.asf = 0;
        this.asg = -1;
        this.ash = -1;
        init();
    }

    public AlphaGradientHListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.art = 0;
        this.asf = 0;
        this.asg = -1;
        this.ash = -1;
        init();
    }

    private void init() {
        setLayerType(1, null);
    }

    public void setColor(int i, int i2) {
        this.art = i;
        this.asf = i2;
    }

    public void setShadowWidth(int i) {
        this.ase = i;
    }

    public void setNeedAlphaShade(boolean z) {
        if (z) {
            if (this.ase <= 0) {
                this.ase = getResources().getDimensionPixelSize(a.e.sdk_ds28);
            }
            this.ahX = new Paint();
            this.ahX.setStyle(Paint.Style.FILL_AND_STROKE);
            this.ahX.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.MULTIPLY));
        } else {
            this.ase = 0;
            this.ahX = null;
        }
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tieba.horizonallist.widget.HListView, com.baidu.live.tieba.horizonallist.widget.AbsHListView, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.ahX != null) {
            if (this.asg != getMeasuredWidth() || this.ash != getMeasuredHeight()) {
                this.ahX.setShader(new LinearGradient(getMeasuredWidth() - this.ase, 0.0f, getMeasuredWidth(), 0.0f, this.art, this.asf, Shader.TileMode.CLAMP));
                this.asg = getMeasuredWidth();
                this.ash = getMeasuredHeight();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tieba.horizonallist.widget.HListView, com.baidu.live.tieba.horizonallist.widget.AbsHListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.ahX != null) {
            canvas.drawRect(getMeasuredWidth() - this.ase, 0.0f, getMeasuredWidth(), getMeasuredHeight(), this.ahX);
        }
    }
}
