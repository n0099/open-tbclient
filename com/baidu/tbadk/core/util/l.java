package com.baidu.tbadk.core.util;

import android.database.Cursor;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbadkApplication;
import java.util.Date;
/* loaded from: classes.dex */
public class l {
    public static void a() {
        DatabaseManager databaseManager;
        if (TbadkApplication.getCurrentAccount() != null && (databaseManager = new DatabaseManager()) != null) {
            try {
                databaseManager.a("delete from chunk_upload_data where strftime('%s','now') - time > 48 * 3600 and account=?", (Object[]) new String[]{TbadkApplication.getCurrentAccount()});
            } catch (Exception e) {
                BdLog.e("DatabaseManager", "delChunkUploadData", "error = " + e.getMessage());
                TiebaStatic.printDBExceptionLog(e, "DatabaseManager.delOverdueChunkUploadData", new Object[0]);
            }
        }
    }

    public static void a(String str) {
        if (TbadkApplication.getCurrentAccount() != null) {
            DatabaseManager databaseManager = new DatabaseManager();
            if (str != null && databaseManager != null) {
                try {
                    databaseManager.a("delete from chunk_upload_data where md5=? and account=?", (Object[]) new String[]{str, TbadkApplication.getCurrentAccount()});
                } catch (Exception e) {
                    BdLog.e("DatabaseManager", "delChunkUploadData", "error = " + e.getMessage());
                    TiebaStatic.printDBExceptionLog(e, "DatabaseManager.delChunkUploadData", new Object[0]);
                }
            }
        }
    }

    public static boolean a(com.baidu.tbadk.coreExtra.data.b bVar) {
        if (TbadkApplication.getCurrentAccount() == null) {
            return false;
        }
        DatabaseManager databaseManager = new DatabaseManager();
        Date date = new Date();
        if (bVar == null || databaseManager == null) {
            return false;
        }
        try {
            databaseManager.a("delete from chunk_upload_data where md5=? and account=?", (Object[]) new String[]{bVar.a(), TbadkApplication.getCurrentAccount()});
            return databaseManager.a("Insert into chunk_upload_data(md5,total_length,chunk_no,account,time) values(?,?,?,?,?)", new Object[]{bVar.a(), Long.valueOf(bVar.b()), Integer.valueOf(bVar.c()), TbadkApplication.getCurrentAccount(), Long.valueOf(date.getTime() / 1000)}).booleanValue();
        } catch (Exception e) {
            BdLog.e("DatabaseManager", "saveChunkUploadData", "error = " + e.getMessage());
            TiebaStatic.printDBExceptionLog(e, "DatabaseManager.saveChunkUploadData", new Object[0]);
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x008f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x007d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static com.baidu.tbadk.coreExtra.data.b b(String str) {
        Cursor cursor;
        Exception e;
        com.baidu.tbadk.coreExtra.data.b bVar;
        Cursor cursor2;
        if (TbadkApplication.getCurrentAccount() == null) {
            return null;
        }
        DatabaseManager databaseManager = new DatabaseManager();
        if (databaseManager != null) {
            try {
                Cursor a = databaseManager.a("select * from chunk_upload_data where md5=? and account=? and strftime('%s','now') - time < 48 * 3600", new String[]{str, TbadkApplication.getCurrentAccount()});
                if (a != null) {
                    try {
                        try {
                            if (a.moveToFirst()) {
                                com.baidu.tbadk.coreExtra.data.b bVar2 = new com.baidu.tbadk.coreExtra.data.b();
                                try {
                                    bVar2.a(str);
                                    bVar2.a(a.getInt(3));
                                    bVar2.a(a.getLong(2));
                                    bVar = bVar2;
                                } catch (Exception e2) {
                                    e = e2;
                                    bVar = bVar2;
                                    cursor = a;
                                    try {
                                        BdLog.e("DatabaseManager", "getChunkUploadDataByMd5", "error = " + e.getMessage());
                                        TiebaStatic.printDBExceptionLog(e, "DatabaseManager.getChunkUploadDataByMd5", new Object[0]);
                                        if (cursor != null) {
                                        }
                                        return bVar;
                                    } catch (Throwable th) {
                                        th = th;
                                        if (cursor != null) {
                                        }
                                        throw th;
                                    }
                                }
                            } else {
                                bVar = null;
                            }
                        } catch (Exception e3) {
                            cursor = a;
                            e = e3;
                            bVar = null;
                        }
                        try {
                            a.close();
                        } catch (Exception e4) {
                            e = e4;
                            cursor = a;
                            BdLog.e("DatabaseManager", "getChunkUploadDataByMd5", "error = " + e.getMessage());
                            TiebaStatic.printDBExceptionLog(e, "DatabaseManager.getChunkUploadDataByMd5", new Object[0]);
                            if (cursor != null) {
                                try {
                                    cursor.close();
                                } catch (Exception e5) {
                                    TiebaStatic.printDBExceptionLog(e5, "DatabaseManager.getChunkUploadDataByMd5 close cursor", new Object[0]);
                                }
                            }
                            return bVar;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        cursor = a;
                        if (cursor != null) {
                            try {
                                cursor.close();
                            } catch (Exception e6) {
                                TiebaStatic.printDBExceptionLog(e6, "DatabaseManager.getChunkUploadDataByMd5 close cursor", new Object[0]);
                            }
                        }
                        throw th;
                    }
                } else {
                    bVar = null;
                }
                cursor2 = null;
            } catch (Exception e7) {
                cursor = null;
                e = e7;
                bVar = null;
            } catch (Throwable th3) {
                th = th3;
                cursor = null;
            }
        } else {
            bVar = null;
            cursor2 = null;
        }
        if (0 != 0) {
            try {
                cursor2.close();
            } catch (Exception e8) {
                TiebaStatic.printDBExceptionLog(e8, "DatabaseManager.getChunkUploadDataByMd5 close cursor", new Object[0]);
            }
        }
        return bVar;
    }
}
