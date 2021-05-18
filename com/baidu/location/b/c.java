package com.baidu.location.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.SystemClock;
import android.telephony.CellIdentityCdma;
import android.telephony.CellIdentityGsm;
import android.telephony.CellIdentityLte;
import android.telephony.CellIdentityWcdma;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoWcdma;
import android.telephony.CellLocation;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.text.TextUtils;
import com.baidu.android.bbalbs.common.util.CommonParam;
import com.baidu.location.BDLocation;
import com.baidu.location.Jni;
import com.baidu.location.LocationClientOption;
import com.baidu.tbadk.core.util.FieldBuilder;
import com.googlecode.mp4parser.boxes.ultraviolet.BaseLocationBox;
import com.tencent.connect.common.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c {

    /* renamed from: i  reason: collision with root package name */
    public static Class<?> f6552i;
    public static char[] r = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_.".toCharArray();

    /* renamed from: a  reason: collision with root package name */
    public String f6553a;

    /* renamed from: b  reason: collision with root package name */
    public String f6554b;

    /* renamed from: d  reason: collision with root package name */
    public Context f6556d;

    /* renamed from: e  reason: collision with root package name */
    public TelephonyManager f6557e;

    /* renamed from: g  reason: collision with root package name */
    public WifiManager f6559g;
    public String j;
    public String k;
    public LocationClientOption l;
    public a m;
    public String o;
    public String p;
    public boolean q;

    /* renamed from: f  reason: collision with root package name */
    public com.baidu.location.c.a f6558f = new com.baidu.location.c.a();

    /* renamed from: h  reason: collision with root package name */
    public C0090c f6560h = null;
    public String n = null;

    /* renamed from: c  reason: collision with root package name */
    public b f6555c = new b();
    public long s = 0;
    public boolean t = false;

    /* loaded from: classes2.dex */
    public interface a {
        void onReceiveLocation(BDLocation bDLocation);
    }

    /* loaded from: classes2.dex */
    public class b extends com.baidu.location.e.e {

        /* renamed from: a  reason: collision with root package name */
        public String f6561a = null;

        public b() {
            this.k = new HashMap();
        }

        @Override // com.baidu.location.e.e
        public void a() {
            this.f6807h = com.baidu.location.e.k.e();
            if (c.this.o != null && c.this.p != null) {
                this.f6561a += String.format(Locale.CHINA, "&ki=%s&sn=%s", c.this.o, c.this.p);
            }
            String str = this.f6561a + "&enc=2";
            this.f6561a = str;
            String encodeTp4 = Jni.encodeTp4(str);
            this.f6561a = null;
            this.k.put(BaseLocationBox.TYPE, encodeTp4);
            this.k.put("trtm", String.format(Locale.CHINA, "%d", Long.valueOf(System.currentTimeMillis())));
        }

        public void a(String str) {
            this.f6561a = str;
            b(com.baidu.location.e.k.f6824f);
        }

        /* JADX WARN: Code restructure failed: missing block: B:4:0x0006, code lost:
            r5 = r4.j;
         */
        @Override // com.baidu.location.e.e
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void a(boolean z) {
            String str;
            BDLocation bDLocation;
            if (z && str != null) {
                try {
                    if (str.contains("\"enc\"")) {
                        try {
                            JSONObject jSONObject = new JSONObject(str);
                            if (jSONObject.has("enc")) {
                                str = j.a().a(jSONObject.getString("enc"));
                            }
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                    try {
                        bDLocation = new BDLocation(str);
                    } catch (Exception unused) {
                        bDLocation = new BDLocation();
                        bDLocation.setLocType(63);
                    }
                    if (bDLocation.getLocType() == 161) {
                        bDLocation.setCoorType(c.this.l.coorType);
                        bDLocation.setLocationID(Jni.en1(c.this.f6553a + ";" + c.this.f6554b + ";" + bDLocation.getTime()));
                        bDLocation.setRoadLocString(0.0f, 0.0f);
                        c.this.t = true;
                        c.this.m.onReceiveLocation(bDLocation);
                    }
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
            Map<String, Object> map = this.k;
            if (map != null) {
                map.clear();
            }
        }
    }

    /* renamed from: com.baidu.location.b.c$c  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0090c {

        /* renamed from: a  reason: collision with root package name */
        public List<ScanResult> f6563a;

        /* renamed from: d  reason: collision with root package name */
        public long f6566d;

        /* renamed from: b  reason: collision with root package name */
        public String f6564b = null;

        /* renamed from: e  reason: collision with root package name */
        public String f6567e = null;

        public C0090c(List<ScanResult> list) {
            this.f6563a = null;
            this.f6566d = 0L;
            this.f6563a = list;
            this.f6566d = System.currentTimeMillis();
            try {
                b();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        /*  JADX ERROR: JadxOverflowException in pass: LoopRegionVisitor
            jadx.core.utils.exceptions.JadxOverflowException: LoopRegionVisitor.assignOnlyInLoop endless recursion
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:56)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:30)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:18)
            */
        private void b() {
            /*
                r7 = this;
                int r0 = r7.a()
                r1 = 1
                if (r0 >= r1) goto L8
                return
            L8:
                java.util.List<android.net.wifi.ScanResult> r0 = r7.f6563a
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
                java.util.List<android.net.wifi.ScanResult> r4 = r7.f6563a
                java.lang.Object r4 = r4.get(r2)
                if (r4 == 0) goto L57
                java.util.List<android.net.wifi.ScanResult> r4 = r7.f6563a
                int r5 = r2 + 1
                java.lang.Object r4 = r4.get(r5)
                if (r4 == 0) goto L57
                java.util.List<android.net.wifi.ScanResult> r4 = r7.f6563a
                java.lang.Object r4 = r4.get(r2)
                android.net.wifi.ScanResult r4 = (android.net.wifi.ScanResult) r4
                int r4 = r4.level
                java.util.List<android.net.wifi.ScanResult> r6 = r7.f6563a
                java.lang.Object r6 = r6.get(r5)
                android.net.wifi.ScanResult r6 = (android.net.wifi.ScanResult) r6
                int r6 = r6.level
                if (r4 >= r6) goto L57
                java.util.List<android.net.wifi.ScanResult> r3 = r7.f6563a
                java.lang.Object r3 = r3.get(r5)
                android.net.wifi.ScanResult r3 = (android.net.wifi.ScanResult) r3
                java.util.List<android.net.wifi.ScanResult> r4 = r7.f6563a
                java.lang.Object r6 = r4.get(r2)
                r4.set(r5, r6)
                java.util.List<android.net.wifi.ScanResult> r4 = r7.f6563a
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
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.b.c.C0090c.b():void");
        }

        public int a() {
            List<ScanResult> list = this.f6563a;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0049  */
        /* JADX WARN: Removed duplicated region for block: B:43:0x00cd  */
        /* JADX WARN: Removed duplicated region for block: B:48:0x00d9  */
        /* JADX WARN: Removed duplicated region for block: B:53:0x00e9  */
        /* JADX WARN: Removed duplicated region for block: B:55:0x00f3 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:57:0x00f5  */
        /* JADX WARN: Removed duplicated region for block: B:84:0x00e3 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:85:0x00e5 A[EDGE_INSN: B:85:0x00e5->B:51:0x00e5 ?: BREAK  , SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public String a(int i2, String str) {
            long j;
            boolean z;
            int size;
            int i3;
            boolean z2;
            String str2;
            int i4;
            String str3;
            long j2;
            int i5;
            String str4 = str;
            if (a() < 2) {
                return null;
            }
            ArrayList<Long> arrayList = new ArrayList();
            int i6 = 1;
            if (Build.VERSION.SDK_INT >= 19) {
                try {
                    j = SystemClock.elapsedRealtimeNanos() / 1000;
                } catch (Error unused) {
                    j = 0;
                }
                if (j > 0) {
                    z = true;
                    StringBuffer stringBuffer = new StringBuffer(512);
                    size = this.f6563a.size();
                    long j3 = 0;
                    i3 = 0;
                    int i7 = 0;
                    z2 = true;
                    int i8 = 0;
                    int i9 = 0;
                    while (true) {
                        if (i3 < size) {
                            str2 = "";
                            break;
                        }
                        if (this.f6563a.get(i3).level != 0) {
                            i7++;
                            if (z2) {
                                stringBuffer.append("&wf=");
                                z2 = false;
                            } else {
                                stringBuffer.append(FieldBuilder.SE);
                            }
                            String replace = this.f6563a.get(i3).BSSID.replace(":", "");
                            stringBuffer.append(replace);
                            if (str4 != null && replace.equals(str4)) {
                                i9 = i7;
                            }
                            int i10 = this.f6563a.get(i3).level;
                            if (i10 < 0) {
                                i10 = -i10;
                            }
                            Locale locale = Locale.CHINA;
                            Object[] objArr = new Object[i6];
                            objArr[0] = Integer.valueOf(i10);
                            stringBuffer.append(String.format(locale, ";%d;", objArr));
                            int i11 = i8 + 1;
                            if (z) {
                                try {
                                    str2 = "";
                                    try {
                                        j2 = (j - this.f6563a.get(i3).timestamp) / 1000000;
                                    } catch (Throwable unused2) {
                                        j2 = 0;
                                        arrayList.add(Long.valueOf(j2));
                                        if (j2 > j3) {
                                        }
                                        i5 = i2;
                                        if (i11 > i5) {
                                        }
                                    }
                                } catch (Throwable unused3) {
                                    str2 = "";
                                }
                                arrayList.add(Long.valueOf(j2));
                                if (j2 > j3) {
                                    i5 = i2;
                                    j3 = j2;
                                    if (i11 > i5) {
                                        break;
                                    }
                                    i8 = i11;
                                }
                            } else {
                                str2 = "";
                            }
                            i5 = i2;
                            if (i11 > i5) {
                            }
                        }
                        i3++;
                        str4 = str;
                        i6 = 1;
                    }
                    i4 = i9;
                    if (i4 > 0) {
                        stringBuffer.append("&wf_n=");
                        stringBuffer.append(i4);
                    }
                    if (z2) {
                        if (j3 > 10 && arrayList.size() > 0 && ((Long) arrayList.get(0)).longValue() > 0) {
                            StringBuffer stringBuffer2 = new StringBuffer(128);
                            stringBuffer2.append("&wf_ut=");
                            Long l = (Long) arrayList.get(0);
                            boolean z3 = true;
                            for (Long l2 : arrayList) {
                                if (z3) {
                                    stringBuffer2.append(l2.longValue());
                                    str3 = str2;
                                    z3 = false;
                                } else {
                                    long longValue = l2.longValue() - l.longValue();
                                    if (longValue != 0) {
                                        StringBuilder sb = new StringBuilder();
                                        str3 = str2;
                                        sb.append(str3);
                                        sb.append(longValue);
                                        stringBuffer2.append(sb.toString());
                                    } else {
                                        str3 = str2;
                                    }
                                }
                                stringBuffer2.append(FieldBuilder.SE);
                                str2 = str3;
                            }
                            stringBuffer.append(stringBuffer2.toString());
                        }
                        return stringBuffer.toString();
                    }
                    return null;
                }
            } else {
                j = 0;
            }
            z = false;
            StringBuffer stringBuffer3 = new StringBuffer(512);
            size = this.f6563a.size();
            long j32 = 0;
            i3 = 0;
            int i72 = 0;
            z2 = true;
            int i82 = 0;
            int i92 = 0;
            while (true) {
                if (i3 < size) {
                }
                i3++;
                str4 = str;
                i6 = 1;
            }
            i4 = i92;
            if (i4 > 0) {
            }
            if (z2) {
            }
        }
    }

    public c(Context context, LocationClientOption locationClientOption, a aVar) {
        StringBuilder sb;
        String str = null;
        this.f6556d = null;
        this.f6557e = null;
        this.f6559g = null;
        this.j = null;
        this.k = null;
        this.o = null;
        this.p = null;
        this.f6553a = null;
        this.f6554b = null;
        this.q = false;
        Context applicationContext = context.getApplicationContext();
        this.f6556d = applicationContext;
        try {
            com.baidu.location.e.k.ax = applicationContext.getPackageName();
        } catch (Exception unused) {
        }
        this.q = true;
        if (1 != 0) {
            this.l = new LocationClientOption(locationClientOption);
            this.m = aVar;
            this.f6553a = this.f6556d.getPackageName();
            this.f6554b = null;
            try {
                this.f6557e = (TelephonyManager) this.f6556d.getSystemService("phone");
                this.f6559g = (WifiManager) this.f6556d.getApplicationContext().getSystemService("wifi");
            } catch (Exception unused2) {
            }
            this.k = "&" + this.f6553a + "&" + ((String) null);
            try {
                this.f6554b = CommonParam.getCUID(this.f6556d);
            } catch (Throwable unused3) {
                this.f6554b = null;
                this.f6557e = null;
                this.f6559g = null;
            }
            if (this.f6554b != null) {
                com.baidu.location.e.k.o = "" + this.f6554b;
                sb = new StringBuilder();
                sb.append("&prod=");
                sb.append(this.l.prodName);
                sb.append(":");
                sb.append(this.f6553a);
                sb.append("|&cu=");
                str = this.f6554b;
            } else {
                sb = new StringBuilder();
                sb.append("&prod=");
                sb.append(this.l.prodName);
                sb.append(":");
                sb.append(this.f6553a);
                sb.append("|&im=");
            }
            sb.append(str);
            sb.append("&coor=");
            sb.append(locationClientOption.getCoorType());
            this.j = sb.toString();
            StringBuffer stringBuffer = new StringBuffer(256);
            stringBuffer.append("&fw=");
            stringBuffer.append("7.93");
            stringBuffer.append("&sdk=");
            stringBuffer.append("7.93");
            stringBuffer.append("&lt=1");
            stringBuffer.append("&mb=");
            stringBuffer.append(Build.MODEL);
            stringBuffer.append("&resid=");
            stringBuffer.append(Constants.VIA_REPORT_TYPE_SET_AVATAR);
            locationClientOption.getAddrType();
            if (locationClientOption.getAddrType() != null && locationClientOption.getAddrType().equals("all")) {
                this.j += "&addr=allj";
                if (locationClientOption.isNeedNewVersionRgc) {
                    stringBuffer.append("&adtp=n2");
                }
            }
            if (locationClientOption.isNeedAptag || locationClientOption.isNeedAptagd) {
                this.j += "&sema=";
                if (locationClientOption.isNeedAptag) {
                    this.j += "aptag|";
                }
                if (locationClientOption.isNeedAptagd) {
                    this.j += "aptagd|";
                }
                this.o = com.baidu.location.a.a.b(this.f6556d);
                this.p = com.baidu.location.a.a.c(this.f6556d);
            }
            stringBuffer.append("&first=1");
            stringBuffer.append("&os=A");
            stringBuffer.append(Build.VERSION.SDK);
            this.j += stringBuffer.toString();
            String a2 = a();
            a2 = TextUtils.isEmpty(a2) ? a2 : a2.replace(":", "");
            if (!TextUtils.isEmpty(a2) && !a2.equals("020000000000")) {
                this.j += "&mac=" + a2;
            }
            b();
        }
    }

    private int a(int i2) {
        if (i2 == Integer.MAX_VALUE) {
            return -1;
        }
        return i2;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:5|(1:7)(2:24|(9:26|(4:31|32|33|(2:39|(1:41)))|30|9|10|(3:13|14|(1:16))|19|20|21)(7:45|(1:47)|10|(3:13|14|(0))|19|20|21))|8|9|10|(0)|19|20|21) */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00d1, code lost:
        if (r2 <= 0) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0170, code lost:
        r1.f6705g = java.lang.System.currentTimeMillis();
     */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0117 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x011d A[Catch: Exception -> 0x015b, TRY_LEAVE, TryCatch #2 {Exception -> 0x015b, blocks: (B:38:0x0119, B:40:0x011d), top: B:50:0x0119 }] */
    @SuppressLint({"NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private com.baidu.location.c.a a(CellInfo cellInfo) {
        int asuLevel;
        int i2;
        int intValue = Integer.valueOf(Build.VERSION.SDK_INT).intValue();
        if (intValue < 17) {
            return null;
        }
        com.baidu.location.c.a aVar = new com.baidu.location.c.a();
        boolean z = false;
        if (!(cellInfo instanceof CellInfoGsm)) {
            if (!(cellInfo instanceof CellInfoCdma)) {
                if (cellInfo instanceof CellInfoLte) {
                    CellInfoLte cellInfoLte = (CellInfoLte) cellInfo;
                    CellIdentityLte cellIdentity = cellInfoLte.getCellIdentity();
                    aVar.f6701c = a(cellIdentity.getMcc());
                    aVar.f6702d = a(cellIdentity.getMnc());
                    aVar.f6699a = a(cellIdentity.getTac());
                    aVar.f6700b = a(cellIdentity.getCi());
                    aVar.f6707i = 'g';
                    asuLevel = cellInfoLte.getCellSignalStrength().getAsuLevel();
                }
                if (intValue >= 18) {
                    if (cellInfo instanceof CellInfoWcdma) {
                    }
                }
                aVar.f6705g = System.currentTimeMillis() - ((SystemClock.elapsedRealtimeNanos() - cellInfo.getTimeStamp()) / 1000000);
                return aVar;
            }
            CellInfoCdma cellInfoCdma = (CellInfoCdma) cellInfo;
            CellIdentityCdma cellIdentity2 = cellInfoCdma.getCellIdentity();
            aVar.f6703e = cellIdentity2.getLatitude();
            aVar.f6704f = cellIdentity2.getLongitude();
            aVar.f6702d = a(cellIdentity2.getSystemId());
            aVar.f6699a = a(cellIdentity2.getNetworkId());
            aVar.f6700b = a(cellIdentity2.getBasestationId());
            aVar.f6707i = 'c';
            aVar.f6706h = cellInfoCdma.getCellSignalStrength().getCdmaDbm();
            com.baidu.location.c.a aVar2 = this.f6558f;
            if (aVar2 == null || (i2 = aVar2.f6701c) <= 0) {
                i2 = -1;
                try {
                    String networkOperator = this.f6557e.getNetworkOperator();
                    if (networkOperator != null && networkOperator.length() > 0 && networkOperator.length() >= 3) {
                        int intValue2 = Integer.valueOf(networkOperator.substring(0, 3)).intValue();
                        if (intValue2 >= 0) {
                            i2 = intValue2;
                        }
                    }
                } catch (Exception unused) {
                }
            }
            aVar.f6701c = i2;
            z = true;
            if (intValue >= 18 && !z) {
                try {
                    if (cellInfo instanceof CellInfoWcdma) {
                        CellIdentityWcdma cellIdentity3 = ((CellInfoWcdma) cellInfo).getCellIdentity();
                        aVar.f6701c = a(cellIdentity3.getMcc());
                        aVar.f6702d = a(cellIdentity3.getMnc());
                        aVar.f6699a = a(cellIdentity3.getLac());
                        aVar.f6700b = a(cellIdentity3.getCid());
                        aVar.f6707i = 'g';
                        aVar.f6706h = ((CellInfoWcdma) cellInfo).getCellSignalStrength().getAsuLevel();
                    }
                } catch (Exception unused2) {
                }
            }
            aVar.f6705g = System.currentTimeMillis() - ((SystemClock.elapsedRealtimeNanos() - cellInfo.getTimeStamp()) / 1000000);
            return aVar;
        }
        CellInfoGsm cellInfoGsm = (CellInfoGsm) cellInfo;
        CellIdentityGsm cellIdentity4 = cellInfoGsm.getCellIdentity();
        aVar.f6701c = a(cellIdentity4.getMcc());
        aVar.f6702d = a(cellIdentity4.getMnc());
        aVar.f6699a = a(cellIdentity4.getLac());
        aVar.f6700b = a(cellIdentity4.getCid());
        aVar.f6707i = 'g';
        asuLevel = cellInfoGsm.getCellSignalStrength().getAsuLevel();
        aVar.f6706h = asuLevel;
        z = true;
        if (intValue >= 18) {
        }
        aVar.f6705g = System.currentTimeMillis() - ((SystemClock.elapsedRealtimeNanos() - cellInfo.getTimeStamp()) / 1000000);
        return aVar;
    }

    private void a(CellLocation cellLocation) {
        if (cellLocation == null || this.f6557e == null) {
            return;
        }
        com.baidu.location.c.a aVar = new com.baidu.location.c.a();
        String networkOperator = this.f6557e.getNetworkOperator();
        if (networkOperator != null && networkOperator.length() > 0) {
            try {
                if (networkOperator.length() >= 3) {
                    int intValue = Integer.valueOf(networkOperator.substring(0, 3)).intValue();
                    if (intValue < 0) {
                        intValue = this.f6558f.f6701c;
                    }
                    aVar.f6701c = intValue;
                }
                String substring = networkOperator.substring(3);
                if (substring != null) {
                    char[] charArray = substring.toCharArray();
                    int i2 = 0;
                    while (i2 < charArray.length && Character.isDigit(charArray[i2])) {
                        i2++;
                    }
                    int intValue2 = Integer.valueOf(substring.substring(0, i2)).intValue();
                    if (intValue2 < 0) {
                        intValue2 = this.f6558f.f6702d;
                    }
                    aVar.f6702d = intValue2;
                }
            } catch (Exception unused) {
            }
        }
        if (cellLocation instanceof GsmCellLocation) {
            GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
            aVar.f6699a = gsmCellLocation.getLac();
            aVar.f6700b = gsmCellLocation.getCid();
            aVar.f6707i = 'g';
        } else if (cellLocation instanceof CdmaCellLocation) {
            aVar.f6707i = 'c';
            if (f6552i == null) {
                try {
                    f6552i = Class.forName("android.telephony.cdma.CdmaCellLocation");
                } catch (Exception unused2) {
                    f6552i = null;
                    return;
                }
            }
            Class<?> cls = f6552i;
            if (cls != null && cls.isInstance(cellLocation)) {
                try {
                    int systemId = ((CdmaCellLocation) cellLocation).getSystemId();
                    if (systemId < 0) {
                        systemId = -1;
                    }
                    aVar.f6702d = systemId;
                    aVar.f6700b = ((CdmaCellLocation) cellLocation).getBaseStationId();
                    aVar.f6699a = ((CdmaCellLocation) cellLocation).getNetworkId();
                    int baseStationLatitude = ((CdmaCellLocation) cellLocation).getBaseStationLatitude();
                    if (baseStationLatitude < Integer.MAX_VALUE) {
                        aVar.f6703e = baseStationLatitude;
                    }
                    int baseStationLongitude = ((CdmaCellLocation) cellLocation).getBaseStationLongitude();
                    if (baseStationLongitude < Integer.MAX_VALUE) {
                        aVar.f6704f = baseStationLongitude;
                    }
                } catch (Exception unused3) {
                }
            }
        }
        if (aVar.b()) {
            this.f6558f = aVar;
        } else {
            this.f6558f = null;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(16:1|2|3|(9:8|9|(1:45)(1:13)|15|16|(1:22)|24|25|(2:(1:(1:33)(1:34))|(1:36)(4:37|(1:39)|40|41))(2:28|29))|46|9|(1:11)|45|15|16|(3:18|20|22)|24|25|(0)|(0)|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x006b, code lost:
        r5 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x008a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x008b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String b(int i2) {
        String str;
        String str2;
        com.baidu.location.c.a d2;
        try {
            d2 = d();
        } catch (Throwable unused) {
            str = null;
        }
        if (d2 != null && d2.b()) {
            this.f6558f = d2;
            str = (this.f6558f == null && this.f6558f.b()) ? this.f6558f.g() : null;
            if (!TextUtils.isEmpty(str) && this.f6558f != null && this.f6558f.k != null) {
                str = str + this.f6558f.k;
            }
            this.f6560h = null;
            C0090c c0090c = new C0090c(this.f6559g.getScanResults());
            this.f6560h = c0090c;
            str2 = c0090c.a(i2, e());
            if (str != null && str2 == null) {
                this.n = null;
                return null;
            }
            if (str2 != null) {
                if (str == null) {
                    str = str2;
                } else {
                    str = str + str2;
                }
            }
            if (str != null) {
                return null;
            }
            this.n = str;
            if (this.j != null) {
                this.n += this.j;
            }
            return str + this.j;
        }
        a(this.f6557e.getCellLocation());
        if (this.f6558f == null) {
        }
        if (!TextUtils.isEmpty(str)) {
            str = str + this.f6558f.k;
        }
        this.f6560h = null;
        C0090c c0090c2 = new C0090c(this.f6559g.getScanResults());
        this.f6560h = c0090c2;
        str2 = c0090c2.a(i2, e());
        if (str != null) {
        }
        if (str2 != null) {
        }
        if (str != null) {
        }
    }

    @SuppressLint({"NewApi"})
    private com.baidu.location.c.a d() {
        if (Integer.valueOf(Build.VERSION.SDK_INT).intValue() < 17) {
            return null;
        }
        try {
            List<CellInfo> allCellInfo = this.f6557e.getAllCellInfo();
            if (allCellInfo == null || allCellInfo.size() <= 0) {
                return null;
            }
            com.baidu.location.c.a aVar = null;
            for (CellInfo cellInfo : allCellInfo) {
                if (cellInfo.isRegistered()) {
                    boolean z = aVar != null;
                    com.baidu.location.c.a a2 = a(cellInfo);
                    if (a2 != null) {
                        if (!a2.b()) {
                            a2 = null;
                        } else if (z && aVar != null) {
                            aVar.k = a2.h();
                            return aVar;
                        }
                        if (aVar == null) {
                            aVar = a2;
                        }
                    }
                }
            }
            return aVar;
        } catch (Throwable unused) {
            return null;
        }
    }

    private String e() {
        WifiInfo connectionInfo;
        WifiManager wifiManager = this.f6559g;
        if (wifiManager == null || (connectionInfo = wifiManager.getConnectionInfo()) == null) {
            return null;
        }
        try {
            String bssid = connectionInfo.getBSSID();
            String replace = bssid != null ? bssid.replace(":", "") : null;
            if (replace == null || replace.length() == 12) {
                return new String(replace);
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public String a() {
        try {
            WifiInfo connectionInfo = this.f6559g.getConnectionInfo();
            if (connectionInfo != null) {
                return connectionInfo.getMacAddress();
            }
            return null;
        } catch (Error | Exception unused) {
            return null;
        }
    }

    public String b() {
        try {
            return b(15);
        } catch (Exception unused) {
            return null;
        }
    }

    public void c() {
        String str = this.n;
        if (str != null && this.q) {
            this.f6555c.a(str);
        }
    }
}
