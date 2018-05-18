package com.baidu.location.a;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.CellLocation;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.text.TextUtils;
import com.baidu.location.BDLocation;
import com.baidu.location.Jni;
import com.baidu.location.LocationClientOption;
import com.baidu.sapi2.passhost.pluginsdk.service.ISapiAccount;
import com.googlecode.mp4parser.boxes.ultraviolet.BaseLocationBox;
import com.tencent.connect.common.Constants;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import org.apache.http.HttpStatus;
/* loaded from: classes.dex */
public class b {
    private static Method e = null;
    private static Method f = null;
    private static Method g = null;
    private static Class<?> h = null;
    private LocationClientOption Nt;
    private InterfaceC0049b Nu;
    private Context b;
    private TelephonyManager c;
    private WifiManager i;
    private String k;
    private a Nr = new a();
    private d Ns = null;
    private String n = null;
    c Nv = new c();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        public int a;
        public int b;
        public int c;
        public int d;
        public char e;

        private a() {
            this.a = -1;
            this.b = -1;
            this.c = -1;
            this.d = -1;
            this.e = (char) 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean d() {
            return this.a > -1 && this.b > 0;
        }

        public int a() {
            if (this.c <= 0 || !d()) {
                return 2;
            }
            return (this.c == 460 || this.c == 454 || this.c == 455 || this.c == 466) ? 1 : 0;
        }

        public String b() {
            if (d()) {
                StringBuffer stringBuffer = new StringBuffer(128);
                stringBuffer.append("&nw=");
                stringBuffer.append(this.e);
                stringBuffer.append(String.format(Locale.CHINA, "&cl=%d|%d|%d|%d", Integer.valueOf(this.c), Integer.valueOf(this.d), Integer.valueOf(this.a), Integer.valueOf(this.b)));
                return stringBuffer.toString();
            }
            return null;
        }

        public String c() {
            if (d()) {
                StringBuffer stringBuffer = new StringBuffer(128);
                stringBuffer.append(this.b + 23);
                stringBuffer.append("H");
                stringBuffer.append(this.a + 45);
                stringBuffer.append("K");
                stringBuffer.append(this.d + 54);
                stringBuffer.append("Q");
                stringBuffer.append(this.c + HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION);
                return stringBuffer.toString();
            }
            return null;
        }
    }

    /* renamed from: com.baidu.location.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0049b {
        void onReceiveLocation(BDLocation bDLocation);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c extends com.baidu.location.h.f {
        String a = null;

        c() {
            this.k = new HashMap();
        }

        @Override // com.baidu.location.h.f
        public void a() {
            this.h = com.baidu.location.h.i.c();
            String encodeTp4 = Jni.encodeTp4(this.a);
            this.a = null;
            this.k.put(BaseLocationBox.TYPE, encodeTp4);
            StringBuffer stringBuffer = new StringBuffer(512);
            stringBuffer.append(String.format(Locale.CHINA, "&ki=%s&sn=%s", com.baidu.location.h.a.b(b.this.b), com.baidu.location.h.a.a(b.this.b)));
            if (stringBuffer.length() > 0) {
                this.k.put("ext", Jni.encode(stringBuffer.toString()));
            }
            this.k.put("trtm", String.format(Locale.CHINA, "%d", Long.valueOf(System.currentTimeMillis())));
        }

        public void a(String str) {
            this.a = str;
            e();
        }

        @Override // com.baidu.location.h.f
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
                        bDLocation.setCoorType(b.this.Nt.coorType);
                        b.this.Nu.onReceiveLocation(bDLocation);
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
    /* loaded from: classes.dex */
    public class d {
        public List<ScanResult> a;
        private long c;

        public d(List<ScanResult> list) {
            this.a = null;
            this.c = 0L;
            this.a = list;
            this.c = System.currentTimeMillis();
            b();
        }

        private void b() {
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
            int i2;
            if (a() < 2) {
                return null;
            }
            StringBuffer stringBuffer = new StringBuffer(512);
            int size = this.a.size();
            int i3 = 0;
            int i4 = 0;
            boolean z = true;
            while (i3 < size) {
                if (this.a.get(i3).level == 0) {
                    i2 = i4;
                } else {
                    if (z) {
                        stringBuffer.append("&wf=");
                        z = false;
                    } else {
                        stringBuffer.append("|");
                    }
                    stringBuffer.append(this.a.get(i3).BSSID.replace(":", ""));
                    int i5 = this.a.get(i3).level;
                    if (i5 < 0) {
                        i5 = -i5;
                    }
                    stringBuffer.append(String.format(Locale.CHINA, ";%d;", Integer.valueOf(i5)));
                    i2 = i4 + 1;
                    if (i2 > i) {
                        break;
                    }
                }
                i3++;
                i4 = i2;
            }
            if (z) {
                return null;
            }
            return stringBuffer.toString();
        }
    }

    public b(Context context, LocationClientOption locationClientOption, InterfaceC0049b interfaceC0049b) {
        String str;
        String str2;
        this.b = null;
        this.c = null;
        this.i = null;
        this.k = null;
        this.b = context.getApplicationContext();
        this.Nt = locationClientOption;
        this.Nu = interfaceC0049b;
        String packageName = this.b.getPackageName();
        try {
            this.c = (TelephonyManager) this.b.getSystemService(ISapiAccount.SAPI_ACCOUNT_PHONE);
            str = this.c.getDeviceId();
        } catch (Exception e2) {
            str = null;
        }
        try {
            str2 = com.baidu.location.b.b.a.a(this.b);
        } catch (Exception e3) {
            str2 = null;
        }
        if (str2 != null) {
            this.k = "&prod=" + this.Nt.prodName + ":" + packageName + "|&cu=" + str2 + "&coor=" + locationClientOption.getCoorType();
        } else {
            this.k = "&prod=" + this.Nt.prodName + ":" + packageName + "|&im=" + str + "&coor=" + locationClientOption.getCoorType();
        }
        StringBuffer stringBuffer = new StringBuffer(256);
        stringBuffer.append("&fw=");
        stringBuffer.append("6.23");
        stringBuffer.append("&lt=1");
        stringBuffer.append("&mb=");
        stringBuffer.append(Build.MODEL);
        stringBuffer.append("&resid=");
        stringBuffer.append(Constants.VIA_REPORT_TYPE_SET_AVATAR);
        if (locationClientOption.getAddrType() != null) {
        }
        if (locationClientOption.getAddrType() != null && locationClientOption.getAddrType().equals("all")) {
            this.k += "&addr=all";
        }
        if (locationClientOption.isNeedAptag || locationClientOption.isNeedAptagd) {
            this.k += "&sema=";
            if (locationClientOption.isNeedAptag) {
                this.k += "aptag|";
            }
            if (locationClientOption.isNeedAptagd) {
                this.k += "aptagd|";
            }
        }
        stringBuffer.append("&first=1");
        stringBuffer.append(Build.VERSION.SDK);
        this.k += stringBuffer.toString();
        this.i = (WifiManager) this.b.getSystemService("wifi");
        String a2 = a();
        a2 = TextUtils.isEmpty(a2) ? a2 : a2.replace(":", "");
        if (!TextUtils.isEmpty(a2)) {
            this.k += "&mac=" + a2;
        }
        b();
    }

    private String a(int i) {
        String str;
        String str2;
        if (i < 3) {
            i = 3;
        }
        try {
            a(this.c.getCellLocation());
            str = this.Nr.b();
        } catch (Exception e2) {
            str = null;
        }
        try {
            this.Ns = null;
            this.Ns = new d(this.i.getScanResults());
            str2 = this.Ns.a(i);
        } catch (Exception e3) {
            str2 = null;
        }
        if (str == null && str2 == null) {
            this.n = null;
            return null;
        }
        if (str2 != null) {
            str = str + str2;
        }
        if (str != null) {
            this.n = str + this.k;
            return str + this.k;
        }
        return null;
    }

    private void a(CellLocation cellLocation) {
        int i = 0;
        if (cellLocation == null || this.c == null) {
            return;
        }
        a aVar = new a();
        String networkOperator = this.c.getNetworkOperator();
        if (networkOperator != null && networkOperator.length() > 0) {
            try {
                if (networkOperator.length() >= 3) {
                    int intValue = Integer.valueOf(networkOperator.substring(0, 3)).intValue();
                    if (intValue < 0) {
                        intValue = this.Nr.c;
                    }
                    aVar.c = intValue;
                }
                String substring = networkOperator.substring(3);
                if (substring != null) {
                    char[] charArray = substring.toCharArray();
                    while (i < charArray.length && Character.isDigit(charArray[i])) {
                        i++;
                    }
                }
                int intValue2 = Integer.valueOf(substring.substring(0, i)).intValue();
                if (intValue2 < 0) {
                    intValue2 = this.Nr.d;
                }
                aVar.d = intValue2;
            } catch (Exception e2) {
            }
        }
        if (cellLocation instanceof GsmCellLocation) {
            aVar.a = ((GsmCellLocation) cellLocation).getLac();
            aVar.b = ((GsmCellLocation) cellLocation).getCid();
            aVar.e = 'g';
        } else if (cellLocation instanceof CdmaCellLocation) {
            aVar.e = 'c';
            if (h == null) {
                try {
                    h = Class.forName("android.telephony.cdma.CdmaCellLocation");
                    e = h.getMethod("getBaseStationId", new Class[0]);
                    f = h.getMethod("getNetworkId", new Class[0]);
                    g = h.getMethod("getSystemId", new Class[0]);
                } catch (Exception e3) {
                    h = null;
                    return;
                }
            }
            if (h != null && h.isInstance(cellLocation)) {
                try {
                    int intValue3 = ((Integer) g.invoke(cellLocation, new Object[0])).intValue();
                    if (intValue3 < 0) {
                        intValue3 = this.Nr.d;
                    }
                    aVar.d = intValue3;
                    aVar.b = ((Integer) e.invoke(cellLocation, new Object[0])).intValue();
                    aVar.a = ((Integer) f.invoke(cellLocation, new Object[0])).intValue();
                } catch (Exception e4) {
                    return;
                }
            }
        }
        if (aVar.d()) {
            this.Nr = aVar;
        }
    }

    public String a() {
        try {
            WifiInfo connectionInfo = this.i.getConnectionInfo();
            if (connectionInfo != null) {
                return connectionInfo.getMacAddress();
            }
            return null;
        } catch (Exception e2) {
            return null;
        }
    }

    public String b() {
        try {
            return a(15);
        } catch (Exception e2) {
            return null;
        }
    }

    public void c() {
        BDLocation bDLocation;
        if (this.n == null) {
            return;
        }
        if (this.Nr == null || this.Nr.a() == 1) {
            if (this.i == null || this.Nt.scanSpan < 1000 || this.Nt.getAddrType().equals("all") || this.Nt.isNeedAptag || this.Nt.isNeedAptagd) {
                bDLocation = null;
            } else {
                try {
                    bDLocation = com.baidu.location.e.a.np().a(this.Nr.c(), this.i.getScanResults(), false);
                    if (!this.Nt.coorType.equals("gcj02")) {
                        double longitude = bDLocation.getLongitude();
                        double latitude = bDLocation.getLatitude();
                        if (longitude != Double.MIN_VALUE && latitude != Double.MIN_VALUE) {
                            double[] coorEncrypt = Jni.coorEncrypt(longitude, latitude, this.Nt.coorType);
                            bDLocation.setLongitude(coorEncrypt[0]);
                            bDLocation.setLatitude(coorEncrypt[1]);
                            bDLocation.setCoorType(this.Nt.coorType);
                        }
                    }
                    if (bDLocation.getLocType() == 66) {
                        this.Nu.onReceiveLocation(bDLocation);
                    }
                } catch (Exception e2) {
                    bDLocation = null;
                }
            }
            if (bDLocation == null) {
                this.Nv.a(this.n);
            }
        }
    }
}
