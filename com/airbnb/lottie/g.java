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
/* loaded from: classes5.dex */
public class g extends Drawable implements Animatable, Drawable.Callback {
    private static final String TAG = g.class.getSimpleName();
    private e composition;
    @Nullable
    private String dS;
    @Nullable
    private com.airbnb.lottie.b.b ep;
    @Nullable
    private c eq;
    @Nullable
    private com.airbnb.lottie.b.a er;
    @Nullable
    b es;
    @Nullable
    r eu;
    private boolean ev;
    @Nullable
    private com.airbnb.lottie.model.layer.b ew;
    private boolean ey;
    private final Matrix matrix = new Matrix();
    private final com.airbnb.lottie.d.c el = new com.airbnb.lottie.d.c();
    private float scale = 1.0f;
    private final Set<Object> en = new HashSet();
    private final ArrayList<a> eo = new ArrayList<>();
    private int alpha = 255;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public interface a {
        void c(e eVar);
    }

    public g() {
        this.el.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.airbnb.lottie.g.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (g.this.ew != null) {
                    g.this.ew.setProgress(g.this.el.dE());
                }
            }
        });
    }

    public boolean hasMasks() {
        return this.ew != null && this.ew.hasMasks();
    }

    public boolean hasMatte() {
        return this.ew != null && this.ew.hasMatte();
    }

    public boolean bp() {
        return this.ev;
    }

    public void enableMergePathsForKitKatAndAbove(boolean z) {
        if (this.ev != z) {
            if (Build.VERSION.SDK_INT < 19) {
                Log.w(TAG, "Merge paths are not supported pre-Kit Kat.");
                return;
            }
            this.ev = z;
            if (this.composition != null) {
                bq();
            }
        }
    }

    public boolean isMergePathsEnabledForKitKatAndAbove() {
        return this.ev;
    }

    public void I(@Nullable String str) {
        this.dS = str;
    }

    @Nullable
    public String getImageAssetsFolder() {
        return this.dS;
    }

    public void recycleBitmaps() {
        if (this.ep != null) {
            this.ep.recycleBitmaps();
        }
    }

    public boolean b(e eVar) {
        if (this.composition == eVar) {
            return false;
        }
        clearComposition();
        this.composition = eVar;
        bq();
        this.el.setComposition(eVar);
        setProgress(this.el.getAnimatedFraction());
        setScale(this.scale);
        bt();
        Iterator it = new ArrayList(this.eo).iterator();
        while (it.hasNext()) {
            ((a) it.next()).c(eVar);
            it.remove();
        }
        this.eo.clear();
        eVar.setPerformanceTrackingEnabled(this.ey);
        return true;
    }

    public void setPerformanceTrackingEnabled(boolean z) {
        this.ey = z;
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
        this.ew = new com.airbnb.lottie.model.layer.b(this, s.d(this.composition), this.composition.bj(), this.composition);
    }

    public void clearComposition() {
        recycleBitmaps();
        if (this.el.isRunning()) {
            this.el.cancel();
        }
        this.composition = null;
        this.ew = null;
        this.ep = null;
        this.el.clearComposition();
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
        if (this.ew != null) {
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
            this.ew.a(canvas, this.matrix, this.alpha);
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
        if (this.ew == null) {
            this.eo.add(new a() { // from class: com.airbnb.lottie.g.6
                @Override // com.airbnb.lottie.g.a
                public void c(e eVar) {
                    g.this.playAnimation();
                }
            });
        } else {
            this.el.playAnimation();
        }
    }

    @MainThread
    public void endAnimation() {
        this.eo.clear();
        this.el.endAnimation();
    }

    @MainThread
    public void resumeAnimation() {
        if (this.ew == null) {
            this.eo.add(new a() { // from class: com.airbnb.lottie.g.7
                @Override // com.airbnb.lottie.g.a
                public void c(e eVar) {
                    g.this.resumeAnimation();
                }
            });
        } else {
            this.el.resumeAnimation();
        }
    }

    public void setMinFrame(final int i) {
        if (this.composition == null) {
            this.eo.add(new a() { // from class: com.airbnb.lottie.g.8
                @Override // com.airbnb.lottie.g.a
                public void c(e eVar) {
                    g.this.setMinFrame(i);
                }
            });
        } else {
            this.el.setMinFrame(i);
        }
    }

    public float getMinFrame() {
        return this.el.getMinFrame();
    }

    public void setMinProgress(final float f) {
        if (this.composition == null) {
            this.eo.add(new a() { // from class: com.airbnb.lottie.g.9
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
            this.eo.add(new a() { // from class: com.airbnb.lottie.g.10
                @Override // com.airbnb.lottie.g.a
                public void c(e eVar) {
                    g.this.setMaxFrame(i);
                }
            });
        } else {
            this.el.setMaxFrame(i);
        }
    }

    public float getMaxFrame() {
        return this.el.getMaxFrame();
    }

    public void setMaxProgress(@FloatRange(from = 0.0d, to = 1.0d) final float f) {
        if (this.composition == null) {
            this.eo.add(new a() { // from class: com.airbnb.lottie.g.11
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
            this.eo.add(new a() { // from class: com.airbnb.lottie.g.12
                @Override // com.airbnb.lottie.g.a
                public void c(e eVar) {
                    g.this.setMinAndMaxFrame(i, i2);
                }
            });
        } else {
            this.el.e(i, i2);
        }
    }

    public void setMinAndMaxProgress(@FloatRange(from = 0.0d, to = 1.0d) final float f, @FloatRange(from = 0.0d, to = 1.0d) final float f2) {
        if (this.composition == null) {
            this.eo.add(new a() { // from class: com.airbnb.lottie.g.13
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
        this.el.reverseAnimationSpeed();
    }

    public void setSpeed(float f) {
        this.el.setSpeed(f);
    }

    public float getSpeed() {
        return this.el.getSpeed();
    }

    public void addAnimatorUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.el.addUpdateListener(animatorUpdateListener);
    }

    public void a(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.el.removeUpdateListener(animatorUpdateListener);
    }

    public void removeAllUpdateListeners() {
        this.el.removeAllUpdateListeners();
    }

    public void addAnimatorListener(Animator.AnimatorListener animatorListener) {
        this.el.addListener(animatorListener);
    }

    public void removeAnimatorListener(Animator.AnimatorListener animatorListener) {
        this.el.removeListener(animatorListener);
    }

    public void removeAllAnimatorListeners() {
        this.el.removeAllListeners();
    }

    public void setFrame(final int i) {
        if (this.composition == null) {
            this.eo.add(new a() { // from class: com.airbnb.lottie.g.2
                @Override // com.airbnb.lottie.g.a
                public void c(e eVar) {
                    g.this.setFrame(i);
                }
            });
        } else {
            this.el.setFrame(i);
        }
    }

    public int getFrame() {
        return (int) this.el.dF();
    }

    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) final float f) {
        if (this.composition == null) {
            this.eo.add(new a() { // from class: com.airbnb.lottie.g.3
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
        this.el.setRepeatMode(i);
    }

    public int getRepeatMode() {
        return this.el.getRepeatMode();
    }

    public void setRepeatCount(int i) {
        this.el.setRepeatCount(i);
    }

    public int getRepeatCount() {
        return this.el.getRepeatCount();
    }

    public boolean isAnimating() {
        return this.el.isRunning();
    }

    public void setScale(float f) {
        this.scale = f;
        bt();
    }

    public void setImageAssetDelegate(c cVar) {
        this.eq = cVar;
        if (this.ep != null) {
            this.ep.a(cVar);
        }
    }

    public void setFontAssetDelegate(b bVar) {
        this.es = bVar;
        if (this.er != null) {
            this.er.a(bVar);
        }
    }

    public void setTextDelegate(r rVar) {
        this.eu = rVar;
    }

    @Nullable
    public r br() {
        return this.eu;
    }

    public boolean bs() {
        return this.eu == null && this.composition.bk().size() > 0;
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
        this.eo.clear();
        this.el.cancel();
    }

    public void pauseAnimation() {
        this.eo.clear();
        this.el.pauseAnimation();
    }

    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    public float getProgress() {
        return this.el.dE();
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
        if (this.ew == null) {
            Log.w("LOTTIE", "Cannot resolve KeyPath. Composition is not set yet.");
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        this.ew.a(eVar, 0, arrayList, new com.airbnb.lottie.model.e(new String[0]));
        return arrayList;
    }

    public <T> void addValueCallback(final com.airbnb.lottie.model.e eVar, final T t, final com.airbnb.lottie.e.c<T> cVar) {
        boolean z = true;
        if (this.ew == null) {
            this.eo.add(new a() { // from class: com.airbnb.lottie.g.4
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
            if (t == k.fi) {
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
        if (this.ep != null && !this.ep.Q(getContext())) {
            this.ep.recycleBitmaps();
            this.ep = null;
        }
        if (this.ep == null) {
            this.ep = new com.airbnb.lottie.b.b(getCallback(), this.dS, this.eq, this.composition.bm());
        }
        return this.ep;
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
        if (this.er == null) {
            this.er = new com.airbnb.lottie.b.a(getCallback(), this.es);
        }
        return this.er;
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
