package com.baidu.swan.facade.provider.a;

import android.database.Cursor;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.xiaomi.mipush.sdk.Constants;
import java.util.HashMap;
/* loaded from: classes11.dex */
public class a {
    public static HashMap<String, PMSAppInfo> ajw() {
        Cursor query = com.baidu.swan.pms.database.provider.a.atA().getReadableDatabase().query("swan_app", null, null, null, null, null, null);
        HashMap<String, PMSAppInfo> hashMap = new HashMap<>();
        if (query != null && query.moveToFirst()) {
            int columnIndex = query.getColumnIndex(Constants.APP_ID);
            int columnIndex2 = query.getColumnIndex("app_key");
            int columnIndex3 = query.getColumnIndex("app_sign");
            int columnIndex4 = query.getColumnIndex("version_code");
            int columnIndex5 = query.getColumnIndex(SharedPrefConfig.VERSION_NAME);
            int columnIndex6 = query.getColumnIndex("description");
            int columnIndex7 = query.getColumnIndex("app_status");
            int columnIndex8 = query.getColumnIndex("status_detail");
            int columnIndex9 = query.getColumnIndex("status_desc");
            int columnIndex10 = query.getColumnIndex("resume_date");
            int columnIndex11 = query.getColumnIndex("icon_url");
            int columnIndex12 = query.getColumnIndex("app_name");
            int columnIndex13 = query.getColumnIndex("service_category");
            int columnIndex14 = query.getColumnIndex("subject_info");
            int columnIndex15 = query.getColumnIndex("type");
            int columnIndex16 = query.getColumnIndex("pkg_size");
            int columnIndex17 = query.getColumnIndex("pending_err_code");
            int columnIndex18 = query.getColumnIndex("app_category");
            int columnIndex19 = query.getColumnIndex("orientation");
            int columnIndex20 = query.getColumnIndex("max_age");
            int columnIndex21 = query.getColumnIndex("create_time");
            int columnIndex22 = query.getColumnIndex("webview_domains");
            int columnIndex23 = query.getColumnIndex("web_action");
            int columnIndex24 = query.getColumnIndex("domains");
            int columnIndex25 = query.getColumnIndex("bear_info");
            int columnIndex26 = query.getColumnIndex("server_ext");
            int columnIndex27 = query.getColumnIndex("pay_protected");
            do {
                PMSAppInfo pMSAppInfo = new PMSAppInfo();
                pMSAppInfo.appId = query.getString(columnIndex);
                pMSAppInfo.appKey = query.getString(columnIndex2);
                pMSAppInfo.appSign = query.getLong(columnIndex3);
                pMSAppInfo.versionCode = query.getInt(columnIndex4);
                pMSAppInfo.versionName = query.getString(columnIndex5);
                pMSAppInfo.description = query.getString(columnIndex6);
                pMSAppInfo.appStatus = query.getInt(columnIndex7);
                pMSAppInfo.statusDetail = query.getString(columnIndex8);
                pMSAppInfo.statusDesc = query.getString(columnIndex9);
                pMSAppInfo.resumeDate = query.getString(columnIndex10);
                pMSAppInfo.iconUrl = query.getString(columnIndex11);
                pMSAppInfo.appName = query.getString(columnIndex12);
                pMSAppInfo.serviceCategory = query.getString(columnIndex13);
                pMSAppInfo.subjectInfo = query.getString(columnIndex14);
                pMSAppInfo.type = query.getInt(columnIndex15);
                pMSAppInfo.pkgSize = query.getLong(columnIndex16);
                pMSAppInfo.pendingErrCode = query.getInt(columnIndex17);
                pMSAppInfo.appCategory = query.getInt(columnIndex18);
                pMSAppInfo.orientation = query.getInt(columnIndex19);
                pMSAppInfo.maxAge = query.getLong(columnIndex20);
                pMSAppInfo.createTime = query.getLong(columnIndex21);
                pMSAppInfo.webViewDomains = query.getString(columnIndex22);
                pMSAppInfo.webAction = query.getString(columnIndex23);
                pMSAppInfo.domains = query.getString(columnIndex24);
                pMSAppInfo.bearInfo = query.getString(columnIndex25);
                pMSAppInfo.serverExt = query.getString(columnIndex26);
                pMSAppInfo.payProtected = query.getInt(columnIndex27);
                hashMap.put(pMSAppInfo.appId, pMSAppInfo);
            } while (query.moveToNext());
            com.baidu.swan.d.c.closeSafely(query);
            return hashMap;
        }
        com.baidu.swan.d.c.closeSafely(query);
        return hashMap;
    }
}
