package com.baidu.swan.pms.database.a;

import android.content.ContentValues;
import android.database.Cursor;
import android.support.annotation.NonNull;
import com.baidu.swan.pms.utils.AbiType;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes15.dex */
public class i extends b<com.baidu.swan.pms.model.i> implements com.baidu.swan.pms.database.c {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.pms.database.a.b
    /* renamed from: r */
    public com.baidu.swan.pms.model.i j(Cursor cursor) {
        if (cursor == null || cursor.getCount() <= 0 || !cursor.moveToFirst()) {
            return null;
        }
        return s(cursor);
    }

    @Override // com.baidu.swan.pms.database.a.b
    public List<com.baidu.swan.pms.model.i> h(Cursor cursor) {
        ArrayList arrayList = new ArrayList();
        if (cursor != null && cursor.getCount() > 0 && cursor.moveToFirst()) {
            do {
                arrayList.add(s(cursor));
            } while (cursor.moveToNext());
            return arrayList;
        }
        return arrayList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.pms.database.a.b
    /* renamed from: j */
    public ContentValues aj(com.baidu.swan.pms.model.i iVar) {
        ContentValues e = super.e(iVar);
        e.put("max_age", Long.valueOf(iVar.maxAge));
        e.put("abi", iVar.dTy.id);
        e.put("lib_name", iVar.cEd);
        return e;
    }

    private com.baidu.swan.pms.model.i s(Cursor cursor) {
        if (cursor != null) {
            com.baidu.swan.pms.model.i iVar = new com.baidu.swan.pms.model.i();
            if (a(cursor, iVar)) {
                iVar.maxAge = cursor.getLong(a(cursor, "max_age"));
                iVar.dTy = AbiType.findById(cursor.getString(a(cursor, "abi")), null);
                iVar.cEd = cursor.getString(a(cursor, "lib_name"));
                return iVar;
            }
        }
        return null;
    }

    private static int a(@NonNull Cursor cursor, @NonNull String str) {
        return cursor.getColumnIndex(str);
    }
}
