package com.baidu.swan.pms.database.a;

import android.content.ContentValues;
import android.database.Cursor;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends b<PMSAppInfo> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.pms.database.a.b
    /* renamed from: h */
    public PMSAppInfo k(Cursor cursor) {
        if (cursor == null || cursor.getCount() <= 0 || !cursor.moveToFirst()) {
            return null;
        }
        return j(cursor);
    }

    @Override // com.baidu.swan.pms.database.a.b
    public List<PMSAppInfo> i(Cursor cursor) {
        ArrayList arrayList = new ArrayList();
        if (cursor != null && cursor.getCount() > 0 && cursor.moveToFirst()) {
            do {
                arrayList.add(j(cursor));
            } while (cursor.moveToNext());
            return arrayList;
        }
        return arrayList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.pms.database.a.b
    /* renamed from: t */
    public ContentValues al(PMSAppInfo pMSAppInfo) throws IllegalArgumentException {
        ContentValues contentValues = new ContentValues();
        if (pMSAppInfo != null) {
            contentValues.put("app_id", pMSAppInfo.appId);
            contentValues.put("app_key", pMSAppInfo.appKey);
            contentValues.put("app_sign", Long.valueOf(pMSAppInfo.appSign));
            contentValues.put("version_code", Long.valueOf(pMSAppInfo.versionCode));
            contentValues.put(SharedPrefConfig.VERSION_NAME, pMSAppInfo.versionName);
            contentValues.put("description", pMSAppInfo.description);
            contentValues.put("app_status", Integer.valueOf(pMSAppInfo.appStatus));
            contentValues.put("status_detail", pMSAppInfo.statusDetail);
            contentValues.put("status_desc", pMSAppInfo.statusDesc);
            contentValues.put("resume_date", pMSAppInfo.resumeDate);
            contentValues.put("icon_url", pMSAppInfo.iconUrl);
            contentValues.put("app_name", pMSAppInfo.appName);
            contentValues.put("service_category", pMSAppInfo.serviceCategory);
            contentValues.put("subject_info", pMSAppInfo.subjectInfo);
            contentValues.put("type", Integer.valueOf(pMSAppInfo.type));
            contentValues.put("pkg_size", Long.valueOf(pMSAppInfo.pkgSize));
            contentValues.put("pending_err_code", Integer.valueOf(pMSAppInfo.pendingErrCode));
            contentValues.put("app_category", Integer.valueOf(pMSAppInfo.appCategory));
            contentValues.put("orientation", Integer.valueOf(pMSAppInfo.getOrientation()));
            contentValues.put("max_age", Long.valueOf(pMSAppInfo.maxAge));
            contentValues.put("create_time", Long.valueOf(pMSAppInfo.createTime));
            contentValues.put("webview_domains", pMSAppInfo.webViewDomains);
            contentValues.put("web_action", pMSAppInfo.webAction);
            contentValues.put("domains", pMSAppInfo.domains);
            contentValues.put("bear_info", pMSAppInfo.bearInfo);
            contentValues.put("server_ext", pMSAppInfo.serverExt);
            contentValues.put("pay_protected", Integer.valueOf(pMSAppInfo.payProtected));
            contentValues.put("customer_service", Integer.valueOf(pMSAppInfo.customerService));
            contentValues.put("global_notice", Integer.valueOf(pMSAppInfo.globalNotice));
            contentValues.put("global_private", Integer.valueOf(pMSAppInfo.globalPrivate));
            contentValues.put("pa_number", pMSAppInfo.paNumber);
            contentValues.put(Constants.PHONE_BRAND, pMSAppInfo.brandsInfo);
            contentValues.put("quick_app_key", pMSAppInfo.quickAppKey);
            long lastLaunchTime = pMSAppInfo.getLastLaunchTime();
            if (0 < lastLaunchTime) {
                contentValues.put("last_launch_time", Long.valueOf(lastLaunchTime));
            }
            int aOg = pMSAppInfo.aOg();
            if (aOg > 0) {
                contentValues.put("launch_count", Integer.valueOf(aOg));
            }
            int aqY = pMSAppInfo.aqY();
            if (aqY > 0) {
                contentValues.put("install_src", Integer.valueOf(aqY));
            }
            contentValues.put("web_url", pMSAppInfo.webUrl);
            contentValues.put("cs_protocol_version", Integer.valueOf(pMSAppInfo.csProtocolVersion));
        }
        return contentValues;
    }

    private PMSAppInfo j(Cursor cursor) {
        if (cursor != null) {
            int columnIndex = cursor.getColumnIndex("app_id");
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
            int columnIndex27 = cursor.getColumnIndex("pay_protected");
            int columnIndex28 = cursor.getColumnIndex("customer_service");
            int columnIndex29 = cursor.getColumnIndex("global_notice");
            int columnIndex30 = cursor.getColumnIndex("global_private");
            int columnIndex31 = cursor.getColumnIndex("pa_number");
            int columnIndex32 = cursor.getColumnIndex(Constants.PHONE_BRAND);
            int columnIndex33 = cursor.getColumnIndex("last_launch_time");
            int columnIndex34 = cursor.getColumnIndex("launch_count");
            int columnIndex35 = cursor.getColumnIndex("install_src");
            int columnIndex36 = cursor.getColumnIndex("quick_app_key");
            int columnIndex37 = cursor.getColumnIndex("web_url");
            int columnIndex38 = cursor.getColumnIndex("cs_protocol_version");
            PMSAppInfo pMSAppInfo = new PMSAppInfo();
            pMSAppInfo.appId = cursor.getString(columnIndex);
            pMSAppInfo.appKey = cursor.getString(columnIndex2);
            pMSAppInfo.appSign = cursor.getLong(columnIndex3);
            pMSAppInfo.versionCode = cursor.getInt(columnIndex4);
            pMSAppInfo.versionName = cursor.getString(columnIndex5);
            pMSAppInfo.description = cursor.getString(columnIndex6);
            pMSAppInfo.appStatus = cursor.getInt(columnIndex7);
            pMSAppInfo.statusDetail = cursor.getString(columnIndex8);
            pMSAppInfo.statusDesc = cursor.getString(columnIndex9);
            pMSAppInfo.resumeDate = cursor.getString(columnIndex10);
            pMSAppInfo.iconUrl = cursor.getString(columnIndex11);
            pMSAppInfo.appName = cursor.getString(columnIndex12);
            pMSAppInfo.serviceCategory = cursor.getString(columnIndex13);
            pMSAppInfo.subjectInfo = cursor.getString(columnIndex14);
            pMSAppInfo.type = cursor.getInt(columnIndex15);
            pMSAppInfo.pkgSize = cursor.getLong(columnIndex16);
            pMSAppInfo.pendingErrCode = cursor.getInt(columnIndex17);
            pMSAppInfo.appCategory = cursor.getInt(columnIndex18);
            pMSAppInfo.setOrientation(cursor.getInt(columnIndex19));
            pMSAppInfo.maxAge = cursor.getLong(columnIndex20);
            pMSAppInfo.createTime = cursor.getLong(columnIndex21);
            pMSAppInfo.webViewDomains = cursor.getString(columnIndex22);
            pMSAppInfo.webAction = cursor.getString(columnIndex23);
            pMSAppInfo.domains = cursor.getString(columnIndex24);
            pMSAppInfo.bearInfo = cursor.getString(columnIndex25);
            pMSAppInfo.serverExt = cursor.getString(columnIndex26);
            pMSAppInfo.payProtected = cursor.getInt(columnIndex27);
            pMSAppInfo.customerService = cursor.getInt(columnIndex28);
            pMSAppInfo.globalNotice = cursor.getInt(columnIndex29);
            pMSAppInfo.globalPrivate = cursor.getInt(columnIndex30);
            pMSAppInfo.paNumber = cursor.getString(columnIndex31);
            pMSAppInfo.brandsInfo = cursor.getString(columnIndex32);
            pMSAppInfo.quickAppKey = cursor.getString(columnIndex36);
            pMSAppInfo.dt(cursor.getLong(columnIndex33));
            pMSAppInfo.lQ(cursor.getInt(columnIndex34));
            pMSAppInfo.lR(cursor.getInt(columnIndex35));
            pMSAppInfo.webUrl = cursor.getString(columnIndex37);
            pMSAppInfo.csProtocolVersion = cursor.getInt(columnIndex38);
            return pMSAppInfo;
        }
        return null;
    }
}
