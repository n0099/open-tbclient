package com.baidu.rtc.logreport;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.SystemClock;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
/* loaded from: classes2.dex */
public class CpuMonitor {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int CPU_STAT_LOG_PERIOD_MS = 6000;
    public static final int CPU_STAT_SAMPLE_PERIOD_MS = 2000;
    public static final int MOVING_AVERAGE_SAMPLES = 5;
    public static final String TAG = "CpuMonitor";
    public transient /* synthetic */ FieldHolder $fh;
    public int actualCpusPresent;
    public final Context appContext;
    public long[] cpuFreqMax;
    public boolean cpuOveruse;
    public int cpusPresent;
    public double[] curFreqScales;
    public String[] curPath;
    public ScheduledExecutorService executor;
    public final MovingAverage frequencyScale;
    public boolean initialized;
    public ProcStat lastProcStat;
    public long lastStatLogTimeMs;
    public String[] maxPath;
    public final MovingAverage systemCpuUsage;
    public final MovingAverage totalCpuUsage;
    public final MovingAverage userCpuUsage;

    /* loaded from: classes2.dex */
    public static class MovingAverage {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public double[] circBuffer;
        public int circBufferIndex;
        public double currentValue;
        public final int size;
        public double sum;

        public MovingAverage(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            if (i2 <= 0) {
                throw new AssertionError("Size value in MovingAverage ctor should be positive.");
            }
            this.size = i2;
            this.circBuffer = new double[i2];
        }

        public void addValue(double d2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Double.valueOf(d2)}) == null) {
                double d3 = this.sum;
                double[] dArr = this.circBuffer;
                int i2 = this.circBufferIndex;
                double d4 = d3 - dArr[i2];
                this.sum = d4;
                int i3 = i2 + 1;
                this.circBufferIndex = i3;
                dArr[i2] = d2;
                this.currentValue = d2;
                this.sum = d4 + d2;
                if (i3 >= this.size) {
                    this.circBufferIndex = 0;
                }
            }
        }

        public double getAverage() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.sum / this.size : invokeV.doubleValue;
        }

        public double getCurrent() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.currentValue : invokeV.doubleValue;
        }

        public void reset() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                Arrays.fill(this.circBuffer, 0.0d);
                this.circBufferIndex = 0;
                this.sum = 0.0d;
                this.currentValue = 0.0d;
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class ProcStat {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final long idleTime;
        public final long systemTime;
        public final long userTime;

        public ProcStat(long j, long j2, long j3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.userTime = j;
            this.systemTime = j2;
            this.idleTime = j3;
        }
    }

    public CpuMonitor(Context context) {
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
        Log.d(TAG, "CpuMonitor ctor.");
        this.appContext = context.getApplicationContext();
        this.userCpuUsage = new MovingAverage(5);
        this.systemCpuUsage = new MovingAverage(5);
        this.totalCpuUsage = new MovingAverage(5);
        this.frequencyScale = new MovingAverage(5);
        this.lastStatLogTimeMs = SystemClock.elapsedRealtime();
        scheduleCpuUtilizationTask();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cpuUtilizationTask() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65538, this) == null) && sampleCpuUtilization() && SystemClock.elapsedRealtime() - this.lastStatLogTimeMs >= 6000) {
            this.lastStatLogTimeMs = SystemClock.elapsedRealtime();
            Log.d(TAG, getStatString());
        }
    }

    private int doubleToPercent(double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, this, new Object[]{Double.valueOf(d2)})) == null) ? (int) ((d2 * 100.0d) + 0.5d) : invokeCommon.intValue;
    }

    private int getBatteryLevel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            Intent registerReceiver = this.appContext.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            int intExtra = registerReceiver.getIntExtra("scale", 100);
            if (intExtra > 0) {
                return (int) ((registerReceiver.getIntExtra("level", 0) * 100.0f) / intExtra);
            }
            return 0;
        }
        return invokeV.intValue;
    }

    private String getStatString() {
        InterceptResult invokeV;
        String sb;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this)) == null) {
            synchronized (this) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("CPU User: ");
                sb2.append(doubleToPercent(this.userCpuUsage.getCurrent()));
                sb2.append("/");
                sb2.append(doubleToPercent(this.userCpuUsage.getAverage()));
                sb2.append(". System: ");
                sb2.append(doubleToPercent(this.systemCpuUsage.getCurrent()));
                sb2.append("/");
                sb2.append(doubleToPercent(this.systemCpuUsage.getAverage()));
                sb2.append(". Freq: ");
                sb2.append(doubleToPercent(this.frequencyScale.getCurrent()));
                sb2.append("/");
                sb2.append(doubleToPercent(this.frequencyScale.getAverage()));
                sb2.append(". Total usage: ");
                sb2.append(doubleToPercent(this.totalCpuUsage.getCurrent()));
                sb2.append("/");
                sb2.append(doubleToPercent(this.totalCpuUsage.getAverage()));
                sb2.append(". Cores: ");
                sb2.append(this.actualCpusPresent);
                sb2.append("( ");
                for (int i2 = 0; i2 < this.cpusPresent; i2++) {
                    sb2.append(doubleToPercent(this.curFreqScales[i2]));
                    sb2.append(" ");
                }
                sb2.append("). Battery: ");
                sb2.append(getBatteryLevel());
                if (this.cpuOveruse) {
                    sb2.append(". Overuse.");
                }
                sb = sb2.toString();
            }
            return sb;
        }
        return (String) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x005a A[LOOP:0: B:18:0x0056->B:20:0x005a, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void init() {
        String str;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) {
            try {
                FileReader fileReader = new FileReader("/sys/devices/system/cpu/present");
                try {
                    try {
                        Scanner useDelimiter = new Scanner(new BufferedReader(fileReader)).useDelimiter("[-\n]");
                        useDelimiter.nextInt();
                        this.cpusPresent = useDelimiter.nextInt() + 1;
                        useDelimiter.close();
                    } catch (Exception unused) {
                        Log.e(TAG, "Cannot do CPU stats due to /sys/devices/system/cpu/present parsing problem");
                    }
                    fileReader.close();
                } catch (Throwable th) {
                    fileReader.close();
                    throw th;
                }
            } catch (FileNotFoundException unused2) {
                str = "Cannot do CPU stats since /sys/devices/system/cpu/present is missing";
                Log.e(TAG, str);
                int i3 = this.cpusPresent;
                this.cpuFreqMax = new long[i3];
                this.maxPath = new String[i3];
                this.curPath = new String[i3];
                this.curFreqScales = new double[i3];
                while (i2 < this.cpusPresent) {
                }
                this.lastProcStat = new ProcStat(0L, 0L, 0L);
                resetStat();
                this.initialized = true;
            } catch (IOException unused3) {
                str = "Error closing file";
                Log.e(TAG, str);
                int i32 = this.cpusPresent;
                this.cpuFreqMax = new long[i32];
                this.maxPath = new String[i32];
                this.curPath = new String[i32];
                this.curFreqScales = new double[i32];
                while (i2 < this.cpusPresent) {
                }
                this.lastProcStat = new ProcStat(0L, 0L, 0L);
                resetStat();
                this.initialized = true;
            }
            int i322 = this.cpusPresent;
            this.cpuFreqMax = new long[i322];
            this.maxPath = new String[i322];
            this.curPath = new String[i322];
            this.curFreqScales = new double[i322];
            for (i2 = 0; i2 < this.cpusPresent; i2++) {
                this.cpuFreqMax[i2] = 0;
                this.curFreqScales[i2] = 0.0d;
                String[] strArr = this.maxPath;
                strArr[i2] = "/sys/devices/system/cpu/cpu" + i2 + "/cpufreq/cpuinfo_max_freq";
                String[] strArr2 = this.curPath;
                strArr2[i2] = "/sys/devices/system/cpu/cpu" + i2 + "/cpufreq/scaling_cur_freq";
            }
            this.lastProcStat = new ProcStat(0L, 0L, 0L);
            resetStat();
            this.initialized = true;
        }
    }

    public static long parseLong(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
            try {
                return Long.parseLong(str);
            } catch (NumberFormatException e2) {
                Log.e(TAG, "parseLong error.", e2);
                return 0L;
            }
        }
        return invokeL.longValue;
    }

    private long readFreqFromFile(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, this, str)) == null) {
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(str));
                long parseLong = parseLong(bufferedReader.readLine());
                try {
                    bufferedReader.close();
                    return parseLong;
                } catch (FileNotFoundException | IOException unused) {
                    return parseLong;
                }
            } catch (FileNotFoundException | IOException unused2) {
                return 0L;
            }
        }
        return invokeL.longValue;
    }

    private ProcStat readProcStat() {
        InterceptResult invokeV;
        String str;
        long j;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) {
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/stat"));
                try {
                    String[] split = bufferedReader.readLine().split("\\s+");
                    int length = split.length;
                    long j3 = 0;
                    if (length >= 5) {
                        j3 = parseLong(split[1]) + parseLong(split[2]);
                        j = parseLong(split[3]);
                        j2 = parseLong(split[4]);
                    } else {
                        j = 0;
                        j2 = 0;
                    }
                    if (length >= 8) {
                        j3 += parseLong(split[5]);
                        j = j + parseLong(split[6]) + parseLong(split[7]);
                    }
                    return new ProcStat(j3, j, j2);
                } catch (Exception e2) {
                    Log.e(TAG, "Problems parsing /proc/stat", e2);
                    return null;
                } finally {
                    bufferedReader.close();
                }
            } catch (FileNotFoundException e3) {
                e = e3;
                str = "Cannot open /proc/stat for reading";
                Log.e(TAG, str, e);
                return null;
            } catch (IOException e4) {
                e = e4;
                str = "Problems reading /proc/stat";
                Log.e(TAG, str, e);
                return null;
            }
        }
        return (ProcStat) invokeV.objValue;
    }

    private void resetStat() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            synchronized (this) {
                this.userCpuUsage.reset();
                this.systemCpuUsage.reset();
                this.totalCpuUsage.reset();
                this.frequencyScale.reset();
                this.lastStatLogTimeMs = SystemClock.elapsedRealtime();
            }
        }
    }

    private boolean sampleCpuUtilization() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, this)) == null) {
            synchronized (this) {
                if (!this.initialized) {
                    init();
                }
                if (this.cpusPresent == 0) {
                    return false;
                }
                this.actualCpusPresent = 0;
                long j = 0;
                long j2 = 0;
                long j3 = 0;
                for (int i2 = 0; i2 < this.cpusPresent; i2++) {
                    this.curFreqScales[i2] = 0.0d;
                    if (this.cpuFreqMax[i2] == 0) {
                        long readFreqFromFile = readFreqFromFile(this.maxPath[i2]);
                        if (readFreqFromFile > 0) {
                            Log.d(TAG, "Core " + i2 + ". Max frequency: " + readFreqFromFile);
                            this.cpuFreqMax[i2] = readFreqFromFile;
                            this.maxPath[i2] = null;
                            j3 = readFreqFromFile;
                        }
                    } else {
                        j3 = this.cpuFreqMax[i2];
                    }
                    long readFreqFromFile2 = readFreqFromFile(this.curPath[i2]);
                    int i3 = (readFreqFromFile2 > 0L ? 1 : (readFreqFromFile2 == 0L ? 0 : -1));
                    if (i3 != 0 || j3 != 0) {
                        if (i3 > 0) {
                            this.actualCpusPresent++;
                        }
                        j += readFreqFromFile2;
                        j2 += j3;
                        if (j3 > 0) {
                            this.curFreqScales[i2] = readFreqFromFile2 / j3;
                        }
                    }
                }
                if (j != 0 && j2 != 0) {
                    double d2 = j / j2;
                    if (this.frequencyScale.getCurrent() > 0.0d) {
                        d2 = (this.frequencyScale.getCurrent() + d2) * 0.5d;
                    }
                    this.frequencyScale.addValue(d2);
                    if (Build.VERSION.SDK_INT >= 19 && Build.VERSION.SDK_INT <= 24) {
                        ProcStat readProcStat = readProcStat();
                        if (readProcStat == null) {
                            return false;
                        }
                        long j4 = readProcStat.userTime - this.lastProcStat.userTime;
                        long j5 = readProcStat.systemTime - this.lastProcStat.systemTime;
                        long j6 = j4 + j5 + (readProcStat.idleTime - this.lastProcStat.idleTime);
                        if (d2 != 0.0d && j6 != 0) {
                            double d3 = j4;
                            double d4 = j6;
                            double d5 = d3 / d4;
                            this.userCpuUsage.addValue(d5);
                            double d6 = j5 / d4;
                            this.systemCpuUsage.addValue(d6);
                            this.totalCpuUsage.addValue((d5 + d6) * d2);
                            this.lastProcStat = readProcStat;
                            return true;
                        }
                        return false;
                    }
                    return true;
                }
                Log.e(TAG, "Could not read max or current frequency for any CPU");
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    private void scheduleCpuUtilizationTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            ScheduledExecutorService scheduledExecutorService = this.executor;
            if (scheduledExecutorService != null) {
                scheduledExecutorService.shutdownNow();
                this.executor = null;
            }
            ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
            this.executor = newSingleThreadScheduledExecutor;
            newSingleThreadScheduledExecutor.scheduleAtFixedRate(new Runnable(this) { // from class: com.baidu.rtc.logreport.CpuMonitor.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ CpuMonitor this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.this$0.cpuUtilizationTask();
                    }
                }
            }, 0L, 2000L, TimeUnit.MILLISECONDS);
        }
    }

    public int getCpuUsageAverage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            synchronized (this) {
                if (Build.VERSION.SDK_INT >= 19 && Build.VERSION.SDK_INT <= 24) {
                    return doubleToPercent(this.userCpuUsage.getAverage() + this.systemCpuUsage.getAverage());
                }
                return -1;
            }
        }
        return invokeV.intValue;
    }

    public int getCpuUsageCurrent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            synchronized (this) {
                if (Build.VERSION.SDK_INT >= 19 && Build.VERSION.SDK_INT <= 24) {
                    return doubleToPercent(this.userCpuUsage.getCurrent() + this.systemCpuUsage.getCurrent());
                }
                return -1;
            }
        }
        return invokeV.intValue;
    }

    public int getFrequencyScaleAverage() {
        InterceptResult invokeV;
        int doubleToPercent;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this) {
                doubleToPercent = doubleToPercent(this.frequencyScale.getAverage());
            }
            return doubleToPercent;
        }
        return invokeV.intValue;
    }

    public void pause() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.executor == null) {
            return;
        }
        Log.d(TAG, "pause");
        this.executor.shutdownNow();
        this.executor = null;
    }

    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            synchronized (this) {
                if (this.executor != null) {
                    Log.d(TAG, "reset");
                    resetStat();
                    this.cpuOveruse = false;
                }
            }
        }
    }

    public void resume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            Log.d(TAG, "resume");
            resetStat();
            scheduleCpuUtilizationTask();
        }
    }
}
