package com.baidu.location.b;

import android.annotation.SuppressLint;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import com.baidu.tbadk.core.util.FieldBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.regex.Pattern;
/* loaded from: classes2.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public List<ScanResult> f6909a;

    /* renamed from: b  reason: collision with root package name */
    public long f6910b;

    /* renamed from: c  reason: collision with root package name */
    public long f6911c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f6912d = false;

    /* renamed from: e  reason: collision with root package name */
    public boolean f6913e;

    public h(List<ScanResult> list, long j) {
        this.f6909a = null;
        this.f6910b = 0L;
        this.f6911c = 0L;
        this.f6910b = j;
        this.f6909a = list;
        this.f6911c = System.currentTimeMillis();
        m();
    }

    private boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return Pattern.compile("wpa|wep", 2).matcher(str).find();
    }

    private String b(String str) {
        return str != null ? (str.contains("&") || str.contains(";")) ? str.replace("&", "_").replace(";", "_") : str : str;
    }

    private int l() {
        List<ScanResult> list = this.f6909a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    /*  JADX ERROR: JadxOverflowException in pass: LoopRegionVisitor
        jadx.core.utils.exceptions.JadxOverflowException: LoopRegionVisitor.assignOnlyInLoop endless recursion
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:56)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:30)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:18)
        */
    private void m() {
        /*
            r7 = this;
            int r0 = r7.l()
            r1 = 1
            if (r0 >= r1) goto L8
            return
        L8:
            java.util.List<android.net.wifi.ScanResult> r0 = r7.f6909a
            int r0 = r0.size()
            int r0 = r0 - r1
            r2 = 1
        L10:
            if (r0 < r1) goto L4d
            if (r2 == 0) goto L4d
            r2 = 0
            r3 = 0
        L16:
            if (r2 >= r0) goto L49
            java.util.List<android.net.wifi.ScanResult> r4 = r7.f6909a
            java.lang.Object r4 = r4.get(r2)
            android.net.wifi.ScanResult r4 = (android.net.wifi.ScanResult) r4
            int r4 = r4.level
            java.util.List<android.net.wifi.ScanResult> r5 = r7.f6909a
            int r6 = r2 + 1
            java.lang.Object r5 = r5.get(r6)
            android.net.wifi.ScanResult r5 = (android.net.wifi.ScanResult) r5
            int r5 = r5.level
            if (r4 >= r5) goto L47
            java.util.List<android.net.wifi.ScanResult> r3 = r7.f6909a
            java.lang.Object r3 = r3.get(r6)
            android.net.wifi.ScanResult r3 = (android.net.wifi.ScanResult) r3
            java.util.List<android.net.wifi.ScanResult> r4 = r7.f6909a
            java.lang.Object r5 = r4.get(r2)
            r4.set(r6, r5)
            java.util.List<android.net.wifi.ScanResult> r4 = r7.f6909a
            r4.set(r2, r3)
            r3 = 1
        L47:
            r2 = r6
            goto L16
        L49:
            int r0 = r0 + (-1)
            r2 = r3
            goto L10
        L4d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.b.h.m():void");
    }

    public int a() {
        List<ScanResult> list = this.f6909a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public String a(int i2) {
        return a(i2, false, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x021c A[Catch: Exception -> 0x005c, Error -> 0x0315, TryCatch #2 {Exception -> 0x005c, blocks: (B:17:0x0053, B:31:0x0075, B:38:0x0091, B:99:0x020d, B:48:0x00c3, B:53:0x00d7, B:55:0x00de, B:61:0x0117, B:63:0x0123, B:66:0x0137, B:68:0x0154, B:70:0x015c, B:96:0x01f1, B:57:0x00fc, B:60:0x0103, B:102:0x021c, B:106:0x0237, B:109:0x0251, B:111:0x0257, B:113:0x0268, B:114:0x0280, B:116:0x0286, B:118:0x028e, B:122:0x02ba, B:119:0x0299, B:121:0x02a8, B:123:0x02be, B:125:0x02c7, B:127:0x02e7, B:131:0x02f6, B:133:0x02fb, B:135:0x0307, B:136:0x030e), top: B:149:0x0053 }] */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0313 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0091 A[Catch: Exception -> 0x005c, Error -> 0x0315, TRY_ENTER, TRY_LEAVE, TryCatch #2 {Exception -> 0x005c, blocks: (B:17:0x0053, B:31:0x0075, B:38:0x0091, B:99:0x020d, B:48:0x00c3, B:53:0x00d7, B:55:0x00de, B:61:0x0117, B:63:0x0123, B:66:0x0137, B:68:0x0154, B:70:0x015c, B:96:0x01f1, B:57:0x00fc, B:60:0x0103, B:102:0x021c, B:106:0x0237, B:109:0x0251, B:111:0x0257, B:113:0x0268, B:114:0x0280, B:116:0x0286, B:118:0x028e, B:122:0x02ba, B:119:0x0299, B:121:0x02a8, B:123:0x02be, B:125:0x02c7, B:127:0x02e7, B:131:0x02f6, B:133:0x02fb, B:135:0x0307, B:136:0x030e), top: B:149:0x0053 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00d7 A[Catch: Exception -> 0x005c, Error -> 0x0315, TryCatch #2 {Exception -> 0x005c, blocks: (B:17:0x0053, B:31:0x0075, B:38:0x0091, B:99:0x020d, B:48:0x00c3, B:53:0x00d7, B:55:0x00de, B:61:0x0117, B:63:0x0123, B:66:0x0137, B:68:0x0154, B:70:0x015c, B:96:0x01f1, B:57:0x00fc, B:60:0x0103, B:102:0x021c, B:106:0x0237, B:109:0x0251, B:111:0x0257, B:113:0x0268, B:114:0x0280, B:116:0x0286, B:118:0x028e, B:122:0x02ba, B:119:0x0299, B:121:0x02a8, B:123:0x02be, B:125:0x02c7, B:127:0x02e7, B:131:0x02f6, B:133:0x02fb, B:135:0x0307, B:136:0x030e), top: B:149:0x0053 }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00fc A[Catch: Exception -> 0x005c, Error -> 0x0315, TryCatch #2 {Exception -> 0x005c, blocks: (B:17:0x0053, B:31:0x0075, B:38:0x0091, B:99:0x020d, B:48:0x00c3, B:53:0x00d7, B:55:0x00de, B:61:0x0117, B:63:0x0123, B:66:0x0137, B:68:0x0154, B:70:0x015c, B:96:0x01f1, B:57:0x00fc, B:60:0x0103, B:102:0x021c, B:106:0x0237, B:109:0x0251, B:111:0x0257, B:113:0x0268, B:114:0x0280, B:116:0x0286, B:118:0x028e, B:122:0x02ba, B:119:0x0299, B:121:0x02a8, B:123:0x02be, B:125:0x02c7, B:127:0x02e7, B:131:0x02f6, B:133:0x02fb, B:135:0x0307, B:136:0x030e), top: B:149:0x0053 }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0123 A[Catch: Exception -> 0x005c, Error -> 0x0315, TryCatch #2 {Exception -> 0x005c, blocks: (B:17:0x0053, B:31:0x0075, B:38:0x0091, B:99:0x020d, B:48:0x00c3, B:53:0x00d7, B:55:0x00de, B:61:0x0117, B:63:0x0123, B:66:0x0137, B:68:0x0154, B:70:0x015c, B:96:0x01f1, B:57:0x00fc, B:60:0x0103, B:102:0x021c, B:106:0x0237, B:109:0x0251, B:111:0x0257, B:113:0x0268, B:114:0x0280, B:116:0x0286, B:118:0x028e, B:122:0x02ba, B:119:0x0299, B:121:0x02a8, B:123:0x02be, B:125:0x02c7, B:127:0x02e7, B:131:0x02f6, B:133:0x02fb, B:135:0x0307, B:136:0x030e), top: B:149:0x0053 }] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0205  */
    @SuppressLint({"NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String a(int i2, boolean z, boolean z2) {
        String str;
        String str2;
        int i3;
        long j;
        boolean z3;
        int size;
        int i4;
        boolean z4;
        String str3;
        String str4;
        long j2;
        String str5;
        String str6;
        long j3;
        boolean z5;
        char c2;
        if (a() < 1) {
            return null;
        }
        try {
            Random random = new Random();
            StringBuffer stringBuffer = new StringBuffer(512);
            ArrayList<Long> arrayList = new ArrayList();
            WifiInfo k = i.a().k();
            String str7 = ":";
            if (k == null || k.getBSSID() == null) {
                str = null;
                str2 = null;
                i3 = -1;
            } else {
                str = k.getBSSID().replace(":", "");
                i3 = k.getRssi();
                str2 = i.a().m();
                if (i3 < 0) {
                    i3 = -i3;
                }
            }
            try {
                if (Build.VERSION.SDK_INT >= 17) {
                    try {
                        try {
                            j = SystemClock.elapsedRealtimeNanos() / 1000;
                        } catch (Error unused) {
                            j = 0;
                        }
                        if (j > 0) {
                            z3 = true;
                            if (z3) {
                                z3 = z3 && z;
                            }
                            size = this.f6909a.size();
                            if (size > i2) {
                                size = i2;
                            }
                            i4 = 0;
                            StringBuffer stringBuffer2 = null;
                            long j4 = 0;
                            z4 = true;
                            int i5 = 0;
                            int i6 = 0;
                            char c3 = 0;
                            while (i4 < size) {
                                if (this.f6909a.get(i4).level == 0) {
                                    str6 = str7;
                                    str4 = str2;
                                    j3 = j;
                                } else {
                                    if (z3) {
                                        try {
                                            str3 = str;
                                            str4 = str2;
                                        } catch (Exception unused2) {
                                            str3 = str;
                                            str4 = str2;
                                        }
                                        try {
                                            j2 = (j - this.f6909a.get(i4).timestamp) / 1000000;
                                        } catch (Exception unused3) {
                                            j2 = 0;
                                            arrayList.add(Long.valueOf(j2));
                                            if (j2 > j4) {
                                            }
                                            if (z4) {
                                            }
                                            str5 = this.f6909a.get(i4).BSSID;
                                            if (str5 == null) {
                                            }
                                            i4++;
                                            str2 = str4;
                                            str7 = str6;
                                            j = j3;
                                        }
                                        arrayList.add(Long.valueOf(j2));
                                        if (j2 > j4) {
                                            j4 = j2;
                                        }
                                    } else {
                                        str3 = str;
                                        str4 = str2;
                                    }
                                    if (z4) {
                                        stringBuffer.append(FieldBuilder.SE);
                                        if (z2 && stringBuffer2 != null) {
                                            stringBuffer2.append(FieldBuilder.SE);
                                            stringBuffer2.append(b(this.f6909a.get(i4).frequency));
                                        }
                                    } else {
                                        stringBuffer.append("&wf=");
                                        if (z2) {
                                            stringBuffer2 = new StringBuffer();
                                            stringBuffer2.append("&wf_ch=");
                                            stringBuffer2.append(b(this.f6909a.get(i4).frequency));
                                        }
                                        z4 = false;
                                    }
                                    str5 = this.f6909a.get(i4).BSSID;
                                    if (str5 == null) {
                                        String replace = str5.replace(str7, "");
                                        stringBuffer.append(replace);
                                        int i7 = this.f6909a.get(i4).level;
                                        if (i7 < 0) {
                                            i7 = -i7;
                                        }
                                        str6 = str7;
                                        j3 = j;
                                        stringBuffer.append(String.format(Locale.CHINA, ";%d;", Integer.valueOf(i7)));
                                        i6++;
                                        if (str3 != null) {
                                            str = str3;
                                            if (str.equals(replace)) {
                                                this.f6913e = a(this.f6909a.get(i4).capabilities);
                                                i5 = i6;
                                                z5 = true;
                                                if (z5) {
                                                    c2 = c3;
                                                    if (c2 == 0) {
                                                        try {
                                                            if (random.nextInt(10) == 2 && this.f6909a.get(i4).SSID != null && this.f6909a.get(i4).SSID.length() < 30) {
                                                                stringBuffer.append(b(this.f6909a.get(i4).SSID));
                                                                c3 = 1;
                                                            }
                                                        } catch (Exception unused4) {
                                                        }
                                                    } else if (c2 == 1 && random.nextInt(20) == 1 && this.f6909a.get(i4).SSID != null && this.f6909a.get(i4).SSID.length() < 30) {
                                                        stringBuffer.append(b(this.f6909a.get(i4).SSID));
                                                        c3 = 2;
                                                    }
                                                } else {
                                                    c2 = c3;
                                                    stringBuffer.append(b(this.f6909a.get(i4).SSID));
                                                }
                                                c3 = c2;
                                            }
                                        } else {
                                            str = str3;
                                        }
                                        z5 = false;
                                        if (z5) {
                                        }
                                        c3 = c2;
                                    } else {
                                        str6 = str7;
                                        j3 = j;
                                        str = str3;
                                    }
                                }
                                i4++;
                                str2 = str4;
                                str7 = str6;
                                j = j3;
                            }
                            String str8 = str2;
                            if (z4) {
                                StringBuilder sb = new StringBuilder();
                                sb.append("&wf_n=");
                                int i8 = i5;
                                sb.append(i8);
                                stringBuffer.append(sb.toString());
                                if (str != null && i3 != -1) {
                                    stringBuffer.append("&wf_rs=" + i3);
                                }
                                if (j4 > 10 && arrayList.size() > 0 && ((Long) arrayList.get(0)).longValue() > 0) {
                                    StringBuffer stringBuffer3 = new StringBuffer(128);
                                    stringBuffer3.append("&wf_ut=");
                                    Long l = (Long) arrayList.get(0);
                                    boolean z6 = true;
                                    for (Long l2 : arrayList) {
                                        if (z6) {
                                            stringBuffer3.append(l2.longValue());
                                            z6 = false;
                                        } else {
                                            long longValue = l2.longValue() - l.longValue();
                                            if (longValue != 0) {
                                                stringBuffer3.append("" + longValue);
                                            }
                                        }
                                        stringBuffer3.append(FieldBuilder.SE);
                                    }
                                    stringBuffer.append(stringBuffer3.toString());
                                }
                                stringBuffer.append("&wf_st=");
                                stringBuffer.append(this.f6910b);
                                stringBuffer.append("&wf_et=");
                                stringBuffer.append(this.f6911c);
                                stringBuffer.append("&wf_vt=");
                                stringBuffer.append(i.f6914a);
                                if (i8 > 0) {
                                    this.f6912d = true;
                                    stringBuffer.append("&wf_en=");
                                    stringBuffer.append(this.f6913e ? 1 : 0);
                                }
                                if (str8 != null) {
                                    stringBuffer.append("&wf_gw=");
                                    stringBuffer.append(str8);
                                }
                                if (stringBuffer2 != null) {
                                    stringBuffer.append(stringBuffer2.toString());
                                }
                                return stringBuffer.toString();
                            }
                            return null;
                        }
                    } catch (Exception unused5) {
                        return null;
                    }
                } else {
                    j = 0;
                }
                size = this.f6909a.size();
                if (size > i2) {
                }
                i4 = 0;
                StringBuffer stringBuffer22 = null;
                long j42 = 0;
                z4 = true;
                int i52 = 0;
                int i62 = 0;
                char c32 = 0;
                while (i4 < size) {
                }
                String str82 = str2;
                if (z4) {
                }
            } catch (Error unused6) {
                return null;
            }
            z3 = false;
            if (z3) {
            }
        } catch (Error unused7) {
            return null;
        } catch (Exception unused8) {
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x003b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(long j) {
        long j2;
        boolean z;
        List<ScanResult> list;
        int size;
        int i2;
        long j3;
        if (Build.VERSION.SDK_INT >= 17) {
            try {
                j2 = SystemClock.elapsedRealtimeNanos() / 1000;
            } catch (Error | Exception unused) {
                j2 = 0;
            }
            if (j2 > 0) {
                z = true;
                if (z || (list = this.f6909a) == null || list.size() == 0) {
                    return false;
                }
                size = this.f6909a.size();
                if (size > 16) {
                    size = 16;
                }
                long j4 = 0;
                long j5 = 0;
                for (i2 = 0; i2 < size; i2++) {
                    if (this.f6909a.get(i2).level != 0 && z) {
                        try {
                            j3 = (j2 - this.f6909a.get(i2).timestamp) / 1000000;
                        } catch (Error | Exception unused2) {
                            j3 = 0;
                        }
                        j4 += j3;
                        if (j3 > j5) {
                            j5 = j3;
                        }
                    }
                }
                return j5 * 1000 <= j || (j4 / ((long) size)) * 1000 > j;
            }
        } else {
            j2 = 0;
        }
        z = false;
        if (z) {
            return false;
        }
        size = this.f6909a.size();
        if (size > 16) {
        }
        long j42 = 0;
        long j52 = 0;
        while (i2 < size) {
        }
        if (j52 * 1000 <= j) {
        }
    }

    public boolean a(h hVar) {
        List<ScanResult> list = this.f6909a;
        if (list == null || hVar == null || hVar.f6909a == null) {
            return false;
        }
        int size = (list.size() < hVar.f6909a.size() ? this.f6909a : hVar.f6909a).size();
        for (int i2 = 0; i2 < size; i2++) {
            if (!this.f6909a.get(i2).BSSID.equals(hVar.f6909a.get(i2).BSSID)) {
                return false;
            }
        }
        return true;
    }

    public int b(int i2) {
        if (i2 <= 2400 || i2 >= 2500) {
            return (i2 <= 4900 || i2 >= 5900) ? 0 : 5;
        }
        return 2;
    }

    public String b() {
        try {
            return a(com.baidu.location.d.j.O, true, true);
        } catch (Exception unused) {
            return null;
        }
    }

    public boolean b(h hVar) {
        List<ScanResult> list = this.f6909a;
        if (list == null || hVar == null || hVar.f6909a == null) {
            return false;
        }
        int size = (list.size() < hVar.f6909a.size() ? this.f6909a : hVar.f6909a).size();
        for (int i2 = 0; i2 < size; i2++) {
            String str = this.f6909a.get(i2).BSSID;
            int i3 = this.f6909a.get(i2).level;
            String str2 = hVar.f6909a.get(i2).BSSID;
            int i4 = hVar.f6909a.get(i2).level;
            if (!str.equals(str2) || i3 != i4) {
                return false;
            }
        }
        return true;
    }

    public String c() {
        try {
            return a(com.baidu.location.d.j.O, true, false);
        } catch (Exception unused) {
            return null;
        }
    }

    public String c(int i2) {
        if (i2 != 0) {
            int i3 = 1;
            if (a() < 1) {
                return null;
            }
            StringBuffer stringBuffer = new StringBuffer(256);
            int size = this.f6909a.size();
            int i4 = com.baidu.location.d.j.O;
            if (size > i4) {
                size = i4;
            }
            int i5 = 0;
            for (int i6 = 0; i6 < size; i6++) {
                if ((i3 & i2) != 0 && this.f6909a.get(i6).BSSID != null) {
                    stringBuffer.append(i5 == 0 ? "&ssid=" : FieldBuilder.SE);
                    stringBuffer.append(this.f6909a.get(i6).BSSID.replace(":", ""));
                    stringBuffer.append(";");
                    stringBuffer.append(b(this.f6909a.get(i6).SSID));
                    i5++;
                }
                i3 <<= 1;
            }
            return stringBuffer.toString();
        }
        return null;
    }

    public boolean c(h hVar) {
        return i.a(hVar, this);
    }

    public String d() {
        try {
            return a(15);
        } catch (Exception unused) {
            return null;
        }
    }

    public boolean e() {
        return a(com.baidu.location.d.j.af);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:49:? A[RETURN, SYNTHETIC] */
    @SuppressLint({"NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long f() {
        long j;
        boolean z;
        int size;
        long j2;
        List<ScanResult> list = this.f6909a;
        if (list == null || list.size() == 0) {
            return 0L;
        }
        if (Build.VERSION.SDK_INT >= 17) {
            try {
                j = SystemClock.elapsedRealtimeNanos() / 1000;
            } catch (Error | Exception unused) {
                j = 0;
            }
            if (j > 0) {
                z = true;
                size = this.f6909a.size();
                if (size > 16) {
                    size = 16;
                }
                long j3 = 0;
                long j4 = 0;
                long j5 = 0;
                for (int i2 = 0; i2 < size; i2++) {
                    if (this.f6909a.get(i2).level != 0 && z) {
                        try {
                            j2 = (j - this.f6909a.get(i2).timestamp) / 1000000;
                        } catch (Error | Exception unused2) {
                            j2 = 0;
                        }
                        j5 += j2;
                        j3++;
                        if (j2 > j4) {
                            j4 = j2;
                        }
                    }
                }
                return j3 <= 1 ? (j5 - j4) / (j3 - 1) : j4;
            }
        } else {
            j = 0;
        }
        z = false;
        size = this.f6909a.size();
        if (size > 16) {
        }
        long j32 = 0;
        long j42 = 0;
        long j52 = 0;
        while (i2 < size) {
        }
        if (j32 <= 1) {
        }
    }

    public int g() {
        for (int i2 = 0; i2 < a(); i2++) {
            int i3 = -this.f6909a.get(i2).level;
            if (i3 > 0) {
                return i3;
            }
        }
        return 0;
    }

    public boolean h() {
        return this.f6912d;
    }

    public boolean i() {
        return System.currentTimeMillis() - this.f6911c > 0 && System.currentTimeMillis() - this.f6911c < 5000;
    }

    public boolean j() {
        return System.currentTimeMillis() - this.f6911c > 0 && System.currentTimeMillis() - this.f6911c < 5000;
    }

    public boolean k() {
        return System.currentTimeMillis() - this.f6911c > 0 && System.currentTimeMillis() - this.f6910b < 5000;
    }
}
