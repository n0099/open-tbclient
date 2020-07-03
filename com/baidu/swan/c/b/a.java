package com.baidu.swan.c.b;

import com.baidu.searchbox.http.callback.ResponseCallback;
import java.util.Map;
import okhttp3.RequestBody;
/* loaded from: classes11.dex */
public class a {
    public ResponseCallback dpN;
    public Map<String, String> headers;
    public RequestBody requestBody;
    public Object tag;
    public String url;
    public String method = "GET";
    public boolean dpO = false;
    public boolean dpP = false;
    public boolean dpQ = false;

    public a() {
    }

    public a(String str, ResponseCallback responseCallback) {
        this.url = str;
        this.dpN = responseCallback;
    }

    public a(String str, RequestBody requestBody, ResponseCallback responseCallback) {
        this.url = str;
        this.requestBody = requestBody;
        this.dpN = responseCallback;
    }
}
