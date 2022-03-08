package com.baidu.searchbox.logsystem.basic.javacrash;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.a.i0.b.a.a;
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public abstract class BUncaughtExceptionHandler extends UncaughtExceptionHandler {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "BaseUncaughtException";
    public transient /* synthetic */ FieldHolder $fh;
    public final Context mContext;
    public long mProcessLaunchTime;
    public final String mProcessName;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BUncaughtExceptionHandler(@NonNull Context context, @Nullable List<ProcessExceptionListener> list) {
        super(list);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, list};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((List) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mProcessLaunchTime = System.currentTimeMillis();
        Context applicationContext = context.getApplicationContext();
        this.mContext = applicationContext != null ? applicationContext : context;
        this.mProcessName = a.b();
    }

    private LogExtra createLogExtra(@NonNull Thread thread) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, thread)) == null) {
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
        return (LogExtra) invokeL.objValue;
    }

    public abstract ForwardingProcessEventSceneHandler getForwardingHandler();

    public String getProcessName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mProcessName : (String) invokeV.objValue;
    }

    public void onAttachExtra(@NonNull Context context, @NonNull JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, jSONObject) == null) {
        }
    }

    public void onDisasterRecovery(@NonNull Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, context) == null) {
        }
    }

    public abstract void onReport(@NonNull Context context, @NonNull String str, @Nullable File file, @Nullable LogExtra logExtra);

    @Override // com.baidu.searchbox.logsystem.javacrash.UncaughtExceptionHandler
    public void processException(@NonNull Thread thread, @NonNull Throwable th) {
        HashSet hashSet;
        Set<LogFile> obtainProcessSnapShots;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, thread, th) == null) {
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
                if (LLog.sDebug && hashSet.size() > 0) {
                    String str = "uploadLogFiles.size() = " + hashSet.size();
                    for (int i2 = 0; i2 < hashSet.size(); i2++) {
                    }
                }
            } else {
                hashSet = null;
            }
            onDisasterRecovery(this.mContext);
            if (hashSet != null) {
                file = SnapshotUtil.createPathNameKeeper(obtainFileDirWithProcessName, hashSet);
                if (LLog.sDebug && file != null) {
                    String str2 = "pathNameKeeper = " + file.getAbsolutePath();
                }
            }
            onReport(this.mContext, sb, file, createLogExtra);
        }
    }

    public void setProcessLaunchTime(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048582, this, j2) == null) {
            this.mProcessLaunchTime = j2;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BUncaughtExceptionHandler(@NonNull Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (List) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }
}
