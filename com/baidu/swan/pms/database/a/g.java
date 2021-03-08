package com.baidu.swan.pms.database.a;

import android.content.ContentValues;
import android.database.Cursor;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class g extends b<com.baidu.swan.pms.model.g> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.pms.database.a.b
    /* renamed from: o */
    public com.baidu.swan.pms.model.g k(Cursor cursor) {
        if (cursor == null || cursor.getCount() <= 0 || !cursor.moveToFirst()) {
            return null;
        }
        return p(cursor);
    }

    @Override // com.baidu.swan.pms.database.a.b
    public List<com.baidu.swan.pms.model.g> i(Cursor cursor) {
        ArrayList arrayList = new ArrayList();
        if (cursor != null && cursor.getCount() > 0 && cursor.moveToFirst()) {
            do {
                arrayList.add(p(cursor));
            } while (cursor.moveToNext());
            return arrayList;
        }
        return arrayList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.pms.database.a.b
    /* renamed from: l */
    public ContentValues an(com.baidu.swan.pms.model.g gVar) {
        ContentValues e = super.e(gVar);
        e.put("independent", Integer.valueOf(gVar.evI ? 1 : 0));
        e.put("sub_pkg_name", gVar.pkgName);
        e.put("app_id", gVar.appId);
        return e;
    }

    private com.baidu.swan.pms.model.g p(Cursor cursor) {
        if (cursor != null) {
            int columnIndex = cursor.getColumnIndex("independent");
            int columnIndex2 = cursor.getColumnIndex("sub_pkg_name");
            int columnIndex3 = cursor.getColumnIndex("app_id");
            com.baidu.swan.pms.model.g gVar = new com.baidu.swan.pms.model.g();
            if (a(cursor, gVar)) {
                gVar.evI = cursor.getInt(columnIndex) == 1;
                gVar.pkgName = cursor.getString(columnIndex2);
                gVar.appId = cursor.getString(columnIndex3);
                return gVar;
            }
        }
        return null;
    }
}
