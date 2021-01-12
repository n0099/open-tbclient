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
    @Nullable
    private String BK;
    private boolean Ck;
    private boolean Cm;
    @Nullable
    private com.baidu.live.lottie.b.b boA;
    @Nullable
    private c boB;
    @Nullable
    private com.baidu.live.lottie.b.a boC;
    @Nullable
    b boD;
    @Nullable
    s boE;
    @Nullable
    private com.baidu.live.lottie.model.layer.b boF;
    private e composition;
    private final Matrix matrix = new Matrix();
    private final com.baidu.live.lottie.d.c boz = new com.baidu.live.lottie.d.c();
    private float scale = 1.0f;
    private final Set<Object> Cd = new HashSet();
    private final ArrayList<a> Ce = new ArrayList<>();
    private int alpha = 255;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public interface a {
        void b(e eVar);
    }

    public h() {
        this.boz.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.live.lottie.h.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (h.this.boF != null) {
                    h.this.boF.setProgress(h.this.boz.ku());
                }
            }
        });
    }

    public boolean hasMasks() {
        return this.boF != null && this.boF.hasMasks();
    }

    public boolean hasMatte() {
        return this.boF != null && this.boF.hasMatte();
    }

    public boolean ie() {
        return this.Ck;
    }

    public void enableMergePathsForKitKatAndAbove(boolean z) {
        if (this.Ck != z) {
            if (Build.VERSION.SDK_INT < 19) {
                Log.w(TAG, "Merge paths are not supported pre-Kit Kat.");
                return;
            }
            this.Ck = z;
            if (this.composition != null) {
                m20if();
            }
        }
    }

    public boolean isMergePathsEnabledForKitKatAndAbove() {
        return this.Ck;
    }

    public void be(@Nullable String str) {
        this.BK = str;
    }

    @Nullable
    public String getImageAssetsFolder() {
        return this.BK;
    }

    public void recycleBitmaps() {
        if (this.boA != null) {
            this.boA.recycleBitmaps();
        }
    }

    public boolean a(e eVar) {
        if (this.composition == eVar) {
            return false;
        }
        clearComposition();
        this.composition = eVar;
        m20if();
        this.boz.setComposition(eVar);
        setProgress(this.boz.getAnimatedFraction());
        setScale(this.scale);
        ii();
        Iterator it = new ArrayList(this.Ce).iterator();
        while (it.hasNext()) {
            ((a) it.next()).b(eVar);
            it.remove();
        }
        this.Ce.clear();
        eVar.setPerformanceTrackingEnabled(this.Cm);
        return true;
    }

    public void setPerformanceTrackingEnabled(boolean z) {
        this.Cm = z;
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

    /* renamed from: if  reason: not valid java name */
    private void m20if() {
        this.boF = new com.baidu.live.lottie.model.layer.b(this, com.baidu.live.lottie.c.s.d(this.composition), this.composition.hW(), this.composition);
    }

    public void clearComposition() {
        recycleBitmaps();
        if (this.boz.isRunning()) {
            this.boz.cancel();
        }
        this.composition = null;
        this.boF = null;
        this.boA = null;
        this.boz.clearComposition();
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
        if (this.boF != null) {
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
                float width = this.composition.hR().width() / 2.0f;
                float height = this.composition.hR().height() / 2.0f;
                float f3 = width * e;
                float f4 = height * e;
                canvas.translate((width * getScale()) - f3, (height * getScale()) - f4);
                canvas.scale(f, f, f3, f4);
            }
            this.matrix.reset();
            this.matrix.preScale(e, e);
            this.boF.c(canvas, this.matrix, this.alpha);
            d.bb("Drawable#draw");
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
        if (this.boF == null) {
            this.Ce.add(new a() { // from class: com.baidu.live.lottie.h.5
                @Override // com.baidu.live.lottie.h.a
                public void b(e eVar) {
                    h.this.playAnimation();
                }
            });
        } else {
            this.boz.playAnimation();
        }
    }

    @MainThread
    public void endAnimation() {
        this.Ce.clear();
        this.boz.endAnimation();
    }

    @MainThread
    public void resumeAnimation() {
        if (this.boF == null) {
            this.Ce.add(new a() { // from class: com.baidu.live.lottie.h.6
                @Override // com.baidu.live.lottie.h.a
                public void b(e eVar) {
                    h.this.resumeAnimation();
                }
            });
        } else {
            this.boz.resumeAnimation();
        }
    }

    public void setMinFrame(final int i) {
        if (this.composition == null) {
            this.Ce.add(new a() { // from class: com.baidu.live.lottie.h.7
                @Override // com.baidu.live.lottie.h.a
                public void b(e eVar) {
                    h.this.setMinFrame(i);
                }
            });
        } else {
            this.boz.setMinFrame(i);
        }
    }

    public float getMinFrame() {
        return this.boz.getMinFrame();
    }

    public void setMinProgress(final float f) {
        if (this.composition == null) {
            this.Ce.add(new a() { // from class: com.baidu.live.lottie.h.8
                @Override // com.baidu.live.lottie.h.a
                public void b(e eVar) {
                    h.this.setMinProgress(f);
                }
            });
        } else {
            setMinFrame((int) com.baidu.live.lottie.d.e.lerp(this.composition.hT(), this.composition.hU(), f));
        }
    }

    public void setMaxFrame(final int i) {
        if (this.composition == null) {
            this.Ce.add(new a() { // from class: com.baidu.live.lottie.h.9
                @Override // com.baidu.live.lottie.h.a
                public void b(e eVar) {
                    h.this.setMaxFrame(i);
                }
            });
        } else {
            this.boz.setMaxFrame(i);
        }
    }

    public float getMaxFrame() {
        return this.boz.getMaxFrame();
    }

    public void setMaxProgress(@FloatRange(from = 0.0d, to = 1.0d) final float f) {
        if (this.composition == null) {
            this.Ce.add(new a() { // from class: com.baidu.live.lottie.h.10
                @Override // com.baidu.live.lottie.h.a
                public void b(e eVar) {
                    h.this.setMaxProgress(f);
                }
            });
        } else {
            setMaxFrame((int) com.baidu.live.lottie.d.e.lerp(this.composition.hT(), this.composition.hU(), f));
        }
    }

    public void setMinAndMaxFrame(final int i, final int i2) {
        if (this.composition == null) {
            this.Ce.add(new a() { // from class: com.baidu.live.lottie.h.11
                @Override // com.baidu.live.lottie.h.a
                public void b(e eVar) {
                    h.this.setMinAndMaxFrame(i, i2);
                }
            });
        } else {
            this.boz.l(i, i2);
        }
    }

    public void setMinAndMaxProgress(@FloatRange(from = 0.0d, to = 1.0d) final float f, @FloatRange(from = 0.0d, to = 1.0d) final float f2) {
        if (this.composition == null) {
            this.Ce.add(new a() { // from class: com.baidu.live.lottie.h.12
                @Override // com.baidu.live.lottie.h.a
                public void b(e eVar) {
                    h.this.setMinAndMaxProgress(f, f2);
                }
            });
        } else {
            setMinAndMaxFrame((int) com.baidu.live.lottie.d.e.lerp(this.composition.hT(), this.composition.hU(), f), (int) com.baidu.live.lottie.d.e.lerp(this.composition.hT(), this.composition.hU(), f2));
        }
    }

    public void reverseAnimationSpeed() {
        this.boz.reverseAnimationSpeed();
    }

    public void setSpeed(float f) {
        this.boz.setSpeed(f);
    }

    public float getSpeed() {
        return this.boz.getSpeed();
    }

    public void addAnimatorUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.boz.addUpdateListener(animatorUpdateListener);
    }

    public void a(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.boz.removeUpdateListener(animatorUpdateListener);
    }

    public void removeAllUpdateListeners() {
        this.boz.removeAllUpdateListeners();
    }

    public void addAnimatorListener(Animator.AnimatorListener animatorListener) {
        this.boz.addListener(animatorListener);
    }

    public void removeAnimatorListener(Animator.AnimatorListener animatorListener) {
        this.boz.removeListener(animatorListener);
    }

    public void removeAllAnimatorListeners() {
        this.boz.removeAllListeners();
    }

    public void setFrame(final int i) {
        if (this.composition == null) {
            this.Ce.add(new a() { // from class: com.baidu.live.lottie.h.2
                @Override // com.baidu.live.lottie.h.a
                public void b(e eVar) {
                    h.this.setFrame(i);
                }
            });
        } else {
            this.boz.setFrame(i);
        }
    }

    public int getFrame() {
        return (int) this.boz.kv();
    }

    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) final float f) {
        if (this.composition == null) {
            this.Ce.add(new a() { // from class: com.baidu.live.lottie.h.3
                @Override // com.baidu.live.lottie.h.a
                public void b(e eVar) {
                    h.this.setProgress(f);
                }
            });
        } else {
            setFrame((int) com.baidu.live.lottie.d.e.lerp(this.composition.hT(), this.composition.hU(), f));
        }
    }

    public void setRepeatMode(int i) {
        this.boz.setRepeatMode(i);
    }

    public int getRepeatMode() {
        return this.boz.getRepeatMode();
    }

    public void setRepeatCount(int i) {
        this.boz.setRepeatCount(i);
    }

    public int getRepeatCount() {
        return this.boz.getRepeatCount();
    }

    public boolean isAnimating() {
        return this.boz.isRunning();
    }

    public void setScale(float f) {
        this.scale = f;
        ii();
    }

    public void setImageAssetDelegate(c cVar) {
        this.boB = cVar;
        if (this.boA != null) {
            this.boA.a(cVar);
        }
    }

    public void setFontAssetDelegate(b bVar) {
        this.boD = bVar;
        if (this.boC != null) {
            this.boC.a(bVar);
        }
    }

    public void setTextDelegate(s sVar) {
        this.boE = sVar;
    }

    @Nullable
    public s LH() {
        return this.boE;
    }

    public boolean ih() {
        return this.boE == null && this.composition.hX().size() > 0;
    }

    public float getScale() {
        return this.scale;
    }

    public e getComposition() {
        return this.composition;
    }

    private void ii() {
        if (this.composition != null) {
            float scale = getScale();
            setBounds(0, 0, (int) (this.composition.hR().width() * scale), (int) (scale * this.composition.hR().height()));
        }
    }

    public void cancelAnimation() {
        this.Ce.clear();
        this.boz.cancel();
    }

    public void pauseAnimation() {
        this.Ce.clear();
        this.boz.pauseAnimation();
    }

    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    public float getProgress() {
        return this.boz.ku();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        if (this.composition == null) {
            return -1;
        }
        return (int) (this.composition.hR().width() * getScale());
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        if (this.composition == null) {
            return -1;
        }
        return (int) (this.composition.hR().height() * getScale());
    }

    public List<com.baidu.live.lottie.model.e> resolveKeyPath(com.baidu.live.lottie.model.e eVar) {
        if (this.boF == null) {
            Log.w("LOTTIE", "Cannot resolve KeyPath. Composition is not set yet.");
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        this.boF.a(eVar, 0, arrayList, new com.baidu.live.lottie.model.e(new String[0]));
        return arrayList;
    }

    public <T> void addValueCallback(final com.baidu.live.lottie.model.e eVar, final T t, final com.baidu.live.lottie.e.c<T> cVar) {
        boolean z = true;
        if (this.boF == null) {
            this.Ce.add(new a() { // from class: com.baidu.live.lottie.h.4
                @Override // com.baidu.live.lottie.h.a
                public void b(e eVar2) {
                    h.this.addValueCallback(eVar, t, cVar);
                }
            });
            return;
        }
        if (eVar.LS() != null) {
            eVar.LS().a(t, cVar);
        } else {
            List<com.baidu.live.lottie.model.e> resolveKeyPath = resolveKeyPath(eVar);
            for (int i = 0; i < resolveKeyPath.size(); i++) {
                resolveKeyPath.get(i).LS().a(t, cVar);
            }
            z = resolveKeyPath.isEmpty() ? false : true;
        }
        if (z) {
            invalidateSelf();
            if (t == l.Da) {
                setProgress(getProgress());
            }
        }
    }

    @Nullable
    public Bitmap updateBitmap(String str, @Nullable Bitmap bitmap) {
        com.baidu.live.lottie.b.b LI = LI();
        if (LI == null) {
            Log.w("LOTTIE", "Cannot update bitmap. Most likely the drawable is not added to a View which prevents Lottie from getting a Context.");
            return null;
        }
        Bitmap updateBitmap = LI.updateBitmap(str, bitmap);
        invalidateSelf();
        return updateBitmap;
    }

    @Nullable
    public Bitmap bf(String str) {
        com.baidu.live.lottie.b.b LI = LI();
        if (LI != null) {
            return LI.bj(str);
        }
        return null;
    }

    private com.baidu.live.lottie.b.b LI() {
        if (getCallback() == null) {
            return null;
        }
        if (this.boA != null && !this.boA.H(getContext())) {
            this.boA.recycleBitmaps();
            this.boA = null;
        }
        if (this.boA == null) {
            this.boA = new com.baidu.live.lottie.b.b(getCallback(), this.BK, this.boB, this.composition.hZ());
        }
        return this.boA;
    }

    @Nullable
    public Typeface q(String str, String str2) {
        com.baidu.live.lottie.b.a LJ = LJ();
        if (LJ != null) {
            return LJ.q(str, str2);
        }
        return null;
    }

    private com.baidu.live.lottie.b.a LJ() {
        if (getCallback() == null) {
            return null;
        }
        if (this.boC == null) {
            this.boC = new com.baidu.live.lottie.b.a(getCallback(), this.boD);
        }
        return this.boC;
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
        return Math.min(canvas.getWidth() / this.composition.hR().width(), canvas.getHeight() / this.composition.hR().height());
    }
}
