package com.baidu.swan.gamecenter.appmanager.download;

import android.os.Environment;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.down.manage.Download;
import com.baidu.searchbox.common.runtime.AppRuntime;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String dnk;
    private long dnl;
    private String mPackageName;
    private String mUrl;

    public a() {
        this.mUrl = "";
        this.dnk = "";
        this.dnl = System.currentTimeMillis();
    }

    public a(@NonNull Download download) {
        this.mUrl = "";
        this.dnk = "";
        this.dnl = System.currentTimeMillis();
        this.mUrl = download.getUrl();
        this.mPackageName = download.getKeyByUser();
        String fromParam = download.getFromParam();
        if (!TextUtils.isEmpty(fromParam)) {
            try {
                JSONObject jSONObject = new JSONObject(fromParam);
                this.dnk = jSONObject.optString("apk_id");
                this.dnl = jSONObject.optLong("download_time", System.currentTimeMillis());
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    public Download aKj() {
        Download download = new Download();
        download.setUrl(this.mUrl);
        download.setKeyByUser(this.mPackageName);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("apk_id", this.dnk);
            jSONObject.put("download_time", this.dnl);
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

    public a ui(String str) {
        this.mUrl = str;
        return this;
    }

    public a uj(String str) {
        this.mPackageName = str;
        return this;
    }

    public String aKk() {
        return this.dnk;
    }

    public a uk(String str) {
        this.dnk = str;
        return this;
    }

    public long getDownloadTime() {
        return this.dnl;
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
