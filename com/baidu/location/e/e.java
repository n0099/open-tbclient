package com.baidu.location.e;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.location.BDLocation;
import com.baidu.location.Jni;
import com.baidu.location.Poi;
import com.baidu.location.e.j;
import com.baidu.tbadk.TbConfig;
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
/* loaded from: classes.dex */
public final class e {
    private final d HX;
    private double HY;
    private Long HZ;
    private final SQLiteDatabase Ic;
    private final SQLiteDatabase Id;
    private int b;
    private double c;
    private boolean p = false;
    private final c Ia = new c(this, true);
    private final c Ib = new c(this, false);
    private StringBuffer Ij = new StringBuffer();
    private StringBuffer Ie = null;
    private StringBuffer If = null;
    private HashSet<Long> Ig = new HashSet<>();
    private ConcurrentHashMap<Long, Integer> Ih = new ConcurrentHashMap<>();
    private ConcurrentHashMap<Long, String> Ii = new ConcurrentHashMap<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class a {
        double a;
        double b;
        double c;

        private a(double d, double d2, double d3) {
            this.a = d;
            this.b = d2;
            this.c = d3;
        }

        /* synthetic */ a(double d, double d2, double d3, f fVar) {
            this(d, d2, d3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends Thread {
        private BDLocation FO;
        private Long Ik;
        private BDLocation Il;
        private BDLocation Im;
        private LinkedHashMap<String, Integer> In;
        private String a;
        private String g;

        private b(String str, Long l, BDLocation bDLocation, BDLocation bDLocation2, BDLocation bDLocation3, String str2, LinkedHashMap<String, Integer> linkedHashMap) {
            this.a = str;
            this.Ik = l;
            this.Il = bDLocation;
            this.FO = bDLocation2;
            this.Im = bDLocation3;
            this.g = str2;
            this.In = linkedHashMap;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ b(e eVar, String str, Long l, BDLocation bDLocation, BDLocation bDLocation2, BDLocation bDLocation3, String str2, LinkedHashMap linkedHashMap, f fVar) {
            this(str, l, bDLocation, bDLocation2, bDLocation3, str2, linkedHashMap);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                e.this.a(this.a, this.Ik, this.Il);
                e.this.Ie = null;
                e.this.If = null;
                e.this.a(this.In);
                e.this.a(this.Im, this.Il, this.FO, this.a, this.Ik);
                if (this.g != null) {
                    e.this.HX.lR().a(this.g);
                }
            } catch (Exception e) {
            }
            this.In = null;
            this.a = null;
            this.g = null;
            this.Ik = null;
            this.Il = null;
            this.FO = null;
            this.Im = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class c extends com.baidu.location.h.f {
        private e Ip;
        private String b;
        private final String c;
        private String d;
        private boolean f = false;
        private int p = 0;
        private long Iq = -1;
        private long Ir = -1;
        private long Is = -1;
        private long t = -1;

        c(e eVar, boolean z) {
            this.Ip = eVar;
            if (z) {
                this.c = "load";
            } else {
                this.c = "update";
            }
            this.Jx = new HashMap();
            this.b = d.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(String str, String str2, String str3) {
            this.d = str3;
            this.b = String.format("http://%s/%s", str, str2);
            e();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c() {
            this.p++;
            this.Iq = System.currentTimeMillis();
        }

        private boolean f() {
            if (this.p < 2) {
                return true;
            }
            if (this.Iq + 43200000 < System.currentTimeMillis()) {
                this.p = 0;
                this.Iq = -1L;
                return true;
            }
            return false;
        }

        private void g() {
            this.d = null;
            if (!l()) {
                this.d = i();
            } else if (this.Ir == -1 || this.Ir + 86400000 <= System.currentTimeMillis()) {
                this.d = h();
            }
            if (this.d == null && (this.Is == -1 || this.Is + 86400000 <= System.currentTimeMillis())) {
                if (e.this.HX.lS().a()) {
                    this.d = j();
                } else {
                    this.d = k();
                }
            }
            if (this.d != null) {
                e();
            }
        }

        private String h() {
            JSONObject jSONObject;
            try {
                jSONObject = new JSONObject();
                jSONObject.put("type", "0");
                jSONObject.put(SocialConstants.PARAM_CUID, com.baidu.location.h.c.mr().b);
                jSONObject.put("ver", "1");
                jSONObject.put("prod", com.baidu.location.h.c.d + ":" + com.baidu.location.h.c.c);
            } catch (Exception e) {
                jSONObject = null;
            }
            if (jSONObject != null) {
                return Jni.encodeOfflineLocationUpdateRequest(jSONObject.toString());
            }
            return null;
        }

        /* JADX WARN: Removed duplicated region for block: B:102:0x00da A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:106:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0068  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x0097  */
        /* JADX WARN: Removed duplicated region for block: B:84:0x0164 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:86:0x015f A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:90:0x005d A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:92:0x0148 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:94:0x0062 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:98:0x014d A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private String i() {
            Cursor cursor;
            JSONObject jSONObject;
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
                        cursor = e.this.Id.rawQuery(String.format("SELECT * FROM %s WHERE frequency>%d ORDER BY frequency DESC LIMIT %d;", "CL", 5, 50), null);
                    } catch (Exception e) {
                        cursor = null;
                        cursor2 = null;
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
                    } catch (Throwable th) {
                        th = th;
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
                        cursor2 = e.this.Id.rawQuery(String.format("SELECT * FROM %s WHERE frequency>%d ORDER BY frequency DESC LIMIT %d;", "AP", 5, 50), null);
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
                            } catch (Throwable th2) {
                                th = th2;
                                cursor3 = cursor2;
                                if (cursor3 != null) {
                                }
                                if (cursor != null) {
                                }
                                throw th;
                            }
                        }
                        jSONObject.put("type", "1");
                        jSONObject.put(SocialConstants.PARAM_CUID, com.baidu.location.h.c.mr().b);
                        jSONObject.put("ver", "1");
                        jSONObject.put("prod", com.baidu.location.h.c.d + ":" + com.baidu.location.h.c.c);
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
                            if (jSONObject2 != null || jSONObject2.has("model") || (this.t != -1 && this.t + 86400000 >= System.currentTimeMillis())) {
                                str = null;
                            } else {
                                String encodeOfflineLocationUpdateRequest = Jni.encodeOfflineLocationUpdateRequest(jSONObject2.toString());
                                this.t = System.currentTimeMillis();
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
                cursor2 = e.this.Id.rawQuery(String.format("SELECT * FROM %s WHERE frequency>%d ORDER BY frequency DESC LIMIT %d;", "AP", 5, 50), null);
                if (cursor2 != null) {
                }
                jSONObject.put("type", "1");
                jSONObject.put(SocialConstants.PARAM_CUID, com.baidu.location.h.c.mr().b);
                jSONObject.put("ver", "1");
                jSONObject.put("prod", com.baidu.location.h.c.d + ":" + com.baidu.location.h.c.c);
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
            } catch (Throwable th3) {
                th = th3;
                cursor = null;
            }
        }

        private String j() {
            JSONObject jSONObject;
            try {
                jSONObject = new JSONObject();
                try {
                    jSONObject.put("type", "2");
                    jSONObject.put("ver", "1");
                    jSONObject.put(SocialConstants.PARAM_CUID, com.baidu.location.h.c.mr().b);
                    jSONObject.put("prod", com.baidu.location.h.c.d + ":" + com.baidu.location.h.c.c);
                    this.Is = System.currentTimeMillis();
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
                JSONObject b = e.this.HX.lS().b();
                if (b != null) {
                    jSONObject = new JSONObject();
                    try {
                        jSONObject.put("type", TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE);
                        jSONObject.put("ver", "1");
                        jSONObject.put(SocialConstants.PARAM_CUID, com.baidu.location.h.c.mr().b);
                        jSONObject.put("prod", com.baidu.location.h.c.d + ":" + com.baidu.location.h.c.c);
                        jSONObject.put("rgc", b);
                        this.Is = System.currentTimeMillis();
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

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0039, code lost:
            if (r1.getInt(0) != 0) goto L17;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private boolean l() {
            Cursor cursor;
            Cursor cursor2 = null;
            boolean z = true;
            try {
                cursor = e.this.Ic.rawQuery("SELECT COUNT(*) FROM AP;", null);
                try {
                    cursor2 = e.this.Ic.rawQuery("SELECT COUNT(*) FROM CL", null);
                    if (cursor != null && cursor.moveToFirst() && cursor2 != null && cursor2.moveToFirst()) {
                        if (cursor.getInt(0) == 0) {
                        }
                        z = false;
                    }
                    if (cursor != null) {
                        try {
                            cursor.close();
                        } catch (Exception e) {
                        }
                    }
                    if (cursor2 != null) {
                        try {
                            cursor2.close();
                        } catch (Exception e2) {
                        }
                    }
                } catch (Exception e3) {
                    if (cursor != null) {
                        try {
                            cursor.close();
                        } catch (Exception e4) {
                        }
                    }
                    if (cursor2 != null) {
                        try {
                            cursor2.close();
                        } catch (Exception e5) {
                        }
                    }
                    return z;
                } catch (Throwable th) {
                    th = th;
                    if (cursor != null) {
                        try {
                            cursor.close();
                        } catch (Exception e6) {
                        }
                    }
                    if (cursor2 != null) {
                        try {
                            cursor2.close();
                        } catch (Exception e7) {
                        }
                    }
                    throw th;
                }
            } catch (Exception e8) {
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
                cursor = null;
            }
            return z;
        }

        @Override // com.baidu.location.h.f
        public void a() {
            this.f = true;
            this.h = this.b;
            this.Jx.clear();
            this.Jx.put("qt", this.c);
            this.Jx.put("req", this.d);
        }

        @Override // com.baidu.location.h.f
        public void a(boolean z) {
            if (z && this.j != null) {
                new g(this).start();
                return;
            }
            this.f = false;
            c();
        }

        void b() {
            if (!f() || this.f) {
                return;
            }
            e.this.Ib.g();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        SQLiteDatabase sQLiteDatabase;
        SQLiteDatabase sQLiteDatabase2 = null;
        this.HX = dVar;
        try {
            File file = new File(this.HX.lQ(), "ofl_location.db");
            if (!file.exists()) {
                file.createNewFile();
            }
            sQLiteDatabase = SQLiteDatabase.openOrCreateDatabase(file, (SQLiteDatabase.CursorFactory) null);
        } catch (Exception e) {
            sQLiteDatabase = null;
        }
        this.Ic = sQLiteDatabase;
        if (this.Ic != null) {
            try {
                this.Ic.execSQL("CREATE TABLE IF NOT EXISTS AP (id LONG PRIMARY KEY,x DOUBLE,y DOUBLE,r INTEGER,cl DOUBLE,timestamp INTEGER, frequency INTEGER DEFAULT 0);");
                this.Ic.execSQL("CREATE TABLE IF NOT EXISTS CL (id LONG PRIMARY KEY,x DOUBLE,y DOUBLE,r INTEGER,cl DOUBLE,timestamp INTEGER, frequency INTEGER DEFAULT 0);");
            } catch (Exception e2) {
            }
        }
        try {
            File file2 = new File(this.HX.lQ(), "ofl_statistics.db");
            if (!file2.exists()) {
                file2.createNewFile();
            }
            sQLiteDatabase2 = SQLiteDatabase.openOrCreateDatabase(file2, (SQLiteDatabase.CursorFactory) null);
        } catch (Exception e3) {
        }
        this.Id = sQLiteDatabase2;
        if (this.Id != null) {
            try {
                this.Id.execSQL("CREATE TABLE IF NOT EXISTS AP (id LONG PRIMARY KEY, originid VARCHAR(15), frequency INTEGER DEFAULT 0);");
                this.Id.execSQL("CREATE TABLE IF NOT EXISTS CL (id LONG PRIMARY KEY, originid VARCHAR(40), frequency INTEGER DEFAULT 0);");
            } catch (Exception e4) {
            }
        }
    }

    private double a(double d, double d2, double d3, double d4) {
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

    /* JADX WARN: Removed duplicated region for block: B:28:0x0098 A[LOOP:0: B:7:0x000a->B:28:0x0098, LOOP_END] */
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
                int i4 = 0;
                double d4 = 0.0d;
                while (i4 < arrayList.size()) {
                    double d5 = arrayList.get(i4).a + d4;
                    i4++;
                    d3 = arrayList.get(i4).b + d3;
                    d4 = d5;
                }
                double size = d4 / arrayList.size();
                double size2 = d3 / arrayList.size();
                double d6 = -1.0d;
                int i5 = -1;
                int i6 = 0;
                while (true) {
                    int i7 = i6;
                    i = i5;
                    d2 = d6;
                    if (i7 >= arrayList.size()) {
                        break;
                    }
                    d6 = a(size2, size, arrayList.get(i7).b, arrayList.get(i7).a);
                    if (d6 > d2) {
                        i5 = i7;
                    } else {
                        i5 = i;
                        d6 = d2;
                    }
                    i6 = i7 + 1;
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

    /* JADX WARN: Removed duplicated region for block: B:110:0x0331  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0355 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:140:0x033b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0178 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x017d  */
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
        double d4;
        int i3;
        boolean z4;
        double d5;
        double d6;
        double d7;
        int min;
        this.Ij.setLength(0);
        double d8 = 0.0d;
        double d9 = 0.0d;
        if (bDLocation != null) {
            d9 = bDLocation.getLatitude();
            d8 = bDLocation.getLongitude();
            z = true;
        } else {
            z = false;
        }
        StringBuffer stringBuffer = new StringBuffer();
        boolean z5 = true;
        Iterator<Map.Entry<String, Integer>> it = linkedHashMap.entrySet().iterator();
        int i4 = 0;
        while (true) {
            int i5 = i4;
            boolean z6 = z5;
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
                this.Ii.put(encode3, key);
                if (z6) {
                    z6 = false;
                } else {
                    stringBuffer.append(',');
                }
                this.Ih.put(encode3, value);
                stringBuffer.append(encode3);
            }
            z5 = z6;
            i4 = i5 + 1;
        }
        Cursor cursor2 = null;
        try {
            cursor = this.Ic.rawQuery(String.format(Locale.US, "SELECT * FROM AP WHERE id IN (%s) AND timestamp+%d>%d;", stringBuffer, 7776000, Long.valueOf(System.currentTimeMillis() / 1000)), null);
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
                } catch (Exception e2) {
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
                        double d10 = cursor.getDouble(1);
                        double d11 = cursor.getDouble(2);
                        int i6 = cursor.getInt(3);
                        double d12 = cursor.getDouble(4);
                        int i7 = cursor.getInt(5);
                        this.Ig.add(valueOf);
                        if (i7 + 604800 < System.currentTimeMillis() / 1000) {
                            if (this.Ij.length() > 0) {
                                this.Ij.append(",");
                            }
                            this.Ij.append(String.format(Locale.US, "(%d,\"%s\",%d)", valueOf, this.Ii.get(valueOf), 100000));
                        }
                        if (d12 <= 0.0d) {
                            cursor.moveToNext();
                        } else if (d10 <= 0.0d || d11 <= 0.0d || i6 <= 0 || i6 >= 1000) {
                            cursor.moveToNext();
                        } else if (!z || a(d9, d8, d11, d10) <= 10000.0d) {
                            arrayList.add(new a(d10, d11, Math.exp((Math.min(100, Math.max(30, this.Ih.get(valueOf).intValue())) > 70 ? 1.0d + ((min - 70) / 30.0d) : 1.0d + ((min - 70) / 50.0d)) * Math.pow(Math.max(50.0d, i6), 0.6d) * (-0.065d)), null));
                            cursor.moveToNext();
                        } else {
                            cursor.moveToNext();
                        }
                    }
                    a(arrayList, 1000.0d);
                    double d13 = 0.0d;
                    double d14 = 0.0d;
                    double d15 = 0.0d;
                    int i8 = 0;
                    while (i8 < arrayList.size()) {
                        a aVar = arrayList.get(i8);
                        if (aVar.c <= 0.0d) {
                            d6 = d14;
                            d7 = d13;
                            d5 = d15;
                        } else {
                            double d16 = (aVar.a * aVar.c) + d13;
                            double d17 = d14 + (aVar.b * aVar.c);
                            d5 = aVar.c + d15;
                            d6 = d17;
                            d7 = d16;
                        }
                        i8++;
                        double d18 = d5;
                        d13 = d7;
                        d14 = d6;
                        d15 = d18;
                    }
                    if (d15 <= 0.0d || d13 <= 0.0d || d14 <= 0.0d) {
                        z3 = false;
                        d3 = 0.0d;
                        d4 = 0.0d;
                        i3 = 0;
                    } else {
                        d2 = d13 / d15;
                        d = d14 / d15;
                        int i9 = 0;
                        float f = 0.0f;
                        while (i9 < arrayList.size()) {
                            try {
                                i9++;
                                f = (float) (a(d2, d, arrayList.get(i9).a, arrayList.get(i9).b) + f);
                            } catch (Exception e3) {
                                cursor2 = cursor;
                                z2 = true;
                                i2 = 0;
                                if (cursor2 != null) {
                                    try {
                                        cursor2.close();
                                    } catch (Exception e4) {
                                    }
                                }
                                if (z2) {
                                }
                            }
                        }
                        int round = Math.round(f / arrayList.size());
                        if (round < 30) {
                            z3 = true;
                            i3 = 30;
                            d3 = d;
                            d4 = d2;
                        } else if (100 < round) {
                            z3 = true;
                            i3 = 100;
                            d3 = d;
                            d4 = d2;
                        } else {
                            z3 = true;
                            i3 = round;
                            d3 = d;
                            d4 = d2;
                        }
                    }
                    if (!z) {
                        try {
                            if (arrayList.size() <= 1) {
                                z3 = false;
                            }
                        } catch (Exception e5) {
                            z2 = z3;
                            i2 = i3;
                            cursor2 = cursor;
                            d = d3;
                            d2 = d4;
                            if (cursor2 != null) {
                            }
                            if (z2) {
                            }
                        }
                    }
                    if (arrayList.size() < i) {
                        if ((1.0d * arrayList.size()) / linkedHashMap.size() < 0.5d) {
                            z4 = false;
                            if (z && z4) {
                                try {
                                } catch (Exception e6) {
                                    cursor2 = cursor;
                                    z2 = z4;
                                    i2 = i3;
                                    d = d3;
                                    d2 = d4;
                                    if (cursor2 != null) {
                                    }
                                    if (z2) {
                                    }
                                }
                                if (a(d9, d8, d3, d4) > 10000.0d) {
                                    z2 = false;
                                    i2 = i3;
                                    d = d3;
                                    d2 = d4;
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
                            z2 = z4;
                            i2 = i3;
                            d = d3;
                            d2 = d4;
                            if (cursor != null) {
                            }
                            if (z2) {
                            }
                        }
                    }
                    z4 = z3;
                    if (z) {
                        if (a(d9, d8, d3, d4) > 10000.0d) {
                        }
                    }
                    z2 = z4;
                    i2 = i3;
                    d = d3;
                    d2 = d4;
                    if (cursor != null) {
                    }
                    if (z2) {
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                if (cursor != null) {
                    try {
                        cursor.close();
                    } catch (Exception e8) {
                    }
                }
                throw th;
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
        if (bDLocation2 != null && bDLocation.getNetworkLocationType() != null && bDLocation.getNetworkLocationType().equals("cl") && a(bDLocation2.getLatitude(), bDLocation2.getLongitude(), bDLocation.getLatitude(), bDLocation.getLongitude()) > 300.0d) {
            String format = String.format(Locale.US, "UPDATE CL SET cl = 0 WHERE id = %d;", l);
            String format2 = String.format(Locale.US, "INSERT OR REPLACE INTO CL VALUES (%d,\"%s\",%d);", l, str, 100000);
            try {
                this.Ic.execSQL(format);
                this.Id.execSQL(format2);
            } catch (Exception e) {
            }
        }
        if (bDLocation3 == null || bDLocation.getNetworkLocationType() == null || !bDLocation.getNetworkLocationType().equals("wf") || a(bDLocation3.getLatitude(), bDLocation3.getLongitude(), bDLocation.getLatitude(), bDLocation.getLongitude()) <= 100.0d) {
            return;
        }
        try {
            String format3 = String.format("UPDATE AP SET cl = 0 WHERE id In (%s);", this.Ie.toString());
            String format4 = String.format("INSERT OR REPLACE INTO AP VALUES %s;", this.If.toString());
            this.Ic.execSQL(format3);
            this.Id.execSQL(format4);
        } catch (Exception e2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, Long l, BDLocation bDLocation) {
        if (str != null) {
            if (bDLocation != null) {
                try {
                    this.Ic.execSQL(String.format(Locale.US, "UPDATE CL SET frequency=frequency+1 WHERE id = %d;", l));
                } catch (Exception e) {
                }
            } else {
                String format = String.format(Locale.US, "INSERT OR IGNORE INTO CL VALUES (%d,\"%s\",0);", l, str);
                String format2 = String.format(Locale.US, "UPDATE CL SET frequency=frequency+1 WHERE id = %d;", l);
                try {
                    this.Id.execSQL(format);
                    this.Id.execSQL(format2);
                } catch (Exception e2) {
                }
            }
            if (this.p) {
                try {
                    this.Id.execSQL(String.format(Locale.US, "INSERT OR IGNORE INTO CL VALUES (%d,\"%s\",%d);", l, str, 100000));
                } catch (Exception e3) {
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, String str3) {
        this.Ia.a(str, str2, str3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LinkedHashMap<String, Integer> linkedHashMap) {
        boolean z;
        boolean z2;
        if (linkedHashMap == null || linkedHashMap.size() <= 0) {
            return;
        }
        this.Ie = new StringBuffer();
        this.If = new StringBuffer();
        StringBuffer stringBuffer = new StringBuffer();
        StringBuffer stringBuffer2 = new StringBuffer();
        if (this.Ih != null && this.Ih.keySet() != null) {
            boolean z3 = true;
            boolean z4 = true;
            for (Long l : this.Ih.keySet()) {
                try {
                    if (this.Ig.contains(l)) {
                        if (z4) {
                            z4 = false;
                        } else {
                            this.Ie.append(',');
                            this.If.append(',');
                        }
                        this.Ie.append(l);
                        this.If.append('(').append(l).append(',').append('\"').append(this.Ii.get(l)).append('\"').append(',').append(100000).append(')');
                        z = z3;
                        z2 = z4;
                    } else {
                        String str = this.Ii.get(l);
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
            this.Ic.execSQL(String.format(Locale.US, "UPDATE AP SET frequency=frequency+1 WHERE id IN(%s)", this.Ie.toString()));
        } catch (Exception e2) {
        }
        if (this.Ij != null && this.Ij.length() > 0) {
            if (stringBuffer2.length() > 0) {
                stringBuffer2.append(",");
            }
            stringBuffer2.append(this.Ij);
        }
        try {
            String format = String.format("INSERT OR IGNORE INTO AP VALUES %s;", stringBuffer2.toString());
            String format2 = String.format("UPDATE AP SET frequency=frequency+1 WHERE id in (%s);", stringBuffer.toString());
            if (stringBuffer2.length() > 0) {
                this.Id.execSQL(format);
            }
            if (stringBuffer.length() > 0) {
                this.Id.execSQL(format2);
            }
        } catch (Exception e3) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String[] strArr) {
        this.HX.lT().a(strArr);
    }

    private BDLocation c(Long l) {
        Cursor cursor;
        Throwable th;
        this.p = false;
        int i = 0;
        double d = 0.0d;
        double d2 = 0.0d;
        boolean z = false;
        if (this.HZ == null || !this.HZ.equals(l)) {
            Cursor cursor2 = null;
            try {
                try {
                    Cursor rawQuery = this.Ic.rawQuery(String.format(Locale.US, "SELECT * FROM CL WHERE id = %d AND timestamp + %d > %d;", l, 15552000, Long.valueOf(System.currentTimeMillis() / 1000)), null);
                    if (rawQuery != null) {
                        try {
                            if (rawQuery.moveToFirst() && rawQuery.getDouble(rawQuery.getColumnIndex("cl")) > 0.0d) {
                                z = true;
                                d = rawQuery.getDouble(rawQuery.getColumnIndex("x"));
                                d2 = rawQuery.getDouble(rawQuery.getColumnIndex("y"));
                                i = rawQuery.getInt(rawQuery.getColumnIndex("r"));
                                if (rawQuery.getInt(rawQuery.getColumnIndex("timestamp")) + 604800 < System.currentTimeMillis() / 1000) {
                                    this.p = true;
                                }
                                if (i < 300) {
                                    i = 300;
                                } else if (2000 < i) {
                                    i = 2000;
                                }
                                this.c = d;
                                this.HY = d2;
                                this.b = i;
                                this.HZ = l;
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
                } catch (Throwable th3) {
                    cursor = null;
                    th = th3;
                }
            } catch (Exception e3) {
                if (0 != 0) {
                    try {
                        cursor2.close();
                    } catch (Exception e4) {
                    }
                }
            }
        } else {
            z = true;
            d = this.c;
            d2 = this.HY;
            i = this.b;
        }
        if (z) {
            BDLocation bDLocation = new BDLocation();
            bDLocation.setRadius(i);
            bDLocation.setLatitude(d2);
            bDLocation.setLongitude(d);
            bDLocation.setNetworkLocationType("cl");
            bDLocation.setLocType(66);
            return bDLocation;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:57:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01da  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Cursor a(j.a aVar) {
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
            LinkedHashMap<String, Integer> linkedHashMap = aVar.IB;
            int i3 = aVar.f;
            BDLocation bDLocation3 = aVar.IA;
            BDLocation bDLocation4 = null;
            long j = Long.MIN_VALUE;
            if (str2 != null && this.Ic != null && (j = Jni.encode3(str2)) != null) {
                bDLocation4 = c(j);
            }
            BDLocation bDLocation5 = null;
            if (linkedHashMap != null && linkedHashMap.size() > 0 && this.Ic != null) {
                this.Ih.clear();
                this.Ig.clear();
                this.Ii.clear();
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
                bDLocation4.setNetworkLocationType("cl");
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
                if (aVar.e && this.HX.lT().l() && d5 != null && d != null) {
                    bDLocation.setAddr(this.HX.lS().a(d.doubleValue(), d5.doubleValue()));
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
                    List<Poi> b2 = this.HX.lS().b(d.doubleValue(), d5.doubleValue());
                    if (aVar.d) {
                        bDLocation.setPoiList(b2);
                    }
                    list = b2;
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
                    stringBuffer.append(j.a(bDLocation5, bDLocation4, aVar));
                    stringBuffer.append(j.b(bDLocation, i));
                    str3 = stringBuffer.toString();
                }
                new f(this, str2, j, bDLocation4, bDLocation5, bDLocation3, str3, linkedHashMap).start();
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
                    bDLocation.setAddr(this.HX.lS().a(d.doubleValue(), d5.doubleValue()));
                }
                if (z) {
                    d5 = null;
                    d = null;
                    i2 = 0;
                    bDLocation = bDLocation2;
                }
                if (aVar.d) {
                }
                List<Poi> b22 = this.HX.lS().b(d.doubleValue(), d5.doubleValue());
                if (aVar.d) {
                }
                list = b22;
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
                new f(this, str2, j, bDLocation4, bDLocation5, bDLocation3, str32, linkedHashMap).start();
            }
        } else {
            bDLocation = bDLocation2;
        }
        return j.c(bDLocation);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SQLiteDatabase a() {
        return this.Id;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        this.Ib.b();
    }
}
