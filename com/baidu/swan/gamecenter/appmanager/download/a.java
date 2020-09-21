package com.baidu.swan.gamecenter.appmanager.download;

import android.os.Environment;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.down.manage.Download;
import com.baidu.searchbox.common.runtime.AppRuntime;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes14.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String dpr;
    private long dps;
    private String mPackageName;
    private String mUrl;

    public a() {
        this.mUrl = "";
        this.dpr = "";
        this.dps = System.currentTimeMillis();
    }

    public a(@NonNull Download download) {
        this.mUrl = "";
        this.dpr = "";
        this.dps = System.currentTimeMillis();
        this.mUrl = download.getUrl();
        this.mPackageName = download.getKeyByUser();
        String fromParam = download.getFromParam();
        if (!TextUtils.isEmpty(fromParam)) {
            try {
                JSONObject jSONObject = new JSONObject(fromParam);
                this.dpr = jSONObject.optString("apk_id");
                this.dps = jSONObject.optLong("download_time", System.currentTimeMillis());
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    public Download aKU() {
        Download download = new Download();
        download.setUrl(this.mUrl);
        download.setKeyByUser(this.mPackageName);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("apk_id", this.dpr);
            jSONObject.put("download_time", this.dps);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        download.setFromParam(jSONObject.toString());
        download.setMimetype("application/vnd.android.package-archive");
        download.setWifiOnly(false);
        String downloadDir = getDownloadDir();
        if (!TextUtils.isEmpty(downloadDir)) {
            download.setSavedPathForUser(downloadDir);
        }
        download.setFileName(System.currentTimeMillis() + ".apk");
        return download;
    }

    public a uC(String str) {
        this.mUrl = str;
        return this;
    }

    public a uD(String str) {
        this.mPackageName = str;
        return this;
    }

    public String aKV() {
        return this.dpr;
    }

    public a uE(String str) {
        this.dpr = str;
        return this;
    }

    public long getDownloadTime() {
        return this.dps;
    }

    private static String getDownloadDir() {
        String str = null;
        if (Environment.getExternalStorageState().equals("mounted")) {
            str = AppRuntime.getAppContext().getExternalFilesDir(null) + File.separator + "gameCenter/download/apk";
            File file = new File(str);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        return str;
    }
}
