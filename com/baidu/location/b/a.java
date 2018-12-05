package com.baidu.location.b;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.android.bbalbs.common.security.Base64;
import com.baidu.location.BDLocation;
import com.baidu.location.Jni;
import com.baidu.location.g.g;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.io.File;
import java.util.HashMap;
import java.util.Locale;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a {
    private static Object b = new Object();
    private static a aej = null;
    private static final String d = g.h() + "/gal.db";
    private SQLiteDatabase aek = null;
    private boolean f = false;
    C0084a ael = null;
    private String g = null;
    private double h = Double.MAX_VALUE;
    private double ado = Double.MAX_VALUE;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.location.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C0084a extends com.baidu.location.g.e {
        int a;
        int b;
        int c;
        int d;
        double e;

        C0084a() {
            this.k = new HashMap();
        }

        @Override // com.baidu.location.g.e
        public void a() {
            String str;
            this.h = "http://loc.map.baidu.com/gpsz";
            String format = String.format(Locale.CHINESE, "&x=%d&y=%d%s", Integer.valueOf(this.a), Integer.valueOf(this.b), com.baidu.location.g.b.tV().c());
            String encode = Jni.encode(format);
            if (!encode.contains("err!")) {
                this.k.put("gpsz", encode);
                return;
            }
            try {
                str = Base64.encode(format.toString().getBytes(), "UTF-8");
            } catch (Exception e) {
                str = "err2!";
            }
            this.k.put("gpszb", str);
        }

        public void a(double d, double d2, double d3) {
            if (a.this.f) {
                return;
            }
            double[] coorEncrypt = Jni.coorEncrypt(d, d2, "gcj2wgs");
            this.a = (int) Math.floor(coorEncrypt[0] * 100.0d);
            this.b = (int) Math.floor(coorEncrypt[1] * 100.0d);
            this.c = (int) Math.floor(d * 100.0d);
            this.d = (int) Math.floor(d2 * 100.0d);
            this.e = d3;
            a.this.f = true;
            e();
        }

        @Override // com.baidu.location.g.e
        public void a(boolean z) {
            if (z && this.j != null) {
                try {
                    JSONObject jSONObject = new JSONObject(this.j);
                    if (jSONObject != null && jSONObject.has("height")) {
                        String string = jSONObject.getString("height");
                        if (string.contains(",")) {
                            String[] split = string.trim().split(",");
                            int length = split.length;
                            int sqrt = (int) Math.sqrt(length);
                            if (sqrt * sqrt == length) {
                                int i = this.c - ((sqrt - 1) / 2);
                                int i2 = this.d - ((sqrt - 1) / 2);
                                for (int i3 = 0; i3 < sqrt; i3++) {
                                    for (int i4 = 0; i4 < sqrt; i4++) {
                                        ContentValues contentValues = new ContentValues();
                                        if (split[(i3 * sqrt) + i4].contains("E")) {
                                            contentValues.put("aldata", Double.valueOf(10000.0d));
                                            contentValues.put("sigma", Double.valueOf(10000.0d));
                                        } else if (split[(i3 * sqrt) + i4].contains(":")) {
                                            String[] split2 = split[(i3 * sqrt) + i4].split(":");
                                            if (split2.length == 2) {
                                                contentValues.put("aldata", Double.valueOf(split2[0]));
                                                contentValues.put("sigma", split2[1]);
                                            } else {
                                                contentValues.put("aldata", Double.valueOf(10000.0d));
                                                contentValues.put("sigma", Double.valueOf(10000.0d));
                                            }
                                        } else {
                                            contentValues.put("aldata", Double.valueOf(split[(i3 * sqrt) + i4]));
                                            contentValues.put("sigma", Double.valueOf(10000.0d));
                                        }
                                        contentValues.put(PushConstants.PUSH_NOTIFICATION_CREATE_TIMES_TAMP, Integer.valueOf((int) (System.currentTimeMillis() / 1000)));
                                        String format = String.format(Locale.CHINESE, "%d,%d", Integer.valueOf(i + i4), Integer.valueOf(i2 + i3));
                                        try {
                                            if (a.this.aek.update("galdata_new", contentValues, "id = \"" + format + "\"", null) <= 0) {
                                                contentValues.put("id", format);
                                                a.this.aek.insert("galdata_new", null, contentValues);
                                            }
                                        } catch (Exception e) {
                                        }
                                    }
                                }
                            }
                        }
                    }
                } catch (Exception e2) {
                }
            }
            if (this.k != null) {
                this.k.clear();
            }
            a.this.f = false;
        }
    }

    private void a(double d2, double d3, double d4) {
        if (this.ael == null) {
            this.ael = new C0084a();
        }
        this.ael.a(d2, d3, d4);
    }

    public static a tt() {
        a aVar;
        synchronized (b) {
            if (aej == null) {
                aej = new a();
            }
            aVar = aej;
        }
        return aVar;
    }

    public void b() {
        try {
            File file = new File(d);
            if (!file.exists()) {
                file.createNewFile();
            }
            if (file.exists()) {
                this.aek = SQLiteDatabase.openOrCreateDatabase(file, (SQLiteDatabase.CursorFactory) null);
                Cursor rawQuery = this.aek.rawQuery("SELECT count(*) FROM sqlite_master WHERE type='table' AND name='galdata'", null);
                if (rawQuery.moveToFirst()) {
                    if (rawQuery.getInt(0) == 0) {
                        this.aek.execSQL("CREATE TABLE IF NOT EXISTS galdata_new(id CHAR(40) PRIMARY KEY,aldata DOUBLE, sigma DOUBLE,tt INT);");
                    } else {
                        this.aek.execSQL("DROP TABLE galdata");
                        this.aek.execSQL("CREATE TABLE galdata_new(id CHAR(40) PRIMARY KEY,aldata DOUBLE, sigma DOUBLE,tt INT);");
                    }
                }
                this.aek.setVersion(1);
                rawQuery.close();
            }
        } catch (Exception e) {
            this.aek = null;
        }
    }

    public void c() {
        if (this.aek != null) {
            try {
                this.aek.close();
            } catch (Exception e) {
            } finally {
                this.aek = null;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0100 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public double[] c(double d2, double d3) {
        double d4;
        double d5;
        Cursor cursor;
        Throwable th;
        double[] dArr = new double[2];
        if (this.aek == null || d2 <= 0.1d || d3 <= 0.1d) {
            d4 = Double.MAX_VALUE;
            d5 = Double.MAX_VALUE;
        } else {
            Cursor cursor2 = null;
            String format = String.format(Locale.CHINESE, "%d,%d", Integer.valueOf((int) Math.floor(100.0d * d2)), Integer.valueOf((int) Math.floor(100.0d * d3)));
            if (this.g == null || !this.g.equals(format)) {
                try {
                    try {
                        cursor2 = this.aek.rawQuery("select * from galdata_new where id = \"" + format + "\";", null);
                        if (cursor2 != null) {
                            try {
                                if (cursor2.moveToFirst()) {
                                    d5 = cursor2.getDouble(1);
                                    try {
                                        d4 = cursor2.getDouble(2);
                                        try {
                                            int i = cursor2.getInt(3);
                                            double d6 = d5 == 10000.0d ? Double.MAX_VALUE : d5;
                                            double d7 = d4 <= 0.0d ? Double.MAX_VALUE : d4;
                                            long currentTimeMillis = (System.currentTimeMillis() / 1000) - i;
                                            if (!this.f && currentTimeMillis > 604800) {
                                                a(d2, d3, 7.800000190734863d);
                                            }
                                            this.g = format;
                                            this.h = d6;
                                            this.ado = d7;
                                            d4 = d7;
                                            d5 = d6;
                                            if (cursor2 != null) {
                                                try {
                                                    cursor2.close();
                                                } catch (Exception e) {
                                                }
                                            }
                                        } catch (Exception e2) {
                                            if (cursor2 != null) {
                                                try {
                                                    cursor2.close();
                                                } catch (Exception e3) {
                                                }
                                            }
                                            if (d5 <= 10000.0d) {
                                            }
                                            if (d4 <= 10000.0d) {
                                            }
                                            return dArr;
                                        }
                                    } catch (Exception e4) {
                                        d4 = Double.MAX_VALUE;
                                    }
                                }
                            } catch (Throwable th2) {
                                cursor = cursor2;
                                th = th2;
                                if (cursor != null) {
                                    try {
                                        cursor.close();
                                    } catch (Exception e5) {
                                    }
                                }
                                throw th;
                            }
                        }
                        if (!this.f) {
                            a(d2, d3, 7.800000190734863d);
                        }
                        d4 = Double.MAX_VALUE;
                        d5 = Double.MAX_VALUE;
                        if (cursor2 != null) {
                        }
                    } catch (Exception e6) {
                        d4 = Double.MAX_VALUE;
                        d5 = Double.MAX_VALUE;
                    }
                } catch (Throwable th3) {
                    cursor = null;
                    th = th3;
                }
            } else {
                d5 = this.h;
                d4 = this.ado;
            }
        }
        if (d5 <= 10000.0d) {
            dArr[0] = 10000.0d;
        } else {
            dArr[0] = d5;
        }
        if (d4 <= 10000.0d) {
            dArr[1] = 10000.0d;
        } else {
            dArr[1] = d4;
        }
        return dArr;
    }

    public int e(BDLocation bDLocation) {
        double d2;
        float f;
        if (bDLocation != null) {
            f = bDLocation.getRadius();
            d2 = bDLocation.getAltitude();
        } else {
            d2 = 0.0d;
            f = 0.0f;
        }
        if (this.aek != null && f > 0.0f && d2 > 0.0d && bDLocation != null) {
            double d3 = c(bDLocation.getLongitude(), bDLocation.getLatitude())[0];
            if (d3 != Double.MAX_VALUE) {
                double gpsSwiftRadius = Jni.getGpsSwiftRadius(f, d2, d3);
                if (gpsSwiftRadius > 50.0d) {
                    return 3;
                }
                return gpsSwiftRadius > 20.0d ? 2 : 1;
            }
        }
        return 0;
    }
}
