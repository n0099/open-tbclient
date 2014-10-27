package com.baidu.tbadk.core.voice;
/* loaded from: classes.dex */
public interface n {
    void onDeletedVoice(String str);

    void onSendVoice(String str, int i);

    void onShowErr(int i, String str);

    void onShowRecordTime(int i);

    void onShowRecording(int i);

    void onStartedRecorder(boolean z);

    void onStopingRecorder();
}
