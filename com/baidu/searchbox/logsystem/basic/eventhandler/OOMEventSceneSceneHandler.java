package com.baidu.searchbox.logsystem.basic.eventhandler;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.logsystem.logsys.eventscene.EventObject;
import com.baidu.searchbox.logsystem.logsys.eventscene.handler.ProcessEventSceneHandler;
import com.baidu.searchbox.logsystem.logsys.eventscene.snapshot.ProcessSnapshotType;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes6.dex */
public class OOMEventSceneSceneHandler extends ProcessEventSceneHandler {
    protected static final String OOM = "java.lang.OutOfMemoryError";

    @Override // com.baidu.searchbox.logsystem.logsys.eventscene.handler.ProcessEventSceneHandler, com.baidu.searchbox.logsystem.logsys.eventscene.handler.BaseEventSceneHandler, com.baidu.searchbox.logsystem.logsys.eventscene.handler.EventSceneHandler
    @Nullable
    public Set<ProcessSnapshotType> requireGeneralSnapshots(@NonNull Context context, @NonNull EventObject eventObject) {
        if (!eventObject.mEventLog.contains(OOM) || 0 != 0) {
            return null;
        }
        HashSet hashSet = new HashSet(1);
        hashSet.add(ProcessSnapshotType.PROCESS_MEMORY_STATUS);
        return hashSet;
    }
}
