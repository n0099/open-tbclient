package com.baidu.searchbox.player.event;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.searchbox.player.utils.BdVideoLog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class PlayerEventTrigger extends AbsEventTrigger {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<Integer> mAttentionEventArray;

    public PlayerEventTrigger() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mAttentionEventArray = new ArrayList<>(9);
        initAttentionArray();
    }

    private boolean filterOnInfoEvent(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65537, this, i2)) == null) ? this.mAttentionEventArray.contains(Integer.valueOf(i2)) : invokeI.booleanValue;
    }

    private void initAttentionArray() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            this.mAttentionEventArray.add(904);
            this.mAttentionEventArray.add(701);
            this.mAttentionEventArray.add(702);
            this.mAttentionEventArray.add(Integer.valueOf((int) CyberPlayerManager.MEDIA_INFO_EXTEND_VIDEO_CACHE_PROGRESS));
            this.mAttentionEventArray.add(924);
            this.mAttentionEventArray.add(5000);
            this.mAttentionEventArray.add(Integer.valueOf((int) CyberPlayerManager.MEDIA_INFO_STREAM_RECONNECED));
            this.mAttentionEventArray.add(Integer.valueOf((int) CyberPlayerManager.MEDIA_INFO_STREAM_RECONNECTING));
            this.mAttentionEventArray.add(Integer.valueOf((int) CyberPlayerManager.MEDIA_INFO_LOOP_REPLAYED));
            this.mAttentionEventArray.add(Integer.valueOf((int) CyberPlayerManager.MEDIA_INFO_RESTART_PLAYED));
        }
    }

    public void onBufferingUpdate(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            triggerEvent(PlayerEvent.obtainEvent(PlayerEvent.ACTION_BUFFER_UPDATE));
        }
    }

    public void onCompletion() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            triggerEvent(PlayerEvent.obtainEvent(PlayerEvent.ACTION_ON_COMPLETE));
        }
    }

    public boolean onError(int i2, int i3, Object obj) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i2, i3, obj)) == null) {
            VideoEvent obtainEvent = PlayerEvent.obtainEvent(PlayerEvent.ACTION_ON_ERROR);
            obtainEvent.putExtra(1, Integer.valueOf(i2));
            obtainEvent.putExtra(2, Integer.valueOf(i3));
            obtainEvent.putExtra(3, obj);
            triggerEvent(obtainEvent);
            return true;
        }
        return invokeIIL.booleanValue;
    }

    public boolean onInfo(int i2, int i3, Object obj) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048579, this, i2, i3, obj)) == null) {
            BdVideoLog.d("player trigger on info what:" + i2);
            if (filterOnInfoEvent(i2)) {
                VideoEvent obtainEvent = PlayerEvent.obtainEvent(PlayerEvent.ACTION_ON_INFO);
                obtainEvent.putExtra(1, Integer.valueOf(i2));
                obtainEvent.putExtra(2, Integer.valueOf(i3));
                obtainEvent.putExtra(3, obj);
                triggerEvent(obtainEvent);
                return false;
            }
            return false;
        }
        return invokeIIL.booleanValue;
    }

    public void onPlayerAttach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            triggerEvent(PlayerEvent.obtainEvent(PlayerEvent.ACTION_PLAYER_ATTACH));
        }
    }

    public void onPlayerDetach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            triggerEvent(PlayerEvent.obtainEvent(PlayerEvent.ACTION_PLAYER_DETACH));
        }
    }

    public void onPrepared() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            triggerEvent(PlayerEvent.obtainEvent(PlayerEvent.ACTION_ON_PREPARED));
        }
    }

    public void onSeekComplete() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            triggerEvent(PlayerEvent.obtainEvent(PlayerEvent.ACTION_SEEK_COMPLETE));
        }
    }

    public void onVideoSizeChanged(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, i3, i4, i5) == null) {
            VideoEvent obtainEvent = PlayerEvent.obtainEvent(PlayerEvent.ACTION_VIDEO_SIZE_CHANGED);
            obtainEvent.putExtra(5, Integer.valueOf(i2));
            obtainEvent.putExtra(6, Integer.valueOf(i3));
            triggerEvent(obtainEvent);
        }
    }

    @Override // com.baidu.searchbox.player.event.AbsEventTrigger, com.baidu.searchbox.player.event.IEventTrigger
    public void triggerEvent(@NonNull VideoEvent videoEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, videoEvent) == null) {
            super.triggerEvent(videoEvent);
        }
    }
}
