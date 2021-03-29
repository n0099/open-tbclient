package com.baidu.down.common;

import java.util.List;
/* loaded from: classes.dex */
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
        stringBuffer.append("[retryType=");
        stringBuffer.append(this.retryType);
        stringBuffer.append("]");
        stringBuffer.append("[retryException=");
        stringBuffer.append(this.retryException);
        stringBuffer.append("]");
        stringBuffer.append("[retryStrategyInfo=");
        stringBuffer.append(this.retryStrategyInfo);
        stringBuffer.append("]");
        stringBuffer.append("[extendType=");
        stringBuffer.append(this.extendType);
        stringBuffer.append("]");
        stringBuffer.append("[extendInfo=");
        stringBuffer.append(this.extendInfo);
        stringBuffer.append("[allInfo=");
        stringBuffer.append(this.allInfo);
        stringBuffer.append("]");
        List<UrlDNSInfo> list = this.domainNameAndIpInfo;
        if (list != null && !list.isEmpty()) {
            for (UrlDNSInfo urlDNSInfo : this.domainNameAndIpInfo) {
                stringBuffer.append("host:" + urlDNSInfo.host + "ip:" + urlDNSInfo.ip + "t:" + urlDNSInfo.dnsTime);
            }
        }
        return stringBuffer.toString();
    }
}
