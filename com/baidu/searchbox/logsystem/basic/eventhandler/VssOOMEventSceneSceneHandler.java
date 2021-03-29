package com.baidu.searchbox.logsystem.basic.eventhandler;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.logsystem.logsys.eventscene.EventObject;
import com.baidu.searchbox.logsystem.logsys.eventscene.snapshot.ProcessSnapshotType;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes2.dex */
public class VssOOMEventSceneSceneHandler extends OOMEventSceneSceneHandler {
    public static final String CWA = "android.database.CursorWindowAllocationException: Cursor window allocation";
    public static final String PC = "pthread_create";

    @Override // com.baidu.searchbox.logsystem.basic.eventhandler.OOMEventSceneSceneHandler, com.baidu.searchbox.logsystem.logsys.eventscene.handler.ProcessEventSceneHandler, com.baidu.searchbox.logsystem.logsys.eventscene.handler.BaseEventSceneHandler, com.baidu.searchbox.logsystem.logsys.eventscene.handler.EventSceneHandler
    @Nullable
    public Set<ProcessSnapshotType> requireGeneralSnapshots(@NonNull Context context, @NonNull EventObject eventObject) {
        String str = eventObject.mEventLog;
        if ((str.contains("java.lang.OutOfMemoryError") && str.contains(PC)) || str.contains(CWA)) {
            Set<ProcessSnapshotType> requireGeneralSnapshots = super.requireGeneralSnapshots(context, eventObject);
            if (requireGeneralSnapshots == null) {
                requireGeneralSnapshots = new HashSet<>(4);
            }
            requireGeneralSnapshots.add(ProcessSnapshotType.PROCESS_SMAPS);
            requireGeneralSnapshots.add(ProcessSnapshotType.PROCESS_MAPS);
            requireGeneralSnapshots.add(ProcessSnapshotType.PROCESS_THREAD_LIST);
            requireGeneralSnapshots.add(ProcessSnapshotType.PROCESS_FILE_DESCRIPTOR);
            return requireGeneralSnapshots;
        }
        return null;
    }
}
