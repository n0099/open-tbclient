package com.baidu.location.a;

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
/* loaded from: classes2.dex */
public class c {

    /* renamed from: i  reason: collision with root package name */
    public static Class<?> f6721i;

    /* renamed from: a  reason: collision with root package name */
    public String f6722a;

    /* renamed from: b  reason: collision with root package name */
    public String f6723b;

    /* renamed from: d  reason: collision with root package name */
    public Context f6725d;

    /* renamed from: e  reason: collision with root package name */
    public TelephonyManager f6726e;

    /* renamed from: g  reason: collision with root package name */
    public WifiManager f6728g;
    public String j;
    public LocationClientOption k;
    public a l;
    public String n;
    public String o;
    public boolean p;

    /* renamed from: f  reason: collision with root package name */
    public com.baidu.location.b.a f6727f = new com.baidu.location.b.a();

    /* renamed from: h  reason: collision with root package name */
    public C0091c f6729h = null;
    public String m = null;

    /* renamed from: c  reason: collision with root package name */
    public b f6724c = new b();
    public long q = 0;
    public boolean r = false;

    /* loaded from: classes2.dex */
    public interface a {
        void onReceiveLocation(BDLocation bDLocation);
    }

    /* loaded from: classes2.dex */
    public class b extends com.baidu.location.d.e {

        /* renamed from: a  reason: collision with root package name */
        public String f6730a = null;

        public b() {
            this.k = new HashMap();
        }

        @Override // com.baidu.location.d.e
        public void a() {
            this.f6975h = com.baidu.location.d.j.c();
            if (c.this.n != null && c.this.o != null) {
                this.f6730a += String.format(Locale.CHINA, "&ki=%s&sn=%s", c.this.n, c.this.o);
            }
            String encodeTp4 = Jni.encodeTp4(this.f6730a);
            this.f6730a = null;
            this.k.put(BaseLocationBox.TYPE, encodeTp4);
            this.k.put("trtm", String.format(Locale.CHINA, "%d", Long.valueOf(System.currentTimeMillis())));
        }

        public void a(String str) {
            this.f6730a = str;
            b(com.baidu.location.d.j.f6990f);
        }

        @Override // com.baidu.location.d.e
        public void a(boolean z) {
            String str;
            BDLocation bDLocation;
            if (z && (str = this.j) != null) {
                try {
                    try {
                        bDLocation = new BDLocation(str);
                    } catch (Exception unused) {
                        bDLocation = new BDLocation();
                        bDLocation.setLocType(63);
                    }
                    if (bDLocation.getLocType() == 161) {
                        bDLocation.setCoorType(c.this.k.coorType);
                        bDLocation.setLocationID(Jni.en1(c.this.f6722a + ";" + c.this.f6723b + ";" + bDLocation.getTime()));
                        c.this.r = true;
                        c.this.l.onReceiveLocation(bDLocation);
                    }
                } catch (Exception unused2) {
                }
            }
            Map<String, Object> map = this.k;
            if (map != null) {
                map.clear();
            }
        }
    }

    /* renamed from: com.baidu.location.a.c$c  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0091c {

        /* renamed from: a  reason: collision with root package name */
        public List<ScanResult> f6732a;

        /* renamed from: c  reason: collision with root package name */
        public long f6734c;

        public C0091c(List<ScanResult> list) {
            this.f6732a = null;
            this.f6734c = 0L;
            this.f6732a = list;
            this.f6734c = System.currentTimeMillis();
            c();
        }

        private String b() {
            WifiInfo connectionInfo;
            if (c.this.f6728g == null || (connectionInfo = c.this.f6728g.getConnectionInfo()) == null) {
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

        /*  JADX ERROR: JadxOverflowException in pass: LoopRegionVisitor
            jadx.core.utils.exceptions.JadxOverflowException: LoopRegionVisitor.assignOnlyInLoop endless recursion
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:56)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:30)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:18)
            */
        private void c() {
            /*
                r7 = this;
                int r0 = r7.a()
                r1 = 1
                if (r0 >= r1) goto L8
                return
            L8:
                java.util.List<android.net.wifi.ScanResult> r0 = r7.f6732a
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
                java.util.List<android.net.wifi.ScanResult> r4 = r7.f6732a
                java.lang.Object r4 = r4.get(r2)
                android.net.wifi.ScanResult r4 = (android.net.wifi.ScanResult) r4
                int r4 = r4.level
                java.util.List<android.net.wifi.ScanResult> r5 = r7.f6732a
                int r6 = r2 + 1
                java.lang.Object r5 = r5.get(r6)
                android.net.wifi.ScanResult r5 = (android.net.wifi.ScanResult) r5
                int r5 = r5.level
                if (r4 >= r5) goto L47
                java.util.List<android.net.wifi.ScanResult> r3 = r7.f6732a
                java.lang.Object r3 = r3.get(r6)
                android.net.wifi.ScanResult r3 = (android.net.wifi.ScanResult) r3
                java.util.List<android.net.wifi.ScanResult> r4 = r7.f6732a
                java.lang.Object r5 = r4.get(r2)
                r4.set(r6, r5)
                java.util.List<android.net.wifi.ScanResult> r4 = r7.f6732a
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
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.a.c.C0091c.c():void");
        }

        public int a() {
            List<ScanResult> list = this.f6732a;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x004b  */
        /* JADX WARN: Removed duplicated region for block: B:43:0x00d3  */
        /* JADX WARN: Removed duplicated region for block: B:48:0x00dd  */
        /* JADX WARN: Removed duplicated region for block: B:53:0x00ed  */
        /* JADX WARN: Removed duplicated region for block: B:55:0x00f7 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:57:0x00f9  */
        /* JADX WARN: Removed duplicated region for block: B:84:0x00e7 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:85:0x00e9 A[EDGE_INSN: B:85:0x00e9->B:51:0x00e9 ?: BREAK  , SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public String a(int i2) {
            long j;
            boolean z;
            int size;
            int i3;
            boolean z2;
            String str;
            int i4;
            String str2;
            int i5;
            long j2;
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
                    size = this.f6732a.size();
                    String b2 = b();
                    long j3 = 0;
                    i3 = 0;
                    int i7 = 0;
                    z2 = true;
                    int i8 = 0;
                    int i9 = 0;
                    while (true) {
                        if (i3 < size) {
                            str = "";
                            break;
                        }
                        if (this.f6732a.get(i3).level == 0) {
                            i5 = size;
                        } else {
                            i7++;
                            if (z2) {
                                stringBuffer.append("&wf=");
                                z2 = false;
                            } else {
                                stringBuffer.append(FieldBuilder.SE);
                            }
                            String replace = this.f6732a.get(i3).BSSID.replace(":", "");
                            stringBuffer.append(replace);
                            if (b2 != null && replace.equals(b2)) {
                                i9 = i7;
                            }
                            int i10 = this.f6732a.get(i3).level;
                            if (i10 < 0) {
                                i10 = -i10;
                            }
                            Locale locale = Locale.CHINA;
                            i5 = size;
                            Object[] objArr = new Object[i6];
                            objArr[0] = Integer.valueOf(i10);
                            stringBuffer.append(String.format(locale, ";%d;", objArr));
                            int i11 = i8 + 1;
                            if (z) {
                                try {
                                    str = "";
                                } catch (Throwable unused2) {
                                    str = "";
                                }
                                try {
                                    j2 = (j - this.f6732a.get(i3).timestamp) / 1000000;
                                } catch (Throwable unused3) {
                                    j2 = 0;
                                    arrayList.add(Long.valueOf(j2));
                                    if (j2 > j3) {
                                    }
                                    if (i11 <= i2) {
                                    }
                                }
                                arrayList.add(Long.valueOf(j2));
                                if (j2 > j3) {
                                    j3 = j2;
                                }
                            } else {
                                str = "";
                            }
                            if (i11 <= i2) {
                                break;
                            }
                            i8 = i11;
                        }
                        i3++;
                        size = i5;
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
                                    str2 = str;
                                    z3 = false;
                                } else {
                                    long longValue = l2.longValue() - l.longValue();
                                    if (longValue != 0) {
                                        StringBuilder sb = new StringBuilder();
                                        str2 = str;
                                        sb.append(str2);
                                        sb.append(longValue);
                                        stringBuffer2.append(sb.toString());
                                    } else {
                                        str2 = str;
                                    }
                                }
                                stringBuffer2.append(FieldBuilder.SE);
                                str = str2;
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
            size = this.f6732a.size();
            String b22 = b();
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
                size = i5;
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
        String str;
        String str2;
        this.f6725d = null;
        this.f6726e = null;
        this.f6728g = null;
        this.j = null;
        this.n = null;
        this.o = null;
        this.f6722a = null;
        this.f6723b = null;
        this.p = false;
        this.f6725d = context.getApplicationContext();
        this.p = true;
        if (1 != 0) {
            this.k = new LocationClientOption(locationClientOption);
            this.l = aVar;
            this.f6722a = this.f6725d.getPackageName();
            this.f6723b = null;
            try {
                TelephonyManager telephonyManager = (TelephonyManager) this.f6725d.getSystemService("phone");
                this.f6726e = telephonyManager;
                str = telephonyManager.getDeviceId();
                try {
                    this.f6728g = (WifiManager) this.f6725d.getApplicationContext().getSystemService("wifi");
                } catch (Exception unused) {
                }
            } catch (Exception unused2) {
                str = null;
            }
            try {
                this.f6723b = CommonParam.a(this.f6725d);
            } catch (Throwable unused3) {
                this.f6723b = null;
                this.f6726e = null;
                this.f6728g = null;
            }
            if (this.f6723b != null) {
                com.baidu.location.d.j.o = "" + this.f6723b;
                str2 = "&prod=" + this.k.prodName + ":" + this.f6722a + "|&cu=" + this.f6723b + "&coor=" + locationClientOption.getCoorType();
            } else {
                str2 = "&prod=" + this.k.prodName + ":" + this.f6722a + "|&im=" + str + "&coor=" + locationClientOption.getCoorType();
            }
            this.j = str2;
            StringBuffer stringBuffer = new StringBuffer(256);
            stringBuffer.append("&fw=");
            stringBuffer.append("7.63");
            stringBuffer.append("&sdk=");
            stringBuffer.append("7.63");
            stringBuffer.append("&lt=1");
            stringBuffer.append("&mb=");
            stringBuffer.append(Build.MODEL);
            stringBuffer.append("&resid=");
            stringBuffer.append(Constants.VIA_REPORT_TYPE_SET_AVATAR);
            locationClientOption.getAddrType();
            if (locationClientOption.getAddrType() != null && locationClientOption.getAddrType().equals("all")) {
                this.j += "&addr=allj";
            }
            if (locationClientOption.isNeedNewVersionRgc) {
                stringBuffer.append("&adtp=n2");
            }
            if (locationClientOption.isNeedAptag || locationClientOption.isNeedAptagd) {
                this.j += "&sema=";
                if (locationClientOption.isNeedAptag) {
                    this.j += "aptag|";
                }
                if (locationClientOption.isNeedAptagd) {
                    this.j += "aptagd|";
                }
                this.n = j.b(this.f6725d);
                this.o = j.c(this.f6725d);
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
        r1.f6877g = java.lang.System.currentTimeMillis();
     */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0117 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x011d A[Catch: Exception -> 0x015b, TRY_LEAVE, TryCatch #2 {Exception -> 0x015b, blocks: (B:38:0x0119, B:40:0x011d), top: B:50:0x0119 }] */
    @SuppressLint({"NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private com.baidu.location.b.a a(CellInfo cellInfo) {
        int asuLevel;
        int i2;
        int intValue = Integer.valueOf(Build.VERSION.SDK_INT).intValue();
        if (intValue < 17) {
            return null;
        }
        com.baidu.location.b.a aVar = new com.baidu.location.b.a();
        boolean z = false;
        if (!(cellInfo instanceof CellInfoGsm)) {
            if (!(cellInfo instanceof CellInfoCdma)) {
                if (cellInfo instanceof CellInfoLte) {
                    CellInfoLte cellInfoLte = (CellInfoLte) cellInfo;
                    CellIdentityLte cellIdentity = cellInfoLte.getCellIdentity();
                    aVar.f6873c = a(cellIdentity.getMcc());
                    aVar.f6874d = a(cellIdentity.getMnc());
                    aVar.f6871a = a(cellIdentity.getTac());
                    aVar.f6872b = a(cellIdentity.getCi());
                    aVar.f6879i = 'g';
                    asuLevel = cellInfoLte.getCellSignalStrength().getAsuLevel();
                }
                if (intValue >= 18) {
                    if (cellInfo instanceof CellInfoWcdma) {
                    }
                }
                aVar.f6877g = System.currentTimeMillis() - ((SystemClock.elapsedRealtimeNanos() - cellInfo.getTimeStamp()) / 1000000);
                return aVar;
            }
            CellInfoCdma cellInfoCdma = (CellInfoCdma) cellInfo;
            CellIdentityCdma cellIdentity2 = cellInfoCdma.getCellIdentity();
            aVar.f6875e = cellIdentity2.getLatitude();
            aVar.f6876f = cellIdentity2.getLongitude();
            aVar.f6874d = a(cellIdentity2.getSystemId());
            aVar.f6871a = a(cellIdentity2.getNetworkId());
            aVar.f6872b = a(cellIdentity2.getBasestationId());
            aVar.f6879i = 'c';
            aVar.f6878h = cellInfoCdma.getCellSignalStrength().getCdmaDbm();
            com.baidu.location.b.a aVar2 = this.f6727f;
            if (aVar2 == null || (i2 = aVar2.f6873c) <= 0) {
                i2 = -1;
                try {
                    String networkOperator = this.f6726e.getNetworkOperator();
                    if (networkOperator != null && networkOperator.length() > 0 && networkOperator.length() >= 3) {
                        int intValue2 = Integer.valueOf(networkOperator.substring(0, 3)).intValue();
                        if (intValue2 >= 0) {
                            i2 = intValue2;
                        }
                    }
                } catch (Exception unused) {
                }
            }
            aVar.f6873c = i2;
            z = true;
            if (intValue >= 18 && !z) {
                try {
                    if (cellInfo instanceof CellInfoWcdma) {
                        CellIdentityWcdma cellIdentity3 = ((CellInfoWcdma) cellInfo).getCellIdentity();
                        aVar.f6873c = a(cellIdentity3.getMcc());
                        aVar.f6874d = a(cellIdentity3.getMnc());
                        aVar.f6871a = a(cellIdentity3.getLac());
                        aVar.f6872b = a(cellIdentity3.getCid());
                        aVar.f6879i = 'g';
                        aVar.f6878h = ((CellInfoWcdma) cellInfo).getCellSignalStrength().getAsuLevel();
                    }
                } catch (Exception unused2) {
                }
            }
            aVar.f6877g = System.currentTimeMillis() - ((SystemClock.elapsedRealtimeNanos() - cellInfo.getTimeStamp()) / 1000000);
            return aVar;
        }
        CellInfoGsm cellInfoGsm = (CellInfoGsm) cellInfo;
        CellIdentityGsm cellIdentity4 = cellInfoGsm.getCellIdentity();
        aVar.f6873c = a(cellIdentity4.getMcc());
        aVar.f6874d = a(cellIdentity4.getMnc());
        aVar.f6871a = a(cellIdentity4.getLac());
        aVar.f6872b = a(cellIdentity4.getCid());
        aVar.f6879i = 'g';
        asuLevel = cellInfoGsm.getCellSignalStrength().getAsuLevel();
        aVar.f6878h = asuLevel;
        z = true;
        if (intValue >= 18) {
        }
        aVar.f6877g = System.currentTimeMillis() - ((SystemClock.elapsedRealtimeNanos() - cellInfo.getTimeStamp()) / 1000000);
        return aVar;
    }

    private void a(CellLocation cellLocation) {
        int i2;
        if (cellLocation == null || this.f6726e == null) {
            return;
        }
        com.baidu.location.b.a aVar = new com.baidu.location.b.a();
        String networkOperator = this.f6726e.getNetworkOperator();
        if (networkOperator != null && networkOperator.length() > 0) {
            try {
                if (networkOperator.length() >= 3) {
                    int intValue = Integer.valueOf(networkOperator.substring(0, 3)).intValue();
                    if (intValue < 0) {
                        intValue = this.f6727f.f6873c;
                    }
                    aVar.f6873c = intValue;
                }
                String substring = networkOperator.substring(3);
                if (substring != null) {
                    char[] charArray = substring.toCharArray();
                    i2 = 0;
                    while (i2 < charArray.length && Character.isDigit(charArray[i2])) {
                        i2++;
                    }
                } else {
                    i2 = 0;
                }
                int intValue2 = Integer.valueOf(substring.substring(0, i2)).intValue();
                if (intValue2 < 0) {
                    intValue2 = this.f6727f.f6874d;
                }
                aVar.f6874d = intValue2;
            } catch (Exception unused) {
            }
        }
        if (cellLocation instanceof GsmCellLocation) {
            GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
            aVar.f6871a = gsmCellLocation.getLac();
            aVar.f6872b = gsmCellLocation.getCid();
            aVar.f6879i = 'g';
        } else if (cellLocation instanceof CdmaCellLocation) {
            aVar.f6879i = 'c';
            if (f6721i == null) {
                try {
                    f6721i = Class.forName("android.telephony.cdma.CdmaCellLocation");
                } catch (Exception unused2) {
                    f6721i = null;
                    return;
                }
            }
            Class<?> cls = f6721i;
            if (cls != null && cls.isInstance(cellLocation)) {
                try {
                    int systemId = ((CdmaCellLocation) cellLocation).getSystemId();
                    if (systemId < 0) {
                        systemId = -1;
                    }
                    aVar.f6874d = systemId;
                    aVar.f6872b = ((CdmaCellLocation) cellLocation).getBaseStationId();
                    aVar.f6871a = ((CdmaCellLocation) cellLocation).getNetworkId();
                    int baseStationLatitude = ((CdmaCellLocation) cellLocation).getBaseStationLatitude();
                    if (baseStationLatitude < Integer.MAX_VALUE) {
                        aVar.f6875e = baseStationLatitude;
                    }
                    int baseStationLongitude = ((CdmaCellLocation) cellLocation).getBaseStationLongitude();
                    if (baseStationLongitude < Integer.MAX_VALUE) {
                        aVar.f6876f = baseStationLongitude;
                    }
                } catch (Exception unused3) {
                }
            }
        }
        if (aVar.b()) {
            this.f6727f = aVar;
        } else {
            this.f6727f = null;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(15:1|(2:2|3)|(9:8|9|(1:43)(1:13)|15|16|(1:20)|22|23|(2:(1:(1:31)(1:32))|(1:34)(4:35|(1:37)|38|39))(2:26|27))|44|9|(1:11)|43|15|16|(2:18|20)|22|23|(0)|(0)|(0)(0)) */
    /* JADX WARN: Can't wrap try/catch for region: R(16:1|2|3|(9:8|9|(1:43)(1:13)|15|16|(1:20)|22|23|(2:(1:(1:31)(1:32))|(1:34)(4:35|(1:37)|38|39))(2:26|27))|44|9|(1:11)|43|15|16|(2:18|20)|22|23|(0)|(0)|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0063, code lost:
        r5 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:32:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0082 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0083  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String b(int i2) {
        String str;
        String str2;
        com.baidu.location.b.a d2;
        try {
            d2 = d();
        } catch (Throwable unused) {
            str = null;
        }
        if (d2 != null && d2.b()) {
            this.f6727f = d2;
            str = (this.f6727f == null && this.f6727f.b()) ? this.f6727f.g() : null;
            if (!TextUtils.isEmpty(str) && this.f6727f.j != null) {
                str = str + this.f6727f.j;
            }
            this.f6729h = null;
            C0091c c0091c = new C0091c(this.f6728g.getScanResults());
            this.f6729h = c0091c;
            str2 = c0091c.a(i2);
            if (str != null && str2 == null) {
                this.m = null;
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
            this.m = str;
            if (this.j != null) {
                this.m += this.j;
            }
            return str + this.j;
        }
        a(this.f6726e.getCellLocation());
        if (this.f6727f == null) {
        }
        if (!TextUtils.isEmpty(str)) {
            str = str + this.f6727f.j;
        }
        this.f6729h = null;
        C0091c c0091c2 = new C0091c(this.f6728g.getScanResults());
        this.f6729h = c0091c2;
        str2 = c0091c2.a(i2);
        if (str != null) {
        }
        if (str2 != null) {
        }
        if (str != null) {
        }
    }

    @SuppressLint({"NewApi"})
    private com.baidu.location.b.a d() {
        if (Integer.valueOf(Build.VERSION.SDK_INT).intValue() < 17) {
            return null;
        }
        try {
            List<CellInfo> allCellInfo = this.f6726e.getAllCellInfo();
            if (allCellInfo == null || allCellInfo.size() <= 0) {
                return null;
            }
            com.baidu.location.b.a aVar = null;
            for (CellInfo cellInfo : allCellInfo) {
                if (cellInfo.isRegistered()) {
                    boolean z = aVar != null;
                    com.baidu.location.b.a a2 = a(cellInfo);
                    if (a2 != null) {
                        if (!a2.b()) {
                            a2 = null;
                        } else if (z) {
                            aVar.j = a2.h();
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

    public String a() {
        try {
            WifiInfo connectionInfo = this.f6728g.getConnectionInfo();
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
        String str = this.m;
        if (str != null && this.p) {
            this.f6724c.a(str);
        }
    }
}
