package com.airbnb.lottie;

import android.animation.Animator;
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
    private static final SparseArray<e> jT = new SparseArray<>();
    private static final SparseArray<WeakReference<e>> jU = new SparseArray<>();
    private static final Map<String, e> jV = new HashMap();
    private static final Map<String, WeakReference<e>> jW = new HashMap();
    private boolean autoPlay;
    private final h jX;
    private final f jY;
    private CacheStrategy jZ;
    private String kb;
    @RawRes
    private int kc;
    private boolean kd;
    private boolean ke;
    @Nullable
    private a kf;
    @Nullable
    private e kg;

    /* loaded from: classes2.dex */
    public enum CacheStrategy {
        None,
        Weak,
        Strong
    }

    public LottieAnimationView(Context context) {
        super(context);
        this.jX = new h() { // from class: com.airbnb.lottie.LottieAnimationView.1
            @Override // com.airbnb.lottie.h
            public void a(@Nullable e eVar) {
                if (eVar != null) {
                    LottieAnimationView.this.setComposition(eVar);
                }
                LottieAnimationView.this.kf = null;
            }
        };
        this.jY = new f();
        this.kd = false;
        this.autoPlay = false;
        this.ke = false;
        init(null);
    }

    public LottieAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jX = new h() { // from class: com.airbnb.lottie.LottieAnimationView.1
            @Override // com.airbnb.lottie.h
            public void a(@Nullable e eVar) {
                if (eVar != null) {
                    LottieAnimationView.this.setComposition(eVar);
                }
                LottieAnimationView.this.kf = null;
            }
        };
        this.jY = new f();
        this.kd = false;
        this.autoPlay = false;
        this.ke = false;
        init(attributeSet);
    }

    public LottieAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jX = new h() { // from class: com.airbnb.lottie.LottieAnimationView.1
            @Override // com.airbnb.lottie.h
            public void a(@Nullable e eVar) {
                if (eVar != null) {
                    LottieAnimationView.this.setComposition(eVar);
                }
                LottieAnimationView.this.kf = null;
            }
        };
        this.jY = new f();
        this.kd = false;
        this.autoPlay = false;
        this.ke = false;
        init(attributeSet);
    }

    private void init(@Nullable AttributeSet attributeSet) {
        String string;
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, j.a.LottieAnimationView);
        this.jZ = CacheStrategy.values()[obtainStyledAttributes.getInt(j.a.LottieAnimationView_lottie_cacheStrategy, CacheStrategy.Weak.ordinal())];
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
            this.jY.ba();
            this.autoPlay = true;
        }
        this.jY.k(obtainStyledAttributes.getBoolean(j.a.LottieAnimationView_lottie_loop, false));
        setImageAssetsFolder(obtainStyledAttributes.getString(j.a.LottieAnimationView_lottie_imageAssetsFolder));
        setProgress(obtainStyledAttributes.getFloat(j.a.LottieAnimationView_lottie_progress, 0.0f));
        j(obtainStyledAttributes.getBoolean(j.a.LottieAnimationView_lottie_enableMergePathsForKitKatAndAbove, false));
        if (obtainStyledAttributes.hasValue(j.a.LottieAnimationView_lottie_colorFilter)) {
            a(new k(obtainStyledAttributes.getColor(j.a.LottieAnimationView_lottie_colorFilter, 0)));
        }
        if (obtainStyledAttributes.hasValue(j.a.LottieAnimationView_lottie_scale)) {
            this.jY.setScale(obtainStyledAttributes.getFloat(j.a.LottieAnimationView_lottie_scale, 1.0f));
        }
        obtainStyledAttributes.recycle();
        if (com.airbnb.lottie.c.f.S(getContext()) == 0.0f) {
            this.jY.bu();
        }
        bc();
    }

    @Override // android.support.v7.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int i) {
        aY();
        aZ();
        super.setImageResource(i);
    }

    @Override // android.support.v7.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        if (drawable != this.jY) {
            aY();
        }
        aZ();
        super.setImageDrawable(drawable);
    }

    @Override // android.support.v7.widget.AppCompatImageView, android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        aY();
        aZ();
        super.setImageBitmap(bitmap);
    }

    public void a(@Nullable ColorFilter colorFilter) {
        this.jY.a(colorFilter);
    }

    @Override // android.widget.ImageView, android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(@NonNull Drawable drawable) {
        if (getDrawable() == this.jY) {
            super.invalidateDrawable(this.jY);
        } else {
            super.invalidateDrawable(drawable);
        }
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.kb = this.kb;
        savedState.kc = this.kc;
        savedState.progress = this.jY.getProgress();
        savedState.kl = this.jY.isAnimating();
        savedState.km = this.jY.isLooping();
        savedState.kn = this.jY.getImageAssetsFolder();
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
        this.kb = savedState.kb;
        if (!TextUtils.isEmpty(this.kb)) {
            setAnimation(this.kb);
        }
        this.kc = savedState.kc;
        if (this.kc != 0) {
            setAnimation(this.kc);
        }
        setProgress(savedState.progress);
        k(savedState.km);
        if (savedState.kl) {
            ba();
        }
        this.jY.G(savedState.kn);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.autoPlay && this.kd) {
            ba();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        if (isAnimating()) {
            bb();
            this.kd = true;
        }
        aY();
        super.onDetachedFromWindow();
    }

    @VisibleForTesting
    void aY() {
        if (this.jY != null) {
            this.jY.aY();
        }
    }

    public void j(boolean z) {
        this.jY.j(z);
    }

    public void setAnimation(@RawRes int i) {
        setAnimation(i, this.jZ);
    }

    public void setAnimation(@RawRes final int i, final CacheStrategy cacheStrategy) {
        this.kc = i;
        this.kb = null;
        if (jU.indexOfKey(i) > 0) {
            e eVar = jU.get(i).get();
            if (eVar != null) {
                setComposition(eVar);
                return;
            }
        } else if (jT.indexOfKey(i) > 0) {
            setComposition(jT.get(i));
            return;
        }
        this.jY.bb();
        aZ();
        this.kf = e.a.a(getContext(), i, new h() { // from class: com.airbnb.lottie.LottieAnimationView.2
            @Override // com.airbnb.lottie.h
            public void a(e eVar2) {
                if (cacheStrategy == CacheStrategy.Strong) {
                    LottieAnimationView.jT.put(i, eVar2);
                } else if (cacheStrategy == CacheStrategy.Weak) {
                    LottieAnimationView.jU.put(i, new WeakReference(eVar2));
                }
                LottieAnimationView.this.setComposition(eVar2);
            }
        });
    }

    public void setAnimation(String str) {
        setAnimation(str, this.jZ);
    }

    public void setAnimation(final String str, final CacheStrategy cacheStrategy) {
        this.kb = str;
        this.kc = 0;
        if (jW.containsKey(str)) {
            e eVar = jW.get(str).get();
            if (eVar != null) {
                setComposition(eVar);
                return;
            }
        } else if (jV.containsKey(str)) {
            setComposition(jV.get(str));
            return;
        }
        this.jY.bb();
        aZ();
        this.kf = e.a.a(getContext(), str, new h() { // from class: com.airbnb.lottie.LottieAnimationView.3
            @Override // com.airbnb.lottie.h
            public void a(e eVar2) {
                if (cacheStrategy == CacheStrategy.Strong) {
                    LottieAnimationView.jV.put(str, eVar2);
                } else if (cacheStrategy == CacheStrategy.Weak) {
                    LottieAnimationView.jW.put(str, new WeakReference(eVar2));
                }
                LottieAnimationView.this.setComposition(eVar2);
            }
        });
    }

    public void setAnimation(JSONObject jSONObject) {
        aZ();
        this.kf = e.a.a(getResources(), jSONObject, this.jX);
    }

    private void aZ() {
        if (this.kf != null) {
            this.kf.cancel();
            this.kf = null;
        }
    }

    public void setComposition(@NonNull e eVar) {
        this.jY.setCallback(this);
        boolean h = this.jY.h(eVar);
        bc();
        if (h) {
            setImageDrawable(null);
            setImageDrawable(this.jY);
            this.kg = eVar;
            requestLayout();
        }
    }

    public void ba() {
        this.jY.ba();
        bc();
    }

    public void setMinFrame(int i) {
        this.jY.setMinFrame(i);
    }

    public void setMinProgress(float f) {
        this.jY.setMinProgress(f);
    }

    public void setMaxFrame(int i) {
        this.jY.setMaxFrame(i);
    }

    public void setMaxProgress(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        this.jY.setMaxProgress(f);
    }

    public void setMinAndMaxFrame(int i, int i2) {
        this.jY.setMinAndMaxFrame(i, i2);
    }

    public void setMinAndMaxProgress(@FloatRange(from = 0.0d, to = 1.0d) float f, @FloatRange(from = 0.0d, to = 1.0d) float f2) {
        this.jY.setMinAndMaxProgress(f, f2);
    }

    public void setSpeed(float f) {
        this.jY.setSpeed(f);
    }

    public float getSpeed() {
        return this.jY.getSpeed();
    }

    public void a(Animator.AnimatorListener animatorListener) {
        this.jY.a(animatorListener);
    }

    public void k(boolean z) {
        this.jY.k(z);
    }

    public boolean isAnimating() {
        return this.jY.isAnimating();
    }

    public void setImageAssetsFolder(String str) {
        this.jY.G(str);
    }

    @Nullable
    public String getImageAssetsFolder() {
        return this.jY.getImageAssetsFolder();
    }

    public void setImageAssetDelegate(c cVar) {
        this.jY.setImageAssetDelegate(cVar);
    }

    public void setFontAssetDelegate(b bVar) {
        this.jY.setFontAssetDelegate(bVar);
    }

    public void setTextDelegate(l lVar) {
        this.jY.setTextDelegate(lVar);
    }

    public void setScale(float f) {
        this.jY.setScale(f);
        if (getDrawable() == this.jY) {
            setImageDrawable(null);
            setImageDrawable(this.jY);
        }
    }

    public float getScale() {
        return this.jY.getScale();
    }

    public void bb() {
        this.jY.bb();
        bc();
    }

    public void setFrame(int i) {
        this.jY.setFrame(i);
    }

    public int getFrame() {
        return this.jY.getFrame();
    }

    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        this.jY.setProgress(f);
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float getProgress() {
        return this.jY.getProgress();
    }

    public long getDuration() {
        if (this.kg != null) {
            return this.kg.getDuration();
        }
        return 0L;
    }

    public void setPerformanceTrackingEnabled(boolean z) {
        this.jY.setPerformanceTrackingEnabled(z);
    }

    @Nullable
    public i getPerformanceTracker() {
        return this.jY.getPerformanceTracker();
    }

    private void bc() {
        setLayerType(this.ke && this.jY.isAnimating() ? 2 : 1, null);
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
        String kb;
        int kc;
        boolean kl;
        boolean km;
        String kn;
        float progress;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.kb = parcel.readString();
            this.progress = parcel.readFloat();
            this.kl = parcel.readInt() == 1;
            this.km = parcel.readInt() == 1;
            this.kn = parcel.readString();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.kb);
            parcel.writeFloat(this.progress);
            parcel.writeInt(this.kl ? 1 : 0);
            parcel.writeInt(this.km ? 1 : 0);
            parcel.writeString(this.kn);
        }
    }
}
