package com.baidu.location.e;

import android.database.sqlite.SQLiteDatabase;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.appsearchlib.Info;
import com.baidu.location.Jni;
import com.baidu.tbadk.TbConfig;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Locale;
import java.util.Scanner;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class h {
    private final d NT;
    private final SQLiteDatabase Op;
    private boolean t = true;
    private long u = 8000;
    private long Ml = TbConfig.NOTIFY_SOUND_INTERVAL;
    private long w = TbConfig.NOTIFY_SOUND_INTERVAL;
    private long x = TbConfig.NOTIFY_SOUND_INTERVAL;
    private long y = TbConfig.NOTIFY_SOUND_INTERVAL;
    private boolean d = false;
    private boolean e = false;
    private boolean f = false;
    private boolean g = false;
    private boolean h = false;
    private boolean j = false;
    private int k = 6;
    private int l = 30;
    private int m = 30;
    private double Or = 0.0d;
    private double MB = 0.0d;
    private double MC = 0.0d;
    private double MD = 0.0d;
    private double ME = 0.0d;
    private int s = 8;
    private String[] i = new String[0];
    private final a Oq = new a();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class a extends com.baidu.location.h.f {
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
            this.f = Jni.encodeOfflineLocationUpdateRequest(String.format(Locale.US, "&ver=%s&cuid=%s&prod=%s:%s&sdk=%.2f", "1", com.baidu.location.h.c.ni().b, com.baidu.location.h.c.d, com.baidu.location.h.c.c, Float.valueOf(6.23f)));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b() {
            if (this.e) {
                return;
            }
            boolean z = false;
            try {
                File file = new File(h.this.NT.mI(), "ofl.config");
                if (this.d == -1 && file.exists()) {
                    Scanner scanner = new Scanner(file);
                    String next = scanner.next();
                    scanner.close();
                    JSONObject jSONObject = new JSONObject(next);
                    h.this.d = jSONObject.getBoolean("ol");
                    h.this.e = jSONObject.getBoolean("fl");
                    h.this.f = jSONObject.getBoolean("on");
                    h.this.g = jSONObject.getBoolean("wn");
                    h.this.h = jSONObject.getBoolean("oc");
                    this.d = jSONObject.getLong(Info.kBaiduTimeKey);
                    if (jSONObject.has("cplist")) {
                        h.this.i = jSONObject.getString("cplist").split(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
                    }
                    if (jSONObject.has("rgcgp")) {
                        h.this.k = jSONObject.getInt("rgcgp");
                    }
                    if (jSONObject.has("rgcon")) {
                        h.this.j = jSONObject.getBoolean("rgcon");
                    }
                    if (jSONObject.has("addrup")) {
                        h.this.m = jSONObject.getInt("addrup");
                    }
                    if (jSONObject.has("poiup")) {
                        h.this.l = jSONObject.getInt("poiup");
                    }
                    if (jSONObject.has("oflp")) {
                        JSONObject jSONObject2 = jSONObject.getJSONObject("oflp");
                        if (jSONObject2.has("0")) {
                            h.this.Or = jSONObject2.getDouble("0");
                        }
                        if (jSONObject2.has("1")) {
                            h.this.MB = jSONObject2.getDouble("1");
                        }
                        if (jSONObject2.has("2")) {
                            h.this.MC = jSONObject2.getDouble("2");
                        }
                        if (jSONObject2.has(TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE)) {
                            h.this.MD = jSONObject2.getDouble(TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE);
                        }
                        if (jSONObject2.has("4")) {
                            h.this.ME = jSONObject2.getDouble("4");
                        }
                    }
                    if (jSONObject.has("onlt")) {
                        JSONObject jSONObject3 = jSONObject.getJSONObject("onlt");
                        if (jSONObject3.has("0")) {
                            h.this.y = jSONObject3.getLong("0");
                        }
                        if (jSONObject3.has("1")) {
                            h.this.x = jSONObject3.getLong("1");
                        }
                        if (jSONObject3.has("2")) {
                            h.this.u = jSONObject3.getLong("2");
                        }
                        if (jSONObject3.has(TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE)) {
                            h.this.Ml = jSONObject3.getLong(TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE);
                        }
                        if (jSONObject3.has("4")) {
                            h.this.w = jSONObject3.getLong("4");
                        }
                    }
                    if (jSONObject.has("minapn")) {
                        h.this.s = jSONObject.getInt("minapn");
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
            if ((this.d == -1 || z) && c() && com.baidu.location.h.i.a(h.this.NT.b())) {
                this.e = true;
                e();
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

        @Override // com.baidu.location.h.f
        public void a() {
            this.k.clear();
            this.k.put("qt", "conf");
            this.k.put("req", this.f);
            this.h = d.a;
        }

        @Override // com.baidu.location.h.f
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
                        h.this.d = true;
                    }
                    if ((j & 2) == 2) {
                        h.this.e = true;
                    }
                    if ((j & 4) == 4) {
                        h.this.f = true;
                    }
                    if ((j & 8) == 8) {
                        h.this.g = true;
                    }
                    if ((16 & j) == 16) {
                        h.this.h = true;
                    }
                    if ((j & 32) == 32) {
                        h.this.j = true;
                    }
                    JSONObject jSONObject2 = new JSONObject();
                    if (jSONObject.has("cplist")) {
                        h.this.i = jSONObject.getString("cplist").split(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
                        jSONObject2.put("cplist", jSONObject.getString("cplist"));
                    }
                    if (jSONObject.has("bklist")) {
                        h.this.a(jSONObject.getString("bklist").split(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR));
                    }
                    if (jSONObject.has("para")) {
                        JSONObject jSONObject3 = jSONObject.getJSONObject("para");
                        if (jSONObject3.has("rgcgp")) {
                            h.this.k = jSONObject3.getInt("rgcgp");
                        }
                        if (jSONObject3.has("addrup")) {
                            h.this.m = jSONObject3.getInt("addrup");
                        }
                        if (jSONObject3.has("poiup")) {
                            h.this.l = jSONObject3.getInt("poiup");
                        }
                        if (jSONObject3.has("oflp")) {
                            JSONObject jSONObject4 = jSONObject3.getJSONObject("oflp");
                            if (jSONObject4.has("0")) {
                                h.this.Or = jSONObject4.getDouble("0");
                            }
                            if (jSONObject4.has("1")) {
                                h.this.MB = jSONObject4.getDouble("1");
                            }
                            if (jSONObject4.has("2")) {
                                h.this.MC = jSONObject4.getDouble("2");
                            }
                            if (jSONObject4.has(TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE)) {
                                h.this.MD = jSONObject4.getDouble(TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE);
                            }
                            if (jSONObject4.has("4")) {
                                h.this.ME = jSONObject4.getDouble("4");
                            }
                        }
                        if (jSONObject3.has("onlt")) {
                            JSONObject jSONObject5 = jSONObject3.getJSONObject("onlt");
                            if (jSONObject5.has("0")) {
                                h.this.y = jSONObject5.getLong("0");
                            }
                            if (jSONObject5.has("1")) {
                                h.this.x = jSONObject5.getLong("1");
                            }
                            if (jSONObject5.has("2")) {
                                h.this.u = jSONObject5.getLong("2");
                            }
                            if (jSONObject5.has(TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE)) {
                                h.this.Ml = jSONObject5.getLong(TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE);
                            }
                            if (jSONObject5.has("4")) {
                                h.this.w = jSONObject5.getLong("4");
                            }
                        }
                        if (jSONObject3.has("minapn")) {
                            h.this.s = jSONObject3.getInt("minapn");
                        }
                    }
                    jSONObject2.put("ol", h.this.d);
                    jSONObject2.put("fl", h.this.e);
                    jSONObject2.put("on", h.this.f);
                    jSONObject2.put("wn", h.this.g);
                    jSONObject2.put("oc", h.this.h);
                    this.d = System.currentTimeMillis();
                    jSONObject2.put(Info.kBaiduTimeKey, this.d);
                    jSONObject2.put("ver", string);
                    jSONObject2.put("rgcon", h.this.j);
                    jSONObject2.put("rgcgp", h.this.k);
                    JSONObject jSONObject6 = new JSONObject();
                    jSONObject6.put("0", h.this.Or);
                    jSONObject6.put("1", h.this.MB);
                    jSONObject6.put("2", h.this.MC);
                    jSONObject6.put(TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE, h.this.MD);
                    jSONObject6.put("4", h.this.ME);
                    jSONObject2.put("oflp", jSONObject6);
                    JSONObject jSONObject7 = new JSONObject();
                    jSONObject7.put("0", h.this.y);
                    jSONObject7.put("1", h.this.x);
                    jSONObject7.put("2", h.this.u);
                    jSONObject7.put(TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE, h.this.Ml);
                    jSONObject7.put("4", h.this.w);
                    jSONObject2.put("onlt", jSONObject7);
                    jSONObject2.put("addrup", h.this.m);
                    jSONObject2.put("poiup", h.this.l);
                    jSONObject2.put("minapn", h.this.s);
                    File file = new File(h.this.NT.mI(), "ofl.config");
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
    public h(d dVar, SQLiteDatabase sQLiteDatabase) {
        this.NT = dVar;
        this.Op = sQLiteDatabase;
        if (this.Op != null && this.Op.isOpen()) {
            try {
                this.Op.execSQL("CREATE TABLE IF NOT EXISTS BLACK (name VARCHAR(100) PRIMARY KEY);");
            } catch (Exception e) {
            }
        }
        g();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a() {
        return this.s;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long a(String str) {
        return str.equals("2G") ? this.u : str.equals("3G") ? this.Ml : str.equals("4G") ? this.w : str.equals("WIFI") ? this.x : str.equals("unknown") ? this.y : TbConfig.NOTIFY_SOUND_INTERVAL;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String[] strArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < strArr.length; i++) {
            if (i > 0) {
                stringBuffer.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
            stringBuffer.append("(\"");
            stringBuffer.append(strArr[i]);
            stringBuffer.append("\")");
        }
        if (this.Op == null || !this.Op.isOpen() || stringBuffer.length() <= 0) {
            return;
        }
        try {
            this.Op.execSQL(String.format(Locale.US, "INSERT OR IGNORE INTO BLACK VALUES %s;", stringBuffer.toString()));
        } catch (Exception e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public double b() {
        return this.Or;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public double c() {
        return this.MB;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g() {
        this.Oq.b();
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
        return this.t;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public double mN() {
        return this.MC;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public double mO() {
        return this.MD;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public double mP() {
        return this.ME;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String[] mQ() {
        return this.i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int n() {
        return this.k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int p() {
        return this.m;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int q() {
        return this.l;
    }
}
