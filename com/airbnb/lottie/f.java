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
    @Nullable
    private String mH;
    private e my;
    @Nullable
    private com.airbnb.lottie.b.b nd;
    @Nullable
    private c ne;
    @Nullable
    private com.airbnb.lottie.b.a nf;
    @Nullable
    com.airbnb.lottie.b ng;
    @Nullable
    l nh;
    private boolean ni;
    @Nullable
    private com.airbnb.lottie.model.layer.b nj;
    private boolean nk;
    private final Matrix matrix = new Matrix();
    private final com.airbnb.lottie.c.c na = new com.airbnb.lottie.c.c();
    private float scale = 1.0f;
    private final Set<a> nb = new HashSet();
    private final ArrayList<b> nc = new ArrayList<>();
    private int alpha = 255;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public interface b {
        void i(e eVar);
    }

    public f() {
        this.na.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.airbnb.lottie.f.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (f.this.nj != null) {
                    f.this.nj.setProgress(f.this.na.eG());
                }
            }
        });
    }

    public boolean cv() {
        return this.ni;
    }

    public void p(boolean z) {
        if (Build.VERSION.SDK_INT < 19) {
            Log.w(TAG, "Merge paths are not supported pre-Kit Kat.");
            return;
        }
        this.ni = z;
        if (this.my != null) {
            cw();
        }
    }

    public void X(@Nullable String str) {
        this.mH = str;
    }

    @Nullable
    public String getImageAssetsFolder() {
        return this.mH;
    }

    public void cc() {
        if (this.nd != null) {
            this.nd.cc();
        }
    }

    public boolean h(e eVar) {
        if (this.my == eVar) {
            return false;
        }
        cy();
        this.my = eVar;
        cw();
        this.na.k(eVar.getDuration());
        setProgress(this.na.eG());
        setScale(this.scale);
        cD();
        cx();
        Iterator it = new ArrayList(this.nc).iterator();
        while (it.hasNext()) {
            ((b) it.next()).i(eVar);
            it.remove();
        }
        this.nc.clear();
        eVar.setPerformanceTrackingEnabled(this.nk);
        return true;
    }

    public void setPerformanceTrackingEnabled(boolean z) {
        this.nk = z;
        if (this.my != null) {
            this.my.setPerformanceTrackingEnabled(z);
        }
    }

    @Nullable
    public i getPerformanceTracker() {
        if (this.my != null) {
            return this.my.getPerformanceTracker();
        }
        return null;
    }

    private void cw() {
        this.nj = new com.airbnb.lottie.model.layer.b(this, Layer.a.k(this.my), this.my.cp(), this.my);
    }

    private void cx() {
        if (this.nj != null) {
            for (a aVar : this.nb) {
                this.nj.b(aVar.nq, aVar.nr, aVar.ns);
            }
        }
    }

    public void cy() {
        cc();
        if (this.na.isRunning()) {
            this.na.cancel();
        }
        this.my = null;
        this.nj = null;
        this.nd = null;
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
        if (colorFilter == null && this.nb.contains(aVar)) {
            this.nb.remove(aVar);
        } else {
            this.nb.add(new a(str, str2, colorFilter));
        }
        if (this.nj != null) {
            this.nj.b(str, str2, colorFilter);
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
        if (this.nj != null) {
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
                float width = this.my.getBounds().width() / 2.0f;
                float height = this.my.getBounds().height() / 2.0f;
                float f3 = width * c;
                float f4 = height * c;
                canvas.translate((width * getScale()) - f3, (height * getScale()) - f4);
                canvas.scale(f, f, f3, f4);
            }
            this.matrix.reset();
            this.matrix.preScale(c, c);
            this.nj.a(canvas, this.matrix, this.alpha);
            d.U("Drawable#draw");
            if (f > 1.0f) {
                canvas.restore();
            }
        }
    }

    public void ce() {
        if (this.nj == null) {
            this.nc.add(new b() { // from class: com.airbnb.lottie.f.2
                @Override // com.airbnb.lottie.f.b
                public void i(e eVar) {
                    f.this.ce();
                }
            });
        } else {
            this.na.ce();
        }
    }

    public void setMinFrame(final int i) {
        if (this.my == null) {
            this.nc.add(new b() { // from class: com.airbnb.lottie.f.3
                @Override // com.airbnb.lottie.f.b
                public void i(e eVar) {
                    f.this.setMinFrame(i);
                }
            });
        } else {
            setMinProgress(i / this.my.ct());
        }
    }

    public void setMinProgress(float f) {
        this.na.m(f);
    }

    public void setMaxFrame(final int i) {
        if (this.my == null) {
            this.nc.add(new b() { // from class: com.airbnb.lottie.f.4
                @Override // com.airbnb.lottie.f.b
                public void i(e eVar) {
                    f.this.setMaxFrame(i);
                }
            });
        } else {
            setMaxProgress(i / this.my.ct());
        }
    }

    public void setMaxProgress(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        this.na.n(f);
    }

    public void setMinAndMaxFrame(final int i, final int i2) {
        if (this.my == null) {
            this.nc.add(new b() { // from class: com.airbnb.lottie.f.5
                @Override // com.airbnb.lottie.f.b
                public void i(e eVar) {
                    f.this.setMinAndMaxFrame(i, i2);
                }
            });
        } else {
            this.na.g(i / this.my.ct(), i2 / this.my.ct());
        }
    }

    public void setMinAndMaxProgress(@FloatRange(from = 0.0d, to = 1.0d) float f, @FloatRange(from = 0.0d, to = 1.0d) float f2) {
        this.na.g(f, f2);
    }

    public void setSpeed(float f) {
        this.na.setSpeed(f);
    }

    public float getSpeed() {
        return this.na.getSpeed();
    }

    public void a(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.na.addUpdateListener(animatorUpdateListener);
    }

    public void a(Animator.AnimatorListener animatorListener) {
        this.na.addListener(animatorListener);
    }

    public void b(Animator.AnimatorListener animatorListener) {
        this.na.removeListener(animatorListener);
    }

    public void setFrame(final int i) {
        if (this.my == null) {
            this.nc.add(new b() { // from class: com.airbnb.lottie.f.6
                @Override // com.airbnb.lottie.f.b
                public void i(e eVar) {
                    f.this.setFrame(i);
                }
            });
        } else {
            setProgress(i / this.my.ct());
        }
    }

    public int getFrame() {
        if (this.my == null) {
            return 0;
        }
        return (int) (getProgress() * this.my.ct());
    }

    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        this.na.l(f);
        if (this.nj != null) {
            this.nj.setProgress(f);
        }
    }

    public void s(boolean z) {
        this.na.setRepeatCount(z ? -1 : 0);
    }

    public boolean isLooping() {
        return this.na.getRepeatCount() == -1;
    }

    public boolean isAnimating() {
        return this.na.isRunning();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cz() {
        this.na.cz();
    }

    public void setScale(float f) {
        this.scale = f;
        cD();
    }

    public void setImageAssetDelegate(c cVar) {
        this.ne = cVar;
        if (this.nd != null) {
            this.nd.a(cVar);
        }
    }

    public void setFontAssetDelegate(com.airbnb.lottie.b bVar) {
        this.ng = bVar;
        if (this.nf != null) {
            this.nf.a(bVar);
        }
    }

    public void setTextDelegate(l lVar) {
        this.nh = lVar;
    }

    @Nullable
    public l cA() {
        return this.nh;
    }

    public boolean cB() {
        return this.nh == null && this.my.cq().size() > 0;
    }

    public float getScale() {
        return this.scale;
    }

    public e cC() {
        return this.my;
    }

    private void cD() {
        if (this.my != null) {
            float scale = getScale();
            setBounds(0, 0, (int) (this.my.getBounds().width() * scale), (int) (scale * this.my.getBounds().height()));
        }
    }

    public void cf() {
        this.nc.clear();
        this.na.cancel();
    }

    public void cg() {
        this.nc.clear();
        this.na.cg();
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float getProgress() {
        return this.na.eG();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        if (this.my == null) {
            return -1;
        }
        return (int) (this.my.getBounds().width() * getScale());
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        if (this.my == null) {
            return -1;
        }
        return (int) (this.my.getBounds().height() * getScale());
    }

    @Nullable
    public Bitmap Y(String str) {
        com.airbnb.lottie.b.b cE = cE();
        if (cE != null) {
            return cE.ac(str);
        }
        return null;
    }

    private com.airbnb.lottie.b.b cE() {
        if (getCallback() == null) {
            return null;
        }
        if (this.nd != null && !this.nd.ay(getContext())) {
            this.nd.cc();
            this.nd = null;
        }
        if (this.nd == null) {
            this.nd = new com.airbnb.lottie.b.b(getCallback(), this.mH, this.ne, this.my.cs());
        }
        return this.nd;
    }

    @Nullable
    public Typeface n(String str, String str2) {
        com.airbnb.lottie.b.a cF = cF();
        if (cF != null) {
            return cF.n(str, str2);
        }
        return null;
    }

    private com.airbnb.lottie.b.a cF() {
        if (getCallback() == null) {
            return null;
        }
        if (this.nf == null) {
            this.nf = new com.airbnb.lottie.b.a(getCallback(), this.ng);
        }
        return this.nf;
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
        return Math.min(canvas.getWidth() / this.my.getBounds().width(), canvas.getHeight() / this.my.getBounds().height());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a {
        final String nq;
        @Nullable
        final String nr;
        @Nullable
        final ColorFilter ns;

        a(@Nullable String str, @Nullable String str2, @Nullable ColorFilter colorFilter) {
            this.nq = str;
            this.nr = str2;
            this.ns = colorFilter;
        }

        public int hashCode() {
            int i = 17;
            if (this.nq != null) {
                i = this.nq.hashCode() * 527;
            }
            if (this.nr != null) {
                return i * 31 * this.nr.hashCode();
            }
            return i;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof a) {
                a aVar = (a) obj;
                return hashCode() == aVar.hashCode() && this.ns == aVar.ns;
            }
            return false;
        }
    }
}
