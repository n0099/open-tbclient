package com.baidu.swan.apps.adlanding.download.model;

import com.baidu.swan.apps.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a {
    public static final boolean DEBUG = b.DEBUG;
    public String contentDisposition;
    public long contentLength;
    public String mimeType;
    public String name;
    public String title;
    public String url;
    public String userAgent;

    public a(String str, String str2) {
        this.url = str;
        this.name = str2;
        this.title = "";
    }

    public a(String str, String str2, String str3) {
        this.url = str;
        this.name = str2;
        this.title = str3;
    }

    public JSONObject Vl() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("url", this.url);
            jSONObject.put("name", this.name);
            jSONObject.put("userAgent", this.userAgent);
            jSONObject.put("contentDisposition", this.contentDisposition);
            jSONObject.put("mimeType", this.mimeType);
            jSONObject.put("contentLength", this.contentLength);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return jSONObject;
    }
}
