package com.baidu.tbadk.core.util;

import android.database.Cursor;
import com.baidu.tbadk.TiebaDatabase;
import com.baidu.tbadk.core.TbadkCoreApplication;
import d.b.b.a.k.b;
import d.b.b.e.m.a;
import d.b.h0.s.c.o;
import java.util.Date;
/* loaded from: classes3.dex */
public class ChunkUploadDatabaseService {
    public static void delChunkUploadData(String str) {
        if (TbadkCoreApplication.getCurrentAccount() == null) {
            return;
        }
        b mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
        if (str == null || mainDBDatabaseManager == null) {
            return;
        }
        mainDBDatabaseManager.e("delete from chunk_upload_data where md5=? and account=?", new String[]{str, TbadkCoreApplication.getCurrentAccount()});
    }

    public static void delOverdueChunkUploadData() {
        b mainDBDatabaseManager;
        if (TbadkCoreApplication.getCurrentAccount() == null || (mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager()) == null) {
            return;
        }
        mainDBDatabaseManager.e("delete from chunk_upload_data where strftime('%s','now') - time > 48 * 3600 and account=?", new String[]{TbadkCoreApplication.getCurrentAccount()});
    }

    public static o getChunkUploadDataByMd5(String str) {
        o oVar;
        Cursor cursor = null;
        o oVar2 = null;
        cursor = null;
        if (TbadkCoreApplication.getCurrentAccount() == null) {
            return null;
        }
        b mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
        try {
            try {
                Cursor j = mainDBDatabaseManager.j("select * from chunk_upload_data where md5=? and account=? and strftime('%s','now') - time < 48 * 3600", new String[]{str, TbadkCoreApplication.getCurrentAccount()});
                try {
                    try {
                        if (j.moveToFirst()) {
                            oVar = new o();
                            try {
                                oVar.e(str);
                                oVar.d(j.getInt(3));
                                oVar.f(j.getLong(2));
                                oVar2 = oVar;
                            } catch (Exception e2) {
                                e = e2;
                                cursor = j;
                                mainDBDatabaseManager.i(e, "getChunkUploadDataByMd5");
                                a.a(cursor);
                                return oVar;
                            }
                        }
                        a.a(j);
                        return oVar2;
                    } catch (Exception e3) {
                        e = e3;
                        oVar = null;
                    }
                } catch (Throwable th) {
                    th = th;
                    cursor = j;
                    a.a(cursor);
                    throw th;
                }
            } catch (Exception e4) {
                e = e4;
                oVar = null;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static boolean saveChunkUploadData(o oVar) {
        if (TbadkCoreApplication.getCurrentAccount() == null) {
            return false;
        }
        b mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
        Date date = new Date();
        if (oVar == null || mainDBDatabaseManager == null) {
            return false;
        }
        mainDBDatabaseManager.e("delete from chunk_upload_data where md5=? and account=?", new String[]{oVar.b(), TbadkCoreApplication.getCurrentAccount()});
        return mainDBDatabaseManager.e("Insert into chunk_upload_data(md5,total_length,chunk_no,account,time) values(?,?,?,?,?)", new Object[]{oVar.b(), Long.valueOf(oVar.c()), Integer.valueOf(oVar.a()), TbadkCoreApplication.getCurrentAccount(), Long.valueOf(date.getTime() / 1000)});
    }
}
