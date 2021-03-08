package com.baidu.swan.pms.database.a;

import android.content.ContentValues;
import android.database.Cursor;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class h extends b<com.baidu.swan.pms.model.h> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.pms.database.a.b
    /* renamed from: q */
    public com.baidu.swan.pms.model.h k(Cursor cursor) {
        if (cursor == null || cursor.getCount() <= 0 || !cursor.moveToFirst()) {
            return null;
        }
        return r(cursor);
    }

    @Override // com.baidu.swan.pms.database.a.b
    public List<com.baidu.swan.pms.model.h> i(Cursor cursor) {
        ArrayList arrayList = new ArrayList();
        if (cursor != null && cursor.getCount() > 0 && cursor.moveToFirst()) {
            do {
                arrayList.add(r(cursor));
            } while (cursor.moveToNext());
            return arrayList;
        }
        return arrayList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.pms.database.a.b
    /* renamed from: h */
    public ContentValues an(com.baidu.swan.pms.model.h hVar) {
        ContentValues e = super.e(hVar);
        e.put("max_age", Long.valueOf(hVar.maxAge));
        e.put("token", hVar.token);
        e.put("domains", hVar.domains);
        e.put("app_key", hVar.appKey);
        e.put("app_name", hVar.appName);
        return e;
    }

    private com.baidu.swan.pms.model.h r(Cursor cursor) {
        if (cursor != null) {
            int columnIndex = cursor.getColumnIndex("max_age");
            int columnIndex2 = cursor.getColumnIndex("token");
            int columnIndex3 = cursor.getColumnIndex("domains");
            int columnIndex4 = cursor.getColumnIndex("app_key");
            int columnIndex5 = cursor.getColumnIndex("app_name");
            com.baidu.swan.pms.model.h hVar = new com.baidu.swan.pms.model.h();
            if (a(cursor, hVar)) {
                hVar.maxAge = cursor.getLong(columnIndex);
                hVar.token = cursor.getString(columnIndex2);
                hVar.domains = cursor.getString(columnIndex3);
                hVar.appKey = cursor.getString(columnIndex4);
                hVar.appName = cursor.getString(columnIndex5);
                return hVar;
            }
        }
        return null;
    }
}
