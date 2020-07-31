package com.baidu.searchbox.elasticthread.statistic;
/* loaded from: classes5.dex */
public interface Recordable {

    /* loaded from: classes5.dex */
    public enum RecordStatus {
        UNINITIATED,
        RECORDING,
        RECORD_END
    }

    void onRecordBegin();

    void onRecordEnd();
}
