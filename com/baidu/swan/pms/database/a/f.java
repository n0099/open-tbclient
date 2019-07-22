package com.baidu.swan.pms.database.a;

import android.content.ContentValues;
import android.database.Cursor;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class f extends b<com.baidu.swan.pms.model.f> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.pms.database.a.b
    /* renamed from: o */
    public com.baidu.swan.pms.model.f l(Cursor cursor) {
        if (cursor != null && cursor.getCount() > 0 && cursor.moveToFirst()) {
            com.baidu.swan.pms.model.f fVar = new com.baidu.swan.pms.model.f();
            if (a(cursor, fVar)) {
                return fVar;
            }
        }
        return null;
    }

    @Override // com.baidu.swan.pms.database.a.b
    public List<com.baidu.swan.pms.model.f> j(Cursor cursor) {
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
    /* renamed from: f */
    public ContentValues U(com.baidu.swan.pms.model.f fVar) {
        ContentValues g = super.g(fVar);
        g.put("pkg_type", Integer.valueOf(fVar.bsS));
        return g;
    }
}
