package com.baidu.tbadk.core.tabHost;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class FragmentTabSwellingView extends View {
    private Paint dYZ;
    private Path dZa;
    private Path dZb;
    private int dZc;
    private int dZd;
    private int dZe;
    private int dZf;
    private int dZg;
    private int dZh;
    private int dZi;
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
        aZR();
        aZT();
        aZS();
        setLayerType(1, null);
    }

    private void aZR() {
        this.dZc = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds137);
        this.dZd = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds204);
        this.dZe = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds23);
        this.dZf = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds51);
        this.dZg = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds16);
        this.dZh = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds52);
        this.dZi = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds2);
    }

    private void aZS() {
        this.dZa = new Path();
        this.dZb = new Path();
    }

    private void aZT() {
        this.dYZ = new Paint();
        this.dYZ.setColor(ao.getColor(R.color.cp_bg_line_e));
        this.dYZ.setAntiAlias(true);
        this.dYZ.setStrokeWidth(1.0f);
        this.dYZ.setDither(true);
        this.dYZ.setStyle(Paint.Style.FILL);
        this.mShadowPaint = new Paint();
        this.mShadowPaint.setAntiAlias(true);
        this.mShadowPaint.setDither(true);
        this.mShadowPaint.setShadowLayer(20.0f, 0.0f, -2.0f, getResources().getColor(R.color.cp_shadow_a_alpha33));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (getWidth() <= l.getEquipmentWidth(getContext())) {
            this.dZb.reset();
            this.dZa.reset();
            this.dZa.moveTo(0.0f, getHeight() - this.dZc);
            this.dZa.lineTo((getWidth() / 2) - (this.dZd / 2), getHeight() - this.dZc);
            this.dZa.quadTo(((getWidth() / 2) - (this.dZd / 2)) + this.dZe, getHeight() - this.dZc, ((getWidth() / 2) - (this.dZd / 2)) + this.dZf, (getHeight() - this.dZc) - this.dZg);
            this.dZa.quadTo(getWidth() / 2, (getHeight() - this.dZc) - this.dZh, ((getWidth() / 2) + (this.dZd / 2)) - this.dZf, (getHeight() - this.dZc) - this.dZg);
            this.dZa.quadTo(((getWidth() / 2) + (this.dZd / 2)) - this.dZe, getHeight() - this.dZc, (getWidth() / 2) + (this.dZd / 2), getHeight() - this.dZc);
            this.dZa.lineTo(getWidth(), getHeight() - this.dZc);
            this.dZa.lineTo(getWidth(), getHeight());
            this.dZa.lineTo(0.0f, getHeight());
            this.dZa.close();
            this.dZb.moveTo(0.0f, (getHeight() - this.dZc) + this.dZi);
            this.dZb.lineTo((getWidth() / 2) - (this.dZd / 2), (getHeight() - this.dZc) + this.dZi);
            this.dZb.quadTo(((getWidth() / 2) - (this.dZd / 2)) + this.dZe, (getHeight() - this.dZc) + this.dZi, ((getWidth() / 2) - (this.dZd / 2)) + this.dZf, ((getHeight() - this.dZc) - this.dZg) + this.dZi);
            this.dZb.quadTo(getWidth() / 2, ((getHeight() - this.dZc) - this.dZh) + this.dZi, ((getWidth() / 2) + (this.dZd / 2)) - this.dZf, ((getHeight() - this.dZc) - this.dZg) + this.dZi);
            this.dZb.quadTo(((getWidth() / 2) + (this.dZd / 2)) - this.dZe, (getHeight() - this.dZc) + this.dZi, (getWidth() / 2) + (this.dZd / 2), (getHeight() - this.dZc) + this.dZi);
            this.dZb.lineTo(getWidth(), (getHeight() - this.dZc) + this.dZi);
            this.dZb.lineTo(getWidth(), getHeight());
            this.dZb.lineTo(0.0f, getHeight());
            this.dZb.close();
            canvas.drawPath(this.dZb, this.mShadowPaint);
            canvas.drawPath(this.dZa, this.dYZ);
        }
    }

    public void onChangeSkinType(int i) {
        if (i == 1 || i == 4) {
            this.dYZ.setColor(ao.getColor(R.color.cp_bg_line_g_1));
            this.mShadowPaint.setShadowLayer(20.0f, 0.0f, -2.0f, getResources().getColor(R.color.transparent));
        } else {
            this.dYZ.setColor(ao.getColor(R.color.cp_bg_line_e));
            this.mShadowPaint.setShadowLayer(20.0f, 0.0f, -2.0f, getResources().getColor(R.color.cp_shadow_a_alpha33));
        }
        invalidate();
    }
}
