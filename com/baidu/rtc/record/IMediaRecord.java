package com.baidu.rtc.record;
/* loaded from: classes2.dex */
public interface IMediaRecord {
    void startRecording(String str, MediaEncodeParams mediaEncodeParams, RecorderCallback recorderCallback);

    void stopRecording();
}
