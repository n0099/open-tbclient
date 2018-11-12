package com.baidu.sofire.rp.b;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Base64;
import com.baidu.ar.util.IoUtils;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.ng.ai.apps.util.AiAppDateTimeUtil;
import com.baidu.sofire.ac.F;
import com.baidu.sofire.b;
import com.baidu.sofire.e;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private static a a;
    private C0140a b;
    private e c;
    private SQLiteDatabase d;
    private Context e;

    private a(Context context) {
        this.e = context;
        this.b = new C0140a(context);
        this.c = new e(context);
        d();
    }

    private void d() {
        try {
            this.d = this.b.getWritableDatabase();
        } catch (Throwable th) {
            com.baidu.sofire.b.e.a(th);
        }
    }

    public static synchronized a a(Context context) {
        a aVar;
        synchronized (a.class) {
            if (a == null) {
                a = new a(context);
            }
            aVar = a;
        }
        return aVar;
    }

    public long a(com.baidu.sofire.rp.c.a aVar) {
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
            str = Base64.encodeToString(F.getInstance().ae(str.getBytes(), "xVOTuxgN3lkRN2v4".getBytes(IoUtils.UTF_8)), 0);
        } catch (Exception e) {
            com.baidu.sofire.b.e.a(e);
        }
        contentValues.put("h", str);
        try {
            return this.d.insert("r", null, contentValues);
        } catch (Throwable th) {
            com.baidu.sofire.b.e.a(th);
            return -1L;
        }
    }

    public long a(String str) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("b", str);
        try {
            return this.d.insert("c", null, contentValues);
        } catch (Throwable th) {
            com.baidu.sofire.b.e.a(th);
            return -1L;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [150=4] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0024 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:45:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean b(String str) {
        Cursor cursor;
        boolean z;
        try {
            cursor = this.d.query("c", null, "b=?", new String[]{str}, null, null, null);
            if (cursor != null) {
                try {
                    if (cursor.getCount() > 0) {
                        z = false;
                        if (cursor == null) {
                            try {
                                cursor.close();
                                return z;
                            } catch (Exception e) {
                                com.baidu.sofire.b.e.a(e);
                                return z;
                            }
                        }
                        return z;
                    }
                } catch (Throwable th) {
                    th = th;
                    try {
                        com.baidu.sofire.b.e.a(th);
                        if (cursor != null) {
                            try {
                                cursor.close();
                                return true;
                            } catch (Exception e2) {
                                com.baidu.sofire.b.e.a(e2);
                                return true;
                            }
                        }
                        return true;
                    } catch (Throwable th2) {
                        Cursor cursor2 = cursor;
                        if (cursor2 != null) {
                            try {
                                cursor2.close();
                            } catch (Exception e3) {
                                com.baidu.sofire.b.e.a(e3);
                            }
                        }
                        throw th2;
                    }
                }
            }
            z = true;
            if (cursor == null) {
            }
        } catch (Throwable th3) {
            th = th3;
            cursor = null;
        }
    }

    public int a(int i) {
        try {
            return this.d.delete("r", "a=?", new String[]{i + ""});
        } catch (Throwable th) {
            com.baidu.sofire.b.e.a(th);
            return -1;
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE, MOVE_EXCEPTION, IGET, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
    public int a(List<Integer> list) {
        try {
            this.d.beginTransaction();
            for (Integer num : list) {
                a(num.intValue());
            }
            this.d.setTransactionSuccessful();
        } catch (Throwable th) {
            try {
                com.baidu.sofire.b.e.a(th);
                try {
                    this.d.endTransaction();
                } catch (Exception e) {
                    com.baidu.sofire.b.e.a(e);
                }
            } finally {
                try {
                    this.d.endTransaction();
                } catch (Exception e2) {
                    com.baidu.sofire.b.e.a(e2);
                }
            }
        }
        return -1;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [265=4] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01e0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<com.baidu.sofire.rp.c.a> b(int i) {
        Cursor cursor;
        String str;
        ArrayList arrayList = new ArrayList();
        long currentTimeMillis = System.currentTimeMillis();
        e eVar = new e(this.e);
        String str2 = i == 2 ? "(d <= (" + currentTimeMillis + Constants.ACCEPT_TIME_SEPARATOR_SERVER + "e*3600000) or e=0 )" : "(d <= (" + currentTimeMillis + Constants.ACCEPT_TIME_SEPARATOR_SERVER + "e*3600000) or e=0 ) and (g!=2 or d<=" + (currentTimeMillis - (eVar.T() * 3600000)) + ")";
        try {
            cursor = i == 2 ? this.d.query("r", null, str2, null, null, null, "d desc", Integer.toString(100)) : this.d.query("r", null, str2, null, null, null, "d desc", Integer.toString(eVar.V()));
            if (cursor != null) {
                while (cursor.moveToNext()) {
                    try {
                        try {
                            com.baidu.sofire.rp.c.a aVar = new com.baidu.sofire.rp.c.a();
                            aVar.a = cursor.getInt(cursor.getColumnIndex(Config.APP_VERSION_CODE));
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
                                str = new String(F.getInstance().ad(Base64.decode(string, 0), "xVOTuxgN3lkRN2v4".getBytes(IoUtils.UTF_8)));
                            } catch (Exception e) {
                                com.baidu.sofire.b.e.a(e);
                                str = string;
                            }
                            aVar.d = str;
                            arrayList.add(aVar);
                        } catch (Exception e2) {
                            e = e2;
                            com.baidu.sofire.b.e.a(e);
                            if (cursor != null) {
                                try {
                                    cursor.close();
                                } catch (Exception e3) {
                                    com.baidu.sofire.b.e.a(e3);
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
                                com.baidu.sofire.b.e.a(e4);
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
                    com.baidu.sofire.b.e.a(e5);
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [316=4] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00f0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<com.baidu.sofire.rp.c.a> a() {
        Cursor cursor;
        String str;
        ArrayList arrayList = new ArrayList();
        try {
            cursor = this.d.query("r", null, "i=5", null, null, null, "d desc", "100");
            if (cursor != null) {
                while (cursor.moveToNext()) {
                    try {
                        try {
                            com.baidu.sofire.rp.c.a aVar = new com.baidu.sofire.rp.c.a();
                            aVar.a = cursor.getInt(cursor.getColumnIndex(Config.APP_VERSION_CODE));
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
                                str = new String(F.getInstance().ad(Base64.decode(string, 0), "xVOTuxgN3lkRN2v4".getBytes(IoUtils.UTF_8)));
                            } catch (Exception e) {
                                com.baidu.sofire.b.e.a(e);
                                str = string;
                            }
                            aVar.d = str;
                            arrayList.add(aVar);
                        } catch (Exception e2) {
                            e = e2;
                            com.baidu.sofire.b.e.a(e);
                            if (cursor != null) {
                                try {
                                    cursor.close();
                                } catch (Exception e3) {
                                    com.baidu.sofire.b.e.a(e3);
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
                                com.baidu.sofire.b.e.a(e4);
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
                    com.baidu.sofire.b.e.a(e5);
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [389=4] */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:40:0x0195 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:44:0x018c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v20, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v3, types: [android.database.Cursor] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<com.baidu.sofire.rp.c.a> a(boolean z, int i) {
        String str;
        ?? r1;
        Cursor cursor;
        String str2;
        ArrayList arrayList = new ArrayList();
        long currentTimeMillis = System.currentTimeMillis();
        if (z) {
            r1 = "!= 0)";
            str = "(d < (" + currentTimeMillis + Constants.ACCEPT_TIME_SEPARATOR_SERVER + "f*3600000) and f!= 0)";
        } else {
            str = "d<=" + (currentTimeMillis - 259200000);
        }
        try {
            try {
                if (i == 2) {
                    cursor = this.d.query("r", null, str, null, null, null, "d desc", null);
                } else {
                    int V = new e(this.e).V();
                    b.a("sj-trigger report 3g limit" + Integer.toString(V));
                    cursor = this.d.query("r", null, str, null, null, null, "d desc", Integer.toString(V));
                }
                if (cursor != null) {
                    while (cursor.moveToNext()) {
                        try {
                            com.baidu.sofire.rp.c.a aVar = new com.baidu.sofire.rp.c.a();
                            aVar.a = cursor.getInt(cursor.getColumnIndex(Config.APP_VERSION_CODE));
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
                                str2 = new String(F.getInstance().ad(Base64.decode(string, 0), "xVOTuxgN3lkRN2v4".getBytes(IoUtils.UTF_8)));
                            } catch (Exception e) {
                                com.baidu.sofire.b.e.a(e);
                                str2 = string;
                            }
                            aVar.d = str2;
                            arrayList.add(aVar);
                        } catch (Exception e2) {
                            e = e2;
                            com.baidu.sofire.b.e.a(e);
                            if (cursor != null) {
                                try {
                                    cursor.close();
                                } catch (Exception e3) {
                                    com.baidu.sofire.b.e.a(e3);
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
                        com.baidu.sofire.b.e.a(e4);
                    }
                }
            } catch (Throwable th) {
                th = th;
                if (r1 != 0) {
                    try {
                        r1.close();
                    } catch (Exception e5) {
                        com.baidu.sofire.b.e.a(e5);
                    }
                }
                throw th;
            }
        } catch (Exception e6) {
            e = e6;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            r1 = 0;
            if (r1 != 0) {
            }
            throw th;
        }
        return arrayList;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [412=4] */
    /* JADX WARN: Not initialized variable reg: 1, insn: 0x0042: MOVE  (r10 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:26:0x0042 */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0038 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int b() {
        Cursor cursor;
        Cursor cursor2;
        int count;
        Cursor cursor3 = null;
        try {
            try {
                cursor = this.d.query("r", null, null, null, null, null, null, null);
                if (cursor != null) {
                    try {
                        count = cursor.getCount();
                    } catch (Exception e) {
                        e = e;
                        com.baidu.sofire.b.e.a(e);
                        if (cursor != null) {
                            try {
                                cursor.close();
                                return 0;
                            } catch (Exception e2) {
                                com.baidu.sofire.b.e.a(e2);
                                return 0;
                            }
                        }
                        return 0;
                    }
                } else {
                    count = 0;
                }
                if (cursor != null) {
                    try {
                        cursor.close();
                        return count;
                    } catch (Exception e3) {
                        com.baidu.sofire.b.e.a(e3);
                        return count;
                    }
                }
                return count;
            } catch (Throwable th) {
                th = th;
                cursor3 = cursor2;
                if (cursor3 != null) {
                    try {
                        cursor3.close();
                    } catch (Exception e4) {
                        com.baidu.sofire.b.e.a(e4);
                    }
                }
                throw th;
            }
        } catch (Exception e5) {
            e = e5;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            if (cursor3 != null) {
            }
            throw th;
        }
    }

    public int c() {
        e eVar = new e(this.e);
        long currentTimeMillis = System.currentTimeMillis();
        try {
            return this.d.delete("r", "(d <= ? or (d < (" + currentTimeMillis + Constants.ACCEPT_TIME_SEPARATOR_SERVER + "f*3600000) and f!= 0)) and b != '1001001'and i != 5 ", new String[]{String.valueOf(currentTimeMillis - (eVar.U() * AiAppDateTimeUtil.TIME_DAY_MILLISECOND))});
        } catch (Exception e) {
            com.baidu.sofire.b.e.a(e);
            return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.sofire.rp.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0140a extends SQLiteOpenHelper {
        public C0140a(Context context) {
            super(context, "d.db", (SQLiteDatabase.CursorFactory) null, 3);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.execSQL("create table if not exists r(a integer primary key autoincrement, b text, c integer, e integer,f integer,h text, g integer, i integer, j text, d long);");
            sQLiteDatabase.execSQL("create table if not exists c(a integer primary key autoincrement, b text); ");
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            if (i <= 1) {
                sQLiteDatabase.execSQL("alter table r add i integer default 0;");
            }
            if (i <= 2) {
                sQLiteDatabase.execSQL("ALTER TABLE r ADD COLUMN j TEXT");
            }
        }
    }
}
