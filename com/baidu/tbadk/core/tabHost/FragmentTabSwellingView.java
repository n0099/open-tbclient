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
    private Paint dxL;
    private Path dxM;
    private Path dxN;
    private int dxO;
    private int dxP;
    private int dxQ;
    private int dxR;
    private int dxS;
    private int dxT;
    private int dxU;
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
        aNV();
        aNX();
        aNW();
        setLayerType(1, null);
    }

    private void aNV() {
        this.dxO = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds137);
        this.dxP = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds204);
        this.dxQ = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds23);
        this.dxR = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds51);
        this.dxS = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds16);
        this.dxT = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds52);
        this.dxU = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds2);
    }

    private void aNW() {
        this.dxM = new Path();
        this.dxN = new Path();
    }

    private void aNX() {
        this.dxL = new Paint();
        this.dxL.setColor(am.getColor(R.color.cp_bg_line_e));
        this.dxL.setAntiAlias(true);
        this.dxL.setStrokeWidth(1.0f);
        this.dxL.setDither(true);
        this.dxL.setStyle(Paint.Style.FILL);
        this.mShadowPaint = new Paint();
        this.mShadowPaint.setAntiAlias(true);
        this.mShadowPaint.setDither(true);
        this.mShadowPaint.setShadowLayer(20.0f, 0.0f, -2.0f, getResources().getColor(R.color.cp_shadow_a_alpha33));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (getWidth() <= l.getEquipmentWidth(getContext())) {
            this.dxM.moveTo(0.0f, getHeight() - this.dxO);
            this.dxM.lineTo((getWidth() / 2) - (this.dxP / 2), getHeight() - this.dxO);
            this.dxM.quadTo(((getWidth() / 2) - (this.dxP / 2)) + this.dxQ, getHeight() - this.dxO, ((getWidth() / 2) - (this.dxP / 2)) + this.dxR, (getHeight() - this.dxO) - this.dxS);
            this.dxM.quadTo(getWidth() / 2, (getHeight() - this.dxO) - this.dxT, ((getWidth() / 2) + (this.dxP / 2)) - this.dxR, (getHeight() - this.dxO) - this.dxS);
            this.dxM.quadTo(((getWidth() / 2) + (this.dxP / 2)) - this.dxQ, getHeight() - this.dxO, (getWidth() / 2) + (this.dxP / 2), getHeight() - this.dxO);
            this.dxM.lineTo(getWidth(), getHeight() - this.dxO);
            this.dxM.lineTo(getWidth(), getHeight());
            this.dxM.lineTo(0.0f, getHeight());
            this.dxM.close();
            this.dxN.moveTo(0.0f, (getHeight() - this.dxO) + this.dxU);
            this.dxN.lineTo((getWidth() / 2) - (this.dxP / 2), (getHeight() - this.dxO) + this.dxU);
            this.dxN.quadTo(((getWidth() / 2) - (this.dxP / 2)) + this.dxQ, (getHeight() - this.dxO) + this.dxU, ((getWidth() / 2) - (this.dxP / 2)) + this.dxR, ((getHeight() - this.dxO) - this.dxS) + this.dxU);
            this.dxN.quadTo(getWidth() / 2, ((getHeight() - this.dxO) - this.dxT) + this.dxU, ((getWidth() / 2) + (this.dxP / 2)) - this.dxR, ((getHeight() - this.dxO) - this.dxS) + this.dxU);
            this.dxN.quadTo(((getWidth() / 2) + (this.dxP / 2)) - this.dxQ, (getHeight() - this.dxO) + this.dxU, (getWidth() / 2) + (this.dxP / 2), (getHeight() - this.dxO) + this.dxU);
            this.dxN.lineTo(getWidth(), (getHeight() - this.dxO) + this.dxU);
            this.dxN.lineTo(getWidth(), getHeight());
            this.dxN.lineTo(0.0f, getHeight());
            this.dxN.close();
            canvas.drawPath(this.dxN, this.mShadowPaint);
            canvas.drawPath(this.dxM, this.dxL);
        }
    }

    public void onChangeSkinType(int i) {
        this.dxL.setColor(am.getColor(R.color.cp_bg_line_e));
        if (i == 1 || i == 4) {
            this.mShadowPaint.setShadowLayer(20.0f, 0.0f, -2.0f, getResources().getColor(R.color.transparent));
        } else {
            this.mShadowPaint.setShadowLayer(20.0f, 0.0f, -2.0f, getResources().getColor(R.color.cp_shadow_a_alpha33));
        }
        invalidate();
    }
}
