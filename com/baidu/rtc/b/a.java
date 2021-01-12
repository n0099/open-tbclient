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
    private int cwa;
    private long[] cwb;
    private boolean cwc;
    private int cwd;
    private double[] cwe;
    private String[] cwf;
    private final C0317a cwg;
    private b cwh;
    private long cwi;
    private String[] cwj;
    private final C0317a cwk;
    private final C0317a cwl;
    private final C0317a cwm;
    private ScheduledExecutorService executor;
    private boolean initialized;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.rtc.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C0317a {
        private double[] cwo;
        private int cwp;
        private double cwq;
        private double cwr;
        private final int size;

        public C0317a(int i) {
            if (i <= 0) {
                throw new AssertionError("Size value in MovingAverage ctor should be positive.");
            }
            this.size = i;
            this.cwo = new double[i];
        }

        public double aeQ() {
            return this.cwr / this.size;
        }

        public double aeR() {
            return this.cwq;
        }

        public void l(double d) {
            this.cwr -= this.cwo[this.cwp];
            double[] dArr = this.cwo;
            int i = this.cwp;
            this.cwp = i + 1;
            dArr[i] = d;
            this.cwq = d;
            this.cwr += d;
            if (this.cwp >= this.size) {
                this.cwp = 0;
            }
        }

        public void reset() {
            Arrays.fill(this.cwo, 0.0d);
            this.cwp = 0;
            this.cwr = 0.0d;
            this.cwq = 0.0d;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public static class b {
        final long cws;
        final long cwt;
        final long cwu;

        b(long j, long j2, long j3) {
            this.cwu = j;
            this.cwt = j2;
            this.cws = j3;
        }
    }

    public a(Context context) {
        Log.d("CpuMonitor", "CpuMonitor ctor.");
        this.appContext = context.getApplicationContext();
        this.cwm = new C0317a(5);
        this.cwk = new C0317a(5);
        this.cwl = new C0317a(5);
        this.cwg = new C0317a(5);
        this.cwi = SystemClock.elapsedRealtime();
        aeO();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aeI() {
        if (!aeN() || SystemClock.elapsedRealtime() - this.cwi < 6000) {
            return;
        }
        this.cwi = SystemClock.elapsedRealtime();
        Log.d("CpuMonitor", aeK());
    }

    private int aeJ() {
        Intent registerReceiver = this.appContext.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        int intExtra = registerReceiver.getIntExtra("scale", 100);
        if (intExtra > 0) {
            return (int) ((registerReceiver.getIntExtra("level", 0) * 100.0f) / intExtra);
        }
        return 0;
    }

    private String aeK() {
        String sb;
        synchronized (this) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("CPU User: ");
            sb2.append(k(this.cwm.aeR()));
            sb2.append("/");
            sb2.append(k(this.cwm.aeQ()));
            sb2.append(". System: ");
            sb2.append(k(this.cwk.aeR()));
            sb2.append("/");
            sb2.append(k(this.cwk.aeQ()));
            sb2.append(". Freq: ");
            sb2.append(k(this.cwg.aeR()));
            sb2.append("/");
            sb2.append(k(this.cwg.aeQ()));
            sb2.append(". Total usage: ");
            sb2.append(k(this.cwl.aeR()));
            sb2.append("/");
            sb2.append(k(this.cwl.aeQ()));
            sb2.append(". Cores: ");
            sb2.append(this.cwa);
            sb2.append("( ");
            for (int i = 0; i < this.cwd; i++) {
                sb2.append(k(this.cwe[i]));
                sb2.append(" ");
            }
            sb2.append("). Battery: ");
            sb2.append(aeJ());
            if (this.cwc) {
                sb2.append(". Overuse.");
            }
            sb = sb2.toString();
        }
        return sb;
    }

    private b aeL() {
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

    private void aeM() {
        synchronized (this) {
            this.cwm.reset();
            this.cwk.reset();
            this.cwl.reset();
            this.cwg.reset();
            this.cwi = SystemClock.elapsedRealtime();
        }
    }

    private boolean aeN() {
        long j;
        synchronized (this) {
            if (!this.initialized) {
                init();
            }
            if (this.cwd == 0) {
                return false;
            }
            this.cwa = 0;
            int i = 0;
            long j2 = 0;
            long j3 = 0;
            long j4 = 0;
            while (i < this.cwd) {
                this.cwe[i] = 0.0d;
                if (this.cwb[i] == 0) {
                    j = jm(this.cwj[i]);
                    if (j > 0) {
                        Log.d("CpuMonitor", "Core " + i + ". Max frequency: " + j);
                        this.cwb[i] = j;
                        this.cwj[i] = null;
                    } else {
                        j = j3;
                    }
                } else {
                    j = this.cwb[i];
                }
                long jm = jm(this.cwf[i]);
                int i2 = (jm > 0L ? 1 : (jm == 0L ? 0 : -1));
                if (i2 != 0 || j != 0) {
                    if (i2 > 0) {
                        this.cwa++;
                    }
                    j4 += jm;
                    j2 += j;
                    if (j > 0) {
                        this.cwe[i] = jm / j;
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
            if (this.cwg.aeR() > 0.0d) {
                d = (d + this.cwg.aeR()) * 0.5d;
            }
            this.cwg.l(d);
            if (Build.VERSION.SDK_INT < 19 || Build.VERSION.SDK_INT > 24) {
                return true;
            }
            b aeL = aeL();
            if (aeL == null) {
                return false;
            }
            long j5 = aeL.cwu - this.cwh.cwu;
            long j6 = aeL.cwt - this.cwh.cwt;
            long j7 = j5 + j6 + (aeL.cws - this.cwh.cws);
            if (d == 0.0d || j7 == 0) {
                return false;
            }
            double d2 = j7;
            double d3 = j5 / d2;
            this.cwm.l(d3);
            double d4 = j6 / d2;
            this.cwk.l(d4);
            this.cwl.l(d * (d3 + d4));
            this.cwh = aeL;
            return true;
        }
    }

    private void aeO() {
        if (this.executor != null) {
            this.executor.shutdownNow();
            this.executor = null;
        }
        this.executor = Executors.newSingleThreadScheduledExecutor();
        this.executor.scheduleAtFixedRate(new Runnable() { // from class: com.baidu.rtc.b.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.aeI();
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
                    this.cwd = useDelimiter.nextInt() + 1;
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
        this.cwb = new long[this.cwd];
        this.cwj = new String[this.cwd];
        this.cwf = new String[this.cwd];
        this.cwe = new double[this.cwd];
        for (int i = 0; i < this.cwd; i++) {
            this.cwb[i] = 0;
            this.cwe[i] = 0.0d;
            String[] strArr = this.cwj;
            strArr[i] = "/sys/devices/system/cpu/cpu" + i + "/cpufreq/cpuinfo_max_freq";
            String[] strArr2 = this.cwf;
            strArr2[i] = "/sys/devices/system/cpu/cpu" + i + "/cpufreq/scaling_cur_freq";
        }
        this.cwh = new b(0L, 0L, 0L);
        aeM();
        this.initialized = true;
    }

    private long jm(String str) {
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

    public int aeP() {
        int k;
        synchronized (this) {
            k = k(this.cwg.aeQ());
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
