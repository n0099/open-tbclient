package com.baidu.searchbox.logsystem.basic.eventhandler;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.logsystem.logsys.eventscene.EventObject;
import com.baidu.searchbox.logsystem.logsys.eventscene.handler.DeviceEventSceneHandler;
import com.baidu.searchbox.logsystem.logsys.eventscene.snapshot.DeviceSnapshotType;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes2.dex */
public class OOMDeviceEventSceneSceneHandler extends DeviceEventSceneHandler {
    public static final String EGL_BAD_ALLOC = "EGL_BAD_ALLOC";
    public static final String OOM = "java.lang.OutOfMemoryError";

    @Override // com.baidu.searchbox.logsystem.logsys.eventscene.handler.DeviceEventSceneHandler, com.baidu.searchbox.logsystem.logsys.eventscene.handler.BaseEventSceneHandler, com.baidu.searchbox.logsystem.logsys.eventscene.handler.EventSceneHandler
    @Nullable
    public Set<DeviceSnapshotType> requireGeneralSnapshots(@NonNull Context context, @NonNull EventObject eventObject) {
        if (eventObject.mEventLog.contains("java.lang.OutOfMemoryError")) {
            HashSet hashSet = new HashSet(1);
            hashSet.add(DeviceSnapshotType.DEVICE_APP_DB_INFO);
            if (eventObject.mEventLog.contains(EGL_BAD_ALLOC)) {
                hashSet.add(DeviceSnapshotType.DEVICE_GUP_MEM);
                hashSet.add(DeviceSnapshotType.DEVICE_ION_MEM);
                return hashSet;
            }
            return hashSet;
        }
        return null;
    }
}
