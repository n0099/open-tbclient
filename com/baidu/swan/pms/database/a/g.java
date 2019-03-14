package com.baidu.swan.pms.database.a;

import android.content.ContentValues;
import android.database.Cursor;
import com.baidu.swan.pms.model.i;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class g extends b<i> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.pms.database.a.b
    /* renamed from: p */
    public i l(Cursor cursor) {
        if (cursor == null || cursor.getCount() <= 0 || !cursor.moveToFirst()) {
            return null;
        }
        return q(cursor);
    }

    @Override // com.baidu.swan.pms.database.a.b
    public List<i> j(Cursor cursor) {
        ArrayList arrayList = new ArrayList();
        if (cursor != null && cursor.getCount() > 0 && cursor.moveToFirst()) {
            do {
                arrayList.add(q(cursor));
            } while (cursor.moveToNext());
            return arrayList;
        }
        return arrayList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.pms.database.a.b
    /* renamed from: f */
    public ContentValues W(i iVar) {
        ContentValues e = super.e(iVar);
        e.put("independent", Integer.valueOf(iVar.bma ? 1 : 0));
        e.put("sub_pkg_name", iVar.Jz);
        e.put("app_id", iVar.appId);
        return e;
    }

    private i q(Cursor cursor) {
        if (cursor != null) {
            int columnIndex = cursor.getColumnIndex("independent");
            int columnIndex2 = cursor.getColumnIndex("sub_pkg_name");
            int columnIndex3 = cursor.getColumnIndex("app_id");
            i iVar = new i();
            if (a(cursor, iVar)) {
                iVar.bma = cursor.getInt(columnIndex) == 1;
                iVar.Jz = cursor.getString(columnIndex2);
                iVar.appId = cursor.getString(columnIndex3);
                return iVar;
            }
        }
        return null;
    }
}
