package com.baidu.rtc.b;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.SystemClock;
import android.util.Log;
import com.baidu.platform.comapi.map.MapBundleKey;
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
    private int cAM;
    private long[] cAN;
    private boolean cAO;
    private int cAP;
    private double[] cAQ;
    private String[] cAR;
    private final C0334a cAS;
    private b cAT;
    private long cAU;
    private String[] cAV;
    private final C0334a cAW;
    private final C0334a cAX;
    private final C0334a cAY;
    private ScheduledExecutorService executor;
    private boolean initialized;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.rtc.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0334a {
        private double[] cBa;
        private int cBb;
        private double cBc;
        private double cBd;
        private final int size;

        public C0334a(int i) {
            if (i <= 0) {
                throw new AssertionError("Size value in MovingAverage ctor should be positive.");
            }
            this.size = i;
            this.cBa = new double[i];
        }

        public double aiK() {
            return this.cBd / this.size;
        }

        public double aiL() {
            return this.cBc;
        }

        public void r(double d) {
            this.cBd -= this.cBa[this.cBb];
            double[] dArr = this.cBa;
            int i = this.cBb;
            this.cBb = i + 1;
            dArr[i] = d;
            this.cBc = d;
            this.cBd += d;
            if (this.cBb >= this.size) {
                this.cBb = 0;
            }
        }

        public void reset() {
            Arrays.fill(this.cBa, 0.0d);
            this.cBb = 0;
            this.cBd = 0.0d;
            this.cBc = 0.0d;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class b {
        final long cBe;
        final long cBf;
        final long cBg;

        b(long j, long j2, long j3) {
            this.cBg = j;
            this.cBf = j2;
            this.cBe = j3;
        }
    }

    public a(Context context) {
        Log.d("CpuMonitor", "CpuMonitor ctor.");
        this.appContext = context.getApplicationContext();
        this.cAY = new C0334a(5);
        this.cAW = new C0334a(5);
        this.cAX = new C0334a(5);
        this.cAS = new C0334a(5);
        this.cAU = SystemClock.elapsedRealtime();
        aiI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aiC() {
        if (!aiH() || SystemClock.elapsedRealtime() - this.cAU < 6000) {
            return;
        }
        this.cAU = SystemClock.elapsedRealtime();
        Log.d("CpuMonitor", aiE());
    }

    private int aiD() {
        Intent registerReceiver = this.appContext.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        int intExtra = registerReceiver.getIntExtra("scale", 100);
        if (intExtra > 0) {
            return (int) ((registerReceiver.getIntExtra(MapBundleKey.MapObjKey.OBJ_LEVEL, 0) * 100.0f) / intExtra);
        }
        return 0;
    }

    private String aiE() {
        String sb;
        synchronized (this) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("CPU User: ");
            sb2.append(q(this.cAY.aiL()));
            sb2.append("/");
            sb2.append(q(this.cAY.aiK()));
            sb2.append(". System: ");
            sb2.append(q(this.cAW.aiL()));
            sb2.append("/");
            sb2.append(q(this.cAW.aiK()));
            sb2.append(". Freq: ");
            sb2.append(q(this.cAS.aiL()));
            sb2.append("/");
            sb2.append(q(this.cAS.aiK()));
            sb2.append(". Total usage: ");
            sb2.append(q(this.cAX.aiL()));
            sb2.append("/");
            sb2.append(q(this.cAX.aiK()));
            sb2.append(". Cores: ");
            sb2.append(this.cAM);
            sb2.append("( ");
            for (int i = 0; i < this.cAP; i++) {
                sb2.append(q(this.cAQ[i]));
                sb2.append(" ");
            }
            sb2.append("). Battery: ");
            sb2.append(aiD());
            if (this.cAO) {
                sb2.append(". Overuse.");
            }
            sb = sb2.toString();
        }
        return sb;
    }

    private b aiF() {
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

    private void aiG() {
        synchronized (this) {
            this.cAY.reset();
            this.cAW.reset();
            this.cAX.reset();
            this.cAS.reset();
            this.cAU = SystemClock.elapsedRealtime();
        }
    }

    private boolean aiH() {
        long j;
        synchronized (this) {
            if (!this.initialized) {
                init();
            }
            if (this.cAP == 0) {
                return false;
            }
            this.cAM = 0;
            int i = 0;
            long j2 = 0;
            long j3 = 0;
            long j4 = 0;
            while (i < this.cAP) {
                this.cAQ[i] = 0.0d;
                if (this.cAN[i] == 0) {
                    j = kx(this.cAV[i]);
                    if (j > 0) {
                        Log.d("CpuMonitor", "Core " + i + ". Max frequency: " + j);
                        this.cAN[i] = j;
                        this.cAV[i] = null;
                    } else {
                        j = j3;
                    }
                } else {
                    j = this.cAN[i];
                }
                long kx = kx(this.cAR[i]);
                int i2 = (kx > 0L ? 1 : (kx == 0L ? 0 : -1));
                if (i2 != 0 || j != 0) {
                    if (i2 > 0) {
                        this.cAM++;
                    }
                    j4 += kx;
                    j2 += j;
                    if (j > 0) {
                        this.cAQ[i] = kx / j;
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
            if (this.cAS.aiL() > 0.0d) {
                d = (d + this.cAS.aiL()) * 0.5d;
            }
            this.cAS.r(d);
            if (Build.VERSION.SDK_INT < 19 || Build.VERSION.SDK_INT > 24) {
                return true;
            }
            b aiF = aiF();
            if (aiF == null) {
                return false;
            }
            long j5 = aiF.cBg - this.cAT.cBg;
            long j6 = aiF.cBf - this.cAT.cBf;
            long j7 = j5 + j6 + (aiF.cBe - this.cAT.cBe);
            if (d == 0.0d || j7 == 0) {
                return false;
            }
            double d2 = j7;
            double d3 = j5 / d2;
            this.cAY.r(d3);
            double d4 = j6 / d2;
            this.cAW.r(d4);
            this.cAX.r(d * (d3 + d4));
            this.cAT = aiF;
            return true;
        }
    }

    private void aiI() {
        if (this.executor != null) {
            this.executor.shutdownNow();
            this.executor = null;
        }
        this.executor = Executors.newSingleThreadScheduledExecutor();
        this.executor.scheduleAtFixedRate(new Runnable() { // from class: com.baidu.rtc.b.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.aiC();
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
                    this.cAP = useDelimiter.nextInt() + 1;
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
        this.cAN = new long[this.cAP];
        this.cAV = new String[this.cAP];
        this.cAR = new String[this.cAP];
        this.cAQ = new double[this.cAP];
        for (int i = 0; i < this.cAP; i++) {
            this.cAN[i] = 0;
            this.cAQ[i] = 0.0d;
            String[] strArr = this.cAV;
            strArr[i] = "/sys/devices/system/cpu/cpu" + i + "/cpufreq/cpuinfo_max_freq";
            String[] strArr2 = this.cAR;
            strArr2[i] = "/sys/devices/system/cpu/cpu" + i + "/cpufreq/scaling_cur_freq";
        }
        this.cAT = new b(0L, 0L, 0L);
        aiG();
        this.initialized = true;
    }

    private long kx(String str) {
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

    public int aiJ() {
        int q;
        synchronized (this) {
            q = q(this.cAS.aiK());
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
