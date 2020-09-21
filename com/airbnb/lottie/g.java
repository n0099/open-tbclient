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
    private String AM;
    @Nullable
    private com.airbnb.lottie.b.b Bl;
    @Nullable
    private c Bm;
    @Nullable
    private com.airbnb.lottie.b.a Bn;
    @Nullable
    b Bo;
    @Nullable
    r Bp;
    private boolean Bq;
    @Nullable
    private com.airbnb.lottie.model.layer.b Br;
    private boolean Bs;
    private e composition;
    private final Matrix matrix = new Matrix();
    private final com.airbnb.lottie.d.c Bi = new com.airbnb.lottie.d.c();
    private float scale = 1.0f;
    private final Set<Object> Bj = new HashSet();
    private final ArrayList<a> Bk = new ArrayList<>();
    private int alpha = 255;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public interface a {
        void b(e eVar);
    }

    public g() {
        this.Bi.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.airbnb.lottie.g.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (g.this.Br != null) {
                    g.this.Br.setProgress(g.this.Bi.kU());
                }
            }
        });
    }

    public boolean hasMasks() {
        return this.Br != null && this.Br.hasMasks();
    }

    public boolean hasMatte() {
        return this.Br != null && this.Br.hasMatte();
    }

    public boolean iF() {
        return this.Bq;
    }

    public void enableMergePathsForKitKatAndAbove(boolean z) {
        if (this.Bq != z) {
            if (Build.VERSION.SDK_INT < 19) {
                Log.w(TAG, "Merge paths are not supported pre-Kit Kat.");
                return;
            }
            this.Bq = z;
            if (this.composition != null) {
                iG();
            }
        }
    }

    public boolean isMergePathsEnabledForKitKatAndAbove() {
        return this.Bq;
    }

    public void be(@Nullable String str) {
        this.AM = str;
    }

    @Nullable
    public String getImageAssetsFolder() {
        return this.AM;
    }

    public void recycleBitmaps() {
        if (this.Bl != null) {
            this.Bl.recycleBitmaps();
        }
    }

    public boolean a(e eVar) {
        if (this.composition == eVar) {
            return false;
        }
        clearComposition();
        this.composition = eVar;
        iG();
        this.Bi.setComposition(eVar);
        setProgress(this.Bi.getAnimatedFraction());
        setScale(this.scale);
        iJ();
        Iterator it = new ArrayList(this.Bk).iterator();
        while (it.hasNext()) {
            ((a) it.next()).b(eVar);
            it.remove();
        }
        this.Bk.clear();
        eVar.setPerformanceTrackingEnabled(this.Bs);
        return true;
    }

    public void setPerformanceTrackingEnabled(boolean z) {
        this.Bs = z;
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

    private void iG() {
        this.Br = new com.airbnb.lottie.model.layer.b(this, s.c(this.composition), this.composition.iy(), this.composition);
    }

    public void clearComposition() {
        recycleBitmaps();
        if (this.Bi.isRunning()) {
            this.Bi.cancel();
        }
        this.composition = null;
        this.Br = null;
        this.Bl = null;
        this.Bi.clearComposition();
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
        if (this.Br != null) {
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
                float width = this.composition.it().width() / 2.0f;
                float height = this.composition.it().height() / 2.0f;
                float f4 = width * f2;
                float f5 = height * f2;
                canvas.translate((width * getScale()) - f4, (height * getScale()) - f5);
                canvas.scale(f, f, f4, f5);
            }
            this.matrix.reset();
            this.matrix.preScale(f2, f2);
            this.Br.a(canvas, this.matrix, this.alpha);
            d.bb("Drawable#draw");
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
        if (this.Br == null) {
            this.Bk.add(new a() { // from class: com.airbnb.lottie.g.6
                @Override // com.airbnb.lottie.g.a
                public void b(e eVar) {
                    g.this.playAnimation();
                }
            });
        } else {
            this.Bi.playAnimation();
        }
    }

    @MainThread
    public void endAnimation() {
        this.Bk.clear();
        this.Bi.endAnimation();
    }

    @MainThread
    public void resumeAnimation() {
        if (this.Br == null) {
            this.Bk.add(new a() { // from class: com.airbnb.lottie.g.7
                @Override // com.airbnb.lottie.g.a
                public void b(e eVar) {
                    g.this.resumeAnimation();
                }
            });
        } else {
            this.Bi.resumeAnimation();
        }
    }

    public void setMinFrame(final int i) {
        if (this.composition == null) {
            this.Bk.add(new a() { // from class: com.airbnb.lottie.g.8
                @Override // com.airbnb.lottie.g.a
                public void b(e eVar) {
                    g.this.setMinFrame(i);
                }
            });
        } else {
            this.Bi.setMinFrame(i);
        }
    }

    public float getMinFrame() {
        return this.Bi.getMinFrame();
    }

    public void setMinProgress(final float f) {
        if (this.composition == null) {
            this.Bk.add(new a() { // from class: com.airbnb.lottie.g.9
                @Override // com.airbnb.lottie.g.a
                public void b(e eVar) {
                    g.this.setMinProgress(f);
                }
            });
        } else {
            setMinFrame((int) com.airbnb.lottie.d.e.lerp(this.composition.iv(), this.composition.iw(), f));
        }
    }

    public void setMaxFrame(final int i) {
        if (this.composition == null) {
            this.Bk.add(new a() { // from class: com.airbnb.lottie.g.10
                @Override // com.airbnb.lottie.g.a
                public void b(e eVar) {
                    g.this.setMaxFrame(i);
                }
            });
        } else {
            this.Bi.setMaxFrame(i);
        }
    }

    public float getMaxFrame() {
        return this.Bi.getMaxFrame();
    }

    public void setMaxProgress(@FloatRange(from = 0.0d, to = 1.0d) final float f) {
        if (this.composition == null) {
            this.Bk.add(new a() { // from class: com.airbnb.lottie.g.11
                @Override // com.airbnb.lottie.g.a
                public void b(e eVar) {
                    g.this.setMaxProgress(f);
                }
            });
        } else {
            setMaxFrame((int) com.airbnb.lottie.d.e.lerp(this.composition.iv(), this.composition.iw(), f));
        }
    }

    public void setMinAndMaxFrame(final int i, final int i2) {
        if (this.composition == null) {
            this.Bk.add(new a() { // from class: com.airbnb.lottie.g.12
                @Override // com.airbnb.lottie.g.a
                public void b(e eVar) {
                    g.this.setMinAndMaxFrame(i, i2);
                }
            });
        } else {
            this.Bi.k(i, i2);
        }
    }

    public void setMinAndMaxProgress(@FloatRange(from = 0.0d, to = 1.0d) final float f, @FloatRange(from = 0.0d, to = 1.0d) final float f2) {
        if (this.composition == null) {
            this.Bk.add(new a() { // from class: com.airbnb.lottie.g.13
                @Override // com.airbnb.lottie.g.a
                public void b(e eVar) {
                    g.this.setMinAndMaxProgress(f, f2);
                }
            });
        } else {
            setMinAndMaxFrame((int) com.airbnb.lottie.d.e.lerp(this.composition.iv(), this.composition.iw(), f), (int) com.airbnb.lottie.d.e.lerp(this.composition.iv(), this.composition.iw(), f2));
        }
    }

    public void reverseAnimationSpeed() {
        this.Bi.reverseAnimationSpeed();
    }

    public void setSpeed(float f) {
        this.Bi.setSpeed(f);
    }

    public float getSpeed() {
        return this.Bi.getSpeed();
    }

    public void addAnimatorUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.Bi.addUpdateListener(animatorUpdateListener);
    }

    public void a(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.Bi.removeUpdateListener(animatorUpdateListener);
    }

    public void removeAllUpdateListeners() {
        this.Bi.removeAllUpdateListeners();
    }

    public void addAnimatorListener(Animator.AnimatorListener animatorListener) {
        this.Bi.addListener(animatorListener);
    }

    public void removeAnimatorListener(Animator.AnimatorListener animatorListener) {
        this.Bi.removeListener(animatorListener);
    }

    public void removeAllAnimatorListeners() {
        this.Bi.removeAllListeners();
    }

    public void setFrame(final int i) {
        if (this.composition == null) {
            this.Bk.add(new a() { // from class: com.airbnb.lottie.g.2
                @Override // com.airbnb.lottie.g.a
                public void b(e eVar) {
                    g.this.setFrame(i);
                }
            });
        } else {
            this.Bi.setFrame(i);
        }
    }

    public int getFrame() {
        return (int) this.Bi.kV();
    }

    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) final float f) {
        if (this.composition == null) {
            this.Bk.add(new a() { // from class: com.airbnb.lottie.g.3
                @Override // com.airbnb.lottie.g.a
                public void b(e eVar) {
                    g.this.setProgress(f);
                }
            });
        } else {
            setFrame((int) com.airbnb.lottie.d.e.lerp(this.composition.iv(), this.composition.iw(), f));
        }
    }

    public void setRepeatMode(int i) {
        this.Bi.setRepeatMode(i);
    }

    public int getRepeatMode() {
        return this.Bi.getRepeatMode();
    }

    public void setRepeatCount(int i) {
        this.Bi.setRepeatCount(i);
    }

    public int getRepeatCount() {
        return this.Bi.getRepeatCount();
    }

    public boolean isAnimating() {
        return this.Bi.isRunning();
    }

    public void setScale(float f) {
        this.scale = f;
        iJ();
    }

    public void setImageAssetDelegate(c cVar) {
        this.Bm = cVar;
        if (this.Bl != null) {
            this.Bl.a(cVar);
        }
    }

    public void setFontAssetDelegate(b bVar) {
        this.Bo = bVar;
        if (this.Bn != null) {
            this.Bn.a(bVar);
        }
    }

    public void setTextDelegate(r rVar) {
        this.Bp = rVar;
    }

    @Nullable
    public r iH() {
        return this.Bp;
    }

    public boolean iI() {
        return this.Bp == null && this.composition.iz().size() > 0;
    }

    public float getScale() {
        return this.scale;
    }

    public e getComposition() {
        return this.composition;
    }

    private void iJ() {
        if (this.composition != null) {
            float scale = getScale();
            setBounds(0, 0, (int) (this.composition.it().width() * scale), (int) (scale * this.composition.it().height()));
        }
    }

    public void cancelAnimation() {
        this.Bk.clear();
        this.Bi.cancel();
    }

    public void pauseAnimation() {
        this.Bk.clear();
        this.Bi.pauseAnimation();
    }

    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    public float getProgress() {
        return this.Bi.kU();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        if (this.composition == null) {
            return -1;
        }
        return (int) (this.composition.it().width() * getScale());
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        if (this.composition == null) {
            return -1;
        }
        return (int) (this.composition.it().height() * getScale());
    }

    public List<com.airbnb.lottie.model.e> resolveKeyPath(com.airbnb.lottie.model.e eVar) {
        if (this.Br == null) {
            Log.w("LOTTIE", "Cannot resolve KeyPath. Composition is not set yet.");
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        this.Br.a(eVar, 0, arrayList, new com.airbnb.lottie.model.e(new String[0]));
        return arrayList;
    }

    public <T> void addValueCallback(final com.airbnb.lottie.model.e eVar, final T t, final com.airbnb.lottie.e.c<T> cVar) {
        boolean z = true;
        if (this.Br == null) {
            this.Bk.add(new a() { // from class: com.airbnb.lottie.g.4
                @Override // com.airbnb.lottie.g.a
                public void b(e eVar2) {
                    g.this.addValueCallback(eVar, (com.airbnb.lottie.model.e) t, (com.airbnb.lottie.e.c<com.airbnb.lottie.model.e>) cVar);
                }
            });
            return;
        }
        if (eVar.jz() != null) {
            eVar.jz().a(t, cVar);
        } else {
            List<com.airbnb.lottie.model.e> resolveKeyPath = resolveKeyPath(eVar);
            for (int i = 0; i < resolveKeyPath.size(); i++) {
                resolveKeyPath.get(i).jz().a(t, cVar);
            }
            z = resolveKeyPath.isEmpty() ? false : true;
        }
        if (z) {
            invalidateSelf();
            if (t == k.Ca) {
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
        com.airbnb.lottie.b.b iK = iK();
        if (iK == null) {
            Log.w("LOTTIE", "Cannot update bitmap. Most likely the drawable is not added to a View which prevents Lottie from getting a Context.");
            return null;
        }
        Bitmap updateBitmap = iK.updateBitmap(str, bitmap);
        invalidateSelf();
        return updateBitmap;
    }

    @Nullable
    public Bitmap bf(String str) {
        com.airbnb.lottie.b.b iK = iK();
        if (iK != null) {
            return iK.bj(str);
        }
        return null;
    }

    private com.airbnb.lottie.b.b iK() {
        if (getCallback() == null) {
            return null;
        }
        if (this.Bl != null && !this.Bl.F(getContext())) {
            this.Bl.recycleBitmaps();
            this.Bl = null;
        }
        if (this.Bl == null) {
            this.Bl = new com.airbnb.lottie.b.b(getCallback(), this.AM, this.Bm, this.composition.iB());
        }
        return this.Bl;
    }

    @Nullable
    public Typeface q(String str, String str2) {
        com.airbnb.lottie.b.a iL = iL();
        if (iL != null) {
            return iL.q(str, str2);
        }
        return null;
    }

    private com.airbnb.lottie.b.a iL() {
        if (getCallback() == null) {
            return null;
        }
        if (this.Bn == null) {
            this.Bn = new com.airbnb.lottie.b.a(getCallback(), this.Bo);
        }
        return this.Bn;
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
        return Math.min(canvas.getWidth() / this.composition.it().width(), canvas.getHeight() / this.composition.it().height());
    }
}
