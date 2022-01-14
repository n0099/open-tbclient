package com.baidu.searchbox.ruka.ioc;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes11.dex */
public class Constant {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KEY_ANR_TIMESTAMP = "anrTimeStamp";
    public static final String KEY_APP_VERSION = "appversion";
    public static final String KEY_BLOCK_TIMESTAMP = "blockTimeStamp";
    public static final String KEY_CONFIG_ID = "configid";
    public static final String KEY_CPU = "cpu";
    public static final String KEY_CPU_RATE = "cpuusage";
    public static final String KEY_DEVICE_SCORE = "devicescore";
    public static final String KEY_EMULATOR = "emulator";
    public static final String KEY_EXSTORAGE = "exStorage";
    public static final String KEY_FILE_ID = "fileid";
    public static final String KEY_HEAP = "heap";
    public static final String KEY_INSTORAGE = "inStorage";
    public static final String KEY_ISLOWMEMORY = "isLowMemory";
    public static final String KEY_LAUNCH_ID = "launchid";
    public static final String KEY_LAUNCH_TYPE = "launchtype";
    public static final String KEY_LINEMAPPING = "linemapping";
    public static final String KEY_LOG_ID = "logid";
    public static final String KEY_MEMORY = "memory";
    public static final String KEY_NETWORK = "network";
    public static final String KEY_OS_VERSION = "osversion";
    public static final String KEY_PACKAGE_NAME = "packagename";
    public static final String KEY_PAGE = "page";
    public static final String KEY_PROCBIT = "procBit";
    public static final String KEY_PROCESS_LAUNCHTIME = "launchTime";
    public static final String KEY_PSS = "PSS";
    public static final String KEY_ROM = "ROM";
    public static final String KEY_ROOT = "root";
    public static final String KEY_RUKA_CONFIG = "ruka_config";
    public static final String KEY_SDK_VERSION = "sdkversion";
    public static final String KEY_STACK = "stacktrace";
    public static final String KEY_SYSMEM = "sysMem";
    public static final String KEY_TIME_COST_END = "endlagtime";
    public static final String KEY_TIME_COST_START = "startlagtime";
    public static final String KEY_TIME_DURATION = "duration";
    public static final String KEY_TYPE = "type";
    public static final String KEY_VSSRSS = "VSSRSS";
    public static final String PAGE_TRACE = "pageTrace";
    public static final String PAGE_TRACE_EVENT = "event";
    public static final String PAGE_TRACE_PAGE = "page";
    public static final String PAGE_TRACE_TAG = "tag";
    public static final String PAGE_TRACE_TIME = "time";
    public transient /* synthetic */ FieldHolder $fh;

    public Constant() {
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
