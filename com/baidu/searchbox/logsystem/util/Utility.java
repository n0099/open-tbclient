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
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.android.util.io.Closeables;
import com.baidu.android.util.io.FileUtils;
import com.baidu.android.util.soloader.SoLoader;
import com.baidu.searchbox.aperf.runtime.AperfRuntime;
import com.baidu.searchbox.logsystem.logsys.LogExtra;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
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
/* loaded from: classes2.dex */
public class Utility {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "Utility";
    public transient /* synthetic */ FieldHolder $fh;

    public Utility() {
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

    public static final boolean createNewEmptyFile(@NonNull File file) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, file)) == null) {
            if (file.exists() && file.isFile()) {
                file.delete();
            }
            try {
                z = file.createNewFile();
            } catch (IOException e) {
                if (LLog.sDebug) {
                    e.printStackTrace();
                }
                z = false;
            }
            if (LLog.sDebug) {
                Log.d("Utility", "createNewEmptyFile() = " + z + ", file = " + file.getAbsolutePath());
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public static String formatTimeDuration(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65538, null, j)) == null) {
            if (j <= 0) {
                return String.valueOf(j);
            }
            long j2 = 86400000;
            long j3 = j / j2;
            long j4 = j - (j2 * j3);
            long j5 = 3600000;
            long j6 = j4 / j5;
            long j7 = j4 - (j5 * j6);
            long j8 = 60000;
            long j9 = j7 / j8;
            long j10 = j7 - (j8 * j9);
            long j11 = 1000;
            long j12 = j10 / j11;
            return j3 + " " + j6 + ":" + j9 + ":" + j12 + ":" + (j10 - (j11 * j12));
        }
        return (String) invokeJ.objValue;
    }

    @TargetApi(23)
    public static String getMemoryStats(@NonNull Debug.MemoryInfo memoryInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65539, null, memoryInfo)) != null) {
            return (String) invokeL.objValue;
        }
        Iterator<Map.Entry<String, String>> it = memoryInfo.getMemoryStats().entrySet().iterator();
        if (!it.hasNext()) {
            return StringUtil.EMPTY_ARRAY;
        }
        StringBuilder sb = new StringBuilder();
        sb.append('{');
        while (true) {
            Map.Entry<String, String> next = it.next();
            sb.append(next.getKey());
            sb.append('=');
            sb.append(next.getValue());
            if (!it.hasNext()) {
                sb.append('}');
                return sb.toString();
            }
            sb.append(',');
            sb.append(WebvttCueParser.CHAR_SPACE);
        }
    }

    @TargetApi(24)
    public static long getProcessStartElapsedRealTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? Process.getStartElapsedRealtime() : invokeV.longValue;
    }

    public static void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, null) == null) {
        }
    }

    public static final boolean isNetWorkEnabled(@NonNull Context context) {
        InterceptResult invokeL;
        NetworkInfo activeNetworkInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, context)) == null) {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
            if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
                return false;
            }
            return activeNetworkInfo.isAvailable();
        }
        return invokeL.booleanValue;
    }

    public static final boolean isWifiConnected(@NonNull Context context) {
        InterceptResult invokeL;
        NetworkInfo activeNetworkInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            return connectivityManager != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null && activeNetworkInfo.isAvailable() && activeNetworkInfo.getType() == 1;
        }
        return invokeL.booleanValue;
    }

    public static void obtainDBInfo(@NonNull Context context, @NonNull File file) {
        FileWriter fileWriter;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65544, null, context, file) == null) && file.exists() && file.isFile()) {
            FileWriter fileWriter2 = null;
            try {
                try {
                    fileWriter = new FileWriter(file, true);
                } catch (Exception e) {
                    e = e;
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                File parentFile = context.getFilesDir().getParentFile();
                fileWriter.write("DataBase list:");
                if (parentFile != null && parentFile.exists()) {
                    writeDBInfo(fileWriter, parentFile);
                }
                fileWriter.flush();
                Closeables.closeSafely(fileWriter);
            } catch (Exception e2) {
                e = e2;
                fileWriter2 = fileWriter;
                e.printStackTrace();
                Closeables.closeSafely(fileWriter2);
            } catch (Throwable th2) {
                th = th2;
                fileWriter2 = fileWriter;
                Closeables.closeSafely(fileWriter2);
                throw th;
            }
        }
    }

    public static final void obtainDeviceInfo(@NonNull Context context, @NonNull File file) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65545, null, context, file) != null) || !file.exists() || !file.isFile()) {
            return;
        }
        FileWriter fileWriter = null;
        try {
            String str = Build.MODEL;
            String str2 = "NUL";
            String replace = TextUtils.isEmpty(str) ? "NUL" : str.replace("_", "-");
            String str3 = Build.VERSION.RELEASE;
            String replace2 = TextUtils.isEmpty(str3) ? "0.0" : str3.replace("_", "-");
            String valueOf = String.valueOf(Build.VERSION.SDK_INT);
            String str4 = Build.MANUFACTURER;
            if (!TextUtils.isEmpty(str4)) {
                str2 = str4.replace("_", "-");
            }
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            int i = displayMetrics.widthPixels;
            int i2 = displayMetrics.heightPixels;
            float f = displayMetrics.density;
            FileWriter fileWriter2 = new FileWriter(file, true);
            try {
                StringBuilder sb = new StringBuilder();
                sb.append("Devices info = ");
                sb.append(replace + "_" + replace2 + "_" + valueOf + "_" + str2 + "_" + i + "*" + i2 + "*" + f);
                fileWriter2.write(sb.toString());
                fileWriter2.write("\nRuntime.getRuntime().availableProcessors() = " + Runtime.getRuntime().availableProcessors());
                fileWriter2.write("\nRomName = " + RomUtils.getName() + ", RomVersion = " + RomUtils.getVersion());
                fileWriter2.flush();
                Closeables.closeSafely(fileWriter2);
            } catch (Throwable th) {
                fileWriter = fileWriter2;
                th = th;
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

    public static final void obtainInstalledSoInfo(@NonNull Context context, @NonNull File file) {
        FileWriter fileWriter;
        File parentFile;
        File parentFile2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65546, null, context, file) == null) && file.exists() && file.isFile()) {
            FileWriter fileWriter2 = null;
            try {
                try {
                    fileWriter = new FileWriter(file, true);
                } catch (Throwable th) {
                    th = th;
                }
            } catch (FileNotFoundException e) {
                e = e;
            } catch (IOException e2) {
                e = e2;
            } catch (Exception e3) {
                e = e3;
            }
            try {
                fileWriter.write("data/app/{package_name-x} start\n");
                File file2 = new File(context.getApplicationInfo().sourceDir);
                if (file2.exists() && (parentFile2 = file2.getParentFile()) != null && parentFile2.exists()) {
                    fileWriter.write(parentFile2.getAbsolutePath());
                    if (LLog.sDebug) {
                        Log.d("Utility", parentFile2.getAbsolutePath() + "\n");
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
                            Log.d("Utility", file3.getAbsolutePath() + "\n");
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
                        Log.d("Utility", releaseSoFilePath.getAbsolutePath() + "\n");
                    }
                    printFilePathInfo(fileWriter, releaseSoFilePath, "");
                }
                fileWriter.write("/data/data/{package_name}/files/{released_so_directory} end\n\n\n");
                Closeables.closeSafely(fileWriter);
            } catch (FileNotFoundException e4) {
                e = e4;
                fileWriter2 = fileWriter;
                e.printStackTrace();
                Closeables.closeSafely(fileWriter2);
            } catch (IOException e5) {
                e = e5;
                fileWriter2 = fileWriter;
                e.printStackTrace();
                Closeables.closeSafely(fileWriter2);
            } catch (Exception e6) {
                e = e6;
                fileWriter2 = fileWriter;
                e.printStackTrace();
                Closeables.closeSafely(fileWriter2);
            } catch (Throwable th2) {
                th = th2;
                fileWriter2 = fileWriter;
                Closeables.closeSafely(fileWriter2);
                throw th;
            }
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:21:0x0053 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:31:0x0064 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:38:0x0012 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.baidu.titan.sdk.runtime.Interceptable] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v8, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r1v9 */
    public static final void obtainLogcatFile(@NonNull File file) {
        ?? r1;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            r1 = interceptable;
            if (r1.invokeL(65547, null, file) != null) {
                return;
            }
        }
        if (file.exists() && file.isFile()) {
            BufferedReader bufferedReader = null;
            try {
                try {
                    r1 = new FileOutputStream(file);
                    try {
                        BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("logcat -v time -t 1000").getInputStream()));
                        while (true) {
                            try {
                                String readLine = bufferedReader2.readLine();
                                if (readLine == null) {
                                    break;
                                }
                                r1.write(readLine.getBytes());
                                r1.write("\n".getBytes());
                            } catch (Exception e) {
                                e = e;
                                bufferedReader = bufferedReader2;
                                e.printStackTrace();
                                Closeables.closeSafely(bufferedReader);
                                r1 = r1;
                                Closeables.closeSafely((Closeable) r1);
                            } catch (Throwable th) {
                                th = th;
                                bufferedReader = bufferedReader2;
                                Closeables.closeSafely(bufferedReader);
                                Closeables.closeSafely((Closeable) r1);
                                throw th;
                            }
                        }
                        r1.flush();
                        Closeables.closeSafely(bufferedReader2);
                        r1 = r1;
                    } catch (Exception e2) {
                        e = e2;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Exception e3) {
                e = e3;
                r1 = 0;
            } catch (Throwable th3) {
                th = th3;
                r1 = 0;
            }
            Closeables.closeSafely((Closeable) r1);
        }
    }

    public static final void obtainMemoryInfo(@NonNull Context context, @NonNull File file) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65548, null, context, file) != null) || !file.exists() || !file.isFile()) {
            return;
        }
        FileWriter fileWriter = null;
        try {
            FileWriter fileWriter2 = new FileWriter(file, true);
            try {
                fileWriter2.write("Runtime.getRuntime() memory info:");
                fileWriter2.write("\nRuntime.getRuntime().maxMemory() = " + Runtime.getRuntime().maxMemory());
                fileWriter2.write("\nRuntime.getRuntime().totalMemory() = " + Runtime.getRuntime().totalMemory());
                fileWriter2.write("\nRuntime.getRuntime().freeMemory() = " + Runtime.getRuntime().freeMemory());
                ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
                ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                activityManager.getMemoryInfo(memoryInfo);
                fileWriter2.write("\n\nActivityManager.MemoryInfo");
                if (DeviceUtil.OSInfo.hasKitKat()) {
                    fileWriter2.write("\nisLowRamDevice = " + activityManager.isLowRamDevice());
                }
                fileWriter2.write("\nMemoryInfo.availMem = " + memoryInfo.availMem);
                fileWriter2.write("\nMemoryInfo.lowMemory = " + memoryInfo.lowMemory);
                fileWriter2.write("\nMemoryInfo.totalMem = " + memoryInfo.totalMem);
                fileWriter2.write("\nMemoryInfo.threshold = " + memoryInfo.threshold);
                Debug.MemoryInfo memoryInfo2 = new Debug.MemoryInfo();
                Debug.getMemoryInfo(memoryInfo2);
                fileWriter2.write("\n\nDebug.MemoryInfo");
                fileWriter2.write("\nMemoryInfo.dalvikPss = " + memoryInfo2.dalvikPss);
                fileWriter2.write("\nMemoryInfo.dalvikPrivateDirty = " + memoryInfo2.dalvikPrivateDirty);
                fileWriter2.write("\nMemoryInfo.dalvikSharedDirty = " + memoryInfo2.dalvikSharedDirty);
                fileWriter2.write("\nMemoryInfo.nativePss = " + memoryInfo2.nativePss);
                fileWriter2.write("\nMemoryInfo.nativePrivateDirty = " + memoryInfo2.nativePrivateDirty);
                fileWriter2.write("\nMemoryInfo.nativeSharedDirty = " + memoryInfo2.nativeSharedDirty);
                fileWriter2.write("\nMemoryInfo.otherPss = " + memoryInfo2.otherPss);
                fileWriter2.write("\nMemoryInfo.otherPrivateDirty = " + memoryInfo2.otherPrivateDirty);
                fileWriter2.write("\nMemoryInfo.otherSharedDirty = " + memoryInfo2.otherSharedDirty);
                fileWriter2.write("\nMemoryInfo.getTotalPss() = " + memoryInfo2.getTotalPss());
                if (DeviceUtil.OSInfo.hasKitKat()) {
                    fileWriter2.write("\nMemoryInfo.getTotalPrivateClean() = " + memoryInfo2.getTotalPrivateClean());
                }
                fileWriter2.write("\nMemoryInfo.getTotalPrivateDirty() = " + memoryInfo2.getTotalPrivateDirty());
                if (DeviceUtil.OSInfo.hasKitKat()) {
                    fileWriter2.write("\nMemoryInfo.getTotalSharedClean() = " + memoryInfo2.getTotalSharedClean());
                }
                fileWriter2.write("\nMemoryInfo.getTotalSharedDirty() = " + memoryInfo2.getTotalSharedDirty());
                if (DeviceUtil.OSInfo.hasKitKat()) {
                    fileWriter2.write("\nMemoryInfo.getTotalSwappablePss() = " + memoryInfo2.getTotalSwappablePss());
                }
                if (DeviceUtil.OSInfo.hasMarshMallow()) {
                    fileWriter2.write("MemoryInfo.getMemoryStats() = " + getMemoryStats(memoryInfo2));
                }
                fileWriter2.flush();
                Closeables.closeSafely(fileWriter2);
            } catch (Throwable th) {
                th = th;
                fileWriter = fileWriter2;
                try {
                    Log.d("Utility", Log.getStackTraceString(th));
                } finally {
                    Closeables.closeSafely(fileWriter);
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static final void obtainProcessFdInfo(@NonNull File file) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65549, null, file) == null) && file.exists() && file.isFile()) {
            InputStream inputStream = null;
            try {
                try {
                    Runtime runtime = Runtime.getRuntime();
                    inputStream = runtime.exec("ls -l " + ("/proc/" + Process.myPid() + "/fd")).getInputStream();
                    FileUtils.saveToFile(inputStream, file);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } finally {
                Closeables.closeSafely(inputStream);
            }
        }
    }

    public static final void obtainProcessMaps(@NonNull File file) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65550, null, file) == null) && file.exists() && file.isFile()) {
            int myPid = Process.myPid();
            File file2 = new File("/proc/" + myPid + "/maps");
            if (file2.exists()) {
                FileUtils.copyFile(file2, file);
            }
        }
    }

    public static final void obtainProcessRunningStatus(@Nullable Context context, @NonNull File file, @NonNull String str, @NonNull LogExtra logExtra) {
        FileWriter fileWriter;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLL(65551, null, context, file, str, logExtra) != null) || !file.exists() || !file.isFile()) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long elapsedCpuTime = Process.getElapsedCpuTime();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long processStartElapsedRealTime = DeviceUtil.OSInfo.hasNougat() ? getProcessStartElapsedRealTime() : -1L;
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss:SSS");
            FileWriter fileWriter2 = new FileWriter(file, true);
            try {
                fileWriter2.write("When crash happens:" + simpleDateFormat.format(new Date(currentTimeMillis)));
                fileWriter2.write("\nprocess name = " + str);
                try {
                    PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
                    fileWriter2.write("\nPackageInfo: " + packageInfo.versionCode + "_" + packageInfo.versionName);
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
                        Object invoke = ClassLoader.class.getDeclaredMethod("findLibrary", String.class).invoke(context.getClassLoader(), "art");
                        if (invoke != null) {
                            boolean contains = ((String) invoke).contains("lib64");
                            fileWriter2.write("\nProcess is64bit = " + contains);
                        } else {
                            fileWriter2.write("\nProcess is64bit = unknown");
                        }
                    } catch (Exception unused) {
                        fileWriter2.write("\nProcess is64bit = unknown");
                    }
                } else {
                    fileWriter2.write("\nProcess is64bit = false");
                }
                fileWriter2.write("\nCrash thread name = " + logExtra.mCrashThreadName + ", priority = " + logExtra.mCrashThreadPriority);
                StringBuilder sb = new StringBuilder();
                sb.append("\ntraceid = ");
                sb.append(AperfRuntime.Runtime.getProcessUUID());
                fileWriter2.write(sb.toString());
                fileWriter2.write("\nlog mJSONAttach = " + logExtra.mJSONAttach);
                fileWriter2.write("\nprocessid = " + Process.myPid());
                fileWriter2.flush();
                Closeables.closeSafely(fileWriter2);
            } catch (Throwable th) {
                th = th;
                fileWriter = fileWriter2;
                try {
                    Log.d("Utility", Log.getStackTraceString(th));
                } finally {
                    Closeables.closeSafely(fileWriter);
                }
            }
        } catch (Throwable th2) {
            th = th2;
            fileWriter = null;
        }
    }

    public static final void obtainProcessSmaps(@NonNull File file) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65552, null, file) == null) && file.exists() && file.isFile()) {
            File file2 = new File("/proc/self/smaps");
            if (file2.exists()) {
                FileUtils.copyFile(file2, file);
            }
        }
    }

    public static final void obtainProcessStatus(@NonNull File file) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65553, null, file) == null) && file.exists() && file.isFile()) {
            int myPid = Process.myPid();
            File file2 = new File("/proc/" + myPid + "/status");
            if (file2.exists()) {
                FileUtils.copyFile(file2, file);
            }
        }
    }

    public static final void obtainProcessThreadsInfo(@NonNull File file) {
        Map<Thread, StackTraceElement[]> allStackTraces;
        Set<Thread> keySet;
        FileWriter fileWriter;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65554, null, file) == null) && file.exists() && file.isFile() && (allStackTraces = Thread.getAllStackTraces()) != null && (keySet = allStackTraces.keySet()) != null) {
            FileWriter fileWriter2 = null;
            try {
                try {
                    fileWriter = new FileWriter(file, true);
                } catch (IOException e) {
                    e = e;
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                fileWriter.write("threads count:" + keySet.size() + "\n");
                int i = 0;
                for (Thread thread : keySet) {
                    if (thread != null) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(i);
                        sb.append(":");
                        sb.append(thread.getName());
                        sb.append("\n");
                        StackTraceElement[] stackTrace = thread.getStackTrace();
                        if (stackTrace != null) {
                            for (StackTraceElement stackTraceElement : stackTrace) {
                                if (stackTraceElement != null) {
                                    sb.append(stackTraceElement.toString());
                                    sb.append("\n");
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
            } catch (IOException e2) {
                e = e2;
                fileWriter2 = fileWriter;
                e.printStackTrace();
                Closeables.closeSafely(fileWriter2);
            } catch (Throwable th2) {
                th = th2;
                fileWriter2 = fileWriter;
                Closeables.closeSafely(fileWriter2);
                throw th;
            }
        }
    }

    public static final void printFilePathInfo(@NonNull FileWriter fileWriter, @NonNull File file, @NonNull String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65555, null, fileWriter, file, str) == null) && file.exists()) {
            try {
                fileWriter.write(str + file.getAbsolutePath());
                if (file.isFile()) {
                    fileWriter.write("\tlength=" + file.length() + ",lastModified=" + file.lastModified());
                }
                fileWriter.write("\n");
                if (LLog.sDebug) {
                    Log.d("Utility", str + file.getAbsolutePath() + "\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (file.isDirectory()) {
                File[] listFiles = file.listFiles();
                String str2 = str + " ";
                if (listFiles == null || listFiles.length <= 0) {
                    return;
                }
                for (File file2 : listFiles) {
                    printFilePathInfo(fileWriter, file2, str2);
                }
            }
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:40:0x006d */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v13 */
    /* JADX WARN: Type inference failed for: r8v4, types: [java.io.Closeable] */
    public static final Pair<String, Boolean> readFile(@NonNull File file, int i) {
        InterceptResult invokeLI;
        ?? r8;
        ByteArrayOutputStream byteArrayOutputStream;
        FileInputStream fileInputStream;
        byte[] bArr;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLI = interceptable.invokeLI(65556, null, file, i)) != null) {
            return (Pair) invokeLI.objValue;
        }
        FileInputStream fileInputStream2 = null;
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
            r8 = 0;
            Closeables.closeSafely(fileInputStream2);
            Closeables.closeSafely((Closeable) r8);
            throw th;
        }
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                Boolean bool = new Boolean(false);
                int i2 = 0;
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read != -1) {
                        if (i - i2 >= read) {
                            byteArrayOutputStream.write(bArr, 0, read);
                            i2 += read;
                        } else {
                            byteArrayOutputStream.write(bArr, 0, read);
                            bool = new Boolean(true);
                            break;
                        }
                    } else {
                        break;
                    }
                }
                Pair<String, Boolean> pair = new Pair<>(byteArrayOutputStream.toString(IMAudioTransRequest.CHARSET), bool);
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
            file = null;
            fileInputStream2 = fileInputStream;
            r8 = file;
            Closeables.closeSafely(fileInputStream2);
            Closeables.closeSafely((Closeable) r8);
            throw th;
        }
    }

    public static void writeDBInfo(@NonNull FileWriter fileWriter, @NonNull File file) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65557, null, fileWriter, file) == null) && file.exists()) {
            if (file.isDirectory()) {
                File[] listFiles = file.listFiles();
                if (listFiles == null || listFiles.length <= 0) {
                    return;
                }
                for (File file2 : listFiles) {
                    if (file2 != null && file2.exists()) {
                        writeDBInfo(fileWriter, file2);
                    }
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

    public static final void writeStringToFile(@NonNull File file, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65558, null, file, str) == null) {
            writeStringToFile(file, str, true);
        }
    }

    public static final void writeStringToFile(@NonNull File file, @NonNull String str, boolean z) {
        FileOutputStream fileOutputStream;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLZ(65559, null, file, str, z) == null) && file.exists() && file.isFile() && !TextUtils.isEmpty(str)) {
            FileOutputStream fileOutputStream2 = null;
            try {
                try {
                    fileOutputStream = new FileOutputStream(file, z);
                } catch (Throwable th) {
                    th = th;
                }
            } catch (Exception e) {
                e = e;
            }
            try {
                fileOutputStream.write(str.getBytes());
                fileOutputStream.flush();
                Closeables.closeSafely(fileOutputStream);
            } catch (Exception e2) {
                e = e2;
                fileOutputStream2 = fileOutputStream;
                e.printStackTrace();
                Closeables.closeSafely(fileOutputStream2);
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream2 = fileOutputStream;
                Closeables.closeSafely(fileOutputStream2);
                throw th;
            }
        }
    }
}
