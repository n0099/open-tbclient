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
    private int eLA;
    private int eLB;
    private int eLC;
    private int eLD;
    private Paint eLu;
    private Path eLv;
    private Path eLw;
    private int eLx;
    private int eLy;
    private int eLz;
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
        bqj();
        bql();
        bqk();
        setLayerType(1, null);
    }

    private void bqj() {
        this.eLx = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds137);
        this.eLy = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds204);
        this.eLz = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds23);
        this.eLA = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds51);
        this.eLB = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds16);
        this.eLC = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds52);
        this.eLD = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds2);
    }

    private void bqk() {
        this.eLv = new Path();
        this.eLw = new Path();
    }

    private void bql() {
        this.eLu = new Paint();
        this.eLu.setColor(ap.getColor(R.color.cp_bg_line_e));
        this.eLu.setAntiAlias(true);
        this.eLu.setStrokeWidth(1.0f);
        this.eLu.setDither(true);
        this.eLu.setStyle(Paint.Style.FILL);
        this.mShadowPaint = new Paint();
        this.mShadowPaint.setAntiAlias(true);
        this.mShadowPaint.setDither(true);
        this.mShadowPaint.setShadowLayer(20.0f, 0.0f, -2.0f, getResources().getColor(R.color.cp_shadow_a_alpha33));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (getWidth() <= l.getEquipmentWidth(getContext())) {
            this.eLw.reset();
            this.eLv.reset();
            this.eLv.moveTo(0.0f, getHeight() - this.eLx);
            this.eLv.lineTo((getWidth() / 2) - (this.eLy / 2), getHeight() - this.eLx);
            this.eLv.quadTo(((getWidth() / 2) - (this.eLy / 2)) + this.eLz, getHeight() - this.eLx, ((getWidth() / 2) - (this.eLy / 2)) + this.eLA, (getHeight() - this.eLx) - this.eLB);
            this.eLv.quadTo(getWidth() / 2, (getHeight() - this.eLx) - this.eLC, ((getWidth() / 2) + (this.eLy / 2)) - this.eLA, (getHeight() - this.eLx) - this.eLB);
            this.eLv.quadTo(((getWidth() / 2) + (this.eLy / 2)) - this.eLz, getHeight() - this.eLx, (getWidth() / 2) + (this.eLy / 2), getHeight() - this.eLx);
            this.eLv.lineTo(getWidth(), getHeight() - this.eLx);
            this.eLv.lineTo(getWidth(), getHeight());
            this.eLv.lineTo(0.0f, getHeight());
            this.eLv.close();
            this.eLw.moveTo(0.0f, (getHeight() - this.eLx) + this.eLD);
            this.eLw.lineTo((getWidth() / 2) - (this.eLy / 2), (getHeight() - this.eLx) + this.eLD);
            this.eLw.quadTo(((getWidth() / 2) - (this.eLy / 2)) + this.eLz, (getHeight() - this.eLx) + this.eLD, ((getWidth() / 2) - (this.eLy / 2)) + this.eLA, ((getHeight() - this.eLx) - this.eLB) + this.eLD);
            this.eLw.quadTo(getWidth() / 2, ((getHeight() - this.eLx) - this.eLC) + this.eLD, ((getWidth() / 2) + (this.eLy / 2)) - this.eLA, ((getHeight() - this.eLx) - this.eLB) + this.eLD);
            this.eLw.quadTo(((getWidth() / 2) + (this.eLy / 2)) - this.eLz, (getHeight() - this.eLx) + this.eLD, (getWidth() / 2) + (this.eLy / 2), (getHeight() - this.eLx) + this.eLD);
            this.eLw.lineTo(getWidth(), (getHeight() - this.eLx) + this.eLD);
            this.eLw.lineTo(getWidth(), getHeight());
            this.eLw.lineTo(0.0f, getHeight());
            this.eLw.close();
            canvas.drawPath(this.eLw, this.mShadowPaint);
            canvas.drawPath(this.eLv, this.eLu);
        }
    }

    public void onChangeSkinType(int i) {
        if (i == 1 || i == 4) {
            this.eLu.setColor(ap.getColor(R.color.cp_bg_line_g_1));
            this.mShadowPaint.setShadowLayer(20.0f, 0.0f, -2.0f, getResources().getColor(R.color.transparent));
        } else {
            this.eLu.setColor(ap.getColor(R.color.cp_bg_line_e));
            this.mShadowPaint.setShadowLayer(20.0f, 0.0f, -2.0f, getResources().getColor(R.color.cp_shadow_a_alpha33));
        }
        invalidate();
    }
}
