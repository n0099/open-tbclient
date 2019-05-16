package com.baidu.location.e;

import android.annotation.SuppressLint;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.location.g.g;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.regex.Pattern;
/* loaded from: classes3.dex */
public class e {
    public List<ScanResult> a;
    private long b;
    private long c;
    private boolean d = false;
    private boolean e;

    public e(List<ScanResult> list, long j) {
        this.a = null;
        this.b = 0L;
        this.c = 0L;
        this.b = j;
        this.a = list;
        this.c = System.currentTimeMillis();
        n();
    }

    private boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return Pattern.compile("wpa|wep", 2).matcher(str).find();
    }

    private String b(String str) {
        return str != null ? (str.contains("&") || str.contains(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR)) ? str.replace("&", "_").replace(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR, "_") : str : str;
    }

    private int m() {
        if (this.a == null) {
            return 0;
        }
        return this.a.size();
    }

    private void n() {
        boolean z;
        if (m() < 1) {
            return;
        }
        boolean z2 = true;
        for (int size = this.a.size() - 1; size >= 1 && z2; size--) {
            int i = 0;
            z2 = false;
            while (i < size) {
                if (this.a.get(i).level < this.a.get(i + 1).level) {
                    this.a.set(i + 1, this.a.get(i));
                    this.a.set(i, this.a.get(i + 1));
                    z = true;
                } else {
                    z = z2;
                }
                i++;
                z2 = z;
            }
        }
    }

    public int a() {
        if (this.a == null) {
            return 0;
        }
        return this.a.size();
    }

    public String a(int i) {
        return a(i, false, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:132:0x03ad A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:136:0x03b7  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x03bb  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x008b A[Catch: Error -> 0x01fa, Exception -> 0x03b0, TRY_LEAVE, TryCatch #0 {Exception -> 0x03b0, blocks: (B:7:0x000a, B:9:0x002a, B:11:0x0030, B:14:0x0053, B:17:0x005e, B:27:0x0077, B:32:0x008b, B:41:0x00ca, B:45:0x00da, B:47:0x00e5, B:48:0x0105, B:50:0x0113, B:53:0x0131, B:55:0x0158, B:57:0x0160, B:93:0x0254, B:73:0x01d1, B:76:0x01dd, B:96:0x0278, B:100:0x0298, B:103:0x02b9, B:105:0x02bf, B:107:0x02d2, B:108:0x02ed, B:110:0x02f3, B:112:0x02fb, B:113:0x0304, B:114:0x030c, B:116:0x031b, B:118:0x0334, B:119:0x033d, B:121:0x0370, B:124:0x0384, B:126:0x038b, B:128:0x039c, B:129:0x03a5), top: B:141:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0278 A[Catch: Error -> 0x01fa, Exception -> 0x03b0, TryCatch #0 {Exception -> 0x03b0, blocks: (B:7:0x000a, B:9:0x002a, B:11:0x0030, B:14:0x0053, B:17:0x005e, B:27:0x0077, B:32:0x008b, B:41:0x00ca, B:45:0x00da, B:47:0x00e5, B:48:0x0105, B:50:0x0113, B:53:0x0131, B:55:0x0158, B:57:0x0160, B:93:0x0254, B:73:0x01d1, B:76:0x01dd, B:96:0x0278, B:100:0x0298, B:103:0x02b9, B:105:0x02bf, B:107:0x02d2, B:108:0x02ed, B:110:0x02f3, B:112:0x02fb, B:113:0x0304, B:114:0x030c, B:116:0x031b, B:118:0x0334, B:119:0x033d, B:121:0x0370, B:124:0x0384, B:126:0x038b, B:128:0x039c, B:129:0x03a5), top: B:141:0x000a }] */
    @SuppressLint({"NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String a(int i, boolean z, boolean z2) {
        int i2;
        String str;
        String str2;
        long j;
        int size;
        boolean z3;
        int i3;
        boolean z4;
        long j2;
        StringBuffer stringBuffer;
        int i4;
        int i5;
        long j3;
        char c;
        boolean z5;
        char c2;
        if (a() < 1) {
            return null;
        }
        char c3 = 0;
        try {
            try {
                Random random = new Random();
                StringBuffer stringBuffer2 = new StringBuffer(512);
                ArrayList<Long> arrayList = new ArrayList();
                WifiInfo l = f.a().l();
                if (l == null || l.getBSSID() == null) {
                    i2 = -1;
                    str = null;
                    str2 = null;
                } else {
                    String replace = l.getBSSID().replace(":", "");
                    int rssi = l.getRssi();
                    String n = f.a().n();
                    if (rssi < 0) {
                        i2 = -rssi;
                        str = n;
                        str2 = replace;
                    } else {
                        i2 = rssi;
                        str = n;
                        str2 = replace;
                    }
                }
                long j4 = 0;
                long j5 = 0;
                boolean z6 = false;
                if (Build.VERSION.SDK_INT >= 17) {
                    try {
                        j4 = SystemClock.elapsedRealtimeNanos() / 1000;
                    } catch (Error e) {
                        j4 = 0;
                    }
                    if (j4 > 0) {
                        z6 = true;
                        j = j4;
                        boolean z7 = z6 ? z6 : z6 && z;
                        int i6 = 0;
                        int i7 = 0;
                        size = this.a.size();
                        z3 = true;
                        if (size <= i) {
                            i = size;
                        }
                        StringBuffer stringBuffer3 = null;
                        i3 = 0;
                        while (i3 < i) {
                            if (this.a.get(i3).level == 0) {
                                stringBuffer = stringBuffer3;
                                i4 = i7;
                                boolean z8 = z3;
                                i5 = i6;
                                j3 = j5;
                                c = c3;
                                z5 = z8;
                            } else {
                                if (z7) {
                                    try {
                                        j2 = (j - this.a.get(i3).timestamp) / 1000000;
                                    } catch (Exception e2) {
                                        j2 = 0;
                                    }
                                    arrayList.add(Long.valueOf(j2));
                                    if (j2 > j5) {
                                        j5 = j2;
                                    }
                                }
                                if (z3) {
                                    z3 = false;
                                    stringBuffer2.append("&wf=");
                                    if (z2) {
                                        stringBuffer3 = new StringBuffer();
                                        stringBuffer3.append("&wf_ch=");
                                        stringBuffer3.append(b(this.a.get(i3).frequency));
                                    }
                                } else {
                                    stringBuffer2.append("|");
                                    if (z2 && stringBuffer3 != null) {
                                        stringBuffer3.append("|");
                                        stringBuffer3.append(b(this.a.get(i3).frequency));
                                    }
                                }
                                String str3 = this.a.get(i3).BSSID;
                                if (str3 != null) {
                                    String replace2 = str3.replace(":", "");
                                    stringBuffer2.append(replace2);
                                    int i8 = this.a.get(i3).level;
                                    if (i8 < 0) {
                                        i8 = -i8;
                                    }
                                    stringBuffer2.append(String.format(Locale.CHINA, ";%d;", Integer.valueOf(i8)));
                                    i6++;
                                    boolean z9 = false;
                                    if (str2 != null && str2.equals(replace2)) {
                                        this.e = a(this.a.get(i3).capabilities);
                                        z9 = true;
                                        i7 = i6;
                                    }
                                    if (z9) {
                                        stringBuffer2.append(b(this.a.get(i3).SSID));
                                    } else {
                                        if (c3 == 0) {
                                            try {
                                                if (random.nextInt(10) == 2 && this.a.get(i3).SSID != null && this.a.get(i3).SSID.length() < 30) {
                                                    stringBuffer2.append(b(this.a.get(i3).SSID));
                                                    c2 = 1;
                                                }
                                                c2 = c3;
                                            } catch (Exception e3) {
                                                stringBuffer = stringBuffer3;
                                                i4 = i7;
                                                boolean z10 = z3;
                                                i5 = i6;
                                                j3 = j5;
                                                c = c3;
                                                z5 = z10;
                                            }
                                        } else {
                                            if (c3 == 1 && random.nextInt(20) == 1 && this.a.get(i3).SSID != null && this.a.get(i3).SSID.length() < 30) {
                                                stringBuffer2.append(b(this.a.get(i3).SSID));
                                                c2 = 2;
                                            }
                                            c2 = c3;
                                        }
                                        z5 = z3;
                                        i5 = i6;
                                        int i9 = i7;
                                        j3 = j5;
                                        c = c2;
                                        stringBuffer = stringBuffer3;
                                        i4 = i9;
                                    }
                                }
                                stringBuffer = stringBuffer3;
                                i4 = i7;
                                boolean z11 = z3;
                                i5 = i6;
                                j3 = j5;
                                c = c3;
                                z5 = z11;
                            }
                            i3++;
                            boolean z12 = z5;
                            c3 = c;
                            j5 = j3;
                            i7 = i4;
                            i6 = i5;
                            stringBuffer3 = stringBuffer;
                            z3 = z12;
                        }
                        if (z3) {
                            stringBuffer2.append("&wf_n=" + i7);
                            if (str2 != null && i2 != -1) {
                                stringBuffer2.append("&wf_rs=" + i2);
                            }
                            if (j5 > 10 && arrayList.size() > 0 && ((Long) arrayList.get(0)).longValue() > 0) {
                                StringBuffer stringBuffer4 = new StringBuffer(128);
                                stringBuffer4.append("&wf_ut=");
                                boolean z13 = true;
                                Long l2 = (Long) arrayList.get(0);
                                for (Long l3 : arrayList) {
                                    if (z13) {
                                        stringBuffer4.append(l3.longValue());
                                        z4 = false;
                                    } else {
                                        long longValue = l3.longValue() - l2.longValue();
                                        if (longValue != 0) {
                                            stringBuffer4.append("" + longValue);
                                        }
                                        z4 = z13;
                                    }
                                    stringBuffer4.append("|");
                                    z13 = z4;
                                }
                                stringBuffer2.append(stringBuffer4.toString());
                            }
                            stringBuffer2.append("&wf_st=");
                            stringBuffer2.append(this.b);
                            stringBuffer2.append("&wf_et=");
                            stringBuffer2.append(this.c);
                            stringBuffer2.append("&wf_vt=");
                            stringBuffer2.append(f.a);
                            if (i7 > 0) {
                                this.d = true;
                                stringBuffer2.append("&wf_en=");
                                stringBuffer2.append(this.e ? 1 : 0);
                            }
                            if (str != null) {
                                stringBuffer2.append("&wf_gw=");
                                stringBuffer2.append(str);
                            }
                            if (stringBuffer3 != null) {
                                stringBuffer2.append(stringBuffer3.toString());
                            }
                            return stringBuffer2.toString();
                        }
                        return null;
                    }
                }
                j = j4;
                if (z6) {
                }
                int i62 = 0;
                int i72 = 0;
                size = this.a.size();
                z3 = true;
                if (size <= i) {
                }
                StringBuffer stringBuffer32 = null;
                i3 = 0;
                while (i3 < i) {
                }
                if (z3) {
                }
            } catch (Exception e4) {
                return null;
            }
        } catch (Error e5) {
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0098  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(long j) {
        boolean z;
        long j2;
        int i;
        int i2;
        long j3;
        long j4 = 0;
        long j5 = 0;
        long j6 = 0;
        if (Build.VERSION.SDK_INT >= 17) {
            try {
                j4 = SystemClock.elapsedRealtimeNanos() / 1000;
            } catch (Error e) {
                j4 = 0;
            } catch (Exception e2) {
                j4 = 0;
            }
            if (j4 > 0) {
                z = true;
                j2 = j4;
                if (z || this.a == null || this.a.size() == 0) {
                    return false;
                }
                int size = this.a.size();
                i = size <= 16 ? 16 : size;
                for (i2 = 0; i2 < i; i2++) {
                    if (this.a.get(i2).level != 0 && z) {
                        try {
                            j3 = (j2 - this.a.get(i2).timestamp) / 1000000;
                        } catch (Error e3) {
                            j3 = 0;
                        } catch (Exception e4) {
                            j3 = 0;
                        }
                        j6 += j3;
                        if (j3 > j5) {
                            j5 = j3;
                        }
                    }
                }
                return 1000 * j5 <= j || (j6 / ((long) i)) * 1000 > j;
            }
        }
        z = false;
        j2 = j4;
        if (z) {
            return false;
        }
        int size2 = this.a.size();
        if (size2 <= 16) {
        }
        while (i2 < i) {
        }
        return 1000 * j5 <= j || (j6 / ((long) i)) * 1000 > j;
    }

    public boolean a(e eVar) {
        if (this.a == null || eVar == null || eVar.a == null) {
            return false;
        }
        int size = this.a.size() < eVar.a.size() ? this.a.size() : eVar.a.size();
        for (int i = 0; i < size; i++) {
            if (!this.a.get(i).BSSID.equals(eVar.a.get(i).BSSID)) {
                return false;
            }
        }
        return true;
    }

    public int b(int i) {
        if (i <= 2400 || i >= 2500) {
            return (i <= 4900 || i >= 5900) ? 0 : 5;
        }
        return 2;
    }

    public String b() {
        try {
            return a(g.O, true, true);
        } catch (Exception e) {
            return null;
        }
    }

    public boolean b(e eVar) {
        if (this.a == null || eVar == null || eVar.a == null) {
            return false;
        }
        int size = this.a.size() < eVar.a.size() ? this.a.size() : eVar.a.size();
        for (int i = 0; i < size; i++) {
            String str = this.a.get(i).BSSID;
            int i2 = this.a.get(i).level;
            String str2 = eVar.a.get(i).BSSID;
            int i3 = eVar.a.get(i).level;
            if (!str.equals(str2) || i2 != i3) {
                return false;
            }
        }
        return true;
    }

    public String c() {
        try {
            return a(g.O, true, false);
        } catch (Exception e) {
            return null;
        }
    }

    public String c(int i) {
        if (a() < 1) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer(512);
        int size = this.a.size();
        if (size <= i) {
            i = size;
        }
        int i2 = 0;
        boolean z = true;
        while (i2 < i) {
            if (this.a.get(i2).level != 0 && this.a.get(i2).BSSID != null) {
                if (z) {
                    z = false;
                } else {
                    stringBuffer.append("|");
                }
                stringBuffer.append(this.a.get(i2).BSSID.replace(":", ""));
                int i3 = this.a.get(i2).level;
                if (i3 < 0) {
                    i3 = -i3;
                }
                stringBuffer.append(String.format(Locale.CHINA, ";%d;", Integer.valueOf(i3)));
            }
            i2++;
            z = z;
        }
        if (z) {
            return null;
        }
        return stringBuffer.toString();
    }

    public boolean c(e eVar) {
        return f.a(eVar, this);
    }

    public String d() {
        try {
            return a(15);
        } catch (Exception e) {
            return null;
        }
    }

    public String d(int i) {
        int i2;
        int i3 = 0;
        if (i == 0 || a() < 1) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer(256);
        int size = this.a.size();
        int i4 = size > g.O ? g.O : size;
        int i5 = 1;
        int i6 = 0;
        while (i6 < i4) {
            if ((i5 & i) == 0 || this.a.get(i6).BSSID == null) {
                i2 = i3;
            } else {
                if (i3 == 0) {
                    stringBuffer.append("&ssid=");
                } else {
                    stringBuffer.append("|");
                }
                stringBuffer.append(this.a.get(i6).BSSID.replace(":", ""));
                stringBuffer.append(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
                stringBuffer.append(b(this.a.get(i6).SSID));
                i2 = i3 + 1;
            }
            i5 <<= 1;
            i6++;
            i3 = i2;
        }
        return stringBuffer.toString();
    }

    public boolean e() {
        return a(g.af);
    }

    @SuppressLint({"NewApi"})
    public long f() {
        long j;
        boolean z;
        long j2;
        if (this.a == null || this.a.size() == 0) {
            return 0L;
        }
        if (Build.VERSION.SDK_INT >= 17) {
            try {
                j = SystemClock.elapsedRealtimeNanos() / 1000;
            } catch (Error e) {
                j = 0;
            } catch (Exception e2) {
                j = 0;
            }
            z = j > 0;
        } else {
            z = false;
            j = 0;
        }
        int size = this.a.size();
        int i = size <= 16 ? size : 16;
        long j3 = 0;
        for (int i2 = 0; i2 < i; i2++) {
            if (this.a.get(i2).level != 0 && z) {
                try {
                    j2 = (j - this.a.get(i2).timestamp) / 1000000;
                } catch (Error e3) {
                    j2 = 0;
                } catch (Exception e4) {
                    j2 = 0;
                }
                if (j2 > j3) {
                    j3 = j2;
                }
            }
        }
        return j3;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:49:? A[RETURN, SYNTHETIC] */
    @SuppressLint({"NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long g() {
        boolean z;
        int i;
        int i2;
        long j;
        if (this.a == null || this.a.size() == 0) {
            return 0L;
        }
        long j2 = 0;
        long j3 = 0;
        long j4 = 0;
        long j5 = 0;
        if (Build.VERSION.SDK_INT >= 17) {
            try {
                j2 = SystemClock.elapsedRealtimeNanos() / 1000;
            } catch (Error e) {
                j2 = 0;
            } catch (Exception e2) {
                j2 = 0;
            }
            if (j2 > 0) {
                z = true;
                int size = this.a.size();
                i = size <= 16 ? 16 : size;
                for (i2 = 0; i2 < i; i2++) {
                    if (this.a.get(i2).level != 0 && z) {
                        try {
                            j = (j2 - this.a.get(i2).timestamp) / 1000000;
                        } catch (Error e3) {
                            j = 0;
                        } catch (Exception e4) {
                            j = 0;
                        }
                        j4 += j;
                        j5++;
                        if (j > j3) {
                            j3 = j;
                        }
                    }
                }
                return j5 <= 1 ? (j4 - j3) / (j5 - 1) : j3;
            }
        }
        z = false;
        int size2 = this.a.size();
        if (size2 <= 16) {
        }
        while (i2 < i) {
        }
        if (j5 <= 1) {
        }
    }

    public int h() {
        for (int i = 0; i < a(); i++) {
            int i2 = -this.a.get(i).level;
            if (i2 > 0) {
                return i2;
            }
        }
        return 0;
    }

    public boolean i() {
        return this.d;
    }

    public boolean j() {
        return System.currentTimeMillis() - this.c > 0 && System.currentTimeMillis() - this.c < 5000;
    }

    public boolean k() {
        return System.currentTimeMillis() - this.c > 0 && System.currentTimeMillis() - this.c < 5000;
    }

    public boolean l() {
        return System.currentTimeMillis() - this.c > 0 && System.currentTimeMillis() - this.b < 5000;
    }
}
