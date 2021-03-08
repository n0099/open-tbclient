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
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.live.sdk.a;
/* loaded from: classes10.dex */
public class CubicRoundRectRelativeLayout extends RelativeLayout {
    private float bUR;
    private float bUS;
    private boolean bUT;
    private boolean bUU;
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
        this.bUR = i;
        this.mRectF.set(0.0f, 0.0f, i, i2);
        if (this.bUS == 0.0f) {
            this.bUS = 0.11f * this.bUR;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.bUU) {
            i(canvas);
        } else {
            j(canvas);
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        if (this.bUT) {
            if (this.bUU) {
                k(canvas);
                return;
            } else {
                l(canvas);
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
        this.bUT = true;
        this.bUU = Build.VERSION.SDK_INT >= 28;
    }

    private void initAttrs(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, a.j.sdk_CubicRoundRectRelativeLayout);
            this.bUT = obtainStyledAttributes.getBoolean(a.j.sdk_CubicRoundRectRelativeLayout_sdk_crrrl_clip_background, true);
            this.bUS = obtainStyledAttributes.getDimension(a.j.sdk_CubicRoundRectRelativeLayout_sdk_crrrl_accuracy, 0.0f);
            obtainStyledAttributes.recycle();
        }
    }

    private Path Xy() {
        this.mPath.reset();
        float f = this.bUR;
        float f2 = (0.0f + f) / 2.0f;
        float f3 = this.mHeight;
        float f4 = (0.0f + f3) / 2.0f;
        this.mPath.moveTo(f2, 0.0f);
        this.mPath.cubicTo(this.bUR - this.bUS, 0.0f, this.bUR, this.bUS, f, f4);
        this.mPath.cubicTo(this.bUR, this.bUR - this.bUS, this.bUR - this.bUS, this.bUR, f2, f3);
        this.mPath.cubicTo(this.bUS, this.bUR, 0.0f, this.bUR - this.bUS, 0.0f, f4);
        this.mPath.cubicTo(0.0f, this.bUS, this.bUS, 0.0f, f2, 0.0f);
        this.mPath.close();
        return this.mPath;
    }

    private void i(Canvas canvas) {
        canvas.save();
        canvas.clipPath(Xy());
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    private void j(Canvas canvas) {
        canvas.saveLayer(this.mRectF, null, 31);
        super.dispatchDraw(canvas);
        canvas.drawPath(Xy(), this.mPaint);
        canvas.restore();
    }

    private void k(Canvas canvas) {
        canvas.save();
        canvas.clipPath(Xy());
        super.draw(canvas);
        canvas.restore();
    }

    private void l(Canvas canvas) {
        canvas.saveLayer(this.mRectF, null, 31);
        super.draw(canvas);
        canvas.drawPath(Xy(), this.mPaint);
        canvas.restore();
    }
}
