package com.baidu.searchbox.player;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.player.annotation.PublicMethod;
import com.baidu.searchbox.player.callback.IVideoPlayerCallback;
import com.baidu.searchbox.player.callback.VideoPlayerCallbackBaseManager;
import com.baidu.searchbox.player.constants.PlayerStatus;
import com.baidu.searchbox.player.event.ControlEventTrigger;
import com.baidu.searchbox.player.event.InternalSyncControlEventTrigger;
import com.baidu.searchbox.player.event.PlayerEventTrigger;
import com.baidu.searchbox.player.event.StatisticsEvent;
import com.baidu.searchbox.player.event.StatisticsEventTrigger;
import com.baidu.searchbox.player.event.VideoEvent;
import com.baidu.searchbox.player.helper.SimpleKernelReuseHelper;
import com.baidu.searchbox.player.helper.VideoSystemHelper;
import com.baidu.searchbox.player.interfaces.IKernelLayerReuseHelper;
import com.baidu.searchbox.player.interfaces.IVideoEventInterceptor;
import com.baidu.searchbox.player.interfaces.InternalEventDispatcher;
import com.baidu.searchbox.player.kernel.AbsVideoKernel;
import com.baidu.searchbox.player.kernel.IKernelPlayer;
import com.baidu.searchbox.player.layer.AbsLayer;
import com.baidu.searchbox.player.layer.BaseKernelLayer;
import com.baidu.searchbox.player.layer.LayerContainer;
import com.baidu.searchbox.player.message.IMessenger;
import com.baidu.searchbox.player.model.VideoTask;
import com.baidu.searchbox.player.plugin.AbsPlugin;
import com.baidu.searchbox.player.plugin.PluginManager;
import com.baidu.searchbox.player.session.VideoSessionManager;
import com.baidu.searchbox.player.ubc.IPlayerStatisticsDispatcher;
import com.baidu.searchbox.player.ubc.SimpleVideoStatisticsDispatcher;
import com.baidu.searchbox.player.utils.BdVideoLog;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import org.webrtc.MediaStreamTrack;
/* loaded from: classes10.dex */
public abstract class BDVideoPlayer implements IBVideoPlayer, IKernelPlayer {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "BDVideoPlayer";
    public static boolean sGlobalMute;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isUseCache;
    public AudioFocusChangedListener mAudioFocusListener;
    public AudioManager mAudioManager;
    public VideoPlayerCallbackBaseManager mCallbackManager;
    public ViewGroup.LayoutParams mContainerLayoutParams;
    public final ControlEventTrigger mControlEventTrigger;
    public boolean mHasAudioFocus;
    public boolean mIsForeground;
    public boolean mIsMute;
    @Nullable
    public String mKLayerCacheKey;
    @Nullable
    public BaseKernelLayer mKernelLayer;
    @NonNull
    public String mKey;
    public LayerContainer mLayerContainer;
    public IMessenger mMessenger;
    public ViewGroup mPlayerContainer;
    public final PlayerEventTrigger mPlayerEventTrigger;
    public PluginManager mPluginManager;
    public IKernelLayerReuseHelper mReuseHelper;
    public int mScaleMode;
    public float mSpeed;
    public final StatisticsEventTrigger mStatEventTrigger;
    public final InternalSyncControlEventTrigger mSyncControlEventTrigger;
    public int mVideoLoopCount;
    public VideoTask mVideoTask;

    /* loaded from: classes10.dex */
    public class AudioFocusChangedListener implements AudioManager.OnAudioFocusChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BDVideoPlayer this$0;

        public AudioFocusChangedListener(BDVideoPlayer bDVideoPlayer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bDVideoPlayer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = bDVideoPlayer;
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                this.this$0.onAudioFocusChanged(i2);
            }
        }
    }

    /* loaded from: classes10.dex */
    public class InternalPlayerDispatcher implements InternalEventDispatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BDVideoPlayer this$0;

        public InternalPlayerDispatcher(BDVideoPlayer bDVideoPlayer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bDVideoPlayer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = bDVideoPlayer;
        }

        @Override // com.baidu.searchbox.player.interfaces.InternalEventDispatcher
        public int getExpectOrder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.searchbox.player.interfaces.InternalEventDispatcher
        public void onVideoEventNotify(VideoEvent videoEvent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, videoEvent) == null) {
                this.this$0.getPlayerCallbackManager().dispatchPlayerAction(videoEvent);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(347566101, "Lcom/baidu/searchbox/player/BDVideoPlayer;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(347566101, "Lcom/baidu/searchbox/player/BDVideoPlayer;");
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BDVideoPlayer(@Nullable Context context) {
        this(context, new BaseKernelLayer(AbsVideoKernel.NORMAL_PLAYER));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (BaseKernelLayer) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    private void createEnv(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, context) == null) {
            this.mContainerLayoutParams = new ViewGroup.LayoutParams(-1, -1);
            this.mVideoTask = new VideoTask();
            initMessenger();
            this.mPluginManager = new PluginManager(this);
            LayerContainer createLayerContainer = createLayerContainer(context);
            this.mLayerContainer = createLayerContainer;
            createLayerContainer.bindPlayer(this);
            this.mLayerContainer.setClickable(true);
            initCallBackManager();
        }
    }

    private void createSessionId(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65541, this, z) == null) {
            if (z || TextUtils.isEmpty(this.mVideoTask.sessionId)) {
                this.mVideoTask.sessionId = VideoSessionManager.getInstance().getSessionId(getVideoUniqueKey());
            }
        }
    }

    @NonNull
    private InternalSyncControlEventTrigger getInternalSyncControlEventTrigger() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) ? this.mSyncControlEventTrigger : (InternalSyncControlEventTrigger) invokeV.objValue;
    }

    private void initMessenger() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            IMessenger createMessenger = BDPlayerConfig.getMessengerFactory().createMessenger();
            this.mMessenger = createMessenger;
            createMessenger.addInternalDispatcher(new InternalPlayerDispatcher());
            VideoSessionManager.getInstance().bindPlayer(this);
        }
    }

    @PublicMethod
    public static boolean isGlobalMute() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? sGlobalMute : invokeV.booleanValue;
    }

    private void releaseMessenger() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            VideoSessionManager.getInstance().unbindPlayer(this);
            this.mMessenger.release();
        }
    }

    public void abandonAudioFocus() {
        AudioFocusChangedListener audioFocusChangedListener;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            AudioManager audioManager = this.mAudioManager;
            if (audioManager != null && (audioFocusChangedListener = this.mAudioFocusListener) != null) {
                audioManager.abandonAudioFocus(audioFocusChangedListener);
                BdVideoLog.i(wrapMessage("abandonAudioFocus()"));
                this.mAudioManager = null;
                this.mAudioFocusListener = null;
            }
            this.mHasAudioFocus = false;
        }
    }

    @PublicMethod
    public void addInterceptor(@NonNull IVideoEventInterceptor iVideoEventInterceptor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, iVideoEventInterceptor) == null) {
            this.mMessenger.addInterceptor(iVideoEventInterceptor);
        }
    }

    @PublicMethod
    public void addLayer(@NonNull AbsLayer absLayer, FrameLayout.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, absLayer, layoutParams) == null) {
            this.mLayerContainer.addLayer(absLayer, layoutParams);
        }
    }

    @PublicMethod
    public void addPlugin(@NonNull AbsPlugin absPlugin) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, absPlugin) == null) {
            this.mPluginManager.addPlugin(absPlugin);
        }
    }

    public boolean attachKLayerFromCache(@Nullable String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) ? getReuseHelper().attachCache(this, str) : invokeL.booleanValue;
    }

    @PublicMethod
    public void attachKernelLayer(@NonNull BaseKernelLayer baseKernelLayer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, baseKernelLayer) == null) {
            detachKernelLayer();
            BdVideoLog.i(wrapMessage("attachKernelLayer(" + System.identityHashCode(baseKernelLayer) + "), kernel = " + System.identityHashCode(baseKernelLayer.getVideoKernel())));
            this.mKernelLayer = baseKernelLayer;
            baseKernelLayer.setKernelCallBack(this);
            this.mLayerContainer.attachKernelLayer(baseKernelLayer);
        }
    }

    @PublicMethod
    public void attachToContainer(@NonNull ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, viewGroup) == null) {
            attachToContainer(viewGroup, true);
        }
    }

    public LayerContainer createLayerContainer(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, context)) == null) ? new LayerContainer(context) : (LayerContainer) invokeL.objValue;
    }

    @PublicMethod
    public void detachFromContainer() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            detachFromContainer(true);
        }
    }

    public boolean detachKLayerToCache() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? detachKLayerToCache(this.mKLayerCacheKey) : invokeV.booleanValue;
    }

    @Nullable
    @PublicMethod
    public BaseKernelLayer detachKernelLayer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            if (this.mKernelLayer != null) {
                BdVideoLog.i(wrapMessage("detachKernelLayer = " + System.identityHashCode(this.mKernelLayer)));
                BaseKernelLayer baseKernelLayer = this.mKernelLayer;
                this.mLayerContainer.detachLayer((AbsLayer) baseKernelLayer, true);
                baseKernelLayer.setKernelCallBack(null);
                this.mKernelLayer = null;
                return baseKernelLayer;
            }
            return null;
        }
        return (BaseKernelLayer) invokeV.objValue;
    }

    @PublicMethod
    public void detachLayer(@NonNull AbsLayer absLayer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, absLayer) == null) {
            this.mLayerContainer.detachLayer(absLayer, true);
        }
    }

    @PublicMethod
    public void doPlay() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            BdVideoLog.i(wrapMessage("doPlay(), status = " + getStatus()));
            if (this.mKernelLayer == null || isPause()) {
                return;
            }
            if (!isPlayerMute()) {
                requestAudioFocus();
            }
            VideoSystemHelper.setKeepScreenOnOff(getActivity(), true);
            getControlEventTrigger().start();
            getInternalSyncControlEventTrigger().start();
            BdVideoLog.i(wrapMessage("doPlay, url = " + getVideoUrl()));
            getStatDispatcher().start();
            getStatEventTrigger().onPlayerStart();
        }
    }

    @Nullable
    @PublicMethod
    public Activity getActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            ViewGroup viewGroup = this.mPlayerContainer;
            if (viewGroup == null || !(viewGroup.getContext() instanceof Activity)) {
                return null;
            }
            return (Activity) this.mPlayerContainer.getContext();
        }
        return (Activity) invokeV.objValue;
    }

    @NonNull
    @PublicMethod
    public Context getAppContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? BDPlayerConfig.getAppContext() : (Context) invokeV.objValue;
    }

    @Nullable
    @PublicMethod
    public ViewGroup getAttachedContainer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.mPlayerContainer : (ViewGroup) invokeV.objValue;
    }

    @NonNull
    public String getBackupKernelType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? AbsVideoKernel.CYBER_PLAYER : (String) invokeV.objValue;
    }

    @PublicMethod
    public int getBufferingPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            BaseKernelLayer baseKernelLayer = this.mKernelLayer;
            if (baseKernelLayer == null) {
                return 0;
            }
            return baseKernelLayer.getBufferingPosition();
        }
        return invokeV.intValue;
    }

    @NonNull
    @PublicMethod
    public ControlEventTrigger getControlEventTrigger() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.mControlEventTrigger : (ControlEventTrigger) invokeV.objValue;
    }

    @PublicMethod
    public int getDecodeMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            BaseKernelLayer baseKernelLayer = this.mKernelLayer;
            if (baseKernelLayer != null) {
                return baseKernelLayer.getDecodeMode();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @PublicMethod
    public int getDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            BaseKernelLayer baseKernelLayer = this.mKernelLayer;
            if (baseKernelLayer == null) {
                return this.mVideoTask.duration;
            }
            return baseKernelLayer.getDuration();
        }
        return invokeV.intValue;
    }

    @PublicMethod
    public int getDurationMs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            BaseKernelLayer baseKernelLayer = this.mKernelLayer;
            if (baseKernelLayer == null) {
                return this.mVideoTask.duration * 1000;
            }
            return baseKernelLayer.getDurationMs();
        }
        return invokeV.intValue;
    }

    @Nullable
    @PublicMethod(version = "11.26.0.0")
    public String getKLayerCacheKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.mKLayerCacheKey : (String) invokeV.objValue;
    }

    @Nullable
    public String getKLogId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            BaseKernelLayer baseKernelLayer = this.mKernelLayer;
            return baseKernelLayer != null ? baseKernelLayer.getKernelLogId() : "";
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    @PublicMethod
    public LayerContainer getLayerContainer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.mLayerContainer : (LayerContainer) invokeV.objValue;
    }

    @PublicMethod
    public int getLoopCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.mVideoLoopCount : invokeV.intValue;
    }

    public IMessenger getMessenger() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.mMessenger : (IMessenger) invokeV.objValue;
    }

    @NonNull
    @PublicMethod
    public VideoPlayerCallbackBaseManager getPlayerCallbackManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.mCallbackManager : (VideoPlayerCallbackBaseManager) invokeV.objValue;
    }

    public PlayerEventTrigger getPlayerEventTrigger() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.mPlayerEventTrigger : (PlayerEventTrigger) invokeV.objValue;
    }

    @Nullable
    @PublicMethod
    public BaseKernelLayer getPlayerKernelLayer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.mKernelLayer : (BaseKernelLayer) invokeV.objValue;
    }

    @PublicMethod
    public int getPlayerStageType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            return -1;
        }
        return invokeV.intValue;
    }

    @PublicMethod
    public int getPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            BaseKernelLayer baseKernelLayer = this.mKernelLayer;
            if (baseKernelLayer == null) {
                return 0;
            }
            return baseKernelLayer.getPosition();
        }
        return invokeV.intValue;
    }

    @PublicMethod
    public int getPositionMs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            BaseKernelLayer baseKernelLayer = this.mKernelLayer;
            if (baseKernelLayer == null) {
                return 0;
            }
            return baseKernelLayer.getPositionMs();
        }
        return invokeV.intValue;
    }

    @NonNull
    public IKernelLayerReuseHelper getReuseHelper() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            if (this.mReuseHelper == null) {
                this.mReuseHelper = new SimpleKernelReuseHelper();
            }
            return this.mReuseHelper;
        }
        return (IKernelLayerReuseHelper) invokeV.objValue;
    }

    @PublicMethod(version = "12.10.0.0")
    public int getScaleMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? this.mScaleMode : invokeV.intValue;
    }

    @Nullable
    @PublicMethod
    public String getServerIpInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            BaseKernelLayer baseKernelLayer = this.mKernelLayer;
            if (baseKernelLayer != null) {
                return baseKernelLayer.getServerIpInfo();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Nullable
    public String getSessionId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) ? this.mVideoTask.sessionId : (String) invokeV.objValue;
    }

    @PublicMethod(version = "12.2.0.0")
    public float getSpeed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) ? this.mSpeed : invokeV.floatValue;
    }

    @NonNull
    @PublicMethod
    @Deprecated
    public IPlayerStatisticsDispatcher getStatDispatcher() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) ? SimpleVideoStatisticsDispatcher.EMPTY : (IPlayerStatisticsDispatcher) invokeV.objValue;
    }

    @NonNull
    @PublicMethod(version = "11.24.0.0")
    public StatisticsEventTrigger getStatEventTrigger() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) ? this.mStatEventTrigger : (StatisticsEventTrigger) invokeV.objValue;
    }

    @NonNull
    @PublicMethod
    public PlayerStatus getStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            BaseKernelLayer baseKernelLayer = this.mKernelLayer;
            return baseKernelLayer == null ? PlayerStatus.IDLE : baseKernelLayer.getStatus();
        }
        return (PlayerStatus) invokeV.objValue;
    }

    @PublicMethod
    public int getSyncPositionMs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            BaseKernelLayer baseKernelLayer = this.mKernelLayer;
            if (baseKernelLayer == null) {
                return 0;
            }
            return baseKernelLayer.getSyncPositionMs();
        }
        return invokeV.intValue;
    }

    @PublicMethod(version = "11.24.0.0")
    public int getVideoHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            BaseKernelLayer baseKernelLayer = this.mKernelLayer;
            if (baseKernelLayer != null) {
                return baseKernelLayer.getVideoHeight();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @PublicMethod
    public VideoTask getVideoTask() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) ? this.mVideoTask : (VideoTask) invokeV.objValue;
    }

    @NonNull
    @PublicMethod
    public String getVideoUniqueKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) ? this.mKey : (String) invokeV.objValue;
    }

    @PublicMethod
    public String getVideoUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
            BaseKernelLayer baseKernelLayer = this.mKernelLayer;
            return baseKernelLayer == null ? "" : baseKernelLayer.getVideoUrl();
        }
        return (String) invokeV.objValue;
    }

    @PublicMethod(version = "11.24.0.0")
    public int getVideoWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) {
            BaseKernelLayer baseKernelLayer = this.mKernelLayer;
            if (baseKernelLayer != null) {
                return baseKernelLayer.getVideoWidth();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @PublicMethod
    public void goBackOrForeground(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048628, this, z) == null) {
            BdVideoLog.i(wrapMessage("goBackOrForeground(" + z + SmallTailInfo.EMOTION_SUFFIX));
            this.mIsForeground = z;
            getStatDispatcher().goBackOrForeground(z, getLoopCount());
            getStatEventTrigger().onPlayerBackOrForeground(z);
            VideoSystemHelper.setKeepScreenOnOff(getActivity(), z);
            getPlayerEventTrigger().goBackOrForeground(z);
            getPlayerCallbackManager().onGoBackOrForeground(z);
        }
    }

    public void initCallBackManager() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048629, this) == null) {
            this.mCallbackManager = new VideoPlayerCallbackBaseManager();
        }
    }

    public void initPlayer() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048630, this) == null) {
        }
    }

    @PublicMethod
    public void insertLayer(@NonNull AbsLayer absLayer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048631, this, absLayer) == null) {
            this.mLayerContainer.insertLayer(absLayer, (FrameLayout.LayoutParams) null);
        }
    }

    @PublicMethod
    public boolean isAttachToContainer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) ? this.mLayerContainer.getParent() != null : invokeV.booleanValue;
    }

    @PublicMethod
    public boolean isComplete() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) ? getStatus() == PlayerStatus.COMPLETE : invokeV.booleanValue;
    }

    @PublicMethod
    public boolean isError() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) ? getStatus() == PlayerStatus.ERROR : invokeV.booleanValue;
    }

    @PublicMethod
    public boolean isForeground() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) ? this.mIsForeground : invokeV.booleanValue;
    }

    @PublicMethod
    public boolean isHasAudioFocus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) ? this.mHasAudioFocus : invokeV.booleanValue;
    }

    @PublicMethod
    public boolean isIdle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) ? getStatus() == PlayerStatus.IDLE : invokeV.booleanValue;
    }

    @PublicMethod
    public boolean isMute() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) ? this.mIsMute : invokeV.booleanValue;
    }

    @PublicMethod
    public boolean isPause() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) ? getStatus() == PlayerStatus.PAUSE : invokeV.booleanValue;
    }

    @PublicMethod
    public boolean isPlayerMute() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) ? isGlobalMute() : invokeV.booleanValue;
    }

    @Override // com.baidu.searchbox.player.IBVideoPlayer
    @PublicMethod
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) ? getStatus() == PlayerStatus.PLAYING : invokeV.booleanValue;
    }

    @PublicMethod
    public boolean isPrepared() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048642, this)) == null) ? getStatus() == PlayerStatus.PREPARED : invokeV.booleanValue;
    }

    @PublicMethod
    public boolean isPreparing() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048643, this)) == null) ? getStatus() == PlayerStatus.PREPARING : invokeV.booleanValue;
    }

    @PublicMethod
    public boolean isStop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048644, this)) == null) ? getStatus() == PlayerStatus.STOP : invokeV.booleanValue;
    }

    public boolean isUseCache() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048645, this)) == null) ? this.isUseCache : invokeV.booleanValue;
    }

    public boolean matchStatus(@NonNull PlayerStatus... playerStatusArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048646, this, playerStatusArr)) == null) {
            BaseKernelLayer baseKernelLayer = this.mKernelLayer;
            if (baseKernelLayer == null) {
                return false;
            }
            return baseKernelLayer.getVideoSession().matchStatus(playerStatusArr);
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.searchbox.player.IBVideoPlayer
    @PublicMethod
    public void mute(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048647, this, z) == null) {
            BdVideoLog.i(wrapMessage("mute(" + z + SmallTailInfo.EMOTION_SUFFIX));
            BaseKernelLayer baseKernelLayer = this.mKernelLayer;
            if (baseKernelLayer == null) {
                return;
            }
            baseKernelLayer.mute(z);
        }
    }

    public void onAudioFocusChanged(int i2) {
        Activity activity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048648, this, i2) == null) || (activity = getActivity()) == null || isPlayerMute()) {
            return;
        }
        activity.runOnUiThread(new Runnable(this, i2) { // from class: com.baidu.searchbox.player.BDVideoPlayer.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ BDVideoPlayer this$0;
            public final /* synthetic */ int val$focusChange;

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
                this.val$focusChange = i2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    int i3 = this.val$focusChange;
                    if ((i3 == -2 || i3 == -1) && this.this$0.isPlaying()) {
                        this.this$0.pause(2);
                        this.this$0.abandonAudioFocus();
                    }
                }
            }
        });
    }

    @Override // com.baidu.searchbox.player.kernel.IKernelPlayer
    public void onBufferingUpdate(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048649, this, i2) == null) {
            getPlayerEventTrigger().onBufferingUpdate(i2);
        }
    }

    public void onCompletion() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048650, this) == null) {
            abandonAudioFocus();
            getPlayerEventTrigger().onCompletion();
            getStatDispatcher().end(getLoopCount());
            getStatEventTrigger().onPlayerComplete(getLoopCount());
        }
    }

    @Override // com.baidu.searchbox.player.kernel.IKernelPlayer
    public boolean onError(int i2, int i3, Object obj) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048651, this, i2, i3, obj)) == null) {
            getPlayerEventTrigger().onError(i2, i3, obj);
            getStatDispatcher().onError(i2, i3, obj);
            getStatEventTrigger().onError(i2, i3, obj);
            VideoSystemHelper.setKeepScreenOnOff(getActivity(), false);
            return true;
        }
        return invokeIIL.booleanValue;
    }

    public boolean onInfo(int i2, int i3, Object obj) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048652, this, i2, i3, obj)) == null) {
            getPlayerEventTrigger().onInfo(i2, i3, obj);
            getStatDispatcher().onInfo(i2, i3, obj != null ? obj.toString() : "");
            getStatEventTrigger().onInfo(i2, i3, obj);
            return false;
        }
        return invokeIIL.booleanValue;
    }

    @Override // com.baidu.searchbox.player.kernel.IKernelPlayer
    public boolean onMediaSourceChanged(int i2, int i3, Object obj) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048653, this, i2, i3, obj)) == null) {
            getPlayerEventTrigger().onMediaSourceChanged(i2, i3, obj);
            return true;
        }
        return invokeIIL.booleanValue;
    }

    public void onPrepared() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048654, this) == null) {
            getPlayerEventTrigger().onPrepared();
        }
    }

    public void onSeekComplete() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048655, this) == null) {
            getPlayerEventTrigger().onSeekComplete();
        }
    }

    @Override // com.baidu.searchbox.player.kernel.IKernelPlayer
    public void onVideoSizeChanged(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048656, this, i2, i3, i4, i5) == null) {
            getPlayerEventTrigger().onVideoSizeChanged(i2, i3, i4, i5);
        }
    }

    @Override // com.baidu.searchbox.player.IBVideoPlayer
    @PublicMethod
    public void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048657, this) == null) {
            pause(0);
        }
    }

    @PublicMethod
    public void pauseInternal(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048659, this, z) == null) {
            pause(z ? 1 : 0);
        }
    }

    @Override // com.baidu.searchbox.player.IBVideoPlayer
    @PublicMethod
    public void play(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048660, this, str) == null) {
            BdVideoLog.i(wrapMessage("play(), url = " + str));
            BaseKernelLayer baseKernelLayer = this.mKernelLayer;
            if (baseKernelLayer == null) {
                return;
            }
            baseKernelLayer.play(str);
        }
    }

    @Override // com.baidu.searchbox.player.IBVideoPlayer
    @PublicMethod
    public void prepare() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048661, this) == null) {
            BdVideoLog.i(wrapMessage("prepare()"));
            getControlEventTrigger().prepare();
            getInternalSyncControlEventTrigger().prepare();
        }
    }

    @PublicMethod
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048662, this) == null) {
            BdVideoLog.i(wrapMessage("release()"));
            getStatDispatcher().stop(getLoopCount());
            getStatEventTrigger().onPlayerStop(getLoopCount());
            getStatDispatcher().release();
            releaseKernelLayer();
            VideoSystemHelper.setKeepScreenOnOff(getActivity(), false);
            getPlayerCallbackManager().release();
            abandonAudioFocus();
            releaseTrigger();
            this.mPluginManager.release();
            this.mLayerContainer.release();
            detachFromContainer(false);
            releaseMessenger();
            this.mPlayerContainer = null;
        }
    }

    public void releaseKernelLayer() {
        BaseKernelLayer baseKernelLayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048663, this) == null) || (baseKernelLayer = this.mKernelLayer) == null) {
            return;
        }
        baseKernelLayer.pause();
        this.mKernelLayer.stop();
        this.mKernelLayer.release();
    }

    public void releaseTrigger() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048664, this) == null) {
            getStatEventTrigger().release();
            getPlayerEventTrigger().release();
            getControlEventTrigger().release();
            getInternalSyncControlEventTrigger().release();
        }
    }

    public void removeInterceptor(@NonNull IVideoEventInterceptor iVideoEventInterceptor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048665, this, iVideoEventInterceptor) == null) {
            this.mMessenger.removeInterceptor(iVideoEventInterceptor);
        }
    }

    @PublicMethod
    public void removePlugin(@NonNull AbsPlugin absPlugin) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048666, this, absPlugin) == null) {
            this.mPluginManager.removePlugin(absPlugin);
        }
    }

    @PublicMethod
    public void replaceVideoHolder(@NonNull ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048667, this, viewGroup) == null) {
            this.mPlayerContainer = viewGroup;
        }
    }

    public void requestAudioFocus() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048668, this) == null) || this.mHasAudioFocus) {
            return;
        }
        if (this.mAudioManager == null) {
            this.mAudioManager = (AudioManager) getAppContext().getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
        }
        if (this.mAudioManager != null) {
            if (this.mAudioFocusListener == null) {
                this.mAudioFocusListener = new AudioFocusChangedListener();
            }
            this.mHasAudioFocus = this.mAudioManager.requestAudioFocus(this.mAudioFocusListener, 3, 2) == 1;
            BdVideoLog.i(wrapMessage("requestAudioFocus()"));
        }
    }

    public void restoreVideoTask(@NonNull BaseKernelLayer baseKernelLayer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048669, this, baseKernelLayer) == null) {
            this.mVideoTask.videoUrl = baseKernelLayer.getVideoUrl();
            this.mVideoTask.duration = baseKernelLayer.getDuration();
            this.mVideoTask.position = baseKernelLayer.getPosition();
            this.mVideoTask.positionMs = baseKernelLayer.getPositionMs();
        }
    }

    @Override // com.baidu.searchbox.player.IBVideoPlayer
    @PublicMethod
    public void resume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048670, this) == null) {
            BdVideoLog.i(wrapMessage("resume()"));
            if (this.mKernelLayer != null && isPause()) {
                if (!isPlayerMute()) {
                    requestAudioFocus();
                }
                getControlEventTrigger().resume();
                getInternalSyncControlEventTrigger().resume();
                getStatDispatcher().resume();
                getStatEventTrigger().onPlayerResume();
            }
        }
    }

    public void resumeFromError() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048671, this) == null) {
            BdVideoLog.i(wrapMessage("resumeFromError()"));
            BaseKernelLayer baseKernelLayer = this.mKernelLayer;
            if (baseKernelLayer != null) {
                baseKernelLayer.stopPlayback();
            }
            setVideoScalingMode(getScaleMode());
            setVideoUrl(this.mVideoTask.videoUrl);
            resumePlayer(false);
        }
    }

    @PublicMethod
    public void resumePlayer(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048672, this, z) == null) {
            BdVideoLog.i(wrapMessage("resumePlayer(" + z + SmallTailInfo.EMOTION_SUFFIX));
            BaseKernelLayer baseKernelLayer = this.mKernelLayer;
            if (baseKernelLayer == null) {
                return;
            }
            if (z) {
                VideoTask videoTask = this.mVideoTask;
                videoTask.position = 0;
                videoTask.duration = 0;
                videoTask.positionMs = 0;
            } else {
                this.mVideoTask.position = baseKernelLayer.getPosition();
                this.mVideoTask.duration = this.mKernelLayer.getDuration();
                this.mVideoTask.positionMs = this.mKernelLayer.getPositionMs();
            }
            if (isPause()) {
                resume();
            } else {
                start();
            }
        }
    }

    @Override // com.baidu.searchbox.player.IBVideoPlayer
    @PublicMethod
    public void seekTo(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048673, this, i2) == null) {
            getControlEventTrigger().seekToMs(i2 * 1000, 3);
        }
    }

    @PublicMethod
    public void seekToMs(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048674, this, i2) == null) {
            getControlEventTrigger().seekToMs(i2, 3);
        }
    }

    @PublicMethod
    public void sendEvent(@NonNull VideoEvent videoEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048675, this, videoEvent) == null) {
            this.mMessenger.notifyEvent(videoEvent);
        }
    }

    @PublicMethod(version = "12.0.0.0")
    public void setClarityInfo(@Nullable String str) {
        BaseKernelLayer baseKernelLayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048676, this, str) == null) || (baseKernelLayer = this.mKernelLayer) == null) {
            return;
        }
        baseKernelLayer.setClarityInfo(str);
    }

    @PublicMethod
    public void setDecodeMode(int i2) {
        BaseKernelLayer baseKernelLayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048677, this, i2) == null) || (baseKernelLayer = this.mKernelLayer) == null) {
            return;
        }
        baseKernelLayer.setDecodeMode(i2);
    }

    @PublicMethod(version = "11.24.0.0")
    public void setExternalInfo(String str, Object obj) {
        BaseKernelLayer baseKernelLayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048678, this, str, obj) == null) || (baseKernelLayer = this.mKernelLayer) == null) {
            return;
        }
        baseKernelLayer.setExternalInfo(str, obj);
    }

    @PublicMethod
    public void setGlobalMuteMode(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048679, this, z) == null) {
            sGlobalMute = z;
            setMuteMode(z);
        }
    }

    @PublicMethod
    public void setHasReplaceUrl(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048680, this, z) == null) && z && this.mKernelLayer != null) {
            BdVideoLog.i(wrapMessage("setHasReplaceUrl(" + z + SmallTailInfo.EMOTION_SUFFIX));
            this.mKernelLayer.updateFreeProxy(null);
        }
    }

    @PublicMethod
    public void setHttpHeader(HashMap<String, String> hashMap) {
        BaseKernelLayer baseKernelLayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048681, this, hashMap) == null) || (baseKernelLayer = this.mKernelLayer) == null) {
            return;
        }
        baseKernelLayer.setHttpHeader(hashMap);
    }

    @PublicMethod
    public void setInterceptor(@Nullable IVideoEventInterceptor iVideoEventInterceptor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048682, this, iVideoEventInterceptor) == null) {
            this.mMessenger.setInterceptor(iVideoEventInterceptor);
        }
    }

    @PublicMethod(version = "11.26.0.0")
    public void setKLayerCacheKey(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048683, this, str) == null) {
            this.mKLayerCacheKey = str;
        }
    }

    @PublicMethod
    public void setLooping(boolean z) {
        BaseKernelLayer baseKernelLayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048684, this, z) == null) || (baseKernelLayer = this.mKernelLayer) == null) {
            return;
        }
        baseKernelLayer.setLooping(z);
    }

    @PublicMethod
    public void setMuteMode(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048685, this, z) == null) {
            BdVideoLog.i(wrapMessage("setMuteMode(" + z + SmallTailInfo.EMOTION_SUFFIX));
            this.mIsMute = z;
            BaseKernelLayer baseKernelLayer = this.mKernelLayer;
            if (baseKernelLayer != null) {
                baseKernelLayer.mute(z);
            }
            if (z) {
                abandonAudioFocus();
            } else if (isPlaying()) {
                requestAudioFocus();
            }
        }
    }

    @PublicMethod(version = "11.24.0.0")
    public void setOption(String str, String str2) {
        BaseKernelLayer baseKernelLayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048686, this, str, str2) == null) || (baseKernelLayer = this.mKernelLayer) == null) {
            return;
        }
        baseKernelLayer.setOption(str, str2);
    }

    @Deprecated
    public void setParameter(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048687, this, str, i2) == null) {
        }
    }

    @PublicMethod(version = "12.0.0.0")
    public void setPlayConf(@Nullable String str) {
        BaseKernelLayer baseKernelLayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048688, this, str) == null) || (baseKernelLayer = this.mKernelLayer) == null) {
            return;
        }
        baseKernelLayer.setPlayConf(str);
    }

    @PublicMethod
    public void setPlayerListener(IVideoPlayerCallback iVideoPlayerCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048689, this, iVideoPlayerCallback) == null) {
            getPlayerCallbackManager().setVideoPlayerCallback(iVideoPlayerCallback);
        }
    }

    @PublicMethod
    public void setProxy(@Nullable String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048690, this, str) == null) {
            BdVideoLog.i(wrapMessage("setProxy(" + str + SmallTailInfo.EMOTION_SUFFIX));
            BaseKernelLayer baseKernelLayer = this.mKernelLayer;
            if (baseKernelLayer == null) {
                return;
            }
            baseKernelLayer.setProxy(str);
        }
    }

    @PublicMethod(version = "11.26.0.0")
    public void setRadius(float f2) {
        BaseKernelLayer baseKernelLayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048691, this, f2) == null) || (baseKernelLayer = this.mKernelLayer) == null) {
            return;
        }
        baseKernelLayer.setRadius(f2);
    }

    public void setReuseHelper(@NonNull IKernelLayerReuseHelper iKernelLayerReuseHelper) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048692, this, iKernelLayerReuseHelper) == null) {
            this.mReuseHelper = iKernelLayerReuseHelper;
        }
    }

    @PublicMethod
    public void setSpeed(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048693, this, f2) == null) {
            this.mSpeed = f2;
            BaseKernelLayer baseKernelLayer = this.mKernelLayer;
            if (baseKernelLayer != null) {
                baseKernelLayer.setSpeed(f2);
                BdVideoLog.i(wrapMessage("setSpeed(" + f2 + SmallTailInfo.EMOTION_SUFFIX));
            }
        }
    }

    public void setStageInfo(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048694, this, str, str2, str3) == null) {
            BdVideoLog.i(wrapMessage("setStageInfo(" + str + StringUtil.ARRAY_ELEMENT_SEPARATOR + str2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + str3 + SmallTailInfo.EMOTION_SUFFIX));
        }
    }

    public void setTraceId(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048695, this, str) == null) {
            this.mVideoTask.traceId = str;
        }
    }

    public void setUseCache(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048696, this, z) == null) {
            this.isUseCache = z;
        }
    }

    @Override // com.baidu.searchbox.player.IBVideoPlayer
    @PublicMethod
    public void setUserAgent(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048697, this, str) == null) {
            BdVideoLog.i(wrapMessage("setUserAgent(" + str + SmallTailInfo.EMOTION_SUFFIX));
            BaseKernelLayer baseKernelLayer = this.mKernelLayer;
            if (baseKernelLayer == null) {
                return;
            }
            baseKernelLayer.setUserAgent(str);
        }
    }

    @Override // com.baidu.searchbox.player.IBVideoPlayer
    @PublicMethod
    public void setVideoBackground(Drawable drawable) {
        BaseKernelLayer baseKernelLayer;
        View bVideoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048698, this, drawable) == null) || (baseKernelLayer = this.mKernelLayer) == null || (bVideoView = baseKernelLayer.getVideoKernel().getBVideoView()) == null) {
            return;
        }
        bVideoView.setBackground(drawable);
    }

    @Override // com.baidu.searchbox.player.IBVideoPlayer
    @PublicMethod
    public void setVideoRotation(int i2) {
        BaseKernelLayer baseKernelLayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048699, this, i2) == null) || (baseKernelLayer = this.mKernelLayer) == null) {
            return;
        }
        baseKernelLayer.setVideoRotation(i2);
    }

    @Override // com.baidu.searchbox.player.IBVideoPlayer
    @PublicMethod
    public void setVideoScalingMode(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048700, this, i2) == null) {
            BdVideoLog.i(wrapMessage("setVideoScalingMode(" + i2 + SmallTailInfo.EMOTION_SUFFIX));
            BaseKernelLayer baseKernelLayer = this.mKernelLayer;
            if (baseKernelLayer == null) {
                return;
            }
            this.mScaleMode = i2;
            baseKernelLayer.setVideoScalingMode(i2);
        }
    }

    @PublicMethod
    public void setVideoUniqueKey(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048701, this, str) == null) {
            this.mKey = str;
        }
    }

    @Override // com.baidu.searchbox.player.IBVideoPlayer
    @PublicMethod
    public void setVideoUrl(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048702, this, str) == null) {
            setVideoUrl(str, true);
        }
    }

    @PublicMethod
    public void setupKernelLayer(@Nullable BaseKernelLayer baseKernelLayer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048704, this, baseKernelLayer) == null) {
            getStatDispatcher().startInitPlayerKernel();
            if (baseKernelLayer != null) {
                attachKernelLayer(baseKernelLayer);
            }
            getStatDispatcher().endInitPlayerKernel();
        }
    }

    public abstract void setupLayers(@NonNull Context context);

    public void setupPlayer(@NonNull Context context, @Nullable BaseKernelLayer baseKernelLayer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048706, this, context, baseKernelLayer) == null) {
            setupTrigger();
            setupKernelLayer(baseKernelLayer);
            setupLayers(context);
            setupPlugin(context);
        }
    }

    public void setupPlugin(@NonNull Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048707, this, context) == null) {
        }
    }

    public void setupTrigger() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048708, this) == null) {
            getStatEventTrigger().setMessenger(this.mMessenger);
            getPlayerEventTrigger().setMessenger(this.mMessenger);
            getControlEventTrigger().setMessenger(this.mMessenger);
            getInternalSyncControlEventTrigger().setMessenger(this.mMessenger);
        }
    }

    @Override // com.baidu.searchbox.player.IBVideoPlayer
    @PublicMethod
    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048709, this) == null) {
            BdVideoLog.i(wrapMessage("start()"));
            doPlay();
        }
    }

    @Override // com.baidu.searchbox.player.IBVideoPlayer
    @PublicMethod
    public void stop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048710, this) == null) {
            BdVideoLog.i(wrapMessage("stop()"));
            if (this.mKernelLayer == null) {
                return;
            }
            abandonAudioFocus();
            getStatDispatcher().stop(getLoopCount());
            getStatEventTrigger().onPlayerStop(getLoopCount());
            getControlEventTrigger().stop();
            getInternalSyncControlEventTrigger().stop();
            VideoSystemHelper.setKeepScreenOnOff(getActivity(), false);
        }
    }

    @PublicMethod(version = "12.0.0.0")
    public void switchMediaSource(int i2) {
        BaseKernelLayer baseKernelLayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048711, this, i2) == null) || (baseKernelLayer = this.mKernelLayer) == null) {
            return;
        }
        baseKernelLayer.switchMediaSource(i2);
    }

    @PublicMethod
    public void syncStatus(@NonNull PlayerStatus playerStatus) {
        BaseKernelLayer baseKernelLayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048712, this, playerStatus) == null) || (baseKernelLayer = this.mKernelLayer) == null) {
            return;
        }
        baseKernelLayer.getVideoSession().statusChangeNotify(playerStatus);
    }

    @PublicMethod(version = "11.23.0.0")
    public void updateFreeProxy(@Nullable String str) {
        BaseKernelLayer baseKernelLayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048713, this, str) == null) || (baseKernelLayer = this.mKernelLayer) == null) {
            return;
        }
        baseKernelLayer.updateFreeProxy(str);
    }

    @PublicMethod
    public void updateStatisticsContent(@NonNull Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048714, this, obj) == null) {
            VideoEvent obtainEvent = StatisticsEvent.obtainEvent(StatisticsEvent.ACTION_UPDATE_CONTENT);
            obtainEvent.putExtra(13, obj);
            getStatEventTrigger().triggerEvent(obtainEvent);
        }
    }

    public String wrapMessage(@NonNull String str) {
        InterceptResult invokeL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048715, this, str)) == null) {
            StringBuilder sb = new StringBuilder();
            if (TextUtils.isEmpty(this.mKey)) {
                str2 = "Player@" + System.identityHashCode(this);
            } else {
                str2 = this.mKey;
            }
            sb.append(str2);
            sb.append("=>");
            sb.append(str);
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BDVideoPlayer(@Nullable Context context, @Nullable BaseKernelLayer baseKernelLayer) {
        this(context, baseKernelLayer, "", "");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, baseKernelLayer};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (BaseKernelLayer) objArr2[1], (String) objArr2[2], (String) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    @PublicMethod
    public void addInterceptor(int i2, @NonNull IVideoEventInterceptor iVideoEventInterceptor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, iVideoEventInterceptor) == null) {
            this.mMessenger.addInterceptor(i2, iVideoEventInterceptor);
        }
    }

    @PublicMethod
    public void addLayer(@NonNull AbsLayer absLayer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, absLayer) == null) {
            this.mLayerContainer.addLayer(absLayer);
        }
    }

    @PublicMethod
    public void attachToContainer(@NonNull ViewGroup viewGroup, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048585, this, viewGroup, z) == null) {
            detachFromContainer(z);
            BdVideoLog.i(wrapMessage("attachToContainer(" + System.identityHashCode(viewGroup) + StringUtil.ARRAY_ELEMENT_SEPARATOR + z + SmallTailInfo.EMOTION_SUFFIX));
            this.mPlayerContainer = viewGroup;
            viewGroup.addView(this.mLayerContainer, this.mContainerLayoutParams);
            getPlayerEventTrigger().onPlayerAttach();
        }
    }

    @PublicMethod
    public void detachFromContainer(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048588, this, z) == null) && (this.mLayerContainer.getParent() instanceof ViewGroup)) {
            ViewGroup viewGroup = (ViewGroup) this.mLayerContainer.getParent();
            viewGroup.removeView(this.mLayerContainer);
            BdVideoLog.i(wrapMessage("detachFromContainer(" + z + "), parent = " + System.identityHashCode(viewGroup)));
            if (z) {
                this.mLayerContainer.onContainerDetach();
                getPlayerEventTrigger().onPlayerDetach();
            }
            this.mPlayerContainer = null;
        }
    }

    public boolean detachKLayerToCache(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
            boolean detachCache = getReuseHelper().detachCache(this, str);
            if (detachCache) {
                setUseCache(false);
            }
            return detachCache;
        }
        return invokeL.booleanValue;
    }

    @PublicMethod
    public void pause(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048658, this, i2) == null) {
            BdVideoLog.i(wrapMessage("pause(" + i2 + SmallTailInfo.EMOTION_SUFFIX));
            if (this.mKernelLayer == null) {
                return;
            }
            abandonAudioFocus();
            getControlEventTrigger().pause(i2);
            getInternalSyncControlEventTrigger().pause();
            getStatDispatcher().pause();
            getStatEventTrigger().onPlayerPause();
        }
    }

    @PublicMethod
    public void setVideoUrl(@NonNull String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048703, this, str, z) == null) {
            BdVideoLog.i(wrapMessage("setVideoUrl = " + str));
            this.mVideoTask.videoUrl = str;
            createSessionId(z);
            getPlayerEventTrigger().setDataSource(this.mVideoTask.videoUrl, z, getPlayerStageType());
        }
    }

    public BDVideoPlayer(@Nullable Context context, @Nullable BaseKernelLayer baseKernelLayer, @NonNull String str, @Nullable String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, baseKernelLayer, str, str2};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.mIsForeground = false;
        this.mStatEventTrigger = new StatisticsEventTrigger();
        this.mPlayerEventTrigger = new PlayerEventTrigger();
        this.mControlEventTrigger = new ControlEventTrigger();
        this.mSyncControlEventTrigger = new InternalSyncControlEventTrigger();
        this.mIsMute = false;
        this.mSpeed = 1.0f;
        this.mVideoLoopCount = 0;
        this.isUseCache = false;
        this.mScaleMode = 2;
        this.mKey = str;
        this.mKLayerCacheKey = str2;
        BdVideoLog.i(wrapMessage("BDVideoPlayer(" + context + ",  kernelLayer@" + System.identityHashCode(baseKernelLayer) + ", key@" + this.mKey + SmallTailInfo.EMOTION_SUFFIX));
        getStatDispatcher().startInitPlayer();
        context = context == null ? getAppContext() : context;
        createEnv(context);
        initPlayer();
        setupPlayer(context, baseKernelLayer);
        getStatDispatcher().endInitPlayer();
    }
}
