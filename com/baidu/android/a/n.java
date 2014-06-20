package com.baidu.android.a;

import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n extends com.baidu.android.systemmonitor.b.d {
    final /* synthetic */ ArrayList a;
    final /* synthetic */ int b;
    final /* synthetic */ h c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(h hVar, ArrayList arrayList, int i) {
        this.c = hVar;
        this.a = arrayList;
        this.b = i;
    }

    @Override // com.baidu.android.systemmonitor.b.d
    protected boolean a(SQLiteDatabase sQLiteDatabase) {
        if (this.a == null || this.a.size() == 0) {
            return false;
        }
        sQLiteDatabase.delete("server_config_table", "type=" + this.b, null);
        DatabaseUtils.InsertHelper insertHelper = new DatabaseUtils.InsertHelper(sQLiteDatabase, "server_config_table");
        int columnIndex = insertHelper.getColumnIndex("name");
        int columnIndex2 = insertHelper.getColumnIndex("value");
        int columnIndex3 = insertHelper.getColumnIndex("type");
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            e eVar = (e) it.next();
            insertHelper.prepareForReplace();
            insertHelper.bind(columnIndex, eVar.a());
            insertHelper.bind(columnIndex2, eVar.b());
            insertHelper.bind(columnIndex3, eVar.c());
            insertHelper.execute();
        }
        insertHelper.close();
        return true;
    }
}
