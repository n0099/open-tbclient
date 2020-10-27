package com.baidu.location.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.os.SystemClock;
import android.telephony.CellIdentityCdma;
import android.telephony.CellIdentityGsm;
import android.telephony.CellIdentityLte;
import android.telephony.CellIdentityNr;
import android.telephony.CellIdentityTdscdma;
import android.telephony.CellIdentityWcdma;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoNr;
import android.telephony.CellInfoTdscdma;
import android.telephony.CellInfoWcdma;
import android.telephony.CellLocation;
import android.telephony.CellSignalStrengthNr;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.text.TextUtils;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.fsg.base.widget.textfilter.EditTextPasteFilterUtils;
import com.baidu.lbsapi.auth.LBSAuthManager;
import com.baidu.location.BDLocation;
import com.baidu.location.Jni;
import com.baidu.location.LocationClientOption;
import com.baidu.searchbox.v8engine.util.TimeUtils;
import com.baidu.webkit.internal.ETAG;
import com.googlecode.mp4parser.boxes.ultraviolet.BaseLocationBox;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Timer;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class d {
    private static Class<?> i = null;
    private static char[] r = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_.".toCharArray();

    /* renamed from: a  reason: collision with root package name */
    String f1875a;
    String b;
    private Context d;
    private TelephonyManager e;
    private WifiManager g;
    private String j;
    private String k;
    private LocationClientOption l;
    private a m;
    private String o;
    private String p;
    private boolean q;
    private com.baidu.location.c.a f = new com.baidu.location.c.a();
    private C0234d h = null;
    private String n = null;
    b c = new b();
    private int s = 16;
    private boolean t = false;
    private long u = 0;
    private boolean v = false;

    /* loaded from: classes7.dex */
    public interface a {
        void onReceiveLocation(BDLocation bDLocation);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public class b extends com.baidu.location.e.f {
        LocationManager b;
        a c;

        /* renamed from: a  reason: collision with root package name */
        String f1876a = null;
        boolean d = false;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes7.dex */
        public class a implements LocationListener {
            private a() {
            }

            /* synthetic */ a(b bVar, e eVar) {
                this();
            }

            @Override // android.location.LocationListener
            public void onLocationChanged(Location location) {
                b.this.c();
                b.this.d = true;
            }

            @Override // android.location.LocationListener
            public void onProviderDisabled(String str) {
            }

            @Override // android.location.LocationListener
            public void onProviderEnabled(String str) {
            }

            @Override // android.location.LocationListener
            public void onStatusChanged(String str, int i, Bundle bundle) {
            }
        }

        b() {
            this.k = new HashMap();
        }

        private void b() {
            try {
                this.b = (LocationManager) d.this.d.getSystemService("location");
                this.c = new a(this, null);
                if (this.b == null || this.c == null) {
                    return;
                }
                try {
                    this.b.requestLocationUpdates("network", 1000L, 0.0f, this.c, Looper.getMainLooper());
                } catch (SecurityException e) {
                    e.printStackTrace();
                }
            } catch (Throwable th) {
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c() {
            if (this.c == null || this.b == null) {
                return;
            }
            try {
                this.b.removeUpdates(this.c);
            } catch (Exception e) {
            }
        }

        @Override // com.baidu.location.e.f
        public void a() {
            this.h = com.baidu.location.e.l.e();
            if (d.this.o != null && d.this.p != null) {
                this.f1876a += String.format(Locale.CHINA, "&ki=%s&sn=%s", d.this.o, d.this.p);
            }
            this.f1876a += "&enc=2";
            String encodeTp4 = Jni.encodeTp4(this.f1876a);
            this.f1876a = null;
            this.k.put(BaseLocationBox.TYPE, encodeTp4);
            this.k.put("trtm", String.format(Locale.CHINA, "%d", Long.valueOf(System.currentTimeMillis())));
        }

        public void a(String str) {
            this.f1876a = str;
            b(com.baidu.location.e.l.f);
            if (d.this.t) {
                b();
                Timer timer = new Timer();
                timer.schedule(new f(this, timer), 10000L);
                SharedPreferences.Editor edit = d.this.d.getSharedPreferences("cuidRelate", 0).edit();
                edit.putLong("reqtime", System.currentTimeMillis());
                edit.apply();
            }
        }

        @Override // com.baidu.location.e.f
        public void a(boolean z) {
            BDLocation bDLocation;
            if (!z || this.j == null) {
                d.this.c(63);
            } else {
                try {
                    String str = this.j;
                    if (str.contains("\"enc\"")) {
                        try {
                            JSONObject jSONObject = new JSONObject(str);
                            if (jSONObject.has("enc")) {
                                str = m.a().b(jSONObject.getString("enc"));
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    try {
                        BDLocation bDLocation2 = new BDLocation(str);
                        d.this.a(str);
                        bDLocation = bDLocation2;
                    } catch (Exception e2) {
                        bDLocation = new BDLocation();
                        bDLocation.setLocType(63);
                    }
                    if (bDLocation != null && bDLocation.getLocType() == 161) {
                        bDLocation.setCoorType(d.this.l.coorType);
                        bDLocation.setLocationID(Jni.en1(d.this.f1875a + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR + d.this.b + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR + bDLocation.getTime()));
                        bDLocation.setRoadLocString(0.0f, 0.0f);
                        d.this.v = true;
                        d.this.m.onReceiveLocation(bDLocation);
                    } else if (bDLocation != null) {
                        d.this.c(bDLocation.getLocType());
                    } else {
                        d.this.c(167);
                    }
                } catch (Exception e3) {
                    d.this.c(63);
                    e3.printStackTrace();
                }
            }
            if (this.k != null) {
                this.k.clear();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class c {

        /* renamed from: a  reason: collision with root package name */
        public String f1878a;
        public int b;

        c(String str, int i) {
            this.f1878a = str;
            this.b = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: com.baidu.location.b.d$d  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0234d {

        /* renamed from: a  reason: collision with root package name */
        public List<ScanResult> f1879a;
        private long d;
        public String b = null;
        private String e = null;

        public C0234d(List<ScanResult> list) {
            this.f1879a = null;
            this.d = 0L;
            this.f1879a = list;
            this.d = System.currentTimeMillis();
            try {
                b();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        private void b() {
            boolean z;
            if (a() < 1) {
                return;
            }
            boolean z2 = true;
            for (int size = this.f1879a.size() - 1; size >= 1 && z2; size--) {
                int i = 0;
                z2 = false;
                while (i < size) {
                    if (this.f1879a.get(i) == null || this.f1879a.get(i + 1) == null || this.f1879a.get(i).level >= this.f1879a.get(i + 1).level) {
                        z = z2;
                    } else {
                        this.f1879a.set(i + 1, this.f1879a.get(i));
                        this.f1879a.set(i, this.f1879a.get(i + 1));
                        z = true;
                    }
                    i++;
                    z2 = z;
                }
            }
        }

        public int a() {
            if (this.f1879a == null) {
                return 0;
            }
            return this.f1879a.size();
        }

        /* JADX WARN: Code restructure failed: missing block: B:38:0x00f7, code lost:
            if (r10 > r12) goto L32;
         */
        /* JADX WARN: Removed duplicated region for block: B:15:0x0050  */
        /* JADX WARN: Removed duplicated region for block: B:43:0x0107  */
        /* JADX WARN: Removed duplicated region for block: B:47:0x011b  */
        /* JADX WARN: Removed duplicated region for block: B:95:0x023e A[SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public String a(int i, String str) {
            boolean z;
            int size;
            int i2;
            int i3;
            long j;
            int i4;
            if (a() < 1) {
                return null;
            }
            d.this.s = com.baidu.location.b.a.a().b;
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
                    size = this.f1879a.size();
                    boolean z2 = true;
                    i2 = 0;
                    int i5 = 0;
                    int i6 = 0;
                    i3 = 0;
                    while (true) {
                        if (i3 < size) {
                            j = j3;
                            break;
                        }
                        if (this.f1879a.get(i3) == null) {
                            i4 = i2;
                            j = j3;
                        } else if (this.f1879a.get(i3).level == 0) {
                            i4 = i2;
                            j = j3;
                        } else {
                            i5++;
                            if (z2) {
                                stringBuffer.append("&wf=");
                                z2 = false;
                            } else {
                                stringBuffer.append("|");
                            }
                            String replace = this.f1879a.get(i3).BSSID.replace(":", "");
                            stringBuffer.append(replace);
                            if (str != null && replace.equals(str)) {
                                i6 = i5;
                            }
                            int i7 = this.f1879a.get(i3).level;
                            if (i7 < 0) {
                                i7 = -i7;
                            }
                            stringBuffer.append(String.format(Locale.CHINA, ";%d;", Integer.valueOf(i7)));
                            i2++;
                            if (z) {
                                try {
                                    j = (j2 - this.f1879a.get(i3).timestamp) / TimeUtils.NANOS_PER_MS;
                                } catch (Throwable th) {
                                    j = 0;
                                }
                                arrayList.add(Long.valueOf(j));
                            }
                            j = j3;
                            if (i2 > i) {
                                break;
                            }
                            i4 = i2;
                        }
                        i3++;
                        j3 = j;
                        i2 = i4;
                    }
                    if (d.this.t) {
                        if (i6 > 0) {
                            stringBuffer.append("&wf_n=");
                            stringBuffer.append(i6);
                        }
                        if (i2 > i && d.this.s > i + 1) {
                            for (int i8 = i2; i8 < size; i8++) {
                                if (i8 == i2) {
                                    stringBuffer.append("&wf2=");
                                } else {
                                    stringBuffer.append("|");
                                }
                                stringBuffer.append(this.f1879a.get(i8).BSSID.replace(":", ""));
                                int i9 = this.f1879a.get(i8).level;
                                if (i9 < 0) {
                                    i9 = -i9;
                                }
                                stringBuffer.append(String.format(Locale.CHINA, ";%d;", Integer.valueOf(i9)));
                                if (i8 >= d.this.s) {
                                    break;
                                }
                            }
                        }
                        if (z2) {
                            return null;
                        }
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
                    return stringBuffer.toString();
                }
            }
            z = false;
            StringBuffer stringBuffer3 = new StringBuffer(512);
            size = this.f1879a.size();
            boolean z22 = true;
            i2 = 0;
            int i52 = 0;
            int i62 = 0;
            i3 = 0;
            while (true) {
                if (i3 < size) {
                }
                i3++;
                j3 = j;
                i2 = i4;
            }
            if (d.this.t) {
            }
        }
    }

    public d(Context context, LocationClientOption locationClientOption, a aVar) {
        this.d = null;
        this.e = null;
        this.g = null;
        this.j = null;
        this.k = null;
        this.o = null;
        this.p = null;
        this.f1875a = null;
        this.b = null;
        this.q = false;
        this.d = context.getApplicationContext();
        try {
            com.baidu.location.e.l.ax = this.d.getPackageName();
        } catch (Exception e) {
        }
        this.q = true;
        if (this.q) {
            this.l = new LocationClientOption(locationClientOption);
            this.m = aVar;
            this.f1875a = this.d.getPackageName();
            this.b = null;
            try {
                this.e = (TelephonyManager) this.d.getSystemService("phone");
                this.g = (WifiManager) this.d.getApplicationContext().getSystemService("wifi");
            } catch (Exception e2) {
            }
            this.k = ETAG.ITEM_SEPARATOR + this.f1875a + ETAG.ITEM_SEPARATOR + ((String) null);
            try {
                this.b = LBSAuthManager.getInstance(this.d).getCUID();
            } catch (Throwable th) {
                this.b = null;
                this.e = null;
                this.g = null;
            }
            if (this.b != null) {
                com.baidu.location.e.l.o = "" + this.b;
                this.j = "&prod=" + this.l.prodName + ":" + this.f1875a + "|&cu=" + this.b + "&coor=" + locationClientOption.getCoorType();
            } else {
                this.j = "&prod=" + this.l.prodName + ":" + this.f1875a + "|&im=" + ((String) null) + "&coor=" + locationClientOption.getCoorType();
            }
            StringBuffer stringBuffer = new StringBuffer(256);
            stringBuffer.append("&fw=");
            stringBuffer.append("9.02");
            stringBuffer.append("&sdk=");
            stringBuffer.append("9.02");
            stringBuffer.append("&lt=1");
            stringBuffer.append("&mb=");
            stringBuffer.append(Build.MODEL);
            stringBuffer.append("&resid=");
            stringBuffer.append("12");
            if (locationClientOption.getAddrType() != null) {
            }
            if (locationClientOption.getAddrType() != null && locationClientOption.getAddrType().equals("all")) {
                this.j += "&addr=allj2";
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
                    this.j += "aptagd2|";
                }
                this.o = com.baidu.location.a.a.b(this.d);
                this.p = com.baidu.location.a.a.c(this.d);
            }
            stringBuffer.append("&first=1");
            stringBuffer.append("&os=A");
            stringBuffer.append(Build.VERSION.SDK);
            this.j += stringBuffer.toString();
        }
    }

    private int a(int i2) {
        if (i2 == Integer.MAX_VALUE) {
            return -1;
        }
        return i2;
    }

    @SuppressLint({"NewApi"})
    private com.baidu.location.c.a a(CellInfo cellInfo) {
        CellIdentityNr cellIdentityNr;
        int i2 = -1;
        boolean z = false;
        int intValue = Integer.valueOf(Build.VERSION.SDK_INT).intValue();
        if (intValue < 17) {
            return null;
        }
        com.baidu.location.c.a aVar = new com.baidu.location.c.a();
        if (cellInfo instanceof CellInfoGsm) {
            CellIdentityGsm cellIdentity = ((CellInfoGsm) cellInfo).getCellIdentity();
            aVar.c = a(cellIdentity.getMcc());
            aVar.d = a(cellIdentity.getMnc());
            aVar.f1919a = a(cellIdentity.getLac());
            aVar.b = a(cellIdentity.getCid());
            aVar.i = 'g';
            aVar.h = ((CellInfoGsm) cellInfo).getCellSignalStrength().getAsuLevel();
            aVar.k = 2;
            z = true;
        } else if (cellInfo instanceof CellInfoCdma) {
            CellIdentityCdma cellIdentity2 = ((CellInfoCdma) cellInfo).getCellIdentity();
            aVar.e = cellIdentity2.getLatitude();
            aVar.f = cellIdentity2.getLongitude();
            aVar.d = a(cellIdentity2.getSystemId());
            aVar.f1919a = a(cellIdentity2.getNetworkId());
            aVar.b = a(cellIdentity2.getBasestationId());
            aVar.i = 'c';
            aVar.h = ((CellInfoCdma) cellInfo).getCellSignalStrength().getCdmaDbm();
            aVar.k = 1;
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
            aVar.f1919a = a(cellIdentity3.getTac());
            aVar.b = a(cellIdentity3.getCi());
            aVar.i = 'g';
            aVar.h = ((CellInfoLte) cellInfo).getCellSignalStrength().getAsuLevel();
            aVar.k = 3;
            z = true;
        }
        if (intValue >= 18 && !z) {
            try {
                if (cellInfo instanceof CellInfoWcdma) {
                    CellIdentityWcdma cellIdentity4 = ((CellInfoWcdma) cellInfo).getCellIdentity();
                    aVar.c = a(cellIdentity4.getMcc());
                    aVar.d = a(cellIdentity4.getMnc());
                    aVar.f1919a = a(cellIdentity4.getLac());
                    aVar.b = a(cellIdentity4.getCid());
                    aVar.i = 'g';
                    aVar.h = ((CellInfoWcdma) cellInfo).getCellSignalStrength().getAsuLevel();
                    aVar.k = 4;
                } else if (Build.VERSION.SDK_INT >= 29) {
                    if (cellInfo instanceof CellInfoTdscdma) {
                        CellIdentityTdscdma cellIdentity5 = ((CellInfoTdscdma) cellInfo).getCellIdentity();
                        if (cellIdentity5.getMccString() != null) {
                            try {
                                aVar.c = Integer.valueOf(cellIdentity5.getMccString()).intValue();
                            } catch (Throwable th) {
                            }
                        }
                        if (cellIdentity5.getMncString() != null) {
                            try {
                                aVar.d = Integer.valueOf(cellIdentity5.getMncString()).intValue();
                            } catch (Throwable th2) {
                            }
                        }
                        aVar.f1919a = a(cellIdentity5.getLac());
                        aVar.b = a(cellIdentity5.getCid());
                        aVar.i = 'g';
                        aVar.h = ((CellInfoTdscdma) cellInfo).getCellSignalStrength().getAsuLevel();
                        aVar.k = 5;
                        if (Build.VERSION.SDK_INT >= 28) {
                            aVar.j = cellInfo.getCellConnectionStatus();
                        }
                    } else if ((cellInfo instanceof CellInfoNr) && (cellIdentityNr = (CellIdentityNr) ((CellInfoNr) cellInfo).getCellIdentity()) != null) {
                        if (cellIdentityNr.getMccString() != null) {
                            try {
                                aVar.c = Integer.valueOf(cellIdentityNr.getMccString()).intValue();
                            } catch (Throwable th3) {
                            }
                        }
                        if (cellIdentityNr.getMncString() != null) {
                            try {
                                aVar.d = Integer.valueOf(cellIdentityNr.getMncString()).intValue();
                            } catch (Throwable th4) {
                            }
                        }
                        aVar.f1919a = a(cellIdentityNr.getTac());
                        if (cellIdentityNr.getNci() != Long.MAX_VALUE) {
                            aVar.b = cellIdentityNr.getNci();
                        }
                        aVar.i = 'g';
                        aVar.k = 6;
                        if (Build.VERSION.SDK_INT >= 28) {
                            aVar.j = cellInfo.getCellConnectionStatus();
                        }
                        CellSignalStrengthNr cellSignalStrengthNr = (CellSignalStrengthNr) ((CellInfoNr) cellInfo).getCellSignalStrength();
                        aVar.h = cellSignalStrengthNr.getAsuLevel();
                        aVar.m = String.format(Locale.US, "%d|%d|%d|%d|%d|%d|%d|%d", Integer.valueOf(cellSignalStrengthNr.getCsiRsrp()), Integer.valueOf(cellSignalStrengthNr.getCsiRsrq()), Integer.valueOf(cellSignalStrengthNr.getCsiSinr()), Integer.valueOf(cellSignalStrengthNr.getDbm()), Integer.valueOf(cellSignalStrengthNr.getLevel()), Integer.valueOf(cellSignalStrengthNr.getSsRsrp()), Integer.valueOf(cellSignalStrengthNr.getSsRsrq()), Integer.valueOf(cellSignalStrengthNr.getSsSinr()));
                    }
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

    private Object a(Object obj, String str) throws Exception {
        return obj.getClass().getField(str).get(obj);
    }

    private String a(List<WifiConfiguration> list) {
        ArrayList<c> arrayList;
        int i2;
        int i3 = 0;
        if (list == null || list.size() <= 0) {
            arrayList = null;
        } else {
            arrayList = new ArrayList();
            for (WifiConfiguration wifiConfiguration : list) {
                String str = wifiConfiguration.SSID;
                try {
                    i2 = ((Integer) a(wifiConfiguration, "numAssociation")).intValue();
                } catch (Throwable th) {
                    i2 = 0;
                }
                if (i2 > 0 && !TextUtils.isEmpty(str)) {
                    arrayList.add(new c(str, i2));
                }
            }
        }
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        if (arrayList.size() > 1) {
            Collections.sort(arrayList, new e(this));
        }
        StringBuffer stringBuffer = new StringBuffer(200);
        for (c cVar : arrayList) {
            stringBuffer.append(cVar.f1878a).append(Constants.ACCEPT_TIME_SEPARATOR_SP).append(cVar.b).append("|");
            int i4 = i3 + 1;
            if (i4 == 4) {
                break;
            }
            i3 = i4;
        }
        if (arrayList.size() >= 5) {
            stringBuffer.append(((c) arrayList.get(4)).f1878a).append(Constants.ACCEPT_TIME_SEPARATOR_SP).append(((c) arrayList.get(4)).b);
        }
        return stringBuffer.toString();
    }

    private void a(CellLocation cellLocation) {
        int i2 = 0;
        if (cellLocation == null || this.e == null) {
            return;
        }
        com.baidu.location.c.a aVar = new com.baidu.location.c.a();
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
                    int intValue2 = Integer.valueOf(substring.substring(0, i2)).intValue();
                    if (intValue2 < 0) {
                        intValue2 = this.f.d;
                    }
                    aVar.d = intValue2;
                }
            } catch (Exception e) {
            }
        }
        if (cellLocation instanceof GsmCellLocation) {
            aVar.f1919a = ((GsmCellLocation) cellLocation).getLac();
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
                    aVar.f1919a = ((CdmaCellLocation) cellLocation).getNetworkId();
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

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        String[] split;
        try {
            JSONObject jSONObject = new JSONObject(str).getJSONObject("content");
            String string = jSONObject.has("ideocfre") ? jSONObject.getString("ideocfre") : null;
            if (TextUtils.isEmpty(string) || !string.contains("|") || (split = string.split(EditTextPasteFilterUtils.EDITTEXT_PASTE_INTERCEPTOR_SEPERATOR)) == null || split.length < 2) {
                return;
            }
            int parseInt = Integer.parseInt(split[0]);
            long parseLong = Long.parseLong(split[1]);
            SharedPreferences.Editor edit = this.d.getSharedPreferences("cuidRelate", 0).edit();
            edit.putInt("cuidoc", parseInt);
            edit.putLong("cuidfreq", parseLong);
            edit.apply();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String b(int i2) {
        String str;
        String str2;
        try {
            com.baidu.location.c.a d = d();
            if (d != null && d.b()) {
                this.f = d;
            } else if (Build.VERSION.SDK_INT <= 28) {
                a(this.e.getCellLocation());
            }
            str = (this.f == null || !this.f.b()) ? null : this.f.h();
            try {
                if (!TextUtils.isEmpty(str) && this.f != null && this.f.l != null) {
                    str = str + this.f.l;
                }
            } catch (Throwable th) {
            }
        } catch (Throwable th2) {
            str = null;
        }
        try {
            this.h = null;
            if (e()) {
                this.h = new C0234d(this.g.getScanResults());
                str2 = this.h.a(i2, f());
                try {
                    if (this.l != null && this.l.isOnceLocation()) {
                        this.g.startScan();
                    }
                } catch (Exception e) {
                }
            } else {
                str2 = null;
            }
        } catch (Exception e2) {
            str2 = null;
        }
        if (str == null && str2 == null) {
            this.n = null;
            return null;
        }
        if (str2 != null) {
            str = str == null ? str2 : str + str2;
        }
        if (str != null) {
            this.n = str;
            if (this.j != null) {
                this.n += this.j;
            }
            h();
            return str + this.j;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i2) {
        if (this.l.isOnceLocation()) {
            BDLocation bDLocation = new BDLocation();
            bDLocation.setLocType(i2);
            if (this.m != null) {
                this.m.onReceiveLocation(bDLocation);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0047, code lost:
        if (r1 == null) goto L26;
     */
    @SuppressLint({"NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private com.baidu.location.c.a d() {
        com.baidu.location.c.a aVar;
        if (Integer.valueOf(Build.VERSION.SDK_INT).intValue() < 17) {
            return null;
        }
        try {
            List<CellInfo> allCellInfo = this.e.getAllCellInfo();
            if (allCellInfo == null || allCellInfo.size() <= 0) {
                return null;
            }
            com.baidu.location.c.a aVar2 = null;
            for (CellInfo cellInfo : allCellInfo) {
                if (cellInfo.isRegistered()) {
                    boolean z = aVar2 != null;
                    aVar = a(cellInfo);
                    if (aVar == null) {
                        continue;
                    } else if (!aVar.b()) {
                        aVar = null;
                    } else if (z && aVar2 != null) {
                        aVar2.l = aVar.i();
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

    private boolean e() {
        try {
            if (this.g.isWifiEnabled()) {
                return true;
            }
            if (Build.VERSION.SDK_INT > 17) {
                if (this.g.isScanAlwaysAvailable()) {
                    return true;
                }
            }
            return false;
        } catch (Throwable th) {
            return false;
        }
    }

    private String f() {
        if (this.g == null) {
            return null;
        }
        try {
            WifiInfo connectionInfo = this.g.getConnectionInfo();
            if (connectionInfo != null) {
                String bssid = connectionInfo.getBSSID();
                String replace = bssid != null ? bssid.replace(":", "") : null;
                if (replace == null || replace.length() == 12) {
                    return new String(replace);
                }
                return null;
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    private boolean g() {
        if (com.baidu.location.b.a.a().d == 0) {
            return false;
        }
        SharedPreferences sharedPreferences = this.d.getApplicationContext().getSharedPreferences("cuidRelate", 0);
        if (!sharedPreferences.contains("isInstalled")) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            if (!com.baidu.location.e.l.b(this.d, "com.baidu.map.location")) {
                edit.putInt("isInstalled", 0);
                return false;
            }
            edit.putInt("isInstalled", 1);
            edit.apply();
        } else if (sharedPreferences.getInt("isInstalled", -1) == 0) {
            return false;
        }
        return sharedPreferences.getInt("cuidoc", 1) != 0 && (System.currentTimeMillis() - sharedPreferences.getLong("reqtime", 0L)) / 1000 >= sharedPreferences.getLong("cuidfreq", 60L) && com.baidu.location.e.l.b(this.d) >= 2 && e() && this.h.a() > 3;
    }

    private void h() {
        String a2;
        if (!g()) {
            this.t = false;
            return;
        }
        this.t = true;
        if (this.h.a() >= 10) {
            String a3 = this.h.a(9, f());
            if (!TextUtils.isEmpty(a3)) {
                a2 = com.baidu.location.e.l.a(a3.getBytes(), false);
            }
            a2 = null;
        } else {
            String a4 = this.h.a(this.h.a(), f());
            if (!TextUtils.isEmpty(a4)) {
                a2 = com.baidu.location.e.l.a(a4.getBytes(), false);
            }
            a2 = null;
        }
        String a5 = a(i());
        String a6 = TextUtils.isEmpty(a5) ? null : com.baidu.location.e.l.a(a5.getBytes(), false);
        if (TextUtils.isEmpty(a2)) {
            this.t = false;
        } else {
            this.n += "&swf5=" + a2;
            this.t = true;
        }
        if (TextUtils.isEmpty(a6)) {
            return;
        }
        this.n += "&hwf5=" + a6;
        this.t = true;
    }

    private List<WifiConfiguration> i() {
        try {
            if (this.g != null) {
                return this.g.getConfiguredNetworks();
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    public void a() {
        b();
    }

    public String b() {
        try {
            return b(15);
        } catch (Exception e) {
            return null;
        }
    }

    public void c() {
        if (this.n == null) {
            c(62);
        } else if (this.q && 0 == 0) {
            this.c.a(this.n);
        }
    }
}
