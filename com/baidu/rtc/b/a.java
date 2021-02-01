package com.baidu.rtc.b;

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
/* loaded from: classes10.dex */
public class a {
    private final Context appContext;
    private int cyn;
    private long[] cyo;
    private boolean cyp;
    private int cyq;
    private double[] cyr;
    private String[] cys;
    private final C0314a cyt;
    private b cyu;
    private long cyv;
    private String[] cyw;
    private final C0314a cyx;
    private final C0314a cyy;
    private final C0314a cyz;
    private ScheduledExecutorService executor;
    private boolean initialized;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.rtc.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0314a {
        private double[] cyB;
        private int cyC;
        private double cyD;
        private double cyE;
        private final int size;

        public C0314a(int i) {
            if (i <= 0) {
                throw new AssertionError("Size value in MovingAverage ctor should be positive.");
            }
            this.size = i;
            this.cyB = new double[i];
        }

        public double afj() {
            return this.cyE / this.size;
        }

        public double afk() {
            return this.cyD;
        }

        public void l(double d) {
            this.cyE -= this.cyB[this.cyC];
            double[] dArr = this.cyB;
            int i = this.cyC;
            this.cyC = i + 1;
            dArr[i] = d;
            this.cyD = d;
            this.cyE += d;
            if (this.cyC >= this.size) {
                this.cyC = 0;
            }
        }

        public void reset() {
            Arrays.fill(this.cyB, 0.0d);
            this.cyC = 0;
            this.cyE = 0.0d;
            this.cyD = 0.0d;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class b {
        final long cyF;
        final long cyG;
        final long cyH;

        b(long j, long j2, long j3) {
            this.cyH = j;
            this.cyG = j2;
            this.cyF = j3;
        }
    }

    public a(Context context) {
        Log.d("CpuMonitor", "CpuMonitor ctor.");
        this.appContext = context.getApplicationContext();
        this.cyz = new C0314a(5);
        this.cyx = new C0314a(5);
        this.cyy = new C0314a(5);
        this.cyt = new C0314a(5);
        this.cyv = SystemClock.elapsedRealtime();
        afh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afb() {
        if (!afg() || SystemClock.elapsedRealtime() - this.cyv < 6000) {
            return;
        }
        this.cyv = SystemClock.elapsedRealtime();
        Log.d("CpuMonitor", afd());
    }

    private int afc() {
        Intent registerReceiver = this.appContext.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        int intExtra = registerReceiver.getIntExtra("scale", 100);
        if (intExtra > 0) {
            return (int) ((registerReceiver.getIntExtra("level", 0) * 100.0f) / intExtra);
        }
        return 0;
    }

    private String afd() {
        String sb;
        synchronized (this) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("CPU User: ");
            sb2.append(k(this.cyz.afk()));
            sb2.append("/");
            sb2.append(k(this.cyz.afj()));
            sb2.append(". System: ");
            sb2.append(k(this.cyx.afk()));
            sb2.append("/");
            sb2.append(k(this.cyx.afj()));
            sb2.append(". Freq: ");
            sb2.append(k(this.cyt.afk()));
            sb2.append("/");
            sb2.append(k(this.cyt.afj()));
            sb2.append(". Total usage: ");
            sb2.append(k(this.cyy.afk()));
            sb2.append("/");
            sb2.append(k(this.cyy.afj()));
            sb2.append(". Cores: ");
            sb2.append(this.cyn);
            sb2.append("( ");
            for (int i = 0; i < this.cyq; i++) {
                sb2.append(k(this.cyr[i]));
                sb2.append(" ");
            }
            sb2.append("). Battery: ");
            sb2.append(afc());
            if (this.cyp) {
                sb2.append(". Overuse.");
            }
            sb = sb2.toString();
        }
        return sb;
    }

    private b afe() {
        long j;
        long j2;
        long j3;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/stat"));
            try {
                String[] split = bufferedReader.readLine().split("\\s+");
                int length = split.length;
                if (length >= 5) {
                    j3 = parseLong(split[1]) + parseLong(split[2]);
                    j2 = parseLong(split[3]);
                    j = parseLong(split[4]);
                } else {
                    j = 0;
                    j2 = 0;
                    j3 = 0;
                }
                if (length >= 8) {
                    j3 += parseLong(split[5]);
                    j2 = j2 + parseLong(split[6]) + parseLong(split[7]);
                }
                return new b(j3, j2, j);
            } catch (Exception e) {
                Log.e("CpuMonitor", "Problems parsing /proc/stat", e);
                return null;
            } finally {
                bufferedReader.close();
            }
        } catch (FileNotFoundException e2) {
            Log.e("CpuMonitor", "Cannot open /proc/stat for reading", e2);
            return null;
        } catch (IOException e3) {
            Log.e("CpuMonitor", "Problems reading /proc/stat", e3);
            return null;
        }
    }

    private void aff() {
        synchronized (this) {
            this.cyz.reset();
            this.cyx.reset();
            this.cyy.reset();
            this.cyt.reset();
            this.cyv = SystemClock.elapsedRealtime();
        }
    }

    private boolean afg() {
        long j;
        synchronized (this) {
            if (!this.initialized) {
                init();
            }
            if (this.cyq == 0) {
                return false;
            }
            this.cyn = 0;
            int i = 0;
            long j2 = 0;
            long j3 = 0;
            long j4 = 0;
            while (i < this.cyq) {
                this.cyr[i] = 0.0d;
                if (this.cyo[i] == 0) {
                    j = jF(this.cyw[i]);
                    if (j > 0) {
                        Log.d("CpuMonitor", "Core " + i + ". Max frequency: " + j);
                        this.cyo[i] = j;
                        this.cyw[i] = null;
                    } else {
                        j = j3;
                    }
                } else {
                    j = this.cyo[i];
                }
                long jF = jF(this.cys[i]);
                int i2 = (jF > 0L ? 1 : (jF == 0L ? 0 : -1));
                if (i2 != 0 || j != 0) {
                    if (i2 > 0) {
                        this.cyn++;
                    }
                    j4 += jF;
                    j2 += j;
                    if (j > 0) {
                        this.cyr[i] = jF / j;
                    }
                }
                i++;
                j3 = j;
            }
            if (j4 == 0 || j2 == 0) {
                Log.e("CpuMonitor", "Could not read max or current frequency for any CPU");
                return false;
            }
            double d = j4 / j2;
            if (this.cyt.afk() > 0.0d) {
                d = (d + this.cyt.afk()) * 0.5d;
            }
            this.cyt.l(d);
            if (Build.VERSION.SDK_INT < 19 || Build.VERSION.SDK_INT > 24) {
                return true;
            }
            b afe = afe();
            if (afe == null) {
                return false;
            }
            long j5 = afe.cyH - this.cyu.cyH;
            long j6 = afe.cyG - this.cyu.cyG;
            long j7 = j5 + j6 + (afe.cyF - this.cyu.cyF);
            if (d == 0.0d || j7 == 0) {
                return false;
            }
            double d2 = j7;
            double d3 = j5 / d2;
            this.cyz.l(d3);
            double d4 = j6 / d2;
            this.cyx.l(d4);
            this.cyy.l(d * (d3 + d4));
            this.cyu = afe;
            return true;
        }
    }

    private void afh() {
        if (this.executor != null) {
            this.executor.shutdownNow();
            this.executor = null;
        }
        this.executor = Executors.newSingleThreadScheduledExecutor();
        this.executor.scheduleAtFixedRate(new Runnable() { // from class: com.baidu.rtc.b.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.afb();
            }
        }, 0L, 2000L, TimeUnit.MILLISECONDS);
    }

    private void init() {
        try {
            FileReader fileReader = new FileReader("/sys/devices/system/cpu/present");
            try {
                try {
                    Scanner useDelimiter = new Scanner(new BufferedReader(fileReader)).useDelimiter("[-\n]");
                    useDelimiter.nextInt();
                    this.cyq = useDelimiter.nextInt() + 1;
                    useDelimiter.close();
                } catch (Exception e) {
                    Log.e("CpuMonitor", "Cannot do CPU stats due to /sys/devices/system/cpu/present parsing problem");
                }
            } finally {
                fileReader.close();
            }
        } catch (FileNotFoundException e2) {
            Log.e("CpuMonitor", "Cannot do CPU stats since /sys/devices/system/cpu/present is missing");
        } catch (IOException e3) {
            Log.e("CpuMonitor", "Error closing file");
        }
        this.cyo = new long[this.cyq];
        this.cyw = new String[this.cyq];
        this.cys = new String[this.cyq];
        this.cyr = new double[this.cyq];
        for (int i = 0; i < this.cyq; i++) {
            this.cyo[i] = 0;
            this.cyr[i] = 0.0d;
            String[] strArr = this.cyw;
            strArr[i] = "/sys/devices/system/cpu/cpu" + i + "/cpufreq/cpuinfo_max_freq";
            String[] strArr2 = this.cys;
            strArr2[i] = "/sys/devices/system/cpu/cpu" + i + "/cpufreq/scaling_cur_freq";
        }
        this.cyu = new b(0L, 0L, 0L);
        aff();
        this.initialized = true;
    }

    private long jF(String str) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(str));
            try {
                long parseLong = parseLong(bufferedReader.readLine());
                try {
                    bufferedReader.close();
                    return parseLong;
                } catch (FileNotFoundException e) {
                    return parseLong;
                } catch (IOException e2) {
                    return parseLong;
                }
            } catch (Throwable th) {
                bufferedReader.close();
                throw th;
            }
        } catch (FileNotFoundException | IOException e3) {
            return 0L;
        }
    }

    private int k(double d) {
        return (int) ((100.0d * d) + 0.5d);
    }

    private static long parseLong(String str) {
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException e) {
            Log.e("CpuMonitor", "parseLong error.", e);
            return 0L;
        }
    }

    public int afi() {
        int k;
        synchronized (this) {
            k = k(this.cyt.afj());
        }
        return k;
    }

    public void pause() {
        if (this.executor != null) {
            Log.d("CpuMonitor", "pause");
            this.executor.shutdownNow();
            this.executor = null;
        }
    }
}
