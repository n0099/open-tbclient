package com.baidu.swan.pms.database.a;

import android.content.ContentValues;
import android.database.Cursor;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class d extends b<com.baidu.swan.pms.model.c> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.pms.database.a.b
    /* renamed from: m */
    public com.baidu.swan.pms.model.c l(Cursor cursor) {
        if (cursor != null && cursor.getCount() > 0 && cursor.moveToFirst()) {
            com.baidu.swan.pms.model.c cVar = new com.baidu.swan.pms.model.c();
            if (a(cursor, cVar)) {
                return cVar;
            }
        }
        return null;
    }

    @Override // com.baidu.swan.pms.database.a.b
    public List<com.baidu.swan.pms.model.c> j(Cursor cursor) {
        ArrayList arrayList = new ArrayList();
        if (cursor != null && cursor.getCount() > 0 && cursor.moveToFirst()) {
            do {
                com.baidu.swan.pms.model.c cVar = new com.baidu.swan.pms.model.c();
                if (a(cursor, cVar)) {
                    arrayList.add(cVar);
                }
            } while (cursor.moveToNext());
            return arrayList;
        }
        return arrayList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.pms.database.a.b
    /* renamed from: f */
    public ContentValues U(com.baidu.swan.pms.model.c cVar) {
        return e(cVar);
    }
}
