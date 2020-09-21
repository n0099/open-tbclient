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
import com.baidu.platform.comapi.map.MapController;
import com.baidu.webkit.internal.ETAG;
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
/* loaded from: classes4.dex */
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
    /* JADX WARN: Removed duplicated region for block: B:40:0x0095  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void saveExceptionInfo(Thread thread, Throwable th, boolean z) {
        PrintStream printStream;
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        if (TbConfig.getDebugSwitch() && isOOM(th)) {
            dumpOOM();
        }
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                printStream = new PrintStream(byteArrayOutputStream);
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
                } catch (Exception e) {
                    e = e;
                    byteArrayOutputStream2 = byteArrayOutputStream;
                    try {
                        e.printStackTrace();
                        CloseUtil.close((OutputStream) printStream);
                        CloseUtil.close((OutputStream) byteArrayOutputStream2);
                        if (z) {
                            return;
                        }
                        if (!TbConfig.getDebugSwitch() || this.handler == null) {
                            Process.killProcess(Process.myPid());
                        } else {
                            this.handler.uncaughtException(thread, th);
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        byteArrayOutputStream = byteArrayOutputStream2;
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
                } catch (Throwable th3) {
                    th = th3;
                    CloseUtil.close((OutputStream) printStream);
                    CloseUtil.close((OutputStream) byteArrayOutputStream);
                    if (!z) {
                    }
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
                printStream = null;
                byteArrayOutputStream2 = byteArrayOutputStream;
            } catch (Throwable th4) {
                th = th4;
                printStream = null;
            }
        } catch (Exception e3) {
            e = e3;
            printStream = null;
        } catch (Throwable th5) {
            th = th5;
            printStream = null;
            byteArrayOutputStream = null;
        }
    }

    private void addInfo(FileWriter fileWriter, String str, String str2) {
        try {
            fileWriter.append((CharSequence) str);
            if (str2 != null) {
                fileWriter.append(ETAG.EQUAL);
                fileWriter.append((CharSequence) str2);
            }
            fileWriter.append("\n");
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:31:0x0124 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.baidu.live.tbadk.core.data.ExceptionData] */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.io.Writer] */
    /* JADX WARN: Type inference failed for: r1v3 */
    private void writeToFile(Thread thread, Throwable th, String str) {
        FileWriter fileWriter;
        Exception e;
        FileWriter fileWriter2 = null;
        ?? r1 = this.mInfo;
        try {
            if (r1 != 0) {
                try {
                    File CreateFileIfNotFound = FileHelper.CreateFileIfNotFound(str);
                    if (CreateFileIfNotFound != null) {
                        fileWriter = new FileWriter(CreateFileIfNotFound, true);
                        try {
                            addInfo(fileWriter, StringHelper.getCurrentString(), null);
                            addInfo(fileWriter, "tblive_crash_new_info_end", null);
                            addInfo(fileWriter, "version", TbConfig.getVersion());
                            addInfo(fileWriter, "model", Build.MODEL);
                            addInfo(fileWriter, "android_version", Build.VERSION.RELEASE);
                            addInfo(fileWriter, MapController.ANDROID_SDK_LAYER_TAG, String.valueOf(Build.VERSION.SDK_INT));
                            addInfo(fileWriter, "uid", TbadkCoreApplication.getCurrentAccount());
                            addInfo(fileWriter, "client_id", TbadkCoreApplication.getClientId());
                            if (!TextUtils.isEmpty(TbConfig.getSubappType())) {
                                addInfo(fileWriter, "subapp_type", TbConfig.getSubappType());
                            }
                            addInfo(fileWriter, "imei", TbadkCoreApplication.getInst().getImei());
                            addInfo(fileWriter, BdStatsConstant.StatsKey.UNAME, TbadkCoreApplication.getCurrentAccountName());
                            addInfo(fileWriter, PushConstants.INTENT_ACTIVITY_NAME, TiebaStaticHelper.getCurrentActivityAllName());
                            addInfo(fileWriter, "maxMemory", String.valueOf(Runtime.getRuntime().maxMemory()));
                            addInfo(fileWriter, BdStatsConstant.StatsKey.CRASH_TYPE, th.getClass().getName());
                            addInfo(fileWriter, BdStatsConstant.StatsType.ERROR, this.mInfo.info);
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
                                        addInfo(fileWriter, "process_name", runningAppProcesses.get(i2).processName);
                                        break;
                                    }
                                }
                            }
                            addInfo(fileWriter, "tblive_crash_new_info_end", null);
                            fileWriter.append("\n");
                            fileWriter.flush();
                            fileWriter2 = fileWriter;
                        } catch (Exception e2) {
                            e = e2;
                            e.printStackTrace();
                            CloseUtil.close((Writer) fileWriter);
                            return;
                        }
                    }
                    CloseUtil.close((Writer) fileWriter2);
                } catch (Exception e3) {
                    fileWriter = null;
                    e = e3;
                } catch (Throwable th2) {
                    r1 = 0;
                    th = th2;
                    CloseUtil.close((Writer) r1);
                    throw th;
                }
            }
        } catch (Throwable th3) {
            th = th3;
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
        FileInputStream fileInputStream;
        Exception e;
        byte[] bArr;
        int read;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                try {
                    bArr = new byte[(int) file.length()];
                    int i = 0;
                    while (i < bArr.length && (read = fileInputStream.read(bArr, i, bArr.length - i)) >= 0) {
                        try {
                            i += read;
                        } catch (Exception e2) {
                            e = e2;
                            BdLog.e(e.toString());
                            CloseUtil.close((InputStream) fileInputStream);
                            return bArr;
                        }
                    }
                    CloseUtil.close((InputStream) fileInputStream);
                } catch (Throwable th) {
                    th = th;
                    CloseUtil.close((InputStream) fileInputStream);
                    throw th;
                }
            } catch (Exception e3) {
                bArr = null;
                e = e3;
            }
        } catch (Exception e4) {
            fileInputStream = null;
            e = e4;
            bArr = null;
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = null;
            CloseUtil.close((InputStream) fileInputStream);
            throw th;
        }
        return bArr;
    }
}
