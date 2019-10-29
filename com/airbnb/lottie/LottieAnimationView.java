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
    private String animationName;
    @RawRes
    private int animationResId;
    private boolean autoPlay;
    private final h dg;
    private final f dh;
    private CacheStrategy di;
    @Nullable
    private a dj;
    @Nullable
    private e dk;
    private boolean useHardwareLayer;
    private boolean wasAnimatingWhenDetached;
    private static final String TAG = LottieAnimationView.class.getSimpleName();
    private static final SparseArray<e> RAW_RES_STRONG_REF_CACHE = new SparseArray<>();
    private static final SparseArray<WeakReference<e>> RAW_RES_WEAK_REF_CACHE = new SparseArray<>();
    private static final Map<String, e> ASSET_STRONG_REF_CACHE = new HashMap();
    private static final Map<String, WeakReference<e>> ASSET_WEAK_REF_CACHE = new HashMap();

    /* loaded from: classes2.dex */
    public enum CacheStrategy {
        None,
        Weak,
        Strong
    }

    public LottieAnimationView(Context context) {
        super(context);
        this.dg = new h() { // from class: com.airbnb.lottie.LottieAnimationView.1
            @Override // com.airbnb.lottie.h
            public void a(@Nullable e eVar) {
                if (eVar != null) {
                    LottieAnimationView.this.setComposition(eVar);
                }
                LottieAnimationView.this.dj = null;
            }
        };
        this.dh = new f();
        this.wasAnimatingWhenDetached = false;
        this.autoPlay = false;
        this.useHardwareLayer = false;
        init(null);
    }

    public LottieAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dg = new h() { // from class: com.airbnb.lottie.LottieAnimationView.1
            @Override // com.airbnb.lottie.h
            public void a(@Nullable e eVar) {
                if (eVar != null) {
                    LottieAnimationView.this.setComposition(eVar);
                }
                LottieAnimationView.this.dj = null;
            }
        };
        this.dh = new f();
        this.wasAnimatingWhenDetached = false;
        this.autoPlay = false;
        this.useHardwareLayer = false;
        init(attributeSet);
    }

    public LottieAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dg = new h() { // from class: com.airbnb.lottie.LottieAnimationView.1
            @Override // com.airbnb.lottie.h
            public void a(@Nullable e eVar) {
                if (eVar != null) {
                    LottieAnimationView.this.setComposition(eVar);
                }
                LottieAnimationView.this.dj = null;
            }
        };
        this.dh = new f();
        this.wasAnimatingWhenDetached = false;
        this.autoPlay = false;
        this.useHardwareLayer = false;
        init(attributeSet);
    }

    private void init(@Nullable AttributeSet attributeSet) {
        String string;
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, j.a.LottieAnimationView);
        this.di = CacheStrategy.values()[obtainStyledAttributes.getInt(j.a.LottieAnimationView_lottie_cacheStrategy, CacheStrategy.Weak.ordinal())];
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
            this.dh.playAnimation();
            this.autoPlay = true;
        }
        this.dh.loop(obtainStyledAttributes.getBoolean(j.a.LottieAnimationView_lottie_loop, false));
        setImageAssetsFolder(obtainStyledAttributes.getString(j.a.LottieAnimationView_lottie_imageAssetsFolder));
        setProgress(obtainStyledAttributes.getFloat(j.a.LottieAnimationView_lottie_progress, 0.0f));
        enableMergePathsForKitKatAndAbove(obtainStyledAttributes.getBoolean(j.a.LottieAnimationView_lottie_enableMergePathsForKitKatAndAbove, false));
        if (obtainStyledAttributes.hasValue(j.a.LottieAnimationView_lottie_colorFilter)) {
            addColorFilter(new k(obtainStyledAttributes.getColor(j.a.LottieAnimationView_lottie_colorFilter, 0)));
        }
        if (obtainStyledAttributes.hasValue(j.a.LottieAnimationView_lottie_scale)) {
            this.dh.setScale(obtainStyledAttributes.getFloat(j.a.LottieAnimationView_lottie_scale, 1.0f));
        }
        obtainStyledAttributes.recycle();
        if (com.airbnb.lottie.c.f.Q(getContext()) == 0.0f) {
            this.dh.bg();
        }
        enableOrDisableHardwareLayer();
    }

    @Override // android.support.v7.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int i) {
        recycleBitmaps();
        cancelLoaderTask();
        super.setImageResource(i);
    }

    @Override // android.support.v7.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        if (drawable != this.dh) {
            recycleBitmaps();
        }
        cancelLoaderTask();
        super.setImageDrawable(drawable);
    }

    @Override // android.support.v7.widget.AppCompatImageView, android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        recycleBitmaps();
        cancelLoaderTask();
        super.setImageBitmap(bitmap);
    }

    public void addColorFilter(@Nullable ColorFilter colorFilter) {
        this.dh.addColorFilter(colorFilter);
    }

    @Override // android.widget.ImageView, android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(@NonNull Drawable drawable) {
        if (getDrawable() == this.dh) {
            super.invalidateDrawable(this.dh);
        } else {
            super.invalidateDrawable(drawable);
        }
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.animationName = this.animationName;
        savedState.animationResId = this.animationResId;
        savedState.progress = this.dh.getProgress();
        savedState.dr = this.dh.isAnimating();
        savedState.ds = this.dh.isLooping();
        savedState.dt = this.dh.getImageAssetsFolder();
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
        this.animationName = savedState.animationName;
        if (!TextUtils.isEmpty(this.animationName)) {
            setAnimation(this.animationName);
        }
        this.animationResId = savedState.animationResId;
        if (this.animationResId != 0) {
            setAnimation(this.animationResId);
        }
        setProgress(savedState.progress);
        loop(savedState.ds);
        if (savedState.dr) {
            playAnimation();
        }
        this.dh.G(savedState.dt);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.autoPlay && this.wasAnimatingWhenDetached) {
            playAnimation();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        if (isAnimating()) {
            cancelAnimation();
            this.wasAnimatingWhenDetached = true;
        }
        recycleBitmaps();
        super.onDetachedFromWindow();
    }

    @VisibleForTesting
    void recycleBitmaps() {
        if (this.dh != null) {
            this.dh.recycleBitmaps();
        }
    }

    public void enableMergePathsForKitKatAndAbove(boolean z) {
        this.dh.enableMergePathsForKitKatAndAbove(z);
    }

    public void useHardwareAcceleration(boolean z) {
        this.useHardwareLayer = z;
        enableOrDisableHardwareLayer();
    }

    public void setAnimation(@RawRes int i) {
        setAnimation(i, this.di);
    }

    public void setAnimation(@RawRes final int i, final CacheStrategy cacheStrategy) {
        this.animationResId = i;
        this.animationName = null;
        if (RAW_RES_WEAK_REF_CACHE.indexOfKey(i) > 0) {
            e eVar = RAW_RES_WEAK_REF_CACHE.get(i).get();
            if (eVar != null) {
                setComposition(eVar);
                return;
            }
        } else if (RAW_RES_STRONG_REF_CACHE.indexOfKey(i) > 0) {
            setComposition(RAW_RES_STRONG_REF_CACHE.get(i));
            return;
        }
        this.dh.cancelAnimation();
        cancelLoaderTask();
        this.dj = e.a.a(getContext(), i, new h() { // from class: com.airbnb.lottie.LottieAnimationView.2
            @Override // com.airbnb.lottie.h
            public void a(e eVar2) {
                if (cacheStrategy == CacheStrategy.Strong) {
                    LottieAnimationView.RAW_RES_STRONG_REF_CACHE.put(i, eVar2);
                } else if (cacheStrategy == CacheStrategy.Weak) {
                    LottieAnimationView.RAW_RES_WEAK_REF_CACHE.put(i, new WeakReference(eVar2));
                }
                LottieAnimationView.this.setComposition(eVar2);
            }
        });
    }

    public void setAnimation(String str) {
        setAnimation(str, this.di);
    }

    public void setAnimation(final String str, final CacheStrategy cacheStrategy) {
        this.animationName = str;
        this.animationResId = 0;
        if (ASSET_WEAK_REF_CACHE.containsKey(str)) {
            e eVar = ASSET_WEAK_REF_CACHE.get(str).get();
            if (eVar != null) {
                setComposition(eVar);
                return;
            }
        } else if (ASSET_STRONG_REF_CACHE.containsKey(str)) {
            setComposition(ASSET_STRONG_REF_CACHE.get(str));
            return;
        }
        this.dh.cancelAnimation();
        cancelLoaderTask();
        this.dj = e.a.a(getContext(), str, new h() { // from class: com.airbnb.lottie.LottieAnimationView.3
            @Override // com.airbnb.lottie.h
            public void a(e eVar2) {
                if (cacheStrategy == CacheStrategy.Strong) {
                    LottieAnimationView.ASSET_STRONG_REF_CACHE.put(str, eVar2);
                } else if (cacheStrategy == CacheStrategy.Weak) {
                    LottieAnimationView.ASSET_WEAK_REF_CACHE.put(str, new WeakReference(eVar2));
                }
                LottieAnimationView.this.setComposition(eVar2);
            }
        });
    }

    public void setAnimation(JSONObject jSONObject) {
        cancelLoaderTask();
        this.dj = e.a.a(getResources(), jSONObject, this.dg);
    }

    private void cancelLoaderTask() {
        if (this.dj != null) {
            this.dj.cancel();
            this.dj = null;
        }
    }

    public void setComposition(@NonNull e eVar) {
        this.dh.setCallback(this);
        boolean h = this.dh.h(eVar);
        enableOrDisableHardwareLayer();
        if (h) {
            setImageDrawable(null);
            setImageDrawable(this.dh);
            this.dk = eVar;
            requestLayout();
        }
    }

    public void playAnimation() {
        this.dh.playAnimation();
        enableOrDisableHardwareLayer();
    }

    public void resumeAnimation() {
        this.dh.resumeAnimation();
        enableOrDisableHardwareLayer();
    }

    public void setMinFrame(int i) {
        this.dh.setMinFrame(i);
    }

    public void setMinProgress(float f) {
        this.dh.setMinProgress(f);
    }

    public void setMaxFrame(int i) {
        this.dh.setMaxFrame(i);
    }

    public void setMaxProgress(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        this.dh.setMaxProgress(f);
    }

    public void setMinAndMaxFrame(int i, int i2) {
        this.dh.setMinAndMaxFrame(i, i2);
    }

    public void setMinAndMaxProgress(@FloatRange(from = 0.0d, to = 1.0d) float f, @FloatRange(from = 0.0d, to = 1.0d) float f2) {
        this.dh.setMinAndMaxProgress(f, f2);
    }

    public void setSpeed(float f) {
        this.dh.setSpeed(f);
    }

    public float getSpeed() {
        return this.dh.getSpeed();
    }

    public void addAnimatorUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.dh.addAnimatorUpdateListener(animatorUpdateListener);
    }

    public void removeUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.dh.a(animatorUpdateListener);
    }

    public void addAnimatorListener(Animator.AnimatorListener animatorListener) {
        this.dh.addAnimatorListener(animatorListener);
    }

    public void removeAnimatorListener(Animator.AnimatorListener animatorListener) {
        this.dh.removeAnimatorListener(animatorListener);
    }

    public void loop(boolean z) {
        this.dh.loop(z);
    }

    public boolean isAnimating() {
        return this.dh.isAnimating();
    }

    public void setImageAssetsFolder(String str) {
        this.dh.G(str);
    }

    @Nullable
    public String getImageAssetsFolder() {
        return this.dh.getImageAssetsFolder();
    }

    public void setImageAssetDelegate(c cVar) {
        this.dh.setImageAssetDelegate(cVar);
    }

    public void setFontAssetDelegate(b bVar) {
        this.dh.setFontAssetDelegate(bVar);
    }

    public void setTextDelegate(l lVar) {
        this.dh.setTextDelegate(lVar);
    }

    public void setScale(float f) {
        this.dh.setScale(f);
        if (getDrawable() == this.dh) {
            setImageDrawable(null);
            setImageDrawable(this.dh);
        }
    }

    public float getScale() {
        return this.dh.getScale();
    }

    public void cancelAnimation() {
        this.dh.cancelAnimation();
        enableOrDisableHardwareLayer();
    }

    public void pauseAnimation() {
        this.dh.pauseAnimation();
        enableOrDisableHardwareLayer();
    }

    public void setFrame(int i) {
        this.dh.setFrame(i);
    }

    public int getFrame() {
        return this.dh.getFrame();
    }

    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        this.dh.setProgress(f);
    }

    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    public float getProgress() {
        return this.dh.getProgress();
    }

    public long getDuration() {
        if (this.dk != null) {
            return this.dk.getDuration();
        }
        return 0L;
    }

    public void setPerformanceTrackingEnabled(boolean z) {
        this.dh.setPerformanceTrackingEnabled(z);
    }

    @Nullable
    public i getPerformanceTracker() {
        return this.dh.getPerformanceTracker();
    }

    private void enableOrDisableHardwareLayer() {
        setLayerType(this.useHardwareLayer && this.dh.isAnimating() ? 2 : 1, null);
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
        String animationName;
        int animationResId;
        boolean dr;
        boolean ds;
        String dt;
        float progress;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.animationName = parcel.readString();
            this.progress = parcel.readFloat();
            this.dr = parcel.readInt() == 1;
            this.ds = parcel.readInt() == 1;
            this.dt = parcel.readString();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.animationName);
            parcel.writeFloat(this.progress);
            parcel.writeInt(this.dr ? 1 : 0);
            parcel.writeInt(this.ds ? 1 : 0);
            parcel.writeString(this.dt);
        }
    }
}
