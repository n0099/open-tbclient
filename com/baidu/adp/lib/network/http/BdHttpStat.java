package com.baidu.adp.lib.network.http;

import com.baidu.bdhttpdns.BDHttpDnsResult;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class BdHttpStat {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long allCostTime;
    public long connectTime;
    public long contentLen;
    public long dataLenth;
    public String directIp;
    public String dnsIp;
    public String dnsIpList;
    public BDHttpDnsResult.ResolveStatus dnsResolveStatus;
    public BDHttpDnsResult.ResolveType dnsResolveType;
    public long dnsTime;
    public long downloadSize;
    public int errorCode;
    public String exception;
    public int executeStatus;
    public long fileLength;
    public int ipIndex;
    public boolean isUseIpDirectConnect;
    public int netLibFlag;
    public String redirectUrl;
    public int responsedCode;
    public int retry;
    public long rspTime;
    public String traceCode1;
    public String traceCode2;
    public long upDataSize;
    public String url;

    public BdHttpStat() {
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
        this.upDataSize = -1L;
        this.downloadSize = -1L;
        this.connectTime = -1L;
        this.rspTime = -1L;
        this.retry = 0;
        this.allCostTime = -1L;
        this.dnsTime = -1L;
        this.exception = "";
        this.responsedCode = -1;
        this.errorCode = 0;
        this.executeStatus = 0;
        this.directIp = null;
        this.dnsIp = null;
        this.dnsResolveType = null;
        this.dnsResolveStatus = null;
        this.dnsIpList = null;
        this.ipIndex = 0;
        this.redirectUrl = null;
        this.url = null;
        this.traceCode1 = null;
        this.traceCode2 = null;
        this.netLibFlag = 0;
        this.dataLenth = -1L;
        this.fileLength = -1L;
        this.contentLen = -1L;
    }
}
