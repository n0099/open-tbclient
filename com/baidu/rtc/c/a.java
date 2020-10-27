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
    private final C0314a ckA;
    private b ckB;
    private long ckC;
    private String[] ckD;
    private final C0314a ckE;
    private final C0314a ckF;
    private final C0314a ckG;
    private int cku;
    private long[] ckv;
    private boolean ckw;
    private int ckx;
    private double[] cky;
    private String[] ckz;
    private ScheduledExecutorService executor;
    private boolean initialized;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.rtc.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C0314a {
        private double[] ckI;
        private int ckJ;
        private double ckK;
        private double ckL;
        private final int size;

        public C0314a(int i) {
            if (i <= 0) {
                throw new AssertionError("Size value in MovingAverage ctor should be positive.");
            }
            this.size = i;
            this.ckI = new double[i];
        }

        public double act() {
            return this.ckL / this.size;
        }

        public double acu() {
            return this.ckK;
        }

        public void reset() {
            Arrays.fill(this.ckI, 0.0d);
            this.ckJ = 0;
            this.ckL = 0.0d;
            this.ckK = 0.0d;
        }

        public void s(double d) {
            this.ckL -= this.ckI[this.ckJ];
            double[] dArr = this.ckI;
            int i = this.ckJ;
            this.ckJ = i + 1;
            dArr[i] = d;
            this.ckK = d;
            this.ckL += d;
            if (this.ckJ >= this.size) {
                this.ckJ = 0;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public static class b {
        final long ckM;
        final long ckN;
        final long ckO;

        b(long j, long j2, long j3) {
            this.ckO = j;
            this.ckN = j2;
            this.ckM = j3;
        }
    }

    public a(Context context) {
        Log.d("CpuMonitor", "CpuMonitor ctor.");
        this.appContext = context.getApplicationContext();
        this.ckG = new C0314a(5);
        this.ckE = new C0314a(5);
        this.ckF = new C0314a(5);
        this.ckA = new C0314a(5);
        this.ckC = SystemClock.elapsedRealtime();
        acr();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void acl() {
        if (!acq() || SystemClock.elapsedRealtime() - this.ckC < 6000) {
            return;
        }
        this.ckC = SystemClock.elapsedRealtime();
        Log.d("CpuMonitor", acn());
    }

    private int acm() {
        Intent registerReceiver = this.appContext.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        int intExtra = registerReceiver.getIntExtra("scale", 100);
        if (intExtra > 0) {
            return (int) ((registerReceiver.getIntExtra("level", 0) * 100.0f) / intExtra);
        }
        return 0;
    }

    private String acn() {
        String sb;
        synchronized (this) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("CPU User: ");
            sb2.append(r(this.ckG.acu()));
            sb2.append("/");
            sb2.append(r(this.ckG.act()));
            sb2.append(". System: ");
            sb2.append(r(this.ckE.acu()));
            sb2.append("/");
            sb2.append(r(this.ckE.act()));
            sb2.append(". Freq: ");
            sb2.append(r(this.ckA.acu()));
            sb2.append("/");
            sb2.append(r(this.ckA.act()));
            sb2.append(". Total usage: ");
            sb2.append(r(this.ckF.acu()));
            sb2.append("/");
            sb2.append(r(this.ckF.act()));
            sb2.append(". Cores: ");
            sb2.append(this.cku);
            sb2.append("( ");
            for (int i = 0; i < this.ckx; i++) {
                sb2.append(r(this.cky[i]));
                sb2.append(" ");
            }
            sb2.append("). Battery: ");
            sb2.append(acm());
            if (this.ckw) {
                sb2.append(". Overuse.");
            }
            sb = sb2.toString();
        }
        return sb;
    }

    private b aco() {
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

    private void acp() {
        synchronized (this) {
            this.ckG.reset();
            this.ckE.reset();
            this.ckF.reset();
            this.ckA.reset();
            this.ckC = SystemClock.elapsedRealtime();
        }
    }

    private boolean acq() {
        long j;
        synchronized (this) {
            if (!this.initialized) {
                init();
            }
            if (this.ckx == 0) {
                return false;
            }
            this.cku = 0;
            long j2 = 0;
            long j3 = 0;
            int i = 0;
            long j4 = 0;
            while (i < this.ckx) {
                this.cky[i] = 0.0d;
                if (this.ckv[i] == 0) {
                    j = jO(this.ckD[i]);
                    if (j > 0) {
                        Log.d("CpuMonitor", "Core " + i + ". Max frequency: " + j);
                        this.ckv[i] = j;
                        this.ckD[i] = null;
                    } else {
                        j = j3;
                    }
                } else {
                    j = this.ckv[i];
                }
                long jO = jO(this.ckz[i]);
                int i2 = (jO > 0L ? 1 : (jO == 0L ? 0 : -1));
                if (i2 != 0 || j != 0) {
                    if (i2 > 0) {
                        this.cku++;
                    }
                    j4 += jO;
                    j2 += j;
                    if (j > 0) {
                        this.cky[i] = jO / j;
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
            if (this.ckA.acu() > 0.0d) {
                d = (d + this.ckA.acu()) * 0.5d;
            }
            this.ckA.s(d);
            if (Build.VERSION.SDK_INT < 19 || Build.VERSION.SDK_INT > 24) {
                return true;
            }
            b aco = aco();
            if (aco == null) {
                return false;
            }
            long j5 = aco.ckO - this.ckB.ckO;
            long j6 = aco.ckN - this.ckB.ckN;
            long j7 = j5 + j6 + (aco.ckM - this.ckB.ckM);
            if (d == 0.0d || j7 == 0) {
                return false;
            }
            double d2 = j7;
            double d3 = j5 / d2;
            this.ckG.s(d3);
            double d4 = j6 / d2;
            this.ckE.s(d4);
            this.ckF.s(d * (d3 + d4));
            this.ckB = aco;
            return true;
        }
    }

    private void acr() {
        if (this.executor != null) {
            this.executor.shutdownNow();
            this.executor = null;
        }
        this.executor = Executors.newSingleThreadScheduledExecutor();
        this.executor.scheduleAtFixedRate(new Runnable() { // from class: com.baidu.rtc.c.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.acl();
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
                    this.ckx = useDelimiter.nextInt() + 1;
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
        this.ckv = new long[this.ckx];
        this.ckD = new String[this.ckx];
        this.ckz = new String[this.ckx];
        this.cky = new double[this.ckx];
        for (int i = 0; i < this.ckx; i++) {
            this.ckv[i] = 0;
            this.cky[i] = 0.0d;
            String[] strArr = this.ckD;
            strArr[i] = "/sys/devices/system/cpu/cpu" + i + "/cpufreq/cpuinfo_max_freq";
            String[] strArr2 = this.ckz;
            strArr2[i] = "/sys/devices/system/cpu/cpu" + i + "/cpufreq/scaling_cur_freq";
        }
        this.ckB = new b(0L, 0L, 0L);
        acp();
        this.initialized = true;
    }

    private long jO(String str) {
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

    public int acs() {
        int r;
        synchronized (this) {
            r = r(this.ckA.act());
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
