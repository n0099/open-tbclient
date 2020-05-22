package com.baidu.swan.b.a.b;

import android.os.Environment;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.down.manage.Download;
import com.baidu.searchbox.common.runtime.AppRuntime;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String cSL;
    private long cSM;
    private String mPackageName;
    private String mUrl;

    public a() {
        this.mUrl = "";
        this.cSL = "";
        this.cSM = System.currentTimeMillis();
    }

    public a(@NonNull Download download) {
        this.mUrl = "";
        this.cSL = "";
        this.cSM = System.currentTimeMillis();
        this.mUrl = download.getUrl();
        this.mPackageName = download.getKeyByUser();
        String fromParam = download.getFromParam();
        if (!TextUtils.isEmpty(fromParam)) {
            try {
                JSONObject jSONObject = new JSONObject(fromParam);
                this.cSL = jSONObject.optString("apk_id");
                this.cSM = jSONObject.optLong("download_time", System.currentTimeMillis());
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    public Download awV() {
        Download download = new Download();
        download.setUrl(this.mUrl);
        download.setKeyByUser(this.mPackageName);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("apk_id", this.cSL);
            jSONObject.put("download_time", this.cSM);
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

    public a qM(String str) {
        this.mUrl = str;
        return this;
    }

    public a qN(String str) {
        this.mPackageName = str;
        return this;
    }

    public String awW() {
        return this.cSL;
    }

    public a qO(String str) {
        this.cSL = str;
        return this;
    }

    public long getDownloadTime() {
        return this.cSM;
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
