package com.baidu.tbadk.core;

import android.database.sqlite.SQLiteDatabase;
import com.baidu.adp.base.a.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements a.InterfaceC0001a {
    @Override // com.baidu.adp.base.a.a.InterfaceC0001a
    public void b(SQLiteDatabase sQLiteDatabase) {
        TbadkCoreApplication.resetTDatabaseCreateTime();
    }
}
