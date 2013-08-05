package com.baidu.android.systemmonitor.a.a;

import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
final class a extends com.baidu.android.systemmonitor.c.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ArrayList f642a;
    final /* synthetic */ int b;
    final /* synthetic */ n c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(n nVar, ArrayList arrayList, int i) {
        this.c = nVar;
        this.f642a = arrayList;
        this.b = i;
    }

    @Override // com.baidu.android.systemmonitor.c.a
    protected boolean a(SQLiteDatabase sQLiteDatabase) {
        if (this.f642a == null || this.f642a.size() == 0) {
            return false;
        }
        sQLiteDatabase.delete("server_config_table", "type=" + this.b, null);
        DatabaseUtils.InsertHelper insertHelper = new DatabaseUtils.InsertHelper(sQLiteDatabase, "server_config_table");
        int columnIndex = insertHelper.getColumnIndex("name");
        int columnIndex2 = insertHelper.getColumnIndex("value");
        int columnIndex3 = insertHelper.getColumnIndex("type");
        Iterator it = this.f642a.iterator();
        while (it.hasNext()) {
            l lVar = (l) it.next();
            insertHelper.prepareForReplace();
            insertHelper.bind(columnIndex, lVar.a());
            insertHelper.bind(columnIndex2, lVar.b());
            insertHelper.bind(columnIndex3, lVar.c());
            insertHelper.execute();
        }
        insertHelper.close();
        return true;
    }
}
