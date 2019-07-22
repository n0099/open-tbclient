package com.baidu.location.a;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.support.v7.widget.ActivityChooserView;
import android.telephony.CellLocation;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.android.bbalbs.common.util.CommonParam;
import com.baidu.location.Address;
import com.baidu.location.BDLocation;
import com.baidu.location.Jni;
import com.baidu.location.LocationClientOption;
import com.baidu.tieba.model.ReportUserInfoModel;
import com.googlecode.mp4parser.boxes.ultraviolet.BaseLocationBox;
import com.tencent.connect.common.Constants;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
/* loaded from: classes3.dex */
public class d {
    private static Method h = null;
    private static Method i = null;
    private static Method j = null;
    private static Method k = null;
    private static Method l = null;
    private static Class<?> m = null;
    String a;
    String b;
    private Context e;
    private TelephonyManager f;
    private WifiManager n;
    private String p;
    private LocationClientOption q;
    private b r;
    private Address d = null;
    private a g = new a();
    private C0044d o = null;
    private String s = null;
    c c = new c();
    private long t = 0;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a {
        public int a;
        public int b;
        public int c;
        public int d;
        public int e;
        public int f;
        public char g;

        private a() {
            this.a = -1;
            this.b = -1;
            this.c = -1;
            this.d = -1;
            this.e = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            this.f = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            this.g = (char) 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean b() {
            return this.a > -1 && this.b > 0;
        }

        public String a() {
            if (b()) {
                StringBuffer stringBuffer = new StringBuffer(128);
                stringBuffer.append("&nw=");
                stringBuffer.append(this.g);
                stringBuffer.append(String.format(Locale.CHINA, "&cl=%d|%d|%d|%d", Integer.valueOf(this.c), Integer.valueOf(this.d), Integer.valueOf(this.a), Integer.valueOf(this.b)));
                if (this.e < Integer.MAX_VALUE && this.f < Integer.MAX_VALUE) {
                    stringBuffer.append(String.format(Locale.CHINA, "&cdmall=%.6f|%.6f", Double.valueOf(this.f / 14400.0d), Double.valueOf(this.e / 14400.0d)));
                }
                return stringBuffer.toString();
            }
            return null;
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void onReceiveFixLocation(BDLocation bDLocation);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class c extends com.baidu.location.g.e {
        String a = null;
        private boolean c = false;

        c() {
            this.k = new HashMap();
        }

        private void b() {
            BDLocation bDLocation = new BDLocation();
            bDLocation.setLocType(63);
            d.this.r.onReceiveFixLocation(bDLocation);
        }

        @Override // com.baidu.location.g.e
        public void a() {
            this.h = com.baidu.location.g.g.c();
            String encodeTp4 = Jni.encodeTp4(this.a);
            this.a = null;
            this.k.put(BaseLocationBox.TYPE, encodeTp4);
            this.k.put("trtm", String.format(Locale.CHINA, "%d", Long.valueOf(System.currentTimeMillis())));
        }

        public void a(String str) {
            this.a = str;
            if (this.c) {
                return;
            }
            this.c = true;
            a(false, "");
        }

        @Override // com.baidu.location.g.e
        public void a(boolean z) {
            BDLocation bDLocation;
            if (!z || this.j == null) {
                b();
            } else {
                try {
                    try {
                        bDLocation = new BDLocation(this.j);
                    } catch (Exception e) {
                        bDLocation = new BDLocation();
                        bDLocation.setLocType(63);
                    }
                    if (bDLocation == null || bDLocation.getLocType() != 161) {
                        b();
                    } else {
                        bDLocation.setCoorType(d.this.q.coorType);
                        bDLocation.setLocationID(Jni.en1(d.this.a + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR + d.this.b + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR + bDLocation.getTime()));
                        if (d.b(bDLocation.getAddress()) == 1) {
                            d.this.a(bDLocation.getAddress());
                            d.this.r.onReceiveFixLocation(bDLocation);
                        } else {
                            bDLocation.setAddr(new Address.Builder().build());
                            d.this.r.onReceiveFixLocation(bDLocation);
                        }
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                    b();
                }
            }
            if (this.k != null) {
                this.k.clear();
            }
            this.c = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: com.baidu.location.a.d$d  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0044d {
        public List<ScanResult> a;
        private long c;

        public C0044d(List<ScanResult> list) {
            this.a = null;
            this.c = 0L;
            this.a = list;
            this.c = System.currentTimeMillis();
            d();
        }

        private int b() {
            if (this.a == null) {
                return 0;
            }
            return this.a.size();
        }

        private String c() {
            WifiInfo connectionInfo = d.this.n.getConnectionInfo();
            if (connectionInfo == null) {
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

        private void d() {
            boolean z;
            if (b() < 1) {
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
            int i2;
            if (a() < 2) {
                return null;
            }
            StringBuffer stringBuffer = new StringBuffer(512);
            int size = this.a.size();
            boolean z = true;
            int i3 = 0;
            String c = c();
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            while (i6 < size) {
                if (this.a.get(i6).level == 0) {
                    i2 = i3;
                } else {
                    i4++;
                    if (z) {
                        stringBuffer.append("&wf=");
                        z = false;
                    } else {
                        stringBuffer.append("|");
                    }
                    String replace = this.a.get(i6).BSSID.replace(":", "");
                    stringBuffer.append(replace);
                    if (c != null && replace.equals(c)) {
                        i5 = i4;
                    }
                    int i7 = this.a.get(i6).level;
                    if (i7 < 0) {
                        i7 = -i7;
                    }
                    stringBuffer.append(String.format(Locale.CHINA, ";%d;", Integer.valueOf(i7)));
                    i2 = i3 + 1;
                    if (i2 > i) {
                        break;
                    }
                }
                i6++;
                i3 = i2;
            }
            if (i5 > 0) {
                stringBuffer.append("&wf_n=");
                stringBuffer.append(i5);
            }
            if (z) {
                return null;
            }
            return stringBuffer.toString();
        }
    }

    public d(Context context, LocationClientOption locationClientOption, b bVar) {
        String str;
        this.e = null;
        this.f = null;
        this.n = null;
        this.p = null;
        this.a = null;
        this.b = null;
        this.e = context.getApplicationContext();
        this.q = locationClientOption;
        this.r = bVar;
        this.a = this.e.getPackageName();
        this.b = null;
        try {
            this.f = (TelephonyManager) this.e.getSystemService("phone");
            this.n = (WifiManager) this.e.getApplicationContext().getSystemService("wifi");
            str = this.f.getDeviceId();
        } catch (Exception e) {
            this.n = null;
            this.f = null;
            str = null;
        }
        try {
            this.b = CommonParam.getCUID(this.e);
        } catch (Exception e2) {
            this.b = null;
        }
        if (this.b != null) {
            this.p = "&prod=" + this.q.prodName + ":" + this.a + "|&cu=" + this.b + "&coor=" + locationClientOption.getCoorType();
        } else {
            this.p = "&prod=" + this.q.prodName + ":" + this.a + "|&im=" + str + "&coor=" + locationClientOption.getCoorType();
        }
        StringBuffer stringBuffer = new StringBuffer(256);
        stringBuffer.append("&fw=");
        stringBuffer.append("7.8");
        stringBuffer.append("&lt=1");
        stringBuffer.append("&mb=");
        stringBuffer.append(Build.MODEL);
        stringBuffer.append("&resid=");
        stringBuffer.append(Constants.VIA_REPORT_TYPE_SET_AVATAR);
        this.p += "&addr=allj";
        if (locationClientOption.isNeedAptag || locationClientOption.isNeedAptagd) {
            this.p += "&sema=";
            if (locationClientOption.isNeedAptag) {
                this.p += "aptag|";
            }
            if (locationClientOption.isNeedAptagd) {
                this.p += "aptagd|";
            }
        }
        stringBuffer.append("&first=2");
        stringBuffer.append("&os=A");
        stringBuffer.append(Build.VERSION.SDK);
        this.p += stringBuffer.toString();
    }

    private String a(int i2) {
        String str;
        String str2;
        if (i2 < 3) {
            i2 = 3;
        }
        try {
            a(this.f.getCellLocation());
            str = this.g.a();
        } catch (Throwable th) {
            str = null;
        }
        try {
            this.o = null;
            this.o = new C0044d(this.n.getScanResults());
            str2 = this.o.a(i2);
        } catch (Exception e) {
            str2 = null;
        }
        if (str == null && str2 == null) {
            this.s = null;
            return null;
        }
        if (str2 != null) {
            str = str + str2;
        }
        if (str != null) {
            this.s = str;
            if (this.p != null) {
                this.s += this.p;
            }
            return str + this.p;
        }
        return null;
    }

    private void a(CellLocation cellLocation) {
        if (cellLocation == null || this.f == null) {
            return;
        }
        a aVar = new a();
        String networkOperator = this.f.getNetworkOperator();
        if (networkOperator != null && networkOperator.length() > 0) {
            int i2 = -1;
            try {
                if (networkOperator.length() >= 3) {
                    i2 = Integer.valueOf(networkOperator.substring(0, 3)).intValue();
                    aVar.c = i2 < 0 ? this.g.c : i2;
                }
                String substring = networkOperator.substring(3);
                if (substring != null) {
                    char[] charArray = substring.toCharArray();
                    int i3 = 0;
                    while (i3 < charArray.length && Character.isDigit(charArray[i3])) {
                        i3++;
                    }
                    i2 = Integer.valueOf(substring.substring(0, i3)).intValue();
                }
                if (i2 < 0) {
                    i2 = this.g.d;
                }
                aVar.d = i2;
            } catch (Exception e) {
            }
        }
        if (cellLocation instanceof GsmCellLocation) {
            aVar.a = ((GsmCellLocation) cellLocation).getLac();
            aVar.b = ((GsmCellLocation) cellLocation).getCid();
            aVar.g = 'g';
        } else if (cellLocation instanceof CdmaCellLocation) {
            aVar.g = 'c';
            if (m == null) {
                try {
                    m = Class.forName("android.telephony.cdma.CdmaCellLocation");
                    h = m.getMethod("getBaseStationId", new Class[0]);
                    i = m.getMethod("getNetworkId", new Class[0]);
                    j = m.getMethod("getSystemId", new Class[0]);
                    k = m.getMethod("getBaseStationLatitude", new Class[0]);
                    l = m.getMethod("getBaseStationLongitude", new Class[0]);
                } catch (Exception e2) {
                    m = null;
                    return;
                }
            }
            if (m != null && m.isInstance(cellLocation)) {
                try {
                    int intValue = ((Integer) j.invoke(cellLocation, new Object[0])).intValue();
                    if (intValue < 0) {
                        intValue = this.g.d;
                    }
                    aVar.d = intValue;
                    aVar.b = ((Integer) h.invoke(cellLocation, new Object[0])).intValue();
                    aVar.a = ((Integer) i.invoke(cellLocation, new Object[0])).intValue();
                    Object invoke = k.invoke(cellLocation, new Object[0]);
                    if (((Integer) invoke).intValue() < Integer.MAX_VALUE) {
                        aVar.e = ((Integer) invoke).intValue();
                    }
                    Object invoke2 = l.invoke(cellLocation, new Object[0]);
                    if (((Integer) invoke2).intValue() < Integer.MAX_VALUE) {
                        aVar.f = ((Integer) invoke2).intValue();
                    }
                } catch (Exception e3) {
                    return;
                }
            }
        }
        if (aVar.b()) {
            this.g = aVar;
        } else {
            this.g = null;
        }
    }

    public static int b(Address address) {
        int i2 = 0;
        if (address != null && !TextUtils.isEmpty(address.cityCode)) {
            try {
                Integer.valueOf(address.cityCode).intValue();
                i2 = 1;
            } catch (Throwable th) {
                Log.w(com.baidu.location.g.a.a, "FixAddrManager addr citycode exception", th);
                i2 = 2;
            }
        }
        if (address == null || i2 != 1 || address.countryCode == null || !address.countryCode.equals("0") || address.country == null || address.country.equals("中国")) {
            return i2;
        }
        Log.w(com.baidu.location.g.a.a, "FixAddrManager addr country is wrong");
        return 2;
    }

    private String b() {
        try {
            return a(15);
        } catch (Exception e) {
            return null;
        }
    }

    private void c() {
        b();
        if (this.s == null) {
            return;
        }
        this.c.a(this.s);
    }

    public Address a() {
        Address address = this.d;
        if (address == null) {
            address = new Address.Builder().build();
        }
        long currentTimeMillis = System.currentTimeMillis() - this.t;
        if (currentTimeMillis > ReportUserInfoModel.TIME_INTERVAL || currentTimeMillis < -10000) {
            this.t = System.currentTimeMillis();
            c();
        }
        return address;
    }

    public void a(Address address) {
        if (b(address) == 1) {
            this.d = new Address.Builder().country(address.country).countryCode(address.countryCode).province(address.province).city(address.city).cityCode(address.cityCode).district(address.district).street(address.street).adcode(address.adcode).streetNumber(address.streetNumber).build();
            this.t = System.currentTimeMillis();
        }
    }
}
