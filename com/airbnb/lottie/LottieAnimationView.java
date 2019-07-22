package com.airbnb.lottie;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.FloatRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RawRes;
import android.support.annotation.VisibleForTesting;
import android.support.v7.widget.AppCompatImageView;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import com.airbnb.lottie.e;
import com.airbnb.lottie.j;
import com.baidu.mapapi.map.WeightedLatLng;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class LottieAnimationView extends AppCompatImageView {
    private static final String TAG = LottieAnimationView.class.getSimpleName();
    private static final SparseArray<e> ku = new SparseArray<>();
    private static final SparseArray<WeakReference<e>> kv = new SparseArray<>();
    private static final Map<String, e> kx = new HashMap();
    private static final Map<String, WeakReference<e>> ky = new HashMap();
    private boolean autoPlay;
    private final h kA;
    private final f kB;
    private CacheStrategy kC;
    private String kD;
    @RawRes
    private int kE;
    private boolean kF;
    private boolean kG;
    @Nullable
    private a kH;
    @Nullable
    private e kI;

    /* loaded from: classes2.dex */
    public enum CacheStrategy {
        None,
        Weak,
        Strong
    }

    public LottieAnimationView(Context context) {
        super(context);
        this.kA = new h() { // from class: com.airbnb.lottie.LottieAnimationView.1
            @Override // com.airbnb.lottie.h
            public void a(@Nullable e eVar) {
                if (eVar != null) {
                    LottieAnimationView.this.setComposition(eVar);
                }
                LottieAnimationView.this.kH = null;
            }
        };
        this.kB = new f();
        this.kF = false;
        this.autoPlay = false;
        this.kG = false;
        init(null);
    }

    public LottieAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kA = new h() { // from class: com.airbnb.lottie.LottieAnimationView.1
            @Override // com.airbnb.lottie.h
            public void a(@Nullable e eVar) {
                if (eVar != null) {
                    LottieAnimationView.this.setComposition(eVar);
                }
                LottieAnimationView.this.kH = null;
            }
        };
        this.kB = new f();
        this.kF = false;
        this.autoPlay = false;
        this.kG = false;
        init(attributeSet);
    }

    public LottieAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kA = new h() { // from class: com.airbnb.lottie.LottieAnimationView.1
            @Override // com.airbnb.lottie.h
            public void a(@Nullable e eVar) {
                if (eVar != null) {
                    LottieAnimationView.this.setComposition(eVar);
                }
                LottieAnimationView.this.kH = null;
            }
        };
        this.kB = new f();
        this.kF = false;
        this.autoPlay = false;
        this.kG = false;
        init(attributeSet);
    }

    private void init(@Nullable AttributeSet attributeSet) {
        String string;
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, j.a.LottieAnimationView);
        this.kC = CacheStrategy.values()[obtainStyledAttributes.getInt(j.a.LottieAnimationView_lottie_cacheStrategy, CacheStrategy.Weak.ordinal())];
        if (!isInEditMode()) {
            boolean hasValue = obtainStyledAttributes.hasValue(j.a.LottieAnimationView_lottie_rawRes);
            boolean hasValue2 = obtainStyledAttributes.hasValue(j.a.LottieAnimationView_lottie_fileName);
            if (hasValue && hasValue2) {
                throw new IllegalArgumentException("lottie_rawRes and lottie_fileName cannot be used at the same time. Please use use only one at once.");
            }
            if (hasValue) {
                int resourceId = obtainStyledAttributes.getResourceId(j.a.LottieAnimationView_lottie_rawRes, 0);
                if (resourceId != 0) {
                    setAnimation(resourceId);
                }
            } else if (hasValue2 && (string = obtainStyledAttributes.getString(j.a.LottieAnimationView_lottie_fileName)) != null) {
                setAnimation(string);
            }
        }
        if (obtainStyledAttributes.getBoolean(j.a.LottieAnimationView_lottie_autoPlay, false)) {
            this.kB.br();
            this.autoPlay = true;
        }
        this.kB.y(obtainStyledAttributes.getBoolean(j.a.LottieAnimationView_lottie_loop, false));
        setImageAssetsFolder(obtainStyledAttributes.getString(j.a.LottieAnimationView_lottie_imageAssetsFolder));
        setProgress(obtainStyledAttributes.getFloat(j.a.LottieAnimationView_lottie_progress, 0.0f));
        w(obtainStyledAttributes.getBoolean(j.a.LottieAnimationView_lottie_enableMergePathsForKitKatAndAbove, false));
        if (obtainStyledAttributes.hasValue(j.a.LottieAnimationView_lottie_colorFilter)) {
            a(new k(obtainStyledAttributes.getColor(j.a.LottieAnimationView_lottie_colorFilter, 0)));
        }
        if (obtainStyledAttributes.hasValue(j.a.LottieAnimationView_lottie_scale)) {
            this.kB.setScale(obtainStyledAttributes.getFloat(j.a.LottieAnimationView_lottie_scale, 1.0f));
        }
        obtainStyledAttributes.recycle();
        if (com.airbnb.lottie.c.f.Q(getContext()) == 0.0f) {
            this.kB.bN();
        }
        bu();
    }

    @Override // android.support.v7.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int i) {
        bp();
        bq();
        super.setImageResource(i);
    }

    @Override // android.support.v7.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        if (drawable != this.kB) {
            bp();
        }
        bq();
        super.setImageDrawable(drawable);
    }

    @Override // android.support.v7.widget.AppCompatImageView, android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        bp();
        bq();
        super.setImageBitmap(bitmap);
    }

    public void a(@Nullable ColorFilter colorFilter) {
        this.kB.a(colorFilter);
    }

    @Override // android.widget.ImageView, android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(@NonNull Drawable drawable) {
        if (getDrawable() == this.kB) {
            super.invalidateDrawable(this.kB);
        } else {
            super.invalidateDrawable(drawable);
        }
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.kD = this.kD;
        savedState.kE = this.kE;
        savedState.progress = this.kB.getProgress();
        savedState.kN = this.kB.isAnimating();
        savedState.kO = this.kB.isLooping();
        savedState.kP = this.kB.getImageAssetsFolder();
        return savedState;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.kD = savedState.kD;
        if (!TextUtils.isEmpty(this.kD)) {
            setAnimation(this.kD);
        }
        this.kE = savedState.kE;
        if (this.kE != 0) {
            setAnimation(this.kE);
        }
        setProgress(savedState.progress);
        y(savedState.kO);
        if (savedState.kN) {
            br();
        }
        this.kB.G(savedState.kP);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.autoPlay && this.kF) {
            br();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        if (isAnimating()) {
            cancelAnimation();
            this.kF = true;
        }
        bp();
        super.onDetachedFromWindow();
    }

    @VisibleForTesting
    void bp() {
        if (this.kB != null) {
            this.kB.bp();
        }
    }

    public void w(boolean z) {
        this.kB.w(z);
    }

    public void x(boolean z) {
        this.kG = z;
        bu();
    }

    public void setAnimation(@RawRes int i) {
        setAnimation(i, this.kC);
    }

    public void setAnimation(@RawRes final int i, final CacheStrategy cacheStrategy) {
        this.kE = i;
        this.kD = null;
        if (kv.indexOfKey(i) > 0) {
            e eVar = kv.get(i).get();
            if (eVar != null) {
                setComposition(eVar);
                return;
            }
        } else if (ku.indexOfKey(i) > 0) {
            setComposition(ku.get(i));
            return;
        }
        this.kB.cancelAnimation();
        bq();
        this.kH = e.a.a(getContext(), i, new h() { // from class: com.airbnb.lottie.LottieAnimationView.2
            @Override // com.airbnb.lottie.h
            public void a(e eVar2) {
                if (cacheStrategy == CacheStrategy.Strong) {
                    LottieAnimationView.ku.put(i, eVar2);
                } else if (cacheStrategy == CacheStrategy.Weak) {
                    LottieAnimationView.kv.put(i, new WeakReference(eVar2));
                }
                LottieAnimationView.this.setComposition(eVar2);
            }
        });
    }

    public void setAnimation(String str) {
        setAnimation(str, this.kC);
    }

    public void setAnimation(final String str, final CacheStrategy cacheStrategy) {
        this.kD = str;
        this.kE = 0;
        if (ky.containsKey(str)) {
            e eVar = ky.get(str).get();
            if (eVar != null) {
                setComposition(eVar);
                return;
            }
        } else if (kx.containsKey(str)) {
            setComposition(kx.get(str));
            return;
        }
        this.kB.cancelAnimation();
        bq();
        this.kH = e.a.a(getContext(), str, new h() { // from class: com.airbnb.lottie.LottieAnimationView.3
            @Override // com.airbnb.lottie.h
            public void a(e eVar2) {
                if (cacheStrategy == CacheStrategy.Strong) {
                    LottieAnimationView.kx.put(str, eVar2);
                } else if (cacheStrategy == CacheStrategy.Weak) {
                    LottieAnimationView.ky.put(str, new WeakReference(eVar2));
                }
                LottieAnimationView.this.setComposition(eVar2);
            }
        });
    }

    public void setAnimation(JSONObject jSONObject) {
        bq();
        this.kH = e.a.a(getResources(), jSONObject, this.kA);
    }

    private void bq() {
        if (this.kH != null) {
            this.kH.cancel();
            this.kH = null;
        }
    }

    public void setComposition(@NonNull e eVar) {
        this.kB.setCallback(this);
        boolean h = this.kB.h(eVar);
        bu();
        if (h) {
            setImageDrawable(null);
            setImageDrawable(this.kB);
            this.kI = eVar;
            requestLayout();
        }
    }

    public void br() {
        this.kB.br();
        bu();
    }

    public void bs() {
        this.kB.bs();
        bu();
    }

    public void setMinFrame(int i) {
        this.kB.setMinFrame(i);
    }

    public void setMinProgress(float f) {
        this.kB.setMinProgress(f);
    }

    public void setMaxFrame(int i) {
        this.kB.setMaxFrame(i);
    }

    public void setMaxProgress(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        this.kB.setMaxProgress(f);
    }

    public void setMinAndMaxFrame(int i, int i2) {
        this.kB.setMinAndMaxFrame(i, i2);
    }

    public void setMinAndMaxProgress(@FloatRange(from = 0.0d, to = 1.0d) float f, @FloatRange(from = 0.0d, to = 1.0d) float f2) {
        this.kB.setMinAndMaxProgress(f, f2);
    }

    public void setSpeed(float f) {
        this.kB.setSpeed(f);
    }

    public float getSpeed() {
        return this.kB.getSpeed();
    }

    public void a(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.kB.a(animatorUpdateListener);
    }

    public void b(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.kB.c(animatorUpdateListener);
    }

    public void a(Animator.AnimatorListener animatorListener) {
        this.kB.a(animatorListener);
    }

    public void b(Animator.AnimatorListener animatorListener) {
        this.kB.b(animatorListener);
    }

    public void y(boolean z) {
        this.kB.y(z);
    }

    public boolean isAnimating() {
        return this.kB.isAnimating();
    }

    public void setImageAssetsFolder(String str) {
        this.kB.G(str);
    }

    @Nullable
    public String getImageAssetsFolder() {
        return this.kB.getImageAssetsFolder();
    }

    public void setImageAssetDelegate(c cVar) {
        this.kB.setImageAssetDelegate(cVar);
    }

    public void setFontAssetDelegate(b bVar) {
        this.kB.setFontAssetDelegate(bVar);
    }

    public void setTextDelegate(l lVar) {
        this.kB.setTextDelegate(lVar);
    }

    public void setScale(float f) {
        this.kB.setScale(f);
        if (getDrawable() == this.kB) {
            setImageDrawable(null);
            setImageDrawable(this.kB);
        }
    }

    public float getScale() {
        return this.kB.getScale();
    }

    public void cancelAnimation() {
        this.kB.cancelAnimation();
        bu();
    }

    public void bt() {
        this.kB.bt();
        bu();
    }

    public void setFrame(int i) {
        this.kB.setFrame(i);
    }

    public int getFrame() {
        return this.kB.getFrame();
    }

    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        this.kB.setProgress(f);
    }

    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    public float getProgress() {
        return this.kB.getProgress();
    }

    public long getDuration() {
        if (this.kI != null) {
            return this.kI.getDuration();
        }
        return 0L;
    }

    public void setPerformanceTrackingEnabled(boolean z) {
        this.kB.setPerformanceTrackingEnabled(z);
    }

    @Nullable
    public i getPerformanceTracker() {
        return this.kB.getPerformanceTracker();
    }

    private void bu() {
        setLayerType(this.kG && this.kB.isAnimating() ? 2 : 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.airbnb.lottie.LottieAnimationView.SavedState.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: c */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: j */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        String kD;
        int kE;
        boolean kN;
        boolean kO;
        String kP;
        float progress;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.kD = parcel.readString();
            this.progress = parcel.readFloat();
            this.kN = parcel.readInt() == 1;
            this.kO = parcel.readInt() == 1;
            this.kP = parcel.readString();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.kD);
            parcel.writeFloat(this.progress);
            parcel.writeInt(this.kN ? 1 : 0);
            parcel.writeInt(this.kO ? 1 : 0);
            parcel.writeString(this.kP);
        }
    }
}
