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

    /* renamed from: a  reason: collision with root package name */
    private static final String f1998a = "logsender";
    private static final String d = "rim_stat_event";
    private static final String e = "rim_stat_event.db";
    private static final int f = 1;
    private static final String g = "CREATE TABLE IF NOT EXISTS rim_stat_event(en VARCHAR(64) not null ,extra1 VARCHAR(64)  ,extra2 VARCHAR(64)  ,extra3 VARCHAR(64),extra4 VARCHAR(64)  ,extra5 VARCHAR(64) ,et BIGINT,ev TEXT,extra6 TEXT,extra7 TEXT,extra8 TEXT,extra9 TEXT,eg VARCHAR(20) default(null),lk VARCHAR(10) default(null),nu INTEGER PRIMARY KEY autoincrement)";
    private static i i;

    /* renamed from: b  reason: collision with root package name */
    private SQLiteDatabase f1999b;
    private final byte[] c;
    private int h;

    private i(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i2) {
        super(context, str, cursorFactory, i2);
        this.c = new byte[0];
        this.h = 200;
        this.f1999b = getWritableDatabase();
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
        synchronized (this.c) {
            if (hVar != null) {
                if (!TextUtils.isEmpty(hVar.p)) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(h.f1996a, hVar.p);
                    contentValues.put("et", Long.valueOf(hVar.q));
                    contentValues.put("ev", hVar.r);
                    contentValues.put(h.d, hVar.s);
                    contentValues.put(h.e, hVar.t);
                    try {
                        this.f1999b.insert(d, null, contentValues);
                    } catch (Exception e2) {
                    }
                    LogUtil.d(f1998a, "插入一条数据" + hVar.p);
                }
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [116=4, 117=4] */
    public int a() {
        int i2 = 0;
        synchronized (this.c) {
            Cursor rawQuery = this.f1999b.rawQuery("SELECT COUNT(*) FROM rim_stat_event", null);
            if (rawQuery != null) {
                try {
                } catch (Exception e2) {
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                } catch (Throwable th) {
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    throw th;
                }
                if (rawQuery.moveToFirst()) {
                    i2 = rawQuery.getInt(0);
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                } else if (rawQuery != null) {
                    rawQuery.close();
                }
            }
        }
        return i2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [154=5, 155=4] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0089 A[Catch: all -> 0x008e, TryCatch #4 {, blocks: (B:9:0x0016, B:10:0x0019, B:34:0x009e, B:35:0x00a1, B:21:0x0089, B:22:0x008c, B:30:0x0096, B:19:0x0084), top: B:45:0x0005 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public h[] b() {
        Cursor cursor;
        h[] hVarArr;
        int i2 = 0;
        synchronized (this.c) {
            try {
                cursor = this.f1999b.rawQuery("select * from rim_stat_event", null);
                try {
                    try {
                    } catch (Throwable th) {
                        th = th;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                } catch (Exception e2) {
                    hVarArr = null;
                }
            } catch (Exception e3) {
                hVarArr = null;
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
                cursor = null;
            }
            if (cursor == null) {
                hVarArr = new h[0];
                if (cursor != null) {
                    cursor.close();
                }
            } else {
                hVarArr = new h[cursor.getCount()];
                while (true) {
                    try {
                        int i3 = i2;
                        if (!cursor.moveToNext()) {
                            break;
                        }
                        h hVar = new h();
                        hVar.p = cursor.getString(cursor.getColumnIndex(h.f1996a));
                        hVar.q = cursor.getLong(cursor.getColumnIndex("et"));
                        hVar.r = cursor.getString(cursor.getColumnIndex("ev"));
                        hVar.s = cursor.getString(cursor.getColumnIndex(h.d));
                        hVar.t = cursor.getString(cursor.getColumnIndex(h.e));
                        hVar.u = cursor.getInt(cursor.getColumnIndex(h.f));
                        i2 = i3 + 1;
                        hVarArr[i3] = hVar;
                    } catch (Exception e4) {
                        if (cursor != null) {
                            cursor.close();
                        }
                        if (hVarArr == null) {
                        }
                        return hVarArr;
                    }
                }
                if (cursor != null) {
                    cursor.close();
                }
                if (hVarArr == null) {
                    hVarArr = new h[0];
                }
            }
        }
        return hVarArr;
    }

    public void a(h[] hVarArr) {
        synchronized (this.c) {
            if (hVarArr != null) {
                if (hVarArr.length != 0) {
                    LogUtil.d(f1998a, "=====removeEvents-begin=====size=" + hVarArr.length);
                    for (h hVar : hVarArr) {
                        if (hVar != null) {
                            this.f1999b.delete(d, "nu=" + hVar.u, null);
                        }
                    }
                    LogUtil.d(f1998a, "=====removeEvents-end=====");
                    return;
                }
            }
            LogUtil.d(f1998a, "=====removeEvents=====size=0");
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
        if (this.f1999b != null && this.f1999b.isOpen()) {
            this.f1999b.close();
        }
        this.f1999b = null;
        super.finalize();
    }
}
