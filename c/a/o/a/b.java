package c.a.o.a;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.java.Supplier;
import com.baidu.android.imsdk.internal.Constants;
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
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Supplier<List<ProcessEventSceneHandler>> f4344a;

    /* renamed from: b  reason: collision with root package name */
    public String f4345b;

    /* renamed from: c  reason: collision with root package name */
    public Context f4346c;

    /* renamed from: d  reason: collision with root package name */
    public long f4347d;

    public b(@NonNull Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (context instanceof Application) {
            this.f4346c = context;
        } else {
            this.f4346c = context.getApplicationContext();
        }
        this.f4345b = c.a.h0.b.a.a.b();
        this.f4347d = System.currentTimeMillis();
        if (Build.VERSION.SDK_INT <= 19) {
            b();
        }
    }

    @NonNull
    public final ForwardingProcessEventSceneHandler a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ForwardingProcessEventSceneHandler forwardingProcessEventSceneHandler = new ForwardingProcessEventSceneHandler();
            if (Build.VERSION.SDK_INT > 19) {
                forwardingProcessEventSceneHandler.addEventHandleCallback(new DefaultProcessEventSceneHandler());
            }
            Supplier<List<ProcessEventSceneHandler>> supplier = this.f4344a;
            if (supplier != null && Build.VERSION.SDK_INT > 19) {
                forwardingProcessEventSceneHandler.addEventHandleCallback(supplier.get());
            }
            return forwardingProcessEventSceneHandler;
        }
        return (ForwardingProcessEventSceneHandler) invokeV.objValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
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
    }

    public void c(@NonNull Context context, @NonNull JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, jSONObject) == null) {
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    public void e(@NonNull Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, context) == null) {
        }
    }

    public void f(@NonNull String str, @NonNull String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, str, str2) == null) {
        }
    }

    public void g(@NonNull Context context, @NonNull String str, @Nullable File file, @Nullable LogExtra logExtra) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048582, this, context, str, file, logExtra) == null) {
            LogSystemServiceUtil.startLogHandlerService(context, LogType.NATIVE_CRASH, str, file, logExtra);
        }
    }

    public final void h(@NonNull String str, @NonNull LogExtra logExtra) {
        HashSet hashSet;
        Set<LogFile> obtainProcessSnapShots;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, str, logExtra) == null) {
            File obtainFileDirWithProcessName = LogPipelineSingleton.obtainFileDirWithProcessName(this.f4345b);
            if (!obtainFileDirWithProcessName.exists()) {
                obtainFileDirWithProcessName.mkdirs();
            }
            JSONObject jSONObject = new JSONObject();
            c(this.f4346c, jSONObject);
            logExtra.mJSONAttach = jSONObject.toString();
            ForwardingProcessEventSceneHandler a2 = a();
            File file = null;
            if (a2 != null) {
                hashSet = new HashSet(5);
                EventObject eventObject = new EventObject(LogType.NATIVE_CRASH, str);
                Set<ProcessSnapshotType> requireGeneralSnapshots = a2.requireGeneralSnapshots(this.f4346c, eventObject);
                if (requireGeneralSnapshots != null && requireGeneralSnapshots.size() > 0 && (obtainProcessSnapShots = SnapshotUtil.obtainProcessSnapShots(this.f4346c, requireGeneralSnapshots, obtainFileDirWithProcessName, this.f4345b, logExtra)) != null && obtainProcessSnapShots.size() > 0) {
                    hashSet.addAll(obtainProcessSnapShots);
                }
                Set<LogFile> customizedSnapshots = a2.getCustomizedSnapshots(this.f4346c, obtainFileDirWithProcessName, eventObject);
                if (customizedSnapshots != null && customizedSnapshots.size() > 0) {
                    hashSet.addAll(customizedSnapshots);
                }
                LogFile obtainFragmentSnapShot = SnapshotUtil.obtainFragmentSnapShot(this.f4346c, a2, eventObject, obtainFileDirWithProcessName, SnapshotConstant.ProcessConstants.PROCESS_SHARED_FRAGMENT_FILE);
                if (obtainFragmentSnapShot != null && obtainFragmentSnapShot.mFile.exists()) {
                    hashSet.add(obtainFragmentSnapShot);
                }
                if (LLog.sDebug && hashSet.size() > 0) {
                    String str2 = "uploadLogFiles.size() = " + hashSet.size();
                    for (int i2 = 0; i2 < hashSet.size(); i2++) {
                    }
                }
            } else {
                hashSet = null;
            }
            e(this.f4346c);
            if (hashSet != null) {
                file = SnapshotUtil.createPathNameKeeper(obtainFileDirWithProcessName, hashSet);
                if (LLog.sDebug && file != null) {
                    String str3 = "pathNameKeeper = " + file.getAbsolutePath();
                }
            }
            g(this.f4346c, str, file, logExtra);
        }
    }

    public void i(@NonNull String str, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, i2, i3) == null) {
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
            logExtra.mLaunchTime = String.valueOf(this.f4347d);
            if (DeviceUtil.OSInfo.hasNougat()) {
                logExtra.mProcessLifeTime = String.valueOf(SystemClock.elapsedRealtime() - Utility.getProcessStartElapsedRealTime());
            }
            logExtra.mForeground = String.valueOf(Track.getInstance().isForeground());
            logExtra.mTraceID = AperfRuntime.Runtime.getProcessUUID();
            try {
                h(str, logExtra);
            } catch (Throwable th) {
                if (LLog.sDebug) {
                    th.printStackTrace();
                }
            }
        }
    }
}
