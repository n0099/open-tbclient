package com.baidu.spswitch.emotion.view;

import android.content.Context;
import android.media.MediaMetadataRetriever;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.core.app.NotificationCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.devices.DeviceUtils;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.afx.AlphaVideo;
import com.baidu.searchbox.afx.callback.ErrorInfo;
import com.baidu.searchbox.afx.callback.OnVideoEndedListener;
import com.baidu.searchbox.afx.callback.OnVideoErrorListener;
import com.baidu.searchbox.afx.callback.OnVideoStartedListener;
import com.baidu.searchbox.afx.proxy.MediaPlayerProxy;
import com.baidu.spswitch.emotion.view.EmotionEffectView;
import com.baidu.spswitch.utils.EmotionEffectUtils;
import com.baidu.spswitch.utils.SPConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 +2\u00020\u0001:\u0002+,B+\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tB%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u0007¢\u0006\u0002\u0010\u000bJ\u0006\u0010\u001b\u001a\u00020\u001cJ\b\u0010\u001d\u001a\u00020\u001eH\u0014J\u0012\u0010\u001f\u001a\u00020\u001c2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J \u0010\"\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u001c2\b\u0010&\u001a\u0004\u0018\u00010'J\u0006\u0010(\u001a\u00020\u001eJ\u0010\u0010)\u001a\u00020\u001e2\u0006\u0010*\u001a\u00020$H\u0002R\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0014\u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0011\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/baidu/spswitch/emotion/view/EmotionEffectView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", NotificationCompat.WearableExtender.KEY_GRAVITY, "", "topMargin", "(Landroid/content/Context;Landroid/util/AttributeSet;Ljava/lang/Integer;I)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "alphaVideo", "Lcom/baidu/searchbox/afx/AlphaVideo;", "getAlphaVideo", "()Lcom/baidu/searchbox/afx/AlphaVideo;", "alphaVideo$delegate", "Lkotlin/Lazy;", "emotionHandler", "Landroid/os/Handler;", "retriever", "Landroid/media/MediaMetadataRetriever;", "getRetriever", "()Landroid/media/MediaMetadataRetriever;", "retriever$delegate", "viewRemoveRunnable", "Ljava/lang/Runnable;", "isPlaying", "", "onDetachedFromWindow", "", "onInterceptTouchEvent", Config.EVENT_PART, "Landroid/view/MotionEvent;", "playAfx", "sourcePath", "", "nightMode", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/baidu/spswitch/emotion/view/EmotionEffectView$OnEmotionEffectListener;", "releaseRetriever", "updateLayoutParams", "path", "Companion", "OnEmotionEffectListener", "lib_spswitch_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class EmotionEffectView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Companion Companion;
    public static final float defaultRadio = 2.4f;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<Integer, View> _$_findViewCache;
    public final Lazy alphaVideo$delegate;
    public final Handler emotionHandler;
    public final Lazy retriever$delegate;
    public Runnable viewRemoveRunnable;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&¨\u0006\u0007"}, d2 = {"Lcom/baidu/spswitch/emotion/view/EmotionEffectView$OnEmotionEffectListener;", "", "onEnd", "", "isErr", "", "onStart", "lib_spswitch_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public interface OnEmotionEffectListener {
        void onEnd(boolean z);

        void onStart();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1949732016, "Lcom/baidu/spswitch/emotion/view/EmotionEffectView;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1949732016, "Lcom/baidu/spswitch/emotion/view/EmotionEffectView;");
                return;
            }
        }
        Companion = new Companion(null);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public EmotionEffectView(Context context) {
        this(context, null, 0, 6, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue(), (DefaultConstructorMarker) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public EmotionEffectView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue(), (DefaultConstructorMarker) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void _$_clearFindViewByIdCache() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this._$_findViewCache.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            Map<Integer, View> map = this._$_findViewCache;
            View view2 = map.get(Integer.valueOf(i));
            if (view2 == null) {
                View findViewById = findViewById(i);
                if (findViewById != null) {
                    map.put(Integer.valueOf(i), findViewById);
                    return findViewById;
                }
                return null;
            }
            return view2;
        }
        return (View) invokeI.objValue;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, motionEvent)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/baidu/spswitch/emotion/view/EmotionEffectView$Companion;", "", "()V", "defaultRadio", "", "lib_spswitch_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public EmotionEffectView(final Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
        this._$_findViewCache = new LinkedHashMap();
        this.alphaVideo$delegate = LazyKt__LazyJVMKt.lazy(new Function0<AlphaVideo>(context) { // from class: com.baidu.spswitch.emotion.view.EmotionEffectView$alphaVideo$2
            public static /* synthetic */ Interceptable $ic;
            public final /* synthetic */ Context $context;
            public transient /* synthetic */ FieldHolder $fh;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {context};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.$context = context;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final AlphaVideo invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    return new AlphaVideo(this.$context);
                }
                return (AlphaVideo) invokeV.objValue;
            }
        });
        this.retriever$delegate = LazyKt__LazyJVMKt.lazy(EmotionEffectView$retriever$2.INSTANCE);
        this.emotionHandler = new Handler(Looper.getMainLooper());
        this.viewRemoveRunnable = new Runnable() { // from class: com.baidu.tieba.wo1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // java.lang.Runnable
            public final void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    EmotionEffectView.m118viewRemoveRunnable$lambda0(EmotionEffectView.this);
                }
            }
        };
        setFocusable(false);
        setClickable(false);
    }

    public /* synthetic */ EmotionEffectView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public EmotionEffectView(Context context, AttributeSet attributeSet, Integer num, int i) {
        this(context, null, 0);
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, num, Integer.valueOf(i)};
            interceptable.invokeUnInit(65541, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65541, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(DeviceUtils.ScreenInfo.getDisplayWidth(context), DeviceUtils.ScreenInfo.getDisplayHeight(context));
        if (num != null) {
            i2 = num.intValue();
        } else {
            i2 = 17;
        }
        layoutParams.gravity = i2;
        if (num != null && num.intValue() == 48) {
            layoutParams.topMargin = i;
        }
        AlphaVideo alphaVideo = getAlphaVideo();
        alphaVideo.setPlayer(new MediaPlayerProxy());
        alphaVideo.setLooping(false);
        alphaVideo.setClickable(false);
        alphaVideo.setFocusable(false);
        addView(getAlphaVideo(), layoutParams);
    }

    private final AlphaVideo getAlphaVideo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) {
            return (AlphaVideo) this.alphaVideo$delegate.getValue();
        }
        return (AlphaVideo) invokeV.objValue;
    }

    private final MediaMetadataRetriever getRetriever() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) {
            return (MediaMetadataRetriever) this.retriever$delegate.getValue();
        }
        return (MediaMetadataRetriever) invokeV.objValue;
    }

    public final boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return getAlphaVideo().isPlaying();
        }
        return invokeV.booleanValue;
    }

    public final void releaseRetriever() {
        MediaMetadataRetriever retriever;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (retriever = getRetriever()) != null) {
            retriever.release();
        }
    }

    /* renamed from: playAfx$lambda-6  reason: not valid java name */
    public static final void m114playAfx$lambda6(final EmotionEffectView this$0, String sourcePath, boolean z, final OnEmotionEffectListener onEmotionEffectListener) {
        float f;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{this$0, sourcePath, Boolean.valueOf(z), onEmotionEffectListener}) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(sourcePath, "$sourcePath");
            final AlphaVideo alphaVideo = this$0.getAlphaVideo();
            if (SPConfig.isDebug()) {
                Log.d(EmotionEffectUtils.TAG, "emotion effect view play: start - path: " + sourcePath);
            }
            alphaVideo.setSourcePath(sourcePath);
            if (z) {
                f = 0.5f;
            } else {
                f = 0.0f;
            }
            alphaVideo.setDarkFilter(f);
            alphaVideo.setOnVideoStartedListener(new OnVideoStartedListener() { // from class: com.baidu.tieba.uo1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.searchbox.afx.callback.OnVideoStartedListener
                public final void onVideoStarted() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        EmotionEffectView.m115playAfx$lambda6$lambda5$lambda2(EmotionEffectView.OnEmotionEffectListener.this);
                    }
                }
            });
            alphaVideo.setOnVideoEndedListener(new OnVideoEndedListener() { // from class: com.baidu.tieba.vo1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.searchbox.afx.callback.OnVideoEndedListener
                public final void onVideoEnded() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        EmotionEffectView.m116playAfx$lambda6$lambda5$lambda3(EmotionEffectView.this, alphaVideo, onEmotionEffectListener);
                    }
                }
            });
            alphaVideo.setOnVideoErrorListener(new OnVideoErrorListener() { // from class: com.baidu.tieba.xo1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.searchbox.afx.callback.OnVideoErrorListener
                public final boolean onError(ErrorInfo errorInfo) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, errorInfo)) == null) ? EmotionEffectView.m117playAfx$lambda6$lambda5$lambda4(EmotionEffectView.this, alphaVideo, onEmotionEffectListener, errorInfo) : invokeL.booleanValue;
                }
            });
            alphaVideo.play();
        }
    }

    /* renamed from: playAfx$lambda-6$lambda-5$lambda-2  reason: not valid java name */
    public static final void m115playAfx$lambda6$lambda5$lambda2(OnEmotionEffectListener onEmotionEffectListener) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65545, null, onEmotionEffectListener) == null) && onEmotionEffectListener != null) {
            onEmotionEffectListener.onStart();
        }
    }

    /* renamed from: playAfx$lambda-6$lambda-5$lambda-3  reason: not valid java name */
    public static final void m116playAfx$lambda6$lambda5$lambda3(EmotionEffectView this$0, AlphaVideo this_run, OnEmotionEffectListener onEmotionEffectListener) {
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65546, null, this$0, this_run, onEmotionEffectListener) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this_run, "$this_run");
            if (SPConfig.isDebug()) {
                Log.d(EmotionEffectUtils.TAG, "emotion effect view play: end");
            }
            this$0.setVisibility(8);
            Handler handler = this$0.emotionHandler;
            Runnable runnable = this$0.viewRemoveRunnable;
            if (this_run.getDuration() > 0) {
                j = this_run.getDuration() * 2;
            } else {
                j = 500;
            }
            handler.postDelayed(runnable, j);
            if (onEmotionEffectListener != null) {
                onEmotionEffectListener.onEnd(false);
            }
        }
    }

    /* renamed from: playAfx$lambda-6$lambda-5$lambda-4  reason: not valid java name */
    public static final boolean m117playAfx$lambda6$lambda5$lambda4(EmotionEffectView this$0, AlphaVideo this_run, OnEmotionEffectListener onEmotionEffectListener, ErrorInfo errorInfo) {
        InterceptResult invokeLLLL;
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65547, null, this$0, this_run, onEmotionEffectListener, errorInfo)) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this_run, "$this_run");
            if (SPConfig.isDebug()) {
                Log.d(EmotionEffectUtils.TAG, "emotion effect view play: error");
            }
            this$0.setVisibility(8);
            Handler handler = this$0.emotionHandler;
            Runnable runnable = this$0.viewRemoveRunnable;
            if (this_run.getDuration() > 0) {
                j = this_run.getDuration() * 2;
            } else {
                j = 500;
            }
            handler.postDelayed(runnable, j);
            if (onEmotionEffectListener != null) {
                onEmotionEffectListener.onEnd(true);
            }
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    private final void updateLayoutParams(String str) {
        float f;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, this, str) == null) {
            try {
                getRetriever().setDataSource(str);
                String extractMetadata = getRetriever().extractMetadata(18);
                Intrinsics.checkNotNull(extractMetadata);
                float parseFloat = Float.parseFloat(extractMetadata) / 2;
                String extractMetadata2 = getRetriever().extractMetadata(19);
                Intrinsics.checkNotNull(extractMetadata2);
                f = Float.parseFloat(extractMetadata2) / parseFloat;
            } catch (Exception unused) {
                f = 2.4f;
            }
            int displayWidth = DeviceUtils.ScreenInfo.getDisplayWidth(getContext());
            float f2 = displayWidth * f;
            if (SPConfig.isDebug()) {
                Log.d(EmotionEffectUtils.TAG, "emotion effect AlphaVideo: width-" + displayWidth + " height-" + f2);
            }
            ViewGroup.LayoutParams layoutParams = getAlphaVideo().getLayoutParams();
            layoutParams.width = displayWidth;
            layoutParams.height = (int) f2;
            getAlphaVideo().setLayoutParams(layoutParams);
        }
    }

    /* renamed from: viewRemoveRunnable$lambda-0  reason: not valid java name */
    public static final void m118viewRemoveRunnable$lambda0(EmotionEffectView this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (this$0.getParent() instanceof ViewGroup) {
                ViewParent parent = this$0.getParent();
                if (parent != null) {
                    ((ViewGroup) parent).removeView(this$0);
                    if (SPConfig.isDebug()) {
                        Log.d(EmotionEffectUtils.TAG, "emotion effect AlphaVideo: remove view");
                        return;
                    }
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onDetachedFromWindow();
            this.emotionHandler.removeCallbacks(this.viewRemoveRunnable);
            setVisibility(8);
            if (SPConfig.isDebug()) {
                Log.d(EmotionEffectUtils.TAG, "emotion effect view: onDetachedFromWindow");
            }
            getAlphaVideo().destroy();
        }
    }

    public final void playAfx(final String sourcePath, final boolean z, final OnEmotionEffectListener onEmotionEffectListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{sourcePath, Boolean.valueOf(z), onEmotionEffectListener}) == null) {
            Intrinsics.checkNotNullParameter(sourcePath, "sourcePath");
            updateLayoutParams(sourcePath);
            setVisibility(0);
            this.emotionHandler.removeCallbacks(this.viewRemoveRunnable);
            post(new Runnable() { // from class: com.baidu.tieba.yo1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        EmotionEffectView.m114playAfx$lambda6(EmotionEffectView.this, sourcePath, z, onEmotionEffectListener);
                    }
                }
            });
        }
    }
}
