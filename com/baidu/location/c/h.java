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
/* loaded from: classes26.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public List<ScanResult> f1939a;
    private long b;
    private long c;
    private boolean d = false;
    private boolean e;

    public h(List<ScanResult> list, long j) {
        this.f1939a = null;
        this.b = 0L;
        this.c = 0L;
        this.b = j;
        this.f1939a = list;
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
        if (this.f1939a == null) {
            return 0;
        }
        return this.f1939a.size();
    }

    private void n() {
        boolean z;
        if (m() < 1) {
            return;
        }
        boolean z2 = true;
        for (int size = this.f1939a.size() - 1; size >= 1 && z2; size--) {
            int i = 0;
            z2 = false;
            while (i < size) {
                if (this.f1939a.get(i) == null || this.f1939a.get(i + 1) == null || this.f1939a.get(i).level >= this.f1939a.get(i + 1).level) {
                    z = z2;
                } else {
                    this.f1939a.set(i + 1, this.f1939a.get(i));
                    this.f1939a.set(i, this.f1939a.get(i + 1));
                    z = true;
                }
                i++;
                z2 = z;
            }
        }
    }

    public int a() {
        if (this.f1939a == null) {
            return 0;
        }
        return this.f1939a.size();
    }

    public String a(int i) {
        return a(i, false, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:109:0x0274  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x02fe A[Catch: Error -> 0x01ef, Exception -> 0x01fd, TryCatch #0 {Exception -> 0x01fd, blocks: (B:7:0x000a, B:9:0x002a, B:11:0x0030, B:14:0x0053, B:17:0x005e, B:27:0x0079, B:29:0x0087, B:35:0x0099, B:37:0x00a5, B:46:0x00df, B:49:0x00ed, B:59:0x0117, B:60:0x011f, B:62:0x012d, B:65:0x014b, B:67:0x0170, B:69:0x0178, B:106:0x0253, B:89:0x01f3, B:86:0x01ea, B:110:0x0275, B:112:0x0281, B:114:0x028f, B:117:0x02a0, B:119:0x02a7, B:120:0x02b0, B:122:0x02c0, B:125:0x02e0, B:126:0x02f8, B:149:0x03a5, B:129:0x02fe, B:131:0x0319, B:135:0x0331, B:138:0x0352, B:140:0x0358, B:142:0x036b, B:143:0x0386, B:145:0x038c, B:147:0x0394, B:148:0x039d, B:150:0x03af, B:152:0x03be, B:154:0x03d7, B:155:0x03e0, B:157:0x0413, B:160:0x0427, B:162:0x042e, B:163:0x043d), top: B:175:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0445 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0451  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0456  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0087 A[Catch: Error -> 0x01ef, Exception -> 0x01fd, TryCatch #0 {Exception -> 0x01fd, blocks: (B:7:0x000a, B:9:0x002a, B:11:0x0030, B:14:0x0053, B:17:0x005e, B:27:0x0079, B:29:0x0087, B:35:0x0099, B:37:0x00a5, B:46:0x00df, B:49:0x00ed, B:59:0x0117, B:60:0x011f, B:62:0x012d, B:65:0x014b, B:67:0x0170, B:69:0x0178, B:106:0x0253, B:89:0x01f3, B:86:0x01ea, B:110:0x0275, B:112:0x0281, B:114:0x028f, B:117:0x02a0, B:119:0x02a7, B:120:0x02b0, B:122:0x02c0, B:125:0x02e0, B:126:0x02f8, B:149:0x03a5, B:129:0x02fe, B:131:0x0319, B:135:0x0331, B:138:0x0352, B:140:0x0358, B:142:0x036b, B:143:0x0386, B:145:0x038c, B:147:0x0394, B:148:0x039d, B:150:0x03af, B:152:0x03be, B:154:0x03d7, B:155:0x03e0, B:157:0x0413, B:160:0x0427, B:162:0x042e, B:163:0x043d), top: B:175:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0099 A[Catch: Error -> 0x01ef, Exception -> 0x01fd, TryCatch #0 {Exception -> 0x01fd, blocks: (B:7:0x000a, B:9:0x002a, B:11:0x0030, B:14:0x0053, B:17:0x005e, B:27:0x0079, B:29:0x0087, B:35:0x0099, B:37:0x00a5, B:46:0x00df, B:49:0x00ed, B:59:0x0117, B:60:0x011f, B:62:0x012d, B:65:0x014b, B:67:0x0170, B:69:0x0178, B:106:0x0253, B:89:0x01f3, B:86:0x01ea, B:110:0x0275, B:112:0x0281, B:114:0x028f, B:117:0x02a0, B:119:0x02a7, B:120:0x02b0, B:122:0x02c0, B:125:0x02e0, B:126:0x02f8, B:149:0x03a5, B:129:0x02fe, B:131:0x0319, B:135:0x0331, B:138:0x0352, B:140:0x0358, B:142:0x036b, B:143:0x0386, B:145:0x038c, B:147:0x0394, B:148:0x039d, B:150:0x03af, B:152:0x03be, B:154:0x03d7, B:155:0x03e0, B:157:0x0413, B:160:0x0427, B:162:0x042e, B:163:0x043d), top: B:175:0x000a }] */
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
        StringBuffer stringBuffer;
        int i4;
        char c;
        boolean z6;
        int i5;
        long j2;
        long j3;
        char c2;
        if (a() < 1) {
            return null;
        }
        try {
            try {
                Random random = new Random();
                StringBuffer stringBuffer2 = new StringBuffer(512);
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
                long j4 = 0;
                long j5 = 0;
                boolean z7 = false;
                if (Build.VERSION.SDK_INT >= 17) {
                    try {
                        j4 = SystemClock.elapsedRealtimeNanos() / 1000;
                    } catch (Error e) {
                        j4 = 0;
                    }
                    if (j4 > 0) {
                        z7 = true;
                        j = j4;
                        boolean z8 = z7 ? z7 : z7 && z;
                        int i6 = 0;
                        int i7 = 0;
                        size = this.f1939a.size();
                        z3 = true;
                        if (size <= i) {
                            z4 = i < l.az;
                        } else {
                            i = size;
                            z4 = false;
                        }
                        StringBuffer stringBuffer3 = null;
                        i3 = 0;
                        int i8 = 0;
                        char c3 = 0;
                        while (i3 < i) {
                            int i9 = i8 + 1;
                            if (this.f1939a.get(i3) != null) {
                                if (this.f1939a.get(i3).level == 0) {
                                    stringBuffer = stringBuffer3;
                                    i4 = i7;
                                    c = c3;
                                    z6 = z3;
                                    i5 = i6;
                                    j2 = j5;
                                } else {
                                    if (z8) {
                                        try {
                                            j3 = (j - this.f1939a.get(i3).timestamp) / TimeUtils.NANOS_PER_MS;
                                        } catch (Exception e2) {
                                            j3 = 0;
                                        }
                                        arrayList.add(Long.valueOf(j3));
                                        if (j3 > j5) {
                                            j5 = j3;
                                        }
                                    }
                                    if (Build.VERSION.SDK_INT >= 23) {
                                        try {
                                            if (this.f1939a.get(i3).is80211mcResponder()) {
                                                if (stringBuffer3 == null) {
                                                    stringBuffer3 = new StringBuffer();
                                                }
                                                stringBuffer3.append(i3);
                                                stringBuffer3.append("|");
                                            }
                                        } catch (Throwable th) {
                                            th.printStackTrace();
                                        }
                                    }
                                    if (z3) {
                                        z3 = false;
                                        stringBuffer2.append("&wf=");
                                    } else {
                                        stringBuffer2.append("|");
                                    }
                                    String str3 = this.f1939a.get(i3).BSSID;
                                    if (str3 != null) {
                                        String replace2 = str3.replace(":", "");
                                        stringBuffer2.append(replace2);
                                        int i10 = this.f1939a.get(i3).level;
                                        if (i10 < 0) {
                                            i10 = -i10;
                                        }
                                        stringBuffer2.append(String.format(Locale.CHINA, ";%d;", Integer.valueOf(i10)));
                                        i6++;
                                        boolean z9 = false;
                                        if (str2 != null && str2.equals(replace2)) {
                                            this.e = a(this.f1939a.get(i3).capabilities);
                                            z9 = true;
                                            i7 = i6;
                                        }
                                        if (z9) {
                                            stringBuffer2.append(b(this.f1939a.get(i3).SSID));
                                        } else {
                                            if (c3 == 0) {
                                                try {
                                                    if (random.nextInt(10) == 2 && this.f1939a.get(i3).SSID != null && this.f1939a.get(i3).SSID.length() < 30) {
                                                        stringBuffer2.append(b(this.f1939a.get(i3).SSID));
                                                        c2 = 1;
                                                    }
                                                    c2 = c3;
                                                } catch (Exception e3) {
                                                    stringBuffer = stringBuffer3;
                                                    i4 = i7;
                                                    c = c3;
                                                    z6 = z3;
                                                    i5 = i6;
                                                    j2 = j5;
                                                }
                                            } else {
                                                if (c3 == 1 && random.nextInt(20) == 1 && this.f1939a.get(i3).SSID != null && this.f1939a.get(i3).SSID.length() < 30) {
                                                    stringBuffer2.append(b(this.f1939a.get(i3).SSID));
                                                    c2 = 2;
                                                }
                                                c2 = c3;
                                            }
                                            z6 = z3;
                                            i5 = i6;
                                            j2 = j5;
                                            StringBuffer stringBuffer4 = stringBuffer3;
                                            i4 = i7;
                                            c = c2;
                                            stringBuffer = stringBuffer4;
                                        }
                                    }
                                }
                                i3++;
                                j5 = j2;
                                i6 = i5;
                                z3 = z6;
                                c3 = c;
                                i7 = i4;
                                stringBuffer3 = stringBuffer;
                                i8 = i9;
                            }
                            stringBuffer = stringBuffer3;
                            i4 = i7;
                            c = c3;
                            z6 = z3;
                            i5 = i6;
                            j2 = j5;
                            i3++;
                            j5 = j2;
                            i6 = i5;
                            z3 = z6;
                            c3 = c;
                            i7 = i4;
                            stringBuffer3 = stringBuffer;
                            i8 = i9;
                        }
                        if (z4) {
                            boolean z10 = true;
                            while (i < this.f1939a.size()) {
                                int i11 = i8 + 1;
                                if (this.f1939a.get(i) != null && this.f1939a.get(i).level != 0) {
                                    if (z10) {
                                        z10 = false;
                                        stringBuffer2.append("&wf2=");
                                    } else {
                                        stringBuffer2.append("|");
                                    }
                                    String str4 = this.f1939a.get(i).BSSID;
                                    if (str4 != null) {
                                        stringBuffer2.append(str4.replace(":", ""));
                                        int i12 = this.f1939a.get(i).level;
                                        if (i12 < 0) {
                                            i12 = -i12;
                                        }
                                        stringBuffer2.append(String.format(Locale.CHINA, ";%d;", Integer.valueOf(i12)));
                                    }
                                    if (i11 >= l.az) {
                                        break;
                                    }
                                }
                                i++;
                                z10 = z10;
                                i8 = i11;
                            }
                        }
                        if (z3) {
                            stringBuffer2.append("&wf_n=" + i7);
                            if (stringBuffer3 != null) {
                                stringBuffer2.append("&wf_mc=");
                                stringBuffer2.append(stringBuffer3.toString());
                            }
                            if (str2 != null && i2 != -1) {
                                stringBuffer2.append("&wf_rs=" + i2);
                            }
                            if (j5 > 10 && arrayList.size() > 0 && ((Long) arrayList.get(0)).longValue() > 0) {
                                StringBuffer stringBuffer5 = new StringBuffer(128);
                                stringBuffer5.append("&wf_ut=");
                                boolean z11 = true;
                                Long l = (Long) arrayList.get(0);
                                for (Long l2 : arrayList) {
                                    if (z11) {
                                        stringBuffer5.append(l2.longValue());
                                        z5 = false;
                                    } else {
                                        long longValue = l2.longValue() - l.longValue();
                                        if (longValue != 0) {
                                            stringBuffer5.append("" + longValue);
                                        }
                                        z5 = z11;
                                    }
                                    stringBuffer5.append("|");
                                    z11 = z5;
                                }
                                stringBuffer2.append(stringBuffer5.toString());
                            }
                            stringBuffer2.append("&wf_st=");
                            stringBuffer2.append(this.b);
                            stringBuffer2.append("&wf_et=");
                            stringBuffer2.append(this.c);
                            stringBuffer2.append("&wf_vt=");
                            stringBuffer2.append(i.f1940a);
                            if (i7 > 0) {
                                this.d = true;
                                stringBuffer2.append("&wf_en=");
                                stringBuffer2.append(this.e ? 1 : 0);
                            }
                            if (str != null) {
                                stringBuffer2.append("&wf_gw=");
                                stringBuffer2.append(str);
                            }
                            return stringBuffer2.toString();
                        }
                        return null;
                    }
                }
                j = j4;
                if (z7) {
                }
                int i62 = 0;
                int i72 = 0;
                size = this.f1939a.size();
                z3 = true;
                if (size <= i) {
                }
                StringBuffer stringBuffer32 = null;
                i3 = 0;
                int i82 = 0;
                char c32 = 0;
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
                if (z || this.f1939a == null || this.f1939a.size() == 0) {
                    return false;
                }
                int size = this.f1939a.size();
                i = size <= 16 ? 16 : size;
                for (i2 = 0; i2 < i; i2++) {
                    if (this.f1939a.get(i2) != null && this.f1939a.get(i2).level != 0 && z) {
                        try {
                            j3 = (j2 - this.f1939a.get(i2).timestamp) / TimeUtils.NANOS_PER_MS;
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
        int size2 = this.f1939a.size();
        if (size2 <= 16) {
        }
        while (i2 < i) {
        }
        return 1000 * j5 <= j || (j6 / ((long) i)) * 1000 > j;
    }

    public boolean a(h hVar) {
        if (this.f1939a == null || hVar == null || hVar.f1939a == null) {
            return false;
        }
        int size = this.f1939a.size() < hVar.f1939a.size() ? this.f1939a.size() : hVar.f1939a.size();
        for (int i = 0; i < size; i++) {
            if (this.f1939a.get(i) != null) {
                String str = this.f1939a.get(i).BSSID;
                String str2 = hVar.f1939a.get(i).BSSID;
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
        int i3;
        int i4 = 1;
        int i5 = 0;
        if (i == 0 || a() < 1) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer(256);
        int size = this.f1939a.size();
        int i6 = size > l.O ? l.O : size;
        int i7 = 0;
        while (i7 < i6) {
            if (this.f1939a.get(i7) == null) {
                i3 = i4;
            } else {
                if ((i4 & i) == 0 || this.f1939a.get(i7).BSSID == null) {
                    i2 = i5;
                } else {
                    if (i5 == 0) {
                        stringBuffer.append("&ssid=");
                    } else {
                        stringBuffer.append("|");
                    }
                    stringBuffer.append(this.f1939a.get(i7).BSSID.replace(":", ""));
                    stringBuffer.append(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
                    stringBuffer.append(b(this.f1939a.get(i7).SSID));
                    i2 = i5 + 1;
                }
                int i8 = i2;
                i3 = i4 << 1;
                i5 = i8;
            }
            i7++;
            i4 = i3;
        }
        return stringBuffer.toString();
    }

    public boolean b(h hVar) {
        if (this.f1939a == null || hVar == null || hVar.f1939a == null) {
            return false;
        }
        int size = this.f1939a.size() < hVar.f1939a.size() ? this.f1939a.size() : hVar.f1939a.size();
        for (int i = 0; i < size; i++) {
            if (this.f1939a.get(i) != null) {
                String str = this.f1939a.get(i).BSSID;
                int i2 = this.f1939a.get(i).level;
                String str2 = hVar.f1939a.get(i).BSSID;
                int i3 = hVar.f1939a.get(i).level;
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
        long j2;
        boolean z;
        long j3;
        if (this.f1939a == null || this.f1939a.size() == 0) {
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
            if (j > 0) {
                j2 = j;
                z = true;
            } else {
                j2 = j;
                z = false;
            }
        } else {
            z = false;
            j2 = 0;
        }
        if (z) {
            int size = this.f1939a.size();
            if (size > 16) {
                size = 16;
            }
            long j4 = 2147483647L;
            for (int i = 0; i < size; i++) {
                if (this.f1939a.get(i) != null && this.f1939a.get(i).level != 0 && z) {
                    try {
                        j3 = (j2 - this.f1939a.get(i).timestamp) / TimeUtils.NANOS_PER_MS;
                    } catch (Error e3) {
                        j3 = 0;
                    } catch (Exception e4) {
                        j3 = 0;
                    }
                    if (j3 < j4) {
                        j4 = j3;
                    }
                }
            }
            long j5 = z ? j4 : 0L;
            if (j5 < 0) {
                j5 = 0;
            }
            return j5;
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
        long j;
        boolean z;
        long j2;
        if (this.f1939a == null || this.f1939a.size() == 0) {
            return 0L;
        }
        long j3 = 0;
        long j4 = 0;
        long j5 = 0;
        if (Build.VERSION.SDK_INT >= 17) {
            try {
                j3 = SystemClock.elapsedRealtimeNanos() / 1000;
            } catch (Error e) {
                j3 = 0;
            } catch (Exception e2) {
                j3 = 0;
            }
            if (j3 > 0) {
                j = j3;
                z = true;
                if (z) {
                    return 0L;
                }
                int size = this.f1939a.size();
                int i = size > 16 ? 16 : size;
                long j6 = 0;
                for (int i2 = 0; i2 < i; i2++) {
                    if (this.f1939a.get(i2) != null && this.f1939a.get(i2).level != 0 && z) {
                        try {
                            j2 = (j - this.f1939a.get(i2).timestamp) / TimeUtils.NANOS_PER_MS;
                        } catch (Error e3) {
                            j2 = 0;
                        } catch (Exception e4) {
                            j2 = 0;
                        }
                        j4 += j2;
                        j5++;
                        if (j2 > j6) {
                            j6 = j2;
                        }
                    }
                }
                return j5 > 1 ? (j4 - j6) / (j5 - 1) : j6;
            }
        }
        j = j3;
        z = false;
        if (z) {
        }
    }

    public int h() {
        int i;
        for (int i2 = 0; i2 < a(); i2++) {
            if (this.f1939a.get(i2) != null && (i = -this.f1939a.get(i2).level) > 0) {
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
        return System.currentTimeMillis() - this.c > 0 && System.currentTimeMillis() - this.b < 5000;
    }
}
