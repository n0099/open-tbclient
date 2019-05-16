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
import com.baidu.mapapi.map.WeightedLatLng;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
/* loaded from: classes2.dex */
public class f extends Drawable implements Drawable.Callback {
    private static final String TAG = f.class.getSimpleName();
    private e kJ;
    @Nullable
    private String kQ;
    @Nullable
    private com.airbnb.lottie.b.b lk;
    @Nullable
    private c ll;
    @Nullable
    private com.airbnb.lottie.b.a lm;
    @Nullable
    com.airbnb.lottie.b ln;
    @Nullable
    l lo;
    private boolean lq;
    @Nullable
    private com.airbnb.lottie.model.layer.b lr;
    private boolean lt;
    private final Matrix matrix = new Matrix();
    private final com.airbnb.lottie.c.c lh = new com.airbnb.lottie.c.c();
    private float scale = 1.0f;
    private final Set<a> li = new HashSet();
    private final ArrayList<b> lj = new ArrayList<>();
    private int alpha = 255;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public interface b {
        void i(e eVar);
    }

    public f() {
        this.lh.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.airbnb.lottie.f.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (f.this.lr != null) {
                    f.this.lr.setProgress(f.this.lh.dQ());
                }
            }
        });
    }

    public boolean bF() {
        return this.lq;
    }

    public void w(boolean z) {
        if (Build.VERSION.SDK_INT < 19) {
            Log.w(TAG, "Merge paths are not supported pre-Kit Kat.");
            return;
        }
        this.lq = z;
        if (this.kJ != null) {
            bG();
        }
    }

    public void G(@Nullable String str) {
        this.kQ = str;
    }

    @Nullable
    public String getImageAssetsFolder() {
        return this.kQ;
    }

    public void bm() {
        if (this.lk != null) {
            this.lk.bm();
        }
    }

    public boolean h(e eVar) {
        if (this.kJ == eVar) {
            return false;
        }
        bI();
        this.kJ = eVar;
        bG();
        this.lh.h(eVar.getDuration());
        setProgress(this.lh.dQ());
        setScale(this.scale);
        bN();
        bH();
        Iterator it = new ArrayList(this.lj).iterator();
        while (it.hasNext()) {
            ((b) it.next()).i(eVar);
            it.remove();
        }
        this.lj.clear();
        eVar.setPerformanceTrackingEnabled(this.lt);
        return true;
    }

    public void setPerformanceTrackingEnabled(boolean z) {
        this.lt = z;
        if (this.kJ != null) {
            this.kJ.setPerformanceTrackingEnabled(z);
        }
    }

    @Nullable
    public i getPerformanceTracker() {
        if (this.kJ != null) {
            return this.kJ.getPerformanceTracker();
        }
        return null;
    }

    private void bG() {
        this.lr = new com.airbnb.lottie.model.layer.b(this, Layer.a.k(this.kJ), this.kJ.bz(), this.kJ);
    }

    private void bH() {
        if (this.lr != null) {
            for (a aVar : this.li) {
                this.lr.b(aVar.ly, aVar.lA, aVar.lB);
            }
        }
    }

    public void bI() {
        bm();
        if (this.lh.isRunning()) {
            this.lh.cancel();
        }
        this.kJ = null;
        this.lr = null;
        this.lk = null;
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
        if (colorFilter == null && this.li.contains(aVar)) {
            this.li.remove(aVar);
        } else {
            this.li.add(new a(str, str2, colorFilter));
        }
        if (this.lr != null) {
            this.lr.b(str, str2, colorFilter);
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
        if (this.lr != null) {
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
                float width = this.kJ.getBounds().width() / 2.0f;
                float height = this.kJ.getBounds().height() / 2.0f;
                float f3 = width * c;
                float f4 = height * c;
                canvas.translate((width * getScale()) - f3, (height * getScale()) - f4);
                canvas.scale(f, f, f3, f4);
            }
            this.matrix.reset();
            this.matrix.preScale(c, c);
            this.lr.a(canvas, this.matrix, this.alpha);
            d.D("Drawable#draw");
            if (f > 1.0f) {
                canvas.restore();
            }
        }
    }

    public void bo() {
        if (this.lr == null) {
            this.lj.add(new b() { // from class: com.airbnb.lottie.f.2
                @Override // com.airbnb.lottie.f.b
                public void i(e eVar) {
                    f.this.bo();
                }
            });
        } else {
            this.lh.bo();
        }
    }

    public void bp() {
        if (this.lr == null) {
            this.lj.add(new b() { // from class: com.airbnb.lottie.f.3
                @Override // com.airbnb.lottie.f.b
                public void i(e eVar) {
                    f.this.bp();
                }
            });
        } else {
            this.lh.bp();
        }
    }

    public void setMinFrame(final int i) {
        if (this.kJ == null) {
            this.lj.add(new b() { // from class: com.airbnb.lottie.f.4
                @Override // com.airbnb.lottie.f.b
                public void i(e eVar) {
                    f.this.setMinFrame(i);
                }
            });
        } else {
            setMinProgress(i / this.kJ.bD());
        }
    }

    public void setMinProgress(float f) {
        this.lh.m(f);
    }

    public void setMaxFrame(final int i) {
        if (this.kJ == null) {
            this.lj.add(new b() { // from class: com.airbnb.lottie.f.5
                @Override // com.airbnb.lottie.f.b
                public void i(e eVar) {
                    f.this.setMaxFrame(i);
                }
            });
        } else {
            setMaxProgress(i / this.kJ.bD());
        }
    }

    public void setMaxProgress(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        this.lh.n(f);
    }

    public void setMinAndMaxFrame(final int i, final int i2) {
        if (this.kJ == null) {
            this.lj.add(new b() { // from class: com.airbnb.lottie.f.6
                @Override // com.airbnb.lottie.f.b
                public void i(e eVar) {
                    f.this.setMinAndMaxFrame(i, i2);
                }
            });
        } else {
            this.lh.j(i / this.kJ.bD(), i2 / this.kJ.bD());
        }
    }

    public void setMinAndMaxProgress(@FloatRange(from = 0.0d, to = 1.0d) float f, @FloatRange(from = 0.0d, to = 1.0d) float f2) {
        this.lh.j(f, f2);
    }

    public void setSpeed(float f) {
        this.lh.setSpeed(f);
    }

    public float getSpeed() {
        return this.lh.getSpeed();
    }

    public void a(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.lh.addUpdateListener(animatorUpdateListener);
    }

    public void b(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.lh.removeUpdateListener(animatorUpdateListener);
    }

    public void a(Animator.AnimatorListener animatorListener) {
        this.lh.addListener(animatorListener);
    }

    public void b(Animator.AnimatorListener animatorListener) {
        this.lh.removeListener(animatorListener);
    }

    public void setFrame(final int i) {
        if (this.kJ == null) {
            this.lj.add(new b() { // from class: com.airbnb.lottie.f.7
                @Override // com.airbnb.lottie.f.b
                public void i(e eVar) {
                    f.this.setFrame(i);
                }
            });
        } else {
            setProgress(i / this.kJ.bD());
        }
    }

    public int getFrame() {
        if (this.kJ == null) {
            return 0;
        }
        return (int) (getProgress() * this.kJ.bD());
    }

    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        this.lh.l(f);
        if (this.lr != null) {
            this.lr.setProgress(f);
        }
    }

    public void y(boolean z) {
        this.lh.setRepeatCount(z ? -1 : 0);
    }

    public boolean isLooping() {
        return this.lh.getRepeatCount() == -1;
    }

    public boolean isAnimating() {
        return this.lh.isRunning();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bJ() {
        this.lh.bJ();
    }

    public void setScale(float f) {
        this.scale = f;
        bN();
    }

    public void setImageAssetDelegate(c cVar) {
        this.ll = cVar;
        if (this.lk != null) {
            this.lk.a(cVar);
        }
    }

    public void setFontAssetDelegate(com.airbnb.lottie.b bVar) {
        this.ln = bVar;
        if (this.lm != null) {
            this.lm.a(bVar);
        }
    }

    public void setTextDelegate(l lVar) {
        this.lo = lVar;
    }

    @Nullable
    public l bK() {
        return this.lo;
    }

    public boolean bL() {
        return this.lo == null && this.kJ.bA().size() > 0;
    }

    public float getScale() {
        return this.scale;
    }

    public e bM() {
        return this.kJ;
    }

    private void bN() {
        if (this.kJ != null) {
            float scale = getScale();
            setBounds(0, 0, (int) (this.kJ.getBounds().width() * scale), (int) (scale * this.kJ.getBounds().height()));
        }
    }

    public void cancelAnimation() {
        this.lj.clear();
        this.lh.cancel();
    }

    public void bq() {
        this.lj.clear();
        this.lh.bq();
    }

    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    public float getProgress() {
        return this.lh.dQ();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        if (this.kJ == null) {
            return -1;
        }
        return (int) (this.kJ.getBounds().width() * getScale());
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        if (this.kJ == null) {
            return -1;
        }
        return (int) (this.kJ.getBounds().height() * getScale());
    }

    @Nullable
    public Bitmap H(String str) {
        com.airbnb.lottie.b.b bO = bO();
        if (bO != null) {
            return bO.L(str);
        }
        return null;
    }

    private com.airbnb.lottie.b.b bO() {
        if (getCallback() == null) {
            return null;
        }
        if (this.lk != null && !this.lk.P(getContext())) {
            this.lk.bm();
            this.lk = null;
        }
        if (this.lk == null) {
            this.lk = new com.airbnb.lottie.b.b(getCallback(), this.kQ, this.ll, this.kJ.bC());
        }
        return this.lk;
    }

    @Nullable
    public Typeface g(String str, String str2) {
        com.airbnb.lottie.b.a bP = bP();
        if (bP != null) {
            return bP.g(str, str2);
        }
        return null;
    }

    private com.airbnb.lottie.b.a bP() {
        if (getCallback() == null) {
            return null;
        }
        if (this.lm == null) {
            this.lm = new com.airbnb.lottie.b.a(getCallback(), this.ln);
        }
        return this.lm;
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
        return Math.min(canvas.getWidth() / this.kJ.getBounds().width(), canvas.getHeight() / this.kJ.getBounds().height());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a {
        @Nullable
        final String lA;
        @Nullable
        final ColorFilter lB;
        final String ly;

        a(@Nullable String str, @Nullable String str2, @Nullable ColorFilter colorFilter) {
            this.ly = str;
            this.lA = str2;
            this.lB = colorFilter;
        }

        public int hashCode() {
            int i = 17;
            if (this.ly != null) {
                i = this.ly.hashCode() * 527;
            }
            if (this.lA != null) {
                return i * 31 * this.lA.hashCode();
            }
            return i;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof a) {
                a aVar = (a) obj;
                return hashCode() == aVar.hashCode() && this.lB == aVar.lB;
            }
            return false;
        }
    }
}
