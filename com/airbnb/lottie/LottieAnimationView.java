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
    private static final SparseArray<e> mk = new SparseArray<>();
    private static final SparseArray<WeakReference<e>> ml = new SparseArray<>();
    private static final Map<String, e> mm = new HashMap();
    private static final Map<String, WeakReference<e>> mn = new HashMap();
    private boolean autoPlay;
    private final h mo;
    private final f mp;
    private CacheStrategy mq;
    private String mr;
    @RawRes
    private int mt;
    private boolean mu;
    private boolean mw;
    @Nullable
    private a mx;
    @Nullable
    private e my;

    /* loaded from: classes2.dex */
    public enum CacheStrategy {
        None,
        Weak,
        Strong
    }

    public LottieAnimationView(Context context) {
        super(context);
        this.mo = new h() { // from class: com.airbnb.lottie.LottieAnimationView.1
            @Override // com.airbnb.lottie.h
            public void a(@Nullable e eVar) {
                if (eVar != null) {
                    LottieAnimationView.this.setComposition(eVar);
                }
                LottieAnimationView.this.mx = null;
            }
        };
        this.mp = new f();
        this.mu = false;
        this.autoPlay = false;
        this.mw = false;
        init(null);
    }

    public LottieAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mo = new h() { // from class: com.airbnb.lottie.LottieAnimationView.1
            @Override // com.airbnb.lottie.h
            public void a(@Nullable e eVar) {
                if (eVar != null) {
                    LottieAnimationView.this.setComposition(eVar);
                }
                LottieAnimationView.this.mx = null;
            }
        };
        this.mp = new f();
        this.mu = false;
        this.autoPlay = false;
        this.mw = false;
        init(attributeSet);
    }

    public LottieAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mo = new h() { // from class: com.airbnb.lottie.LottieAnimationView.1
            @Override // com.airbnb.lottie.h
            public void a(@Nullable e eVar) {
                if (eVar != null) {
                    LottieAnimationView.this.setComposition(eVar);
                }
                LottieAnimationView.this.mx = null;
            }
        };
        this.mp = new f();
        this.mu = false;
        this.autoPlay = false;
        this.mw = false;
        init(attributeSet);
    }

    private void init(@Nullable AttributeSet attributeSet) {
        String string;
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, j.a.LottieAnimationView);
        this.mq = CacheStrategy.values()[obtainStyledAttributes.getInt(j.a.LottieAnimationView_lottie_cacheStrategy, CacheStrategy.Weak.ordinal())];
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
            this.mp.ce();
            this.autoPlay = true;
        }
        this.mp.s(obtainStyledAttributes.getBoolean(j.a.LottieAnimationView_lottie_loop, false));
        setImageAssetsFolder(obtainStyledAttributes.getString(j.a.LottieAnimationView_lottie_imageAssetsFolder));
        setProgress(obtainStyledAttributes.getFloat(j.a.LottieAnimationView_lottie_progress, 0.0f));
        p(obtainStyledAttributes.getBoolean(j.a.LottieAnimationView_lottie_enableMergePathsForKitKatAndAbove, false));
        if (obtainStyledAttributes.hasValue(j.a.LottieAnimationView_lottie_colorFilter)) {
            a(new k(obtainStyledAttributes.getColor(j.a.LottieAnimationView_lottie_colorFilter, 0)));
        }
        if (obtainStyledAttributes.hasValue(j.a.LottieAnimationView_lottie_scale)) {
            this.mp.setScale(obtainStyledAttributes.getFloat(j.a.LottieAnimationView_lottie_scale, 1.0f));
        }
        obtainStyledAttributes.recycle();
        if (com.airbnb.lottie.c.f.az(getContext()) == 0.0f) {
            this.mp.cz();
        }
        ch();
    }

    @Override // android.support.v7.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int i) {
        cc();
        cd();
        super.setImageResource(i);
    }

    @Override // android.support.v7.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        if (drawable != this.mp) {
            cc();
        }
        cd();
        super.setImageDrawable(drawable);
    }

    @Override // android.support.v7.widget.AppCompatImageView, android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        cc();
        cd();
        super.setImageBitmap(bitmap);
    }

    public void a(@Nullable ColorFilter colorFilter) {
        this.mp.a(colorFilter);
    }

    @Override // android.widget.ImageView, android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(@NonNull Drawable drawable) {
        if (getDrawable() == this.mp) {
            super.invalidateDrawable(this.mp);
        } else {
            super.invalidateDrawable(drawable);
        }
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.mr = this.mr;
        savedState.mt = this.mt;
        savedState.progress = this.mp.getProgress();
        savedState.mF = this.mp.isAnimating();
        savedState.mG = this.mp.isLooping();
        savedState.mH = this.mp.getImageAssetsFolder();
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
        this.mr = savedState.mr;
        if (!TextUtils.isEmpty(this.mr)) {
            setAnimation(this.mr);
        }
        this.mt = savedState.mt;
        if (this.mt != 0) {
            setAnimation(this.mt);
        }
        setProgress(savedState.progress);
        s(savedState.mG);
        if (savedState.mF) {
            ce();
        }
        this.mp.X(savedState.mH);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.autoPlay && this.mu) {
            ce();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        if (isAnimating()) {
            cf();
            this.mu = true;
        }
        cc();
        super.onDetachedFromWindow();
    }

    @VisibleForTesting
    void cc() {
        if (this.mp != null) {
            this.mp.cc();
        }
    }

    public void p(boolean z) {
        this.mp.p(z);
    }

    public void q(boolean z) {
        this.mw = z;
        ch();
    }

    public void setAnimation(@RawRes int i) {
        setAnimation(i, this.mq);
    }

    public void setAnimation(@RawRes final int i, final CacheStrategy cacheStrategy) {
        this.mt = i;
        this.mr = null;
        if (ml.indexOfKey(i) > 0) {
            e eVar = ml.get(i).get();
            if (eVar != null) {
                setComposition(eVar);
                return;
            }
        } else if (mk.indexOfKey(i) > 0) {
            setComposition(mk.get(i));
            return;
        }
        this.mp.cf();
        cd();
        this.mx = e.a.a(getContext(), i, new h() { // from class: com.airbnb.lottie.LottieAnimationView.2
            @Override // com.airbnb.lottie.h
            public void a(e eVar2) {
                if (cacheStrategy == CacheStrategy.Strong) {
                    LottieAnimationView.mk.put(i, eVar2);
                } else if (cacheStrategy == CacheStrategy.Weak) {
                    LottieAnimationView.ml.put(i, new WeakReference(eVar2));
                }
                LottieAnimationView.this.setComposition(eVar2);
            }
        });
    }

    public void setAnimation(String str) {
        setAnimation(str, this.mq);
    }

    public void setAnimation(final String str, final CacheStrategy cacheStrategy) {
        this.mr = str;
        this.mt = 0;
        if (mn.containsKey(str)) {
            e eVar = mn.get(str).get();
            if (eVar != null) {
                setComposition(eVar);
                return;
            }
        } else if (mm.containsKey(str)) {
            setComposition(mm.get(str));
            return;
        }
        this.mp.cf();
        cd();
        this.mx = e.a.a(getContext(), str, new h() { // from class: com.airbnb.lottie.LottieAnimationView.3
            @Override // com.airbnb.lottie.h
            public void a(e eVar2) {
                if (cacheStrategy == CacheStrategy.Strong) {
                    LottieAnimationView.mm.put(str, eVar2);
                } else if (cacheStrategy == CacheStrategy.Weak) {
                    LottieAnimationView.mn.put(str, new WeakReference(eVar2));
                }
                LottieAnimationView.this.setComposition(eVar2);
            }
        });
    }

    public void setAnimation(JSONObject jSONObject) {
        cd();
        this.mx = e.a.a(getResources(), jSONObject, this.mo);
    }

    private void cd() {
        if (this.mx != null) {
            this.mx.cancel();
            this.mx = null;
        }
    }

    public void setComposition(@NonNull e eVar) {
        this.mp.setCallback(this);
        boolean h = this.mp.h(eVar);
        ch();
        if (h) {
            setImageDrawable(null);
            setImageDrawable(this.mp);
            this.my = eVar;
            requestLayout();
        }
    }

    public void ce() {
        this.mp.ce();
        ch();
    }

    public void setMinFrame(int i) {
        this.mp.setMinFrame(i);
    }

    public void setMinProgress(float f) {
        this.mp.setMinProgress(f);
    }

    public void setMaxFrame(int i) {
        this.mp.setMaxFrame(i);
    }

    public void setMaxProgress(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        this.mp.setMaxProgress(f);
    }

    public void setMinAndMaxFrame(int i, int i2) {
        this.mp.setMinAndMaxFrame(i, i2);
    }

    public void setMinAndMaxProgress(@FloatRange(from = 0.0d, to = 1.0d) float f, @FloatRange(from = 0.0d, to = 1.0d) float f2) {
        this.mp.setMinAndMaxProgress(f, f2);
    }

    public void setSpeed(float f) {
        this.mp.setSpeed(f);
    }

    public float getSpeed() {
        return this.mp.getSpeed();
    }

    public void a(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.mp.a(animatorUpdateListener);
    }

    public void a(Animator.AnimatorListener animatorListener) {
        this.mp.a(animatorListener);
    }

    public void b(Animator.AnimatorListener animatorListener) {
        this.mp.b(animatorListener);
    }

    public void s(boolean z) {
        this.mp.s(z);
    }

    public boolean isAnimating() {
        return this.mp.isAnimating();
    }

    public void setImageAssetsFolder(String str) {
        this.mp.X(str);
    }

    @Nullable
    public String getImageAssetsFolder() {
        return this.mp.getImageAssetsFolder();
    }

    public void setImageAssetDelegate(c cVar) {
        this.mp.setImageAssetDelegate(cVar);
    }

    public void setFontAssetDelegate(b bVar) {
        this.mp.setFontAssetDelegate(bVar);
    }

    public void setTextDelegate(l lVar) {
        this.mp.setTextDelegate(lVar);
    }

    public void setScale(float f) {
        this.mp.setScale(f);
        if (getDrawable() == this.mp) {
            setImageDrawable(null);
            setImageDrawable(this.mp);
        }
    }

    public float getScale() {
        return this.mp.getScale();
    }

    public void cf() {
        this.mp.cf();
        ch();
    }

    public void cg() {
        this.mp.cg();
        ch();
    }

    public void setFrame(int i) {
        this.mp.setFrame(i);
    }

    public int getFrame() {
        return this.mp.getFrame();
    }

    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        this.mp.setProgress(f);
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float getProgress() {
        return this.mp.getProgress();
    }

    public long getDuration() {
        if (this.my != null) {
            return this.my.getDuration();
        }
        return 0L;
    }

    public void setPerformanceTrackingEnabled(boolean z) {
        this.mp.setPerformanceTrackingEnabled(z);
    }

    @Nullable
    public i getPerformanceTracker() {
        return this.mp.getPerformanceTracker();
    }

    private void ch() {
        setLayerType(this.mw && this.mp.isAnimating() ? 2 : 1, null);
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
            /* renamed from: r */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        boolean mF;
        boolean mG;
        String mH;
        String mr;
        int mt;
        float progress;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.mr = parcel.readString();
            this.progress = parcel.readFloat();
            this.mF = parcel.readInt() == 1;
            this.mG = parcel.readInt() == 1;
            this.mH = parcel.readString();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.mr);
            parcel.writeFloat(this.progress);
            parcel.writeInt(this.mF ? 1 : 0);
            parcel.writeInt(this.mG ? 1 : 0);
            parcel.writeString(this.mH);
        }
    }
}
