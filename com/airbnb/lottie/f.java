package com.airbnb.lottie;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.FloatRange;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import com.airbnb.lottie.model.layer.Layer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
/* loaded from: classes2.dex */
public class f extends Drawable implements Drawable.Callback {
    private static final String TAG = f.class.getSimpleName();
    @Nullable
    private com.airbnb.lottie.b.b kJ;
    @Nullable
    private c kK;
    @Nullable
    private com.airbnb.lottie.b.a kL;
    @Nullable
    com.airbnb.lottie.b kM;
    @Nullable
    l kN;
    private boolean kO;
    @Nullable
    private com.airbnb.lottie.model.layer.b kP;
    private boolean kQ;
    private e kg;
    @Nullable
    private String kn;
    private final Matrix matrix = new Matrix();
    private final com.airbnb.lottie.c.c kG = new com.airbnb.lottie.c.c();
    private float scale = 1.0f;
    private final Set<a> kH = new HashSet();
    private final ArrayList<b> kI = new ArrayList<>();
    private int alpha = 255;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public interface b {
        void i(e eVar);
    }

    public f() {
        this.kG.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.airbnb.lottie.f.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (f.this.kP != null) {
                    f.this.kP.setProgress(f.this.kG.dB());
                }
            }
        });
    }

    public boolean bq() {
        return this.kO;
    }

    public void j(boolean z) {
        if (Build.VERSION.SDK_INT < 19) {
            Log.w(TAG, "Merge paths are not supported pre-Kit Kat.");
            return;
        }
        this.kO = z;
        if (this.kg != null) {
            br();
        }
    }

    public void G(@Nullable String str) {
        this.kn = str;
    }

    @Nullable
    public String getImageAssetsFolder() {
        return this.kn;
    }

    public void aY() {
        if (this.kJ != null) {
            this.kJ.aY();
        }
    }

    public boolean h(e eVar) {
        if (this.kg == eVar) {
            return false;
        }
        bt();
        this.kg = eVar;
        br();
        this.kG.h(eVar.getDuration());
        setProgress(this.kG.dB());
        setScale(this.scale);
        by();
        bs();
        Iterator it = new ArrayList(this.kI).iterator();
        while (it.hasNext()) {
            ((b) it.next()).i(eVar);
            it.remove();
        }
        this.kI.clear();
        eVar.setPerformanceTrackingEnabled(this.kQ);
        return true;
    }

    public void setPerformanceTrackingEnabled(boolean z) {
        this.kQ = z;
        if (this.kg != null) {
            this.kg.setPerformanceTrackingEnabled(z);
        }
    }

    @Nullable
    public i getPerformanceTracker() {
        if (this.kg != null) {
            return this.kg.getPerformanceTracker();
        }
        return null;
    }

    private void br() {
        this.kP = new com.airbnb.lottie.model.layer.b(this, Layer.a.k(this.kg), this.kg.bk(), this.kg);
    }

    private void bs() {
        if (this.kP != null) {
            for (a aVar : this.kH) {
                this.kP.b(aVar.kV, aVar.kW, aVar.kX);
            }
        }
    }

    public void bt() {
        aY();
        if (this.kG.isRunning()) {
            this.kG.cancel();
        }
        this.kg = null;
        this.kP = null;
        this.kJ = null;
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

    public void a(ColorFilter colorFilter) {
        a(null, null, colorFilter);
    }

    private void a(@Nullable String str, @Nullable String str2, @Nullable ColorFilter colorFilter) {
        a aVar = new a(str, str2, colorFilter);
        if (colorFilter == null && this.kH.contains(aVar)) {
            this.kH.remove(aVar);
        } else {
            this.kH.add(new a(str, str2, colorFilter));
        }
        if (this.kP != null) {
            this.kP.b(str, str2, colorFilter);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        float f;
        d.beginSection("Drawable#draw");
        if (this.kP != null) {
            float f2 = this.scale;
            float e = e(canvas);
            if (f2 > e) {
                f = this.scale / e;
            } else {
                e = f2;
                f = 1.0f;
            }
            if (f > 1.0f) {
                canvas.save();
                float width = this.kg.getBounds().width() / 2.0f;
                float height = this.kg.getBounds().height() / 2.0f;
                float f3 = width * e;
                float f4 = height * e;
                canvas.translate((width * getScale()) - f3, (height * getScale()) - f4);
                canvas.scale(f, f, f3, f4);
            }
            this.matrix.reset();
            this.matrix.preScale(e, e);
            this.kP.a(canvas, this.matrix, this.alpha);
            d.D("Drawable#draw");
            if (f > 1.0f) {
                canvas.restore();
            }
        }
    }

    public void ba() {
        if (this.kP == null) {
            this.kI.add(new b() { // from class: com.airbnb.lottie.f.2
                @Override // com.airbnb.lottie.f.b
                public void i(e eVar) {
                    f.this.ba();
                }
            });
        } else {
            this.kG.ba();
        }
    }

    public void setMinFrame(final int i) {
        if (this.kg == null) {
            this.kI.add(new b() { // from class: com.airbnb.lottie.f.3
                @Override // com.airbnb.lottie.f.b
                public void i(e eVar) {
                    f.this.setMinFrame(i);
                }
            });
        } else {
            setMinProgress(i / this.kg.bo());
        }
    }

    public void setMinProgress(float f) {
        this.kG.m(f);
    }

    public void setMaxFrame(final int i) {
        if (this.kg == null) {
            this.kI.add(new b() { // from class: com.airbnb.lottie.f.4
                @Override // com.airbnb.lottie.f.b
                public void i(e eVar) {
                    f.this.setMaxFrame(i);
                }
            });
        } else {
            setMaxProgress(i / this.kg.bo());
        }
    }

    public void setMaxProgress(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        this.kG.n(f);
    }

    public void setMinAndMaxFrame(final int i, final int i2) {
        if (this.kg == null) {
            this.kI.add(new b() { // from class: com.airbnb.lottie.f.5
                @Override // com.airbnb.lottie.f.b
                public void i(e eVar) {
                    f.this.setMinAndMaxFrame(i, i2);
                }
            });
        } else {
            this.kG.g(i / this.kg.bo(), i2 / this.kg.bo());
        }
    }

    public void setMinAndMaxProgress(@FloatRange(from = 0.0d, to = 1.0d) float f, @FloatRange(from = 0.0d, to = 1.0d) float f2) {
        this.kG.g(f, f2);
    }

    public void setSpeed(float f) {
        this.kG.setSpeed(f);
    }

    public float getSpeed() {
        return this.kG.getSpeed();
    }

    public void a(Animator.AnimatorListener animatorListener) {
        this.kG.addListener(animatorListener);
    }

    public void setFrame(final int i) {
        if (this.kg == null) {
            this.kI.add(new b() { // from class: com.airbnb.lottie.f.6
                @Override // com.airbnb.lottie.f.b
                public void i(e eVar) {
                    f.this.setFrame(i);
                }
            });
        } else {
            setProgress(i / this.kg.bo());
        }
    }

    public int getFrame() {
        if (this.kg == null) {
            return 0;
        }
        return (int) (getProgress() * this.kg.bo());
    }

    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        this.kG.l(f);
        if (this.kP != null) {
            this.kP.setProgress(f);
        }
    }

    public void k(boolean z) {
        this.kG.setRepeatCount(z ? -1 : 0);
    }

    public boolean isLooping() {
        return this.kG.getRepeatCount() == -1;
    }

    public boolean isAnimating() {
        return this.kG.isRunning();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bu() {
        this.kG.bu();
    }

    public void setScale(float f) {
        this.scale = f;
        by();
    }

    public void setImageAssetDelegate(c cVar) {
        this.kK = cVar;
        if (this.kJ != null) {
            this.kJ.a(cVar);
        }
    }

    public void setFontAssetDelegate(com.airbnb.lottie.b bVar) {
        this.kM = bVar;
        if (this.kL != null) {
            this.kL.a(bVar);
        }
    }

    public void setTextDelegate(l lVar) {
        this.kN = lVar;
    }

    @Nullable
    public l bv() {
        return this.kN;
    }

    public boolean bw() {
        return this.kN == null && this.kg.bl().size() > 0;
    }

    public float getScale() {
        return this.scale;
    }

    public e bx() {
        return this.kg;
    }

    private void by() {
        if (this.kg != null) {
            float scale = getScale();
            setBounds(0, 0, (int) (this.kg.getBounds().width() * scale), (int) (scale * this.kg.getBounds().height()));
        }
    }

    public void bb() {
        this.kI.clear();
        this.kG.cancel();
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float getProgress() {
        return this.kG.dB();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        if (this.kg == null) {
            return -1;
        }
        return (int) (this.kg.getBounds().width() * getScale());
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        if (this.kg == null) {
            return -1;
        }
        return (int) (this.kg.getBounds().height() * getScale());
    }

    @Nullable
    public Bitmap H(String str) {
        com.airbnb.lottie.b.b bz = bz();
        if (bz != null) {
            return bz.L(str);
        }
        return null;
    }

    private com.airbnb.lottie.b.b bz() {
        if (getCallback() == null) {
            return null;
        }
        if (this.kJ != null && !this.kJ.R(getContext())) {
            this.kJ.aY();
            this.kJ = null;
        }
        if (this.kJ == null) {
            this.kJ = new com.airbnb.lottie.b.b(getCallback(), this.kn, this.kK, this.kg.bn());
        }
        return this.kJ;
    }

    @Nullable
    public Typeface g(String str, String str2) {
        com.airbnb.lottie.b.a bA = bA();
        if (bA != null) {
            return bA.g(str, str2);
        }
        return null;
    }

    private com.airbnb.lottie.b.a bA() {
        if (getCallback() == null) {
            return null;
        }
        if (this.kL == null) {
            this.kL = new com.airbnb.lottie.b.a(getCallback(), this.kM);
        }
        return this.kL;
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
        return Math.min(canvas.getWidth() / this.kg.getBounds().width(), canvas.getHeight() / this.kg.getBounds().height());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a {
        final String kV;
        @Nullable
        final String kW;
        @Nullable
        final ColorFilter kX;

        a(@Nullable String str, @Nullable String str2, @Nullable ColorFilter colorFilter) {
            this.kV = str;
            this.kW = str2;
            this.kX = colorFilter;
        }

        public int hashCode() {
            int i = 17;
            if (this.kV != null) {
                i = this.kV.hashCode() * 527;
            }
            if (this.kW != null) {
                return i * 31 * this.kW.hashCode();
            }
            return i;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof a) {
                a aVar = (a) obj;
                return hashCode() == aVar.hashCode() && this.kX == aVar.kX;
            }
            return false;
        }
    }
}
