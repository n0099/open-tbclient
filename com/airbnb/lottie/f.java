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
    private com.airbnb.lottie.b.b dN;
    @Nullable
    private c dO;
    @Nullable
    private com.airbnb.lottie.b.a dP;
    @Nullable
    com.airbnb.lottie.b dQ;
    @Nullable
    l dR;
    private boolean dS;
    @Nullable
    private com.airbnb.lottie.model.layer.b dT;
    private boolean dU;
    private e dk;
    @Nullable
    private String dt;
    private final Matrix matrix = new Matrix();
    private final com.airbnb.lottie.c.c dK = new com.airbnb.lottie.c.c();
    private float scale = 1.0f;
    private final Set<a> dL = new HashSet();
    private final ArrayList<b> dM = new ArrayList<>();
    private int alpha = 255;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public interface b {
        void i(e eVar);
    }

    public f() {
        this.dK.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.airbnb.lottie.f.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (f.this.dT != null) {
                    f.this.dT.setProgress(f.this.dK.dq());
                }
            }
        });
    }

    public boolean bc() {
        return this.dS;
    }

    public void enableMergePathsForKitKatAndAbove(boolean z) {
        if (Build.VERSION.SDK_INT < 19) {
            Log.w(TAG, "Merge paths are not supported pre-Kit Kat.");
            return;
        }
        this.dS = z;
        if (this.dk != null) {
            bd();
        }
    }

    public void G(@Nullable String str) {
        this.dt = str;
    }

    @Nullable
    public String getImageAssetsFolder() {
        return this.dt;
    }

    public void recycleBitmaps() {
        if (this.dN != null) {
            this.dN.recycleBitmaps();
        }
    }

    public boolean h(e eVar) {
        if (this.dk == eVar) {
            return false;
        }
        bf();
        this.dk = eVar;
        bd();
        this.dK.h(eVar.getDuration());
        setProgress(this.dK.dq());
        setScale(this.scale);
        bk();
        be();
        Iterator it = new ArrayList(this.dM).iterator();
        while (it.hasNext()) {
            ((b) it.next()).i(eVar);
            it.remove();
        }
        this.dM.clear();
        eVar.setPerformanceTrackingEnabled(this.dU);
        return true;
    }

    public void setPerformanceTrackingEnabled(boolean z) {
        this.dU = z;
        if (this.dk != null) {
            this.dk.setPerformanceTrackingEnabled(z);
        }
    }

    @Nullable
    public i getPerformanceTracker() {
        if (this.dk != null) {
            return this.dk.getPerformanceTracker();
        }
        return null;
    }

    private void bd() {
        this.dT = new com.airbnb.lottie.model.layer.b(this, Layer.a.k(this.dk), this.dk.aW(), this.dk);
    }

    private void be() {
        if (this.dT != null) {
            for (a aVar : this.dL) {
                this.dT.b(aVar.dZ, aVar.ea, aVar.eb);
            }
        }
    }

    public void bf() {
        recycleBitmaps();
        if (this.dK.isRunning()) {
            this.dK.cancel();
        }
        this.dk = null;
        this.dT = null;
        this.dN = null;
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

    public void addColorFilter(ColorFilter colorFilter) {
        a(null, null, colorFilter);
    }

    private void a(@Nullable String str, @Nullable String str2, @Nullable ColorFilter colorFilter) {
        a aVar = new a(str, str2, colorFilter);
        if (colorFilter == null && this.dL.contains(aVar)) {
            this.dL.remove(aVar);
        } else {
            this.dL.add(new a(str, str2, colorFilter));
        }
        if (this.dT != null) {
            this.dT.b(str, str2, colorFilter);
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
        if (this.dT != null) {
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
                float width = this.dk.aS().width() / 2.0f;
                float height = this.dk.aS().height() / 2.0f;
                float f3 = width * c;
                float f4 = height * c;
                canvas.translate((width * getScale()) - f3, (height * getScale()) - f4);
                canvas.scale(f, f, f3, f4);
            }
            this.matrix.reset();
            this.matrix.preScale(c, c);
            this.dT.a(canvas, this.matrix, this.alpha);
            d.D("Drawable#draw");
            if (f > 1.0f) {
                canvas.restore();
            }
        }
    }

    public void playAnimation() {
        if (this.dT == null) {
            this.dM.add(new b() { // from class: com.airbnb.lottie.f.2
                @Override // com.airbnb.lottie.f.b
                public void i(e eVar) {
                    f.this.playAnimation();
                }
            });
        } else {
            this.dK.playAnimation();
        }
    }

    public void resumeAnimation() {
        if (this.dT == null) {
            this.dM.add(new b() { // from class: com.airbnb.lottie.f.3
                @Override // com.airbnb.lottie.f.b
                public void i(e eVar) {
                    f.this.resumeAnimation();
                }
            });
        } else {
            this.dK.resumeAnimation();
        }
    }

    public void setMinFrame(final int i) {
        if (this.dk == null) {
            this.dM.add(new b() { // from class: com.airbnb.lottie.f.4
                @Override // com.airbnb.lottie.f.b
                public void i(e eVar) {
                    f.this.setMinFrame(i);
                }
            });
        } else {
            setMinProgress(i / this.dk.ba());
        }
    }

    public void setMinProgress(float f) {
        this.dK.m(f);
    }

    public void setMaxFrame(final int i) {
        if (this.dk == null) {
            this.dM.add(new b() { // from class: com.airbnb.lottie.f.5
                @Override // com.airbnb.lottie.f.b
                public void i(e eVar) {
                    f.this.setMaxFrame(i);
                }
            });
        } else {
            setMaxProgress(i / this.dk.ba());
        }
    }

    public void setMaxProgress(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        this.dK.n(f);
    }

    public void setMinAndMaxFrame(final int i, final int i2) {
        if (this.dk == null) {
            this.dM.add(new b() { // from class: com.airbnb.lottie.f.6
                @Override // com.airbnb.lottie.f.b
                public void i(e eVar) {
                    f.this.setMinAndMaxFrame(i, i2);
                }
            });
        } else {
            this.dK.j(i / this.dk.ba(), i2 / this.dk.ba());
        }
    }

    public void setMinAndMaxProgress(@FloatRange(from = 0.0d, to = 1.0d) float f, @FloatRange(from = 0.0d, to = 1.0d) float f2) {
        this.dK.j(f, f2);
    }

    public void setSpeed(float f) {
        this.dK.setSpeed(f);
    }

    public float getSpeed() {
        return this.dK.getSpeed();
    }

    public void addAnimatorUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.dK.addUpdateListener(animatorUpdateListener);
    }

    public void a(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.dK.removeUpdateListener(animatorUpdateListener);
    }

    public void addAnimatorListener(Animator.AnimatorListener animatorListener) {
        this.dK.addListener(animatorListener);
    }

    public void removeAnimatorListener(Animator.AnimatorListener animatorListener) {
        this.dK.removeListener(animatorListener);
    }

    public void setFrame(final int i) {
        if (this.dk == null) {
            this.dM.add(new b() { // from class: com.airbnb.lottie.f.7
                @Override // com.airbnb.lottie.f.b
                public void i(e eVar) {
                    f.this.setFrame(i);
                }
            });
        } else {
            setProgress(i / this.dk.ba());
        }
    }

    public int getFrame() {
        if (this.dk == null) {
            return 0;
        }
        return (int) (getProgress() * this.dk.ba());
    }

    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        this.dK.l(f);
        if (this.dT != null) {
            this.dT.setProgress(f);
        }
    }

    public void loop(boolean z) {
        this.dK.setRepeatCount(z ? -1 : 0);
    }

    public boolean isLooping() {
        return this.dK.getRepeatCount() == -1;
    }

    public boolean isAnimating() {
        return this.dK.isRunning();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bg() {
        this.dK.bg();
    }

    public void setScale(float f) {
        this.scale = f;
        bk();
    }

    public void setImageAssetDelegate(c cVar) {
        this.dO = cVar;
        if (this.dN != null) {
            this.dN.a(cVar);
        }
    }

    public void setFontAssetDelegate(com.airbnb.lottie.b bVar) {
        this.dQ = bVar;
        if (this.dP != null) {
            this.dP.a(bVar);
        }
    }

    public void setTextDelegate(l lVar) {
        this.dR = lVar;
    }

    @Nullable
    public l bh() {
        return this.dR;
    }

    public boolean bi() {
        return this.dR == null && this.dk.aX().size() > 0;
    }

    public float getScale() {
        return this.scale;
    }

    public e bj() {
        return this.dk;
    }

    private void bk() {
        if (this.dk != null) {
            float scale = getScale();
            setBounds(0, 0, (int) (this.dk.aS().width() * scale), (int) (scale * this.dk.aS().height()));
        }
    }

    public void cancelAnimation() {
        this.dM.clear();
        this.dK.cancel();
    }

    public void pauseAnimation() {
        this.dM.clear();
        this.dK.pauseAnimation();
    }

    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    public float getProgress() {
        return this.dK.dq();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        if (this.dk == null) {
            return -1;
        }
        return (int) (this.dk.aS().width() * getScale());
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        if (this.dk == null) {
            return -1;
        }
        return (int) (this.dk.aS().height() * getScale());
    }

    @Nullable
    public Bitmap H(String str) {
        com.airbnb.lottie.b.b bl = bl();
        if (bl != null) {
            return bl.L(str);
        }
        return null;
    }

    private com.airbnb.lottie.b.b bl() {
        if (getCallback() == null) {
            return null;
        }
        if (this.dN != null && !this.dN.P(getContext())) {
            this.dN.recycleBitmaps();
            this.dN = null;
        }
        if (this.dN == null) {
            this.dN = new com.airbnb.lottie.b.b(getCallback(), this.dt, this.dO, this.dk.aZ());
        }
        return this.dN;
    }

    @Nullable
    public Typeface g(String str, String str2) {
        com.airbnb.lottie.b.a bm = bm();
        if (bm != null) {
            return bm.g(str, str2);
        }
        return null;
    }

    private com.airbnb.lottie.b.a bm() {
        if (getCallback() == null) {
            return null;
        }
        if (this.dP == null) {
            this.dP = new com.airbnb.lottie.b.a(getCallback(), this.dQ);
        }
        return this.dP;
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
        return Math.min(canvas.getWidth() / this.dk.aS().width(), canvas.getHeight() / this.dk.aS().height());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a {
        final String dZ;
        @Nullable
        final String ea;
        @Nullable
        final ColorFilter eb;

        a(@Nullable String str, @Nullable String str2, @Nullable ColorFilter colorFilter) {
            this.dZ = str;
            this.ea = str2;
            this.eb = colorFilter;
        }

        public int hashCode() {
            int i = 17;
            if (this.dZ != null) {
                i = this.dZ.hashCode() * 527;
            }
            if (this.ea != null) {
                return i * 31 * this.ea.hashCode();
            }
            return i;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof a) {
                a aVar = (a) obj;
                return hashCode() == aVar.hashCode() && this.eb == aVar.eb;
            }
            return false;
        }
    }
}
