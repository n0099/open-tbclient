package com.baidu.tbadk.core.util;

import android.database.Cursor;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.TiebaDatabase;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements Runnable {
    @Override // java.lang.Runnable
    public void run() {
        Cursor cursor;
        Throwable th;
        int i;
        com.baidu.adp.base.a.b mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
        try {
            cursor = mainDBDatabaseManager.ch().rawQuery("SELECT * FROM user_emotions where uid = ? order by updateTime desc ", new String[]{TbadkCoreApplication.getCurrentAccount()});
            i = 0;
            while (cursor.moveToNext()) {
                try {
                    i++;
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        mainDBDatabaseManager.a(th, "EmotionsDBManager.listMyEmotions");
                        com.baidu.adp.lib.util.o.e(cursor);
                        au auVar = new au("c12232");
                        auVar.Z(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount());
                        auVar.r("obj_param1", i);
                        TiebaStatic.log(auVar);
                    } catch (Throwable th3) {
                        com.baidu.adp.lib.util.o.e(cursor);
                        throw th3;
                    }
                }
            }
            com.baidu.adp.lib.util.o.e(cursor);
        } catch (Throwable th4) {
            cursor = null;
            th = th4;
            i = 0;
        }
        au auVar2 = new au("c12232");
        auVar2.Z(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount());
        auVar2.r("obj_param1", i);
        TiebaStatic.log(auVar2);
    }
}
