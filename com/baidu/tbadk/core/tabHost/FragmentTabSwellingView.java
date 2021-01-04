package com.baidu.tbadk.core.tabHost;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class FragmentTabSwellingView extends View {
    private Paint fbE;
    private Path fbF;
    private Path fbG;
    private int fbH;
    private int fbI;
    private int fbJ;
    private int fbK;
    private int fbL;
    private int fbM;
    private int fbN;
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
        bvs();
        bvu();
        bvt();
        setLayerType(1, null);
    }

    private void bvs() {
        this.fbH = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds137);
        this.fbI = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds204);
        this.fbJ = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds23);
        this.fbK = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds51);
        this.fbL = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds16);
        this.fbM = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds52);
        this.fbN = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds2);
    }

    private void bvt() {
        this.fbF = new Path();
        this.fbG = new Path();
    }

    private void bvu() {
        this.fbE = new Paint();
        this.fbE.setColor(ao.getColor(R.color.CAM_X0205));
        this.fbE.setAntiAlias(true);
        this.fbE.setStrokeWidth(1.0f);
        this.fbE.setDither(true);
        this.fbE.setStyle(Paint.Style.FILL);
        this.mShadowPaint = new Paint();
        this.mShadowPaint.setAntiAlias(true);
        this.mShadowPaint.setDither(true);
        this.mShadowPaint.setShadowLayer(20.0f, 0.0f, -2.0f, getResources().getColor(R.color.CAM_X0806));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (getWidth() <= l.getEquipmentWidth(getContext())) {
            this.fbG.reset();
            this.fbF.reset();
            this.fbF.moveTo(0.0f, getHeight() - this.fbH);
            this.fbF.lineTo((getWidth() / 2) - (this.fbI / 2), getHeight() - this.fbH);
            this.fbF.quadTo(((getWidth() / 2) - (this.fbI / 2)) + this.fbJ, getHeight() - this.fbH, ((getWidth() / 2) - (this.fbI / 2)) + this.fbK, (getHeight() - this.fbH) - this.fbL);
            this.fbF.quadTo(getWidth() / 2, (getHeight() - this.fbH) - this.fbM, ((getWidth() / 2) + (this.fbI / 2)) - this.fbK, (getHeight() - this.fbH) - this.fbL);
            this.fbF.quadTo(((getWidth() / 2) + (this.fbI / 2)) - this.fbJ, getHeight() - this.fbH, (getWidth() / 2) + (this.fbI / 2), getHeight() - this.fbH);
            this.fbF.lineTo(getWidth(), getHeight() - this.fbH);
            this.fbF.lineTo(getWidth(), getHeight());
            this.fbF.lineTo(0.0f, getHeight());
            this.fbF.close();
            this.fbG.moveTo(0.0f, (getHeight() - this.fbH) + this.fbN);
            this.fbG.lineTo((getWidth() / 2) - (this.fbI / 2), (getHeight() - this.fbH) + this.fbN);
            this.fbG.quadTo(((getWidth() / 2) - (this.fbI / 2)) + this.fbJ, (getHeight() - this.fbH) + this.fbN, ((getWidth() / 2) - (this.fbI / 2)) + this.fbK, ((getHeight() - this.fbH) - this.fbL) + this.fbN);
            this.fbG.quadTo(getWidth() / 2, ((getHeight() - this.fbH) - this.fbM) + this.fbN, ((getWidth() / 2) + (this.fbI / 2)) - this.fbK, ((getHeight() - this.fbH) - this.fbL) + this.fbN);
            this.fbG.quadTo(((getWidth() / 2) + (this.fbI / 2)) - this.fbJ, (getHeight() - this.fbH) + this.fbN, (getWidth() / 2) + (this.fbI / 2), (getHeight() - this.fbH) + this.fbN);
            this.fbG.lineTo(getWidth(), (getHeight() - this.fbH) + this.fbN);
            this.fbG.lineTo(getWidth(), getHeight());
            this.fbG.lineTo(0.0f, getHeight());
            this.fbG.close();
            canvas.drawPath(this.fbG, this.mShadowPaint);
            canvas.drawPath(this.fbF, this.fbE);
        }
    }

    public void onChangeSkinType(int i) {
        if (i == 1 || i == 4) {
            this.fbE.setColor(ao.getColor(R.color.CAM_X0206_1));
            this.mShadowPaint.setShadowLayer(20.0f, 0.0f, -2.0f, getResources().getColor(R.color.transparent));
        } else {
            this.fbE.setColor(ao.getColor(R.color.CAM_X0205));
            this.mShadowPaint.setShadowLayer(20.0f, 0.0f, -2.0f, getResources().getColor(R.color.CAM_X0806));
        }
        invalidate();
    }
}
