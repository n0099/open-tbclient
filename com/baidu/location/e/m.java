package com.baidu.location.e;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.location.Address;
import com.baidu.location.Jni;
import com.baidu.location.Poi;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.baidu.tbadk.core.atomData.GroupInfoActivityConfig;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class m {
    private static final double[] KS = {45.0d, 135.0d, 225.0d, 315.0d};
    private final SQLiteDatabase KT;
    private final d Kj;
    private final int c;
    private int e = -1;
    private int f = -1;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class a {
        private double a;
        private double b;

        private a(double d, double d2) {
            this.a = d;
            this.b = d2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* loaded from: classes.dex */
    public static abstract class b {
        private final int e;
        private final String f;
        private final String g;
        private final String h;
        private final int i;
        public static final b a = new n("AREA", 0, "RGCAREA", CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA, "addrv", 0, 1000);
        public static final b b = new o("ROAD", 1, "RGCROAD", "road", "addrv", 1000, 10000);
        public static final b c = new p("SITE", 2, "RGCSITE", "site", "addrv", 100, 50000);
        public static final b d = new q("POI", 3, "RGCPOI", "poi", "poiv", 1000, 5000);
        private static final /* synthetic */ b[] KU = {a, b, c, d};

        private b(String str, int i, String str2, String str3, String str4, int i2, int i3) {
            this.f = str2;
            this.g = str3;
            this.h = str4;
            this.e = i2;
            this.i = i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String a(JSONObject jSONObject) {
            Iterator<String> keys = jSONObject.keys();
            StringBuffer stringBuffer = new StringBuffer();
            while (keys.hasNext()) {
                String next = keys.next();
                if (stringBuffer.length() != 0) {
                    stringBuffer.append(",");
                }
                stringBuffer.append("\"").append(next).append("\"");
            }
            return String.format(Locale.US, "DELETE FROM %s WHERE gridkey IN (%s)", this.f, stringBuffer);
        }

        public static b[] a() {
            return (b[]) KU.clone();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String b(int i, double d2, double d3) {
            HashSet hashSet = new HashSet();
            hashSet.add(m.a(i, d2, d3));
            double d4 = this.e * 1.414d;
            if (this.e > 0) {
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 >= m.KS.length) {
                        break;
                    }
                    double[] b2 = m.b(d3, d2, d4, m.KS[i3]);
                    hashSet.add(m.a(i, b2[1], b2[0]));
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
        public static void b(StringBuffer stringBuffer, String str, String str2, int i) {
            if (stringBuffer.length() > 0) {
                stringBuffer.append(",");
            }
            stringBuffer.append("(\"").append(str).append("\",\"").append(str2).append("\",").append(i).append(",").append(System.currentTimeMillis() / 86400000).append(")");
        }

        abstract List<String> a(JSONObject jSONObject, String str, int i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(d dVar, SQLiteDatabase sQLiteDatabase, int i) {
        this.Kj = dVar;
        this.KT = sQLiteDatabase;
        this.c = i;
        if (this.KT == null || !this.KT.isOpen()) {
            return;
        }
        try {
            this.KT.execSQL("CREATE TABLE IF NOT EXISTS RGCAREA(gridkey VARCHAR(10) PRIMARY KEY, country VARCHAR(100),countrycode VARCHAR(100), province VARCHAR(100), city VARCHAR(100), citycode VARCHAR(100), district VARCHAR(100), timestamp INTEGER, version VARCHAR(50))");
            this.KT.execSQL("CREATE TABLE IF NOT EXISTS RGCROAD(_id INTEGER PRIMARY KEY AUTOINCREMENT, gridkey VARCHAR(10), street VARCHAR(100), x1 DOUBLE, y1 DOUBLE, x2 DOUBLE, y2 DOUBLE)");
            this.KT.execSQL("CREATE TABLE IF NOT EXISTS RGCSITE(_id INTEGER PRIMARY KEY AUTOINCREMENT, gridkey VARCHAR(10), street VARCHAR(100), streetnumber VARCHAR(100), x DOUBLE, y DOUBLE)");
            this.KT.execSQL("CREATE TABLE IF NOT EXISTS RGCPOI(pid VARCHAR(50) PRIMARY KEY , gridkey VARCHAR(10), name VARCHAR(100), type VARCHAR(50), x DOUBLE, y DOUBLE, rank INTEGER)");
            this.KT.execSQL("CREATE TABLE IF NOT EXISTS RGCUPDATE(gridkey VARCHAR(10), version VARCHAR(50), type INTEGER, timestamp INTEGER, PRIMARY KEY(gridkey, type))");
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
            i3 = GroupInfoActivityConfig.JOIN_BUTTON_DISABLE_MAX_DURATION;
        } else if (500 > i2) {
            d = -0.75d;
            i3 = 55500;
        } else {
            d = -0.5d;
            i3 = 0;
        }
        return ((int) ((d * i2) + i3)) + i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String a(int i, double d, double d2) {
        a aVar;
        double d3;
        int i2;
        int i3;
        boolean z = true;
        int i4 = i * 5;
        char[] cArr = new char[i + 1];
        a aVar2 = new a(90.0d, -90.0d);
        a aVar3 = new a(180.0d, -180.0d);
        int i5 = 1;
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't wrap try/catch for region: R(23:21|22|(22:163|164|165|(0)|82|83|84|85|86|(0)|149|(0)|(0)|(0)|(0)|(0)|(0)|(0)|(0)|(0)(0)|121|122)|24|(0)|82|83|84|85|86|(0)|149|(0)|(0)|(0)|(0)|(0)|(0)|(0)|(0)|(0)(0)|121|122) */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x0274, code lost:
        r5 = null;
        r6 = null;
        r7 = null;
        r8 = null;
        r9 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:149:0x02f3  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x01ab A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0160 A[Catch: Exception -> 0x0273, all -> 0x02ac, TryCatch #4 {all -> 0x02ac, blocks: (B:58:0x015a, B:60:0x0160, B:62:0x0166, B:63:0x0170, B:64:0x017a, B:65:0x0184, B:66:0x018e, B:67:0x0198), top: B:164:0x015a }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01e0  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0210  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0220  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Address a(double d, double d2) {
        Cursor cursor;
        Cursor cursor2;
        String str;
        String str2;
        String str3;
        String str4;
        Cursor cursor3;
        Cursor cursor4;
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
        Cursor cursor5;
        Cursor cursor6;
        String str15;
        String str16;
        double c;
        String str17;
        String str18;
        try {
            cursor = this.KT.rawQuery(b.c.b(this.c, d, d2), null);
            try {
                try {
                    if (cursor.moveToFirst()) {
                        double d3 = Double.MAX_VALUE;
                        String str19 = null;
                        String str20 = null;
                        while (!cursor.isAfterLast()) {
                            try {
                                str16 = cursor.getString(2);
                                String string = cursor.getString(3);
                                c = c(d2, d, cursor.getDouble(5), cursor.getDouble(4));
                                if (c >= d3 || c > b.c.e) {
                                    c = d3;
                                    str17 = str19;
                                    str18 = str20;
                                } else {
                                    str17 = string;
                                    str18 = str16;
                                }
                            } catch (Exception e) {
                                cursor2 = cursor;
                                str = str19;
                                str2 = str20;
                            }
                            try {
                                cursor.moveToNext();
                                d3 = c;
                                str19 = str17;
                                str20 = str18;
                            } catch (Exception e2) {
                                str2 = str18;
                                str = str17;
                                cursor2 = cursor;
                                try {
                                    if (cursor2 != null) {
                                        try {
                                            cursor2.close();
                                            str3 = str;
                                            str4 = str2;
                                        } catch (Exception e3) {
                                            str3 = str;
                                            str4 = str2;
                                        }
                                        if (str3 == null) {
                                        }
                                        cursor3 = null;
                                        cursor3 = this.KT.rawQuery(b.a.b(this.c, d, d2), null);
                                        if (cursor3.moveToFirst()) {
                                        }
                                        str14 = null;
                                        str13 = null;
                                        str12 = null;
                                        str11 = null;
                                        str10 = null;
                                        str9 = null;
                                        if (cursor3 != null) {
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
                                        return new Address.Builder().country(str9).countryCode(str10).province(str11).city(str12).cityCode(str13).district(str14).street(str4).streetNumber(str3 != null ? new String(com.baidu.location.b.a.b.a(str3.getBytes())) : str3).build();
                                    }
                                    if (cursor3.moveToFirst()) {
                                    }
                                    str14 = null;
                                    str13 = null;
                                    str12 = null;
                                    str11 = null;
                                    str10 = null;
                                    str9 = null;
                                    if (cursor3 != null) {
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
                                    return new Address.Builder().country(str9).countryCode(str10).province(str11).city(str12).cityCode(str13).district(str14).street(str4).streetNumber(str3 != null ? new String(com.baidu.location.b.a.b.a(str3.getBytes())) : str3).build();
                                } catch (Throwable th2) {
                                    cursor4 = cursor3;
                                    th = th2;
                                    if (cursor4 != null) {
                                        try {
                                            cursor4.close();
                                        } catch (Exception e4) {
                                        }
                                    }
                                    throw th;
                                }
                                str3 = str;
                                str4 = str2;
                                if (str3 == null) {
                                }
                                cursor3 = null;
                                cursor3 = this.KT.rawQuery(b.a.b(this.c, d, d2), null);
                            }
                        }
                        str = str19;
                        str2 = str20;
                    } else {
                        str = null;
                        str2 = null;
                    }
                } catch (Exception e5) {
                    cursor2 = cursor;
                    str = null;
                    str2 = null;
                }
            } catch (Throwable th3) {
                th = th3;
                if (cursor != null) {
                    try {
                        cursor.close();
                    } catch (Exception e6) {
                    }
                }
                throw th;
            }
        } catch (Exception e7) {
            cursor2 = null;
            str = null;
            str2 = null;
        } catch (Throwable th4) {
            th = th4;
            cursor = null;
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
                        cursor5 = this.KT.rawQuery(b.b.b(this.c, d, d2), null);
                        try {
                            try {
                                if (cursor5.moveToFirst()) {
                                    double d4 = Double.MAX_VALUE;
                                    double[] coorEncrypt = Jni.coorEncrypt(d, d2, "wgs842mc");
                                    while (true) {
                                        try {
                                            str16 = str4;
                                            if (cursor5.isAfterLast()) {
                                                break;
                                            }
                                            String string2 = cursor5.getString(2);
                                            double[] coorEncrypt2 = Jni.coorEncrypt(cursor5.getDouble(3), cursor5.getDouble(4), "wgs842mc");
                                            double[] coorEncrypt3 = Jni.coorEncrypt(cursor5.getDouble(5), cursor5.getDouble(6), "wgs842mc");
                                            double a2 = a(coorEncrypt[0], coorEncrypt[1], coorEncrypt2[0], coorEncrypt2[1], coorEncrypt3[0], coorEncrypt3[1]);
                                            if (a2 >= d4 || a2 > b.b.e) {
                                                a2 = d4;
                                                str4 = str16;
                                            } else {
                                                str4 = string2;
                                            }
                                            cursor5.moveToNext();
                                            d4 = a2;
                                        } catch (Exception e9) {
                                            cursor6 = cursor5;
                                            str15 = str16;
                                            if (cursor6 != null) {
                                                try {
                                                    cursor6.close();
                                                    str4 = str15;
                                                } catch (Exception e10) {
                                                    str4 = str15;
                                                }
                                                cursor3 = null;
                                                cursor3 = this.KT.rawQuery(b.a.b(this.c, d, d2), null);
                                                if (cursor3.moveToFirst()) {
                                                }
                                                str14 = null;
                                                str13 = null;
                                                str12 = null;
                                                str11 = null;
                                                str10 = null;
                                                str9 = null;
                                                if (cursor3 != null) {
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
                                                return new Address.Builder().country(str9).countryCode(str10).province(str11).city(str12).cityCode(str13).district(str14).street(str4).streetNumber(str3 != null ? new String(com.baidu.location.b.a.b.a(str3.getBytes())) : str3).build();
                                            }
                                            str4 = str15;
                                            cursor3 = null;
                                            cursor3 = this.KT.rawQuery(b.a.b(this.c, d, d2), null);
                                            if (cursor3.moveToFirst()) {
                                            }
                                            str14 = null;
                                            str13 = null;
                                            str12 = null;
                                            str11 = null;
                                            str10 = null;
                                            str9 = null;
                                            if (cursor3 != null) {
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
                                            return new Address.Builder().country(str9).countryCode(str10).province(str11).city(str12).cityCode(str13).district(str14).street(str4).streetNumber(str3 != null ? new String(com.baidu.location.b.a.b.a(str3.getBytes())) : str3).build();
                                        }
                                    }
                                    str15 = str16;
                                } else {
                                    str15 = str4;
                                }
                                if (cursor5 != null) {
                                    try {
                                        cursor5.close();
                                        str4 = str15;
                                    } catch (Exception e11) {
                                        str4 = str15;
                                    }
                                }
                            } catch (Exception e12) {
                                cursor6 = cursor5;
                                str15 = str4;
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            if (cursor5 != null) {
                                try {
                                    cursor5.close();
                                } catch (Exception e13) {
                                }
                            }
                            throw th;
                        }
                    } catch (Exception e14) {
                        cursor6 = null;
                        str15 = str4;
                    } catch (Throwable th6) {
                        th = th6;
                        cursor5 = null;
                    }
                    str4 = str15;
                }
                cursor3 = null;
                cursor3 = this.KT.rawQuery(b.a.b(this.c, d, d2), null);
                if (cursor3.moveToFirst() || cursor3.isAfterLast()) {
                    str14 = null;
                    str13 = null;
                    str12 = null;
                    str11 = null;
                    str10 = null;
                    str9 = null;
                } else {
                    String str21 = cursor3.getString(cursor3.getColumnIndex("country"));
                    try {
                        str8 = cursor3.getString(cursor3.getColumnIndex("countrycode"));
                        try {
                            str7 = cursor3.getString(cursor3.getColumnIndex("province"));
                            try {
                                str6 = cursor3.getString(cursor3.getColumnIndex("city"));
                                try {
                                    str5 = cursor3.getString(cursor3.getColumnIndex("citycode"));
                                    try {
                                        str9 = str21;
                                        str10 = str8;
                                        str11 = str7;
                                        str12 = str6;
                                        str13 = str5;
                                        str14 = cursor3.getString(cursor3.getColumnIndex("district"));
                                    } catch (Exception e15) {
                                        if (cursor3 != null) {
                                            try {
                                                cursor3.close();
                                                str9 = str21;
                                                str10 = str8;
                                                str11 = str7;
                                                str12 = str6;
                                                str13 = str5;
                                                str14 = null;
                                            } catch (Exception e16) {
                                                str9 = str21;
                                                str10 = str8;
                                                str11 = str7;
                                                str12 = str6;
                                                str13 = str5;
                                                str14 = null;
                                            }
                                        } else {
                                            str9 = str21;
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
                                        return new Address.Builder().country(str9).countryCode(str10).province(str11).city(str12).cityCode(str13).district(str14).street(str4).streetNumber(str3 != null ? new String(com.baidu.location.b.a.b.a(str3.getBytes())) : str3).build();
                                    }
                                } catch (Exception e17) {
                                    str5 = null;
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
                if (cursor3 != null) {
                    try {
                        cursor3.close();
                    } catch (Exception e21) {
                    }
                }
                if (str9 != null) {
                    str9 = new String(com.baidu.location.b.a.b.a(str9.getBytes()));
                }
                if (str10 != null) {
                    str10 = new String(com.baidu.location.b.a.b.a(str10.getBytes()));
                }
                if (str11 != null) {
                    str11 = new String(com.baidu.location.b.a.b.a(str11.getBytes()));
                }
                if (str12 != null) {
                    str12 = new String(com.baidu.location.b.a.b.a(str12.getBytes()));
                }
                if (str13 != null) {
                    str13 = new String(com.baidu.location.b.a.b.a(str13.getBytes()));
                }
                if (str14 != null) {
                    str14 = new String(com.baidu.location.b.a.b.a(str14.getBytes()));
                }
                if (str4 != null) {
                    str4 = new String(com.baidu.location.b.a.b.a(str4.getBytes()));
                }
                return new Address.Builder().country(str9).countryCode(str10).province(str11).city(str12).cityCode(str13).district(str14).street(str4).streetNumber(str3 != null ? new String(com.baidu.location.b.a.b.a(str3.getBytes())) : str3).build();
            }
            cursor3 = this.KT.rawQuery(b.a.b(this.c, d, d2), null);
            if (cursor3.moveToFirst()) {
            }
            str14 = null;
            str13 = null;
            str12 = null;
            str11 = null;
            str10 = null;
            str9 = null;
            if (cursor3 != null) {
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
            return new Address.Builder().country(str9).countryCode(str10).province(str11).city(str12).cityCode(str13).district(str14).street(str4).streetNumber(str3 != null ? new String(com.baidu.location.b.a.b.a(str3.getBytes())) : str3).build();
        } catch (Throwable th7) {
            cursor4 = null;
            th = th7;
        }
        str3 = str;
        str4 = str2;
        if (str3 == null) {
        }
        cursor3 = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(JSONObject jSONObject) {
        b[] a2;
        if (this.KT == null || !this.KT.isOpen()) {
            return;
        }
        try {
            this.KT.beginTransaction();
            for (b bVar : b.a()) {
                if (jSONObject.has(bVar.g)) {
                    String string = jSONObject.has(bVar.h) ? jSONObject.getString(bVar.h) : "";
                    ArrayList<String> arrayList = new ArrayList();
                    JSONObject jSONObject2 = jSONObject.getJSONObject(bVar.g);
                    arrayList.add(bVar.a(jSONObject2));
                    arrayList.addAll(bVar.a(jSONObject2, string, bVar.i));
                    for (String str : arrayList) {
                        this.KT.execSQL(str);
                    }
                }
            }
            this.KT.setTransactionSuccessful();
            this.e = -1;
            this.f = -1;
            try {
                this.KT.endTransaction();
            } catch (Exception e) {
            }
        } catch (Exception e2) {
            try {
                this.KT.endTransaction();
            } catch (Exception e3) {
            }
        } catch (Throwable th) {
            try {
                this.KT.endTransaction();
            } catch (Exception e4) {
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a() {
        Cursor cursor;
        Cursor cursor2 = null;
        if (this.Kj.mO().l() && this.f == -1 && this.e == -1 && this.KT != null && this.KT.isOpen()) {
            try {
                cursor = this.KT.rawQuery("SELECT COUNT(*) FROM RGCSITE;", null);
                try {
                    cursor.moveToFirst();
                    this.f = cursor.getInt(0);
                    cursor2 = this.KT.rawQuery("SELECT COUNT(*) FROM RGCAREA;", null);
                    cursor2.moveToFirst();
                    this.e = cursor2.getInt(0);
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
                    return this.f != 0 ? false : false;
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
        }
        if (this.f != 0 && this.e == 0) {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0087, code lost:
        if (r2 > r12) goto L23;
     */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0097  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<Poi> b(double d, double d2) {
        Cursor cursor;
        Cursor cursor2;
        Poi poi;
        ArrayList arrayList = new ArrayList();
        Poi poi2 = null;
        int i = 0;
        try {
            cursor = this.KT.rawQuery(b.d.b(this.c, d, d2), null);
            try {
                try {
                    if (cursor.moveToFirst()) {
                        while (true) {
                            try {
                                int i2 = i;
                                poi = poi2;
                                if (cursor.isAfterLast()) {
                                    break;
                                }
                                String string = cursor.getString(0);
                                String string2 = cursor.getString(2);
                                double d3 = cursor.getDouble(4);
                                double d4 = cursor.getDouble(5);
                                int i3 = cursor.getInt(6);
                                double c = c(d2, d, d4, d3);
                                if (c < b.d.e) {
                                    poi2 = new Poi(new String(com.baidu.location.b.a.b.a(string.getBytes())), new String(com.baidu.location.b.a.b.a(string2.getBytes())), 1.0d);
                                    i = a(i3, Math.round((float) c));
                                }
                                i = i2;
                                poi2 = poi;
                                cursor.moveToNext();
                            } catch (Exception e) {
                                poi2 = poi;
                                cursor2 = cursor;
                                if (cursor2 != null) {
                                    try {
                                        cursor2.close();
                                    } catch (Exception e2) {
                                    }
                                }
                                if (poi2 != null) {
                                }
                                return arrayList;
                            }
                        }
                        poi2 = poi;
                    }
                    if (cursor != null) {
                        try {
                            cursor.close();
                        } catch (Exception e3) {
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    if (cursor != null) {
                        try {
                            cursor.close();
                        } catch (Exception e4) {
                        }
                    }
                    throw th;
                }
            } catch (Exception e5) {
                cursor2 = cursor;
            }
        } catch (Exception e6) {
            cursor2 = null;
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
        }
        if (poi2 != null) {
            arrayList.add(poi2);
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
            if (this.KT != null && this.KT.isOpen()) {
                JSONArray jSONArray = new JSONArray();
                JSONArray jSONArray2 = new JSONArray();
                JSONArray jSONArray3 = new JSONArray();
                JSONArray jSONArray4 = new JSONArray();
                cursor2 = this.KT.rawQuery(String.format("SELECT * FROM RGCUPDATE WHERE type=%d AND %d > timestamp+%d ORDER BY gridkey", 0, Integer.valueOf(currentTimeMillis), Integer.valueOf(this.Kj.mO().p())), null);
                cursor = this.KT.rawQuery(String.format("SELECT * FROM RGCUPDATE WHERE type=%d AND %d > timestamp+%d ORDER BY gridkey", 1, Integer.valueOf(currentTimeMillis), Integer.valueOf(this.Kj.mO().q())), null);
                if (cursor2.moveToFirst()) {
                    HashSet hashSet = new HashSet();
                    while (!cursor2.isAfterLast()) {
                        String string = cursor2.getString(0);
                        String string2 = cursor2.getString(1);
                        jSONArray3.put(string);
                        hashSet.add(string2);
                        if (stringBuffer2.length() > 0) {
                            stringBuffer2.append(",");
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
                            stringBuffer.append(",");
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
                this.KT.execSQL(String.format(Locale.US, "UPDATE RGCUPDATE SET timestamp=timestamp+1 WHERE type = %d AND gridkey IN (%s)", 0, stringBuffer2.toString()));
            }
            if (stringBuffer.length() > 0) {
                this.KT.execSQL(String.format(Locale.US, "UPDATE RGCUPDATE SET timestamp=timestamp+1 WHERE type = %d AND gridkey IN (%s)", 1, stringBuffer.toString()));
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
