package com.baidu.searchbox.player.layer;

import android.text.TextUtils;
import android.view.Surface;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.player.annotation.PublicMethod;
import com.baidu.searchbox.player.constants.PlayerStatus;
import com.baidu.searchbox.player.event.ControlEvent;
import com.baidu.searchbox.player.event.InteractiveEvent;
import com.baidu.searchbox.player.event.InternalSyncControlEvent;
import com.baidu.searchbox.player.event.LayerEvent;
import com.baidu.searchbox.player.event.PlayerEvent;
import com.baidu.searchbox.player.event.SystemEvent;
import com.baidu.searchbox.player.event.VideoEvent;
import com.baidu.searchbox.player.interfaces.IKernelGestureDetector;
import com.baidu.searchbox.player.interfaces.InternalEventDispatcher;
import com.baidu.searchbox.player.interfaces.OnSnapShotFrameListener;
import com.baidu.searchbox.player.kernel.AbsVideoKernel;
import com.baidu.searchbox.player.kernel.EmptyKernel;
import com.baidu.searchbox.player.kernel.IKernelPlayer;
import com.baidu.searchbox.player.message.IMessenger;
import com.baidu.searchbox.player.model.VideoUrlModel;
import com.baidu.searchbox.player.pool.VideoKernelPool;
import com.baidu.searchbox.player.session.VideoSession;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes10.dex */
public class BaseKernelLayer extends AbsLayer {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int MIN_POSITION = 2;
    public static final int SEEK_TO_DELTA = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean mAcceptVolumeChange;
    public InternalEventDispatcher mInternalEventDispatcher;
    public AbsVideoKernel mVideoKernel;

    /* renamed from: com.baidu.searchbox.player.layer.BaseKernelLayer$1  reason: invalid class name */
    /* loaded from: classes10.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes10.dex */
    public class Dispatcher implements InternalEventDispatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BaseKernelLayer this$0;

        public Dispatcher(BaseKernelLayer baseKernelLayer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {baseKernelLayer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = baseKernelLayer;
        }

        @Override // com.baidu.searchbox.player.interfaces.InternalEventDispatcher
        public int getExpectOrder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 1;
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.searchbox.player.interfaces.InternalEventDispatcher
        public void onVideoEventNotify(VideoEvent videoEvent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, videoEvent) == null) {
                this.this$0.getVideoSession().accessEventNotify(videoEvent);
            }
        }

        public /* synthetic */ Dispatcher(BaseKernelLayer baseKernelLayer, AnonymousClass1 anonymousClass1) {
            this(baseKernelLayer);
        }
    }

    public BaseKernelLayer(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mAcceptVolumeChange = true;
        this.mInternalEventDispatcher = new Dispatcher(this, null);
        this.mVideoKernel = VideoKernelPool.getInstance().obtain(str);
        initLayer();
    }

    private void requestAudioFocus() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65538, this) == null) || getBindPlayer().isPlayerMute()) {
            return;
        }
        getBindPlayer().requestAudioFocus();
    }

    @Override // com.baidu.searchbox.player.layer.AbsLayer
    public void attachMessenger(@NonNull IMessenger iMessenger) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, iMessenger) == null) {
            super.attachMessenger(iMessenger);
            iMessenger.addInternalDispatcher(this.mInternalEventDispatcher);
            this.mVideoKernel.bindMessenger(iMessenger);
        }
    }

    public void changePlayUrl(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.mVideoKernel.changePlayUrl(str);
        }
    }

    @Override // com.baidu.searchbox.player.layer.AbsLayer
    public void detachMessenger() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (getMessenger() != null) {
                getMessenger().removeInternalDispatcher(this.mInternalEventDispatcher);
            }
            super.detachMessenger();
            this.mVideoKernel.unbindMessenger();
        }
    }

    @PublicMethod
    public int getBufferingPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mVideoKernel.getBufferingPosition() : invokeV.intValue;
    }

    @Override // com.baidu.searchbox.player.layer.ILayer
    @Nullable
    @PublicMethod
    public View getContentView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mVideoKernel.getBVideoView() : (View) invokeV.objValue;
    }

    @PublicMethod
    public int getDecodeMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mVideoKernel.getDecodeMode() : invokeV.intValue;
    }

    @PublicMethod
    public int getDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mVideoKernel.getDuration() : invokeV.intValue;
    }

    @PublicMethod
    public int getDurationMs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mVideoKernel.getDurationMs() : invokeV.intValue;
    }

    @Nullable
    @PublicMethod(version = "12.5.0.0")
    public IKernelGestureDetector getGestureDetector() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return null;
        }
        return (IKernelGestureDetector) invokeV.objValue;
    }

    @Nullable
    public String getKernelLogId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.mVideoKernel.getKernelLogId() : (String) invokeV.objValue;
    }

    @PublicMethod
    public int getPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.mVideoKernel.getPosition() : invokeV.intValue;
    }

    @PublicMethod
    public int getPositionMs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.mVideoKernel.getPositionMs() : invokeV.intValue;
    }

    @Nullable
    @PublicMethod
    public String getServerIpInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.mVideoKernel.getServerIpInfo() : (String) invokeV.objValue;
    }

    @PublicMethod
    public PlayerStatus getStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.mVideoKernel.getStatus() : (PlayerStatus) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.player.interfaces.INeuron
    @Nullable
    public int[] getSubscribeEvent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? new int[]{4, 3, 1, 2} : (int[]) invokeV.objValue;
    }

    @PublicMethod
    public int getSyncPositionMs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.mVideoKernel.getSyncPositionMs() : invokeV.intValue;
    }

    @PublicMethod
    public int getVideoHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.mVideoKernel.getVideoHeight() : invokeV.intValue;
    }

    @PublicMethod
    public AbsVideoKernel getVideoKernel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.mVideoKernel : (AbsVideoKernel) invokeV.objValue;
    }

    public VideoSession getVideoSession() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.mVideoKernel.getVideoSession() : (VideoSession) invokeV.objValue;
    }

    @PublicMethod
    public String getVideoUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.mVideoKernel.getVideoUrl() : (String) invokeV.objValue;
    }

    @PublicMethod
    public int getVideoWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.mVideoKernel.getVideoWidth() : invokeV.intValue;
    }

    @Override // com.baidu.searchbox.player.layer.AbsLayer, com.baidu.searchbox.player.layer.ILayer
    public void initLayer() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            super.initLayer();
        }
    }

    @PublicMethod
    public void mute(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            this.mVideoKernel.mute(z);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.baidu.searchbox.player.layer.AbsLayer, com.baidu.searchbox.player.interfaces.INeuron
    public void onControlEventNotify(@NonNull VideoEvent videoEvent) {
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, videoEvent) == null) {
            String action = videoEvent.getAction();
            switch (action.hashCode()) {
                case -1929694922:
                    if (action.equals(InternalSyncControlEvent.INTERNAL_ACTION_RESUME)) {
                        c2 = 5;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1106918114:
                    if (action.equals(InternalSyncControlEvent.INTERNAL_ACTION_PREPARE)) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1076076346:
                    if (action.equals(ControlEvent.ACTION_SEEK_MS)) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -502522037:
                    if (action.equals(InternalSyncControlEvent.INTERNAL_ACTION_STOP)) {
                        c2 = 6;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 745698331:
                    if (action.equals(InternalSyncControlEvent.INTERNAL_ACTION_START)) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1547340063:
                    if (action.equals(ControlEvent.ACTION_SEEK)) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1598355405:
                    if (action.equals(InternalSyncControlEvent.INTERNAL_ACTION_PAUSE)) {
                        c2 = 4;
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            switch (c2) {
                case 0:
                    seekToMs(videoEvent.getIntExtra(5) * 1000, videoEvent.getIntExtra(12, 3));
                    return;
                case 1:
                    seekToMs(videoEvent.getIntExtra(5), videoEvent.getIntExtra(12, 3));
                    return;
                case 2:
                    prepare();
                    return;
                case 3:
                    if (getContentView() != null) {
                        getContentView().setVisibility(0);
                    }
                    start();
                    return;
                case 4:
                    pause();
                    return;
                case 5:
                    resume();
                    return;
                case 6:
                    stop();
                    return;
                default:
                    return;
            }
        }
    }

    @Override // com.baidu.searchbox.player.layer.AbsLayer, com.baidu.searchbox.player.interfaces.INeuron
    public void onInteractiveEventNotify(@NonNull VideoEvent videoEvent) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048601, this, videoEvent) == null) && InteractiveEvent.ACTION_INTERACTIVE_ERROR.equals(videoEvent.getAction())) {
            this.mVideoKernel.onError();
        }
    }

    @Override // com.baidu.searchbox.player.layer.AbsLayer, com.baidu.searchbox.player.layer.ILayer
    public void onLayerDetach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            super.onLayerDetach();
            sendEvent(PlayerEvent.obtainEvent(PlayerEvent.ACTION_KERNEL_LAYER_DETACH));
        }
    }

    @Override // com.baidu.searchbox.player.layer.AbsLayer, com.baidu.searchbox.player.interfaces.INeuron
    public void onLayerEventNotify(@NonNull VideoEvent videoEvent) {
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, videoEvent) == null) {
            String action = videoEvent.getAction();
            int hashCode = action.hashCode();
            if (hashCode == -150198673) {
                if (action.equals(LayerEvent.ACTION_CLICK_NET_TIP)) {
                    c2 = 0;
                }
                c2 = 65535;
            } else if (hashCode != -103262037) {
                if (hashCode == 1939755256 && action.equals(LayerEvent.ACTION_CHANGE_CLARITY)) {
                    c2 = 2;
                }
                c2 = 65535;
            } else {
                if (action.equals(LayerEvent.ACTION_SEEK)) {
                    c2 = 1;
                }
                c2 = 65535;
            }
            if (c2 == 0) {
                getBindPlayer().doPlay();
            } else if (c2 == 1) {
                seekTo(videoEvent.getIntExtra(1));
                requestAudioFocus();
                this.mVideoKernel.resume();
            } else if (c2 != 2) {
            } else {
                int intExtra = videoEvent.getIntExtra(19);
                Object extra = videoEvent.getExtra(31);
                if (extra instanceof VideoUrlModel) {
                    VideoUrlModel videoUrlModel = (VideoUrlModel) extra;
                    if (TextUtils.isEmpty(videoUrlModel.videoUrl)) {
                        return;
                    }
                    changePlayUrl(videoUrlModel);
                    seekTo(intExtra);
                }
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.baidu.searchbox.player.layer.AbsLayer, com.baidu.searchbox.player.interfaces.INeuron
    public void onPlayerEventNotify(@NonNull VideoEvent videoEvent) {
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, videoEvent) == null) {
            String action = videoEvent.getAction();
            switch (action.hashCode()) {
                case -882902390:
                    if (action.equals(PlayerEvent.ACTION_SET_DATA_SOURCE)) {
                        c2 = 4;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -525235558:
                    if (action.equals(PlayerEvent.ACTION_ON_PREPARED)) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -461848373:
                    if (action.equals(PlayerEvent.ACTION_ON_ERROR)) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 154871702:
                    if (action.equals(PlayerEvent.ACTION_ON_COMPLETE)) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1370689931:
                    if (action.equals(PlayerEvent.ACTION_ON_INFO)) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            if (c2 == 0) {
                this.mVideoKernel.onComplete();
            } else if (c2 == 1) {
                this.mVideoKernel.onPrepared();
            } else if (c2 == 2) {
                this.mVideoKernel.onError();
            } else if (c2 != 3) {
                if (c2 == 4 && (videoEvent.getExtra(3) instanceof VideoUrlModel)) {
                    VideoUrlModel videoUrlModel = (VideoUrlModel) videoEvent.getExtra(3);
                    getBindPlayer().getVideoTask().videoUrl = videoUrlModel.videoUrl;
                    setVideoUrl((BaseKernelLayer) videoUrlModel);
                }
            } else {
                this.mVideoKernel.onInfo(videoEvent.getIntExtra(1), videoEvent.getIntExtra(2), videoEvent.getExtra(3));
            }
        }
    }

    @Override // com.baidu.searchbox.player.layer.AbsLayer, com.baidu.searchbox.player.interfaces.INeuron
    public void onSystemEventNotify(@NonNull VideoEvent videoEvent) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048605, this, videoEvent) == null) && this.mAcceptVolumeChange && SystemEvent.ACTION_VOLUME_CHANGED.equals(videoEvent.getAction())) {
            mute(videoEvent.getIntExtra(5) <= 0);
        }
    }

    @PublicMethod
    public void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            this.mVideoKernel.pause();
        }
    }

    @PublicMethod
    public void play(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, str) == null) {
            this.mVideoKernel.play(str);
        }
    }

    @PublicMethod
    public void prepare() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            this.mVideoKernel.prepare();
        }
    }

    @PublicMethod
    public void release() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048609, this) == null) || (this.mVideoKernel instanceof EmptyKernel)) {
            return;
        }
        setKernelCallBack(null);
        AbsVideoKernel absVideoKernel = this.mVideoKernel;
        this.mVideoKernel = new EmptyKernel();
        VideoKernelPool.getInstance().recycle(absVideoKernel);
    }

    @PublicMethod
    public void resume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            this.mVideoKernel.resume();
        }
    }

    @PublicMethod
    public void seekTo(int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048611, this, i2) == null) {
            int duration = this.mVideoKernel.getDuration();
            if (duration > 1 && i2 > (i3 = duration - 1)) {
                i2 = i3;
            }
            this.mVideoKernel.seekToMs(i2 * 1000);
        }
    }

    public void seekToMs(int i2, int i3) {
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048612, this, i2, i3) == null) {
            int durationMs = this.mVideoKernel.getDurationMs();
            if (durationMs > 1 && i2 > (i4 = durationMs - 1)) {
                i2 = i4;
            }
            this.mVideoKernel.seekToMs(i2, i3);
        }
    }

    @PublicMethod
    public void setAcceptVolumeChange(Boolean bool) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, bool) == null) {
            this.mAcceptVolumeChange = bool.booleanValue();
        }
    }

    public void setClarityInfo(@Nullable String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, str) == null) {
            this.mVideoKernel.setClarityInfo(str);
        }
    }

    @PublicMethod
    public void setDecodeMode(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048615, this, i2) == null) {
            this.mVideoKernel.setDecodeMode(i2);
        }
    }

    @PublicMethod
    public void setExternalInfo(String str, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048616, this, str, obj) == null) {
            this.mVideoKernel.setExternalInfo(str, obj);
        }
    }

    @PublicMethod(version = "12.5.0.0")
    public void setGestureDetector(@Nullable IKernelGestureDetector iKernelGestureDetector) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, iKernelGestureDetector) == null) {
        }
    }

    @PublicMethod
    public void setHttpHeader(@Nullable HashMap<String, String> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, hashMap) == null) {
            this.mVideoKernel.setHttpHeader(hashMap);
        }
    }

    @PublicMethod
    public void setKernelCallBack(@Nullable IKernelPlayer iKernelPlayer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, iKernelPlayer) == null) {
            this.mVideoKernel.setKernelCallBack(iKernelPlayer);
        }
    }

    @PublicMethod
    public void setLooping(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048620, this, z) == null) {
            this.mVideoKernel.setLooping(z);
        }
    }

    @PublicMethod
    public void setOption(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048621, this, str, str2) == null) {
            this.mVideoKernel.setOption(str, str2);
        }
    }

    public void setPlayConf(@Nullable String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, str) == null) {
            this.mVideoKernel.setPlayConf(str);
        }
    }

    @PublicMethod
    public void setProxy(@Nullable String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, str) == null) {
            this.mVideoKernel.setProxy(str);
        }
    }

    @PublicMethod(version = "11.26.0.0")
    public void setRadius(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048624, this, f2) == null) {
            this.mVideoKernel.setRadius(f2);
        }
    }

    @PublicMethod
    public void setRemote(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048625, this, z) == null) {
            this.mVideoKernel.setRemote(z);
        }
    }

    @PublicMethod
    public void setSpeed(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048626, this, f2) == null) {
            this.mVideoKernel.setSpeed(f2);
        }
    }

    @PublicMethod
    public void setSurface(Surface surface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, surface) == null) {
            this.mVideoKernel.setSurface(surface);
        }
    }

    @PublicMethod
    public void setUserAgent(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048628, this, str) == null) {
            this.mVideoKernel.setUserAgent(str);
        }
    }

    @PublicMethod
    public void setVideoFormatOptions(String str, @NonNull HashMap<String, String> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048629, this, str, hashMap) == null) {
            this.mVideoKernel.setVideoFormatOptions(str, hashMap);
        }
    }

    @PublicMethod
    public void setVideoRotation(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048630, this, i2) == null) {
            this.mVideoKernel.setVideoRotation(i2);
        }
    }

    @PublicMethod
    public void setVideoScalingMode(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048631, this, i2) == null) {
            this.mVideoKernel.setVideoScalingMode(i2);
        }
    }

    @PublicMethod(version = "12.19.0.0")
    public <T extends VideoUrlModel> void setVideoUrl(@NonNull T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048632, this, t) == null) {
            this.mVideoKernel.setVideoUrl((AbsVideoKernel) t);
        }
    }

    @PublicMethod
    public void setZOrderMediaOverlay(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048635, this, z) == null) {
            this.mVideoKernel.setZOrderMediaOverlay(z);
        }
    }

    @PublicMethod
    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048636, this) == null) {
            this.mVideoKernel.start();
        }
    }

    @PublicMethod
    public void stop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048637, this) == null) {
            this.mVideoKernel.stop();
        }
    }

    @PublicMethod
    public void stopPlayback() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048638, this) == null) {
            this.mVideoKernel.stopPlayback();
        }
    }

    public void switchMediaSource(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048639, this, i2) == null) {
            this.mVideoKernel.switchMediaSource(i2);
        }
    }

    @PublicMethod
    public void syncStatus(@NonNull PlayerStatus playerStatus) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048640, this, playerStatus) == null) {
            this.mVideoKernel.getVideoSession().statusChangeNotify(playerStatus);
        }
    }

    @PublicMethod
    public boolean takeSnapshotAsync(OnSnapShotFrameListener onSnapShotFrameListener, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLF = interceptable.invokeLF(1048641, this, onSnapShotFrameListener, f2)) == null) ? this.mVideoKernel.takeSnapshotAsync(onSnapShotFrameListener, f2) : invokeLF.booleanValue;
    }

    @PublicMethod
    public void updateFreeProxy(@Nullable String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048642, this, str) == null) {
            this.mVideoKernel.updateFreeProxy(str);
        }
    }

    public void changePlayUrl(@NonNull VideoUrlModel videoUrlModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, videoUrlModel) == null) {
            this.mVideoKernel.changePlayUrl((AbsVideoKernel) videoUrlModel);
        }
    }

    @PublicMethod
    public void setVideoUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048633, this, str) == null) {
            setVideoUrl(str, true);
        }
    }

    public void setVideoUrl(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048634, this, str, z) == null) {
            this.mVideoKernel.setVideoUrl(str, z);
        }
    }

    public BaseKernelLayer(@NonNull AbsVideoKernel absVideoKernel) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {absVideoKernel};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mAcceptVolumeChange = true;
        this.mInternalEventDispatcher = new Dispatcher(this, null);
        this.mVideoKernel = absVideoKernel;
        initLayer();
    }
}
