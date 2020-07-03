package com.baidu.tbadk.core.tabHost;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class FragmentTabSwellingView extends View {
    private Paint dSH;
    private Path dSI;
    private Path dSJ;
    private int dSK;
    private int dSL;
    private int dSM;
    private int dSN;
    private int dSO;
    private int dSP;
    private int dSQ;
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
        aVR();
        aVT();
        aVS();
        setLayerType(1, null);
    }

    private void aVR() {
        this.dSK = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds137);
        this.dSL = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds204);
        this.dSM = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds23);
        this.dSN = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds51);
        this.dSO = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds16);
        this.dSP = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds52);
        this.dSQ = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds2);
    }

    private void aVS() {
        this.dSI = new Path();
        this.dSJ = new Path();
    }

    private void aVT() {
        this.dSH = new Paint();
        this.dSH.setColor(an.getColor(R.color.cp_bg_line_e));
        this.dSH.setAntiAlias(true);
        this.dSH.setStrokeWidth(1.0f);
        this.dSH.setDither(true);
        this.dSH.setStyle(Paint.Style.FILL);
        this.mShadowPaint = new Paint();
        this.mShadowPaint.setAntiAlias(true);
        this.mShadowPaint.setDither(true);
        this.mShadowPaint.setShadowLayer(20.0f, 0.0f, -2.0f, getResources().getColor(R.color.cp_shadow_a_alpha33));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (getWidth() <= l.getEquipmentWidth(getContext())) {
            this.dSI.moveTo(0.0f, getHeight() - this.dSK);
            this.dSI.lineTo((getWidth() / 2) - (this.dSL / 2), getHeight() - this.dSK);
            this.dSI.quadTo(((getWidth() / 2) - (this.dSL / 2)) + this.dSM, getHeight() - this.dSK, ((getWidth() / 2) - (this.dSL / 2)) + this.dSN, (getHeight() - this.dSK) - this.dSO);
            this.dSI.quadTo(getWidth() / 2, (getHeight() - this.dSK) - this.dSP, ((getWidth() / 2) + (this.dSL / 2)) - this.dSN, (getHeight() - this.dSK) - this.dSO);
            this.dSI.quadTo(((getWidth() / 2) + (this.dSL / 2)) - this.dSM, getHeight() - this.dSK, (getWidth() / 2) + (this.dSL / 2), getHeight() - this.dSK);
            this.dSI.lineTo(getWidth(), getHeight() - this.dSK);
            this.dSI.lineTo(getWidth(), getHeight());
            this.dSI.lineTo(0.0f, getHeight());
            this.dSI.close();
            this.dSJ.moveTo(0.0f, (getHeight() - this.dSK) + this.dSQ);
            this.dSJ.lineTo((getWidth() / 2) - (this.dSL / 2), (getHeight() - this.dSK) + this.dSQ);
            this.dSJ.quadTo(((getWidth() / 2) - (this.dSL / 2)) + this.dSM, (getHeight() - this.dSK) + this.dSQ, ((getWidth() / 2) - (this.dSL / 2)) + this.dSN, ((getHeight() - this.dSK) - this.dSO) + this.dSQ);
            this.dSJ.quadTo(getWidth() / 2, ((getHeight() - this.dSK) - this.dSP) + this.dSQ, ((getWidth() / 2) + (this.dSL / 2)) - this.dSN, ((getHeight() - this.dSK) - this.dSO) + this.dSQ);
            this.dSJ.quadTo(((getWidth() / 2) + (this.dSL / 2)) - this.dSM, (getHeight() - this.dSK) + this.dSQ, (getWidth() / 2) + (this.dSL / 2), (getHeight() - this.dSK) + this.dSQ);
            this.dSJ.lineTo(getWidth(), (getHeight() - this.dSK) + this.dSQ);
            this.dSJ.lineTo(getWidth(), getHeight());
            this.dSJ.lineTo(0.0f, getHeight());
            this.dSJ.close();
            canvas.drawPath(this.dSJ, this.mShadowPaint);
            canvas.drawPath(this.dSI, this.dSH);
        }
    }

    public void onChangeSkinType(int i) {
        if (i == 1 || i == 4) {
            this.dSH.setColor(an.getColor(R.color.cp_bg_line_g_1));
            this.mShadowPaint.setShadowLayer(20.0f, 0.0f, -2.0f, getResources().getColor(R.color.transparent));
        } else {
            this.dSH.setColor(an.getColor(R.color.cp_bg_line_e));
            this.mShadowPaint.setShadowLayer(20.0f, 0.0f, -2.0f, getResources().getColor(R.color.cp_shadow_a_alpha33));
        }
        invalidate();
    }
}
