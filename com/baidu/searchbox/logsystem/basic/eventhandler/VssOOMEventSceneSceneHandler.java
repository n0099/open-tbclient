package com.baidu.searchbox.logsystem.basic.eventhandler;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.logsystem.logsys.eventscene.EventObject;
import com.baidu.searchbox.logsystem.logsys.eventscene.snapshot.ProcessSnapshotType;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes6.dex */
public class VssOOMEventSceneSceneHandler extends OOMEventSceneSceneHandler {
    private static final String CWA = "android.database.CursorWindowAllocationException: Cursor window allocation";
    private static final String PC = "pthread_create";

    @Override // com.baidu.searchbox.logsystem.basic.eventhandler.OOMEventSceneSceneHandler, com.baidu.searchbox.logsystem.logsys.eventscene.handler.ProcessEventSceneHandler, com.baidu.searchbox.logsystem.logsys.eventscene.handler.BaseEventSceneHandler, com.baidu.searchbox.logsystem.logsys.eventscene.handler.EventSceneHandler
    @Nullable
    public Set<ProcessSnapshotType> requireGeneralSnapshots(@NonNull Context context, @NonNull EventObject eventObject) {
        Set<ProcessSnapshotType> set = null;
        String str = eventObject.mEventLog;
        if ((str.contains("java.lang.OutOfMemoryError") && str.contains(PC)) || str.contains(CWA)) {
            set = super.requireGeneralSnapshots(context, eventObject);
            if (set == null) {
                set = new HashSet<>(4);
            }
            set.add(ProcessSnapshotType.PROCESS_SMAPS);
            set.add(ProcessSnapshotType.PROCESS_MAPS);
            set.add(ProcessSnapshotType.PROCESS_THREAD_LIST);
            set.add(ProcessSnapshotType.PROCESS_FILE_DESCRIPTOR);
        }
        return set;
    }
}
