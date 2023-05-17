package com.baidu.swan.game.ad.downloader.model;

import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class DownloadParams {
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public long f;

    public DownloadParams(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    /* loaded from: classes4.dex */
    public enum SwanAppDownloadType {
        TYPE_QUERY_STATUS("queryStatus"),
        TYPE_START_DOWNLOAD("startDownload"),
        TYPE_PAUSE_DOWNLOAD("pauseDownload"),
        TYPE_CANCEL_DOWNLOAD("cancelDownload"),
        TYPE_RESUME_DOWNLOAD("resumeDownload"),
        TYPE_INSTALL_APP("installApp"),
        TYPE_STOP_SERVICE("stopService"),
        TYPE_OTHER("#");
        
        public String typeName;

        SwanAppDownloadType(String str) {
            this.typeName = str;
        }

        public static SwanAppDownloadType find(@Nullable String str) {
            SwanAppDownloadType[] values;
            for (SwanAppDownloadType swanAppDownloadType : values()) {
                if (swanAppDownloadType.typeName.equals(str)) {
                    return swanAppDownloadType;
                }
            }
            return TYPE_OTHER;
        }

        public String getTypeName() {
            return this.typeName;
        }
    }

    public DownloadParams(String str, String str2, String str3) {
        this.a = str;
        this.b = str2;
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("url", this.a);
            jSONObject.put("name", this.b);
            jSONObject.put(TTDownloadField.TT_USERAGENT, this.c);
            jSONObject.put("contentDisposition", this.d);
            jSONObject.put("mimeType", this.e);
            jSONObject.put("contentLength", this.f);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }
}
