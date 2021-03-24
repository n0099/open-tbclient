package com.baidu.searchbox.logsystem.logsys.eventscene.handler;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.logsystem.logsys.LogFile;
import com.baidu.searchbox.logsystem.logsys.eventscene.EventObject;
import com.baidu.searchbox.logsystem.logsys.eventscene.snapshot.ProcessSnapshotType;
import com.baidu.searchbox.logsystem.util.LLog;
import java.io.File;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
/* loaded from: classes3.dex */
public class ForwardingProcessEventSceneHandler extends ProcessEventSceneHandler {
    public static final String TAG = "ForwardingCrash";
    public final List<ProcessEventSceneHandler> mEventSceneHandlers = new LinkedList();

    public ForwardingProcessEventSceneHandler(@NonNull List<ProcessEventSceneHandler> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        for (ProcessEventSceneHandler processEventSceneHandler : list) {
            if (processEventSceneHandler != null) {
                this.mEventSceneHandlers.add(processEventSceneHandler);
            }
        }
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

    @Override // com.baidu.searchbox.logsystem.logsys.eventscene.handler.BaseEventSceneHandler, com.baidu.searchbox.logsystem.logsys.eventscene.handler.EventSceneHandler
    @Nullable
    public Set<LogFile> getCustomizedSnapshots(@NonNull Context context, @NonNull File file, @NonNull EventObject eventObject) {
        if (context == null && LLog.sDebug) {
            Log.d("ForwardingCrash", "Context is null in ForwardingEventSceneHandler.getCustomizedSnapshots.");
        }
        HashSet hashSet = null;
        for (ProcessEventSceneHandler processEventSceneHandler : this.mEventSceneHandlers) {
            if (processEventSceneHandler != null) {
                try {
                    Set<LogFile> customizedSnapshots = processEventSceneHandler.getCustomizedSnapshots(context, file, eventObject);
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

    @Override // com.baidu.searchbox.logsystem.logsys.eventscene.handler.ProcessEventSceneHandler, com.baidu.searchbox.logsystem.logsys.eventscene.handler.BaseEventSceneHandler, com.baidu.searchbox.logsystem.logsys.eventscene.handler.EventSceneHandler
    public Set<ProcessSnapshotType> requireGeneralSnapshots(@NonNull Context context, @NonNull EventObject eventObject) {
        HashSet hashSet = null;
        for (ProcessEventSceneHandler processEventSceneHandler : this.mEventSceneHandlers) {
            if (processEventSceneHandler != null) {
                try {
                    Set<T> requireGeneralSnapshots = processEventSceneHandler.requireGeneralSnapshots(context, eventObject);
                    if (requireGeneralSnapshots != 0 && requireGeneralSnapshots.size() > 0) {
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
            for (ProcessEventSceneHandler processEventSceneHandler : this.mEventSceneHandlers) {
                if (processEventSceneHandler != null) {
                    try {
                        boolean saveFragmentSnapshot = processEventSceneHandler.saveFragmentSnapshot(context, eventObject, file);
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

    public ForwardingProcessEventSceneHandler addEventHandleCallback(@NonNull ProcessEventSceneHandler processEventSceneHandler) {
        if (processEventSceneHandler != null) {
            this.mEventSceneHandlers.add(processEventSceneHandler);
        } else if (LLog.sDebug) {
            Log.d("ForwardingCrash", "callback instance should not be null in addEventHandleCallback()");
        }
        return this;
    }

    public ForwardingProcessEventSceneHandler(@NonNull ProcessEventSceneHandler... processEventSceneHandlerArr) {
        if (processEventSceneHandlerArr == null || processEventSceneHandlerArr.length <= 0) {
            return;
        }
        for (ProcessEventSceneHandler processEventSceneHandler : processEventSceneHandlerArr) {
            if (processEventSceneHandler != null) {
                this.mEventSceneHandlers.add(processEventSceneHandler);
            }
        }
    }

    public ForwardingProcessEventSceneHandler() {
    }
}
