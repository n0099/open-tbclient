package com.baidu.searchbox.logsystem.basic.eventhandler;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.logsystem.logsys.eventscene.EventObject;
import com.baidu.searchbox.logsystem.logsys.eventscene.handler.ProcessEventSceneHandler;
import com.baidu.searchbox.logsystem.logsys.eventscene.snapshot.ProcessSnapshotType;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes5.dex */
public class DefaultProcessEventSceneHandler extends ProcessEventSceneHandler {
    public static void init() {
    }

    @Override // com.baidu.searchbox.logsystem.logsys.eventscene.handler.ProcessEventSceneHandler, com.baidu.searchbox.logsystem.logsys.eventscene.handler.BaseEventSceneHandler, com.baidu.searchbox.logsystem.logsys.eventscene.handler.EventSceneHandler
    @Nullable
    public Set<ProcessSnapshotType> requireGeneralSnapshots(@NonNull Context context, @NonNull EventObject eventObject) {
        HashSet hashSet = new HashSet(3);
        hashSet.add(ProcessSnapshotType.PROCESS_UI_TRACE);
        hashSet.add(ProcessSnapshotType.PROCESS_RUNNING_STATUS);
        hashSet.add(ProcessSnapshotType.PROCESS_STATUS);
        return hashSet;
    }
}
