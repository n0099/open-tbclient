package com.baidu.location;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.location.Location;
import android.net.wifi.ScanResult;
import android.os.AsyncTask;
import android.os.Message;
import com.baidu.location.au;
import com.baidu.location.u;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import java.io.File;
import java.util.Iterator;
import java.util.Locale;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a1 implements a0, n {
    private static a1 iR = null;
    private String jb = null;
    private boolean i3 = false;
    private boolean i9 = false;
    private boolean iS = false;
    private String iT = null;
    private int i7 = 0;
    private double i0 = 0.0d;
    private double iZ = 0.0d;
    private double i4 = 0.0d;
    private double iX = 0.0d;
    private double iW = 0.0d;
    private long iU = 0;
    private boolean i1 = false;
    private volatile boolean i5 = false;
    private final int iV = 6;
    private final int ja = 10000;
    private final String iY = "bdcltb09";
    private final String i8 = "wof";
    private final String i6 = I + "/ls.db";
    private boolean i2 = true;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends AsyncTask {
        private a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public Boolean doInBackground(Boolean... boolArr) {
            SQLiteDatabase sQLiteDatabase = null;
            if (boolArr.length != 4) {
                return false;
            }
            try {
                sQLiteDatabase = SQLiteDatabase.openOrCreateDatabase(a1.this.i6, (SQLiteDatabase.CursorFactory) null);
            } catch (Exception e) {
            }
            if (sQLiteDatabase == null) {
                return false;
            }
            int currentTimeMillis = (int) (System.currentTimeMillis() >> 28);
            try {
                sQLiteDatabase.beginTransaction();
                if (boolArr[0].booleanValue()) {
                    try {
                        sQLiteDatabase.execSQL("delete from wof where ac < " + (currentTimeMillis - 35));
                    } catch (Exception e2) {
                    }
                }
                if (boolArr[1].booleanValue()) {
                    try {
                        sQLiteDatabase.execSQL("delete from bdcltb09 where ac is NULL or ac < " + (currentTimeMillis - 130));
                    } catch (Exception e3) {
                    }
                }
                sQLiteDatabase.setTransactionSuccessful();
                sQLiteDatabase.endTransaction();
                sQLiteDatabase.close();
            } catch (Exception e4) {
            }
            return true;
        }
    }

    /* loaded from: classes.dex */
    private class b extends AsyncTask {
        private b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public Boolean doInBackground(Object... objArr) {
            SQLiteDatabase sQLiteDatabase;
            if (objArr.length != 4) {
                a1.this.i5 = false;
                return false;
            }
            try {
                sQLiteDatabase = SQLiteDatabase.openOrCreateDatabase(a1.this.i6, (SQLiteDatabase.CursorFactory) null);
            } catch (Exception e) {
                sQLiteDatabase = null;
            }
            if (sQLiteDatabase == null) {
                a1.this.i5 = false;
                return false;
            }
            try {
                sQLiteDatabase.beginTransaction();
                a1.this.m74if((String) objArr[0], (u.a) objArr[1], sQLiteDatabase);
                a1.this.m73if((au.b) objArr[2], (BDLocation) objArr[3], sQLiteDatabase);
                sQLiteDatabase.setTransactionSuccessful();
                sQLiteDatabase.endTransaction();
                sQLiteDatabase.close();
            } catch (Exception e2) {
            }
            a1.this.i5 = false;
            return true;
        }
    }

    private a1() {
        try {
            cw();
        } catch (Exception e) {
        }
    }

    /* renamed from: byte  reason: not valid java name */
    private String m67byte(boolean z) {
        double d = 0.0d;
        double d2 = 0.0d;
        double d3 = 0.0d;
        boolean z2 = false;
        boolean z3 = false;
        if (this.i9) {
            z2 = true;
            d = this.iX;
            d2 = this.iW;
            d3 = 246.4d;
            z3 = true;
        } else if (this.i3) {
            z2 = true;
            d = this.i0;
            d2 = this.iZ;
            d3 = this.i4;
            z3 = ak.aF().aH();
        }
        if (!z2) {
            return z ? "{\"result\":{\"time\":\"" + c.m278try() + "\",\"error\":\"67\"}}" : "{\"result\":{\"time\":\"" + c.m278try() + "\",\"error\":\"63\"}}";
        } else if (z) {
            return String.format(Locale.CHINA, "{\"result\":{\"time\":\"" + c.m278try() + "\",\"error\":\"66\"},\"content\":{\"point\":{\"x\":\"%f\",\"y\":\"%f\"},\"radius\":\"%f\",\"isCellChanged\":\"%b\"}}", Double.valueOf(d), Double.valueOf(d2), Double.valueOf(d3), true);
        } else {
            return String.format(Locale.CHINA, "{\"result\":{\"time\":\"" + c.m278try() + "\",\"error\":\"68\"},\"content\":{\"point\":{\"x\":\"%f\",\"y\":\"%f\"},\"radius\":\"%f\",\"isCellChanged\":\"%b\"}}", Double.valueOf(d), Double.valueOf(d2), Double.valueOf(d3), Boolean.valueOf(z3));
        }
    }

    public static a1 ct() {
        if (iR == null) {
            iR = new a1();
        }
        return iR;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cu() {
        SQLiteDatabase sQLiteDatabase;
        try {
            sQLiteDatabase = SQLiteDatabase.openOrCreateDatabase(this.i6, (SQLiteDatabase.CursorFactory) null);
        } catch (Exception e) {
            sQLiteDatabase = null;
        }
        if (sQLiteDatabase == null) {
            return;
        }
        long queryNumEntries = DatabaseUtils.queryNumEntries(sQLiteDatabase, "wof");
        long queryNumEntries2 = DatabaseUtils.queryNumEntries(sQLiteDatabase, "bdcltb09");
        boolean z = queryNumEntries > 10000;
        boolean z2 = queryNumEntries2 > 10000;
        if (z || z2) {
            new a().execute(Boolean.valueOf(z), Boolean.valueOf(z2));
        }
        sQLiteDatabase.close();
    }

    private void cv() {
        u.a at = u.au().at();
        if (at != null) {
            s(at.m353case());
        }
        m69for(au.cc().b7());
    }

    private void cw() {
        try {
            File file = new File(I);
            File file2 = new File(this.i6);
            if (!file.exists()) {
                file.mkdirs();
            }
            if (!file2.exists()) {
                file2.createNewFile();
            }
            if (file2.exists()) {
                SQLiteDatabase openOrCreateDatabase = SQLiteDatabase.openOrCreateDatabase(file2, (SQLiteDatabase.CursorFactory) null);
                openOrCreateDatabase.execSQL("CREATE TABLE IF NOT EXISTS bdcltb09(id CHAR(40) PRIMARY KEY,time DOUBLE,tag DOUBLE, type DOUBLE , ac INT);");
                openOrCreateDatabase.execSQL("CREATE TABLE IF NOT EXISTS wof(id CHAR(15) PRIMARY KEY,mktime DOUBLE,time DOUBLE, ac INT, bc INT, cc INT);");
                openOrCreateDatabase.setVersion(1);
                openOrCreateDatabase.close();
            }
        } catch (Exception e) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:91:0x010a A[SYNTHETIC] */
    /* renamed from: for  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void m69for(au.b bVar) {
        SQLiteDatabase sQLiteDatabase;
        int i;
        double[] dArr;
        boolean z;
        int i2;
        double d;
        double d2;
        Cursor rawQuery;
        float[] fArr;
        boolean z2;
        int i3;
        double d3;
        System.currentTimeMillis();
        this.i9 = false;
        if (bVar.f74for == null) {
            return;
        }
        try {
            sQLiteDatabase = SQLiteDatabase.openOrCreateDatabase(this.i6, (SQLiteDatabase.CursorFactory) null);
        } catch (Exception e) {
            sQLiteDatabase = null;
        }
        if (sQLiteDatabase == null || bVar == null) {
            return;
        }
        Iterator it = bVar.f74for.iterator();
        int i4 = 0;
        double[] dArr2 = null;
        boolean z3 = false;
        int i5 = 0;
        double d4 = 0.0d;
        double d5 = 0.0d;
        int i6 = 0;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            ScanResult scanResult = (ScanResult) it.next();
            int i7 = i6 + 1;
            if (i7 > 10) {
                break;
            }
            try {
                rawQuery = sQLiteDatabase.rawQuery("select * from wof where id = \"" + Jni.k(scanResult.BSSID.replace(":", "")) + "\";", null);
            } catch (Exception e2) {
                i = i4;
                dArr = dArr2;
                z = z3;
                i2 = i5;
                d = d4;
                d2 = d5;
            }
            if (rawQuery.moveToFirst()) {
                double d6 = rawQuery.getDouble(1) - 113.2349d;
                double d7 = rawQuery.getDouble(2) - 432.1238d;
                rawQuery.getInt(3);
                int i8 = rawQuery.getInt(4);
                int i9 = rawQuery.getInt(5);
                rawQuery.close();
                if (i9 > 8 && i9 > i8) {
                    i6 = i7;
                } else if (this.i3) {
                    Location.distanceBetween(d7, d6, this.iZ, this.i0, new float[1]);
                    if (fArr[0] > this.i4 + 2000.0d) {
                        i6 = i7;
                    } else {
                        double d8 = d5 + d6;
                        double d9 = d4 + d7;
                        i = i4;
                        dArr = dArr2;
                        z = true;
                        i2 = i5 + 1;
                        d = d9;
                        d2 = d8;
                        if (i2 > 4) {
                            i5 = i2;
                            d4 = d;
                            d5 = d2;
                            break;
                        }
                        i4 = i;
                        dArr2 = dArr;
                        z3 = z;
                        i5 = i2;
                        d4 = d;
                        d5 = d2;
                        i6 = i7;
                    }
                } else {
                    if (z3) {
                        float[] fArr2 = new float[1];
                        Location.distanceBetween(d7, d6, d4 / i5, d5 / i5, fArr2);
                        if (fArr2[0] > 1000.0f) {
                            i6 = i7;
                        } else {
                            i = i4;
                            dArr = dArr2;
                            z = z3;
                            i2 = i5;
                            d = d4;
                            d2 = d5;
                        }
                    } else if (dArr2 == null) {
                        double[] dArr3 = new double[8];
                        int i10 = i4 + 1;
                        try {
                            dArr3[i4] = d6;
                            int i11 = i10 + 1;
                            dArr3[i10] = d7;
                            i = i11;
                            dArr = dArr3;
                            z = z3;
                            i2 = i5;
                            d = d4;
                            d2 = d5;
                        } catch (Exception e3) {
                            i = i10;
                            dArr = dArr3;
                            z = z3;
                            i2 = i5;
                            d2 = d5;
                            d = d4;
                        }
                    } else {
                        int i12 = 0;
                        while (i12 < i4) {
                            float[] fArr3 = new float[1];
                            Location.distanceBetween(d7, d6, dArr2[i12 + 1], dArr2[i12], fArr3);
                            if (fArr3[0] < 1000.0f) {
                                z2 = true;
                                try {
                                    d5 += dArr2[i12];
                                    d3 = d4 + dArr2[i12 + 1];
                                    i3 = i5 + 1;
                                } catch (Exception e4) {
                                    i = i4;
                                    dArr = dArr2;
                                    z = true;
                                    i2 = i5;
                                    d2 = d5;
                                    d = d4;
                                }
                            } else {
                                z2 = z3;
                                i3 = i5;
                                d3 = d4;
                            }
                            i12 += 2;
                            d4 = d3;
                            d5 = d5;
                            z3 = z2;
                            i5 = i3;
                        }
                        if (z3) {
                            double d10 = d5 + d6;
                            double d11 = d4 + d7;
                            i = i4;
                            dArr = dArr2;
                            z = z3;
                            i2 = i5 + 1;
                            d = d11;
                            d2 = d10;
                        } else if (i4 >= 8) {
                            sQLiteDatabase.close();
                            return;
                        } else {
                            int i13 = i4 + 1;
                            dArr2[i4] = d6;
                            int i14 = i13 + 1;
                            dArr2[i13] = d7;
                            i = i14;
                            dArr = dArr2;
                            z = z3;
                            i2 = i5;
                            d = d4;
                            d2 = d5;
                        }
                    }
                    if (i2 > 4) {
                    }
                    i4 = i;
                    dArr2 = dArr;
                    z3 = z;
                    i5 = i2;
                    d4 = d;
                    d5 = d2;
                    i6 = i7;
                }
            } else {
                rawQuery.close();
                i6 = i7;
            }
        }
        if (i5 > 0) {
            this.i9 = true;
            this.iX = d5 / i5;
            this.iW = d4 / i5;
        }
        sQLiteDatabase.close();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: if  reason: not valid java name */
    public void m73if(au.b bVar, BDLocation bDLocation, SQLiteDatabase sQLiteDatabase) {
        int i;
        int i2;
        double d;
        boolean z;
        double d2;
        if (bDLocation == null || bDLocation.getLocType() != 161) {
            return;
        }
        if (("wf".equals(bDLocation.getNetworkLocationType()) || bDLocation.getRadius() < 300.0f) && bVar.f74for != null) {
            int currentTimeMillis = (int) (System.currentTimeMillis() >> 28);
            System.currentTimeMillis();
            int i3 = 0;
            for (ScanResult scanResult : bVar.f74for) {
                if (scanResult.level != 0) {
                    int i4 = i3 + 1;
                    if (i4 > 6) {
                        return;
                    }
                    ContentValues contentValues = new ContentValues();
                    String k = Jni.k(scanResult.BSSID.replace(":", ""));
                    try {
                        Cursor rawQuery = sQLiteDatabase.rawQuery("select * from wof where id = \"" + k + "\";", null);
                        if (rawQuery == null || !rawQuery.moveToFirst()) {
                            i = 0;
                            i2 = 0;
                            d = 0.0d;
                            z = false;
                            d2 = 0.0d;
                        } else {
                            double d3 = rawQuery.getDouble(1) - 113.2349d;
                            rawQuery.getInt(3);
                            int i5 = rawQuery.getInt(4);
                            i = rawQuery.getInt(5);
                            i2 = i5;
                            d2 = rawQuery.getDouble(2) - 432.1238d;
                            z = true;
                            d = d3;
                        }
                        rawQuery.close();
                        if (!z) {
                            contentValues.put("mktime", Double.valueOf(bDLocation.getLongitude() + 113.2349d));
                            contentValues.put(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, Double.valueOf(bDLocation.getLatitude() + 432.1238d));
                            contentValues.put("bc", (Integer) 1);
                            contentValues.put("cc", (Integer) 1);
                            contentValues.put("ac", Integer.valueOf(currentTimeMillis));
                            contentValues.put("id", k);
                            sQLiteDatabase.insert("wof", null, contentValues);
                        } else if (i == 0) {
                            i3 = i4;
                        } else {
                            float[] fArr = new float[1];
                            Location.distanceBetween(d2, d, bDLocation.getLatitude(), bDLocation.getLongitude(), fArr);
                            if (fArr[0] > 1500.0f) {
                                int i6 = i + 1;
                                if (i6 <= 10 || i6 <= i2 * 3) {
                                    contentValues.put("cc", Integer.valueOf(i6));
                                } else {
                                    contentValues.put("mktime", Double.valueOf(bDLocation.getLongitude() + 113.2349d));
                                    contentValues.put(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, Double.valueOf(bDLocation.getLatitude() + 432.1238d));
                                    contentValues.put("bc", (Integer) 1);
                                    contentValues.put("cc", (Integer) 1);
                                    contentValues.put("ac", Integer.valueOf(currentTimeMillis));
                                }
                            } else {
                                contentValues.put("mktime", Double.valueOf((((d * i2) + bDLocation.getLongitude()) / (i2 + 1)) + 113.2349d));
                                contentValues.put(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, Double.valueOf((((d2 * i2) + bDLocation.getLatitude()) / (i2 + 1)) + 432.1238d));
                                contentValues.put("bc", Integer.valueOf(i2 + 1));
                                contentValues.put("ac", Integer.valueOf(currentTimeMillis));
                            }
                            try {
                                if (sQLiteDatabase.update("wof", contentValues, "id = \"" + k + "\"", null) <= 0) {
                                }
                            } catch (Exception e) {
                            }
                        }
                    } catch (Exception e2) {
                    }
                    i3 = i4;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: if  reason: not valid java name */
    public void m74if(String str, u.a aVar, SQLiteDatabase sQLiteDatabase) {
        if (aVar.a() && ak.aF().aH()) {
            System.currentTimeMillis();
            double d = 0.0d;
            double d2 = 0.0d;
            float f = 0.0f;
            int currentTimeMillis = (int) (System.currentTimeMillis() >> 28);
            String m353case = aVar.m353case();
            boolean z = true;
            try {
                JSONObject jSONObject = new JSONObject(str);
                int parseInt = Integer.parseInt(jSONObject.getJSONObject("result").getString("error"));
                if (parseInt == 161) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT);
                    if (jSONObject2.has("clf")) {
                        z = false;
                        String string = jSONObject2.getString("clf");
                        if (string.equals("0")) {
                            JSONObject jSONObject3 = jSONObject2.getJSONObject("point");
                            d = Double.parseDouble(jSONObject3.getString("x"));
                            d2 = Double.parseDouble(jSONObject3.getString("y"));
                            f = Float.parseFloat(jSONObject2.getString("radius"));
                        } else {
                            String[] split = string.split("\\|");
                            d = Double.parseDouble(split[0]);
                            d2 = Double.parseDouble(split[1]);
                            f = Float.parseFloat(split[2]);
                        }
                    }
                } else if (parseInt == 167) {
                    sQLiteDatabase.delete("bdcltb09", "id = \"" + m353case + "\"", null);
                    return;
                }
                if (z) {
                    return;
                }
                float f2 = 4326.0f + f;
                ContentValues contentValues = new ContentValues();
                contentValues.put(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, Double.valueOf(d + 1235.4323d));
                contentValues.put("tag", Float.valueOf(f2));
                contentValues.put("type", Double.valueOf(d2 + 2367.3217d));
                contentValues.put("ac", Integer.valueOf(currentTimeMillis));
                try {
                    if (sQLiteDatabase.update("bdcltb09", contentValues, "id = \"" + m353case + "\"", null) <= 0) {
                        contentValues.put("id", m353case);
                        sQLiteDatabase.insert("bdcltb09", null, contentValues);
                    }
                } catch (Exception e) {
                }
            } catch (Exception e2) {
            }
        }
    }

    private void k(Message message) {
        k.q().m303if(m76case(true), message);
    }

    private void s(String str) {
        SQLiteDatabase sQLiteDatabase = null;
        if (str == null || str.equals(this.jb)) {
            return;
        }
        try {
            sQLiteDatabase = SQLiteDatabase.openOrCreateDatabase(this.i6, (SQLiteDatabase.CursorFactory) null);
        } catch (Exception e) {
        }
        if (sQLiteDatabase == null || str == null) {
            this.i3 = false;
            return;
        }
        this.i3 = false;
        try {
            Cursor rawQuery = sQLiteDatabase.rawQuery("select * from bdcltb09 where id = \"" + str + "\";", null);
            this.jb = str;
            this.iU = System.currentTimeMillis();
            if (rawQuery != null) {
                if (rawQuery.moveToFirst()) {
                    this.i0 = rawQuery.getDouble(1) - 1235.4323d;
                    this.i4 = rawQuery.getDouble(2) - 4326.0d;
                    this.iZ = rawQuery.getDouble(3) - 2367.3217d;
                    this.i3 = true;
                }
                rawQuery.close();
            }
        } catch (Exception e2) {
        }
        sQLiteDatabase.close();
    }

    /* renamed from: case  reason: not valid java name */
    public BDLocation m76case(boolean z) {
        cv();
        return new BDLocation(m67byte(z));
    }

    public void cx() {
    }

    public void cy() {
        this.i2 = true;
        ad.br().postDelayed(new Runnable() { // from class: com.baidu.location.a1.1
            @Override // java.lang.Runnable
            public void run() {
                if (ad.gO) {
                    a1.this.cu();
                }
            }
        }, 3000L);
    }

    /* renamed from: if  reason: not valid java name */
    public void m77if(String str, u.a aVar, au.b bVar, BDLocation bDLocation) {
        boolean z = (aVar.a() && ak.aF().aH()) ? false : true;
        boolean z2 = bDLocation == null || bDLocation.getLocType() != 161 || (!"wf".equals(bDLocation.getNetworkLocationType()) && bDLocation.getRadius() >= 300.0f);
        if (bVar.f74for == null) {
            z2 = true;
        }
        if ((z && z2) || this.i5) {
            return;
        }
        this.i5 = true;
        new b().execute(str, aVar, bVar, bDLocation);
    }

    public void j(Message message) {
        k(message);
    }
}
