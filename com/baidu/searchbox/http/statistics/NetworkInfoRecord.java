package com.baidu.searchbox.http.statistics;
/* loaded from: classes11.dex */
public interface NetworkInfoRecord {
    void doRecord(NetworkStatRecord networkStatRecord);

    boolean shouldRecord();
}
