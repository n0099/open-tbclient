package com.baidu.tbadk.core.util;

import android.database.Cursor;
import com.baidu.tbadk.TiebaDatabase;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.Date;
/* loaded from: classes.dex */
public class c {
    public static void aZW() {
        com.baidu.adp.base.a.b mainDBDatabaseManager;
        if (TbadkCoreApplication.getCurrentAccount() != null && (mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager()) != null) {
            mainDBDatabaseManager.execSQLNoException("delete from chunk_upload_data where strftime('%s','now') - time > 48 * 3600 and account=?", new String[]{TbadkCoreApplication.getCurrentAccount()});
        }
    }

    public static void xy(String str) {
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            com.baidu.adp.base.a.b mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
            if (str != null && mainDBDatabaseManager != null) {
                mainDBDatabaseManager.execSQLNoException("delete from chunk_upload_data where md5=? and account=?", new String[]{str, TbadkCoreApplication.getCurrentAccount()});
            }
        }
    }

    public static boolean a(com.baidu.tbadk.coreExtra.data.l lVar) {
        if (TbadkCoreApplication.getCurrentAccount() == null) {
            return false;
        }
        com.baidu.adp.base.a.b mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
        Date date = new Date();
        if (lVar == null || mainDBDatabaseManager == null) {
            return false;
        }
        mainDBDatabaseManager.execSQLNoException("delete from chunk_upload_data where md5=? and account=?", new String[]{lVar.getMd5(), TbadkCoreApplication.getCurrentAccount()});
        return mainDBDatabaseManager.execSQLNoException("Insert into chunk_upload_data(md5,total_length,chunk_no,account,time) values(?,?,?,?,?)", new Object[]{lVar.getMd5(), Long.valueOf(lVar.getTotalLength()), Integer.valueOf(lVar.getChunkNo()), TbadkCoreApplication.getCurrentAccount(), Long.valueOf(date.getTime() / 1000)});
    }

    public static com.baidu.tbadk.coreExtra.data.l xz(String str) {
        Cursor cursor;
        Exception e;
        com.baidu.tbadk.coreExtra.data.l lVar;
        if (TbadkCoreApplication.getCurrentAccount() == null) {
            return null;
        }
        com.baidu.adp.base.a.b mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
        try {
            cursor = mainDBDatabaseManager.rawQuery("select * from chunk_upload_data where md5=? and account=? and strftime('%s','now') - time < 48 * 3600", new String[]{str, TbadkCoreApplication.getCurrentAccount()});
            try {
                try {
                    if (cursor.moveToFirst()) {
                        lVar = new com.baidu.tbadk.coreExtra.data.l();
                        try {
                            lVar.setMd5(str);
                            lVar.setChunkNo(cursor.getInt(3));
                            lVar.setTotalLength(cursor.getLong(2));
                        } catch (Exception e2) {
                            e = e2;
                            mainDBDatabaseManager.notifySQLException(e, "getChunkUploadDataByMd5");
                            com.baidu.adp.lib.f.a.close(cursor);
                            return lVar;
                        }
                    } else {
                        lVar = null;
                    }
                    com.baidu.adp.lib.f.a.close(cursor);
                } catch (Exception e3) {
                    lVar = null;
                    e = e3;
                }
            } catch (Throwable th) {
                th = th;
                com.baidu.adp.lib.f.a.close(cursor);
                throw th;
            }
        } catch (Exception e4) {
            cursor = null;
            e = e4;
            lVar = null;
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
        }
        return lVar;
    }
}
