package com.baidu.tbadk.core.dialog;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class CircleView extends View {
    private static int adn = 360;
    private static int ado = 100;
    private int adp;
    private int adq;
    private Paint adr;
    private Paint ads;
    private RectF adt;
    private int adu;
    private int mWidth;

    public CircleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.adu = 0;
        init();
    }

    public CircleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.adu = 0;
        init();
    }

    public CircleView(Context context) {
        super(context);
        this.adu = 0;
        init();
    }

    public void setProgress(int i) {
        this.adu = i;
        invalidate();
    }

    public void init() {
        this.mWidth = getResources().getDimensionPixelSize(d.e.ds100);
        this.adp = getResources().getDimensionPixelSize(d.e.ds4);
        this.adq = getResources().getDimensionPixelSize(d.e.ds2);
        this.adr = new Paint();
        this.adr.setStrokeWidth(this.adp);
        this.adr.setColor(getResources().getColor(d.C0126d.cp_cont_g));
        this.adr.setStyle(Paint.Style.STROKE);
        this.adr.setAntiAlias(true);
        this.ads = new Paint();
        this.ads.setStrokeWidth(this.adq);
        this.ads.setColor(getResources().getColor(d.C0126d.common_color_10042));
        this.ads.setStyle(Paint.Style.STROKE);
        this.ads.setAntiAlias(true);
        this.adt = new RectF(this.adp, this.adp, this.mWidth + this.adp, this.mWidth + this.adp);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawArc(this.adt, 0.0f, adn, false, this.ads);
        canvas.drawArc(this.adt, 270.0f, (adn * this.adu) / ado, false, this.adr);
    }
}
