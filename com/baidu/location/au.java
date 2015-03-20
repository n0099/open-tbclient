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
import android.os.Build;
import android.text.TextUtils;
import com.baidu.tbadk.TbConfig;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.regex.Pattern;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class au implements a0, n {
    private static final int ij = 15;
    private static au is = null;
    private final long ii = 3000;
    private final long io = 3000;
    private final long iq = TbConfig.NOTIFY_SOUND_INTERVAL;
    private WifiManager ir = null;
    private a iw = null;
    private b im = null;
    private long ip = 0;
    private long iv = 0;
    private boolean iu = false;
    private Object in = null;
    private Method it = null;
    private boolean ik = true;
    private long il = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends BroadcastReceiver {
        private a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (context != null && intent.getAction().equals("android.net.wifi.SCAN_RESULTS")) {
                au.this.il = System.currentTimeMillis() / 1000;
                au.this.cb();
                ad.br().obtainMessage(41).sendToTarget();
                if (ag.bz().bC()) {
                    ag.bz().hl.obtainMessage(41).sendToTarget();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b {

        /* renamed from: do  reason: not valid java name */
        private boolean f73do;

        /* renamed from: for  reason: not valid java name */
        public List f74for;

        /* renamed from: if  reason: not valid java name */
        private long f75if;

        /* renamed from: int  reason: not valid java name */
        private long f76int;

        /* renamed from: new  reason: not valid java name */
        private boolean f77new;

        public b(b bVar) {
            this.f74for = null;
            this.f75if = 0L;
            this.f76int = 0L;
            this.f73do = false;
            if (bVar != null) {
                this.f74for = bVar.f74for;
                this.f75if = bVar.f75if;
                this.f76int = bVar.f76int;
                this.f73do = bVar.f73do;
            }
        }

        public b(List list, long j) {
            this.f74for = null;
            this.f75if = 0L;
            this.f76int = 0L;
            this.f73do = false;
            this.f75if = j;
            this.f74for = list;
            this.f76int = System.currentTimeMillis();
            a();
            c.m273if(a0.i, m225int());
        }

        private void a() {
            boolean z;
            if (m227try() < 1) {
                return;
            }
            boolean z2 = true;
            for (int size = this.f74for.size() - 1; size >= 1 && z2; size--) {
                int i = 0;
                z2 = false;
                while (i < size) {
                    if (((ScanResult) this.f74for.get(i)).level < ((ScanResult) this.f74for.get(i + 1)).level) {
                        this.f74for.set(i + 1, this.f74for.get(i));
                        this.f74for.set(i, (ScanResult) this.f74for.get(i + 1));
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
            try {
                if (m227try() < 1) {
                    return null;
                }
                StringBuffer stringBuffer = new StringBuffer(512);
                int size = this.f74for.size();
                if (size <= i) {
                    i = size;
                }
                for (int i2 = 0; i2 < i; i2++) {
                    if (((ScanResult) this.f74for.get(i2)).level != 0) {
                        stringBuffer.append(String.format(Locale.CHINA, "<access-point>\n<mac>%s</mac>\n<signal-strength>%d</signal-strength>\n</access-point>\n", ((ScanResult) this.f74for.get(i2)).BSSID.replace(":", ""), Integer.valueOf(((ScanResult) this.f74for.get(i2)).level)));
                    }
                }
                return stringBuffer.toString();
            } catch (Exception e) {
                return null;
            }
        }

        public boolean a(b bVar) {
            return au.m212if(bVar, this, c.X);
        }

        /* renamed from: byte  reason: not valid java name */
        public String m214byte() {
            try {
                return m222if(15);
            } catch (Exception e) {
                return null;
            }
        }

        /* renamed from: case  reason: not valid java name */
        public boolean m215case() {
            return this.f73do;
        }

        /* renamed from: char  reason: not valid java name */
        public String m216char() {
            try {
                return m222if(c.a2);
            } catch (Exception e) {
                return null;
            }
        }

        /* renamed from: do  reason: not valid java name */
        public int m217do() {
            for (int i = 0; i < m227try(); i++) {
                int i2 = -((ScanResult) this.f74for.get(i)).level;
                if (i2 > 0) {
                    return i2;
                }
            }
            return 0;
        }

        /* renamed from: do  reason: not valid java name */
        public String m218do(int i) {
            int i2 = 0;
            if (i == 0 || m227try() < 1) {
                return null;
            }
            StringBuffer stringBuffer = new StringBuffer(256);
            if (this.f74for.size() > c.a2) {
                int i3 = c.a2;
            }
            int i4 = 0;
            int i5 = 1;
            while (true) {
                int i6 = i2;
                if (i6 >= c.a2) {
                    return stringBuffer.toString();
                }
                if ((i5 & i) != 0) {
                    if (i4 == 0) {
                        stringBuffer.append("&ssid=");
                    } else {
                        stringBuffer.append("|");
                    }
                    stringBuffer.append(((ScanResult) this.f74for.get(i6)).BSSID);
                    stringBuffer.append(";");
                    stringBuffer.append(((ScanResult) this.f74for.get(i6)).SSID);
                    i4++;
                }
                i5 <<= 1;
                i2 = i6 + 1;
            }
        }

        /* renamed from: do  reason: not valid java name */
        public boolean m219do(b bVar) {
            if (this.f74for == null || bVar == null || bVar.f74for == null) {
                return false;
            }
            int size = this.f74for.size() < bVar.f74for.size() ? this.f74for.size() : bVar.f74for.size();
            for (int i = 0; i < size; i++) {
                String str = ((ScanResult) this.f74for.get(i)).BSSID;
                int i2 = ((ScanResult) this.f74for.get(i)).level;
                String str2 = ((ScanResult) bVar.f74for.get(i)).BSSID;
                int i3 = ((ScanResult) bVar.f74for.get(i)).level;
                if (!str.equals(str2) || i2 != i3) {
                    return false;
                }
            }
            return true;
        }

        /* renamed from: else  reason: not valid java name */
        public String m220else() {
            boolean z;
            StringBuffer stringBuffer = new StringBuffer(512);
            stringBuffer.append("wifi info:");
            if (m227try() < 1) {
                return stringBuffer.toString();
            }
            int size = this.f74for.size();
            if (size > 10) {
                size = 10;
            }
            int i = 0;
            boolean z2 = true;
            while (i < size) {
                if (((ScanResult) this.f74for.get(i)).level == 0) {
                    z = z2;
                } else if (z2) {
                    stringBuffer.append("wifi=");
                    stringBuffer.append(((ScanResult) this.f74for.get(i)).BSSID.replace(":", ""));
                    stringBuffer.append(String.format(Locale.CHINA, ";%d;", Integer.valueOf(((ScanResult) this.f74for.get(i)).level)));
                    z = false;
                } else {
                    stringBuffer.append(";");
                    stringBuffer.append(((ScanResult) this.f74for.get(i)).BSSID.replace(":", ""));
                    stringBuffer.append(String.format(Locale.CHINA, ",%d;", Integer.valueOf(((ScanResult) this.f74for.get(i)).level)));
                    z = z2;
                }
                i++;
                z2 = z;
            }
            return stringBuffer.toString();
        }

        /* renamed from: for  reason: not valid java name */
        public boolean m221for() {
            return System.currentTimeMillis() - this.f76int < 3000;
        }

        /* renamed from: if  reason: not valid java name */
        public String m222if(int i) {
            char c;
            int i2;
            char c2;
            boolean z;
            int i3;
            if (m227try() < 1) {
                return null;
            }
            char c3 = 0;
            Random random = new Random();
            StringBuffer stringBuffer = new StringBuffer(512);
            String ck = au.this.ck();
            int i4 = 0;
            int i5 = 0;
            int size = this.f74for.size();
            boolean z2 = true;
            if (size <= i) {
                i = size;
            }
            int i6 = 0;
            while (i6 < i) {
                if (((ScanResult) this.f74for.get(i6)).level == 0) {
                    z = z2;
                    i3 = i4;
                    int i7 = i5;
                    c2 = c3;
                    i2 = i7;
                } else {
                    if (z2) {
                        z2 = false;
                        stringBuffer.append("&wf=");
                    } else {
                        stringBuffer.append("|");
                    }
                    String replace = ((ScanResult) this.f74for.get(i6)).BSSID.replace(":", "");
                    stringBuffer.append(replace);
                    int i8 = ((ScanResult) this.f74for.get(i6)).level;
                    if (i8 < 0) {
                        i8 = -i8;
                    }
                    stringBuffer.append(String.format(Locale.CHINA, ";%d;", Integer.valueOf(i8)));
                    int i9 = i4 + 1;
                    if (ck != null && ck.equals(replace)) {
                        this.f77new = au.this.r(((ScanResult) this.f74for.get(i6)).capabilities);
                        i5 = i9;
                    }
                    if (c3 == 0) {
                        try {
                            if (random.nextInt(10) == 2 && ((ScanResult) this.f74for.get(i6)).SSID != null && ((ScanResult) this.f74for.get(i6)).SSID.length() < 30) {
                                stringBuffer.append(((ScanResult) this.f74for.get(i6)).SSID);
                                c = 1;
                            }
                            c = c3;
                        } catch (Exception e) {
                            z = z2;
                            i3 = i9;
                            int i10 = i5;
                            c2 = c3;
                            i2 = i10;
                        }
                    } else {
                        if (c3 == 1 && random.nextInt(20) == 1 && ((ScanResult) this.f74for.get(i6)).SSID != null && ((ScanResult) this.f74for.get(i6)).SSID.length() < 30) {
                            stringBuffer.append(((ScanResult) this.f74for.get(i6)).SSID);
                            c = 2;
                        }
                        c = c3;
                    }
                    i2 = i5;
                    c2 = c;
                    z = z2;
                    i3 = i9;
                }
                i6++;
                i4 = i3;
                z2 = z;
                int i11 = i2;
                c3 = c2;
                i5 = i11;
            }
            if (z2) {
                return null;
            }
            stringBuffer.append("&wf_n=" + i5);
            stringBuffer.append("&wf_st=");
            stringBuffer.append(this.f75if);
            stringBuffer.append("&wf_et=");
            stringBuffer.append(this.f76int);
            stringBuffer.append("&wf_vt=");
            stringBuffer.append(au.this.il);
            if (i5 > 0) {
                this.f73do = true;
                stringBuffer.append("&wf_en=");
                stringBuffer.append(this.f77new ? 1 : 0);
            }
            return stringBuffer.toString();
        }

        /* renamed from: if  reason: not valid java name */
        public boolean m223if() {
            return System.currentTimeMillis() - this.f75if < 3000;
        }

        /* renamed from: if  reason: not valid java name */
        public boolean m224if(b bVar) {
            if (this.f74for == null || bVar == null || bVar.f74for == null) {
                return false;
            }
            int size = this.f74for.size() < bVar.f74for.size() ? this.f74for.size() : bVar.f74for.size();
            for (int i = 0; i < size; i++) {
                if (!((ScanResult) this.f74for.get(i)).BSSID.equals(((ScanResult) bVar.f74for.get(i)).BSSID)) {
                    return false;
                }
            }
            return true;
        }

        /* renamed from: int  reason: not valid java name */
        public String m225int() {
            StringBuilder sb = new StringBuilder();
            sb.append("wifi=");
            if (this.f74for == null) {
                return sb.toString();
            }
            for (int i = 0; i < this.f74for.size(); i++) {
                int i2 = ((ScanResult) this.f74for.get(i)).level;
                sb.append(((ScanResult) this.f74for.get(i)).BSSID.replace(":", ""));
                sb.append(String.format(Locale.CHINA, ",%d;", Integer.valueOf(i2)));
            }
            return sb.toString();
        }

        /* renamed from: new  reason: not valid java name */
        public boolean m226new() {
            return System.currentTimeMillis() - this.f76int < TbConfig.NOTIFY_SOUND_INTERVAL;
        }

        /* renamed from: try  reason: not valid java name */
        public int m227try() {
            if (this.f74for == null) {
                return 0;
            }
            return this.f74for.size();
        }
    }

    private au() {
    }

    public static boolean ca() {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) f.getServiceContext().getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                if (activeNetworkInfo.getType() == 1) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cb() {
        if (this.ir == null) {
            return;
        }
        try {
            b bVar = new b(this.ir.getScanResults(), this.ip);
            this.ip = 0L;
            if (this.im == null || !bVar.m224if(this.im)) {
                this.im = bVar;
            }
        } catch (Exception e) {
        }
    }

    public static au cc() {
        if (is == null) {
            is = new au();
        }
        return is;
    }

    /* renamed from: if  reason: not valid java name */
    public static double m209if(b bVar, b bVar2) {
        int i;
        if (bVar == null || bVar2 == null) {
            return 0.0d;
        }
        List list = bVar.f74for;
        List list2 = bVar2.f74for;
        if (list != list2) {
            if (list == null || list2 == null) {
                return 0.0d;
            }
            int size = list.size();
            int size2 = list2.size();
            float f = size + size2;
            if (size == 0 && size2 == 0) {
                return 1.0d;
            }
            if (size == 0 || size2 == 0) {
                return 0.0d;
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
            if (f <= 0.0f) {
                return 0.0d;
            }
            return i3 / f;
        }
        return 1.0d;
    }

    /* renamed from: if  reason: not valid java name */
    public static boolean m212if(b bVar, b bVar2, float f) {
        int i;
        if (bVar == null || bVar2 == null) {
            return false;
        }
        List list = bVar.f74for;
        List list2 = bVar2.f74for;
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
        return ((float) (i3 * 2)) >= f2 * f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean r(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return Pattern.compile("wpa|wep", 2).matcher(str).find();
    }

    public b b7() {
        return (this.im == null || !this.im.m221for()) ? ce() : this.im;
    }

    public synchronized void b8() {
        if (this.iu) {
            try {
                f.getServiceContext().unregisterReceiver(this.iw);
                this.il = 0L;
            } catch (Exception e) {
            }
            this.iw = null;
            this.ir = null;
            this.iu = false;
        }
    }

    public boolean b9() {
        if (this.ir == null) {
            return false;
        }
        return this.ir.isScanAlwaysAvailable();
    }

    public boolean cd() {
        if (this.ir != null && System.currentTimeMillis() - this.ip > 3000) {
            return cl();
        }
        return false;
    }

    public b ce() {
        if (this.ir != null) {
            try {
                return new b(this.ir.getScanResults(), 0L);
            } catch (Exception e) {
            }
        }
        return new b(null, 0L);
    }

    public boolean cf() {
        return this.ir.isWifiEnabled() && 3 == this.ir.getWifiState();
    }

    public String cg() {
        try {
            WifiInfo connectionInfo = this.ir.getConnectionInfo();
            if (connectionInfo != null) {
                return connectionInfo.getMacAddress();
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    public b ch() {
        return (this.im == null || !this.im.m226new()) ? ce() : this.im;
    }

    public synchronized void ci() {
        if (!this.iu && ad.gO) {
            this.ir = (WifiManager) f.getServiceContext().getSystemService("wifi");
            this.iw = new a();
            try {
                f.getServiceContext().registerReceiver(this.iw, new IntentFilter("android.net.wifi.SCAN_RESULTS"));
            } catch (Exception e) {
            }
            this.iu = true;
            try {
                Field declaredField = Class.forName("android.net.wifi.WifiManager").getDeclaredField("mService");
                if (declaredField != null) {
                    declaredField.setAccessible(true);
                    this.in = declaredField.get(this.ir);
                    this.it = this.in.getClass().getDeclaredMethod("startScan", Boolean.TYPE);
                    if (this.it != null) {
                        this.it.setAccessible(true);
                    }
                }
            } catch (Exception e2) {
            }
        }
    }

    public boolean cj() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.iv <= 10000) {
            return false;
        }
        this.iv = currentTimeMillis;
        return cd();
    }

    public String ck() {
        String str;
        WifiInfo connectionInfo = this.ir.getConnectionInfo();
        if (connectionInfo == null) {
            return null;
        }
        try {
            String bssid = connectionInfo.getBSSID();
            if (bssid != null) {
                str = bssid.replace(":", "");
                if ("000000000000".equals(str)) {
                    return null;
                }
                if ("".equals(str)) {
                    return null;
                }
            } else {
                str = null;
            }
            return str;
        } catch (Exception e) {
            return null;
        }
    }

    public boolean cl() {
        try {
            if (!this.ir.isWifiEnabled() && (Build.VERSION.SDK_INT <= 17 || !this.ir.isScanAlwaysAvailable())) {
                this.ip = 0L;
                return false;
            }
            if (this.it == null || this.in == null) {
                this.ir.startScan();
            } else {
                try {
                    this.it.invoke(this.in, Boolean.valueOf(this.ik));
                } catch (Exception e) {
                    this.ir.startScan();
                }
            }
            this.ip = System.currentTimeMillis();
            return true;
        } catch (Exception e2) {
            return false;
        }
    }
}
