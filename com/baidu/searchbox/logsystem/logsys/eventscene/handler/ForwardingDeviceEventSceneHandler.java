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
/* loaded from: classes6.dex */
public class ForwardingDeviceEventSceneHandler extends DeviceEventSceneHandler {
    protected static final String TAG = "ForwardingCrash";
    private final List<DeviceEventSceneHandler> mEventSceneHandlers = new LinkedList();

    public ForwardingDeviceEventSceneHandler(@NonNull List<DeviceEventSceneHandler> list) {
        if (list != null && list.size() > 0) {
            for (DeviceEventSceneHandler deviceEventSceneHandler : list) {
                if (deviceEventSceneHandler != null) {
                    this.mEventSceneHandlers.add(deviceEventSceneHandler);
                }
            }
        }
    }

    public ForwardingDeviceEventSceneHandler(@NonNull DeviceEventSceneHandler... deviceEventSceneHandlerArr) {
        if (deviceEventSceneHandlerArr != null && deviceEventSceneHandlerArr.length > 0) {
            for (DeviceEventSceneHandler deviceEventSceneHandler : deviceEventSceneHandlerArr) {
                if (deviceEventSceneHandler != null) {
                    this.mEventSceneHandlers.add(deviceEventSceneHandler);
                }
            }
        }
    }

    public ForwardingDeviceEventSceneHandler() {
    }

    public ForwardingDeviceEventSceneHandler addEventHandleCallback(@NonNull DeviceEventSceneHandler deviceEventSceneHandler) {
        if (deviceEventSceneHandler != null) {
            this.mEventSceneHandlers.add(deviceEventSceneHandler);
        } else if (LLog.sDebug) {
            Log.d(TAG, "callback instance should not be null in addEventHandleCallback()");
        }
        return this;
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

    @Override // com.baidu.searchbox.logsystem.logsys.eventscene.handler.DeviceEventSceneHandler, com.baidu.searchbox.logsystem.logsys.eventscene.handler.BaseEventSceneHandler, com.baidu.searchbox.logsystem.logsys.eventscene.handler.EventSceneHandler
    @Nullable
    public Set<DeviceSnapshotType> requireGeneralSnapshots(@NonNull Context context, @NonNull EventObject eventObject) {
        HashSet hashSet;
        Set<DeviceSnapshotType> requireGeneralSnapshots;
        HashSet hashSet2 = null;
        for (DeviceEventSceneHandler deviceEventSceneHandler : this.mEventSceneHandlers) {
            if (deviceEventSceneHandler != null) {
                try {
                    requireGeneralSnapshots = deviceEventSceneHandler.requireGeneralSnapshots(context, eventObject);
                } catch (Exception e) {
                    e = e;
                    hashSet = hashSet2;
                }
                if (requireGeneralSnapshots != null && requireGeneralSnapshots.size() > 0) {
                    hashSet = hashSet2 == null ? new HashSet(5) : hashSet2;
                    try {
                        hashSet.addAll(requireGeneralSnapshots);
                    } catch (Exception e2) {
                        e = e2;
                        if (LLog.sDebug) {
                            Log.d(TAG, Log.getStackTraceString(e));
                        }
                        hashSet2 = hashSet;
                    }
                    hashSet2 = hashSet;
                }
            }
            hashSet = hashSet2;
            hashSet2 = hashSet;
        }
        return hashSet2;
    }

    @Override // com.baidu.searchbox.logsystem.logsys.eventscene.handler.BaseEventSceneHandler, com.baidu.searchbox.logsystem.logsys.eventscene.handler.EventSceneHandler
    @Nullable
    public Set<LogFile> getCustomizedSnapshots(@NonNull Context context, @NonNull File file, @NonNull EventObject eventObject) {
        HashSet hashSet;
        Set<LogFile> customizedSnapshots;
        if (context == null && LLog.sDebug) {
            Log.d(TAG, "Context is null in ForwardingEventSceneHandler.getCustomizedSnapshots.");
        }
        HashSet hashSet2 = null;
        for (DeviceEventSceneHandler deviceEventSceneHandler : this.mEventSceneHandlers) {
            if (deviceEventSceneHandler != null) {
                try {
                    customizedSnapshots = deviceEventSceneHandler.getCustomizedSnapshots(context, file, eventObject);
                } catch (Exception e) {
                    e = e;
                    hashSet = hashSet2;
                }
                if (customizedSnapshots != null && customizedSnapshots.size() > 0) {
                    hashSet = hashSet2 == null ? new HashSet(customizedSnapshots.size()) : hashSet2;
                    try {
                        hashSet.addAll(customizedSnapshots);
                    } catch (Exception e2) {
                        e = e2;
                        if (LLog.sDebug) {
                            Log.d(TAG, Log.getStackTraceString(e));
                        }
                        hashSet2 = hashSet;
                    }
                    hashSet2 = hashSet;
                }
            }
            hashSet = hashSet2;
            hashSet2 = hashSet;
        }
        return hashSet2;
    }

    @Override // com.baidu.searchbox.logsystem.logsys.eventscene.handler.BaseEventSceneHandler, com.baidu.searchbox.logsystem.logsys.eventscene.handler.EventSceneHandler
    public boolean saveFragmentSnapshot(@NonNull Context context, @NonNull EventObject eventObject, @NonNull File file) {
        boolean z;
        boolean z2 = false;
        for (DeviceEventSceneHandler deviceEventSceneHandler : this.mEventSceneHandlers) {
            if (deviceEventSceneHandler != null) {
                try {
                    z = z2 || deviceEventSceneHandler.saveFragmentSnapshot(context, eventObject, file);
                } catch (Exception e) {
                    if (LLog.sDebug) {
                        Log.d(TAG, Log.getStackTraceString(e));
                    }
                }
                z2 = z;
            }
            z = z2;
            z2 = z;
        }
        return z2;
    }
}
