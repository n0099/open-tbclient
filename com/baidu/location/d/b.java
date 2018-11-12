package com.baidu.location.d;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.location.BDLocation;
import com.baidu.location.Jni;
import com.baidu.location.Poi;
import com.baidu.location.d.e;
import com.baidu.mobstat.Config;
import com.googlecode.mp4parser.boxes.apple.TrackLoadSettingsAtom;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class b {
    private final d aeH;
    private Long aeI;
    private final SQLiteDatabase aeL;
    private final SQLiteDatabase aeM;
    private int b;
    private double c;
    private double d;
    private boolean p = false;
    private final c aeJ = new c(this, true);
    private final c aeK = new c(this, false);
    private StringBuffer aeS = new StringBuffer();
    private StringBuffer aeN = null;
    private StringBuffer aeO = null;
    private HashSet<Long> aeP = new HashSet<>();
    private ConcurrentHashMap<Long, Integer> aeQ = new ConcurrentHashMap<>();
    private ConcurrentHashMap<Long, String> aeR = new ConcurrentHashMap<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static final class a {
        double a;
        double b;
        double c;

        private a(double d, double d2, double d3) {
            this.a = d;
            this.b = d2;
            this.c = d3;
        }
    }

    /* renamed from: com.baidu.location.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    private class C0086b extends Thread {
        private String a;
        private Long aeU;
        private BDLocation aeV;
        private BDLocation aeW;
        private BDLocation aeX;
        private LinkedHashMap<String, Integer> aeY;
        private String g;

        private C0086b(String str, Long l, BDLocation bDLocation, BDLocation bDLocation2, BDLocation bDLocation3, String str2, LinkedHashMap<String, Integer> linkedHashMap) {
            this.a = str;
            this.aeU = l;
            this.aeV = bDLocation;
            this.aeW = bDLocation2;
            this.aeX = bDLocation3;
            this.g = str2;
            this.aeY = linkedHashMap;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                b.this.a(this.a, this.aeU, this.aeV);
                b.this.aeN = null;
                b.this.aeO = null;
                b.this.a(this.aeY);
                b.this.a(this.aeX, this.aeV, this.aeW, this.a, this.aeU);
                if (this.g != null) {
                    b.this.aeH.tG().a(this.g);
                }
            } catch (Exception e) {
            }
            this.aeY = null;
            this.a = null;
            this.g = null;
            this.aeU = null;
            this.aeV = null;
            this.aeW = null;
            this.aeX = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public final class c extends com.baidu.location.g.e {
        private b afa;
        private String b;
        private final String c;
        private String d;
        private boolean f = false;
        private int q = 0;
        private long r = -1;
        private long s = -1;
        private long t = -1;
        private long u = -1;

        c(b bVar, boolean z) {
            this.afa = bVar;
            if (z) {
                this.c = TrackLoadSettingsAtom.TYPE;
            } else {
                this.c = "update";
            }
            this.k = new HashMap();
            this.b = d.b;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(String str, String str2, String str3) {
            this.d = str3;
            this.b = String.format("http://%s/%s", str, str2);
            a(false, "ofloc.map.baidu.com");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c() {
            this.q++;
            this.r = System.currentTimeMillis();
        }

        private boolean f() {
            if (this.q < 2) {
                return true;
            }
            if (this.r + 43200000 < System.currentTimeMillis()) {
                this.q = 0;
                this.r = -1L;
                return true;
            }
            return false;
        }

        private void g() {
            this.d = null;
            if (!l()) {
                this.d = i();
            } else if (this.s == -1 || this.s + 86400000 <= System.currentTimeMillis()) {
                this.d = h();
            }
            if (this.d == null && (this.t == -1 || this.t + 86400000 <= System.currentTimeMillis())) {
                if (b.this.aeH.tH().a()) {
                    this.d = j();
                } else {
                    this.d = k();
                }
            }
            if (this.d != null) {
                b("https://ofloc.map.baidu.com/offline_loc");
            }
        }

        private String h() {
            JSONObject jSONObject;
            try {
                jSONObject = new JSONObject();
                jSONObject.put("type", "0");
                jSONObject.put("cuid", com.baidu.location.g.b.tW().b);
                jSONObject.put("ver", "1");
                jSONObject.put("prod", com.baidu.location.g.b.e + ":" + com.baidu.location.g.b.d);
            } catch (Exception e) {
                jSONObject = null;
            }
            if (jSONObject != null) {
                return Jni.encodeOfflineLocationUpdateRequest(jSONObject.toString());
            }
            return null;
        }

        /* JADX WARN: Removed duplicated region for block: B:102:0x00e1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:106:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:21:0x006a  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x009a  */
        /* JADX WARN: Removed duplicated region for block: B:84:0x0173 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:86:0x016e A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:90:0x005f A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:92:0x0157 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:94:0x0064 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:98:0x015c A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private String i() {
            JSONObject jSONObject;
            Cursor cursor;
            Cursor cursor2;
            JSONObject jSONObject2;
            String str;
            JSONObject jSONObject3;
            int i;
            int i2 = 0;
            Cursor cursor3 = null;
            try {
                try {
                    jSONObject3 = new JSONObject();
                    jSONObject = new JSONObject();
                    try {
                        cursor = b.this.aeM.rawQuery(String.format("SELECT * FROM %s WHERE frequency>%d ORDER BY frequency DESC LIMIT %d;", "CL", 5, 50), null);
                    } catch (Exception e) {
                        cursor = null;
                        cursor2 = null;
                    }
                } catch (Throwable th) {
                    th = th;
                    cursor = null;
                }
            } catch (Exception e2) {
                jSONObject = null;
                cursor = null;
                cursor2 = null;
            }
            if (cursor != null) {
                try {
                } catch (Exception e3) {
                    cursor2 = null;
                    if (cursor2 != null) {
                        try {
                            cursor2.close();
                        } catch (Exception e4) {
                        }
                    }
                    if (cursor != null) {
                        try {
                            cursor.close();
                            jSONObject2 = jSONObject;
                        } catch (Exception e5) {
                            jSONObject2 = jSONObject;
                        }
                        if (jSONObject2 != null) {
                        }
                        str = null;
                        if (jSONObject2 == null) {
                        }
                    }
                    jSONObject2 = jSONObject;
                    if (jSONObject2 != null) {
                    }
                    str = null;
                    if (jSONObject2 == null) {
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (cursor3 != null) {
                        try {
                            cursor3.close();
                        } catch (Exception e6) {
                        }
                    }
                    if (cursor != null) {
                        try {
                            cursor.close();
                        } catch (Exception e7) {
                        }
                    }
                    throw th;
                }
                if (cursor.moveToFirst()) {
                    int count = cursor.getCount();
                    JSONArray jSONArray = new JSONArray();
                    while (!cursor.isAfterLast()) {
                        jSONArray.put(cursor.getString(1));
                        cursor.moveToNext();
                    }
                    jSONObject3.put("cell", jSONArray);
                    i = count;
                    cursor2 = b.this.aeM.rawQuery(String.format("SELECT * FROM %s WHERE frequency>%d ORDER BY frequency DESC LIMIT %d;", "AP", 5, 50), null);
                    if (cursor2 != null) {
                        try {
                            if (cursor2.moveToFirst()) {
                                i2 = cursor2.getCount();
                                JSONArray jSONArray2 = new JSONArray();
                                while (!cursor2.isAfterLast()) {
                                    jSONArray2.put(cursor2.getString(1));
                                    cursor2.moveToNext();
                                }
                                jSONObject3.put("ap", jSONArray2);
                            }
                        } catch (Exception e8) {
                            if (cursor2 != null) {
                            }
                            if (cursor != null) {
                            }
                            jSONObject2 = jSONObject;
                            if (jSONObject2 != null) {
                            }
                            str = null;
                            if (jSONObject2 == null) {
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            cursor3 = cursor2;
                            if (cursor3 != null) {
                            }
                            if (cursor != null) {
                            }
                            throw th;
                        }
                    }
                    jSONObject.put("type", "1");
                    jSONObject.put("cuid", com.baidu.location.g.b.tW().b);
                    jSONObject.put("ver", "1");
                    jSONObject.put("prod", com.baidu.location.g.b.e + ":" + com.baidu.location.g.b.d);
                    if (i == 0 || i2 != 0) {
                        jSONObject.put("model", jSONObject3);
                    }
                    if (cursor2 != null) {
                        try {
                            cursor2.close();
                        } catch (Exception e9) {
                        }
                    }
                    if (cursor != null) {
                        try {
                            cursor.close();
                            jSONObject2 = jSONObject;
                        } catch (Exception e10) {
                            jSONObject2 = jSONObject;
                        }
                        if (jSONObject2 != null || jSONObject2.has("model") || (this.u != -1 && this.u + 86400000 >= System.currentTimeMillis())) {
                            str = null;
                        } else {
                            String encodeOfflineLocationUpdateRequest = Jni.encodeOfflineLocationUpdateRequest(jSONObject2.toString());
                            this.u = System.currentTimeMillis();
                            str = encodeOfflineLocationUpdateRequest;
                        }
                        return (jSONObject2 == null || !jSONObject2.has("model")) ? str : Jni.encodeOfflineLocationUpdateRequest(jSONObject2.toString());
                    }
                    jSONObject2 = jSONObject;
                    if (jSONObject2 != null) {
                    }
                    str = null;
                    if (jSONObject2 == null) {
                        return str;
                    }
                }
            }
            i = 0;
            cursor2 = b.this.aeM.rawQuery(String.format("SELECT * FROM %s WHERE frequency>%d ORDER BY frequency DESC LIMIT %d;", "AP", 5, 50), null);
            if (cursor2 != null) {
            }
            jSONObject.put("type", "1");
            jSONObject.put("cuid", com.baidu.location.g.b.tW().b);
            jSONObject.put("ver", "1");
            jSONObject.put("prod", com.baidu.location.g.b.e + ":" + com.baidu.location.g.b.d);
            if (i == 0) {
            }
            jSONObject.put("model", jSONObject3);
            if (cursor2 != null) {
            }
            if (cursor != null) {
            }
            jSONObject2 = jSONObject;
            if (jSONObject2 != null) {
            }
            str = null;
            if (jSONObject2 == null) {
            }
        }

        private String j() {
            JSONObject jSONObject;
            try {
                jSONObject = new JSONObject();
                try {
                    jSONObject.put("type", "2");
                    jSONObject.put("ver", "1");
                    jSONObject.put("cuid", com.baidu.location.g.b.tW().b);
                    jSONObject.put("prod", com.baidu.location.g.b.e + ":" + com.baidu.location.g.b.d);
                    this.t = System.currentTimeMillis();
                } catch (Exception e) {
                }
            } catch (Exception e2) {
                jSONObject = null;
            }
            if (jSONObject != null) {
                return Jni.encodeOfflineLocationUpdateRequest(jSONObject.toString());
            }
            return null;
        }

        private String k() {
            JSONObject jSONObject;
            try {
                JSONObject b = b.this.aeH.tH().b();
                if (b != null) {
                    jSONObject = new JSONObject();
                    try {
                        jSONObject.put("type", "3");
                        jSONObject.put("ver", "1");
                        jSONObject.put("cuid", com.baidu.location.g.b.tW().b);
                        jSONObject.put("prod", com.baidu.location.g.b.e + ":" + com.baidu.location.g.b.d);
                        jSONObject.put("rgc", b);
                        this.t = System.currentTimeMillis();
                    } catch (Exception e) {
                    }
                } else {
                    jSONObject = null;
                }
            } catch (Exception e2) {
                jSONObject = null;
            }
            if (jSONObject != null) {
                return Jni.encodeOfflineLocationUpdateRequest(jSONObject.toString());
            }
            return null;
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x003b, code lost:
            if (r1.getInt(0) != 0) goto L18;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private boolean l() {
            Cursor cursor;
            Cursor cursor2 = null;
            boolean z = true;
            try {
                cursor = b.this.aeL.rawQuery("SELECT COUNT(*) FROM AP;", null);
            } catch (Exception e) {
                cursor = null;
            } catch (Throwable th) {
                th = th;
                cursor = null;
            }
            try {
                cursor2 = b.this.aeL.rawQuery("SELECT COUNT(*) FROM CL", null);
                if (cursor != null && cursor.moveToFirst() && cursor2 != null && cursor2.moveToFirst()) {
                    if (cursor.getInt(0) == 0) {
                    }
                    z = false;
                }
                if (cursor != null) {
                    try {
                        cursor.close();
                    } catch (Exception e2) {
                    }
                }
                if (cursor2 != null) {
                    try {
                        cursor2.close();
                    } catch (Exception e3) {
                    }
                }
            } catch (Exception e4) {
                if (cursor != null) {
                    try {
                        cursor.close();
                    } catch (Exception e5) {
                    }
                }
                if (cursor2 != null) {
                    try {
                        cursor2.close();
                    } catch (Exception e6) {
                    }
                }
                return z;
            } catch (Throwable th2) {
                th = th2;
                if (cursor != null) {
                    try {
                        cursor.close();
                    } catch (Exception e7) {
                    }
                }
                if (cursor2 != null) {
                    try {
                        cursor2.close();
                    } catch (Exception e8) {
                    }
                }
                throw th;
            }
            return z;
        }

        @Override // com.baidu.location.g.e
        public void a() {
            this.f = true;
            this.h = this.b;
            this.k.clear();
            this.k.put("qt", this.c);
            this.k.put("req", this.d);
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [com.baidu.location.d.b$c$1] */
        @Override // com.baidu.location.g.e
        public void a(boolean z) {
            if (z && this.j != null) {
                new Thread() { // from class: com.baidu.location.d.b.c.1
                    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[IGET, IGET, INVOKE] complete} */
                    /* JADX WARN: Removed duplicated region for block: B:104:0x0351 A[Catch: Exception -> 0x0267, all -> 0x02db, TryCatch #4 {Exception -> 0x0267, blocks: (B:25:0x0097, B:27:0x00aa, B:29:0x00b3, B:31:0x00c3, B:33:0x00d0, B:35:0x00d9, B:37:0x00f4, B:39:0x00fd, B:41:0x0134, B:43:0x013d, B:44:0x015d, B:46:0x0163, B:49:0x017f, B:53:0x0191, B:56:0x01d8, B:59:0x0202, B:62:0x022c, B:84:0x02d4, B:101:0x0341, B:102:0x0349, B:68:0x0260, B:104:0x0351, B:106:0x0371, B:108:0x0391, B:110:0x03b1, B:112:0x03ba, B:113:0x03da, B:115:0x03e0, B:118:0x03fc, B:122:0x040e, B:125:0x0459, B:128:0x0483, B:130:0x04ab, B:133:0x04dd, B:136:0x04e9, B:137:0x04f6, B:132:0x04d4, B:139:0x04fe, B:141:0x051e, B:143:0x053e, B:144:0x055c, B:146:0x0610, B:148:0x0619, B:150:0x0622, B:151:0x0629), top: B:185:0x0097, outer: #7 }] */
                    /* JADX WARN: Removed duplicated region for block: B:106:0x0371 A[Catch: Exception -> 0x0267, all -> 0x02db, TryCatch #4 {Exception -> 0x0267, blocks: (B:25:0x0097, B:27:0x00aa, B:29:0x00b3, B:31:0x00c3, B:33:0x00d0, B:35:0x00d9, B:37:0x00f4, B:39:0x00fd, B:41:0x0134, B:43:0x013d, B:44:0x015d, B:46:0x0163, B:49:0x017f, B:53:0x0191, B:56:0x01d8, B:59:0x0202, B:62:0x022c, B:84:0x02d4, B:101:0x0341, B:102:0x0349, B:68:0x0260, B:104:0x0351, B:106:0x0371, B:108:0x0391, B:110:0x03b1, B:112:0x03ba, B:113:0x03da, B:115:0x03e0, B:118:0x03fc, B:122:0x040e, B:125:0x0459, B:128:0x0483, B:130:0x04ab, B:133:0x04dd, B:136:0x04e9, B:137:0x04f6, B:132:0x04d4, B:139:0x04fe, B:141:0x051e, B:143:0x053e, B:144:0x055c, B:146:0x0610, B:148:0x0619, B:150:0x0622, B:151:0x0629), top: B:185:0x0097, outer: #7 }] */
                    /* JADX WARN: Removed duplicated region for block: B:108:0x0391 A[Catch: Exception -> 0x0267, all -> 0x02db, TryCatch #4 {Exception -> 0x0267, blocks: (B:25:0x0097, B:27:0x00aa, B:29:0x00b3, B:31:0x00c3, B:33:0x00d0, B:35:0x00d9, B:37:0x00f4, B:39:0x00fd, B:41:0x0134, B:43:0x013d, B:44:0x015d, B:46:0x0163, B:49:0x017f, B:53:0x0191, B:56:0x01d8, B:59:0x0202, B:62:0x022c, B:84:0x02d4, B:101:0x0341, B:102:0x0349, B:68:0x0260, B:104:0x0351, B:106:0x0371, B:108:0x0391, B:110:0x03b1, B:112:0x03ba, B:113:0x03da, B:115:0x03e0, B:118:0x03fc, B:122:0x040e, B:125:0x0459, B:128:0x0483, B:130:0x04ab, B:133:0x04dd, B:136:0x04e9, B:137:0x04f6, B:132:0x04d4, B:139:0x04fe, B:141:0x051e, B:143:0x053e, B:144:0x055c, B:146:0x0610, B:148:0x0619, B:150:0x0622, B:151:0x0629), top: B:185:0x0097, outer: #7 }] */
                    /* JADX WARN: Removed duplicated region for block: B:115:0x03e0 A[Catch: Exception -> 0x0267, all -> 0x02db, TryCatch #4 {Exception -> 0x0267, blocks: (B:25:0x0097, B:27:0x00aa, B:29:0x00b3, B:31:0x00c3, B:33:0x00d0, B:35:0x00d9, B:37:0x00f4, B:39:0x00fd, B:41:0x0134, B:43:0x013d, B:44:0x015d, B:46:0x0163, B:49:0x017f, B:53:0x0191, B:56:0x01d8, B:59:0x0202, B:62:0x022c, B:84:0x02d4, B:101:0x0341, B:102:0x0349, B:68:0x0260, B:104:0x0351, B:106:0x0371, B:108:0x0391, B:110:0x03b1, B:112:0x03ba, B:113:0x03da, B:115:0x03e0, B:118:0x03fc, B:122:0x040e, B:125:0x0459, B:128:0x0483, B:130:0x04ab, B:133:0x04dd, B:136:0x04e9, B:137:0x04f6, B:132:0x04d4, B:139:0x04fe, B:141:0x051e, B:143:0x053e, B:144:0x055c, B:146:0x0610, B:148:0x0619, B:150:0x0622, B:151:0x0629), top: B:185:0x0097, outer: #7 }] */
                    /* JADX WARN: Removed duplicated region for block: B:139:0x04fe A[Catch: Exception -> 0x0267, all -> 0x02db, TryCatch #4 {Exception -> 0x0267, blocks: (B:25:0x0097, B:27:0x00aa, B:29:0x00b3, B:31:0x00c3, B:33:0x00d0, B:35:0x00d9, B:37:0x00f4, B:39:0x00fd, B:41:0x0134, B:43:0x013d, B:44:0x015d, B:46:0x0163, B:49:0x017f, B:53:0x0191, B:56:0x01d8, B:59:0x0202, B:62:0x022c, B:84:0x02d4, B:101:0x0341, B:102:0x0349, B:68:0x0260, B:104:0x0351, B:106:0x0371, B:108:0x0391, B:110:0x03b1, B:112:0x03ba, B:113:0x03da, B:115:0x03e0, B:118:0x03fc, B:122:0x040e, B:125:0x0459, B:128:0x0483, B:130:0x04ab, B:133:0x04dd, B:136:0x04e9, B:137:0x04f6, B:132:0x04d4, B:139:0x04fe, B:141:0x051e, B:143:0x053e, B:144:0x055c, B:146:0x0610, B:148:0x0619, B:150:0x0622, B:151:0x0629), top: B:185:0x0097, outer: #7 }] */
                    /* JADX WARN: Removed duplicated region for block: B:141:0x051e A[Catch: Exception -> 0x0267, all -> 0x02db, TryCatch #4 {Exception -> 0x0267, blocks: (B:25:0x0097, B:27:0x00aa, B:29:0x00b3, B:31:0x00c3, B:33:0x00d0, B:35:0x00d9, B:37:0x00f4, B:39:0x00fd, B:41:0x0134, B:43:0x013d, B:44:0x015d, B:46:0x0163, B:49:0x017f, B:53:0x0191, B:56:0x01d8, B:59:0x0202, B:62:0x022c, B:84:0x02d4, B:101:0x0341, B:102:0x0349, B:68:0x0260, B:104:0x0351, B:106:0x0371, B:108:0x0391, B:110:0x03b1, B:112:0x03ba, B:113:0x03da, B:115:0x03e0, B:118:0x03fc, B:122:0x040e, B:125:0x0459, B:128:0x0483, B:130:0x04ab, B:133:0x04dd, B:136:0x04e9, B:137:0x04f6, B:132:0x04d4, B:139:0x04fe, B:141:0x051e, B:143:0x053e, B:144:0x055c, B:146:0x0610, B:148:0x0619, B:150:0x0622, B:151:0x0629), top: B:185:0x0097, outer: #7 }] */
                    /* JADX WARN: Removed duplicated region for block: B:143:0x053e A[Catch: Exception -> 0x0267, all -> 0x02db, TryCatch #4 {Exception -> 0x0267, blocks: (B:25:0x0097, B:27:0x00aa, B:29:0x00b3, B:31:0x00c3, B:33:0x00d0, B:35:0x00d9, B:37:0x00f4, B:39:0x00fd, B:41:0x0134, B:43:0x013d, B:44:0x015d, B:46:0x0163, B:49:0x017f, B:53:0x0191, B:56:0x01d8, B:59:0x0202, B:62:0x022c, B:84:0x02d4, B:101:0x0341, B:102:0x0349, B:68:0x0260, B:104:0x0351, B:106:0x0371, B:108:0x0391, B:110:0x03b1, B:112:0x03ba, B:113:0x03da, B:115:0x03e0, B:118:0x03fc, B:122:0x040e, B:125:0x0459, B:128:0x0483, B:130:0x04ab, B:133:0x04dd, B:136:0x04e9, B:137:0x04f6, B:132:0x04d4, B:139:0x04fe, B:141:0x051e, B:143:0x053e, B:144:0x055c, B:146:0x0610, B:148:0x0619, B:150:0x0622, B:151:0x0629), top: B:185:0x0097, outer: #7 }] */
                    /* JADX WARN: Removed duplicated region for block: B:185:0x0097 A[EXC_TOP_SPLITTER, SYNTHETIC] */
                    /* JADX WARN: Removed duplicated region for block: B:46:0x0163 A[Catch: Exception -> 0x0267, all -> 0x02db, TryCatch #4 {Exception -> 0x0267, blocks: (B:25:0x0097, B:27:0x00aa, B:29:0x00b3, B:31:0x00c3, B:33:0x00d0, B:35:0x00d9, B:37:0x00f4, B:39:0x00fd, B:41:0x0134, B:43:0x013d, B:44:0x015d, B:46:0x0163, B:49:0x017f, B:53:0x0191, B:56:0x01d8, B:59:0x0202, B:62:0x022c, B:84:0x02d4, B:101:0x0341, B:102:0x0349, B:68:0x0260, B:104:0x0351, B:106:0x0371, B:108:0x0391, B:110:0x03b1, B:112:0x03ba, B:113:0x03da, B:115:0x03e0, B:118:0x03fc, B:122:0x040e, B:125:0x0459, B:128:0x0483, B:130:0x04ab, B:133:0x04dd, B:136:0x04e9, B:137:0x04f6, B:132:0x04d4, B:139:0x04fe, B:141:0x051e, B:143:0x053e, B:144:0x055c, B:146:0x0610, B:148:0x0619, B:150:0x0622, B:151:0x0629), top: B:185:0x0097, outer: #7 }] */
                    @Override // java.lang.Thread, java.lang.Runnable
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public void run() {
                        JSONObject jSONObject;
                        JSONObject jSONObject2;
                        Iterator<String> keys;
                        int i;
                        int i2;
                        int i3;
                        int i4;
                        int i5;
                        boolean z2;
                        Iterator<String> keys2;
                        int i6;
                        int i7;
                        int i8;
                        int i9;
                        boolean z3;
                        JSONObject jSONObject3;
                        super.run();
                        if (b.this.aeL == null || b.this.aeM == null || !b.this.aeL.isOpen() || !b.this.aeM.isOpen()) {
                            c.this.f = false;
                            return;
                        }
                        JSONObject jSONObject4 = null;
                        JSONObject jSONObject5 = null;
                        JSONObject jSONObject6 = null;
                        try {
                            if (c.this.j != null) {
                                jSONObject = new JSONObject(c.this.j);
                                try {
                                    jSONObject3 = jSONObject.has("model") ? jSONObject.getJSONObject("model") : null;
                                    try {
                                        if (jSONObject.has("rgc")) {
                                            jSONObject6 = jSONObject.getJSONObject("rgc");
                                        }
                                    } catch (Exception e) {
                                        jSONObject4 = jSONObject3;
                                        jSONObject5 = jSONObject;
                                        e = e;
                                        e.printStackTrace();
                                        jSONObject = jSONObject5;
                                        jSONObject2 = jSONObject4;
                                        b.this.aeL.beginTransaction();
                                        b.this.aeM.beginTransaction();
                                        if (jSONObject6 != null) {
                                        }
                                        if (jSONObject != null) {
                                            c.this.s = System.currentTimeMillis();
                                        }
                                        if (jSONObject != null) {
                                            c.this.afa.a(jSONObject.getString("bdlist").split(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR));
                                        }
                                        if (jSONObject != null) {
                                            c.this.afa.a(jSONObject.getJSONObject("loadurl").getString("host"), jSONObject.getJSONObject("loadurl").getString("module"), jSONObject.getJSONObject("loadurl").getString("req"));
                                        }
                                        if (jSONObject2 != null) {
                                            JSONObject jSONObject7 = jSONObject2.getJSONObject("cell");
                                            keys2 = jSONObject7.keys();
                                            StringBuffer stringBuffer = new StringBuffer();
                                            StringBuffer stringBuffer2 = new StringBuffer();
                                            StringBuffer stringBuffer3 = new StringBuffer();
                                            boolean z4 = true;
                                            boolean z5 = true;
                                            boolean z6 = true;
                                            i6 = 0;
                                            i7 = 0;
                                            i8 = 0;
                                            while (keys2.hasNext()) {
                                            }
                                            if (i7 > 0) {
                                            }
                                            if (i8 > 0) {
                                            }
                                            if (i6 > 0) {
                                            }
                                        }
                                        if (jSONObject2 != null) {
                                            JSONObject jSONObject8 = jSONObject2.getJSONObject("ap");
                                            keys = jSONObject8.keys();
                                            i = 0;
                                            i2 = 0;
                                            i3 = 0;
                                            boolean z7 = true;
                                            boolean z8 = true;
                                            boolean z9 = true;
                                            StringBuffer stringBuffer4 = new StringBuffer();
                                            StringBuffer stringBuffer5 = new StringBuffer();
                                            StringBuffer stringBuffer6 = new StringBuffer();
                                            while (keys.hasNext()) {
                                            }
                                            if (i2 > 0) {
                                            }
                                            if (i3 > 0) {
                                            }
                                            if (i > 0) {
                                            }
                                        }
                                        b.this.aeL.execSQL(String.format("DELETE FROM %s WHERE id NOT IN (SELECT id FROM %s ORDER BY timestamp DESC, frequency DESC LIMIT %d);", "AP", "AP", 200000));
                                        b.this.aeL.execSQL(String.format("DELETE FROM %s WHERE id NOT IN (SELECT id FROM %s ORDER BY timestamp DESC, frequency DESC LIMIT %d);", "CL", "CL", 200000));
                                        b.this.aeM.execSQL(String.format("DELETE FROM %s WHERE id NOT IN (SELECT id FROM %s ORDER BY frequency DESC LIMIT %d);", "AP", "AP", 10000));
                                        b.this.aeM.execSQL(String.format("DELETE FROM %s WHERE id NOT IN (SELECT id FROM %s ORDER BY frequency DESC LIMIT %d);", "CL", "CL", 10000));
                                        if (jSONObject2 != null) {
                                            c.this.c();
                                        }
                                        b.this.aeL.setTransactionSuccessful();
                                        b.this.aeM.setTransactionSuccessful();
                                        if (b.this.aeL != null) {
                                            b.this.aeL.endTransaction();
                                        }
                                        if (b.this.aeM != null) {
                                            b.this.aeM.endTransaction();
                                        }
                                        c.this.j = null;
                                        c.this.f = false;
                                    }
                                } catch (Exception e2) {
                                    jSONObject5 = jSONObject;
                                    e = e2;
                                }
                            } else {
                                jSONObject = null;
                                jSONObject3 = null;
                            }
                            jSONObject2 = jSONObject3;
                        } catch (Exception e3) {
                            e = e3;
                        }
                        try {
                            b.this.aeL.beginTransaction();
                            b.this.aeM.beginTransaction();
                        } catch (Exception e4) {
                        }
                        if (jSONObject6 != null) {
                            try {
                                try {
                                    b.this.aeH.tH().a(jSONObject6);
                                } catch (Exception e5) {
                                    c.this.c();
                                    try {
                                        if (b.this.aeL != null && b.this.aeL.isOpen()) {
                                            b.this.aeL.endTransaction();
                                        }
                                        if (b.this.aeM != null && b.this.aeM.isOpen()) {
                                            b.this.aeM.endTransaction();
                                        }
                                    } catch (Exception e6) {
                                    }
                                    c.this.j = null;
                                    c.this.f = false;
                                    return;
                                }
                            } catch (Throwable th) {
                                try {
                                    if (b.this.aeL != null && b.this.aeL.isOpen()) {
                                        b.this.aeL.endTransaction();
                                    }
                                    if (b.this.aeM != null && b.this.aeM.isOpen()) {
                                        b.this.aeM.endTransaction();
                                    }
                                } catch (Exception e7) {
                                }
                                c.this.j = null;
                                c.this.f = false;
                                throw th;
                            }
                        }
                        if (jSONObject != null && jSONObject.has("type") && jSONObject.getString("type").equals("0")) {
                            c.this.s = System.currentTimeMillis();
                        }
                        if (jSONObject != null && jSONObject.has("bdlist")) {
                            c.this.afa.a(jSONObject.getString("bdlist").split(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR));
                        }
                        if (jSONObject != null && jSONObject.has("loadurl")) {
                            c.this.afa.a(jSONObject.getJSONObject("loadurl").getString("host"), jSONObject.getJSONObject("loadurl").getString("module"), jSONObject.getJSONObject("loadurl").getString("req"));
                        }
                        if (jSONObject2 != null && jSONObject2.has("cell")) {
                            JSONObject jSONObject72 = jSONObject2.getJSONObject("cell");
                            keys2 = jSONObject72.keys();
                            StringBuffer stringBuffer7 = new StringBuffer();
                            StringBuffer stringBuffer22 = new StringBuffer();
                            StringBuffer stringBuffer32 = new StringBuffer();
                            boolean z42 = true;
                            boolean z52 = true;
                            boolean z62 = true;
                            i6 = 0;
                            i7 = 0;
                            i8 = 0;
                            while (keys2.hasNext()) {
                                String next = keys2.next();
                                String string = jSONObject72.getString(next);
                                Double valueOf = Double.valueOf(string.split(",")[3]);
                                if (z52) {
                                    z52 = false;
                                } else {
                                    stringBuffer22.append(',');
                                }
                                stringBuffer22.append(next);
                                i7++;
                                if (valueOf.doubleValue() > 0.0d) {
                                    if (z62) {
                                        z62 = false;
                                    } else {
                                        stringBuffer32.append(',');
                                    }
                                    stringBuffer32.append('(').append(next).append(',').append(string).append("," + (System.currentTimeMillis() / 1000)).append(')');
                                    i8++;
                                    i9 = i6;
                                    z3 = z42;
                                } else {
                                    if (z42) {
                                        z42 = false;
                                    } else {
                                        stringBuffer7.append(',');
                                    }
                                    stringBuffer7.append(next);
                                    i9 = i6 + 1;
                                    z3 = z42;
                                }
                                if (i7 >= 100) {
                                    b.this.aeM.execSQL(String.format("DELETE FROM CL WHERE id IN (%s);", stringBuffer22.toString()));
                                    z52 = true;
                                    stringBuffer22.setLength(0);
                                    i7 -= 100;
                                }
                                if (i8 >= 100) {
                                    b.this.aeL.execSQL(String.format("INSERT OR REPLACE INTO CL (id,x,y,r,cl,timestamp) VALUES %s;", stringBuffer32.toString()));
                                    z62 = true;
                                    stringBuffer32.setLength(0);
                                    i8 -= 100;
                                }
                                if (i9 >= 100) {
                                    b.this.aeL.execSQL(String.format("DELETE FROM CL WHERE id IN (%s);", stringBuffer7.toString()));
                                    z3 = true;
                                    stringBuffer7.setLength(0);
                                    i9 -= 100;
                                }
                                z42 = z3;
                                i6 = i9;
                            }
                            if (i7 > 0) {
                                b.this.aeM.execSQL(String.format("DELETE FROM CL WHERE id IN (%s);", stringBuffer22.toString()));
                            }
                            if (i8 > 0) {
                                b.this.aeL.execSQL(String.format("INSERT OR REPLACE INTO CL (id,x,y,r,cl,timestamp) VALUES %s;", stringBuffer32.toString()));
                            }
                            if (i6 > 0) {
                                b.this.aeL.execSQL(String.format("DELETE FROM CL WHERE id IN (%s);", stringBuffer7.toString()));
                            }
                        }
                        if (jSONObject2 != null && jSONObject2.has("ap")) {
                            JSONObject jSONObject82 = jSONObject2.getJSONObject("ap");
                            keys = jSONObject82.keys();
                            i = 0;
                            i2 = 0;
                            i3 = 0;
                            boolean z72 = true;
                            boolean z82 = true;
                            boolean z92 = true;
                            StringBuffer stringBuffer42 = new StringBuffer();
                            StringBuffer stringBuffer52 = new StringBuffer();
                            StringBuffer stringBuffer62 = new StringBuffer();
                            while (keys.hasNext()) {
                                String next2 = keys.next();
                                String string2 = jSONObject82.getString(next2);
                                Double valueOf2 = Double.valueOf(string2.split(",")[3]);
                                if (z82) {
                                    z82 = false;
                                } else {
                                    stringBuffer52.append(',');
                                }
                                stringBuffer52.append(next2);
                                i2++;
                                if (valueOf2.doubleValue() > 0.0d) {
                                    if (z92) {
                                        z92 = false;
                                    } else {
                                        stringBuffer62.append(',');
                                    }
                                    stringBuffer62.append('(').append(next2).append(',').append(string2).append("," + (System.currentTimeMillis() / 1000)).append(')');
                                    int i10 = i3 + 1;
                                    i5 = i;
                                    z2 = z92;
                                    i4 = i10;
                                } else {
                                    if (z72) {
                                        z72 = false;
                                    } else {
                                        stringBuffer42.append(',');
                                    }
                                    stringBuffer42.append(next2);
                                    boolean z10 = z92;
                                    i4 = i3;
                                    i5 = i + 1;
                                    z2 = z10;
                                }
                                if (i2 >= 100) {
                                    b.this.aeM.execSQL(String.format("DELETE FROM AP WHERE id IN (%s);", stringBuffer52.toString()));
                                    z82 = true;
                                    stringBuffer52.setLength(0);
                                    i2 -= 100;
                                }
                                if (i4 >= 100) {
                                    b.this.aeL.execSQL(String.format("INSERT OR REPLACE INTO AP (id,x,y,r,cl,timestamp) VALUES %s;", stringBuffer62.toString()));
                                    z2 = true;
                                    stringBuffer62.setLength(0);
                                    i4 -= 100;
                                }
                                if (i5 > 0) {
                                    b.this.aeL.execSQL(String.format("DELETE FROM AP WHERE id IN (%s);", stringBuffer42.toString()));
                                }
                                i = i5;
                                i3 = i4;
                                z92 = z2;
                            }
                            if (i2 > 0) {
                                b.this.aeM.execSQL(String.format("DELETE FROM AP WHERE id IN (%s);", stringBuffer52.toString()));
                            }
                            if (i3 > 0) {
                                b.this.aeL.execSQL(String.format("INSERT OR REPLACE INTO AP (id,x,y,r,cl,timestamp) VALUES %s;", stringBuffer62.toString()));
                            }
                            if (i > 0) {
                                b.this.aeL.execSQL(String.format("DELETE FROM AP WHERE id IN (%s);", stringBuffer42.toString()));
                            }
                        }
                        b.this.aeL.execSQL(String.format("DELETE FROM %s WHERE id NOT IN (SELECT id FROM %s ORDER BY timestamp DESC, frequency DESC LIMIT %d);", "AP", "AP", 200000));
                        b.this.aeL.execSQL(String.format("DELETE FROM %s WHERE id NOT IN (SELECT id FROM %s ORDER BY timestamp DESC, frequency DESC LIMIT %d);", "CL", "CL", 200000));
                        b.this.aeM.execSQL(String.format("DELETE FROM %s WHERE id NOT IN (SELECT id FROM %s ORDER BY frequency DESC LIMIT %d);", "AP", "AP", 10000));
                        b.this.aeM.execSQL(String.format("DELETE FROM %s WHERE id NOT IN (SELECT id FROM %s ORDER BY frequency DESC LIMIT %d);", "CL", "CL", 10000));
                        if (jSONObject2 != null && !jSONObject2.has("ap") && !jSONObject2.has("cell")) {
                            c.this.c();
                        }
                        b.this.aeL.setTransactionSuccessful();
                        b.this.aeM.setTransactionSuccessful();
                        try {
                            if (b.this.aeL != null && b.this.aeL.isOpen()) {
                                b.this.aeL.endTransaction();
                            }
                            if (b.this.aeM != null && b.this.aeM.isOpen()) {
                                b.this.aeM.endTransaction();
                            }
                        } catch (Exception e8) {
                        }
                        c.this.j = null;
                        c.this.f = false;
                    }
                }.start();
                return;
            }
            this.f = false;
            c();
        }

        void b() {
            if (!f() || this.f) {
                return;
            }
            b.this.aeK.g();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(d dVar) {
        SQLiteDatabase sQLiteDatabase;
        SQLiteDatabase sQLiteDatabase2 = null;
        this.aeH = dVar;
        try {
            File file = new File(this.aeH.c(), "ofl_location.db");
            if (!file.exists()) {
                file.createNewFile();
            }
            sQLiteDatabase = SQLiteDatabase.openOrCreateDatabase(file, (SQLiteDatabase.CursorFactory) null);
        } catch (Exception e) {
            sQLiteDatabase = null;
        }
        this.aeL = sQLiteDatabase;
        if (this.aeL != null) {
            try {
                this.aeL.execSQL("CREATE TABLE IF NOT EXISTS AP (id LONG PRIMARY KEY,x DOUBLE,y DOUBLE,r INTEGER,cl DOUBLE,timestamp INTEGER, frequency INTEGER DEFAULT 0);");
                this.aeL.execSQL("CREATE TABLE IF NOT EXISTS CL (id LONG PRIMARY KEY,x DOUBLE,y DOUBLE,r INTEGER,cl DOUBLE,timestamp INTEGER, frequency INTEGER DEFAULT 0);");
            } catch (Exception e2) {
            }
        }
        try {
            File file2 = new File(this.aeH.c(), "ofl_statistics.db");
            if (!file2.exists()) {
                file2.createNewFile();
            }
            sQLiteDatabase2 = SQLiteDatabase.openOrCreateDatabase(file2, (SQLiteDatabase.CursorFactory) null);
        } catch (Exception e3) {
        }
        this.aeM = sQLiteDatabase2;
        if (this.aeM != null) {
            try {
                this.aeM.execSQL("CREATE TABLE IF NOT EXISTS AP (id LONG PRIMARY KEY, originid VARCHAR(15), frequency INTEGER DEFAULT 0);");
                this.aeM.execSQL("CREATE TABLE IF NOT EXISTS CL (id LONG PRIMARY KEY, originid VARCHAR(40), frequency INTEGER DEFAULT 0);");
            } catch (Exception e4) {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0091 A[LOOP:0: B:7:0x000a->B:28:0x0091, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0007 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int a(ArrayList<a> arrayList, double d) {
        boolean z;
        int i;
        double d2;
        if (arrayList.size() == 0) {
            return 0;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (arrayList.size() >= 3) {
                double d3 = 0.0d;
                double d4 = 0.0d;
                int i4 = 0;
                while (true) {
                    int i5 = i4;
                    if (i5 >= arrayList.size()) {
                        break;
                    }
                    d3 += arrayList.get(i5).a;
                    d4 += arrayList.get(i5).b;
                    i4 = i5 + 1;
                }
                double size = d3 / arrayList.size();
                double size2 = d4 / arrayList.size();
                double d5 = -1.0d;
                int i6 = -1;
                int i7 = 0;
                while (true) {
                    int i8 = i7;
                    i = i6;
                    d2 = d5;
                    if (i8 >= arrayList.size()) {
                        break;
                    }
                    d5 = b(size2, size, arrayList.get(i8).b, arrayList.get(i8).a);
                    if (d5 > d2) {
                        i6 = i8;
                    } else {
                        i6 = i;
                        d5 = d2;
                    }
                    i7 = i8 + 1;
                }
                if (d2 > d && i >= 0 && i < arrayList.size()) {
                    arrayList.remove(i);
                    z = true;
                    i2 = i3 + 1;
                    if (z) {
                        return i2;
                    }
                }
            }
            z = false;
            i2 = i3;
            if (z) {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:117:0x0340 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:135:0x032b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:144:0x017b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0180  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private BDLocation a(LinkedHashMap<String, Integer> linkedHashMap, BDLocation bDLocation, int i) {
        boolean z;
        Cursor cursor;
        Throwable th;
        boolean z2;
        double d;
        double d2;
        int i2;
        boolean z3;
        double d3;
        int i3;
        double d4;
        double d5;
        int min;
        this.aeS.setLength(0);
        double d6 = 0.0d;
        double d7 = 0.0d;
        if (bDLocation != null) {
            d7 = bDLocation.getLatitude();
            d6 = bDLocation.getLongitude();
            z = true;
        } else {
            z = false;
        }
        StringBuffer stringBuffer = new StringBuffer();
        boolean z4 = true;
        Iterator<Map.Entry<String, Integer>> it = linkedHashMap.entrySet().iterator();
        int i4 = 0;
        while (true) {
            int i5 = i4;
            boolean z5 = z4;
            if (i5 >= Math.min(linkedHashMap.size(), 30)) {
                break;
            }
            Map.Entry<String, Integer> next = it.next();
            String key = next.getKey();
            Integer value = next.getValue();
            if (value.intValue() < 0) {
                value = Integer.valueOf(-value.intValue());
            }
            Long encode3 = Jni.encode3(key);
            if (encode3 != null) {
                this.aeR.put(encode3, key);
                if (z5) {
                    z5 = false;
                } else {
                    stringBuffer.append(',');
                }
                this.aeQ.put(encode3, value);
                stringBuffer.append(encode3);
            }
            z4 = z5;
            i4 = i5 + 1;
        }
        Cursor cursor2 = null;
        try {
            cursor = this.aeL.rawQuery(String.format(Locale.US, "SELECT * FROM AP WHERE id IN (%s) AND timestamp+%d>%d;", stringBuffer, 7776000, Long.valueOf(System.currentTimeMillis() / 1000)), null);
        } catch (Exception e) {
            z2 = false;
            d = 0.0d;
            d2 = 0.0d;
            i2 = 0;
        } catch (Throwable th2) {
            cursor = null;
            th = th2;
        }
        if (cursor != null) {
            try {
                try {
                } catch (Throwable th3) {
                    th = th3;
                    if (cursor != null) {
                        try {
                            cursor.close();
                        } catch (Exception e2) {
                        }
                    }
                    throw th;
                }
            } catch (Exception e3) {
                cursor2 = cursor;
                z2 = false;
                d = 0.0d;
                d2 = 0.0d;
                i2 = 0;
            }
            if (cursor.moveToFirst()) {
                ArrayList<a> arrayList = new ArrayList<>();
                while (!cursor.isAfterLast()) {
                    Long valueOf = Long.valueOf(cursor.getLong(0));
                    double d8 = cursor.getDouble(1);
                    double d9 = cursor.getDouble(2);
                    int i6 = cursor.getInt(3);
                    double d10 = cursor.getDouble(4);
                    int i7 = cursor.getInt(5);
                    this.aeP.add(valueOf);
                    if (i7 + 604800 < System.currentTimeMillis() / 1000) {
                        if (this.aeS.length() > 0) {
                            this.aeS.append(",");
                        }
                        this.aeS.append(String.format(Locale.US, "(%d,\"%s\",%d)", valueOf, this.aeR.get(valueOf), 100000));
                    }
                    if (d10 <= 0.0d) {
                        cursor.moveToNext();
                    } else if (d8 <= 0.0d || d9 <= 0.0d || i6 <= 0 || i6 >= 1000) {
                        cursor.moveToNext();
                    } else if (!z || b(d7, d6, d9, d8) <= 10000.0d) {
                        arrayList.add(new a(d8, d9, Math.exp((Math.min(100, Math.max(30, this.aeQ.get(valueOf).intValue())) > 70 ? ((min - 70) / 30.0d) + 1.0d : ((min - 70) / 50.0d) + 1.0d) * Math.pow(Math.max(50.0d, i6), 0.6d) * (-0.065d))));
                        cursor.moveToNext();
                    } else {
                        cursor.moveToNext();
                    }
                }
                a(arrayList, 1000.0d);
                double d11 = 0.0d;
                double d12 = 0.0d;
                double d13 = 0.0d;
                int i8 = 0;
                while (i8 < arrayList.size()) {
                    a aVar = arrayList.get(i8);
                    if (aVar.c <= 0.0d) {
                        d4 = d13;
                        d5 = d12;
                    } else {
                        double d14 = (aVar.a * aVar.c) + d11;
                        double d15 = (aVar.b * aVar.c) + d12;
                        d4 = aVar.c + d13;
                        d5 = d15;
                        d11 = d14;
                    }
                    i8++;
                    d12 = d5;
                    d13 = d4;
                }
                if (d13 <= 0.0d || d11 <= 0.0d || d12 <= 0.0d) {
                    z3 = false;
                    d3 = 0.0d;
                    d2 = 0.0d;
                    i3 = 0;
                } else {
                    d2 = d11 / d13;
                    d = d12 / d13;
                    z2 = true;
                    float f = 0.0f;
                    int i9 = 0;
                    while (i9 < arrayList.size()) {
                        try {
                            i9++;
                            f = (float) (b(d2, d, arrayList.get(i9).a, arrayList.get(i9).b) + f);
                        } catch (Exception e4) {
                            cursor2 = cursor;
                            i2 = 0;
                            if (cursor2 != null) {
                                try {
                                    cursor2.close();
                                } catch (Exception e5) {
                                }
                            }
                            if (z2) {
                            }
                        }
                    }
                    int round = Math.round(f / arrayList.size());
                    if (round < 30) {
                        z3 = true;
                        d3 = d;
                        i3 = 30;
                    } else if (100 < round) {
                        z3 = true;
                        d3 = d;
                        i3 = 100;
                    } else {
                        z3 = true;
                        d3 = d;
                        i3 = round;
                    }
                }
                if (!z) {
                    try {
                        if (arrayList.size() <= 1) {
                            z3 = false;
                        }
                    } catch (Exception e6) {
                        z2 = z3;
                        i2 = i3;
                        d = d3;
                        cursor2 = cursor;
                        if (cursor2 != null) {
                        }
                        if (z2) {
                        }
                    }
                }
                if (arrayList.size() < i && (1.0d * arrayList.size()) / linkedHashMap.size() < 0.5d) {
                    z3 = false;
                }
                if (z && z3) {
                    if (b(d7, d6, d3, d2) > 10000.0d) {
                        z2 = false;
                        i2 = i3;
                        d = d3;
                        if (cursor != null) {
                            try {
                                cursor.close();
                            } catch (Exception e7) {
                            }
                        }
                        if (z2) {
                            BDLocation bDLocation2 = new BDLocation();
                            bDLocation2.setRadius(i2);
                            bDLocation2.setLatitude(d);
                            bDLocation2.setLongitude(d2);
                            bDLocation2.setNetworkLocationType("wf");
                            bDLocation2.setLocType(66);
                            return bDLocation2;
                        }
                        return null;
                    }
                }
                z2 = z3;
                i2 = i3;
                d = d3;
                if (cursor != null) {
                }
                if (z2) {
                }
            }
        }
        z2 = false;
        d = 0.0d;
        d2 = 0.0d;
        i2 = 0;
        if (cursor != null) {
        }
        if (z2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(BDLocation bDLocation, BDLocation bDLocation2, BDLocation bDLocation3, String str, Long l) {
        if (bDLocation == null || bDLocation.getLocType() != 161) {
            return;
        }
        if (bDLocation2 != null && bDLocation.getNetworkLocationType() != null && bDLocation.getNetworkLocationType().equals(Config.CELL_LOCATION) && b(bDLocation2.getLatitude(), bDLocation2.getLongitude(), bDLocation.getLatitude(), bDLocation.getLongitude()) > 300.0d) {
            String format = String.format(Locale.US, "UPDATE CL SET cl = 0 WHERE id = %d;", l);
            String format2 = String.format(Locale.US, "INSERT OR REPLACE INTO CL VALUES (%d,\"%s\",%d);", l, str, 100000);
            try {
                this.aeL.execSQL(format);
                this.aeM.execSQL(format2);
            } catch (Exception e) {
            }
        }
        if (bDLocation3 == null || bDLocation.getNetworkLocationType() == null || !bDLocation.getNetworkLocationType().equals("wf") || b(bDLocation3.getLatitude(), bDLocation3.getLongitude(), bDLocation.getLatitude(), bDLocation.getLongitude()) <= 100.0d) {
            return;
        }
        try {
            String format3 = String.format("UPDATE AP SET cl = 0 WHERE id In (%s);", this.aeN.toString());
            String format4 = String.format("INSERT OR REPLACE INTO AP VALUES %s;", this.aeO.toString());
            this.aeL.execSQL(format3);
            this.aeM.execSQL(format4);
        } catch (Exception e2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, Long l, BDLocation bDLocation) {
        if (str != null) {
            if (bDLocation != null) {
                try {
                    this.aeL.execSQL(String.format(Locale.US, "UPDATE CL SET frequency=frequency+1 WHERE id = %d;", l));
                } catch (Exception e) {
                }
            } else {
                String format = String.format(Locale.US, "INSERT OR IGNORE INTO CL VALUES (%d,\"%s\",0);", l, str);
                String format2 = String.format(Locale.US, "UPDATE CL SET frequency=frequency+1 WHERE id = %d;", l);
                try {
                    this.aeM.execSQL(format);
                    this.aeM.execSQL(format2);
                } catch (Exception e2) {
                }
            }
            if (this.p) {
                try {
                    this.aeM.execSQL(String.format(Locale.US, "INSERT OR IGNORE INTO CL VALUES (%d,\"%s\",%d);", l, str, 100000));
                } catch (Exception e3) {
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, String str3) {
        this.aeJ.a(str, str2, str3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LinkedHashMap<String, Integer> linkedHashMap) {
        boolean z;
        boolean z2;
        if (linkedHashMap == null || linkedHashMap.size() <= 0) {
            return;
        }
        this.aeN = new StringBuffer();
        this.aeO = new StringBuffer();
        StringBuffer stringBuffer = new StringBuffer();
        StringBuffer stringBuffer2 = new StringBuffer();
        if (this.aeQ != null && this.aeQ.keySet() != null) {
            boolean z3 = true;
            boolean z4 = true;
            for (Long l : this.aeQ.keySet()) {
                try {
                    if (this.aeP.contains(l)) {
                        if (z4) {
                            z4 = false;
                        } else {
                            this.aeN.append(',');
                            this.aeO.append(',');
                        }
                        this.aeN.append(l);
                        this.aeO.append('(').append(l).append(',').append('\"').append(this.aeR.get(l)).append('\"').append(',').append(100000).append(')');
                        z = z3;
                        z2 = z4;
                    } else {
                        String str = this.aeR.get(l);
                        if (z3) {
                            z3 = false;
                        } else {
                            stringBuffer.append(',');
                            stringBuffer2.append(',');
                        }
                        stringBuffer.append(l);
                        stringBuffer2.append('(').append(l).append(',').append('\"').append(str).append('\"').append(",0)");
                        z = z3;
                        z2 = z4;
                    }
                    z3 = z;
                    z4 = z2;
                } catch (Exception e) {
                    z3 = z3;
                    z4 = z4;
                }
            }
        }
        try {
            this.aeL.execSQL(String.format(Locale.US, "UPDATE AP SET frequency=frequency+1 WHERE id IN(%s)", this.aeN.toString()));
        } catch (Exception e2) {
        }
        if (this.aeS != null && this.aeS.length() > 0) {
            if (stringBuffer2.length() > 0) {
                stringBuffer2.append(",");
            }
            stringBuffer2.append(this.aeS);
        }
        try {
            String format = String.format("INSERT OR IGNORE INTO AP VALUES %s;", stringBuffer2.toString());
            String format2 = String.format("UPDATE AP SET frequency=frequency+1 WHERE id in (%s);", stringBuffer.toString());
            if (stringBuffer2.length() > 0) {
                this.aeM.execSQL(format);
            }
            if (stringBuffer.length() > 0) {
                this.aeM.execSQL(format2);
            }
        } catch (Exception e3) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String[] strArr) {
        this.aeH.tI().a(strArr);
    }

    private double b(double d, double d2, double d3, double d4) {
        double radians = Math.toRadians(d);
        Math.toRadians(d2);
        double radians2 = Math.toRadians(d3);
        Math.toRadians(d4);
        double radians3 = Math.toRadians(d4 - d2);
        double radians4 = Math.toRadians(d3 - d);
        double sin = Math.sin(radians4 / 2.0d);
        double sin2 = (Math.sin(radians3 / 2.0d) * Math.cos(radians) * Math.cos(radians2) * Math.sin(radians3 / 2.0d)) + (Math.sin(radians4 / 2.0d) * sin);
        return Math.atan2(Math.sqrt(sin2), Math.sqrt(1.0d - sin2)) * 2.0d * 6378137.0d;
    }

    private BDLocation c(Long l) {
        Cursor cursor;
        Throwable th;
        this.p = false;
        int i = 0;
        double d = 0.0d;
        double d2 = 0.0d;
        boolean z = false;
        if (this.aeI == null || !this.aeI.equals(l)) {
            Cursor cursor2 = null;
            try {
                try {
                    Cursor rawQuery = this.aeL.rawQuery(String.format(Locale.US, "SELECT * FROM CL WHERE id = %d AND timestamp + %d > %d;", l, 15552000, Long.valueOf(System.currentTimeMillis() / 1000)), null);
                    if (rawQuery != null) {
                        try {
                            if (rawQuery.moveToFirst() && rawQuery.getDouble(rawQuery.getColumnIndex(Config.CELL_LOCATION)) > 0.0d) {
                                z = true;
                                d = rawQuery.getDouble(rawQuery.getColumnIndex(Config.EVENT_HEAT_X));
                                d2 = rawQuery.getDouble(rawQuery.getColumnIndex("y"));
                                i = rawQuery.getInt(rawQuery.getColumnIndex("r"));
                                if (rawQuery.getInt(rawQuery.getColumnIndex(HttpConstants.TIMESTAMP)) + 604800 < System.currentTimeMillis() / 1000) {
                                    this.p = true;
                                }
                                if (i < 300) {
                                    i = 300;
                                } else if (2000 < i) {
                                    i = 2000;
                                }
                                this.c = d;
                                this.d = d2;
                                this.b = i;
                                this.aeI = l;
                            }
                        } catch (Throwable th2) {
                            cursor = rawQuery;
                            th = th2;
                            if (cursor != null) {
                                try {
                                    cursor.close();
                                } catch (Exception e) {
                                }
                            }
                            throw th;
                        }
                    }
                    if (rawQuery != null) {
                        try {
                            rawQuery.close();
                        } catch (Exception e2) {
                        }
                    }
                } catch (Exception e3) {
                    if (0 != 0) {
                        try {
                            cursor2.close();
                        } catch (Exception e4) {
                        }
                    }
                }
            } catch (Throwable th3) {
                cursor = null;
                th = th3;
            }
        } else {
            z = true;
            d = this.c;
            d2 = this.d;
            i = this.b;
        }
        if (z) {
            BDLocation bDLocation = new BDLocation();
            bDLocation.setRadius(i);
            bDLocation.setLatitude(d2);
            bDLocation.setLongitude(d);
            bDLocation.setNetworkLocationType(Config.CELL_LOCATION);
            bDLocation.setLocType(66);
            return bDLocation;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:57:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01eb  */
    /* JADX WARN: Type inference failed for: r4v10, types: [com.baidu.location.d.b$1] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Cursor a(e.a aVar) {
        BDLocation bDLocation;
        Double d;
        List<Poi> list;
        int i;
        String str;
        BDLocation bDLocation2 = new BDLocation();
        bDLocation2.setLocType(67);
        int i2 = 0;
        if (aVar.c) {
            String str2 = aVar.b;
            LinkedHashMap<String, Integer> linkedHashMap = aVar.afl;
            int i3 = aVar.f;
            BDLocation bDLocation3 = aVar.afk;
            BDLocation bDLocation4 = null;
            long j = Long.MIN_VALUE;
            if (str2 != null && this.aeL != null && (j = Jni.encode3(str2)) != null) {
                bDLocation4 = c(j);
            }
            BDLocation bDLocation5 = null;
            if (linkedHashMap != null && linkedHashMap.size() > 0 && this.aeL != null) {
                this.aeQ.clear();
                this.aeP.clear();
                this.aeR.clear();
                bDLocation5 = a(linkedHashMap, bDLocation4, i3);
            }
            Double d2 = null;
            Double d3 = null;
            Double d4 = null;
            Double d5 = null;
            if (bDLocation4 != null) {
                d2 = Double.valueOf(bDLocation4.getLongitude());
                d3 = Double.valueOf(bDLocation4.getLatitude());
                double[] coorEncrypt = Jni.coorEncrypt(bDLocation4.getLongitude(), bDLocation4.getLatitude(), BDLocation.BDLOCATION_BD09LL_TO_GCJ02);
                bDLocation4.setCoorType("gcj");
                bDLocation4.setLatitude(coorEncrypt[1]);
                bDLocation4.setLongitude(coorEncrypt[0]);
                bDLocation4.setNetworkLocationType(Config.CELL_LOCATION);
            }
            if (bDLocation5 != null) {
                d4 = Double.valueOf(bDLocation5.getLongitude());
                d5 = Double.valueOf(bDLocation5.getLatitude());
                double[] coorEncrypt2 = Jni.coorEncrypt(bDLocation5.getLongitude(), bDLocation5.getLatitude(), BDLocation.BDLOCATION_BD09LL_TO_GCJ02);
                bDLocation5.setCoorType("gcj");
                bDLocation5.setLatitude(coorEncrypt2[1]);
                bDLocation5.setLongitude(coorEncrypt2[0]);
                bDLocation5.setNetworkLocationType("wf");
            }
            if (bDLocation4 != null && bDLocation5 == null) {
                i2 = 1;
            } else if (bDLocation4 == null && bDLocation5 != null) {
                i2 = 2;
            } else if (bDLocation4 != null && bDLocation5 != null) {
                i2 = 4;
            }
            boolean z = aVar.f > 0;
            boolean z2 = linkedHashMap == null || linkedHashMap.size() <= 0;
            if (z) {
                if (bDLocation5 != null) {
                    d = d4;
                    bDLocation = bDLocation5;
                } else {
                    if (z2 && bDLocation4 != null) {
                        d5 = d3;
                        bDLocation = bDLocation4;
                        d = d2;
                    }
                    d5 = null;
                    d = null;
                    bDLocation = bDLocation2;
                }
                if (aVar.e && this.aeH.tI().l() && d5 != null && d != null) {
                    bDLocation.setAddr(this.aeH.tH().d(d.doubleValue(), d5.doubleValue()));
                }
                if (z && aVar.e && bDLocation.getAddrStr() == null) {
                    d5 = null;
                    d = null;
                    i2 = 0;
                    bDLocation = bDLocation2;
                }
                if ((aVar.d && !aVar.h) || d5 == null || d == null) {
                    list = null;
                } else {
                    List<Poi> e = this.aeH.tH().e(d.doubleValue(), d5.doubleValue());
                    if (aVar.d) {
                        bDLocation.setPoiList(e);
                    }
                    list = e;
                }
                if (z || !aVar.d || (list != null && list.size() > 0)) {
                    i = i2;
                } else {
                    i = 0;
                    bDLocation = bDLocation2;
                }
                str = null;
                if (aVar.h && list != null && list.size() > 0) {
                    str = String.format(Locale.CHINA, "在%s附近", list.get(0).getName());
                    bDLocation.setLocationDescribe(str);
                }
                if (z && aVar.h && str == null) {
                    i = 0;
                    bDLocation = bDLocation2;
                }
                StringBuffer stringBuffer = new StringBuffer();
                String str3 = null;
                if (aVar.a != null) {
                    stringBuffer.append(aVar.a);
                    stringBuffer.append(e.a(bDLocation5, bDLocation4, aVar));
                    stringBuffer.append(e.b(bDLocation, i));
                    str3 = stringBuffer.toString();
                }
                new C0086b(str2, j, bDLocation4, bDLocation5, bDLocation3, str3, linkedHashMap) { // from class: com.baidu.location.d.b.1
                }.start();
            } else {
                if (bDLocation5 != null) {
                    d = d4;
                    bDLocation = bDLocation5;
                } else {
                    if (bDLocation4 != null) {
                        d5 = d3;
                        bDLocation = bDLocation4;
                        d = d2;
                    }
                    d5 = null;
                    d = null;
                    bDLocation = bDLocation2;
                }
                if (aVar.e) {
                    bDLocation.setAddr(this.aeH.tH().d(d.doubleValue(), d5.doubleValue()));
                }
                if (z) {
                    d5 = null;
                    d = null;
                    i2 = 0;
                    bDLocation = bDLocation2;
                }
                if (aVar.d) {
                }
                List<Poi> e2 = this.aeH.tH().e(d.doubleValue(), d5.doubleValue());
                if (aVar.d) {
                }
                list = e2;
                if (z) {
                }
                i = i2;
                str = null;
                if (aVar.h) {
                    str = String.format(Locale.CHINA, "在%s附近", list.get(0).getName());
                    bDLocation.setLocationDescribe(str);
                }
                if (z) {
                    i = 0;
                    bDLocation = bDLocation2;
                }
                StringBuffer stringBuffer2 = new StringBuffer();
                String str32 = null;
                if (aVar.a != null) {
                }
                new C0086b(str2, j, bDLocation4, bDLocation5, bDLocation3, str32, linkedHashMap) { // from class: com.baidu.location.d.b.1
                }.start();
            }
        } else {
            bDLocation = bDLocation2;
        }
        return e.f(bDLocation);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        this.aeK.b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SQLiteDatabase tB() {
        return this.aeM;
    }
}
