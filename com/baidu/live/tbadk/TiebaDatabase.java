package com.baidu.live.tbadk;

import com.baidu.live.adp.base.db.DatabaseManager;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.TiebaMainDatabaseHelper;
import com.baidu.live.tbadk.core.util.TiebaMainSdDatabaseHelper;
/* loaded from: classes6.dex */
public class TiebaDatabase {
    private static TiebaDatabase _instance = new TiebaDatabase();
    private DatabaseManager mainDB;
    private DatabaseManager mainSdDB;

    private TiebaDatabase() {
    }

    public static TiebaDatabase getInstance() {
        return _instance;
    }

    public DatabaseManager getMainDBDatabaseManager() {
        DatabaseManager databaseManager;
        if (this.mainDB != null) {
            return this.mainDB;
        }
        synchronized (_instance) {
            if (this.mainDB != null) {
                databaseManager = this.mainDB;
            } else {
                this.mainDB = new DatabaseManager(new TiebaMainDatabaseHelper(TbadkCoreApplication.getInst().getContext()));
                databaseManager = this.mainDB;
            }
        }
        return databaseManager;
    }

    public DatabaseManager getSdcardMainDBDatabaseManager() {
        DatabaseManager databaseManager;
        if (this.mainSdDB != null) {
            return this.mainSdDB;
        }
        synchronized (_instance) {
            if (this.mainSdDB != null) {
                databaseManager = this.mainSdDB;
            } else {
                this.mainSdDB = new DatabaseManager(new TiebaMainSdDatabaseHelper());
                databaseManager = this.mainSdDB;
            }
        }
        return databaseManager;
    }
}
