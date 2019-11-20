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
    private e cJ;
    @Nullable
    private String cQ;
    @Nullable

    /* renamed from: do  reason: not valid java name */
    private com.airbnb.lottie.b.b f1do;
    @Nullable
    private c dp;
    @Nullable
    private com.airbnb.lottie.b.a dq;
    @Nullable
    com.airbnb.lottie.b dr;
    @Nullable
    l ds;
    private boolean dt;
    @Nullable
    private com.airbnb.lottie.model.layer.b du;
    private boolean dv;
    private final Matrix matrix = new Matrix();
    private final com.airbnb.lottie.c.c dj = new com.airbnb.lottie.c.c();
    private float scale = 1.0f;
    private final Set<a> dk = new HashSet();
    private final ArrayList<b> dl = new ArrayList<>();
    private int alpha = 255;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public interface b {
        void i(e eVar);
    }

    public f() {
        this.dj.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.airbnb.lottie.f.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (f.this.du != null) {
                    f.this.du.setProgress(f.this.dj.dq());
                }
            }
        });
    }

    public boolean bc() {
        return this.dt;
    }

    public void enableMergePathsForKitKatAndAbove(boolean z) {
        if (Build.VERSION.SDK_INT < 19) {
            Log.w(TAG, "Merge paths are not supported pre-Kit Kat.");
            return;
        }
        this.dt = z;
        if (this.cJ != null) {
            bd();
        }
    }

    public void G(@Nullable String str) {
        this.cQ = str;
    }

    @Nullable
    public String getImageAssetsFolder() {
        return this.cQ;
    }

    public void recycleBitmaps() {
        if (this.f1do != null) {
            this.f1do.recycleBitmaps();
        }
    }

    public boolean h(e eVar) {
        if (this.cJ == eVar) {
            return false;
        }
        bf();
        this.cJ = eVar;
        bd();
        this.dj.g(eVar.getDuration());
        setProgress(this.dj.dq());
        setScale(this.scale);
        bk();
        be();
        Iterator it = new ArrayList(this.dl).iterator();
        while (it.hasNext()) {
            ((b) it.next()).i(eVar);
            it.remove();
        }
        this.dl.clear();
        eVar.setPerformanceTrackingEnabled(this.dv);
        return true;
    }

    public void setPerformanceTrackingEnabled(boolean z) {
        this.dv = z;
        if (this.cJ != null) {
            this.cJ.setPerformanceTrackingEnabled(z);
        }
    }

    @Nullable
    public i getPerformanceTracker() {
        if (this.cJ != null) {
            return this.cJ.getPerformanceTracker();
        }
        return null;
    }

    private void bd() {
        this.du = new com.airbnb.lottie.model.layer.b(this, Layer.a.k(this.cJ), this.cJ.aW(), this.cJ);
    }

    private void be() {
        if (this.du != null) {
            for (a aVar : this.dk) {
                this.du.b(aVar.dA, aVar.dB, aVar.dC);
            }
        }
    }

    public void bf() {
        recycleBitmaps();
        if (this.dj.isRunning()) {
            this.dj.cancel();
        }
        this.cJ = null;
        this.du = null;
        this.f1do = null;
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
        if (colorFilter == null && this.dk.contains(aVar)) {
            this.dk.remove(aVar);
        } else {
            this.dk.add(new a(str, str2, colorFilter));
        }
        if (this.du != null) {
            this.du.b(str, str2, colorFilter);
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
        if (this.du != null) {
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
                float width = this.cJ.aS().width() / 2.0f;
                float height = this.cJ.aS().height() / 2.0f;
                float f3 = width * c;
                float f4 = height * c;
                canvas.translate((width * getScale()) - f3, (height * getScale()) - f4);
                canvas.scale(f, f, f3, f4);
            }
            this.matrix.reset();
            this.matrix.preScale(c, c);
            this.du.a(canvas, this.matrix, this.alpha);
            d.D("Drawable#draw");
            if (f > 1.0f) {
                canvas.restore();
            }
        }
    }

    public void playAnimation() {
        if (this.du == null) {
            this.dl.add(new b() { // from class: com.airbnb.lottie.f.2
                @Override // com.airbnb.lottie.f.b
                public void i(e eVar) {
                    f.this.playAnimation();
                }
            });
        } else {
            this.dj.playAnimation();
        }
    }

    public void resumeAnimation() {
        if (this.du == null) {
            this.dl.add(new b() { // from class: com.airbnb.lottie.f.3
                @Override // com.airbnb.lottie.f.b
                public void i(e eVar) {
                    f.this.resumeAnimation();
                }
            });
        } else {
            this.dj.resumeAnimation();
        }
    }

    public void setMinFrame(final int i) {
        if (this.cJ == null) {
            this.dl.add(new b() { // from class: com.airbnb.lottie.f.4
                @Override // com.airbnb.lottie.f.b
                public void i(e eVar) {
                    f.this.setMinFrame(i);
                }
            });
        } else {
            setMinProgress(i / this.cJ.ba());
        }
    }

    public void setMinProgress(float f) {
        this.dj.m(f);
    }

    public void setMaxFrame(final int i) {
        if (this.cJ == null) {
            this.dl.add(new b() { // from class: com.airbnb.lottie.f.5
                @Override // com.airbnb.lottie.f.b
                public void i(e eVar) {
                    f.this.setMaxFrame(i);
                }
            });
        } else {
            setMaxProgress(i / this.cJ.ba());
        }
    }

    public void setMaxProgress(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        this.dj.n(f);
    }

    public void setMinAndMaxFrame(final int i, final int i2) {
        if (this.cJ == null) {
            this.dl.add(new b() { // from class: com.airbnb.lottie.f.6
                @Override // com.airbnb.lottie.f.b
                public void i(e eVar) {
                    f.this.setMinAndMaxFrame(i, i2);
                }
            });
        } else {
            this.dj.j(i / this.cJ.ba(), i2 / this.cJ.ba());
        }
    }

    public void setMinAndMaxProgress(@FloatRange(from = 0.0d, to = 1.0d) float f, @FloatRange(from = 0.0d, to = 1.0d) float f2) {
        this.dj.j(f, f2);
    }

    public void setSpeed(float f) {
        this.dj.setSpeed(f);
    }

    public float getSpeed() {
        return this.dj.getSpeed();
    }

    public void addAnimatorUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.dj.addUpdateListener(animatorUpdateListener);
    }

    public void a(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.dj.removeUpdateListener(animatorUpdateListener);
    }

    public void addAnimatorListener(Animator.AnimatorListener animatorListener) {
        this.dj.addListener(animatorListener);
    }

    public void removeAnimatorListener(Animator.AnimatorListener animatorListener) {
        this.dj.removeListener(animatorListener);
    }

    public void setFrame(final int i) {
        if (this.cJ == null) {
            this.dl.add(new b() { // from class: com.airbnb.lottie.f.7
                @Override // com.airbnb.lottie.f.b
                public void i(e eVar) {
                    f.this.setFrame(i);
                }
            });
        } else {
            setProgress(i / this.cJ.ba());
        }
    }

    public int getFrame() {
        if (this.cJ == null) {
            return 0;
        }
        return (int) (getProgress() * this.cJ.ba());
    }

    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        this.dj.l(f);
        if (this.du != null) {
            this.du.setProgress(f);
        }
    }

    public void loop(boolean z) {
        this.dj.setRepeatCount(z ? -1 : 0);
    }

    public boolean isLooping() {
        return this.dj.getRepeatCount() == -1;
    }

    public boolean isAnimating() {
        return this.dj.isRunning();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bg() {
        this.dj.bg();
    }

    public void setScale(float f) {
        this.scale = f;
        bk();
    }

    public void setImageAssetDelegate(c cVar) {
        this.dp = cVar;
        if (this.f1do != null) {
            this.f1do.a(cVar);
        }
    }

    public void setFontAssetDelegate(com.airbnb.lottie.b bVar) {
        this.dr = bVar;
        if (this.dq != null) {
            this.dq.a(bVar);
        }
    }

    public void setTextDelegate(l lVar) {
        this.ds = lVar;
    }

    @Nullable
    public l bh() {
        return this.ds;
    }

    public boolean bi() {
        return this.ds == null && this.cJ.aX().size() > 0;
    }

    public float getScale() {
        return this.scale;
    }

    public e bj() {
        return this.cJ;
    }

    private void bk() {
        if (this.cJ != null) {
            float scale = getScale();
            setBounds(0, 0, (int) (this.cJ.aS().width() * scale), (int) (scale * this.cJ.aS().height()));
        }
    }

    public void cancelAnimation() {
        this.dl.clear();
        this.dj.cancel();
    }

    public void pauseAnimation() {
        this.dl.clear();
        this.dj.pauseAnimation();
    }

    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    public float getProgress() {
        return this.dj.dq();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        if (this.cJ == null) {
            return -1;
        }
        return (int) (this.cJ.aS().width() * getScale());
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        if (this.cJ == null) {
            return -1;
        }
        return (int) (this.cJ.aS().height() * getScale());
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
        if (this.f1do != null && !this.f1do.P(getContext())) {
            this.f1do.recycleBitmaps();
            this.f1do = null;
        }
        if (this.f1do == null) {
            this.f1do = new com.airbnb.lottie.b.b(getCallback(), this.cQ, this.dp, this.cJ.aZ());
        }
        return this.f1do;
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
        if (this.dq == null) {
            this.dq = new com.airbnb.lottie.b.a(getCallback(), this.dr);
        }
        return this.dq;
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
        return Math.min(canvas.getWidth() / this.cJ.aS().width(), canvas.getHeight() / this.cJ.aS().height());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a {
        final String dA;
        @Nullable
        final String dB;
        @Nullable
        final ColorFilter dC;

        a(@Nullable String str, @Nullable String str2, @Nullable ColorFilter colorFilter) {
            this.dA = str;
            this.dB = str2;
            this.dC = colorFilter;
        }

        public int hashCode() {
            int i = 17;
            if (this.dA != null) {
                i = this.dA.hashCode() * 527;
            }
            if (this.dB != null) {
                return i * 31 * this.dB.hashCode();
            }
            return i;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof a) {
                a aVar = (a) obj;
                return hashCode() == aVar.hashCode() && this.dC == aVar.dC;
            }
            return false;
        }
    }
}
