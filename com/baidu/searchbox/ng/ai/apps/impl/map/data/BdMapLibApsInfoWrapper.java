package com.baidu.searchbox.ng.ai.apps.impl.map.data;

import com.baidu.searchbox.bdmapsdk.BdMapLibLoader;
/* loaded from: classes4.dex */
public class BdMapLibApsInfoWrapper {
    public BdMapLibLoader.OnFetchMapLibCallback mMapCallback;
    public BdMapLibApsInfo mMapInfo;

    private BdMapLibApsInfoWrapper() {
    }

    public static BdMapLibApsInfoWrapper wrapBdMapLibApsInfo(BdMapLibApsInfo bdMapLibApsInfo, BdMapLibLoader.OnFetchMapLibCallback onFetchMapLibCallback) {
        BdMapLibApsInfoWrapper bdMapLibApsInfoWrapper = new BdMapLibApsInfoWrapper();
        bdMapLibApsInfoWrapper.mMapInfo = bdMapLibApsInfo;
        bdMapLibApsInfoWrapper.mMapCallback = onFetchMapLibCallback;
        return bdMapLibApsInfoWrapper;
    }

    public boolean validateSuccess() {
        return this.mMapInfo != null;
    }

    public boolean isMainProcess() {
        return this.mMapInfo != null && this.mMapInfo.isMainProcess();
    }

    public String toString() {
        return this.mMapInfo != null ? this.mMapInfo.toString() : " mapInfo is empty!";
    }
}
