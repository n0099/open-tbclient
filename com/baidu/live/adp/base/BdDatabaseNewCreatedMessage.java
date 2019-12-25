package com.baidu.live.adp.base;

import android.database.sqlite.SQLiteDatabase;
import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes2.dex */
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
