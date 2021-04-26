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

    public synchronized BundleInfo getBundleByType(int i2) {
        return this.bundleInfoMap.get(Integer.valueOf(i2));
    }

    public synchronized long getTimeStamp() {
        return this.timeStamp;
    }

    public synchronized void removeBundleByType(int i2) {
        this.bundleInfoMap.remove(Integer.valueOf(i2));
    }

    public synchronized void setTimeStamp(long j) {
        this.timeStamp = j;
    }

    public synchronized void swapBundleByType(int i2, int i3) {
        BundleInfo remove = this.bundleInfoMap.remove(Integer.valueOf(i2));
        if (remove != null) {
            this.bundleInfoMap.put(Integer.valueOf(i3), remove);
        }
    }

    public synchronized void updateBundleByType(int i2, BundleInfo bundleInfo) {
        bundleInfo.setType(i2);
        this.bundleInfoMap.put(Integer.valueOf(i2), bundleInfo);
    }
}
