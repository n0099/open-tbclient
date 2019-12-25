package com.baidu.swan.pms.database.a;

import android.content.ContentValues;
import android.database.Cursor;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class d extends b<com.baidu.swan.pms.model.b> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.pms.database.a.b
    /* renamed from: j */
    public com.baidu.swan.pms.model.b i(Cursor cursor) {
        if (cursor != null && cursor.getCount() > 0 && cursor.moveToFirst()) {
            com.baidu.swan.pms.model.b bVar = new com.baidu.swan.pms.model.b();
            if (a(cursor, bVar)) {
                return bVar;
            }
        }
        return null;
    }

    @Override // com.baidu.swan.pms.database.a.b
    public List<com.baidu.swan.pms.model.b> g(Cursor cursor) {
        ArrayList arrayList = new ArrayList();
        if (cursor != null && cursor.getCount() > 0 && cursor.moveToFirst()) {
            do {
                com.baidu.swan.pms.model.b bVar = new com.baidu.swan.pms.model.b();
                if (a(cursor, bVar)) {
                    arrayList.add(bVar);
                }
            } while (cursor.moveToNext());
            return arrayList;
        }
        return arrayList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.pms.database.a.b
    /* renamed from: j */
    public ContentValues X(com.baidu.swan.pms.model.b bVar) {
        return e(bVar);
    }
}
