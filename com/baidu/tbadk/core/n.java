package com.baidu.tbadk.core;

import android.database.sqlite.SQLiteDatabase;
import com.baidu.adp.base.a.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements a.InterfaceC0002a {
    @Override // com.baidu.adp.base.a.a.InterfaceC0002a
    public void b(SQLiteDatabase sQLiteDatabase) {
        TbadkCoreApplication.resetTDatabaseCreateTime();
    }
}
