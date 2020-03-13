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
    private Paint cYk;
    private Path cYl;
    private Path cYm;
    private int cYn;
    private int cYo;
    private int cYp;
    private int cYq;
    private int cYr;
    private int cYs;
    private int cYt;
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
        this.cYn = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds137);
        this.cYo = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds204);
        this.cYp = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds23);
        this.cYq = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds51);
        this.cYr = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds16);
        this.cYs = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds43);
        this.cYt = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds2);
    }

    private void aFG() {
        this.cYl = new Path();
        this.cYm = new Path();
    }

    private void aFH() {
        this.cYk = new Paint();
        this.cYk.setColor(am.getColor(R.color.cp_bg_line_e));
        this.cYk.setAntiAlias(true);
        this.cYk.setStrokeWidth(1.0f);
        this.cYk.setDither(true);
        this.cYk.setStyle(Paint.Style.FILL);
        this.mShadowPaint = new Paint();
        this.mShadowPaint.setAntiAlias(true);
        this.mShadowPaint.setDither(true);
        this.mShadowPaint.setShadowLayer(20.0f, 0.0f, -2.0f, getResources().getColor(R.color.cp_shadow_a_alpha33));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.cYl.moveTo(0.0f, getHeight() - this.cYn);
        this.cYl.lineTo((getWidth() / 2) - (this.cYo / 2), getHeight() - this.cYn);
        this.cYl.quadTo(((getWidth() / 2) - (this.cYo / 2)) + this.cYp, getHeight() - this.cYn, ((getWidth() / 2) - (this.cYo / 2)) + this.cYq, (getHeight() - this.cYn) - this.cYr);
        this.cYl.quadTo(getWidth() / 2, (getHeight() - this.cYn) - this.cYs, ((getWidth() / 2) + (this.cYo / 2)) - this.cYq, (getHeight() - this.cYn) - this.cYr);
        this.cYl.quadTo(((getWidth() / 2) + (this.cYo / 2)) - this.cYp, getHeight() - this.cYn, (getWidth() / 2) + (this.cYo / 2), getHeight() - this.cYn);
        this.cYl.lineTo(getWidth(), getHeight() - this.cYn);
        this.cYl.lineTo(getWidth(), getHeight());
        this.cYl.lineTo(0.0f, getHeight());
        this.cYl.close();
        this.cYm.moveTo(0.0f, (getHeight() - this.cYn) + this.cYt);
        this.cYm.lineTo((getWidth() / 2) - (this.cYo / 2), (getHeight() - this.cYn) + this.cYt);
        this.cYm.quadTo(((getWidth() / 2) - (this.cYo / 2)) + this.cYp, (getHeight() - this.cYn) + this.cYt, ((getWidth() / 2) - (this.cYo / 2)) + this.cYq, ((getHeight() - this.cYn) - this.cYr) + this.cYt);
        this.cYm.quadTo(getWidth() / 2, ((getHeight() - this.cYn) - this.cYs) + this.cYt, ((getWidth() / 2) + (this.cYo / 2)) - this.cYq, ((getHeight() - this.cYn) - this.cYr) + this.cYt);
        this.cYm.quadTo(((getWidth() / 2) + (this.cYo / 2)) - this.cYp, (getHeight() - this.cYn) + this.cYt, (getWidth() / 2) + (this.cYo / 2), (getHeight() - this.cYn) + this.cYt);
        this.cYm.lineTo(getWidth(), (getHeight() - this.cYn) + this.cYt);
        this.cYm.lineTo(getWidth(), getHeight());
        this.cYm.lineTo(0.0f, getHeight());
        this.cYm.close();
        canvas.drawPath(this.cYm, this.mShadowPaint);
        canvas.drawPath(this.cYl, this.cYk);
    }

    public void onChangeSkinType(int i) {
        this.cYk.setColor(am.getColor(R.color.cp_bg_line_e));
        if (i == 1 || i == 4) {
            this.mShadowPaint.setShadowLayer(20.0f, 0.0f, -2.0f, getResources().getColor(R.color.transparent));
        } else {
            this.mShadowPaint.setShadowLayer(20.0f, 0.0f, -2.0f, getResources().getColor(R.color.cp_shadow_a_alpha33));
        }
        invalidate();
    }
}
