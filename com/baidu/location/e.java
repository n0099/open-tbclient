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
import com.baidu.tbadk.TbConfig;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e {

    /* renamed from: byte  reason: not valid java name */
    private static final int f113byte = 15;

    /* renamed from: try  reason: not valid java name */
    private static String f114try = f.v;

    /* renamed from: goto  reason: not valid java name */
    private Context f120goto;

    /* renamed from: if  reason: not valid java name */
    private Handler f121if;
    private final long f = 3000;

    /* renamed from: new  reason: not valid java name */
    private final long f124new = 3000;
    private final long a = TbConfig.NOTIFY_SOUND_INTERVAL;

    /* renamed from: void  reason: not valid java name */
    private WifiManager f125void = null;

    /* renamed from: char  reason: not valid java name */
    private b f116char = null;
    private a c = null;

    /* renamed from: case  reason: not valid java name */
    private c f115case = null;
    private long b = 0;

    /* renamed from: long  reason: not valid java name */
    private long f123long = 0;

    /* renamed from: int  reason: not valid java name */
    private boolean f122int = false;
    private Object g = null;
    private Method e = null;

    /* renamed from: for  reason: not valid java name */
    private boolean f119for = true;
    private boolean d = false;

    /* renamed from: else  reason: not valid java name */
    private boolean f118else = false;

    /* renamed from: do  reason: not valid java name */
    private boolean f117do = false;

    /* loaded from: classes.dex */
    class a extends BroadcastReceiver {
        private a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (context == null || e.this.f121if == null) {
                return;
            }
            e.this.m122goto();
        }
    }

    /* loaded from: classes.dex */
    class b extends BroadcastReceiver {
        private b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (context == null || e.this.f121if == null) {
                return;
            }
            e.this.m124if();
            e.this.f121if.obtainMessage(41).sendToTarget();
            j.a(e.f114try, "wifi manager receive new wifi...");
        }
    }

    /* loaded from: classes.dex */
    public class c {

        /* renamed from: do  reason: not valid java name */
        public List f126do;

        /* renamed from: for  reason: not valid java name */
        private long f127for;

        /* renamed from: if  reason: not valid java name */
        private long f128if;

        public c(List list, long j) {
            this.f126do = null;
            this.f128if = 0L;
            this.f127for = 0L;
            this.f128if = j;
            this.f126do = list;
            this.f127for = System.currentTimeMillis();
            a();
            j.m242if(e.f114try, m137for());
        }

        private void a() {
            boolean z;
            if (m142new() < 1) {
                return;
            }
            boolean z2 = true;
            for (int size = this.f126do.size() - 1; size >= 1 && z2; size--) {
                int i = 0;
                z2 = false;
                while (i < size) {
                    if (((ScanResult) this.f126do.get(i)).level < ((ScanResult) this.f126do.get(i + 1)).level) {
                        this.f126do.set(i + 1, this.f126do.get(i));
                        this.f126do.set(i, (ScanResult) this.f126do.get(i + 1));
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
            if (m142new() < 1) {
                return null;
            }
            StringBuffer stringBuffer = new StringBuffer(512);
            String m127char = e.this.m127char();
            int size = this.f126do.size();
            if (size <= i) {
                i = size;
            }
            int i3 = 0;
            boolean z2 = true;
            int i4 = 0;
            int i5 = 0;
            while (i3 < i) {
                if (((ScanResult) this.f126do.get(i3)).level == 0) {
                    z = z2;
                    i2 = i5;
                } else if (z2) {
                    stringBuffer.append("&wf=");
                    String replace = ((ScanResult) this.f126do.get(i3)).BSSID.replace(":", "");
                    stringBuffer.append(replace);
                    int i6 = ((ScanResult) this.f126do.get(i3)).level;
                    if (i6 < 0) {
                        i6 = -i6;
                    }
                    stringBuffer.append(String.format(";%d;", Integer.valueOf(i6)));
                    i2 = i5 + 1;
                    i4 = (m127char == null || !m127char.equals(replace)) ? i4 : i2;
                    z = false;
                } else {
                    stringBuffer.append("|");
                    String replace2 = ((ScanResult) this.f126do.get(i3)).BSSID.replace(":", "");
                    stringBuffer.append(replace2);
                    int i7 = ((ScanResult) this.f126do.get(i3)).level;
                    if (i7 < 0) {
                        i7 = -i7;
                    }
                    stringBuffer.append(String.format(";%d;", Integer.valueOf(i7)));
                    int i8 = i5 + 1;
                    if (m127char == null || !m127char.equals(replace2)) {
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
            j.a(e.f114try, m127char + i4);
            stringBuffer.append("&wf_n=" + i4);
            stringBuffer.append("&wf_st=");
            stringBuffer.append(this.f128if);
            stringBuffer.append("&wf_et=");
            stringBuffer.append(this.f127for);
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
            List list = cVar.f126do;
            List list2 = cVar2.f126do;
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
            j.a(e.f114try, String.format("same %d,total %f,rate %f...", Integer.valueOf(i3), Float.valueOf(f2), Float.valueOf(f)));
            return ((float) (i3 * 2)) >= f2 * f;
        }

        /* renamed from: byte  reason: not valid java name */
        public String m133byte() {
            try {
                return a(j.F);
            } catch (Exception e) {
                return null;
            }
        }

        /* renamed from: case  reason: not valid java name */
        public String m134case() {
            boolean z;
            StringBuffer stringBuffer = new StringBuffer(512);
            stringBuffer.append("wifi info:");
            if (m142new() < 1) {
                return stringBuffer.toString();
            }
            int size = this.f126do.size();
            if (size > 10) {
                size = 10;
            }
            int i = 0;
            boolean z2 = true;
            while (i < size) {
                if (((ScanResult) this.f126do.get(i)).level == 0) {
                    z = z2;
                } else if (z2) {
                    stringBuffer.append("wifi=");
                    stringBuffer.append(((ScanResult) this.f126do.get(i)).BSSID.replace(":", ""));
                    stringBuffer.append(String.format(";%d;", Integer.valueOf(((ScanResult) this.f126do.get(i)).level)));
                    z = false;
                } else {
                    stringBuffer.append(";");
                    stringBuffer.append(((ScanResult) this.f126do.get(i)).BSSID.replace(":", ""));
                    stringBuffer.append(String.format(",%d;", Integer.valueOf(((ScanResult) this.f126do.get(i)).level)));
                    z = z2;
                }
                i++;
                z2 = z;
            }
            return stringBuffer.toString();
        }

        /* renamed from: do  reason: not valid java name */
        public boolean m135do() {
            return System.currentTimeMillis() - this.f127for < 3000;
        }

        /* renamed from: do  reason: not valid java name */
        public boolean m136do(c cVar) {
            if (this.f126do == null || cVar == null || cVar.f126do == null) {
                return false;
            }
            int size = this.f126do.size() < cVar.f126do.size() ? this.f126do.size() : cVar.f126do.size();
            for (int i = 0; i < size; i++) {
                String str = ((ScanResult) this.f126do.get(i)).BSSID;
                int i2 = ((ScanResult) this.f126do.get(i)).level;
                String str2 = ((ScanResult) cVar.f126do.get(i)).BSSID;
                int i3 = ((ScanResult) cVar.f126do.get(i)).level;
                if (!str.equals(str2) || i2 != i3) {
                    return false;
                }
            }
            return true;
        }

        /* renamed from: for  reason: not valid java name */
        public String m137for() {
            StringBuilder sb = new StringBuilder();
            sb.append("wifi=");
            if (this.f126do == null) {
                return sb.toString();
            }
            for (int i = 0; i < this.f126do.size(); i++) {
                int i2 = ((ScanResult) this.f126do.get(i)).level;
                sb.append(((ScanResult) this.f126do.get(i)).BSSID.replace(":", ""));
                sb.append(String.format(",%d;", Integer.valueOf(i2)));
            }
            return sb.toString();
        }

        /* renamed from: if  reason: not valid java name */
        public String m138if(int i) {
            int i2 = 0;
            if (i == 0 || m142new() < 1) {
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
                    stringBuffer.append(((ScanResult) this.f126do.get(i5)).BSSID);
                    stringBuffer.append(";");
                    stringBuffer.append(((ScanResult) this.f126do.get(i5)).SSID);
                    i3++;
                }
                i4 <<= 1;
                i2 = i5 + 1;
            }
        }

        /* renamed from: if  reason: not valid java name */
        public boolean m139if() {
            return System.currentTimeMillis() - this.f128if < 3000;
        }

        /* renamed from: if  reason: not valid java name */
        public boolean m140if(c cVar) {
            if (this.f126do == null || cVar == null || cVar.f126do == null) {
                return false;
            }
            int size = this.f126do.size() < cVar.f126do.size() ? this.f126do.size() : cVar.f126do.size();
            for (int i = 0; i < size; i++) {
                if (!((ScanResult) this.f126do.get(i)).BSSID.equals(((ScanResult) cVar.f126do.get(i)).BSSID)) {
                    return false;
                }
            }
            return true;
        }

        /* renamed from: int  reason: not valid java name */
        public boolean m141int() {
            return System.currentTimeMillis() - this.f127for < TbConfig.NOTIFY_SOUND_INTERVAL;
        }

        /* renamed from: new  reason: not valid java name */
        public int m142new() {
            if (this.f126do == null) {
                return 0;
            }
            return this.f126do.size();
        }

        /* renamed from: try  reason: not valid java name */
        public String m143try() {
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
                e.this.f117do = false;
                return;
            }
            e.this.f121if.obtainMessage(91).sendToTarget();
            e.this.f121if.postDelayed(this, j.h);
            e.this.f117do = true;
        }
    }

    public e(Context context, Handler handler) {
        this.f121if = null;
        this.f120goto = context;
        this.f121if = handler;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: goto  reason: not valid java name */
    public void m122goto() {
        NetworkInfo.State state;
        NetworkInfo.State state2 = NetworkInfo.State.UNKNOWN;
        try {
            state = ((ConnectivityManager) this.f120goto.getSystemService("connectivity")).getNetworkInfo(1).getState();
        } catch (Exception e) {
            state = state2;
        }
        if (NetworkInfo.State.CONNECTED != state) {
            this.d = false;
        } else if (this.d) {
        } else {
            this.d = true;
            this.f121if.postDelayed(new d(), j.h);
            this.f117do = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: if  reason: not valid java name */
    public void m124if() {
        if (this.f125void == null) {
            return;
        }
        try {
            c cVar = new c(this.f125void.getScanResults(), this.b);
            this.b = 0L;
            if (this.f115case == null || !cVar.m140if(this.f115case)) {
                this.f115case = cVar;
            }
        } catch (Exception e) {
        }
    }

    public boolean a() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f123long <= 10000) {
            return false;
        }
        this.f123long = currentTimeMillis;
        return m131new();
    }

    /* renamed from: byte  reason: not valid java name */
    public c m125byte() {
        if ((this.f115case == null || !this.f115case.m141int()) && this.f125void != null) {
            try {
                return new c(this.f125void.getScanResults(), 0L);
            } catch (Exception e) {
                return new c(null, 0L);
            }
        }
        return this.f115case;
    }

    /* renamed from: case  reason: not valid java name */
    public void m126case() {
        if (this.c == null) {
            this.c = new a();
        }
        try {
            if (!j.f205try || this.f118else) {
                return;
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            this.f120goto.registerReceiver(this.c, intentFilter);
            m122goto();
            this.f118else = true;
        } catch (Exception e) {
        }
    }

    /* renamed from: char  reason: not valid java name */
    public String m127char() {
        WifiInfo connectionInfo = this.f125void.getConnectionInfo();
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
    public void m128else() {
        if (this.f122int) {
            try {
                this.f120goto.unregisterReceiver(this.f116char);
                if (j.f205try) {
                    this.f120goto.unregisterReceiver(this.c);
                }
            } catch (Exception e) {
            }
            this.f116char = null;
            this.f125void = null;
            this.c = null;
            this.f122int = false;
            j.a(f114try, "wifimanager stop ...");
        }
    }

    /* renamed from: for  reason: not valid java name */
    public void m129for() {
        if (!this.f117do && j.f205try && j.J) {
            this.f121if.postDelayed(new d(), j.h);
            this.f117do = true;
        }
    }

    /* renamed from: int  reason: not valid java name */
    public c m130int() {
        if ((this.f115case == null || !this.f115case.m135do()) && this.f125void != null) {
            try {
                return new c(this.f125void.getScanResults(), 0L);
            } catch (Exception e) {
                return new c(null, 0L);
            }
        }
        return this.f115case;
    }

    /* renamed from: new  reason: not valid java name */
    public boolean m131new() {
        if (this.f125void == null) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.b > 3000) {
            try {
                if (!this.f125void.isWifiEnabled()) {
                    this.b = 0L;
                    return false;
                }
                if (this.e == null || this.g == null) {
                    this.f125void.startScan();
                } else {
                    try {
                        this.e.invoke(this.g, Boolean.valueOf(this.f119for));
                    } catch (Exception e) {
                        e.printStackTrace();
                        this.f125void.startScan();
                    }
                }
                this.b = currentTimeMillis;
                j.a(f114try, "wifimanager start scan ...");
                return true;
            } catch (Exception e2) {
                return false;
            }
        }
        return false;
    }

    /* renamed from: try  reason: not valid java name */
    public void m132try() {
        if (this.f122int) {
            return;
        }
        this.f125void = (WifiManager) this.f120goto.getSystemService("wifi");
        this.f116char = new b();
        try {
            this.f120goto.registerReceiver(this.f116char, new IntentFilter("android.net.wifi.SCAN_RESULTS"));
            this.c = new a();
            if (j.f205try) {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                this.f120goto.registerReceiver(this.c, intentFilter);
                this.f118else = true;
                m122goto();
            }
        } catch (Exception e) {
        }
        this.f122int = true;
        j.a(f114try, "wifimanager start ...");
        try {
            Field declaredField = Class.forName("android.net.wifi.WifiManager").getDeclaredField("mService");
            if (declaredField == null) {
                j.a(f114try, "android.net.wifi.WifiManager.mService  NOT  found ...");
            } else {
                declaredField.setAccessible(true);
                this.g = declaredField.get(this.f125void);
                Class<?> cls = this.g.getClass();
                j.a(f114try, "mserviceClass : " + cls.getName());
                this.e = cls.getDeclaredMethod("startScan", Boolean.TYPE);
                if (this.e == null) {
                    j.a(f114try, "mService.startScan NOT  found ...");
                } else {
                    this.e.setAccessible(true);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
