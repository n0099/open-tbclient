package com.baidu.live.lottie;

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
import com.baidu.mapapi.map.WeightedLatLng;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
/* loaded from: classes9.dex */
public class h extends Drawable implements Animatable, Drawable.Callback {
    private static final String TAG = h.class.getSimpleName();
    private boolean DK;
    private boolean DN;
    @Nullable
    private String Dj;
    @Nullable
    private com.baidu.live.lottie.b.b btC;
    @Nullable
    private c btD;
    @Nullable
    private com.baidu.live.lottie.b.a btE;
    @Nullable
    b btF;
    @Nullable
    s btG;
    @Nullable
    private com.baidu.live.lottie.model.layer.b btH;
    private e composition;
    private final Matrix matrix = new Matrix();
    private final com.baidu.live.lottie.d.c btB = new com.baidu.live.lottie.d.c();
    private float scale = 1.0f;
    private final Set<Object> DC = new HashSet();
    private final ArrayList<a> DD = new ArrayList<>();
    private int alpha = 255;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public interface a {
        void b(e eVar);
    }

    public h() {
        this.btB.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.live.lottie.h.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (h.this.btH != null) {
                    h.this.btH.setProgress(h.this.btB.kt());
                }
            }
        });
    }

    public boolean hasMasks() {
        return this.btH != null && this.btH.hasMasks();
    }

    public boolean hasMatte() {
        return this.btH != null && this.btH.hasMatte();
    }

    public boolean ic() {
        return this.DK;
    }

    public void enableMergePathsForKitKatAndAbove(boolean z) {
        if (this.DK != z) {
            if (Build.VERSION.SDK_INT < 19) {
                Log.w(TAG, "Merge paths are not supported pre-Kit Kat.");
                return;
            }
            this.DK = z;
            if (this.composition != null) {
                ie();
            }
        }
    }

    public boolean isMergePathsEnabledForKitKatAndAbove() {
        return this.DK;
    }

    public void bi(@Nullable String str) {
        this.Dj = str;
    }

    @Nullable
    public String getImageAssetsFolder() {
        return this.Dj;
    }

    public void recycleBitmaps() {
        if (this.btC != null) {
            this.btC.recycleBitmaps();
        }
    }

    public boolean a(e eVar) {
        if (this.composition == eVar) {
            return false;
        }
        clearComposition();
        this.composition = eVar;
        ie();
        this.btB.setComposition(eVar);
        setProgress(this.btB.getAnimatedFraction());
        setScale(this.scale);
        ih();
        Iterator it = new ArrayList(this.DD).iterator();
        while (it.hasNext()) {
            ((a) it.next()).b(eVar);
            it.remove();
        }
        this.DD.clear();
        eVar.setPerformanceTrackingEnabled(this.DN);
        return true;
    }

    public void setPerformanceTrackingEnabled(boolean z) {
        this.DN = z;
        if (this.composition != null) {
            this.composition.setPerformanceTrackingEnabled(z);
        }
    }

    @Nullable
    public p getPerformanceTracker() {
        if (this.composition != null) {
            return this.composition.getPerformanceTracker();
        }
        return null;
    }

    private void ie() {
        this.btH = new com.baidu.live.lottie.model.layer.b(this, com.baidu.live.lottie.c.s.d(this.composition), this.composition.hV(), this.composition);
    }

    public void clearComposition() {
        recycleBitmaps();
        if (this.btB.isRunning()) {
            this.btB.cancel();
        }
        this.composition = null;
        this.btH = null;
        this.btC = null;
        this.btB.clearComposition();
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
        if (this.btH != null) {
            float f2 = this.scale;
            float e = e(canvas);
            if (f2 > e) {
                f = this.scale / e;
            } else {
                f = 1.0f;
                e = f2;
            }
            if (f > 1.0f) {
                canvas.save();
                float width = this.composition.hQ().width() / 2.0f;
                float height = this.composition.hQ().height() / 2.0f;
                float f3 = width * e;
                float f4 = height * e;
                canvas.translate((width * getScale()) - f3, (height * getScale()) - f4);
                canvas.scale(f, f, f3, f4);
            }
            this.matrix.reset();
            this.matrix.preScale(e, e);
            this.btH.c(canvas, this.matrix, this.alpha);
            d.bf("Drawable#draw");
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
        if (this.btH == null) {
            this.DD.add(new a() { // from class: com.baidu.live.lottie.h.5
                @Override // com.baidu.live.lottie.h.a
                public void b(e eVar) {
                    h.this.playAnimation();
                }
            });
        } else {
            this.btB.playAnimation();
        }
    }

    @MainThread
    public void endAnimation() {
        this.DD.clear();
        this.btB.endAnimation();
    }

    @MainThread
    public void resumeAnimation() {
        if (this.btH == null) {
            this.DD.add(new a() { // from class: com.baidu.live.lottie.h.6
                @Override // com.baidu.live.lottie.h.a
                public void b(e eVar) {
                    h.this.resumeAnimation();
                }
            });
        } else {
            this.btB.resumeAnimation();
        }
    }

    public void setMinFrame(final int i) {
        if (this.composition == null) {
            this.DD.add(new a() { // from class: com.baidu.live.lottie.h.7
                @Override // com.baidu.live.lottie.h.a
                public void b(e eVar) {
                    h.this.setMinFrame(i);
                }
            });
        } else {
            this.btB.setMinFrame(i);
        }
    }

    public float getMinFrame() {
        return this.btB.getMinFrame();
    }

    public void setMinProgress(final float f) {
        if (this.composition == null) {
            this.DD.add(new a() { // from class: com.baidu.live.lottie.h.8
                @Override // com.baidu.live.lottie.h.a
                public void b(e eVar) {
                    h.this.setMinProgress(f);
                }
            });
        } else {
            setMinFrame((int) com.baidu.live.lottie.d.e.lerp(this.composition.hS(), this.composition.hT(), f));
        }
    }

    public void setMaxFrame(final int i) {
        if (this.composition == null) {
            this.DD.add(new a() { // from class: com.baidu.live.lottie.h.9
                @Override // com.baidu.live.lottie.h.a
                public void b(e eVar) {
                    h.this.setMaxFrame(i);
                }
            });
        } else {
            this.btB.setMaxFrame(i);
        }
    }

    public float getMaxFrame() {
        return this.btB.getMaxFrame();
    }

    public void setMaxProgress(@FloatRange(from = 0.0d, to = 1.0d) final float f) {
        if (this.composition == null) {
            this.DD.add(new a() { // from class: com.baidu.live.lottie.h.10
                @Override // com.baidu.live.lottie.h.a
                public void b(e eVar) {
                    h.this.setMaxProgress(f);
                }
            });
        } else {
            setMaxFrame((int) com.baidu.live.lottie.d.e.lerp(this.composition.hS(), this.composition.hT(), f));
        }
    }

    public void setMinAndMaxFrame(final int i, final int i2) {
        if (this.composition == null) {
            this.DD.add(new a() { // from class: com.baidu.live.lottie.h.11
                @Override // com.baidu.live.lottie.h.a
                public void b(e eVar) {
                    h.this.setMinAndMaxFrame(i, i2);
                }
            });
        } else {
            this.btB.l(i, i2);
        }
    }

    public void setMinAndMaxProgress(@FloatRange(from = 0.0d, to = 1.0d) final float f, @FloatRange(from = 0.0d, to = 1.0d) final float f2) {
        if (this.composition == null) {
            this.DD.add(new a() { // from class: com.baidu.live.lottie.h.12
                @Override // com.baidu.live.lottie.h.a
                public void b(e eVar) {
                    h.this.setMinAndMaxProgress(f, f2);
                }
            });
        } else {
            setMinAndMaxFrame((int) com.baidu.live.lottie.d.e.lerp(this.composition.hS(), this.composition.hT(), f), (int) com.baidu.live.lottie.d.e.lerp(this.composition.hS(), this.composition.hT(), f2));
        }
    }

    public void reverseAnimationSpeed() {
        this.btB.reverseAnimationSpeed();
    }

    public void setSpeed(float f) {
        this.btB.setSpeed(f);
    }

    public float getSpeed() {
        return this.btB.getSpeed();
    }

    public void addAnimatorUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.btB.addUpdateListener(animatorUpdateListener);
    }

    public void a(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.btB.removeUpdateListener(animatorUpdateListener);
    }

    public void removeAllUpdateListeners() {
        this.btB.removeAllUpdateListeners();
    }

    public void addAnimatorListener(Animator.AnimatorListener animatorListener) {
        this.btB.addListener(animatorListener);
    }

    public void removeAnimatorListener(Animator.AnimatorListener animatorListener) {
        this.btB.removeListener(animatorListener);
    }

    public void removeAllAnimatorListeners() {
        this.btB.removeAllListeners();
    }

    public void setFrame(final int i) {
        if (this.composition == null) {
            this.DD.add(new a() { // from class: com.baidu.live.lottie.h.2
                @Override // com.baidu.live.lottie.h.a
                public void b(e eVar) {
                    h.this.setFrame(i);
                }
            });
        } else {
            this.btB.setFrame(i);
        }
    }

    public int getFrame() {
        return (int) this.btB.ku();
    }

    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) final float f) {
        if (this.composition == null) {
            this.DD.add(new a() { // from class: com.baidu.live.lottie.h.3
                @Override // com.baidu.live.lottie.h.a
                public void b(e eVar) {
                    h.this.setProgress(f);
                }
            });
        } else {
            setFrame((int) com.baidu.live.lottie.d.e.lerp(this.composition.hS(), this.composition.hT(), f));
        }
    }

    public void setRepeatMode(int i) {
        this.btB.setRepeatMode(i);
    }

    public int getRepeatMode() {
        return this.btB.getRepeatMode();
    }

    public void setRepeatCount(int i) {
        this.btB.setRepeatCount(i);
    }

    public int getRepeatCount() {
        return this.btB.getRepeatCount();
    }

    public boolean isAnimating() {
        return this.btB.isRunning();
    }

    public void setScale(float f) {
        this.scale = f;
        ih();
    }

    public void setImageAssetDelegate(c cVar) {
        this.btD = cVar;
        if (this.btC != null) {
            this.btC.a(cVar);
        }
    }

    public void setFontAssetDelegate(b bVar) {
        this.btF = bVar;
        if (this.btE != null) {
            this.btE.a(bVar);
        }
    }

    public void setTextDelegate(s sVar) {
        this.btG = sVar;
    }

    @Nullable
    public s Ni() {
        return this.btG;
    }

    public boolean ig() {
        return this.btG == null && this.composition.hW().size() > 0;
    }

    public float getScale() {
        return this.scale;
    }

    public e getComposition() {
        return this.composition;
    }

    private void ih() {
        if (this.composition != null) {
            float scale = getScale();
            setBounds(0, 0, (int) (this.composition.hQ().width() * scale), (int) (scale * this.composition.hQ().height()));
        }
    }

    public void cancelAnimation() {
        this.DD.clear();
        this.btB.cancel();
    }

    public void pauseAnimation() {
        this.DD.clear();
        this.btB.pauseAnimation();
    }

    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    public float getProgress() {
        return this.btB.kt();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        if (this.composition == null) {
            return -1;
        }
        return (int) (this.composition.hQ().width() * getScale());
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        if (this.composition == null) {
            return -1;
        }
        return (int) (this.composition.hQ().height() * getScale());
    }

    public List<com.baidu.live.lottie.model.e> resolveKeyPath(com.baidu.live.lottie.model.e eVar) {
        if (this.btH == null) {
            Log.w("LOTTIE", "Cannot resolve KeyPath. Composition is not set yet.");
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        this.btH.a(eVar, 0, arrayList, new com.baidu.live.lottie.model.e(new String[0]));
        return arrayList;
    }

    public <T> void addValueCallback(final com.baidu.live.lottie.model.e eVar, final T t, final com.baidu.live.lottie.e.c<T> cVar) {
        boolean z = true;
        if (this.btH == null) {
            this.DD.add(new a() { // from class: com.baidu.live.lottie.h.4
                @Override // com.baidu.live.lottie.h.a
                public void b(e eVar2) {
                    h.this.addValueCallback(eVar, t, cVar);
                }
            });
            return;
        }
        if (eVar.Nt() != null) {
            eVar.Nt().a(t, cVar);
        } else {
            List<com.baidu.live.lottie.model.e> resolveKeyPath = resolveKeyPath(eVar);
            for (int i = 0; i < resolveKeyPath.size(); i++) {
                resolveKeyPath.get(i).Nt().a(t, cVar);
            }
            z = resolveKeyPath.isEmpty() ? false : true;
        }
        if (z) {
            invalidateSelf();
            if (t == l.Ew) {
                setProgress(getProgress());
            }
        }
    }

    @Nullable
    public Bitmap updateBitmap(String str, @Nullable Bitmap bitmap) {
        com.baidu.live.lottie.b.b Nj = Nj();
        if (Nj == null) {
            Log.w("LOTTIE", "Cannot update bitmap. Most likely the drawable is not added to a View which prevents Lottie from getting a Context.");
            return null;
        }
        Bitmap updateBitmap = Nj.updateBitmap(str, bitmap);
        invalidateSelf();
        return updateBitmap;
    }

    @Nullable
    public Bitmap bj(String str) {
        com.baidu.live.lottie.b.b Nj = Nj();
        if (Nj != null) {
            return Nj.bn(str);
        }
        return null;
    }

    private com.baidu.live.lottie.b.b Nj() {
        if (getCallback() == null) {
            return null;
        }
        if (this.btC != null && !this.btC.G(getContext())) {
            this.btC.recycleBitmaps();
            this.btC = null;
        }
        if (this.btC == null) {
            this.btC = new com.baidu.live.lottie.b.b(getCallback(), this.Dj, this.btD, this.composition.hY());
        }
        return this.btC;
    }

    @Nullable
    public Typeface n(String str, String str2) {
        com.baidu.live.lottie.b.a Nk = Nk();
        if (Nk != null) {
            return Nk.n(str, str2);
        }
        return null;
    }

    private com.baidu.live.lottie.b.a Nk() {
        if (getCallback() == null) {
            return null;
        }
        if (this.btE == null) {
            this.btE = new com.baidu.live.lottie.b.a(getCallback(), this.btF);
        }
        return this.btE;
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
        return Math.min(canvas.getWidth() / this.composition.hQ().width(), canvas.getHeight() / this.composition.hQ().height());
    }
}
