package com.baidu.searchbox.elasticthread.statistic;
/* loaded from: classes13.dex */
public interface Recordable {

    /* loaded from: classes13.dex */
    public enum RecordStatus {
        UNINITIATED,
        RECORDING,
        RECORD_END
    }

    void onRecordBegin();

    void onRecordEnd();
}
