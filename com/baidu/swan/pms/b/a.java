package com.baidu.swan.pms.b;

import android.database.Cursor;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
/* loaded from: classes15.dex */
public class a {
    private String appId;
    private String dTs;
    private long dTt = 0;
    private String downloadUrl;
    private String md5;
    private String sign;
    private long size;
    private int versionCode;
    private String versionName;

    private a() {
    }

    @NonNull
    public static a t(@NonNull Cursor cursor) {
        a aVar = new a();
        int columnIndex = cursor.getColumnIndex("app_id");
        int columnIndex2 = cursor.getColumnIndex("bundle_id");
        int columnIndex3 = cursor.getColumnIndex(SharedPrefConfig.VERSION_NAME);
        int columnIndex4 = cursor.getColumnIndex("version_code");
        int columnIndex5 = cursor.getColumnIndex("size");
        int columnIndex6 = cursor.getColumnIndex("md5");
        int columnIndex7 = cursor.getColumnIndex("sign");
        int columnIndex8 = cursor.getColumnIndex("downloadUrl");
        int columnIndex9 = cursor.getColumnIndex(IMConstants.MSG_ROW_ID);
        String string = cursor.getString(columnIndex2);
        if (!TextUtils.isEmpty(string)) {
            aVar.dTs = string;
            aVar.appId = cursor.getString(columnIndex);
            aVar.versionName = cursor.getString(columnIndex3);
            aVar.versionCode = cursor.getInt(columnIndex4);
            aVar.size = cursor.getLong(columnIndex5);
            aVar.md5 = cursor.getString(columnIndex6);
            aVar.sign = cursor.getString(columnIndex7);
            aVar.downloadUrl = cursor.getString(columnIndex8);
            aVar.dTt = cursor.getLong(columnIndex9);
        }
        return aVar;
    }

    @NonNull
    public String toString() {
        return "SwanMiniPackageInfo{appId='" + this.appId + "', bundleId='" + this.dTs + "', versionCode=" + this.versionCode + ", versionName='" + this.versionName + "', size=" + this.size + ", md5='" + this.md5 + "', sign='" + this.sign + "', downloadUrl='" + this.downloadUrl + "', rawid=" + this.dTt + '}';
    }

    public String getAppId() {
        return this.appId;
    }

    public String getBundleId() {
        return this.dTs;
    }

    public int getVersionCode() {
        return this.versionCode;
    }

    public String getVersionName() {
        return this.versionName;
    }

    public long getSize() {
        return this.size;
    }

    public String getMd5() {
        return this.md5;
    }

    public String getSign() {
        return this.sign;
    }

    public String getDownloadUrl() {
        return this.downloadUrl;
    }
}
