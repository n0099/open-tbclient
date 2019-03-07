package com.baidu.location.d;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.android.bbalbs.common.security.Base64;
import com.baidu.appsearchlib.Info;
import com.baidu.location.Address;
import com.baidu.location.Jni;
import com.baidu.location.Poi;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.meizu.cloud.pushsdk.notification.model.TimeDisplaySetting;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class g {
    private static final double[] b = {45.0d, 135.0d, 225.0d, 315.0d};
    private final d a;
    private final int c;
    private final SQLiteDatabase d;
    private int e = -1;
    private int f = -1;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class a {
        private double a;
        private double b;

        private a(double d, double d2) {
            this.a = d;
            this.b = d2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public enum b {
        AREA("RGCAREA", CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA, "addrv", 0, 1000) { // from class: com.baidu.location.d.g.b.1
            @Override // com.baidu.location.d.g.b
            List<String> a(JSONObject jSONObject, String str, int i) {
                int i2 = 0;
                Iterator<String> keys = jSONObject.keys();
                StringBuffer stringBuffer = new StringBuffer();
                StringBuffer stringBuffer2 = new StringBuffer();
                ArrayList arrayList = new ArrayList();
                while (true) {
                    int i3 = i2;
                    if (!keys.hasNext()) {
                        break;
                    }
                    String next = keys.next();
                    try {
                        JSONObject jSONObject2 = jSONObject.getJSONObject(next);
                        String string = jSONObject2.has("cy") ? jSONObject2.getString("cy") : null;
                        String string2 = jSONObject2.has("cyc") ? jSONObject2.getString("cyc") : null;
                        String string3 = jSONObject2.has("prov") ? jSONObject2.getString("prov") : null;
                        String string4 = jSONObject2.has("ctc") ? jSONObject2.getString("ctc") : null;
                        String string5 = jSONObject2.has("ct") ? jSONObject2.getString("ct") : null;
                        String string6 = jSONObject2.has("dist") ? jSONObject2.getString("dist") : null;
                        if (stringBuffer.length() > 0) {
                            stringBuffer.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                        }
                        stringBuffer.append("(\"").append(next).append("\",\"").append(string).append("\",\"").append(string2).append("\",\"").append(string3).append("\",\"").append(string5).append("\",\"").append(string4).append("\",\"").append(string6).append("\",").append(System.currentTimeMillis() / 1000).append(",\"\")");
                        b.b(stringBuffer2, next, str, 0);
                    } catch (JSONException e) {
                    }
                    if (i3 % 50 == 49 && stringBuffer.length() > 0) {
                        arrayList.add(String.format(Locale.US, "INSERT OR REPLACE INTO %s VALUES %s", "RGCAREA", stringBuffer));
                        arrayList.add(String.format(Locale.US, "INSERT OR REPLACE INTO %s VALUES %s", "RGCUPDATE", stringBuffer2));
                        stringBuffer.setLength(0);
                    }
                    i2 = i3 + 1;
                }
                if (stringBuffer.length() > 0) {
                    arrayList.add(String.format(Locale.US, "INSERT OR REPLACE INTO %s VALUES %s", "RGCAREA", stringBuffer));
                    arrayList.add(String.format(Locale.US, "INSERT OR REPLACE INTO %s VALUES %s", "RGCUPDATE", stringBuffer2));
                    stringBuffer.setLength(0);
                }
                arrayList.add(String.format(Locale.US, "DELETE FROM RGCAREA WHERE gridkey NOT IN (SELECT gridkey FROM RGCAREA LIMIT %d);", Integer.valueOf(i)));
                return arrayList;
            }
        },
        ROAD("RGCROAD", "road", "addrv", 1000, 10000) { // from class: com.baidu.location.d.g.b.2
            @Override // com.baidu.location.d.g.b
            List<String> a(JSONObject jSONObject, String str, int i) {
                JSONArray jSONArray;
                Iterator<String> keys = jSONObject.keys();
                ArrayList arrayList = new ArrayList();
                StringBuffer stringBuffer = new StringBuffer();
                while (keys.hasNext()) {
                    StringBuffer stringBuffer2 = new StringBuffer();
                    String next = keys.next();
                    b.b(stringBuffer, next, str, 0);
                    try {
                        jSONArray = jSONObject.getJSONArray(next);
                    } catch (JSONException e) {
                        jSONArray = null;
                    }
                    if (jSONArray != null) {
                        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                            try {
                                JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                                String string = jSONObject2.has(TimeDisplaySetting.START_SHOW_TIME) ? jSONObject2.getString(TimeDisplaySetting.START_SHOW_TIME) : null;
                                Double valueOf = jSONObject2.has("x1") ? Double.valueOf(jSONObject2.getDouble("x1")) : null;
                                Double valueOf2 = jSONObject2.has("y1") ? Double.valueOf(jSONObject2.getDouble("y1")) : null;
                                Double valueOf3 = jSONObject2.has("x2") ? Double.valueOf(jSONObject2.getDouble("x2")) : null;
                                Double valueOf4 = jSONObject2.has("y2") ? Double.valueOf(jSONObject2.getDouble("y2")) : null;
                                if (string != null && valueOf != null && valueOf2 != null && valueOf3 != null && valueOf4 != null) {
                                    if (stringBuffer2.length() > 0) {
                                        stringBuffer2.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                                    }
                                    stringBuffer2.append("(NULL,\"").append(next).append("\",\"").append(string).append("\",").append(valueOf).append(Constants.ACCEPT_TIME_SEPARATOR_SP).append(valueOf2).append(Constants.ACCEPT_TIME_SEPARATOR_SP).append(valueOf3).append(Constants.ACCEPT_TIME_SEPARATOR_SP).append(valueOf4).append(")");
                                }
                            } catch (JSONException e2) {
                            }
                            if (i2 % 50 == 49 && stringBuffer2.length() > 0) {
                                arrayList.add(String.format(Locale.US, "INSERT OR REPLACE INTO %s VALUES %s", "RGCROAD", stringBuffer2.toString()));
                                stringBuffer2.setLength(0);
                            }
                        }
                        if (stringBuffer2.length() > 0) {
                            arrayList.add(String.format(Locale.US, "INSERT OR REPLACE INTO %s VALUES %s", "RGCROAD", stringBuffer2.toString()));
                        }
                    }
                }
                if (stringBuffer.length() > 0) {
                    arrayList.add(String.format(Locale.US, "INSERT OR REPLACE INTO %s VALUES %s", "RGCUPDATE", stringBuffer));
                }
                arrayList.add(String.format(Locale.US, "DELETE FROM RGCROAD WHERE _id NOT IN (SELECT _id FROM RGCROAD LIMIT %d);", Integer.valueOf(i)));
                return arrayList;
            }
        },
        SITE("RGCSITE", "site", "addrv", 100, 50000) { // from class: com.baidu.location.d.g.b.3
            @Override // com.baidu.location.d.g.b
            List<String> a(JSONObject jSONObject, String str, int i) {
                JSONArray jSONArray;
                Iterator<String> keys = jSONObject.keys();
                ArrayList arrayList = new ArrayList();
                StringBuffer stringBuffer = new StringBuffer();
                while (keys.hasNext()) {
                    StringBuffer stringBuffer2 = new StringBuffer();
                    String next = keys.next();
                    b.b(stringBuffer, next, str, 0);
                    try {
                        jSONArray = jSONObject.getJSONArray(next);
                    } catch (JSONException e) {
                        jSONArray = null;
                    }
                    if (jSONArray != null) {
                        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                            try {
                                JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                                String string = jSONObject2.has(TimeDisplaySetting.START_SHOW_TIME) ? jSONObject2.getString(TimeDisplaySetting.START_SHOW_TIME) : null;
                                String string2 = jSONObject2.has("stn") ? jSONObject2.getString("stn") : null;
                                Double valueOf = jSONObject2.has("x") ? Double.valueOf(jSONObject2.getDouble("x")) : null;
                                Double valueOf2 = jSONObject2.has("y") ? Double.valueOf(jSONObject2.getDouble("y")) : null;
                                if (stringBuffer2.length() > 0) {
                                    stringBuffer2.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                                }
                                stringBuffer2.append("(NULL,\"").append(next).append("\",\"").append(string).append("\",\"").append(string2).append("\",").append(valueOf).append(Constants.ACCEPT_TIME_SEPARATOR_SP).append(valueOf2).append(")");
                            } catch (JSONException e2) {
                            }
                            if (i2 % 50 == 49 && stringBuffer2.length() > 0) {
                                arrayList.add(String.format(Locale.US, "INSERT OR REPLACE INTO %s VALUES %s", "RGCSITE", stringBuffer2.toString()));
                                stringBuffer2.setLength(0);
                            }
                        }
                        if (stringBuffer2.length() > 0) {
                            arrayList.add(String.format(Locale.US, "INSERT OR REPLACE INTO %s VALUES %s", "RGCSITE", stringBuffer2.toString()));
                        }
                    }
                }
                if (stringBuffer.length() > 0) {
                    arrayList.add(String.format(Locale.US, "INSERT OR REPLACE INTO %s VALUES %s", "RGCUPDATE", stringBuffer));
                }
                arrayList.add(String.format(Locale.US, "DELETE FROM RGCSITE WHERE _id NOT IN (SELECT _id FROM RGCSITE LIMIT %d);", Integer.valueOf(i)));
                return arrayList;
            }
        },
        POI("RGCPOI", "poi", "poiv", 1000, 5000) { // from class: com.baidu.location.d.g.b.4
            @Override // com.baidu.location.d.g.b
            List<String> a(JSONObject jSONObject, String str, int i) {
                JSONArray jSONArray;
                Iterator<String> keys = jSONObject.keys();
                ArrayList arrayList = new ArrayList();
                StringBuffer stringBuffer = new StringBuffer();
                while (keys.hasNext()) {
                    StringBuffer stringBuffer2 = new StringBuffer();
                    String next = keys.next();
                    b.b(stringBuffer, next, str, 1);
                    try {
                        jSONArray = jSONObject.getJSONArray(next);
                    } catch (JSONException e) {
                        jSONArray = null;
                    }
                    if (jSONArray != null) {
                        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                            try {
                                JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                                String string = jSONObject2.has(Info.kBaiduPIDKey) ? jSONObject2.getString(Info.kBaiduPIDKey) : null;
                                String string2 = jSONObject2.has("ne") ? jSONObject2.getString("ne") : null;
                                String string3 = jSONObject2.has("tp") ? jSONObject2.getString("tp") : null;
                                Integer valueOf = jSONObject2.has("rk") ? Integer.valueOf(jSONObject2.getInt("rk")) : null;
                                Double valueOf2 = jSONObject2.has("x") ? Double.valueOf(jSONObject2.getDouble("x")) : null;
                                Double valueOf3 = jSONObject2.has("y") ? Double.valueOf(jSONObject2.getDouble("y")) : null;
                                if (stringBuffer2.length() > 0) {
                                    stringBuffer2.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                                }
                                stringBuffer2.append("(\"").append(string).append("\",\"").append(next).append("\",\"").append(string2).append("\",\"").append(string3).append("\",").append(valueOf2).append(Constants.ACCEPT_TIME_SEPARATOR_SP).append(valueOf3).append(Constants.ACCEPT_TIME_SEPARATOR_SP).append(valueOf).append(")");
                            } catch (JSONException e2) {
                            }
                            if (i2 % 50 == 49) {
                                arrayList.add(String.format(Locale.US, "INSERT OR REPLACE INTO %s VALUES %s", "RGCPOI", stringBuffer2.toString()));
                                stringBuffer2.setLength(0);
                            }
                        }
                        if (stringBuffer2.length() > 0) {
                            arrayList.add(String.format(Locale.US, "INSERT OR REPLACE INTO %s VALUES %s", "RGCPOI", stringBuffer2.toString()));
                        }
                    }
                }
                if (stringBuffer.length() > 0) {
                    arrayList.add(String.format(Locale.US, "INSERT OR REPLACE INTO %s VALUES %s", "RGCUPDATE", stringBuffer));
                }
                arrayList.add(String.format(Locale.US, "DELETE FROM RGCPOI WHERE pid NOT IN (SELECT pid FROM RGCPOI LIMIT %d);", Integer.valueOf(i)));
                return arrayList;
            }
        };
        
        private final int e;
        private final String f;
        private final String g;
        private final String h;
        private final int i;

        b(String str, String str2, String str3, int i, int i2) {
            this.f = str;
            this.g = str2;
            this.h = str3;
            this.e = i;
            this.i = i2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String a(int i, double d, double d2) {
            HashSet hashSet = new HashSet();
            hashSet.add(g.b(i, d, d2));
            double d3 = this.e * 1.414d;
            if (this.e > 0) {
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 >= g.b.length) {
                        break;
                    }
                    double[] b = g.b(d2, d, d3, g.b[i3]);
                    hashSet.add(g.b(i, b[1], b[0]));
                    i2 = i3 + 1;
                }
            }
            StringBuffer stringBuffer = new StringBuffer();
            Iterator it = hashSet.iterator();
            boolean z = true;
            while (it.hasNext()) {
                String str = (String) it.next();
                if (z) {
                    z = false;
                } else {
                    stringBuffer.append(',');
                }
                stringBuffer.append("\"").append(str).append("\"");
            }
            return String.format("SELECT * FROM %s WHERE gridkey IN (%s);", this.f, stringBuffer.toString());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String a(JSONObject jSONObject) {
            Iterator<String> keys = jSONObject.keys();
            StringBuffer stringBuffer = new StringBuffer();
            while (keys.hasNext()) {
                String next = keys.next();
                if (stringBuffer.length() != 0) {
                    stringBuffer.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                stringBuffer.append("\"").append(next).append("\"");
            }
            return String.format(Locale.US, "DELETE FROM %s WHERE gridkey IN (%s)", this.f, stringBuffer);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void b(StringBuffer stringBuffer, String str, String str2, int i) {
            if (stringBuffer.length() > 0) {
                stringBuffer.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
            stringBuffer.append("(\"").append(str).append("\",\"").append(str2).append("\",").append(i).append(Constants.ACCEPT_TIME_SEPARATOR_SP).append(System.currentTimeMillis() / 86400000).append(")");
        }

        abstract List<String> a(JSONObject jSONObject, String str, int i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(d dVar, SQLiteDatabase sQLiteDatabase, int i) {
        this.a = dVar;
        this.d = sQLiteDatabase;
        this.c = i;
        if (this.d == null || !this.d.isOpen()) {
            return;
        }
        try {
            this.d.execSQL("CREATE TABLE IF NOT EXISTS RGCAREA(gridkey VARCHAR(10) PRIMARY KEY, country VARCHAR(100),countrycode VARCHAR(100), province VARCHAR(100), city VARCHAR(100), citycode VARCHAR(100), district VARCHAR(100), timestamp INTEGER, version VARCHAR(50))");
            this.d.execSQL("CREATE TABLE IF NOT EXISTS RGCROAD(_id INTEGER PRIMARY KEY AUTOINCREMENT, gridkey VARCHAR(10), street VARCHAR(100), x1 DOUBLE, y1 DOUBLE, x2 DOUBLE, y2 DOUBLE)");
            this.d.execSQL("CREATE TABLE IF NOT EXISTS RGCSITE(_id INTEGER PRIMARY KEY AUTOINCREMENT, gridkey VARCHAR(10), street VARCHAR(100), streetnumber VARCHAR(100), x DOUBLE, y DOUBLE)");
            this.d.execSQL("CREATE TABLE IF NOT EXISTS RGCPOI(pid VARCHAR(50) PRIMARY KEY , gridkey VARCHAR(10), name VARCHAR(100), type VARCHAR(50), x DOUBLE, y DOUBLE, rank INTEGER)");
            this.d.execSQL("CREATE TABLE IF NOT EXISTS RGCUPDATE(gridkey VARCHAR(10), version VARCHAR(50), type INTEGER, timestamp INTEGER, PRIMARY KEY(gridkey, type))");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private double a(double d, double d2, double d3, double d4, double d5, double d6) {
        double d7 = ((d5 - d3) * (d - d3)) + ((d6 - d4) * (d2 - d4));
        if (d7 <= 0.0d) {
            return Math.sqrt(((d - d3) * (d - d3)) + ((d2 - d4) * (d2 - d4)));
        }
        double d8 = ((d5 - d3) * (d5 - d3)) + ((d6 - d4) * (d6 - d4));
        if (d7 >= d8) {
            return Math.sqrt(((d - d5) * (d - d5)) + ((d2 - d6) * (d2 - d6)));
        }
        double d9 = d7 / d8;
        double d10 = ((d5 - d3) * d9) + d3;
        double d11 = (d9 * (d6 - d4)) + d4;
        return Math.sqrt(((d11 - d2) * (d11 - d2)) + ((d - d10) * (d - d10)));
    }

    private static int a(int i, int i2) {
        double d;
        int i3;
        if (100 > i2) {
            d = -0.1d;
            i3 = 60000;
        } else if (500 > i2) {
            d = -0.75d;
            i3 = 55500;
        } else {
            d = -0.5d;
            i3 = 0;
        }
        return ((int) (i3 + (d * i2))) + i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String b(int i, double d, double d2) {
        a aVar;
        double d3;
        int i2;
        int i3;
        int i4 = i * 5;
        char[] cArr = new char[i + 1];
        a aVar2 = new a(90.0d, -90.0d);
        a aVar3 = new a(180.0d, -180.0d);
        int i5 = 1;
        boolean z = true;
        int i6 = 0;
        while (i5 <= i4) {
            if (z) {
                aVar = aVar3;
                d3 = d;
            } else {
                aVar = aVar2;
                d3 = d2;
            }
            double d4 = (aVar.b + aVar.a) / 2.0d;
            int i7 = i6 << 1;
            if (((int) (d3 * 1000000.0d)) > ((int) (1000000.0d * d4))) {
                aVar.b = d4;
                i2 = i7 | 1;
            } else {
                aVar.a = d4;
                i2 = i7;
            }
            if (i5 % 5 == 0) {
                cArr[(i5 / 5) - 1] = "0123456789bcdefghjkmnpqrstuvwxyz".charAt(i2);
                i3 = 0;
            } else {
                i3 = i2;
            }
            i5++;
            z = !z;
            i6 = i3;
        }
        cArr[i] = 0;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i8 = 0; i8 < i; i8++) {
            stringBuffer.append(cArr[i8]);
        }
        return stringBuffer.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static double[] b(double d, double d2, double d3, double d4) {
        double radians = Math.toRadians(d);
        double radians2 = Math.toRadians(d2);
        double radians3 = Math.toRadians(d4);
        double asin = Math.asin((Math.sin(radians) * Math.cos(d3 / 6378137.0d)) + (Math.cos(radians) * Math.sin(d3 / 6378137.0d) * Math.cos(radians3)));
        return new double[]{Math.toDegrees(asin), Math.toDegrees(Math.atan2(Math.sin(radians3) * Math.sin(d3 / 6378137.0d) * Math.cos(radians), Math.cos(d3 / 6378137.0d) - (Math.sin(radians) * Math.sin(asin))) + radians2)};
    }

    private double c(double d, double d2, double d3, double d4) {
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

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:174:0x00af */
    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't wrap try/catch for region: R(7:21|(16:(22:161|162|163|(0)|80|81|82|83|84|(0)|147|(0)|(0)|(0)|(0)|(0)|(0)|(0)|(0)|(0)(0)|120|121)|83|84|(0)|147|(0)|(0)|(0)|(0)|(0)|(0)|(0)|(0)|(0)(0)|120|121)|23|(0)|80|81|82) */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x0277, code lost:
        r5 = null;
        r6 = null;
        r7 = null;
        r8 = null;
        r9 = null;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:148:0x02f1  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x01ae A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x015d A[Catch: Exception -> 0x0276, all -> 0x02af, TryCatch #7 {Exception -> 0x0276, blocks: (B:56:0x014e, B:57:0x0157, B:59:0x015d, B:61:0x0163), top: B:170:0x014e }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01f3  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0203  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0213  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0223  */
    /* JADX WARN: Type inference failed for: r4v56 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Address a(double d, double d2) {
        Cursor cursor;
        String str;
        String str2;
        String str3;
        String str4;
        Cursor cursor2;
        Cursor cursor3;
        Throwable th;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        String str13;
        String str14;
        Cursor cursor4;
        Cursor cursor5;
        String str15;
        double d3;
        double c;
        Cursor cursor6 = null;
        try {
            cursor = this.d.rawQuery(b.SITE.a(this.c, d, d2), null);
            try {
                try {
                    if (cursor.moveToFirst()) {
                        double d4 = Double.MAX_VALUE;
                        String str16 = null;
                        String str17 = null;
                        while (!cursor.isAfterLast()) {
                            try {
                                String string = cursor.getString(2);
                                String string2 = cursor.getString(3);
                                c = c(d2, d, cursor.getDouble(5), cursor.getDouble(4));
                                if (c >= d4 || c > b.SITE.e) {
                                    c = d4;
                                    str = str16;
                                    str2 = str17;
                                } else {
                                    str = string2;
                                    str2 = string;
                                }
                            } catch (Exception e) {
                                str = str16;
                                str2 = str17;
                            }
                            try {
                                cursor.moveToNext();
                                d4 = c;
                                str16 = str;
                                str17 = str2;
                            } catch (Exception e2) {
                                try {
                                    if (cursor != null) {
                                        try {
                                            cursor.close();
                                            str3 = str;
                                            str4 = str2;
                                        } catch (Exception e3) {
                                            str3 = str;
                                            str4 = str2;
                                        }
                                        if (str3 == null) {
                                        }
                                        cursor2 = null;
                                        cursor2 = this.d.rawQuery(b.AREA.a(this.c, d, d2), null);
                                        if (cursor2.moveToFirst()) {
                                        }
                                        str14 = null;
                                        str13 = null;
                                        str12 = null;
                                        str11 = null;
                                        str10 = null;
                                        str9 = null;
                                        if (cursor2 != null) {
                                        }
                                        if (str9 != null) {
                                        }
                                        if (str10 != null) {
                                        }
                                        if (str11 != null) {
                                        }
                                        if (str12 != null) {
                                        }
                                        if (str13 != null) {
                                        }
                                        if (str14 != null) {
                                        }
                                        if (str4 != null) {
                                        }
                                        return new Address.Builder().country(str9).countryCode(str10).province(str11).city(str12).cityCode(str13).district(str14).street(str4).streetNumber(str3 != null ? new String(Base64.decode(str3.getBytes())) : str3).build();
                                    }
                                    if (cursor2.moveToFirst()) {
                                    }
                                    str14 = null;
                                    str13 = null;
                                    str12 = null;
                                    str11 = null;
                                    str10 = null;
                                    str9 = null;
                                    if (cursor2 != null) {
                                    }
                                    if (str9 != null) {
                                    }
                                    if (str10 != null) {
                                    }
                                    if (str11 != null) {
                                    }
                                    if (str12 != null) {
                                    }
                                    if (str13 != null) {
                                    }
                                    if (str14 != null) {
                                    }
                                    if (str4 != null) {
                                    }
                                    return new Address.Builder().country(str9).countryCode(str10).province(str11).city(str12).cityCode(str13).district(str14).street(str4).streetNumber(str3 != null ? new String(Base64.decode(str3.getBytes())) : str3).build();
                                } catch (Throwable th2) {
                                    cursor3 = cursor2;
                                    th = th2;
                                    if (cursor3 != null) {
                                        try {
                                            cursor3.close();
                                        } catch (Exception e4) {
                                        }
                                    }
                                    throw th;
                                }
                                str3 = str;
                                str4 = str2;
                                if (str3 == null) {
                                }
                                cursor2 = null;
                                cursor2 = this.d.rawQuery(b.AREA.a(this.c, d, d2), null);
                            }
                        }
                        str = str16;
                        str2 = str17;
                    } else {
                        str = null;
                        str2 = null;
                    }
                } catch (Exception e5) {
                    str = null;
                    str2 = null;
                }
            } catch (Throwable th3) {
                cursor6 = cursor;
                th = th3;
                if (cursor6 != null) {
                    try {
                        cursor6.close();
                    } catch (Exception e6) {
                    }
                }
                throw th;
            }
        } catch (Exception e7) {
            cursor = null;
            str = null;
            str2 = null;
        } catch (Throwable th4) {
            th = th4;
        }
        try {
            if (cursor != null) {
                try {
                    cursor.close();
                    str3 = str;
                    str4 = str2;
                } catch (Exception e8) {
                    str3 = str;
                    str4 = str2;
                }
                if (str3 == null) {
                    try {
                        cursor4 = this.d.rawQuery(b.ROAD.a(this.c, d, d2), null);
                        try {
                            try {
                                if (cursor4.moveToFirst()) {
                                    double d5 = Double.MAX_VALUE;
                                    double[] coorEncrypt = Jni.coorEncrypt(d, d2, "wgs842mc");
                                    str15 = "wgs842mc";
                                    while (true) {
                                        try {
                                            str15 = str4;
                                            if (cursor4.isAfterLast()) {
                                                break;
                                            }
                                            String string3 = cursor4.getString(2);
                                            double[] coorEncrypt2 = Jni.coorEncrypt(cursor4.getDouble(3), cursor4.getDouble(4), "wgs842mc");
                                            double[] coorEncrypt3 = Jni.coorEncrypt(cursor4.getDouble(5), cursor4.getDouble(6), "wgs842mc");
                                            double a2 = a(coorEncrypt[0], coorEncrypt[1], coorEncrypt2[0], coorEncrypt2[1], coorEncrypt3[0], coorEncrypt3[1]);
                                            if (a2 >= d5 || a2 > b.ROAD.e) {
                                                str4 = str15;
                                                d3 = d5;
                                            } else {
                                                d3 = a2;
                                                str4 = string3;
                                            }
                                            cursor4.moveToNext();
                                            d5 = d3;
                                            str15 = d3;
                                        } catch (Exception e9) {
                                            cursor5 = cursor4;
                                            str15 = str15;
                                            if (cursor5 != null) {
                                                try {
                                                    cursor5.close();
                                                    str4 = str15;
                                                } catch (Exception e10) {
                                                    str4 = str15;
                                                }
                                                cursor2 = null;
                                                cursor2 = this.d.rawQuery(b.AREA.a(this.c, d, d2), null);
                                                if (cursor2.moveToFirst()) {
                                                }
                                                str14 = null;
                                                str13 = null;
                                                str12 = null;
                                                str11 = null;
                                                str10 = null;
                                                str9 = null;
                                                if (cursor2 != null) {
                                                }
                                                if (str9 != null) {
                                                }
                                                if (str10 != null) {
                                                }
                                                if (str11 != null) {
                                                }
                                                if (str12 != null) {
                                                }
                                                if (str13 != null) {
                                                }
                                                if (str14 != null) {
                                                }
                                                if (str4 != null) {
                                                }
                                                return new Address.Builder().country(str9).countryCode(str10).province(str11).city(str12).cityCode(str13).district(str14).street(str4).streetNumber(str3 != null ? new String(Base64.decode(str3.getBytes())) : str3).build();
                                            }
                                            str4 = str15;
                                            cursor2 = null;
                                            cursor2 = this.d.rawQuery(b.AREA.a(this.c, d, d2), null);
                                            if (cursor2.moveToFirst()) {
                                            }
                                            str14 = null;
                                            str13 = null;
                                            str12 = null;
                                            str11 = null;
                                            str10 = null;
                                            str9 = null;
                                            if (cursor2 != null) {
                                            }
                                            if (str9 != null) {
                                            }
                                            if (str10 != null) {
                                            }
                                            if (str11 != null) {
                                            }
                                            if (str12 != null) {
                                            }
                                            if (str13 != null) {
                                            }
                                            if (str14 != null) {
                                            }
                                            if (str4 != null) {
                                            }
                                            return new Address.Builder().country(str9).countryCode(str10).province(str11).city(str12).cityCode(str13).district(str14).street(str4).streetNumber(str3 != null ? new String(Base64.decode(str3.getBytes())) : str3).build();
                                        }
                                    }
                                } else {
                                    str15 = str4;
                                }
                                if (cursor4 != null) {
                                    try {
                                        cursor4.close();
                                        str4 = str15;
                                    } catch (Exception e11) {
                                        str4 = str15;
                                    }
                                }
                            } catch (Exception e12) {
                                cursor5 = cursor4;
                                str15 = str4;
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            if (cursor4 != null) {
                                try {
                                    cursor4.close();
                                } catch (Exception e13) {
                                }
                            }
                            throw th;
                        }
                    } catch (Exception e14) {
                        cursor5 = null;
                        str15 = str4;
                    } catch (Throwable th6) {
                        th = th6;
                        cursor4 = null;
                    }
                    str4 = str15;
                }
                cursor2 = null;
                cursor2 = this.d.rawQuery(b.AREA.a(this.c, d, d2), null);
                if (cursor2.moveToFirst() || cursor2.isAfterLast()) {
                    str14 = null;
                    str13 = null;
                    str12 = null;
                    str11 = null;
                    str10 = null;
                    str9 = null;
                } else {
                    String str18 = cursor2.getString(cursor2.getColumnIndex("country"));
                    try {
                        str8 = cursor2.getString(cursor2.getColumnIndex("countrycode"));
                        try {
                            str7 = cursor2.getString(cursor2.getColumnIndex("province"));
                            try {
                                str6 = cursor2.getString(cursor2.getColumnIndex("city"));
                                try {
                                    str5 = cursor2.getString(cursor2.getColumnIndex("citycode"));
                                } catch (Exception e15) {
                                    str5 = null;
                                }
                                try {
                                    str9 = str18;
                                    str10 = str8;
                                    str11 = str7;
                                    str12 = str6;
                                    str13 = str5;
                                    str14 = cursor2.getString(cursor2.getColumnIndex("district"));
                                } catch (Exception e16) {
                                    if (cursor2 != null) {
                                        try {
                                            cursor2.close();
                                            str9 = str18;
                                            str10 = str8;
                                            str11 = str7;
                                            str12 = str6;
                                            str13 = str5;
                                            str14 = null;
                                        } catch (Exception e17) {
                                            str9 = str18;
                                            str10 = str8;
                                            str11 = str7;
                                            str12 = str6;
                                            str13 = str5;
                                            str14 = null;
                                        }
                                    } else {
                                        str9 = str18;
                                        str10 = str8;
                                        str11 = str7;
                                        str12 = str6;
                                        str13 = str5;
                                        str14 = null;
                                    }
                                    if (str9 != null) {
                                    }
                                    if (str10 != null) {
                                    }
                                    if (str11 != null) {
                                    }
                                    if (str12 != null) {
                                    }
                                    if (str13 != null) {
                                    }
                                    if (str14 != null) {
                                    }
                                    if (str4 != null) {
                                    }
                                    return new Address.Builder().country(str9).countryCode(str10).province(str11).city(str12).cityCode(str13).district(str14).street(str4).streetNumber(str3 != null ? new String(Base64.decode(str3.getBytes())) : str3).build();
                                }
                            } catch (Exception e18) {
                                str5 = null;
                                str6 = null;
                            }
                        } catch (Exception e19) {
                            str5 = null;
                            str6 = null;
                            str7 = null;
                        }
                    } catch (Exception e20) {
                        str5 = null;
                        str6 = null;
                        str7 = null;
                        str8 = null;
                    }
                }
                if (cursor2 != null) {
                    try {
                        cursor2.close();
                    } catch (Exception e21) {
                    }
                }
                if (str9 != null) {
                    str9 = new String(Base64.decode(str9.getBytes()));
                }
                if (str10 != null) {
                    str10 = new String(Base64.decode(str10.getBytes()));
                }
                if (str11 != null) {
                    str11 = new String(Base64.decode(str11.getBytes()));
                }
                if (str12 != null) {
                    str12 = new String(Base64.decode(str12.getBytes()));
                }
                if (str13 != null) {
                    str13 = new String(Base64.decode(str13.getBytes()));
                }
                if (str14 != null) {
                    str14 = new String(Base64.decode(str14.getBytes()));
                }
                if (str4 != null) {
                    str4 = new String(Base64.decode(str4.getBytes()));
                }
                return new Address.Builder().country(str9).countryCode(str10).province(str11).city(str12).cityCode(str13).district(str14).street(str4).streetNumber(str3 != null ? new String(Base64.decode(str3.getBytes())) : str3).build();
            }
            cursor2 = this.d.rawQuery(b.AREA.a(this.c, d, d2), null);
            if (cursor2.moveToFirst()) {
            }
            str14 = null;
            str13 = null;
            str12 = null;
            str11 = null;
            str10 = null;
            str9 = null;
            if (cursor2 != null) {
            }
            if (str9 != null) {
            }
            if (str10 != null) {
            }
            if (str11 != null) {
            }
            if (str12 != null) {
            }
            if (str13 != null) {
            }
            if (str14 != null) {
            }
            if (str4 != null) {
            }
            return new Address.Builder().country(str9).countryCode(str10).province(str11).city(str12).cityCode(str13).district(str14).street(str4).streetNumber(str3 != null ? new String(Base64.decode(str3.getBytes())) : str3).build();
        } catch (Throwable th7) {
            cursor3 = null;
            th = th7;
        }
        str3 = str;
        str4 = str2;
        if (str3 == null) {
        }
        cursor2 = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(JSONObject jSONObject) {
        b[] values;
        if (this.d == null || !this.d.isOpen()) {
            return;
        }
        try {
            this.d.beginTransaction();
            for (b bVar : b.values()) {
                if (jSONObject.has(bVar.g)) {
                    String string = jSONObject.has(bVar.h) ? jSONObject.getString(bVar.h) : "";
                    ArrayList<String> arrayList = new ArrayList();
                    JSONObject jSONObject2 = jSONObject.getJSONObject(bVar.g);
                    arrayList.add(bVar.a(jSONObject2));
                    arrayList.addAll(bVar.a(jSONObject2, string, bVar.i));
                    for (String str : arrayList) {
                        this.d.execSQL(str);
                    }
                }
            }
            this.d.setTransactionSuccessful();
            this.e = -1;
            this.f = -1;
            try {
                this.d.endTransaction();
            } catch (Exception e) {
            }
        } catch (Exception e2) {
            try {
                this.d.endTransaction();
            } catch (Exception e3) {
            }
        } catch (Throwable th) {
            try {
                this.d.endTransaction();
            } catch (Exception e4) {
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a() {
        Cursor cursor;
        Cursor cursor2 = null;
        if (this.a.l().l() && this.f == -1 && this.e == -1 && this.d != null && this.d.isOpen()) {
            try {
                cursor = this.d.rawQuery("SELECT COUNT(*) FROM RGCSITE;", null);
            } catch (Exception e) {
                cursor = null;
            } catch (Throwable th) {
                th = th;
                cursor = null;
            }
            try {
                cursor.moveToFirst();
                this.f = cursor.getInt(0);
                cursor2 = this.d.rawQuery("SELECT COUNT(*) FROM RGCAREA;", null);
                cursor2.moveToFirst();
                this.e = cursor2.getInt(0);
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
                return this.f != 0 ? false : false;
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
        }
        if (this.f != 0 && this.e == 0) {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0095  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<Poi> b(double d, double d2) {
        Cursor cursor;
        Cursor cursor2;
        ArrayList arrayList = new ArrayList();
        Poi poi = null;
        int i = 0;
        try {
            cursor = this.d.rawQuery(b.POI.a(this.c, d, d2), null);
        } catch (Exception e) {
            cursor2 = null;
        } catch (Throwable th) {
            th = th;
            cursor = null;
        }
        try {
            if (cursor.moveToFirst()) {
                while (true) {
                    int i2 = i;
                    if (cursor.isAfterLast()) {
                        break;
                    }
                    String string = cursor.getString(0);
                    String string2 = cursor.getString(2);
                    double d3 = cursor.getDouble(4);
                    double d4 = cursor.getDouble(5);
                    int i3 = cursor.getInt(6);
                    double c = c(d2, d, d4, d3);
                    if (c < b.POI.e) {
                        Poi poi2 = new Poi(new String(Base64.decode(string.getBytes())), new String(Base64.decode(string2.getBytes())), 1.0d);
                        i = a(i3, Math.round((float) c));
                        if (i > i2) {
                            poi = poi2;
                            cursor.moveToNext();
                        }
                    }
                    i = i2;
                    cursor.moveToNext();
                }
            }
            if (cursor != null) {
                try {
                    cursor.close();
                } catch (Exception e2) {
                }
            }
        } catch (Exception e3) {
            cursor2 = cursor;
            if (cursor2 != null) {
                try {
                    cursor2.close();
                } catch (Exception e4) {
                }
            }
            if (poi != null) {
            }
            return arrayList;
        } catch (Throwable th2) {
            th = th2;
            if (cursor != null) {
                try {
                    cursor.close();
                } catch (Exception e5) {
                }
            }
            throw th;
        }
        if (poi != null) {
            arrayList.add(poi);
        }
        return arrayList;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, MOVE_EXCEPTION, INVOKE, MOVE_EXCEPTION, IF, MOVE_EXCEPTION, INVOKE, MOVE_EXCEPTION, IF, MOVE_EXCEPTION, INVOKE, MOVE_EXCEPTION, IF, MOVE_EXCEPTION, INVOKE, MOVE_EXCEPTION, INVOKE, MOVE_EXCEPTION, IF, MOVE_EXCEPTION] complete} */
    /* JADX INFO: Access modifiers changed from: package-private */
    public JSONObject b() {
        Cursor cursor = null;
        Cursor cursor2 = null;
        JSONObject jSONObject = new JSONObject();
        StringBuffer stringBuffer = new StringBuffer();
        StringBuffer stringBuffer2 = new StringBuffer();
        int currentTimeMillis = (int) (System.currentTimeMillis() / 86400000);
        try {
            if (this.d != null && this.d.isOpen()) {
                JSONArray jSONArray = new JSONArray();
                JSONArray jSONArray2 = new JSONArray();
                JSONArray jSONArray3 = new JSONArray();
                JSONArray jSONArray4 = new JSONArray();
                cursor2 = this.d.rawQuery(String.format("SELECT * FROM RGCUPDATE WHERE type=%d AND %d > timestamp+%d ORDER BY gridkey", 0, Integer.valueOf(currentTimeMillis), Integer.valueOf(this.a.l().p())), null);
                cursor = this.d.rawQuery(String.format("SELECT * FROM RGCUPDATE WHERE type=%d AND %d > timestamp+%d ORDER BY gridkey", 1, Integer.valueOf(currentTimeMillis), Integer.valueOf(this.a.l().q())), null);
                if (cursor2.moveToFirst()) {
                    HashSet hashSet = new HashSet();
                    while (!cursor2.isAfterLast()) {
                        String string = cursor2.getString(0);
                        String string2 = cursor2.getString(1);
                        jSONArray3.put(string);
                        hashSet.add(string2);
                        if (stringBuffer2.length() > 0) {
                            stringBuffer2.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                        }
                        stringBuffer2.append("\"").append(string).append("\"");
                        cursor2.moveToNext();
                    }
                    String[] strArr = new String[hashSet.size()];
                    hashSet.toArray(strArr);
                    for (String str : strArr) {
                        jSONArray4.put(str);
                    }
                }
                if (cursor.moveToFirst()) {
                    HashSet hashSet2 = new HashSet();
                    while (!cursor.isAfterLast()) {
                        String string3 = cursor.getString(0);
                        String string4 = cursor.getString(1);
                        jSONArray.put(string3);
                        hashSet2.add(string4);
                        if (stringBuffer.length() > 0) {
                            stringBuffer.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                        }
                        stringBuffer.append("\"").append(string3).append("\"");
                        cursor.moveToNext();
                    }
                    String[] strArr2 = new String[hashSet2.size()];
                    hashSet2.toArray(strArr2);
                    for (String str2 : strArr2) {
                        jSONArray2.put(str2);
                    }
                }
                if (jSONArray3.length() != 0) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("gk", jSONArray3);
                    jSONObject2.put("ver", jSONArray4);
                    jSONObject.put("addr", jSONObject2);
                }
                if (jSONArray.length() != 0) {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("gk", jSONArray);
                    jSONObject3.put("ver", jSONArray2);
                    jSONObject.put("poi", jSONObject3);
                }
            }
            if (stringBuffer2.length() > 0) {
                String format = String.format(Locale.US, "UPDATE RGCUPDATE SET timestamp=timestamp+1 WHERE type = %d AND gridkey IN (%s)", 0, stringBuffer2.toString());
                if (this.d != null) {
                    this.d.execSQL(format);
                }
            }
            if (stringBuffer.length() > 0) {
                String format2 = String.format(Locale.US, "UPDATE RGCUPDATE SET timestamp=timestamp+1 WHERE type = %d AND gridkey IN (%s)", 1, stringBuffer.toString());
                if (this.d != null) {
                    this.d.execSQL(format2);
                }
            }
            if (cursor2 != null) {
                try {
                    cursor2.close();
                } catch (Exception e) {
                }
            }
            if (cursor != null) {
                try {
                    cursor.close();
                } catch (Exception e2) {
                }
            }
        } catch (Exception e3) {
            if (cursor2 != null) {
                try {
                    cursor2.close();
                } catch (Exception e4) {
                }
            }
            if (cursor != null) {
                try {
                    cursor.close();
                } catch (Exception e5) {
                }
            }
        } catch (Throwable th) {
            if (cursor2 != null) {
                try {
                    cursor2.close();
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
        if (jSONObject.has("poi") || jSONObject.has("addr")) {
            return jSONObject;
        }
        return null;
    }
}
