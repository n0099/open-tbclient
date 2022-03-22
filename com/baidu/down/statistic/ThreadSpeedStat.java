package com.baidu.down.statistic;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class ThreadSpeedStat {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String CLIENT_REQUEST_ID_HEADER_NAME = "cqid";
    public static final String DOWN_RESULT_STATE_CANCEL = "c";
    public static final String DOWN_RESULT_STATE_FAIL = "f";
    public static final String DOWN_RESULT_STATE_SUCCESS = "s";
    public transient /* synthetic */ FieldHolder $fh;
    public String cqid;
    public long dTempDownSize;
    public long dend;
    public long downEndConnectTime;
    public long downEndTime;
    public long downStartConnectTime;
    public long downStartTime;
    public int drnum;
    public String drs;
    public long dsize;
    public long dspt;
    public long dstart;
    public long dt;
    public long endWirteTime;
    public String ip;
    public long startWriteTime;
    public String url;

    public ThreadSpeedStat() {
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
        this.drs = "";
        this.dstart = -1L;
    }
}
