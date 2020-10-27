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
    private Paint eFF;
    private Path eFG;
    private Path eFH;
    private int eFI;
    private int eFJ;
    private int eFK;
    private int eFL;
    private int eFM;
    private int eFN;
    private int eFO;
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
        bnJ();
        bnL();
        bnK();
        setLayerType(1, null);
    }

    private void bnJ() {
        this.eFI = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds137);
        this.eFJ = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds204);
        this.eFK = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds23);
        this.eFL = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds51);
        this.eFM = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds16);
        this.eFN = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds52);
        this.eFO = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds2);
    }

    private void bnK() {
        this.eFG = new Path();
        this.eFH = new Path();
    }

    private void bnL() {
        this.eFF = new Paint();
        this.eFF.setColor(ap.getColor(R.color.cp_bg_line_e));
        this.eFF.setAntiAlias(true);
        this.eFF.setStrokeWidth(1.0f);
        this.eFF.setDither(true);
        this.eFF.setStyle(Paint.Style.FILL);
        this.mShadowPaint = new Paint();
        this.mShadowPaint.setAntiAlias(true);
        this.mShadowPaint.setDither(true);
        this.mShadowPaint.setShadowLayer(20.0f, 0.0f, -2.0f, getResources().getColor(R.color.cp_shadow_a_alpha33));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (getWidth() <= l.getEquipmentWidth(getContext())) {
            this.eFH.reset();
            this.eFG.reset();
            this.eFG.moveTo(0.0f, getHeight() - this.eFI);
            this.eFG.lineTo((getWidth() / 2) - (this.eFJ / 2), getHeight() - this.eFI);
            this.eFG.quadTo(((getWidth() / 2) - (this.eFJ / 2)) + this.eFK, getHeight() - this.eFI, ((getWidth() / 2) - (this.eFJ / 2)) + this.eFL, (getHeight() - this.eFI) - this.eFM);
            this.eFG.quadTo(getWidth() / 2, (getHeight() - this.eFI) - this.eFN, ((getWidth() / 2) + (this.eFJ / 2)) - this.eFL, (getHeight() - this.eFI) - this.eFM);
            this.eFG.quadTo(((getWidth() / 2) + (this.eFJ / 2)) - this.eFK, getHeight() - this.eFI, (getWidth() / 2) + (this.eFJ / 2), getHeight() - this.eFI);
            this.eFG.lineTo(getWidth(), getHeight() - this.eFI);
            this.eFG.lineTo(getWidth(), getHeight());
            this.eFG.lineTo(0.0f, getHeight());
            this.eFG.close();
            this.eFH.moveTo(0.0f, (getHeight() - this.eFI) + this.eFO);
            this.eFH.lineTo((getWidth() / 2) - (this.eFJ / 2), (getHeight() - this.eFI) + this.eFO);
            this.eFH.quadTo(((getWidth() / 2) - (this.eFJ / 2)) + this.eFK, (getHeight() - this.eFI) + this.eFO, ((getWidth() / 2) - (this.eFJ / 2)) + this.eFL, ((getHeight() - this.eFI) - this.eFM) + this.eFO);
            this.eFH.quadTo(getWidth() / 2, ((getHeight() - this.eFI) - this.eFN) + this.eFO, ((getWidth() / 2) + (this.eFJ / 2)) - this.eFL, ((getHeight() - this.eFI) - this.eFM) + this.eFO);
            this.eFH.quadTo(((getWidth() / 2) + (this.eFJ / 2)) - this.eFK, (getHeight() - this.eFI) + this.eFO, (getWidth() / 2) + (this.eFJ / 2), (getHeight() - this.eFI) + this.eFO);
            this.eFH.lineTo(getWidth(), (getHeight() - this.eFI) + this.eFO);
            this.eFH.lineTo(getWidth(), getHeight());
            this.eFH.lineTo(0.0f, getHeight());
            this.eFH.close();
            canvas.drawPath(this.eFH, this.mShadowPaint);
            canvas.drawPath(this.eFG, this.eFF);
        }
    }

    public void onChangeSkinType(int i) {
        if (i == 1 || i == 4) {
            this.eFF.setColor(ap.getColor(R.color.cp_bg_line_g_1));
            this.mShadowPaint.setShadowLayer(20.0f, 0.0f, -2.0f, getResources().getColor(R.color.transparent));
        } else {
            this.eFF.setColor(ap.getColor(R.color.cp_bg_line_e));
            this.mShadowPaint.setShadowLayer(20.0f, 0.0f, -2.0f, getResources().getColor(R.color.cp_shadow_a_alpha33));
        }
        invalidate();
    }
}
