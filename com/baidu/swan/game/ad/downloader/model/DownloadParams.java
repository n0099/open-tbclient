package com.baidu.swan.game.ad.downloader.model;

import androidx.annotation.Nullable;
import com.baidu.mobads.container.components.command.XAdRemoteAPKDownloadExtraInfo;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class DownloadParams {

    /* renamed from: a  reason: collision with root package name */
    public String f11633a;

    /* renamed from: b  reason: collision with root package name */
    public String f11634b;

    /* renamed from: c  reason: collision with root package name */
    public String f11635c;

    /* renamed from: d  reason: collision with root package name */
    public String f11636d;

    /* renamed from: e  reason: collision with root package name */
    public String f11637e;

    /* renamed from: f  reason: collision with root package name */
    public long f11638f;

    /* loaded from: classes3.dex */
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

    public DownloadParams(String str, String str2) {
        this.f11633a = str;
        this.f11634b = str2;
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("url", this.f11633a);
            jSONObject.put("name", this.f11634b);
            jSONObject.put("userAgent", this.f11635c);
            jSONObject.put("contentDisposition", this.f11636d);
            jSONObject.put("mimeType", this.f11637e);
            jSONObject.put(XAdRemoteAPKDownloadExtraInfo.CONTENT_LENGTH, this.f11638f);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public DownloadParams(String str, String str2, String str3) {
        this.f11633a = str;
        this.f11634b = str2;
    }
}
