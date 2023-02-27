package com.baidu.location.c;

import android.annotation.SuppressLint;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.defs.obj.ParamableElem;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.regex.Pattern;
/* loaded from: classes2.dex */
public class j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<ScanResult> a;
    public long b;
    public long c;
    public boolean d;
    public boolean e;

    public j(List<ScanResult> list, long j) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list, Long.valueOf(j)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
        this.b = 0L;
        this.c = 0L;
        this.d = false;
        this.b = j;
        this.a = list;
        this.c = System.currentTimeMillis();
        try {
            n();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return Pattern.compile("wpa|wep", 2).matcher(str).find();
        }
        return invokeL.booleanValue;
    }

    private String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, this, str)) == null) ? str != null ? (str.contains("&") || str.contains(ParamableElem.DIVIDE_PARAM)) ? str.replace("&", "_").replace(ParamableElem.DIVIDE_PARAM, "_") : str : str : (String) invokeL.objValue;
    }

    private int m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            List<ScanResult> list = this.a;
            if (list == null) {
                return 0;
            }
            return list.size();
        }
        return invokeV.intValue;
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
            com.baidu.titan.sdk.runtime.Interceptable r0 = com.baidu.location.c.j.$ic
            if (r0 != 0) goto L63
        L4:
            int r0 = r7.m()
            r1 = 1
            if (r0 >= r1) goto Lc
            return
        Lc:
            java.util.List<android.net.wifi.ScanResult> r0 = r7.a
            int r0 = r0.size()
            int r0 = r0 - r1
            r2 = 1
        L14:
            if (r0 < r1) goto L62
            if (r2 == 0) goto L62
            r2 = 0
            r3 = 0
        L1a:
            if (r2 >= r0) goto L5e
            java.util.List<android.net.wifi.ScanResult> r4 = r7.a
            java.lang.Object r4 = r4.get(r2)
            if (r4 == 0) goto L5b
            java.util.List<android.net.wifi.ScanResult> r4 = r7.a
            int r5 = r2 + 1
            java.lang.Object r4 = r4.get(r5)
            if (r4 == 0) goto L5b
            java.util.List<android.net.wifi.ScanResult> r4 = r7.a
            java.lang.Object r4 = r4.get(r2)
            android.net.wifi.ScanResult r4 = (android.net.wifi.ScanResult) r4
            int r4 = r4.level
            java.util.List<android.net.wifi.ScanResult> r6 = r7.a
            java.lang.Object r6 = r6.get(r5)
            android.net.wifi.ScanResult r6 = (android.net.wifi.ScanResult) r6
            int r6 = r6.level
            if (r4 >= r6) goto L5b
            java.util.List<android.net.wifi.ScanResult> r3 = r7.a
            java.lang.Object r3 = r3.get(r5)
            android.net.wifi.ScanResult r3 = (android.net.wifi.ScanResult) r3
            java.util.List<android.net.wifi.ScanResult> r4 = r7.a
            java.lang.Object r6 = r4.get(r2)
            r4.set(r5, r6)
            java.util.List<android.net.wifi.ScanResult> r4 = r7.a
            r4.set(r2, r3)
            r3 = 1
        L5b:
            int r2 = r2 + 1
            goto L1a
        L5e:
            int r0 = r0 + (-1)
            r2 = r3
            goto L14
        L62:
            return
        L63:
            r5 = r0
            r6 = 65540(0x10004, float:9.1841E-41)
            com.baidu.titan.sdk.runtime.InterceptResult r0 = r5.invokeV(r6, r7)
            if (r0 == 0) goto L4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.c.j.n():void");
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            List<ScanResult> list = this.a;
            if (list == null) {
                return 0;
            }
            return list.size();
        }
        return invokeV.intValue;
    }

    public String a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) ? a(i, false, false) : (String) invokeI.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:112:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0210  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x022e  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0297 A[Catch: Exception -> 0x0062, Error -> 0x0395, TryCatch #7 {Error -> 0x0395, blocks: (B:33:0x007b, B:35:0x0083, B:44:0x00a5, B:46:0x00ad, B:50:0x00bd, B:52:0x00c9, B:56:0x00d9, B:60:0x00eb, B:74:0x0118, B:76:0x011d, B:78:0x0128, B:80:0x0134, B:83:0x0148, B:85:0x0161, B:87:0x0169, B:95:0x018b, B:97:0x0191, B:99:0x019d, B:101:0x01ad, B:117:0x021f, B:104:0x01c4, B:106:0x01cc, B:108:0x01d8, B:110:0x01e8, B:113:0x01fe, B:77:0x0125, B:121:0x022f, B:123:0x0237, B:125:0x0241, B:129:0x0250, B:131:0x025a, B:133:0x0266, B:136:0x027a, B:137:0x028d, B:130:0x0257, B:140:0x0292, B:142:0x0297, B:144:0x02af, B:148:0x02c0, B:151:0x02da, B:153:0x02e0, B:155:0x02f1, B:156:0x0309, B:158:0x030f, B:160:0x0317, B:164:0x0343, B:161:0x0322, B:163:0x0331, B:165:0x0347, B:167:0x0350, B:169:0x0370, B:173:0x037f, B:175:0x0384, B:176:0x038e), top: B:201:0x007b }] */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0393 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:195:0x00f1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0083 A[Catch: Exception -> 0x0062, Error -> 0x0395, TRY_LEAVE, TryCatch #7 {Error -> 0x0395, blocks: (B:33:0x007b, B:35:0x0083, B:44:0x00a5, B:46:0x00ad, B:50:0x00bd, B:52:0x00c9, B:56:0x00d9, B:60:0x00eb, B:74:0x0118, B:76:0x011d, B:78:0x0128, B:80:0x0134, B:83:0x0148, B:85:0x0161, B:87:0x0169, B:95:0x018b, B:97:0x0191, B:99:0x019d, B:101:0x01ad, B:117:0x021f, B:104:0x01c4, B:106:0x01cc, B:108:0x01d8, B:110:0x01e8, B:113:0x01fe, B:77:0x0125, B:121:0x022f, B:123:0x0237, B:125:0x0241, B:129:0x0250, B:131:0x025a, B:133:0x0266, B:136:0x027a, B:137:0x028d, B:130:0x0257, B:140:0x0292, B:142:0x0297, B:144:0x02af, B:148:0x02c0, B:151:0x02da, B:153:0x02e0, B:155:0x02f1, B:156:0x0309, B:158:0x030f, B:160:0x0317, B:164:0x0343, B:161:0x0322, B:163:0x0331, B:165:0x0347, B:167:0x0350, B:169:0x0370, B:173:0x037f, B:175:0x0384, B:176:0x038e), top: B:201:0x007b }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x011d A[Catch: Exception -> 0x0062, Error -> 0x0395, TryCatch #7 {Error -> 0x0395, blocks: (B:33:0x007b, B:35:0x0083, B:44:0x00a5, B:46:0x00ad, B:50:0x00bd, B:52:0x00c9, B:56:0x00d9, B:60:0x00eb, B:74:0x0118, B:76:0x011d, B:78:0x0128, B:80:0x0134, B:83:0x0148, B:85:0x0161, B:87:0x0169, B:95:0x018b, B:97:0x0191, B:99:0x019d, B:101:0x01ad, B:117:0x021f, B:104:0x01c4, B:106:0x01cc, B:108:0x01d8, B:110:0x01e8, B:113:0x01fe, B:77:0x0125, B:121:0x022f, B:123:0x0237, B:125:0x0241, B:129:0x0250, B:131:0x025a, B:133:0x0266, B:136:0x027a, B:137:0x028d, B:130:0x0257, B:140:0x0292, B:142:0x0297, B:144:0x02af, B:148:0x02c0, B:151:0x02da, B:153:0x02e0, B:155:0x02f1, B:156:0x0309, B:158:0x030f, B:160:0x0317, B:164:0x0343, B:161:0x0322, B:163:0x0331, B:165:0x0347, B:167:0x0350, B:169:0x0370, B:173:0x037f, B:175:0x0384, B:176:0x038e), top: B:201:0x007b }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0125 A[Catch: Exception -> 0x0062, Error -> 0x0395, TryCatch #7 {Error -> 0x0395, blocks: (B:33:0x007b, B:35:0x0083, B:44:0x00a5, B:46:0x00ad, B:50:0x00bd, B:52:0x00c9, B:56:0x00d9, B:60:0x00eb, B:74:0x0118, B:76:0x011d, B:78:0x0128, B:80:0x0134, B:83:0x0148, B:85:0x0161, B:87:0x0169, B:95:0x018b, B:97:0x0191, B:99:0x019d, B:101:0x01ad, B:117:0x021f, B:104:0x01c4, B:106:0x01cc, B:108:0x01d8, B:110:0x01e8, B:113:0x01fe, B:77:0x0125, B:121:0x022f, B:123:0x0237, B:125:0x0241, B:129:0x0250, B:131:0x025a, B:133:0x0266, B:136:0x027a, B:137:0x028d, B:130:0x0257, B:140:0x0292, B:142:0x0297, B:144:0x02af, B:148:0x02c0, B:151:0x02da, B:153:0x02e0, B:155:0x02f1, B:156:0x0309, B:158:0x030f, B:160:0x0317, B:164:0x0343, B:161:0x0322, B:163:0x0331, B:165:0x0347, B:167:0x0350, B:169:0x0370, B:173:0x037f, B:175:0x0384, B:176:0x038e), top: B:201:0x007b }] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0134 A[Catch: Exception -> 0x0062, Error -> 0x0395, TryCatch #7 {Error -> 0x0395, blocks: (B:33:0x007b, B:35:0x0083, B:44:0x00a5, B:46:0x00ad, B:50:0x00bd, B:52:0x00c9, B:56:0x00d9, B:60:0x00eb, B:74:0x0118, B:76:0x011d, B:78:0x0128, B:80:0x0134, B:83:0x0148, B:85:0x0161, B:87:0x0169, B:95:0x018b, B:97:0x0191, B:99:0x019d, B:101:0x01ad, B:117:0x021f, B:104:0x01c4, B:106:0x01cc, B:108:0x01d8, B:110:0x01e8, B:113:0x01fe, B:77:0x0125, B:121:0x022f, B:123:0x0237, B:125:0x0241, B:129:0x0250, B:131:0x025a, B:133:0x0266, B:136:0x027a, B:137:0x028d, B:130:0x0257, B:140:0x0292, B:142:0x0297, B:144:0x02af, B:148:0x02c0, B:151:0x02da, B:153:0x02e0, B:155:0x02f1, B:156:0x0309, B:158:0x030f, B:160:0x0317, B:164:0x0343, B:161:0x0322, B:163:0x0331, B:165:0x0347, B:167:0x0350, B:169:0x0370, B:173:0x037f, B:175:0x0384, B:176:0x038e), top: B:201:0x007b }] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0182  */
    @SuppressLint({"NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String a(int i, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        String str;
        String str2;
        int i2;
        long j;
        boolean z3;
        int size;
        boolean z4;
        int i3;
        boolean z5;
        String str3;
        long j2;
        char c;
        String str4;
        long j3;
        String str5;
        boolean z6;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2)})) != null) {
            return (String) invokeCommon.objValue;
        }
        if (a() < 1) {
            return null;
        }
        try {
            Random random = new Random();
            StringBuffer stringBuffer = new StringBuffer(512);
            ArrayList<Long> arrayList = new ArrayList();
            WifiInfo k = k.a().k();
            if (k == null || k.getBSSID() == null) {
                str = null;
                str2 = null;
                i2 = -1;
            } else {
                str = k.getBSSID().replace(":", "");
                i2 = k.getRssi();
                str2 = k.a().m();
                if (i2 < 0) {
                    i2 = -i2;
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
                            size = this.a.size();
                            if (size > i) {
                                if (i < com.baidu.location.e.k.ay) {
                                    size = i;
                                    z4 = true;
                                    int i4 = 0;
                                    i3 = 0;
                                    StringBuffer stringBuffer2 = null;
                                    long j4 = 0;
                                    z5 = true;
                                    int i5 = 0;
                                    int i6 = 0;
                                    char c2 = 0;
                                    while (i3 < size) {
                                        int i7 = i4 + 1;
                                        if (this.a.get(i3) == null || this.a.get(i3).level == 0) {
                                            str3 = str2;
                                            j2 = j;
                                            c = c2;
                                        } else {
                                            if (z3) {
                                                try {
                                                    str4 = str;
                                                    str3 = str2;
                                                    try {
                                                        j3 = (j - this.a.get(i3).timestamp) / 1000000;
                                                    } catch (Exception unused2) {
                                                        j3 = 0;
                                                        arrayList.add(Long.valueOf(j3));
                                                        if (j3 > j4) {
                                                        }
                                                        if (Build.VERSION.SDK_INT >= 23) {
                                                        }
                                                        if (z5) {
                                                        }
                                                        str5 = this.a.get(i3).BSSID;
                                                        if (str5 != null) {
                                                        }
                                                        i3++;
                                                        i4 = i7;
                                                        str2 = str3;
                                                        j = j2;
                                                    }
                                                } catch (Exception unused3) {
                                                    str4 = str;
                                                    str3 = str2;
                                                }
                                                arrayList.add(Long.valueOf(j3));
                                                if (j3 > j4) {
                                                    j4 = j3;
                                                }
                                            } else {
                                                str4 = str;
                                                str3 = str2;
                                            }
                                            if (Build.VERSION.SDK_INT >= 23) {
                                                try {
                                                    if (this.a.get(i3).is80211mcResponder()) {
                                                        StringBuffer stringBuffer3 = stringBuffer2 == null ? new StringBuffer() : stringBuffer2;
                                                        try {
                                                            stringBuffer3.append(i3);
                                                            stringBuffer3.append("|");
                                                            stringBuffer2 = stringBuffer3;
                                                        } catch (Throwable th) {
                                                            th = th;
                                                            stringBuffer2 = stringBuffer3;
                                                            th.printStackTrace();
                                                            if (z5) {
                                                            }
                                                            str5 = this.a.get(i3).BSSID;
                                                            if (str5 != null) {
                                                            }
                                                            i3++;
                                                            i4 = i7;
                                                            str2 = str3;
                                                            j = j2;
                                                        }
                                                    }
                                                } catch (Throwable th2) {
                                                    th = th2;
                                                }
                                            }
                                            if (z5) {
                                                stringBuffer.append("&wf=");
                                                z5 = false;
                                            } else {
                                                stringBuffer.append("|");
                                            }
                                            str5 = this.a.get(i3).BSSID;
                                            if (str5 != null) {
                                                String replace = str5.replace(":", "");
                                                stringBuffer.append(replace);
                                                int i8 = this.a.get(i3).level;
                                                if (i8 < 0) {
                                                    i8 = -i8;
                                                }
                                                j2 = j;
                                                stringBuffer.append(String.format(Locale.CHINA, ";%d;", Integer.valueOf(i8)));
                                                i6++;
                                                if (str4 != null) {
                                                    str = str4;
                                                    if (str.equals(replace)) {
                                                        this.e = a(this.a.get(i3).capabilities);
                                                        i5 = i6;
                                                        z6 = true;
                                                        if (z6) {
                                                            c = c2;
                                                            if (c == 0) {
                                                                try {
                                                                    if (random.nextInt(10) == 2 && this.a.get(i3).SSID != null && this.a.get(i3).SSID.length() < 30) {
                                                                        stringBuffer.append(b(this.a.get(i3).SSID));
                                                                        c2 = 1;
                                                                    }
                                                                } catch (Exception unused4) {
                                                                }
                                                            } else if (c == 1 && random.nextInt(20) == 1 && this.a.get(i3).SSID != null && this.a.get(i3).SSID.length() < 30) {
                                                                stringBuffer.append(b(this.a.get(i3).SSID));
                                                                c2 = 2;
                                                            }
                                                        } else {
                                                            c = c2;
                                                            stringBuffer.append(b(this.a.get(i3).SSID));
                                                        }
                                                    }
                                                } else {
                                                    str = str4;
                                                }
                                                z6 = false;
                                                if (z6) {
                                                }
                                            } else {
                                                j2 = j;
                                                str = str4;
                                            }
                                            i3++;
                                            i4 = i7;
                                            str2 = str3;
                                            j = j2;
                                        }
                                        c2 = c;
                                        i3++;
                                        i4 = i7;
                                        str2 = str3;
                                        j = j2;
                                    }
                                    String str6 = str2;
                                    if (z4) {
                                        boolean z7 = true;
                                        while (size < this.a.size()) {
                                            i4++;
                                            if (this.a.get(size) != null && this.a.get(size).level != 0) {
                                                if (z7) {
                                                    stringBuffer.append("&wf2=");
                                                    z7 = false;
                                                } else {
                                                    stringBuffer.append("|");
                                                }
                                                String str7 = this.a.get(size).BSSID;
                                                if (str7 != null) {
                                                    stringBuffer.append(str7.replace(":", ""));
                                                    int i9 = this.a.get(size).level;
                                                    if (i9 < 0) {
                                                        i9 = -i9;
                                                    }
                                                    stringBuffer.append(String.format(Locale.CHINA, ";%d;", Integer.valueOf(i9)));
                                                }
                                                if (i4 >= com.baidu.location.e.k.ay) {
                                                    break;
                                                }
                                            }
                                            size++;
                                        }
                                    }
                                    if (z5) {
                                        return null;
                                    }
                                    StringBuilder sb = new StringBuilder();
                                    sb.append("&wf_n=");
                                    int i10 = i5;
                                    sb.append(i10);
                                    stringBuffer.append(sb.toString());
                                    if (stringBuffer2 != null) {
                                        stringBuffer.append("&wf_mc=");
                                        stringBuffer.append(stringBuffer2.toString());
                                    }
                                    if (str != null && i2 != -1) {
                                        stringBuffer.append("&wf_rs=" + i2);
                                    }
                                    if (j4 > 10 && arrayList.size() > 0 && ((Long) arrayList.get(0)).longValue() > 0) {
                                        StringBuffer stringBuffer4 = new StringBuffer(128);
                                        stringBuffer4.append("&wf_ut=");
                                        Long l = (Long) arrayList.get(0);
                                        boolean z8 = true;
                                        for (Long l2 : arrayList) {
                                            if (z8) {
                                                stringBuffer4.append(l2.longValue());
                                                z8 = false;
                                            } else {
                                                long longValue = l2.longValue() - l.longValue();
                                                if (longValue != 0) {
                                                    stringBuffer4.append("" + longValue);
                                                }
                                            }
                                            stringBuffer4.append("|");
                                        }
                                        stringBuffer.append(stringBuffer4.toString());
                                    }
                                    stringBuffer.append("&wf_st=");
                                    stringBuffer.append(this.b);
                                    stringBuffer.append("&wf_et=");
                                    stringBuffer.append(this.c);
                                    stringBuffer.append("&wf_vt=");
                                    stringBuffer.append(k.a);
                                    if (i10 > 0) {
                                        this.d = true;
                                        stringBuffer.append("&wf_en=");
                                        stringBuffer.append(this.e ? 1 : 0);
                                    }
                                    if (str6 != null) {
                                        stringBuffer.append("&wf_gw=");
                                        stringBuffer.append(str6);
                                    }
                                    return stringBuffer.toString();
                                }
                                size = i;
                            }
                            z4 = false;
                            int i42 = 0;
                            i3 = 0;
                            StringBuffer stringBuffer22 = null;
                            long j42 = 0;
                            z5 = true;
                            int i52 = 0;
                            int i62 = 0;
                            char c22 = 0;
                            while (i3 < size) {
                            }
                            String str62 = str2;
                            if (z4) {
                            }
                            if (z5) {
                            }
                        }
                    } catch (Exception unused5) {
                        return null;
                    }
                } else {
                    j = 0;
                }
                size = this.a.size();
                if (size > i) {
                }
                z4 = false;
                int i422 = 0;
                i3 = 0;
                StringBuffer stringBuffer222 = null;
                long j422 = 0;
                z5 = true;
                int i522 = 0;
                int i622 = 0;
                char c222 = 0;
                while (i3 < size) {
                }
                String str622 = str2;
                if (z4) {
                }
                if (z5) {
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

    /* JADX WARN: Removed duplicated region for block: B:23:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x003f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(long j) {
        InterceptResult invokeJ;
        long j2;
        boolean z;
        List<ScanResult> list;
        int size;
        int i;
        long j3;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeJ = interceptable.invokeJ(1048579, this, j)) != null) {
            return invokeJ.booleanValue;
        }
        if (Build.VERSION.SDK_INT >= 17) {
            try {
                j2 = SystemClock.elapsedRealtimeNanos() / 1000;
            } catch (Error | Exception unused) {
                j2 = 0;
            }
            if (j2 > 0) {
                z = true;
                if (z || (list = this.a) == null || list.size() == 0) {
                    return false;
                }
                size = this.a.size();
                if (size > 16) {
                    size = 16;
                }
                long j4 = 0;
                long j5 = 0;
                for (i = 0; i < size; i++) {
                    if (this.a.get(i) != null && this.a.get(i).level != 0 && z) {
                        try {
                            j3 = (j2 - this.a.get(i).timestamp) / 1000000;
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
        size = this.a.size();
        if (size > 16) {
        }
        long j42 = 0;
        long j52 = 0;
        while (i < size) {
        }
        if (j52 * 1000 <= j) {
        }
    }

    public boolean a(j jVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, jVar)) == null) {
            List<ScanResult> list = this.a;
            if (list == null || jVar == null || jVar.a == null) {
                return false;
            }
            int size = (list.size() < jVar.a.size() ? this.a : jVar.a).size();
            for (int i = 0; i < size; i++) {
                if (this.a.get(i) != null) {
                    String str = this.a.get(i).BSSID;
                    String str2 = jVar.a.get(i).BSSID;
                    if (!TextUtils.isEmpty(str) && !str.equals(str2)) {
                        return false;
                    }
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            try {
                return a(com.baidu.location.e.k.N, true, true);
            } catch (Exception unused) {
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    public String b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            if (i != 0) {
                int i2 = 1;
                if (a() < 1) {
                    return null;
                }
                StringBuffer stringBuffer = new StringBuffer(256);
                int size = this.a.size();
                int i3 = com.baidu.location.e.k.N;
                if (size > i3) {
                    size = i3;
                }
                int i4 = 0;
                for (int i5 = 0; i5 < size; i5++) {
                    if (this.a.get(i5) != null) {
                        if ((i2 & i) != 0 && this.a.get(i5).BSSID != null) {
                            stringBuffer.append(i4 == 0 ? "&ssid=" : "|");
                            stringBuffer.append(this.a.get(i5).BSSID.replace(":", ""));
                            stringBuffer.append(ParamableElem.DIVIDE_PARAM);
                            stringBuffer.append(b(this.a.get(i5).SSID));
                            i4++;
                        }
                        i2 <<= 1;
                    }
                }
                return stringBuffer.toString();
            }
            return null;
        }
        return (String) invokeI.objValue;
    }

    public boolean b(j jVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, jVar)) == null) {
            List<ScanResult> list = this.a;
            if (list == null || jVar == null || jVar.a == null) {
                return false;
            }
            int size = (list.size() < jVar.a.size() ? this.a : jVar.a).size();
            for (int i = 0; i < size; i++) {
                if (this.a.get(i) != null) {
                    String str = this.a.get(i).BSSID;
                    int i2 = this.a.get(i).level;
                    String str2 = jVar.a.get(i).BSSID;
                    int i3 = jVar.a.get(i).level;
                    if ((!TextUtils.isEmpty(str) && !str.equals(str2)) || i2 != i3) {
                        return false;
                    }
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            try {
                return a(com.baidu.location.e.k.N, true, false);
            } catch (Exception unused) {
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    public boolean c(j jVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, jVar)) == null) ? k.a(jVar, this) : invokeL.booleanValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            try {
                return a(15);
            } catch (Exception unused) {
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? a(com.baidu.location.e.k.af) : invokeV.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x002f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0030  */
    @SuppressLint({"NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long f() {
        InterceptResult invokeV;
        long j;
        boolean z;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(1048588, this)) != null) {
            return invokeV.longValue;
        }
        List<ScanResult> list = this.a;
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
                int size = this.a.size();
                if (size > 16) {
                    size = 16;
                }
                for (int i = 0; i < size; i++) {
                    if (this.a.get(i) != null && this.a.get(i).level != 0 && z) {
                        try {
                            j2 = (j - this.a.get(i).timestamp) / 1000000;
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

    /* JADX WARN: Removed duplicated region for block: B:20:0x002e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x002f  */
    @SuppressLint({"NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long g() {
        InterceptResult invokeV;
        long j;
        boolean z;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(1048589, this)) != null) {
            return invokeV.longValue;
        }
        List<ScanResult> list = this.a;
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
                int size = this.a.size();
                if (size > 16) {
                    size = 16;
                }
                long j3 = 0;
                long j4 = 0;
                long j5 = 0;
                for (int i = 0; i < size; i++) {
                    if (this.a.get(i) != null && this.a.get(i).level != 0 && z) {
                        try {
                            j2 = (j - this.a.get(i).timestamp) / 1000000;
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
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            for (int i2 = 0; i2 < a(); i2++) {
                if (this.a.get(i2) != null && (i = -this.a.get(i2).level) > 0) {
                    return i;
                }
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.d : invokeV.booleanValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? System.currentTimeMillis() - this.c > 0 && System.currentTimeMillis() - this.c < 5000 : invokeV.booleanValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? System.currentTimeMillis() - this.c > 0 && System.currentTimeMillis() - this.c < 5000 : invokeV.booleanValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? System.currentTimeMillis() - this.c > 0 && System.currentTimeMillis() - this.b < 5000 : invokeV.booleanValue;
    }
}
