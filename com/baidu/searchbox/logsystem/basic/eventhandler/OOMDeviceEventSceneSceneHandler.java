package com.baidu.searchbox.logsystem.basic.eventhandler;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.baidu.searchbox.logsystem.logsys.eventscene.EventObject;
import com.baidu.searchbox.logsystem.logsys.eventscene.handler.DeviceEventSceneHandler;
import com.baidu.searchbox.logsystem.logsys.eventscene.snapshot.DeviceSnapshotType;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes11.dex */
public class OOMDeviceEventSceneSceneHandler extends DeviceEventSceneHandler {
    private static final String EGL_BAD_ALLOC = "EGL_BAD_ALLOC";
    protected static final String OOM = "java.lang.OutOfMemoryError";

    @Override // com.baidu.searchbox.logsystem.logsys.eventscene.handler.DeviceEventSceneHandler, com.baidu.searchbox.logsystem.logsys.eventscene.handler.BaseEventSceneHandler, com.baidu.searchbox.logsystem.logsys.eventscene.handler.EventSceneHandler
    @Nullable
    public Set<DeviceSnapshotType> requireGeneralSnapshots(@NonNull Context context, @NonNull EventObject eventObject) {
        HashSet hashSet = null;
        if (eventObject.mEventLog.contains(OOM) && 0 == 0) {
            hashSet = new HashSet(1);
            hashSet.add(DeviceSnapshotType.DEVICE_APP_DB_INFO);
            if (eventObject.mEventLog.contains(EGL_BAD_ALLOC)) {
                if (hashSet == null) {
                    hashSet = new HashSet(2);
                }
                hashSet.add(DeviceSnapshotType.DEVICE_GUP_MEM);
                hashSet.add(DeviceSnapshotType.DEVICE_ION_MEM);
            }
        }
        return hashSet;
    }
}
