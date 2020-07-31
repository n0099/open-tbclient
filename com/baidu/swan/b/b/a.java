package com.baidu.swan.b.b;

import com.baidu.searchbox.http.callback.ResponseCallback;
import java.util.Map;
import okhttp3.RequestBody;
/* loaded from: classes10.dex */
public class a {
    public ResponseCallback dvE;
    public Map<String, String> headers;
    public RequestBody requestBody;
    public Object tag;
    public String url;
    public String method = "GET";
    public boolean dvF = false;
    public boolean dvG = false;
    public boolean dvH = false;

    public a() {
    }

    public a(String str, ResponseCallback responseCallback) {
        this.url = str;
        this.dvE = responseCallback;
    }

    public a(String str, RequestBody requestBody, ResponseCallback responseCallback) {
        this.url = str;
        this.requestBody = requestBody;
        this.dvE = responseCallback;
    }
}
