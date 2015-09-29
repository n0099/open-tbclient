package com.baidu.tbadk;

import com.baidu.adp.base.a.b;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.av;
/* loaded from: classes.dex */
public class TiebaDatabase {
    private static TiebaDatabase _instance = new TiebaDatabase();
    private b mainDB;
    private b mainSdDB;

    private TiebaDatabase() {
    }

    public static TiebaDatabase getInstance() {
        return _instance;
    }

    public b getMainDBDatabaseManager() {
        b bVar;
        if (this.mainDB != null) {
            return this.mainDB;
        }
        synchronized (_instance) {
            if (this.mainDB != null) {
                bVar = this.mainDB;
            } else {
                this.mainDB = new b(new au(TbadkCoreApplication.m411getInst().getContext()));
                bVar = this.mainDB;
            }
        }
        return bVar;
    }

    public b getSdcardMainDBDatabaseManager() {
        b bVar;
        if (this.mainSdDB != null) {
            return this.mainSdDB;
        }
        synchronized (_instance) {
            if (this.mainSdDB != null) {
                bVar = this.mainSdDB;
            } else {
                this.mainSdDB = new b(new av());
                bVar = this.mainSdDB;
            }
        }
        return bVar;
    }
}
