package com.baidu.searchbox.logsystem.logsys.eventscene.handler;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import com.baidu.searchbox.logsystem.logsys.LogFile;
import com.baidu.searchbox.logsystem.logsys.eventscene.EventObject;
import com.baidu.searchbox.logsystem.logsys.eventscene.snapshot.ProcessSnapshotType;
import com.baidu.searchbox.logsystem.util.LLog;
import java.io.File;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
/* loaded from: classes9.dex */
public class ForwardingProcessEventSceneHandler extends ProcessEventSceneHandler {
    protected static final String TAG = "ForwardingCrash";
    private final List<ProcessEventSceneHandler> mEventSceneHandlers = new LinkedList();

    public ForwardingProcessEventSceneHandler(@NonNull List<ProcessEventSceneHandler> list) {
        if (list != null && list.size() > 0) {
            for (ProcessEventSceneHandler processEventSceneHandler : list) {
                if (processEventSceneHandler != null) {
                    this.mEventSceneHandlers.add(processEventSceneHandler);
                }
            }
        }
    }

    public ForwardingProcessEventSceneHandler(@NonNull ProcessEventSceneHandler... processEventSceneHandlerArr) {
        if (processEventSceneHandlerArr != null && processEventSceneHandlerArr.length > 0) {
            for (ProcessEventSceneHandler processEventSceneHandler : processEventSceneHandlerArr) {
                if (processEventSceneHandler != null) {
                    this.mEventSceneHandlers.add(processEventSceneHandler);
                }
            }
        }
    }

    public ForwardingProcessEventSceneHandler() {
    }

    public ForwardingProcessEventSceneHandler addEventHandleCallback(@NonNull List<ProcessEventSceneHandler> list) {
        if (list != null && list.size() > 0) {
            for (ProcessEventSceneHandler processEventSceneHandler : list) {
                if (processEventSceneHandler != null) {
                    this.mEventSceneHandlers.add(processEventSceneHandler);
                }
            }
        }
        return this;
    }

    public ForwardingProcessEventSceneHandler addEventHandleCallback(@NonNull ProcessEventSceneHandler processEventSceneHandler) {
        if (processEventSceneHandler != null) {
            this.mEventSceneHandlers.add(processEventSceneHandler);
        } else if (LLog.sDebug) {
            Log.d(TAG, "callback instance should not be null in addEventHandleCallback()");
        }
        return this;
    }

    @Override // com.baidu.searchbox.logsystem.logsys.eventscene.handler.ProcessEventSceneHandler, com.baidu.searchbox.logsystem.logsys.eventscene.handler.BaseEventSceneHandler, com.baidu.searchbox.logsystem.logsys.eventscene.handler.EventSceneHandler
    public Set<ProcessSnapshotType> requireGeneralSnapshots(@NonNull Context context, @NonNull EventObject eventObject) {
        HashSet hashSet;
        Exception e;
        Set<T> requireGeneralSnapshots;
        HashSet hashSet2 = null;
        for (ProcessEventSceneHandler processEventSceneHandler : this.mEventSceneHandlers) {
            if (processEventSceneHandler != null) {
                try {
                    requireGeneralSnapshots = processEventSceneHandler.requireGeneralSnapshots(context, eventObject);
                } catch (Exception e2) {
                    hashSet = hashSet2;
                    e = e2;
                }
                if (requireGeneralSnapshots != 0 && requireGeneralSnapshots.size() > 0) {
                    hashSet = hashSet2 == null ? new HashSet(5) : hashSet2;
                    try {
                        hashSet.addAll(requireGeneralSnapshots);
                    } catch (Exception e3) {
                        e = e3;
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
        Exception e;
        Set<LogFile> customizedSnapshots;
        if (context == null && LLog.sDebug) {
            Log.d(TAG, "Context is null in ForwardingEventSceneHandler.getCustomizedSnapshots.");
        }
        HashSet hashSet2 = null;
        for (ProcessEventSceneHandler processEventSceneHandler : this.mEventSceneHandlers) {
            if (processEventSceneHandler != null) {
                try {
                    customizedSnapshots = processEventSceneHandler.getCustomizedSnapshots(context, file, eventObject);
                } catch (Exception e2) {
                    hashSet = hashSet2;
                    e = e2;
                }
                if (customizedSnapshots != null && customizedSnapshots.size() > 0) {
                    hashSet = hashSet2 == null ? new HashSet(customizedSnapshots.size()) : hashSet2;
                    try {
                        hashSet.addAll(customizedSnapshots);
                    } catch (Exception e3) {
                        e = e3;
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
        for (ProcessEventSceneHandler processEventSceneHandler : this.mEventSceneHandlers) {
            if (processEventSceneHandler != null) {
                try {
                    z = z2 || processEventSceneHandler.saveFragmentSnapshot(context, eventObject, file);
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
