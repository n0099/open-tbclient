package com.alipay.sdk.tid;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.alipay.sdk.util.c;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public final class a extends SQLiteOpenHelper {

    /* renamed from: a  reason: collision with root package name */
    public static final String f1923a = "msp.db";

    /* renamed from: b  reason: collision with root package name */
    public static final int f1924b = 1;

    /* renamed from: c  reason: collision with root package name */
    public WeakReference<Context> f1925c;

    public a(Context context) {
        super(context, f1923a, (SQLiteDatabase.CursorFactory) null, 1);
        this.f1925c = new WeakReference<>(context);
    }

    private String c(String str, String str2) {
        return str + str2;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, IF, INVOKE] complete} */
    public void a() {
        SQLiteDatabase sQLiteDatabase = null;
        try {
            try {
                sQLiteDatabase = getWritableDatabase();
                sQLiteDatabase.execSQL("drop table if exists tb_tid");
                if (sQLiteDatabase == null || !sQLiteDatabase.isOpen()) {
                    return;
                }
            } catch (Exception e2) {
                c.a(e2);
                if (sQLiteDatabase == null || !sQLiteDatabase.isOpen()) {
                    return;
                }
            }
            sQLiteDatabase.close();
        } catch (Throwable th) {
            if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                sQLiteDatabase.close();
            }
            throw th;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x002a, code lost:
        if (r2.isOpen() != false) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x002c, code lost:
        r2.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0059, code lost:
        if (r2.isOpen() != false) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String b(String str, String str2) {
        SQLiteDatabase sQLiteDatabase;
        Cursor cursor;
        Cursor cursor2 = null;
        r1 = null;
        r1 = null;
        String str3 = null;
        cursor2 = null;
        try {
            sQLiteDatabase = getReadableDatabase();
            try {
                cursor = sQLiteDatabase.rawQuery("select key_tid from tb_tid where name=?", new String[]{c(str, str2)});
                try {
                    str3 = cursor.moveToFirst() ? cursor.getString(0) : null;
                    if (cursor != null) {
                        cursor.close();
                    }
                    if (sQLiteDatabase != null) {
                    }
                } catch (Exception unused) {
                    if (cursor != null) {
                        cursor.close();
                    }
                    if (sQLiteDatabase != null) {
                    }
                    return str3;
                } catch (Throwable th) {
                    th = th;
                    cursor2 = cursor;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                        sQLiteDatabase.close();
                    }
                    throw th;
                }
            } catch (Exception unused2) {
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception unused3) {
            cursor = null;
            sQLiteDatabase = null;
        } catch (Throwable th3) {
            th = th3;
            sQLiteDatabase = null;
        }
        return str3;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("create table if not exists tb_tid (name text primary key, tid text, key_tid text, dt datetime);");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        sQLiteDatabase.execSQL("drop table if exists tb_tid");
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x002a, code lost:
        if (r2.isOpen() != false) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x002c, code lost:
        r2.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0059, code lost:
        if (r2.isOpen() != false) goto L17;
     */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:47:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String a(String str, String str2) {
        SQLiteDatabase sQLiteDatabase;
        Cursor cursor;
        Cursor cursor2 = null;
        r1 = null;
        r1 = null;
        String str3 = null;
        cursor2 = null;
        try {
            sQLiteDatabase = getReadableDatabase();
            try {
                cursor = sQLiteDatabase.rawQuery("select tid from tb_tid where name=?", new String[]{c(str, str2)});
                try {
                    str3 = cursor.moveToFirst() ? cursor.getString(0) : null;
                    if (cursor != null) {
                        cursor.close();
                    }
                    if (sQLiteDatabase != null) {
                    }
                } catch (Exception unused) {
                    if (cursor != null) {
                        cursor.close();
                    }
                    if (sQLiteDatabase != null) {
                    }
                    if (TextUtils.isEmpty(str3)) {
                    }
                } catch (Throwable th) {
                    th = th;
                    cursor2 = cursor;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                        sQLiteDatabase.close();
                    }
                    throw th;
                }
            } catch (Exception unused2) {
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception unused3) {
            cursor = null;
            sQLiteDatabase = null;
        } catch (Throwable th3) {
            th = th3;
            sQLiteDatabase = null;
        }
        return TextUtils.isEmpty(str3) ? com.alipay.sdk.encrypt.b.b(str3, com.alipay.sdk.util.a.c(this.f1925c.get())) : str3;
    }
}
