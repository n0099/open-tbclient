package com.baidu.swan.pms.b;

import android.database.Cursor;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import org.json.JSONObject;
/* loaded from: classes19.dex */
public class a {
    private String appId;
    private String downloadUrl;
    private String dvZ;
    private long dwa = 0;
    private String md5;
    private String sign;
    private long size;
    private int versionCode;
    private String versionName;

    private a() {
    }

    @NonNull
    public static a cl(@NonNull JSONObject jSONObject) {
        a aVar = new a();
        aVar.appId = jSONObject.optString("appKey");
        JSONObject optJSONObject = jSONObject.optJSONObject("packageInfo");
        if (optJSONObject != null) {
            aVar.dvZ = optJSONObject.optString("bundle_id");
            aVar.downloadUrl = optJSONObject.optString("download_url");
            aVar.md5 = optJSONObject.optString("md5");
            aVar.sign = optJSONObject.optString("sign");
            aVar.size = optJSONObject.optLong(TiebaInitialize.LogFields.SIZE);
            aVar.versionCode = optJSONObject.optInt("version_code");
            aVar.versionName = optJSONObject.optString(SharedPrefConfig.VERSION_NAME);
        }
        return aVar;
    }

    @NonNull
    public static a r(@NonNull Cursor cursor) {
        a aVar = new a();
        int columnIndex = cursor.getColumnIndex("app_id");
        int columnIndex2 = cursor.getColumnIndex("bundle_id");
        int columnIndex3 = cursor.getColumnIndex(SharedPrefConfig.VERSION_NAME);
        int columnIndex4 = cursor.getColumnIndex("version_code");
        int columnIndex5 = cursor.getColumnIndex(TiebaInitialize.LogFields.SIZE);
        int columnIndex6 = cursor.getColumnIndex("md5");
        int columnIndex7 = cursor.getColumnIndex("sign");
        int columnIndex8 = cursor.getColumnIndex("downloadUrl");
        int columnIndex9 = cursor.getColumnIndex(IMConstants.MSG_ROW_ID);
        String string = cursor.getString(columnIndex2);
        if (!TextUtils.isEmpty(string)) {
            aVar.dvZ = string;
            aVar.appId = cursor.getString(columnIndex);
            aVar.versionName = cursor.getString(columnIndex3);
            aVar.versionCode = cursor.getInt(columnIndex4);
            aVar.size = cursor.getLong(columnIndex5);
            aVar.md5 = cursor.getString(columnIndex6);
            aVar.sign = cursor.getString(columnIndex7);
            aVar.downloadUrl = cursor.getString(columnIndex8);
            aVar.dwa = cursor.getLong(columnIndex9);
        }
        return aVar;
    }

    public boolean acP() {
        return (TextUtils.isEmpty(this.appId) || TextUtils.isEmpty(this.dvZ) || this.versionCode <= 0 || this.size <= 0 || TextUtils.isEmpty(this.md5) || TextUtils.isEmpty(this.sign) || TextUtils.isEmpty(this.downloadUrl)) ? false : true;
    }

    @NonNull
    public String toString() {
        return "SwanMiniPackageInfo{appId='" + this.appId + "', bundleId='" + this.dvZ + "', versionCode=" + this.versionCode + ", versionName='" + this.versionName + "', size=" + this.size + ", md5='" + this.md5 + "', sign='" + this.sign + "', downloadUrl='" + this.downloadUrl + "', rawid=" + this.dwa + '}';
    }

    @NonNull
    public String aed() {
        return "SwanMiniPackageInfo{appId='" + this.appId + "', bundleId='" + this.dvZ + "', versionCode=" + this.versionCode + ", md5='" + this.md5 + "'}";
    }

    public String getAppId() {
        return this.appId;
    }

    public String getBundleId() {
        return this.dvZ;
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
