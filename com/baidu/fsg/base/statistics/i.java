package com.baidu.fsg.base.statistics;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.baidu.fsg.base.utils.LogUtil;
/* loaded from: classes2.dex */
public class i extends SQLiteOpenHelper {

    /* renamed from: a  reason: collision with root package name */
    public static final String f5232a = "logsender";

    /* renamed from: d  reason: collision with root package name */
    public static final String f5233d = "rim_stat_event";

    /* renamed from: e  reason: collision with root package name */
    public static final String f5234e = "rim_stat_event.db";

    /* renamed from: f  reason: collision with root package name */
    public static final int f5235f = 1;

    /* renamed from: g  reason: collision with root package name */
    public static final String f5236g = "CREATE TABLE IF NOT EXISTS rim_stat_event(en VARCHAR(64) not null ,extra1 VARCHAR(64)  ,extra2 VARCHAR(64)  ,extra3 VARCHAR(64),extra4 VARCHAR(64)  ,extra5 VARCHAR(64) ,et BIGINT,ev TEXT,extra6 TEXT,extra7 TEXT,extra8 TEXT,extra9 TEXT,eg VARCHAR(20) default(null),lk VARCHAR(10) default(null),nu INTEGER PRIMARY KEY autoincrement)";

    /* renamed from: i  reason: collision with root package name */
    public static i f5237i;

    /* renamed from: b  reason: collision with root package name */
    public SQLiteDatabase f5238b;

    /* renamed from: c  reason: collision with root package name */
    public final byte[] f5239c;

    /* renamed from: h  reason: collision with root package name */
    public int f5240h;

    public i(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i2) {
        super(context, str, cursorFactory, i2);
        this.f5239c = new byte[0];
        this.f5240h = 200;
        this.f5238b = getWritableDatabase();
    }

    public static synchronized i a(Context context) {
        i iVar;
        synchronized (i.class) {
            if (f5237i == null) {
                f5237i = new i(context, f5234e, null, 1);
            }
            iVar = f5237i;
        }
        return iVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x009a A[Catch: all -> 0x0095, TryCatch #2 {all -> 0x0095, blocks: (B:9:0x0014, B:10:0x0017, B:18:0x007c, B:33:0x009a, B:34:0x009c, B:24:0x008a, B:25:0x008d, B:28:0x0091), top: B:38:0x0005 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public h[] b() {
        h[] hVarArr;
        h[] hVarArr2;
        Cursor rawQuery;
        synchronized (this.f5239c) {
            Cursor cursor = null;
            try {
                try {
                    rawQuery = this.f5238b.rawQuery("select * from rim_stat_event", null);
                    try {
                    } catch (Exception unused) {
                        hVarArr = null;
                        cursor = rawQuery;
                        if (cursor != null) {
                            cursor.close();
                        }
                        hVarArr2 = hVarArr;
                        if (hVarArr2 == null) {
                        }
                        return hVarArr2;
                    } catch (Throwable th) {
                        th = th;
                        cursor = rawQuery;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                } finally {
                }
            } catch (Exception unused2) {
                hVarArr = null;
            } catch (Throwable th2) {
                th = th2;
            }
            if (rawQuery == null) {
                h[] hVarArr3 = new h[0];
                if (rawQuery != null) {
                    rawQuery.close();
                }
                return hVarArr3;
            }
            hVarArr2 = new h[rawQuery.getCount()];
            int i2 = 0;
            while (rawQuery.moveToNext()) {
                h hVar = new h();
                hVar.p = rawQuery.getString(rawQuery.getColumnIndex("en"));
                hVar.q = rawQuery.getLong(rawQuery.getColumnIndex("et"));
                hVar.r = rawQuery.getString(rawQuery.getColumnIndex("ev"));
                hVar.s = rawQuery.getString(rawQuery.getColumnIndex("eg"));
                hVar.t = rawQuery.getString(rawQuery.getColumnIndex("lk"));
                hVar.u = rawQuery.getInt(rawQuery.getColumnIndex("nu"));
                int i3 = i2 + 1;
                hVarArr2[i2] = hVar;
                i2 = i3;
            }
            if (rawQuery != null) {
                rawQuery.close();
            }
            if (hVarArr2 == null) {
                hVarArr2 = new h[0];
            }
            return hVarArr2;
        }
    }

    public void finalize() throws Throwable {
        SQLiteDatabase sQLiteDatabase = this.f5238b;
        if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
            this.f5238b.close();
        }
        this.f5238b = null;
        super.finalize();
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(f5236g);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
    }

    public void a(h hVar) {
        synchronized (this.f5239c) {
            if (hVar != null) {
                if (!TextUtils.isEmpty(hVar.p)) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("en", hVar.p);
                    contentValues.put("et", Long.valueOf(hVar.q));
                    contentValues.put("ev", hVar.r);
                    contentValues.put("eg", hVar.s);
                    contentValues.put("lk", hVar.t);
                    try {
                        this.f5238b.insert(f5233d, null, contentValues);
                    } catch (Exception unused) {
                    }
                    LogUtil.d("logsender", "插入一条数据" + hVar.p);
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0022, code lost:
        if (r1 != null) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int a() {
        synchronized (this.f5239c) {
            Cursor rawQuery = this.f5238b.rawQuery("SELECT COUNT(*) FROM rim_stat_event", null);
            if (rawQuery == null) {
                return 0;
            }
            try {
                if (rawQuery.moveToFirst()) {
                    int i2 = rawQuery.getInt(0);
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    return i2;
                }
            } catch (Exception unused) {
                if (rawQuery != null) {
                    rawQuery.close();
                }
                return 0;
            } catch (Throwable th) {
                if (rawQuery != null) {
                    rawQuery.close();
                }
                throw th;
            }
        }
    }

    public void a(h[] hVarArr) {
        synchronized (this.f5239c) {
            if (hVarArr != null) {
                if (hVarArr.length != 0) {
                    LogUtil.d("logsender", "=====removeEvents-begin=====size=" + hVarArr.length);
                    for (h hVar : hVarArr) {
                        if (hVar != null) {
                            this.f5238b.delete(f5233d, "nu=" + hVar.u, null);
                        }
                    }
                    LogUtil.d("logsender", "=====removeEvents-end=====");
                    return;
                }
            }
            LogUtil.d("logsender", "=====removeEvents=====size=0");
        }
    }
}
