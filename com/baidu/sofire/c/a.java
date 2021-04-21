package com.baidu.sofire.c;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Base64;
import com.baidu.ala.view.AlaAttentionManager;
import com.baidu.mapsdkplatform.comapi.map.r;
import com.baidu.sofire.ac.F;
import com.baidu.sofire.b;
import com.baidu.sofire.e;
import com.baidu.sofire.g.d;
import com.baidu.tbadk.core.data.SmallTailInfo;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static a f11308a;

    /* renamed from: b  reason: collision with root package name */
    public C0158a f11309b;

    /* renamed from: c  reason: collision with root package name */
    public SQLiteDatabase f11310c;

    /* renamed from: d  reason: collision with root package name */
    public Context f11311d;

    /* renamed from: com.baidu.sofire.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0158a extends SQLiteOpenHelper {
        public C0158a(Context context) {
            super(context, "d.db", (SQLiteDatabase.CursorFactory) null, 3);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onCreate(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.execSQL("create table if not exists r(a integer primary key autoincrement, b text, c integer, e integer,f integer,h text, g integer, i integer, j text, d long);");
            sQLiteDatabase.execSQL("create table if not exists c(a integer primary key autoincrement, b text); ");
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            if (i <= 1) {
                sQLiteDatabase.execSQL("alter table r add i integer default 0;");
            }
            if (i <= 2) {
                sQLiteDatabase.execSQL("ALTER TABLE r ADD COLUMN j TEXT");
            }
        }
    }

    public a(Context context) {
        this.f11311d = context;
        C0158a c0158a = new C0158a(context);
        this.f11309b = c0158a;
        try {
            this.f11310c = c0158a.getWritableDatabase();
        } catch (Throwable unused) {
            d.a();
        }
    }

    public static synchronized a a(Context context) {
        a aVar;
        synchronized (a.class) {
            if (f11308a == null) {
                f11308a = new a(context);
            }
            aVar = f11308a;
        }
        return aVar;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, INVOKE, INVOKE] complete} */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x002b, code lost:
        if (r11 == null) goto L6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean b(String str) {
        Cursor cursor;
        boolean z = true;
        try {
            cursor = this.f11310c.query("c", null, "b=?", new String[]{str}, null, null, null);
            if (cursor != null) {
                try {
                    if (cursor.getCount() > 0) {
                        z = false;
                    }
                } catch (Throwable unused) {
                    try {
                        d.a();
                    } finally {
                        if (cursor != null) {
                            try {
                                cursor.close();
                            } catch (Exception unused2) {
                                d.a();
                            }
                        }
                    }
                }
            }
        } catch (Throwable unused3) {
            cursor = null;
        }
        return z;
    }

    public final int c() {
        e eVar = new e(this.f11311d);
        long currentTimeMillis = System.currentTimeMillis();
        int i = eVar.f11402e.getInt("re_net_over", 7) * AlaAttentionManager.ALA_LIVE_PUSH_REMIND_TIME_INTERVAL;
        try {
            return this.f11310c.delete(r.f7699a, "(d <= ? or (d < (" + currentTimeMillis + "-f*3600000) and f!= 0)) and b != '1001001'and i != 5 ", new String[]{String.valueOf(currentTimeMillis - i)});
        } catch (Exception unused) {
            d.a();
            return -1;
        }
    }

    public final long a(com.baidu.sofire.d.a aVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("b", aVar.f11388b);
        contentValues.put("c", Integer.valueOf(aVar.f11389c));
        contentValues.put("d", Long.valueOf(aVar.f11391e));
        contentValues.put("e", Integer.valueOf(aVar.f11393g));
        contentValues.put("g", Integer.valueOf(aVar.f11392f));
        contentValues.put("f", Integer.valueOf(aVar.f11394h));
        contentValues.put("i", Integer.valueOf(aVar.i));
        contentValues.put("j", aVar.j);
        String str = aVar.f11390d;
        try {
            str = Base64.encodeToString(F.getInstance().ae(str.getBytes(), "xVOTuxgN3lkRN2v4".getBytes("utf-8")), 0);
        } catch (Exception unused) {
            d.a();
        }
        contentValues.put("h", str);
        try {
            return this.f11310c.insert(r.f7699a, null, contentValues);
        } catch (Throwable unused2) {
            d.a();
            return -1L;
        }
    }

    private int b(int i) {
        try {
            return this.f11310c.delete(r.f7699a, "a=?", new String[]{String.valueOf(i)});
        } catch (Throwable unused) {
            d.a();
            return -1;
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, INVOKE, INVOKE] complete} */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0026, code lost:
        if (r0 == null) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0017, code lost:
        if (r0 != null) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0019, code lost:
        r0.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x001d, code lost:
        com.baidu.sofire.g.d.a();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int b() {
        Cursor cursor = null;
        try {
            try {
                cursor = this.f11310c.query(r.f7699a, null, null, null, null, null, null, null);
                r1 = cursor != null ? cursor.getCount() : 0;
            } catch (Throwable th) {
                if (cursor != null) {
                    try {
                        cursor.close();
                    } catch (Exception unused) {
                        d.a();
                    }
                }
                throw th;
            }
        } catch (Exception unused2) {
            d.a();
        }
        return r1;
    }

    public final long a(String str) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("b", str);
        try {
            return this.f11310c.insert("c", null, contentValues);
        } catch (Throwable unused) {
            d.a();
            return -1L;
        }
    }

    public final int a(List<Integer> list) {
        int i = -1;
        try {
        } catch (Throwable unused) {
            d.a();
            d.a();
        }
        try {
            try {
                this.f11310c.beginTransaction();
                for (Integer num : list) {
                    i = b(num.intValue());
                    if (i <= 0) {
                        com.baidu.sofire.f.a.f11406d = System.currentTimeMillis();
                    }
                }
                this.f11310c.setTransactionSuccessful();
                this.f11310c.endTransaction();
            } catch (Throwable unused2) {
                com.baidu.sofire.f.a.f11406d = System.currentTimeMillis();
                d.a();
                this.f11310c.endTransaction();
            }
            return i;
        } catch (Throwable th) {
            try {
                try {
                    this.f11310c.endTransaction();
                } catch (Throwable unused3) {
                    com.baidu.sofire.f.a.f11406d = System.currentTimeMillis();
                    d.a();
                    throw th;
                }
            } catch (Throwable unused4) {
                d.a();
                d.a();
                throw th;
            }
            throw th;
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, INVOKE, INVOKE] complete} */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x012e, code lost:
        if (r3 != null) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0136, code lost:
        if (r3 == null) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0138, code lost:
        r3.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x013c, code lost:
        com.baidu.sofire.g.d.a();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List<com.baidu.sofire.d.a> a(int i) {
        String str;
        Cursor query;
        ArrayList arrayList = new ArrayList();
        long currentTimeMillis = System.currentTimeMillis();
        e eVar = new e(this.f11311d);
        int i2 = eVar.f11402e.getInt("re_net_wt", 3) * 3600000;
        if (i == 2) {
            str = "(d <= (" + currentTimeMillis + "-e*3600000) or e=0 )";
        } else {
            str = "(d <= (" + currentTimeMillis + "-e*3600000) or e=0 ) and (g!=2 or d<=" + (currentTimeMillis - i2) + SmallTailInfo.EMOTION_SUFFIX;
        }
        String str2 = str;
        Cursor cursor = null;
        try {
            try {
                if (i == 2) {
                    query = this.f11310c.query(r.f7699a, null, str2, null, null, null, "d desc", Integer.toString(100));
                } else {
                    query = this.f11310c.query(r.f7699a, null, str2, null, null, null, "d desc", Integer.toString(eVar.x()));
                }
                cursor = query;
                if (cursor != null) {
                    while (cursor.moveToNext()) {
                        com.baidu.sofire.d.a aVar = new com.baidu.sofire.d.a();
                        aVar.f11387a = cursor.getInt(cursor.getColumnIndex("a"));
                        aVar.f11388b = cursor.getString(cursor.getColumnIndex("b"));
                        aVar.f11389c = cursor.getInt(cursor.getColumnIndex("c"));
                        aVar.f11391e = cursor.getLong(cursor.getColumnIndex("d"));
                        aVar.f11392f = cursor.getInt(cursor.getColumnIndex("g"));
                        aVar.f11393g = cursor.getInt(cursor.getColumnIndex("e"));
                        aVar.f11394h = cursor.getInt(cursor.getColumnIndex("f"));
                        aVar.i = cursor.getInt(cursor.getColumnIndex("i"));
                        aVar.j = cursor.getString(cursor.getColumnIndex("j"));
                        String string = cursor.getString(cursor.getColumnIndex("h"));
                        try {
                            string = new String(F.getInstance().ad(Base64.decode(string, 0), "xVOTuxgN3lkRN2v4".getBytes("utf-8")));
                        } catch (Exception unused) {
                            d.a();
                        }
                        aVar.f11390d = string;
                        arrayList.add(aVar);
                    }
                }
            } catch (Throwable th) {
                if (cursor != null) {
                    try {
                        cursor.close();
                    } catch (Exception unused2) {
                        d.a();
                    }
                }
                throw th;
            }
        } catch (Exception unused3) {
            d.a();
        }
        return arrayList;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, INVOKE, INVOKE] complete} */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x00c3, code lost:
        if (r10 != null) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x00cb, code lost:
        if (r10 == null) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x00cd, code lost:
        r10.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x00d1, code lost:
        com.baidu.sofire.g.d.a();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List<com.baidu.sofire.d.a> a() {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            try {
                cursor = this.f11310c.query(r.f7699a, null, "i=5", null, null, null, "d desc", "100");
                if (cursor != null) {
                    while (cursor.moveToNext()) {
                        com.baidu.sofire.d.a aVar = new com.baidu.sofire.d.a();
                        aVar.f11387a = cursor.getInt(cursor.getColumnIndex("a"));
                        aVar.f11388b = cursor.getString(cursor.getColumnIndex("b"));
                        aVar.f11389c = cursor.getInt(cursor.getColumnIndex("c"));
                        aVar.f11391e = cursor.getLong(cursor.getColumnIndex("d"));
                        aVar.f11392f = cursor.getInt(cursor.getColumnIndex("g"));
                        aVar.f11393g = cursor.getInt(cursor.getColumnIndex("e"));
                        aVar.f11394h = cursor.getInt(cursor.getColumnIndex("f"));
                        aVar.i = cursor.getInt(cursor.getColumnIndex("i"));
                        aVar.j = cursor.getString(cursor.getColumnIndex("j"));
                        String string = cursor.getString(cursor.getColumnIndex("h"));
                        try {
                            string = new String(F.getInstance().ad(Base64.decode(string, 0), "xVOTuxgN3lkRN2v4".getBytes("utf-8")));
                        } catch (Exception unused) {
                            d.a();
                        }
                        aVar.f11390d = string;
                        arrayList.add(aVar);
                    }
                }
            } catch (Throwable th) {
                if (cursor != null) {
                    try {
                        cursor.close();
                    } catch (Exception unused2) {
                        d.a();
                    }
                }
                throw th;
            }
        } catch (Exception unused3) {
            d.a();
        }
        return arrayList;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, INVOKE, INVOKE] complete} */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x011e, code lost:
        if (r11 != null) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0126, code lost:
        if (r11 == null) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0128, code lost:
        r11.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x012c, code lost:
        com.baidu.sofire.g.d.a();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List<com.baidu.sofire.d.a> a(boolean z, int i) {
        String str;
        ArrayList arrayList = new ArrayList();
        long currentTimeMillis = System.currentTimeMillis();
        if (z) {
            str = "(d < (" + currentTimeMillis + "-f*3600000) and f!= 0)";
        } else {
            str = "d<=" + (currentTimeMillis - 259200000);
        }
        String str2 = str;
        Cursor cursor = null;
        try {
            try {
                if (i == 2) {
                    cursor = this.f11310c.query(r.f7699a, null, str2, null, null, null, "d desc", "100");
                } else {
                    int x = new e(this.f11311d).x();
                    new StringBuilder(" 3g limit").append(Integer.toString(x));
                    b.a();
                    cursor = this.f11310c.query(r.f7699a, null, str2, null, null, null, "d desc", Integer.toString(x));
                }
                if (cursor != null) {
                    while (cursor.moveToNext()) {
                        com.baidu.sofire.d.a aVar = new com.baidu.sofire.d.a();
                        aVar.f11387a = cursor.getInt(cursor.getColumnIndex("a"));
                        aVar.f11388b = cursor.getString(cursor.getColumnIndex("b"));
                        aVar.f11389c = cursor.getInt(cursor.getColumnIndex("c"));
                        aVar.f11391e = cursor.getLong(cursor.getColumnIndex("d"));
                        aVar.f11392f = cursor.getInt(cursor.getColumnIndex("g"));
                        aVar.f11393g = cursor.getInt(cursor.getColumnIndex("e"));
                        aVar.f11394h = cursor.getInt(cursor.getColumnIndex("f"));
                        aVar.i = cursor.getInt(cursor.getColumnIndex("i"));
                        aVar.j = cursor.getString(cursor.getColumnIndex("j"));
                        String string = cursor.getString(cursor.getColumnIndex("h"));
                        try {
                            string = new String(F.getInstance().ad(Base64.decode(string, 0), "xVOTuxgN3lkRN2v4".getBytes("utf-8")));
                        } catch (Exception unused) {
                            d.a();
                        }
                        aVar.f11390d = string;
                        arrayList.add(aVar);
                    }
                }
            } catch (Throwable th) {
                if (cursor != null) {
                    try {
                        cursor.close();
                    } catch (Exception unused2) {
                        d.a();
                    }
                }
                throw th;
            }
        } catch (Exception unused3) {
            d.a();
        }
        return arrayList;
    }
}
