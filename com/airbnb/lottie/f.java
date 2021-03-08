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
/* loaded from: classes5.dex */
public class f extends Drawable implements Animatable, Drawable.Callback {
    private static final String TAG = f.class.getSimpleName();
    @Nullable
    private com.airbnb.lottie.b.b DE;
    @Nullable
    private b DG;
    @Nullable
    private com.airbnb.lottie.b.a DH;
    @Nullable
    com.airbnb.lottie.a DI;
    @Nullable
    p DJ;
    private boolean DK;
    @Nullable
    private com.airbnb.lottie.model.layer.b DM;
    private boolean DN;
    private d Dh;
    @Nullable
    private String Dj;
    private final Matrix matrix = new Matrix();
    private final com.airbnb.lottie.d.c DA = new com.airbnb.lottie.d.c();
    private float scale = 1.0f;
    private final Set<Object> DC = new HashSet();
    private final ArrayList<a> DD = new ArrayList<>();
    private int alpha = 255;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public interface a {
        void c(d dVar);
    }

    public f() {
        this.DA.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.airbnb.lottie.f.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (f.this.DM != null) {
                    f.this.DM.setProgress(f.this.DA.kt());
                }
            }
        });
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
            if (this.Dh != null) {
                ie();
            }
        }
    }

    public void bi(@Nullable String str) {
        this.Dj = str;
    }

    @Nullable
    public String getImageAssetsFolder() {
        return this.Dj;
    }

    public void recycleBitmaps() {
        if (this.DE != null) {
            this.DE.recycleBitmaps();
        }
    }

    public boolean b(d dVar) {
        if (this.Dh == dVar) {
            return false;
        }
        clearComposition();
        this.Dh = dVar;
        ie();
        this.DA.setComposition(dVar);
        setProgress(this.DA.getAnimatedFraction());
        setScale(this.scale);
        ih();
        Iterator it = new ArrayList(this.DD).iterator();
        while (it.hasNext()) {
            ((a) it.next()).c(dVar);
            it.remove();
        }
        this.DD.clear();
        dVar.setPerformanceTrackingEnabled(this.DN);
        return true;
    }

    public void setPerformanceTrackingEnabled(boolean z) {
        this.DN = z;
        if (this.Dh != null) {
            this.Dh.setPerformanceTrackingEnabled(z);
        }
    }

    @Nullable
    public m getPerformanceTracker() {
        if (this.Dh != null) {
            return this.Dh.getPerformanceTracker();
        }
        return null;
    }

    private void ie() {
        this.DM = new com.airbnb.lottie.model.layer.b(this, s.e(this.Dh), this.Dh.hV(), this.Dh);
    }

    public void clearComposition() {
        recycleBitmaps();
        if (this.DA.isRunning()) {
            this.DA.cancel();
        }
        this.Dh = null;
        this.DM = null;
        this.DE = null;
        this.DA.clearComposition();
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
        if (this.DM != null) {
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
                float width = this.Dh.hQ().width() / 2.0f;
                float height = this.Dh.hQ().height() / 2.0f;
                float f3 = width * e;
                float f4 = height * e;
                canvas.translate((width * getScale()) - f3, (height * getScale()) - f4);
                canvas.scale(f, f, f3, f4);
            }
            this.matrix.reset();
            this.matrix.preScale(e, e);
            this.DM.c(canvas, this.matrix, this.alpha);
            c.bf("Drawable#draw");
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
        if (this.DM == null) {
            this.DD.add(new a() { // from class: com.airbnb.lottie.f.5
                @Override // com.airbnb.lottie.f.a
                public void c(d dVar) {
                    f.this.playAnimation();
                }
            });
        } else {
            this.DA.playAnimation();
        }
    }

    @MainThread
    public void endAnimation() {
        this.DD.clear();
        this.DA.endAnimation();
    }

    @MainThread
    public void resumeAnimation() {
        if (this.DM == null) {
            this.DD.add(new a() { // from class: com.airbnb.lottie.f.6
                @Override // com.airbnb.lottie.f.a
                public void c(d dVar) {
                    f.this.resumeAnimation();
                }
            });
        } else {
            this.DA.resumeAnimation();
        }
    }

    public void setMinFrame(final int i) {
        if (this.Dh == null) {
            this.DD.add(new a() { // from class: com.airbnb.lottie.f.7
                @Override // com.airbnb.lottie.f.a
                public void c(d dVar) {
                    f.this.setMinFrame(i);
                }
            });
        } else {
            this.DA.setMinFrame(i);
        }
    }

    public float getMinFrame() {
        return this.DA.getMinFrame();
    }

    public void setMinProgress(final float f) {
        if (this.Dh == null) {
            this.DD.add(new a() { // from class: com.airbnb.lottie.f.8
                @Override // com.airbnb.lottie.f.a
                public void c(d dVar) {
                    f.this.setMinProgress(f);
                }
            });
        } else {
            setMinFrame((int) com.airbnb.lottie.d.e.lerp(this.Dh.hS(), this.Dh.hT(), f));
        }
    }

    public void setMaxFrame(final int i) {
        if (this.Dh == null) {
            this.DD.add(new a() { // from class: com.airbnb.lottie.f.9
                @Override // com.airbnb.lottie.f.a
                public void c(d dVar) {
                    f.this.setMaxFrame(i);
                }
            });
        } else {
            this.DA.setMaxFrame(i);
        }
    }

    public float getMaxFrame() {
        return this.DA.getMaxFrame();
    }

    public void setMaxProgress(@FloatRange(from = 0.0d, to = 1.0d) final float f) {
        if (this.Dh == null) {
            this.DD.add(new a() { // from class: com.airbnb.lottie.f.10
                @Override // com.airbnb.lottie.f.a
                public void c(d dVar) {
                    f.this.setMaxProgress(f);
                }
            });
        } else {
            setMaxFrame((int) com.airbnb.lottie.d.e.lerp(this.Dh.hS(), this.Dh.hT(), f));
        }
    }

    public void setMinAndMaxFrame(final int i, final int i2) {
        if (this.Dh == null) {
            this.DD.add(new a() { // from class: com.airbnb.lottie.f.11
                @Override // com.airbnb.lottie.f.a
                public void c(d dVar) {
                    f.this.setMinAndMaxFrame(i, i2);
                }
            });
        } else {
            this.DA.l(i, i2);
        }
    }

    public void setMinAndMaxProgress(@FloatRange(from = 0.0d, to = 1.0d) final float f, @FloatRange(from = 0.0d, to = 1.0d) final float f2) {
        if (this.Dh == null) {
            this.DD.add(new a() { // from class: com.airbnb.lottie.f.12
                @Override // com.airbnb.lottie.f.a
                public void c(d dVar) {
                    f.this.setMinAndMaxProgress(f, f2);
                }
            });
        } else {
            setMinAndMaxFrame((int) com.airbnb.lottie.d.e.lerp(this.Dh.hS(), this.Dh.hT(), f), (int) com.airbnb.lottie.d.e.lerp(this.Dh.hS(), this.Dh.hT(), f2));
        }
    }

    public void setSpeed(float f) {
        this.DA.setSpeed(f);
    }

    public float getSpeed() {
        return this.DA.getSpeed();
    }

    public void addAnimatorUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.DA.addUpdateListener(animatorUpdateListener);
    }

    public void a(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.DA.removeUpdateListener(animatorUpdateListener);
    }

    public void addAnimatorListener(Animator.AnimatorListener animatorListener) {
        this.DA.addListener(animatorListener);
    }

    public void removeAnimatorListener(Animator.AnimatorListener animatorListener) {
        this.DA.removeListener(animatorListener);
    }

    public void removeAllAnimatorListeners() {
        this.DA.removeAllListeners();
    }

    public void setFrame(final int i) {
        if (this.Dh == null) {
            this.DD.add(new a() { // from class: com.airbnb.lottie.f.2
                @Override // com.airbnb.lottie.f.a
                public void c(d dVar) {
                    f.this.setFrame(i);
                }
            });
        } else {
            this.DA.setFrame(i);
        }
    }

    public int getFrame() {
        return (int) this.DA.ku();
    }

    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) final float f) {
        if (this.Dh == null) {
            this.DD.add(new a() { // from class: com.airbnb.lottie.f.3
                @Override // com.airbnb.lottie.f.a
                public void c(d dVar) {
                    f.this.setProgress(f);
                }
            });
        } else {
            setFrame((int) com.airbnb.lottie.d.e.lerp(this.Dh.hS(), this.Dh.hT(), f));
        }
    }

    public void setRepeatMode(int i) {
        this.DA.setRepeatMode(i);
    }

    public int getRepeatMode() {
        return this.DA.getRepeatMode();
    }

    public void setRepeatCount(int i) {
        this.DA.setRepeatCount(i);
    }

    public int getRepeatCount() {
        return this.DA.getRepeatCount();
    }

    public boolean isAnimating() {
        return this.DA.isRunning();
    }

    public void setScale(float f) {
        this.scale = f;
        ih();
    }

    public void setImageAssetDelegate(b bVar) {
        this.DG = bVar;
        if (this.DE != null) {
            this.DE.a(bVar);
        }
    }

    public void setFontAssetDelegate(com.airbnb.lottie.a aVar) {
        this.DI = aVar;
        if (this.DH != null) {
            this.DH.a(aVar);
        }
    }

    public void setTextDelegate(p pVar) {
        this.DJ = pVar;
    }

    @Nullable
    /* renamed from: if  reason: not valid java name */
    public p m6if() {
        return this.DJ;
    }

    public boolean ig() {
        return this.DJ == null && this.Dh.hW().size() > 0;
    }

    public float getScale() {
        return this.scale;
    }

    public d getComposition() {
        return this.Dh;
    }

    private void ih() {
        if (this.Dh != null) {
            float scale = getScale();
            setBounds(0, 0, (int) (this.Dh.hQ().width() * scale), (int) (scale * this.Dh.hQ().height()));
        }
    }

    public void cancelAnimation() {
        this.DD.clear();
        this.DA.cancel();
    }

    public void pauseAnimation() {
        this.DD.clear();
        this.DA.pauseAnimation();
    }

    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    public float getProgress() {
        return this.DA.kt();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        if (this.Dh == null) {
            return -1;
        }
        return (int) (this.Dh.hQ().width() * getScale());
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        if (this.Dh == null) {
            return -1;
        }
        return (int) (this.Dh.hQ().height() * getScale());
    }

    public List<com.airbnb.lottie.model.e> a(com.airbnb.lottie.model.e eVar) {
        if (this.DM == null) {
            Log.w("LOTTIE", "Cannot resolve KeyPath. Composition is not set yet.");
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        this.DM.a(eVar, 0, arrayList, new com.airbnb.lottie.model.e(new String[0]));
        return arrayList;
    }

    public <T> void a(final com.airbnb.lottie.model.e eVar, final T t, final com.airbnb.lottie.e.c<T> cVar) {
        boolean z = true;
        if (this.DM == null) {
            this.DD.add(new a() { // from class: com.airbnb.lottie.f.4
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
            if (t == j.Ew) {
                setProgress(getProgress());
            }
        }
    }

    @Nullable
    public Bitmap bj(String str) {
        com.airbnb.lottie.b.b ii = ii();
        if (ii != null) {
            return ii.bn(str);
        }
        return null;
    }

    private com.airbnb.lottie.b.b ii() {
        if (getCallback() == null) {
            return null;
        }
        if (this.DE != null && !this.DE.G(getContext())) {
            this.DE.recycleBitmaps();
            this.DE = null;
        }
        if (this.DE == null) {
            this.DE = new com.airbnb.lottie.b.b(getCallback(), this.Dj, this.DG, this.Dh.hY());
        }
        return this.DE;
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
        if (this.DH == null) {
            this.DH = new com.airbnb.lottie.b.a(getCallback(), this.DI);
        }
        return this.DH;
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
        return Math.min(canvas.getWidth() / this.Dh.hQ().width(), canvas.getHeight() / this.Dh.hQ().height());
    }
}
