package com.baidu.location.c;

import android.annotation.SuppressLint;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.location.e.k;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.regex.Pattern;
/* loaded from: classes7.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public List<ScanResult> f39133a;

    /* renamed from: b  reason: collision with root package name */
    public long f39134b;

    /* renamed from: c  reason: collision with root package name */
    public long f39135c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f39136d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f39137e;

    public h(List<ScanResult> list, long j) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list, Long.valueOf(j)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f39133a = null;
        this.f39134b = 0L;
        this.f39135c = 0L;
        this.f39136d = false;
        this.f39134b = j;
        this.f39133a = list;
        this.f39135c = System.currentTimeMillis();
        try {
            n();
        } catch (Exception e2) {
            e2.printStackTrace();
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
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, this, str)) == null) ? str != null ? (str.contains("&") || str.contains(";")) ? str.replace("&", "_").replace(";", "_") : str : str : (String) invokeL.objValue;
    }

    private int m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            List<ScanResult> list = this.f39133a;
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
            com.baidu.titan.sdk.runtime.Interceptable r0 = com.baidu.location.c.h.$ic
            if (r0 != 0) goto L63
        L4:
            int r0 = r7.m()
            r1 = 1
            if (r0 >= r1) goto Lc
            return
        Lc:
            java.util.List<android.net.wifi.ScanResult> r0 = r7.f39133a
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
            java.util.List<android.net.wifi.ScanResult> r4 = r7.f39133a
            java.lang.Object r4 = r4.get(r2)
            if (r4 == 0) goto L5b
            java.util.List<android.net.wifi.ScanResult> r4 = r7.f39133a
            int r5 = r2 + 1
            java.lang.Object r4 = r4.get(r5)
            if (r4 == 0) goto L5b
            java.util.List<android.net.wifi.ScanResult> r4 = r7.f39133a
            java.lang.Object r4 = r4.get(r2)
            android.net.wifi.ScanResult r4 = (android.net.wifi.ScanResult) r4
            int r4 = r4.level
            java.util.List<android.net.wifi.ScanResult> r6 = r7.f39133a
            java.lang.Object r6 = r6.get(r5)
            android.net.wifi.ScanResult r6 = (android.net.wifi.ScanResult) r6
            int r6 = r6.level
            if (r4 >= r6) goto L5b
            java.util.List<android.net.wifi.ScanResult> r3 = r7.f39133a
            java.lang.Object r3 = r3.get(r5)
            android.net.wifi.ScanResult r3 = (android.net.wifi.ScanResult) r3
            java.util.List<android.net.wifi.ScanResult> r4 = r7.f39133a
            java.lang.Object r6 = r4.get(r2)
            r4.set(r5, r6)
            java.util.List<android.net.wifi.ScanResult> r4 = r7.f39133a
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
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.c.h.n():void");
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            List<ScanResult> list = this.f39133a;
            if (list == null) {
                return 0;
            }
            return list.size();
        }
        return invokeV.intValue;
    }

    public String a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? a(i2, false, false) : (String) invokeI.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x01e1  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x01f5  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0217 A[Catch: Exception -> 0x0060, Error -> 0x0315, TryCatch #0 {Exception -> 0x0060, blocks: (B:19:0x0057, B:33:0x0079, B:40:0x0095, B:42:0x009d, B:52:0x00c9, B:56:0x00db, B:58:0x00e1, B:61:0x00f1, B:62:0x00f6, B:64:0x00fe, B:66:0x0109, B:68:0x0115, B:71:0x0129, B:73:0x0146, B:75:0x014e, B:105:0x0208, B:101:0x01e3, B:65:0x0106, B:108:0x0217, B:110:0x022f, B:114:0x0240, B:117:0x025a, B:119:0x0260, B:121:0x0271, B:122:0x0289, B:124:0x028f, B:126:0x0297, B:130:0x02c3, B:127:0x02a2, B:129:0x02b1, B:131:0x02c7, B:133:0x02d0, B:135:0x02f0, B:139:0x02ff, B:141:0x0304, B:142:0x030e), top: B:157:0x0057 }] */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0313 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0095 A[Catch: Exception -> 0x0060, Error -> 0x0315, TRY_ENTER, TryCatch #0 {Exception -> 0x0060, blocks: (B:19:0x0057, B:33:0x0079, B:40:0x0095, B:42:0x009d, B:52:0x00c9, B:56:0x00db, B:58:0x00e1, B:61:0x00f1, B:62:0x00f6, B:64:0x00fe, B:66:0x0109, B:68:0x0115, B:71:0x0129, B:73:0x0146, B:75:0x014e, B:105:0x0208, B:101:0x01e3, B:65:0x0106, B:108:0x0217, B:110:0x022f, B:114:0x0240, B:117:0x025a, B:119:0x0260, B:121:0x0271, B:122:0x0289, B:124:0x028f, B:126:0x0297, B:130:0x02c3, B:127:0x02a2, B:129:0x02b1, B:131:0x02c7, B:133:0x02d0, B:135:0x02f0, B:139:0x02ff, B:141:0x0304, B:142:0x030e), top: B:157:0x0057 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00f1 A[Catch: Exception -> 0x0060, Error -> 0x0315, TryCatch #0 {Exception -> 0x0060, blocks: (B:19:0x0057, B:33:0x0079, B:40:0x0095, B:42:0x009d, B:52:0x00c9, B:56:0x00db, B:58:0x00e1, B:61:0x00f1, B:62:0x00f6, B:64:0x00fe, B:66:0x0109, B:68:0x0115, B:71:0x0129, B:73:0x0146, B:75:0x014e, B:105:0x0208, B:101:0x01e3, B:65:0x0106, B:108:0x0217, B:110:0x022f, B:114:0x0240, B:117:0x025a, B:119:0x0260, B:121:0x0271, B:122:0x0289, B:124:0x028f, B:126:0x0297, B:130:0x02c3, B:127:0x02a2, B:129:0x02b1, B:131:0x02c7, B:133:0x02d0, B:135:0x02f0, B:139:0x02ff, B:141:0x0304, B:142:0x030e), top: B:157:0x0057 }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00fe A[Catch: Exception -> 0x0060, Error -> 0x0315, TryCatch #0 {Exception -> 0x0060, blocks: (B:19:0x0057, B:33:0x0079, B:40:0x0095, B:42:0x009d, B:52:0x00c9, B:56:0x00db, B:58:0x00e1, B:61:0x00f1, B:62:0x00f6, B:64:0x00fe, B:66:0x0109, B:68:0x0115, B:71:0x0129, B:73:0x0146, B:75:0x014e, B:105:0x0208, B:101:0x01e3, B:65:0x0106, B:108:0x0217, B:110:0x022f, B:114:0x0240, B:117:0x025a, B:119:0x0260, B:121:0x0271, B:122:0x0289, B:124:0x028f, B:126:0x0297, B:130:0x02c3, B:127:0x02a2, B:129:0x02b1, B:131:0x02c7, B:133:0x02d0, B:135:0x02f0, B:139:0x02ff, B:141:0x0304, B:142:0x030e), top: B:157:0x0057 }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0106 A[Catch: Exception -> 0x0060, Error -> 0x0315, TryCatch #0 {Exception -> 0x0060, blocks: (B:19:0x0057, B:33:0x0079, B:40:0x0095, B:42:0x009d, B:52:0x00c9, B:56:0x00db, B:58:0x00e1, B:61:0x00f1, B:62:0x00f6, B:64:0x00fe, B:66:0x0109, B:68:0x0115, B:71:0x0129, B:73:0x0146, B:75:0x014e, B:105:0x0208, B:101:0x01e3, B:65:0x0106, B:108:0x0217, B:110:0x022f, B:114:0x0240, B:117:0x025a, B:119:0x0260, B:121:0x0271, B:122:0x0289, B:124:0x028f, B:126:0x0297, B:130:0x02c3, B:127:0x02a2, B:129:0x02b1, B:131:0x02c7, B:133:0x02d0, B:135:0x02f0, B:139:0x02ff, B:141:0x0304, B:142:0x030e), top: B:157:0x0057 }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0115 A[Catch: Exception -> 0x0060, Error -> 0x0315, TryCatch #0 {Exception -> 0x0060, blocks: (B:19:0x0057, B:33:0x0079, B:40:0x0095, B:42:0x009d, B:52:0x00c9, B:56:0x00db, B:58:0x00e1, B:61:0x00f1, B:62:0x00f6, B:64:0x00fe, B:66:0x0109, B:68:0x0115, B:71:0x0129, B:73:0x0146, B:75:0x014e, B:105:0x0208, B:101:0x01e3, B:65:0x0106, B:108:0x0217, B:110:0x022f, B:114:0x0240, B:117:0x025a, B:119:0x0260, B:121:0x0271, B:122:0x0289, B:124:0x028f, B:126:0x0297, B:130:0x02c3, B:127:0x02a2, B:129:0x02b1, B:131:0x02c7, B:133:0x02d0, B:135:0x02f0, B:139:0x02ff, B:141:0x0304, B:142:0x030e), top: B:157:0x0057 }] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0167  */
    @SuppressLint({"NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String a(int i2, boolean z, boolean z2) {
        InterceptResult invokeCommon;
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
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2)})) != null) {
            return (String) invokeCommon.objValue;
        }
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
                        } catch (Exception unused) {
                            return null;
                        }
                    } catch (Error unused2) {
                        j = 0;
                    }
                    if (j > 0) {
                        z3 = true;
                        if (z3) {
                            z3 = z3 && z;
                        }
                        size = this.f39133a.size();
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
                            if (this.f39133a.get(i4) == null || this.f39133a.get(i4).level == 0) {
                                str3 = str7;
                                str4 = str2;
                                j2 = j;
                                c2 = c3;
                            } else {
                                if (z3) {
                                    try {
                                        str5 = str;
                                        str4 = str2;
                                        try {
                                            j3 = (j - this.f39133a.get(i4).timestamp) / 1000000;
                                        } catch (Exception unused3) {
                                            j3 = 0;
                                            arrayList.add(Long.valueOf(j3));
                                            if (j3 > j4) {
                                            }
                                            if (Build.VERSION.SDK_INT >= 23) {
                                                if (stringBuffer2 == null) {
                                                }
                                                stringBuffer2.append(i4);
                                                stringBuffer2.append("|");
                                            }
                                            if (z4) {
                                            }
                                            str6 = this.f39133a.get(i4).BSSID;
                                            if (str6 == null) {
                                            }
                                            i4++;
                                            str2 = str4;
                                            str7 = str3;
                                            j = j2;
                                        }
                                    } catch (Exception unused4) {
                                        str5 = str;
                                        str4 = str2;
                                    }
                                    arrayList.add(Long.valueOf(j3));
                                    if (j3 > j4) {
                                        j4 = j3;
                                    }
                                } else {
                                    str5 = str;
                                    str4 = str2;
                                }
                                if (Build.VERSION.SDK_INT >= 23 && this.f39133a.get(i4).is80211mcResponder()) {
                                    if (stringBuffer2 == null) {
                                        stringBuffer2 = new StringBuffer();
                                    }
                                    stringBuffer2.append(i4);
                                    stringBuffer2.append("|");
                                }
                                if (z4) {
                                    stringBuffer.append("|");
                                } else {
                                    stringBuffer.append("&wf=");
                                    z4 = false;
                                }
                                str6 = this.f39133a.get(i4).BSSID;
                                if (str6 == null) {
                                    String replace = str6.replace(str7, "");
                                    stringBuffer.append(replace);
                                    int i7 = this.f39133a.get(i4).level;
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
                                            this.f39137e = a(this.f39133a.get(i4).capabilities);
                                            i5 = i6;
                                            z5 = true;
                                            if (z5) {
                                                c2 = c3;
                                                if (c2 == 0) {
                                                    try {
                                                        if (random.nextInt(10) == 2 && this.f39133a.get(i4).SSID != null && this.f39133a.get(i4).SSID.length() < 30) {
                                                            stringBuffer.append(b(this.f39133a.get(i4).SSID));
                                                            c3 = 1;
                                                        }
                                                    } catch (Exception unused5) {
                                                    }
                                                } else if (c2 == 1 && random.nextInt(20) == 1 && this.f39133a.get(i4).SSID != null && this.f39133a.get(i4).SSID.length() < 30) {
                                                    stringBuffer.append(b(this.f39133a.get(i4).SSID));
                                                    c3 = 2;
                                                }
                                            } else {
                                                c2 = c3;
                                                stringBuffer.append(b(this.f39133a.get(i4).SSID));
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
                                    stringBuffer3.append("|");
                                }
                                stringBuffer.append(stringBuffer3.toString());
                            }
                            stringBuffer.append("&wf_st=");
                            stringBuffer.append(this.f39134b);
                            stringBuffer.append("&wf_et=");
                            stringBuffer.append(this.f39135c);
                            stringBuffer.append("&wf_vt=");
                            stringBuffer.append(i.f39138a);
                            if (i8 > 0) {
                                this.f39136d = true;
                                stringBuffer.append("&wf_en=");
                                stringBuffer.append(this.f39137e ? 1 : 0);
                            }
                            if (str8 != null) {
                                stringBuffer.append("&wf_gw=");
                                stringBuffer.append(str8);
                            }
                            return stringBuffer.toString();
                        }
                        return null;
                    }
                } else {
                    j = 0;
                }
                size = this.f39133a.size();
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
        int i2;
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
                if (z || (list = this.f39133a) == null || list.size() == 0) {
                    return false;
                }
                size = this.f39133a.size();
                if (size > 16) {
                    size = 16;
                }
                long j4 = 0;
                long j5 = 0;
                for (i2 = 0; i2 < size; i2++) {
                    if (this.f39133a.get(i2) != null && this.f39133a.get(i2).level != 0 && z) {
                        try {
                            j3 = (j2 - this.f39133a.get(i2).timestamp) / 1000000;
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
        size = this.f39133a.size();
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
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, hVar)) == null) {
            List<ScanResult> list = this.f39133a;
            if (list == null || hVar == null || hVar.f39133a == null) {
                return false;
            }
            int size = (list.size() < hVar.f39133a.size() ? this.f39133a : hVar.f39133a).size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.f39133a.get(i2) != null && !this.f39133a.get(i2).BSSID.equals(hVar.f39133a.get(i2).BSSID)) {
                    return false;
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
                return a(k.O, true, true);
            } catch (Exception unused) {
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    public String b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            if (i2 != 0) {
                int i3 = 1;
                if (a() < 1) {
                    return null;
                }
                StringBuffer stringBuffer = new StringBuffer(256);
                int size = this.f39133a.size();
                int i4 = k.O;
                if (size > i4) {
                    size = i4;
                }
                int i5 = 0;
                for (int i6 = 0; i6 < size; i6++) {
                    if (this.f39133a.get(i6) != null) {
                        if ((i3 & i2) != 0 && this.f39133a.get(i6).BSSID != null) {
                            stringBuffer.append(i5 == 0 ? "&ssid=" : "|");
                            stringBuffer.append(this.f39133a.get(i6).BSSID.replace(":", ""));
                            stringBuffer.append(";");
                            stringBuffer.append(b(this.f39133a.get(i6).SSID));
                            i5++;
                        }
                        i3 <<= 1;
                    }
                }
                return stringBuffer.toString();
            }
            return null;
        }
        return (String) invokeI.objValue;
    }

    public boolean b(h hVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, hVar)) == null) {
            List<ScanResult> list = this.f39133a;
            if (list == null || hVar == null || hVar.f39133a == null) {
                return false;
            }
            int size = (list.size() < hVar.f39133a.size() ? this.f39133a : hVar.f39133a).size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.f39133a.get(i2) != null) {
                    String str = this.f39133a.get(i2).BSSID;
                    int i3 = this.f39133a.get(i2).level;
                    String str2 = hVar.f39133a.get(i2).BSSID;
                    int i4 = hVar.f39133a.get(i2).level;
                    if (!str.equals(str2) || i3 != i4) {
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
                return a(k.O, true, false);
            } catch (Exception unused) {
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    public boolean c(h hVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, hVar)) == null) ? i.a(hVar, this) : invokeL.booleanValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? a(k.ag) : invokeV.booleanValue;
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
        List<ScanResult> list = this.f39133a;
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
                int size = this.f39133a.size();
                if (size > 16) {
                    size = 16;
                }
                for (int i2 = 0; i2 < size; i2++) {
                    if (this.f39133a.get(i2) != null && this.f39133a.get(i2).level != 0 && z) {
                        try {
                            j2 = (j - this.f39133a.get(i2).timestamp) / 1000000;
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
        List<ScanResult> list = this.f39133a;
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
                int size = this.f39133a.size();
                if (size > 16) {
                    size = 16;
                }
                long j3 = 0;
                long j4 = 0;
                long j5 = 0;
                for (int i2 = 0; i2 < size; i2++) {
                    if (this.f39133a.get(i2) != null && this.f39133a.get(i2).level != 0 && z) {
                        try {
                            j2 = (j - this.f39133a.get(i2).timestamp) / 1000000;
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
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            for (int i3 = 0; i3 < a(); i3++) {
                if (this.f39133a.get(i3) != null && (i2 = -this.f39133a.get(i3).level) > 0) {
                    return i2;
                }
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f39136d : invokeV.booleanValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? System.currentTimeMillis() - this.f39135c > 0 && System.currentTimeMillis() - this.f39135c < 5000 : invokeV.booleanValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? System.currentTimeMillis() - this.f39135c > 0 && System.currentTimeMillis() - this.f39135c < 5000 : invokeV.booleanValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? System.currentTimeMillis() - this.f39135c > 0 && System.currentTimeMillis() - this.f39134b < 5000 : invokeV.booleanValue;
    }
}
