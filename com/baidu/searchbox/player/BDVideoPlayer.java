package com.baidu.searchbox.player;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.player.annotation.PublicMethod;
import com.baidu.searchbox.player.callback.IVideoPlayerCallback;
import com.baidu.searchbox.player.callback.VideoPlayerCallbackBaseManager;
import com.baidu.searchbox.player.constants.PlayerStatus;
import com.baidu.searchbox.player.event.PlayerEventTrigger;
import com.baidu.searchbox.player.event.StatisticsEventTrigger;
import com.baidu.searchbox.player.event.VideoEvent;
import com.baidu.searchbox.player.helper.VideoSystemHelper;
import com.baidu.searchbox.player.kernel.IKernelPlayer;
import com.baidu.searchbox.player.layer.AbsLayer;
import com.baidu.searchbox.player.layer.BaseKernelLayer;
import com.baidu.searchbox.player.layer.LayerContainer;
import com.baidu.searchbox.player.model.VideoTask;
import com.baidu.searchbox.player.plugin.AbsPlugin;
import com.baidu.searchbox.player.plugin.PluginManager;
import com.baidu.searchbox.player.session.VideoKernelState;
import com.baidu.searchbox.player.session.VideoSession;
import com.baidu.searchbox.player.session.VideoSessionManager;
import com.baidu.searchbox.player.ubc.IPlayerStatisticsDispatcher;
import com.baidu.searchbox.player.ubc.SimpleVideoStatisticsDispatcher;
import com.baidu.searchbox.player.utils.BdVideoLog;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import org.webrtc.MediaStreamTrack;
/* loaded from: classes5.dex */
public abstract class BDVideoPlayer implements IBVideoPlayer, IKernelPlayer {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "BDVideoPlayer";
    public static boolean sGlobalMute;
    public transient /* synthetic */ FieldHolder $fh;
    public AudioFocusChangedListener mAudioFocusListener;
    public AudioManager mAudioManager;
    public VideoPlayerCallbackBaseManager mCallbackManager;
    public ViewGroup.LayoutParams mContainerLayoutParams;
    public boolean mHasAudioFocus;
    public boolean mIsForeground;
    public boolean mIsMute;
    @Nullable
    public BaseKernelLayer mKernelLayer;
    @NonNull
    public String mKey;
    public LayerContainer mLayerContainer;
    public ViewGroup mPlayerContainer;
    public PluginManager mPluginManager;
    public StatisticsEventTrigger mStatEventTrigger;
    public int mVideoLoopCount;
    public VideoSession mVideoSession;
    public VideoTask mVideoTask;

    /* loaded from: classes5.dex */
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
        this(context, new BaseKernelLayer("NormalVideoKernel"));
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

    private void bindSession() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            bindSession(requireVideoSession());
        }
    }

    private void createEnv(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, context) == null) {
            this.mContainerLayoutParams = new ViewGroup.LayoutParams(-1, -1);
            this.mVideoTask = new VideoTask();
            this.mPluginManager = new PluginManager(this);
            LayerContainer layerContainer = new LayerContainer(context);
            this.mLayerContainer = layerContainer;
            layerContainer.bindPlayer(this);
            this.mLayerContainer.setClickable(true);
            initCallBackManager();
        }
    }

    @PublicMethod
    public static boolean isGlobalMute() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? sGlobalMute : invokeV.booleanValue;
    }

    private void setupPlayer(@Nullable Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, this, context) == null) {
            setupPlayer(context, new BaseKernelLayer("NormalVideoKernel"));
        }
    }

    public void abandonAudioFocus() {
        AudioFocusChangedListener audioFocusChangedListener;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            AudioManager audioManager = this.mAudioManager;
            if (audioManager != null && (audioFocusChangedListener = this.mAudioFocusListener) != null) {
                audioManager.abandonAudioFocus(audioFocusChangedListener);
                this.mAudioManager = null;
                this.mAudioFocusListener = null;
            }
            this.mHasAudioFocus = false;
            BdVideoLog.d(TAG, "video player abandonAudioFocus");
        }
    }

    @PublicMethod
    public void addLayer(@NonNull AbsLayer absLayer, FrameLayout.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, absLayer, layoutParams) == null) {
            absLayer.injectMessenger(this.mVideoSession.getMessenger());
            this.mLayerContainer.addLayer(absLayer, layoutParams);
        }
    }

    @PublicMethod
    public void addPlugin(@NonNull AbsPlugin absPlugin) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, absPlugin) == null) {
            absPlugin.attachMessenger(this.mVideoSession.getMessenger());
            this.mPluginManager.addPlugin(absPlugin);
        }
    }

    @PublicMethod
    public void attachKernelLayer(@NonNull BaseKernelLayer baseKernelLayer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, baseKernelLayer) == null) {
            detachKernelLayer();
            this.mKernelLayer = baseKernelLayer;
            baseKernelLayer.setKernelCallBack(this);
            this.mKernelLayer.setVideoSession(this.mVideoSession);
            this.mKernelLayer.injectMessenger(this.mVideoSession.getMessenger());
            this.mLayerContainer.attachKernelLayer(baseKernelLayer);
        }
    }

    @PublicMethod
    public void attachToContainer(@NonNull ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, viewGroup) == null) {
            attachToContainer(viewGroup, true);
        }
    }

    @PublicMethod
    public void detachFromContainer() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            detachFromContainer(true);
        }
    }

    @Nullable
    @PublicMethod
    public BaseKernelLayer detachKernelLayer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            BaseKernelLayer baseKernelLayer = this.mKernelLayer;
            if (baseKernelLayer != null) {
                this.mVideoSession.unregisterLayer(baseKernelLayer);
                this.mLayerContainer.detachLayer(this.mKernelLayer);
                this.mKernelLayer = null;
                return baseKernelLayer;
            }
            return null;
        }
        return (BaseKernelLayer) invokeV.objValue;
    }

    @PublicMethod
    public void doPlay() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || this.mKernelLayer == null || this.mVideoSession.getStatus() == PlayerStatus.PAUSE) {
            return;
        }
        if (this.mKernelLayer.getContentView() != null) {
            this.mKernelLayer.getContentView().setVisibility(0);
        }
        String str = this.mVideoTask.videoUrl;
        if (!isPlayerMute()) {
            requestAudioFocus();
        }
        VideoSystemHelper.setKeepScreenOnOff(getActivity(), true);
        this.mVideoSession.getControlEventTrigger().start();
        this.mKernelLayer.play(str);
        getStatDispatcher().start();
        getStatEventTrigger().onPlayerStart();
    }

    @Nullable
    @PublicMethod
    public Activity getActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? BDPlayerConfig.getAppContext() : (Context) invokeV.objValue;
    }

    @PublicMethod
    public ViewGroup getAttachedContainer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.mPlayerContainer : (ViewGroup) invokeV.objValue;
    }

    @PublicMethod
    public int getBufferingPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            BaseKernelLayer baseKernelLayer = this.mKernelLayer;
            if (baseKernelLayer == null) {
                return 0;
            }
            return baseKernelLayer.getBufferingPosition();
        }
        return invokeV.intValue;
    }

    @PublicMethod
    public int getDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            BaseKernelLayer baseKernelLayer = this.mKernelLayer;
            if (baseKernelLayer == null) {
                return 0;
            }
            return baseKernelLayer.getDuration();
        }
        return invokeV.intValue;
    }

    @PublicMethod
    public int getDurationMs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            BaseKernelLayer baseKernelLayer = this.mKernelLayer;
            if (baseKernelLayer == null) {
                return 0;
            }
            return baseKernelLayer.getDurationMs();
        }
        return invokeV.intValue;
    }

    @NonNull
    @PublicMethod
    public LayerContainer getLayerContainer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.mLayerContainer : (LayerContainer) invokeV.objValue;
    }

    @PublicMethod
    public int getLoopCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.mVideoLoopCount : invokeV.intValue;
    }

    @NonNull
    @PublicMethod
    public VideoPlayerCallbackBaseManager getPlayerCallbackManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.mCallbackManager : (VideoPlayerCallbackBaseManager) invokeV.objValue;
    }

    public PlayerEventTrigger getPlayerEventTrigger() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.mVideoSession.getPlayerEventTrigger() : (PlayerEventTrigger) invokeV.objValue;
    }

    @Nullable
    @PublicMethod
    public BaseKernelLayer getPlayerKernelLayer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.mKernelLayer : (BaseKernelLayer) invokeV.objValue;
    }

    @PublicMethod
    public int getPlayerStageType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return -1;
        }
        return invokeV.intValue;
    }

    @PublicMethod
    public int getPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            BaseKernelLayer baseKernelLayer = this.mKernelLayer;
            if (baseKernelLayer == null) {
                return 0;
            }
            return baseKernelLayer.getPositionMs();
        }
        return invokeV.intValue;
    }

    @Nullable
    @PublicMethod
    public String getServerIpInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            BaseKernelLayer baseKernelLayer = this.mKernelLayer;
            if (baseKernelLayer != null) {
                return baseKernelLayer.getServerIpInfo();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    @PublicMethod
    public IPlayerStatisticsDispatcher getStatDispatcher() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? SimpleVideoStatisticsDispatcher.EMPTY : (IPlayerStatisticsDispatcher) invokeV.objValue;
    }

    @NonNull
    @PublicMethod(version = "11.24.0.0")
    public StatisticsEventTrigger getStatEventTrigger() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.mStatEventTrigger : (StatisticsEventTrigger) invokeV.objValue;
    }

    @PublicMethod
    public int getSyncPositionMs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            BaseKernelLayer baseKernelLayer = this.mKernelLayer;
            if (baseKernelLayer != null) {
                return baseKernelLayer.getVideoHeight();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @PublicMethod
    public VideoSession getVideoSession() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.mVideoSession : (VideoSession) invokeV.objValue;
    }

    @PublicMethod
    public VideoTask getVideoTask() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.mVideoTask : (VideoTask) invokeV.objValue;
    }

    @NonNull
    @PublicMethod
    public String getVideoUniqueKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.mKey : (String) invokeV.objValue;
    }

    @PublicMethod
    public String getVideoUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            BaseKernelLayer baseKernelLayer = this.mKernelLayer;
            return baseKernelLayer == null ? "" : baseKernelLayer.getVideoUrl();
        }
        return (String) invokeV.objValue;
    }

    @PublicMethod(version = "11.24.0.0")
    public int getVideoWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
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
        if (interceptable == null || interceptable.invokeZ(1048611, this, z) == null) {
            this.mIsForeground = z;
            getStatDispatcher().goBackOrForeground(z, getLoopCount());
            VideoSystemHelper.setKeepScreenOnOff(getActivity(), z);
            this.mVideoSession.getControlEventTrigger().goBackOrForeground(z);
            getPlayerCallbackManager().onGoBackOrForeground(z);
        }
    }

    public void initCallBackManager() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            this.mCallbackManager = new VideoPlayerCallbackBaseManager();
        }
    }

    public void initPlayer() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
        }
    }

    @PublicMethod
    public void insertLayer(@NonNull AbsLayer absLayer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, absLayer) == null) {
            absLayer.injectMessenger(this.mVideoSession.getMessenger());
            this.mLayerContainer.insertLayer(absLayer, (FrameLayout.LayoutParams) null);
        }
    }

    @PublicMethod
    public boolean isAttachToContainer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? this.mLayerContainer.getParent() != null : invokeV.booleanValue;
    }

    @PublicMethod
    public boolean isComplete() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? this.mVideoSession.isComplete() : invokeV.booleanValue;
    }

    @PublicMethod
    public boolean isError() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) ? this.mVideoSession.isError() : invokeV.booleanValue;
    }

    @PublicMethod
    public boolean isForeground() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) ? this.mIsForeground : invokeV.booleanValue;
    }

    @PublicMethod
    public boolean isHasAudioFocus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) ? this.mHasAudioFocus : invokeV.booleanValue;
    }

    @PublicMethod
    public boolean isMute() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) ? this.mIsMute : invokeV.booleanValue;
    }

    @PublicMethod
    public boolean isPause() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) ? this.mVideoSession.isPause() : invokeV.booleanValue;
    }

    @PublicMethod
    public boolean isPlayerMute() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) ? isGlobalMute() : invokeV.booleanValue;
    }

    @Override // com.baidu.searchbox.player.IBVideoPlayer
    @PublicMethod
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) ? this.mVideoSession.isPlaying() : invokeV.booleanValue;
    }

    @PublicMethod
    public boolean isPrepared() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) ? this.mVideoSession.isPrepared() : invokeV.booleanValue;
    }

    @PublicMethod
    public boolean isPreparing() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) ? this.mVideoSession.isPreparing() : invokeV.booleanValue;
    }

    @PublicMethod
    public boolean isStop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) ? this.mVideoSession.isStop() : invokeV.booleanValue;
    }

    @Override // com.baidu.searchbox.player.IBVideoPlayer
    @PublicMethod
    public void mute(boolean z) {
        BaseKernelLayer baseKernelLayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048627, this, z) == null) || (baseKernelLayer = this.mKernelLayer) == null) {
            return;
        }
        baseKernelLayer.mute(z);
    }

    public void onAudioFocusChanged(int i2) {
        Activity activity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048628, this, i2) == null) || (activity = getActivity()) == null || isPlayerMute()) {
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
                        this.this$0.pauseInternal(2);
                        this.this$0.abandonAudioFocus();
                    }
                }
            }
        });
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnBufferingUpdateListener
    public void onBufferingUpdate(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048629, this, i2) == null) {
        }
    }

    public void onCompletion() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048630, this) == null) {
            abandonAudioFocus();
            getPlayerEventTrigger().onCompletion();
            getStatDispatcher().end(getLoopCount());
            getStatEventTrigger().onPlayerComplete(getLoopCount());
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
    public boolean onError(int i2, int i3, Object obj) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048631, this, i2, i3, obj)) == null) {
            getPlayerEventTrigger().onError(i2, i3, obj);
            getStatDispatcher().onError(i2, i3, obj);
            getStatEventTrigger().onError(i2, i3, obj);
            VideoSystemHelper.setKeepScreenOnOff(getActivity(), false);
            return true;
        }
        return invokeIIL.booleanValue;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
    public boolean onInfo(int i2, int i3, Object obj) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048632, this, i2, i3, obj)) == null) {
            getPlayerEventTrigger().onInfo(i2, i3, obj);
            getStatDispatcher().onInfo(i2, i3, obj != null ? obj.toString() : "");
            getStatEventTrigger().onInfo(i2, i3, obj);
            return false;
        }
        return invokeIIL.booleanValue;
    }

    public void onPrepared() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048633, this) == null) {
            getPlayerEventTrigger().onPrepared();
        }
    }

    public void onSeekComplete() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048634, this) == null) {
            getPlayerEventTrigger().onSeekComplete();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnVideoSizeChangedListener
    public void onVideoSizeChanged(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048635, this, i2, i3, i4, i5) == null) {
            getPlayerEventTrigger().onVideoSizeChanged(i2, i3, i4, i5);
        }
    }

    @Override // com.baidu.searchbox.player.IBVideoPlayer
    @PublicMethod
    public void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048636, this) == null) {
            pauseInternal(0);
        }
    }

    public void pauseInternal(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048637, this, i2) == null) || this.mKernelLayer == null) {
            return;
        }
        abandonAudioFocus();
        this.mVideoSession.getControlEventTrigger().pause(i2);
        this.mKernelLayer.pause();
        getStatDispatcher().pause();
    }

    @Override // com.baidu.searchbox.player.IBVideoPlayer
    @PublicMethod
    public void play(String str) {
        BaseKernelLayer baseKernelLayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048639, this, str) == null) || (baseKernelLayer = this.mKernelLayer) == null) {
            return;
        }
        baseKernelLayer.play(str);
    }

    @Override // com.baidu.searchbox.player.IBVideoPlayer
    @PublicMethod
    public void prepare() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048640, this) == null) || this.mKernelLayer == null) {
            return;
        }
        this.mVideoSession.getControlEventTrigger().prepare();
        this.mKernelLayer.prepare();
    }

    @PublicMethod
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048641, this) == null) {
            BdVideoLog.d("release player : " + this);
            getStatDispatcher().stop(getLoopCount());
            getStatEventTrigger().onPlayerStop(getLoopCount());
            getStatDispatcher().release();
            BaseKernelLayer baseKernelLayer = this.mKernelLayer;
            if (baseKernelLayer != null) {
                baseKernelLayer.pause();
                this.mKernelLayer.stop();
                this.mKernelLayer.release();
            }
            VideoSystemHelper.setKeepScreenOnOff(getActivity(), false);
            getPlayerCallbackManager().release();
            abandonAudioFocus();
            this.mPluginManager.release();
            this.mLayerContainer.release();
            detachFromContainer(false);
            getStatEventTrigger().release();
            unbindSession();
            this.mPlayerContainer = null;
        }
    }

    @PublicMethod
    public void removePlugin(@NonNull AbsPlugin absPlugin) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048642, this, absPlugin) == null) {
            absPlugin.detachMessenger();
            this.mPluginManager.removePlugin(absPlugin);
        }
    }

    @PublicMethod
    public void replaceVideoHolder(@NonNull ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048643, this, viewGroup) == null) {
            this.mPlayerContainer = viewGroup;
        }
    }

    public void requestAudioFocus() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048644, this) == null) || this.mHasAudioFocus) {
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
            BdVideoLog.d(TAG, "video player requestAudioFocus");
        }
    }

    public VideoSession requireVideoSession() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048645, this)) == null) ? VideoSessionManager.getInstance().getVideoSession() : (VideoSession) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.player.IBVideoPlayer
    @PublicMethod
    public void resume() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048646, this) == null) || this.mKernelLayer == null) {
            return;
        }
        if (this.mVideoSession.getStatus() == PlayerStatus.PAUSE || this.mVideoSession.getStatus() == PlayerStatus.PREPARED || this.mVideoSession.getStatus() == PlayerStatus.PREPARING) {
            if (!isPlayerMute()) {
                requestAudioFocus();
            }
            this.mVideoSession.getControlEventTrigger().resume();
            this.mKernelLayer.resume();
            getStatDispatcher().resume();
        }
    }

    public void resumeFromError() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048647, this) == null) {
            BaseKernelLayer baseKernelLayer = this.mKernelLayer;
            if (baseKernelLayer != null) {
                baseKernelLayer.stopPlayback();
            }
            setVideoUrl(this.mVideoTask.videoUrl);
            resumePlayer(false);
        }
    }

    @PublicMethod
    public void resumePlayer(boolean z) {
        BaseKernelLayer baseKernelLayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048648, this, z) == null) || (baseKernelLayer = this.mKernelLayer) == null) {
            return;
        }
        if (z) {
            VideoTask videoTask = this.mVideoTask;
            videoTask.position = 0;
            videoTask.duration = 0;
        } else {
            this.mVideoTask.position = baseKernelLayer.getPosition();
            this.mVideoTask.duration = this.mKernelLayer.getDuration();
        }
        if (this.mVideoSession.getStatus() == PlayerStatus.PAUSE) {
            resume();
        } else {
            start();
        }
    }

    @Override // com.baidu.searchbox.player.IBVideoPlayer
    @PublicMethod
    public void seekTo(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048649, this, i2) == null) || this.mKernelLayer == null) {
            return;
        }
        this.mVideoSession.getControlEventTrigger().seekTo(i2);
    }

    @PublicMethod
    public void seekToMs(int i2) {
        BaseKernelLayer baseKernelLayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048650, this, i2) == null) || (baseKernelLayer = this.mKernelLayer) == null) {
            return;
        }
        baseKernelLayer.seekToMs(i2);
    }

    @PublicMethod
    public void sendEvent(@NonNull VideoEvent videoEvent) {
        VideoSession videoSession;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048651, this, videoEvent) == null) || (videoSession = this.mVideoSession) == null) {
            return;
        }
        videoSession.sendEvent(videoEvent);
    }

    @PublicMethod(version = "11.24.0.0")
    public void setExternalInfo(String str, Object obj) {
        BaseKernelLayer baseKernelLayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048652, this, str, obj) == null) || (baseKernelLayer = this.mKernelLayer) == null) {
            return;
        }
        baseKernelLayer.setExternalInfo(str, obj);
    }

    @PublicMethod
    public void setGlobalMuteMode(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048653, this, z) == null) {
            sGlobalMute = z;
            setMuteMode(z);
        }
    }

    @PublicMethod
    public void setHasReplaceUrl(boolean z) {
        BaseKernelLayer baseKernelLayer;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048654, this, z) == null) && z && (baseKernelLayer = this.mKernelLayer) != null) {
            baseKernelLayer.updateFreeProxy(null);
        }
    }

    @PublicMethod
    public void setHttpHeader(HashMap<String, String> hashMap) {
        BaseKernelLayer baseKernelLayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048655, this, hashMap) == null) || (baseKernelLayer = this.mKernelLayer) == null) {
            return;
        }
        baseKernelLayer.setHttpHeader(hashMap);
    }

    @PublicMethod
    public void setLooping(boolean z) {
        BaseKernelLayer baseKernelLayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048656, this, z) == null) || (baseKernelLayer = this.mKernelLayer) == null) {
            return;
        }
        baseKernelLayer.setLooping(z);
    }

    @PublicMethod
    public void setMuteMode(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048657, this, z) == null) {
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
        if (!(interceptable == null || interceptable.invokeLL(1048658, this, str, str2) == null) || (baseKernelLayer = this.mKernelLayer) == null) {
            return;
        }
        baseKernelLayer.setOption(str, str2);
    }

    @Override // com.baidu.searchbox.player.IBVideoPlayer
    @PublicMethod
    public void setParameter(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048659, this, str, i2) == null) {
        }
    }

    @PublicMethod
    public void setPlayerListener(IVideoPlayerCallback iVideoPlayerCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048660, this, iVideoPlayerCallback) == null) {
            getPlayerCallbackManager().setVideoPlayerCallback(iVideoPlayerCallback);
        }
    }

    @PublicMethod
    public void setProxy(@Nullable String str) {
        BaseKernelLayer baseKernelLayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048661, this, str) == null) || (baseKernelLayer = this.mKernelLayer) == null) {
            return;
        }
        baseKernelLayer.setProxy(str);
    }

    @PublicMethod
    public void setSpeed(float f2) {
        BaseKernelLayer baseKernelLayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048662, this, f2) == null) || (baseKernelLayer = this.mKernelLayer) == null) {
            return;
        }
        baseKernelLayer.setSpeed(f2);
    }

    public void setStageInfo(String str, String str2, String str3) {
        String str4;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048663, this, str, str2, str3) == null) || this.mKernelLayer == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(CyberPlayerManager.STAGE_INFO_TYPE, str);
        hashMap.put(CyberPlayerManager.STAGE_INFO_SOURCE, str2);
        hashMap.put(CyberPlayerManager.STAGE_INFO_TITLE, str3);
        this.mKernelLayer.setExternalInfo(CyberPlayerManager.STR_STAGE_INFO, hashMap);
        if (getPlayerStageType() != 1) {
            if ((getPlayerStageType() != 22) & (getPlayerStageType() != 6)) {
                str4 = "0";
                this.mKernelLayer.setOption(CyberPlayerManager.OPT_FEED_VIDEO, str4);
            }
        }
        str4 = "1";
        this.mKernelLayer.setOption(CyberPlayerManager.OPT_FEED_VIDEO, str4);
    }

    @Override // com.baidu.searchbox.player.IBVideoPlayer
    @PublicMethod
    public void setUserAgent(String str) {
        BaseKernelLayer baseKernelLayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048664, this, str) == null) || (baseKernelLayer = this.mKernelLayer) == null) {
            return;
        }
        baseKernelLayer.setUserAgent(str);
    }

    @Override // com.baidu.searchbox.player.IBVideoPlayer
    @PublicMethod
    public void setVideoRotation(int i2) {
        BaseKernelLayer baseKernelLayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048665, this, i2) == null) || (baseKernelLayer = this.mKernelLayer) == null) {
            return;
        }
        baseKernelLayer.setVideoRotation(i2);
    }

    @Override // com.baidu.searchbox.player.IBVideoPlayer
    @PublicMethod
    public void setVideoScalingMode(int i2) {
        BaseKernelLayer baseKernelLayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048666, this, i2) == null) || (baseKernelLayer = this.mKernelLayer) == null) {
            return;
        }
        baseKernelLayer.setVideoScalingMode(i2);
    }

    @PublicMethod
    public void setVideoUniqueKey(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048667, this, str) == null) {
            this.mKey = str;
        }
    }

    @Override // com.baidu.searchbox.player.IBVideoPlayer
    @PublicMethod
    public void setVideoUrl(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048668, this, str) == null) {
            setVideoUrl(str, true);
        }
    }

    @PublicMethod
    public void setupKernel(@Nullable BaseKernelLayer baseKernelLayer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048670, this, baseKernelLayer) == null) {
            getStatDispatcher().startInitPlayerKernel();
            if (baseKernelLayer != null) {
                attachKernelLayer(baseKernelLayer);
            }
            getStatDispatcher().endInitPlayerKernel();
        }
    }

    public abstract void setupLayers(@NonNull Context context);

    public void setupPlugin(@NonNull Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048673, this, context) == null) {
        }
    }

    @Override // com.baidu.searchbox.player.IBVideoPlayer
    @PublicMethod
    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048674, this) == null) {
            doPlay();
        }
    }

    @Override // com.baidu.searchbox.player.IBVideoPlayer
    @PublicMethod
    public void stop() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048675, this) == null) || this.mKernelLayer == null) {
            return;
        }
        abandonAudioFocus();
        getStatDispatcher().stop(getLoopCount());
        this.mVideoSession.getControlEventTrigger().stop();
        getStatEventTrigger().onPlayerStop(getLoopCount());
        this.mKernelLayer.stop();
        VideoSystemHelper.setKeepScreenOnOff(getActivity(), false);
    }

    @PublicMethod
    public void syncSession(@NonNull VideoSession videoSession) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048676, this, videoSession) == null) {
            this.mVideoSession.syncSession(videoSession);
        }
    }

    @PublicMethod
    public void syncState(@NonNull BDVideoPlayer bDVideoPlayer) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048677, this, bDVideoPlayer) == null) || this.mVideoSession == null || bDVideoPlayer.getVideoSession() == null) {
            return;
        }
        this.mVideoSession.getState().stateChangeNotify(bDVideoPlayer.getVideoSession().getStatus());
    }

    public void unbindSession() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048679, this) == null) || this.mVideoSession == null) {
            return;
        }
        VideoSessionManager.getInstance().recycle(this.mVideoSession);
    }

    @PublicMethod(version = "11.23.0.0")
    public void updateFreeProxy(@Nullable String str) {
        BaseKernelLayer baseKernelLayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048680, this, str) == null) || (baseKernelLayer = this.mKernelLayer) == null) {
            return;
        }
        baseKernelLayer.updateFreeProxy(str);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BDVideoPlayer(@Nullable Context context, @Nullable BaseKernelLayer baseKernelLayer) {
        this(context, baseKernelLayer, "");
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
                this((Context) objArr2[0], (BaseKernelLayer) objArr2[1], (String) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    private void bindSession(@NonNull VideoSession videoSession) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, videoSession) == null) {
            this.mVideoSession = videoSession;
            videoSession.bind(this);
        }
    }

    @PublicMethod
    public void attachToContainer(@NonNull ViewGroup viewGroup, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048582, this, viewGroup, z) == null) {
            detachFromContainer(z);
            this.mPlayerContainer = viewGroup;
            viewGroup.addView(this.mLayerContainer, this.mContainerLayoutParams);
            getPlayerEventTrigger().onPlayerAttach();
        }
    }

    @PublicMethod
    public void detachFromContainer(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) && (this.mLayerContainer.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.mLayerContainer.getParent()).removeView(this.mLayerContainer);
            if (z) {
                this.mLayerContainer.onContainerDetach();
                getPlayerEventTrigger().onPlayerDetach();
            }
            this.mPlayerContainer = null;
        }
    }

    @PublicMethod
    public void setVideoUrl(@NonNull String str, boolean z) {
        BaseKernelLayer baseKernelLayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048669, this, str, z) == null) || (baseKernelLayer = this.mKernelLayer) == null) {
            return;
        }
        this.mVideoTask.videoUrl = str;
        if (z) {
            baseKernelLayer.setVideoUrl(str);
        }
    }

    public void setupPlayer(Context context, @Nullable BaseKernelLayer baseKernelLayer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048672, this, context, baseKernelLayer) == null) {
            bindSession();
            getStatEventTrigger().setMessenger(this.mVideoSession.getMessenger());
            setupKernel(baseKernelLayer);
            setupLayers(context);
            setupPlugin(context);
        }
    }

    public BDVideoPlayer(@Nullable Context context, @Nullable BaseKernelLayer baseKernelLayer, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, baseKernelLayer, str};
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
        this.mKey = "";
        this.mIsMute = false;
        this.mVideoLoopCount = 0;
        this.mKey = str;
        getStatDispatcher().startInitPlayer();
        context = context == null ? getAppContext() : context;
        createEnv(context);
        initPlayer();
        setupPlayer(context, baseKernelLayer);
        getStatDispatcher().endInitPlayer();
    }

    @PublicMethod
    public void addLayer(@NonNull AbsLayer absLayer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, absLayer) == null) {
            absLayer.injectMessenger(this.mVideoSession.getMessenger());
            this.mLayerContainer.addLayer(absLayer);
        }
    }

    @PublicMethod
    public void syncState(@NonNull VideoKernelState videoKernelState) {
        VideoSession videoSession;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048678, this, videoKernelState) == null) || (videoSession = this.mVideoSession) == null) {
            return;
        }
        videoSession.getState().stateChangeNotify(videoKernelState.getStatus());
    }

    @PublicMethod
    public void pauseInternal(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048638, this, z) == null) || this.mKernelLayer == null) {
            return;
        }
        abandonAudioFocus();
        this.mVideoSession.getControlEventTrigger().pause(z);
        this.mKernelLayer.pause();
        getStatDispatcher().pause();
    }
}
