package com.baidu.tbadk.core.tabHost;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class FragmentTabSwellingView extends View {
    private Paint eiJ;
    private Path eiK;
    private Path eiL;
    private int eiM;
    private int eiN;
    private int eiO;
    private int eiP;
    private int eiQ;
    private int eiR;
    private int eiS;
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
        bim();
        bio();
        bin();
        setLayerType(1, null);
    }

    private void bim() {
        this.eiM = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds137);
        this.eiN = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds204);
        this.eiO = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds23);
        this.eiP = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds51);
        this.eiQ = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds16);
        this.eiR = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds52);
        this.eiS = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds2);
    }

    private void bin() {
        this.eiK = new Path();
        this.eiL = new Path();
    }

    private void bio() {
        this.eiJ = new Paint();
        this.eiJ.setColor(ap.getColor(R.color.cp_bg_line_e));
        this.eiJ.setAntiAlias(true);
        this.eiJ.setStrokeWidth(1.0f);
        this.eiJ.setDither(true);
        this.eiJ.setStyle(Paint.Style.FILL);
        this.mShadowPaint = new Paint();
        this.mShadowPaint.setAntiAlias(true);
        this.mShadowPaint.setDither(true);
        this.mShadowPaint.setShadowLayer(20.0f, 0.0f, -2.0f, getResources().getColor(R.color.cp_shadow_a_alpha33));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (getWidth() <= l.getEquipmentWidth(getContext())) {
            this.eiL.reset();
            this.eiK.reset();
            this.eiK.moveTo(0.0f, getHeight() - this.eiM);
            this.eiK.lineTo((getWidth() / 2) - (this.eiN / 2), getHeight() - this.eiM);
            this.eiK.quadTo(((getWidth() / 2) - (this.eiN / 2)) + this.eiO, getHeight() - this.eiM, ((getWidth() / 2) - (this.eiN / 2)) + this.eiP, (getHeight() - this.eiM) - this.eiQ);
            this.eiK.quadTo(getWidth() / 2, (getHeight() - this.eiM) - this.eiR, ((getWidth() / 2) + (this.eiN / 2)) - this.eiP, (getHeight() - this.eiM) - this.eiQ);
            this.eiK.quadTo(((getWidth() / 2) + (this.eiN / 2)) - this.eiO, getHeight() - this.eiM, (getWidth() / 2) + (this.eiN / 2), getHeight() - this.eiM);
            this.eiK.lineTo(getWidth(), getHeight() - this.eiM);
            this.eiK.lineTo(getWidth(), getHeight());
            this.eiK.lineTo(0.0f, getHeight());
            this.eiK.close();
            this.eiL.moveTo(0.0f, (getHeight() - this.eiM) + this.eiS);
            this.eiL.lineTo((getWidth() / 2) - (this.eiN / 2), (getHeight() - this.eiM) + this.eiS);
            this.eiL.quadTo(((getWidth() / 2) - (this.eiN / 2)) + this.eiO, (getHeight() - this.eiM) + this.eiS, ((getWidth() / 2) - (this.eiN / 2)) + this.eiP, ((getHeight() - this.eiM) - this.eiQ) + this.eiS);
            this.eiL.quadTo(getWidth() / 2, ((getHeight() - this.eiM) - this.eiR) + this.eiS, ((getWidth() / 2) + (this.eiN / 2)) - this.eiP, ((getHeight() - this.eiM) - this.eiQ) + this.eiS);
            this.eiL.quadTo(((getWidth() / 2) + (this.eiN / 2)) - this.eiO, (getHeight() - this.eiM) + this.eiS, (getWidth() / 2) + (this.eiN / 2), (getHeight() - this.eiM) + this.eiS);
            this.eiL.lineTo(getWidth(), (getHeight() - this.eiM) + this.eiS);
            this.eiL.lineTo(getWidth(), getHeight());
            this.eiL.lineTo(0.0f, getHeight());
            this.eiL.close();
            canvas.drawPath(this.eiL, this.mShadowPaint);
            canvas.drawPath(this.eiK, this.eiJ);
        }
    }

    public void onChangeSkinType(int i) {
        if (i == 1 || i == 4) {
            this.eiJ.setColor(ap.getColor(R.color.cp_bg_line_g_1));
            this.mShadowPaint.setShadowLayer(20.0f, 0.0f, -2.0f, getResources().getColor(R.color.transparent));
        } else {
            this.eiJ.setColor(ap.getColor(R.color.cp_bg_line_e));
            this.mShadowPaint.setShadowLayer(20.0f, 0.0f, -2.0f, getResources().getColor(R.color.cp_shadow_a_alpha33));
        }
        invalidate();
    }
}
