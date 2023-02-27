package com.baidu.swan.apps.core.launchtips.monitor.request;

import com.baidu.searchbox.dns.transmit.model.DnsModel;
/* loaded from: classes3.dex */
public enum RequestStatus {
    STATUS_SEND("send"),
    STATUS_SUCCESS(DnsModel.MSG_OK),
    STATUS_FAILED("failRate"),
    STATUS_UNKNOWN("unknown"),
    STATUS_SLOW("slow"),
    STATUS_CORE_FAILED("coreFail"),
    STATUS_SERVER_FAILED("serverRate");
    
    public final String mStatus;

    RequestStatus(String str) {
        this.mStatus = str;
    }

    public String getStatus() {
        return this.mStatus;
    }
}
