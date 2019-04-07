package com.baidu.swan.pms.database.a;

import android.content.ContentValues;
import android.database.Cursor;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class f extends b<com.baidu.swan.pms.model.g> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.pms.database.a.b
    /* renamed from: o */
    public com.baidu.swan.pms.model.g l(Cursor cursor) {
        if (cursor != null && cursor.getCount() > 0 && cursor.moveToFirst()) {
            com.baidu.swan.pms.model.g gVar = new com.baidu.swan.pms.model.g();
            if (a(cursor, gVar)) {
                return gVar;
            }
        }
        return null;
    }

    @Override // com.baidu.swan.pms.database.a.b
    public List<com.baidu.swan.pms.model.g> j(Cursor cursor) {
        ArrayList arrayList = new ArrayList();
        if (cursor != null && cursor.getCount() > 0 && cursor.moveToFirst()) {
            do {
                com.baidu.swan.pms.model.g gVar = new com.baidu.swan.pms.model.g();
                if (a(cursor, gVar)) {
                    arrayList.add(gVar);
                }
            } while (cursor.moveToNext());
            return arrayList;
        }
        return arrayList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.pms.database.a.b
    /* renamed from: f */
    public ContentValues U(com.baidu.swan.pms.model.g gVar) {
        ContentValues e = super.e(gVar);
        e.put("pkg_type", Integer.valueOf(gVar.bma));
        return e;
    }
}
