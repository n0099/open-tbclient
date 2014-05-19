package com.baidu.tbadk.core.a;

import android.database.Cursor;
import android.graphics.Bitmap;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.DatabaseManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.g;
import java.util.Date;
/* loaded from: classes.dex */
public class a {
    public static Bitmap a(String str, long j) {
        return a("pb_photo", str, j);
    }

    public static Bitmap b(String str, long j) {
        return a("friend_photo", str, j);
    }

    public static Bitmap a(String str) {
        return a("user_icon", str, 0L);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:32:0x00e6 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.baidu.tbadk.core.util.DatabaseManager$DatabaseLocation] */
    /* JADX WARN: Type inference failed for: r2v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r2v6 */
    private static Bitmap a(String str, String str2, long j) {
        Cursor cursor;
        Bitmap bitmap = null;
        if (str2 != null) {
            ?? r2 = DatabaseManager.DatabaseLocation.SDCARD;
            DatabaseManager databaseManager = new DatabaseManager(r2);
            try {
                if (databaseManager != null) {
                    try {
                        cursor = databaseManager.a("select * from " + str + " where key = ?", new String[]{str2});
                        if (cursor != null) {
                            try {
                                if (cursor.moveToFirst()) {
                                    bitmap = g.a(cursor.getBlob(1));
                                }
                            } catch (Exception e) {
                                e = e;
                                BdLog.e("DatabaseManager", "getPhoto", "error = " + e.getMessage());
                                TiebaStatic.printDBExceptionLog(e, "DatabaseManager.getPhoto" + str, new Object[0]);
                                if (cursor != null) {
                                    try {
                                        cursor.close();
                                    } catch (Exception e2) {
                                        TiebaStatic.printDBExceptionLog(e2, "DatabaseManager.getPhoto" + str + "close cursor", new Object[0]);
                                    }
                                }
                                return bitmap;
                            }
                        }
                    } catch (Exception e3) {
                        e = e3;
                        cursor = null;
                    } catch (Throwable th) {
                        r2 = 0;
                        th = th;
                        if (r2 != 0) {
                            try {
                                r2.close();
                            } catch (Exception e4) {
                                TiebaStatic.printDBExceptionLog(e4, "DatabaseManager.getPhoto" + str + "close cursor", new Object[0]);
                            }
                        }
                        throw th;
                    }
                } else {
                    cursor = null;
                }
                if (cursor != null) {
                    try {
                        cursor.close();
                    } catch (Exception e5) {
                        TiebaStatic.printDBExceptionLog(e5, "DatabaseManager.getPhoto" + str + "close cursor", new Object[0]);
                    }
                }
            } catch (Throwable th2) {
                th = th2;
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

    private static void a(String str, int i, String str2, Bitmap bitmap) {
        int i2;
        Cursor cursor;
        Cursor a;
        Cursor cursor2 = null;
        if (str2 != null) {
            DatabaseManager databaseManager = new DatabaseManager(DatabaseManager.DatabaseLocation.SDCARD);
            try {
                if (databaseManager != null) {
                    try {
                        Cursor a2 = databaseManager.a("select count(*) from " + str, (String[]) null);
                        if (a2 != null) {
                            try {
                                i2 = a2.moveToFirst() ? a2.getInt(0) : 0;
                                a2.close();
                            } catch (Exception e) {
                                e = e;
                                BdLog.e("DatabaseManager", "cashPhoto", "error = " + e.getMessage());
                                TiebaStatic.printDBExceptionLog(e, "DatabaseManager.cashPhoto" + str, new Object[0]);
                                if (0 != 0) {
                                    try {
                                        cursor2.close();
                                        return;
                                    } catch (Exception e2) {
                                        TiebaStatic.printDBExceptionLog(e2, "DatabaseManager.cashPhoto" + str + "close cursor", new Object[0]);
                                        return;
                                    }
                                }
                                return;
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
                        cursor = null;
                    } catch (Exception e3) {
                        e = e3;
                    } catch (Throwable th) {
                        th = th;
                        if (0 != 0) {
                            try {
                                cursor2.close();
                            } catch (Exception e4) {
                                TiebaStatic.printDBExceptionLog(e4, "DatabaseManager.cashPhoto" + str + "close cursor", new Object[0]);
                            }
                        }
                        throw th;
                    }
                } else {
                    cursor = null;
                }
                if (0 != 0) {
                    try {
                        cursor.close();
                    } catch (Exception e5) {
                        TiebaStatic.printDBExceptionLog(e5, "DatabaseManager.cashPhoto" + str + "close cursor", new Object[0]);
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }
}
