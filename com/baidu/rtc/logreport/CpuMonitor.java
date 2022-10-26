package com.baidu.rtc.logreport;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.SystemClock;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.live.interfaces.defaultimpl.service.LivePreStartPlayServiceImpl;
import com.baidu.tbadk.core.leveiconlivepolling.PollingModel;
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

    private int doubleToPercent(double d) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, this, new Object[]{Double.valueOf(d)})) == null) ? (int) ((d * 100.0d) + 0.5d) : invokeCommon.intValue;
    }

    /* loaded from: classes2.dex */
    public class MovingAverage {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public double[] circBuffer;
        public int circBufferIndex;
        public double currentValue;
        public final int size;
        public double sum;

        public MovingAverage(int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            if (i > 0) {
                this.size = i;
                this.circBuffer = new double[i];
                return;
            }
            throw new AssertionError("Size value in MovingAverage ctor should be positive.");
        }

        public void addValue(double d) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Double.valueOf(d)}) == null) {
                double d2 = this.sum;
                double[] dArr = this.circBuffer;
                int i = this.circBufferIndex;
                double d3 = d2 - dArr[i];
                this.sum = d3;
                int i2 = i + 1;
                this.circBufferIndex = i2;
                dArr[i] = d;
                this.currentValue = d;
                this.sum = d3 + d;
                if (i2 >= this.size) {
                    this.circBufferIndex = 0;
                }
            }
        }

        public double getAverage() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.sum / this.size;
            }
            return invokeV.doubleValue;
        }

        public double getCurrent() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.currentValue;
            }
            return invokeV.doubleValue;
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
    public class ProcStat {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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

    public static long parseLong(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
            try {
                return Long.parseLong(str);
            } catch (NumberFormatException e) {
                Log.e(TAG, "parseLong error.", e);
                return 0L;
            }
        }
        return invokeL.longValue;
    }

    private long readFreqFromFile(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, this, str)) == null) {
            long j = 0;
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(str));
                j = parseLong(bufferedReader.readLine());
                bufferedReader.close();
            } catch (FileNotFoundException | IOException unused) {
            }
            return j;
        }
        return invokeL.longValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cpuUtilizationTask() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65538, this) == null) && sampleCpuUtilization() && SystemClock.elapsedRealtime() - this.lastStatLogTimeMs >= LivePreStartPlayServiceImpl.PLAYER_TIME_OUT_DURATION) {
            this.lastStatLogTimeMs = SystemClock.elapsedRealtime();
            Log.d(TAG, getStatString());
        }
    }

    private synchronized void resetStat() {
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
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
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

    public synchronized int getFrequencyScaleAverage() {
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
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.executor != null) {
            Log.d(TAG, "pause");
            this.executor.shutdownNow();
            this.executor = null;
        }
    }

    public synchronized void reset() {
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

    private int getBatteryLevel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            Intent registerReceiver = this.appContext.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            int intExtra = registerReceiver.getIntExtra("scale", 100);
            if (intExtra <= 0) {
                return 0;
            }
            return (int) ((registerReceiver.getIntExtra(PollingModel.LEVEL, 0) * 100.0f) / intExtra);
        }
        return invokeV.intValue;
    }

    public synchronized int getCpuUsageAverage() {
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

    public synchronized int getCpuUsageCurrent() {
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

    private synchronized String getStatString() {
        InterceptResult invokeV;
        String sb;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) {
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
                for (int i = 0; i < this.cpusPresent; i++) {
                    sb2.append(doubleToPercent(this.curFreqScales[i]));
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

    private void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
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
                } finally {
                    fileReader.close();
                }
            } catch (FileNotFoundException unused2) {
                Log.e(TAG, "Cannot do CPU stats since /sys/devices/system/cpu/present is missing");
            } catch (IOException unused3) {
                Log.e(TAG, "Error closing file");
            }
            int i = this.cpusPresent;
            this.cpuFreqMax = new long[i];
            this.maxPath = new String[i];
            this.curPath = new String[i];
            this.curFreqScales = new double[i];
            for (int i2 = 0; i2 < this.cpusPresent; i2++) {
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

    private ProcStat readProcStat() {
        InterceptResult invokeV;
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
                } catch (Exception e) {
                    Log.e(TAG, "Problems parsing /proc/stat", e);
                    return null;
                } finally {
                    bufferedReader.close();
                }
            } catch (FileNotFoundException e2) {
                Log.e(TAG, "Cannot open /proc/stat for reading", e2);
                return null;
            } catch (IOException e3) {
                Log.e(TAG, "Problems reading /proc/stat", e3);
                return null;
            }
        }
        return (ProcStat) invokeV.objValue;
    }

    private synchronized boolean sampleCpuUtilization() {
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
                for (int i = 0; i < this.cpusPresent; i++) {
                    this.curFreqScales[i] = 0.0d;
                    if (this.cpuFreqMax[i] == 0) {
                        long readFreqFromFile = readFreqFromFile(this.maxPath[i]);
                        if (readFreqFromFile > 0) {
                            Log.d(TAG, "Core " + i + ". Max frequency: " + readFreqFromFile);
                            this.cpuFreqMax[i] = readFreqFromFile;
                            this.maxPath[i] = null;
                            j3 = readFreqFromFile;
                        }
                    } else {
                        j3 = this.cpuFreqMax[i];
                    }
                    long readFreqFromFile2 = readFreqFromFile(this.curPath[i]);
                    int i2 = (readFreqFromFile2 > 0L ? 1 : (readFreqFromFile2 == 0L ? 0 : -1));
                    if (i2 != 0 || j3 != 0) {
                        if (i2 > 0) {
                            this.actualCpusPresent++;
                        }
                        j += readFreqFromFile2;
                        j2 += j3;
                        if (j3 > 0) {
                            this.curFreqScales[i] = readFreqFromFile2 / j3;
                        }
                    }
                }
                if (j != 0 && j2 != 0) {
                    double d = j / j2;
                    if (this.frequencyScale.getCurrent() > 0.0d) {
                        d = 0.5d * (this.frequencyScale.getCurrent() + d);
                    }
                    this.frequencyScale.addValue(d);
                    if (Build.VERSION.SDK_INT >= 19 && Build.VERSION.SDK_INT <= 24) {
                        ProcStat readProcStat = readProcStat();
                        if (readProcStat == null) {
                            return false;
                        }
                        long j4 = readProcStat.userTime - this.lastProcStat.userTime;
                        long j5 = readProcStat.systemTime - this.lastProcStat.systemTime;
                        long j6 = j4 + j5 + (readProcStat.idleTime - this.lastProcStat.idleTime);
                        if (d != 0.0d && j6 != 0) {
                            double d2 = j6;
                            double d3 = j4 / d2;
                            this.userCpuUsage.addValue(d3);
                            double d4 = j5 / d2;
                            this.systemCpuUsage.addValue(d4);
                            this.totalCpuUsage.addValue((d3 + d4) * d);
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
}
