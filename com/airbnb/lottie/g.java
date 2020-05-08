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
    private com.airbnb.lottie.b.b Ab;
    @Nullable
    private c Ac;
    @Nullable
    private com.airbnb.lottie.b.a Ae;
    @Nullable
    b Af;
    @Nullable
    r Ag;
    private boolean Ah;
    @Nullable
    private com.airbnb.lottie.model.layer.b Ai;
    private boolean Aj;
    private e composition;
    @Nullable
    private String zE;
    private final Matrix matrix = new Matrix();
    private final com.airbnb.lottie.d.c zY = new com.airbnb.lottie.d.c();
    private float scale = 1.0f;
    private final Set<Object> zZ = new HashSet();
    private final ArrayList<a> Aa = new ArrayList<>();
    private int alpha = 255;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public interface a {
        void b(e eVar);
    }

    public g() {
        this.zY.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.airbnb.lottie.g.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (g.this.Ai != null) {
                    g.this.Ai.setProgress(g.this.zY.je());
                }
            }
        });
    }

    public boolean hasMasks() {
        return this.Ai != null && this.Ai.hasMasks();
    }

    public boolean hasMatte() {
        return this.Ai != null && this.Ai.hasMatte();
    }

    public boolean gN() {
        return this.Ah;
    }

    public void enableMergePathsForKitKatAndAbove(boolean z) {
        if (this.Ah != z) {
            if (Build.VERSION.SDK_INT < 19) {
                Log.w(TAG, "Merge paths are not supported pre-Kit Kat.");
                return;
            }
            this.Ah = z;
            if (this.composition != null) {
                gO();
            }
        }
    }

    public boolean isMergePathsEnabledForKitKatAndAbove() {
        return this.Ah;
    }

    public void aY(@Nullable String str) {
        this.zE = str;
    }

    @Nullable
    public String getImageAssetsFolder() {
        return this.zE;
    }

    public void recycleBitmaps() {
        if (this.Ab != null) {
            this.Ab.recycleBitmaps();
        }
    }

    public boolean a(e eVar) {
        if (this.composition == eVar) {
            return false;
        }
        clearComposition();
        this.composition = eVar;
        gO();
        this.zY.setComposition(eVar);
        setProgress(this.zY.getAnimatedFraction());
        setScale(this.scale);
        gR();
        Iterator it = new ArrayList(this.Aa).iterator();
        while (it.hasNext()) {
            ((a) it.next()).b(eVar);
            it.remove();
        }
        this.Aa.clear();
        eVar.setPerformanceTrackingEnabled(this.Aj);
        return true;
    }

    public void setPerformanceTrackingEnabled(boolean z) {
        this.Aj = z;
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

    private void gO() {
        this.Ai = new com.airbnb.lottie.model.layer.b(this, s.c(this.composition), this.composition.gH(), this.composition);
    }

    public void clearComposition() {
        recycleBitmaps();
        if (this.zY.isRunning()) {
            this.zY.cancel();
        }
        this.composition = null;
        this.Ai = null;
        this.Ab = null;
        this.zY.clearComposition();
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
        if (this.Ai != null) {
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
                float width = this.composition.gC().width() / 2.0f;
                float height = this.composition.gC().height() / 2.0f;
                float f4 = width * f2;
                float f5 = height * f2;
                canvas.translate((width * getScale()) - f4, (height * getScale()) - f5);
                canvas.scale(f, f, f4, f5);
            }
            this.matrix.reset();
            this.matrix.preScale(f2, f2);
            this.Ai.a(canvas, this.matrix, this.alpha);
            d.aV("Drawable#draw");
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
        if (this.Ai == null) {
            this.Aa.add(new a() { // from class: com.airbnb.lottie.g.6
                @Override // com.airbnb.lottie.g.a
                public void b(e eVar) {
                    g.this.playAnimation();
                }
            });
        } else {
            this.zY.playAnimation();
        }
    }

    @MainThread
    public void endAnimation() {
        this.Aa.clear();
        this.zY.endAnimation();
    }

    @MainThread
    public void resumeAnimation() {
        if (this.Ai == null) {
            this.Aa.add(new a() { // from class: com.airbnb.lottie.g.7
                @Override // com.airbnb.lottie.g.a
                public void b(e eVar) {
                    g.this.resumeAnimation();
                }
            });
        } else {
            this.zY.resumeAnimation();
        }
    }

    public void setMinFrame(final int i) {
        if (this.composition == null) {
            this.Aa.add(new a() { // from class: com.airbnb.lottie.g.8
                @Override // com.airbnb.lottie.g.a
                public void b(e eVar) {
                    g.this.setMinFrame(i);
                }
            });
        } else {
            this.zY.setMinFrame(i);
        }
    }

    public float getMinFrame() {
        return this.zY.getMinFrame();
    }

    public void setMinProgress(final float f) {
        if (this.composition == null) {
            this.Aa.add(new a() { // from class: com.airbnb.lottie.g.9
                @Override // com.airbnb.lottie.g.a
                public void b(e eVar) {
                    g.this.setMinProgress(f);
                }
            });
        } else {
            setMinFrame((int) com.airbnb.lottie.d.e.lerp(this.composition.gE(), this.composition.gF(), f));
        }
    }

    public void setMaxFrame(final int i) {
        if (this.composition == null) {
            this.Aa.add(new a() { // from class: com.airbnb.lottie.g.10
                @Override // com.airbnb.lottie.g.a
                public void b(e eVar) {
                    g.this.setMaxFrame(i);
                }
            });
        } else {
            this.zY.setMaxFrame(i);
        }
    }

    public float getMaxFrame() {
        return this.zY.getMaxFrame();
    }

    public void setMaxProgress(@FloatRange(from = 0.0d, to = 1.0d) final float f) {
        if (this.composition == null) {
            this.Aa.add(new a() { // from class: com.airbnb.lottie.g.11
                @Override // com.airbnb.lottie.g.a
                public void b(e eVar) {
                    g.this.setMaxProgress(f);
                }
            });
        } else {
            setMaxFrame((int) com.airbnb.lottie.d.e.lerp(this.composition.gE(), this.composition.gF(), f));
        }
    }

    public void setMinAndMaxFrame(final int i, final int i2) {
        if (this.composition == null) {
            this.Aa.add(new a() { // from class: com.airbnb.lottie.g.12
                @Override // com.airbnb.lottie.g.a
                public void b(e eVar) {
                    g.this.setMinAndMaxFrame(i, i2);
                }
            });
        } else {
            this.zY.h(i, i2);
        }
    }

    public void setMinAndMaxProgress(@FloatRange(from = 0.0d, to = 1.0d) final float f, @FloatRange(from = 0.0d, to = 1.0d) final float f2) {
        if (this.composition == null) {
            this.Aa.add(new a() { // from class: com.airbnb.lottie.g.13
                @Override // com.airbnb.lottie.g.a
                public void b(e eVar) {
                    g.this.setMinAndMaxProgress(f, f2);
                }
            });
        } else {
            setMinAndMaxFrame((int) com.airbnb.lottie.d.e.lerp(this.composition.gE(), this.composition.gF(), f), (int) com.airbnb.lottie.d.e.lerp(this.composition.gE(), this.composition.gF(), f2));
        }
    }

    public void reverseAnimationSpeed() {
        this.zY.reverseAnimationSpeed();
    }

    public void setSpeed(float f) {
        this.zY.setSpeed(f);
    }

    public float getSpeed() {
        return this.zY.getSpeed();
    }

    public void addAnimatorUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.zY.addUpdateListener(animatorUpdateListener);
    }

    public void a(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.zY.removeUpdateListener(animatorUpdateListener);
    }

    public void removeAllUpdateListeners() {
        this.zY.removeAllUpdateListeners();
    }

    public void addAnimatorListener(Animator.AnimatorListener animatorListener) {
        this.zY.addListener(animatorListener);
    }

    public void removeAnimatorListener(Animator.AnimatorListener animatorListener) {
        this.zY.removeListener(animatorListener);
    }

    public void removeAllAnimatorListeners() {
        this.zY.removeAllListeners();
    }

    public void setFrame(final int i) {
        if (this.composition == null) {
            this.Aa.add(new a() { // from class: com.airbnb.lottie.g.2
                @Override // com.airbnb.lottie.g.a
                public void b(e eVar) {
                    g.this.setFrame(i);
                }
            });
        } else {
            this.zY.setFrame(i);
        }
    }

    public int getFrame() {
        return (int) this.zY.jf();
    }

    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) final float f) {
        if (this.composition == null) {
            this.Aa.add(new a() { // from class: com.airbnb.lottie.g.3
                @Override // com.airbnb.lottie.g.a
                public void b(e eVar) {
                    g.this.setProgress(f);
                }
            });
        } else {
            setFrame((int) com.airbnb.lottie.d.e.lerp(this.composition.gE(), this.composition.gF(), f));
        }
    }

    public void setRepeatMode(int i) {
        this.zY.setRepeatMode(i);
    }

    public int getRepeatMode() {
        return this.zY.getRepeatMode();
    }

    public void setRepeatCount(int i) {
        this.zY.setRepeatCount(i);
    }

    public int getRepeatCount() {
        return this.zY.getRepeatCount();
    }

    public boolean isAnimating() {
        return this.zY.isRunning();
    }

    public void setScale(float f) {
        this.scale = f;
        gR();
    }

    public void setImageAssetDelegate(c cVar) {
        this.Ac = cVar;
        if (this.Ab != null) {
            this.Ab.a(cVar);
        }
    }

    public void setFontAssetDelegate(b bVar) {
        this.Af = bVar;
        if (this.Ae != null) {
            this.Ae.a(bVar);
        }
    }

    public void setTextDelegate(r rVar) {
        this.Ag = rVar;
    }

    @Nullable
    public r gP() {
        return this.Ag;
    }

    public boolean gQ() {
        return this.Ag == null && this.composition.gI().size() > 0;
    }

    public float getScale() {
        return this.scale;
    }

    public e getComposition() {
        return this.composition;
    }

    private void gR() {
        if (this.composition != null) {
            float scale = getScale();
            setBounds(0, 0, (int) (this.composition.gC().width() * scale), (int) (scale * this.composition.gC().height()));
        }
    }

    public void cancelAnimation() {
        this.Aa.clear();
        this.zY.cancel();
    }

    public void pauseAnimation() {
        this.Aa.clear();
        this.zY.pauseAnimation();
    }

    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    public float getProgress() {
        return this.zY.je();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        if (this.composition == null) {
            return -1;
        }
        return (int) (this.composition.gC().width() * getScale());
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        if (this.composition == null) {
            return -1;
        }
        return (int) (this.composition.gC().height() * getScale());
    }

    public List<com.airbnb.lottie.model.e> resolveKeyPath(com.airbnb.lottie.model.e eVar) {
        if (this.Ai == null) {
            Log.w("LOTTIE", "Cannot resolve KeyPath. Composition is not set yet.");
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        this.Ai.a(eVar, 0, arrayList, new com.airbnb.lottie.model.e(new String[0]));
        return arrayList;
    }

    public <T> void addValueCallback(final com.airbnb.lottie.model.e eVar, final T t, final com.airbnb.lottie.e.c<T> cVar) {
        boolean z = true;
        if (this.Ai == null) {
            this.Aa.add(new a() { // from class: com.airbnb.lottie.g.4
                @Override // com.airbnb.lottie.g.a
                public void b(e eVar2) {
                    g.this.addValueCallback(eVar, (com.airbnb.lottie.model.e) t, (com.airbnb.lottie.e.c<com.airbnb.lottie.model.e>) cVar);
                }
            });
            return;
        }
        if (eVar.hH() != null) {
            eVar.hH().a(t, cVar);
        } else {
            List<com.airbnb.lottie.model.e> resolveKeyPath = resolveKeyPath(eVar);
            for (int i = 0; i < resolveKeyPath.size(); i++) {
                resolveKeyPath.get(i).hH().a(t, cVar);
            }
            z = resolveKeyPath.isEmpty() ? false : true;
        }
        if (z) {
            invalidateSelf();
            if (t == k.AU) {
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
        com.airbnb.lottie.b.b gS = gS();
        if (gS == null) {
            Log.w("LOTTIE", "Cannot update bitmap. Most likely the drawable is not added to a View which prevents Lottie from getting a Context.");
            return null;
        }
        Bitmap updateBitmap = gS.updateBitmap(str, bitmap);
        invalidateSelf();
        return updateBitmap;
    }

    @Nullable
    public Bitmap aZ(String str) {
        com.airbnb.lottie.b.b gS = gS();
        if (gS != null) {
            return gS.bd(str);
        }
        return null;
    }

    private com.airbnb.lottie.b.b gS() {
        if (getCallback() == null) {
            return null;
        }
        if (this.Ab != null && !this.Ab.D(getContext())) {
            this.Ab.recycleBitmaps();
            this.Ab = null;
        }
        if (this.Ab == null) {
            this.Ab = new com.airbnb.lottie.b.b(getCallback(), this.zE, this.Ac, this.composition.gK());
        }
        return this.Ab;
    }

    @Nullable
    public Typeface n(String str, String str2) {
        com.airbnb.lottie.b.a gT = gT();
        if (gT != null) {
            return gT.n(str, str2);
        }
        return null;
    }

    private com.airbnb.lottie.b.a gT() {
        if (getCallback() == null) {
            return null;
        }
        if (this.Ae == null) {
            this.Ae = new com.airbnb.lottie.b.a(getCallback(), this.Af);
        }
        return this.Ae;
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
        return Math.min(canvas.getWidth() / this.composition.gC().width(), canvas.getHeight() / this.composition.gC().height());
    }
}
