package com.baidu.down.statistic;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class ConfigSpeedStat {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int CFG_ENABLE_DEFAULT = 1;
    public static final long CFG_MIN_INTERVAL_DEFAULT = 7200;
    public static final long CFG_MIN_INTERVAL_MAX = 86400;
    public static final long CFG_MIN_SIZE_DEFAULT = 102400;
    public static final long CFG_MIN_TIME_DEFAULT = 5;
    public static final String CFG_VERSION_DEFAULT = "";
    public transient /* synthetic */ FieldHolder $fh;
    public int cfgEnable;
    public long cfgMinInterval;
    public long cfgMinSize;
    public long cfgMinTime;
    public String cfgVersion;

    public ConfigSpeedStat() {
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
