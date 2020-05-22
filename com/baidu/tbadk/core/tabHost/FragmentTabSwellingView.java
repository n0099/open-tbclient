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
    private Paint dLR;
    private Path dLS;
    private Path dLT;
    private int dLU;
    private int dLV;
    private int dLW;
    private int dLX;
    private int dLY;
    private int dLZ;
    private int dMa;
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
        aTZ();
        aUb();
        aUa();
        setLayerType(1, null);
    }

    private void aTZ() {
        this.dLU = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds137);
        this.dLV = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds204);
        this.dLW = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds23);
        this.dLX = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds51);
        this.dLY = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds16);
        this.dLZ = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds52);
        this.dMa = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds2);
    }

    private void aUa() {
        this.dLS = new Path();
        this.dLT = new Path();
    }

    private void aUb() {
        this.dLR = new Paint();
        this.dLR.setColor(am.getColor(R.color.cp_bg_line_e));
        this.dLR.setAntiAlias(true);
        this.dLR.setStrokeWidth(1.0f);
        this.dLR.setDither(true);
        this.dLR.setStyle(Paint.Style.FILL);
        this.mShadowPaint = new Paint();
        this.mShadowPaint.setAntiAlias(true);
        this.mShadowPaint.setDither(true);
        this.mShadowPaint.setShadowLayer(20.0f, 0.0f, -2.0f, getResources().getColor(R.color.cp_shadow_a_alpha33));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (getWidth() <= l.getEquipmentWidth(getContext())) {
            this.dLS.moveTo(0.0f, getHeight() - this.dLU);
            this.dLS.lineTo((getWidth() / 2) - (this.dLV / 2), getHeight() - this.dLU);
            this.dLS.quadTo(((getWidth() / 2) - (this.dLV / 2)) + this.dLW, getHeight() - this.dLU, ((getWidth() / 2) - (this.dLV / 2)) + this.dLX, (getHeight() - this.dLU) - this.dLY);
            this.dLS.quadTo(getWidth() / 2, (getHeight() - this.dLU) - this.dLZ, ((getWidth() / 2) + (this.dLV / 2)) - this.dLX, (getHeight() - this.dLU) - this.dLY);
            this.dLS.quadTo(((getWidth() / 2) + (this.dLV / 2)) - this.dLW, getHeight() - this.dLU, (getWidth() / 2) + (this.dLV / 2), getHeight() - this.dLU);
            this.dLS.lineTo(getWidth(), getHeight() - this.dLU);
            this.dLS.lineTo(getWidth(), getHeight());
            this.dLS.lineTo(0.0f, getHeight());
            this.dLS.close();
            this.dLT.moveTo(0.0f, (getHeight() - this.dLU) + this.dMa);
            this.dLT.lineTo((getWidth() / 2) - (this.dLV / 2), (getHeight() - this.dLU) + this.dMa);
            this.dLT.quadTo(((getWidth() / 2) - (this.dLV / 2)) + this.dLW, (getHeight() - this.dLU) + this.dMa, ((getWidth() / 2) - (this.dLV / 2)) + this.dLX, ((getHeight() - this.dLU) - this.dLY) + this.dMa);
            this.dLT.quadTo(getWidth() / 2, ((getHeight() - this.dLU) - this.dLZ) + this.dMa, ((getWidth() / 2) + (this.dLV / 2)) - this.dLX, ((getHeight() - this.dLU) - this.dLY) + this.dMa);
            this.dLT.quadTo(((getWidth() / 2) + (this.dLV / 2)) - this.dLW, (getHeight() - this.dLU) + this.dMa, (getWidth() / 2) + (this.dLV / 2), (getHeight() - this.dLU) + this.dMa);
            this.dLT.lineTo(getWidth(), (getHeight() - this.dLU) + this.dMa);
            this.dLT.lineTo(getWidth(), getHeight());
            this.dLT.lineTo(0.0f, getHeight());
            this.dLT.close();
            canvas.drawPath(this.dLT, this.mShadowPaint);
            canvas.drawPath(this.dLS, this.dLR);
        }
    }

    public void onChangeSkinType(int i) {
        this.dLR.setColor(am.getColor(R.color.cp_bg_line_e));
        if (i == 1 || i == 4) {
            this.mShadowPaint.setShadowLayer(20.0f, 0.0f, -2.0f, getResources().getColor(R.color.transparent));
        } else {
            this.mShadowPaint.setShadowLayer(20.0f, 0.0f, -2.0f, getResources().getColor(R.color.cp_shadow_a_alpha33));
        }
        invalidate();
    }
}
