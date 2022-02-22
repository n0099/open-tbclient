package com.baidu.searchbox.datacollector.growth.utils;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes11.dex */
public class GrowthConstant {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long DEVICE_RECORD_TIMEOUT = 86400000;
    public static final long KEEP_ALIVE_TIME = 600000;
    public static final String PREF_NAME = "GrowthDataCollect";
    public static final String SP_KEY_LAST_DEVICE_RECORD_TIME = "ldt";
    public static final String UBC_ID_ACTIVE = "1716";
    public static final String UBC_ID_CHANNEL = "1611";
    public static final String UBC_ID_CLIP_BOARD = "1612";
    public static final String UBC_ID_DEVICE = "3705";
    public static final String UBC_KEY_AES_KEY = "aes_key";
    public static final String UBC_KEY_CHANNEL = "channel";
    public static final String UBC_KEY_DOWN_CH = "down_ch";
    public static final String UBC_KEY_EXT = "ext";
    public static final String UBC_KEY_FIT = "fit";
    public static final String UBC_KEY_IMEI = "imei";
    public static final String UBC_KEY_LAUNCH_CH = "launch_ch";
    public static final String UBC_KEY_LUT = "lut";
    public static final String UBC_KEY_OAID = "oaid";
    public static final String UBC_KEY_SCHEMA = "schema";
    public static final String UBC_KEY_SOURCE = "source";
    public static final String UBC_KEY_TYPE = "type";
    public static final String UBC_KEY_USS = "uss";
    public static final String UBC_VALUE_TYPE_CLIP_BOARD = "clipboard";
    public static final String UBC_VALUE_TYPE_DEFAULT = "active";
    public static final String UBC_VALUE_TYPE_DEVICE_INFO = "deviceInfo";
    public transient /* synthetic */ FieldHolder $fh;

    public GrowthConstant() {
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
