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
/* loaded from: classes2.dex */
public class FragmentTabSwellingView extends View {
    private Paint eiF;
    private Path eiG;
    private Path eiH;
    private int eiI;
    private int eiJ;
    private int eiK;
    private int eiL;
    private int eiM;
    private int eiN;
    private int eiO;
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
        this.eiI = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds137);
        this.eiJ = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds204);
        this.eiK = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds23);
        this.eiL = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds51);
        this.eiM = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds16);
        this.eiN = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds52);
        this.eiO = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds2);
    }

    private void bin() {
        this.eiG = new Path();
        this.eiH = new Path();
    }

    private void bio() {
        this.eiF = new Paint();
        this.eiF.setColor(ap.getColor(R.color.cp_bg_line_e));
        this.eiF.setAntiAlias(true);
        this.eiF.setStrokeWidth(1.0f);
        this.eiF.setDither(true);
        this.eiF.setStyle(Paint.Style.FILL);
        this.mShadowPaint = new Paint();
        this.mShadowPaint.setAntiAlias(true);
        this.mShadowPaint.setDither(true);
        this.mShadowPaint.setShadowLayer(20.0f, 0.0f, -2.0f, getResources().getColor(R.color.cp_shadow_a_alpha33));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (getWidth() <= l.getEquipmentWidth(getContext())) {
            this.eiH.reset();
            this.eiG.reset();
            this.eiG.moveTo(0.0f, getHeight() - this.eiI);
            this.eiG.lineTo((getWidth() / 2) - (this.eiJ / 2), getHeight() - this.eiI);
            this.eiG.quadTo(((getWidth() / 2) - (this.eiJ / 2)) + this.eiK, getHeight() - this.eiI, ((getWidth() / 2) - (this.eiJ / 2)) + this.eiL, (getHeight() - this.eiI) - this.eiM);
            this.eiG.quadTo(getWidth() / 2, (getHeight() - this.eiI) - this.eiN, ((getWidth() / 2) + (this.eiJ / 2)) - this.eiL, (getHeight() - this.eiI) - this.eiM);
            this.eiG.quadTo(((getWidth() / 2) + (this.eiJ / 2)) - this.eiK, getHeight() - this.eiI, (getWidth() / 2) + (this.eiJ / 2), getHeight() - this.eiI);
            this.eiG.lineTo(getWidth(), getHeight() - this.eiI);
            this.eiG.lineTo(getWidth(), getHeight());
            this.eiG.lineTo(0.0f, getHeight());
            this.eiG.close();
            this.eiH.moveTo(0.0f, (getHeight() - this.eiI) + this.eiO);
            this.eiH.lineTo((getWidth() / 2) - (this.eiJ / 2), (getHeight() - this.eiI) + this.eiO);
            this.eiH.quadTo(((getWidth() / 2) - (this.eiJ / 2)) + this.eiK, (getHeight() - this.eiI) + this.eiO, ((getWidth() / 2) - (this.eiJ / 2)) + this.eiL, ((getHeight() - this.eiI) - this.eiM) + this.eiO);
            this.eiH.quadTo(getWidth() / 2, ((getHeight() - this.eiI) - this.eiN) + this.eiO, ((getWidth() / 2) + (this.eiJ / 2)) - this.eiL, ((getHeight() - this.eiI) - this.eiM) + this.eiO);
            this.eiH.quadTo(((getWidth() / 2) + (this.eiJ / 2)) - this.eiK, (getHeight() - this.eiI) + this.eiO, (getWidth() / 2) + (this.eiJ / 2), (getHeight() - this.eiI) + this.eiO);
            this.eiH.lineTo(getWidth(), (getHeight() - this.eiI) + this.eiO);
            this.eiH.lineTo(getWidth(), getHeight());
            this.eiH.lineTo(0.0f, getHeight());
            this.eiH.close();
            canvas.drawPath(this.eiH, this.mShadowPaint);
            canvas.drawPath(this.eiG, this.eiF);
        }
    }

    public void onChangeSkinType(int i) {
        if (i == 1 || i == 4) {
            this.eiF.setColor(ap.getColor(R.color.cp_bg_line_g_1));
            this.mShadowPaint.setShadowLayer(20.0f, 0.0f, -2.0f, getResources().getColor(R.color.transparent));
        } else {
            this.eiF.setColor(ap.getColor(R.color.cp_bg_line_e));
            this.mShadowPaint.setShadowLayer(20.0f, 0.0f, -2.0f, getResources().getColor(R.color.cp_shadow_a_alpha33));
        }
        invalidate();
    }
}
