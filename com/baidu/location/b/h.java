package com.baidu.location.b;

import android.annotation.SuppressLint;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.searchbox.v8engine.util.TimeUtils;
import com.baidu.webkit.internal.ETAG;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.regex.Pattern;
/* loaded from: classes4.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public List<ScanResult> f1956a;
    private long b;
    private long c;
    private boolean d = false;
    private boolean e;

    public h(List<ScanResult> list, long j) {
        this.f1956a = null;
        this.b = 0L;
        this.c = 0L;
        this.b = j;
        this.f1956a = list;
        this.c = System.currentTimeMillis();
        m();
    }

    private boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return Pattern.compile("wpa|wep", 2).matcher(str).find();
    }

    private String b(String str) {
        return str != null ? (str.contains(ETAG.ITEM_SEPARATOR) || str.contains(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR)) ? str.replace(ETAG.ITEM_SEPARATOR, PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS).replace(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR, PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS) : str : str;
    }

    private int l() {
        if (this.f1956a == null) {
            return 0;
        }
        return this.f1956a.size();
    }

    private void m() {
        boolean z;
        if (l() < 1) {
            return;
        }
        boolean z2 = true;
        for (int size = this.f1956a.size() - 1; size >= 1 && z2; size--) {
            int i = 0;
            z2 = false;
            while (i < size) {
                if (this.f1956a.get(i).level < this.f1956a.get(i + 1).level) {
                    this.f1956a.set(i + 1, this.f1956a.get(i));
                    this.f1956a.set(i, this.f1956a.get(i + 1));
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
        if (this.f1956a == null) {
            return 0;
        }
        return this.f1956a.size();
    }

    public String a(int i) {
        return a(i, false, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:130:0x0381 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:134:0x038a  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x038e  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x024a A[EDGE_INSN: B:147:0x024a->B:93:0x024a ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x008b A[Catch: Error -> 0x01e0, Exception -> 0x0246, TRY_LEAVE, TryCatch #0 {Error -> 0x01e0, blocks: (B:7:0x000a, B:9:0x002a, B:11:0x0030, B:14:0x0053, B:27:0x0077, B:32:0x008b, B:39:0x00a5, B:40:0x00b8, B:44:0x00c8, B:46:0x00d3, B:47:0x00f3, B:49:0x0101, B:52:0x011f, B:54:0x0146, B:56:0x014e, B:61:0x016c, B:63:0x0175, B:65:0x0183, B:67:0x0197, B:82:0x01e9, B:84:0x01f2, B:86:0x0200, B:88:0x0214, B:90:0x022d, B:72:0x01b7, B:75:0x01c3, B:94:0x024c, B:98:0x026c, B:101:0x028d, B:103:0x0293, B:105:0x02a6, B:106:0x02c1, B:108:0x02c7, B:110:0x02cf, B:111:0x02d8, B:112:0x02e0, B:114:0x02ef, B:116:0x0308, B:117:0x0311, B:119:0x0344, B:122:0x0358, B:124:0x035f, B:126:0x0370, B:127:0x0379), top: B:139:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x024c A[Catch: Error -> 0x01e0, Exception -> 0x0246, TryCatch #0 {Error -> 0x01e0, blocks: (B:7:0x000a, B:9:0x002a, B:11:0x0030, B:14:0x0053, B:27:0x0077, B:32:0x008b, B:39:0x00a5, B:40:0x00b8, B:44:0x00c8, B:46:0x00d3, B:47:0x00f3, B:49:0x0101, B:52:0x011f, B:54:0x0146, B:56:0x014e, B:61:0x016c, B:63:0x0175, B:65:0x0183, B:67:0x0197, B:82:0x01e9, B:84:0x01f2, B:86:0x0200, B:88:0x0214, B:90:0x022d, B:72:0x01b7, B:75:0x01c3, B:94:0x024c, B:98:0x026c, B:101:0x028d, B:103:0x0293, B:105:0x02a6, B:106:0x02c1, B:108:0x02c7, B:110:0x02cf, B:111:0x02d8, B:112:0x02e0, B:114:0x02ef, B:116:0x0308, B:117:0x0311, B:119:0x0344, B:122:0x0358, B:124:0x035f, B:126:0x0370, B:127:0x0379), top: B:139:0x000a }] */
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
        int i4;
        boolean z4;
        long j2;
        char c;
        if (a() < 1) {
            return null;
        }
        char c2 = 0;
        try {
            try {
                Random random = new Random();
                StringBuffer stringBuffer = new StringBuffer(512);
                ArrayList<Long> arrayList = new ArrayList();
                WifiInfo k = i.a().k();
                if (k == null || k.getBSSID() == null) {
                    i2 = -1;
                    str = null;
                    str2 = null;
                } else {
                    String replace = k.getBSSID().replace(":", "");
                    int rssi = k.getRssi();
                    String m = i.a().m();
                    if (rssi < 0) {
                        i2 = -rssi;
                        str = m;
                        str2 = replace;
                    } else {
                        i2 = rssi;
                        str = m;
                        str2 = replace;
                    }
                }
                long j3 = 0;
                long j4 = 0;
                boolean z5 = false;
                if (Build.VERSION.SDK_INT >= 17) {
                    try {
                        j3 = SystemClock.elapsedRealtimeNanos() / 1000;
                    } catch (Error e) {
                        j3 = 0;
                    }
                    if (j3 > 0) {
                        z5 = true;
                        j = j3;
                        boolean z6 = z5 ? z5 : z5 && z;
                        int i5 = 0;
                        int i6 = 0;
                        size = this.f1956a.size();
                        z3 = true;
                        if (size <= i) {
                            i = size;
                        }
                        StringBuffer stringBuffer2 = null;
                        i3 = 0;
                        while (true) {
                            i4 = i3;
                            if (i4 < i) {
                                break;
                            }
                            if (this.f1956a.get(i4).level != 0) {
                                if (z6) {
                                    try {
                                        j2 = (j - this.f1956a.get(i4).timestamp) / TimeUtils.NANOS_PER_MS;
                                    } catch (Exception e2) {
                                        j2 = 0;
                                    }
                                    arrayList.add(Long.valueOf(j2));
                                    if (j2 > j4) {
                                        j4 = j2;
                                    }
                                }
                                if (z3) {
                                    z3 = false;
                                    stringBuffer.append("&wf=");
                                    if (z2) {
                                        stringBuffer2 = new StringBuffer();
                                        stringBuffer2.append("&wf_ch=");
                                        stringBuffer2.append(b(this.f1956a.get(i4).frequency));
                                    }
                                } else {
                                    stringBuffer.append("|");
                                    if (z2 && stringBuffer2 != null) {
                                        stringBuffer2.append("|");
                                        stringBuffer2.append(b(this.f1956a.get(i4).frequency));
                                    }
                                }
                                String str3 = this.f1956a.get(i4).BSSID;
                                if (str3 != null) {
                                    String replace2 = str3.replace(":", "");
                                    stringBuffer.append(replace2);
                                    int i7 = this.f1956a.get(i4).level;
                                    if (i7 < 0) {
                                        i7 = -i7;
                                    }
                                    stringBuffer.append(String.format(Locale.CHINA, ";%d;", Integer.valueOf(i7)));
                                    i5++;
                                    boolean z7 = false;
                                    if (str2 != null && str2.equals(replace2)) {
                                        this.e = a(this.f1956a.get(i4).capabilities);
                                        z7 = true;
                                        i6 = i5;
                                    }
                                    if (z7) {
                                        stringBuffer.append(b(this.f1956a.get(i4).SSID));
                                    } else {
                                        if (c2 == 0) {
                                            try {
                                                if (random.nextInt(10) == 2 && this.f1956a.get(i4).SSID != null && this.f1956a.get(i4).SSID.length() < 30) {
                                                    stringBuffer.append(b(this.f1956a.get(i4).SSID));
                                                    c = 1;
                                                }
                                                c = c2;
                                            } catch (Exception e3) {
                                            }
                                        } else {
                                            if (c2 == 1 && random.nextInt(20) == 1 && this.f1956a.get(i4).SSID != null && this.f1956a.get(i4).SSID.length() < 30) {
                                                stringBuffer.append(b(this.f1956a.get(i4).SSID));
                                                c = 2;
                                            }
                                            c = c2;
                                        }
                                        c2 = c;
                                    }
                                }
                            }
                            i3 = i4 + 1;
                        }
                        if (z3) {
                            stringBuffer.append("&wf_n=" + i6);
                            if (str2 != null && i2 != -1) {
                                stringBuffer.append("&wf_rs=" + i2);
                            }
                            if (j4 > 10 && arrayList.size() > 0 && ((Long) arrayList.get(0)).longValue() > 0) {
                                StringBuffer stringBuffer3 = new StringBuffer(128);
                                stringBuffer3.append("&wf_ut=");
                                boolean z8 = true;
                                Long l = (Long) arrayList.get(0);
                                for (Long l2 : arrayList) {
                                    if (z8) {
                                        stringBuffer3.append(l2.longValue());
                                        z4 = false;
                                    } else {
                                        long longValue = l2.longValue() - l.longValue();
                                        if (longValue != 0) {
                                            stringBuffer3.append("" + longValue);
                                        }
                                        z4 = z8;
                                    }
                                    stringBuffer3.append("|");
                                    z8 = z4;
                                }
                                stringBuffer.append(stringBuffer3.toString());
                            }
                            stringBuffer.append("&wf_st=");
                            stringBuffer.append(this.b);
                            stringBuffer.append("&wf_et=");
                            stringBuffer.append(this.c);
                            stringBuffer.append("&wf_vt=");
                            stringBuffer.append(i.f1957a);
                            if (i6 > 0) {
                                this.d = true;
                                stringBuffer.append("&wf_en=");
                                stringBuffer.append(this.e ? 1 : 0);
                            }
                            if (str != null) {
                                stringBuffer.append("&wf_gw=");
                                stringBuffer.append(str);
                            }
                            if (stringBuffer2 != null) {
                                stringBuffer.append(stringBuffer2.toString());
                            }
                            return stringBuffer.toString();
                        }
                        return null;
                    }
                }
                j = j3;
                if (z5) {
                }
                int i52 = 0;
                int i62 = 0;
                size = this.f1956a.size();
                z3 = true;
                if (size <= i) {
                }
                StringBuffer stringBuffer22 = null;
                i3 = 0;
                while (true) {
                    i4 = i3;
                    if (i4 < i) {
                    }
                    i3 = i4 + 1;
                }
                if (z3) {
                }
            } catch (Error e4) {
                return null;
            }
        } catch (Exception e5) {
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
                if (z || this.f1956a == null || this.f1956a.size() == 0) {
                    return false;
                }
                int size = this.f1956a.size();
                i = size <= 16 ? 16 : size;
                for (i2 = 0; i2 < i; i2++) {
                    if (this.f1956a.get(i2).level != 0 && z) {
                        try {
                            j3 = (j2 - this.f1956a.get(i2).timestamp) / TimeUtils.NANOS_PER_MS;
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
        int size2 = this.f1956a.size();
        if (size2 <= 16) {
        }
        while (i2 < i) {
        }
        return 1000 * j5 <= j || (j6 / ((long) i)) * 1000 > j;
    }

    public boolean a(h hVar) {
        if (this.f1956a == null || hVar == null || hVar.f1956a == null) {
            return false;
        }
        int size = this.f1956a.size() < hVar.f1956a.size() ? this.f1956a.size() : hVar.f1956a.size();
        for (int i = 0; i < size; i++) {
            if (!this.f1956a.get(i).BSSID.equals(hVar.f1956a.get(i).BSSID)) {
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
            return a(com.baidu.location.d.j.O, true, true);
        } catch (Exception e) {
            return null;
        }
    }

    public boolean b(h hVar) {
        if (this.f1956a == null || hVar == null || hVar.f1956a == null) {
            return false;
        }
        int size = this.f1956a.size() < hVar.f1956a.size() ? this.f1956a.size() : hVar.f1956a.size();
        for (int i = 0; i < size; i++) {
            String str = this.f1956a.get(i).BSSID;
            int i2 = this.f1956a.get(i).level;
            String str2 = hVar.f1956a.get(i).BSSID;
            int i3 = hVar.f1956a.get(i).level;
            if (!str.equals(str2) || i2 != i3) {
                return false;
            }
        }
        return true;
    }

    public String c() {
        try {
            return a(com.baidu.location.d.j.O, true, false);
        } catch (Exception e) {
            return null;
        }
    }

    public String c(int i) {
        int i2;
        int i3 = 1;
        if (i == 0 || a() < 1) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer(256);
        int size = this.f1956a.size();
        int i4 = size > com.baidu.location.d.j.O ? com.baidu.location.d.j.O : size;
        int i5 = 0;
        int i6 = 0;
        while (i5 < i4) {
            if ((i3 & i) == 0 || this.f1956a.get(i5).BSSID == null) {
                i2 = i6;
            } else {
                if (i6 == 0) {
                    stringBuffer.append("&ssid=");
                } else {
                    stringBuffer.append("|");
                }
                stringBuffer.append(this.f1956a.get(i5).BSSID.replace(":", ""));
                stringBuffer.append(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
                stringBuffer.append(b(this.f1956a.get(i5).SSID));
                i2 = i6 + 1;
            }
            i5++;
            i6 = i2;
            i3 <<= 1;
        }
        return stringBuffer.toString();
    }

    public boolean c(h hVar) {
        return i.a(hVar, this);
    }

    public String d() {
        try {
            return a(15);
        } catch (Exception e) {
            return null;
        }
    }

    public boolean e() {
        return a(com.baidu.location.d.j.af);
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
    public long f() {
        boolean z;
        int i;
        int i2;
        long j;
        if (this.f1956a == null || this.f1956a.size() == 0) {
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
                int size = this.f1956a.size();
                i = size <= 16 ? 16 : size;
                for (i2 = 0; i2 < i; i2++) {
                    if (this.f1956a.get(i2).level != 0 && z) {
                        try {
                            j = (j2 - this.f1956a.get(i2).timestamp) / TimeUtils.NANOS_PER_MS;
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
        int size2 = this.f1956a.size();
        if (size2 <= 16) {
        }
        while (i2 < i) {
        }
        if (j5 <= 1) {
        }
    }

    public int g() {
        for (int i = 0; i < a(); i++) {
            int i2 = -this.f1956a.get(i).level;
            if (i2 > 0) {
                return i2;
            }
        }
        return 0;
    }

    public boolean h() {
        return this.d;
    }

    public boolean i() {
        return System.currentTimeMillis() - this.c > 0 && System.currentTimeMillis() - this.c < 5000;
    }

    public boolean j() {
        return System.currentTimeMillis() - this.c > 0 && System.currentTimeMillis() - this.c < 5000;
    }

    public boolean k() {
        return System.currentTimeMillis() - this.c > 0 && System.currentTimeMillis() - this.b < 5000;
    }
}
