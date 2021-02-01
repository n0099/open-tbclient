package com.baidu.down.common;

import java.util.List;
/* loaded from: classes4.dex */
public class DownDetail {
    public static final int RETRY_STRATEGY_DOWNFLOW_FAIL = 2;
    public static final int RETRY_STRATEGY_DOWNFLOW_FAIL_DATA_NO_MATCH = 5;
    public static final int RETRY_STRATEGY_DOWNFLOW_FAIL_NET_ERROR = 6;
    public static final int RETRY_STRATEGY_DOWNFLOW_SUCCESS = 1;
    public static final int RETRY_STRATEGY_FAIL = 4;
    public static final int RETRY_STRATEGY_NO = 0;
    public static final int RETRY_STRATEGY_SUCCESS = 3;
    public String allInfo;
    public List<UrlDNSInfo> domainNameAndIpInfo;
    public String extendInfo;
    public String retryException;
    public String retryStrategyInfo;
    public int retryType = 0;
    public int extendType = 0;

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[retryType=").append(this.retryType).append("]").append("[retryException=").append(this.retryException).append("]").append("[retryStrategyInfo=").append(this.retryStrategyInfo).append("]").append("[extendType=").append(this.extendType).append("]").append("[extendInfo=").append(this.extendInfo).append("[allInfo=").append(this.allInfo).append("]");
        if (this.domainNameAndIpInfo != null && !this.domainNameAndIpInfo.isEmpty()) {
            for (UrlDNSInfo urlDNSInfo : this.domainNameAndIpInfo) {
                stringBuffer.append("host:" + urlDNSInfo.host + "ip:" + urlDNSInfo.ip + "t:" + urlDNSInfo.dnsTime);
            }
        }
        return stringBuffer.toString();
    }
}
