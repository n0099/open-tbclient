package com.baidu.location;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e {

    /* renamed from: new  reason: not valid java name */
    private static String f111new = f.g;

    /* renamed from: try  reason: not valid java name */
    private static final int f112try = 15;

    /* renamed from: goto  reason: not valid java name */
    private Context f119goto;

    /* renamed from: if  reason: not valid java name */
    private Handler f120if;
    private final long e = 3000;

    /* renamed from: int  reason: not valid java name */
    private final long f121int = 3000;
    private final long a = 15000;

    /* renamed from: char  reason: not valid java name */
    private final float f115char = 0.5f;

    /* renamed from: long  reason: not valid java name */
    private WifiManager f122long = null;

    /* renamed from: case  reason: not valid java name */
    private b f114case = null;
    private a b = null;

    /* renamed from: byte  reason: not valid java name */
    private c f113byte = null;

    /* renamed from: void  reason: not valid java name */
    private long f123void = 0;

    /* renamed from: for  reason: not valid java name */
    private boolean f118for = false;
    private Object f = null;
    private Method d = null;

    /* renamed from: do  reason: not valid java name */
    private boolean f116do = true;
    private boolean c = false;

    /* renamed from: else  reason: not valid java name */
    private boolean f117else = false;

    /* loaded from: classes.dex */
    private class a extends BroadcastReceiver {
        private a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (context == null || e.this.f120if == null) {
                return;
            }
            e.this.m95char();
        }
    }

    /* loaded from: classes.dex */
    private class b extends BroadcastReceiver {
        private b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (context == null || e.this.f120if == null) {
                return;
            }
            e.this.m99if();
            e.this.f120if.obtainMessage(41).sendToTarget();
            j.a(e.f111new, "wifi manager receive new wifi...");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public class c {

        /* renamed from: do  reason: not valid java name */
        public List f124do;

        /* renamed from: for  reason: not valid java name */
        private long f125for;

        /* renamed from: if  reason: not valid java name */
        private long f126if;

        public c(List list, long j) {
            this.f124do = null;
            this.f126if = 0L;
            this.f125for = 0L;
            this.f126if = j;
            this.f124do = list;
            this.f125for = System.currentTimeMillis();
            a();
            j.m188if(e.f111new, m108do());
        }

        private void a() {
            boolean z;
            if (m113int() < 1) {
                return;
            }
            boolean z2 = true;
            for (int size = this.f124do.size() - 1; size >= 1 && z2; size--) {
                int i = 0;
                z2 = false;
                while (i < size) {
                    if (((ScanResult) this.f124do.get(i)).level < ((ScanResult) this.f124do.get(i + 1)).level) {
                        this.f124do.set(i + 1, this.f124do.get(i));
                        this.f124do.set(i, (ScanResult) this.f124do.get(i + 1));
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
            if (m113int() < 1) {
                return null;
            }
            StringBuffer stringBuffer = new StringBuffer(512);
            String m100byte = e.this.m100byte();
            int size = this.f124do.size();
            if (size <= i) {
                i = size;
            }
            int i3 = 0;
            boolean z2 = true;
            int i4 = 0;
            int i5 = 0;
            while (i3 < i) {
                if (((ScanResult) this.f124do.get(i3)).level == 0) {
                    z = z2;
                    i2 = i5;
                } else if (z2) {
                    stringBuffer.append("&wf=");
                    String replace = ((ScanResult) this.f124do.get(i3)).BSSID.replace(":", "");
                    stringBuffer.append(replace);
                    int i6 = ((ScanResult) this.f124do.get(i3)).level;
                    if (i6 < 0) {
                        i6 = -i6;
                    }
                    stringBuffer.append(String.format(";%d;", Integer.valueOf(i6)));
                    i2 = i5 + 1;
                    i4 = (m100byte == null || !m100byte.equals(replace)) ? i4 : i2;
                    z = false;
                } else {
                    stringBuffer.append("|");
                    String replace2 = ((ScanResult) this.f124do.get(i3)).BSSID.replace(":", "");
                    stringBuffer.append(replace2);
                    int i7 = ((ScanResult) this.f124do.get(i3)).level;
                    if (i7 < 0) {
                        i7 = -i7;
                    }
                    stringBuffer.append(String.format(";%d;", Integer.valueOf(i7)));
                    int i8 = i5 + 1;
                    if (m100byte == null || !m100byte.equals(replace2)) {
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
            j.a(e.f111new, m100byte + i4);
            if (i4 > 0) {
                stringBuffer.append("&wf_n=" + i4);
            }
            stringBuffer.append("&wf_st=");
            stringBuffer.append(this.f126if);
            stringBuffer.append("&wf_et=");
            stringBuffer.append(this.f125for);
            return stringBuffer.toString();
        }

        public boolean a(c cVar) {
            return a(cVar, this, 0.5f);
        }

        public boolean a(c cVar, c cVar2, float f) {
            int i;
            if (cVar == null || cVar2 == null) {
                return false;
            }
            List list = cVar.f124do;
            List list2 = cVar2.f124do;
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
            j.a(e.f111new, String.format("same %d,total %f,rate %f...", Integer.valueOf(i3), Float.valueOf(f2), Float.valueOf(f)));
            return ((float) (i3 * 2)) >= f2 * f;
        }

        /* renamed from: byte  reason: not valid java name */
        public String m107byte() {
            boolean z;
            StringBuffer stringBuffer = new StringBuffer(512);
            stringBuffer.append("wifi info:");
            if (m113int() < 1) {
                return stringBuffer.toString();
            }
            int size = this.f124do.size();
            if (size > 10) {
                size = 10;
            }
            int i = 0;
            boolean z2 = true;
            while (i < size) {
                if (((ScanResult) this.f124do.get(i)).level == 0) {
                    z = z2;
                } else if (z2) {
                    stringBuffer.append("wifi=");
                    stringBuffer.append(((ScanResult) this.f124do.get(i)).BSSID.replace(":", ""));
                    stringBuffer.append(String.format(";%d;", Integer.valueOf(((ScanResult) this.f124do.get(i)).level)));
                    z = false;
                } else {
                    stringBuffer.append(";");
                    stringBuffer.append(((ScanResult) this.f124do.get(i)).BSSID.replace(":", ""));
                    stringBuffer.append(String.format(",%d;", Integer.valueOf(((ScanResult) this.f124do.get(i)).level)));
                    z = z2;
                }
                i++;
                z2 = z;
            }
            return stringBuffer.toString();
        }

        /* renamed from: do  reason: not valid java name */
        public String m108do() {
            StringBuilder sb = new StringBuilder();
            sb.append("wifi=");
            if (this.f124do == null) {
                return sb.toString();
            }
            for (int i = 0; i < this.f124do.size(); i++) {
                int i2 = ((ScanResult) this.f124do.get(i)).level;
                sb.append(((ScanResult) this.f124do.get(i)).BSSID.replace(":", ""));
                sb.append(String.format(",%d;", Integer.valueOf(i2)));
            }
            return sb.toString();
        }

        /* renamed from: for  reason: not valid java name */
        public boolean m109for() {
            return System.currentTimeMillis() - this.f125for < 15000;
        }

        /* renamed from: if  reason: not valid java name */
        public String m110if(int i) {
            int i2 = 0;
            if (i == 0 || m113int() < 1) {
                return null;
            }
            StringBuffer stringBuffer = new StringBuffer((int) AccessibilityEventCompat.TYPE_VIEW_HOVER_EXIT);
            int i3 = 0;
            int i4 = 1;
            while (true) {
                int i5 = i2;
                if (i5 >= j.f188new) {
                    return stringBuffer.toString();
                }
                if ((i4 & i) != 0) {
                    if (i3 == 0) {
                        stringBuffer.append("&ssid=");
                    } else {
                        stringBuffer.append("|");
                    }
                    stringBuffer.append(((ScanResult) this.f124do.get(i5)).BSSID);
                    stringBuffer.append(";");
                    stringBuffer.append(((ScanResult) this.f124do.get(i5)).SSID);
                    i3++;
                }
                i4 <<= 1;
                i2 = i5 + 1;
            }
        }

        /* renamed from: if  reason: not valid java name */
        public boolean m111if() {
            return System.currentTimeMillis() - this.f125for < 3000;
        }

        /* renamed from: if  reason: not valid java name */
        public boolean m112if(c cVar) {
            if (this.f124do == null || cVar == null || cVar.f124do == null) {
                return false;
            }
            int size = this.f124do.size() < cVar.f124do.size() ? this.f124do.size() : cVar.f124do.size();
            for (int i = 0; i < size; i++) {
                if (!((ScanResult) this.f124do.get(i)).BSSID.equals(((ScanResult) cVar.f124do.get(i)).BSSID)) {
                    return false;
                }
            }
            return true;
        }

        /* renamed from: int  reason: not valid java name */
        public int m113int() {
            if (this.f124do == null) {
                return 0;
            }
            return this.f124do.size();
        }

        /* renamed from: new  reason: not valid java name */
        public String m114new() {
            return a(15);
        }

        /* renamed from: try  reason: not valid java name */
        public String m115try() {
            return a(j.f188new);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class d implements Runnable {
        private d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (e.this.c) {
                e.this.f120if.obtainMessage(91).sendToTarget();
                e.this.f120if.postDelayed(this, j.f183for);
            }
        }
    }

    public e(Context context, Handler handler) {
        this.f120if = null;
        this.f119goto = context;
        this.f120if = handler;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: char  reason: not valid java name */
    public void m95char() {
        if (NetworkInfo.State.CONNECTED != ((ConnectivityManager) this.f119goto.getSystemService("connectivity")).getNetworkInfo(1).getState()) {
            this.c = false;
        } else if (this.c) {
        } else {
            this.c = true;
            this.f120if.postDelayed(new d(), j.f183for);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: if  reason: not valid java name */
    public void m99if() {
        if (this.f122long == null) {
            return;
        }
        c cVar = new c(this.f122long.getScanResults(), this.f123void);
        this.f123void = 0L;
        if (this.f113byte == null || !cVar.m112if(this.f113byte)) {
            this.f113byte = cVar;
        }
    }

    /* renamed from: byte  reason: not valid java name */
    public String m100byte() {
        String bssid = this.f122long.getConnectionInfo().getBSSID();
        if (bssid != null) {
            return bssid.replace(":", "");
        }
        return null;
    }

    /* renamed from: case  reason: not valid java name */
    public void m101case() {
        if (this.f118for) {
            try {
                this.f119goto.unregisterReceiver(this.f114case);
                if (j.f181do) {
                    this.f119goto.unregisterReceiver(this.b);
                }
            } catch (Exception e) {
            }
            this.f114case = null;
            this.f122long = null;
            this.b = null;
            this.f118for = false;
            j.a(f111new, "wifimanager stop ...");
        }
    }

    /* renamed from: do  reason: not valid java name */
    public c m102do() {
        return ((this.f113byte == null || !this.f113byte.m111if()) && this.f122long != null) ? new c(this.f122long.getScanResults(), 0L) : this.f113byte;
    }

    /* renamed from: for  reason: not valid java name */
    public boolean m103for() {
        if (this.f122long == null) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f123void > 3000) {
            if (!this.f122long.isWifiEnabled()) {
                this.f123void = 0L;
                return false;
            }
            if (this.d == null || this.f == null) {
                this.f122long.startScan();
            } else {
                try {
                    this.d.invoke(this.f, Boolean.valueOf(this.f116do));
                } catch (Exception e) {
                    e.printStackTrace();
                    this.f122long.startScan();
                }
            }
            this.f123void = currentTimeMillis;
            j.a(f111new, "wifimanager start scan ...");
            return true;
        }
        return false;
    }

    /* renamed from: int  reason: not valid java name */
    public void m104int() {
        if (this.f118for) {
            return;
        }
        this.f122long = (WifiManager) this.f119goto.getSystemService("wifi");
        this.f114case = new b();
        try {
            this.f119goto.registerReceiver(this.f114case, new IntentFilter("android.net.wifi.SCAN_RESULTS"));
            this.b = new a();
            if (j.f181do) {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                this.f119goto.registerReceiver(this.b, intentFilter);
                this.f117else = true;
                m95char();
            }
        } catch (Exception e) {
        }
        this.f118for = true;
        j.a(f111new, "wifimanager start ...");
        try {
            Field declaredField = Class.forName("android.net.wifi.WifiManager").getDeclaredField("mService");
            if (declaredField == null) {
                j.a(f111new, "android.net.wifi.WifiManager.mService  NOT  found ...");
            } else {
                declaredField.setAccessible(true);
                this.f = declaredField.get(this.f122long);
                Class<?> cls = this.f.getClass();
                j.a(f111new, "mserviceClass : " + cls.getName());
                this.d = cls.getDeclaredMethod("startScan", Boolean.TYPE);
                if (this.d == null) {
                    j.a(f111new, "mService.startScan NOT  found ...");
                } else {
                    this.d.setAccessible(true);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* renamed from: new  reason: not valid java name */
    public c m105new() {
        return ((this.f113byte == null || !this.f113byte.m109for()) && this.f122long != null) ? new c(this.f122long.getScanResults(), 0L) : this.f113byte;
    }

    /* renamed from: try  reason: not valid java name */
    public void m106try() {
        if (this.b == null) {
            this.b = new a();
        }
        try {
            if (!j.f181do || this.f117else) {
                return;
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            this.f119goto.registerReceiver(this.b, intentFilter);
            m95char();
        } catch (Exception e) {
        }
    }
}
