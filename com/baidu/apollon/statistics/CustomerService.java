package com.baidu.apollon.statistics;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.baidu.apollon.statistics.sqlite.MyDb;
import com.baidu.apollon.utils.LogUtil;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class CustomerService extends MyDb {
    public static final String CS_GET_DATA_ERROR = "CS_getDbDataError";
    public static final String CS_OPEN_DB_ERROR = "CS_openDbError";
    public static final String sMarkString = "kf";

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f3933a;

    /* renamed from: b  reason: collision with root package name */
    public long f3934b;

    /* renamed from: c  reason: collision with root package name */
    public int f3935c;

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: b  reason: collision with root package name */
        public static final String f3937b = "customerservice.db";

        /* renamed from: a  reason: collision with root package name */
        public static int f3936a = 2;

        /* renamed from: c  reason: collision with root package name */
        public static final CustomerService f3938c = new CustomerService(PayStatisticsUtil.c(), f3937b, f3936a);
    }

    private e[] a() {
        SQLiteDatabase sQLiteDatabase = this.mDb;
        if (sQLiteDatabase == null) {
            PayStatisticsUtil.onEvent(CS_GET_DATA_ERROR);
            return new e[0];
        }
        Cursor cursor = null;
        try {
            try {
                Cursor rawQuery = sQLiteDatabase.rawQuery("select * from stat_event", null);
                if (rawQuery == null) {
                    e[] eVarArr = new e[0];
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    return eVarArr;
                }
                e[] eVarArr2 = new e[rawQuery.getCount()];
                int i2 = 0;
                while (rawQuery.moveToNext()) {
                    e eVar = new e();
                    eVar.f3980h = rawQuery.getString(0);
                    eVar.f3981i = rawQuery.getLong(1);
                    eVar.j = rawQuery.getString(2);
                    eVar.k = rawQuery.getString(3);
                    eVar.l = rawQuery.getString(4);
                    eVar.m = rawQuery.getLong(5);
                    if (1 < a.f3936a) {
                        eVar.n = rawQuery.getString(6);
                    }
                    int i3 = i2 + 1;
                    eVarArr2[i2] = eVar;
                    i2 = i3;
                }
                if (rawQuery != null) {
                    rawQuery.close();
                }
                return eVarArr2;
            } catch (Exception e2) {
                LogUtil.errord(e2.getMessage());
                e[] eVarArr3 = new e[0];
                if (0 != 0) {
                    cursor.close();
                }
                return eVarArr3;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    public static CustomerService getInstance() {
        return a.f3938c;
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:72:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x014c -> B:63:0x016e). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void enqueEvent(e eVar) {
        Cursor cursor;
        if (eVar == null || TextUtils.isEmpty(eVar.f3980h)) {
            return;
        }
        if (this.mDb != null) {
            StringBuilder sb = new StringBuilder();
            ContentValues contentValues = new ContentValues();
            contentValues.put("en", eVar.f3980h);
            contentValues.put("et", Long.valueOf(eVar.f3981i));
            contentValues.put("ev", eVar.j);
            contentValues.put("eg", eVar.k);
            contentValues.put("lk", eVar.l);
            contentValues.put("nu", Long.valueOf(eVar.m));
            contentValues.put("at", eVar.n);
            this.mDb.beginTransaction();
            sb.delete(0, sb.length());
            sb.append("select count(*) from stat_event");
            Cursor cursor2 = null;
            try {
                try {
                    long insert = this.mDb.insert("stat_event", null, contentValues);
                    Cursor rawQuery = this.mDb.rawQuery(sb.toString(), null);
                    if (rawQuery != null) {
                        try {
                            if (rawQuery.moveToFirst()) {
                                if (this.f3935c < rawQuery.getLong(0)) {
                                    sb.delete(0, sb.length());
                                    if (0 < this.f3934b) {
                                        sb.append("select min(rowid), max(rowid) from stat_event where ");
                                        sb.append("rowid <= ");
                                        sb.append(insert - this.f3935c);
                                        sb.append(" and et < ");
                                        sb.append(eVar.f3981i);
                                        sb.append(" - ");
                                        sb.append(this.f3934b);
                                        cursor2 = this.mDb.rawQuery(sb.toString(), null);
                                        if (cursor2 != null && cursor2.moveToFirst()) {
                                            sb.delete(0, sb.length());
                                            long j = cursor2.getLong(0);
                                            long j2 = cursor2.getLong(1);
                                            sb.append("delete from stat_event where rowid <= ");
                                            sb.append(j2);
                                            sb.append(" and rowid >= ");
                                            sb.append(j);
                                            this.mDb.execSQL(sb.toString());
                                        }
                                    } else {
                                        sb.append("delete from stat_event where rowid < ");
                                        sb.append(insert - this.f3935c);
                                        this.mDb.execSQL(sb.toString());
                                    }
                                }
                            }
                        } catch (Exception e2) {
                            e = e2;
                            Cursor cursor3 = cursor2;
                            cursor2 = rawQuery;
                            cursor = cursor3;
                            try {
                                LogUtil.errord(e.getMessage());
                                if (cursor2 != null) {
                                    cursor2.close();
                                }
                                if (cursor != null) {
                                    cursor.close();
                                }
                                this.mDb.endTransaction();
                                if (g.a().a(eVar)) {
                                }
                            } catch (Throwable th) {
                                th = th;
                                if (cursor2 != null) {
                                    cursor2.close();
                                }
                                if (cursor != null) {
                                    cursor.close();
                                }
                                try {
                                    this.mDb.endTransaction();
                                } catch (Exception e3) {
                                    LogUtil.errord(e3.getMessage());
                                }
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            Cursor cursor4 = cursor2;
                            cursor2 = rawQuery;
                            cursor = cursor4;
                            if (cursor2 != null) {
                            }
                            if (cursor != null) {
                            }
                            this.mDb.endTransaction();
                            throw th;
                        }
                    }
                    this.mDb.setTransactionSuccessful();
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    this.mDb.endTransaction();
                } catch (Exception e4) {
                    LogUtil.errord(e4.getMessage());
                }
            } catch (Exception e5) {
                e = e5;
                cursor = null;
            } catch (Throwable th3) {
                th = th3;
                cursor = null;
            }
        }
        if (g.a().a(eVar)) {
            return;
        }
        LogSender.getInstance().triggerSending(Config.w);
    }

    public String getSendData() {
        JSONObject jSONObject;
        e[] a2 = a();
        if (a2.length == 0) {
            return null;
        }
        synchronized (this.f3933a) {
            try {
                StatisticsSettings a3 = PayStatisticsUtil.getInstance().a();
                jSONObject = a3 != null ? new JSONObject(a3.getCommonHeader()) : null;
            } catch (JSONException unused) {
                return null;
            }
        }
        if (jSONObject == null) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (e eVar : a2) {
            jSONArray.put(eVar.a());
        }
        try {
            jSONObject.put("array", jSONArray);
            return jSONObject.toString();
        } catch (JSONException unused2) {
            return null;
        }
    }

    public boolean isEnabled() {
        return this.f3935c > 0 || 0 < this.f3934b;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        this.mDb = sQLiteDatabase;
        MyDb.createTable(sQLiteDatabase, "stat_event", new String[]{"en VARCHAR(64) not null", "et BIGINT", "ev TEXT", "eg VARCHAR(20) default(null)", "lk VARCHAR(10) default(null)", "nu BIGINT", "at VARCHAR(1024) default(null)", "primary key (en,et,nu)"});
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onOpen(SQLiteDatabase sQLiteDatabase) {
        this.mDb = sQLiteDatabase;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        this.mDb = sQLiteDatabase;
        if (1 == i2 && 2 == i3 && sQLiteDatabase != null) {
            sQLiteDatabase.execSQL("alter table stat_event add at VARCHAR(1024)");
        }
    }

    public void setConfig(int i2, int i3) {
        this.f3934b = i2;
        this.f3935c = i3;
    }

    public CustomerService(Context context, String str, int i2) {
        super(context, str, i2);
        this.f3933a = new byte[0];
        this.f3934b = 0L;
        this.f3935c = 200;
        if (this.mDb == null) {
            PayStatisticsUtil.onEvent(CS_OPEN_DB_ERROR);
        }
    }

    public void enqueEvent(String str, String str2, String str3, String str4) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        e eVar = new e();
        eVar.f3980h = str;
        eVar.j = str2;
        eVar.k = str3;
        eVar.l = com.baidu.apollon.statistics.a.a();
        eVar.f3981i = System.currentTimeMillis();
        eVar.m = f.a();
        eVar.n = str4;
        enqueEvent(eVar);
    }
}
