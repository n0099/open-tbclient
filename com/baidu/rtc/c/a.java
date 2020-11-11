package com.baidu.rtc.c;

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
/* loaded from: classes9.dex */
public class a {
    private final Context appContext;
    private String[] cqA;
    private final C0326a cqB;
    private final C0326a cqC;
    private final C0326a cqD;
    private int cqr;
    private long[] cqs;
    private boolean cqt;
    private int cqu;
    private double[] cqv;
    private String[] cqw;
    private final C0326a cqx;
    private b cqy;
    private long cqz;
    private ScheduledExecutorService executor;
    private boolean initialized;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.rtc.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C0326a {
        private double[] cqF;
        private int cqG;
        private double cqH;
        private double cqI;
        private final int size;

        public C0326a(int i) {
            if (i <= 0) {
                throw new AssertionError("Size value in MovingAverage ctor should be positive.");
            }
            this.size = i;
            this.cqF = new double[i];
        }

        public double aeT() {
            return this.cqI / this.size;
        }

        public double aeU() {
            return this.cqH;
        }

        public void reset() {
            Arrays.fill(this.cqF, 0.0d);
            this.cqG = 0;
            this.cqI = 0.0d;
            this.cqH = 0.0d;
        }

        public void s(double d) {
            this.cqI -= this.cqF[this.cqG];
            double[] dArr = this.cqF;
            int i = this.cqG;
            this.cqG = i + 1;
            dArr[i] = d;
            this.cqH = d;
            this.cqI += d;
            if (this.cqG >= this.size) {
                this.cqG = 0;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public static class b {
        final long cqJ;
        final long cqK;
        final long cqL;

        b(long j, long j2, long j3) {
            this.cqL = j;
            this.cqK = j2;
            this.cqJ = j3;
        }
    }

    public a(Context context) {
        Log.d("CpuMonitor", "CpuMonitor ctor.");
        this.appContext = context.getApplicationContext();
        this.cqD = new C0326a(5);
        this.cqB = new C0326a(5);
        this.cqC = new C0326a(5);
        this.cqx = new C0326a(5);
        this.cqz = SystemClock.elapsedRealtime();
        aeR();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aeL() {
        if (!aeQ() || SystemClock.elapsedRealtime() - this.cqz < 6000) {
            return;
        }
        this.cqz = SystemClock.elapsedRealtime();
        Log.d("CpuMonitor", aeN());
    }

    private int aeM() {
        Intent registerReceiver = this.appContext.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        int intExtra = registerReceiver.getIntExtra("scale", 100);
        if (intExtra > 0) {
            return (int) ((registerReceiver.getIntExtra("level", 0) * 100.0f) / intExtra);
        }
        return 0;
    }

    private String aeN() {
        String sb;
        synchronized (this) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("CPU User: ");
            sb2.append(r(this.cqD.aeU()));
            sb2.append("/");
            sb2.append(r(this.cqD.aeT()));
            sb2.append(". System: ");
            sb2.append(r(this.cqB.aeU()));
            sb2.append("/");
            sb2.append(r(this.cqB.aeT()));
            sb2.append(". Freq: ");
            sb2.append(r(this.cqx.aeU()));
            sb2.append("/");
            sb2.append(r(this.cqx.aeT()));
            sb2.append(". Total usage: ");
            sb2.append(r(this.cqC.aeU()));
            sb2.append("/");
            sb2.append(r(this.cqC.aeT()));
            sb2.append(". Cores: ");
            sb2.append(this.cqr);
            sb2.append("( ");
            for (int i = 0; i < this.cqu; i++) {
                sb2.append(r(this.cqv[i]));
                sb2.append(" ");
            }
            sb2.append("). Battery: ");
            sb2.append(aeM());
            if (this.cqt) {
                sb2.append(". Overuse.");
            }
            sb = sb2.toString();
        }
        return sb;
    }

    private b aeO() {
        long j;
        long j2;
        long j3 = 0;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/stat"));
            try {
                String[] split = bufferedReader.readLine().split("\\s+");
                int length = split.length;
                if (length >= 5) {
                    j2 = parseLong(split[1]) + parseLong(split[2]);
                    j = parseLong(split[3]);
                    j3 = parseLong(split[4]);
                } else {
                    j = 0;
                    j2 = 0;
                }
                if (length >= 8) {
                    j2 += parseLong(split[5]);
                    j = j + parseLong(split[6]) + parseLong(split[7]);
                }
                bufferedReader.close();
                return new b(j2, j, j3);
            } catch (Exception e) {
                Log.e("CpuMonitor", "Problems parsing /proc/stat", e);
                bufferedReader.close();
                return null;
            }
        } catch (FileNotFoundException e2) {
            Log.e("CpuMonitor", "Cannot open /proc/stat for reading", e2);
            return null;
        } catch (IOException e3) {
            Log.e("CpuMonitor", "Problems reading /proc/stat", e3);
            return null;
        }
    }

    private void aeP() {
        synchronized (this) {
            this.cqD.reset();
            this.cqB.reset();
            this.cqC.reset();
            this.cqx.reset();
            this.cqz = SystemClock.elapsedRealtime();
        }
    }

    private boolean aeQ() {
        long j;
        synchronized (this) {
            if (!this.initialized) {
                init();
            }
            if (this.cqu == 0) {
                return false;
            }
            this.cqr = 0;
            long j2 = 0;
            long j3 = 0;
            int i = 0;
            long j4 = 0;
            while (i < this.cqu) {
                this.cqv[i] = 0.0d;
                if (this.cqs[i] == 0) {
                    j = kd(this.cqA[i]);
                    if (j > 0) {
                        Log.d("CpuMonitor", "Core " + i + ". Max frequency: " + j);
                        this.cqs[i] = j;
                        this.cqA[i] = null;
                    } else {
                        j = j3;
                    }
                } else {
                    j = this.cqs[i];
                }
                long kd = kd(this.cqw[i]);
                int i2 = (kd > 0L ? 1 : (kd == 0L ? 0 : -1));
                if (i2 != 0 || j != 0) {
                    if (i2 > 0) {
                        this.cqr++;
                    }
                    j4 += kd;
                    j2 += j;
                    if (j > 0) {
                        this.cqv[i] = kd / j;
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
            if (this.cqx.aeU() > 0.0d) {
                d = (d + this.cqx.aeU()) * 0.5d;
            }
            this.cqx.s(d);
            if (Build.VERSION.SDK_INT < 19 || Build.VERSION.SDK_INT > 24) {
                return true;
            }
            b aeO = aeO();
            if (aeO == null) {
                return false;
            }
            long j5 = aeO.cqL - this.cqy.cqL;
            long j6 = aeO.cqK - this.cqy.cqK;
            long j7 = j5 + j6 + (aeO.cqJ - this.cqy.cqJ);
            if (d == 0.0d || j7 == 0) {
                return false;
            }
            double d2 = j7;
            double d3 = j5 / d2;
            this.cqD.s(d3);
            double d4 = j6 / d2;
            this.cqB.s(d4);
            this.cqC.s(d * (d3 + d4));
            this.cqy = aeO;
            return true;
        }
    }

    private void aeR() {
        if (this.executor != null) {
            this.executor.shutdownNow();
            this.executor = null;
        }
        this.executor = Executors.newSingleThreadScheduledExecutor();
        this.executor.scheduleAtFixedRate(new Runnable() { // from class: com.baidu.rtc.c.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.aeL();
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
                    this.cqu = useDelimiter.nextInt() + 1;
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
        this.cqs = new long[this.cqu];
        this.cqA = new String[this.cqu];
        this.cqw = new String[this.cqu];
        this.cqv = new double[this.cqu];
        for (int i = 0; i < this.cqu; i++) {
            this.cqs[i] = 0;
            this.cqv[i] = 0.0d;
            String[] strArr = this.cqA;
            strArr[i] = "/sys/devices/system/cpu/cpu" + i + "/cpufreq/cpuinfo_max_freq";
            String[] strArr2 = this.cqw;
            strArr2[i] = "/sys/devices/system/cpu/cpu" + i + "/cpufreq/scaling_cur_freq";
        }
        this.cqy = new b(0L, 0L, 0L);
        aeP();
        this.initialized = true;
    }

    private long kd(String str) {
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

    private static long parseLong(String str) {
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException e) {
            Log.e("CpuMonitor", "parseLong error.", e);
            return 0L;
        }
    }

    private int r(double d) {
        return (int) ((100.0d * d) + 0.5d);
    }

    public int aeS() {
        int r;
        synchronized (this) {
            r = r(this.cqx.aeT());
        }
        return r;
    }

    public void pause() {
        if (this.executor != null) {
            Log.d("CpuMonitor", "pause");
            this.executor.shutdownNow();
            this.executor = null;
        }
    }
}
