package com.baidu.android.util.android;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public final class R {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static final class string {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int activity_not_found = 0x7f0f00ba;
        public static final int app_name = 0x7f0f029e;
        public static final int liveshow_teletext_time_day_before = 0x7f0f0c16;
        public static final int liveshow_teletext_time_hour_before = 0x7f0f0c17;
        public static final int liveshow_teletext_time_min_before = 0x7f0f0c18;
        public static final int liveshow_teletext_time_sec_before = 0x7f0f0c19;
        public transient /* synthetic */ FieldHolder $fh;

        public string() {
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
    }

    public R() {
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
}
