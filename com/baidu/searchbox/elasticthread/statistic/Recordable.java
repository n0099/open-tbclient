package com.baidu.searchbox.elasticthread.statistic;
/* loaded from: classes6.dex */
public interface Recordable {

    /* loaded from: classes6.dex */
    public enum RecordStatus {
        UNINITIATED,
        RECORDING,
        RECORD_END
    }

    void onRecordBegin();

    void onRecordEnd();
}
