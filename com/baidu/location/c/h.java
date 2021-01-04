package com.baidu.location.c;

import android.annotation.SuppressLint;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.location.e.l;
import com.baidu.searchbox.v8engine.util.TimeUtils;
import com.baidu.webkit.internal.ETAG;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.regex.Pattern;
/* loaded from: classes15.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public List<ScanResult> f2696a;

    /* renamed from: b  reason: collision with root package name */
    private long f2697b;
    private long c;
    private boolean d = false;
    private boolean e;

    public h(List<ScanResult> list, long j) {
        this.f2696a = null;
        this.f2697b = 0L;
        this.c = 0L;
        this.f2697b = j;
        this.f2696a = list;
        this.c = System.currentTimeMillis();
        try {
            n();
        } catch (Exception e) {
            e.printStackTrace();
        }
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

    private int m() {
        if (this.f2696a == null) {
            return 0;
        }
        return this.f2696a.size();
    }

    private void n() {
        boolean z;
        if (m() < 1) {
            return;
        }
        boolean z2 = true;
        for (int size = this.f2696a.size() - 1; size >= 1 && z2; size--) {
            int i = 0;
            z2 = false;
            while (i < size) {
                if (this.f2696a.get(i) == null || this.f2696a.get(i + 1) == null || this.f2696a.get(i).level >= this.f2696a.get(i + 1).level) {
                    z = z2;
                } else {
                    this.f2696a.set(i + 1, this.f2696a.get(i));
                    this.f2696a.set(i, this.f2696a.get(i + 1));
                    z = true;
                }
                i++;
                z2 = z;
            }
        }
    }

    public int a() {
        if (this.f2696a == null) {
            return 0;
        }
        return this.f2696a.size();
    }

    public String a(int i) {
        return a(i, false, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x024f  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x02d9 A[Catch: Error -> 0x01d9, Exception -> 0x01e7, TryCatch #2 {Exception -> 0x01e7, blocks: (B:7:0x000a, B:9:0x002a, B:11:0x0030, B:14:0x0053, B:17:0x005e, B:27:0x0078, B:29:0x0086, B:35:0x0096, B:37:0x00a2, B:45:0x00cf, B:48:0x00dd, B:58:0x0107, B:59:0x010f, B:61:0x011d, B:64:0x013b, B:66:0x0162, B:68:0x016a, B:103:0x0234, B:88:0x01dd, B:85:0x01d4, B:106:0x0251, B:108:0x025d, B:110:0x026b, B:113:0x027c, B:115:0x0282, B:116:0x028b, B:118:0x029b, B:121:0x02bb, B:122:0x02d3, B:145:0x0380, B:125:0x02d9, B:127:0x02f4, B:131:0x030c, B:134:0x032d, B:136:0x0333, B:138:0x0346, B:139:0x0361, B:141:0x0367, B:143:0x036f, B:144:0x0378, B:146:0x038a, B:148:0x0399, B:150:0x03b2, B:151:0x03bb, B:153:0x03ee, B:156:0x0402, B:158:0x0409, B:159:0x0418), top: B:177:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0420 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:168:0x042f  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0434  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0086 A[Catch: Error -> 0x01d9, Exception -> 0x01e7, TryCatch #2 {Exception -> 0x01e7, blocks: (B:7:0x000a, B:9:0x002a, B:11:0x0030, B:14:0x0053, B:17:0x005e, B:27:0x0078, B:29:0x0086, B:35:0x0096, B:37:0x00a2, B:45:0x00cf, B:48:0x00dd, B:58:0x0107, B:59:0x010f, B:61:0x011d, B:64:0x013b, B:66:0x0162, B:68:0x016a, B:103:0x0234, B:88:0x01dd, B:85:0x01d4, B:106:0x0251, B:108:0x025d, B:110:0x026b, B:113:0x027c, B:115:0x0282, B:116:0x028b, B:118:0x029b, B:121:0x02bb, B:122:0x02d3, B:145:0x0380, B:125:0x02d9, B:127:0x02f4, B:131:0x030c, B:134:0x032d, B:136:0x0333, B:138:0x0346, B:139:0x0361, B:141:0x0367, B:143:0x036f, B:144:0x0378, B:146:0x038a, B:148:0x0399, B:150:0x03b2, B:151:0x03bb, B:153:0x03ee, B:156:0x0402, B:158:0x0409, B:159:0x0418), top: B:177:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0096 A[Catch: Error -> 0x01d9, Exception -> 0x01e7, TryCatch #2 {Exception -> 0x01e7, blocks: (B:7:0x000a, B:9:0x002a, B:11:0x0030, B:14:0x0053, B:17:0x005e, B:27:0x0078, B:29:0x0086, B:35:0x0096, B:37:0x00a2, B:45:0x00cf, B:48:0x00dd, B:58:0x0107, B:59:0x010f, B:61:0x011d, B:64:0x013b, B:66:0x0162, B:68:0x016a, B:103:0x0234, B:88:0x01dd, B:85:0x01d4, B:106:0x0251, B:108:0x025d, B:110:0x026b, B:113:0x027c, B:115:0x0282, B:116:0x028b, B:118:0x029b, B:121:0x02bb, B:122:0x02d3, B:145:0x0380, B:125:0x02d9, B:127:0x02f4, B:131:0x030c, B:134:0x032d, B:136:0x0333, B:138:0x0346, B:139:0x0361, B:141:0x0367, B:143:0x036f, B:144:0x0378, B:146:0x038a, B:148:0x0399, B:150:0x03b2, B:151:0x03bb, B:153:0x03ee, B:156:0x0402, B:158:0x0409, B:159:0x0418), top: B:177:0x000a }] */
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
        boolean z4;
        int i3;
        boolean z5;
        long j2;
        char c;
        if (a() < 1) {
            return null;
        }
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
                boolean z6 = false;
                if (Build.VERSION.SDK_INT >= 17) {
                    try {
                        j3 = SystemClock.elapsedRealtimeNanos() / 1000;
                    } catch (Error e) {
                        j3 = 0;
                    }
                    if (j3 > 0) {
                        z6 = true;
                        j = j3;
                        boolean z7 = z6 ? z6 : z6 && z;
                        int i4 = 0;
                        int i5 = 0;
                        size = this.f2696a.size();
                        z3 = true;
                        if (size <= i) {
                            z4 = i < l.az;
                        } else {
                            z4 = false;
                            i = size;
                        }
                        StringBuffer stringBuffer2 = null;
                        int i6 = 0;
                        i3 = 0;
                        char c2 = 0;
                        while (i3 < i) {
                            int i7 = i6 + 1;
                            if (this.f2696a.get(i3) != null && this.f2696a.get(i3).level != 0) {
                                if (z7) {
                                    try {
                                        j2 = (j - this.f2696a.get(i3).timestamp) / TimeUtils.NANOS_PER_MS;
                                    } catch (Exception e2) {
                                        j2 = 0;
                                    }
                                    arrayList.add(Long.valueOf(j2));
                                    if (j2 > j4) {
                                        j4 = j2;
                                    }
                                }
                                if (Build.VERSION.SDK_INT >= 23) {
                                    try {
                                        if (this.f2696a.get(i3).is80211mcResponder()) {
                                            if (stringBuffer2 == null) {
                                                stringBuffer2 = new StringBuffer();
                                            }
                                            stringBuffer2.append(i3);
                                            stringBuffer2.append("|");
                                        }
                                    } catch (Throwable th) {
                                        th.printStackTrace();
                                    }
                                }
                                if (z3) {
                                    z3 = false;
                                    stringBuffer.append("&wf=");
                                } else {
                                    stringBuffer.append("|");
                                }
                                String str3 = this.f2696a.get(i3).BSSID;
                                if (str3 != null) {
                                    String replace2 = str3.replace(":", "");
                                    stringBuffer.append(replace2);
                                    int i8 = this.f2696a.get(i3).level;
                                    if (i8 < 0) {
                                        i8 = -i8;
                                    }
                                    stringBuffer.append(String.format(Locale.CHINA, ";%d;", Integer.valueOf(i8)));
                                    i4++;
                                    boolean z8 = false;
                                    if (str2 != null && str2.equals(replace2)) {
                                        this.e = a(this.f2696a.get(i3).capabilities);
                                        z8 = true;
                                        i5 = i4;
                                    }
                                    if (z8) {
                                        stringBuffer.append(b(this.f2696a.get(i3).SSID));
                                    } else {
                                        if (c2 == 0) {
                                            try {
                                                if (random.nextInt(10) == 2 && this.f2696a.get(i3).SSID != null && this.f2696a.get(i3).SSID.length() < 30) {
                                                    stringBuffer.append(b(this.f2696a.get(i3).SSID));
                                                    c = 1;
                                                }
                                                c = c2;
                                            } catch (Exception e3) {
                                            }
                                        } else {
                                            if (c2 == 1 && random.nextInt(20) == 1 && this.f2696a.get(i3).SSID != null && this.f2696a.get(i3).SSID.length() < 30) {
                                                stringBuffer.append(b(this.f2696a.get(i3).SSID));
                                                c = 2;
                                            }
                                            c = c2;
                                        }
                                        c2 = c;
                                    }
                                }
                            }
                            i3++;
                            i6 = i7;
                        }
                        if (z4) {
                            boolean z9 = true;
                            int i9 = i6;
                            while (i < this.f2696a.size()) {
                                i9++;
                                if (this.f2696a.get(i) != null && this.f2696a.get(i).level != 0) {
                                    if (z9) {
                                        z9 = false;
                                        stringBuffer.append("&wf2=");
                                    } else {
                                        stringBuffer.append("|");
                                    }
                                    String str4 = this.f2696a.get(i).BSSID;
                                    if (str4 != null) {
                                        stringBuffer.append(str4.replace(":", ""));
                                        int i10 = this.f2696a.get(i).level;
                                        if (i10 < 0) {
                                            i10 = -i10;
                                        }
                                        stringBuffer.append(String.format(Locale.CHINA, ";%d;", Integer.valueOf(i10)));
                                    }
                                    if (i9 >= l.az) {
                                        break;
                                    }
                                }
                                i++;
                                z9 = z9;
                            }
                        }
                        if (z3) {
                            stringBuffer.append("&wf_n=" + i5);
                            if (stringBuffer2 != null) {
                                stringBuffer.append("&wf_mc=");
                                stringBuffer.append(stringBuffer2.toString());
                            }
                            if (str2 != null && i2 != -1) {
                                stringBuffer.append("&wf_rs=" + i2);
                            }
                            if (j4 > 10 && arrayList.size() > 0 && ((Long) arrayList.get(0)).longValue() > 0) {
                                StringBuffer stringBuffer3 = new StringBuffer(128);
                                stringBuffer3.append("&wf_ut=");
                                boolean z10 = true;
                                Long l = (Long) arrayList.get(0);
                                for (Long l2 : arrayList) {
                                    if (z10) {
                                        stringBuffer3.append(l2.longValue());
                                        z5 = false;
                                    } else {
                                        long longValue = l2.longValue() - l.longValue();
                                        if (longValue != 0) {
                                            stringBuffer3.append("" + longValue);
                                        }
                                        z5 = z10;
                                    }
                                    stringBuffer3.append("|");
                                    z10 = z5;
                                }
                                stringBuffer.append(stringBuffer3.toString());
                            }
                            stringBuffer.append("&wf_st=");
                            stringBuffer.append(this.f2697b);
                            stringBuffer.append("&wf_et=");
                            stringBuffer.append(this.c);
                            stringBuffer.append("&wf_vt=");
                            stringBuffer.append(i.f2698a);
                            if (i5 > 0) {
                                this.d = true;
                                stringBuffer.append("&wf_en=");
                                stringBuffer.append(this.e ? 1 : 0);
                            }
                            if (str != null) {
                                stringBuffer.append("&wf_gw=");
                                stringBuffer.append(str);
                            }
                            return stringBuffer.toString();
                        }
                        return null;
                    }
                }
                j = j3;
                if (z6) {
                }
                int i42 = 0;
                int i52 = 0;
                size = this.f2696a.size();
                z3 = true;
                if (size <= i) {
                }
                StringBuffer stringBuffer22 = null;
                int i62 = 0;
                i3 = 0;
                char c22 = 0;
                while (i3 < i) {
                }
                if (z4) {
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
    /* JADX WARN: Removed duplicated region for block: B:44:0x00a2  */
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
                if (z || this.f2696a == null || this.f2696a.size() == 0) {
                    return false;
                }
                int size = this.f2696a.size();
                i = size <= 16 ? 16 : size;
                for (i2 = 0; i2 < i; i2++) {
                    if (this.f2696a.get(i2) != null && this.f2696a.get(i2).level != 0 && z) {
                        try {
                            j3 = (j2 - this.f2696a.get(i2).timestamp) / TimeUtils.NANOS_PER_MS;
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
        int size2 = this.f2696a.size();
        if (size2 <= 16) {
        }
        while (i2 < i) {
        }
        return 1000 * j5 <= j || (j6 / ((long) i)) * 1000 > j;
    }

    public boolean a(h hVar) {
        if (this.f2696a == null || hVar == null || hVar.f2696a == null) {
            return false;
        }
        int size = this.f2696a.size() < hVar.f2696a.size() ? this.f2696a.size() : hVar.f2696a.size();
        for (int i = 0; i < size; i++) {
            if (this.f2696a.get(i) != null) {
                String str = this.f2696a.get(i).BSSID;
                String str2 = hVar.f2696a.get(i).BSSID;
                if (!TextUtils.isEmpty(str) && !str.equals(str2)) {
                    return false;
                }
            }
        }
        return true;
    }

    public String b() {
        try {
            return a(l.O, true, true);
        } catch (Exception e) {
            return null;
        }
    }

    public String b(int i) {
        int i2;
        int i3 = 1;
        if (i == 0 || a() < 1) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer(256);
        int size = this.f2696a.size();
        int i4 = size > l.O ? l.O : size;
        int i5 = 0;
        for (int i6 = 0; i6 < i4; i6++) {
            if (this.f2696a.get(i6) != null) {
                if ((i3 & i) == 0 || this.f2696a.get(i6).BSSID == null) {
                    i2 = i5;
                } else {
                    if (i5 == 0) {
                        stringBuffer.append("&ssid=");
                    } else {
                        stringBuffer.append("|");
                    }
                    stringBuffer.append(this.f2696a.get(i6).BSSID.replace(":", ""));
                    stringBuffer.append(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
                    stringBuffer.append(b(this.f2696a.get(i6).SSID));
                    i2 = i5 + 1;
                }
                i3 <<= 1;
                i5 = i2;
            }
        }
        return stringBuffer.toString();
    }

    public boolean b(h hVar) {
        if (this.f2696a == null || hVar == null || hVar.f2696a == null) {
            return false;
        }
        int size = this.f2696a.size() < hVar.f2696a.size() ? this.f2696a.size() : hVar.f2696a.size();
        for (int i = 0; i < size; i++) {
            if (this.f2696a.get(i) != null) {
                String str = this.f2696a.get(i).BSSID;
                int i2 = this.f2696a.get(i).level;
                String str2 = hVar.f2696a.get(i).BSSID;
                int i3 = hVar.f2696a.get(i).level;
                if ((!TextUtils.isEmpty(str) && !str.equals(str2)) || i2 != i3) {
                    return false;
                }
            }
        }
        return true;
    }

    public String c() {
        try {
            return a(l.O, true, false);
        } catch (Exception e) {
            return null;
        }
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
        return a(l.ag);
    }

    @SuppressLint({"NewApi"})
    public long f() {
        long j;
        boolean z;
        long j2;
        if (this.f2696a == null || this.f2696a.size() == 0) {
            return 0L;
        }
        long j3 = 2147483647L;
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
        if (z) {
            int size = this.f2696a.size();
            if (size > 16) {
                size = 16;
            }
            for (int i = 0; i < size; i++) {
                if (this.f2696a.get(i) != null && this.f2696a.get(i).level != 0 && z) {
                    try {
                        j2 = (j - this.f2696a.get(i).timestamp) / TimeUtils.NANOS_PER_MS;
                    } catch (Error e3) {
                        j2 = 0;
                    } catch (Exception e4) {
                        j2 = 0;
                    }
                    if (j2 < j3) {
                        j3 = j2;
                    }
                }
            }
            long j4 = z ? j3 : 0L;
            if (j4 < 0) {
                j4 = 0;
            }
            return j4;
        }
        return 0L;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:53:? A[RETURN, SYNTHETIC] */
    @SuppressLint({"NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long g() {
        boolean z;
        long j;
        if (this.f2696a == null || this.f2696a.size() == 0) {
            return 0L;
        }
        long j2 = 0;
        long j3 = 0;
        long j4 = 0;
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
                if (z) {
                    return 0L;
                }
                int size = this.f2696a.size();
                int i = size > 16 ? 16 : size;
                long j5 = 0;
                for (int i2 = 0; i2 < i; i2++) {
                    if (this.f2696a.get(i2) != null && this.f2696a.get(i2).level != 0 && z) {
                        try {
                            j = (j2 - this.f2696a.get(i2).timestamp) / TimeUtils.NANOS_PER_MS;
                        } catch (Error e3) {
                            j = 0;
                        } catch (Exception e4) {
                            j = 0;
                        }
                        j3 += j;
                        j4++;
                        if (j > j5) {
                            j5 = j;
                        }
                    }
                }
                return j4 > 1 ? (j3 - j5) / (j4 - 1) : j5;
            }
        }
        z = false;
        if (z) {
        }
    }

    public int h() {
        int i;
        for (int i2 = 0; i2 < a(); i2++) {
            if (this.f2696a.get(i2) != null && (i = -this.f2696a.get(i2).level) > 0) {
                return i;
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
        return System.currentTimeMillis() - this.c > 0 && System.currentTimeMillis() - this.f2697b < 5000;
    }
}
