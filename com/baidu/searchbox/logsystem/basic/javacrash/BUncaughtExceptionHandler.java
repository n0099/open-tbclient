package com.baidu.searchbox.logsystem.basic.javacrash;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.searchbox.aperf.param.CommonUtils;
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
import com.baidu.tieba.ze1;
import java.io.File;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public abstract class BUncaughtExceptionHandler extends UncaughtExceptionHandler {
    public static final String TAG = "BaseUncaughtException";
    public final Context mContext;
    public long mProcessLaunchTime;
    public final String mProcessName;

    public abstract ForwardingProcessEventSceneHandler getForwardingHandler();

    public void onAttachExtra(@NonNull Context context, @NonNull JSONObject jSONObject) {
    }

    public void onDisasterRecovery(@NonNull Context context) {
    }

    public abstract void onReport(@NonNull Context context, @NonNull String str, @Nullable File file, @Nullable LogExtra logExtra);

    public BUncaughtExceptionHandler(@NonNull Context context) {
        this(context, null);
    }

    public void setProcessLaunchTime(long j) {
        this.mProcessLaunchTime = j;
    }

    public BUncaughtExceptionHandler(@NonNull Context context, @Nullable List<ProcessExceptionListener> list) {
        super(list);
        this.mProcessLaunchTime = System.currentTimeMillis();
        Context applicationContext = context.getApplicationContext();
        this.mContext = applicationContext != null ? applicationContext : context;
        this.mProcessName = ze1.b();
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
        logExtra.mHeapMem = CommonUtils.getHeapInfo();
        logExtra.mVSSRSS = CommonUtils.getVSSRSS();
        logExtra.mPSS = CommonUtils.getPSS();
        logExtra.mSysMem = CommonUtils.getSysMem();
        logExtra.mSysLowMem = !CommonUtils.isLowMemory() ? 1 : 0;
        return logExtra;
    }

    public String getProcessName() {
        return this.mProcessName;
    }

    @Override // com.baidu.searchbox.logsystem.javacrash.UncaughtExceptionHandler
    public void processException(@NonNull Thread thread, @NonNull Throwable th) {
        HashSet hashSet;
        Set<LogFile> obtainProcessSnapShots;
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
        File file = null;
        if (forwardingHandler != null) {
            hashSet = new HashSet(5);
            EventObject eventObject = new EventObject(LogType.JAVA_CRASH, sb);
            Set<ProcessSnapshotType> requireGeneralSnapshots = forwardingHandler.requireGeneralSnapshots(this.mContext, eventObject);
            if (requireGeneralSnapshots != null && requireGeneralSnapshots.size() > 0 && (obtainProcessSnapShots = SnapshotUtil.obtainProcessSnapShots(this.mContext, requireGeneralSnapshots, obtainFileDirWithProcessName, this.mProcessName, createLogExtra)) != null && obtainProcessSnapShots.size() > 0) {
                hashSet.addAll(obtainProcessSnapShots);
            }
            Set<LogFile> customizedSnapshots = forwardingHandler.getCustomizedSnapshots(this.mContext, obtainFileDirWithProcessName, eventObject);
            if (customizedSnapshots != null && customizedSnapshots.size() > 0) {
                hashSet.addAll(customizedSnapshots);
            }
            LogFile obtainFragmentSnapShot = SnapshotUtil.obtainFragmentSnapShot(this.mContext, forwardingHandler, eventObject, obtainFileDirWithProcessName, SnapshotConstant.ProcessConstants.PROCESS_SHARED_FRAGMENT_FILE);
            if (obtainFragmentSnapShot != null && obtainFragmentSnapShot.mFile.exists()) {
                hashSet.add(obtainFragmentSnapShot);
            }
            if (LLog.sDebug) {
                if (hashSet.size() > 0) {
                    Log.d(TAG, "uploadLogFiles.size() = " + hashSet.size());
                    for (int i = 0; i < hashSet.size(); i++) {
                    }
                } else {
                    Log.d(TAG, "uploadLogFiles is null or uploadLogFiles.size() = 0");
                }
            }
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
}
