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
    private Paint eWW;
    private Path eWX;
    private Path eWY;
    private int eWZ;
    private int eXa;
    private int eXb;
    private int eXc;
    private int eXd;
    private int eXe;
    private int eXf;
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
        brz();
        brB();
        brA();
        setLayerType(1, null);
    }

    private void brz() {
        this.eWZ = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds137);
        this.eXa = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds204);
        this.eXb = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds23);
        this.eXc = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds51);
        this.eXd = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds16);
        this.eXe = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds52);
        this.eXf = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds2);
    }

    private void brA() {
        this.eWX = new Path();
        this.eWY = new Path();
    }

    private void brB() {
        this.eWW = new Paint();
        this.eWW.setColor(ao.getColor(R.color.CAM_X0205));
        this.eWW.setAntiAlias(true);
        this.eWW.setStrokeWidth(1.0f);
        this.eWW.setDither(true);
        this.eWW.setStyle(Paint.Style.FILL);
        this.mShadowPaint = new Paint();
        this.mShadowPaint.setAntiAlias(true);
        this.mShadowPaint.setDither(true);
        this.mShadowPaint.setShadowLayer(20.0f, 0.0f, -2.0f, getResources().getColor(R.color.CAM_X0806));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (getWidth() <= l.getEquipmentWidth(getContext())) {
            this.eWY.reset();
            this.eWX.reset();
            this.eWX.moveTo(0.0f, getHeight() - this.eWZ);
            this.eWX.lineTo((getWidth() / 2) - (this.eXa / 2), getHeight() - this.eWZ);
            this.eWX.quadTo(((getWidth() / 2) - (this.eXa / 2)) + this.eXb, getHeight() - this.eWZ, ((getWidth() / 2) - (this.eXa / 2)) + this.eXc, (getHeight() - this.eWZ) - this.eXd);
            this.eWX.quadTo(getWidth() / 2, (getHeight() - this.eWZ) - this.eXe, ((getWidth() / 2) + (this.eXa / 2)) - this.eXc, (getHeight() - this.eWZ) - this.eXd);
            this.eWX.quadTo(((getWidth() / 2) + (this.eXa / 2)) - this.eXb, getHeight() - this.eWZ, (getWidth() / 2) + (this.eXa / 2), getHeight() - this.eWZ);
            this.eWX.lineTo(getWidth(), getHeight() - this.eWZ);
            this.eWX.lineTo(getWidth(), getHeight());
            this.eWX.lineTo(0.0f, getHeight());
            this.eWX.close();
            this.eWY.moveTo(0.0f, (getHeight() - this.eWZ) + this.eXf);
            this.eWY.lineTo((getWidth() / 2) - (this.eXa / 2), (getHeight() - this.eWZ) + this.eXf);
            this.eWY.quadTo(((getWidth() / 2) - (this.eXa / 2)) + this.eXb, (getHeight() - this.eWZ) + this.eXf, ((getWidth() / 2) - (this.eXa / 2)) + this.eXc, ((getHeight() - this.eWZ) - this.eXd) + this.eXf);
            this.eWY.quadTo(getWidth() / 2, ((getHeight() - this.eWZ) - this.eXe) + this.eXf, ((getWidth() / 2) + (this.eXa / 2)) - this.eXc, ((getHeight() - this.eWZ) - this.eXd) + this.eXf);
            this.eWY.quadTo(((getWidth() / 2) + (this.eXa / 2)) - this.eXb, (getHeight() - this.eWZ) + this.eXf, (getWidth() / 2) + (this.eXa / 2), (getHeight() - this.eWZ) + this.eXf);
            this.eWY.lineTo(getWidth(), (getHeight() - this.eWZ) + this.eXf);
            this.eWY.lineTo(getWidth(), getHeight());
            this.eWY.lineTo(0.0f, getHeight());
            this.eWY.close();
            canvas.drawPath(this.eWY, this.mShadowPaint);
            canvas.drawPath(this.eWX, this.eWW);
        }
    }

    public void onChangeSkinType(int i) {
        if (i == 1 || i == 4) {
            this.eWW.setColor(ao.getColor(R.color.CAM_X0206_1));
            this.mShadowPaint.setShadowLayer(20.0f, 0.0f, -2.0f, getResources().getColor(R.color.transparent));
        } else {
            this.eWW.setColor(ao.getColor(R.color.CAM_X0205));
            this.mShadowPaint.setShadowLayer(20.0f, 0.0f, -2.0f, getResources().getColor(R.color.CAM_X0806));
        }
        invalidate();
    }
}
