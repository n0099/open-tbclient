package com.baidu.tbadk.core.util;

import android.database.Cursor;
import com.baidu.tbadk.TiebaDatabase;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.Date;
/* loaded from: classes.dex */
public class c {
    public static void alT() {
        com.baidu.adp.base.a.b mainDBDatabaseManager;
        if (TbadkCoreApplication.getCurrentAccount() != null && (mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager()) != null) {
            mainDBDatabaseManager.execSQLNoException("delete from chunk_upload_data where strftime('%s','now') - time > 48 * 3600 and account=?", new String[]{TbadkCoreApplication.getCurrentAccount()});
        }
    }

    public static void nC(String str) {
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            com.baidu.adp.base.a.b mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
            if (str != null && mainDBDatabaseManager != null) {
                mainDBDatabaseManager.execSQLNoException("delete from chunk_upload_data where md5=? and account=?", new String[]{str, TbadkCoreApplication.getCurrentAccount()});
            }
        }
    }

    public static boolean a(com.baidu.tbadk.coreExtra.data.k kVar) {
        if (TbadkCoreApplication.getCurrentAccount() == null) {
            return false;
        }
        com.baidu.adp.base.a.b mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
        Date date = new Date();
        if (kVar == null || mainDBDatabaseManager == null) {
            return false;
        }
        mainDBDatabaseManager.execSQLNoException("delete from chunk_upload_data where md5=? and account=?", new String[]{kVar.getMd5(), TbadkCoreApplication.getCurrentAccount()});
        return mainDBDatabaseManager.execSQLNoException("Insert into chunk_upload_data(md5,total_length,chunk_no,account,time) values(?,?,?,?,?)", new Object[]{kVar.getMd5(), Long.valueOf(kVar.getTotalLength()), Integer.valueOf(kVar.getChunkNo()), TbadkCoreApplication.getCurrentAccount(), Long.valueOf(date.getTime() / 1000)});
    }

    public static com.baidu.tbadk.coreExtra.data.k nD(String str) {
        Cursor cursor;
        Exception e;
        com.baidu.tbadk.coreExtra.data.k kVar;
        if (TbadkCoreApplication.getCurrentAccount() == null) {
            return null;
        }
        com.baidu.adp.base.a.b mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
        try {
            cursor = mainDBDatabaseManager.rawQuery("select * from chunk_upload_data where md5=? and account=? and strftime('%s','now') - time < 48 * 3600", new String[]{str, TbadkCoreApplication.getCurrentAccount()});
            try {
                try {
                    if (cursor.moveToFirst()) {
                        kVar = new com.baidu.tbadk.coreExtra.data.k();
                        try {
                            kVar.setMd5(str);
                            kVar.setChunkNo(cursor.getInt(3));
                            kVar.setTotalLength(cursor.getLong(2));
                        } catch (Exception e2) {
                            e = e2;
                            mainDBDatabaseManager.notifySQLException(e, "getChunkUploadDataByMd5");
                            com.baidu.adp.lib.g.a.close(cursor);
                            return kVar;
                        }
                    } else {
                        kVar = null;
                    }
                    com.baidu.adp.lib.g.a.close(cursor);
                } catch (Exception e3) {
                    kVar = null;
                    e = e3;
                }
            } catch (Throwable th) {
                th = th;
                com.baidu.adp.lib.g.a.close(cursor);
                throw th;
            }
        } catch (Exception e4) {
            cursor = null;
            e = e4;
            kVar = null;
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
        }
        return kVar;
    }
}
