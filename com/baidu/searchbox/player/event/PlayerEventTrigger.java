package com.baidu.searchbox.player.event;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.player.annotation.PublicMethod;
import com.baidu.searchbox.player.model.VideoUrlModel;
import com.baidu.searchbox.player.utils.BdVideoLog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class PlayerEventTrigger extends SingleTargetTrigger {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean ignoreInfoEventFilter;
    public final ArrayList<Integer> mAttentionEventArray;

    public PlayerEventTrigger() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mAttentionEventArray = new ArrayList<>(17);
        this.ignoreInfoEventFilter = false;
        initAttentionArray();
    }

    public void onCompletion() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            triggerEvent(PlayerEvent.obtainEvent(PlayerEvent.ACTION_ON_COMPLETE));
        }
    }

    public void onPlayerAttach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            triggerEvent(PlayerEvent.obtainEvent(PlayerEvent.ACTION_PLAYER_ATTACH));
        }
    }

    public void onPlayerDetach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            triggerEvent(PlayerEvent.obtainEvent(PlayerEvent.ACTION_PLAYER_DETACH));
        }
    }

    public void onPrepared() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            triggerEvent(PlayerEvent.obtainEvent(PlayerEvent.ACTION_ON_PREPARED));
        }
    }

    public void onSeekComplete() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            triggerEvent(PlayerEvent.obtainEvent(PlayerEvent.ACTION_SEEK_COMPLETE));
        }
    }

    @PublicMethod
    public void updateDataSource() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            triggerEvent(PlayerEvent.obtainEvent(PlayerEvent.ACTION_UPDATE_DATA_SOURCE));
        }
    }

    private boolean filterOnInfoEvent(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, this, i)) == null) {
            return this.mAttentionEventArray.contains(Integer.valueOf(i));
        }
        return invokeI.booleanValue;
    }

    @PublicMethod
    public void goBackOrForeground(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            VideoEvent obtainEvent = PlayerEvent.obtainEvent(PlayerEvent.ACTION_GO_BACK_OR_FOREGROUND);
            obtainEvent.putExtra(4, Boolean.valueOf(z));
            triggerEvent(obtainEvent);
        }
    }

    public void ignoreInfoEventFilter(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.ignoreInfoEventFilter = z;
        }
    }

    public void onBufferingUpdate(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            VideoEvent obtainEvent = PlayerEvent.obtainEvent(PlayerEvent.ACTION_BUFFER_UPDATE);
            obtainEvent.putExtra(2, Integer.valueOf(i));
            obtainEvent.setLogLevel(1);
            triggerEvent(obtainEvent);
        }
    }

    public void setDataSource(@NonNull VideoUrlModel videoUrlModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, videoUrlModel) == null) {
            VideoEvent obtainEvent = PlayerEvent.obtainEvent(PlayerEvent.ACTION_SET_DATA_SOURCE);
            obtainEvent.putExtra(3, videoUrlModel);
            obtainEvent.setPriority(1);
            triggerEvent(obtainEvent);
        }
    }

    @Override // com.baidu.searchbox.player.event.SingleTargetTrigger, com.baidu.searchbox.player.event.IEventTrigger
    public void triggerEvent(@NonNull VideoEvent videoEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, videoEvent) == null) {
            super.triggerEvent(videoEvent);
        }
    }

    private void initAttentionArray() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            this.mAttentionEventArray.add(904);
            this.mAttentionEventArray.add(701);
            this.mAttentionEventArray.add(702);
            this.mAttentionEventArray.add(11004);
            this.mAttentionEventArray.add(11005);
            this.mAttentionEventArray.add(946);
            this.mAttentionEventArray.add(924);
            this.mAttentionEventArray.add(5000);
            this.mAttentionEventArray.add(937);
            this.mAttentionEventArray.add(936);
            this.mAttentionEventArray.add(955);
            this.mAttentionEventArray.add(956);
            this.mAttentionEventArray.add(910);
            this.mAttentionEventArray.add(10103);
            this.mAttentionEventArray.add(12005);
            this.mAttentionEventArray.add(12006);
            this.mAttentionEventArray.add(10009);
        }
    }

    public boolean onError(int i, int i2, Object obj) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048580, this, i, i2, obj)) == null) {
            VideoEvent obtainEvent = PlayerEvent.obtainEvent(PlayerEvent.ACTION_ON_ERROR);
            obtainEvent.putExtra(1, Integer.valueOf(i));
            obtainEvent.putExtra(2, Integer.valueOf(i2));
            obtainEvent.putExtra(3, obj);
            triggerEvent(obtainEvent);
            return true;
        }
        return invokeIIL.booleanValue;
    }

    public void onMediaSourceChanged(int i, int i2, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048582, this, i, i2, obj) == null) {
            VideoEvent obtainEvent = PlayerEvent.obtainEvent(PlayerEvent.ACTION_MEDIA_SOURCE_CHANGED);
            obtainEvent.putExtra(7, Integer.valueOf(i));
            obtainEvent.putExtra(8, Integer.valueOf(i2));
            obtainEvent.putExtra(3, obj);
            triggerEvent(obtainEvent);
        }
    }

    public boolean onInfo(int i, int i2, Object obj) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048581, this, i, i2, obj)) == null) {
            BdVideoLog.v("player trigger on info what:" + i);
            if (this.ignoreInfoEventFilter || filterOnInfoEvent(i)) {
                VideoEvent obtainEvent = PlayerEvent.obtainEvent(PlayerEvent.ACTION_ON_INFO);
                if (i == 910) {
                    obtainEvent.setLogLevel(1);
                }
                obtainEvent.putExtra(1, Integer.valueOf(i));
                obtainEvent.putExtra(2, Integer.valueOf(i2));
                obtainEvent.putExtra(3, obj);
                triggerEvent(obtainEvent);
                return false;
            }
            return false;
        }
        return invokeIIL.booleanValue;
    }

    public void onVideoSizeChanged(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048587, this, i, i2, i3, i4) == null) {
            VideoEvent obtainEvent = PlayerEvent.obtainEvent(PlayerEvent.ACTION_VIDEO_SIZE_CHANGED);
            obtainEvent.putExtra(5, Integer.valueOf(i));
            obtainEvent.putExtra(6, Integer.valueOf(i2));
            triggerEvent(obtainEvent);
        }
    }

    public void setDataSource(String str, boolean z, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{str, Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            VideoEvent obtainEvent = PlayerEvent.obtainEvent(PlayerEvent.ACTION_SET_DATA_SOURCE);
            VideoUrlModel videoUrlModel = new VideoUrlModel();
            videoUrlModel.videoUrl = str;
            videoUrlModel.isNeedPrepare = z;
            videoUrlModel.playerStageType = i;
            obtainEvent.putExtra(3, videoUrlModel);
            obtainEvent.setPriority(1);
            triggerEvent(obtainEvent);
        }
    }
}
