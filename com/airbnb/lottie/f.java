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
    private e kI;
    @Nullable
    private String kP;
    @Nullable
    private com.airbnb.lottie.b.b lj;
    @Nullable
    private c lk;
    @Nullable
    private com.airbnb.lottie.b.a ll;
    @Nullable
    com.airbnb.lottie.b lm;
    @Nullable
    l ln;
    private boolean lo;
    @Nullable
    private com.airbnb.lottie.model.layer.b lq;
    private boolean lr;
    private final Matrix matrix = new Matrix();
    private final com.airbnb.lottie.c.c lg = new com.airbnb.lottie.c.c();
    private float scale = 1.0f;
    private final Set<a> lh = new HashSet();
    private final ArrayList<b> li = new ArrayList<>();
    private int alpha = 255;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public interface b {
        void i(e eVar);
    }

    public f() {
        this.lg.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.airbnb.lottie.f.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (f.this.lq != null) {
                    f.this.lq.setProgress(f.this.lg.dX());
                }
            }
        });
    }

    public boolean bJ() {
        return this.lo;
    }

    public void w(boolean z) {
        if (Build.VERSION.SDK_INT < 19) {
            Log.w(TAG, "Merge paths are not supported pre-Kit Kat.");
            return;
        }
        this.lo = z;
        if (this.kI != null) {
            bK();
        }
    }

    public void G(@Nullable String str) {
        this.kP = str;
    }

    @Nullable
    public String getImageAssetsFolder() {
        return this.kP;
    }

    public void bp() {
        if (this.lj != null) {
            this.lj.bp();
        }
    }

    public boolean h(e eVar) {
        if (this.kI == eVar) {
            return false;
        }
        bM();
        this.kI = eVar;
        bK();
        this.lg.h(eVar.getDuration());
        setProgress(this.lg.dX());
        setScale(this.scale);
        bR();
        bL();
        Iterator it = new ArrayList(this.li).iterator();
        while (it.hasNext()) {
            ((b) it.next()).i(eVar);
            it.remove();
        }
        this.li.clear();
        eVar.setPerformanceTrackingEnabled(this.lr);
        return true;
    }

    public void setPerformanceTrackingEnabled(boolean z) {
        this.lr = z;
        if (this.kI != null) {
            this.kI.setPerformanceTrackingEnabled(z);
        }
    }

    @Nullable
    public i getPerformanceTracker() {
        if (this.kI != null) {
            return this.kI.getPerformanceTracker();
        }
        return null;
    }

    private void bK() {
        this.lq = new com.airbnb.lottie.model.layer.b(this, Layer.a.k(this.kI), this.kI.bD(), this.kI);
    }

    private void bL() {
        if (this.lq != null) {
            for (a aVar : this.lh) {
                this.lq.b(aVar.lx, aVar.ly, aVar.lA);
            }
        }
    }

    public void bM() {
        bp();
        if (this.lg.isRunning()) {
            this.lg.cancel();
        }
        this.kI = null;
        this.lq = null;
        this.lj = null;
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
        if (colorFilter == null && this.lh.contains(aVar)) {
            this.lh.remove(aVar);
        } else {
            this.lh.add(new a(str, str2, colorFilter));
        }
        if (this.lq != null) {
            this.lq.b(str, str2, colorFilter);
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
        if (this.lq != null) {
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
                float width = this.kI.bz().width() / 2.0f;
                float height = this.kI.bz().height() / 2.0f;
                float f3 = width * c;
                float f4 = height * c;
                canvas.translate((width * getScale()) - f3, (height * getScale()) - f4);
                canvas.scale(f, f, f3, f4);
            }
            this.matrix.reset();
            this.matrix.preScale(c, c);
            this.lq.a(canvas, this.matrix, this.alpha);
            d.D("Drawable#draw");
            if (f > 1.0f) {
                canvas.restore();
            }
        }
    }

    public void br() {
        if (this.lq == null) {
            this.li.add(new b() { // from class: com.airbnb.lottie.f.2
                @Override // com.airbnb.lottie.f.b
                public void i(e eVar) {
                    f.this.br();
                }
            });
        } else {
            this.lg.br();
        }
    }

    public void bs() {
        if (this.lq == null) {
            this.li.add(new b() { // from class: com.airbnb.lottie.f.3
                @Override // com.airbnb.lottie.f.b
                public void i(e eVar) {
                    f.this.bs();
                }
            });
        } else {
            this.lg.bs();
        }
    }

    public void setMinFrame(final int i) {
        if (this.kI == null) {
            this.li.add(new b() { // from class: com.airbnb.lottie.f.4
                @Override // com.airbnb.lottie.f.b
                public void i(e eVar) {
                    f.this.setMinFrame(i);
                }
            });
        } else {
            setMinProgress(i / this.kI.bH());
        }
    }

    public void setMinProgress(float f) {
        this.lg.m(f);
    }

    public void setMaxFrame(final int i) {
        if (this.kI == null) {
            this.li.add(new b() { // from class: com.airbnb.lottie.f.5
                @Override // com.airbnb.lottie.f.b
                public void i(e eVar) {
                    f.this.setMaxFrame(i);
                }
            });
        } else {
            setMaxProgress(i / this.kI.bH());
        }
    }

    public void setMaxProgress(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        this.lg.n(f);
    }

    public void setMinAndMaxFrame(final int i, final int i2) {
        if (this.kI == null) {
            this.li.add(new b() { // from class: com.airbnb.lottie.f.6
                @Override // com.airbnb.lottie.f.b
                public void i(e eVar) {
                    f.this.setMinAndMaxFrame(i, i2);
                }
            });
        } else {
            this.lg.j(i / this.kI.bH(), i2 / this.kI.bH());
        }
    }

    public void setMinAndMaxProgress(@FloatRange(from = 0.0d, to = 1.0d) float f, @FloatRange(from = 0.0d, to = 1.0d) float f2) {
        this.lg.j(f, f2);
    }

    public void setSpeed(float f) {
        this.lg.setSpeed(f);
    }

    public float getSpeed() {
        return this.lg.getSpeed();
    }

    public void a(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.lg.addUpdateListener(animatorUpdateListener);
    }

    public void c(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.lg.removeUpdateListener(animatorUpdateListener);
    }

    public void a(Animator.AnimatorListener animatorListener) {
        this.lg.addListener(animatorListener);
    }

    public void b(Animator.AnimatorListener animatorListener) {
        this.lg.removeListener(animatorListener);
    }

    public void setFrame(final int i) {
        if (this.kI == null) {
            this.li.add(new b() { // from class: com.airbnb.lottie.f.7
                @Override // com.airbnb.lottie.f.b
                public void i(e eVar) {
                    f.this.setFrame(i);
                }
            });
        } else {
            setProgress(i / this.kI.bH());
        }
    }

    public int getFrame() {
        if (this.kI == null) {
            return 0;
        }
        return (int) (getProgress() * this.kI.bH());
    }

    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        this.lg.l(f);
        if (this.lq != null) {
            this.lq.setProgress(f);
        }
    }

    public void y(boolean z) {
        this.lg.setRepeatCount(z ? -1 : 0);
    }

    public boolean isLooping() {
        return this.lg.getRepeatCount() == -1;
    }

    public boolean isAnimating() {
        return this.lg.isRunning();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bN() {
        this.lg.bN();
    }

    public void setScale(float f) {
        this.scale = f;
        bR();
    }

    public void setImageAssetDelegate(c cVar) {
        this.lk = cVar;
        if (this.lj != null) {
            this.lj.a(cVar);
        }
    }

    public void setFontAssetDelegate(com.airbnb.lottie.b bVar) {
        this.lm = bVar;
        if (this.ll != null) {
            this.ll.a(bVar);
        }
    }

    public void setTextDelegate(l lVar) {
        this.ln = lVar;
    }

    @Nullable
    public l bO() {
        return this.ln;
    }

    public boolean bP() {
        return this.ln == null && this.kI.bE().size() > 0;
    }

    public float getScale() {
        return this.scale;
    }

    public e bQ() {
        return this.kI;
    }

    private void bR() {
        if (this.kI != null) {
            float scale = getScale();
            setBounds(0, 0, (int) (this.kI.bz().width() * scale), (int) (scale * this.kI.bz().height()));
        }
    }

    public void cancelAnimation() {
        this.li.clear();
        this.lg.cancel();
    }

    public void bt() {
        this.li.clear();
        this.lg.bt();
    }

    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    public float getProgress() {
        return this.lg.dX();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        if (this.kI == null) {
            return -1;
        }
        return (int) (this.kI.bz().width() * getScale());
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        if (this.kI == null) {
            return -1;
        }
        return (int) (this.kI.bz().height() * getScale());
    }

    @Nullable
    public Bitmap H(String str) {
        com.airbnb.lottie.b.b bS = bS();
        if (bS != null) {
            return bS.L(str);
        }
        return null;
    }

    private com.airbnb.lottie.b.b bS() {
        if (getCallback() == null) {
            return null;
        }
        if (this.lj != null && !this.lj.P(getContext())) {
            this.lj.bp();
            this.lj = null;
        }
        if (this.lj == null) {
            this.lj = new com.airbnb.lottie.b.b(getCallback(), this.kP, this.lk, this.kI.bG());
        }
        return this.lj;
    }

    @Nullable
    public Typeface g(String str, String str2) {
        com.airbnb.lottie.b.a bT = bT();
        if (bT != null) {
            return bT.g(str, str2);
        }
        return null;
    }

    private com.airbnb.lottie.b.a bT() {
        if (getCallback() == null) {
            return null;
        }
        if (this.ll == null) {
            this.ll = new com.airbnb.lottie.b.a(getCallback(), this.lm);
        }
        return this.ll;
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
        return Math.min(canvas.getWidth() / this.kI.bz().width(), canvas.getHeight() / this.kI.bz().height());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a {
        @Nullable
        final ColorFilter lA;
        final String lx;
        @Nullable
        final String ly;

        a(@Nullable String str, @Nullable String str2, @Nullable ColorFilter colorFilter) {
            this.lx = str;
            this.ly = str2;
            this.lA = colorFilter;
        }

        public int hashCode() {
            int i = 17;
            if (this.lx != null) {
                i = this.lx.hashCode() * 527;
            }
            if (this.ly != null) {
                return i * 31 * this.ly.hashCode();
            }
            return i;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof a) {
                a aVar = (a) obj;
                return hashCode() == aVar.hashCode() && this.lA == aVar.lA;
            }
            return false;
        }
    }
}
