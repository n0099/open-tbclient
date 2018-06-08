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
    private com.airbnb.lottie.b.b kK;
    @Nullable
    private c kL;
    @Nullable
    private com.airbnb.lottie.b.a kM;
    @Nullable
    com.airbnb.lottie.b kN;
    @Nullable
    l kO;
    private boolean kP;
    @Nullable
    private com.airbnb.lottie.model.layer.b kQ;
    private boolean kR;
    private e kg;
    @Nullable
    private String ko;
    private final Matrix matrix = new Matrix();
    private final com.airbnb.lottie.c.c kH = new com.airbnb.lottie.c.c();
    private float scale = 1.0f;
    private final Set<a> kI = new HashSet();
    private final ArrayList<b> kJ = new ArrayList<>();
    private int alpha = 255;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public interface b {
        void i(e eVar);
    }

    public f() {
        this.kH.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.airbnb.lottie.f.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (f.this.kQ != null) {
                    f.this.kQ.setProgress(f.this.kH.dB());
                }
            }
        });
    }

    public boolean bq() {
        return this.kP;
    }

    public void j(boolean z) {
        if (Build.VERSION.SDK_INT < 19) {
            Log.w(TAG, "Merge paths are not supported pre-Kit Kat.");
            return;
        }
        this.kP = z;
        if (this.kg != null) {
            br();
        }
    }

    public void G(@Nullable String str) {
        this.ko = str;
    }

    @Nullable
    public String getImageAssetsFolder() {
        return this.ko;
    }

    public void aY() {
        if (this.kK != null) {
            this.kK.aY();
        }
    }

    public boolean h(e eVar) {
        if (this.kg == eVar) {
            return false;
        }
        bt();
        this.kg = eVar;
        br();
        this.kH.h(eVar.getDuration());
        setProgress(this.kH.dB());
        setScale(this.scale);
        by();
        bs();
        Iterator it = new ArrayList(this.kJ).iterator();
        while (it.hasNext()) {
            ((b) it.next()).i(eVar);
            it.remove();
        }
        this.kJ.clear();
        eVar.setPerformanceTrackingEnabled(this.kR);
        return true;
    }

    public void setPerformanceTrackingEnabled(boolean z) {
        this.kR = z;
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
        this.kQ = new com.airbnb.lottie.model.layer.b(this, Layer.a.k(this.kg), this.kg.bk(), this.kg);
    }

    private void bs() {
        if (this.kQ != null) {
            for (a aVar : this.kI) {
                this.kQ.b(aVar.kW, aVar.kX, aVar.kY);
            }
        }
    }

    public void bt() {
        aY();
        if (this.kH.isRunning()) {
            this.kH.cancel();
        }
        this.kg = null;
        this.kQ = null;
        this.kK = null;
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
        if (colorFilter == null && this.kI.contains(aVar)) {
            this.kI.remove(aVar);
        } else {
            this.kI.add(new a(str, str2, colorFilter));
        }
        if (this.kQ != null) {
            this.kQ.b(str, str2, colorFilter);
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
        if (this.kQ != null) {
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
            this.kQ.a(canvas, this.matrix, this.alpha);
            d.D("Drawable#draw");
            if (f > 1.0f) {
                canvas.restore();
            }
        }
    }

    public void ba() {
        if (this.kQ == null) {
            this.kJ.add(new b() { // from class: com.airbnb.lottie.f.2
                @Override // com.airbnb.lottie.f.b
                public void i(e eVar) {
                    f.this.ba();
                }
            });
        } else {
            this.kH.ba();
        }
    }

    public void setMinFrame(final int i) {
        if (this.kg == null) {
            this.kJ.add(new b() { // from class: com.airbnb.lottie.f.3
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
        this.kH.m(f);
    }

    public void setMaxFrame(final int i) {
        if (this.kg == null) {
            this.kJ.add(new b() { // from class: com.airbnb.lottie.f.4
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
        this.kH.n(f);
    }

    public void setMinAndMaxFrame(final int i, final int i2) {
        if (this.kg == null) {
            this.kJ.add(new b() { // from class: com.airbnb.lottie.f.5
                @Override // com.airbnb.lottie.f.b
                public void i(e eVar) {
                    f.this.setMinAndMaxFrame(i, i2);
                }
            });
        } else {
            this.kH.g(i / this.kg.bo(), i2 / this.kg.bo());
        }
    }

    public void setMinAndMaxProgress(@FloatRange(from = 0.0d, to = 1.0d) float f, @FloatRange(from = 0.0d, to = 1.0d) float f2) {
        this.kH.g(f, f2);
    }

    public void setSpeed(float f) {
        this.kH.setSpeed(f);
    }

    public float getSpeed() {
        return this.kH.getSpeed();
    }

    public void a(Animator.AnimatorListener animatorListener) {
        this.kH.addListener(animatorListener);
    }

    public void setFrame(final int i) {
        if (this.kg == null) {
            this.kJ.add(new b() { // from class: com.airbnb.lottie.f.6
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
        this.kH.l(f);
        if (this.kQ != null) {
            this.kQ.setProgress(f);
        }
    }

    public void k(boolean z) {
        this.kH.setRepeatCount(z ? -1 : 0);
    }

    public boolean isLooping() {
        return this.kH.getRepeatCount() == -1;
    }

    public boolean isAnimating() {
        return this.kH.isRunning();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bu() {
        this.kH.bu();
    }

    public void setScale(float f) {
        this.scale = f;
        by();
    }

    public void setImageAssetDelegate(c cVar) {
        this.kL = cVar;
        if (this.kK != null) {
            this.kK.a(cVar);
        }
    }

    public void setFontAssetDelegate(com.airbnb.lottie.b bVar) {
        this.kN = bVar;
        if (this.kM != null) {
            this.kM.a(bVar);
        }
    }

    public void setTextDelegate(l lVar) {
        this.kO = lVar;
    }

    @Nullable
    public l bv() {
        return this.kO;
    }

    public boolean bw() {
        return this.kO == null && this.kg.bl().size() > 0;
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
        this.kJ.clear();
        this.kH.cancel();
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float getProgress() {
        return this.kH.dB();
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
        if (this.kK != null && !this.kK.R(getContext())) {
            this.kK.aY();
            this.kK = null;
        }
        if (this.kK == null) {
            this.kK = new com.airbnb.lottie.b.b(getCallback(), this.ko, this.kL, this.kg.bn());
        }
        return this.kK;
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
        if (this.kM == null) {
            this.kM = new com.airbnb.lottie.b.a(getCallback(), this.kN);
        }
        return this.kM;
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
        final String kW;
        @Nullable
        final String kX;
        @Nullable
        final ColorFilter kY;

        a(@Nullable String str, @Nullable String str2, @Nullable ColorFilter colorFilter) {
            this.kW = str;
            this.kX = str2;
            this.kY = colorFilter;
        }

        public int hashCode() {
            int i = 17;
            if (this.kW != null) {
                i = this.kW.hashCode() * 527;
            }
            if (this.kX != null) {
                return i * 31 * this.kX.hashCode();
            }
            return i;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof a) {
                a aVar = (a) obj;
                return hashCode() == aVar.hashCode() && this.kY == aVar.kY;
            }
            return false;
        }
    }
}
