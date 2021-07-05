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
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.utils.Logger;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.LottieFrameInfo;
import com.airbnb.lottie.value.LottieValueCallback;
import com.airbnb.lottie.value.SimpleLottieValueCallback;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
/* loaded from: classes.dex */
public class LottieAnimationView extends AppCompatImageView {
    public static /* synthetic */ Interceptable $ic;
    public static final LottieListener<Throwable> DEFAULT_FAILURE_LISTENER;
    public static final String TAG;
    public transient /* synthetic */ FieldHolder $fh;
    public String animationName;
    @RawRes
    public int animationResId;
    public boolean autoPlay;
    public int buildDrawingCacheDepth;
    public boolean cacheComposition;
    @Nullable
    public LottieComposition composition;
    @Nullable
    public LottieTask<LottieComposition> compositionTask;
    @Nullable
    public LottieListener<Throwable> failureListener;
    @DrawableRes
    public int fallbackResource;
    public boolean isInitialized;
    public final LottieListener<LottieComposition> loadedListener;
    public final LottieDrawable lottieDrawable;
    public Set<LottieOnCompositionLoadedListener> lottieOnCompositionLoadedListeners;
    public boolean playAnimationWhenShown;
    public RenderMode renderMode;
    public boolean wasAnimatingWhenDetached;
    public boolean wasAnimatingWhenNotShown;
    public final LottieListener<Throwable> wrappedFailureListener;

    /* renamed from: com.airbnb.lottie.LottieAnimationView$7  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass7 {
        public static final /* synthetic */ int[] $SwitchMap$com$airbnb$lottie$RenderMode;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-436029243, "Lcom/airbnb/lottie/LottieAnimationView$7;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-436029243, "Lcom/airbnb/lottie/LottieAnimationView$7;");
                    return;
                }
            }
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

    /* loaded from: classes.dex */
    public static class SavedState extends View.BaseSavedState {
        public static /* synthetic */ Interceptable $ic;
        public static final Parcelable.Creator<SavedState> CREATOR;
        public transient /* synthetic */ FieldHolder $fh;
        public String animationName;
        public int animationResId;
        public String imageAssetsFolder;
        public boolean isAnimating;
        public float progress;
        public int repeatCount;
        public int repeatMode;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1619105200, "Lcom/airbnb/lottie/LottieAnimationView$SavedState;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1619105200, "Lcom/airbnb/lottie/LottieAnimationView$SavedState;");
                    return;
                }
            }
            CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.airbnb.lottie.LottieAnimationView.SavedState.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public SavedState createFromParcel(Parcel parcel) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, parcel)) == null) ? new SavedState(parcel) : (SavedState) invokeL.objValue;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public SavedState[] newArray(int i2) {
                    InterceptResult invokeI;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeI = interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? new SavedState[i2] : (SavedState[]) invokeI.objValue;
                }
            };
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, parcel, i2) == null) {
                super.writeToParcel(parcel, i2);
                parcel.writeString(this.animationName);
                parcel.writeFloat(this.progress);
                parcel.writeInt(this.isAnimating ? 1 : 0);
                parcel.writeString(this.imageAssetsFolder);
                parcel.writeInt(this.repeatMode);
                parcel.writeInt(this.repeatCount);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SavedState(Parcelable parcelable) {
            super(parcelable);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {parcelable};
                interceptable.invokeUnInit(65539, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Parcelable) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65539, newInitContext);
                    return;
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SavedState(Parcel parcel) {
            super(parcel);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {parcel};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Parcel) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.animationName = parcel.readString();
            this.progress = parcel.readFloat();
            this.isAnimating = parcel.readInt() == 1;
            this.imageAssetsFolder = parcel.readString();
            this.repeatMode = parcel.readInt();
            this.repeatCount = parcel.readInt();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-854084040, "Lcom/airbnb/lottie/LottieAnimationView;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-854084040, "Lcom/airbnb/lottie/LottieAnimationView;");
                return;
            }
        }
        TAG = LottieAnimationView.class.getSimpleName();
        DEFAULT_FAILURE_LISTENER = new LottieListener<Throwable>() { // from class: com.airbnb.lottie.LottieAnimationView.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.airbnb.lottie.LottieListener
            public void onResult(Throwable th) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                    if (Utils.isNetworkException(th)) {
                        Logger.warning("Unable to load composition.", th);
                        return;
                    }
                    throw new IllegalStateException("Unable to parse composition", th);
                }
            }
        };
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LottieAnimationView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.loadedListener = new LottieListener<LottieComposition>(this) { // from class: com.airbnb.lottie.LottieAnimationView.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ LottieAnimationView this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.airbnb.lottie.LottieListener
            public void onResult(LottieComposition lottieComposition) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, lottieComposition) == null) {
                    this.this$0.setComposition(lottieComposition);
                }
            }
        };
        this.wrappedFailureListener = new LottieListener<Throwable>(this) { // from class: com.airbnb.lottie.LottieAnimationView.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ LottieAnimationView this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.airbnb.lottie.LottieListener
            public void onResult(Throwable th) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                    if (this.this$0.fallbackResource != 0) {
                        LottieAnimationView lottieAnimationView = this.this$0;
                        lottieAnimationView.setImageResource(lottieAnimationView.fallbackResource);
                    }
                    (this.this$0.failureListener == null ? LottieAnimationView.DEFAULT_FAILURE_LISTENER : this.this$0.failureListener).onResult(th);
                }
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
        init(null, R.attr.lottieAnimationViewStyle);
    }

    private void cancelLoaderTask() {
        LottieTask<LottieComposition> lottieTask;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65544, this) == null) || (lottieTask = this.compositionTask) == null) {
            return;
        }
        lottieTask.removeListener(this.loadedListener);
        this.compositionTask.removeFailureListener(this.wrappedFailureListener);
    }

    private void clearComposition() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            this.composition = null;
            this.lottieDrawable.clearComposition();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0048, code lost:
        if (r3 != false) goto L27;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void enableOrDisableHardwareLayer() {
        LottieComposition lottieComposition;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            int i3 = AnonymousClass7.$SwitchMap$com$airbnb$lottie$RenderMode[this.renderMode.ordinal()];
            int i4 = 2;
            if (i3 != 1) {
                if (i3 != 2 && i3 == 3) {
                    LottieComposition lottieComposition2 = this.composition;
                    boolean z = false;
                    if ((lottieComposition2 == null || !lottieComposition2.hasDashPattern() || Build.VERSION.SDK_INT >= 28) && (((lottieComposition = this.composition) == null || lottieComposition.getMaskAndMatteCount() <= 4) && (i2 = Build.VERSION.SDK_INT) >= 21 && i2 != 24 && i2 != 25)) {
                        z = true;
                    }
                }
                i4 = 1;
            }
            if (i4 != getLayerType()) {
                setLayerType(i4, null);
            }
        }
    }

    private LottieTask<LottieComposition> fromAssets(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, this, str)) == null) {
            if (isInEditMode()) {
                return new LottieTask<>(new Callable<LottieResult<LottieComposition>>(this, str) { // from class: com.airbnb.lottie.LottieAnimationView.5
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ LottieAnimationView this$0;
                    public final /* synthetic */ String val$assetName;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, str};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$assetName = str;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // java.util.concurrent.Callable
                    public LottieResult<LottieComposition> call() throws Exception {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? this.this$0.cacheComposition ? LottieCompositionFactory.fromAssetSync(this.this$0.getContext(), this.val$assetName) : LottieCompositionFactory.fromAssetSync(this.this$0.getContext(), this.val$assetName, null) : (LottieResult) invokeV.objValue;
                    }
                }, true);
            }
            return this.cacheComposition ? LottieCompositionFactory.fromAsset(getContext(), str) : LottieCompositionFactory.fromAsset(getContext(), str, null);
        }
        return (LottieTask) invokeL.objValue;
    }

    private LottieTask<LottieComposition> fromRawRes(@RawRes int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65548, this, i2)) == null) {
            if (isInEditMode()) {
                return new LottieTask<>(new Callable<LottieResult<LottieComposition>>(this, i2) { // from class: com.airbnb.lottie.LottieAnimationView.4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ LottieAnimationView this$0;
                    public final /* synthetic */ int val$rawRes;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, Integer.valueOf(i2)};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$rawRes = i2;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // java.util.concurrent.Callable
                    public LottieResult<LottieComposition> call() throws Exception {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? this.this$0.cacheComposition ? LottieCompositionFactory.fromRawResSync(this.this$0.getContext(), this.val$rawRes) : LottieCompositionFactory.fromRawResSync(this.this$0.getContext(), this.val$rawRes, null) : (LottieResult) invokeV.objValue;
                    }
                }, true);
            }
            return this.cacheComposition ? LottieCompositionFactory.fromRawRes(getContext(), i2) : LottieCompositionFactory.fromRawRes(getContext(), i2, null);
        }
        return (LottieTask) invokeI.objValue;
    }

    private void init(@Nullable AttributeSet attributeSet, @AttrRes int i2) {
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65549, this, attributeSet, i2) == null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.LottieAnimationView, i2, 0);
            this.cacheComposition = obtainStyledAttributes.getBoolean(R.styleable.LottieAnimationView_lottie_cacheComposition, true);
            boolean hasValue = obtainStyledAttributes.hasValue(R.styleable.LottieAnimationView_lottie_rawRes);
            boolean hasValue2 = obtainStyledAttributes.hasValue(R.styleable.LottieAnimationView_lottie_fileName);
            boolean hasValue3 = obtainStyledAttributes.hasValue(R.styleable.LottieAnimationView_lottie_url);
            if (hasValue && hasValue2) {
                throw new IllegalArgumentException("lottie_rawRes and lottie_fileName cannot be used at the same time. Please use only one at once.");
            }
            if (hasValue) {
                int resourceId = obtainStyledAttributes.getResourceId(R.styleable.LottieAnimationView_lottie_rawRes, 0);
                if (resourceId != 0) {
                    setAnimation(resourceId);
                }
            } else if (hasValue2) {
                String string2 = obtainStyledAttributes.getString(R.styleable.LottieAnimationView_lottie_fileName);
                if (string2 != null) {
                    setAnimation(string2);
                }
            } else if (hasValue3 && (string = obtainStyledAttributes.getString(R.styleable.LottieAnimationView_lottie_url)) != null) {
                setAnimationFromUrl(string);
            }
            setFallbackResource(obtainStyledAttributes.getResourceId(R.styleable.LottieAnimationView_lottie_fallbackRes, 0));
            if (obtainStyledAttributes.getBoolean(R.styleable.LottieAnimationView_lottie_autoPlay, false)) {
                this.wasAnimatingWhenDetached = true;
                this.autoPlay = true;
            }
            if (obtainStyledAttributes.getBoolean(R.styleable.LottieAnimationView_lottie_loop, false)) {
                this.lottieDrawable.setRepeatCount(-1);
            }
            if (obtainStyledAttributes.hasValue(R.styleable.LottieAnimationView_lottie_repeatMode)) {
                setRepeatMode(obtainStyledAttributes.getInt(R.styleable.LottieAnimationView_lottie_repeatMode, 1));
            }
            if (obtainStyledAttributes.hasValue(R.styleable.LottieAnimationView_lottie_repeatCount)) {
                setRepeatCount(obtainStyledAttributes.getInt(R.styleable.LottieAnimationView_lottie_repeatCount, -1));
            }
            if (obtainStyledAttributes.hasValue(R.styleable.LottieAnimationView_lottie_speed)) {
                setSpeed(obtainStyledAttributes.getFloat(R.styleable.LottieAnimationView_lottie_speed, 1.0f));
            }
            setImageAssetsFolder(obtainStyledAttributes.getString(R.styleable.LottieAnimationView_lottie_imageAssetsFolder));
            setProgress(obtainStyledAttributes.getFloat(R.styleable.LottieAnimationView_lottie_progress, 0.0f));
            enableMergePathsForKitKatAndAbove(obtainStyledAttributes.getBoolean(R.styleable.LottieAnimationView_lottie_enableMergePathsForKitKatAndAbove, false));
            if (obtainStyledAttributes.hasValue(R.styleable.LottieAnimationView_lottie_colorFilter)) {
                addValueCallback(new KeyPath("**"), (KeyPath) LottieProperty.COLOR_FILTER, (LottieValueCallback<KeyPath>) new LottieValueCallback(new SimpleColorFilter(obtainStyledAttributes.getColor(R.styleable.LottieAnimationView_lottie_colorFilter, 0))));
            }
            if (obtainStyledAttributes.hasValue(R.styleable.LottieAnimationView_lottie_scale)) {
                this.lottieDrawable.setScale(obtainStyledAttributes.getFloat(R.styleable.LottieAnimationView_lottie_scale, 1.0f));
            }
            if (obtainStyledAttributes.hasValue(R.styleable.LottieAnimationView_lottie_renderMode)) {
                int i3 = obtainStyledAttributes.getInt(R.styleable.LottieAnimationView_lottie_renderMode, RenderMode.AUTOMATIC.ordinal());
                if (i3 >= RenderMode.values().length) {
                    i3 = RenderMode.AUTOMATIC.ordinal();
                }
                setRenderMode(RenderMode.values()[i3]);
            }
            if (getScaleType() != null) {
                this.lottieDrawable.setScaleType(getScaleType());
            }
            obtainStyledAttributes.recycle();
            this.lottieDrawable.setSystemAnimationsAreEnabled(Boolean.valueOf(Utils.getAnimationScale(getContext()) != 0.0f));
            enableOrDisableHardwareLayer();
            this.isInitialized = true;
        }
    }

    private void setCompositionTask(LottieTask<LottieComposition> lottieTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, this, lottieTask) == null) {
            clearComposition();
            cancelLoaderTask();
            this.compositionTask = lottieTask.addListener(this.loadedListener).addFailureListener(this.wrappedFailureListener);
        }
    }

    public void addAnimatorListener(Animator.AnimatorListener animatorListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, animatorListener) == null) {
            this.lottieDrawable.addAnimatorListener(animatorListener);
        }
    }

    public void addAnimatorUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animatorUpdateListener) == null) {
            this.lottieDrawable.addAnimatorUpdateListener(animatorUpdateListener);
        }
    }

    public boolean addLottieOnCompositionLoadedListener(@NonNull LottieOnCompositionLoadedListener lottieOnCompositionLoadedListener) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, lottieOnCompositionLoadedListener)) == null) {
            LottieComposition lottieComposition = this.composition;
            if (lottieComposition != null) {
                lottieOnCompositionLoadedListener.onCompositionLoaded(lottieComposition);
            }
            return this.lottieOnCompositionLoadedListeners.add(lottieOnCompositionLoadedListener);
        }
        return invokeL.booleanValue;
    }

    public <T> void addValueCallback(KeyPath keyPath, T t, LottieValueCallback<T> lottieValueCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, keyPath, t, lottieValueCallback) == null) {
            this.lottieDrawable.addValueCallback(keyPath, (KeyPath) t, (LottieValueCallback<KeyPath>) lottieValueCallback);
        }
    }

    @Override // android.view.View
    public void buildDrawingCache(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            L.beginSection("buildDrawingCache");
            this.buildDrawingCacheDepth++;
            super.buildDrawingCache(z);
            if (this.buildDrawingCacheDepth == 1 && getWidth() > 0 && getHeight() > 0 && getLayerType() == 1 && getDrawingCache(z) == null) {
                setRenderMode(RenderMode.HARDWARE);
            }
            this.buildDrawingCacheDepth--;
            L.endSection("buildDrawingCache");
        }
    }

    @MainThread
    public void cancelAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.wasAnimatingWhenDetached = false;
            this.wasAnimatingWhenNotShown = false;
            this.playAnimationWhenShown = false;
            this.lottieDrawable.cancelAnimation();
            enableOrDisableHardwareLayer();
        }
    }

    public void disableExtraScaleModeInFitXY() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.lottieDrawable.disableExtraScaleModeInFitXY();
        }
    }

    public void enableMergePathsForKitKatAndAbove(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.lottieDrawable.enableMergePathsForKitKatAndAbove(z);
        }
    }

    @Nullable
    public LottieComposition getComposition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.composition : (LottieComposition) invokeV.objValue;
    }

    public long getDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            LottieComposition lottieComposition = this.composition;
            if (lottieComposition != null) {
                return lottieComposition.getDuration();
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    public int getFrame() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.lottieDrawable.getFrame() : invokeV.intValue;
    }

    @Nullable
    public String getImageAssetsFolder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.lottieDrawable.getImageAssetsFolder() : (String) invokeV.objValue;
    }

    public float getMaxFrame() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.lottieDrawable.getMaxFrame() : invokeV.floatValue;
    }

    public float getMinFrame() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.lottieDrawable.getMinFrame() : invokeV.floatValue;
    }

    @Nullable
    public PerformanceTracker getPerformanceTracker() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.lottieDrawable.getPerformanceTracker() : (PerformanceTracker) invokeV.objValue;
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float getProgress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.lottieDrawable.getProgress() : invokeV.floatValue;
    }

    public int getRepeatCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.lottieDrawable.getRepeatCount() : invokeV.intValue;
    }

    public int getRepeatMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.lottieDrawable.getRepeatMode() : invokeV.intValue;
    }

    public float getScale() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.lottieDrawable.getScale() : invokeV.floatValue;
    }

    public float getSpeed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.lottieDrawable.getSpeed() : invokeV.floatValue;
    }

    public boolean hasMasks() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.lottieDrawable.hasMasks() : invokeV.booleanValue;
    }

    public boolean hasMatte() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.lottieDrawable.hasMatte() : invokeV.booleanValue;
    }

    @Override // android.widget.ImageView, android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(@NonNull Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, drawable) == null) {
            Drawable drawable2 = getDrawable();
            LottieDrawable lottieDrawable = this.lottieDrawable;
            if (drawable2 == lottieDrawable) {
                super.invalidateDrawable(lottieDrawable);
            } else {
                super.invalidateDrawable(drawable);
            }
        }
    }

    public boolean isAnimating() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.lottieDrawable.isAnimating() : invokeV.booleanValue;
    }

    public boolean isMergePathsEnabledForKitKatAndAbove() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.lottieDrawable.isMergePathsEnabledForKitKatAndAbove() : invokeV.booleanValue;
    }

    @Deprecated
    public void loop(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048602, this, z) == null) {
            this.lottieDrawable.setRepeatCount(z ? -1 : 0);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
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
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            if (isAnimating()) {
                cancelAnimation();
                this.wasAnimatingWhenDetached = true;
            }
            super.onDetachedFromWindow();
        }
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, parcelable) == null) {
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
            int i2 = savedState.animationResId;
            this.animationResId = i2;
            if (i2 != 0) {
                setAnimation(i2);
            }
            setProgress(savedState.progress);
            if (savedState.isAnimating) {
                playAnimation();
            }
            this.lottieDrawable.setImagesAssetsFolder(savedState.imageAssetsFolder);
            setRepeatMode(savedState.repeatMode);
            setRepeatCount(savedState.repeatCount);
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            SavedState savedState = new SavedState(super.onSaveInstanceState());
            savedState.animationName = this.animationName;
            savedState.animationResId = this.animationResId;
            savedState.progress = this.lottieDrawable.getProgress();
            savedState.isAnimating = this.lottieDrawable.isAnimating() || (!ViewCompat.isAttachedToWindow(this) && this.wasAnimatingWhenDetached);
            savedState.imageAssetsFolder = this.lottieDrawable.getImageAssetsFolder();
            savedState.repeatMode = this.lottieDrawable.getRepeatMode();
            savedState.repeatCount = this.lottieDrawable.getRepeatCount();
            return savedState;
        }
        return (Parcelable) invokeV.objValue;
    }

    @Override // android.view.View
    public void onVisibilityChanged(@NonNull View view, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048607, this, view, i2) == null) && this.isInitialized) {
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            this.autoPlay = false;
            this.wasAnimatingWhenDetached = false;
            this.wasAnimatingWhenNotShown = false;
            this.playAnimationWhenShown = false;
            this.lottieDrawable.pauseAnimation();
            enableOrDisableHardwareLayer();
        }
    }

    @MainThread
    public void playAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            if (isShown()) {
                this.lottieDrawable.playAnimation();
                enableOrDisableHardwareLayer();
                return;
            }
            this.playAnimationWhenShown = true;
        }
    }

    public void removeAllAnimatorListeners() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            this.lottieDrawable.removeAllAnimatorListeners();
        }
    }

    public void removeAllLottieOnCompositionLoadedListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            this.lottieOnCompositionLoadedListeners.clear();
        }
    }

    public void removeAllUpdateListeners() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            this.lottieDrawable.removeAllUpdateListeners();
        }
    }

    public void removeAnimatorListener(Animator.AnimatorListener animatorListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, animatorListener) == null) {
            this.lottieDrawable.removeAnimatorListener(animatorListener);
        }
    }

    public boolean removeLottieOnCompositionLoadedListener(@NonNull LottieOnCompositionLoadedListener lottieOnCompositionLoadedListener) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048614, this, lottieOnCompositionLoadedListener)) == null) ? this.lottieOnCompositionLoadedListeners.remove(lottieOnCompositionLoadedListener) : invokeL.booleanValue;
    }

    public void removeUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, animatorUpdateListener) == null) {
            this.lottieDrawable.removeAnimatorUpdateListener(animatorUpdateListener);
        }
    }

    public List<KeyPath> resolveKeyPath(KeyPath keyPath) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048616, this, keyPath)) == null) ? this.lottieDrawable.resolveKeyPath(keyPath) : (List) invokeL.objValue;
    }

    @MainThread
    public void resumeAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            if (isShown()) {
                this.lottieDrawable.resumeAnimation();
                enableOrDisableHardwareLayer();
                return;
            }
            this.playAnimationWhenShown = false;
            this.wasAnimatingWhenNotShown = true;
        }
    }

    public void reverseAnimationSpeed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            this.lottieDrawable.reverseAnimationSpeed();
        }
    }

    public void setAnimation(@RawRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048619, this, i2) == null) {
            this.animationResId = i2;
            this.animationName = null;
            setCompositionTask(fromRawRes(i2));
        }
    }

    @Deprecated
    public void setAnimationFromJson(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, str) == null) {
            setAnimationFromJson(str, null);
        }
    }

    public void setAnimationFromUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, str) == null) {
            setCompositionTask(this.cacheComposition ? LottieCompositionFactory.fromUrl(getContext(), str) : LottieCompositionFactory.fromUrl(getContext(), str, null));
        }
    }

    public void setApplyingOpacityToLayersEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048626, this, z) == null) {
            this.lottieDrawable.setApplyingOpacityToLayersEnabled(z);
        }
    }

    public void setCacheComposition(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048627, this, z) == null) {
            this.cacheComposition = z;
        }
    }

    public void setComposition(@NonNull LottieComposition lottieComposition) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048628, this, lottieComposition) == null) {
            if (L.DBG) {
                String str = TAG;
                Log.v(str, "Set Composition \n" + lottieComposition);
            }
            this.lottieDrawable.setCallback(this);
            this.composition = lottieComposition;
            boolean composition = this.lottieDrawable.setComposition(lottieComposition);
            enableOrDisableHardwareLayer();
            if (getDrawable() != this.lottieDrawable || composition) {
                onVisibilityChanged(this, getVisibility());
                requestLayout();
                for (LottieOnCompositionLoadedListener lottieOnCompositionLoadedListener : this.lottieOnCompositionLoadedListeners) {
                    lottieOnCompositionLoadedListener.onCompositionLoaded(lottieComposition);
                }
            }
        }
    }

    public void setFailureListener(@Nullable LottieListener<Throwable> lottieListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, lottieListener) == null) {
            this.failureListener = lottieListener;
        }
    }

    public void setFallbackResource(@DrawableRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048630, this, i2) == null) {
            this.fallbackResource = i2;
        }
    }

    public void setFontAssetDelegate(FontAssetDelegate fontAssetDelegate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048631, this, fontAssetDelegate) == null) {
            this.lottieDrawable.setFontAssetDelegate(fontAssetDelegate);
        }
    }

    public void setFrame(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048632, this, i2) == null) {
            this.lottieDrawable.setFrame(i2);
        }
    }

    public void setImageAssetDelegate(ImageAssetDelegate imageAssetDelegate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048633, this, imageAssetDelegate) == null) {
            this.lottieDrawable.setImageAssetDelegate(imageAssetDelegate);
        }
    }

    public void setImageAssetsFolder(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048634, this, str) == null) {
            this.lottieDrawable.setImagesAssetsFolder(str);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048635, this, bitmap) == null) {
            cancelLoaderTask();
            super.setImageBitmap(bitmap);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048636, this, drawable) == null) {
            cancelLoaderTask();
            super.setImageDrawable(drawable);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048637, this, i2) == null) {
            cancelLoaderTask();
            super.setImageResource(i2);
        }
    }

    public void setMaxFrame(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048638, this, i2) == null) {
            this.lottieDrawable.setMaxFrame(i2);
        }
    }

    public void setMaxProgress(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048640, this, f2) == null) {
            this.lottieDrawable.setMaxProgress(f2);
        }
    }

    public void setMinAndMaxFrame(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048642, this, str) == null) {
            this.lottieDrawable.setMinAndMaxFrame(str);
        }
    }

    public void setMinAndMaxProgress(@FloatRange(from = 0.0d, to = 1.0d) float f2, @FloatRange(from = 0.0d, to = 1.0d) float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048644, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            this.lottieDrawable.setMinAndMaxProgress(f2, f3);
        }
    }

    public void setMinFrame(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048645, this, i2) == null) {
            this.lottieDrawable.setMinFrame(i2);
        }
    }

    public void setMinProgress(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048647, this, f2) == null) {
            this.lottieDrawable.setMinProgress(f2);
        }
    }

    public void setPerformanceTrackingEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048648, this, z) == null) {
            this.lottieDrawable.setPerformanceTrackingEnabled(z);
        }
    }

    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048649, this, f2) == null) {
            this.lottieDrawable.setProgress(f2);
        }
    }

    public void setRenderMode(RenderMode renderMode) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048650, this, renderMode) == null) {
            this.renderMode = renderMode;
            enableOrDisableHardwareLayer();
        }
    }

    public void setRepeatCount(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048651, this, i2) == null) {
            this.lottieDrawable.setRepeatCount(i2);
        }
    }

    public void setRepeatMode(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048652, this, i2) == null) {
            this.lottieDrawable.setRepeatMode(i2);
        }
    }

    public void setSafeMode(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048653, this, z) == null) {
            this.lottieDrawable.setSafeMode(z);
        }
    }

    public void setScale(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048654, this, f2) == null) {
            this.lottieDrawable.setScale(f2);
            if (getDrawable() == this.lottieDrawable) {
                setImageDrawable(null);
                setImageDrawable(this.lottieDrawable);
            }
        }
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048655, this, scaleType) == null) {
            super.setScaleType(scaleType);
            LottieDrawable lottieDrawable = this.lottieDrawable;
            if (lottieDrawable != null) {
                lottieDrawable.setScaleType(scaleType);
            }
        }
    }

    public void setSpeed(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048656, this, f2) == null) {
            this.lottieDrawable.setSpeed(f2);
        }
    }

    public void setTextDelegate(TextDelegate textDelegate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048657, this, textDelegate) == null) {
            this.lottieDrawable.setTextDelegate(textDelegate);
        }
    }

    @Nullable
    public Bitmap updateBitmap(String str, @Nullable Bitmap bitmap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048658, this, str, bitmap)) == null) ? this.lottieDrawable.updateBitmap(str, bitmap) : (Bitmap) invokeLL.objValue;
    }

    public <T> void addValueCallback(KeyPath keyPath, T t, SimpleLottieValueCallback<T> simpleLottieValueCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, keyPath, t, simpleLottieValueCallback) == null) {
            this.lottieDrawable.addValueCallback(keyPath, (KeyPath) t, (LottieValueCallback<KeyPath>) new LottieValueCallback<T>(this, simpleLottieValueCallback) { // from class: com.airbnb.lottie.LottieAnimationView.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ LottieAnimationView this$0;
                public final /* synthetic */ SimpleLottieValueCallback val$callback;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, simpleLottieValueCallback};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$callback = simpleLottieValueCallback;
                }

                /* JADX WARN: Type inference failed for: r1v0, types: [T, java.lang.Object] */
                /* JADX WARN: Type inference failed for: r5v1, types: [T, java.lang.Object] */
                @Override // com.airbnb.lottie.value.LottieValueCallback
                public T getValue(LottieFrameInfo<T> lottieFrameInfo) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, lottieFrameInfo)) == null) ? this.val$callback.getValue(lottieFrameInfo) : invokeL.objValue;
                }
            });
        }
    }

    public void setAnimationFromJson(String str, @Nullable String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048623, this, str, str2) == null) {
            setAnimation(new ByteArrayInputStream(str.getBytes()), str2);
        }
    }

    public void setMaxFrame(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048639, this, str) == null) {
            this.lottieDrawable.setMaxFrame(str);
        }
    }

    public void setMinAndMaxFrame(String str, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048643, this, str, str2, z) == null) {
            this.lottieDrawable.setMinAndMaxFrame(str, str2, z);
        }
    }

    public void setMinFrame(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048646, this, str) == null) {
            this.lottieDrawable.setMinFrame(str);
        }
    }

    public void setMinAndMaxFrame(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048641, this, i2, i3) == null) {
            this.lottieDrawable.setMinAndMaxFrame(i2, i3);
        }
    }

    public void setAnimation(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, str) == null) {
            this.animationName = str;
            this.animationResId = 0;
            setCompositionTask(fromAssets(str));
        }
    }

    public void setAnimationFromUrl(String str, @Nullable String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048625, this, str, str2) == null) {
            setCompositionTask(LottieCompositionFactory.fromUrl(getContext(), str, str2));
        }
    }

    public void setAnimation(InputStream inputStream, @Nullable String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048620, this, inputStream, str) == null) {
            setCompositionTask(LottieCompositionFactory.fromJsonInputStream(inputStream, str));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LottieAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.loadedListener = new LottieListener<LottieComposition>(this) { // from class: com.airbnb.lottie.LottieAnimationView.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ LottieAnimationView this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr2;
                    Object[] objArr22 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.airbnb.lottie.LottieListener
            public void onResult(LottieComposition lottieComposition) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, lottieComposition) == null) {
                    this.this$0.setComposition(lottieComposition);
                }
            }
        };
        this.wrappedFailureListener = new LottieListener<Throwable>(this) { // from class: com.airbnb.lottie.LottieAnimationView.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ LottieAnimationView this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr2;
                    Object[] objArr22 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.airbnb.lottie.LottieListener
            public void onResult(Throwable th) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                    if (this.this$0.fallbackResource != 0) {
                        LottieAnimationView lottieAnimationView = this.this$0;
                        lottieAnimationView.setImageResource(lottieAnimationView.fallbackResource);
                    }
                    (this.this$0.failureListener == null ? LottieAnimationView.DEFAULT_FAILURE_LISTENER : this.this$0.failureListener).onResult(th);
                }
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
        init(attributeSet, R.attr.lottieAnimationViewStyle);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LottieAnimationView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.loadedListener = new LottieListener<LottieComposition>(this) { // from class: com.airbnb.lottie.LottieAnimationView.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ LottieAnimationView this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr22;
                    Object[] objArr22 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i42 = newInitContext2.flag;
                    if ((i42 & 1) != 0) {
                        int i5 = i42 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.airbnb.lottie.LottieListener
            public void onResult(LottieComposition lottieComposition) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, lottieComposition) == null) {
                    this.this$0.setComposition(lottieComposition);
                }
            }
        };
        this.wrappedFailureListener = new LottieListener<Throwable>(this) { // from class: com.airbnb.lottie.LottieAnimationView.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ LottieAnimationView this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr22;
                    Object[] objArr22 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i42 = newInitContext2.flag;
                    if ((i42 & 1) != 0) {
                        int i5 = i42 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.airbnb.lottie.LottieListener
            public void onResult(Throwable th) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                    if (this.this$0.fallbackResource != 0) {
                        LottieAnimationView lottieAnimationView = this.this$0;
                        lottieAnimationView.setImageResource(lottieAnimationView.fallbackResource);
                    }
                    (this.this$0.failureListener == null ? LottieAnimationView.DEFAULT_FAILURE_LISTENER : this.this$0.failureListener).onResult(th);
                }
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
        init(attributeSet, i2);
    }
}
