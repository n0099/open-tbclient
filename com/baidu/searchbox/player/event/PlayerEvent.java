package com.baidu.searchbox.player.event;

import androidx.annotation.NonNull;
import com.baidu.searchbox.player.annotation.PublicMethod;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class PlayerEvent extends VideoEvent {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ACTION_BUFFER_UPDATE = "player_event_buffer_update";
    public static final String ACTION_GO_BACK_OR_FOREGROUND = "player_event_go_back_or_foreground";
    public static final String ACTION_KERNEL_LAYER_DETACH = "player_event_kernel_layer_detach";
    public static final String ACTION_MEDIA_SOURCE_CHANGED = "player_event_media_source_changed";
    public static final String ACTION_ON_COMPLETE = "player_event_on_complete";
    public static final String ACTION_ON_ERROR = "player_event_on_error";
    public static final String ACTION_ON_INFO = "player_event_on_info";
    public static final String ACTION_ON_PREPARED = "player_event_on_prepared";
    public static final String ACTION_PLAYER_ATTACH = "player_event_attach";
    public static final String ACTION_PLAYER_DETACH = "player_event_detach";
    public static final String ACTION_SEEK_COMPLETE = "player_event_seek_complete";
    public static final String ACTION_SET_DATA_SOURCE = "player_event_set_data";
    public static final String ACTION_UPDATE_DATA_SOURCE = "player_event_update_data";
    public static final String ACTION_VIDEO_SIZE_CHANGED = "player_event_video_size_changed";
    public static final int KEY_EXTRA = 2;
    public static final int KEY_GO_BACK_OR_FOREGROUND = 4;
    public static final int KEY_HEIGHT = 6;
    public static final int KEY_OBJECT = 3;
    public static final int KEY_RANK = 8;
    public static final int KEY_RESULT = 7;
    public static final int KEY_WHAT = 1;
    public static final int KEY_WIDTH = 5;
    public transient /* synthetic */ FieldHolder $fh;

    public PlayerEvent() {
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

    @PublicMethod
    public static VideoEvent obtainEvent(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) ? VideoEvent.obtain(str, 4) : (VideoEvent) invokeL.objValue;
    }
}
