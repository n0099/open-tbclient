package com.baidu.ar.record;

import com.baidu.ar.bean.Watermark;
/* loaded from: classes3.dex */
public interface IRecord {
    void pauseRecord();

    void resumeRecord();

    void setRecordWatermark(Watermark watermark);

    void startRecord(String str, long j2, RecordCallback recordCallback);

    void stopRecord();
}
