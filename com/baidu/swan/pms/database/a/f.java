package com.baidu.swan.pms.database.a;

import android.content.ContentValues;
import android.database.Cursor;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes15.dex */
public class f extends b<com.baidu.swan.pms.model.f> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.pms.database.a.b
    /* renamed from: m */
    public com.baidu.swan.pms.model.f j(Cursor cursor) {
        if (cursor != null && cursor.getCount() > 0 && cursor.moveToFirst()) {
            com.baidu.swan.pms.model.f fVar = new com.baidu.swan.pms.model.f();
            if (a(cursor, fVar)) {
                return fVar;
            }
        }
        return null;
    }

    @Override // com.baidu.swan.pms.database.a.b
    public List<com.baidu.swan.pms.model.f> h(Cursor cursor) {
        ArrayList arrayList = new ArrayList();
        if (cursor != null && cursor.getCount() > 0 && cursor.moveToFirst()) {
            do {
                com.baidu.swan.pms.model.f fVar = new com.baidu.swan.pms.model.f();
                if (a(cursor, fVar)) {
                    arrayList.add(fVar);
                }
            } while (cursor.moveToNext());
            return arrayList;
        }
        return arrayList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.pms.database.a.b
    /* renamed from: g */
    public ContentValues aj(com.baidu.swan.pms.model.f fVar) {
        ContentValues e = super.e(fVar);
        e.put("pkg_type", Integer.valueOf(fVar.dTw));
        return e;
    }
}
