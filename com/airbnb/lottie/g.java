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
/* loaded from: classes6.dex */
public class g extends Drawable implements Animatable, Drawable.Callback {
    private static final String TAG = g.class.getSimpleName();
    private e composition;
    @Nullable
    private String dS;
    private boolean eA;
    @Nullable
    private com.airbnb.lottie.b.b er;
    @Nullable
    private c es;
    @Nullable
    private com.airbnb.lottie.b.a eu;
    @Nullable
    b ev;
    @Nullable
    r ew;
    private boolean ey;
    @Nullable
    private com.airbnb.lottie.model.layer.b ez;
    private final Matrix matrix = new Matrix();
    private final com.airbnb.lottie.d.c en = new com.airbnb.lottie.d.c();
    private float scale = 1.0f;
    private final Set<Object> eo = new HashSet();
    private final ArrayList<a> ep = new ArrayList<>();
    private int alpha = 255;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public interface a {
        void b(e eVar);
    }

    public g() {
        this.en.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.airbnb.lottie.g.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (g.this.ez != null) {
                    g.this.ez.setProgress(g.this.en.dF());
                }
            }
        });
    }

    public boolean hasMasks() {
        return this.ez != null && this.ez.hasMasks();
    }

    public boolean hasMatte() {
        return this.ez != null && this.ez.hasMatte();
    }

    public boolean bq() {
        return this.ey;
    }

    public void enableMergePathsForKitKatAndAbove(boolean z) {
        if (this.ey != z) {
            if (Build.VERSION.SDK_INT < 19) {
                Log.w(TAG, "Merge paths are not supported pre-Kit Kat.");
                return;
            }
            this.ey = z;
            if (this.composition != null) {
                br();
            }
        }
    }

    public boolean isMergePathsEnabledForKitKatAndAbove() {
        return this.ey;
    }

    public void I(@Nullable String str) {
        this.dS = str;
    }

    @Nullable
    public String getImageAssetsFolder() {
        return this.dS;
    }

    public void recycleBitmaps() {
        if (this.er != null) {
            this.er.recycleBitmaps();
        }
    }

    public boolean a(e eVar) {
        if (this.composition == eVar) {
            return false;
        }
        clearComposition();
        this.composition = eVar;
        br();
        this.en.setComposition(eVar);
        setProgress(this.en.getAnimatedFraction());
        setScale(this.scale);
        bu();
        Iterator it = new ArrayList(this.ep).iterator();
        while (it.hasNext()) {
            ((a) it.next()).b(eVar);
            it.remove();
        }
        this.ep.clear();
        eVar.setPerformanceTrackingEnabled(this.eA);
        return true;
    }

    public void setPerformanceTrackingEnabled(boolean z) {
        this.eA = z;
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

    private void br() {
        this.ez = new com.airbnb.lottie.model.layer.b(this, s.c(this.composition), this.composition.bk(), this.composition);
    }

    public void clearComposition() {
        recycleBitmaps();
        if (this.en.isRunning()) {
            this.en.cancel();
        }
        this.composition = null;
        this.ez = null;
        this.er = null;
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
        float f2;
        d.beginSection("Drawable#draw");
        if (this.ez != null) {
            float f3 = this.scale;
            float d = d(canvas);
            if (f3 > d) {
                f2 = d;
                f = this.scale / d;
            } else {
                f = 1.0f;
                f2 = f3;
            }
            int i = -1;
            if (f > 1.0f) {
                i = canvas.save();
                float width = this.composition.bf().width() / 2.0f;
                float height = this.composition.bf().height() / 2.0f;
                float f4 = width * f2;
                float f5 = height * f2;
                canvas.translate((width * getScale()) - f4, (height * getScale()) - f5);
                canvas.scale(f, f, f4, f5);
            }
            this.matrix.reset();
            this.matrix.preScale(f2, f2);
            this.ez.a(canvas, this.matrix, this.alpha);
            d.F("Drawable#draw");
            if (i > 0) {
                canvas.restoreToCount(i);
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
        if (this.ez == null) {
            this.ep.add(new a() { // from class: com.airbnb.lottie.g.6
                @Override // com.airbnb.lottie.g.a
                public void b(e eVar) {
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
        if (this.ez == null) {
            this.ep.add(new a() { // from class: com.airbnb.lottie.g.7
                @Override // com.airbnb.lottie.g.a
                public void b(e eVar) {
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
                public void b(e eVar) {
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
                public void b(e eVar) {
                    g.this.setMinProgress(f);
                }
            });
        } else {
            setMinFrame((int) com.airbnb.lottie.d.e.lerp(this.composition.bh(), this.composition.bi(), f));
        }
    }

    public void setMaxFrame(final int i) {
        if (this.composition == null) {
            this.ep.add(new a() { // from class: com.airbnb.lottie.g.10
                @Override // com.airbnb.lottie.g.a
                public void b(e eVar) {
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
                public void b(e eVar) {
                    g.this.setMaxProgress(f);
                }
            });
        } else {
            setMaxFrame((int) com.airbnb.lottie.d.e.lerp(this.composition.bh(), this.composition.bi(), f));
        }
    }

    public void setMinAndMaxFrame(final int i, final int i2) {
        if (this.composition == null) {
            this.ep.add(new a() { // from class: com.airbnb.lottie.g.12
                @Override // com.airbnb.lottie.g.a
                public void b(e eVar) {
                    g.this.setMinAndMaxFrame(i, i2);
                }
            });
        } else {
            this.en.f(i, i2);
        }
    }

    public void setMinAndMaxProgress(@FloatRange(from = 0.0d, to = 1.0d) final float f, @FloatRange(from = 0.0d, to = 1.0d) final float f2) {
        if (this.composition == null) {
            this.ep.add(new a() { // from class: com.airbnb.lottie.g.13
                @Override // com.airbnb.lottie.g.a
                public void b(e eVar) {
                    g.this.setMinAndMaxProgress(f, f2);
                }
            });
        } else {
            setMinAndMaxFrame((int) com.airbnb.lottie.d.e.lerp(this.composition.bh(), this.composition.bi(), f), (int) com.airbnb.lottie.d.e.lerp(this.composition.bh(), this.composition.bi(), f2));
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
                public void b(e eVar) {
                    g.this.setFrame(i);
                }
            });
        } else {
            this.en.setFrame(i);
        }
    }

    public int getFrame() {
        return (int) this.en.dG();
    }

    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) final float f) {
        if (this.composition == null) {
            this.ep.add(new a() { // from class: com.airbnb.lottie.g.3
                @Override // com.airbnb.lottie.g.a
                public void b(e eVar) {
                    g.this.setProgress(f);
                }
            });
        } else {
            setFrame((int) com.airbnb.lottie.d.e.lerp(this.composition.bh(), this.composition.bi(), f));
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
        bu();
    }

    public void setImageAssetDelegate(c cVar) {
        this.es = cVar;
        if (this.er != null) {
            this.er.a(cVar);
        }
    }

    public void setFontAssetDelegate(b bVar) {
        this.ev = bVar;
        if (this.eu != null) {
            this.eu.a(bVar);
        }
    }

    public void setTextDelegate(r rVar) {
        this.ew = rVar;
    }

    @Nullable
    public r bs() {
        return this.ew;
    }

    public boolean bt() {
        return this.ew == null && this.composition.bl().size() > 0;
    }

    public float getScale() {
        return this.scale;
    }

    public e getComposition() {
        return this.composition;
    }

    private void bu() {
        if (this.composition != null) {
            float scale = getScale();
            setBounds(0, 0, (int) (this.composition.bf().width() * scale), (int) (scale * this.composition.bf().height()));
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
        return this.en.dF();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        if (this.composition == null) {
            return -1;
        }
        return (int) (this.composition.bf().width() * getScale());
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        if (this.composition == null) {
            return -1;
        }
        return (int) (this.composition.bf().height() * getScale());
    }

    public List<com.airbnb.lottie.model.e> resolveKeyPath(com.airbnb.lottie.model.e eVar) {
        if (this.ez == null) {
            Log.w("LOTTIE", "Cannot resolve KeyPath. Composition is not set yet.");
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        this.ez.a(eVar, 0, arrayList, new com.airbnb.lottie.model.e(new String[0]));
        return arrayList;
    }

    public <T> void addValueCallback(final com.airbnb.lottie.model.e eVar, final T t, final com.airbnb.lottie.e.c<T> cVar) {
        boolean z = true;
        if (this.ez == null) {
            this.ep.add(new a() { // from class: com.airbnb.lottie.g.4
                @Override // com.airbnb.lottie.g.a
                public void b(e eVar2) {
                    g.this.addValueCallback(eVar, (com.airbnb.lottie.model.e) t, (com.airbnb.lottie.e.c<com.airbnb.lottie.model.e>) cVar);
                }
            });
            return;
        }
        if (eVar.ck() != null) {
            eVar.ck().a(t, cVar);
        } else {
            List<com.airbnb.lottie.model.e> resolveKeyPath = resolveKeyPath(eVar);
            for (int i = 0; i < resolveKeyPath.size(); i++) {
                resolveKeyPath.get(i).ck().a(t, cVar);
            }
            z = resolveKeyPath.isEmpty() ? false : true;
        }
        if (z) {
            invalidateSelf();
            if (t == k.fn) {
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
        com.airbnb.lottie.b.b bv = bv();
        if (bv == null) {
            Log.w("LOTTIE", "Cannot update bitmap. Most likely the drawable is not added to a View which prevents Lottie from getting a Context.");
            return null;
        }
        Bitmap updateBitmap = bv.updateBitmap(str, bitmap);
        invalidateSelf();
        return updateBitmap;
    }

    @Nullable
    public Bitmap J(String str) {
        com.airbnb.lottie.b.b bv = bv();
        if (bv != null) {
            return bv.N(str);
        }
        return null;
    }

    private com.airbnb.lottie.b.b bv() {
        if (getCallback() == null) {
            return null;
        }
        if (this.er != null && !this.er.Q(getContext())) {
            this.er.recycleBitmaps();
            this.er = null;
        }
        if (this.er == null) {
            this.er = new com.airbnb.lottie.b.b(getCallback(), this.dS, this.es, this.composition.bn());
        }
        return this.er;
    }

    @Nullable
    public Typeface j(String str, String str2) {
        com.airbnb.lottie.b.a bw = bw();
        if (bw != null) {
            return bw.j(str, str2);
        }
        return null;
    }

    private com.airbnb.lottie.b.a bw() {
        if (getCallback() == null) {
            return null;
        }
        if (this.eu == null) {
            this.eu = new com.airbnb.lottie.b.a(getCallback(), this.ev);
        }
        return this.eu;
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
        return Math.min(canvas.getWidth() / this.composition.bf().width(), canvas.getHeight() / this.composition.bf().height());
    }
}
