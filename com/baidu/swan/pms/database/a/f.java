package com.baidu.swan.pms.database.a;

import android.content.ContentValues;
import android.database.Cursor;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class f extends b<com.baidu.swan.pms.model.f> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.pms.database.a.b
    /* renamed from: n */
    public com.baidu.swan.pms.model.f k(Cursor cursor) {
        if (cursor != null && cursor.getCount() > 0 && cursor.moveToFirst()) {
            com.baidu.swan.pms.model.f fVar = new com.baidu.swan.pms.model.f();
            if (a(cursor, fVar)) {
                return fVar;
            }
        }
        return null;
    }

    @Override // com.baidu.swan.pms.database.a.b
    public List<com.baidu.swan.pms.model.f> i(Cursor cursor) {
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
    public ContentValues al(com.baidu.swan.pms.model.f fVar) {
        ContentValues e = super.e(fVar);
        e.put("pkg_type", Integer.valueOf(fVar.eug));
        return e;
    }
}
