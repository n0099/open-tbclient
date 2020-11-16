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
/* loaded from: classes16.dex */
public class a {
    private final Context appContext;
    private int coG;
    private long[] coH;
    private boolean coI;
    private int coJ;
    private double[] coK;
    private String[] coL;
    private final C0324a coM;
    private b coN;
    private long coO;
    private String[] coP;
    private final C0324a coQ;
    private final C0324a coR;
    private final C0324a coS;
    private ScheduledExecutorService executor;
    private boolean initialized;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.rtc.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    public static class C0324a {
        private double[] coU;
        private int coV;
        private double coW;
        private double coX;
        private final int size;

        public C0324a(int i) {
            if (i <= 0) {
                throw new AssertionError("Size value in MovingAverage ctor should be positive.");
            }
            this.size = i;
            this.coU = new double[i];
        }

        public double ael() {
            return this.coX / this.size;
        }

        public double aem() {
            return this.coW;
        }

        public void r(double d) {
            this.coX -= this.coU[this.coV];
            double[] dArr = this.coU;
            int i = this.coV;
            this.coV = i + 1;
            dArr[i] = d;
            this.coW = d;
            this.coX += d;
            if (this.coV >= this.size) {
                this.coV = 0;
            }
        }

        public void reset() {
            Arrays.fill(this.coU, 0.0d);
            this.coV = 0;
            this.coX = 0.0d;
            this.coW = 0.0d;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes16.dex */
    public static class b {
        final long coY;
        final long coZ;
        final long cpa;

        b(long j, long j2, long j3) {
            this.cpa = j;
            this.coZ = j2;
            this.coY = j3;
        }
    }

    public a(Context context) {
        Log.d("CpuMonitor", "CpuMonitor ctor.");
        this.appContext = context.getApplicationContext();
        this.coS = new C0324a(5);
        this.coQ = new C0324a(5);
        this.coR = new C0324a(5);
        this.coM = new C0324a(5);
        this.coO = SystemClock.elapsedRealtime();
        aej();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aed() {
        if (!aei() || SystemClock.elapsedRealtime() - this.coO < 6000) {
            return;
        }
        this.coO = SystemClock.elapsedRealtime();
        Log.d("CpuMonitor", aef());
    }

    private int aee() {
        Intent registerReceiver = this.appContext.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        int intExtra = registerReceiver.getIntExtra("scale", 100);
        if (intExtra > 0) {
            return (int) ((registerReceiver.getIntExtra("level", 0) * 100.0f) / intExtra);
        }
        return 0;
    }

    private String aef() {
        String sb;
        synchronized (this) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("CPU User: ");
            sb2.append(q(this.coS.aem()));
            sb2.append("/");
            sb2.append(q(this.coS.ael()));
            sb2.append(". System: ");
            sb2.append(q(this.coQ.aem()));
            sb2.append("/");
            sb2.append(q(this.coQ.ael()));
            sb2.append(". Freq: ");
            sb2.append(q(this.coM.aem()));
            sb2.append("/");
            sb2.append(q(this.coM.ael()));
            sb2.append(". Total usage: ");
            sb2.append(q(this.coR.aem()));
            sb2.append("/");
            sb2.append(q(this.coR.ael()));
            sb2.append(". Cores: ");
            sb2.append(this.coG);
            sb2.append("( ");
            for (int i = 0; i < this.coJ; i++) {
                sb2.append(q(this.coK[i]));
                sb2.append(" ");
            }
            sb2.append("). Battery: ");
            sb2.append(aee());
            if (this.coI) {
                sb2.append(". Overuse.");
            }
            sb = sb2.toString();
        }
        return sb;
    }

    private b aeg() {
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

    private void aeh() {
        synchronized (this) {
            this.coS.reset();
            this.coQ.reset();
            this.coR.reset();
            this.coM.reset();
            this.coO = SystemClock.elapsedRealtime();
        }
    }

    private boolean aei() {
        long j;
        synchronized (this) {
            if (!this.initialized) {
                init();
            }
            if (this.coJ == 0) {
                return false;
            }
            this.coG = 0;
            long j2 = 0;
            long j3 = 0;
            int i = 0;
            long j4 = 0;
            while (i < this.coJ) {
                this.coK[i] = 0.0d;
                if (this.coH[i] == 0) {
                    j = jX(this.coP[i]);
                    if (j > 0) {
                        Log.d("CpuMonitor", "Core " + i + ". Max frequency: " + j);
                        this.coH[i] = j;
                        this.coP[i] = null;
                    } else {
                        j = j3;
                    }
                } else {
                    j = this.coH[i];
                }
                long jX = jX(this.coL[i]);
                int i2 = (jX > 0L ? 1 : (jX == 0L ? 0 : -1));
                if (i2 != 0 || j != 0) {
                    if (i2 > 0) {
                        this.coG++;
                    }
                    j4 += jX;
                    j2 += j;
                    if (j > 0) {
                        this.coK[i] = jX / j;
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
            if (this.coM.aem() > 0.0d) {
                d = (d + this.coM.aem()) * 0.5d;
            }
            this.coM.r(d);
            if (Build.VERSION.SDK_INT < 19 || Build.VERSION.SDK_INT > 24) {
                return true;
            }
            b aeg = aeg();
            if (aeg == null) {
                return false;
            }
            long j5 = aeg.cpa - this.coN.cpa;
            long j6 = aeg.coZ - this.coN.coZ;
            long j7 = j5 + j6 + (aeg.coY - this.coN.coY);
            if (d == 0.0d || j7 == 0) {
                return false;
            }
            double d2 = j7;
            double d3 = j5 / d2;
            this.coS.r(d3);
            double d4 = j6 / d2;
            this.coQ.r(d4);
            this.coR.r(d * (d3 + d4));
            this.coN = aeg;
            return true;
        }
    }

    private void aej() {
        if (this.executor != null) {
            this.executor.shutdownNow();
            this.executor = null;
        }
        this.executor = Executors.newSingleThreadScheduledExecutor();
        this.executor.scheduleAtFixedRate(new Runnable() { // from class: com.baidu.rtc.c.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.aed();
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
                    this.coJ = useDelimiter.nextInt() + 1;
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
        this.coH = new long[this.coJ];
        this.coP = new String[this.coJ];
        this.coL = new String[this.coJ];
        this.coK = new double[this.coJ];
        for (int i = 0; i < this.coJ; i++) {
            this.coH[i] = 0;
            this.coK[i] = 0.0d;
            String[] strArr = this.coP;
            strArr[i] = "/sys/devices/system/cpu/cpu" + i + "/cpufreq/cpuinfo_max_freq";
            String[] strArr2 = this.coL;
            strArr2[i] = "/sys/devices/system/cpu/cpu" + i + "/cpufreq/scaling_cur_freq";
        }
        this.coN = new b(0L, 0L, 0L);
        aeh();
        this.initialized = true;
    }

    private long jX(String str) {
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

    public int aek() {
        int q;
        synchronized (this) {
            q = q(this.coM.ael());
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
