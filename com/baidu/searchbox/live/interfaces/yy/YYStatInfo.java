package com.baidu.searchbox.live.interfaces.yy;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class YYStatInfo {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String LOAD_TYPE_LOADED = "launch";
    public static final String LOAD_TYPE_NOT_DOWNLOAD = "download";
    public static final String LOAD_TYPE_NOT_INSTALL = "install";
    public static final String LOAD_TYPE_NOT_LOAD = "load";
    public transient /* synthetic */ FieldHolder $fh;
    public Object flowObj;
    @Deprecated
    public boolean isColdLaunch;
    public String loadType;
    public HashMap<String, Object> statInfo;

    public YYStatInfo() {
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
