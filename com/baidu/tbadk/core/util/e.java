package com.baidu.tbadk.core.util;

import android.database.Cursor;
import com.baidu.tbadk.TiebaDatabase;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.Date;
/* loaded from: classes.dex */
public class e {
    public static void tz() {
        com.baidu.adp.base.a.b mainDBDatabaseManager;
        if (TbadkCoreApplication.getCurrentAccount() != null && (mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager()) != null) {
            mainDBDatabaseManager.a("delete from chunk_upload_data where strftime('%s','now') - time > 48 * 3600 and account=?", new String[]{TbadkCoreApplication.getCurrentAccount()});
        }
    }

    public static void cE(String str) {
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            com.baidu.adp.base.a.b mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
            if (str != null && mainDBDatabaseManager != null) {
                mainDBDatabaseManager.a("delete from chunk_upload_data where md5=? and account=?", new String[]{str, TbadkCoreApplication.getCurrentAccount()});
            }
        }
    }

    public static boolean a(com.baidu.tbadk.coreExtra.data.b bVar) {
        if (TbadkCoreApplication.getCurrentAccount() == null) {
            return false;
        }
        com.baidu.adp.base.a.b mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
        Date date = new Date();
        if (bVar == null || mainDBDatabaseManager == null) {
            return false;
        }
        mainDBDatabaseManager.a("delete from chunk_upload_data where md5=? and account=?", new String[]{bVar.wh(), TbadkCoreApplication.getCurrentAccount()});
        return mainDBDatabaseManager.a("Insert into chunk_upload_data(md5,total_length,chunk_no,account,time) values(?,?,?,?,?)", new Object[]{bVar.wh(), Long.valueOf(bVar.getTotalLength()), Integer.valueOf(bVar.wi()), TbadkCoreApplication.getCurrentAccount(), Long.valueOf(date.getTime() / 1000)});
    }

    public static com.baidu.tbadk.coreExtra.data.b cF(String str) {
        Cursor cursor;
        Exception e;
        com.baidu.tbadk.coreExtra.data.b bVar;
        if (TbadkCoreApplication.getCurrentAccount() == null) {
            return null;
        }
        com.baidu.adp.base.a.b mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
        try {
            cursor = mainDBDatabaseManager.rawQuery("select * from chunk_upload_data where md5=? and account=? and strftime('%s','now') - time < 48 * 3600", new String[]{str, TbadkCoreApplication.getCurrentAccount()});
            try {
                try {
                    if (cursor.moveToFirst()) {
                        bVar = new com.baidu.tbadk.coreExtra.data.b();
                        try {
                            bVar.dL(str);
                            bVar.cU(cursor.getInt(3));
                            bVar.y(cursor.getLong(2));
                        } catch (Exception e2) {
                            e = e2;
                            mainDBDatabaseManager.a(e, "getChunkUploadDataByMd5");
                            com.baidu.adp.lib.g.a.b(cursor);
                            return bVar;
                        }
                    } else {
                        bVar = null;
                    }
                    com.baidu.adp.lib.g.a.b(cursor);
                } catch (Exception e3) {
                    bVar = null;
                    e = e3;
                }
            } catch (Throwable th) {
                th = th;
                com.baidu.adp.lib.g.a.b(cursor);
                throw th;
            }
        } catch (Exception e4) {
            cursor = null;
            e = e4;
            bVar = null;
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
        }
        return bVar;
    }
}
