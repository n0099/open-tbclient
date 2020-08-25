package com.baidu.swan.a.b;

import com.baidu.searchbox.http.callback.ResponseCallback;
import java.util.Map;
import okhttp3.RequestBody;
/* loaded from: classes4.dex */
public class a {
    public ResponseCallback dEN;
    public Map<String, String> headers;
    public RequestBody requestBody;
    public Object tag;
    public String url;
    public String method = "GET";
    public boolean dEO = false;
    public boolean dEP = false;
    public boolean dEQ = false;

    public a() {
    }

    public a(String str, ResponseCallback responseCallback) {
        this.url = str;
        this.dEN = responseCallback;
    }

    public a(String str, RequestBody requestBody, ResponseCallback responseCallback) {
        this.url = str;
        this.requestBody = requestBody;
        this.dEN = responseCallback;
    }
}
