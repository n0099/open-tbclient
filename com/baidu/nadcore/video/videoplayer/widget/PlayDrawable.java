package com.baidu.nadcore.video.videoplayer.widget;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* loaded from: classes3.dex */
public class PlayDrawable extends Drawable {
    public static final float[] k = new float[8];
    public float b;
    public float[] c;
    public float[] d;
    public float[] e;
    public float[] f;
    public final Paint i;
    public IconState j;
    public final ValueAnimator a = ValueAnimator.ofFloat(0.0f, 1.0f);
    public final Path g = new Path();
    public final Path h = new Path();

    /* loaded from: classes3.dex */
    public enum IconState {
        PLAY_STATE,
        PAUSE_STATE
    }

    public final float c(float f, float f2, float f3) {
        return f + ((f2 - f) * f3);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    /* loaded from: classes3.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            PlayDrawable.this.s(valueAnimator.getAnimatedFraction());
        }
    }

    public final Rect e() {
        float m = m();
        float j = j();
        float l = l();
        float k2 = k();
        Rect rect = new Rect();
        int i = (int) ((m - l) / 2.0f);
        rect.left = i;
        int i2 = (int) ((j - k2) / 2.0f);
        rect.top = i2;
        rect.right = (int) (i + l);
        rect.bottom = (int) (i2 + k2);
        return rect;
    }

    public final float h() {
        return getBounds().exactCenterX();
    }

    public final float i() {
        return getBounds().exactCenterY();
    }

    public final float j() {
        return getBounds().height();
    }

    public final float k() {
        return j() * 0.38f;
    }

    public final float l() {
        return m() * 0.33f;
    }

    public final float m() {
        return getBounds().width();
    }

    public final boolean o() {
        return this.a.isRunning();
    }

    public PlayDrawable() {
        Paint paint = new Paint(1);
        this.i = paint;
        this.j = IconState.PLAY_STATE;
        paint.setColor(-1);
        this.a.setDuration(150L);
        this.a.addUpdateListener(new a());
    }

    public final void g(@NonNull Path path, @NonNull float[] fArr) {
        if (!path.isEmpty()) {
            path.rewind();
        }
        path.moveTo(fArr[0], fArr[1]);
        path.lineTo(fArr[2], fArr[3]);
        path.lineTo(fArr[4], fArr[5]);
        path.lineTo(fArr[6], fArr[7]);
    }

    public final void b(IconState iconState) {
        if (o()) {
            this.a.cancel();
        }
        if (iconState == IconState.PAUSE_STATE) {
            this.a.start();
        } else {
            this.a.reverse();
        }
        t(iconState);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        d(canvas, this.c, this.e, this.b, this.g, this.i);
        d(canvas, this.d, this.f, this.b, this.h, this.i);
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        n();
    }

    public void p(IconState iconState) {
        float f;
        if (o()) {
            this.a.cancel();
        }
        if (iconState == IconState.PLAY_STATE) {
            f = 0.0f;
        } else {
            f = 1.0f;
        }
        this.b = f;
        t(iconState);
        invalidateSelf();
    }

    public void q(IconState iconState) {
        float f;
        if (!o()) {
            if (iconState == IconState.PLAY_STATE) {
                f = 0.0f;
            } else {
                f = 1.0f;
            }
            this.b = f;
            t(iconState);
            invalidateSelf();
        }
    }

    public void r(boolean z) {
        IconState iconState = this.j;
        IconState iconState2 = IconState.PLAY_STATE;
        if (iconState == iconState2) {
            iconState2 = IconState.PAUSE_STATE;
        }
        if (z) {
            b(iconState2);
        } else {
            p(iconState2);
        }
    }

    public final void s(float f) {
        this.b = f;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.i.setAlpha(i);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.i.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public final void t(IconState iconState) {
        this.j = iconState;
    }

    public final void d(Canvas canvas, float[] fArr, float[] fArr2, float f, Path path, Paint paint) {
        f(k, fArr, fArr2, f);
        g(path, k);
        canvas.drawPath(path, paint);
    }

    public final void f(float[] fArr, float[] fArr2, float[] fArr3, float f) {
        if (fArr != null && fArr2 != null && fArr3 != null && fArr.length == fArr2.length) {
            int length = fArr2.length;
            for (int i = 0; i < length; i++) {
                fArr[i] = c(fArr2[i], fArr3[i], f);
            }
        }
    }

    public final void n() {
        Rect e = e();
        int m = (int) (m() * 0.074f);
        this.c = new float[]{e.left + m, e.top, ((int) h()) + m, (e.height() * 0.25f) + e.top, ((int) h()) + m, (e.height() * 0.75f) + e.top, e.left + m, e.height() + e.top};
        int i = e.top;
        this.d = new float[]{((int) h()) + m, (e.height() * 0.25f) + e.top, e.left + e.width() + m, i(), e.left + e.width() + m, i(), ((int) h()) + m, (e.height() * 0.75f) + i};
        int i2 = e.left;
        this.e = new float[]{i2, i, i2 + (e.width() * 0.285f), e.top, e.left + (e.width() * 0.285f), e.top + e.height(), e.left, e.top + e.height()};
        this.f = new float[]{e.left + (e.width() * 0.715f), e.top, e.left + e.width(), e.top, e.left + e.width(), e.top + e.height(), e.left + (e.width() * 0.715f), e.top + e.height()};
    }
}
