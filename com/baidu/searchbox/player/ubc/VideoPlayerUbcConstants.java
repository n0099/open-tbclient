package com.baidu.searchbox.player.ubc;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class VideoPlayerUbcConstants {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String UBC_PLAY_PERFORMANCE_ID = "515";
    public static final String UBC_VIDEO_CARLTON = "481";
    public static final String UBC_VIDEO_DOWNLOAD_TOAST = "615";
    public static final String UBC_VIDEO_FLOATING = "1292";
    public static final String UBC_VIDEO_FLOATING_DURATION = "1291";
    public static final String UBC_VIDEO_FUNC_KEY = "465";
    public static final String UBC_VIDEO_LOADING = "895";
    public static final String UBC_VIDEO_NET_TIPS = "484";
    public static final String UBC_VIDEO_PANEL_SHOW = "514";
    public static final String UBC_VIDEO_PLAY_CLARITY = "1074";
    public static final String UBC_VIDEO_PLAY_DURATION = "485";
    public static final String UBC_VIDEO_PLAY_ERROR = "36";
    public static final String UBC_VIDEO_PLAY_SPEED_DURATION = "1046";
    public static final String UBC_VIDEO_PLAY_SUCCESS = "322";
    public static final String UBC_VIDEO_STATUS_LOAD = "3";
    public static final String UBC_VIDEO_WIDGET = "464";
    public transient /* synthetic */ FieldHolder $fh;

    public VideoPlayerUbcConstants() {
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
