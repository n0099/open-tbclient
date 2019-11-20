package com.baidu.swan.pms.database.a;

import android.content.ContentValues;
import android.database.Cursor;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a extends b<PMSAppInfo> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.pms.database.a.b
    /* renamed from: e */
    public PMSAppInfo h(Cursor cursor) {
        if (cursor == null || cursor.getCount() <= 0 || !cursor.moveToFirst()) {
            return null;
        }
        return g(cursor);
    }

    @Override // com.baidu.swan.pms.database.a.b
    public List<PMSAppInfo> f(Cursor cursor) {
        ArrayList arrayList = new ArrayList();
        if (cursor != null && cursor.getCount() > 0 && cursor.moveToFirst()) {
            do {
                arrayList.add(g(cursor));
            } while (cursor.moveToNext());
            return arrayList;
        }
        return arrayList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.pms.database.a.b
    /* renamed from: g */
    public ContentValues S(PMSAppInfo pMSAppInfo) throws IllegalArgumentException {
        ContentValues contentValues = new ContentValues();
        if (pMSAppInfo != null) {
            contentValues.put(Constants.APP_ID, pMSAppInfo.appId);
            contentValues.put("app_key", pMSAppInfo.appKey);
            contentValues.put("app_sign", Long.valueOf(pMSAppInfo.bKY));
            contentValues.put("version_code", Integer.valueOf(pMSAppInfo.versionCode));
            contentValues.put(SharedPrefConfig.VERSION_NAME, pMSAppInfo.versionName);
            contentValues.put("description", pMSAppInfo.description);
            contentValues.put("app_status", Integer.valueOf(pMSAppInfo.appStatus));
            contentValues.put("status_detail", pMSAppInfo.bKZ);
            contentValues.put("status_desc", pMSAppInfo.bLa);
            contentValues.put("resume_date", pMSAppInfo.aOo);
            contentValues.put("icon_url", pMSAppInfo.iconUrl);
            contentValues.put("app_name", pMSAppInfo.appName);
            contentValues.put("service_category", pMSAppInfo.aOr);
            contentValues.put("subject_info", pMSAppInfo.aOs);
            contentValues.put("type", Integer.valueOf(pMSAppInfo.type));
            contentValues.put("pkg_size", Long.valueOf(pMSAppInfo.bLb));
            contentValues.put("pending_err_code", Integer.valueOf(pMSAppInfo.bLc));
            contentValues.put("app_category", Integer.valueOf(pMSAppInfo.bLd));
            contentValues.put("orientation", Integer.valueOf(pMSAppInfo.orientation));
            contentValues.put("max_age", Long.valueOf(pMSAppInfo.aOB));
            contentValues.put("create_time", Long.valueOf(pMSAppInfo.createTime));
            contentValues.put("webview_domains", pMSAppInfo.bLe);
            contentValues.put("web_action", pMSAppInfo.bLf);
            contentValues.put("domains", pMSAppInfo.bLg);
            contentValues.put("bear_info", pMSAppInfo.aOt);
            contentValues.put("server_ext", pMSAppInfo.bLh);
        }
        return contentValues;
    }

    private PMSAppInfo g(Cursor cursor) {
        if (cursor != null) {
            int columnIndex = cursor.getColumnIndex(Constants.APP_ID);
            int columnIndex2 = cursor.getColumnIndex("app_key");
            int columnIndex3 = cursor.getColumnIndex("app_sign");
            int columnIndex4 = cursor.getColumnIndex("version_code");
            int columnIndex5 = cursor.getColumnIndex(SharedPrefConfig.VERSION_NAME);
            int columnIndex6 = cursor.getColumnIndex("description");
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
            PMSAppInfo pMSAppInfo = new PMSAppInfo();
            pMSAppInfo.appId = cursor.getString(columnIndex);
            pMSAppInfo.appKey = cursor.getString(columnIndex2);
            pMSAppInfo.bKY = cursor.getLong(columnIndex3);
            pMSAppInfo.versionCode = cursor.getInt(columnIndex4);
            pMSAppInfo.versionName = cursor.getString(columnIndex5);
            pMSAppInfo.description = cursor.getString(columnIndex6);
            pMSAppInfo.appStatus = cursor.getInt(columnIndex7);
            pMSAppInfo.bKZ = cursor.getString(columnIndex8);
            pMSAppInfo.bLa = cursor.getString(columnIndex9);
            pMSAppInfo.aOo = cursor.getString(columnIndex10);
            pMSAppInfo.iconUrl = cursor.getString(columnIndex11);
            pMSAppInfo.appName = cursor.getString(columnIndex12);
            pMSAppInfo.aOr = cursor.getString(columnIndex13);
            pMSAppInfo.aOs = cursor.getString(columnIndex14);
            pMSAppInfo.type = cursor.getInt(columnIndex15);
            pMSAppInfo.bLb = cursor.getLong(columnIndex16);
            pMSAppInfo.bLc = cursor.getInt(columnIndex17);
            pMSAppInfo.bLd = cursor.getInt(columnIndex18);
            pMSAppInfo.orientation = cursor.getInt(columnIndex19);
            pMSAppInfo.aOB = cursor.getLong(columnIndex20);
            pMSAppInfo.createTime = cursor.getLong(columnIndex21);
            pMSAppInfo.bLe = cursor.getString(columnIndex22);
            pMSAppInfo.bLf = cursor.getString(columnIndex23);
            pMSAppInfo.bLg = cursor.getString(columnIndex24);
            pMSAppInfo.aOt = cursor.getString(columnIndex25);
            pMSAppInfo.bLh = cursor.getString(columnIndex26);
            return pMSAppInfo;
        }
        return null;
    }
}
