package com.baidu.tbadk.core.util;

import android.database.Cursor;
import com.baidu.tbadk.TiebaDatabase;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.Date;
/* loaded from: classes.dex */
public class c {
    public static void yl() {
        com.baidu.adp.base.a.b mainDBDatabaseManager;
        if (TbadkCoreApplication.getCurrentAccount() != null && (mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager()) != null) {
            mainDBDatabaseManager.f("delete from chunk_upload_data where strftime('%s','now') - time > 48 * 3600 and account=?", new String[]{TbadkCoreApplication.getCurrentAccount()});
        }
    }

    public static void dR(String str) {
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            com.baidu.adp.base.a.b mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
            if (str != null && mainDBDatabaseManager != null) {
                mainDBDatabaseManager.f("delete from chunk_upload_data where md5=? and account=?", new String[]{str, TbadkCoreApplication.getCurrentAccount()});
            }
        }
    }

    public static boolean a(com.baidu.tbadk.coreExtra.data.i iVar) {
        if (TbadkCoreApplication.getCurrentAccount() == null) {
            return false;
        }
        com.baidu.adp.base.a.b mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
        Date date = new Date();
        if (iVar == null || mainDBDatabaseManager == null) {
            return false;
        }
        mainDBDatabaseManager.f("delete from chunk_upload_data where md5=? and account=?", new String[]{iVar.Cn(), TbadkCoreApplication.getCurrentAccount()});
        return mainDBDatabaseManager.f("Insert into chunk_upload_data(md5,total_length,chunk_no,account,time) values(?,?,?,?,?)", new Object[]{iVar.Cn(), Long.valueOf(iVar.getTotalLength()), Integer.valueOf(iVar.Co()), TbadkCoreApplication.getCurrentAccount(), Long.valueOf(date.getTime() / 1000)});
    }

    public static com.baidu.tbadk.coreExtra.data.i dS(String str) {
        Cursor cursor;
        Exception e;
        com.baidu.tbadk.coreExtra.data.i iVar;
        if (TbadkCoreApplication.getCurrentAccount() == null) {
            return null;
        }
        com.baidu.adp.base.a.b mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
        try {
            cursor = mainDBDatabaseManager.rawQuery("select * from chunk_upload_data where md5=? and account=? and strftime('%s','now') - time < 48 * 3600", new String[]{str, TbadkCoreApplication.getCurrentAccount()});
            try {
                try {
                    if (cursor.moveToFirst()) {
                        iVar = new com.baidu.tbadk.coreExtra.data.i();
                        try {
                            iVar.fA(str);
                            iVar.dR(cursor.getInt(3));
                            iVar.U(cursor.getLong(2));
                        } catch (Exception e2) {
                            e = e2;
                            mainDBDatabaseManager.a(e, "getChunkUploadDataByMd5");
                            com.baidu.adp.lib.g.a.e(cursor);
                            return iVar;
                        }
                    } else {
                        iVar = null;
                    }
                    com.baidu.adp.lib.g.a.e(cursor);
                } catch (Exception e3) {
                    iVar = null;
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
            iVar = null;
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
        }
        return iVar;
    }
}
