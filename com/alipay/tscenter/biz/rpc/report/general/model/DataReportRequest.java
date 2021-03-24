package com.alipay.tscenter.biz.rpc.report.general.model;

import java.io.Serializable;
import java.util.Map;
/* loaded from: classes.dex */
public class DataReportRequest implements Serializable {
    public Map<String, String> bizData;
    public String bizType;
    public Map<String, String> deviceData;
    public String os;
    public String rpcVersion;
}
