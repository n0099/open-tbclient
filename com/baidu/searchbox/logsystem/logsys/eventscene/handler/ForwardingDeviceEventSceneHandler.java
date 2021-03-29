package com.baidu.searchbox.logsystem.logsys.eventscene.handler;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.logsystem.logsys.LogFile;
import com.baidu.searchbox.logsystem.logsys.eventscene.EventObject;
import com.baidu.searchbox.logsystem.logsys.eventscene.snapshot.DeviceSnapshotType;
import com.baidu.searchbox.logsystem.util.LLog;
import java.io.File;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
/* loaded from: classes2.dex */
public class ForwardingDeviceEventSceneHandler extends DeviceEventSceneHandler {
    public static final String TAG = "ForwardingCrash";
    public final List<DeviceEventSceneHandler> mEventSceneHandlers = new LinkedList();

    public ForwardingDeviceEventSceneHandler(@NonNull List<DeviceEventSceneHandler> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        for (DeviceEventSceneHandler deviceEventSceneHandler : list) {
            if (deviceEventSceneHandler != null) {
                this.mEventSceneHandlers.add(deviceEventSceneHandler);
            }
        }
    }

    public ForwardingDeviceEventSceneHandler addEventHandleCallback(@NonNull DeviceEventSceneHandler deviceEventSceneHandler) {
        if (deviceEventSceneHandler != null) {
            this.mEventSceneHandlers.add(deviceEventSceneHandler);
        } else if (LLog.sDebug) {
            Log.d("ForwardingCrash", "callback instance should not be null in addEventHandleCallback()");
        }
        return this;
    }

    @Override // com.baidu.searchbox.logsystem.logsys.eventscene.handler.BaseEventSceneHandler, com.baidu.searchbox.logsystem.logsys.eventscene.handler.EventSceneHandler
    @Nullable
    public Set<LogFile> getCustomizedSnapshots(@NonNull Context context, @NonNull File file, @NonNull EventObject eventObject) {
        if (context == null && LLog.sDebug) {
            Log.d("ForwardingCrash", "Context is null in ForwardingEventSceneHandler.getCustomizedSnapshots.");
        }
        HashSet hashSet = null;
        for (DeviceEventSceneHandler deviceEventSceneHandler : this.mEventSceneHandlers) {
            if (deviceEventSceneHandler != null) {
                try {
                    Set<LogFile> customizedSnapshots = deviceEventSceneHandler.getCustomizedSnapshots(context, file, eventObject);
                    if (customizedSnapshots != null && customizedSnapshots.size() > 0) {
                        if (hashSet == null) {
                            hashSet = new HashSet(customizedSnapshots.size());
                        }
                        hashSet.addAll(customizedSnapshots);
                    }
                } catch (Exception e2) {
                    if (LLog.sDebug) {
                        Log.d("ForwardingCrash", Log.getStackTraceString(e2));
                    }
                }
            }
        }
        return hashSet;
    }

    @Override // com.baidu.searchbox.logsystem.logsys.eventscene.handler.DeviceEventSceneHandler, com.baidu.searchbox.logsystem.logsys.eventscene.handler.BaseEventSceneHandler, com.baidu.searchbox.logsystem.logsys.eventscene.handler.EventSceneHandler
    @Nullable
    public Set<DeviceSnapshotType> requireGeneralSnapshots(@NonNull Context context, @NonNull EventObject eventObject) {
        HashSet hashSet = null;
        for (DeviceEventSceneHandler deviceEventSceneHandler : this.mEventSceneHandlers) {
            if (deviceEventSceneHandler != null) {
                try {
                    Set<DeviceSnapshotType> requireGeneralSnapshots = deviceEventSceneHandler.requireGeneralSnapshots(context, eventObject);
                    if (requireGeneralSnapshots != null && requireGeneralSnapshots.size() > 0) {
                        if (hashSet == null) {
                            hashSet = new HashSet(5);
                        }
                        hashSet.addAll(requireGeneralSnapshots);
                    }
                } catch (Exception e2) {
                    if (LLog.sDebug) {
                        Log.d("ForwardingCrash", Log.getStackTraceString(e2));
                    }
                }
            }
        }
        return hashSet;
    }

    @Override // com.baidu.searchbox.logsystem.logsys.eventscene.handler.BaseEventSceneHandler, com.baidu.searchbox.logsystem.logsys.eventscene.handler.EventSceneHandler
    public boolean saveFragmentSnapshot(@NonNull Context context, @NonNull EventObject eventObject, @NonNull File file) {
        while (true) {
            boolean z = false;
            for (DeviceEventSceneHandler deviceEventSceneHandler : this.mEventSceneHandlers) {
                if (deviceEventSceneHandler != null) {
                    try {
                        boolean saveFragmentSnapshot = deviceEventSceneHandler.saveFragmentSnapshot(context, eventObject, file);
                        if (z || saveFragmentSnapshot) {
                            z = true;
                        }
                    } catch (Exception e2) {
                        if (LLog.sDebug) {
                            Log.d("ForwardingCrash", Log.getStackTraceString(e2));
                        }
                    }
                }
            }
            return z;
        }
    }

    public ForwardingDeviceEventSceneHandler addEventHandleCallback(@NonNull List<DeviceEventSceneHandler> list) {
        if (list != null && list.size() > 0) {
            for (DeviceEventSceneHandler deviceEventSceneHandler : list) {
                if (deviceEventSceneHandler != null) {
                    this.mEventSceneHandlers.add(deviceEventSceneHandler);
                }
            }
        }
        return this;
    }

    public ForwardingDeviceEventSceneHandler(@NonNull DeviceEventSceneHandler... deviceEventSceneHandlerArr) {
        if (deviceEventSceneHandlerArr == null || deviceEventSceneHandlerArr.length <= 0) {
            return;
        }
        for (DeviceEventSceneHandler deviceEventSceneHandler : deviceEventSceneHandlerArr) {
            if (deviceEventSceneHandler != null) {
                this.mEventSceneHandlers.add(deviceEventSceneHandler);
            }
        }
    }

    public ForwardingDeviceEventSceneHandler() {
    }
}
