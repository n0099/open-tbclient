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
    @Nullable
    private com.airbnb.lottie.b.b AC;
    @Nullable
    private c AD;
    @Nullable
    private com.airbnb.lottie.b.a AE;
    @Nullable
    b AF;
    @Nullable
    r AG;
    private boolean AH;
    @Nullable
    private com.airbnb.lottie.model.layer.b AI;
    private boolean AJ;
    @Nullable
    private String Af;
    private e composition;
    private final Matrix matrix = new Matrix();
    private final com.airbnb.lottie.d.c Az = new com.airbnb.lottie.d.c();
    private float scale = 1.0f;
    private final Set<Object> AA = new HashSet();
    private final ArrayList<a> AB = new ArrayList<>();
    private int alpha = 255;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public interface a {
        void b(e eVar);
    }

    public g() {
        this.Az.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.airbnb.lottie.g.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (g.this.AI != null) {
                    g.this.AI.setProgress(g.this.Az.ju());
                }
            }
        });
    }

    public boolean hasMasks() {
        return this.AI != null && this.AI.hasMasks();
    }

    public boolean hasMatte() {
        return this.AI != null && this.AI.hasMatte();
    }

    public boolean hd() {
        return this.AH;
    }

    public void enableMergePathsForKitKatAndAbove(boolean z) {
        if (this.AH != z) {
            if (Build.VERSION.SDK_INT < 19) {
                Log.w(TAG, "Merge paths are not supported pre-Kit Kat.");
                return;
            }
            this.AH = z;
            if (this.composition != null) {
                he();
            }
        }
    }

    public boolean isMergePathsEnabledForKitKatAndAbove() {
        return this.AH;
    }

    public void aZ(@Nullable String str) {
        this.Af = str;
    }

    @Nullable
    public String getImageAssetsFolder() {
        return this.Af;
    }

    public void recycleBitmaps() {
        if (this.AC != null) {
            this.AC.recycleBitmaps();
        }
    }

    public boolean a(e eVar) {
        if (this.composition == eVar) {
            return false;
        }
        clearComposition();
        this.composition = eVar;
        he();
        this.Az.setComposition(eVar);
        setProgress(this.Az.getAnimatedFraction());
        setScale(this.scale);
        hh();
        Iterator it = new ArrayList(this.AB).iterator();
        while (it.hasNext()) {
            ((a) it.next()).b(eVar);
            it.remove();
        }
        this.AB.clear();
        eVar.setPerformanceTrackingEnabled(this.AJ);
        return true;
    }

    public void setPerformanceTrackingEnabled(boolean z) {
        this.AJ = z;
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

    private void he() {
        this.AI = new com.airbnb.lottie.model.layer.b(this, s.c(this.composition), this.composition.gX(), this.composition);
    }

    public void clearComposition() {
        recycleBitmaps();
        if (this.Az.isRunning()) {
            this.Az.cancel();
        }
        this.composition = null;
        this.AI = null;
        this.AC = null;
        this.Az.clearComposition();
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
        if (this.AI != null) {
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
                float width = this.composition.gS().width() / 2.0f;
                float height = this.composition.gS().height() / 2.0f;
                float f4 = width * f2;
                float f5 = height * f2;
                canvas.translate((width * getScale()) - f4, (height * getScale()) - f5);
                canvas.scale(f, f, f4, f5);
            }
            this.matrix.reset();
            this.matrix.preScale(f2, f2);
            this.AI.a(canvas, this.matrix, this.alpha);
            d.aW("Drawable#draw");
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
        if (this.AI == null) {
            this.AB.add(new a() { // from class: com.airbnb.lottie.g.6
                @Override // com.airbnb.lottie.g.a
                public void b(e eVar) {
                    g.this.playAnimation();
                }
            });
        } else {
            this.Az.playAnimation();
        }
    }

    @MainThread
    public void endAnimation() {
        this.AB.clear();
        this.Az.endAnimation();
    }

    @MainThread
    public void resumeAnimation() {
        if (this.AI == null) {
            this.AB.add(new a() { // from class: com.airbnb.lottie.g.7
                @Override // com.airbnb.lottie.g.a
                public void b(e eVar) {
                    g.this.resumeAnimation();
                }
            });
        } else {
            this.Az.resumeAnimation();
        }
    }

    public void setMinFrame(final int i) {
        if (this.composition == null) {
            this.AB.add(new a() { // from class: com.airbnb.lottie.g.8
                @Override // com.airbnb.lottie.g.a
                public void b(e eVar) {
                    g.this.setMinFrame(i);
                }
            });
        } else {
            this.Az.setMinFrame(i);
        }
    }

    public float getMinFrame() {
        return this.Az.getMinFrame();
    }

    public void setMinProgress(final float f) {
        if (this.composition == null) {
            this.AB.add(new a() { // from class: com.airbnb.lottie.g.9
                @Override // com.airbnb.lottie.g.a
                public void b(e eVar) {
                    g.this.setMinProgress(f);
                }
            });
        } else {
            setMinFrame((int) com.airbnb.lottie.d.e.lerp(this.composition.gU(), this.composition.gV(), f));
        }
    }

    public void setMaxFrame(final int i) {
        if (this.composition == null) {
            this.AB.add(new a() { // from class: com.airbnb.lottie.g.10
                @Override // com.airbnb.lottie.g.a
                public void b(e eVar) {
                    g.this.setMaxFrame(i);
                }
            });
        } else {
            this.Az.setMaxFrame(i);
        }
    }

    public float getMaxFrame() {
        return this.Az.getMaxFrame();
    }

    public void setMaxProgress(@FloatRange(from = 0.0d, to = 1.0d) final float f) {
        if (this.composition == null) {
            this.AB.add(new a() { // from class: com.airbnb.lottie.g.11
                @Override // com.airbnb.lottie.g.a
                public void b(e eVar) {
                    g.this.setMaxProgress(f);
                }
            });
        } else {
            setMaxFrame((int) com.airbnb.lottie.d.e.lerp(this.composition.gU(), this.composition.gV(), f));
        }
    }

    public void setMinAndMaxFrame(final int i, final int i2) {
        if (this.composition == null) {
            this.AB.add(new a() { // from class: com.airbnb.lottie.g.12
                @Override // com.airbnb.lottie.g.a
                public void b(e eVar) {
                    g.this.setMinAndMaxFrame(i, i2);
                }
            });
        } else {
            this.Az.i(i, i2);
        }
    }

    public void setMinAndMaxProgress(@FloatRange(from = 0.0d, to = 1.0d) final float f, @FloatRange(from = 0.0d, to = 1.0d) final float f2) {
        if (this.composition == null) {
            this.AB.add(new a() { // from class: com.airbnb.lottie.g.13
                @Override // com.airbnb.lottie.g.a
                public void b(e eVar) {
                    g.this.setMinAndMaxProgress(f, f2);
                }
            });
        } else {
            setMinAndMaxFrame((int) com.airbnb.lottie.d.e.lerp(this.composition.gU(), this.composition.gV(), f), (int) com.airbnb.lottie.d.e.lerp(this.composition.gU(), this.composition.gV(), f2));
        }
    }

    public void reverseAnimationSpeed() {
        this.Az.reverseAnimationSpeed();
    }

    public void setSpeed(float f) {
        this.Az.setSpeed(f);
    }

    public float getSpeed() {
        return this.Az.getSpeed();
    }

    public void addAnimatorUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.Az.addUpdateListener(animatorUpdateListener);
    }

    public void a(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.Az.removeUpdateListener(animatorUpdateListener);
    }

    public void removeAllUpdateListeners() {
        this.Az.removeAllUpdateListeners();
    }

    public void addAnimatorListener(Animator.AnimatorListener animatorListener) {
        this.Az.addListener(animatorListener);
    }

    public void removeAnimatorListener(Animator.AnimatorListener animatorListener) {
        this.Az.removeListener(animatorListener);
    }

    public void removeAllAnimatorListeners() {
        this.Az.removeAllListeners();
    }

    public void setFrame(final int i) {
        if (this.composition == null) {
            this.AB.add(new a() { // from class: com.airbnb.lottie.g.2
                @Override // com.airbnb.lottie.g.a
                public void b(e eVar) {
                    g.this.setFrame(i);
                }
            });
        } else {
            this.Az.setFrame(i);
        }
    }

    public int getFrame() {
        return (int) this.Az.jv();
    }

    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) final float f) {
        if (this.composition == null) {
            this.AB.add(new a() { // from class: com.airbnb.lottie.g.3
                @Override // com.airbnb.lottie.g.a
                public void b(e eVar) {
                    g.this.setProgress(f);
                }
            });
        } else {
            setFrame((int) com.airbnb.lottie.d.e.lerp(this.composition.gU(), this.composition.gV(), f));
        }
    }

    public void setRepeatMode(int i) {
        this.Az.setRepeatMode(i);
    }

    public int getRepeatMode() {
        return this.Az.getRepeatMode();
    }

    public void setRepeatCount(int i) {
        this.Az.setRepeatCount(i);
    }

    public int getRepeatCount() {
        return this.Az.getRepeatCount();
    }

    public boolean isAnimating() {
        return this.Az.isRunning();
    }

    public void setScale(float f) {
        this.scale = f;
        hh();
    }

    public void setImageAssetDelegate(c cVar) {
        this.AD = cVar;
        if (this.AC != null) {
            this.AC.a(cVar);
        }
    }

    public void setFontAssetDelegate(b bVar) {
        this.AF = bVar;
        if (this.AE != null) {
            this.AE.a(bVar);
        }
    }

    public void setTextDelegate(r rVar) {
        this.AG = rVar;
    }

    @Nullable
    public r hf() {
        return this.AG;
    }

    public boolean hg() {
        return this.AG == null && this.composition.gY().size() > 0;
    }

    public float getScale() {
        return this.scale;
    }

    public e getComposition() {
        return this.composition;
    }

    private void hh() {
        if (this.composition != null) {
            float scale = getScale();
            setBounds(0, 0, (int) (this.composition.gS().width() * scale), (int) (scale * this.composition.gS().height()));
        }
    }

    public void cancelAnimation() {
        this.AB.clear();
        this.Az.cancel();
    }

    public void pauseAnimation() {
        this.AB.clear();
        this.Az.pauseAnimation();
    }

    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    public float getProgress() {
        return this.Az.ju();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        if (this.composition == null) {
            return -1;
        }
        return (int) (this.composition.gS().width() * getScale());
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        if (this.composition == null) {
            return -1;
        }
        return (int) (this.composition.gS().height() * getScale());
    }

    public List<com.airbnb.lottie.model.e> resolveKeyPath(com.airbnb.lottie.model.e eVar) {
        if (this.AI == null) {
            Log.w("LOTTIE", "Cannot resolve KeyPath. Composition is not set yet.");
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        this.AI.a(eVar, 0, arrayList, new com.airbnb.lottie.model.e(new String[0]));
        return arrayList;
    }

    public <T> void addValueCallback(final com.airbnb.lottie.model.e eVar, final T t, final com.airbnb.lottie.e.c<T> cVar) {
        boolean z = true;
        if (this.AI == null) {
            this.AB.add(new a() { // from class: com.airbnb.lottie.g.4
                @Override // com.airbnb.lottie.g.a
                public void b(e eVar2) {
                    g.this.addValueCallback(eVar, (com.airbnb.lottie.model.e) t, (com.airbnb.lottie.e.c<com.airbnb.lottie.model.e>) cVar);
                }
            });
            return;
        }
        if (eVar.hX() != null) {
            eVar.hX().a(t, cVar);
        } else {
            List<com.airbnb.lottie.model.e> resolveKeyPath = resolveKeyPath(eVar);
            for (int i = 0; i < resolveKeyPath.size(); i++) {
                resolveKeyPath.get(i).hX().a(t, cVar);
            }
            z = resolveKeyPath.isEmpty() ? false : true;
        }
        if (z) {
            invalidateSelf();
            if (t == k.Bu) {
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
        com.airbnb.lottie.b.b hi = hi();
        if (hi == null) {
            Log.w("LOTTIE", "Cannot update bitmap. Most likely the drawable is not added to a View which prevents Lottie from getting a Context.");
            return null;
        }
        Bitmap updateBitmap = hi.updateBitmap(str, bitmap);
        invalidateSelf();
        return updateBitmap;
    }

    @Nullable
    public Bitmap ba(String str) {
        com.airbnb.lottie.b.b hi = hi();
        if (hi != null) {
            return hi.be(str);
        }
        return null;
    }

    private com.airbnb.lottie.b.b hi() {
        if (getCallback() == null) {
            return null;
        }
        if (this.AC != null && !this.AC.D(getContext())) {
            this.AC.recycleBitmaps();
            this.AC = null;
        }
        if (this.AC == null) {
            this.AC = new com.airbnb.lottie.b.b(getCallback(), this.Af, this.AD, this.composition.ha());
        }
        return this.AC;
    }

    @Nullable
    public Typeface n(String str, String str2) {
        com.airbnb.lottie.b.a hj = hj();
        if (hj != null) {
            return hj.n(str, str2);
        }
        return null;
    }

    private com.airbnb.lottie.b.a hj() {
        if (getCallback() == null) {
            return null;
        }
        if (this.AE == null) {
            this.AE = new com.airbnb.lottie.b.a(getCallback(), this.AF);
        }
        return this.AE;
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
        return Math.min(canvas.getWidth() / this.composition.gS().width(), canvas.getHeight() / this.composition.gS().height());
    }
}
