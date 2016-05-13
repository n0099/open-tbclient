package com.baidu.tbadk.core.util;

import android.database.Cursor;
import com.baidu.tbadk.TiebaDatabase;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.Date;
/* loaded from: classes.dex */
public class d {
    public static void sW() {
        com.baidu.adp.base.a.b mainDBDatabaseManager;
        if (TbadkCoreApplication.getCurrentAccount() != null && (mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager()) != null) {
            mainDBDatabaseManager.b("delete from chunk_upload_data where strftime('%s','now') - time > 48 * 3600 and account=?", new String[]{TbadkCoreApplication.getCurrentAccount()});
        }
    }

    public static void cN(String str) {
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            com.baidu.adp.base.a.b mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
            if (str != null && mainDBDatabaseManager != null) {
                mainDBDatabaseManager.b("delete from chunk_upload_data where md5=? and account=?", new String[]{str, TbadkCoreApplication.getCurrentAccount()});
            }
        }
    }

    public static boolean a(com.baidu.tbadk.coreExtra.data.c cVar) {
        if (TbadkCoreApplication.getCurrentAccount() == null) {
            return false;
        }
        com.baidu.adp.base.a.b mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
        Date date = new Date();
        if (cVar == null || mainDBDatabaseManager == null) {
            return false;
        }
        mainDBDatabaseManager.b("delete from chunk_upload_data where md5=? and account=?", new String[]{cVar.getMd5(), TbadkCoreApplication.getCurrentAccount()});
        return mainDBDatabaseManager.b("Insert into chunk_upload_data(md5,total_length,chunk_no,account,time) values(?,?,?,?,?)", new Object[]{cVar.getMd5(), Long.valueOf(cVar.getTotalLength()), Integer.valueOf(cVar.wt()), TbadkCoreApplication.getCurrentAccount(), Long.valueOf(date.getTime() / 1000)});
    }

    public static com.baidu.tbadk.coreExtra.data.c cO(String str) {
        Cursor cursor;
        Exception e;
        com.baidu.tbadk.coreExtra.data.c cVar;
        if (TbadkCoreApplication.getCurrentAccount() == null) {
            return null;
        }
        com.baidu.adp.base.a.b mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
        try {
            cursor = mainDBDatabaseManager.rawQuery("select * from chunk_upload_data where md5=? and account=? and strftime('%s','now') - time < 48 * 3600", new String[]{str, TbadkCoreApplication.getCurrentAccount()});
            try {
                try {
                    if (cursor.moveToFirst()) {
                        cVar = new com.baidu.tbadk.coreExtra.data.c();
                        try {
                            cVar.setMd5(str);
                            cVar.di(cursor.getInt(3));
                            cVar.M(cursor.getLong(2));
                        } catch (Exception e2) {
                            e = e2;
                            mainDBDatabaseManager.d(e, "getChunkUploadDataByMd5");
                            com.baidu.adp.lib.h.a.a(cursor);
                            return cVar;
                        }
                    } else {
                        cVar = null;
                    }
                    com.baidu.adp.lib.h.a.a(cursor);
                } catch (Exception e3) {
                    cVar = null;
                    e = e3;
                }
            } catch (Throwable th) {
                th = th;
                com.baidu.adp.lib.h.a.a(cursor);
                throw th;
            }
        } catch (Exception e4) {
            cursor = null;
            e = e4;
            cVar = null;
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
        }
        return cVar;
    }
}
