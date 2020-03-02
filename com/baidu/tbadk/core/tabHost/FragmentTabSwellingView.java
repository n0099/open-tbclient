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
    private Paint cYj;
    private Path cYk;
    private Path cYl;
    private int cYm;
    private int cYn;
    private int cYo;
    private int cYp;
    private int cYq;
    private int cYr;
    private int cYs;
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
        aFF();
        aFH();
        aFG();
        setLayerType(1, null);
    }

    private void aFF() {
        this.cYm = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds137);
        this.cYn = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds204);
        this.cYo = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds23);
        this.cYp = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds51);
        this.cYq = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds16);
        this.cYr = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds43);
        this.cYs = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds2);
    }

    private void aFG() {
        this.cYk = new Path();
        this.cYl = new Path();
    }

    private void aFH() {
        this.cYj = new Paint();
        this.cYj.setColor(am.getColor(R.color.cp_bg_line_e));
        this.cYj.setAntiAlias(true);
        this.cYj.setStrokeWidth(1.0f);
        this.cYj.setDither(true);
        this.cYj.setStyle(Paint.Style.FILL);
        this.mShadowPaint = new Paint();
        this.mShadowPaint.setAntiAlias(true);
        this.mShadowPaint.setDither(true);
        this.mShadowPaint.setShadowLayer(20.0f, 0.0f, -2.0f, getResources().getColor(R.color.cp_shadow_a_alpha33));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.cYk.moveTo(0.0f, getHeight() - this.cYm);
        this.cYk.lineTo((getWidth() / 2) - (this.cYn / 2), getHeight() - this.cYm);
        this.cYk.quadTo(((getWidth() / 2) - (this.cYn / 2)) + this.cYo, getHeight() - this.cYm, ((getWidth() / 2) - (this.cYn / 2)) + this.cYp, (getHeight() - this.cYm) - this.cYq);
        this.cYk.quadTo(getWidth() / 2, (getHeight() - this.cYm) - this.cYr, ((getWidth() / 2) + (this.cYn / 2)) - this.cYp, (getHeight() - this.cYm) - this.cYq);
        this.cYk.quadTo(((getWidth() / 2) + (this.cYn / 2)) - this.cYo, getHeight() - this.cYm, (getWidth() / 2) + (this.cYn / 2), getHeight() - this.cYm);
        this.cYk.lineTo(getWidth(), getHeight() - this.cYm);
        this.cYk.lineTo(getWidth(), getHeight());
        this.cYk.lineTo(0.0f, getHeight());
        this.cYk.close();
        this.cYl.moveTo(0.0f, (getHeight() - this.cYm) + this.cYs);
        this.cYl.lineTo((getWidth() / 2) - (this.cYn / 2), (getHeight() - this.cYm) + this.cYs);
        this.cYl.quadTo(((getWidth() / 2) - (this.cYn / 2)) + this.cYo, (getHeight() - this.cYm) + this.cYs, ((getWidth() / 2) - (this.cYn / 2)) + this.cYp, ((getHeight() - this.cYm) - this.cYq) + this.cYs);
        this.cYl.quadTo(getWidth() / 2, ((getHeight() - this.cYm) - this.cYr) + this.cYs, ((getWidth() / 2) + (this.cYn / 2)) - this.cYp, ((getHeight() - this.cYm) - this.cYq) + this.cYs);
        this.cYl.quadTo(((getWidth() / 2) + (this.cYn / 2)) - this.cYo, (getHeight() - this.cYm) + this.cYs, (getWidth() / 2) + (this.cYn / 2), (getHeight() - this.cYm) + this.cYs);
        this.cYl.lineTo(getWidth(), (getHeight() - this.cYm) + this.cYs);
        this.cYl.lineTo(getWidth(), getHeight());
        this.cYl.lineTo(0.0f, getHeight());
        this.cYl.close();
        canvas.drawPath(this.cYl, this.mShadowPaint);
        canvas.drawPath(this.cYk, this.cYj);
    }

    public void onChangeSkinType(int i) {
        this.cYj.setColor(am.getColor(R.color.cp_bg_line_e));
        if (i == 1 || i == 4) {
            this.mShadowPaint.setShadowLayer(20.0f, 0.0f, -2.0f, getResources().getColor(R.color.transparent));
        } else {
            this.mShadowPaint.setShadowLayer(20.0f, 0.0f, -2.0f, getResources().getColor(R.color.cp_shadow_a_alpha33));
        }
        invalidate();
    }
}
