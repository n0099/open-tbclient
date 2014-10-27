package com.baidu.tbadk.core.util;

import android.database.Cursor;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.TiebaDatabase;
import java.util.Date;
/* loaded from: classes.dex */
public class i {
    public static void ls() {
        com.baidu.adp.base.a.c mainDBDatabaseManager;
        if (TbadkApplication.getCurrentAccount() != null && (mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager()) != null) {
            mainDBDatabaseManager.a("delete from chunk_upload_data where strftime('%s','now') - time > 48 * 3600 and account=?", new String[]{TbadkApplication.getCurrentAccount()});
        }
    }

    public static void bm(String str) {
        if (TbadkApplication.getCurrentAccount() != null) {
            com.baidu.adp.base.a.c mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
            if (str != null && mainDBDatabaseManager != null) {
                mainDBDatabaseManager.a("delete from chunk_upload_data where md5=? and account=?", new String[]{str, TbadkApplication.getCurrentAccount()});
            }
        }
    }

    public static boolean a(com.baidu.tbadk.coreExtra.data.b bVar) {
        if (TbadkApplication.getCurrentAccount() == null) {
            return false;
        }
        com.baidu.adp.base.a.c mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
        Date date = new Date();
        if (bVar == null || mainDBDatabaseManager == null) {
            return false;
        }
        mainDBDatabaseManager.a("delete from chunk_upload_data where md5=? and account=?", new String[]{bVar.ou(), TbadkApplication.getCurrentAccount()});
        return mainDBDatabaseManager.a("Insert into chunk_upload_data(md5,total_length,chunk_no,account,time) values(?,?,?,?,?)", new Object[]{bVar.ou(), Long.valueOf(bVar.ov()), Integer.valueOf(bVar.ow()), TbadkApplication.getCurrentAccount(), Long.valueOf(date.getTime() / 1000)});
    }

    public static com.baidu.tbadk.coreExtra.data.b bn(String str) {
        Cursor cursor;
        Exception e;
        com.baidu.tbadk.coreExtra.data.b bVar;
        if (TbadkApplication.getCurrentAccount() == null) {
            return null;
        }
        com.baidu.adp.base.a.c mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
        try {
            cursor = mainDBDatabaseManager.rawQuery("select * from chunk_upload_data where md5=? and account=? and strftime('%s','now') - time < 48 * 3600", new String[]{str, TbadkApplication.getCurrentAccount()});
            try {
                try {
                    if (cursor.moveToFirst()) {
                        bVar = new com.baidu.tbadk.coreExtra.data.b();
                        try {
                            bVar.cn(str);
                            bVar.bV(cursor.getInt(3));
                            bVar.l(cursor.getLong(2));
                        } catch (Exception e2) {
                            e = e2;
                            mainDBDatabaseManager.a(e, "getChunkUploadDataByMd5");
                            com.baidu.adp.lib.g.a.a(cursor);
                            return bVar;
                        }
                    } else {
                        bVar = null;
                    }
                    com.baidu.adp.lib.g.a.a(cursor);
                } catch (Exception e3) {
                    bVar = null;
                    e = e3;
                }
            } catch (Throwable th) {
                th = th;
                com.baidu.adp.lib.g.a.a(cursor);
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
