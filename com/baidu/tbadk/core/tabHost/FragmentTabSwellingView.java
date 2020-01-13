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
    private Paint cUg;
    private Path cUh;
    private Path cUi;
    private int cUj;
    private int cUk;
    private int cUl;
    private int cUm;
    private int cUn;
    private int cUo;
    private int cUp;
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
        aDt();
        aDv();
        aDu();
        setLayerType(1, null);
    }

    private void aDt() {
        this.cUj = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds137);
        this.cUk = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds204);
        this.cUl = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds23);
        this.cUm = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds51);
        this.cUn = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds16);
        this.cUo = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds43);
        this.cUp = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds2);
    }

    private void aDu() {
        this.cUh = new Path();
        this.cUi = new Path();
    }

    private void aDv() {
        this.cUg = new Paint();
        this.cUg.setColor(am.getColor(R.color.cp_bg_line_e));
        this.cUg.setAntiAlias(true);
        this.cUg.setStrokeWidth(1.0f);
        this.cUg.setDither(true);
        this.cUg.setStyle(Paint.Style.FILL);
        this.mShadowPaint = new Paint();
        this.mShadowPaint.setAntiAlias(true);
        this.mShadowPaint.setDither(true);
        this.mShadowPaint.setShadowLayer(20.0f, 0.0f, -2.0f, getResources().getColor(R.color.cp_shadow_a_alpha33));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.cUh.moveTo(0.0f, getHeight() - this.cUj);
        this.cUh.lineTo((getWidth() / 2) - (this.cUk / 2), getHeight() - this.cUj);
        this.cUh.quadTo(((getWidth() / 2) - (this.cUk / 2)) + this.cUl, getHeight() - this.cUj, ((getWidth() / 2) - (this.cUk / 2)) + this.cUm, (getHeight() - this.cUj) - this.cUn);
        this.cUh.quadTo(getWidth() / 2, (getHeight() - this.cUj) - this.cUo, ((getWidth() / 2) + (this.cUk / 2)) - this.cUm, (getHeight() - this.cUj) - this.cUn);
        this.cUh.quadTo(((getWidth() / 2) + (this.cUk / 2)) - this.cUl, getHeight() - this.cUj, (getWidth() / 2) + (this.cUk / 2), getHeight() - this.cUj);
        this.cUh.lineTo(getWidth(), getHeight() - this.cUj);
        this.cUh.lineTo(getWidth(), getHeight());
        this.cUh.lineTo(0.0f, getHeight());
        this.cUh.close();
        this.cUi.moveTo(0.0f, (getHeight() - this.cUj) + this.cUp);
        this.cUi.lineTo((getWidth() / 2) - (this.cUk / 2), (getHeight() - this.cUj) + this.cUp);
        this.cUi.quadTo(((getWidth() / 2) - (this.cUk / 2)) + this.cUl, (getHeight() - this.cUj) + this.cUp, ((getWidth() / 2) - (this.cUk / 2)) + this.cUm, ((getHeight() - this.cUj) - this.cUn) + this.cUp);
        this.cUi.quadTo(getWidth() / 2, ((getHeight() - this.cUj) - this.cUo) + this.cUp, ((getWidth() / 2) + (this.cUk / 2)) - this.cUm, ((getHeight() - this.cUj) - this.cUn) + this.cUp);
        this.cUi.quadTo(((getWidth() / 2) + (this.cUk / 2)) - this.cUl, (getHeight() - this.cUj) + this.cUp, (getWidth() / 2) + (this.cUk / 2), (getHeight() - this.cUj) + this.cUp);
        this.cUi.lineTo(getWidth(), (getHeight() - this.cUj) + this.cUp);
        this.cUi.lineTo(getWidth(), getHeight());
        this.cUi.lineTo(0.0f, getHeight());
        this.cUi.close();
        canvas.drawPath(this.cUi, this.mShadowPaint);
        canvas.drawPath(this.cUh, this.cUg);
    }

    public void onChangeSkinType(int i) {
        this.cUg.setColor(am.getColor(R.color.cp_bg_line_e));
        if (i == 1 || i == 4) {
            this.mShadowPaint.setShadowLayer(20.0f, 0.0f, -2.0f, getResources().getColor(R.color.transparent));
        } else {
            this.mShadowPaint.setShadowLayer(20.0f, 0.0f, -2.0f, getResources().getColor(R.color.cp_shadow_a_alpha33));
        }
        invalidate();
    }
}
