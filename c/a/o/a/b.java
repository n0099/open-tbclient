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
import com.baidu.searchbox.aperf.param.CommonUtils;
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
    public Supplier<List<ProcessEventSceneHandler>> a;

    /* renamed from: b  reason: collision with root package name */
    public String f4597b;

    /* renamed from: c  reason: collision with root package name */
    public Context f4598c;

    /* renamed from: d  reason: collision with root package name */
    public long f4599d;

    public b(@NonNull Context context, @NonNull Supplier<List<ProcessEventSceneHandler>> supplier) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, supplier};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        if (context instanceof Application) {
            this.f4598c = context;
        } else {
            this.f4598c = context.getApplicationContext();
        }
        this.f4597b = c.a.k0.b.a.a.b();
        this.f4599d = System.currentTimeMillis();
        this.a = supplier;
    }

    public final LogExtra a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
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
            logExtra.mLaunchTime = String.valueOf(this.f4599d);
            if (DeviceUtil.OSInfo.hasNougat()) {
                logExtra.mProcessLifeTime = String.valueOf(SystemClock.elapsedRealtime() - Utility.getProcessStartElapsedRealTime());
            }
            logExtra.mForeground = String.valueOf(Track.getInstance().isForeground());
            logExtra.mTraceID = AperfRuntime.Runtime.getProcessUUID();
            logExtra.mHeapMem = CommonUtils.getHeapInfo();
            logExtra.mVSSRSS = CommonUtils.getVSSRSS();
            logExtra.mPSS = CommonUtils.getPSS();
            logExtra.mSysMem = CommonUtils.getSysMem();
            logExtra.mSysLowMem = !CommonUtils.isLowMemory() ? 1 : 0;
            return logExtra;
        }
        return (LogExtra) invokeV.objValue;
    }

    @NonNull
    public final ForwardingProcessEventSceneHandler b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ForwardingProcessEventSceneHandler forwardingProcessEventSceneHandler = new ForwardingProcessEventSceneHandler();
            if (Build.VERSION.SDK_INT > 19) {
                forwardingProcessEventSceneHandler.addEventHandleCallback(new DefaultProcessEventSceneHandler());
            }
            Supplier<List<ProcessEventSceneHandler>> supplier = this.a;
            if (supplier != null && Build.VERSION.SDK_INT > 19) {
                forwardingProcessEventSceneHandler.addEventHandleCallback(supplier.get());
            }
            return forwardingProcessEventSceneHandler;
        }
        return (ForwardingProcessEventSceneHandler) invokeV.objValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
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

    public void d(@NonNull Context context, @NonNull JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, context, jSONObject) == null) {
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    public void f(@NonNull Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, context) == null) {
        }
    }

    public void g(@NonNull String str, @NonNull String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, str, str2) == null) {
        }
    }

    public void h(@NonNull Context context, @NonNull String str, @Nullable File file, @Nullable LogExtra logExtra) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048583, this, context, str, file, logExtra) == null) {
            LogSystemServiceUtil.startLogHandlerService(context, LogType.NATIVE_CRASH, str, file, logExtra);
        }
    }

    public final void i(@NonNull String str, @NonNull LogExtra logExtra) {
        HashSet hashSet;
        Set<LogFile> obtainProcessSnapShots;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, logExtra) == null) {
            File obtainFileDirWithProcessName = LogPipelineSingleton.obtainFileDirWithProcessName(this.f4597b);
            if (!obtainFileDirWithProcessName.exists()) {
                obtainFileDirWithProcessName.mkdirs();
            }
            JSONObject jSONObject = new JSONObject();
            d(this.f4598c, jSONObject);
            logExtra.mJSONAttach = jSONObject.toString();
            ForwardingProcessEventSceneHandler b2 = b();
            File file = null;
            if (b2 != null) {
                hashSet = new HashSet(5);
                EventObject eventObject = new EventObject(LogType.NATIVE_CRASH, str);
                Set<ProcessSnapshotType> requireGeneralSnapshots = b2.requireGeneralSnapshots(this.f4598c, eventObject);
                if (requireGeneralSnapshots != null && requireGeneralSnapshots.size() > 0 && (obtainProcessSnapShots = SnapshotUtil.obtainProcessSnapShots(this.f4598c, requireGeneralSnapshots, obtainFileDirWithProcessName, this.f4597b, logExtra)) != null && obtainProcessSnapShots.size() > 0) {
                    hashSet.addAll(obtainProcessSnapShots);
                }
                Set<LogFile> customizedSnapshots = b2.getCustomizedSnapshots(this.f4598c, obtainFileDirWithProcessName, eventObject);
                if (customizedSnapshots != null && customizedSnapshots.size() > 0) {
                    hashSet.addAll(customizedSnapshots);
                }
                LogFile obtainFragmentSnapShot = SnapshotUtil.obtainFragmentSnapShot(this.f4598c, b2, eventObject, obtainFileDirWithProcessName, SnapshotConstant.ProcessConstants.PROCESS_SHARED_FRAGMENT_FILE);
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
            f(this.f4598c);
            if (hashSet != null) {
                file = SnapshotUtil.createPathNameKeeper(obtainFileDirWithProcessName, hashSet);
                if (LLog.sDebug && file != null) {
                    String str3 = "pathNameKeeper = " + file.getAbsolutePath();
                }
            }
            h(this.f4598c, str, file, logExtra);
        }
    }

    public void j(@NonNull String str, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048585, this, str, i2, i3) == null) {
            try {
                i(str, a());
            } catch (Throwable th) {
                if (LLog.sDebug) {
                    th.printStackTrace();
                }
            }
        }
    }

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
            this.f4598c = context;
        } else {
            this.f4598c = context.getApplicationContext();
        }
        this.f4597b = c.a.k0.b.a.a.b();
        this.f4599d = System.currentTimeMillis();
        if (Build.VERSION.SDK_INT <= 19) {
            c();
        }
    }
}
