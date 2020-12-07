package com.baidu.searchbox.logsystem.basic.eventhandler;

import android.content.Context;
import android.support.annotation.NonNull;
import com.baidu.searchbox.logsystem.logsys.eventscene.EventObject;
import com.baidu.searchbox.logsystem.logsys.eventscene.handler.DeviceEventSceneHandler;
import com.baidu.searchbox.logsystem.logsys.eventscene.snapshot.DeviceSnapshotType;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes11.dex */
public class SQLiteFullSceneHandler extends DeviceEventSceneHandler {
    private static final String SQLITE_FULL = "android.database.sqlite.SQLiteFullException";

    @Override // com.baidu.searchbox.logsystem.logsys.eventscene.handler.DeviceEventSceneHandler, com.baidu.searchbox.logsystem.logsys.eventscene.handler.BaseEventSceneHandler, com.baidu.searchbox.logsystem.logsys.eventscene.handler.EventSceneHandler
    public Set<DeviceSnapshotType> requireGeneralSnapshots(@NonNull Context context, @NonNull EventObject eventObject) {
        if (eventObject.mEventLog.contains(SQLITE_FULL)) {
            HashSet hashSet = new HashSet(1);
            hashSet.add(DeviceSnapshotType.DEVICE_APP_DB_INFO);
            return hashSet;
        }
        return null;
    }
}
