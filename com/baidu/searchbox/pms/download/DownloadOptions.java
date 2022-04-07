package com.baidu.searchbox.pms.download;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class DownloadOptions {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int PRIORITY_BACKGROUND = 2;
    public static final int PRIORITY_DEFAULT = 1;
    public static final int PRIORITY_SPECIAL = 4;
    public static final int PRIORITY_USER_INTERACTIVE = 3;
    public transient /* synthetic */ FieldHolder $fh;
    public String fileDir;
    public boolean forceAnyEnv;
    public int priority;
    public boolean saveToDb;

    public DownloadOptions() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.forceAnyEnv = true;
        this.saveToDb = true;
    }
}
