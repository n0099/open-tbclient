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
/* loaded from: classes12.dex */
public class a {
    private final Context appContext;
    private int cvD;
    private long[] cvE;
    private boolean cvF;
    private int cvG;
    private double[] cvH;
    private String[] cvI;
    private final C0335a cvJ;
    private b cvK;
    private long cvL;
    private String[] cvM;
    private final C0335a cvN;
    private final C0335a cvO;
    private final C0335a cvP;
    private ScheduledExecutorService executor;
    private boolean initialized;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.rtc.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    public static class C0335a {
        private double[] cvR;
        private int cvS;
        private double cvT;
        private double cvU;
        private final int size;

        public C0335a(int i) {
            if (i <= 0) {
                throw new AssertionError("Size value in MovingAverage ctor should be positive.");
            }
            this.size = i;
            this.cvR = new double[i];
        }

        public double aht() {
            return this.cvU / this.size;
        }

        public double ahu() {
            return this.cvT;
        }

        public void r(double d) {
            this.cvU -= this.cvR[this.cvS];
            double[] dArr = this.cvR;
            int i = this.cvS;
            this.cvS = i + 1;
            dArr[i] = d;
            this.cvT = d;
            this.cvU += d;
            if (this.cvS >= this.size) {
                this.cvS = 0;
            }
        }

        public void reset() {
            Arrays.fill(this.cvR, 0.0d);
            this.cvS = 0;
            this.cvU = 0.0d;
            this.cvT = 0.0d;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public static class b {
        final long cvV;
        final long cvW;
        final long cvX;

        b(long j, long j2, long j3) {
            this.cvX = j;
            this.cvW = j2;
            this.cvV = j3;
        }
    }

    public a(Context context) {
        Log.d("CpuMonitor", "CpuMonitor ctor.");
        this.appContext = context.getApplicationContext();
        this.cvP = new C0335a(5);
        this.cvN = new C0335a(5);
        this.cvO = new C0335a(5);
        this.cvJ = new C0335a(5);
        this.cvL = SystemClock.elapsedRealtime();
        ahr();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ahl() {
        if (!ahq() || SystemClock.elapsedRealtime() - this.cvL < 6000) {
            return;
        }
        this.cvL = SystemClock.elapsedRealtime();
        Log.d("CpuMonitor", ahn());
    }

    private int ahm() {
        Intent registerReceiver = this.appContext.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        int intExtra = registerReceiver.getIntExtra("scale", 100);
        if (intExtra > 0) {
            return (int) ((registerReceiver.getIntExtra("level", 0) * 100.0f) / intExtra);
        }
        return 0;
    }

    private String ahn() {
        String sb;
        synchronized (this) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("CPU User: ");
            sb2.append(q(this.cvP.ahu()));
            sb2.append("/");
            sb2.append(q(this.cvP.aht()));
            sb2.append(". System: ");
            sb2.append(q(this.cvN.ahu()));
            sb2.append("/");
            sb2.append(q(this.cvN.aht()));
            sb2.append(". Freq: ");
            sb2.append(q(this.cvJ.ahu()));
            sb2.append("/");
            sb2.append(q(this.cvJ.aht()));
            sb2.append(". Total usage: ");
            sb2.append(q(this.cvO.ahu()));
            sb2.append("/");
            sb2.append(q(this.cvO.aht()));
            sb2.append(". Cores: ");
            sb2.append(this.cvD);
            sb2.append("( ");
            for (int i = 0; i < this.cvG; i++) {
                sb2.append(q(this.cvH[i]));
                sb2.append(" ");
            }
            sb2.append("). Battery: ");
            sb2.append(ahm());
            if (this.cvF) {
                sb2.append(". Overuse.");
            }
            sb = sb2.toString();
        }
        return sb;
    }

    private b aho() {
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

    private void ahp() {
        synchronized (this) {
            this.cvP.reset();
            this.cvN.reset();
            this.cvO.reset();
            this.cvJ.reset();
            this.cvL = SystemClock.elapsedRealtime();
        }
    }

    private boolean ahq() {
        long j;
        synchronized (this) {
            if (!this.initialized) {
                init();
            }
            if (this.cvG == 0) {
                return false;
            }
            this.cvD = 0;
            long j2 = 0;
            long j3 = 0;
            int i = 0;
            long j4 = 0;
            while (i < this.cvG) {
                this.cvH[i] = 0.0d;
                if (this.cvE[i] == 0) {
                    j = kE(this.cvM[i]);
                    if (j > 0) {
                        Log.d("CpuMonitor", "Core " + i + ". Max frequency: " + j);
                        this.cvE[i] = j;
                        this.cvM[i] = null;
                    } else {
                        j = j3;
                    }
                } else {
                    j = this.cvE[i];
                }
                long kE = kE(this.cvI[i]);
                int i2 = (kE > 0L ? 1 : (kE == 0L ? 0 : -1));
                if (i2 != 0 || j != 0) {
                    if (i2 > 0) {
                        this.cvD++;
                    }
                    j4 += kE;
                    j2 += j;
                    if (j > 0) {
                        this.cvH[i] = kE / j;
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
            if (this.cvJ.ahu() > 0.0d) {
                d = (d + this.cvJ.ahu()) * 0.5d;
            }
            this.cvJ.r(d);
            if (Build.VERSION.SDK_INT < 19 || Build.VERSION.SDK_INT > 24) {
                return true;
            }
            b aho = aho();
            if (aho == null) {
                return false;
            }
            long j5 = aho.cvX - this.cvK.cvX;
            long j6 = aho.cvW - this.cvK.cvW;
            long j7 = j5 + j6 + (aho.cvV - this.cvK.cvV);
            if (d == 0.0d || j7 == 0) {
                return false;
            }
            double d2 = j7;
            double d3 = j5 / d2;
            this.cvP.r(d3);
            double d4 = j6 / d2;
            this.cvN.r(d4);
            this.cvO.r(d * (d3 + d4));
            this.cvK = aho;
            return true;
        }
    }

    private void ahr() {
        if (this.executor != null) {
            this.executor.shutdownNow();
            this.executor = null;
        }
        this.executor = Executors.newSingleThreadScheduledExecutor();
        this.executor.scheduleAtFixedRate(new Runnable() { // from class: com.baidu.rtc.c.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.ahl();
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
                    this.cvG = useDelimiter.nextInt() + 1;
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
        this.cvE = new long[this.cvG];
        this.cvM = new String[this.cvG];
        this.cvI = new String[this.cvG];
        this.cvH = new double[this.cvG];
        for (int i = 0; i < this.cvG; i++) {
            this.cvE[i] = 0;
            this.cvH[i] = 0.0d;
            String[] strArr = this.cvM;
            strArr[i] = "/sys/devices/system/cpu/cpu" + i + "/cpufreq/cpuinfo_max_freq";
            String[] strArr2 = this.cvI;
            strArr2[i] = "/sys/devices/system/cpu/cpu" + i + "/cpufreq/scaling_cur_freq";
        }
        this.cvK = new b(0L, 0L, 0L);
        ahp();
        this.initialized = true;
    }

    private long kE(String str) {
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

    private int q(double d) {
        return (int) ((100.0d * d) + 0.5d);
    }

    public int ahs() {
        int q;
        synchronized (this) {
            q = q(this.cvJ.aht());
        }
        return q;
    }

    public void pause() {
        if (this.executor != null) {
            Log.d("CpuMonitor", "pause");
            this.executor.shutdownNow();
            this.executor = null;
        }
    }
}
