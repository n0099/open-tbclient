package com.baidu.searchbox.logsystem.logsys.eventscene.handler;

import android.content.Context;
import android.support.annotation.NonNull;
import com.baidu.searchbox.logsystem.logsys.eventscene.EventObject;
import com.baidu.searchbox.logsystem.logsys.eventscene.snapshot.DeviceSnapshotType;
import java.util.Set;
/* loaded from: classes9.dex */
public class DeviceEventSceneHandler extends BaseEventSceneHandler {
    @Override // com.baidu.searchbox.logsystem.logsys.eventscene.handler.BaseEventSceneHandler, com.baidu.searchbox.logsystem.logsys.eventscene.handler.EventSceneHandler
    public Set<DeviceSnapshotType> requireGeneralSnapshots(@NonNull Context context, @NonNull EventObject eventObject) {
        return null;
    }
}
