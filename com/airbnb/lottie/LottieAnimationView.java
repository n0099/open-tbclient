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
    private boolean autoPlay;
    private final h kB;
    private final f kC;
    private CacheStrategy kD;
    private String kE;
    @RawRes
    private int kF;
    private boolean kG;
    private boolean kH;
    @Nullable
    private a kI;
    @Nullable
    private e kJ;
    private static final String TAG = LottieAnimationView.class.getSimpleName();
    private static final SparseArray<e> kv = new SparseArray<>();
    private static final SparseArray<WeakReference<e>> kx = new SparseArray<>();
    private static final Map<String, e> ky = new HashMap();
    private static final Map<String, WeakReference<e>> kA = new HashMap();

    /* loaded from: classes2.dex */
    public enum CacheStrategy {
        None,
        Weak,
        Strong
    }

    public LottieAnimationView(Context context) {
        super(context);
        this.kB = new h() { // from class: com.airbnb.lottie.LottieAnimationView.1
            @Override // com.airbnb.lottie.h
            public void a(@Nullable e eVar) {
                if (eVar != null) {
                    LottieAnimationView.this.setComposition(eVar);
                }
                LottieAnimationView.this.kI = null;
            }
        };
        this.kC = new f();
        this.kG = false;
        this.autoPlay = false;
        this.kH = false;
        init(null);
    }

    public LottieAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kB = new h() { // from class: com.airbnb.lottie.LottieAnimationView.1
            @Override // com.airbnb.lottie.h
            public void a(@Nullable e eVar) {
                if (eVar != null) {
                    LottieAnimationView.this.setComposition(eVar);
                }
                LottieAnimationView.this.kI = null;
            }
        };
        this.kC = new f();
        this.kG = false;
        this.autoPlay = false;
        this.kH = false;
        init(attributeSet);
    }

    public LottieAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kB = new h() { // from class: com.airbnb.lottie.LottieAnimationView.1
            @Override // com.airbnb.lottie.h
            public void a(@Nullable e eVar) {
                if (eVar != null) {
                    LottieAnimationView.this.setComposition(eVar);
                }
                LottieAnimationView.this.kI = null;
            }
        };
        this.kC = new f();
        this.kG = false;
        this.autoPlay = false;
        this.kH = false;
        init(attributeSet);
    }

    private void init(@Nullable AttributeSet attributeSet) {
        String string;
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, j.a.LottieAnimationView);
        this.kD = CacheStrategy.values()[obtainStyledAttributes.getInt(j.a.LottieAnimationView_lottie_cacheStrategy, CacheStrategy.Weak.ordinal())];
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
            this.kC.bo();
            this.autoPlay = true;
        }
        this.kC.y(obtainStyledAttributes.getBoolean(j.a.LottieAnimationView_lottie_loop, false));
        setImageAssetsFolder(obtainStyledAttributes.getString(j.a.LottieAnimationView_lottie_imageAssetsFolder));
        setProgress(obtainStyledAttributes.getFloat(j.a.LottieAnimationView_lottie_progress, 0.0f));
        w(obtainStyledAttributes.getBoolean(j.a.LottieAnimationView_lottie_enableMergePathsForKitKatAndAbove, false));
        if (obtainStyledAttributes.hasValue(j.a.LottieAnimationView_lottie_colorFilter)) {
            a(new k(obtainStyledAttributes.getColor(j.a.LottieAnimationView_lottie_colorFilter, 0)));
        }
        if (obtainStyledAttributes.hasValue(j.a.LottieAnimationView_lottie_scale)) {
            this.kC.setScale(obtainStyledAttributes.getFloat(j.a.LottieAnimationView_lottie_scale, 1.0f));
        }
        obtainStyledAttributes.recycle();
        if (com.airbnb.lottie.c.f.Q(getContext()) == 0.0f) {
            this.kC.bJ();
        }
        br();
    }

    @Override // android.support.v7.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int i) {
        bm();
        bn();
        super.setImageResource(i);
    }

    @Override // android.support.v7.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        if (drawable != this.kC) {
            bm();
        }
        bn();
        super.setImageDrawable(drawable);
    }

    @Override // android.support.v7.widget.AppCompatImageView, android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        bm();
        bn();
        super.setImageBitmap(bitmap);
    }

    public void a(@Nullable ColorFilter colorFilter) {
        this.kC.a(colorFilter);
    }

    @Override // android.widget.ImageView, android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(@NonNull Drawable drawable) {
        if (getDrawable() == this.kC) {
            super.invalidateDrawable(this.kC);
        } else {
            super.invalidateDrawable(drawable);
        }
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.kE = this.kE;
        savedState.kF = this.kF;
        savedState.progress = this.kC.getProgress();
        savedState.kO = this.kC.isAnimating();
        savedState.kP = this.kC.isLooping();
        savedState.kQ = this.kC.getImageAssetsFolder();
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
        this.kE = savedState.kE;
        if (!TextUtils.isEmpty(this.kE)) {
            setAnimation(this.kE);
        }
        this.kF = savedState.kF;
        if (this.kF != 0) {
            setAnimation(this.kF);
        }
        setProgress(savedState.progress);
        y(savedState.kP);
        if (savedState.kO) {
            bo();
        }
        this.kC.G(savedState.kQ);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.autoPlay && this.kG) {
            bo();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        if (isAnimating()) {
            cancelAnimation();
            this.kG = true;
        }
        bm();
        super.onDetachedFromWindow();
    }

    @VisibleForTesting
    void bm() {
        if (this.kC != null) {
            this.kC.bm();
        }
    }

    public void w(boolean z) {
        this.kC.w(z);
    }

    public void x(boolean z) {
        this.kH = z;
        br();
    }

    public void setAnimation(@RawRes int i) {
        setAnimation(i, this.kD);
    }

    public void setAnimation(@RawRes final int i, final CacheStrategy cacheStrategy) {
        this.kF = i;
        this.kE = null;
        if (kx.indexOfKey(i) > 0) {
            e eVar = kx.get(i).get();
            if (eVar != null) {
                setComposition(eVar);
                return;
            }
        } else if (kv.indexOfKey(i) > 0) {
            setComposition(kv.get(i));
            return;
        }
        this.kC.cancelAnimation();
        bn();
        this.kI = e.a.a(getContext(), i, new h() { // from class: com.airbnb.lottie.LottieAnimationView.2
            @Override // com.airbnb.lottie.h
            public void a(e eVar2) {
                if (cacheStrategy == CacheStrategy.Strong) {
                    LottieAnimationView.kv.put(i, eVar2);
                } else if (cacheStrategy == CacheStrategy.Weak) {
                    LottieAnimationView.kx.put(i, new WeakReference(eVar2));
                }
                LottieAnimationView.this.setComposition(eVar2);
            }
        });
    }

    public void setAnimation(String str) {
        setAnimation(str, this.kD);
    }

    public void setAnimation(final String str, final CacheStrategy cacheStrategy) {
        this.kE = str;
        this.kF = 0;
        if (kA.containsKey(str)) {
            e eVar = kA.get(str).get();
            if (eVar != null) {
                setComposition(eVar);
                return;
            }
        } else if (ky.containsKey(str)) {
            setComposition(ky.get(str));
            return;
        }
        this.kC.cancelAnimation();
        bn();
        this.kI = e.a.a(getContext(), str, new h() { // from class: com.airbnb.lottie.LottieAnimationView.3
            @Override // com.airbnb.lottie.h
            public void a(e eVar2) {
                if (cacheStrategy == CacheStrategy.Strong) {
                    LottieAnimationView.ky.put(str, eVar2);
                } else if (cacheStrategy == CacheStrategy.Weak) {
                    LottieAnimationView.kA.put(str, new WeakReference(eVar2));
                }
                LottieAnimationView.this.setComposition(eVar2);
            }
        });
    }

    public void setAnimation(JSONObject jSONObject) {
        bn();
        this.kI = e.a.a(getResources(), jSONObject, this.kB);
    }

    private void bn() {
        if (this.kI != null) {
            this.kI.cancel();
            this.kI = null;
        }
    }

    public void setComposition(@NonNull e eVar) {
        this.kC.setCallback(this);
        boolean h = this.kC.h(eVar);
        br();
        if (h) {
            setImageDrawable(null);
            setImageDrawable(this.kC);
            this.kJ = eVar;
            requestLayout();
        }
    }

    public void bo() {
        this.kC.bo();
        br();
    }

    public void bp() {
        this.kC.bp();
        br();
    }

    public void setMinFrame(int i) {
        this.kC.setMinFrame(i);
    }

    public void setMinProgress(float f) {
        this.kC.setMinProgress(f);
    }

    public void setMaxFrame(int i) {
        this.kC.setMaxFrame(i);
    }

    public void setMaxProgress(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        this.kC.setMaxProgress(f);
    }

    public void setMinAndMaxFrame(int i, int i2) {
        this.kC.setMinAndMaxFrame(i, i2);
    }

    public void setMinAndMaxProgress(@FloatRange(from = 0.0d, to = 1.0d) float f, @FloatRange(from = 0.0d, to = 1.0d) float f2) {
        this.kC.setMinAndMaxProgress(f, f2);
    }

    public void setSpeed(float f) {
        this.kC.setSpeed(f);
    }

    public float getSpeed() {
        return this.kC.getSpeed();
    }

    public void a(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.kC.a(animatorUpdateListener);
    }

    public void removeUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.kC.b(animatorUpdateListener);
    }

    public void a(Animator.AnimatorListener animatorListener) {
        this.kC.a(animatorListener);
    }

    public void b(Animator.AnimatorListener animatorListener) {
        this.kC.b(animatorListener);
    }

    public void y(boolean z) {
        this.kC.y(z);
    }

    public boolean isAnimating() {
        return this.kC.isAnimating();
    }

    public void setImageAssetsFolder(String str) {
        this.kC.G(str);
    }

    @Nullable
    public String getImageAssetsFolder() {
        return this.kC.getImageAssetsFolder();
    }

    public void setImageAssetDelegate(c cVar) {
        this.kC.setImageAssetDelegate(cVar);
    }

    public void setFontAssetDelegate(b bVar) {
        this.kC.setFontAssetDelegate(bVar);
    }

    public void setTextDelegate(l lVar) {
        this.kC.setTextDelegate(lVar);
    }

    public void setScale(float f) {
        this.kC.setScale(f);
        if (getDrawable() == this.kC) {
            setImageDrawable(null);
            setImageDrawable(this.kC);
        }
    }

    public float getScale() {
        return this.kC.getScale();
    }

    public void cancelAnimation() {
        this.kC.cancelAnimation();
        br();
    }

    public void bq() {
        this.kC.bq();
        br();
    }

    public void setFrame(int i) {
        this.kC.setFrame(i);
    }

    public int getFrame() {
        return this.kC.getFrame();
    }

    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        this.kC.setProgress(f);
    }

    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    public float getProgress() {
        return this.kC.getProgress();
    }

    public long getDuration() {
        if (this.kJ != null) {
            return this.kJ.getDuration();
        }
        return 0L;
    }

    public void setPerformanceTrackingEnabled(boolean z) {
        this.kC.setPerformanceTrackingEnabled(z);
    }

    @Nullable
    public i getPerformanceTracker() {
        return this.kC.getPerformanceTracker();
    }

    private void br() {
        setLayerType(this.kH && this.kC.isAnimating() ? 2 : 1, null);
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
        String kE;
        int kF;
        boolean kO;
        boolean kP;
        String kQ;
        float progress;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.kE = parcel.readString();
            this.progress = parcel.readFloat();
            this.kO = parcel.readInt() == 1;
            this.kP = parcel.readInt() == 1;
            this.kQ = parcel.readString();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.kE);
            parcel.writeFloat(this.progress);
            parcel.writeInt(this.kO ? 1 : 0);
            parcel.writeInt(this.kP ? 1 : 0);
            parcel.writeString(this.kQ);
        }
    }
}
