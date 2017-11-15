package com.baidu.tbadk.core.util;

import android.database.Cursor;
import com.baidu.tbadk.TiebaDatabase;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.Date;
/* loaded from: classes.dex */
public class c {
    public static void ue() {
        com.baidu.adp.base.a.b mainDBDatabaseManager;
        if (TbadkCoreApplication.getCurrentAccount() != null && (mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager()) != null) {
            mainDBDatabaseManager.a("delete from chunk_upload_data where strftime('%s','now') - time > 48 * 3600 and account=?", new String[]{TbadkCoreApplication.getCurrentAccount()});
        }
    }

    public static void de(String str) {
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            com.baidu.adp.base.a.b mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
            if (str != null && mainDBDatabaseManager != null) {
                mainDBDatabaseManager.a("delete from chunk_upload_data where md5=? and account=?", new String[]{str, TbadkCoreApplication.getCurrentAccount()});
            }
        }
    }

    public static boolean a(com.baidu.tbadk.coreExtra.data.h hVar) {
        if (TbadkCoreApplication.getCurrentAccount() == null) {
            return false;
        }
        com.baidu.adp.base.a.b mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
        Date date = new Date();
        if (hVar == null || mainDBDatabaseManager == null) {
            return false;
        }
        mainDBDatabaseManager.a("delete from chunk_upload_data where md5=? and account=?", new String[]{hVar.xT(), TbadkCoreApplication.getCurrentAccount()});
        return mainDBDatabaseManager.a("Insert into chunk_upload_data(md5,total_length,chunk_no,account,time) values(?,?,?,?,?)", new Object[]{hVar.xT(), Long.valueOf(hVar.getTotalLength()), Integer.valueOf(hVar.xU()), TbadkCoreApplication.getCurrentAccount(), Long.valueOf(date.getTime() / 1000)});
    }

    public static com.baidu.tbadk.coreExtra.data.h df(String str) {
        Cursor cursor;
        Exception e;
        com.baidu.tbadk.coreExtra.data.h hVar;
        if (TbadkCoreApplication.getCurrentAccount() == null) {
            return null;
        }
        com.baidu.adp.base.a.b mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
        try {
            cursor = mainDBDatabaseManager.rawQuery("select * from chunk_upload_data where md5=? and account=? and strftime('%s','now') - time < 48 * 3600", new String[]{str, TbadkCoreApplication.getCurrentAccount()});
            try {
                try {
                    if (cursor.moveToFirst()) {
                        hVar = new com.baidu.tbadk.coreExtra.data.h();
                        try {
                            hVar.eB(str);
                            hVar.dR(cursor.getInt(3));
                            hVar.N(cursor.getLong(2));
                        } catch (Exception e2) {
                            e = e2;
                            mainDBDatabaseManager.a(e, "getChunkUploadDataByMd5");
                            com.baidu.adp.lib.g.a.e(cursor);
                            return hVar;
                        }
                    } else {
                        hVar = null;
                    }
                    com.baidu.adp.lib.g.a.e(cursor);
                } catch (Exception e3) {
                    hVar = null;
                    e = e3;
                }
            } catch (Throwable th) {
                th = th;
                com.baidu.adp.lib.g.a.e(cursor);
                throw th;
            }
        } catch (Exception e4) {
            cursor = null;
            e = e4;
            hVar = null;
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
        }
        return hVar;
    }
}
