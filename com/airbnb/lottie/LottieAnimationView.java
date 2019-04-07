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
    private static final SparseArray<e> mV = new SparseArray<>();
    private static final SparseArray<WeakReference<e>> mW = new SparseArray<>();
    private static final Map<String, e> mZ = new HashMap();
    private static final Map<String, WeakReference<e>> na = new HashMap();
    private boolean autoPlay;
    private final h nb;
    private final f nc;
    private CacheStrategy nd;
    private String ne;
    @RawRes
    private int nf;
    private boolean ng;
    private boolean nh;
    @Nullable
    private a ni;
    @Nullable
    private e nj;

    /* loaded from: classes2.dex */
    public enum CacheStrategy {
        None,
        Weak,
        Strong
    }

    public LottieAnimationView(Context context) {
        super(context);
        this.nb = new h() { // from class: com.airbnb.lottie.LottieAnimationView.1
            @Override // com.airbnb.lottie.h
            public void a(@Nullable e eVar) {
                if (eVar != null) {
                    LottieAnimationView.this.setComposition(eVar);
                }
                LottieAnimationView.this.ni = null;
            }
        };
        this.nc = new f();
        this.ng = false;
        this.autoPlay = false;
        this.nh = false;
        init(null);
    }

    public LottieAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nb = new h() { // from class: com.airbnb.lottie.LottieAnimationView.1
            @Override // com.airbnb.lottie.h
            public void a(@Nullable e eVar) {
                if (eVar != null) {
                    LottieAnimationView.this.setComposition(eVar);
                }
                LottieAnimationView.this.ni = null;
            }
        };
        this.nc = new f();
        this.ng = false;
        this.autoPlay = false;
        this.nh = false;
        init(attributeSet);
    }

    public LottieAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nb = new h() { // from class: com.airbnb.lottie.LottieAnimationView.1
            @Override // com.airbnb.lottie.h
            public void a(@Nullable e eVar) {
                if (eVar != null) {
                    LottieAnimationView.this.setComposition(eVar);
                }
                LottieAnimationView.this.ni = null;
            }
        };
        this.nc = new f();
        this.ng = false;
        this.autoPlay = false;
        this.nh = false;
        init(attributeSet);
    }

    private void init(@Nullable AttributeSet attributeSet) {
        String string;
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, j.a.LottieAnimationView);
        this.nd = CacheStrategy.values()[obtainStyledAttributes.getInt(j.a.LottieAnimationView_lottie_cacheStrategy, CacheStrategy.Weak.ordinal())];
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
            this.nc.cu();
            this.autoPlay = true;
        }
        this.nc.G(obtainStyledAttributes.getBoolean(j.a.LottieAnimationView_lottie_loop, false));
        setImageAssetsFolder(obtainStyledAttributes.getString(j.a.LottieAnimationView_lottie_imageAssetsFolder));
        setProgress(obtainStyledAttributes.getFloat(j.a.LottieAnimationView_lottie_progress, 0.0f));
        E(obtainStyledAttributes.getBoolean(j.a.LottieAnimationView_lottie_enableMergePathsForKitKatAndAbove, false));
        if (obtainStyledAttributes.hasValue(j.a.LottieAnimationView_lottie_colorFilter)) {
            a(new k(obtainStyledAttributes.getColor(j.a.LottieAnimationView_lottie_colorFilter, 0)));
        }
        if (obtainStyledAttributes.hasValue(j.a.LottieAnimationView_lottie_scale)) {
            this.nc.setScale(obtainStyledAttributes.getFloat(j.a.LottieAnimationView_lottie_scale, 1.0f));
        }
        obtainStyledAttributes.recycle();
        if (com.airbnb.lottie.c.f.az(getContext()) == 0.0f) {
            this.nc.cP();
        }
        cx();
    }

    @Override // android.support.v7.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int i) {
        cs();
        ct();
        super.setImageResource(i);
    }

    @Override // android.support.v7.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        if (drawable != this.nc) {
            cs();
        }
        ct();
        super.setImageDrawable(drawable);
    }

    @Override // android.support.v7.widget.AppCompatImageView, android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        cs();
        ct();
        super.setImageBitmap(bitmap);
    }

    public void a(@Nullable ColorFilter colorFilter) {
        this.nc.a(colorFilter);
    }

    @Override // android.widget.ImageView, android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(@NonNull Drawable drawable) {
        if (getDrawable() == this.nc) {
            super.invalidateDrawable(this.nc);
        } else {
            super.invalidateDrawable(drawable);
        }
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.ne = this.ne;
        savedState.nf = this.nf;
        savedState.progress = this.nc.getProgress();
        savedState.np = this.nc.isAnimating();
        savedState.nq = this.nc.isLooping();
        savedState.nr = this.nc.getImageAssetsFolder();
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
        this.ne = savedState.ne;
        if (!TextUtils.isEmpty(this.ne)) {
            setAnimation(this.ne);
        }
        this.nf = savedState.nf;
        if (this.nf != 0) {
            setAnimation(this.nf);
        }
        setProgress(savedState.progress);
        G(savedState.nq);
        if (savedState.np) {
            cu();
        }
        this.nc.X(savedState.nr);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.autoPlay && this.ng) {
            cu();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        if (isAnimating()) {
            cancelAnimation();
            this.ng = true;
        }
        cs();
        super.onDetachedFromWindow();
    }

    @VisibleForTesting
    void cs() {
        if (this.nc != null) {
            this.nc.cs();
        }
    }

    public void E(boolean z) {
        this.nc.E(z);
    }

    public void F(boolean z) {
        this.nh = z;
        cx();
    }

    public void setAnimation(@RawRes int i) {
        setAnimation(i, this.nd);
    }

    public void setAnimation(@RawRes final int i, final CacheStrategy cacheStrategy) {
        this.nf = i;
        this.ne = null;
        if (mW.indexOfKey(i) > 0) {
            e eVar = mW.get(i).get();
            if (eVar != null) {
                setComposition(eVar);
                return;
            }
        } else if (mV.indexOfKey(i) > 0) {
            setComposition(mV.get(i));
            return;
        }
        this.nc.cancelAnimation();
        ct();
        this.ni = e.a.a(getContext(), i, new h() { // from class: com.airbnb.lottie.LottieAnimationView.2
            @Override // com.airbnb.lottie.h
            public void a(e eVar2) {
                if (cacheStrategy == CacheStrategy.Strong) {
                    LottieAnimationView.mV.put(i, eVar2);
                } else if (cacheStrategy == CacheStrategy.Weak) {
                    LottieAnimationView.mW.put(i, new WeakReference(eVar2));
                }
                LottieAnimationView.this.setComposition(eVar2);
            }
        });
    }

    public void setAnimation(String str) {
        setAnimation(str, this.nd);
    }

    public void setAnimation(final String str, final CacheStrategy cacheStrategy) {
        this.ne = str;
        this.nf = 0;
        if (na.containsKey(str)) {
            e eVar = na.get(str).get();
            if (eVar != null) {
                setComposition(eVar);
                return;
            }
        } else if (mZ.containsKey(str)) {
            setComposition(mZ.get(str));
            return;
        }
        this.nc.cancelAnimation();
        ct();
        this.ni = e.a.a(getContext(), str, new h() { // from class: com.airbnb.lottie.LottieAnimationView.3
            @Override // com.airbnb.lottie.h
            public void a(e eVar2) {
                if (cacheStrategy == CacheStrategy.Strong) {
                    LottieAnimationView.mZ.put(str, eVar2);
                } else if (cacheStrategy == CacheStrategy.Weak) {
                    LottieAnimationView.na.put(str, new WeakReference(eVar2));
                }
                LottieAnimationView.this.setComposition(eVar2);
            }
        });
    }

    public void setAnimation(JSONObject jSONObject) {
        ct();
        this.ni = e.a.a(getResources(), jSONObject, this.nb);
    }

    private void ct() {
        if (this.ni != null) {
            this.ni.cancel();
            this.ni = null;
        }
    }

    public void setComposition(@NonNull e eVar) {
        this.nc.setCallback(this);
        boolean h = this.nc.h(eVar);
        cx();
        if (h) {
            setImageDrawable(null);
            setImageDrawable(this.nc);
            this.nj = eVar;
            requestLayout();
        }
    }

    public void cu() {
        this.nc.cu();
        cx();
    }

    public void cv() {
        this.nc.cv();
        cx();
    }

    public void setMinFrame(int i) {
        this.nc.setMinFrame(i);
    }

    public void setMinProgress(float f) {
        this.nc.setMinProgress(f);
    }

    public void setMaxFrame(int i) {
        this.nc.setMaxFrame(i);
    }

    public void setMaxProgress(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        this.nc.setMaxProgress(f);
    }

    public void setMinAndMaxFrame(int i, int i2) {
        this.nc.setMinAndMaxFrame(i, i2);
    }

    public void setMinAndMaxProgress(@FloatRange(from = 0.0d, to = 1.0d) float f, @FloatRange(from = 0.0d, to = 1.0d) float f2) {
        this.nc.setMinAndMaxProgress(f, f2);
    }

    public void setSpeed(float f) {
        this.nc.setSpeed(f);
    }

    public float getSpeed() {
        return this.nc.getSpeed();
    }

    public void a(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.nc.a(animatorUpdateListener);
    }

    public void removeUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.nc.b(animatorUpdateListener);
    }

    public void a(Animator.AnimatorListener animatorListener) {
        this.nc.a(animatorListener);
    }

    public void b(Animator.AnimatorListener animatorListener) {
        this.nc.b(animatorListener);
    }

    public void G(boolean z) {
        this.nc.G(z);
    }

    public boolean isAnimating() {
        return this.nc.isAnimating();
    }

    public void setImageAssetsFolder(String str) {
        this.nc.X(str);
    }

    @Nullable
    public String getImageAssetsFolder() {
        return this.nc.getImageAssetsFolder();
    }

    public void setImageAssetDelegate(c cVar) {
        this.nc.setImageAssetDelegate(cVar);
    }

    public void setFontAssetDelegate(b bVar) {
        this.nc.setFontAssetDelegate(bVar);
    }

    public void setTextDelegate(l lVar) {
        this.nc.setTextDelegate(lVar);
    }

    public void setScale(float f) {
        this.nc.setScale(f);
        if (getDrawable() == this.nc) {
            setImageDrawable(null);
            setImageDrawable(this.nc);
        }
    }

    public float getScale() {
        return this.nc.getScale();
    }

    public void cancelAnimation() {
        this.nc.cancelAnimation();
        cx();
    }

    public void cw() {
        this.nc.cw();
        cx();
    }

    public void setFrame(int i) {
        this.nc.setFrame(i);
    }

    public int getFrame() {
        return this.nc.getFrame();
    }

    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        this.nc.setProgress(f);
    }

    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    public float getProgress() {
        return this.nc.getProgress();
    }

    public long getDuration() {
        if (this.nj != null) {
            return this.nj.getDuration();
        }
        return 0L;
    }

    public void setPerformanceTrackingEnabled(boolean z) {
        this.nc.setPerformanceTrackingEnabled(z);
    }

    @Nullable
    public i getPerformanceTracker() {
        return this.nc.getPerformanceTracker();
    }

    private void cx() {
        setLayerType(this.nh && this.nc.isAnimating() ? 2 : 1, null);
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
            /* renamed from: q */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        String ne;
        int nf;
        boolean np;
        boolean nq;
        String nr;
        float progress;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.ne = parcel.readString();
            this.progress = parcel.readFloat();
            this.np = parcel.readInt() == 1;
            this.nq = parcel.readInt() == 1;
            this.nr = parcel.readString();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.ne);
            parcel.writeFloat(this.progress);
            parcel.writeInt(this.np ? 1 : 0);
            parcel.writeInt(this.nq ? 1 : 0);
            parcel.writeString(this.nr);
        }
    }
}
