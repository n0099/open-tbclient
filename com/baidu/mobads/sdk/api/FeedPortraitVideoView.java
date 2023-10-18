package com.baidu.mobads.sdk.api;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.sdk.internal.ar;
import com.baidu.mobads.sdk.internal.bq;
import com.baidu.mobads.sdk.internal.w;
import com.baidu.searchbox.download.constants.DownloadStatisticConstants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
/* loaded from: classes3.dex */
public class FeedPortraitVideoView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String FEED_CLICK = "pauseBtnClick";
    public static final String PLAY_END = "playCompletion";
    public static final String PLAY_ERROR = "playError";
    public static final String PLAY_PAUSE = "playPause";
    public static final String PLAY_RESUME = "playResume";
    public static final String PLAY_START = "playRenderingStart";
    public static final String TAG = "FeedPortraitVideoView";
    public transient /* synthetic */ FieldHolder $fh;
    public View mAdView;
    public IFeedPortraitListener mFeedVideoListener;
    public ClassLoader mLoader;
    public String mRemoteClassName;
    public Context mViewContext;
    public boolean useDownloadFrame;

    /* loaded from: classes3.dex */
    public class InvocationHandlerImp implements InvocationHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FeedPortraitVideoView this$0;

        public InvocationHandlerImp(FeedPortraitVideoView feedPortraitVideoView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {feedPortraitVideoView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = feedPortraitVideoView;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, obj, method, objArr)) == null) {
                String name = method.getName();
                if (TextUtils.isEmpty(name)) {
                    return null;
                }
                if (name.equals("playCompletion")) {
                    if (this.this$0.mFeedVideoListener != null) {
                        this.this$0.mFeedVideoListener.playCompletion();
                    }
                } else if (name.equals(FeedPortraitVideoView.PLAY_ERROR)) {
                    if (this.this$0.mFeedVideoListener != null) {
                        this.this$0.mFeedVideoListener.playError();
                    }
                } else if (name.equals(FeedPortraitVideoView.PLAY_START)) {
                    if (this.this$0.mFeedVideoListener != null) {
                        this.this$0.mFeedVideoListener.playRenderingStart();
                    }
                } else if (name.equals(FeedPortraitVideoView.PLAY_PAUSE)) {
                    if (this.this$0.mFeedVideoListener != null) {
                        this.this$0.mFeedVideoListener.playPause();
                    }
                } else if (name.equals(FeedPortraitVideoView.PLAY_RESUME)) {
                    if (this.this$0.mFeedVideoListener != null) {
                        this.this$0.mFeedVideoListener.playResume();
                    }
                } else if (name.equals(FeedPortraitVideoView.FEED_CLICK) && this.this$0.mFeedVideoListener != null) {
                    this.this$0.mFeedVideoListener.pauseBtnClick();
                }
                return null;
            }
            return invokeLLL.objValue;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FeedPortraitVideoView(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    private void init(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, context) == null) {
            this.mViewContext = context;
            Object[] objArr = {context};
            ClassLoader a = bq.a(context);
            this.mLoader = a;
            View view2 = (View) ar.a(this.mRemoteClassName, a, new Class[]{Context.class}, objArr);
            this.mAdView = view2;
            if (view2 != null) {
                addView(view2, new RelativeLayout.LayoutParams(-1, -1));
            }
        }
    }

    public void setFeedPortraitListener(IFeedPortraitListener iFeedPortraitListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, iFeedPortraitListener) == null) {
            this.mFeedVideoListener = iFeedPortraitListener;
            try {
                Class<?> a = ar.a("com.component.feed.IFeedPortraitListener", this.mLoader);
                if (a != null) {
                    Object newProxyInstance = Proxy.newProxyInstance(a.getClassLoader(), new Class[]{a}, new InvocationHandlerImp(this));
                    if (this.mAdView != null) {
                        ar.a(this.mRemoteClassName, this.mAdView, this.mLoader, "setFeedPortraitListener", new Class[]{a}, newProxyInstance);
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    public void setVideoMute(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            try {
                if (this.mAdView != null) {
                    ar.a(this.mRemoteClassName, this.mAdView, this.mLoader, "userSetVideoMute", new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void systemSetVideoMute(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
            try {
                if (this.mAdView != null) {
                    ar.a(this.mRemoteClassName, this.mAdView, this.mLoader, "setVideoMute", new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FeedPortraitVideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedPortraitVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mRemoteClassName = w.d;
        this.useDownloadFrame = false;
        init(context);
    }

    public void handleFeedCover(AbstractData abstractData) {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, abstractData) == null) && (view2 = this.mAdView) != null) {
            ar.a(this.mRemoteClassName, view2, this.mLoader, "handleCover", new Class[]{Object.class}, abstractData);
        }
    }

    public void hideFeedCoverPic(AbstractData abstractData) {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, abstractData) == null) && (view2 = this.mAdView) != null) {
            ar.a(this.mRemoteClassName, view2, this.mLoader, "hideFeedCoverPic", new Class[]{Object.class}, abstractData);
        }
    }

    public void hideFeedPauseBtn(AbstractData abstractData) {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, abstractData) == null) && (view2 = this.mAdView) != null) {
            ar.a(this.mRemoteClassName, view2, this.mLoader, "hidePauseBtn", new Class[]{Object.class}, abstractData);
        }
    }

    public void seekTo(int i) {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048586, this, i) == null) && (view2 = this.mAdView) != null) {
            ar.a(this.mRemoteClassName, view2, this.mLoader, "seekTo", new Class[]{Integer.TYPE}, Integer.valueOf(i));
        }
    }

    public void setCanClickVideo(boolean z) {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048588, this, z) == null) && (view2 = this.mAdView) != null) {
            ar.a(this.mRemoteClassName, view2, this.mLoader, "setCanClickVideo", new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
        }
    }

    public void setPlayBackSpeed(float f) {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeF(1048590, this, f) == null) && (view2 = this.mAdView) != null) {
            ar.a(this.mRemoteClassName, view2, this.mLoader, "setPlayBackSpeed", new Class[]{Float.TYPE}, Float.valueOf(f));
        }
    }

    public void setProgressBackgroundColor(int i) {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048591, this, i) == null) && (view2 = this.mAdView) != null) {
            ar.a(this.mRemoteClassName, view2, this.mLoader, "setProgressBackgroundColor", new Class[]{Integer.TYPE}, Integer.valueOf(i));
        }
    }

    public void setProgressBarColor(int i) {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048592, this, i) == null) && (view2 = this.mAdView) != null) {
            ar.a(this.mRemoteClassName, view2, this.mLoader, "setProgressBarColor", new Class[]{Integer.TYPE}, Integer.valueOf(i));
        }
    }

    public void setProgressHeightInDp(int i) {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048593, this, i) == null) && (view2 = this.mAdView) != null) {
            ar.a(this.mRemoteClassName, view2, this.mLoader, "setProgressHeightDp", new Class[]{Integer.TYPE}, Integer.valueOf(i));
        }
    }

    public void setShowProgress(boolean z) {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048594, this, z) == null) && (view2 = this.mAdView) != null) {
            ar.a(this.mRemoteClassName, view2, this.mLoader, "setShowProgressBar", new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
        }
    }

    public void setUseDownloadFrame(boolean z) {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048595, this, z) == null) && (view2 = this.mAdView) != null) {
            ar.a(this.mRemoteClassName, view2, this.mLoader, "setUseDownloadFrame", new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
        }
    }

    public void showFeedVideoCover(AbstractData abstractData) {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048597, this, abstractData) == null) && (view2 = this.mAdView) != null) {
            ar.a(this.mRemoteClassName, view2, this.mLoader, "showFeedVideoCover", new Class[]{Object.class}, abstractData);
        }
    }

    public void showNormalPic(AbstractData abstractData) {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048598, this, abstractData) == null) && abstractData != null && (view2 = this.mAdView) != null) {
            ar.a(this.mRemoteClassName, view2, this.mLoader, "showNormalPic", new Class[]{Object.class}, abstractData);
        }
    }

    public long getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            View view2 = this.mAdView;
            if (view2 != null) {
                return ((Long) ar.a(this.mRemoteClassName, view2, this.mLoader, "getCurrentPosition", new Class[0], new Object[0])).longValue();
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    public long getDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            View view2 = this.mAdView;
            if (view2 != null) {
                return ((Long) ar.a(this.mRemoteClassName, view2, this.mLoader, "getDuration", new Class[0], new Object[0])).longValue();
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            View view2 = this.mAdView;
            if (view2 != null) {
                Object a = ar.a(this.mRemoteClassName, view2, this.mLoader, "isPlaying", new Class[0], new Object[0]);
                if (a instanceof Boolean) {
                    return ((Boolean) a).booleanValue();
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isShowEndFrame() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            View view2 = this.mAdView;
            if (view2 == null) {
                return false;
            }
            return ((Boolean) ar.a(this.mRemoteClassName, view2, this.mLoader, "isShowEndFrame", new Class[0], new Object[0])).booleanValue();
        }
        return invokeV.booleanValue;
    }

    public void pause() {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && (view2 = this.mAdView) != null) {
            ar.a(this.mRemoteClassName, view2, this.mLoader, DownloadStatisticConstants.UBC_TYPE_PAUSE, new Class[0], new Object[0]);
        }
    }

    public void play() {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (view2 = this.mAdView) != null) {
            ar.a(this.mRemoteClassName, view2, this.mLoader, "play", new Class[0], new Object[0]);
        }
    }

    public void resume() {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (view2 = this.mAdView) != null) {
            ar.a(this.mRemoteClassName, view2, this.mLoader, DownloadStatisticConstants.UBC_TYPE_RESUME, new Class[0], new Object[0]);
        }
    }

    public void stop() {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048599, this) == null) && (view2 = this.mAdView) != null) {
            ar.a(this.mRemoteClassName, view2, this.mLoader, "stop", new Class[0], new Object[0]);
        }
    }

    public void setAdData(AbstractData abstractData) {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, abstractData) == null) && abstractData != null && (view2 = this.mAdView) != null) {
            if (abstractData instanceof NativeCPUAdData) {
                ar.a(this.mRemoteClassName, view2, this.mLoader, "setCpuAdData", new Class[]{Object.class}, abstractData);
            } else {
                ar.a(this.mRemoteClassName, view2, this.mLoader, "setAdData", new Class[]{Object.class}, abstractData);
            }
        }
    }
}
