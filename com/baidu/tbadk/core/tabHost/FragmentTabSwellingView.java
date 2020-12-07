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
    private Paint eRF;
    private Path eRG;
    private Path eRH;
    private int eRI;
    private int eRJ;
    private int eRK;
    private int eRL;
    private int eRM;
    private int eRN;
    private int eRO;
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
        bsQ();
        bsS();
        bsR();
        setLayerType(1, null);
    }

    private void bsQ() {
        this.eRI = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds137);
        this.eRJ = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds204);
        this.eRK = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds23);
        this.eRL = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds51);
        this.eRM = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds16);
        this.eRN = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds52);
        this.eRO = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds2);
    }

    private void bsR() {
        this.eRG = new Path();
        this.eRH = new Path();
    }

    private void bsS() {
        this.eRF = new Paint();
        this.eRF.setColor(ap.getColor(R.color.CAM_X0205));
        this.eRF.setAntiAlias(true);
        this.eRF.setStrokeWidth(1.0f);
        this.eRF.setDither(true);
        this.eRF.setStyle(Paint.Style.FILL);
        this.mShadowPaint = new Paint();
        this.mShadowPaint.setAntiAlias(true);
        this.mShadowPaint.setDither(true);
        this.mShadowPaint.setShadowLayer(20.0f, 0.0f, -2.0f, getResources().getColor(R.color.CAM_X0806));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (getWidth() <= l.getEquipmentWidth(getContext())) {
            this.eRH.reset();
            this.eRG.reset();
            this.eRG.moveTo(0.0f, getHeight() - this.eRI);
            this.eRG.lineTo((getWidth() / 2) - (this.eRJ / 2), getHeight() - this.eRI);
            this.eRG.quadTo(((getWidth() / 2) - (this.eRJ / 2)) + this.eRK, getHeight() - this.eRI, ((getWidth() / 2) - (this.eRJ / 2)) + this.eRL, (getHeight() - this.eRI) - this.eRM);
            this.eRG.quadTo(getWidth() / 2, (getHeight() - this.eRI) - this.eRN, ((getWidth() / 2) + (this.eRJ / 2)) - this.eRL, (getHeight() - this.eRI) - this.eRM);
            this.eRG.quadTo(((getWidth() / 2) + (this.eRJ / 2)) - this.eRK, getHeight() - this.eRI, (getWidth() / 2) + (this.eRJ / 2), getHeight() - this.eRI);
            this.eRG.lineTo(getWidth(), getHeight() - this.eRI);
            this.eRG.lineTo(getWidth(), getHeight());
            this.eRG.lineTo(0.0f, getHeight());
            this.eRG.close();
            this.eRH.moveTo(0.0f, (getHeight() - this.eRI) + this.eRO);
            this.eRH.lineTo((getWidth() / 2) - (this.eRJ / 2), (getHeight() - this.eRI) + this.eRO);
            this.eRH.quadTo(((getWidth() / 2) - (this.eRJ / 2)) + this.eRK, (getHeight() - this.eRI) + this.eRO, ((getWidth() / 2) - (this.eRJ / 2)) + this.eRL, ((getHeight() - this.eRI) - this.eRM) + this.eRO);
            this.eRH.quadTo(getWidth() / 2, ((getHeight() - this.eRI) - this.eRN) + this.eRO, ((getWidth() / 2) + (this.eRJ / 2)) - this.eRL, ((getHeight() - this.eRI) - this.eRM) + this.eRO);
            this.eRH.quadTo(((getWidth() / 2) + (this.eRJ / 2)) - this.eRK, (getHeight() - this.eRI) + this.eRO, (getWidth() / 2) + (this.eRJ / 2), (getHeight() - this.eRI) + this.eRO);
            this.eRH.lineTo(getWidth(), (getHeight() - this.eRI) + this.eRO);
            this.eRH.lineTo(getWidth(), getHeight());
            this.eRH.lineTo(0.0f, getHeight());
            this.eRH.close();
            canvas.drawPath(this.eRH, this.mShadowPaint);
            canvas.drawPath(this.eRG, this.eRF);
        }
    }

    public void onChangeSkinType(int i) {
        if (i == 1 || i == 4) {
            this.eRF.setColor(ap.getColor(R.color.CAM_X0206_1));
            this.mShadowPaint.setShadowLayer(20.0f, 0.0f, -2.0f, getResources().getColor(R.color.transparent));
        } else {
            this.eRF.setColor(ap.getColor(R.color.CAM_X0205));
            this.mShadowPaint.setShadowLayer(20.0f, 0.0f, -2.0f, getResources().getColor(R.color.CAM_X0806));
        }
        invalidate();
    }
}
