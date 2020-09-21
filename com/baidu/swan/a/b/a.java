package com.baidu.swan.a.b;

import com.baidu.searchbox.http.callback.ResponseCallback;
import java.util.Map;
import okhttp3.RequestBody;
/* loaded from: classes24.dex */
public class a {
    public ResponseCallback dGV;
    public Map<String, String> headers;
    public RequestBody requestBody;
    public Object tag;
    public String url;
    public String method = "GET";
    public boolean dGW = false;
    public boolean dGX = false;
    public boolean dGY = false;

    public a() {
    }

    public a(String str, ResponseCallback responseCallback) {
        this.url = str;
        this.dGV = responseCallback;
    }

    public a(String str, RequestBody requestBody, ResponseCallback responseCallback) {
        this.url = str;
        this.requestBody = requestBody;
        this.dGV = responseCallback;
    }
}
