package com.baidu.adp.plugin.packageManager.status;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class PluginStatus extends OrmObject {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int STATUS_INSTALL_ERROR_ROMSIZE = 2;
    public static final int STATUS_INSTALL_FSYNC_FAILED = 5;
    public static final int STATUS_INSTALL_ONLYREAD_FILESYSTEM = 3;
    public static final int STATUS_INSTALL_PERMISSION_DENIED = 4;
    public static final int STATUS_INSTALL_RETRY_TIMEOUT = 6;
    public static final int STATUS_INSTALL_UNKNOWN = 1;
    public static final int STATUS_LOAD_UNKNOWN = 100;
    public static final int STATUS_SUCCESS = 0;
    public transient /* synthetic */ FieldHolder $fh;
    public PluginPackageManager.PluginStatus a;
    public int b;
    public String c;
    public String d;
    public boolean e;

    public PluginStatus() {
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
