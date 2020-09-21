package com.baidu.live.adp.lib.stats;
/* loaded from: classes4.dex */
public class AlaStatManager {
    private static volatile AlaStatManager statisticsManager = null;
    private IAlaStatUploader uploader;

    public static AlaStatManager getInstance() {
        if (statisticsManager == null) {
            synchronized (AlaStatManager.class) {
                if (statisticsManager == null) {
                    statisticsManager = new AlaStatManager();
                }
            }
        }
        return statisticsManager;
    }

    public synchronized void setUploader(IAlaStatUploader iAlaStatUploader) {
        this.uploader = iAlaStatUploader;
    }

    private void addLog(String str, String str2, long j, String str3, AlaStatsItem alaStatsItem) {
        if (this.uploader != null && alaStatsItem != null) {
            alaStatsItem.parentType = str;
            alaStatsItem.childType = str2;
            this.uploader.addLog(str, str2, j, str3, alaStatsItem);
        }
    }

    public void forceUpload() {
        if (this.uploader != null) {
            this.uploader.forceUpload();
        }
    }

    public void debug(String str, Object... objArr) {
        addLog("dbg", str, -1L, null, translate(objArr));
    }

    public void debug(String str, AlaStatsItem alaStatsItem) {
        if (alaStatsItem != null) {
            debug(str, -1L, null, alaStatsItem);
        }
    }

    public void debug(String str, long j, String str2, AlaStatsItem alaStatsItem) {
        addLog("dbg", str, j, str2, alaStatsItem);
    }

    public void newDebug(String str, long j, String str2, Object... objArr) {
        addLog("dbg", str, j, str2, translate(objArr));
    }

    private AlaStatsItem translate(Object... objArr) {
        int length = objArr.length;
        if (length % 2 == 0) {
            AlaStatsItem alaStatsItem = new AlaStatsItem();
            for (int i = 0; i < length; i += 2) {
                alaStatsItem.addValue(objArr[i], objArr[i + 1]);
            }
            return alaStatsItem;
        }
        return null;
    }
}
