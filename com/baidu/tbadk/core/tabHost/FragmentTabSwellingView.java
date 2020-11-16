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
    private int eKA;
    private int eKB;
    private int eKC;
    private Paint eKt;
    private Path eKu;
    private Path eKv;
    private int eKw;
    private int eKx;
    private int eKy;
    private int eKz;
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
        bpw();
        bpy();
        bpx();
        setLayerType(1, null);
    }

    private void bpw() {
        this.eKw = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds137);
        this.eKx = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds204);
        this.eKy = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds23);
        this.eKz = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds51);
        this.eKA = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds16);
        this.eKB = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds52);
        this.eKC = l.getDimens(getContext().getApplicationContext(), R.dimen.tbds2);
    }

    private void bpx() {
        this.eKu = new Path();
        this.eKv = new Path();
    }

    private void bpy() {
        this.eKt = new Paint();
        this.eKt.setColor(ap.getColor(R.color.CAM_X0205));
        this.eKt.setAntiAlias(true);
        this.eKt.setStrokeWidth(1.0f);
        this.eKt.setDither(true);
        this.eKt.setStyle(Paint.Style.FILL);
        this.mShadowPaint = new Paint();
        this.mShadowPaint.setAntiAlias(true);
        this.mShadowPaint.setDither(true);
        this.mShadowPaint.setShadowLayer(20.0f, 0.0f, -2.0f, getResources().getColor(R.color.CAM_X0806));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (getWidth() <= l.getEquipmentWidth(getContext())) {
            this.eKv.reset();
            this.eKu.reset();
            this.eKu.moveTo(0.0f, getHeight() - this.eKw);
            this.eKu.lineTo((getWidth() / 2) - (this.eKx / 2), getHeight() - this.eKw);
            this.eKu.quadTo(((getWidth() / 2) - (this.eKx / 2)) + this.eKy, getHeight() - this.eKw, ((getWidth() / 2) - (this.eKx / 2)) + this.eKz, (getHeight() - this.eKw) - this.eKA);
            this.eKu.quadTo(getWidth() / 2, (getHeight() - this.eKw) - this.eKB, ((getWidth() / 2) + (this.eKx / 2)) - this.eKz, (getHeight() - this.eKw) - this.eKA);
            this.eKu.quadTo(((getWidth() / 2) + (this.eKx / 2)) - this.eKy, getHeight() - this.eKw, (getWidth() / 2) + (this.eKx / 2), getHeight() - this.eKw);
            this.eKu.lineTo(getWidth(), getHeight() - this.eKw);
            this.eKu.lineTo(getWidth(), getHeight());
            this.eKu.lineTo(0.0f, getHeight());
            this.eKu.close();
            this.eKv.moveTo(0.0f, (getHeight() - this.eKw) + this.eKC);
            this.eKv.lineTo((getWidth() / 2) - (this.eKx / 2), (getHeight() - this.eKw) + this.eKC);
            this.eKv.quadTo(((getWidth() / 2) - (this.eKx / 2)) + this.eKy, (getHeight() - this.eKw) + this.eKC, ((getWidth() / 2) - (this.eKx / 2)) + this.eKz, ((getHeight() - this.eKw) - this.eKA) + this.eKC);
            this.eKv.quadTo(getWidth() / 2, ((getHeight() - this.eKw) - this.eKB) + this.eKC, ((getWidth() / 2) + (this.eKx / 2)) - this.eKz, ((getHeight() - this.eKw) - this.eKA) + this.eKC);
            this.eKv.quadTo(((getWidth() / 2) + (this.eKx / 2)) - this.eKy, (getHeight() - this.eKw) + this.eKC, (getWidth() / 2) + (this.eKx / 2), (getHeight() - this.eKw) + this.eKC);
            this.eKv.lineTo(getWidth(), (getHeight() - this.eKw) + this.eKC);
            this.eKv.lineTo(getWidth(), getHeight());
            this.eKv.lineTo(0.0f, getHeight());
            this.eKv.close();
            canvas.drawPath(this.eKv, this.mShadowPaint);
            canvas.drawPath(this.eKu, this.eKt);
        }
    }

    public void onChangeSkinType(int i) {
        if (i == 1 || i == 4) {
            this.eKt.setColor(ap.getColor(R.color.CAM_X0206_1));
            this.mShadowPaint.setShadowLayer(20.0f, 0.0f, -2.0f, getResources().getColor(R.color.transparent));
        } else {
            this.eKt.setColor(ap.getColor(R.color.CAM_X0205));
            this.mShadowPaint.setShadowLayer(20.0f, 0.0f, -2.0f, getResources().getColor(R.color.CAM_X0806));
        }
        invalidate();
    }
}
