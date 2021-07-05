package com.baidu.cyberplayer.sdk.dlna;

import com.baidu.cyberplayer.sdk.Keep;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@Keep
/* loaded from: classes3.dex */
public class DlnaManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DLNA_ERROR_CREATE_CTRL_POINT_TIMER_THREAD_FAIL = -1011;
    public static final int DLNA_ERROR_CREATE_SSDP_THREAD_FIAL = -1017;
    public static final int DLNA_ERROR_DATA_INVALIDATE = -1015;
    public static final int DLNA_ERROR_DEVICE_CONNECT_TIMEOUT = -1002;
    public static final int DLNA_ERROR_DEVICE_NOT_EXIST = -1019;
    public static final int DLNA_ERROR_GET_MEDIA_INFO_ACTION_NOT_FOUND = -1006;
    public static final int DLNA_ERROR_GET_MUTE_ACTION_NOT_FOUND = -1008;
    public static final int DLNA_ERROR_GET_POSITION_INFO_ACTION_NOT_FOUND = -1009;
    public static final int DLNA_ERROR_GET_TRANSPORT_INFO_ACTION_NOT_FOUND = -1010;
    public static final int DLNA_ERROR_NETWORK_EXCEPTION = -1021;
    public static final int DLNA_ERROR_NO_DEVICE = -1016;
    public static final int DLNA_ERROR_PARSE_FAIL = -1014;
    public static final int DLNA_ERROR_PAUSE_ACTION_NOT_FOUND = -1004;
    public static final int DLNA_ERROR_PLAY_ACTION_NOT_FOUND = -1001;
    public static final int DLNA_ERROR_SEEK_ACTION_NOT_FOUND = -1005;
    public static final int DLNA_ERROR_SEEK_FAIL = -1020;
    public static final int DLNA_ERROR_SET_AV_TRANSPORT_URI_ACTION_NOT_FOUND = -1003;
    public static final int DLNA_ERROR_SET_MUTE_ACTION_NOT_FOUND = -1007;
    public static final int DLNA_ERROR_SET_VOLUME_ACTION_NOT_FOUND = -1013;
    public static final int DLNA_ERROR_STOP_ACTION_NOT_FOUND = -1012;
    public static final int DLNA_ERROR_STOP_SPCE_INVALIDATE = -1018;
    public static final int DLNA_PLAY_STATUS = 0;
    public static final int DLNA_PLAY_SUB_STATUS_COMPLETE = 4;
    public static final int DLNA_PLAY_SUB_STATUS_CONNECTED = 5;
    public static final int DLNA_PLAY_SUB_STATUS_IDLE = 0;
    public static final int DLNA_PLAY_SUB_STATUS_PAUSED = 2;
    public static final int DLNA_PLAY_SUB_STATUS_PLAYING = 1;
    public static final int DLNA_PLAY_SUB_STATUS_PREPARED = 3;
    public static final int DLNA_PLAY_SUB_STATUS_UNKNOW = -1;
    public static final int DLNA_SUB_ERROR_NETWORK_NOT_WIFI = -2001;
    public static final int DLNA_SUB_ERROR_NETWORK_UNREACHABLE = -2000;
    public transient /* synthetic */ FieldHolder $fh;

    public DlnaManager() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }
}
