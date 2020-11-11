package com.baidu.swan.pms.database.a;

import android.content.ContentValues;
import android.database.Cursor;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes15.dex */
public class g extends b<com.baidu.swan.pms.model.g> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.pms.database.a.b
    /* renamed from: n */
    public com.baidu.swan.pms.model.g j(Cursor cursor) {
        if (cursor == null || cursor.getCount() <= 0 || !cursor.moveToFirst()) {
            return null;
        }
        return o(cursor);
    }

    @Override // com.baidu.swan.pms.database.a.b
    public List<com.baidu.swan.pms.model.g> h(Cursor cursor) {
        ArrayList arrayList = new ArrayList();
        if (cursor != null && cursor.getCount() > 0 && cursor.moveToFirst()) {
            do {
                arrayList.add(o(cursor));
            } while (cursor.moveToNext());
            return arrayList;
        }
        return arrayList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.pms.database.a.b
    /* renamed from: l */
    public ContentValues aj(com.baidu.swan.pms.model.g gVar) {
        ContentValues e = super.e(gVar);
        e.put("independent", Integer.valueOf(gVar.ehL ? 1 : 0));
        e.put("sub_pkg_name", gVar.pkgName);
        e.put("app_id", gVar.appId);
        return e;
    }

    private com.baidu.swan.pms.model.g o(Cursor cursor) {
        if (cursor != null) {
            int columnIndex = cursor.getColumnIndex("independent");
            int columnIndex2 = cursor.getColumnIndex("sub_pkg_name");
            int columnIndex3 = cursor.getColumnIndex("app_id");
            com.baidu.swan.pms.model.g gVar = new com.baidu.swan.pms.model.g();
            if (a(cursor, gVar)) {
                gVar.ehL = cursor.getInt(columnIndex) == 1;
                gVar.pkgName = cursor.getString(columnIndex2);
                gVar.appId = cursor.getString(columnIndex3);
                return gVar;
            }
        }
        return null;
    }
}
