package com.baidu.tbadk.core.util;

import android.database.Cursor;
import com.baidu.tbadk.TbadkApplication;
import java.util.Date;
/* loaded from: classes.dex */
public final class k {
    public static void a(String str) {
        if (TbadkApplication.E() != null) {
            DatabaseManager databaseManager = new DatabaseManager();
            if (str != null) {
                try {
                    databaseManager.a("delete from chunk_upload_data where md5=? and account=?", (Object[]) new String[]{str, TbadkApplication.E()});
                } catch (Exception e) {
                    com.baidu.adp.lib.util.f.b("DatabaseManager", "delChunkUploadData", "error = " + e.getMessage());
                    TiebaStatic.a(e, "DatabaseManager.delChunkUploadData", new Object[0]);
                }
            }
        }
    }

    public static boolean a(com.baidu.tbadk.coreExtra.data.b bVar) {
        if (TbadkApplication.E() == null) {
            return false;
        }
        DatabaseManager databaseManager = new DatabaseManager();
        Date date = new Date();
        if (bVar != null) {
            try {
                databaseManager.a("delete from chunk_upload_data where md5=? and account=?", (Object[]) new String[]{bVar.a(), TbadkApplication.E()});
                return databaseManager.a("Insert into chunk_upload_data(md5,total_length,chunk_no,account,time) values(?,?,?,?,?)", new Object[]{bVar.a(), Long.valueOf(bVar.b()), Integer.valueOf(bVar.c()), TbadkApplication.E(), Long.valueOf(date.getTime() / 1000)}).booleanValue();
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b("DatabaseManager", "saveChunkUploadData", "error = " + e.getMessage());
                TiebaStatic.a(e, "DatabaseManager.saveChunkUploadData", new Object[0]);
                return false;
            }
        }
        return false;
    }

    public static com.baidu.tbadk.coreExtra.data.b b(String str) {
        Cursor cursor;
        Throwable th;
        com.baidu.tbadk.coreExtra.data.b bVar = null;
        if (TbadkApplication.E() != null) {
            try {
                cursor = new DatabaseManager().a("select * from chunk_upload_data where md5=? and account=? and strftime('%s','now') - time < 48 * 3600", new String[]{str, TbadkApplication.E()});
                if (cursor != null) {
                    try {
                        try {
                            if (cursor.moveToFirst()) {
                                com.baidu.tbadk.coreExtra.data.b bVar2 = new com.baidu.tbadk.coreExtra.data.b();
                                try {
                                    bVar2.a(str);
                                    bVar2.a(cursor.getInt(3));
                                    bVar2.a(cursor.getLong(2));
                                    bVar = bVar2;
                                } catch (Exception e) {
                                    bVar = bVar2;
                                    e = e;
                                    com.baidu.adp.lib.util.f.b("DatabaseManager", "getChunkUploadDataByMd5", "error = " + e.getMessage());
                                    TiebaStatic.a(e, "DatabaseManager.getChunkUploadDataByMd5", new Object[0]);
                                    if (cursor != null) {
                                        try {
                                            cursor.close();
                                        } catch (Exception e2) {
                                            TiebaStatic.a(e2, "DatabaseManager.getChunkUploadDataByMd5 close cursor", new Object[0]);
                                        }
                                    }
                                    return bVar;
                                }
                            }
                            cursor.close();
                        } catch (Throwable th2) {
                            th = th2;
                            if (cursor != null) {
                                try {
                                    cursor.close();
                                } catch (Exception e3) {
                                    TiebaStatic.a(e3, "DatabaseManager.getChunkUploadDataByMd5 close cursor", new Object[0]);
                                }
                            }
                            throw th;
                        }
                    } catch (Exception e4) {
                        e = e4;
                    }
                }
            } catch (Exception e5) {
                e = e5;
                cursor = null;
            } catch (Throwable th3) {
                cursor = null;
                th = th3;
            }
        }
        return bVar;
    }
}
