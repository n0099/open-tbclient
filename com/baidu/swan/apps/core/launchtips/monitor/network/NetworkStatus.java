package com.baidu.swan.apps.core.launchtips.monitor.network;

import com.baidu.tbadk.core.atomData.FrsActivityConfig;
/* loaded from: classes3.dex */
public enum NetworkStatus {
    NETWORK_GOOD(1, FrsActivityConfig.GOOD, "网络：正常；"),
    NETWORK_BAD(2, "bad", "网络：弱网；"),
    NETWORK_OFFLINE(3, "offline", "网络：离线；"),
    NETWORK_UNKNOWN(-1, "unknown", "网络：未知；");
    
    public final String mDesc;
    public final int mQuality;
    public final String mStatus;

    NetworkStatus(int i, String str, String str2) {
        this.mQuality = i;
        this.mStatus = str;
        this.mDesc = str2;
    }

    public String getDesc() {
        return this.mDesc;
    }

    public int getQuality() {
        return this.mQuality;
    }

    public String getStatus() {
        return this.mStatus;
    }
}
