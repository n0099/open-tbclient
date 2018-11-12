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
    @Nullable
    private com.airbnb.lottie.b.b nQ;
    @Nullable
    private c nR;
    @Nullable
    private com.airbnb.lottie.b.a nS;
    @Nullable
    com.airbnb.lottie.b nT;
    @Nullable
    l nU;
    private boolean nV;
    @Nullable
    private com.airbnb.lottie.model.layer.b nW;
    private boolean nX;
    private e np;
    @Nullable
    private String nw;
    private final Matrix matrix = new Matrix();
    private final com.airbnb.lottie.c.c nN = new com.airbnb.lottie.c.c();
    private float scale = 1.0f;
    private final Set<a> nO = new HashSet();
    private final ArrayList<b> nP = new ArrayList<>();
    private int alpha = 255;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public interface b {
        void i(e eVar);
    }

    public f() {
        this.nN.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.airbnb.lottie.f.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (f.this.nW != null) {
                    f.this.nW.setProgress(f.this.nN.eX());
                }
            }
        });
    }

    public boolean cM() {
        return this.nV;
    }

    public void E(boolean z) {
        if (Build.VERSION.SDK_INT < 19) {
            Log.w(TAG, "Merge paths are not supported pre-Kit Kat.");
            return;
        }
        this.nV = z;
        if (this.np != null) {
            cN();
        }
    }

    public void X(@Nullable String str) {
        this.nw = str;
    }

    @Nullable
    public String getImageAssetsFolder() {
        return this.nw;
    }

    public void ct() {
        if (this.nQ != null) {
            this.nQ.ct();
        }
    }

    public boolean h(e eVar) {
        if (this.np == eVar) {
            return false;
        }
        cP();
        this.np = eVar;
        cN();
        this.nN.m(eVar.getDuration());
        setProgress(this.nN.eX());
        setScale(this.scale);
        cU();
        cO();
        Iterator it = new ArrayList(this.nP).iterator();
        while (it.hasNext()) {
            ((b) it.next()).i(eVar);
            it.remove();
        }
        this.nP.clear();
        eVar.setPerformanceTrackingEnabled(this.nX);
        return true;
    }

    public void setPerformanceTrackingEnabled(boolean z) {
        this.nX = z;
        if (this.np != null) {
            this.np.setPerformanceTrackingEnabled(z);
        }
    }

    @Nullable
    public i getPerformanceTracker() {
        if (this.np != null) {
            return this.np.getPerformanceTracker();
        }
        return null;
    }

    private void cN() {
        this.nW = new com.airbnb.lottie.model.layer.b(this, Layer.a.k(this.np), this.np.cG(), this.np);
    }

    private void cO() {
        if (this.nW != null) {
            for (a aVar : this.nO) {
                this.nW.b(aVar.oc, aVar.od, aVar.oe);
            }
        }
    }

    public void cP() {
        ct();
        if (this.nN.isRunning()) {
            this.nN.cancel();
        }
        this.np = null;
        this.nW = null;
        this.nQ = null;
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
        if (colorFilter == null && this.nO.contains(aVar)) {
            this.nO.remove(aVar);
        } else {
            this.nO.add(new a(str, str2, colorFilter));
        }
        if (this.nW != null) {
            this.nW.b(str, str2, colorFilter);
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
        if (this.nW != null) {
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
                float width = this.np.getBounds().width() / 2.0f;
                float height = this.np.getBounds().height() / 2.0f;
                float f3 = width * c;
                float f4 = height * c;
                canvas.translate((width * getScale()) - f3, (height * getScale()) - f4);
                canvas.scale(f, f, f3, f4);
            }
            this.matrix.reset();
            this.matrix.preScale(c, c);
            this.nW.a(canvas, this.matrix, this.alpha);
            d.U("Drawable#draw");
            if (f > 1.0f) {
                canvas.restore();
            }
        }
    }

    public void cv() {
        if (this.nW == null) {
            this.nP.add(new b() { // from class: com.airbnb.lottie.f.2
                @Override // com.airbnb.lottie.f.b
                public void i(e eVar) {
                    f.this.cv();
                }
            });
        } else {
            this.nN.cv();
        }
    }

    public void cw() {
        if (this.nW == null) {
            this.nP.add(new b() { // from class: com.airbnb.lottie.f.3
                @Override // com.airbnb.lottie.f.b
                public void i(e eVar) {
                    f.this.cw();
                }
            });
        } else {
            this.nN.cw();
        }
    }

    public void setMinFrame(final int i) {
        if (this.np == null) {
            this.nP.add(new b() { // from class: com.airbnb.lottie.f.4
                @Override // com.airbnb.lottie.f.b
                public void i(e eVar) {
                    f.this.setMinFrame(i);
                }
            });
        } else {
            setMinProgress(i / this.np.cK());
        }
    }

    public void setMinProgress(float f) {
        this.nN.m(f);
    }

    public void setMaxFrame(final int i) {
        if (this.np == null) {
            this.nP.add(new b() { // from class: com.airbnb.lottie.f.5
                @Override // com.airbnb.lottie.f.b
                public void i(e eVar) {
                    f.this.setMaxFrame(i);
                }
            });
        } else {
            setMaxProgress(i / this.np.cK());
        }
    }

    public void setMaxProgress(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        this.nN.n(f);
    }

    public void setMinAndMaxFrame(final int i, final int i2) {
        if (this.np == null) {
            this.nP.add(new b() { // from class: com.airbnb.lottie.f.6
                @Override // com.airbnb.lottie.f.b
                public void i(e eVar) {
                    f.this.setMinAndMaxFrame(i, i2);
                }
            });
        } else {
            this.nN.j(i / this.np.cK(), i2 / this.np.cK());
        }
    }

    public void setMinAndMaxProgress(@FloatRange(from = 0.0d, to = 1.0d) float f, @FloatRange(from = 0.0d, to = 1.0d) float f2) {
        this.nN.j(f, f2);
    }

    public void setSpeed(float f) {
        this.nN.setSpeed(f);
    }

    public float getSpeed() {
        return this.nN.getSpeed();
    }

    public void a(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.nN.addUpdateListener(animatorUpdateListener);
    }

    public void a(Animator.AnimatorListener animatorListener) {
        this.nN.addListener(animatorListener);
    }

    public void b(Animator.AnimatorListener animatorListener) {
        this.nN.removeListener(animatorListener);
    }

    public void setFrame(final int i) {
        if (this.np == null) {
            this.nP.add(new b() { // from class: com.airbnb.lottie.f.7
                @Override // com.airbnb.lottie.f.b
                public void i(e eVar) {
                    f.this.setFrame(i);
                }
            });
        } else {
            setProgress(i / this.np.cK());
        }
    }

    public int getFrame() {
        if (this.np == null) {
            return 0;
        }
        return (int) (getProgress() * this.np.cK());
    }

    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        this.nN.l(f);
        if (this.nW != null) {
            this.nW.setProgress(f);
        }
    }

    public void G(boolean z) {
        this.nN.setRepeatCount(z ? -1 : 0);
    }

    public boolean isLooping() {
        return this.nN.getRepeatCount() == -1;
    }

    public boolean isAnimating() {
        return this.nN.isRunning();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cQ() {
        this.nN.cQ();
    }

    public void setScale(float f) {
        this.scale = f;
        cU();
    }

    public void setImageAssetDelegate(c cVar) {
        this.nR = cVar;
        if (this.nQ != null) {
            this.nQ.a(cVar);
        }
    }

    public void setFontAssetDelegate(com.airbnb.lottie.b bVar) {
        this.nT = bVar;
        if (this.nS != null) {
            this.nS.a(bVar);
        }
    }

    public void setTextDelegate(l lVar) {
        this.nU = lVar;
    }

    @Nullable
    public l cR() {
        return this.nU;
    }

    public boolean cS() {
        return this.nU == null && this.np.cH().size() > 0;
    }

    public float getScale() {
        return this.scale;
    }

    public e cT() {
        return this.np;
    }

    private void cU() {
        if (this.np != null) {
            float scale = getScale();
            setBounds(0, 0, (int) (this.np.getBounds().width() * scale), (int) (scale * this.np.getBounds().height()));
        }
    }

    public void cancelAnimation() {
        this.nP.clear();
        this.nN.cancel();
    }

    public void cx() {
        this.nP.clear();
        this.nN.cx();
    }

    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    public float getProgress() {
        return this.nN.eX();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        if (this.np == null) {
            return -1;
        }
        return (int) (this.np.getBounds().width() * getScale());
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        if (this.np == null) {
            return -1;
        }
        return (int) (this.np.getBounds().height() * getScale());
    }

    @Nullable
    public Bitmap Y(String str) {
        com.airbnb.lottie.b.b cV = cV();
        if (cV != null) {
            return cV.ac(str);
        }
        return null;
    }

    private com.airbnb.lottie.b.b cV() {
        if (getCallback() == null) {
            return null;
        }
        if (this.nQ != null && !this.nQ.ay(getContext())) {
            this.nQ.ct();
            this.nQ = null;
        }
        if (this.nQ == null) {
            this.nQ = new com.airbnb.lottie.b.b(getCallback(), this.nw, this.nR, this.np.cJ());
        }
        return this.nQ;
    }

    @Nullable
    public Typeface n(String str, String str2) {
        com.airbnb.lottie.b.a cW = cW();
        if (cW != null) {
            return cW.n(str, str2);
        }
        return null;
    }

    private com.airbnb.lottie.b.a cW() {
        if (getCallback() == null) {
            return null;
        }
        if (this.nS == null) {
            this.nS = new com.airbnb.lottie.b.a(getCallback(), this.nT);
        }
        return this.nS;
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
        return Math.min(canvas.getWidth() / this.np.getBounds().width(), canvas.getHeight() / this.np.getBounds().height());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a {
        final String oc;
        @Nullable
        final String od;
        @Nullable
        final ColorFilter oe;

        a(@Nullable String str, @Nullable String str2, @Nullable ColorFilter colorFilter) {
            this.oc = str;
            this.od = str2;
            this.oe = colorFilter;
        }

        public int hashCode() {
            int i = 17;
            if (this.oc != null) {
                i = this.oc.hashCode() * 527;
            }
            if (this.od != null) {
                return i * 31 * this.od.hashCode();
            }
            return i;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof a) {
                a aVar = (a) obj;
                return hashCode() == aVar.hashCode() && this.oe == aVar.oe;
            }
            return false;
        }
    }
}
