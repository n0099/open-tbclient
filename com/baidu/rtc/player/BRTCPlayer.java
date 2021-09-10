package com.baidu.rtc.player;

import com.baidu.rtc.RTCVideoView;
import com.baidu.rtc.record.IMediaRecord;
import com.baidu.rtc.snapshot.ISnapShot;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public interface BRTCPlayer extends IMediaRecord, ISnapShot {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes5.dex */
    public static final class PlayerState {
        public static final /* synthetic */ PlayerState[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final PlayerState STATE_ERROR;
        public static final PlayerState STATE_IDLE;
        public static final PlayerState STATE_INITIALIZED;
        public static final PlayerState STATE_PAUSED;
        public static final PlayerState STATE_PLAYING;
        public static final PlayerState STATE_PREPARED;
        public static final PlayerState STATE_PREPARING;
        public static final PlayerState STATE_STOP;
        public transient /* synthetic */ FieldHolder $fh;
        public int mCode;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1498676125, "Lcom/baidu/rtc/player/BRTCPlayer$PlayerState;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1498676125, "Lcom/baidu/rtc/player/BRTCPlayer$PlayerState;");
                    return;
                }
            }
            STATE_ERROR = new PlayerState("STATE_ERROR", 0, -1);
            STATE_IDLE = new PlayerState("STATE_IDLE", 1, 0);
            STATE_INITIALIZED = new PlayerState("STATE_INITIALIZED", 2, 1);
            STATE_PREPARING = new PlayerState("STATE_PREPARING", 3, 2);
            STATE_PREPARED = new PlayerState("STATE_PREPARED", 4, 3);
            STATE_PLAYING = new PlayerState("STATE_PLAYING", 5, 4);
            STATE_PAUSED = new PlayerState("STATE_PAUSED", 6, 5);
            PlayerState playerState = new PlayerState("STATE_STOP", 7, 6);
            STATE_STOP = playerState;
            $VALUES = new PlayerState[]{STATE_ERROR, STATE_IDLE, STATE_INITIALIZED, STATE_PREPARING, STATE_PREPARED, STATE_PLAYING, STATE_PAUSED, playerState};
        }

        public PlayerState(String str, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.mCode = i3;
        }

        public static PlayerState valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (PlayerState) Enum.valueOf(PlayerState.class, str) : (PlayerState) invokeL.objValue;
        }

        public static PlayerState[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (PlayerState[]) $VALUES.clone() : (PlayerState[]) invokeV.objValue;
        }
    }

    PlayerState getPlayerState();

    boolean hasAudio();

    boolean hasVideo();

    long initPlayer(BRTCPlayerParameters bRTCPlayerParameters, BRTCPlayerEvents bRTCPlayerEvents);

    void pausePlay();

    void releasePlayer();

    void resumePlay();

    void setEventObserver(BRTCPlayerEvents bRTCPlayerEvents);

    void setRemoteSdp(String str);

    void setScalingType(RTCVideoView.ScalingType scalingType);

    void setStreamUri(String str);

    void setSurfaceView(RTCVideoView rTCVideoView);

    void setVolume(double d2);

    void startPlay();

    void stopPlay();
}
