package com.baidu.tbadk;

import com.baidu.adp.base.a.c;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.core.util.be;
/* loaded from: classes.dex */
public class TiebaDatabase {
    private static TiebaDatabase _instance = new TiebaDatabase();
    private c mainDB;
    private c mainSdDB;

    private TiebaDatabase() {
    }

    public static TiebaDatabase getInstance() {
        return _instance;
    }

    public c getMainDBDatabaseManager() {
        c cVar;
        if (this.mainDB != null) {
            return this.mainDB;
        }
        synchronized (_instance) {
            if (this.mainDB != null) {
                cVar = this.mainDB;
            } else {
                this.mainDB = new c(new bd(TbadkCoreApplication.m255getInst().getContext()));
                cVar = this.mainDB;
            }
        }
        return cVar;
    }

    public c getSdcardMainDBDatabaseManager() {
        c cVar;
        if (this.mainSdDB != null) {
            return this.mainSdDB;
        }
        synchronized (_instance) {
            if (this.mainSdDB != null) {
                cVar = this.mainSdDB;
            } else {
                this.mainSdDB = new c(new be());
                cVar = this.mainSdDB;
            }
        }
        return cVar;
    }
}
