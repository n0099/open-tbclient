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
/* loaded from: classes10.dex */
public class h extends Drawable implements Animatable, Drawable.Callback {
    private static final String TAG = h.class.getSimpleName();
    @Nullable
    private String BM;
    private boolean Cm;
    private boolean Co;
    @Nullable
    private com.baidu.live.lottie.b.b btm;
    @Nullable
    private c bto;
    @Nullable
    private com.baidu.live.lottie.b.a btp;
    @Nullable
    b btq;
    @Nullable
    s btr;
    @Nullable
    private com.baidu.live.lottie.model.layer.b bts;
    private e composition;
    private final Matrix matrix = new Matrix();
    private final com.baidu.live.lottie.d.c btl = new com.baidu.live.lottie.d.c();
    private float scale = 1.0f;
    private final Set<Object> Cf = new HashSet();
    private final ArrayList<a> Cg = new ArrayList<>();
    private int alpha = 255;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public interface a {
        void b(e eVar);
    }

    public h() {
        this.btl.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.live.lottie.h.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (h.this.bts != null) {
                    h.this.bts.setProgress(h.this.btl.ku());
                }
            }
        });
    }

    public boolean hasMasks() {
        return this.bts != null && this.bts.hasMasks();
    }

    public boolean hasMatte() {
        return this.bts != null && this.bts.hasMatte();
    }

    public boolean ie() {
        return this.Cm;
    }

    public void enableMergePathsForKitKatAndAbove(boolean z) {
        if (this.Cm != z) {
            if (Build.VERSION.SDK_INT < 19) {
                Log.w(TAG, "Merge paths are not supported pre-Kit Kat.");
                return;
            }
            this.Cm = z;
            if (this.composition != null) {
                m21if();
            }
        }
    }

    public boolean isMergePathsEnabledForKitKatAndAbove() {
        return this.Cm;
    }

    public void be(@Nullable String str) {
        this.BM = str;
    }

    @Nullable
    public String getImageAssetsFolder() {
        return this.BM;
    }

    public void recycleBitmaps() {
        if (this.btm != null) {
            this.btm.recycleBitmaps();
        }
    }

    public boolean a(e eVar) {
        if (this.composition == eVar) {
            return false;
        }
        clearComposition();
        this.composition = eVar;
        m21if();
        this.btl.setComposition(eVar);
        setProgress(this.btl.getAnimatedFraction());
        setScale(this.scale);
        ii();
        Iterator it = new ArrayList(this.Cg).iterator();
        while (it.hasNext()) {
            ((a) it.next()).b(eVar);
            it.remove();
        }
        this.Cg.clear();
        eVar.setPerformanceTrackingEnabled(this.Co);
        return true;
    }

    public void setPerformanceTrackingEnabled(boolean z) {
        this.Co = z;
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
    private void m21if() {
        this.bts = new com.baidu.live.lottie.model.layer.b(this, com.baidu.live.lottie.c.s.d(this.composition), this.composition.hW(), this.composition);
    }

    public void clearComposition() {
        recycleBitmaps();
        if (this.btl.isRunning()) {
            this.btl.cancel();
        }
        this.composition = null;
        this.bts = null;
        this.btm = null;
        this.btl.clearComposition();
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
        if (this.bts != null) {
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
            this.bts.c(canvas, this.matrix, this.alpha);
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
        if (this.bts == null) {
            this.Cg.add(new a() { // from class: com.baidu.live.lottie.h.5
                @Override // com.baidu.live.lottie.h.a
                public void b(e eVar) {
                    h.this.playAnimation();
                }
            });
        } else {
            this.btl.playAnimation();
        }
    }

    @MainThread
    public void endAnimation() {
        this.Cg.clear();
        this.btl.endAnimation();
    }

    @MainThread
    public void resumeAnimation() {
        if (this.bts == null) {
            this.Cg.add(new a() { // from class: com.baidu.live.lottie.h.6
                @Override // com.baidu.live.lottie.h.a
                public void b(e eVar) {
                    h.this.resumeAnimation();
                }
            });
        } else {
            this.btl.resumeAnimation();
        }
    }

    public void setMinFrame(final int i) {
        if (this.composition == null) {
            this.Cg.add(new a() { // from class: com.baidu.live.lottie.h.7
                @Override // com.baidu.live.lottie.h.a
                public void b(e eVar) {
                    h.this.setMinFrame(i);
                }
            });
        } else {
            this.btl.setMinFrame(i);
        }
    }

    public float getMinFrame() {
        return this.btl.getMinFrame();
    }

    public void setMinProgress(final float f) {
        if (this.composition == null) {
            this.Cg.add(new a() { // from class: com.baidu.live.lottie.h.8
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
            this.Cg.add(new a() { // from class: com.baidu.live.lottie.h.9
                @Override // com.baidu.live.lottie.h.a
                public void b(e eVar) {
                    h.this.setMaxFrame(i);
                }
            });
        } else {
            this.btl.setMaxFrame(i);
        }
    }

    public float getMaxFrame() {
        return this.btl.getMaxFrame();
    }

    public void setMaxProgress(@FloatRange(from = 0.0d, to = 1.0d) final float f) {
        if (this.composition == null) {
            this.Cg.add(new a() { // from class: com.baidu.live.lottie.h.10
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
            this.Cg.add(new a() { // from class: com.baidu.live.lottie.h.11
                @Override // com.baidu.live.lottie.h.a
                public void b(e eVar) {
                    h.this.setMinAndMaxFrame(i, i2);
                }
            });
        } else {
            this.btl.l(i, i2);
        }
    }

    public void setMinAndMaxProgress(@FloatRange(from = 0.0d, to = 1.0d) final float f, @FloatRange(from = 0.0d, to = 1.0d) final float f2) {
        if (this.composition == null) {
            this.Cg.add(new a() { // from class: com.baidu.live.lottie.h.12
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
        this.btl.reverseAnimationSpeed();
    }

    public void setSpeed(float f) {
        this.btl.setSpeed(f);
    }

    public float getSpeed() {
        return this.btl.getSpeed();
    }

    public void addAnimatorUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.btl.addUpdateListener(animatorUpdateListener);
    }

    public void a(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.btl.removeUpdateListener(animatorUpdateListener);
    }

    public void removeAllUpdateListeners() {
        this.btl.removeAllUpdateListeners();
    }

    public void addAnimatorListener(Animator.AnimatorListener animatorListener) {
        this.btl.addListener(animatorListener);
    }

    public void removeAnimatorListener(Animator.AnimatorListener animatorListener) {
        this.btl.removeListener(animatorListener);
    }

    public void removeAllAnimatorListeners() {
        this.btl.removeAllListeners();
    }

    public void setFrame(final int i) {
        if (this.composition == null) {
            this.Cg.add(new a() { // from class: com.baidu.live.lottie.h.2
                @Override // com.baidu.live.lottie.h.a
                public void b(e eVar) {
                    h.this.setFrame(i);
                }
            });
        } else {
            this.btl.setFrame(i);
        }
    }

    public int getFrame() {
        return (int) this.btl.kv();
    }

    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) final float f) {
        if (this.composition == null) {
            this.Cg.add(new a() { // from class: com.baidu.live.lottie.h.3
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
        this.btl.setRepeatMode(i);
    }

    public int getRepeatMode() {
        return this.btl.getRepeatMode();
    }

    public void setRepeatCount(int i) {
        this.btl.setRepeatCount(i);
    }

    public int getRepeatCount() {
        return this.btl.getRepeatCount();
    }

    public boolean isAnimating() {
        return this.btl.isRunning();
    }

    public void setScale(float f) {
        this.scale = f;
        ii();
    }

    public void setImageAssetDelegate(c cVar) {
        this.bto = cVar;
        if (this.btm != null) {
            this.btm.a(cVar);
        }
    }

    public void setFontAssetDelegate(b bVar) {
        this.btq = bVar;
        if (this.btp != null) {
            this.btp.a(bVar);
        }
    }

    public void setTextDelegate(s sVar) {
        this.btr = sVar;
    }

    @Nullable
    public s PC() {
        return this.btr;
    }

    public boolean ih() {
        return this.btr == null && this.composition.hX().size() > 0;
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
        this.Cg.clear();
        this.btl.cancel();
    }

    public void pauseAnimation() {
        this.Cg.clear();
        this.btl.pauseAnimation();
    }

    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    public float getProgress() {
        return this.btl.ku();
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
        if (this.bts == null) {
            Log.w("LOTTIE", "Cannot resolve KeyPath. Composition is not set yet.");
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        this.bts.a(eVar, 0, arrayList, new com.baidu.live.lottie.model.e(new String[0]));
        return arrayList;
    }

    public <T> void addValueCallback(final com.baidu.live.lottie.model.e eVar, final T t, final com.baidu.live.lottie.e.c<T> cVar) {
        boolean z = true;
        if (this.bts == null) {
            this.Cg.add(new a() { // from class: com.baidu.live.lottie.h.4
                @Override // com.baidu.live.lottie.h.a
                public void b(e eVar2) {
                    h.this.addValueCallback(eVar, t, cVar);
                }
            });
            return;
        }
        if (eVar.PN() != null) {
            eVar.PN().a(t, cVar);
        } else {
            List<com.baidu.live.lottie.model.e> resolveKeyPath = resolveKeyPath(eVar);
            for (int i = 0; i < resolveKeyPath.size(); i++) {
                resolveKeyPath.get(i).PN().a(t, cVar);
            }
            z = resolveKeyPath.isEmpty() ? false : true;
        }
        if (z) {
            invalidateSelf();
            if (t == l.Dc) {
                setProgress(getProgress());
            }
        }
    }

    @Nullable
    public Bitmap updateBitmap(String str, @Nullable Bitmap bitmap) {
        com.baidu.live.lottie.b.b PD = PD();
        if (PD == null) {
            Log.w("LOTTIE", "Cannot update bitmap. Most likely the drawable is not added to a View which prevents Lottie from getting a Context.");
            return null;
        }
        Bitmap updateBitmap = PD.updateBitmap(str, bitmap);
        invalidateSelf();
        return updateBitmap;
    }

    @Nullable
    public Bitmap bf(String str) {
        com.baidu.live.lottie.b.b PD = PD();
        if (PD != null) {
            return PD.bj(str);
        }
        return null;
    }

    private com.baidu.live.lottie.b.b PD() {
        if (getCallback() == null) {
            return null;
        }
        if (this.btm != null && !this.btm.H(getContext())) {
            this.btm.recycleBitmaps();
            this.btm = null;
        }
        if (this.btm == null) {
            this.btm = new com.baidu.live.lottie.b.b(getCallback(), this.BM, this.bto, this.composition.hZ());
        }
        return this.btm;
    }

    @Nullable
    public Typeface q(String str, String str2) {
        com.baidu.live.lottie.b.a PE = PE();
        if (PE != null) {
            return PE.q(str, str2);
        }
        return null;
    }

    private com.baidu.live.lottie.b.a PE() {
        if (getCallback() == null) {
            return null;
        }
        if (this.btp == null) {
            this.btp = new com.baidu.live.lottie.b.a(getCallback(), this.btq);
        }
        return this.btp;
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
