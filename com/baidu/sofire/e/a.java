package com.baidu.sofire.e;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Base64;
import com.baidu.live.tbadk.data.Config;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.pass.biometrics.face.liveness.d.b;
import com.baidu.sofire.ac.F;
import com.baidu.sofire.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static a f3622a;
    private C0356a b;
    private e c;
    private SQLiteDatabase d;
    private Context e;

    private a(Context context) {
        this.e = context;
        this.b = new C0356a(context);
        this.c = new e(context);
        try {
            this.d = this.b.getWritableDatabase();
        } catch (Throwable th) {
            com.baidu.sofire.i.e.a();
        }
    }

    public static synchronized a a(Context context) {
        a aVar;
        synchronized (a.class) {
            if (f3622a == null) {
                f3622a = new a(context);
            }
            aVar = f3622a;
        }
        return aVar;
    }

    public final long a(com.baidu.sofire.f.a aVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(b.f2753a, aVar.b);
        contentValues.put("c", Integer.valueOf(aVar.c));
        contentValues.put("d", Long.valueOf(aVar.e));
        contentValues.put("e", Integer.valueOf(aVar.g));
        contentValues.put(IXAdRequestInfo.GPS, Integer.valueOf(aVar.f));
        contentValues.put("f", Integer.valueOf(aVar.h));
        contentValues.put("i", Integer.valueOf(aVar.i));
        contentValues.put("j", aVar.j);
        String str = aVar.d;
        try {
            str = Base64.encodeToString(F.getInstance().ae(str.getBytes(), "xVOTuxgN3lkRN2v4".getBytes("utf-8")), 0);
        } catch (Exception e) {
            com.baidu.sofire.i.e.a();
        }
        contentValues.put("h", str);
        try {
            return this.d.insert("r", null, contentValues);
        } catch (Throwable th) {
            com.baidu.sofire.i.e.a();
            return -1L;
        }
    }

    public final long a(String str) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(b.f2753a, str);
        try {
            return this.d.insert("c", null, contentValues);
        } catch (Throwable th) {
            com.baidu.sofire.i.e.a();
            return -1L;
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [158=4] */
    public final boolean b(java.lang.String r12) {
        /*
            r11 = this;
            r8 = 1
            r10 = 0
            r9 = 0
            java.lang.String r3 = "b=?"
            r0 = 1
            java.lang.String[] r4 = new java.lang.String[r0]     // Catch: java.lang.Throwable -> L2d
            r0 = 0
            r4[r0] = r12     // Catch: java.lang.Throwable -> L2d
            android.database.sqlite.SQLiteDatabase r0 = r11.d     // Catch: java.lang.Throwable -> L2d
            java.lang.String r1 = "c"
            r2 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L2d
            if (r1 == 0) goto L57
            int r0 = r1.getCount()     // Catch: java.lang.Throwable -> L52
            if (r0 <= 0) goto L57
            r0 = r10
        L22:
            if (r1 == 0) goto L27
            r1.close()     // Catch: java.lang.Exception -> L28
        L27:
            return r0
        L28:
            r1 = move-exception
            com.baidu.sofire.i.e.a()
            goto L27
        L2d:
            r0 = move-exception
            r0 = r9
        L2f:
            com.baidu.sofire.i.e.a()     // Catch: java.lang.Throwable -> L4e
            if (r0 == 0) goto L55
            r0.close()     // Catch: java.lang.Exception -> L39
            r0 = r8
            goto L27
        L39:
            r0 = move-exception
            com.baidu.sofire.i.e.a()
            r0 = r8
            goto L27
        L3f:
            r0 = move-exception
        L40:
            if (r9 == 0) goto L45
            r9.close()     // Catch: java.lang.Exception -> L46
        L45:
            throw r0
        L46:
            r1 = move-exception
            com.baidu.sofire.i.e.a()
            goto L45
        L4b:
            r0 = move-exception
            r9 = r1
            goto L40
        L4e:
            r1 = move-exception
            r9 = r0
            r0 = r1
            goto L40
        L52:
            r0 = move-exception
            r0 = r1
            goto L2f
        L55:
            r0 = r8
            goto L27
        L57:
            r0 = r8
            goto L22
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.e.a.b(java.lang.String):boolean");
    }

    private int b(int i) {
        try {
            return this.d.delete("r", "a=?", new String[]{String.valueOf(i)});
        } catch (Throwable th) {
            com.baidu.sofire.i.e.a();
            return -1;
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE, INVOKE, INVOKE, INVOKE, INVOKE, MOVE_EXCEPTION, INVOKE, SPUT, INVOKE, INVOKE, INVOKE, MOVE_EXCEPTION, MOVE_EXCEPTION, IGET, INVOKE, INVOKE, INVOKE, INVOKE, INVOKE, INVOKE, MOVE_EXCEPTION, INVOKE, SPUT, INVOKE, INVOKE, INVOKE, MOVE_EXCEPTION, MOVE_EXCEPTION] complete} */
    /* JADX DEBUG: Incorrect finally slice size: {[INVOKE, INVOKE, MOVE, INVOKE, INVOKE, MOVE, INVOKE, MOVE_EXCEPTION, INVOKE, SPUT, INVOKE, INVOKE, MOVE, INVOKE, MOVE_EXCEPTION, MOVE_EXCEPTION, IGET, INVOKE, INVOKE, INVOKE, MOVE, INVOKE, INVOKE, MOVE, INVOKE, MOVE_EXCEPTION, INVOKE, SPUT, INVOKE, INVOKE, MOVE, INVOKE, MOVE_EXCEPTION, MOVE_EXCEPTION] complete}, expected: {[INVOKE, INVOKE, INVOKE, INVOKE, INVOKE, MOVE_EXCEPTION, INVOKE, SPUT, INVOKE, INVOKE, INVOKE, MOVE_EXCEPTION, MOVE_EXCEPTION, IGET, INVOKE, INVOKE, INVOKE, INVOKE, INVOKE, INVOKE, MOVE_EXCEPTION, INVOKE, SPUT, INVOKE, INVOKE, INVOKE, MOVE_EXCEPTION, MOVE_EXCEPTION] complete} */
    /* JADX WARN: Finally extract failed */
    public final int a(List<Integer> list) {
        int i = -1;
        try {
            this.d.beginTransaction();
            for (Integer num : list) {
                i = b(num.intValue());
                if (i <= 0) {
                    com.baidu.sofire.h.a.d = System.currentTimeMillis();
                }
            }
            this.d.setTransactionSuccessful();
            try {
                this.d.endTransaction();
                return i;
            } catch (Throwable th) {
                try {
                    com.baidu.sofire.h.a.d = System.currentTimeMillis();
                } catch (Throwable th2) {
                    com.baidu.sofire.i.e.a();
                }
                com.baidu.sofire.i.e.a();
                return i;
            }
        } catch (Throwable th3) {
            int i2 = i;
            try {
                com.baidu.sofire.h.a.d = System.currentTimeMillis();
                com.baidu.sofire.i.e.a();
                try {
                    this.d.endTransaction();
                    return i2;
                } catch (Throwable th4) {
                    try {
                        com.baidu.sofire.h.a.d = System.currentTimeMillis();
                    } catch (Throwable th5) {
                        com.baidu.sofire.i.e.a();
                    }
                    com.baidu.sofire.i.e.a();
                    return i2;
                }
            } catch (Throwable th6) {
                try {
                    this.d.endTransaction();
                } catch (Throwable th7) {
                    try {
                        com.baidu.sofire.h.a.d = System.currentTimeMillis();
                    } catch (Throwable th8) {
                        com.baidu.sofire.i.e.a();
                    }
                    com.baidu.sofire.i.e.a();
                }
                throw th6;
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [293=4] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0153 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List<com.baidu.sofire.f.a> a(int i) {
        StringBuilder append;
        String sb;
        Cursor cursor;
        String str;
        Cursor cursor2 = null;
        ArrayList arrayList = new ArrayList();
        long currentTimeMillis = System.currentTimeMillis();
        e eVar = new e(this.e);
        int i2 = eVar.e.getInt("re_net_wt", 3) * 3600000;
        if (i == 2) {
            append = new StringBuilder("(d <= (").append(currentTimeMillis).append("-e*3600000) or e=0 )");
            sb = append.toString();
        } else {
            append = new StringBuilder("(d <= (").append(currentTimeMillis).append("-e*3600000) or e=0 ) and (g!=2 or d<=").append(currentTimeMillis - i2).append(")");
            sb = append.toString();
        }
        try {
            try {
                if (i == 2) {
                    cursor = this.d.query("r", null, sb, null, null, null, "d desc", Integer.toString(100));
                } else {
                    cursor = this.d.query("r", null, sb, null, null, null, "d desc", Integer.toString(eVar.z()));
                }
                if (cursor != null) {
                    while (cursor.moveToNext()) {
                        try {
                            com.baidu.sofire.f.a aVar = new com.baidu.sofire.f.a();
                            aVar.f3624a = cursor.getInt(cursor.getColumnIndex("a"));
                            aVar.b = cursor.getString(cursor.getColumnIndex(b.f2753a));
                            aVar.c = cursor.getInt(cursor.getColumnIndex("c"));
                            aVar.e = cursor.getLong(cursor.getColumnIndex("d"));
                            aVar.f = cursor.getInt(cursor.getColumnIndex(IXAdRequestInfo.GPS));
                            aVar.g = cursor.getInt(cursor.getColumnIndex("e"));
                            aVar.h = cursor.getInt(cursor.getColumnIndex("f"));
                            aVar.i = cursor.getInt(cursor.getColumnIndex("i"));
                            aVar.j = cursor.getString(cursor.getColumnIndex("j"));
                            String string = cursor.getString(cursor.getColumnIndex("h"));
                            try {
                                str = new String(F.getInstance().ad(Base64.decode(string, 0), "xVOTuxgN3lkRN2v4".getBytes("utf-8")));
                            } catch (Exception e) {
                                str = string;
                                com.baidu.sofire.i.e.a();
                            }
                            aVar.d = str;
                            arrayList.add(aVar);
                        } catch (Exception e2) {
                            com.baidu.sofire.i.e.a();
                            if (cursor != null) {
                                try {
                                    cursor.close();
                                } catch (Exception e3) {
                                    com.baidu.sofire.i.e.a();
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
                        com.baidu.sofire.i.e.a();
                    }
                }
            } catch (Throwable th) {
                cursor2 = append;
                th = th;
                if (cursor2 != null) {
                    try {
                        cursor2.close();
                    } catch (Exception e5) {
                        com.baidu.sofire.i.e.a();
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [348=4] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00e1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List<com.baidu.sofire.f.a> a() {
        Cursor cursor;
        String str;
        Cursor cursor2 = null;
        ArrayList arrayList = new ArrayList();
        try {
            cursor = this.d.query("r", null, "i=5", null, null, null, "d desc", "100");
            if (cursor != null) {
                while (cursor.moveToNext()) {
                    try {
                        try {
                            com.baidu.sofire.f.a aVar = new com.baidu.sofire.f.a();
                            aVar.f3624a = cursor.getInt(cursor.getColumnIndex("a"));
                            aVar.b = cursor.getString(cursor.getColumnIndex(b.f2753a));
                            aVar.c = cursor.getInt(cursor.getColumnIndex("c"));
                            aVar.e = cursor.getLong(cursor.getColumnIndex("d"));
                            aVar.f = cursor.getInt(cursor.getColumnIndex(IXAdRequestInfo.GPS));
                            aVar.g = cursor.getInt(cursor.getColumnIndex("e"));
                            aVar.h = cursor.getInt(cursor.getColumnIndex("f"));
                            aVar.i = cursor.getInt(cursor.getColumnIndex("i"));
                            aVar.j = cursor.getString(cursor.getColumnIndex("j"));
                            String string = cursor.getString(cursor.getColumnIndex("h"));
                            try {
                                str = new String(F.getInstance().ad(Base64.decode(string, 0), "xVOTuxgN3lkRN2v4".getBytes("utf-8")));
                            } catch (Exception e) {
                                str = string;
                                com.baidu.sofire.i.e.a();
                            }
                            aVar.d = str;
                            arrayList.add(aVar);
                        } catch (Exception e2) {
                            com.baidu.sofire.i.e.a();
                            if (cursor != null) {
                                try {
                                    cursor.close();
                                } catch (Exception e3) {
                                    com.baidu.sofire.i.e.a();
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
                                com.baidu.sofire.i.e.a();
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
                    com.baidu.sofire.i.e.a();
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [424=4] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0144 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List<com.baidu.sofire.f.a> a(boolean z, int i) {
        long currentTimeMillis;
        Cursor cursor;
        String str;
        Cursor cursor2 = null;
        ArrayList arrayList = new ArrayList();
        String str2 = z ? "(d < (" + System.currentTimeMillis() + "-f*3600000) and f!= 0)" : "d<=" + (currentTimeMillis - Config.THREAD_IMAGE_SAVE_MAX_TIME);
        try {
            if (i == 2) {
                cursor = this.d.query("r", null, str2, null, null, null, "d desc", "100");
            } else {
                int z2 = new e(this.e).z();
                new StringBuilder(" 3g limit").append(Integer.toString(z2));
                com.baidu.sofire.b.a();
                cursor = this.d.query("r", null, str2, null, null, null, "d desc", Integer.toString(z2));
            }
            if (cursor != null) {
                while (cursor.moveToNext()) {
                    try {
                        try {
                            com.baidu.sofire.f.a aVar = new com.baidu.sofire.f.a();
                            aVar.f3624a = cursor.getInt(cursor.getColumnIndex("a"));
                            aVar.b = cursor.getString(cursor.getColumnIndex(b.f2753a));
                            aVar.c = cursor.getInt(cursor.getColumnIndex("c"));
                            aVar.e = cursor.getLong(cursor.getColumnIndex("d"));
                            aVar.f = cursor.getInt(cursor.getColumnIndex(IXAdRequestInfo.GPS));
                            aVar.g = cursor.getInt(cursor.getColumnIndex("e"));
                            aVar.h = cursor.getInt(cursor.getColumnIndex("f"));
                            aVar.i = cursor.getInt(cursor.getColumnIndex("i"));
                            aVar.j = cursor.getString(cursor.getColumnIndex("j"));
                            String string = cursor.getString(cursor.getColumnIndex("h"));
                            try {
                                str = new String(F.getInstance().ad(Base64.decode(string, 0), "xVOTuxgN3lkRN2v4".getBytes("utf-8")));
                            } catch (Exception e) {
                                str = string;
                                com.baidu.sofire.i.e.a();
                            }
                            aVar.d = str;
                            arrayList.add(aVar);
                        } catch (Exception e2) {
                            com.baidu.sofire.i.e.a();
                            if (cursor != null) {
                                try {
                                    cursor.close();
                                } catch (Exception e3) {
                                    com.baidu.sofire.i.e.a();
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
                                com.baidu.sofire.i.e.a();
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
                    com.baidu.sofire.i.e.a();
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [447=4] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0038 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int b() {
        Cursor cursor;
        int count;
        Cursor cursor2 = null;
        try {
            Cursor query = this.d.query("r", null, null, null, null, null, null, null);
            if (query != null) {
                try {
                    count = query.getCount();
                } catch (Exception e) {
                    cursor = query;
                    try {
                        com.baidu.sofire.i.e.a();
                        if (cursor != null) {
                            try {
                                cursor.close();
                                return 0;
                            } catch (Exception e2) {
                                com.baidu.sofire.i.e.a();
                                return 0;
                            }
                        }
                        return 0;
                    } catch (Throwable th) {
                        cursor2 = cursor;
                        th = th;
                        if (cursor2 != null) {
                            try {
                                cursor2.close();
                            } catch (Exception e3) {
                                com.baidu.sofire.i.e.a();
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    cursor2 = query;
                    if (cursor2 != null) {
                    }
                    throw th;
                }
            } else {
                count = 0;
            }
            if (query != null) {
                try {
                    query.close();
                    return count;
                } catch (Exception e4) {
                    com.baidu.sofire.i.e.a();
                    return count;
                }
            }
            return count;
        } catch (Exception e5) {
            cursor = null;
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public final int c() {
        e eVar = new e(this.e);
        long currentTimeMillis = System.currentTimeMillis();
        try {
            return this.d.delete("r", "(d <= ? or (d < (" + currentTimeMillis + "-f*3600000) and f!= 0)) and b != '1001001'and i != 5 ", new String[]{String.valueOf(currentTimeMillis - (eVar.e.getInt("re_net_over", 7) * 86400000))});
        } catch (Exception e) {
            com.baidu.sofire.i.e.a();
            return -1;
        }
    }

    /* renamed from: com.baidu.sofire.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    class C0356a extends SQLiteOpenHelper {
        public C0356a(Context context) {
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
