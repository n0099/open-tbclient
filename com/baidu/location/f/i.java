package com.baidu.location.f;

import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.tbadk.TbConfig;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class i {
    public List<ScanResult> a;
    private long b;
    private long c;
    private boolean d = false;
    private boolean e;

    public i(List<ScanResult> list, long j) {
        this.a = null;
        this.b = 0L;
        this.c = 0L;
        this.b = j;
        this.a = list;
        this.c = System.currentTimeMillis();
        i();
    }

    private boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return Pattern.compile("wpa|wep", 2).matcher(str).find();
    }

    private void i() {
        boolean z;
        if (a() < 1) {
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
        return o(i, false);
    }

    public boolean a(i iVar) {
        if (this.a == null || iVar == null || iVar.a == null) {
            return false;
        }
        int size = this.a.size() < iVar.a.size() ? this.a.size() : iVar.a.size();
        for (int i = 0; i < size; i++) {
            if (!this.a.get(i).BSSID.equals(iVar.a.get(i).BSSID)) {
                return false;
            }
        }
        return true;
    }

    public String b() {
        try {
            return o(com.baidu.location.h.i.L, true);
        } catch (Exception e) {
            return null;
        }
    }

    public String b(int i) {
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

    public boolean b(i iVar) {
        if (this.a == null || iVar == null || iVar.a == null) {
            return false;
        }
        int size = this.a.size() < iVar.a.size() ? this.a.size() : iVar.a.size();
        for (int i = 0; i < size; i++) {
            String str = this.a.get(i).BSSID;
            int i2 = this.a.get(i).level;
            String str2 = iVar.a.get(i).BSSID;
            int i3 = iVar.a.get(i).level;
            if (!str.equals(str2) || i2 != i3) {
                return false;
            }
        }
        return true;
    }

    public String c() {
        try {
            return a(15);
        } catch (Exception e) {
            return null;
        }
    }

    public String c(int i) {
        int i2;
        int i3 = 0;
        if (i == 0 || a() < 1) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer(256);
        int size = this.a.size();
        int i4 = size > com.baidu.location.h.i.L ? com.baidu.location.h.i.L : size;
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
                stringBuffer.append(this.a.get(i6).SSID);
                i2 = i3 + 1;
            }
            i5 <<= 1;
            i6++;
            i3 = i2;
        }
        return stringBuffer.toString();
    }

    public boolean c(i iVar) {
        return j.a(iVar, this, com.baidu.location.h.i.aDm);
    }

    public int d() {
        for (int i = 0; i < a(); i++) {
            int i2 = -this.a.get(i).level;
            if (i2 > 0) {
                return i2;
            }
        }
        return 0;
    }

    public boolean e() {
        return this.d;
    }

    public boolean f() {
        return System.currentTimeMillis() - this.c < TbConfig.NOTIFY_SOUND_INTERVAL;
    }

    public boolean g() {
        return System.currentTimeMillis() - this.c < TbConfig.NOTIFY_SOUND_INTERVAL;
    }

    public boolean h() {
        return System.currentTimeMillis() - this.b < TbConfig.NOTIFY_SOUND_INTERVAL;
    }

    /* JADX WARN: Removed duplicated region for block: B:120:0x0308 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:125:0x031c  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0320  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x007f A[Catch: Error -> 0x019b, Exception -> 0x030b, TRY_LEAVE, TryCatch #2 {Exception -> 0x030b, blocks: (B:7:0x000a, B:9:0x0029, B:11:0x002f, B:14:0x0048, B:17:0x0053, B:27:0x006c, B:32:0x007f, B:41:0x00bc, B:45:0x00cc, B:46:0x00d5, B:48:0x00e3, B:51:0x0101, B:53:0x0125, B:55:0x012d, B:70:0x0191, B:88:0x01ef, B:92:0x020f, B:95:0x0230, B:97:0x0236, B:99:0x0249, B:100:0x0264, B:102:0x026a, B:104:0x0272, B:105:0x027b, B:106:0x0283, B:108:0x0292, B:110:0x02ab, B:111:0x02b4, B:113:0x02e7, B:116:0x02fb, B:117:0x0300), top: B:134:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01ef A[Catch: Error -> 0x019b, Exception -> 0x030b, TRY_ENTER, TryCatch #2 {Exception -> 0x030b, blocks: (B:7:0x000a, B:9:0x0029, B:11:0x002f, B:14:0x0048, B:17:0x0053, B:27:0x006c, B:32:0x007f, B:41:0x00bc, B:45:0x00cc, B:46:0x00d5, B:48:0x00e3, B:51:0x0101, B:53:0x0125, B:55:0x012d, B:70:0x0191, B:88:0x01ef, B:92:0x020f, B:95:0x0230, B:97:0x0236, B:99:0x0249, B:100:0x0264, B:102:0x026a, B:104:0x0272, B:105:0x027b, B:106:0x0283, B:108:0x0292, B:110:0x02ab, B:111:0x02b4, B:113:0x02e7, B:116:0x02fb, B:117:0x0300), top: B:134:0x000a }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String o(int i, boolean z) {
        int i2;
        String str;
        long j;
        int size;
        boolean z2;
        int i3;
        boolean z3;
        long j2;
        boolean z4;
        int i4;
        long j3;
        char c;
        int i5;
        char c2;
        if (a() < 1) {
            return null;
        }
        char c3 = 0;
        try {
            try {
                Random random = new Random();
                StringBuffer stringBuffer = new StringBuffer(512);
                ArrayList<Long> arrayList = new ArrayList();
                WifiInfo uv = k.uz().uv();
                if (uv == null || uv.getBSSID() == null) {
                    i2 = -1;
                    str = null;
                } else {
                    String replace = uv.getBSSID().replace(":", "");
                    int rssi = uv.getRssi();
                    if (rssi < 0) {
                        i2 = -rssi;
                        str = replace;
                    } else {
                        i2 = rssi;
                        str = replace;
                    }
                }
                long j4 = 0;
                long j5 = 0;
                boolean z5 = false;
                if (Build.VERSION.SDK_INT >= 17) {
                    try {
                        j4 = SystemClock.elapsedRealtimeNanos() / 1000;
                    } catch (Error e) {
                        j4 = 0;
                    }
                    if (j4 > 0) {
                        z5 = true;
                        j = j4;
                        boolean z6 = z5 ? z5 : z5 && z;
                        int i6 = 0;
                        int i7 = 0;
                        size = this.a.size();
                        z2 = true;
                        if (size <= i) {
                            i = size;
                        }
                        i3 = 0;
                        while (i3 < i) {
                            if (this.a.get(i3).level == 0) {
                                z4 = z2;
                                i4 = i6;
                                j3 = j5;
                                int i8 = i7;
                                c = c3;
                                i5 = i8;
                            } else {
                                if (z6) {
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
                                if (z2) {
                                    z2 = false;
                                    stringBuffer.append("&wf=");
                                } else {
                                    stringBuffer.append("|");
                                }
                                String str2 = this.a.get(i3).BSSID;
                                if (str2 != null) {
                                    String replace2 = str2.replace(":", "");
                                    stringBuffer.append(replace2);
                                    int i9 = this.a.get(i3).level;
                                    if (i9 < 0) {
                                        i9 = -i9;
                                    }
                                    stringBuffer.append(String.format(Locale.CHINA, ";%d;", Integer.valueOf(i9)));
                                    int i10 = i6 + 1;
                                    if (str != null && str.equals(replace2)) {
                                        this.e = a(this.a.get(i3).capabilities);
                                        i7 = i10;
                                    }
                                    if (c3 == 0) {
                                        try {
                                            if (random.nextInt(10) == 2 && this.a.get(i3).SSID != null && this.a.get(i3).SSID.length() < 30) {
                                                stringBuffer.append(this.a.get(i3).SSID);
                                                c2 = 1;
                                            }
                                            c2 = c3;
                                        } catch (Exception e3) {
                                            z4 = z2;
                                            i4 = i10;
                                            j3 = j5;
                                            int i11 = i7;
                                            c = c3;
                                            i5 = i11;
                                        }
                                    } else {
                                        if (c3 == 1 && random.nextInt(20) == 1 && this.a.get(i3).SSID != null && this.a.get(i3).SSID.length() < 30) {
                                            stringBuffer.append(this.a.get(i3).SSID);
                                            c2 = 2;
                                        }
                                        c2 = c3;
                                    }
                                    i5 = i7;
                                    c = c2;
                                    z4 = z2;
                                    i4 = i10;
                                    j3 = j5;
                                } else {
                                    z4 = z2;
                                    i4 = i6;
                                    j3 = j5;
                                    int i12 = i7;
                                    c = c3;
                                    i5 = i12;
                                }
                            }
                            i3++;
                            j5 = j3;
                            i6 = i4;
                            z2 = z4;
                            int i13 = i5;
                            c3 = c;
                            i7 = i13;
                        }
                        if (z2) {
                            stringBuffer.append("&wf_n=" + i7);
                            if (str != null && i2 != -1) {
                                stringBuffer.append("&wf_rs=" + i2);
                            }
                            if (j5 > 10 && arrayList.size() > 0 && ((Long) arrayList.get(0)).longValue() > 0) {
                                StringBuffer stringBuffer2 = new StringBuffer(128);
                                stringBuffer2.append("&wf_ut=");
                                boolean z7 = true;
                                Long l = (Long) arrayList.get(0);
                                for (Long l2 : arrayList) {
                                    if (z7) {
                                        stringBuffer2.append(l2.longValue());
                                        z3 = false;
                                    } else {
                                        long longValue = l2.longValue() - l.longValue();
                                        if (longValue != 0) {
                                            stringBuffer2.append("" + longValue);
                                        }
                                        z3 = z7;
                                    }
                                    stringBuffer2.append("|");
                                    z7 = z3;
                                }
                                stringBuffer.append(stringBuffer2.toString());
                            }
                            stringBuffer.append("&wf_st=");
                            stringBuffer.append(this.b);
                            stringBuffer.append("&wf_et=");
                            stringBuffer.append(this.c);
                            stringBuffer.append("&wf_vt=");
                            stringBuffer.append(j.a);
                            if (i7 > 0) {
                                this.d = true;
                                stringBuffer.append("&wf_en=");
                                stringBuffer.append(this.e ? 1 : 0);
                            }
                            return stringBuffer.toString();
                        }
                        return null;
                    }
                }
                j = j4;
                if (z5) {
                }
                int i62 = 0;
                int i72 = 0;
                size = this.a.size();
                z2 = true;
                if (size <= i) {
                }
                i3 = 0;
                while (i3 < i) {
                }
                if (z2) {
                }
            } catch (Exception e4) {
                return null;
            }
        } catch (Error e5) {
            return null;
        }
    }
}
