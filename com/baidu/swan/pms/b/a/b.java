package com.baidu.swan.pms.b.a;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class b extends com.baidu.swan.pms.database.a.b<com.baidu.swan.pms.b.a> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.pms.database.a.b
    /* renamed from: e */
    public ContentValues af(@NonNull com.baidu.swan.pms.b.a aVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", aVar.getAppId());
        contentValues.put("bundle_id", aVar.getBundleId());
        contentValues.put(SharedPrefConfig.VERSION_NAME, aVar.getVersionName());
        contentValues.put("version_code", Integer.valueOf(aVar.getVersionCode()));
        contentValues.put(TiebaInitialize.LogFields.SIZE, Long.valueOf(aVar.getSize()));
        contentValues.put("md5", aVar.getMd5());
        contentValues.put("sign", aVar.getSign());
        contentValues.put("downloadUrl", aVar.getDownloadUrl());
        return contentValues;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.pms.database.a.b
    @Nullable
    /* renamed from: s */
    public com.baidu.swan.pms.b.a j(Cursor cursor) throws SQLException {
        if (cursor == null || cursor.getCount() <= 0 || !cursor.moveToFirst()) {
            return null;
        }
        return t(cursor);
    }

    @Override // com.baidu.swan.pms.database.a.b
    public List<com.baidu.swan.pms.b.a> h(Cursor cursor) throws SQLException {
        ArrayList arrayList = new ArrayList();
        if (cursor != null && cursor.getCount() > 0 && cursor.moveToFirst()) {
            do {
                arrayList.add(t(cursor));
            } while (cursor.moveToNext());
            return arrayList;
        }
        return arrayList;
    }

    @Nullable
    private com.baidu.swan.pms.b.a t(Cursor cursor) {
        if (cursor != null) {
            return com.baidu.swan.pms.b.a.r(cursor);
        }
        return null;
    }
}
