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
    private static final SparseArray<e> jM = new SparseArray<>();
    private static final SparseArray<WeakReference<e>> jN = new SparseArray<>();
    private static final Map<String, e> jO = new HashMap();
    private static final Map<String, WeakReference<e>> jP = new HashMap();
    private boolean autoPlay;
    private final h jQ;
    private final f jR;
    private CacheStrategy jS;
    private String jT;
    @RawRes
    private int jU;
    private boolean jV;
    private boolean jW;
    @Nullable
    private a jX;
    @Nullable
    private e jY;

    /* loaded from: classes2.dex */
    public enum CacheStrategy {
        None,
        Weak,
        Strong
    }

    public LottieAnimationView(Context context) {
        super(context);
        this.jQ = new h() { // from class: com.airbnb.lottie.LottieAnimationView.1
            @Override // com.airbnb.lottie.h
            public void a(@Nullable e eVar) {
                if (eVar != null) {
                    LottieAnimationView.this.setComposition(eVar);
                }
                LottieAnimationView.this.jX = null;
            }
        };
        this.jR = new f();
        this.jV = false;
        this.autoPlay = false;
        this.jW = false;
        init(null);
    }

    public LottieAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jQ = new h() { // from class: com.airbnb.lottie.LottieAnimationView.1
            @Override // com.airbnb.lottie.h
            public void a(@Nullable e eVar) {
                if (eVar != null) {
                    LottieAnimationView.this.setComposition(eVar);
                }
                LottieAnimationView.this.jX = null;
            }
        };
        this.jR = new f();
        this.jV = false;
        this.autoPlay = false;
        this.jW = false;
        init(attributeSet);
    }

    public LottieAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jQ = new h() { // from class: com.airbnb.lottie.LottieAnimationView.1
            @Override // com.airbnb.lottie.h
            public void a(@Nullable e eVar) {
                if (eVar != null) {
                    LottieAnimationView.this.setComposition(eVar);
                }
                LottieAnimationView.this.jX = null;
            }
        };
        this.jR = new f();
        this.jV = false;
        this.autoPlay = false;
        this.jW = false;
        init(attributeSet);
    }

    private void init(@Nullable AttributeSet attributeSet) {
        String string;
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, j.a.LottieAnimationView);
        this.jS = CacheStrategy.values()[obtainStyledAttributes.getInt(j.a.LottieAnimationView_lottie_cacheStrategy, CacheStrategy.Weak.ordinal())];
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
            this.jR.aX();
            this.autoPlay = true;
        }
        this.jR.i(obtainStyledAttributes.getBoolean(j.a.LottieAnimationView_lottie_loop, false));
        setImageAssetsFolder(obtainStyledAttributes.getString(j.a.LottieAnimationView_lottie_imageAssetsFolder));
        setProgress(obtainStyledAttributes.getFloat(j.a.LottieAnimationView_lottie_progress, 0.0f));
        h(obtainStyledAttributes.getBoolean(j.a.LottieAnimationView_lottie_enableMergePathsForKitKatAndAbove, false));
        if (obtainStyledAttributes.hasValue(j.a.LottieAnimationView_lottie_colorFilter)) {
            a(new k(obtainStyledAttributes.getColor(j.a.LottieAnimationView_lottie_colorFilter, 0)));
        }
        if (obtainStyledAttributes.hasValue(j.a.LottieAnimationView_lottie_scale)) {
            this.jR.setScale(obtainStyledAttributes.getFloat(j.a.LottieAnimationView_lottie_scale, 1.0f));
        }
        obtainStyledAttributes.recycle();
        if (com.airbnb.lottie.c.f.S(getContext()) == 0.0f) {
            this.jR.bs();
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
        if (drawable != this.jR) {
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
        this.jR.a(colorFilter);
    }

    @Override // android.widget.ImageView, android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(@NonNull Drawable drawable) {
        if (getDrawable() == this.jR) {
            super.invalidateDrawable(this.jR);
        } else {
            super.invalidateDrawable(drawable);
        }
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.jT = this.jT;
        savedState.jU = this.jU;
        savedState.progress = this.jR.getProgress();
        savedState.ke = this.jR.isAnimating();
        savedState.kf = this.jR.isLooping();
        savedState.kg = this.jR.getImageAssetsFolder();
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
        this.jT = savedState.jT;
        if (!TextUtils.isEmpty(this.jT)) {
            setAnimation(this.jT);
        }
        this.jU = savedState.jU;
        if (this.jU != 0) {
            setAnimation(this.jU);
        }
        setProgress(savedState.progress);
        i(savedState.kf);
        if (savedState.ke) {
            aX();
        }
        this.jR.G(savedState.kg);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.autoPlay && this.jV) {
            aX();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        if (isAnimating()) {
            aY();
            this.jV = true;
        }
        aV();
        super.onDetachedFromWindow();
    }

    @VisibleForTesting
    void aV() {
        if (this.jR != null) {
            this.jR.aV();
        }
    }

    public void h(boolean z) {
        this.jR.h(z);
    }

    public void setAnimation(@RawRes int i) {
        setAnimation(i, this.jS);
    }

    public void setAnimation(@RawRes final int i, final CacheStrategy cacheStrategy) {
        this.jU = i;
        this.jT = null;
        if (jN.indexOfKey(i) > 0) {
            e eVar = jN.get(i).get();
            if (eVar != null) {
                setComposition(eVar);
                return;
            }
        } else if (jM.indexOfKey(i) > 0) {
            setComposition(jM.get(i));
            return;
        }
        this.jR.aY();
        aW();
        this.jX = e.a.a(getContext(), i, new h() { // from class: com.airbnb.lottie.LottieAnimationView.2
            @Override // com.airbnb.lottie.h
            public void a(e eVar2) {
                if (cacheStrategy == CacheStrategy.Strong) {
                    LottieAnimationView.jM.put(i, eVar2);
                } else if (cacheStrategy == CacheStrategy.Weak) {
                    LottieAnimationView.jN.put(i, new WeakReference(eVar2));
                }
                LottieAnimationView.this.setComposition(eVar2);
            }
        });
    }

    public void setAnimation(String str) {
        setAnimation(str, this.jS);
    }

    public void setAnimation(final String str, final CacheStrategy cacheStrategy) {
        this.jT = str;
        this.jU = 0;
        if (jP.containsKey(str)) {
            e eVar = jP.get(str).get();
            if (eVar != null) {
                setComposition(eVar);
                return;
            }
        } else if (jO.containsKey(str)) {
            setComposition(jO.get(str));
            return;
        }
        this.jR.aY();
        aW();
        this.jX = e.a.a(getContext(), str, new h() { // from class: com.airbnb.lottie.LottieAnimationView.3
            @Override // com.airbnb.lottie.h
            public void a(e eVar2) {
                if (cacheStrategy == CacheStrategy.Strong) {
                    LottieAnimationView.jO.put(str, eVar2);
                } else if (cacheStrategy == CacheStrategy.Weak) {
                    LottieAnimationView.jP.put(str, new WeakReference(eVar2));
                }
                LottieAnimationView.this.setComposition(eVar2);
            }
        });
    }

    public void setAnimation(JSONObject jSONObject) {
        aW();
        this.jX = e.a.a(getResources(), jSONObject, this.jQ);
    }

    private void aW() {
        if (this.jX != null) {
            this.jX.cancel();
            this.jX = null;
        }
    }

    public void setComposition(@NonNull e eVar) {
        this.jR.setCallback(this);
        boolean h = this.jR.h(eVar);
        ba();
        if (h) {
            setImageDrawable(null);
            setImageDrawable(this.jR);
            this.jY = eVar;
            requestLayout();
        }
    }

    public void aX() {
        this.jR.aX();
        ba();
    }

    public void setMinFrame(int i) {
        this.jR.setMinFrame(i);
    }

    public void setMinProgress(float f) {
        this.jR.setMinProgress(f);
    }

    public void setMaxFrame(int i) {
        this.jR.setMaxFrame(i);
    }

    public void setMaxProgress(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        this.jR.setMaxProgress(f);
    }

    public void setMinAndMaxFrame(int i, int i2) {
        this.jR.setMinAndMaxFrame(i, i2);
    }

    public void setMinAndMaxProgress(@FloatRange(from = 0.0d, to = 1.0d) float f, @FloatRange(from = 0.0d, to = 1.0d) float f2) {
        this.jR.setMinAndMaxProgress(f, f2);
    }

    public void setSpeed(float f) {
        this.jR.setSpeed(f);
    }

    public float getSpeed() {
        return this.jR.getSpeed();
    }

    public void a(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.jR.a(animatorUpdateListener);
    }

    public void a(Animator.AnimatorListener animatorListener) {
        this.jR.a(animatorListener);
    }

    public void b(Animator.AnimatorListener animatorListener) {
        this.jR.b(animatorListener);
    }

    public void i(boolean z) {
        this.jR.i(z);
    }

    public boolean isAnimating() {
        return this.jR.isAnimating();
    }

    public void setImageAssetsFolder(String str) {
        this.jR.G(str);
    }

    @Nullable
    public String getImageAssetsFolder() {
        return this.jR.getImageAssetsFolder();
    }

    public void setImageAssetDelegate(c cVar) {
        this.jR.setImageAssetDelegate(cVar);
    }

    public void setFontAssetDelegate(b bVar) {
        this.jR.setFontAssetDelegate(bVar);
    }

    public void setTextDelegate(l lVar) {
        this.jR.setTextDelegate(lVar);
    }

    public void setScale(float f) {
        this.jR.setScale(f);
        if (getDrawable() == this.jR) {
            setImageDrawable(null);
            setImageDrawable(this.jR);
        }
    }

    public float getScale() {
        return this.jR.getScale();
    }

    public void aY() {
        this.jR.aY();
        ba();
    }

    public void aZ() {
        this.jR.aZ();
        ba();
    }

    public void setFrame(int i) {
        this.jR.setFrame(i);
    }

    public int getFrame() {
        return this.jR.getFrame();
    }

    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        this.jR.setProgress(f);
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float getProgress() {
        return this.jR.getProgress();
    }

    public long getDuration() {
        if (this.jY != null) {
            return this.jY.getDuration();
        }
        return 0L;
    }

    public void setPerformanceTrackingEnabled(boolean z) {
        this.jR.setPerformanceTrackingEnabled(z);
    }

    @Nullable
    public i getPerformanceTracker() {
        return this.jR.getPerformanceTracker();
    }

    private void ba() {
        setLayerType(this.jW && this.jR.isAnimating() ? 2 : 1, null);
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
        String jT;
        int jU;
        boolean ke;
        boolean kf;
        String kg;
        float progress;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.jT = parcel.readString();
            this.progress = parcel.readFloat();
            this.ke = parcel.readInt() == 1;
            this.kf = parcel.readInt() == 1;
            this.kg = parcel.readString();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.jT);
            parcel.writeFloat(this.progress);
            parcel.writeInt(this.ke ? 1 : 0);
            parcel.writeInt(this.kf ? 1 : 0);
            parcel.writeString(this.kg);
        }
    }
}
