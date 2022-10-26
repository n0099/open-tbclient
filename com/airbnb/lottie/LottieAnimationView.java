package com.airbnb.lottie;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.view.ViewCompat;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.utils.Logger;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.LottieFrameInfo;
import com.airbnb.lottie.value.LottieValueCallback;
import com.airbnb.lottie.value.SimpleLottieValueCallback;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
/* loaded from: classes.dex */
public class LottieAnimationView extends AppCompatImageView {
    public String animationName;
    public int animationResId;
    public boolean autoPlay;
    public int buildDrawingCacheDepth;
    public boolean cacheComposition;
    public LottieComposition composition;
    public LottieTask compositionTask;
    public LottieListener failureListener;
    public int fallbackResource;
    public boolean isInitialized;
    public final LottieListener loadedListener;
    public final LottieDrawable lottieDrawable;
    public Set lottieOnCompositionLoadedListeners;
    public boolean playAnimationWhenShown;
    public RenderMode renderMode;
    public boolean wasAnimatingWhenDetached;
    public boolean wasAnimatingWhenNotShown;
    public final LottieListener wrappedFailureListener;
    public static final String TAG = LottieAnimationView.class.getSimpleName();
    public static final LottieListener DEFAULT_FAILURE_LISTENER = new LottieListener() { // from class: com.airbnb.lottie.LottieAnimationView.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.airbnb.lottie.LottieListener
        public void onResult(Throwable th) {
            if (Utils.isNetworkException(th)) {
                Logger.warning("Unable to load composition.", th);
                return;
            }
            throw new IllegalStateException("Unable to parse composition", th);
        }
    };

    /* renamed from: com.airbnb.lottie.LottieAnimationView$7  reason: invalid class name */
    /* loaded from: classes.dex */
    public /* synthetic */ class AnonymousClass7 {
        public static final /* synthetic */ int[] $SwitchMap$com$airbnb$lottie$RenderMode;

        static {
            int[] iArr = new int[RenderMode.values().length];
            $SwitchMap$com$airbnb$lottie$RenderMode = iArr;
            try {
                iArr[RenderMode.HARDWARE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$airbnb$lottie$RenderMode[RenderMode.SOFTWARE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$airbnb$lottie$RenderMode[RenderMode.AUTOMATIC.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private void cancelLoaderTask() {
        LottieTask lottieTask = this.compositionTask;
        if (lottieTask != null) {
            lottieTask.removeListener(this.loadedListener);
            this.compositionTask.removeFailureListener(this.wrappedFailureListener);
        }
    }

    private void clearComposition() {
        this.composition = null;
        this.lottieDrawable.clearComposition();
    }

    public void cancelAnimation() {
        this.wasAnimatingWhenDetached = false;
        this.wasAnimatingWhenNotShown = false;
        this.playAnimationWhenShown = false;
        this.lottieDrawable.cancelAnimation();
        enableOrDisableHardwareLayer();
    }

    public void disableExtraScaleModeInFitXY() {
        this.lottieDrawable.disableExtraScaleModeInFitXY();
    }

    public LottieComposition getComposition() {
        return this.composition;
    }

    public long getDuration() {
        LottieComposition lottieComposition = this.composition;
        if (lottieComposition != null) {
            return lottieComposition.getDuration();
        }
        return 0L;
    }

    public int getFrame() {
        return this.lottieDrawable.getFrame();
    }

    public String getImageAssetsFolder() {
        return this.lottieDrawable.getImageAssetsFolder();
    }

    public float getMaxFrame() {
        return this.lottieDrawable.getMaxFrame();
    }

    public float getMinFrame() {
        return this.lottieDrawable.getMinFrame();
    }

    public PerformanceTracker getPerformanceTracker() {
        return this.lottieDrawable.getPerformanceTracker();
    }

    public float getProgress() {
        return this.lottieDrawable.getProgress();
    }

    public int getRepeatCount() {
        return this.lottieDrawable.getRepeatCount();
    }

    public int getRepeatMode() {
        return this.lottieDrawable.getRepeatMode();
    }

    public float getScale() {
        return this.lottieDrawable.getScale();
    }

    public float getSpeed() {
        return this.lottieDrawable.getSpeed();
    }

    public boolean hasMasks() {
        return this.lottieDrawable.hasMasks();
    }

    public boolean hasMatte() {
        return this.lottieDrawable.hasMatte();
    }

    public boolean isAnimating() {
        return this.lottieDrawable.isAnimating();
    }

    public boolean isMergePathsEnabledForKitKatAndAbove() {
        return this.lottieDrawable.isMergePathsEnabledForKitKatAndAbove();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!isInEditMode() && (this.autoPlay || this.wasAnimatingWhenDetached)) {
            playAnimation();
            this.autoPlay = false;
            this.wasAnimatingWhenDetached = false;
        }
        if (Build.VERSION.SDK_INT < 23) {
            onVisibilityChanged(this, getVisibility());
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        if (isAnimating()) {
            cancelAnimation();
            this.wasAnimatingWhenDetached = true;
        }
        super.onDetachedFromWindow();
    }

    public void pauseAnimation() {
        this.autoPlay = false;
        this.wasAnimatingWhenDetached = false;
        this.wasAnimatingWhenNotShown = false;
        this.playAnimationWhenShown = false;
        this.lottieDrawable.pauseAnimation();
        enableOrDisableHardwareLayer();
    }

    public void playAnimation() {
        if (isShown()) {
            this.lottieDrawable.playAnimation();
            enableOrDisableHardwareLayer();
            return;
        }
        this.playAnimationWhenShown = true;
    }

    public void removeAllAnimatorListeners() {
        this.lottieDrawable.removeAllAnimatorListeners();
    }

    public void removeAllLottieOnCompositionLoadedListener() {
        this.lottieOnCompositionLoadedListeners.clear();
    }

    public void removeAllUpdateListeners() {
        this.lottieDrawable.removeAllUpdateListeners();
    }

    public void resumeAnimation() {
        if (isShown()) {
            this.lottieDrawable.resumeAnimation();
            enableOrDisableHardwareLayer();
            return;
        }
        this.playAnimationWhenShown = false;
        this.wasAnimatingWhenNotShown = true;
    }

    public void reverseAnimationSpeed() {
        this.lottieDrawable.reverseAnimationSpeed();
    }

    /* loaded from: classes.dex */
    public class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator CREATOR = new Parcelable.Creator() { // from class: com.airbnb.lottie.LottieAnimationView.SavedState.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        public String animationName;
        public int animationResId;
        public String imageAssetsFolder;
        public boolean isAnimating;
        public float progress;
        public int repeatCount;
        public int repeatMode;

        public SavedState(Parcel parcel) {
            super(parcel);
            this.animationName = parcel.readString();
            this.progress = parcel.readFloat();
            this.isAnimating = parcel.readInt() == 1;
            this.imageAssetsFolder = parcel.readString();
            this.repeatMode = parcel.readInt();
            this.repeatCount = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.animationName);
            parcel.writeFloat(this.progress);
            parcel.writeInt(this.isAnimating ? 1 : 0);
            parcel.writeString(this.imageAssetsFolder);
            parcel.writeInt(this.repeatMode);
            parcel.writeInt(this.repeatCount);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public LottieAnimationView(Context context) {
        super(context);
        this.loadedListener = new LottieListener() { // from class: com.airbnb.lottie.LottieAnimationView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.airbnb.lottie.LottieListener
            public void onResult(LottieComposition lottieComposition) {
                LottieAnimationView.this.setComposition(lottieComposition);
            }
        };
        this.wrappedFailureListener = new LottieListener() { // from class: com.airbnb.lottie.LottieAnimationView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.airbnb.lottie.LottieListener
            public void onResult(Throwable th) {
                LottieListener lottieListener;
                if (LottieAnimationView.this.fallbackResource != 0) {
                    LottieAnimationView lottieAnimationView = LottieAnimationView.this;
                    lottieAnimationView.setImageResource(lottieAnimationView.fallbackResource);
                }
                if (LottieAnimationView.this.failureListener == null) {
                    lottieListener = LottieAnimationView.DEFAULT_FAILURE_LISTENER;
                } else {
                    lottieListener = LottieAnimationView.this.failureListener;
                }
                lottieListener.onResult(th);
            }
        };
        this.fallbackResource = 0;
        this.lottieDrawable = new LottieDrawable();
        this.playAnimationWhenShown = false;
        this.wasAnimatingWhenNotShown = false;
        this.wasAnimatingWhenDetached = false;
        this.autoPlay = false;
        this.cacheComposition = true;
        this.renderMode = RenderMode.AUTOMATIC;
        this.lottieOnCompositionLoadedListeners = new HashSet();
        this.buildDrawingCacheDepth = 0;
        init(null, com.baidu.tieba.R.attr.lottieAnimationViewStyle);
    }

    @Override // android.view.View
    public void buildDrawingCache(boolean z) {
        L.beginSection("buildDrawingCache");
        this.buildDrawingCacheDepth++;
        super.buildDrawingCache(z);
        if (this.buildDrawingCacheDepth == 1 && getWidth() > 0 && getHeight() > 0 && getLayerType() == 1 && getDrawingCache(z) == null) {
            setRenderMode(RenderMode.HARDWARE);
        }
        this.buildDrawingCacheDepth--;
        L.endSection("buildDrawingCache");
    }

    public LottieAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.loadedListener = new LottieListener() { // from class: com.airbnb.lottie.LottieAnimationView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.airbnb.lottie.LottieListener
            public void onResult(LottieComposition lottieComposition) {
                LottieAnimationView.this.setComposition(lottieComposition);
            }
        };
        this.wrappedFailureListener = new LottieListener() { // from class: com.airbnb.lottie.LottieAnimationView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.airbnb.lottie.LottieListener
            public void onResult(Throwable th) {
                LottieListener lottieListener;
                if (LottieAnimationView.this.fallbackResource != 0) {
                    LottieAnimationView lottieAnimationView = LottieAnimationView.this;
                    lottieAnimationView.setImageResource(lottieAnimationView.fallbackResource);
                }
                if (LottieAnimationView.this.failureListener == null) {
                    lottieListener = LottieAnimationView.DEFAULT_FAILURE_LISTENER;
                } else {
                    lottieListener = LottieAnimationView.this.failureListener;
                }
                lottieListener.onResult(th);
            }
        };
        this.fallbackResource = 0;
        this.lottieDrawable = new LottieDrawable();
        this.playAnimationWhenShown = false;
        this.wasAnimatingWhenNotShown = false;
        this.wasAnimatingWhenDetached = false;
        this.autoPlay = false;
        this.cacheComposition = true;
        this.renderMode = RenderMode.AUTOMATIC;
        this.lottieOnCompositionLoadedListeners = new HashSet();
        this.buildDrawingCacheDepth = 0;
        init(attributeSet, com.baidu.tieba.R.attr.lottieAnimationViewStyle);
    }

    public LottieAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.loadedListener = new LottieListener() { // from class: com.airbnb.lottie.LottieAnimationView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.airbnb.lottie.LottieListener
            public void onResult(LottieComposition lottieComposition) {
                LottieAnimationView.this.setComposition(lottieComposition);
            }
        };
        this.wrappedFailureListener = new LottieListener() { // from class: com.airbnb.lottie.LottieAnimationView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.airbnb.lottie.LottieListener
            public void onResult(Throwable th) {
                LottieListener lottieListener;
                if (LottieAnimationView.this.fallbackResource != 0) {
                    LottieAnimationView lottieAnimationView = LottieAnimationView.this;
                    lottieAnimationView.setImageResource(lottieAnimationView.fallbackResource);
                }
                if (LottieAnimationView.this.failureListener == null) {
                    lottieListener = LottieAnimationView.DEFAULT_FAILURE_LISTENER;
                } else {
                    lottieListener = LottieAnimationView.this.failureListener;
                }
                lottieListener.onResult(th);
            }
        };
        this.fallbackResource = 0;
        this.lottieDrawable = new LottieDrawable();
        this.playAnimationWhenShown = false;
        this.wasAnimatingWhenNotShown = false;
        this.wasAnimatingWhenDetached = false;
        this.autoPlay = false;
        this.cacheComposition = true;
        this.renderMode = RenderMode.AUTOMATIC;
        this.lottieOnCompositionLoadedListeners = new HashSet();
        this.buildDrawingCacheDepth = 0;
        init(attributeSet, i);
    }

    private LottieTask fromAssets(final String str) {
        if (isInEditMode()) {
            return new LottieTask(new Callable() { // from class: com.airbnb.lottie.LottieAnimationView.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.concurrent.Callable
                public LottieResult call() throws Exception {
                    if (LottieAnimationView.this.cacheComposition) {
                        return LottieCompositionFactory.fromAssetSync(LottieAnimationView.this.getContext(), str);
                    }
                    return LottieCompositionFactory.fromAssetSync(LottieAnimationView.this.getContext(), str, null);
                }
            }, true);
        }
        if (this.cacheComposition) {
            return LottieCompositionFactory.fromAsset(getContext(), str);
        }
        return LottieCompositionFactory.fromAsset(getContext(), str, null);
    }

    private LottieTask fromRawRes(final int i) {
        if (isInEditMode()) {
            return new LottieTask(new Callable() { // from class: com.airbnb.lottie.LottieAnimationView.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.concurrent.Callable
                public LottieResult call() throws Exception {
                    if (LottieAnimationView.this.cacheComposition) {
                        return LottieCompositionFactory.fromRawResSync(LottieAnimationView.this.getContext(), i);
                    }
                    return LottieCompositionFactory.fromRawResSync(LottieAnimationView.this.getContext(), i, null);
                }
            }, true);
        }
        if (this.cacheComposition) {
            return LottieCompositionFactory.fromRawRes(getContext(), i);
        }
        return LottieCompositionFactory.fromRawRes(getContext(), i, null);
    }

    private void setCompositionTask(LottieTask lottieTask) {
        clearComposition();
        cancelLoaderTask();
        this.compositionTask = lottieTask.addListener(this.loadedListener).addFailureListener(this.wrappedFailureListener);
    }

    public void addAnimatorListener(Animator.AnimatorListener animatorListener) {
        this.lottieDrawable.addAnimatorListener(animatorListener);
    }

    public void addAnimatorUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.lottieDrawable.addAnimatorUpdateListener(animatorUpdateListener);
    }

    public boolean addLottieOnCompositionLoadedListener(LottieOnCompositionLoadedListener lottieOnCompositionLoadedListener) {
        LottieComposition lottieComposition = this.composition;
        if (lottieComposition != null) {
            lottieOnCompositionLoadedListener.onCompositionLoaded(lottieComposition);
        }
        return this.lottieOnCompositionLoadedListeners.add(lottieOnCompositionLoadedListener);
    }

    public void enableMergePathsForKitKatAndAbove(boolean z) {
        this.lottieDrawable.enableMergePathsForKitKatAndAbove(z);
    }

    @Override // android.widget.ImageView, android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        Drawable drawable2 = getDrawable();
        LottieDrawable lottieDrawable = this.lottieDrawable;
        if (drawable2 == lottieDrawable) {
            super.invalidateDrawable(lottieDrawable);
        } else {
            super.invalidateDrawable(drawable);
        }
    }

    @Deprecated
    public void loop(boolean z) {
        int i;
        LottieDrawable lottieDrawable = this.lottieDrawable;
        if (z) {
            i = -1;
        } else {
            i = 0;
        }
        lottieDrawable.setRepeatCount(i);
    }

    public void removeAnimatorListener(Animator.AnimatorListener animatorListener) {
        this.lottieDrawable.removeAnimatorListener(animatorListener);
    }

    public boolean removeLottieOnCompositionLoadedListener(LottieOnCompositionLoadedListener lottieOnCompositionLoadedListener) {
        return this.lottieOnCompositionLoadedListeners.remove(lottieOnCompositionLoadedListener);
    }

    public void removeUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.lottieDrawable.removeAnimatorUpdateListener(animatorUpdateListener);
    }

    public List resolveKeyPath(KeyPath keyPath) {
        return this.lottieDrawable.resolveKeyPath(keyPath);
    }

    public void setAnimation(int i) {
        this.animationResId = i;
        this.animationName = null;
        setCompositionTask(fromRawRes(i));
    }

    @Deprecated
    public void setAnimationFromJson(String str) {
        setAnimationFromJson(str, null);
    }

    public void setAnimationFromUrl(String str) {
        LottieTask fromUrl;
        if (this.cacheComposition) {
            fromUrl = LottieCompositionFactory.fromUrl(getContext(), str);
        } else {
            fromUrl = LottieCompositionFactory.fromUrl(getContext(), str, null);
        }
        setCompositionTask(fromUrl);
    }

    public void setApplyingOpacityToLayersEnabled(boolean z) {
        this.lottieDrawable.setApplyingOpacityToLayersEnabled(z);
    }

    public void setCacheComposition(boolean z) {
        this.cacheComposition = z;
    }

    public void setFailureListener(LottieListener lottieListener) {
        this.failureListener = lottieListener;
    }

    public void setFallbackResource(int i) {
        this.fallbackResource = i;
    }

    public void setFontAssetDelegate(FontAssetDelegate fontAssetDelegate) {
        this.lottieDrawable.setFontAssetDelegate(fontAssetDelegate);
    }

    public void setFrame(int i) {
        this.lottieDrawable.setFrame(i);
    }

    public void setImageAssetDelegate(ImageAssetDelegate imageAssetDelegate) {
        this.lottieDrawable.setImageAssetDelegate(imageAssetDelegate);
    }

    public void setImageAssetsFolder(String str) {
        this.lottieDrawable.setImagesAssetsFolder(str);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        cancelLoaderTask();
        super.setImageBitmap(bitmap);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        cancelLoaderTask();
        super.setImageDrawable(drawable);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int i) {
        cancelLoaderTask();
        super.setImageResource(i);
    }

    public void setMaxFrame(int i) {
        this.lottieDrawable.setMaxFrame(i);
    }

    public void setMaxProgress(float f) {
        this.lottieDrawable.setMaxProgress(f);
    }

    public void setMinAndMaxFrame(String str) {
        this.lottieDrawable.setMinAndMaxFrame(str);
    }

    public void setMinFrame(int i) {
        this.lottieDrawable.setMinFrame(i);
    }

    public void setMinProgress(float f) {
        this.lottieDrawable.setMinProgress(f);
    }

    public void setPerformanceTrackingEnabled(boolean z) {
        this.lottieDrawable.setPerformanceTrackingEnabled(z);
    }

    public void setProgress(float f) {
        this.lottieDrawable.setProgress(f);
    }

    public void setRenderMode(RenderMode renderMode) {
        this.renderMode = renderMode;
        enableOrDisableHardwareLayer();
    }

    public void setRepeatCount(int i) {
        this.lottieDrawable.setRepeatCount(i);
    }

    public void setRepeatMode(int i) {
        this.lottieDrawable.setRepeatMode(i);
    }

    public void setSafeMode(boolean z) {
        this.lottieDrawable.setSafeMode(z);
    }

    public void setScale(float f) {
        this.lottieDrawable.setScale(f);
        if (getDrawable() == this.lottieDrawable) {
            setImageDrawable(null);
            setImageDrawable(this.lottieDrawable);
        }
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        super.setScaleType(scaleType);
        LottieDrawable lottieDrawable = this.lottieDrawable;
        if (lottieDrawable != null) {
            lottieDrawable.setScaleType(scaleType);
        }
    }

    public void setSpeed(float f) {
        this.lottieDrawable.setSpeed(f);
    }

    public void setTextDelegate(TextDelegate textDelegate) {
        this.lottieDrawable.setTextDelegate(textDelegate);
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0044, code lost:
        if (r3 != false) goto L25;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void enableOrDisableHardwareLayer() {
        LottieComposition lottieComposition;
        int i;
        int i2 = AnonymousClass7.$SwitchMap$com$airbnb$lottie$RenderMode[this.renderMode.ordinal()];
        int i3 = 2;
        if (i2 != 1) {
            if (i2 != 2 && i2 == 3) {
                LottieComposition lottieComposition2 = this.composition;
                boolean z = false;
                if ((lottieComposition2 == null || !lottieComposition2.hasDashPattern() || Build.VERSION.SDK_INT >= 28) && (((lottieComposition = this.composition) == null || lottieComposition.getMaskAndMatteCount() <= 4) && (i = Build.VERSION.SDK_INT) >= 21 && i != 24 && i != 25)) {
                    z = true;
                }
            }
            i3 = 1;
        }
        if (i3 != getLayerType()) {
            setLayerType(i3, null);
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        boolean z;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.animationName = this.animationName;
        savedState.animationResId = this.animationResId;
        savedState.progress = this.lottieDrawable.getProgress();
        if (!this.lottieDrawable.isAnimating() && (ViewCompat.isAttachedToWindow(this) || !this.wasAnimatingWhenDetached)) {
            z = false;
        } else {
            z = true;
        }
        savedState.isAnimating = z;
        savedState.imageAssetsFolder = this.lottieDrawable.getImageAssetsFolder();
        savedState.repeatMode = this.lottieDrawable.getRepeatMode();
        savedState.repeatCount = this.lottieDrawable.getRepeatCount();
        return savedState;
    }

    private void init(AttributeSet attributeSet, int i) {
        String string;
        boolean z = false;
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.LottieAnimationView, i, 0);
        this.cacheComposition = obtainStyledAttributes.getBoolean(12, true);
        boolean hasValue = obtainStyledAttributes.hasValue(7);
        boolean hasValue2 = obtainStyledAttributes.hasValue(3);
        boolean hasValue3 = obtainStyledAttributes.hasValue(11);
        if (hasValue && hasValue2) {
            throw new IllegalArgumentException("lottie_rawRes and lottie_fileName cannot be used at the same time. Please use only one at once.");
        }
        if (hasValue) {
            int resourceId = obtainStyledAttributes.getResourceId(7, 0);
            if (resourceId != 0) {
                setAnimation(resourceId);
            }
        } else if (hasValue2) {
            String string2 = obtainStyledAttributes.getString(3);
            if (string2 != null) {
                setAnimation(string2);
            }
        } else if (hasValue3 && (string = obtainStyledAttributes.getString(11)) != null) {
            setAnimationFromUrl(string);
        }
        setFallbackResource(obtainStyledAttributes.getResourceId(13, 0));
        if (obtainStyledAttributes.getBoolean(0, false)) {
            this.wasAnimatingWhenDetached = true;
            this.autoPlay = true;
        }
        if (obtainStyledAttributes.getBoolean(5, false)) {
            this.lottieDrawable.setRepeatCount(-1);
        }
        if (obtainStyledAttributes.hasValue(9)) {
            setRepeatMode(obtainStyledAttributes.getInt(9, 1));
        }
        if (obtainStyledAttributes.hasValue(8)) {
            setRepeatCount(obtainStyledAttributes.getInt(8, -1));
        }
        if (obtainStyledAttributes.hasValue(15)) {
            setSpeed(obtainStyledAttributes.getFloat(15, 1.0f));
        }
        setImageAssetsFolder(obtainStyledAttributes.getString(4));
        setProgress(obtainStyledAttributes.getFloat(6, 0.0f));
        enableMergePathsForKitKatAndAbove(obtainStyledAttributes.getBoolean(2, false));
        if (obtainStyledAttributes.hasValue(1)) {
            addValueCallback(new KeyPath("**"), LottieProperty.COLOR_FILTER, new LottieValueCallback(new SimpleColorFilter(obtainStyledAttributes.getColor(1, 0))));
        }
        if (obtainStyledAttributes.hasValue(10)) {
            this.lottieDrawable.setScale(obtainStyledAttributes.getFloat(10, 1.0f));
        }
        if (obtainStyledAttributes.hasValue(14)) {
            int i2 = obtainStyledAttributes.getInt(14, RenderMode.AUTOMATIC.ordinal());
            if (i2 >= RenderMode.values().length) {
                i2 = RenderMode.AUTOMATIC.ordinal();
            }
            setRenderMode(RenderMode.values()[i2]);
        }
        if (getScaleType() != null) {
            this.lottieDrawable.setScaleType(getScaleType());
        }
        obtainStyledAttributes.recycle();
        LottieDrawable lottieDrawable = this.lottieDrawable;
        if (Utils.getAnimationScale(getContext()) != 0.0f) {
            z = true;
        }
        lottieDrawable.setSystemAnimationsAreEnabled(Boolean.valueOf(z));
        enableOrDisableHardwareLayer();
        this.isInitialized = true;
    }

    public void addValueCallback(KeyPath keyPath, Object obj, LottieValueCallback lottieValueCallback) {
        this.lottieDrawable.addValueCallback(keyPath, obj, lottieValueCallback);
    }

    public void setMinAndMaxFrame(String str, String str2, boolean z) {
        this.lottieDrawable.setMinAndMaxFrame(str, str2, z);
    }

    public void addValueCallback(KeyPath keyPath, Object obj, final SimpleLottieValueCallback simpleLottieValueCallback) {
        this.lottieDrawable.addValueCallback(keyPath, obj, new LottieValueCallback() { // from class: com.airbnb.lottie.LottieAnimationView.6
            @Override // com.airbnb.lottie.value.LottieValueCallback
            public Object getValue(LottieFrameInfo lottieFrameInfo) {
                return simpleLottieValueCallback.getValue(lottieFrameInfo);
            }
        });
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        String str = savedState.animationName;
        this.animationName = str;
        if (!TextUtils.isEmpty(str)) {
            setAnimation(this.animationName);
        }
        int i = savedState.animationResId;
        this.animationResId = i;
        if (i != 0) {
            setAnimation(i);
        }
        setProgress(savedState.progress);
        if (savedState.isAnimating) {
            playAnimation();
        }
        this.lottieDrawable.setImagesAssetsFolder(savedState.imageAssetsFolder);
        setRepeatMode(savedState.repeatMode);
        setRepeatCount(savedState.repeatCount);
    }

    public void setComposition(LottieComposition lottieComposition) {
        if (L.DBG) {
            String str = TAG;
            Log.v(str, "Set Composition \n" + lottieComposition);
        }
        this.lottieDrawable.setCallback(this);
        this.composition = lottieComposition;
        boolean composition = this.lottieDrawable.setComposition(lottieComposition);
        enableOrDisableHardwareLayer();
        if (getDrawable() == this.lottieDrawable && !composition) {
            return;
        }
        onVisibilityChanged(this, getVisibility());
        requestLayout();
        for (LottieOnCompositionLoadedListener lottieOnCompositionLoadedListener : this.lottieOnCompositionLoadedListeners) {
            lottieOnCompositionLoadedListener.onCompositionLoaded(lottieComposition);
        }
    }

    @Override // android.view.View
    public void onVisibilityChanged(View view2, int i) {
        if (!this.isInitialized) {
            return;
        }
        if (isShown()) {
            if (this.wasAnimatingWhenNotShown) {
                resumeAnimation();
            } else if (this.playAnimationWhenShown) {
                playAnimation();
            }
            this.wasAnimatingWhenNotShown = false;
            this.playAnimationWhenShown = false;
        } else if (isAnimating()) {
            pauseAnimation();
            this.wasAnimatingWhenNotShown = true;
        }
    }

    public void setAnimation(InputStream inputStream, String str) {
        setCompositionTask(LottieCompositionFactory.fromJsonInputStream(inputStream, str));
    }

    public void setAnimationFromJson(String str, String str2) {
        setAnimation(new ByteArrayInputStream(str.getBytes()), str2);
    }

    public void setAnimationFromUrl(String str, String str2) {
        setCompositionTask(LottieCompositionFactory.fromUrl(getContext(), str, str2));
    }

    public void setMinAndMaxFrame(int i, int i2) {
        this.lottieDrawable.setMinAndMaxFrame(i, i2);
    }

    public void setMinAndMaxProgress(float f, float f2) {
        this.lottieDrawable.setMinAndMaxProgress(f, f2);
    }

    public Bitmap updateBitmap(String str, Bitmap bitmap) {
        return this.lottieDrawable.updateBitmap(str, bitmap);
    }

    public void setAnimation(String str) {
        this.animationName = str;
        this.animationResId = 0;
        setCompositionTask(fromAssets(str));
    }

    public void setMaxFrame(String str) {
        this.lottieDrawable.setMaxFrame(str);
    }

    public void setMinFrame(String str) {
        this.lottieDrawable.setMinFrame(str);
    }
}
