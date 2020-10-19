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
    private Paint exg;
    private Path exh;
    private Path exi;
    private int exj;
    private int exk;
    private int exl;
    private int exm;
    private int exn;
    private int exo;
    private int exp;
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
        blQ();
        blS();
        blR();
        setLayerType(1, null);
    }

    private void blQ() {
        this.exj = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds137);
        this.exk = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds204);
        this.exl = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds23);
        this.exm = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds51);
        this.exn = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds16);
        this.exo = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds52);
        this.exp = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds2);
    }

    private void blR() {
        this.exh = new Path();
        this.exi = new Path();
    }

    private void blS() {
        this.exg = new Paint();
        this.exg.setColor(ap.getColor(R.color.cp_bg_line_e));
        this.exg.setAntiAlias(true);
        this.exg.setStrokeWidth(1.0f);
        this.exg.setDither(true);
        this.exg.setStyle(Paint.Style.FILL);
        this.mShadowPaint = new Paint();
        this.mShadowPaint.setAntiAlias(true);
        this.mShadowPaint.setDither(true);
        this.mShadowPaint.setShadowLayer(20.0f, 0.0f, -2.0f, getResources().getColor(R.color.cp_shadow_a_alpha33));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (getWidth() <= l.getEquipmentWidth(getContext())) {
            this.exi.reset();
            this.exh.reset();
            this.exh.moveTo(0.0f, getHeight() - this.exj);
            this.exh.lineTo((getWidth() / 2) - (this.exk / 2), getHeight() - this.exj);
            this.exh.quadTo(((getWidth() / 2) - (this.exk / 2)) + this.exl, getHeight() - this.exj, ((getWidth() / 2) - (this.exk / 2)) + this.exm, (getHeight() - this.exj) - this.exn);
            this.exh.quadTo(getWidth() / 2, (getHeight() - this.exj) - this.exo, ((getWidth() / 2) + (this.exk / 2)) - this.exm, (getHeight() - this.exj) - this.exn);
            this.exh.quadTo(((getWidth() / 2) + (this.exk / 2)) - this.exl, getHeight() - this.exj, (getWidth() / 2) + (this.exk / 2), getHeight() - this.exj);
            this.exh.lineTo(getWidth(), getHeight() - this.exj);
            this.exh.lineTo(getWidth(), getHeight());
            this.exh.lineTo(0.0f, getHeight());
            this.exh.close();
            this.exi.moveTo(0.0f, (getHeight() - this.exj) + this.exp);
            this.exi.lineTo((getWidth() / 2) - (this.exk / 2), (getHeight() - this.exj) + this.exp);
            this.exi.quadTo(((getWidth() / 2) - (this.exk / 2)) + this.exl, (getHeight() - this.exj) + this.exp, ((getWidth() / 2) - (this.exk / 2)) + this.exm, ((getHeight() - this.exj) - this.exn) + this.exp);
            this.exi.quadTo(getWidth() / 2, ((getHeight() - this.exj) - this.exo) + this.exp, ((getWidth() / 2) + (this.exk / 2)) - this.exm, ((getHeight() - this.exj) - this.exn) + this.exp);
            this.exi.quadTo(((getWidth() / 2) + (this.exk / 2)) - this.exl, (getHeight() - this.exj) + this.exp, (getWidth() / 2) + (this.exk / 2), (getHeight() - this.exj) + this.exp);
            this.exi.lineTo(getWidth(), (getHeight() - this.exj) + this.exp);
            this.exi.lineTo(getWidth(), getHeight());
            this.exi.lineTo(0.0f, getHeight());
            this.exi.close();
            canvas.drawPath(this.exi, this.mShadowPaint);
            canvas.drawPath(this.exh, this.exg);
        }
    }

    public void onChangeSkinType(int i) {
        if (i == 1 || i == 4) {
            this.exg.setColor(ap.getColor(R.color.cp_bg_line_g_1));
            this.mShadowPaint.setShadowLayer(20.0f, 0.0f, -2.0f, getResources().getColor(R.color.transparent));
        } else {
            this.exg.setColor(ap.getColor(R.color.cp_bg_line_e));
            this.mShadowPaint.setShadowLayer(20.0f, 0.0f, -2.0f, getResources().getColor(R.color.cp_shadow_a_alpha33));
        }
        invalidate();
    }
}
