package com.baidu.swan.pms.database.a;

import android.content.ContentValues;
import android.database.Cursor;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class e extends b<com.baidu.swan.pms.model.d> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.pms.database.a.b
    /* renamed from: k */
    public com.baidu.swan.pms.model.d i(Cursor cursor) {
        if (cursor != null && cursor.getCount() > 0 && cursor.moveToFirst()) {
            com.baidu.swan.pms.model.d dVar = new com.baidu.swan.pms.model.d();
            if (a(cursor, dVar)) {
                return dVar;
            }
        }
        return null;
    }

    @Override // com.baidu.swan.pms.database.a.b
    public List<com.baidu.swan.pms.model.d> g(Cursor cursor) {
        ArrayList arrayList = new ArrayList();
        if (cursor != null && cursor.getCount() > 0 && cursor.moveToFirst()) {
            do {
                com.baidu.swan.pms.model.d dVar = new com.baidu.swan.pms.model.d();
                if (a(cursor, dVar)) {
                    arrayList.add(dVar);
                }
            } while (cursor.moveToNext());
            return arrayList;
        }
        return arrayList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.pms.database.a.b
    /* renamed from: i */
    public ContentValues ab(com.baidu.swan.pms.model.d dVar) {
        return e(dVar);
    }
}
