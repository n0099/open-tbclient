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
    private e jY;
    @Nullable
    private com.airbnb.lottie.b.b kC;
    @Nullable
    private c kD;
    @Nullable
    private com.airbnb.lottie.b.a kE;
    @Nullable
    com.airbnb.lottie.b kF;
    @Nullable
    l kG;
    private boolean kH;
    @Nullable
    private com.airbnb.lottie.model.layer.b kI;
    private boolean kJ;
    @Nullable
    private String kg;
    private final Matrix matrix = new Matrix();
    private final com.airbnb.lottie.c.c ky = new com.airbnb.lottie.c.c();
    private float scale = 1.0f;
    private final Set<a> kA = new HashSet();
    private final ArrayList<b> kB = new ArrayList<>();
    private int alpha = 255;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public interface b {
        void i(e eVar);
    }

    public f() {
        this.ky.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.airbnb.lottie.f.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (f.this.kI != null) {
                    f.this.kI.setProgress(f.this.ky.dz());
                }
            }
        });
    }

    public boolean bo() {
        return this.kH;
    }

    public void h(boolean z) {
        if (Build.VERSION.SDK_INT < 19) {
            Log.w(TAG, "Merge paths are not supported pre-Kit Kat.");
            return;
        }
        this.kH = z;
        if (this.jY != null) {
            bp();
        }
    }

    public void G(@Nullable String str) {
        this.kg = str;
    }

    @Nullable
    public String getImageAssetsFolder() {
        return this.kg;
    }

    public void aV() {
        if (this.kC != null) {
            this.kC.aV();
        }
    }

    public boolean h(e eVar) {
        if (this.jY == eVar) {
            return false;
        }
        br();
        this.jY = eVar;
        bp();
        this.ky.h(eVar.getDuration());
        setProgress(this.ky.dz());
        setScale(this.scale);
        bw();
        bq();
        Iterator it = new ArrayList(this.kB).iterator();
        while (it.hasNext()) {
            ((b) it.next()).i(eVar);
            it.remove();
        }
        this.kB.clear();
        eVar.setPerformanceTrackingEnabled(this.kJ);
        return true;
    }

    public void setPerformanceTrackingEnabled(boolean z) {
        this.kJ = z;
        if (this.jY != null) {
            this.jY.setPerformanceTrackingEnabled(z);
        }
    }

    @Nullable
    public i getPerformanceTracker() {
        if (this.jY != null) {
            return this.jY.getPerformanceTracker();
        }
        return null;
    }

    private void bp() {
        this.kI = new com.airbnb.lottie.model.layer.b(this, Layer.a.k(this.jY), this.jY.bi(), this.jY);
    }

    private void bq() {
        if (this.kI != null) {
            for (a aVar : this.kA) {
                this.kI.b(aVar.kO, aVar.kP, aVar.kQ);
            }
        }
    }

    public void br() {
        aV();
        if (this.ky.isRunning()) {
            this.ky.cancel();
        }
        this.jY = null;
        this.kI = null;
        this.kC = null;
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
        if (colorFilter == null && this.kA.contains(aVar)) {
            this.kA.remove(aVar);
        } else {
            this.kA.add(new a(str, str2, colorFilter));
        }
        if (this.kI != null) {
            this.kI.b(str, str2, colorFilter);
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
        if (this.kI != null) {
            float f2 = this.scale;
            float c = c(canvas);
            if (f2 > c) {
                f = this.scale / c;
            } else {
                c = f2;
                f = 1.0f;
            }
            if (f > 1.0f) {
                canvas.save();
                float width = this.jY.getBounds().width() / 2.0f;
                float height = this.jY.getBounds().height() / 2.0f;
                float f3 = width * c;
                float f4 = height * c;
                canvas.translate((width * getScale()) - f3, (height * getScale()) - f4);
                canvas.scale(f, f, f3, f4);
            }
            this.matrix.reset();
            this.matrix.preScale(c, c);
            this.kI.a(canvas, this.matrix, this.alpha);
            d.D("Drawable#draw");
            if (f > 1.0f) {
                canvas.restore();
            }
        }
    }

    public void aX() {
        if (this.kI == null) {
            this.kB.add(new b() { // from class: com.airbnb.lottie.f.2
                @Override // com.airbnb.lottie.f.b
                public void i(e eVar) {
                    f.this.aX();
                }
            });
        } else {
            this.ky.aX();
        }
    }

    public void setMinFrame(final int i) {
        if (this.jY == null) {
            this.kB.add(new b() { // from class: com.airbnb.lottie.f.3
                @Override // com.airbnb.lottie.f.b
                public void i(e eVar) {
                    f.this.setMinFrame(i);
                }
            });
        } else {
            setMinProgress(i / this.jY.bm());
        }
    }

    public void setMinProgress(float f) {
        this.ky.m(f);
    }

    public void setMaxFrame(final int i) {
        if (this.jY == null) {
            this.kB.add(new b() { // from class: com.airbnb.lottie.f.4
                @Override // com.airbnb.lottie.f.b
                public void i(e eVar) {
                    f.this.setMaxFrame(i);
                }
            });
        } else {
            setMaxProgress(i / this.jY.bm());
        }
    }

    public void setMaxProgress(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        this.ky.n(f);
    }

    public void setMinAndMaxFrame(final int i, final int i2) {
        if (this.jY == null) {
            this.kB.add(new b() { // from class: com.airbnb.lottie.f.5
                @Override // com.airbnb.lottie.f.b
                public void i(e eVar) {
                    f.this.setMinAndMaxFrame(i, i2);
                }
            });
        } else {
            this.ky.g(i / this.jY.bm(), i2 / this.jY.bm());
        }
    }

    public void setMinAndMaxProgress(@FloatRange(from = 0.0d, to = 1.0d) float f, @FloatRange(from = 0.0d, to = 1.0d) float f2) {
        this.ky.g(f, f2);
    }

    public void setSpeed(float f) {
        this.ky.setSpeed(f);
    }

    public float getSpeed() {
        return this.ky.getSpeed();
    }

    public void a(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.ky.addUpdateListener(animatorUpdateListener);
    }

    public void a(Animator.AnimatorListener animatorListener) {
        this.ky.addListener(animatorListener);
    }

    public void b(Animator.AnimatorListener animatorListener) {
        this.ky.removeListener(animatorListener);
    }

    public void setFrame(final int i) {
        if (this.jY == null) {
            this.kB.add(new b() { // from class: com.airbnb.lottie.f.6
                @Override // com.airbnb.lottie.f.b
                public void i(e eVar) {
                    f.this.setFrame(i);
                }
            });
        } else {
            setProgress(i / this.jY.bm());
        }
    }

    public int getFrame() {
        if (this.jY == null) {
            return 0;
        }
        return (int) (getProgress() * this.jY.bm());
    }

    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        this.ky.l(f);
        if (this.kI != null) {
            this.kI.setProgress(f);
        }
    }

    public void i(boolean z) {
        this.ky.setRepeatCount(z ? -1 : 0);
    }

    public boolean isLooping() {
        return this.ky.getRepeatCount() == -1;
    }

    public boolean isAnimating() {
        return this.ky.isRunning();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bs() {
        this.ky.bs();
    }

    public void setScale(float f) {
        this.scale = f;
        bw();
    }

    public void setImageAssetDelegate(c cVar) {
        this.kD = cVar;
        if (this.kC != null) {
            this.kC.a(cVar);
        }
    }

    public void setFontAssetDelegate(com.airbnb.lottie.b bVar) {
        this.kF = bVar;
        if (this.kE != null) {
            this.kE.a(bVar);
        }
    }

    public void setTextDelegate(l lVar) {
        this.kG = lVar;
    }

    @Nullable
    public l bt() {
        return this.kG;
    }

    public boolean bu() {
        return this.kG == null && this.jY.bj().size() > 0;
    }

    public float getScale() {
        return this.scale;
    }

    public e bv() {
        return this.jY;
    }

    private void bw() {
        if (this.jY != null) {
            float scale = getScale();
            setBounds(0, 0, (int) (this.jY.getBounds().width() * scale), (int) (scale * this.jY.getBounds().height()));
        }
    }

    public void aY() {
        this.kB.clear();
        this.ky.cancel();
    }

    public void aZ() {
        this.kB.clear();
        this.ky.aZ();
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float getProgress() {
        return this.ky.dz();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        if (this.jY == null) {
            return -1;
        }
        return (int) (this.jY.getBounds().width() * getScale());
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        if (this.jY == null) {
            return -1;
        }
        return (int) (this.jY.getBounds().height() * getScale());
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
        if (this.kC != null && !this.kC.R(getContext())) {
            this.kC.aV();
            this.kC = null;
        }
        if (this.kC == null) {
            this.kC = new com.airbnb.lottie.b.b(getCallback(), this.kg, this.kD, this.jY.bl());
        }
        return this.kC;
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
        if (this.kE == null) {
            this.kE = new com.airbnb.lottie.b.a(getCallback(), this.kF);
        }
        return this.kE;
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

    private float c(@NonNull Canvas canvas) {
        return Math.min(canvas.getWidth() / this.jY.getBounds().width(), canvas.getHeight() / this.jY.getBounds().height());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a {
        final String kO;
        @Nullable
        final String kP;
        @Nullable
        final ColorFilter kQ;

        a(@Nullable String str, @Nullable String str2, @Nullable ColorFilter colorFilter) {
            this.kO = str;
            this.kP = str2;
            this.kQ = colorFilter;
        }

        public int hashCode() {
            int i = 17;
            if (this.kO != null) {
                i = this.kO.hashCode() * 527;
            }
            if (this.kP != null) {
                return i * 31 * this.kP.hashCode();
            }
            return i;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof a) {
                a aVar = (a) obj;
                return hashCode() == aVar.hashCode() && this.kQ == aVar.kQ;
            }
            return false;
        }
    }
}
