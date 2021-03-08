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
/* loaded from: classes9.dex */
public class a {
    private final Context appContext;
    private int czN;
    private long[] czO;
    private boolean czP;
    private int czQ;
    private double[] czR;
    private String[] czS;
    private final C0320a czT;
    private b czU;
    private long czV;
    private String[] czW;
    private final C0320a czX;
    private final C0320a czY;
    private final C0320a czZ;
    private ScheduledExecutorService executor;
    private boolean initialized;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.rtc.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C0320a {
        private double[] cAb;
        private int cAc;
        private double cAd;
        private double cAe;
        private final int size;

        public C0320a(int i) {
            if (i <= 0) {
                throw new AssertionError("Size value in MovingAverage ctor should be positive.");
            }
            this.size = i;
            this.cAb = new double[i];
        }

        public double afm() {
            return this.cAe / this.size;
        }

        public double afn() {
            return this.cAd;
        }

        public void l(double d) {
            this.cAe -= this.cAb[this.cAc];
            double[] dArr = this.cAb;
            int i = this.cAc;
            this.cAc = i + 1;
            dArr[i] = d;
            this.cAd = d;
            this.cAe += d;
            if (this.cAc >= this.size) {
                this.cAc = 0;
            }
        }

        public void reset() {
            Arrays.fill(this.cAb, 0.0d);
            this.cAc = 0;
            this.cAe = 0.0d;
            this.cAd = 0.0d;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public static class b {
        final long cAf;
        final long cAg;
        final long cAh;

        b(long j, long j2, long j3) {
            this.cAh = j;
            this.cAg = j2;
            this.cAf = j3;
        }
    }

    public a(Context context) {
        Log.d("CpuMonitor", "CpuMonitor ctor.");
        this.appContext = context.getApplicationContext();
        this.czZ = new C0320a(5);
        this.czX = new C0320a(5);
        this.czY = new C0320a(5);
        this.czT = new C0320a(5);
        this.czV = SystemClock.elapsedRealtime();
        afk();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afe() {
        if (!afj() || SystemClock.elapsedRealtime() - this.czV < 6000) {
            return;
        }
        this.czV = SystemClock.elapsedRealtime();
        Log.d("CpuMonitor", afg());
    }

    private int aff() {
        Intent registerReceiver = this.appContext.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        int intExtra = registerReceiver.getIntExtra("scale", 100);
        if (intExtra > 0) {
            return (int) ((registerReceiver.getIntExtra("level", 0) * 100.0f) / intExtra);
        }
        return 0;
    }

    private String afg() {
        String sb;
        synchronized (this) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("CPU User: ");
            sb2.append(k(this.czZ.afn()));
            sb2.append("/");
            sb2.append(k(this.czZ.afm()));
            sb2.append(". System: ");
            sb2.append(k(this.czX.afn()));
            sb2.append("/");
            sb2.append(k(this.czX.afm()));
            sb2.append(". Freq: ");
            sb2.append(k(this.czT.afn()));
            sb2.append("/");
            sb2.append(k(this.czT.afm()));
            sb2.append(". Total usage: ");
            sb2.append(k(this.czY.afn()));
            sb2.append("/");
            sb2.append(k(this.czY.afm()));
            sb2.append(". Cores: ");
            sb2.append(this.czN);
            sb2.append("( ");
            for (int i = 0; i < this.czQ; i++) {
                sb2.append(k(this.czR[i]));
                sb2.append(" ");
            }
            sb2.append("). Battery: ");
            sb2.append(aff());
            if (this.czP) {
                sb2.append(". Overuse.");
            }
            sb = sb2.toString();
        }
        return sb;
    }

    private b afh() {
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

    private void afi() {
        synchronized (this) {
            this.czZ.reset();
            this.czX.reset();
            this.czY.reset();
            this.czT.reset();
            this.czV = SystemClock.elapsedRealtime();
        }
    }

    private boolean afj() {
        long j;
        synchronized (this) {
            if (!this.initialized) {
                init();
            }
            if (this.czQ == 0) {
                return false;
            }
            this.czN = 0;
            int i = 0;
            long j2 = 0;
            long j3 = 0;
            long j4 = 0;
            while (i < this.czQ) {
                this.czR[i] = 0.0d;
                if (this.czO[i] == 0) {
                    j = jM(this.czW[i]);
                    if (j > 0) {
                        Log.d("CpuMonitor", "Core " + i + ". Max frequency: " + j);
                        this.czO[i] = j;
                        this.czW[i] = null;
                    } else {
                        j = j3;
                    }
                } else {
                    j = this.czO[i];
                }
                long jM = jM(this.czS[i]);
                int i2 = (jM > 0L ? 1 : (jM == 0L ? 0 : -1));
                if (i2 != 0 || j != 0) {
                    if (i2 > 0) {
                        this.czN++;
                    }
                    j4 += jM;
                    j2 += j;
                    if (j > 0) {
                        this.czR[i] = jM / j;
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
            if (this.czT.afn() > 0.0d) {
                d = (d + this.czT.afn()) * 0.5d;
            }
            this.czT.l(d);
            if (Build.VERSION.SDK_INT < 19 || Build.VERSION.SDK_INT > 24) {
                return true;
            }
            b afh = afh();
            if (afh == null) {
                return false;
            }
            long j5 = afh.cAh - this.czU.cAh;
            long j6 = afh.cAg - this.czU.cAg;
            long j7 = j5 + j6 + (afh.cAf - this.czU.cAf);
            if (d == 0.0d || j7 == 0) {
                return false;
            }
            double d2 = j7;
            double d3 = j5 / d2;
            this.czZ.l(d3);
            double d4 = j6 / d2;
            this.czX.l(d4);
            this.czY.l(d * (d3 + d4));
            this.czU = afh;
            return true;
        }
    }

    private void afk() {
        if (this.executor != null) {
            this.executor.shutdownNow();
            this.executor = null;
        }
        this.executor = Executors.newSingleThreadScheduledExecutor();
        this.executor.scheduleAtFixedRate(new Runnable() { // from class: com.baidu.rtc.b.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.afe();
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
                    this.czQ = useDelimiter.nextInt() + 1;
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
        this.czO = new long[this.czQ];
        this.czW = new String[this.czQ];
        this.czS = new String[this.czQ];
        this.czR = new double[this.czQ];
        for (int i = 0; i < this.czQ; i++) {
            this.czO[i] = 0;
            this.czR[i] = 0.0d;
            String[] strArr = this.czW;
            strArr[i] = "/sys/devices/system/cpu/cpu" + i + "/cpufreq/cpuinfo_max_freq";
            String[] strArr2 = this.czS;
            strArr2[i] = "/sys/devices/system/cpu/cpu" + i + "/cpufreq/scaling_cur_freq";
        }
        this.czU = new b(0L, 0L, 0L);
        afi();
        this.initialized = true;
    }

    private long jM(String str) {
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

    public int afl() {
        int k;
        synchronized (this) {
            k = k(this.czT.afm());
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
