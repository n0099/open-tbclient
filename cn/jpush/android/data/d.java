package cn.jpush.android.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.tieba.model.ReportUserInfoModel;
/* loaded from: classes3.dex */
public final class d extends f {
    private static volatile d b;
    private static final String[] a = {"_id", "ln_id", "ln_count", "ln_remove", "ln_type", "ln_extra", "ln_trigger_time", "ln_add_time"};
    private static final Object c = new Object();

    private d(Context context) {
        super(context, "jpush_local_notification.db", null, 1);
    }

    public static d a(Context context) {
        if (b == null) {
            synchronized (c) {
                if (b == null) {
                    b = new d(context.getApplicationContext());
                }
            }
        }
        return b;
    }

    public static e a(Cursor cursor) {
        if (cursor == null || cursor.getCount() == 0) {
            return null;
        }
        try {
            e eVar = new e();
            eVar.a(cursor.getLong(1));
            eVar.a(cursor.getInt(2));
            eVar.b(cursor.getInt(3));
            eVar.c(cursor.getInt(4));
            eVar.a(cursor.getString(5));
            eVar.c(cursor.getLong(6));
            eVar.b(cursor.getLong(7));
            return eVar;
        } catch (Exception e) {
            e.getStackTrace();
            return null;
        }
    }

    public final int a(long j) {
        try {
            if (a(true)) {
                return getWritableDatabase().delete("t_localnotification", "ln_id=" + j, null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            b(true);
        }
        return 0;
    }

    public final long a(long j, int i, int i2, int i3, String str, long j2, long j3) {
        long j4 = 0;
        if (a(true)) {
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put("ln_id", Long.valueOf(j));
                contentValues.put("ln_count", (Integer) 1);
                contentValues.put("ln_remove", (Integer) 0);
                contentValues.put("ln_type", (Integer) 0);
                contentValues.put("ln_extra", str);
                contentValues.put("ln_trigger_time", Long.valueOf(j2));
                contentValues.put("ln_add_time", Long.valueOf(j3));
                j4 = getWritableDatabase().insert("t_localnotification", null, contentValues);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                b(true);
            }
        }
        return j4;
    }

    public final Cursor a(int i, long j) {
        try {
            return getReadableDatabase().query(true, "t_localnotification", a, "ln_count=1 and ln_trigger_time<" + j, null, null, null, null, null);
        } catch (Exception e) {
            return null;
        }
    }

    public final Cursor a(long j, long j2) {
        try {
            return getReadableDatabase().query(true, "t_localnotification", a, "ln_count>0 and ln_trigger_time<" + (ReportUserInfoModel.TIME_INTERVAL + j) + " and ln_trigger_time>" + j, null, null, null, null, null);
        } catch (Exception e) {
            return null;
        }
    }

    public final e a(long j, int i) {
        Cursor cursor;
        if (!a(false)) {
            throw new Exception("open database failed");
        }
        try {
            cursor = getReadableDatabase().query(true, "t_localnotification", a, "ln_id=" + j + " and ln_type=0", null, null, null, null, null);
            if (cursor != null) {
                try {
                    cursor.moveToFirst();
                } catch (Throwable th) {
                    th = th;
                    if (cursor != null) {
                        cursor.close();
                    }
                    b(false);
                    throw th;
                }
            }
            e a2 = a(cursor);
            if (cursor != null) {
                cursor.close();
            }
            b(false);
            return a2;
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x004f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:71:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:72:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int[] a() {
        Cursor cursor;
        boolean z;
        Exception e;
        boolean z2;
        int[] iArr;
        boolean z3;
        Cursor cursor2 = null;
        if (!a(false)) {
            return null;
        }
        try {
            cursor = getReadableDatabase().query(true, "t_localnotification", new String[]{"ln_id"}, "1", null, null, null, null, null);
            try {
                if (cursor != null) {
                    try {
                        try {
                            if (cursor.getCount() > 0) {
                                int[] iArr2 = new int[cursor.getCount()];
                                try {
                                    cursor.moveToFirst();
                                    int i = 0;
                                    do {
                                        iArr2[i] = cursor.getInt(0);
                                        i++;
                                    } while (cursor.moveToNext());
                                    iArr = iArr2;
                                    if (a(true)) {
                                        z3 = false;
                                    } else {
                                        try {
                                            getWritableDatabase().execSQL("delete from t_localnotification");
                                            z3 = true;
                                        } catch (Exception e2) {
                                            e = e2;
                                            cursor2 = cursor;
                                            z2 = true;
                                            try {
                                                e.printStackTrace();
                                                if (cursor2 != null) {
                                                }
                                                b(false);
                                                if (z2) {
                                                }
                                            } catch (Throwable th) {
                                                th = th;
                                                z = z2;
                                                cursor = cursor2;
                                                if (cursor != null) {
                                                    cursor.close();
                                                }
                                                b(false);
                                                if (z) {
                                                    b(true);
                                                }
                                                throw th;
                                            }
                                        } catch (Throwable th2) {
                                            th = th2;
                                            z = true;
                                            if (cursor != null) {
                                            }
                                            b(false);
                                            if (z) {
                                            }
                                            throw th;
                                        }
                                    }
                                    if (cursor != null) {
                                        cursor.close();
                                    }
                                    b(false);
                                    if (z3) {
                                        return iArr;
                                    }
                                    b(true);
                                    return iArr;
                                } catch (Exception e3) {
                                    e = e3;
                                    iArr = iArr2;
                                    cursor2 = cursor;
                                    z2 = false;
                                    e.printStackTrace();
                                    if (cursor2 != null) {
                                        cursor2.close();
                                    }
                                    b(false);
                                    if (z2) {
                                        return iArr;
                                    }
                                    b(true);
                                    return iArr;
                                }
                            }
                        } catch (Exception e4) {
                            e = e4;
                            iArr = null;
                            cursor2 = cursor;
                            z2 = false;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        z = false;
                        if (cursor != null) {
                        }
                        b(false);
                        if (z) {
                        }
                        throw th;
                    }
                }
                if (a(true)) {
                }
                if (cursor != null) {
                }
                b(false);
                if (z3) {
                }
            } catch (Exception e5) {
                e = e5;
                cursor2 = cursor;
                z2 = false;
            }
            iArr = null;
        } catch (Exception e6) {
            e = e6;
            z2 = false;
            iArr = null;
        } catch (Throwable th4) {
            th = th4;
            cursor = null;
            z = false;
        }
    }

    public final long b(long j, int i, int i2, int i3, String str, long j2, long j3) {
        long j4 = 0;
        try {
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            b(true);
        }
        if (a(true)) {
            String str2 = "ln_id=" + j;
            ContentValues contentValues = new ContentValues();
            contentValues.put("ln_id", Long.valueOf(j));
            contentValues.put("ln_count", Integer.valueOf(i));
            contentValues.put("ln_remove", Integer.valueOf(i2));
            contentValues.put("ln_type", (Integer) 0);
            contentValues.put("ln_extra", str);
            contentValues.put("ln_trigger_time", Long.valueOf(j2));
            contentValues.put("ln_add_time", Long.valueOf(j3));
            j4 = getWritableDatabase().update("t_localnotification", contentValues, str2, null);
        }
        return j4;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("CREATE TABLE t_localnotification (_id INTEGER PRIMARY KEY AUTOINCREMENT ,ln_id long not null,ln_count integer not null,ln_remove integer not null,ln_type integer not null,ln_extra text ,ln_trigger_time long ,ln_add_time long );");
        } catch (Exception e) {
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS t_localnotification");
        onCreate(sQLiteDatabase);
    }
}
