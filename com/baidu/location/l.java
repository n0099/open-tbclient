package com.baidu.location;

import android.app.AlarmManager;
import android.app.KeyguardManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.ScanResult;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.location.au;
import com.baidu.location.u;
import com.baidu.tbadk.TbConfig;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements a0, n {
    private static final int b7 = 200;
    private static final int bM = 800;
    public static final String bO = "com.baidu.locTest.LocationServer5.0.1";
    private static final int bY = 24;
    ArrayList b0;
    long b8;
    private Handler bC;
    private boolean bG;
    private AlarmManager bK;
    private PendingIntent bL;
    private Context bN;
    private long bU;
    ArrayList bX;
    private long bZ;
    c bz;
    private a ca;
    private static String b1 = I + "/glb.dat";
    private static File bF = null;
    private static File b9 = null;
    private String bI = I + "/vm.dat";
    private final long bA = 86100000;
    private final int b3 = b7;
    private long[] bE = new long[20];
    private int bJ = 0;
    private u.a bT = null;
    private String bP = null;
    private int b5 = 1;
    private boolean bH = false;
    private boolean bR = false;
    private boolean b6 = false;
    private final int bV = 1;
    private int b4 = 0;
    private long bS = 0;
    private long bQ = 0;
    private long b2 = 0;
    private String bB = "";
    private boolean bD = false;
    String bW = "dlcu.dat";

    /* loaded from: classes.dex */
    public class a extends BroadcastReceiver {
        public a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals(l.bO)) {
                l.this.bC.sendEmptyMessage(1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b {

        /* renamed from: do  reason: not valid java name */
        public static final double f100do = 0.8d;

        /* renamed from: if  reason: not valid java name */
        public static final double f101if = 0.7d;

        /* renamed from: for  reason: not valid java name */
        private double f102for;

        /* renamed from: int  reason: not valid java name */
        private HashMap f103int = new HashMap();

        public b(au.b bVar) {
            int abs;
            this.f102for = 1.0d;
            if (bVar.f74for != null) {
                int i = 0;
                Iterator it = bVar.f74for.iterator();
                while (true) {
                    int i2 = i;
                    if (!it.hasNext()) {
                        break;
                    }
                    ScanResult scanResult = (ScanResult) it.next();
                    this.f103int.put(scanResult.BSSID, Integer.valueOf(Math.abs(scanResult.level)));
                    this.f102for += (100 - abs) * (100 - abs);
                    i = i2 + 1;
                    if (i > 16) {
                        break;
                    }
                }
                this.f102for = Math.sqrt(this.f102for);
            }
        }

        public double a() {
            return this.f102for;
        }

        double a(b bVar) {
            Integer num;
            double d = 0.0d;
            for (String str : this.f103int.keySet()) {
                int intValue = ((Integer) this.f103int.get(str)).intValue();
                if (((Integer) bVar.m311if().get(str)) != null) {
                    d = ((100 - num.intValue()) * (100 - intValue)) + d;
                }
            }
            return d / (this.f102for * bVar.a());
        }

        /* renamed from: if  reason: not valid java name */
        public HashMap m311if() {
            return this.f103int;
        }
    }

    /* loaded from: classes.dex */
    class c extends BroadcastReceiver {

        /* renamed from: if  reason: not valid java name */
        boolean f104if = false;

        public c() {
            a(f.getServiceContext());
        }

        public void a(Context context) {
            if (this.f104if) {
                return;
            }
            this.f104if = true;
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            context.registerReceiver(this, intentFilter);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (!action.equals("android.intent.action.SCREEN_ON") && action.equals("android.intent.action.SCREEN_OFF")) {
                af.c0().cY();
            }
        }
    }

    public l(Context context) {
        this.bK = null;
        this.ca = null;
        this.bL = null;
        this.bN = null;
        this.bZ = 0L;
        this.bC = null;
        this.bG = false;
        this.bU = com.baidu.location.c.aT;
        this.bz = null;
        this.b0 = null;
        this.bX = null;
        this.b8 = 0L;
        this.bN = context;
        this.b8 = 0L;
        try {
            this.bz = new c();
        } catch (Exception e) {
            this.bz = null;
        }
        synchronized (this) {
            this.bC = new Handler() { // from class: com.baidu.location.l.1
                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    if (ad.gO) {
                        switch (message.what) {
                            case 1:
                                try {
                                    l.this.w();
                                    return;
                                } catch (Exception e2) {
                                    return;
                                }
                            default:
                                return;
                        }
                    }
                }
            };
            this.bZ = System.currentTimeMillis();
            this.bK = (AlarmManager) context.getSystemService("alarm");
            this.ca = new a();
            context.registerReceiver(this.ca, new IntentFilter(bO));
            this.bL = PendingIntent.getBroadcast(context, 0, new Intent(bO), 134217728);
            this.bK.set(0, System.currentTimeMillis() + 1000, this.bL);
            this.bU = com.baidu.location.c.aT;
            this.b0 = new ArrayList();
            this.bX = new ArrayList();
            u();
            this.bG = true;
        }
    }

    /* renamed from: if  reason: not valid java name */
    private void m309if(boolean z) {
        String m257case = com.baidu.location.c.m257case();
        if (m257case == null) {
            return;
        }
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(m257case + File.separator + "baidu/tempdata/" + this.bW, "rw");
            if (z) {
                randomAccessFile.seek(0L);
                randomAccessFile.writeLong(System.currentTimeMillis());
                randomAccessFile.writeInt(2125);
                this.b4 = 0;
                this.bS = System.currentTimeMillis();
            } else {
                randomAccessFile.seek(12L);
            }
            randomAccessFile.writeInt(this.b4);
            randomAccessFile.writeInt(2125);
            randomAccessFile.close();
        } catch (Exception e) {
        }
    }

    public static void r() {
        try {
            if (b1 == null) {
                b9 = null;
                return;
            }
            b9 = new File(b1);
            if (b9.exists()) {
                return;
            }
            File file = new File(I);
            if (!file.exists()) {
                file.mkdirs();
            }
            b9.createNewFile();
            RandomAccessFile randomAccessFile = new RandomAccessFile(b9, "rw");
            randomAccessFile.seek(0L);
            randomAccessFile.writeInt(-1);
            randomAccessFile.writeInt(-1);
            randomAccessFile.writeInt(0);
            randomAccessFile.writeLong(0L);
            randomAccessFile.writeInt(0);
            randomAccessFile.writeInt(0);
            randomAccessFile.close();
        } catch (Exception e) {
            b9 = null;
        }
    }

    public static String t() {
        return null;
    }

    private void u() {
        long j;
        int i;
        boolean z;
        String m257case = com.baidu.location.c.m257case();
        if (m257case == null) {
            return;
        }
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(m257case + File.separator + "baidu/tempdata/" + this.bW, "r");
            randomAccessFile.seek(0L);
            j = randomAccessFile.readLong();
            try {
                if (randomAccessFile.readInt() == 2125) {
                    i = randomAccessFile.readInt();
                    try {
                        z = randomAccessFile.readInt() == 2125;
                    } catch (Exception e) {
                        z = false;
                    }
                } else {
                    i = 0;
                    z = false;
                }
                try {
                    randomAccessFile.close();
                } catch (Exception e2) {
                }
            } catch (Exception e3) {
                i = 0;
                z = false;
            }
        } catch (Exception e4) {
            j = 0;
            i = 0;
            z = false;
        }
        if (z) {
            this.b4 = i;
            this.bS = j;
            return;
        }
        this.b4 = 0;
        this.bS = 0L;
    }

    /* renamed from: if  reason: not valid java name */
    boolean m310if(double d, double d2) {
        return (((-2.1971522d) * d) + ((-0.70587059d) * d2)) + 0.8428018d > 0.0d;
    }

    public boolean s() {
        return ((KeyguardManager) this.bN.getSystemService("keyguard")).inKeyguardRestrictedInputMode();
    }

    public synchronized void v() {
        this.bG = false;
        if (this.ca != null) {
            this.bN.unregisterReceiver(this.ca);
        }
        this.ca = null;
        if (this.bK != null && this.bL != null) {
            this.bK.cancel(this.bL);
        }
        this.bK = null;
        this.bL = null;
        bF = null;
        this.b0.clear();
        this.bX.clear();
        this.b0 = null;
        this.bX = null;
        this.b8 = 0L;
        this.b2 = 0L;
        this.bB = "";
        this.bD = false;
    }

    void w() {
        String str;
        int i;
        boolean z;
        boolean z2;
        String str2;
        int size;
        if (this.bG) {
            long currentTimeMillis = this.b2 != 0 ? (System.currentTimeMillis() - this.b2) + 30000 : 0L;
            this.b2 = System.currentTimeMillis();
            String m257case = com.baidu.location.c.m257case();
            if (m257case == null) {
                this.bK.set(0, System.currentTimeMillis() + com.baidu.location.c.aR, this.bL);
                return;
            }
            u.a at = u.au().at();
            if (at == null) {
                this.bK.set(0, System.currentTimeMillis() + com.baidu.location.c.aR, this.bL);
                return;
            }
            au.b ch = au.cc().ch();
            boolean z3 = false;
            if (this.b8 == 0) {
                z3 = true;
                this.b0.clear();
                this.bX.clear();
            }
            boolean z4 = z3;
            int i2 = 0;
            if (!z4 && (size = this.bX.size()) > 0 && at.a((u.a) this.bX.get(size - 1)) && this.b0.size() >= size) {
                au.b bVar = (au.b) this.b0.get(size - 1);
                if (!m310if(au.m209if(ch, bVar), new b(bVar).a(new b(ch)))) {
                    i2 = -1;
                }
            }
            boolean z5 = i2 < 0;
            if (!z5) {
                if (System.currentTimeMillis() - this.bS > 86400000 || System.currentTimeMillis() - this.bS < 0) {
                    this.b4 = 0;
                    m309if(true);
                } else {
                    this.b4++;
                    m309if(false);
                }
                if (this.b4 > com.baidu.location.c.ak) {
                    this.bQ = (this.bS + 86400000) - System.currentTimeMillis();
                }
            }
            if (this.bQ > 900000) {
                this.bU = this.bQ;
                this.bK.set(0, System.currentTimeMillis() + this.bU, this.bL);
                this.bQ = 0L;
            } else if (i2 < 0) {
                this.bU += com.baidu.location.c.aS;
                if (ch == null || ch.f74for == null || ch.f74for.size() == 0) {
                    if (this.bU > com.baidu.location.c.a8) {
                        this.bU = com.baidu.location.c.a8;
                    }
                } else if (this.bU > com.baidu.location.c.aR) {
                    this.bU = com.baidu.location.c.aR;
                }
                this.bK.set(0, System.currentTimeMillis() + this.bU, this.bL);
                this.bD = true;
            } else {
                this.bU = com.baidu.location.c.aT;
                this.bK.set(0, System.currentTimeMillis() + this.bU, this.bL);
                if (System.currentTimeMillis() - this.b8 > 840000) {
                    this.b0.clear();
                    this.bX.clear();
                }
            }
            this.b8 = System.currentTimeMillis();
            if (z5) {
                q.y().A();
                return;
            }
            StringBuffer stringBuffer = new StringBuffer((int) b7);
            if (z4) {
                stringBuffer.append("s");
            }
            stringBuffer.append("v");
            stringBuffer.append(5);
            int currentTimeMillis2 = (int) (System.currentTimeMillis() >> 15);
            stringBuffer.append("t");
            stringBuffer.append(currentTimeMillis2);
            if (at.a()) {
                if (at.f107byte == 460) {
                    stringBuffer.append("x,");
                } else {
                    stringBuffer.append("x");
                    stringBuffer.append(at.f107byte);
                    stringBuffer.append(",");
                }
                stringBuffer.append(at.f108case);
                stringBuffer.append(",");
                stringBuffer.append(at.a);
                stringBuffer.append(",");
                stringBuffer.append(at.f111for);
            }
            String ck = au.cc().ck();
            int i3 = 0;
            boolean z6 = false;
            String str3 = null;
            if (ch != null && ch.f74for != null) {
                int i4 = 0;
                while (true) {
                    if (i4 >= ch.f74for.size()) {
                        i = i3;
                        break;
                    }
                    String replace = ((ScanResult) ch.f74for.get(i4)).BSSID.replace(":", "");
                    int i5 = ((ScanResult) ch.f74for.get(i4)).level;
                    int i6 = i5 < 0 ? -i5 : i5;
                    if (i3 >= 3) {
                        z = z6;
                        i = i3;
                    } else if (i4 < 2 || z6 || ck == null || ck.equals(replace)) {
                        if (i4 == 0) {
                            stringBuffer.append("w");
                        } else {
                            stringBuffer.append(",");
                        }
                        stringBuffer.append(replace);
                        if (ck != null && ck.equals(replace)) {
                            String str4 = ((ScanResult) ch.f74for.get(i4)).capabilities;
                            if (TextUtils.isEmpty(str4)) {
                                stringBuffer.append("j");
                            } else {
                                String upperCase = str4.toUpperCase(Locale.CHINA);
                                if (upperCase.contains("WEP") || upperCase.contains("WPA")) {
                                    stringBuffer.append("l");
                                } else {
                                    stringBuffer.append("j");
                                }
                            }
                            z6 = true;
                        }
                        stringBuffer.append(";" + i6);
                        z = z6;
                        i = i3 + 1;
                    } else {
                        if (str3 == null) {
                            str2 = "," + replace + ";" + i6;
                            z2 = z6;
                            i = i3;
                        } else {
                            str2 = str3;
                            z2 = z6;
                            i = i3;
                        }
                        i4++;
                        i3 = i;
                        z6 = z2;
                        str3 = str2;
                    }
                    if (i > 2) {
                        break;
                    }
                    String str5 = str3;
                    z2 = z;
                    str2 = str5;
                    i4++;
                    i3 = i;
                    z6 = z2;
                    str3 = str2;
                }
                if (i < 3 && str3 != null) {
                    stringBuffer.append(str3);
                }
            }
            try {
                if (s()) {
                    str = "y2";
                } else {
                    str = "y1";
                    af.c0().m149long(currentTimeMillis2);
                }
            } catch (Exception e) {
                str = "y";
            }
            if (az.m252do().a() != null) {
                str = str + az.m252do().a();
            }
            stringBuffer.append(str);
            if (this.bD) {
                if (currentTimeMillis > 0) {
                    this.bB = "r" + (currentTimeMillis / TbConfig.USE_TIME_INTERVAL);
                    stringBuffer.append(this.bB);
                    this.bB = "";
                }
                this.bD = false;
            }
            System.currentTimeMillis();
            Jni.m21int(m257case, stringBuffer.toString());
            this.b0.add(ch);
            while (this.b0.size() > 3) {
                this.b0.remove(0);
            }
            this.bX.add(at);
            while (this.bX.size() > 3) {
                this.bX.remove(0);
            }
            q.y().A();
        }
    }
}
