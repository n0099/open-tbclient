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
    private static final SparseArray<e> nc = new SparseArray<>();
    private static final SparseArray<WeakReference<e>> nd = new SparseArray<>();
    private static final Map<String, e> ne = new HashMap();
    private static final Map<String, WeakReference<e>> nf = new HashMap();
    private boolean autoPlay;
    private final h ng;
    private final f nh;
    private CacheStrategy ni;
    private String nj;
    @RawRes
    private int nk;
    private boolean nl;
    private boolean nm;
    @Nullable
    private a nn;
    @Nullable
    private e np;

    /* loaded from: classes2.dex */
    public enum CacheStrategy {
        None,
        Weak,
        Strong
    }

    public LottieAnimationView(Context context) {
        super(context);
        this.ng = new h() { // from class: com.airbnb.lottie.LottieAnimationView.1
            @Override // com.airbnb.lottie.h
            public void a(@Nullable e eVar) {
                if (eVar != null) {
                    LottieAnimationView.this.setComposition(eVar);
                }
                LottieAnimationView.this.nn = null;
            }
        };
        this.nh = new f();
        this.nl = false;
        this.autoPlay = false;
        this.nm = false;
        init(null);
    }

    public LottieAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ng = new h() { // from class: com.airbnb.lottie.LottieAnimationView.1
            @Override // com.airbnb.lottie.h
            public void a(@Nullable e eVar) {
                if (eVar != null) {
                    LottieAnimationView.this.setComposition(eVar);
                }
                LottieAnimationView.this.nn = null;
            }
        };
        this.nh = new f();
        this.nl = false;
        this.autoPlay = false;
        this.nm = false;
        init(attributeSet);
    }

    public LottieAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ng = new h() { // from class: com.airbnb.lottie.LottieAnimationView.1
            @Override // com.airbnb.lottie.h
            public void a(@Nullable e eVar) {
                if (eVar != null) {
                    LottieAnimationView.this.setComposition(eVar);
                }
                LottieAnimationView.this.nn = null;
            }
        };
        this.nh = new f();
        this.nl = false;
        this.autoPlay = false;
        this.nm = false;
        init(attributeSet);
    }

    private void init(@Nullable AttributeSet attributeSet) {
        String string;
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, j.a.LottieAnimationView);
        this.ni = CacheStrategy.values()[obtainStyledAttributes.getInt(j.a.LottieAnimationView_lottie_cacheStrategy, CacheStrategy.Weak.ordinal())];
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
            this.nh.cv();
            this.autoPlay = true;
        }
        this.nh.G(obtainStyledAttributes.getBoolean(j.a.LottieAnimationView_lottie_loop, false));
        setImageAssetsFolder(obtainStyledAttributes.getString(j.a.LottieAnimationView_lottie_imageAssetsFolder));
        setProgress(obtainStyledAttributes.getFloat(j.a.LottieAnimationView_lottie_progress, 0.0f));
        E(obtainStyledAttributes.getBoolean(j.a.LottieAnimationView_lottie_enableMergePathsForKitKatAndAbove, false));
        if (obtainStyledAttributes.hasValue(j.a.LottieAnimationView_lottie_colorFilter)) {
            a(new k(obtainStyledAttributes.getColor(j.a.LottieAnimationView_lottie_colorFilter, 0)));
        }
        if (obtainStyledAttributes.hasValue(j.a.LottieAnimationView_lottie_scale)) {
            this.nh.setScale(obtainStyledAttributes.getFloat(j.a.LottieAnimationView_lottie_scale, 1.0f));
        }
        obtainStyledAttributes.recycle();
        if (com.airbnb.lottie.c.f.az(getContext()) == 0.0f) {
            this.nh.cQ();
        }
        cy();
    }

    @Override // android.support.v7.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int i) {
        ct();
        cu();
        super.setImageResource(i);
    }

    @Override // android.support.v7.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        if (drawable != this.nh) {
            ct();
        }
        cu();
        super.setImageDrawable(drawable);
    }

    @Override // android.support.v7.widget.AppCompatImageView, android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        ct();
        cu();
        super.setImageBitmap(bitmap);
    }

    public void a(@Nullable ColorFilter colorFilter) {
        this.nh.a(colorFilter);
    }

    @Override // android.widget.ImageView, android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(@NonNull Drawable drawable) {
        if (getDrawable() == this.nh) {
            super.invalidateDrawable(this.nh);
        } else {
            super.invalidateDrawable(drawable);
        }
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.nj = this.nj;
        savedState.nk = this.nk;
        savedState.progress = this.nh.getProgress();
        savedState.nu = this.nh.isAnimating();
        savedState.nv = this.nh.isLooping();
        savedState.nw = this.nh.getImageAssetsFolder();
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
        this.nj = savedState.nj;
        if (!TextUtils.isEmpty(this.nj)) {
            setAnimation(this.nj);
        }
        this.nk = savedState.nk;
        if (this.nk != 0) {
            setAnimation(this.nk);
        }
        setProgress(savedState.progress);
        G(savedState.nv);
        if (savedState.nu) {
            cv();
        }
        this.nh.X(savedState.nw);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.autoPlay && this.nl) {
            cv();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        if (isAnimating()) {
            cancelAnimation();
            this.nl = true;
        }
        ct();
        super.onDetachedFromWindow();
    }

    @VisibleForTesting
    void ct() {
        if (this.nh != null) {
            this.nh.ct();
        }
    }

    public void E(boolean z) {
        this.nh.E(z);
    }

    public void F(boolean z) {
        this.nm = z;
        cy();
    }

    public void setAnimation(@RawRes int i) {
        setAnimation(i, this.ni);
    }

    public void setAnimation(@RawRes final int i, final CacheStrategy cacheStrategy) {
        this.nk = i;
        this.nj = null;
        if (nd.indexOfKey(i) > 0) {
            e eVar = nd.get(i).get();
            if (eVar != null) {
                setComposition(eVar);
                return;
            }
        } else if (nc.indexOfKey(i) > 0) {
            setComposition(nc.get(i));
            return;
        }
        this.nh.cancelAnimation();
        cu();
        this.nn = e.a.a(getContext(), i, new h() { // from class: com.airbnb.lottie.LottieAnimationView.2
            @Override // com.airbnb.lottie.h
            public void a(e eVar2) {
                if (cacheStrategy == CacheStrategy.Strong) {
                    LottieAnimationView.nc.put(i, eVar2);
                } else if (cacheStrategy == CacheStrategy.Weak) {
                    LottieAnimationView.nd.put(i, new WeakReference(eVar2));
                }
                LottieAnimationView.this.setComposition(eVar2);
            }
        });
    }

    public void setAnimation(String str) {
        setAnimation(str, this.ni);
    }

    public void setAnimation(final String str, final CacheStrategy cacheStrategy) {
        this.nj = str;
        this.nk = 0;
        if (nf.containsKey(str)) {
            e eVar = nf.get(str).get();
            if (eVar != null) {
                setComposition(eVar);
                return;
            }
        } else if (ne.containsKey(str)) {
            setComposition(ne.get(str));
            return;
        }
        this.nh.cancelAnimation();
        cu();
        this.nn = e.a.a(getContext(), str, new h() { // from class: com.airbnb.lottie.LottieAnimationView.3
            @Override // com.airbnb.lottie.h
            public void a(e eVar2) {
                if (cacheStrategy == CacheStrategy.Strong) {
                    LottieAnimationView.ne.put(str, eVar2);
                } else if (cacheStrategy == CacheStrategy.Weak) {
                    LottieAnimationView.nf.put(str, new WeakReference(eVar2));
                }
                LottieAnimationView.this.setComposition(eVar2);
            }
        });
    }

    public void setAnimation(JSONObject jSONObject) {
        cu();
        this.nn = e.a.a(getResources(), jSONObject, this.ng);
    }

    private void cu() {
        if (this.nn != null) {
            this.nn.cancel();
            this.nn = null;
        }
    }

    public void setComposition(@NonNull e eVar) {
        this.nh.setCallback(this);
        boolean h = this.nh.h(eVar);
        cy();
        if (h) {
            setImageDrawable(null);
            setImageDrawable(this.nh);
            this.np = eVar;
            requestLayout();
        }
    }

    public void cv() {
        this.nh.cv();
        cy();
    }

    public void cw() {
        this.nh.cw();
        cy();
    }

    public void setMinFrame(int i) {
        this.nh.setMinFrame(i);
    }

    public void setMinProgress(float f) {
        this.nh.setMinProgress(f);
    }

    public void setMaxFrame(int i) {
        this.nh.setMaxFrame(i);
    }

    public void setMaxProgress(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        this.nh.setMaxProgress(f);
    }

    public void setMinAndMaxFrame(int i, int i2) {
        this.nh.setMinAndMaxFrame(i, i2);
    }

    public void setMinAndMaxProgress(@FloatRange(from = 0.0d, to = 1.0d) float f, @FloatRange(from = 0.0d, to = 1.0d) float f2) {
        this.nh.setMinAndMaxProgress(f, f2);
    }

    public void setSpeed(float f) {
        this.nh.setSpeed(f);
    }

    public float getSpeed() {
        return this.nh.getSpeed();
    }

    public void a(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.nh.a(animatorUpdateListener);
    }

    public void a(Animator.AnimatorListener animatorListener) {
        this.nh.a(animatorListener);
    }

    public void b(Animator.AnimatorListener animatorListener) {
        this.nh.b(animatorListener);
    }

    public void G(boolean z) {
        this.nh.G(z);
    }

    public boolean isAnimating() {
        return this.nh.isAnimating();
    }

    public void setImageAssetsFolder(String str) {
        this.nh.X(str);
    }

    @Nullable
    public String getImageAssetsFolder() {
        return this.nh.getImageAssetsFolder();
    }

    public void setImageAssetDelegate(c cVar) {
        this.nh.setImageAssetDelegate(cVar);
    }

    public void setFontAssetDelegate(b bVar) {
        this.nh.setFontAssetDelegate(bVar);
    }

    public void setTextDelegate(l lVar) {
        this.nh.setTextDelegate(lVar);
    }

    public void setScale(float f) {
        this.nh.setScale(f);
        if (getDrawable() == this.nh) {
            setImageDrawable(null);
            setImageDrawable(this.nh);
        }
    }

    public float getScale() {
        return this.nh.getScale();
    }

    public void cancelAnimation() {
        this.nh.cancelAnimation();
        cy();
    }

    public void cx() {
        this.nh.cx();
        cy();
    }

    public void setFrame(int i) {
        this.nh.setFrame(i);
    }

    public int getFrame() {
        return this.nh.getFrame();
    }

    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        this.nh.setProgress(f);
    }

    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    public float getProgress() {
        return this.nh.getProgress();
    }

    public long getDuration() {
        if (this.np != null) {
            return this.np.getDuration();
        }
        return 0L;
    }

    public void setPerformanceTrackingEnabled(boolean z) {
        this.nh.setPerformanceTrackingEnabled(z);
    }

    @Nullable
    public i getPerformanceTracker() {
        return this.nh.getPerformanceTracker();
    }

    private void cy() {
        setLayerType(this.nm && this.nh.isAnimating() ? 2 : 1, null);
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
            /* renamed from: I */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        String nj;
        int nk;
        boolean nu;
        boolean nv;
        String nw;
        float progress;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.nj = parcel.readString();
            this.progress = parcel.readFloat();
            this.nu = parcel.readInt() == 1;
            this.nv = parcel.readInt() == 1;
            this.nw = parcel.readString();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.nj);
            parcel.writeFloat(this.progress);
            parcel.writeInt(this.nu ? 1 : 0);
            parcel.writeInt(this.nv ? 1 : 0);
            parcel.writeString(this.nw);
        }
    }
}
