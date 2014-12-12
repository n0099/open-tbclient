package com.baidu.tbadk.core;

import android.database.sqlite.SQLiteDatabase;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements com.baidu.adp.base.a.b {
    @Override // com.baidu.adp.base.a.b
    public void c(SQLiteDatabase sQLiteDatabase) {
        TbadkCoreApplication.resetTDatabaseCreateTime();
    }
}
