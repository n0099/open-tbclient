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
import com.baidu.mapapi.map.WeightedLatLng;
import d.a.a.d;
import d.a.a.f;
import d.a.a.h;
import d.a.a.i;
import d.a.a.j;
import d.a.a.l;
import d.a.a.m;
import d.a.a.n;
import d.a.a.o;
import d.a.a.p;
import d.a.a.w.e;
import java.io.StringReader;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* loaded from: classes.dex */
public class LottieAnimationView extends AppCompatImageView {
    public static final String TAG = LottieAnimationView.class.getSimpleName();
    public String animationName;
    @RawRes
    public int animationResId;
    public boolean autoPlay;
    @Nullable
    public d composition;
    @Nullable
    public l<d> compositionTask;
    public final h<Throwable> failureListener;
    public final h<d> loadedListener;
    public final f lottieDrawable;
    public Set<i> lottieOnCompositionLoadedListeners;
    public boolean useHardwareLayer;
    public boolean wasAnimatingWhenDetached;

    /* loaded from: classes.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: e  reason: collision with root package name */
        public String f1580e;

        /* renamed from: f  reason: collision with root package name */
        public int f1581f;

        /* renamed from: g  reason: collision with root package name */
        public float f1582g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f1583h;
        public String i;
        public int j;
        public int k;

        /* loaded from: classes.dex */
        public static class a implements Parcelable.Creator<SavedState> {
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        }

        public /* synthetic */ SavedState(Parcel parcel, a aVar) {
            this(parcel);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.f1580e);
            parcel.writeFloat(this.f1582g);
            parcel.writeInt(this.f1583h ? 1 : 0);
            parcel.writeString(this.i);
            parcel.writeInt(this.j);
            parcel.writeInt(this.k);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            this.f1580e = parcel.readString();
            this.f1582g = parcel.readFloat();
            this.f1583h = parcel.readInt() == 1;
            this.i = parcel.readString();
            this.j = parcel.readInt();
            this.k = parcel.readInt();
        }
    }

    /* loaded from: classes.dex */
    public class a implements h<d> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.a.h
        /* renamed from: a */
        public void onResult(d dVar) {
            LottieAnimationView.this.setComposition(dVar);
        }
    }

    /* loaded from: classes.dex */
    public class b implements h<Throwable> {
        public b() {
        }

        public void a(Throwable th) {
            throw new IllegalStateException("Unable to parse composition", th);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // d.a.a.h
        public /* bridge */ /* synthetic */ void onResult(Throwable th) {
            a(th);
            throw null;
        }
    }

    /* loaded from: classes.dex */
    public class c extends d.a.a.w.c<T> {

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ e f1586c;

        public c(e eVar) {
            this.f1586c = eVar;
        }

        /* JADX WARN: Type inference failed for: r2v1, types: [T, java.lang.Object] */
        @Override // d.a.a.w.c
        public T a(d.a.a.w.b<T> bVar) {
            return this.f1586c.a(bVar);
        }
    }

    public LottieAnimationView(Context context) {
        super(context);
        this.loadedListener = new a();
        this.failureListener = new b();
        this.lottieDrawable = new f();
        this.wasAnimatingWhenDetached = false;
        this.autoPlay = false;
        this.useHardwareLayer = false;
        this.lottieOnCompositionLoadedListeners = new HashSet();
        init(null);
    }

    private void cancelLoaderTask() {
        l<d> lVar = this.compositionTask;
        if (lVar != null) {
            lVar.m(this.loadedListener);
            this.compositionTask.l(this.failureListener);
        }
    }

    private void clearComposition() {
        this.composition = null;
        this.lottieDrawable.h();
    }

    private void enableOrDisableHardwareLayer() {
        setLayerType(this.useHardwareLayer && this.lottieDrawable.F() ? 2 : 1, null);
    }

    private void init(@Nullable AttributeSet attributeSet) {
        String string;
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, n.LottieAnimationView);
        if (!isInEditMode()) {
            boolean hasValue = obtainStyledAttributes.hasValue(n.LottieAnimationView_lottie_rawRes);
            boolean hasValue2 = obtainStyledAttributes.hasValue(n.LottieAnimationView_lottie_fileName);
            boolean hasValue3 = obtainStyledAttributes.hasValue(n.LottieAnimationView_lottie_url);
            if (hasValue && hasValue2) {
                throw new IllegalArgumentException("lottie_rawRes and lottie_fileName cannot be used at the same time. Please use only one at once.");
            }
            if (hasValue) {
                int resourceId = obtainStyledAttributes.getResourceId(n.LottieAnimationView_lottie_rawRes, 0);
                if (resourceId != 0) {
                    setAnimation(resourceId);
                }
            } else if (hasValue2) {
                String string2 = obtainStyledAttributes.getString(n.LottieAnimationView_lottie_fileName);
                if (string2 != null) {
                    setAnimation(string2);
                }
            } else if (hasValue3 && (string = obtainStyledAttributes.getString(n.LottieAnimationView_lottie_url)) != null) {
                setAnimationFromUrl(string);
            }
        }
        if (obtainStyledAttributes.getBoolean(n.LottieAnimationView_lottie_autoPlay, false)) {
            this.wasAnimatingWhenDetached = true;
            this.autoPlay = true;
        }
        if (obtainStyledAttributes.getBoolean(n.LottieAnimationView_lottie_loop, false)) {
            this.lottieDrawable.e0(-1);
        }
        if (obtainStyledAttributes.hasValue(n.LottieAnimationView_lottie_repeatMode)) {
            setRepeatMode(obtainStyledAttributes.getInt(n.LottieAnimationView_lottie_repeatMode, 1));
        }
        if (obtainStyledAttributes.hasValue(n.LottieAnimationView_lottie_repeatCount)) {
            setRepeatCount(obtainStyledAttributes.getInt(n.LottieAnimationView_lottie_repeatCount, -1));
        }
        setImageAssetsFolder(obtainStyledAttributes.getString(n.LottieAnimationView_lottie_imageAssetsFolder));
        setProgress(obtainStyledAttributes.getFloat(n.LottieAnimationView_lottie_progress, 0.0f));
        enableMergePathsForKitKatAndAbove(obtainStyledAttributes.getBoolean(n.LottieAnimationView_lottie_enableMergePathsForKitKatAndAbove, false));
        if (obtainStyledAttributes.hasValue(n.LottieAnimationView_lottie_colorFilter)) {
            addValueCallback(new d.a.a.s.e("**"), (d.a.a.s.e) j.x, (d.a.a.w.c<d.a.a.s.e>) new d.a.a.w.c(new o(obtainStyledAttributes.getColor(n.LottieAnimationView_lottie_colorFilter, 0))));
        }
        if (obtainStyledAttributes.hasValue(n.LottieAnimationView_lottie_scale)) {
            this.lottieDrawable.g0(obtainStyledAttributes.getFloat(n.LottieAnimationView_lottie_scale, 1.0f));
        }
        obtainStyledAttributes.recycle();
        enableOrDisableHardwareLayer();
    }

    private void setCompositionTask(l<d> lVar) {
        clearComposition();
        cancelLoaderTask();
        lVar.h(this.loadedListener);
        lVar.g(this.failureListener);
        this.compositionTask = lVar;
    }

    public void addAnimatorListener(Animator.AnimatorListener animatorListener) {
        this.lottieDrawable.c(animatorListener);
    }

    public void addAnimatorUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.lottieDrawable.d(animatorUpdateListener);
    }

    public boolean addLottieOnCompositionLoadedListener(@NonNull i iVar) {
        return this.lottieOnCompositionLoadedListeners.add(iVar);
    }

    public <T> void addValueCallback(d.a.a.s.e eVar, T t, d.a.a.w.c<T> cVar) {
        this.lottieDrawable.e(eVar, t, cVar);
    }

    @MainThread
    public void cancelAnimation() {
        this.lottieDrawable.g();
        enableOrDisableHardwareLayer();
    }

    public void enableMergePathsForKitKatAndAbove(boolean z) {
        this.lottieDrawable.i(z);
    }

    @Nullable
    public d getComposition() {
        return this.composition;
    }

    public long getDuration() {
        d dVar = this.composition;
        if (dVar != null) {
            return dVar.d();
        }
        return 0L;
    }

    public int getFrame() {
        return this.lottieDrawable.o();
    }

    @Nullable
    public String getImageAssetsFolder() {
        return this.lottieDrawable.r();
    }

    public float getMaxFrame() {
        return this.lottieDrawable.s();
    }

    public float getMinFrame() {
        return this.lottieDrawable.u();
    }

    @Nullable
    public m getPerformanceTracker() {
        return this.lottieDrawable.v();
    }

    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    public float getProgress() {
        return this.lottieDrawable.w();
    }

    public int getRepeatCount() {
        return this.lottieDrawable.x();
    }

    public int getRepeatMode() {
        return this.lottieDrawable.y();
    }

    public float getScale() {
        return this.lottieDrawable.z();
    }

    public float getSpeed() {
        return this.lottieDrawable.A();
    }

    public boolean getUseHardwareAcceleration() {
        return this.useHardwareLayer;
    }

    public boolean hasMasks() {
        return this.lottieDrawable.D();
    }

    public boolean hasMatte() {
        return this.lottieDrawable.E();
    }

    @Override // android.widget.ImageView, android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(@NonNull Drawable drawable) {
        Drawable drawable2 = getDrawable();
        f fVar = this.lottieDrawable;
        if (drawable2 == fVar) {
            super.invalidateDrawable(fVar);
        } else {
            super.invalidateDrawable(drawable);
        }
    }

    public boolean isAnimating() {
        return this.lottieDrawable.F();
    }

    public boolean isMergePathsEnabledForKitKatAndAbove() {
        return this.lottieDrawable.G();
    }

    @Deprecated
    public void loop(boolean z) {
        this.lottieDrawable.e0(z ? -1 : 0);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.autoPlay && this.wasAnimatingWhenDetached) {
            playAnimation();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        if (isAnimating()) {
            cancelAnimation();
            this.wasAnimatingWhenDetached = true;
        }
        recycleBitmaps();
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        String str = savedState.f1580e;
        this.animationName = str;
        if (!TextUtils.isEmpty(str)) {
            setAnimation(this.animationName);
        }
        int i = savedState.f1581f;
        this.animationResId = i;
        if (i != 0) {
            setAnimation(i);
        }
        setProgress(savedState.f1582g);
        if (savedState.f1583h) {
            playAnimation();
        }
        this.lottieDrawable.V(savedState.i);
        setRepeatMode(savedState.j);
        setRepeatCount(savedState.k);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f1580e = this.animationName;
        savedState.f1581f = this.animationResId;
        savedState.f1582g = this.lottieDrawable.w();
        savedState.f1583h = this.lottieDrawable.F();
        savedState.i = this.lottieDrawable.r();
        savedState.j = this.lottieDrawable.y();
        savedState.k = this.lottieDrawable.x();
        return savedState;
    }

    @MainThread
    public void pauseAnimation() {
        this.lottieDrawable.H();
        enableOrDisableHardwareLayer();
    }

    @MainThread
    public void playAnimation() {
        this.lottieDrawable.I();
        enableOrDisableHardwareLayer();
    }

    @VisibleForTesting
    public void recycleBitmaps() {
        this.lottieDrawable.J();
    }

    public void removeAllAnimatorListeners() {
        this.lottieDrawable.K();
    }

    public void removeAllLottieOnCompositionLoadedListener() {
        this.lottieOnCompositionLoadedListeners.clear();
    }

    public void removeAllUpdateListeners() {
        this.lottieDrawable.L();
    }

    public void removeAnimatorListener(Animator.AnimatorListener animatorListener) {
        this.lottieDrawable.M(animatorListener);
    }

    public boolean removeLottieOnCompositionLoadedListener(@NonNull i iVar) {
        return this.lottieOnCompositionLoadedListeners.remove(iVar);
    }

    public void removeUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.lottieDrawable.N(animatorUpdateListener);
    }

    public List<d.a.a.s.e> resolveKeyPath(d.a.a.s.e eVar) {
        return this.lottieDrawable.O(eVar);
    }

    @MainThread
    public void resumeAnimation() {
        this.lottieDrawable.P();
        enableOrDisableHardwareLayer();
    }

    public void reverseAnimationSpeed() {
        this.lottieDrawable.Q();
    }

    public void setAnimation(@RawRes int i) {
        this.animationResId = i;
        this.animationName = null;
        setCompositionTask(d.a.a.e.k(getContext(), i));
    }

    @Deprecated
    public void setAnimationFromJson(String str) {
        setAnimationFromJson(str, null);
    }

    public void setAnimationFromUrl(String str) {
        setCompositionTask(d.a.a.e.m(getContext(), str));
    }

    public void setComposition(@NonNull d dVar) {
        if (d.a.a.c.f41120a) {
            String str = TAG;
            Log.v(str, "Set Composition \n" + dVar);
        }
        this.lottieDrawable.setCallback(this);
        this.composition = dVar;
        boolean R = this.lottieDrawable.R(dVar);
        enableOrDisableHardwareLayer();
        if (getDrawable() != this.lottieDrawable || R) {
            setImageDrawable(null);
            setImageDrawable(this.lottieDrawable);
            requestLayout();
            for (i iVar : this.lottieOnCompositionLoadedListeners) {
                iVar.a(dVar);
            }
        }
    }

    public void setFontAssetDelegate(d.a.a.a aVar) {
        this.lottieDrawable.S(aVar);
    }

    public void setFrame(int i) {
        this.lottieDrawable.T(i);
    }

    public void setImageAssetDelegate(d.a.a.b bVar) {
        this.lottieDrawable.U(bVar);
    }

    public void setImageAssetsFolder(String str) {
        this.lottieDrawable.V(str);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        recycleBitmaps();
        cancelLoaderTask();
        super.setImageBitmap(bitmap);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        setImageDrawable(drawable, true);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int i) {
        recycleBitmaps();
        cancelLoaderTask();
        super.setImageResource(i);
    }

    public void setMaxFrame(int i) {
        this.lottieDrawable.W(i);
    }

    public void setMaxProgress(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        this.lottieDrawable.X(f2);
    }

    public void setMinAndMaxFrame(int i, int i2) {
        this.lottieDrawable.Y(i, i2);
    }

    public void setMinAndMaxProgress(@FloatRange(from = 0.0d, to = 1.0d) float f2, @FloatRange(from = 0.0d, to = 1.0d) float f3) {
        this.lottieDrawable.Z(f2, f3);
    }

    public void setMinFrame(int i) {
        this.lottieDrawable.a0(i);
    }

    public void setMinProgress(float f2) {
        this.lottieDrawable.b0(f2);
    }

    public void setPerformanceTrackingEnabled(boolean z) {
        this.lottieDrawable.c0(z);
    }

    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        this.lottieDrawable.d0(f2);
    }

    public void setRepeatCount(int i) {
        this.lottieDrawable.e0(i);
    }

    public void setRepeatMode(int i) {
        this.lottieDrawable.f0(i);
    }

    public void setScale(float f2) {
        this.lottieDrawable.g0(f2);
        if (getDrawable() == this.lottieDrawable) {
            setImageDrawable(null, false);
            setImageDrawable(this.lottieDrawable, false);
        }
    }

    public void setSpeed(float f2) {
        this.lottieDrawable.h0(f2);
    }

    public void setTextDelegate(p pVar) {
        this.lottieDrawable.i0(pVar);
    }

    @Nullable
    public Bitmap updateBitmap(String str, @Nullable Bitmap bitmap) {
        return this.lottieDrawable.j0(str, bitmap);
    }

    @Deprecated
    public void useExperimentalHardwareAcceleration() {
        useHardwareAcceleration(true);
    }

    public void useHardwareAcceleration() {
        useHardwareAcceleration(true);
    }

    private void setImageDrawable(Drawable drawable, boolean z) {
        if (z && drawable != this.lottieDrawable) {
            recycleBitmaps();
        }
        cancelLoaderTask();
        super.setImageDrawable(drawable);
    }

    public <T> void addValueCallback(d.a.a.s.e eVar, T t, e<T> eVar2) {
        this.lottieDrawable.e(eVar, t, new c(eVar2));
    }

    public void setAnimationFromJson(String str, @Nullable String str2) {
        setAnimation(new JsonReader(new StringReader(str)), str2);
    }

    @Deprecated
    public void useExperimentalHardwareAcceleration(boolean z) {
        useHardwareAcceleration(z);
    }

    public void useHardwareAcceleration(boolean z) {
        if (this.useHardwareLayer == z) {
            return;
        }
        this.useHardwareLayer = z;
        enableOrDisableHardwareLayer();
    }

    public void setAnimation(String str) {
        this.animationName = str;
        this.animationResId = 0;
        setCompositionTask(d.a.a.e.d(getContext(), str));
    }

    public void setAnimation(JsonReader jsonReader, @Nullable String str) {
        setCompositionTask(d.a.a.e.i(jsonReader, str));
    }

    public LottieAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.loadedListener = new a();
        this.failureListener = new b();
        this.lottieDrawable = new f();
        this.wasAnimatingWhenDetached = false;
        this.autoPlay = false;
        this.useHardwareLayer = false;
        this.lottieOnCompositionLoadedListeners = new HashSet();
        init(attributeSet);
    }

    public LottieAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.loadedListener = new a();
        this.failureListener = new b();
        this.lottieDrawable = new f();
        this.wasAnimatingWhenDetached = false;
        this.autoPlay = false;
        this.useHardwareLayer = false;
        this.lottieOnCompositionLoadedListeners = new HashSet();
        init(attributeSet);
    }
}
