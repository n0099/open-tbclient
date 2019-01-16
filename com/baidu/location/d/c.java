package com.baidu.location.d;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.location.Jni;
import com.baidu.searchbox.ng.ai.apps.ar.model.ARCameraAttr;
import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Locale;
import java.util.Scanner;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class c {
    private final d aeQ;
    private final SQLiteDatabase b;
    private boolean u = true;
    private long v = 8000;
    private long w = 5000;
    private long x = 5000;
    private long y = 5000;
    private long z = 5000;
    private boolean d = false;
    private boolean e = false;
    private boolean f = false;
    private boolean g = false;
    private boolean h = false;
    private boolean j = false;
    private boolean k = false;
    private int l = 6;
    private int m = 30;
    private int n = 30;
    private double o = 0.0d;
    private double p = 0.0d;
    private double aei = 0.0d;
    private double adn = 0.0d;
    private double s = 0.0d;
    private int t = 8;
    private String[] i = new String[0];
    private final a afl = new a();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public final class a extends com.baidu.location.g.e {
        private int b;
        private long c;
        private long d;
        private boolean e;
        private final String f;

        private a() {
            this.b = 0;
            this.e = false;
            this.c = -1L;
            this.d = -1L;
            this.k = new HashMap();
            this.f = Jni.encodeOfflineLocationUpdateRequest(String.format(Locale.US, "&ver=%s&cuid=%s&prod=%s:%s&sdk=%.2f&mb=%s&os=A%s", "1", com.baidu.location.g.b.tZ().b, com.baidu.location.g.b.e, com.baidu.location.g.b.d, Float.valueOf(7.8f), Build.MODEL, Build.VERSION.SDK));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b() {
            if (this.e) {
                return;
            }
            boolean z = false;
            try {
                File file = new File(c.this.aeQ.c(), "ofl.config");
                if (this.d == -1 && file.exists()) {
                    Scanner scanner = new Scanner(file);
                    String next = scanner.next();
                    scanner.close();
                    JSONObject jSONObject = new JSONObject(next);
                    c.this.d = jSONObject.getBoolean("ol");
                    c.this.e = jSONObject.getBoolean("fl");
                    c.this.f = jSONObject.getBoolean(ARCameraAttr.FlashType.FLASH_ON);
                    c.this.g = jSONObject.getBoolean("wn");
                    c.this.h = jSONObject.getBoolean("oc");
                    this.d = jSONObject.getLong("t");
                    if (jSONObject.has("ol")) {
                        c.this.k = jSONObject.getBoolean("olv2");
                    }
                    if (jSONObject.has("cplist")) {
                        c.this.i = jSONObject.getString("cplist").split(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
                    }
                    if (jSONObject.has("rgcgp")) {
                        c.this.l = jSONObject.getInt("rgcgp");
                    }
                    if (jSONObject.has("rgcon")) {
                        c.this.j = jSONObject.getBoolean("rgcon");
                    }
                    if (jSONObject.has("addrup")) {
                        c.this.n = jSONObject.getInt("addrup");
                    }
                    if (jSONObject.has("poiup")) {
                        c.this.m = jSONObject.getInt("poiup");
                    }
                    if (jSONObject.has("oflp")) {
                        JSONObject jSONObject2 = jSONObject.getJSONObject("oflp");
                        if (jSONObject2.has("0")) {
                            c.this.o = jSONObject2.getDouble("0");
                        }
                        if (jSONObject2.has("1")) {
                            c.this.p = jSONObject2.getDouble("1");
                        }
                        if (jSONObject2.has("2")) {
                            c.this.aei = jSONObject2.getDouble("2");
                        }
                        if (jSONObject2.has("3")) {
                            c.this.adn = jSONObject2.getDouble("3");
                        }
                        if (jSONObject2.has("4")) {
                            c.this.s = jSONObject2.getDouble("4");
                        }
                    }
                    if (jSONObject.has("onlt")) {
                        JSONObject jSONObject3 = jSONObject.getJSONObject("onlt");
                        if (jSONObject3.has("0")) {
                            c.this.z = jSONObject3.getLong("0");
                        }
                        if (jSONObject3.has("1")) {
                            c.this.y = jSONObject3.getLong("1");
                        }
                        if (jSONObject3.has("2")) {
                            c.this.v = jSONObject3.getLong("2");
                        }
                        if (jSONObject3.has("3")) {
                            c.this.w = jSONObject3.getLong("3");
                        }
                        if (jSONObject3.has("4")) {
                            c.this.x = jSONObject3.getLong("4");
                        }
                    }
                    if (jSONObject.has("minapn")) {
                        c.this.t = jSONObject.getInt("minapn");
                    }
                }
                if (this.d != -1 || !file.exists()) {
                }
                if (this.d != -1) {
                    if (this.d + 86400000 <= System.currentTimeMillis()) {
                        z = true;
                    }
                }
            } catch (Exception e) {
            }
            if ((this.d == -1 || z) && c() && com.baidu.location.g.g.a(c.this.aeQ.b())) {
                this.e = true;
                b("https://ofloc.map.baidu.com/offline_loc");
            }
        }

        private boolean c() {
            boolean z = true;
            if (this.b >= 2) {
                if (this.c + 86400000 < System.currentTimeMillis()) {
                    this.b = 0;
                    this.c = -1L;
                } else {
                    z = false;
                }
            }
            if (!z) {
            }
            return z;
        }

        @Override // com.baidu.location.g.e
        public void a() {
            this.k.clear();
            this.k.put("qt", "conf");
            this.k.put("req", this.f);
            this.h = d.b;
        }

        @Override // com.baidu.location.g.e
        public void a(boolean z) {
            if (!z || this.j == null) {
                this.b++;
                this.c = System.currentTimeMillis();
            } else {
                try {
                    JSONObject jSONObject = new JSONObject(this.j);
                    long j = jSONObject.has("ofl") ? jSONObject.getLong("ofl") : 0L;
                    String string = jSONObject.has("ver") ? jSONObject.getString("ver") : "1";
                    if ((j & 1) == 1) {
                        c.this.d = true;
                    }
                    if ((j & 2) == 2) {
                        c.this.e = true;
                    }
                    if ((j & 4) == 4) {
                        c.this.f = true;
                    }
                    if ((j & 8) == 8) {
                        c.this.g = true;
                    }
                    if ((16 & j) == 16) {
                        c.this.h = true;
                    }
                    if ((32 & j) == 32) {
                        c.this.j = true;
                    }
                    if ((j & 64) == 64) {
                        c.this.k = true;
                    }
                    JSONObject jSONObject2 = new JSONObject();
                    if (jSONObject.has("cplist")) {
                        c.this.i = jSONObject.getString("cplist").split(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
                        jSONObject2.put("cplist", jSONObject.getString("cplist"));
                    }
                    if (jSONObject.has("bklist")) {
                        c.this.a(jSONObject.getString("bklist").split(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR));
                    }
                    if (jSONObject.has("para")) {
                        JSONObject jSONObject3 = jSONObject.getJSONObject("para");
                        if (jSONObject3.has("rgcgp")) {
                            c.this.l = jSONObject3.getInt("rgcgp");
                        }
                        if (jSONObject3.has("addrup")) {
                            c.this.n = jSONObject3.getInt("addrup");
                        }
                        if (jSONObject3.has("poiup")) {
                            c.this.m = jSONObject3.getInt("poiup");
                        }
                        if (jSONObject3.has("oflp")) {
                            JSONObject jSONObject4 = jSONObject3.getJSONObject("oflp");
                            if (jSONObject4.has("0")) {
                                c.this.o = jSONObject4.getDouble("0");
                            }
                            if (jSONObject4.has("1")) {
                                c.this.p = jSONObject4.getDouble("1");
                            }
                            if (jSONObject4.has("2")) {
                                c.this.aei = jSONObject4.getDouble("2");
                            }
                            if (jSONObject4.has("3")) {
                                c.this.adn = jSONObject4.getDouble("3");
                            }
                            if (jSONObject4.has("4")) {
                                c.this.s = jSONObject4.getDouble("4");
                            }
                        }
                        if (jSONObject3.has("onlt")) {
                            JSONObject jSONObject5 = jSONObject3.getJSONObject("onlt");
                            if (jSONObject5.has("0")) {
                                c.this.z = jSONObject5.getLong("0");
                            }
                            if (jSONObject5.has("1")) {
                                c.this.y = jSONObject5.getLong("1");
                            }
                            if (jSONObject5.has("2")) {
                                c.this.v = jSONObject5.getLong("2");
                            }
                            if (jSONObject5.has("3")) {
                                c.this.w = jSONObject5.getLong("3");
                            }
                            if (jSONObject5.has("4")) {
                                c.this.x = jSONObject5.getLong("4");
                            }
                        }
                        if (jSONObject3.has("minapn")) {
                            c.this.t = jSONObject3.getInt("minapn");
                        }
                    }
                    jSONObject2.put("ol", c.this.d);
                    jSONObject2.put("olv2", c.this.k);
                    jSONObject2.put("fl", c.this.e);
                    jSONObject2.put(ARCameraAttr.FlashType.FLASH_ON, c.this.f);
                    jSONObject2.put("wn", c.this.g);
                    jSONObject2.put("oc", c.this.h);
                    this.d = System.currentTimeMillis();
                    jSONObject2.put("t", this.d);
                    jSONObject2.put("ver", string);
                    jSONObject2.put("rgcon", c.this.j);
                    jSONObject2.put("rgcgp", c.this.l);
                    JSONObject jSONObject6 = new JSONObject();
                    jSONObject6.put("0", c.this.o);
                    jSONObject6.put("1", c.this.p);
                    jSONObject6.put("2", c.this.aei);
                    jSONObject6.put("3", c.this.adn);
                    jSONObject6.put("4", c.this.s);
                    jSONObject2.put("oflp", jSONObject6);
                    JSONObject jSONObject7 = new JSONObject();
                    jSONObject7.put("0", c.this.z);
                    jSONObject7.put("1", c.this.y);
                    jSONObject7.put("2", c.this.v);
                    jSONObject7.put("3", c.this.w);
                    jSONObject7.put("4", c.this.x);
                    jSONObject2.put("onlt", jSONObject7);
                    jSONObject2.put("addrup", c.this.n);
                    jSONObject2.put("poiup", c.this.m);
                    jSONObject2.put("minapn", c.this.t);
                    File file = new File(c.this.aeQ.c(), "ofl.config");
                    if (!file.exists()) {
                        file.createNewFile();
                    }
                    FileWriter fileWriter = new FileWriter(file);
                    fileWriter.write(jSONObject2.toString());
                    fileWriter.close();
                } catch (Exception e) {
                    this.b++;
                    this.c = System.currentTimeMillis();
                }
            }
            this.e = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(d dVar, SQLiteDatabase sQLiteDatabase) {
        this.aeQ = dVar;
        this.b = sQLiteDatabase;
        if (this.b != null && this.b.isOpen()) {
            try {
                this.b.execSQL("CREATE TABLE IF NOT EXISTS BLACK (name VARCHAR(100) PRIMARY KEY);");
            } catch (Exception e) {
            }
        }
        g();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a() {
        return this.t;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long a(String str) {
        if (str.equals("2G")) {
            return this.v;
        }
        if (str.equals("3G")) {
            return this.w;
        }
        if (str.equals("4G")) {
            return this.x;
        }
        if (str.equals("WIFI")) {
            return this.y;
        }
        if (str.equals("unknown")) {
            return this.z;
        }
        return 5000L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String[] strArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < strArr.length; i++) {
            if (i > 0) {
                stringBuffer.append(",");
            }
            stringBuffer.append("(\"");
            stringBuffer.append(strArr[i]);
            stringBuffer.append("\")");
        }
        if (this.b == null || !this.b.isOpen() || stringBuffer.length() <= 0) {
            return;
        }
        try {
            this.b.execSQL(String.format(Locale.US, "INSERT OR IGNORE INTO BLACK VALUES %s;", stringBuffer.toString()));
        } catch (Exception e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public double b() {
        return this.o;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, MOVE_EXCEPTION, INVOKE, MOVE_EXCEPTION] complete} */
    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(String str) {
        Cursor cursor = null;
        try {
            cursor = this.b.rawQuery(String.format(Locale.US, "SELECT * FROM BLACK WHERE NAME IN (\"%s\");", str), null);
            r0 = cursor.getCount() > 0;
            if (cursor != null) {
                try {
                    cursor.close();
                } catch (Exception e) {
                }
            }
        } catch (Exception e2) {
            if (cursor != null) {
                try {
                    cursor.close();
                } catch (Exception e3) {
                }
            }
        } catch (Throwable th) {
            if (cursor != null) {
                try {
                    cursor.close();
                } catch (Exception e4) {
                }
            }
            throw th;
        }
        if (r0) {
        }
        return r0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public double bN() {
        return this.aei;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public double c() {
        return this.p;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g() {
        this.afl.b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean h() {
        return this.d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean i() {
        return this.f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean j() {
        return this.g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean k() {
        return this.e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean l() {
        return this.j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean m() {
        return this.u;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int n() {
        return this.l;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int p() {
        return this.n;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int q() {
        return this.m;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public double tF() {
        return this.adn;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public double tG() {
        return this.s;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String[] tH() {
        return this.i;
    }
}
