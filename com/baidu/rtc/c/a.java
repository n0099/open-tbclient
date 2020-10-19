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
    private int cbV;
    private long[] cbW;
    private boolean cbX;
    private int cbY;
    private double[] cbZ;
    private String[] cca;
    private final C0300a ccb;
    private b ccc;
    private long ccd;
    private String[] cce;
    private final C0300a ccf;
    private final C0300a ccg;
    private final C0300a cch;
    private ScheduledExecutorService executor;
    private boolean initialized;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.rtc.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C0300a {
        private double[] ccj;
        private int cck;
        private double ccl;
        private double ccm;
        private final int size;

        public C0300a(int i) {
            if (i <= 0) {
                throw new AssertionError("Size value in MovingAverage ctor should be positive.");
            }
            this.size = i;
            this.ccj = new double[i];
        }

        public double aaA() {
            return this.ccl;
        }

        public double aaz() {
            return this.ccm / this.size;
        }

        public void r(double d) {
            this.ccm -= this.ccj[this.cck];
            double[] dArr = this.ccj;
            int i = this.cck;
            this.cck = i + 1;
            dArr[i] = d;
            this.ccl = d;
            this.ccm += d;
            if (this.cck >= this.size) {
                this.cck = 0;
            }
        }

        public void reset() {
            Arrays.fill(this.ccj, 0.0d);
            this.cck = 0;
            this.ccm = 0.0d;
            this.ccl = 0.0d;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public static class b {
        final long ccn;
        final long cco;
        final long ccp;

        b(long j, long j2, long j3) {
            this.ccp = j;
            this.cco = j2;
            this.ccn = j3;
        }
    }

    public a(Context context) {
        Log.d("CpuMonitor", "CpuMonitor ctor.");
        this.appContext = context.getApplicationContext();
        this.cch = new C0300a(5);
        this.ccf = new C0300a(5);
        this.ccg = new C0300a(5);
        this.ccb = new C0300a(5);
        this.ccd = SystemClock.elapsedRealtime();
        aax();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aar() {
        if (!aaw() || SystemClock.elapsedRealtime() - this.ccd < 6000) {
            return;
        }
        this.ccd = SystemClock.elapsedRealtime();
        Log.d("CpuMonitor", aat());
    }

    private int aas() {
        Intent registerReceiver = this.appContext.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        int intExtra = registerReceiver.getIntExtra("scale", 100);
        if (intExtra > 0) {
            return (int) ((registerReceiver.getIntExtra("level", 0) * 100.0f) / intExtra);
        }
        return 0;
    }

    private String aat() {
        String sb;
        synchronized (this) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("CPU User: ");
            sb2.append(q(this.cch.aaA()));
            sb2.append("/");
            sb2.append(q(this.cch.aaz()));
            sb2.append(". System: ");
            sb2.append(q(this.ccf.aaA()));
            sb2.append("/");
            sb2.append(q(this.ccf.aaz()));
            sb2.append(". Freq: ");
            sb2.append(q(this.ccb.aaA()));
            sb2.append("/");
            sb2.append(q(this.ccb.aaz()));
            sb2.append(". Total usage: ");
            sb2.append(q(this.ccg.aaA()));
            sb2.append("/");
            sb2.append(q(this.ccg.aaz()));
            sb2.append(". Cores: ");
            sb2.append(this.cbV);
            sb2.append("( ");
            for (int i = 0; i < this.cbY; i++) {
                sb2.append(q(this.cbZ[i]));
                sb2.append(" ");
            }
            sb2.append("). Battery: ");
            sb2.append(aas());
            if (this.cbX) {
                sb2.append(". Overuse.");
            }
            sb = sb2.toString();
        }
        return sb;
    }

    private b aau() {
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

    private void aav() {
        synchronized (this) {
            this.cch.reset();
            this.ccf.reset();
            this.ccg.reset();
            this.ccb.reset();
            this.ccd = SystemClock.elapsedRealtime();
        }
    }

    private boolean aaw() {
        long j;
        synchronized (this) {
            if (!this.initialized) {
                init();
            }
            if (this.cbY == 0) {
                return false;
            }
            this.cbV = 0;
            long j2 = 0;
            long j3 = 0;
            int i = 0;
            long j4 = 0;
            while (i < this.cbY) {
                this.cbZ[i] = 0.0d;
                if (this.cbW[i] == 0) {
                    j = jv(this.cce[i]);
                    if (j > 0) {
                        Log.d("CpuMonitor", "Core " + i + ". Max frequency: " + j);
                        this.cbW[i] = j;
                        this.cce[i] = null;
                    } else {
                        j = j3;
                    }
                } else {
                    j = this.cbW[i];
                }
                long jv = jv(this.cca[i]);
                int i2 = (jv > 0L ? 1 : (jv == 0L ? 0 : -1));
                if (i2 != 0 || j != 0) {
                    if (i2 > 0) {
                        this.cbV++;
                    }
                    j4 += jv;
                    j2 += j;
                    if (j > 0) {
                        this.cbZ[i] = jv / j;
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
            if (this.ccb.aaA() > 0.0d) {
                d = (d + this.ccb.aaA()) * 0.5d;
            }
            this.ccb.r(d);
            if (Build.VERSION.SDK_INT < 19 || Build.VERSION.SDK_INT > 24) {
                return true;
            }
            b aau = aau();
            if (aau == null) {
                return false;
            }
            long j5 = aau.ccp - this.ccc.ccp;
            long j6 = aau.cco - this.ccc.cco;
            long j7 = j5 + j6 + (aau.ccn - this.ccc.ccn);
            if (d == 0.0d || j7 == 0) {
                return false;
            }
            double d2 = j7;
            double d3 = j5 / d2;
            this.cch.r(d3);
            double d4 = j6 / d2;
            this.ccf.r(d4);
            this.ccg.r(d * (d3 + d4));
            this.ccc = aau;
            return true;
        }
    }

    private void aax() {
        if (this.executor != null) {
            this.executor.shutdownNow();
            this.executor = null;
        }
        this.executor = Executors.newSingleThreadScheduledExecutor();
        this.executor.scheduleAtFixedRate(new Runnable() { // from class: com.baidu.rtc.c.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.aar();
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
                    this.cbY = useDelimiter.nextInt() + 1;
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
        this.cbW = new long[this.cbY];
        this.cce = new String[this.cbY];
        this.cca = new String[this.cbY];
        this.cbZ = new double[this.cbY];
        for (int i = 0; i < this.cbY; i++) {
            this.cbW[i] = 0;
            this.cbZ[i] = 0.0d;
            String[] strArr = this.cce;
            strArr[i] = "/sys/devices/system/cpu/cpu" + i + "/cpufreq/cpuinfo_max_freq";
            String[] strArr2 = this.cca;
            strArr2[i] = "/sys/devices/system/cpu/cpu" + i + "/cpufreq/scaling_cur_freq";
        }
        this.ccc = new b(0L, 0L, 0L);
        aav();
        this.initialized = true;
    }

    private long jv(String str) {
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

    public int aay() {
        int q;
        synchronized (this) {
            q = q(this.ccb.aaz());
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
