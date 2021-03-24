package com.baidu.rtc.logreport;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.SystemClock;
import android.util.Log;
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
    public static final int CPU_STAT_LOG_PERIOD_MS = 6000;
    public static final int CPU_STAT_SAMPLE_PERIOD_MS = 2000;
    public static final int MOVING_AVERAGE_SAMPLES = 5;
    public static final String TAG = "CpuMonitor";
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
        public double[] circBuffer;
        public int circBufferIndex;
        public double currentValue;
        public final int size;
        public double sum;

        public MovingAverage(int i) {
            if (i <= 0) {
                throw new AssertionError("Size value in MovingAverage ctor should be positive.");
            }
            this.size = i;
            this.circBuffer = new double[i];
        }

        public void addValue(double d2) {
            double d3 = this.sum;
            double[] dArr = this.circBuffer;
            int i = this.circBufferIndex;
            double d4 = d3 - dArr[i];
            this.sum = d4;
            int i2 = i + 1;
            this.circBufferIndex = i2;
            dArr[i] = d2;
            this.currentValue = d2;
            this.sum = d4 + d2;
            if (i2 >= this.size) {
                this.circBufferIndex = 0;
            }
        }

        public double getAverage() {
            double d2 = this.sum;
            double d3 = this.size;
            Double.isNaN(d3);
            return d2 / d3;
        }

        public double getCurrent() {
            return this.currentValue;
        }

        public void reset() {
            Arrays.fill(this.circBuffer, 0.0d);
            this.circBufferIndex = 0;
            this.sum = 0.0d;
            this.currentValue = 0.0d;
        }
    }

    /* loaded from: classes2.dex */
    public static class ProcStat {
        public final long idleTime;
        public final long systemTime;
        public final long userTime;

        public ProcStat(long j, long j2, long j3) {
            this.userTime = j;
            this.systemTime = j2;
            this.idleTime = j3;
        }
    }

    public CpuMonitor(Context context) {
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
        if (!sampleCpuUtilization() || SystemClock.elapsedRealtime() - this.lastStatLogTimeMs < 6000) {
            return;
        }
        this.lastStatLogTimeMs = SystemClock.elapsedRealtime();
        Log.d(TAG, getStatString());
    }

    private int doubleToPercent(double d2) {
        return (int) ((d2 * 100.0d) + 0.5d);
    }

    private int getBatteryLevel() {
        Intent registerReceiver = this.appContext.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        int intExtra = registerReceiver.getIntExtra("scale", 100);
        if (intExtra > 0) {
            return (int) ((registerReceiver.getIntExtra("level", 0) * 100.0f) / intExtra);
        }
        return 0;
    }

    private String getStatString() {
        String sb;
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

    /* JADX WARN: Removed duplicated region for block: B:18:0x0056 A[LOOP:0: B:16:0x0052->B:18:0x0056, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void init() {
        String str;
        int i;
        try {
            FileReader fileReader = new FileReader("/sys/devices/system/cpu/present");
            try {
                Scanner useDelimiter = new Scanner(new BufferedReader(fileReader)).useDelimiter("[-\n]");
                useDelimiter.nextInt();
                this.cpusPresent = useDelimiter.nextInt() + 1;
                useDelimiter.close();
            } catch (Exception unused) {
                Log.e(TAG, "Cannot do CPU stats due to /sys/devices/system/cpu/present parsing problem");
            }
            fileReader.close();
        } catch (FileNotFoundException unused2) {
            str = "Cannot do CPU stats since /sys/devices/system/cpu/present is missing";
            Log.e(TAG, str);
            int i2 = this.cpusPresent;
            this.cpuFreqMax = new long[i2];
            this.maxPath = new String[i2];
            this.curPath = new String[i2];
            this.curFreqScales = new double[i2];
            while (i < this.cpusPresent) {
            }
            this.lastProcStat = new ProcStat(0L, 0L, 0L);
            resetStat();
            this.initialized = true;
        } catch (IOException unused3) {
            str = "Error closing file";
            Log.e(TAG, str);
            int i22 = this.cpusPresent;
            this.cpuFreqMax = new long[i22];
            this.maxPath = new String[i22];
            this.curPath = new String[i22];
            this.curFreqScales = new double[i22];
            while (i < this.cpusPresent) {
            }
            this.lastProcStat = new ProcStat(0L, 0L, 0L);
            resetStat();
            this.initialized = true;
        }
        int i222 = this.cpusPresent;
        this.cpuFreqMax = new long[i222];
        this.maxPath = new String[i222];
        this.curPath = new String[i222];
        this.curFreqScales = new double[i222];
        for (i = 0; i < this.cpusPresent; i++) {
            this.cpuFreqMax[i] = 0;
            this.curFreqScales[i] = 0.0d;
            String[] strArr = this.maxPath;
            strArr[i] = "/sys/devices/system/cpu/cpu" + i + "/cpufreq/cpuinfo_max_freq";
            String[] strArr2 = this.curPath;
            strArr2[i] = "/sys/devices/system/cpu/cpu" + i + "/cpufreq/scaling_cur_freq";
        }
        this.lastProcStat = new ProcStat(0L, 0L, 0L);
        resetStat();
        this.initialized = true;
    }

    public static long parseLong(String str) {
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException e2) {
            Log.e(TAG, "parseLong error.", e2);
            return 0L;
        }
    }

    private long readFreqFromFile(String str) {
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

    private ProcStat readProcStat() {
        String str;
        long j;
        long j2;
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

    private void resetStat() {
        synchronized (this) {
            this.userCpuUsage.reset();
            this.systemCpuUsage.reset();
            this.totalCpuUsage.reset();
            this.frequencyScale.reset();
            this.lastStatLogTimeMs = SystemClock.elapsedRealtime();
        }
    }

    private boolean sampleCpuUtilization() {
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
                        double[] dArr = this.curFreqScales;
                        double d2 = readFreqFromFile2;
                        double d3 = j3;
                        Double.isNaN(d2);
                        Double.isNaN(d3);
                        dArr[i] = d2 / d3;
                    }
                }
            }
            if (j == 0 || j2 == 0) {
                Log.e(TAG, "Could not read max or current frequency for any CPU");
                return false;
            }
            double d4 = j;
            double d5 = j2;
            Double.isNaN(d4);
            Double.isNaN(d5);
            double d6 = d4 / d5;
            if (this.frequencyScale.getCurrent() > 0.0d) {
                d6 = (this.frequencyScale.getCurrent() + d6) * 0.5d;
            }
            this.frequencyScale.addValue(d6);
            if (Build.VERSION.SDK_INT >= 19 && Build.VERSION.SDK_INT <= 24) {
                ProcStat readProcStat = readProcStat();
                if (readProcStat == null) {
                    return false;
                }
                long j4 = readProcStat.userTime - this.lastProcStat.userTime;
                long j5 = readProcStat.systemTime - this.lastProcStat.systemTime;
                long j6 = j4 + j5 + (readProcStat.idleTime - this.lastProcStat.idleTime);
                if (d6 == 0.0d || j6 == 0) {
                    return false;
                }
                double d7 = j4;
                double d8 = j6;
                Double.isNaN(d7);
                Double.isNaN(d8);
                double d9 = d7 / d8;
                this.userCpuUsage.addValue(d9);
                double d10 = j5;
                Double.isNaN(d10);
                Double.isNaN(d8);
                double d11 = d10 / d8;
                this.systemCpuUsage.addValue(d11);
                this.totalCpuUsage.addValue((d9 + d11) * d6);
                this.lastProcStat = readProcStat;
                return true;
            }
            return true;
        }
    }

    private void scheduleCpuUtilizationTask() {
        ScheduledExecutorService scheduledExecutorService = this.executor;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.shutdownNow();
            this.executor = null;
        }
        ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
        this.executor = newSingleThreadScheduledExecutor;
        newSingleThreadScheduledExecutor.scheduleAtFixedRate(new Runnable() { // from class: com.baidu.rtc.logreport.CpuMonitor.1
            @Override // java.lang.Runnable
            public void run() {
                CpuMonitor.this.cpuUtilizationTask();
            }
        }, 0L, 2000L, TimeUnit.MILLISECONDS);
    }

    public int getCpuUsageAverage() {
        synchronized (this) {
            if (Build.VERSION.SDK_INT >= 19 && Build.VERSION.SDK_INT <= 24) {
                return doubleToPercent(this.userCpuUsage.getAverage() + this.systemCpuUsage.getAverage());
            }
            return -1;
        }
    }

    public int getCpuUsageCurrent() {
        synchronized (this) {
            if (Build.VERSION.SDK_INT >= 19 && Build.VERSION.SDK_INT <= 24) {
                return doubleToPercent(this.userCpuUsage.getCurrent() + this.systemCpuUsage.getCurrent());
            }
            return -1;
        }
    }

    public int getFrequencyScaleAverage() {
        int doubleToPercent;
        synchronized (this) {
            doubleToPercent = doubleToPercent(this.frequencyScale.getAverage());
        }
        return doubleToPercent;
    }

    public void pause() {
        if (this.executor != null) {
            Log.d(TAG, "pause");
            this.executor.shutdownNow();
            this.executor = null;
        }
    }

    public void reset() {
        synchronized (this) {
            if (this.executor != null) {
                Log.d(TAG, "reset");
                resetStat();
                this.cpuOveruse = false;
            }
        }
    }

    public void resume() {
        Log.d(TAG, "resume");
        resetStat();
        scheduleCpuUtilizationTask();
    }
}
