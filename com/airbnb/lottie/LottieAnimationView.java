package com.airbnb.lottie;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.JsonReader;
import android.util.Log;
import android.view.View;
import androidx.annotation.FloatRange;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.widget.AppCompatImageView;
import com.airbnb.lottie.n;
import com.baidu.mapapi.map.WeightedLatLng;
import java.io.StringReader;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes4.dex */
public class LottieAnimationView extends AppCompatImageView {
    private static final String TAG = LottieAnimationView.class.getSimpleName();
    private final h<d> BF;
    private final h<Throwable> BG;
    private final f BH;
    @Nullable
    private l<d> BI;
    @Nullable
    private d BJ;
    private String animationName;
    @RawRes
    private int animationResId;
    private boolean autoPlay;
    private Set<i> lottieOnCompositionLoadedListeners;
    private boolean useHardwareLayer;
    private boolean wasAnimatingWhenDetached;

    public LottieAnimationView(Context context) {
        super(context);
        this.BF = new h<d>() { // from class: com.airbnb.lottie.LottieAnimationView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.airbnb.lottie.h
            /* renamed from: a */
            public void onResult(d dVar) {
                LottieAnimationView.this.setComposition(dVar);
            }
        };
        this.BG = new h<Throwable>() { // from class: com.airbnb.lottie.LottieAnimationView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.airbnb.lottie.h
            /* renamed from: f */
            public void onResult(Throwable th) {
                throw new IllegalStateException("Unable to parse composition", th);
            }
        };
        this.BH = new f();
        this.wasAnimatingWhenDetached = false;
        this.autoPlay = false;
        this.useHardwareLayer = false;
        this.lottieOnCompositionLoadedListeners = new HashSet();
        init(null);
    }

    public LottieAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.BF = new h<d>() { // from class: com.airbnb.lottie.LottieAnimationView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.airbnb.lottie.h
            /* renamed from: a */
            public void onResult(d dVar) {
                LottieAnimationView.this.setComposition(dVar);
            }
        };
        this.BG = new h<Throwable>() { // from class: com.airbnb.lottie.LottieAnimationView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.airbnb.lottie.h
            /* renamed from: f */
            public void onResult(Throwable th) {
                throw new IllegalStateException("Unable to parse composition", th);
            }
        };
        this.BH = new f();
        this.wasAnimatingWhenDetached = false;
        this.autoPlay = false;
        this.useHardwareLayer = false;
        this.lottieOnCompositionLoadedListeners = new HashSet();
        init(attributeSet);
    }

    public LottieAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.BF = new h<d>() { // from class: com.airbnb.lottie.LottieAnimationView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.airbnb.lottie.h
            /* renamed from: a */
            public void onResult(d dVar) {
                LottieAnimationView.this.setComposition(dVar);
            }
        };
        this.BG = new h<Throwable>() { // from class: com.airbnb.lottie.LottieAnimationView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.airbnb.lottie.h
            /* renamed from: f */
            public void onResult(Throwable th) {
                throw new IllegalStateException("Unable to parse composition", th);
            }
        };
        this.BH = new f();
        this.wasAnimatingWhenDetached = false;
        this.autoPlay = false;
        this.useHardwareLayer = false;
        this.lottieOnCompositionLoadedListeners = new HashSet();
        init(attributeSet);
    }

    private void init(@Nullable AttributeSet attributeSet) {
        String string;
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, n.a.LottieAnimationView);
        if (!isInEditMode()) {
            boolean hasValue = obtainStyledAttributes.hasValue(n.a.LottieAnimationView_lottie_rawRes);
            boolean hasValue2 = obtainStyledAttributes.hasValue(n.a.LottieAnimationView_lottie_fileName);
            boolean hasValue3 = obtainStyledAttributes.hasValue(n.a.LottieAnimationView_lottie_url);
            if (hasValue && hasValue2) {
                throw new IllegalArgumentException("lottie_rawRes and lottie_fileName cannot be used at the same time. Please use only one at once.");
            }
            if (hasValue) {
                int resourceId = obtainStyledAttributes.getResourceId(n.a.LottieAnimationView_lottie_rawRes, 0);
                if (resourceId != 0) {
                    setAnimation(resourceId);
                }
            } else if (hasValue2) {
                String string2 = obtainStyledAttributes.getString(n.a.LottieAnimationView_lottie_fileName);
                if (string2 != null) {
                    setAnimation(string2);
                }
            } else if (hasValue3 && (string = obtainStyledAttributes.getString(n.a.LottieAnimationView_lottie_url)) != null) {
                setAnimationFromUrl(string);
            }
        }
        if (obtainStyledAttributes.getBoolean(n.a.LottieAnimationView_lottie_autoPlay, false)) {
            this.wasAnimatingWhenDetached = true;
            this.autoPlay = true;
        }
        if (obtainStyledAttributes.getBoolean(n.a.LottieAnimationView_lottie_loop, false)) {
            this.BH.setRepeatCount(-1);
        }
        if (obtainStyledAttributes.hasValue(n.a.LottieAnimationView_lottie_repeatMode)) {
            setRepeatMode(obtainStyledAttributes.getInt(n.a.LottieAnimationView_lottie_repeatMode, 1));
        }
        if (obtainStyledAttributes.hasValue(n.a.LottieAnimationView_lottie_repeatCount)) {
            setRepeatCount(obtainStyledAttributes.getInt(n.a.LottieAnimationView_lottie_repeatCount, -1));
        }
        setImageAssetsFolder(obtainStyledAttributes.getString(n.a.LottieAnimationView_lottie_imageAssetsFolder));
        setProgress(obtainStyledAttributes.getFloat(n.a.LottieAnimationView_lottie_progress, 0.0f));
        enableMergePathsForKitKatAndAbove(obtainStyledAttributes.getBoolean(n.a.LottieAnimationView_lottie_enableMergePathsForKitKatAndAbove, false));
        if (obtainStyledAttributes.hasValue(n.a.LottieAnimationView_lottie_colorFilter)) {
            a(new com.airbnb.lottie.model.e("**"), j.Db, new com.airbnb.lottie.e.c(new o(obtainStyledAttributes.getColor(n.a.LottieAnimationView_lottie_colorFilter, 0))));
        }
        if (obtainStyledAttributes.hasValue(n.a.LottieAnimationView_lottie_scale)) {
            this.BH.setScale(obtainStyledAttributes.getFloat(n.a.LottieAnimationView_lottie_scale, 1.0f));
        }
        obtainStyledAttributes.recycle();
        enableOrDisableHardwareLayer();
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int i) {
        recycleBitmaps();
        cancelLoaderTask();
        super.setImageResource(i);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        setImageDrawable(drawable, true);
    }

    private void setImageDrawable(Drawable drawable, boolean z) {
        if (z && drawable != this.BH) {
            recycleBitmaps();
        }
        cancelLoaderTask();
        super.setImageDrawable(drawable);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        recycleBitmaps();
        cancelLoaderTask();
        super.setImageBitmap(bitmap);
    }

    @Override // android.widget.ImageView, android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(@NonNull Drawable drawable) {
        if (getDrawable() == this.BH) {
            super.invalidateDrawable(this.BH);
        } else {
            super.invalidateDrawable(drawable);
        }
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.animationName = this.animationName;
        savedState.animationResId = this.animationResId;
        savedState.progress = this.BH.getProgress();
        savedState.isAnimating = this.BH.isAnimating();
        savedState.BL = this.BH.getImageAssetsFolder();
        savedState.repeatMode = this.BH.getRepeatMode();
        savedState.repeatCount = this.BH.getRepeatCount();
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
        if (savedState.isAnimating) {
            playAnimation();
        }
        this.BH.be(savedState.BL);
        setRepeatMode(savedState.repeatMode);
        setRepeatCount(savedState.repeatCount);
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
        this.BH.recycleBitmaps();
    }

    public void enableMergePathsForKitKatAndAbove(boolean z) {
        this.BH.enableMergePathsForKitKatAndAbove(z);
    }

    public void useHardwareAcceleration(boolean z) {
        if (this.useHardwareLayer != z) {
            this.useHardwareLayer = z;
            enableOrDisableHardwareLayer();
        }
    }

    public boolean getUseHardwareAcceleration() {
        return this.useHardwareLayer;
    }

    public void setAnimation(@RawRes int i) {
        this.animationResId = i;
        this.animationName = null;
        setCompositionTask(e.d(getContext(), i));
    }

    public void setAnimation(String str) {
        this.animationName = str;
        this.animationResId = 0;
        setCompositionTask(e.t(getContext(), str));
    }

    @Deprecated
    public void setAnimationFromJson(String str) {
        setAnimationFromJson(str, null);
    }

    public void setAnimationFromJson(String str, @Nullable String str2) {
        setAnimation(new JsonReader(new StringReader(str)), str2);
    }

    public void setAnimation(JsonReader jsonReader, @Nullable String str) {
        setCompositionTask(e.c(jsonReader, str));
    }

    public void setAnimationFromUrl(String str) {
        setCompositionTask(e.s(getContext(), str));
    }

    private void setCompositionTask(l<d> lVar) {
        clearComposition();
        cancelLoaderTask();
        this.BI = lVar.a(this.BF).c(this.BG);
    }

    private void cancelLoaderTask() {
        if (this.BI != null) {
            this.BI.b(this.BF);
            this.BI.d(this.BG);
        }
    }

    public void setComposition(@NonNull d dVar) {
        if (c.DBG) {
            Log.v(TAG, "Set Composition \n" + dVar);
        }
        this.BH.setCallback(this);
        this.BJ = dVar;
        boolean b2 = this.BH.b(dVar);
        enableOrDisableHardwareLayer();
        if (getDrawable() != this.BH || b2) {
            setImageDrawable(null);
            setImageDrawable(this.BH);
            requestLayout();
            for (i iVar : this.lottieOnCompositionLoadedListeners) {
                iVar.d(dVar);
            }
        }
    }

    @Nullable
    public d getComposition() {
        return this.BJ;
    }

    @MainThread
    public void playAnimation() {
        this.BH.playAnimation();
        enableOrDisableHardwareLayer();
    }

    @MainThread
    public void resumeAnimation() {
        this.BH.resumeAnimation();
        enableOrDisableHardwareLayer();
    }

    public void setMinFrame(int i) {
        this.BH.setMinFrame(i);
    }

    public float getMinFrame() {
        return this.BH.getMinFrame();
    }

    public void setMinProgress(float f) {
        this.BH.setMinProgress(f);
    }

    public void setMaxFrame(int i) {
        this.BH.setMaxFrame(i);
    }

    public float getMaxFrame() {
        return this.BH.getMaxFrame();
    }

    public void setMaxProgress(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        this.BH.setMaxProgress(f);
    }

    public void setMinAndMaxFrame(int i, int i2) {
        this.BH.setMinAndMaxFrame(i, i2);
    }

    public void setMinAndMaxProgress(@FloatRange(from = 0.0d, to = 1.0d) float f, @FloatRange(from = 0.0d, to = 1.0d) float f2) {
        this.BH.setMinAndMaxProgress(f, f2);
    }

    public void setSpeed(float f) {
        this.BH.setSpeed(f);
    }

    public float getSpeed() {
        return this.BH.getSpeed();
    }

    public void addAnimatorUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.BH.addAnimatorUpdateListener(animatorUpdateListener);
    }

    public void removeUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.BH.a(animatorUpdateListener);
    }

    public void addAnimatorListener(Animator.AnimatorListener animatorListener) {
        this.BH.addAnimatorListener(animatorListener);
    }

    public void removeAnimatorListener(Animator.AnimatorListener animatorListener) {
        this.BH.removeAnimatorListener(animatorListener);
    }

    public void removeAllAnimatorListeners() {
        this.BH.removeAllAnimatorListeners();
    }

    @Deprecated
    public void loop(boolean z) {
        this.BH.setRepeatCount(z ? -1 : 0);
    }

    public void setRepeatMode(int i) {
        this.BH.setRepeatMode(i);
    }

    public int getRepeatMode() {
        return this.BH.getRepeatMode();
    }

    public void setRepeatCount(int i) {
        this.BH.setRepeatCount(i);
    }

    public int getRepeatCount() {
        return this.BH.getRepeatCount();
    }

    public boolean isAnimating() {
        return this.BH.isAnimating();
    }

    public void setImageAssetsFolder(String str) {
        this.BH.be(str);
    }

    @Nullable
    public String getImageAssetsFolder() {
        return this.BH.getImageAssetsFolder();
    }

    public void setImageAssetDelegate(b bVar) {
        this.BH.setImageAssetDelegate(bVar);
    }

    public void setFontAssetDelegate(a aVar) {
        this.BH.setFontAssetDelegate(aVar);
    }

    public void setTextDelegate(p pVar) {
        this.BH.setTextDelegate(pVar);
    }

    public <T> void a(com.airbnb.lottie.model.e eVar, T t, com.airbnb.lottie.e.c<T> cVar) {
        this.BH.a(eVar, t, cVar);
    }

    public void setScale(float f) {
        this.BH.setScale(f);
        if (getDrawable() == this.BH) {
            setImageDrawable(null, false);
            setImageDrawable(this.BH, false);
        }
    }

    public float getScale() {
        return this.BH.getScale();
    }

    @MainThread
    public void cancelAnimation() {
        this.BH.cancelAnimation();
        enableOrDisableHardwareLayer();
    }

    @MainThread
    public void pauseAnimation() {
        this.BH.pauseAnimation();
        enableOrDisableHardwareLayer();
    }

    public void setFrame(int i) {
        this.BH.setFrame(i);
    }

    public int getFrame() {
        return this.BH.getFrame();
    }

    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        this.BH.setProgress(f);
    }

    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    public float getProgress() {
        return this.BH.getProgress();
    }

    public long getDuration() {
        if (this.BJ != null) {
            return this.BJ.hR();
        }
        return 0L;
    }

    public void setPerformanceTrackingEnabled(boolean z) {
        this.BH.setPerformanceTrackingEnabled(z);
    }

    @Nullable
    public m getPerformanceTracker() {
        return this.BH.getPerformanceTracker();
    }

    private void clearComposition() {
        this.BJ = null;
        this.BH.clearComposition();
    }

    private void enableOrDisableHardwareLayer() {
        setLayerType(this.useHardwareLayer && this.BH.isAnimating() ? 2 : 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
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
            /* renamed from: W */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        String BL;
        String animationName;
        int animationResId;
        boolean isAnimating;
        float progress;
        int repeatCount;
        int repeatMode;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.animationName = parcel.readString();
            this.progress = parcel.readFloat();
            this.isAnimating = parcel.readInt() == 1;
            this.BL = parcel.readString();
            this.repeatMode = parcel.readInt();
            this.repeatCount = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.animationName);
            parcel.writeFloat(this.progress);
            parcel.writeInt(this.isAnimating ? 1 : 0);
            parcel.writeString(this.BL);
            parcel.writeInt(this.repeatMode);
            parcel.writeInt(this.repeatCount);
        }
    }
}
