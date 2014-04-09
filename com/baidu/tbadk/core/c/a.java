package com.baidu.tbadk.core.c;

import android.database.Cursor;
import android.graphics.Bitmap;
import com.baidu.adp.lib.util.f;
import com.baidu.tbadk.core.util.DatabaseManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.g;
import java.util.Date;
/* loaded from: classes.dex */
public final class a {
    public static Bitmap a(String str, long j) {
        return a("pb_photo", str);
    }

    public static Bitmap b(String str, long j) {
        return a("friend_photo", str);
    }

    public static Bitmap a(String str) {
        return a("user_icon", str);
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00b8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static Bitmap a(String str, String str2) {
        Cursor cursor;
        Throwable th;
        Bitmap bitmap = null;
        if (str2 != null) {
            try {
                cursor = new DatabaseManager(DatabaseManager.DatabaseLocation.SDCARD).a("select * from " + str + " where key = ?", new String[]{str2});
                if (cursor != null) {
                    try {
                        try {
                            if (cursor.moveToFirst()) {
                                bitmap = g.a(cursor.getBlob(1));
                            }
                        } catch (Exception e) {
                            e = e;
                            f.b("DatabaseManager", "getPhoto", "error = " + e.getMessage());
                            TiebaStatic.a(e, "DatabaseManager.getPhoto" + str, new Object[0]);
                            if (cursor != null) {
                                try {
                                    cursor.close();
                                } catch (Exception e2) {
                                    TiebaStatic.a(e2, "DatabaseManager.getPhoto" + str + "close cursor", new Object[0]);
                                }
                            }
                            return bitmap;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (cursor != null) {
                            try {
                                cursor.close();
                            } catch (Exception e3) {
                                TiebaStatic.a(e3, "DatabaseManager.getPhoto" + str + "close cursor", new Object[0]);
                            }
                        }
                        throw th;
                    }
                }
                if (cursor != null) {
                    try {
                        cursor.close();
                    } catch (Exception e4) {
                        TiebaStatic.a(e4, "DatabaseManager.getPhoto" + str + "close cursor", new Object[0]);
                    }
                }
            } catch (Exception e5) {
                e = e5;
                cursor = null;
            } catch (Throwable th3) {
                cursor = null;
                th = th3;
                if (cursor != null) {
                }
                throw th;
            }
        }
        return bitmap;
    }

    public static void a(String str, Bitmap bitmap) {
        a("pb_photo", 500, str, bitmap);
    }

    public static void b(String str, Bitmap bitmap) {
        a("user_icon", 100, str, bitmap);
    }

    public static void c(String str, Bitmap bitmap) {
        a("friend_photo", 500, str, bitmap);
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x0159 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void a(String str, int i, String str2, Bitmap bitmap) {
        Cursor cursor;
        int i2;
        Cursor a;
        if (str2 != null) {
            DatabaseManager databaseManager = new DatabaseManager(DatabaseManager.DatabaseLocation.SDCARD);
            try {
                Cursor a2 = databaseManager.a("select count(*) from " + str, (String[]) null);
                if (a2 != null) {
                    try {
                        try {
                            i2 = a2.moveToFirst() ? a2.getInt(0) : 0;
                            a2.close();
                        } catch (Exception e) {
                            e = e;
                            f.b("DatabaseManager", "cashPhoto", "error = " + e.getMessage());
                            TiebaStatic.a(e, "DatabaseManager.cashPhoto" + str, new Object[0]);
                            if (cursor != null) {
                                try {
                                    cursor.close();
                                    return;
                                } catch (Exception e2) {
                                    TiebaStatic.a(e2, "DatabaseManager.cashPhoto" + str + "close cursor", new Object[0]);
                                    return;
                                }
                            }
                            return;
                        }
                    } catch (Throwable th) {
                        th = th;
                        if (cursor != null) {
                            try {
                                cursor.close();
                            } catch (Exception e3) {
                                TiebaStatic.a(e3, "DatabaseManager.cashPhoto" + str + "close cursor", new Object[0]);
                            }
                        }
                        throw th;
                    }
                } else {
                    i2 = 0;
                }
                if (i2 >= i && (a = databaseManager.a("select * from " + str + " order by date asc limit 1", (String[]) null)) != null) {
                    a.moveToFirst();
                    databaseManager.a("delete from " + str + " where key=?", (Object[]) new String[]{a.getString(0)});
                    a.close();
                }
                Cursor a3 = databaseManager.a("select * from " + str + " where key = ?", new String[]{str2});
                if (a3 != null) {
                    if (a3.moveToFirst()) {
                        databaseManager.a("delete from " + str + " where key=?", (Object[]) new String[]{str2});
                    }
                    a3.close();
                }
                databaseManager.a("Insert into " + str + "(key,image,date,stamp) values(?,?,?,?)", new Object[]{str2, g.c(bitmap, 80), Long.valueOf(new Date().getTime()), 0});
            } catch (Exception e4) {
                e = e4;
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
                cursor = null;
                if (cursor != null) {
                }
                throw th;
            }
        }
    }
}
