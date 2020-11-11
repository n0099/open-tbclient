package com.baidu.swan.a.b;

import com.baidu.searchbox.http.callback.ResponseCallback;
import java.util.Map;
import okhttp3.RequestBody;
/* loaded from: classes8.dex */
public class a {
    public ResponseCallback ehk;
    public Map<String, String> headers;
    public RequestBody requestBody;
    public Object tag;
    public String url;
    public String method = "GET";
    public boolean ehl = false;
    public boolean ehm = false;
    public boolean ehn = false;

    public a() {
    }

    public a(String str, ResponseCallback responseCallback) {
        this.url = str;
        this.ehk = responseCallback;
    }

    public a(String str, RequestBody requestBody, ResponseCallback responseCallback) {
        this.url = str;
        this.requestBody = requestBody;
        this.ehk = responseCallback;
    }
}
