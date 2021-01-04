package com.baidu.searchbox.logsystem.logsys.eventscene.handler;

import android.content.Context;
import androidx.annotation.NonNull;
import com.baidu.searchbox.logsystem.logsys.eventscene.EventObject;
import com.baidu.searchbox.logsystem.logsys.eventscene.snapshot.DeviceSnapshotType;
import java.util.Set;
/* loaded from: classes6.dex */
public class DeviceEventSceneHandler extends BaseEventSceneHandler {
    @Override // com.baidu.searchbox.logsystem.logsys.eventscene.handler.BaseEventSceneHandler, com.baidu.searchbox.logsystem.logsys.eventscene.handler.EventSceneHandler
    public Set<DeviceSnapshotType> requireGeneralSnapshots(@NonNull Context context, @NonNull EventObject eventObject) {
        return null;
    }
}
