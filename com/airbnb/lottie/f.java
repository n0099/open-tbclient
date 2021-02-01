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
import android.util.Log;
import android.view.View;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.airbnb.lottie.c.s;
import com.baidu.mapapi.map.WeightedLatLng;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
/* loaded from: classes4.dex */
public class f extends Drawable implements Animatable, Drawable.Callback {
    private static final String TAG = f.class.getSimpleName();
    private d BJ;
    @Nullable
    private String BL;
    @Nullable
    private com.airbnb.lottie.b.b Cf;
    @Nullable
    private b Cg;
    @Nullable
    private com.airbnb.lottie.b.a Ch;
    @Nullable
    com.airbnb.lottie.a Ci;
    @Nullable
    p Cj;
    private boolean Ck;
    @Nullable
    private com.airbnb.lottie.model.layer.b Cl;
    private boolean Cm;
    private final Matrix matrix = new Matrix();
    private final com.airbnb.lottie.d.c Cc = new com.airbnb.lottie.d.c();
    private float scale = 1.0f;
    private final Set<Object> Cd = new HashSet();
    private final ArrayList<a> Ce = new ArrayList<>();
    private int alpha = 255;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public interface a {
        void c(d dVar);
    }

    public f() {
        this.Cc.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.airbnb.lottie.f.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (f.this.Cl != null) {
                    f.this.Cl.setProgress(f.this.Cc.kt());
                }
            }
        });
    }

    public boolean ic() {
        return this.Ck;
    }

    public void enableMergePathsForKitKatAndAbove(boolean z) {
        if (this.Ck != z) {
            if (Build.VERSION.SDK_INT < 19) {
                Log.w(TAG, "Merge paths are not supported pre-Kit Kat.");
                return;
            }
            this.Ck = z;
            if (this.BJ != null) {
                ie();
            }
        }
    }

    public void be(@Nullable String str) {
        this.BL = str;
    }

    @Nullable
    public String getImageAssetsFolder() {
        return this.BL;
    }

    public void recycleBitmaps() {
        if (this.Cf != null) {
            this.Cf.recycleBitmaps();
        }
    }

    public boolean b(d dVar) {
        if (this.BJ == dVar) {
            return false;
        }
        clearComposition();
        this.BJ = dVar;
        ie();
        this.Cc.setComposition(dVar);
        setProgress(this.Cc.getAnimatedFraction());
        setScale(this.scale);
        ih();
        Iterator it = new ArrayList(this.Ce).iterator();
        while (it.hasNext()) {
            ((a) it.next()).c(dVar);
            it.remove();
        }
        this.Ce.clear();
        dVar.setPerformanceTrackingEnabled(this.Cm);
        return true;
    }

    public void setPerformanceTrackingEnabled(boolean z) {
        this.Cm = z;
        if (this.BJ != null) {
            this.BJ.setPerformanceTrackingEnabled(z);
        }
    }

    @Nullable
    public m getPerformanceTracker() {
        if (this.BJ != null) {
            return this.BJ.getPerformanceTracker();
        }
        return null;
    }

    private void ie() {
        this.Cl = new com.airbnb.lottie.model.layer.b(this, s.e(this.BJ), this.BJ.hV(), this.BJ);
    }

    public void clearComposition() {
        recycleBitmaps();
        if (this.Cc.isRunning()) {
            this.Cc.cancel();
        }
        this.BJ = null;
        this.Cl = null;
        this.Cf = null;
        this.Cc.clearComposition();
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
        c.beginSection("Drawable#draw");
        if (this.Cl != null) {
            float f2 = this.scale;
            float e = e(canvas);
            if (f2 > e) {
                f = this.scale / e;
            } else {
                f = 1.0f;
                e = f2;
            }
            int i = -1;
            if (f > 1.0f) {
                i = canvas.save();
                float width = this.BJ.hQ().width() / 2.0f;
                float height = this.BJ.hQ().height() / 2.0f;
                float f3 = width * e;
                float f4 = height * e;
                canvas.translate((width * getScale()) - f3, (height * getScale()) - f4);
                canvas.scale(f, f, f3, f4);
            }
            this.matrix.reset();
            this.matrix.preScale(e, e);
            this.Cl.c(canvas, this.matrix, this.alpha);
            c.bb("Drawable#draw");
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
        if (this.Cl == null) {
            this.Ce.add(new a() { // from class: com.airbnb.lottie.f.5
                @Override // com.airbnb.lottie.f.a
                public void c(d dVar) {
                    f.this.playAnimation();
                }
            });
        } else {
            this.Cc.playAnimation();
        }
    }

    @MainThread
    public void endAnimation() {
        this.Ce.clear();
        this.Cc.endAnimation();
    }

    @MainThread
    public void resumeAnimation() {
        if (this.Cl == null) {
            this.Ce.add(new a() { // from class: com.airbnb.lottie.f.6
                @Override // com.airbnb.lottie.f.a
                public void c(d dVar) {
                    f.this.resumeAnimation();
                }
            });
        } else {
            this.Cc.resumeAnimation();
        }
    }

    public void setMinFrame(final int i) {
        if (this.BJ == null) {
            this.Ce.add(new a() { // from class: com.airbnb.lottie.f.7
                @Override // com.airbnb.lottie.f.a
                public void c(d dVar) {
                    f.this.setMinFrame(i);
                }
            });
        } else {
            this.Cc.setMinFrame(i);
        }
    }

    public float getMinFrame() {
        return this.Cc.getMinFrame();
    }

    public void setMinProgress(final float f) {
        if (this.BJ == null) {
            this.Ce.add(new a() { // from class: com.airbnb.lottie.f.8
                @Override // com.airbnb.lottie.f.a
                public void c(d dVar) {
                    f.this.setMinProgress(f);
                }
            });
        } else {
            setMinFrame((int) com.airbnb.lottie.d.e.lerp(this.BJ.hS(), this.BJ.hT(), f));
        }
    }

    public void setMaxFrame(final int i) {
        if (this.BJ == null) {
            this.Ce.add(new a() { // from class: com.airbnb.lottie.f.9
                @Override // com.airbnb.lottie.f.a
                public void c(d dVar) {
                    f.this.setMaxFrame(i);
                }
            });
        } else {
            this.Cc.setMaxFrame(i);
        }
    }

    public float getMaxFrame() {
        return this.Cc.getMaxFrame();
    }

    public void setMaxProgress(@FloatRange(from = 0.0d, to = 1.0d) final float f) {
        if (this.BJ == null) {
            this.Ce.add(new a() { // from class: com.airbnb.lottie.f.10
                @Override // com.airbnb.lottie.f.a
                public void c(d dVar) {
                    f.this.setMaxProgress(f);
                }
            });
        } else {
            setMaxFrame((int) com.airbnb.lottie.d.e.lerp(this.BJ.hS(), this.BJ.hT(), f));
        }
    }

    public void setMinAndMaxFrame(final int i, final int i2) {
        if (this.BJ == null) {
            this.Ce.add(new a() { // from class: com.airbnb.lottie.f.11
                @Override // com.airbnb.lottie.f.a
                public void c(d dVar) {
                    f.this.setMinAndMaxFrame(i, i2);
                }
            });
        } else {
            this.Cc.l(i, i2);
        }
    }

    public void setMinAndMaxProgress(@FloatRange(from = 0.0d, to = 1.0d) final float f, @FloatRange(from = 0.0d, to = 1.0d) final float f2) {
        if (this.BJ == null) {
            this.Ce.add(new a() { // from class: com.airbnb.lottie.f.12
                @Override // com.airbnb.lottie.f.a
                public void c(d dVar) {
                    f.this.setMinAndMaxProgress(f, f2);
                }
            });
        } else {
            setMinAndMaxFrame((int) com.airbnb.lottie.d.e.lerp(this.BJ.hS(), this.BJ.hT(), f), (int) com.airbnb.lottie.d.e.lerp(this.BJ.hS(), this.BJ.hT(), f2));
        }
    }

    public void setSpeed(float f) {
        this.Cc.setSpeed(f);
    }

    public float getSpeed() {
        return this.Cc.getSpeed();
    }

    public void addAnimatorUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.Cc.addUpdateListener(animatorUpdateListener);
    }

    public void a(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.Cc.removeUpdateListener(animatorUpdateListener);
    }

    public void addAnimatorListener(Animator.AnimatorListener animatorListener) {
        this.Cc.addListener(animatorListener);
    }

    public void removeAnimatorListener(Animator.AnimatorListener animatorListener) {
        this.Cc.removeListener(animatorListener);
    }

    public void removeAllAnimatorListeners() {
        this.Cc.removeAllListeners();
    }

    public void setFrame(final int i) {
        if (this.BJ == null) {
            this.Ce.add(new a() { // from class: com.airbnb.lottie.f.2
                @Override // com.airbnb.lottie.f.a
                public void c(d dVar) {
                    f.this.setFrame(i);
                }
            });
        } else {
            this.Cc.setFrame(i);
        }
    }

    public int getFrame() {
        return (int) this.Cc.ku();
    }

    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) final float f) {
        if (this.BJ == null) {
            this.Ce.add(new a() { // from class: com.airbnb.lottie.f.3
                @Override // com.airbnb.lottie.f.a
                public void c(d dVar) {
                    f.this.setProgress(f);
                }
            });
        } else {
            setFrame((int) com.airbnb.lottie.d.e.lerp(this.BJ.hS(), this.BJ.hT(), f));
        }
    }

    public void setRepeatMode(int i) {
        this.Cc.setRepeatMode(i);
    }

    public int getRepeatMode() {
        return this.Cc.getRepeatMode();
    }

    public void setRepeatCount(int i) {
        this.Cc.setRepeatCount(i);
    }

    public int getRepeatCount() {
        return this.Cc.getRepeatCount();
    }

    public boolean isAnimating() {
        return this.Cc.isRunning();
    }

    public void setScale(float f) {
        this.scale = f;
        ih();
    }

    public void setImageAssetDelegate(b bVar) {
        this.Cg = bVar;
        if (this.Cf != null) {
            this.Cf.a(bVar);
        }
    }

    public void setFontAssetDelegate(com.airbnb.lottie.a aVar) {
        this.Ci = aVar;
        if (this.Ch != null) {
            this.Ch.a(aVar);
        }
    }

    public void setTextDelegate(p pVar) {
        this.Cj = pVar;
    }

    @Nullable
    /* renamed from: if  reason: not valid java name */
    public p m6if() {
        return this.Cj;
    }

    public boolean ig() {
        return this.Cj == null && this.BJ.hW().size() > 0;
    }

    public float getScale() {
        return this.scale;
    }

    public d getComposition() {
        return this.BJ;
    }

    private void ih() {
        if (this.BJ != null) {
            float scale = getScale();
            setBounds(0, 0, (int) (this.BJ.hQ().width() * scale), (int) (scale * this.BJ.hQ().height()));
        }
    }

    public void cancelAnimation() {
        this.Ce.clear();
        this.Cc.cancel();
    }

    public void pauseAnimation() {
        this.Ce.clear();
        this.Cc.pauseAnimation();
    }

    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    public float getProgress() {
        return this.Cc.kt();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        if (this.BJ == null) {
            return -1;
        }
        return (int) (this.BJ.hQ().width() * getScale());
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        if (this.BJ == null) {
            return -1;
        }
        return (int) (this.BJ.hQ().height() * getScale());
    }

    public List<com.airbnb.lottie.model.e> a(com.airbnb.lottie.model.e eVar) {
        if (this.Cl == null) {
            Log.w("LOTTIE", "Cannot resolve KeyPath. Composition is not set yet.");
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        this.Cl.a(eVar, 0, arrayList, new com.airbnb.lottie.model.e(new String[0]));
        return arrayList;
    }

    public <T> void a(final com.airbnb.lottie.model.e eVar, final T t, final com.airbnb.lottie.e.c<T> cVar) {
        boolean z = true;
        if (this.Cl == null) {
            this.Ce.add(new a() { // from class: com.airbnb.lottie.f.4
                @Override // com.airbnb.lottie.f.a
                public void c(d dVar) {
                    f.this.a(eVar, t, cVar);
                }
            });
            return;
        }
        if (eVar.iY() != null) {
            eVar.iY().a(t, cVar);
        } else {
            List<com.airbnb.lottie.model.e> a2 = a(eVar);
            for (int i = 0; i < a2.size(); i++) {
                a2.get(i).iY().a(t, cVar);
            }
            z = a2.isEmpty() ? false : true;
        }
        if (z) {
            invalidateSelf();
            if (t == j.Da) {
                setProgress(getProgress());
            }
        }
    }

    @Nullable
    public Bitmap bf(String str) {
        com.airbnb.lottie.b.b ii = ii();
        if (ii != null) {
            return ii.bj(str);
        }
        return null;
    }

    private com.airbnb.lottie.b.b ii() {
        if (getCallback() == null) {
            return null;
        }
        if (this.Cf != null && !this.Cf.H(getContext())) {
            this.Cf.recycleBitmaps();
            this.Cf = null;
        }
        if (this.Cf == null) {
            this.Cf = new com.airbnb.lottie.b.b(getCallback(), this.BL, this.Cg, this.BJ.hY());
        }
        return this.Cf;
    }

    @Nullable
    public Typeface n(String str, String str2) {
        com.airbnb.lottie.b.a ij = ij();
        if (ij != null) {
            return ij.n(str, str2);
        }
        return null;
    }

    private com.airbnb.lottie.b.a ij() {
        if (getCallback() == null) {
            return null;
        }
        if (this.Ch == null) {
            this.Ch = new com.airbnb.lottie.b.a(getCallback(), this.Ci);
        }
        return this.Ch;
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

    private float e(@NonNull Canvas canvas) {
        return Math.min(canvas.getWidth() / this.BJ.hQ().width(), canvas.getHeight() / this.BJ.hQ().height());
    }
}
