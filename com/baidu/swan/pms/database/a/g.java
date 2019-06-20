package com.baidu.swan.pms.database.a;

import android.content.ContentValues;
import android.database.Cursor;
import com.baidu.swan.pms.model.h;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class g extends b<h> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.pms.database.a.b
    /* renamed from: p */
    public h l(Cursor cursor) {
        if (cursor == null || cursor.getCount() <= 0 || !cursor.moveToFirst()) {
            return null;
        }
        return q(cursor);
    }

    @Override // com.baidu.swan.pms.database.a.b
    public List<h> j(Cursor cursor) {
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
    /* renamed from: h */
    public ContentValues U(h hVar) {
        ContentValues g = super.g(hVar);
        g.put("independent", Integer.valueOf(hVar.bsg ? 1 : 0));
        g.put("sub_pkg_name", hVar.Hi);
        g.put(Constants.APP_ID, hVar.appId);
        return g;
    }

    private h q(Cursor cursor) {
        if (cursor != null) {
            int columnIndex = cursor.getColumnIndex("independent");
            int columnIndex2 = cursor.getColumnIndex("sub_pkg_name");
            int columnIndex3 = cursor.getColumnIndex(Constants.APP_ID);
            h hVar = new h();
            if (a(cursor, hVar)) {
                hVar.bsg = cursor.getInt(columnIndex) == 1;
                hVar.Hi = cursor.getString(columnIndex2);
                hVar.appId = cursor.getString(columnIndex3);
                return hVar;
            }
        }
        return null;
    }
}
