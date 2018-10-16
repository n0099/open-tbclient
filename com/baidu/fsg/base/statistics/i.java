package com.baidu.fsg.base.statistics;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.baidu.fsg.base.utils.LogUtil;
/* loaded from: classes6.dex */
class i extends SQLiteOpenHelper {
    private static final String a = "logsender";
    private static final String d = "rim_stat_event";
    private static final String e = "rim_stat_event.db";
    private static final int f = 1;
    private static final String g = "CREATE TABLE IF NOT EXISTS rim_stat_event(en VARCHAR(64) not null ,extra1 VARCHAR(64)  ,extra2 VARCHAR(64)  ,extra3 VARCHAR(64),extra4 VARCHAR(64)  ,extra5 VARCHAR(64) ,et BIGINT,ev TEXT,extra6 TEXT,extra7 TEXT,extra8 TEXT,extra9 TEXT,eg VARCHAR(20) default(null),lk VARCHAR(10) default(null),nu INTEGER PRIMARY KEY autoincrement)";
    private static i i;
    private SQLiteDatabase b;
    private final byte[] c;
    private int h;

    private i(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i2) {
        super(context, str, cursorFactory, i2);
        this.c = new byte[0];
        this.h = 200;
        this.b = getWritableDatabase();
    }

    public static synchronized i a(Context context) {
        i iVar;
        synchronized (i.class) {
            if (i == null) {
                i = new i(context, e, null, 1);
            }
            iVar = i;
        }
        return iVar;
    }

    public void a(h hVar) {
        if (hVar != null && !TextUtils.isEmpty(hVar.p)) {
            ContentValues contentValues = new ContentValues();
            contentValues.put(h.a, hVar.p);
            contentValues.put("et", Long.valueOf(hVar.q));
            contentValues.put("ev", hVar.r);
            contentValues.put(h.d, hVar.s);
            contentValues.put(h.e, hVar.t);
            synchronized (this.c) {
                this.b.insert(d, null, contentValues);
            }
            LogUtil.d(a, "插入一条数据" + hVar.p);
        }
    }

    public int a() {
        Cursor rawQuery = this.b.rawQuery("SELECT COUNT(*) FROM rim_stat_event", null);
        if (rawQuery == null) {
            return 0;
        }
        if (rawQuery.moveToFirst()) {
            return rawQuery.getInt(0);
        }
        rawQuery.close();
        return 0;
    }

    public h[] b() {
        h[] hVarArr;
        int i2 = 0;
        synchronized (this.c) {
            Cursor rawQuery = this.b.rawQuery("select * from rim_stat_event", null);
            if (rawQuery == null) {
                hVarArr = new h[0];
            } else {
                hVarArr = new h[rawQuery.getCount()];
                while (rawQuery.moveToNext()) {
                    h hVar = new h();
                    hVar.p = rawQuery.getString(rawQuery.getColumnIndex(h.a));
                    hVar.q = rawQuery.getLong(rawQuery.getColumnIndex("et"));
                    hVar.r = rawQuery.getString(rawQuery.getColumnIndex("ev"));
                    hVar.s = rawQuery.getString(rawQuery.getColumnIndex(h.d));
                    hVar.t = rawQuery.getString(rawQuery.getColumnIndex(h.e));
                    hVar.u = rawQuery.getInt(rawQuery.getColumnIndex(h.f));
                    hVarArr[i2] = hVar;
                    i2++;
                }
                rawQuery.close();
            }
        }
        return hVarArr;
    }

    public void a(h[] hVarArr) {
        synchronized (this.c) {
            if (hVarArr != null) {
                if (hVarArr.length != 0) {
                    LogUtil.d(a, "=====removeEvents-begin=====size=" + hVarArr.length);
                    for (h hVar : hVarArr) {
                        if (hVar != null) {
                            this.b.delete(d, "nu=" + hVar.u, null);
                        }
                    }
                    LogUtil.d(a, "=====removeEvents-end=====");
                    return;
                }
            }
            LogUtil.d(a, "=====removeEvents=====size=0");
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(g);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
    }

    protected void finalize() throws Throwable {
        if (this.b != null && this.b.isOpen()) {
            this.b.close();
        }
        this.b = null;
        super.finalize();
    }
}
