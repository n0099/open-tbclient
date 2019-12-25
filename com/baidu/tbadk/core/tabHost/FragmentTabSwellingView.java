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
    private Paint cTW;
    private Path cTX;
    private Path cTY;
    private int cTZ;
    private int cUa;
    private int cUb;
    private int cUc;
    private int cUd;
    private int cUe;
    private int cUf;
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
        aDa();
        aDc();
        aDb();
        setLayerType(1, null);
    }

    private void aDa() {
        this.cTZ = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds137);
        this.cUa = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds204);
        this.cUb = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds23);
        this.cUc = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds51);
        this.cUd = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds16);
        this.cUe = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds43);
        this.cUf = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds2);
    }

    private void aDb() {
        this.cTX = new Path();
        this.cTY = new Path();
    }

    private void aDc() {
        this.cTW = new Paint();
        this.cTW.setColor(am.getColor(R.color.cp_bg_line_e));
        this.cTW.setAntiAlias(true);
        this.cTW.setStrokeWidth(1.0f);
        this.cTW.setDither(true);
        this.cTW.setStyle(Paint.Style.FILL);
        this.mShadowPaint = new Paint();
        this.mShadowPaint.setAntiAlias(true);
        this.mShadowPaint.setDither(true);
        this.mShadowPaint.setShadowLayer(20.0f, 0.0f, -2.0f, getResources().getColor(R.color.cp_shadow_a_alpha33));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.cTX.moveTo(0.0f, getHeight() - this.cTZ);
        this.cTX.lineTo((getWidth() / 2) - (this.cUa / 2), getHeight() - this.cTZ);
        this.cTX.quadTo(((getWidth() / 2) - (this.cUa / 2)) + this.cUb, getHeight() - this.cTZ, ((getWidth() / 2) - (this.cUa / 2)) + this.cUc, (getHeight() - this.cTZ) - this.cUd);
        this.cTX.quadTo(getWidth() / 2, (getHeight() - this.cTZ) - this.cUe, ((getWidth() / 2) + (this.cUa / 2)) - this.cUc, (getHeight() - this.cTZ) - this.cUd);
        this.cTX.quadTo(((getWidth() / 2) + (this.cUa / 2)) - this.cUb, getHeight() - this.cTZ, (getWidth() / 2) + (this.cUa / 2), getHeight() - this.cTZ);
        this.cTX.lineTo(getWidth(), getHeight() - this.cTZ);
        this.cTX.lineTo(getWidth(), getHeight());
        this.cTX.lineTo(0.0f, getHeight());
        this.cTX.close();
        this.cTY.moveTo(0.0f, (getHeight() - this.cTZ) + this.cUf);
        this.cTY.lineTo((getWidth() / 2) - (this.cUa / 2), (getHeight() - this.cTZ) + this.cUf);
        this.cTY.quadTo(((getWidth() / 2) - (this.cUa / 2)) + this.cUb, (getHeight() - this.cTZ) + this.cUf, ((getWidth() / 2) - (this.cUa / 2)) + this.cUc, ((getHeight() - this.cTZ) - this.cUd) + this.cUf);
        this.cTY.quadTo(getWidth() / 2, ((getHeight() - this.cTZ) - this.cUe) + this.cUf, ((getWidth() / 2) + (this.cUa / 2)) - this.cUc, ((getHeight() - this.cTZ) - this.cUd) + this.cUf);
        this.cTY.quadTo(((getWidth() / 2) + (this.cUa / 2)) - this.cUb, (getHeight() - this.cTZ) + this.cUf, (getWidth() / 2) + (this.cUa / 2), (getHeight() - this.cTZ) + this.cUf);
        this.cTY.lineTo(getWidth(), (getHeight() - this.cTZ) + this.cUf);
        this.cTY.lineTo(getWidth(), getHeight());
        this.cTY.lineTo(0.0f, getHeight());
        this.cTY.close();
        canvas.drawPath(this.cTY, this.mShadowPaint);
        canvas.drawPath(this.cTX, this.cTW);
    }

    public void onChangeSkinType(int i) {
        this.cTW.setColor(am.getColor(R.color.cp_bg_line_e));
        if (i == 1 || i == 4) {
            this.mShadowPaint.setShadowLayer(20.0f, 0.0f, -2.0f, getResources().getColor(R.color.transparent));
        } else {
            this.mShadowPaint.setShadowLayer(20.0f, 0.0f, -2.0f, getResources().getColor(R.color.cp_shadow_a_alpha33));
        }
        invalidate();
    }
}
