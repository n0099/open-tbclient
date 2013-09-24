package com.baidu.location;

import android.app.AlarmManager;
import android.app.KeyguardManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.location.Location;
import android.net.wifi.ScanResult;
import android.os.Environment;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Process;
import android.util.Log;
import com.baidu.browser.core.util.BdUtil;
import com.baidu.location.c;
import com.baidu.location.e;
import com.baidu.zeus.bouncycastle.DERTags;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import java.io.File;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.io.StringWriter;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.Calendar;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class f extends Service {
    static final int C = 57;
    static final int F = 52;
    static final int H = 26;
    static final int J = 64;
    static final int K = 27;
    static final int L = 62;
    static final int Q = 1000;
    static final int S = 54;
    static final int T = 81;
    static final int U = 25;
    static final int Y = 21;
    private static final int ad = 200;
    static final int ae = 43;
    static final int af = 14;
    static final int ag = 3000;
    static final int ai = 56;
    static final int am = 101;
    static final float an = 3.1f;
    static final int ao = 61;
    static final int ap = 53;
    private static final int ar = 800;
    static final int b = 63;

    /* renamed from: byte  reason: not valid java name */
    private static final int f165byte = 24;
    static final int c = 12;

    /* renamed from: case  reason: not valid java name */
    static final int f166case = 42;

    /* renamed from: do  reason: not valid java name */
    static final int f167do = 28;
    static final int e = 65;

    /* renamed from: else  reason: not valid java name */
    static final int f168else = 2000;

    /* renamed from: for  reason: not valid java name */
    static final int f169for = 22;
    static final int g = 15;
    static final int i = 55;

    /* renamed from: int  reason: not valid java name */
    static final int f170int = 31;
    static final int l = 11;

    /* renamed from: long  reason: not valid java name */
    static final int f171long = 13;
    static final int p = 41;
    static final int s = 23;
    static final int t = 91;
    public static final String v = "baidu_location_service";

    /* renamed from: void  reason: not valid java name */
    static final int f172void = 71;
    static final int w = 24;
    static final int x = 3000;
    static final int z = 51;
    static String aa = Environment.getExternalStorageDirectory().getPath() + "/baidu/tempdata";

    /* renamed from: a  reason: collision with root package name */
    private static String f780a = aa + "/glb.dat";
    private static File j = null;
    private static File k = null;
    private String m = aa + "/vm.dat";
    final Handler P = new d();
    final Messenger al = new Messenger(this.P);
    private com.baidu.location.c r = null;
    private com.baidu.location.b Z = null;
    private e E = null;
    private com.baidu.location.a as = null;
    private e.c B = null;

    /* renamed from: char  reason: not valid java name */
    private e.c f173char = null;
    private e.c ac = null;

    /* renamed from: try  reason: not valid java name */
    private c.a f177try = null;
    private c.a aj = null;
    private c.a u = null;
    private Location f = null;
    private String h = null;

    /* renamed from: new  reason: not valid java name */
    private String f176new = null;
    private String G = null;
    private boolean ab = false;
    private boolean W = true;
    private boolean M = false;
    private boolean ah = false;
    private long N = 0;
    private long d = 0;
    private c y = null;
    private SQLiteDatabase R = null;

    /* renamed from: if  reason: not valid java name */
    private String f175if = "bdcltb09";
    private String A = null;
    private String aq = null;
    private boolean O = false;

    /* renamed from: goto  reason: not valid java name */
    private boolean f174goto = false;
    private String V = null;
    private int X = 0;
    private boolean I = true;
    private double o = 0.0d;
    private double n = 0.0d;
    private double q = 0.0d;
    private long D = 0;
    private boolean ak = false;

    /* loaded from: classes.dex */
    public class a implements Thread.UncaughtExceptionHandler {

        /* renamed from: if  reason: not valid java name */
        private Context f178if;

        a(Context context) {
            this.f178if = context;
            a();
        }

        private String a(Throwable th) {
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            th.printStackTrace(printWriter);
            printWriter.close();
            return stringWriter.toString();
        }

        public void a() {
            String str;
            String str2 = null;
            try {
                File file = new File((Environment.getExternalStorageDirectory().getPath() + "/traces") + "/error_fs.dat");
                if (file.exists()) {
                    RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                    randomAccessFile.seek(280L);
                    if (1326 == randomAccessFile.readInt()) {
                        randomAccessFile.seek(308L);
                        int readInt = randomAccessFile.readInt();
                        if (readInt <= 0 || readInt >= 2048) {
                            str = null;
                        } else {
                            j.a(f.v, "A" + readInt);
                            byte[] bArr = new byte[readInt];
                            randomAccessFile.read(bArr, 0, readInt);
                            str = new String(bArr, 0, readInt);
                        }
                        randomAccessFile.seek(600L);
                        int readInt2 = randomAccessFile.readInt();
                        if (readInt2 > 0 && readInt2 < 2048) {
                            j.a(f.v, "A" + readInt2);
                            byte[] bArr2 = new byte[readInt2];
                            randomAccessFile.read(bArr2, 0, readInt2);
                            str2 = new String(bArr2, 0, readInt2);
                        }
                        j.a(f.v, str + str2);
                        if (a(str, str2)) {
                            randomAccessFile.seek(280L);
                            randomAccessFile.writeInt(12346);
                        }
                    }
                    randomAccessFile.close();
                }
            } catch (Exception e) {
            }
        }

        public void a(File file, String str, String str2) {
            try {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                randomAccessFile.seek(280L);
                randomAccessFile.writeInt(12346);
                randomAccessFile.seek(300L);
                randomAccessFile.writeLong(System.currentTimeMillis());
                byte[] bytes = str.getBytes();
                randomAccessFile.writeInt(bytes.length);
                randomAccessFile.write(bytes, 0, bytes.length);
                randomAccessFile.seek(600L);
                byte[] bytes2 = str2.getBytes();
                randomAccessFile.writeInt(bytes2.length);
                randomAccessFile.write(bytes2, 0, bytes2.length);
                if (!a(str, str2)) {
                    randomAccessFile.seek(280L);
                    randomAccessFile.writeInt(1326);
                }
                randomAccessFile.close();
            } catch (Exception e) {
            }
        }

        boolean a(String str, String str2) {
            if (g.a(this.f178if)) {
                try {
                    HttpPost httpPost = new HttpPost(j.f233do);
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(new BasicNameValuePair("e0", str));
                    arrayList.add(new BasicNameValuePair("e1", str2));
                    httpPost.setEntity(new UrlEncodedFormEntity(arrayList, BdUtil.UTF8));
                    DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
                    defaultHttpClient.getParams().setParameter("http.connection.timeout", 12000);
                    defaultHttpClient.getParams().setParameter("http.socket.timeout", 12000);
                    j.a(f.v, "send begin ...");
                    if (defaultHttpClient.execute(httpPost).getStatusLine().getStatusCode() == 200) {
                        j.a(f.v, "send ok....");
                        return true;
                    }
                    return false;
                } catch (Exception e) {
                    return false;
                }
            }
            return false;
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x0077 A[Catch: Exception -> 0x00bc, TryCatch #1 {Exception -> 0x00bc, blocks: (B:10:0x003e, B:12:0x0077, B:14:0x0082, B:15:0x0085, B:17:0x008b, B:23:0x009b, B:25:0x00b8), top: B:35:0x003e }] */
        /* JADX WARN: Removed duplicated region for block: B:23:0x009b A[Catch: Exception -> 0x00bc, TRY_ENTER, TryCatch #1 {Exception -> 0x00bc, blocks: (B:10:0x003e, B:12:0x0077, B:14:0x0082, B:15:0x0085, B:17:0x008b, B:23:0x009b, B:25:0x00b8), top: B:35:0x003e }] */
        @Override // java.lang.Thread.UncaughtExceptionHandler
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void uncaughtException(Thread thread, Throwable th) {
            String str;
            String str2;
            String str3;
            File file;
            try {
                str2 = a(th);
                try {
                    j.a(f.v, str2);
                    com.baidu.location.c unused = f.this.r;
                    String a2 = com.baidu.location.c.a(false);
                    if (f.this.as != null) {
                        a2 = a2 + f.this.as.m50byte();
                    }
                    str3 = a2 != null ? Jni.m17if(a2) : null;
                } catch (Exception e) {
                    str = str2;
                    str2 = str;
                    str3 = null;
                    String str4 = Environment.getExternalStorageDirectory().getPath() + "/traces";
                    file = new File(str4 + "/error_fs.dat");
                    if (file.exists()) {
                    }
                    Process.killProcess(Process.myPid());
                }
            } catch (Exception e2) {
                str = null;
            }
            try {
                String str42 = Environment.getExternalStorageDirectory().getPath() + "/traces";
                file = new File(str42 + "/error_fs.dat");
                if (file.exists()) {
                    File file2 = new File(str42);
                    if (!file2.exists()) {
                        file2.mkdirs();
                    }
                    a(file.createNewFile() ? file : null, str3, str2);
                } else {
                    RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                    randomAccessFile.seek(300L);
                    if (System.currentTimeMillis() - randomAccessFile.readLong() > 604800000) {
                        a(file, str3, str2);
                    }
                }
            } catch (Exception e3) {
            }
            Process.killProcess(Process.myPid());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements Runnable {
        private b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (f.this.ah) {
                f.this.ah = false;
                f.this.m158byte();
            }
        }
    }

    /* loaded from: classes.dex */
    public class c {

        /* renamed from: for  reason: not valid java name */
        public static final String f179for = "com.baidu.locTest.LocationServer";

        /* renamed from: case  reason: not valid java name */
        private a f181case;
        private PendingIntent d;

        /* renamed from: goto  reason: not valid java name */
        private Context f185goto;

        /* renamed from: try  reason: not valid java name */
        private AlarmManager f190try;

        /* renamed from: void  reason: not valid java name */
        private long f191void;

        /* renamed from: new  reason: not valid java name */
        private final long f189new = 86100000;

        /* renamed from: char  reason: not valid java name */
        private final int f182char = 200;

        /* renamed from: a  reason: collision with root package name */
        private long[] f783a = new long[20];

        /* renamed from: int  reason: not valid java name */
        private int f187int = 0;
        private c.a b = null;

        /* renamed from: long  reason: not valid java name */
        private String f188long = null;

        /* renamed from: byte  reason: not valid java name */
        private int f180byte = 1;

        /* renamed from: do  reason: not valid java name */
        private boolean f183do = false;

        /* renamed from: if  reason: not valid java name */
        private boolean f186if = false;

        /* renamed from: else  reason: not valid java name */
        private boolean f184else = false;
        private String c = null;

        /* loaded from: classes.dex */
        public class a extends BroadcastReceiver {
            public a() {
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                String action = intent.getAction();
                if (action.equals(c.f179for)) {
                    f.this.P.obtainMessage(101).sendToTarget();
                    return;
                }
                try {
                    if (action.equals("android.intent.action.BATTERY_CHANGED")) {
                        int intExtra = intent.getIntExtra("status", 0);
                        int intExtra2 = intent.getIntExtra("plugged", 0);
                        switch (intExtra) {
                            case 2:
                                c.this.c = "4";
                                break;
                            case 3:
                            case 4:
                                c.this.c = "3";
                                break;
                            default:
                                c.this.c = null;
                                break;
                        }
                        switch (intExtra2) {
                            case 1:
                                c.this.c = "6";
                                return;
                            case 2:
                                c.this.c = "5";
                                return;
                            default:
                                return;
                        }
                    }
                } catch (Exception e) {
                    c.this.c = null;
                }
            }
        }

        public c(Context context) {
            this.f190try = null;
            this.f181case = null;
            this.d = null;
            this.f185goto = null;
            this.f191void = 0L;
            this.f185goto = context;
            this.f191void = System.currentTimeMillis();
            this.f190try = (AlarmManager) context.getSystemService("alarm");
            this.f181case = new a();
            context.registerReceiver(this.f181case, new IntentFilter(f179for));
            this.d = PendingIntent.getBroadcast(context, 0, new Intent(f179for), 134217728);
            this.f190try.setRepeating(2, j.z, j.z, this.d);
            f.this.registerReceiver(this.f181case, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        }

        public void a() {
            m205if();
            if (f.j == null) {
                return;
            }
            try {
                RandomAccessFile randomAccessFile = new RandomAccessFile(f.j, "rw");
                if (randomAccessFile.length() < 1) {
                    randomAccessFile.close();
                    return;
                }
                randomAccessFile.seek(0L);
                int readInt = randomAccessFile.readInt();
                randomAccessFile.seek(0L);
                randomAccessFile.writeInt(readInt + 1);
                randomAccessFile.seek((readInt * 200) + 4);
                randomAccessFile.writeLong(System.currentTimeMillis());
                randomAccessFile.writeInt(this.f180byte);
                randomAccessFile.writeInt(0);
                randomAccessFile.writeInt(this.f187int);
                randomAccessFile.writeInt(this.b.f142do);
                randomAccessFile.writeInt(this.b.f144if);
                randomAccessFile.writeInt(this.b.f143for);
                randomAccessFile.writeInt(this.b.f147try);
                byte[] bArr = new byte[160];
                for (int i = 0; i < this.f187int; i++) {
                    bArr[(i * 8) + 7] = (byte) this.f783a[i];
                    bArr[(i * 8) + 6] = (byte) (this.f783a[i] >> 8);
                    bArr[(i * 8) + 5] = (byte) (this.f783a[i] >> 16);
                    bArr[(i * 8) + 4] = (byte) (this.f783a[i] >> 24);
                    bArr[(i * 8) + 3] = (byte) (this.f783a[i] >> 32);
                    bArr[(i * 8) + 2] = (byte) (this.f783a[i] >> 40);
                    bArr[(i * 8) + 1] = (byte) (this.f783a[i] >> 48);
                    bArr[(i * 8) + 0] = (byte) (this.f783a[i] >> 56);
                }
                if (this.f187int > 0) {
                    randomAccessFile.write(bArr, 0, this.f187int * 8);
                }
                randomAccessFile.writeInt(this.f187int);
                randomAccessFile.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        /* renamed from: byte  reason: not valid java name */
        public void m201byte() {
            if (this.f183do) {
                this.f180byte = 1;
                j.z = j.B * 1000 * 60;
                j.q = j.z >> 2;
                Calendar calendar = Calendar.getInstance();
                int i = calendar.get(5);
                int i2 = calendar.get(1);
                String str = (i2 > f.f168else ? i2 - 2000 : 0) + "," + (calendar.get(2) + 1) + "," + i + "," + calendar.get(11) + "," + calendar.get(12) + "," + j.B;
                if (this.f186if) {
                    this.f188long = "&tr=" + j.f + "," + str;
                } else {
                    this.f188long += "|T" + str;
                }
                j.a(f.v, "trace begin:" + this.f188long);
                try {
                    RandomAccessFile randomAccessFile = new RandomAccessFile(f.k, "rw");
                    randomAccessFile.seek(12L);
                    randomAccessFile.writeLong(System.currentTimeMillis());
                    randomAccessFile.writeInt(this.f180byte);
                    randomAccessFile.close();
                    RandomAccessFile randomAccessFile2 = new RandomAccessFile(f.j, "rw");
                    randomAccessFile2.seek(0L);
                    randomAccessFile2.writeInt(0);
                    randomAccessFile2.close();
                } catch (Exception e) {
                }
            }
        }

        /* renamed from: case  reason: not valid java name */
        public void m202case() {
            int i;
            f.m176goto();
            if (f.k == null) {
                return;
            }
            try {
                RandomAccessFile randomAccessFile = new RandomAccessFile(f.k, "rw");
                if (randomAccessFile.length() < 1) {
                    randomAccessFile.close();
                    return;
                }
                randomAccessFile.seek(0L);
                int readInt = randomAccessFile.readInt();
                int readInt2 = randomAccessFile.readInt();
                int readInt3 = randomAccessFile.readInt();
                if (this.f183do && this.f186if) {
                    j.a(f.v, "trace new info:" + readInt + ":" + readInt2 + ":" + readInt3);
                    int i2 = (readInt2 + 1) % 200;
                    randomAccessFile.seek(4L);
                    randomAccessFile.writeInt(i2);
                    readInt++;
                    if (readInt >= 200) {
                        readInt = 199;
                    }
                    if (i2 == readInt3 && readInt > 0) {
                        readInt3 = (readInt3 + 1) % 200;
                        randomAccessFile.writeInt(readInt3);
                    }
                    j.a(f.v, "trace new info:" + readInt + ":" + readInt2 + ":" + readInt3);
                    i = (i2 * 800) + 24;
                } else {
                    i = (readInt2 * 800) + 24;
                }
                randomAccessFile.seek(i + 4);
                byte[] bytes = this.f188long.getBytes();
                for (int i3 = 0; i3 < bytes.length; i3++) {
                    bytes[i3] = (byte) (bytes[i3] ^ 90);
                }
                randomAccessFile.write(bytes, 0, bytes.length);
                randomAccessFile.writeInt(bytes.length);
                randomAccessFile.seek(i);
                randomAccessFile.writeInt(bytes.length);
                if (this.f183do && this.f186if) {
                    randomAccessFile.seek(0L);
                    randomAccessFile.writeInt(readInt);
                }
                randomAccessFile.close();
            } catch (Exception e) {
            }
        }

        /* renamed from: do  reason: not valid java name */
        public void m203do() {
            e.c m139byte;
            int i;
            int i2 = 0;
            try {
                j.a(f.v, "regular expire...");
                m207new();
                if (this.f184else) {
                    this.f184else = false;
                    return;
                }
                m201byte();
                this.f187int = 0;
                this.b = null;
                if (f.this.E != null) {
                    f.this.E.m145new();
                }
                if (f.this.E != null && (m139byte = f.this.E.m139byte()) != null && m139byte.f162do != null) {
                    int size = m139byte.f162do.size();
                    if (size > 20) {
                        size = 20;
                    }
                    int i3 = 0;
                    while (i3 < size) {
                        try {
                            i = i2 + 1;
                            try {
                                this.f783a[i2] = Long.parseLong(((ScanResult) m139byte.f162do.get(i3)).BSSID.replace(":", ""), 16);
                            } catch (Exception e) {
                            }
                        } catch (Exception e2) {
                            i = i2;
                        }
                        i3++;
                        i2 = i;
                    }
                    this.f187int = i2;
                }
                if (f.this.r != null) {
                    this.b = f.this.r.a();
                }
                if (this.b != null) {
                    m204for();
                }
            } catch (Exception e3) {
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:67:0x0291  */
        /* JADX WARN: Removed duplicated region for block: B:83:0x0364  */
        /* renamed from: for  reason: not valid java name */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void m204for() {
            String str;
            boolean z;
            String str2;
            String m141char;
            m205if();
            j.a(f.v, "trace1:" + this.f188long);
            try {
                str = f.this.m200char() ? "y2" : "y1";
            } catch (Exception e) {
                str = "y";
            }
            if (!this.f183do) {
                try {
                    RandomAccessFile randomAccessFile = new RandomAccessFile(f.j, "rw");
                    if (randomAccessFile.length() < 1) {
                        randomAccessFile.close();
                        return;
                    }
                    int readInt = randomAccessFile.readInt();
                    for (int i = 0; i < readInt; i++) {
                        randomAccessFile.seek((i * 200) + 4);
                        randomAccessFile.readLong();
                        int readInt2 = randomAccessFile.readInt();
                        int readInt3 = randomAccessFile.readInt();
                        int readInt4 = randomAccessFile.readInt();
                        byte[] bArr = new byte[200];
                        randomAccessFile.read(bArr, 0, (readInt4 * 8) + 16);
                        int i2 = (bArr[3] & 255) | ((bArr[2] << 8) & 65280) | ((bArr[1] << 16) & 16711680) | ((bArr[0] << 24) & (-16777216));
                        int i3 = (bArr[7] & 255) | ((bArr[6] << 8) & 65280) | ((bArr[5] << 16) & 16711680) | ((bArr[4] << 24) & (-16777216));
                        int i4 = (bArr[11] & 255) | ((bArr[10] << 8) & 65280) | ((bArr[9] << 16) & 16711680) | ((bArr[8] << 24) & (-16777216));
                        int i5 = (bArr[15] & 255) | ((bArr[14] << 8) & 65280) | ((bArr[13] << 16) & 16711680) | ((bArr[12] << 24) & (-16777216));
                        if (this.b.f142do == i2 && this.b.f144if == i3 && this.b.f143for == i4 && this.b.f147try == i5) {
                            long[] jArr = new long[readInt4];
                            for (int i6 = 0; i6 < readInt4; i6++) {
                                jArr[i6] = ((bArr[(i6 * 8) + 16] & 255) << 56) | ((bArr[((i6 * 8) + 16) + 1] & 255) << 48) | ((bArr[((i6 * 8) + 16) + 2] & 255) << 40) | ((bArr[((i6 * 8) + 16) + 3] & 255) << 32) | ((bArr[((i6 * 8) + 16) + 4] & 255) << 24) | ((bArr[((i6 * 8) + 16) + 5] & 255) << 16) | ((bArr[((i6 * 8) + 16) + 6] & 255) << 8) | (bArr[(i6 * 8) + 16 + 7] & 255);
                            }
                            int i7 = 0;
                            int i8 = 0;
                            while (i8 < this.f187int) {
                                int i9 = i7;
                                for (int i10 = 0; i10 < readInt4; i10++) {
                                    if (this.f783a[i8] == jArr[i10]) {
                                        i9++;
                                    }
                                }
                                i8++;
                                i7 = i9;
                            }
                            if (i7 > 5 || i7 * 8 > this.f187int + readInt4 || ((readInt4 == 0 && this.f187int == 0) || ((readInt4 == 1 && this.f187int == 1 && this.f783a[0] == jArr[0]) || (readInt4 > 1 && this.f187int > 1 && this.f783a[0] == jArr[0] && this.f783a[1] == jArr[1])))) {
                                z = true;
                                randomAccessFile.seek((i * 200) + 16);
                                randomAccessFile.writeInt(readInt3 + 1);
                                if (this.f188long != null) {
                                    this.f188long += "|" + readInt2 + str;
                                    if (this.c != null) {
                                        this.f188long += this.c;
                                    }
                                }
                                j.a(f.v, "daily info:is same");
                                if (!z) {
                                    String str3 = (this.b.f142do == 460 ? "|x," : "|x460,") + this.b.f144if + "," + this.b.f143for + "," + this.b.f147try;
                                    long j = 0;
                                    if (f.this.E != null && (m141char = f.this.E.m141char()) != null) {
                                        try {
                                            j = Long.parseLong(m141char, 16);
                                        } catch (Exception e2) {
                                        }
                                    }
                                    if (this.f187int == 1) {
                                        str3 = str3 + "w" + Long.toHexString(this.f783a[0]) + "k";
                                        if (this.f783a[0] == j) {
                                            str2 = str3 + "k";
                                            this.f188long += str2 + str;
                                            if (this.c != null) {
                                                this.f188long += this.c;
                                            }
                                            a();
                                        }
                                        str2 = str3;
                                        this.f188long += str2 + str;
                                        if (this.c != null) {
                                        }
                                        a();
                                    } else {
                                        if (this.f187int > 1) {
                                            String str4 = str3 + "w" + Long.toHexString(this.f783a[0]);
                                            if (this.f783a[0] == j) {
                                                str4 = str4 + "k";
                                                j = 0;
                                            }
                                            str2 = j > 0 ? str4 + "," + Long.toHexString(j) + "k" : str4 + "," + Long.toHexString(this.f783a[1]);
                                            this.f188long += str2 + str;
                                            if (this.c != null) {
                                            }
                                            a();
                                        }
                                        str2 = str3;
                                        this.f188long += str2 + str;
                                        if (this.c != null) {
                                        }
                                        a();
                                    }
                                }
                                j.a(f.v, "trace2:" + this.f188long);
                                m202case();
                                this.f188long = null;
                            }
                        }
                    }
                } catch (Exception e3) {
                    return;
                }
            }
            z = false;
            if (!z) {
            }
            j.a(f.v, "trace2:" + this.f188long);
            m202case();
            this.f188long = null;
        }

        /* renamed from: if  reason: not valid java name */
        public void m205if() {
            try {
                if (f.this.m == null) {
                    File unused = f.j = null;
                    return;
                }
                File unused2 = f.j = new File(f.this.m);
                if (f.j.exists()) {
                    return;
                }
                File file = new File(f.aa);
                if (!file.exists()) {
                    file.mkdirs();
                }
                f.j.createNewFile();
                RandomAccessFile randomAccessFile = new RandomAccessFile(f.j, "rw");
                randomAccessFile.seek(0L);
                randomAccessFile.writeInt(0);
                randomAccessFile.close();
            } catch (Exception e) {
                e.printStackTrace();
                File unused3 = f.j = null;
            }
        }

        /* renamed from: int  reason: not valid java name */
        public void m206int() {
        }

        /* renamed from: new  reason: not valid java name */
        public void m207new() {
            this.f183do = false;
            this.f186if = false;
            m205if();
            f.m176goto();
            try {
                RandomAccessFile randomAccessFile = new RandomAccessFile(f.k, "rw");
                randomAccessFile.seek(0L);
                int readInt = randomAccessFile.readInt();
                int readInt2 = randomAccessFile.readInt();
                randomAccessFile.readInt();
                long readLong = randomAccessFile.readLong();
                int readInt3 = randomAccessFile.readInt();
                if (readInt < 0) {
                    this.f183do = true;
                    this.f186if = true;
                    randomAccessFile.close();
                    return;
                }
                randomAccessFile.seek((readInt2 * 800) + 24);
                int readInt4 = randomAccessFile.readInt();
                if (readInt4 > 680) {
                    this.f183do = true;
                    this.f186if = true;
                    randomAccessFile.close();
                    return;
                }
                byte[] bArr = new byte[800];
                randomAccessFile.read(bArr, 0, readInt4);
                if (readInt4 != randomAccessFile.readInt()) {
                    j.a(f.v, "trace true check fail");
                    this.f183do = true;
                    this.f186if = true;
                    randomAccessFile.close();
                    return;
                }
                for (int i = 0; i < bArr.length; i++) {
                    bArr[i] = (byte) (bArr[i] ^ 90);
                }
                this.f188long = new String(bArr, 0, readInt4);
                if (!this.f188long.contains("&tr=")) {
                    this.f183do = true;
                    this.f186if = true;
                    randomAccessFile.close();
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                long j = currentTimeMillis - readLong;
                if (j > (j.z * 3) - j.q) {
                    this.f183do = true;
                } else if (j > (j.z * 2) - j.q) {
                    this.f188long += "|" + readInt3;
                    this.f180byte = readInt3 + 2;
                } else if (j <= j.z - j.q) {
                    this.f184else = true;
                    randomAccessFile.close();
                    return;
                } else {
                    this.f180byte = readInt3 + 1;
                }
                randomAccessFile.seek(12L);
                randomAccessFile.writeLong(currentTimeMillis);
                randomAccessFile.writeInt(this.f180byte);
                randomAccessFile.close();
                RandomAccessFile randomAccessFile2 = new RandomAccessFile(f.j, "rw");
                randomAccessFile2.seek(0L);
                if (randomAccessFile2.readInt() != 0) {
                    randomAccessFile2.close();
                    return;
                }
                this.f183do = true;
                randomAccessFile2.close();
                j.a(f.v, "Day file number 0");
            } catch (Exception e) {
                e.printStackTrace();
                j.a(f.v, "exception!!!");
                this.f183do = true;
                this.f186if = true;
            }
        }

        /* renamed from: try  reason: not valid java name */
        public void m208try() {
            this.f185goto.unregisterReceiver(this.f181case);
            this.f190try.cancel(this.d);
            File unused = f.j = null;
        }
    }

    /* loaded from: classes.dex */
    public class d extends Handler {
        public d() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (f.this.ab) {
                switch (message.what) {
                    case 11:
                        f.this.m166do(message);
                        break;
                    case 12:
                        f.this.m195try(message);
                        break;
                    case 15:
                        f.this.m159byte(message);
                        break;
                    case 21:
                        f.this.a(message, 21);
                        break;
                    case 22:
                        f.this.m192new(message);
                        break;
                    case DERTags.GENERALIZED_TIME /* 24 */:
                        f.this.a(message);
                        break;
                    case 25:
                        f.this.m173for(message);
                        break;
                    case 26:
                        f.this.a(message, 26);
                        break;
                    case 28:
                        f.this.m185int(message);
                        break;
                    case f.f170int /* 31 */:
                        f.this.m170else();
                        break;
                    case f.p /* 41 */:
                        f.this.m165do();
                        break;
                    case f.z /* 51 */:
                        f.this.m179if();
                        break;
                    case f.F /* 52 */:
                        f.this.m199void();
                        break;
                    case f.ap /* 53 */:
                        f.this.b();
                        break;
                    case f.C /* 57 */:
                        f.this.m180if(message);
                        break;
                    case 62:
                    case 63:
                        f.this.a(21);
                        break;
                    case 64:
                    case 65:
                        f.this.a(26);
                        break;
                    case f.T /* 81 */:
                        f.this.m194try();
                        break;
                    case f.t /* 91 */:
                        f.this.m184int();
                        break;
                    case 101:
                        if (j.f241try && f.this.y != null) {
                            f.this.y.m203do();
                            break;
                        }
                        break;
                }
            }
            super.handleMessage(message);
        }
    }

    private String a(String str) {
        j.a(v, "generate locdata ...");
        if ((this.f177try == null || !this.f177try.m128do()) && this.r != null) {
            this.f177try = this.r.a();
        }
        this.A = this.f177try.a();
        if (this.f177try != null) {
            j.m256if(v, this.f177try.m130if());
        } else {
            j.m256if(v, "cellInfo null...");
        }
        if ((this.B == null || !this.B.m149do()) && this.E != null) {
            this.B = this.E.m139byte();
        }
        if (this.B != null) {
            j.m256if(v, this.B.m148case());
        } else {
            j.m256if(v, "wifi list null");
        }
        if (this.Z == null || !this.Z.m94for()) {
            this.f = null;
        } else {
            this.f = this.Z.m95int();
        }
        String m50byte = this.as != null ? this.as.m50byte() : null;
        String format = 3 == g.m212do(this) ? "&cn=32" : String.format("&cn=%d", Integer.valueOf(this.r.m127new()));
        if (this.W) {
            format = format + "&rq=1";
        }
        String str2 = format + m50byte;
        if (str != null) {
            str2 = str + str2;
        }
        return j.a(this.f177try, this.B, this.f, str2, 0);
    }

    private String a(boolean z2) {
        if ((this.f177try == null || !this.f177try.m128do()) && this.r != null) {
            this.f177try = this.r.a();
        }
        m168do(this.f177try.a());
        return m178if(z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2) {
        j.a(v, "on network exception");
        j.m256if(v, "on network exception");
        this.f176new = null;
        this.f173char = null;
        if (this.as != null) {
            this.as.a(a(false), i2);
        }
        if (i2 == 21) {
            m163case();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Message message) {
        j.a(v, "manual upload ...");
        double d2 = message.getData().getDouble("x");
        double d3 = message.getData().getDouble("y");
        String string = message.getData().getString("addr");
        if (this.r != null && this.E != null && this.as != null) {
            k.a(this.r.a(), this.E.m144int(), this.as.m50byte(), d2, d3, string);
        }
        m158byte();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Message message, int i2) {
        j.a(v, "on network success");
        j.m256if(v, "on network success");
        String str = (String) message.obj;
        j.a(v, "network:" + str);
        if (this.as != null) {
            this.as.a(str, i2);
        }
        if (j.a(str)) {
            if (i2 == 21) {
                this.f176new = str;
            } else {
                this.G = str;
            }
        } else if (i2 == 21) {
            this.f176new = null;
        } else {
            this.G = null;
        }
        int m253if = j.m253if(str, "ssid\":\"", "\"");
        if (m253if == Integer.MIN_VALUE || this.f173char == null) {
            this.h = null;
        } else {
            this.h = this.f173char.m152if(m253if);
        }
        m182if(str);
        double m249do = j.m249do(str, "a\":\"", "\"");
        if (m249do != Double.MIN_VALUE) {
            k.a(m249do, j.m249do(str, "b\":\"", "\""), j.m249do(str, "c\":\"", "\""), j.m249do(str, "b\":\"", "\""));
        }
        int m253if2 = j.m253if(str, "rWifiN\":\"", "\"");
        if (m253if2 > 15) {
            j.F = m253if2;
        }
        int m253if3 = j.m253if(str, "rWifiT\":\"", "\"");
        if (m253if3 > 500) {
            j.h = m253if3;
        }
        float a2 = j.a(str, "hSpeedDis\":\"", "\"");
        if (a2 > 5.0f) {
            j.H = a2;
        }
        float a3 = j.a(str, "mSpeedDis\":\"", "\"");
        if (a3 > 5.0f) {
            j.d = a3;
        }
        float a4 = j.a(str, "mWifiR\":\"", "\"");
        if (a4 < 1.0f && a4 > 0.2d) {
            j.f240new = a4;
        }
        if (i2 == 21) {
            m163case();
        }
    }

    private boolean a(c.a aVar) {
        if (this.r == null) {
            return false;
        }
        this.f177try = this.r.a();
        if (this.f177try != aVar) {
            if (this.f177try == null || aVar == null) {
                return true;
            }
            return aVar.a(this.f177try) ? false : true;
        }
        return false;
    }

    private boolean a(e.c cVar) {
        if (this.E == null) {
            return false;
        }
        this.B = this.E.m139byte();
        if (cVar != this.B) {
            if (this.B == null || cVar == null) {
                return true;
            }
            return cVar.a(this.B) ? false : true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (this.as != null) {
            this.as.m58new();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: byte  reason: not valid java name */
    public void m158byte() {
        if (this.M) {
            return;
        }
        if (System.currentTimeMillis() - this.N < 1000) {
            j.a(v, "request too frequency ...");
            if (this.f176new != null) {
                this.as.a(this.f176new);
                m163case();
                return;
            }
        }
        j.a(v, "start network locating ...");
        j.m256if(v, "start network locating ...");
        this.M = true;
        this.I = a(this.aj);
        if (!a(this.f173char) && !this.I && this.f176new != null) {
            this.as.a(this.f176new);
            m163case();
            return;
        }
        String a2 = a((String) null);
        if (a2 == null) {
            this.as.a("{\"result\":{\"time\":\"" + j.a() + "\",\"error\":\"62\"}}");
            m163case();
            return;
        }
        if (this.h != null) {
            a2 = a2 + this.h;
            this.h = null;
        }
        if (g.a(a2, this.P)) {
            this.aj = this.f177try;
            this.f173char = this.B;
        } else {
            j.a(v, "request error ..");
        }
        if (this.W) {
            this.W = false;
        }
        this.N = System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: byte  reason: not valid java name */
    public void m159byte(Message message) {
        if (this.as != null && this.as.m53for(message) && this.E != null) {
            this.E.m143for();
        }
        this.f176new = null;
    }

    private void c() {
        File file = new File(aa);
        File file2 = new File(aa + "/ls.db");
        if (!file.exists()) {
            file.mkdirs();
        }
        if (!file2.exists()) {
            try {
                file2.createNewFile();
            } catch (Exception e2) {
            }
        }
        try {
            this.R = SQLiteDatabase.openOrCreateDatabase(file2, (SQLiteDatabase.CursorFactory) null);
            this.R.execSQL("CREATE TABLE " + this.f175if + "(id CHAR(40) PRIMARY KEY,time DOUBLE,tag DOUBLE, type DOUBLE , ac INT);");
        } catch (Exception e3) {
        }
    }

    /* renamed from: case  reason: not valid java name */
    private void m163case() {
        this.M = false;
        m189long();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: do  reason: not valid java name */
    public void m165do() {
        j.a(v, "on new wifi ...");
        if (this.ah) {
            m158byte();
            this.ah = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: do  reason: not valid java name */
    public void m166do(Message message) {
        if (this.as != null) {
            this.as.m57int(message);
        }
        if (this.E != null) {
            this.E.m140case();
        }
    }

    /* renamed from: do  reason: not valid java name */
    private void m168do(String str) {
        if (this.R == null || str == null) {
            j.a(v, "db is null...");
            this.O = false;
            return;
        }
        j.a(v, "LOCATING...");
        if (System.currentTimeMillis() - this.D < 1500 || str.equals(this.aq)) {
            return;
        }
        this.O = false;
        try {
            Cursor rawQuery = this.R.rawQuery("select * from " + this.f175if + " where id = \"" + str + "\";", null);
            this.aq = str;
            this.D = System.currentTimeMillis();
            if (rawQuery != null) {
                if (rawQuery.moveToFirst()) {
                    j.a(v, "lookup DB success:" + this.aq);
                    this.o = rawQuery.getDouble(1) - 1235.4323d;
                    this.q = rawQuery.getDouble(2) - 4326.0d;
                    this.n = rawQuery.getDouble(3) - 2367.3217d;
                    this.O = true;
                    j.a(v, "lookup DB success:x" + this.o + "y" + this.n + "r" + this.q);
                }
                rawQuery.close();
            }
        } catch (Exception e2) {
            this.D = System.currentTimeMillis();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: else  reason: not valid java name */
    public void m170else() {
        j.a(v, "on new cell ...");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: for  reason: not valid java name */
    public void m173for(Message message) {
        if (System.currentTimeMillis() - this.d < 3000) {
            j.a(v, "request too frequency ...");
            if (this.G != null) {
                this.as.a(this.G, 26);
                return;
            }
        }
        if (this.as != null) {
            String a2 = a(this.as.a(message));
            if (this.h != null) {
                a2 = a2 + this.h;
                this.h = null;
            }
            g.m212do(this);
            if (g.m225if(a2, this.P)) {
                this.u = this.f177try;
                this.ac = this.B;
            } else {
                j.a(v, "request poi error ..");
            }
            this.d = System.currentTimeMillis();
        }
    }

    /* renamed from: goto  reason: not valid java name */
    public static void m176goto() {
        try {
            if (f780a == null) {
                k = null;
                return;
            }
            k = new File(f780a);
            if (k.exists()) {
                return;
            }
            File file = new File(aa);
            if (!file.exists()) {
                file.mkdirs();
            }
            k.createNewFile();
            RandomAccessFile randomAccessFile = new RandomAccessFile(k, "rw");
            randomAccessFile.seek(0L);
            randomAccessFile.writeInt(-1);
            randomAccessFile.writeInt(-1);
            randomAccessFile.writeInt(0);
            randomAccessFile.writeLong(0L);
            randomAccessFile.writeInt(0);
            randomAccessFile.writeInt(0);
            randomAccessFile.close();
        } catch (Exception e2) {
            e2.printStackTrace();
            k = null;
        }
    }

    /* renamed from: if  reason: not valid java name */
    private String m178if(boolean z2) {
        return this.O ? z2 ? String.format("{\"result\":{\"time\":\"" + j.a() + "\",\"error\":\"66\"},\"content\":{\"point\":{\"x\":\"%f\",\"y\":\"%f\"},\"radius\":\"%f\",\"isCellChanged\":\"%b\"}}", Double.valueOf(this.o), Double.valueOf(this.n), Double.valueOf(this.q), true) : String.format("{\"result\":{\"time\":\"" + j.a() + "\",\"error\":\"68\"},\"content\":{\"point\":{\"x\":\"%f\",\"y\":\"%f\"},\"radius\":\"%f\",\"isCellChanged\":\"%b\"}}", Double.valueOf(this.o), Double.valueOf(this.n), Double.valueOf(this.q), Boolean.valueOf(this.I)) : z2 ? "{\"result\":{\"time\":\"" + j.a() + "\",\"error\":\"67\"}}" : "{\"result\":{\"time\":\"" + j.a() + "\",\"error\":\"63\"}}";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: if  reason: not valid java name */
    public void m179if() {
        if (this.Z == null) {
            return;
        }
        j.a(v, "on new gps...");
        Location m95int = this.Z.m95int();
        if (this.Z.m94for() && k.a(m95int, true) && this.r != null && this.E != null && this.as != null) {
            if (this.E != null) {
                this.E.a();
            }
            k.a(this.r.a(), this.E.m144int(), m95int, this.as.m50byte());
        }
        if (this.as == null || !this.Z.m94for()) {
            return;
        }
        this.as.m56if(this.Z.m93do());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: if  reason: not valid java name */
    public void m180if(Message message) {
        if (message == null || message.obj == null) {
            j.a(v, "Gps updateloation is null");
            return;
        }
        Location location = (Location) message.obj;
        if (location != null) {
            j.a(v, "on update gps...");
            if (!k.a(location, true) || this.r == null || this.E == null || this.as == null || !j.v) {
                return;
            }
            k.a(this.r.a(), this.E.m144int(), location, this.as.m50byte());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    /* renamed from: if  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void m182if(String str) {
        float f;
        double d2;
        double d3;
        boolean z2 = false;
        if (this.R == null || !this.I) {
            return;
        }
        try {
            j.a(v, "DB:" + str);
            JSONObject jSONObject = new JSONObject(str);
            int parseInt = Integer.parseInt(jSONObject.getJSONObject("result").getString("error"));
            if (parseInt == 161) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("content");
                if (jSONObject2.has("clf")) {
                    String string = jSONObject2.getString("clf");
                    if (string.equals("0")) {
                        JSONObject jSONObject3 = jSONObject2.getJSONObject("point");
                        d2 = Double.parseDouble(jSONObject3.getString("x"));
                        d3 = Double.parseDouble(jSONObject3.getString("y"));
                        f = Float.parseFloat(jSONObject2.getString("radius"));
                    } else {
                        String[] split = string.split("\\|");
                        d2 = Double.parseDouble(split[0]);
                        d3 = Double.parseDouble(split[1]);
                        f = Float.parseFloat(split[2]);
                    }
                    j.a(v, "DB PARSE:x" + d2 + "y" + d3 + "R" + f);
                    if (z2) {
                        float f2 = 4326.0f + f;
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("time", Double.valueOf(d2 + 1235.4323d));
                        contentValues.put("tag", Float.valueOf(f2));
                        contentValues.put("type", Double.valueOf(d3 + 2367.3217d));
                        try {
                            if (this.R.update(this.f175if, contentValues, "id = \"" + this.A + "\"", null) <= 0) {
                                contentValues.put(LocaleUtil.INDONESIAN, this.A);
                                this.R.insert(this.f175if, null, contentValues);
                                j.a(v, "insert DB success!");
                                return;
                            }
                            return;
                        } catch (Exception e2) {
                            return;
                        }
                    }
                    return;
                }
            } else if (parseInt == 167) {
                this.R.delete(this.f175if, "id = \"" + this.A + "\"", null);
                return;
            }
            z2 = true;
            f = 0.0f;
            d2 = 0.0d;
            d3 = 0.0d;
            if (z2) {
            }
        } catch (Exception e3) {
            j.a(v, "DB PARSE:exp!");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: int  reason: not valid java name */
    public void m184int() {
        if (g.a(this)) {
            g.f();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: int  reason: not valid java name */
    public void m185int(Message message) {
        if (this.as == null) {
            return;
        }
        this.as.a(a(true), message);
    }

    /* renamed from: long  reason: not valid java name */
    private void m189long() {
        if (this.f176new == null || !g.a(this)) {
            return;
        }
        g.f();
    }

    /* renamed from: new  reason: not valid java name */
    public static String m191new() {
        j.a(v, "read trace log1..");
        m176goto();
        try {
            if (k != null) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(k, "rw");
                int readInt = randomAccessFile.readInt();
                randomAccessFile.readInt();
                int readInt2 = randomAccessFile.readInt();
                j.a(v, "read trace log.." + readInt2);
                if (readInt > 0) {
                    randomAccessFile.seek((readInt2 * 800) + 24);
                    int readInt3 = randomAccessFile.readInt();
                    byte[] bArr = new byte[800];
                    randomAccessFile.read(bArr, 0, readInt3);
                    int readInt4 = randomAccessFile.readInt();
                    randomAccessFile.seek(0L);
                    randomAccessFile.writeInt(readInt - 1);
                    randomAccessFile.seek(8L);
                    randomAccessFile.writeInt((readInt2 + 1) % 200);
                    if (readInt4 != readInt3) {
                        randomAccessFile.close();
                        return null;
                    }
                    for (int i2 = 0; i2 < bArr.length; i2++) {
                        bArr[i2] = (byte) (bArr[i2] ^ 90);
                    }
                    String m17if = Jni.m17if(new String(bArr, 0, readInt3));
                    randomAccessFile.close();
                    return m17if;
                }
                randomAccessFile.close();
            }
            return null;
        } catch (Exception e2) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: new  reason: not valid java name */
    public void m192new(Message message) {
        j.a(v, "on request location ...");
        j.m256if(v, "on request location ...");
        if (this.as == null) {
            return;
        }
        if (this.as.m51do(message) == 1 && this.Z != null && this.Z.m94for()) {
            j.a(v, "send gps location to client ...");
            this.as.a(this.Z.m93do(), message);
        } else if (this.W) {
            m158byte();
        } else if (this.M) {
        } else {
            if (this.E == null || !this.E.m145new()) {
                m158byte();
                return;
            }
            this.ah = true;
            this.P.postDelayed(new b(), 2000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: try  reason: not valid java name */
    public void m194try() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: try  reason: not valid java name */
    public void m195try(Message message) {
        if (this.as != null) {
            this.as.m55if(message);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: void  reason: not valid java name */
    public void m199void() {
        j.a(v, "on switch gps ...");
        if (this.as == null) {
            return;
        }
        if (this.as.m52for()) {
            if (this.Z == null) {
                this.Z = new com.baidu.location.b(this, this.P);
            }
            this.Z.i();
        } else if (this.Z != null) {
            this.Z.j();
            this.Z = null;
        }
    }

    /* renamed from: char  reason: not valid java name */
    public boolean m200char() {
        return ((KeyguardManager) getSystemService("keyguard")).inKeyguardRestrictedInputMode();
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.al.getBinder();
    }

    @Override // android.app.Service
    public void onCreate() {
        Thread.setDefaultUncaughtExceptionHandler(new a(this));
        this.r = new com.baidu.location.c(this, this.P);
        this.E = new e(this, this.P);
        this.as = new com.baidu.location.a(this.P);
        this.r.m124do();
        this.E.m146try();
        this.ab = true;
        this.M = false;
        this.ah = false;
        g.m209byte();
        try {
            c();
        } catch (Exception e2) {
        }
        try {
            if (j.f241try && j.M) {
                this.y = new c(this);
            }
        } catch (Exception e3) {
        }
        j.a(v, "OnCreate");
        Log.d(v, "baidu location service start1 ..." + Process.myPid());
    }

    @Override // android.app.Service
    public void onDestroy() {
        if (this.r != null) {
            this.r.m123byte();
        }
        if (this.E != null) {
            this.E.m142else();
        }
        if (this.Z != null) {
            this.Z.j();
        }
        k.m263if();
        this.M = false;
        this.ah = false;
        this.ab = false;
        if (this.y != null) {
            this.y.m208try();
        }
        if (this.R != null) {
            this.R.close();
        }
        j.a(v, "onDestroy");
        Log.d(v, "baidu location service stop ...");
        if (j.f241try) {
            Process.killProcess(Process.myPid());
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        j.a(v, "onStratCommandNotSticky");
        return 2;
    }
}
