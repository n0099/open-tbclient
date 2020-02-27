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
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.android.bbalbs.common.util.CommonParam;
import com.baidu.location.BDLocation;
import com.baidu.location.Jni;
import com.baidu.location.LocationClientOption;
import com.baidu.searchbox.unitedscheme.SchemeCollecter;
import com.baidu.searchbox.v8engine.util.TimeUtils;
import com.googlecode.mp4parser.boxes.ultraviolet.BaseLocationBox;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
/* loaded from: classes8.dex */
public class c {
    private static Class<?> i = null;
    String a;
    String b;
    private Context d;
    private TelephonyManager e;
    private WifiManager g;
    private String j;
    private LocationClientOption k;
    private a l;
    private String n;
    private String o;
    private boolean p;
    private com.baidu.location.b.a f = new com.baidu.location.b.a();
    private C0110c h = null;
    private String m = null;
    b c = new b();
    private long q = 0;
    private boolean r = false;

    /* loaded from: classes8.dex */
    public interface a {
        void onReceiveLocation(BDLocation bDLocation);
    }

    /* loaded from: classes8.dex */
    class b extends com.baidu.location.d.e {
        String a = null;

        b() {
            this.k = new HashMap();
        }

        @Override // com.baidu.location.d.e
        public void a() {
            this.h = com.baidu.location.d.j.c();
            if (c.this.n != null && c.this.o != null) {
                this.a += String.format(Locale.CHINA, "&ki=%s&sn=%s", c.this.n, c.this.o);
            }
            String encodeTp4 = Jni.encodeTp4(this.a);
            this.a = null;
            this.k.put(BaseLocationBox.TYPE, encodeTp4);
            this.k.put("trtm", String.format(Locale.CHINA, "%d", Long.valueOf(System.currentTimeMillis())));
        }

        public void a(String str) {
            this.a = str;
            b(com.baidu.location.d.j.f);
        }

        @Override // com.baidu.location.d.e
        public void a(boolean z) {
            BDLocation bDLocation;
            if (z && this.j != null) {
                try {
                    try {
                        bDLocation = new BDLocation(this.j);
                    } catch (Exception e) {
                        bDLocation = new BDLocation();
                        bDLocation.setLocType(63);
                    }
                    if (bDLocation != null && bDLocation.getLocType() == 161) {
                        bDLocation.setCoorType(c.this.k.coorType);
                        bDLocation.setLocationID(Jni.en1(c.this.a + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR + c.this.b + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR + bDLocation.getTime()));
                        c.this.r = true;
                        c.this.l.onReceiveLocation(bDLocation);
                    }
                } catch (Exception e2) {
                }
            }
            if (this.k != null) {
                this.k.clear();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: com.baidu.location.a.c$c  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0110c {
        public List<ScanResult> a;
        private long c;

        public C0110c(List<ScanResult> list) {
            this.a = null;
            this.c = 0L;
            this.a = list;
            this.c = System.currentTimeMillis();
            c();
        }

        private String b() {
            WifiInfo connectionInfo;
            if (c.this.g == null || (connectionInfo = c.this.g.getConnectionInfo()) == null) {
                return null;
            }
            try {
                String bssid = connectionInfo.getBSSID();
                String replace = bssid != null ? bssid.replace(":", "") : null;
                if (replace == null || replace.length() == 12) {
                    return new String(replace);
                }
                return null;
            } catch (Exception e) {
                return null;
            }
        }

        private void c() {
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

        /* JADX WARN: Code restructure failed: missing block: B:36:0x00e4, code lost:
            if (r10 > r12) goto L30;
         */
        /* JADX WARN: Removed duplicated region for block: B:15:0x0047  */
        /* JADX WARN: Removed duplicated region for block: B:40:0x00ec  */
        /* JADX WARN: Removed duplicated region for block: B:42:0x00fb A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:46:0x010c  */
        /* JADX WARN: Removed duplicated region for block: B:73:0x019f A[SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public String a(int i) {
            boolean z;
            int size;
            boolean z2;
            int i2;
            int i3;
            int i4;
            long j;
            int i5;
            if (a() < 2) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            long j2 = 0;
            long j3 = 0;
            if (Build.VERSION.SDK_INT >= 19) {
                try {
                    j2 = SystemClock.elapsedRealtimeNanos() / 1000;
                } catch (Error e) {
                    j2 = 0;
                }
                if (j2 > 0) {
                    z = true;
                    StringBuffer stringBuffer = new StringBuffer(512);
                    size = this.a.size();
                    z2 = true;
                    i2 = 0;
                    String b = b();
                    int i6 = 0;
                    i3 = 0;
                    i4 = 0;
                    while (true) {
                        if (i4 < size) {
                            j = j3;
                            break;
                        }
                        if (this.a.get(i4).level == 0) {
                            i5 = i2;
                            j = j3;
                        } else {
                            i6++;
                            if (z2) {
                                stringBuffer.append("&wf=");
                                z2 = false;
                            } else {
                                stringBuffer.append("|");
                            }
                            String replace = this.a.get(i4).BSSID.replace(":", "");
                            stringBuffer.append(replace);
                            if (b != null && replace.equals(b)) {
                                i3 = i6;
                            }
                            int i7 = this.a.get(i4).level;
                            if (i7 < 0) {
                                i7 = -i7;
                            }
                            stringBuffer.append(String.format(Locale.CHINA, ";%d;", Integer.valueOf(i7)));
                            int i8 = i2 + 1;
                            if (z) {
                                try {
                                    j = (j2 - this.a.get(i4).timestamp) / TimeUtils.NANOS_PER_MS;
                                } catch (Throwable th) {
                                    j = 0;
                                }
                                arrayList.add(Long.valueOf(j));
                            }
                            j = j3;
                            if (i8 > i) {
                                break;
                            }
                            i5 = i8;
                        }
                        i4++;
                        j3 = j;
                        i2 = i5;
                    }
                    if (i3 > 0) {
                        stringBuffer.append("&wf_n=");
                        stringBuffer.append(i3);
                    }
                    if (z2) {
                        if (j > 10 && arrayList.size() > 0 && ((Long) arrayList.get(0)).longValue() > 0) {
                            StringBuffer stringBuffer2 = new StringBuffer(128);
                            stringBuffer2.append("&wf_ut=");
                            boolean z3 = true;
                            Long l = (Long) arrayList.get(0);
                            Iterator it = arrayList.iterator();
                            while (true) {
                                boolean z4 = z3;
                                if (!it.hasNext()) {
                                    break;
                                }
                                Long l2 = (Long) it.next();
                                if (z4) {
                                    z4 = false;
                                    stringBuffer2.append(l2.longValue());
                                } else {
                                    long longValue = l2.longValue() - l.longValue();
                                    if (longValue != 0) {
                                        stringBuffer2.append("" + longValue);
                                    }
                                }
                                z3 = z4;
                                stringBuffer2.append("|");
                            }
                            stringBuffer.append(stringBuffer2.toString());
                        }
                        return stringBuffer.toString();
                    }
                    return null;
                }
            }
            z = false;
            StringBuffer stringBuffer3 = new StringBuffer(512);
            size = this.a.size();
            z2 = true;
            i2 = 0;
            String b2 = b();
            int i62 = 0;
            i3 = 0;
            i4 = 0;
            while (true) {
                if (i4 < size) {
                }
                i4++;
                j3 = j;
                i2 = i5;
            }
            if (i3 > 0) {
            }
            if (z2) {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x01ed  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0234  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public c(Context context, LocationClientOption locationClientOption, a aVar) {
        String str;
        String str2;
        String a2;
        this.d = null;
        this.e = null;
        this.g = null;
        this.j = null;
        this.n = null;
        this.o = null;
        this.a = null;
        this.b = null;
        this.p = false;
        this.d = context.getApplicationContext();
        this.p = true;
        if (this.p) {
            this.k = new LocationClientOption(locationClientOption);
            this.l = aVar;
            this.a = this.d.getPackageName();
            this.b = null;
            try {
                this.e = (TelephonyManager) this.d.getSystemService("phone");
                str2 = this.e.getDeviceId();
                try {
                    this.g = (WifiManager) this.d.getApplicationContext().getSystemService("wifi");
                } catch (Exception e) {
                    str = str2;
                    str2 = str;
                    this.b = CommonParam.a(this.d);
                    if (this.b == null) {
                    }
                    StringBuffer stringBuffer = new StringBuffer(256);
                    stringBuffer.append("&fw=");
                    stringBuffer.append("7.63");
                    stringBuffer.append("&sdk=");
                    stringBuffer.append("7.63");
                    stringBuffer.append("&lt=1");
                    stringBuffer.append("&mb=");
                    stringBuffer.append(Build.MODEL);
                    stringBuffer.append("&resid=");
                    stringBuffer.append("12");
                    if (locationClientOption.getAddrType() == null) {
                    }
                    if (locationClientOption.getAddrType() != null) {
                        this.j += "&addr=allj";
                    }
                    if (locationClientOption.isNeedNewVersionRgc) {
                    }
                    if (!locationClientOption.isNeedAptag) {
                    }
                    this.j += "&sema=";
                    if (locationClientOption.isNeedAptag) {
                    }
                    if (locationClientOption.isNeedAptagd) {
                    }
                    this.n = j.b(this.d);
                    this.o = j.c(this.d);
                    stringBuffer.append("&first=1");
                    stringBuffer.append("&os=A");
                    stringBuffer.append(Build.VERSION.SDK);
                    this.j += stringBuffer.toString();
                    a2 = a();
                    if (TextUtils.isEmpty(a2)) {
                    }
                    if (!TextUtils.isEmpty(a2)) {
                        this.j += "&mac=" + a2;
                    }
                    b();
                }
            } catch (Exception e2) {
                str = null;
            }
            try {
                this.b = CommonParam.a(this.d);
            } catch (Throwable th) {
                this.b = null;
                this.e = null;
                this.g = null;
            }
            if (this.b == null) {
                com.baidu.location.d.j.o = "" + this.b;
                this.j = "&prod=" + this.k.prodName + ":" + this.a + "|&cu=" + this.b + "&coor=" + locationClientOption.getCoorType();
            } else {
                this.j = "&prod=" + this.k.prodName + ":" + this.a + "|&im=" + str2 + "&coor=" + locationClientOption.getCoorType();
            }
            StringBuffer stringBuffer2 = new StringBuffer(256);
            stringBuffer2.append("&fw=");
            stringBuffer2.append("7.63");
            stringBuffer2.append("&sdk=");
            stringBuffer2.append("7.63");
            stringBuffer2.append("&lt=1");
            stringBuffer2.append("&mb=");
            stringBuffer2.append(Build.MODEL);
            stringBuffer2.append("&resid=");
            stringBuffer2.append("12");
            if (locationClientOption.getAddrType() == null) {
            }
            if (locationClientOption.getAddrType() != null && locationClientOption.getAddrType().equals(SchemeCollecter.CLASSIFY_ALL)) {
                this.j += "&addr=allj";
            }
            if (locationClientOption.isNeedNewVersionRgc) {
                stringBuffer2.append("&adtp=n2");
            }
            if (!locationClientOption.isNeedAptag || locationClientOption.isNeedAptagd) {
                this.j += "&sema=";
                if (locationClientOption.isNeedAptag) {
                    this.j += "aptag|";
                }
                if (locationClientOption.isNeedAptagd) {
                    this.j += "aptagd|";
                }
                this.n = j.b(this.d);
                this.o = j.c(this.d);
            }
            stringBuffer2.append("&first=1");
            stringBuffer2.append("&os=A");
            stringBuffer2.append(Build.VERSION.SDK);
            this.j += stringBuffer2.toString();
            a2 = a();
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

    @SuppressLint({"NewApi"})
    private com.baidu.location.b.a a(CellInfo cellInfo) {
        boolean z = false;
        int i2 = -1;
        int intValue = Integer.valueOf(Build.VERSION.SDK_INT).intValue();
        if (intValue < 17) {
            return null;
        }
        com.baidu.location.b.a aVar = new com.baidu.location.b.a();
        if (cellInfo instanceof CellInfoGsm) {
            CellIdentityGsm cellIdentity = ((CellInfoGsm) cellInfo).getCellIdentity();
            aVar.c = a(cellIdentity.getMcc());
            aVar.d = a(cellIdentity.getMnc());
            aVar.a = a(cellIdentity.getLac());
            aVar.b = a(cellIdentity.getCid());
            aVar.i = 'g';
            aVar.h = ((CellInfoGsm) cellInfo).getCellSignalStrength().getAsuLevel();
            z = true;
        } else if (cellInfo instanceof CellInfoCdma) {
            CellIdentityCdma cellIdentity2 = ((CellInfoCdma) cellInfo).getCellIdentity();
            aVar.e = cellIdentity2.getLatitude();
            aVar.f = cellIdentity2.getLongitude();
            aVar.d = a(cellIdentity2.getSystemId());
            aVar.a = a(cellIdentity2.getNetworkId());
            aVar.b = a(cellIdentity2.getBasestationId());
            aVar.i = 'c';
            aVar.h = ((CellInfoCdma) cellInfo).getCellSignalStrength().getCdmaDbm();
            if (this.f == null || this.f.c <= 0) {
                try {
                    String networkOperator = this.e.getNetworkOperator();
                    if (networkOperator != null && networkOperator.length() > 0 && networkOperator.length() >= 3) {
                        int intValue2 = Integer.valueOf(networkOperator.substring(0, 3)).intValue();
                        if (intValue2 < 0) {
                            intValue2 = -1;
                        }
                        i2 = intValue2;
                    }
                } catch (Exception e) {
                }
                if (i2 > 0) {
                    aVar.c = i2;
                }
            } else {
                aVar.c = this.f.c;
            }
            z = true;
        } else if (cellInfo instanceof CellInfoLte) {
            CellIdentityLte cellIdentity3 = ((CellInfoLte) cellInfo).getCellIdentity();
            aVar.c = a(cellIdentity3.getMcc());
            aVar.d = a(cellIdentity3.getMnc());
            aVar.a = a(cellIdentity3.getTac());
            aVar.b = a(cellIdentity3.getCi());
            aVar.i = 'g';
            aVar.h = ((CellInfoLte) cellInfo).getCellSignalStrength().getAsuLevel();
            z = true;
        }
        if (intValue >= 18 && !z) {
            try {
                if (cellInfo instanceof CellInfoWcdma) {
                    CellIdentityWcdma cellIdentity4 = ((CellInfoWcdma) cellInfo).getCellIdentity();
                    aVar.c = a(cellIdentity4.getMcc());
                    aVar.d = a(cellIdentity4.getMnc());
                    aVar.a = a(cellIdentity4.getLac());
                    aVar.b = a(cellIdentity4.getCid());
                    aVar.i = 'g';
                    aVar.h = ((CellInfoWcdma) cellInfo).getCellSignalStrength().getAsuLevel();
                }
            } catch (Exception e2) {
            }
        }
        try {
            aVar.g = System.currentTimeMillis() - ((SystemClock.elapsedRealtimeNanos() - cellInfo.getTimeStamp()) / TimeUtils.NANOS_PER_MS);
        } catch (Error e3) {
            aVar.g = System.currentTimeMillis();
        }
        return aVar;
    }

    private void a(CellLocation cellLocation) {
        int i2 = 0;
        if (cellLocation == null || this.e == null) {
            return;
        }
        com.baidu.location.b.a aVar = new com.baidu.location.b.a();
        String networkOperator = this.e.getNetworkOperator();
        if (networkOperator != null && networkOperator.length() > 0) {
            try {
                if (networkOperator.length() >= 3) {
                    int intValue = Integer.valueOf(networkOperator.substring(0, 3)).intValue();
                    if (intValue < 0) {
                        intValue = this.f.c;
                    }
                    aVar.c = intValue;
                }
                String substring = networkOperator.substring(3);
                if (substring != null) {
                    char[] charArray = substring.toCharArray();
                    while (i2 < charArray.length && Character.isDigit(charArray[i2])) {
                        i2++;
                    }
                }
                int intValue2 = Integer.valueOf(substring.substring(0, i2)).intValue();
                if (intValue2 < 0) {
                    intValue2 = this.f.d;
                }
                aVar.d = intValue2;
            } catch (Exception e) {
            }
        }
        if (cellLocation instanceof GsmCellLocation) {
            aVar.a = ((GsmCellLocation) cellLocation).getLac();
            aVar.b = ((GsmCellLocation) cellLocation).getCid();
            aVar.i = 'g';
        } else if (cellLocation instanceof CdmaCellLocation) {
            aVar.i = 'c';
            if (i == null) {
                try {
                    i = Class.forName("android.telephony.cdma.CdmaCellLocation");
                } catch (Exception e2) {
                    i = null;
                    return;
                }
            }
            if (i != null && i.isInstance(cellLocation)) {
                try {
                    int systemId = ((CdmaCellLocation) cellLocation).getSystemId();
                    if (systemId < 0) {
                        systemId = -1;
                    }
                    aVar.d = systemId;
                    aVar.b = ((CdmaCellLocation) cellLocation).getBaseStationId();
                    aVar.a = ((CdmaCellLocation) cellLocation).getNetworkId();
                    int baseStationLatitude = ((CdmaCellLocation) cellLocation).getBaseStationLatitude();
                    if (baseStationLatitude < Integer.MAX_VALUE) {
                        aVar.e = baseStationLatitude;
                    }
                    int baseStationLongitude = ((CdmaCellLocation) cellLocation).getBaseStationLongitude();
                    if (baseStationLongitude < Integer.MAX_VALUE) {
                        aVar.f = baseStationLongitude;
                    }
                } catch (Exception e3) {
                }
            }
        }
        if (aVar.b()) {
            this.f = aVar;
        } else {
            this.f = null;
        }
    }

    private String b(int i2) {
        String str;
        String str2;
        try {
            com.baidu.location.b.a d = d();
            if (d == null || !d.b()) {
                a(this.e.getCellLocation());
            } else {
                this.f = d;
            }
            str = (this.f == null || !this.f.b()) ? null : this.f.g();
            try {
                if (!TextUtils.isEmpty(str) && this.f.j != null) {
                    str = str + this.f.j;
                }
            } catch (Throwable th) {
            }
        } catch (Throwable th2) {
            str = null;
        }
        try {
            this.h = null;
            this.h = new C0110c(this.g.getScanResults());
            str2 = this.h.a(i2);
        } catch (Exception e) {
            str2 = null;
        }
        if (str == null && str2 == null) {
            this.m = null;
            return null;
        }
        if (str2 != null) {
            str = str == null ? str2 : str + str2;
        }
        if (str == null) {
            return null;
        }
        this.m = str;
        if (this.j != null) {
            this.m += this.j;
        }
        return str + this.j;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0047, code lost:
        if (r1 == null) goto L26;
     */
    @SuppressLint({"NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private com.baidu.location.b.a d() {
        com.baidu.location.b.a aVar;
        if (Integer.valueOf(Build.VERSION.SDK_INT).intValue() < 17) {
            return null;
        }
        try {
            List<CellInfo> allCellInfo = this.e.getAllCellInfo();
            if (allCellInfo == null || allCellInfo.size() <= 0) {
                return null;
            }
            com.baidu.location.b.a aVar2 = null;
            for (CellInfo cellInfo : allCellInfo) {
                if (cellInfo.isRegistered()) {
                    boolean z = aVar2 != null;
                    aVar = a(cellInfo);
                    if (aVar == null) {
                        continue;
                    } else if (!aVar.b()) {
                        aVar = null;
                    } else if (z) {
                        aVar2.j = aVar.h();
                        return aVar2;
                    }
                }
                aVar = aVar2;
                aVar2 = aVar;
            }
            return aVar2;
        } catch (Throwable th) {
            return null;
        }
    }

    public String a() {
        try {
            WifiInfo connectionInfo = this.g.getConnectionInfo();
            if (connectionInfo != null) {
                return connectionInfo.getMacAddress();
            }
            return null;
        } catch (Error e) {
            return null;
        } catch (Exception e2) {
            return null;
        }
    }

    public String b() {
        try {
            return b(15);
        } catch (Exception e) {
            return null;
        }
    }

    public void c() {
        if (this.m != null && this.p && 0 == 0) {
            this.c.a(this.m);
        }
    }
}
