package com.baidu.tbadk.core.tabHost;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class FragmentTabSwellingView extends View {
    private int cYA;
    private int cYB;
    private int cYC;
    private int cYD;
    private int cYE;
    private int cYF;
    private int cYG;
    private Paint cYx;
    private Path cYy;
    private Path cYz;
    private Paint mShadowPaint;

    public FragmentTabSwellingView(Context context) {
        this(context, null);
    }

    public FragmentTabSwellingView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FragmentTabSwellingView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        aFJ();
        aFL();
        aFK();
        setLayerType(1, null);
    }

    private void aFJ() {
        this.cYA = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds137);
        this.cYB = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds204);
        this.cYC = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds23);
        this.cYD = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds51);
        this.cYE = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds16);
        this.cYF = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds52);
        this.cYG = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds2);
    }

    private void aFK() {
        this.cYy = new Path();
        this.cYz = new Path();
    }

    private void aFL() {
        this.cYx = new Paint();
        this.cYx.setColor(am.getColor(R.color.cp_bg_line_e));
        this.cYx.setAntiAlias(true);
        this.cYx.setStrokeWidth(1.0f);
        this.cYx.setDither(true);
        this.cYx.setStyle(Paint.Style.FILL);
        this.mShadowPaint = new Paint();
        this.mShadowPaint.setAntiAlias(true);
        this.mShadowPaint.setDither(true);
        this.mShadowPaint.setShadowLayer(20.0f, 0.0f, -2.0f, getResources().getColor(R.color.cp_shadow_a_alpha33));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.cYy.moveTo(0.0f, getHeight() - this.cYA);
        this.cYy.lineTo((getWidth() / 2) - (this.cYB / 2), getHeight() - this.cYA);
        this.cYy.quadTo(((getWidth() / 2) - (this.cYB / 2)) + this.cYC, getHeight() - this.cYA, ((getWidth() / 2) - (this.cYB / 2)) + this.cYD, (getHeight() - this.cYA) - this.cYE);
        this.cYy.quadTo(getWidth() / 2, (getHeight() - this.cYA) - this.cYF, ((getWidth() / 2) + (this.cYB / 2)) - this.cYD, (getHeight() - this.cYA) - this.cYE);
        this.cYy.quadTo(((getWidth() / 2) + (this.cYB / 2)) - this.cYC, getHeight() - this.cYA, (getWidth() / 2) + (this.cYB / 2), getHeight() - this.cYA);
        this.cYy.lineTo(getWidth(), getHeight() - this.cYA);
        this.cYy.lineTo(getWidth(), getHeight());
        this.cYy.lineTo(0.0f, getHeight());
        this.cYy.close();
        this.cYz.moveTo(0.0f, (getHeight() - this.cYA) + this.cYG);
        this.cYz.lineTo((getWidth() / 2) - (this.cYB / 2), (getHeight() - this.cYA) + this.cYG);
        this.cYz.quadTo(((getWidth() / 2) - (this.cYB / 2)) + this.cYC, (getHeight() - this.cYA) + this.cYG, ((getWidth() / 2) - (this.cYB / 2)) + this.cYD, ((getHeight() - this.cYA) - this.cYE) + this.cYG);
        this.cYz.quadTo(getWidth() / 2, ((getHeight() - this.cYA) - this.cYF) + this.cYG, ((getWidth() / 2) + (this.cYB / 2)) - this.cYD, ((getHeight() - this.cYA) - this.cYE) + this.cYG);
        this.cYz.quadTo(((getWidth() / 2) + (this.cYB / 2)) - this.cYC, (getHeight() - this.cYA) + this.cYG, (getWidth() / 2) + (this.cYB / 2), (getHeight() - this.cYA) + this.cYG);
        this.cYz.lineTo(getWidth(), (getHeight() - this.cYA) + this.cYG);
        this.cYz.lineTo(getWidth(), getHeight());
        this.cYz.lineTo(0.0f, getHeight());
        this.cYz.close();
        canvas.drawPath(this.cYz, this.mShadowPaint);
        canvas.drawPath(this.cYy, this.cYx);
    }

    public void onChangeSkinType(int i) {
        this.cYx.setColor(am.getColor(R.color.cp_bg_line_e));
        if (i == 1 || i == 4) {
            this.mShadowPaint.setShadowLayer(20.0f, 0.0f, -2.0f, getResources().getColor(R.color.transparent));
        } else {
            this.mShadowPaint.setShadowLayer(20.0f, 0.0f, -2.0f, getResources().getColor(R.color.cp_shadow_a_alpha33));
        }
        invalidate();
    }
}
