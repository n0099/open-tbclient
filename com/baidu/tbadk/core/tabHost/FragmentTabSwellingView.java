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
    private Paint dxH;
    private Path dxI;
    private Path dxJ;
    private int dxK;
    private int dxL;
    private int dxM;
    private int dxN;
    private int dxO;
    private int dxP;
    private int dxQ;
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
        aNX();
        aNZ();
        aNY();
        setLayerType(1, null);
    }

    private void aNX() {
        this.dxK = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds137);
        this.dxL = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds204);
        this.dxM = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds23);
        this.dxN = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds51);
        this.dxO = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds16);
        this.dxP = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds52);
        this.dxQ = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds2);
    }

    private void aNY() {
        this.dxI = new Path();
        this.dxJ = new Path();
    }

    private void aNZ() {
        this.dxH = new Paint();
        this.dxH.setColor(am.getColor(R.color.cp_bg_line_e));
        this.dxH.setAntiAlias(true);
        this.dxH.setStrokeWidth(1.0f);
        this.dxH.setDither(true);
        this.dxH.setStyle(Paint.Style.FILL);
        this.mShadowPaint = new Paint();
        this.mShadowPaint.setAntiAlias(true);
        this.mShadowPaint.setDither(true);
        this.mShadowPaint.setShadowLayer(20.0f, 0.0f, -2.0f, getResources().getColor(R.color.cp_shadow_a_alpha33));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (getWidth() <= l.getEquipmentWidth(getContext())) {
            this.dxI.moveTo(0.0f, getHeight() - this.dxK);
            this.dxI.lineTo((getWidth() / 2) - (this.dxL / 2), getHeight() - this.dxK);
            this.dxI.quadTo(((getWidth() / 2) - (this.dxL / 2)) + this.dxM, getHeight() - this.dxK, ((getWidth() / 2) - (this.dxL / 2)) + this.dxN, (getHeight() - this.dxK) - this.dxO);
            this.dxI.quadTo(getWidth() / 2, (getHeight() - this.dxK) - this.dxP, ((getWidth() / 2) + (this.dxL / 2)) - this.dxN, (getHeight() - this.dxK) - this.dxO);
            this.dxI.quadTo(((getWidth() / 2) + (this.dxL / 2)) - this.dxM, getHeight() - this.dxK, (getWidth() / 2) + (this.dxL / 2), getHeight() - this.dxK);
            this.dxI.lineTo(getWidth(), getHeight() - this.dxK);
            this.dxI.lineTo(getWidth(), getHeight());
            this.dxI.lineTo(0.0f, getHeight());
            this.dxI.close();
            this.dxJ.moveTo(0.0f, (getHeight() - this.dxK) + this.dxQ);
            this.dxJ.lineTo((getWidth() / 2) - (this.dxL / 2), (getHeight() - this.dxK) + this.dxQ);
            this.dxJ.quadTo(((getWidth() / 2) - (this.dxL / 2)) + this.dxM, (getHeight() - this.dxK) + this.dxQ, ((getWidth() / 2) - (this.dxL / 2)) + this.dxN, ((getHeight() - this.dxK) - this.dxO) + this.dxQ);
            this.dxJ.quadTo(getWidth() / 2, ((getHeight() - this.dxK) - this.dxP) + this.dxQ, ((getWidth() / 2) + (this.dxL / 2)) - this.dxN, ((getHeight() - this.dxK) - this.dxO) + this.dxQ);
            this.dxJ.quadTo(((getWidth() / 2) + (this.dxL / 2)) - this.dxM, (getHeight() - this.dxK) + this.dxQ, (getWidth() / 2) + (this.dxL / 2), (getHeight() - this.dxK) + this.dxQ);
            this.dxJ.lineTo(getWidth(), (getHeight() - this.dxK) + this.dxQ);
            this.dxJ.lineTo(getWidth(), getHeight());
            this.dxJ.lineTo(0.0f, getHeight());
            this.dxJ.close();
            canvas.drawPath(this.dxJ, this.mShadowPaint);
            canvas.drawPath(this.dxI, this.dxH);
        }
    }

    public void onChangeSkinType(int i) {
        this.dxH.setColor(am.getColor(R.color.cp_bg_line_e));
        if (i == 1 || i == 4) {
            this.mShadowPaint.setShadowLayer(20.0f, 0.0f, -2.0f, getResources().getColor(R.color.transparent));
        } else {
            this.mShadowPaint.setShadowLayer(20.0f, 0.0f, -2.0f, getResources().getColor(R.color.cp_shadow_a_alpha33));
        }
        invalidate();
    }
}
