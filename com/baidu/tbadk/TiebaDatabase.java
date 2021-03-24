package com.baidu.tbadk;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaMainDatabaseHelper;
import com.baidu.tbadk.core.util.TiebaMainSdDatabaseHelper;
import d.b.b.a.k.b;
/* loaded from: classes.dex */
public class TiebaDatabase {
    public static TiebaDatabase _instance = new TiebaDatabase();
    public b mainDB;
    public b mainSdDB;

    public static TiebaDatabase getInstance() {
        return _instance;
    }

    public b getMainDBDatabaseManager() {
        b bVar = this.mainDB;
        if (bVar != null) {
            return bVar;
        }
        synchronized (_instance) {
            if (this.mainDB != null) {
                return this.mainDB;
            }
            b bVar2 = new b(new TiebaMainDatabaseHelper(TbadkCoreApplication.getInst().getContext()));
            this.mainDB = bVar2;
            return bVar2;
        }
    }

    public b getSdcardMainDBDatabaseManager() {
        b bVar = this.mainSdDB;
        if (bVar != null) {
            return bVar;
        }
        synchronized (_instance) {
            if (this.mainSdDB != null) {
                return this.mainSdDB;
            }
            b bVar2 = new b(new TiebaMainSdDatabaseHelper());
            this.mainSdDB = bVar2;
            return bVar2;
        }
    }
}
