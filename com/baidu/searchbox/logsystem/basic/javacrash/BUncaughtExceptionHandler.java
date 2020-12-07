package com.baidu.searchbox.logsystem.basic.javacrash;

import android.content.Context;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.pyramid.runtime.multiprocess.a;
import com.baidu.searchbox.aperf.runtime.AperfRuntime;
import com.baidu.searchbox.logsystem.basic.util.SnapshotUtil;
import com.baidu.searchbox.logsystem.javacrash.ProcessExceptionListener;
import com.baidu.searchbox.logsystem.javacrash.UncaughtExceptionHandler;
import com.baidu.searchbox.logsystem.logsys.LogExtra;
import com.baidu.searchbox.logsystem.logsys.LogFile;
import com.baidu.searchbox.logsystem.logsys.LogPipelineSingleton;
import com.baidu.searchbox.logsystem.logsys.LogType;
import com.baidu.searchbox.logsystem.logsys.SnapshotConstant;
import com.baidu.searchbox.logsystem.logsys.eventscene.EventObject;
import com.baidu.searchbox.logsystem.logsys.eventscene.handler.ForwardingProcessEventSceneHandler;
import com.baidu.searchbox.logsystem.logsys.eventscene.snapshot.ProcessSnapshotType;
import com.baidu.searchbox.logsystem.util.LLog;
import com.baidu.searchbox.logsystem.util.Utility;
import com.baidu.searchbox.track.Track;
import com.baidu.searchbox.track.ui.TrackUI;
import java.io.File;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public abstract class BUncaughtExceptionHandler extends UncaughtExceptionHandler {
    private static final String TAG = "BaseUncaughtException";
    private Context mContext;
    private long mProcessLaunchTime;
    private String mProcessName;

    public abstract ForwardingProcessEventSceneHandler getForwardingHandler();

    public abstract void onReport(@NonNull Context context, @NonNull String str, @Nullable File file, @Nullable LogExtra logExtra);

    public BUncaughtExceptionHandler(@NonNull Context context, @Nullable List<ProcessExceptionListener> list) {
        super(list);
        this.mProcessLaunchTime = System.currentTimeMillis();
        Context applicationContext = context.getApplicationContext();
        this.mContext = applicationContext != null ? applicationContext : context;
        this.mProcessName = a.getProcessName();
    }

    public BUncaughtExceptionHandler(@NonNull Context context) {
        this(context, null);
    }

    @Override // com.baidu.searchbox.logsystem.javacrash.UncaughtExceptionHandler
    protected void processException(@NonNull Thread thread, @NonNull Throwable th) {
        HashSet hashSet;
        Set<LogFile> obtainProcessSnapShots;
        File file = null;
        File obtainFileDirWithProcessName = LogPipelineSingleton.obtainFileDirWithProcessName(this.mProcessName);
        if (!obtainFileDirWithProcessName.exists()) {
            obtainFileDirWithProcessName.mkdirs();
        }
        LogExtra createLogExtra = createLogExtra(thread);
        JSONObject jSONObject = new JSONObject();
        onAttachExtra(this.mContext, jSONObject);
        createLogExtra.mJSONAttach = jSONObject.toString();
        String sb = new StringBuilder(Log.getStackTraceString(th)).toString();
        ForwardingProcessEventSceneHandler forwardingHandler = getForwardingHandler();
        if (forwardingHandler != null) {
            HashSet hashSet2 = new HashSet(5);
            EventObject eventObject = new EventObject(LogType.JAVA_CRASH, sb);
            Set<ProcessSnapshotType> requireGeneralSnapshots = forwardingHandler.requireGeneralSnapshots(this.mContext, eventObject);
            if (requireGeneralSnapshots != null && requireGeneralSnapshots.size() > 0 && (obtainProcessSnapShots = SnapshotUtil.obtainProcessSnapShots(this.mContext, requireGeneralSnapshots, obtainFileDirWithProcessName, this.mProcessName, createLogExtra)) != null && obtainProcessSnapShots.size() > 0) {
                hashSet2.addAll(obtainProcessSnapShots);
            }
            Set<LogFile> customizedSnapshots = forwardingHandler.getCustomizedSnapshots(this.mContext, obtainFileDirWithProcessName, eventObject);
            if (customizedSnapshots != null && customizedSnapshots.size() > 0) {
                hashSet2.addAll(customizedSnapshots);
            }
            LogFile obtainFragmentSnapShot = SnapshotUtil.obtainFragmentSnapShot(this.mContext, forwardingHandler, eventObject, obtainFileDirWithProcessName, SnapshotConstant.ProcessConstants.PROCESS_SHARED_FRAGMENT_FILE);
            if (obtainFragmentSnapShot != null && obtainFragmentSnapShot.mFile.exists()) {
                hashSet2.add(obtainFragmentSnapShot);
            }
            if (LLog.sDebug) {
                if (hashSet2 != null && hashSet2.size() > 0) {
                    Log.d(TAG, "uploadLogFiles.size() = " + hashSet2.size());
                    for (int i = 0; i < hashSet2.size(); i++) {
                    }
                    hashSet = hashSet2;
                } else {
                    Log.d(TAG, "uploadLogFiles is null or uploadLogFiles.size() = 0");
                }
            }
            hashSet = hashSet2;
        } else {
            hashSet = null;
        }
        onDisasterRecovery(this.mContext);
        if (hashSet != null) {
            file = SnapshotUtil.createPathNameKeeper(obtainFileDirWithProcessName, hashSet);
            if (LLog.sDebug && file != null) {
                Log.d(TAG, "pathNameKeeper = " + file.getAbsolutePath());
            }
        }
        onReport(this.mContext, sb, file, createLogExtra);
    }

    private LogExtra createLogExtra(@NonNull Thread thread) {
        LogExtra logExtra = new LogExtra();
        TrackUI lastTrackUI = Track.getInstance().getLastTrackUI();
        if (lastTrackUI != null) {
            if (!TextUtils.isEmpty(lastTrackUI.getFragmentPage())) {
                logExtra.mPage = lastTrackUI.getFragmentPage();
            } else {
                logExtra.mPage = lastTrackUI.getActivityPage();
            }
        }
        logExtra.mCrashTime = String.valueOf(System.currentTimeMillis());
        logExtra.mLaunchTime = String.valueOf(this.mProcessLaunchTime);
        if (DeviceUtil.OSInfo.hasNougat()) {
            logExtra.mProcessLifeTime = String.valueOf(SystemClock.elapsedRealtime() - Utility.getProcessStartElapsedRealTime());
        }
        logExtra.mCrashThreadName = thread.getName();
        logExtra.mCrashThreadPriority = String.valueOf(thread.getPriority());
        logExtra.mForeground = String.valueOf(Track.getInstance().isForeground());
        logExtra.mTraceID = AperfRuntime.Runtime.getProcessUUID();
        return logExtra;
    }

    public String getProcessName() {
        return this.mProcessName;
    }

    public void setProcessLaunchTime(long j) {
        this.mProcessLaunchTime = j;
    }

    public void onAttachExtra(@NonNull Context context, @NonNull JSONObject jSONObject) {
    }

    public void onDisasterRecovery(@NonNull Context context) {
    }
}
