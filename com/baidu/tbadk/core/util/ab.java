package com.baidu.tbadk.core.util;

import android.database.Cursor;
import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ab {
    public static ArrayList<String> a() {
        Cursor cursor;
        Exception e;
        ArrayList<String> arrayList;
        Cursor cursor2;
        DatabaseManager databaseManager = new DatabaseManager();
        if (databaseManager != null) {
            try {
                cursor = databaseManager.a("select * from frs_image_forums", (String[]) null);
                if (cursor != null) {
                    try {
                        try {
                            arrayList = new ArrayList<>();
                            while (cursor.moveToNext()) {
                                try {
                                    arrayList.add(cursor.getString(0));
                                } catch (Exception e2) {
                                    e = e2;
                                    BdLog.e(e.getMessage());
                                    TiebaStatic.printDBExceptionLog(e, "DatabaseManager.getAllFrsImageForums", new Object[0]);
                                    if (cursor != null) {
                                        try {
                                            cursor.close();
                                        } catch (Exception e3) {
                                            TiebaStatic.printDBExceptionLog(e3, "DatabaseManager.getAllFrsImageForums close cursor", new Object[0]);
                                            e3.printStackTrace();
                                        }
                                    }
                                    return arrayList;
                                }
                            }
                            cursor.close();
                        } catch (Exception e4) {
                            arrayList = null;
                            e = e4;
                        }
                    } catch (Throwable th) {
                        th = th;
                        if (cursor != null) {
                            try {
                                cursor.close();
                            } catch (Exception e5) {
                                TiebaStatic.printDBExceptionLog(e5, "DatabaseManager.getAllFrsImageForums close cursor", new Object[0]);
                                e5.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } else {
                    arrayList = null;
                }
                cursor2 = null;
            } catch (Exception e6) {
                cursor = null;
                e = e6;
                arrayList = null;
            } catch (Throwable th2) {
                th = th2;
                cursor = null;
            }
        } else {
            arrayList = null;
            cursor2 = null;
        }
        if (0 != 0) {
            try {
                cursor2.close();
            } catch (Exception e7) {
                TiebaStatic.printDBExceptionLog(e7, "DatabaseManager.getAllFrsImageForums close cursor", new Object[0]);
                e7.printStackTrace();
            }
        }
        return arrayList;
    }

    public static void a(String str) {
        DatabaseManager databaseManager = new DatabaseManager();
        if (databaseManager != null && str != null) {
            try {
                databaseManager.a("delete from frs_image_forums where forum_name=?", (Object[]) new String[]{str});
                databaseManager.a("Insert into frs_image_forums(forum_name) values(?)", new Object[]{str});
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                TiebaStatic.printDBExceptionLog(e, "DatabaseManager.insertFrsImageForum", new Object[0]);
            }
        }
    }

    public static void b(String str) {
        DatabaseManager databaseManager = new DatabaseManager();
        if (databaseManager != null && str != null) {
            try {
                databaseManager.a("delete from frs_image_forums where forum_name=?", (Object[]) new String[]{str});
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                TiebaStatic.printDBExceptionLog(e, "DatabaseManager.delFrsImageForum", new Object[0]);
            }
        }
    }
}
