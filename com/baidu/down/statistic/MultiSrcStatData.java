package com.baidu.down.statistic;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class MultiSrcStatData {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long ccost;
    public int cstatus;
    public int dbtype;
    public long dfcost;
    public int dfstat;
    public long dtest;
    public int dyget;
    public int dyuse;
    public String network;
    public String packageName;
    public String sid;
    public int tnum;
    public String version;

    public MultiSrcStatData() {
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
        this.cstatus = -1;
        this.ccost = -1L;
        this.tnum = -1;
        this.network = "";
        this.sid = "";
        this.packageName = "";
        this.version = "";
        this.dfstat = -1;
        this.dfcost = -1L;
        this.dyget = -1;
        this.dyuse = -1;
        this.dtest = -1L;
        this.dbtype = 5;
    }
}
