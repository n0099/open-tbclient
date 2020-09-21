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
    private Paint ekY;
    private Path ekZ;
    private Path ela;
    private int elb;
    private int elc;
    private int eld;
    private int ele;
    private int elf;
    private int elg;
    private int elh;
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
        bjh();
        bjj();
        bji();
        setLayerType(1, null);
    }

    private void bjh() {
        this.elb = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds137);
        this.elc = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds204);
        this.eld = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds23);
        this.ele = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds51);
        this.elf = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds16);
        this.elg = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds52);
        this.elh = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds2);
    }

    private void bji() {
        this.ekZ = new Path();
        this.ela = new Path();
    }

    private void bjj() {
        this.ekY = new Paint();
        this.ekY.setColor(ap.getColor(R.color.cp_bg_line_e));
        this.ekY.setAntiAlias(true);
        this.ekY.setStrokeWidth(1.0f);
        this.ekY.setDither(true);
        this.ekY.setStyle(Paint.Style.FILL);
        this.mShadowPaint = new Paint();
        this.mShadowPaint.setAntiAlias(true);
        this.mShadowPaint.setDither(true);
        this.mShadowPaint.setShadowLayer(20.0f, 0.0f, -2.0f, getResources().getColor(R.color.cp_shadow_a_alpha33));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (getWidth() <= l.getEquipmentWidth(getContext())) {
            this.ela.reset();
            this.ekZ.reset();
            this.ekZ.moveTo(0.0f, getHeight() - this.elb);
            this.ekZ.lineTo((getWidth() / 2) - (this.elc / 2), getHeight() - this.elb);
            this.ekZ.quadTo(((getWidth() / 2) - (this.elc / 2)) + this.eld, getHeight() - this.elb, ((getWidth() / 2) - (this.elc / 2)) + this.ele, (getHeight() - this.elb) - this.elf);
            this.ekZ.quadTo(getWidth() / 2, (getHeight() - this.elb) - this.elg, ((getWidth() / 2) + (this.elc / 2)) - this.ele, (getHeight() - this.elb) - this.elf);
            this.ekZ.quadTo(((getWidth() / 2) + (this.elc / 2)) - this.eld, getHeight() - this.elb, (getWidth() / 2) + (this.elc / 2), getHeight() - this.elb);
            this.ekZ.lineTo(getWidth(), getHeight() - this.elb);
            this.ekZ.lineTo(getWidth(), getHeight());
            this.ekZ.lineTo(0.0f, getHeight());
            this.ekZ.close();
            this.ela.moveTo(0.0f, (getHeight() - this.elb) + this.elh);
            this.ela.lineTo((getWidth() / 2) - (this.elc / 2), (getHeight() - this.elb) + this.elh);
            this.ela.quadTo(((getWidth() / 2) - (this.elc / 2)) + this.eld, (getHeight() - this.elb) + this.elh, ((getWidth() / 2) - (this.elc / 2)) + this.ele, ((getHeight() - this.elb) - this.elf) + this.elh);
            this.ela.quadTo(getWidth() / 2, ((getHeight() - this.elb) - this.elg) + this.elh, ((getWidth() / 2) + (this.elc / 2)) - this.ele, ((getHeight() - this.elb) - this.elf) + this.elh);
            this.ela.quadTo(((getWidth() / 2) + (this.elc / 2)) - this.eld, (getHeight() - this.elb) + this.elh, (getWidth() / 2) + (this.elc / 2), (getHeight() - this.elb) + this.elh);
            this.ela.lineTo(getWidth(), (getHeight() - this.elb) + this.elh);
            this.ela.lineTo(getWidth(), getHeight());
            this.ela.lineTo(0.0f, getHeight());
            this.ela.close();
            canvas.drawPath(this.ela, this.mShadowPaint);
            canvas.drawPath(this.ekZ, this.ekY);
        }
    }

    public void onChangeSkinType(int i) {
        if (i == 1 || i == 4) {
            this.ekY.setColor(ap.getColor(R.color.cp_bg_line_g_1));
            this.mShadowPaint.setShadowLayer(20.0f, 0.0f, -2.0f, getResources().getColor(R.color.transparent));
        } else {
            this.ekY.setColor(ap.getColor(R.color.cp_bg_line_e));
            this.mShadowPaint.setShadowLayer(20.0f, 0.0f, -2.0f, getResources().getColor(R.color.cp_shadow_a_alpha33));
        }
        invalidate();
    }
}
