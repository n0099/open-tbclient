package com.baidu.down.common;

import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes2.dex */
public class DownDetail {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int RETRY_STRATEGY_DOWNFLOW_FAIL = 2;
    public static final int RETRY_STRATEGY_DOWNFLOW_FAIL_DATA_NO_MATCH = 5;
    public static final int RETRY_STRATEGY_DOWNFLOW_FAIL_NET_ERROR = 6;
    public static final int RETRY_STRATEGY_DOWNFLOW_SUCCESS = 1;
    public static final int RETRY_STRATEGY_FAIL = 4;
    public static final int RETRY_STRATEGY_NO = 0;
    public static final int RETRY_STRATEGY_SUCCESS = 3;
    public transient /* synthetic */ FieldHolder $fh;
    public String allInfo;
    public List domainNameAndIpInfo;
    public String extendInfo;
    public int extendType;
    public String retryException;
    public String retryStrategyInfo;
    public int retryType;

    public DownDetail() {
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
        this.retryType = 0;
        this.extendType = 0;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("[retryType=");
            stringBuffer.append(this.retryType);
            stringBuffer.append(PreferencesUtil.RIGHT_MOUNT);
            stringBuffer.append("[retryException=");
            stringBuffer.append(this.retryException);
            stringBuffer.append(PreferencesUtil.RIGHT_MOUNT);
            stringBuffer.append("[retryStrategyInfo=");
            stringBuffer.append(this.retryStrategyInfo);
            stringBuffer.append(PreferencesUtil.RIGHT_MOUNT);
            stringBuffer.append("[extendType=");
            stringBuffer.append(this.extendType);
            stringBuffer.append(PreferencesUtil.RIGHT_MOUNT);
            stringBuffer.append("[extendInfo=");
            stringBuffer.append(this.extendInfo);
            stringBuffer.append("[allInfo=");
            stringBuffer.append(this.allInfo);
            stringBuffer.append(PreferencesUtil.RIGHT_MOUNT);
            List list = this.domainNameAndIpInfo;
            if (list != null && !list.isEmpty()) {
                for (UrlDNSInfo urlDNSInfo : this.domainNameAndIpInfo) {
                    stringBuffer.append("host:" + urlDNSInfo.host + "ip:" + urlDNSInfo.ip + "t:" + urlDNSInfo.dnsTime);
                }
            }
            return stringBuffer.toString();
        }
        return (String) invokeV.objValue;
    }
}
