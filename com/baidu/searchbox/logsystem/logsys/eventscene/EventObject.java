package com.baidu.searchbox.logsystem.logsys.eventscene;

import android.support.annotation.NonNull;
import com.baidu.searchbox.logsystem.logsys.LogType;
/* loaded from: classes9.dex */
public class EventObject {
    @NonNull
    public final String mEventLog;
    @NonNull
    public final LogType mEventType;

    public EventObject(@NonNull LogType logType, @NonNull String str) {
        this.mEventType = logType;
        this.mEventLog = str;
    }
}
