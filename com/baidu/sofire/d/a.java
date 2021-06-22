package com.baidu.sofire.d;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Base64;
import com.baidu.mapsdkplatform.comapi.map.r;
import com.baidu.sofire.ac.F;
import com.baidu.sofire.utility.c;
import com.baidu.tbadk.core.data.SmallTailInfo;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static a f10294a;

    /* renamed from: b  reason: collision with root package name */
    public C0142a f10295b;

    /* renamed from: c  reason: collision with root package name */
    public SQLiteDatabase f10296c;

    /* renamed from: d  reason: collision with root package name */
    public Context f10297d;

    /* renamed from: com.baidu.sofire.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0142a extends SQLiteOpenHelper {
        public C0142a(Context context) {
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
        this.f10297d = context;
        C0142a c0142a = new C0142a(context);
        this.f10295b = c0142a;
        try {
            this.f10296c = c0142a.getWritableDatabase();
        } catch (Throwable unused) {
            c.a();
        }
    }

    public static synchronized a a(Context context) {
        a aVar;
        synchronized (a.class) {
            if (f10294a == null) {
                f10294a = new a(context);
            }
            aVar = f10294a;
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
            cursor = this.f10296c.query("c", null, "b=?", new String[]{str}, null, null, null);
            if (cursor != null) {
                try {
                    if (cursor.getCount() > 0) {
                        z = false;
                    }
                } catch (Throwable unused) {
                    try {
                        c.a();
                    } finally {
                        if (cursor != null) {
                            try {
                                cursor.close();
                            } catch (Exception unused2) {
                                c.a();
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
        com.baidu.sofire.h.a a2 = com.baidu.sofire.h.a.a(this.f10297d);
        long currentTimeMillis = System.currentTimeMillis();
        int i2 = a2.f10325e.getInt("re_net_over", 7) * 86400000;
        try {
            return this.f10296c.delete(r.f7715a, "(d <= ? or (d < (" + currentTimeMillis + "-f*3600000) and f!= 0)) and b != '1001001'and i != 5 ", new String[]{String.valueOf(currentTimeMillis - i2)});
        } catch (Exception unused) {
            c.a();
            return -1;
        }
    }

    public final long a(com.baidu.sofire.e.a aVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("b", aVar.f10300b);
        contentValues.put("c", Integer.valueOf(aVar.f10301c));
        contentValues.put("d", Long.valueOf(aVar.f10303e));
        contentValues.put("e", Integer.valueOf(aVar.f10305g));
        contentValues.put("g", Integer.valueOf(aVar.f10304f));
        contentValues.put("f", Integer.valueOf(aVar.f10306h));
        contentValues.put("i", Integer.valueOf(aVar.f10307i));
        contentValues.put("j", aVar.j);
        String str = aVar.f10302d;
        try {
            str = Base64.encodeToString(F.getInstance().ae(str.getBytes(), "xVOTuxgN3lkRN2v4".getBytes("utf-8")), 0);
        } catch (Exception unused) {
            c.a();
        }
        contentValues.put("h", str);
        try {
            return this.f10296c.insert(r.f7715a, null, contentValues);
        } catch (Throwable unused2) {
            c.a();
            return -1L;
        }
    }

    private int b(int i2) {
        try {
            return this.f10296c.delete(r.f7715a, "a=?", new String[]{String.valueOf(i2)});
        } catch (Throwable unused) {
            c.a();
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
        com.baidu.sofire.utility.c.a();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int b() {
        Cursor cursor = null;
        try {
            try {
                cursor = this.f10296c.query(r.f7715a, null, null, null, null, null, null, null);
                r1 = cursor != null ? cursor.getCount() : 0;
            } catch (Throwable th) {
                if (cursor != null) {
                    try {
                        cursor.close();
                    } catch (Exception unused) {
                        c.a();
                    }
                }
                throw th;
            }
        } catch (Exception unused2) {
            c.a();
        }
        return r1;
    }

    public final long a(String str) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("b", str);
        try {
            return this.f10296c.insert("c", null, contentValues);
        } catch (Throwable unused) {
            c.a();
            return -1L;
        }
    }

    public final int a(List<Integer> list) {
        int i2 = -1;
        try {
        } catch (Throwable unused) {
            c.a();
            c.a();
        }
        try {
            try {
                this.f10296c.beginTransaction();
                for (Integer num : list) {
                    i2 = b(num.intValue());
                    if (i2 <= 0) {
                        com.baidu.sofire.g.a.f10312d = System.currentTimeMillis();
                    }
                }
                this.f10296c.setTransactionSuccessful();
                this.f10296c.endTransaction();
            } catch (Throwable unused2) {
                com.baidu.sofire.g.a.f10312d = System.currentTimeMillis();
                c.a();
                this.f10296c.endTransaction();
            }
            return i2;
        } catch (Throwable th) {
            try {
                try {
                    this.f10296c.endTransaction();
                } catch (Throwable unused3) {
                    com.baidu.sofire.g.a.f10312d = System.currentTimeMillis();
                    c.a();
                    throw th;
                }
            } catch (Throwable unused4) {
                c.a();
                c.a();
                throw th;
            }
            throw th;
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, INVOKE, INVOKE] complete} */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x012d, code lost:
        if (r3 != null) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0135, code lost:
        if (r3 == null) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0137, code lost:
        r3.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x013b, code lost:
        com.baidu.sofire.utility.c.a();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List<com.baidu.sofire.e.a> a(int i2) {
        String str;
        Cursor query;
        ArrayList arrayList = new ArrayList();
        long currentTimeMillis = System.currentTimeMillis();
        com.baidu.sofire.h.a a2 = com.baidu.sofire.h.a.a(this.f10297d);
        int i3 = a2.f10325e.getInt("re_net_wt", 3) * 3600000;
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
                    query = this.f10296c.query(r.f7715a, null, str2, null, null, null, "d desc", Integer.toString(100));
                } else {
                    query = this.f10296c.query(r.f7715a, null, str2, null, null, null, "d desc", Integer.toString(a2.v()));
                }
                cursor = query;
                if (cursor != null) {
                    while (cursor.moveToNext()) {
                        com.baidu.sofire.e.a aVar = new com.baidu.sofire.e.a();
                        aVar.f10299a = cursor.getInt(cursor.getColumnIndex("a"));
                        aVar.f10300b = cursor.getString(cursor.getColumnIndex("b"));
                        aVar.f10301c = cursor.getInt(cursor.getColumnIndex("c"));
                        aVar.f10303e = cursor.getLong(cursor.getColumnIndex("d"));
                        aVar.f10304f = cursor.getInt(cursor.getColumnIndex("g"));
                        aVar.f10305g = cursor.getInt(cursor.getColumnIndex("e"));
                        aVar.f10306h = cursor.getInt(cursor.getColumnIndex("f"));
                        aVar.f10307i = cursor.getInt(cursor.getColumnIndex("i"));
                        aVar.j = cursor.getString(cursor.getColumnIndex("j"));
                        String string = cursor.getString(cursor.getColumnIndex("h"));
                        try {
                            string = new String(F.getInstance().ad(Base64.decode(string, 0), "xVOTuxgN3lkRN2v4".getBytes("utf-8")));
                        } catch (Exception unused) {
                            c.a();
                        }
                        aVar.f10302d = string;
                        arrayList.add(aVar);
                    }
                }
            } catch (Throwable th) {
                if (cursor != null) {
                    try {
                        cursor.close();
                    } catch (Exception unused2) {
                        c.a();
                    }
                }
                throw th;
            }
        } catch (Exception unused3) {
            c.a();
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
        com.baidu.sofire.utility.c.a();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List<com.baidu.sofire.e.a> a() {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            try {
                cursor = this.f10296c.query(r.f7715a, null, "i=5", null, null, null, "d desc", "100");
                if (cursor != null) {
                    while (cursor.moveToNext()) {
                        com.baidu.sofire.e.a aVar = new com.baidu.sofire.e.a();
                        aVar.f10299a = cursor.getInt(cursor.getColumnIndex("a"));
                        aVar.f10300b = cursor.getString(cursor.getColumnIndex("b"));
                        aVar.f10301c = cursor.getInt(cursor.getColumnIndex("c"));
                        aVar.f10303e = cursor.getLong(cursor.getColumnIndex("d"));
                        aVar.f10304f = cursor.getInt(cursor.getColumnIndex("g"));
                        aVar.f10305g = cursor.getInt(cursor.getColumnIndex("e"));
                        aVar.f10306h = cursor.getInt(cursor.getColumnIndex("f"));
                        aVar.f10307i = cursor.getInt(cursor.getColumnIndex("i"));
                        aVar.j = cursor.getString(cursor.getColumnIndex("j"));
                        String string = cursor.getString(cursor.getColumnIndex("h"));
                        try {
                            string = new String(F.getInstance().ad(Base64.decode(string, 0), "xVOTuxgN3lkRN2v4".getBytes("utf-8")));
                        } catch (Exception unused) {
                            c.a();
                        }
                        aVar.f10302d = string;
                        arrayList.add(aVar);
                    }
                }
            } catch (Throwable th) {
                if (cursor != null) {
                    try {
                        cursor.close();
                    } catch (Exception unused2) {
                        c.a();
                    }
                }
                throw th;
            }
        } catch (Exception unused3) {
            c.a();
        }
        return arrayList;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, INVOKE, INVOKE] complete} */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x010c, code lost:
        if (r11 != null) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0114, code lost:
        if (r11 == null) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0116, code lost:
        r11.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x011a, code lost:
        com.baidu.sofire.utility.c.a();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List<com.baidu.sofire.e.a> a(boolean z, int i2) {
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
                    cursor = this.f10296c.query(r.f7715a, null, str2, null, null, null, "d desc", "100");
                } else {
                    cursor = this.f10296c.query(r.f7715a, null, str2, null, null, null, "d desc", Integer.toString(com.baidu.sofire.h.a.a(this.f10297d).v()));
                }
                if (cursor != null) {
                    while (cursor.moveToNext()) {
                        com.baidu.sofire.e.a aVar = new com.baidu.sofire.e.a();
                        aVar.f10299a = cursor.getInt(cursor.getColumnIndex("a"));
                        aVar.f10300b = cursor.getString(cursor.getColumnIndex("b"));
                        aVar.f10301c = cursor.getInt(cursor.getColumnIndex("c"));
                        aVar.f10303e = cursor.getLong(cursor.getColumnIndex("d"));
                        aVar.f10304f = cursor.getInt(cursor.getColumnIndex("g"));
                        aVar.f10305g = cursor.getInt(cursor.getColumnIndex("e"));
                        aVar.f10306h = cursor.getInt(cursor.getColumnIndex("f"));
                        aVar.f10307i = cursor.getInt(cursor.getColumnIndex("i"));
                        aVar.j = cursor.getString(cursor.getColumnIndex("j"));
                        String string = cursor.getString(cursor.getColumnIndex("h"));
                        try {
                            string = new String(F.getInstance().ad(Base64.decode(string, 0), "xVOTuxgN3lkRN2v4".getBytes("utf-8")));
                        } catch (Exception unused) {
                            c.a();
                        }
                        aVar.f10302d = string;
                        arrayList.add(aVar);
                    }
                }
            } catch (Exception unused2) {
                c.a();
            }
            return arrayList;
        } catch (Throwable th) {
            if (cursor != null) {
                try {
                    cursor.close();
                } catch (Exception unused3) {
                    c.a();
                }
            }
            throw th;
        }
    }
}
