package com.baidu.searchbox.logsystem.util;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Debug;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.android.util.io.Closeables;
import com.baidu.android.util.io.FileUtils;
import com.baidu.android.util.soloader.SoLoader;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.searchbox.aperf.runtime.AperfRuntime;
import com.baidu.searchbox.logsystem.logsys.LogExtra;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
/* loaded from: classes6.dex */
public class Utility {
    private static final String TAG = "Utility";

    public static void init() {
    }

    public static final boolean isNetWorkEnabled(@NonNull Context context) {
        NetworkInfo activeNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
        if (connectivityManager != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null) {
            return activeNetworkInfo.isAvailable();
        }
        return false;
    }

    public static final boolean isWifiConnected(@NonNull Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            return false;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isAvailable() && activeNetworkInfo.getType() == 1;
    }

    public static final void writeStringToFile(@NonNull File file, @NonNull String str) {
        writeStringToFile(file, str, true);
    }

    public static final void writeStringToFile(@NonNull File file, @NonNull String str, boolean z) {
        FileOutputStream fileOutputStream;
        if (file.exists() && file.isFile() && !TextUtils.isEmpty(str)) {
            try {
                try {
                    fileOutputStream = new FileOutputStream(file, z);
                    try {
                        fileOutputStream.write(str.getBytes());
                        fileOutputStream.flush();
                        Closeables.closeSafely(fileOutputStream);
                    } catch (Exception e) {
                        e = e;
                        e.printStackTrace();
                        Closeables.closeSafely(fileOutputStream);
                    }
                } catch (Throwable th) {
                    th = th;
                    Closeables.closeSafely(fileOutputStream);
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
                fileOutputStream = null;
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = null;
                Closeables.closeSafely(fileOutputStream);
                throw th;
            }
        }
    }

    public static final void obtainProcessThreadsInfo(@NonNull File file) {
        Map<Thread, StackTraceElement[]> allStackTraces;
        Set<Thread> keySet;
        FileWriter fileWriter;
        if (file.exists() && file.isFile() && (allStackTraces = Thread.getAllStackTraces()) != null && (keySet = allStackTraces.keySet()) != null) {
            try {
                fileWriter = new FileWriter(file, true);
                try {
                    try {
                        fileWriter.write("threads count:" + keySet.size() + "\n");
                        int i = 0;
                        for (Thread thread : keySet) {
                            if (thread != null) {
                                StringBuilder sb = new StringBuilder();
                                sb.append(i).append(":").append(thread.getName()).append("\n");
                                StackTraceElement[] stackTrace = thread.getStackTrace();
                                if (stackTrace != null) {
                                    for (StackTraceElement stackTraceElement : stackTrace) {
                                        if (stackTraceElement != null) {
                                            sb.append(stackTraceElement.toString()).append("\n");
                                        }
                                    }
                                }
                                sb.append("\n");
                                fileWriter.write(sb.toString());
                                i++;
                            }
                        }
                        fileWriter.flush();
                        Closeables.closeSafely(fileWriter);
                    } catch (IOException e) {
                        e = e;
                        e.printStackTrace();
                        Closeables.closeSafely(fileWriter);
                    }
                } catch (Throwable th) {
                    th = th;
                    Closeables.closeSafely(fileWriter);
                    throw th;
                }
            } catch (IOException e2) {
                e = e2;
                fileWriter = null;
            } catch (Throwable th2) {
                th = th2;
                fileWriter = null;
                Closeables.closeSafely(fileWriter);
                throw th;
            }
        }
    }

    public static final void obtainProcessFdInfo(@NonNull File file) {
        if (file.exists() && file.isFile()) {
            InputStream inputStream = null;
            try {
                inputStream = Runtime.getRuntime().exec("ls -l " + ("/proc/" + Process.myPid() + "/fd")).getInputStream();
                FileUtils.saveToFile(inputStream, file);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                Closeables.closeSafely(inputStream);
            }
        }
    }

    public static final void obtainProcessStatus(@NonNull File file) {
        if (file.exists() && file.isFile()) {
            File file2 = new File("/proc/" + Process.myPid() + "/status");
            if (file2.exists()) {
                FileUtils.copyFile(file2, file);
            }
        }
    }

    public static final void obtainProcessMaps(@NonNull File file) {
        if (file.exists() && file.isFile()) {
            File file2 = new File("/proc/" + Process.myPid() + "/maps");
            if (file2.exists()) {
                FileUtils.copyFile(file2, file);
            }
        }
    }

    public static final void obtainProcessSmaps(@NonNull File file) {
        if (file.exists() && file.isFile()) {
            File file2 = new File("/proc/self/smaps");
            if (file2.exists()) {
                FileUtils.copyFile(file2, file);
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [303=4] */
    public static final void obtainLogcatFile(@NonNull File file) {
        FileOutputStream fileOutputStream;
        Closeable closeable;
        BufferedReader bufferedReader;
        if (!file.exists()) {
            return;
        }
        try {
            if (!file.isFile()) {
                return;
            }
            try {
                fileOutputStream = new FileOutputStream(file);
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("logcat -v time -t 1000").getInputStream()));
                    while (true) {
                        try {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                fileOutputStream.flush();
                                Closeables.closeSafely(bufferedReader);
                                Closeables.closeSafely(fileOutputStream);
                                return;
                            }
                            fileOutputStream.write(readLine.getBytes());
                            fileOutputStream.write("\n".getBytes());
                        } catch (Exception e) {
                            e = e;
                            e.printStackTrace();
                            Closeables.closeSafely(bufferedReader);
                            Closeables.closeSafely(fileOutputStream);
                            return;
                        }
                    }
                } catch (Exception e2) {
                    e = e2;
                    bufferedReader = null;
                } catch (Throwable th) {
                    th = th;
                    closeable = null;
                    Closeables.closeSafely(closeable);
                    Closeables.closeSafely(fileOutputStream);
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
                bufferedReader = null;
                fileOutputStream = null;
            } catch (Throwable th2) {
                th = th2;
                closeable = null;
                fileOutputStream = null;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    private static final void printFilePathInfo(@NonNull FileWriter fileWriter, @NonNull File file, @NonNull String str) {
        if (file.exists()) {
            try {
                fileWriter.write(str + file.getAbsolutePath());
                if (file.isFile()) {
                    fileWriter.write("\tlength=" + file.length() + ",lastModified=" + file.lastModified());
                }
                fileWriter.write("\n");
                if (LLog.sDebug) {
                    Log.d(TAG, str + file.getAbsolutePath() + "\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (file.isDirectory()) {
                File[] listFiles = file.listFiles();
                String str2 = str + " ";
                if (listFiles != null && listFiles.length > 0) {
                    for (File file2 : listFiles) {
                        printFilePathInfo(fileWriter, file2, str2);
                    }
                }
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [411=4] */
    public static final void obtainInstalledSoInfo(@NonNull Context context, @NonNull File file) {
        FileWriter fileWriter;
        File parentFile;
        File parentFile2;
        if (!file.exists() || !file.isFile()) {
            return;
        }
        try {
            try {
                fileWriter = new FileWriter(file, true);
                try {
                    fileWriter.write("data/app/{package_name-x} start\n");
                    File file2 = new File(context.getApplicationInfo().sourceDir);
                    if (file2 != null && file2.exists() && (parentFile2 = file2.getParentFile()) != null && parentFile2.exists()) {
                        fileWriter.write(parentFile2.getAbsolutePath());
                        if (LLog.sDebug) {
                            Log.d(TAG, parentFile2.getAbsolutePath() + "\n");
                        }
                        printFilePathInfo(fileWriter, parentFile2, "");
                    }
                    fileWriter.write("data/app/{package_name-x} end\n\n\n");
                    fileWriter.write("/data/data/{package_name}/lib start\n");
                    File filesDir = context.getFilesDir();
                    if (filesDir != null && filesDir.exists() && (parentFile = filesDir.getParentFile()) != null && parentFile.exists()) {
                        File file3 = new File(parentFile, "lib");
                        if (file3.exists()) {
                            fileWriter.write(file3.getAbsolutePath());
                            if (LLog.sDebug) {
                                Log.d(TAG, file3.getAbsolutePath() + "\n");
                            }
                            printFilePathInfo(fileWriter, file3, "");
                        }
                    }
                    fileWriter.write("/data/data/{package_name}/lib end\n\n\n");
                    fileWriter.write("/data/data/{package_name}/files/{released_so_directory} start\n");
                    File releaseSoFilePath = SoLoader.getReleaseSoFilePath(context);
                    if (releaseSoFilePath != null && releaseSoFilePath.exists()) {
                        fileWriter.write(releaseSoFilePath.getAbsolutePath());
                        if (LLog.sDebug) {
                            Log.d(TAG, releaseSoFilePath.getAbsolutePath() + "\n");
                        }
                        printFilePathInfo(fileWriter, releaseSoFilePath, "");
                    }
                    fileWriter.write("/data/data/{package_name}/files/{released_so_directory} end\n\n\n");
                    Closeables.closeSafely(fileWriter);
                } catch (FileNotFoundException e) {
                    e = e;
                    e.printStackTrace();
                    Closeables.closeSafely(fileWriter);
                } catch (IOException e2) {
                    e = e2;
                    e.printStackTrace();
                    Closeables.closeSafely(fileWriter);
                } catch (Exception e3) {
                    e = e3;
                    e.printStackTrace();
                    Closeables.closeSafely(fileWriter);
                }
            } catch (Throwable th) {
                th = th;
                Closeables.closeSafely((Closeable) null);
                throw th;
            }
        } catch (FileNotFoundException e4) {
            e = e4;
            fileWriter = null;
        } catch (IOException e5) {
            e = e5;
            fileWriter = null;
        } catch (Exception e6) {
            e = e6;
            fileWriter = null;
        } catch (Throwable th2) {
            th = th2;
            Closeables.closeSafely((Closeable) null);
            throw th;
        }
    }

    @TargetApi(24)
    public static long getProcessStartElapsedRealTime() {
        return Process.getStartElapsedRealtime();
    }

    public static void obtainDBInfo(@NonNull Context context, @NonNull File file) {
        FileWriter fileWriter;
        if (file.exists() && file.isFile()) {
            try {
                try {
                    fileWriter = new FileWriter(file, true);
                    try {
                        File parentFile = context.getFilesDir().getParentFile();
                        fileWriter.write("DataBase list:");
                        if (parentFile != null && parentFile.exists()) {
                            writeDBInfo(fileWriter, parentFile);
                        }
                        fileWriter.flush();
                        Closeables.closeSafely(fileWriter);
                    } catch (Exception e) {
                        e = e;
                        e.printStackTrace();
                        Closeables.closeSafely(fileWriter);
                    }
                } catch (Throwable th) {
                    th = th;
                    Closeables.closeSafely((Closeable) null);
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
                fileWriter = null;
            } catch (Throwable th2) {
                th = th2;
                Closeables.closeSafely((Closeable) null);
                throw th;
            }
        }
    }

    private static void writeDBInfo(@NonNull FileWriter fileWriter, @NonNull File file) {
        if (file.exists()) {
            if (file.isDirectory()) {
                File[] listFiles = file.listFiles();
                if (listFiles != null && listFiles.length > 0) {
                    for (File file2 : listFiles) {
                        if (file2 != null && file2.exists()) {
                            writeDBInfo(fileWriter, file2);
                        }
                    }
                    return;
                }
                return;
            }
            String absolutePath = file.getAbsolutePath();
            if (absolutePath.endsWith(".db")) {
                try {
                    fileWriter.write("\n" + absolutePath + "=" + file.length());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [548=4] */
    public static final void obtainProcessRunningStatus(@Nullable Context context, @NonNull File file, @NonNull String str, @NonNull LogExtra logExtra) {
        FileWriter fileWriter;
        FileWriter fileWriter2;
        SimpleDateFormat simpleDateFormat;
        Object invoke;
        if (file.exists() && file.isFile()) {
            long currentTimeMillis = System.currentTimeMillis();
            long elapsedCpuTime = Process.getElapsedCpuTime();
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long processStartElapsedRealTime = DeviceUtil.OSInfo.hasNougat() ? getProcessStartElapsedRealTime() : -1L;
            try {
                simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss:SSS");
                fileWriter2 = new FileWriter(file, true);
            } catch (Throwable th) {
                th = th;
                fileWriter = null;
            }
            try {
                fileWriter2.write("When crash happens:" + simpleDateFormat.format(new Date(currentTimeMillis)));
                fileWriter2.write("\nprocess name = " + str);
                try {
                    try {
                        PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
                        fileWriter2.write("\nPackageInfo: " + packageInfo.versionCode + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + packageInfo.versionName);
                    } catch (Throwable th2) {
                        th = th2;
                        Closeables.closeSafely(fileWriter2);
                        throw th;
                    }
                } catch (PackageManager.NameNotFoundException e) {
                    e.printStackTrace();
                }
                fileWriter2.write("\nSystemClock.elapsedRealTime()=" + elapsedRealtime);
                fileWriter2.write("\nandroid.os.Process.getStartElapsedRealTime()=" + processStartElapsedRealTime);
                if (processStartElapsedRealTime != -1) {
                    fileWriter2.write("\nSystemClock.elapsedRealTime() - android.os.Process.getStartElapsedRealTime()=" + formatTimeDuration(elapsedRealtime - processStartElapsedRealTime));
                }
                fileWriter2.write("\nandroid.os.Process.getElapsedCpuTime()=" + elapsedCpuTime);
                if (Build.VERSION.SDK_INT >= 23) {
                    fileWriter2.write("\nProcess is64bit = " + Process.is64Bit());
                } else if (Build.VERSION.SDK_INT >= 21) {
                    try {
                        if (ClassLoader.class.getDeclaredMethod("findLibrary", String.class).invoke(context.getClassLoader(), "art") != null) {
                            fileWriter2.write("\nProcess is64bit = " + ((String) invoke).contains("lib64"));
                        } else {
                            fileWriter2.write("\nProcess is64bit = unknown");
                        }
                    } catch (Exception e2) {
                        fileWriter2.write("\nProcess is64bit = unknown");
                    }
                } else {
                    fileWriter2.write("\nProcess is64bit = false");
                }
                fileWriter2.write("\nCrash thread name = " + logExtra.mCrashThreadName + ", priority = " + logExtra.mCrashThreadPriority);
                fileWriter2.write("\ntraceid = " + AperfRuntime.Runtime.getProcessUUID());
                fileWriter2.write("\nlog mJSONAttach = " + logExtra.mJSONAttach);
                fileWriter2.write("\nprocessid = " + Process.myPid());
                fileWriter2.flush();
                Closeables.closeSafely(fileWriter2);
            } catch (Throwable th3) {
                th = th3;
                fileWriter = fileWriter2;
                try {
                    Log.d(TAG, Log.getStackTraceString(th));
                    Closeables.closeSafely(fileWriter);
                } catch (Throwable th4) {
                    th = th4;
                    fileWriter2 = fileWriter;
                    Closeables.closeSafely(fileWriter2);
                    throw th;
                }
            }
        }
    }

    public static final void obtainDeviceInfo(@NonNull Context context, @NonNull File file) {
        String replace;
        String replace2;
        String replace3;
        if (file.exists() && file.isFile()) {
            FileWriter fileWriter = null;
            try {
                String str = Build.MODEL;
                if (TextUtils.isEmpty(str)) {
                    replace = "NUL";
                } else {
                    replace = str.replace(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                }
                String str2 = Build.VERSION.RELEASE;
                if (TextUtils.isEmpty(str2)) {
                    replace2 = "0.0";
                } else {
                    replace2 = str2.replace(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                }
                String valueOf = String.valueOf(Build.VERSION.SDK_INT);
                String str3 = Build.MANUFACTURER;
                if (TextUtils.isEmpty(str3)) {
                    replace3 = "NUL";
                } else {
                    replace3 = str3.replace(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                }
                DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
                int i = displayMetrics.widthPixels;
                int i2 = displayMetrics.heightPixels;
                StringBuilder append = new StringBuilder(replace).append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS).append(replace2).append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS).append(valueOf).append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS).append(replace3).append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS).append(i).append("*").append(i2).append("*").append(displayMetrics.density);
                FileWriter fileWriter2 = new FileWriter(file, true);
                try {
                    fileWriter2.write("Devices info = " + append.toString());
                    fileWriter2.write("\nRuntime.getRuntime().availableProcessors() = " + Runtime.getRuntime().availableProcessors());
                    fileWriter2.write("\nRomName = " + RomUtils.getName() + ", RomVersion = " + RomUtils.getVersion());
                    fileWriter2.flush();
                    Closeables.closeSafely(fileWriter2);
                } catch (Throwable th) {
                    th = th;
                    fileWriter = fileWriter2;
                    try {
                        th.printStackTrace();
                    } finally {
                        Closeables.closeSafely(fileWriter);
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    public static final void obtainMemoryInfo(@NonNull Context context, @NonNull File file) {
        FileWriter fileWriter;
        ActivityManager activityManager;
        ActivityManager.MemoryInfo memoryInfo;
        Debug.MemoryInfo memoryInfo2;
        if (file.exists() && file.isFile()) {
            try {
                fileWriter = new FileWriter(file, true);
            } catch (Throwable th) {
                th = th;
                fileWriter = null;
            }
            try {
                fileWriter.write("Runtime.getRuntime() memory info:");
                fileWriter.write("\nRuntime.getRuntime().maxMemory() = " + Runtime.getRuntime().maxMemory());
                fileWriter.write("\nRuntime.getRuntime().totalMemory() = " + Runtime.getRuntime().totalMemory());
                fileWriter.write("\nRuntime.getRuntime().freeMemory() = " + Runtime.getRuntime().freeMemory());
                ((ActivityManager) context.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getMemoryInfo(new ActivityManager.MemoryInfo());
                fileWriter.write("\n\nActivityManager.MemoryInfo");
                if (DeviceUtil.OSInfo.hasKitKat()) {
                    fileWriter.write("\nisLowRamDevice = " + activityManager.isLowRamDevice());
                }
                fileWriter.write("\nMemoryInfo.availMem = " + memoryInfo.availMem);
                fileWriter.write("\nMemoryInfo.lowMemory = " + memoryInfo.lowMemory);
                fileWriter.write("\nMemoryInfo.totalMem = " + memoryInfo.totalMem);
                fileWriter.write("\nMemoryInfo.threshold = " + memoryInfo.threshold);
                Debug.getMemoryInfo(new Debug.MemoryInfo());
                fileWriter.write("\n\nDebug.MemoryInfo");
                fileWriter.write("\nMemoryInfo.dalvikPss = " + memoryInfo2.dalvikPss);
                fileWriter.write("\nMemoryInfo.dalvikPrivateDirty = " + memoryInfo2.dalvikPrivateDirty);
                fileWriter.write("\nMemoryInfo.dalvikSharedDirty = " + memoryInfo2.dalvikSharedDirty);
                fileWriter.write("\nMemoryInfo.nativePss = " + memoryInfo2.nativePss);
                fileWriter.write("\nMemoryInfo.nativePrivateDirty = " + memoryInfo2.nativePrivateDirty);
                fileWriter.write("\nMemoryInfo.nativeSharedDirty = " + memoryInfo2.nativeSharedDirty);
                fileWriter.write("\nMemoryInfo.otherPss = " + memoryInfo2.otherPss);
                fileWriter.write("\nMemoryInfo.otherPrivateDirty = " + memoryInfo2.otherPrivateDirty);
                fileWriter.write("\nMemoryInfo.otherSharedDirty = " + memoryInfo2.otherSharedDirty);
                fileWriter.write("\nMemoryInfo.getTotalPss() = " + memoryInfo2.getTotalPss());
                if (DeviceUtil.OSInfo.hasKitKat()) {
                    fileWriter.write("\nMemoryInfo.getTotalPrivateClean() = " + memoryInfo2.getTotalPrivateClean());
                }
                fileWriter.write("\nMemoryInfo.getTotalPrivateDirty() = " + memoryInfo2.getTotalPrivateDirty());
                if (DeviceUtil.OSInfo.hasKitKat()) {
                    fileWriter.write("\nMemoryInfo.getTotalSharedClean() = " + memoryInfo2.getTotalSharedClean());
                }
                fileWriter.write("\nMemoryInfo.getTotalSharedDirty() = " + memoryInfo2.getTotalSharedDirty());
                if (DeviceUtil.OSInfo.hasKitKat()) {
                    fileWriter.write("\nMemoryInfo.getTotalSwappablePss() = " + memoryInfo2.getTotalSwappablePss());
                }
                if (DeviceUtil.OSInfo.hasMarshMallow()) {
                    fileWriter.write("MemoryInfo.getMemoryStats() = " + getMemoryStats(memoryInfo2));
                }
                fileWriter.flush();
            } catch (Throwable th2) {
                th = th2;
                try {
                    Log.d(TAG, Log.getStackTraceString(th));
                } finally {
                    Closeables.closeSafely(fileWriter);
                }
            }
        }
    }

    @TargetApi(23)
    private static String getMemoryStats(@NonNull Debug.MemoryInfo memoryInfo) {
        Iterator<Map.Entry<String, String>> it = memoryInfo.getMemoryStats().entrySet().iterator();
        if (!it.hasNext()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('{');
        while (true) {
            Map.Entry<String, String> next = it.next();
            sb.append(next.getKey());
            sb.append('=');
            sb.append(next.getValue());
            if (!it.hasNext()) {
                return sb.append('}').toString();
            }
            sb.append(',').append(' ');
        }
    }

    public static final boolean createNewEmptyFile(@NonNull File file) {
        boolean z = false;
        if (file.exists() && file.isFile()) {
            file.delete();
        }
        try {
            z = file.createNewFile();
        } catch (IOException e) {
            if (LLog.sDebug) {
                e.printStackTrace();
            }
        }
        if (LLog.sDebug) {
            Log.d(TAG, "createNewEmptyFile() = " + z + ", file = " + file.getAbsolutePath());
        }
        return z;
    }

    private static String formatTimeDuration(long j) {
        if (j <= 0) {
            return String.valueOf(j);
        }
        long j2 = j / 86400000;
        long j3 = (j - (86400000 * j2)) / 3600000;
        long j4 = ((j - (86400000 * j2)) - (3600000 * j3)) / 60000;
        long j5 = (((j - (86400000 * j2)) - (3600000 * j3)) - (60000 * j4)) / 1000;
        return j2 + " " + j3 + ":" + j4 + ":" + j5 + ":" + ((((j - (86400000 * j2)) - (3600000 * j3)) - (60000 * j4)) - (1000 * j5));
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [803=5, 804=4] */
    public static final Pair<String, Boolean> readFile(@NonNull File file, int i) {
        Closeable closeable;
        FileInputStream fileInputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        byte[] bArr;
        Boolean bool;
        int i2 = 0;
        if (i <= 0) {
            return null;
        }
        try {
            try {
                bArr = new byte[1024];
                fileInputStream = new FileInputStream(file);
            } catch (Throwable th) {
                th = th;
            }
        } catch (FileNotFoundException e) {
            e = e;
            byteArrayOutputStream = null;
            fileInputStream = null;
        } catch (IOException e2) {
            e = e2;
            byteArrayOutputStream = null;
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            closeable = null;
            fileInputStream = null;
        }
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                Boolean bool2 = new Boolean(false);
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read == -1) {
                        bool = bool2;
                        break;
                    } else if (i - i2 < read) {
                        byteArrayOutputStream.write(bArr, 0, read);
                        bool = new Boolean(true);
                        break;
                    } else {
                        byteArrayOutputStream.write(bArr, 0, read);
                        i2 += read;
                    }
                }
                Pair<String, Boolean> pair = new Pair<>(byteArrayOutputStream.toString("utf-8"), bool);
                Closeables.closeSafely(fileInputStream);
                Closeables.closeSafely(byteArrayOutputStream);
                return pair;
            } catch (FileNotFoundException e3) {
                e = e3;
                e.printStackTrace();
                Closeables.closeSafely(fileInputStream);
                Closeables.closeSafely(byteArrayOutputStream);
                return null;
            } catch (IOException e4) {
                e = e4;
                e.printStackTrace();
                Closeables.closeSafely(fileInputStream);
                Closeables.closeSafely(byteArrayOutputStream);
                return null;
            }
        } catch (FileNotFoundException e5) {
            e = e5;
            byteArrayOutputStream = null;
        } catch (IOException e6) {
            e = e6;
            byteArrayOutputStream = null;
        } catch (Throwable th3) {
            th = th3;
            closeable = null;
            Closeables.closeSafely(fileInputStream);
            Closeables.closeSafely(closeable);
            throw th;
        }
    }

    public static String getAppVersion(Context context) {
        String appVersion = LokiOverlayRuntime.getLokiOverlayContext().getAppVersion();
        if (TextUtils.isEmpty(appVersion)) {
            try {
                return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
                return "0.8";
            }
        }
        return appVersion;
    }
}
