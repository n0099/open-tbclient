package com.baidu.searchbox.logsystem.basic;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.logsystem.logsys.LogBaseObject;
import com.baidu.searchbox.logsystem.logsys.LogExtra;
import com.baidu.searchbox.logsystem.logsys.LogObject;
import com.baidu.searchbox.logsystem.logsys.LogType;
import com.baidu.searchbox.logsystem.util.LLog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes2.dex */
public class LokiService extends Service {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String LOG_SYSTEM_SERVICE = ":loki";
    public static final String TAG = "LokiService";
    public static LogSystemProcessor mProcessor;
    public transient /* synthetic */ FieldHolder $fh;

    public static void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
        }
    }

    /* loaded from: classes2.dex */
    public static final class Constant {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String LOG_BASIC_DATA = "logbasicdata";
        public static final String LOG_BASIC_DATA_FILE = "logbasicdatafile";
        public static final String LOG_CRASH_TAG = "crash_TAG";
        public static final String LOG_EXTRA = "logExtra";
        public static final String LOG_EXTRA_PATHNAME_KEEPER = "logextrapathnamekeeper";
        public static final String LOG_PROCESS_NAME = "processname";
        public static final String LOG_TYPE = "logtype";
        public static final int MAX_LENGTH_OF_STRING_TO_DIRECT_TRANS_WITH_BINDER = 25600;
        public transient /* synthetic */ FieldHolder $fh;

        public Constant() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    public LokiService() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // android.app.Service
    public void onCreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.onCreate();
            if (LLog.sDebug) {
                Log.d(TAG, "LokiService.onCreate(), pid = " + Process.myPid());
            }
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, intent)) == null) {
            if (LLog.sDebug) {
                Log.d(TAG, "LokiService.onBind(), pid = " + Process.myPid());
                return null;
            }
            return null;
        }
        return (IBinder) invokeL.objValue;
    }

    @Override // android.app.Service
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onDestroy();
            if (LLog.sDebug) {
                Log.d(TAG, "LokiService.onDestroy(), pid = " + Process.myPid());
            }
            Process.killProcess(Process.myPid());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x005e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x005f  */
    @Override // android.app.Service
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int onStartCommand(Intent intent, int i, int i2) {
        InterceptResult invokeLII;
        File file;
        LogType logType;
        File file2;
        LogBaseObject logObject;
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048579, this, intent, i, i2)) == null) {
            if (LLog.sDebug) {
                Log.d(TAG, "LokiService.onStartCommand(), pid = " + Process.myPid());
            }
            if (intent == null) {
                return 2;
            }
            String stringExtra = intent.getStringExtra(Constant.LOG_BASIC_DATA);
            String stringExtra2 = intent.getStringExtra(Constant.LOG_BASIC_DATA_FILE);
            if (!TextUtils.isEmpty(stringExtra2)) {
                File file3 = new File(stringExtra2);
                if (file3.exists() && file3.isFile()) {
                    file = file3;
                    logType = (LogType) intent.getSerializableExtra("logtype");
                    String stringExtra3 = intent.getStringExtra(Constant.LOG_PROCESS_NAME);
                    if (logType != null) {
                        return 2;
                    }
                    if (LogType.NONE != logType && ((TextUtils.isEmpty(stringExtra) && (file == null || !file.exists() || !file.isFile())) || TextUtils.isEmpty(stringExtra3))) {
                        return 2;
                    }
                    String stringExtra4 = intent.getStringExtra(Constant.LOG_EXTRA_PATHNAME_KEEPER);
                    String stringExtra5 = intent.getStringExtra(Constant.LOG_CRASH_TAG);
                    if (LLog.sDebug) {
                        Log.d(TAG, "logType = " + logType.getTypeName());
                        StringBuilder sb = new StringBuilder();
                        sb.append("logBasicData = ");
                        if (TextUtils.isEmpty(stringExtra)) {
                            str = "logBasicData is empty or null";
                        } else {
                            str = stringExtra;
                        }
                        sb.append(str);
                        Log.d(TAG, sb.toString());
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("processName = ");
                        if (TextUtils.isEmpty(stringExtra3)) {
                            str2 = "process name is empty or null";
                        } else {
                            str2 = stringExtra3;
                        }
                        sb2.append(str2);
                        Log.d(TAG, sb2.toString());
                        if (!TextUtils.isEmpty(stringExtra4)) {
                            Log.d(TAG, "logExtraPathNameKeeper = " + stringExtra4);
                        } else {
                            Log.d(TAG, "logExtraPathNameKeeper is null or empty ");
                        }
                        Log.d(TAG, "crashTAG = " + stringExtra5);
                    }
                    if (LogType.NONE == logType) {
                        logObject = new LogBaseObject();
                    } else {
                        if (!TextUtils.isEmpty(stringExtra4)) {
                            File file4 = new File(stringExtra4);
                            if (file4.exists() && file4.isFile()) {
                                file2 = file4;
                                logObject = new LogObject(logType, stringExtra3, stringExtra, file, file2, (LogExtra) intent.getParcelableExtra("logExtra"), stringExtra5);
                            }
                        }
                        file2 = null;
                        logObject = new LogObject(logType, stringExtra3, stringExtra, file, file2, (LogExtra) intent.getParcelableExtra("logExtra"), stringExtra5);
                    }
                    LogSystemProcessor logSystemProcessor = mProcessor;
                    if (logSystemProcessor != null) {
                        logSystemProcessor.process(this, i2, logObject);
                    }
                    return 2;
                }
            }
            file = null;
            logType = (LogType) intent.getSerializableExtra("logtype");
            String stringExtra32 = intent.getStringExtra(Constant.LOG_PROCESS_NAME);
            if (logType != null) {
            }
        } else {
            return invokeLII.intValue;
        }
    }
}
