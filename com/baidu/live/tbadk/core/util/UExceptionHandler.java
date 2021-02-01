package com.baidu.live.tbadk.core.util;

import android.app.ActivityManager;
import android.os.Build;
import android.os.Debug;
import android.os.Environment;
import android.os.Process;
import android.text.TextUtils;
import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.adp.lib.util.BdFileHelper;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.CloseUtil;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.data.ExceptionData;
import com.baidu.live.tbadk.util.DaemonServiceManager;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.Writer;
import java.lang.Thread;
import java.util.List;
/* loaded from: classes11.dex */
public class UExceptionHandler implements Thread.UncaughtExceptionHandler {
    private static final String HPROF_FILE_PATH = Environment.getExternalStorageDirectory().getPath() + File.separator + "tblive" + File.separator + "oom" + File.separator;
    private static final String OOM = "java.lang.OutOfMemoryError";
    private final Thread.UncaughtExceptionHandler handler = Thread.getDefaultUncaughtExceptionHandler();
    private ExceptionData mInfo = null;

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        saveExceptionInfo(thread, th, false);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [78=4] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0094  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void saveExceptionInfo(Thread thread, Throwable th, boolean z) {
        PrintStream printStream;
        ByteArrayOutputStream byteArrayOutputStream;
        if (TbConfig.getDebugSwitch() && isOOM(th)) {
            dumpOOM();
        }
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
        } catch (Exception e) {
            e = e;
            printStream = null;
            byteArrayOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            printStream = null;
            byteArrayOutputStream = null;
        }
        try {
            printStream = new PrintStream(byteArrayOutputStream);
            try {
                try {
                    th.printStackTrace(printStream);
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    this.mInfo = new ExceptionData();
                    if (z) {
                        this.mInfo.info = th.getMessage();
                    } else {
                        this.mInfo.info = new String(byteArray);
                        this.mInfo.mExcep = th;
                    }
                    if (!z) {
                        writeToFile(thread, th);
                    }
                    CloseUtil.close((OutputStream) printStream);
                    CloseUtil.close((OutputStream) byteArrayOutputStream);
                    if (z) {
                        return;
                    }
                    if (!TbConfig.getDebugSwitch() || this.handler == null) {
                        Process.killProcess(Process.myPid());
                    } else {
                        this.handler.uncaughtException(thread, th);
                    }
                } catch (Exception e2) {
                    e = e2;
                    e.printStackTrace();
                    CloseUtil.close((OutputStream) printStream);
                    CloseUtil.close((OutputStream) byteArrayOutputStream);
                    if (z) {
                        return;
                    }
                    if (!TbConfig.getDebugSwitch() || this.handler == null) {
                        Process.killProcess(Process.myPid());
                    } else {
                        this.handler.uncaughtException(thread, th);
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                CloseUtil.close((OutputStream) printStream);
                CloseUtil.close((OutputStream) byteArrayOutputStream);
                if (!z) {
                    if (!TbConfig.getDebugSwitch() || this.handler == null) {
                        Process.killProcess(Process.myPid());
                    } else {
                        this.handler.uncaughtException(thread, th);
                    }
                }
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            printStream = null;
        } catch (Throwable th4) {
            th = th4;
            printStream = null;
            CloseUtil.close((OutputStream) printStream);
            CloseUtil.close((OutputStream) byteArrayOutputStream);
            if (!z) {
            }
            throw th;
        }
    }

    private void addInfo(FileWriter fileWriter, String str, String str2) {
        try {
            fileWriter.append((CharSequence) str);
            if (str2 != null) {
                fileWriter.append("=");
                fileWriter.append((CharSequence) str2);
            }
            fileWriter.append("\n");
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void writeToFile(Thread thread, Throwable th, String str) {
        Throwable th2;
        FileWriter fileWriter;
        Exception exc;
        FileWriter fileWriter2 = null;
        if (this.mInfo != null) {
            try {
                File CreateFileIfNotFound = FileHelper.CreateFileIfNotFound(str);
                if (CreateFileIfNotFound != null) {
                    FileWriter fileWriter3 = new FileWriter(CreateFileIfNotFound, true);
                    try {
                        addInfo(fileWriter3, StringHelper.getCurrentString(), null);
                        addInfo(fileWriter3, "tblive_crash_new_info_end", null);
                        addInfo(fileWriter3, "version", TbConfig.getVersion());
                        addInfo(fileWriter3, "model", Build.MODEL);
                        addInfo(fileWriter3, "android_version", Build.VERSION.RELEASE);
                        addInfo(fileWriter3, "android_sdk", String.valueOf(Build.VERSION.SDK_INT));
                        addInfo(fileWriter3, "uid", TbadkCoreApplication.getCurrentAccount());
                        addInfo(fileWriter3, "client_id", TbadkCoreApplication.getClientId());
                        if (!TextUtils.isEmpty(TbConfig.getSubappType())) {
                            addInfo(fileWriter3, "subapp_type", TbConfig.getSubappType());
                        }
                        addInfo(fileWriter3, "imei", TbadkCoreApplication.getInst().getImei());
                        addInfo(fileWriter3, BdStatsConstant.StatsKey.UNAME, TbadkCoreApplication.getCurrentAccountName());
                        addInfo(fileWriter3, PushConstants.INTENT_ACTIVITY_NAME, TiebaStaticHelper.getCurrentActivityAllName());
                        addInfo(fileWriter3, "maxMemory", String.valueOf(Runtime.getRuntime().maxMemory()));
                        addInfo(fileWriter3, BdStatsConstant.StatsKey.CRASH_TYPE, th.getClass().getName());
                        addInfo(fileWriter3, BdStatsConstant.StatsType.ERROR, this.mInfo.info);
                        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) TbadkCoreApplication.getInst().getApp().getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getRunningAppProcesses();
                        int myPid = Process.myPid();
                        if (runningAppProcesses != null) {
                            int i = 0;
                            while (true) {
                                int i2 = i;
                                if (i2 >= runningAppProcesses.size()) {
                                    break;
                                } else if (runningAppProcesses.get(i2).pid != myPid) {
                                    i = i2 + 1;
                                } else {
                                    addInfo(fileWriter3, "process_name", runningAppProcesses.get(i2).processName);
                                    break;
                                }
                            }
                        }
                        addInfo(fileWriter3, "tblive_crash_new_info_end", null);
                        fileWriter3.append("\n");
                        fileWriter3.flush();
                        fileWriter2 = fileWriter3;
                    } catch (Exception e) {
                        exc = e;
                        fileWriter = fileWriter3;
                        try {
                            exc.printStackTrace();
                            CloseUtil.close((Writer) fileWriter);
                            return;
                        } catch (Throwable th3) {
                            th2 = th3;
                            CloseUtil.close((Writer) fileWriter);
                            throw th2;
                        }
                    } catch (Throwable th4) {
                        th2 = th4;
                        fileWriter = fileWriter3;
                        CloseUtil.close((Writer) fileWriter);
                        throw th2;
                    }
                }
                CloseUtil.close((Writer) fileWriter2);
            } catch (Exception e2) {
                exc = e2;
                fileWriter = null;
            } catch (Throwable th5) {
                th2 = th5;
                fileWriter = null;
            }
        }
    }

    private void writeToFile(Thread thread, Throwable th) {
        if (this.mInfo != null) {
            writeToFile(thread, th, com.baidu.tbadk.TbConfig.FATAL_ERROR_DEBUG_FILE);
        }
    }

    public static boolean isOOM(Throwable th) {
        if (OOM.equals(th.getClass().getName())) {
            return true;
        }
        Throwable cause = th.getCause();
        if (cause != null) {
            return isOOM(cause);
        }
        return false;
    }

    private void dumpOOM() {
        try {
            File file = new File(HPROF_FILE_PATH);
            if (!file.exists()) {
                file.mkdir();
            }
            Debug.dumpHprofData(HPROF_FILE_PATH + System.currentTimeMillis());
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }

    private int recordHourCrashCount() {
        int i;
        long j = 0;
        byte[] fileData = BdFileHelper.getFileData(DaemonServiceManager.CRASH_HOUR_RECORD_FILE);
        String str = null;
        if (fileData != null) {
            str = new String(fileData);
        }
        long j2 = StringUtils.getyyyyMMddHHTimeForNow();
        if (TextUtils.isEmpty(str)) {
            i = 0;
        } else {
            String[] split = str.split(":");
            if (split == null || split.length != 2) {
                i = 0;
            } else {
                i = JavaTypesHelper.toInt(split[0], 0);
                j = JavaTypesHelper.toLong(split[1], j2);
            }
        }
        int i2 = j != j2 ? 1 : i + 1;
        BdFileHelper.saveFile(DaemonServiceManager.CRASH_HOUR_RECORD_FILE, (i2 + ":" + j2).getBytes());
        return i2;
    }

    public static byte[] getBytesFromFile(File file) {
        byte[] bArr;
        FileInputStream fileInputStream;
        int read;
        try {
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    bArr = new byte[(int) file.length()];
                    int i = 0;
                    while (i < bArr.length && (read = fileInputStream.read(bArr, i, bArr.length - i)) >= 0) {
                        try {
                            i += read;
                        } catch (Exception e) {
                            e = e;
                            BdLog.e(e.toString());
                            CloseUtil.close((InputStream) fileInputStream);
                            return bArr;
                        }
                    }
                    CloseUtil.close((InputStream) fileInputStream);
                } catch (Exception e2) {
                    e = e2;
                    bArr = null;
                }
            } catch (Throwable th) {
                th = th;
                CloseUtil.close((InputStream) null);
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            bArr = null;
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            CloseUtil.close((InputStream) null);
            throw th;
        }
        return bArr;
    }
}
