package com.airbnb.lottie;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Typeface;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.FloatRange;
import android.support.annotation.IntRange;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import com.airbnb.lottie.c.s;
import com.baidu.mapapi.map.WeightedLatLng;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
/* loaded from: classes4.dex */
public class g extends Drawable implements Animatable, Drawable.Callback {
    private static final String TAG = g.class.getSimpleName();
    private e composition;
    @Nullable
    private String dT;
    @Nullable
    private com.airbnb.lottie.b.b eq;
    @Nullable
    private c er;
    @Nullable
    private com.airbnb.lottie.b.a es;
    @Nullable
    b eu;
    @Nullable
    r ev;
    private boolean ew;
    @Nullable
    private com.airbnb.lottie.model.layer.b ey;
    private boolean ez;
    private final Matrix matrix = new Matrix();
    private final com.airbnb.lottie.d.c en = new com.airbnb.lottie.d.c();
    private float scale = 1.0f;
    private final Set<Object> eo = new HashSet();
    private final ArrayList<a> ep = new ArrayList<>();
    private int alpha = 255;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public interface a {
        void c(e eVar);
    }

    public g() {
        this.en.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.airbnb.lottie.g.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (g.this.ey != null) {
                    g.this.ey.setProgress(g.this.en.dE());
                }
            }
        });
    }

    public boolean hasMasks() {
        return this.ey != null && this.ey.hasMasks();
    }

    public boolean hasMatte() {
        return this.ey != null && this.ey.hasMatte();
    }

    public boolean bp() {
        return this.ew;
    }

    public void enableMergePathsForKitKatAndAbove(boolean z) {
        if (this.ew != z) {
            if (Build.VERSION.SDK_INT < 19) {
                Log.w(TAG, "Merge paths are not supported pre-Kit Kat.");
                return;
            }
            this.ew = z;
            if (this.composition != null) {
                bq();
            }
        }
    }

    public boolean isMergePathsEnabledForKitKatAndAbove() {
        return this.ew;
    }

    public void I(@Nullable String str) {
        this.dT = str;
    }

    @Nullable
    public String getImageAssetsFolder() {
        return this.dT;
    }

    public void recycleBitmaps() {
        if (this.eq != null) {
            this.eq.recycleBitmaps();
        }
    }

    public boolean b(e eVar) {
        if (this.composition == eVar) {
            return false;
        }
        clearComposition();
        this.composition = eVar;
        bq();
        this.en.setComposition(eVar);
        setProgress(this.en.getAnimatedFraction());
        setScale(this.scale);
        bt();
        Iterator it = new ArrayList(this.ep).iterator();
        while (it.hasNext()) {
            ((a) it.next()).c(eVar);
            it.remove();
        }
        this.ep.clear();
        eVar.setPerformanceTrackingEnabled(this.ez);
        return true;
    }

    public void setPerformanceTrackingEnabled(boolean z) {
        this.ez = z;
        if (this.composition != null) {
            this.composition.setPerformanceTrackingEnabled(z);
        }
    }

    @Nullable
    public o getPerformanceTracker() {
        if (this.composition != null) {
            return this.composition.getPerformanceTracker();
        }
        return null;
    }

    private void bq() {
        this.ey = new com.airbnb.lottie.model.layer.b(this, s.d(this.composition), this.composition.bj(), this.composition);
    }

    public void clearComposition() {
        recycleBitmaps();
        if (this.en.isRunning()) {
            this.en.cancel();
        }
        this.composition = null;
        this.ey = null;
        this.eq = null;
        this.en.clearComposition();
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

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        float f;
        d.beginSection("Drawable#draw");
        if (this.ey != null) {
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
                float width = this.composition.be().width() / 2.0f;
                float height = this.composition.be().height() / 2.0f;
                float f3 = width * d;
                float f4 = height * d;
                canvas.translate((width * getScale()) - f3, (height * getScale()) - f4);
                canvas.scale(f, f, f3, f4);
            }
            this.matrix.reset();
            this.matrix.preScale(d, d);
            this.ey.a(canvas, this.matrix, this.alpha);
            d.F("Drawable#draw");
            if (f > 1.0f) {
                canvas.restore();
            }
        }
    }

    @Override // android.graphics.drawable.Animatable
    @MainThread
    public void start() {
        playAnimation();
    }

    @Override // android.graphics.drawable.Animatable
    @MainThread
    public void stop() {
        endAnimation();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return isAnimating();
    }

    @MainThread
    public void playAnimation() {
        if (this.ey == null) {
            this.ep.add(new a() { // from class: com.airbnb.lottie.g.6
                @Override // com.airbnb.lottie.g.a
                public void c(e eVar) {
                    g.this.playAnimation();
                }
            });
        } else {
            this.en.playAnimation();
        }
    }

    @MainThread
    public void endAnimation() {
        this.ep.clear();
        this.en.endAnimation();
    }

    @MainThread
    public void resumeAnimation() {
        if (this.ey == null) {
            this.ep.add(new a() { // from class: com.airbnb.lottie.g.7
                @Override // com.airbnb.lottie.g.a
                public void c(e eVar) {
                    g.this.resumeAnimation();
                }
            });
        } else {
            this.en.resumeAnimation();
        }
    }

    public void setMinFrame(final int i) {
        if (this.composition == null) {
            this.ep.add(new a() { // from class: com.airbnb.lottie.g.8
                @Override // com.airbnb.lottie.g.a
                public void c(e eVar) {
                    g.this.setMinFrame(i);
                }
            });
        } else {
            this.en.setMinFrame(i);
        }
    }

    public float getMinFrame() {
        return this.en.getMinFrame();
    }

    public void setMinProgress(final float f) {
        if (this.composition == null) {
            this.ep.add(new a() { // from class: com.airbnb.lottie.g.9
                @Override // com.airbnb.lottie.g.a
                public void c(e eVar) {
                    g.this.setMinProgress(f);
                }
            });
        } else {
            setMinFrame((int) com.airbnb.lottie.d.e.lerp(this.composition.bg(), this.composition.bh(), f));
        }
    }

    public void setMaxFrame(final int i) {
        if (this.composition == null) {
            this.ep.add(new a() { // from class: com.airbnb.lottie.g.10
                @Override // com.airbnb.lottie.g.a
                public void c(e eVar) {
                    g.this.setMaxFrame(i);
                }
            });
        } else {
            this.en.setMaxFrame(i);
        }
    }

    public float getMaxFrame() {
        return this.en.getMaxFrame();
    }

    public void setMaxProgress(@FloatRange(from = 0.0d, to = 1.0d) final float f) {
        if (this.composition == null) {
            this.ep.add(new a() { // from class: com.airbnb.lottie.g.11
                @Override // com.airbnb.lottie.g.a
                public void c(e eVar) {
                    g.this.setMaxProgress(f);
                }
            });
        } else {
            setMaxFrame((int) com.airbnb.lottie.d.e.lerp(this.composition.bg(), this.composition.bh(), f));
        }
    }

    public void setMinAndMaxFrame(final int i, final int i2) {
        if (this.composition == null) {
            this.ep.add(new a() { // from class: com.airbnb.lottie.g.12
                @Override // com.airbnb.lottie.g.a
                public void c(e eVar) {
                    g.this.setMinAndMaxFrame(i, i2);
                }
            });
        } else {
            this.en.e(i, i2);
        }
    }

    public void setMinAndMaxProgress(@FloatRange(from = 0.0d, to = 1.0d) final float f, @FloatRange(from = 0.0d, to = 1.0d) final float f2) {
        if (this.composition == null) {
            this.ep.add(new a() { // from class: com.airbnb.lottie.g.13
                @Override // com.airbnb.lottie.g.a
                public void c(e eVar) {
                    g.this.setMinAndMaxProgress(f, f2);
                }
            });
        } else {
            setMinAndMaxFrame((int) com.airbnb.lottie.d.e.lerp(this.composition.bg(), this.composition.bh(), f), (int) com.airbnb.lottie.d.e.lerp(this.composition.bg(), this.composition.bh(), f2));
        }
    }

    public void reverseAnimationSpeed() {
        this.en.reverseAnimationSpeed();
    }

    public void setSpeed(float f) {
        this.en.setSpeed(f);
    }

    public float getSpeed() {
        return this.en.getSpeed();
    }

    public void addAnimatorUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.en.addUpdateListener(animatorUpdateListener);
    }

    public void a(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.en.removeUpdateListener(animatorUpdateListener);
    }

    public void removeAllUpdateListeners() {
        this.en.removeAllUpdateListeners();
    }

    public void addAnimatorListener(Animator.AnimatorListener animatorListener) {
        this.en.addListener(animatorListener);
    }

    public void removeAnimatorListener(Animator.AnimatorListener animatorListener) {
        this.en.removeListener(animatorListener);
    }

    public void removeAllAnimatorListeners() {
        this.en.removeAllListeners();
    }

    public void setFrame(final int i) {
        if (this.composition == null) {
            this.ep.add(new a() { // from class: com.airbnb.lottie.g.2
                @Override // com.airbnb.lottie.g.a
                public void c(e eVar) {
                    g.this.setFrame(i);
                }
            });
        } else {
            this.en.setFrame(i);
        }
    }

    public int getFrame() {
        return (int) this.en.dF();
    }

    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) final float f) {
        if (this.composition == null) {
            this.ep.add(new a() { // from class: com.airbnb.lottie.g.3
                @Override // com.airbnb.lottie.g.a
                public void c(e eVar) {
                    g.this.setProgress(f);
                }
            });
        } else {
            setFrame((int) com.airbnb.lottie.d.e.lerp(this.composition.bg(), this.composition.bh(), f));
        }
    }

    public void setRepeatMode(int i) {
        this.en.setRepeatMode(i);
    }

    public int getRepeatMode() {
        return this.en.getRepeatMode();
    }

    public void setRepeatCount(int i) {
        this.en.setRepeatCount(i);
    }

    public int getRepeatCount() {
        return this.en.getRepeatCount();
    }

    public boolean isAnimating() {
        return this.en.isRunning();
    }

    public void setScale(float f) {
        this.scale = f;
        bt();
    }

    public void setImageAssetDelegate(c cVar) {
        this.er = cVar;
        if (this.eq != null) {
            this.eq.a(cVar);
        }
    }

    public void setFontAssetDelegate(b bVar) {
        this.eu = bVar;
        if (this.es != null) {
            this.es.a(bVar);
        }
    }

    public void setTextDelegate(r rVar) {
        this.ev = rVar;
    }

    @Nullable
    public r br() {
        return this.ev;
    }

    public boolean bs() {
        return this.ev == null && this.composition.bk().size() > 0;
    }

    public float getScale() {
        return this.scale;
    }

    public e getComposition() {
        return this.composition;
    }

    private void bt() {
        if (this.composition != null) {
            float scale = getScale();
            setBounds(0, 0, (int) (this.composition.be().width() * scale), (int) (scale * this.composition.be().height()));
        }
    }

    public void cancelAnimation() {
        this.ep.clear();
        this.en.cancel();
    }

    public void pauseAnimation() {
        this.ep.clear();
        this.en.pauseAnimation();
    }

    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    public float getProgress() {
        return this.en.dE();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        if (this.composition == null) {
            return -1;
        }
        return (int) (this.composition.be().width() * getScale());
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        if (this.composition == null) {
            return -1;
        }
        return (int) (this.composition.be().height() * getScale());
    }

    public List<com.airbnb.lottie.model.e> resolveKeyPath(com.airbnb.lottie.model.e eVar) {
        if (this.ey == null) {
            Log.w("LOTTIE", "Cannot resolve KeyPath. Composition is not set yet.");
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        this.ey.a(eVar, 0, arrayList, new com.airbnb.lottie.model.e(new String[0]));
        return arrayList;
    }

    public <T> void addValueCallback(final com.airbnb.lottie.model.e eVar, final T t, final com.airbnb.lottie.e.c<T> cVar) {
        boolean z = true;
        if (this.ey == null) {
            this.ep.add(new a() { // from class: com.airbnb.lottie.g.4
                @Override // com.airbnb.lottie.g.a
                public void c(e eVar2) {
                    g.this.addValueCallback(eVar, (com.airbnb.lottie.model.e) t, (com.airbnb.lottie.e.c<com.airbnb.lottie.model.e>) cVar);
                }
            });
            return;
        }
        if (eVar.cj() != null) {
            eVar.cj().a(t, cVar);
        } else {
            List<com.airbnb.lottie.model.e> resolveKeyPath = resolveKeyPath(eVar);
            for (int i = 0; i < resolveKeyPath.size(); i++) {
                resolveKeyPath.get(i).cj().a(t, cVar);
            }
            z = resolveKeyPath.isEmpty() ? false : true;
        }
        if (z) {
            invalidateSelf();
            if (t == k.fj) {
                setProgress(getProgress());
            }
        }
    }

    public <T> void addValueCallback(com.airbnb.lottie.model.e eVar, T t, final com.airbnb.lottie.e.e<T> eVar2) {
        addValueCallback(eVar, (com.airbnb.lottie.model.e) t, (com.airbnb.lottie.e.c<com.airbnb.lottie.model.e>) new com.airbnb.lottie.e.c<T>() { // from class: com.airbnb.lottie.g.5
            /* JADX WARN: Type inference failed for: r0v1, types: [T, java.lang.Object] */
            @Override // com.airbnb.lottie.e.c
            public T getValue(com.airbnb.lottie.e.b<T> bVar) {
                return eVar2.getValue(bVar);
            }
        });
    }

    @Nullable
    public Bitmap updateBitmap(String str, @Nullable Bitmap bitmap) {
        com.airbnb.lottie.b.b bu = bu();
        if (bu == null) {
            Log.w("LOTTIE", "Cannot update bitmap. Most likely the drawable is not added to a View which prevents Lottie from getting a Context.");
            return null;
        }
        Bitmap updateBitmap = bu.updateBitmap(str, bitmap);
        invalidateSelf();
        return updateBitmap;
    }

    @Nullable
    public Bitmap J(String str) {
        com.airbnb.lottie.b.b bu = bu();
        if (bu != null) {
            return bu.N(str);
        }
        return null;
    }

    private com.airbnb.lottie.b.b bu() {
        if (getCallback() == null) {
            return null;
        }
        if (this.eq != null && !this.eq.Q(getContext())) {
            this.eq.recycleBitmaps();
            this.eq = null;
        }
        if (this.eq == null) {
            this.eq = new com.airbnb.lottie.b.b(getCallback(), this.dT, this.er, this.composition.bm());
        }
        return this.eq;
    }

    @Nullable
    public Typeface g(String str, String str2) {
        com.airbnb.lottie.b.a bv = bv();
        if (bv != null) {
            return bv.g(str, str2);
        }
        return null;
    }

    private com.airbnb.lottie.b.a bv() {
        if (getCallback() == null) {
            return null;
        }
        if (this.es == null) {
            this.es = new com.airbnb.lottie.b.a(getCallback(), this.eu);
        }
        return this.es;
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
        return Math.min(canvas.getWidth() / this.composition.be().width(), canvas.getHeight() / this.composition.be().height());
    }
}
