package com.baidu.sofire.rp.b;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Base64;
import com.baidu.sofire.ac.F;
import com.baidu.sofire.b.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public final class a {
    private static a QI;
    private SQLiteDatabase Nz;
    private C0052a QJ;
    private com.baidu.sofire.rp.a.a QK;
    private Context e;

    private a(Context context) {
        this.e = context;
        this.QJ = new C0052a(context);
        this.QK = new com.baidu.sofire.rp.a.a(context);
        try {
            this.Nz = this.QJ.getWritableDatabase();
        } catch (Throwable th) {
            d.a(th);
        }
    }

    public static synchronized a ar(Context context) {
        a aVar;
        synchronized (a.class) {
            if (QI == null) {
                QI = new a(context);
            }
            aVar = QI;
        }
        return aVar;
    }

    public final long a(com.baidu.sofire.rp.c.a aVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("b", aVar.b);
        contentValues.put("c", Integer.valueOf(aVar.c));
        contentValues.put("d", Long.valueOf(aVar.e));
        contentValues.put("e", Integer.valueOf(aVar.g));
        contentValues.put("g", Integer.valueOf(aVar.f));
        contentValues.put("f", Integer.valueOf(aVar.h));
        contentValues.put("i", Integer.valueOf(aVar.i));
        contentValues.put("j", aVar.j);
        String str = aVar.d;
        try {
            str = Base64.encodeToString(F.getInstance().ae(str.getBytes(), "xVOTuxgN3lkRN2v4".getBytes("utf-8")), 0);
        } catch (Exception e) {
            d.a(e);
        }
        contentValues.put("h", str);
        try {
            return this.Nz.insert("r", null, contentValues);
        } catch (Throwable th) {
            d.a(th);
            return -1L;
        }
    }

    public final long bO(String str) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("b", str);
        try {
            return this.Nz.insert("c", null, contentValues);
        } catch (Throwable th) {
            d.a(th);
            return -1L;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0023 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean b(String str) {
        Throwable th;
        boolean z;
        Cursor query;
        try {
            query = this.Nz.query("c", null, "b=?", new String[]{str}, null, null, null);
        } catch (Throwable th2) {
            th = th2;
            z = true;
        }
        if (query != null) {
            if (query.getCount() > 0) {
                z = false;
                if (query != null) {
                    try {
                        query.close();
                    } catch (Throwable th3) {
                        th = th3;
                        d.a(th);
                        return z;
                    }
                }
                return z;
            }
        }
        z = true;
        if (query != null) {
        }
        return z;
    }

    private int b(int i) {
        try {
            return this.Nz.delete("r", "a=?", new String[]{String.valueOf(i)});
        } catch (Throwable th) {
            d.a(th);
            return -1;
        }
    }

    public final int a(List<Integer> list) {
        try {
            this.Nz.beginTransaction();
            for (Integer num : list) {
                b(num.intValue());
            }
            this.Nz.setTransactionSuccessful();
            try {
                this.Nz.endTransaction();
                return -1;
            } catch (Exception e) {
                d.a(e);
                return -1;
            }
        } catch (Throwable th) {
            try {
                d.a(th);
                try {
                    return -1;
                } catch (Exception e2) {
                    return -1;
                }
            } finally {
                try {
                    this.Nz.endTransaction();
                } catch (Exception e22) {
                    d.a(e22);
                }
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [257=4] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0164 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List<com.baidu.sofire.rp.c.a> aZ(int i) {
        Cursor cursor;
        String str;
        ArrayList arrayList = new ArrayList();
        long currentTimeMillis = System.currentTimeMillis();
        com.baidu.sofire.rp.a.a aVar = new com.baidu.sofire.rp.a.a(this.e);
        String str2 = i == 2 ? "(d <= (" + currentTimeMillis + "-e*3600000) or e=0 )" : "(d <= (" + currentTimeMillis + "-e*3600000) or e=0 ) and (g!=2 or d<=" + (currentTimeMillis - (aVar.a.getInt("re_net_wt", 3) * 3600000)) + ")";
        try {
            cursor = i == 2 ? this.Nz.query("r", null, str2, null, null, null, "d desc", null) : this.Nz.query("r", null, str2, null, null, null, "d desc", Integer.toString(aVar.a.getInt("up_nu_li", 100)));
            if (cursor != null) {
                while (cursor.moveToNext()) {
                    try {
                        try {
                            com.baidu.sofire.rp.c.a aVar2 = new com.baidu.sofire.rp.c.a();
                            aVar2.a = cursor.getInt(cursor.getColumnIndex("a"));
                            aVar2.b = cursor.getString(cursor.getColumnIndex("b"));
                            aVar2.c = cursor.getInt(cursor.getColumnIndex("c"));
                            aVar2.e = cursor.getLong(cursor.getColumnIndex("d"));
                            aVar2.f = cursor.getInt(cursor.getColumnIndex("g"));
                            aVar2.g = cursor.getInt(cursor.getColumnIndex("e"));
                            aVar2.h = cursor.getInt(cursor.getColumnIndex("f"));
                            aVar2.i = cursor.getInt(cursor.getColumnIndex("i"));
                            aVar2.j = cursor.getString(cursor.getColumnIndex("j"));
                            String string = cursor.getString(cursor.getColumnIndex("h"));
                            try {
                                str = new String(F.getInstance().ad(Base64.decode(string, 0), "xVOTuxgN3lkRN2v4".getBytes("utf-8")));
                            } catch (Exception e) {
                                d.a(e);
                                str = string;
                            }
                            aVar2.d = str;
                            arrayList.add(aVar2);
                        } catch (Exception e2) {
                            e = e2;
                            d.a(e);
                            if (cursor != null) {
                                try {
                                    cursor.close();
                                } catch (Exception e3) {
                                    d.a(e3);
                                }
                            }
                            return arrayList;
                        }
                    } catch (Throwable th) {
                        th = th;
                        if (cursor != null) {
                            try {
                                cursor.close();
                            } catch (Exception e4) {
                                d.a(e4);
                            }
                        }
                        throw th;
                    }
                }
            }
            if (cursor != null) {
                try {
                    cursor.close();
                } catch (Exception e5) {
                    d.a(e5);
                }
            }
        } catch (Exception e6) {
            e = e6;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
            if (cursor != null) {
            }
            throw th;
        }
        return arrayList;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [308=4] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00f0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List<com.baidu.sofire.rp.c.a> a() {
        Cursor cursor;
        String str;
        ArrayList arrayList = new ArrayList();
        try {
            cursor = this.Nz.query("r", null, "i=5", null, null, null, "d desc", "100");
            if (cursor != null) {
                while (cursor.moveToNext()) {
                    try {
                        try {
                            com.baidu.sofire.rp.c.a aVar = new com.baidu.sofire.rp.c.a();
                            aVar.a = cursor.getInt(cursor.getColumnIndex("a"));
                            aVar.b = cursor.getString(cursor.getColumnIndex("b"));
                            aVar.c = cursor.getInt(cursor.getColumnIndex("c"));
                            aVar.e = cursor.getLong(cursor.getColumnIndex("d"));
                            aVar.f = cursor.getInt(cursor.getColumnIndex("g"));
                            aVar.g = cursor.getInt(cursor.getColumnIndex("e"));
                            aVar.h = cursor.getInt(cursor.getColumnIndex("f"));
                            aVar.i = cursor.getInt(cursor.getColumnIndex("i"));
                            aVar.j = cursor.getString(cursor.getColumnIndex("j"));
                            String string = cursor.getString(cursor.getColumnIndex("h"));
                            try {
                                str = new String(F.getInstance().ad(Base64.decode(string, 0), "xVOTuxgN3lkRN2v4".getBytes("utf-8")));
                            } catch (Exception e) {
                                d.a(e);
                                str = string;
                            }
                            aVar.d = str;
                            arrayList.add(aVar);
                        } catch (Exception e2) {
                            e = e2;
                            d.a(e);
                            if (cursor != null) {
                                try {
                                    cursor.close();
                                } catch (Exception e3) {
                                    d.a(e3);
                                }
                            }
                            return arrayList;
                        }
                    } catch (Throwable th) {
                        th = th;
                        if (cursor != null) {
                            try {
                                cursor.close();
                            } catch (Exception e4) {
                                d.a(e4);
                            }
                        }
                        throw th;
                    }
                }
            }
            if (cursor != null) {
                try {
                    cursor.close();
                } catch (Exception e5) {
                    d.a(e5);
                }
            }
        } catch (Exception e6) {
            e = e6;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
            if (cursor != null) {
            }
            throw th;
        }
        return arrayList;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [381=4] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0155 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List<com.baidu.sofire.rp.c.a> b(boolean z, int i) {
        long currentTimeMillis;
        Cursor cursor;
        String str;
        ArrayList arrayList = new ArrayList();
        String str2 = z ? "(d < (" + System.currentTimeMillis() + "-f*3600000) and f!= 0)" : "d<=" + (currentTimeMillis - 259200000);
        try {
            if (i == 2) {
                cursor = this.Nz.query("r", null, str2, null, null, null, "d desc", null);
            } else {
                int i2 = new com.baidu.sofire.rp.a.a(this.e).a.getInt("up_nu_li", 100);
                new StringBuilder("sj-trigger report 3g limit").append(Integer.toString(i2));
                cursor = this.Nz.query("r", null, str2, null, null, null, "d desc", Integer.toString(i2));
            }
            if (cursor != null) {
                while (cursor.moveToNext()) {
                    try {
                        try {
                            com.baidu.sofire.rp.c.a aVar = new com.baidu.sofire.rp.c.a();
                            aVar.a = cursor.getInt(cursor.getColumnIndex("a"));
                            aVar.b = cursor.getString(cursor.getColumnIndex("b"));
                            aVar.c = cursor.getInt(cursor.getColumnIndex("c"));
                            aVar.e = cursor.getLong(cursor.getColumnIndex("d"));
                            aVar.f = cursor.getInt(cursor.getColumnIndex("g"));
                            aVar.g = cursor.getInt(cursor.getColumnIndex("e"));
                            aVar.h = cursor.getInt(cursor.getColumnIndex("f"));
                            aVar.i = cursor.getInt(cursor.getColumnIndex("i"));
                            aVar.j = cursor.getString(cursor.getColumnIndex("j"));
                            String string = cursor.getString(cursor.getColumnIndex("h"));
                            try {
                                str = new String(F.getInstance().ad(Base64.decode(string, 0), "xVOTuxgN3lkRN2v4".getBytes("utf-8")));
                            } catch (Exception e) {
                                d.a(e);
                                str = string;
                            }
                            aVar.d = str;
                            arrayList.add(aVar);
                        } catch (Exception e2) {
                            e = e2;
                            d.a(e);
                            if (cursor != null) {
                                try {
                                    cursor.close();
                                } catch (Exception e3) {
                                    d.a(e3);
                                }
                            }
                            return arrayList;
                        }
                    } catch (Throwable th) {
                        th = th;
                        if (cursor != null) {
                            try {
                                cursor.close();
                            } catch (Exception e4) {
                                d.a(e4);
                            }
                        }
                        throw th;
                    }
                }
            }
            if (cursor != null) {
                try {
                    cursor.close();
                } catch (Exception e5) {
                    d.a(e5);
                }
            }
        } catch (Exception e6) {
            e = e6;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
            if (cursor != null) {
            }
            throw th;
        }
        return arrayList;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [431=4] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00ea A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List<com.baidu.sofire.rp.c.a> b() {
        Cursor cursor;
        String str;
        Cursor cursor2 = null;
        ArrayList arrayList = new ArrayList();
        try {
            try {
                cursor = this.Nz.query("r", null, null, null, null, null, null, null);
                if (cursor != null) {
                    while (cursor.moveToNext()) {
                        try {
                            com.baidu.sofire.rp.c.a aVar = new com.baidu.sofire.rp.c.a();
                            aVar.a = cursor.getInt(cursor.getColumnIndex("a"));
                            aVar.b = cursor.getString(cursor.getColumnIndex("b"));
                            aVar.c = cursor.getInt(cursor.getColumnIndex("c"));
                            aVar.e = cursor.getLong(cursor.getColumnIndex("d"));
                            aVar.f = cursor.getInt(cursor.getColumnIndex("g"));
                            aVar.g = cursor.getInt(cursor.getColumnIndex("e"));
                            aVar.h = cursor.getInt(cursor.getColumnIndex("f"));
                            aVar.i = cursor.getInt(cursor.getColumnIndex("i"));
                            aVar.j = cursor.getString(cursor.getColumnIndex("j"));
                            String string = cursor.getString(cursor.getColumnIndex("h"));
                            try {
                                str = new String(F.getInstance().ae(Base64.decode(string, 0), "xVOTuxgN3lkRN2v4".getBytes("utf-8")));
                            } catch (Exception e) {
                                d.a(e);
                                str = string;
                            }
                            aVar.d = str;
                            arrayList.add(aVar);
                        } catch (Exception e2) {
                            e = e2;
                            d.a(e);
                            if (cursor != null) {
                                try {
                                    cursor.close();
                                } catch (Exception e3) {
                                    d.a(e3);
                                }
                            }
                            return arrayList;
                        }
                    }
                }
                if (cursor != null) {
                    try {
                        cursor.close();
                    } catch (Exception e4) {
                        d.a(e4);
                    }
                }
            } catch (Throwable th) {
                th = th;
                if (0 != 0) {
                    try {
                        cursor2.close();
                    } catch (Exception e5) {
                        d.a(e5);
                    }
                }
                throw th;
            }
        } catch (Exception e6) {
            e = e6;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            if (0 != 0) {
            }
            throw th;
        }
        return arrayList;
    }

    public final int c() {
        com.baidu.sofire.rp.a.a aVar = new com.baidu.sofire.rp.a.a(this.e);
        long currentTimeMillis = System.currentTimeMillis();
        try {
            return this.Nz.delete("r", "(d <= ? or (d < (" + currentTimeMillis + "-f*3600000) and f!= 0)) and b != '1001001'and i != 5 ", new String[]{String.valueOf(currentTimeMillis - (aVar.a.getInt("re_net_over", 7) * 86400000))});
        } catch (Exception e) {
            d.a(e);
            return -1;
        }
    }

    /* renamed from: com.baidu.sofire.rp.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class C0052a extends SQLiteOpenHelper {
        public C0052a(Context context) {
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
}
