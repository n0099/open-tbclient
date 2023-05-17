package com.baidu.searchbox.elasticthread.statistic;
/* loaded from: classes3.dex */
public interface Recordable {

    /* loaded from: classes3.dex */
    public enum RecordStatus {
        UNINITIATED,
        RECORDING,
        RECORD_END
    }

    void onRecordBegin();

    void onRecordEnd();
}
