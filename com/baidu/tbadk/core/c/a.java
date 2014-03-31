package com.baidu.tbadk.core.c;

import android.database.Cursor;
import android.graphics.Bitmap;
import com.baidu.adp.lib.util.f;
import com.baidu.tbadk.core.util.DatabaseManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.g;
import com.baidu.tbadk.core.util.resourceLoader.d;
import java.util.Date;
/* loaded from: classes.dex */
public final class a {
    public static d a(String str, long j) {
        return a("pb_photo", str, j);
    }

    public static d b(String str, long j) {
        return a("friend_photo", str, j);
    }

    public static d a(String str) {
        return a("user_icon", str, 0L);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [84=5, 85=5, 87=5, 88=5] */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:55:0x0144 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0124 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.baidu.tbadk.core.util.DatabaseManager$DatabaseLocation] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v3, types: [android.database.Cursor] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static d a(String str, String str2, long j) {
        Throwable th;
        Cursor cursor;
        d dVar = null;
        if (str2 != null) {
            ?? r2 = DatabaseManager.DatabaseLocation.SDCARD;
            try {
                try {
                    cursor = new DatabaseManager(r2).a("select * from " + str + " where key = ?", new String[]{str2});
                    if (cursor != null) {
                        try {
                            if (cursor.moveToFirst()) {
                                long j2 = cursor.getLong(3);
                                if (j2 != 0 || j == 0) {
                                    if (j2 == 0 || j == 0 || j <= j2) {
                                        d dVar2 = new d();
                                        try {
                                            dVar2.a = g.a(cursor.getBlob(1));
                                            dVar2.b = j2;
                                            dVar = dVar2;
                                        } catch (Exception e) {
                                            dVar = dVar2;
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
                                            return dVar;
                                        }
                                    } else if (cursor != null) {
                                        try {
                                            cursor.close();
                                        } catch (Exception e3) {
                                            TiebaStatic.a(e3, "DatabaseManager.getPhoto" + str + "close cursor", new Object[0]);
                                        }
                                    }
                                } else if (cursor != null) {
                                    try {
                                        cursor.close();
                                    } catch (Exception e4) {
                                        TiebaStatic.a(e4, "DatabaseManager.getPhoto" + str + "close cursor", new Object[0]);
                                    }
                                }
                            }
                        } catch (Exception e5) {
                            e = e5;
                        }
                    }
                    if (cursor != null) {
                        try {
                            cursor.close();
                        } catch (Exception e6) {
                            TiebaStatic.a(e6, "DatabaseManager.getPhoto" + str + "close cursor", new Object[0]);
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (r2 != 0) {
                        try {
                            r2.close();
                        } catch (Exception e7) {
                            TiebaStatic.a(e7, "DatabaseManager.getPhoto" + str + "close cursor", new Object[0]);
                        }
                    }
                    throw th;
                }
            } catch (Exception e8) {
                e = e8;
                cursor = null;
            } catch (Throwable th3) {
                r2 = 0;
                th = th3;
                if (r2 != 0) {
                }
                throw th;
            }
        }
        return dVar;
    }

    public static void a(String str, Bitmap bitmap, long j) {
        a("pb_photo", 500, str, bitmap, j);
    }

    public static void a(String str, Bitmap bitmap) {
        a("user_icon", 100, str, bitmap, 0L);
    }

    public static void b(String str, Bitmap bitmap, long j) {
        a("friend_photo", 500, str, bitmap, j);
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x0158 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void a(String str, int i, String str2, Bitmap bitmap, long j) {
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
                databaseManager.a("Insert into " + str + "(key,image,date,stamp) values(?,?,?,?)", new Object[]{str2, g.c(bitmap, 80), Long.valueOf(new Date().getTime()), Long.valueOf(j)});
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
