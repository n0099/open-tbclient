package com.baidu.android.systemmonitor.d.a;

import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
class j extends com.baidu.android.systemmonitor.a.d {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ArrayList f670a;
    final /* synthetic */ int b;
    final /* synthetic */ i c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar, ArrayList arrayList, int i) {
        this.c = iVar;
        this.f670a = arrayList;
        this.b = i;
    }

    @Override // com.baidu.android.systemmonitor.a.d
    protected boolean a(SQLiteDatabase sQLiteDatabase) {
        if (this.f670a == null || this.f670a.size() == 0) {
            return false;
        }
        sQLiteDatabase.delete("server_config_table", "type=" + this.b, null);
        DatabaseUtils.InsertHelper insertHelper = new DatabaseUtils.InsertHelper(sQLiteDatabase, "server_config_table");
        int columnIndex = insertHelper.getColumnIndex("name");
        int columnIndex2 = insertHelper.getColumnIndex("value");
        int columnIndex3 = insertHelper.getColumnIndex("type");
        Iterator it = this.f670a.iterator();
        while (it.hasNext()) {
            b bVar = (b) it.next();
            insertHelper.prepareForReplace();
            insertHelper.bind(columnIndex, bVar.a());
            insertHelper.bind(columnIndex2, bVar.b());
            insertHelper.bind(columnIndex3, bVar.c());
            insertHelper.execute();
        }
        insertHelper.close();
        return true;
    }
}
