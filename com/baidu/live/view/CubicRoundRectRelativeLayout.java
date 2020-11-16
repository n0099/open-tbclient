package com.baidu.live.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.baidu.live.sdk.a;
/* loaded from: classes4.dex */
public class CubicRoundRectRelativeLayout extends RelativeLayout {
    private float bKb;
    private float bKc;
    private boolean bKd;
    private boolean bKe;
    private float mHeight;
    private Paint mPaint;
    private Path mPath;
    private RectF mRectF;

    public CubicRoundRectRelativeLayout(@NonNull Context context) {
        this(context, null);
    }

    public CubicRoundRectRelativeLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init(attributeSet);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.mHeight = i2;
        this.bKb = i;
        this.mRectF.set(0.0f, 0.0f, i, i2);
        if (this.bKc == 0.0f) {
            this.bKc = 0.11f * this.bKb;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.bKe) {
            h(canvas);
        } else {
            i(canvas);
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        if (this.bKd) {
            if (this.bKe) {
                j(canvas);
                return;
            } else {
                k(canvas);
                return;
            }
        }
        super.draw(canvas);
    }

    private void init(AttributeSet attributeSet) {
        initFields();
        initAttrs(attributeSet);
    }

    private void initFields() {
        this.mPaint = new Paint(1);
        this.mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        this.mPath = new Path();
        this.mRectF = new RectF();
        this.bKd = true;
        this.bKe = Build.VERSION.SDK_INT >= 28;
    }

    private void initAttrs(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, a.j.sdk_CubicRoundRectRelativeLayout);
            this.bKd = obtainStyledAttributes.getBoolean(a.j.sdk_CubicRoundRectRelativeLayout_sdk_crrrl_clip_background, true);
            this.bKc = obtainStyledAttributes.getDimension(a.j.sdk_CubicRoundRectRelativeLayout_sdk_crrrl_accuracy, 0.0f);
            obtainStyledAttributes.recycle();
        }
    }

    private Path VU() {
        this.mPath.reset();
        float f = this.bKb;
        float f2 = (0.0f + f) / 2.0f;
        float f3 = this.mHeight;
        float f4 = (0.0f + f3) / 2.0f;
        this.mPath.moveTo(f2, 0.0f);
        this.mPath.cubicTo(this.bKb - this.bKc, 0.0f, this.bKb, this.bKc, f, f4);
        this.mPath.cubicTo(this.bKb, this.bKb - this.bKc, this.bKb - this.bKc, this.bKb, f2, f3);
        this.mPath.cubicTo(this.bKc, this.bKb, 0.0f, this.bKb - this.bKc, 0.0f, f4);
        this.mPath.cubicTo(0.0f, this.bKc, this.bKc, 0.0f, f2, 0.0f);
        this.mPath.close();
        return this.mPath;
    }

    private void h(Canvas canvas) {
        canvas.save();
        canvas.clipPath(VU());
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    private void i(Canvas canvas) {
        canvas.saveLayer(this.mRectF, null, 31);
        super.dispatchDraw(canvas);
        canvas.drawPath(VU(), this.mPaint);
        canvas.restore();
    }

    private void j(Canvas canvas) {
        canvas.save();
        canvas.clipPath(VU());
        super.draw(canvas);
        canvas.restore();
    }

    private void k(Canvas canvas) {
        canvas.saveLayer(this.mRectF, null, 31);
        super.draw(canvas);
        canvas.drawPath(VU(), this.mPaint);
        canvas.restore();
    }
}
