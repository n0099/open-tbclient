package com.baidu.searchbox.logsystem.basic;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.logsystem.logsys.LogBaseObject;
import com.baidu.searchbox.logsystem.logsys.LogExtra;
import com.baidu.searchbox.logsystem.logsys.LogObject;
import com.baidu.searchbox.logsystem.logsys.LogType;
import com.baidu.searchbox.logsystem.util.LLog;
import java.io.File;
/* loaded from: classes6.dex */
public class LokiService extends Service {
    protected static final String LOG_SYSTEM_SERVICE = ":loki";
    private static final String TAG = "LokiService";
    public static LogSystemProcessor mProcessor;

    /* loaded from: classes6.dex */
    public static final class Constant {
        public static final String LOG_BASIC_DATA = "logbasicdata";
        public static final String LOG_BASIC_DATA_FILE = "logbasicdatafile";
        public static final String LOG_CRASH_TAG = "crash_TAG";
        public static final String LOG_EXTRA = "logExtra";
        public static final String LOG_EXTRA_PATHNAME_KEEPER = "logextrapathnamekeeper";
        public static final String LOG_PROCESS_NAME = "processname";
        public static final String LOG_TYPE = "logtype";
        public static final int MAX_LENGTH_OF_STRING_TO_DIRECT_TRANS_WITH_BINDER = 25600;
    }

    public static void init() {
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        if (LLog.sDebug) {
            Log.d(TAG, "LokiService.onCreate(), pid = " + Process.myPid());
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        File file;
        File file2;
        LogBaseObject logObject;
        if (LLog.sDebug) {
            Log.d(TAG, "LokiService.onStartCommand(), pid = " + Process.myPid());
        }
        if (intent != null) {
            String stringExtra = intent.getStringExtra(Constant.LOG_BASIC_DATA);
            String stringExtra2 = intent.getStringExtra(Constant.LOG_BASIC_DATA_FILE);
            if (TextUtils.isEmpty(stringExtra2)) {
                file = null;
            } else {
                file = new File(stringExtra2);
                if (!file.exists() || !file.isFile()) {
                    file = null;
                }
            }
            LogType logType = (LogType) intent.getSerializableExtra("logtype");
            String stringExtra3 = intent.getStringExtra(Constant.LOG_PROCESS_NAME);
            if (logType != null && (LogType.NONE == logType || ((!TextUtils.isEmpty(stringExtra) || (file != null && file.exists() && file.isFile())) && !TextUtils.isEmpty(stringExtra3)))) {
                String stringExtra4 = intent.getStringExtra(Constant.LOG_EXTRA_PATHNAME_KEEPER);
                String stringExtra5 = intent.getStringExtra(Constant.LOG_CRASH_TAG);
                if (LLog.sDebug) {
                    Log.d(TAG, "logType = " + logType.getTypeName());
                    Log.d(TAG, "logBasicData = " + (TextUtils.isEmpty(stringExtra) ? "logBasicData is empty or null" : stringExtra));
                    Log.d(TAG, "processName = " + (TextUtils.isEmpty(stringExtra3) ? "process name is empty or null" : stringExtra3));
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
                    if (TextUtils.isEmpty(stringExtra4)) {
                        file2 = null;
                    } else {
                        file2 = new File(stringExtra4);
                        if (!file2.exists() || !file2.isFile()) {
                            file2 = null;
                        }
                    }
                    logObject = new LogObject(logType, stringExtra3, stringExtra, file, file2, (LogExtra) intent.getParcelableExtra(Constant.LOG_EXTRA), stringExtra5);
                }
                if (logObject != null) {
                    if (mProcessor != null) {
                        mProcessor.process(this, i2, logObject);
                    }
                } else if (LLog.sDebug) {
                    Log.d(TAG, "logOBJ is null, no action should be done");
                }
            }
        }
        return 2;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        if (LLog.sDebug) {
            Log.d(TAG, "LokiService.onBind(), pid = " + Process.myPid());
            return null;
        }
        return null;
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        if (LLog.sDebug) {
            Log.d(TAG, "LokiService.onDestroy(), pid = " + Process.myPid());
        }
        Process.killProcess(Process.myPid());
    }
}
