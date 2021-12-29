package com.baidu.searchbox.net.update;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public final class R {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes10.dex */
    public static final class string {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int activity_not_found = 0x7f0f0077;
        public static final int app_name = 0x7f0f029e;
        public static final int time_liveshow_teletext_time_day_before = 0x7f0f1610;
        public static final int time_liveshow_teletext_time_hour_before = 0x7f0f1611;
        public static final int time_liveshow_teletext_time_min_before = 0x7f0f1612;
        public static final int time_liveshow_teletext_time_sec_before = 0x7f0f1613;
        public transient /* synthetic */ FieldHolder $fh;

        public string() {
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

    public R() {
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
