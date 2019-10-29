package com.baidu.adp.base;

import android.database.sqlite.SQLiteDatabase;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.MessageConfig;
/* loaded from: classes.dex */
public class BdDatabaseNewCreatedMessage extends CustomResponsedMessage<SQLiteDatabase> {
    public BdDatabaseNewCreatedMessage(SQLiteDatabase sQLiteDatabase) {
        super(MessageConfig.DATABASE_CREATED, sQLiteDatabase);
    }

    public String getDatabaseFile() {
        SQLiteDatabase data = getData();
        if (data == null) {
            return null;
        }
        return data.getPath();
    }
}
