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
    private com.airbnb.lottie.b.b nL;
    @Nullable
    private c nM;
    @Nullable
    private com.airbnb.lottie.b.a nN;
    @Nullable
    com.airbnb.lottie.b nO;
    @Nullable
    l nP;
    private boolean nQ;
    @Nullable
    private com.airbnb.lottie.model.layer.b nR;
    private boolean nS;
    private e nj;
    @Nullable
    private String nr;
    private final Matrix matrix = new Matrix();
    private final com.airbnb.lottie.c.c nI = new com.airbnb.lottie.c.c();
    private float scale = 1.0f;
    private final Set<a> nJ = new HashSet();
    private final ArrayList<b> nK = new ArrayList<>();
    private int alpha = 255;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public interface b {
        void i(e eVar);
    }

    public f() {
        this.nI.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.airbnb.lottie.f.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (f.this.nR != null) {
                    f.this.nR.setProgress(f.this.nI.eW());
                }
            }
        });
    }

    public boolean cL() {
        return this.nQ;
    }

    public void E(boolean z) {
        if (Build.VERSION.SDK_INT < 19) {
            Log.w(TAG, "Merge paths are not supported pre-Kit Kat.");
            return;
        }
        this.nQ = z;
        if (this.nj != null) {
            cM();
        }
    }

    public void X(@Nullable String str) {
        this.nr = str;
    }

    @Nullable
    public String getImageAssetsFolder() {
        return this.nr;
    }

    public void cs() {
        if (this.nL != null) {
            this.nL.cs();
        }
    }

    public boolean h(e eVar) {
        if (this.nj == eVar) {
            return false;
        }
        cO();
        this.nj = eVar;
        cM();
        this.nI.k(eVar.getDuration());
        setProgress(this.nI.eW());
        setScale(this.scale);
        cT();
        cN();
        Iterator it = new ArrayList(this.nK).iterator();
        while (it.hasNext()) {
            ((b) it.next()).i(eVar);
            it.remove();
        }
        this.nK.clear();
        eVar.setPerformanceTrackingEnabled(this.nS);
        return true;
    }

    public void setPerformanceTrackingEnabled(boolean z) {
        this.nS = z;
        if (this.nj != null) {
            this.nj.setPerformanceTrackingEnabled(z);
        }
    }

    @Nullable
    public i getPerformanceTracker() {
        if (this.nj != null) {
            return this.nj.getPerformanceTracker();
        }
        return null;
    }

    private void cM() {
        this.nR = new com.airbnb.lottie.model.layer.b(this, Layer.a.k(this.nj), this.nj.cF(), this.nj);
    }

    private void cN() {
        if (this.nR != null) {
            for (a aVar : this.nJ) {
                this.nR.b(aVar.nX, aVar.nY, aVar.nZ);
            }
        }
    }

    public void cO() {
        cs();
        if (this.nI.isRunning()) {
            this.nI.cancel();
        }
        this.nj = null;
        this.nR = null;
        this.nL = null;
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
        if (colorFilter == null && this.nJ.contains(aVar)) {
            this.nJ.remove(aVar);
        } else {
            this.nJ.add(new a(str, str2, colorFilter));
        }
        if (this.nR != null) {
            this.nR.b(str, str2, colorFilter);
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
        if (this.nR != null) {
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
                float width = this.nj.getBounds().width() / 2.0f;
                float height = this.nj.getBounds().height() / 2.0f;
                float f3 = width * c;
                float f4 = height * c;
                canvas.translate((width * getScale()) - f3, (height * getScale()) - f4);
                canvas.scale(f, f, f3, f4);
            }
            this.matrix.reset();
            this.matrix.preScale(c, c);
            this.nR.a(canvas, this.matrix, this.alpha);
            d.U("Drawable#draw");
            if (f > 1.0f) {
                canvas.restore();
            }
        }
    }

    public void cu() {
        if (this.nR == null) {
            this.nK.add(new b() { // from class: com.airbnb.lottie.f.2
                @Override // com.airbnb.lottie.f.b
                public void i(e eVar) {
                    f.this.cu();
                }
            });
        } else {
            this.nI.cu();
        }
    }

    public void cv() {
        if (this.nR == null) {
            this.nK.add(new b() { // from class: com.airbnb.lottie.f.3
                @Override // com.airbnb.lottie.f.b
                public void i(e eVar) {
                    f.this.cv();
                }
            });
        } else {
            this.nI.cv();
        }
    }

    public void setMinFrame(final int i) {
        if (this.nj == null) {
            this.nK.add(new b() { // from class: com.airbnb.lottie.f.4
                @Override // com.airbnb.lottie.f.b
                public void i(e eVar) {
                    f.this.setMinFrame(i);
                }
            });
        } else {
            setMinProgress(i / this.nj.cJ());
        }
    }

    public void setMinProgress(float f) {
        this.nI.m(f);
    }

    public void setMaxFrame(final int i) {
        if (this.nj == null) {
            this.nK.add(new b() { // from class: com.airbnb.lottie.f.5
                @Override // com.airbnb.lottie.f.b
                public void i(e eVar) {
                    f.this.setMaxFrame(i);
                }
            });
        } else {
            setMaxProgress(i / this.nj.cJ());
        }
    }

    public void setMaxProgress(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        this.nI.n(f);
    }

    public void setMinAndMaxFrame(final int i, final int i2) {
        if (this.nj == null) {
            this.nK.add(new b() { // from class: com.airbnb.lottie.f.6
                @Override // com.airbnb.lottie.f.b
                public void i(e eVar) {
                    f.this.setMinAndMaxFrame(i, i2);
                }
            });
        } else {
            this.nI.j(i / this.nj.cJ(), i2 / this.nj.cJ());
        }
    }

    public void setMinAndMaxProgress(@FloatRange(from = 0.0d, to = 1.0d) float f, @FloatRange(from = 0.0d, to = 1.0d) float f2) {
        this.nI.j(f, f2);
    }

    public void setSpeed(float f) {
        this.nI.setSpeed(f);
    }

    public float getSpeed() {
        return this.nI.getSpeed();
    }

    public void a(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.nI.addUpdateListener(animatorUpdateListener);
    }

    public void b(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.nI.removeUpdateListener(animatorUpdateListener);
    }

    public void a(Animator.AnimatorListener animatorListener) {
        this.nI.addListener(animatorListener);
    }

    public void b(Animator.AnimatorListener animatorListener) {
        this.nI.removeListener(animatorListener);
    }

    public void setFrame(final int i) {
        if (this.nj == null) {
            this.nK.add(new b() { // from class: com.airbnb.lottie.f.7
                @Override // com.airbnb.lottie.f.b
                public void i(e eVar) {
                    f.this.setFrame(i);
                }
            });
        } else {
            setProgress(i / this.nj.cJ());
        }
    }

    public int getFrame() {
        if (this.nj == null) {
            return 0;
        }
        return (int) (getProgress() * this.nj.cJ());
    }

    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        this.nI.l(f);
        if (this.nR != null) {
            this.nR.setProgress(f);
        }
    }

    public void G(boolean z) {
        this.nI.setRepeatCount(z ? -1 : 0);
    }

    public boolean isLooping() {
        return this.nI.getRepeatCount() == -1;
    }

    public boolean isAnimating() {
        return this.nI.isRunning();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cP() {
        this.nI.cP();
    }

    public void setScale(float f) {
        this.scale = f;
        cT();
    }

    public void setImageAssetDelegate(c cVar) {
        this.nM = cVar;
        if (this.nL != null) {
            this.nL.a(cVar);
        }
    }

    public void setFontAssetDelegate(com.airbnb.lottie.b bVar) {
        this.nO = bVar;
        if (this.nN != null) {
            this.nN.a(bVar);
        }
    }

    public void setTextDelegate(l lVar) {
        this.nP = lVar;
    }

    @Nullable
    public l cQ() {
        return this.nP;
    }

    public boolean cR() {
        return this.nP == null && this.nj.cG().size() > 0;
    }

    public float getScale() {
        return this.scale;
    }

    public e cS() {
        return this.nj;
    }

    private void cT() {
        if (this.nj != null) {
            float scale = getScale();
            setBounds(0, 0, (int) (this.nj.getBounds().width() * scale), (int) (scale * this.nj.getBounds().height()));
        }
    }

    public void cancelAnimation() {
        this.nK.clear();
        this.nI.cancel();
    }

    public void cw() {
        this.nK.clear();
        this.nI.cw();
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float getProgress() {
        return this.nI.eW();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        if (this.nj == null) {
            return -1;
        }
        return (int) (this.nj.getBounds().width() * getScale());
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        if (this.nj == null) {
            return -1;
        }
        return (int) (this.nj.getBounds().height() * getScale());
    }

    @Nullable
    public Bitmap Y(String str) {
        com.airbnb.lottie.b.b cU = cU();
        if (cU != null) {
            return cU.ac(str);
        }
        return null;
    }

    private com.airbnb.lottie.b.b cU() {
        if (getCallback() == null) {
            return null;
        }
        if (this.nL != null && !this.nL.ay(getContext())) {
            this.nL.cs();
            this.nL = null;
        }
        if (this.nL == null) {
            this.nL = new com.airbnb.lottie.b.b(getCallback(), this.nr, this.nM, this.nj.cI());
        }
        return this.nL;
    }

    @Nullable
    public Typeface n(String str, String str2) {
        com.airbnb.lottie.b.a cV = cV();
        if (cV != null) {
            return cV.n(str, str2);
        }
        return null;
    }

    private com.airbnb.lottie.b.a cV() {
        if (getCallback() == null) {
            return null;
        }
        if (this.nN == null) {
            this.nN = new com.airbnb.lottie.b.a(getCallback(), this.nO);
        }
        return this.nN;
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
        return Math.min(canvas.getWidth() / this.nj.getBounds().width(), canvas.getHeight() / this.nj.getBounds().height());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a {
        final String nX;
        @Nullable
        final String nY;
        @Nullable
        final ColorFilter nZ;

        a(@Nullable String str, @Nullable String str2, @Nullable ColorFilter colorFilter) {
            this.nX = str;
            this.nY = str2;
            this.nZ = colorFilter;
        }

        public int hashCode() {
            int i = 17;
            if (this.nX != null) {
                i = this.nX.hashCode() * 527;
            }
            if (this.nY != null) {
                return i * 31 * this.nY.hashCode();
            }
            return i;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof a) {
                a aVar = (a) obj;
                return hashCode() == aVar.hashCode() && this.nZ == aVar.nZ;
            }
            return false;
        }
    }
}
