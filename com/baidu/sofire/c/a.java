package com.baidu.sofire.c;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Base64;
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
    public static a f10095a;

    /* renamed from: b  reason: collision with root package name */
    public C0139a f10096b;

    /* renamed from: c  reason: collision with root package name */
    public SQLiteDatabase f10097c;

    /* renamed from: d  reason: collision with root package name */
    public Context f10098d;

    /* renamed from: com.baidu.sofire.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0139a extends SQLiteOpenHelper {
        public C0139a(Context context) {
            super(context, "d.db", (SQLiteDatabase.CursorFactory) null, 3);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onCreate(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.execSQL("create table if not exists r(a integer primary key autoincrement, b text, c integer, e integer,f integer,h text, g integer, i integer, j text, d long);");
            sQLiteDatabase.execSQL("create table if not exists c(a integer primary key autoincrement, b text); ");
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
            if (i2 <= 1) {
                sQLiteDatabase.execSQL("alter table r add i integer default 0;");
            }
            if (i2 <= 2) {
                sQLiteDatabase.execSQL("ALTER TABLE r ADD COLUMN j TEXT");
            }
        }
    }

    public a(Context context) {
        this.f10098d = context;
        C0139a c0139a = new C0139a(context);
        this.f10096b = c0139a;
        try {
            this.f10097c = c0139a.getWritableDatabase();
        } catch (Throwable unused) {
            d.a();
        }
    }

    public static synchronized a a(Context context) {
        a aVar;
        synchronized (a.class) {
            if (f10095a == null) {
                f10095a = new a(context);
            }
            aVar = f10095a;
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
            cursor = this.f10097c.query("c", null, "b=?", new String[]{str}, null, null, null);
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
        e eVar = new e(this.f10098d);
        long currentTimeMillis = System.currentTimeMillis();
        int i2 = eVar.f10193e.getInt("re_net_over", 7) * 86400000;
        try {
            return this.f10097c.delete(r.f7672a, "(d <= ? or (d < (" + currentTimeMillis + "-f*3600000) and f!= 0)) and b != '1001001'and i != 5 ", new String[]{String.valueOf(currentTimeMillis - i2)});
        } catch (Exception unused) {
            d.a();
            return -1;
        }
    }

    public final long a(com.baidu.sofire.d.a aVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("b", aVar.f10178b);
        contentValues.put("c", Integer.valueOf(aVar.f10179c));
        contentValues.put("d", Long.valueOf(aVar.f10181e));
        contentValues.put("e", Integer.valueOf(aVar.f10183g));
        contentValues.put("g", Integer.valueOf(aVar.f10182f));
        contentValues.put("f", Integer.valueOf(aVar.f10184h));
        contentValues.put("i", Integer.valueOf(aVar.f10185i));
        contentValues.put("j", aVar.j);
        String str = aVar.f10180d;
        try {
            str = Base64.encodeToString(F.getInstance().ae(str.getBytes(), "xVOTuxgN3lkRN2v4".getBytes("utf-8")), 0);
        } catch (Exception unused) {
            d.a();
        }
        contentValues.put("h", str);
        try {
            return this.f10097c.insert(r.f7672a, null, contentValues);
        } catch (Throwable unused2) {
            d.a();
            return -1L;
        }
    }

    private int b(int i2) {
        try {
            return this.f10097c.delete(r.f7672a, "a=?", new String[]{String.valueOf(i2)});
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
                cursor = this.f10097c.query(r.f7672a, null, null, null, null, null, null, null);
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
            return this.f10097c.insert("c", null, contentValues);
        } catch (Throwable unused) {
            d.a();
            return -1L;
        }
    }

    public final int a(List<Integer> list) {
        int i2 = -1;
        try {
        } catch (Throwable unused) {
            d.a();
            d.a();
        }
        try {
            try {
                this.f10097c.beginTransaction();
                for (Integer num : list) {
                    i2 = b(num.intValue());
                    if (i2 <= 0) {
                        com.baidu.sofire.f.a.f10197d = System.currentTimeMillis();
                    }
                }
                this.f10097c.setTransactionSuccessful();
                this.f10097c.endTransaction();
            } catch (Throwable unused2) {
                com.baidu.sofire.f.a.f10197d = System.currentTimeMillis();
                d.a();
                this.f10097c.endTransaction();
            }
            return i2;
        } catch (Throwable th) {
            try {
                try {
                    this.f10097c.endTransaction();
                } catch (Throwable unused3) {
                    com.baidu.sofire.f.a.f10197d = System.currentTimeMillis();
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
    public final List<com.baidu.sofire.d.a> a(int i2) {
        String str;
        Cursor query;
        ArrayList arrayList = new ArrayList();
        long currentTimeMillis = System.currentTimeMillis();
        e eVar = new e(this.f10098d);
        int i3 = eVar.f10193e.getInt("re_net_wt", 3) * 3600000;
        if (i2 == 2) {
            str = "(d <= (" + currentTimeMillis + "-e*3600000) or e=0 )";
        } else {
            str = "(d <= (" + currentTimeMillis + "-e*3600000) or e=0 ) and (g!=2 or d<=" + (currentTimeMillis - i3) + SmallTailInfo.EMOTION_SUFFIX;
        }
        String str2 = str;
        Cursor cursor = null;
        try {
            try {
                if (i2 == 2) {
                    query = this.f10097c.query(r.f7672a, null, str2, null, null, null, "d desc", Integer.toString(100));
                } else {
                    query = this.f10097c.query(r.f7672a, null, str2, null, null, null, "d desc", Integer.toString(eVar.x()));
                }
                cursor = query;
                if (cursor != null) {
                    while (cursor.moveToNext()) {
                        com.baidu.sofire.d.a aVar = new com.baidu.sofire.d.a();
                        aVar.f10177a = cursor.getInt(cursor.getColumnIndex("a"));
                        aVar.f10178b = cursor.getString(cursor.getColumnIndex("b"));
                        aVar.f10179c = cursor.getInt(cursor.getColumnIndex("c"));
                        aVar.f10181e = cursor.getLong(cursor.getColumnIndex("d"));
                        aVar.f10182f = cursor.getInt(cursor.getColumnIndex("g"));
                        aVar.f10183g = cursor.getInt(cursor.getColumnIndex("e"));
                        aVar.f10184h = cursor.getInt(cursor.getColumnIndex("f"));
                        aVar.f10185i = cursor.getInt(cursor.getColumnIndex("i"));
                        aVar.j = cursor.getString(cursor.getColumnIndex("j"));
                        String string = cursor.getString(cursor.getColumnIndex("h"));
                        try {
                            string = new String(F.getInstance().ad(Base64.decode(string, 0), "xVOTuxgN3lkRN2v4".getBytes("utf-8")));
                        } catch (Exception unused) {
                            d.a();
                        }
                        aVar.f10180d = string;
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
                cursor = this.f10097c.query(r.f7672a, null, "i=5", null, null, null, "d desc", "100");
                if (cursor != null) {
                    while (cursor.moveToNext()) {
                        com.baidu.sofire.d.a aVar = new com.baidu.sofire.d.a();
                        aVar.f10177a = cursor.getInt(cursor.getColumnIndex("a"));
                        aVar.f10178b = cursor.getString(cursor.getColumnIndex("b"));
                        aVar.f10179c = cursor.getInt(cursor.getColumnIndex("c"));
                        aVar.f10181e = cursor.getLong(cursor.getColumnIndex("d"));
                        aVar.f10182f = cursor.getInt(cursor.getColumnIndex("g"));
                        aVar.f10183g = cursor.getInt(cursor.getColumnIndex("e"));
                        aVar.f10184h = cursor.getInt(cursor.getColumnIndex("f"));
                        aVar.f10185i = cursor.getInt(cursor.getColumnIndex("i"));
                        aVar.j = cursor.getString(cursor.getColumnIndex("j"));
                        String string = cursor.getString(cursor.getColumnIndex("h"));
                        try {
                            string = new String(F.getInstance().ad(Base64.decode(string, 0), "xVOTuxgN3lkRN2v4".getBytes("utf-8")));
                        } catch (Exception unused) {
                            d.a();
                        }
                        aVar.f10180d = string;
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
    public final List<com.baidu.sofire.d.a> a(boolean z, int i2) {
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
                if (i2 == 2) {
                    cursor = this.f10097c.query(r.f7672a, null, str2, null, null, null, "d desc", "100");
                } else {
                    int x = new e(this.f10098d).x();
                    new StringBuilder(" 3g limit").append(Integer.toString(x));
                    b.a();
                    cursor = this.f10097c.query(r.f7672a, null, str2, null, null, null, "d desc", Integer.toString(x));
                }
                if (cursor != null) {
                    while (cursor.moveToNext()) {
                        com.baidu.sofire.d.a aVar = new com.baidu.sofire.d.a();
                        aVar.f10177a = cursor.getInt(cursor.getColumnIndex("a"));
                        aVar.f10178b = cursor.getString(cursor.getColumnIndex("b"));
                        aVar.f10179c = cursor.getInt(cursor.getColumnIndex("c"));
                        aVar.f10181e = cursor.getLong(cursor.getColumnIndex("d"));
                        aVar.f10182f = cursor.getInt(cursor.getColumnIndex("g"));
                        aVar.f10183g = cursor.getInt(cursor.getColumnIndex("e"));
                        aVar.f10184h = cursor.getInt(cursor.getColumnIndex("f"));
                        aVar.f10185i = cursor.getInt(cursor.getColumnIndex("i"));
                        aVar.j = cursor.getString(cursor.getColumnIndex("j"));
                        String string = cursor.getString(cursor.getColumnIndex("h"));
                        try {
                            string = new String(F.getInstance().ad(Base64.decode(string, 0), "xVOTuxgN3lkRN2v4".getBytes("utf-8")));
                        } catch (Exception unused) {
                            d.a();
                        }
                        aVar.f10180d = string;
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
