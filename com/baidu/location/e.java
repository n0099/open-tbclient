package com.baidu.location;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Handler;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e {

    /* renamed from: byte  reason: not valid java name */
    private static final int f149byte = 15;

    /* renamed from: try  reason: not valid java name */
    private static String f150try = f.v;

    /* renamed from: goto  reason: not valid java name */
    private Context f156goto;

    /* renamed from: if  reason: not valid java name */
    private Handler f157if;
    private final long f = 3000;

    /* renamed from: new  reason: not valid java name */
    private final long f160new = 3000;

    /* renamed from: a  reason: collision with root package name */
    private final long f740a = 5000;

    /* renamed from: void  reason: not valid java name */
    private WifiManager f161void = null;

    /* renamed from: char  reason: not valid java name */
    private b f152char = null;
    private a c = null;

    /* renamed from: case  reason: not valid java name */
    private c f151case = null;
    private long b = 0;

    /* renamed from: long  reason: not valid java name */
    private long f159long = 0;

    /* renamed from: int  reason: not valid java name */
    private boolean f158int = false;
    private Object g = null;
    private Method e = null;

    /* renamed from: for  reason: not valid java name */
    private boolean f155for = true;
    private boolean d = false;

    /* renamed from: else  reason: not valid java name */
    private boolean f154else = false;

    /* renamed from: do  reason: not valid java name */
    private boolean f153do = false;

    /* loaded from: classes.dex */
    class a extends BroadcastReceiver {
        private a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (context == null || e.this.f157if == null) {
                return;
            }
            e.this.m136goto();
        }
    }

    /* loaded from: classes.dex */
    class b extends BroadcastReceiver {
        private b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (context == null || e.this.f157if == null) {
                return;
            }
            e.this.m138if();
            e.this.f157if.obtainMessage(41).sendToTarget();
            j.a(e.f150try, "wifi manager receive new wifi...");
        }
    }

    /* loaded from: classes.dex */
    public class c {

        /* renamed from: do  reason: not valid java name */
        public List f162do;

        /* renamed from: for  reason: not valid java name */
        private long f163for;

        /* renamed from: if  reason: not valid java name */
        private long f164if;

        public c(List list, long j) {
            this.f162do = null;
            this.f164if = 0L;
            this.f163for = 0L;
            this.f164if = j;
            this.f162do = list;
            this.f163for = System.currentTimeMillis();
            a();
            j.m256if(e.f150try, m151for());
        }

        private void a() {
            boolean z;
            if (m156new() < 1) {
                return;
            }
            boolean z2 = true;
            for (int size = this.f162do.size() - 1; size >= 1 && z2; size--) {
                int i = 0;
                z2 = false;
                while (i < size) {
                    if (((ScanResult) this.f162do.get(i)).level < ((ScanResult) this.f162do.get(i + 1)).level) {
                        this.f162do.set(i + 1, this.f162do.get(i));
                        this.f162do.set(i, (ScanResult) this.f162do.get(i + 1));
                        z = true;
                    } else {
                        z = z2;
                    }
                    i++;
                    z2 = z;
                }
            }
        }

        public String a(int i) {
            int i2;
            boolean z;
            if (m156new() < 1) {
                return null;
            }
            StringBuffer stringBuffer = new StringBuffer(512);
            String m141char = e.this.m141char();
            int size = this.f162do.size();
            if (size <= i) {
                i = size;
            }
            int i3 = 0;
            boolean z2 = true;
            int i4 = 0;
            int i5 = 0;
            while (i3 < i) {
                if (((ScanResult) this.f162do.get(i3)).level == 0) {
                    z = z2;
                    i2 = i5;
                } else if (z2) {
                    stringBuffer.append("&wf=");
                    String replace = ((ScanResult) this.f162do.get(i3)).BSSID.replace(":", "");
                    stringBuffer.append(replace);
                    int i6 = ((ScanResult) this.f162do.get(i3)).level;
                    if (i6 < 0) {
                        i6 = -i6;
                    }
                    stringBuffer.append(String.format(";%d;", Integer.valueOf(i6)));
                    i2 = i5 + 1;
                    i4 = (m141char == null || !m141char.equals(replace)) ? i4 : i2;
                    z = false;
                } else {
                    stringBuffer.append("|");
                    String replace2 = ((ScanResult) this.f162do.get(i3)).BSSID.replace(":", "");
                    stringBuffer.append(replace2);
                    int i7 = ((ScanResult) this.f162do.get(i3)).level;
                    if (i7 < 0) {
                        i7 = -i7;
                    }
                    stringBuffer.append(String.format(";%d;", Integer.valueOf(i7)));
                    int i8 = i5 + 1;
                    if (m141char == null || !m141char.equals(replace2)) {
                        boolean z3 = z2;
                        i2 = i8;
                        z = z3;
                    } else {
                        i4 = i8;
                        boolean z4 = z2;
                        i2 = i8;
                        z = z4;
                    }
                }
                i3++;
                i5 = i2;
                z2 = z;
            }
            if (z2) {
                return null;
            }
            j.a(e.f150try, m141char + i4);
            stringBuffer.append("&wf_n=" + i4);
            stringBuffer.append("&wf_st=");
            stringBuffer.append(this.f164if);
            stringBuffer.append("&wf_et=");
            stringBuffer.append(this.f163for);
            return stringBuffer.toString();
        }

        public boolean a(c cVar) {
            return a(cVar, this, j.D);
        }

        public boolean a(c cVar, c cVar2, float f) {
            int i;
            if (cVar == null || cVar2 == null) {
                return false;
            }
            List list = cVar.f162do;
            List list2 = cVar2.f162do;
            if (list == list2) {
                return true;
            }
            if (list == null || list2 == null) {
                return false;
            }
            int size = list.size();
            int size2 = list2.size();
            float f2 = size + size2;
            if (size == 0 && size2 == 0) {
                return true;
            }
            if (size == 0 || size2 == 0) {
                return false;
            }
            int i2 = 0;
            int i3 = 0;
            while (i2 < size) {
                String str = ((ScanResult) list.get(i2)).BSSID;
                if (str != null) {
                    int i4 = 0;
                    while (true) {
                        if (i4 >= size2) {
                            i = i3;
                            break;
                        } else if (str.equals(((ScanResult) list2.get(i4)).BSSID)) {
                            i = i3 + 1;
                            break;
                        } else {
                            i4++;
                        }
                    }
                } else {
                    i = i3;
                }
                i2++;
                i3 = i;
            }
            j.a(e.f150try, String.format("same %d,total %f,rate %f...", Integer.valueOf(i3), Float.valueOf(f2), Float.valueOf(f)));
            return ((float) (i3 * 2)) >= f2 * f;
        }

        /* renamed from: byte  reason: not valid java name */
        public String m147byte() {
            try {
                return a(j.F);
            } catch (Exception e) {
                return null;
            }
        }

        /* renamed from: case  reason: not valid java name */
        public String m148case() {
            boolean z;
            StringBuffer stringBuffer = new StringBuffer(512);
            stringBuffer.append("wifi info:");
            if (m156new() < 1) {
                return stringBuffer.toString();
            }
            int size = this.f162do.size();
            if (size > 10) {
                size = 10;
            }
            int i = 0;
            boolean z2 = true;
            while (i < size) {
                if (((ScanResult) this.f162do.get(i)).level == 0) {
                    z = z2;
                } else if (z2) {
                    stringBuffer.append("wifi=");
                    stringBuffer.append(((ScanResult) this.f162do.get(i)).BSSID.replace(":", ""));
                    stringBuffer.append(String.format(";%d;", Integer.valueOf(((ScanResult) this.f162do.get(i)).level)));
                    z = false;
                } else {
                    stringBuffer.append(";");
                    stringBuffer.append(((ScanResult) this.f162do.get(i)).BSSID.replace(":", ""));
                    stringBuffer.append(String.format(",%d;", Integer.valueOf(((ScanResult) this.f162do.get(i)).level)));
                    z = z2;
                }
                i++;
                z2 = z;
            }
            return stringBuffer.toString();
        }

        /* renamed from: do  reason: not valid java name */
        public boolean m149do() {
            return System.currentTimeMillis() - this.f163for < 3000;
        }

        /* renamed from: do  reason: not valid java name */
        public boolean m150do(c cVar) {
            if (this.f162do == null || cVar == null || cVar.f162do == null) {
                return false;
            }
            int size = this.f162do.size() < cVar.f162do.size() ? this.f162do.size() : cVar.f162do.size();
            for (int i = 0; i < size; i++) {
                String str = ((ScanResult) this.f162do.get(i)).BSSID;
                int i2 = ((ScanResult) this.f162do.get(i)).level;
                String str2 = ((ScanResult) cVar.f162do.get(i)).BSSID;
                int i3 = ((ScanResult) cVar.f162do.get(i)).level;
                if (!str.equals(str2) || i2 != i3) {
                    return false;
                }
            }
            return true;
        }

        /* renamed from: for  reason: not valid java name */
        public String m151for() {
            StringBuilder sb = new StringBuilder();
            sb.append("wifi=");
            if (this.f162do == null) {
                return sb.toString();
            }
            for (int i = 0; i < this.f162do.size(); i++) {
                int i2 = ((ScanResult) this.f162do.get(i)).level;
                sb.append(((ScanResult) this.f162do.get(i)).BSSID.replace(":", ""));
                sb.append(String.format(",%d;", Integer.valueOf(i2)));
            }
            return sb.toString();
        }

        /* renamed from: if  reason: not valid java name */
        public String m152if(int i) {
            int i2 = 0;
            if (i == 0 || m156new() < 1) {
                return null;
            }
            StringBuffer stringBuffer = new StringBuffer(256);
            int i3 = 0;
            int i4 = 1;
            while (true) {
                int i5 = i2;
                if (i5 >= j.F) {
                    return stringBuffer.toString();
                }
                if ((i4 & i) != 0) {
                    if (i3 == 0) {
                        stringBuffer.append("&ssid=");
                    } else {
                        stringBuffer.append("|");
                    }
                    stringBuffer.append(((ScanResult) this.f162do.get(i5)).BSSID);
                    stringBuffer.append(";");
                    stringBuffer.append(((ScanResult) this.f162do.get(i5)).SSID);
                    i3++;
                }
                i4 <<= 1;
                i2 = i5 + 1;
            }
        }

        /* renamed from: if  reason: not valid java name */
        public boolean m153if() {
            return System.currentTimeMillis() - this.f164if < 3000;
        }

        /* renamed from: if  reason: not valid java name */
        public boolean m154if(c cVar) {
            if (this.f162do == null || cVar == null || cVar.f162do == null) {
                return false;
            }
            int size = this.f162do.size() < cVar.f162do.size() ? this.f162do.size() : cVar.f162do.size();
            for (int i = 0; i < size; i++) {
                if (!((ScanResult) this.f162do.get(i)).BSSID.equals(((ScanResult) cVar.f162do.get(i)).BSSID)) {
                    return false;
                }
            }
            return true;
        }

        /* renamed from: int  reason: not valid java name */
        public boolean m155int() {
            return System.currentTimeMillis() - this.f163for < 5000;
        }

        /* renamed from: new  reason: not valid java name */
        public int m156new() {
            if (this.f162do == null) {
                return 0;
            }
            return this.f162do.size();
        }

        /* renamed from: try  reason: not valid java name */
        public String m157try() {
            try {
                return a(15);
            } catch (Exception e) {
                return null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d implements Runnable {
        private d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!e.this.d || !j.J) {
                e.this.f153do = false;
                return;
            }
            e.this.f157if.obtainMessage(91).sendToTarget();
            e.this.f157if.postDelayed(this, j.h);
            e.this.f153do = true;
        }
    }

    public e(Context context, Handler handler) {
        this.f157if = null;
        this.f156goto = context;
        this.f157if = handler;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: goto  reason: not valid java name */
    public void m136goto() {
        NetworkInfo.State state;
        NetworkInfo.State state2 = NetworkInfo.State.UNKNOWN;
        try {
            state = ((ConnectivityManager) this.f156goto.getSystemService("connectivity")).getNetworkInfo(1).getState();
        } catch (Exception e) {
            state = state2;
        }
        if (NetworkInfo.State.CONNECTED != state) {
            this.d = false;
        } else if (this.d) {
        } else {
            this.d = true;
            this.f157if.postDelayed(new d(), j.h);
            this.f153do = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: if  reason: not valid java name */
    public void m138if() {
        if (this.f161void == null) {
            return;
        }
        try {
            c cVar = new c(this.f161void.getScanResults(), this.b);
            this.b = 0L;
            if (this.f151case == null || !cVar.m154if(this.f151case)) {
                this.f151case = cVar;
            }
        } catch (Exception e) {
        }
    }

    public boolean a() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f159long <= 10000) {
            return false;
        }
        this.f159long = currentTimeMillis;
        return m145new();
    }

    /* renamed from: byte  reason: not valid java name */
    public c m139byte() {
        if ((this.f151case == null || !this.f151case.m155int()) && this.f161void != null) {
            try {
                return new c(this.f161void.getScanResults(), 0L);
            } catch (Exception e) {
                return new c(null, 0L);
            }
        }
        return this.f151case;
    }

    /* renamed from: case  reason: not valid java name */
    public void m140case() {
        if (this.c == null) {
            this.c = new a();
        }
        try {
            if (!j.f241try || this.f154else) {
                return;
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            this.f156goto.registerReceiver(this.c, intentFilter);
            m136goto();
            this.f154else = true;
        } catch (Exception e) {
        }
    }

    /* renamed from: char  reason: not valid java name */
    public String m141char() {
        WifiInfo connectionInfo = this.f161void.getConnectionInfo();
        if (connectionInfo == null) {
            return null;
        }
        try {
            String bssid = connectionInfo.getBSSID();
            if (bssid != null) {
                return bssid.replace(":", "");
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    /* renamed from: else  reason: not valid java name */
    public void m142else() {
        if (this.f158int) {
            try {
                this.f156goto.unregisterReceiver(this.f152char);
                if (j.f241try) {
                    this.f156goto.unregisterReceiver(this.c);
                }
            } catch (Exception e) {
            }
            this.f152char = null;
            this.f161void = null;
            this.c = null;
            this.f158int = false;
            j.a(f150try, "wifimanager stop ...");
        }
    }

    /* renamed from: for  reason: not valid java name */
    public void m143for() {
        if (!this.f153do && j.f241try && j.J) {
            this.f157if.postDelayed(new d(), j.h);
            this.f153do = true;
        }
    }

    /* renamed from: int  reason: not valid java name */
    public c m144int() {
        if ((this.f151case == null || !this.f151case.m149do()) && this.f161void != null) {
            try {
                return new c(this.f161void.getScanResults(), 0L);
            } catch (Exception e) {
                return new c(null, 0L);
            }
        }
        return this.f151case;
    }

    /* renamed from: new  reason: not valid java name */
    public boolean m145new() {
        if (this.f161void == null) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.b > 3000) {
            try {
                if (!this.f161void.isWifiEnabled()) {
                    this.b = 0L;
                    return false;
                }
                if (this.e == null || this.g == null) {
                    this.f161void.startScan();
                } else {
                    try {
                        this.e.invoke(this.g, Boolean.valueOf(this.f155for));
                    } catch (Exception e) {
                        e.printStackTrace();
                        this.f161void.startScan();
                    }
                }
                this.b = currentTimeMillis;
                j.a(f150try, "wifimanager start scan ...");
                return true;
            } catch (Exception e2) {
                return false;
            }
        }
        return false;
    }

    /* renamed from: try  reason: not valid java name */
    public void m146try() {
        if (this.f158int) {
            return;
        }
        this.f161void = (WifiManager) this.f156goto.getSystemService("wifi");
        this.f152char = new b();
        try {
            this.f156goto.registerReceiver(this.f152char, new IntentFilter("android.net.wifi.SCAN_RESULTS"));
            this.c = new a();
            if (j.f241try) {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                this.f156goto.registerReceiver(this.c, intentFilter);
                this.f154else = true;
                m136goto();
            }
        } catch (Exception e) {
        }
        this.f158int = true;
        j.a(f150try, "wifimanager start ...");
        try {
            Field declaredField = Class.forName("android.net.wifi.WifiManager").getDeclaredField("mService");
            if (declaredField == null) {
                j.a(f150try, "android.net.wifi.WifiManager.mService  NOT  found ...");
            } else {
                declaredField.setAccessible(true);
                this.g = declaredField.get(this.f161void);
                Class<?> cls = this.g.getClass();
                j.a(f150try, "mserviceClass : " + cls.getName());
                this.e = cls.getDeclaredMethod("startScan", Boolean.TYPE);
                if (this.e == null) {
                    j.a(f150try, "mService.startScan NOT  found ...");
                } else {
                    this.e.setAccessible(true);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
