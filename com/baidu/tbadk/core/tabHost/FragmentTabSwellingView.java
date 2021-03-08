package com.baidu.tbadk.core.tabHost;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class FragmentTabSwellingView extends View {
    private Paint faL;
    private Path faM;
    private Path faN;
    private int faO;
    private int faP;
    private int faQ;
    private int faR;
    private int faS;
    private int faT;
    private int faU;
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
        brT();
        brV();
        brU();
        setLayerType(1, null);
    }

    private void brT() {
        this.faO = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds137);
        this.faP = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds204);
        this.faQ = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds23);
        this.faR = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds51);
        this.faS = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds16);
        this.faT = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds52);
        this.faU = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds2);
    }

    private void brU() {
        this.faM = new Path();
        this.faN = new Path();
    }

    private void brV() {
        this.faL = new Paint();
        this.faL.setColor(ap.getColor(R.color.CAM_X0205));
        this.faL.setAntiAlias(true);
        this.faL.setStrokeWidth(1.0f);
        this.faL.setDither(true);
        this.faL.setStyle(Paint.Style.FILL);
        this.mShadowPaint = new Paint();
        this.mShadowPaint.setAntiAlias(true);
        this.mShadowPaint.setDither(true);
        this.mShadowPaint.setShadowLayer(20.0f, 0.0f, -2.0f, getResources().getColor(R.color.CAM_X0806));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (getWidth() <= l.getEquipmentWidth(getContext())) {
            this.faN.reset();
            this.faM.reset();
            this.faM.moveTo(0.0f, getHeight() - this.faO);
            this.faM.lineTo((getWidth() / 2) - (this.faP / 2), getHeight() - this.faO);
            this.faM.quadTo(((getWidth() / 2) - (this.faP / 2)) + this.faQ, getHeight() - this.faO, ((getWidth() / 2) - (this.faP / 2)) + this.faR, (getHeight() - this.faO) - this.faS);
            this.faM.quadTo(getWidth() / 2, (getHeight() - this.faO) - this.faT, ((getWidth() / 2) + (this.faP / 2)) - this.faR, (getHeight() - this.faO) - this.faS);
            this.faM.quadTo(((getWidth() / 2) + (this.faP / 2)) - this.faQ, getHeight() - this.faO, (getWidth() / 2) + (this.faP / 2), getHeight() - this.faO);
            this.faM.lineTo(getWidth(), getHeight() - this.faO);
            this.faM.lineTo(getWidth(), getHeight());
            this.faM.lineTo(0.0f, getHeight());
            this.faM.close();
            this.faN.moveTo(0.0f, (getHeight() - this.faO) + this.faU);
            this.faN.lineTo((getWidth() / 2) - (this.faP / 2), (getHeight() - this.faO) + this.faU);
            this.faN.quadTo(((getWidth() / 2) - (this.faP / 2)) + this.faQ, (getHeight() - this.faO) + this.faU, ((getWidth() / 2) - (this.faP / 2)) + this.faR, ((getHeight() - this.faO) - this.faS) + this.faU);
            this.faN.quadTo(getWidth() / 2, ((getHeight() - this.faO) - this.faT) + this.faU, ((getWidth() / 2) + (this.faP / 2)) - this.faR, ((getHeight() - this.faO) - this.faS) + this.faU);
            this.faN.quadTo(((getWidth() / 2) + (this.faP / 2)) - this.faQ, (getHeight() - this.faO) + this.faU, (getWidth() / 2) + (this.faP / 2), (getHeight() - this.faO) + this.faU);
            this.faN.lineTo(getWidth(), (getHeight() - this.faO) + this.faU);
            this.faN.lineTo(getWidth(), getHeight());
            this.faN.lineTo(0.0f, getHeight());
            this.faN.close();
            canvas.drawPath(this.faN, this.mShadowPaint);
            canvas.drawPath(this.faM, this.faL);
        }
    }

    public void onChangeSkinType(int i) {
        if (i == 1 || i == 4) {
            this.faL.setColor(ap.getColor(R.color.CAM_X0206_1));
            this.mShadowPaint.setShadowLayer(20.0f, 0.0f, -2.0f, getResources().getColor(R.color.transparent));
        } else {
            this.faL.setColor(ap.getColor(R.color.CAM_X0205));
            this.mShadowPaint.setShadowLayer(20.0f, 0.0f, -2.0f, getResources().getColor(R.color.CAM_X0806));
        }
        invalidate();
    }
}
