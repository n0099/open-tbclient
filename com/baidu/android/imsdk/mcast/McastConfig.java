package com.baidu.android.imsdk.mcast;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class McastConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ACTION_NETWORK_STATE_CHANGED = "android.net.wifi.STATE_CHANGE";
    public static final String ACTION_WIFI_STATE_CHANGED = "android.net.wifi.WIFI_STATE_CHANGED";
    public static final int CAST_HEART_BEAT = 30000;
    public static final int HEART_BEAT_TIME = 3000;
    public static final int RANDOM_SCOPE_MS = 3000;
    public transient /* synthetic */ FieldHolder $fh;

    public McastConfig() {
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
