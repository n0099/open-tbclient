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
import androidx.annotation.AttrRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.view.ViewCompat;
import d.a.a.h;
import d.a.a.j;
import d.a.a.k;
import d.a.a.l;
import d.a.a.m;
import d.a.a.n;
import d.a.a.o;
import d.a.a.p;
import d.a.a.q;
import d.a.a.r;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
/* loaded from: classes.dex */
public class LottieAnimationView extends AppCompatImageView {
    public String animationName;
    @RawRes
    public int animationResId;
    public boolean autoPlay;
    public int buildDrawingCacheDepth;
    public boolean cacheComposition;
    @Nullable
    public d.a.a.d composition;
    @Nullable
    public m<d.a.a.d> compositionTask;
    @Nullable
    public h<Throwable> failureListener;
    @DrawableRes
    public int fallbackResource;
    public boolean isInitialized;
    public final h<d.a.a.d> loadedListener;
    public final d.a.a.f lottieDrawable;
    public Set<j> lottieOnCompositionLoadedListeners;
    public boolean playAnimationWhenShown;
    public RenderMode renderMode;
    public boolean wasAnimatingWhenDetached;
    public boolean wasAnimatingWhenNotShown;
    public final h<Throwable> wrappedFailureListener;
    public static final String TAG = LottieAnimationView.class.getSimpleName();
    public static final h<Throwable> DEFAULT_FAILURE_LISTENER = new a();

    /* loaded from: classes.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: e  reason: collision with root package name */
        public String f1566e;

        /* renamed from: f  reason: collision with root package name */
        public int f1567f;

        /* renamed from: g  reason: collision with root package name */
        public float f1568g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f1569h;
        public String i;
        public int j;
        public int k;

        /* loaded from: classes.dex */
        public class a implements Parcelable.Creator<SavedState> {
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
            parcel.writeString(this.f1566e);
            parcel.writeFloat(this.f1568g);
            parcel.writeInt(this.f1569h ? 1 : 0);
            parcel.writeString(this.i);
            parcel.writeInt(this.j);
            parcel.writeInt(this.k);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            this.f1566e = parcel.readString();
            this.f1568g = parcel.readFloat();
            this.f1569h = parcel.readInt() == 1;
            this.i = parcel.readString();
            this.j = parcel.readInt();
            this.k = parcel.readInt();
        }
    }

    /* loaded from: classes.dex */
    public class a implements h<Throwable> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.a.h
        /* renamed from: a */
        public void onResult(Throwable th) {
            if (d.a.a.x.h.k(th)) {
                d.a.a.x.d.d("Unable to load composition.", th);
                return;
            }
            throw new IllegalStateException("Unable to parse composition", th);
        }
    }

    /* loaded from: classes.dex */
    public class b implements h<d.a.a.d> {
        public b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.a.h
        /* renamed from: a */
        public void onResult(d.a.a.d dVar) {
            LottieAnimationView.this.setComposition(dVar);
        }
    }

    /* loaded from: classes.dex */
    public class c implements h<Throwable> {
        public c() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.a.h
        /* renamed from: a */
        public void onResult(Throwable th) {
            if (LottieAnimationView.this.fallbackResource != 0) {
                LottieAnimationView lottieAnimationView = LottieAnimationView.this;
                lottieAnimationView.setImageResource(lottieAnimationView.fallbackResource);
            }
            (LottieAnimationView.this.failureListener == null ? LottieAnimationView.DEFAULT_FAILURE_LISTENER : LottieAnimationView.this.failureListener).onResult(th);
        }
    }

    /* loaded from: classes.dex */
    public class d implements Callable<l<d.a.a.d>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f1572e;

        public d(int i) {
            this.f1572e = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public l<d.a.a.d> call() throws Exception {
            return LottieAnimationView.this.cacheComposition ? d.a.a.e.o(LottieAnimationView.this.getContext(), this.f1572e) : d.a.a.e.p(LottieAnimationView.this.getContext(), this.f1572e, null);
        }
    }

    /* loaded from: classes.dex */
    public class e implements Callable<l<d.a.a.d>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f1574e;

        public e(String str) {
            this.f1574e = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public l<d.a.a.d> call() throws Exception {
            return LottieAnimationView.this.cacheComposition ? d.a.a.e.f(LottieAnimationView.this.getContext(), this.f1574e) : d.a.a.e.g(LottieAnimationView.this.getContext(), this.f1574e, null);
        }
    }

    /* loaded from: classes.dex */
    public class f extends d.a.a.y.c<T> {

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.a.y.e f1576c;

        public f(d.a.a.y.e eVar) {
            this.f1576c = eVar;
        }

        /* JADX WARN: Type inference failed for: r2v1, types: [T, java.lang.Object] */
        @Override // d.a.a.y.c
        public T a(d.a.a.y.b<T> bVar) {
            return this.f1576c.a(bVar);
        }
    }

    /* loaded from: classes.dex */
    public static /* synthetic */ class g {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f1578a;

        static {
            int[] iArr = new int[RenderMode.values().length];
            f1578a = iArr;
            try {
                iArr[RenderMode.HARDWARE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1578a[RenderMode.SOFTWARE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1578a[RenderMode.AUTOMATIC.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public LottieAnimationView(Context context) {
        super(context);
        this.loadedListener = new b();
        this.wrappedFailureListener = new c();
        this.fallbackResource = 0;
        this.lottieDrawable = new d.a.a.f();
        this.playAnimationWhenShown = false;
        this.wasAnimatingWhenNotShown = false;
        this.wasAnimatingWhenDetached = false;
        this.autoPlay = false;
        this.cacheComposition = true;
        this.renderMode = RenderMode.AUTOMATIC;
        this.lottieOnCompositionLoadedListeners = new HashSet();
        this.buildDrawingCacheDepth = 0;
        init(null, o.lottieAnimationViewStyle);
    }

    private void cancelLoaderTask() {
        m<d.a.a.d> mVar = this.compositionTask;
        if (mVar != null) {
            mVar.k(this.loadedListener);
            this.compositionTask.j(this.wrappedFailureListener);
        }
    }

    private void clearComposition() {
        this.composition = null;
        this.lottieDrawable.h();
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0044, code lost:
        if (r3 != false) goto L25;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void enableOrDisableHardwareLayer() {
        d.a.a.d dVar;
        int i;
        int i2 = g.f1578a[this.renderMode.ordinal()];
        int i3 = 2;
        if (i2 != 1) {
            if (i2 != 2 && i2 == 3) {
                d.a.a.d dVar2 = this.composition;
                boolean z = false;
                if ((dVar2 == null || !dVar2.p() || Build.VERSION.SDK_INT >= 28) && (((dVar = this.composition) == null || dVar.l() <= 4) && (i = Build.VERSION.SDK_INT) >= 21 && i != 24 && i != 25)) {
                    z = true;
                }
            }
            i3 = 1;
        }
        if (i3 != getLayerType()) {
            setLayerType(i3, null);
        }
    }

    private m<d.a.a.d> fromAssets(String str) {
        if (isInEditMode()) {
            return new m<>(new e(str), true);
        }
        return this.cacheComposition ? d.a.a.e.d(getContext(), str) : d.a.a.e.e(getContext(), str, null);
    }

    private m<d.a.a.d> fromRawRes(@RawRes int i) {
        if (isInEditMode()) {
            return new m<>(new d(i), true);
        }
        return this.cacheComposition ? d.a.a.e.m(getContext(), i) : d.a.a.e.n(getContext(), i, null);
    }

    private void init(@Nullable AttributeSet attributeSet, @AttrRes int i) {
        String string;
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, p.LottieAnimationView, i, 0);
        this.cacheComposition = obtainStyledAttributes.getBoolean(p.LottieAnimationView_lottie_cacheComposition, true);
        boolean hasValue = obtainStyledAttributes.hasValue(p.LottieAnimationView_lottie_rawRes);
        boolean hasValue2 = obtainStyledAttributes.hasValue(p.LottieAnimationView_lottie_fileName);
        boolean hasValue3 = obtainStyledAttributes.hasValue(p.LottieAnimationView_lottie_url);
        if (hasValue && hasValue2) {
            throw new IllegalArgumentException("lottie_rawRes and lottie_fileName cannot be used at the same time. Please use only one at once.");
        }
        if (hasValue) {
            int resourceId = obtainStyledAttributes.getResourceId(p.LottieAnimationView_lottie_rawRes, 0);
            if (resourceId != 0) {
                setAnimation(resourceId);
            }
        } else if (hasValue2) {
            String string2 = obtainStyledAttributes.getString(p.LottieAnimationView_lottie_fileName);
            if (string2 != null) {
                setAnimation(string2);
            }
        } else if (hasValue3 && (string = obtainStyledAttributes.getString(p.LottieAnimationView_lottie_url)) != null) {
            setAnimationFromUrl(string);
        }
        setFallbackResource(obtainStyledAttributes.getResourceId(p.LottieAnimationView_lottie_fallbackRes, 0));
        if (obtainStyledAttributes.getBoolean(p.LottieAnimationView_lottie_autoPlay, false)) {
            this.wasAnimatingWhenDetached = true;
            this.autoPlay = true;
        }
        if (obtainStyledAttributes.getBoolean(p.LottieAnimationView_lottie_loop, false)) {
            this.lottieDrawable.n0(-1);
        }
        if (obtainStyledAttributes.hasValue(p.LottieAnimationView_lottie_repeatMode)) {
            setRepeatMode(obtainStyledAttributes.getInt(p.LottieAnimationView_lottie_repeatMode, 1));
        }
        if (obtainStyledAttributes.hasValue(p.LottieAnimationView_lottie_repeatCount)) {
            setRepeatCount(obtainStyledAttributes.getInt(p.LottieAnimationView_lottie_repeatCount, -1));
        }
        if (obtainStyledAttributes.hasValue(p.LottieAnimationView_lottie_speed)) {
            setSpeed(obtainStyledAttributes.getFloat(p.LottieAnimationView_lottie_speed, 1.0f));
        }
        setImageAssetsFolder(obtainStyledAttributes.getString(p.LottieAnimationView_lottie_imageAssetsFolder));
        setProgress(obtainStyledAttributes.getFloat(p.LottieAnimationView_lottie_progress, 0.0f));
        enableMergePathsForKitKatAndAbove(obtainStyledAttributes.getBoolean(p.LottieAnimationView_lottie_enableMergePathsForKitKatAndAbove, false));
        if (obtainStyledAttributes.hasValue(p.LottieAnimationView_lottie_colorFilter)) {
            addValueCallback(new d.a.a.u.d("**"), (d.a.a.u.d) k.C, (d.a.a.y.c<d.a.a.u.d>) new d.a.a.y.c(new q(obtainStyledAttributes.getColor(p.LottieAnimationView_lottie_colorFilter, 0))));
        }
        if (obtainStyledAttributes.hasValue(p.LottieAnimationView_lottie_scale)) {
            this.lottieDrawable.q0(obtainStyledAttributes.getFloat(p.LottieAnimationView_lottie_scale, 1.0f));
        }
        if (obtainStyledAttributes.hasValue(p.LottieAnimationView_lottie_renderMode)) {
            int i2 = obtainStyledAttributes.getInt(p.LottieAnimationView_lottie_renderMode, RenderMode.AUTOMATIC.ordinal());
            if (i2 >= RenderMode.values().length) {
                i2 = RenderMode.AUTOMATIC.ordinal();
            }
            setRenderMode(RenderMode.values()[i2]);
        }
        if (getScaleType() != null) {
            this.lottieDrawable.r0(getScaleType());
        }
        obtainStyledAttributes.recycle();
        this.lottieDrawable.t0(Boolean.valueOf(d.a.a.x.h.f(getContext()) != 0.0f));
        enableOrDisableHardwareLayer();
        this.isInitialized = true;
    }

    private void setCompositionTask(m<d.a.a.d> mVar) {
        clearComposition();
        cancelLoaderTask();
        mVar.f(this.loadedListener);
        mVar.e(this.wrappedFailureListener);
        this.compositionTask = mVar;
    }

    public void addAnimatorListener(Animator.AnimatorListener animatorListener) {
        this.lottieDrawable.c(animatorListener);
    }

    public void addAnimatorUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.lottieDrawable.d(animatorUpdateListener);
    }

    public boolean addLottieOnCompositionLoadedListener(@NonNull j jVar) {
        d.a.a.d dVar = this.composition;
        if (dVar != null) {
            jVar.a(dVar);
        }
        return this.lottieOnCompositionLoadedListeners.add(jVar);
    }

    public <T> void addValueCallback(d.a.a.u.d dVar, T t, d.a.a.y.c<T> cVar) {
        this.lottieDrawable.e(dVar, t, cVar);
    }

    @Override // android.view.View
    public void buildDrawingCache(boolean z) {
        d.a.a.c.a("buildDrawingCache");
        this.buildDrawingCacheDepth++;
        super.buildDrawingCache(z);
        if (this.buildDrawingCacheDepth == 1 && getWidth() > 0 && getHeight() > 0 && getLayerType() == 1 && getDrawingCache(z) == null) {
            setRenderMode(RenderMode.HARDWARE);
        }
        this.buildDrawingCacheDepth--;
        d.a.a.c.b("buildDrawingCache");
    }

    @MainThread
    public void cancelAnimation() {
        this.wasAnimatingWhenDetached = false;
        this.wasAnimatingWhenNotShown = false;
        this.playAnimationWhenShown = false;
        this.lottieDrawable.g();
        enableOrDisableHardwareLayer();
    }

    public void disableExtraScaleModeInFitXY() {
        this.lottieDrawable.i();
    }

    public void enableMergePathsForKitKatAndAbove(boolean z) {
        this.lottieDrawable.m(z);
    }

    @Nullable
    public d.a.a.d getComposition() {
        return this.composition;
    }

    public long getDuration() {
        d.a.a.d dVar = this.composition;
        if (dVar != null) {
            return dVar.d();
        }
        return 0L;
    }

    public int getFrame() {
        return this.lottieDrawable.s();
    }

    @Nullable
    public String getImageAssetsFolder() {
        return this.lottieDrawable.v();
    }

    public float getMaxFrame() {
        return this.lottieDrawable.w();
    }

    public float getMinFrame() {
        return this.lottieDrawable.y();
    }

    @Nullable
    public n getPerformanceTracker() {
        return this.lottieDrawable.z();
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float getProgress() {
        return this.lottieDrawable.A();
    }

    public int getRepeatCount() {
        return this.lottieDrawable.B();
    }

    public int getRepeatMode() {
        return this.lottieDrawable.C();
    }

    public float getScale() {
        return this.lottieDrawable.D();
    }

    public float getSpeed() {
        return this.lottieDrawable.E();
    }

    public boolean hasMasks() {
        return this.lottieDrawable.H();
    }

    public boolean hasMatte() {
        return this.lottieDrawable.I();
    }

    @Override // android.widget.ImageView, android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(@NonNull Drawable drawable) {
        Drawable drawable2 = getDrawable();
        d.a.a.f fVar = this.lottieDrawable;
        if (drawable2 == fVar) {
            super.invalidateDrawable(fVar);
        } else {
            super.invalidateDrawable(drawable);
        }
    }

    public boolean isAnimating() {
        return this.lottieDrawable.J();
    }

    public boolean isMergePathsEnabledForKitKatAndAbove() {
        return this.lottieDrawable.L();
    }

    @Deprecated
    public void loop(boolean z) {
        this.lottieDrawable.n0(z ? -1 : 0);
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

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        String str = savedState.f1566e;
        this.animationName = str;
        if (!TextUtils.isEmpty(str)) {
            setAnimation(this.animationName);
        }
        int i = savedState.f1567f;
        this.animationResId = i;
        if (i != 0) {
            setAnimation(i);
        }
        setProgress(savedState.f1568g);
        if (savedState.f1569h) {
            playAnimation();
        }
        this.lottieDrawable.a0(savedState.i);
        setRepeatMode(savedState.j);
        setRepeatCount(savedState.k);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f1566e = this.animationName;
        savedState.f1567f = this.animationResId;
        savedState.f1568g = this.lottieDrawable.A();
        savedState.f1569h = this.lottieDrawable.J() || (!ViewCompat.isAttachedToWindow(this) && this.wasAnimatingWhenDetached);
        savedState.i = this.lottieDrawable.v();
        savedState.j = this.lottieDrawable.C();
        savedState.k = this.lottieDrawable.B();
        return savedState;
    }

    @Override // android.view.View
    public void onVisibilityChanged(@NonNull View view, int i) {
        if (this.isInitialized) {
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
    }

    @MainThread
    public void pauseAnimation() {
        this.autoPlay = false;
        this.wasAnimatingWhenDetached = false;
        this.wasAnimatingWhenNotShown = false;
        this.playAnimationWhenShown = false;
        this.lottieDrawable.M();
        enableOrDisableHardwareLayer();
    }

    @MainThread
    public void playAnimation() {
        if (isShown()) {
            this.lottieDrawable.N();
            enableOrDisableHardwareLayer();
            return;
        }
        this.playAnimationWhenShown = true;
    }

    public void removeAllAnimatorListeners() {
        this.lottieDrawable.O();
    }

    public void removeAllLottieOnCompositionLoadedListener() {
        this.lottieOnCompositionLoadedListeners.clear();
    }

    public void removeAllUpdateListeners() {
        this.lottieDrawable.P();
    }

    public void removeAnimatorListener(Animator.AnimatorListener animatorListener) {
        this.lottieDrawable.Q(animatorListener);
    }

    public boolean removeLottieOnCompositionLoadedListener(@NonNull j jVar) {
        return this.lottieOnCompositionLoadedListeners.remove(jVar);
    }

    public void removeUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.lottieDrawable.R(animatorUpdateListener);
    }

    public List<d.a.a.u.d> resolveKeyPath(d.a.a.u.d dVar) {
        return this.lottieDrawable.S(dVar);
    }

    @MainThread
    public void resumeAnimation() {
        if (isShown()) {
            this.lottieDrawable.T();
            enableOrDisableHardwareLayer();
            return;
        }
        this.playAnimationWhenShown = false;
        this.wasAnimatingWhenNotShown = true;
    }

    public void reverseAnimationSpeed() {
        this.lottieDrawable.U();
    }

    public void setAnimation(@RawRes int i) {
        this.animationResId = i;
        this.animationName = null;
        setCompositionTask(fromRawRes(i));
    }

    @Deprecated
    public void setAnimationFromJson(String str) {
        setAnimationFromJson(str, null);
    }

    public void setAnimationFromUrl(String str) {
        setCompositionTask(this.cacheComposition ? d.a.a.e.q(getContext(), str) : d.a.a.e.r(getContext(), str, null));
    }

    public void setApplyingOpacityToLayersEnabled(boolean z) {
        this.lottieDrawable.V(z);
    }

    public void setCacheComposition(boolean z) {
        this.cacheComposition = z;
    }

    public void setComposition(@NonNull d.a.a.d dVar) {
        if (d.a.a.c.f41504a) {
            String str = TAG;
            Log.v(str, "Set Composition \n" + dVar);
        }
        this.lottieDrawable.setCallback(this);
        this.composition = dVar;
        boolean W = this.lottieDrawable.W(dVar);
        enableOrDisableHardwareLayer();
        if (getDrawable() != this.lottieDrawable || W) {
            onVisibilityChanged(this, getVisibility());
            requestLayout();
            for (j jVar : this.lottieOnCompositionLoadedListeners) {
                jVar.a(dVar);
            }
        }
    }

    public void setFailureListener(@Nullable h<Throwable> hVar) {
        this.failureListener = hVar;
    }

    public void setFallbackResource(@DrawableRes int i) {
        this.fallbackResource = i;
    }

    public void setFontAssetDelegate(d.a.a.a aVar) {
        this.lottieDrawable.X(aVar);
    }

    public void setFrame(int i) {
        this.lottieDrawable.Y(i);
    }

    public void setImageAssetDelegate(d.a.a.b bVar) {
        this.lottieDrawable.Z(bVar);
    }

    public void setImageAssetsFolder(String str) {
        this.lottieDrawable.a0(str);
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
        this.lottieDrawable.b0(i);
    }

    public void setMaxProgress(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        this.lottieDrawable.d0(f2);
    }

    public void setMinAndMaxFrame(String str) {
        this.lottieDrawable.f0(str);
    }

    public void setMinAndMaxProgress(@FloatRange(from = 0.0d, to = 1.0d) float f2, @FloatRange(from = 0.0d, to = 1.0d) float f3) {
        this.lottieDrawable.h0(f2, f3);
    }

    public void setMinFrame(int i) {
        this.lottieDrawable.i0(i);
    }

    public void setMinProgress(float f2) {
        this.lottieDrawable.k0(f2);
    }

    public void setPerformanceTrackingEnabled(boolean z) {
        this.lottieDrawable.l0(z);
    }

    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        this.lottieDrawable.m0(f2);
    }

    public void setRenderMode(RenderMode renderMode) {
        this.renderMode = renderMode;
        enableOrDisableHardwareLayer();
    }

    public void setRepeatCount(int i) {
        this.lottieDrawable.n0(i);
    }

    public void setRepeatMode(int i) {
        this.lottieDrawable.o0(i);
    }

    public void setSafeMode(boolean z) {
        this.lottieDrawable.p0(z);
    }

    public void setScale(float f2) {
        this.lottieDrawable.q0(f2);
        if (getDrawable() == this.lottieDrawable) {
            setImageDrawable(null);
            setImageDrawable(this.lottieDrawable);
        }
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        super.setScaleType(scaleType);
        d.a.a.f fVar = this.lottieDrawable;
        if (fVar != null) {
            fVar.r0(scaleType);
        }
    }

    public void setSpeed(float f2) {
        this.lottieDrawable.s0(f2);
    }

    public void setTextDelegate(r rVar) {
        this.lottieDrawable.u0(rVar);
    }

    @Nullable
    public Bitmap updateBitmap(String str, @Nullable Bitmap bitmap) {
        return this.lottieDrawable.v0(str, bitmap);
    }

    public <T> void addValueCallback(d.a.a.u.d dVar, T t, d.a.a.y.e<T> eVar) {
        this.lottieDrawable.e(dVar, t, new f(eVar));
    }

    public void setAnimationFromJson(String str, @Nullable String str2) {
        setAnimation(new ByteArrayInputStream(str.getBytes()), str2);
    }

    public void setMaxFrame(String str) {
        this.lottieDrawable.c0(str);
    }

    public void setMinAndMaxFrame(String str, String str2, boolean z) {
        this.lottieDrawable.g0(str, str2, z);
    }

    public void setMinFrame(String str) {
        this.lottieDrawable.j0(str);
    }

    public void setMinAndMaxFrame(int i, int i2) {
        this.lottieDrawable.e0(i, i2);
    }

    public void setAnimation(String str) {
        this.animationName = str;
        this.animationResId = 0;
        setCompositionTask(fromAssets(str));
    }

    public void setAnimationFromUrl(String str, @Nullable String str2) {
        setCompositionTask(d.a.a.e.r(getContext(), str, str2));
    }

    public void setAnimation(InputStream inputStream, @Nullable String str) {
        setCompositionTask(d.a.a.e.h(inputStream, str));
    }

    public LottieAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.loadedListener = new b();
        this.wrappedFailureListener = new c();
        this.fallbackResource = 0;
        this.lottieDrawable = new d.a.a.f();
        this.playAnimationWhenShown = false;
        this.wasAnimatingWhenNotShown = false;
        this.wasAnimatingWhenDetached = false;
        this.autoPlay = false;
        this.cacheComposition = true;
        this.renderMode = RenderMode.AUTOMATIC;
        this.lottieOnCompositionLoadedListeners = new HashSet();
        this.buildDrawingCacheDepth = 0;
        init(attributeSet, o.lottieAnimationViewStyle);
    }

    public LottieAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.loadedListener = new b();
        this.wrappedFailureListener = new c();
        this.fallbackResource = 0;
        this.lottieDrawable = new d.a.a.f();
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
}
