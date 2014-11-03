package com.baidu.tbadk.core.util.httpNet;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class CdnCacheItem implements Serializable {
    private static final long serialVersionUID = 6622778689529331355L;
    private ArrayList<TBIPListItem> ipList;
    private static Object mLock = new Object();
    private static Object FP = new Object();
    private boolean isUsedIp = false;
    public long lastTachometerTime = 0;
    public long firstUseIpTime = 0;
    public String ssid = null;
    private int cdnDomainRank = 0;
    private HashMap<String, String> ipHashMap = new HashMap<>();

    public CdnCacheItem() {
        this.ipList = null;
        this.ipList = new ArrayList<>();
    }

    public String getIpString(int i) {
        String str;
        if (this.isUsedIp) {
            if (this.ipList == null || this.ipList.size() == 0) {
                return null;
            }
            synchronized (mLock) {
                int size = i % this.ipList.size();
                if (size >= this.ipList.size()) {
                    str = null;
                } else {
                    TBIPListItem tBIPListItem = this.ipList.get(size);
                    str = tBIPListItem == null ? null : tBIPListItem.cdnIp;
                }
            }
            return str;
        }
        return null;
    }

    public int setIPRank(int i, float f, String str) {
        int i2;
        TBIPListItem tBIPListItem;
        if (str == null) {
            return -1;
        }
        synchronized (mLock) {
            int size = this.ipList.size();
            int i3 = 0;
            while (true) {
                if (i3 >= size) {
                    i2 = 0;
                    tBIPListItem = null;
                    break;
                }
                TBIPListItem tBIPListItem2 = this.ipList.get(i3);
                if (str.equalsIgnoreCase(tBIPListItem2.cdnIp)) {
                    int i4 = i3;
                    tBIPListItem = tBIPListItem2;
                    i2 = i4;
                    break;
                }
                i3++;
            }
            if (tBIPListItem == null) {
                return -1;
            }
            tBIPListItem.ipRank += i;
            if (tBIPListItem.ipRank >= f) {
                this.ipHashMap.remove(tBIPListItem.cdnIp);
                this.ipList.remove(i2);
            }
            if (tBIPListItem.ipRank < 0) {
                tBIPListItem.ipRank = 0;
            }
            if (this.ipList.size() == 0) {
                this.isUsedIp = false;
            }
            return tBIPListItem.ipRank;
        }
    }

    public int setCdnDomainRank(int i, float f) {
        int i2;
        synchronized (FP) {
            this.cdnDomainRank += i;
            if (this.cdnDomainRank < 0) {
                this.cdnDomainRank = 0;
            }
            i2 = this.cdnDomainRank;
            if (this.cdnDomainRank > f) {
                this.cdnDomainRank = 0;
                this.isUsedIp = true;
            }
        }
        return i2;
    }

    public boolean hasImageProblem() {
        return this.cdnDomainRank > 0 || this.isUsedIp;
    }

    public boolean getIsUsedIp() {
        return this.isUsedIp;
    }

    /* loaded from: classes.dex */
    class TBIPListItem implements Serializable {
        private static final long serialVersionUID = -99289965442562023L;
        public String cdnIp;
        public int ipRank;

        private TBIPListItem() {
            this.ipRank = 0;
        }

        /* synthetic */ TBIPListItem(CdnCacheItem cdnCacheItem, TBIPListItem tBIPListItem) {
            this();
        }
    }

    public void setIpList(ArrayList<String> arrayList, boolean z, boolean z2) {
        if (arrayList != null && arrayList.size() != 0) {
            synchronized (mLock) {
                if (z2) {
                    this.ipList.clear();
                    this.ipHashMap.clear();
                }
                this.isUsedIp = z;
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    String str = arrayList.get(i);
                    if (this.ipHashMap.get(str) == null) {
                        TBIPListItem tBIPListItem = new TBIPListItem(this, null);
                        tBIPListItem.cdnIp = str;
                        this.ipList.add(tBIPListItem);
                        this.ipHashMap.put(str, "1");
                    }
                }
            }
        }
    }
}
