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
import android.support.v4.view.MotionEventCompat;
import android.util.Log;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.location.c;
import com.baidu.location.e;
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
import protobuf.Im;
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
    private static final int f129byte = 24;
    static final int c = 12;

    /* renamed from: case  reason: not valid java name */
    static final int f130case = 42;

    /* renamed from: do  reason: not valid java name */
    static final int f131do = 28;
    static final int e = 65;

    /* renamed from: else  reason: not valid java name */
    static final int f132else = 2000;

    /* renamed from: for  reason: not valid java name */
    static final int f133for = 22;
    static final int g = 15;
    static final int i = 55;

    /* renamed from: int  reason: not valid java name */
    static final int f134int = 31;
    static final int l = 11;

    /* renamed from: long  reason: not valid java name */
    static final int f135long = 13;
    static final int p = 41;
    static final int s = 23;
    static final int t = 91;
    public static final String v = "baidu_location_service";

    /* renamed from: void  reason: not valid java name */
    static final int f136void = 71;
    static final int w = 24;
    static final int x = 3000;
    static final int z = 51;
    static String aa = Environment.getExternalStorageDirectory().getPath() + "/baidu/tempdata";
    private static String a = aa + "/glb.dat";
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
    private e.c f137char = null;
    private e.c ac = null;

    /* renamed from: try  reason: not valid java name */
    private c.a f141try = null;
    private c.a aj = null;
    private c.a u = null;
    private Location f = null;
    private String h = null;

    /* renamed from: new  reason: not valid java name */
    private String f140new = null;
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
    private String f139if = "bdcltb09";
    private String A = null;
    private String aq = null;
    private boolean O = false;

    /* renamed from: goto  reason: not valid java name */
    private boolean f138goto = false;
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
        private Context f142if;

        a(Context context) {
            this.f142if = context;
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
            if (g.a(this.f142if)) {
                try {
                    HttpPost httpPost = new HttpPost(j.f197do);
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(new BasicNameValuePair("e0", str));
                    arrayList.add(new BasicNameValuePair("e1", str2));
                    httpPost.setEntity(new UrlEncodedFormEntity(arrayList, "utf-8"));
                    DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
                    defaultHttpClient.getParams().setParameter("http.connection.timeout", 12000);
                    defaultHttpClient.getParams().setParameter("http.socket.timeout", 12000);
                    j.a(f.v, "send begin ...");
                    if (defaultHttpClient.execute(httpPost).getStatusLine().getStatusCode() == f.ad) {
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
                    String a = com.baidu.location.c.a(false);
                    if (f.this.as != null) {
                        a = a + f.this.as.m35byte();
                    }
                    str3 = a != null ? Jni.m2if(a) : null;
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
                f.this.m143byte();
            }
        }
    }

    /* loaded from: classes.dex */
    public class c {

        /* renamed from: for  reason: not valid java name */
        public static final String f143for = "com.baidu.locTest.LocationServer";

        /* renamed from: case  reason: not valid java name */
        private a f145case;
        private PendingIntent d;

        /* renamed from: goto  reason: not valid java name */
        private Context f149goto;

        /* renamed from: try  reason: not valid java name */
        private AlarmManager f154try;

        /* renamed from: void  reason: not valid java name */
        private long f155void;

        /* renamed from: new  reason: not valid java name */
        private final long f153new = 86100000;

        /* renamed from: char  reason: not valid java name */
        private final int f146char = f.ad;
        private long[] a = new long[20];

        /* renamed from: int  reason: not valid java name */
        private int f151int = 0;
        private c.a b = null;

        /* renamed from: long  reason: not valid java name */
        private String f152long = null;

        /* renamed from: byte  reason: not valid java name */
        private int f144byte = 1;

        /* renamed from: do  reason: not valid java name */
        private boolean f147do = false;

        /* renamed from: if  reason: not valid java name */
        private boolean f150if = false;

        /* renamed from: else  reason: not valid java name */
        private boolean f148else = false;
        private String c = null;

        /* loaded from: classes.dex */
        public class a extends BroadcastReceiver {
            public a() {
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                String action = intent.getAction();
                if (action.equals(c.f143for)) {
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
            this.f154try = null;
            this.f145case = null;
            this.d = null;
            this.f149goto = null;
            this.f155void = 0L;
            this.f149goto = context;
            this.f155void = System.currentTimeMillis();
            this.f154try = (AlarmManager) context.getSystemService("alarm");
            this.f145case = new a();
            context.registerReceiver(this.f145case, new IntentFilter(f143for));
            this.d = PendingIntent.getBroadcast(context, 0, new Intent(f143for), 134217728);
            this.f154try.setRepeating(2, j.z, j.z, this.d);
            f.this.registerReceiver(this.f145case, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        }

        public void a() {
            m190if();
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
                randomAccessFile.seek((readInt * f.ad) + 4);
                randomAccessFile.writeLong(System.currentTimeMillis());
                randomAccessFile.writeInt(this.f144byte);
                randomAccessFile.writeInt(0);
                randomAccessFile.writeInt(this.f151int);
                randomAccessFile.writeInt(this.b.f106do);
                randomAccessFile.writeInt(this.b.f108if);
                randomAccessFile.writeInt(this.b.f107for);
                randomAccessFile.writeInt(this.b.f111try);
                byte[] bArr = new byte[160];
                for (int i = 0; i < this.f151int; i++) {
                    bArr[(i * 8) + 7] = (byte) this.a[i];
                    bArr[(i * 8) + 6] = (byte) (this.a[i] >> 8);
                    bArr[(i * 8) + 5] = (byte) (this.a[i] >> 16);
                    bArr[(i * 8) + 4] = (byte) (this.a[i] >> 24);
                    bArr[(i * 8) + 3] = (byte) (this.a[i] >> 32);
                    bArr[(i * 8) + 2] = (byte) (this.a[i] >> 40);
                    bArr[(i * 8) + 1] = (byte) (this.a[i] >> 48);
                    bArr[(i * 8) + 0] = (byte) (this.a[i] >> 56);
                }
                if (this.f151int > 0) {
                    randomAccessFile.write(bArr, 0, this.f151int * 8);
                }
                randomAccessFile.writeInt(this.f151int);
                randomAccessFile.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        /* renamed from: byte  reason: not valid java name */
        public void m186byte() {
            if (this.f147do) {
                this.f144byte = 1;
                long j = j.B * 1000 * 60;
                j.z = j;
                j.q = j >> 2;
                Calendar calendar = Calendar.getInstance();
                int i = calendar.get(5);
                int i2 = calendar.get(1);
                String str = (i2 > f.f132else ? i2 - 2000 : 0) + "," + (calendar.get(2) + 1) + "," + i + "," + calendar.get(11) + "," + calendar.get(12) + "," + j.B;
                if (this.f150if) {
                    this.f152long = "&tr=" + j.f + "," + str;
                } else {
                    this.f152long += "|T" + str;
                }
                j.a(f.v, "trace begin:" + this.f152long);
                try {
                    RandomAccessFile randomAccessFile = new RandomAccessFile(f.k, "rw");
                    randomAccessFile.seek(12L);
                    randomAccessFile.writeLong(System.currentTimeMillis());
                    randomAccessFile.writeInt(this.f144byte);
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
        public void m187case() {
            int i;
            f.m161goto();
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
                if (this.f147do && this.f150if) {
                    j.a(f.v, "trace new info:" + readInt + ":" + readInt2 + ":" + readInt3);
                    int i2 = (readInt2 + 1) % f.ad;
                    randomAccessFile.seek(4L);
                    randomAccessFile.writeInt(i2);
                    readInt++;
                    if (readInt >= f.ad) {
                        readInt = 199;
                    }
                    if (i2 == readInt3 && readInt > 0) {
                        readInt3 = (readInt3 + 1) % f.ad;
                        randomAccessFile.writeInt(readInt3);
                    }
                    j.a(f.v, "trace new info:" + readInt + ":" + readInt2 + ":" + readInt3);
                    i = (i2 * f.ar) + 24;
                } else {
                    i = (readInt2 * f.ar) + 24;
                }
                randomAccessFile.seek(i + 4);
                byte[] bytes = this.f152long.getBytes();
                for (int i3 = 0; i3 < bytes.length; i3++) {
                    bytes[i3] = (byte) (bytes[i3] ^ 90);
                }
                randomAccessFile.write(bytes, 0, bytes.length);
                randomAccessFile.writeInt(bytes.length);
                randomAccessFile.seek(i);
                randomAccessFile.writeInt(bytes.length);
                if (this.f147do && this.f150if) {
                    randomAccessFile.seek(0L);
                    randomAccessFile.writeInt(readInt);
                }
                randomAccessFile.close();
            } catch (Exception e) {
            }
        }

        /* renamed from: do  reason: not valid java name */
        public void m188do() {
            e.c m124byte;
            int i;
            int i2 = 0;
            try {
                j.a(f.v, "regular expire...");
                m192new();
                if (this.f148else) {
                    this.f148else = false;
                    return;
                }
                m186byte();
                this.f151int = 0;
                this.b = null;
                if (f.this.E != null) {
                    f.this.E.m130new();
                }
                if (f.this.E != null && (m124byte = f.this.E.m124byte()) != null && m124byte.f126do != null) {
                    int size = m124byte.f126do.size();
                    if (size > 20) {
                        size = 20;
                    }
                    int i3 = 0;
                    while (i3 < size) {
                        try {
                            i = i2 + 1;
                            try {
                                this.a[i2] = Long.parseLong(((ScanResult) m124byte.f126do.get(i3)).BSSID.replace(":", ""), 16);
                            } catch (Exception e) {
                            }
                        } catch (Exception e2) {
                            i = i2;
                        }
                        i3++;
                        i2 = i;
                    }
                    this.f151int = i2;
                }
                if (f.this.r != null) {
                    this.b = f.this.r.a();
                }
                if (this.b != null) {
                    m189for();
                }
            } catch (Exception e3) {
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:83:0x0360  */
        /* renamed from: for  reason: not valid java name */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void m189for() {
            String str;
            boolean z;
            String str2;
            String m126char;
            m190if();
            j.a(f.v, "trace1:" + this.f152long);
            try {
                str = f.this.m185char() ? "y2" : "y1";
            } catch (Exception e) {
                str = "y";
            }
            if (this.f147do) {
                z = false;
            } else {
                try {
                    RandomAccessFile randomAccessFile = new RandomAccessFile(f.j, "rw");
                    if (randomAccessFile.length() < 1) {
                        randomAccessFile.close();
                        return;
                    }
                    int readInt = randomAccessFile.readInt();
                    for (int i = 0; i < readInt; i++) {
                        randomAccessFile.seek((i * f.ad) + 4);
                        randomAccessFile.readLong();
                        int readInt2 = randomAccessFile.readInt();
                        int readInt3 = randomAccessFile.readInt();
                        int readInt4 = randomAccessFile.readInt();
                        byte[] bArr = new byte[f.ad];
                        randomAccessFile.read(bArr, 0, (readInt4 * 8) + 16);
                        int i2 = (bArr[3] & 255) | ((bArr[2] << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK) | ((bArr[1] << 16) & 16711680) | ((bArr[0] << 24) & (-16777216));
                        int i3 = (bArr[7] & 255) | ((bArr[6] << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK) | ((bArr[5] << 16) & 16711680) | ((bArr[4] << 24) & (-16777216));
                        int i4 = (bArr[11] & 255) | ((bArr[10] << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK) | ((bArr[9] << 16) & 16711680) | ((bArr[8] << 24) & (-16777216));
                        int i5 = (bArr[15] & 255) | ((bArr[14] << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK) | ((bArr[13] << 16) & 16711680) | ((bArr[12] << 24) & (-16777216));
                        if (this.b.f106do == i2 && this.b.f108if == i3 && this.b.f107for == i4 && this.b.f111try == i5) {
                            long[] jArr = new long[readInt4];
                            for (int i6 = 0; i6 < readInt4; i6++) {
                                jArr[i6] = ((bArr[(i6 * 8) + 16] & 255) << 56) | ((bArr[((i6 * 8) + 16) + 1] & 255) << 48) | ((bArr[((i6 * 8) + 16) + 2] & 255) << 40) | ((bArr[((i6 * 8) + 16) + 3] & 255) << 32) | ((bArr[((i6 * 8) + 16) + 4] & 255) << 24) | ((bArr[((i6 * 8) + 16) + 5] & 255) << 16) | ((bArr[((i6 * 8) + 16) + 6] & 255) << 8) | (bArr[(i6 * 8) + 16 + 7] & 255);
                            }
                            int i7 = 0;
                            int i8 = 0;
                            while (i8 < this.f151int) {
                                int i9 = i7;
                                for (int i10 = 0; i10 < readInt4; i10++) {
                                    if (this.a[i8] == jArr[i10]) {
                                        i9++;
                                    }
                                }
                                i8++;
                                i7 = i9;
                            }
                            if (i7 > 5 || i7 * 8 > this.f151int + readInt4 || ((readInt4 == 0 && this.f151int == 0) || ((readInt4 == 1 && this.f151int == 1 && this.a[0] == jArr[0]) || (readInt4 > 1 && this.f151int > 1 && this.a[0] == jArr[0] && this.a[1] == jArr[1])))) {
                                z = true;
                                randomAccessFile.seek((i * f.ad) + 16);
                                randomAccessFile.writeInt(readInt3 + 1);
                                if (this.f152long != null) {
                                    this.f152long += "|" + readInt2 + str;
                                    if (this.c != null) {
                                        this.f152long += this.c;
                                    }
                                }
                                j.a(f.v, "daily info:is same");
                            }
                        }
                    }
                    z = false;
                } catch (Exception e2) {
                    return;
                }
            }
            if (!z) {
                String str3 = (this.b.f106do == 460 ? "|x," : "|x460,") + this.b.f108if + "," + this.b.f107for + "," + this.b.f111try;
                long j = 0;
                if (f.this.E != null && (m126char = f.this.E.m126char()) != null) {
                    try {
                        j = Long.parseLong(m126char, 16);
                    } catch (Exception e3) {
                    }
                }
                if (this.f151int == 1) {
                    str3 = str3 + "w" + Long.toHexString(this.a[0]) + "k";
                    if (this.a[0] == j) {
                        str2 = str3 + "k";
                        this.f152long += str2 + str;
                        if (this.c != null) {
                            this.f152long += this.c;
                        }
                        a();
                    }
                    str2 = str3;
                    this.f152long += str2 + str;
                    if (this.c != null) {
                    }
                    a();
                } else {
                    if (this.f151int > 1) {
                        String str4 = str3 + "w" + Long.toHexString(this.a[0]);
                        if (this.a[0] == j) {
                            str4 = str4 + "k";
                            j = 0;
                        }
                        str2 = j > 0 ? str4 + "," + Long.toHexString(j) + "k" : str4 + "," + Long.toHexString(this.a[1]);
                        this.f152long += str2 + str;
                        if (this.c != null) {
                        }
                        a();
                    }
                    str2 = str3;
                    this.f152long += str2 + str;
                    if (this.c != null) {
                    }
                    a();
                }
            }
            j.a(f.v, "trace2:" + this.f152long);
            m187case();
            this.f152long = null;
        }

        /* renamed from: if  reason: not valid java name */
        public void m190if() {
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
        public void m191int() {
        }

        /* renamed from: new  reason: not valid java name */
        public void m192new() {
            this.f147do = false;
            this.f150if = false;
            m190if();
            f.m161goto();
            try {
                RandomAccessFile randomAccessFile = new RandomAccessFile(f.k, "rw");
                randomAccessFile.seek(0L);
                int readInt = randomAccessFile.readInt();
                int readInt2 = randomAccessFile.readInt();
                randomAccessFile.readInt();
                long readLong = randomAccessFile.readLong();
                int readInt3 = randomAccessFile.readInt();
                if (readInt < 0) {
                    this.f147do = true;
                    this.f150if = true;
                    randomAccessFile.close();
                    return;
                }
                randomAccessFile.seek((readInt2 * f.ar) + 24);
                int readInt4 = randomAccessFile.readInt();
                if (readInt4 > 680) {
                    this.f147do = true;
                    this.f150if = true;
                    randomAccessFile.close();
                    return;
                }
                byte[] bArr = new byte[f.ar];
                randomAccessFile.read(bArr, 0, readInt4);
                if (readInt4 != randomAccessFile.readInt()) {
                    j.a(f.v, "trace true check fail");
                    this.f147do = true;
                    this.f150if = true;
                    randomAccessFile.close();
                    return;
                }
                for (int i = 0; i < bArr.length; i++) {
                    bArr[i] = (byte) (bArr[i] ^ 90);
                }
                this.f152long = new String(bArr, 0, readInt4);
                if (!this.f152long.contains("&tr=")) {
                    this.f147do = true;
                    this.f150if = true;
                    randomAccessFile.close();
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                long j = currentTimeMillis - readLong;
                if (j > (j.z * 3) - j.q) {
                    this.f147do = true;
                } else if (j > (j.z * 2) - j.q) {
                    this.f152long += "|" + readInt3;
                    this.f144byte = readInt3 + 2;
                } else if (j <= j.z - j.q) {
                    this.f148else = true;
                    randomAccessFile.close();
                    return;
                } else {
                    this.f144byte = readInt3 + 1;
                }
                randomAccessFile.seek(12L);
                randomAccessFile.writeLong(currentTimeMillis);
                randomAccessFile.writeInt(this.f144byte);
                randomAccessFile.close();
                RandomAccessFile randomAccessFile2 = new RandomAccessFile(f.j, "rw");
                randomAccessFile2.seek(0L);
                if (randomAccessFile2.readInt() != 0) {
                    randomAccessFile2.close();
                    return;
                }
                this.f147do = true;
                randomAccessFile2.close();
                j.a(f.v, "Day file number 0");
            } catch (Exception e) {
                e.printStackTrace();
                j.a(f.v, "exception!!!");
                this.f147do = true;
                this.f150if = true;
            }
        }

        /* renamed from: try  reason: not valid java name */
        public void m193try() {
            this.f149goto.unregisterReceiver(this.f145case);
            this.f154try.cancel(this.d);
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
                        f.this.m151do(message);
                        break;
                    case 12:
                        f.this.m180try(message);
                        break;
                    case 15:
                        f.this.m144byte(message);
                        break;
                    case 21:
                        f.this.a(message, 21);
                        break;
                    case 22:
                        f.this.m177new(message);
                        break;
                    case Im.GroupInfo.ISHIDEPOSITION_FIELD_NUMBER /* 24 */:
                        f.this.a(message);
                        break;
                    case 25:
                        f.this.m158for(message);
                        break;
                    case 26:
                        f.this.a(message, 26);
                        break;
                    case 28:
                        f.this.m170int(message);
                        break;
                    case 31:
                        f fVar = f.this;
                        j.a(f.v, "on new cell ...");
                        break;
                    case f.p /* 41 */:
                        f.this.m150do();
                        break;
                    case f.z /* 51 */:
                        f.this.m164if();
                        break;
                    case f.F /* 52 */:
                        f.this.m184void();
                        break;
                    case f.ap /* 53 */:
                        f.this.b();
                        break;
                    case f.C /* 57 */:
                        f.this.m165if(message);
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
                        f.m181try(f.this);
                        break;
                    case f.t /* 91 */:
                        f.this.m169int();
                        break;
                    case 101:
                        if (j.f205try && f.this.y != null) {
                            f.this.y.m188do();
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
        if ((this.f141try == null || !this.f141try.m113do()) && this.r != null) {
            this.f141try = this.r.a();
        }
        this.A = this.f141try.a();
        if (this.f141try != null) {
            j.m241if(v, this.f141try.m115if());
        } else {
            j.m241if(v, "cellInfo null...");
        }
        if ((this.B == null || !this.B.m134do()) && this.E != null) {
            this.B = this.E.m124byte();
        }
        if (this.B != null) {
            j.m241if(v, this.B.m133case());
        } else {
            j.m241if(v, "wifi list null");
        }
        if (this.Z == null || !this.Z.m79for()) {
            this.f = null;
        } else {
            this.f = this.Z.m80int();
        }
        String m35byte = this.as != null ? this.as.m35byte() : null;
        String format = 3 == g.m197do(this) ? "&cn=32" : String.format("&cn=%d", Integer.valueOf(this.r.m112new()));
        if (this.W) {
            format = format + "&rq=1";
        }
        String str2 = format + m35byte;
        if (str != null) {
            str2 = str + str2;
        }
        return j.a(this.f141try, this.B, this.f, str2, 0);
    }

    private String a(boolean z2) {
        if ((this.f141try == null || !this.f141try.m113do()) && this.r != null) {
            this.f141try = this.r.a();
        }
        m153do(this.f141try.a());
        return m163if(z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2) {
        j.a(v, "on network exception");
        j.m241if(v, "on network exception");
        this.f140new = null;
        this.f137char = null;
        if (this.as != null) {
            this.as.a(a(false), i2);
        }
        if (i2 == 21) {
            m148case();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Message message) {
        j.a(v, "manual upload ...");
        double d2 = message.getData().getDouble("x");
        double d3 = message.getData().getDouble("y");
        String string = message.getData().getString("addr");
        if (this.r != null && this.E != null && this.as != null) {
            k.a(this.r.a(), this.E.m129int(), this.as.m35byte(), d2, d3, string);
        }
        m143byte();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Message message, int i2) {
        j.a(v, "on network success");
        j.m241if(v, "on network success");
        String str = (String) message.obj;
        j.a(v, "network:" + str);
        if (this.as != null) {
            this.as.a(str, i2);
        }
        if (j.a(str)) {
            if (i2 == 21) {
                this.f140new = str;
            } else {
                this.G = str;
            }
        } else if (i2 == 21) {
            this.f140new = null;
        } else {
            this.G = null;
        }
        int m238if = j.m238if(str, "ssid\":\"", "\"");
        if (m238if == Integer.MIN_VALUE || this.f137char == null) {
            this.h = null;
        } else {
            this.h = this.f137char.m137if(m238if);
        }
        m167if(str);
        double m234do = j.m234do(str, "a\":\"", "\"");
        if (m234do != Double.MIN_VALUE) {
            k.a(m234do, j.m234do(str, "b\":\"", "\""), j.m234do(str, "c\":\"", "\""), j.m234do(str, "b\":\"", "\""));
        }
        int m238if2 = j.m238if(str, "rWifiN\":\"", "\"");
        if (m238if2 > 15) {
            j.F = m238if2;
        }
        int m238if3 = j.m238if(str, "rWifiT\":\"", "\"");
        if (m238if3 > 500) {
            j.h = m238if3;
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
            j.f204new = a4;
        }
        if (i2 == 21) {
            m148case();
        }
    }

    private boolean a(c.a aVar) {
        if (this.r == null) {
            return false;
        }
        this.f141try = this.r.a();
        if (this.f141try != aVar) {
            if (this.f141try == null || aVar == null) {
                return true;
            }
            return !aVar.a(this.f141try);
        }
        return false;
    }

    private boolean a(e.c cVar) {
        if (this.E == null) {
            return false;
        }
        this.B = this.E.m124byte();
        if (cVar != this.B) {
            if (this.B == null || cVar == null) {
                return true;
            }
            return !cVar.a(this.B);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (this.as != null) {
            this.as.m43new();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: byte  reason: not valid java name */
    public void m143byte() {
        if (this.M) {
            return;
        }
        if (System.currentTimeMillis() - this.N < 1000) {
            j.a(v, "request too frequency ...");
            if (this.f140new != null) {
                this.as.a(this.f140new);
                m148case();
                return;
            }
        }
        j.a(v, "start network locating ...");
        j.m241if(v, "start network locating ...");
        this.M = true;
        this.I = a(this.aj);
        if (!a(this.f137char) && !this.I && this.f140new != null) {
            this.as.a(this.f140new);
            m148case();
            return;
        }
        String a2 = a((String) null);
        if (a2 == null) {
            this.as.a("{\"result\":{\"time\":\"" + j.a() + "\",\"error\":\"62\"}}");
            m148case();
            return;
        }
        if (this.h != null) {
            a2 = a2 + this.h;
            this.h = null;
        }
        if (g.a(a2, this.P)) {
            this.aj = this.f141try;
            this.f137char = this.B;
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
    public void m144byte(Message message) {
        if (this.as != null && this.as.m38for(message) && this.E != null) {
            this.E.m128for();
        }
        this.f140new = null;
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
            this.R.execSQL("CREATE TABLE " + this.f139if + "(id CHAR(40) PRIMARY KEY,time DOUBLE,tag DOUBLE, type DOUBLE , ac INT);");
        } catch (Exception e3) {
        }
    }

    /* renamed from: case  reason: not valid java name */
    private void m148case() {
        this.M = false;
        m174long();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: do  reason: not valid java name */
    public void m150do() {
        j.a(v, "on new wifi ...");
        if (this.ah) {
            m143byte();
            this.ah = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: do  reason: not valid java name */
    public void m151do(Message message) {
        if (this.as != null) {
            this.as.m42int(message);
        }
        if (this.E != null) {
            this.E.m125case();
        }
    }

    /* renamed from: do  reason: not valid java name */
    private void m153do(String str) {
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
            Cursor rawQuery = this.R.rawQuery("select * from " + this.f139if + " where id = \"" + str + "\";", null);
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

    /* renamed from: else  reason: not valid java name */
    private void m155else() {
        j.a(v, "on new cell ...");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: for  reason: not valid java name */
    public void m158for(Message message) {
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
            g.m197do(this);
            if (g.m210if(a2, this.P)) {
                this.u = this.f141try;
                this.ac = this.B;
            } else {
                j.a(v, "request poi error ..");
            }
            this.d = System.currentTimeMillis();
        }
    }

    /* renamed from: goto  reason: not valid java name */
    public static void m161goto() {
        try {
            if (a == null) {
                k = null;
                return;
            }
            File file = new File(a);
            k = file;
            if (file.exists()) {
                return;
            }
            File file2 = new File(aa);
            if (!file2.exists()) {
                file2.mkdirs();
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
    private String m163if(boolean z2) {
        return this.O ? z2 ? String.format("{\"result\":{\"time\":\"" + j.a() + "\",\"error\":\"66\"},\"content\":{\"point\":{\"x\":\"%f\",\"y\":\"%f\"},\"radius\":\"%f\",\"isCellChanged\":\"%b\"}}", Double.valueOf(this.o), Double.valueOf(this.n), Double.valueOf(this.q), true) : String.format("{\"result\":{\"time\":\"" + j.a() + "\",\"error\":\"68\"},\"content\":{\"point\":{\"x\":\"%f\",\"y\":\"%f\"},\"radius\":\"%f\",\"isCellChanged\":\"%b\"}}", Double.valueOf(this.o), Double.valueOf(this.n), Double.valueOf(this.q), Boolean.valueOf(this.I)) : z2 ? "{\"result\":{\"time\":\"" + j.a() + "\",\"error\":\"67\"}}" : "{\"result\":{\"time\":\"" + j.a() + "\",\"error\":\"63\"}}";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: if  reason: not valid java name */
    public void m164if() {
        if (this.Z == null) {
            return;
        }
        j.a(v, "on new gps...");
        Location m80int = this.Z.m80int();
        if (this.Z.m79for() && k.a(m80int, true) && this.r != null && this.E != null && this.as != null) {
            if (this.E != null) {
                this.E.a();
            }
            k.a(this.r.a(), this.E.m129int(), m80int, this.as.m35byte());
        }
        if (this.as == null || !this.Z.m79for()) {
            return;
        }
        this.as.m41if(this.Z.m78do());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: if  reason: not valid java name */
    public void m165if(Message message) {
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
            k.a(this.r.a(), this.E.m129int(), location, this.as.m35byte());
        }
    }

    /* renamed from: if  reason: not valid java name */
    private void m167if(String str) {
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
                JSONObject jSONObject2 = jSONObject.getJSONObject(PushConstants.EXTRA_CONTENT);
                if (jSONObject2.has("clf")) {
                    String string = jSONObject2.getString("clf");
                    if (string.equals(SocialConstants.FALSE)) {
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
                } else {
                    z2 = true;
                    f = 0.0f;
                    d2 = 0.0d;
                    d3 = 0.0d;
                }
            } else if (parseInt == 167) {
                this.R.delete(this.f139if, "id = \"" + this.A + "\"", null);
                return;
            } else {
                z2 = true;
                f = 0.0f;
                d2 = 0.0d;
                d3 = 0.0d;
            }
            if (z2) {
                return;
            }
            float f2 = 4326.0f + f;
            ContentValues contentValues = new ContentValues();
            contentValues.put("time", Double.valueOf(d2 + 1235.4323d));
            contentValues.put("tag", Float.valueOf(f2));
            contentValues.put("type", Double.valueOf(d3 + 2367.3217d));
            try {
                if (this.R.update(this.f139if, contentValues, "id = \"" + this.A + "\"", null) <= 0) {
                    contentValues.put("id", this.A);
                    this.R.insert(this.f139if, null, contentValues);
                    j.a(v, "insert DB success!");
                }
            } catch (Exception e2) {
            }
        } catch (Exception e3) {
            j.a(v, "DB PARSE:exp!");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: int  reason: not valid java name */
    public void m169int() {
        if (g.a(this)) {
            g.f();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: int  reason: not valid java name */
    public void m170int(Message message) {
        if (this.as == null) {
            return;
        }
        this.as.a(a(true), message);
    }

    /* renamed from: long  reason: not valid java name */
    private void m174long() {
        if (this.f140new == null || !g.a(this)) {
            return;
        }
        g.f();
    }

    /* renamed from: new  reason: not valid java name */
    public static String m176new() {
        j.a(v, "read trace log1..");
        m161goto();
        try {
            if (k != null) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(k, "rw");
                int readInt = randomAccessFile.readInt();
                randomAccessFile.readInt();
                int readInt2 = randomAccessFile.readInt();
                j.a(v, "read trace log.." + readInt2);
                if (readInt > 0) {
                    randomAccessFile.seek((readInt2 * ar) + 24);
                    int readInt3 = randomAccessFile.readInt();
                    byte[] bArr = new byte[ar];
                    randomAccessFile.read(bArr, 0, readInt3);
                    int readInt4 = randomAccessFile.readInt();
                    int i2 = (readInt2 + 1) % ad;
                    randomAccessFile.seek(0L);
                    randomAccessFile.writeInt(readInt - 1);
                    randomAccessFile.seek(8L);
                    randomAccessFile.writeInt(i2);
                    if (readInt4 != readInt3) {
                        randomAccessFile.close();
                        return null;
                    }
                    for (int i3 = 0; i3 < bArr.length; i3++) {
                        bArr[i3] = (byte) (bArr[i3] ^ 90);
                    }
                    String m2if = Jni.m2if(new String(bArr, 0, readInt3));
                    randomAccessFile.close();
                    return m2if;
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
    public void m177new(Message message) {
        j.a(v, "on request location ...");
        j.m241if(v, "on request location ...");
        if (this.as == null) {
            return;
        }
        if (this.as.m36do(message) == 1 && this.Z != null && this.Z.m79for()) {
            j.a(v, "send gps location to client ...");
            this.as.a(this.Z.m78do(), message);
            return;
        }
        if (!this.W) {
            if (this.M) {
                return;
            }
            if (this.E != null && this.E.m130new()) {
                this.ah = true;
                this.P.postDelayed(new b(), 2000L);
                return;
            }
        }
        m143byte();
    }

    /* renamed from: try  reason: not valid java name */
    private void m179try() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: try  reason: not valid java name */
    public void m180try(Message message) {
        if (this.as != null) {
            this.as.m40if(message);
        }
    }

    /* renamed from: try  reason: not valid java name */
    static /* synthetic */ void m181try(f fVar) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: void  reason: not valid java name */
    public void m184void() {
        j.a(v, "on switch gps ...");
        if (this.as == null) {
            return;
        }
        if (this.as.m37for()) {
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
    public final boolean m185char() {
        return ((KeyguardManager) getSystemService("keyguard")).inKeyguardRestrictedInputMode();
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        return this.al.getBinder();
    }

    @Override // android.app.Service
    public final void onCreate() {
        Thread.setDefaultUncaughtExceptionHandler(new a(this));
        this.r = new com.baidu.location.c(this, this.P);
        this.E = new e(this, this.P);
        this.as = new com.baidu.location.a(this.P);
        this.r.m109do();
        this.E.m131try();
        this.ab = true;
        this.M = false;
        this.ah = false;
        g.m194byte();
        try {
            c();
        } catch (Exception e2) {
        }
        try {
            if (j.f205try && j.M) {
                this.y = new c(this);
            }
        } catch (Exception e3) {
        }
        j.a(v, "OnCreate");
        Log.d(v, "baidu location service start1 ..." + Process.myPid());
    }

    @Override // android.app.Service
    public final void onDestroy() {
        if (this.r != null) {
            this.r.m108byte();
        }
        if (this.E != null) {
            this.E.m127else();
        }
        if (this.Z != null) {
            this.Z.j();
        }
        k.m248if();
        this.M = false;
        this.ah = false;
        this.ab = false;
        if (this.y != null) {
            this.y.m193try();
        }
        if (this.R != null) {
            this.R.close();
        }
        j.a(v, "onDestroy");
        Log.d(v, "baidu location service stop ...");
        if (j.f205try) {
            Process.killProcess(Process.myPid());
        }
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i2, int i3) {
        j.a(v, "onStratCommandNotSticky");
        return 2;
    }
}
