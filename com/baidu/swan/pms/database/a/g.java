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
    /* renamed from: l */
    public h h(Cursor cursor) {
        if (cursor == null || cursor.getCount() <= 0 || !cursor.moveToFirst()) {
            return null;
        }
        return m(cursor);
    }

    @Override // com.baidu.swan.pms.database.a.b
    public List<h> f(Cursor cursor) {
        ArrayList arrayList = new ArrayList();
        if (cursor != null && cursor.getCount() > 0 && cursor.moveToFirst()) {
            do {
                arrayList.add(m(cursor));
            } while (cursor.moveToNext());
            return arrayList;
        }
        return arrayList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.pms.database.a.b
    /* renamed from: h */
    public ContentValues S(h hVar) {
        ContentValues g = super.g(hVar);
        g.put("independent", Integer.valueOf(hVar.bLn ? 1 : 0));
        g.put("sub_pkg_name", hVar.pkgName);
        g.put(Constants.APP_ID, hVar.appId);
        return g;
    }

    private h m(Cursor cursor) {
        if (cursor != null) {
            int columnIndex = cursor.getColumnIndex("independent");
            int columnIndex2 = cursor.getColumnIndex("sub_pkg_name");
            int columnIndex3 = cursor.getColumnIndex(Constants.APP_ID);
            h hVar = new h();
            if (a(cursor, hVar)) {
                hVar.bLn = cursor.getInt(columnIndex) == 1;
                hVar.pkgName = cursor.getString(columnIndex2);
                hVar.appId = cursor.getString(columnIndex3);
                return hVar;
            }
        }
        return null;
    }
}
