package com.baidu.searchbox.task.item;

import android.content.SharedPreferences;
import android.os.Build;
import android.os.StrictMode;
import android.os.strictmode.Violation;
import android.preference.PreferenceManager;
import android.text.format.Time;
import androidx.annotation.RequiresApi;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.sp.PreferenceUtils;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.performance.speed.task.LaunchTask;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.TimeZone;
import java.util.concurrent.Executors;
/* loaded from: classes5.dex */
public class StrictModeTask extends LaunchTask {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long CLEAN_FILE_INTERVAL = 172800000;
    public static final String FILE_DIR = "baidu_strict_mode_log.txt";
    public static final String LAST_CLEAN_FILE_TIME = "last_clean_strict_mode_time";
    public static final String SP_KEY_ENABLE_STRICT_MODE = "sp_enable_strict_mode";
    public static final String SP_KEY_STRICT_MODE_FILTER_SP_LOG = "sp_strict_mode_filter_sp_log";
    public static final String TAG = "StrictModeTask";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.baidu.searchbox.task.item.StrictModeTask$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    @RequiresApi(api = 28)
    /* loaded from: classes5.dex */
    public class OnThreadViolationListener implements StrictMode.OnThreadViolationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ StrictModeTask this$0;

        public OnThreadViolationListener(StrictModeTask strictModeTask) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {strictModeTask};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = strictModeTask;
        }

        @Override // android.os.StrictMode.OnThreadViolationListener
        public void onThreadViolation(Violation violation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, violation) == null) {
                this.this$0.cleanFileIfNeed();
                if (PreferenceUtils.getBoolean(StrictModeTask.SP_KEY_STRICT_MODE_FILTER_SP_LOG, false)) {
                    if (this.this$0.violationContainString(violation, "SharedPreferences")) {
                        return;
                    }
                    this.this$0.writeLogToFile(violation);
                    return;
                }
                this.this$0.writeLogToFile(violation);
            }
        }

        public /* synthetic */ OnThreadViolationListener(StrictModeTask strictModeTask, AnonymousClass1 anonymousClass1) {
            this(strictModeTask);
        }
    }

    public StrictModeTask() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cleanFileIfNeed() {
        File logFile;
        FileOutputStream fileOutputStream;
        PrintWriter printWriter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) || (logFile = getLogFile()) == null) {
            return;
        }
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext());
        long j2 = defaultSharedPreferences.getLong(LAST_CLEAN_FILE_TIME, 0L);
        long currentTimeMillis = System.currentTimeMillis();
        long j3 = currentTimeMillis - j2;
        if (j3 > CLEAN_FILE_INTERVAL || j3 < -172800000) {
            PrintWriter printWriter2 = null;
            try {
                try {
                    fileOutputStream = new FileOutputStream(logFile);
                    printWriter = new PrintWriter(new OutputStreamWriter(fileOutputStream));
                } catch (Throwable th) {
                    th = th;
                }
            } catch (IOException e2) {
                e = e2;
            }
            try {
                printWriter.print("");
                printWriter.flush();
                fileOutputStream.getFD().sync();
                printWriter.close();
                printWriter.close();
            } catch (IOException e3) {
                e = e3;
                printWriter2 = printWriter;
                e.printStackTrace();
                if (printWriter2 != null) {
                    printWriter2.close();
                }
                SharedPreferences.Editor edit = defaultSharedPreferences.edit();
                edit.putLong(LAST_CLEAN_FILE_TIME, (((currentTimeMillis / 86400000) + 1) * 86400000) - TimeZone.getDefault().getRawOffset());
                edit.apply();
            } catch (Throwable th2) {
                th = th2;
                printWriter2 = printWriter;
                if (printWriter2 != null) {
                    printWriter2.close();
                }
                throw th;
            }
            SharedPreferences.Editor edit2 = defaultSharedPreferences.edit();
            edit2.putLong(LAST_CLEAN_FILE_TIME, (((currentTimeMillis / 86400000) + 1) * 86400000) - TimeZone.getDefault().getRawOffset());
            edit2.apply();
        }
    }

    private File getLogFile() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this)) == null) {
            File externalFilesDir = AppRuntime.getAppContext().getExternalFilesDir(null);
            if (externalFilesDir == null) {
                return null;
            }
            return new File(externalFilesDir, FILE_DIR);
        }
        return (File) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean violationContainString(Violation violation, String str) {
        InterceptResult invokeLL;
        StackTraceElement[] stackTrace;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, this, violation, str)) == null) {
            if (violation != null && (stackTrace = violation.getStackTrace()) != null && stackTrace.length != 0) {
                for (StackTraceElement stackTraceElement : stackTrace) {
                    if (stackTraceElement.toString().contains(str)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void writeLogToFile(Violation violation) {
        File logFile;
        FileOutputStream fileOutputStream;
        PrintWriter printWriter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65543, this, violation) == null) || (logFile = getLogFile()) == null) {
            return;
        }
        Time time = new Time();
        PrintWriter printWriter2 = null;
        try {
            fileOutputStream = new FileOutputStream(logFile, true);
            printWriter = new PrintWriter(new OutputStreamWriter(fileOutputStream));
        } catch (IOException unused) {
        } catch (Throwable th) {
            th = th;
        }
        try {
            printWriter.println("========================================");
            time.set(System.currentTimeMillis());
            printWriter.println(time.format("%Y-%m-%d %H:%M:%S"));
            violation.printStackTrace(printWriter);
            printWriter.println("");
            printWriter.println("");
            printWriter.flush();
            fileOutputStream.getFD().sync();
            printWriter.close();
        } catch (IOException unused2) {
            printWriter2 = printWriter;
            if (printWriter2 != null) {
                printWriter2.close();
            }
        } catch (Throwable th2) {
            th = th2;
            printWriter2 = printWriter;
            if (printWriter2 != null) {
                printWriter2.close();
            }
            throw th;
        }
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public void execute() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && LaunchTask.DEBUG && PreferenceUtils.getBoolean(SP_KEY_ENABLE_STRICT_MODE, false)) {
            StrictMode.ThreadPolicy.Builder penaltyLog = new StrictMode.ThreadPolicy.Builder().detectDiskWrites().detectDiskReads().detectNetwork().penaltyDropBox().penaltyLog();
            if (Build.VERSION.SDK_INT >= 28) {
                penaltyLog.penaltyListener(Executors.newSingleThreadExecutor(), new OnThreadViolationListener(this, null));
            }
            StrictMode.setThreadPolicy(penaltyLog.build());
        }
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public String getName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "strictMode" : (String) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public int getProcess() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return 3;
        }
        return invokeV.intValue;
    }
}
