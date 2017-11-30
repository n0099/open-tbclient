package com.baidu.sofire.rp.b;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Base64;
import com.baidu.sofire.rp.f.b;
import com.baidu.sofire.rp.f.f;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public final class a {
    private static a QF;
    private SQLiteDatabase Nx;
    private C0038a QG;
    private com.baidu.sofire.rp.a.a QH;
    private Context e;

    private a(Context context) {
        this.e = context;
        this.QG = new C0038a(context);
        this.QH = new com.baidu.sofire.rp.a.a(context);
        try {
            this.Nx = this.QG.getWritableDatabase();
        } catch (Throwable th) {
            b.a();
        }
    }

    public static synchronized a ar(Context context) {
        a aVar;
        synchronized (a.class) {
            if (QF == null) {
                QF = new a(context);
            }
            aVar = QF;
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
        String str = aVar.d;
        try {
            str = Base64.encodeToString(f.a(str.getBytes(), "xVOTuxgN3lkRN2v4".getBytes("utf-8")), 0);
        } catch (Exception e) {
            b.a();
        }
        contentValues.put("h", str);
        try {
            return this.Nx.insert("r", null, contentValues);
        } catch (Throwable th) {
            b.a();
            return -1L;
        }
    }

    public final long bN(String str) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("b", str);
        try {
            return this.Nx.insert("c", null, contentValues);
        } catch (Throwable th) {
            b.a();
            return -1L;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0023 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean b(String str) {
        boolean z;
        Cursor query;
        try {
            query = this.Nx.query("c", null, "b=?", new String[]{str}, null, null, null);
        } catch (Throwable th) {
            z = true;
        }
        if (query != null) {
            if (query.getCount() > 0) {
                z = false;
                if (query != null) {
                    try {
                        query.close();
                    } catch (Throwable th2) {
                        b.a();
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

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r8v0 int)] */
    private int b(int i) {
        try {
            return this.Nx.delete("r", "a=?", new String[]{new StringBuilder().append(i).toString()});
        } catch (Throwable th) {
            b.a();
            return -1;
        }
    }

    public final int a(List<Integer> list) {
        try {
            this.Nx.beginTransaction();
            for (Integer num : list) {
                b(num.intValue());
            }
            this.Nx.setTransactionSuccessful();
            try {
                this.Nx.endTransaction();
                return -1;
            } catch (Exception e) {
                b.a();
                return -1;
            }
        } catch (Throwable th) {
            try {
                b.a();
                try {
                    return -1;
                } catch (Exception e2) {
                    return -1;
                }
            } finally {
                try {
                    this.Nx.endTransaction();
                } catch (Exception e3) {
                    b.a();
                }
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [254=4] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0144 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List<com.baidu.sofire.rp.c.a> aZ(int i) {
        Cursor cursor;
        String str;
        Cursor cursor2 = null;
        ArrayList arrayList = new ArrayList();
        long currentTimeMillis = System.currentTimeMillis();
        com.baidu.sofire.rp.a.a aVar = new com.baidu.sofire.rp.a.a(this.e);
        String str2 = i == 2 ? "(d <= (" + currentTimeMillis + "-e*3600000) or e=0 )" : "(d <= (" + currentTimeMillis + "-e*3600000) or e=0 ) and (g!=2 or d<=" + (currentTimeMillis - (aVar.a.getInt("re_net_wt", 3) * 3600000)) + ")";
        try {
            cursor = i == 2 ? this.Nx.query("r", null, str2, null, null, null, "d desc", null) : this.Nx.query("r", null, str2, null, null, null, "d desc", Integer.toString(aVar.a.getInt("up_nu_li", 100)));
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
                            String string = cursor.getString(cursor.getColumnIndex("h"));
                            try {
                                str = new String(f.b(Base64.decode(string, 0), "xVOTuxgN3lkRN2v4".getBytes("utf-8")));
                            } catch (Exception e) {
                                str = string;
                                b.a();
                            }
                            aVar2.d = str;
                            arrayList.add(aVar2);
                        } catch (Exception e2) {
                            b.a();
                            if (cursor != null) {
                                try {
                                    cursor.close();
                                } catch (Exception e3) {
                                    b.a();
                                }
                            }
                            return arrayList;
                        }
                    } catch (Throwable th) {
                        cursor2 = cursor;
                        th = th;
                        if (cursor2 != null) {
                            try {
                                cursor2.close();
                            } catch (Exception e4) {
                                b.a();
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
                    b.a();
                }
            }
        } catch (Exception e6) {
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            if (cursor2 != null) {
            }
            throw th;
        }
        return arrayList;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [304=4] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00d0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List<com.baidu.sofire.rp.c.a> a() {
        Cursor cursor;
        String str;
        Cursor cursor2 = null;
        ArrayList arrayList = new ArrayList();
        try {
            cursor = this.Nx.query("r", null, "i=5", null, null, null, "d desc", "100");
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
                            String string = cursor.getString(cursor.getColumnIndex("h"));
                            try {
                                str = new String(f.b(Base64.decode(string, 0), "xVOTuxgN3lkRN2v4".getBytes("utf-8")));
                            } catch (Exception e) {
                                str = string;
                                b.a();
                            }
                            aVar.d = str;
                            arrayList.add(aVar);
                        } catch (Exception e2) {
                            b.a();
                            if (cursor != null) {
                                try {
                                    cursor.close();
                                } catch (Exception e3) {
                                    b.a();
                                }
                            }
                            return arrayList;
                        }
                    } catch (Throwable th) {
                        cursor2 = cursor;
                        th = th;
                        if (cursor2 != null) {
                            try {
                                cursor2.close();
                            } catch (Exception e4) {
                                b.a();
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
                    b.a();
                }
            }
        } catch (Exception e6) {
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            if (cursor2 != null) {
            }
            throw th;
        }
        return arrayList;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [376=4] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0139 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List<com.baidu.sofire.rp.c.a> b(boolean z, int i) {
        long currentTimeMillis;
        Cursor cursor;
        int i2;
        String str;
        Cursor cursor2 = null;
        ArrayList arrayList = new ArrayList();
        String str2 = z ? "(d < (" + System.currentTimeMillis() + "-f*3600000) and f!= 0)" : "d<=" + (currentTimeMillis - 259200000);
        try {
            try {
                if (i == 2) {
                    cursor = this.Nx.query("r", null, str2, null, null, null, "d desc", null);
                } else {
                    String str3 = " 3g limit" + Integer.toString(i2);
                    cursor = this.Nx.query("r", null, str2, null, null, null, "d desc", Integer.toString(new com.baidu.sofire.rp.a.a(this.e).a.getInt("up_nu_li", 100)));
                }
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
                            String string = cursor.getString(cursor.getColumnIndex("h"));
                            try {
                                str = new String(f.b(Base64.decode(string, 0), "xVOTuxgN3lkRN2v4".getBytes("utf-8")));
                            } catch (Exception e) {
                                str = string;
                                b.a();
                            }
                            aVar.d = str;
                            arrayList.add(aVar);
                        } catch (Exception e2) {
                            b.a();
                            if (cursor != null) {
                                try {
                                    cursor.close();
                                } catch (Exception e3) {
                                    b.a();
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
                        b.a();
                    }
                }
            } catch (Throwable th) {
                cursor2 = 2;
                th = th;
                if (cursor2 != null) {
                    try {
                        cursor2.close();
                    } catch (Exception e5) {
                        b.a();
                    }
                }
                throw th;
            }
        } catch (Exception e6) {
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            if (cursor2 != null) {
            }
            throw th;
        }
        return arrayList;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [425=4] */
    /* JADX WARN: Not initialized variable reg: 0, insn: 0x00c6: MOVE  (r9 I:??[OBJECT, ARRAY]) = (r0 I:??[OBJECT, ARRAY]), block:B:22:0x00c6 */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00ca A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List<com.baidu.sofire.rp.c.a> b() {
        Cursor cursor;
        Cursor cursor2;
        String str;
        Cursor cursor3 = null;
        ArrayList arrayList = new ArrayList();
        try {
            try {
                cursor = this.Nx.query("r", null, null, null, null, null, null, null);
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
                            String string = cursor.getString(cursor.getColumnIndex("h"));
                            try {
                                str = new String(f.b(Base64.decode(string, 0), "xVOTuxgN3lkRN2v4".getBytes("utf-8")));
                            } catch (Exception e) {
                                str = string;
                                b.a();
                            }
                            aVar.d = str;
                            arrayList.add(aVar);
                        } catch (Exception e2) {
                            b.a();
                            if (cursor != null) {
                                try {
                                    cursor.close();
                                } catch (Exception e3) {
                                    b.a();
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
                        b.a();
                    }
                }
            } catch (Throwable th) {
                cursor3 = cursor2;
                th = th;
                if (cursor3 != null) {
                    try {
                        cursor3.close();
                    } catch (Exception e5) {
                        b.a();
                    }
                }
                throw th;
            }
        } catch (Exception e6) {
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            if (cursor3 != null) {
            }
            throw th;
        }
        return arrayList;
    }

    public final int c() {
        com.baidu.sofire.rp.a.a aVar = new com.baidu.sofire.rp.a.a(this.e);
        long currentTimeMillis = System.currentTimeMillis();
        try {
            return this.Nx.delete("r", "(d <= ? or (d < (" + currentTimeMillis + "-f*3600000) and f!= 0)) and b != '1001001'and i != 5 ", new String[]{String.valueOf(currentTimeMillis - (aVar.a.getInt("re_net_over", 7) * 86400000))});
        } catch (Exception e) {
            b.a();
            return -1;
        }
    }

    /* renamed from: com.baidu.sofire.rp.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class C0038a extends SQLiteOpenHelper {
        public C0038a(Context context) {
            super(context, "d.db", (SQLiteDatabase.CursorFactory) null, 2);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onCreate(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.execSQL("create table if not exists r(a integer primary key autoincrement, b text, c integer, e integer,f integer,h text, g integer, i integer, d long);");
            sQLiteDatabase.execSQL("create table if not exists c(a integer primary key autoincrement, b text); ");
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            if (i <= 1) {
                sQLiteDatabase.execSQL("alter table r add i integer default 0;");
            }
        }
    }
}
