package com.baidu.tbadk.core.util;

import android.database.Cursor;
import com.baidu.tbadk.TbadkApplication;
import java.util.Date;
/* loaded from: classes.dex */
public class i {
    public static void a() {
        com.baidu.adp.base.a.c b;
        if (TbadkApplication.getCurrentAccount() != null && (b = com.baidu.tbadk.j.a().b()) != null) {
            b.a("delete from chunk_upload_data where strftime('%s','now') - time > 48 * 3600 and account=?", (Object[]) new String[]{TbadkApplication.getCurrentAccount()});
        }
    }

    public static void a(String str) {
        if (TbadkApplication.getCurrentAccount() != null) {
            com.baidu.adp.base.a.c b = com.baidu.tbadk.j.a().b();
            if (str != null && b != null) {
                b.a("delete from chunk_upload_data where md5=? and account=?", (Object[]) new String[]{str, TbadkApplication.getCurrentAccount()});
            }
        }
    }

    public static boolean a(com.baidu.tbadk.coreExtra.data.b bVar) {
        if (TbadkApplication.getCurrentAccount() == null) {
            return false;
        }
        com.baidu.adp.base.a.c b = com.baidu.tbadk.j.a().b();
        Date date = new Date();
        if (bVar == null || b == null) {
            return false;
        }
        b.a("delete from chunk_upload_data where md5=? and account=?", (Object[]) new String[]{bVar.a(), TbadkApplication.getCurrentAccount()});
        return b.a("Insert into chunk_upload_data(md5,total_length,chunk_no,account,time) values(?,?,?,?,?)", new Object[]{bVar.a(), Long.valueOf(bVar.b()), Integer.valueOf(bVar.c()), TbadkApplication.getCurrentAccount(), Long.valueOf(date.getTime() / 1000)});
    }

    public static com.baidu.tbadk.coreExtra.data.b b(String str) {
        Cursor cursor;
        Exception e;
        com.baidu.tbadk.coreExtra.data.b bVar;
        if (TbadkApplication.getCurrentAccount() == null) {
            return null;
        }
        com.baidu.adp.base.a.c b = com.baidu.tbadk.j.a().b();
        try {
            cursor = b.a("select * from chunk_upload_data where md5=? and account=? and strftime('%s','now') - time < 48 * 3600", new String[]{str, TbadkApplication.getCurrentAccount()});
            try {
                try {
                    if (cursor.moveToFirst()) {
                        bVar = new com.baidu.tbadk.coreExtra.data.b();
                        try {
                            bVar.a(str);
                            bVar.a(cursor.getInt(3));
                            bVar.a(cursor.getLong(2));
                        } catch (Exception e2) {
                            e = e2;
                            b.a(e, "getChunkUploadDataByMd5");
                            com.baidu.adp.lib.e.a.a(cursor);
                            return bVar;
                        }
                    } else {
                        bVar = null;
                    }
                    com.baidu.adp.lib.e.a.a(cursor);
                } catch (Exception e3) {
                    bVar = null;
                    e = e3;
                }
            } catch (Throwable th) {
                th = th;
                com.baidu.adp.lib.e.a.a(cursor);
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
