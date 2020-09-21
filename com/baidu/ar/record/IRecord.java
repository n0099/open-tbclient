package com.baidu.ar.record;
/* loaded from: classes10.dex */
public interface IRecord {
    void pauseRecord();

    void resumeRecord();

    void startRecord(String str, long j, RecordCallback recordCallback);

    void stopRecord();
}
