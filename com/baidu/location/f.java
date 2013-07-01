package com.baidu.location;

import android.app.KeyguardManager;
import android.app.Service;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.location.Location;
import android.os.Environment;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Process;
import android.util.Log;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.cyberplayer.sdk.BVideoView;
import com.baidu.mapapi.MKSearch;
import com.baidu.mapapi.MapView;
import com.baidu.zeus.WebChromeClient;
import com.baidu.zeus.bouncycastle.DERTags;
import java.io.File;
import java.io.RandomAccessFile;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class f extends Service {

    /* renamed from: a */
    static String f470a = Environment.getExternalStorageDirectory().getPath() + "/baidu/tempdata";
    private static String e = f470a + "/glb.dat";
    private static File f = null;
    private static File g = null;
    private String d = f470a + "/vm.dat";
    final Handler b = new d();
    final Messenger c = new Messenger(this.b);
    private t h = null;
    private m i = null;
    private w j = null;
    private k k = null;
    private aa l = null;
    private aa m = null;
    private aa n = null;
    private u o = null;
    private u p = null;
    private u q = null;
    private Location r = null;
    private String s = null;
    private String t = null;
    private String u = null;
    private boolean v = false;
    private boolean w = true;
    private boolean x = false;
    private boolean y = false;
    private long z = 0;
    private long A = 0;
    private af B = null;
    private SQLiteDatabase C = null;
    private String D = "bdcltb09";
    private String E = null;
    private String F = null;
    private boolean G = false;
    private boolean H = false;
    private String I = null;
    private int J = 0;
    private boolean K = true;
    private double L = 0.0d;
    private double M = 0.0d;
    private double N = 0.0d;
    private long O = 0;
    private boolean P = false;

    /* loaded from: classes.dex */
    public class d extends Handler {
        public d() {
            f.this = r1;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (f.this.v) {
                switch (message.what) {
                    case 11:
                        f.this.a(message);
                        break;
                    case 12:
                        f.this.b(message);
                        break;
                    case 15:
                        f.this.c(message);
                        break;
                    case 21:
                        f.this.a(message, 21);
                        break;
                    case DERTags.IA5_STRING /* 22 */:
                        f.this.h(message);
                        break;
                    case DERTags.GENERALIZED_TIME /* 24 */:
                        f.this.e(message);
                        break;
                    case DERTags.GRAPHIC_STRING /* 25 */:
                        f.this.f(message);
                        break;
                    case DERTags.VISIBLE_STRING /* 26 */:
                        f.this.a(message, 26);
                        break;
                    case DERTags.UNIVERSAL_STRING /* 28 */:
                        f.this.g(message);
                        break;
                    case 31:
                        f.this.g();
                        break;
                    case 41:
                        f.this.h();
                        break;
                    case 51:
                        f.this.f();
                        break;
                    case MKSearch.POI_DETAIL_SEARCH /* 52 */:
                        f.this.i();
                        break;
                    case 53:
                        f.this.o();
                        break;
                    case 57:
                        f.this.d(message);
                        break;
                    case 62:
                    case 63:
                        f.this.a(21);
                        break;
                    case DERTags.APPLICATION /* 64 */:
                    case 65:
                        f.this.a(26);
                        break;
                    case MapView.LayoutParams.BOTTOM_CENTER /* 81 */:
                        f.this.j();
                        break;
                    case 91:
                        f.this.n();
                        break;
                    case WebChromeClient.STRING_DLG_TITLE_DATETIME /* 101 */:
                        if (ap.f464a && f.this.B != null) {
                            f.this.B.b();
                            break;
                        }
                        break;
                }
            }
            super.handleMessage(message);
        }
    }

    private String a(String str) {
        ap.a("baidu_location_service", "generate locdata ...");
        if ((this.o == null || !this.o.a()) && this.h != null) {
            this.o = this.h.d();
        }
        this.E = this.o.c();
        if (this.o != null) {
            ap.b("baidu_location_service", this.o.d());
        } else {
            ap.b("baidu_location_service", "cellInfo null...");
        }
        if ((this.l == null || !this.l.f()) && this.j != null) {
            this.l = this.j.h();
        }
        if (this.l != null) {
            ap.b("baidu_location_service", this.l.e());
        } else {
            ap.b("baidu_location_service", "wifi list null");
        }
        if (this.i == null || !this.i.f()) {
            this.r = null;
        } else {
            this.r = this.i.d();
        }
        String b = this.k != null ? this.k.b() : null;
        String format = 3 == ah.b(this) ? "&cn=32" : String.format("&cn=%d", Integer.valueOf(this.h.c()));
        if (this.w) {
            format = format + "&rq=1";
        }
        String str2 = format + b;
        if (str != null) {
            str2 = str + str2;
        }
        return ap.a(this.o, this.l, this.r, str2, 0);
    }

    private String a(boolean z) {
        return this.G ? z ? String.format("{\"result\":{\"time\":\"" + ap.a() + "\",\"error\":\"66\"},\"content\":{\"point\":{\"x\":\"%f\",\"y\":\"%f\"},\"radius\":\"%f\",\"isCellChanged\":\"%b\"}}", Double.valueOf(this.L), Double.valueOf(this.M), Double.valueOf(this.N), true) : String.format("{\"result\":{\"time\":\"" + ap.a() + "\",\"error\":\"68\"},\"content\":{\"point\":{\"x\":\"%f\",\"y\":\"%f\"},\"radius\":\"%f\",\"isCellChanged\":\"%b\"}}", Double.valueOf(this.L), Double.valueOf(this.M), Double.valueOf(this.N), Boolean.valueOf(this.K)) : z ? "{\"result\":{\"time\":\"" + ap.a() + "\",\"error\":\"67\"}}" : "{\"result\":{\"time\":\"" + ap.a() + "\",\"error\":\"63\"}}";
    }

    public static void a() {
        try {
            if (e == null) {
                g = null;
                return;
            }
            g = new File(e);
            if (g.exists()) {
                return;
            }
            File file = new File(f470a);
            if (!file.exists()) {
                file.mkdirs();
            }
            g.createNewFile();
            RandomAccessFile randomAccessFile = new RandomAccessFile(g, "rw");
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
            g = null;
        }
    }

    public void a(int i) {
        ap.a("baidu_location_service", "on network exception");
        ap.b("baidu_location_service", "on network exception");
        this.t = null;
        this.m = null;
        if (this.k != null) {
            this.k.a(b(false), i);
        }
        if (i == 21) {
            p();
        }
    }

    public void a(Message message) {
        if (this.k != null) {
            this.k.a(message);
        }
        if (this.j != null) {
            this.j.b();
        }
    }

    public void a(Message message, int i) {
        ap.a("baidu_location_service", "on network success");
        ap.b("baidu_location_service", "on network success");
        String str = (String) message.obj;
        ap.a("baidu_location_service", "network:" + str);
        if (this.k != null) {
            this.k.a(str, i);
        }
        if (ap.a(str)) {
            if (i == 21) {
                this.t = str;
            } else {
                this.u = str;
            }
        } else if (i == 21) {
            this.t = null;
        } else {
            this.u = null;
        }
        int a2 = ap.a(str, "ssid\":\"", "\"");
        if (a2 == Integer.MIN_VALUE || this.m == null) {
            this.s = null;
        } else {
            this.s = this.m.b(a2);
        }
        c(str);
        double c = ap.c(str, "a\":\"", "\"");
        if (c != Double.MIN_VALUE) {
            as.a(c, ap.c(str, "b\":\"", "\""), ap.c(str, "c\":\"", "\""), ap.c(str, "b\":\"", "\""));
        }
        int a3 = ap.a(str, "rWifiN\":\"", "\"");
        if (a3 > 15) {
            ap.J = a3;
        }
        int a4 = ap.a(str, "rWifiT\":\"", "\"");
        if (a4 > 500) {
            ap.L = a4;
        }
        float b = ap.b(str, "hSpeedDis\":\"", "\"");
        if (b > 5.0f) {
            ap.I = b;
        }
        float b2 = ap.b(str, "mSpeedDis\":\"", "\"");
        if (b2 > 5.0f) {
            ap.H = b2;
        }
        float b3 = ap.b(str, "mWifiR\":\"", "\"");
        if (b3 < 1.0f && b3 > 0.2d) {
            ap.K = b3;
        }
        if (i == 21) {
            p();
        }
    }

    private boolean a(aa aaVar) {
        if (this.j == null) {
            return false;
        }
        this.l = this.j.h();
        if (aaVar != this.l) {
            if (this.l == null || aaVar == null) {
                return true;
            }
            return aaVar.c(this.l) ? false : true;
        }
        return false;
    }

    private boolean a(u uVar) {
        if (this.h == null) {
            return false;
        }
        this.o = this.h.d();
        if (this.o != uVar) {
            if (this.o == null || uVar == null) {
                return true;
            }
            return uVar.a(this.o) ? false : true;
        }
        return false;
    }

    public static String b() {
        ap.a("baidu_location_service", "read trace log1..");
        a();
        try {
            if (g != null) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(g, "rw");
                int readInt = randomAccessFile.readInt();
                randomAccessFile.readInt();
                int readInt2 = randomAccessFile.readInt();
                ap.a("baidu_location_service", "read trace log.." + readInt2);
                if (readInt > 0) {
                    randomAccessFile.seek((readInt2 * BVideoView.MEDIA_INFO_BAD_INTERLEAVING) + 24);
                    int readInt3 = randomAccessFile.readInt();
                    byte[] bArr = new byte[BVideoView.MEDIA_INFO_BAD_INTERLEAVING];
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
                    for (int i = 0; i < bArr.length; i++) {
                        bArr[i] = (byte) (bArr[i] ^ 90);
                    }
                    String a2 = Jni.a(new String(bArr, 0, readInt3));
                    randomAccessFile.close();
                    return a2;
                }
                randomAccessFile.close();
            }
            return null;
        } catch (Exception e2) {
            return null;
        }
    }

    private String b(boolean z) {
        if ((this.o == null || !this.o.a()) && this.h != null) {
            this.o = this.h.d();
        }
        b(this.o.c());
        return a(z);
    }

    public void b(Message message) {
        if (this.k != null) {
            this.k.b(message);
        }
    }

    private void b(String str) {
        if (this.C == null || str == null) {
            ap.a("baidu_location_service", "db is null...");
            this.G = false;
            return;
        }
        ap.a("baidu_location_service", "LOCATING...");
        if (System.currentTimeMillis() - this.O < 1500 || str.equals(this.F)) {
            return;
        }
        this.G = false;
        try {
            Cursor rawQuery = this.C.rawQuery("select * from " + this.D + " where id = \"" + str + "\";", null);
            this.F = str;
            this.O = System.currentTimeMillis();
            if (rawQuery != null) {
                if (rawQuery.moveToFirst()) {
                    ap.a("baidu_location_service", "lookup DB success:" + this.F);
                    this.L = rawQuery.getDouble(1) - 1235.4323d;
                    this.N = rawQuery.getDouble(2) - 4326.0d;
                    this.M = rawQuery.getDouble(3) - 2367.3217d;
                    this.G = true;
                    ap.a("baidu_location_service", "lookup DB success:x" + this.L + "y" + this.M + "r" + this.N);
                }
                rawQuery.close();
            }
        } catch (Exception e2) {
            this.O = System.currentTimeMillis();
        }
    }

    public void c(Message message) {
        if (this.k != null && this.k.c(message) && this.j != null) {
            this.j.i();
        }
        this.t = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:59:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:78:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void c(String str) {
        float f2;
        double d2;
        double d3;
        boolean z = false;
        if (this.C == null || !this.K) {
            return;
        }
        try {
            ap.a("baidu_location_service", "DB:" + str);
            JSONObject jSONObject = new JSONObject(str);
            int parseInt = Integer.parseInt(jSONObject.getJSONObject("result").getString("error"));
            if (parseInt == 161) {
                JSONObject jSONObject2 = jSONObject.getJSONObject(PushConstants.EXTRA_CONTENT);
                if (jSONObject2.has("clf")) {
                    String string = jSONObject2.getString("clf");
                    if (string.equals("0")) {
                        JSONObject jSONObject3 = jSONObject2.getJSONObject("point");
                        d2 = Double.parseDouble(jSONObject3.getString("x"));
                        d3 = Double.parseDouble(jSONObject3.getString("y"));
                        f2 = Float.parseFloat(jSONObject2.getString("radius"));
                    } else {
                        String[] split = string.split("\\|");
                        d2 = Double.parseDouble(split[0]);
                        d3 = Double.parseDouble(split[1]);
                        f2 = Float.parseFloat(split[2]);
                    }
                    ap.a("baidu_location_service", "DB PARSE:x" + d2 + "y" + d3 + "R" + f2);
                    if (z) {
                        float f3 = 4326.0f + f2;
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("time", Double.valueOf(d2 + 1235.4323d));
                        contentValues.put("tag", Float.valueOf(f3));
                        contentValues.put("type", Double.valueOf(d3 + 2367.3217d));
                        try {
                            if (this.C.update(this.D, contentValues, "id = \"" + this.E + "\"", null) <= 0) {
                                contentValues.put("id", this.E);
                                this.C.insert(this.D, null, contentValues);
                                ap.a("baidu_location_service", "insert DB success!");
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
                this.C.delete(this.D, "id = \"" + this.E + "\"", null);
                return;
            }
            z = true;
            f2 = 0.0f;
            d2 = 0.0d;
            d3 = 0.0d;
            if (z) {
            }
        } catch (Exception e3) {
            ap.a("baidu_location_service", "DB PARSE:exp!");
        }
    }

    public void d(Message message) {
        if (message == null || message.obj == null) {
            ap.a("baidu_location_service", "Gps updateloation is null");
            return;
        }
        Location location = (Location) message.obj;
        if (location != null) {
            ap.a("baidu_location_service", "on update gps...");
            if (!as.a(location, true) || this.h == null || this.j == null || this.k == null || !ap.b) {
                return;
            }
            as.a(this.h.d(), this.j.g(), location, this.k.b());
        }
    }

    public void e(Message message) {
        ap.a("baidu_location_service", "manual upload ...");
        double d2 = message.getData().getDouble("x");
        double d3 = message.getData().getDouble("y");
        String string = message.getData().getString("addr");
        if (this.h != null && this.j != null && this.k != null) {
            as.a(this.h.d(), this.j.g(), this.k.b(), d2, d3, string);
        }
        m();
    }

    public void f() {
        if (this.i == null) {
            return;
        }
        ap.a("baidu_location_service", "on new gps...");
        Location d2 = this.i.d();
        if (this.i.f() && as.a(d2, true) && this.h != null && this.j != null && this.k != null) {
            if (this.j != null) {
                this.j.d();
            }
            as.a(this.h.d(), this.j.g(), d2, this.k.b());
        }
        if (this.k == null || !this.i.f()) {
            return;
        }
        this.k.b(this.i.c());
    }

    public void f(Message message) {
        if (System.currentTimeMillis() - this.A < 3000) {
            ap.a("baidu_location_service", "request too frequency ...");
            if (this.u != null) {
                this.k.a(this.u, 26);
                return;
            }
        }
        if (this.k != null) {
            String a2 = a(this.k.d(message));
            if (this.s != null) {
                a2 = a2 + this.s;
                this.s = null;
            }
            ah.b(this);
            if (ah.b(a2, this.b)) {
                this.q = this.o;
                this.n = this.l;
            } else {
                ap.a("baidu_location_service", "request poi error ..");
            }
            this.A = System.currentTimeMillis();
        }
    }

    public void g() {
        ap.a("baidu_location_service", "on new cell ...");
    }

    public void g(Message message) {
        if (this.k == null) {
            return;
        }
        this.k.a(b(true), message);
    }

    public void h() {
        ap.a("baidu_location_service", "on new wifi ...");
        if (this.y) {
            m();
            this.y = false;
        }
    }

    public void h(Message message) {
        ap.a("baidu_location_service", "on request location ...");
        ap.b("baidu_location_service", "on request location ...");
        if (this.k == null) {
            return;
        }
        if (this.k.e(message) == 1 && this.i != null && this.i.f()) {
            ap.a("baidu_location_service", "send gps location to client ...");
            this.k.a(this.i.c(), message);
        } else if (this.w) {
            m();
        } else if (this.x) {
        } else {
            if (this.j == null || !this.j.e()) {
                m();
                return;
            }
            this.y = true;
            this.b.postDelayed(new ae(this), 2000L);
        }
    }

    public void i() {
        ap.a("baidu_location_service", "on switch gps ...");
        if (this.k == null) {
            return;
        }
        if (this.k.a()) {
            if (this.i == null) {
                this.i = new m(this, this.b);
            }
            this.i.a();
        } else if (this.i != null) {
            this.i.b();
            this.i = null;
        }
    }

    public void j() {
    }

    private void k() {
        if (this.t == null || !ah.a(this)) {
            return;
        }
        ah.a();
    }

    private void l() {
        File file = new File(f470a);
        File file2 = new File(f470a + "/ls.db");
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
            this.C = SQLiteDatabase.openOrCreateDatabase(file2, (SQLiteDatabase.CursorFactory) null);
            this.C.execSQL("CREATE TABLE " + this.D + "(id CHAR(40) PRIMARY KEY,time DOUBLE,tag DOUBLE, type DOUBLE , ac INT);");
        } catch (Exception e3) {
        }
    }

    public void m() {
        if (this.x) {
            return;
        }
        if (System.currentTimeMillis() - this.z < 1000) {
            ap.a("baidu_location_service", "request too frequency ...");
            if (this.t != null) {
                this.k.a(this.t);
                p();
                return;
            }
        }
        ap.a("baidu_location_service", "start network locating ...");
        ap.b("baidu_location_service", "start network locating ...");
        this.x = true;
        this.K = a(this.p);
        if (!a(this.m) && !this.K && this.t != null) {
            this.k.a(this.t);
            p();
            return;
        }
        String a2 = a((String) null);
        if (a2 == null) {
            this.k.a("{\"result\":{\"time\":\"" + ap.a() + "\",\"error\":\"62\"}}");
            p();
            return;
        }
        if (this.s != null) {
            a2 = a2 + this.s;
            this.s = null;
        }
        if (ah.a(a2, this.b)) {
            this.p = this.o;
            this.m = this.l;
        } else {
            ap.a("baidu_location_service", "request error ..");
        }
        if (this.w) {
            this.w = false;
        }
        this.z = System.currentTimeMillis();
    }

    public void n() {
        if (ah.a(this)) {
            ah.a();
        }
    }

    public void o() {
        if (this.k != null) {
            this.k.c();
        }
    }

    private void p() {
        this.x = false;
        k();
    }

    public boolean c() {
        return ((KeyguardManager) getSystemService("keyguard")).inKeyguardRestrictedInputMode();
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.c.getBinder();
    }

    @Override // android.app.Service
    public void onCreate() {
        Thread.setDefaultUncaughtExceptionHandler(new ad(this, this));
        this.h = new t(this, this.b);
        this.j = new w(this, this.b);
        this.k = new k(this.b);
        this.h.a();
        this.j.a();
        this.v = true;
        this.x = false;
        this.y = false;
        ah.d();
        try {
            l();
        } catch (Exception e2) {
        }
        try {
            if (ap.f464a && ap.l) {
                this.B = new af(this, this);
            }
        } catch (Exception e3) {
        }
        ap.a("baidu_location_service", "OnCreate");
        Log.d("baidu_location_service", "baidu location service start1 ..." + Process.myPid());
    }

    @Override // android.app.Service
    public void onDestroy() {
        if (this.h != null) {
            this.h.b();
        }
        if (this.j != null) {
            this.j.c();
        }
        if (this.i != null) {
            this.i.b();
        }
        as.b();
        this.x = false;
        this.y = false;
        this.v = false;
        if (this.B != null) {
            this.B.a();
        }
        if (this.C != null) {
            this.C.close();
        }
        ap.a("baidu_location_service", "onDestroy");
        Log.d("baidu_location_service", "baidu location service stop ...");
        if (ap.f464a) {
            Process.killProcess(Process.myPid());
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        ap.a("baidu_location_service", "onStratCommandNotSticky");
        return 2;
    }
}
