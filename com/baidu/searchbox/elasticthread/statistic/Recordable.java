package com.baidu.searchbox.elasticthread.statistic;
/* loaded from: classes16.dex */
public interface Recordable {

    /* loaded from: classes16.dex */
    public enum RecordStatus {
        UNINITIATED,
        RECORDING,
        RECORD_END
    }

    void onRecordBegin();

    void onRecordEnd();
}
