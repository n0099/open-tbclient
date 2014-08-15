package com.baidu.tbadk.core.util.httpNet;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class CdnCacheItem implements Serializable {
    private static final long serialVersionUID = 6622778689529331355L;
    public ArrayList<String> ipList;
    public boolean isUsedIp = false;
    public long lastTachometerTime = 0;
    public int currentUseIpPos = 0;
    public long firstUseIpTime = 0;
    public String ssid = null;

    public CdnCacheItem() {
        this.ipList = null;
        this.ipList = new ArrayList<>();
    }
}
