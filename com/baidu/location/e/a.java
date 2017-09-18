package com.baidu.location.e;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.location.Location;
import android.net.wifi.ScanResult;
import android.os.AsyncTask;
import android.os.Environment;
import android.os.Handler;
import com.baidu.location.BDLocation;
import com.baidu.location.Jni;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class a {
    private static a MM = null;
    private static final String k = Environment.getExternalStorageDirectory().getPath() + "/baidu/tempdata/";
    private static final String l = Environment.getExternalStorageDirectory().getPath() + "/baidu/tempdata/ls.db";
    private String b = null;
    private boolean c = false;
    private boolean d = false;
    private double MN = 0.0d;
    private double Lz = 0.0d;
    private double MO = 0.0d;
    private double h = 0.0d;
    private double Mu = 0.0d;
    private volatile boolean j = false;
    private Handler m = new Handler();

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.location.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class AsyncTaskC0027a extends AsyncTask<Boolean, Void, Boolean> {
        private AsyncTaskC0027a() {
        }

        /* synthetic */ AsyncTaskC0027a(a aVar, com.baidu.location.e.b bVar) {
            this();
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
                sQLiteDatabase = SQLiteDatabase.openOrCreateDatabase(a.l, (SQLiteDatabase.CursorFactory) null);
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

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends AsyncTask<Object, Void, Boolean> {
        private b() {
        }

        /* synthetic */ b(a aVar, com.baidu.location.e.b bVar) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: g */
        public Boolean doInBackground(Object... objArr) {
            SQLiteDatabase sQLiteDatabase;
            if (objArr.length != 4) {
                a.this.j = false;
                return false;
            }
            try {
                sQLiteDatabase = SQLiteDatabase.openOrCreateDatabase(a.l, (SQLiteDatabase.CursorFactory) null);
            } catch (Exception e) {
                sQLiteDatabase = null;
            }
            if (sQLiteDatabase == null) {
                a.this.j = false;
                return false;
            }
            try {
                sQLiteDatabase.beginTransaction();
                a.this.a((String) objArr[0], (com.baidu.location.f.a) objArr[1], sQLiteDatabase);
                a.this.a((com.baidu.location.f.i) objArr[2], (BDLocation) objArr[3], sQLiteDatabase);
                sQLiteDatabase.setTransactionSuccessful();
                sQLiteDatabase.endTransaction();
                sQLiteDatabase.close();
            } catch (Exception e2) {
            }
            a.this.j = false;
            return true;
        }
    }

    private a() {
        try {
            File file = new File(k);
            File file2 = new File(l);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.location.f.i iVar, BDLocation bDLocation, SQLiteDatabase sQLiteDatabase) {
        int i;
        int i2;
        double d;
        boolean z;
        double d2;
        if (bDLocation == null || bDLocation.getLocType() != 161) {
            return;
        }
        if (("wf".equals(bDLocation.getNetworkLocationType()) || bDLocation.getRadius() < 300.0f) && iVar.a != null) {
            int currentTimeMillis = (int) (System.currentTimeMillis() >> 28);
            System.currentTimeMillis();
            int i3 = 0;
            for (ScanResult scanResult : iVar.a) {
                if (scanResult.level != 0) {
                    int i4 = i3 + 1;
                    if (i4 > 6) {
                        return;
                    }
                    ContentValues contentValues = new ContentValues();
                    String encode2 = Jni.encode2(scanResult.BSSID.replace(":", ""));
                    try {
                        Cursor rawQuery = sQLiteDatabase.rawQuery("select * from wof where id = \"" + encode2 + "\";", null);
                        if (rawQuery == null || !rawQuery.moveToFirst()) {
                            i = 0;
                            i2 = 0;
                            d = 0.0d;
                            z = false;
                            d2 = 0.0d;
                        } else {
                            double d3 = rawQuery.getDouble(1) - 113.2349d;
                            int i5 = rawQuery.getInt(4);
                            i = rawQuery.getInt(5);
                            i2 = i5;
                            d = d3;
                            z = true;
                            d2 = rawQuery.getDouble(2) - 432.1238d;
                        }
                        if (rawQuery != null) {
                            rawQuery.close();
                        }
                        if (!z) {
                            contentValues.put("mktime", Double.valueOf(bDLocation.getLongitude() + 113.2349d));
                            contentValues.put(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, Double.valueOf(bDLocation.getLatitude() + 432.1238d));
                            contentValues.put("bc", (Integer) 1);
                            contentValues.put("cc", (Integer) 1);
                            contentValues.put("ac", Integer.valueOf(currentTimeMillis));
                            contentValues.put("id", encode2);
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
                                if (sQLiteDatabase.update("wof", contentValues, "id = \"" + encode2 + "\"", null) <= 0) {
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

    private void a(String str, SQLiteDatabase sQLiteDatabase) {
        Cursor cursor;
        Throwable th;
        Cursor rawQuery;
        Cursor cursor2 = null;
        if (str == null || str.equals(this.b)) {
            return;
        }
        this.c = false;
        try {
            try {
                rawQuery = sQLiteDatabase.rawQuery("select * from bdcltb09 where id = \"" + str + "\";", null);
            } catch (Throwable th2) {
                cursor = null;
                th = th2;
            }
            try {
                this.b = str;
                if (rawQuery.moveToFirst()) {
                    this.Lz = rawQuery.getDouble(1) - 1235.4323d;
                    this.MN = rawQuery.getDouble(2) - 4326.0d;
                    this.MO = rawQuery.getDouble(3) - 2367.3217d;
                    this.c = true;
                }
                if (rawQuery != null) {
                    try {
                        rawQuery.close();
                    } catch (Exception e) {
                    }
                }
            } catch (Throwable th3) {
                cursor = rawQuery;
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
            if (0 != 0) {
                try {
                    cursor2.close();
                } catch (Exception e4) {
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:16:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(String str, com.baidu.location.f.a aVar, SQLiteDatabase sQLiteDatabase) {
        float f;
        double d;
        boolean z = false;
        double d2 = 0.0d;
        if (!aVar.b() || !com.baidu.location.a.e.me().g()) {
            return;
        }
        System.currentTimeMillis();
        int currentTimeMillis = (int) (System.currentTimeMillis() >> 28);
        String g = aVar.g();
        try {
            JSONObject jSONObject = new JSONObject(str);
            int parseInt = Integer.parseInt(jSONObject.getJSONObject("result").getString("error"));
            if (parseInt == 161) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("content");
                if (jSONObject2.has("clf")) {
                    String string = jSONObject2.getString("clf");
                    if (string.equals("0")) {
                        JSONObject jSONObject3 = jSONObject2.getJSONObject("point");
                        d2 = Double.parseDouble(jSONObject3.getString("x"));
                        d = Double.parseDouble(jSONObject3.getString("y"));
                        f = Float.parseFloat(jSONObject2.getString("radius"));
                    } else {
                        String[] split = string.split("\\|");
                        d2 = Double.parseDouble(split[0]);
                        d = Double.parseDouble(split[1]);
                        f = Float.parseFloat(split[2]);
                    }
                    if (z) {
                        float f2 = 4326.0f + f;
                        ContentValues contentValues = new ContentValues();
                        contentValues.put(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, Double.valueOf(d2 + 1235.4323d));
                        contentValues.put("tag", Float.valueOf(f2));
                        contentValues.put("type", Double.valueOf(d + 2367.3217d));
                        contentValues.put("ac", Integer.valueOf(currentTimeMillis));
                        try {
                            if (sQLiteDatabase.update("bdcltb09", contentValues, "id = \"" + g + "\"", null) <= 0) {
                                contentValues.put("id", g);
                                sQLiteDatabase.insert("bdcltb09", null, contentValues);
                                return;
                            }
                            return;
                        } catch (Exception e) {
                            return;
                        }
                    }
                    return;
                }
            } else if (parseInt == 167) {
                sQLiteDatabase.delete("bdcltb09", "id = \"" + g + "\"", null);
                return;
            }
            z = true;
            f = 0.0f;
            d = 0.0d;
            if (z) {
            }
        } catch (Exception e2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, List<ScanResult> list) {
        SQLiteDatabase sQLiteDatabase;
        if (str == null || str.equals(this.b)) {
            sQLiteDatabase = null;
        } else {
            sQLiteDatabase = SQLiteDatabase.openOrCreateDatabase(l, (SQLiteDatabase.CursorFactory) null);
            a(str, sQLiteDatabase);
        }
        if (list != null) {
            if (sQLiteDatabase == null) {
                sQLiteDatabase = SQLiteDatabase.openOrCreateDatabase(l, (SQLiteDatabase.CursorFactory) null);
            }
            a(list, sQLiteDatabase);
        }
        if (sQLiteDatabase == null || !sQLiteDatabase.isOpen()) {
            return;
        }
        sQLiteDatabase.close();
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x0111 A[EDGE_INSN: B:104:0x0111->B:46:0x0111 ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01b3 A[Catch: Exception -> 0x0098, all -> 0x00fd, TRY_LEAVE, TryCatch #7 {Exception -> 0x0098, all -> 0x00fd, blocks: (B:14:0x0061, B:16:0x0067, B:18:0x006d, B:21:0x0094, B:33:0x00d1, B:35:0x00d7, B:37:0x00f8, B:74:0x01b3, B:56:0x0133, B:58:0x0147, B:61:0x0153, B:65:0x0168, B:67:0x017d, B:68:0x0189, B:70:0x0195, B:73:0x01a6, B:48:0x0114), top: B:89:0x0061 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(List<ScanResult> list, SQLiteDatabase sQLiteDatabase) {
        Cursor cursor;
        Throwable th;
        float[] fArr;
        int i;
        boolean z;
        boolean z2;
        int i2;
        double d;
        double d2;
        System.currentTimeMillis();
        this.d = false;
        if (list == null || sQLiteDatabase == null || list == null) {
            return;
        }
        double d3 = 0.0d;
        double d4 = 0.0d;
        int i3 = 0;
        boolean z3 = false;
        double[] dArr = new double[8];
        boolean z4 = false;
        int i4 = 0;
        StringBuffer stringBuffer = new StringBuffer();
        int i5 = 0;
        for (ScanResult scanResult : list) {
            if (i5 > 10) {
                break;
            }
            if (i5 > 0) {
                stringBuffer.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
            i5++;
            stringBuffer.append("\"").append(Jni.encode2(scanResult.BSSID.replace(":", ""))).append("\"");
        }
        Cursor cursor2 = null;
        try {
            cursor = sQLiteDatabase.rawQuery("select * from wof where id in (" + stringBuffer.toString() + ");", null);
            try {
                if (cursor.moveToFirst()) {
                    while (!cursor.isAfterLast()) {
                        double d5 = cursor.getDouble(1) - 113.2349d;
                        double d6 = cursor.getDouble(2) - 432.1238d;
                        int i6 = cursor.getInt(4);
                        int i7 = cursor.getInt(5);
                        if (i7 > 8 && i7 > i6) {
                            cursor.moveToNext();
                        } else if (this.c) {
                            Location.distanceBetween(d6, d5, this.MO, this.Lz, new float[1]);
                            if (fArr[0] > this.MN + 2000.0d) {
                                cursor.moveToNext();
                            } else {
                                z3 = true;
                                d3 += d5;
                                d4 += d6;
                                i3++;
                                i = i4;
                                z = z4;
                                if (i3 <= 4) {
                                    break;
                                }
                                cursor.moveToNext();
                                i4 = i;
                                z4 = z;
                            }
                        } else {
                            if (z3) {
                                float[] fArr2 = new float[1];
                                Location.distanceBetween(d6, d5, d4 / i3, d3 / i3, fArr2);
                                if (fArr2[0] > 1000.0f) {
                                    cursor.moveToNext();
                                } else {
                                    i = i4;
                                    z = z4;
                                }
                            } else if (z4) {
                                int i8 = 0;
                                while (i8 < i4) {
                                    float[] fArr3 = new float[1];
                                    Location.distanceBetween(d6, d5, dArr[i8 + 1], dArr[i8], fArr3);
                                    if (fArr3[0] < 1000.0f) {
                                        z2 = true;
                                        d2 = d3 + dArr[i8];
                                        d = dArr[i8 + 1] + d4;
                                        i2 = i3 + 1;
                                    } else {
                                        z2 = z3;
                                        i2 = i3;
                                        d = d4;
                                        d2 = d3;
                                    }
                                    i8 += 2;
                                    d4 = d;
                                    d3 = d2;
                                    z3 = z2;
                                    i3 = i2;
                                }
                                if (!z3) {
                                    if (i4 >= 8) {
                                        break;
                                    }
                                    int i9 = i4 + 1;
                                    dArr[i4] = d5;
                                    dArr[i9] = d6;
                                    i = i9 + 1;
                                    z = z4;
                                } else {
                                    d3 += d5;
                                    d4 += d6;
                                    i3++;
                                    i = i4;
                                    z = z4;
                                }
                            } else {
                                int i10 = i4 + 1;
                                dArr[i4] = d5;
                                dArr[i10] = d6;
                                z = true;
                                i = i10 + 1;
                            }
                            if (i3 <= 4) {
                            }
                        }
                    }
                    if (i3 > 0) {
                        this.d = true;
                        this.h = d3 / i3;
                        this.Mu = d4 / i3;
                    }
                }
                if (cursor != null) {
                    try {
                        cursor.close();
                    } catch (Exception e) {
                    }
                }
            } catch (Exception e2) {
                cursor2 = cursor;
                if (cursor2 != null) {
                    try {
                        cursor2.close();
                    } catch (Exception e3) {
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (cursor != null) {
                    try {
                        cursor.close();
                    } catch (Exception e4) {
                    }
                }
                throw th;
            }
        } catch (Exception e5) {
        } catch (Throwable th3) {
            cursor = null;
            th = th3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String ab(boolean z) {
        boolean z2;
        boolean z3;
        double d;
        double d2;
        double d3 = 0.0d;
        if (this.d) {
            d2 = this.h;
            d = this.Mu;
            d3 = 246.4d;
            z2 = true;
            z3 = true;
        } else if (this.c) {
            d2 = this.Lz;
            d = this.MO;
            d3 = this.MN;
            z2 = com.baidu.location.a.e.me().g();
            z3 = true;
        } else {
            z2 = false;
            z3 = false;
            d = 0.0d;
            d2 = 0.0d;
        }
        if (!z3) {
            return z ? "{\"result\":{\"time\":\"" + com.baidu.location.h.i.a() + "\",\"error\":\"67\"}}" : "{\"result\":{\"time\":\"" + com.baidu.location.h.i.a() + "\",\"error\":\"63\"}}";
        } else if (z) {
            return String.format(Locale.CHINA, "{\"result\":{\"time\":\"" + com.baidu.location.h.i.a() + "\",\"error\":\"66\"},\"content\":{\"point\":{\"x\":\"%f\",\"y\":\"%f\"},\"radius\":\"%f\",\"isCellChanged\":\"%b\"}}", Double.valueOf(d2), Double.valueOf(d), Double.valueOf(d3), true);
        } else {
            return String.format(Locale.CHINA, "{\"result\":{\"time\":\"" + com.baidu.location.h.i.a() + "\",\"error\":\"66\"},\"content\":{\"point\":{\"x\":\"%f\",\"y\":\"%f\"},\"radius\":\"%f\",\"isCellChanged\":\"%b\"}}", Double.valueOf(d2), Double.valueOf(d), Double.valueOf(d3), Boolean.valueOf(z2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        SQLiteDatabase sQLiteDatabase;
        try {
            sQLiteDatabase = SQLiteDatabase.openOrCreateDatabase(l, (SQLiteDatabase.CursorFactory) null);
        } catch (Exception e) {
            sQLiteDatabase = null;
        }
        if (sQLiteDatabase == null) {
            return;
        }
        try {
            long queryNumEntries = DatabaseUtils.queryNumEntries(sQLiteDatabase, "wof");
            long queryNumEntries2 = DatabaseUtils.queryNumEntries(sQLiteDatabase, "bdcltb09");
            boolean z = queryNumEntries > 10000;
            boolean z2 = queryNumEntries2 > 10000;
            if (z || z2) {
                new AsyncTaskC0027a(this, null).execute(Boolean.valueOf(z), Boolean.valueOf(z2));
            }
            sQLiteDatabase.close();
        } catch (Exception e2) {
        }
    }

    public static synchronized a mB() {
        a aVar;
        synchronized (a.class) {
            if (MM == null) {
                MM = new a();
            }
            aVar = MM;
        }
        return aVar;
    }

    public BDLocation a(String str, List<ScanResult> list, boolean z) {
        String str2;
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
        FutureTask futureTask = (FutureTask) newSingleThreadExecutor.submit(new c(this, str, list));
        try {
            try {
                try {
                    try {
                        str2 = (String) futureTask.get(2000L, TimeUnit.MILLISECONDS);
                    } catch (ExecutionException e) {
                        futureTask.cancel(true);
                        newSingleThreadExecutor.shutdown();
                        str2 = "{\"result\":\"null\"}";
                    }
                } catch (TimeoutException e2) {
                    if (z) {
                        com.baidu.location.c.f.my().a("old offlineLocation Timeout Exception!");
                    }
                    futureTask.cancel(true);
                    newSingleThreadExecutor.shutdown();
                    str2 = "{\"result\":\"null\"}";
                }
            } catch (InterruptedException e3) {
                futureTask.cancel(true);
                newSingleThreadExecutor.shutdown();
                str2 = "{\"result\":\"null\"}";
            }
            return new BDLocation(str2);
        } finally {
            newSingleThreadExecutor.shutdown();
        }
    }

    public void a(String str, com.baidu.location.f.a aVar, com.baidu.location.f.i iVar, BDLocation bDLocation) {
        boolean z = (aVar.b() && com.baidu.location.a.e.me().g()) ? false : true;
        boolean z2 = bDLocation == null || bDLocation.getLocType() != 161 || (!"wf".equals(bDLocation.getNetworkLocationType()) && bDLocation.getRadius() >= 300.0f);
        if (iVar.a == null) {
            z2 = true;
        }
        if ((z && z2) || this.j) {
            return;
        }
        this.j = true;
        new b(this, null).execute(str, aVar, iVar, bDLocation);
    }

    public BDLocation aa(boolean z) {
        com.baidu.location.f.a mR = com.baidu.location.f.c.mV().mR();
        String g = mR != null ? mR.g() : null;
        com.baidu.location.f.i nb = com.baidu.location.f.k.ne().nb();
        BDLocation a = nb != null ? a(g, nb.a, true) : null;
        if (a != null && a.getLocType() == 66) {
            StringBuffer stringBuffer = new StringBuffer(1024);
            stringBuffer.append(String.format(Locale.CHINA, "&ofl=%f|%f|%f", Double.valueOf(a.getLatitude()), Double.valueOf(a.getLongitude()), Float.valueOf(a.getRadius())));
            if (nb != null && nb.a() > 0) {
                stringBuffer.append("&wf=");
                stringBuffer.append(nb.b(15));
            }
            if (mR != null) {
                stringBuffer.append(mR.h());
            }
            stringBuffer.append("&uptype=oldoff");
            stringBuffer.append(com.baidu.location.h.c.nf().a(false));
            stringBuffer.append(com.baidu.location.a.a.mc().c());
            stringBuffer.toString();
        }
        return a;
    }

    public void b() {
        this.m.postDelayed(new com.baidu.location.e.b(this), 3000L);
    }
}
