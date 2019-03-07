package com.baidu.swan.pms.database.a;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.open.SocialConstants;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a extends b<com.baidu.swan.pms.model.a> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.pms.database.a.b
    /* renamed from: i */
    public com.baidu.swan.pms.model.a l(Cursor cursor) {
        if (cursor == null || cursor.getCount() <= 0 || !cursor.moveToFirst()) {
            return null;
        }
        return k(cursor);
    }

    @Override // com.baidu.swan.pms.database.a.b
    public List<com.baidu.swan.pms.model.a> j(Cursor cursor) {
        ArrayList arrayList = new ArrayList();
        if (cursor != null && cursor.getCount() > 0 && cursor.moveToFirst()) {
            do {
                arrayList.add(k(cursor));
            } while (cursor.moveToNext());
            return arrayList;
        }
        return arrayList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.pms.database.a.b
    /* renamed from: g */
    public ContentValues W(com.baidu.swan.pms.model.a aVar) throws IllegalArgumentException {
        ContentValues contentValues = new ContentValues();
        if (aVar != null) {
            contentValues.put("app_id", aVar.appId);
            contentValues.put("app_key", aVar.appKey);
            contentValues.put("app_sign", Long.valueOf(aVar.blL));
            contentValues.put("version_code", Integer.valueOf(aVar.versionCode));
            contentValues.put("version_name", aVar.versionName);
            contentValues.put(SocialConstants.PARAM_COMMENT, aVar.description);
            contentValues.put("app_status", Integer.valueOf(aVar.appStatus));
            contentValues.put("status_detail", aVar.blM);
            contentValues.put("status_desc", aVar.blN);
            contentValues.put("resume_date", aVar.atT);
            contentValues.put("icon_url", aVar.iconUrl);
            contentValues.put("app_name", aVar.appName);
            contentValues.put("service_category", aVar.atW);
            contentValues.put("subject_info", aVar.atX);
            contentValues.put("type", Integer.valueOf(aVar.type));
            contentValues.put("pkg_size", Long.valueOf(aVar.blO));
            contentValues.put("pending_err_code", Integer.valueOf(aVar.blP));
            contentValues.put("app_category", Integer.valueOf(aVar.appCategory));
            contentValues.put("orientation", Integer.valueOf(aVar.orientation));
            contentValues.put("max_age", Long.valueOf(aVar.aug));
            contentValues.put("create_time", Long.valueOf(aVar.createTime));
            contentValues.put("webview_domains", aVar.blQ);
            contentValues.put("web_action", aVar.blR);
            contentValues.put("domains", aVar.blS);
            contentValues.put("bear_info", aVar.atY);
            contentValues.put("server_ext", aVar.blT);
        }
        return contentValues;
    }

    private com.baidu.swan.pms.model.a k(Cursor cursor) {
        if (cursor != null) {
            int columnIndex = cursor.getColumnIndex("app_id");
            int columnIndex2 = cursor.getColumnIndex("app_key");
            int columnIndex3 = cursor.getColumnIndex("app_sign");
            int columnIndex4 = cursor.getColumnIndex("version_code");
            int columnIndex5 = cursor.getColumnIndex("version_name");
            int columnIndex6 = cursor.getColumnIndex(SocialConstants.PARAM_COMMENT);
            int columnIndex7 = cursor.getColumnIndex("app_status");
            int columnIndex8 = cursor.getColumnIndex("status_detail");
            int columnIndex9 = cursor.getColumnIndex("status_desc");
            int columnIndex10 = cursor.getColumnIndex("resume_date");
            int columnIndex11 = cursor.getColumnIndex("icon_url");
            int columnIndex12 = cursor.getColumnIndex("app_name");
            int columnIndex13 = cursor.getColumnIndex("service_category");
            int columnIndex14 = cursor.getColumnIndex("subject_info");
            int columnIndex15 = cursor.getColumnIndex("type");
            int columnIndex16 = cursor.getColumnIndex("pkg_size");
            int columnIndex17 = cursor.getColumnIndex("pending_err_code");
            int columnIndex18 = cursor.getColumnIndex("app_category");
            int columnIndex19 = cursor.getColumnIndex("orientation");
            int columnIndex20 = cursor.getColumnIndex("max_age");
            int columnIndex21 = cursor.getColumnIndex("create_time");
            int columnIndex22 = cursor.getColumnIndex("webview_domains");
            int columnIndex23 = cursor.getColumnIndex("web_action");
            int columnIndex24 = cursor.getColumnIndex("domains");
            int columnIndex25 = cursor.getColumnIndex("bear_info");
            int columnIndex26 = cursor.getColumnIndex("server_ext");
            com.baidu.swan.pms.model.a aVar = new com.baidu.swan.pms.model.a();
            aVar.appId = cursor.getString(columnIndex);
            aVar.appKey = cursor.getString(columnIndex2);
            aVar.blL = cursor.getLong(columnIndex3);
            aVar.versionCode = cursor.getInt(columnIndex4);
            aVar.versionName = cursor.getString(columnIndex5);
            aVar.description = cursor.getString(columnIndex6);
            aVar.appStatus = cursor.getInt(columnIndex7);
            aVar.blM = cursor.getString(columnIndex8);
            aVar.blN = cursor.getString(columnIndex9);
            aVar.atT = cursor.getString(columnIndex10);
            aVar.iconUrl = cursor.getString(columnIndex11);
            aVar.appName = cursor.getString(columnIndex12);
            aVar.atW = cursor.getString(columnIndex13);
            aVar.atX = cursor.getString(columnIndex14);
            aVar.type = cursor.getInt(columnIndex15);
            aVar.blO = cursor.getLong(columnIndex16);
            aVar.blP = cursor.getInt(columnIndex17);
            aVar.appCategory = cursor.getInt(columnIndex18);
            aVar.orientation = cursor.getInt(columnIndex19);
            aVar.aug = cursor.getLong(columnIndex20);
            aVar.createTime = cursor.getLong(columnIndex21);
            aVar.blQ = cursor.getString(columnIndex22);
            aVar.blR = cursor.getString(columnIndex23);
            aVar.blS = cursor.getString(columnIndex24);
            aVar.atY = cursor.getString(columnIndex25);
            aVar.blT = cursor.getString(columnIndex26);
            return aVar;
        }
        return null;
    }
}
