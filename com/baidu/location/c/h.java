package com.baidu.location.c;

import android.annotation.SuppressLint;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import com.baidu.location.e.k;
import com.baidu.tbadk.core.util.FieldBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.regex.Pattern;
/* loaded from: classes2.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public List<ScanResult> f6737a;

    /* renamed from: b  reason: collision with root package name */
    public long f6738b;

    /* renamed from: c  reason: collision with root package name */
    public long f6739c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f6740d = false;

    /* renamed from: e  reason: collision with root package name */
    public boolean f6741e;

    public h(List<ScanResult> list, long j) {
        this.f6737a = null;
        this.f6738b = 0L;
        this.f6739c = 0L;
        this.f6738b = j;
        this.f6737a = list;
        this.f6739c = System.currentTimeMillis();
        try {
            n();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
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

    private int m() {
        List<ScanResult> list = this.f6737a;
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
    private void n() {
        /*
            r7 = this;
            int r0 = r7.m()
            r1 = 1
            if (r0 >= r1) goto L8
            return
        L8:
            java.util.List<android.net.wifi.ScanResult> r0 = r7.f6737a
            int r0 = r0.size()
            int r0 = r0 - r1
            r2 = 1
        L10:
            if (r0 < r1) goto L5e
            if (r2 == 0) goto L5e
            r2 = 0
            r3 = 0
        L16:
            if (r2 >= r0) goto L5a
            java.util.List<android.net.wifi.ScanResult> r4 = r7.f6737a
            java.lang.Object r4 = r4.get(r2)
            if (r4 == 0) goto L57
            java.util.List<android.net.wifi.ScanResult> r4 = r7.f6737a
            int r5 = r2 + 1
            java.lang.Object r4 = r4.get(r5)
            if (r4 == 0) goto L57
            java.util.List<android.net.wifi.ScanResult> r4 = r7.f6737a
            java.lang.Object r4 = r4.get(r2)
            android.net.wifi.ScanResult r4 = (android.net.wifi.ScanResult) r4
            int r4 = r4.level
            java.util.List<android.net.wifi.ScanResult> r6 = r7.f6737a
            java.lang.Object r6 = r6.get(r5)
            android.net.wifi.ScanResult r6 = (android.net.wifi.ScanResult) r6
            int r6 = r6.level
            if (r4 >= r6) goto L57
            java.util.List<android.net.wifi.ScanResult> r3 = r7.f6737a
            java.lang.Object r3 = r3.get(r5)
            android.net.wifi.ScanResult r3 = (android.net.wifi.ScanResult) r3
            java.util.List<android.net.wifi.ScanResult> r4 = r7.f6737a
            java.lang.Object r6 = r4.get(r2)
            r4.set(r5, r6)
            java.util.List<android.net.wifi.ScanResult> r4 = r7.f6737a
            r4.set(r2, r3)
            r3 = 1
        L57:
            int r2 = r2 + 1
            goto L16
        L5a:
            int r0 = r0 + (-1)
            r2 = r3
            goto L10
        L5e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.c.h.n():void");
    }

    public int a() {
        List<ScanResult> list = this.f6737a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public String a(int i2) {
        return a(i2, false, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x01f1  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0213 A[Catch: Exception -> 0x005c, Error -> 0x0311, TryCatch #1 {Error -> 0x0311, blocks: (B:31:0x0075, B:38:0x0091, B:40:0x0099, B:44:0x00a9, B:46:0x00b5, B:50:0x00c5, B:54:0x00d7, B:56:0x00dd, B:59:0x00ed, B:60:0x00f2, B:62:0x00fa, B:64:0x0105, B:66:0x0111, B:69:0x0125, B:71:0x0142, B:73:0x014a, B:81:0x016c, B:83:0x0172, B:85:0x017e, B:87:0x018e, B:103:0x0204, B:90:0x01a5, B:92:0x01ad, B:94:0x01b9, B:96:0x01c9, B:99:0x01df, B:63:0x0102, B:106:0x0213, B:108:0x022b, B:112:0x023c, B:115:0x0256, B:117:0x025c, B:119:0x026d, B:120:0x0285, B:122:0x028b, B:124:0x0293, B:128:0x02bf, B:125:0x029e, B:127:0x02ad, B:129:0x02c3, B:131:0x02cc, B:133:0x02ec, B:137:0x02fb, B:139:0x0300, B:140:0x030a), top: B:153:0x0075 }] */
    /* JADX WARN: Removed duplicated region for block: B:142:0x030f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0091 A[Catch: Exception -> 0x005c, Error -> 0x0311, TRY_ENTER, TryCatch #1 {Error -> 0x0311, blocks: (B:31:0x0075, B:38:0x0091, B:40:0x0099, B:44:0x00a9, B:46:0x00b5, B:50:0x00c5, B:54:0x00d7, B:56:0x00dd, B:59:0x00ed, B:60:0x00f2, B:62:0x00fa, B:64:0x0105, B:66:0x0111, B:69:0x0125, B:71:0x0142, B:73:0x014a, B:81:0x016c, B:83:0x0172, B:85:0x017e, B:87:0x018e, B:103:0x0204, B:90:0x01a5, B:92:0x01ad, B:94:0x01b9, B:96:0x01c9, B:99:0x01df, B:63:0x0102, B:106:0x0213, B:108:0x022b, B:112:0x023c, B:115:0x0256, B:117:0x025c, B:119:0x026d, B:120:0x0285, B:122:0x028b, B:124:0x0293, B:128:0x02bf, B:125:0x029e, B:127:0x02ad, B:129:0x02c3, B:131:0x02cc, B:133:0x02ec, B:137:0x02fb, B:139:0x0300, B:140:0x030a), top: B:153:0x0075 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00ed A[Catch: Exception -> 0x005c, Error -> 0x0311, TryCatch #1 {Error -> 0x0311, blocks: (B:31:0x0075, B:38:0x0091, B:40:0x0099, B:44:0x00a9, B:46:0x00b5, B:50:0x00c5, B:54:0x00d7, B:56:0x00dd, B:59:0x00ed, B:60:0x00f2, B:62:0x00fa, B:64:0x0105, B:66:0x0111, B:69:0x0125, B:71:0x0142, B:73:0x014a, B:81:0x016c, B:83:0x0172, B:85:0x017e, B:87:0x018e, B:103:0x0204, B:90:0x01a5, B:92:0x01ad, B:94:0x01b9, B:96:0x01c9, B:99:0x01df, B:63:0x0102, B:106:0x0213, B:108:0x022b, B:112:0x023c, B:115:0x0256, B:117:0x025c, B:119:0x026d, B:120:0x0285, B:122:0x028b, B:124:0x0293, B:128:0x02bf, B:125:0x029e, B:127:0x02ad, B:129:0x02c3, B:131:0x02cc, B:133:0x02ec, B:137:0x02fb, B:139:0x0300, B:140:0x030a), top: B:153:0x0075 }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00fa A[Catch: Exception -> 0x005c, Error -> 0x0311, TryCatch #1 {Error -> 0x0311, blocks: (B:31:0x0075, B:38:0x0091, B:40:0x0099, B:44:0x00a9, B:46:0x00b5, B:50:0x00c5, B:54:0x00d7, B:56:0x00dd, B:59:0x00ed, B:60:0x00f2, B:62:0x00fa, B:64:0x0105, B:66:0x0111, B:69:0x0125, B:71:0x0142, B:73:0x014a, B:81:0x016c, B:83:0x0172, B:85:0x017e, B:87:0x018e, B:103:0x0204, B:90:0x01a5, B:92:0x01ad, B:94:0x01b9, B:96:0x01c9, B:99:0x01df, B:63:0x0102, B:106:0x0213, B:108:0x022b, B:112:0x023c, B:115:0x0256, B:117:0x025c, B:119:0x026d, B:120:0x0285, B:122:0x028b, B:124:0x0293, B:128:0x02bf, B:125:0x029e, B:127:0x02ad, B:129:0x02c3, B:131:0x02cc, B:133:0x02ec, B:137:0x02fb, B:139:0x0300, B:140:0x030a), top: B:153:0x0075 }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0102 A[Catch: Exception -> 0x005c, Error -> 0x0311, TryCatch #1 {Error -> 0x0311, blocks: (B:31:0x0075, B:38:0x0091, B:40:0x0099, B:44:0x00a9, B:46:0x00b5, B:50:0x00c5, B:54:0x00d7, B:56:0x00dd, B:59:0x00ed, B:60:0x00f2, B:62:0x00fa, B:64:0x0105, B:66:0x0111, B:69:0x0125, B:71:0x0142, B:73:0x014a, B:81:0x016c, B:83:0x0172, B:85:0x017e, B:87:0x018e, B:103:0x0204, B:90:0x01a5, B:92:0x01ad, B:94:0x01b9, B:96:0x01c9, B:99:0x01df, B:63:0x0102, B:106:0x0213, B:108:0x022b, B:112:0x023c, B:115:0x0256, B:117:0x025c, B:119:0x026d, B:120:0x0285, B:122:0x028b, B:124:0x0293, B:128:0x02bf, B:125:0x029e, B:127:0x02ad, B:129:0x02c3, B:131:0x02cc, B:133:0x02ec, B:137:0x02fb, B:139:0x0300, B:140:0x030a), top: B:153:0x0075 }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0111 A[Catch: Exception -> 0x005c, Error -> 0x0311, TryCatch #1 {Error -> 0x0311, blocks: (B:31:0x0075, B:38:0x0091, B:40:0x0099, B:44:0x00a9, B:46:0x00b5, B:50:0x00c5, B:54:0x00d7, B:56:0x00dd, B:59:0x00ed, B:60:0x00f2, B:62:0x00fa, B:64:0x0105, B:66:0x0111, B:69:0x0125, B:71:0x0142, B:73:0x014a, B:81:0x016c, B:83:0x0172, B:85:0x017e, B:87:0x018e, B:103:0x0204, B:90:0x01a5, B:92:0x01ad, B:94:0x01b9, B:96:0x01c9, B:99:0x01df, B:63:0x0102, B:106:0x0213, B:108:0x022b, B:112:0x023c, B:115:0x0256, B:117:0x025c, B:119:0x026d, B:120:0x0285, B:122:0x028b, B:124:0x0293, B:128:0x02bf, B:125:0x029e, B:127:0x02ad, B:129:0x02c3, B:131:0x02cc, B:133:0x02ec, B:137:0x02fb, B:139:0x0300, B:140:0x030a), top: B:153:0x0075 }] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01dd  */
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
        char c2;
        String str5;
        long j3;
        String str6;
        boolean z5;
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
                            size = this.f6737a.size();
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
                                if (this.f6737a.get(i4) == null || this.f6737a.get(i4).level == 0) {
                                    str3 = str7;
                                    str4 = str2;
                                    j2 = j;
                                    c2 = c3;
                                } else {
                                    if (z3) {
                                        try {
                                            str5 = str;
                                            str4 = str2;
                                        } catch (Exception unused2) {
                                            str5 = str;
                                            str4 = str2;
                                        }
                                        try {
                                            j3 = (j - this.f6737a.get(i4).timestamp) / 1000000;
                                        } catch (Exception unused3) {
                                            j3 = 0;
                                            arrayList.add(Long.valueOf(j3));
                                            if (j3 > j4) {
                                            }
                                            if (Build.VERSION.SDK_INT >= 23) {
                                                if (stringBuffer2 == null) {
                                                }
                                                stringBuffer2.append(i4);
                                                stringBuffer2.append(FieldBuilder.SE);
                                            }
                                            if (z4) {
                                            }
                                            str6 = this.f6737a.get(i4).BSSID;
                                            if (str6 == null) {
                                            }
                                            i4++;
                                            str2 = str4;
                                            str7 = str3;
                                            j = j2;
                                        }
                                        arrayList.add(Long.valueOf(j3));
                                        if (j3 > j4) {
                                            j4 = j3;
                                        }
                                    } else {
                                        str5 = str;
                                        str4 = str2;
                                    }
                                    if (Build.VERSION.SDK_INT >= 23 && this.f6737a.get(i4).is80211mcResponder()) {
                                        if (stringBuffer2 == null) {
                                            stringBuffer2 = new StringBuffer();
                                        }
                                        stringBuffer2.append(i4);
                                        stringBuffer2.append(FieldBuilder.SE);
                                    }
                                    if (z4) {
                                        stringBuffer.append(FieldBuilder.SE);
                                    } else {
                                        stringBuffer.append("&wf=");
                                        z4 = false;
                                    }
                                    str6 = this.f6737a.get(i4).BSSID;
                                    if (str6 == null) {
                                        String replace = str6.replace(str7, "");
                                        stringBuffer.append(replace);
                                        int i7 = this.f6737a.get(i4).level;
                                        if (i7 < 0) {
                                            i7 = -i7;
                                        }
                                        str3 = str7;
                                        j2 = j;
                                        stringBuffer.append(String.format(Locale.CHINA, ";%d;", Integer.valueOf(i7)));
                                        i6++;
                                        if (str5 != null) {
                                            str = str5;
                                            if (str.equals(replace)) {
                                                this.f6741e = a(this.f6737a.get(i4).capabilities);
                                                i5 = i6;
                                                z5 = true;
                                                if (z5) {
                                                    c2 = c3;
                                                    if (c2 == 0) {
                                                        try {
                                                            if (random.nextInt(10) == 2 && this.f6737a.get(i4).SSID != null && this.f6737a.get(i4).SSID.length() < 30) {
                                                                stringBuffer.append(b(this.f6737a.get(i4).SSID));
                                                                c3 = 1;
                                                            }
                                                        } catch (Exception unused4) {
                                                        }
                                                    } else if (c2 == 1 && random.nextInt(20) == 1 && this.f6737a.get(i4).SSID != null && this.f6737a.get(i4).SSID.length() < 30) {
                                                        stringBuffer.append(b(this.f6737a.get(i4).SSID));
                                                        c3 = 2;
                                                    }
                                                } else {
                                                    c2 = c3;
                                                    stringBuffer.append(b(this.f6737a.get(i4).SSID));
                                                }
                                            }
                                        } else {
                                            str = str5;
                                        }
                                        z5 = false;
                                        if (z5) {
                                        }
                                    } else {
                                        str3 = str7;
                                        j2 = j;
                                        str = str5;
                                    }
                                    i4++;
                                    str2 = str4;
                                    str7 = str3;
                                    j = j2;
                                }
                                c3 = c2;
                                i4++;
                                str2 = str4;
                                str7 = str3;
                                j = j2;
                            }
                            String str8 = str2;
                            if (z4) {
                                StringBuilder sb = new StringBuilder();
                                sb.append("&wf_n=");
                                int i8 = i5;
                                sb.append(i8);
                                stringBuffer.append(sb.toString());
                                if (stringBuffer2 != null) {
                                    stringBuffer.append("&wf_mc=");
                                    stringBuffer.append(stringBuffer2.toString());
                                }
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
                                stringBuffer.append(this.f6738b);
                                stringBuffer.append("&wf_et=");
                                stringBuffer.append(this.f6739c);
                                stringBuffer.append("&wf_vt=");
                                stringBuffer.append(i.f6742a);
                                if (i8 > 0) {
                                    this.f6740d = true;
                                    stringBuffer.append("&wf_en=");
                                    stringBuffer.append(this.f6741e ? 1 : 0);
                                }
                                if (str8 != null) {
                                    stringBuffer.append("&wf_gw=");
                                    stringBuffer.append(str8);
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
                size = this.f6737a.size();
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
                if (z || (list = this.f6737a) == null || list.size() == 0) {
                    return false;
                }
                size = this.f6737a.size();
                if (size > 16) {
                    size = 16;
                }
                long j4 = 0;
                long j5 = 0;
                for (i2 = 0; i2 < size; i2++) {
                    if (this.f6737a.get(i2) != null && this.f6737a.get(i2).level != 0 && z) {
                        try {
                            j3 = (j2 - this.f6737a.get(i2).timestamp) / 1000000;
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
        size = this.f6737a.size();
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
        List<ScanResult> list = this.f6737a;
        if (list == null || hVar == null || hVar.f6737a == null) {
            return false;
        }
        int size = (list.size() < hVar.f6737a.size() ? this.f6737a : hVar.f6737a).size();
        for (int i2 = 0; i2 < size; i2++) {
            if (this.f6737a.get(i2) != null && !this.f6737a.get(i2).BSSID.equals(hVar.f6737a.get(i2).BSSID)) {
                return false;
            }
        }
        return true;
    }

    public String b() {
        try {
            return a(k.O, true, true);
        } catch (Exception unused) {
            return null;
        }
    }

    public String b(int i2) {
        if (i2 != 0) {
            int i3 = 1;
            if (a() < 1) {
                return null;
            }
            StringBuffer stringBuffer = new StringBuffer(256);
            int size = this.f6737a.size();
            int i4 = k.O;
            if (size > i4) {
                size = i4;
            }
            int i5 = 0;
            for (int i6 = 0; i6 < size; i6++) {
                if (this.f6737a.get(i6) != null) {
                    if ((i3 & i2) != 0 && this.f6737a.get(i6).BSSID != null) {
                        stringBuffer.append(i5 == 0 ? "&ssid=" : FieldBuilder.SE);
                        stringBuffer.append(this.f6737a.get(i6).BSSID.replace(":", ""));
                        stringBuffer.append(";");
                        stringBuffer.append(b(this.f6737a.get(i6).SSID));
                        i5++;
                    }
                    i3 <<= 1;
                }
            }
            return stringBuffer.toString();
        }
        return null;
    }

    public boolean b(h hVar) {
        List<ScanResult> list = this.f6737a;
        if (list == null || hVar == null || hVar.f6737a == null) {
            return false;
        }
        int size = (list.size() < hVar.f6737a.size() ? this.f6737a : hVar.f6737a).size();
        for (int i2 = 0; i2 < size; i2++) {
            if (this.f6737a.get(i2) != null) {
                String str = this.f6737a.get(i2).BSSID;
                int i3 = this.f6737a.get(i2).level;
                String str2 = hVar.f6737a.get(i2).BSSID;
                int i4 = hVar.f6737a.get(i2).level;
                if (!str.equals(str2) || i3 != i4) {
                    return false;
                }
            }
        }
        return true;
    }

    public String c() {
        try {
            return a(k.O, true, false);
        } catch (Exception unused) {
            return null;
        }
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
        return a(k.ag);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x002b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x002c  */
    @SuppressLint({"NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long f() {
        long j;
        boolean z;
        long j2;
        List<ScanResult> list = this.f6737a;
        if (list == null || list.size() == 0) {
            return 0L;
        }
        long j3 = 2147483647L;
        if (Build.VERSION.SDK_INT >= 17) {
            try {
                j = SystemClock.elapsedRealtimeNanos() / 1000;
            } catch (Error | Exception unused) {
                j = 0;
            }
            if (j > 0) {
                z = true;
                if (z) {
                    return 0L;
                }
                int size = this.f6737a.size();
                if (size > 16) {
                    size = 16;
                }
                for (int i2 = 0; i2 < size; i2++) {
                    if (this.f6737a.get(i2) != null && this.f6737a.get(i2).level != 0 && z) {
                        try {
                            j2 = (j - this.f6737a.get(i2).timestamp) / 1000000;
                        } catch (Error | Exception unused2) {
                            j2 = 0;
                        }
                        if (j2 < j3) {
                            j3 = j2;
                        }
                    }
                }
                if (!z) {
                    j3 = 0;
                }
                if (j3 < 0) {
                    return 0L;
                }
                return j3;
            }
        } else {
            j = 0;
        }
        z = false;
        if (z) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x002a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x002b  */
    @SuppressLint({"NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long g() {
        long j;
        boolean z;
        long j2;
        List<ScanResult> list = this.f6737a;
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
                if (z) {
                    return 0L;
                }
                int size = this.f6737a.size();
                if (size > 16) {
                    size = 16;
                }
                long j3 = 0;
                long j4 = 0;
                long j5 = 0;
                for (int i2 = 0; i2 < size; i2++) {
                    if (this.f6737a.get(i2) != null && this.f6737a.get(i2).level != 0 && z) {
                        try {
                            j2 = (j - this.f6737a.get(i2).timestamp) / 1000000;
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
                return j3 > 1 ? (j5 - j4) / (j3 - 1) : j4;
            }
        } else {
            j = 0;
        }
        z = false;
        if (z) {
        }
    }

    public int h() {
        int i2;
        for (int i3 = 0; i3 < a(); i3++) {
            if (this.f6737a.get(i3) != null && (i2 = -this.f6737a.get(i3).level) > 0) {
                return i2;
            }
        }
        return 0;
    }

    public boolean i() {
        return this.f6740d;
    }

    public boolean j() {
        return System.currentTimeMillis() - this.f6739c > 0 && System.currentTimeMillis() - this.f6739c < 5000;
    }

    public boolean k() {
        return System.currentTimeMillis() - this.f6739c > 0 && System.currentTimeMillis() - this.f6739c < 5000;
    }

    public boolean l() {
        return System.currentTimeMillis() - this.f6739c > 0 && System.currentTimeMillis() - this.f6738b < 5000;
    }
}
