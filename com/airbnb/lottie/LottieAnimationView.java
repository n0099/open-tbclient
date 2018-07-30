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
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class LottieAnimationView extends AppCompatImageView {
    private static final String TAG = LottieAnimationView.class.getSimpleName();
    private static final SparseArray<e> jL = new SparseArray<>();
    private static final SparseArray<WeakReference<e>> jM = new SparseArray<>();
    private static final Map<String, e> jN = new HashMap();
    private static final Map<String, WeakReference<e>> jO = new HashMap();
    private boolean autoPlay;
    private final h jP;
    private final f jQ;
    private CacheStrategy jR;
    private String jS;
    @RawRes
    private int jT;
    private boolean jU;
    private boolean jV;
    @Nullable
    private a jW;
    @Nullable
    private e jX;

    /* loaded from: classes2.dex */
    public enum CacheStrategy {
        None,
        Weak,
        Strong
    }

    public LottieAnimationView(Context context) {
        super(context);
        this.jP = new h() { // from class: com.airbnb.lottie.LottieAnimationView.1
            @Override // com.airbnb.lottie.h
            public void a(@Nullable e eVar) {
                if (eVar != null) {
                    LottieAnimationView.this.setComposition(eVar);
                }
                LottieAnimationView.this.jW = null;
            }
        };
        this.jQ = new f();
        this.jU = false;
        this.autoPlay = false;
        this.jV = false;
        init(null);
    }

    public LottieAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jP = new h() { // from class: com.airbnb.lottie.LottieAnimationView.1
            @Override // com.airbnb.lottie.h
            public void a(@Nullable e eVar) {
                if (eVar != null) {
                    LottieAnimationView.this.setComposition(eVar);
                }
                LottieAnimationView.this.jW = null;
            }
        };
        this.jQ = new f();
        this.jU = false;
        this.autoPlay = false;
        this.jV = false;
        init(attributeSet);
    }

    public LottieAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jP = new h() { // from class: com.airbnb.lottie.LottieAnimationView.1
            @Override // com.airbnb.lottie.h
            public void a(@Nullable e eVar) {
                if (eVar != null) {
                    LottieAnimationView.this.setComposition(eVar);
                }
                LottieAnimationView.this.jW = null;
            }
        };
        this.jQ = new f();
        this.jU = false;
        this.autoPlay = false;
        this.jV = false;
        init(attributeSet);
    }

    private void init(@Nullable AttributeSet attributeSet) {
        String string;
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, j.a.LottieAnimationView);
        this.jR = CacheStrategy.values()[obtainStyledAttributes.getInt(j.a.LottieAnimationView_lottie_cacheStrategy, CacheStrategy.Weak.ordinal())];
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
            this.jQ.aX();
            this.autoPlay = true;
        }
        this.jQ.i(obtainStyledAttributes.getBoolean(j.a.LottieAnimationView_lottie_loop, false));
        setImageAssetsFolder(obtainStyledAttributes.getString(j.a.LottieAnimationView_lottie_imageAssetsFolder));
        setProgress(obtainStyledAttributes.getFloat(j.a.LottieAnimationView_lottie_progress, 0.0f));
        h(obtainStyledAttributes.getBoolean(j.a.LottieAnimationView_lottie_enableMergePathsForKitKatAndAbove, false));
        if (obtainStyledAttributes.hasValue(j.a.LottieAnimationView_lottie_colorFilter)) {
            a(new k(obtainStyledAttributes.getColor(j.a.LottieAnimationView_lottie_colorFilter, 0)));
        }
        if (obtainStyledAttributes.hasValue(j.a.LottieAnimationView_lottie_scale)) {
            this.jQ.setScale(obtainStyledAttributes.getFloat(j.a.LottieAnimationView_lottie_scale, 1.0f));
        }
        obtainStyledAttributes.recycle();
        if (com.airbnb.lottie.c.f.S(getContext()) == 0.0f) {
            this.jQ.bs();
        }
        ba();
    }

    @Override // android.support.v7.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int i) {
        aV();
        aW();
        super.setImageResource(i);
    }

    @Override // android.support.v7.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        if (drawable != this.jQ) {
            aV();
        }
        aW();
        super.setImageDrawable(drawable);
    }

    @Override // android.support.v7.widget.AppCompatImageView, android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        aV();
        aW();
        super.setImageBitmap(bitmap);
    }

    public void a(@Nullable ColorFilter colorFilter) {
        this.jQ.a(colorFilter);
    }

    @Override // android.widget.ImageView, android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(@NonNull Drawable drawable) {
        if (getDrawable() == this.jQ) {
            super.invalidateDrawable(this.jQ);
        } else {
            super.invalidateDrawable(drawable);
        }
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.jS = this.jS;
        savedState.jT = this.jT;
        savedState.progress = this.jQ.getProgress();
        savedState.kd = this.jQ.isAnimating();
        savedState.ke = this.jQ.isLooping();
        savedState.kf = this.jQ.getImageAssetsFolder();
        return savedState;
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.jS = savedState.jS;
        if (!TextUtils.isEmpty(this.jS)) {
            setAnimation(this.jS);
        }
        this.jT = savedState.jT;
        if (this.jT != 0) {
            setAnimation(this.jT);
        }
        setProgress(savedState.progress);
        i(savedState.ke);
        if (savedState.kd) {
            aX();
        }
        this.jQ.G(savedState.kf);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.autoPlay && this.jU) {
            aX();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        if (isAnimating()) {
            aY();
            this.jU = true;
        }
        aV();
        super.onDetachedFromWindow();
    }

    @VisibleForTesting
    void aV() {
        if (this.jQ != null) {
            this.jQ.aV();
        }
    }

    public void h(boolean z) {
        this.jQ.h(z);
    }

    public void setAnimation(@RawRes int i) {
        setAnimation(i, this.jR);
    }

    public void setAnimation(@RawRes final int i, final CacheStrategy cacheStrategy) {
        this.jT = i;
        this.jS = null;
        if (jM.indexOfKey(i) > 0) {
            e eVar = jM.get(i).get();
            if (eVar != null) {
                setComposition(eVar);
                return;
            }
        } else if (jL.indexOfKey(i) > 0) {
            setComposition(jL.get(i));
            return;
        }
        this.jQ.aY();
        aW();
        this.jW = e.a.a(getContext(), i, new h() { // from class: com.airbnb.lottie.LottieAnimationView.2
            @Override // com.airbnb.lottie.h
            public void a(e eVar2) {
                if (cacheStrategy == CacheStrategy.Strong) {
                    LottieAnimationView.jL.put(i, eVar2);
                } else if (cacheStrategy == CacheStrategy.Weak) {
                    LottieAnimationView.jM.put(i, new WeakReference(eVar2));
                }
                LottieAnimationView.this.setComposition(eVar2);
            }
        });
    }

    public void setAnimation(String str) {
        setAnimation(str, this.jR);
    }

    public void setAnimation(final String str, final CacheStrategy cacheStrategy) {
        this.jS = str;
        this.jT = 0;
        if (jO.containsKey(str)) {
            e eVar = jO.get(str).get();
            if (eVar != null) {
                setComposition(eVar);
                return;
            }
        } else if (jN.containsKey(str)) {
            setComposition(jN.get(str));
            return;
        }
        this.jQ.aY();
        aW();
        this.jW = e.a.a(getContext(), str, new h() { // from class: com.airbnb.lottie.LottieAnimationView.3
            @Override // com.airbnb.lottie.h
            public void a(e eVar2) {
                if (cacheStrategy == CacheStrategy.Strong) {
                    LottieAnimationView.jN.put(str, eVar2);
                } else if (cacheStrategy == CacheStrategy.Weak) {
                    LottieAnimationView.jO.put(str, new WeakReference(eVar2));
                }
                LottieAnimationView.this.setComposition(eVar2);
            }
        });
    }

    public void setAnimation(JSONObject jSONObject) {
        aW();
        this.jW = e.a.a(getResources(), jSONObject, this.jP);
    }

    private void aW() {
        if (this.jW != null) {
            this.jW.cancel();
            this.jW = null;
        }
    }

    public void setComposition(@NonNull e eVar) {
        this.jQ.setCallback(this);
        boolean h = this.jQ.h(eVar);
        ba();
        if (h) {
            setImageDrawable(null);
            setImageDrawable(this.jQ);
            this.jX = eVar;
            requestLayout();
        }
    }

    public void aX() {
        this.jQ.aX();
        ba();
    }

    public void setMinFrame(int i) {
        this.jQ.setMinFrame(i);
    }

    public void setMinProgress(float f) {
        this.jQ.setMinProgress(f);
    }

    public void setMaxFrame(int i) {
        this.jQ.setMaxFrame(i);
    }

    public void setMaxProgress(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        this.jQ.setMaxProgress(f);
    }

    public void setMinAndMaxFrame(int i, int i2) {
        this.jQ.setMinAndMaxFrame(i, i2);
    }

    public void setMinAndMaxProgress(@FloatRange(from = 0.0d, to = 1.0d) float f, @FloatRange(from = 0.0d, to = 1.0d) float f2) {
        this.jQ.setMinAndMaxProgress(f, f2);
    }

    public void setSpeed(float f) {
        this.jQ.setSpeed(f);
    }

    public float getSpeed() {
        return this.jQ.getSpeed();
    }

    public void a(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.jQ.a(animatorUpdateListener);
    }

    public void a(Animator.AnimatorListener animatorListener) {
        this.jQ.a(animatorListener);
    }

    public void b(Animator.AnimatorListener animatorListener) {
        this.jQ.b(animatorListener);
    }

    public void i(boolean z) {
        this.jQ.i(z);
    }

    public boolean isAnimating() {
        return this.jQ.isAnimating();
    }

    public void setImageAssetsFolder(String str) {
        this.jQ.G(str);
    }

    @Nullable
    public String getImageAssetsFolder() {
        return this.jQ.getImageAssetsFolder();
    }

    public void setImageAssetDelegate(c cVar) {
        this.jQ.setImageAssetDelegate(cVar);
    }

    public void setFontAssetDelegate(b bVar) {
        this.jQ.setFontAssetDelegate(bVar);
    }

    public void setTextDelegate(l lVar) {
        this.jQ.setTextDelegate(lVar);
    }

    public void setScale(float f) {
        this.jQ.setScale(f);
        if (getDrawable() == this.jQ) {
            setImageDrawable(null);
            setImageDrawable(this.jQ);
        }
    }

    public float getScale() {
        return this.jQ.getScale();
    }

    public void aY() {
        this.jQ.aY();
        ba();
    }

    public void aZ() {
        this.jQ.aZ();
        ba();
    }

    public void setFrame(int i) {
        this.jQ.setFrame(i);
    }

    public int getFrame() {
        return this.jQ.getFrame();
    }

    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        this.jQ.setProgress(f);
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float getProgress() {
        return this.jQ.getProgress();
    }

    public long getDuration() {
        if (this.jX != null) {
            return this.jX.getDuration();
        }
        return 0L;
    }

    public void setPerformanceTrackingEnabled(boolean z) {
        this.jQ.setPerformanceTrackingEnabled(z);
    }

    @Nullable
    public i getPerformanceTracker() {
        return this.jQ.getPerformanceTracker();
    }

    private void ba() {
        setLayerType(this.jV && this.jQ.isAnimating() ? 2 : 1, null);
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
        String jS;
        int jT;
        boolean kd;
        boolean ke;
        String kf;
        float progress;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.jS = parcel.readString();
            this.progress = parcel.readFloat();
            this.kd = parcel.readInt() == 1;
            this.ke = parcel.readInt() == 1;
            this.kf = parcel.readString();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.jS);
            parcel.writeFloat(this.progress);
            parcel.writeInt(this.kd ? 1 : 0);
            parcel.writeInt(this.ke ? 1 : 0);
            parcel.writeString(this.kf);
        }
    }
}
