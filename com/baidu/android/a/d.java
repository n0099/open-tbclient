package com.baidu.android.a;

import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.cloudsdk.social.core.SocialConstants;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
class d extends com.baidu.android.systemmonitor.b.a {
    final /* synthetic */ ArrayList a;
    final /* synthetic */ int b;
    final /* synthetic */ o c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(o oVar, ArrayList arrayList, int i) {
        this.c = oVar;
        this.a = arrayList;
        this.b = i;
    }

    @Override // com.baidu.android.systemmonitor.b.a
    protected boolean a(SQLiteDatabase sQLiteDatabase) {
        if (this.a == null || this.a.size() == 0) {
            return false;
        }
        sQLiteDatabase.delete("server_config_table", "type=" + this.b, null);
        DatabaseUtils.InsertHelper insertHelper = new DatabaseUtils.InsertHelper(sQLiteDatabase, "server_config_table");
        int columnIndex = insertHelper.getColumnIndex(SocialConstants.PARAM_MEDIA_UNAME);
        int columnIndex2 = insertHelper.getColumnIndex("value");
        int columnIndex3 = insertHelper.getColumnIndex("type");
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            k kVar = (k) it.next();
            insertHelper.prepareForReplace();
            insertHelper.bind(columnIndex, kVar.a());
            insertHelper.bind(columnIndex2, kVar.b());
            insertHelper.bind(columnIndex3, kVar.c());
            insertHelper.execute();
        }
        insertHelper.close();
        return true;
    }
}
