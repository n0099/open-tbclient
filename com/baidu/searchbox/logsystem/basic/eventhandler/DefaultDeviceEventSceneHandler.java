package com.baidu.searchbox.logsystem.basic.eventhandler;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.logsystem.logsys.eventscene.EventObject;
import com.baidu.searchbox.logsystem.logsys.eventscene.handler.DeviceEventSceneHandler;
import com.baidu.searchbox.logsystem.logsys.eventscene.snapshot.DeviceSnapshotType;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes3.dex */
public class DefaultDeviceEventSceneHandler extends DeviceEventSceneHandler {
    @Override // com.baidu.searchbox.logsystem.logsys.eventscene.handler.DeviceEventSceneHandler, com.baidu.searchbox.logsystem.logsys.eventscene.handler.BaseEventSceneHandler, com.baidu.searchbox.logsystem.logsys.eventscene.handler.EventSceneHandler
    @Nullable
    public Set<DeviceSnapshotType> requireGeneralSnapshots(@NonNull Context context, @NonNull EventObject eventObject) {
        HashSet hashSet = new HashSet(4);
        hashSet.add(DeviceSnapshotType.DEVICE_APP_LOGCAT);
        hashSet.add(DeviceSnapshotType.DEVICE_BUILD_PROC);
        hashSet.add(DeviceSnapshotType.DEVICE_INFO);
        hashSet.add(DeviceSnapshotType.DEVICE_LINUX_KERNEL_VERSION);
        return hashSet;
    }
}
