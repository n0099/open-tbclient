package com.airbnb.lottie;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.FloatRange;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import com.airbnb.lottie.model.layer.Layer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
/* loaded from: classes2.dex */
public class f extends Drawable implements Drawable.Callback {
    private static final String TAG = f.class.getSimpleName();
    private e jX;
    @Nullable
    private com.airbnb.lottie.b.b kB;
    @Nullable
    private c kC;
    @Nullable
    private com.airbnb.lottie.b.a kD;
    @Nullable
    com.airbnb.lottie.b kE;
    @Nullable
    l kF;
    private boolean kG;
    @Nullable
    private com.airbnb.lottie.model.layer.b kH;
    private boolean kI;
    @Nullable
    private String kf;
    private final Matrix matrix = new Matrix();
    private final com.airbnb.lottie.c.c kx = new com.airbnb.lottie.c.c();
    private float scale = 1.0f;
    private final Set<a> ky = new HashSet();
    private final ArrayList<b> kA = new ArrayList<>();
    private int alpha = 255;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public interface b {
        void i(e eVar);
    }

    public f() {
        this.kx.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.airbnb.lottie.f.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (f.this.kH != null) {
                    f.this.kH.setProgress(f.this.kx.dz());
                }
            }
        });
    }

    public boolean bo() {
        return this.kG;
    }

    public void h(boolean z) {
        if (Build.VERSION.SDK_INT < 19) {
            Log.w(TAG, "Merge paths are not supported pre-Kit Kat.");
            return;
        }
        this.kG = z;
        if (this.jX != null) {
            bp();
        }
    }

    public void G(@Nullable String str) {
        this.kf = str;
    }

    @Nullable
    public String getImageAssetsFolder() {
        return this.kf;
    }

    public void aV() {
        if (this.kB != null) {
            this.kB.aV();
        }
    }

    public boolean h(e eVar) {
        if (this.jX == eVar) {
            return false;
        }
        br();
        this.jX = eVar;
        bp();
        this.kx.h(eVar.getDuration());
        setProgress(this.kx.dz());
        setScale(this.scale);
        bw();
        bq();
        Iterator it = new ArrayList(this.kA).iterator();
        while (it.hasNext()) {
            ((b) it.next()).i(eVar);
            it.remove();
        }
        this.kA.clear();
        eVar.setPerformanceTrackingEnabled(this.kI);
        return true;
    }

    public void setPerformanceTrackingEnabled(boolean z) {
        this.kI = z;
        if (this.jX != null) {
            this.jX.setPerformanceTrackingEnabled(z);
        }
    }

    @Nullable
    public i getPerformanceTracker() {
        if (this.jX != null) {
            return this.jX.getPerformanceTracker();
        }
        return null;
    }

    private void bp() {
        this.kH = new com.airbnb.lottie.model.layer.b(this, Layer.a.k(this.jX), this.jX.bi(), this.jX);
    }

    private void bq() {
        if (this.kH != null) {
            for (a aVar : this.ky) {
                this.kH.b(aVar.kN, aVar.kO, aVar.kP);
            }
        }
    }

    public void br() {
        aV();
        if (this.kx.isRunning()) {
            this.kx.cancel();
        }
        this.jX = null;
        this.kH = null;
        this.kB = null;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(@IntRange(from = 0, to = 255) int i) {
        this.alpha = i;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.alpha;
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        Log.w("LOTTIE", "Use addColorFilter instead.");
    }

    public void a(ColorFilter colorFilter) {
        a(null, null, colorFilter);
    }

    private void a(@Nullable String str, @Nullable String str2, @Nullable ColorFilter colorFilter) {
        a aVar = new a(str, str2, colorFilter);
        if (colorFilter == null && this.ky.contains(aVar)) {
            this.ky.remove(aVar);
        } else {
            this.ky.add(new a(str, str2, colorFilter));
        }
        if (this.kH != null) {
            this.kH.b(str, str2, colorFilter);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        float f;
        d.beginSection("Drawable#draw");
        if (this.kH != null) {
            float f2 = this.scale;
            float d = d(canvas);
            if (f2 > d) {
                f = this.scale / d;
            } else {
                d = f2;
                f = 1.0f;
            }
            if (f > 1.0f) {
                canvas.save();
                float width = this.jX.getBounds().width() / 2.0f;
                float height = this.jX.getBounds().height() / 2.0f;
                float f3 = width * d;
                float f4 = height * d;
                canvas.translate((width * getScale()) - f3, (height * getScale()) - f4);
                canvas.scale(f, f, f3, f4);
            }
            this.matrix.reset();
            this.matrix.preScale(d, d);
            this.kH.a(canvas, this.matrix, this.alpha);
            d.D("Drawable#draw");
            if (f > 1.0f) {
                canvas.restore();
            }
        }
    }

    public void aX() {
        if (this.kH == null) {
            this.kA.add(new b() { // from class: com.airbnb.lottie.f.2
                @Override // com.airbnb.lottie.f.b
                public void i(e eVar) {
                    f.this.aX();
                }
            });
        } else {
            this.kx.aX();
        }
    }

    public void setMinFrame(final int i) {
        if (this.jX == null) {
            this.kA.add(new b() { // from class: com.airbnb.lottie.f.3
                @Override // com.airbnb.lottie.f.b
                public void i(e eVar) {
                    f.this.setMinFrame(i);
                }
            });
        } else {
            setMinProgress(i / this.jX.bm());
        }
    }

    public void setMinProgress(float f) {
        this.kx.m(f);
    }

    public void setMaxFrame(final int i) {
        if (this.jX == null) {
            this.kA.add(new b() { // from class: com.airbnb.lottie.f.4
                @Override // com.airbnb.lottie.f.b
                public void i(e eVar) {
                    f.this.setMaxFrame(i);
                }
            });
        } else {
            setMaxProgress(i / this.jX.bm());
        }
    }

    public void setMaxProgress(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        this.kx.n(f);
    }

    public void setMinAndMaxFrame(final int i, final int i2) {
        if (this.jX == null) {
            this.kA.add(new b() { // from class: com.airbnb.lottie.f.5
                @Override // com.airbnb.lottie.f.b
                public void i(e eVar) {
                    f.this.setMinAndMaxFrame(i, i2);
                }
            });
        } else {
            this.kx.g(i / this.jX.bm(), i2 / this.jX.bm());
        }
    }

    public void setMinAndMaxProgress(@FloatRange(from = 0.0d, to = 1.0d) float f, @FloatRange(from = 0.0d, to = 1.0d) float f2) {
        this.kx.g(f, f2);
    }

    public void setSpeed(float f) {
        this.kx.setSpeed(f);
    }

    public float getSpeed() {
        return this.kx.getSpeed();
    }

    public void a(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.kx.addUpdateListener(animatorUpdateListener);
    }

    public void a(Animator.AnimatorListener animatorListener) {
        this.kx.addListener(animatorListener);
    }

    public void b(Animator.AnimatorListener animatorListener) {
        this.kx.removeListener(animatorListener);
    }

    public void setFrame(final int i) {
        if (this.jX == null) {
            this.kA.add(new b() { // from class: com.airbnb.lottie.f.6
                @Override // com.airbnb.lottie.f.b
                public void i(e eVar) {
                    f.this.setFrame(i);
                }
            });
        } else {
            setProgress(i / this.jX.bm());
        }
    }

    public int getFrame() {
        if (this.jX == null) {
            return 0;
        }
        return (int) (getProgress() * this.jX.bm());
    }

    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        this.kx.l(f);
        if (this.kH != null) {
            this.kH.setProgress(f);
        }
    }

    public void i(boolean z) {
        this.kx.setRepeatCount(z ? -1 : 0);
    }

    public boolean isLooping() {
        return this.kx.getRepeatCount() == -1;
    }

    public boolean isAnimating() {
        return this.kx.isRunning();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bs() {
        this.kx.bs();
    }

    public void setScale(float f) {
        this.scale = f;
        bw();
    }

    public void setImageAssetDelegate(c cVar) {
        this.kC = cVar;
        if (this.kB != null) {
            this.kB.a(cVar);
        }
    }

    public void setFontAssetDelegate(com.airbnb.lottie.b bVar) {
        this.kE = bVar;
        if (this.kD != null) {
            this.kD.a(bVar);
        }
    }

    public void setTextDelegate(l lVar) {
        this.kF = lVar;
    }

    @Nullable
    public l bt() {
        return this.kF;
    }

    public boolean bu() {
        return this.kF == null && this.jX.bj().size() > 0;
    }

    public float getScale() {
        return this.scale;
    }

    public e bv() {
        return this.jX;
    }

    private void bw() {
        if (this.jX != null) {
            float scale = getScale();
            setBounds(0, 0, (int) (this.jX.getBounds().width() * scale), (int) (scale * this.jX.getBounds().height()));
        }
    }

    public void aY() {
        this.kA.clear();
        this.kx.cancel();
    }

    public void aZ() {
        this.kA.clear();
        this.kx.aZ();
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float getProgress() {
        return this.kx.dz();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        if (this.jX == null) {
            return -1;
        }
        return (int) (this.jX.getBounds().width() * getScale());
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        if (this.jX == null) {
            return -1;
        }
        return (int) (this.jX.getBounds().height() * getScale());
    }

    @Nullable
    public Bitmap H(String str) {
        com.airbnb.lottie.b.b bx = bx();
        if (bx != null) {
            return bx.L(str);
        }
        return null;
    }

    private com.airbnb.lottie.b.b bx() {
        if (getCallback() == null) {
            return null;
        }
        if (this.kB != null && !this.kB.R(getContext())) {
            this.kB.aV();
            this.kB = null;
        }
        if (this.kB == null) {
            this.kB = new com.airbnb.lottie.b.b(getCallback(), this.kf, this.kC, this.jX.bl());
        }
        return this.kB;
    }

    @Nullable
    public Typeface g(String str, String str2) {
        com.airbnb.lottie.b.a by = by();
        if (by != null) {
            return by.g(str, str2);
        }
        return null;
    }

    private com.airbnb.lottie.b.a by() {
        if (getCallback() == null) {
            return null;
        }
        if (this.kD == null) {
            this.kD = new com.airbnb.lottie.b.a(getCallback(), this.kE);
        }
        return this.kD;
    }

    @Nullable
    private Context getContext() {
        Drawable.Callback callback = getCallback();
        if (callback != null && (callback instanceof View)) {
            return ((View) callback).getContext();
        }
        return null;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(@NonNull Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable, long j) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, runnable, j);
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }

    private float d(@NonNull Canvas canvas) {
        return Math.min(canvas.getWidth() / this.jX.getBounds().width(), canvas.getHeight() / this.jX.getBounds().height());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a {
        final String kN;
        @Nullable
        final String kO;
        @Nullable
        final ColorFilter kP;

        a(@Nullable String str, @Nullable String str2, @Nullable ColorFilter colorFilter) {
            this.kN = str;
            this.kO = str2;
            this.kP = colorFilter;
        }

        public int hashCode() {
            int i = 17;
            if (this.kN != null) {
                i = this.kN.hashCode() * 527;
            }
            if (this.kO != null) {
                return i * 31 * this.kO.hashCode();
            }
            return i;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof a) {
                a aVar = (a) obj;
                return hashCode() == aVar.hashCode() && this.kP == aVar.kP;
            }
            return false;
        }
    }
}
