package com.baidu.searchbox.http.statistics;
/* loaded from: classes6.dex */
public interface NetworkInfoRecord {
    void doRecord(NetworkStatRecord networkStatRecord);

    boolean shouldRecord();
}
