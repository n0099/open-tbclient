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
    private Paint eZm;
    private Path eZn;
    private Path eZo;
    private int eZp;
    private int eZq;
    private int eZr;
    private int eZs;
    private int eZt;
    private int eZu;
    private int eZv;
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
        brS();
        brU();
        brT();
        setLayerType(1, null);
    }

    private void brS() {
        this.eZp = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds137);
        this.eZq = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds204);
        this.eZr = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds23);
        this.eZs = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds51);
        this.eZt = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds16);
        this.eZu = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds52);
        this.eZv = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds2);
    }

    private void brT() {
        this.eZn = new Path();
        this.eZo = new Path();
    }

    private void brU() {
        this.eZm = new Paint();
        this.eZm.setColor(ap.getColor(R.color.CAM_X0205));
        this.eZm.setAntiAlias(true);
        this.eZm.setStrokeWidth(1.0f);
        this.eZm.setDither(true);
        this.eZm.setStyle(Paint.Style.FILL);
        this.mShadowPaint = new Paint();
        this.mShadowPaint.setAntiAlias(true);
        this.mShadowPaint.setDither(true);
        this.mShadowPaint.setShadowLayer(20.0f, 0.0f, -2.0f, getResources().getColor(R.color.CAM_X0806));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (getWidth() <= l.getEquipmentWidth(getContext())) {
            this.eZo.reset();
            this.eZn.reset();
            this.eZn.moveTo(0.0f, getHeight() - this.eZp);
            this.eZn.lineTo((getWidth() / 2) - (this.eZq / 2), getHeight() - this.eZp);
            this.eZn.quadTo(((getWidth() / 2) - (this.eZq / 2)) + this.eZr, getHeight() - this.eZp, ((getWidth() / 2) - (this.eZq / 2)) + this.eZs, (getHeight() - this.eZp) - this.eZt);
            this.eZn.quadTo(getWidth() / 2, (getHeight() - this.eZp) - this.eZu, ((getWidth() / 2) + (this.eZq / 2)) - this.eZs, (getHeight() - this.eZp) - this.eZt);
            this.eZn.quadTo(((getWidth() / 2) + (this.eZq / 2)) - this.eZr, getHeight() - this.eZp, (getWidth() / 2) + (this.eZq / 2), getHeight() - this.eZp);
            this.eZn.lineTo(getWidth(), getHeight() - this.eZp);
            this.eZn.lineTo(getWidth(), getHeight());
            this.eZn.lineTo(0.0f, getHeight());
            this.eZn.close();
            this.eZo.moveTo(0.0f, (getHeight() - this.eZp) + this.eZv);
            this.eZo.lineTo((getWidth() / 2) - (this.eZq / 2), (getHeight() - this.eZp) + this.eZv);
            this.eZo.quadTo(((getWidth() / 2) - (this.eZq / 2)) + this.eZr, (getHeight() - this.eZp) + this.eZv, ((getWidth() / 2) - (this.eZq / 2)) + this.eZs, ((getHeight() - this.eZp) - this.eZt) + this.eZv);
            this.eZo.quadTo(getWidth() / 2, ((getHeight() - this.eZp) - this.eZu) + this.eZv, ((getWidth() / 2) + (this.eZq / 2)) - this.eZs, ((getHeight() - this.eZp) - this.eZt) + this.eZv);
            this.eZo.quadTo(((getWidth() / 2) + (this.eZq / 2)) - this.eZr, (getHeight() - this.eZp) + this.eZv, (getWidth() / 2) + (this.eZq / 2), (getHeight() - this.eZp) + this.eZv);
            this.eZo.lineTo(getWidth(), (getHeight() - this.eZp) + this.eZv);
            this.eZo.lineTo(getWidth(), getHeight());
            this.eZo.lineTo(0.0f, getHeight());
            this.eZo.close();
            canvas.drawPath(this.eZo, this.mShadowPaint);
            canvas.drawPath(this.eZn, this.eZm);
        }
    }

    public void onChangeSkinType(int i) {
        if (i == 1 || i == 4) {
            this.eZm.setColor(ap.getColor(R.color.CAM_X0206_1));
            this.mShadowPaint.setShadowLayer(20.0f, 0.0f, -2.0f, getResources().getColor(R.color.transparent));
        } else {
            this.eZm.setColor(ap.getColor(R.color.CAM_X0205));
            this.mShadowPaint.setShadowLayer(20.0f, 0.0f, -2.0f, getResources().getColor(R.color.CAM_X0806));
        }
        invalidate();
    }
}
