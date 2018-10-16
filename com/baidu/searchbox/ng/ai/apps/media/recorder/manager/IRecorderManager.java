package com.baidu.searchbox.ng.ai.apps.media.recorder.manager;

import android.content.Context;
import com.baidu.searchbox.ng.ai.apps.media.recorder.listener.TimeOutListener;
/* loaded from: classes2.dex */
public interface IRecorderManager {
    void cancelTimer();

    boolean hasRecordPermission(Context context);

    void onAiAppForegroundChange(boolean z);

    void pauseRecord();

    void pauseTimer();

    void resumeRecord();

    void resumeTimer();

    boolean saveRecord();

    void startRecord(boolean z);

    void startTimer(TimeOutListener timeOutListener);

    void stopRecord();

    void stopTimer();
}
