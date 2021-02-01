package com.baidu.disasterrecovery.jnicrash;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.common.others.java.Supplier;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.searchbox.aperf.runtime.AperfRuntime;
import com.baidu.searchbox.logsystem.basic.LogSystemServiceUtil;
import com.baidu.searchbox.logsystem.basic.LokiService;
import com.baidu.searchbox.logsystem.basic.eventhandler.DefaultProcessEventSceneHandler;
import com.baidu.searchbox.logsystem.basic.util.SnapshotUtil;
import com.baidu.searchbox.logsystem.logsys.CrashUtil;
import com.baidu.searchbox.logsystem.logsys.LogDiskStoreConfig;
import com.baidu.searchbox.logsystem.logsys.LogExtra;
import com.baidu.searchbox.logsystem.logsys.LogFile;
import com.baidu.searchbox.logsystem.logsys.LogPipelineSingleton;
import com.baidu.searchbox.logsystem.logsys.LogType;
import com.baidu.searchbox.logsystem.logsys.SnapshotConstant;
import com.baidu.searchbox.logsystem.logsys.eventscene.EventObject;
import com.baidu.searchbox.logsystem.logsys.eventscene.handler.ForwardingProcessEventSceneHandler;
import com.baidu.searchbox.logsystem.logsys.eventscene.handler.ProcessEventSceneHandler;
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
/* loaded from: classes6.dex */
public class b {
    private Supplier<List<ProcessEventSceneHandler>> aqW;
    private Context mContext;
    private long mProcessLaunchTime;
    private String mProcessName;

    public b(@NonNull Context context) {
        if (context instanceof Application) {
            this.mContext = context;
        } else {
            this.mContext = context.getApplicationContext();
        }
        this.mProcessName = com.baidu.pyramid.runtime.multiprocess.a.getProcessName();
        this.mProcessLaunchTime = System.currentTimeMillis();
        if (Build.VERSION.SDK_INT <= 19) {
            ux();
        }
    }

    private void ux() {
        DefaultProcessEventSceneHandler.init();
        LogType.init();
        SnapshotUtil.init();
        LogFile.init();
        ProcessSnapshotType.init();
        Utility.init();
        LogPipelineSingleton.init();
        LokiService.init();
        LogExtra.init();
        LogDiskStoreConfig.init();
        CrashUtil.init();
        LogSystemServiceUtil.init();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void uncaughtNativeCrash(@NonNull String str, int i, int i2) {
        Log.d("loki-native-NativeCrashHandler", str);
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
        logExtra.mForeground = String.valueOf(Track.getInstance().isForeground());
        logExtra.mTraceID = AperfRuntime.Runtime.getProcessUUID();
        try {
            a(str, logExtra);
        } catch (Throwable th) {
            if (LLog.sDebug) {
                th.printStackTrace();
            }
        }
    }

    private void a(@NonNull String str, @NonNull LogExtra logExtra) {
        HashSet hashSet;
        Set<LogFile> obtainProcessSnapShots;
        File file = null;
        File obtainFileDirWithProcessName = LogPipelineSingleton.obtainFileDirWithProcessName(this.mProcessName);
        if (!obtainFileDirWithProcessName.exists()) {
            obtainFileDirWithProcessName.mkdirs();
        }
        JSONObject jSONObject = new JSONObject();
        onAttachExtra(this.mContext, jSONObject);
        logExtra.mJSONAttach = jSONObject.toString();
        ForwardingProcessEventSceneHandler uy = uy();
        if (uy != null) {
            HashSet hashSet2 = new HashSet(5);
            EventObject eventObject = new EventObject(LogType.NATIVE_CRASH, str);
            Set<ProcessSnapshotType> requireGeneralSnapshots = uy.requireGeneralSnapshots(this.mContext, eventObject);
            if (requireGeneralSnapshots != null && requireGeneralSnapshots.size() > 0 && (obtainProcessSnapShots = SnapshotUtil.obtainProcessSnapShots(this.mContext, requireGeneralSnapshots, obtainFileDirWithProcessName, this.mProcessName, logExtra)) != null && obtainProcessSnapShots.size() > 0) {
                hashSet2.addAll(obtainProcessSnapShots);
            }
            Set<LogFile> customizedSnapshots = uy.getCustomizedSnapshots(this.mContext, obtainFileDirWithProcessName, eventObject);
            if (customizedSnapshots != null && customizedSnapshots.size() > 0) {
                hashSet2.addAll(customizedSnapshots);
            }
            LogFile obtainFragmentSnapShot = SnapshotUtil.obtainFragmentSnapShot(this.mContext, uy, eventObject, obtainFileDirWithProcessName, SnapshotConstant.ProcessConstants.PROCESS_SHARED_FRAGMENT_FILE);
            if (obtainFragmentSnapShot != null && obtainFragmentSnapShot.mFile.exists()) {
                hashSet2.add(obtainFragmentSnapShot);
            }
            if (LLog.sDebug) {
                if (hashSet2 != null && hashSet2.size() > 0) {
                    Log.d("loki-native-NativeCrashHandler", "uploadLogFiles.size() = " + hashSet2.size());
                    for (int i = 0; i < hashSet2.size(); i++) {
                    }
                    hashSet = hashSet2;
                } else {
                    Log.d("loki-native-NativeCrashHandler", "uploadLogFiles is null or uploadLogFiles.size() = 0");
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
                Log.d("loki-native-NativeCrashHandler", "pathNameKeeper = " + file.getAbsolutePath());
            }
        }
        onReport(this.mContext, str, file, logExtra);
    }

    @NonNull
    private ForwardingProcessEventSceneHandler uy() {
        ForwardingProcessEventSceneHandler forwardingProcessEventSceneHandler = new ForwardingProcessEventSceneHandler();
        if (Build.VERSION.SDK_INT > 19) {
            forwardingProcessEventSceneHandler.addEventHandleCallback(new DefaultProcessEventSceneHandler());
        }
        if (this.aqW != null && Build.VERSION.SDK_INT > 19) {
            forwardingProcessEventSceneHandler.addEventHandleCallback(this.aqW.get());
        }
        return forwardingProcessEventSceneHandler;
    }

    public void uz() {
    }

    public void onAttachExtra(@NonNull Context context, @NonNull JSONObject jSONObject) {
    }

    public void onDisasterRecovery(@NonNull Context context) {
    }

    public void onReport(@NonNull Context context, @NonNull String str, @Nullable File file, @Nullable LogExtra logExtra) {
        LogSystemServiceUtil.startLogHandlerService(context, LogType.NATIVE_CRASH, str, file, logExtra);
    }

    public void onEvent(@NonNull String str, @NonNull String str2) {
    }
}
