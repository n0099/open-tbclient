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
    private Paint cYi;
    private Path cYj;
    private Path cYk;
    private int cYl;
    private int cYm;
    private int cYn;
    private int cYo;
    private int cYp;
    private int cYq;
    private int cYr;
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
        aFD();
        aFF();
        aFE();
        setLayerType(1, null);
    }

    private void aFD() {
        this.cYl = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds137);
        this.cYm = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds204);
        this.cYn = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds23);
        this.cYo = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds51);
        this.cYp = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds16);
        this.cYq = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds43);
        this.cYr = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds2);
    }

    private void aFE() {
        this.cYj = new Path();
        this.cYk = new Path();
    }

    private void aFF() {
        this.cYi = new Paint();
        this.cYi.setColor(am.getColor(R.color.cp_bg_line_e));
        this.cYi.setAntiAlias(true);
        this.cYi.setStrokeWidth(1.0f);
        this.cYi.setDither(true);
        this.cYi.setStyle(Paint.Style.FILL);
        this.mShadowPaint = new Paint();
        this.mShadowPaint.setAntiAlias(true);
        this.mShadowPaint.setDither(true);
        this.mShadowPaint.setShadowLayer(20.0f, 0.0f, -2.0f, getResources().getColor(R.color.cp_shadow_a_alpha33));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.cYj.moveTo(0.0f, getHeight() - this.cYl);
        this.cYj.lineTo((getWidth() / 2) - (this.cYm / 2), getHeight() - this.cYl);
        this.cYj.quadTo(((getWidth() / 2) - (this.cYm / 2)) + this.cYn, getHeight() - this.cYl, ((getWidth() / 2) - (this.cYm / 2)) + this.cYo, (getHeight() - this.cYl) - this.cYp);
        this.cYj.quadTo(getWidth() / 2, (getHeight() - this.cYl) - this.cYq, ((getWidth() / 2) + (this.cYm / 2)) - this.cYo, (getHeight() - this.cYl) - this.cYp);
        this.cYj.quadTo(((getWidth() / 2) + (this.cYm / 2)) - this.cYn, getHeight() - this.cYl, (getWidth() / 2) + (this.cYm / 2), getHeight() - this.cYl);
        this.cYj.lineTo(getWidth(), getHeight() - this.cYl);
        this.cYj.lineTo(getWidth(), getHeight());
        this.cYj.lineTo(0.0f, getHeight());
        this.cYj.close();
        this.cYk.moveTo(0.0f, (getHeight() - this.cYl) + this.cYr);
        this.cYk.lineTo((getWidth() / 2) - (this.cYm / 2), (getHeight() - this.cYl) + this.cYr);
        this.cYk.quadTo(((getWidth() / 2) - (this.cYm / 2)) + this.cYn, (getHeight() - this.cYl) + this.cYr, ((getWidth() / 2) - (this.cYm / 2)) + this.cYo, ((getHeight() - this.cYl) - this.cYp) + this.cYr);
        this.cYk.quadTo(getWidth() / 2, ((getHeight() - this.cYl) - this.cYq) + this.cYr, ((getWidth() / 2) + (this.cYm / 2)) - this.cYo, ((getHeight() - this.cYl) - this.cYp) + this.cYr);
        this.cYk.quadTo(((getWidth() / 2) + (this.cYm / 2)) - this.cYn, (getHeight() - this.cYl) + this.cYr, (getWidth() / 2) + (this.cYm / 2), (getHeight() - this.cYl) + this.cYr);
        this.cYk.lineTo(getWidth(), (getHeight() - this.cYl) + this.cYr);
        this.cYk.lineTo(getWidth(), getHeight());
        this.cYk.lineTo(0.0f, getHeight());
        this.cYk.close();
        canvas.drawPath(this.cYk, this.mShadowPaint);
        canvas.drawPath(this.cYj, this.cYi);
    }

    public void onChangeSkinType(int i) {
        this.cYi.setColor(am.getColor(R.color.cp_bg_line_e));
        if (i == 1 || i == 4) {
            this.mShadowPaint.setShadowLayer(20.0f, 0.0f, -2.0f, getResources().getColor(R.color.transparent));
        } else {
            this.mShadowPaint.setShadowLayer(20.0f, 0.0f, -2.0f, getResources().getColor(R.color.cp_shadow_a_alpha33));
        }
        invalidate();
    }
}
