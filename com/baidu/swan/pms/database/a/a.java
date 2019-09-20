package com.baidu.swan.pms.database.a;

import android.content.ContentValues;
import android.database.Cursor;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a extends b<PMSAppInfo> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.pms.database.a.b
    /* renamed from: i */
    public PMSAppInfo l(Cursor cursor) {
        if (cursor == null || cursor.getCount() <= 0 || !cursor.moveToFirst()) {
            return null;
        }
        return k(cursor);
    }

    @Override // com.baidu.swan.pms.database.a.b
    public List<PMSAppInfo> j(Cursor cursor) {
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
    public ContentValues U(PMSAppInfo pMSAppInfo) throws IllegalArgumentException {
        ContentValues contentValues = new ContentValues();
        if (pMSAppInfo != null) {
            contentValues.put(Constants.APP_ID, pMSAppInfo.appId);
            contentValues.put("app_key", pMSAppInfo.appKey);
            contentValues.put("app_sign", Long.valueOf(pMSAppInfo.bte));
            contentValues.put("version_code", Integer.valueOf(pMSAppInfo.versionCode));
            contentValues.put("version_name", pMSAppInfo.versionName);
            contentValues.put("description", pMSAppInfo.description);
            contentValues.put("app_status", Integer.valueOf(pMSAppInfo.appStatus));
            contentValues.put("status_detail", pMSAppInfo.btf);
            contentValues.put("status_desc", pMSAppInfo.btg);
            contentValues.put("resume_date", pMSAppInfo.avq);
            contentValues.put("icon_url", pMSAppInfo.iconUrl);
            contentValues.put(DpStatConstants.KEY_APP_NAME, pMSAppInfo.appName);
            contentValues.put("service_category", pMSAppInfo.avt);
            contentValues.put("subject_info", pMSAppInfo.avu);
            contentValues.put("type", Integer.valueOf(pMSAppInfo.type));
            contentValues.put("pkg_size", Long.valueOf(pMSAppInfo.bth));
            contentValues.put("pending_err_code", Integer.valueOf(pMSAppInfo.bti));
            contentValues.put("app_category", Integer.valueOf(pMSAppInfo.btj));
            contentValues.put("orientation", Integer.valueOf(pMSAppInfo.orientation));
            contentValues.put("max_age", Long.valueOf(pMSAppInfo.avE));
            contentValues.put("create_time", Long.valueOf(pMSAppInfo.createTime));
            contentValues.put("webview_domains", pMSAppInfo.btk);
            contentValues.put("web_action", pMSAppInfo.btl);
            contentValues.put("domains", pMSAppInfo.btm);
            contentValues.put("bear_info", pMSAppInfo.avv);
            contentValues.put("server_ext", pMSAppInfo.btn);
        }
        return contentValues;
    }

    private PMSAppInfo k(Cursor cursor) {
        if (cursor != null) {
            int columnIndex = cursor.getColumnIndex(Constants.APP_ID);
            int columnIndex2 = cursor.getColumnIndex("app_key");
            int columnIndex3 = cursor.getColumnIndex("app_sign");
            int columnIndex4 = cursor.getColumnIndex("version_code");
            int columnIndex5 = cursor.getColumnIndex("version_name");
            int columnIndex6 = cursor.getColumnIndex("description");
            int columnIndex7 = cursor.getColumnIndex("app_status");
            int columnIndex8 = cursor.getColumnIndex("status_detail");
            int columnIndex9 = cursor.getColumnIndex("status_desc");
            int columnIndex10 = cursor.getColumnIndex("resume_date");
            int columnIndex11 = cursor.getColumnIndex("icon_url");
            int columnIndex12 = cursor.getColumnIndex(DpStatConstants.KEY_APP_NAME);
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
            pMSAppInfo.bte = cursor.getLong(columnIndex3);
            pMSAppInfo.versionCode = cursor.getInt(columnIndex4);
            pMSAppInfo.versionName = cursor.getString(columnIndex5);
            pMSAppInfo.description = cursor.getString(columnIndex6);
            pMSAppInfo.appStatus = cursor.getInt(columnIndex7);
            pMSAppInfo.btf = cursor.getString(columnIndex8);
            pMSAppInfo.btg = cursor.getString(columnIndex9);
            pMSAppInfo.avq = cursor.getString(columnIndex10);
            pMSAppInfo.iconUrl = cursor.getString(columnIndex11);
            pMSAppInfo.appName = cursor.getString(columnIndex12);
            pMSAppInfo.avt = cursor.getString(columnIndex13);
            pMSAppInfo.avu = cursor.getString(columnIndex14);
            pMSAppInfo.type = cursor.getInt(columnIndex15);
            pMSAppInfo.bth = cursor.getLong(columnIndex16);
            pMSAppInfo.bti = cursor.getInt(columnIndex17);
            pMSAppInfo.btj = cursor.getInt(columnIndex18);
            pMSAppInfo.orientation = cursor.getInt(columnIndex19);
            pMSAppInfo.avE = cursor.getLong(columnIndex20);
            pMSAppInfo.createTime = cursor.getLong(columnIndex21);
            pMSAppInfo.btk = cursor.getString(columnIndex22);
            pMSAppInfo.btl = cursor.getString(columnIndex23);
            pMSAppInfo.btm = cursor.getString(columnIndex24);
            pMSAppInfo.avv = cursor.getString(columnIndex25);
            pMSAppInfo.btn = cursor.getString(columnIndex26);
            return pMSAppInfo;
        }
        return null;
    }
}
