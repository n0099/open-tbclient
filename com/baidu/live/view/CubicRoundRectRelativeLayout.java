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
    private float bPi;
    private float bPj;
    private boolean bPk;
    private boolean bPl;
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
        this.bPi = i;
        this.mRectF.set(0.0f, 0.0f, i, i2);
        if (this.bPj == 0.0f) {
            this.bPj = 0.11f * this.bPi;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.bPl) {
            h(canvas);
        } else {
            i(canvas);
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        if (this.bPk) {
            if (this.bPl) {
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
        this.bPk = true;
        this.bPl = Build.VERSION.SDK_INT >= 28;
    }

    private void initAttrs(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, a.j.sdk_CubicRoundRectRelativeLayout);
            this.bPk = obtainStyledAttributes.getBoolean(a.j.sdk_CubicRoundRectRelativeLayout_sdk_crrrl_clip_background, true);
            this.bPj = obtainStyledAttributes.getDimension(a.j.sdk_CubicRoundRectRelativeLayout_sdk_crrrl_accuracy, 0.0f);
            obtainStyledAttributes.recycle();
        }
    }

    private Path Yu() {
        this.mPath.reset();
        float f = this.bPi;
        float f2 = (0.0f + f) / 2.0f;
        float f3 = this.mHeight;
        float f4 = (0.0f + f3) / 2.0f;
        this.mPath.moveTo(f2, 0.0f);
        this.mPath.cubicTo(this.bPi - this.bPj, 0.0f, this.bPi, this.bPj, f, f4);
        this.mPath.cubicTo(this.bPi, this.bPi - this.bPj, this.bPi - this.bPj, this.bPi, f2, f3);
        this.mPath.cubicTo(this.bPj, this.bPi, 0.0f, this.bPi - this.bPj, 0.0f, f4);
        this.mPath.cubicTo(0.0f, this.bPj, this.bPj, 0.0f, f2, 0.0f);
        this.mPath.close();
        return this.mPath;
    }

    private void h(Canvas canvas) {
        canvas.save();
        canvas.clipPath(Yu());
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    private void i(Canvas canvas) {
        canvas.saveLayer(this.mRectF, null, 31);
        super.dispatchDraw(canvas);
        canvas.drawPath(Yu(), this.mPaint);
        canvas.restore();
    }

    private void j(Canvas canvas) {
        canvas.save();
        canvas.clipPath(Yu());
        super.draw(canvas);
        canvas.restore();
    }

    private void k(Canvas canvas) {
        canvas.saveLayer(this.mRectF, null, 31);
        super.draw(canvas);
        canvas.drawPath(Yu(), this.mPaint);
        canvas.restore();
    }
}
