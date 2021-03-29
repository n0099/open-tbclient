package com.baidu.nps.pm;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class BundleInfoGroup {
    public Map<Integer, BundleInfo> bundleInfoMap = new HashMap();
    public long timeStamp;

    public BundleInfoGroup(long j) {
        this.timeStamp = 0L;
        this.timeStamp = j;
    }

    public synchronized BundleInfo getBundleByType(int i) {
        return this.bundleInfoMap.get(Integer.valueOf(i));
    }

    public synchronized long getTimeStamp() {
        return this.timeStamp;
    }

    public synchronized void removeBundleByType(int i) {
        this.bundleInfoMap.remove(Integer.valueOf(i));
    }

    public synchronized void setTimeStamp(long j) {
        this.timeStamp = j;
    }

    public synchronized void swapBundleByType(int i, int i2) {
        BundleInfo remove = this.bundleInfoMap.remove(Integer.valueOf(i));
        if (remove != null) {
            this.bundleInfoMap.put(Integer.valueOf(i2), remove);
        }
    }

    public synchronized void updateBundleByType(int i, BundleInfo bundleInfo) {
        bundleInfo.setType(i);
        this.bundleInfoMap.put(Integer.valueOf(i), bundleInfo);
    }
}
